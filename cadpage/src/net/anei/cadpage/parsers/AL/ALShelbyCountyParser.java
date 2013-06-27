package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Shelby County, AL
 */
public class ALShelbyCountyParser extends FieldProgramParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(?:SHELBY(?: ?911)? |SC911-)?ARNS ALERT");
  private static final Pattern MARKER_PTN = Pattern.compile("^(?:SHELBY |SC911-)?ARNS ALERT / ");
  
  public ALShelbyCountyParser() {
    super("SHELBY COUNTY", "AL",
           "( TYPE DATETIME ID SRC CALL ADDR3 ( X NAME | ) UNIT! | DATETIME ID SRC CALL PLACE ADDR! ADDR2? INFO+ )");
  }
  
  @Override
  public String getFilter() {
    return "arns@shelby911.org,arns@shelbyal.com,1410";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    do {
      if (SUBJECT_PTN.matcher(subject).matches()) break;

      Matcher  match = MARKER_PTN.matcher(body);
      if(match.find()) {
        body = body.substring(match.end()).trim();
        break;
      }
      
      return false;
    } while (false);
    
    // Check for run report
    if (body.startsWith("CadCloseEvent\n")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body.substring(15).trim();
      return true;
    }
    
    if (!parseFields(body.split("\n"), 6, data)) return false;
    if (data.strAddress.length() == 0) {
      parseAddress(data.strCross, data);
      data.strCross = "";
    }
    return true;
  }

  private static final Pattern DATE_TIME_PTN1 = Pattern.compile("\\d{4}-\\d\\d-\\d\\dT\\d\\d:\\d\\d:\\d\\dZ");
  private static final DateFormat DATE_TIME_FMT1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
  
  private static final Pattern DATE_TIME_PTN2 = Pattern.compile("[A-Z][a-z]{2} \\d\\d? \\d{4} +\\d\\d?:\\d\\d[AP]M");
  private static final DateFormat DATE_TIME_FMT2 = new SimpleDateFormat("MMM dd yyyy hh:mmaa");
  
  private static final Pattern DATE_TIME_PTN3 = Pattern.compile("\\d\\d?/\\d\\d?/\\d{4} \\d\\d?:\\d\\d:\\d\\d [AP]M");
  private static final DateFormat DATE_TIME_FMT3 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN1.matcher(field);
      if (match.matches()) {
        setDateTime(DATE_TIME_FMT1, field, data);
        return true;
      }
      
      match = DATE_TIME_PTN2.matcher(field);
      if (match.matches()) {
        setDateTime(DATE_TIME_FMT2, field, data);
        return true;
      }
      
      match = DATE_TIME_PTN3.matcher(field);
      if (match.matches()) {
        setDateTime(DATE_TIME_FMT3, field, data);
        return true;
      }
      
      return false;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("-default")) field = field.substring(0,field.length()-8).trim();
      else if (field.endsWith("-")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern PLACE_SRC_PTN = Pattern.compile("[A-Z]{2}FD");
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      if (PLACE_SRC_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private static final Pattern ADDR_APT_PTN = Pattern.compile("[ ,]+(?:(?:APT|RM) *([^ ]+)|(LOT *[^ ]+))$");
  private static final Pattern ADDR_CITY_CODE_PTN = Pattern.compile(" +([A-Z]{4}) +[A-Z]{3}$");
  private class MyAddress3Field extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Look for trailing apt pattern
      Matcher match = ADDR_APT_PTN.matcher(field);
      if (match.find()) {
        data.strApt = match.group(1);
        if (data.strApt == null) data.strApt = match.group(2);
        field = field.substring(0,match.start());
      }
      
      // Process trailing place name
      int pt = field.indexOf(": @");
      if (pt >= 0) {
        data.strPlace = field.substring(pt+3).trim();
        field = field.substring(0,pt);
      }

      // Process city code.  We don't know what the last 3 character code is, for now ignore it
      match = ADDR_CITY_CODE_PTN.matcher(field);
      if (!match.find()) abort();
      data.strCity = convertCodes(match.group(1),  CITY_CODES);
      field = field.substring(0,match.start());
      
      parseAddress(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR CITY PLACE APT";
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (!field.contains(":")) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      field = field.replace(':', '/');
      if (field.endsWith("/")) {
        field = field.substring(0,field.length()-1).trim();
      }
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      int pt = field.indexOf('@');
      if (pt >= 0) {
        String cross = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
        if (cross.startsWith("/")) cross = cross.substring(1).trim();
        data.strCross = cross;
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return super.getFieldNames() + " X";
    }
  }
  
  // Backup address field is used if first address field does not contain an address
  private class MyAddress2Field extends AddressField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      if (data.strAddress.length() > 0) return false;
      parse(field, data);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith(": @")) {
        field = field.substring(3).trim();
        int pt = field.indexOf(':');
        if (pt < 0) pt = field.indexOf(' ');
        if (pt < 0) pt = field.length();
        String place = field.substring(0,pt);
        if (!PLACE_SRC_PTN.matcher(place).matches()) {
          data.strPlace = append(data.strPlace, " - ", place);
        }
        if (pt >= field.length()) return;
        field = field.substring(pt+1).trim();
      }
      String apt = "";
      int pt = field.lastIndexOf(',');
      if (pt >= 0) {
        apt = field.substring(pt+1).trim();
        field = field.substring(0,pt).trim();
      }
      super.parse(field, data);
      data.strApt = append(data.strApt, " - ", apt);
    }
  }
  
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = cleanWirelessCarrier(field);
      if (CITY_SET.contains(field)) {
        if (field.equals("BIBB CO")) field = "BIBB COUNTY";
        data.strCity = field;
      }
      else if (field.startsWith(": @")) {
        field = field.substring(3).trim();
        if (! field.equals(data.strPlace)) data.strPlace = append(data.strPlace, " - ", field);
      }
      
      else if (field.startsWith(":")) {
        data.strApt = append(data.strApt, " - ", field.substring(1).trim());
      }
      else super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "APT PLACE CITY INFO";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("TYPE")) return new SkipField("Cad.*", true);
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR3")) return new MyAddress3Field();
    if (name.equals("X"))  return new MyCrossField();
    
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("ADDR2")) return new MyAddress2Field();
    if (name.equals("INFO")) return new MyInfoField();
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
      "ALAB", "ALABASTER",
      "ALMT", "MONTEVALLO",
      "CALE", "CALERA",
      "CALJ", "CALERA",
      "COLU", "COLUMBIANA",
      "HELN", "HELENA",
      "KING", "COLUMBIANA",
      "MONT", "MONTEVALLO",
      "SHEL", "SHELBY",
      "SUMH", "",
      "WEST", "WESTOVER",
      "WILS", "WILSONVILLE",
      "WSHE", "MONTEVALLO"
      
  });
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(
    
    "ALABASTER",
    "BIRMINGHAM",
    "CALERA",
    "CHELSEA",
    "COLUMBIANA",
    "HARPERSVILLE",
    "HELENA",
    "HOOVER",
    "INDIAN SPRINGS VILLAGE",
    "LEEDS",
    "MONTEVALLO",
    "PELHAM",
    "VESTAVIA HILLS",
    "VINCENT",
    "WESTOVER",
    "WILSONVILLE",
    "WILTON",
    
    "CLOVERDALE",
    "INVERNESS",
    "SAGINAW",
    "SILURIA",
    
    "BRANTLEYVILLE",
    "BROOK HIGHLAND",
    "DUNNAVANT",
    "HIGHLAND LAKES",
    "MEADOWBROOK",
    "SHELBY",
    "SHOAL CREEK",
    "STERRETT",
    "VANDIVER",
    "CHILDERSBURG",
    
    "BIBB CO",
    "BIBB COUNTY"
  ));  
}
