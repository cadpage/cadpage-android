package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class NYSuffolkCountyBParser extends SmartAddressParser {
  
  private static final String[] KEYWORDS = new String[]{"ADDR", "CS", "TOA", "HY"};
  
  private static final Pattern TIME_DATE = Pattern.compile("\\d\\d:\\d\\d \\d\\d/\\d\\d/\\d\\d ");
  private static final String[] DISTRICT_LIST = new String[]{"NORTH BABYLON FC", "AMITYVILLE FD", "DEER PARK FIRE DISTRICT", "PT JEFFERSON"};
  private static final String[] CITY_LIST = new String[]{
    "PORT JEFFERSON", "BELLE TERRE", "MOUNT SINAI", "STONY BROOK", "MILLER PLACE", "CORAM"
  };
  
  public NYSuffolkCountyBParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY");
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf("***");
    if (pt < 0) return false;
    int pta = body.indexOf("***",pt+3); 
    if (pta < 0) return false;
    data.strCall = body.substring(pt+3, pta).trim();
    body = body.substring(pta+3).trim();
    
    body = "ADDR:" + body;
    Properties props = parseMessage(body, KEYWORDS);
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, props.getProperty("ADDR", ""), data);
    if (data.strPlace.endsWith("*")) data.strPlace = data.strPlace.substring(0, data.strPlace.length()-1).trim(); 
    data.strCross = props.getProperty("CS", "");
    String sSupp = props.getProperty("TOA", "");
    Matcher match = TIME_DATE.matcher(sSupp);
    if (match.find()) sSupp = sSupp.substring(match.end()).trim();
    boolean found = false;
    for (String district : DISTRICT_LIST) {
      pt = sSupp.indexOf(district);
      if (pt >= 0) {
        data.strSupp = sSupp.substring(0, pt).trim();
        data.strSource = district;
        data.strCallId = sSupp.substring(pt + district.length()).trim();
        pt = data.strCallId.indexOf(' ');
        if (pt >= 0) data.strCallId = data.strCallId.substring(0, pt);
        found = true;
        break;
      }
    }
    if (!found) data.strSupp = sSupp;
    return true;
  }
}
