package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

public class COJeffersonCountyParserTest extends BaseParserTest {
  
  public COJeffersonCountyParserTest() {
    setParser(new COJeffersonCountyParser(), "Jefferson County", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[WRCAD] Add:3745 Quail St Type: UNKM PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0708201205966-001385",
        "ADDR:3745 Quail St",
        "CALL:UNKM",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0708201205966-001385");

    doTest("T2",
        "[WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431",
        "ADDR:2650 Harlan St",
        "CALL:UNKM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001431");

    doTest("T3",
        "[WRCAD] Add:4345 Everett St Type: FALL PgG-17 Units:WM1,WR1Radio:TAC2 Case#:0627201205966-001283",
        "ADDR:4345 Everett St",
        "CALL:FALL",
        "MAP:G-17",
        "UNIT:WM1,WR1",
        "CH:TAC2",
        "ID:0627201205966-001283");

    doTest("T4",
        "[WRCAD] Add:3480 Ames St Type: LINE PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0627201205966-001282",
        "ADDR:3480 Ames St",
        "CALL:LINE",
        "MAP:H-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0627201205966-001282");

    doTest("T5",
        "[WRCAD] Add:7045 W 43rd Ave Type: INV PgG-18 Units:WR1,WRD71Radio:TAC3 Case#:0705201205966-001352",
        "ADDR:7045 W 43rd Ave",
        "CALL:INV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC3",
        "ID:0705201205966-001352");

    doTest("T6",
        "[WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412",
        "ADDR:2686 Newland St",
        "CALL:CO",
        "MAP:H-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0712201205966-001412");

    doTest("T7",
        "[WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001410");

    doTest("T8",
        "[WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423",
        "ADDR:7380 W 32nd Ave",
        "CALL:STROK",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001423");

    doTest("T9",
        "[WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458",
        "ADDR:7535 W 44th Ave",
        "CALL:ALTER",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001458");

    doTest("T10",
        "[WRCAD] Add:7777 W 29th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0704201205966-001341",
        "ADDR:7777 W 29th Ave",
        "CALL:PSYCH",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0704201205966-001341");

    doTest("T11",
        "[WRCAD] Add:4407 Teller St Type: CPRA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0630201205966-001302",
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
        "ADDR:3790 Yukon Ct",
        "CALL:ABDOM",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001391");

    doTest("T2",
        "[WRCAD] [WRCAD] Alarm #0709201205966-015914DISP: 12:55:59ENR: SCN: CLR:12:57:54",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0709201205966-015914DISP: 12:55:59ENR: SCN: CLR:12:57:54");

    doTest("T3",
        "[WRCAD] [WRCAD] Add:10451 W 38th Ave Type: BREAT PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0709201205966-001392",
        "ADDR:10451 W 38th Ave",
        "CALL:BREAT",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0709201205966-001392");

    doTest("T4",
        "[WRCAD] [WRCAD] Alarm #0709201205966-015920DISP: 13:35:44ENR:13:37:12SCN:13:38:10CLR:13:38:14",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0709201205966-015920DISP: 13:35:44ENR:13:37:12SCN:13:38:10CLR:13:38:14");

    doTest("T5",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Harlan St Type: AA PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001393",
        "ADDR:W 38th Ave & Harlan St",
        "CALL:AA",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001393");

    doTest("T6",
        "[WRCAD] [WRCAD] Add:12555 W 27th Ave Type: ETOH PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001394",
        "ADDR:12555 W 27th Ave",
        "CALL:ETOH",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001394");

    doTest("T7",
        "[WRCAD] [WRCAD] Add:W 48th Ave & Wadsworth Blvd Type: INV PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0709201205966-001395",
        "ADDR:W 48th Ave & Wadsworth Blvd",
        "CALL:INV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0709201205966-001395");

    doTest("T8",
        "[WRCAD] [WRCAD] Add:5301 W 38th Ave Type: FALL PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001396",
        "ADDR:5301 W 38th Ave",
        "CALL:FALL",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001396");

    doTest("T9",
        "[WRCAD] [WRCAD] Add:3835 Harlan St Type: CHEST PgG-19 Units:WR2,WM2Radio:TAC2 Case#:0709201205966-001397",
        "ADDR:3835 Harlan St",
        "CALL:CHEST",
        "MAP:G-19",
        "UNIT:WR2,WM2",
        "CH:TAC2",
        "ID:0709201205966-001397");

    doTest("T10",
        "[WRCAD] [WRCAD] Add:3664 Depew St Type: MALM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0709201205966-001398",
        "ADDR:3664 Depew St",
        "CALL:MALM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0709201205966-001398");

    doTest("T11",
        "[WRCAD] [WRCAD] Add:4377 Pierce St Type: BLEED PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0710201205966-001399",
        "ADDR:4377 Pierce St",
        "CALL:BLEED",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0710201205966-001399");

    doTest("T12",
        "[WRCAD] [WRCAD] Add:4005 Kipling St Type: AA PgG-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001400",
        "ADDR:4005 Kipling St",
        "CALL:AA",
        "MAP:G-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0710201205966-001400");

    doTest("T13",
        "[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR2Radio:TAC2 Case#:0710201205966-001401",
        "ADDR:3880 Upham St",
        "CALL:TEST",
        "MAP:G-18",
        "UNIT:WR2",
        "CH:TAC2",
        "ID:0710201205966-001401");

    doTest("T14",
        "[WRCAD] [WRCAD] Alarm #0710201205966-016007DISP: 18:13:16ENR:18:16:23SCN:18:17:22CLR:19:15:28",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0710201205966-016007DISP: 18:13:16ENR:18:16:23SCN:18:17:22CLR:19:15:28");

    doTest("T15",
        "[WRCAD] [WRCAD] Add:3067 Robb Cir Type: ODOR PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0710201205966-001401",
        "ADDR:3067 Robb Cir",
        "CALL:ODOR",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0710201205966-001401");

    doTest("T16",
        "[WRCAD] [WRCAD] Add:10901 W 30th Pl Type: Sick PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0710201205966-001402",
        "ADDR:10901 W 30th Pl",
        "CALL:Sick",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0710201205966-001402");

    doTest("T17",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001403",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001403");

    doTest("T18",
        "[WRCAD] [WRCAD] Add:W 44th Ave & Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001404",
        "ADDR:W 44th Ave & Wadsworth Blvd",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001404");

    doTest("T19",
        "[WRCAD] [WRCAD] Add:3880 Upham St Type: TEST PgG-18 Units:WR1Radio:TAC2 Case#:0711201205966-001405",
        "ADDR:3880 Upham St",
        "CALL:TEST",
        "MAP:G-18",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0711201205966-001405");

    doTest("T20",
        "[WRCAD] [WRCAD] Add:3315 Sheridan Blvd Type: FA PgH-20 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001405",
        "ADDR:3315 Sheridan Blvd",
        "CALL:FA",
        "MAP:H-20",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001405");

    doTest("T21",
        "[WRCAD] [WRCAD] Add:11250 W 38th Ave Type: CHEST PgH-16 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001406",
        "ADDR:11250 W 38th Ave",
        "CALL:CHEST",
        "MAP:H-16",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001406");

    doTest("T22",
        "[WRCAD] [WRCAD] Add:3920 Pierce St Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001407",
        "ADDR:3920 Pierce St",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001407");

    doTest("T23",
        "[WRCAD] [WRCAD] Alarm #0711201205966-016093DISP: 15:08:24ENR:15:10:38SCN:15:12:45CLR:15:23:50",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0711201205966-016093DISP: 15:08:24ENR:15:10:38SCN:15:12:45CLR:15:23:50");

    doTest("T24",
        "[WRCAD] [WRCAD] Add:4535 Yukon Ct Type: OD PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001408",
        "ADDR:4535 Yukon Ct",
        "CALL:OD",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001408");

    doTest("T25",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0711201205966-001409",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0711201205966-001409");

    doTest("T26",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001410",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001410");

    doTest("T27",
        "[WRCAD] [WRCAD] Add:5301 W 38th Ave Type: CHOKA PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0711201205966-001411",
        "ADDR:5301 W 38th Ave",
        "CALL:CHOKA",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0711201205966-001411");

    doTest("T28",
        "[WRCAD] [WRCAD] Add:2686 Newland St Type: CO PgH-19 Units:WR1Radio:TAC2 Case#:0712201205966-001412",
        "ADDR:2686 Newland St",
        "CALL:CO",
        "MAP:H-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0712201205966-001412");

    doTest("T29",
        "[WRCAD] [WRCAD] Alarm #0712201205966-016152DISP: 06:11:12ENR:06:14:24SCN:06:27:49CLR:06:35:00",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0712201205966-016152DISP: 06:11:12ENR:06:14:24SCN:06:27:49CLR:06:35:00");

    doTest("T30",
        "[WRCAD] [WRCAD] Add:11340 W 38th Ave Type: CHEST PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0712201205966-001413",
        "ADDR:11340 W 38th Ave",
        "CALL:CHEST",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0712201205966-001413");

    doTest("T31",
        "[WRCAD] [WRCAD] Add:12060 W 32nd Dr Type: CHEST PgH-15 Units:WR1,WM2Radio:TAC2 Case#:0712201205966-001414",
        "ADDR:12060 W 32nd Dr",
        "CALL:CHEST",
        "MAP:H-15",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0712201205966-001414");

    doTest("T32",
        "[WRCAD] [WRCAD] Add:6995 W 38th Ave Type: FALL PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0712201205966-001415",
        "ADDR:6995 W 38th Ave",
        "CALL:FALL",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0712201205966-001415");

    doTest("T33",
        "[WRCAD] [WRCAD] Add:4262 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0712201205966-001416",
        "ADDR:4262 Wadsworth Blvd",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0712201205966-001416");

    doTest("T34",
        "[WRCAD] [WRCAD] Alarm #0712201205966-016189DISP: 13:48:53ENR:13:50:58SCN: CLR:14:18:37",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0712201205966-016189DISP: 13:48:53ENR:13:50:58SCN: CLR:14:18:37");

    doTest("T35",
        "[WRCAD] [WRCAD] Add:2932 Chase St Type: UNC PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0712201205966-001417",
        "ADDR:2932 Chase St",
        "CALL:UNC",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0712201205966-001417");

    doTest("T36",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: FALL PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0712201205966-001418",
        "ADDR:2800 Youngfield St",
        "CALL:FALL",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0712201205966-001418");

    doTest("T37",
        "[WRCAD] [WRCAD] Add:21 Skyline Dr Type: CO PgH-16 Units:WR1Radio:TAC2 Case#:0713201205966-001419",
        "ADDR:21 Skyline Dr",
        "CALL:CO",
        "MAP:H-16",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0713201205966-001419");

    doTest("T38",
        "[WRCAD] [WRCAD] Add:3400 Lutheran Pkwy W Type: UNKM PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001420",
        "ADDR:3400 Lutheran Pkwy W",
        "CALL:UNKM",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001420");

    doTest("T39",
        "[WRCAD] [WRCAD] Add:3510 Holland St Type: SICK PgH-17 Units:WM1,WR1Radio:TAC2 Case#:0713201205966-001421",
        "ADDR:3510 Holland St",
        "CALL:SICK",
        "MAP:H-17",
        "UNIT:WM1,WR1",
        "CH:TAC2",
        "ID:0713201205966-001421");

    doTest("T40",
        "[WRCAD] [WRCAD] Add:W 44th Ave & Allison St Type: AA PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0713201205966-001422",
        "ADDR:W 44th Ave & Allison St",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0713201205966-001422");

    doTest("T41",
        "[WRCAD] [WRCAD] Add:7380 W 32nd Ave Type: STROK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001423",
        "ADDR:7380 W 32nd Ave",
        "CALL:STROK",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001423");

    doTest("T42",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: UNC PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001424",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001424");

    doTest("T43",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Pierce St Type: ABDOM PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001425",
        "ADDR:W 38th Ave & Pierce St",
        "CALL:ABDOM",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001425");

    doTest("T44",
        "[WRCAD] [WRCAD] Add:7500 W 29th Ave Type: UNKM PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001426",
        "ADDR:7500 W 29th Ave",
        "CALL:UNKM",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001426");

    doTest("T45",
        "[WRCAD] [WRCAD] Alarm #0713201205966-016299DISP: 18:35:25ENR:18:37:13SCN:18:39:36CLR:18:52:15",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0713201205966-016299DISP: 18:35:25ENR:18:37:13SCN:18:39:36CLR:18:52:15");

    doTest("T46",
        "[WRCAD] [WRCAD] Add:4375 Ames St Type: MED PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0713201205966-001427",
        "ADDR:4375 Ames St",
        "CALL:MED",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0713201205966-001427");

    doTest("T47",
        "[WRCAD] [WRCAD] Add:4125 Newland St Type: MALM PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001428",
        "ADDR:4125 Newland St",
        "CALL:MALM",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001428");

    doTest("T48",
        "[WRCAD] [WRCAD] Add:7756 W 38th Ave Type: GAS PgH-18 Units:WR1,WRD71Radio:TAC2 Case#:0714201205966-001430",
        "ADDR:7756 W 38th Ave",
        "CALL:GAS",
        "MAP:H-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0714201205966-001430");

    doTest("T49",
        "[WRCAD] [WRCAD] Add:2650 Harlan St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001431",
        "ADDR:2650 Harlan St",
        "CALL:UNKM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001431");

    doTest("T50",
        "[WRCAD] [WRCAD] Add:2920 Fenton St Type: UNC PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0714201205966-001432",
        "ADDR:2920 Fenton St",
        "CALL:UNC",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0714201205966-001432");

    doTest("T51",
        "[WRCAD] [WRCAD] Add:2688 Harlan St Type: INV PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0715201205966-001433",
        "ADDR:2688 Harlan St",
        "CALL:INV",
        "MAP:H-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0715201205966-001433");

    doTest("T52",
        "[WRCAD] [WRCAD] Alarm #0715201205966-016406DISP: 00:46:02ENR:00:48:13SCN:00:52:36CLR:01:10:23",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0715201205966-016406DISP: 00:46:02ENR:00:48:13SCN:00:52:36CLR:01:10:23");

    doTest("T53",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: UNC PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0715201205966-001434",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0715201205966-001434");

    doTest("T54",
        "[WRCAD] [WRCAD] Add:3835 Harlan St Type: FA PgG-19 Units:WR1,WRD71Radio:TAC2 Case#:0715201205966-001435",
        "ADDR:3835 Harlan St",
        "CALL:FA",
        "MAP:G-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0715201205966-001435");

    doTest("T55",
        "[WRCAD] [WRCAD] Alarm #0715201205966-016435DISP: 10:40:04ENR:10:42:32SCN:10:46:54CLR:11:03:04",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0715201205966-016435DISP: 10:40:04ENR:10:42:32SCN:10:46:54CLR:11:03:04");

    doTest("T56",
        "[WRCAD] [WRCAD] Add:6875 W 38th Ave Type: STRRE PgH-18 Units:WR1,WM2,WREMERG,WRMUT,WRD71,FMRadio:TAC3 Case#:071520125936-000358",
        "ADDR:6875 W 38th Ave",
        "CALL:STRRE",
        "MAP:H-18",
        "UNIT:WR1,WM2,WREMERG,WRMUT,WRD71,FM",
        "CH:TAC3",
        "ID:071520125936-000358");

    doTest("T57",
        "[WRCAD] [WRCAD] Add:6875 W 38th Ave Type: STRRE PgH-18 Units:WR1,WM2,WREMERG,WRMUT,WRD71,FMRadio:TAC3 Case#:071520125936-000358",
        "ADDR:6875 W 38th Ave",
        "CALL:STRRE",
        "MAP:H-18",
        "UNIT:WR1,WM2,WREMERG,WRMUT,WRD71,FM",
        "CH:TAC3",
        "ID:071520125936-000358");

    doTest("T58",
        "[WRCAD] [WRCAD] Add:9505 W 32nd Ave Type: BREAT PgH-17 Units:WR1,WM4Radio:TAC2 Case#:0715201205966-001437",
        "ADDR:9505 W 32nd Ave",
        "CALL:BREAT",
        "MAP:H-17",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0715201205966-001437");

    doTest("T59",
        "[WRCAD] [WRCAD] Add:4595 Harlan St Type: FA PgG-19 Units:WR1,WRD71Radio:TAC2 Case#:0716201205966-001438",
        "ADDR:4595 Harlan St",
        "CALL:FA",
        "MAP:G-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0716201205966-001438");

    doTest("T60",
        "[WRCAD] [WRCAD] Alarm #0716201205966-016505DISP: 07:43:34ENR:07:45:48SCN:07:49:08CLR:07:59:38",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0716201205966-016505DISP: 07:43:34ENR:07:45:48SCN:07:49:08CLR:07:59:38");

    doTest("T61",
        "[WRCAD] [WRCAD] Add:4595 Harlan St Type: FA PgG-19 Units:WR1,WRD71Radio:TAC2 Case#:0716201205966-001439",
        "ADDR:4595 Harlan St",
        "CALL:FA",
        "MAP:G-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0716201205966-001439");

    doTest("T62",
        "[WRCAD] [WRCAD] Alarm #0716201205966-016508DISP: 09:03:06ENR:09:04:48SCN:09:07:58CLR:09:16:35",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0716201205966-016508DISP: 09:03:06ENR:09:04:48SCN:09:07:58CLR:09:16:35");

    doTest("T63",
        "[WRCAD] [WRCAD] Add:9505 W 32nd Ave Type: FA PgH-17 Units:WRD71,WR1Radio:TAC2 Case#:0716201205966-001440",
        "ADDR:9505 W 32nd Ave",
        "CALL:FA",
        "MAP:H-17",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0716201205966-001440");

    doTest("T64",
        "[WRCAD] [WRCAD] Alarm #0716201205966-016515DISP: 10:36:15ENR:10:36:36SCN:10:43:14CLR:11:06:18",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0716201205966-016515DISP: 10:36:15ENR:10:36:36SCN:10:43:14CLR:11:06:18");

    doTest("T65",
        "[WRCAD] [WRCAD] Add:4005 Kipling St Type: Sick PgG-16 Units:WR1,WM1Radio:TAC2 Case#:0716201205966-001441",
        "ADDR:4005 Kipling St",
        "CALL:Sick",
        "MAP:G-16",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0716201205966-001441");

    doTest("T66",
        "[WRCAD] [WRCAD] Add:4425 Reed St Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0716201205966-001442",
        "ADDR:4425 Reed St",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0716201205966-001442");

    doTest("T67",
        "[WRCAD] [WRCAD] Add:11652 W 36th Ave Type: BREAT PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0716201205966-001443",
        "ADDR:11652 W 36th Ave",
        "CALL:BREAT",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0716201205966-001443");

    doTest("T68",
        "[WRCAD] [WRCAD] Add:4225 Pierce St Type: UNC PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0716201205966-001444",
        "ADDR:4225 Pierce St",
        "CALL:UNC",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0716201205966-001444");

    doTest("T69",
        "[WRCAD] [WRCAD] Add:3724 Fenton St Type: OD PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0716201205966-001445",
        "ADDR:3724 Fenton St",
        "CALL:OD",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0716201205966-001445");

    doTest("T70",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: CHEST PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0716201205966-001446",
        "ADDR:2800 Youngfield St",
        "CALL:CHEST",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0716201205966-001446");

    doTest("T71",
        "[WRCAD] [WRCAD] Add:4020 Wadsworth Blvd Type: FA PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0717201205966-001447",
        "ADDR:4020 Wadsworth Blvd",
        "CALL:FA",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0717201205966-001447");

    doTest("T72",
        "[WRCAD] [WRCAD] Alarm #0717201205966-016583DISP: 00:31:35ENR:00:33:56SCN:00:37:49CLR:01:01:52",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0717201205966-016583DISP: 00:31:35ENR:00:33:56SCN:00:37:49CLR:01:01:52");

    doTest("T73",
        "[WRCAD] [WRCAD] Add:W 39th Ave & Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0717201205966-001448",
        "ADDR:W 39th Ave & Wadsworth Blvd",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0717201205966-001448");

    doTest("T74",
        "[WRCAD] [WRCAD] Add:7780 W 38th Ave Type: ELEV PgH-18 Units:WR1,WRD71Radio:TAC2 Case#:0717201205966-001449",
        "ADDR:7780 W 38th Ave",
        "CALL:ELEV",
        "MAP:H-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0717201205966-001449");

    doTest("T75",
        "[WRCAD] [WRCAD] Add:3210 Lutheran Pkwy Type: BLEED PgH-17 Units:WR1,WM1Radio:TAC2 Case#:0717201205966-001450",
        "ADDR:3210 Lutheran Pkwy",
        "CALL:BLEED",
        "MAP:H-17",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0717201205966-001450");

    doTest("T76",
        "[WRCAD] [WRCAD] Add:3289 Benton St Type: ETOH PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0717201205966-001451",
        "ADDR:3289 Benton St",
        "CALL:ETOH",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0717201205966-001451");

    doTest("T77",
        "[WRCAD] [WRCAD] Add:10901 W 38th Ave Type: TEST PgH-16 Units:WRD71,WR2Radio:TAC2 Case#:0717201205966-001452",
        "ADDR:10901 W 38th Ave",
        "CALL:TEST",
        "MAP:H-16",
        "UNIT:WRD71,WR2",
        "CH:TAC2",
        "ID:0717201205966-001452");

    doTest("T78",
        "[WRCAD] [WRCAD] Add:4350 Wadsworth Blvd Type: TEST PgG-18 Units:WR2Radio:TAC2 Case#:0717201205966-001453",
        "ADDR:4350 Wadsworth Blvd",
        "CALL:TEST",
        "MAP:G-18",
        "UNIT:WR2",
        "CH:TAC2",
        "ID:0717201205966-001453");

    doTest("T79",
        "[WRCAD] [WRCAD] Alarm #0717201205966-016629DISP: 13:44:27ENR: SCN: CLR:13:45:10",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0717201205966-016629DISP: 13:44:27ENR: SCN: CLR:13:45:10");

    doTest("T80",
        "[WRCAD] [WRCAD] Add:3600 Youngfield St Type: CHEST PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0717201205966-001453",
        "ADDR:3600 Youngfield St",
        "CALL:CHEST",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0717201205966-001453");

    doTest("T81",
        "[WRCAD] [WRCAD] Add:2840 Chase St Type: ODOR PgH-19 Units:WR1,WRD71Radio:TAC2 Case#:0718201205966-001454",
        "ADDR:2840 Chase St",
        "CALL:ODOR",
        "MAP:H-19",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0718201205966-001454");

    doTest("T82",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: FALL PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0718201205966-001455",
        "ADDR:2800 Youngfield St",
        "CALL:FALL",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0718201205966-001455");

    doTest("T83",
        "[WRCAD] [WRCAD] Add:3630 Vance St Type: FALL PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0718201205966-001456",
        "ADDR:3630 Vance St",
        "CALL:FALL",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0718201205966-001456");

    doTest("T84",
        "[WRCAD] [WRCAD] Add:6360 W 38th Ave Type: MALM PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001457",
        "ADDR:6360 W 38th Ave",
        "CALL:MALM",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001457");

    doTest("T85",
        "[WRCAD] [WRCAD] Add:7535 W 44th Ave Type: ALTER PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001458",
        "ADDR:7535 W 44th Ave",
        "CALL:ALTER",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001458");

    doTest("T86",
        "[WRCAD] [WRCAD] Add:6270 W 38th Ave Type: BACK PgG-19 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001459",
        "ADDR:6270 W 38th Ave",
        "CALL:BACK",
        "MAP:G-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001459");

    doTest("T87",
        "[WRCAD] [WRCAD] Add:10050 W 41st Ave Type: TRAUM PgG-16 Units:WR1,WM4Radio:TAC2 Case#:0718201205966-001460",
        "ADDR:10050 W 41st Ave",
        "CALL:TRAUM",
        "MAP:G-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0718201205966-001460");

    doTest("T88",
        "[WRCAD] [WRCAD] Add:3550 Lutheran Pkwy W Type: TRAUM PgH-17 Units:WR1,WM2Radio:TAC2 Case#:0718201205966-001461",
        "ADDR:3550 Lutheran Pkwy W",
        "CALL:TRAUM",
        "MAP:H-17",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0718201205966-001461");

    doTest("T89",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Wadsworth Blvd Type: AAP PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0718201205966-001462",
        "ADDR:W 38th Ave & Wadsworth Blvd",
        "CALL:AAP",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0718201205966-001462");

    doTest("T90",
        "[WRCAD] [WRCAD] Add:3244 Youngfield St Type: UNC PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0719201205966-001465",
        "ADDR:3244 Youngfield St",
        "CALL:UNC",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0719201205966-001465");

    doTest("T91",
        "[WRCAD] [WRCAD] Add:W 37th Pl & Pierce St Type: TRAUM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0719201205966-001466",
        "ADDR:W 37th Pl & Pierce St",
        "CALL:TRAUM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0719201205966-001466");

    doTest("T92",
        "[WRCAD] [WRCAD] Add:3510 Holland St Type: UNC PgH-17 Units:WR1,WM4Radio:TAC2 Case#:0719201205966-001467",
        "ADDR:3510 Holland St",
        "CALL:UNC",
        "MAP:H-17",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0719201205966-001467");

    doTest("T93",
        "[WRCAD] [WRCAD] Add:W 32nd Ave & Marshall St Type: ILLBU PgH-19 Units:WR2,WRD71Radio:TAC2 Case#:0719201205966-001468",
        "ADDR:W 32nd Ave & Marshall St",
        "CALL:ILLBU",
        "MAP:H-19",
        "UNIT:WR2,WRD71",
        "CH:TAC2",
        "ID:0719201205966-001468");

    doTest("T94",
        "[WRCAD] [WRCAD] Alarm #0719201205966-016835DISP: 19:21:44ENR:19:23:31SCN:19:25:21CLR:19:29:30",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0719201205966-016835DISP: 19:21:44ENR:19:23:31SCN:19:25:21CLR:19:29:30");

    doTest("T95",
        "[WRCAD] [WRCAD] Add:3600 Youngfield St Type: UNC PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0720201205966-001469",
        "ADDR:3600 Youngfield St",
        "CALL:UNC",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0720201205966-001469");

    doTest("T96",
        "[WRCAD] [WRCAD] Add:4377 Pierce St Type: ABDOM PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0720201205966-001470",
        "ADDR:4377 Pierce St",
        "CALL:ABDOM",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0720201205966-001470");

    doTest("T97",
        "[WRCAD] [WRCAD] Alarm #0720201205966-016860DISP: 04:15:51ENR:04:18:12SCN:04:19:59CLR:04:30:33",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0720201205966-016860DISP: 04:15:51ENR:04:18:12SCN:04:19:59CLR:04:30:33");

    doTest("T98",
        "[WRCAD] [WRCAD] Add:3280 Wadsworth Blvd Type: SICK PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0720201205966-001471",
        "ADDR:3280 Wadsworth Blvd",
        "CALL:SICK",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0720201205966-001471");

    doTest("T99",
        "[WRCAD] [WRCAD] Add:3315 Sheridan Blvd Type: FA PgH-20 Units:WR1,WRD71Radio:TAC2 Case#:0720201205966-001472",
        "ADDR:3315 Sheridan Blvd",
        "CALL:FA",
        "MAP:H-20",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0720201205966-001472");

    doTest("T100",
        "[WRCAD] [WRCAD] Add:3227 Chase St Type: SICK PgH-19 Units:WR2,WM2Radio:TAC2 Case#:0720201205966-001473",
        "ADDR:3227 Chase St",
        "CALL:SICK",
        "MAP:H-19",
        "UNIT:WR2,WM2",
        "CH:TAC2",
        "ID:0720201205966-001473");

    doTest("T101",
        "[WRCAD] [WRCAD] Alarm #0720201205966-016878DISP: 10:12:51ENR:10:15:01SCN:10:17:59CLR:10:26:03",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0720201205966-016878DISP: 10:12:51ENR:10:15:01SCN:10:17:59CLR:10:26:03");

    doTest("T102",
        "[WRCAD] [WRCAD] Add:7340 W 38th Ave Type: DIABE PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0720201205966-001474",
        "ADDR:7340 W 38th Ave",
        "CALL:DIABE",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0720201205966-001474");

    doTest("T103",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: UNC PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0720201205966-001475",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0720201205966-001475");

    doTest("T104",
        "[WRCAD] [WRCAD] Add:2620 Quay St Type: BREAT PgH-18 Units:WR2,WM3Radio:TAC2 Case#:0720201205966-001476",
        "ADDR:2620 Quay St",
        "CALL:BREAT",
        "MAP:H-18",
        "UNIT:WR2,WM3",
        "CH:TAC2",
        "ID:0720201205966-001476");

    doTest("T105",
        "[WRCAD] [WRCAD] Add:7780 W 38th Ave Type: PSYCH PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0720201205966-001477",
        "ADDR:7780 W 38th Ave",
        "CALL:PSYCH",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0720201205966-001477");

    doTest("T106",
        "[WRCAD] [WRCAD] Add:3765 Holland St Type: MALM PgH-17 Units:WR1,WM4Radio:TAC2 Case#:0720201205966-001478",
        "ADDR:3765 Holland St",
        "CALL:MALM",
        "MAP:H-17",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0720201205966-001478");

    doTest("T107",
        "[WRCAD] [WRCAD] Add:6499 W 38th Ave Type: OD PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0720201205966-001479",
        "ADDR:6499 W 38th Ave",
        "CALL:OD",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0720201205966-001479");

    doTest("T108",
        "[WRCAD] [WRCAD] Add:10901 W 38th Ave Type: TEST PgH-16 Units:WRT72,WR2Radio:TAC2 Case#:0720201205966-001480",
        "ADDR:10901 W 38th Ave",
        "CALL:TEST",
        "MAP:H-16",
        "UNIT:WRT72,WR2",
        "CH:TAC2",
        "ID:0720201205966-001480");

    doTest("T109",
        "[WRCAD] [WRCAD] Add:6340 W 38th Ave Type: MALM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0720201205966-001480",
        "ADDR:6340 W 38th Ave",
        "CALL:MALM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0720201205966-001480");

    doTest("T110",
        "[WRCAD] [WRCAD] Add:3880 Upham St Type: MED PgG-18 Units:WR1Radio:FDISP Case#:0720201205966-001481",
        "ADDR:3880 Upham St",
        "CALL:MED",
        "MAP:G-18",
        "UNIT:WR1",
        "CH:FDISP",
        "ID:0720201205966-001481");

    doTest("T111",
        "[WRCAD] [WRCAD] Alarm #0720201205966-016955DISP: 22:48:26ENR: SCN: CLR:22:50:10",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0720201205966-016955DISP: 22:48:26ENR: SCN: CLR:22:50:10");

    doTest("T112",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: CHEST PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0721201205966-001481",
        "ADDR:2800 Youngfield St",
        "CALL:CHEST",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0721201205966-001481");

    doTest("T113",
        "[WRCAD] [WRCAD] Add:4155 Sheridan Blvd Type: FALL PgG-20 Units:WR1,WM1Radio:TAC2 Case#:0721201205966-001483",
        "ADDR:4155 Sheridan Blvd",
        "CALL:FALL",
        "MAP:G-20",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0721201205966-001483");

    doTest("T114",
        "[WRCAD] [WRCAD] Add:8300 W 38th Ave Type: FA PgH-18 Units:WR1,WRD71Radio:TAC2 Case#:0721201205966-001484",
        "ADDR:8300 W 38th Ave",
        "CALL:FA",
        "MAP:H-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0721201205966-001484");

    doTest("T115",
        "[WRCAD] [WRCAD] Alarm #0721201205966-016999DISP: 12:39:17ENR:12:41:12SCN:12:43:54CLR:13:05:16",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0721201205966-016999DISP: 12:39:17ENR:12:41:12SCN:12:43:54CLR:13:05:16");

    doTest("T116",
        "[WRCAD] [WRCAD] Add:5808 W 38th Ave Type: CHEST PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0721201205966-001485",
        "ADDR:5808 W 38th Ave",
        "CALL:CHEST",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0721201205966-001485");

    doTest("T117",
        "[WRCAD] [WRCAD] Add:11860 Tabor Dr Type: SUICI PgH-15 Units:WR2,WM4Radio:TAC2 Case#:0721201205966-001486",
        "ADDR:11860 Tabor Dr",
        "CALL:SUICI",
        "MAP:H-15",
        "UNIT:WR2,WM4",
        "CH:TAC2",
        "ID:0721201205966-001486");

    doTest("T118",
        "[WRCAD] [WRCAD] Alarm #0721201205966-017013DISP: 14:49:15ENR:14:51:13SCN:14:56:03CLR:15:16:12",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0721201205966-017013DISP: 14:49:15ENR:14:51:13SCN:14:56:03CLR:15:16:12");

    doTest("T119",
        "[WRCAD] [WRCAD] Alarm #0721201205966-017014DISP: 14:59:41ENR:15:01:08SCN:15:03:48CLR:15:41:50",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0721201205966-017014DISP: 14:59:41ENR:15:01:08SCN:15:03:48CLR:15:41:50");

    doTest("T120",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: FALL PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0721201205966-001487",
        "ADDR:2800 Youngfield St",
        "CALL:FALL",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0721201205966-001487");

    doTest("T121",
        "[WRCAD] [WRCAD] Add:Wb I70 Ramp Type:AAH PgG-15 Cross:TURNAROUND/WB I70 Case#:0722201205966-001488",
        "ADDR:Wb I70 Ramp",
        "MADDR:I 70 Ramp & TURNAROUND",
        "CALL:AAH",
        "MAP:G-15",
        "X:TURNAROUND/WB I70",
        "ID:0722201205966-001488");

    doTest("T122",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: FAINT PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0722201205966-001489",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:FAINT",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0722201205966-001489");

    doTest("T123",
        "[WRCAD] [WRCAD] Add:10700 W 38th Ave Type: SICK PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0722201205966-001490",
        "ADDR:10700 W 38th Ave",
        "CALL:SICK",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0722201205966-001490");

    doTest("T124",
        "[WRCAD] [WRCAD] Add:3710 Independence St Type: ASST PgH-17 Units:WR1Radio:TAC2 Case#:0722201205966-001491",
        "ADDR:3710 Independence St",
        "CALL:ASST",
        "MAP:H-17",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0722201205966-001491");

    doTest("T125",
        "[WRCAD] [WRCAD] Add:3400 Lutheran Pkwy W Type: SZ PgH-18 Units:WR1,WM2Radio:TAC2 Case#:0722201205966-001492",
        "ADDR:3400 Lutheran Pkwy W",
        "CALL:SZ",
        "MAP:H-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0722201205966-001492");

    doTest("T126",
        "[WRCAD] [WRCAD] Alarm #0722201205966-017089DISP: 13:02:58ENR:13:03:48SCN: CLR:13:29:53",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0722201205966-017089DISP: 13:02:58ENR:13:03:48SCN: CLR:13:29:53");

    doTest("T127",
        "[WRCAD] [WRCAD] Add:W 44th Ave & Saulsbury St Type: UNKF PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0722201205966-001493",
        "ADDR:W 44th Ave & Saulsbury St",
        "CALL:UNKF",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0722201205966-001493");

    doTest("T128",
        "[WRCAD] [WRCAD] Alarm #0722201205966-017133DISP: 22:11:52ENR:22:13:43SCN:22:15:09CLR:22:24:29",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0722201205966-017133DISP: 22:11:52ENR:22:13:43SCN:22:15:09CLR:22:24:29");

    doTest("T129",
        "[WRCAD] [WRCAD] Add:7669 W 32nd Ave Type: SZ PgH-18 Units:WR1,WM1Radio:TAC2 Case#:0723201205966-001494",
        "ADDR:7669 W 32nd Ave",
        "CALL:SZ",
        "MAP:H-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0723201205966-001494");

    doTest("T130",
        "[WRCAD] [WRCAD] Add:6761 W 36th Pl Type: SICK PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0723201205966-001495",
        "ADDR:6761 W 36th Pl",
        "CALL:SICK",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0723201205966-001495");

    doTest("T131",
        "[WRCAD] [WRCAD] Add:3340 Wright St Type: ODOR PgH-15 Units:WRD71,WR1Radio:TAC2 Case#:0723201205966-001496",
        "ADDR:3340 Wright St",
        "CALL:ODOR",
        "MAP:H-15",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0723201205966-001496");

    doTest("T132",
        "[WRCAD] [WRCAD] Alarm #0723201205966-017157DISP: 08:16:50ENR:08:19:47SCN: CLR:08:22:55",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0723201205966-017157DISP: 08:16:50ENR:08:19:47SCN: CLR:08:22:55");

    doTest("T133",
        "[WRCAD] [WRCAD] Add:4718 Quay St Type: BREAT PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0723201205966-001497",
        "ADDR:4718 Quay St",
        "CALL:BREAT",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0723201205966-001497");

    doTest("T134",
        "[WRCAD] [WRCAD] Add:3955 Wadsworth Blvd Type: UNC PgG-18 Units:WR1,WM4Radio:TAC2 Case#:0723201205966-001498",
        "ADDR:3955 Wadsworth Blvd",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0723201205966-001498");

    doTest("T135",
        "[WRCAD] [WRCAD] Add:3800 Youngfield St Type: UNC PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0723201205966-001499",
        "ADDR:3800 Youngfield St",
        "CALL:UNC",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0723201205966-001499");

    doTest("T136",
        "[WRCAD] [WRCAD] Add:3210 Lutheran Pkwy Type: SICK PgH-17 Units:WR2,WM2Radio:TAC2 Case#:0723201205966-001500",
        "ADDR:3210 Lutheran Pkwy",
        "CALL:SICK",
        "MAP:H-17",
        "UNIT:WR2,WM2",
        "CH:TAC2",
        "ID:0723201205966-001500");

    doTest("T137",
        "[WRCAD] [WRCAD] Alarm #0723201205966-017210DISP: 18:26:29ENR:18:28:22SCN: CLR:18:28:24",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0723201205966-017210DISP: 18:26:29ENR:18:28:22SCN: CLR:18:28:24");

    doTest("T138",
        "[WRCAD] [WRCAD] Add:4401 Wadsworth Blvd Type: UNC PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0724201205966-001501",
        "ADDR:4401 Wadsworth Blvd",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0724201205966-001501");

    doTest("T139",
        "[WRCAD] [WRCAD] Add:6340 W 38th Ave Type: BREAT PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0724201205966-001502",
        "ADDR:6340 W 38th Ave",
        "CALL:BREAT",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0724201205966-001502");

    doTest("T140",
        "[WRCAD] [WRCAD] Add:3500 Miller Ct Type: BLEED PgH-16 Units:WR2,WM3Radio:TAC2 Case#:0724201205966-001503",
        "ADDR:3500 Miller Ct",
        "CALL:BLEED",
        "MAP:H-16",
        "UNIT:WR2,WM3",
        "CH:TAC2",
        "ID:0724201205966-001503");

    doTest("T141",
        "[WRCAD] [WRCAD] Add:3802 Parfet St Type: FALL PgG-16 Units:WR1,WM3Radio:TAC2 Case#:0724201205966-001504",
        "ADDR:3802 Parfet St",
        "CALL:FALL",
        "MAP:G-16",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0724201205966-001504");

    doTest("T142",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Sheridan Blvd Type: AA PgH-20 Units:WR1,WM1Radio:TAC2 Case#:0724201205966-001505",
        "ADDR:W 38th Ave & Sheridan Blvd",
        "CALL:AA",
        "MAP:H-20",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0724201205966-001505");

    doTest("T143",
        "[WRCAD] [WRCAD] Add:3765 Marshall St Type: COM PgH-19 Units:WR1,WM1,WRD71Radio:TAC2 Case#:0725201205966-001506",
        "ADDR:3765 Marshall St",
        "CALL:COM",
        "MAP:H-19",
        "UNIT:WR1,WM1,WRD71",
        "CH:TAC2",
        "ID:0725201205966-001506");

    doTest("T144",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: ABDOM PgH-15 Units:WR1,WM3Radio:TAC2 Case#:0725201205966-001507",
        "ADDR:2800 Youngfield St",
        "CALL:ABDOM",
        "MAP:H-15",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0725201205966-001507");

    doTest("T145",
        "[WRCAD] [WRCAD] Add:W 26th Ave & Allison St Type: UNKM PgI-18 Units:WR1,WM1Radio:TAC2 Case#:0725201205966-001508",
        "ADDR:W 26th Ave & Allison St",
        "CALL:UNKM",
        "MAP:I-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0725201205966-001508");

    doTest("T146",
        "[WRCAD] [WRCAD] Add:3880 Dover St Type: SICK PgG-17 Units:WR1,WM2Radio:TAC2 Case#:0725201205966-001509",
        "ADDR:3880 Dover St",
        "CALL:SICK",
        "MAP:G-17",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0725201205966-001509");

    doTest("T147",
        "[WRCAD] [WRCAD] Add:6301 W 38th Ave Type: FALL PgH-19 Units:WR1,WM3Radio:TAC2 Case#:0725201205966-001510",
        "ADDR:6301 W 38th Ave",
        "CALL:FALL",
        "MAP:H-19",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0725201205966-001510");

    doTest("T148",
        "[WRCAD] [WRCAD] Add:7250 W 31st Pl Type: CO PgH-18 Units:WR1Radio:TAC2 Case#:0725201205966-001511",
        "ADDR:7250 W 31st Pl",
        "CALL:CO",
        "MAP:H-18",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0725201205966-001511");

    doTest("T149",
        "[WRCAD] [WRCAD] Alarm #0725201205966-017361DISP: 09:55:39ENR:09:57:15SCN:10:05:46CLR:10:10:42",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0725201205966-017361DISP: 09:55:39ENR:09:57:15SCN:10:05:46CLR:10:10:42");

    doTest("T150",
        "[WRCAD] [WRCAD] Add:W 32nd Ave & Wadsworth Blvd Type: AA PgH-18 Units:WR1,WM2Radio:TAC2 Case#:0725201205966-001512",
        "ADDR:W 32nd Ave & Wadsworth Blvd",
        "CALL:AA",
        "MAP:H-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0725201205966-001512");

    doTest("T151",
        "[WRCAD] [WRCAD] Add:10474 W 38th Ave Type: INV PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0725201205966-001513",
        "ADDR:10474 W 38th Ave",
        "CALL:INV",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0725201205966-001513");

    doTest("T152",
        "[WRCAD] [WRCAD] Add:6650 W 46th Pl Type: UNC PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0725201205966-001514",
        "ADDR:6650 W 46th Pl",
        "CALL:UNC",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0725201205966-001514");

    doTest("T153",
        "[WRCAD] [WRCAD] Add:2625 Kipling St Type: FA PgH-17 Units:WRD71,WR1Radio:TAC2 Case#:0725201205966-001515",
        "ADDR:2625 Kipling St",
        "CALL:FA",
        "MAP:H-17",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0725201205966-001515");

    doTest("T154",
        "[WRCAD] [WRCAD] Add:3400 Youngfield St Type: FA PgH-15 Units:WRD71,WR1Radio:TAC2 Case#:0726201205966-001516",
        "ADDR:3400 Youngfield St",
        "CALL:FA",
        "MAP:H-15",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0726201205966-001516");

    doTest("T155",
        "[WRCAD] [WRCAD] Add:3835 Harlan St Type: SICK PgG-19 Units:WR1,WM3Radio:TAC2 Case#:0726201205966-001517",
        "ADDR:3835 Harlan St",
        "CALL:SICK",
        "MAP:G-19",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0726201205966-001517");

    doTest("T156",
        "[WRCAD] [WRCAD] Add:3664 Depew St Type: MALM PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0726201205966-001518",
        "ADDR:3664 Depew St",
        "CALL:MALM",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0726201205966-001518");

    doTest("T157",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: UNC PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0726201205966-001519",
        "ADDR:2800 Youngfield St",
        "CALL:UNC",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0726201205966-001519");

    doTest("T158",
        "[WRCAD] [WRCAD] Add:2720 Fenton St Type: ASSAU PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0727201205966-001520",
        "ADDR:2720 Fenton St",
        "CALL:ASSAU",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0727201205966-001520");

    doTest("T159",
        "[WRCAD] [WRCAD] Add:7822 W 39th Ave Type: FALL PgG-18 Units:WM1,WR1Radio:TAC2 Case#:0727201205966-001521",
        "ADDR:7822 W 39th Ave",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WM1,WR1",
        "CH:TAC2",
        "ID:0727201205966-001521");

    doTest("T160",
        "[WRCAD] [WRCAD] Add:3775 Depew St Type: UNC PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0727201205966-001522",
        "ADDR:3775 Depew St",
        "CALL:UNC",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0727201205966-001522");

    doTest("T161",
        "[WRCAD] [WRCAD] Add:W 38th Ave & Kipling St Type: AA PgH-17 Units:WR1,WM4Radio:TAC2 Case#:0727201205966-001523",
        "ADDR:W 38th Ave & Kipling St",
        "CALL:AA",
        "MAP:H-17",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0727201205966-001523");

    doTest("T162",
        "[WRCAD] [WRCAD] Add:4150 Yarrow Ct Type: UNKM PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0727201205966-001524",
        "ADDR:4150 Yarrow Ct",
        "CALL:UNKM",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0727201205966-001524");

    doTest("T163",
        "[WRCAD] [WRCAD] Add:3606 Depew St Type: HEAD PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0728201205966-001525",
        "ADDR:3606 Depew St",
        "CALL:HEAD",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0728201205966-001525");

    doTest("T164",
        "[WRCAD] [WRCAD] Add:7822 W 39th Ave Type: UNC PgG-18 Units:WM2,WR1Radio:TAC2 Case#:0728201205966-001526",
        "ADDR:7822 W 39th Ave",
        "CALL:UNC",
        "MAP:G-18",
        "UNIT:WM2,WR1",
        "CH:TAC2",
        "ID:0728201205966-001526");

    doTest("T165",
        "[WRCAD] [WRCAD] Add:12060 W 32nd Dr Type: BREAT PgH-15 Units:WM2,WR1Radio:TAC2 Case#:0728201205966-001527",
        "ADDR:12060 W 32nd Dr",
        "CALL:BREAT",
        "MAP:H-15",
        "UNIT:WM2,WR1",
        "CH:TAC2",
        "ID:0728201205966-001527");

    doTest("T166",
        "[WRCAD] [WRCAD] Add:3540 Youngfield St Type: ASST PgH-15 Units:WR1Radio:TAC2 Case#:0728201205966-001528",
        "ADDR:3540 Youngfield St",
        "CALL:ASST",
        "MAP:H-15",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0728201205966-001528");

    doTest("T167",
        "[WRCAD] [WRCAD] Alarm #0728201205966-017639DISP: 13:08:43ENR:13:09:45SCN:13:11:11CLR:13:19:20",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0728201205966-017639DISP: 13:08:43ENR:13:09:45SCN:13:11:11CLR:13:19:20");

    doTest("T168",
        "[WRCAD] [WRCAD] Add:11965 Applewood Knolls Dr Type: DIABE PgH-15 Units:WR1,WM2Radio:TAC2 Case#:0728201205966-001529",
        "ADDR:11965 Applewood Knolls Dr",
        "CALL:DIABE",
        "MAP:H-15",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0728201205966-001529");

    doTest("T169",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: CHEST PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0729201205966-001530",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:CHEST",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0729201205966-001530");

    doTest("T170",
        "[WRCAD] [WRCAD] Add:3300 Fenton St Type: UNKM PgH-19 Units:WR1,WM1Radio:TAC2 Case#:0729201205966-001531",
        "ADDR:3300 Fenton St",
        "CALL:UNKM",
        "MAP:H-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0729201205966-001531");

    doTest("T171",
        "[WRCAD] [WRCAD] Alarm #0729201205966-017703DISP: 07:31:46ENR:07:33:05SCN: CLR:07:55:51",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0729201205966-017703DISP: 07:31:46ENR:07:33:05SCN: CLR:07:55:51");

    doTest("T172",
        "[WRCAD] [WRCAD] Add:3885 Upham St Type: ELEV PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0729201205966-001532",
        "ADDR:3885 Upham St",
        "CALL:ELEV",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0729201205966-001532");

    doTest("T173",
        "[WRCAD] [WRCAD] Add:4265 Kendall St Type: ALLER PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0729201205966-001533",
        "ADDR:4265 Kendall St",
        "CALL:ALLER",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0729201205966-001533");

    doTest("T174",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: FALL PgH-15 Units:WR1,WM4Radio:TAC2 Case#:0729201205966-001534",
        "ADDR:2800 Youngfield St",
        "CALL:FALL",
        "MAP:H-15",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0729201205966-001534");

    doTest("T175",
        "[WRCAD] [WRCAD] Add:2615 Oak Dr Type: Fall PgH-16 Units:WR1,WM1Radio:TAC2 Case#:0729201205966-001535",
        "ADDR:2615 Oak Dr",
        "CALL:Fall",
        "MAP:H-16",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0729201205966-001535");

    doTest("T176",
        "[WRCAD] [WRCAD] Add:10451 W 38th Ave Type: Chest PgH-16 Units:WR1,WM1Radio:TAC2 Case#:0729201205966-001536",
        "ADDR:10451 W 38th Ave",
        "CALL:Chest",
        "MAP:H-16",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0729201205966-001536");

    doTest("T177",
        "[WRCAD] [WRCAD] Add:3580 Lewis St Type: LINE PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0729201205966-001537",
        "ADDR:3580 Lewis St",
        "CALL:LINE",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0729201205966-001537");

    doTest("T178",
        "[WRCAD] [WRCAD] Add:2815 Ames St Type: CHEST PgH-19 Units:WR2,WM1Radio:TAC2 Case#:0729201205966-001538",
        "ADDR:2815 Ames St",
        "CALL:CHEST",
        "MAP:H-19",
        "UNIT:WR2,WM1",
        "CH:TAC2",
        "ID:0729201205966-001538");

    doTest("T179",
        "[WRCAD] [WRCAD] Add:4145 Ammons St Type: FALL PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0729201205966-001539",
        "ADDR:4145 Ammons St",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0729201205966-001539");

    doTest("T180",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: ETOH PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0730201205966-001540",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:ETOH",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0730201205966-001540");

    doTest("T181",
        "[WRCAD] [WRCAD] Add:4125 Newland St Type: MALM PgG-19 Units:WR1,WM2Radio:TAC2 Case#:0730201205966-001541",
        "ADDR:4125 Newland St",
        "CALL:MALM",
        "MAP:G-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0730201205966-001541");

    doTest("T182",
        "[WRCAD] [WRCAD] Add:10520 W 35th Ave Type: FA PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0730201205966-001542",
        "ADDR:10520 W 35th Ave",
        "CALL:FA",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0730201205966-001542");

    doTest("T183",
        "[WRCAD] [WRCAD] Add:3550 LUTHERAN PKWY W Type: STROK PgH-17 Units:WR1,WM1Radio: Case#:0730201205966-001543",
        "ADDR:3550 LUTHERAN PKWY W",
        "CALL:STROK",
        "MAP:H-17",
        "UNIT:WR1,WM1",
        "ID:0730201205966-001543");

    doTest("T184",
        "[WRCAD] [WRCAD] Add:3550 Lutheran Pkwy W Type: BREAT PgH-17 Units:WR2Radio:TAC2 Case#:0730201205966-001544",
        "ADDR:3550 Lutheran Pkwy W",
        "CALL:BREAT",
        "MAP:H-17",
        "UNIT:WR2",
        "CH:TAC2",
        "ID:0730201205966-001544");

    doTest("T185",
        "[WRCAD] [WRCAD] Add:3915 Upham St Type: FALL PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0730201205966-001545",
        "ADDR:3915 Upham St",
        "CALL:FALL",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0730201205966-001545");

    doTest("T186",
        "[WRCAD] [WRCAD] Add:Wadsworth Blvd & W 44th Ave Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0730201205966-001546",
        "ADDR:Wadsworth Blvd & W 44th Ave",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0730201205966-001546");

    doTest("T187",
        "[WRCAD] [WRCAD] Add:6340 W 38th Ave Type: BREAT PgH-19 Units:WR2,WM3Radio:TAC2 Case#:0730201205966-001547",
        "ADDR:6340 W 38th Ave",
        "CALL:BREAT",
        "MAP:H-19",
        "UNIT:WR2,WM3",
        "CH:TAC2",
        "ID:0730201205966-001547");

    doTest("T188",
        "[WRCAD] [WRCAD] Add:4360 Marshall St Type: ASST PgG-19 Units:WR1Radio:TAC2 Case#:0730201205966-001548",
        "ADDR:4360 Marshall St",
        "CALL:ASST",
        "MAP:G-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0730201205966-001548");

    doTest("T189",
        "[WRCAD] [WRCAD] Add:6690 W 47th Ave Type: CO PgG-19 Units:WR1Radio:TAC2 Case#:0730201205966-001549",
        "ADDR:6690 W 47th Ave",
        "CALL:CO",
        "MAP:G-19",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0730201205966-001549");

    doTest("T190",
        "[WRCAD] [WRCAD] Alarm #0730201205966-017818DISP: 17:07:45ENR:17:10:03SCN:17:22:49CLR:17:22:59",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0730201205966-017818DISP: 17:07:45ENR:17:10:03SCN:17:22:49CLR:17:22:59");

    doTest("T191",
        "[WRCAD] [WRCAD] Add:3720 Yukon Ct Type: ODORC PgH-18 Units:WR1,WRD71Radio:TAC2 Case#:0730201205966-001550",
        "ADDR:3720 Yukon Ct",
        "CALL:ODORC",
        "MAP:H-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0730201205966-001550");

    doTest("T192",
        "[WRCAD] [WRCAD] Alarm #0730201205966-017824DISP: 17:41:09ENR:17:42:58SCN:17:44:31CLR:18:08:45",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0730201205966-017824DISP: 17:41:09ENR:17:42:58SCN:17:44:31CLR:18:08:45");

    doTest("T193",
        "[WRCAD] [WRCAD] Add:11965 Applewood Knolls Dr Type: DIABE PgH-15 Units:WR1,WM3Radio:TAC2 Case#:0730201205966-001551",
        "ADDR:11965 Applewood Knolls Dr",
        "CALL:DIABE",
        "MAP:H-15",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0730201205966-001551");

    doTest("T194",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: Fall PgH-15 Units:WR1,WM2Radio:TAC2 Case#:0731201205966-001552",
        "ADDR:2800 Youngfield St",
        "CALL:Fall",
        "MAP:H-15",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0731201205966-001552");

    doTest("T195",
        "[WRCAD] [WRCAD] Add:W 26th Ave & Garland St Type: UNC PgH-17 Units:WR1,WM1Radio:TAC2 Case#:0731201205966-001553",
        "ADDR:W 26th Ave & Garland St",
        "CALL:UNC",
        "MAP:H-17",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0731201205966-001553");

    doTest("T196",
        "[WRCAD] [WRCAD] Add:3895 Pierson Ct Type: FAR PgG-16 Units:WRD71,WR1Radio:TAC2 Case#:0731201205966-001554",
        "ADDR:3895 Pierson Ct",
        "CALL:FAR",
        "MAP:G-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0731201205966-001554");

    doTest("T197",
        "[WRCAD] [WRCAD] Alarm #0731201205966-017908DISP: 14:58:11ENR:14:59:53SCN:15:10:52CLR:15:17:44",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0731201205966-017908DISP: 14:58:11ENR:14:59:53SCN:15:10:52CLR:15:17:44");

    doTest("T198",
        "[WRCAD] [WRCAD] Add:4340 Marshall St Type: BREAT PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0731201205966-001555",
        "ADDR:4340 Marshall St",
        "CALL:BREAT",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0731201205966-001555");

    doTest("T199",
        "[WRCAD] [WRCAD] Add:3745 Quail St Type: ODOR PgH-16 Units:WRD71,WR1Radio:TAC2 Case#:0731201205966-001556",
        "ADDR:3745 Quail St",
        "CALL:ODOR",
        "MAP:H-16",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0731201205966-001556");

    doTest("T200",
        "[WRCAD] [WRCAD] Add:7801 W 35th Ave Type: SICK PgH-18 Units:WR1,WM2Radio:TAC2 Case#:0801201205966-001557",
        "ADDR:7801 W 35th Ave",
        "CALL:SICK",
        "MAP:H-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0801201205966-001557");

    doTest("T201",
        "[WRCAD] [WRCAD] Add:W 44th Ave & Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0801201205966-001558",
        "ADDR:W 44th Ave & Wadsworth Blvd",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0801201205966-001558");

    doTest("T202",
        "[WRCAD] [WRCAD] Alarm #0801201205966-017951DISP: 08:56:38ENR:08:58:33SCN:09:00:43CLR:09:20:54",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0801201205966-017951DISP: 08:56:38ENR:08:58:33SCN:09:00:43CLR:09:20:54");

    doTest("T203",
        "[WRCAD] [WRCAD] Add:6350 W 38th Ave Type: SICK PgH-19 Units:WR1,WM3Radio:TAC2 Case#:0801201205966-001559",
        "ADDR:6350 W 38th Ave",
        "CALL:SICK",
        "MAP:H-19",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0801201205966-001559");

    doTest("T204",
        "[WRCAD] [WRCAD] Add:3010 Gray St Type: ABDOM PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0801201205966-001560",
        "ADDR:3010 Gray St",
        "CALL:ABDOM",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0801201205966-001560");

    doTest("T205",
        "[WRCAD] [WRCAD] Add:3725 Fenton St Type: ALTER PgH-19 Units:WR1,WM3Radio:TAC2 Case#:0801201205966-001561",
        "ADDR:3725 Fenton St",
        "CALL:ALTER",
        "MAP:H-19",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0801201205966-001561");

    doTest("T206",
        "[WRCAD] [WRCAD] Add:4608 Teller St Type: OD PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0801201205966-001562",
        "ADDR:4608 Teller St",
        "CALL:OD",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0801201205966-001562");

    doTest("T207",
        "[WRCAD] [WRCAD] Add:3835 Harlan St Type: FALL PgG-19 Units:WR1,WM1Radio:TAC2 Case#:0801201205966-001563",
        "ADDR:3835 Harlan St",
        "CALL:FALL",
        "MAP:G-19",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0801201205966-001563");

    doTest("T208",
        "[WRCAD] [WRCAD] Add:5301 W 38th Ave Type: UNC PgH-19 Units:WR1,WM4Radio:TAC2 Case#:0801201205966-001564",
        "ADDR:5301 W 38th Ave",
        "CALL:UNC",
        "MAP:H-19",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0801201205966-001564");

    doTest("T209",
        "[WRCAD] [WRCAD] Add:2800 Youngfield St Type: FALL PgH-15 Units:WR1,WM1Radio:TAC2 Case#:0801201205966-001565",
        "ADDR:2800 Youngfield St",
        "CALL:FALL",
        "MAP:H-15",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0801201205966-001565");

    doTest("T210",
        "[WRCAD] [WRCAD] Add:10802 W 28th Pl Type: BREAT PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0801201205966-001566",
        "ADDR:10802 W 28th Pl",
        "CALL:BREAT",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0801201205966-001566");

    doTest("T211",
        "[WRCAD] [WRCAD] Alarm #0801201205966-018024DISP: 22:57:34ENR:22:59:08SCN: CLR:23:01:00",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0801201205966-018024DISP: 22:57:34ENR:22:59:08SCN: CLR:23:01:00");

    doTest("T212",
        "[WRCAD] [WRCAD] Add:4200 Wadsworth Blvd Type: AA PgG-18 Units:WR1,WM1Radio:TAC2 Case#:0802201205966-001567",
        "ADDR:4200 Wadsworth Blvd",
        "CALL:AA",
        "MAP:G-18",
        "UNIT:WR1,WM1",
        "CH:TAC2",
        "ID:0802201205966-001567");

    doTest("T213",
        "[WRCAD] [WRCAD] Add:4643 Wadsworth Blvd Type: BREAT PgG-18 Units:WR1,WM2Radio:TAC2 Case#:0802201205966-001568",
        "ADDR:4643 Wadsworth Blvd",
        "CALL:BREAT",
        "MAP:G-18",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0802201205966-001568");

    doTest("T214",
        "[WRCAD] [WRCAD] Add:3777 Kipling St Type: CHEST PgH-17 Units:WR2,WM1Radio:TAC2 Case#:0802201205966-001569",
        "ADDR:3777 Kipling St",
        "CALL:CHEST",
        "MAP:H-17",
        "UNIT:WR2,WM1",
        "CH:TAC2",
        "ID:0802201205966-001569");

    doTest("T215",
        "[WRCAD] [WRCAD] Add:10390 W 38th Ave Type: UNC PgH-16 Units:WR1,WM4Radio:TAC2 Case#:0802201205966-001570",
        "ADDR:10390 W 38th Ave",
        "CALL:UNC",
        "MAP:H-16",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0802201205966-001570");

    doTest("T216",
        "[WRCAD] [WRCAD] Add:9730 W 41st Ave Type: FALL PgG-17 Units:WR1,WM4Radio:TAC2 Case#:0802201205966-001571",
        "ADDR:9730 W 41st Ave",
        "CALL:FALL",
        "MAP:G-17",
        "UNIT:WR1,WM4",
        "CH:TAC2",
        "ID:0802201205966-001571");

    doTest("T217",
        "[WRCAD] [WRCAD] Add:W 26th Ave & Kipling St Type: SPILL PgH-17 Units:WR1Radio:TAC2 Case#:0802201205966-001572",
        "ADDR:W 26th Ave & Kipling St",
        "CALL:SPILL",
        "MAP:H-17",
        "UNIT:WR1",
        "CH:TAC2",
        "ID:0802201205966-001572");

    doTest("T218",
        "[WRCAD] [WRCAD] Alarm #0802201205966-018099DISP: 17:48:10ENR:17:52:38SCN:17:54:22CLR:18:01:20",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0802201205966-018099DISP: 17:48:10ENR:17:52:38SCN:17:54:22CLR:18:01:20");

    doTest("T219",
        "[WRCAD] [WRCAD] Add:6340 W 38th Ave Type: BREAT PgH-19 Units:WR1,WM2Radio:TAC2 Case#:0802201205966-001573",
        "ADDR:6340 W 38th Ave",
        "CALL:BREAT",
        "MAP:H-19",
        "UNIT:WR1,WM2",
        "CH:TAC2",
        "ID:0802201205966-001573");

    doTest("T220",
        "[WRCAD] [WRCAD] Add:3300 Youngfield St Type: GAS PgH-15 Units:WRD71,WR1Radio:TAC2 Case#:0803201205966-001574",
        "ADDR:3300 Youngfield St",
        "CALL:GAS",
        "MAP:H-15",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0803201205966-001574");

    doTest("T221",
        "[WRCAD] [WRCAD] Add:2684 Paramount Pkwy Type: FALL PgH-16 Units:WR1,WM3Radio:TAC2 Case#:0803201205966-001575",
        "ADDR:2684 Paramount Pkwy",
        "CALL:FALL",
        "MAP:H-16",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0803201205966-001575");

    doTest("T222",
        "[WRCAD] [WRCAD] Add:3550 Lutheran Pkwy W Type: CHEST PgH-17 Units:WR1,WM3Radio:TAC2 Case#:0803201205966-001576",
        "ADDR:3550 Lutheran Pkwy W",
        "CALL:CHEST",
        "MAP:H-17",
        "UNIT:WR1,WM3",
        "CH:TAC2",
        "ID:0803201205966-001576");

    doTest("T223",
        "[WRCAD] [WRCAD] Add:W 32nd Ave & Youngfield St Apt: Type: AA Map PgH-15 Units:WR1,E5,M2Alarm# 0803201205909-018157",
        "ADDR:W 32nd Ave & Youngfield St",
        "CALL:AA",
        "MAP:H-15",
        "UNIT:WR1,E5,M2",
        "ID:0803201205909-018157");

    doTest("T224",
        "[WRCAD] [WRCAD] Add:3600 Youngfield St Type: FA PgH-15 Units:WRD71,WR1Radio:TAC2 Case#:0803201205966-001578",
        "ADDR:3600 Youngfield St",
        "CALL:FA",
        "MAP:H-15",
        "UNIT:WRD71,WR1",
        "CH:TAC2",
        "ID:0803201205966-001578");

    doTest("T225",
        "[WRCAD] [WRCAD] Add:6270 W 38th Ave Type: ALTER PgG-19 Units:WR2,WM4Radio:TAC2 Case#:0803201205966-001579",
        "ADDR:6270 W 38th Ave",
        "CALL:ALTER",
        "MAP:G-19",
        "UNIT:WR2,WM4",
        "CH:TAC2",
        "ID:0803201205966-001579");

    doTest("T226",
        "[WRCAD] [WRCAD] Alarm #0803201205966-018162DISP: 13:37:04ENR:13:38:00SCN:13:38:51CLR:14:00:24",
        "CALL:RUN REPORT",
        "PLACE:Alarm #0803201205966-018162DISP: 13:37:04ENR:13:38:00SCN:13:38:51CLR:14:00:24");

    doTest("T227",
        "[WRCAD] [WRCAD] Add:4335 Quay St Type: FAR PgG-18 Units:WR1,WRD71Radio:TAC2 Case#:0803201205966-001580",
        "ADDR:4335 Quay St",
        "CALL:FAR",
        "MAP:G-18",
        "UNIT:WR1,WRD71",
        "CH:TAC2",
        "ID:0803201205966-001580");

  }
  
  public static void main(String[] args) {
    new COJeffersonCountyParserTest().generateTests("T1");
  }
}
  