package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

public class VAStauntonParser extends DispatchOSSIParser {
  
  public VAStauntonParser() {
    super("STAUNTON", "VA", 
          "ADDR CITY CALL! INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@staunton.net";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("Text Message")) return false;
    return super.parseMsg("CAD:" + body, data);
  }
}
