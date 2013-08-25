package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GACoffeeCountyParser extends DispatchB2Parser {

  public GACoffeeCountyParser() {
    super("911-CENTER:", "COFFEE COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@coffeecountygov.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    body = body.replace(" OLD BELL LK ", " OLD BELL LAKE RD ");
    return super.parseMsg(body, data);
  }
  
  
}
