package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYWashingtonCountyParser extends DispatchA13Parser {
  
  public NYWashingtonCountyParser() {
    super("WASHINGTON COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "911commcenter@co.washington.ny.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    int pt = body.indexOf("\n\nTo unsubscribe");
    if (pt >= 0) body = body.substring(0,pt).trim();
    return super.parseMsg(body, data);
  }
}
	