package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Merrimack County, NH

Contact: Active911
Agency name: New London Fire Dept.
Location: New London, NH, United States
Sender: dispatch@newlondonpd.us

(CAD) TYPE: MED/Medical Call\nTIME: 08/15/2013 17:09:29\nLOC: 143 COUNTY RD\nCITY: NEW LONDON\nASSIST AMBULANCE WITH CARRY OUT OF BUILDING\n70 YO
(CAD) TYPE: ASC/Assist Citizen\nTIME: 08/14/2013 15:21:05\nLOC: PLEASANT LAKE\nCITY: NEW LONDON\nCHILD FELL FROM RAFT INTO WATER
(CAD) TYPE: MVCOMP/Motor Vehicle Complaint\nTIME: 08/11/2013 16:55:52\nLOC: 89 NB EXIT 12 MM 34.2\nCITY: NEW LONDON\nSM PLANE LANDED. STAGE @STATI
(CAD) EVENT:0045\nTIME:08/07/2013 21:53:04\nTYPE:FIRE/Fire Call\nLOC:SEAMANS RD NEAR WELLSWOOD\nTXT:
(CAD) TIME: 08/05/2013 14:11:39\nCITY: \nLOC: MT KEARSARGE\nTYPE: MED/Medical Call\nTXT: FEMALE BROKEN ANKLE ON BARLOW TRAIL 1/2 WAY UP
(CAD) TIME: 07/31/2013 16:36:27\nCITY: NEW LONDON\nLOC: 96 GAY FARM RD\nTYPE: FIRE/Fire Call\nTXT: REQ TO VENTILATE SMOKE IN BUILDING
(CAD) TIME: 07/31/2013 08:50:40\nCITY: NEW LONDON\nLOC: 89 NB MM 31.8\nTYPE: MVCOMP/Motor Vehicle Complaint\nTXT: MVA INTO GUARDRAIL, CHECK ELDERL
(CAD) EVENT:0058\nTIME:07/22/2013 21:25:50\nTYPE:ACC/Traffic Accident\nLOC:TANNERY POND\nTXT:BOAT CAPSIZED 1 PT UNACCOUNTED FOR NLFD DIVE TEAM
(CAD) EVENT:0047\nTIME:07/17/2013 22:10:41\nTYPE:FIRE/Fire Call\nLOC:179 LITTLE SUNAPEE RD\nTXT:REQ FOR FIRE DEPARTMENT TO RESPOND FOR A FIRE ALAR
(CAD) EVENT:0031\nTIME:07/05/2013 13:31:05\nTYPE:LOG/Log Note\nLOC:ROUTE 10 SOUTH\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL
(CAD) EVENT:0031\nTIME:07/05/2013 13:17:09\nTYPE:LOG/Log Note\nLOC:ROUTE 103\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL
(CAD) EVENT:0031\nTIME:07/05/2013 13:17:09\nTYPE:LOG/Log Note\nLOC:NEWBURY\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL
(CAD) EVENT:0016\nTIME:07/01/2013 11:32:59\nTYPE:LOG/Log Note\nLOC:25 SEAMANS RD\nTXT:TEST OF THE ACTIVE 911 FROM DISPATCH @1159
(CAD) EVENT:0018\nTIME:06/17/2013 14:54:22\nTYPE:LOG/Log Note\nLOC:NEW LONDON\nTXT:TEST OF ACTIVE 911 FROM DISPATCH
(CAD) EVENT:0041\nTIME:04/22/2013 18:10:12\nTYPE:FIRE A/Fire Alarm\nLOC:450 HALL FARM RD\nTXT:REQUEST FOR FIRE DEPARTMENT TO RESPOND FOR A GAS ALA
(CAD) EVENT:0054\nTIME:04/17/2013 23:30:29\nTYPE:FIRE/Fire Call\nLOC:9 SAWYER MEADOW RD\nTXT:REQUEST FOR A FIRST ALARM IN THE TOWN OF CROYDON FOR
(CAD) EVENT:0021\nTIME:04/15/2013 15:30:46\nTYPE:ACC/Traffic Accident\nLOC:MAIN ST/DUNKIN DONUT\nTXT:
(CAD) EVENT:0011\nTIME:03/11/2013 07:40:49\nTYPE:FIRE/Fire Call\nLOC:112RT4\nTXT:88 REQUEST A NEW LONDON ENGINE TO RESPOND TO ABOVE FOR AN ELECTRI
(CAD) EVENT:0011\nTIME:03/11/2013 07:40:49\nTYPE:FIRE/Fire Call\nLOC:112RT4\nTXT:
(CAD) EVENT:0108\nTIME:03/05/2013 10:10:44\nTYPE:FIRE/Fire Call\nLOC:237 MAIN ST\nTXT:TEST CALL FOR NLFD

*/

public class NHMerrimackCountyParserTest extends BaseParserTest {
  
  public NHMerrimackCountyParserTest() {
    setParser(new NHMerrimackCountyParser(), "MERRIMACK COUNTY", "NH");
  }
  
  @Test
  public void testNewLondonFierDept() {

    doTest("T1",
        "(CAD) TYPE: MED/Medical Call\n" +
        "TIME: 08/15/2013 17:09:29\n" +
        "LOC: 143 COUNTY RD\n" +
        "CITY: NEW LONDON\n" +
        "ASSIST AMBULANCE WITH CARRY OUT OF BUILDING\n" +
        "70 YO",

        "CALL:MED/Medical Call",
        "DATE:08/15/2013",
        "TIME:17:09:29",
        "ADDR:143 COUNTY RD",
        "CITY:NEW LONDON",
        "INFO:ASSIST AMBULANCE WITH CARRY OUT OF BUILDING / 70 YO");

    doTest("T2",
        "(CAD) TYPE: ASC/Assist Citizen\nTIME: 08/14/2013 15:21:05\nLOC: PLEASANT LAKE\nCITY: NEW LONDON\nCHILD FELL FROM RAFT INTO WATER",
        "CALL:ASC/Assist Citizen",
        "DATE:08/14/2013",
        "TIME:15:21:05",
        "ADDR:PLEASANT LAKE",
        "CITY:NEW LONDON",
        "INFO:CHILD FELL FROM RAFT INTO WATER");

    doTest("T3",
        "(CAD) TYPE: MVCOMP/Motor Vehicle Complaint\n" +
        "TIME: 08/11/2013 16:55:52\n" +
        "LOC: 89 NB EXIT 12 MM 34.2\n" +
        "CITY: NEW LONDON\n" +
        "SM PLANE LANDED. STAGE @STATI",

        "CALL:MVCOMP/Motor Vehicle Complaint",
        "DATE:08/11/2013",
        "TIME:16:55:52",
        "ADDR:89 NB EXIT 12 MM 34.2",
        "MADDR:89 EXIT 12 MM 34.2",
        "CITY:NEW LONDON",
        "INFO:SM PLANE LANDED. STAGE @STATI");

    doTest("T4",
        "(CAD) EVENT:0045\nTIME:08/07/2013 21:53:04\nTYPE:FIRE/Fire Call\nLOC:SEAMANS RD NEAR WELLSWOOD\nTXT:",
        "DATE:08/07/2013",
        "TIME:21:53:04",
        "CALL:FIRE/Fire Call",
        "ADDR:SEAMANS RD NEAR WELLSWOOD",
        "MADDR:SEAMANS RD & WELLSWOOD");

    doTest("T5",
        "(CAD) TIME: 08/05/2013 14:11:39\n" +
        "CITY: \n" +
        "LOC: MT KEARSARGE\n" +
        "TYPE: MED/Medical Call\n" +
        "TXT: FEMALE BROKEN ANKLE ON BARLOW TRAIL 1/2 WAY UP",

        "DATE:08/05/2013",
        "TIME:14:11:39",
        "ADDR:MT KEARSARGE",
        "CALL:MED/Medical Call",
        "INFO:FEMALE BROKEN ANKLE ON BARLOW TRAIL 1/2 WAY UP");

    doTest("T6",
        "(CAD) TIME: 07/31/2013 16:36:27\nCITY: NEW LONDON\nLOC: 96 GAY FARM RD\nTYPE: FIRE/Fire Call\nTXT: REQ TO VENTILATE SMOKE IN BUILDING",
        "DATE:07/31/2013",
        "TIME:16:36:27",
        "CITY:NEW LONDON",
        "ADDR:96 GAY FARM RD",
        "CALL:FIRE/Fire Call",
        "INFO:REQ TO VENTILATE SMOKE IN BUILDING");

    doTest("T7",
        "(CAD) TIME: 07/31/2013 08:50:40\n" +
        "CITY: NEW LONDON\n" +
        "LOC: 89 NB MM 31.8\n" +
        "TYPE: MVCOMP/Motor Vehicle Complaint\n" +
        "TXT: MVA INTO GUARDRAIL, CHECK ELDERL",

        "DATE:07/31/2013",
        "TIME:08:50:40",
        "CITY:NEW LONDON",
        "ADDR:89 NB MM 31.8",
        "MADDR:89 MM 31.8",
        "CALL:MVCOMP/Motor Vehicle Complaint",
        "INFO:MVA INTO GUARDRAIL, CHECK ELDERL");

    doTest("T8",
        "(CAD) EVENT:0058\n" +
        "TIME:07/22/2013 21:25:50\n" +
        "TYPE:ACC/Traffic Accident\n" +
        "LOC:TANNERY POND\n" +
        "TXT:BOAT CAPSIZED 1 PT UNACCOUNTED FOR NLFD DIVE TEAM",

        "DATE:07/22/2013",
        "TIME:21:25:50",
        "CALL:ACC/Traffic Accident",
        "ADDR:TANNERY POND",
        "INFO:BOAT CAPSIZED 1 PT UNACCOUNTED FOR NLFD DIVE TEAM");

    doTest("T9",
        "(CAD) EVENT:0047\n" +
        "TIME:07/17/2013 22:10:41\n" +
        "TYPE:FIRE/Fire Call\n" +
        "LOC:179 LITTLE SUNAPEE RD\n" +
        "TXT:REQ FOR FIRE DEPARTMENT TO RESPOND FOR A FIRE ALAR",

        "DATE:07/17/2013",
        "TIME:22:10:41",
        "CALL:FIRE/Fire Call",
        "ADDR:179 LITTLE SUNAPEE RD",
        "INFO:REQ FOR FIRE DEPARTMENT TO RESPOND FOR A FIRE ALAR");

    doTest("T10",
        "(CAD) EVENT:0031\nTIME:07/05/2013 13:31:05\nTYPE:LOG/Log Note\nLOC:ROUTE 10 SOUTH\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL",
        "DATE:07/05/2013",
        "TIME:13:31:05",
        "CALL:LOG/Log Note",
        "ADDR:ROUTE 10 SOUTH",
        "INFO:ACTIVE 911 TEST FOR MUTUAL AID CALL");

    doTest("T11",
        "(CAD) EVENT:0031\nTIME:07/05/2013 13:17:09\nTYPE:LOG/Log Note\nLOC:ROUTE 103\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL",
        "DATE:07/05/2013",
        "TIME:13:17:09",
        "CALL:LOG/Log Note",
        "ADDR:ROUTE 103",
        "INFO:ACTIVE 911 TEST FOR MUTUAL AID CALL");

    doTest("T12",
        "(CAD) EVENT:0031\nTIME:07/05/2013 13:17:09\nTYPE:LOG/Log Note\nLOC:NEWBURY\nTXT:ACTIVE 911 TEST FOR MUTUAL AID CALL",
        "DATE:07/05/2013",
        "TIME:13:17:09",
        "CALL:LOG/Log Note",
        "ADDR:NEWBURY",
        "INFO:ACTIVE 911 TEST FOR MUTUAL AID CALL");

    doTest("T13",
        "(CAD) EVENT:0016\nTIME:07/01/2013 11:32:59\nTYPE:LOG/Log Note\nLOC:25 SEAMANS RD\nTXT:TEST OF THE ACTIVE 911 FROM DISPATCH @1159",
        "DATE:07/01/2013",
        "TIME:11:32:59",
        "CALL:LOG/Log Note",
        "ADDR:25 SEAMANS RD",
        "INFO:TEST OF THE ACTIVE 911 FROM DISPATCH @1159");

    doTest("T14",
        "(CAD) EVENT:0018\nTIME:06/17/2013 14:54:22\nTYPE:LOG/Log Note\nLOC:NEW LONDON\nTXT:TEST OF ACTIVE 911 FROM DISPATCH",
        "DATE:06/17/2013",
        "TIME:14:54:22",
        "CALL:LOG/Log Note",
        "ADDR:NEW LONDON",
        "INFO:TEST OF ACTIVE 911 FROM DISPATCH");

    doTest("T15",
        "(CAD) EVENT:0041\n" +
        "TIME:04/22/2013 18:10:12\n" +
        "TYPE:FIRE A/Fire Alarm\n" +
        "LOC:450 HALL FARM RD\n" +
        "TXT:REQUEST FOR FIRE DEPARTMENT TO RESPOND FOR A GAS ALA",

        "DATE:04/22/2013",
        "TIME:18:10:12",
        "CALL:FIRE A/Fire Alarm",
        "ADDR:450 HALL FARM RD",
        "INFO:REQUEST FOR FIRE DEPARTMENT TO RESPOND FOR A GAS ALA");

    doTest("T16",
        "(CAD) EVENT:0054\n" +
        "TIME:04/17/2013 23:30:29\n" +
        "TYPE:FIRE/Fire Call\n" +
        "LOC:9 SAWYER MEADOW RD\n" +
        "TXT:REQUEST FOR A FIRST ALARM IN THE TOWN OF CROYDON FOR",

        "DATE:04/17/2013",
        "TIME:23:30:29",
        "CALL:FIRE/Fire Call",
        "ADDR:9 SAWYER MEADOW RD",
        "INFO:REQUEST FOR A FIRST ALARM IN THE TOWN OF CROYDON FOR");

    doTest("T17",
        "(CAD) EVENT:0021\nTIME:04/15/2013 15:30:46\nTYPE:ACC/Traffic Accident\nLOC:MAIN ST/DUNKIN DONUT\nTXT:",
        "DATE:04/15/2013",
        "TIME:15:30:46",
        "CALL:ACC/Traffic Accident",
        "ADDR:MAIN ST & DUNKIN DONUT");

    doTest("T18",
        "(CAD) EVENT:0011\n" +
        "TIME:03/11/2013 07:40:49\n" +
        "TYPE:FIRE/Fire Call\n" +
        "LOC:112RT4\n" +
        "TXT:88 REQUEST A NEW LONDON ENGINE TO RESPOND TO ABOVE FOR AN ELECTRI",

        "DATE:03/11/2013",
        "TIME:07:40:49",
        "CALL:FIRE/Fire Call",
        "ADDR:112RT4",
        "INFO:88 REQUEST A NEW LONDON ENGINE TO RESPOND TO ABOVE FOR AN ELECTRI");

    doTest("T19",
        "(CAD) EVENT:0011\nTIME:03/11/2013 07:40:49\nTYPE:FIRE/Fire Call\nLOC:112RT4\nTXT:",
        "DATE:03/11/2013",
        "TIME:07:40:49",
        "CALL:FIRE/Fire Call",
        "ADDR:112RT4");

    doTest("T20",
        "(CAD) EVENT:0108\nTIME:03/05/2013 10:10:44\nTYPE:FIRE/Fire Call\nLOC:237 MAIN ST\nTXT:TEST CALL FOR NLFD",
        "DATE:03/05/2013",
        "TIME:10:10:44",
        "CALL:FIRE/Fire Call",
        "ADDR:237 MAIN ST",
        "INFO:TEST CALL FOR NLFD");
     
  }

  public static void main(String[] args) {
    new NHMerrimackCountyParserTest().generateTests("T1");
  }
}
