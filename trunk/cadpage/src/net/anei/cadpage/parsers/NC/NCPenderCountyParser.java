package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Pender County, NC
 */
public class NCPenderCountyParser extends DispatchA3Parser {
  
  public NCPenderCountyParser() {
    super(0, "911-:=", "PENDER COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "911-@pendersheriff.com";
  }
}
