
package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCWarrenCountyParser extends DispatchSouthernParser {
  
  private static final Pattern MASTER2 = Pattern.compile("(.*?) (20\\d{3,}) (.*)");

  public NCWarrenCountyParser() {
    super(CITY_LIST, "WARREN COUNTY", "NC", DSFLAG_FOLLOW_CALL);
  }
  
  @Override
  public String getFilter() {
    return "@warrencountync.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (super.parseMsg(body, data)) return true;
    
    
    // Check for alternate fallback format missing a date.time
    Matcher match = MASTER2.matcher(body);
    setFieldList("CALL ID ADDR APT CITY");
    if (!match.matches()) return false;

    data.initialize(this);
    data.strCall = match.group(1).trim();
    data.strCallId = match.group(2);
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, match.group(3).trim(), data);
    return data.strCity.length() > 0;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    "MACON",
    "HENDERSON",
    "NORLINA",
    "WARRENTON",
    "WISE"
  };
}
