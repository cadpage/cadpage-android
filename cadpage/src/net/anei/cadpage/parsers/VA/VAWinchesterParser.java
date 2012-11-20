package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;



public class VAWinchesterParser extends DispatchShieldwareParser {
    
  
  public VAWinchesterParser() {
    super("WINCHESTER", "VA");
  }
  
  @Override
  public String getFilter() {
    return "winecc@ci.winchester.va.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.equals("Winchester ECC info")) return false;
    return super.parseMsg(body, data);
  }
}
