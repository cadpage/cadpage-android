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
    Pattern.compile("(?:((?:[A-Z]{2} +)+))?(?:(\\d{3}) +)?(?:(Quad \\d{3,4}) - ([A-Z]{2})|(Brandon-\\d|Dell Rapids \\d)) +(.+?)(?: (C\\d))? (\\d{4}-\\d{8})");
  
  private static final Pattern MM_PTN = Pattern.compile("( MM \\d+)([^\\d ])");
  private static final Pattern MM_PTN2 = Pattern.compile("^MM \\d+");
 
  public SDMinnehahaCountyParser() {
    super(CITY_CODES, "MINNEHAHA COUNTY", "SD");
    setFieldList("SRC UNIT MAP ADDR APT PLACE CITY CALL CODE ID");
  }
  
  @Override
  public String getFilter() {
    return "911metrodispatch@911metro.org";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    Matcher match = CAD_MSG_PTN.matcher(body);
    if (!match.matches()) return false;
    
    data.strUnit = getOptGroup(match.group(1));
    data.strSource = getOptGroup(match.group(2));
    data.strMap = getOptGroup(match.group(3));
    String sCityCode = getOptGroup(match.group(4));
    if (data.strMap.length() == 0) data.strMap = getOptGroup(match.group(5));
    String sAddrFld = match.group(6);
    data.strCode = getOptGroup(match.group(7));
    data.strCallId = match.group(8);
    
    // Dispatch never puts a blank between mile markers and city codes :(
    sAddrFld = MM_PTN.matcher(sAddrFld).replaceFirst("$1 $2");
    
    // Whose bright idea was it to use DR as a city code?
    pt = -1;
    String pad;
    if (sCityCode.equals("DR")) pt = sAddrFld.lastIndexOf(" DR ");
    if (pt >= 0) {
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT, 
                   sAddrFld.substring(0,pt).trim(), data);
      pad = getLeft();
      data.strCall = sAddrFld.substring(pt+4).trim();
      data.strCity = "DELL RAPIDS";
    } else {
      parseAddress(StartType.START_ADDR, FLAG_IMPLIED_INTERSECT | FLAG_PAD_FIELD, sAddrFld, data);
      pad = getPadField();
      data.strCall = getLeft();
    }

    match = MM_PTN2.matcher(data.strCall);
    if (match.find()) {
      data.strAddress = append(data.strAddress, " ", match.group());
      data.strCall = data.strCall.substring(match.end()).trim();
    }
    
    if (data.strCity.length() == 0 && data.strCall.startsWith("DR ")) {
      data.strCity = "DELL RAPIDS";
      data.strCall = data.strCall.substring(3).trim();
    }

    if (pad.length() <= 4) {
      data.strApt = append(data.strApt, "-", pad);
    } else if (pad.startsWith("MM ")) {
      data.strAddress = append(data.strAddress, " ", pad);
    } else {
      data.strPlace = pad;
    }
    return true;
  }
}
