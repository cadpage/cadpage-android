package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

/*
El Paso County, CO
Contact: Shane Gattis <cfpd1400@gmail.com>
Sender: ept@ept911.info
System: Tri Tech

CAL FD - Unconscious / Fainti24615 Scott Rd                Big Cats of Ser[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See " P\r
CAL FD - Medical             1222 Ververs Ln                              1481 transporting,no further resp needed,Automatic\r
CAL FD - Medical             5TH ST / CASCADE ST                          5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42\r
CAL FD - Medical             1350 8th St                                  [Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4\r
CAL FD - Chest Pain          185 4th St                    Calhan Full Gos911ALI Info: Verizon WRLS 800-451-5242, Wireless,\r

 */


public class COElPasoCountyParser extends MsgParser {
  
  public COElPasoCountyParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "ept@ept911.info";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (body.length() < 30) return false;
    if (!body.substring(6,9).equals(" - ")) return false;
    
    data.strSource = body.substring(0,6).trim();
    data.strCall = substring(body, 9, 29);
    parseAddress(substring(body, 29, 59), data);
    data.strPlace = substring(body, 59, 74);
    data.strSupp = substring(body, 74);
    return true;
  }
}
