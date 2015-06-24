package net.anei.cadpage.parsers.NY;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class NYSuffolkCountyHParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("(\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d) (.*?) (AM|EH) (.*)");
  
  public NYSuffolkCountyHParser() {
    super(CITY_LIST, "SUFFOLK COUNTY", "NY");
    setFieldList("DATE TIME CALL SRC ADDR APT CITY INFO");
    setupSpecialStreets(
        "BEACHWAY",
        "CAPTAINS WALK",
        "EDWARDS CLOSE",
        "GLENWAY",
        "GREENWAY",
        "HIGHWOOD",
        "QUALITY ROW",
        "SHORIDGE",
        "WATERS EDGE",
        "WATERSEDGE", 
        "WINDWARD"
    );
  }
  
  @Override
  public String getFilter() {
    return "@easthamptonvillageny.gov";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CALL")) return false;
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    
    data.strDate = match.group(1);
    data.strTime = match.group(2);
    data.strCall = match.group(3).trim();
    data.strSource = match.group(4);
    String addr = match.group(5).trim();
    parseAddress(StartType.START_ADDR, addr, data);
    data.strSupp = getLeft();
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "EAST HAMPTON"
  };
}
