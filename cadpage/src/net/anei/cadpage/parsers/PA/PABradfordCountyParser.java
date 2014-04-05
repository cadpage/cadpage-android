package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA4Parser;



public class PABradfordCountyParser extends DispatchA4Parser {
  
  public PABradfordCountyParser() {
    super("BRADFORD COUNTY", "PA", 2);
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.parseMsg(subject, body, data)) return false;
    data.strCity = stripFieldEnd(data.strCity, " BORO");
    return true;
  }

  @Override
  public String getFilter() {
    return "911relay@bradfordco.org";
  }

}
