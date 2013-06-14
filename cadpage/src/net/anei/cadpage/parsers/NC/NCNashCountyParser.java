package net.anei.cadpage.parsers.NC;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.CodeSet;
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class NCNashCountyParser extends SmartAddressParser {
  
  private static final Pattern DATE_TIME_PTN = Pattern.compile(" (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d) : pos\\d+ : [A-Z0-9]+\\b",Pattern.CASE_INSENSITIVE); 
  private static final Pattern DATE_TIME_PTN2 = Pattern.compile(" (\\d\\d/\\d\\d/\\d{4}) (\\d\\d:\\d\\d:\\d\\d)\\b");
  private static final Pattern DATE_TIME_PTN3 = Pattern.compile(" \\d\\d/[\\d /:]*$");
  
  public NCNashCountyParser() {
    super(CITY_LIST, "NASH COUNTY", "NC");
    setFieldList("ADDR APT CITY X CALL NAME UNIT DATE TIME INFO");
  }
  
  @Override
  public String getFilter() {
    return "nash911@nashcountync.gov,9300";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (body.startsWith("/ ")) body = body.substring(2).trim();
    if (!body.startsWith("NASH911:")) return false;
    body = body.substring(8).trim();
    
    Matcher match = DATE_TIME_PTN.matcher(body);
    if (match.find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      data.strSupp = body.substring(match.end()).trim();
      body = body.substring(0,match.start());
    } 
    
    else if ((match = DATE_TIME_PTN2.matcher(body)).find()) {
      data.strDate = match.group(1);
      data.strTime = match.group(2);
      body = body.substring(0,match.start());
    } 
    
    else if ((match = DATE_TIME_PTN3.matcher(body)).find()) {
      body = body.substring(0,match.start());
    } 
    
    body = body.replace("//", "/");
    parseAddress(StartType.START_ADDR, FLAG_CROSS_FOLLOWS, body, data);
    String left = getLeft();
    if (left.length() == 0) return false;
    
    // look for cross street information
    Result res = parseAddress(StartType.START_ADDR, FLAG_ONLY_CROSS | FLAG_IMPLIED_INTERSECT, left);
    if (res.getStatus() > 0) {
      res.getData(data);
      left = res.getLeft();
    }
    
    Parser p;
    String call = CALL_SET.getCode(left);
    if (call != null) {
      p = new Parser(left.substring(call.length()).trim());
    } else {
      p = new Parser(left);
      call = p.get(' ');
    }
    data.strCall = call;
    data.strUnit = p.getLast(' ');
    data.strName = cleanWirelessCarrier(p.get());
    return true;
  }
  
  private static final CodeSet CALL_SET = new CodeSet(
      "ALARM-FIRE",
      "CHEST-H",
      "DIABETIC-H",
      "GAS LEAK",
      "HEART PR-H",
      "MEDICAL",
      "MVA PI-H",
      "MVA PIN-H",
      "OUTSIDE FI",
      "PSYC.SUI-H",
      "SEIZURES-H",
      "STRUCTURE",
      "TRAUMA-H",
      
      "ALL FIRE RELATED ALARMS"
  );
  
  private static final String[] CITY_LIST = new String[]{
      "BAILEY",
      "CASTALIA",
      "DORTCHES",
      "ELM CITY",
      "MIDDLESEX",
      "MOMEYER",
      "NASHVILLE",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "WHITAKERS",
      "BAILEY",
      "BATTLEBORO",
      "CASTALIA",
      "COOPERS",
      "DRY WELLS",
      "FERRELLS",
      "GRIFFINS",
      "JACKSON",
      "MANNINGS",
      "NASHVILLE",
      "NORTH WHITAKERS",
      "OAK LEVEL",
      "RED OAK",
      "ROCKY MOUNT",
      "SPRING HOPE",
      "SOUTH WHITAKERS",
      "STONY CREEK"
  };
}
