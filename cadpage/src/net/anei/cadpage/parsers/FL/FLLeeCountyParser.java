package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class FLLeeCountyParser extends SmartAddressParser {
  

  
  public FLLeeCountyParser() {
    super("LEE COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "leecontrol@leegov";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    

    return true;
  }
}
