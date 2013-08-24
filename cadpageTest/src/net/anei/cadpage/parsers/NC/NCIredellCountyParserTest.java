package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Iredell county, NC
Contact: Jason Little <jason.little82@gmail.com>
Sender: CommtechMessenger@co.iredell.nc.us

FD20 C-5 FIRE ALARM, 347 JENNINGS RD
FR200 FALL, HAWKS RD
FD20 C-36 STAND BY AT BASE, 641 MOCKSVILLE HWY
FR200 MEDICAL ALARM, 142 NEW MEXICO DR
FD20 PUBLIC SERVICE, 106 KNOLLCREST LN
FR200 C-86 RESPIRATORY DISTRESS, 139 EASTGATE DR

Contact: Mark shifflet <markshifflet@att.net>,7044004641@txt.att.net
FRM:CommtechMessenger (emergin)"\nMSG:MFD 2ANAPHYLACTIC SHOCK, 161 NILE CIR

Contact: Carrie La Basco <labascofamily@gmail.com>
Sender: Basepage@co.iredell.nc.us
FD70 C-90 GRASS / WOODS FIRE, TIMBER RD

Contact: pr3@windstream.net <pr3@windstream.net>
Sender: CommtechMessenger@co.iredell.nc.us
MFD C-50 UNCONSCIOUS, 117 PURPLE FINCH LN, 13-00954

Contact: jdeaton@windstream.net <jdeaton@windstream.net>
Sender: Basepage@co.iredell.nc.us
MFD MUTAID - MUTUAL AID, 752 E CENTER AVE, 13-00957
MFD C-65 SEIZURES, 544 BILTMORE ST, 13-00958

Contact: Danny Beauvais <taylordg85@gmail.com>
Sender: CommtechMessenger (emergin)
FRM:CommtechMessenger (emergin)\nMSG:MFD C-65 SEIZURES, 544 BILTMORE ST, 13-00958

Contact: "Shifflet, Mark" <mshifflet@ci.mooresville.nc.us>
Sender: CommtechMessenger (emergin)
FRM:CommtechMessenger (emergin)\nMSG:MFD C-50 UNCONSCIOUS, 113 SHAGBARK LN, 13-01077

Contact: support.active911.com
[] FD18 C-90 HOUSE FIRE, 127 FLORA LN\n
[] FD18 C-36 STAND BY AT BASE, 1819 RIDGE RD\n
[] FD18 C-5 FIRE ALARM, 1969 MOCKSVILLE HW\n

Contact: Active911
Agency name: Lake Norman Fire  Rescue
Location: Mooresville, NC, United States
Sender: CommtechMessenger@co.iredell.nc.us

FR110C-86 RESPIRATORY DISTRESS, 607 BEATEN PATH RD
FR110C-65 SEIZURES, BARBER LOOP
FR110C-41 STROKE, 384 OAK TREE RD
FR110C-50 UNCONSCIOUS, 137 TUSKARORA POINT LN
FD11 C-5 FIRE ALARM, 198 OLYMPIA DR
FR110C-66 MAN DOWN, 109 WYNWARD LN
FR110C-65 SEIZURES, ESQUIRE LN
FR110MUTAID - MUTUAL AID, 154 LAKE PINE RD
FR110C-55 HEAD INJURIES, 129 MOORELAND RD
FR110C-86 RESPIRATORY DISTRESS, 142 DOBBIN DR
FD11 C-5 FIRE ALARM, 132 SWIFT ARROW DR
FD11 C-5 FIRE ALARM, 198 OLYMPIA DR
FR110C-86 RESPIRATORY DISTRESS, 143 PATTERNOTE RD
FR110C-41 STROKE, 384 OAK TREE RD
FR110C-65 SEIZURES, BARBER LOOP
FR110C-86 RESPIRATORY DISTRESS, 607 BEATEN PATH RD
FD11 C-90 HOUSE FIRE, 136 PETERBOROUGH DR
FR110FALL, 161 WOODSTREAM CIR
FR110C-58 HIP INJURY, 154 CULPEZE RD
FD11 CARBON MONOXIDE ACTIVATION, 245 SUNDOWN RD
FD11 10-50 Traffic Accident, 1812 BRAWLEY SCHOOL RD
FR110C-45 CHEST PAINS, 145 WOOD DUCK LOOP
FD11 C-90 HOUSE FIRE, 242 WOOD DUCK LOOP
FD11 ILLEGAL - BURN, BOWFIN CIR
FD11 C-90 BARN FIRE, 170 FERN HILL RD
FR110C-86 RESPIRATORY DISTRESS, 113 DRYE DR
FR110MUTAID - MUTUAL AID, 344 LAKEVIEW SHORES LOOP
FD11 C-5 FIRE ALARM, 116 PINE CLIFF LN
FD11 PUBLIC - SERVICE, 1397 BRAWLEY SCHOOL RD
FR110C-45 CHEST PAINS, 108 CHINOOK LN

Contact: Active911
Agency name: Mooresville Rescue Squad Inc
Location: Mooresville, NC, United States
Sender: "CommtechMessenger (emergin)"<CommtechMessenger@co.iredell.nc.us>

FR03 C-49 DIABETIC COMA, 187 COMMODORE LOOP
FR03 C-86 RESPIRATORY DISTRESS, 414 ROCKY RIVER RD
FR03 C-50 UNCONSCIOUS, 191 MCKENDREE RD
MRS COUNTY  - EMS STANDBY, 204 E IREDELL AV
MRS C-80 CPR IN PROGRESS, 199 CORNELIUS RD
FR03 FALL, 260 LAKESHORE DR
FR03 C-45 CHEST PAINS, 167 WESTMORELAND RD
MRS MUTAID - MUTUAL AID, 219 MCKENDREE RD
FR03 C-66 MAN DOWN, 2002 CHARLOTTE HWY
MRS C-90 HOUSE FIRE, 1500 TRIPLETT RD
FR03 C-86 RESPIRATORY DISTRESS, 168 CROSSRAIL RD
FR03 C-50 UNCONSCIOUS, 137 TUSKARORA POINT LN
FR03 C-86 RESPIRATORY DISTRESS, 1297 SHEARERS RD
FR03 C-45 CHEST PAINS, 152 WOODRIDGE LN
FR03 C-45 CHEST PAINS, 158 WESTMORELAND RD
FR03 C-86 RESPIRATORY DISTRESS, 254 PARADISE PENINSULA RD
FR03 C-66 MAN DOWN, 109 WYNWARD LN
FR03 C-64 GUNSHOT WOUND, 159 WOODRIDGE LN
FR03 C-65 SEIZURES, ESQUIRE LN
FR03 MUTAID - MUTUAL AID, 154 LAKE PINE RD
MRS 10-50 Traffic Accident, 217 BEATEN PATH RD
MRS COUNTY  - EMS STANDBY, 204 E IREDELL AV
MRS C-80 CPR IN PROGRESS, 199 CORNELIUS RD
MRS MUTAID - MUTUAL AID, 219 MCKENDREE RD
MRS C-90 HOUSE FIRE, 1500 TRIPLETT RD
MRS 10-50 Traffic Accident, BIG INDIAN AND BLUEFIELD
MRS C-80 CPR IN PROGRESS, 1113 S  MAGNOLIA ST
MRS 10-50 Traffic Accident, CORNELIUS RD AT BLUEFIELD RD
MRS C-90 HOUSE FIRE, 136 PETERBOROUGH DR
MRS 10-50 Traffic Accident, 2550 CHARLOTTE HWY
MRS 10-50 Traffic Accident, 1812 BRAWLEY SCHOOL RD
MRS 10-50 Traffic Accident, I 77 SB MM34
MRS C-90 HOUSE FIRE, GABRIEL DR

Contact: Active911
Agency name: Iredell County Rescue Squad
Location: Statesville, NC, United States
Sender: "CommtechMessenger (emergin)" <CommtechMessenger@co.iredell.nc.us>

ICRS MUTAID - MUTUAL AID, 119 IVANHOE LN
ICRS PUBLIC - SERVICE, 908 INGLEWOOD RD
FR01 C-66 MAN DOWN, 119 IVANHOE LN
ICRS 10-50 Traffic Accident, 1920 OLD MOUNTAIN RD
FR01 C-65 SEIZURES, 1314 HARRIS ST
FR01 C-49 DIABETIC COMA, 166 GYPSY DR
FR01 C-45 CHEST PAINS, 207 HERITAGE RD
FR01 C-83 HEMORRAGE, 1130 7TH ST
FR01 C-55 HEAD INJURIES, 3439 TAYLORSVILLE HWY
FR01 C-55 HEAD INJURIES, 474 N CENTER ST

Contact: Active911
Agency name: Iredell County Mobile Air Response Team
Location: Statesville, NC, United States
Sender: "CommtechMessenger (emergin)" <CommtechMessenger@co.iredell.nc.us>

FA10 C-90 HOUSE FIRE, E LACKEY FARM RD
FA10 C-90 HOUSE FIRE, 121 POST LN
FA10 C-94 REQUEST AIR UNIT, MYERS MILL RD
FA10 C-94 REQUEST AIR UNIT, 2997 WILKESBORO HWY
FA10 C-90 BUILDING FIRE, 490 SWANN RD
FA10 C-94 REQUEST AIR UNIT, 2997 WILKESBORO HWY
FA10 C-90 HOUSE FIRE, 131 PAUL JR LN
FA10 C-90 HOUSE FIRE, 107 UNION GROVE RD
FA10 C-90 HOUSE FIRE, 1715 YOUNGER AVE
FA10 C-90 HOUSE FIRE, 1112 BROWN SUMMIT AVE

Agency name: Iredell County Fire Marshal
Contact: Active911
Location: Statesville, NC, United States
Sender: "CommtechMessenger (emergin)" <CommtechMessenger@co.iredell.nc.us>

FM3600C-90 BUILDING FIRE, 237 FERN HILL RD
FM3600C-90 BARN FIRE, 103 VAUGHN MILL RD
FM3600C-90 HOUSE FIRE, 123 CAPE COD WAY
FM3600C-90 HOUSE FIRE, 1118 SHARON SCHOOL RD
FM3600C-90 BUILDING FIRE, 187 BRUMLEY RD
FM3600C-90 HOUSE FIRE, E LACKEY FARM RD
FM3600C-6 INVESTIGATION, 2022 OLD MOUNTAIN RD
FM3600C-90 HOUSE FIRE, 121 POST LN
FM3600C-90 HOUSE FIRE, 107 BLUE SKY CT
FM3600C-5 FIRE ALARM, 120 MEETING HOUSE CIR

Contact: Active911
Agency name: Statesville Fire Department
Location: Statesville, NC, United States
Sender: "CommtechMessenger (emergin)" <CommtechMessenger@co.iredell.nc.us>

SFD 10-50 Traffic Accident, 150 E I-40 HWY, 13-00589
SFD HAZMAT - LEVEL 1 RESPONSE, 1357 5TH ST, 13-00588
SFD C-5 FIRE ALARM, 230 N RACE ST, 13-00587
SFD C-50 UNCONSCIOUS, 517 HOLLAND DR, 13-00586
SFD MUTAID - MUTUAL AID, 714 WILMINGTON AVE, 13-00585
SFD PUBLIC - SERVICE, 521 SYLVIA ST, 13-00584
SFD C-5 FIRE ALARM, 743 SPRINGDALE RD, 13-00583
SFD C-90 OTHER FIRE, 519 BROOKDALE DR, 13-00582
SFD PUBLIC - SERVICE, 2155 WEXFORD WAY, 13-00581
SFD C-5 FIRE ALARM, 1929 E BROAD ST, 13-00580

*/

public class NCIredellCountyParserTest extends BaseParserTest {
  
  public NCIredellCountyParserTest() {
    setParser(new NCIredellCountyParser(), "IREDELL COUNTY", "NC");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("If you can, I'll have something planned. No pressure, but hours are available, even on the weekend if interested. Let me know.");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FD20 C-5 FIRE ALARM, 347 JENNINGS RD",
        "UNIT:FD20",
        "CALL:C-5 FIRE ALARM",
        "ADDR:347 JENNINGS RD");

    doTest("T2",
        "FR200 FALL, HAWKS RD",
        "UNIT:FR200",
        "CALL:FALL",
        "ADDR:HAWKS RD");

    doTest("T3",
        "FD20 C-36 STAND BY AT BASE, 641 MOCKSVILLE HWY",
        "UNIT:FD20",
        "CALL:C-36 STAND BY AT BASE",
        "ADDR:641 MOCKSVILLE HWY");

    doTest("T4",
        "FR200 MEDICAL ALARM, 142 NEW MEXICO DR",
        "UNIT:FR200",
        "CALL:MEDICAL ALARM",
        "ADDR:142 NEW MEXICO DR");

    doTest("T5",
        "FD20 PUBLIC SERVICE, 106 KNOLLCREST LN",
        "UNIT:FD20",
        "CALL:PUBLIC SERVICE",
        "ADDR:106 KNOLLCREST LN");

    doTest("T6",
        "FRM:CommtechMessenger (emergin)\"\nMSG:MFD 2ANAPHYLACTIC SHOCK, 161 NILE CIR",
        "UNIT:MFD",
        "CALL:2ANAPHYLACTIC SHOCK",
        "ADDR:161 NILE CIR");

    doTest("T7",
        "FD70 C-90 GRASS / WOODS FIRE, TIMBER RD",
        "UNIT:FD70",
        "CALL:C-90 GRASS / WOODS FIRE",
        "ADDR:TIMBER RD");

  }
  
  @Test
  public void tesetPr3() {

    doTest("T1",
        "MFD C-50 UNCONSCIOUS, 117 PURPLE FINCH LN, 13-00954",
        "UNIT:MFD",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:117 PURPLE FINCH LN",
        "ID:13-00954");
   
  }
  
  @Test
  public void testJdeaton() {

    doTest("T1",
        "MFD MUTAID - MUTUAL AID, 752 E CENTER AVE, 13-00957",
        "UNIT:MFD",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:752 E CENTER AVE",
        "ID:13-00957");

    doTest("T2",
        "MFD C-65 SEIZURES, 544 BILTMORE ST, 13-00958",
        "UNIT:MFD",
        "CALL:C-65 SEIZURES",
        "ADDR:544 BILTMORE ST",
        "ID:13-00958");

  }
  
  @Test
  public void testDannyBeauvais() {

    doTest("T1",
        "FRM:CommtechMessenger (emergin)\nMSG:MFD C-65 SEIZURES, 544 BILTMORE ST, 13-00958",
        "UNIT:MFD",
        "CALL:C-65 SEIZURES",
        "ADDR:544 BILTMORE ST",
        "ID:13-00958");

  }
  
  @Test
  public void testMarkShifflet() {

    doTest("T1",
        "FRM:CommtechMessenger (emergin)\nMSG:MFD C-50 UNCONSCIOUS, 113 SHAGBARK LN, 13-01077",
        "UNIT:MFD",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:113 SHAGBARK LN",
        "ID:13-01077");
  
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[] FD18 C-90 HOUSE FIRE, 127 FLORA LN\n",
        "UNIT:FD18",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:127 FLORA LN");

    doTest("T2",
        "[] FD18 C-36 STAND BY AT BASE, 1819 RIDGE RD\n",
        "UNIT:FD18",
        "CALL:C-36 STAND BY AT BASE",
        "ADDR:1819 RIDGE RD");

    doTest("T3",
        "[] FD18 C-5 FIRE ALARM, 1969 MOCKSVILLE HW\n",
        "UNIT:FD18",
        "CALL:C-5 FIRE ALARM",
        "ADDR:1969 MOCKSVILLE HW",
        "MADDR:1969 MOCKSVILLE HWY");
    
  }
  @Test
  public void testLakeNorman() {

    doTest("T1",
        "FR110C-86 RESPIRATORY DISTRESS, 607 BEATEN PATH RD",
        "UNIT:FR110",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:607 BEATEN PATH RD");

    doTest("T2",
        "FR110C-65 SEIZURES, BARBER LOOP",
        "UNIT:FR110",
        "CALL:C-65 SEIZURES",
        "ADDR:BARBER LOOP");

    doTest("T3",
        "FR110C-41 STROKE, 384 OAK TREE RD",
        "UNIT:FR110",
        "CALL:C-41 STROKE",
        "ADDR:384 OAK TREE RD");

    doTest("T4",
        "FR110C-50 UNCONSCIOUS, 137 TUSKARORA POINT LN",
        "UNIT:FR110",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:137 TUSKARORA POINT LN");

    doTest("T5",
        "FD11 C-5 FIRE ALARM, 198 OLYMPIA DR",
        "UNIT:FD11",
        "CALL:C-5 FIRE ALARM",
        "ADDR:198 OLYMPIA DR");

    doTest("T6",
        "FR110C-66 MAN DOWN, 109 WYNWARD LN",
        "UNIT:FR110",
        "CALL:C-66 MAN DOWN",
        "ADDR:109 WYNWARD LN");

    doTest("T7",
        "FR110C-65 SEIZURES, ESQUIRE LN",
        "UNIT:FR110",
        "CALL:C-65 SEIZURES",
        "ADDR:ESQUIRE LN");

    doTest("T8",
        "FR110MUTAID - MUTUAL AID, 154 LAKE PINE RD",
        "UNIT:FR110",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:154 LAKE PINE RD");

    doTest("T9",
        "FR110C-55 HEAD INJURIES, 129 MOORELAND RD",
        "UNIT:FR110",
        "CALL:C-55 HEAD INJURIES",
        "ADDR:129 MOORELAND RD");

    doTest("T10",
        "FR110C-86 RESPIRATORY DISTRESS, 142 DOBBIN DR",
        "UNIT:FR110",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:142 DOBBIN DR");  // Google says this is DOBBIN LN

    doTest("T11",
        "FD11 C-5 FIRE ALARM, 132 SWIFT ARROW DR",
        "UNIT:FD11",
        "CALL:C-5 FIRE ALARM",
        "ADDR:132 SWIFT ARROW DR");

    doTest("T12",
        "FD11 C-5 FIRE ALARM, 198 OLYMPIA DR",
        "UNIT:FD11",
        "CALL:C-5 FIRE ALARM",
        "ADDR:198 OLYMPIA DR");

    doTest("T13",
        "FR110C-86 RESPIRATORY DISTRESS, 143 PATTERNOTE RD",
        "UNIT:FR110",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:143 PATTERNOTE RD");

    doTest("T14",
        "FR110C-41 STROKE, 384 OAK TREE RD",
        "UNIT:FR110",
        "CALL:C-41 STROKE",
        "ADDR:384 OAK TREE RD");

    doTest("T15",
        "FR110C-65 SEIZURES, BARBER LOOP",
        "UNIT:FR110",
        "CALL:C-65 SEIZURES",
        "ADDR:BARBER LOOP");

    doTest("T16",
        "FR110C-86 RESPIRATORY DISTRESS, 607 BEATEN PATH RD",
        "UNIT:FR110",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:607 BEATEN PATH RD");

    doTest("T17",
        "FD11 C-90 HOUSE FIRE, 136 PETERBOROUGH DR",
        "UNIT:FD11",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:136 PETERBOROUGH DR");

    doTest("T18",
        "FR110FALL, 161 WOODSTREAM CIR",
        "UNIT:FR110",
        "CALL:FALL",
        "ADDR:161 WOODSTREAM CIR");  // Google says this is  WOODSTREAM RD

    doTest("T19",
        "FR110C-58 HIP INJURY, 154 CULPEZE RD",
        "UNIT:FR110",
        "CALL:C-58 HIP INJURY",
        "ADDR:154 CULPEZE RD");

    doTest("T20",
        "FD11 CARBON MONOXIDE ACTIVATION, 245 SUNDOWN RD",
        "UNIT:FD11",
        "CALL:CARBON MONOXIDE ACTIVATION",
        "ADDR:245 SUNDOWN RD");

    doTest("T21",
        "FD11 10-50 Traffic Accident, 1812 BRAWLEY SCHOOL RD",
        "UNIT:FD11",
        "CALL:10-50 Traffic Accident",
        "ADDR:1812 BRAWLEY SCHOOL RD");

    doTest("T22",
        "FR110C-45 CHEST PAINS, 145 WOOD DUCK LOOP",
        "UNIT:FR110",
        "CALL:C-45 CHEST PAINS",
        "ADDR:145 WOOD DUCK LOOP");

    doTest("T23",
        "FD11 C-90 HOUSE FIRE, 242 WOOD DUCK LOOP",
        "UNIT:FD11",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:242 WOOD DUCK LOOP");

    doTest("T24",
        "FD11 ILLEGAL - BURN, BOWFIN CIR",
        "UNIT:FD11",
        "CALL:ILLEGAL - BURN",
        "ADDR:BOWFIN CIR");

    doTest("T25",
        "FD11 C-90 BARN FIRE, 170 FERN HILL RD",
        "UNIT:FD11",
        "CALL:C-90 BARN FIRE",
        "ADDR:170 FERN HILL RD");

    doTest("T26",
        "FR110C-86 RESPIRATORY DISTRESS, 113 DRYE DR",
        "UNIT:FR110",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:113 DRYE DR");

    doTest("T27",
        "FR110MUTAID - MUTUAL AID, 344 LAKEVIEW SHORES LOOP",
        "UNIT:FR110",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:344 LAKEVIEW SHORES LOOP");

    doTest("T28",
        "FD11 C-5 FIRE ALARM, 116 PINE CLIFF LN",
        "UNIT:FD11",
        "CALL:C-5 FIRE ALARM",
        "ADDR:116 PINE CLIFF LN");

    doTest("T29",
        "FD11 PUBLIC - SERVICE, 1397 BRAWLEY SCHOOL RD",
        "UNIT:FD11",
        "CALL:PUBLIC - SERVICE",
        "ADDR:1397 BRAWLEY SCHOOL RD");

    doTest("T30",
        "FR110C-45 CHEST PAINS, 108 CHINOOK LN",
        "UNIT:FR110",
        "CALL:C-45 CHEST PAINS",
        "ADDR:108 CHINOOK LN");
 
  }
  
  @Test
  public void testMooresvilleRescueSquad() {

    doTest("T1",
        "FR03 C-49 DIABETIC COMA, 187 COMMODORE LOOP",
        "UNIT:FR03",
        "CALL:C-49 DIABETIC COMA",
        "ADDR:187 COMMODORE LOOP");

    doTest("T2",
        "FR03 C-86 RESPIRATORY DISTRESS, 414 ROCKY RIVER RD",
        "UNIT:FR03",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:414 ROCKY RIVER RD");

    doTest("T3",
        "FR03 C-50 UNCONSCIOUS, 191 MCKENDREE RD",
        "UNIT:FR03",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:191 MCKENDREE RD");

    doTest("T4",
        "MRS COUNTY  - EMS STANDBY, 204 E IREDELL AV",
        "UNIT:MRS",
        "CALL:COUNTY  - EMS STANDBY",
        "ADDR:204 E IREDELL AV",
        "MADDR:204 E IREDELL AVE");

    doTest("T5",
        "MRS C-80 CPR IN PROGRESS, 199 CORNELIUS RD",
        "UNIT:MRS",
        "CALL:C-80 CPR IN PROGRESS",
        "ADDR:199 CORNELIUS RD");

    doTest("T6",
        "FR03 FALL, 260 LAKESHORE DR",
        "UNIT:FR03",
        "CALL:FALL",
        "ADDR:260 LAKESHORE DR");

    doTest("T7",
        "FR03 C-45 CHEST PAINS, 167 WESTMORELAND RD",
        "UNIT:FR03",
        "CALL:C-45 CHEST PAINS",
        "ADDR:167 WESTMORELAND RD");

    doTest("T8",
        "MRS MUTAID - MUTUAL AID, 219 MCKENDREE RD",
        "UNIT:MRS",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:219 MCKENDREE RD");

    doTest("T9",
        "FR03 C-66 MAN DOWN, 2002 CHARLOTTE HWY",
        "UNIT:FR03",
        "CALL:C-66 MAN DOWN",
        "ADDR:2002 CHARLOTTE HWY");

    doTest("T10",
        "MRS C-90 HOUSE FIRE, 1500 TRIPLETT RD",
        "UNIT:MRS",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:1500 TRIPLETT RD");

    doTest("T11",
        "FR03 C-86 RESPIRATORY DISTRESS, 168 CROSSRAIL RD",
        "UNIT:FR03",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:168 CROSSRAIL RD");

    doTest("T12",
        "FR03 C-50 UNCONSCIOUS, 137 TUSKARORA POINT LN",
        "UNIT:FR03",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:137 TUSKARORA POINT LN");

    doTest("T13",
        "FR03 C-86 RESPIRATORY DISTRESS, 1297 SHEARERS RD",
        "UNIT:FR03",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:1297 SHEARERS RD");

    doTest("T14",
        "FR03 C-45 CHEST PAINS, 152 WOODRIDGE LN",
        "UNIT:FR03",
        "CALL:C-45 CHEST PAINS",
        "ADDR:152 WOODRIDGE LN");

    doTest("T15",
        "FR03 C-45 CHEST PAINS, 158 WESTMORELAND RD",
        "UNIT:FR03",
        "CALL:C-45 CHEST PAINS",
        "ADDR:158 WESTMORELAND RD");

    doTest("T16",
        "FR03 C-86 RESPIRATORY DISTRESS, 254 PARADISE PENINSULA RD",
        "UNIT:FR03",
        "CALL:C-86 RESPIRATORY DISTRESS",
        "ADDR:254 PARADISE PENINSULA RD");  // Google says this is Peninsula DR

    doTest("T17",
        "FR03 C-66 MAN DOWN, 109 WYNWARD LN",
        "UNIT:FR03",
        "CALL:C-66 MAN DOWN",
        "ADDR:109 WYNWARD LN");

    doTest("T18",
        "FR03 C-64 GUNSHOT WOUND, 159 WOODRIDGE LN",
        "UNIT:FR03",
        "CALL:C-64 GUNSHOT WOUND",
        "ADDR:159 WOODRIDGE LN");

    doTest("T19",
        "FR03 C-65 SEIZURES, ESQUIRE LN",
        "UNIT:FR03",
        "CALL:C-65 SEIZURES",
        "ADDR:ESQUIRE LN");

    doTest("T20",
        "FR03 MUTAID - MUTUAL AID, 154 LAKE PINE RD",
        "UNIT:FR03",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:154 LAKE PINE RD");

    doTest("T21",
        "MRS 10-50 Traffic Accident, 217 BEATEN PATH RD",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:217 BEATEN PATH RD");

    doTest("T22",
        "MRS COUNTY  - EMS STANDBY, 204 E IREDELL AV",
        "UNIT:MRS",
        "CALL:COUNTY  - EMS STANDBY",
        "ADDR:204 E IREDELL AV",
        "MADDR:204 E IREDELL AVE");

    doTest("T23",
        "MRS C-80 CPR IN PROGRESS, 199 CORNELIUS RD",
        "UNIT:MRS",
        "CALL:C-80 CPR IN PROGRESS",
        "ADDR:199 CORNELIUS RD");

    doTest("T24",
        "MRS MUTAID - MUTUAL AID, 219 MCKENDREE RD",
        "UNIT:MRS",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:219 MCKENDREE RD");

    doTest("T25",
        "MRS C-90 HOUSE FIRE, 1500 TRIPLETT RD",
        "UNIT:MRS",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:1500 TRIPLETT RD");

    doTest("T26",
        "MRS 10-50 Traffic Accident, BIG INDIAN AND BLUEFIELD",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:BIG INDIAN AND BLUEFIELD",
        "MADDR:BIG INDIAN & BLUEFIELD");

    doTest("T27",
        "MRS C-80 CPR IN PROGRESS, 1113 S  MAGNOLIA ST",
        "UNIT:MRS",
        "CALL:C-80 CPR IN PROGRESS",
        "ADDR:1113 S  MAGNOLIA ST");

    doTest("T28",
        "MRS 10-50 Traffic Accident, CORNELIUS RD AT BLUEFIELD RD",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:CORNELIUS RD AT BLUEFIELD RD");

    doTest("T29",
        "MRS C-90 HOUSE FIRE, 136 PETERBOROUGH DR",
        "UNIT:MRS",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:136 PETERBOROUGH DR");

    doTest("T30",
        "MRS 10-50 Traffic Accident, 2550 CHARLOTTE HWY",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:2550 CHARLOTTE HWY");

    doTest("T31",
        "MRS 10-50 Traffic Accident, 1812 BRAWLEY SCHOOL RD",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:1812 BRAWLEY SCHOOL RD");

    doTest("T32",
        "MRS 10-50 Traffic Accident, I 77 SB MM34",
        "UNIT:MRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:I 77 SB MM34",
        "MADDR:I 77 MM34");

    doTest("T33",
        "MRS C-90 HOUSE FIRE, GABRIEL DR",
        "UNIT:MRS",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:GABRIEL DR");
  
  }
  
  @Test
  public void testIredellCountyEMS() {

    doTest("T1",
        "ICRS MUTAID - MUTUAL AID, 119 IVANHOE LN",
        "UNIT:ICRS",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:119 IVANHOE LN");

    doTest("T2",
        "ICRS PUBLIC - SERVICE, 908 INGLEWOOD RD",
        "UNIT:ICRS",
        "CALL:PUBLIC - SERVICE",
        "ADDR:908 INGLEWOOD RD");

    doTest("T3",
        "FR01 C-66 MAN DOWN, 119 IVANHOE LN",
        "UNIT:FR01",
        "CALL:C-66 MAN DOWN",
        "ADDR:119 IVANHOE LN");

    doTest("T4",
        "ICRS 10-50 Traffic Accident, 1920 OLD MOUNTAIN RD",
        "UNIT:ICRS",
        "CALL:10-50 Traffic Accident",
        "ADDR:1920 OLD MOUNTAIN RD");

    doTest("T5",
        "FR01 C-65 SEIZURES, 1314 HARRIS ST",
        "UNIT:FR01",
        "CALL:C-65 SEIZURES",
        "ADDR:1314 HARRIS ST");

    doTest("T6",
        "FR01 C-49 DIABETIC COMA, 166 GYPSY DR",
        "UNIT:FR01",
        "CALL:C-49 DIABETIC COMA",
        "ADDR:166 GYPSY DR");

    doTest("T7",
        "FR01 C-45 CHEST PAINS, 207 HERITAGE RD",
        "UNIT:FR01",
        "CALL:C-45 CHEST PAINS",
        "ADDR:207 HERITAGE RD");

    doTest("T8",
        "FR01 C-83 HEMORRAGE, 1130 7TH ST",
        "UNIT:FR01",
        "CALL:C-83 HEMORRAGE",
        "ADDR:1130 7TH ST");

    doTest("T9",
        "FR01 C-55 HEAD INJURIES, 3439 TAYLORSVILLE HWY",
        "UNIT:FR01",
        "CALL:C-55 HEAD INJURIES",
        "ADDR:3439 TAYLORSVILLE HWY");

    doTest("T10",
        "FR01 C-55 HEAD INJURIES, 474 N CENTER ST",
        "UNIT:FR01",
        "CALL:C-55 HEAD INJURIES",
        "ADDR:474 N CENTER ST");
   
  }
  
  @Test
  public void testIredellCountyMobileAirResponseTeam() {

    doTest("T1",
        "FA10 C-90 HOUSE FIRE, E LACKEY FARM RD",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:E LACKEY FARM RD");

    doTest("T2",
        "FA10 C-90 HOUSE FIRE, 121 POST LN",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:121 POST LN");

    doTest("T3",
        "FA10 C-94 REQUEST AIR UNIT, MYERS MILL RD",
        "UNIT:FA10",
        "CALL:C-94 REQUEST AIR UNIT",
        "ADDR:MYERS MILL RD");

    doTest("T4",
        "FA10 C-94 REQUEST AIR UNIT, 2997 WILKESBORO HWY",
        "UNIT:FA10",
        "CALL:C-94 REQUEST AIR UNIT",
        "ADDR:2997 WILKESBORO HWY");

    doTest("T5",
        "FA10 C-90 BUILDING FIRE, 490 SWANN RD",
        "UNIT:FA10",
        "CALL:C-90 BUILDING FIRE",
        "ADDR:490 SWANN RD");

    doTest("T6",
        "FA10 C-94 REQUEST AIR UNIT, 2997 WILKESBORO HWY",
        "UNIT:FA10",
        "CALL:C-94 REQUEST AIR UNIT",
        "ADDR:2997 WILKESBORO HWY");

    doTest("T7",
        "FA10 C-90 HOUSE FIRE, 131 PAUL JR LN",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:131 PAUL JR LN");

    doTest("T8",
        "FA10 C-90 HOUSE FIRE, 107 UNION GROVE RD",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:107 UNION GROVE RD");

    doTest("T9",
        "FA10 C-90 HOUSE FIRE, 1715 YOUNGER AVE",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:1715 YOUNGER AVE");

    doTest("T10",
        "FA10 C-90 HOUSE FIRE, 1112 BROWN SUMMIT AVE",
        "UNIT:FA10",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:1112 BROWN SUMMIT AVE");
   
  }
  
  @Test
  public void testIredellCountyFireMarshal() {

    doTest("T1",
        "FM3600C-90 BUILDING FIRE, 237 FERN HILL RD",
        "UNIT:FM3600",
        "CALL:C-90 BUILDING FIRE",
        "ADDR:237 FERN HILL RD");

    doTest("T2",
        "FM3600C-90 BARN FIRE, 103 VAUGHN MILL RD",
        "UNIT:FM3600",
        "CALL:C-90 BARN FIRE",
        "ADDR:103 VAUGHN MILL RD");

    doTest("T3",
        "FM3600C-90 HOUSE FIRE, 123 CAPE COD WAY",
        "UNIT:FM3600",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:123 CAPE COD WAY");

    doTest("T4",
        "FM3600C-90 HOUSE FIRE, 1118 SHARON SCHOOL RD",
        "UNIT:FM3600",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:1118 SHARON SCHOOL RD");

    doTest("T5",
        "FM3600C-90 BUILDING FIRE, 187 BRUMLEY RD",
        "UNIT:FM3600",
        "CALL:C-90 BUILDING FIRE",
        "ADDR:187 BRUMLEY RD");

    doTest("T6",
        "FM3600C-90 HOUSE FIRE, E LACKEY FARM RD",
        "UNIT:FM3600",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:E LACKEY FARM RD");

    doTest("T7",
        "FM3600C-6 INVESTIGATION, 2022 OLD MOUNTAIN RD",
        "UNIT:FM3600",
        "CALL:C-6 INVESTIGATION",
        "ADDR:2022 OLD MOUNTAIN RD");

    doTest("T8",
        "FM3600C-90 HOUSE FIRE, 121 POST LN",
        "UNIT:FM3600",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:121 POST LN");

    doTest("T9",
        "FM3600C-90 HOUSE FIRE, 107 BLUE SKY CT",
        "UNIT:FM3600",
        "CALL:C-90 HOUSE FIRE",
        "ADDR:107 BLUE SKY CT");

    doTest("T10",
        "FM3600C-5 FIRE ALARM, 120 MEETING HOUSE CIR",
        "UNIT:FM3600",
        "CALL:C-5 FIRE ALARM",
        "ADDR:120 MEETING HOUSE CIR");

  }
  
  @Test
  public void testStatesvilleFire() {

    doTest("T1",
        "SFD 10-50 Traffic Accident, 150 E I-40 HWY, 13-00589",
        "UNIT:SFD",
        "CALL:10-50 Traffic Accident",
        "ADDR:150 E I-40 HWY",
        "MADDR:150 E I 40",
        "ID:13-00589");

    doTest("T2",
        "SFD HAZMAT - LEVEL 1 RESPONSE, 1357 5TH ST, 13-00588",
        "UNIT:SFD",
        "CALL:HAZMAT - LEVEL 1 RESPONSE",
        "ADDR:1357 5TH ST",
        "ID:13-00588");

    doTest("T3",
        "SFD C-5 FIRE ALARM, 230 N RACE ST, 13-00587",
        "UNIT:SFD",
        "CALL:C-5 FIRE ALARM",
        "ADDR:230 N RACE ST",
        "ID:13-00587");

    doTest("T4",
        "SFD C-50 UNCONSCIOUS, 517 HOLLAND DR, 13-00586",
        "UNIT:SFD",
        "CALL:C-50 UNCONSCIOUS",
        "ADDR:517 HOLLAND DR",
        "ID:13-00586");

    doTest("T5",
        "SFD MUTAID - MUTUAL AID, 714 WILMINGTON AVE, 13-00585",
        "UNIT:SFD",
        "CALL:MUTAID - MUTUAL AID",
        "ADDR:714 WILMINGTON AVE",
        "ID:13-00585");

    doTest("T6",
        "SFD PUBLIC - SERVICE, 521 SYLVIA ST, 13-00584",
        "UNIT:SFD",
        "CALL:PUBLIC - SERVICE",
        "ADDR:521 SYLVIA ST",
        "ID:13-00584");

    doTest("T7",
        "SFD C-5 FIRE ALARM, 743 SPRINGDALE RD, 13-00583",
        "UNIT:SFD",
        "CALL:C-5 FIRE ALARM",
        "ADDR:743 SPRINGDALE RD",
        "ID:13-00583");

    doTest("T8",
        "SFD C-90 OTHER FIRE, 519 BROOKDALE DR, 13-00582",
        "UNIT:SFD",
        "CALL:C-90 OTHER FIRE",
        "ADDR:519 BROOKDALE DR",
        "ID:13-00582");

    doTest("T9",
        "SFD PUBLIC - SERVICE, 2155 WEXFORD WAY, 13-00581",
        "UNIT:SFD",
        "CALL:PUBLIC - SERVICE",
        "ADDR:2155 WEXFORD WAY",
        "ID:13-00581");

    doTest("T10",
        "SFD C-5 FIRE ALARM, 1929 E BROAD ST, 13-00580",
        "UNIT:SFD",
        "CALL:C-5 FIRE ALARM",
        "ADDR:1929 E BROAD ST",
        "ID:13-00580");
   
  }
  
  public static void main(String[] args) {
    new NCIredellCountyParserTest().generateTests("T1");
  }
}
