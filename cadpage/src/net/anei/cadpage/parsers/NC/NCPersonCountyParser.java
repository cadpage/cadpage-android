package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class NCPersonCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "ROXBORO",
    
    "ALLENSVILLE",
    "BUSHY FORK",
    "CUNNINGHAM",
    "FLAT RIVER",
    "HOLLOWAY",
    "MT TIRZAH",
    "OLIVE HILL",
    "WOODSDALE",
    
    "HURDLE MILLS",
    "LEASBURG",
    "ROUGEMONT",
    "SEMORA",
    "TIMBERLAKE"
  };

  public NCPersonCountyParser() {
    super(CITY_LIST, "PERSON COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL |  DSFLAG_FOLLOW_CROSS);
  }

}
