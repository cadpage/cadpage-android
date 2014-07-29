package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Pennington County, MN
 */

public class MNPenningtonCountyParser extends DispatchA27Parser {
  
  public MNPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "MN", "S\\d{4}");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }


  private static final String[] CITY_LIST = new String[]{
    "GOODRIDGE",
    "RED LAKE FALLS",  
    "ST HILAIRE",
    "THIEF RIVER FALLS"
  };
  
}
