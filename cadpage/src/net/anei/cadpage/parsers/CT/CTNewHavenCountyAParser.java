package net.anei.cadpage.parsers.CT;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmartAddressParser;

/*
New Haven County, CT
Contact: John Planas <fire388@gmail.com>
Sender: guilfordfd@rednmxcad.com
System: Red Alert

MARINE INCIDENT, - SEARCH at BLOCK ISLAND RD BRANFORD, GUILFORD . . 14:27:56
CODE 5,- AUTOMATIC FIRE ALARM at 275 LAKE DRIVE GUILFORD 15:57
CODE 1,- AUTOMATIC FIRE ALARM at 35 STATE STREET, GUILFORD 17:15 cross street 1-begins at broad st;115-Boston Post Road;180-North Street
CODE 2,- DTN MEDICAL EMERGENCY at 669 BOSTON POST ROAD, GUILFORD 10:19
CODE 1,- APPLIANCE,TV,ETC. at 258 CHESTNUT GROVE ROAD 19:50
CODE 2,-DTN MEDICAL EMERGENCY at 49 GUILFORD COURT, GUILFORD 15:47
CODE 5,- AUTOMATIC FIRE ALARM at 159 LEDGE HILL ROAD, GUILFORD 11:40
CODE 1,- AUTOMATIC FIRE ALARM at 53 IRONWOOD ROAD, GUILFORD 11:43
CODE 2,-DTN MEDICAL EMERGENCY at 51 WATER STREET, GUILFORD 10:46
CODE 4, - DTN STRUCTURE FIRE at 9 OLD BARN LN, GUILFORD 08:33
CODE 4, - DTN STRUCTURE FIRE at 125 GOOSE LANE, GUILFORD 09:32

*/

public class CTNewHavenCountyAParser extends SmartAddressParser {
  
  private static final Pattern MASTER1 = Pattern.compile("(.*?), *- *(.*?) at (.*) . . \\d\\d:\\d\\d:\\d\\d");
  private static final Pattern MASTER2 = Pattern.compile("CODE (.), *- *(.*?) at (.*?) \\d\\d:\\d\\d\\b *(.*)");
  
  public CTNewHavenCountyAParser() {
    super(CITY_LIST, "NEW HAVEN COUNTY", "CT");
  }
  
  @Override
  public String getFilter() {
    return "guilfordfd@rednmxcad.com";
  }
  
  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    
    String sAddr;
    Matcher match;
    if ((match = MASTER1.matcher(body)).matches()) {
      data.strCall = append(match.group(1).trim(), " - ", match.group(2).trim());
      sAddr = match.group(3).trim();
    }
    else if ((match = MASTER2.matcher(body)).matches()) {
      data.strPriority = match.group(1);
      data.strCall = match.group(2).trim();
      sAddr = match.group(3).trim();
      data.strSupp = match.group(4).trim();
    }
    else return false;
    
    int pt = sAddr.indexOf(", ");
    if (pt >= 0) {
      data.strSource = sAddr.substring(pt+2).trim();
      sAddr = sAddr.substring(0,pt).trim();
    }
    parseAddress(StartType.START_ADDR, FLAG_ANCHOR_END, sAddr, data);
    if (data.strCity.length() == 0) data.strCity = data.strSource;
    
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ALLENPORT",
    "AMWELL TWP",
    "BEALLSVILLE",
    "BENTLEYVILLE",
    "BLAINE TWP",
    "BUFFALO TWP",
    "BURGETTSTWP",
    "CALIFORNIA",
    "CANONSBURG",
    "CANTON TWP",
    "CARROLL TWP",
    "CECIL TWP",
    "CENTERVILLE",
    "CHARTIERS TWP",
    "CLAYSVILLE",
    "COAL CENTER",
    "COKEBURG",
    "CHARLEROI",
    "CROSS CREEK TWP",
    "DEEMSTON",
    "DONEGAL TWP",
    "DONORA",
    "DUNLEVY",
    "EAST BETHLEHEM TWP",
    "EAST FINLEY TWP",
    "ELCO",
    "ELLSWORTH",
    "EAST WASHINGTON",
    "FALLOWFIELD TWP",
    "FINLEYVILLE",
    "GREEN HILLS",
    "HANOVER TWP",
    "HOPEWELL TWP",
    "HOUSTON",
    "INDEPENDENCE TWP",
    "JEFFERSON TWP",
    "LONG BRANCH",
    "MARIANNA",
    "MCDONALD",
    "MIDWAY",
    "MONONGAHELA CITY",
    "MORRIS TWP",
    "MOUNT PLEASANT TWP",
    "NORTH BETHLEHEM TWP",
    "NORTH CHARLEROI",
    "ANSONIA",
    "BEACON FALLS TWP",
    "BETHANY TWP",
    "BRANFORD TWP",
    "CHESHIRE TWP",
    "DERBY",
    "EAST HAVEN TWP",
    "GUILFORD TWP",
    "HAMDEN TWP",
    "AUGERVILLE",
    "CENTERVILLE TWP",
    "DUNBAR HILL",
    "HAMDEN PLAINS",
    "HIGHWOOD",
    "MIX DISTRICT",
    "MOUNT CARMEL",
    "SPRING GLEN",
    "STATE STREET",
    "WEST WOODS",
    "HAMDEN HILLS",
    "WHITNEYVILLE",
    "MADISON TWP",
    "MERIDEN",
    "MIDDLEBURY TWP",
    "MILFORD",
    "DEVON",
    "WOODMONT",
    "NAUGATUCK",
    "NEW HAVEN",
    "AMITY",
    "CEDAR HILL",
    "CITY POINT",
    "DOWNTWP",
    "EAST ROCK",
    "FAIR HAVEN",
    "FAIR HAVEN HEIGHTS",
    "LONG WHARF",
    "MILL RIVER",
    "QUINNIPIAC MEADOWS",
    "WESTVILLE",
    "WOOSTER SQUARE",
    "NORTH BRANFORD TWP",
    "NORTHFORD",
    "NORTH HAVEN TWP",
    "ORANGE TWP",
    "OXFORD TWP",
    "PROSPECT TWP",
    "SEYMOUR TWP",
    "SOUTHBURY TWP",
    "WALLINGFORD TWP",
    "YALESVILLE",
    "WATERBURY",
    "WEST HAVEN",
    "WOLCOTT TWP",
    "WOODBRIDGE TWP",
    "GUILFORD",
    "BRANFORD"
  };
}
