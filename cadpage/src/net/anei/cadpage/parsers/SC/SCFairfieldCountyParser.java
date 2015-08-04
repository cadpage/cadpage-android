
package net.anei.cadpage.parsers.SC;

import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class SCFairfieldCountyParser extends DispatchSouthernParser {

  public SCFairfieldCountyParser() {
    super(CITY_LIST, "FAIRFIELD COUNTY", "SC", DSFLAG_LEAD_PLACE | DSFLAG_FOLLOW_CROSS |  DSFLAG_LEAD_UNIT);
  }

  private static final Pattern MILE_MARKER_PTN = Pattern.compile("\\d+ MILE MARKER \\d+");
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    data.strAddress = data.strAddress.replace("INTERSTATE", "I");
    
    if (MILE_MARKER_PTN.matcher(data.strPlace).matches()) {
      data.strAddress = append(data.strPlace, " ", data.strAddress);
      data.strPlace = "";
    }
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
      
      "BLACKSTOCK",
      "BLAIR",
      "BUCKLICK",
      "JENKINSVILLE",
      "MITFORD",
      "MONTICELLO",
      "RIDGEWAY",
      "WINNSBORO",
      "WINNSBORO MILLS",
      
      // Chester County
      "GREATFALLS",
      "GREAT FALLS"
      
  };
}
