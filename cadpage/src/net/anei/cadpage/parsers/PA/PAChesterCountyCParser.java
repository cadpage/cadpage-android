package net.anei.cadpage.parsers.PA;
import java.util.regex.Pattern;

import net.anei.cadpage.SmsMsgInfo.Data;


/* 
Chester County, PA (version C)
Contact: Christopher Bakey <ceb5070@gmail.com>
Sender: longwoodfire@comcast.net <From%3Alongwoodfire@comcast.net>

CHIMNEY FIRE **1905 LENAPE UNIONVILLE RD*RED LION RD & MUNICIPAL BOUNDA*POCOPS*21:30*WOOD STOVE IN BASEMENT, F
HOUSE FIRE **241 SAGINAW RD*LEWISVILLE RD & HOLLOW ROCK LA*NEWLON*12:52*DETAILS TO FOLLOW
ACCIDENT - SERIOUS **N BROAD ST / E LINDEN ST*KNTSQR*11:31*1 VEH, BLOCKING, CAR SMOK
FUEL SPILL **1001 HICKORY HILL RD*HONEYTREE LA & HILLENDALERD*PNSBRY*18:15*250 GALLON OIL TANK FOR F
OUT BUILDING / SHED FIRE **6 CARNATION LA*14:54*25 ENG ASSIST D59 – SHED
RELOCATE FIRE / EMS UNITS*23 FIREHOUSE WY - STATION 23*GAP NEWPORT PK & DEAD END*AVNDAL*21:18*MIC251 COVERING SOUTH
ALARM - CARBON MONOXIDE **5 COOPERSHALWK LA, CHADDS FORD*09:12*ENG25 ASST D59
ALARM - FIRE **815 E BALTIMORE PK - HILTON GARDENS INN*SCHOOLHOUSE RD & ONIX DR*EMARLB*20:25*GEN FIRE – NOTIYFING
NOTIFY FIRE CHIEF*1695 LENAPE RD - POCOPSON HOME*RED BRIDGE LA & LENAPE UNIONVI*POCOPS*03:12*RP ADV RESIDENT PULLED FI
BARN FIRE **382 W STREET RD - NEW BOLTON CTR MAIN CM*WIDENER LA & BYRD RD*EMARLB*19:32*SMOKE IN BARN - NO FIRE S

*/


public class PAChesterCountyCParser extends PAChesterCountyBaseParser {
  
  public PAChesterCountyCParser() {
    super("CALL ADDRPL! X2? APT? CITY? TIME! INFO+");
  }

  // Delimiter pattern is start that is not followed by a second star
  private static final Pattern STAR_DELIM = Pattern.compile("\\*(?!\\*)");

  @Override
  protected boolean parseMsg(String body, Data data) {
    String fields[] = STAR_DELIM.split(body);
    if (fields.length < 4) return false;
    return parseFields(fields, data);
  }
} 
