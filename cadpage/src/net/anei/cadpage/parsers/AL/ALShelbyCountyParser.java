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
  
  public ALShelbyCountyParser() {
    super("SHELBY COUNTY", "AL",
           "ID DATETIME SRC_UNIT CALL ADDR! APT X NAME");
  }
  
  @Override
  public String getFilter() {
    return "arns@shelby911.org,ARNS Alert";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("ARNS ALERT")) return false;
    if (!body.startsWith("NEW - ")) return false;
    body = body.substring(6).trim();
    return parseFields(body.split("\n"), data);
  }

  private static final Pattern DATE_TIME_PTN = Pattern.compile("\\d{4}-\\d\\d-\\d\\d \\d\\d:\\d\\d:\\d\\d");
  private class MyDateTimeField extends DateTimeField {

    @Override
    public void parse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) abort();
      data.strDate = field.substring(5,7) + '/' + field.substring(8,10) + '/' + field.substring(0,4);
      data.strTime = field.substring(11);
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
  
  private static final Pattern ADDR_SPECIAL_PTN = Pattern.compile("([A-Z]{4}) [A-Z]{3}: @(.*?)(?::(.*))?");
  private static final Pattern ADDR_SPECIAL_PTN2 = Pattern.compile("(.*?):(.*?): *(\\d{3}-?\\d{3}-\\d{4})");
  private static final Pattern ADDR_PLACE_PTN = Pattern.compile(" *: ?@?(.*)");
  private static final Pattern ADDR_CITY_CODE_PTN = Pattern.compile(" +([A-Z]{4}) +[A-Z]{3}$");
  private static final Pattern ADDR_APT_PTN = Pattern.compile("[ ,:]+(?:(?:APT|RM|ROOM|UNIT|SUITE?)(?![A-Z]) *([^ ]+)|((?:LOT|FL) *[^ ]+)|(?<=,) *(\\d+[A-Z]?))$");
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      
      // Check special city src: @place:address pattern
      Matcher match = ADDR_SPECIAL_PTN.matcher(field);
      if (match.matches()) {
        data.strCity = convertCodes(match.group(1), CITY_CODES);
        data.strPlace = match.group(2).trim();
        parseAddress(getOptGroup(match.group(3)).trim(), data);
        if (data.strAddress.length() == 0 && data.strPlace.startsWith("MM ")) {
          data.strAddress = data.strPlace;
          data.strPlace = "";
        }
        return;
      }
      
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
        String place = match.group(1);;
        field = field.substring(0,match.start());
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

      // Process city code and something that we are ignoring
      match = ADDR_CITY_CODE_PTN.matcher(field);
      if (match.find()) {
        String city = CITY_CODES.getProperty(match.group(1));
        if (city != null) {
          data.strCity = city;
          field = field.substring(0,match.start());
        }
      }
      
      parseAddress(field, data);
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
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equals("FOURMILE")) return "SHELBY COUNTY";
    if (city.equals("SAGINAW")) return "SHELBY COUNTY";
    return city;
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "ALAB", "ALABASTER",
      "ALMT", "MONTEVALLO",
      "BRIR", "BRIERFIELD",
      "CALE", "CALERA",
      "CALJ", "CALERA",
      "COLU", "COLUMBIANA",
      "FOUR", "FOURMILE",
      "HELN", "HELENA",
      "KING", "COLUMBIANA",
      "MONT", "MONTEVALLO",
      "NONE", "",
      "PELH", "PELHAM",
      "SAGN", "SAGINAW",
      "SHEL", "SHELBY",
      "SUMH", "",
      "WESJ", "WESTOVER",
      "WEST", "WESTOVER",
      "WILJ", "WILSONVILLE",
      "WILS", "WILSONVILLE",
      "WILT", "WILTON",
      "WSHE", "MONTEVALLO"
      
  });
}
