

package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Chattam County, NC
 */
public class NCChathamCountyParser extends DispatchSouthernParser {

  public NCChathamCountyParser() {
    super(CITY_LIST, "CHATHAM COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_NO_NAME_PHONE);
    
    
  }
  @Override
  public String getFilter() {
    return "@chathamnc.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    "FEARRINGTON",
    "GOLDSTON",
    "PITTSBORO",
    "SILER CITY",
    "CHAPEL HILL",
    
    "BEAR CREEK",
    "BENNETT",
    "BONLEE",
    "BRICKHAVEN",
    "BYNUM",
    "CARBONTON",
    "CORINTH",
    "CRUTCHFIELD CROSSROADS",
    "GULF",
    "HAYWOOD",
    "MONCURE",
    "SILK HOPE",
    "WILSONVILLE"
  };
}
