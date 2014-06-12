package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYMadisonCountyBParser extends DispatchA13Parser {

  private static final Pattern MISMATCH_PAREN_PTN = Pattern.compile("(\\([^\\)]*)(?=\\()");
  
  public NYMadisonCountyBParser() {
    super(CITY_LIST, "MADISON COUNTY", "NY");
  }
  
  @Override
  public String getFilter() {
    return "e-911@co.madison.ny.us,e911@madisoncounty.ny.go,messaging@iamresponding.com,e911@bounce.secureserver.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.endsWith("911 Dispatch")  && !subject.equals("Greater Lenox")) return false;
    
    // Missed right parens cause a problem.  If we find any add a closing right paren.
    body = MISMATCH_PAREN_PTN.matcher(body).replaceAll("$1)");

    if (!super.parseMsg(body, data)) return false;
    
    if (data.strCity.endsWith(" VIL")) {
      data.strCity = data.strCity.substring(0,data.strCity.length()-4).trim();
    }
    return true;

  }
  
  @Override
  public String adjustMapCity(String city) {
    if (city.equalsIgnoreCase("MORRISVILLE VILLAGE-SUNY")) {
      city = "MORRISVILLE";
    }
    return city;
  }

  private static final String[] CITY_LIST = new String[]{
    "BRIDGEPORT",
    "BROOKFIELD",
    "CANASTOTA",
    "CANASTOTA VIL",
    "CAZENOVIA",
    "CAZENOVIA VIL",
    "CHITTENANGO",
    "DERUYTER",
    "EARLVILLE",
    "EARLVILLE VIL",
    "EATON",
    "FENNER",
    "GEORGETOWN",
    "HAMILTON",
    "HAMILTON VIL",
    "LEBANON",
    "LENOX",
    "LINCOLN",
    "MADISON",
    "MADISON VIL",
    "MORRISVILLE",
    "MORRISVILLE VIL",
    "MORRISVILLE VILLAGE-SUNY",
    "MUNNSVILLE",
    "MUNNSVILLE VIL",
    "NELSON",
    "NELSON VIL",
    "ONEIDA",
    "ONEIDA CITY",
    "SMITHFIELD",
    "STOCKBRIDGE",
    "SULLIVAN",
    "WAMPSVILLE",
    "WAMPSVILLE VIL",
    "WAMPSVILLE VILLAGE"
  };
}
	