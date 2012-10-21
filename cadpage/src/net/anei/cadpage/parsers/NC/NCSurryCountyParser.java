package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Surry County, NC
 */
public class NCSurryCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("SC911::?(?:Call #|=)(\\d{6,}-\\d{4}) \\[(?:Address|Location)\\] (.*?) \\[X St\\] (.*?) \\[Type\\] (.*)");
  
  public NCSurryCountyParser() {
    super(CITY_LIST, "SURRY COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "SC911:@co.surry.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    String addr = match.group(2).replace("//", "&").trim();
    String state = null;
    int pt = addr.lastIndexOf(',');
    if (pt >= 0) {
      state = addr.substring(pt+1).trim();
      addr = addr.substring(0,pt).trim();
    }
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, addr, data);
    if (state != null) {
      if (state.length() == 2) {
        if (!state.equals(data.defState)) data.strState = state; 
      } else if (data.strCity.length() == 0) {
        data.strCity = state;
      }
    }
    
    data.strCross = match.group(3).trim().replace(" TO ", " & ");
    if (data.strCross.equals("TO")) data.strCross = "";
    else if (data.strCross.endsWith(" TO")) {
      data.strCross = data.strCross.substring(0,data.strCross.length()-3).trim();
    }
    data.strCall = match.group(4).trim();
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "DOBSON",
    "ELKIN",
    "MOUNT AIRY",
    "PILOT MOUNTAIN",
    "SURRY COUNTY"
  };
}
