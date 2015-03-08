package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class VAGoochlandCountyParser extends DispatchOSSIParser {
  
  public VAGoochlandCountyParser() {
    super("GOOCHLAND COUNTY", "VA",
           "( CANCEL ADDR | FYI? CALL ADDR! X X ) INFO+");
  }
}
