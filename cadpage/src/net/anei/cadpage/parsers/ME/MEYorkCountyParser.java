package net.anei.cadpage.parsers.ME;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
Waterboro, ME
Contact: Sean Perkins <sperkins@waterborofire.org>
Sender: U.2229178@pager.ucom.com
[Page]  MEDICAL EMERGENCY26 EAST SHORE RD Waterboro7/4/2011 12:36
[Page]  FIRE, OTHER161 BEAVER DAM RD Waterboro7/4/2011 11:43
[Page]  MEDICAL EMERGENCYMX 270 MOTOR CROSS TRACKLyman7/3/2011 11:24 
[Page]  MEDICAL EMERGENCY54 ROCKY RD Lyman7/2/2011 17:51 
[Page]  FIRE, OTHERDEERING RIDGE RD.PHEASANT RUN RD Waterboro7/2/2011 03:22 
(Page) FIRE, STRUCTURE13 KINGS CT Waterboro7/23/2011 16:00
(Page) MOTOR VEHICLE ACCIDENT-PI/HAZ979 SOKOKIS TRL Waterboro7/24/2011 13:31

(Page) FIRE ALARM ACTIVATIONWATERBORO ELEMENTARY SCHOOL340 SOKOKIS TRL Waterboro7/28/2011 11:33

*/

public class MEYorkCountyParser extends SmartAddressParser {
  
  private static final String[] CALL_LIST = new String[]{
    "MEDICAL EMERGENCY",
    "FIRE, OTHER",
    "FIRE, STRUCTURE",
    "MOTOR VEHICLE ACCIDENT-PI/HAZ"
  };
  
  private static final String[] CITY_LIST = new String[]{
    "ACTON",
    "ALFRED",
    "ARUNDEL",
    "BERWICK",
    "BIDDEFORD",
    "BUXTON",
    "CORNISH",
    "DAYTON",
    "ELIOT",
    "HOLLIS",
    "KENNEBUNK",
    "KENNEBUNKPORT",
    "KITTERY",
    "LEBANON",
    "LIMERICK",
    "LIMINGTON",
    "LYMAN",
    "NEWFIELD",
    "NORTH BERWICK",
    "OGUNQUIT",
    "OLD ORCHARD BEACH",
    "PARSONSFIELD",
    "SACO",
    "SANFORD",
    "SHAPLEIGH",
    "SOUTH BERWICK",
    "WATERBORO",
    "WELLS",
    "YORK"
  };
  
  private static final Pattern DATE_TIME_PTN = 
    Pattern.compile("\\d\\d?/\\d\\d?/\\d{4} \\d\\d:\\d\\d");
  
  public MEYorkCountyParser() {
    super(CITY_LIST, "YORK COUNTY", "ME");
  }
  
  @Override
  public String getFilter() {
    return "@pager.ucom.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.equals("Page")) return false;
    for (String call : CALL_LIST) {
      if (body.startsWith(call)) {
        data.strCall = call;
        body = body.substring(call.length()).trim();
        break;
      }
    }
    if (data.strCall.length() == 0) return false;
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (!match.find()) return false;
    String sAddr = body.substring(0, match.start()).trim().replace(".", " & ");
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    
    // There is always a city, but sometimes there isn't a space separating it from the address :(
    if (data.strCity.length() == 0) {
      String sUpAddr = sAddr.toUpperCase();
      for (String city : CITY_LIST) {
        if (sUpAddr.endsWith(city)) {
          int pt = sAddr.length() - city.length();
          data.strAddress = "";
          parseAddress(sAddr.substring(0,pt).trim(), data);
          data.strCity = sAddr.substring(pt);
          break;
        }
      }
    }
    return true;
  }
}
