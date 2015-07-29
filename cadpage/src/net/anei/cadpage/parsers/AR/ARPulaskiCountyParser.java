
package net.anei.cadpage.parsers.AR;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Pulaski County, AL
 */

public class ARPulaskiCountyParser extends DispatchSouthernParser {
  
  public ARPulaskiCountyParser() {
    super(getKeywords(CITY_CODES), "PULASKI COUNTY", "AR", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strCity = convertCodes(data.strCity.toUpperCase(), CITY_CODES);
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NLR",  "NORTH LITTLE ROCK",
      "MAUM", "MAUMELLE"
  });
}
