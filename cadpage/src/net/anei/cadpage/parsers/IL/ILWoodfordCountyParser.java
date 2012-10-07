package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;



public class ILWoodfordCountyParser extends DispatchShieldwareParser {
  
  public ILWoodfordCountyParser() {
    super("WOODFORD COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "woodford911@mchsi.com";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Woodford Comm")) return false;
    return super.parseMsg(body, data);
  }
}
