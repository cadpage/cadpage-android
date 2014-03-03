package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class TNJeffersonCountyParser extends DispatchSouthernParser {
  
  
  public TNJeffersonCountyParser() {
    super(CITY_LIST, "JEFFERSON COUNTY", "TN", DSFLAG_OPT_DISPATCH_ID | DSFLAG_ID_OPTIONAL);
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
