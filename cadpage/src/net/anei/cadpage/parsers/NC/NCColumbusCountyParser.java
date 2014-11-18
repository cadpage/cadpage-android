
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCColumbusCountyParser extends DispatchSouthernParser {

  public NCColumbusCountyParser() {
    super(CITY_LIST, "COLUMBUS COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_CROSS_NAME_PHONE);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BOARDMAN",
    "BOLTON",
    "BRUNSWICK",
    "CERRO GORDO",
    "CHADBOURN",
    "FAIR BLUFF",
    "LAKE WACCAMAW",
    "SANDYFIELD",
    "TABOR CITY",
    "WHITEVILLE"
  };
}
