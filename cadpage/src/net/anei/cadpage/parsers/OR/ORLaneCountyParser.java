package net.anei.cadpage.parsers.OR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

public class ORLaneCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern GEN_ALERT_PTN = Pattern.compile("([A-Z]+) +TIME: *([:0-9]+) +(.*)");
  
  public ORLaneCountyParser() {
    super(CITY_CODES, "LANE COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "ce911@ci.eugene.or.us";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher match = GEN_ALERT_PTN.matcher(body);
    if (match.matches()) {
      data.strCall = "GENERAL ALERT";
      data.strUnit = match.group(1);
      data.strTime = match.group(2);
      data.strPlace = match.group(3);
      return true;
    }
    return super.parseMsg(body, data);
  }

  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "UNC BLA", "BLACHLY",
      "UNC BLU", "BLUE RIVER",
      "UNC CHE", "CHESHIRE",
      "UNC COT", "COTTAGE GROVE",
      "UNC CRE", "CRESWELL",
      "UNC DEA", "DEADWOOD",
      "UNC DEX", "DEXTER",
      "UNC DOR", "DORENA",
      "UNC ELM", "ELMIRA",
      "UNC EUG", "EUGENE",
      "UNC FAL", "FALL CREEK",
      "UNC FLO", "FLORENCE",
      "UNC HAR", "HARRISBURG",
      "UNC JUN", "JUNCTION CITY",
      "UNC LEA", "LEABURG",
      "UNC LOR", "LORANE",
      "UNC LOW", "LOWELL",
      "UNC MAP", "MAPLETON",
      "UNC MAR", "MARCOLA",
      "UNC MON", "MONROE",
      "UNC NOT", "NOTI",
      "UNC OAK", "OAKRIDGE",
      "UNC PLE", "PLEASANT HILL",
      "UNC SPR", "SPRINGFIELD",
      "UNC SWI", "SWISSHOME",
      "UNC VEN", "VENETA",
      "UNC VID", "VIDA",
      "UNC WAN", "WALTON",
      "UNC WEF", "WESTFIR",
      "UNC WES", "WESTLAKE",
      "UNC YAC", "YACHATS"
  });
}
