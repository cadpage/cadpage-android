package net.anei.cadpage.parsers.IN;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Marion County, IN
Contact: Tod Parker <tod@phototac.com>
Sender: CAD@pager.mecagov.org

2265 S MERIDIAN ST,IND S02300 W00001 GARAGE/WORKI LD13 MD29 TS18 SF06 C1205 C1823 IPAGE MEDIA I05320
1702 E GIMBER ST,IND S02750 E01700 STRUCT/COLLAPSE CSTF TC01 LD01 TC23 EG23 SQ10 C1103 SF06 C1823 MD29 EG29 LD29 BC14 DST6 OP1 I05219
W 16TH ST/N AUBURN ST,SPD N01600 W05000 APARTMNT/WORKI LD30 TS18 TS83 SF08 WRKFIR IFDFYI I05193
E WASHINGTON ST/S ORIENTAL ST,IND N00100 E01400 BUILDING/WORKI JUST FYI ON FD-OP05 (LP) I05087 @ FROM: IF40
E WASHINGTON ST/S ORIENTAL ST,IND N00100 E01400 BUILDING/WORKI IFDFYI FIRE UNDER CONTROL ON OP5 BC14 COMMAND...ENC3 I05087 @ FROM: IF44
4512 E 21ST ST,IND N02100 E04500 RESIDENCE/WORKIN LD27 MD20 TS25 SF04 C1205 C1822 IPAGE MEDIA I05068
8850 FALL CREEK RD,LWR N07000 E08900 CIV/FATALITY IFDFYI SINGLE FATALITY ON OP3...ENC I04762 @ FROM: IF42
E 30TH ST/N GERMAN CHURCH RD,WAR N03200 E11000 FIELD IFDFYI...FYI ONLY, SEVERAL IFD APPARATUS, EG37 FROM LAWRENCE, AND HANCOCK CO GRASS TRUCK ON THIS :1of2

*/

public class INMarionCountyParser extends MsgParser {
  
  private static final Pattern MASTER = Pattern.compile("([^,]+),([A-Z]{3}) ([NS]\\d{5} [EW]\\d{5}) ([^ ]+) (.*)");
  private static final Pattern UNIT_PTN = Pattern.compile("^(?:[A-Z]+[0-9]+|IPAGE|MEDIA)\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "IND", "Indianapolis",
      "LWR", "Lawrence TWP",
      "PIK", "Pike TWP",
      "WAY", "Wayne TWP",
      "SPD", "Speedway",
      "PER", "Perry TWP",
      "DEC", "Decatur TWP",
      "WAR", "Warren TWP",
      "WAS", "Washington TWP",
      "HAM", "Hamilton County"
  });
  
  
  public INMarionCountyParser() {
    super("MARION COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "CAD@pager.mecagov.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    parseAddress(match.group(1).trim(), data);
    data.strCity = convertCodes(match.group(2), CITY_CODES);
    data.strMap = match.group(3);
    data.strCall = match.group(4);
    String sExtra = match.group(5).trim();
    if (UNIT_PTN.matcher(sExtra).find()) {
      data.strUnit = sExtra;
    } else {
      data.strSupp = sExtra;
    }
    return true;
    
  }
}
