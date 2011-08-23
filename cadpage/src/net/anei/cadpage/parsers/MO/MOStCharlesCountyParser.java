package net.anei.cadpage.parsers.MO;


import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;


/*
St Charles County, MO
Contact: Micah Conner <mconner@offpd.com>
Sender: dispatch@sccda.org

081411-29063        05 Back Pain (No Trauma) 161 Our Ln                                        ~/HIGHWAY 94 N           APT:                X ST:HIGHWAY 94 N/Dead End         MAP:M 6-22         Rivers Pointe B2
072611-26676        23 Overdose QD           308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2
081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2
081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2

*/

public class MOStCharlesCountyParser extends SmsMsgParser {
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{6}-\\d{5}");
 
  public MOStCharlesCountyParser() {
    super("ST CHARLES COUNTY", "MO");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    data.strCallId = substring(body, 0, 12);
    if (! ID_PTN.matcher(data.strCallId).matches()) return false;
    data.strSupp = substring(body, 12, 20);
    data.strCode = substring(body, 20, 23);
    data.strCall = substring(body, 23, 45);
    parseAddress(substring(body, 45, 95), data);
    data.strPlace = substring(body, 95, 120);
    data.strCross = substring(body, 120, 175);
    data.strMap = substring(body, 175, 194);
    return true;
  }
  
  private String substring(String text, int start, int end) {
    int  len =  text.length();
    if (start > len) start = len;
    if (end > len) end = len;
    return text.substring(start, end).trim();
  }
}