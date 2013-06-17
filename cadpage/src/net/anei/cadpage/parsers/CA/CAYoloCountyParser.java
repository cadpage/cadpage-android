package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Yolo County, CA
 */
public class CAYoloCountyParser extends DispatchA20Parser {
  
  public CAYoloCountyParser() {
    super("YOLO COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "CLARK@ci.davis.ca.us";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
}
