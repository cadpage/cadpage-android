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

    doTest("T19",
        "[E911] EMS Assist - 236 PLEASANT VIEW LOOP , CLINTON, TN - REC:11:50 DISP:11:52 RESP: ONSC: INSRV:12:35 TRK#:212915",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 236 PLEASANT VIEW LOOP , CLINTON, TN - REC:11:50 DISP:11:52 RESP: ONSC: INSRV:12:35 TRK#:212915");

    doTest("T20",
        "[E911] RESC FIRST RESP - 575 OLD TACORA HILLS RD  CLINTON, TN - UNRESPONSIVE",
        "SRC:RESC FIRST RESP",
        "CALL:UNRESPONSIVE",
        "ADDR:575 OLD TACORA HILLS RD",
        "CITY:CLINTON");

    doTest("T21",
        "[E911] EMS Assist - 575 OLD TACORA HILLS RD , CLINTON, TN - REC:00:31 DISP:00:37 RESP: ONSC: INSRV:01:07 TRK#:212959",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 575 OLD TACORA HILLS RD , CLINTON, TN - REC:00:31 DISP:00:37 RESP: ONSC: INSRV:01:07 TRK#:212959");

    doTest("T22",
        "[E911] RESC - I-75 NB 121-122 CLINTON, TN - MVA",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:I-75 NB 121-122",
        "MADDR:I 75 121",
        "CITY:CLINTON");

    doTest("T23",
        "[E911] EMS Assist - I-75 NB 121-122, CLINTON, TN - REC:01:12 DISP:01:13 RESP:01:16 ONSC:01:26 INSRV:01:34 TRK#:212962",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - I-75 NB 121-122, CLINTON, TN - REC:01:12 DISP:01:13 RESP:01:16 ONSC:01:26 INSRV:01:34 TRK#:212962");

    doTest("T24",
        "[E911] RESC FIRST RESP - 137 BRYANT CIR LAKE CITY, TN - LOW 02 SATS",
        "SRC:RESC FIRST RESP",
        "CALL:LOW 02 SATS",
        "ADDR:137 BRYANT CIR",
        "CITY:LAKE CITY");

    doTest("T25",
        "[E911] RESC FIRST RESP - 522 PINE RIDGE RD CLINTON, TN - MENTAL STATUS CHANGE",
        "SRC:RESC FIRST RESP",
        "CALL:MENTAL STATUS CHANGE",
        "ADDR:522 PINE RIDGE RD",
        "CITY:CLINTON");

    doTest("T26",
        "[E911] EMS Assist - 137 BRYANT CIR, LAKE CITY, TN - REC:14:45 DISP:14:52 RESP: ONSC: INSRV:15:25 TRK#:213056",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 137 BRYANT CIR, LAKE CITY, TN - REC:14:45 DISP:14:52 RESP: ONSC: INSRV:15:25 TRK#:213056");

    doTest("T27",
        "[E911] EMS Assist - 522 PINE RIDGE RD, CLINTON, TN - REC:15:01 DISP:15:07 RESP: ONSC: INSRV:15:28 TRK#:213062",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 522 PINE RIDGE RD, CLINTON, TN - REC:15:01 DISP:15:07 RESP: ONSC: INSRV:15:28 TRK#:213062");

    doTest("T28",
        "[E911] RESC FIRST RESP - 1215 DUTCH VALLEY RD CLINTON, TN - PAIN-CHEST",
        "SRC:RESC FIRST RESP",
        "CALL:PAIN-CHEST",
        "ADDR:1215 DUTCH VALLEY RD",
        "CITY:CLINTON");

    doTest("T29",
        "[E911] EMS Assist - 1215 DUTCH VALLEY RD, CLINTON, TN - REC:15:21 DISP:15:24 RESP: ONSC: INSRV:15:54 TRK#:213071",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 1215 DUTCH VALLEY RD, CLINTON, TN - REC:15:21 DISP:15:24 RESP: ONSC: INSRV:15:54 TRK#:213071");

    doTest("T30",
        "[E911] RESC - 3044 LAKE CITY HWY LAKE CITY, TN - MVA - 213938\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:3044 LAKE CITY HWY",
        "CITY:LAKE CITY",
        "ID:213938");

    doTest("T31",
        "[E911] EMS Assist - 3044 LAKE CITY HWY, LAKE CITY, TN - REC:03:21 DISP:03:25 RESP:03:26 ONSC:03:30 INSRV:05:34 TRK#:213940\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 3044 LAKE CITY HWY, LAKE CITY, TN - REC:03:21 DISP:03:25 RESP:03:26 ONSC:03:30 INSRV:05:34 TRK#:213940");

    doTest("T32",
        "[E911] RESC FIRST RESP - 410 ANDYS RIDGE RD LAKE CITY, TN - DIFFICULTY  BREATHING - 213951\n",
        "SRC:RESC FIRST RESP",
        "CALL:DIFFICULTY  BREATHING",
        "ADDR:410 ANDYS RIDGE RD",
        "CITY:LAKE CITY",
        "ID:213951");

    doTest("T33",
        "[E911] EMS Assist - 410 ANDYS RIDGE RD, LAKE CITY, TN - REC:07:32 DISP:07:38 RESP: ONSC: INSRV:09:23 TRK#:213951\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 410 ANDYS RIDGE RD, LAKE CITY, TN - REC:07:32 DISP:07:38 RESP: ONSC: INSRV:09:23 TRK#:213951");

    doTest("T34",
        "[E911] RESC - OLD EDGEMOOR LN @ S DOGWOOD RD CLINTON, TN - INJURY-LEG - 213960\n",
        "SRC:RESC",
        "CALL:INJURY-LEG",
        "ADDR:OLD EDGEMOOR LN & S DOGWOOD RD",
        "CITY:CLINTON",
        "ID:213960");

    doTest("T35",
        "[E911] EMS Assist - OLD EDGEMOOR LN @ S DOGWOOD RD, CLINTON, TN - REC:10:03 DISP:10:07 RESP: ONSC: INSRV:10:18 TRK#:213962\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - OLD EDGEMOOR LN @ S DOGWOOD RD, CLINTON, TN - REC:10:03 DISP:10:07 RESP: ONSC: INSRV:10:18 TRK#:213962");

    doTest("T36",
        "[E911] RESC - NORRIS FRWY @ ECHO VALLEY RD LAKE CITY, TN - MVA - 213988\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:NORRIS FRWY & ECHO VALLEY RD",
        "CITY:LAKE CITY",
        "ID:213988");

    doTest("T37",
        "[E911] EMS Assist - NORRIS FRWY @ ECHO VALLEY RD, LAKE CITY, TN - REC:17:07 DISP:17:10 RESP: ONSC: INSRV:17:24 TRK#:213989\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - NORRIS FRWY @ ECHO VALLEY RD, LAKE CITY, TN - REC:17:07 DISP:17:10 RESP: ONSC: INSRV:17:24 TRK#:213989");

    doTest("T38",
        "[E911] RESC FIRST RESP - 103 OFFUTT RD CLINTON, TN - FALL INJURIES - 214008\n",
        "SRC:RESC FIRST RESP",
        "CALL:FALL INJURIES",
        "ADDR:103 OFFUTT RD",
        "CITY:CLINTON",
        "ID:214008");

    doTest("T39",
        "[E911] EMS Assist - 103 OFFUTT RD, CLINTON, TN - REC:23:57 DISP:00:00 RESP: ONSC: INSRV:00:09 TRK#:214008\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 103 OFFUTT RD, CLINTON, TN - REC:23:57 DISP:00:00 RESP: ONSC: INSRV:00:09 TRK#:214008");

    doTest("T40",
        "[E911] RESC - I 75 SB BETWEEN 129 AND 128 OAK RIDGE, TN - MVA - 214010\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:I 75 SB BETWEEN 129 AND 128",
        "MADDR:I 75 BETWEEN 129 AND 128",
        "CITY:OAK RIDGE",
        "ID:214010");

    doTest("T41",
        "[E911] EMS Assist - I 75 SB BETWEEN 129 AND 128, OAK RIDGE, TN - REC:01:09 DISP:01:13 RESP:01:17 ONSC: INSRV:01:26 TRK#:214012\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - I 75 SB BETWEEN 129 AND 128, OAK RIDGE, TN - REC:01:09 DISP:01:13 RESP:01:17 ONSC: INSRV:01:26 TRK#:214012");

    doTest("T42",
        "[E911] RESC - 2676 NORRIS FRWY ANDERSONVILLE, TN - MVA - 214031\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:2676 NORRIS FRWY",
        "CITY:ANDERSONVILLE",
        "ID:214031");

    doTest("T43",
        "[E911] MVA - Injury - 2676 NORRIS FRWY, ANDERSONVILLE, TN - REC:16:06 DISP:16:07 RESP:16:09 ONSC: INSRV:17:33 TRK#:214033\n",
        "CALL:RUN REPORT",
        "PLACE:MVA - Injury - 2676 NORRIS FRWY, ANDERSONVILLE, TN - REC:16:06 DISP:16:07 RESP:16:09 ONSC: INSRV:17:33 TRK#:214033");

    doTest("T44",
        "[E911] RESC - 1088 NEW CLEAR BRANCH RD  LAKE CITY, TN - MVA - 214037\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:1088 NEW CLEAR BRANCH RD",
        "CITY:LAKE CITY",
        "ID:214037");

    doTest("T45",
        "[E911] EMS Assist - 1088 NEW CLEAR BRANCH RD , LAKE CITY, TN - REC:19:47 DISP:19:49 RESP:19:51 ONSC:20:04 INSRV:20:22 TRK#:214038\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 1088 NEW CLEAR BRANCH RD , LAKE CITY, TN - REC:19:47 DISP:19:49 RESP:19:51 ONSC:20:04 INSRV:20:22 TRK#:214038");

    doTest("T46",
        "[E911] RESC FIRST RESP - 8100 YOUNT RD LOT 42  CLINTON, TN - PAIN-CHEST - 214048\n",
        "SRC:RESC FIRST RESP",
        "CALL:PAIN-CHEST",
        "ADDR:8100 YOUNT RD",
        "APT:42",
        "CITY:CLINTON",
        "ID:214048");

    doTest("T47",
        "[E911] EMS Assist - 8100 YOUNT RD LOT 42 , CLINTON, TN - REC:23:22 DISP:23:24 RESP: ONSC: INSRV:00:01 TRK#:214048\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 8100 YOUNT RD LOT 42 , CLINTON, TN - REC:23:22 DISP:23:24 RESP: ONSC: INSRV:00:01 TRK#:214048");

    doTest("T48",
        "[E911] RESC FIRST RESP - 205 LOY LN  POWELL, TN - STROKE - 214064\n",
        "SRC:RESC FIRST RESP",
        "CALL:STROKE",
        "ADDR:205 LOY LN",
        "CITY:POWELL",
        "ID:214064");

    doTest("T49",
        "[E911] RESC FIRST RESP - 111 JM WHITE LN  CLINTON, TN - FALL INJURIES - 214067\n",
        "SRC:RESC FIRST RESP",
        "CALL:FALL INJURIES",
        "ADDR:111 JM WHITE LN",
        "CITY:CLINTON",
        "ID:214067");

    doTest("T50",
        "[E911] EMS Assist - 205 LOY LN , POWELL, TN - REC:06:06 DISP:06:07 RESP: ONSC: INSRV:06:32 TRK#:214064\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 205 LOY LN , POWELL, TN - REC:06:06 DISP:06:07 RESP: ONSC: INSRV:06:32 TRK#:214064");

    doTest("T51",
        "[E911] EMS Assist - 111 JM WHITE LN , CLINTON, TN - REC:06:16 DISP:06:18 RESP: ONSC: INSRV:07:11 TRK#:214067\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 111 JM WHITE LN , CLINTON, TN - REC:06:16 DISP:06:18 RESP: ONSC: INSRV:07:11 TRK#:214067");

    doTest("T52",
        "[E911] RESC FIRST RESP - 202 MILL LN CLINTON, TN - DIFFICULTY  BREATHING - 214074\n",
        "SRC:RESC FIRST RESP",
        "CALL:DIFFICULTY  BREATHING",
        "ADDR:202 MILL LN",
        "CITY:CLINTON",
        "ID:214074");

    doTest("T53",
        "[E911] EMS Assist - 202 MILL LN, CLINTON, TN - REC:08:03 DISP:08:04 RESP: ONSC: INSRV:08:42 TRK#:214074\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 202 MILL LN, CLINTON, TN - REC:08:03 DISP:08:04 RESP: ONSC: INSRV:08:42 TRK#:214074");

    doTest("T54",
        "[E911] RESC FIRST RESP - 221 SATELLITE RD POWELL, TN - DIFFICULTY  BREATHING - 214235\n",
        "SRC:RESC FIRST RESP",
        "CALL:DIFFICULTY  BREATHING",
        "ADDR:221 SATELLITE RD",
        "CITY:POWELL",
        "ID:214235");

    doTest("T55",
        "[E911] RESC FIRST RESP - 107 WEST LN POWELL, TN - FALL INJURIES - 214238\n",
        "SRC:RESC FIRST RESP",
        "CALL:FALL INJURIES",
        "ADDR:107 WEST LN",
        "CITY:POWELL",
        "ID:214238");

    doTest("T56",
        "[E911] EMS Assist - 221 SATELLITE RD, POWELL, TN - REC:18:07 DISP:18:09 RESP: ONSC: INSRV:18:30 TRK#:214235\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 221 SATELLITE RD, POWELL, TN - REC:18:07 DISP:18:09 RESP: ONSC: INSRV:18:30 TRK#:214235");

    doTest("T57",
        "[E911] EMS Assist - 107 WEST LN, POWELL, TN - REC:18:12 DISP:18:15 RESP: ONSC: INSRV:18:37 TRK#:214239\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 107 WEST LN, POWELL, TN - REC:18:12 DISP:18:15 RESP: ONSC: INSRV:18:37 TRK#:214239");

    doTest("T58",
        "[E911] RESC - NEW HENDERSON RD POWELL, TN - MVA - 214248\n",
        "SRC:RESC",
        "CALL:MVA",
        "ADDR:NEW HENDERSON RD",
        "CITY:POWELL",
        "ID:214248");

    doTest("T59",
        "[E911] EMS Assist - NEW HENDERSON RD, POWELL, TN - REC:20:11 DISP:20:14 RESP: ONSC: INSRV:21:04 TRK#:214250\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - NEW HENDERSON RD, POWELL, TN - REC:20:11 DISP:20:14 RESP: ONSC: INSRV:21:04 TRK#:214250");

    doTest("T60",
        "[E911] RESC FIRST RESP - 318 BRANCH LANE CLINTON, TN - UNRESPONSIVE - 214270\n",
        "SRC:RESC FIRST RESP",
        "CALL:UNRESPONSIVE",
        "ADDR:318 BRANCH LANE",
        "CITY:CLINTON",
        "ID:214270");

    doTest("T61",
        "[E911] EMS Assist - 318 BRANCH LANE, CLINTON, TN - REC:08:09 DISP:08:10 RESP: ONSC: INSRV:08:59 TRK#:214270\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 318 BRANCH LANE, CLINTON, TN - REC:08:09 DISP:08:10 RESP: ONSC: INSRV:08:59 TRK#:214270");

    doTest("T62",
        "[E911] RESC FIRST RESP - 1951 OLD LAKE CITY HWY CLINTON, TN - MEDICAL ALARM - 214308\n",
        "SRC:RESC FIRST RESP",
        "CALL:MEDICAL ALARM",
        "ADDR:1951 OLD LAKE CITY HWY",
        "CITY:CLINTON",
        "ID:214308");

    doTest("T63",
        "[E911] Lift Assist - 114 OAK HILL RD , CLINTON, TN\n",
        "CALL:Lift Assist",
        "ADDR:114 OAK HILL RD",
        "CITY:CLINTON");

    doTest("T64",
        "[E911] EMS Assist - 1951 OLD LAKE CITY HWY, CLINTON, TN - REC:11:47 DISP:11:49 RESP: ONSC: INSRV:12:06 TRK#:214308\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 1951 OLD LAKE CITY HWY, CLINTON, TN - REC:11:47 DISP:11:49 RESP: ONSC: INSRV:12:06 TRK#:214308");

    doTest("T65",
        "[E911] RESC FIRST RESP - 822 PARK LANE ANDERSONVILLE, TN - SEIZURES - 214319\n",
        "SRC:RESC FIRST RESP",
        "CALL:SEIZURES",
        "ADDR:822 PARK LANE",
        "CITY:ANDERSONVILLE",
        "ID:214319");

    doTest("T66",
        "[E911] RESC FIRST RESP - 443 LEINART LANE  CLINTON, TN - FALL INJURIES - 214324\n",
        "SRC:RESC FIRST RESP",
        "CALL:FALL INJURIES",
        "ADDR:443 LEINART LANE",
        "CITY:CLINTON",
        "ID:214324");

    doTest("T67",
        "[E911] EMS Assist - 822 PARK LANE, ANDERSONVILLE, TN - REC:12:16 DISP:12:16 RESP: ONSC: INSRV:13:09 TRK#:214319\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 822 PARK LANE, ANDERSONVILLE, TN - REC:12:16 DISP:12:16 RESP: ONSC: INSRV:13:09 TRK#:214319");

    doTest("T68",
        "[E911] EMS Assist - 443 LEINART LANE , CLINTON, TN - REC:13:04 DISP:13:05 RESP: ONSC: INSRV:13:19 TRK#:214324\n",
        "CALL:RUN REPORT",
        "PLACE:EMS Assist - 443 LEINART LANE , CLINTON, TN - REC:13:04 DISP:13:05 RESP: ONSC: INSRV:13:19 TRK#:214324");
    
  }
  

  public static void main(String[] args) {
    new TNAndersonCountyParserTest().generateTests("T30");
  }
}
