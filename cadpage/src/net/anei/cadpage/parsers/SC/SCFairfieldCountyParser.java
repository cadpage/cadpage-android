
package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class SCFairfieldCountyParser extends DispatchSouthernParser {

  public SCFairfieldCountyParser() {
    super(CITY_LIST, "FAIRFIELD COUNTY", "SC", DSFLAG_LEAD_UNIT);
  }

  private static final String[] CITY_LIST = new String[]{
      
      "BLACKSTOCK",
      "BLAIR",
      "BUCKLICK",
      "JENKINSVILLE",
      "MITFORD",
      "MONTICELLO",
      "RIDGEWAY",
      "WINNSBORO",
      "WINNSBORO MILLS"
      
  };
}
