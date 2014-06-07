package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Franklin County, VA
 */
public class VAFranklinCountyBParser extends DispatchSouthernParser {
  
  public VAFranklinCountyBParser() {
    super(CITY_LIST, "FRANKLIN COUNTY", "VA", DSFLAG_NO_NAME_PHONE);
  }
      
  
  @Override
  public String getFilter() {
    return "911@FCSO.COM";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  private static String[] CITY_LIST = new String[]{

    // Cities
    "BOONES MILL",
    "ROCKY MOUNT",

    // Unincorporated communities
    "BENT MOUNTAIN",
    "CALLAWAY",
    "FERRUM",
    "GLADE HILL",
    "HALES FORD",
    "NORTH SHORE",
    "PENHOOK",
    "REDWOOD",
    "SNOW CREEK",
    "UNION HALL",
    "WESTLAKE CORNER",
    "WIRTZ",
    
    // Bedford County
    "MONETA"

  };

}