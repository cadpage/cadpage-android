package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Monmouth County, NJ
 */
public class NJMonmouthCountyAParserOld extends DispatchA5Parser {
  
  public NJMonmouthCountyAParserOld() {
    super("MONMOUTH COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "@MCSONJ.ORG";
  }
}
