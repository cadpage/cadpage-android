package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCTransylvaniaCountyParser extends DispatchSouthernParser {
  
  public NCTransylvaniaCountyParser() {
    super(CITY_LIST, "TRANSYLVANIA COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BALSAM GROVE",
    "BREVARD CITY",
    "LITTLE RIVER",
    "PISGAH FOREST",
    "ROSMAN"
  };

}
