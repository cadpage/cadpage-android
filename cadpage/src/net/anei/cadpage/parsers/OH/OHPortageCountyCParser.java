package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/**
 * Portage County, OH
 */
public class OHPortageCountyCParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("MANTUA- +(.*?)- (.*)");

  public OHPortageCountyCParser() {
    super("PORTAGE COUNTY", "OH");
    setFieldList("ADDR APT CALL");
  }

  @Override
  public String getFilter() {
    return "mantuafire@gmail.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, match.group(1).trim(), data);
    data.strCall = match.group(2).trim();
    return true;
  };
}
