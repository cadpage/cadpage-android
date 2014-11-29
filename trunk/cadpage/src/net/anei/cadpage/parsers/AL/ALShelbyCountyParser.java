package net.anei.cadpage.parsers.AL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Shelby County, AL
 */
public class ALShelbyCountyParser extends FieldProgramParser {
  
  private static final Pattern PREFIX_PTN = Pattern.compile("^(?:NEW - |Arns Alert\n) *", Pattern.CASE_INSENSITIVE);
  
  public ALShelbyCountyParser() {
    super(CITY_CODES, "SHELBY COUNTY", "AL",
           "( ID DATETIME | DATETIME ID ) SRC_UNIT CALL ADDR! APT X NAME");
  }
  
  @Override
  public String getFilter() {
    return "arns@shelby911.org,ARNS Alert";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
  
    Matcher match = PREFIX_PTN.matcher(body);
    if (match.find()) body = body.substring(match.end());
    
    return parseFields(body.split("\n"), data);
  }

  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\d{4}-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }

    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = field.substring(5,7) + '/' + field.substring(8,10) + '/' + field.substring(0,4);
      data.strTime = field.substring(11);
      return true;
    }

    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class SourceUnitField extends Field {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('-');
      if (pt < 0) abort();
      data.strSource = field.substring(0,pt).trim();
      data.strUnit = field.substring(pt+1).trim();
    }

    @Override
    public String getFieldNames() {
      return "SRC UNIT";
    }
  }
  
  private static final Pattern ADDR_SPECIAL_PTN = Pattern.compile("([A-Z]{4} [A-Z]{3}): @(.*?)(?::(.*))?");
  private static final Pattern ADDR_SPECIAL_PTN2 = Pattern.compile("(.*?):(.*?): *(\\d{3}-?\\d{3}-\\d{4})");
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile("(LL\\([-+,0-9\\.:]+\\) *|[^:]+): ?@?(.*)");
  private static final Pattern ADDR_APT_PTN = Pattern.compile("[ ,:]+(?:(?:APT|RM|ROOM|UNIT|SUITE?)(?![A-Z]) *([^ ]+(?: +FLR? *[^ ]+)?)|((?:LOT|FL) *[^ ]+)|(?<=,) *(\\d+[A-Z]?))$");
  private static final Pattern ADDR_UNIT_PTN = Pattern.compile("^[A-Z]{2}FD\\b");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Check special city src: @place:address pattern
      Matcher match = ADDR_SPECIAL_PTN.matcher(field);
      if (match.matches()) {
        data.strCity = convertCodes(match.group(1), CITY_CODES);
        String place = match.group(2).trim();
        String addr = getOptGroup(match.group(3));
        match = ADDR_UNIT_PTN.matcher(place);
        if (match.find()) {
          data.strUnit = match.group();
          place = place.substring(match.end()).trim();
        }
        if (addr.length() == 0) {
          addr = place;
          place = "";
        }
        field = addr;
        if (place.endsWith("FD")) {
          if (data.strSource.length() == 0) data.strSource = place;
        } else {
          data.strPlace = place;
        }
      }

      else {
        
        // Check for special case Address:Place:Phone
        match = ADDR_SPECIAL_PTN2.matcher(field);
        if (match.matches()) {
          field = match.group(1).trim();
          data.strPlace = match.group(2).trim();
          data.strPhone = match.group(3);
        }
        
        // OK, things look "normal"
        // look for trailing place name
        
        // Check for trailing apt
        match = ADDR_APT_PTN.matcher(field);
        if (match.find()) {
          String apt = match.group(1);
          if (apt == null) apt = match.group(2);
          if (apt == null) apt = match.group(3);
          data.strApt = apt;
          field = field.substring(0,match.start()).trim();
        }
        
        match = ADDR_PLACE_PTN.matcher(field);
        if (match.find()) {
          field =  match.group(1).trim();
          String place = match.group(2).trim();
          if (NUMERIC.matcher(place).matches()) {
            data.strApt = append(place, "-", data.strApt);
          } else {
            data.strPlace = place;
          }
        }
        
        // Check for trailing apt (again)
        match = ADDR_APT_PTN.matcher(field);
        if (match.find()) {
          if (data.strApt.length() == 0) {
            String apt = match.group(1);
            if (apt == null) apt = match.group(2);
            if (apt == null) apt = match.group(3);
            data.strApt = append(apt, "-", data.strApt);
          }
          field = field.substring(0,match.start()).trim();
        }
      }

      // Process city code and something that we are ignoring
      String saveCity = data.strCity;
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
      if (saveCity.length() > 0) data.strCity = saveCity;
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY APT PLACE PHONE";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains("::")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace("::", "/");
      if (field.endsWith("/")) {
        field = field.substring(0,field.length()-1).trim();
      }
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TYPE")) return new SkipField("Cad.*", true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("SRC_UNIT")) return new SourceUnitField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X"))  return new MyCrossField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String sAddress) {
    return sAddress.replace("EGG AND BUTTER", "EGG_AND_BUTTER");
  }

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("EGG_AND_BUTTER", "EGG AND BUTTER");
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      
      "ALA",      "ALABASTER",
      "ALAB ALA", "ALABASTER",
      "CALE ALA", "ALABASTER",
      "CALJ ALA", "ALABASTER",
      "SAGN ALA", "ALABASTER",
      "WSHE ALA", "ALABASTER",
      
      "BFD",      "BRIERFIELD",
      "BFLD BFD", "BRIERFIELD",
      "BRIR BFD", "BRIERFIELD",
      
      "BHM",       "BIRMINGHAM",
      "CVAL BHM",  "BIRMINGHAM",

      "CAL",      "CALERA",
      "CALE CAL", "CALERA",
      "CALJ CAL", "CALERA",
      "SUMH CAL", "CALERA",

      "COL",      "COLUMBIANA",
      "COLU COL", "COLUMBIANA",
      "FOUR COL", "COLUMBIANA",
      "KING COL", "COLUMBIANA",
      "NONE COL", "COLUMBIANA",
      "SAGN COL", "COLUMBIANA",
      "SUMH COL", "COLUMBIANA",
      
      "BMH",      "BIRMINGHAM",
      "CVAL BMH", "BIRMINGHAM",
      
      "HRP",      "HARPERSVILLE",
      "HARP HRP", "HARPERSVILLE",
      "WESJ HRP", "WESTOVER",
      "WILJ HRP", "HARPERSVILLE",
      
      "ALAB MAY", "ALABASTER",

      "MON",      "MONTEVALLO",
      "ALMT MON", "MONTEVALLO",
      "CALE MON", "MONTEVALLO",
      "CALJ MON", "MONTEVALLO",
      "DRYV MON", "MONTEVALLO",
      "MONT MON", "MONTEVALLO",
      "PEAR MON", "MONTEVALLO",
      "UOFM MON", "MONTEVALLO",
      "WILT MON", "WILTON",
      "WSHE MON", "MONTEVALLO",
      
      "HEL",      "HELENA",
      "HELN HEL", "HELENA",
      
      "PEAR MAY", "MONTEVALLO",
      
      "SHE",      "SHELBY",
      "SHEL SHE", "SHELBY",

      "STE",      "STERRETT",
      "CHEL STE", "STERRETT",
      "WESJ STE", "WESTOVER",
      "WEST STE", "WESTOVER",
      
      "WIL",      "WILSONVILLE",
      "FOUR WIL", "WILSONVILLE",
      "WESJ WIL", "WILSONVILLE",
      "WILJ WIL", "WILSONVILLE",
      "WILS WIL", "WILSONVILLE"
      
//      "NONE", "",
//      "PELH", "PELHAM",
//      "SAGN", "SAGINAW",
//      "SHEL", "SHELBY",
//      "SUMH", "", 
      
  });
}
