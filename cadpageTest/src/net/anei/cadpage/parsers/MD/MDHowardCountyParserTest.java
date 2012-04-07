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
  public void testActive911() {

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
  
  public static void main(String[] args) {
    new MDHowardCountyParserTest().generateTests("T1");
  }
}