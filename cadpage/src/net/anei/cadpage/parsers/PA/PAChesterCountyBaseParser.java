package net.anei.cadpage.parsers.PA;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

public class PAChesterCountyBaseParser extends FieldProgramParser {
  
  public PAChesterCountyBaseParser(String programStr) {
    super(CITY_CODES, "CHESTER COUNTY", "PA", programStr);
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
      return parseChesterAddress(field, data);
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!parseChesterAddress(field, data)) abort();
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
      if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      if (field.startsWith("APT ")) {
        field = field.substring(4).trim();
      }
      super.parse(field, data);
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
  
  private class BaseDateField extends DateField {
    public BaseDateField() {
      super("\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)?", true);
    }
  }
  
  private class BaseTimeField extends TimeField {
    public BaseTimeField() {
      super("\\d\\d:\\d\\d(?::\\d\\d)?", true);
    }
  }
  
  private static final Pattern DATE_PATTERN = Pattern.compile("\\d\\d/\\d\\d/\\d\\d(?:\\d\\d)?");
  private static final Pattern TIME_PATTERN = Pattern.compile("\\d\\d:\\d\\d(?::\\d\\d)?");
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
  
  // EMPTY: must be empty
  protected class EmptyField extends SkipField {

    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      return field.length() == 0;
    }
  }
  
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRPL")) return new AddressPlaceField();
    if (name.equals("ADDRCITY")) return new AddressCityField();
    if (name.equals("ADDRCITY2")) return new AddressCity2Field();
    if (name.equals("X2")) return new Cross2Field();
    if (name.equals("APT")) return new BaseAptField();
    if (name.equals("PLACE")) return new BasePlaceField();
    if (name.equals("DATE")) return new BaseDateField();
    if (name.equals("TIME")) return new BaseTimeField();
    if (name.equals("DATETIME")) return new BaseDateTimeField();
    if (name.equals("EMPTY")) return new EmptyField();
    return super.getField(name);
  }

  private static final Pattern ADDR_PTN = Pattern.compile("(.*), *(\\d\\d)");
  public boolean parseChesterAddress(String field, Data data) {
    Matcher match = ADDR_PTN.matcher(field);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    
    int ndx = Integer.parseInt(match.group(2));
    if (ndx < CITY_LIST.length) data.strCity = CITY_LIST[ndx];
    return true;
  }
  
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
    /* 16 */ "COATESVILLE CITY",
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
    /* 30 */ "",                // BRANDYWINE REGIONAL POLICE
    /* 31 */ "",
    /* 32 */ "UPPER UWCHLAN TWP",
    /* 33 */ "UWCHLAN TWP",
    /* 34 */ "WEST PIKELAND TWP",
    /* 35 */ "",
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
    /* 56 */ "",
    /* 57 */ "",
    /* 58 */ "",
    /* 59 */ "",
    /* 60 */ "NEW GARDEN TWP",
    /* 61 */ "EAST MARLBOROUGH TWP",
    /* 62 */ "KENNETT TWP",
    /* 63 */ "",
    /* 64 */ "",
    /* 65 */ "BIRMINGHAM TWP",
    /* 66 */ "",
    /* 67 */ "WESTTOWN TWP",
    /* 68 */ "WEST NOTTINGHAM TWP",
    /* 69 */ "",
    /* 70 */ "",
    /* 71 */ "",
    /* 72 */ "",
    /* 73 */ "",
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
    /* 86 */ "GLENMOORE"        // SPRINGTON MANOR COUNTY PARK
  };
  
  protected static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AVNDAL", "AVONDALE",
      "DNGTWN", "DOWNINGTOWN",
      "CALN",   "CALN TWP",
      "EGOSHN", "EAST GOSHEN TWP",
      "EMARLB", "EAST MARLBOROUGH TWP",
      "ENOTT",  "EAST NOTINGHAM TWP",
      "FRNKLN", "FRANKLIN TWP",
      "KNTSQR", "KENNETT SQUARE",
      "KNTTWP", "KENNETT TWP",
      "LDNBRT", "LANDENBERG",
      "LGROVE", "LONDON GROVE TWP",
      "LONDER", "LONDONERRY TWP",
      "LWROXF", "LOWER OXFORD TWP",
      "NEWLON", "NEW LONDON TWP",
      "NGARDN", "NEW GARDEN TWP",
      "OXFORD", "OXFORD",
      "PENN",   "PENN TWP",
      "POCOPS", "POCOPSON TWP",
      "PNSBRY", "",
      "WESTWN", "WESTTOWN TWP",
      "WFALLO", "WEST FALLOWFIELD TWP",
      "WGOSHN", "WEST GOSHEN TWP",
      "WGROVE", "WEST GROVE",
      "WILLIS", "WILLISTOWN TWP",
      "WMARLB", "WEST MARLBOROUGH TWP"
  });
} 
