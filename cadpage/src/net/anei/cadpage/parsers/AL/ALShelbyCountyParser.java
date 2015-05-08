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
    super("SHELBY COUNTY", "AL",
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
  private static final Pattern ADDR_CITY_PTN = Pattern.compile("(.*?) *\\b([A-Z][A-Z0-9]{3}) ([A-Z]{3})");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Check special city src: @place:address pattern
      Matcher match = ADDR_SPECIAL_PTN.matcher(field);
      if (match.matches()) {
        String city = match.group(1);
        String city2 = stripCity(city, data);
        if (city2.length() > 0) data.strCity = city;
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
      
      // Check for a comma separated Apt, which may include it's own city name
      if (!field.startsWith("LL")) {
        int pt = field.lastIndexOf(',');
        if (pt >= 0) {
          String apt = field.substring(pt+1).trim();
          apt = stripFieldStart(apt, "#");
          field = field.substring(0,pt).trim();
          apt = stripCity(apt, data);
          if (data.strApt.length() == 0) {
            data.strApt = apt;
          } else {
            if (!apt.equals(data.strApt)) {
              if (!Pattern.compile("\\b" + apt + "\\b").matcher(data.strApt).find()) {
                data.strApt = append(apt,  "-",  data.strApt);
              }
            }
          }
        }
      }

      // Process city code and something that we are ignoring
      field = stripCity(field, data);
      parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, field, data);
    }
    
    private String stripCity(String field, Data data) {
      Matcher match = ADDR_CITY_PTN.matcher(field);
      if (match.matches()) {
        String city = CITY_CODES.getProperty(match.group(3));
        if (city == null || city.endsWith(" COUNTY")) {
          String subcity = CITY_SUBCODES.getProperty(match.group(2));
          if (subcity != null) city = subcity;
        }
        if (city != null) {
          data.strCity = city;
          field = match.group(1);
        }
      }
      return field;
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
    sAddress = sAddress.replace("EGG AND BUTTER", "EGG_AND_BUTTER");
    sAddress = CLFS_PTN.matcher(sAddress).replaceAll("CLIFFS");
    return super.adjustMapAddress(sAddress);
  }
  private static final Pattern CLFS_PTN = Pattern.compile("\\bCLFS\\b", Pattern.CASE_INSENSITIVE);

  @Override
  public String postAdjustMapAddress(String sAddress) {
    return sAddress.replace("EGG_AND_BUTTER", "EGG AND BUTTER");
  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equals("CAHABA VALLEY")) city = "BIRMINGHAM";
    return city;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALA", "ALABASTER",
      "BES", "BESSEMER",
      "BFD", "BRIERFIELD",
      "BIB", "BIBB COUNTY",      
      "BHM", "BIRMINGHAM",
      "CAL", "CALERA",
      "CHL", "CHELSEA",
      "COL", "COLUMBIANA",
      "HEL", "HELENA",
      "HOV", "HOOVER",
      "HRP", "HARPERSVILLE",
      "JEF", "JEFFERSON COUNTY",
      "LEE", "LEEDS",
      "MAY", "MAYLENE",
      "MON", "MONTEVALLO",
      "PEH", "PELHAM",
      "SAG", "SAGINAW",
      "SHE", "SHELBY",
      "STE", "STERRETT",
      "VES", "VESTAVIA HILLS",
      "VAN", "VANDIVER",
      "VIN", "VINCENT",
      "WES", "WESTOVER",
      "WIL", "WILSONVILLE",
  });
  
  private static final Properties CITY_SUBCODES = buildCodeTable(new String[]{
      "ALAB", "ALABASTER",
      "BFLD", "BRIERFIELD",
      "BHAM", "BIRMINGHAM",
      "CALE", "CALERA",
      "CALJ", "CALERA",
      "CHEJ", "CHELSEA",
      "CHEL", "CHELSEA",
      "COLU", "COLUMBIANA",
      "CVAL", "CAHABA VALLEY",
      "DUNN", "DUNNAVANT",
      "HARJ", "HARPERSVILLE",
      "HARP", "HARPERSVILLE",
      "HELN", "HELENA",
      "HOOV", "HOOVER",
      "LEED", "LEEDS",
      "MONT", "MONTEVALLO",
      "PELH", "PELHAM",
      "SAGN", "SAGINAW",
      "SHEL", "SHELBY",
      "VAND", "VANDIVER",
      "VEST", "VESTAVIA HILLS",
      "VINC", "VINCENT",
      "VINJ", "VINCENT",
      "WEST", "WESTOVER",
      "WILJ", "WILSONVILLE",
      "WILS", "WILSONVILLE"
  });
}
