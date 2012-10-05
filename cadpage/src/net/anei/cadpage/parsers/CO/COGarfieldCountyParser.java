package net.anei.cadpage.parsers.CO;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;




public class COGarfieldCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(.*) +Location +(.*?) +(\\d{4} \\d{8})");
  private static final Pattern APT_PTN = Pattern.compile(" APT ([^ ]+)$");
  private static final Pattern BLK_PTN = Pattern.compile("\\bblk\\b");
  private static final Pattern PLACE_PTN = Pattern.compile("^.*[a-z]");
  private static final Pattern PLACE2_PTN = Pattern.compile("^.*[A-Z]{3}(?=\\d)");
  
  public COGarfieldCountyParser() {
    super("GARFIELD COUNTY", "CO");
  }
  
  @Override
  public String getFilter() {
    return "GCECA@call3n.com,@everbridge.net";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (!subject.endsWith("CAD Page")) return false;
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1);
    String sAddr = match.group(2).trim();
    data.strCallId = match.group(3);
    
    // Remove apt from address before checking for city/map zone
    match = APT_PTN.matcher(sAddr);
    if (match.find()) {
      data.strApt = match.group(1);
      sAddr = sAddr.substring(0,match.start()).trim();
    }
    
    // The address field may contain a leading place name, and usually contains a
    // trailing city code.  Unfortunately dispatch is pretty sloppy about separating
    // these fields with blanks, so we won't count on blank separators.
    for (int len = 2; len<=4; len++) {
      int pt = sAddr.length() - len;
      if (pt >= 0) {
        String city = CITY_CODES.getProperty(sAddr.substring(pt));
        if (city != null) {
          if (city.startsWith("Z")) data.strMap = city;
          else data.strCity = city;
          sAddr = sAddr.substring(0,pt).trim();
          break;
        }
      }
    }
    
    // Place names are (usually) cammel case while address is always upper case
    // So we split them at the last lower case character
    sAddr = BLK_PTN.matcher(sAddr).replaceAll("BLK");
    match = PLACE_PTN.matcher(sAddr);
    boolean found = match.find();
    if (!found) {
      match = PLACE2_PTN.matcher(sAddr);
      found = match.find();
    }
    if (found) {
      data.strPlace = match.group();
      sAddr = sAddr.substring(match.end()).trim();
    }
    
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END | FLAG_IMPLIED_INTERSECT, sAddr, data);
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GS",   "GLENWOOD SPRINGS",
      "RIF",  "RIFLE",
      "SIL",  "SILT",
      "SILT", "SILT",
      "NC",   "NEW CASTLE",
      "Z1",   "Z1",
      "Z2",   "Z2",
      "Z3",   "Z3"
  });
}
