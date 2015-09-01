
package net.anei.cadpage.parsers.AR;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/**
 * Pulaski County, AR
 */

public class ARPulaskiCountyParser extends DispatchSouthernParser {
  
  public ARPulaskiCountyParser() {
    super(getKeywords(CITY_CODES), "PULASKI COUNTY", "AR", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS);
  }
  
  private static final Pattern TRAIL_APT_PTN = Pattern.compile("(.*) ([A-H][A-Z]*\\d[A-Z0-9]*|(?!AV)[AB][A-Z])");
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strCity = convertCodes(data.strCity.toUpperCase(), CITY_CODES);
    if (data.strApt.length() == 0) {
      Matcher match = TRAIL_APT_PTN.matcher(data.strAddress);
      if (match.matches()) {
        data.strAddress = match.group(1).trim();
        data.strApt = match.group(2);
      }
    }
    return true;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "NLR",  "NORTH LITTLE ROCK",
      "MAUM", "MAUMELLE"
  });
}
