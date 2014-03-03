package net.anei.cadpage.parsers.FL;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class FLCitrusCountyParser extends SmartAddressParser {
  
  private static final Pattern TRUNC_CITY_PTN = Pattern.compile("(?: [A-Z][a-z]+)+(?: [A-Z])?$");
  private static final Pattern MASTER = Pattern.compile("Unit:([A-Z0-9]+) Status:Dispatched ([A-Z0-9]+) - (.*?) (\\d{2}[A-Z]) (.*)");

  
  public FLCitrusCountyParser() {
    super(CITY_LIST, "CITRUS COUNTY", "FL");
    setFieldList("UNIT CODE CALL MAP ADDR APT X CITY INFO");
  }
  
  @Override
  public String getFilter() {
    return "777,888,ddevoe@sheriffcitrus.org";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    do {
      if (body.startsWith("CITRUS COUNTY FIRE DEPARTMENT ")) {
        body = body.substring(30).trim();
        break;
      }
      if (subject.equals("Message from HipLink")) break;
      return false;
    } while (false);
    
    // There is a problem with truncated cities.  See if we can identify and restore a truncated
    // camel case city at the end of the text body
    Matcher match = TRUNC_CITY_PTN.matcher(body);
    if (match.find()) {
      String truncCity = match.group().trim();
      SortedSet<String> set = CITY_SET.tailSet(truncCity);
      if (!set.isEmpty()) {
        String city = set.first();
        if (city.startsWith(truncCity)) {
          body = body.substring(0,match.start()) + ' ' + city;
        }
      }
    }
    
    match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    data.strCode = match.group(2);
    data.strCall = match.group(3);
    data.strMap = match.group(4);
    String sAddr = match.group(5).trim();
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS, sAddr, data);
    data.strCross = getPadField();
    data.strSupp = getLeft();
    return true;
  }
  
  @Override
  public String adjustMapAddress(String addr) {
    return addr.replace("GULF TO LAKE", "GULF-TO-LAKE");
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Incorporated
    "CRYSTAL RIVER",
    "INVERNESS",
    
    // Unincorporated
    "BEVERLY HILLS",
    "BLACK DIAMOND",
    "CHASSAHOWITZKA",
    "CITRUS HILLS",
    "CITRUS SPRINGS",
    "FLORAL CITY",
    "HERNANDO",
    "HOLDER",
    "HOMOSASSA SPRINGS",
    "HOMOSASSA",
    "INVERNESS HIGHLANDS NORTH",
    "INVERNESS HIGHLANDS SOUTH",
    "LECANTO",
    "MEADOWCREST",
    "PINE RIDGE",
    "PINEOLA",
    "RED LEVEL",
    "SUGARMILL WOODS"
  }; 
  
  private static final TreeSet<String> CITY_SET = new TreeSet<String>();
  static {
    for (String city : CITY_LIST) CITY_SET.add(toCamelCase(city));
  }
  private static String toCamelCase(String city) {
    StringBuilder sb = new StringBuilder();
    boolean downshift = false;
    for (char chr : city.toCharArray()) {
      if (downshift) chr = Character.toLowerCase(chr);
      sb.append(chr);
      downshift = (chr != ' ');
    }
    return sb.toString();
  }
}
