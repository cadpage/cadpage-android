package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Nassau County, NY (version B)
Contact: Tommy Johnson <tjohnson377.tj@gmail.com>
Sender: paging@alpinesoftware.com

FireCom:  3 HUDSON ST E (GENERAL-AUTO) FIRE ALARM RINGING
FireCom:  31 MUNSON PL (SIG 9-AMBU) 20F ABDOMINAL PAINS
FireCom: THE FISHERY 1 MAIN ST (SIG 9-AMBU) MALE FELL-FX WRIST 
FireCom:  528 ATLANTIC AVE (SIG 9-AMBU) BACK DOOR DIFF BREATHING
FireCom:  RHAME AVE (DISTRIC-HAZM) SW CORNER/SEWER-ILLEGALE DUMPING
FireCom:  22 RIVERSIDE ROAD (SIG 9-AMBU) DEHYDRATED MA
FireCom:  65 EMMET AVE (GENERAL-AUTO) ESTRIN RES/40A024

*/


public class NYNassauCountyBParser extends SmsMsgParser {

  public NYNassauCountyBParser() {
    super("NASSAU COUNTY", "NY");
  }
  
  public String getFilter() {
    return "paging@alpinesoftware.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("FireCom:")) return false;
    body = body.substring(8);
    
    int pt1 = body.indexOf('(');
    if (pt1 < 0) return false;
    int pt2 =  body.indexOf(')', pt1+1);
    if (pt2 < 0) return false;
    
    String sAddr = body.substring(0,pt1).trim();
    parseAddress(sAddr, data);
    data.strCall = body.substring(pt1+1,pt2).trim();
    data.strSupp = body.substring(pt2+1).trim();

    return true;
  }
}


