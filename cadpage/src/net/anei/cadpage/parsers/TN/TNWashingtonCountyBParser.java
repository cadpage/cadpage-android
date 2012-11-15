package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Washington County, TN (B)
 */
public class TNWashingtonCountyBParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:([A-Z]+)(?:\\.[^-]+)?-)?(.*?) +AT +(.*?) (?:-X-ST:(.*?) +)?(?:MAP-([A-Z0-9]+) +)?(\\d\\d:\\d\\d)");
  
  public TNWashingtonCountyBParser() {
    super("WASHINGTON COUNTY", "TN");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    body = body.replace("(-1)", "");
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strSource = getOptGroup(match.group(1));
    data.strCall = match.group(2).trim();
    parseAddress(StartType.START_ADDR, match.group(3).trim(), data);
    data.strSupp = getLeft();
    data.strCross = getOptGroup(match.group(4)).replaceAll(" *- *", " & ");
    data.strMap = getOptGroup(match.group(5));
    data.strTime = match.group(6);
    return true;
  }
}
