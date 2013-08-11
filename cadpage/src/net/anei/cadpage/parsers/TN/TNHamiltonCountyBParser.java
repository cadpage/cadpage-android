package net.anei.cadpage.parsers.TN;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class TNHamiltonCountyBParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^,]+), ([ A-Z]+) \\(([^\\)]+)\\) (.*?) ([^ ]+) \n: (.*)");
  
  public TNHamiltonCountyBParser() {
    super("HAMILTON COUNTY", "TN");
    setFieldList("ADDR APT CITY X SRC UNIT CALL");
  }
  
  public String getFilter() {
    return "7774";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strCity = match.group(2).trim();
    data.strCross = match.group(3).trim();
    data.strSource = match.group(4).trim();
    data.strUnit = match.group(5);
    data.strCall = match.group(6).trim();
    return true;
  }
}
