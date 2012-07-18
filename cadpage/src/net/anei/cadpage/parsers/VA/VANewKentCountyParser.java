package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchDAPROParser;

/*
New Kent County, VA
Contact: Active911 
Agency name: New Kent Fire Rescue Location: New Kent, VA
Sender: MAILBOX@co.newkent.state.va.us
 
MAILBOX:F1 TEST ONLY 11995 COURTHOUSE CIR 0 CFS# 2012-017858
MAILBOX:F1 TEST ONLY 12025 COURTHOUSE CIR CFS# 2012-017860
MAILBOX:F1 TEST ONLY 4315 N COURTHOUSE RD CFS# 2012-017863
MAILBOX:F1 TEST ONLY 3511 OLIVET CHURCH RD CFS# 2012-017862
MAILBOX:F1 TEST ONLY 12001 COURTHOUSE CIR CFS# 2012-017861
MAILBOX:F1 SICK (UNKNOWN MEDICAL) 15460 POCAHONTAS TRL CFS# 2012-017864
MAILBOX:F3 VEHICLE FIRE 220 WB 64 CFS# 2012-017867
MAILBOX:F1 SEIZURE/CONVULSIONS 9100 POCAHONTAS TRL CFS# 2012-017875
MAILBOX:F3 RESIDENTIAL FIRE ALARM 9818 TUNSTALL RD CFS# 2012-017894
MAILBOX:F3 BREATHING DIFFICULTY 7701 PARHAM LANDING RD CFS# 2012-017897
MAILBOX:F2 SUSPICIOUS SITUATION 8157 N HENPECK RD G CFS# 2012-017902
MAILBOX:F2 CARDIAC (WITH HISTORY) 3447 RIDGE RD CFS# 2012-017921
MAILBOX:F3 MOTOR VEHICLE ACCIDENT 33/EXXON CFS# 2012-018009
MAILBOX:F2 DEBRIS/TREE IN ROAD 000000 HENPECK/64 CFS# 2012-018017

*/

public class VANewKentCountyParser extends DispatchDAPROParser {
  
  public VANewKentCountyParser() {
    super("NEW KENT COUNTY", "VA");
    setup();
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
  
  private void setup() {
    setupCallList(
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
}
