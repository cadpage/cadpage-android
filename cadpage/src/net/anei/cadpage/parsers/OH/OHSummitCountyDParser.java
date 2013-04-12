package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Summit County, OH
 */
public class OHSummitCountyDParser extends DispatchA5Parser {
  
  public OHSummitCountyDParser() {
    super("SUMMIT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "MAKRINOSL@STOW.OH.US";
  }
  
}