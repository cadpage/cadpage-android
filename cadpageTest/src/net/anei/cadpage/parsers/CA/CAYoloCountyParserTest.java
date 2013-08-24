package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
 
Yolo County, CA
Contact: Active911
Agency name: City of Davis Fire
Location: Davis, CA, United States
Sender: @ci.davis.ca.us 

(Dispatched Call (E32)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * FIRST * 55 * #130816043 * this is a test call only to test station 34's printer.
(Dispatched Call (TR34)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * FIRST * 55 * #130816043 * this is a test call only to test station 34's printer.
(Dispatched Call (E31)) 715 POLE LINE RD, Davis, CA * DAVIS HEALTH CARE * S DIAMETER DR/LEHIGH DR *  * STMA * 57 * #130816036 * MAIN LOBBY - HURT EYE
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * E239 * STMA * 21 * #130816035 * MALE SHAKY
(Dispatched Call (E31IPAD)) 219 G ST, Davis, CA * WOODSTOCKS PIZZA * 2ND ST/3RD ST *  * STMA * 72 * #130816013 * C2 PD REQUEST
(Dispatched Call (E31)) 219 G ST, Davis, CA * WOODSTOCKS PIZZA * 2ND ST/3RD ST *  * STMA * 72 * #130816013 * C2 PD REQUEST
(Dispatched Call (E31)) 1771 RESEARCH PARK DR, Davis, CA * LA QUINTA INN * RICHARDS BL/COWELL BL (KFC) *  * STAS * 72 * #130816002 * POA- GEN FIRE ALARM ZONE ONE 
(Dispatched Call (E31)) 2102 LOYOLA DR, Davis, CA *  * REGIS DR/LOCUST PL *  * STMA * 41 * #130815134 * DIABETIC - 48YOA \nCellular E911 Call: \nLat:38.546916  Lon:
(Dispatched Call (E31)) 920 CRANBROOK CT, Davis, CA * PINECREST APARTMENTS * J ST * 119 * STMA * 40 * #130815131 * REQ MEDICAL PD ONSCENE
(Dispatched Call (E33)) 44330 N EL MACERO DR, Davis, CA *  * EL MACERO DR/MIDDLE GOLF DR *  * STMA * 61 * #130815129 * PD OS REQ MEDICAL\nCellular E911 Call: \nLat:
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 2101 * STMA * 36 * #130815125 * Service Class: PBXb- FE
(Dispatched Call (E31)) 1850 E 8TH ST, Davis, CA * COURTYARD CONVALESCENT * CHESTNUT LN/POLE LINE RD * B3 * STMA * 57 * #130815109 * 62 YR OLD MALE, TACICARTIC AND 
(Dispatched Call (E31)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 1102 * STMA * 36 * #130815107 * ASSISTED LIVING, NORTH 
(Dispatched Call (E31)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * STMA * 55 * #130815104 * test call only to check the printer
(Dispatched Call (E31)) 1850 HANOVER DR, Davis, CA * ANDERSON PLACE GARDEN APTS * W COVELL BL * 2 * STMA * 38 * #130815100 * MALE FEELS LIKE HE IS GOING TO HAVE A S
(Dispatched Call (E33)) I 80 E/EO MACE BL, Davis, CA *  * EO MACE BL *  * STAA * 45 * #130815098 * THREE VEHS ALL IN CTR DIVIDE  1 PT
(Dispatched Call (E33)) 3030 COWELL BL, Davis, CA * NEW HARMONY APARTMENTS * CHILES RD/KOSO ST * 222 * STMA * 59 * #130815088 * ILL FEMALE - RP IS ENR TO LOCATION
(Dispatched Call (E31)) 1666 DA VINCI CT, Davis, CA * DA VINCI COURT APARTMENTS * RESEARCH PARK DR * 111 * STMI * 88 * #130815085 * MOVING VAN HIT A FIRE SPRINKLER 
(Dispatched Call (E32)) 1 DIXON AID, Davis, CA * DIXON AID * DAVIS FD PD *  * STMI *  * #130815069 * E32 TO THE SCENE 7638 MERIDIAN NORTH .. 2ND ALARM STRUCTURE .. 
(Dispatched Call (E31)) 1666 DA VINCI CT, Davis, CA * DA VINCI COURT APARTMENTS * RESEARCH PARK DR *  * STMA * 88 * #130815066 * ON GREENBELT BEHIND DAVINCI APTS ON
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 4336 * STPA * 36 * #130815023 * Service Class: PBXb - W
(Dispatched Call (E31)) 1010 OLIVE DR, Davis, CA * UNIVERSITY SHELL * RICHARDS BL/HICKORY LN *  * STMA * 72 * #130815019 * MALE SUBJ SEIZURE-
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 25 * STMA * 21 * #130815011 * FALL VIC INJURED - MEMORY CARE BATHRO
(Dispatched Call (E34)) 409 A ST, Davis, CA * TOOMEY FIELD BLEACHERS EAST (UCD * 4TH ST/RUSSELL BL *  * STMA * 71 * #130814172 * WEST SIDE A ST, UNK MED AID SUBJ LA
(Dispatched Call (E31)) 2609 BELMONT DR, Davis, CA *  * TULIP LN *  * STMA * 42 * #130814168 * Service Class: RESD - 87 YOF DIFF BREATHING
(Dispatched Call (E34)) 160 N COLONY RD, Davis, CA * CENTER FOR COMPARIATIVE MED (UCD) * RHESUS RD *  * STAS * 64 * #130814162 * SMOKE DETECTOR 2ND FLOOR FAR WEST
(Dispatched Call (E33)) 4414 VISTA WY, Davis, CA *  * ENSENADA DR/EL MACERO DR *  * STMA * 60 * #130814153 * Service Class: RESD - MALE POSS HEART ATTACK, LOC
(Dispatched Call (E31)) 1221 KENNEDY PL, Davis, CA * DAVISVILLE APARTMENTS * J ST * 27 * STMA * 40 * #130814142 * BREATHING BUT UNCON\n[Cellular E911 Call: \nLat:38
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 23A * STMA * 21 * #130814140 * FEMALE HIGH BLOOD PRESSURE, MEMORY C
(Dispatched Call (E32)) W COVELL BL/SYCAMORE LN, Davis, CA *  * SYCAMORE LN * 115A * STMA * 37 * #130814139 * MALE LAYING ON THE SIDEWALK APPEARS PASSED OUT, NO SHI
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN *  * STMA * 21 * #130814128 * LIFE GUIDANCE COMMUNITY .. IN THE BACK 
(Dispatched Call (E33)) E COVELL BL/MONARCH LN, Davis, CA *  * MONARCH LN *  * STSF * 26 * #130814097 * SMALL FIRE W/ SMOKE  IN THE MEDIAN
(Dispatched Call (E31)) 1820 PALM PL, Davis, CA *  * DENISON DR *  * STMI * 25 * #130814086 * PILE BURNING IN THE BACK YARD  .. SMOKE .. NOT A FIRE PIT
(Dispatched Call (E33)) 3023 ALBANY AV, Davis, CA * OWENDALE COMMUNITY * ARNOLD ST/DRUMMOND AV * 119 * STMA * 58 * #130814077 * FEMALE UNK MEDICAL
(Dispatched Call (E32)) 812 DOUGLASS AV, Davis, CA *  * W 8TH ST/ANTIOCH DR *  * STMI * 54 * #130814070 * BRANCH DOWN AND LEANING ON LIVE WIRE
(Dispatched Call (E31)) 1111 J ST, Davis, CA * J ST APARTMENTS * ALICE ST/DREXEL DR * 85 * STMI * 40 * #130814068 * ODOR INVESTIGATION OF CHEMICAL SMELL IN GENERAL 
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN *  * STMA * 21 * #130813125 * MALE W/NOSE BLEED - PATIENT AT SERVICE 
(Dispatched Call (E33)) 3514 ARROYO AV, Davis, CA *  * BENDITA CT/COLINA CT *  * STMA * 43 * #130813119 * POSS OD ON XANAX
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 4210 * STMA * 36 * #130813114 * FEMALE UNK MEDICAL NEED
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 247 * STMA * 21 * #130813108 * FEMALE HAS FALLEN W/PAIN IN BACK
(Dispatched Call (E34)) 222 PHYSICAL SCIENCES MALL, Davis, CA * BAINER HALL (UCD) * CALIFORNIA AV * 3004 * STMA * 86 * #130813097 * 35 YOF, CHEST PAINS, IRREGULAR H
(Dispatched Call (E32)) HWY 113 N/COVELL BL, Davis, CA *  * COVELL BL *  * STSF * 21 * #130813088 * FIRE ALONG FENCE NEAR ONRAMP TO 113
(Dispatched Call (E34)) 625 KLEIBER HALL DR, Davis, CA * FIRE & POLICE BUILDING (UCD) * HUTCHISON DR *  * STMA * 70 * #130813079 * SECOND HAND REPT FOR UNRESPONSIVE
(Dispatched Call (E32)) 644 ALVARADO AV, Davis, CA * AGGIE SQUARE APARTMENTS * FORTUNA CT/ANDERSON RD * 243 * STMA * 22 * #130813052 * 21 YOF PASSED OUT, BREATHING
(Dispatched Call (E31)) 510 4TH ST, Davis, CA *  * D ST/E ST *  * STMA * 71 * #130813045 * F SUBJ DIZZY, VOMITING\nService Class: VOIP
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST *  * STMA * 36 * #130813036 * @ FRONT DESK, UNK MEDICAL E
(Dispatched Call (E33)) 1335 TORREY ST, Davis, CA *  * ALMOND LN *  * STAS * 76 * #130813022 * [HUNTER RESIDENCE] AP: HALWAY SMOKE DET\nPH:530-297-5448\nRESP PEND
(Dispatched Call (E31)) 1321 FIG PL, Davis, CA *  * LOYOLA DR *  * STMA * 41 * #130812116 * HUSB IN BATHROOM CHOKING\nService Class: RESD
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST *  * STMA * 36 * #130812107 * @ FRONT DESK, FEMALE FEELIN
(Dispatched Call (E34)) 1538 JADE ST, Davis, CA *  * SAGE ST/CELADON ST * A343 * STMA * 68 * #130812106 * 25 YOF BACK  INJ
(Dispatched Call (E31)) 1309 LOCUST PL, Davis, CA *  * LOYOLA DR *  * STPA * 41 * #130812099 * LIFT ASSIST REQUESTED FOR SUBJ INSIDE VEH PARKED IN DRIVEWAY\n\nServi
(Dispatched Call (E34)) 171 HUTCHISON DR, Davis, CA * OLSON HALL (UCD) * CUSHING WY/ROADHOUSE MALL * 40 * STAS * 71 * #130812092 * BASEMENT DUCT DETECTOR
(Dispatched Call (E31)) 1617 RESEARCH PARK DR, Davis, CA * KFC * RICHARDS BL/COWELL BL (KFC) *  * STMA * 72 * #130812080 * PD OS W/ SUBJ, REQ C3 MEDICAL
(Dispatched Call (E32)) 2020 SUTTER PL, Davis, CA * IMAGING * RISLING CT * 102 * STMA * 20 * #130812075 * MALE PX NEEDS AMB TO SUTTER GENERAL .. PX HAS DISLOCATED H
(Dispatched Call (E31)) 2033 F ST, Davis, CA * SUNTREE APARTMENTS * AMAPOLA DR/BUENO DR *  * STMA * 23 * #130812070 * NEAR MAIN ENTRANCE , GRY TOYT COROLLA W/ FEMAL
(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 3333 * STMA * 36 * #130812069 * INDEPENDENT LIVING \nFE
(Dispatched Call (E32)) 819 ADAMS TR, Davis, CA *  * ADAMS ST * C * STAS * 52 * #130812055 * CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY\nCellular 
(Dispatched Call (E31)) 1801 HANOVER DR, Davis, CA * BLOOD SOURCE * ANDERSON RD/SCRIPPS DR * 512 * STSF * 38 * #130812060 * EXTINGUISHED FIRE IN PLANTER BOX IS STIL
(Dispatched Call (E32)) 819 ADAMS TR, Davis, CA *  * ADAMS ST * C * STAS * 52 * #130812055 * CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY\nCellular 
(Dispatched Call (E31IPAD)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * F262 * STMA * 21 * #130812053 * FEMALE RES, FALL VICTIM, CONSC & BR
(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * F262 * STMA * 21 * #130812053 * FEMALE RES, FALL VICTIM, CONSC & BR
(Dispatched Call (E31)) 1309 LOCUST PL, Davis, CA *  * LOYOLA DR *  * STMA * 41 * #130812047 * 83 YOM, CONCIOUS AND BREATHING .. REQ TRANSPORT TO HOSPITAL FOR POSS 

 */

public class CAYoloCountyParserTest extends BaseParserTest {
  
  public CAYoloCountyParserTest() {
    setParser(new CAYoloCountyParser(), "YOLO COUNTY", "CA");
  }
  
  @Test
  public void testCityOfDavisParser() {

    doTest("T1",
        "(Dispatched Call (E32)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * FIRST * 55 * #130816043 * this is a test call only to test station 34's printer.",
        "UNIT:E32",
        "ADDR:530 5TH ST",
        "CITY:Davis",
        "PLACE:STATION 31",
        "X:D ST/E ST",
        "CODE:FIRST",
        "MAP:55",
        "ID:130816043",
        "CALL:this is a test call only to test station 34's printer.");

    doTest("T2",
        "(Dispatched Call (TR34)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * FIRST * 55 * #130816043 * this is a test call only to test station 34's printer.",
        "UNIT:TR34",
        "ADDR:530 5TH ST",
        "CITY:Davis",
        "PLACE:STATION 31",
        "X:D ST/E ST",
        "CODE:FIRST",
        "MAP:55",
        "ID:130816043",
        "CALL:this is a test call only to test station 34's printer.");

    doTest("T3",
        "(Dispatched Call (E31)) 715 POLE LINE RD, Davis, CA * DAVIS HEALTH CARE * S DIAMETER DR/LEHIGH DR *  * STMA * 57 * #130816036 * MAIN LOBBY - HURT EYE",
        "UNIT:E31",
        "ADDR:715 POLE LINE RD",
        "CITY:Davis",
        "PLACE:DAVIS HEALTH CARE",
        "X:S DIAMETER DR/LEHIGH DR",
        "CODE:STMA",
        "MAP:57",
        "ID:130816036",
        "CALL:MAIN LOBBY - HURT EYE");

    doTest("T4",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * E239 * STMA * 21 * #130816035 * MALE SHAKY",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:E239",
        "CODE:STMA",
        "MAP:21",
        "ID:130816035",
        "CALL:MALE SHAKY");

    doTest("T5",
        "(Dispatched Call (E31IPAD)) 219 G ST, Davis, CA * WOODSTOCKS PIZZA * 2ND ST/3RD ST *  * STMA * 72 * #130816013 * C2 PD REQUEST",
        "UNIT:E31IPAD",
        "ADDR:219 G ST",
        "CITY:Davis",
        "PLACE:WOODSTOCKS PIZZA",
        "X:2ND ST/3RD ST",
        "CODE:STMA",
        "MAP:72",
        "ID:130816013",
        "CALL:C2 PD REQUEST");

    doTest("T6",
        "(Dispatched Call (E31)) 219 G ST, Davis, CA * WOODSTOCKS PIZZA * 2ND ST/3RD ST *  * STMA * 72 * #130816013 * C2 PD REQUEST",
        "UNIT:E31",
        "ADDR:219 G ST",
        "CITY:Davis",
        "PLACE:WOODSTOCKS PIZZA",
        "X:2ND ST/3RD ST",
        "CODE:STMA",
        "MAP:72",
        "ID:130816013",
        "CALL:C2 PD REQUEST");

    doTest("T7",
        "(Dispatched Call (E31)) 1771 RESEARCH PARK DR, Davis, CA * LA QUINTA INN * RICHARDS BL/COWELL BL (KFC) *  * STAS * 72 * #130816002 * POA- GEN FIRE ALARM ZONE ONE ",
        "UNIT:E31",
        "ADDR:1771 RESEARCH PARK DR",
        "CITY:Davis",
        "PLACE:LA QUINTA INN",
        "X:RICHARDS BL/COWELL BL (KFC)",
        "CODE:STAS",
        "MAP:72",
        "ID:130816002",
        "CALL:POA- GEN FIRE ALARM ZONE ONE");

    doTest("T8",
        "(Dispatched Call (E31)) 2102 LOYOLA DR, Davis, CA *  * REGIS DR/LOCUST PL *  * STMA * 41 * #130815134 * DIABETIC - 48YOA \n" +
        "Cellular E911 Call: \n" +
        "Lat:38.546916  Lon:",

        "UNIT:E31",
        "ADDR:2102 LOYOLA DR",
        "CITY:Davis",
        "X:REGIS DR/LOCUST PL",
        "CODE:STMA",
        "MAP:41",
        "ID:130815134",
        "CALL:DIABETIC - 48YOA");

    doTest("T9",
        "(Dispatched Call (E31)) 920 CRANBROOK CT, Davis, CA * PINECREST APARTMENTS * J ST * 119 * STMA * 40 * #130815131 * REQ MEDICAL PD ONSCENE",
        "UNIT:E31",
        "ADDR:920 CRANBROOK CT",
        "CITY:Davis",
        "PLACE:PINECREST APARTMENTS",
        "X:J ST",
        "APT:119",
        "CODE:STMA",
        "MAP:40",
        "ID:130815131",
        "CALL:REQ MEDICAL PD ONSCENE");

    doTest("T10",
        "(Dispatched Call (E33)) 44330 N EL MACERO DR, Davis, CA *  * EL MACERO DR/MIDDLE GOLF DR *  * STMA * 61 * #130815129 * PD OS REQ MEDICAL\n" +
        "Cellular E911 Call: \n" +
        "Lat:",

        "UNIT:E33",
        "ADDR:44330 N EL MACERO DR",
        "CITY:Davis",
        "X:EL MACERO DR/MIDDLE GOLF DR",
        "CODE:STMA",
        "MAP:61",
        "ID:130815129",
        "CALL:PD OS REQ MEDICAL");

    doTest("T11",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 2101 * STMA * 36 * #130815125 * Service Class: PBXb- FE",
        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "APT:2101",
        "CODE:STMA",
        "MAP:36",
        "ID:130815125",
        "CALL:ALERT");

    doTest("T12",
        "(Dispatched Call (E31)) 1850 E 8TH ST, Davis, CA * COURTYARD CONVALESCENT * CHESTNUT LN/POLE LINE RD * B3 * STMA * 57 * #130815109 * 62 YR OLD MALE, TACICARTIC AND ",
        "UNIT:E31",
        "ADDR:1850 E 8TH ST",
        "CITY:Davis",
        "PLACE:COURTYARD CONVALESCENT",
        "X:CHESTNUT LN/POLE LINE RD",
        "APT:B3",
        "CODE:STMA",
        "MAP:57",
        "ID:130815109",
        "CALL:62 YR OLD MALE",
        "INFO:TACICARTIC AND");

    doTest("T13",
        "(Dispatched Call (E31)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 1102 * STMA * 36 * #130815107 * ASSISTED LIVING, NORTH ",
        "UNIT:E31",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "APT:1102",
        "CODE:STMA",
        "MAP:36",
        "ID:130815107",
        "CALL:ASSISTED LIVING",
        "INFO:NORTH");

    doTest("T14",
        "(Dispatched Call (E31)) 530 5TH ST, Davis, CA * STATION 31 * D ST/E ST *  * STMA * 55 * #130815104 * test call only to check the printer",
        "UNIT:E31",
        "ADDR:530 5TH ST",
        "CITY:Davis",
        "PLACE:STATION 31",
        "X:D ST/E ST",
        "CODE:STMA",
        "MAP:55",
        "ID:130815104",
        "CALL:test call only to check the printer");

    doTest("T15",
        "(Dispatched Call (E31)) 1850 HANOVER DR, Davis, CA * ANDERSON PLACE GARDEN APTS * W COVELL BL * 2 * STMA * 38 * #130815100 * MALE FEELS LIKE HE IS GOING TO HAVE A S",
        "UNIT:E31",
        "ADDR:1850 HANOVER DR",
        "CITY:Davis",
        "PLACE:ANDERSON PLACE GARDEN APTS",
        "X:W COVELL BL",
        "APT:2",
        "CODE:STMA",
        "MAP:38",
        "ID:130815100",
        "CALL:MALE FEELS LIKE HE IS GOING TO HAVE A S");

    doTest("T16",
        "(Dispatched Call (E33)) I 80 E/EO MACE BL, Davis, CA *  * EO MACE BL *  * STAA * 45 * #130815098 * THREE VEHS ALL IN CTR DIVIDE  1 PT",
        "UNIT:E33",
        "ADDR:I 80 E & EO MACE BL",
        "MADDR:I 80 E & MACE BL",
        "CITY:Davis",
        "X:EO MACE BL",
        "CODE:STAA",
        "MAP:45",
        "ID:130815098",
        "CALL:THREE VEHS ALL IN CTR DIVIDE",
        "INFO:1 PT");

    doTest("T17",
        "(Dispatched Call (E33)) 3030 COWELL BL, Davis, CA * NEW HARMONY APARTMENTS * CHILES RD/KOSO ST * 222 * STMA * 59 * #130815088 * ILL FEMALE - RP IS ENR TO LOCATION",
        "UNIT:E33",
        "ADDR:3030 COWELL BL",
        "CITY:Davis",
        "PLACE:NEW HARMONY APARTMENTS",
        "X:CHILES RD/KOSO ST",
        "APT:222",
        "CODE:STMA",
        "MAP:59",
        "ID:130815088",
        "CALL:ILL FEMALE - RP IS ENR TO LOCATION");

    doTest("T18",
        "(Dispatched Call (E31)) 1666 DA VINCI CT, Davis, CA * DA VINCI COURT APARTMENTS * RESEARCH PARK DR * 111 * STMI * 88 * #130815085 * MOVING VAN HIT A FIRE SPRINKLER ",
        "UNIT:E31",
        "ADDR:1666 DA VINCI CT",
        "CITY:Davis",
        "PLACE:DA VINCI COURT APARTMENTS",
        "X:RESEARCH PARK DR",
        "APT:111",
        "CODE:STMI",
        "MAP:88",
        "ID:130815085",
        "CALL:MOVING VAN HIT A FIRE SPRINKLER");

    doTest("T19",
        "(Dispatched Call (E32)) 1 DIXON AID, Davis, CA * DIXON AID * DAVIS FD PD *  * STMI *  * #130815069 * E32 TO THE SCENE 7638 MERIDIAN NORTH .. 2ND ALARM STRUCTURE .. ",
        "UNIT:E32",
        "ADDR:1 DIXON AID",
        "CITY:Davis",
        "PLACE:DIXON AID",
        "X:DAVIS FD PD",
        "CODE:STMI",
        "ID:130815069",
        "CALL:E32 TO THE SCENE 7638 MERIDIAN NORTH .. 2ND ALARM STRUCTURE ..");

    doTest("T20",
        "(Dispatched Call (E31)) 1666 DA VINCI CT, Davis, CA * DA VINCI COURT APARTMENTS * RESEARCH PARK DR *  * STMA * 88 * #130815066 * ON GREENBELT BEHIND DAVINCI APTS ON",
        "UNIT:E31",
        "ADDR:1666 DA VINCI CT",
        "CITY:Davis",
        "PLACE:DA VINCI COURT APARTMENTS",
        "X:RESEARCH PARK DR",
        "CODE:STMA",
        "MAP:88",
        "ID:130815066",
        "CALL:ON GREENBELT BEHIND DAVINCI APTS ON");

    doTest("T21",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 4336 * STPA * 36 * #130815023 * Service Class: PBXb - W",
        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "APT:4336",
        "CODE:STPA",
        "MAP:36",
        "ID:130815023",
        "CALL:ALERT");

    doTest("T22",
        "(Dispatched Call (E31)) 1010 OLIVE DR, Davis, CA * UNIVERSITY SHELL * RICHARDS BL/HICKORY LN *  * STMA * 72 * #130815019 * MALE SUBJ SEIZURE-",
        "UNIT:E31",
        "ADDR:1010 OLIVE DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY SHELL",
        "X:RICHARDS BL/HICKORY LN",
        "CODE:STMA",
        "MAP:72",
        "ID:130815019",
        "CALL:MALE SUBJ SEIZURE-");

    doTest("T23",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 25 * STMA * 21 * #130815011 * FALL VIC INJURED - MEMORY CARE BATHRO",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:25",
        "CODE:STMA",
        "MAP:21",
        "ID:130815011",
        "CALL:FALL VIC INJURED - MEMORY CARE BATHRO");

    doTest("T24",
        "(Dispatched Call (E34)) 409 A ST, Davis, CA * TOOMEY FIELD BLEACHERS EAST (UCD * 4TH ST/RUSSELL BL *  * STMA * 71 * #130814172 * WEST SIDE A ST, UNK MED AID SUBJ LA",
        "UNIT:E34",
        "ADDR:409 A ST",
        "CITY:Davis",
        "PLACE:TOOMEY FIELD BLEACHERS EAST (UCD",
        "X:4TH ST/RUSSELL BL",
        "CODE:STMA",
        "MAP:71",
        "ID:130814172",
        "CALL:WEST SIDE A ST",
        "INFO:UNK MED AID SUBJ LA");

    doTest("T25",
        "(Dispatched Call (E31)) 2609 BELMONT DR, Davis, CA *  * TULIP LN *  * STMA * 42 * #130814168 * Service Class: RESD - 87 YOF DIFF BREATHING",
        "UNIT:E31",
        "ADDR:2609 BELMONT DR",
        "CITY:Davis",
        "X:TULIP LN",
        "CODE:STMA",
        "MAP:42",
        "ID:130814168",
        "CALL:ALERT");

    doTest("T26",
        "(Dispatched Call (E34)) 160 N COLONY RD, Davis, CA * CENTER FOR COMPARIATIVE MED (UCD) * RHESUS RD *  * STAS * 64 * #130814162 * SMOKE DETECTOR 2ND FLOOR FAR WEST",
        "UNIT:E34",
        "ADDR:160 N COLONY RD",
        "CITY:Davis",
        "PLACE:CENTER FOR COMPARIATIVE MED (UCD)",
        "X:RHESUS RD",
        "CODE:STAS",
        "MAP:64",
        "ID:130814162",
        "CALL:SMOKE DETECTOR 2ND FLOOR FAR WEST");

    doTest("T27",
        "(Dispatched Call (E33)) 4414 VISTA WY, Davis, CA *  * ENSENADA DR/EL MACERO DR *  * STMA * 60 * #130814153 * Service Class: RESD - MALE POSS HEART ATTACK, LOC",
        "UNIT:E33",
        "ADDR:4414 VISTA WY",
        "CITY:Davis",
        "X:ENSENADA DR/EL MACERO DR",
        "CODE:STMA",
        "MAP:60",
        "ID:130814153",
        "CALL:LOC");

    doTest("T28",
        "(Dispatched Call (E31)) 1221 KENNEDY PL, Davis, CA * DAVISVILLE APARTMENTS * J ST * 27 * STMA * 40 * #130814142 * BREATHING BUT UNCON\n" +
        "[Cellular E911 Call: \n" +
        "Lat:38",

        "UNIT:E31",
        "ADDR:1221 KENNEDY PL",
        "CITY:Davis",
        "PLACE:DAVISVILLE APARTMENTS",
        "X:J ST",
        "APT:27",
        "CODE:STMA",
        "MAP:40",
        "ID:130814142",
        "CALL:BREATHING BUT UNCON",
        "INFO:[");

    doTest("T29",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 23A * STMA * 21 * #130814140 * FEMALE HIGH BLOOD PRESSURE, MEMORY C",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:23A",
        "CODE:STMA",
        "MAP:21",
        "ID:130814140",
        "CALL:FEMALE HIGH BLOOD PRESSURE",
        "INFO:MEMORY C");

    doTest("T30",
        "(Dispatched Call (E32)) W COVELL BL/SYCAMORE LN, Davis, CA *  * SYCAMORE LN * 115A * STMA * 37 * #130814139 * MALE LAYING ON THE SIDEWALK APPEARS PASSED OUT, NO SHI",
        "UNIT:E32",
        "ADDR:W COVELL BL & SYCAMORE LN",
        "CITY:Davis",
        "X:SYCAMORE LN",
        "APT:115A",
        "CODE:STMA",
        "MAP:37",
        "ID:130814139",
        "CALL:MALE LAYING ON THE SIDEWALK APPEARS PASSED OUT",
        "INFO:NO SHI");

    doTest("T31",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN *  * STMA * 21 * #130814128 * LIFE GUIDANCE COMMUNITY .. IN THE BACK ",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "CODE:STMA",
        "MAP:21",
        "ID:130814128",
        "CALL:LIFE GUIDANCE COMMUNITY .. IN THE BACK");

    doTest("T32",
        "(Dispatched Call (E33)) E COVELL BL/MONARCH LN, Davis, CA *  * MONARCH LN *  * STSF * 26 * #130814097 * SMALL FIRE W/ SMOKE  IN THE MEDIAN",
        "UNIT:E33",
        "ADDR:E COVELL BL & MONARCH LN",
        "CITY:Davis",
        "X:MONARCH LN",
        "CODE:STSF",
        "MAP:26",
        "ID:130814097",
        "CALL:SMALL FIRE W/ SMOKE",
        "INFO:IN THE MEDIAN");

    doTest("T33",
        "(Dispatched Call (E31)) 1820 PALM PL, Davis, CA *  * DENISON DR *  * STMI * 25 * #130814086 * PILE BURNING IN THE BACK YARD  .. SMOKE .. NOT A FIRE PIT",
        "UNIT:E31",
        "ADDR:1820 PALM PL",
        "CITY:Davis",
        "X:DENISON DR",
        "CODE:STMI",
        "MAP:25",
        "ID:130814086",
        "CALL:PILE BURNING IN THE BACK YARD",
        "INFO:.. SMOKE .. NOT A FIRE PIT");

    doTest("T34",
        "(Dispatched Call (E33)) 3023 ALBANY AV, Davis, CA * OWENDALE COMMUNITY * ARNOLD ST/DRUMMOND AV * 119 * STMA * 58 * #130814077 * FEMALE UNK MEDICAL",
        "UNIT:E33",
        "ADDR:3023 ALBANY AV",
        "MADDR:3023 ALBANY AVE",
        "CITY:Davis",
        "PLACE:OWENDALE COMMUNITY",
        "X:ARNOLD ST/DRUMMOND AV",
        "APT:119",
        "CODE:STMA",
        "MAP:58",
        "ID:130814077",
        "CALL:FEMALE UNK MEDICAL");

    doTest("T35",
        "(Dispatched Call (E32)) 812 DOUGLASS AV, Davis, CA *  * W 8TH ST/ANTIOCH DR *  * STMI * 54 * #130814070 * BRANCH DOWN AND LEANING ON LIVE WIRE",
        "UNIT:E32",
        "ADDR:812 DOUGLASS AV",
        "MADDR:812 DOUGLASS AVE",
        "CITY:Davis",
        "X:W 8TH ST/ANTIOCH DR",
        "CODE:STMI",
        "MAP:54",
        "ID:130814070",
        "CALL:BRANCH DOWN AND LEANING ON LIVE WIRE");

    doTest("T36",
        "(Dispatched Call (E31)) 1111 J ST, Davis, CA * J ST APARTMENTS * ALICE ST/DREXEL DR * 85 * STMI * 40 * #130814068 * ODOR INVESTIGATION OF CHEMICAL SMELL IN GENERAL ",
        "UNIT:E31",
        "ADDR:1111 J ST",
        "CITY:Davis",
        "PLACE:J ST APARTMENTS",
        "X:ALICE ST/DREXEL DR",
        "APT:85",
        "CODE:STMI",
        "MAP:40",
        "ID:130814068",
        "CALL:ODOR INVESTIGATION OF CHEMICAL SMELL IN GENERAL");

    doTest("T37",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN *  * STMA * 21 * #130813125 * MALE W/NOSE BLEED - PATIENT AT SERVICE ",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "CODE:STMA",
        "MAP:21",
        "ID:130813125",
        "CALL:MALE W/NOSE BLEED - PATIENT AT SERVICE");

    doTest("T38",
        "(Dispatched Call (E33)) 3514 ARROYO AV, Davis, CA *  * BENDITA CT/COLINA CT *  * STMA * 43 * #130813119 * POSS OD ON XANAX",
        "UNIT:E33",
        "ADDR:3514 ARROYO AV",
        "MADDR:3514 ARROYO AVE",
        "CITY:Davis",
        "X:BENDITA CT/COLINA CT",
        "CODE:STMA",
        "MAP:43",
        "ID:130813119",
        "CALL:POSS OD ON XANAX");

    doTest("T39",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 4210 * STMA * 36 * #130813114 * FEMALE UNK MEDICAL NEED",
        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "APT:4210",
        "CODE:STMA",
        "MAP:36",
        "ID:130813114",
        "CALL:FEMALE UNK MEDICAL NEED");

    doTest("T40",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * 247 * STMA * 21 * #130813108 * FEMALE HAS FALLEN W/PAIN IN BACK",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:247",
        "CODE:STMA",
        "MAP:21",
        "ID:130813108",
        "CALL:FEMALE HAS FALLEN W/PAIN IN BACK");

    doTest("T41",
        "(Dispatched Call (E34)) 222 PHYSICAL SCIENCES MALL, Davis, CA * BAINER HALL (UCD) * CALIFORNIA AV * 3004 * STMA * 86 * #130813097 * 35 YOF, CHEST PAINS, IRREGULAR H",
        "UNIT:E34",
        "ADDR:222 PHYSICAL SCIENCES MALL",
        "CITY:Davis",
        "PLACE:BAINER HALL (UCD)",
        "X:CALIFORNIA AV",
        "APT:3004",
        "CODE:STMA",
        "MAP:86",
        "ID:130813097",
        "CALL:35 YOF",
        "INFO:CHEST PAINS / IRREGULAR H");

    doTest("T42",
        "(Dispatched Call (E32)) HWY 113 N/COVELL BL, Davis, CA *  * COVELL BL *  * STSF * 21 * #130813088 * FIRE ALONG FENCE NEAR ONRAMP TO 113",
        "UNIT:E32",
        "ADDR:HWY 113 N & COVELL BL",
        "CITY:Davis",
        "X:COVELL BL",
        "CODE:STSF",
        "MAP:21",
        "ID:130813088",
        "CALL:FIRE ALONG FENCE NEAR ONRAMP TO 113");

    doTest("T43",
        "(Dispatched Call (E34)) 625 KLEIBER HALL DR, Davis, CA * FIRE & POLICE BUILDING (UCD) * HUTCHISON DR *  * STMA * 70 * #130813079 * SECOND HAND REPT FOR UNRESPONSIVE",
        "UNIT:E34",
        "ADDR:625 KLEIBER HALL DR",
        "CITY:Davis",
        "PLACE:FIRE & POLICE BUILDING (UCD)",
        "X:HUTCHISON DR",
        "CODE:STMA",
        "MAP:70",
        "ID:130813079",
        "CALL:SECOND HAND REPT FOR UNRESPONSIVE");

    doTest("T44",
        "(Dispatched Call (E32)) 644 ALVARADO AV, Davis, CA * AGGIE SQUARE APARTMENTS * FORTUNA CT/ANDERSON RD * 243 * STMA * 22 * #130813052 * 21 YOF PASSED OUT, BREATHING",
        "UNIT:E32",
        "ADDR:644 ALVARADO AV",
        "MADDR:644 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:AGGIE SQUARE APARTMENTS",
        "X:FORTUNA CT/ANDERSON RD",
        "APT:243",
        "CODE:STMA",
        "MAP:22",
        "ID:130813052",
        "CALL:21 YOF PASSED OUT",
        "INFO:BREATHING");

    doTest("T45",
        "(Dispatched Call (E31)) 510 4TH ST, Davis, CA *  * D ST/E ST *  * STMA * 71 * #130813045 * F SUBJ DIZZY, VOMITING\n" +
        "Service Class: VOIP",

        "UNIT:E31",
        "ADDR:510 4TH ST",
        "CITY:Davis",
        "X:D ST/E ST",
        "CODE:STMA",
        "MAP:71",
        "ID:130813045",
        "CALL:F SUBJ DIZZY",
        "INFO:VOMITING");

    doTest("T46",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST *  * STMA * 36 * #130813036 * @ FRONT DESK, UNK MEDICAL E",
        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "CODE:STMA",
        "MAP:36",
        "ID:130813036",
        "CALL:@ FRONT DESK",
        "INFO:UNK MEDICAL E");

    doTest("T47",
        "(Dispatched Call (E33)) 1335 TORREY ST, Davis, CA *  * ALMOND LN *  * STAS * 76 * #130813022 * [HUNTER RESIDENCE] AP: HALWAY SMOKE DET\n" +
        "PH:530-297-5448\n" +
        "RESP PEND",

        "UNIT:E33",
        "ADDR:1335 TORREY ST",
        "CITY:Davis",
        "X:ALMOND LN",
        "CODE:STAS",
        "MAP:76",
        "ID:130813022",
        "CALL:[HUNTER RESIDENCE] AP: HALWAY SMOKE DET",
        "INFO:PH:530-297-5448 / RESP PEND");

    doTest("T48",
        "(Dispatched Call (E31)) 1321 FIG PL, Davis, CA *  * LOYOLA DR *  * STMA * 41 * #130812116 * HUSB IN BATHROOM CHOKING\n" +
        "Service Class: RESD",

        "UNIT:E31",
        "ADDR:1321 FIG PL",
        "CITY:Davis",
        "X:LOYOLA DR",
        "CODE:STMA",
        "MAP:41",
        "ID:130812116",
        "CALL:HUSB IN BATHROOM CHOKING");

    doTest("T49",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST *  * STMA * 36 * #130812107 * @ FRONT DESK, FEMALE FEELIN",
        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "CODE:STMA",
        "MAP:36",
        "ID:130812107",
        "CALL:@ FRONT DESK",
        "INFO:FEMALE FEELIN");

    doTest("T50",
        "(Dispatched Call (E34)) 1538 JADE ST, Davis, CA *  * SAGE ST/CELADON ST * A343 * STMA * 68 * #130812106 * 25 YOF BACK  INJ",
        "UNIT:E34",
        "ADDR:1538 JADE ST",
        "CITY:Davis",
        "X:SAGE ST/CELADON ST",
        "APT:A343",
        "CODE:STMA",
        "MAP:68",
        "ID:130812106",
        "CALL:25 YOF BACK",
        "INFO:INJ");

    doTest("T51",
        "(Dispatched Call (E31)) 1309 LOCUST PL, Davis, CA *  * LOYOLA DR *  * STPA * 41 * #130812099 * LIFT ASSIST REQUESTED FOR SUBJ INSIDE VEH PARKED IN DRIVEWAY\n\n" +
        "Servi",

        "UNIT:E31",
        "ADDR:1309 LOCUST PL",
        "CITY:Davis",
        "X:LOYOLA DR",
        "CODE:STPA",
        "MAP:41",
        "ID:130812099",
        "CALL:LIFT ASSIST REQUESTED FOR SUBJ INSIDE VEH PARKED IN DRIVEWAY");

    doTest("T52",
        "(Dispatched Call (E34)) 171 HUTCHISON DR, Davis, CA * OLSON HALL (UCD) * CUSHING WY/ROADHOUSE MALL * 40 * STAS * 71 * #130812092 * BASEMENT DUCT DETECTOR",
        "UNIT:E34",
        "ADDR:171 HUTCHISON DR",
        "CITY:Davis",
        "PLACE:OLSON HALL (UCD)",
        "X:CUSHING WY/ROADHOUSE MALL",
        "APT:40",
        "CODE:STAS",
        "MAP:71",
        "ID:130812092",
        "CALL:BASEMENT DUCT DETECTOR");

    doTest("T53",
        "(Dispatched Call (E31)) 1617 RESEARCH PARK DR, Davis, CA * KFC * RICHARDS BL/COWELL BL (KFC) *  * STMA * 72 * #130812080 * PD OS W/ SUBJ, REQ C3 MEDICAL",
        "UNIT:E31",
        "ADDR:1617 RESEARCH PARK DR",
        "CITY:Davis",
        "PLACE:KFC",
        "X:RICHARDS BL/COWELL BL (KFC)",
        "CODE:STMA",
        "MAP:72",
        "ID:130812080",
        "CALL:PD OS W/ SUBJ",
        "INFO:REQ C3 MEDICAL");

    doTest("T54",
        "(Dispatched Call (E32)) 2020 SUTTER PL, Davis, CA * IMAGING * RISLING CT * 102 * STMA * 20 * #130812075 * MALE PX NEEDS AMB TO SUTTER GENERAL .. PX HAS DISLOCATED H",
        "UNIT:E32",
        "ADDR:2020 SUTTER PL",
        "CITY:Davis",
        "PLACE:IMAGING",
        "X:RISLING CT",
        "APT:102",
        "CODE:STMA",
        "MAP:20",
        "ID:130812075",
        "CALL:MALE PX NEEDS AMB TO SUTTER GENERAL .. PX HAS DISLOCATED H");

    doTest("T55",
        "(Dispatched Call (E31)) 2033 F ST, Davis, CA * SUNTREE APARTMENTS * AMAPOLA DR/BUENO DR *  * STMA * 23 * #130812070 * NEAR MAIN ENTRANCE , GRY TOYT COROLLA W/ FEMAL",
        "UNIT:E31",
        "ADDR:2033 F ST",
        "CITY:Davis",
        "PLACE:SUNTREE APARTMENTS",
        "X:AMAPOLA DR/BUENO DR",
        "CODE:STMA",
        "MAP:23",
        "ID:130812070",
        "CALL:NEAR MAIN ENTRANCE",
        "INFO:GRY TOYT COROLLA W/ FEMAL");

    doTest("T56",
        "(Dispatched Call (E32)) 1515 SHASTA DR, Davis, CA * UNIVERSITY RETIREMENT APTS * W COVELL BL/RIO GRANDE ST * 3333 * STMA * 36 * #130812069 * INDEPENDENT LIVING \n" +
        "FE",

        "UNIT:E32",
        "ADDR:1515 SHASTA DR",
        "CITY:Davis",
        "PLACE:UNIVERSITY RETIREMENT APTS",
        "X:W COVELL BL/RIO GRANDE ST",
        "APT:3333",
        "CODE:STMA",
        "MAP:36",
        "ID:130812069",
        "CALL:INDEPENDENT LIVING",
        "INFO:FE");

    doTest("T57",
        "(Dispatched Call (E32)) 819 ADAMS TR, Davis, CA *  * ADAMS ST * C * STAS * 52 * #130812055 * CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY\n" +
        "Cellular ",

        "UNIT:E32",
        "ADDR:819 ADAMS TR",
        "CITY:Davis",
        "X:ADAMS ST",
        "APT:C",
        "CODE:STAS",
        "MAP:52",
        "ID:130812055",
        "CALL:CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY",
        "INFO:Cellular");

    doTest("T58",
        "(Dispatched Call (E31)) 1801 HANOVER DR, Davis, CA * BLOOD SOURCE * ANDERSON RD/SCRIPPS DR * 512 * STSF * 38 * #130812060 * EXTINGUISHED FIRE IN PLANTER BOX IS STIL",
        "UNIT:E31",
        "ADDR:1801 HANOVER DR",
        "CITY:Davis",
        "PLACE:BLOOD SOURCE",
        "X:ANDERSON RD/SCRIPPS DR",
        "APT:512",
        "CODE:STSF",
        "MAP:38",
        "ID:130812060",
        "CALL:EXTINGUISHED FIRE IN PLANTER BOX IS STIL");

    doTest("T59",
        "(Dispatched Call (E32)) 819 ADAMS TR, Davis, CA *  * ADAMS ST * C * STAS * 52 * #130812055 * CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY\n" +
        "Cellular ",

        "UNIT:E32",
        "ADDR:819 ADAMS TR",
        "CITY:Davis",
        "X:ADAMS ST",
        "APT:C",
        "CODE:STAS",
        "MAP:52",
        "ID:130812055",
        "CALL:CARBON MONOXIDE DETECTOR SOUNDING .. LOC UPSTAIRS IN HALLWAY",
        "INFO:Cellular");

    doTest("T60",
        "(Dispatched Call (E31IPAD)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * F262 * STMA * 21 * #130812053 * FEMALE RES, FALL VICTIM, CONSC & BR",
        "UNIT:E31IPAD",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:F262",
        "CODE:STMA",
        "MAP:21",
        "ID:130812053",
        "CALL:FEMALE RES",
        "INFO:FALL VICTIM / CONSC & BR");

    doTest("T61",
        "(Dispatched Call (E32)) 1111 ALVARADO AV, Davis, CA * COVELL GARDENS * ANDERSON RD/SYCAMORE LN * F262 * STMA * 21 * #130812053 * FEMALE RES, FALL VICTIM, CONSC & BR",
        "UNIT:E32",
        "ADDR:1111 ALVARADO AV",
        "MADDR:1111 ALVARADO AVE",
        "CITY:Davis",
        "PLACE:COVELL GARDENS",
        "X:ANDERSON RD/SYCAMORE LN",
        "APT:F262",
        "CODE:STMA",
        "MAP:21",
        "ID:130812053",
        "CALL:FEMALE RES",
        "INFO:FALL VICTIM / CONSC & BR");

    doTest("T62",
        "(Dispatched Call (E31)) 1309 LOCUST PL, Davis, CA *  * LOYOLA DR *  * STMA * 41 * #130812047 * 83 YOM, CONCIOUS AND BREATHING .. REQ TRANSPORT TO HOSPITAL FOR POSS ",
        "UNIT:E31",
        "ADDR:1309 LOCUST PL",
        "CITY:Davis",
        "X:LOYOLA DR",
        "CODE:STMA",
        "MAP:41",
        "ID:130812047",
        "CALL:83 YOM",
        "INFO:CONCIOUS AND BREATHING .. REQ TRANSPORT TO HOSPITAL FOR POSS");

  }
  
  public static void main(String[] args) {
    new CAYoloCountyParserTest().generateTests("T1");
  }
}