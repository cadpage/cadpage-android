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

Contact: Active911.com
FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:542 COUNTY LINE RD DANDRIDGE 10:47:55 SICK PERSON (SPECIFIC DIAGNOSIS)\r\n
FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:4800 TIMBER WAY SEVIERVILLE 20:28:20 CHEST PAIN HEART PROBLEMS\r\n
FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:542 COUNTY LINE RD DANDRIDGE 10:01:21 STROKE (CVA)\r\n

*/

public class TNJeffersonCountyParser extends DispatchSouthernParser {
  
  
  public TNJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "TN", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL);
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@jeffersoncountytn911.org";
  }
  

  private static final String[] CITY_LIST = new String[]{
    "JEFFERSON CITY",
    "CHESTNUT HILL",
    "DANDRIDGE",
    "NEW MARKET",
    "PIEDMONT",
    "SEVIERVILLE",
    "STRAWBERRY PLAINS",
    "TALBOTT",
    "WHITE PINE"
  };

}
