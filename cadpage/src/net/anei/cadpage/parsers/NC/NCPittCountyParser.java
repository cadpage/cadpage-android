package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCPittCountyParser extends FieldProgramParser {
  
  private static final Pattern CONFIRM_FIRE_MARKER = Pattern.compile(">>ADDRESS: +(?:0 +-|(.*?)) +>>NOTES: *(.*?)(?: // (.*))?");
  private static final Pattern APT_PTN = Pattern.compile("^(?:APT|RM|ROOM) *", Pattern.CASE_INSENSITIVE);
  
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
      setFieldList("CALL ADDR APT INFO");
      data.strCall = "CONFIRMED FIRE";
      String addr = match.group(1);
      String apt = null;
      if (addr == null) {
        addr = match.group(2);
      } else {
        apt = match.group(2).trim();
      }
      parseAddress(addr.trim(), data);
      if (apt != null) {
        Matcher match2 = APT_PTN.matcher(apt);
        if (match2.find()) apt = apt.substring(match2.end());
        data.strApt = append(data.strApt, "-", apt);
      }
      
      data.strSupp = getOptGroup(match.group(3));
      return true;
    }
    
    if (!parseFields(body.split("\\|"), data)) return false;
    
    if (data.strAddress.length() == 0) {
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
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      if (field.equals("0") || field.startsWith("0 ")) field = "";
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("DATETIME")) return new DateTimeField("\\d\\d/\\d\\d/\\d{4} \\d\\d:\\d\\d", true);
    if (name.equals("SAME")) return new SkipField("SAME", true);
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("ADDR")) return new MyAddressField();
    return super.getField(name);
  }
}
