package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Ventura County, CA
 */
public class CAVenturaCountyParser extends MsgParser {
  
  public CAVenturaCountyParser() {
    super("VENTURA COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "Fcc-do-not-reply@Ventura.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.equals("FCC Page")) break;
      
      if (body.startsWith("FCC Page / ")) {
        body = body.substring(11).trim();
        break;
      }
      return false;
    } while (false);
    
    if (!body.startsWith("Incident Dispatch: ")) return false;
    if (body.length() < 94) return false;
    data.strUnit = body.substring(19,27).trim();
    data.strCall = body.substring(27,38).trim();
    parseAddress(body.substring(38,69).trim(), data);
    data.strMap = body.substring(69,77).trim();
    data.strChannel = body.substring(77,84).trim();
    data.strCallId = body.substring(84).trim();
    return true;
  }
}
