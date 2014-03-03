package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class TNUnionCountyParser extends DispatchGeoconxParser {
  
  public TNUnionCountyParser() {
    super("UNION COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }
}
