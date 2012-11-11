package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class OHEnglewoodParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^:]+?):(\\d\\d:\\d\\d:\\d\\d)-([A-Z0-9]+:[-A-Z0-9]*):([^:?]+):@([^,]+?),([A-Z ]*?):(.*)");
  
  public OHEnglewoodParser() {
    super("ENGLEWOOD", "OH");
  }
  
  @Override
  public String getFilter() {
    return "CAD@englewood.oh.us";
  }
  
  @Override
  public String getLocName() {
    return "Englewood Regional Communications, OH";
  }

  @Override
  public boolean parseMsg(String body, Data data) {
    body = body.replace('\n', ' ').trim();
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1).trim();
    data.strTime =match.group(2).trim();
    data.strCode = match.group(3).trim();
    data.strCall = match.group(4).trim();
    String sAddr = match.group(5).trim().replace("@", " & ");
    parseAddress(sAddr, data);
    data.strCity = match.group(6).trim();
    data.strSupp = match.group(7).trim();
    return true;
  }
}
