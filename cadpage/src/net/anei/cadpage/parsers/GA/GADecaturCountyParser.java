package net.anei.cadpage.parsers.GA;

import java.util.regex.Pattern;

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
  
  private static final Pattern MISSING_BLANK_PTN = Pattern.compile("(?<![ \\*])(?=\\*)");
  private static final Pattern JUNK_PTN = Pattern.compile("^[- \\*\\.]+");
  
  public boolean parseMsg(String body, Data data) {
    if (!body.startsWith("DG911\n")) return false;
    body = body.substring(6).trim();
    int pt = body.indexOf("\n>---");
    if (pt >= 0) body = body.substring(0,pt).trim();
    
    // Check on how  many newlines we have
    // if exactly two, first part is the call description
    // if more than two, reject
    
    String[] parts = body.split("\n");
    if (parts.length > 2) return false;
    if (parts.length == 2) {
      data.strCall = parts[0].trim();
      body = parts[1].trim();
    }
    
    body = MISSING_BLANK_PTN.matcher(body).replaceAll(" ");
    
    // If we have a call description already, see if it is duplicated in the rest of the message
    // either way, we won't be looking for it 
    StartType st = StartType.START_CALL;
    if (data.strCall.length() > 0) {
      st = StartType.START_ADDR;
      if (body.startsWith(data.strCall)) {
        body = body.substring(data.strCall.length());
        body = JUNK_PTN.matcher(body).replaceFirst("");
      }
      
      //  One time they put both the call and address in the first part :(
      else {
        pt = data.strCall.lastIndexOf(" - ");
        if (pt >= 0) {
          String addr = data.strCall.substring(pt+3).trim();
          if (isValidAddress(addr)) {
            data.strCall = data.strCall.substring(0,pt).trim();
            parseAddress(addr, data);
            data.strSupp = body;
            return true;
          }
        }
      }
    }
    
    Result res = parseAddress(st, FLAG_NO_IMPLIED_APT | FLAG_IGNORE_AT, body);
    if (res.isValid()) {
      res.getData(data);
      String left = res.getLeft();
      left = JUNK_PTN.matcher(left).replaceFirst("");
      if (data.strCall.length() == 0) {
        data.strCall = left;
      } else {
        data.strSupp = left;
      }
    } else {
      if (data.strCall.length() > 0) {
        data.strSupp = body;
      } else {
        data.strCall = "GENERAL ALERT";
        data.strPlace = body;
      }
    }
    return true;
  }
}
