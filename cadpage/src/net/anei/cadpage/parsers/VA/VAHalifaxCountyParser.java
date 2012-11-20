package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchShieldwareParser;


public class VAHalifaxCountyParser extends DispatchShieldwareParser {
  
  public VAHalifaxCountyParser() {
    super("HALIFAX COUNTY", "VA", FLG_NO_UNIT);
  }
  
  @Override
  public String getFilter() {
    return "halifaxeoc@co.halifax.va.us";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("from Central")) return false;
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.toUpperCase().startsWith("TURBEVILLE")) data.strCity = data.strCity.substring(0,10);
    return true;
  }
}