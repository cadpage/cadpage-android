package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Madison County, AL
Contact: Mark Wehrwein <heyblue17@gmail.com>
Sender: cad.page@madco911.com

IPS I/Page Notification / Loc: 7583 WALL TRIANA HWY MDCO: @URGENT MEDCARE EVT#: C1009726 TYPE: M TIME: 13:36:55
IPS I/Page Notification / Loc: 2525 OLD RAILROAD BED RD MDCO EVT#: C1009579 TYPE: M TIME: 16:53:25
IPS I/Page Notification / Loc: HIGHWAY 53/KELLY SPRING RD HSV: alias HWY 53/KELLY SPRING EVT#: C1009577 TYPE: MVA/I TIME: 14:12:44
IPS I/Page Notification / Loc: 101 VASSER CIR MDCO EVT#: C1009575 TYPE: M TIME: 13:54:54
IPS I/Page Notification / Loc: 106 CHESAPEAKE BLVD MDCO EVT#: C1009490 TYPE: M TIME: 16:04:25
IPS I/Page Notification / Loc: 120 EMERALD DR MDCO EVT#: C1009484 TYPE: M TIME: 12:07:46

Contact: NICK GOODMAN <hemsi89@gmail.com>
(IPS I/Page Notification) EVENT: E1105513 Loc: 116 DRYSDALE DR MDCO EVT#: E1105513 TYPE: M TIME: 08:48:15

Contact: Medcomm <jddyer@rescuesquad.net>
Sender: rescue1-bounces@rescuesquad.net
(R1 IPS I/Page Notification) Loc: 1251 CARTERS GIN RD MDCO EVT#: E1120631 TYPE: MVA/E TIME: 01:50:42
(R1 IPS I/Page Notification) Loc: TIMBERLANE AV NW/POPLAR AV NW HSV  EVT#: E1120841 TYPE: MVA/E TIME: 13:42:06

Contact: Rick Phillips <rick81997@yahoo.com>
Sender: cad.page@madco911.com
Subject:IPS I/Page Notification\nLoc: 2979 OLD HIGHWAY 431 OXRD: @NO NAME: COMMERCIAL & RESIDENTAL APT COMPLEX: alias 2979 OLD HWY 431 EVT

Contact: shamond rice <freefalling2010@gmail.com>
Sender: cad.page@madco911.com
(IPS I/Page Notification) Loc: 124 8TH ST TRI EVT#: C1205250 TYPE: FR TIME: 07:44:04 GRID ID: 2222
(IPS I/Page Notification) Loc: 140 FEARN DR TRI EVT#: C1205345 TYPE: DOM TIME: 19:54:32 GRID ID: 2225

Contact: "Chad Tillman" <tillmanclt@gmail.com>
Sender: cad.page@madco911.com
(IPS I/Page Notification) Loc: 1567 YARBROUGH RD MDCO EVT#: E1232245 TYPE: MVA/E TIME: 03:21:57 GRID ID: 936

Contact: C.J. Hamilton <c.j.hamilton93@gmail.com>
Sender: cad.page@madco911.com
cad.page@madco911.com / IPS I/Page Notification / Loc: 369 WALL RD MDCO EVT#: C1301773 TYPE: ALM/M TIME: 17:18:26 GRID ID: 1429
cad.page@madco911.com / IPS I/Page Notification / Loc: 295 ACUFF RD MDCO EVT#: C1301790 TYPE: ALM/M TIME: 12:55:09 GRID ID: 1537
cad.page@madco911.com / IPS I/Page Notification / Loc: 1770 DUG HILL RD MDCO EVT#: C1301746 TYPE: ASST/C TIME: 17:48:48 GRID ID: 1432
cad.page@madco911.com / IPS I/Page Notification / Loc: 117 STACY CIR MDCO EVT#: C1301732 TYPE: M TIME: 09:12:11 GRID ID: 1419
cad.page@madco911.com / IPS I/Page Notification / Loc: 3252 HIGHWAY 72 E MDCO: alias 3252 HWY 72 EVT#: C1301707 TYPE: M TIME: 16:08:52 GRID ID: 1430

Contact: Active911
Agency name: Monrovia FireRescue
Location: Huntsville, AL, United States
Sender: Shawn Terry <firechief@monroviafire.org>

TEST ONLY Loc: JEFF RD/CAPSHAW RD MDCO EVT#: C1303111 TYPE: SUI/A TIME: 09:23:34 GRID ID: 1221
Loc: 290 HOMEPLACE LN MDCO EVT#: C1301940 TYPE: M TIME: 15:27:43 GRID ID: 1208
Loc: 115 TINDALL DR MDCO EVT#: C1301468 TYPE: F/ALARMS TIME: 12:01:24 GRID ID: 1209
Loc: 345 MT. ZION RD MDCO EVT#: C13XXXX TYPE: TEST ONLY\r\n
Loc: 345 MT. ZION RD MDCO EVT#: C1301298 TYPE: TEST TIME: 10:54:13 GRID ID: 1217
Loc: 124 SABEL CIR MDCO EVT#: C1301301 TYPE: M TIME: 12:37:06 GRID ID: 1211\r\n

Contact: Active911
Agency name: Madison Fire  Rescue
Location: Madison, AL, United States
Sender: Madco911 <cad.page@madco911.com>

(IPS I/Page Notification) Loc: HIGHWAY 72 W/NANCE RD HSV: alias HWY 72 W/NANCE RD HSV EVT#: R131400 TYPE: MVA/I TIME: 17:13:57 GRID ID: 1227 
(IPS I/Page Notification) Loc: 112 STAVEMILL CIR MAD EVT#: R131399 TYPE: M TIME: 17:12:00 GRID ID: 1910 
(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131395 TYPE: TEST TIME: 15:35:37 GRID ID: 1141 
(IPS I/Page Notification) Loc: 103 STONEWAY TR MAD EVT#: R131398 TYPE: M TIME: 15:13:35 GRID ID: 1234 
(IPS I/Page Notification) Loc: 101 SUNSET TR MAD EVT#: R131397 TYPE: M TIME: 08:46:17 GRID ID: 1910 
(IPS I/Page Notification) Loc: 124 LEWTER DR MDCO EVT#: R131396 TYPE: CARDIAC TIME: 20:26:18 GRID ID: 1904 
(IPS I/Page Notification) Loc: 101 MILL RD MAD: @MFD1 EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID: 1910 
(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131395 TYPE: TEST TIME: 15:35:37 GRID ID: 1141 
(IPS I/Page Notification) Loc: 101 MILL RD MAD: @MFD1 EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID: 1910 
(IPS I/Page Notification) Loc: 146 SPRING WATER DR MAD EVT#: R131392 TYPE: FR TIME: 08:07:46 GRID ID: 1904 
(IPS I/Page Notification) Loc: 11306 COUNTY LINE RD LIME MAD: @JAMES CLEMENS EVT#: R131381 TYPE: BOMB TIME: 12:37:18 GRID ID: 2009 
(IPS I/Page Notification) Loc: 115 SOUTHERN POINTE DR MAD:DAVIS RES EVT#: R131378 TYPE: F/ALARMS TIME: 05:36:16 GRID ID: 1903 
(IPS I/Page Notification) Loc: 670 CAMBRIDGE DR MAD:ROBERT JEFFERYS EVT#: R131374 TYPE: F/ALARMS TIME: 21:07:11 GRID ID: 1910 
(IPS I/Page Notification) Loc: 578 GILLESPIE RD MDCO EVT#: R131373 TYPE: M TIME: 19:58:32 GRID ID: 1235 
(IPS I/Page Notification) Loc: 799 BALCH RD MAD EVT#: R131370 TYPE: M TIME: 17:04:23 GRID ID: 1236 
(IPS I/Page Notification) Loc: 29570 ANDREA LN LIME EVT#: R131366 TYPE: TRAUMA TIME: 13:20:25 GRID ID: 1141 
(IPS I/Page Notification) Loc: 229 PALMER RD MAD: @TYONEK FABRICATION CORPORATION:TYONEK EVT#: R131363 TYPE: F/ALARMS TIME: 11:03:42 GRID ID: 1914 
(IPS I/Page Notification) Loc: 142 HUNINGTON CHASE DR MAD EVT#: R131358 TYPE: FR TIME: 23:33:09 GRID ID: 2009 
(IPS I/Page Notification) Loc: 102 OLD PEWTER LN MAD EVT#: R131353 TYPE: M TIME: 10:11:28 GRID ID: 1236 
(IPS I/Page Notification) Loc: 800 BROWNS FERRY RD MAD EVT#: R131350 TYPE: FR TIME: 05:34:11 GRID ID: 1912 
(IPS I/Page Notification) Loc: 29570 ANDREA LN LIME EVT#: R131346 TYPE: SEIZURES TIME: 00:13:02 GRID ID: 1141 
(IPS I/Page Notification) Loc: 8721 MADISON BLVD MAD: @RADISSON HOTEL EVT#: R131342 TYPE: FR TIME: 20:04:35 GRID ID: 1923 
(IPS I/Page Notification) Loc: 1600 BROWNS FERRY RD MAD: @BRADFORD HEALTH SERVICES EVT#: R131341 TYPE: M TIME: 17:00:32 GRID ID: 2008 
(IPS I/Page Notification) Loc: DAILY FSA SYSTEM TEST EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID:  
(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131333 TYPE: TEST TIME: 20:08:50 GRID ID: 1141 
(IPS I/Page Notification) Loc: 103 MOSS WOOD CT MAD: @PSI: JAMES "MONTE" LONG RESIDENCE EVT#: M13025932 TYPE: UNK TIME: 19:49:51 GRID ID: 1226 
(IPS I/Page Notification) Loc: 107 ARLINGTON DR MAD: @MADISON VILLAGE EVT#: M13025927 TYPE: RP TIME: 19:16:35 GRID ID:  
(IPS I/Page Notification) Loc: 10446 COUNTY LINE RD LIME: @SOUTHERN CONVENTION CENTER EVT#: M13025925 TYPE: TS TIME: 18:56:45 GRID ID:  
(IPS I/Page Notification) Loc: @ASHBURY EVT#: M13025923 TYPE: RP TIME: 18:48:08 GRID ID:  
(IPS I/Page Notification) Loc: MADISON BLVD/COUNTY LINE RD HSV EVT#: M13025920 TYPE: TS TIME: 18:31:13 GRID ID:  
(IPS I/Page Notification) Loc: 107 ARLINGTON DR MAD: @MADISON VILLAGE EVT#: M13025919 TYPE: RP TIME: 18:24:09 GRID ID:  
(IPS I/Page Notification) Loc: 3714 SULLIVAN ST MAD: @OREILLYS EVT#: M13025906 TYPE: MVA TIME: 16:14:49 GRID ID: 1923 
(IPS I/Page Notification) Loc: 5827 OAKWOOD RD NW HSV: @911 CENTER EVT#: M13025904 TYPE: TEST TIME: 16:10:17 GRID ID: 1230 

Contact: Charles Renegat <cnrenegar@gmail.com>
Sender: cad.page@madco911.com
(IPS I/Page Notification) Loc: 114 SHADY OAK LN MDCO EVT#: C1305871 TYPE: FR TIME: 13:21:05 GRID ID: 617

 */

public class ALMadisonCountyParserTest extends BaseParserTest {
  
  public ALMadisonCountyParserTest() {
    setParser(new ALMadisonCountyParser(), "MADISON COUNTY", "AL");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "IPS I/Page Notification / Loc: 7583 WALL TRIANA HWY MDCO: @URGENT MEDCARE EVT#: C1009726 TYPE: M TIME: 13:36:55",
        "ADDR:7583 WALL TRIANA HWY",
        "CITY:MADISON COUNTY",
        "PLACE:URGENT MEDCARE",
        "ID:C1009726",
        "CALL:MEDICAL",
        "TIME:13:36:55");
        
    doTest("T2",
        "IPS I/Page Notification / Loc: 2525 OLD RAILROAD BED RD MDCO EVT#: C1009579 TYPE: M TIME: 16:53:25",
        "ADDR:2525 OLD RAILROAD BED RD",
        "CITY:MADISON COUNTY",
        "ID:C1009579",
        "CALL:MEDICAL",
        "TIME:16:53:25");
  
    doTest("T3",
        "IPS I/Page Notification / Loc: HIGHWAY 53/KELLY SPRING RD HSV: alias HWY 53/KELLY SPRING EVT#: C1009577 TYPE: MVA/I TIME: 14:12:44",
        "ADDR:HIGHWAY 53 & KELLY SPRING RD",
        "CITY:HUNTSVILLE",
        "PLACE:HWY 53/KELLY SPRING",
        "ID:C1009577",
        "CALL:MVA W/ INJURY",
        "TIME:14:12:44");
    
    doTest("T4",
        "IPS I/Page Notification / Loc: 101 VASSER CIR MDCO EVT#: C1009575 TYPE: M TIME: 13:54:54",
        "ADDR:101 VASSER CIR",
        "CITY:MADISON COUNTY",
        "ID:C1009575",
        "CALL:MEDICAL",
        "TIME:13:54:54");
    
    doTest("T5",
        "IPS I/Page Notification / Loc: 106 CHESAPEAKE BLVD MDCO EVT#: C1009490 TYPE: M TIME: 16:04:25",
        "ADDR:106 CHESAPEAKE BLVD",
        "CITY:MADISON COUNTY",
        "ID:C1009490",
        "CALL:MEDICAL",
        "TIME:16:04:25");
    
    doTest("T6",
        "IPS I/Page Notification / Loc: 120 EMERALD DR MDCO EVT#: C1009484 TYPE: M TIME: 12:07:46",
        "ADDR:120 EMERALD DR",
        "CITY:MADISON COUNTY",
        "ID:C1009484",
        "CALL:MEDICAL",
        "TIME:12:07:46");
    
    doTest("T7",
        "(IPS I/Page Notification) EVENT: E1105513 Loc: 116 DRYSDALE DR MDCO EVT#: E1105513 TYPE: M TIME: 08:48:15",
        "ADDR:116 DRYSDALE DR",
        "CITY:MADISON COUNTY",
        "ID:E1105513",
        "CALL:MEDICAL",
        "TIME:08:48:15");

    doTest("T8",
        "(R1 IPS I/Page Notification) Loc: TIMBERLANE AV NW/POPLAR AV NW HSV  EVT#: E1120841 TYPE: MVA/E TIME: 13:42:06",
        "ADDR:TIMBERLANE AV NW & POPLAR AV NW",
        "MADDR:TIMBERLANE AVE NW & POPLAR AVE NW",
        "CITY:HUNTSVILLE",
        "ID:E1120841",
        "CALL:MVA W/ ENTRAPMENT",
        "TIME:13:42:06");

    doTest("T9",
        "Subject:IPS I/Page Notification\nLoc: 2979 OLD HIGHWAY 431 OXRD: @NO NAME: COMMERCIAL & RESIDENTAL APT COMPLEX: alias 2979 OLD HWY 431 EVT",
        "ADDR:2979 OLD HIGHWAY 431",
        "PLACE:NO NAME: COMMERCIAL & RESIDENTAL APT COMPLEX: @2979 OLD HWY 431",
        "CITY:OWENS CROSS ROADS");

    doTest("T10",
        "(IPS I/Page Notification) Loc: 124 8TH ST TRI EVT#: C1205250 TYPE: FR TIME: 07:44:04 GRID ID: 2222",
        "ADDR:124 8TH ST",
        "CITY:TRIANA",
        "ID:C1205250",
        "CALL:FIRE/RESCUE",
         "TIME:07:44:04",
         "MAP:2222");

    doTest("T11",
        "(IPS I/Page Notification) Loc: 140 FEARN DR TRI EVT#: C1205345 TYPE: DOM TIME: 19:54:32 GRID ID: 2225",
        "ADDR:140 FEARN DR",
        "CITY:TRIANA",
        "ID:C1205345",
        "CALL:DOM",
        "TIME:19:54:32",
        "MAP:2225");
  }
  
  @Test
  public void testChadTillman() {

    doTest("T1",
        "(IPS I/Page Notification) Loc: 1567 YARBROUGH RD MDCO EVT#: E1232245 TYPE: MVA/E TIME: 03:21:57 GRID ID: 936",
        "ADDR:1567 YARBROUGH RD",
        "CITY:MADISON COUNTY",
        "ID:E1232245",
        "CALL:MVA W/ ENTRAPMENT",
        "TIME:03:21:57",
        "MAP:936");

  }
  
  @Test
  public void testCJHamilton() {

    doTest("T1",
        "cad.page@madco911.com / IPS I/Page Notification / Loc: 369 WALL RD MDCO EVT#: C1301773 TYPE: ALM/M TIME: 17:18:26 GRID ID: 1429",
        "ADDR:369 WALL RD",
        "CITY:MADISON COUNTY",
        "ID:C1301773",
        "CALL:MEDICAL ALARM",
        "TIME:17:18:26",
        "MAP:1429");

    doTest("T2",
        "cad.page@madco911.com / IPS I/Page Notification / Loc: 295 ACUFF RD MDCO EVT#: C1301790 TYPE: ALM/M TIME: 12:55:09 GRID ID: 1537",
        "ADDR:295 ACUFF RD",
        "CITY:MADISON COUNTY",
        "ID:C1301790",
        "CALL:MEDICAL ALARM",
        "TIME:12:55:09",
        "MAP:1537");

    doTest("T3",
        "cad.page@madco911.com / IPS I/Page Notification / Loc: 1770 DUG HILL RD MDCO EVT#: C1301746 TYPE: ASST/C TIME: 17:48:48 GRID ID: 1432",
        "ADDR:1770 DUG HILL RD",
        "CITY:MADISON COUNTY",
        "ID:C1301746",
        "CALL:ASST/C",
        "TIME:17:48:48",
        "MAP:1432");

    doTest("T4",
        "cad.page@madco911.com / IPS I/Page Notification / Loc: 117 STACY CIR MDCO EVT#: C1301732 TYPE: M TIME: 09:12:11 GRID ID: 1419",
        "ADDR:117 STACY CIR",
        "CITY:MADISON COUNTY",
        "ID:C1301732",
        "CALL:MEDICAL",
        "TIME:09:12:11",
        "MAP:1419");

    doTest("T5",
        "cad.page@madco911.com / IPS I/Page Notification / Loc: 3252 HIGHWAY 72 E MDCO: alias 3252 HWY 72 EVT#: C1301707 TYPE: M TIME: 16:08:52 GRID ID: 1430",
        "ADDR:3252 HIGHWAY 72 E",
        "CITY:MADISON COUNTY",
        "PLACE:3252 HWY 72",
        "ID:C1301707",
        "CALL:MEDICAL",
        "TIME:16:08:52",
        "MAP:1430");

  }
  
  @Test
  public void testMonroviaFireRescue() {

    doTest("T1",
        "TEST ONLY Loc: JEFF RD/CAPSHAW RD MDCO EVT#: C1303111 TYPE: SUI/A TIME: 09:23:34 GRID ID: 1221",
        "ADDR:JEFF RD & CAPSHAW RD",
        "CITY:MADISON COUNTY",
        "ID:C1303111",
        "CALL:SUI/A",
        "TIME:09:23:34",
        "MAP:1221");

    doTest("T2",
        "Loc: 290 HOMEPLACE LN MDCO EVT#: C1301940 TYPE: M TIME: 15:27:43 GRID ID: 1208",
        "ADDR:290 HOMEPLACE LN",
        "CITY:MADISON COUNTY",
        "ID:C1301940",
        "CALL:MEDICAL",
        "TIME:15:27:43",
        "MAP:1208");

    doTest("T3",
        "Loc: 115 TINDALL DR MDCO EVT#: C1301468 TYPE: F/ALARMS TIME: 12:01:24 GRID ID: 1209",
        "ADDR:115 TINDALL DR",
        "CITY:MADISON COUNTY",
        "ID:C1301468",
        "CALL:FIRE ALARM",
        "TIME:12:01:24",
        "MAP:1209");

    doTest("T4",
        "Loc: 345 MT. ZION RD MDCO EVT#: C13XXXX TYPE: TEST ONLY\r\n",
        "ADDR:345 MT ZION RD",
        "CITY:MADISON COUNTY",
        "ID:C13XXXX",
        "CALL:TEST ONLY");

    doTest("T5",
        "Loc: 345 MT. ZION RD MDCO EVT#: C1301298 TYPE: TEST TIME: 10:54:13 GRID ID: 1217",
        "ADDR:345 MT ZION RD",
        "CITY:MADISON COUNTY",
        "ID:C1301298",
        "CALL:TEST",
        "TIME:10:54:13",
        "MAP:1217");

    doTest("T6",
        "Loc: 124 SABEL CIR MDCO EVT#: C1301301 TYPE: M TIME: 12:37:06 GRID ID: 1211\r\n",
        "ADDR:124 SABEL CIR",
        "CITY:MADISON COUNTY",
        "ID:C1301301",
        "CALL:MEDICAL",
        "TIME:12:37:06",
        "MAP:1211");
    
  }
  
  @Test
  public void testMadisonFireRescue() {

    doTest("T1",
        "(IPS I/Page Notification) Loc: HIGHWAY 72 W/NANCE RD HSV: alias HWY 72 W/NANCE RD HSV EVT#: R131400 TYPE: MVA/I TIME: 17:13:57 GRID ID: 1227 ",
        "ADDR:HIGHWAY 72 W & NANCE RD",
        "CITY:HUNTSVILLE",
        "PLACE:HWY 72 W/NANCE RD HSV",
        "ID:R131400",
        "CALL:MVA W/ INJURY",
        "TIME:17:13:57",
        "MAP:1227");

    doTest("T2",
        "(IPS I/Page Notification) Loc: 112 STAVEMILL CIR MAD EVT#: R131399 TYPE: M TIME: 17:12:00 GRID ID: 1910 ",
        "ADDR:112 STAVEMILL CIR",
        "CITY:MADISON",
        "ID:R131399",
        "CALL:MEDICAL",
        "TIME:17:12:00",
        "MAP:1910");

    doTest("T3",
        "(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131395 TYPE: TEST TIME: 15:35:37 GRID ID: 1141 ",
        "ADDR:12266 COUNTY LINE RD",
        "CITY:MADISON",
        "PLACE:MFD3",
        "ID:R131395",
        "CALL:TEST",
        "TIME:15:35:37",
        "MAP:1141");

    doTest("T4",
        "(IPS I/Page Notification) Loc: 103 STONEWAY TR MAD EVT#: R131398 TYPE: M TIME: 15:13:35 GRID ID: 1234 ",
        "ADDR:103 STONEWAY TR",
        "CITY:MADISON",
        "ID:R131398",
        "CALL:MEDICAL",
        "TIME:15:13:35",
        "MAP:1234");

    doTest("T5",
        "(IPS I/Page Notification) Loc: 101 SUNSET TR MAD EVT#: R131397 TYPE: M TIME: 08:46:17 GRID ID: 1910 ",
        "ADDR:101 SUNSET TR",
        "CITY:MADISON",
        "ID:R131397",
        "CALL:MEDICAL",
        "TIME:08:46:17",
        "MAP:1910");

    doTest("T6",
        "(IPS I/Page Notification) Loc: 124 LEWTER DR MDCO EVT#: R131396 TYPE: CARDIAC TIME: 20:26:18 GRID ID: 1904 ",
        "ADDR:124 LEWTER DR",
        "CITY:MADISON COUNTY",
        "ID:R131396",
        "CALL:CARDIAC",
        "TIME:20:26:18",
        "MAP:1904");

    doTest("T7",
        "(IPS I/Page Notification) Loc: 101 MILL RD MAD: @MFD1 EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID: 1910 ",
        "ADDR:101 MILL RD",
        "CITY:MADISON",
        "PLACE:MFD1",
        "ID:R130471",
        "CALL:TEST",
        "TIME:23:13:21",
        "MAP:1910");

    doTest("T8",
        "(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131395 TYPE: TEST TIME: 15:35:37 GRID ID: 1141 ",
        "ADDR:12266 COUNTY LINE RD",
        "CITY:MADISON",
        "PLACE:MFD3",
        "ID:R131395",
        "CALL:TEST",
        "TIME:15:35:37",
        "MAP:1141");

    doTest("T9",
        "(IPS I/Page Notification) Loc: 101 MILL RD MAD: @MFD1 EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID: 1910 ",
        "ADDR:101 MILL RD",
        "CITY:MADISON",
        "PLACE:MFD1",
        "ID:R130471",
        "CALL:TEST",
        "TIME:23:13:21",
        "MAP:1910");

    doTest("T10",
        "(IPS I/Page Notification) Loc: 146 SPRING WATER DR MAD EVT#: R131392 TYPE: FR TIME: 08:07:46 GRID ID: 1904 ",
        "ADDR:146 SPRING WATER DR",
        "CITY:MADISON",
        "ID:R131392",
        "CALL:FIRE/RESCUE",
        "TIME:08:07:46",
        "MAP:1904");

    doTest("T11",
        "(IPS I/Page Notification) Loc: 11306 COUNTY LINE RD LIME MAD: @JAMES CLEMENS EVT#: R131381 TYPE: BOMB TIME: 12:37:18 GRID ID: 2009 ",
        "ADDR:11306 COUNTY LINE RD",
        "CITY:MADISON",
        "PLACE:JAMES CLEMENS",
        "ID:R131381",
        "CALL:BOMB",
        "TIME:12:37:18",
        "MAP:2009");

    doTest("T12",
        "(IPS I/Page Notification) Loc: 115 SOUTHERN POINTE DR MAD:DAVIS RES EVT#: R131378 TYPE: F/ALARMS TIME: 05:36:16 GRID ID: 1903 ",
        "ADDR:115 SOUTHERN POINTE DR",
        "CITY:MADISON",
        "PLACE:DAVIS RES",
        "ID:R131378",
        "CALL:FIRE ALARM",
        "TIME:05:36:16",
        "MAP:1903");

    doTest("T13",
        "(IPS I/Page Notification) Loc: 670 CAMBRIDGE DR MAD:ROBERT JEFFERYS EVT#: R131374 TYPE: F/ALARMS TIME: 21:07:11 GRID ID: 1910 ",
        "ADDR:670 CAMBRIDGE DR",
        "CITY:MADISON",
        "PLACE:ROBERT JEFFERYS",
        "ID:R131374",
        "CALL:FIRE ALARM",
        "TIME:21:07:11",
        "MAP:1910");

    doTest("T14",
        "(IPS I/Page Notification) Loc: 578 GILLESPIE RD MDCO EVT#: R131373 TYPE: M TIME: 19:58:32 GRID ID: 1235 ",
        "ADDR:578 GILLESPIE RD",
        "CITY:MADISON COUNTY",
        "ID:R131373",
        "CALL:MEDICAL",
        "TIME:19:58:32",
        "MAP:1235");

    doTest("T15",
        "(IPS I/Page Notification) Loc: 799 BALCH RD MAD EVT#: R131370 TYPE: M TIME: 17:04:23 GRID ID: 1236 ",
        "ADDR:799 BALCH RD",
        "CITY:MADISON",
        "ID:R131370",
        "CALL:MEDICAL",
        "TIME:17:04:23",
        "MAP:1236");

    doTest("T16",
        "(IPS I/Page Notification) Loc: 29570 ANDREA LN LIME EVT#: R131366 TYPE: TRAUMA TIME: 13:20:25 GRID ID: 1141 ",
        "ADDR:29570 ANDREA LN",
        "CITY:LIMESTONE COUNTY",
        "ID:R131366",
        "CALL:TRAUMA",
        "TIME:13:20:25",
        "MAP:1141");

    doTest("T17",
        "(IPS I/Page Notification) Loc: 229 PALMER RD MAD: @TYONEK FABRICATION CORPORATION:TYONEK EVT#: R131363 TYPE: F/ALARMS TIME: 11:03:42 GRID ID: 1914 ",
        "ADDR:229 PALMER RD",
        "CITY:MADISON",
        "PLACE:TYONEK FABRICATION CORPORATION:TYONEK",
        "ID:R131363",
        "CALL:FIRE ALARM",
        "TIME:11:03:42",
        "MAP:1914");

    doTest("T18",
        "(IPS I/Page Notification) Loc: 142 HUNINGTON CHASE DR MAD EVT#: R131358 TYPE: FR TIME: 23:33:09 GRID ID: 2009 ",
        "ADDR:142 HUNINGTON CHASE DR",
        "CITY:MADISON",
        "ID:R131358",
        "CALL:FIRE/RESCUE",
        "TIME:23:33:09",
        "MAP:2009");

    doTest("T19",
        "(IPS I/Page Notification) Loc: 102 OLD PEWTER LN MAD EVT#: R131353 TYPE: M TIME: 10:11:28 GRID ID: 1236 ",
        "ADDR:102 OLD PEWTER LN",
        "CITY:MADISON",
        "ID:R131353",
        "CALL:MEDICAL",
        "TIME:10:11:28",
        "MAP:1236");

    doTest("T20",
        "(IPS I/Page Notification) Loc: 800 BROWNS FERRY RD MAD EVT#: R131350 TYPE: FR TIME: 05:34:11 GRID ID: 1912 ",
        "ADDR:800 BROWNS FERRY RD",
        "CITY:MADISON",
        "ID:R131350",
        "CALL:FIRE/RESCUE",
        "TIME:05:34:11",
        "MAP:1912");

    doTest("T21",
        "(IPS I/Page Notification) Loc: 29570 ANDREA LN LIME EVT#: R131346 TYPE: SEIZURES TIME: 00:13:02 GRID ID: 1141 ",
        "ADDR:29570 ANDREA LN",
        "CITY:LIMESTONE COUNTY",
        "ID:R131346",
        "CALL:SEIZURES",
        "TIME:00:13:02",
        "MAP:1141");

    doTest("T22",
        "(IPS I/Page Notification) Loc: 8721 MADISON BLVD MAD: @RADISSON HOTEL EVT#: R131342 TYPE: FR TIME: 20:04:35 GRID ID: 1923 ",
        "ADDR:8721 MADISON BLVD",
        "CITY:MADISON",
        "PLACE:RADISSON HOTEL",
        "ID:R131342",
        "CALL:FIRE/RESCUE",
        "TIME:20:04:35",
        "MAP:1923");

    doTest("T23",
        "(IPS I/Page Notification) Loc: 1600 BROWNS FERRY RD MAD: @BRADFORD HEALTH SERVICES EVT#: R131341 TYPE: M TIME: 17:00:32 GRID ID: 2008 ",
        "ADDR:1600 BROWNS FERRY RD",
        "CITY:MADISON",
        "PLACE:BRADFORD HEALTH SERVICES",
        "ID:R131341",
        "CALL:MEDICAL",
        "TIME:17:00:32",
        "MAP:2008");

    doTest("T24",
        "(IPS I/Page Notification) Loc: DAILY FSA SYSTEM TEST EVT#: R130471 TYPE: TEST TIME: 23:13:21 GRID ID:  ",
        "ADDR:DAILY FSA SYSTEM TEST",
        "ID:R130471",
        "CALL:TEST",
        "TIME:23:13:21");

    doTest("T25",
        "(IPS I/Page Notification) Loc: 12266 COUNTY LINE RD LIME MAD: @MFD3 EVT#: R131333 TYPE: TEST TIME: 20:08:50 GRID ID: 1141 ",
        "ADDR:12266 COUNTY LINE RD",
        "CITY:MADISON",
        "PLACE:MFD3",
        "ID:R131333",
        "CALL:TEST",
        "TIME:20:08:50",
        "MAP:1141");

    doTest("T26",
        "(IPS I/Page Notification) Loc: 103 MOSS WOOD CT MAD: @PSI: JAMES \"MONTE\" LONG RESIDENCE EVT#: M13025932 TYPE: UNK TIME: 19:49:51 GRID ID: 1226 ",
        "ADDR:103 MOSS WOOD CT",
        "CITY:MADISON",
        "PLACE:PSI: JAMES \"MONTE\" LONG RESIDENCE",
        "ID:M13025932",
        "CALL:UNK",
        "TIME:19:49:51",
        "MAP:1226");

    doTest("T27",
        "(IPS I/Page Notification) Loc: 107 ARLINGTON DR MAD: @MADISON VILLAGE EVT#: M13025927 TYPE: RP TIME: 19:16:35 GRID ID:  ",
        "ADDR:107 ARLINGTON DR",
        "CITY:MADISON",
        "PLACE:MADISON VILLAGE",
        "ID:M13025927",
        "CALL:RP",
        "TIME:19:16:35");

    doTest("T28",
        "(IPS I/Page Notification) Loc: 10446 COUNTY LINE RD LIME: @SOUTHERN CONVENTION CENTER EVT#: M13025925 TYPE: TS TIME: 18:56:45 GRID ID:  ",
        "ADDR:10446 COUNTY LINE RD",
        "CITY:LIMESTONE COUNTY",
        "PLACE:SOUTHERN CONVENTION CENTER",
        "ID:M13025925",
        "CALL:TS",
        "TIME:18:56:45");

    doTest("T29",
        "(IPS I/Page Notification) Loc: @ASHBURY EVT#: M13025923 TYPE: RP TIME: 18:48:08 GRID ID:  ",
        "ADDR:@ASHBURY",
        "ID:M13025923",
        "CALL:RP",
        "TIME:18:48:08");

    doTest("T30",
        "(IPS I/Page Notification) Loc: MADISON BLVD/COUNTY LINE RD HSV EVT#: M13025920 TYPE: TS TIME: 18:31:13 GRID ID:  ",
        "ADDR:MADISON BLVD & COUNTY LINE RD",
        "CITY:HUNTSVILLE",
        "ID:M13025920",
        "CALL:TS",
        "TIME:18:31:13");

    doTest("T31",
        "(IPS I/Page Notification) Loc: 107 ARLINGTON DR MAD: @MADISON VILLAGE EVT#: M13025919 TYPE: RP TIME: 18:24:09 GRID ID:  ",
        "ADDR:107 ARLINGTON DR",
        "CITY:MADISON",
        "PLACE:MADISON VILLAGE",
        "ID:M13025919",
        "CALL:RP",
        "TIME:18:24:09");

    doTest("T32",
        "(IPS I/Page Notification) Loc: 3714 SULLIVAN ST MAD: @OREILLYS EVT#: M13025906 TYPE: MVA TIME: 16:14:49 GRID ID: 1923 ",
        "ADDR:3714 SULLIVAN ST",
        "CITY:MADISON",
        "PLACE:OREILLYS",
        "ID:M13025906",
        "CALL:MVA",
        "TIME:16:14:49",
        "MAP:1923");

    doTest("T33",
        "(IPS I/Page Notification) Loc: 5827 OAKWOOD RD NW HSV: @911 CENTER EVT#: M13025904 TYPE: TEST TIME: 16:10:17 GRID ID: 1230 ",
        "ADDR:5827 OAKWOOD RD NW",
        "CITY:HUNTSVILLE",
        "PLACE:911 CENTER",
        "ID:M13025904",
        "CALL:TEST",
        "TIME:16:10:17",
        "MAP:1230");

  }
  
  @Test
  public void testCharlesRenegat() {

    doTest("T1",
        "(IPS I/Page Notification) Loc: 114 SHADY OAK LN MDCO EVT#: C1305871 TYPE: FR TIME: 13:21:05 GRID ID: 617",
        "ADDR:114 SHADY OAK LN",
        "CITY:MADISON COUNTY",
        "ID:C1305871",
        "CALL:FIRE/RESCUE",
        "TIME:13:21:05",
        "MAP:617");

  }
  
  public static void main(String[] args) {
    new ALMadisonCountyParserTest().generateTests("T1");
  }
}