
package net.anei.cadpage.parsers.AL;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/*
Baldwin County, AL
Contact: Josh Hines <josh36530@gmail.com>
Sender: cad@baldwin911.org

- E911 Notification - Elberta VFD - 05-20-12 13:43: Station STA31 dispatched to Incident ID 290161 (Stroke) at 25855 WILLOW RIDGE R
- E911 Notification - Elberta VFD - 05-21-12 15:35: Station STA31 dispatched to Incident ID 290600 (Fire - Grass) at 17305 JOE GOTTLER RD
- E911 Notification - Elberta VFD - 05-24-12 08:48: Station STA31 dispatched to Incident ID 291543 (Auto Accident) at 14850 87\n
- E911 Notification - Elberta VFD - 05-26-12 08:04: Station STA31 dispatched to Incident ID 292420 (Auto Accident) at US HWY 98 @ SANDY LN
- E911 Notification - Elberta VFD - 05-26-12 16:24: Station STA31 dispatched to Incident ID 292625 (Auto Accident) at HWY98 @ CORD9

*/


public class ALBaldwinCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("- E911 Notification - ([^-]+) - (\\d\\d-\\d\\d-\\d\\d) (\\d\\d:\\d\\d): Station ([A-Z0-9]+) dispatched to Incident ID (\\d+) \\(([^\\)]*?)\\) at (.*)");
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
    data.strSource = match.group(1).trim();
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
