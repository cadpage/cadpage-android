
package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/**
 * Morgan County, AL
 */

public class ALMorganCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:CAD:)?(.*?)(?: (\\d{8}))?(?: (DFS\\d|MTFS))?");
  private static final Pattern CAT_PTN = Pattern.compile(" +CAT(\\d)\\b *");

  public ALMorganCountyParser() {
    super("MORGAN COUNTY", "AL");
    setFieldList("PLACE ADDR CALL PRI X ID SRC");
  }
  
  @Override
  public String getFilter() {
    return "cad@morgan911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    body = match.group(1);
    data.strCallId = getOptGroup(match.group(2));
    data.strSource = getOptGroup(match.group(3));
    
    match = CAT_PTN.matcher(body);
    if (match.find()) {
      data.strPriority = match.group(1);
      Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, body.substring(match.end()));
      res.getData(data);
      body = body.substring(0,match.start());
    }
    
    parseAddress(StartType.START_PLACE, body, data);
    
    // What's left is usually the call description
    // but if we didn't find a priority and cross street, it might be
    // a combine description and place name
    String left = getLeft();
    if (data.strPriority.length() == 0) {
      Result res = parseAddress(StartType.START_CALL, FLAG_START_FLD_REQ | FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, left);
      res.getData(data);
    } else {
      data.strCall = left;
    }
    return true;
  }
}
