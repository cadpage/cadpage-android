package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDHowardCountyParserTest extends BaseParserTest {
  
  public MDHowardCountyParserTest() {
    setParser(new MDHowardCountyParser(), "HOWARD COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[CAD] RT 32/LINDEN CHURCH RD WS CLK TYPE: RESCUE--UNKNOW @ 23:29:39 BEAT/BOX: 032119",
        "ADDR:RT 32 & LINDEN CHURCH RD WS",
        "CITY:CLARKSVILLE",
        "CALL:RESCUE--UNKNOW",
        "TIME:23:29:39",
        "BOX:032119");

    doTest("T2",
        "[CAD] 14470 TRIADELPHIA MILL RD DYTN TYPE: WIRES-WIRES @ 13:52:21 BEAT/BOX: 0540",
        "ADDR:14470 TRIADELPHIA MILL RD",
        "CITY:DAYTON",
        "CALL:WIRES-WIRES",
        "TIME:13:52:21",
        "BOX:0540");

    doTest("T3",
        "[CAD] 6005 DAYBREAK CIR CLK: @RIVER HILL VC TYPE: LOCKV-ANIMAL @ 12:13:57 BEAT/BOX: 0501",
        "ADDR:6005 DAYBREAK CIR",
        "CITY:CLARKSVILLE",
        "PLACE:RIVER HILL VC",
        "CALL:LOCKV-ANIMAL",
        "TIME:12:13:57",
        "BOX:0501");

    doTest("T4",
        "[CAD] 6348 MORNING TIME LN WCOL TYPE: MEDICAL-BLS-COLD @ 13:59:49 BEAT/BOX: 0561",
        "ADDR:6348 MORNING TIME LN",
        "CITY:COLUMBIA",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:13:59:49",
        "BOX:0561");

    doTest("T5",
        "[CAD] RT 32/ROSEMARY LN ECW TYPE: RESCUE--UNKNOW @ 06:03:24 BEAT/BOX: 032145",
        "ADDR:RT 32 & ROSEMARY LN",
        "CITY:ELLICOTT CITY",
        "CALL:RESCUE--UNKNOW",
        "TIME:06:03:24",
        "BOX:032145");

    doTest("T6",
        "[CAD] 12700 HALL SHOP RD HIGH: @SAINT MARKS EPISCOPAL CHURCH TYPE: GASLEAK-OUTSIDE/FIRE @ 01:28:32 BEAT/BOX: 0564",
        "ADDR:12700 HALL SHOP RD",
        "CITY:HIGHLAND",
        "PLACE:SAINT MARKS EPISCOPAL CHURCH",
        "CALL:GASLEAK-OUTSIDE/FIRE",
        "TIME:01:28:32",
        "BOX:0564");

    doTest("T7",
        "[CAD] 5764 STEVENS FOREST RD ECOL,111: @GRANDE POINT APARTMENTS TYPE: SMOKE-INSIDE/HIGHOCC @ 23:28:39 BEAT/BOX: 0908",
        "ADDR:5764 STEVENS FOREST RD",
        "APT:111",
        "CITY:COLUMBIA",
        "PLACE:GRANDE POINT APARTMENTS",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "TIME:23:28:39",
        "BOX:0908");

    doTest("T8",
        "[CAD] 14101 HOWARD RD DYTN: @SMITH RESIDENCE TYPE: MEDICAL-*********** @ 08:30:53 BEAT/BOX: 0545",
        "ADDR:14101 HOWARD RD",
        "CITY:DAYTON",
        "PLACE:SMITH RESIDENCE",
        "CALL:MEDICAL",
        "TIME:08:30:53",
        "BOX:0545");

    doTest("T9",
        "(CAD) [CAD] EVENT: F11023456 7110 MINSTREL WAY ECOL: @BRIGHTON GARDENS TYPE: SMOKE-INSIDE/HIGHOCC @ 10:38:22 BEAT/BOX: 1034",
        "ID:F11023456",
        "ADDR:7110 MINSTREL WAY",
        "CITY:COLUMBIA",
        "PLACE:BRIGHTON GARDENS",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "TIME:10:38:22",
        "BOX:1034");

    doTest("T10",
        "(CAD) [CAD] EVENT: F11023457 RT 29 SB/RIVERS EDGE RD SCOL TYPE: RESCUE--UNKNOW @ 10:56:54 BEAT/BOX: 029086",
        "ID:F11023457",
        "ADDR:RT 29 SB & RIVERS EDGE RD",
        "MADDR:RT 29 & RIVERS EDGE RD",
        "CITY:COLUMBIA",
        "CALL:RESCUE--UNKNOW",
        "TIME:10:56:54",
        "BOX:029086");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(hCAD) [!] EVENT: F12009425 10162 BRACKEN DR ECW: @LEE RESIDENCE: @GLANCEY RESIDENCE TYPE: MEDICAL-ALSA/PD-HOT @ 01:16:08 BEAT/BOX: 0810",
        "ID:F12009425",
        "ADDR:10162 BRACKEN DR",
        "CITY:ELLICOTT CITY",
        "PLACE:LEE RESIDENCE - GLANCEY RESIDENCE",
        "CALL:MEDICAL-ALSA/PD-HOT",
        "TIME:01:16:08",
        "BOX:0810");

    doTest("T2",
        "(hCAD) [!] EVENT: F12009429 8789 FREDERICK RD EC TYPE: MEDICAL-ALSA-HOT @ 03:26:18 BEAT/BOX: 0212",
        "ID:F12009429",
        "ADDR:8789 FREDERICK RD",
        "CITY:ELLICOTT CITY",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:03:26:18",
        "BOX:0212");

    doTest("T3",
        "(hCAD) [!] EVENT: F12009429 8789 FREDERICK RD EC TYPE: MEDICAL-*********** @ 03:26:18 BEAT/BOX: 0212",
        "ID:F12009429",
        "ADDR:8789 FREDERICK RD",
        "CITY:ELLICOTT CITY",
        "CALL:MEDICAL",
        "TIME:03:26:18",
        "BOX:0212");

    doTest("T4",
        "(hCAD) [!] EVENT: F12009443 3004 NORTH RIDGE RD EC,H217: @HEARTLANDS COMM CTR & ASST LVG TYPE: MEDICAL-*********** @ 09:36:10 BEAT/BOX: 0241",
        "ID:F12009443",
        "ADDR:3004 NORTH RIDGE RD",
        "APT:H217",
        "CITY:ELLICOTT CITY",
        "PLACE:HEARTLANDS COMM CTR & ASST LVG",
        "CALL:MEDICAL",
        "TIME:09:36:10",
        "BOX:0241");

    doTest("T5",
        "(hCAD) [!] EVENT: F12009444 8450 BALTIMORE NATIONAL PK WB EC: @NORMANDY SHOPPING CENTER TYPE: CHECK-ALS/PD-COLD @ 09:38:57 BEAT/BOX: 0243",
        "ID:F12009444",
        "ADDR:8450 BALTIMORE NATIONAL PK WB",
        "MADDR:8450 BALTIMORE NATIONAL PIKE",
        "CITY:ELLICOTT CITY",
        "PLACE:NORMANDY SHOPPING CENTER",
        "CALL:CHECK-ALS/PD-COLD",
        "TIME:09:38:57",
        "BOX:0243");

    doTest("T6",
        "(hCAD) [!] EVENT: F12009444 8450 BALTIMORE NATIONAL PK WB EC: @NORMANDY SHOPPING CENTER TYPE: CHECK-ALS/PD-COLD @ 09:38:57 BEAT/BOX: 0243",
        "ID:F12009444",
        "ADDR:8450 BALTIMORE NATIONAL PK WB",
        "MADDR:8450 BALTIMORE NATIONAL PIKE",
        "CITY:ELLICOTT CITY",
        "PLACE:NORMANDY SHOPPING CENTER",
        "CALL:CHECK-ALS/PD-COLD",
        "TIME:09:38:57",
        "BOX:0243");

    doTest("T7",
        "(hCAD) [!] EVENT: F12009454 MARYLAND AVE/SAINT PAUL ST EC TYPE: LOCKV-ANIMAL @ 11:19:38 BEAT/BOX: 0214",
        "ID:F12009454",
        "ADDR:MARYLAND AVE & SAINT PAUL ST",
        "CITY:ELLICOTT CITY",
        "CALL:LOCKV-ANIMAL",
        "TIME:11:19:38",
        "BOX:0214");

    doTest("T8",
        "(hCAD) [!] EVENT: F12009456 8766 CLOUDLEAP CT ECOL,T3 TYPE: MEDICAL-*********** @ 11:42:28 BEAT/BOX: 0919",
        "ID:F12009456",
        "ADDR:8766 CLOUDLEAP CT",
        "APT:T3",
        "CITY:COLUMBIA",
        "CALL:MEDICAL",
        "TIME:11:42:28",
        "BOX:0919");

    doTest("T9",
        "(hCAD) [!] EVENT: F12009456 8766 CLOUDLEAP CT ECOL,T3 TYPE: MEDICAL-BARIATRIC @ 11:42:28 BEAT/BOX: 0919",
        "ID:F12009456",
        "ADDR:8766 CLOUDLEAP CT",
        "APT:T3",
        "CITY:COLUMBIA",
        "CALL:MEDICAL-BARIATRIC",
        "TIME:11:42:28",
        "BOX:0919");

    doTest("T10",
        "(hCAD) [!] EVENT: F12009458 10300 LITTLE PATUXENT PKWY WB WCOL,D300: @SEARS TYPE: BRUSH-BRUSH @ 11:59:01 BEAT/BOX: 0701",
        "ID:F12009458",
        "ADDR:10300 LITTLE PATUXENT PKWY WB",
        "MADDR:10300 LITTLE PATUXENT PKWY",
        "APT:D300",
        "CITY:COLUMBIA",
        "PLACE:SEARS",
        "CALL:BRUSH-BRUSH",
        "TIME:11:59:01",
        "BOX:0701");

    doTest("T11",
        "(hCAD) [!] EVENT: F12009459 4150 MONTGOMERY RD EC: @STATION 2 TYPE: VEHICLE-AUTO @ 12:04:50 BEAT/BOX: 0201",
        "ID:F12009459",
        "ADDR:4150 MONTGOMERY RD",
        "CITY:ELLICOTT CITY",
        "PLACE:STATION 2",
        "CALL:VEHICLE-AUTO",
        "TIME:12:04:50",
        "BOX:0201");

    doTest("T12",
        "(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC: @TIBER HUDSON SENIOR HOUSING TYPE: ALFIRE-BUSC @ 12:09:06 BEAT/BOX: 0213",
        "ID:F12009460",
        "ADDR:3675 MOUNT IDA DR",
        "CITY:ELLICOTT CITY",
        "PLACE:TIBER HUDSON SENIOR HOUSING",
        "CALL:ALFIRE-BUSC",
        "TIME:12:09:06",
        "BOX:0213");

    doTest("T13",
        "(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC: @TIBER HUDSON SENIOR HOUSING TYPE: ALFIRE-BUSC @ 12:09:06 BEAT/BOX: 0213",
        "ID:F12009460",
        "ADDR:3675 MOUNT IDA DR",
        "CITY:ELLICOTT CITY",
        "PLACE:TIBER HUDSON SENIOR HOUSING",
        "CALL:ALFIRE-BUSC",
        "TIME:12:09:06",
        "BOX:0213");

    doTest("T14",
        "(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213",
        "ID:F12009460",
        "ADDR:3675 MOUNT IDA DR",
        "APT:100",
        "CITY:ELLICOTT CITY",
        "PLACE:TIBER HUDSON SENIOR HOUSING",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "TIME:12:09:06",
        "BOX:0213");

    doTest("T15",
        "(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213",
        "ID:F12009460",
        "ADDR:3675 MOUNT IDA DR",
        "APT:100",
        "CITY:ELLICOTT CITY",
        "PLACE:TIBER HUDSON SENIOR HOUSING",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "TIME:12:09:06",
        "BOX:0213");

    doTest("T16",
        "(hCAD) [!] EVENT: F12009460 3675 MOUNT IDA DR EC,100: @TIBER HUDSON SENIOR HOUSING TYPE: SMOKE-INSIDE/HIGHOCC @ 12:09:06 BEAT/BOX: 0213",
        "ID:F12009460",
        "ADDR:3675 MOUNT IDA DR",
        "APT:100",
        "CITY:ELLICOTT CITY",
        "PLACE:TIBER HUDSON SENIOR HOUSING",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "TIME:12:09:06",
        "BOX:0213");

    doTest("T17",
        "(hCAD) [!] EVENT: F12009464 3290 CENTENNIAL LN ECW: @ARBYS TYPE: MISC-noPD @ 12:48:31 BEAT/BOX: 0804",
        "ID:F12009464",
        "ADDR:3290 CENTENNIAL LN",
        "CITY:ELLICOTT CITY",
        "PLACE:ARBYS",
        "CALL:MISC-noPD",
        "TIME:12:48:31",
        "BOX:0804");

    doTest("T18",
        "(hCAD) [!] EVENT: F12009466 BALTIMORE COUNTY CTNV: @BC4 TYPE: MUTAID-MAALS @ 13:17:25 BEAT/BOX: BC04",
        "ID:F12009466",
        "ADDR:BALTIMORE COUNTY CTNV",
        "MADDR:BC4,BALTIMORE COUNTY CTNV",
        "PLACE:BC4",
        "CALL:MUTAID-MAALS",
        "TIME:13:17:25",
        "BOX:BC04");

    doTest("T19",
        "(hCAD) [!] EVENT: F12009470 11185 CHAMBERS CT WDSK,A TYPE: FIRE-APPLIANCE @ 13:24:48 BEAT/BOX: 0815",
        "ID:F12009470",
        "ADDR:11185 CHAMBERS CT",
        "APT:A",
        "CITY:WOODSTOCK",
        "CALL:FIRE-APPLIANCE",
        "TIME:13:24:48",
        "BOX:0815");

    doTest("T20",
        "(hCAD) [!] EVENT: F12009470 11185 CHAMBERS CT WDSK,A TYPE: FIRE-APPLIANCE @ 13:24:48 BEAT/BOX: 0815",
        "ID:F12009470",
        "ADDR:11185 CHAMBERS CT",
        "APT:A",
        "CITY:WOODSTOCK",
        "CALL:FIRE-APPLIANCE",
        "TIME:13:24:48",
        "BOX:0815");

    doTest("T21",
        "(hCAD) [!] EVENT: F12009479 3120 WHEATON WAY EC,J TYPE: MEDICAL-*********** @ 15:16:49 BEAT/BOX: 0243",
        "ID:F12009479",
        "ADDR:3120 WHEATON WAY",
        "APT:J",
        "CITY:ELLICOTT CITY",
        "CALL:MEDICAL",
        "TIME:15:16:49",
        "BOX:0243");

    doTest("T22",
        "(hCAD) [!] EVENT: F12009479 3120 WHEATON WAY EC,J TYPE: MEDICAL-ALSA-HOT @ 15:16:49 BEAT/BOX: 0243",
        "ID:F12009479",
        "ADDR:3120 WHEATON WAY",
        "APT:J",
        "CITY:ELLICOTT CITY",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:15:16:49",
        "BOX:0243");

    doTest("T23",
        "(hCAD) [!] EVENT: F12009491 3410 PLUMTREE DR ECW: @SHANTY GRILL TYPE: MEDICAL-*********** @ 18:10:56 BEAT/BOX: 0208",
        "ID:F12009491",
        "ADDR:3410 PLUMTREE DR",
        "CITY:ELLICOTT CITY",
        "PLACE:SHANTY GRILL",
        "CALL:MEDICAL",
        "TIME:18:10:56",
        "BOX:0208");
    
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "(Station 1) EVENT: F12015237 5952 MONTGOMERY RD ELK TYPE: MEDICAL-ALS-HOT @ 09:55:03 BEAT/BOX: 0124 ",
        "SRC:Station 1",
        "ID:F12015237",
        "ADDR:5952 MONTGOMERY RD",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-ALS-HOT",
        "TIME:09:55:03",
        "BOX:0124");

    doTest("T2",
        "(Station 1) EVENT: F12015242 5895 BONNIE VIEW LN ELK,114: @ECONO LODGE MOTEL ELKRIDGE TYPE: MEDICAL-ALSA-HOT @ 10:51:33 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015242",
        "ADDR:5895 BONNIE VIEW LN",
        "APT:114",
        "CITY:ELKRIDGE",
        "PLACE:ECONO LODGE MOTEL ELKRIDGE",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:10:51:33",
        "BOX:0101");

    doTest("T4",
        "(Station 1) EVENT: F12015255 7064 DUCKETTS LN ELK,204 TYPE: MEDICAL-*********** @ 13:34:29 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015255",
        "ADDR:7064 DUCKETTS LN",
        "APT:204",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:13:34:29",
        "BOX:0104");

    doTest("T5",
        "(Station 1) EVENT: F12015266 ELK: @PATAPSCO STATE PARK TYPE: MEDICAL-*********** @ 14:31:58 BEAT/BOX: 0130 ",
        "SRC:Station 1",
        "ID:F12015266",
        "ADDR:ELK",  // ELK: @PATAPSCO STATE PARK ???
        "MADDR:PATAPSCO STATE PARK,ELK",  
        "PLACE:PATAPSCO STATE PARK",
        "CALL:MEDICAL",
        "TIME:14:31:58",
        "BOX:0130");

    doTest("T6",
        "(Station 1) EVENT: F12015266 ELK: @PATAPSCO STATE PARK TYPE: MEDICAL-BLS-COLD @ 14:31:58 BEAT/BOX: 0130 ",
        "SRC:Station 1",
        "ID:F12015266",
        "ADDR:ELK",
        "MADDR:PATAPSCO STATE PARK,ELK",
        "PLACE:PATAPSCO STATE PARK",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:14:31:58",
        "BOX:0130");

    doTest("T7",
        "(Station 1) EVENT: F12015291 7777 WASHINGTON BLVD JSSP: @MSP WATERLOO TYPE: MEDICAL-BLS-COLD @ 19:00:05 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015291",
        "ADDR:7777 WASHINGTON BLVD",
        "CITY:JESSUP",
        "PLACE:MSP WATERLOO",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:19:00:05",
        "BOX:0107");

    doTest("T8",
        "(Station 1) EVENT: F12015305 LARK BROWN RD/OLD WATERLOO RD ELK TYPE: RESCUE--UNKNOW @ 22:02:39 BEAT/BOX: 0927 ",
        "SRC:Station 1",
        "ID:F12015305",
        "ADDR:LARK BROWN RD & OLD WATERLOO RD",
        "CITY:ELKRIDGE",
        "CALL:RESCUE--UNKNOW",
        "TIME:22:02:39",
        "BOX:0927");

    doTest("T9",
        "(Station 1) EVENT: F12015319 RT 95 NB/RT 175 SCOL TYPE: RESCUE--UNKNOW @ 02:57:53 BEAT/BOX: 095037 ",
        "SRC:Station 1",
        "ID:F12015319",
        "ADDR:RT 95 NB & RT 175",
        "MADDR:RT 95 & RT 175", 
        "CITY:COLUMBIA",
        "CALL:RESCUE--UNKNOW",
        "TIME:02:57:53",
        "BOX:095037");

    doTest("T10",
        "(Station 1) EVENT: F12015326 6488 SEDGWICK ST ELK TYPE: MEDICAL-*********** @ 04:47:52 BEAT/BOX: 0127 ",
        "SRC:Station 1",
        "ID:F12015326",
        "ADDR:6488 SEDGWICK ST",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:04:47:52",
        "BOX:0127");

    doTest("T11",
        "(Station 1) EVENT: F12015334 6330 WASHINGTON BLVD ELK,103: @HILLSIDE MOTEL TYPE: MEDICAL-*********** @ 08:03:28 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015334",
        "ADDR:6330 WASHINGTON BLVD",
        "APT:103",
        "CITY:ELKRIDGE",
        "PLACE:HILLSIDE MOTEL",
        "CALL:MEDICAL",
        "TIME:08:03:28",
        "BOX:0101");

    doTest("T12",
        "(Station 1) EVENT: F12015352 BALTIMORE COUNTY CTNV: @BC4 TYPE: MUTAID-MAALS @ 12:36:14 BEAT/BOX: BC04 ",
        "SRC:Station 1",
        "ID:F12015352",
        "ADDR:BALTIMORE COUNTY CTNV",
        "MADDR:BC4,BALTIMORE COUNTY CTNV",  // What does this mean???
        "PLACE:BC4",
        "CALL:MUTAID-MAALS",
        "TIME:12:36:14",
        "BOX:BC04");

    doTest("T13",
        "(Station 1) EVENT: F12015364 6245 WASHINGTON BLVD ELK: @PNC BANK TYPE: MISC-noPD @ 14:15:32 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015364",
        "ADDR:6245 WASHINGTON BLVD",
        "CITY:ELKRIDGE",
        "PLACE:PNC BANK",
        "CALL:MISC-noPD",
        "TIME:14:15:32",
        "BOX:0101");

    doTest("T14",
        "(Station 1) EVENT: F12015376 7017 HOLLY SPRINGS LN ELK TYPE: GASLEAK-OUTSIDE @ 17:00:43 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015376",
        "ADDR:7017 HOLLY SPRINGS LN",
        "CITY:ELKRIDGE",
        "CALL:GASLEAK-OUTSIDE",
        "TIME:17:00:43",
        "BOX:0107");

    doTest("T15",
        "(Station 1) EVENT: F12015379 6785 BUSINESS PKWY ELK: @CONVIENT CARE TYPE: MEDICAL-*********** @ 17:49:21 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015379",
        "ADDR:6785 BUSINESS PKWY",
        "CITY:ELKRIDGE",
        "PLACE:CONVIENT CARE",
        "CALL:MEDICAL",
        "TIME:17:49:21",
        "BOX:0106");

    doTest("T16",
        "(Station 1) EVENT: F12015392 6151 HANOVER RD HANR TYPE: MEDICAL-*********** @ 22:33:39 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015392",
        "ADDR:6151 HANOVER RD",
        "CITY:HANOVER",
        "CALL:MEDICAL",
        "TIME:22:33:39",
        "BOX:0101");

    doTest("T17",
        "(Station 1) EVENT: F12015392 6151 HANOVER RD HANR TYPE: MEDICAL-ALSA-HOT @ 22:33:39 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015392",
        "ADDR:6151 HANOVER RD",
        "CITY:HANOVER",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:22:33:39",
        "BOX:0101");

    doTest("T18",
        "(Station 1) EVENT: F12015397 6436 SKIPTON DR HANR TYPE: MEDICAL-*********** @ 23:59:26 BEAT/BOX: 0112 ",
        "SRC:Station 1",
        "ID:F12015397",
        "ADDR:6436 SKIPTON DR",
        "CITY:HANOVER",
        "CALL:MEDICAL",
        "TIME:23:59:26",
        "BOX:0112");

    doTest("T19",
        "(Station 1) EVENT: F12015399 7540 WASHINGTON BLVD ELK: @999 BAR TYPE: MEDICAL-BLS-COLD @ 01:27:55 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015399",
        "ADDR:7540 WASHINGTON BLVD",
        "CITY:ELKRIDGE",
        "PLACE:999 BAR",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:01:27:55",
        "BOX:0106");

    doTest("T20",
        "(Station 1) EVENT: F12015406 RT 95 SB ELK TYPE: VEHICLE-AUTO @ 06:56:26 BEAT/BOX: 095012 ",
        "SRC:Station 1",
        "ID:F12015406",
        "ADDR:RT 95 SB",
        "MADDR:RT 95",
        "CITY:ELKRIDGE",
        "CALL:VEHICLE-AUTO",
        "TIME:06:56:26",
        "BOX:095012");

    doTest("T21",
        "(Station 1) EVENT: F12015431 WILKENS AVE/KENTWOOD AVE TYPE: MUTAID-MARESCUE @ 11:49:17 BEAT/BOX: BC35 ",
        "SRC:Station 1",
        "ID:F12015431",
        "ADDR:WILKENS AVE & KENTWOOD AVE",  // Not mapping - not in howard county??
        "CALL:MUTAID-MARESCUE",
        "TIME:11:49:17",
        "BOX:BC35");

    doTest("T22",
        "(Station 1) EVENT: F12015454 6516 ARROW WAY ELK: @BRAY RESIDENCE TYPE: MEDICAL-*********** @ 15:30:12 BEAT/BOX: 0928 ",
        "SRC:Station 1",
        "ID:F12015454",
        "ADDR:6516 ARROW WAY",
        "CITY:ELKRIDGE",
        "PLACE:BRAY RESIDENCE",
        "CALL:MEDICAL",
        "TIME:15:30:12",
        "BOX:0928");

    doTest("T23",
        "(Station 1) EVENT: F12015457 7540 WASHINGTON BLVD ELK,F: @FLEA MARKET WORLD TYPE: RESCUE--UNKNOW @ 15:51:43 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015457",
        "ADDR:7540 WASHINGTON BLVD",
        "APT:F",
        "CITY:ELKRIDGE",
        "PLACE:FLEA MARKET WORLD",
        "CALL:RESCUE--UNKNOW",
        "TIME:15:51:43",
        "BOX:0106");

    doTest("T24",
        "(Station 1) EVENT: F12015463 7492 MONTEVIDEO RD JSSP TYPE: MEDICAL-*********** @ 16:52:22 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015463",
        "ADDR:7492 MONTEVIDEO RD",
        "CITY:JESSUP",
        "CALL:MEDICAL",
        "TIME:16:52:22",
        "BOX:0107");

    doTest("T25",
        "(Station 1) EVENT: F12015488 6064 MARSHALEE DR ELK,425: @HOLIDAY INN EXPRESS TYPE: HAZMAT-HAZNO @ 23:01:57 BEAT/BOX: 0124 ",
        "SRC:Station 1",
        "ID:F12015488",
        "ADDR:6064 MARSHALEE DR",
        "APT:425",
        "CITY:ELKRIDGE",
        "PLACE:HOLIDAY INN EXPRESS",
        "CALL:HAZMAT-HAZNO",
        "TIME:23:01:57",
        "BOX:0124");

    doTest("T26",
        "(Station 1) EVENT: F12015488 6064 MARSHALEE DR ELK,425: @HOLIDAY INN EXPRESS TYPE: HAZMAT-NOFIRE @ 23:01:57 BEAT/BOX: 0124 ",
        "SRC:Station 1",
        "ID:F12015488",
        "ADDR:6064 MARSHALEE DR",
        "APT:425",
        "CITY:ELKRIDGE",
        "PLACE:HOLIDAY INN EXPRESS",
        "CALL:HAZMAT-NOFIRE",
        "TIME:23:01:57",
        "BOX:0124");

    doTest("T27",
        "(Station 1) EVENT: F12015509 5989 SETTER DR ELK TYPE: ALFIRE-RES @ 03:41:13 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015509",
        "ADDR:5989 SETTER DR",
        "CITY:ELKRIDGE",
        "CALL:ALFIRE-RES",
        "TIME:03:41:13",
        "BOX:0103");

    doTest("T28",
        "(Station 1) EVENT: F12015510 HANOVER RD/ANDERSON AVE HANR TYPE: RESCUE--UNKNOW @ 05:29:53 BEAT/BOX: 0112 ",
        "SRC:Station 1",
        "ID:F12015510",
        "ADDR:HANOVER RD & ANDERSON AVE",
        "CITY:HANOVER",
        "CALL:RESCUE--UNKNOW",
        "TIME:05:29:53",
        "BOX:0112");

    doTest("T29",
        "(Station 1) EVENT: F12015533 6116 DOWNS AVE ELK: @TRAHAN RESIDENCE TYPE: MEDICAL-*********** @ 10:06:00 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015533",
        "ADDR:6116 DOWNS AVE",
        "CITY:ELKRIDGE",
        "PLACE:TRAHAN RESIDENCE",
        "CALL:MEDICAL",
        "TIME:10:06:00",
        "BOX:0101");

    doTest("T30",
        "(Station 1) EVENT: F12015551 7377 WASHINGTON BLVD ELK,101: @ASHLAND CHEMICAL TYPE: MEDICAL-*********** @ 13:28:13 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015551",
        "ADDR:7377 WASHINGTON BLVD",
        "APT:101",
        "CITY:ELKRIDGE",
        "PLACE:ASHLAND CHEMICAL",
        "CALL:MEDICAL",
        "TIME:13:28:13",
        "BOX:0106");

    doTest("T31",
        "(Station 1) EVENT: F12015562 7154 MONTEVIDEO RD JSSP TYPE: MEDICAL-*********** @ 15:39:15 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015562",
        "ADDR:7154 MONTEVIDEO RD",
        "CITY:JESSUP",
        "CALL:MEDICAL",
        "TIME:15:39:15",
        "BOX:0107");

    doTest("T32",
        "(Station 1) EVENT: F12015562 7154 MONTEVIDEO RD JSSP TYPE: MEDICAL-ALSA-HOT @ 15:39:15 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015562",
        "ADDR:7154 MONTEVIDEO RD",
        "CITY:JESSUP",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:15:39:15",
        "BOX:0107");

    doTest("T33",
        "(Station 1) EVENT: F12015579 7719 MILLSTONE CT EC TYPE: MBURN-default @ 18:19:47 BEAT/BOX: 0124 ",
        "SRC:Station 1",
        "ID:F12015579",
        "ADDR:7719 MILLSTONE CT",
        "CITY:ELLICOTT CITY",
        "CALL:MBURN-default",
        "TIME:18:19:47",
        "BOX:0124");

    doTest("T34",
        "(Station 1) EVENT: F12015584 LEVERING AVE/LAWYERS HILL RD ELK TYPE: MISC-noPD @ 19:08:12 BEAT/BOX: 0102 ",
        "SRC:Station 1",
        "ID:F12015584",
        "ADDR:LEVERING AVE & LAWYERS HILL RD",
        "CITY:ELKRIDGE",
        "CALL:MISC-noPD",
        "TIME:19:08:12",
        "BOX:0102");

    doTest("T35",
        "(Station 1) EVENT: F12015593 6983 ELM AVE ELK TYPE: MEDICAL-*********** @ 20:03:41 BEAT/BOX: 0114 ",
        "SRC:Station 1",
        "ID:F12015593",
        "ADDR:6983 ELM AVE",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:20:03:41",
        "BOX:0114");

    doTest("T36",
        "(Station 1) EVENT: F12015600 6912 RED CLAY FORGE ELK TYPE: MEDICAL-*********** @ 21:42:22 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015600",
        "ADDR:6912 RED CLAY FORGE",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:21:42:22",
        "BOX:0104");

    doTest("T37",
        "(Station 1) EVENT: F12015600 6912 RED CLAY FORGE ELK TYPE: MEDICAL-BLS-COLD @ 21:42:22 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015600",
        "ADDR:6912 RED CLAY FORGE",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:21:42:22",
        "BOX:0104");

    doTest("T38",
        "(Station 1) EVENT: F12015639 6205 FAIRBOURNE CT HANR TYPE: MEDICAL-*********** @ 12:05:04 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015639",
        "ADDR:6205 FAIRBOURNE CT",
        "CITY:HANOVER",
        "CALL:MEDICAL",
        "TIME:12:05:04",
        "BOX:0101");

    doTest("T39",
        "(Station 1) EVENT: F12015639 6205 FAIRBOURNE CT HANR TYPE: MEDICAL-ALSA-HOT @ 12:05:04 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015639",
        "ADDR:6205 FAIRBOURNE CT",
        "CITY:HANOVER",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:12:05:04",
        "BOX:0101");

    doTest("T40",
        "(Station 1) EVENT: F12015655 7065 COLUMBIA GATEWAY DR SCOL: @EVI TECHNOLOGY  TYPE: MEDICAL-*********** @ 13:41:55 BEAT/BOX: 0931 ",
        "SRC:Station 1",
        "ID:F12015655",
        "ADDR:7065 COLUMBIA GATEWAY DR",
        "CITY:COLUMBIA",
        "PLACE:EVI TECHNOLOGY",
        "CALL:MEDICAL",
        "TIME:13:41:55",
        "BOX:0931");

    doTest("T41",
        "(Station 1) EVENT: F12015672 RT 29 NB/MONTGOMERY RD EC TYPE: RESCUE--UNKNOW @ 15:15:52 BEAT/BOX: 029037 ",
        "SRC:Station 1",
        "ID:F12015672",
        "ADDR:RT 29 NB & MONTGOMERY RD",
        "MADDR:RT 29 & MONTGOMERY RD",
        "CITY:ELLICOTT CITY",
        "CALL:RESCUE--UNKNOW",
        "TIME:15:15:52",
        "BOX:029037");

    doTest("T42",
        "(Station 1) EVENT: F12015677 8186 LARK BROWN RD ELK,201: @CENTENNIAL MEDICAL GROUP TYPE: MEDICAL-*********** @ 16:10:37 BEAT/BOX: 0927 ",
        "SRC:Station 1",
        "ID:F12015677",
        "ADDR:8186 LARK BROWN RD",
        "APT:201",
        "CITY:ELKRIDGE",
        "PLACE:CENTENNIAL MEDICAL GROUP",
        "CALL:MEDICAL",
        "TIME:16:10:37",
        "BOX:0927");

    doTest("T43",
        "(Station 1) EVENT: F12015700 7505 COVE POINT WAY ELK TYPE: ODOR-UNUSUAL @ 22:02:26 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015700",
        "ADDR:7505 COVE POINT WAY",
        "CITY:ELKRIDGE",
        "CALL:ODOR-UNUSUAL",
        "TIME:22:02:26",
        "BOX:0107");

    doTest("T44",
        "(Station 1) EVENT: F12015701 6636 WASHINGTON BLVD ELK,46: @CAPITAL TRAILER PARK TYPE: MEDICAL-*********** @ 22:07:02 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015701",
        "ADDR:6636 WASHINGTON BLVD",
        "APT:46",
        "CITY:ELKRIDGE",
        "PLACE:CAPITAL TRAILER PARK",
        "CALL:MEDICAL",
        "TIME:22:07:02",
        "BOX:0103");

    doTest("T45",
        "(Station 1) EVENT: F12015701 6636 WASHINGTON BLVD ELK,46: @CAPITAL TRAILER PARK TYPE: MEDICAL-ALSC @ 22:07:02 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015701",
        "ADDR:6636 WASHINGTON BLVD",
        "APT:46",
        "CITY:ELKRIDGE",
        "PLACE:CAPITAL TRAILER PARK",
        "CALL:MEDICAL-ALSC",
        "TIME:22:07:02",
        "BOX:0103");

    doTest("T46",
        "(Station 1) EVENT: F12015711 5823 AUGUSTINE AVE ELK TYPE: MEDICAL-*********** @ 05:19:39 BEAT/BOX: 0101 ",
        "SRC:Station 1",
        "ID:F12015711",
        "ADDR:5823 AUGUSTINE AVE",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:05:19:39",
        "BOX:0101");

    doTest("T47",
        "(Station 1) EVENT: F12015744 6029 HUNT CLUB RD ELK TYPE: MEDICAL-*********** @ 11:59:28 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015744",
        "ADDR:6029 HUNT CLUB RD",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:11:59:28",
        "BOX:0103");

    doTest("T48",
        "(Station 1) EVENT: F12015744 6029 HUNT CLUB RD ELK TYPE: MEDICAL-ALSA-HOT @ 11:59:28 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015744",
        "ADDR:6029 HUNT CLUB RD",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:11:59:28",
        "BOX:0103");

    doTest("T49",
        "(Station 1) EVENT: F12015748 6032 MONTGOMERY RD ELK: @TAYLOR RESIDENCE TYPE: ALFIRE-RES @ 12:36:20 BEAT/BOX: 0124 ",
        "SRC:Station 1",
        "ID:F12015748",
        "ADDR:6032 MONTGOMERY RD",
        "CITY:ELKRIDGE",
        "PLACE:TAYLOR RESIDENCE",
        "CALL:ALFIRE-RES",
        "TIME:12:36:20",
        "BOX:0124");

    doTest("T50",
        "(Station 1) EVENT: F12015761 7380 COCA COLA DR HANR,106: @NETWORK BUILDING AND CONSULTING TYPE: MEDICAL-*********** @ 13:31:11 BEAT/BOX: 0113 ",
        "SRC:Station 1",
        "ID:F12015761",
        "ADDR:7380 COCA COLA DR",
        "APT:106",
        "CITY:HANOVER",
        "PLACE:NETWORK BUILDING AND CONSULTING",
        "CALL:MEDICAL",
        "TIME:13:31:11",
        "BOX:0113");

    doTest("T51",
        "(Station 1) EVENT: F12015761 7380 COCA COLA DR HANR,106: @NETWORK BUILDING AND CONSULTING TYPE: MEDICAL-ALSA-HOT @ 13:31:11 BEAT/BOX: 0113 ",
        "SRC:Station 1",
        "ID:F12015761",
        "ADDR:7380 COCA COLA DR",
        "APT:106",
        "CITY:HANOVER",
        "PLACE:NETWORK BUILDING AND CONSULTING",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:13:31:11",
        "BOX:0113");

    doTest("T52",
        "(Station 1) EVENT: F12015762 5950 TAMAR DR ECOL: @STA9 TYPE: TRANSFER-AMBO @ 13:35:52 BEAT/BOX: 0901 ",
        "SRC:Station 1",
        "ID:F12015762",
        "ADDR:5950 TAMAR DR",
        "CITY:COLUMBIA",
        "PLACE:STA9",
        "CALL:TRANSFER-AMBO",
        "TIME:13:35:52",
        "BOX:0901");

    doTest("T53",
        "(Station 1) EVENT: F12015770 7393 WASHINGTON BLVD ELK: TYPE: ALFIRE-BUSC @ 14:41:05 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015770",
        "ADDR:7393 WASHINGTON BLVD",
        "CITY:ELKRIDGE",
        "CALL:ALFIRE-BUSC",
        "TIME:14:41:05",
        "BOX:0106");

    doTest("T54",
        "(Station 1) EVENT: F12015781 WASHINGTON BLVD/TROY HILL DR NS ELK TYPE: MEDICAL-BLS/PD-HOT @ 16:35:08 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015781",
        "ADDR:WASHINGTON BLVD & TROY HILL DR NS",
        "MADDR:WASHINGTON BLVD & TROY HILL DR",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-BLS/PD-HOT",
        "TIME:16:35:08",
        "BOX:0104");

    doTest("T55",
        "(Station 1) EVENT: F12015782 7030 HI TECH DR HANR: @BELMONT STATION COMMUNITY TYPE: ALFIRE-BUSC @ 16:36:08 BEAT/BOX: 0113 ",
        "SRC:Station 1",
        "ID:F12015782",
        "ADDR:7030 HI TECH DR",
        "CITY:HANOVER",
        "PLACE:BELMONT STATION COMMUNITY",
        "CALL:ALFIRE-BUSC",
        "TIME:16:36:08",
        "BOX:0113");

    doTest("T56",
        "(Station 1) EVENT: F12015791 TYPE: RESCUE--UNKNOW @ 19:17:17 BEAT/BOX: 095021 ",
        "SRC:Station 1",
        "ID:F12015791",
        "CALL:RESCUE--UNKNOW",
        "TIME:19:17:17",
        "BOX:095021");

    doTest("T57",
        "(Station 1) EVENT: F12015801 6900 THOMAS STONE ELK: @BELMOUNT STATION APTS TYPE: MEDICAL-*********** @ 21:07:07 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015801",
        "ADDR:6900 THOMAS STONE",
        "CITY:ELKRIDGE",
        "PLACE:BELMOUNT STATION APTS",
        "CALL:MEDICAL",
        "TIME:21:07:07",
        "BOX:0104");

    doTest("T58",
        "(Station 1) EVENT: F12015801 6900 THOMAS STONE ELK: @BELMOUNT STATION APTS TYPE: MEDICAL-ALSA-HOT @ 21:07:07 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015801",
        "ADDR:6900 THOMAS STONE",
        "CITY:ELKRIDGE",
        "PLACE:BELMOUNT STATION APTS",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:21:07:07",
        "BOX:0104");

    doTest("T59",
        "(Station 1) EVENT: F12015812 6432 WOODLAND FOREST DR ELK TYPE: MEDICAL-*********** @ 06:01:59 BEAT/BOX: 0127 ",
        "SRC:Station 1",
        "ID:F12015812",
        "ADDR:6432 WOODLAND FOREST DR",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:06:01:59",
        "BOX:0127");

    doTest("T60",
        "(Station 1) EVENT: F12015831 7030 HI TECH DR HANR: @BELMONT STATION COMMUNITY TYPE: ALFIRE-BUSC @ 09:41:23 BEAT/BOX: 0113 ",
        "SRC:Station 1",
        "ID:F12015831",
        "ADDR:7030 HI TECH DR",
        "CITY:HANOVER",
        "PLACE:BELMONT STATION COMMUNITY",
        "CALL:ALFIRE-BUSC",
        "TIME:09:41:23",
        "BOX:0113");

    doTest("T61",
        "(Station 1) EVENT: F12015837 42 RT 95 SB ELK: EST TYPE: GASLEAK-OUTSIDE @ 10:24:46 BEAT/BOX: 095034 ",
        "SRC:Station 1",
        "ID:F12015837",
        "ADDR:42 RT 95 SB",
        "MADDR:42 RT 95",
        "CITY:ELKRIDGE",
        "CALL:GASLEAK-OUTSIDE",
        "TIME:10:24:46",
        "BOX:095034");

    doTest("T62",
        "(Station 1) EVENT: F12015853 RT 29 NB EC TYPE: RESCUE--UNKNOW @ 13:17:55 BEAT/BOX: 029033 ",
        "SRC:Station 1",
        "ID:F12015853",
        "ADDR:RT 29 NB",
        "MADDR:RT 29",
        "CITY:ELLICOTT CITY",
        "CALL:RESCUE--UNKNOW",
        "TIME:13:17:55",
        "BOX:029033");

    doTest("T63",
        "(Station 1) EVENT: F12015855 6150 SHADYWOOD ELK,207 TYPE: MEDICAL-*********** @ 13:33:44 BEAT/BOX: 0123 ",
        "SRC:Station 1",
        "ID:F12015855",
        "ADDR:6150 SHADYWOOD",
        "APT:207",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL",
        "TIME:13:33:44",
        "BOX:0123");

    doTest("T64",
        "(Station 1) EVENT: F12015855 6150 SHADYWOOD ELK,207 TYPE: MEDICAL-ALSA-HOT @ 13:33:44 BEAT/BOX: 0123 ",
        "SRC:Station 1",
        "ID:F12015855",
        "ADDR:6150 SHADYWOOD",
        "APT:207",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:13:33:44",
        "BOX:0123");

    doTest("T65",
        "(Station 1) EVENT: F12015869 6315 VIRGINIA PINE PL ELK TYPE: MEDICAL-BLS-COLD @ 15:20:56 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015869",
        "ADDR:6315 VIRGINIA PINE PL",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-BLS-COLD",
        "TIME:15:20:56",
        "BOX:0103");

    doTest("T66",
        "(Station 1) EVENT: F12015878 8801 BOSLEY RD EC TYPE: MEDICAL-*********** @ 16:08:36 BEAT/BOX: 0201 ",
        "SRC:Station 1",
        "ID:F12015878",
        "ADDR:8801 BOSLEY RD",
        "CITY:ELLICOTT CITY",
        "CALL:MEDICAL",
        "TIME:16:08:36",
        "BOX:0201");

    doTest("T67",
        "(Station 1) EVENT: F12015884 RT 95 SB ELK TYPE: RESCUE--UNKNOW @ 17:08:17 BEAT/BOX: 095036 ",
        "SRC:Station 1",
        "ID:F12015884",
        "ADDR:RT 95 SB",
        "MADDR:RT 95",
        "CITY:ELKRIDGE",
        "CALL:RESCUE--UNKNOW",
        "TIME:17:08:17",
        "BOX:095036");

    doTest("T68",
        "(Station 1) EVENT: F12015899 WASHINGTON BLVD/LOUDON AVE ELK TYPE: MEDICAL-BLS-HOT @ 20:14:00 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015899",
        "ADDR:WASHINGTON BLVD & LOUDON AVE", // Not found, reported
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-BLS-HOT",
        "TIME:20:14:00",
        "BOX:0103");

    doTest("T69",
        "(Station 1) EVENT: F12015933 7120 DORSEY RUN RD ELK: @BALTIMORE WASHINGTON AUTO EXCHANGE TYPE: VEHICLE-AUTO @ 10:51:45 BEAT/BOX: 0107 ",
        "SRC:Station 1",
        "ID:F12015933",
        "ADDR:7120 DORSEY RUN RD",
        "CITY:ELKRIDGE",
        "PLACE:BALTIMORE WASHINGTON AUTO EXCHANGE",
        "CALL:VEHICLE-AUTO",
        "TIME:10:51:45",
        "BOX:0107");

    doTest("T70",
        "(Station 1) EVENT: F12015934 7540 WASHINGTON BLVD ELK: @US RT 1 FLEA MARKET TYPE: MEDICAL-*********** @ 11:01:31 BEAT/BOX: 0106 ",
        "SRC:Station 1",
        "ID:F12015934",
        "ADDR:7540 WASHINGTON BLVD",
        "CITY:ELKRIDGE",
        "PLACE:US RT 1 FLEA MARKET",
        "CALL:MEDICAL",
        "TIME:11:01:31",
        "BOX:0106");

    doTest("T71",
        "(Station 1) EVENT: F12015937 6374 DUCKETTS LN ELK TYPE: MEDICAL-ALSA-HOT @ 11:40:04 BEAT/BOX: 0104 ",
        "SRC:Station 1",
        "ID:F12015937",
        "ADDR:6374 DUCKETTS LN",
        "CITY:ELKRIDGE",
        "CALL:MEDICAL-ALSA-HOT",
        "TIME:11:40:04",
        "BOX:0104");

    doTest("T72",
        "(Station 1) EVENT: F12015945 6391 ROWANBERRY DR ELK: @COLONIAL LANDING APARTMENTS TYPE: MEDICAL-*********** @ 12:51:56 BEAT/BOX: 0103 ",
        "SRC:Station 1",
        "ID:F12015945",
        "ADDR:6391 ROWANBERRY DR",
        "CITY:ELKRIDGE",
        "PLACE:COLONIAL LANDING APARTMENTS",
        "CALL:MEDICAL",
        "TIME:12:51:56",
        "BOX:0103");

    doTest("T73",
        "(Station 1) EVENT: F12015956 BALTIMORE COUNTY ENGC: @BC37 TYPE: MUTAID-MAALS @ 15:36:10 BEAT/BOX: BC37 ",
        "SRC:Station 1",
        "ID:F12015956",
        "ADDR:BALTIMORE COUNTY ENGC", // What is this???
        "MADDR:BC37,BALTIMORE COUNTY ENGC",
        "PLACE:BC37",
        "CALL:MUTAID-MAALS",
        "TIME:15:36:10",
        "BOX:BC37");

    doTest("T74",
        "(Station 1) EVENT: F12015957 BALTIMORE COUNTY HALE: @BC5 TYPE: MUTAID-MAALS @ 16:02:45 BEAT/BOX: BC05 ",
        "SRC:Station 1",
        "ID:F12015957",
        "ADDR:BALTIMORE COUNTY HALE",  // And this
        "MADDR:BC5,BALTIMORE COUNTY HALE",
        "PLACE:BC5",
        "CALL:MUTAID-MAALS",
        "TIME:16:02:45",
        "BOX:BC05");
   
  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Saturday, July 14, 2012 3:04:59 PM\n" +
        "To: Levy, MD., Matthew\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: P121960260 TYPE: RESCUE-TRAPPED @ 14:52:27 FREDERICK RD/CARRS MILL RD - 3 P1'S ALL CAT. A' s - 1 TRAPPED OFF ROAD WAY - AVIATION REQUESTED 3X - OPS B1",

        "ID:P121960260",
        "ADDR:FREDERICK RD & CARRS MILL RD",  // Not mapping
        "CALL:RESCUE-TRAPPED",
        "TIME:14:52:27",
        "INFO:3 P1'S ALL CAT A' s - 1 TRAPPED OFF ROAD WAY - AVIATION REQUESTED 3X - OPS B1");

    doTest("T2",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Saturday, July 14, 2012 3:08:29 PM\n" +
        "To: Levy, MD., Matthew\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: P121960260 TYPE: RESCUE-TRAPPED @ 14:52:27 FREDERICK & CARRS MILL RD - PT EXTRICATED - AVIATION ENROUTE 3X'S",

        "ID:P121960260",
        "CALL:RESCUE-TRAPPED",
        "TIME:14:52:27",
        "INFO:FREDERICK & CARRS MILL RD - PT EXTRICATED - AVIATION ENROUTE 3X'S");

    doTest("T3",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Tuesday, July 24, 2012 1:25:18 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12021123 TYPE: RESCUE-AUTOVS @ 13:14:17 BEAT/BOX: 0508       P1 FLYOUT",

        "ID:F12021123",
        "CALL:RESCUE-AUTOVS",
        "TIME:13:14:17",
        "BOX:0508",
        "INFO:P1 FLYOUT");

    doTest("T4",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Sunday, July 29, 2012 3:51:04 AM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12021615 5009 COLUMBIA RD WCOL,401 TYPE: FIRE-MULTIFAMILY @ 02:53:13 BEAT/BOX: 0221:  CMD ADVISING 4 APARTMENTS THAT WILL NEED ASSISTANCE. TOTAL OF 5 DAMAGED.  FM IS RESPONDING. FIRE OUT.",

        "ID:F12021615",
        "ADDR:5009 COLUMBIA RD",
        "APT:401",
        "CITY:COLUMBIA",
        "CALL:FIRE-MULTIFAMILY",
        "TIME:02:53:13",
        "BOX:0221:",
        "INFO:CMD ADVISING 4 APARTMENTS THAT WILL NEED ASSISTANCE. TOTAL OF 5 DAMAGED.  FM IS RESPONDING. FIRE OUT.");

    doTest("T5",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 01, 2012 4:23:44 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12021972 SB I95 TO EB RT 100 RAMP ELK TYPE: RESCUE-TRAPPED @ 16:12:42 BEAT/BOX: 095032     PT PINNED...RAMP FROM E/B 100 SHUT DOWN",

        "ID:F12021972",
        "ADDR:SB I95 TO EB RT 100 RAMP",
        "MADDR:I 95 TO RT 100 RAMP",
        "CITY:ELKRIDGE",
        "CALL:RESCUE-TRAPPED",
        "TIME:16:12:42",
        "BOX:095032",
        "INFO:PT PINNED...RAMP FROM E/B 100 SHUT DOWN");

    doTest("T6",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 01, 2012 4:50:40 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12021972 SB I95 TO EB RT 100 RAMP ELK TYPE: RESCUE-TRAPPED @ 16:12:42 BEAT/BOX: 095032     PT EXTRICATED",

        "ID:F12021972",
        "ADDR:SB I95 TO EB RT 100 RAMP",
        "MADDR:I 95 TO RT 100 RAMP",
        "CITY:ELKRIDGE",
        "CALL:RESCUE-TRAPPED",
        "TIME:16:12:42",
        "BOX:095032",
        "INFO:PT EXTRICATED");

    doTest("T7",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 01, 2012 5:06:51 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12021972 SB I95 TO EB RT 100 RAMP ELK TYPE: RESCUE-TRAPPED @ 16:12:42 BEAT/BOX: 095032   INJURED  FF  TRANPORTED TO HCGH P3",

        "ID:F12021972",
        "ADDR:SB I95 TO EB RT 100 RAMP",
        "MADDR:I 95 TO RT 100 RAMP",
        "CITY:ELKRIDGE",
        "CALL:RESCUE-TRAPPED",
        "TIME:16:12:42",
        "BOX:095032",
        "INFO:INJURED  FF  TRANPORTED TO HCGH P3");

    doTest("T8",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Friday, August 03, 2012 9:45:28 AM\n" +
        "To: OnCallPIO\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022137 7246 CRADLEROCK WAY ES ECOL: @OWEN BROWN INTERFAITH CENTER TYPE: INVPKG-default @ 09:14:05 BEAT/BOX: 1032",

        "ID:F12022137",
        "ADDR:7246 CRADLEROCK WAY ES",
        "CITY:COLUMBIA",
        "PLACE:OWEN BROWN INTERFAITH CENTER",
        "CALL:INVPKG-default",
        "TIME:09:14:05",
        "BOX:1032");

    doTest("T9",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Friday, August 03, 2012 9:45:28 AM\n" +
        "To: OnCallPIO\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022137 7246 CRADLEROCK WAY ES ECOL: @OWEN BROWN INTERFAITH CENTER TYPE: INVPKG-default @ 09:14:05 BEAT/BOX: 1032",

        "ID:F12022137",
        "ADDR:7246 CRADLEROCK WAY ES",  // Not mapping - ES??
        "CITY:COLUMBIA",
        "PLACE:OWEN BROWN INTERFAITH CENTER",
        "CALL:INVPKG-default",
        "TIME:09:14:05",
        "BOX:1032");

    doTest("T10",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Sunday, August 05, 2012 7:26:22 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022371 8731 WEATHERED STONE WAY LAUR TYPE: FIRE-HOUSE @ 16:55:33 BEAT/BOX: 0613:CMD FIRE OUT. RED CROSS NOTIFIED.",

        "ID:F12022371",
        "ADDR:8731 WEATHERED STONE WAY",
        "CITY:LAUREL",
        "CALL:FIRE-HOUSE",
        "TIME:16:55:33",
        "BOX:0613:CMD",
        "INFO:FIRE OUT. RED CROSS NOTIFIED.");

    doTest("T11",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 08, 2012 12:48:55 PM\n" +
        "To: OnCallPIO\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022676 1430 WOODSTOCK RD WDSK: EST TYPE: RAIL-FREIGHT @ 12:46:47 BEAT/BOX: 0814",

        "ID:F12022676",
        "ADDR:1430 WOODSTOCK RD", 
        "CITY:WOODSTOCK",
        "CALL:RAIL-FREIGHT",
        "TIME:12:46:47",
        "BOX:0814");

    doTest("T12",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 08, 2012 12:48:55 PM\n" +
        "To: OnCallPIO\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022676 1430 WOODSTOCK RD WDSK: EST TYPE: RAIL-FREIGHT @ 12:46:47 BEAT/BOX: 0814",

        "ID:F12022676",
        "ADDR:1430 WOODSTOCK RD",
        "CITY:WOODSTOCK",
        "CALL:RAIL-FREIGHT",
        "TIME:12:46:47",
        "BOX:0814");

    doTest("T13",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 08, 2012 12:57:35 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022676 1430 WOODSTOCK RD WDSK: EST TYPE: RAIL-FREIGHT @ 12:46:47 ONE CLORINE CAR DERAILED - NOT LEAKING - STILL INVESTIGATING",

        "ID:F12022676",
        "ADDR:1430 WOODSTOCK RD",
        "CITY:WOODSTOCK",
        "CALL:RAIL-FREIGHT",
        "TIME:12:46:47");

    doTest("T14",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Wednesday, August 08, 2012 1:00:51 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: P122210218 1430 WOODSTOCK RD WDSK: EST TYPE: RAIL-FREIGHT @ 12:46:47 Evacuations of the immeadiate area - HCFR and POLICE are on the scene.",

        "ID:P122210218",
        "ADDR:1430 WOODSTOCK RD",
        "CITY:WOODSTOCK",
        "CALL:RAIL-FREIGHT",
        "TIME:12:46:47");

    doTest("T15",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Thursday, August 09, 2012 3:16:08 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022792 CLARKSVILLE PK/WAINWRIGHT RD HIGH TYPE: RESCUE-TRAPPED @ 14:59:52 BEAT/BOX: 0508 1 SUBJECT TRAPED TROOPER ENROUTE",

        "ID:F12022792",
        "ADDR:CLARKSVILLE PK & WAINWRIGHT RD",
        "MADDR:CLARKSVILLE PIKE & WAINWRIGHT RD",
        "CITY:HIGHLAND",
        "CALL:RESCUE-TRAPPED",
        "TIME:14:59:52",
        "BOX:0508",
        "INFO:1 SUBJECT TRAPED TROOPER ENROUTE");

    doTest("T16",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Thursday, August 09, 2012 4:34:36 PM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12022805 BALTIMORE NATIONAL PK EB/ROGERS AVE EC TYPE: RESCUE-TRAPPED @ 16:27:12 BEAT/BOX: 0242 DUMP TRUCK OVERTURNED 1 P1 1 P2",

        "ID:F12022805",
        "ADDR:BALTIMORE NATIONAL PK EB & ROGERS AVE",
        "MADDR:BALTIMORE NATIONAL PIKE & ROGERS AVE",
        "CITY:ELLICOTT CITY",
        "CALL:RESCUE-TRAPPED",
        "TIME:16:27:12",
        "BOX:0242",
        "INFO:DUMP TRUCK OVERTURNED 1 P1 1 P2");

    doTest("T17",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Sunday, August 12, 2012 6:18:58 AM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12023058 5141 BRITTEN LN EC TYPE: FIRE-HOUSE @ 06:07:27 BEAT/BOX: 0232  ATTACHED GARAGE WORKING FIRE",

        "ID:F12023058",
        "ADDR:5141 BRITTEN LN",
        "CITY:ELLICOTT CITY",
        "CALL:FIRE-HOUSE",
        "TIME:06:07:27",
        "BOX:0232",
        "INFO:ATTACHED GARAGE WORKING FIRE");

    doTest("T18",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Sunday, August 12, 2012 6:22:27 AM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12023058 5141 BRITTEN LN EC TYPE: BC2 FIRE IN GARAGE ONLY",

        "ID:F12023058",
        "ADDR:5141 BRITTEN LN",
        "CITY:ELLICOTT CITY",
        "CALL:BC2 FIRE IN GARAGE ONLY");

    doTest("T19",
        "\n-------------------------------------------\n" +
        "From: I/Page CAD[SMTP:HC1@HOWARDCOUNTYMD.GOV]\n" +
        "Sent: Sunday, August 12, 2012 6:39:16 AM\n" +
        "To: Walton, Douglas\n" +
        "Auto forwarded by a Rule\n\n" +
        "EVENT: F12023058 5141 BRITTEN LN EC TYPE: FIRE-HOUSE @ 06:07:27 BEAT/BOX: 0232:  CMD ADVISING FIRE OUT.",

        "ID:F12023058",
        "ADDR:5141 BRITTEN LN",
        "CITY:ELLICOTT CITY",
        "CALL:FIRE-HOUSE",
        "TIME:06:07:27",
        "BOX:0232:",
        "INFO:CMD ADVISING FIRE OUT.");

  }
  
  public static void main(String[] args) {
    new MDHowardCountyParserTest().generateTests("T1");
  }
}