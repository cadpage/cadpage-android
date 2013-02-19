package net.anei.cadpage.parsers.ME;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class MEOxfordCountyParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^(\\d+):Dispatch:");
  private static final Pattern ADDRESS_MARKER = Pattern.compile("\\b(?:RESPOND TO|((?:IN )?AREA OF)) ", Pattern.CASE_INSENSITIVE);
  
  public MEOxfordCountyParser() {
    super(CITY_LIST, "OXFORD COUNTY", "ME");
    setFieldList("ID PLACE ADDR APT CITY CALL INFO");
  }
  
  @Override
  public String getFilter() {
    return "2075151833,2075151834";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCallId = match.group(1);
    body = body.substring(match.end()).trim();
    if (doParseMsg(body, data)) return true;
    
    // Fallback treat as general alert
    data.strCall = "GENERAL ALERT";
    data.strPlace = body;
    return true;
  }
  
  private boolean doParseMsg(String body, Data data) {
    
    // Look for things that look like address markers
    Matcher match = ADDRESS_MARKER.matcher(body);
    if (match.find()) {
      data.strPlace = getOptGroup(match.group(1));
      data.strCall = body.substring(0,match.start());
      body = body.substring(match.end());
    }
    StartType st = (data.strCall.length() > 0 ? StartType.START_ADDR : StartType.START_CALL);
    
    // See if there is a comma, this might or might not mark the end of the address
    boolean retry = false;
    int flags = 0;
    int pt = body.indexOf(',');
    if (pt >= 0) {
      String extra = body.substring(pt+1).trim();
      body = body.substring(0,pt).trim();
      
      // See if there is a city name following the address.  That would make
      // this a definitive end of address
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, extra, data);
      if (data.strCity.length() > 0) {
        data.strSupp = getLeft();
      } 
      
      // If comma is not followed by a city, we aren't sure whether it marks the
      // end of the address or occurs somewhere in the extra text following the address
      // We will assume it is the end of address for now, but if the address parser
      // is not happy with that assumption we will retry it the other way
      else {
        data.strSupp = extra;
        retry = true;
      }
      flags = FLAG_ANCHOR_END;
    }
    
    // OK, now that we have things narrowed down, let's try to find an address
    Result res = parseAddress(st, flags, body);
    if (retry && res.getStatus() == 0) {
      flags = 0;
      body = body + ", " + data.strSupp;
      data.strSupp = "";
      res = parseAddress(st, flags, body);
    }
    res.getData(data);
    if (data.strAddress.length() == 0) return false;
    if (flags == 0) data.strSupp = getLeft();
    
    // If we didn't find a call description in front of the address, use the info fiel
    if (data.strCall.length() == 0) {
      data.strCall = data.strSupp;
      data.strSupp = "";
    }
    
    return data.strCall.length() > 0;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ANDOVER",
    "BETHEL",
    "BROWNFIELD",
    "BUCKFIELD",
    "BYRON",
    "CANTON",
    "DENMARK",
    "DIXFIELD",
    "FRYEBURG",
    "GILEAD",
    "GREENWOOD",
    "HANOVER",
    "HARTFORD",
    "HEBRON",
    "HIRAM",
    "LINCOLN PLANTATION",
    "LOVELL",
    "MAGALLOWAY PLANTATION",
    "MEXICO",
    "NEWRY",
    "NORWAY",
    "OTISFIELD",
    "OXFORD",
    "PARIS",
    "PERU",
    "PORTER",
    "ROXBURY",
    "RUMFORD",
    "STONEHAM",
    "STOW",
    "SUMNER",
    "SWEDEN",
    "UPTON",
    "WATERFORD",
    "WEST PARIS",
    "WOODSTOCK",

    "SOUTH OXFORD",
    "NORTH OXFORD",
    "MILTON"
  };
}
