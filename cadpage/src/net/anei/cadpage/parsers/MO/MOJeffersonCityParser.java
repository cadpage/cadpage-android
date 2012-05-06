package net.anei.cadpage.parsers.MO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.MsgParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
Jefferson City, MO
Contact: Jake Holee <jakeholee@gmail.com>
Contact: Scott Kempker <jcfd133@gmail.com>
Contact: "jacobholee04@pm.sprint.com" <jacobholee04@pm.sprint.com>
Sender: paging@jeffcitymo.org

Subject:DONOTREPLY\nSnyder, Jodi 14:00 Medical Emergency 718 MICHIGAN -Cross Streets- LOUISIANA AVE / MISSOURI BLVD E1   CONSCIOUS  OUTSID
Subject:DONOTREPLY\nE4  14:28 Line Down  - 1505 SOUTHWEST -Cross Streets- CEDAR RIDGE RD / EDGEWOOD DR   LIMB IS ON A POWER LINE \n
Subject:DONOTREPLY\nMcDowell, Shelley 13:40 Medical Emergency 301 HIGH -Cross Streets- BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1   FEMA
Subject:DONOTREPLY\nBatt12 E1 L1 E3 S5  13:31 Fire Alarm - 1303 EDMONDS -Cross Streets- MONTANA ST / MYRTLE AVE   OPER 38  UNKNOWN ROOM  3 
Subject:DONOTREPLY\nL1  12:02 Accident with Injuries - 1300 5463 BLK -Cross Streets- RAMP 25, HWY 54 E / RAMP 26   CCEMS EN ROUTE  NEED EX 
Subject:DONOTREPLY\nMcDowell, Shelley 10:07 Medical Emergency 1705 CHRISTY -Cross Streets- CHRISTY CT / ELLIS BLVD E4   SUITE 208 \n
Subject:DONOTREPLY\nMcDowell, Shelley 09:40 Medical Emergency 1434 NOTTING HILL -Cross Streets- DEAD END / PORTABELLO PLACE DR S5   EMS EN 
Subject:DONOTREPLY\nMcDowell, Shelley 08:30 Medical Emergency 424 STADIUM -Cross Streets- ADAMS ST / YMCA DR, JACKSON ST E4   ELDERLY MALE 
Subject:DONOTREPLY\nStiefermann, Angela 02:32 Medical Alarm 10 JACKSON 704 -Address Between- DEAD END / E STATE ST E1   \n
Subject:DONOTREPLY\nE1  16:32 Assist Citizen Fire - MYRTLE EDMONDS -Cross Streets-   MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O
FRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Aston, Nora 22:35 Medical Alarm 10 JACKSON 207 -Address Between- DEAD END / E STATE ST E1 EMS NOTIFIED \n

1410000046:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Batt12 E1 L1 S2 E4  13:40 Structure Fire - 600 ADAMS -Cross Streets-\nDEAD END / E CEDAR WAY\n(Con't) 2 of 2\n  LAST HOUSE DEAD END OF ADAMS  DECK ON FIRE  SMOKE IN THE AREA\n(End)\n
1410000050:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Gabathuler, Erin 20:34 Medical Emergency 207 FRANKLIN A -Cross Streets-\nMADISON ST / MONROE\n(Con't) 2 of 2\nST L1   HISTORY OF DIABETES  48 YO FEMALE HAS FELL AND IS\n(End)
1410000052:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Suchanek, Celeste 23:52 Medical Emergency 531 ELM A -Cross Streets-\nJACKSON ST / MARSHALL\n(Con't) 2 of 2\nST L1   F 5 MONTHS PREGNANT   BLEEDING\n(End)
1410000045:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Batt12 E1 L1 S5 E4  11:42 Fire Alarm - 1432 SOUTHWEST -Cross Streets-\nEDGEWOOD DR / CEDAR\n(Con't) 2 of 2\nRIDGE RD   GENERAL FIRE\n(End)
1410000036:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Snyder, Jodi 11:18 Medical Emergency 308 BENTON -Cross Streets- DEAD END\n/ COLLIER LN,\n(Con't) 2 of 2\nNORTHWAY DR L1   SUBJECT CAN'T WALK\n(End)
1410000039:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Morgan, Kacey 22:05 Medical Emergency 1020 ELIZABETH A -Cross Streets-\nEDMONDS ST / MYRTLE\n(Con't) 2 of 2\nAVE L1   SUBJECT IS ON A BREATHING MACHINE  ASTHMA ATTACK\n(End)
1410000043:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:1101 1401 1110 112 CCPager  17:53 Fire Alarm - 2709 LILAC -Cross\nStreets- DEAD END / S\n(Con't) 2 of 2\nCOUNTRY CLUB DR   RESIDENTAL- PIERSONS - FIRE MAIN FLOOR\n(End)
1410000038:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:1201 1401 1531 114 CCPager  17:45 Accident with Injuries - 8000 D BLK\n-Cross Streets-\n(Con't) 2 of 2\nSCRIVNER RD / BATES RD   RP JUST HEARD THE ACCIDENT  UNKNOWN INJURY\n(End)

Jefferson County, MO
Contact: support@active911.com
Sender: paging@jeffcitymo.org
(DONOTREPLY) E3  13:39 Line Down  - 1304 MCCARTY -Cross Streets- HAVANA ST, HART ST / HAVANA ST   TREE DOWN ACROSS W MCCARTY STREET - TOOK DOWN POWER LINES AS WELL  Call #: 617 - RP THINKS WIRES ARE DOWN ON MCCARTY  Call #: 617 - RP HEARD A LOUD POPPING SOUND 
(DONOTREPLY) E1  13:46 Assist Police - 2201 MAIN -Cross Streets- MEMORIAL PARK DR / FOREST HILL AVE   93 REQUESTING WASH DOWN AFTER THE SAFETY PATROL PICNIC. (JUST SEND E1) 
(DONOTREPLY) Degraffenreid, Jenny 14:24 Medical Emergency 120 DUNKLIN -Cross Streets- W DUNKLIN ST, JEFFERSON ST / MADISON ST S5  
(DONOTREPLY) AC2 E4 S5 E3 L1  14:48 Fire Alarm - 1201 FAIRGROUNDS -Cross Streets- VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR   OFFICE AREA 
(DONOTREPLY) Taylor, Tiffany 15:08 Medical Emergency 711 KANSAS -Cross Streets- WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD E1   SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET
(DONOTREPLY) Degraffenreid, Jenny 16:33 Medical Emergency 406 ATCHISON -Cross Streets- No Cross Streets Found E1   SEIZURE - BEING COMBATIVE 
(DONOTREPLY) Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD E3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S
(DONOTREPLY) AC2 L1 E4  16:42 Accident with Injuries - JEFFERSON -Cross Streets-   EMS NOTIFIED  Call #: 691 - METALIC CAR  ELDERLY MALE DRIVER  Call #: 691 - AT CONOCO  UNKNOWN INJURIES  SIL CAR RAN INTO GAURD-RAIL  Call #: 691 - CALLER DOES NOT BELIEVE THIS IS AN ACCIDENT, BUT MAYBE ELDERLY MALE HAVING SOME KIND OF ISSUE  Call #: 691 - VEH IS UP ON GUARD RAIL  Call #: 691 - W/M
(DONOTREPLY) Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD L3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S
(DONOTREPLY) Schlitt, Meagen 18:53 Medical Emergency 3038 TRUMAN -Cross Streets- DUPONT CIR / N TEN MILE DR E3   RM 401  RESIDENT MAY BE HAVING HEART ATTACK 
(DONOTREPLY) AC2 E1 L1 S2 E4  19:22 Structure Fire - ELM -Cross Streets-   WHITE SMOKE COMING FROM FRONT OF BUILDING 
(DONOTREPLY) Degraffenreid, Jenny 09:41 Medical Emergency 2225 WEATHERED ROCK 4 -Cross Streets- LORENZO GREENE DR / MILLBROOK DR E1   SAYS SHE TRIED TO DRIVE BUT COULDN'T. BLEEDING FR
(DONOTREPLY) 1101 1401 1110 112 CCPager  16:58 Fire Alarm - 2227 SADDLEBROOKE LAKE -Cross Streets- CHERISH CT / SCRUGGS STATION RD   ALLEN RESIDENCE 
(DONOTREPLY) AC2 E1 L1 S2 E3  08:40 Fire Alarm - 1445 CHRISTY -Cross Streets- OSCAR DR / RAMP 31-970733, TANNER BRIDGE RD   GENERAL  FIRE ALARM - ROOM SMOKE  MID MO ANESTHIA 
(DONOTREPLY) DC4 E1 L1 S2 E4  23:39 Fire Alarm - 2033 CHRISTY -Cross Streets- VETERANS LN / RT B   Call Number 434 was created from Call Number 433(May  3 2012 11:37PM)  PERIMETER AND FIRE ALARM - OFFICE HALL MOTION DETECTOR #2406 
(DONOTREPLY) S5  22:59 Accident with Injuries - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH 
(DONOTREPLY) Batt11  22:59 Extrication - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   UNION PACIFIC ADVISED- THEY CALLED INTO REPORT A PROBLEM - THEY WERE UNSURE OF WHAT THE PROBLEM WAS- THEY HAVE BEEN ADVISED TO STOP ALL TRAIN TRAFFIC  EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH 
(DONOTREPLY) Gabathuler, Erin 20:08 Medical Alarm 1509 STADIUM -Address Between- MYRTLE AVE / SOUTHWEST BLVD E4   CCEMS ADVISED  KEY - UNDER WHITE ROCK - UNDER/NEX
(DONOTREPLY)  19:01 Test - 1229 BROADWAY -Cross Streets- W RAILROAD RD, MARION ST / RT NN, MAIN ST   REGIONAL WEST FIRE PROTECTION DISTRICT ALARM AND PAGER TEST. 
(DONOTREPLY) Gabathuler, Erin 19:46 Medical Emergency 925 DUNKLIN A -Cross Streets- LEE DR, LINN ST / CHESTNUT ST E1   FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES
(DONOTREPLY) Suchanek, Celeste 17:51 Medical Emergency 8501 NO MORE VICTIMS -Cross Streets- DEAD END / CORTEZ DR S2   nose bleed   front entrance 
(DONOTREPLY) E4  18:42 Natural Cover  - 7 HILLS -Cross Streets-   NATURAL COVER FIRE IN THE AREA 
(DONOTREPLY) Suchanek, Celeste 17:02 Medical Emergency 807 MONROE -Cross Streets- E HESS WAY / E ASHLEY ST E1   FALLEN OFF BIKE 

*/


public class MOJeffersonCityParser extends MsgParser {
  
  private static final Pattern MASTER_PTN = 
    Pattern.compile("(.*)\\b(\\d\\d:\\d\\d) (.*) (?:-Cross Streets-|-Address Between-) (.*)");
  private static final Pattern NUMBER_PTN = Pattern.compile("\\b\\d{2,}\\b");
  
  public MOJeffersonCityParser() {
    super("JEFFERSON CITY", "MO");
  }
  
  @Override
  public String getFilter() {
    return "paging@jeffcitymo.org";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_DIRO;
  }

  @Override
  public boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("DONOTREPLY")) return false;
    body = body.replace('\n', ' ');
    Matcher match = MASTER_PTN.matcher(body);
    if (!match.find()) return false;
    
    String sPrefix = match.group(1).trim();
    if (sPrefix.contains(",")) {
      data.strName = sPrefix;
    } else {
      data.strUnit = sPrefix;
    }
    data.strTime = match.group(2);
    String sPart1 = match.group(3).trim();
    String sPart2 = match.group(4);
    
    int pt = sPart1.indexOf(" - ");
    if (pt >= 0) {
      data.strCall = sPart1.substring(0,pt).trim();
      parseAddress(sPart1.substring(pt+3).trim(), data);
    } else if ((match = NUMBER_PTN.matcher(sPart1)).find()) {
      data.strCall = sPart1.substring(0,match.start()).trim();
      parseAddress(sPart1.substring(match.start()), data);
    } else return false;
    
    Parser p = new Parser(sPart2);
    data.strCross = p.get("  ");
    data.strSupp = p.get();
    return true;
  }
}
