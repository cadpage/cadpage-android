package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


/*
contact: "Craig Caviness" <ccaviness@dixhillsfd.org>
sender: paging@dixhillsfd.xohost.com
2010-001784 23:36 *** 16- Rescue *** 17 BRYCEWOOD DR SPIEGEL, LORI A Dix Hills HQ ARISTA DR 31-A-1 UNCONSCIOUS / FAINTING (NEAR) CEWOOD DR DIXHIL TYPE:
2010-001779 10:34 *** 24/16- Mutual Aid *** 51 BALDWIN PATH  Dix Hills HQ
2010-001777 15:54 *** 16- Rescue ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST
2010-001778 15:54 *** 23- Misc Fire ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST
2010-001774 11:56 *** 13- Structure Fire *** 29 WHITE BIRCH DR FULGONI, MARISSA Dix Hills HQ BALSAM DR 52-B-1G ALARMS TE BIRCH DR DIXHIL TYPE: ALARMS 
2010-001766 05:54 *** 13- Structure Fire *** 29 WILDWOOD DR TRUEN, CRAIG Dix Hills HQ WHITNEY CT 60-C-1O GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) DWOOD
2010-001919 01:48 *** 16- Rescue *** 179 OAKFIELD AV BRUZZESE, ROCCO  SEAMAN NECK RD 6-D-3 RESPIRATORY KFIELD AV DIXHIL TYPE: RESPIRATORY LOC: 179  OAKFI
2010-001923 11:44 *** 16- Rescue *** 337 DEER PARK AV SUNRISE ASSISTED LIVING RED MAPLE LA Alert
2010-001991 08:42 *** 23- Misc Fire ***  CARLLS STRAIGHT PATH CARLLS STRAIGHT PA & S SERVICE RD S SERVICE RD

*** Google doesn't understand PA, translate to CARLS STRAIGHT PATH & S SERVICE RD
*/

public class NYDixHillsParser extends SmartAddressParser {
  
  public NYDixHillsParser() {
    super("DIX HILLS", "NY");
  }
  
  @Override
  public String getFilter() {
    return "paging@dixhillsfd.xohost.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 22 ||! body.substring(17, 22).equals(" *** ")) return false;
    data.strCallId = body.substring(0,11);
    data.strTime = body.substring(12,17);
    body = body.substring(22).trim();
    int pt = body.indexOf("***");
    if (pt < 0) return false;
    data.strCall = body.substring(0,pt).trim();
    body = body.substring(pt+3).trim();
    body = cleanup(body);
    parseAddress(StartType.START_ADDR, body, data);
    String sExtra = getLeft();
    pt = sExtra.indexOf(" Dix Hills ");
    if (pt >= 0) {
      data.strName = sExtra.substring(0,pt).trim();
      sExtra = sExtra.substring(pt+11).trim();
    }
    data.strSupp = sExtra;
    return true;
  }
    
    // For some totally bizarre reason, the first street of an intersection is
    // doubled and has to be cleaned up
  private String cleanup(String body) {
    
    int pt = body.indexOf(" & ");
    if (pt < 0) return body;
    
    int pta = body.indexOf(' ');
    String first = body.substring(0, pta+1);
    int ptb = body.indexOf(" " + first);
    if (ptb < 0 || ptb > pt) return body;
    return body.substring(0,ptb) + body.substring(pt);
  }
}
