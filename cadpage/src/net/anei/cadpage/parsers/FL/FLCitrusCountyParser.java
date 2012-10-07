package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;


public class FLCitrusCountyParser extends DispatchPrintrakParser {
  
  public FLCitrusCountyParser() {
    super("CITRUS COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net";
  }
}
