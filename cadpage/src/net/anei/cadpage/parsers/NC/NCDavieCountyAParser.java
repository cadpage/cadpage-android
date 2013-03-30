package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Davie County, NC
 * This appears to no longer be generated and is retained only to display historical calls 3/27/2013
 */
public class NCDavieCountyAParser extends DispatchA3Parser {
  
  public NCDavieCountyAParser() {
    super("911:Call #", "DAVIE COUNTY", "NC",
           "ID Address:ADDR! APT CH! City:CITY! X+ Type:X! X INFO+ PH#:CODE! Units:CALL! IRA:NAME PHONE UNIT% INFO+ NARR:INFO INFO+");
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
