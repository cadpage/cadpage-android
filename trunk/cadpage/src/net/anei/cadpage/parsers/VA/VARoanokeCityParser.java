package net.anei.cadpage.parsers.VA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/* 
Roanoke City, VA
Contact: Sandy Webb <sandywebb@gmail.com>
Sender: e911@roanokeva.gov

Working Fire at 1401 ORANGE AVE NW
Working Fire at 2802 COLONIAL AVE SWAPT 16
Working Fire at 5046 WILLIAMSON RD NW

*/

public class VARoanokeCityParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Za-z0-9 ]+) at (.*)");
  
  public VARoanokeCityParser() {
    super("ROANOKE CITY", "VA");
  }
  
  @Override
  public String getFilter() {
    return "e911@roanokeva.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    String sAddr = match.group(2).replace("APT ", " APT").trim();
    parseAddress(sAddr, data);
    return checkAddress(data.strAddress, 2) > 0;
  }
}
