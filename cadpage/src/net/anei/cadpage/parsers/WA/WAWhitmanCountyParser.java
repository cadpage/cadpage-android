package net.anei.cadpage.parsers.WA;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA11Parser;

/**
 * Whitman County, NJ
 */
public class WAWhitmanCountyParser extends DispatchA11Parser {
  
  private static final Pattern RUN_REPORT_PTN = Pattern.compile("([A-Z]+)\n([A-Z0-9]+)\n(\\d{2}-\\d{6})\n(.*\nCMPLT- \\d\\d\\.\\d\\d\\.\\d\\d)",Pattern.DOTALL);
  
  public WAWhitmanCountyParser() {
    super(CITY_CODES, "WHITMAN COUNTY", "WA");
  }
  
  @Override
  public String getFilter() {
    return "hiplink@whitcom.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {

    if (!subject.equals("test")) return false;
    
    Matcher match = RUN_REPORT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "RUN REPORT";
      data.strSource = match.group(1);
      data.strUnit = match.group(2);
      data.strCallId = match.group(3);
      data.strPlace = match.group(4).trim();
      return true;
    }
    return super.parseMsg(body, data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
     "CLA", "CLARKSTON",
     "PUL", "PULMAN"
  });
}
