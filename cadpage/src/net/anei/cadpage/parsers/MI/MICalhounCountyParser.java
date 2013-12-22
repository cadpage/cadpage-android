package net.anei.cadpage.parsers.MI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.GroupBestParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class MICalhounCountyParser extends GroupBestParser {
  
  public MICalhounCountyParser() {
    super(new MICalhounCountyAParser(), new MICalhounCountyBParser());
  }
  
  static void cleanup(Data data) {
    // Correct Mnn to MI nn
    data.strAddress = M_ROUTE_PTN.matcher(data.strAddress).replaceAll("MI $1");
  }
  
  private static final Pattern M_ROUTE_PTN = Pattern.compile("\\bM *(\\d+)\\b"); 


  static final Properties CITY_TABLE = buildCodeTable(new String[]{
      "AL", "ALBION",
      "AS", "ATHENS TWP",
      "AT", "ALBION TWP",
      "BC", "BATTLE CREEK",
      "BE", "BEDFORD TWP",
      "BT", "BURLINGTON TWP",
      "BU", "BURLINGTON",
      "CL", "CLARENCE TWP",
      "CT", "CLARENDON TWP",
      "CO", "CONVIS TWP",
      "EC", "ECKFORD TWP",
      "ET", "EMMETT TWP",
      "FT", "FREDONIA TWP",
      "HO", "HOMER VILLIAGE",
      "HP", "HOMER TWP",
      "LE", "LEE TWP",
      "LT", "LEROY TWP",
      "MA", "MARSHALL",
      "MO", "MARENGO TWP",
      "MT", "MARSHALL TWP",
      "NT", "NEWTON TWP",
      "PT", "PENNFIELD TWP",
      "SF", "SPRINGFIELD",
      "ST", "SHERIDAN TWP",
      "TK", "TEKONSHA",
      "TT", "TEKONSHA TWP",
      "VA", "ATHENS"
  });
}
