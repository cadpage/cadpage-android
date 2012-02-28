package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


/*
Camden County, NJ (alternate)
Contact: Dave <davem@usa.net>
Sender: ccfsup@camdencounty.com

(CCCAlert) REQ FOR FM TO RESPOND - 508 MAIN AVE. BEDROOM FIRE. UNDER CONTROL.
(CCCAlert) 2 BLS UNITS AND RESCUE OPERATING AT RT 561 AND MORRIS DRIVE FOR AN OVERTURNED DUMP TRUCK ON TOP OF A VEHICLE
(CCCAlert) e1351 ol at s135 with a vehicle that has hit the side of the building reporting structural damage 
(CCCAlert) REQ FOR FM TO RESPOND - 508 MAIN AVE. BEDROOM FIRE. UNDER CONTROL.
(CCCAlert) DWELLING 1513 BRICK RD / SQ1331 ON LOCATION REPORTING  2 STY SINGLE FAMILY SMOKE SHOWING FROM FRONT DOOR

*/

public class NJCamdenCountyBParser extends SmartAddressParser {
  
  private static final int FLAG_ST_FLD_REQ = 0;

  public NJCamdenCountyBParser() {
    super("CAMDEN COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "ccfsup@camdencounty.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("CCCAlert")) return false;
    
    parseAddress(StartType.START_CALL, FLAG_ST_FLD_REQ, body, data);
    if (data.strAddress.length() == 0) return false;
    data.strSupp = getLeft();
    return true;
  }
}
