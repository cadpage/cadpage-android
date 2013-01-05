package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class NCIredellCountyParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = Pattern.compile("(F[RD]\\d+|[A-Z]{1,2}FD) *([^,]+), *(.*)");
  
  public NCIredellCountyParser() {
    super("IREDELL COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "CommtechMessenger,@co.iredell.nc.us";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.matches()) return false;
    data.strSource = match.group(1);
    data.strCall = match.group(2).trim();
    parseAddress(match.group(3), data);
    return data.strAddress.length() > 0;
  }
}
