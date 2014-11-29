package net.anei.cadpage.parsers.SD;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class SDMinnehahaCountyParser extends SmartAddressParser {
  
  private static final Pattern CAD_MSG_PTN = 
    Pattern.compile("(?:((?:[A-Z]{2} +)+))?(?:(\\d{3}) +)?(?:((?:[A-Z]{2} +)+))?(?:(Quad \\d{3,4}) - ([A-Z]{2})|(Baltic \\d{1,2}|Brandon[- ]\\d{1,2}|Colton City|Colton \\d{1,2}|Dell Rapids \\d|Garretson \\d{1,2}|Splitrock \\d{1,2}|Valley Springs \\d{1,2}))? +(.+?)(?: (C\\d))?(?: (\\d{4}-\\d{8}))?");
  private static final Pattern DISPATCH_MSG_PTN = 
      Pattern.compile("(.*?) +(\\d{4}-\\d{8})((?:  Dispatch received by unit ([^ ]+))+)");
  
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
    if (match.matches()) {
      
      data.strUnit = append(getOptGroup(match.group(1)), " ", getOptGroup(match.group(3)));
      data.strSource = getOptGroup(match.group(2));
      data.strMap = getOptGroup(match.group(4));
      String sCityCode = getOptGroup(match.group(5));
      if (data.strMap.length() == 0) data.strMap = getOptGroup(match.group(6));
      String sAddrFld = match.group(7);
      data.strCode = getOptGroup(match.group(8));
      data.strCallId = getOptGroup(match.group(9));
      
      // Almost everything is optional, but we have to have some standards
      // If we don't have a map or a call ID, reject this
      if (data.strMap.length() == 0 && data.strCallId.length() == 0) return false;
      
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
      
      if (data.strCity.length() == 0) {
        match = CITY_PTN.matcher(data.strCall);
        if (match.matches()) {
          data.strPlace = match.group(1);
          String city = match.group(2);
          data.strCall = match.group(3);
          if (city.equals("DR")) {
            data.strCity = "DELL RAPIDS";
          } else {
            data.strCity = convertCodes(city, CITY_CODES);
          }
        }
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
    
    else if ((match = DISPATCH_MSG_PTN.matcher(body)).matches()) {
      String addrFld = match.group(1);
      data.strCallId = match.group(2);
      data.strUnit = match.group(3).replace("Dispatch received by ", "").trim();
      parseAddress(StartType.START_ADDR, addrFld, data);
      data.strCall = getLeft();
      return data.strCall.length() > 0;
    }
    else return false;
  }
  
  private static final Pattern CITY_PTN = Pattern.compile("(.*?) *(BA|BR|CO|CR|DR|GA|GN|HD|HU|LY|RE|VS|SR|EM) +(.*)");
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BA", "BALTIC",
      "BR", "BRANDON",
      "CO", "COLTON",
      "CR", "CROOKS",
//      "DR", "DELL RAPIDS",  // gets confused drive DR road suffix :(
      "GA", "GARRETSON",
      "GN", "GARRETSON",
      "HD", "", // Should be Hartford but actually in sioux falls
      "HU", "HUMBOLT",
      "LY", "LYONS",
      "RE", "RENNER",
      "VS", "VALLEY SPRINGS",
      "SR", "SPLIT ROCK",
      "EM", ""
  });
}
