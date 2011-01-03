package net.anei.cadpage.parsers;

import net.anei.cadpage.SmsMsgInfo.Data;

/****
Southhampton Village, NY
Contact: Chris Mckay <ccmckay18@gmail.com>
Sender: paging@alpinesoftware.com
Can probably use Rocky Point, NY parser
1- ALARM - GENERAL at 64 COUNTY RD 39, SOUTHAMPTON  c/s: NORTH SEA RD   O: HAMPTONS CENTER FOR REHAB . . 11:09:34

2- STRUCTURE FIRE, RESIDENTIAL at 133 North Magee St, Southampton  c/s: Sebonic Inlet Rd . . 16:42:18

3- MISC ALARM, GAS LEAK at 271 Gin . . 09:24:18

4- ALARM - GENERAL at 151 WINDMILL LN, SOUTHAMPTON  c/s: JAGGER LN   O: SVPD HQ . . 12:02:10

5- STRUCTURE FIRE, RESIDENTIAL at HILL ST / CAPTAINS NECK LN, SOUTHAMPTON . . 15:36:34
****/

public class NYSouthhamptonVillageParser extends SmartAddressParser {
  
  private static final String DEF_STATE = "NY";
  private static final String DEF_CITY = "SOUTHHAMPTON";
  
  public NYSouthhamptonVillageParser() {
    super(DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "paging@alpinesoftware.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {

    int idx = 0;
    idx = body.indexOf(" at ");
    if (idx >= 0){
      if (body.substring(0,idx).contains(",")){
          body = body.replaceFirst(",","-");
      }
    }
    Parser p = new Parser(body);
    
    // Drop call time at end of message
    if (p.getLastOptional(" . . ").length() == 0) return false;
 
    // get everything else
    data.strSupp = p.getLastOptional(" O:");
    data.strCross = p.getLastOptional(" c/s:");
    data.strCity = p.getLastOptional(',');
    data.strAddress = p.getLastOptional(" at ");
    data.strCall = p.get();
    
    return true;
  }
}
