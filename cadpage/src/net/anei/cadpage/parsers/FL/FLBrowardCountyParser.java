package net.anei.cadpage.parsers.FL;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchPrintrakParser;

/**
 * Broward County, FL
 */

public class FLBrowardCountyParser extends DispatchPrintrakParser {
  
  private static final Pattern M_ROUTE_PTN = Pattern.compile("\\bM *(\\d+)\\b"); 
  
  public FLBrowardCountyParser() {
    super(CITY_TABLE, "BROWARD COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "CAD@Sheriff.org";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // Not sure if CCCDA is a separate dispatch center or is massaging pages from
    // county dispatch.  But we can unmessage them so they work
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
      "BC", "BROWARD COUNTY",
      "CK", "COCONUT CREEK",
      "CC", "COOPER CITY",
      "CS", "CORAL SPRINGS",
      "DN", "DANIA BEACH",
      "DV", "DAVIE",
      "DR", "DEERFIELD BEACH",
      "FL", "FORT LAUDERDALE",
      "HD", "HALLANDALE BEACH",
      "HW", "HOLLYWOOD",
      "LL", "LAUDERDALE LAKES",
      "LS", "LAUDERDALE-BY-THE-SEA",
      "LH", "LAUDERHILL",
      "LZ", "LAZY LAKE",
      "LP", "LIGHTHOUSE POINT",
      "MG", "MARGATE",
      "MM", "MIRAMAR",
      "NL", "NORTH LAUDERDALE",
      "OP", "OAKLAND PARK",
      "PK", "PEMBROKE PARK",
      "PP", "PEMBROKE PINES",
      "PL", "PLANTATION",
      "PB", "POMPANO BEACH",
      "SR", "SEA RANCH LAKES",
      "SW", "SOUTHWEST RANCHES",
      "SN", "SUNRISE",
      "TM", "TAMARAC",
      "WS", "WESTON",
      "WP", "WEST PARK",
      "WM", "WILTON MANORS"
     
  });
}
