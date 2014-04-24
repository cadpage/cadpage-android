package net.anei.cadpage.parsers.NJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NJSussexCountyAParser extends SmartAddressParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("[A-Z]{1,5}-[A-Z]?\\d{4}-\\d{6}");
  private static final Pattern MASTER_PTN = 
    Pattern.compile("([-A-Z0-9 ]+) @ ([^,]+?) *, ([^-]*) -(?: (.*))?"); 
  
  public NJSussexCountyAParser() {
    super("SUSSEX COUNTY", "NJ");
    setFieldList("ID CALL ADDR APT CITY INFO");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! SUBJECT_PTN.matcher(subject).matches()) return false;
    data.strCallId = subject;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    parseAddress(match.group(2).trim(), data);
    data.strCity = match.group(3).trim();
    String sInfo = getOptGroup(match.group(4));
    if (data.strAddress.equals("OUT OF TOWN")) {
      data.strAddress = "";
      parseAddress(StartType.START_ADDR, sInfo, data);
      data.strSupp = getLeft();
      data.defCity = "";
      data.defState = "";
    } else {
      data.strSupp = sInfo;
    }
    return true;
  }
}
