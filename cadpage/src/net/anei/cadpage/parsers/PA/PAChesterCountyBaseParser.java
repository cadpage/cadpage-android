package net.anei.cadpage.parsers.PA;
import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA7BaseParser;

public class PAChesterCountyBaseParser extends DispatchA7BaseParser {
  
  public PAChesterCountyBaseParser(String programStr) {
    super(0, CITY_LIST, CITY_CODES, "CHESTER COUNTY", "PA", programStr);
  }
  
  @Override
  protected boolean parseFields(String[] fields, Data data) {
    if (!super.parseFields(fields, data)) return false;
    if (data.strCity.equals("NEW CASTLE COUNTY")) data.strState = "DE";
    return true;
  }
  
  @Override
  public String getProgram() {
    return super.getProgram().replace("CITY", "CITY ST");
  }
  
  // ADDRPL: address - place
  protected class AddressPlaceField extends AddressField {
    
    @Override
    public void parse(String field, Data data) {
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        data.strCity = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      pt = field.indexOf(" - ");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR PLACE CITY";
    }
  }
  
  // ADDRCITY: address, citycode
  protected class AddressCityField extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains(",")) return false;
      parseChesterAddress(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  // ADDRCITY2: address, city
  protected class AddressCity2Field extends AddressField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      int pt = field.indexOf(',');
      if (pt < 0) return false;
      parseAddress(field.substring(0,pt).trim(), data);
      data.strCity = field.substring(pt+1).trim();
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " CITY";
    }
  }
  
  protected class CityField extends DispatchA7BaseParser.CityField {
    @Override
    public void parse(String field, Data data) {
      
      // DOn't overwrite previous contents if this field is empty
      if (field.length() > 0) super.parse(field, data);
    }
    
  }
  
  // X2: must contain &
  protected class Cross2Field extends CrossField {
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("&")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public String getFieldNames() {
      return "X";
    }
  }
  
  // APT: must start with APT or be <= 4 characters
  protected class BaseAptField extends AptField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("APT ")) {
        field = field.substring(4).trim();
      } else if (field.length() > 4) return false;
      
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("-")) field = field.substring(1).trim();
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("APT ")) {
        field = field.substring(4).trim();
      }
      if (field.length() > 6) data.strPlace = field;
      else super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE";
    }
  }
  
  // PLACE: ignore if len <= 1
  protected class BasePlaceField extends  PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (field.length() > 1) {
        super.parse(field, data);
      }
    }
  }
  
  private static final Pattern DATE_PATTERN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)?");
  private class BaseDateField extends DateField {
    public BaseDateField() {
      setPattern(DATE_PATTERN, true);
    }
  }
  
  private static final Pattern TIME_PATTERN = Pattern.compile("\\d\\d:\\d\\d(?::\\d\\d)?");
  private class BaseTimeField extends TimeField {
    public BaseTimeField() {
      setPattern(TIME_PATTERN, true);
    }
  }
  
  protected class BaseDateTimeField extends DateTimeField {
    
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!isLastField()) {
        if (TIME_PATTERN.matcher(field).matches()) {
          data.strTime = field;
          return true;
        }
        if (DATE_PATTERN.matcher(field).matches()) {
          data.strDate = field;
          return true;
        }
        return false;
      }
      
      else {
        String tmp = field.replaceAll("\\d", "N");
        return "NN/NN/NNNN".startsWith(tmp) ||
                "NN:NN:NN".startsWith(tmp);
      }
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRPL")) return new AddressPlaceField();
    if (name.equals("ADDRCITY")) return new AddressCityField();
    if (name.equals("ADDRCITY2")) return new AddressCity2Field();
    if (name.equals("CITY")) return new CityField();
    if (name.equals("X2")) return new Cross2Field();
    if (name.equals("APT")) return new BaseAptField();
    if (name.equals("PLACE")) return new BasePlaceField();
    if (name.equals("DATE")) return new BaseDateField();
    if (name.equals("TIME")) return new BaseTimeField();
    if (name.equals("DATETIME")) return new BaseDateTimeField();
    if (name.equals("EMPTY")) return new EmptyField();
    return super.getField(name);
  }

  public void parseChesterAddress(String field, Data data) {
    parseAddressA7(field, data);
  }
  
  public String convertCityCode(String city) {
    return convertCodes(city, CITY_CODES);
  }
  
  /**
   * Check if this is variant G message.  These are long complicated, and often
   * pass for another variant, so we check here to eliminate them early
   * @param body message body
   * @return true if this is a variant G message
   */
  public boolean isVariantGMsg(String body) {
    return VARIANT_G_MARKER.matcher(body).find();
  }
  private static final Pattern VARIANT_G_MARKER = Pattern.compile("^(?:\\([A-Z]\\) *)?Inc History");
  
  private static final String[] CITY_LIST = new String[]{
    /* 00 */ "",
    /* 01 */ "WEST CHESTER",
    /* 02 */ "MALVERN",
    /* 03 */ "KENNETT SQUARE",
    /* 04 */ "AVONDALE",
    /* 05 */ "WEST GROVE",
    /* 06 */ "OXFORD",
    /* 07 */ "ATGLEN",
    /* 08 */ "PARKESBURG",
    /* 09 */ "SOUTH COATESVILLE",
    /* 10 */ "",
    /* 11 */ "DOWNINGTOWN",
    /* 12 */ "HONEY BROOK",
    /* 13 */ "",
    /* 14 */ "SPRING CITY",
    /* 15 */ "PHOENIXVILLE",
    /* 16 */ "COATESVILLE",
    /* 17 */ "NORTH COVENTRY TWP",
    /* 18 */ "EAST COVENTRY TWP",
    /* 19 */ "",
    /* 20 */ "POTTSTOWN",
    /* 21 */ "EAST VINCENT TWP",
    /* 22 */ "",
    /* 23 */ "",
    /* 24 */ "",
    /* 25 */ "WEST VINCENT TWP",
    /* 26 */ "EAST PIKELAND TWP",
    /* 27 */ "SCHUYLKILL TWP",
    /* 28 */ "WEST CALN TWP",
    /* 29 */ "WEST BRANDYWINE TWP",
    /* 30 */ "EAST BRANDYWINE TWP",   // or BRANDYWINE REGIONAL POLICE??
    /* 31 */ "",
    /* 32 */ "UPPER UWCHLAN TWP",
    /* 33 */ "UWCHLAN TWP",
    /* 34 */ "WEST PIKELAND TWP",
    /* 35 */ "CHARLESTOWN TWP",
    /* 36 */ "WEST SADSBURY TWP",
    /* 37 */ "SADSBURY TWP",
    /* 38 */ "VALLEY TWP",
    /* 39 */ "CALN TWP",
    /* 40 */ "",
    /* 41 */ "WEST WHITELAND TWP",
    /* 42 */ "EAST WHITELAND TWP",
    /* 43 */ "TREDYFFRIN TWP",
    /* 44 */ "WEST FALLOWFIELD TWP",
    /* 45 */ "HIGHLAND TWP",
    /* 46 */ "",
    /* 47 */ "EAST FALLOWFIELD TWP",
    /* 48 */ "",
    /* 49 */ "NEWLIN TWP",
    /* 50 */ "",
    /* 51 */ "",
    /* 52 */ "WEST GOSHEN TWP",
    /* 53 */ "EAST GOSHEN TWP",
    /* 54 */ "WILLISTOWN TWP",
    /* 55 */ "EASTTOWN TWP",
    /* 56 */ "LOWER OXFORD TWP",
    /* 57 */ "",
    /* 58 */ "PENN TWP",
    /* 59 */ "LONDON GROVE TWP",
    /* 60 */ "NEW GARDEN TWP",
    /* 61 */ "EAST MARLBOROUGH TWP",
    /* 62 */ "KENNETT TWP",
    /* 63 */ "",
    /* 64 */ "PENNSBURY TWP",
    /* 65 */ "BIRMINGHAM TWP",
    /* 66 */ "",
    /* 67 */ "WESTTOWN TWP",
    /* 68 */ "WEST NOTTINGHAM TWP",
    /* 69 */ "EAST NOTTINGHAM TWP",
    /* 70 */ "",
    /* 71 */ "NEW LONDON TWP",
    /* 72 */ "FRANKLIN TWP",
    /* 73 */ "LANDENBERG",
    /* 74 */ "",
    /* 75 */ "WEST CHESTER",    // WEST CHESTER UNIVERSITY PD 
    /* 76 */ "OXFORD",          // LINCOLN UNIVERSITY 
    /* 77 */ "COATESVILLE",     // COATESVILLE VA MEDICAL CENTER POLICE
    /* 78 */ "WEST CHESTER",    // WEST CHESTER AREA SCHOOL DISTRICT SECURITY
    /* 79 */ "COATESVILLE",     // COATESVILLE AREA SCHOOL DISTRICT POLICE
    /* 80 */ "",
    /* 81 */ "",                // PENNSYLVANIA FISH AND BOAT COMMISSION
    /* 82 */ "DOWNINGTON",      // MARSH CREEK STATE PARK RANGERS
    /* 83 */ "POTTSDOWN",       // WARWICK COUNTY PARK
    /* 84 */ "COATESVILLE",     // HIBERNIA COUNTY PARK
    /* 85 */ "NOTTINGHAM",      // NOTTINGHAM COUNTY PARK
    /* 86 */ "GLENMOORE",        // SPRINGTON MANOR COUNTY PARK
    /* 87 */ "",
    /* 88 */ "NEW CASTLE COUNTY"
  };
  
  protected static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AVNDAL", "AVONDALE",
      "DNGTWN", "DOWNINGTOWN",
      "CALN",   "CALN TWP",
      "CHARLS", "CHARLESTOWN TWP",
      "COATVL", "COATESVILLE",
      "EBRAND", "EAST BRANDYWINE TWP",
      "EFALLO", "EAST FALLOWFIELD TWP",
      "EGOSHN", "EAST GOSHEN TWP",
      "EMARLB", "EAST MARLBOROUGH TWP",
      "ENOTT",  "EAST NOTTINGHAM TWP",
      "EPIKEL", "EAST PIKELAND TWP",
      "EWHITE", "EAST WHITELAND TWP",
      "FRNKLN", "FRANKLIN TWP",
      "KNTSQR", "KENNETT SQUARE",
      "KNTTWP", "KENNETT TWP",
      "LDNBRT", "LANDENBERG",
      "LGROVE", "LONDON GROVE TWP",
      "LONDER", "LONDONERRY TWP",
      "LWROXF", "LOWER OXFORD TWP",
      "MALVRN", "MALVERN",
      "NCC",    "NEW CASTLE COUNTY",
      "NEWLON", "NEW LONDON TWP",
      "NGARDN", "NEW GARDEN TWP",
      "OXFORD", "OXFORD",
      "PENN",   "PENN TWP",
      "PHNXVL", "PHOENIXVILLE",
      "POCOPS", "POCOPSON TWP",
      "PNSBRY", "PENNSBURY TWP",
      "TREDYF", "TREDYFFRIN TWP",
      "UWCHLN", "UWCHLAN TWP",
      "VALLEY", "VALLEY TWP",
      "WESTWN", "WESTTOWN TWP",
      "WFALLO", "WEST FALLOWFIELD TWP",
      "WGOSHN", "WEST GOSHEN TWP",
      "WGROVE", "WEST GROVE",
      "WWHITE", "WEST WHITELAND TWP",
      "WILLIS", "WILLISTOWN TWP",
      "WMARLB", "WEST MARLBOROUGH TWP",
      "WNOTT",  "WEST NOTTINGHAM TWP",
      "WPIKEL", "WEST PIKELAND TWP",

      // Mongtomery county
      "UPPER PROV", "UPPER PROVIDENCE TWP",

  });
} 
