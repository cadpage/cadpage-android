package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOWarrenCountyParser extends FieldProgramParser {

  public MOWarrenCountyParser() {
    super(CITY_TABLE, "WARREN COUNTY", "MO", 
          "ADDRCITY CALL! DATETIME? INFO/N+");
    setupSpecialStreets("BROOKVIEW");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@WARRENCOUNTY911.ORG,WarrenCo911@publicsafetysoftware.net";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Pretty loose format, so check for a positive ID
    if (!isPositiveId()) return false;
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("DATETIME")) return new MyDateTimeField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private static final Pattern ADDR_APT_PTN = Pattern.compile("[A-Z]?\\d+[A-Z]?");
  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      
      // We can usually, but not always, count on a double
      // space delimiter between the address and city
      int pt = field.lastIndexOf("  ");
      int flags = FLAG_ALLOW_DUAL_DIRECTIONS | FLAG_RECHECK_APT | FLAG_ANCHOR_END;
      String city = null;
      if (pt >= 0) {
        city = field.substring(pt+2).trim();
        field = field.substring(0,pt).trim();
        flags |= FLAG_NO_CITY;
      }
      parseAddress(StartType.START_ADDR, flags, field, data);
      if (city != null) {
        if (ADDR_APT_PTN.matcher(city).matches()) {
          data.strApt = append(data.strApt, "-", city);
        } else {
          data.strCity = city;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "ADDR APT X CITY";
    }
  }

  @Override
  protected boolean isNotExtraApt(String apt) {
    if (apt.startsWith("OFF")) return true;
    return super.isNotExtraApt(apt);
  }
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile("Call Received on (\\d\\d/\\d\\d/\\d{4}) @ (\\d\\d?:\\d\\d)");
  private class MyDateTimeField extends DateTimeField {
    @Override
    public boolean canFail() {
      return true;
    }
    
    @Override
    public boolean checkParse(String field, Data data) {
      Matcher match = DATE_TIME_PTN.matcher(field);
      if (!match.matches()) return false;
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      return true;
    }
    
    @Override
    public void parse(String field, Data data) {
      if (!checkParse(field, data)) abort();
    }
  }

  private static final Pattern INFO_DASH_PTN = Pattern.compile("-+");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      if (INFO_DASH_PTN.matcher(field).matches()) return;
      super.parse(field, data);
    }
  }
  
  private static final String[] CITY_TABLE = new String[]{
    "WARREN COUNTY",
    
    // Cities and towns
    "FORISTELL",
    "INNSBROOK",
    "MARTHASVILLE",
    "PENDLETON",
    "THREE CREEKS",
    "TRUESDALE",
    "WARRENTON",
    "WRIGHT CITY",
    
    // Unincorporated communities
    "ASPENHOFF",
    "DUTZOW",
    "HOLSTEIN",
    "MINDEN",
    "NEW TRUXTON",
    "TRELOAR",
    
    // Franklin County
    "WASHINGTON",
    
    // Lincoln County
    "HAWK POINT",
    "TROY",
    "TRUXTON",
    
    // Montgomery County
    "JONESBURG",
    "NEW FLORENCE",
    
    // St Charles County
    "LAKE ST LOUIS",
    "NEW MELLE",
    "OFALLON",
    "ST CHARLES",
    "WENTZVILLE",
    
    // Independent cities
    "ST LOUIS",
    
    // Places recognized by Google
    "LAKE SHERWOOD",
    
    // Gasconade County
    "HERMANN"
    
    
  };
}
