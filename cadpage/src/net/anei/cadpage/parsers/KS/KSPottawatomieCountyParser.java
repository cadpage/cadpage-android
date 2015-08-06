package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchA25Parser;


public class KSPottawatomieCountyParser extends DispatchA25Parser {
  
  public KSPottawatomieCountyParser() {
    super("POTTAWATOMIE COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "EnterpolAlerts@atchisonlec.org";
  }

  
}
