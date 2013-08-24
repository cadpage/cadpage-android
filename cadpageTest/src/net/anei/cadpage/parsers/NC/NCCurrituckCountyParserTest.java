package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Currituck County, NC
Contact: Active911
Sender: CAD@co.currituck.nc.us
Agency name: Corolla Fire and Rescue Squad Inc Location: Corolla, NC 

CAD:INV REPORT OF SMOKE OR ALARM;827 WHALEHEAD DR;TEST CALL
CAD:CANCEL;827 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)
CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS
CAD:INV REPORT OF SMOKE OR ALARM;135 SALT HOUSE RD;JOHNS BROTHERS;8007682767
CAD:INV REPORT OF SMOKE OR ALARM;471 ISLAND LEAD RD
CAD:ASSIST FOR AGENCY OR PUBLIC;1013 LIGHTHOUSE DR;VERIZON WIRELESS;7248753289
CAD:GRASS FIRE;150 MP6 BEACH STRAND
CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS SECURITY;8007682767
CAD:INV REPORT OF SMOKE OR ALARM;792 APOLLO RD;THOMAS PARNELL;2524532368
CAD:ENTRAPMENT INACCESSIBLE;645 OCEAN FRONT ARCH;TRACEY WOOSLEY;2525971267
CAD:ASSIST FOR AGENCY OR PUBLIC;162 FOUR SEASONS LN DUCK;DARE CENTRAL
CAD:ACCIDENT;616-BLK HUNT CLUB DR;JACQUELYN;2525482221
CAD:CARBON MONOXIDE;913 SEA RIDGE DR;KEVIN HOFFMAN;4045979877
CAD:GRASS FIRE;1105-BLK AUSTIN ST;DAWN;2525482221
CAD:TRAUMATIC INJURIES;1101-BLK MORRIS DR E
CAD:INV REPORT OF SMOKE OR ALARM;762 VOYAGER RD;JOHNS BROTHERS;8007682767
CAD:COMMAND ESTABLISHED;762 VOYAGER RD; CRLA;(S)BUCK ISLAND (N)
CAD:GRASS FIRE;766 LAKESHORE CT;RIPLEY, CHARLES;2524536426
CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609
CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965
CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009
CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442
CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS
CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191
CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512
CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886
CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767
CAD:GRASS FIRE;333 AUDUBON DR
CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO
CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842
CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310
CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196

[] CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609\n
[] CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965\n
[] CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009\n
[] CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS\n
[] CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191\n
[] CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886\n
[] CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767\n
[] CAD:GRASS FIRE;333 AUDUBON DR\n
[] CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO\n
[] CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842\n
[] CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310\n
[] CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196\n
[] CAD:INV REPORT OF SMOKE OR ALARM;247 LONGFELLOW CV;JOHNS BROS\n
[] CAD:F6;STRUCTURE FIRE;750 WATERS EDGE\n
[] CAD:HAZARDOUS CONDITION;OCEAN TRL/OCEAN WAY;ANDREW;8048952818\n
[] CAD:ACCIDENT;604-BLK CURRITUCK CLUBHOUSE DR;PETER IDANOV;2522025523\n
[] CAD:TRANSFORMER OR POLE FIRE;1023-BLK OCEAN TRL;COROLLA LIGHT SECURITY;2522026313\n
[] CAD:BREATHING PROBLEMS;626 WAVE ARCH;ROSE VARIEL;4124435782\n
[] CAD:GAS LEAK;257 LONGFELLOW CV;GENE HOLCUTT;2524356628\n
[] CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS\n
[] CAD:COMMAND ESTABLISHED;806 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;1066 OCEAN TRL;VICKI CHASE;4052264969\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;866 WHALEHEAD DR;GREG KAUFFMAN;5402208954\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;634 MYRTLEWOOD CT;ROBERT ELDICH;6103498458\n
[] CAD:INV REPORT OF SMOKE OR ALARM;169 SALT HOUSE RD;DAVID MURRAY;2524536388\n
[] CAD:INV REPORT OF SMOKE OR ALARM;929 WHALEHEAD DR;SUSAN BARCLAY;8144420297\n
[] CAD:ASSIST FOR AGENCY OR PUBLIC;157 SALT HOUSE RD;MARYANNE LEPINSKI;2404092081\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROTHERS;8007672767\n
[] CAD:INV REPORT OF SMOKE OR ALARM;815-E OCEAN TRL;SIMPLEX GRINELL;8887467539\n
[] CAD:ACCIDENT;812-B OCEAN TRL;TIM ZENNO;2156302467\n
[] CAD:F6;STRUCTURE FIRE;1263 SANDCASTLE DR\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1251 LAKESIDE CT;ROSE;2524895549\n
[] CAD:ACCIDENT;770-BLK OCEAN TRL;PAUL ROETTEGER;3143046013\n
[] CAD:F6;STRUCTURE FIRE;867 LIGHTHOUSE DR\n
[] CAD:F6;STRUCTURE FIRE;655 JUNIPER BERRY CT\n
[] CAD:INV REPORT OF SMOKE OR ALARM;1123 OCEAN TRL;BARRY RICHMAN;2524532121\n
[] CAD:CANCEL;1123 OCEAN TRL; CRLA\n

Contact: Active911
Agency name: Lower Currituck Volunteer FD
Location: Grandy, NC, United States
Sender: CAD@co.currituck.nc.us

CAD:ACCIDENT;5330 CARATOKE HWY;LESLIE DAUGHTERY;2525990872
CAD:INV REPORT OF SMOKE OR ALARM;571 JARVISBURG RD;CATTAIL LN;S BAYVIEW RD
CAD:INV REPORT OF SMOKE OR ALARM;123-C FORBES LOOP;CARATOKE HWY;CARATOKE HWY
CAD:LANDING ZONE SETUP;6323 CARATOKE HWY;AUGUSTA DR;OUTBACK LN
CAD:ACCIDENT;200-BLK MACEDONIA CHURCH RD;AT&T MOBILITY;2522028711;[LAW] SAME IS OFF TO THE SIDE OF THE ROAD [04/17/13 13:53:54 KEPPLEY] MOTORCYCLE 10-50 WITH INJURIES PER CALLER [04/17/13 13:53:47 KEPPLEY]
CAD:HAZARDOUS CONDITION;7069-BLK CARATOKE HWY;JENNIFER WOOD;5188921984;WIRE SWINGING AND HIT WINDSHIELD [04/14/13 14:48:56 SHELTON]
CAD:INV REPORT OF SMOKE OR ALARM;100 MERCEDES CT;WATERFRONT DR
CAD:INV REPORT OF SMOKE OR ALARM;121 FORBES RD;CARATOKE HWY;INDIAN KETTLE RD
CAD:ACCIDENT;EDGEWATER RD/HARBINGER RIDGE RD;SANDEE SALIMBENE;EDGEWATER AND HARBINGER RD MALE INJURED [04/11/13 17:28:20 SHELTON]
CAD:ACCIDENT;CARATOKE HWY/FEREBEE LN;VERIZON WIRELESS;2524558252;truck pulled out and another one hit it. [04/09/13 18:20:41 RBAREFOOT]
CAD:ASSIST FOR AGENCY OR PUBLIC;149 UNCLE GRAHAM RD;TREMAINE LINDSEY;2523848152;CHILD LOCKED IN CAR, 2 YEARS OLD [04/07/13 21:56:50 SSALIMBENE]
CAD:GRASS FIRE;6400-BLK CARATOKE HWY;CAROLINA CLUB DR;GRANDY RD
CAD:ACCIDENT;4952 CARATOKE HWY;SANDY DANDY;2522077300;HEADLIGHTS ARE ON, MOTOR IS RUNNING [04/05/13 23:41:29 AKIGHT] DOESN`T APPEAR TO BE ANY INJ [04/05/13 23:41:23 AKIGHT] car in the ditch [04/05/13 23:41:03 AKIGHT]
CAD:STRUCTURE FIRE;113 NEAL AVE;ALBEMARLE ST
CAD:GRASS FIRE;164 SIMPSON LN;CARATOKE HWY
CAD:STRUCTURE FIRE;108 SHARK ST;SAILFISH ST
CAD:ACCIDENT;633 GRANDY RD;WAYNE GARRENTON;2522076781;car turned over north of this location [04/03/13 03:39:25 AKIGHT]
CAD:GRASS FIRE;103 MARQUIS CT;PARKERS LANDING DR
CAD:INV REPORT OF SMOKE OR ALARM;6615 CARATOKE HWY;EDGEWATER DR;SOUNDSIDE ESTATES DR
CAD:ACCIDENT;6501 CARATOKE HWY;LISA MILES;2524533993;WHT PICKUP TRK [03/27/13 10:32:35 EGILLEN] ONE IS WHITE TOWWN CAR [03/27/13 10:32:09 EGILLEN] PD ONLY [03/27/13 10:31:57 EGILLEN] NO FLUID [03/27/13 10:31:48 EGILLEN] NO INJ [03/27/13 10:
CAD:STRUCTURE FIRE;1275 WATERLILY RD;B AND B LN;NEVERSAIL WAY
CAD:STRUCTURE FIRE;103 SUNDOWN CT;SOUNDSIDE ESTATES DR
CAD:GAS LEAK;107 FOSTER FORBES RD;CARATOKE HWY;SANDY MEADOW LN
CAD:ACCIDENT;CARATOKE HWY/WALNUT ISLAND BLVD;JEFFERSON HELTER;rear end 10-50 no pi resported [03/19/13 15:43:12 SHELTON]
CAD:ILLEGAL BURN;145 FARIS DR;WALNUT ISLAND BLVD;HOLLY CRES
CAD:INV REPORT OF SMOKE OR ALARM;6615 CARATOKE HWY;EDGEWATER DR;SOUNDSIDE ESTATES DR
CAD:ILLEGAL BURN;100-BLK TROUT CT;WATERVIEW DR
CAD:ASSIST FOR AGENCY OR PUBLIC;109 FORBES LOOP;AMY PAYNE;2522073437;5 MONTH OLD LOCKED IN THE CAR [03/15/13 17:08:33 KEPPLEY]
CAD:ACCIDENT;POPLAR BRANCH RD/BARNARD RD;ALLEN HASTINGS;9194172954;UNK INJURIES OR FLUID LEAKAGE [03/15/13 15:55:52 BBROWN] CHEVY CRUZE V. BUICK [03/15/13 15:55:45 BBROWN] 2 VEH 10-50 [03/15/13 15:55:33 BBROWN]
CAD:GRASS FIRE;3023 CARATOKE HWY;LAUREL WOODS BLVD;JBC SHORE DR
CAD:GAS LEAK;112 ARNOLD DR;CARATOKE HWY
CAD:GRASS FIRE;130 STRAWHOUSE LN;N SPOT RD
CAD:INV REPORT OF SMOKE OR ALARM;170-BLK DOWDYS BAY RD;WATERVIEW DR
CAD:INV REPORT OF SMOKE OR ALARM;7900-BLK CARATOKE HWY;N FEREBEE LN;FEREBEE LN
CAD:TRANSFORMER OR POLE FIRE;209 S SPOT RD;HALL FAMILY LN;CARATOKE HWY
CAD:INV REPORT OF SMOKE OR ALARM;100 BENJAMIN CT;SOUNDSIDE ESTATES DR
CAD:ACCIDENT;8568 CARATOKE HWY;BENITA/MILL END CARPETS;2524912594;RANGER PICK UP TRUCK SLAMMED BY DUMP TRUCK [03/05/13 14:26:31 SHELTON] dump truck driver john gaither calling in as well [03/05/13 14:26:22 EGILLEN]
CAD:INV REPORT OF SMOKE OR ALARM;8955 CARATOKE HWY;NEW BEACH RD;DORIS LN
CAD:INV REPORT OF SMOKE OR ALARM;732 POPLAR BRANCH RD;TURF LN;TUCKERS LAIR
CAD:INV REPORT OF SMOKE OR ALARM;100 MERCEDES CT;WATERFRONT DR
CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;AUGUSTA DR;OUTBACK LN;STILL TESTING TO DO RESPOND [02/28/13 14:34:32 LHODGIS] TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]
CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;GNDY;AUGUSTA DR;OUTBACK LN;TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]
CAD:6323 CARATOKE HWY;TEST CALL;TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]
CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;GNDY

*/

public class NCCurrituckCountyParserTest extends BaseParserTest {
  
  public NCCurrituckCountyParserTest() {
    setParser(new NCCurrituckCountyParser(), "CURRITUCK COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:INV REPORT OF SMOKE OR ALARM;827 WHALEHEAD DR;TEST CALL",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:827 WHALEHEAD DR",
        "NAME:TEST CALL");

    doTest("T2",
        "CAD:CANCEL;827 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)",
        "CALL:CANCEL",
        "ADDR:827 WHALEHEAD DR",
        "CITY:COROLLA",
        "PLACE:WHALEHEAD CLUB");

    doTest("T3",
        "CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:806 WHALEHEAD DR",
        "NAME:JOHNS BROS");

    doTest("T4",
        "CAD:INV REPORT OF SMOKE OR ALARM;135 SALT HOUSE RD;JOHNS BROTHERS;8007682767",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:135 SALT HOUSE RD",
        "NAME:JOHNS BROTHERS",
        "PHONE:8007682767");

    doTest("T5",
        "CAD:INV REPORT OF SMOKE OR ALARM;471 ISLAND LEAD RD",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:471 ISLAND LEAD RD");

    doTest("T6",
        "CAD:ASSIST FOR AGENCY OR PUBLIC;1013 LIGHTHOUSE DR;VERIZON WIRELESS;7248753289",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:1013 LIGHTHOUSE DR",
        "PHONE:7248753289");

    doTest("T7",
        "CAD:GRASS FIRE;150 MP6 BEACH STRAND",
        "CALL:GRASS FIRE",
        "ADDR:150 MP6 BEACH STRAND");  // No idea what this is????

    doTest("T8",
        "CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS SECURITY;8007682767",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1076 LIGHTHOUSE DR",
        "NAME:JOHNS BROS SECURITY",
        "PHONE:8007682767");

    doTest("T9",
        "CAD:INV REPORT OF SMOKE OR ALARM;792 APOLLO RD;THOMAS PARNELL;2524532368",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:792 APOLLO RD",
        "NAME:THOMAS PARNELL",
        "PHONE:2524532368");

    doTest("T10",
        "CAD:ENTRAPMENT INACCESSIBLE;645 OCEAN FRONT ARCH;TRACEY WOOSLEY;2525971267",
        "CALL:ENTRAPMENT INACCESSIBLE",
        "ADDR:645 OCEAN FRONT ARCH",
        "NAME:TRACEY WOOSLEY",
        "PHONE:2525971267");

    doTest("T11",
        "CAD:ASSIST FOR AGENCY OR PUBLIC;162 FOUR SEASONS LN DUCK;DARE CENTRAL",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:162 FOUR SEASONS LN",
        "CITY:DUCK",
        "NAME:DARE CENTRAL");

    doTest("T12",
        "CAD:ACCIDENT;616-BLK HUNT CLUB DR;JACQUELYN;2525482221",
        "CALL:ACCIDENT",
        "ADDR:616-BLK HUNT CLUB DR",
        "MADDR:616 HUNT CLUB DR",
        "NAME:JACQUELYN",
        "PHONE:2525482221");

    doTest("T13",
        "CAD:CARBON MONOXIDE;913 SEA RIDGE DR;KEVIN HOFFMAN;4045979877",
        "CALL:CARBON MONOXIDE",
        "ADDR:913 SEA RIDGE DR",
        "NAME:KEVIN HOFFMAN",
        "PHONE:4045979877");

    doTest("T14",
        "CAD:GRASS FIRE;1105-BLK AUSTIN ST;DAWN;2525482221",
        "CALL:GRASS FIRE",
        "ADDR:1105-BLK AUSTIN ST",
        "MADDR:1105 AUSTIN ST",
        "NAME:DAWN",
        "PHONE:2525482221");

    doTest("T15",
        "CAD:TRAUMATIC INJURIES;1101-BLK MORRIS DR E",
        "CALL:TRAUMATIC INJURIES",
        "ADDR:1101-BLK MORRIS DR E",
        "MADDR:1101 MORRIS DR E");

    doTest("T16",
        "CAD:INV REPORT OF SMOKE OR ALARM;762 VOYAGER RD;JOHNS BROTHERS;8007682767",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:762 VOYAGER RD",
        "NAME:JOHNS BROTHERS",
        "PHONE:8007682767");

    doTest("T17",
        "CAD:COMMAND ESTABLISHED;762 VOYAGER RD; CRLA;(S)BUCK ISLAND (N)",
        "CALL:COMMAND ESTABLISHED",
        "ADDR:762 VOYAGER RD",
        "CITY:COROLLA",
        "PLACE:BUCK ISLAND");

    doTest("T18",
        "CAD:GRASS FIRE;766 LAKESHORE CT;RIPLEY, CHARLES;2524536426",
        "CALL:GRASS FIRE",
        "ADDR:766 LAKESHORE CT",
        "NAME:RIPLEY, CHARLES",
        "PHONE:2524536426");

    doTest("T19",
        "CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:774 BAYBERRY CT",
        "NAME:BRETT FRAILEY",
        "PHONE:2524532609");

    doTest("T20",
        "CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965",
        "CALL:ACCIDENT",
        "ADDR:OCEAN TRL & SCHOOLHOUSE LN",  // Won't map - Reported to google
        "PHONE:7048986965");

    doTest("T21",
        "CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009",
        "CALL:ACCIDENT",
        "ADDR:1150 OCEAN TRL",
        "NAME:MARIE LONG",
        "PHONE:7578693009");

    doTest("T22",
        "CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442",
        "CALL:ACCIDENT",
        "ADDR:510-C OLD STONEY RD",
        "MADDR:510 OLD STONEY RD",
        "NAME:CHEIF 6",
        "PHONE:2526194442");

    doTest("T23",
        "CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1076 LIGHTHOUSE DR",
        "NAME:JOHNS BROS");

    doTest("T24",
        "CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191",
        "CALL:HAZARDOUS CONDITION",
        "ADDR:861 LIGHTHOUSE DR",
        "NAME:BRIAN COLE",
        "PHONE:9106395191");

    doTest("T25",
        "CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512",
        "CALL:ENTRAPMENT INACCESSIBLE",
        "ADDR:600 CURRITUCK CLUBHOUSE DR",
        "NAME:JAMES HOLDING L*L*C",
        "PHONE:2524530512");

    doTest("T26",
        "CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1001 CANE GARDEN BAY CIR",  // Not mapping
        "NAME:NICOLE",
        "PHONE:4432204886");

    doTest("T27",
        "CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:418 MYRTLE POND RD",
        "NAME:JOHNS BROS-17",
        "PHONE:8007682767");

    doTest("T28",
        "CAD:GRASS FIRE;333 AUDUBON DR",
        "CALL:GRASS FIRE",
        "ADDR:333 AUDUBON DR");

    doTest("T29",
        "CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:453 NORTH COVE RD",
        "NAME:SUSAN -JOHNS BRO");

    doTest("T30",
        "CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842",
        "CALL:ACCIDENT",
        "ADDR:424-BLK OCEAN TRL",
        "MADDR:424 OCEAN TRL",
        "PHONE:2522027842");

    doTest("T31",
        "CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:935 COROLLA DR",
        "NAME:TRUDY ALEXANDER",
        "PHONE:2524533310");

    doTest("T32",
        "CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196",
        "CALL:SICK PERSON",
        "ADDR:1140 MORRIS DR",
        "NAME:TRACEY STARLIPER",
        "PHONE:2525971196");

    doTest("T33",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;774 BAYBERRY CT;BRETT FRAILEY;2524532609\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:774 BAYBERRY CT",
        "NAME:BRETT FRAILEY",
        "PHONE:2524532609");

    doTest("T34",
        "[] CAD:ACCIDENT;OCEAN TRL/SCHOOLHOUSE LN;AT&T MOBILITY;7048986965\n",
        "CALL:ACCIDENT",
        "ADDR:OCEAN TRL & SCHOOLHOUSE LN",
        "PHONE:7048986965");

    doTest("T35",
        "[] CAD:ACCIDENT;1150 OCEAN TRL;MARIE LONG;7578693009\n",
        "CALL:ACCIDENT",
        "ADDR:1150 OCEAN TRL",
        "NAME:MARIE LONG",
        "PHONE:7578693009");

    doTest("T36",
        "[] CAD:ACCIDENT;510-C OLD STONEY RD;CHEIF 6;2526194442\n",
        "CALL:ACCIDENT",
        "ADDR:510-C OLD STONEY RD",
        "MADDR:510 OLD STONEY RD",
        "NAME:CHEIF 6",
        "PHONE:2526194442");

    doTest("T37",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROS\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1076 LIGHTHOUSE DR",
        "NAME:JOHNS BROS");

    doTest("T38",
        "[] CAD:HAZARDOUS CONDITION;861 LIGHTHOUSE DR;BRIAN COLE;9106395191\n",
        "CALL:HAZARDOUS CONDITION",
        "ADDR:861 LIGHTHOUSE DR",
        "NAME:BRIAN COLE",
        "PHONE:9106395191");

    doTest("T39",
        "[] CAD:ENTRAPMENT INACCESSIBLE;600 CURRITUCK CLUBHOUSE DR;JAMES HOLDING L*L*C;2524530512\n",
        "CALL:ENTRAPMENT INACCESSIBLE",
        "ADDR:600 CURRITUCK CLUBHOUSE DR",
        "NAME:JAMES HOLDING L*L*C",
        "PHONE:2524530512");

    doTest("T40",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;1001 CANE GARDEN BAY CIR;NICOLE;4432204886\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1001 CANE GARDEN BAY CIR",
        "NAME:NICOLE",
        "PHONE:4432204886");

    doTest("T41",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;418 MYRTLE POND RD;JOHNS BROS-17;8007682767\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:418 MYRTLE POND RD",
        "NAME:JOHNS BROS-17",
        "PHONE:8007682767");

    doTest("T42",
        "[] CAD:GRASS FIRE;333 AUDUBON DR\n",
        "CALL:GRASS FIRE",
        "ADDR:333 AUDUBON DR");

    doTest("T43",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;453 NORTH COVE RD;SUSAN -JOHNS BRO\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:453 NORTH COVE RD",
        "NAME:SUSAN -JOHNS BRO");

    doTest("T44",
        "[] CAD:ACCIDENT;424-BLK OCEAN TRL;VERIZON WIRELESS;2522027842\n",
        "CALL:ACCIDENT",
        "ADDR:424-BLK OCEAN TRL",
        "MADDR:424 OCEAN TRL",
        "PHONE:2522027842");

    doTest("T45",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;935 COROLLA DR;TRUDY ALEXANDER;2524533310\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:935 COROLLA DR",
        "NAME:TRUDY ALEXANDER",
        "PHONE:2524533310");

    doTest("T46",
        "[] CAD:SICK PERSON;1140 MORRIS DR;TRACEY STARLIPER;2525971196\n",
        "CALL:SICK PERSON",
        "ADDR:1140 MORRIS DR",
        "NAME:TRACEY STARLIPER",
        "PHONE:2525971196");

    doTest("T47",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;247 LONGFELLOW CV;JOHNS BROS\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:247 LONGFELLOW CV",
        "NAME:JOHNS BROS");

    doTest("T48",
        "[] CAD:F6;STRUCTURE FIRE;750 WATERS EDGE\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:750 WATERS EDGE");

    doTest("T49",
        "[] CAD:HAZARDOUS CONDITION;OCEAN TRL/OCEAN WAY;ANDREW;8048952818\n",
        "CALL:HAZARDOUS CONDITION",
        "ADDR:OCEAN TRL & OCEAN WAY",
        "NAME:ANDREW",
        "PHONE:8048952818");

    doTest("T50",
        "[] CAD:ACCIDENT;604-BLK CURRITUCK CLUBHOUSE DR;PETER IDANOV;2522025523\n",
        "CALL:ACCIDENT",
        "ADDR:604-BLK CURRITUCK CLUBHOUSE DR",
        "MADDR:604 CURRITUCK CLUBHOUSE DR",
        "NAME:PETER IDANOV",
        "PHONE:2522025523");

    doTest("T51",
        "[] CAD:TRANSFORMER OR POLE FIRE;1023-BLK OCEAN TRL;COROLLA LIGHT SECURITY;2522026313\n",
        "CALL:TRANSFORMER OR POLE FIRE",
        "ADDR:1023-BLK OCEAN TRL",
        "MADDR:1023 OCEAN TRL",
        "NAME:COROLLA LIGHT SECURITY",
        "PHONE:2522026313");

    doTest("T52",
        "[] CAD:BREATHING PROBLEMS;626 WAVE ARCH;ROSE VARIEL;4124435782\n",
        "CALL:BREATHING PROBLEMS",
        "ADDR:626 WAVE ARCH",
        "NAME:ROSE VARIEL",
        "PHONE:4124435782");

    doTest("T53",
        "[] CAD:GAS LEAK;257 LONGFELLOW CV;GENE HOLCUTT;2524356628\n",
        "CALL:GAS LEAK",
        "ADDR:257 LONGFELLOW CV",
        "NAME:GENE HOLCUTT",
        "PHONE:2524356628");

    doTest("T54",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;806 WHALEHEAD DR;JOHNS BROS\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:806 WHALEHEAD DR",
        "NAME:JOHNS BROS");

    doTest("T55",
        "[] CAD:COMMAND ESTABLISHED;806 WHALEHEAD DR; CRLA;(S)WHALEHEAD CLUB (N)\n",
        "CALL:COMMAND ESTABLISHED",
        "ADDR:806 WHALEHEAD DR",
        "CITY:COROLLA",
        "PLACE:WHALEHEAD CLUB");

    doTest("T56",
        "[] CAD:ASSIST FOR AGENCY OR PUBLIC;1066 OCEAN TRL;VICKI CHASE;4052264969\n",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:1066 OCEAN TRL",
        "NAME:VICKI CHASE",
        "PHONE:4052264969");

    doTest("T57",
        "[] CAD:ASSIST FOR AGENCY OR PUBLIC;866 WHALEHEAD DR;GREG KAUFFMAN;5402208954\n",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:866 WHALEHEAD DR",
        "NAME:GREG KAUFFMAN",
        "PHONE:5402208954");

    doTest("T58",
        "[] CAD:ASSIST FOR AGENCY OR PUBLIC;634 MYRTLEWOOD CT;ROBERT ELDICH;6103498458\n",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:634 MYRTLEWOOD CT",
        "NAME:ROBERT ELDICH",
        "PHONE:6103498458");

    doTest("T59",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;169 SALT HOUSE RD;DAVID MURRAY;2524536388\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:169 SALT HOUSE RD",
        "NAME:DAVID MURRAY",
        "PHONE:2524536388");

    doTest("T60",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;929 WHALEHEAD DR;SUSAN BARCLAY;8144420297\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:929 WHALEHEAD DR",
        "NAME:SUSAN BARCLAY",
        "PHONE:8144420297");

    doTest("T61",
        "[] CAD:ASSIST FOR AGENCY OR PUBLIC;157 SALT HOUSE RD;MARYANNE LEPINSKI;2404092081\n",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:157 SALT HOUSE RD",
        "NAME:MARYANNE LEPINSKI",
        "PHONE:2404092081");

    doTest("T62",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;1076 LIGHTHOUSE DR;JOHNS BROTHERS;8007672767\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1076 LIGHTHOUSE DR",
        "NAME:JOHNS BROTHERS",
        "PHONE:8007672767");

    doTest("T63",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;815-E OCEAN TRL;SIMPLEX GRINELL;8887467539\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:815-E OCEAN TRL",
        "MADDR:815 OCEAN TRL",
        "NAME:SIMPLEX GRINELL",
        "PHONE:8887467539");

    doTest("T64",
        "[] CAD:ACCIDENT;812-B OCEAN TRL;TIM ZENNO;2156302467\n",
        "CALL:ACCIDENT",
        "ADDR:812-B OCEAN TRL",
        "MADDR:812 OCEAN TRL",
        "NAME:TIM ZENNO",
        "PHONE:2156302467");

    doTest("T65",
        "[] CAD:F6;STRUCTURE FIRE;1263 SANDCASTLE DR\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:1263 SANDCASTLE DR");

    doTest("T66",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;1251 LAKESIDE CT;ROSE;2524895549\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1251 LAKESIDE CT",
        "NAME:ROSE",
        "PHONE:2524895549");

    doTest("T67",
        "[] CAD:ACCIDENT;770-BLK OCEAN TRL;PAUL ROETTEGER;3143046013\n",
        "CALL:ACCIDENT",
        "ADDR:770-BLK OCEAN TRL",
        "MADDR:770 OCEAN TRL",
        "NAME:PAUL ROETTEGER",
        "PHONE:3143046013");

    doTest("T68",
        "[] CAD:F6;STRUCTURE FIRE;867 LIGHTHOUSE DR\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:867 LIGHTHOUSE DR");

    doTest("T69",
        "[] CAD:F6;STRUCTURE FIRE;655 JUNIPER BERRY CT\n",
        "CALL:STRUCTURE FIRE",
        "ADDR:655 JUNIPER BERRY CT");

    doTest("T70",
        "[] CAD:INV REPORT OF SMOKE OR ALARM;1123 OCEAN TRL;BARRY RICHMAN;2524532121\n",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:1123 OCEAN TRL",
        "NAME:BARRY RICHMAN",
        "PHONE:2524532121");

    doTest("T71",
        "[] CAD:CANCEL;1123 OCEAN TRL; CRLA\n",
        "CALL:CANCEL",
        "ADDR:1123 OCEAN TRL",
        "CITY:COROLLA");
  }
  
  @Test
  public void testLowerCurrituckVolunteerFD() {

    doTest("T1",
        "CAD:ACCIDENT;5330 CARATOKE HWY;LESLIE DAUGHTERY;2525990872",
        "CALL:ACCIDENT",
        "ADDR:5330 CARATOKE HWY",
        "NAME:LESLIE DAUGHTERY",
        "PHONE:2525990872");

    doTest("T2",
        "CAD:INV REPORT OF SMOKE OR ALARM;571 JARVISBURG RD;CATTAIL LN;S BAYVIEW RD",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:571 JARVISBURG RD",
        "X:CATTAIL LN & S BAYVIEW RD");

    doTest("T3",
        "CAD:INV REPORT OF SMOKE OR ALARM;123-C FORBES LOOP;CARATOKE HWY;CARATOKE HWY",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:123-C FORBES LOOP",
        "MADDR:123 FORBES LOOP",
        "X:CARATOKE HWY & CARATOKE HWY");

    doTest("T4",
        "CAD:LANDING ZONE SETUP;6323 CARATOKE HWY;AUGUSTA DR;OUTBACK LN",
        "CALL:LANDING ZONE SETUP",
        "ADDR:6323 CARATOKE HWY",
        "X:AUGUSTA DR & OUTBACK LN");

    doTest("T5",
        "CAD:ACCIDENT;200-BLK MACEDONIA CHURCH RD;AT&T MOBILITY;2522028711;[LAW] SAME IS OFF TO THE SIDE OF THE ROAD [04/17/13 13:53:54 KEPPLEY] MOTORCYCLE 10-50 WITH INJURIES PER CALLER [04/17/13 13:53:47 KEPPLEY]",
        "CALL:ACCIDENT",
        "ADDR:200-BLK MACEDONIA CHURCH RD",
        "MADDR:200 MACEDONIA CHURCH RD",
        "PHONE:2522028711",
        "DATE:04/17/13",
        "TIME:13:53:54");

    doTest("T6",
        "CAD:HAZARDOUS CONDITION;7069-BLK CARATOKE HWY;JENNIFER WOOD;5188921984;WIRE SWINGING AND HIT WINDSHIELD [04/14/13 14:48:56 SHELTON]",
        "CALL:HAZARDOUS CONDITION",
        "ADDR:7069-BLK CARATOKE HWY",
        "MADDR:7069 CARATOKE HWY",
        "NAME:JENNIFER WOOD",
        "PHONE:5188921984",
        "DATE:04/14/13",
        "TIME:14:48:56");

    doTest("T7",
        "CAD:INV REPORT OF SMOKE OR ALARM;100 MERCEDES CT;WATERFRONT DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:100 MERCEDES CT",
        "X:WATERFRONT DR");

    doTest("T8",
        "CAD:INV REPORT OF SMOKE OR ALARM;121 FORBES RD;CARATOKE HWY;INDIAN KETTLE RD",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:121 FORBES RD",
        "X:CARATOKE HWY & INDIAN KETTLE RD");

    doTest("T9",
        "CAD:ACCIDENT;EDGEWATER RD/HARBINGER RIDGE RD;SANDEE SALIMBENE;EDGEWATER AND HARBINGER RD MALE INJURED [04/11/13 17:28:20 SHELTON]",
        "CALL:ACCIDENT",
        "ADDR:EDGEWATER RD & HARBINGER RIDGE RD",
        "NAME:SANDEE SALIMBENE",
        "PHONE:EDGEWATER AND HARBINGER RD MALE INJURED",
        "DATE:04/11/13",
        "TIME:17:28:20");

    doTest("T10",
        "CAD:ACCIDENT;CARATOKE HWY/FEREBEE LN;VERIZON WIRELESS;2524558252;truck pulled out and another one hit it. [04/09/13 18:20:41 RBAREFOOT]",
        "CALL:ACCIDENT",
        "ADDR:CARATOKE HWY & FEREBEE LN",
        "PHONE:2524558252",
        "DATE:04/09/13",
        "TIME:18:20:41");

    doTest("T11",
        "CAD:ASSIST FOR AGENCY OR PUBLIC;149 UNCLE GRAHAM RD;TREMAINE LINDSEY;2523848152;CHILD LOCKED IN CAR, 2 YEARS OLD [04/07/13 21:56:50 SSALIMBENE]",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:149 UNCLE GRAHAM RD",
        "NAME:TREMAINE LINDSEY",
        "PHONE:2523848152",
        "DATE:04/07/13",
        "TIME:21:56:50");

    doTest("T12",
        "CAD:GRASS FIRE;6400-BLK CARATOKE HWY;CAROLINA CLUB DR;GRANDY RD",
        "CALL:GRASS FIRE",
        "ADDR:6400-BLK CARATOKE HWY",
        "MADDR:6400 CARATOKE HWY",
        "X:CAROLINA CLUB DR & GRANDY RD");

    doTest("T13",
        "CAD:ACCIDENT;4952 CARATOKE HWY;SANDY DANDY;2522077300;HEADLIGHTS ARE ON, MOTOR IS RUNNING [04/05/13 23:41:29 AKIGHT] DOESN`T APPEAR TO BE ANY INJ [04/05/13 23:41:23 AKIGHT] car in the ditch [04/05/13 23:41:03 AKIGHT]",
        "CALL:ACCIDENT",
        "ADDR:4952 CARATOKE HWY",
        "NAME:SANDY DANDY",
        "PHONE:2522077300",
        "DATE:04/05/13",
        "TIME:23:41:29");

    doTest("T14",
        "CAD:STRUCTURE FIRE;113 NEAL AVE;ALBEMARLE ST",
        "CALL:STRUCTURE FIRE",
        "ADDR:113 NEAL AVE",
        "X:ALBEMARLE ST");

    doTest("T15",
        "CAD:GRASS FIRE;164 SIMPSON LN;CARATOKE HWY",
        "CALL:GRASS FIRE",
        "ADDR:164 SIMPSON LN",
        "X:CARATOKE HWY");

    doTest("T16",
        "CAD:STRUCTURE FIRE;108 SHARK ST;SAILFISH ST",
        "CALL:STRUCTURE FIRE",
        "ADDR:108 SHARK ST",
        "X:SAILFISH ST");

    doTest("T17",
        "CAD:ACCIDENT;633 GRANDY RD;WAYNE GARRENTON;2522076781;car turned over north of this location [04/03/13 03:39:25 AKIGHT]",
        "CALL:ACCIDENT",
        "ADDR:633 GRANDY RD",
        "NAME:WAYNE GARRENTON",
        "PHONE:2522076781",
        "DATE:04/03/13",
        "TIME:03:39:25");

    doTest("T18",
        "CAD:GRASS FIRE;103 MARQUIS CT;PARKERS LANDING DR",
        "CALL:GRASS FIRE",
        "ADDR:103 MARQUIS CT",
        "X:PARKERS LANDING DR");

    doTest("T19",
        "CAD:INV REPORT OF SMOKE OR ALARM;6615 CARATOKE HWY;EDGEWATER DR;SOUNDSIDE ESTATES DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:6615 CARATOKE HWY",
        "X:EDGEWATER DR & SOUNDSIDE ESTATES DR");

    doTest("T20",
        "CAD:ACCIDENT;6501 CARATOKE HWY;LISA MILES;2524533993;WHT PICKUP TRK [03/27/13 10:32:35 EGILLEN] ONE IS WHITE TOWWN CAR [03/27/13 10:32:09 EGILLEN] PD ONLY [03/27/13 10:31:57 EGILLEN] NO FLUID [03/27/13 10:31:48 EGILLEN] NO INJ [03/27/13 10:",
        "CALL:ACCIDENT",
        "ADDR:6501 CARATOKE HWY",
        "NAME:LISA MILES",
        "PHONE:2524533993",
        "DATE:03/27/13",
        "TIME:10:32:35");

    doTest("T21",
        "CAD:STRUCTURE FIRE;1275 WATERLILY RD;B AND B LN;NEVERSAIL WAY",
        "CALL:STRUCTURE FIRE",
        "ADDR:1275 WATERLILY RD",
        "NAME:B AND B LN",
        "PHONE:NEVERSAIL WAY");

    doTest("T22",
        "CAD:STRUCTURE FIRE;103 SUNDOWN CT;SOUNDSIDE ESTATES DR",
        "CALL:STRUCTURE FIRE",
        "ADDR:103 SUNDOWN CT",
        "X:SOUNDSIDE ESTATES DR");

    doTest("T23",
        "CAD:GAS LEAK;107 FOSTER FORBES RD;CARATOKE HWY;SANDY MEADOW LN",
        "CALL:GAS LEAK",
        "ADDR:107 FOSTER FORBES RD",
        "X:CARATOKE HWY & SANDY MEADOW LN");

    doTest("T24",
        "CAD:ACCIDENT;CARATOKE HWY/WALNUT ISLAND BLVD;JEFFERSON HELTER;rear end 10-50 no pi resported [03/19/13 15:43:12 SHELTON]",
        "CALL:ACCIDENT",
        "ADDR:CARATOKE HWY & WALNUT ISLAND BLVD",
        "NAME:JEFFERSON HELTER",
        "PHONE:rear end 10-50 no pi resported",
        "DATE:03/19/13",
        "TIME:15:43:12");

    doTest("T25",
        "CAD:ILLEGAL BURN;145 FARIS DR;WALNUT ISLAND BLVD;HOLLY CRES",
        "CALL:ILLEGAL BURN",
        "ADDR:145 FARIS DR",
        "X:WALNUT ISLAND BLVD",
        "NAME:HOLLY CRES");

    doTest("T26",
        "CAD:INV REPORT OF SMOKE OR ALARM;6615 CARATOKE HWY;EDGEWATER DR;SOUNDSIDE ESTATES DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:6615 CARATOKE HWY",
        "X:EDGEWATER DR & SOUNDSIDE ESTATES DR");

    doTest("T27",
        "CAD:ILLEGAL BURN;100-BLK TROUT CT;WATERVIEW DR",
        "CALL:ILLEGAL BURN",
        "ADDR:100-BLK TROUT CT",
        "MADDR:100 TROUT CT",
        "X:WATERVIEW DR");

    doTest("T28",
        "CAD:ASSIST FOR AGENCY OR PUBLIC;109 FORBES LOOP;AMY PAYNE;2522073437;5 MONTH OLD LOCKED IN THE CAR [03/15/13 17:08:33 KEPPLEY]",
        "CALL:ASSIST FOR AGENCY OR PUBLIC",
        "ADDR:109 FORBES LOOP",
        "NAME:AMY PAYNE",
        "PHONE:2522073437",
        "DATE:03/15/13",
        "TIME:17:08:33");

    doTest("T29",
        "CAD:ACCIDENT;POPLAR BRANCH RD/BARNARD RD;ALLEN HASTINGS;9194172954;UNK INJURIES OR FLUID LEAKAGE [03/15/13 15:55:52 BBROWN] CHEVY CRUZE V. BUICK [03/15/13 15:55:45 BBROWN] 2 VEH 10-50 [03/15/13 15:55:33 BBROWN]",
        "CALL:ACCIDENT",
        "ADDR:POPLAR BRANCH RD & BARNARD RD",
        "NAME:ALLEN HASTINGS",
        "PHONE:9194172954",
        "DATE:03/15/13",
        "TIME:15:55:52");

    doTest("T30",
        "CAD:GRASS FIRE;3023 CARATOKE HWY;LAUREL WOODS BLVD;JBC SHORE DR",
        "CALL:GRASS FIRE",
        "ADDR:3023 CARATOKE HWY",
        "X:LAUREL WOODS BLVD & JBC SHORE DR");

    doTest("T31",
        "CAD:GAS LEAK;112 ARNOLD DR;CARATOKE HWY",
        "CALL:GAS LEAK",
        "ADDR:112 ARNOLD DR",
        "X:CARATOKE HWY");

    doTest("T32",
        "CAD:GRASS FIRE;130 STRAWHOUSE LN;N SPOT RD",
        "CALL:GRASS FIRE",
        "ADDR:130 STRAWHOUSE LN",
        "X:N SPOT RD");

    doTest("T33",
        "CAD:INV REPORT OF SMOKE OR ALARM;170-BLK DOWDYS BAY RD;WATERVIEW DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:170-BLK DOWDYS BAY RD",
        "MADDR:170 DOWDYS BAY RD",
        "X:WATERVIEW DR");

    doTest("T34",
        "CAD:INV REPORT OF SMOKE OR ALARM;7900-BLK CARATOKE HWY;N FEREBEE LN;FEREBEE LN",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:7900-BLK CARATOKE HWY",
        "MADDR:7900 CARATOKE HWY",
        "X:N FEREBEE LN & FEREBEE LN");

    doTest("T35",
        "CAD:TRANSFORMER OR POLE FIRE;209 S SPOT RD;HALL FAMILY LN;CARATOKE HWY",
        "CALL:TRANSFORMER OR POLE FIRE",
        "ADDR:209 S SPOT RD",
        "X:HALL FAMILY LN & CARATOKE HWY");

    doTest("T36",
        "CAD:INV REPORT OF SMOKE OR ALARM;100 BENJAMIN CT;SOUNDSIDE ESTATES DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:100 BENJAMIN CT",
        "X:SOUNDSIDE ESTATES DR");

    doTest("T37",
        "CAD:ACCIDENT;8568 CARATOKE HWY;BENITA/MILL END CARPETS;2524912594;RANGER PICK UP TRUCK SLAMMED BY DUMP TRUCK [03/05/13 14:26:31 SHELTON] dump truck driver john gaither calling in as well [03/05/13 14:26:22 EGILLEN]",
        "CALL:ACCIDENT",
        "ADDR:8568 CARATOKE HWY",
        "NAME:BENITA/MILL END CARPETS",
        "PHONE:2524912594",
        "DATE:03/05/13",
        "TIME:14:26:31");

    doTest("T38",
        "CAD:INV REPORT OF SMOKE OR ALARM;8955 CARATOKE HWY;NEW BEACH RD;DORIS LN",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:8955 CARATOKE HWY",
        "X:NEW BEACH RD & DORIS LN");

    doTest("T39",
        "CAD:INV REPORT OF SMOKE OR ALARM;732 POPLAR BRANCH RD;TURF LN;TUCKERS LAIR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:732 POPLAR BRANCH RD",
        "X:TURF LN",
        "NAME:TUCKERS LAIR");

    doTest("T40",
        "CAD:INV REPORT OF SMOKE OR ALARM;100 MERCEDES CT;WATERFRONT DR",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:100 MERCEDES CT",
        "X:WATERFRONT DR");

    doTest("T41",
        "CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;AUGUSTA DR;OUTBACK LN;STILL TESTING TO DO RESPOND [02/28/13 14:34:32 LHODGIS] TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:6323 CARATOKE HWY",
        "X:AUGUSTA DR & OUTBACK LN",
        "NAME:STILL TESTING TO DO RESPOND",
        "PHONE:TEST CALL- DO NOT RESPOND",
        "DATE:02/28/13",
        "TIME:14:34:32");

    doTest("T42",
        "CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;GNDY;AUGUSTA DR;OUTBACK LN;TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:6323 CARATOKE HWY",
        "NAME:GNDY",
        "PHONE:AUGUSTA DR",
        "DATE:02/28/13",
        "TIME:14:31:17");

    doTest("T43",
        "CAD:6323 CARATOKE HWY;TEST CALL;TEST CALL- DO NOT RESPOND [02/28/13 14:31:17 LHODGIS]",
        "CALL:6323 CARATOKE HWY",
        "ADDR:TEST CALL",
        "NAME:TEST CALL- DO NOT RESPOND",
        "DATE:02/28/13",
        "TIME:14:31:17");

    doTest("T44",
        "CAD:INV REPORT OF SMOKE OR ALARM;6323 CARATOKE HWY;GNDY",
        "CALL:INV REPORT OF SMOKE OR ALARM",
        "ADDR:6323 CARATOKE HWY",
        "NAME:GNDY");
 
  }
  

  public static void main(String[] args) {
    new NCCurrituckCountyParserTest().generateTests("T1");
  }
}
