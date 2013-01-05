package net.anei.cadpage.parsers.FL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class FLCitrusCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("CITRUS COUNTY FIRE DEPARTMENT Unit:([A-Z0-9]+) Status:Dispatched ([A-Z0-9]+) - ([A-Z ]+) (\\d{2}[A-Z]) (.*)");

  
  public FLCitrusCountyParser() {
    super(CITY_LIST, "CITRUS COUNTY", "FL");
  }
  
  @Override
  public String getFilter() {
    return "777,888";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strUnit = match.group(1);
    data.strCode = match.group(2);
    data.strCall = match.group(3);
    data.strMap = match.group(4);
    String sAddr = match.group(5).trim();
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD, sAddr, data);
    data.strCross = getPadField();
    data.strSupp = getLeft();
    return true;
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
    "SUGARMILL WOODS",

  }; 
}
