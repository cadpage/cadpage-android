package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Botetourt County, VA
 */
public class VABotetourtCountyParser extends DispatchSouthernParser {
  
  public VABotetourtCountyParser() {
    super(CITY_LIST, "BOTETOURT COUNTY", "VA", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE);
  }

  @Override
  public String getFilter() {
    return "@botetourtva.us";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BLUE RIDGE",
    "BUCHANAN",
    "CLOVERDALE",
    "DALEVILLE",
    "EAGLE ROCK",
    "FINCASTLE",
    "HOLLINS",
    "ORISKANY",
    "ROANOKE",
    "SPRINGWOOD",
    "TROUTVILLE"
  }; 
}
