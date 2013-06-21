package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYMadisonCountyBParser extends DispatchA13Parser {
  
  public NYMadisonCountyBParser() {
    super(CITY_LIST, "MADISON COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 Dispatch")  && !subject.equals("Greater Lenox")) return false;
    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.endsWith(" VIL")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    }
    return true;

  }
  
  private static final String[] CITY_LIST = new String[]{
    "BRIDGEPORT",
    "BROOKFIELD",
    "CANASTOTA",
    "CAZENOVIA",
    "CAZENOVIA",
    "CHITTENANGO",
    "DERUYTER",
    "DERUYTER",
    "EARLVILLE",
    "EATON",
    "FENNER",
    "GEORGETOWN",
    "HAMILTON",
    "HAMILTON",
    "LEBANON",
    "LENOX",
    "LINCOLN",
    "MADISON",
    "MADISON",
    "MORRISVILLE",
    "MUNNSVILLE",
    "NELSON",
    "ONEIDA",
    "ONEIDA CITY",
    "SMITHFIELD",
    "STOCKBRIDGE",
    "SULLIVAN",
    "WAMPSVILLE",
  };
}
	