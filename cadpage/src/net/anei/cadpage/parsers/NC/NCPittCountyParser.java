package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCPittCountyParser extends FieldProgramParser {
  
  private static final Pattern CONFIRM_FIRE_MARKER = Pattern.compile(">>ADDRESS: +0 +- +>>NOTES: *(.*?)(?: // (.*))?");
  
  public NCPittCountyParser() {
    super("PITT COUNTY", "NC",
           "SRC! Rcvd:DATETIME! Rsn:CALL! Note:INFO X Adr:ADDR!");
  }
  
  @Override
  public String getFilter() {
    return "donotreply@pittcountync.gov";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("911 Fire Call")) return false;
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = CONFIRM_FIRE_MARKER.matcher(body);
    if (match.matches()) {
      data.strCall = "CONFIRMED FIRE";
      parseAddress(match.group(1).trim(), data);
      data.strSupp = getOptGroup(match.group(2));
      return true;
    }
    
    if (!parseFields(body.split("\\|"), data)) return false;
    
    if (data.strAddress.length() == 0 || data.strAddress.equals("0") || data.strAddress.startsWith("0 ")) {
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, data.strSupp, data);
      data.strSupp = getLeft();
    } else if (data.strSupp.equals("SAME")) {
      data.strSupp = "";
    }
    return true;
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      int pt = field.indexOf('@');
      if (pt >= 0) {
        data.strCross = field.substring(0,pt).trim();
        data.strPlace = field.substring(pt+1).trim();
      } else {
        if (checkAddress(field) > 0) {
          data.strCross = field;
        } else {
          data.strPlace = field;
        }
      }
    }
    
    @Override
    public String getFieldNames() {
      return "X PLACE";
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d", true);
    if (name.equals("SAME")) return new SkipField("SAME", true);
    if (name.equals("X")) return new MyCrossField();
    return super.getField(name);
  }
}
