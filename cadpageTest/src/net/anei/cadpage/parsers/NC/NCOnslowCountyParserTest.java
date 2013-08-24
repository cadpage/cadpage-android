package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Onslow County, NC
Contact: Kim Cytryszewski <kimcytryszewski@gmail.com>,2526220424@messaging.sprintpcs.com
Sender: CAD@onslowcountync.gov

CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C\r
CAD:141 SHADY ST;STRUCTURE FIRE;PGFD;11B
CAD:417 LITTLE CREEK CT;ELECTRICAL HAZARD;WOFD;20D
CAD:1061 RIGGS RD/SMITH RD;DIST: 16.79 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20B
CAD:1612 RIGGS RD;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C
CAD:485 OLD 30 RD;MORTON ELEMENTARY;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20D
CAD:227 MIDDLE RIDGE DR;ALARMS;HFD;8D
CAD:100 BELGRADE SWANSBORO RD/FREEDOM WAY;DIST: 235.62 FT;STRUCTURE FIRE;SFD;17A
CAD:1000 YORKTOWN LN;LIBERTY POINTE APARTMENTS;STRUCTURE FIRE;PGFD;11B

Contact: Shane Jacobs <coastalcutz@gmail.com>
Sender: CAD@onslowcountync.gov
FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;UNIT 1107;17;FALL;17A03G
FRM:CAD@onslowcountync.gov\nMSG:CAD:9018 9TH ST;10;CHEST PAIN;10D04
FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;1107;17;FALL;17A01
FRM:CAD@onslowcountync.gov\nMSG:CAD:2075 HWY 172;COASTAL DREDGING;VEHICLE FIRE;SFFD;15A

Contact: Kenneth Lachman <kenman70@gmail.com>
Sender: CAD@onslowcountync.gov
CAD:649 OLD FOLKSTONE RD;21;HEMORRHAGE
CAD:1401 QUARTERS LANDING CIR;APT 409;9;CARDIAC ARREST DEATH;09B01a
CAD:DEATH/INJURY;167 CREEK LANDING RD;HR;DIST: 147.78 ft;NEED AIR QUALITY REF TO PROPANE SMELL IN THE RESIDENCE. 272 ADVISED THEY SHUT THE TANK OFF. [01/17/1
CAD:136 SWAN POINT RD;26;SICK PERSON;26D01
CAD:327 CAMP GROUND DR;LOT G7;FULCHERS LANDING CAMPGROUND;10;CHEST PAIN;10C04
CAD:156 ORVIN DR;LOT 10;COUNTRY HAVEN ESTATES;6;BREATHING PROBLEMS;06D02
CAD:102 CORAL COVE;2;ALLERGIES/ENVENOMATIONS;02C01
CAD:1122 HWY 210;SEAWARD INN;12;CONVULSIONS/SEIZURES;12D02E
CAD:113 BRADSHAW RD;5;SILVER SANDS MHP;6;BREATHING PROBLEMS;06D02A
CAD:218 CLAY HILL RD;6;BREATHING PROBLEMS;06C01A

Contact: Active911
Agency name: Richlands Rescue
Location: Richlands, NC, United States
Sender: CAD@onslowcountync.gov

CAD:103 WILLIAMS ST EX;DIST: 123.52 ft;10;CHEST PAIN;10C01\r\n
CAD:ASSIST OTHER JURISD 7600;179 OLD FOUNTAIN RD;RICH;DIST: 67.36 ft;Event spawned from STRUCTURE FIRE. [11/06/2012 15:37:17 AB6003] (STA14) COPIES [11/06/12 15:36:18 AB6003] Aborted by Fire Priority with code: 1. Caller hung up [11/06/12 1\r\n
CAD:179 OLD FOUNTAIN RD;DIST: 67.36 ft;STRUCTURE FIRE;BSFD;1B\r\n
CAD:5431 RICHLANDS HWY;10;CHEST PAIN;10D04\r\n
FRM:CAD@onslowcountync.gov\r\nMSG:CAD:133 BILLY HUDSON RD;26;SICK PERSON;26D01\r\n

*/

public class NCOnslowCountyParserTest extends BaseParserTest {
  
  public NCOnslowCountyParserTest() {
    setParser(new NCOnslowCountyParser(), "ONSLOW COUNTY", "NC");
  }
  
  @Test
  public void testKimCytryszewski() {

    doTest("T1",
        "CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C\r",
        "ADDR:100 VANCE LN & RIGGS RD",
        "MADDR:100 VANCE LN",   // Not mapping - Problem reported
        "PLACE:DIST: 158.12 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T2",
        "CAD:141 SHADY ST;STRUCTURE FIRE;PGFD;11B",
        "ADDR:141 SHADY ST",
        "CALL:STRUCTURE FIRE",
        "SRC:PGFD",
        "UNIT:11B");

    doTest("T3",
        "CAD:417 LITTLE CREEK CT;ELECTRICAL HAZARD;WOFD;20D",
        "ADDR:417 LITTLE CREEK CT",
        "CALL:ELECTRICAL HAZARD",
        "SRC:WOFD",
        "UNIT:20D");

    doTest("T4",
        "CAD:1061 RIGGS RD/SMITH RD;DIST: 16.79 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20B",
        "ADDR:1061 RIGGS RD & SMITH RD",
        "MADDR:1061 RIGGS RD",
        "PLACE:DIST: 16.79 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20B");

    doTest("T5",
        "CAD:1612 RIGGS RD;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C",
        "ADDR:1612 RIGGS RD",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T6",
        "CAD:100 VANCE LN/RIGGS RD;DIST: 158.12 FT;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20C",
        "ADDR:100 VANCE LN & RIGGS RD",
        "MADDR:100 VANCE LN",
        "PLACE:DIST: 158.12 FT",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20C");

    doTest("T7",
        "CAD:485 OLD 30 RD;MORTON ELEMENTARY;TRAFFIC TRANSPORTATION ACCIDT;WOFD;20D",
        "ADDR:485 OLD 30 RD",
        "PLACE:MORTON ELEMENTARY",
        "CALL:TRAFFIC TRANSPORTATION ACCIDT",
        "SRC:WOFD",
        "UNIT:20D");

    doTest("T8",
        "CAD:227 MIDDLE RIDGE DR;ALARMS;HFD;8D",
        "ADDR:227 MIDDLE RIDGE DR",
        "CALL:ALARMS",
        "SRC:HFD",
        "UNIT:8D");

    doTest("T9",
        "CAD:100 BELGRADE SWANSBORO RD/FREEDOM WAY;DIST: 235.62 FT;STRUCTURE FIRE;SFD;17A",
        "ADDR:100 BELGRADE SWANSBORO RD & FREEDOM WAY",
        "MADDR:100 BELGRADE SWANSBORO RD",
        "PLACE:DIST: 235.62 FT",
        "CALL:STRUCTURE FIRE",
        "SRC:SFD",
        "UNIT:17A");

    doTest("T10",
        "CAD:1000 YORKTOWN LN;LIBERTY POINTE APARTMENTS;STRUCTURE FIRE;PGFD;11B",
        "ADDR:1000 YORKTOWN LN",  // Piney Green Rd??
        "PLACE:LIBERTY POINTE APARTMENTS",
        "CALL:STRUCTURE FIRE",
        "SRC:PGFD",
        "UNIT:11B");
  }
  
  @Test
  public void testShaneJacobs() {

    doTest("T1",
        "FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;UNIT 1107;17;FALL;17A03G",
        "ADDR:1822 NEW RIVER INLET RD",
        "APT:1107",
        "UNIT:17",
        "CALL:FALL",
        "CODE:17A03G");

    doTest("T2",
        "FRM:CAD@onslowcountync.gov\nMSG:CAD:9018 9TH ST;10;CHEST PAIN;10D04",
        "ADDR:9018 9TH ST",
        "UNIT:10",
        "CALL:CHEST PAIN",
        "CODE:10D04");

    doTest("T3",
        "FRM:CAD@onslowcountync.gov\nMSG:CAD:1822 NEW RIVER INLET RD;1107;17;FALL;17A01",
        "ADDR:1822 NEW RIVER INLET RD",
        "APT:1107",
        "UNIT:17",
        "CALL:FALL",
        "CODE:17A01");

    doTest("T4",
        "FRM:CAD@onslowcountync.gov\nMSG:CAD:2075 HWY 172;COASTAL DREDGING;VEHICLE FIRE;SFFD;15A",
        "ADDR:2075 HWY 172",
        "UNIT:15A",
        "CALL:VEHICLE FIRE",
        "PLACE:COASTAL DREDGING",
        "SRC:SFFD");

  }
  
  @Test
  public void testKennethLachman() {

    doTest("T1",
        "CAD:649 OLD FOLKSTONE RD;21;HEMORRHAGE",
        "ADDR:649 OLD FOLKSTONE RD",
        "UNIT:21",
        "CALL:HEMORRHAGE");

    doTest("T2",
        "CAD:1401 QUARTERS LANDING CIR;APT 409;9;CARDIAC ARREST DEATH;09B01a",
        "ADDR:1401 QUARTERS LANDING CIR", // Not mapping
        "APT:409",
        "UNIT:9",
        "CALL:CARDIAC ARREST DEATH",
        "CODE:09B01a");

// ************************ PARSE FAILURE *****************************
// CAD:DEATH/INJURY;167 CREEK LANDING RD;HR;DIST: 147.78 ft;NEED AIR QUALITY REF TO PROPANE SMELL IN THE RESIDENCE. 272 ADVISED THEY SHUT THE TANK OFF. [01/17/1

    doTest("T4",
        "CAD:136 SWAN POINT RD;26;SICK PERSON;26D01",
        "ADDR:136 SWAN POINT RD",
        "UNIT:26",
        "CALL:SICK PERSON",
        "CODE:26D01");

    doTest("T5",
        "CAD:327 CAMP GROUND DR;LOT G7;FULCHERS LANDING CAMPGROUND;10;CHEST PAIN;10C04",
        "ADDR:327 CAMP GROUND DR",
        "APT:G7",
        "PLACE:FULCHERS LANDING CAMPGROUND",
        "UNIT:10",
        "CALL:CHEST PAIN",
        "CODE:10C04");

    doTest("T6",
        "CAD:156 ORVIN DR;LOT 10;COUNTRY HAVEN ESTATES;6;BREATHING PROBLEMS;06D02",
        "ADDR:156 ORVIN DR",
        "APT:10",
        "PLACE:COUNTRY HAVEN ESTATES",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS",
        "CODE:06D02");

    doTest("T7",
        "CAD:102 CORAL COVE;2;ALLERGIES/ENVENOMATIONS;02C01",
        "ADDR:102 CORAL COVE",
        "UNIT:2",
        "CALL:ALLERGIES/ENVENOMATIONS",
        "CODE:02C01");

    doTest("T8",
        "CAD:1122 HWY 210;SEAWARD INN;12;CONVULSIONS/SEIZURES;12D02E",
        "ADDR:1122 HWY 210",
        "PLACE:SEAWARD INN",
        "UNIT:12",
        "CALL:CONVULSIONS/SEIZURES",
        "CODE:12D02E");

    doTest("T9",
        "CAD:113 BRADSHAW RD;5;SILVER SANDS MHP;6;BREATHING PROBLEMS;06D02A",
        "ADDR:113 BRADSHAW RD",
        "APT:5",
        "PLACE:SILVER SANDS MHP",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS",
        "CODE:06D02A");

    doTest("T10",
        "CAD:218 CLAY HILL RD;6;BREATHING PROBLEMS;06C01A",
        "ADDR:218 CLAY HILL RD",
        "UNIT:6",
        "CALL:BREATHING PROBLEMS",
        "CODE:06C01A");
 
  }
  
  @Test
  public void testRichlandRescue() {

    doTest("T1",
        "CAD:103 WILLIAMS ST EX;DIST: 123.52 ft;10;CHEST PAIN;10C01\r\n",
        "ADDR:103 WILLIAMS ST EX",
        "MADDR:103 WILLIAMS ST",
        "PLACE:DIST: 123.52 ft",
        "UNIT:10",
        "CALL:CHEST PAIN",
        "CODE:10C01");

    doTest("T2",
        "CAD:ASSIST OTHER JURISD 7600;179 OLD FOUNTAIN RD;RICH;DIST: 67.36 ft;Event spawned from STRUCTURE FIRE. [11/06/2012 15:37:17 AB6003] (STA14) COPIES [11/06/12 15:36:18 AB6003] Aborted by Fire Priority with code: 1. Caller hung up [11/06/12 1\r\n",
        "ADDR:179 OLD FOUNTAIN RD",
        "CITY:RICHLANDS",
        "INFO:Event spawned from STRUCTURE FIRE. / (STA14) COPIES / Aborted by Fire Priority with code: 1. Caller hung up",
        "PLACE:DIST: 67.36 ft",
        "CALL:ASSIST OTHER JURISD 7600",
        "DATE:11/06/2012",
        "TIME:15:37:17");

    doTest("T3",
        "CAD:179 OLD FOUNTAIN RD;DIST: 67.36 ft;STRUCTURE FIRE;BSFD;1B\r\n",
        "ADDR:179 OLD FOUNTAIN RD",
        "PLACE:DIST: 67.36 ft",
        "UNIT:1B",
        "CALL:STRUCTURE FIRE",
        "SRC:BSFD");

    doTest("T4",
        "CAD:5431 RICHLANDS HWY;10;CHEST PAIN;10D04\r\n",
        "ADDR:5431 RICHLANDS HWY",
        "UNIT:10",
        "CALL:CHEST PAIN",
        "CODE:10D04");

    doTest("T5",
        "FRM:CAD@onslowcountync.gov\r\nMSG:CAD:133 BILLY HUDSON RD;26;SICK PERSON;26D01\r\n",
        "ADDR:133 BILLY HUDSON RD",
        "UNIT:26",
        "CALL:SICK PERSON",
        "CODE:26D01");

  }
  

  public static void main(String[] args) {
    new NCOnslowCountyParserTest().generateTests("T1");
  }
}
