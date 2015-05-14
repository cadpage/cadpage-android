package net.anei.cadpage.parsers.AZ;

import net.anei.cadpage.parsers.dispatch.DispatchA20Parser;

/**
 * Navajo County (B), AZ
 */
public class AZNavajoCountyBParser extends DispatchA20Parser {
  
  public AZNavajoCountyBParser() {
    super("NAVAJO COUNTY", "AZ");
  }
  
  @Override
  public String getFilter() {
    return "@ci.show-low.ca.us";
  }
}
