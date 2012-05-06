package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOJeffersonCityParserTest extends BaseParserTest {
  
  public MOJeffersonCityParserTest() {
    setParser(new MOJeffersonCityParser(), "JEFFERSON CITY", "MO");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Subject:DONOTREPLY\n" +
        "Snyder, Jodi 14:00 Medical Emergency 718 MICHIGAN -Cross Streets- LOUISIANA AVE / MISSOURI BLVD E1   CONSCIOUS  OUTSID",

        "NAME:Snyder, Jodi",
        "TIME:14:00",
        "CALL:Medical Emergency",
        "ADDR:718 MICHIGAN",
        "X:LOUISIANA AVE / MISSOURI BLVD E1",
        "INFO:CONSCIOUS  OUTSID");

    doTest("T2",
        "Subject:DONOTREPLY\nE4  14:28 Line Down  - 1505 SOUTHWEST -Cross Streets- CEDAR RIDGE RD / EDGEWOOD DR   LIMB IS ON A POWER LINE \n",
        "UNIT:E4",
        "TIME:14:28",
        "CALL:Line Down",
        "ADDR:1505 SOUTHWEST",
        "X:CEDAR RIDGE RD / EDGEWOOD DR",
        "INFO:LIMB IS ON A POWER LINE");

    doTest("T3",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 13:40 Medical Emergency 301 HIGH -Cross Streets- BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1   FEMA",

        "NAME:McDowell, Shelley",
        "TIME:13:40",
        "CALL:Medical Emergency",
        "ADDR:301 HIGH",
        "X:BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1",
        "INFO:FEMA");

    doTest("T4",
        "Subject:DONOTREPLY\n" +
        "Batt12 E1 L1 E3 S5  13:31 Fire Alarm - 1303 EDMONDS -Cross Streets- MONTANA ST / MYRTLE AVE   OPER 38  UNKNOWN ROOM  3 ",

        "UNIT:Batt12 E1 L1 E3 S5",
        "TIME:13:31",
        "CALL:Fire Alarm",
        "ADDR:1303 EDMONDS",
        "X:MONTANA ST / MYRTLE AVE",
        "INFO:OPER 38  UNKNOWN ROOM  3");

    doTest("T5",
        "Subject:DONOTREPLY\n" +
        "L1  12:02 Accident with Injuries - 1300 5463 BLK -Cross Streets- RAMP 25, HWY 54 E / RAMP 26   CCEMS EN ROUTE  NEED EX ",

        "UNIT:L1",
        "TIME:12:02",
        "CALL:Accident with Injuries",
        "ADDR:1300 5463 BLK",
        "MADDR:1300 5463",
        "X:RAMP 25, HWY 54 E / RAMP 26",
        "INFO:CCEMS EN ROUTE  NEED EX");

    doTest("T6",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 10:07 Medical Emergency 1705 CHRISTY -Cross Streets- CHRISTY CT / ELLIS BLVD E4   SUITE 208 \n",

        "NAME:McDowell, Shelley",
        "TIME:10:07",
        "CALL:Medical Emergency",
        "ADDR:1705 CHRISTY",
        "X:CHRISTY CT / ELLIS BLVD E4",
        "INFO:SUITE 208");

    doTest("T7",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 09:40 Medical Emergency 1434 NOTTING HILL -Cross Streets- DEAD END / PORTABELLO PLACE DR S5   EMS EN ",

        "NAME:McDowell, Shelley",
        "TIME:09:40",
        "CALL:Medical Emergency",
        "ADDR:1434 NOTTING HILL",
        "X:DEAD END / PORTABELLO PLACE DR S5",
        "INFO:EMS EN");

    doTest("T8",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 08:30 Medical Emergency 424 STADIUM -Cross Streets- ADAMS ST / YMCA DR, JACKSON ST E4   ELDERLY MALE ",

        "NAME:McDowell, Shelley",
        "TIME:08:30",
        "CALL:Medical Emergency",
        "ADDR:424 STADIUM",
        "X:ADAMS ST / YMCA DR, JACKSON ST E4",
        "INFO:ELDERLY MALE");

    doTest("T9",
        "Subject:DONOTREPLY\nStiefermann, Angela 02:32 Medical Alarm 10 JACKSON 704 -Address Between- DEAD END / E STATE ST E1   \n",
        "NAME:Stiefermann, Angela",
        "TIME:02:32",
        "CALL:Medical Alarm",
        "ADDR:10 JACKSON 704",
        "X:DEAD END / E STATE ST E1");

    doTest("T10",
        "Subject:DONOTREPLY\n" +
        "E1  16:32 Assist Citizen Fire - MYRTLE EDMONDS -Cross Streets-   MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O",

        "UNIT:E1",
        "TIME:16:32",
        "CALL:Assist Citizen Fire",
        "ADDR:MYRTLE EDMONDS",
        "INFO:MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O");

    doTest("T11",
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Aston, Nora 22:35 Medical Alarm 10 JACKSON 207 -Address Between- DEAD END / E STATE ST E1 EMS NOTIFIED \n",

        "NAME:Aston, Nora",
        "TIME:22:35",
        "CALL:Medical Alarm",
        "ADDR:10 JACKSON 207",
        "X:DEAD END / E STATE ST E1 EMS NOTIFIED");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "1410000046:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Batt12 E1 L1 S2 E4  13:40 Structure Fire - 600 ADAMS -Cross Streets-\n" +
        "DEAD END / E CEDAR WAY\n" +
        "(Con't) 2 of 2\n" +
        "  LAST HOUSE DEAD END OF ADAMS  DECK ON FIRE  SMOKE IN THE AREA\n" +
        "(End)\n",

        "UNIT:Batt12 E1 L1 S2 E4",
        "TIME:13:40",
        "CALL:Structure Fire",
        "ADDR:600 ADAMS",
        "X:DEAD END / E CEDAR WAY",
        "INFO:LAST HOUSE DEAD END OF ADAMS  DECK ON FIRE  SMOKE IN THE AREA");

    doTest("T2",
        "1410000050:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Gabathuler, Erin 20:34 Medical Emergency 207 FRANKLIN A -Cross Streets-\n" +
        "MADISON ST / MONROE\n" +
        "(Con't) 2 of 2\n" +
        "ST L1   HISTORY OF DIABETES  48 YO FEMALE HAS FELL AND IS\n" +
        "(End)",

        "NAME:Gabathuler, Erin",
        "TIME:20:34",
        "CALL:Medical Emergency",
        "ADDR:207 FRANKLIN A",
        "X:MADISON ST / MONROE ST L1",
        "INFO:HISTORY OF DIABETES  48 YO FEMALE HAS FELL AND IS");

    doTest("T3",
        "1410000052:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Suchanek, Celeste 23:52 Medical Emergency 531 ELM A -Cross Streets-\n" +
        "JACKSON ST / MARSHALL\n" +
        "(Con't) 2 of 2\n" +
        "ST L1   F 5 MONTHS PREGNANT   BLEEDING\n" +
        "(End)",

        "NAME:Suchanek, Celeste",
        "TIME:23:52",
        "CALL:Medical Emergency",
        "ADDR:531 ELM A",
        "X:JACKSON ST / MARSHALL ST L1",
        "INFO:F 5 MONTHS PREGNANT   BLEEDING");

    doTest("T4",
        "1410000045:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Batt12 E1 L1 S5 E4  11:42 Fire Alarm - 1432 SOUTHWEST -Cross Streets-\n" +
        "EDGEWOOD DR / CEDAR\n" +
        "(Con't) 2 of 2\n" +
        "RIDGE RD   GENERAL FIRE\n" +
        "(End)",

        "UNIT:Batt12 E1 L1 S5 E4",
        "TIME:11:42",
        "CALL:Fire Alarm",
        "ADDR:1432 SOUTHWEST",
        "X:EDGEWOOD DR / CEDAR RIDGE RD",
        "INFO:GENERAL FIRE");

    doTest("T5",
        "1410000036:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Snyder, Jodi 11:18 Medical Emergency 308 BENTON -Cross Streets- DEAD END\n" +
        "/ COLLIER LN,\n" +
        "(Con't) 2 of 2\n" +
        "NORTHWAY DR L1   SUBJECT CAN'T WALK\n" +
        "(End)",

        "NAME:Snyder, Jodi",
        "TIME:11:18",
        "CALL:Medical Emergency",
        "ADDR:308 BENTON",
        "X:DEAD END / COLLIER LN, NORTHWAY DR L1",
        "INFO:SUBJECT CAN'T WALK");

    doTest("T6",
        "1410000039:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:Morgan, Kacey 22:05 Medical Emergency 1020 ELIZABETH A -Cross Streets-\n" +
        "EDMONDS ST / MYRTLE\n" +
        "(Con't) 2 of 2\n" +
        "AVE L1   SUBJECT IS ON A BREATHING MACHINE  ASTHMA ATTACK\n" +
        "(End)",

        "NAME:Morgan, Kacey",
        "TIME:22:05",
        "CALL:Medical Emergency",
        "ADDR:1020 ELIZABETH A",
        "X:EDMONDS ST / MYRTLE AVE L1",
        "INFO:SUBJECT IS ON A BREATHING MACHINE  ASTHMA ATTACK");

    doTest("T7",
        "1410000043:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:1101 1401 1110 112 CCPager  17:53 Fire Alarm - 2709 LILAC -Cross\n" +
        "Streets- DEAD END / S\n" +
        "(Con't) 2 of 2\n" +
        "COUNTRY CLUB DR   RESIDENTAL- PIERSONS - FIRE MAIN FLOOR\n" +
        "(End)",

        "UNIT:1101 1401 1110 112 CCPager",
        "TIME:17:53",
        "CALL:Fire Alarm",
        "ADDR:2709 LILAC",
        "X:DEAD END / S COUNTRY CLUB DR",
        "INFO:RESIDENTAL- PIERSONS - FIRE MAIN FLOOR");

    doTest("T8",
        "1410000038:  1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:1201 1401 1531 114 CCPager  17:45 Accident with Injuries - 8000 D BLK\n" +
        "-Cross Streets-\n" +
        "(Con't) 2 of 2\n" +
        "SCRIVNER RD / BATES RD   RP JUST HEARD THE ACCIDENT  UNKNOWN INJURY\n" +
        "(End)",

        "UNIT:1201 1401 1531 114 CCPager",
        "TIME:17:45",
        "CALL:Accident with Injuries",
        "ADDR:8000 D BLK",
        "MADDR:8000 D",
        "X:SCRIVNER RD / BATES RD",
        "INFO:RP JUST HEARD THE ACCIDENT  UNKNOWN INJURY");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(DONOTREPLY) E3  13:39 Line Down  - 1304 MCCARTY -Cross Streets- HAVANA ST, HART ST / HAVANA ST   TREE DOWN ACROSS W MCCARTY STREET - TOOK DOWN POWER LINES AS WELL  Call #: 617 - RP THINKS WIRES ARE DOWN ON MCCARTY  Call #: 617 - RP HEARD A LOUD POPPING SOUND ",
        "UNIT:E3",
        "TIME:13:39",
        "CALL:Line Down",
        "ADDR:1304 MCCARTY",
        "X:HAVANA ST, HART ST / HAVANA ST",
        "INFO:TREE DOWN ACROSS W MCCARTY STREET - TOOK DOWN POWER LINES AS WELL  Call #: 617 - RP THINKS WIRES ARE DOWN ON MCCARTY  Call #: 617 - RP HEARD A LOUD POPPING SOUND");

    doTest("T2",
        "(DONOTREPLY) E1  13:46 Assist Police - 2201 MAIN -Cross Streets- MEMORIAL PARK DR / FOREST HILL AVE   93 REQUESTING WASH DOWN AFTER THE SAFETY PATROL PICNIC. (JUST SEND E1) ",
        "UNIT:E1",
        "TIME:13:46",
        "CALL:Assist Police",
        "ADDR:2201 MAIN",
        "X:MEMORIAL PARK DR / FOREST HILL AVE",
        "INFO:93 REQUESTING WASH DOWN AFTER THE SAFETY PATROL PICNIC. (JUST SEND E1)");

    doTest("T3",
        "(DONOTREPLY) Degraffenreid, Jenny 14:24 Medical Emergency 120 DUNKLIN -Cross Streets- W DUNKLIN ST, JEFFERSON ST / MADISON ST S5  ",
        "NAME:Degraffenreid, Jenny",
        "TIME:14:24",
        "CALL:Medical Emergency",
        "ADDR:120 DUNKLIN",
        "X:W DUNKLIN ST, JEFFERSON ST / MADISON ST S5");

    doTest("T4",
        "(DONOTREPLY) AC2 E4 S5 E3 L1  14:48 Fire Alarm - 1201 FAIRGROUNDS -Cross Streets- VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR   OFFICE AREA ",
        "UNIT:AC2 E4 S5 E3 L1",
        "TIME:14:48",
        "CALL:Fire Alarm",
        "ADDR:1201 FAIRGROUNDS",
        "X:VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR",
        "INFO:OFFICE AREA");

    doTest("T5",
        "(DONOTREPLY) Taylor, Tiffany 15:08 Medical Emergency 711 KANSAS -Cross Streets- WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD E1   SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET",
        "NAME:Taylor, Tiffany",
        "TIME:15:08",
        "CALL:Medical Emergency",
        "ADDR:711 KANSAS",
        "X:WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD E1",
        "INFO:SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET");

    doTest("T6",
        "(DONOTREPLY) Degraffenreid, Jenny 16:33 Medical Emergency 406 ATCHISON -Cross Streets- No Cross Streets Found E1   SEIZURE - BEING COMBATIVE ",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:33",
        "CALL:Medical Emergency",
        "ADDR:406 ATCHISON",
        "X:No Cross Streets Found E1",
        "INFO:SEIZURE - BEING COMBATIVE");

    doTest("T7",
        "(DONOTREPLY) Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD E3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:42",
        "CALL:Medical Emergency",
        "ADDR:2021 WILLIAM",
        "X:BLAIR DR / DIX RD E3",
        "INFO:STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S");

    doTest("T8",
        "(DONOTREPLY) AC2 L1 E4  16:42 Accident with Injuries - JEFFERSON -Cross Streets-   EMS NOTIFIED  Call #: 691 - METALIC CAR  ELDERLY MALE DRIVER  Call #: 691 - AT CONOCO  UNKNOWN INJURIES  SIL CAR RAN INTO GAURD-RAIL  Call #: 691 - CALLER DOES NOT BELIEVE THIS IS AN ACCIDENT, BUT MAYBE ELDERLY MALE HAVING SOME KIND OF ISSUE  Call #: 691 - VEH IS UP ON GUARD RAIL  Call #: 691 - W/M",
        "UNIT:AC2 L1 E4",
        "TIME:16:42",
        "CALL:Accident with Injuries",
        "ADDR:JEFFERSON",
        "INFO:EMS NOTIFIED  Call #: 691 - METALIC CAR  ELDERLY MALE DRIVER  Call #: 691 - AT CONOCO  UNKNOWN INJURIES  SIL CAR RAN INTO GAURD-RAIL  Call #: 691 - CALLER DOES NOT BELIEVE THIS IS AN ACCIDENT, BUT MAYBE ELDERLY MALE HAVING SOME KIND OF ISSUE  Call #: 691 - VEH IS UP ON GUARD RAIL  Call #: 691 - W/M");

    doTest("T9",
        "(DONOTREPLY) Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD L3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:42",
        "CALL:Medical Emergency",
        "ADDR:2021 WILLIAM",
        "X:BLAIR DR / DIX RD L3",
        "INFO:STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S");

    doTest("T10",
        "(DONOTREPLY) Schlitt, Meagen 18:53 Medical Emergency 3038 TRUMAN -Cross Streets- DUPONT CIR / N TEN MILE DR E3   RM 401  RESIDENT MAY BE HAVING HEART ATTACK ",
        "NAME:Schlitt, Meagen",
        "TIME:18:53",
        "CALL:Medical Emergency",
        "ADDR:3038 TRUMAN",
        "X:DUPONT CIR / N TEN MILE DR E3",
        "INFO:RM 401  RESIDENT MAY BE HAVING HEART ATTACK");

    doTest("T11",
        "(DONOTREPLY) AC2 E1 L1 S2 E4  19:22 Structure Fire - ELM -Cross Streets-   WHITE SMOKE COMING FROM FRONT OF BUILDING ",
        "UNIT:AC2 E1 L1 S2 E4",
        "TIME:19:22",
        "CALL:Structure Fire",
        "ADDR:ELM",
        "INFO:WHITE SMOKE COMING FROM FRONT OF BUILDING");

    doTest("T12",
        "(DONOTREPLY) Degraffenreid, Jenny 09:41 Medical Emergency 2225 WEATHERED ROCK 4 -Cross Streets- LORENZO GREENE DR / MILLBROOK DR E1   SAYS SHE TRIED TO DRIVE BUT COULDN'T. BLEEDING FR",
        "NAME:Degraffenreid, Jenny",
        "TIME:09:41",
        "CALL:Medical Emergency",
        "ADDR:2225 WEATHERED ROCK 4",
        "X:LORENZO GREENE DR / MILLBROOK DR E1",
        "INFO:SAYS SHE TRIED TO DRIVE BUT COULDN'T. BLEEDING FR");

    doTest("T13",
        "(DONOTREPLY) 1101 1401 1110 112 CCPager  16:58 Fire Alarm - 2227 SADDLEBROOKE LAKE -Cross Streets- CHERISH CT / SCRUGGS STATION RD   ALLEN RESIDENCE ",
        "UNIT:1101 1401 1110 112 CCPager",
        "TIME:16:58",
        "CALL:Fire Alarm",
        "ADDR:2227 SADDLEBROOKE LAKE",
        "X:CHERISH CT / SCRUGGS STATION RD",
        "INFO:ALLEN RESIDENCE");

    doTest("T14",
        "(DONOTREPLY) AC2 E1 L1 S2 E3  08:40 Fire Alarm - 1445 CHRISTY -Cross Streets- OSCAR DR / RAMP 31-970733, TANNER BRIDGE RD   GENERAL  FIRE ALARM - ROOM SMOKE  MID MO ANESTHIA ",
        "UNIT:AC2 E1 L1 S2 E3",
        "TIME:08:40",
        "CALL:Fire Alarm",
        "ADDR:1445 CHRISTY",
        "X:OSCAR DR / RAMP 31-970733, TANNER BRIDGE RD",
        "INFO:GENERAL  FIRE ALARM - ROOM SMOKE  MID MO ANESTHIA");

    doTest("T15",
        "(DONOTREPLY) DC4 E1 L1 S2 E4  23:39 Fire Alarm - 2033 CHRISTY -Cross Streets- VETERANS LN / RT B   Call Number 434 was created from Call Number 433(May  3 2012 11:37PM)  PERIMETER AND FIRE ALARM - OFFICE HALL MOTION DETECTOR #2406 ",
        "UNIT:DC4 E1 L1 S2 E4",
        "TIME:23:39",
        "CALL:Fire Alarm",
        "ADDR:2033 CHRISTY",
        "X:VETERANS LN / RT B",
        "INFO:Call Number 434 was created from Call Number 433(May  3 2012 11:37PM)  PERIMETER AND FIRE ALARM - OFFICE HALL MOTION DETECTOR #2406");

    doTest("T16",
        "(DONOTREPLY) S5  22:59 Accident with Injuries - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH ",
        "UNIT:S5",
        "TIME:22:59",
        "CALL:Accident with Injuries",
        "ADDR:1700 INDUSTRIAL",
        "X:ARGONNE ST / HUGHES ST",
        "INFO:EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH");

    doTest("T17",
        "(DONOTREPLY) Batt11  22:59 Extrication - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   UNION PACIFIC ADVISED- THEY CALLED INTO REPORT A PROBLEM - THEY WERE UNSURE OF WHAT THE PROBLEM WAS- THEY HAVE BEEN ADVISED TO STOP ALL TRAIN TRAFFIC  EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH ",
        "UNIT:Batt11",
        "TIME:22:59",
        "CALL:Extrication",
        "ADDR:1700 INDUSTRIAL",
        "X:ARGONNE ST / HUGHES ST",
        "INFO:UNION PACIFIC ADVISED- THEY CALLED INTO REPORT A PROBLEM - THEY WERE UNSURE OF WHAT THE PROBLEM WAS- THEY HAVE BEEN ADVISED TO STOP ALL TRAIN TRAFFIC  EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH");

    doTest("T18",
        "(DONOTREPLY) Gabathuler, Erin 20:08 Medical Alarm 1509 STADIUM -Address Between- MYRTLE AVE / SOUTHWEST BLVD E4   CCEMS ADVISED  KEY - UNDER WHITE ROCK - UNDER/NEX",
        "NAME:Gabathuler, Erin",
        "TIME:20:08",
        "CALL:Medical Alarm",
        "ADDR:1509 STADIUM",
        "X:MYRTLE AVE / SOUTHWEST BLVD E4",
        "INFO:CCEMS ADVISED  KEY - UNDER WHITE ROCK - UNDER/NEX");

    doTest("T19",
        "(DONOTREPLY)  19:01 Test - 1229 BROADWAY -Cross Streets- W RAILROAD RD, MARION ST / RT NN, MAIN ST   REGIONAL WEST FIRE PROTECTION DISTRICT ALARM AND PAGER TEST. ",
        "TIME:19:01",
        "CALL:Test",
        "ADDR:1229 BROADWAY",
        "X:W RAILROAD RD, MARION ST / RT NN, MAIN ST",
        "INFO:REGIONAL WEST FIRE PROTECTION DISTRICT ALARM AND PAGER TEST.");

    doTest("T20",
        "(DONOTREPLY) Gabathuler, Erin 19:46 Medical Emergency 925 DUNKLIN A -Cross Streets- LEE DR, LINN ST / CHESTNUT ST E1   FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES",
        "NAME:Gabathuler, Erin",
        "TIME:19:46",
        "CALL:Medical Emergency",
        "ADDR:925 DUNKLIN A",
        "X:LEE DR, LINN ST / CHESTNUT ST E1",
        "INFO:FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES");

    doTest("T21",
        "(DONOTREPLY) Suchanek, Celeste 17:51 Medical Emergency 8501 NO MORE VICTIMS -Cross Streets- DEAD END / CORTEZ DR S2   nose bleed   front entrance ",
        "NAME:Suchanek, Celeste",
        "TIME:17:51",
        "CALL:Medical Emergency",
        "ADDR:8501 NO MORE VICTIMS",
        "X:DEAD END / CORTEZ DR S2",
        "INFO:nose bleed   front entrance");

    doTest("T22",
        "(DONOTREPLY) E4  18:42 Natural Cover  - 7 HILLS -Cross Streets-   NATURAL COVER FIRE IN THE AREA ",
        "UNIT:E4",
        "TIME:18:42",
        "CALL:Natural Cover",
        "ADDR:7 HILLS",
        "INFO:NATURAL COVER FIRE IN THE AREA");

    doTest("T23",
        "(DONOTREPLY) Suchanek, Celeste 17:02 Medical Emergency 807 MONROE -Cross Streets- E HESS WAY / E ASHLEY ST E1   FALLEN OFF BIKE ",
        "NAME:Suchanek, Celeste",
        "TIME:17:02",
        "CALL:Medical Emergency",
        "ADDR:807 MONROE",
        "X:E HESS WAY / E ASHLEY ST E1",
        "INFO:FALLEN OFF BIKE");
    
  }

  public static void main(String[] args) {
    new MOJeffersonCityParserTest().generateTests("T1", "UNIT NAME TIME CALL ADDR X INFO");
  }
}
