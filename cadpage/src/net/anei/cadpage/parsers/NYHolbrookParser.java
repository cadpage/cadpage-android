package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;
/*
Holbrook FD, NY (Suffolk County franchise)
Contact: "bfdtecresq@aol.com" <bfdtecresq@aol.com>
Sender: Paging@alpinesoftware.com
MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57
WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36
WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21
AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14

Contact: 6318311965@vtext.com
AMBULANCE CALL: 63 YOF RESP. 6-D-2 at 1585 CLAAS AVE, Holbrook . . 20:49:28
CARBON MONOXIDE ALARM: ALARM GOING OFF - NEG SYMPTOMS at 53 TIMBER RIDGE DR, Holbrook . . 22:46:56
FUEL SPILL: SHERIFFS ON SCENE REQUESTING at E/B SUNRISE HWY SRVC / BROADWAY AVE, HOLBROOK . . 23:06:50
CARBON MONOXIDE ALARM: CO ALARM at 53 TIMBER RIDGE DR, HOLBROOK  c/s: SPRINGMEADOW DR . . 00:15:25
MUTUAL AID - STRUCTURE FIRE at 62 POTOMAC  c/s: GRUNDY . . 15:08:02
MOTOR VEHICLE ACCIDENT at LINCOLN AVE / VETERANS MEMORIAL HWY, HOLBROOK . . 12:16:23
MISC: UNKNOWN TYPE FIRE - SOUTH END OF MUSKET DR at MUSKET DR / CANNON DR, HOLBROOK . . 20:58:10
MUTUAL AID - STRUCTURE FIRE: 1 LADDER TO THE SCENE at 456 WAVERLY AVE  c/s: BUCKLEY RD . . 13:56:21
AMBULANCE CALL: E/F FALL 17B1  at 229 SPRINGMEADOW DR #G, HOLBROOK  c/s: BEECH LN . . 08:39:55
VEHICLE FIRE: CAR FIRE - MULTIPLE CALLS at 24 ANNANDALE ROAD  c/s: INVERNESS ROAD . . 06:07:57

Islip Hazmat team
Contact: "bfdtecresq@aol.com" <bfdtecresq@aol.com>
HazMat 10 is OOS, HazMat 11 relocated to Fire Rescue. TFN
Hazmat: gas pumps knocked over at 125 Crooked hill road, Brentwood  c/s: Wicks road   O: 7-11 store . . 11:29:34
need a team leader to respond to brentwood fire for  gas pump knocked over at 7-11 store at 125 crooked hill road
*/

public class NYHolbrookParser extends SmsMsgParser {
  
  private static final String[] KEYWORDS = new String[]{"Loc","c/s", "O"};
  
  public NYHolbrookParser() {
    super("HOLBROOK", "NY");
  }
  
  @Override
  public String getFilter() {
    return "Paging@alpinesoftware.co";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Parser p = new Parser(body);
    String extra = p.getLastOptional(". . ");
    if (extra.length() == 0) return false;
    body = p.get();
    
    Properties props = parseMessage("Loc:" + body, KEYWORDS);
    
    p = new Parser(props.getProperty("Loc", ""));
    data.strCall = p.get(" at ").replaceAll("\\. \\.", "-");
    data.strCity = p.getLastOptional(',');
    String sAddr = p.get();
    if (sAddr.startsWith("intersection of ")) sAddr = sAddr.substring(16);
    parseAddress(sAddr, data);
    
    data.strCross = props.getProperty("c/s", "");
    data.strPlace = props.getProperty("O", "");
    
    return true;
  }
}
