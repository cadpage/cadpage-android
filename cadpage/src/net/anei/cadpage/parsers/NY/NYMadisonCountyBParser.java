package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;




public class NYMadisonCountyBParser extends DispatchA13Parser {
  
  public NYMadisonCountyBParser() {
    super("MADISON COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 Dispatch")) return false;
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.endsWith(" VIL")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    }
    return true;

  }
}
	