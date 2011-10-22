package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Loudon County, TN
Contact: Mark Howard <mhoward562@gmail.com>
Sender: @loudoncounty911.org

S: M:KHICKS:8069 HUFFS FERRY RD NORTH LOUDON 2011028604 18:12:18 FIRE ALARM RES/SCOTT PH/988-8351 AREA/GENERAL FIRE
S: M:KHICKS:8533 POND CREEK RD PHILADELPHIA 2011035525 15:28:16 STRUCTURE FIRE UNK WHAT STARTED THE FIRE
S: M:JBLAKESLEE:1 WHITE WING RD//BIRD RD LENOIR CITY 2011030010 22:52:18 SMOKE INVESTIGATION COMPL SMELLS SMOKE IN THE ARE

*/

public class TNLoudonCountyParser extends DispatchSouthernParser {
  
  
  public TNLoudonCountyParser() {
    super(CITY_LIST, "LOUDON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "@loudoncounty911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replaceAll("//+", "/");
    return super.parseMsg(body, data);
  }
  

  private static final String[] CITY_LIST = new String[]{
    "GREENBACK",
    "LENOIR CITY",
    "LOUDON",
    "PHILADELPHIA",
    
    "DIXIE LEE JUNCTION",
    "MORGANTON",
    "TELLICO VILLAGE"
  };

}
