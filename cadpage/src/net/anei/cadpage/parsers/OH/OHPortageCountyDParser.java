package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;


public class OHPortageCountyDParser extends DispatchA9Parser {

  public OHPortageCountyDParser() {
    super("PORTAGE COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "BROCMURPHY@GMAIL.COM";
  }

}
