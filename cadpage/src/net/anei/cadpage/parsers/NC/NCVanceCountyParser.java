package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;


public class NCVanceCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("VanceCounty911:(\\d{4}-\\d{6}) +([^,]*) +([A-Z0-9,]+.*)");
  
  public NCVanceCountyParser() {
    super(CITY_LIST, "VANCE COUNTY", "NC");
    setFieldList("ID ADDR CALL CITY NAME UNIT");
  }
  
  @Override
  public String getFilter() {
    return "VanceCounty911@vancecounty.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCallId = match.group(1);
    body = match.group(2).replace("//", "/");
    data.strUnit = match.group(3);
    
    parseAddress(StartType.START_ADDR, body, data);
    body = getLeft();
    if (body.length() == 0) return false;
    
    String call = CALL_SET.getCode(body);
    if (call != null) {
      data.strCall = call;
      data.strName = body.substring(call.length()).trim();
    } else {
      data.strCall = body;
    }
    return true;
  }
  
  private CodeSet CALL_SET = new CodeSet(
      "ACCIDENT PERSONAL INJURY",
      "CHIMNEY FIRE",
      "MEDICAL",
      "MISSING PERSON",
      "STRUCTURE FIRE"
  );
  
  private static final String[] CITY_LIST = new String[]{
    "HENDERSON",
    "KITTRELL",
    "MIDDLEBURG",
    "SOUTH HENDERSON"
  };
}
