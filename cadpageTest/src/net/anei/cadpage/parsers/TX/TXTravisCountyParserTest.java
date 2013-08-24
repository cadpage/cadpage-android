package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Travis County, TX

Contact: Active911
Agency name: Travis County ESD #4
Location: Austin, TX, United States
Sender: PublicSafety@austintexas.gov

From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN04 On -AT FCOM E - AT -7657 Nez Perce Trce - INC# =>13046668 Case Num:ESD04-2013-0000689 For -ENG401
From -ESD04 Dispatch -1ALARM -ALARM - Fire Alarm - BOX -04-2602 On -AT FCOM E - AT -3207 Crownover St - INC# =>13046635 Case Num:ESD04-2013-0000688 For -ENG401
From -ESD12 Dispatch -1ALARM -EMS Allergic Reaction Code-3 - BOX -12-MN04 On -AT FCOM E - AT -15120 Arizona Oak Ln - INC# =>13046616 Case Num:ESD04-2013-0000687 For -ENG401
From -ESD04 Dispatch -1ALARM -HC - Hazardous Condition - BOX -04-4103 On -AT FCOM E - AT -9207 Wellesley Dr - INC# =>13046577 Case Num:ESD12-2013-0000727 For -ENG1201,SQ404
From -ESD04 Dispatch -1ALARM -EMS Fall Code-3 - BOX -04-2605 On -AT FCOM E - AT -10003 Fm 969 Rd - INC# =>13046572 Case Num:ESD04-2013-0000685 For -ENG401
From -ESD04 Dispatch -1ALARM -EMS Fall Code-3 - BOX -04-2602 On -AT FCOM E - AT -14523 Sandifer St - INC# =>13046209 Case Num:ESD04-2013-0000684 For -ENG401
From -ESD12 Dispatch -1ALARM -RESQV - Vehicle Rescue - BOX -12-MN07 On -FTAC 201 - AT -SCHMIDT LOOP / N FM 973 RD - INC# =>13046110 Case Num:ESD12-2013-0000723 For -ENG1201,SQ404,ENG401
From -ESD04 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -04-2801 On -AT FCOM E - AT -2201 - 2401 W Howard Ln - INC# =>13046021 Case Num:ESD04-2013-0000682 For -SQ404
From -ESD04 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -04-2602 On -AT FCOM E - AT -Fm 969 Rd / Hunters Bend Rd - INC# =>13046009 Case Num:ESD04-2013-0000681 For -ENG401,SQ404
From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN01 On -AT FCOM E - AT -19009 Fm 969 Rd - INC# =>13045957 Case Num:ESD04-2013-0000680 For -ENG401
From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN01 On -AT FCOM E - AT -21118 Blake Manor Rd - INC# =>13045865 Case Num:ESD04-2013-0000679 For -ENG401
From -ESD12 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -12-MN04 On -AT FCOM E - AT -N Sh 130 Sb / Fm 973 Rd To N Sh 130 Sb Ramp - INC# =>13045823 Case Num:ESD04-2013-0000678 For -ENG401
From -ESD04 Dispatch -1ALARM -EMS Choking Code-3 - BOX -04-2602 On -AT FCOM E - AT -2901 Caleb Dr - INC# =>13045573 Case Num:ESD04-2013-0000676 For -ENG401
From -ESD04 Dispatch -1ALARM -EMS Chest Pain Code-3 - BOX -04-2602 On -AT FCOM E - AT -Austins Colony Blvd / Westall St - INC# =>13045522 Case Num:ESD04-2013-0000675 For -ENG401
From -ESD12 Dispatch -1ALARM -EMS Assault Code-3 - BOX -12-MN04 On -AT FCOM E - AT -20812 Verna St - INC# =>13045513 Case Num:ESD04-2013-0000674 For -ENG401

Contact: Active911
Agency name: Westlake FD
Location: Austin, TX, United States
Sender: PublicSafety@austintexas.gov

From - ESD09 - 1 Alarm / EMS Sick Code-3 Box - 09-3209 @ 906 N Weston Ln XStreets: BRIGHTMAN LN/No CrossStreet Found On - AT FCOM W Time: 16:18:30 Inc# 13046505 Case Num: For - ENG1001
From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3702 @ Barton Creek Blvd / Fm 2244 Rd XStreets: On - AT FCOM W Time: 15:45:09 Inc# 13046497 Case Num: For - ENG902,ENG1001
From - ESD09 - 1 Alarm / EMS Seizure Code-3 Box - 09-3206 @ 1801 Georgia Landing Cv XStreets: CAPE CORAL DR/No CrossStreet Found On - AT FCOM W Time: 10:12:25 Inc# 13046402 Case Num: For - ENG902
From - ESD09 - 1 Alarm / EMS Respiratory Code-3 Box - 09-1004 @ 3403 Toro Canyon Rd XStreets: MANTLE DR/WHITETHORN CT On - AT FCOM W Time: 01:48:08 Inc# 13046323 Case Num: For - ENG901
From - ESD09 - 1 Alarm / EMS Sick Code-3 Box - 09-3106 @ 2407 Deer Pass XStreets: RIDGECREST DR/QUAIL RUN On - AT FCOM W Time: 00:59:42 Inc# 13046318 Case Num: For - ENG901
From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3207 @ 1309 Westbank Dr XStreets: MOON RIVER RD/ALLEN RD On - AT FCOM W Time: 14:41:20 Inc# 13046185 Case Num: For - ENG902,ENG901
From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3206 @ Bay Hill Dr / Quaker Ridge Dr XStreets: On - AT FCOM W Time: 42:27 PM Inc# 13045992 Case Num: For - ENG902,ENG901
From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3702 @ Fm 2244 Rd / Newhall Ln XStreets: On - AT FCOM W Time: 19:47:34 Inc# 13045925 Case Num: For - ENG902,ENG1001
From - ESD09 - 1 Alarm / EMS Unconscious Person Code-3 Box - 09-1004 @ 98 Redbud Trl XStreets: FOREST VIEW DR/WESTLAKE DR On - AT FCOM W Time: 18:17:39 Inc# 13045903 Case Num: For - ENG901

Contact: Active911
Agency name: Volente FD
Location: Austin, TX, United States
Sender: PublicSafety@austintexas.gov

From - ESD14 - 1 Alarm / EMS Fall Code-3 Box - 14-VL01 @ 16107 Wharf Cv XStreets: FM 2769 RD/No CrossStreet Found On - AT FCOM W Time: 19:57:17 Inc# 13046267 Case Num: For - ENG1401
From - ESD14 - 1 Alarm / EMS Sick Code-3 Box - 14-VL01 @ 7621 Debbie Dr XStreets: DAVY DR/DAVY DR On - AT FCOM W Time: 02:27:11 Inc# 13046042 Case Num: For - SQ1408
From - ESD14 - 1 Alarm / EMS Medical Alarm Code-3 Box - 14-VL01 @ 16609 Jackson St XStreets: ARREN TER/No CrossStreet Found On - AT FCOM W Time: 20:47:02 Inc# 13043589 Case Num: For - SQ1408
From - ESD14 - 1 Alarm / EMS Hemorrhage Code-3 Box - 14-VL02 @ 3018 Heathmount Dr XStreets: BEN DORAN CT/MORAY LN On - AT FCOM W Time: 07:28:44 Inc# 13043025 Case Num: For - SQ1408
From - ESD14 - 1 Alarm / SPILL - Liquid < 5 Gallons Box - 14-VL02 @ 2900 GRAND OAKS LOOP XStreets: GRANITE BASIN CT/MOSSY GROVE CT On - AT FCOM W Time: 16:53:49 Inc# 13042511 Case Num: For - QNT38
From - ESD14 - 1 Alarm / EMS Penetrating Trauma Code-3 Box - 14-VL02 @ Twin Creeks Club Dr / Grand Oaks Loop XStreets: On - AT FCOM W Time: 14:36:53 Inc# 13042468 Case Num: For - ENG1402
From - ESD14 - 1 Alarm / EMS Unk Med Cond Code-3 Box - 14-VL02 @ 2507 Terlingua Dr XStreets: No CrossStreet Found/CULVER CLIFF LN On - AT FCOM W Time: 13:45:27 Inc# 13042458 Case Num: For - SQ1408
From - ESD14 - 1 Alarm / EMS Hemorrhage Code-3 Box - 14-VL02 @ 2724 Grand Oaks Loop XStreets: ROLLING PLAINS CT/MILL STREAM DR On - AT FCOM W Time: 19:28:54 Inc# 13042255 Case Num: For - SQ1408
From - ESD14 - 1 Alarm / ELEC - Electrical Fire Box - 14-VL01 @ 14289 Fm 2769 Rd XStreets: MARINA VISTA CIR/GERONIMO ST On - AT FCOM W Time: 14:29:31 Inc# 13041783 Case Num: For - ENG1401
From - ESD14 - 1 Alarm / EMS Sick Code-3 Box - 14-VL01 @ 16605 Jackson St XStreets: LIME CREEK RD/ARREN TER On - AT FCOM W Time: 01:51:57 Inc# 13041293 Case Num: For - SQ1408

Contact: Active911
Agency name: Travis County ESD #12
Location: Manor, TX, United States
Sender: PublicSafety@austintexas.gov

From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN04 @ 7657 Nez Perce Trce XStreets: WELLS TRCE/GILBERT RD On - AT FCOM E Time: 03:55:43 Inc# 13046668 Case Num: For - ENG401
From - ESD12 - 1 Alarm / EMS Allergic Reaction Code-3 Box - 12-MN04 @ 15120 Arizona Oak Ln XStreets: ENGLISH AVE/DELTA POST DR On - AT FCOM E Time: 22:41:03 Inc# 13046616 Case Num: For - ENG401
From - ESD12 - 1 Alarm / EMS Seizure Code-3 Box - 12-MN04 @ 12000 Briarcreek Loop XStreets: GOLDEN VALLEY DR/POWDER CREEK DR On - AT FCOM E Time: 13:31:11 Inc# 13046458 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN09 @ 200 W Carrie Manor St XStreets: S CALDWELL ST/S BASTROP ST On - AT FCOM E Time: 13:35:40 Inc# 13046167 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / RESQV - Vehicle Rescue Box - 12-MN07 @ SCHMIDT LOOP / N FM 973 RD XStreets: On - AT FCOM E Time: 10:10:59 Inc# 13046110 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / EMS TI Rollover Code-3 Box - 12-MN07 @ 15300 - 15650 N Fm 973 Rd XStreets: SCHMIDT LOOP/SCHMIDT LN On - AT FCOM E Time: 10:10:59 Inc# 13046110 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / EMS Obstetrical Code-3 Box - 12-MN08 @ 9808 Crofford Ln XStreets: Dead End/E US HWY 290 On - AT FCOM E Time: 23:03:10 Inc# 13045997 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / EMS Obstetrical Code-3 Box - 12-MN04 @ 10905 E Us 290 Hwy Eb XStreets: E US 290 HWY WB/GREGG MANOR RD On - AT FCOM E Time: 22:10:40 Inc# 13045979 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / PS - Public Service - Other Box - 12-MN04 @ 10905 E Us 290 Hwy Eb XStreets: E US 290 HWY WB/GREGG MANOR RD On - AT FCOM E Time: 21:54:10 Inc# 13045968 Case Num: For - ENG1201
From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN01 @ 19009 Fm 969 Rd XStreets: No CrossStreet Found/WATER ST On - AT FCOM E Time: 21:11:39 Inc# 13045957 Case Num: For - ENG401

*/

public class TXTravisCountyParserTest extends BaseParserTest {
  
  public TXTravisCountyParserTest() {
    setParser(new TXTravisCountyParser(), "TRAVIS COUNTY", "TX");
  }
  
  @Test
  public void testTravisCountyESD4() {

    doTest("T1",
        "From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN04 On -AT FCOM E - AT -7657 Nez Perce Trce - INC# =>13046668 Case Num:ESD04-2013-0000689 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN04",
        "CH:FCOM E",
        "ADDR:7657 Nez Perce Trce",
        "ID:ESD04-2013-0000689/13046668",
        "UNIT:ENG401");

    doTest("T2",
        "From -ESD04 Dispatch -1ALARM -ALARM - Fire Alarm - BOX -04-2602 On -AT FCOM E - AT -3207 Crownover St - INC# =>13046635 Case Num:ESD04-2013-0000688 For -ENG401",
        "SRC:ESD04",
        "CALL:ALARM - Fire Alarm",
        "BOX:04-2602",
        "CH:FCOM E",
        "ADDR:3207 Crownover St",
        "ID:ESD04-2013-0000688/13046635",
        "UNIT:ENG401");

    doTest("T3",
        "From -ESD12 Dispatch -1ALARM -EMS Allergic Reaction Code-3 - BOX -12-MN04 On -AT FCOM E - AT -15120 Arizona Oak Ln - INC# =>13046616 Case Num:ESD04-2013-0000687 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Allergic Reaction Code-3",
        "BOX:12-MN04",
        "CH:FCOM E",
        "ADDR:15120 Arizona Oak Ln",
        "ID:ESD04-2013-0000687/13046616",
        "UNIT:ENG401");

    doTest("T4",
        "From -ESD04 Dispatch -1ALARM -HC - Hazardous Condition - BOX -04-4103 On -AT FCOM E - AT -9207 Wellesley Dr - INC# =>13046577 Case Num:ESD12-2013-0000727 For -ENG1201,SQ404",
        "SRC:ESD04",
        "CALL:HC - Hazardous Condition",
        "BOX:04-4103",
        "CH:FCOM E",
        "ADDR:9207 Wellesley Dr",
        "ID:ESD12-2013-0000727/13046577",
        "UNIT:ENG1201,SQ404");

    doTest("T5",
        "From -ESD04 Dispatch -1ALARM -EMS Fall Code-3 - BOX -04-2605 On -AT FCOM E - AT -10003 Fm 969 Rd - INC# =>13046572 Case Num:ESD04-2013-0000685 For -ENG401",
        "SRC:ESD04",
        "CALL:EMS Fall Code-3",
        "BOX:04-2605",
        "CH:FCOM E",
        "ADDR:10003 Fm 969 Rd",
        "MADDR:10003 FM 969",
        "ID:ESD04-2013-0000685/13046572",
        "UNIT:ENG401");

    doTest("T6",
        "From -ESD04 Dispatch -1ALARM -EMS Fall Code-3 - BOX -04-2602 On -AT FCOM E - AT -14523 Sandifer St - INC# =>13046209 Case Num:ESD04-2013-0000684 For -ENG401",
        "SRC:ESD04",
        "CALL:EMS Fall Code-3",
        "BOX:04-2602",
        "CH:FCOM E",
        "ADDR:14523 Sandifer St",
        "ID:ESD04-2013-0000684/13046209",
        "UNIT:ENG401");

    doTest("T7",
        "From -ESD12 Dispatch -1ALARM -RESQV - Vehicle Rescue - BOX -12-MN07 On -FTAC 201 - AT -SCHMIDT LOOP / N FM 973 RD - INC# =>13046110 Case Num:ESD12-2013-0000723 For -ENG1201,SQ404,ENG401",
        "SRC:ESD12",
        "CALL:RESQV - Vehicle Rescue",
        "BOX:12-MN07",
        "CH:FTAC 201",
        "ADDR:SCHMIDT LOOP & N FM 973 RD",
        "MADDR:SCHMIDT LOOP & N FM 973",
        "ID:ESD12-2013-0000723/13046110",
        "UNIT:ENG1201,SQ404,ENG401");

    doTest("T8",
        "From -ESD04 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -04-2801 On -AT FCOM E - AT -2201 - 2401 W Howard Ln - INC# =>13046021 Case Num:ESD04-2013-0000682 For -SQ404",
        "SRC:ESD04",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:04-2801",
        "CH:FCOM E",
        "ADDR:2201 - 2401 W Howard Ln",
        "MADDR:2201 W Howard Ln",
        "ID:ESD04-2013-0000682/13046021",
        "UNIT:SQ404");

    doTest("T9",
        "From -ESD04 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -04-2602 On -AT FCOM E - AT -Fm 969 Rd / Hunters Bend Rd - INC# =>13046009 Case Num:ESD04-2013-0000681 For -ENG401,SQ404",
        "SRC:ESD04",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:04-2602",
        "CH:FCOM E",
        "ADDR:Fm 969 Rd & Hunters Bend Rd",
        "MADDR:FM 969 & Hunters Bend Rd",
        "ID:ESD04-2013-0000681/13046009",
        "UNIT:ENG401,SQ404");

    doTest("T10",
        "From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN01 On -AT FCOM E - AT -19009 Fm 969 Rd - INC# =>13045957 Case Num:ESD04-2013-0000680 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN01",
        "CH:FCOM E",
        "ADDR:19009 Fm 969 Rd",
        "MADDR:19009 FM 969",
        "ID:ESD04-2013-0000680/13045957",
        "UNIT:ENG401");

    doTest("T11",
        "From -ESD12 Dispatch -1ALARM -EMS Sick Code-3 - BOX -12-MN01 On -AT FCOM E - AT -21118 Blake Manor Rd - INC# =>13045865 Case Num:ESD04-2013-0000679 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN01",
        "CH:FCOM E",
        "ADDR:21118 Blake Manor Rd",
        "ID:ESD04-2013-0000679/13045865",
        "UNIT:ENG401");

    doTest("T12",
        "From -ESD12 Dispatch -1ALARM -EMS Traffic Injury Code-3 - BOX -12-MN04 On -AT FCOM E - AT -N Sh 130 Sb / Fm 973 Rd To N Sh 130 Sb Ramp - INC# =>13045823 Case Num:ESD04-2013-0000678 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:12-MN04",
        "CH:FCOM E",
        "ADDR:N Sh 130 Sb & Fm 973 Rd To N Sh 130 Sb Ramp",
        "MADDR:N St 130 & FM 973 To N St 130 Ramp",
        "ID:ESD04-2013-0000678/13045823",
        "UNIT:ENG401");

    doTest("T13",
        "From -ESD04 Dispatch -1ALARM -EMS Choking Code-3 - BOX -04-2602 On -AT FCOM E - AT -2901 Caleb Dr - INC# =>13045573 Case Num:ESD04-2013-0000676 For -ENG401",
        "SRC:ESD04",
        "CALL:EMS Choking Code-3",
        "BOX:04-2602",
        "CH:FCOM E",
        "ADDR:2901 Caleb Dr",
        "ID:ESD04-2013-0000676/13045573",
        "UNIT:ENG401");

    doTest("T14",
        "From -ESD04 Dispatch -1ALARM -EMS Chest Pain Code-3 - BOX -04-2602 On -AT FCOM E - AT -Austins Colony Blvd / Westall St - INC# =>13045522 Case Num:ESD04-2013-0000675 For -ENG401",
        "SRC:ESD04",
        "CALL:EMS Chest Pain Code-3",
        "BOX:04-2602",
        "CH:FCOM E",
        "ADDR:Austins Colony Blvd & Westall St",
        "ID:ESD04-2013-0000675/13045522",
        "UNIT:ENG401");

    doTest("T15",
        "From -ESD12 Dispatch -1ALARM -EMS Assault Code-3 - BOX -12-MN04 On -AT FCOM E - AT -20812 Verna St - INC# =>13045513 Case Num:ESD04-2013-0000674 For -ENG401",
        "SRC:ESD12",
        "CALL:EMS Assault Code-3",
        "BOX:12-MN04",
        "CH:FCOM E",
        "ADDR:20812 Verna St",
        "ID:ESD04-2013-0000674/13045513",
        "UNIT:ENG401");

  }
  
  @Test
  public void testWestlakeFD() {

    doTest("T1",
        "From - ESD09 - 1 Alarm / EMS Sick Code-3 Box - 09-3209 @ 906 N Weston Ln XStreets: BRIGHTMAN LN/No CrossStreet Found On - AT FCOM W Time: 16:18:30 Inc# 13046505 Case Num: For - ENG1001",
        "SRC:ESD09",
        "CALL:EMS Sick Code-3",
        "BOX:09-3209",
        "ADDR:906 N Weston Ln",
        "X:BRIGHTMAN LN",
        "CH:FCOM W",
        "TIME:16:18:30",
        "ID:13046505",
        "UNIT:ENG1001");

    doTest("T2",
        "From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3702 @ Barton Creek Blvd / Fm 2244 Rd XStreets: On - AT FCOM W Time: 15:45:09 Inc# 13046497 Case Num: For - ENG902,ENG1001",
        "SRC:ESD09",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:09-3702",
        "ADDR:Barton Creek Blvd & Fm 2244 Rd",
        "MADDR:Barton Creek Blvd & FM 2244",
        "CH:FCOM W",
        "TIME:15:45:09",
        "ID:13046497",
        "UNIT:ENG902,ENG1001");

    doTest("T3",
        "From - ESD09 - 1 Alarm / EMS Seizure Code-3 Box - 09-3206 @ 1801 Georgia Landing Cv XStreets: CAPE CORAL DR/No CrossStreet Found On - AT FCOM W Time: 10:12:25 Inc# 13046402 Case Num: For - ENG902",
        "SRC:ESD09",
        "CALL:EMS Seizure Code-3",
        "BOX:09-3206",
        "ADDR:1801 Georgia Landing Cv",
        "X:CAPE CORAL DR",
        "CH:FCOM W",
        "TIME:10:12:25",
        "ID:13046402",
        "UNIT:ENG902");

    doTest("T4",
        "From - ESD09 - 1 Alarm / EMS Respiratory Code-3 Box - 09-1004 @ 3403 Toro Canyon Rd XStreets: MANTLE DR/WHITETHORN CT On - AT FCOM W Time: 01:48:08 Inc# 13046323 Case Num: For - ENG901",
        "SRC:ESD09",
        "CALL:EMS Respiratory Code-3",
        "BOX:09-1004",
        "ADDR:3403 Toro Canyon Rd",
        "X:MANTLE DR/WHITETHORN CT",
        "CH:FCOM W",
        "TIME:01:48:08",
        "ID:13046323",
        "UNIT:ENG901");

    doTest("T5",
        "From - ESD09 - 1 Alarm / EMS Sick Code-3 Box - 09-3106 @ 2407 Deer Pass XStreets: RIDGECREST DR/QUAIL RUN On - AT FCOM W Time: 00:59:42 Inc# 13046318 Case Num: For - ENG901",
        "SRC:ESD09",
        "CALL:EMS Sick Code-3",
        "BOX:09-3106",
        "ADDR:2407 Deer Pass",
        "X:RIDGECREST DR/QUAIL RUN",
        "CH:FCOM W",
        "TIME:00:59:42",
        "ID:13046318",
        "UNIT:ENG901");

    doTest("T6",
        "From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3207 @ 1309 Westbank Dr XStreets: MOON RIVER RD/ALLEN RD On - AT FCOM W Time: 14:41:20 Inc# 13046185 Case Num: For - ENG902,ENG901",
        "SRC:ESD09",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:09-3207",
        "ADDR:1309 Westbank Dr",
        "X:MOON RIVER RD/ALLEN RD",
        "CH:FCOM W",
        "TIME:14:41:20",
        "ID:13046185",
        "UNIT:ENG902,ENG901");

    doTest("T7",
        "From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3206 @ Bay Hill Dr / Quaker Ridge Dr XStreets: On - AT FCOM W Time: 42:27 PM Inc# 13045992 Case Num: For - ENG902,ENG901",
        "SRC:ESD09",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:09-3206",
        "ADDR:Bay Hill Dr & Quaker Ridge Dr",
        "CH:FCOM W",
        "ID:13045992",
        "UNIT:ENG902,ENG901");

    doTest("T8",
        "From - ESD09 - 1 Alarm / EMS Traffic Injury Code-3 Box - 09-3702 @ Fm 2244 Rd / Newhall Ln XStreets: On - AT FCOM W Time: 19:47:34 Inc# 13045925 Case Num: For - ENG902,ENG1001",
        "SRC:ESD09",
        "CALL:EMS Traffic Injury Code-3",
        "BOX:09-3702",
        "ADDR:Fm 2244 Rd & Newhall Ln",  // Not mapping
        "MADDR:FM 2244 & Newhall Ln",
        "CH:FCOM W",
        "TIME:19:47:34",
        "ID:13045925",
        "UNIT:ENG902,ENG1001");

    doTest("T9",
        "From - ESD09 - 1 Alarm / EMS Unconscious Person Code-3 Box - 09-1004 @ 98 Redbud Trl XStreets: FOREST VIEW DR/WESTLAKE DR On - AT FCOM W Time: 18:17:39 Inc# 13045903 Case Num: For - ENG901",
        "SRC:ESD09",
        "CALL:EMS Unconscious Person Code-3",
        "BOX:09-1004",
        "ADDR:98 Redbud Trl",
        "X:FOREST VIEW DR/WESTLAKE DR",
        "CH:FCOM W",
        "TIME:18:17:39",
        "ID:13045903",
        "UNIT:ENG901");

  }
  
  @Test
  public void testVolenteFD() {

    doTest("T1",
        "From - ESD14 - 1 Alarm / EMS Fall Code-3 Box - 14-VL01 @ 16107 Wharf Cv XStreets: FM 2769 RD/No CrossStreet Found On - AT FCOM W Time: 19:57:17 Inc# 13046267 Case Num: For - ENG1401",
        "SRC:ESD14",
        "CALL:EMS Fall Code-3",
        "BOX:14-VL01",
        "ADDR:16107 Wharf Cv",
        "X:FM 2769 RD",
        "CH:FCOM W",
        "TIME:19:57:17",
        "ID:13046267",
        "UNIT:ENG1401");

    doTest("T2",
        "From - ESD14 - 1 Alarm / EMS Sick Code-3 Box - 14-VL01 @ 7621 Debbie Dr XStreets: DAVY DR/DAVY DR On - AT FCOM W Time: 02:27:11 Inc# 13046042 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Sick Code-3",
        "BOX:14-VL01",
        "ADDR:7621 Debbie Dr",
        "X:DAVY DR/DAVY DR",
        "CH:FCOM W",
        "TIME:02:27:11",
        "ID:13046042",
        "UNIT:SQ1408");

    doTest("T3",
        "From - ESD14 - 1 Alarm / EMS Medical Alarm Code-3 Box - 14-VL01 @ 16609 Jackson St XStreets: ARREN TER/No CrossStreet Found On - AT FCOM W Time: 20:47:02 Inc# 13043589 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Medical Alarm Code-3",
        "BOX:14-VL01",
        "ADDR:16609 Jackson St",
        "X:ARREN TER",
        "CH:FCOM W",
        "TIME:20:47:02",
        "ID:13043589",
        "UNIT:SQ1408");

    doTest("T4",
        "From - ESD14 - 1 Alarm / EMS Hemorrhage Code-3 Box - 14-VL02 @ 3018 Heathmount Dr XStreets: BEN DORAN CT/MORAY LN On - AT FCOM W Time: 07:28:44 Inc# 13043025 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Hemorrhage Code-3",
        "BOX:14-VL02",
        "ADDR:3018 Heathmount Dr",
        "X:BEN DORAN CT/MORAY LN",
        "CH:FCOM W",
        "TIME:07:28:44",
        "ID:13043025",
        "UNIT:SQ1408");

    doTest("T5",
        "From - ESD14 - 1 Alarm / SPILL - Liquid < 5 Gallons Box - 14-VL02 @ 2900 GRAND OAKS LOOP XStreets: GRANITE BASIN CT/MOSSY GROVE CT On - AT FCOM W Time: 16:53:49 Inc# 13042511 Case Num: For - QNT38",
        "SRC:ESD14",
        "CALL:SPILL - Liquid < 5 Gallons",
        "BOX:14-VL02",
        "ADDR:2900 GRAND OAKS LOOP",
        "X:GRANITE BASIN CT/MOSSY GROVE CT",
        "CH:FCOM W",
        "TIME:16:53:49",
        "ID:13042511",
        "UNIT:QNT38");

    doTest("T6",
        "From - ESD14 - 1 Alarm / EMS Penetrating Trauma Code-3 Box - 14-VL02 @ Twin Creeks Club Dr / Grand Oaks Loop XStreets: On - AT FCOM W Time: 14:36:53 Inc# 13042468 Case Num: For - ENG1402",
        "SRC:ESD14",
        "CALL:EMS Penetrating Trauma Code-3",
        "BOX:14-VL02",
        "ADDR:Twin Creeks Club Dr & Grand Oaks Loop",
        "CH:FCOM W",
        "TIME:14:36:53",
        "ID:13042468",
        "UNIT:ENG1402");

    doTest("T7",
        "From - ESD14 - 1 Alarm / EMS Unk Med Cond Code-3 Box - 14-VL02 @ 2507 Terlingua Dr XStreets: No CrossStreet Found/CULVER CLIFF LN On - AT FCOM W Time: 13:45:27 Inc# 13042458 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Unk Med Cond Code-3",
        "BOX:14-VL02",
        "ADDR:2507 Terlingua Dr",
        "X:No CrossStreet Found/CULVER CLIFF LN",
        "CH:FCOM W",
        "TIME:13:45:27",
        "ID:13042458",
        "UNIT:SQ1408");

    doTest("T8",
        "From - ESD14 - 1 Alarm / EMS Hemorrhage Code-3 Box - 14-VL02 @ 2724 Grand Oaks Loop XStreets: ROLLING PLAINS CT/MILL STREAM DR On - AT FCOM W Time: 19:28:54 Inc# 13042255 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Hemorrhage Code-3",
        "BOX:14-VL02",
        "ADDR:2724 Grand Oaks Loop",
        "X:ROLLING PLAINS CT/MILL STREAM DR",
        "CH:FCOM W",
        "TIME:19:28:54",
        "ID:13042255",
        "UNIT:SQ1408");

    doTest("T9",
        "From - ESD14 - 1 Alarm / ELEC - Electrical Fire Box - 14-VL01 @ 14289 Fm 2769 Rd XStreets: MARINA VISTA CIR/GERONIMO ST On - AT FCOM W Time: 14:29:31 Inc# 13041783 Case Num: For - ENG1401",
        "SRC:ESD14",
        "CALL:ELEC - Electrical Fire",
        "BOX:14-VL01",
        "ADDR:14289 Fm 2769 Rd",
        "MADDR:14289 FM 2769",
        "X:MARINA VISTA CIR/GERONIMO ST",
        "CH:FCOM W",
        "TIME:14:29:31",
        "ID:13041783",
        "UNIT:ENG1401");

    doTest("T10",
        "From - ESD14 - 1 Alarm / EMS Sick Code-3 Box - 14-VL01 @ 16605 Jackson St XStreets: LIME CREEK RD/ARREN TER On - AT FCOM W Time: 01:51:57 Inc# 13041293 Case Num: For - SQ1408",
        "SRC:ESD14",
        "CALL:EMS Sick Code-3",
        "BOX:14-VL01",
        "ADDR:16605 Jackson St",
        "X:LIME CREEK RD/ARREN TER",
        "CH:FCOM W",
        "TIME:01:51:57",
        "ID:13041293",
        "UNIT:SQ1408");
 
  }
  
  @Test
  public void testTravisCountyESD12() {

    doTest("T1",
        "From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN04 @ 7657 Nez Perce Trce XStreets: WELLS TRCE/GILBERT RD On - AT FCOM E Time: 03:55:43 Inc# 13046668 Case Num: For - ENG401",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN04",
        "ADDR:7657 Nez Perce Trce",
        "X:WELLS TRCE/GILBERT RD",
        "CH:FCOM E",
        "TIME:03:55:43",
        "ID:13046668",
        "UNIT:ENG401");

    doTest("T2",
        "From - ESD12 - 1 Alarm / EMS Allergic Reaction Code-3 Box - 12-MN04 @ 15120 Arizona Oak Ln XStreets: ENGLISH AVE/DELTA POST DR On - AT FCOM E Time: 22:41:03 Inc# 13046616 Case Num: For - ENG401",
        "SRC:ESD12",
        "CALL:EMS Allergic Reaction Code-3",
        "BOX:12-MN04",
        "ADDR:15120 Arizona Oak Ln",
        "X:ENGLISH AVE/DELTA POST DR",
        "CH:FCOM E",
        "TIME:22:41:03",
        "ID:13046616",
        "UNIT:ENG401");

    doTest("T3",
        "From - ESD12 - 1 Alarm / EMS Seizure Code-3 Box - 12-MN04 @ 12000 Briarcreek Loop XStreets: GOLDEN VALLEY DR/POWDER CREEK DR On - AT FCOM E Time: 13:31:11 Inc# 13046458 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:EMS Seizure Code-3",
        "BOX:12-MN04",
        "ADDR:12000 Briarcreek Loop",
        "X:GOLDEN VALLEY DR/POWDER CREEK DR",
        "CH:FCOM E",
        "TIME:13:31:11",
        "ID:13046458",
        "UNIT:ENG1201");

    doTest("T4",
        "From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN09 @ 200 W Carrie Manor St XStreets: S CALDWELL ST/S BASTROP ST On - AT FCOM E Time: 13:35:40 Inc# 13046167 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN09",
        "ADDR:200 W Carrie Manor St",
        "X:S CALDWELL ST/S BASTROP ST",
        "CH:FCOM E",
        "TIME:13:35:40",
        "ID:13046167",
        "UNIT:ENG1201");

    doTest("T5",
        "From - ESD12 - 1 Alarm / RESQV - Vehicle Rescue Box - 12-MN07 @ SCHMIDT LOOP / N FM 973 RD XStreets: On - AT FCOM E Time: 10:10:59 Inc# 13046110 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:RESQV - Vehicle Rescue",
        "BOX:12-MN07",
        "ADDR:SCHMIDT LOOP & N FM 973 RD",
        "MADDR:SCHMIDT LOOP & N FM 973",
        "CH:FCOM E",
        "TIME:10:10:59",
        "ID:13046110",
        "UNIT:ENG1201");

    doTest("T6",
        "From - ESD12 - 1 Alarm / EMS TI Rollover Code-3 Box - 12-MN07 @ 15300 - 15650 N Fm 973 Rd XStreets: SCHMIDT LOOP/SCHMIDT LN On - AT FCOM E Time: 10:10:59 Inc# 13046110 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:EMS TI Rollover Code-3",
        "BOX:12-MN07",
        "ADDR:15300 - 15650 N Fm 973 Rd",
        "MADDR:15300 N FM 973",
        "X:SCHMIDT LOOP/SCHMIDT LN",
        "CH:FCOM E",
        "TIME:10:10:59",
        "ID:13046110",
        "UNIT:ENG1201");

    doTest("T7",
        "From - ESD12 - 1 Alarm / EMS Obstetrical Code-3 Box - 12-MN08 @ 9808 Crofford Ln XStreets: Dead End/E US HWY 290 On - AT FCOM E Time: 23:03:10 Inc# 13045997 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:EMS Obstetrical Code-3",
        "BOX:12-MN08",
        "ADDR:9808 Crofford Ln",
        "X:Dead End/E US HWY 290",
        "CH:FCOM E",
        "TIME:23:03:10",
        "ID:13045997",
        "UNIT:ENG1201");

    doTest("T8",
        "From - ESD12 - 1 Alarm / EMS Obstetrical Code-3 Box - 12-MN04 @ 10905 E Us 290 Hwy Eb XStreets: E US 290 HWY WB/GREGG MANOR RD On - AT FCOM E Time: 22:10:40 Inc# 13045979 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:EMS Obstetrical Code-3",
        "BOX:12-MN04",
        "ADDR:10905 E Us 290 Hwy Eb",
        "MADDR:10905 E US 290",
        "X:E US 290 HWY WB/GREGG MANOR RD",
        "CH:FCOM E",
        "TIME:22:10:40",
        "ID:13045979",
        "UNIT:ENG1201");

    doTest("T9",
        "From - ESD12 - 1 Alarm / PS - Public Service - Other Box - 12-MN04 @ 10905 E Us 290 Hwy Eb XStreets: E US 290 HWY WB/GREGG MANOR RD On - AT FCOM E Time: 21:54:10 Inc# 13045968 Case Num: For - ENG1201",
        "SRC:ESD12",
        "CALL:PS - Public Service - Other",
        "BOX:12-MN04",
        "ADDR:10905 E Us 290 Hwy Eb",
        "MADDR:10905 E US 290",
        "X:E US 290 HWY WB/GREGG MANOR RD",
        "CH:FCOM E",
        "TIME:21:54:10",
        "ID:13045968",
        "UNIT:ENG1201");

    doTest("T10",
        "From - ESD12 - 1 Alarm / EMS Sick Code-3 Box - 12-MN01 @ 19009 Fm 969 Rd XStreets: No CrossStreet Found/WATER ST On - AT FCOM E Time: 21:11:39 Inc# 13045957 Case Num: For - ENG401",
        "SRC:ESD12",
        "CALL:EMS Sick Code-3",
        "BOX:12-MN01",
        "ADDR:19009 Fm 969 Rd",
        "MADDR:19009 FM 969",
        "X:No CrossStreet Found/WATER ST",
        "CH:FCOM E",
        "TIME:21:11:39",
        "ID:13045957",
        "UNIT:ENG401");

  }
  
  public static void main(String[] args) {
    new TXTravisCountyParserTest().generateTests("T1");
  }
}