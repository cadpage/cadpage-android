package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;



public class OHClermontCountyBParser extends DispatchA1Parser {
  
  public OHClermontCountyBParser() {
    super("CLERMONT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "utcc@union-township.oh.us";
  }
}
