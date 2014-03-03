package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class CAHaywardCountyParser extends SmartAddressParser {

  public CAHaywardCountyParser() {
    super(CITY_LIST, "HAYWARD COUNTY", "CA");
  }

  private static Pattern TAGGED_MASTER = Pattern.compile("Location: *(.*?) *(-?\\d{1,3}\\.\\d+ -?\\d{1,3}\\.\\d+) *(.*?) *Common Name: *(.*?) *Call Type: *(.*?) *Call Time: *(\\d{2}/\\d{2}/\\d{2}) *(\\d{2}:\\d{2}) *Call Number: *-?(\\d+) *Narrative: *(.*?)");
  private static Pattern UNTAGGED_MASTER = Pattern.compile("(?:([A-Z0-9 ]+?)  )?([A-Z]{4}) (.*?) (\\d{2}/\\d{2}/\\d{2}) (\\d{2}:\\d{2})  (.*?)(?: *E911 Info.*)?");

  @Override
  public int getMapFlags() {
    return MAP_FLG_PREFER_GPS;
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    // Tagged format
    Matcher mat = TAGGED_MASTER.matcher(body);
    if (mat.matches()) {
      setFieldList("ADDR APT X CITY GPS PLACE CALL DATE TIME ID INFO");
      // ADDR CITY APT
      parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, mat.group(1), data);
      // X
      parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_ANCHOR_END, getPadField(), data);
      // PLACE GPS
      setGPSLoc(getOptGroup(mat.group(2)), data);
      data.strPlace = mat.group(3);
      // PLACE CALL DATE TIME ID INFO<
      data.strPlace = append(data.strPlace, " - ", mat.group(4));
      data.strCall = mat.group(5);
      data.strDate = mat.group(6);
      data.strTime = mat.group(7);
      data.strCallId = mat.group(8);
      data.strSupp = mat.group(9);
      return true;
    }

    // UnTagged format
    mat = UNTAGGED_MASTER.matcher(body);
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
