package net.anei.cadpage.parsers.OH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

public class OHAshlandCountyParser extends DispatchEmergitechParser {
  
  public OHAshlandCountyParser() {
    super(true, CITY_LIST, "ASHLAND COUNTY", "OH", TrailAddrType.INFO);
    removeWords("PLACE");
  }
  
  private static final Pattern TWP_RD_PTN = Pattern.compile("\\b(CLEAR CREEK|GREEN|HANOVER|JACKSON|LAKE|MIFFLIN|MILTON|MTGMRY|ORANGE|PERRY|RUGGLES|SULLIVAN|TROY) (TWP RD \\d+)\\b");
  private static final Pattern SUITE_PTN = Pattern.compile(" +SUITE: *(APT|RM|LOT)?\\b *");
  private static final Pattern ADDR_APT_INFO_PTN = Pattern.compile("(.*?) (?:APT|RM|LOT) *(\\S+) *(.*)");

  @Override
  protected boolean parseMsg(String body, Data data) {
    
    String twp = null;
    Matcher match = TWP_RD_PTN.matcher(body);
    if (match.find()) {
      twp = match.group(1);
      if (twp.equals("MTGMRY")) twp = "MONTGOMERY";
      StringBuffer sb = new StringBuffer();
      do {
        match.appendReplacement(sb, "$2");
      } while (match.find());
      match.appendTail(sb);
      body = sb.toString();
    }
    
    match = SUITE_PTN.matcher(body);
    if (match.find()) {
      String replace = match.group(1);
      if (replace == null) replace = "LOT";
      body = body.substring(0,match.start()) + ' ' + replace + ' ' + body.substring(match.end());
    }
    
    if (!super.parseMsg(body, data)) return false;
    if (twp != null && data.strCity.length() == 0) data.strCity = twp + " TWP";
    
    if (data.strPlace.length() == 0 && data.strCity.length() == 0 && 
        data.strApt.length() == 0 && data.strSupp.length() == 0) {
      match = ADDR_APT_INFO_PTN.matcher(data.strAddress);
      if (match.matches()) {
        data.strAddress = "";
        parseAddress(match.group(1).trim(), data);
        data.strApt = match.group(2);
        data.strSupp = match.group(3);
      }
    }
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
    
      //City

      "ASHLAND",

      //Villages

      "BAILEY LAKES",
      "HAYESVILLE",
      "JEROMESVILLE",
      "LOUDONVILLE",
      "MIFFLIN",
      "PERRYSVILLE",
      "POLK",
      "SAVANNAH",

      //Townships

      "CLEAR CREEK",
      "GREEN",
      "HANOVER",
      "JACKSON",
      "LAKE",
      "MIFFLIN",
      "MILTON",
      "MOHICAN",
      "MONTGOMERY",
      "ORANGE",
      "PERRY",
      "RUGGLES",
      "SULLIVAN",
      "TROY",
      "VERMILLION",

      //Unincorporated communities

      "ALBION",
      "ENGLAND",
      "FIVE POINTS",
      "HEREFORK",
      "LAKE FORK",
      "MCKAY",
      "MCZENA",
      "MOHICANVILLE",
      "NANKIN",
      "NOVA",
      "PARADISE HILL",
      "REDHAW",
      "ROWSBURG",
      "RUGGLES",
      "SPRENG",
      "SULLIVAN",
      "WIDOWVILLE"


  };
}
