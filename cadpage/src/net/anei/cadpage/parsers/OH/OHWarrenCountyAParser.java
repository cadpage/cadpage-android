package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Warren County, OH
 */
public class OHWarrenCountyAParser extends DispatchPrintrakParser {
  
  public OHWarrenCountyAParser() {
    super("WARREN COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "WCPSN@wcoh.net,Notifications@wcoh.net,Mark.Greatorex@htfire.com";
  }
}
