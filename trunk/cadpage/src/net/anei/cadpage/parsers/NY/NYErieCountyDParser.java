package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;




public class NYErieCountyDParser extends MsgParser {

  private static final Pattern MASTER = Pattern.compile("([A-Z]{3}) (.*?) ((?:EMS|EMA|MVA)\\b.*)");
  
  public NYErieCountyDParser() {
    super("ERIE COUNTY", "NY");
  }

  @Override
  protected boolean parseMsg(String body, Data data) { 

    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    String city = CITY_CODES.getProperty(match.group(1));
    if (city == null) return false;
    data.strCity = city;
    parseAddress(match.group(2).trim(), data);
    data.strCall = match.group(3).trim();
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLA", "CLARENCE",
      "AMH", "AMHERST",
      "WMV", "WILLIAMSVILLE"
  });
}
	