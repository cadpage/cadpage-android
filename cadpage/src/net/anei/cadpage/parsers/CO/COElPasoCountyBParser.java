package net.anei.cadpage.parsers.CO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class COElPasoCountyBParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d+)\\*([A-Z\\d]+) +([A-Z\\d,]+),([A-Z]{3}\\d)(.+?) ?(?:Map (.*?))? ?(\\d{2}:\\d{2}:\\d{2})(.*?)Report C\\d+");

  public COElPasoCountyBParser() {
    super("EL PASO COUNTY", "CO");
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    setFieldList("SRC CODE UNIT ID ADDR APT PLACE MAP TIME CALL");
    Matcher mat = MASTER.matcher(body);
    if (mat.matches()) {
      data.strSource = mat.group(1);
      data.strCode = mat.group(2);
      data.strUnit = mat.group(3).trim();
      data.strCallId = mat.group(4);
      parseAddress(StartType.START_ADDR, mat.group(5), data);
      data.strPlace = getLeft();
      data.strMap = getOptGroup(mat.group(6));
      data.strTime = mat.group(7);
      data.strCall = mat.group(8).trim();
      return true;
    } else return false;
  }
  
}
