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
    return "405261,81370,4058352432,4057960363";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!body.startsWith(": ")) return false;
    int pt = body.indexOf(" - From: ");
    if (pt < 0) return false;
    body = body.substring(2,pt).trim();
    
    pt = body.indexOf("- ");
    if (pt >= 0) {
      parseAddress(body.substring(0,pt).trim(), data);
      data.strCall = body.substring(pt+2).trim();
    } 
    
    else {
      parseAddress(StartType.START_CALL, FLAG_IGNORE_AT, body, data);
      if (data.strCall.length() == 0) {
        data.strCall = getLeft();
      } else {
        data.strSupp = getLeft();
      }
    }
    return (data.strCall.length() > 0 && data.strAddress.length() > 0);
  }
}
