package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


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
