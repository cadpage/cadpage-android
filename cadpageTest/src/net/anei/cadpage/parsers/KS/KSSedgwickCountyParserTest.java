package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Sedgwick County, KS
Contact: Active911
Agency name: Derby Fire Department
Location: Derby, KS, United States
Sender: cad_admin@sedgwick.gov

(CommandPoint CAD Message) [10:37:57 05-15-2013] *D 14011 EXFER/731 N KLEIN CR #410 ,DE (DERBY HEALTH AND REHAB) M21 
(CommandPoint CAD Message) [20:43:11 05-14-2013] *D 14011 EHEMOR/731 N KLEIN CR #413 ,DE (DERBY HEALTH AND REHAB) M21 
(CommandPoint CAD Message) [16:56:38 05-14-2013] *D 14008 ESICK/801 E KAY ST #234B ,DE M21 
(CommandPoint CAD Message) [11:38:33 05-14-2013] *D 14004 ESICK/616 N MULBERRY RD ,DE M21 
(CommandPoint CAD Message) [11:35:29 05-14-2013] *E 24004 COALM/616 N MULBERRY RD ,DE 
(CommandPoint CAD Message) [10:52:57 05-14-2013] *D 14004 ESICK/1631 E BRENDONWOOD RD ,DE M36 
(CommandPoint CAD Message) [09:35:12 05-14-2013] *D 14004 EDIABE/1601 E WALNUT GROVE RD ,DE M36 
(CommandPoint CAD Message) [09:19:29 05-14-2013] *D 14004 ECHEST/1701 E WALNUT GROVE RD #4 ,DE (VINTAGE PLACE) M21 
(CommandPoint CAD Message) [06:15:16 05-14-2013] *D 14001 ESICK/2025 N BURNING TREE RD ,DE M21 
(CommandPoint CAD Message) [22:13:49 05-13-2013] *D 14011 ESICK/731 N KLEIN CR #114A ,DE (DERBY HEALTH AND REHAB) M32 
(CommandPoint CAD Message) [19:28:50 05-13-2013] *D 14004 EUNKE/DERBY FD 82 @ 1401 N ROCK RD ,DE M21 
(CommandPoint CAD Message) [18:38:02 05-13-2013] *D 14008 ETRAUM/801 E KAY ST #234B ,DE M21 
(CommandPoint CAD Message) [13:32:16 05-13-2013] *D 14009 ECHEST/250 W RED POWELL DR ,DE M21 
(CommandPoint CAD Message) [09:46:46 05-13-2013] *E 24011 SYSR/1433 N HAMILTON DR ,DE 
(CommandPoint CAD Message) [08:43:01 05-13-2013] *D 14004 E48/E MEADOWLARK BL  / N ROCK RD ,DE <1799,1500> M21 
(CommandPoint CAD Message) [08:42:43 05-13-2013] *E 4004 48/E MEADOWLARK BL  / N ROCK RD ,DE <1799,1500> 
(CommandPoint CAD Message) [19:27:57 05-12-2013] *D 14012 ESICK/400 N ROCK RD ,DE (CASEY'S GENERAL) M21 
(CommandPoint CAD Message) [17:59:08 05-12-2013] *D 14005 EUNKE/208 E EMMA ST ,DE M21 
(CommandPoint CAD Message) [13:12:17 05-12-2013] *D 14005 EHEMOR/807 S BUCKNER ST ,DE M21 
(CommandPoint CAD Message) [11:17:20 05-12-2013] *D 14011 EUNCON/1200 N ROCK RD ,DE M21 

Contact: Active911
Agency name: Colwich Fire Department
Location: Colwich, KS, United States
Sender: cad_admin@sedgwick.gov 

(CommandPoint CAD Message) [08:19:35 05-10-2013] *D 22008 FUNCON/S 5TH ST  / W KANSAS AV ,CO <300,498> COFIRE 
(CommandPoint CAD Message) [12:54:18 05-07-2013] *D 22008 FDIFFB/401 S MARIAN ST ,CO (COLWICH GRADE SCHL) COFIRE 
(CommandPoint CAD Message) [19:56:29 04-28-2013] *D 22008 HOUSE/421 W WICHITA AV ,CO COFIRE 
(CommandPoint CAD Message) [07:02:01 04-26-2013] *D 22008 FSTROK/131 N 5TH ST ,CO COFIRE 
(CommandPoint CAD Message) [14:49:25 04-21-2013] *D 22008 FFALL/E CHICAGO AV  / S 1ST ST ,CO <100,400> COFIRE 
(CommandPoint CAD Message) [12:46:58 04-17-2013] *D 22008 FFALL/442 S 3RD ST ,CO COFIRE 
(CommandPoint CAD Message) [02:32:00 04-13-2013] *D 22008 FDIFFB/S 6TH ST  / W CHICAGO AV ,CO <398,600> COFIRE 
(CommandPoint CAD Message) [01:35:05 04-11-2013] *D 23000 FSICK/6001 N 151ST ST W ,SC (GORDON EVANS-WESTAR) COFIRE SQ33 
(CommandPoint CAD Message) [18:19:06 04-10-2013] *D 22008 GASIN/412 S 6TH ST ,CO COFIRE 
(CommandPoint CAD Message) [05:43:24 04-10-2013] *D 23000 F48/W K96 HY  / N 151ST ST W ,SC <15198,7804> COFIRE SQ7 E33 
(CommandPoint CAD Message) [22:06:20 04-08-2013] *D 21430 ASSTP/N 151ST ST W  / W K96 HY ,SC <7798,15201> COFIRE 
(CommandPoint CAD Message) [20:49:38 04-08-2013] *D 21430 F48/N 151ST ST W  / W K96 HY ,SC <7798,15201> COFIRE 
(CommandPoint CAD Message) [09:23:48 04-03-2013] *D 22008 SYSB/310 S 5TH ST ,CO COFIRE 
(CommandPoint CAD Message) [15:09:13 04-01-2013] *D 22008 MSGF/COLWICH FIRE-EMS @ 116 N 3RD ST ,CO COFIRE 
(CommandPoint CAD Message) [11:22:28 03-27-2013] *D 22008 FUNCON/311 S 5TH ST ,CO COFIRE 
(CommandPoint CAD Message) [11:11:18 03-22-2013] *D 22008 UNKF/S 1ST ST  / E COLWICH AV ,CO <200,100> COFIRE 
(CommandPoint CAD Message) [09:44:18 03-21-2013] *D 23000 UNKF/6001 N 151ST ST W ,SC (GORDON EVANS-WESTAR) COFIRE T33 E33 
(CommandPoint CAD Message) [17:18:17 03-18-2013] *D 21305 SYSR/20505 W 37TH ST N ,SC COFIRE 
(CommandPoint CAD Message) [16:53:03 03-17-2013] *D 23003 FLOSTJ/3011 N LOMBARD LN ,SC COFIRE 
(CommandPoint CAD Message) [21:01:15 03-15-2013] *D 22008 UNKF/208 S COLORADO AV ,CO COFIRE 
(CommandPoint CAD Message) [20:07:25 03-14-2013] *D 22008 POLE/428 W KANSAS AV ,CO COFIRE 
(CommandPoint CAD Message) [18:56:50 03-14-2013] *D 23000 FIROUT/7501 N 119TH ST W ,SC COFIRE T33 SQ32 
(CommandPoint CAD Message) [18:46:38 03-14-2013] *D 21305 MISCF/20333 W 37TH ST N ,SC COFIRE 

Contact: Active911
Agency name: Andale Police
Location: Andale, KS, United States
Sender: cad_admin@sedgwick.gov 

(CommandPoint CAD Message) [17:54:52 05-15-2013] *D 2006 LOSTJ/401 N HUNTINGTON RD ,AN MZ11 
(CommandPoint CAD Message) [17:51:49 05-15-2013] *D 22006 FLOSTJ/401 N HUNTINGTON RD ,AN BCST 
(CommandPoint CAD Message) [17:47:32 05-15-2013] *D 2006 LOSTJ/401 N HUNTINGTON RD ,AN S12 
(CommandPoint CAD Message) [20:52:47 05-13-2013] *D 2006 TS/W ANDERSON AV / N MAIN ST ,AN <400 ,300 > AN5 
(CommandPoint CAD Message) [18:08:42 05-13-2013] *D 2006 TS/W 2ND AV / N ANDALE RD ,AN <100 ,200 > 1B 
(CommandPoint CAD Message) [23:43:26 05-11-2013] *D 2006 TS/500 W RUSH AV ,AN (ANDALE ELEM SCHOOL) AN1 
(CommandPoint CAD Message) [23:22:10 05-11-2013] *D 2008 AUD/341 E WICHITA AV ,CO AN1 
(CommandPoint CAD Message) [22:41:49 05-11-2013] *D 2006 CKCLUB/315 N MAIN ST ,AN AN1 
(CommandPoint CAD Message) [07:37:30 05-11-2013] *D 2006 SA/W 61ST ST N / N ANDALE RD ,AN <24798 ,498 > AN3 
(CommandPoint CAD Message) [23:56:17 05-10-2013] *D 2006 CKCLUB/313 N MAIN ST ,AN AN2 
(CommandPoint CAD Message) [22:21:33 05-10-2013] *D 2006 TS/ANDALE HIGH SCHOOL @ 700 W RUSH AV ,AN AN2 
(CommandPoint CAD Message) [15:31:51 05-10-2013] *D 2006 SC/500BLK N CRESTVIEW ST ,AN AN1 1B 
(CommandPoint CAD Message) [20:03:19 05-09-2013] *D 2006 MSGP/ANDALE PD @ 326 N MAIN ST ,AN AN5 
(CommandPoint CAD Message) [10:20:10 05-09-2013] *D 1446 ABDUCT/W 53RD ST N  / N 135TH ST W ,SC <13599,5400> AN1 
(CommandPoint CAD Message) [23:37:31 05-08-2013] *D 2006 TRAFIC/W RUSH AV  / N VEN JOHN ST ,AN <700,498> AN1 
(CommandPoint CAD Message) [18:48:47 05-07-2013] *D 1205 MSGP/25613 W 61ST ST N ,SC AN1 
(CommandPoint CAD Message) [18:45:41 05-07-2013] *D 2006 SC/W RUSH AV / N DALE ST ,AN <598 ,498 > AN1 
(CommandPoint CAD Message) [18:43:58 05-07-2013] *D 1205 MSGP/25613 W 61ST ST N ,SC AN1 
(CommandPoint CAD Message) [18:42:35 05-07-2013] *D 354 SC/N RUTGERS ST / W STERLING ST ,WI <2512 ,> AN1 
(CommandPoint CAD Message) [18:40:27 05-07-2013] *D 4032 SC/W RUSSELL ST / S BOXELDER AV ,MU <500 ,400 > AN1 

Contact: Active911
Agency name: Colwich Police Department
Location: Colwich, KS, United States
Sender: cad_admin@sedgwick.gov

(CommandPoint CAD Message) [08:19:35 05-10-2013] *D 22008 FUNCON/S 5TH ST  / W KANSAS AV ,CO <300,498> COFIRE 
(CommandPoint CAD Message) [12:54:18 05-07-2013] *D 22008 FDIFFB/401 S MARIAN ST ,CO (COLWICH GRADE SCHL) COFIRE 
(CommandPoint CAD Message) [19:56:29 04-28-2013] *D 22008 HOUSE/421 W WICHITA AV ,CO COFIRE 
(CommandPoint CAD Message) [07:02:01 04-26-2013] *D 22008 FSTROK/131 N 5TH ST ,CO COFIRE 
(CommandPoint CAD Message) [14:49:25 04-21-2013] *D 22008 FFALL/E CHICAGO AV  / S 1ST ST ,CO <100,400> COFIRE 
(CommandPoint CAD Message) [12:46:58 04-17-2013] *D 22008 FFALL/442 S 3RD ST ,CO COFIRE 
(CommandPoint CAD Message) [02:32:00 04-13-2013] *D 22008 FDIFFB/S 6TH ST  / W CHICAGO AV ,CO <398,600> COFIRE 

*/

public class KSSedgwickCountyParserTest extends BaseParserTest {
  
  public KSSedgwickCountyParserTest() {
    setParser(new KSSedgwickCountyParser(), "SEDGWICK COUNTY", "KS");
  }
  
  @Test
  public void testDerbyFireDepartment() {

    doTest("T1",
        "(CommandPoint CAD Message) [10:37:57 05-15-2013] *D 14011 EXFER/731 N KLEIN CR #410 ,DE (DERBY HEALTH AND REHAB) M21 ",
        "TIME:10:37:57",
        "DATE:05/15/2013",
        "ID:14011",
        "CODE:EXFER",
        "CALL:Emergency Medical Transfer - Non emergency",
        "ADDR:731 N KLEIN CR",
        "MADDR:731 N KLEIN CIR",
        "APT:410",
        "CITY:DERBY",
        "PLACE:DERBY HEALTH AND REHAB",
        "UNIT:M21");

    doTest("T2",
        "(CommandPoint CAD Message) [20:43:11 05-14-2013] *D 14011 EHEMOR/731 N KLEIN CR #413 ,DE (DERBY HEALTH AND REHAB) M21 ",
        "TIME:20:43:11",
        "DATE:05/14/2013",
        "ID:14011",
        "CODE:EHEMOR",
        "CALL:Hemorrhage",
        "ADDR:731 N KLEIN CR",
        "MADDR:731 N KLEIN CIR",
        "APT:413",
        "CITY:DERBY",
        "PLACE:DERBY HEALTH AND REHAB",
        "UNIT:M21");

    doTest("T3",
        "(CommandPoint CAD Message) [16:56:38 05-14-2013] *D 14008 ESICK/801 E KAY ST #234B ,DE M21 ",
        "TIME:16:56:38",
        "DATE:05/14/2013",
        "ID:14008",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:801 E KAY ST",
        "APT:234B",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T4",
        "(CommandPoint CAD Message) [11:38:33 05-14-2013] *D 14004 ESICK/616 N MULBERRY RD ,DE M21 ",
        "TIME:11:38:33",
        "DATE:05/14/2013",
        "ID:14004",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:616 N MULBERRY RD",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T5",
        "(CommandPoint CAD Message) [11:35:29 05-14-2013] *E 24004 COALM/616 N MULBERRY RD ,DE ",
        "TIME:11:35:29",
        "DATE:05/14/2013",
        "ID:24004",
        "CODE:COALM",
        "CALL:Carbon Monoxide Alarm",
        "ADDR:616 N MULBERRY RD",
        "CITY:DERBY");

    doTest("T6",
        "(CommandPoint CAD Message) [10:52:57 05-14-2013] *D 14004 ESICK/1631 E BRENDONWOOD RD ,DE M36 ",
        "TIME:10:52:57",
        "DATE:05/14/2013",
        "ID:14004",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:1631 E BRENDONWOOD RD",
        "CITY:DERBY",
        "UNIT:M36");

    doTest("T7",
        "(CommandPoint CAD Message) [09:35:12 05-14-2013] *D 14004 EDIABE/1601 E WALNUT GROVE RD ,DE M36 ",
        "TIME:09:35:12",
        "DATE:05/14/2013",
        "ID:14004",
        "CODE:EDIABE",
        "CALL:Diabetic Emergency",
        "ADDR:1601 E WALNUT GROVE RD",
        "CITY:DERBY",
        "UNIT:M36");

    doTest("T8",
        "(CommandPoint CAD Message) [09:19:29 05-14-2013] *D 14004 ECHEST/1701 E WALNUT GROVE RD #4 ,DE (VINTAGE PLACE) M21 ",
        "TIME:09:19:29",
        "DATE:05/14/2013",
        "ID:14004",
        "CODE:ECHEST",
        "CALL:Chest Pain",
        "ADDR:1701 E WALNUT GROVE RD",
        "APT:4",
        "CITY:DERBY",
        "PLACE:VINTAGE PLACE",
        "UNIT:M21");

    doTest("T9",
        "(CommandPoint CAD Message) [06:15:16 05-14-2013] *D 14001 ESICK/2025 N BURNING TREE RD ,DE M21 ",
        "TIME:06:15:16",
        "DATE:05/14/2013",
        "ID:14001",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:2025 N BURNING TREE RD",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T10",
        "(CommandPoint CAD Message) [22:13:49 05-13-2013] *D 14011 ESICK/731 N KLEIN CR #114A ,DE (DERBY HEALTH AND REHAB) M32 ",
        "TIME:22:13:49",
        "DATE:05/13/2013",
        "ID:14011",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:731 N KLEIN CR",
        "MADDR:731 N KLEIN CIR",
        "APT:114A",
        "CITY:DERBY",
        "PLACE:DERBY HEALTH AND REHAB",
        "UNIT:M32");

    doTest("T11",
        "(CommandPoint CAD Message) [19:28:50 05-13-2013] *D 14004 EUNKE/DERBY FD 82 @ 1401 N ROCK RD ,DE M21 ",
        "TIME:19:28:50",
        "DATE:05/13/2013",
        "ID:14004",
        "CODE:EUNKE",
        "CALL:Unknown Emergency",
        "ADDR:1401 N ROCK RD",
        "CITY:DERBY",
        "PLACE:DERBY FD 82",
        "UNIT:M21");

    doTest("T12",
        "(CommandPoint CAD Message) [18:38:02 05-13-2013] *D 14008 ETRAUM/801 E KAY ST #234B ,DE M21 ",
        "TIME:18:38:02",
        "DATE:05/13/2013",
        "ID:14008",
        "CODE:ETRAUM",
        "CALL:Trauma",
        "ADDR:801 E KAY ST",
        "APT:234B",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T13",
        "(CommandPoint CAD Message) [13:32:16 05-13-2013] *D 14009 ECHEST/250 W RED POWELL DR ,DE M21 ",
        "TIME:13:32:16",
        "DATE:05/13/2013",
        "ID:14009",
        "CODE:ECHEST",
        "CALL:Chest Pain",
        "ADDR:250 W RED POWELL DR",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T14",
        "(CommandPoint CAD Message) [09:46:46 05-13-2013] *E 24011 SYSR/1433 N HAMILTON DR ,DE ",
        "TIME:09:46:46",
        "DATE:05/13/2013",
        "ID:24011",
        "CODE:SYSR",
        "CALL:System Alarm on a Residence",
        "ADDR:1433 N HAMILTON DR",
        "CITY:DERBY");

    doTest("T15",
        "(CommandPoint CAD Message) [08:43:01 05-13-2013] *D 14004 E48/E MEADOWLARK BL  / N ROCK RD ,DE <1799,1500> M21 ",
        "TIME:08:43:01",
        "DATE:05/13/2013",
        "ID:14004",
        "CODE:E48",
        "CALL:E48",
        "ADDR:E MEADOWLARK BL & N ROCK RD",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T16",
        "(CommandPoint CAD Message) [08:42:43 05-13-2013] *E 4004 48/E MEADOWLARK BL  / N ROCK RD ,DE <1799,1500> ",
        "TIME:08:42:43",
        "DATE:05/13/2013",
        "ID:4004",
        "CODE:48",
        "CALL:48",
        "ADDR:E MEADOWLARK BL & N ROCK RD",
        "CITY:DERBY");

    doTest("T17",
        "(CommandPoint CAD Message) [19:27:57 05-12-2013] *D 14012 ESICK/400 N ROCK RD ,DE (CASEY'S GENERAL) M21 ",
        "TIME:19:27:57",
        "DATE:05/12/2013",
        "ID:14012",
        "CODE:ESICK",
        "CALL:Sick Person",
        "ADDR:400 N ROCK RD",
        "CITY:DERBY",
        "PLACE:CASEY'S GENERAL",
        "UNIT:M21");

    doTest("T18",
        "(CommandPoint CAD Message) [17:59:08 05-12-2013] *D 14005 EUNKE/208 E EMMA ST ,DE M21 ",
        "TIME:17:59:08",
        "DATE:05/12/2013",
        "ID:14005",
        "CODE:EUNKE",
        "CALL:Unknown Emergency",
        "ADDR:208 E EMMA ST",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T19",
        "(CommandPoint CAD Message) [13:12:17 05-12-2013] *D 14005 EHEMOR/807 S BUCKNER ST ,DE M21 ",
        "TIME:13:12:17",
        "DATE:05/12/2013",
        "ID:14005",
        "CODE:EHEMOR",
        "CALL:Hemorrhage",
        "ADDR:807 S BUCKNER ST",
        "CITY:DERBY",
        "UNIT:M21");

    doTest("T20",
        "(CommandPoint CAD Message) [11:17:20 05-12-2013] *D 14011 EUNCON/1200 N ROCK RD ,DE M21 ",
        "TIME:11:17:20",
        "DATE:05/12/2013",
        "ID:14011",
        "CODE:EUNCON",
        "CALL:Unconscious",
        "ADDR:1200 N ROCK RD",
        "CITY:DERBY",
        "UNIT:M21");

  }
  
  @Test
  public void testColwichFireDepartment() {

    doTest("T1",
        "(CommandPoint CAD Message) [08:19:35 05-10-2013] *D 22008 FUNCON/S 5TH ST  / W KANSAS AV ,CO <300,498> COFIRE ",
        "TIME:08:19:35",
        "DATE:05/10/2013",
        "ID:22008",
        "CODE:FUNCON",
        "CALL:Unconscious",
        "ADDR:S 5TH ST & W KANSAS AV",
        "MADDR:S 5TH ST & W KANSAS AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T2",
        "(CommandPoint CAD Message) [12:54:18 05-07-2013] *D 22008 FDIFFB/401 S MARIAN ST ,CO (COLWICH GRADE SCHL) COFIRE ",
        "TIME:12:54:18",
        "DATE:05/07/2013",
        "ID:22008",
        "CODE:FDIFFB",
        "CALL:Difficulty Breathing",
        "ADDR:401 S MARIAN ST",
        "CITY:COLWICH",
        "PLACE:COLWICH GRADE SCHL",
        "UNIT:COFIRE");

    doTest("T3",
        "(CommandPoint CAD Message) [19:56:29 04-28-2013] *D 22008 HOUSE/421 W WICHITA AV ,CO COFIRE ",
        "TIME:19:56:29",
        "DATE:04/28/2013",
        "ID:22008",
        "CODE:HOUSE",
        "CALL:House Fire",
        "ADDR:421 W WICHITA AV",
        "MADDR:421 W WICHITA AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T4",
        "(CommandPoint CAD Message) [07:02:01 04-26-2013] *D 22008 FSTROK/131 N 5TH ST ,CO COFIRE ",
        "TIME:07:02:01",
        "DATE:04/26/2013",
        "ID:22008",
        "CODE:FSTROK",
        "CALL:Stroke",
        "ADDR:131 N 5TH ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T5",
        "(CommandPoint CAD Message) [14:49:25 04-21-2013] *D 22008 FFALL/E CHICAGO AV  / S 1ST ST ,CO <100,400> COFIRE ",
        "TIME:14:49:25",
        "DATE:04/21/2013",
        "ID:22008",
        "CODE:FFALL",
        "CALL:Fall",
        "ADDR:E CHICAGO AV & S 1ST ST",
        "MADDR:E CHICAGO AVE & S 1ST ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T6",
        "(CommandPoint CAD Message) [12:46:58 04-17-2013] *D 22008 FFALL/442 S 3RD ST ,CO COFIRE ",
        "TIME:12:46:58",
        "DATE:04/17/2013",
        "ID:22008",
        "CODE:FFALL",
        "CALL:Fall",
        "ADDR:442 S 3RD ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T7",
        "(CommandPoint CAD Message) [02:32:00 04-13-2013] *D 22008 FDIFFB/S 6TH ST  / W CHICAGO AV ,CO <398,600> COFIRE ",
        "TIME:02:32:00",
        "DATE:04/13/2013",
        "ID:22008",
        "CODE:FDIFFB",
        "CALL:Difficulty Breathing",
        "ADDR:S 6TH ST & W CHICAGO AV",
        "MADDR:S 6TH ST & W CHICAGO AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T8",
        "(CommandPoint CAD Message) [01:35:05 04-11-2013] *D 23000 FSICK/6001 N 151ST ST W ,SC (GORDON EVANS-WESTAR) COFIRE SQ33 ",
        "TIME:01:35:05",
        "DATE:04/11/2013",
        "ID:23000",
        "CODE:FSICK",
        "CALL:Sick Person",
        "ADDR:6001 N 151ST ST W",
        "PLACE:GORDON EVANS-WESTAR",
        "UNIT:COFIRE SQ33");

    doTest("T9",
        "(CommandPoint CAD Message) [18:19:06 04-10-2013] *D 22008 GASIN/412 S 6TH ST ,CO COFIRE ",
        "TIME:18:19:06",
        "DATE:04/10/2013",
        "ID:22008",
        "CODE:GASIN",
        "CALL:Check Gas in a Building",
        "ADDR:412 S 6TH ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T10",
        "(CommandPoint CAD Message) [05:43:24 04-10-2013] *D 23000 F48/W K96 HY  / N 151ST ST W ,SC <15198,7804> COFIRE SQ7 E33 ",
        "TIME:05:43:24",
        "DATE:04/10/2013",
        "ID:23000",
        "CODE:F48",
        "CALL:F48",
        "ADDR:W K96 HY & N 151ST ST W",
        "MADDR:W STATE 96 & N 151ST ST W",
        "UNIT:COFIRE SQ7 E33");

    doTest("T11",
        "(CommandPoint CAD Message) [22:06:20 04-08-2013] *D 21430 ASSTP/N 151ST ST W  / W K96 HY ,SC <7798,15201> COFIRE ",
        "TIME:22:06:20",
        "DATE:04/08/2013",
        "ID:21430",
        "CODE:ASSTP",
        "CALL:Assist Law Enforcement",
        "ADDR:N 151ST ST W & W K96 HY",
        "MADDR:N 151ST ST W & W STATE 96",
        "UNIT:COFIRE");

    doTest("T12",
        "(CommandPoint CAD Message) [20:49:38 04-08-2013] *D 21430 F48/N 151ST ST W  / W K96 HY ,SC <7798,15201> COFIRE ",
        "TIME:20:49:38",
        "DATE:04/08/2013",
        "ID:21430",
        "CODE:F48",
        "CALL:F48",
        "ADDR:N 151ST ST W & W K96 HY",
        "MADDR:N 151ST ST W & W STATE 96",
        "UNIT:COFIRE");

    doTest("T13",
        "(CommandPoint CAD Message) [09:23:48 04-03-2013] *D 22008 SYSB/310 S 5TH ST ,CO COFIRE ",
        "TIME:09:23:48",
        "DATE:04/03/2013",
        "ID:22008",
        "CODE:SYSB",
        "CALL:System Alarm on a Business",
        "ADDR:310 S 5TH ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T14",
        "(CommandPoint CAD Message) [15:09:13 04-01-2013] *D 22008 MSGF/COLWICH FIRE-EMS @ 116 N 3RD ST ,CO COFIRE ",
        "TIME:15:09:13",
        "DATE:04/01/2013",
        "ID:22008",
        "CODE:MSGF",
        "CALL:Message for Fire Department",
        "ADDR:116 N 3RD ST",
        "CITY:COLWICH",
        "PLACE:COLWICH FIRE-EMS",
        "UNIT:COFIRE");

    doTest("T15",
        "(CommandPoint CAD Message) [11:22:28 03-27-2013] *D 22008 FUNCON/311 S 5TH ST ,CO COFIRE ",
        "TIME:11:22:28",
        "DATE:03/27/2013",
        "ID:22008",
        "CODE:FUNCON",
        "CALL:Unconscious",
        "ADDR:311 S 5TH ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T16",
        "(CommandPoint CAD Message) [11:11:18 03-22-2013] *D 22008 UNKF/S 1ST ST  / E COLWICH AV ,CO <200,100> COFIRE ",
        "TIME:11:11:18",
        "DATE:03/22/2013",
        "ID:22008",
        "CODE:UNKF",
        "CALL:Unknown Fire",
        "ADDR:S 1ST ST & E COLWICH AV",
        "MADDR:S 1ST ST & E COLWICH AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T17",
        "(CommandPoint CAD Message) [09:44:18 03-21-2013] *D 23000 UNKF/6001 N 151ST ST W ,SC (GORDON EVANS-WESTAR) COFIRE T33 E33 ",
        "TIME:09:44:18",
        "DATE:03/21/2013",
        "ID:23000",
        "CODE:UNKF",
        "CALL:Unknown Fire",
        "ADDR:6001 N 151ST ST W",
        "PLACE:GORDON EVANS-WESTAR",
        "UNIT:COFIRE T33 E33");

    doTest("T18",
        "(CommandPoint CAD Message) [17:18:17 03-18-2013] *D 21305 SYSR/20505 W 37TH ST N ,SC COFIRE ",
        "TIME:17:18:17",
        "DATE:03/18/2013",
        "ID:21305",
        "CODE:SYSR",
        "CALL:System Alarm on a Residence",
        "ADDR:20505 W 37TH ST N",
        "UNIT:COFIRE");

    doTest("T19",
        "(CommandPoint CAD Message) [16:53:03 03-17-2013] *D 23003 FLOSTJ/3011 N LOMBARD LN ,SC COFIRE ",
        "TIME:16:53:03",
        "DATE:03/17/2013",
        "ID:23003",
        "CODE:FLOSTJ",
        "CALL:Lost Juvenile",
        "ADDR:3011 N LOMBARD LN",
        "UNIT:COFIRE");

    doTest("T20",
        "(CommandPoint CAD Message) [21:01:15 03-15-2013] *D 22008 UNKF/208 S COLORADO AV ,CO COFIRE ",
        "TIME:21:01:15",
        "DATE:03/15/2013",
        "ID:22008",
        "CODE:UNKF",
        "CALL:Unknown Fire",
        "ADDR:208 S COLORADO AV",
        "MADDR:208 S COLORADO AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T21",
        "(CommandPoint CAD Message) [20:07:25 03-14-2013] *D 22008 POLE/428 W KANSAS AV ,CO COFIRE ",
        "TIME:20:07:25",
        "DATE:03/14/2013",
        "ID:22008",
        "CODE:POLE",
        "CALL:Pole on Fire",
        "ADDR:428 W KANSAS AV",
        "MADDR:428 W KANSAS AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T22",
        "(CommandPoint CAD Message) [18:56:50 03-14-2013] *D 23000 FIROUT/7501 N 119TH ST W ,SC COFIRE T33 SQ32 ",
        "TIME:18:56:50",
        "DATE:03/14/2013",
        "ID:23000",
        "CODE:FIROUT",
        "CALL:Check a fire that is out",
        "ADDR:7501 N 119TH ST W",
        "UNIT:COFIRE T33 SQ32");

    doTest("T23",
        "(CommandPoint CAD Message) [18:46:38 03-14-2013] *D 21305 MISCF/20333 W 37TH ST N ,SC COFIRE ",
        "TIME:18:46:38",
        "DATE:03/14/2013",
        "ID:21305",
        "CODE:MISCF",
        "CALL:Miscellaneous Service",
        "ADDR:20333 W 37TH ST N",
        "UNIT:COFIRE");

  }
  
  @Test
  public void testAndalePolice() {

    doTest("T1",
        "(CommandPoint CAD Message) [17:54:52 05-15-2013] *D 2006 LOSTJ/401 N HUNTINGTON RD ,AN MZ11 ",
        "TIME:17:54:52",
        "DATE:05/15/2013",
        "ID:2006",
        "CODE:LOSTJ",
        "CALL:Lost Juvenile",
        "ADDR:401 N HUNTINGTON RD",
        "CITY:ANDALE",
        "UNIT:MZ11");

    doTest("T2",
        "(CommandPoint CAD Message) [17:51:49 05-15-2013] *D 22006 FLOSTJ/401 N HUNTINGTON RD ,AN BCST ",
        "TIME:17:51:49",
        "DATE:05/15/2013",
        "ID:22006",
        "CODE:FLOSTJ",
        "CALL:Lost Juvenile",
        "ADDR:401 N HUNTINGTON RD",
        "CITY:ANDALE",
        "UNIT:BCST");

    doTest("T3",
        "(CommandPoint CAD Message) [17:47:32 05-15-2013] *D 2006 LOSTJ/401 N HUNTINGTON RD ,AN S12 ",
        "TIME:17:47:32",
        "DATE:05/15/2013",
        "ID:2006",
        "CODE:LOSTJ",
        "CALL:Lost Juvenile",
        "ADDR:401 N HUNTINGTON RD",
        "CITY:ANDALE",
        "UNIT:S12");

    doTest("T4",
        "(CommandPoint CAD Message) [20:52:47 05-13-2013] *D 2006 TS/W ANDERSON AV / N MAIN ST ,AN <400 ,300 > AN5 ",
        "TIME:20:52:47",
        "DATE:05/13/2013",
        "ID:2006",
        "CODE:TS",
        "CALL:TS",
        "ADDR:W ANDERSON AV & N MAIN ST",
        "MADDR:W ANDERSON AVE & N MAIN ST",
        "CITY:ANDALE",
        "UNIT:AN5");

    doTest("T5",
        "(CommandPoint CAD Message) [18:08:42 05-13-2013] *D 2006 TS/W 2ND AV / N ANDALE RD ,AN <100 ,200 > 1B ",
        "TIME:18:08:42",
        "DATE:05/13/2013",
        "ID:2006",
        "CODE:TS",
        "CALL:TS",
        "ADDR:W 2ND AV & N ANDALE RD",
        "MADDR:W 2ND AVE & N ANDALE RD",
        "CITY:ANDALE",
        "UNIT:1B");

    doTest("T6",
        "(CommandPoint CAD Message) [23:43:26 05-11-2013] *D 2006 TS/500 W RUSH AV ,AN (ANDALE ELEM SCHOOL) AN1 ",
        "TIME:23:43:26",
        "DATE:05/11/2013",
        "ID:2006",
        "CODE:TS",
        "CALL:TS",
        "ADDR:500 W RUSH AV",
        "MADDR:500 W RUSH AVE",
        "CITY:ANDALE",
        "PLACE:ANDALE ELEM SCHOOL",
        "UNIT:AN1");

    doTest("T7",
        "(CommandPoint CAD Message) [23:22:10 05-11-2013] *D 2008 AUD/341 E WICHITA AV ,CO AN1 ",
        "TIME:23:22:10",
        "DATE:05/11/2013",
        "ID:2008",
        "CODE:AUD",
        "CALL:Audible Alarm",
        "ADDR:341 E WICHITA AV",
        "MADDR:341 E WICHITA AVE",
        "CITY:COLWICH",
        "UNIT:AN1");

    doTest("T8",
        "(CommandPoint CAD Message) [22:41:49 05-11-2013] *D 2006 CKCLUB/315 N MAIN ST ,AN AN1 ",
        "TIME:22:41:49",
        "DATE:05/11/2013",
        "ID:2006",
        "CODE:CKCLUB",
        "CALL:Check a Club",
        "ADDR:315 N MAIN ST",
        "CITY:ANDALE",
        "UNIT:AN1");

    doTest("T9",
        "(CommandPoint CAD Message) [07:37:30 05-11-2013] *D 2006 SA/W 61ST ST N / N ANDALE RD ,AN <24798 ,498 > AN3 ",
        "TIME:07:37:30",
        "DATE:05/11/2013",
        "ID:2006",
        "CODE:SA",
        "CALL:System Alarm",
        "ADDR:W 61ST ST N & N ANDALE RD",
        "CITY:ANDALE",
        "UNIT:AN3");

    doTest("T10",
        "(CommandPoint CAD Message) [23:56:17 05-10-2013] *D 2006 CKCLUB/313 N MAIN ST ,AN AN2 ",
        "TIME:23:56:17",
        "DATE:05/10/2013",
        "ID:2006",
        "CODE:CKCLUB",
        "CALL:Check a Club",
        "ADDR:313 N MAIN ST",
        "CITY:ANDALE",
        "UNIT:AN2");

    doTest("T11",
        "(CommandPoint CAD Message) [22:21:33 05-10-2013] *D 2006 TS/ANDALE HIGH SCHOOL @ 700 W RUSH AV ,AN AN2 ",
        "TIME:22:21:33",
        "DATE:05/10/2013",
        "ID:2006",
        "CODE:TS",
        "CALL:TS",
        "ADDR:700 W RUSH AV",
        "MADDR:700 W RUSH AVE",
        "CITY:ANDALE",
        "PLACE:ANDALE HIGH SCHOOL",
        "UNIT:AN2");

    doTest("T12",
        "(CommandPoint CAD Message) [15:31:51 05-10-2013] *D 2006 SC/500BLK N CRESTVIEW ST ,AN AN1 1B ",
        "TIME:15:31:51",
        "DATE:05/10/2013",
        "ID:2006",
        "CODE:SC",
        "CALL:Suspicious Character",
        "ADDR:500BLK N CRESTVIEW ST",
        "MADDR:500 N CRESTVIEW ST",
        "CITY:ANDALE",
        "UNIT:AN1 1B");

    doTest("T13",
        "(CommandPoint CAD Message) [20:03:19 05-09-2013] *D 2006 MSGP/ANDALE PD @ 326 N MAIN ST ,AN AN5 ",
        "TIME:20:03:19",
        "DATE:05/09/2013",
        "ID:2006",
        "CODE:MSGP",
        "CALL:Message for Law Enforcement",
        "ADDR:326 N MAIN ST",
        "CITY:ANDALE",
        "PLACE:ANDALE PD",
        "UNIT:AN5");

    doTest("T14",
        "(CommandPoint CAD Message) [10:20:10 05-09-2013] *D 1446 ABDUCT/W 53RD ST N  / N 135TH ST W ,SC <13599,5400> AN1 ",
        "TIME:10:20:10",
        "DATE:05/09/2013",
        "ID:1446",
        "CODE:ABDUCT",
        "CALL:Abduction",
        "ADDR:W 53RD ST N & N 135TH ST W",
        "UNIT:AN1");

    doTest("T15",
        "(CommandPoint CAD Message) [23:37:31 05-08-2013] *D 2006 TRAFIC/W RUSH AV  / N VEN JOHN ST ,AN <700,498> AN1 ",
        "TIME:23:37:31",
        "DATE:05/08/2013",
        "ID:2006",
        "CODE:TRAFIC",
        "CALL:Traffic Incident",
        "ADDR:W RUSH AV & N VEN JOHN ST",
        "MADDR:W RUSH AVE & N VEN JOHN ST",
        "CITY:ANDALE",
        "UNIT:AN1");

    doTest("T16",
        "(CommandPoint CAD Message) [18:48:47 05-07-2013] *D 1205 MSGP/25613 W 61ST ST N ,SC AN1 ",
        "TIME:18:48:47",
        "DATE:05/07/2013",
        "ID:1205",
        "CODE:MSGP",
        "CALL:Message for Law Enforcement",
        "ADDR:25613 W 61ST ST N",
        "UNIT:AN1");

    doTest("T17",
        "(CommandPoint CAD Message) [18:45:41 05-07-2013] *D 2006 SC/W RUSH AV / N DALE ST ,AN <598 ,498 > AN1 ",
        "TIME:18:45:41",
        "DATE:05/07/2013",
        "ID:2006",
        "CODE:SC",
        "CALL:Suspicious Character",
        "ADDR:W RUSH AV & N DALE ST",
        "MADDR:W RUSH AVE & N DALE ST",
        "CITY:ANDALE",
        "UNIT:AN1");

    doTest("T18",
        "(CommandPoint CAD Message) [18:43:58 05-07-2013] *D 1205 MSGP/25613 W 61ST ST N ,SC AN1 ",
        "TIME:18:43:58",
        "DATE:05/07/2013",
        "ID:1205",
        "CODE:MSGP",
        "CALL:Message for Law Enforcement",
        "ADDR:25613 W 61ST ST N",
        "UNIT:AN1");

    doTest("T19",
        "(CommandPoint CAD Message) [18:42:35 05-07-2013] *D 354 SC/N RUTGERS ST / W STERLING ST ,WI <2512 ,> AN1 ",
        "TIME:18:42:35",
        "DATE:05/07/2013",
        "ID:354",
        "CODE:SC",
        "CALL:Suspicious Character",
        "ADDR:N RUTGERS ST & W STERLING ST",
        "CITY:WICHITA",
        "UNIT:AN1");

    doTest("T20",
        "(CommandPoint CAD Message) [18:40:27 05-07-2013] *D 4032 SC/W RUSSELL ST / S BOXELDER AV ,MU <500 ,400 > AN1 ",
        "TIME:18:40:27",
        "DATE:05/07/2013",
        "ID:4032",
        "CODE:SC",
        "CALL:Suspicious Character",
        "ADDR:W RUSSELL ST & S BOXELDER AV",
        "MADDR:W RUSSELL ST & S BOXELDER AVE",
        "CITY:MULVANE",
        "UNIT:AN1");

  }
  
  @Test
  public void testColwichPolice() {

    doTest("T1",
        "(CommandPoint CAD Message) [08:19:35 05-10-2013] *D 22008 FUNCON/S 5TH ST  / W KANSAS AV ,CO <300,498> COFIRE ",
        "TIME:08:19:35",
        "DATE:05/10/2013",
        "ID:22008",
        "CODE:FUNCON",
        "CALL:Unconscious",
        "ADDR:S 5TH ST & W KANSAS AV",
        "MADDR:S 5TH ST & W KANSAS AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T2",
        "(CommandPoint CAD Message) [12:54:18 05-07-2013] *D 22008 FDIFFB/401 S MARIAN ST ,CO (COLWICH GRADE SCHL) COFIRE ",
        "TIME:12:54:18",
        "DATE:05/07/2013",
        "ID:22008",
        "CODE:FDIFFB",
        "CALL:Difficulty Breathing",
        "ADDR:401 S MARIAN ST",
        "CITY:COLWICH",
        "PLACE:COLWICH GRADE SCHL",
        "UNIT:COFIRE");

    doTest("T3",
        "(CommandPoint CAD Message) [19:56:29 04-28-2013] *D 22008 HOUSE/421 W WICHITA AV ,CO COFIRE ",
        "TIME:19:56:29",
        "DATE:04/28/2013",
        "ID:22008",
        "CODE:HOUSE",
        "CALL:House Fire",
        "ADDR:421 W WICHITA AV",
        "MADDR:421 W WICHITA AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T4",
        "(CommandPoint CAD Message) [07:02:01 04-26-2013] *D 22008 FSTROK/131 N 5TH ST ,CO COFIRE ",
        "TIME:07:02:01",
        "DATE:04/26/2013",
        "ID:22008",
        "CODE:FSTROK",
        "CALL:Stroke",
        "ADDR:131 N 5TH ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T5",
        "(CommandPoint CAD Message) [14:49:25 04-21-2013] *D 22008 FFALL/E CHICAGO AV  / S 1ST ST ,CO <100,400> COFIRE ",
        "TIME:14:49:25",
        "DATE:04/21/2013",
        "ID:22008",
        "CODE:FFALL",
        "CALL:Fall",
        "ADDR:E CHICAGO AV & S 1ST ST",
        "MADDR:E CHICAGO AVE & S 1ST ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T6",
        "(CommandPoint CAD Message) [12:46:58 04-17-2013] *D 22008 FFALL/442 S 3RD ST ,CO COFIRE ",
        "TIME:12:46:58",
        "DATE:04/17/2013",
        "ID:22008",
        "CODE:FFALL",
        "CALL:Fall",
        "ADDR:442 S 3RD ST",
        "CITY:COLWICH",
        "UNIT:COFIRE");

    doTest("T7",
        "(CommandPoint CAD Message) [02:32:00 04-13-2013] *D 22008 FDIFFB/S 6TH ST  / W CHICAGO AV ,CO <398,600> COFIRE ",
        "TIME:02:32:00",
        "DATE:04/13/2013",
        "ID:22008",
        "CODE:FDIFFB",
        "CALL:Difficulty Breathing",
        "ADDR:S 6TH ST & W CHICAGO AV",
        "MADDR:S 6TH ST & W CHICAGO AVE",
        "CITY:COLWICH",
        "UNIT:COFIRE");

  }
  
  public static void main(String[] args) {
    new KSSedgwickCountyParserTest().generateTests("T1");
  }
}
