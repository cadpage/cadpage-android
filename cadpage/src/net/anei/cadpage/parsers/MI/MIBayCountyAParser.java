package net.anei.cadpage.parsers.MI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class MIBayCountyAParser extends SmartAddressParser {
  
  private static final Pattern RUN_REPORT_ID_PTN = Pattern.compile("ID:(.*)\n");
  private static final Pattern RUN_REPORT_UNIT_PTN = Pattern.compile("UNIT:(.*)\n");
  private static final Pattern MASTER = Pattern.compile("([^,]+?), (.*?)(1?\\d/\\d\\d?.\\d{4} \\d\\d?:\\d\\d?:\\d\\d [AP]M)");
  private static final DateFormat DATE_TIME_FMT = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
  
  public MIBayCountyAParser() {
    super(CITY_LIST, "BAY COUNTY", "MI");
    setFieldList("CALL ADDR APT CITY INFO DATE TIME");
    setupCallList(CALL_SET);
  }
  
  @Override
  public String getFilter() {
    return "911@baycounty.net";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (body.startsWith("CALL: RUN REPORT \n")) {
      data.strCall = "RUN REPORT";
      data.strPlace = body;
      Matcher match = RUN_REPORT_ID_PTN.matcher(body);
      if (match.find()) data.strCallId = match.group(1).trim();
      match = RUN_REPORT_UNIT_PTN.matcher(body);
      if (match.find()) data.strUnit = match.group(1).trim();
      return true;
    }
    
    body = body.replace('\n', ' ');
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    String addr = match.group(1).trim();
    addr = addr.replace('@', '&');
    int pt = addr.indexOf("  ");
    if (pt >= 0) {
      data.strCall = addr.substring(0,pt).trim();
      parseAddress(addr.substring(pt+2).trim(), data);
    } else {
      parseAddress(StartType.START_CALL, FLAG_ANCHOR_END, addr, data);
    }
    
    String cityInfo = match.group(2).trim();
    pt = cityInfo.indexOf("  ");
    if (pt >= 0) {
      data.strCity = cityInfo.substring(0,pt).trim();
      data.strSupp = cityInfo.substring(pt+2).trim();
    } else {
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CITY, cityInfo, data);
      data.strSupp = getLeft();
    }
    
    setDateTime(DATE_TIME_FMT, match.group(3), data);
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{

    // Cities
    "AUBURN",
    "BAY CITY",
    "ESSEXVILLE",
    "PINCONNING",
    "MIDLAND",
    
    // Unincorporated
    "BENTLEY",
    "CRUMP",
    "DUEL",
    "KAWKAWLIN",
    "LINWOOD",
    "MOUNT FOREST",
    "MUNGER",
    "WILLARD",
    "UNIVERSITY CENTER",

    // Townships
    "BANGOR TWP",
    "BEAVER TWP",
    "FRANKENLUST TWP",
    "FRASER TWP",
    "GARFIELD TWP",
    "GIBSON TWP",
    "HAMPTON TWP",
    "KAWKAWLIN TWP",
    "MERRITT TWP",
    "MONITOR TWP",
    "MT. FOREST TWP",
    "PINCONNING TWP",
    "PORTSMOUTH TWP",
    "WILLIAMS TWP"
  };
  
  private static final CodeSet CALL_SET = new CodeSet(
      "CITIZEN",
      "COMFIRE",
      "FIRE ALARM",
      "MED",
      "PIA",
      "SMOKE",
      "STRUCTURE",
      "SUICIDE",
      "TEST"
  );
}
