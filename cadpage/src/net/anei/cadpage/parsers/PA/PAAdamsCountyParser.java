package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

/**
 * Adams County, PA
 */
public class PAAdamsCountyParser extends DispatchA1Parser {
  
  public PAAdamsCountyParser() {
    super("ADAMS COUNTY", "PA");
  }

  @Override
  public String getFilter() {
    return"alert@adams911.com,messaging@iamresponding.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    String city = data.strCity;
    if (city.toUpperCase().endsWith(" BORO")) {
      data.strCity = city.substring(0,city.length()-5).trim();
    }
    data.strSupp = data.strSupp.replace(" / ", "\n");
    return true;
  }
}
