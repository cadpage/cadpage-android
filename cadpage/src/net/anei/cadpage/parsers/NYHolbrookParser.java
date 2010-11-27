package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;
/*
Holbrook FD, NY (Suffolk County franchise)
Contact: "bfdtecresq@aol.com" <bfdtecresq@aol.com>
Sender: Paging@alpinesoftware.com
MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57
WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36
WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21
AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14
*/

public class NYHolbrookParser extends SmsMsgParser {
  
  @Override
  public String getFilter() {
    return "Paging@alpinesoftware.co";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    data.defCity="HOLBROOK";
    data.defState="NY";
    
    Parser p = new Parser(body);
    p.getLast(". . ");
    data.strCall = p.get(" at ").replaceAll("\\. \\.", "-");
    String sAddr = p.get();
    if (sAddr.startsWith("intersection of ")) sAddr = sAddr.substring(16);
    parseAddress(sAddr, data);
    
    return true;
  }
}
