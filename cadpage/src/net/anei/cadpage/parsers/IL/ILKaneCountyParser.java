package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ILKaneCountyParser extends SmartAddressParser {
  
  private static final Pattern MASTER = Pattern.compile("([A-Z]+) - (.*?) (\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d\\d) (.*?) ((?:[A-Z]+-\\d+ )+)(.*)");
  
  public ILKaneCountyParser() {
    super(CITY_LIST, "KANE COUNTY", "IL");
    setFieldList("CODE CALL TIME DATE ADDR X CITY UNIT INFO");
    setupMultiWordStreets("ROCK ROAD");
  }
  
  @Override
  public String getFilter() {
    return "Quad Com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MASTER.matcher(body);
    if (!match.matches()) return false;
    data.strCode = match.group(1);
    data.strCall = match.group(2).trim();
    data.strTime = match.group(3);
    data.strDate = match.group(4);
    parseAddress(StartType.START_ADDR, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | FLAG_ANCHOR_END, match.group(5).trim(), data);
    data.strCross = getPadField();
    data.strUnit = match.group(6).trim();
    data.strSupp = match.group(7).trim();
    return true;
  }

  private static final String[] CITY_LIST = new String[]{

        // Townships
        "AURORA TWP",
        "BATAVIA TWP",
        "BIG ROCK TWP",
        "BLACKBERRY TWP",
        "BURLINGTON TWP",
        "CAMPTON TWP",
        "DUNDEE TWP",
        "ELGIN TWP",
        "GENEVA TWP",
        "HAMPSHIRE TWP",
        "KANEVILLE TWP",
        "PLATO TWP",
        "RUTLAND TWP",
        "ST. CHARLES TWP",
        "SUGAR GROVE TWP",
        "VIRGIL TWP",
        
        // Cities and Towns
        "ALGONQUIN",
        "AURORA",
        "BARRINGTON HILLS",
        "BARTLETT",
        "BATAVIA",
        "BIG ROCK",
        "BURLINGTON",
        "CAMPTON HILLS",
        "CARPENTERSVILLE",
        "EAST DUNDEE",
        "ELBURN",
        "ELGIN",
        "GENEVA",
        "GILBERTS",
        "HAMPSHIRE",
        "HOFFMAN ESTATES",
        "HUNTLEY",
        "KANEVILLE",
        "LILY LAKE",
        "MAPLE PARK",
        "MONTGOMERY",
        "NORTH AURORA",
        "PINGREE GROVE",
        "ST. CHARLES",
        "SLEEPY HOLLOW",
        "SOUTH ELGIN",
        "SUGAR GROVE",
        "VIRGIL",
        "WAYNE",
        "WEST DUNDEE",
        
        // Unicorporated Communities
        "ALLENS CORNERS",
        "LA FOX",
        "MOOSEHEART",
        "PLATO CENTER",
        "STARKS, ILLINOIS",
        "WASCO"

  };
}
