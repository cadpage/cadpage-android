package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class TNCampbellCountyParser extends DispatchGeoconxParser {
  
  public TNCampbellCountyParser() {
    super("CAMPBELL COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }
}
