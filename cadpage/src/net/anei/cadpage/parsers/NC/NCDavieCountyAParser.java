package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

/**
 * Davie County, NC
 */
public class NCDavieCountyAParser extends DispatchA3Parser {
  
  public NCDavieCountyAParser() {
    super("911:Call #", "DAVIE COUNTY", "NC",
           "ID Address:ADDR! APT CH! City:CITY! ( INFO1 Type:CODE! CALL! INFO1 PH#:PHONE Units:UNIT | X+ Type:X! X INFO1+ PH#:CODE% Units:CALL% IRA:NAME PHONE UNIT% INFO+ NARR:INFO ) INFO+");
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
