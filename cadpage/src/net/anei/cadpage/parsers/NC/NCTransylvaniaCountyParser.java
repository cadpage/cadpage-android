package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Transylvania County, NC
Contact: 8285771168@vzwpix.com,SUMMERSHINE@vtext.com

911CENTER:45 OAK PARK DR BREVARD CITY 2011-019677 10:43:54 ALARM FIRE (10-37) alarm fire
911CENTER:2725 RESERVE RD LITTLE RIVER 2011-019735 16:20:13 ALARM FIRE (10-37) FOGLE, JOHN 8288775516 FIRE ALARM SMOKE DETECTOR
911CENTER:1 WHITMIRE ST BREVARD CITY 2011-019863 13:34:30 STRUCTURE FIRE OUTBUILDING ON FIRE
911CENTER:1 N BROAD ST BREVARD CITY 2011-019978 10:22:32 HAZARDOUS MATERIAL INCIDENT GREEN RANGE ROVER LEAKING GAS AT PUMP #7
911CENTER:400 ASHEVILLE HWY BREVARD CITY 2011-020259 13:35:26 BRUSH FIRE MULCH FIRE IN FRONT OF DOMINOS PIZZA
911CENTER:1 ISLAND COVE RD LITTLE RIVER 2011-020447 21:09:42 STRUCTURE FIRE BLACK SMOKE ON ISLAND COVE RD

Contact: "cfr918@yahoo.com" <cfr918@yahoo.com>
Sender: 8285530059
8595 GREENVILLE HWY CONNESTEE 2011-026771 16:02:18 CHEST PAIN 67 YO FEMALE, POSSIBLY HAVING A HEART ATTACK. 1ST HOUSE ON LT PAST CEDAR MTN HOUSE
313 KNOB RD BREVARD 2011-027203 18:23:45 STRUCTURE FIRE ELECTRICAL FIRE. SECOND HOUSE ON THE LEFT.
21 HONDAH BLVD LAKE HONDAH 2011-027194 17:28:49 STRUCTURE FIRE CALLER ADV A LOT OF SMOKE COMING FROM HIS NEIGHBORS HOUSE.
1 CONNESTEE RD CONNESTEE 2011-027031 14:04:11 HEAD INJURY REF 9 YO HAD BICYCLE ACCIDENT IN FRONT OF THE CHURCH, POSSIBLE HEAD AND ARM INJURY
11 SHERWOOD RIDGE RD SHERWOOD FOREST 2011-027139 10:23:11 UNCONSCIOUS/UNRESPONSIVE female unresp dob 04/07/21 winnie seale
100 TSULA CT CONNESTEE FALLS 2011-028288 01:18:52 ALARM FIRE (10-37) ADV THAT HIS FIRE ALARM IS MALFUNCTIONING. E FORK GATE-RT ON CATATOGA PATH AND RT ON TSULA-AT THE EN

*/

public class NCTransylvaniaCountyParser extends DispatchSouthernParser {
  
  public NCTransylvaniaCountyParser() {
    super(CITY_LIST, "TRANSYLVANIA COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID);
  }
  
  private static final String[] CITY_LIST = new String[]{
    "BALSAM GROVE",
    "BREVARD CITY",
    "LITTLE RIVER",
    "PISGAH FOREST",
    "ROSMAN"
  };

}
