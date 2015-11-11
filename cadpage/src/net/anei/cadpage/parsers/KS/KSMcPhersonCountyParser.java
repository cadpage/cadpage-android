package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

/**
 * Whitfield County, FL
 */

public class KSMcPhersonCountyParser extends DispatchSPKParser {
  
  public KSMcPhersonCountyParser() {
    super("MCPHERSON COUNTY", "KS");
  }
  
  @Override
  public String getFilter() {
    return "mcpherson911@mcphersoncountyks.us";
  }

}
