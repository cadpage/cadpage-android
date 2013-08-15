package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchGeoconxParser;


public class TNCampbellCountyParser extends DispatchGeoconxParser {
  
  public TNCampbellCountyParser() {
    super("CAMPBELL COUNTY", "TN");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (! super.parseMsg(subject, body, data)) return false;
    
    // Dispatch requests caller name not be included in result
    data.strName = "";
    return true;
  }

  @Override
  public String getFilter() {
    return "dispatch@911email.net";
  }
}
