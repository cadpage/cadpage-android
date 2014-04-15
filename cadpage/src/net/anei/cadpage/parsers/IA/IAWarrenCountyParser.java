package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA38Parser;



public class IAWarrenCountyParser extends DispatchA38Parser {
  
  public IAWarrenCountyParser() {
    super("WARREN COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    data.strSource = subject;
    
    // Fix up some IAR scrambling :(
    if (body.startsWith(":")) {
      body = "CFS#: 0000-00000\nCallType" + body;
    }
    
    if (!super.parseMsg(body, data)) return false;
    if (data.strCallId.equals("0000-00000")) data.strCallId = "";
    return true;
  }
  
  @Override
  public String getProgram() {
    return "SRC " + super.getProgram();
  }
}
