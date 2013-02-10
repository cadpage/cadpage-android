package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class CODouglasCountyBParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("([^:]+): *(\\d\\d/\\d\\d) +(\\d\\d:\\d\\d) +([A-Z]{2}-\\d\\d-[A-Z]) +(.*?) +([A-Z0-9,]+)");
  private static final Pattern FALLBACK_PTN = Pattern.compile("(.*?) +([A-Z]{2}[-/ A-Z0-9]+)");

  public CODouglasCountyBParser() {
    super("DOUGLAS COUNTY", "CO");
    setFieldList("SRC DATE TIME CODE ADDR APT CALL UNIT");
  }
  
  @Override
  public String getFilter() {
    return "Group_Page_Notification@usamobility.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    int pt = body.indexOf(" Received");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = match.group(1).trim();
    data.strDate = match.group(2);
    data.strTime = match.group(3);
    data.strCode = match.group(4);
    String addr = match.group(5).trim();;
    data.strUnit = match.group(6);
    
    // Try using smart address parser to break out address and call description
    parseAddress(StartType.START_ADDR, addr, data);
    data.strCall = getLeft();
    if (data.strCall.length() > 0) return true;
    
    // No go, try a fall back pattern that counts on the call description being upper case
    // and the address being camel case
    data.strAddress = "";
    match = FALLBACK_PTN.matcher(addr);
    if (!match.matches()) return false;
    parseAddress(match.group(1), data);
    data.strCall = match.group(2);
    return true;
  }
}
