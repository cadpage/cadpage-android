package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Monmouth County, NJ
 */
public class NJMonmouthCountyAParser extends DispatchA5Parser {
  
  public NJMonmouthCountyAParser() {
    super("MONMOUTH COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "@MCSONJ.ORG";
  }
}
