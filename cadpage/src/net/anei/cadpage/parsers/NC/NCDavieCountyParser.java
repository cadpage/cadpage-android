package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Davie County, NC
 */
public class NCDavieCountyParser extends DispatchA3Parser {
  
  public NCDavieCountyParser() {
    super(4, "911:Call #", "DAVIE COUNTY", "NC");
  }
  
  @Override
  public String getSponsor() {
    return "Davie County";
  }
}
