package net.anei.cadpage.parsers.SD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class SDMinnehahaCountyParser extends SmartAddressParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BA", "BALTIC",
      "BR", "BRANDON",
      "CO", "COLTON",
      "CR", "CROOKS",
//      "DR", "DELL RAPIDS",  // gets confused drive DR road suffix :(
      "GA", "GARRETSON",
      "HD", "", // Should be Hartford but actually in sioux falls
      "HU", "HUMBOLT",
      "LY", "LYONS",
      "RE", "RENNER",
      "VS", "VALLEY SPRINGS",
      "SR", "SPLIT ROCK",
      "EM", ""
  });
  
  private static final Pattern CAD_MSG_PTN = 
    Pattern.compile("(?:(\\d{3}) +|((?:[A-Z]{2} +)+))?(Quad \\d{3,4}) - ([A-Z]{2}) +(.+?)(?: (C\\d))? (\\d{4}-\\d{8})");
  
  private static final Pattern MM_PTN = Pattern.compile("( MM \\d+)([A-Z]{2} )");
 
  public SDMinnehahaCountyParser() {
    super(CITY_CODES, "MINNEHAHA COUNTY", "SD");
  }
  
  @Override
  public String getFilter() {
    return "911metrodispatch@911metro.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = CAD_MSG_PTN.matcher(body);
    if (!match.matches()) return false;
    
    data.strSource = getOptGroup(match.group(1));
    data.strUnit = getOptGroup(match.group(2));
    data.strMap = match.group(3);
    String sCityCode = match.group(4);
    String sAddrFld = match.group(5);
    data.strCode = getOptGroup(match.group(6));
    data.strCallId = match.group(7);
    
    // Dispatch never puts a blank between mile markers and city codes :(
    sAddrFld = MM_PTN.matcher(sAddrFld).replaceFirst("$1 $2");
    
    // Whose bright idea was it to use DR as a city code?
    int pt = -1;
    if (sCityCode.equals("DR")) pt = sAddrFld.lastIndexOf(" DR ");
    if (pt >= 0) {
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, 
                   sAddrFld.substring(0,pt).trim(), data);
      data.strCall = sAddrFld.substring(pt+4).trim();
      data.strCity = "DELL RAPIDS";
    } else {
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, sAddrFld, data);
      data.strCall = getLeft();
    }
    return true;
  }
}
