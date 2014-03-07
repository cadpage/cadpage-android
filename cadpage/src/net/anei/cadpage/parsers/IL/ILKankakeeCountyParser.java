package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class ILKankakeeCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER_PTN2 = 
      Pattern.compile("(.+) Location: (.+) \\d\\d/\\d\\d/\\d\\d \\d\\d:\\d\\d Incident #: *(.*)");
  private static final Pattern HOUSE_SLASH_PTN = Pattern.compile("^\\d+(/)[^ ]");
  
  private static final Pattern MASTER_PTN1 = Pattern.compile("([A-Z0-9 ]+?)  +(.*?)(?: +(\\d{4}-\\d{8}))?");
  private static final Pattern PLACE_CITY_BRK_PTN = Pattern.compile("\\b([A-Z0-9]+)([A-Z][a-z]+)\\b");
  private static final Pattern SRC_PTN = Pattern.compile("(Aroma Fire|Bourbonnais Fire|Herscher Fire|K3 Twp Fire|Manteno Fire|Momence Fire|Saline/Limestone Fire|Otto Fire|Saline/Limestone Fire|St.Anne Fire|Station #\\d+) +(.*)");
  
  public ILKankakeeCountyParser() {
    super(CITY_LIST, "KANKAKEE COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "dispatchmessage@nwsmessage.net";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    // Check for message signature
    if (!subject.equals("NWS Message")) return false;
    
    // There are two formats, we have to check the older one first
    // because the new format pattern also picks up old format pages :(
    Matcher match = MASTER_PTN2.matcher(body);
    if (match.find()) {
      setFieldList("CALL PLACE ADDR APT CITY ID");
      data.strCall = match.group(1).trim();
      String sAddr = match.group(2);
      Matcher match2 = HOUSE_SLASH_PTN.matcher(sAddr);
      if (match2.find()) sAddr = sAddr.substring(0,match2.start(1)) + " " + sAddr.substring(match2.end(1));
      parseAddress(StartType.START_PLACE, FLAG_START_FLD_NO_DELIM | FLAG_ANCHOR_END, sAddr, data);
      data.strCallId = match.group(3);
      
      // If we didn't find an address, transfer place to address
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
    
    match = MASTER_PTN1.matcher(body);
    if (match.matches()) {
      setFieldList("UNIT SRC ADDR APT PLACE CITY CALL ID");
      data.strUnit = match.group(1).trim();
      body = match.group(2).trim();
      data.strCallId = getOptGroup(match.group(3));
      
      // Sometimes there is no blank separating the place name
      // from the city name.  We will try to identify these by looking
      // for multiple upper case letters followed by a lower case leter
      body = PLACE_CITY_BRK_PTN.matcher(body).replaceFirst("$1 $2");
      
      // compress multiple blanks
      body = body.replaceAll("  +", " ");
      
      // See if we can identify source field from pattern search.  If not
      // we will have to trust the SAP
      StartType st = StartType.START_OTHER;
      match = SRC_PTN.matcher(body);
      if (match.matches()) {
        st = StartType.START_ADDR;
        data.strSource = match.group(1);
        body = match.group(2);
      }
      parseAddress(st, FLAG_IMPLIED_INTERSECT | FLAG_PAD_FIELD, body, data);
      if (data.strSource.length() == 0) data.strSource = getStart();
      String pad = getPadField();
      if (pad.length() < 5) {
        data.strApt = append(data.strApt, " ", pad);
      } else {
        data.strPlace = pad;
      }
      data.strCall = getLeft();
      return data.strCity.length() > 0;
    }
    
    return false;
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
    "ST ANNE",
    "REDDICK",
    "SAMMONS POINT",
    "SUN RIVER TERRACE",
    "UNION HILL",

    "PEMBROKE TOWNSHIP",
    "SOLLITT TOWNSHIP",
    "YEAGER TOWNSHIP",
    "PEWING TOWNSHIP",
    
    "KANKAKEE COUNTY",
    
    "WILMINGTON",
    
    // Ford County
    "KEMPTON",
    
    // Grundy County
    "BRACEVILLE",
    
    // Iroquois County
    "BEAVERVILLE",
    
    // Kankakee County
    "CABERY",
    
    // Will County
    "BRAIDWOOD"
  };
}
