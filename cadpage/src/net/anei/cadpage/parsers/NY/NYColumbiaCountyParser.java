package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYColumbiaCountyParser extends DispatchA13Parser {
  
  public NYColumbiaCountyParser() {
    super(CITY_LIST, "COLUMBIA COUNTY", "NY");
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
    "ANCRAM ",
    "AUSTERLITZ",
    "CANAAN ",
    "CHATHAM ",
    "CLAVERACK ",
    "CLAVERACK-RED MILLS",
    "CLERMONT ",
    "COPAKE ",
    "COPAKE ",
    "GALLATIN ",
    "GERMANTOWN ",
    "GHENT ",
    "GREENPORT ",
    "HILLSDALE ",
    "HUDSON ",
    "KINDERHOOK ",
    "LIVINGSTON ",
    "LORENZ PARK",
    "NEW LEBANON ",
    "NIVERVILLE",
    "PHILMONT ",
    "STOCKPORT ",
    "STOTTVILLE",
    "STUYVESANT ",
    "TAGHKANIC ",
    "VALATIE ",
  };
}
	