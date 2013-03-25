package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILKankakeeCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER_PTN = 
      Pattern.compile("(.+) Location: (.+) \\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d Incident #: *(.*)");
  private static final Pattern HOUSE_SLASH_PTN = Pattern.compile("^\\d+(/)[^ ]");
  
  public ILKankakeeCountyParser() {
    super(CITY_LIST, "KANKAKEE COUNTY", "IL");
    setFieldList("CALL PLACE ADDR APT CITY ID");
  }
  
  @Override
  public String getFilter() {
    return "dispatchmessage@nwsmessage.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("NWS Message")) return false;
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCall = match.group(1).trim();
    String sAddr = match.group(2);
    Matcher match2 = HOUSE_SLASH_PTN.matcher(sAddr);
    if (match2.find()) sAddr = sAddr.substring(0,match2.start(1)) + " " + sAddr.substring(match2.end(1));
    parseAddress(StartType.START_PLACE, FLAG_ANCHOR_END, sAddr, data);
    data.strCallId = match.group(3);
    
    // If we didn't find an address, transer place to address
    if (data.strAddress.length() == 0) {
      data.strAddress = data.strPlace;
      data.strPlace = "";
    }
    
    // If we did find an address
    // try to parse apt from end of parsed address
    else { 
      String addr = data.strAddress;
      String apt = data.strApt;
      data.strAddress = data.strApt = "";
      parseAddress(StartType.START_ADDR, FLAG_NO_CITY, addr, data);
      if (apt.length() == 0) apt = data.strApt;
      data.strApt = append(apt, "-", getLeft());
    }
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "KANKAKEE",
    "MOMENCE",

    "AROMA PARK",
    "BONFIELD",
    "BOURBONNAIS",
    "BRADLEY",
    "BUCKINGHAM",
    "CHEBANSE",
    "ESSEX",
    "GRANT PARK",
    "HERSCHER",
    "HOPKINS PARK",
    "IRWIN",
    "LIMESTONE",
    "MANTENO",
    "ST. ANNE",
    "REDDICK",
    "SAMMONS POINT",
    "SUN RIVER TERRACE",
    "UNION HILL",

    "PEMBROKE",
    "SOLLITT",
    "YEAGER",
    "PEWING",
    
    "WILMINGTON"
  };
}
