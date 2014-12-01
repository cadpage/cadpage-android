

package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Chattam County, NC
 */
public class NCCaswellCountyParser extends DispatchSouthernParser {

  public NCCaswellCountyParser() {
    super(CITY_LIST, "CASWELL COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_NO_NAME_PHONE);
    
    
  }
  @Override
  public String getFilter() {
    return "@caswellcountync.gov";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "MILTON",
    "YANCEYVILLE",
    
    // Townships
    "ANDERSON TWP",
    "HIGHTOWERS TWP",
    "LEASBURG TWP",
    "LOCUST HILL TWP",
    "PROVIDENCE TWP",
    "MILTON TWP",
    "PELHAM TWP",
    "STONEY CREEK TWP",
    "YANCEYVILLE TWP",

    // Unincorporated
    "CASVILLE",
    "LEASBURG",
    "PELHAM",
    "PROSPECT HILL",
    "PROVIDENCE",
    "PURLEY",
    "SEMORA",
    "CHERRY GROVE",
    "BLANCH"
  };
}
