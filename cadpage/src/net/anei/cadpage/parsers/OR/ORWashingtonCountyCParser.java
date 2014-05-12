package net.anei.cadpage.parsers.OR;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/**
 * Washington County, OR (Variant C)
 * Also Clackamas County
 */
public class ORWashingtonCountyCParser extends MsgParser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile(".*\\bUNIT: *([^ ]+) +INC#: *(\\d+) +(?:RCD|CLR): .*");
  private static final Pattern CODE_CALL_PTN = Pattern.compile("(\\d{1,2}[A-Z]\\d{1,2}[A-Z]?) +([^ ].*)");
  
  public ORWashingtonCountyCParser() {
    super("WASHINGTON COUNTY", "OR");
    setFieldList("UNIT ID PLACE ADDR APT CITY X PRI CODE CALL");
  }
  
  @Override
  public String getFilter() {
    return "portlandcomm@amr-ems.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("VisiCAD Email")) return false;
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      data.strUnit = match.group(1);
      data.strCallId = match.group(2);
      return true;
    }

    if (body.length() >= 197 &&
        body.substring(0,6).equals("UNIT: ") &&
        body.substring(15,22).equals(" INC#: ") &&
        body.substring(31,32).equals(" ") &&
        body.charAt(65) != ' ' &&
        body.charAt(106) == ' ' && 
        body.charAt(107) != ' ' && 
        body.substring(125,131).equals(" ZIP: ") &&
        body.substring(142,148).equals(" XST: ") &&
        body.substring(190,194).equals("PRI:") &&
        body.charAt(196) == ' ' &&
        body.charAt(197) != ' ') {
      data.strUnit = substring(body,6,15);
      data.strCallId = substring(body,22,31);
      data.strPlace = substring(body,32,65);
      parseAddress(substring(body,65,96), data);
      data.strApt = substring(body,96,106);
      data.strCity = substring(body,107,125);
      data.strCross = substring(body,148,190);
      data.strPriority = substring(body,194,196);
      String call = substring(body,197);
      match = CODE_CALL_PTN.matcher(call);
      if (match.matches()) {
        data.strCode = match.group(1);
        call = match.group(2);
      }
      data.strCall = call;
      return true;
    }
    
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
}
