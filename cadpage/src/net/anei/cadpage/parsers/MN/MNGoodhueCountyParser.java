package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Goodhue County, MN
 */

public class MNGoodhueCountyParser extends DispatchA27Parser {
  
  public MNGoodhueCountyParser() {
    super("GOODHUE COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cisusa.org";
  }
}
