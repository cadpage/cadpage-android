package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Davie County, NC
 */
public class NCDavieCountyBParser extends DispatchA3Parser {
  
  public NCDavieCountyBParser() {
    super(5, "911:Call#", "DAVIE COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "911@co.davie.nc.us";
  }
  
  @Override
  public String getSponsor() {
    return "Davie County";
  }
}
