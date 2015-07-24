package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class SCMcCormickCountyParser extends DispatchGeoconxParser {
  
  public SCMcCormickCountyParser() {
    super("MCCORMICK COUNTY", "SC", GCX_FLG_NAME_PHONE);
  }

  @Override
  public String getFilter() {
    return "dispatch@911email.org";
  }
  
}
