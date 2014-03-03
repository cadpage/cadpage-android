package net.anei.cadpage.parsers.IL;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;


public class ILKaneCountyAParser extends SmartAddressParser {
  
  private static final Pattern MARKER = Pattern.compile("^([A-Z]+) - (.*?) (\\d\\d:\\d\\d) (\\d\\d/\\d\\d/\\d\\d) +");
  private static final Pattern MAP_PTN = Pattern.compile("(?: +[A-Z]+-\\d+)+\\b *");
  private static final Pattern MISSED_BLANK = Pattern.compile("(?<=[a-z])(?=\\d)");
  private static final Pattern TRAIL_MAP_PTN = Pattern.compile(" +([A-Z]+-\\d+)$");
  private static final Pattern INFO_JUNK_PTN = Pattern.compile(" *(?:Dispatch received by unit ([A-Z0-9]+)|Call Number \\d+ was created from Call Number \\d+\\([^\\)]+?\\)) *");
  
  public ILKaneCountyAParser() {
    super(CITY_LIST, "KANE COUNTY", "IL");
    setFieldList("CODE CALL TIME DATE PLACE ADDR APT X CITY MAP UNIT INFO");
    setupMultiWordStreets("ROCK ROAD", "BONNIE DUNDEE");
  }
  
  @Override
  public String getFilter() {
    return "Quad Com,Dispatch@quadcom911.org";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    Matcher match = MARKER.matcher(body);
    if (!match.find()) return false;
    data.strCode = match.group(1);
    data.strCall = match.group(2).trim();
    data.strTime = match.group(3);
    data.strDate = match.group(4);
    body = body.substring(match.end());
    
    // If the address is <UNKNOWN> that is all there is to that
    if (body.startsWith("<UNKNOWN>")) {
      data.strAddress = "<UNKNOWN>";
      body = body.substring(9).trim();
    }
    
    // Otherwise address must be terminated by a map code
    else {
      String addr;
      match = MAP_PTN.matcher(body);
      if (match.find()) {
        data.strMap = match.group().trim();
        addr = body.substring(0,match.start());
        body = body.substring(match.end());
      } 
      
      // Except for mutual aid calls, which can be terminated with a period
      else {
        if (!data.strCall.toUpperCase().contains("MUTUAL AID")) return false;
        int pt = body.indexOf(" . ");
        addr = body.substring(0,pt).trim();
        body = body.substring(pt+3).trim();
      }
      addr = MISSED_BLANK.matcher(addr).replaceFirst(" ");
      addr = addr.replace("ROCK ROAD", "ROCK-ROAD");
      parseAddress(StartType.START_PLACE, FLAG_PAD_FIELD | FLAG_CROSS_FOLLOWS | FLAG_ANCHOR_END, addr, data);
      data.strAddress = data.strAddress.replace("ROCK-ROAD", "ROCK ROAD");
      data.strCross = getPadField().replace("ROCK-ROAD", "ROCK ROAD");
      if (data.strCross.equals("No Cross Streets Found")) data.strCross = "";
    }

    // check for second map code at end of info area
    
    match = TRAIL_MAP_PTN.matcher(body);
    if (match.find()) {
      data.strMap = append(data.strMap, " ", match.group(1));
      body = body.substring(0,match.start());
    }

    int last = 0;
    match = INFO_JUNK_PTN.matcher(body);
    while (match.find()) {
      data.strSupp = append(data.strSupp, " / ", body.substring(last,match.start()));
      last = match.end();
      String unit = match.group(1);
      if (unit != null) data.strUnit = append(data.strUnit, " ", unit);
    }
    data.strSupp = append(data.strSupp, " / ", body.substring(last));
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
      "DUNDEE",
      "EAST DUNDEE",
      "ELBURN",
      "ELGIN",
      "GENEVA",
      "GILBERTS",
      "HAMPSHIRE",
      "HOFFMAN ESTATES",
      "HUNTLEY",
      "KANEVILLE",
      "LAKE MARIAN",
      "LILY LAKE",
      "MAPLE PARK",
      "MONTGOMERY",
      "NORTH AURORA",
      "PINGREE GROVE",
      "SOUTH BARRINGTON",
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
