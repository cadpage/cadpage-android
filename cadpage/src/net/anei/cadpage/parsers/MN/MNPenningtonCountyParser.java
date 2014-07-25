package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Otter Tail County, MN
 */

public class MNPenningtonCountyParser extends DispatchA27Parser {
  
  public MNPenningtonCountyParser() {
    super(CITY_LIST, "PENNINGTON COUNTY", "MN", "\\d{8}");
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
