package net.anei.cadpage.parsers.IL;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class ILDuPageCountyCParser extends SmartAddressParser {

  public ILDuPageCountyCParser() {
    super("DUPAGE COUNTY", "IL");
    setFieldList("DATE TIME ID ADDR MAP CALL");
  }
  
  private static Pattern MASTER = Pattern.compile("(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2}:\\d{2} [AP]M) (\\d+)\n *(.*?) *(?:MAP +PAGE:(.*?) *)\n *(.*?)");
  
  private static SimpleDateFormat TIME_FMT = new SimpleDateFormat("hh:mm:ss aa");
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;
    data.strDate = mat.group(1);
    setTime(TIME_FMT, mat.group(2), data);
    data.strCallId = mat.group(3);
    parseAddress(mat.group(4), data);
    data.strMap = getOptGroup(mat.group(5));
    data.strCall = mat.group(6);
    return true;
  }

}
