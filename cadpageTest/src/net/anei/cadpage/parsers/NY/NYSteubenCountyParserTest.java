package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYSteubenCountyParserTest extends BaseParserTest {
  
  public NYSteubenCountyParserTest() {
    setParser(new NYSteubenCountyParser(), "STEUBEN COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "messaging@iamresponding.com (Avoca FD) 64 S MAIN ST #APT OFFICE, AVOCA VILLAGE OF (STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME)6D4 Breathing Problems Clammy\nAVOCAFDA",
        "SRC:Avoca FD",
        "ADDR:64 S MAIN ST #",
        "APT:OFFICE",
        "CITY:AVOCA",
        "X:STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME",
        "CODE:6D4",
        "CALL:Breathing Problems Clammy");

    doTest("T2",
        "messaging@iamresponding.com (Avoca FD) 4434 COUNTY ROUTE 6 , AVOCA TOWN OF (STATE ROUTE 415 / COUNTY ROUTE 70) 17B3 Falls Unknown status\nAVOCAFDAMB:2011:98",
        "SRC:Avoca FD",
        "ADDR:4434 COUNTY ROAD 6",
        "CITY:AVOCA",
        "X:STATE ROUTE 415 / COUNTY ROAD 70",
        "CODE:17B3",
        "CALL:Falls Unknown status");

    doTest("T3",
        "messaging@iamresponding.com (Avoca FD) 9439 SPAULDING RD , WHEELER TOWN OF ( / COUNTY ROUTE 7)WIRES EMERG\nAVOCFD:2011:51",
        "SRC:Avoca FD",
        "ADDR:9439 SPAULDING RD",
        "CITY:WHEELER",
        "X:COUNTY ROAD 7",
        "CALL:WIRES EMERG");

    doTest("T4",
        "messaging@iamresponding.com (Avoca FD) 8806 COUNTY ROUTE 105 , AVOCA TOWN OF ( / N MAIN ST) 9E1 Cardiac or Respiratory Arrest not breathing at all\nAVOCAFDAMB:2011:99",
        "SRC:Avoca FD",
        "ADDR:8806 COUNTY ROAD 105",
        "CITY:AVOCA",
        "X:N MAIN ST",
        "CODE:9E1",
        "CALL:ALERT",
        "INFO:Cardiac or Respiratory Arrest not breathing at all");

    doTest("T5",
        "messaging@iamresponding.com (Avoca FD) 7 CHARLESWORTH AV , AVOCA VILLAGE OF (EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS) 17B1 Falls Possibly dangerous body area\nAVOCAFDAMB",
        "SRC:Avoca FD",
        "ADDR:7 CHARLESWORTH AV",
        "CITY:AVOCA",
        "X:EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS",
        "CODE:17B1",
        "CALL:Falls Possibly dangerous body area");

    doTest("T6",
        "messaging@iamresponding.com (Avoca FD) 4652 COUNTY ROUTE 70A , AVOCA TOWN OF (COUNTY ROUTE 69 / ) 26A1 Sick Person No priority symptoms (complaint conditions 2-11 not identified)\nA",
        "SRC:Avoca FD",
        "ADDR:4652 COUNTY ROAD 70A",
        "CITY:AVOCA",
        "X:COUNTY ROAD 69",
        "CODE:26A1",
        "CALL:ALERT",
        "INFO:Sick Person No priority symptoms (complaint conditions 2-11 not identified)");

    doTest("T7",
        "messaging@iamresponding.com (Avoca FD) 7 CHARLESWORTH AV , AVOCA VILLAGE OF (EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS) 17B1 Falls Possibly dangerous body area\nAVOCAFDAMB",
        "SRC:Avoca FD",
        "ADDR:7 CHARLESWORTH AV",
        "CITY:AVOCA",
        "X:EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS",
        "CODE:17B1",
        "CALL:Falls Possibly dangerous body area");

    doTest("T8",
        "messaging@iamresponding.com (Avoca FD) 8012 SMITH POND RD , HOWARD TOWN OF (WESSELS HILL RD / BURDIN HILL RD) 12B1 Convulsions Effective Breathing not verified &lt;35\nAVOCAFDAMB:20",
        "SRC:Avoca FD",
        "ADDR:8012 SMITH POND RD",
        "CITY:HOWARD",
        "X:WESSELS HILL RD / BURDIN HILL RD",
        "CODE:12B1",
        "CALL:ALERT",
        "INFO:Convulsions Effective Breathing not verified <35");

    doTest("T9",
        "messaging@iamresponding.com (Avoca FD) 118 E STEUBEN ST , BATH VILLAGE OF (HALSEY ST / GANSEVOORT ST; Near: PRO ACTION) 32B3 Unknown Problem Unknown Status/Other Codes Not Applicab",
        "SRC:Avoca FD",
        "ADDR:118 E STEUBEN ST",
        "CITY:BATH",
        "X:HALSEY ST / GANSEVOORT ST; Near: PRO ACTION",
        "CODE:32B3",
        "CALL:ALERT",
        "INFO:Unknown Problem Unknown Status/Other Codes Not Applicab");

    doTest("T10",
        "messaging@iamresponding.com (Avoca FD) ::::RECALLED:::::: 118 E STEUBEN ST , BATH VILLAGE OF (HALSEY ST / GANSEVOORT ST; Near: PRO ACTION) 32B3 Unknown Problem Unknown Status/Other",
        "SRC:Avoca FD",
        "ADDR:118 E STEUBEN ST",
        "CITY:BATH",
        "X:HALSEY ST / GANSEVOORT ST; Near: PRO ACTION",
        "CODE:32B3",
        "CALL:RECALLED - Unknown Problem Unknown Status/Other");

    doTest("T11",
        "messaging@iamresponding.com (Avoca FD) 4230 SHARPS CORNERS RD , HOWARD TOWN OF 21A2 Hemorrhage/Lacerations minor hemorrhage\nAVOCAFDAMB:2011:105",
        "SRC:Avoca FD",
        "ADDR:4230 SHARPS CORNERS RD",
        "CITY:HOWARD",
        "CODE:21A2",
        "CALL:Hemorrhage/Lacerations minor hemorrhage");

    doTest("T12",
        "messaging@iamresponding.com (Avoca FD) 64 S MAIN ST , AVOCA VILLAGE OF (STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME) 17B1 Falls Possibly dangerous body area\nAVOCAFD",
        "SRC:Avoca FD",
        "ADDR:64 S MAIN ST",
        "CITY:AVOCA",
        "X:STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME",
        "CODE:17B1",
        "CALL:Falls Possibly dangerous body area");

    doTest("T13",
        "messaging@iamresponding.com (Avoca FD) /ARROW MART GAS STATION (S 99 MAIN ST AVOCA VILLAGE OF ) 10A1 Chest Pain Breathing normaly &lt; 35\nAVOCAFDAMB:2011:107",
        "SRC:Avoca FD",
        "PLACE:ARROW MART GAS STATION",
        "ADDR:S 99 MAIN ST",
        "CITY:AVOCA",
        "CODE:10A1",
        "CALL:ALERT",
        "CALL:Chest Pain Breathing normaly < 35");

    doTest("T14",
        "messaging@iamresponding.com (Avoca FD) 5172 LOUCKS POND RD , AVOCA TOWN OF (OLD AVOCA RD / DYER HILL RD) 10C1 Chest Pain Abnormal breathing\nAVOCAFDAMB:2011:108",
        "SRC:Avoca FD",
        "ADDR:5172 LOUCKS POND RD",
        "CITY:AVOCA",
        "X:OLD AVOCA RD / DYER HILL RD",
        "CODE:10C1",
        "CALL:Chest Pain Abnormal breathing");

    doTest("T15",
        "messaging@iamresponding.com (Avoca FD) 54 GRANT ST , AVOCA VILLAGE OF ( / SMITH ST) 21A1 Hemorrhage/Lacerations not dangerous hemorrhage\nAVOCAFDAMB:2011:109",
        "SRC:Avoca FD",
        "ADDR:54 GRANT ST",
        "CITY:AVOCA",
        "X:SMITH ST",
        "CODE:21A1",
        "CALL:ALERT",
        "INFO:Hemorrhage/Lacerations not dangerous hemorrhage");

    doTest("T16",
        "messaging@iamresponding.com (Avoca FD) WEEKLY PAGER TEST TEST\nAVOCFD:2011:52",
        "SRC:Avoca FD",
        "CALL:WEEKLY PAGER TEST TEST");

    doTest("T17",
        "messaging@iamresponding.com (Avoca FD) 60617 STATE ROUTE 415 , AVOCA TOWN OF Misc FIRE\nAVOCFD:2011:53",
        "SRC:Avoca FD",
        "ADDR:60617 STATE ROUTE 415",
        "CITY:AVOCA",
        "CALL:Misc FIRE");

    doTest("T18",
        "messaging@iamresponding.com (Avoca FD) 64 S MAIN ST , AVOCA VILLAGE OF (STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME) 17A2 Falls non-recent &gt; 6 hrs (without prior",
        "SRC:Avoca FD",
        "ADDR:64 S MAIN ST",
        "CITY:AVOCA",
        "X:STATE ROUTE 415 / CARRINGTON ST; Near: COHOCTON VALLEY HOME",
        "CODE:17A2",
        "CALL:Falls non-recent > 6 hrs (without prior");

    doTest("T19",
        "messaging@iamresponding.com (Avoca FD) 5572 MICHIGAN HOLLOW RD , WHEELER TOWN OF (BEEKERMAN RD / ) 6C1 Breathing Problems Abnormal breathing\nAVOCAFDAMB:2011:112",
        "SRC:Avoca FD",
        "ADDR:5572 MICHIGAN HOLLOW RD",
        "CITY:WHEELER",
        "X:BEEKERMAN RD",
        "CODE:6C1",
        "CALL:Breathing Problems Abnormal breathing");

    doTest("T20",
        "messaging@iamresponding.com (Avoca FD) 7 GRANT ST , AVOCA VILLAGE OF (S MAPLE AV / S MAIN ST) 8O1 Carbon Monoxide Dector Alarm (w/out priority symptoms\nAVOCFD:2011:54",
        "SRC:Avoca FD",
        "ADDR:7 GRANT ST",
        "CITY:AVOCA",
        "X:S MAPLE AV / S MAIN ST",
        "CODE:8O1",
        "CALL:ALERT",
        "INFO:Carbon Monoxide Dector Alarm (w/out priority symptoms");

    doTest("T21",
        "messaging@iamresponding.com (Avoca FD) 7 CHARLESWORTH AV , AVOCA VILLAGE OF (EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS) AUTOMATIC ALARM Fire\nAVOCFD:2011:55",
        "SRC:Avoca FD",
        "ADDR:7 CHARLESWORTH AV",
        "CITY:AVOCA",
        "X:EAST AV / CHASE ST; Near: PINECREST HOME FOR ADULTS",
        "CALL:AUTOMATIC ALARM Fire");

    doTest("T22",
        "messaging@iamresponding.com (Avoca FD) 61619 STATE ROUTE 415 #TRLR, AVOCA TOWN OF 31A1 Unconscious/Fainting Fainting episode(s) and alert &gt;35 (without cardiac history)\nAVOCAFDAM",
        "SRC:Avoca FD",
        "ADDR:61619 STATE ROUTE 415",
        "APT:TRLR",
        "CITY:AVOCA",
        "CODE:31A1",
        "CALL:ALERT",
        "INFO:Unconscious/Fainting Fainting episode(s) and alert >35 (without cardiac history)");

    doTest("T23",
        "messaging@iamresponding.com (Avoca FD) 3628 COUNTY ROUTE 70A , HOWARD TOWN OF (HOUSE RD / SMITH POND RD S) STRUCTURE FIRE\nHOWAFD:2011:43",
        "SRC:Avoca FD",
        "ADDR:3628 COUNTY ROAD 70A",
        "CITY:HOWARD",
        "X:HOUSE RD / SMITH POND RD S",
        "CALL:STRUCTURE FIRE");

    doTest("T24",
        "messaging@iamresponding.com (Avoca FD) ::::RECALLED:::::: 3628 COUNTY ROUTE 70A , HOWARD TOWN OF (HOUSE RD / SMITH POND RD S) STRUCTURE FIRE\nHOWAFD:2011:43",
        "SRC:Avoca FD",
        "ADDR:3628 COUNTY ROAD 70A",
        "CITY:HOWARD",
        "X:HOUSE RD / SMITH POND RD S",
        "CALL:RECALLED - STRUCTURE FIRE");

    doTest("T25",
        "messaging@iamresponding.com (Avoca FD) 4550 COUNTY ROUTE 105 , AVOCA TOWN OF (WALLACE BACK RD / CHURCH ST) 31E1 Unconscious/Fainting Ineffective breathing\nAVOCAFDAMB:2011:115",
        "SRC:Avoca FD",
        "ADDR:4550 COUNTY ROAD 105",
        "CITY:AVOCA",
        "X:WALLACE BACK RD / CHURCH ST",
        "CODE:31E1",
        "CALL:ALERT",
        "INFO:Unconscious/Fainting Ineffective breathing");

    doTest("T26",
        "messaging@iamresponding.com (Avoca FD) /BOMBARDIER ( 7940 STATE ROUTE 415 AVOCA TOWN OF ) Misc FIRE\nAVOCFD:2011:56",
        "SRC:Avoca FD",
        "PLACE:BOMBARDIER",
        "ADDR:7940 STATE ROUTE 415",
        "CITY:AVOCA",
        "CALL:Misc FIRE");

    doTest("T27",
        "messaging@iamresponding.com (Avoca FD) 9068 FAIRBROTHER RD , AVOCA TOWN OF (VAN AUCKER RD / WATERBURY HILL RD) 29B4 Traffic Accident Unknown Status/Other Codes Not Applicable\nAVOCA",
        "SRC:Avoca FD",
        "ADDR:9068 FAIRBROTHER RD",
        "CITY:AVOCA",
        "X:VAN AUCKER RD / WATERBURY HILL RD",
        "CODE:29B4",
        "CALL:ALERT",
        "INFO:Traffic Accident Unknown Status/Other Codes Not Applicable");

    doTest("T28",
        "messaging@iamresponding.com (Avoca FD) 7 ALEXANDER ST , AVOCA VILLAGE OF (N MAPLE AV / N MAIN ST) 25B6 Psychiatric/Suicide attempt Unknown Status/Other Codes Not Applicable\nAVOCAFD",
        "SRC:Avoca FD",
        "ADDR:7 ALEXANDER ST",
        "CITY:AVOCA",
        "X:N MAPLE AV / N MAIN ST",
        "CODE:25B6",
        "CALL:ALERT",
        "INFO:Psychiatric/Suicide attempt Unknown Status/Other Codes Not Applicable");

    doTest("T29",
        "messaging@iamresponding.com (Avoca FD) 9374 KHORKS AV , AVOCA TOWN OF ( / WALLACE BACK RD) 17A1 Falls not dangerous body area\nAVOCAFDAMB:2011:119",
        "SRC:Avoca FD",
        "ADDR:9374 KHORKS AV",
        "CITY:AVOCA",
        "X:WALLACE BACK RD",
        "CODE:17A1",
        "CALL:Falls not dangerous body area");

    doTest("T30",
        "messaging@iamresponding.com (Avoca FD) 8980 REEVES RD , WHEELER TOWN OF ( / HEMLOCK RD) 25B3 Psychiatric/Suicide attempt Threatening Suicide\nAVOCAFDAMB:2011:120",
        "SRC:Avoca FD",
        "ADDR:8980 REEVES RD",
        "CITY:WHEELER",
        "X:HEMLOCK RD",
        "CODE:25B3",
        "CALL:ALERT",
        "INFO:Psychiatric/Suicide attempt Threatening Suicide");

    doTest("T31",
        "messaging@iamresponding.com (Avoca FD) 4252 COUNTY ROUTE 70A , HOWARD TOWN OF (HARRIS HILL RD / MILL RD) 26A 2-11 Sick Person Non-Priority Complaints\nAVOCAFDAMB:2011:121",
        "SRC:Avoca FD",
        "ADDR:4252 COUNTY ROAD 70A",
        "CITY:HOWARD",
        "X:HARRIS HILL RD / MILL RD",
        "CALL:ALERT",
        "INFO:26A 2-11 Sick Person Non-Priority Complaints");

    doTest("T32",
        "messaging@iamresponding.com (Avoca FD) 5279 TRACY RD , AVOCA TOWN OF ( / COUNTY ROUTE 8) 1A1 Abdominal Pain\nAVOCAFDAMB:2011:122",
        "SRC:Avoca FD",
        "ADDR:5279 TRACY RD",
        "CITY:AVOCA",
        "X:COUNTY ROAD 8",
        "CODE:1A1",
        "CALL:Abdominal Pain");

    doTest("T33",
        "messaging@iamresponding.com (Avoca FD) 8764 CLARK RD , AVOCA TOWN OF ( / CROSS RD) 28C02 Stroke (CVA)  Abnormal breathing\nAVOCAFDAMB:2011:123",
        "SRC:Avoca FD",
        "ADDR:8764 CLARK RD",
        "CITY:AVOCA",
        "X:CROSS RD",
        "CODE:28C02",
        "CALL:Stroke (CVA)  Abnormal breathing");

    doTest("T34",
        "messaging@iamresponding.com (Avoca FD) 8980 REEVES RD , WHEELER TOWN OF ( / HEMLOCK RD) 25A1 Psychiatric/Suicide attempt Non-suicidal and alert\nAVOCAFDAMB:2011:124",
        "SRC:Avoca FD",
        "ADDR:8980 REEVES RD",
        "CITY:WHEELER",
        "X:HEMLOCK RD",
        "CODE:25A1",
        "CALL:ALERT",
        "INFO:Psychiatric/Suicide attempt Non-suicidal and alert");

    doTest("T35",
        "messaging@iamresponding.com (Avoca FD) /MILE 139 ( I86 BETWEEN EXIT 35 + ) 29B1 Traffic Accidents  Injuries\nAVOCAFDAMB:2011:125",
        "SRC:Avoca FD",
        "PLACE:MILE 139",
        "ADDR:I-86",
        "X:BETWEEN EXIT 35 +",
        "CODE:29B1",
        "CALL:Traffic Accidents  Injuries");

    doTest("T36",
        "messaging@iamresponding.com (Avoca FD) ::::RECALLED:::::: /MILE 139 ( I86 BETWEEN EXIT 35 + ) 29B1 Traffic Accidents  Injuries\nAVOCAFDAMB:2011:125",
        "SRC:Avoca FD",
        "PLACE:MILE 139",
        "ADDR:I-86",
        "X:BETWEEN EXIT 35 +",
        "CODE:29B1",
        "CALL:RECALLED - Traffic Accidents  Injuries");

    doTest("T37",
        "messaging@iamresponding.com (Avoca FD) 61619 STATE ROUTE 415 #TRLR, AVOCA TOWN OF ( / WENTWORTH RD) 19D4 Heart Problems Clammy\nAVOCAFDAMB:2011:126",
        "SRC:Avoca FD",
        "ADDR:61619 STATE ROUTE 415",
        "APT:TRLR",
        "CITY:AVOCA",
        "X:WENTWORTH RD",
        "CODE:19D4",
        "CALL:Heart Problems Clammy");

    doTest("T38",
        "messaging@iamresponding.com (Avoca FD) 226 W WASHINGTON ST #APT 201, BATH VILLAGE OF (HUBBELL ST / FREEMAN TERR) 10D2 Chest Pain Difficulty Speaking Between Breaths\nBATHAMB:2011:77",
        "SRC:Avoca FD",
        "ADDR:226 W WASHINGTON ST #",
        "APT:201",
        "CITY:BATH",
        "X:HUBBELL ST / FREEMAN TERR",
        "CODE:10D2",
        "CALL:ALERT",
        "INFO:Chest Pain Difficulty Speaking Between Breaths");

    doTest("T39",
        "messaging@iamresponding.com (Avoca FD) 8039 SMITH POND RD , HOWARD TOWN OF (MACKEY RD / WESSELS HILL RD) Brush Fire\nAVOCAFDAMB:2011:127",
        "SRC:Avoca FD",
        "ADDR:8039 SMITH POND RD",
        "CITY:HOWARD",
        "X:MACKEY RD / WESSELS HILL RD",
        "CALL:Brush Fire");

    doTest("T40",
        "messaging@iamresponding.com (Avoca FD) THIS IS A TEST MESSAGE FOR I AM RESPONDING TEST\nAVOCFD:2011:57",
        "SRC:Avoca FD",
        "CALL:ALERT",
        "INFO:THIS IS A TEST MESSAGE FOR I AM RESPONDING TEST");

  }
  
  public static void main(String[] args) {
    new NYSteubenCountyParserTest().generateTests("T1", "SRC PLACE ADDR APT CITY X CODE CALL INFO");
  }
}