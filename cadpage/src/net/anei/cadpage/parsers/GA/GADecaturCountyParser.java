package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class GADecaturCountyParser extends SmartAddressParser {

  public GADecaturCountyParser() {
      super("DECATUR COUNTY", "GA");
      setFieldList("CALL ADDR APT INFO");
      setupMultiWordStreets(
          "BOOSTER CLUB",
          "COOL SPRINGS"
      );
      
  }
  
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("DG911\n")) return false;
    body = body.substring(6).trim();
    int pt = body.indexOf("\n>---");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Check on how  many newlines we have
    // if exactly two, discard the first part as duplicate information
    // if more than two, reject
    String[] parts = body.split("\n");
    if (parts.length > 2) return false;
    if (parts.length == 2) body = parts[1].trim();
    
    // Use smart address parser to get what we can
    parseAddress(StartType.START_CALL, FLAG_IGNORE_AT, body, data);
    if (data.strCall.length() == 0) {
      data.strCall = getLeft();
    } else {
      data.strSupp = getLeft();
    }
    return true;
  }
}
