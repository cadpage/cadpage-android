

package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franklin County, NC
 */

public class NCFranklinCountyParser extends DispatchSouthernParser {

  public NCFranklinCountyParser() {
    super(CITY_LIST, "FRANKLIN COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_NO_NAME_PHONE | DSFLAG_ID_OPTIONAL);
    
    
  }
  @Override
  public String getFilter() {
    return "@franklincountync.us";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and Towns
    "BUNN",
    "CENTERVILLE",
    "FRANKLINTON",
    "LOUISBURG",
    "WAKE FOREST", 
    "YOUNGSVILLE"
    
     };
}
