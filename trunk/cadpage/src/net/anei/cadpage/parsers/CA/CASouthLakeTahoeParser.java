package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class CASouthLakeTahoeParser extends SmartAddressParser {

  public CASouthLakeTahoeParser() {
    super(CITY_LIST, "SOUTH LAKE TAHOE", "CA");
    setFieldList("CALL ADDR APT CITY UNIT X");
  }

  private static Pattern MASTER = Pattern.compile("Event Notice: (.*?) at (?:\\(Location Not Entered\\)|(.*?,  .*?)|(.*?)) *(?:/FD: *(.*?))?(?:/Location not matched in geo file|/(.*?))?/by .*");

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;
    //CALL
    data.strCall = mat.group(1);
    //ADDR
    if (mat.group(2) != null) {
      // if captured group is the one containing ",  " replace with &
      parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT, mat.group(2).replace(",  ", " & "), data);
    } else parseAddress(StartType.START_ADDR, FLAG_RECHECK_APT, getOptGroup(mat.group(3)), data);
    //UNIT CROSS
    data.strUnit = getOptGroup(mat.group(4));
    data.strCross = getOptGroup(mat.group(5));
    return true;
  }

  private static String[] CITY_LIST = new String[] { "S Lake Tahoe" };

}
