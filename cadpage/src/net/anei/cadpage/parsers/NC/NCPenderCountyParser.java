package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/* 
Pender County, NC
Contact: Tripp Lanier <triper99@gmail.com>
Sender: 911-@pendersheriff.com

911-:=12-010417* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-012441* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * BRUSH/FOREST FIRE (RP 1-4)* * * FD13* * * * *
911-:=12-012596* HOLLINGSWORTH DR // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-013390* 1520 OLD MAPLE HILL RD* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009752* 5471 NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009855* 14976 NC HWY 53 EAST* * * * * * * * * ASSIST EMS* * * FD13,FD15* * * * *

*/

public class NCPenderCountyParser extends DispatchA3Parser {
  
  public NCPenderCountyParser() {
    super("PENDER COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "911-@pendersheriff.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("911-:=")) return false;
    body = body.substring(6).trim();
    return super.parseMsg(body, data);
  }
}
