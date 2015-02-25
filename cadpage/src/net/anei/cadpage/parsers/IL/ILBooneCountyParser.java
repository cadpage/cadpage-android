package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.dispatch.DispatchA27Parser;

/**
 * Boone County, IL
 */

public class ILBooneCountyParser extends DispatchA27Parser {
  
  public ILBooneCountyParser() {
    super("BOONE COUNTY", "IL", "[A-Z]+\\d+|[A-Z]{1,3}FD(?:TEST)?");
  }
  
  @Override
  public String getFilter() {
    return "noreply@cis.com";
  }
}
