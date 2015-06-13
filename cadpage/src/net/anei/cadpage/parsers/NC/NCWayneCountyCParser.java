package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.HtmlProgramParser;


public class NCWayneCountyCParser extends HtmlProgramParser {
  
  public NCWayneCountyCParser() {
    super("WAYNE COUNTY", "NC",
          "");
  }
  
  @Override
  public String getFilter() {
    return "waynecounty911@waynegov.com";
  }
}
