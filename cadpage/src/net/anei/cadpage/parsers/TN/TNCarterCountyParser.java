package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class TNCarterCountyParser extends DispatchGeoconxParser {
  
  public TNCarterCountyParser() {
    super("CARTER COUNTY", "TN", GCX_FLG_NAME_PHONE);
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  } 
}
