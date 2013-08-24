package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;
/* 
Jefferson County, CO

Contact: CodeMessaging
Sender: @c-msg.net

[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385
[WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431
[WRCAD] Add:4345 Everett St Type: FALL PgG-17 Units:WM1,WR1Radio:TAC2 Case#:0627201205966-001283
[WRCAD] Add:3480 Ames St Type: LINE PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0627201205966-001282
[WRCAD] Add:7045 W 43rd Ave Type: INV PgG-18 Units:WR1,WRD71Radio:TAC3 Case#:0705201205966-001352
[WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412
[WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410
[WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423
[WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458
[WRCAD] Add:7777 W 29th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0704201205966-001341
[WRCAD] Add:4407 Teller St Type: CPRA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0630201205966-001302

Contact: Active911
Agency name: Wheat Ridge Fire Department Location: Wheat Ridge, CO 
Sender: rc.348@c-msg.net

[WRCAD] [WRCAD] Add:3790 Yukon Ct Type: ABDOM PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001391
[WRCAD] [WRCAD] Alarm #0709201205966-015914DISP: 12:55:59ENR: SCN: CLR:12:57:54
[WRCAD] [WRCAD] Add:10451 W 38th Ave Type: BREAT PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0709201205966-001392
[WRCAD] [WRCAD] Alarm #0709201205966-015920DISP: 13:35:44ENR:13:37:12SCN:13:38:10CLR:13:38:14
[WRCAD] [WRCAD] Add:W 38th Ave & Harlan St Type: AA PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001393
[WRCAD] [WRCAD] Add:12555 W 27th Ave Type: ETOH PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001394
[WRCAD] [WRCAD] Add:W 48th Ave & Wadsworth Blvd Type: INV PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0709201205966-001395
[WRCAD] [WRCAD] Add:5301 W 38th Ave Type: FALL PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001396
[WRCAD] [WRCAD] Add:3835 Harlan St Type: CHEST PgG-19 Units:WR2,WM2Radio:TAC2 Case#:0709201205966-001397
[WRCAD] [WRCAD] Add:3664 Depew St Type: MALM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001398
[WRCAD] [WRCAD] Add:4377 Pierce St Type: BLEED PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0710201205966-001399
[WRCAD] [WRCAD] Add:4005 Kipling St Type: AA PgG-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001400
[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR2Radio:TAC2 Case#:0710201205966-001401
[WRCAD] [WRCAD] Alarm #0710201205966-016007DISP: 18:13:16ENR:18:16:23SCN:18:17:22CLR:19:15:28
[WRCAD] [WRCAD] Add:3067 Robb Cir Type: ODOR PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0710201205966-001401
[WRCAD] [WRCAD] Add:10901 W 30th Pl Type: Sick PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001402
[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001403
[WRCAD] [WRCAD] Add:W 44th Ave & Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001404
[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR1Radio:TAC2 Case#:0711201205966-001405
[WRCAD] [WRCAD] Add:3315 Sheridan Blvd Type: FA PgH-20 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001405

Contact: Active911
Agency name: Fairmount Fire Protection District
Location: Golden, CO, United States
Sender: messaging@emergencysmc.com

(Fairmount Fire) Add:19016 W 62nd Ave              Type:BREAT PgE-11 Cross:CRESTONE ST/DUNRAVEN ST                                                         Case#:122620125936-000654
(Fairmount Fire) Add:5385 Braun St                 Type:BREAT PgF-14 Cross:W 52ND AVE/W 54TH AVE                                                           Case#:122420125936-000653
(Fairmount Fire) Add:14709 W 52nd Ave              Type:FALL  PgF-14 Cross:HOWELL ST/INDIANA ST                                                            Case#:122220125936-000652
(Fairmount Fire) Alarm #122120125936-029899 DISP: 17:23:27\SCN:17:30:45\CLR:18:13:08
(Fairmount Fire) Add:W 32nd Ave & Harlan St        Type:  STRRE PgH-19 Units:WRE73,WM1,WRMUT,WREMERG,WRE71,Radio:TAC3/FTAC1     Case#:122120125936-000651
(Fairmount Fire) Add:State Hwy 93 & W 64th Ave     Type:AA    PgD-11 Cross:                                                                                Case#:122120125936-000650
(Fairmount Fire) Alarm #122020125936-029829 DISP: 23:32:40\SCN:23:39:43\CLR:23:58:39
(Fairmount Fire) Add:19825 W 57th Ave              Type:FAR   PgE-10 Cross:VAN BIBBER DR/no x street avail                                                 Case#:122020125936-000649
(Fairmount Fire) Add:5440 Mcintyre St              Type:UNKM  PgF-13 Cross:W 54TH AVE/W 55TH AVE                                                           Case#:121920125936-000648
(Fairmount Fire) Alarm #121920125936-029665 DISP: 14:00:35\SCN:        \CLR:14:08:02
(Fairmount Fire) Add:0 Wb I70/at Hwy 58 (fmt)      Type:AAH   PgG-15 Cross:                                                                                Case#:121920125936-000647
(Fairmount Fire) Add:4441 Salvia St                Type:FA    PgG-12 Cross:W 44TH AVE/no x street avail                                                    Case#:121920125936-000646
(Fairmount Fire) Add:15260 Arapahoe Dr             Type:ILLBU PgG-13 Cross:KENDRICK ST/KILMER ST                                                           Case#:121820125936-000645
(Fairmount Fire) Add:0 Eb I70/at Ward Rd (fmt)     Type:AAH   PgG-15 Cross:                                                                                Case#:121720125936-000644
(Fairmount Fire) Add:4435 Gladiola St              Type:FAR   PgG-14 Cross:W 44TH AVE/W 44TH DR                                                            Case#:121420125936-000643
(Fairmount Fire) Add:16542 W 55th Pl               Type:SICK  PgF-12 Cross:no x street avail/ROGERS CT                                                     Case#:121320125936-000642

*/

public class COJeffersonCountyAParserTest extends BaseParserTest {
  
  public COJeffersonCountyAParserTest() {
    setParser(new COJeffersonCountyAParser(), "Jefferson County", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385",
        "SRC:WRCAD",
        "ADDR:3745 Quail St",
        "CALL:UNKM",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0708201205966-001385");

    doTest("T2",
        "[WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431",
        "SRC:WRCAD",
        "ADDR:2650 Harlan St",
        "CALL:UNKM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001431");

    doTest("T3",
        "[WRCAD] Add:4345 Everett St Type: FALL PgG-17 Units:WM1,WR1Radio:TAC2 Case#:0627201205966-001283",
        "SRC:WRCAD",
        "ADDR:4345 Everett St",
        "CALL:FALL",
        "MAP:G-17",
        "UNIT:WM1,WR1",
        "CH:TAC2",
        "ID:0627201205966-001283");

    doTest("T4",
        "[WRCAD] Add:3480 Ames St Type: LINE PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0627201205966-001282",
        "SRC:WRCAD",
        "ADDR:3480 Ames St",
        "CALL:LINE",
        "MAP:H-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0627201205966-001282");

    doTest("T5",
        "[WRCAD] Add:7045 W 43rd Ave Type: INV PgG-18 Units:WR1,WRD71Radio:TAC3 Case#:0705201205966-001352",
        "SRC:WRCAD",
        "ADDR:7045 W 43rd Ave",
        "CALL:INV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC3",
        "ID:0705201205966-001352");

    doTest("T6",
        "[WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412",
        "SRC:WRCAD",
        "ADDR:2686 Newland St",
        "CALL:CO",
        "MAP:H-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0712201205966-001412");

    doTest("T7",
        "[WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410",
        "SRC:WRCAD",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001410");

    doTest("T8",
        "[WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423",
        "SRC:WRCAD",
        "ADDR:7380 W 32nd Ave",
        "CALL:STROK",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001423");

    doTest("T9",
        "[WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458",
        "SRC:WRCAD",
        "ADDR:7535 W 44th Ave",
        "CALL:ALTER",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001458");

    doTest("T10",
        "[WRCAD] Add:7777 W 29th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0704201205966-001341",
        "SRC:WRCAD",
        "ADDR:7777 W 29th Ave",
        "CALL:PSYCH",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0704201205966-001341");

    doTest("T11",
        "[WRCAD] Add:4407 Teller St Type: CPRA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0630201205966-001302",
        "SRC:WRCAD",
        "ADDR:4407 Teller St",
        "CALL:CPRA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0630201205966-001302");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[WRCAD] [WRCAD] Add:3790 Yukon Ct Type: ABDOM PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001391",
        "SRC:WRCAD",
        "ADDR:3790 Yukon Ct",
        "CALL:ABDOM",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001391");

    doTest("T2",
        "[WRCAD] [WRCAD] Alarm #0709201205966-015914DISP: 12:55:59ENR: SCN: CLR:12:57:54",
        "SRC:WRCAD",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0709201205966-015914DISP: 12:55:59ENR: SCN: CLR:12:57:54");

    doTest("T3",
        "[WRCAD] [WRCAD] Add:10451 W 38th Ave Type: BREAT PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0709201205966-001392",
        "SRC:WRCAD",
        "ADDR:10451 W 38th Ave",
        "CALL:BREAT",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0709201205966-001392");

    doTest("T4",
        "[WRCAD] [WRCAD] Alarm #0709201205966-015920DISP: 13:35:44ENR:13:37:12SCN:13:38:10CLR:13:38:14",
        "SRC:WRCAD",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0709201205966-015920DISP: 13:35:44ENR:13:37:12SCN:13:38:10CLR:13:38:14");

    doTest("T5",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Harlan St Type: AA PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001393",
        "SRC:WRCAD",
        "ADDR:W 38th Ave & Harlan St",
        "CALL:AA",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001393");

    doTest("T6",
        "[WRCAD] [WRCAD] Add:12555 W 27th Ave Type: ETOH PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001394",
        "SRC:WRCAD",
        "ADDR:12555 W 27th Ave",
        "CALL:ETOH",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001394");

    doTest("T7",
        "[WRCAD] [WRCAD] Add:W 48th Ave & Wadsworth Blvd Type: INV PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0709201205966-001395",
        "SRC:WRCAD",
        "ADDR:W 48th Ave & Wadsworth Blvd",
        "CALL:INV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0709201205966-001395");

    doTest("T8",
        "[WRCAD] [WRCAD] Add:5301 W 38th Ave Type: FALL PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001396",
        "SRC:WRCAD",
        "ADDR:5301 W 38th Ave",
        "CALL:FALL",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001396");

    doTest("T9",
        "[WRCAD] [WRCAD] Add:3835 Harlan St Type: CHEST PgG-19 Units:WR2,WM2Radio:TAC2 Case#:0709201205966-001397",
        "SRC:WRCAD",
        "ADDR:3835 Harlan St",
        "CALL:CHEST",
        "MAP:G-19",
        "UNIT:WR2,WM2",
        "CH:TAC2",
        "ID:0709201205966-001397");

    doTest("T10",
        "[WRCAD] [WRCAD] Add:3664 Depew St Type: MALM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001398",
        "SRC:WRCAD",
        "ADDR:3664 Depew St",
        "CALL:MALM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001398");

    doTest("T11",
        "[WRCAD] [WRCAD] Add:4377 Pierce St Type: BLEED PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0710201205966-001399",
        "SRC:WRCAD",
        "ADDR:4377 Pierce St",
        "CALL:BLEED",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0710201205966-001399");

    doTest("T12",
        "[WRCAD] [WRCAD] Add:4005 Kipling St Type: AA PgG-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001400",
        "SRC:WRCAD",
        "ADDR:4005 Kipling St",
        "CALL:AA",
        "MAP:G-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0710201205966-001400");

    doTest("T13",
        "[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR2Radio:TAC2 Case#:0710201205966-001401",
        "SRC:WRCAD",
        "ADDR:3880 Upham St",
        "CALL:TEST",
        "MAP:G-18",
        "UNIT:WR2",
        "CH:TAC2",
        "ID:0710201205966-001401");

    doTest("T14",
        "[WRCAD] [WRCAD] Alarm #0710201205966-016007DISP: 18:13:16ENR:18:16:23SCN:18:17:22CLR:19:15:28",
        "SRC:WRCAD",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0710201205966-016007DISP: 18:13:16ENR:18:16:23SCN:18:17:22CLR:19:15:28");

    doTest("T15",
        "[WRCAD] [WRCAD] Add:3067 Robb Cir Type: ODOR PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0710201205966-001401",
        "SRC:WRCAD",
        "ADDR:3067 Robb Cir",
        "CALL:ODOR",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0710201205966-001401");

    doTest("T16",
        "[WRCAD] [WRCAD] Add:10901 W 30th Pl Type: Sick PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001402",
        "SRC:WRCAD",
        "ADDR:10901 W 30th Pl",
        "CALL:Sick",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0710201205966-001402");

    doTest("T17",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001403",
        "SRC:WRCAD",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001403");

    doTest("T18",
        "[WRCAD] [WRCAD] Add:W 44th Ave & Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001404",
        "SRC:WRCAD",
        "ADDR:W 44th Ave & Wadsworth Blvd",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001404");

    doTest("T19",
        "[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR1Radio:TAC2 Case#:0711201205966-001405",
        "SRC:WRCAD",
        "ADDR:3880 Upham St",
        "CALL:TEST",
        "MAP:G-18",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0711201205966-001405");

    doTest("T20",
        "[WRCAD] [WRCAD] Add:3315 Sheridan Blvd Type: FA PgH-20 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001405",
        "SRC:WRCAD",
        "ADDR:3315 Sheridan Blvd",
        "CALL:FA",
        "MAP:H-20",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001405");

  }
  
  @Test
  public void testFairmountFire() {

    doTest("T1",
        "(Fairmount Fire) Add:19016 W 62nd Ave              Type:BREAT PgE-11 Cross:CRESTONE ST/DUNRAVEN ST                                                         Case#:122620125936-000654",
        "SRC:Fairmount Fire",
        "ADDR:19016 W 62nd Ave",
        "CALL:BREAT",
        "MAP:E-11",
        "X:CRESTONE ST/DUNRAVEN ST",
        "ID:122620125936-000654");

    doTest("T2",
        "(Fairmount Fire) Add:5385 Braun St                 Type:BREAT PgF-14 Cross:W 52ND AVE/W 54TH AVE                                                           Case#:122420125936-000653",
        "SRC:Fairmount Fire",
        "ADDR:5385 Braun St",
        "CALL:BREAT",
        "MAP:F-14",
        "X:W 52ND AVE/W 54TH AVE",
        "ID:122420125936-000653");

    doTest("T3",
        "(Fairmount Fire) Add:14709 W 52nd Ave              Type:FALL  PgF-14 Cross:HOWELL ST/INDIANA ST                                                            Case#:122220125936-000652",
        "SRC:Fairmount Fire",
        "ADDR:14709 W 52nd Ave",
        "CALL:FALL",
        "MAP:F-14",
        "X:HOWELL ST/INDIANA ST",
        "ID:122220125936-000652");

    doTest("T4",
        "(Fairmount Fire) Alarm #122120125936-029899 DISP: 17:23:27\\SCN:17:30:45\\CLR:18:13:08",
        "SRC:Fairmount Fire",
        "CALL:RUN REPORT",
        "PLACE:Alarm #122120125936-029899 DISP: 17:23:27\\SCN:17:30:45\\CLR:18:13:08");

    doTest("T5",
        "(Fairmount Fire) Add:W 32nd Ave & Harlan St        Type:  STRRE PgH-19 Units:WRE73,WM1,WRMUT,WREMERG,WRE71,Radio:TAC3/FTAC1     Case#:122120125936-000651",
        "SRC:Fairmount Fire",
        "ADDR:W 32nd Ave & Harlan St",
        "CALL:STRRE",
        "MAP:H-19",
        "UNIT:WRE73,WM1,WRMUT,WREMERG,WRE71,",
        "CH:TAC3/FTAC1",
        "ID:122120125936-000651");

    doTest("T6",
        "(Fairmount Fire) Add:State Hwy 93 & W 64th Ave     Type:AA    PgD-11 Cross:                                                                                Case#:122120125936-000650",
        "SRC:Fairmount Fire",
        "ADDR:State Hwy 93 & W 64th Ave",
        "MADDR:STATE 93 & W 64th Ave",
        "CALL:AA",
        "MAP:D-11",
        "ID:122120125936-000650");

    doTest("T7",
        "(Fairmount Fire) Alarm #122020125936-029829 DISP: 23:32:40\\SCN:23:39:43\\CLR:23:58:39",
        "SRC:Fairmount Fire",
        "CALL:RUN REPORT",
        "PLACE:Alarm #122020125936-029829 DISP: 23:32:40\\SCN:23:39:43\\CLR:23:58:39");

    doTest("T8",
        "(Fairmount Fire) Add:19825 W 57th Ave              Type:FAR   PgE-10 Cross:VAN BIBBER DR/no x street avail                                                 Case#:122020125936-000649",
        "SRC:Fairmount Fire",
        "ADDR:19825 W 57th Ave",
        "CALL:FAR",
        "MAP:E-10",
        "X:VAN BIBBER DR/no x street avail",
        "ID:122020125936-000649");

    doTest("T9",
        "(Fairmount Fire) Add:5440 Mcintyre St              Type:UNKM  PgF-13 Cross:W 54TH AVE/W 55TH AVE                                                           Case#:121920125936-000648",
        "SRC:Fairmount Fire",
        "ADDR:5440 Mcintyre St",
        "CALL:UNKM",
        "MAP:F-13",
        "X:W 54TH AVE/W 55TH AVE",
        "ID:121920125936-000648");

    doTest("T10",
        "(Fairmount Fire) Alarm #121920125936-029665 DISP: 14:00:35\\SCN:        \\CLR:14:08:02",
        "SRC:Fairmount Fire",
        "CALL:RUN REPORT",
        "PLACE:Alarm #121920125936-029665 DISP: 14:00:35\\SCN:        \\CLR:14:08:02");

    doTest("T11",
        "(Fairmount Fire) Add:0 Wb I70/at Hwy 58 (fmt)      Type:AAH   PgG-15 Cross:                                                                                Case#:121920125936-000647",
        "SRC:Fairmount Fire",
        "ADDR:Wb I70 & at Hwy 58 (fmt)",
        "MADDR:I 70 & at Hwy 58",
        "CALL:AAH",
        "MAP:G-15",
        "ID:121920125936-000647");

    doTest("T12",
        "(Fairmount Fire) Add:4441 Salvia St                Type:FA    PgG-12 Cross:W 44TH AVE/no x street avail                                                    Case#:121920125936-000646",
        "SRC:Fairmount Fire",
        "ADDR:4441 Salvia St",
        "CALL:FA",
        "MAP:G-12",
        "X:W 44TH AVE/no x street avail",
        "ID:121920125936-000646");

    doTest("T13",
        "(Fairmount Fire) Add:15260 Arapahoe Dr             Type:ILLBU PgG-13 Cross:KENDRICK ST/KILMER ST                                                           Case#:121820125936-000645",
        "SRC:Fairmount Fire",
        "ADDR:15260 Arapahoe Dr",
        "CALL:ILLBU",
        "MAP:G-13",
        "X:KENDRICK ST/KILMER ST",
        "ID:121820125936-000645");

    doTest("T14",
        "(Fairmount Fire) Add:0 Eb I70/at Ward Rd (fmt)     Type:AAH   PgG-15 Cross:                                                                                Case#:121720125936-000644",
        "SRC:Fairmount Fire",
        "ADDR:Eb I70 & at Ward Rd (fmt)",
        "MADDR:I 70 & at Ward Rd",
        "CALL:AAH",
        "MAP:G-15",
        "ID:121720125936-000644");

    doTest("T15",
        "(Fairmount Fire) Add:4435 Gladiola St              Type:FAR   PgG-14 Cross:W 44TH AVE/W 44TH DR                                                            Case#:121420125936-000643",
        "SRC:Fairmount Fire",
        "ADDR:4435 Gladiola St",
        "CALL:FAR",
        "MAP:G-14",
        "X:W 44TH AVE/W 44TH DR",
        "ID:121420125936-000643");

    doTest("T16",
        "(Fairmount Fire) Add:16542 W 55th Pl               Type:SICK  PgF-12 Cross:no x street avail/ROGERS CT                                                     Case#:121320125936-000642",
        "SRC:Fairmount Fire",
        "ADDR:16542 W 55th Pl",
        "CALL:SICK",
        "MAP:F-12",
        "X:no x street avail/ROGERS CT",
        "ID:121320125936-000642");
  
  }
  
  public static void main(String[] args) {
    new COJeffersonCountyAParserTest().generateTests("T1");
  }
}
  