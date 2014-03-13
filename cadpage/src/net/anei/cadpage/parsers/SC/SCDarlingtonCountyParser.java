
package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class SCDarlingtonCountyParser extends DispatchSouthernParser {

  public SCDarlingtonCountyParser() {
    super(CITY_LIST, "DARLINGTON COUNTY", "SC", DSFLAG_NO_NAME_PHONE);
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
    
  private static final String[] CITY_LIST = new String[]{
    "CLYDE",
    "DARLINGTON",
    "HARTSVILLE",
    "LAMAR",
    "NORTH HARTSVILLE",
    "SOCIETY HILL"

  };
}
