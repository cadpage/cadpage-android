package net.anei.cadpage.parsers.IA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class IABlackHawkCountyParser extends FieldProgramParser {
  
  private static final Pattern CALL_ID_PATTERN = Pattern.compile("^\\d\\d-\\d{6} ");
  
  public IABlackHawkCountyParser() {
    super("BLACK HAWK COUNTY", "IA",
           "CALL! Reported:DATETIME! ADDR X PLACE! UNIT");
  }
  
  @Override
  public String getFilter() {
    return "Swmail@bhcso.org,Xmail@connectingyou.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = CALL_ID_PATTERN.matcher(body);
    if (! match.find()) return false;
    
    data.strCallId = body.substring(0, match.end()-1);
    body = body.substring(match.end()).trim();
    
    // Calls come in two forms.  The easy one has nice line break delimiters
    String[] flds = body.split("\n");
    if (flds.length == 1) return oldParseMsg(body, data); 
    return parseFields(flds, data);
  }
  
  @Override
  public String getProgram() {
    return "ID " + super.getProgram();
  }
  
  private class MyPlaceField extends PlaceField {
    @Override
    public void parse(String field, Data data) {
      // Last token is the (possibly abbreviated) city
      int pt = Math.max(field.lastIndexOf(' '), field.lastIndexOf('/'));
      if (pt < 0) abort();
      data.strCity = field.substring(pt+1).trim();
      if (data.strCity.equals("RAYMO")) data.strCity = "RAYMOND";
      field = field.substring(0, pt).trim();
      super.parse(field, data);
    }
    
    @Override
    public String getFieldNames() {
      return "PLACE CITY";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d:\\d\\d", true);
    if  (name.equals("PLACE")) return new MyPlaceField();
    return super.getField(name);
  }
  
  private boolean oldParseMsg(String body, Data data) {
    
    // city is awkward because they sometimes use / and sometimes blank to
    // delineate it
    int pt = Math.max(body.lastIndexOf(' '), body.lastIndexOf('/'));
    if (pt < 0) return false;
    data.strCity = body.substring(pt+1).trim();
    body = body.substring(0, pt).trim();
    
    // Parse description and address, anything left is a cross street
    parseAddress(StartType.START_CALL, body, data);
    data.strCross = getLeft();
    
    return true;
  }
}
