package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHSummitCountyBParser extends FieldProgramParser {
  
  private static final Pattern OPERATOR_PTN = Pattern.compile("^[a-z]+: +", Pattern.CASE_INSENSITIVE);
  
  public OHSummitCountyBParser() {
    this("SUMMIT COUNTY", "OH");
  }
  
  OHSummitCountyBParser(String defCity, String defState) {
    super(CITY_LIST, defCity, defState,
           "( CALL ADDR | CALLADDR ) ( CITY | PLACE CITY | ) INFO+");
  }
  
  @Override
  public String getFilter() {
    return "info@sundance-sys.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    body = OPERATOR_PTN.matcher(body).replaceFirst("");
    return parseFields(body.split(","), 3, data);
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("0 ")) field = field.substring(2).trim();
      super.parse(field, data);
    }
  }
  
  // CALLADDR is a hybrid call address that we try if the CALL field does
  // not match the property pattern.
  private class MyCallAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END | FLAG_CHECK_STATUS, field, data);
      if (getStatus() == 0) abort();
    }
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      
      // Intersections are duplicated in the place field.  If this
      // matches the previous address field, ignore it
      String addr = getRelativeField(-1);
      if (addr.startsWith("0 ") && field.equals(addr.substring(2))) return;
      super.parse(field, data);
    }
  }

  private static final Pattern INFO_CODE_PTN = Pattern.compile("^S\\dD\\d");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = INFO_CODE_PTN.matcher(field);
      if (match.find()) {
        data.strMap = match.group();
        field = field.substring(match.end()).trim();
      }
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "MAP INFO";
    }
  }

  @Override
  protected Field getField(String name) {
    if (name.equals("CALL")) return new CallField("[A-Z0-9/]+-.*", true);
    if (name.equals("CALLADDR")) return new MyCallAddressField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("PLACE")) return new MyPlaceField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    if (addr.endsWith(" LOBBY")) addr = addr.substring(0,addr.length()-6).trim();
    addr = PAREN_DIR_PTN.matcher(addr).replaceAll(" $2 $1 ");
    addr = CLEVE_MASS_PTN.matcher(addr).replaceAll("CLEVELAND MASSILON");
    return addr.trim().replaceAll("  +", " ");
  }
  private static final Pattern PAREN_DIR_PTN = Pattern.compile("(?<=^| )([^&\\d]*) \\(([NSEW])\\)");
  private static final Pattern CLEVE_MASS_PTN = Pattern.compile("\\bCleve-Mass\\b", Pattern.CASE_INSENSITIVE);
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "AKRON",
    "BARBERTON",
    "CAYAHOGA FALLS",
    "FAIRLAWN",
    "GREEN",
    "HUDSON",
    "MACEDONIA",
    "MONROE FALLS",
    "NEW FRANKLIN",
    "NORTON",
    "STOW",
    "TALLMADGE",
    "TWINSBURG",
    
    // Villages
    "BOSTON HEIGHTS",
    "CLINTON",
    "LAKEMORE",
    "MOGADORE",
    "NORTHFIELD",
    "PENINSULA",
    "REMINDERVILLE",
    "RICHFIELD",
    "SILVER LAKE",
    
    // Townships
    "BATH",
    "BOSTON",
    "COPLEY",
    "COVENTRY",
    "NORTHFIELD CENTER",
    "RICHFIELD",
    "SAGAMORE HILLS",
    "SPRINGFIELD",
    "TWINSBURG",
    
    
    // Medina County
    "WADSWORTH",
    "WADSWORTH TOWNSHIP",
    "WADSWORTH TWP"
    
  };
}
