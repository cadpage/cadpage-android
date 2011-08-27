package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Jefferson County, TN
Contact: "jcfd560@yahoo.com" <jcfd560@yahoo.com>
Sender: DISPATCH@jeffersoncountytn.gov
DISPATCH:1718 BROOKLINE CT JEFFERSON CITY 2011-611597 22:43:08  BREATHING DIFFICULTY
DISPATCH:675 E BROADWAY BLVD JEFFERSON CITY 2011-613869 11:31:12 FIRE BRUSH  GRASS FOREST
DISPATCH:1727 EASLEY RD JEFFERSON CITY 2011-613628 20:57:53 FIRE SMOKE INVESTIGATION

Contact: "thnozzleman@bellsouth.net" <thnozzleman@bellsouth.net>
DISPATCH:283 W BROADWAY BLVD 513 JEFFERSON CITY 08:00:21 CARDIAC ARREST CPR IN USE


*/

public class TNJeffersonCountyParser extends DispatchSouthernParser {
  
  
  public TNJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "TN", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@jeffersoncountytn.gov";
  }
  

  private static final String[] CITY_LIST = new String[]{
    "JEFFERSON CITY",
    "CHESTNUT HILL",
    "DANDRIDGE",
    "NEW MARKET",
    "PIEDMONT",
    "STRAWBERRY PLAINS",
    "TALBOTT",
    "WHITE PINE"
  };

}
