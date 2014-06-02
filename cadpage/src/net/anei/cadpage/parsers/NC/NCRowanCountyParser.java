package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCRowanCountyParser extends DispatchOSSIParser {
  
  public NCRowanCountyParser() {
    super(CITY_CODES, "ROWAN COUNTY", "NC",
           "FYI? CALL ADDR! ( OPTPLACE INFO+ | X/Z+? CITY XPLACE+? MAP? CH? UNIT )");
  }
  
  @Override
  public String getFilter() {
    return "9300,CAD";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    boolean ok = body.startsWith("CAD:");
    if (!ok) body = "CAD:" + body;
    if (!super.parseMsg(body, data)) return false;
    
    // If we never got a city, assume this is an out of county mutual aid call
    // If we didn't have the CAD: prefix and don't have a city, this is just
    // to chancy to accept
    if (data.strCity.length() == 0) {
      if (!ok) return false;
      data.defCity = "";
    }
    return data.strAddress.length() > 0;
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strCity = field.substring(pt+3).trim();
        field  = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
  }
  
  // Special place field that only triggers if there is no city field
  // further downstream.  This indicates an out of county mutual aid call
  private class OptionalPlaceField extends PlaceField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Only valid if we detect a downstream city field (length <= 4)
      for (int ndx = 0; ; ndx++) {
        String fld = getRelativeField(ndx);
        if (fld.length() == 0) break;
        if (fld.length() <= 4) return false;
      }
      
      // But sometimes the first 4 characters are a city code
      if (data.strCity.length() == 0 && field.length() >= 8 && field.substring(4,8).equals("DIST")) {
        String city = CITY_CODES.getProperty(field.substring(0,4));
        if (city != null) {
          data.strCity = city;
          field = field.substring(4).trim();
        }
      }

      parse(field, data);
      
      // We don't know what county this is, but we now it is not Rowan County
      return true;
    }
      
    
  }
  
  // City field is required, and must be found in table to rule out
  // similar transactions from other locations
  private class MyCityField extends CityField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() > 4) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      super.parse(field, data);
      if (field.equals(data.strCity)) abort();
    }
  }
  
  private static final Pattern CODE_DESC_PTN = Pattern.compile("(\\d{1,2}[A-Z]\\d{1,2}) +(.*)");
  private class MyCrossPlaceField extends Field {
    
    @Override 
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.length() <= 5) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      
      // This is a catchall field that can contains a lot of things
      // See if it is a call code followed by a description
      Matcher match = CODE_DESC_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        data.strSupp = match.group(2);
      }
      
      // See if this looks like a set of cross streets
      else if (isValidAddress(field)) {
        data.strCross = append(data.strCross, " / ", field);
      } 
      
      // Otherwise it is a place field
      else {
        data.strPlace = append(data.strPlace, " - ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO PLACE X";
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new CallField("[^/]+", true);
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("OPTPLACE")) return new OptionalPlaceField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("XPLACE")) return new MyCrossPlaceField();
    if (name.equals("MAP")) return new MapField("\\d{4}", true);
    if (name.equals("CH")) return new ChannelField("OPS.*", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CHGV", "CHINA GROVE",
      "CLEV", "CLEVELAND",
      "CLVD", "CLEVELAND",
      "COOL", "COOLEEMEE",             
      "ESPN", "EAST SPENCER",
      "FATH", "FAITH",
      "GOLD", "GOLD HILL",
      "GRQY", "GRANITE QUARRY",
      "KANN", "KANNAPOLIS",
      "LAND", "LANDIS",
      "MOCK", "MOCKSVILLE",
      "MOOR", "MOORESVILLE",
      "MTUL", "MT ULLA",
      "RICH", "RICHFIELD",
      "ROCK", "ROCKWELL",
      "SALS", "SALISBURY",
      "SPEN", "SPENCER",
      "WOOD", "WOODLEAF"
  }); 
}
