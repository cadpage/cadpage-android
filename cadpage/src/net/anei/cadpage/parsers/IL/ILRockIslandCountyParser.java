package net.anei.cadpage.parsers.IL;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.MsgParser;



public class ILRockIslandCountyParser extends MsgParser {
  
  private static final Pattern MASTER = 
      Pattern.compile("(?:@([A-Z]+): )?(\\d+):([\\w: ]*);([^;]+?);([^;]+?)(?:;([A-Z]+))?");
  
  public ILRockIslandCountyParser() {
    super("ROCK ISLAND COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "cad@ricoetsb.org";
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strSource = getOptGroup(match.group(1));
    data.strCallId = match.group(2);
    String type = match.group(3).trim();
    String sAddr;
    if (type.equals("CANCEL")) {
      data.strCall = type + " - " + match.group(5).trim();
      sAddr = match.group(4).trim();
    } else {
      data.strCall = match.group(4).trim();
      sAddr = match.group(5).trim();
    }
    String city = match.group(6);
    if (city != null) data.strCity = convertCodes(city, CITY_CODES);
      
    parseAddress(sAddr, data);
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "MO",   "MOLINE",
      "RI",   "ROCK ISLAND",
      "RIA",  "ROCK ISLAND ARSENAL"
  });
  
}
