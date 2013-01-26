package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA15Parser;


public class NCWayneCountyParser extends DispatchA15Parser {
  
  public NCWayneCountyParser() {
    super("WAYNE COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net";
  }
}
