package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class WAKingCountyAParser extends MsgParser {
  
  public WAKingCountyAParser() {
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
    if (!isStartField(body, 61)) return false;
    int endCity = isStartField(body, 91) ? 61 : 96;
    if (!isStartField(body, endCity+30)) return false;
    if (!isStartField(body, endCity+40)) return false;
    
    parseAddress(substring(body, 0, 50), data);
    data.strApt = substring(body, 51, 60);
    data.strCity = substring(body, 61, endCity);
    data.strCall = substring(body, endCity, endCity+29);
    data.strUnit = substring(body, endCity+40);
    return true;
  }
  
  private boolean isStartField(String body, int pt) {
    if (body.length() <= pt) return false;
    if (body.charAt(pt) == ' ') return false;
    if (body.charAt(pt-1) != ' ') return false;
    return true;
  }
}
