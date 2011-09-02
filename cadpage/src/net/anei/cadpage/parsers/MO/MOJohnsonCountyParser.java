package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/*
Johnson County, MO
Contact: Ken Jennings <kj8111@hotmail.com>
Sender: cadpage@joco911.org

[ 911 Page ] Dispatch: 7/19/2011 17:44:07 80 - Carbon Monoxide/Hazmat 1064 NE 75 RD, Apt. 112 JOHNSON COUNTY
[ 911 Page ] Dispatch: 7/20/2011 19:24:58 FIRE VEHCILE 793 NE 101 RD JOHNSON COUNTY MO
[ 911 Page ] Dispatch: 7/18/2011 22:25:03 FIRE GRASS SE DD HWY & SE 341 RD JOHNSON COUNTY
[ Subject: 911 Page ] 7/17/2011 21:02:06 FIRE STRUCTURE 1072 NW 475 RD JOHNSON COUNTY

*/

public class MOJohnsonCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[]{
    "JOHNSON COUNTY",
    "JOHNSON COUNTY MO"
  };
  
  private static final Pattern MARKER = Pattern.compile("^(?:Dispatch: +)?\\d{1,2}/\\d{1,2}/\\d{4} \\d\\d:\\d\\d:\\d\\d +");
 
  public MOJohnsonCountyParser() {
    super(CITY_LIST, "JOHNSON COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@joco911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.contains("911 Page")) return false;
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim().replace(',', ' ');
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, body, data);
    if (data.strCity.startsWith("JOHNSON COUNTY")) data.strCity = "";
    return true;
  }
}