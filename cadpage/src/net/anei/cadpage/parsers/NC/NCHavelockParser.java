package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;

/**
 * Havelock, NC
 */

public class NCHavelockParser extends DispatchA9Parser {
    
   
  public NCHavelockParser() {
    super("CRAVEN COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "egov-info@havelocknc.us,egovinfo@havelocknc.us";
  }

  @Override
  protected int getExtraParseAddressFlags() {
    return FLAG_ALLOW_DUAL_DIRECTIONS;
  }
  
  
  
}
