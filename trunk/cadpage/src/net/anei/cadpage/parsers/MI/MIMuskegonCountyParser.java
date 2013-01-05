package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MIMuskegonCountyParser extends DispatchOSSIParser {
  
  public MIMuskegonCountyParser() {
    super("MUSKEGON COUNTY", "MI",
           "SKIP PLACE? ADDR/S! X? X? CALL");
  }
  
  @Override
  public String getFilter() {
    return "cad@mcd911.net,9300";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    if (! super.parseMsg(body, data)) return false;
    if (data.strCall.length() == 0) data.strCall = "Unknown";
    return true;
  }
}
