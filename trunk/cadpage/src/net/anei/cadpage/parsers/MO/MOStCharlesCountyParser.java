package net.anei.cadpage.parsers.MO;


import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
St Charles County, MO
Contact: Micah Conner <mconner@offpd.com>
Sender: dispatch@sccda.org

081411-29063        05 Back Pain (No Trauma) 161 Our Ln                                        ~/HIGHWAY 94 N           APT:                X ST:HIGHWAY 94 N/Dead End         MAP:M 6-22         Rivers Pointe B2
072611-26676        23 Overdose QD           308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2
081911-29644        29 Motor Vehicle Accident4795 Highway 94 N                                 CHU Trinity Lutheran ChurAPT:                X ST:CHURCH RD/HIGHWAY H           MAP:Z 10-19        Orchard Farm B2
080811-28362        29 Motor Vehicle AccidentHighway 94 N & Highway V                                                   APT:                X ST:                              MAP:Y 7-19         Orchard Farm B2
082211-30048        32 Unknown EMS Problem QD14801 Highway 67 S                                south of the Clark BridgeAPT:                X ST:MISSISSIPPI RIV/Dead End      MAP:F 8-24         Rivers Pointe B2
080811-28362        29 Motor Vehicle AccidentHighway 94 N & Highway V                                                   APT:                X ST:                              MAP:Y 7-19         Orchard Farm B2
080111-27420        17D3 Fall Not Alert      4297 Highway 94 N                                                          APT:                X ST:LAGO VISTA DR/WIEDEY RD       MAP:Z 11-35        Orchard Farm B2
080111-27413        29B4 MVA Unknown Status  Orchard Farm Rd & Washeon Rd                                               APT:                X ST:                              MAP:CC 7-18        Orchard Farm B2
072911-27066        29B4 MVA Unk Status Unk P22100 I 70 W                                      WB EO 79                 APT:                X ST:Dead End/DARDENNE CRK         MAP:NN 16-47       CCFR
072811-26894        Alarm - Commercial       2165 Highway V                                    SCH Orchard Farm Middle  APT:                X ST:HIGHWAY 94 N/UNNAMED STREET   MAP:Z 7-19         Orchard Farm B2
080811-28275        Assist - Police (EMS)    14000 Highway 67 N                                GAS Pit Stop             APT:                X ST:RED SCHOOL RD/HIGHWAY 94      MAP:I 10-23        Rivers Pointe B2
080311-27759        10 Chest Pain QD         15052 Main St                                     /HIGHWAY 94              APT:                X ST:SAINT LOUIS ST/Dead End       MAP:I 10-23        Rivers Pointe B2
072611-26676        23C3 Overdose Antidepress308 Donald Ave                                    PRAIRIE HOMES ADDN/HWY V APT:                X ST:SUSAN AVE/RUTH AVE            MAP:BB 8-19        Orchard Farm B2

*/

public class MOStCharlesCountyParser extends MsgParser {
  
  private static final Pattern ID_PTN = Pattern.compile("\\d{6}-\\d{5}");
 
  public MOStCharlesCountyParser() {
    super("ST CHARLES COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@sccda.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    data.strCallId = substring(body, 0, 12);
    if (! ID_PTN.matcher(data.strCallId).matches()) return false;
    data.strSupp = substring(body, 12, 20);
    data.strCall = substring(body, 20, 45);
    parseAddress(substring(body, 45, 95), data);
    data.strPlace = substring(body, 95, 120);
    data.strApt = substring(body, 124, 140);
    data.strCross = substring(body, 145, 175);
    data.strMap = substring(body, 179, 194);
    data.strSource = substring(body, 194, 999);
    return true;
  }
}