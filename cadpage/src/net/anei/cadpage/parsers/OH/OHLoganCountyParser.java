package net.anei.cadpage.parsers.OH;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Logan County, OH
 */
public class OHLoganCountyParser extends DispatchCiscoParser {

  public OHLoganCountyParser() {
    super(CITY_CODES, "LOGAN COUNTY", "OH");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    int pt = body.indexOf('\n');
    if (pt >= 0) body = body.substring(0,pt).trim();
    if (!super.parseMsg(subject, body, data)) return false;
    
    // Cross fields never contain ampesand separators
    // but they often end with city codes (don't ask why).  We can make
    // a good start on things by turning those codes into ampersands
    data.strCross = CITY_PTN.matcher(data.strCross).replaceAll("&");
    if (data.strCross.endsWith("&")) {
      data.strCross = data.strCross.substring(0,data.strCross.length()-1).trim();
    }
    
    // If that didn't work, see if the smart parser can work this out with implied ampersands
    if (!data.strCross.contains("&")) {
      String cross = data.strCross;
      data.strCross = "";
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT | FLAG_ANCHOR_END, cross, data);
      
      // That didn't work.  Try to find an address we can match with something else
      if (!data.strCross.contains("&")) {
        data.strCross = "";
        parseAddress(StartType.START_OTHER, FLAG_ONLY_CROSS, cross, data);
        data.strCross = append(getStart(), " & ", data.strCross);
        data.strCross = append(data.strCross, " & ", getLeft());
      }
    }
    return true;
  }

  @Override
  public String getFilter() {
    return "lcso911@co.logan.oh.us";
  }
  
  private static Pattern CITY_PTN = Pattern.compile("\\b(?:BF|WL|WM|ZF)\\b");
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BF", "BELLEFONTAINE",
      "WL", "WEST LIBERTY",
      "WM", "WEST MANSFIELD",
      "ZF", "ZANESFIELD"
  });
}
