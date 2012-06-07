package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNAndersonCountyParserTest extends BaseParserTest {
  
  public TNAndersonCountyParserTest() {
    setParser(new TNAndersonCountyParser(), "ANDERSON COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(E911) Fire - Residential - 782 BRUSHY VALLEY RD ANDERSONVILLE, TN - REC:04:51 DISP:04:51 RESP:04:53 ONSC:05:09 INSRV:08:13 TRK#:178730",
        "CALL:RUN REPORT",
        "PLACE:Fire - Residential - 782 BRUSHY VALLEY RD ANDERSONVILLE, TN - REC:04:51 DISP:04:51 RESP:04:53 ONSC:05:09 INSRV:08:13 TRK#:178730");

    doTest("T2",
        "(E911) Fire Alarm-Residential - 1534 MOUNTAIN RD ANDERSONVILLE, TN",
        "CALL:Fire Alarm-Residential",
        "ADDR:1534 MOUNTAIN RD",
        "CITY:ANDERSONVILLE");

    doTest("T3",
        "(E911) Fire - Residential - 778 BRUSHY VALLEY RD ANDERSONVILLE, TN",
        "CALL:Fire - Residential",
        "ADDR:778 BRUSHY VALLEY RD",
        "CITY:ANDERSONVILLE");

    doTest("T4",
        "(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572",
        "CALL:RUN REPORT",
        "PLACE:Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572");

    doTest("T5",
        "(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN",
        "CALL:Fire - Other",
        "ADDR:ANDERSONVILLE HWY & BETHEL ROAD",
        "CITY:CLINTON");

    doTest("T6",
        "(E911) MVA - Hazards - BETHEL RD CLINTON, TN -REC:03:15 DISP:03:17 RESP:03:19 ONSC:03:35 INSRV:04:03 TRK#:178399",
        "CALL:RUN REPORT",
        "PLACE:MVA - Hazards - BETHEL RD CLINTON, TN -REC:03:15 DISP:03:17 RESP:03:19 ONSC:03:35 INSRV:04:03 TRK#:178399");

    doTest("T7",
        "(E911) MVA - Hazards - BETHEL RD CLINTON, TN",
        "CALL:MVA - Hazards",
        "ADDR:BETHEL RD",
        "CITY:CLINTON");

    doTest("T8",
        "(E911) CVFD FIRST RESP - 3259 W WOLF VALLEY ROAD CLINTON, TN - FALL INJURIES",
        "SRC:CVFD FIRST RESP",
        "CALL:FALL INJURIES",
        "ADDR:3259 W WOLF VALLEY ROAD",
        "CITY:CLINTON");

    doTest("T9",
        "(E911) RESC - I75 SB @ MM 119 CLINTON, TN - MVA",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:I75 SB & MM 119",
        "MADDR:I 75 & MM 119",
        "CITY:CLINTON");

    doTest("T10",
        "(E911) MVA - Injury - I75 SB @ MM 119 CLINTON, TN - REC:02:41 DISP:02:41 RESP:02:45 ONSC: INSRV:02:51 TRK#:179132",
        "CALL:RUN REPORT",
        "PLACE:MVA - Injury - I75 SB @ MM 119 CLINTON, TN - REC:02:41 DISP:02:41 RESP:02:45 ONSC: INSRV:02:51 TRK#:179132");

    doTest("T11",
        "(E911) MARFVD FIRST RESP - 1508 LAUREL RD CLINTON, TN - DIFFICULTY BREATHING",
        "SRC:MARFVD FIRST RESP",
        "CALL:DIFFICULTY BREATHING",
        "ADDR:1508 LAUREL RD",
        "CITY:CLINTON");

    doTest("T12",
        "(E911) EMS Assist - 1508 LAUREL RD CLINTON, TN - REC:20:21 DISP:20:23 RESP:20:24 ONSC:20:31 INSRV:20:39 TRK#:179119",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 1508 LAUREL RD CLINTON, TN - REC:20:21 DISP:20:23 RESP:20:24 ONSC:20:31 INSRV:20:39 TRK#:179119");

    doTest("T13",
        "(E911) Mutual Aid Request - 838 OLIVER SPRINGS HIGHWAY CLINTON, TN",
        "CALL:Mutual Aid Request",
        "ADDR:838 OLIVER SPRINGS HIGHWAY",
        "CITY:CLINTON");

    doTest("T14",
        "(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN",
        "CALL:Fire - Other",
        "ADDR:ANDERSONVILLE HWY & BETHEL ROAD",
        "CITY:CLINTON");

    doTest("T15",
        "(E911) Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572",
        "CALL:RUN REPORT",
        "PLACE:Fire - Other - ANDERSONVILLE HWY @ BETHEL ROAD CLINTON, TN - REC:14:25 DISP:14:25 RESP:14:25 ONSC:14:30 INSRV:14:30 TRK#:178572");
  
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "E911 / MARFVD - FROST BOTTOM ROAD  OLIVER SPRINGS, TN - MVA\n\n",
        "SRC:MARFVD",
        "CALL:MVA",
        "ADDR:FROST BOTTOM ROAD",
        "CITY:OLIVER SPRINGS");

    doTest("T2",
        "E911 / MARFVD FIRST RESP - 1180 DUTCH VALLEY ROAD  CLINTON, TN - DIFFICULTY  BREATHING\n\n",
        "SRC:MARFVD FIRST RESP",
        "CALL:DIFFICULTY  BREATHING",
        "ADDR:1180 DUTCH VALLEY ROAD",
        "CITY:CLINTON");

    doTest("T3",
        "E911 / Fire Alarm-Residential - 351 WOODLAND HILLS ROAD CLINTON, TN - REC:12:11 DISP:12:12 RESP:12:16 ONSC: INSRV:12:17 TRK#:188459\n\n",
        "CALL:RUN REPORT",
        "PLACE:Fire Alarm-Residential - 351 WOODLAND HILLS ROAD CLINTON, TN - REC:12:11 DISP:12:12 RESP:12:16 ONSC: INSRV:12:17 TRK#:188459");
   
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "[E911] AVFD FIRST RESP - 130 HUMPHREY CEMETERY HEISKELL, TN - STROKE\n",
        "SRC:AVFD FIRST RESP",
        "CALL:STROKE",
        "ADDR:130 HUMPHREY CEMETERY",
        "CITY:HEISKELL");

    doTest("T2",
        "[E911] Service Call - Investigation - 414 NORTH DOGWOOD RD POWELL, TN\n",
        "CALL:Service Call - Investigation",
        "ADDR:414 NORTH DOGWOOD RD",
        "CITY:POWELL");

    doTest("T3",
        "[E911] Service Call - Investigation - 414 NORTH DOGWOOD RD POWELL, TN\n",
        "CALL:Service Call - Investigation",
        "ADDR:414 NORTH DOGWOOD RD",
        "CITY:POWELL");

    doTest("T4",
        "[E911] EMS Assist - 444 EAST WOLF VALLEY RD HEISKELL, TN - REC:19:17 DISP:19:18\nRESP:19:20 ONSC:19:28 INSRV:19:50 TRK#:211465\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 444 EAST WOLF VALLEY RD HEISKELL, TN - REC:19:17 DISP:19:18\nRESP:19:20 ONSC:19:28 INSRV:19:50 TRK#:211465");

    doTest("T5",
        "[E911] Natural Disaster - 101 SOUTH MAIN ST., CLINTON, TN\n",
        "CALL:Natural Disaster",
        "ADDR:101 SOUTH MAIN ST",
        "CITY:CLINTON");

    doTest("T6",
        "[E911] MVA - Injury - 101 SOUTH MAIN ST, CLINTON, TN\n",
        "CALL:MVA - Injury",
        "ADDR:101 SOUTH MAIN ST",
        "CITY:CLINTON");

    doTest("T7",
        "[E911] Fire - Commercial - 402 BETHEL RD, OAK RIDGE, TN\n",
        "CALL:Fire - Commercial",
        "ADDR:402 BETHEL RD",  // Not mapping
        "CITY:OAK RIDGE");

    doTest("T8",
        "[E911] Fire - Commercial - 402 BETHEL RD, OAK RIDGE, TN\n",
        "CALL:Fire - Commercial",
        "ADDR:402 BETHEL RD",
        "CITY:OAK RIDGE");

    doTest("T9",
        "[E911] Fire Alarm-Residential- 410 MEHAFFEY RD CLINTON, TN\n",
        "CALL:Fire Alarm-Residential",
        "ADDR:410 MEHAFFEY RD",
        "CITY:CLINTON");

    doTest("T10",
        "[Fwd: E911] Fire Alarm-Residential- 410 MEHAFFEY RD CLINTON TN\n",
        "CALL:Fire Alarm-Residential",
        "ADDR:410 MEHAFFEY RD",
        "CITY:CLINTON");

    doTest("T11",
        "[E911] Fire Alarm-Residential- 410 MEHAFFEY RD CLINTON TN\n",
        "CALL:Fire Alarm-Residential",
        "ADDR:410 MEHAFFEY RD",
        "CITY:CLINTON");

    doTest("T12",
        "[E911] Fire Alarm-Residential- 410 MEHAFFEY RD CLINTON TN\n",
        "CALL:Fire Alarm-Residential",
        "ADDR:410 MEHAFFEY RD",
        "CITY:CLINTON");

    doTest("T13",
        "[E911] Fire Alarm-Residential- 410 MEHAFFEY RD CLINTON TN\n",
        "CALL:Fire Alarm-Residential",
        "ADDR:410 MEHAFFEY RD",
        "CITY:CLINTON");

    doTest("T14",
        "[E911] Lift Assist - 100 MARLOW CIR, CLINTON, TN\n",
        "CALL:Lift Assist",
        "ADDR:100 MARLOW CIR",
        "CITY:CLINTON");

    doTest("T15",
        "[E911] Airplane Crash - 123 WEST BROAD ST, CLINTON, TN\n",
        "CALL:Airplane Crash",
        "ADDR:123 WEST BROAD ST",
        "CITY:CLINTON");

    doTest("T16",
        "[E911] Lift Assist - 100 MARLOW CIR, CLINTON, TN - REC:14:12 DISP:14:12 RESP: ONSC: INSRV:14:19 TRK#:211540\n",
        "CALL:RUN REPORT",
        "PLACE:Lift Assist - 100 MARLOW CIR, CLINTON, TN - REC:14:12 DISP:14:12 RESP: ONSC: INSRV:14:19 TRK#:211540");

    doTest("T17",
        "[E911] Airplane Crash - 123 WEST BROAD ST, CLINTON, TN - REC:14:17 DISP:14:18 RESP: ONSC: INSRV:14:19 TRK#:211543\n",
        "CALL:RUN REPORT",
        "PLACE:Airplane Crash - 123 WEST BROAD ST, CLINTON, TN - REC:14:17 DISP:14:18 RESP: ONSC: INSRV:14:19 TRK#:211543");

    doTest("T18",
        "[E911] Lift Assist - 617 PINE RIDGE RD, CLINTON, TN - REC:17:14 DISP:17:14 RESP: ONSC: INSRV:17:19 TRK#:212848",
        "CALL:RUN REPORT",
        "PLACE:Lift Assist - 617 PINE RIDGE RD, CLINTON, TN - REC:17:14 DISP:17:14 RESP: ONSC: INSRV:17:19 TRK#:212848");
    
  }
  

  public static void main(String[] args) {
    new TNAndersonCountyParserTest().generateTests("T1");
  }
}
