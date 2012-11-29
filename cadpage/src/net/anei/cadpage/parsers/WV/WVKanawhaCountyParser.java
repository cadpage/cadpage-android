package net.anei.cadpage.parsers.WV;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;


public class WVKanawhaCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("(?:Metro911:)?(.+?) reported at (.+?) in (.+?) on (\\d\\d/\\d\\d/\\d\\d) (\\d\\d:\\d\\d)");
  
  public WVKanawhaCountyParser() {
    super("KANAWHA COUNTY", "WV");
  }
  
  @Override
  public String getFilter() {
    return "METRO911@metro911.org";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCall = match.group(1).trim();
    parseAddress(match.group(2).trim().replaceAll("//", "/"), data);
    data.strCity = match.group(3).trim();
    if (data.strCity.equals("SISSONVILLE")) {
      data.strPlace = data.strCity;
      data.strCity = "CHARLESTON";
    }
    data.strDate = match.group(4);
    data.strTime = match.group(5);
    return true;
  }
}
