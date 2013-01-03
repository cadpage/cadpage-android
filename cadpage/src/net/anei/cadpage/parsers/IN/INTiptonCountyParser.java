package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class INTiptonCountyParser extends DispatchOSSIParser {
  
  public INTiptonCountyParser() {
    super("TIPTON COUNTY", "IN",
           "UNIT CALL ID ADDR INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@tipco.com";
  }
}
