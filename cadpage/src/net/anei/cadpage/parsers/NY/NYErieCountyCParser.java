package net.anei.cadpage.parsers.NY;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;



public class NYErieCountyCParser extends SmartAddressParser {
  
  private static final Pattern TRAIL_JUNK = Pattern.compile("[\\. ]+$");
  
  public NYErieCountyCParser() {
    super("ERIE COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (! body.startsWith("Erie_Alert ")) return false;
    body = body.substring(11).trim();
    if (body.endsWith("<NOREPLY>")) body = body.substring(0,body.length()-9).trim();
    body = TRAIL_JUNK.matcher(body).replaceAll("");
    
    String saveBody = body;
    
    int pt = body.indexOf(" c/s:");
    if (pt >= 0) {
      data.strCross = body.substring(pt+5).trim();
      body = body.substring(0,pt).trim();
    }
    
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT, body, data);
    data.strSupp = getLeft();
    if (getStatus() == 0) {
      return data.parseGeneralAlert(saveBody);
    }
    
    pt = data.strCall.indexOf(':');
    if (pt >= 0) {
      data.strSupp = append(data.strCall.substring(pt+1).trim(), " / ", data.strSupp);
      data.strCall = data.strCall.substring(0,pt).trim();
    }
    
    return true;
  }
}
