package net.anei.cadpage.parsers.IL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Cook County, IL
Contact: "Malcolm, John" <JMalcolm@mountprospect.org>
Sender: 911@NWCDS.org

[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3 \n
[20:10:53 11-07-2011] *D 1303 3F/409 OAK ST ,MP TWR13 E14 E12 A14 A12 BAT3
[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3
[13:03:43 11-11-2011] *D 1402 AFAF/1329 WOLF RD ,MP (EUCLID CROSSING) TWR13 E14 A14 BAT3
[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3
[17:38:36 11-08-2011] *D 1208 AFAF/803 GOLFVIEW DR ,MP TWR13 E12 A12 BAT3
[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3

*/

public class ILCookCountyParser extends MsgParser {
  
  private static final Pattern SUBJECT_PTN = Pattern.compile("(\\d\\d:\\d\\d:\\d\\d) (\\d\\d-\\d\\d-\\d{4})");
  private static final Pattern MASTER_PTN = Pattern.compile("\\*D (\\d{4} [A-Z0-9]+)/([^,]+) ,([A-Z]+)(?: \\((.*)\\))? (.*)");
  
  public ILCookCountyParser() {
    super("COOK COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "911@NWCDS.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = SUBJECT_PTN.matcher(subject);
    if (!match.matches()) return false;
    data.strTime = match.group(1);
    data.strDate = match.group(2);
    
    match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    parseAddress(match.group(2).trim(), data);
    data.strCity = convertCodes(match.group(3), CITY_CODES);
    data.strPlace = getOptGroup(match.group(4));
    data.strUnit = match.group(5).trim();
    
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MP", "MT PROSPECT"
  });
}
