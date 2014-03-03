package net.anei.cadpage.parsers.WA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class WAGrantCountyParser extends SmartAddressParser {

  public WAGrantCountyParser() {
    super("GRANT COUNTY", "WA");
  }

  private static Pattern MASTER = Pattern.compile("(?:(.*?) *: *(.*?) *: *P:(.*?)|(.*?)) *: *(.*?) *: *(.*?) *:? *:+INF: *(.*?) *:CP: *(.*?) *:(?:CNT:.?(\\d{2}:\\d{2}:\\d{2}) (\\d{2}/\\d{2}/\\d{2}) *(.*)|PH: *(.*))");
  private static Pattern UNIT_PRI_CALL = Pattern.compile("(?:(.*?) +([A-D]) +(.*?)|(.*?,Sta ?\\d,?)([A-D]) *(.*?))");
  private static Pattern ADDR = Pattern.compile("(.*?); (?:(?:#|APT|ROOM|RM) *([A-Z]*\\d+)|(.*?))", Pattern.CASE_INSENSITIVE);
  // Info field components
  private static Pattern PHONE = Pattern.compile("(.*?) *(\\(\\d{3}\\)\\d{3}-\\d{4}) *(.*?)");
  private static Pattern TIME = Pattern.compile("(.*?) *(\\d{2}:\\d{2}:\\d{2}) *(.*?)");
  private static Pattern DATE = Pattern.compile("(.*?) *(\\d{2}/\\d{2}/\\d{2}\\d{2})(?: - )?(.*?)");
  // For condensing consecutive spaces
  private static Pattern SPACE = Pattern.compile(" +");

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;
    setFieldList("UNIT PRI CALL ADDR PLACE APT INFO PHONE TIME DATE NAME");

    // UNIT PRI CALL... three possible formats and last resort pass to strCall
    String g1 = mat.group(1);
    if (g1 != null) {
      data.strUnit = g1;
      data.strCall = mat.group(2);
      data.strPriority = mat.group(3);
    } else {
      String g4 = mat.group(4);
      Matcher upcMat = UNIT_PRI_CALL.matcher(g4);
      if (upcMat.matches()) {
        if (upcMat.group(1) != null) {
          data.strUnit = upcMat.group(1);
          data.strPriority = upcMat.group(2);
          data.strCall = upcMat.group(3);
        } else {
          data.strUnit = upcMat.group(4);
          data.strPriority = upcMat.group(5);
          data.strCall = upcMat.group(6);
        }
      } else data.strCall = g4;
    }

    // ADDR APT PLACE
    String addr = mat.group(5);
    Matcher aMat = ADDR.matcher(addr);
    if (aMat.matches()) {
      addr = aMat.group(1);
      String g2 = aMat.group(2);
      if (g2 != null) data.strApt = g2;
      else data.strPlace = aMat.group(3);
    }
    parseAddress(StartType.START_ADDR, addr, data);
    data.strPlace = append(data.strPlace, "; ", mat.group(6));

    // Parse phone date n time out of INF:
    String info = mat.group(7);
    Matcher iMat = PHONE.matcher(info);
    if (iMat.matches()) {
      data.strPhone = iMat.group(2);
      info = append(iMat.group(1), " ", iMat.group(3));
    }
    iMat = TIME.matcher(info);
    if (iMat.matches()) {
      data.strTime = iMat.group(2);
      info = append(iMat.group(1), " ", iMat.group(3));
    }
    iMat = DATE.matcher(info);
    if (iMat.matches()) {
      data.strDate = iMat.group(2);
      info = append(iMat.group(1), " ", iMat.group(3));
    }
    data.strSupp = info;

    // Append CP:(.*?) to unit with repeating spaces condensed
    data.strUnit = append(data.strUnit, " ", SPACE.matcher(mat.group(8)).replaceAll(" "));

    // if CNT:(.*?) exists parse data that hasn't already been taken
    String g9 = mat.group(9);
    if (g9 != null) {
      if (data.strTime.length() == 0) data.strTime = mat.group(9);
      if (data.strDate.length() == 0) data.strDate = mat.group(10);
      data.strName = mat.group(11);
    }
    return true;
  }

}
