package net.anei.cadpage.parsers.MO;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MOWarrenCountyParser extends FieldProgramParser {

  public MOWarrenCountyParser() {
    super(CITY_TABLE, "WARREN COUNTY", "MO", 
          "ADDRCITY CALL INFO/N+");
    setupSpecialStreets("BROOKVIEW");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@WARRENCOUNTY911.ORG";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return parseFields(body.split("\n"), data);
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("ADDRCITY")) return new MyAddressCityField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }

  private class MyAddressCityField extends AddressCityField {
    @Override
    public void parse(String field, Data data) {
      
      // We can usually, but not always, count on a double
      // space delimiter between the address and city
      int pt = field.lastIndexOf("  ");
      int flags = FLAG_ALLOW_DUAL_DIRECTIONS | FLAG_RECHECK_APT | FLAG_ANCHOR_END;
      if (pt >= 0) {
        data.strCity = field.substring(pt+2).trim();
        field = field.substring(0,pt).trim();
        flags |= FLAG_NO_CITY;
      }
      parseAddress(StartType.START_ADDR, flags, field, data);
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
    "ST LOUIS"
    
    
  };
}
