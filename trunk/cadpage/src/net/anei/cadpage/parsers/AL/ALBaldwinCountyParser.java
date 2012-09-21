
package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/**
 * Baldwin County, AL
 */
public class ALBaldwinCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:- E911 Notification - ([^-]+) - )?(\\d\\d-\\d\\d-\\d\\d) (\\d\\d:\\d\\d): Station ([A-Z0-9]+) dispatched to Incident ID (\\d+) \\(([^\\)]*?)\\) at (.*?)(?:\\(.*\\))?");
  private static final DateFormat DATE_FMT = new SimpleDateFormat("MM-dd-yy");
  private static final Pattern DOUBLE_NUMBER_PTN = Pattern.compile("(\\d+) +(\\d+)");

  public ALBaldwinCountyParser() {
    super("BALDWIN COUNTY", "AL");
  }
    
  @Override
  public String getFilter() {
    return "cad@baldwin911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = getOptGroup(match.group(1));
    setDate(DATE_FMT, match.group(2), data);
    data.strTime = match.group(3);
    data.strUnit = match.group(4);
    data.strCallId = match.group(5);
    data.strCall = match.group(6).trim();
    
    String sAddr = match.group(7).trim().replace('@', '&');
    match = DOUBLE_NUMBER_PTN.matcher(sAddr);
    if (match.matches()) sAddr = match.replaceFirst("$1 RT $2");
    parseAddress(sAddr, data);
    
    return true;
  }
}
