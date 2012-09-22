package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Polk County, IA (Grimes Fire & Rescue)
Contact: angela brouwer <abrouwerdcg@gmail.com>
Sender: 777129998926

.... (Grimes) Location: 500 S JAMES ST GRIM: @SCHOOL - GRIM Type: STILL VEHICLE Caller:  Time: 19:47:24
.... (Grimes) Location: 101 SE DESTINATION DR GRIMES Type: MEDICAL  Caller: GRIMES FAMILY PHYSICIANS Time: 10:54:07
.... (Grimes) Location: 200 SW BROOKSIDE DR GRIM,111 Type: MEDICAL  Caller: KENNYBROOK VILLAGE Time: 13:42:46
.... (Grimes) Location: 5555 NW 55TH AVE JOHN: @CHILDSERVE - JOHN Type: COMMFIRE ALARM Caller: ADT/DBI Time: 17:01:43
.... (Grimes) Location: 2555 W 1ST ST GRIM: @DALLAS CENTER GRIMES HIGH SCHOOL - GRIM Type: COMMFIRE ALARM Caller: ADT Time: 20:37:32

Contact: Rich Davis <med1c@msn.com>
Sender: messaging@iamresponding.com
(PCFD) Location: 6015 NW 62ND AVE JOHN: @JOFD Type: MA MEDICAL Time: 13:46:40

Contact: Tad Watson <tad.watson84@yahoo.com>, 5152400762@vtext.com
(WHTS FD) Location: 6750 SCHOOL ST WIND: @WINDSOR PARK TOWNHOMES - WIND Type: MEDICAL  Caller:  Time: 19:43:52
(WHTS FD) Location: 73RD ST/UNIVERSITY AVE WIND Type: RESCUE UNK Caller:  Time: 16:25:27

Contact: support@active911.com
[CAD] Location: 819 WREN DR ALTO Type: MEDICAL  Caller: MCGINNIS,WILLIAM & DORIS Time: 15:48:02\n
[CAD] Location: 2ND AVE SW/5TH ST SW ALTO Type: RESCUE PIA Caller: REBER,JEFF Time: 16:05:56\n
[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n
[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n
[CAD] Location: 55 N HAWTHORN DR ALTO Type: MEDICAL  Caller: ELLIS,JEREMY Time: 19:49:36\n
[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n
[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n
[CAD] Location: 726 8TH ST SE ALTO,305: @CENTENNIAL PLACE APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 23:27:05\n
[CAD] Location: 407 3RD AVE SE ALTO Type: MEDICAL  Caller: VERHEUL,CHARLES B Time: 07:20:49\n
[CAD] Location: 912 8TH ST SW ALTO,22: @VENBURY TRAIL APARTMENTS - ALTO Type: MEDICAL  Caller: RITCHIE,LINDA Time: 07:16:40\n
[CAD] Location: 953 8TH AVE NW ALTO Type: MEDICAL  Caller: LIFELINE Time: 09:57:25\n
[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:04\n
[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:48\n
[CAD] Location: 5000-B NE HUBBELL RD DELA Type: RESCUE PIA Caller:  Time: 15:31:34\n
[CAD] Location: NE HUBBELL RD/NE 94TH AVE FRAN Type: RESCUE PIA Caller: ISP Time: 17:24:20\n
[CAD] Location: 507 13TH AVE SW ALTO: @LIONS PARK - ALTO Type: MEDICAL  Caller:  Time: 19:03:44\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 19:58:05\n
[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n
[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n
[CAD] Location: 114 CARTER ST SW MITC: @MITCHELL VILLAGE CARE CENTER - MITC Type: MEDICAL  Caller: MITCHELL VILLAGE CARE CENTER Time: 12:05:24\n
[CAD] Location: 200 6TH ST SW ALTO Type: STILL WIRES Caller:  Time: 13:41:01\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller:  Time: 16:33:24\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n
[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n
[CAD] Location: 950 VENBURY DR ALTO: @ALFD Type: MEDICAL  Caller:  Time: 17:15:58\n
[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:23:40\n
[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:24:35\n
[CAD] Location: 5285 NE MITCHELL DR BEAV Type: MEDICAL  Caller: BILLINGS,JO Time: 21:31:04\n
[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n
[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n
[CAD] Location: 1123 GREENWAY CT ALTO,B: @TRIPLE CROWN APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 05:11:37\n
[CAD] Location: 916 13TH STREET CIR SW ALTO Type: MEDICAL  Caller: LOZANO, NICHOLE Time: 09:12:25\n
[CAD] Location: 101 N HAWTHORN DR ALTO Type: RESDFIRE ASSIGN Caller:  Time: 11:23:59\n
[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n
[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n
[CAD] Location: 3231 ADVENTURELAND DR ALTO: @FLYING J - ALTO Type: MEDICAL  Caller: DEDENBERG,GREG Time: 05:25:19\n
[CAD] Location: 542 14TH AVE NW ALTO Type: MEDICAL  Caller:  Time: 07:04:27\n
[CAD] Location: 1006 6TH ST NW ALTO Type: MEDICAL  Caller: MINICK, SMITH Time: 07:56:13\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 10:02:39\n
[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 21:15:43\n
[CAD] Type: RESCUE PIA Caller: VERIZON Time: 07:12:39\n
[CAD] Location: 3178 W 148TH ST S MITC Type: MEDICAL  Caller: JOHNSON,PAM Time: 08:43:40\n

 */

public class IAPolkCountyParserTest extends BaseParserTest {
  
  public IAPolkCountyParserTest() {
    setParser(new IAPolkCountyParser(), "POLK COUNTY", "IA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        ".... (Grimes) Location: 500 S JAMES ST GRIM: @SCHOOL - GRIM Type: STILL VEHICLE Caller:  Time: 19:47:24",
        "SRC:Grimes",
        "ADDR:500 S JAMES ST",
        "CITY:GRIMES",
        "CALL:STILL VEHICLE",
        "PLACE:SCHOOL",
        "TIME:19:47:24");

    doTest("T2",
        ".... (Grimes) Location: 101 SE DESTINATION DR GRIMES Type: MEDICAL  Caller: GRIMES FAMILY PHYSICIANS Time: 10:54:07",
        "SRC:Grimes",
        "ADDR:101 SE DESTINATION DR",
        "CITY:GRIMES",
        "CALL:MEDICAL",
        "PLACE:GRIMES FAMILY PHYSICIANS",
        "TIME:10:54:07");

    doTest("T3",
        ".... (Grimes) Location: 200 SW BROOKSIDE DR GRIM,111 Type: MEDICAL  Caller: KENNYBROOK VILLAGE Time: 13:42:46",
        "SRC:Grimes",
        "ADDR:200 SW BROOKSIDE DR",
        "APT:111",
        "CITY:GRIMES",
        "CALL:MEDICAL",
        "PLACE:KENNYBROOK VILLAGE",
        "TIME:13:42:46");

    doTest("T4",
        ".... (Grimes) Location: 5555 NW 55TH AVE JOHN: @CHILDSERVE - JOHN Type: COMMFIRE ALARM Caller: ADT/DBI Time: 17:01:43",
        "SRC:Grimes",
        "ADDR:5555 NW 55TH AVE",
        "CITY:JOHNSTON",
        "CALL:COMMFIRE ALARM",
        "PLACE:CHILDSERVE / ADT/DBI",
        "TIME:17:01:43");

    doTest("T5",
        ".... (Grimes) Location: 2555 W 1ST ST GRIM: @DALLAS CENTER GRIMES HIGH SCHOOL - GRIM Type: COMMFIRE ALARM Caller: ADT Time: 20:37:32",
        "SRC:Grimes",
        "ADDR:2555 W 1ST ST",
        "CITY:GRIMES",
        "CALL:COMMFIRE ALARM",
        "PLACE:DALLAS CENTER GRIMES HIGH SCHOOL / ADT",
        "TIME:20:37:32");

  }
  
  @Test
  public void testRichardDavis() {

    doTest("T1",
        "(PCFD) Location: 6015 NW 62ND AVE JOHN: @JOFD Type: MA MEDICAL Time: 13:46:40",
        "SRC:PCFD",
        "ADDR:6015 NW 62ND AVE",
        "CITY:JOHNSTON",
        "CALL:MA MEDICAL",
        "PLACE:JOFD",
        "TIME:13:46:40");

  }
  
  @Test
  public void testTadWatson() {

    doTest("T1",
        "(WHTS FD) Location: 6750 SCHOOL ST WIND: @WINDSOR PARK TOWNHOMES - WIND Type: MEDICAL  Caller:  Time: 19:43:52",
        "SRC:WHTS FD",
        "ADDR:6750 SCHOOL ST",
        "CITY:WINDSOR HEIGHTS",
        "CALL:MEDICAL",
        "PLACE:WINDSOR PARK TOWNHOMES",
        "TIME:19:43:52");

    doTest("T2",
        "(WHTS FD) Location: 73RD ST/UNIVERSITY AVE WIND Type: RESCUE UNK Caller:  Time: 16:25:27",
        "SRC:WHTS FD",
        "ADDR:73RD ST & UNIVERSITY AVE",
        "CITY:WINDSOR HEIGHTS",
        "CALL:RESCUE UNK",
        "TIME:16:25:27");

  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[CAD] Location: 819 WREN DR ALTO Type: MEDICAL  Caller: MCGINNIS,WILLIAM & DORIS Time: 15:48:02\n",
        "SRC:CAD",
        "ADDR:819 WREN DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:MCGINNIS,WILLIAM & DORIS",
        "TIME:15:48:02");

    doTest("T2",
        "[CAD] Location: 2ND AVE SW/5TH ST SW ALTO Type: RESCUE PIA Caller: REBER,JEFF Time: 16:05:56\n",
        "SRC:CAD",
        "ADDR:2ND AVE SW & 5TH ST SW",
        "CITY:ALTOONA",
        "CALL:RESCUE PIA",
        "PLACE:REBER,JEFF",
        "TIME:16:05:56");

    doTest("T3",
        "[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n",
        "SRC:CAD",
        "ADDR:147 I80 WB HWY",
        "MADDR:147 I 80",
        "CITY:BEAVER TWP",
        "CALL:MEDICAL",
        "PLACE:REST AREA WESTBOUND / ISP",
        "TIME:16:10:28");

    doTest("T4",
        "[CAD] Location: 147 I80 WB HWY BEAV: @REST AREA WESTBOUND - BEAV Type: MEDICAL  Caller: ISP Time: 16:10:28\n",
        "SRC:CAD",
        "ADDR:147 I80 WB HWY",
        "MADDR:147 I 80",
        "CITY:BEAVER TWP",
        "CALL:MEDICAL",
        "PLACE:REST AREA WESTBOUND / ISP",
        "TIME:16:10:28");

    doTest("T5",
        "[CAD] Location: 55 N HAWTHORN DR ALTO Type: MEDICAL  Caller: ELLIS,JEREMY Time: 19:49:36\n",
        "SRC:CAD",
        "ADDR:55 N HAWTHORN DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:ELLIS,JEREMY",
        "TIME:19:49:36");

    doTest("T6",
        "[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n",
        "SRC:CAD",
        "ADDR:2100-B 2ND AVE SE",
        "MADDR:2100 2ND AVE SE",
        "CITY:ALTOONA",
        "CALL:INVESTIGATION ALARM",
        "TIME:20:57:05");

    doTest("T7",
        "[CAD] Location: 2100-B 2ND AVE SE ALTO Type: INVESTIGATION ALARM Caller:  Time: 20:57:05\n",
        "SRC:CAD",
        "ADDR:2100-B 2ND AVE SE",
        "MADDR:2100 2ND AVE SE",
        "CITY:ALTOONA",
        "CALL:INVESTIGATION ALARM",
        "TIME:20:57:05");

    doTest("T8",
        "[CAD] Location: 726 8TH ST SE ALTO,305: @CENTENNIAL PLACE APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 23:27:05\n",
        "SRC:CAD",
        "ADDR:726 8TH ST SE",
        "APT:305",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:CENTENNIAL PLACE APARTMENTS - ALTO",
        "TIME:23:27:05");

    doTest("T9",
        "[CAD] Location: 407 3RD AVE SE ALTO Type: MEDICAL  Caller: VERHEUL,CHARLES B Time: 07:20:49\n",
        "SRC:CAD",
        "ADDR:407 3RD AVE SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:VERHEUL,CHARLES B",
        "TIME:07:20:49");

    doTest("T10",
        "[CAD] Location: 912 8TH ST SW ALTO,22: @VENBURY TRAIL APARTMENTS - ALTO Type: MEDICAL  Caller: RITCHIE,LINDA Time: 07:16:40\n",
        "SRC:CAD",
        "ADDR:912 8TH ST SW",
        "APT:22",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:VENBURY TRAIL APARTMENTS - ALTO / RITCHIE,LINDA",
        "TIME:07:16:40");

    doTest("T11",
        "[CAD] Location: 953 8TH AVE NW ALTO Type: MEDICAL  Caller: LIFELINE Time: 09:57:25\n",
        "SRC:CAD",
        "ADDR:953 8TH AVE NW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:LIFELINE",
        "TIME:09:57:25");

    doTest("T12",
        "[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:04\n",
        "SRC:CAD",
        "ADDR:500 5TH AVE SW",
        "APT:8D",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE VILLAGE OF ALTOONA - ALTO / WILLIAMS, BILLY",
        "TIME:10:30:04");

    doTest("T13",
        "[CAD] Location: 500 5TH AVE SW ALTO,8D: @PRAIRIE VILLAGE OF ALTOONA - ALTO Type: MEDICAL  Caller: WILLIAMS, BILLY Time: 10:30:48\n",
        "SRC:CAD",
        "ADDR:500 5TH AVE SW",
        "APT:8D",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE VILLAGE OF ALTOONA - ALTO / WILLIAMS, BILLY",
        "TIME:10:30:48");

    doTest("T14",
        "[CAD] Location: 5000-B NE HUBBELL RD DELA Type: RESCUE PIA Caller:  Time: 15:31:34\n",
        "SRC:CAD",
        "ADDR:5000-B NE HUBBELL RD", // <<< Google says this is Hubbell Ave
        "MADDR:5000 NE HUBBELL RD",
        "CITY:DELAWARE TWP",
        "CALL:RESCUE PIA",
        "TIME:15:31:34");

    doTest("T15",
        "[CAD] Location: NE HUBBELL RD/NE 94TH AVE FRAN Type: RESCUE PIA Caller: ISP Time: 17:24:20\n",
        "SRC:CAD",
        "ADDR:NE HUBBELL RD & NE 94TH AVE",
        "CITY:FRANKLIN TWP",
        "CALL:RESCUE PIA",
        "PLACE:ISP",
        "TIME:17:24:20");

    doTest("T16",
        "[CAD] Location: 507 13TH AVE SW ALTO: @LIONS PARK - ALTO Type: MEDICAL  Caller:  Time: 19:03:44\n",
        "SRC:CAD",
        "ADDR:507 13TH AVE SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:LIONS PARK",
        "TIME:19:03:44");

    doTest("T17",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 19:58:05\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE MEADOWS",
        "TIME:19:58:05");

    doTest("T18",
        "[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n",
        "SRC:CAD",
        "ADDR:612 5TH AVE SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:10:09:41");

    doTest("T19",
        "[CAD] Location: 612 5TH AVE SE ALTO Type: MEDICAL  Caller:  Time: 10:09:41\n",
        "SRC:CAD",
        "ADDR:612 5TH AVE SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:10:09:41");

    doTest("T20",
        "[CAD] Location: 114 CARTER ST SW MITC: @MITCHELL VILLAGE CARE CENTER - MITC Type: MEDICAL  Caller: MITCHELL VILLAGE CARE CENTER Time: 12:05:24\n",
        "SRC:CAD",
        "ADDR:114 CARTER ST SW",
        "CITY:MITCHELLVILLE",
        "CALL:MEDICAL",
        "PLACE:MITCHELL VILLAGE CARE CENTER / MITCHELL VILLAGE CARE CENTER",
        "TIME:12:05:24");

    doTest("T21",
        "[CAD] Location: 200 6TH ST SW ALTO Type: STILL WIRES Caller:  Time: 13:41:01\n",
        "SRC:CAD",
        "ADDR:200 6TH ST SW",
        "CITY:ALTOONA",
        "CALL:STILL WIRES",
        "TIME:13:41:01");

    doTest("T22",
        "[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller:  Time: 16:33:24\n",
        "SRC:CAD",
        "ADDR:305 9TH ST SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:16:33:24");

    doTest("T23",
        "[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n",
        "SRC:CAD",
        "ADDR:305 9TH ST SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:MARY",
        "TIME:16:34:34");

    doTest("T24",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:CASINO / SECURITY",
        "TIME:16:38:27");

    doTest("T25",
        "[CAD] Location: 305 9TH ST SE ALTO Type: MEDICAL  Caller: MARY Time: 16:34:34\n",
        "SRC:CAD",
        "ADDR:305 9TH ST SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:MARY",
        "TIME:16:34:34");

    doTest("T26",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @CASINO - ALTO Type: MEDICAL  Caller: SECURITY Time: 16:38:27\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:CASINO / SECURITY",
        "TIME:16:38:27");

    doTest("T27",
        "[CAD] Location: 950 VENBURY DR ALTO: @ALFD Type: MEDICAL  Caller:  Time: 17:15:58\n",
        "SRC:CAD",
        "ADDR:950 VENBURY DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:ALFD",
        "TIME:17:15:58");

    doTest("T28",
        "[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:23:40\n",
        "SRC:CAD",
        "ADDR:2719 14TH ST SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:17:23:40");

    doTest("T29",
        "[CAD] Location: 2719 14TH ST SW ALTO Type: MEDICAL  Caller:  Time: 17:24:35\n",
        "SRC:CAD",
        "ADDR:2719 14TH ST SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:17:24:35");

    doTest("T30",
        "[CAD] Location: 5285 NE MITCHELL DR BEAV Type: MEDICAL  Caller: BILLINGS,JO Time: 21:31:04\n",
        "SRC:CAD",
        "ADDR:5285 NE MITCHELL DR",
        "CITY:BEAVER TWP",
        "CALL:MEDICAL",
        "PLACE:BILLINGS,JO",
        "TIME:21:31:04");

    doTest("T31",
        "[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n",
        "SRC:CAD",
        "ADDR:1022 8TH ST SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:23:21:42");

    doTest("T32",
        "[CAD] Location: 1022 8TH ST SE ALTO Type: MEDICAL  Caller:  Time: 23:21:42\n",
        "SRC:CAD",
        "ADDR:1022 8TH ST SE",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:23:21:42");

    doTest("T33",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE MEADOWS",
        "TIME:23:25:27");

    doTest("T34",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller:  Time: 23:25:27\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE MEADOWS",
        "TIME:23:25:27");

    doTest("T35",
        "[CAD] Location: 1123 GREENWAY CT ALTO,B: @TRIPLE CROWN APARTMENTS - ALTO Type: MEDICAL  Caller:  Time: 05:11:37\n",
        "SRC:CAD",
        "ADDR:1123 GREENWAY CT",
        "APT:B",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:TRIPLE CROWN APARTMENTS - ALTO",
        "TIME:05:11:37");

    doTest("T36",
        "[CAD] Location: 916 13TH STREET CIR SW ALTO Type: MEDICAL  Caller: LOZANO, NICHOLE Time: 09:12:25\n",
        "SRC:CAD",
        "ADDR:916 13TH STREET CIR SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:LOZANO, NICHOLE",
        "TIME:09:12:25");

    doTest("T37",
        "[CAD] Location: 101 N HAWTHORN DR ALTO Type: RESDFIRE ASSIGN Caller:  Time: 11:23:59\n",
        "SRC:CAD",
        "ADDR:101 N HAWTHORN DR",
        "CITY:ALTOONA",
        "CALL:RESDFIRE ASSIGN",
        "TIME:11:23:59");

    doTest("T38",
        "[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n",
        "SRC:CAD",
        "ADDR:3501 8TH ST SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:WALMART",
        "TIME:11:35:05");

    doTest("T39",
        "[CAD] Location: 3501 8TH ST SW ALTO: @WALMART - ALTO Type: MEDICAL  Caller:  Time: 11:35:05\n",
        "SRC:CAD",
        "ADDR:3501 8TH ST SW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:WALMART",
        "TIME:11:35:05");

    doTest("T40",
        "[CAD] Location: 3231 ADVENTURELAND DR ALTO: @FLYING J - ALTO Type: MEDICAL  Caller: DEDENBERG,GREG Time: 05:25:19\n",
        "SRC:CAD",
        "ADDR:3231 ADVENTURELAND DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:FLYING J / DEDENBERG,GREG",
        "TIME:05:25:19");

    doTest("T41",
        "[CAD] Location: 542 14TH AVE NW ALTO Type: MEDICAL  Caller:  Time: 07:04:27\n",
        "SRC:CAD",
        "ADDR:542 14TH AVE NW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "TIME:07:04:27");

    doTest("T42",
        "[CAD] Location: 1006 6TH ST NW ALTO Type: MEDICAL  Caller: MINICK, SMITH Time: 07:56:13\n",
        "SRC:CAD",
        "ADDR:1006 6TH ST NW",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:MINICK, SMITH",
        "TIME:07:56:13");

    doTest("T43",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 10:02:39\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE MEADOWS / PRAIRIE MEADOWS RACETRACK AN",
        "TIME:10:02:39");

    doTest("T44",
        "[CAD] Location: 1 PRAIRIE MEADOWS DR ALTO: @PRAIRIE MEADOWS - ALTO Type: MEDICAL  Caller: PRAIRIE MEADOWS RACETRACK AN Time: 21:15:43\n",
        "SRC:CAD",
        "ADDR:1 PRAIRIE MEADOWS DR",
        "CITY:ALTOONA",
        "CALL:MEDICAL",
        "PLACE:PRAIRIE MEADOWS / PRAIRIE MEADOWS RACETRACK AN",
        "TIME:21:15:43");

    doTest("T45",
        "[CAD] Location: 3178 W 148TH ST S MITC Type: MEDICAL  Caller: JOHNSON,PAM Time: 08:43:40\n",
        "SRC:CAD",
        "ADDR:3178 W 148TH ST S",
        "CITY:MITCHELLVILLE",
        "CALL:MEDICAL",
        "PLACE:JOHNSON,PAM",
        "TIME:08:43:40");
   
  }
  
  public static void main(String[] args) {
    new IAPolkCountyParserTest().generateTests("T1");
  }
}