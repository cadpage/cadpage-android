package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Roanoke City, VA
 */
public class VARoanokeCityParser extends SmartAddressParser {
  
  public VARoanokeCityParser() {
    super("ROANOKE CITY", "VA");
    setFieldList("CALL ADDR APT INFO");
  }
  
  @Override
  public String getFilter() {
    return "e911@roanokeva.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("E-911")) return false;
    int pt = body.indexOf(" [Att");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    if (body.length() < 21 || body.charAt(20) != ' ') return false;
    data.strCall = body.substring(0,20).trim();
    body = body.substring(21).trim();
    
    pt = body.indexOf(" Original Location :");
    if (pt >= 0) {
      parseAddress(body.substring(0,pt).trim(), data);
      data.strSupp = body.substring(pt+20).trim();
    } else {
      parseAddress(StartType.START_ADDR, body, data);
      data.strSupp = getLeft();
    }
    return true;
  }
}
