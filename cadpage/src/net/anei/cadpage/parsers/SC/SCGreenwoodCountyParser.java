package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

public class SCGreenwoodCountyParser extends DispatchSPKParser {
  
  public SCGreenwoodCountyParser() {
    super("GREENWOOD COUNTY", "SC");
  }
  
  @Override
  public String getFilter() {
    return "greenwood.county@greenwoodsc.gov";
  }
}
