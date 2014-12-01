package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA4Parser;



public class PABradfordCountyParser extends DispatchA4Parser {
  
  public PABradfordCountyParser() {
    super("BRADFORD COUNTY", "PA", 2);
    setupMultiWordStreets(
        "ROUND TOP",
        "WOLCOT HOLLOW");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    if (data.strAddress.endsWith("]")) {
      int pt = data.strAddress.indexOf("[");
      if (pt >= 0) data.strAddress = data.strAddress.substring(0,pt).trim();
    }
    data.strCity = stripFieldEnd(data.strCity, " BORO");
    return true;
  }

  @Override
  public String getFilter() {
    return "911relay@bradfordco.org";
  }

}
