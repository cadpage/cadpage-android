package net.anei.cadpage.parsers.CT;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class CTTrumbullParser extends SmartAddressParser {
  
  private static final Pattern UNIT_PTN = Pattern.compile("^(?:[A-Z][A-Z0-9]{2} )+");
  
  private static final Set<String>STATION_CODES = 
    new HashSet<String>(Arrays.asList(new String[]{"TC", "LH", "N"}));
  
  public CTTrumbullParser() {
    super("TRUMBULL", "CT");
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    int pt = body.indexOf(' ');
    if (pt < 0) return false;
    String src = body.substring(0,pt).trim();
    body = body.substring(pt+1).trim();
    for (String code : src.split("/")) {
      if (! STATION_CODES.contains(code)) return false;
    }
    data.strSource = src;
    
    Matcher match = UNIT_PTN.matcher(body);
    if (!match.find()) return false;
    pt = match.end();
    data.strUnit = body.substring(0, pt-1);
    body = body.substring(pt);
    
    if (body.startsWith("AREA OF ")) {
      data.strPlace = "AREA OF";
      body = body.substring(8).trim();
    }
    parseAddress(StartType.START_ADDR, body, data);
    data.strSupp = getLeft();
    if (data.strApt.length() > 0) {
      data.strSupp = data.strApt + " " + data.strSupp;
      data.strApt = "";
    }
    return true;
  }
}
