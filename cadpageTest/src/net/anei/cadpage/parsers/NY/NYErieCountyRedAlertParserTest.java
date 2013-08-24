package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Erie County, NY (again)
Contact: afshar yusuf <afshar.yusuf@gmail.com>
Contact: Joe Gallagher <patchinfirefigher@gmail.com>
Sender: dispatch@townofhamburgny.com

*2EMS: 60/M LONG FALL POSSIBLE ARM AND LEG FRACTURE ILS RESPONSE at 3425 OLD LAKEVIEW RD, Hamburg  c/s: ENGEL DR . . 17:31:57\n\n-- \nThis message has bee
*2EMS: Male fell has a elbow laceration Cold Response at 25 BUFFALO ST #420, Village of Hamburg  c/s: MAIN ST   O: CREEK BEND HGTS APTS . . 05:16:00\n\n-
*2EMS: 23 male poss od uncx at 7219 LIEBLER RD, Boston  c/s: COLE RD . . 19:44:01\n\n-- \nThis message has been scanned for viruse
*2EMS: 51 female dyspnea paramedic response at 8169 BOSTON STATE RD, Boston  c/s: MAY DR   O: PEOPLE INC . . 21:26:12\n\n-- \nThis
*2Misc Electrical Problem: TELEPHONE POLE ON FIRE NEAR ROADWAY at 6674 LIEBLER RD, Boston  c/s: BOSTON STATE RD . . 07:50:52\n\n--
*2EMS: 79m weakness in right arm and leg poss stroke bls hot response no members on duty contact hfc at 6784 REDWING DR, Boston  c
*2EMS: 71 Y/F NOT ALERT  PARAMEDIC RESPONSE   NO MEMBERS ON DUTY  at 8799 ROCKWOOD RD, Boston  c/s: PA/BO LINE . . 13:54:46\n\n--
 
Contact: Matthew Whiting <firefighter015@gmail.com>
Sender: dispatch@townofhamburgny.com
*2Alarm Activation: General fire alarm at 7207 WARD RD, Boston  c/s: COLE RD . . 17:41:51
*2EMS: 15 MONTH CHILD - SEIZURES - BLS HOT at BOSTON STATE RD / WILDWOOD DR, Boston . . 14:57:05
*2Misc Rubbish/Brush, RUBBISH PROBLEM: LEAVES AND UNDERBRUSH ON FIRE IN WOODS WELL AWAY FROM HOUSE at 6754 OMPHALIUS RD, Boston  c/s: EDDY RD . . 13:47
*2EMS: 70F Uncon Medic at 6714 Hilcroft . . 00:39:43
*2EMS Auto Accident: AUTO ACCIDENT WITH INJURY POSS ROLL OVER 20 & 29 TO THE HALL at LOWER EAST HILL RD / WOHLHUETER RD, Boston . . 23:16:18
*2Alarm Activation: general fire alarm at evans nat bank at 7205 BOSTON STATE RD, Boston  c/s: ZIMMERMAN RD   O: EVANS NATIONAL BANK . . 16:11:51
*2EMS: 69 Years Male Chest pain- medic response at 7898 BOSTON STATE RD #40, Boston  c/s: WILDWOOD DR   O: BOSTON HILLS MOBILE HOME PARK . . 19:09:24
*2EMS: M/chest pains at 8112 COLE RD, Boston  c/s: OMPHALIUS RD . . 20:05:16
Vehicle Fire: vehicle fire in roadway at 8799 FEDDICK RD, Boston  c/s: PA/BO LINE . . 07:33:02

Contact: eric dahlgren <ercdahl@gmail.com>
Sender: dispatch@townofhamburgny.com
EMS: HA 8 RESP FOR A TRANSPORT.  NO FURTHER REPONSE NECESSARY. at 239 BROOKWOOD DR, Village of Hamburg  c/s: BIRKSHIRE RD . . 21:3\r

Contact: Jack Chiappone <jchiappone77@verizon.net>
Sender: dispatch@townofhamburgny.com
EMS: 54 Y/F FELL UNKNOWN INJURIES  COLD RESPONSE  SCRANTON 8 MUTUAL AID TO BIG TREE\n17A03  at 4365 BAYVIEW RD, Hamburg  c/s: POLLY LA   O: COMMUNITY S
EMS: 66 Years Male Conscious/Breathing\n17A01 Falls-arm injury BLS COLD  in vestibule Bldg H at 4150 SOWLES RD #H, Hamburg  c/s: CLARICE DR   O: IRIS 
Miscellaneous Alarm, INVESTIGATE ODOR: Odor of plastic burning at 5660 SOUTH PARK AV, Hamburg  c/s: ARTHUR CT   O: BRADFORD PLACE ENTERPRISES . . 19:07
Working  Fire: Residential fire - house filled with smoke. all residents evacuated.  at 8264 HAYES HOLLOW RD, Colden  c/s: IRISH RD . . 07:49:32
Working  Fire: ATTACHED GARAGE FIRE\n at AMSDELL RD / DEVONSHIRE DR, Hamburg . . 05:49:49
Misc Mutual Aid: 63m unable to ambulate cold response needs to go to VA at 25 BUFFALO ST #612, Village of Hamburg  c/s: MAIN ST   O: CREEK BEND HGTS AP
EMS Auto Accident: PIAA EXIT 57 ENT W BD  at 4418 NEW YORK STATE TW, Hamburg c/s: N CREEK RD (OVERPASS) . . 18:17:32
EMS: 81m ill weak unable to move 3rd party call bls hot at 5546 SCRANTON RD #York2, Hamburg  c/s: CAMP RD   O: WASHINGTON SQUARE APARTMENTS . . 11:35:4
Alarm Activation: fire alarm   2nd floor south rooms  at 5285 SOUTH PARK AV, Hamburg  c/s: SOWLES RD   O: COURTYARDS ADULT CARE FACILITY . . 23:34:22
EMS: 77 Years Female Conscious: allergic reaction not alert paramedic response at 5358 ADAMS ST, Hamburg  c/s: ELLSWORTH AV . . 15:30:52
Misc Mutual Aid: NA FAST SC6 TO RESPOND at 707 STERLING DR, Orchard Park c/s: WINDWARD RD   O: MENTHOLATUM CO . . 12:10:42
ALERT@ERIE.GOV EMS: m cardiac arrest at 3965 SOWLES RD, Hamburg  c/s: WINTERWAY LA . . 16:59:52?

*/

public class NYErieCountyRedAlertParserTest extends BaseParserTest {
  
  public NYErieCountyRedAlertParserTest() {
    setParser(new NYErieCountyRedAlertParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*2EMS: 60/M LONG FALL POSSIBLE ARM AND LEG FRACTURE ILS RESPONSE at 3425 OLD LAKEVIEW RD, Hamburg  c/s: ENGEL DR . . 17:31:57\n\n-- \nThis message has bee",
        "CALL:EMS",
        "INFO:60/M LONG FALL POSSIBLE ARM AND LEG FRACTURE ILS RESPONSE",
        "ADDR:3425 OLD LAKEVIEW RD",
        "CITY:Hamburg",
        "X:ENGEL DR",
        "TIME:17:31:57");

    doTest("T2",
        "*2EMS: Male fell has a elbow laceration Cold Response at 25 BUFFALO ST #420, Village of Hamburg  c/s: MAIN ST   O: CREEK BEND HGTS APTS . . 05:16:00\n\n-",
        "CALL:EMS",
        "INFO:Male fell has a elbow laceration Cold Response",
        "ADDR:25 BUFFALO ST",
        "APT:420",
        "CITY:Village of Hamburg",
        "X:MAIN ST",
        "PLACE:CREEK BEND HGTS APTS",
        "TIME:05:16:00");

    doTest("T3",
        "*2EMS: 23 male poss od uncx at 7219 LIEBLER RD, Boston  c/s: COLE RD . . 19:44:01\n\n-- \nThis message has been scanned for viruse",
        "CALL:EMS",
        "INFO:23 male poss od uncx",
        "ADDR:7219 LIEBLER RD",
        "CITY:Boston",
        "X:COLE RD",
        "TIME:19:44:01");

    doTest("T4",
        "*2EMS: 51 female dyspnea paramedic response at 8169 BOSTON STATE RD, Boston  c/s: MAY DR   O: PEOPLE INC . . 21:26:12\n\n-- \nThis",
        "CALL:EMS",
        "INFO:51 female dyspnea paramedic response",
        "ADDR:8169 BOSTON STATE RD",
        "CITY:Boston",
        "X:MAY DR",
        "PLACE:PEOPLE INC",
        "TIME:21:26:12");

    doTest("T5",
        "*2Misc Electrical Problem: TELEPHONE POLE ON FIRE NEAR ROADWAY at 6674 LIEBLER RD, Boston  c/s: BOSTON STATE RD . . 07:50:52\n\n--",
        "CALL:Misc Electrical Problem",
        "INFO:TELEPHONE POLE ON FIRE NEAR ROADWAY",
        "ADDR:6674 LIEBLER RD",
        "CITY:Boston",
        "X:BOSTON STATE RD",
        "TIME:07:50:52");

    doTest("T6",
        "*2EMS: 71 Y/F NOT ALERT  PARAMEDIC RESPONSE   NO MEMBERS ON DUTY  at 8799 ROCKWOOD RD, Boston  c/s: PA/BO LINE . . 13:54:46\n\n-- ",
        "CALL:EMS",
        "INFO:71 Y/F NOT ALERT PARAMEDIC RESPONSE NO MEMBERS ON DUTY",
        "ADDR:8799 ROCKWOOD RD",
        "CITY:Boston",
        "X:PA/BO LINE",
        "TIME:13:54:46");

    doTest("T7",
        "*2Alarm Activation: General fire alarm at 7207 WARD RD, Boston  c/s: COLE RD . . 17:41:51",
        "CALL:Alarm Activation",
        "INFO:General fire alarm",
        "ADDR:7207 WARD RD",
        "CITY:Boston",
        "X:COLE RD",
        "TIME:17:41:51");

    doTest("T8",
        "*2EMS: 15 MONTH CHILD - SEIZURES - BLS HOT at BOSTON STATE RD / WILDWOOD DR, Boston . . 14:57:05",
        "CALL:EMS",
        "INFO:15 MONTH CHILD - SEIZURES - BLS HOT",
        "ADDR:BOSTON STATE RD & WILDWOOD DR",
        "CITY:Boston",
        "TIME:14:57:05");

    doTest("T9",
        "*2Misc Rubbish/Brush, RUBBISH PROBLEM: LEAVES AND UNDERBRUSH ON FIRE IN WOODS WELL AWAY FROM HOUSE at 6754 OMPHALIUS RD, Boston  c/s: EDDY RD . . 13:47",
        "CALL:Misc Rubbish/Brush, RUBBISH PROBLEM",
        "INFO:LEAVES AND UNDERBRUSH ON FIRE IN WOODS WELL AWAY FROM HOUSE",
        "ADDR:6754 OMPHALIUS RD",
        "CITY:Boston",
        "X:EDDY RD",
        "TIME:13:47");

    doTest("T10",
        "*2EMS: 70F Uncon Medic at 6714 Hilcroft . . 00:39:43",
        "CALL:EMS",
        "INFO:70F Uncon Medic",
        "ADDR:6714 Hilcroft",
        "TIME:00:39:43");

    doTest("T11",
        "*2EMS Auto Accident: AUTO ACCIDENT WITH INJURY POSS ROLL OVER 20 & 29 TO THE HALL at LOWER EAST HILL RD / WOHLHUETER RD, Boston . . 23:16:18",
        "CALL:EMS Auto Accident",
        "INFO:AUTO ACCIDENT WITH INJURY POSS ROLL OVER 20 & 29 TO THE HALL",
        "ADDR:LOWER EAST HILL RD & WOHLHUETER RD",
        "CITY:Boston",
        "TIME:23:16:18");

    doTest("T12",
        "*2Alarm Activation: general fire alarm at evans nat bank at 7205 BOSTON STATE RD, Boston  c/s: ZIMMERMAN RD   O: EVANS NATIONAL BANK . . 16:11:51",
        "CALL:Alarm Activation",
        "INFO:general fire alarm at evans nat bank",
        "ADDR:7205 BOSTON STATE RD",
        "CITY:Boston",
        "X:ZIMMERMAN RD",
        "PLACE:EVANS NATIONAL BANK",
        "TIME:16:11:51");

    doTest("T13",
        "*2EMS: 69 Years Male Chest pain- medic response at 7898 BOSTON STATE RD #40, Boston  c/s: WILDWOOD DR   O: BOSTON HILLS MOBILE HOME PARK . . 19:09:24",
        "CALL:EMS",
        "INFO:69 Years Male Chest pain- medic response",
        "ADDR:7898 BOSTON STATE RD",
        "APT:40",
        "CITY:Boston",
        "X:WILDWOOD DR",
        "PLACE:BOSTON HILLS MOBILE HOME PARK",
        "TIME:19:09:24");

    doTest("T14",
        "*2EMS: M/chest pains at 8112 COLE RD, Boston  c/s: OMPHALIUS RD . . 20:05:16",
        "CALL:EMS",
        "INFO:M/chest pains",
        "ADDR:8112 COLE RD",
        "CITY:Boston",
        "X:OMPHALIUS RD",
        "TIME:20:05:16");

    doTest("T15",
        "Vehicle Fire: vehicle fire in roadway at 8799 FEDDICK RD, Boston  c/s: PA/BO LINE . . 07:33:02",
        "CALL:Vehicle Fire",
        "INFO:vehicle fire in roadway",
        "ADDR:8799 FEDDICK RD",
        "CITY:Boston",
        "X:PA/BO LINE",
        "TIME:07:33:02");
  }
  
  @Test
  public void testEricDalghen() {

    doTest("T1",
        "EMS: HA 8 RESP FOR A TRANSPORT.  NO FURTHER REPONSE NECESSARY. at 239 BROOKWOOD DR, Village of Hamburg  c/s: BIRKSHIRE RD . . 21:3\r",
        "CALL:EMS",
        "INFO:HA 8 RESP FOR A TRANSPORT. NO FURTHER REPONSE NECESSARY.",
        "ADDR:239 BROOKWOOD DR",
        "CITY:Village of Hamburg",
        "X:BIRKSHIRE RD");

  }
  
  @Test
  public void testJackChiappone() {

    doTest("T1",
        "EMS: 54 Y/F FELL UNKNOWN INJURIES  COLD RESPONSE  SCRANTON 8 MUTUAL AID TO BIG TREE\n" +
        "17A03  at 4365 BAYVIEW RD, Hamburg  c/s: POLLY LA   O: COMMUNITY S",

        "CALL:EMS",
        "INFO:54 Y/F FELL UNKNOWN INJURIES COLD RESPONSE SCRANTON 8 MUTUAL AID TO BIG TREE",
        "CODE:17A03",
        "ADDR:4365 BAYVIEW RD",
        "CITY:Hamburg",
        "X:POLLY LA",
        "PLACE:COMMUNITY S");

    doTest("T2",
        "EMS: 66 Years Male Conscious/Breathing\n" +
        "17A01 Falls-arm injury BLS COLD  in vestibule Bldg H at 4150 SOWLES RD #H, Hamburg  c/s: CLARICE DR   O: IRIS ",

        "CALL:EMS",
        "INFO:66 Years Male Conscious/Breathing Falls-arm injury BLS COLD in vestibule Bldg H",
        "CODE:17A01",
        "ADDR:4150 SOWLES RD",
        "APT:H",
        "CITY:Hamburg",
        "X:CLARICE DR",
        "PLACE:IRIS");

    doTest("T3",
        "Miscellaneous Alarm, INVESTIGATE ODOR: Odor of plastic burning at 5660 SOUTH PARK AV, Hamburg  c/s: ARTHUR CT   O: BRADFORD PLACE ENTERPRISES . . 19:07",
        "CALL:Miscellaneous Alarm, INVESTIGATE ODOR",
        "INFO:Odor of plastic burning",
        "ADDR:5660 SOUTH PARK AV",
        "MADDR:5660 SOUTH PARK AVE",
        "CITY:Hamburg",
        "X:ARTHUR CT",
        "PLACE:BRADFORD PLACE ENTERPRISES",
        "TIME:19:07");

    doTest("T4",
        "Working  Fire: Residential fire - house filled with smoke. all residents evacuated.  at 8264 HAYES HOLLOW RD, Colden  c/s: IRISH RD . . 07:49:32",
        "CALL:Working Fire",
        "INFO:Residential fire - house filled with smoke. all residents evacuated.",
        "ADDR:8264 HAYES HOLLOW RD",
        "CITY:Colden",
        "X:IRISH RD",
        "TIME:07:49:32");

    doTest("T5",
        "Working  Fire: ATTACHED GARAGE FIRE\n at AMSDELL RD / DEVONSHIRE DR, Hamburg . . 05:49:49",
        "CALL:Working Fire",
        "INFO:ATTACHED GARAGE FIRE",
        "ADDR:AMSDELL RD & DEVONSHIRE DR",
        "CITY:Hamburg",
        "TIME:05:49:49");

    doTest("T6",
        "Misc Mutual Aid: 63m unable to ambulate cold response needs to go to VA at 25 BUFFALO ST #612, Village of Hamburg  c/s: MAIN ST   O: CREEK BEND HGTS AP",
        "CALL:Misc Mutual Aid",
        "INFO:63m unable to ambulate cold response needs to go to VA",
        "ADDR:25 BUFFALO ST",
        "APT:612",
        "CITY:Village of Hamburg",
        "X:MAIN ST",
        "PLACE:CREEK BEND HGTS AP");

    doTest("T7",
        "EMS Auto Accident: PIAA EXIT 57 ENT W BD  at 4418 NEW YORK STATE TW, Hamburg c/s: N CREEK RD (OVERPASS) . . 18:17:32",
        "CALL:EMS Auto Accident",
        "INFO:PIAA EXIT 57 ENT W BD",
        "ADDR:4418 NEW YORK STATE TW",
        "MADDR:4418 NEW YORK STATE THRUWAY",
        "CITY:Hamburg",
        "X:N CREEK RD (OVERPASS)",
        "TIME:18:17:32");

    doTest("T8",
        "EMS: 81m ill weak unable to move 3rd party call bls hot at 5546 SCRANTON RD #York2, Hamburg  c/s: CAMP RD   O: WASHINGTON SQUARE APARTMENTS . . 11:35:4",
        "CALL:EMS",
        "INFO:81m ill weak unable to move 3rd party call bls hot",
        "ADDR:5546 SCRANTON RD",
        "APT:York2",
        "CITY:Hamburg",
        "X:CAMP RD",
        "PLACE:WASHINGTON SQUARE APARTMENTS",
        "TIME:11:35");

    doTest("T9",
        "Alarm Activation: fire alarm   2nd floor south rooms  at 5285 SOUTH PARK AV, Hamburg  c/s: SOWLES RD   O: COURTYARDS ADULT CARE FACILITY . . 23:34:22",
        "CALL:Alarm Activation",
        "INFO:fire alarm 2nd floor south rooms",
        "ADDR:5285 SOUTH PARK AV",
        "MADDR:5285 SOUTH PARK AVE",
        "CITY:Hamburg",
        "X:SOWLES RD",
        "PLACE:COURTYARDS ADULT CARE FACILITY",
        "TIME:23:34:22");

    doTest("T10",
        "EMS: 77 Years Female Conscious: allergic reaction not alert paramedic response at 5358 ADAMS ST, Hamburg  c/s: ELLSWORTH AV . . 15:30:52",
        "CALL:EMS",
        "INFO:77 Years Female Conscious: allergic reaction not alert paramedic response",
        "ADDR:5358 ADAMS ST",
        "CITY:Hamburg",
        "X:ELLSWORTH AV",
        "TIME:15:30:52");

    doTest("T11",
        "Misc Mutual Aid: NA FAST SC6 TO RESPOND at 707 STERLING DR, Orchard Park c/s: WINDWARD RD   O: MENTHOLATUM CO . . 12:10:42",
        "CALL:Misc Mutual Aid",
        "INFO:NA FAST SC6 TO RESPOND",
        "ADDR:707 STERLING DR",
        "CITY:Orchard Park",
        "X:WINDWARD RD",
        "PLACE:MENTHOLATUM CO",
        "TIME:12:10:42");

    doTest("T12",
        "ALERT@ERIE.GOV EMS: m cardiac arrest at 3965 SOWLES RD, Hamburg  c/s: WINTERWAY LA . . 16:59:52?",
        "CALL:EMS",
        "INFO:m cardiac arrest",
        "ADDR:3965 SOWLES RD",
        "CITY:Hamburg",
        "X:WINTERWAY LA . . 16:59:52?");

  }
  
  public static void main(String[] args) {
    new NYErieCountyRedAlertParserTest().generateTests("T1");
  }

}