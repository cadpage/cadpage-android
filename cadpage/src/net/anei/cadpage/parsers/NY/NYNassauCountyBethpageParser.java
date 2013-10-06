package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class NYNassauCountyBethpageParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d{4}-\\d{6})\\*\\*\\* ([0-9A-Z]+)\\) ([^\\*]+) \\*\\*\\*(.*?)(?:CS: (.*?))?TOA: (\\d\\d:\\d\\d) (\\d\\d-\\d\\d-\\d\\d)(.*)");
  private static final Pattern UNIT_BRK_PTN = Pattern.compile("(?<=[^ ])(?=STATION|HEADQUARTERS)");

  public NYNassauCountyBethpageParser() {
    super("NASSAU COUNTY", "NY");
    setFieldList("ID CODE CALL ADDR APT X TIME DATE UNIT");
  }
  
  @Override
  public String getFilter() {
    return "900bfd@gmail.com";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    data.strCode = match.group(2);
    data.strCall = match.group(3).trim();
    parseAddress(match.group(4).trim(), data);
    data.strCross = getOptGroup(match.group(5)).replace('\\', '/');
    data.strTime = match.group(6);
    data.strDate = match.group(7).replace('-', '/');
    String unit = match.group(8).trim();
    data.strUnit = UNIT_BRK_PTN.matcher(unit).replaceAll(" ");
    return true;
  };
}


