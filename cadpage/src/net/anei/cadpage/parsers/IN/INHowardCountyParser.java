package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Howard County, IN
 */
public class INHowardCountyParser extends DispatchCiscoParser {
  
  public INHowardCountyParser() {
    super("HOWARD COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "cisco.paging@co.howard.in.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (subject.length() == 0) return false;
    body = "Ct:" + subject + " " + body;
    return super.parseMsg(body, data);
  }
}
