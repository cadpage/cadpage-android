package net.anei.cadpage.parsers.MO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class MOJohnsonCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[]{
    "JOHNSON COUNTY",
    "JOHNSON COUNTY MO"
  };
  
  private static final Pattern MARKER = Pattern.compile("^(?:Dispatch: +)?\\d{1,2}/\\d{1,2}/\\d{4} \\d\\d:\\d\\d:\\d\\d +");
 
  public MOJohnsonCountyParser() {
    super(CITY_LIST, "JOHNSON COUNTY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "cadpage@joco911.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    do {
      if (subject.contains("911 Page")) break;
      
      if (body.startsWith("911 Page / ")) {
        body = body.substring(11).trim();
        break;
      }
      
      return false;
    } while (false);
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim().replace(',', ' ');
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, body, data);
    if (data.strCity.startsWith("JOHNSON COUNTY")) data.strCity = "";
    return true;
  }
}