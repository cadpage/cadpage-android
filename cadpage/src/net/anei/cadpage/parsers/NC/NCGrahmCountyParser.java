package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;

/**
 * Grahm County, NC
 */
public class NCGrahmCountyParser extends DispatchGeoconxParser {
  
  public NCGrahmCountyParser() {
    super("GRAHM COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }
}
