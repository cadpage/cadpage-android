package net.anei.cadpage.parsers.OH;

import java.util.Properties;

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
    return super.parseMsg(subject, body, data);
  }

  @Override
  public String getFilter() {
    return "lcso911@co.logan.oh.us";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BF", "BELLEFONTAINE",
      "WL", "WEST LIBERTY",
      "WM", "WEST MANSFIELD",
      "ZF", "ZANESFIELD"
  });
}
