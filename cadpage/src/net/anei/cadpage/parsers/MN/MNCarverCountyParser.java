package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Carver County, MN
 */

public class MNCarverCountyParser extends DispatchA27Parser {
  
  public MNCarverCountyParser() {
    super("CARVER COUNTY", "MN");
  }
  
  @Override
  public String getFilter() {
    return "relay@co.carver.mn.us";
  }
}
