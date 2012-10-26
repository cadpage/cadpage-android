package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCRowanCountyParser extends DispatchOSSIParser {
  
  public NCRowanCountyParser() {
    super(CITY_CODES, "ROWAN COUNTY", "NC",
           "FYI? CALL ADDR ( OPTPLACE INFO+ | X/Z+? CITY XPLACE+? UNIT? CH )");
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
      if (checkAddress(field) > 0) {
        data.strCross = append(data.strCross, " / ", field);
      } else {
        data.strPlace = append(data.strPlace, " / ", field);
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE X";
    }
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("FYI")) return new SkipField("FYI:|UPDATE:");
    if (name.equals("OPTPLACE")) return new OptionalPlaceField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("XPLACE")) return new MyCrossPlaceField();
    if (name.equals("UNIT")) return new UnitField("\\d{4}", true);
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CHGV", "CHINA GROVE",
      "CLEV", "CLEVELAND",
      "CLVD", "CLEVELAND",
      "ESPN", "EAST SPENCER",
      "FATH", "FAITH",
      "GOLD", "GOLD HILL",
      "GRQY", "GRANITE QUARRY",
      "KANN", "KANNAPOLIS",
      "LAND", "LANDIS",
      "MOCK", "MOCKSVILLE",
      "MOOR", "MOORESVILLE",
      "MTUL", "MT ULLA",
      "ROCK", "ROCKWELL",
      "SALS", "SALISBURY",
      "SPEN", "SPENCER",
      "WOOD", "WOODLEAF"
  }); 
}
