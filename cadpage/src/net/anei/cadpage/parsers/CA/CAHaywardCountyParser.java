package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA42Parser;

public class CAHaywardCountyParser extends DispatchA42Parser {

  public CAHaywardCountyParser() {
    super(CITY_LIST, "HAYWARD COUNTY", "CA");
  }

  private static Pattern UNTAGGED_MASTER = Pattern.compile("(?:([A-Z0-9 ]+?)  )?([A-Z]{4}) (.*?) (\\d{2}/\\d{2}/\\d{2}) (\\d{2}:\\d{2})  (.*?)(?: *E911 Info.*)?");

  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    // Check for common tagged format
    if (super.parseMsg(body, data)) return true;

    // UnTagged format
    Matcher mat = UNTAGGED_MASTER.matcher(body);
    if (mat.matches()) {
      setFieldList("UNIT CALL APT CITY ADDR DATE TIME INFO");
      data.strUnit = getOptGroup(mat.group(1));
      data.strCall = mat.group(2);
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT | FLAG_ANCHOR_END, mat.group(3), data);
      data.strDate = mat.group(4);
      data.strTime = mat.group(5);
      data.strSupp = mat.group(6);
      return true;
    }

    return false;
  }

  private static String[] CITY_LIST = new String[] { "HAYWARD" };

}
