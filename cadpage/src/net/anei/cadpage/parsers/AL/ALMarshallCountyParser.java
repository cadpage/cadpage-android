package net.anei.cadpage.parsers.AL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/**
 * St Clair County, AL
 */
public class ALMarshallCountyParser extends DispatchBParser {
  
  private static final Pattern MARKER = Pattern.compile("(?:^|\n)911-CENTER:");

  public ALMarshallCountyParser() {
    super(CITY_LIST, "MARSHALL COUNTY", "AL");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return super.parseMsg(body,  data);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALBERTVILLE",
    "ARAB",
    "BOAZ",
    "DOUGLAS",
    "JOPPA",
    "GRANT",
    "GUNTERSVILLE",
    "HORTON",
    "UNION GROVE"
  };
}
