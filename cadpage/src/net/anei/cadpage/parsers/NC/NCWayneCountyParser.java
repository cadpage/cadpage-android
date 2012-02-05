package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/* 
Wayne County, NC
Contact: support@active911.com
Sender: CC_Message_Notification@usamobility.net

Structure Fire  117,S RUNNING DEER CIR ;DUDLEY  DUDLEY [76]
Traffic Accident-Inj    1574,    DURHAM LAKE RD ; DUDLEY  DUDLEY    [68]
Gas Leak        105,    ROLLINGWOOD CT ;  DUDLEY    DUDLEY    [71]
TRaffic Accident-Inj    3944,     US 117 ALT ;      DUDLEY    DUDLEY    [67]
Gas Leak        1104,   S CHURCH ST     MOUNT OLIVE  MOUNT OLIVE  [70]
Traffic Accident-Inj      1493,   EMMAUS CHURCH RD ;  DUDLEY    DUDLEY    [69]
Traffic Accident-Inj    1574,     DURHAM LAKE RD ;  DUDLEY  DUDLEY    [68]

*/

public class NCWayneCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*?)  +(\\d+) *, *(.*?) +[; ] *(.*?)  +(.*?) \\[(\\d+)\\]");
  
  public NCWayneCountyParser() {
    super("WAYNE COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace('\t', ' ');
    Matcher match = MASTER.matcher(body);
    if (!match.find()) return false;
    
    data.strCall = match.group(1);
    String sAddr = append(match.group(2), " ", match.group(3));
    parseAddress(sAddr, data);
    data.strSource = match.group(4);
    data.strCity = match.group(5);
    data.strCallId = match.group(6);
    
    return true;
  }
}
