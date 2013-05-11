package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Clark County, OH
 */
public class OHClarkCountyParser extends DispatchA5Parser {
  
  public OHClarkCountyParser() {
    super("CLARK COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "E911-122@CI.SPRINGFIELD.OH.US";
  }
}