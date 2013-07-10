package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Warren County, OH
 */
public class OHWarrenCountyAParser extends DispatchPrintrakParser {
  
  public OHWarrenCountyAParser() {
    super("WARREN COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "WCPSN@wcoh.net,Notifications@wcoh.net";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strSource = "";
    return true;
  }
}
