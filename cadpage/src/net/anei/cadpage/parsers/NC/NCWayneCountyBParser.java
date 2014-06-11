package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NCWayneCountyBParser extends DispatchA13Parser {
  
  public NCWayneCountyBParser() {
    super("WAYNE COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CC_Message_Notification@usamobility.net,waynecounty911@waynegov.com";
  }
}
