package net.anei.cadpage.parsers.CT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class CTWindhamCountyParser extends SmartAddressParser {
  
  private static final Pattern CHANNEL_PTN = Pattern.compile(" +(UHF-\\d|\\d\\d\\.\\d\\d) +");
  private static final Pattern PRIORITY_PTN = Pattern.compile("^PRI +(\\d) +");
  private static final Pattern TIME_PTN = Pattern.compile("\\d\\d:\\d\\d");

  public CTWindhamCountyParser() {
    super("WINDHAM COUNTY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "qvecpaging@qvec.org,messaging@iamresponding.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (subject.length() != 0) {
      if (subject.endsWith(" Page")) subject = subject.substring(0, subject.length()-5).trim();
      data.strSource = subject;
    }
    
    Matcher match = CHANNEL_PTN.matcher(body);
    if (!match.find()) return false;
    data.strUnit = body.substring(0,match.start()).replaceAll("  +", " ");
    data.strChannel = match.group(1);
    body = body.substring(match.end());
    
    Parser p = new Parser(body);
    String sAddr = p.get("(X-STS ");
    data.strCross = p.get(')');
    String sTime = p.get();
    if (TIME_PTN.matcher(sTime).matches()) data.strTime = sTime;
    
    int pt = sAddr.lastIndexOf('/');
    if (pt < 0) return false;
    String sPlaceCity = sAddr.substring(pt+1).trim();
    sAddr = sAddr.substring(0,pt).trim();
    
    match = PRIORITY_PTN.matcher(sAddr);
    if (match.find()) {
      data.strPriority = match.group(1);
      sAddr = sAddr.substring(match.end()).trim();
    }
    parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ANCHOR_END, sAddr, data);
    
    pt = sPlaceCity.lastIndexOf(' ');
    if (pt < 0 || CITY_SET.contains(sPlaceCity.toUpperCase())) {
      data.strCity = sPlaceCity;
    } else {
      do {
        String sCity = sPlaceCity.substring(pt+1).trim();
        if (CITY_SET.contains(sCity.toUpperCase())) break;
        pt =  sPlaceCity.lastIndexOf(' ', pt-1);
      } while (pt > 0);
      if (pt >= 0) {
        data.strCity = sPlaceCity.substring(pt+1).trim();
        sPlaceCity = sPlaceCity.substring(0, pt).trim();
      }
      if (checkAddress(sPlaceCity) > 0) {
        data.strAddress = data.strAddress + " & " + sPlaceCity;
      } else {
        data.strPlace = sPlaceCity;
      }
    }
    return true;
  }
  
  private static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(new String[]{
      "ASHFORD",
      "BROOKLYN",
         "EAST BROOKLYN",
      "CANTERBURY",
      "CHAPLIN",
      "EASTFORD",
      "HAMPTON",
      "KILLINGLY",
         "DANIELSON",
      "PLAINFIELD",
         "CENTRAL VILLAGE",
         "MOOSUP",
         "PLAINFIELD VILLAGE",
         "WAUREGAN",
      "POMFRET",
      "PUTNAM",
         "PUTNAM DISTRICT",
      "SCOTLAND",
      "STERLING",
         "ONECO",
      "THOMPSON",
         "NORTH GROSVENOR DALE",
         "QUINEBAUG",
      "WINDHAM",
         "SOUTH WINDHAM",
         "WILLIMANTIC",
      "WOODSTOCK",
         "SOUTH WOODSTOCK"
  }));
}
