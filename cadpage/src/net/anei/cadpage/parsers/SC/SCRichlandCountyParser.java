package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Richland county, SC (Columbia)
Contact: Dylan Miller <dylan.miller86@gmail.com>
Sender: 2002000004

RESD STRUCTURE FIRE (FLAMES SHOWING) - 1 SHAFTESBURY LN / BROWN
SUSPICIOUS PACKAGE FOUND AT 7201 TWO NOTCH RD AT RCSD PARKING LOT / BROWN

Address: 731 Horrell Hill Rd Problem: Seizure
Address: 108 Kildare Dr Problem: Insulin Shock
Address: Padgett Rd / Lower Richland Blvd Problem: Woods Fire
Address: Caughman Rd / Teague Rd Problem: MVA
Address: Garners Ferry Rd / Trotter Rd Problem: MVA
Address: 8100 Garners Ferry Rd Problem: MVA
Address: 217 Tilting Rock Dr Problem: Structure Fire - House
Address: Welborn Rd / Leesburg Rd Problem: Fire Test
Address: Fairmont Rd / Leesburg Rd Problem: MVA
Address: Leesburg Rd / Ulmer Rd Problem: MVA
Address: 8000 Garners Ferry Rd Problem: Head Injury
Address: 145 Ramblewood Dr Problem: Seizure
Address: 305 Shagbark Ave Problem: Coronary
Address: 3644 Leesburg Rd Problem: Spinal Injury
Address: 1114 Rabbit Run Problem: False Fire Alarm
Address: Ridge Rd / Lower Richland Blvd Problem: Vehicle Fire Trailer/Bus/MHome

*/

public class SCRichlandCountyParser extends FieldProgramParser {
 
  public SCRichlandCountyParser() {
    super("RICHLAND COUNTY", "SC",
          "Address:ADDR! Problem:CALL!");
  }
  
  @Override
  public String getFilter() {
    return "2002000004";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // If the regular message parser handles this all is well
    if (super.parseMsg(body, data)) return true;
    
    // If not, see if we can get this through a general type parser
    // Which will only accept it caller has identified this as a dispatch page
    if (!isPositiveId()) return false;
    
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT | FLAG_NO_IMPLIED_APT, body, data);
    if (data.strAddress.length() == 0) return false;
    data.strSupp = getLeft();
    return true;
  }
}
