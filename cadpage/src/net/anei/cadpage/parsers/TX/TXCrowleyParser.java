package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA18Parser;


public class TXCrowleyParser extends DispatchA18Parser {
  
  public TXCrowleyParser() {
    super(CITY_LIST, "CROWLEY","TX");
  }
 
  @Override
  public String getFilter() {
    return "crimespaging@ci.crowley.tx.us";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.endsWith(" CO")) data.strCity += "UNTY";
    else if (data.strCity.endsWith(" Co")) data.strCity += "unty";
    return true;
  }

  private static String[] CITY_LIST = new String[]{
    "BURLESON",
    "CROWLEY",
    
    "JOHNSON CO"
  };
}
