package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Montgomery County, NC
Contact: Kyle Morris <wildlandfire09@gmail.com>
Sender: @montgomerycountync.com

CAD:DAYS INN 531 EAST MAIN ST 105 BISCOE 14:14:20 ASSAULT - SEXUAL ASSAULT man an woman was fighting and then fm turned on caller.
CAD:1344 NC HWY 109 S MT GILEAD MDL 09E01 19:26:03 CARDIAC OR RESPIRATORY ARREST - DEATH
CAD:1344 NC HWY 109 S MT GILEAD 19:21:52 UNCONSCIOUS - FAINTING (NEAR) E
CAD:348 AUMAN RD BISCOE 17:25:35 ASSAULT - SEXUAL ASSAULT ASSAULT CALLERS SON GAVE FM BLACK EYE

Contact: mike barrington <michael.barrington509@gmail.com>
Sender: CAD@montgomerycountync.com
CAD:217 BRUTONVILLE CHURCH ST CANDOR 20:52:18 SMOKE INVESTIGATION (OUTSIDE) ADV THERE IS SMOKE AND IT IS MAKING HER SICK FROM FIRE EARLIER TODAY
 
Contact: "Robert" <robert.george@montgomerycountync.com>
Sender: CAD@montgomerycountync.com
CAD:232 HARPER ST STAR 15:48:25 COMMUNICATING THREATS CALE HARRIS EX HUSBAND JUST PULLED GUN :1of2


*/

public class NCMontgomeryCountyParser extends DispatchSouthernParser {
  
  
  public NCMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL | DSFLAG_LEAD_PLACE);
  }
  
  @Override
  public String getFilter() {
    return "@montgomerycountync.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("CAD:")) return false;
    return super.parseMsg(body, data);
  }
  
  @Override
  protected void parseExtra(String sExtra, Data data) {
    Parser p = new Parser(sExtra);
    data.strCall = p.get(" - ");
    data.strSupp = p.get();
  }

  private static final String[] CITY_LIST = new String[] {
    "BISCOE",
    "BLACK ANKLE",
    "CANDOR",
    "ETHER",
    "JACKSON SPRINGS",
    "MT GILEAD",
    "NEW LONDON",
    "OKEEWEMEE",
    "OPHIR",
    "PEE DEE",
    "SEAGROVE",
    "STAR",
    "STEEDS",
    "TROY",
    "WINDBLOW"
  };
}
