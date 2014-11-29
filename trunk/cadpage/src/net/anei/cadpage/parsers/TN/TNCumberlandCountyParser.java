package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class TNCumberlandCountyParser extends DispatchGeoconxParser {
  
  public TNCumberlandCountyParser() {
    super("CUMBERLAND COUNTY", "TN");
    setupMultiWordStreets("MILLSTONE MNTN");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }
}
