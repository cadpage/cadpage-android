package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.dispatch.DispatchProQAParser;


public class CONorthglennEMSParser extends DispatchProQAParser {
  
  public CONorthglennEMSParser() {
    super("ADAMS COUNTY", "CO",
           "ADDR CALL! CALL+");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@northglennambulance.com";
  }
}
