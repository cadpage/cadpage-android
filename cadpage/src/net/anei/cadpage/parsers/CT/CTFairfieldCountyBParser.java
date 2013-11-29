package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

public class CTFairfieldCountyBParser extends SmartAddressParser {

  public CTFairfieldCountyBParser() {
    super(CITY_LIST, "FAIRFIELD COUNTY", "CT");
    setFieldList("ADDR CITY CALL TIME");
  }

  private static Pattern MASTER = Pattern.compile(" *EMS: (.*?) - (.*?) --Disp @ (\\d{2}:\\d{2})");
  
  @Override protected boolean parseMsg(String body, Data data) {
    Matcher mat = MASTER.matcher(body);
    if (!mat.matches()) return false;
    parseAddress(StartType.START_ADDR, mat.group(1), data);
    data.strCall = mat.group(2);
    data.strTime = mat.group(3);
    return true;
  }
  
  private static String[] CITY_LIST = new String[]{ "MONROE" };
  
}
