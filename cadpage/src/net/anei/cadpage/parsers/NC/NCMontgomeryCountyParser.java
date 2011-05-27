package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/* 
Montgomery County, NC
Contact: Kyle Morris <wildlandfire09@gmail.com>
Sender: @montgomerycountync.com

SDUNN:201107504 105 WHITE TAIL RUN MT GILEAD MAN WITH A GUN jeremy collins is there arguing/ has a gun/subject is in the yard
JWHITAKER:106 EAST ALLENTON ST MT GILEAD STATION 2 PAGE 201107494 16:44:24 station 2 will be having cpr class at 7 on Monday the 28th
MDAVIS:201107560 179 TILLERY DAM RD MT GILEAD ILLEGAL BURN MAN BURNING TRASH NEAR PLANT ON RIVERBED, HAVE ASKED HIM TO PUT IT OUT, REFUSING. EXT 0.
JWHITAKER:201107575 644 BISCOE RD TROY FIRE ALARM tommy and debbie honeycutt,gen fire and gen burg,no contact on premise,audible
JWHITAKER:201107593 468 EAST MAIN ST CANDOR FIRE ALARM plant 28,riser 1 water flow
KMORRIS:1895 NC HWY 24-27 E INT BISCOE INFORMATION 201107696 12:09:59 test
KMORRIS:2295 NC HWY 24-27 E BISCOE BISCOE PHARMACY STRUCTURE FIRE 201108670 15:41:32

|GCOVINGTON:201108622 303 GREEN TOP RD STAR MAN WITH A GUN BOBBY GILCHREST T35/GUN WILL NOT LET JEANNE CASSIDY LEAVE :1of2
|HIS RESD, HAS ALSO THREATENED TO CUT HER IF SHE LEAVES.:2of2

*/

public class NCMontgomeryCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[] {
    "BISCOE",
    "BLACK ANKLE",
    "CANDOR",
    "ETHER",
    "JACKSON SPRINGS",
    "MT GILEAD",
    "NEW LONDON",
    "OKEEWEMEE",
    "OPHIR",
    "PEE DEE",
    "SEAGROVE",
    "STAR",
    "STEEDS",
    "TROY",
    "WINDBLOW"
  };
  
  private static final Pattern LEAD_PTN = Pattern.compile("^[A-Z]+:(?:(\\d{9}) )?");
  private static final Pattern ID_TIME_PTN = Pattern.compile("\\b(\\d{9}) \\d\\d:\\d\\d:\\d\\d\\b");
  private static final Pattern CALL_PTN = Pattern.compile("^[A-Z ]+ ");
  
  public NCMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "@montgomerycountync.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    // Pipe character aren't normally used in this format, but they can get
    // inserted by page splitters in ways that the normal descrambling logic
    // cannot detect.  So we solve that problem be removing all pipes.
    body = body.replace("|", "");
    
    // Strip of dispatcher and possible ID from beginning of body
    Matcher match = LEAD_PTN.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    if (data.strCallId == null) data.strCallId = "";
    body = body.substring(match.end()).trim();
    
    // This county handles double routes numbers in a way that is incompatible
    // with the general address logic.  Fortunately there is only one so we
    // can make a special case for it
    body = body.replace(" 24-27 ", " 99242799 ");
    
    // See if we can find an ID/Time pattern
    // If we did, it separates an address/call field from an supplemental info field
    match = ID_TIME_PTN.matcher(body);
    if (match.find()) {
      
      data.strCallId = match.group(1);
      data.strSupp = body.substring(match.end()).trim();
      String sAddr = body.substring(0,match.start()).trim();
      parseAddress(StartType.START_ADDR, sAddr, data);
      data.strCall = getLeft();
    }
    
    // If not, use the smart parser to get what we can
    // and see if we
    else {
      parseAddress(StartType.START_ADDR, body, data);
      body = getLeft();
      match = CALL_PTN.matcher(body);
      if (match.find()) {
        data.strCall = match.group().trim();
        if (data.strCall.length() > 20) {
          data.strCall = "ALERT";
        } else {
          body = body.substring(match.end());
        }
      }
      data.strSupp = body;
    }
    data.strAddress = data.strAddress.replace(" 99242799 ", " 24 27 ");
    if (data.strAddress.endsWith(" INT")) {
      data.strAddress = data.strAddress.substring(0,data.strAddress.length()-4).trim();
    }
    return true;
  }
}
