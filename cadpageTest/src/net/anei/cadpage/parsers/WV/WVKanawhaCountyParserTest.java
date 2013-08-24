package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kanawha County, WV
Contact: support@active911.com
Sender: METRO911@metro911.org
(Message Forwarded by PageGate)  FIRE ALARM reported at 95 RHL BLVD in SOUTH CHARLESTON on 02/10/12 15:00
(Message Forwarded by PageGate)  DECREASED LOC (SEMI-UNRESPONSIVE) reported at 2700 MOUNTAINEER BLVD in SOUTH CHARLESTON on 02/10/12 18:43
(Message Forwarded by PageGate)  SHORTNESS OF BREATH reported at 5218 1/2 INDIANA ST in SOUTH CHARLESTON on 02/10/12 19:03
(Message Forwarded by PageGate)  FIRE ALARM reported at 3 EAGLE DR in SOUTH CHARLESTON on 02/11/12 12:28
(Message Forwarded by PageGate)  AUTO ACCIDENT WITH INJURIES reported at 56 I64 EAST in SOUTH CHARLESTON on 02/11/12 07:57
(Message Forwarded by PageGate)  CARDIAC ARREST reported at 24 MACCORKLE AVE in SOUTH CHARLESTON on 02/11/12 11:56
(Message Forwarded by PageGate)  CHEST PAINS reported at 4610 YOUNG ST in SOUTH CHARLESTON on 02/10/12 22:35
(Message Forwarded by PageGate)  DOMESTIC WITH INJURIES reported at 4991 COLONIAL PARK DR in SOUTH CHARLESTON on 02/11/12 20:08
(Message Forwarded by PageGate)  FIRE ALARM reported at 331 SOUTHRIDGE BLVD in CHARLESTON on 02/12/12 16:36
(Message Forwarded by PageGate)  HAZARDOUS MATERIALS INCIDENT reported at 46 RHL BLVD in SOUTH CHARLESTON on 02/17/12 09:13
(Message Forwarded by PageGate)  UNRESPONSIVE PATIENT reported at 1232 THOMAS RD in SOUTH CHARLESTON on 02/17/12 10:19
(Message Forwarded by PageGate)  SHORTNESS OF BREATH reported at 4718 KANAWHA AVE in SOUTH CHARLESTON on 02/15/12 07:20
(Message Forwarded by PageGate)  DIABETIC PATIENT reported at 2905 MACON ST in SOUTH CHARLESTON on 02/15/12 10:45
(Message Forwarded by PageGate)  INJURED PERSON reported at 15 RIVER WALK MALL in SOUTH CHARLESTON on 02/15/12 11:57
(Message Forwarded by PageGate)  UNRESPONSIVE PATIENT reported at 46 RHL BLVD in SOUTH CHARLESTON on 02/17/12 16:10

Contact: Robert Carpenter <robbie2017@gmail.com>
Sender: Metro911@metro911.org
Metro911@metro911.org Msg: Metro911:HIGH WATER / FLOODING ISSUES reported at NEW GOFF MOUNTAIN RD // 1ST AVE S in CROSS LANES on 05/05/12 13:30

Contact: Active911
Agency name: Sissonville VFD
Location: Sissonville, WV, United States

(Metro CAD Alert) SERVICE CALL (FIRE) reported at BAILEY DR in SISSONVILLE ( ) on 08/21/13 13:32 Call # 814
(Metro CAD Alert) VEHICLE FIRE reported at 1900 MARTINS BRANCH RD in SISSONVILLE ( ) on 08/20/13 16:47 Call # 70
(Metro CAD Alert) ACCIDENT - w/INJURIES reported at 112 I77N in SISSONVILLE ( ) on 08/20/13 16:44 Call # 67
(METRO CAD ALERT) VEHICLE FIRE reported at 111 I77N in SISSONVILLE ( TUPPERS CREEK RD EXIT NB) on 08/19/13 08:19 Call # 724
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 106 I77N in SISSONVILLE ( EDENS FORK RD EXIT NB) on 08/16/13 17:35 Call # 876
(METRO CAD ALERT) FALLS reported at 548 JENKINS DR in SISSONVILLE ( ) on 08/14/13 14:24 Call # 63
(METRO CAD ALERT) ASSIST FIRE reported at 4579 RICH FORK RD in SISSONVILLE ( ) on 08/13/13 14:17 Call # 191
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 117 I77N in SISSONVILLE ( ) on 08/13/13 14:17 Call # 190
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77S in SISSONVILLE ( TUPPERS CREEK RD EXIT SB ) on 08/10/13 16:23 Call Number: 131
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at ARCHIBALD DR SISSONVILLE DR in SISSONVILLE (  ) on 08/10/13 08:26 Call Number: 800
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 106 I77N in SISSONVILLE ( EDENS FORK RD EXIT NB ) on 08/10/13 06:09 Call Number: 747
(METRO CAD ALERT) STRUCTURE FIRE reported at 7010 SISSONVILLE DR in SISSONVILLE (  ) on 08/10/13 04:24 Call Number: 732
(METRO CAD ALERT) ACCIDENT - NO INJURIES reported at 116 I77N in SISSONVILLE ( HAINES BRANCH RD EXIT NB ) on 08/09/13 22:01 Call Number: 526
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 1962 EDENS FORK RD in SISSONVILLE ( CHEVRON ONE STOP EDENS FORK ) on 08/09/13 07:46 Call Number: 900
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77N in SISSONVILLE ( TUPPERS CREEK RD EXIT NB ) on 08/08/13 16:33 Call Number: 492
(METRO CAD ALERT) SERVICE CALL (FIRE) reported at 856 HAPPY HOLLOW RD in SISSONVILLE (  ) on 08/07/13 19:43 Call Number: 847
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77S in SISSONVILLE ( TUPPERS CREEK RD EXIT SB ) on 08/07/13 05:41 Call Number: 177
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at SISSONVILLE DR @ GODWIN PUMPS in SISSONVILLE (  ) on 08/06/13 20:37 Call Number: 929
(METRO CAD ALERT) UNRESPONSIVE reported at GRAPEVINE RD in SISSONVILLE (  ) on 08/06/13 19:01 Call Number: 850
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 4873 SISSONVILLE DR in SISSONVILLE (  ) on 08/06/13 15:56 Call Number: 709

Contact: Active911
Agency name: Tyler Mountain Volunteer Fire Department
Location: Cross lanes, WV, United States
Sender: SIREN@metro911.org

(METRO CAD ALERT) INVESTIGATION FIRE reported at 498 NEW GOFF MOUNTAIN RD in CROSS LANES ( CAROLINA FREIGHT ) on 03/06/13 11:57 Call Number: 573
(METRO CAD ALERT) VEHICLE FIRE reported at 2815 FAIRLAWN AVE in DUNBAR ( RYDER TRUCK RENTAL INSTITUTE ) on 03/06/13 00:12 Call Number: 249
(METRO CAD ALERT) VEHICLE FIRE reported at DAIRY RD & DOC BAILEY RD in CROSS LANES (  ) on 03/05/13 19:20 Call Number: 86
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 47 I64W in NITRO ( CROSS LANES EXIT WB ) on 03/05/13 17:48 Call Number: 16
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at DOC BAILEY RD BIG TYLER RD in CROSS LANES (  ) on 03/05/13 12:33 Call Number: 689
(METRO CAD ALERT) INVESTIGATION FIRE reported at 109 LAKE SHORE DR in CROSS LANES (  ) on 03/04/13 19:47 Call Number: 165
(METRO CAD ALERT) ALARM FIRE reported at 5525 BIG TYLER RD in CROSS LANES ( CROSS LANES ELEMENTARY SCHOOL ) on 03/04/13 15:51 Call Number: 971

Agency name: Sissonville VFD
Location: Sissonville, WV, United States
Contact: Active911
Sender: SIREN@metro911.org

(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 1068 WOLF PEN DR in SISSONVILLE ( 1589C WOLF PEN DR ) on 03/21/13 23:01 Call Number: 100
(METRO CAD ALERT) BRUSH FIRE reported at 6800 SISSONVILLE DR in SISSONVILLE ( LONG & FISHER FUNERAL HOME SISSONVILLE ) on 03/21/13 21:04 Call Number: 34
(METRO CAD ALERT) BRUSH FIRE reported at 1888 KELLYS CREEK RD in SISSONVILLE (  ) on 03/20/13 19:24 Call Number: 207
(METRO CAD ALERT) BRUSH FIRE reported at 140 PHILLIPS RD in SISSONVILLE (  ) on 03/20/13 17:36 Call Number: 115
(METRO CAD ALERT) EXPLOSION reported at 13426 DERRICKS CREEK RD in SISSONVILLE (  ) on 03/19/13 18:46 Call Number: 231
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 3232 POCA RIVER RD in SISSONVILLE (  ) on 03/17/13 20:58 Call Number: 821
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 117 I77S in SISSONVILLE (  ) on 03/17/13 19:20 Call Number: 755
(METRO CAD ALERT) ACCIDENT - NO EMS reported at 3600 KELLYS CREEK RD in SISSONVILLE (  ) on 03/17/13 19:02 Call Number: 742
(METRO CAD ALERT) ACCIDENT - NO INJURIES reported at 114 I77S in SISSONVILLE ( SISSONVILLE/POCATALICO EXIT SB ) on 03/17/13 18:38 Call Number: 729
(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 116 I77S in SISSONVILLE ( HAINES BRANCH RD EXIT SB ) on 03/17/13 18:19 Call Number: 714

*/

public class WVKanawhaCountyParserTest extends BaseParserTest {
  
  public WVKanawhaCountyParserTest() {
    setParser(new WVKanawhaCountyParser(), "KANAWHA COUNTY", "WV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Message Forwarded by PageGate)  FIRE ALARM reported at 95 RHL BLVD in SOUTH CHARLESTON on 02/10/12 15:00",
        "CALL:FIRE ALARM",
        "ADDR:95 RHL BLVD",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/10/12",
        "TIME:15:00");

    doTest("T2",
        "(Message Forwarded by PageGate)  DECREASED LOC (SEMI-UNRESPONSIVE) reported at 2700 MOUNTAINEER BLVD in SOUTH CHARLESTON on 02/10/12 18:43",
        "CALL:DECREASED LOC (SEMI-UNRESPONSIVE)",
        "ADDR:2700 MOUNTAINEER BLVD",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/10/12",
        "TIME:18:43");

    doTest("T3",
        "(Message Forwarded by PageGate)  SHORTNESS OF BREATH reported at 5218 1/2 INDIANA ST in SOUTH CHARLESTON on 02/10/12 19:03",
        "CALL:SHORTNESS OF BREATH",
        "ADDR:5218 1/2 INDIANA ST",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/10/12",
        "TIME:19:03");

    doTest("T4",
        "(Message Forwarded by PageGate)  FIRE ALARM reported at 3 EAGLE DR in SOUTH CHARLESTON on 02/11/12 12:28",
        "CALL:FIRE ALARM",
        "ADDR:3 EAGLE DR",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/11/12",
        "TIME:12:28");

    doTest("T5",
        "(Message Forwarded by PageGate)  AUTO ACCIDENT WITH INJURIES reported at 56 I64 EAST in SOUTH CHARLESTON on 02/11/12 07:57",
        "CALL:AUTO ACCIDENT WITH INJURIES",
        "ADDR:56 I64 EAST",
        "MADDR:56 I 64 EAST",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/11/12",
        "TIME:07:57");

    doTest("T6",
        "(Message Forwarded by PageGate)  CARDIAC ARREST reported at 24 MACCORKLE AVE in SOUTH CHARLESTON on 02/11/12 11:56",
        "CALL:CARDIAC ARREST",
        "ADDR:24 MACCORKLE AVE",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/11/12",
        "TIME:11:56");

    doTest("T7",
        "(Message Forwarded by PageGate)  CHEST PAINS reported at 4610 YOUNG ST in SOUTH CHARLESTON on 02/10/12 22:35",
        "CALL:CHEST PAINS",
        "ADDR:4610 YOUNG ST",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/10/12",
        "TIME:22:35");

    doTest("T8",
        "(Message Forwarded by PageGate)  DOMESTIC WITH INJURIES reported at 4991 COLONIAL PARK DR in SOUTH CHARLESTON on 02/11/12 20:08",
        "CALL:DOMESTIC WITH INJURIES",
        "ADDR:4991 COLONIAL PARK DR",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/11/12",
        "TIME:20:08");

    doTest("T9",
        "(Message Forwarded by PageGate)  FIRE ALARM reported at 331 SOUTHRIDGE BLVD in CHARLESTON on 02/12/12 16:36",
        "CALL:FIRE ALARM",
        "ADDR:331 SOUTHRIDGE BLVD",
        "CITY:CHARLESTON",
        "DATE:02/12/12",
        "TIME:16:36");

    doTest("T10",
        "(Message Forwarded by PageGate)  HAZARDOUS MATERIALS INCIDENT reported at 46 RHL BLVD in SOUTH CHARLESTON on 02/17/12 09:13",
        "CALL:HAZARDOUS MATERIALS INCIDENT",
        "ADDR:46 RHL BLVD",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/17/12",
        "TIME:09:13");

    doTest("T11",
        "(Message Forwarded by PageGate)  UNRESPONSIVE PATIENT reported at 1232 THOMAS RD in SOUTH CHARLESTON on 02/17/12 10:19",
        "CALL:UNRESPONSIVE PATIENT",
        "ADDR:1232 THOMAS RD",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/17/12",
        "TIME:10:19");

    doTest("T12",
        "(Message Forwarded by PageGate)  SHORTNESS OF BREATH reported at 4718 KANAWHA AVE in SOUTH CHARLESTON on 02/15/12 07:20",
        "CALL:SHORTNESS OF BREATH",
        "ADDR:4718 KANAWHA AVE",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/15/12",
        "TIME:07:20");

    doTest("T13",
        "(Message Forwarded by PageGate)  DIABETIC PATIENT reported at 2905 MACON ST in SOUTH CHARLESTON on 02/15/12 10:45",
        "CALL:DIABETIC PATIENT",
        "ADDR:2905 MACON ST",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/15/12",
        "TIME:10:45");

    doTest("T14",
        "(Message Forwarded by PageGate)  INJURED PERSON reported at 15 RIVER WALK MALL in SOUTH CHARLESTON on 02/15/12 11:57",
        "CALL:INJURED PERSON",
        "ADDR:15 RIVER WALK MALL",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/15/12",
        "TIME:11:57");

    doTest("T15",
        "(Message Forwarded by PageGate)  UNRESPONSIVE PATIENT reported at 46 RHL BLVD in SOUTH CHARLESTON on 02/17/12 16:10",
        "CALL:UNRESPONSIVE PATIENT",
        "ADDR:46 RHL BLVD",
        "CITY:SOUTH CHARLESTON",
        "DATE:02/17/12",
        "TIME:16:10");
    
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Metro911@metro911.org Msg: Metro911:HIGH WATER / FLOODING ISSUES reported at NEW GOFF MOUNTAIN RD // 1ST AVE S in CROSS LANES on 05/05/12 13:30",
        "CALL:HIGH WATER / FLOODING ISSUES",
        "ADDR:NEW GOFF MOUNTAIN RD & 1ST AVE S",
        "CITY:CROSS LANES",
        "DATE:05/05/12",
        "TIME:13:30");

  }
  
  @Test
  public void testSissonvilleFire() {

    doTest("T1",
        "(Metro CAD Alert) SERVICE CALL (FIRE) reported at BAILEY DR in SISSONVILLE ( ) on 08/21/13 13:32 Call # 814",
        "CALL:SERVICE CALL (FIRE)",
        "ADDR:BAILEY DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/21/13",
        "TIME:13:32",
        "ID:814");

    doTest("T2",
        "(Metro CAD Alert) VEHICLE FIRE reported at 1900 MARTINS BRANCH RD in SISSONVILLE ( ) on 08/20/13 16:47 Call # 70",
        "CALL:VEHICLE FIRE",
        "ADDR:1900 MARTINS BRANCH RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/20/13",
        "TIME:16:47",
        "ID:70");

    doTest("T3",
        "(Metro CAD Alert) ACCIDENT - w/INJURIES reported at 112 I77N in SISSONVILLE ( ) on 08/20/13 16:44 Call # 67",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:112 I-77N",
        "MADDR:112 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/20/13",
        "TIME:16:44",
        "ID:67");

    doTest("T4",
        "(METRO CAD ALERT) VEHICLE FIRE reported at 111 I77N in SISSONVILLE ( TUPPERS CREEK RD EXIT NB) on 08/19/13 08:19 Call # 724",
        "CALL:VEHICLE FIRE",
        "ADDR:111 I-77N",
        "MADDR:111 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - TUPPERS CREEK RD EXIT NB",
        "DATE:08/19/13",
        "TIME:08:19",
        "ID:724");

    doTest("T5",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 106 I77N in SISSONVILLE ( EDENS FORK RD EXIT NB) on 08/16/13 17:35 Call # 876",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:106 I-77N",
        "MADDR:106 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - EDENS FORK RD EXIT NB",
        "DATE:08/16/13",
        "TIME:17:35",
        "ID:876");

    doTest("T6",
        "(METRO CAD ALERT) FALLS reported at 548 JENKINS DR in SISSONVILLE ( ) on 08/14/13 14:24 Call # 63",
        "CALL:FALLS",
        "ADDR:548 JENKINS DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/14/13",
        "TIME:14:24",
        "ID:63");

    doTest("T7",
        "(METRO CAD ALERT) ASSIST FIRE reported at 4579 RICH FORK RD in SISSONVILLE ( ) on 08/13/13 14:17 Call # 191",
        "CALL:ASSIST FIRE",
        "ADDR:4579 RICH FORK RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/13/13",
        "TIME:14:17",
        "ID:191");

    doTest("T8",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 117 I77N in SISSONVILLE ( ) on 08/13/13 14:17 Call # 190",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:117 I-77N",
        "MADDR:117 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/13/13",
        "TIME:14:17",
        "ID:190");

    doTest("T9",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77S in SISSONVILLE ( TUPPERS CREEK RD EXIT SB ) on 08/10/13 16:23 Call Number: 131",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:111 I-77S",
        "MADDR:111 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - TUPPERS CREEK RD EXIT SB",
        "DATE:08/10/13",
        "TIME:16:23",
        "ID:131");

    doTest("T10",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at ARCHIBALD DR SISSONVILLE DR in SISSONVILLE (  ) on 08/10/13 08:26 Call Number: 800",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:ARCHIBALD DR & SISSONVILLE DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/10/13",
        "TIME:08:26",
        "ID:800");

    doTest("T11",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 106 I77N in SISSONVILLE ( EDENS FORK RD EXIT NB ) on 08/10/13 06:09 Call Number: 747",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:106 I-77N",
        "MADDR:106 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - EDENS FORK RD EXIT NB",
        "DATE:08/10/13",
        "TIME:06:09",
        "ID:747");

    doTest("T12",
        "(METRO CAD ALERT) STRUCTURE FIRE reported at 7010 SISSONVILLE DR in SISSONVILLE (  ) on 08/10/13 04:24 Call Number: 732",
        "CALL:STRUCTURE FIRE",
        "ADDR:7010 SISSONVILLE DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/10/13",
        "TIME:04:24",
        "ID:732");

    doTest("T13",
        "(METRO CAD ALERT) ACCIDENT - NO INJURIES reported at 116 I77N in SISSONVILLE ( HAINES BRANCH RD EXIT NB ) on 08/09/13 22:01 Call Number: 526",
        "CALL:ACCIDENT - NO INJURIES",
        "ADDR:116 I-77N",
        "MADDR:116 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - HAINES BRANCH RD EXIT NB",
        "DATE:08/09/13",
        "TIME:22:01",
        "ID:526");

    doTest("T14",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 1962 EDENS FORK RD in SISSONVILLE ( CHEVRON ONE STOP EDENS FORK ) on 08/09/13 07:46 Call Number: 900",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:1962 EDENS FORK RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - CHEVRON ONE STOP EDENS FORK",
        "DATE:08/09/13",
        "TIME:07:46",
        "ID:900");

    doTest("T15",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77N in SISSONVILLE ( TUPPERS CREEK RD EXIT NB ) on 08/08/13 16:33 Call Number: 492",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:111 I-77N",
        "MADDR:111 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - TUPPERS CREEK RD EXIT NB",
        "DATE:08/08/13",
        "TIME:16:33",
        "ID:492");

    doTest("T16",
        "(METRO CAD ALERT) SERVICE CALL (FIRE) reported at 856 HAPPY HOLLOW RD in SISSONVILLE (  ) on 08/07/13 19:43 Call Number: 847",
        "CALL:SERVICE CALL (FIRE)",
        "ADDR:856 HAPPY HOLLOW RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/07/13",
        "TIME:19:43",
        "ID:847");

    doTest("T17",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 111 I77S in SISSONVILLE ( TUPPERS CREEK RD EXIT SB ) on 08/07/13 05:41 Call Number: 177",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:111 I-77S",
        "MADDR:111 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - TUPPERS CREEK RD EXIT SB",
        "DATE:08/07/13",
        "TIME:05:41",
        "ID:177");

    doTest("T18",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at SISSONVILLE DR @ GODWIN PUMPS in SISSONVILLE (  ) on 08/06/13 20:37 Call Number: 929",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:SISSONVILLE DR",
        "PLACE:GODWIN PUMPS",
        "CITY:CHARLESTON",
        "DATE:08/06/13",
        "TIME:20:37",
        "ID:929");

    doTest("T19",
        "(METRO CAD ALERT) UNRESPONSIVE reported at GRAPEVINE RD in SISSONVILLE (  ) on 08/06/13 19:01 Call Number: 850",
        "CALL:UNRESPONSIVE",
        "ADDR:GRAPEVINE RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/06/13",
        "TIME:19:01",
        "ID:850");

    doTest("T20",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 4873 SISSONVILLE DR in SISSONVILLE (  ) on 08/06/13 15:56 Call Number: 709",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:4873 SISSONVILLE DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:08/06/13",
        "TIME:15:56",
        "ID:709");

  }
  
  @Test
  public void testTylerMountainFire() {

    doTest("T1",
        "(METRO CAD ALERT) INVESTIGATION FIRE reported at 498 NEW GOFF MOUNTAIN RD in CROSS LANES ( CAROLINA FREIGHT ) on 03/06/13 11:57 Call Number: 573",
        "CALL:INVESTIGATION FIRE",
        "ADDR:498 NEW GOFF MOUNTAIN RD",
        "CITY:CROSS LANES",
        "PLACE:CAROLINA FREIGHT",
        "DATE:03/06/13",
        "TIME:11:57",
        "ID:573");

    doTest("T2",
        "(METRO CAD ALERT) VEHICLE FIRE reported at 2815 FAIRLAWN AVE in DUNBAR ( RYDER TRUCK RENTAL INSTITUTE ) on 03/06/13 00:12 Call Number: 249",
        "CALL:VEHICLE FIRE",
        "ADDR:2815 FAIRLAWN AVE",
        "CITY:DUNBAR",
        "PLACE:RYDER TRUCK RENTAL INSTITUTE",
        "DATE:03/06/13",
        "TIME:00:12",
        "ID:249");

    doTest("T3",
        "(METRO CAD ALERT) VEHICLE FIRE reported at DAIRY RD & DOC BAILEY RD in CROSS LANES (  ) on 03/05/13 19:20 Call Number: 86",
        "CALL:VEHICLE FIRE",
        "ADDR:DAIRY RD & DOC BAILEY RD",
        "CITY:CROSS LANES",
        "DATE:03/05/13",
        "TIME:19:20",
        "ID:86");

    doTest("T4",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 47 I64W in NITRO ( CROSS LANES EXIT WB ) on 03/05/13 17:48 Call Number: 16",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:47 I-64W",
        "MADDR:47 I 64",
        "CITY:NITRO",
        "PLACE:CROSS LANES EXIT WB",
        "DATE:03/05/13",
        "TIME:17:48",
        "ID:16");

    doTest("T5",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at DOC BAILEY RD BIG TYLER RD in CROSS LANES (  ) on 03/05/13 12:33 Call Number: 689",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:DOC BAILEY RD & BIG TYLER RD",
        "CITY:CROSS LANES",
        "DATE:03/05/13",
        "TIME:12:33",
        "ID:689");

    doTest("T6",
        "(METRO CAD ALERT) INVESTIGATION FIRE reported at 109 LAKE SHORE DR in CROSS LANES (  ) on 03/04/13 19:47 Call Number: 165",
        "CALL:INVESTIGATION FIRE",
        "ADDR:109 LAKE SHORE DR",
        "CITY:CROSS LANES",
        "DATE:03/04/13",
        "TIME:19:47",
        "ID:165");

    doTest("T7",
        "(METRO CAD ALERT) ALARM FIRE reported at 5525 BIG TYLER RD in CROSS LANES ( CROSS LANES ELEMENTARY SCHOOL ) on 03/04/13 15:51 Call Number: 971",
        "CALL:ALARM FIRE",
        "ADDR:5525 BIG TYLER RD",
        "CITY:CROSS LANES",
        "PLACE:CROSS LANES ELEMENTARY SCHOOL",
        "DATE:03/04/13",
        "TIME:15:51",
        "ID:971");

  }
  
  @Test
  public void testSissonvilleFire2() {

    doTest("T1",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 1068 WOLF PEN DR in SISSONVILLE ( 1589C WOLF PEN DR ) on 03/21/13 23:01 Call Number: 100",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:1068 WOLF PEN DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - 1589C WOLF PEN DR",
        "DATE:03/21/13",
        "TIME:23:01",
        "ID:100");

    doTest("T2",
        "(METRO CAD ALERT) BRUSH FIRE reported at 6800 SISSONVILLE DR in SISSONVILLE ( LONG & FISHER FUNERAL HOME SISSONVILLE ) on 03/21/13 21:04 Call Number: 34",
        "CALL:BRUSH FIRE",
        "ADDR:6800 SISSONVILLE DR",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - LONG & FISHER FUNERAL HOME SISSONVILLE",
        "DATE:03/21/13",
        "TIME:21:04",
        "ID:34");

    doTest("T3",
        "(METRO CAD ALERT) BRUSH FIRE reported at 1888 KELLYS CREEK RD in SISSONVILLE (  ) on 03/20/13 19:24 Call Number: 207",
        "CALL:BRUSH FIRE",
        "ADDR:1888 KELLYS CREEK RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/20/13",
        "TIME:19:24",
        "ID:207");

    doTest("T4",
        "(METRO CAD ALERT) BRUSH FIRE reported at 140 PHILLIPS RD in SISSONVILLE (  ) on 03/20/13 17:36 Call Number: 115",
        "CALL:BRUSH FIRE",
        "ADDR:140 PHILLIPS RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/20/13",
        "TIME:17:36",
        "ID:115");

    doTest("T5",
        "(METRO CAD ALERT) EXPLOSION reported at 13426 DERRICKS CREEK RD in SISSONVILLE (  ) on 03/19/13 18:46 Call Number: 231",
        "CALL:EXPLOSION",
        "ADDR:13426 DERRICKS CREEK RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/19/13",
        "TIME:18:46",
        "ID:231");

    doTest("T6",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 3232 POCA RIVER RD in SISSONVILLE (  ) on 03/17/13 20:58 Call Number: 821",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:3232 POCA RIVER RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/17/13",
        "TIME:20:58",
        "ID:821");

    doTest("T7",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 117 I77S in SISSONVILLE (  ) on 03/17/13 19:20 Call Number: 755",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:117 I-77S",
        "MADDR:117 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/17/13",
        "TIME:19:20",
        "ID:755");

    doTest("T8",
        "(METRO CAD ALERT) ACCIDENT - NO EMS reported at 3600 KELLYS CREEK RD in SISSONVILLE (  ) on 03/17/13 19:02 Call Number: 742",
        "CALL:ACCIDENT - NO EMS",
        "ADDR:3600 KELLYS CREEK RD",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE",
        "DATE:03/17/13",
        "TIME:19:02",
        "ID:742");

    doTest("T9",
        "(METRO CAD ALERT) ACCIDENT - NO INJURIES reported at 114 I77S in SISSONVILLE ( SISSONVILLE/POCATALICO EXIT SB ) on 03/17/13 18:38 Call Number: 729",
        "CALL:ACCIDENT - NO INJURIES",
        "ADDR:114 I-77S",
        "MADDR:114 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - SISSONVILLE/POCATALICO EXIT SB",
        "DATE:03/17/13",
        "TIME:18:38",
        "ID:729");

    doTest("T10",
        "(METRO CAD ALERT) ACCIDENT - w/INJURIES reported at 116 I77S in SISSONVILLE ( HAINES BRANCH RD EXIT SB ) on 03/17/13 18:19 Call Number: 714",
        "CALL:ACCIDENT - w/INJURIES",
        "ADDR:116 I-77S",
        "MADDR:116 I 77",
        "CITY:CHARLESTON",
        "PLACE:SISSONVILLE - HAINES BRANCH RD EXIT SB",
        "DATE:03/17/13",
        "TIME:18:19",
        "ID:714");

  }

  
  public static void main(String[] args) {
    new WVKanawhaCountyParserTest().generateTests("T1");
  }
}