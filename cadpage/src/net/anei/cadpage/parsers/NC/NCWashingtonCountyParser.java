
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCWashingtonCountyParser extends DispatchSouthernParser {
  
  public NCWashingtonCountyParser() {
    super(CITY_LIST, "WASHINGTON COUNTY", "NC", DSFLAG_FOLLOW_CALL);
  }
  
  @Override
  public String getFilter() {
    return "@washconc.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
      "CRESWELL",
      "LEES MILL",
      "PEA RIDGE",
      "PLYMOUTH",
      "ROPER",
      "SCUPPERNONG",
      "SKINNERSVILLE"

  };
}
