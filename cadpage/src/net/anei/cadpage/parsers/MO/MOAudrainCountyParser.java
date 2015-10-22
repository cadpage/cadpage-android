package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.dispatch.DispatchA33Parser;


public class MOAudrainCountyParser extends DispatchA33Parser {
  
  
  public MOAudrainCountyParser() {
    super("AUDRAIN COUNTY", "MO", "X");
  }
  
  @Override
  public String getFilter() {
    return "CAD@AUDRAIN911.ORG,forwarding-noreply@google.com";
  }
}