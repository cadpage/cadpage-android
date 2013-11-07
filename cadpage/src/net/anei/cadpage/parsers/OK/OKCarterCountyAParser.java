package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;

public class OKCarterCountyAParser extends DispatchA33Parser {

  public OKCarterCountyAParser() {
    super("CARTER COUNTY", "OK", "X");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@ARDMORECITY.ORG";
  }
}
