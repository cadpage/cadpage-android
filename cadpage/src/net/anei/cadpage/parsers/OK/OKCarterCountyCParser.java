package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.dispatch.DispatchBCParser;

public class OKCarterCountyCParser extends DispatchBCParser {
  
  public OKCarterCountyCParser() {
    super("CARTER COUNTY", "OK");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@ARDMORECITY.ORG";
  }
}
