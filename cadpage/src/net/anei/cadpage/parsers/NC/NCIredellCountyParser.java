package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCIredellCountyParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = Pattern.compile("((?:A|FA|FD|FM|FR)\\d+?(?=[ A-Z]|10-)|MFD|MRS|ICRS|SFD) *([^,]+), *([^,]*)(?:, *(\\d{2}-\\d{5,6}))?");
  
  public NCIredellCountyParser() {
    super("IREDELL COUNTY", "NC");
    setFieldList("UNIT CALL ADDR ID");
  }
  
  @Override
  public String getFilter() {
    return "CommtechMessenger,@co.iredell.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = getOptGroup(match.group(1));
    data.strCall = match.group(2).trim();
    parseAddress(match.group(3), data);
    data.strCallId = getOptGroup(match.group(4));
    return data.strAddress.length() > 0;
  }
}
