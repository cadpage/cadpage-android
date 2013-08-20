package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;


public class VANewKentCountyParser extends DispatchDAPROParser {
  
  public VANewKentCountyParser() {
    super("NEW KENT COUNTY", "VA");
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "MAILBOX@rushpost.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strAddress.endsWith(" 0")) {
      data.strAddress = data.strAddress.substring(0,data.strAddress.length()-2).trim();
    }
    
    // Strip off leading zero house number
    Matcher match = LEAD_ZEROS_PTN.matcher(data.strAddress);
    if (match.find()) data.strAddress = data.strAddress.substring(match.end());
    return true;
  }
  private static final Pattern LEAD_ZEROS_PTN = Pattern.compile("^0+ +");
  
  private static final CodeSet CALL_SET = new CodeSet(
      "BREATHING DIFFICULTY",
      "CARDIAC (WITH HISTORY)",
      "DEBRIS/TREE IN ROAD",
      "MOTOR VEHICLE ACCIDENT",
      "RESIDENTIAL FIRE ALARM",
      "SUSPICIOUS SITUATION",
      "SEIZURE/CONVUSIONS",
      "VEHICLE FIRE"
  );
}
