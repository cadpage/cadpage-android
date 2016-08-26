package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Dodge County, MN
 */

public class WIPeppinCountyParser extends DispatchA27Parser {
  
  public WIPeppinCountyParser() {
    super("PEPPIN COUNTY", "WI", "\\d{8}");
  }
  
  @Override
  public String getFilter() {
    return "pepinamb@pepinwisconsin.org,cisincident@co.pepin.wi.us";
  }
}
