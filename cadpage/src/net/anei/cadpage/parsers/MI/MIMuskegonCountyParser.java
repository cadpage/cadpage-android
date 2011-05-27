package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/*
Muskegon County, MI 
Contact: john@duffhouse.net
sender: cad@mcd911.net,9300xxxx
CAD:FYI: ;7610 EASY ST;BENSTON RD;WHITEHALL RD;MED1
CAD:FYI: ;322 E MUSKEGON AV;S LIVINGSTON ST;S BALDWIN ST;WIRED
CAD:FYI: ;1387 W HOLTON WHITEHALL RD;AUTOMOBILE RD;HYDE PARK RD;MED1
CAD:FYI: ;823 S LIVINGSTON ST;E MUSKEGON AV;E LEWIS ST;MED1
CAD:FYI: ;2715 N WEBER RD;DULEY DR;W MCMILLAN RD;FGRAS
CAD:FYI: ;4252 W BARD RD;SIMONELLI RD;ORSHAL RD;FAR
CAD:FYI: ;N WEBER RD/W MICHILLINDA RD;PI1
CAD:FYI: ;ADMIRAL PETROLEUM CO;1007 E COLBY ST;S HALL ST;PETERSON RD;PI1

CAD:FYI: ;180 W ASHLAND ST;AUBURN RD;CENTRAL RD;MED1

 */
public class MIMuskegonCountyParser extends DispatchOSSIParser {
  
  public MIMuskegonCountyParser() {
    super("MUSKEGON COUNTY", "MI",
           "SKIP PLACE? ADDR/S! X? X? CALL");
  }
  
  @Override
  public String getFilter() {
    return "cad@mcd911.net,9300";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "Unknown";
    return true;
  }
}
