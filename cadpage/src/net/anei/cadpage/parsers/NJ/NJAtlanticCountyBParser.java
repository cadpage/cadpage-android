package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.dispatch.DispatchProphoenixParser;

public class NJAtlanticCountyBParser extends DispatchProphoenixParser {
  
  public NJAtlanticCountyBParser() {
    super("ATLANTIC COUNTY", "NJ");
  }
  
  @Override
  public String getFilter() {
    return "CADAlert@townshipofhamilton.com";
  }
}
