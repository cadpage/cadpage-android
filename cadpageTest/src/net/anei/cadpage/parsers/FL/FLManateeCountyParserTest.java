package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class FLManateeCountyParserTest extends BaseParserTest {
  
  public FLManateeCountyParserTest() {
    setParser(new FLManateeCountyParser(), "MANATEE COUNTY", "FL");
  }
  
  @Test
  public void testLeeWhitehurst() {

    doTest("T1",
        "Location: SR70 EB FR I75 NB UB Estimated Address: alias EXIT 217 UB TYPE CODE: ACCIDENT W/ INJURIES - FIRE/EMS INSIDE LOCATION: SUB TYPE: RE-HIGH MECHANISM (ROLLOVER) TIME: 17:33:02 MAP GRID: 1913-D",
        "ADDR:SR70 EB FR I75 NB",
        "MADDR:alias EXIT 217 UB,SR70 FRONTAGE RD I 75",
        "CITY:BRADENTON",
        "PLACE:alias EXIT 217 UB",
        "CALL:ACCIDENT W/ INJURIES - FIRE/EMS INSIDE LOCATION:",
        "INFO:RE-HIGH MECHANISM (ROLLOVER)",
        "TIME:17:33:02",
        "MAP:1913-D");

    doTest("T2",
        "Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE (THREAT RESIDENTIAL) TIME: 19:21:37 MAP GRID: 2207-A",
        "ADDR:9913 289TH ST E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:LARGE OUTSIDE FIRE (THREAT RESIDENTIAL)",
        "TIME:19:21:37",
        "MAP:2207-A");

    doTest("T3",
        "Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE (THREAT BLDG) TIME: 17:32:16 MAP GRID: 2207-A",
        "ADDR:9913 289TH ST E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE (THREAT BLDG)",
        "TIME:17:32:16",
        "MAP:2207-A");

    doTest("T4",
        "Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE (THREAT BLDG) TIME: 17:32:16 MAP GRID: 2207-A",
        "ADDR:9913 289TH ST E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE (THREAT BLDG)",
        "TIME:17:32:16",
        "MAP:2207-A");

    doTest("T5",
        "Location: 35100 SR 64 E MY Estimated Address: @FAULKNER FARMS TYPE CODE: TRAUMATIC INJURIES INSIDE LOCATION: SUB TYPE: RE-UNCONSCIOUS OR ARREST TIME: 19:04:35 MAP GRID: 1602-B",
        "ADDR:35100 SR 64 E",
        "MADDR:35100 ST 64 E",
        "CITY:MYAKKA CITY",
        "PLACE:FAULKNER FARMS",
        "CALL:TRAUMATIC INJURIES INSIDE LOCATION:",
        "INFO:RE-UNCONSCIOUS OR ARREST",
        "TIME:19:04:35",
        "MAP:1602-B");

    doTest("T6",
        "Location: 9913 289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE (THREAT RESIDENTIAL) TIME: 19:21:37 MAP GRID: 2207-A",
        "ADDR:9913 289TH ST E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:LARGE OUTSIDE FIRE (THREAT RESIDENTIAL)",
        "TIME:19:21:37",
        "MAP:2207-A");

    doTest("T7",
        "Location: SINGLETARY RD/289TH ST E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 15:07:03 MAP GRID: 2218-C",
        "ADDR:SINGLETARY RD & 289TH ST E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE",
        "TIME:15:07:03",
        "MAP:2218-C");

    doTest("T8",
        "Location: 30771 BETTS RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE TIME: 15:16:08 MAP GRID: 2208-A",
        "ADDR:30771 BETTS RD",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:LARGE OUTSIDE FIRE",
        "TIME:15:16:08",
        "MAP:2208-A");

    doTest("T9",
        "Location: 6520 219TH ST E UB Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 13:31:53 MAP GRID: 1721-C",
        "ADDR:6520 219TH ST E",
        "CITY:BRADENTON",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE",
        "TIME:13:31:53",
        "MAP:1721-C");

    doTest("T10",
        "Location: 40721 11TH AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 18:11:48 MAP GRID: 1432-E",
        "ADDR:40721 11TH AVE E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE",
        "TIME:18:11:48",
        "MAP:1432-E");

    doTest("T11",
        "Location: 71ST AVE E/VERNA BETHANY RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE W/ UNK THREAT TIME: 14:26:20 MAP GRID: 1725-F",
        "ADDR:71ST AVE E & VERNA BETHANY RD",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE W/ UNK THREAT",
        "TIME:14:26:20",
        "MAP:1725-F");

    doTest("T12",
        "Location: 25606 73RD AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: LARGE OUTSIDE FIRE W/ UNK THREAT TIME: 14:31:14 MAP GRID: 1726-F",
        "ADDR:25606 73RD AVE E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:LARGE OUTSIDE FIRE W/ UNK THREAT",
        "TIME:14:31:14",
        "MAP:1726-F");

    doTest("T13",
        "Location: 25008 75TH AVE E MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE TIME: 09:29:29 MAP GRID: 1726-F",
        "ADDR:25008 75TH AVE E",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE",
        "TIME:09:29:29",
        "MAP:1726-F");
    
  }
  
  @Test
  public void testDanielCacchiotti() {

    doTest("T1",
        "Estimated Address: EST 17993 SR 70 E UB TYPE CODE: ACCIDENT W/ INJS (FIRE/EMS) INSIDE LOCATION: SUB TYPE: RE-UNK STATUS/OTHER CODES N/A TIME: 00:49:38 MAP GRID",
        "ADDR:17993 SR 70 E",
        "MADDR:17993 ST 70 E",
        "CITY:BRADENTON",
        "CALL:ACCIDENT W/ INJS (FIRE/EMS) INSIDE LOCATION:",
        "INFO:RE-UNK STATUS/OTHER CODES N/A",
        "TIME:00:49:38");

    doTest("T2",
        "Location: 11031 GATEWOOD DR UB Estimated Address TYPE CODE: TEST CALL FOR ECC INSIDE LOCATION: SUB TYPE:  TIME: 11:06:59 MAP GRID: 1132-E",
        "ADDR:11031 GATEWOOD DR",
        "CITY:BRADENTON",
        "CALL:TEST CALL FOR ECC INSIDE LOCATION:",
        "TIME:11:06:59",
        "MAP:1132-E");

    doTest("T3",
        "Location: 71ST AVE E/VERNA BETHANY RD MY Estimated Address TYPE CODE: OUTSIDE FIRE INSIDE LOCATION: SUB TYPE: BRUSH FIRE W/ UNK THREAT TIME: 14:26:20 MAP GRID:",
        "ADDR:71ST AVE E & VERNA BETHANY RD",
        "CITY:MYAKKA CITY",
        "CALL:OUTSIDE FIRE INSIDE LOCATION:",
        "INFO:BRUSH FIRE W/ UNK THREAT",
        "TIME:14:26:20");

    doTest("T4",
        "Location: SR 64 E/LAKEWOOD RANCH BLVD UB Estimated Address TYPE CODE: VEHICLE FIRE INSIDE LOCATION: SUB TYPE: COMMERCIAL VEHICLE TIME: 18:44:41 MAP GRID: 1130-E",
        "ADDR:SR 64 E & LAKEWOOD RANCH BLVD",
        "MADDR:ST 64 E & LAKEWOOD RANCH BLVD",
        "CITY:BRADENTON",
        "CALL:VEHICLE FIRE INSIDE LOCATION:",
        "INFO:COMMERCIAL VEHICLE",
        "TIME:18:44:41",
        "MAP:1130-E");

    doTest("T5",
        "Location: 11030 SR 64 E UB Estimated Address TYPE CODE: VEHICLE FIRE INSIDE LOCATION: SUB TYPE: COMMERCIAL VEHICLE TIME: 18:44:41 MAP GRID: 1129-E",
        "ADDR:11030 SR 64 E",
        "MADDR:11030 ST 64 E",
        "CITY:BRADENTON",
        "CALL:VEHICLE FIRE INSIDE LOCATION:",
        "INFO:COMMERCIAL VEHICLE",
        "TIME:18:44:41",
        "MAP:1129-E");
  }
  
  public static void main(String[] args) {
    new FLManateeCountyParserTest().generateTests("T1");
  }
}
  