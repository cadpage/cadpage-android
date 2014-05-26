package net.anei.cadpage.parsers.OK;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class OKOklahomaCountyParser extends SmartAddressParser {
  
  public OKOklahomaCountyParser() {
    super("OKLAHOMA COUNTY", "OK");
    addRoadSuffixTerms("NEST", "VISTA");
    setFieldList("CALL ADDR APT INFO");
  }
  
  @Override
  public String getFilter() {
    return "405261,81370";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!body.startsWith(": ")) return false;
    if (!body.endsWith(" - From: OCSO Dispatch")) return false;
    body = body.substring(2,body.length()-22).trim();
    parseAddress(StartType.START_CALL, body, data);
    if (data.strCall.length() == 0) {
      data.strCall = getLeft();
    } else {
      data.strSupp = getLeft();
    }
    return (data.strCall.length() > 0 && data.strAddress.length() > 0);
  }
}
