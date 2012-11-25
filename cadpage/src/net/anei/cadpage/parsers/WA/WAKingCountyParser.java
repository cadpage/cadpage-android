package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class WAKingCountyParser extends MsgParser {
  
  public WAKingCountyParser() {
    super("KING COUNTY", "WA");
  }
  
  @Override
  public String getFilter() {
    return "CAD@bellevuewa.gov";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.length() < 102) return false;
    if (body.charAt(50) != '#') return false;
    if (body.charAt(60) != ' ') return false;
    if (body.charAt(90) != ' ') return false;
    if (body.charAt(100) != ' ') return false;
    
    parseAddress(substring(body, 0, 50), data);
    data.strApt = substring(body, 51, 60);
    data.strCall = substring(body, 61, 90);
    data.strUnit = substring(body, 101);
    return true;
  }
}
