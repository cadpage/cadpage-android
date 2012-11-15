package net.anei.cadpage.parsers.PA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class PADelawareCountyAParser extends FieldProgramParser {
  
  private static final Pattern MARKER = Pattern.compile("^\\d\\d:\\d\\d\\*");
  
  public PADelawareCountyAParser() {
    super("DELAWARE COUNTY", "PA",
           "CALL ADDR X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "station55@comcast.net";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    body = body.substring(match.end()).trim();
    return parseFields(body.split("\\*"), data);
  }
}
