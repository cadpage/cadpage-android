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
        "X:LOUISIANA AVE / MISSOURI BLVD",
        "UNIT:E1",
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
        "X:BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP",
        "UNIT:E1",
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
        "X:CHRISTY CT / ELLIS BLVD",
        "UNIT:E4",
        "INFO:SUITE 208");

    doTest("T7",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 09:40 Medical Emergency 1434 NOTTING HILL -Cross Streets- DEAD END / PORTABELLO PLACE DR S5   EMS EN ",

        "NAME:McDowell, Shelley",
        "TIME:09:40",
        "CALL:Medical Emergency",
        "ADDR:1434 NOTTING HILL",
        "X:DEAD END / PORTABELLO PLACE DR",
        "UNIT:S5",
        "INFO:EMS EN");

    doTest("T8",
        "Subject:DONOTREPLY\n" +
        "McDowell, Shelley 08:30 Medical Emergency 424 STADIUM -Cross Streets- ADAMS ST / YMCA DR, JACKSON ST E4   ELDERLY MALE ",

        "NAME:McDowell, Shelley",
        "TIME:08:30",
        "CALL:Medical Emergency",
        "ADDR:424 STADIUM",
        "X:ADAMS ST / YMCA DR, JACKSON ST",
        "UNIT:E4",
        "INFO:ELDERLY MALE");

    doTest("T9",
        "Subject:DONOTREPLY\nStiefermann, Angela 02:32 Medical Alarm 10 JACKSON 704 -Address Between- DEAD END / E STATE ST E1   \n",
        "NAME:Stiefermann, Angela",
        "TIME:02:32",
        "CALL:Medical Alarm",
        "ADDR:10 JACKSON 704",
        "X:DEAD END / E STATE ST",
        "UNIT:E1");

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
        "X:DEAD END / E STATE ST",
        "UNIT:E1",
        "INFO:EMS NOTIFIED");
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
        "X:MADISON ST / MONROE ST",
        "UNIT:L1",
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
        "X:JACKSON ST / MARSHALL ST",
        "UNIT:L1",
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
        "X:DEAD END / COLLIER LN, NORTHWAY DR",
        "UNIT:L1",
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
        "X:EDMONDS ST / MYRTLE AVE",
        "UNIT:L1",
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
  public void testParser3() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:15:51 Mutual Aid  - 20 MAPLE RD,OLEAN -Cross Streets-  127 TO STATION 2  122 RESP STATION 2\n" +
        "(Con't) 2 of 2\n" +
        "EQUIPMENT AND PERSONNEL  STRUCTURE FIRE - ANIMALS AND AMMUNIT Degraffenreid, Jenny\n" +
        "(End)",

        "TIME:15:51",
        "CALL:Mutual Aid",
        "ADDR:20 MAPLE RD",
        "CITY:OLEAN",
        "X:127 TO STATION 2",
        "INFO:122 RESP STATION 2 EQUIPMENT AND PERSONNEL  STRUCTURE FIRE - ANIMALS AND AMMUNIT",
        "NAME:Degraffenreid, Jenny");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:18:50 Natural Cover  1201 1210 1220 1320 1120 114 CCPager  - -Cross Streets- BAINER RD,\n" +
        "(Con't) 2 of 2\n" +
        "LOESCH RD / WALNUT ACRES RD, ZION RD  GRASS ON FIRE AT THE LOW WATER CROSSING -  Taylor, Tiffany\n" +
        "(End)",

        "TIME:18:50",
        "CALL:Natural Cover",
        "ADDR:1201 1210 1220 1320 1120 114 CCPager  -",
        "X:BAINER RD, LOESCH RD / WALNUT ACRES RD, ZION RD",
        "INFO:GRASS ON FIRE AT THE LOW WATER CROSSING",
        "NAME:Taylor, Tiffany");

    doTest("T3",
        " 1 of 3\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:12:23 Fire Investigation 1301 111 CCPager  - 614 UPPER BOTTOM RD -Cross Streets- NATIONAL\n" +
        "(Con't) 2 of 3\n" +
        "ST / PLACID VALLEY LN LN  CLOSE TO THE ROADWAY, SMOKE VISIBLE.  TRASH ON THE GROUND BURNING CLOSE TO HEAVY VEGITATION. NO ONE\n" +
        "(Con't) 3 of 3\n" +
        "Stiefermann, Angela\n" +
        "(End)",

        "TIME:12:23",
        "CALL:Fire Investigation 1301 111 CCPager",
        "ADDR:614 UPPER BOTTOM RD",
        "X:NATIONAL ST / PLACID VALLEY LN LN",
        "INFO:CLOSE TO THE ROADWAY, SMOKE VISIBLE.  TRASH ON THE GROUND BURNING CLOSE TO HEAVY VEGITATION. NO ONE",
        "NAME:Stiefermann, Angela");

    doTest("T4",
        " 1 of 2\n" +
        "FRM:paging@jeffcitymo.org\n" +
        "SUBJ:DONOTREPLY\n" +
        "MSG:00:05 Structure Fire  - 56757 RT C -Cross Streets- FAHRNI RD / ROBERTA DR  RL REQUESTING\n" +
        "(Con't) 2 of 2\n" +
        "COLE COUNTY FOR TANKER ASSISTANCE  MONT COUNTY SENDING EMS TO STANDBY WITH OFFICERS   Irey, Rachel\n" +
        "(End)",

        "TIME:00:05",
        "CALL:Structure Fire",
        "ADDR:56757 RT C",
        "X:FAHRNI RD / ROBERTA DR",
        "INFO:RL REQUESTING COLE COUNTY FOR TANKER ASSISTANCE  MONT COUNTY SENDING EMS TO STANDBY WITH OFFICERS",
        "NAME:Irey, Rachel");

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
        "X:W DUNKLIN ST, JEFFERSON ST / MADISON ST",
        "UNIT:S5");

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
        "X:WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD",
        "UNIT:E1",
        "INFO:SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET");

    doTest("T6",
        "(DONOTREPLY) Degraffenreid, Jenny 16:33 Medical Emergency 406 ATCHISON -Cross Streets- No Cross Streets Found E1   SEIZURE - BEING COMBATIVE ",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:33",
        "CALL:Medical Emergency",
        "ADDR:406 ATCHISON",
        "X:No Cross Streets Found",
        "UNIT:E1",
        "INFO:SEIZURE - BEING COMBATIVE");

    doTest("T7",
        "(DONOTREPLY) Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD E3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:42",
        "CALL:Medical Emergency",
        "ADDR:2021 WILLIAM",
        "X:BLAIR DR / DIX RD",
        "UNIT:E3",
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
        "X:BLAIR DR / DIX RD",
        "UNIT:L3",
        "INFO:STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S");

    doTest("T10",
        "(DONOTREPLY) Schlitt, Meagen 18:53 Medical Emergency 3038 TRUMAN -Cross Streets- DUPONT CIR / N TEN MILE DR E3   RM 401  RESIDENT MAY BE HAVING HEART ATTACK ",
        "NAME:Schlitt, Meagen",
        "TIME:18:53",
        "CALL:Medical Emergency",
        "ADDR:3038 TRUMAN",
        "X:DUPONT CIR / N TEN MILE DR",
        "UNIT:E3",
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
        "X:LORENZO GREENE DR / MILLBROOK DR",
        "UNIT:E1",
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
        "X:MYRTLE AVE / SOUTHWEST BLVD",
        "UNIT:E4",
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
        "X:LEE DR, LINN ST / CHESTNUT ST",
        "UNIT:E1",
        "INFO:FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES");

    doTest("T21",
        "(DONOTREPLY) Suchanek, Celeste 17:51 Medical Emergency 8501 NO MORE VICTIMS -Cross Streets- DEAD END / CORTEZ DR S2   nose bleed   front entrance ",
        "NAME:Suchanek, Celeste",
        "TIME:17:51",
        "CALL:Medical Emergency",
        "ADDR:8501 NO MORE VICTIMS",
        "X:DEAD END / CORTEZ DR",
        "UNIT:S2",
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
        "X:E HESS WAY / E ASHLEY ST",
        "UNIT:E1",
        "INFO:FALLEN OFF BIKE");

    doTest("T24",
        "[DONOTREPLY] 1101 1401 1110 112 CCPager  16:58 Fire Alarm - 2227 SADDLEBROOKE LAKE -Cross Streets- CHERISH CT / SCRUGGS STATION RD   ALLEN RESIDENCE \n",
        "UNIT:1101 1401 1110 112 CCPager",
        "TIME:16:58",
        "CALL:Fire Alarm",
        "ADDR:2227 SADDLEBROOKE LAKE",
        "X:CHERISH CT / SCRUGGS STATION RD",
        "INFO:ALLEN RESIDENCE");

    doTest("T25",
        "[DONOTREPLY] Suchanek, Celeste 17:02 Medical Emergency 807 MONROE -Cross Streets- E HESS WAY / E ASHLEY ST E1   FALLEN OFF BIKE \n",
        "NAME:Suchanek, Celeste",
        "TIME:17:02",
        "CALL:Medical Emergency",
        "ADDR:807 MONROE",
        "X:E HESS WAY / E ASHLEY ST",
        "UNIT:E1",
        "INFO:FALLEN OFF BIKE");

    doTest("T26",
        "[DONOTREPLY] Suchanek, Celeste 17:51 Medical Emergency 8501 NO MORE VICTIMS -Cross Streets- DEAD END / CORTEZ DR S2   nose bleed   front entrance \n",
        "NAME:Suchanek, Celeste",
        "TIME:17:51",
        "CALL:Medical Emergency",
        "ADDR:8501 NO MORE VICTIMS",
        "X:DEAD END / CORTEZ DR",
        "UNIT:S2",
        "INFO:nose bleed   front entrance");

    doTest("T27",
        "[DONOTREPLY] E4  18:42 Natural Cover  - 7 HILLS -Cross Streets-   NATURAL COVER FIRE IN THE AREA \n",
        "UNIT:E4",
        "TIME:18:42",
        "CALL:Natural Cover",
        "ADDR:7 HILLS",
        "INFO:NATURAL COVER FIRE IN THE AREA");

    doTest("T28",
        "[DONOTREPLY]  19:01 Test - 1229 BROADWAY -Cross Streets- W RAILROAD RD, MARION ST / RT NN, MAIN ST   REGIONAL WEST FIRE PROTECTION DISTRICT ALARM AND PAGER TEST. \n",
        "TIME:19:01",
        "CALL:Test",
        "ADDR:1229 BROADWAY",
        "X:W RAILROAD RD, MARION ST / RT NN, MAIN ST",
        "INFO:REGIONAL WEST FIRE PROTECTION DISTRICT ALARM AND PAGER TEST.");

    doTest("T29",
        "[DONOTREPLY] Gabathuler, Erin 19:46 Medical Emergency 925 DUNKLIN A -Cross Streets- LEE DR, LINN ST / CHESTNUT ST E1   FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES\n",
        "NAME:Gabathuler, Erin",
        "TIME:19:46",
        "CALL:Medical Emergency",
        "ADDR:925 DUNKLIN A",
        "X:LEE DR, LINN ST / CHESTNUT ST",
        "UNIT:E1",
        "INFO:FEMALE WAS SPEAKING WITH THE RP AND THEN HER EYES");

    doTest("T30",
        "[DONOTREPLY] Gabathuler, Erin 20:08 Medical Alarm 1509 STADIUM -Address Between- MYRTLE AVE / SOUTHWEST BLVD E4   CCEMS ADVISED  KEY - UNDER WHITE ROCK - UNDER/NEX\n",
        "NAME:Gabathuler, Erin",
        "TIME:20:08",
        "CALL:Medical Alarm",
        "ADDR:1509 STADIUM",
        "X:MYRTLE AVE / SOUTHWEST BLVD",
        "UNIT:E4",
        "INFO:CCEMS ADVISED  KEY - UNDER WHITE ROCK - UNDER/NEX");

    doTest("T31",
        "[DONOTREPLY] S5  22:59 Accident with Injuries - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH \n",
        "UNIT:S5",
        "TIME:22:59",
        "CALL:Accident with Injuries",
        "ADDR:1700 INDUSTRIAL",
        "X:ARGONNE ST / HUGHES ST",
        "INFO:EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH");

    doTest("T32",
        "[DONOTREPLY] Batt11  22:59 Extrication - 1700 INDUSTRIAL -Cross Streets- ARGONNE ST / HUGHES ST   UNION PACIFIC ADVISED- THEY CALLED INTO REPORT A PROBLEM - THEY WERE UNSURE OF WHAT THE PROBLEM WAS- THEY HAVE BEEN ADVISED TO STOP ALL TRAIN TRAFFIC  EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH \n",
        "UNIT:Batt11",
        "TIME:22:59",
        "CALL:Extrication",
        "ADDR:1700 INDUSTRIAL",
        "X:ARGONNE ST / HUGHES ST",
        "INFO:UNION PACIFIC ADVISED- THEY CALLED INTO REPORT A PROBLEM - THEY WERE UNSURE OF WHAT THE PROBLEM WAS- THEY HAVE BEEN ADVISED TO STOP ALL TRAIN TRAFFIC  EMS ADV  CAR VS TRAIN-  TRAPPED IN VEH");

    doTest("T33",
        "[DONOTREPLY] DC4 E1 L1 S2 E4  23:39 Fire Alarm - 2033 CHRISTY -Cross Streets- VETERANS LN / RT B   Call Number 434 was created from Call Number 433(May  3 2012 11:37PM)  PERIMETER AND FIRE ALARM - OFFICE HALL MOTION DETECTOR #2406 \n",
        "UNIT:DC4 E1 L1 S2 E4",
        "TIME:23:39",
        "CALL:Fire Alarm",
        "ADDR:2033 CHRISTY",
        "X:VETERANS LN / RT B",
        "INFO:Call Number 434 was created from Call Number 433(May  3 2012 11:37PM)  PERIMETER AND FIRE ALARM - OFFICE HALL MOTION DETECTOR #2406");

    doTest("T34",
        "[DONOTREPLY] AC2 E1 L1 S2 E3  08:40 Fire Alarm - 1445 CHRISTY -Cross Streets- OSCAR DR / RAMP 31-970733, TANNER BRIDGE RD   GENERAL  FIRE ALARM - ROOM SMOKE  MID MO ANESTHIA \n",
        "UNIT:AC2 E1 L1 S2 E3",
        "TIME:08:40",
        "CALL:Fire Alarm",
        "ADDR:1445 CHRISTY",
        "X:OSCAR DR / RAMP 31-970733, TANNER BRIDGE RD",
        "INFO:GENERAL  FIRE ALARM - ROOM SMOKE  MID MO ANESTHIA");

    doTest("T35",
        "[DONOTREPLY] Degraffenreid, Jenny 09:41 Medical Emergency 2225 WEATHERED ROCK 4 -Cross Streets- LORENZO GREENE DR / MILLBROOK DR E1   SAYS SHE TRIED TO DRIVE BUT COULDN'T. BLEEDING FR\n",
        "NAME:Degraffenreid, Jenny",
        "TIME:09:41",
        "CALL:Medical Emergency",
        "ADDR:2225 WEATHERED ROCK 4",
        "X:LORENZO GREENE DR / MILLBROOK DR",
        "UNIT:E1",
        "INFO:SAYS SHE TRIED TO DRIVE BUT COULDN'T. BLEEDING FR");

    doTest("T36",
        "[DONOTREPLY] E3  13:39 Line Down  - 1304 MCCARTY -Cross Streets- HAVANA ST, HART ST / HAVANA ST   TREE DOWN ACROSS W MCCARTY STREET - TOOK DOWN POWER LINES AS WELL  Call #: 617 - RP THINKS WIRES ARE DOWN ON MCCARTY  Call #: 617 - RP HEARD A LOUD POPPING SOUND \n",
        "UNIT:E3",
        "TIME:13:39",
        "CALL:Line Down",
        "ADDR:1304 MCCARTY",
        "X:HAVANA ST, HART ST / HAVANA ST",
        "INFO:TREE DOWN ACROSS W MCCARTY STREET - TOOK DOWN POWER LINES AS WELL  Call #: 617 - RP THINKS WIRES ARE DOWN ON MCCARTY  Call #: 617 - RP HEARD A LOUD POPPING SOUND");

    doTest("T37",
        "[DONOTREPLY] E1  13:46 Assist Police - 2201 MAIN -Cross Streets- MEMORIAL PARK DR / FOREST HILL AVE   93 REQUESTING WASH DOWN AFTER THE SAFETY PATROL PICNIC. (JUST SEND E1) \n",
        "UNIT:E1",
        "TIME:13:46",
        "CALL:Assist Police",
        "ADDR:2201 MAIN",
        "X:MEMORIAL PARK DR / FOREST HILL AVE",
        "INFO:93 REQUESTING WASH DOWN AFTER THE SAFETY PATROL PICNIC. (JUST SEND E1)");

    doTest("T38",
        "[DONOTREPLY] Degraffenreid, Jenny 14:24 Medical Emergency 120 DUNKLIN -Cross Streets- W DUNKLIN ST, JEFFERSON ST / MADISON ST S5  \n",
        "NAME:Degraffenreid, Jenny",
        "TIME:14:24",
        "CALL:Medical Emergency",
        "ADDR:120 DUNKLIN",
        "X:W DUNKLIN ST, JEFFERSON ST / MADISON ST",
        "UNIT:S5");

    doTest("T39",
        "[DONOTREPLY] AC2 E4 S5 E3 L1  14:48 Fire Alarm - 1201 FAIRGROUNDS -Cross Streets- VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR   OFFICE AREA \n",
        "UNIT:AC2 E4 S5 E3 L1",
        "TIME:14:48",
        "CALL:Fire Alarm",
        "ADDR:1201 FAIRGROUNDS",
        "X:VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR",
        "INFO:OFFICE AREA");

    doTest("T40",
        "[DONOTREPLY] Taylor, Tiffany 15:08 Medical Emergency 711 KANSAS -Cross Streets- WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD E1   SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET\n",
        "NAME:Taylor, Tiffany",
        "TIME:15:08",
        "CALL:Medical Emergency",
        "ADDR:711 KANSAS",
        "X:WASHINGTON PARK DR / MYRTLE AVE, SOUTH BLVD",
        "UNIT:E1",
        "INFO:SUBJ IS NOW TRYING TO LEAVE -  RP WAS ABLE TO GET");

    doTest("T41",
        "[DONOTREPLY] Degraffenreid, Jenny 16:33 Medical Emergency 406 ATCHISON -Cross Streets- No Cross Streets Found E1   SEIZURE - BEING COMBATIVE \n",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:33",
        "CALL:Medical Emergency",
        "ADDR:406 ATCHISON",
        "X:No Cross Streets Found",
        "UNIT:E1",
        "INFO:SEIZURE - BEING COMBATIVE");

    doTest("T42",
        "[DONOTREPLY] Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD E3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S\n",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:42",
        "CALL:Medical Emergency",
        "ADDR:2021 WILLIAM",
        "X:BLAIR DR / DIX RD",
        "UNIT:E3",
        "INFO:STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S");

    doTest("T43",
        "[DONOTREPLY] AC2 L1 E4  16:42 Accident with Injuries - JEFFERSON -Cross Streets-   EMS NOTIFIED  Call #: 691 - METALIC CAR  ELDERLY MALE DRIVER  Call #: 691 - AT CONOCO  UNKNOWN INJURIES  SIL CAR RAN INTO GAURD-RAIL  Call #: 691 - CALLER DOES NOT BELIEVE THIS IS AN ACCIDENT, BUT MAYBE ELDERLY MALE HAVING SOME KIND OF ISSUE  Call #: 691 - VEH IS UP ON GUARD RAIL  Call #: 691 - W/M\n",
        "UNIT:AC2 L1 E4",
        "TIME:16:42",
        "CALL:Accident with Injuries",
        "ADDR:JEFFERSON",
        "INFO:EMS NOTIFIED  Call #: 691 - METALIC CAR  ELDERLY MALE DRIVER  Call #: 691 - AT CONOCO  UNKNOWN INJURIES  SIL CAR RAN INTO GAURD-RAIL  Call #: 691 - CALLER DOES NOT BELIEVE THIS IS AN ACCIDENT, BUT MAYBE ELDERLY MALE HAVING SOME KIND OF ISSUE  Call #: 691 - VEH IS UP ON GUARD RAIL  Call #: 691 - W/M");

    doTest("T44",
        "[DONOTREPLY] Degraffenreid, Jenny 16:42 Medical Emergency 2021 WILLIAM -Cross Streets- BLAIR DR / DIX RD L3   STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S\n",
        "NAME:Degraffenreid, Jenny",
        "TIME:16:42",
        "CALL:Medical Emergency",
        "ADDR:2021 WILLIAM",
        "X:BLAIR DR / DIX RD",
        "UNIT:L3",
        "INFO:STOMACH PAIN, FACE IS FLUSH, PRESSURE IN HEAD.  S");

    doTest("T45",
        "[DONOTREPLY] Schlitt, Meagen 18:53 Medical Emergency 3038 TRUMAN -Cross Streets- DUPONT CIR / N TEN MILE DR E3   RM 401  RESIDENT MAY BE HAVING HEART ATTACK \n",
        "NAME:Schlitt, Meagen",
        "TIME:18:53",
        "CALL:Medical Emergency",
        "ADDR:3038 TRUMAN",
        "X:DUPONT CIR / N TEN MILE DR",
        "UNIT:E3",
        "INFO:RM 401  RESIDENT MAY BE HAVING HEART ATTACK");

    doTest("T46",
        "[DONOTREPLY] AC2 E1 L1 S2 E4  19:22 Structure Fire - ELM -Cross Streets-   WHITE SMOKE COMING FROM FRONT OF BUILDING \n",
        "UNIT:AC2 E1 L1 S2 E4",
        "TIME:19:22",
        "CALL:Structure Fire",
        "ADDR:ELM",
        "INFO:WHITE SMOKE COMING FROM FRONT OF BUILDING");

    doTest("T47",
        "[DONOTREPLY] 1401 1531 1201 114 CCPager  22:41 Accident with Injuries - 54 -Cross Streets-   OPER 133 CALLING TROOP  CCEMS ADVISED  ONE PATIENT INJURED  ONE VEH ACCIDENT   WHITE  93  CHEVY LUMINA-  HIT THE GUARDRAIL ON THE HWY -  FEMALES HEAD IS BLEEDING \n",
        "UNIT:1401 1531 1201 114 CCPager",
        "TIME:22:41",
        "CALL:Accident with Injuries",
        "ADDR:54",
        "INFO:OPER 133 CALLING TROOP  CCEMS ADVISED  ONE PATIENT INJURED  ONE VEH ACCIDENT   WHITE  93  CHEVY LUMINA-  HIT THE GUARDRAIL ON THE HWY -  FEMALES HEAD IS BLEEDING");

    doTest("T48",
        "[DONOTREPLY] Volmert, F Michelle 01:01 Medical Emergency 401 DUNKLIN -Cross Streets- MULBERRY ST / MISSOURI BLVD, BOLIVAR ST E1   FEMALE IS LISA CREASON-   THEY ARE SITTING AT THE\n",
        "NAME:Volmert, F Michelle",
        "TIME:01:01",
        "CALL:Medical Emergency",
        "ADDR:401 DUNKLIN",
        "X:MULBERRY ST / MISSOURI BLVD, BOLIVAR ST",
        "UNIT:E1",
        "INFO:FEMALE IS LISA CREASON-   THEY ARE SITTING AT THE");

    doTest("T49",
        "[DONOTREPLY] Volmert, F Michelle 05:16 Medical Emergency 706 HOUCHIN A -Cross Streets- E DUNKLIN ST / BALD HILL RD E4   ASTHMA ATTACK \n",
        "NAME:Volmert, F Michelle",
        "TIME:05:16",
        "CALL:Medical Emergency",
        "ADDR:706 HOUCHIN A",
        "X:E DUNKLIN ST / BALD HILL RD",
        "UNIT:E4",
        "INFO:ASTHMA ATTACK");

    doTest("T50",
        "[DONOTREPLY] E1  07:12 Test - 621 HIGH -Cross Streets- BOLIVAR ST / RAMP ON RAMP, RAMP OFF RAMP  \n",
        "UNIT:E1",
        "TIME:07:12",
        "CALL:Test",
        "ADDR:621 HIGH",
        "X:BOLIVAR ST / RAMP ON RAMP, RAMP OFF RAMP");

    doTest("T51",
        "[DONOTREPLY] Bashore, April 10:39 Medical Alarm 12 JACKSON 513 -Address Between- DEAD END / E STATE ST E1   GENERAL MEDICAL ALARM \n",
        "NAME:Bashore, April",
        "TIME:10:39",
        "CALL:Medical Alarm",
        "ADDR:12 JACKSON 513",
        "X:DEAD END / E STATE ST",
        "UNIT:E1",
        "INFO:GENERAL MEDICAL ALARM");

    doTest("T52",
        "[DONOTREPLY] E1  10:55 Trapped In Elevator - 12 JACKSON -Cross Streets- DEAD END / E STATE ST   SUBL STUCK IN ELEVATOR \n",
        "UNIT:E1",
        "TIME:10:55",
        "CALL:Trapped In Elevator",
        "ADDR:12 JACKSON",
        "X:DEAD END / E STATE ST",
        "INFO:SUBL STUCK IN ELEVATOR");

    doTest("T53",
        "[DONOTREPLY] Batt11 E1 L1 E3 S5  12:15 Fire Alarm - 1303 EDMONDS -Cross Streets- MONTANA ST / MYRTLE AVE   SECOND FLOOR ROOM SMOKE \n",
        "UNIT:Batt11 E1 L1 E3 S5",
        "TIME:12:15",
        "CALL:Fire Alarm",
        "ADDR:1303 EDMONDS",
        "X:MONTANA ST / MYRTLE AVE",
        "INFO:SECOND FLOOR ROOM SMOKE");

    doTest("T54",
        "[DONOTREPLY] Bashore, April 15:04 Medical Emergency 221 FILLMORE -Cross Streets- LINDEN DR, BROADWAY ST / WASHINGTON ST E1   SHE IS 101  MALE STATING MARGARET WAS READING AND\n",
        "NAME:Bashore, April",
        "TIME:15:04",
        "CALL:Medical Emergency",
        "ADDR:221 FILLMORE",
        "X:LINDEN DR, BROADWAY ST / WASHINGTON ST",
        "UNIT:E1",
        "INFO:SHE IS 101  MALE STATING MARGARET WAS READING AND");

    doTest("T55",
        "[DONOTREPLY] Snyder, Jodi 18:23 Medical Emergency 242 JAYCEE -Cross Streets- SCHELLRIDGE RD / INDUSTRIAL DR E3   CUSTOMER HAVING SEZUIRE \n",
        "NAME:Snyder, Jodi",
        "TIME:18:23",
        "CALL:Medical Emergency",
        "ADDR:242 JAYCEE",
        "X:SCHELLRIDGE RD / INDUSTRIAL DR",
        "UNIT:E3",
        "INFO:CUSTOMER HAVING SEZUIRE");

    doTest("T56",
        "[DONOTREPLY] Snyder, Jodi 21:02 Medical Alarm 945 WINDSOR -Address Between- WESTWOOD DR / TOWER DR E3   JAMES WAGGONER, CODE FOR GARAGE 4949, CAN ACCESS \n",
        "NAME:Snyder, Jodi",
        "TIME:21:02",
        "CALL:Medical Alarm",
        "ADDR:945 WINDSOR",
        "X:WESTWOOD DR / TOWER DR",
        "UNIT:E3",
        "INFO:JAMES WAGGONER, CODE FOR GARAGE 4949, CAN ACCESS");

    doTest("T57",
        "[DONOTREPLY] 00:47 Trash Dumpster - 1131 MCCARTY 2 -Cross Streets- LOCUST ST / CLARK AVE E1  \n",
        "TIME:00:47",
        "CALL:Trash Dumpster",
        "ADDR:1131 MCCARTY 2",
        "X:LOCUST ST / CLARK AVE",
        "UNIT:E1");

    doTest("T58",
        "[DONOTREPLY] 05:15 Fire Alarm - 1201 FAIRGROUNDS -Cross Streets- VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR Batt11 E4 S5 E3 L3  \n",
        "TIME:05:15",
        "CALL:Fire Alarm",
        "ADDR:1201 FAIRGROUNDS",
        "X:VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR",
        "UNIT:Batt11 E4 S5 E3 L3");

    doTest("T59",
        "[DONOTREPLY] Medical Emergency 314 BROOKS ST JEFFERSON CITY -Cross Streets- W MCCARTY ST / W HIGH ST E1   E1 \n",
        "CALL:Medical Emergency",
        "ADDR:314 BROOKS ST",
        "X:W MCCARTY ST / W HIGH ST",
        "UNIT:E1");

    doTest("T60",
        "[DONOTREPLY] 08:27 Fire Alarm - 1609 ST MARYS -Cross Streets- HOWARD ST / GIPFERT LN Batt13 E4 L3 E3 S5   DOROTHIA SCOTT RES - HALL WAY ZONE \n",
        "TIME:08:27",
        "CALL:Fire Alarm",
        "ADDR:1609 ST MARYS",
        "X:HOWARD ST / GIPFERT LN",
        "UNIT:Batt13 E4 L3 E3 S5",
        "INFO:DOROTHIA SCOTT RES - HALL WAY ZONE");

    doTest("T61",
        "[DONOTREPLY] 08:31 Fire Alarm - 1201 FAIRGROUNDS -Cross Streets- VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR S5 E4 L1   MAIN OFFICE AREA \n",
        "TIME:08:31",
        "CALL:Fire Alarm",
        "ADDR:1201 FAIRGROUNDS",
        "X:VILLAGE DR / S COUNTRY CLUB DR, W EDGEWOOD DR",
        "UNIT:S5 E4 L1",
        "INFO:MAIN OFFICE AREA");

    doTest("T62",
        "[DONOTREPLY] Medical Emergency 706 OHIO ST JEFFERSON CITY -Cross Streets- MISSOURI BLVD / LOUISIANA AVE E1   ELDERLY CHURCH MEMBER HAS FALLEN AND HIT HEAD, LA E1 \n",
        "CALL:Medical Emergency",
        "ADDR:706 OHIO ST",
        "X:MISSOURI BLVD / LOUISIANA AVE",
        "UNIT:E1",
        "INFO:ELDERLY CHURCH MEMBER HAS FALLEN AND HIT HEAD, LA",
        "UNIT:E1");

    doTest("T63",
        "[DONOTREPLY] 12:38 Assist Citizen Fire - 2731 MERCHANTS -Cross Streets- METRO DR / S HWY 179 E3  \n",
        "TIME:12:38",
        "CALL:Assist Citizen Fire",
        "ADDR:2731 MERCHANTS",
        "X:METRO DR / S HWY 179",
        "UNIT:E3");

    doTest("T64",
        "[DONOTREPLY] Medical Emergency 730 W  STADIUM BLVD JEFFERSON CITY -Cross Streets- HYDE PARK RD / MISSOURI BLVD, ST MARYS BLVD E3   E3 \n",
        "CALL:Medical Emergency",
        "ADDR:730 W  STADIUM BLVD",
        "X:HYDE PARK RD / MISSOURI BLVD, ST MARYS BLVD",
        "UNIT:E3");

    doTest("T65",
        "[DONOTREPLY] 15:13 Fire Alarm - 1609 ST MARYS -Cross Streets- HOWARD ST / GIPFERT LN Batt13 E1 L3 E3 S5   SON IS ON SITE AND STATED EVERYTHING IS FINE - RESIDENT DOESN'T REMEMBER THE CODE  RESIDENT IS ELDERLY  HALLWAY FIRE  DORTHY SCOTT RESIDENT \n",
        "TIME:15:13",
        "CALL:Fire Alarm",
        "ADDR:1609 ST MARYS",
        "X:HOWARD ST / GIPFERT LN",
        "UNIT:Batt13 E1 L3 E3 S5",
        "INFO:SON IS ON SITE AND STATED EVERYTHING IS FINE - RESIDENT DOESN'T REMEMBER THE CODE  RESIDENT IS ELDERLY  HALLWAY FIRE  DORTHY SCOTT RESIDENT");

    doTest("T66",
        "[DONOTREPLY] 15:16 Fire Alarm - 3016 DUPONT -Cross Streets- W TRUMAN BLVD / DEAD END Batt13 E1 L3 E4 S5   GENERAL \n",
        "TIME:15:16",
        "CALL:Fire Alarm",
        "ADDR:3016 DUPONT",
        "X:W TRUMAN BLVD / DEAD END",
        "UNIT:Batt13 E1 L3 E4 S5",
        "INFO:GENERAL");

    doTest("T67",
        "[DONOTREPLY] Medical Emergency 2700 CHERRY CREEK CT I205 JEFFERSON CITY -Cross Streets- DEAD END / N HWY 179 E3   CCEMS NOTIFIED  ELDERLY FEMALE HAS FALLEN - DOOR  E3 \n",
        "CALL:Medical Emergency",
        "ADDR:2700 CHERRY CREEK CT I205",
        "MADDR:2700 CHERRY CREEK CT I 205",
        "X:DEAD END / N HWY 179",
        "UNIT:E3",
        "INFO:CCEMS NOTIFIED  ELDERLY FEMALE HAS FALLEN - DOOR");

    doTest("T68",
        "[DONOTREPLY] Medical Emergency 812 E  HIGH ST A JEFFERSON CITY -Cross Streets- CHERRY ST / CHESTNUT ST E1   BAD PHONE CONNECTION  MALE CAN'T WALK  CCEMS NOTI E1 \n",
        "CALL:Medical Emergency",
        "ADDR:812 E  HIGH ST A",
        "X:CHERRY ST / CHESTNUT ST",
        "UNIT:E1",
        "INFO:BAD PHONE CONNECTION  MALE CAN'T WALK  CCEMS NOTI");

    doTest("T69",
        "[DONOTREPLY] Medical Emergency 811 MONROE ST B JEFFERSON CITY -Cross Streets- E HESS WAY / E ATCHISON ST E1   FEMALE IS ON THE PATIO  GIRLFRIEND FELL OUT OF CH E1 \n",
        "CALL:Medical Emergency",
        "ADDR:811 MONROE ST B",
        "X:E HESS WAY / E ATCHISON ST",
        "UNIT:E1",
        "INFO:FEMALE IS ON THE PATIO  GIRLFRIEND FELL OUT OF CH");

    doTest("T70",
        "[DONOTREPLY] 07:23 Line Down  - 800 MYRTLE blk -Cross Streets- PIKE ST / KANSAS ST, SOUTH BLVD E1   POSSIBLE POWER LINE BROKEN AND PARTIALLY LYING IN THE STREET \n",
        "TIME:07:23",
        "CALL:Line Down",
        "ADDR:800 MYRTLE blk",
        "MADDR:800 MYRTLE",
        "X:PIKE ST / KANSAS ST, SOUTH BLVD",
        "UNIT:E1",
        "INFO:POSSIBLE POWER LINE BROKEN AND PARTIALLY LYING IN THE STREET");

    doTest("T71",
        "[DONOTREPLY] 09:17 Fire Alarm - 6336 ALGOA -Cross Streets- CALBACKNA RD / N SHAMROCK RD Batt11 E3 L1 S2 E4  \n",
        "TIME:09:17",
        "CALL:Fire Alarm",
        "ADDR:6336 ALGOA",
        "X:CALBACKNA RD / N SHAMROCK RD",
        "UNIT:Batt11 E3 L1 S2 E4");

    doTest("T72",
        "[DONOTREPLY] 10:00 Fire Alarm - 6336 ALGOA -Cross Streets- CALBACKNA RD / N SHAMROCK RD S2   WATERFLOW FIRE ALARM CAME IN 3 TIMES  AUTOMATIC FIRE ALARM \n",
        "TIME:10:00",
        "CALL:Fire Alarm",
        "ADDR:6336 ALGOA",
        "X:CALBACKNA RD / N SHAMROCK RD",
        "UNIT:S2",
        "INFO:WATERFLOW FIRE ALARM CAME IN 3 TIMES  AUTOMATIC FIRE ALARM");

    doTest("T73",
        "[DONOTREPLY] Medical Emergency 1100 MISSOURI BLVD JEFFERSON CITY -Cross Streets- GEORGIA ST / KANSAS ST E1   CUSTOMER ON SCEN   CHEST PAIN  E1 \n",
        "CALL:Medical Emergency",
        "ADDR:1100 MISSOURI BLVD",
        "X:GEORGIA ST / KANSAS ST",
        "UNIT:E1",
        "INFO:CUSTOMER ON SCEN   CHEST PAIN");

    doTest("T74",
        "[DONOTREPLY] Medical Emergency 1952 SARATOGA BLVD A JEFFERSON CITY -Cross Streets- LEXINGTON DR / LEXINGTON DR E4   91YO FEMALE  LOCATED IN THE KITCHEN  WIFE FELL AN E4 \n",
        "CALL:Medical Emergency",
        "ADDR:1952 SARATOGA BLVD A",
        "X:LEXINGTON DR / LEXINGTON DR",
        "UNIT:E4",
        "INFO:91YO FEMALE  LOCATED IN THE KITCHEN  WIFE FELL AN");

    doTest("T75",
        "[DONOTREPLY] 14:19 Accident with Injuries - MISSOURI -Cross Streets- Batt11 L3   EMS ENROUTE  PULLING IN TO THE COLTONS PARKING LOT  HE STATES THE FEMALE IS REFUSING TO MOVE AWAY FROM THE LIGHT.  AND IS BLOCKING TRAFFIC  INEZ THOMAS IN THE TAN SONATA  2ND PARTY CALLED - COMPLAINING OF NECK PAIN  RP STATES THE OPERATOR OF THE SONATA THREATENED HIM.  HE BUMPED HER BUMPER, NO DAMA\n",
        "TIME:14:19",
        "CALL:Accident with Injuries",
        "ADDR:MISSOURI",
        "UNIT:Batt11 L3",
        "INFO:EMS ENROUTE  PULLING IN TO THE COLTONS PARKING LOT  HE STATES THE FEMALE IS REFUSING TO MOVE AWAY FROM THE LIGHT.  AND IS BLOCKING TRAFFIC  INEZ THOMAS IN THE TAN SONATA  2ND PARTY CALLED - COMPLAINING OF NECK PAIN  RP STATES THE OPERATOR OF THE SONATA THREATENED HIM.  HE BUMPED HER BUMPER, NO DAMA");

    doTest("T76",
        "[DONOTREPLY] Medical Emergency 12 JACKSON ST JEFFERSON CITY -Cross Streets- DEAD END / E STATE ST E1   CCEMS NOTIFIED  JUST INSIDE IN THE LOBBY - MALE F E1 \n",
        "CALL:Medical Emergency",
        "ADDR:12 JACKSON ST",
        "X:DEAD END / E STATE ST",
        "UNIT:E1",
        "INFO:CCEMS NOTIFIED  JUST INSIDE IN THE LOBBY - MALE F");

    doTest("T77",
        "[DONOTREPLY] 17:48 Fire Alarm - 301 HIGH -Cross Streets- BROADWAY ST / RAMP ON RAMP, RAMP OFF RAMP Batt11 E1 L1 S2 E4  \n",
        "TIME:17:48",
        "CALL:Fire Alarm",
        "ADDR:301 HIGH",
        "X:BROADWAY ST / RAMP ON RAMP, RAMP OFF RAMP",
        "UNIT:Batt11 E1 L1 S2 E4");

    doTest("T78",
        "[DONOTREPLY] 18:04 Message Deliver - 5206 MONTICELLO -Cross Streets- WALTHER AVE / MOREAU RIDGE RD, OAKRIDGE RD   TRAINING MEETING TONIGHT 1900HRS AUTHORITY 110 \n",
        "TIME:18:04",
        "CALL:Message Deliver",
        "ADDR:5206 MONTICELLO",
        "X:WALTHER AVE / MOREAU RIDGE RD, OAKRIDGE RD",
        "INFO:TRAINING MEETING TONIGHT 1900HRS AUTHORITY 110");

    doTest("T79",
        "[DONOTREPLY] 18:57 Unusual Fire Request - 1922 MISSOURI -Cross Streets- HILDA ST / DIX RD L3   OPER 149 CALLED STATION 1 - L3 WILL RESPOND  SOMEONE THREW THEIR KEYS ON THE ROOF OF BASKIN ROBBINS - EMPP DOES NOT HAVE ACCESS TO THE ROOF \n",
        "TIME:18:57",
        "CALL:Unusual Fire Request",
        "ADDR:1922 MISSOURI",
        "X:HILDA ST / DIX RD",
        "UNIT:L3",
        "INFO:OPER 149 CALLED STATION 1 - L3 WILL RESPOND  SOMEONE THREW THEIR KEYS ON THE ROOF OF BASKIN ROBBINS - EMPP DOES NOT HAVE ACCESS TO THE ROOF");

    doTest("T80",
        "[DONOTREPLY] 19:01 Test - 4017 COUNTY PARK -Cross Streets- ROCKRIDGE RD / FAIRGROUNDS RD, LEANDRA LN   COLE CO FIRE PROTECTION DISTRICT WEEKLY ALARM AND PAGER TEST. \n",
        "TIME:19:01",
        "CALL:Test",
        "ADDR:4017 COUNTY PARK",
        "X:ROCKRIDGE RD / FAIRGROUNDS RD, LEANDRA LN",
        "INFO:COLE CO FIRE PROTECTION DISTRICT WEEKLY ALARM AND PAGER TEST.");

    doTest("T81",
        "[DONOTREPLY] Medical Emergency 210 EL MERCADO PLZ JEFFERSON CITY -Cross Streets- No Cross Streets Found S5   THIS IS METRO BUSINESS COLLEGE  TEACHER IS ILL, F S5 \n",
        "CALL:Medical Emergency",
        "ADDR:210 EL MERCADO PLZ",
        "X:No Cross Streets Found",
        "UNIT:S5",
        "INFO:THIS IS METRO BUSINESS COLLEGE  TEACHER IS ILL, F");

    doTest("T82",
        "[DONOTREPLY] Medical Emergency 50 JEFFERSON CITY -Cross Streets- E3 S5   ****2 YO HAVING SEIZURE  2 YO WITH FLASHERS ON  H E3 S5 \n",
        "CALL:Medical Emergency",
        "ADDR:50",
        "UNIT:E3 S5",
        "INFO:****2 YO HAVING SEIZURE  2 YO WITH FLASHERS ON  H");

    doTest("T83",
        "[DONOTREPLY] 23:04 Smoke In Structure - 509 TURNBERRY JEFFERSON CITY -Cross Streets- STONE BRIAR RD / PINEHURST CT Batt11 E4 S5 E3 L3  \n",
        "TIME:23:04",
        "CALL:Smoke In Structure",
        "ADDR:509 TURNBERRY",
        "X:STONE BRIAR RD / PINEHURST CT",
        "UNIT:Batt11 E4 S5 E3 L3");

    doTest("T84",
        "[DONOTREPLY] 23:39 Accident with Injuries - 1101 S  COUNTRY CLUB JEFFERSON CITY -Cross Streets- OLD LOHMAN RD / DENESE DR Batt11 S5   CCEMS ADVISED  UNKNOWN INJURIES-RP NOT ABLE TO GO OUTSIDE & CHECK  1 VEH IN RP'S FRONT YARD- \n",
        "TIME:23:39",
        "CALL:Accident with Injuries",
        "ADDR:1101 S  COUNTRY CLUB",
        "X:OLD LOHMAN RD / DENESE DR",
        "UNIT:Batt11 S5",
        "INFO:CCEMS ADVISED  UNKNOWN INJURIES-RP NOT ABLE TO GO OUTSIDE & CHECK  1 VEH IN RP'S FRONT YARD-");

    doTest("T85",
        "[DONOTREPLY] 02:52 Fire Alarm - 509 TURNBERRY JEFFERSON CITY -Cross Streets- STONE BRIAR RD / PINEHURST CT Batt11 E4 S5 E3 L3   OPER TRAVIS REF # 2180  TOM KOLB RESD--GENERAL \n",
        "TIME:02:52",
        "CALL:Fire Alarm",
        "ADDR:509 TURNBERRY",
        "X:STONE BRIAR RD / PINEHURST CT",
        "UNIT:Batt11 E4 S5 E3 L3",
        "INFO:OPER TRAVIS REF # 2180  TOM KOLB RESD--GENERAL");

    doTest("T86",
        "[DONOTREPLY] Medical Emergency 235 JOE LN JEFFERSON CITY -Cross Streets- DEAD END / SCENIC DR S2   NO HISTORY OF BREATHING PROBLEMS  63 YO MALE HAVI S2 \n",
        "CALL:Medical Emergency",
        "ADDR:235 JOE LN",
        "X:DEAD END / SCENIC DR",
        "UNIT:S2",
        "INFO:NO HISTORY OF BREATHING PROBLEMS  63 YO MALE HAVI");
  
  }

  public static void main(String[] args) {
    new MOJeffersonCityParserTest().generateTests("T1", "UNIT NAME TIME CALL ADDR CITY X INFO");
  }
}
