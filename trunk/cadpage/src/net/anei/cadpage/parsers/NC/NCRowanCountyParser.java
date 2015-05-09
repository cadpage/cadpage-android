package net.anei.cadpage.parsers.NC;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class NCRowanCountyParser extends DispatchOSSIParser {
  
  public NCRowanCountyParser() {
    super(CITY_CODES, "ROWAN COUNTY", "NC",
           "FYI? CALL ADDR! ( OPTPLACE | X/Z+? CITY XPLACE+? MAP_CH_UNIT MAP_CH_UNIT+? ) INFO+");
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
    
    if (data.strCity.equals("OUT OF COUNTY")) {
      data.defCity = "";
    }

    return data.strAddress.length() > 0;
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equals("OUT OF COUNTY")) return "";
    return city;
  }
  
  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("OPTPLACE")) return new MyOptionalPlaceField();
    if (name.equals("CITY")) return new MyCityField();
    if (name.equals("XPLACE")) return new MyCrossPlaceField();
    if (name.equals("MAP_CH_UNIT")) return new MyMapChannelUnitField();
    if (name.equals("ID")) return new IdField("\\d{8}");
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  private static final Pattern BAD_CALL_PTN = Pattern.compile("[^ ]/[^ ]+/[^ ]|^[A-Z]\\d+[A-Z]?-");
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (BAD_CALL_PTN.matcher(field).find()) abort();
      super.parse(field, data);
    }
  }

  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*)(?: - |~)(.*)");
  private static final Pattern BAD_CITY_PTN = Pattern.compile("[NSEW]|[NS][EW]");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = ADDR_CITY_PTN.matcher(field);
      if (match.matches()) {
        field = match.group(1).trim();
        data.strCity = match.group(2).trim();
        
        // Cities that look like directions is a feature of Davidson County alerts
        if (BAD_CITY_PTN.matcher(data.strCity).matches()) abort();
        if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  // Special place field that only triggers if there is no city field
  // further downstream.  This indicates an out of county mutual aid call
  private class MyOptionalPlaceField extends MyPlaceField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      
      // Only valid if there is no downstream city field
      for (int ndx = 0; ; ndx++) {
        String fld = getRelativeField(ndx);
        if (fld.length() == 0) break;
        if (fld.length() <= 4) {
          if (CITY_CODES.getProperty(fld) != null) return false;
        }
      }
      
      // But sometimes the first 4 characters are a city code
      if (data.strCity.length() == 0 && field.length() >= 4) {
        String city = CITY_CODES.getProperty(field.substring(0,4));
        if (city != null) {
          data.strCity = city;
          field = field.substring(4).trim();
        }
      }
      
      if (ID_PTN.matcher(field).matches()) {
        data.strCallId = field;
      } else {
        parse(field, data);
      }
      
      // We don't know what county this is, but we now it is not Rowan County
      return true;
    }
      
    @Override
    public String getFieldNames() {
      return "CITY " + super.getFieldNames();
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
  private static final Pattern APT_PTN = Pattern.compile("(?:APT|ROOM|LOT) *(.*)");
  private class MyCrossPlaceField extends MyPlaceField {
    
    @Override
    public void parse(String field, Data data) {
      
      // This is a catchall field that can contains a lot of things
      // See if it is a call code followed by a description
      Matcher match = CODE_DESC_PTN.matcher(field);
      if (match.matches()) {
        data.strCode = match.group(1);
        data.strSupp = match.group(2);
        return;
      }
      
      // See if is an apt/lot number
      match = APT_PTN.matcher(field);
      if (match.matches()) {
        data.strApt = append(data.strApt, "-", match.group(1));
        return;
      }
      
      // See if this looks like a set of cross streets
      if (field.endsWith("CREEK") || field.endsWith("XING") || isValidAddress(field)) {
        data.strCross = append(data.strCross, " / ", field);
        return;
      } 
      
      // Otherwise it is a place field
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "CODE INFO " + super.getFieldNames() + " X";
    }
  }
  
  private static final Pattern MAP_PTN = Pattern.compile("\\d{3,4}");
  private static final Pattern CHANNEL_PTN = Pattern.compile("OPS.*");
  private static final Pattern UNIT_PTN = Pattern.compile("[A-Z]+\\d+[A-Z]?|\\d+[A-Z]+\\d|[A-z0-9]+,[A-Z0-9,]+|[A-Z]{2}|DCC");
  private static final Pattern ID_PTN = Pattern.compile("\\d{8}");
  private class MyMapChannelUnitField extends Field {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strMap.length() == 0) {
        Matcher match = MAP_PTN.matcher(field);
        if (match.matches()) {
          data.strMap = field;
          return true;
        }
      }
      
      if (data.strChannel.length() == 0) {
        Matcher match = CHANNEL_PTN.matcher(field);
        if (match.matches()) {
          data.strChannel = field;
          return true;
        }
      }
      
      if (data.strUnit.length() == 0) {
        Matcher match = UNIT_PTN.matcher(field);
        if (match.matches()) {
          data.strUnit = field;
          return true;
        }
      }
      
      if (ID_PTN.matcher(field).matches()) {
        data.strCallId = field;
        return true;
      }
      
      if (field.startsWith("**")) {
        data.strSupp = field;
        return true;
      }
      
      return false;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }

    @Override
    public String getFieldNames() {
      return "MAP CH UNIT ID INFO";
    }
  }
  
  /**
   * Handles the common place field processinging common to both the MyOptionalPlaceField and
   * MyCrossPlaceField classes
   */
  private static final Pattern PLACE_PTN = Pattern.compile("(.*)\\(S\\)(.*)\\(N\\)(.*)");
  private abstract class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = PLACE_PTN.matcher(field);
      if (match.matches()) {
        for (int ii = 1; ii<=3; ii++) {
          processPart(match.group(ii).trim(), data);
        }
      }
      
      else {
        processPart(field, data);
      }
    }

    private void processPart(String part, Data data) {
      if (part.length() == 0) return;
      
      boolean apt = false;
      
      Matcher match = APT_PTN.matcher(part);
      if (match.matches()) {
        apt = true;
        part = match.group(1);
      }
      
      else if (part.length() <= 4 && NUMERIC.matcher(part).matches()) {
        apt = true;
      }
      
      if (apt) {
        if (!part.equals(data.strApt)) data.strApt = append(data.strApt, "-", part);
      }
      
      else if (data.strPlace.length() == 0) {
        data.strPlace = part;
      }
      
      else if (!part.equals(data.strPlace)) {
        if (part.length() > 5 || part.contains(" ") || part.equals("MM")) {
          data.strPlace = append(data.strPlace, " - ", part);
        } else {
          data.strApt = append(data.strApt, "-", part);
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE APT";
    }
  }
  
  private static final Pattern INFO_CHANNEL_PTN = Pattern.compile("Radio Channel: *(.*)");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_CHANNEL_PTN.matcher(field);
      if (match.matches()) {
        data.strChannel = match.group(1);
        return;
      }
      super.parse(field, data);
    }
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
      "KAN",  "KANNAPOLIS",
      "KANN", "KANNAPOLIS",
      "LAND", "LANDIS",
      "MOCK", "MOCKSVILLE",
      "MOOR", "MOORESVILLE",
      "MTUL", "MT ULLA",
      "RICH", "RICHFIELD",
      "ROCK", "ROCKWELL",
      "SALS", "SALISBURY",
      "SPEN", "SPENCER",
      "WOOD", "WOODLEAF",
      
      // Cabarrus County, NC
      "CON",  "CONCORD",
      
      // Out of County
      "OOC",  "OUT OF COUNTY"
  }); 
}
