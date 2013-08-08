package net.anei.cadpage.parsers.MI;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;


public class MICalhounCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern M_ROUTE_PTN = Pattern.compile("\\bM *(\\d+)\\b"); 
  
  public MICalhounCountyParser() {
    super(CITY_TABLE, "CALHOUN COUNTY", "MI");
  }
  
  @Override
  public String getFilter() {
    return "postmaster@calhouncountymi.gov,mcfd12@gmail.com,CCCDA@calhouncountymi.gov";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Not sure if CCCDA is a separate dispatch center or is massaging pages from
    // county dispatch.  But we can unmassage them so they work
    if (body.startsWith("CCCDA:")) {
      body = body.substring(6).trim();
      int pt1 = body.indexOf(" *: ");
      if (pt1 >= 0) {
        int pt2 = body.indexOf(" *: ", pt1+4);
        if (pt2 < 0) return false;
        body = body.substring(0,pt1) + " TYP: " + body.substring(pt1+4,pt2) + " AD: " + body.substring(pt2+4);
      }
    }
    if (!super.parseMsg(body, data)) return false;
    
    // Correct Mnn to MI nn
    data.strAddress = M_ROUTE_PTN.matcher(data.strAddress).replaceAll("MI $1");
    return true;
  }


  private static final Properties CITY_TABLE = buildCodeTable(new String[]{
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
