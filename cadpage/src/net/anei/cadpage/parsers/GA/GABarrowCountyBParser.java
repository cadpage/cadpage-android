package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA57Parser;

public class GABarrowCountyBParser extends DispatchA57Parser {
  
  public GABarrowCountyBParser() {
    super("BARROW COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@barrowga.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!body.startsWith("Dispatch:")) return false;
    body = body.substring(9);
    return super.parseMsg(body, data);
  }
}
