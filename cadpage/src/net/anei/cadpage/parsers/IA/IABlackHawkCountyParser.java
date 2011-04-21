package net.anei.cadpage.parsers.IA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Waterloo, IA (or Black Hawk County)
Contact: Ryan Mahood <331medic@gmail.com>
Sender: Swmail@bhcso.org,Xmail@connectingyou.com

10-127299 MVA ROLLOVER/20 HWY SERGEANT RD WATERLOO
10-124880 MVA ROLLOVER 1941 W 6TH ST EUREKA/ MITCHELL/WATERLOO
 */


public class IABlackHawkCountyParser extends SmartAddressParser {
  
  private static final Pattern CALL_ID_PATTERN =
      Pattern.compile("^\\d\\d-\\d{6} ");
  
  public IABlackHawkCountyParser() {
    super("BLACK HAWK COUNTY", "IA");
  }
  
  @Override
  public String getFilter() {
    return "Swmail@bhcso.org,Xmail@connectingyou.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = CALL_ID_PATTERN.matcher(body);
    if (! match.find()) return false;
    
    data.strCallId = body.substring(0, match.end()-1);
    body = body.substring(match.end()).trim();
    
    // city is awkward because they sometimes use / and sometimes blank to
    // delineate it
    int pt = Math.max(body.lastIndexOf(' '), body.lastIndexOf('/'));
    if (pt < 0) return false;
    data.strCity = body.substring(pt+1).trim();
    body = body.substring(0, pt).trim();
    
    // Parse description and address, anything left is a cross street
    parseAddress(StartType.START_CALL, body, data);
    data.strCross = getLeft();
    
    return true;
  }
}
