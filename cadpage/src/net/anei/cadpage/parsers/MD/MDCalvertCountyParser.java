package net.anei.cadpage.parsers.MD;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.SmartAddressParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class MDCalvertCountyParser extends SmartAddressParser {
  
  private static final String[] CITY_LIST = new String[] {
    "CHESAPEAKE BEACH", "NORTH BEACH", 
    "DUNKIRK", "HUNTINGTOWN", "LUSBY","OWINGS", "PRINCE FREDERICK", "ST LEONARD", "SOLOMONS",
    "BARSTOW", "BROOMES ISLAND", "DARES BEACH", "DOWELL", "LOWER MARLBORO", "PORT REPUBLIC", "SUNDERLAND"
  };
  
  private static final Pattern UNIT_PTN = Pattern.compile("\\b(?:[BETSRAM]\\d{1,3}|TN\\d|NDC|NMED|COM)\\b");
  private static final Pattern TIME_DATE_PTN = Pattern.compile("\\b(\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d\\d)\\b");
  private static final Pattern ID_PTN = Pattern.compile("\\b\\d{4}-\\d{8}\\b");
  
  public MDCalvertCountyParser() {
    super(CITY_LIST, "CALVERT COUNTY", "MD");
  }
  
  @Override
  public String getFilter() {
    return "dispatch@co.cal.md.us";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    Matcher timeDateMatch = TIME_DATE_PTN.matcher(body);
    if (! timeDateMatch.find()) return false;
    data.strTime = timeDateMatch.group(1);
    data.strDate = timeDateMatch.group(2);
    
    String strCall = body.substring(0,timeDateMatch.start()).trim();
    Matcher unitMatch = UNIT_PTN.matcher(strCall);
    if (unitMatch.find()) {
      data.strUnit = strCall.substring(unitMatch.start());
      strCall = strCall.substring(0,unitMatch.start()).trim();
    }
    data.strCall = strCall;
    
    Matcher idMatch = ID_PTN.matcher(body);
    boolean foundID = idMatch.find(timeDateMatch.end());
    String strAddress = (foundID ? body.substring(timeDateMatch.end(), idMatch.start())
                                 : body.substring(timeDateMatch.end())).trim();
    Parser p = new Parser(strAddress);
    if (p.get(' ').equalsIgnoreCase("BOX")) {
      data.strBox = p.get(' ');
      strAddress = p.get();
    }
    parseAddress(StartType.START_ADDR, strAddress, data);
    data.strPlace = getLeft();
    
    if (foundID) {
      data.strCallId = idMatch.group();
      data.strSupp = body.substring(idMatch.end()).trim();
    }
    return true;
  }
}
