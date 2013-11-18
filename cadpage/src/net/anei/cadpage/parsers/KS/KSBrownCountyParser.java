package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class KSBrownCountyParser extends DispatchA25Parser {
  
  public KSBrownCountyParser() {
    super("BROWN COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "EnterpolAlerts@brownso.org";
  }
}
