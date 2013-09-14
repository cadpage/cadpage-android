package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Stark County, IL
 */
public class ILStarkCountyParser extends DispatchA29Parser {
  
  public ILStarkCountyParser() {
    super("STARK COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
}
