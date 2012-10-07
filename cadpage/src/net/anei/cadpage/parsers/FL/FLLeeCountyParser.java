package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;



public class FLLeeCountyParser extends DispatchPrintrakParser {
  
  public FLLeeCountyParser() {
    super("LEE COUNTY", "FL", "XST:X");
  }
  
  @Override
  public String getFilter() {
    return "leecontrol@leegov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    int ipt = body.indexOf(" TYP:");
    if (ipt < 0) return false;
    Parser p = new Parser(body.substring(0,ipt).trim());
    data.strCallId = p.getLast(' ');
    body = body.substring(ipt+1).trim();
    
    return super.parseMsg(body, data);
  }
}
