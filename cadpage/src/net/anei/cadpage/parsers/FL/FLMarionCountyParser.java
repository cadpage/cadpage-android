package net.anei.cadpage.parsers.FL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;

public class FLMarionCountyParser extends MsgParser {
  
  public FLMarionCountyParser() {
    super("MARION COUNTY", "FL");
    setFieldList("UNIT ID CALL ADDR PLACE APT CITY MAP");
  }
  
  private static final Pattern MASTER = Pattern.compile("\\*{3}CALL ALERT\\*{3} (\\S+) Case #(\\d{4}-\\d{6}) Ref:(.*?)Address:(.*?)Loc Name:(.*?)Apt/Lot/Rm#:(.*?)Bldg/Wing:(.*?)Zip (\\d*) Map Page pg (.*)");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    body = stripFieldEnd(body, ",");
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    data.strCallId = match.group(2);
    data.strCall = match.group(3).trim();
    parseAddress(match.group(4).trim(), data);
    data.strPlace = match.group(5).trim();
    String apt = append(match.group(7).trim(), "-", match.group(6).trim());
    data.strApt = append(data.strApt, "-", apt);
    data.strCity = match.group(8);
    data.strMap = match.group(9).trim();
    return true;
  }

}
