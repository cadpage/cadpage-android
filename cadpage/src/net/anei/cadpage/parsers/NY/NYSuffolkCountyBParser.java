package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Suffolk County, NY (Version B)

*** 13 - Structure Fire *** 147 CHERUBINA LN CS: LEADER AVE  / SKIDMORE RD TOA: 22:37 09/22/10 OIL BURNER NORTH BABYLON FC 2010-002398 HY: 8' 11
*** 13 - Structure Fire *** 514 MOUNT PL CS: ESSEX ST  / LAKEWAY DR TOA: 19:55 09/22/10 NORTH BABYLON FC 2010-002393 HY: 12' 533 MOUNT PL @ ESSE
*** 2nd/16 - Rescue *** 733 HIGHRIDGE RD CS: OCONNER RD  / NARLAND LN TOA: 20:46 09/22/10 a/m pysch emer NORTH BABYLON FC 2010-002395
*** 23 - Miscellaneous Fire *** SR CITZ APTS (5 BLDGS) COMPLEX 15 WEEKS RD CS: DEER PARK AVE  / MULHOLLAND DR TOA: 11:07 09/23/10 INVEST NORTH B
***23- Wires/Electrical Hazard*** THEATRE THREE* 412 MAIN ST PORT JEFFERSON CS: SPRING ST  / MAPLE PL TOA: 14:18 01/02/11 PT JEFFERSON 2011-000003 PJFD
*/

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
    
    if (!body.startsWith("***")) return false;
    int pta = body.indexOf("***",3); 
    if (pta < 0) return false;
    data.strCall = body.substring(3, pta).trim();
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
      int pt = sSupp.indexOf(district);
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
