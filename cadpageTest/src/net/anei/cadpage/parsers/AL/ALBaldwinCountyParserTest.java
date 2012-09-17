package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.AL.ALBaldwinCountyParserTest;

import org.junit.Test;

/*
Baldwin County, AL
Contact: Josh Hines <josh36530@gmail.com>
Sender: cad@baldwin911.org

- E911 Notification - Elberta VFD - 05-20-12 13:43: Station STA31 dispatched to Incident ID 290161 (Stroke) at 25855 WILLOW RIDGE R
- E911 Notification - Elberta VFD - 05-21-12 15:35: Station STA31 dispatched to Incident ID 290600 (Fire - Grass) at 17305 JOE GOTTLER RD
- E911 Notification - Elberta VFD - 05-24-12 08:48: Station STA31 dispatched to Incident ID 291543 (Auto Accident) at 14850 87\n
- E911 Notification - Elberta VFD - 05-26-12 08:04: Station STA31 dispatched to Incident ID 292420 (Auto Accident) at US HWY 98 @ SANDY LN
- E911 Notification - Elberta VFD - 05-26-12 16:24: Station STA31 dispatched to Incident ID 292625 (Auto Accident) at HWY98 @ CORD9

Contact: Active911
Agency name: Daphne Fire Dept. Location: Daphne, AL 
Sender: messaging@iamresponding.com

(DA) 07-27-12 22:54: Station STA66 dispatched to Incident ID 318501 (Suicide) at 8764 DRIFTON CT
(DA) 07-28-12 01:58: Station STA66 dispatched to Incident ID 318559 (Chest Pain) at 29793 WOODROW LN
(DA) 07-28-12 13:44: Station STA66 dispatched to Incident ID 318716 (General Illness) at 131 RIDGEWOOD DR (0)
(DA) 07-28-12 14:11: Station STA66 dispatched to Incident ID 318728 (Auto Accident) at HWY181 NB I-10
(DA) 07-28-12 19:56: Station STA66 dispatched to Incident ID 318908 (Fire Alarm) at 29758 FREDERICK BLVD
(DA) 07-28-12 20:52: Station STA66 dispatched to Incident ID 318944 (General Illness) at 27642 HWY 98
(DA) 07-28-12 22:42: Station STA66 dispatched to Incident ID 318990 (Chest Pain) at MCDONALDS STATE HWY 181
(DA) 07-29-12 03:22: Station STA66 dispatched to Incident ID 319047 (Abdominal Pain) at 29960 SAINT SIMON ST
(DA) 07-29-12 06:52: Station STA66 dispatched to Incident ID 319067 (Unknown Medical) at 9020 ASHLEY CT (0)
(DA) 07-29-12 09:06: Station STA66 dispatched to Incident ID 319086 (Unconscious) at 200 PARMA DR
(DA) 07-29-12 11:38: Station STA66 dispatched to Incident ID 319128 (Fire Alarm) at 27642 US HWY 98
(DA) 07-29-12 14:03: Station STA66 dispatched to Incident ID 319179 (Stroke) at 28480 BAY CLIFF LN
(DA) 07-29-12 15:23: Station STA66 dispatched to Incident ID 319200 (Suicide Threat) at 8764 DRIFTON CT
(DA) 07-30-12 06:56: Station STA66 dispatched to Incident ID 319399 (Structure Fire) at PARK DR
(DA) 07-30-12 08:19: Station STA66 dispatched to Incident ID 319417 (Unconscious) at 27434 STRATFORD GLEN DR
(DA) 07-30-12 08:51: Station STA66 dispatched to Incident ID 319429 (Fall) at 29951 ST BARBARA ST
(DA) 07-30-12 10:21: Station STA66 dispatched to Incident ID 319457 (Suicide Threat) at 133 LAKE FRONT DR
(DA) 07-30-12 10:40: Station STA66 dispatched to Incident ID 319466 (Unknown Medical) at 27961 U S HWY 98
(DA) 07-30-12 11:26: Station STA66 dispatched to Incident ID 319479 (Auto Accident) at CO RD 64/ FRIENDSHIP RD
(DA) 07-30-12 11:53: Station STA66 dispatched to Incident ID 319486 (Bleeding) at 7411 REEDS LN
(DA) 07-30-12 13:12: Station STA66 dispatched to Incident ID 319521 (Fire - Grass) at I-10 WB J E OF EX35
(DA) 07-30-12 17:47: Station STA66 dispatched to Incident ID 319685 (Auto Accident) at I-10 EB EXIT RAMP AT EXIT 35
(DA) 07-30-12 19:44: Station STA66 dispatched to Incident ID 319730 (Bleeding) at 7878 PINE RUN
(DA) 07-30-12 20:34: Station STA66 dispatched to Incident ID 319744 (Unknown Medical) at 27440 COUNTY RD 13
(DA) 07-30-12 22:55: Station STA66 dispatched to Incident ID 319780 (Fall) at 1105 WHISPERING PINES RD (0)
(DA) 07-31-12 11:10: Station STA66 dispatched to Incident ID 319906 (Cardiac Arrest) at 101 VILLA DR (36526)
(DA) 07-31-12 12:47: Station STA66 dispatched to Incident ID 319931 (Seizure) at 29249 U S HWY 98
(DA) 07-31-12 22:11: Station STA66 dispatched to Incident ID 320132 (Chest Pain) at 27522 HARBOR CV
(DA) 08-01-12 07:39: Station STA66 dispatched to Incident ID 320217 (Auto Accident) at HWY 181 @ I10
(DA) 08-01-12 11:32: Station STA66 dispatched to Incident ID 320275 (General Illness) at 107 CALVERDALE CIR (0)
(DA) 08-01-12 12:23: Station STA66 dispatched to Incident ID 320292 (Unknown Medical) at 912 VAN AV
(DA) 08-01-12 12:57: Station STA66 dispatched to Incident ID 320307 (Fracture) at 148 ROLLING HILL DR
(DA) 08-01-12 13:24: Station STA66 dispatched to Incident ID 320320 (Fire Alarm) at 1506 MAIN ST
(DA) 08-01-12 13:46: Station STA66 dispatched to Incident ID 320330 (Fire Alarm) at 29645 FREDERICK BLVD
(DA) 08-01-12 15:39: Station STA66 dispatched to Incident ID 320366 (Auto Accident) at TARGET PKING LOT NEAR THE BANK
(DA) 08-01-12 15:47: Station STA66 dispatched to Incident ID 320374 (General Illness) at 1705 MAIN ST
(DA) 08-01-12 16:18: Station STA66 dispatched to Incident ID 320386 (Chest Pain) at 501 OAK RIDGE CT E (0)
(DA) 08-01-12 16:37: Station STA66 dispatched to Incident ID 320396 (Chest Pain) at 7443 REEDS LN (36526)
(DA) 08-02-12 07:25: Station STA66 dispatched to Incident ID 320597 (Fall) at 29919 WOODROW LN
(DA) 08-02-12 09:25: Station STA66 dispatched to Incident ID 320625 (Assistance) at 27250 U S HWY 98
(DA) 08-02-12 13:50: Station STA66 dispatched to Incident ID 320720 (Fall) at 26210 EQUITY DR (0)
(DA) 08-02-12 18:11: Station STA66 dispatched to Incident ID 320842 (Unconscious) at 201  DAPHMONT DR EXT
(DA) 08-02-12 18:47: Station STA66 dispatched to Incident ID 320857 (Fall) at 27296 COUNTY RD 13
(DA) 08-03-12 10:01: Station STA66 dispatched to Incident ID 321053 (Fire Alarm) at 7101 U S HWY 90
(DA) 08-03-12 12:06: Station STA66 dispatched to Incident ID 321109 (Chest Pain) at 2603 98
(DA) 08-03-12 13:19: Station STA66 dispatched to Incident ID 321144 (Welfare concern) at 27434 STRATFORD GLEN DR
(DA) 08-03-12 15:07: Station STA66 dispatched to Incident ID 321192 (General Weakness) at 101 VILLA DR (36526)
(DA) 08-03-12 19:02: Station STA66 dispatched to Incident ID 321282 (Bleeding) at 28611 U S HWY 98
(DA) 08-03-12 20:20: Station STA66 dispatched to Incident ID 321327 (Back Pain) at MCDONALD'S HWY98 DAPHNE,AL
(DA) 08-03-12 20:35: Station STA66 dispatched to Incident ID 321335 (Fire Alarm) at 28788 N MAIN ST
(DA) 08-04-12 04:21: Station STA66 dispatched to Incident ID 321481 (Neck Injury) at 104 CHATWOOD CIR
(DA) 08-04-12 06:52: Station STA66 dispatched to Incident ID 321496 (Auto Accident) at I-10 EB MALBIS EX
(DA) 08-04-12 11:04: Station STA66 dispatched to Incident ID 321564 (Auto Accident) at HWY181 SB @ I-10 ON RAMP
(DA) 08-04-12 12:24: Station STA66 dispatched to Incident ID 321599 (Auto Accident) at HWY181 SB  @ DUNMORE SUB
(DA) 08-04-12 12:41: Station STA66 dispatched to Incident ID 321607 (Fall) at 10171 PAPAGEORGE ST (0)
(DA) 08-04-12 12:58: Station STA66 dispatched to Incident ID 321614 (Unknown Medical) at 3075 U S HWY 98 (0)
(DA) 08-04-12 17:22: Station STA66 dispatched to Incident ID 321719 (Personal Assist) at 27440 COUNTY RD 13
(DA) 08-04-12 22:21: Station STA66 dispatched to Incident ID 321867 (Unknown Medical) at WALMART IN DAPHNE
(DA) 08-04-12 23:21: Station STA66 dispatched to Incident ID 321886 (Chest Pain) at 26920 POLLARD RD
(DA) 08-05-12 00:18: Station STA66 dispatched to Incident ID 321914 (Unknown Medical) at 504 CHURCH AV
(DA) 08-05-12 01:28: Station STA66 dispatched to Incident ID 321944 (Unknown Medical) at 504 CHURCH AV
(DA) 08-05-12 03:49: Station STA66 dispatched to Incident ID 321963 (Difficulty Breathing) at 28509 2ND ST (36526)
(DA) 08-05-12 09:55: Station STA66 dispatched to Incident ID 322005 (Headache) at 10171 PAPAGEORGE ST (0)
(DA) 08-05-12 11:24: Station STA66 dispatched to Incident ID 322056 (Fall) at 27296 CO RD 13
(DA) 08-05-12 16:50: Station STA66 dispatched to Incident ID 322183 (Auto Accident) at HWY 98/ BEFORE I-10 OVERPASS
(DA) 08-05-12 17:08: Station STA66 dispatched to Incident ID 322192 (Mental Person) at 28609 CASCADES CT
(DA) 08-05-12 17:31: Station STA66 dispatched to Incident ID 322206 (Auto Accident) at I10 EB MM35B
(DA) 08-05-12 20:57: Station STA66 dispatched to Incident ID 322288 (Fall) at 112 BUENA VISTA DR (0)
(DA) 08-05-12 21:41: Station STA66 dispatched to Incident ID 322306 (Diabetic) at 702 ADAMS AV S
(DA) 08-05-12 23:36: Station STA66 dispatched to Incident ID 322343 (Fall) at 2200 EAST BAY DR
(DA) 08-06-12 08:16: Station STA66 dispatched to Incident ID 322409 (Fire Alarm) at 6840 U S HWY 90
(DA) 08-06-12 11:54: Station STA66 dispatched to Incident ID 322474 (Fire Alarm) at 101 VILLA DR
(DA) 08-06-12 12:09: Station STA66 dispatched to Incident ID 322480 (Unknown Medical) at 27961 U S HWY 98
(DA) 08-06-12 12:19: Station STA66 dispatched to Incident ID 322485 (Fire Alarm) at 1506 MAIN ST
(DA) 08-06-12 15:20: Station STA66 dispatched to Incident ID 322538 (Auto Accident) at I-65 SB ON BRIDGE
(DA) 08-06-12 15:24: Station STA66 dispatched to Incident ID 322543 (General Illness) at 2505 POLLARD RD
(DA) 08-06-12 17:38: Station STA66 dispatched to Incident ID 322590 (Auto Accident) at 64 AND 181
(DA) 08-06-12 18:32: Station STA66 dispatched to Incident ID 322610 (Structure Fire) at 806 N GREENO RD
(DA) 08-06-12 18:37: Station STA66 dispatched to Incident ID 322615 (General Illness) at 2301 POLLARD RD (36526)
(DA) 08-07-12 09:34: Station STA66 dispatched to Incident ID 322791 (Back Pain) at 507 TRACE CROSSING
(DA) 08-07-12 16:40: Station STA66 dispatched to Incident ID 322947 (Fall) at 10291 FIONN LOOP
(DA) 08-08-12 09:16: Station STA66 dispatched to Incident ID 323184 (Fire Alarm) at 101 VILLA DR
(DA) 08-08-12 09:37: Station STA66 dispatched to Incident ID 323188 (Vehicle Fire) at US HWY 98 @ I 10
(DA) 08-08-12 12:06: Station STA66 dispatched to Incident ID 323215 (Difficulty Breathing) at 11626 U S HWY 90 (0)
(DA) 08-08-12 15:36: Station STA66 dispatched to Incident ID 323304 (Fire Alarm) at 27440 13
(DA) 08-08-12 15:41: Station STA66 dispatched to Incident ID 323308 (Unknown Medical) at 2200 EAST BAY DR
(DA) 08-08-12 15:44: Station STA66 dispatched to Incident ID 323313 (Fall) at DAPHNE JAIL

*/

public class ALBaldwinCountyParserTest extends BaseParserTest {
  
  public ALBaldwinCountyParserTest() {
    setParser(new ALBaldwinCountyParser(), "BALDWIN COUNTY", "AL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "- E911 Notification - Elberta VFD - 05-20-12 13:43: Station STA31 dispatched to Incident ID 290161 (Stroke) at 25855 WILLOW RIDGE R",
        "SRC:Elberta VFD",
        "DATE:05/20/2012",
        "TIME:13:43",
        "UNIT:STA31",
        "ID:290161",
        "CALL:Stroke",
        "ADDR:25855 WILLOW RIDGE R");

    doTest("T2",
        "- E911 Notification - Elberta VFD - 05-21-12 15:35: Station STA31 dispatched to Incident ID 290600 (Fire - Grass) at 17305 JOE GOTTLER RD",
        "SRC:Elberta VFD",
        "DATE:05/21/2012",
        "TIME:15:35",
        "UNIT:STA31",
        "ID:290600",
        "CALL:Fire - Grass",
        "ADDR:17305 JOE GOTTLER RD");

    doTest("T3",
        "- E911 Notification - Elberta VFD - 05-24-12 08:48: Station STA31 dispatched to Incident ID 291543 (Auto Accident) at 14850 87\n",
        "SRC:Elberta VFD",
        "DATE:05/24/2012",
        "TIME:08:48",
        "UNIT:STA31",
        "ID:291543",
        "CALL:Auto Accident",
        "ADDR:14850 RT 87");

    doTest("T4",
        "- E911 Notification - Elberta VFD - 05-26-12 08:04: Station STA31 dispatched to Incident ID 292420 (Auto Accident) at US HWY 98 @ SANDY LN",
        "SRC:Elberta VFD",
        "DATE:05/26/2012",
        "TIME:08:04",
        "UNIT:STA31",
        "ID:292420",
        "CALL:Auto Accident",
        "ADDR:US HWY 98 & SANDY LN",
        "MADDR:US 98 & SANDY LN");

    doTest("T5",
        "- E911 Notification - Elberta VFD - 05-26-12 16:24: Station STA31 dispatched to Incident ID 292625 (Auto Accident) at HWY98 @ CORD9",
        "SRC:Elberta VFD",
        "DATE:05/26/2012",
        "TIME:16:24",
        "UNIT:STA31",
        "ID:292625",
        "CALL:Auto Accident",
        "ADDR:HWY98 & CORD9",
        "MADDR:HWY 98 & COUNTY ROAD 9");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(DA) 07-27-12 22:54: Station STA66 dispatched to Incident ID 318501 (Suicide) at 8764 DRIFTON CT",
        "DATE:07/27/2012",
        "TIME:22:54",
        "UNIT:STA66",
        "ID:318501",
        "CALL:Suicide",
        "ADDR:8764 DRIFTON CT");  // Not mapping

    doTest("T2",
        "(DA) 07-28-12 01:58: Station STA66 dispatched to Incident ID 318559 (Chest Pain) at 29793 WOODROW LN",
        "DATE:07/28/2012",
        "TIME:01:58",
        "UNIT:STA66",
        "ID:318559",
        "CALL:Chest Pain",
        "ADDR:29793 WOODROW LN");

    doTest("T3",
        "(DA) 07-28-12 13:44: Station STA66 dispatched to Incident ID 318716 (General Illness) at 131 RIDGEWOOD DR (0)",
        "DATE:07/28/2012",
        "TIME:13:44",
        "UNIT:STA66",
        "ID:318716",
        "CALL:General Illness",
        "ADDR:131 RIDGEWOOD DR");

    doTest("T4",
        "(DA) 07-28-12 14:11: Station STA66 dispatched to Incident ID 318728 (Auto Accident) at HWY181 NB I-10",
        "DATE:07/28/2012",
        "TIME:14:11",
        "UNIT:STA66",
        "ID:318728",
        "CALL:Auto Accident",
        "ADDR:HWY181 NB I-10",
        "MADDR:HWY 181 I 10");

    doTest("T5",
        "(DA) 07-28-12 19:56: Station STA66 dispatched to Incident ID 318908 (Fire Alarm) at 29758 FREDERICK BLVD",
        "DATE:07/28/2012",
        "TIME:19:56",
        "UNIT:STA66",
        "ID:318908",
        "CALL:Fire Alarm",
        "ADDR:29758 FREDERICK BLVD");

    doTest("T6",
        "(DA) 07-28-12 20:52: Station STA66 dispatched to Incident ID 318944 (General Illness) at 27642 HWY 98",
        "DATE:07/28/2012",
        "TIME:20:52",
        "UNIT:STA66",
        "ID:318944",
        "CALL:General Illness",
        "ADDR:27642 HWY 98");

    doTest("T7",
        "(DA) 07-28-12 22:42: Station STA66 dispatched to Incident ID 318990 (Chest Pain) at MCDONALDS STATE HWY 181",
        "DATE:07/28/2012",
        "TIME:22:42",
        "UNIT:STA66",
        "ID:318990",
        "CALL:Chest Pain",
        "ADDR:MCDONALDS STATE HWY 181",
        "MADDR:MCDONALDS STATE 181");

    doTest("T8",
        "(DA) 07-29-12 03:22: Station STA66 dispatched to Incident ID 319047 (Abdominal Pain) at 29960 SAINT SIMON ST",
        "DATE:07/29/2012",
        "TIME:03:22",
        "UNIT:STA66",
        "ID:319047",
        "CALL:Abdominal Pain",
        "ADDR:29960 SAINT SIMON ST");

    doTest("T9",
        "(DA) 07-29-12 06:52: Station STA66 dispatched to Incident ID 319067 (Unknown Medical) at 9020 ASHLEY CT (0)",
        "DATE:07/29/2012",
        "TIME:06:52",
        "UNIT:STA66",
        "ID:319067",
        "CALL:Unknown Medical",
        "ADDR:9020 ASHLEY CT");

    doTest("T10",
        "(DA) 07-29-12 09:06: Station STA66 dispatched to Incident ID 319086 (Unconscious) at 200 PARMA DR",
        "DATE:07/29/2012",
        "TIME:09:06",
        "UNIT:STA66",
        "ID:319086",
        "CALL:Unconscious",
        "ADDR:200 PARMA DR");

    doTest("T11",
        "(DA) 07-29-12 11:38: Station STA66 dispatched to Incident ID 319128 (Fire Alarm) at 27642 US HWY 98",
        "DATE:07/29/2012",
        "TIME:11:38",
        "UNIT:STA66",
        "ID:319128",
        "CALL:Fire Alarm",
        "ADDR:27642 US HWY 98",
        "MADDR:27642 US 98");

    doTest("T12",
        "(DA) 07-29-12 14:03: Station STA66 dispatched to Incident ID 319179 (Stroke) at 28480 BAY CLIFF LN",
        "DATE:07/29/2012",
        "TIME:14:03",
        "UNIT:STA66",
        "ID:319179",
        "CALL:Stroke",
        "ADDR:28480 BAY CLIFF LN");

    doTest("T13",
        "(DA) 07-29-12 15:23: Station STA66 dispatched to Incident ID 319200 (Suicide Threat) at 8764 DRIFTON CT",
        "DATE:07/29/2012",
        "TIME:15:23",
        "UNIT:STA66",
        "ID:319200",
        "CALL:Suicide Threat",
        "ADDR:8764 DRIFTON CT");

    doTest("T14",
        "(DA) 07-30-12 06:56: Station STA66 dispatched to Incident ID 319399 (Structure Fire) at PARK DR",
        "DATE:07/30/2012",
        "TIME:06:56",
        "UNIT:STA66",
        "ID:319399",
        "CALL:Structure Fire",
        "ADDR:PARK DR");

    doTest("T15",
        "(DA) 07-30-12 08:19: Station STA66 dispatched to Incident ID 319417 (Unconscious) at 27434 STRATFORD GLEN DR",
        "DATE:07/30/2012",
        "TIME:08:19",
        "UNIT:STA66",
        "ID:319417",
        "CALL:Unconscious",
        "ADDR:27434 STRATFORD GLEN DR");

    doTest("T16",
        "(DA) 07-30-12 08:51: Station STA66 dispatched to Incident ID 319429 (Fall) at 29951 ST BARBARA ST",
        "DATE:07/30/2012",
        "TIME:08:51",
        "UNIT:STA66",
        "ID:319429",
        "CALL:Fall",
        "ADDR:29951 ST BARBARA ST");

    doTest("T17",
        "(DA) 07-30-12 10:21: Station STA66 dispatched to Incident ID 319457 (Suicide Threat) at 133 LAKE FRONT DR",
        "DATE:07/30/2012",
        "TIME:10:21",
        "UNIT:STA66",
        "ID:319457",
        "CALL:Suicide Threat",
        "ADDR:133 LAKE FRONT DR");

    doTest("T18",
        "(DA) 07-30-12 10:40: Station STA66 dispatched to Incident ID 319466 (Unknown Medical) at 27961 U S HWY 98",
        "DATE:07/30/2012",
        "TIME:10:40",
        "UNIT:STA66",
        "ID:319466",
        "CALL:Unknown Medical",
        "ADDR:27961 U S HWY 98");

    doTest("T19",
        "(DA) 07-30-12 11:26: Station STA66 dispatched to Incident ID 319479 (Auto Accident) at CO RD 64/ FRIENDSHIP RD",
        "DATE:07/30/2012",
        "TIME:11:26",
        "UNIT:STA66",
        "ID:319479",
        "CALL:Auto Accident",
        "ADDR:CO RD 64 & FRIENDSHIP RD",
        "MADDR:COUNTY ROAD 64 & FRIENDSHIP RD");

    doTest("T20",
        "(DA) 07-30-12 11:53: Station STA66 dispatched to Incident ID 319486 (Bleeding) at 7411 REEDS LN",
        "DATE:07/30/2012",
        "TIME:11:53",
        "UNIT:STA66",
        "ID:319486",
        "CALL:Bleeding",
        "ADDR:7411 REEDS LN");

    doTest("T21",
        "(DA) 07-30-12 13:12: Station STA66 dispatched to Incident ID 319521 (Fire - Grass) at I-10 WB J E OF EX35",
        "DATE:07/30/2012",
        "TIME:13:12",
        "UNIT:STA66",
        "ID:319521",
        "CALL:Fire - Grass",
        "ADDR:I-10 WB J E OF EX35",
        "MADDR:I 10 J E OF EX35");

    doTest("T22",
        "(DA) 07-30-12 17:47: Station STA66 dispatched to Incident ID 319685 (Auto Accident) at I-10 EB EXIT RAMP AT EXIT 35",
        "DATE:07/30/2012",
        "TIME:17:47",
        "UNIT:STA66",
        "ID:319685",
        "CALL:Auto Accident",
        "ADDR:I-10 EB EXIT RAMP AT EXIT 35",
        "MADDR:I 10 EXIT RAMP AT EXIT 35");

    doTest("T23",
        "(DA) 07-30-12 19:44: Station STA66 dispatched to Incident ID 319730 (Bleeding) at 7878 PINE RUN",
        "DATE:07/30/2012",
        "TIME:19:44",
        "UNIT:STA66",
        "ID:319730",
        "CALL:Bleeding",
        "ADDR:7878 PINE RUN");

    doTest("T24",
        "(DA) 07-30-12 20:34: Station STA66 dispatched to Incident ID 319744 (Unknown Medical) at 27440 COUNTY RD 13",
        "DATE:07/30/2012",
        "TIME:20:34",
        "UNIT:STA66",
        "ID:319744",
        "CALL:Unknown Medical",
        "ADDR:27440 COUNTY RD 13");

    doTest("T25",
        "(DA) 07-30-12 22:55: Station STA66 dispatched to Incident ID 319780 (Fall) at 1105 WHISPERING PINES RD (0)",
        "DATE:07/30/2012",
        "TIME:22:55",
        "UNIT:STA66",
        "ID:319780",
        "CALL:Fall",
        "ADDR:1105 WHISPERING PINES RD");

    doTest("T26",
        "(DA) 07-31-12 11:10: Station STA66 dispatched to Incident ID 319906 (Cardiac Arrest) at 101 VILLA DR (36526)",
        "DATE:07/31/2012",
        "TIME:11:10",
        "UNIT:STA66",
        "ID:319906",
        "CALL:Cardiac Arrest",
        "ADDR:101 VILLA DR");

    doTest("T27",
        "(DA) 07-31-12 12:47: Station STA66 dispatched to Incident ID 319931 (Seizure) at 29249 U S HWY 98",
        "DATE:07/31/2012",
        "TIME:12:47",
        "UNIT:STA66",
        "ID:319931",
        "CALL:Seizure",
        "ADDR:29249 U S HWY 98");

    doTest("T28",
        "(DA) 07-31-12 22:11: Station STA66 dispatched to Incident ID 320132 (Chest Pain) at 27522 HARBOR CV",
        "DATE:07/31/2012",
        "TIME:22:11",
        "UNIT:STA66",
        "ID:320132",
        "CALL:Chest Pain",
        "ADDR:27522 HARBOR CV");

    doTest("T29",
        "(DA) 08-01-12 07:39: Station STA66 dispatched to Incident ID 320217 (Auto Accident) at HWY 181 @ I10",
        "DATE:08/01/2012",
        "TIME:07:39",
        "UNIT:STA66",
        "ID:320217",
        "CALL:Auto Accident",
        "ADDR:HWY 181 & I10",
        "MADDR:HWY 181 & I 10");

    doTest("T30",
        "(DA) 08-01-12 11:32: Station STA66 dispatched to Incident ID 320275 (General Illness) at 107 CALVERDALE CIR (0)",
        "DATE:08/01/2012",
        "TIME:11:32",
        "UNIT:STA66",
        "ID:320275",
        "CALL:General Illness",
        "ADDR:107 CALVERDALE CIR");

    doTest("T31",
        "(DA) 08-01-12 12:23: Station STA66 dispatched to Incident ID 320292 (Unknown Medical) at 912 VAN AV",
        "DATE:08/01/2012",
        "TIME:12:23",
        "UNIT:STA66",
        "ID:320292",
        "CALL:Unknown Medical",
        "ADDR:912 VAN AV",
        "MADDR:912 VAN AVE");

    doTest("T32",
        "(DA) 08-01-12 12:57: Station STA66 dispatched to Incident ID 320307 (Fracture) at 148 ROLLING HILL DR",
        "DATE:08/01/2012",
        "TIME:12:57",
        "UNIT:STA66",
        "ID:320307",
        "CALL:Fracture",
        "ADDR:148 ROLLING HILL DR");

    doTest("T33",
        "(DA) 08-01-12 13:24: Station STA66 dispatched to Incident ID 320320 (Fire Alarm) at 1506 MAIN ST",
        "DATE:08/01/2012",
        "TIME:13:24",
        "UNIT:STA66",
        "ID:320320",
        "CALL:Fire Alarm",
        "ADDR:1506 MAIN ST");

    doTest("T34",
        "(DA) 08-01-12 13:46: Station STA66 dispatched to Incident ID 320330 (Fire Alarm) at 29645 FREDERICK BLVD",
        "DATE:08/01/2012",
        "TIME:13:46",
        "UNIT:STA66",
        "ID:320330",
        "CALL:Fire Alarm",
        "ADDR:29645 FREDERICK BLVD");

    doTest("T35",
        "(DA) 08-01-12 15:39: Station STA66 dispatched to Incident ID 320366 (Auto Accident) at TARGET PKING LOT NEAR THE BANK",
        "DATE:08/01/2012",
        "TIME:15:39",
        "UNIT:STA66",
        "ID:320366",
        "CALL:Auto Accident",
        "ADDR:TARGET PKING",
        "APT:NEAR THE BANK");

    doTest("T36",
        "(DA) 08-01-12 15:47: Station STA66 dispatched to Incident ID 320374 (General Illness) at 1705 MAIN ST",
        "DATE:08/01/2012",
        "TIME:15:47",
        "UNIT:STA66",
        "ID:320374",
        "CALL:General Illness",
        "ADDR:1705 MAIN ST");

    doTest("T37",
        "(DA) 08-01-12 16:18: Station STA66 dispatched to Incident ID 320386 (Chest Pain) at 501 OAK RIDGE CT E (0)",
        "DATE:08/01/2012",
        "TIME:16:18",
        "UNIT:STA66",
        "ID:320386",
        "CALL:Chest Pain",
        "ADDR:501 OAK RIDGE CT E");

    doTest("T38",
        "(DA) 08-01-12 16:37: Station STA66 dispatched to Incident ID 320396 (Chest Pain) at 7443 REEDS LN (36526)",
        "DATE:08/01/2012",
        "TIME:16:37",
        "UNIT:STA66",
        "ID:320396",
        "CALL:Chest Pain",
        "ADDR:7443 REEDS LN");

    doTest("T39",
        "(DA) 08-02-12 07:25: Station STA66 dispatched to Incident ID 320597 (Fall) at 29919 WOODROW LN",
        "DATE:08/02/2012",
        "TIME:07:25",
        "UNIT:STA66",
        "ID:320597",
        "CALL:Fall",
        "ADDR:29919 WOODROW LN");

    doTest("T40",
        "(DA) 08-02-12 09:25: Station STA66 dispatched to Incident ID 320625 (Assistance) at 27250 U S HWY 98",
        "DATE:08/02/2012",
        "TIME:09:25",
        "UNIT:STA66",
        "ID:320625",
        "CALL:Assistance",
        "ADDR:27250 U S HWY 98");

    doTest("T41",
        "(DA) 08-02-12 13:50: Station STA66 dispatched to Incident ID 320720 (Fall) at 26210 EQUITY DR (0)",
        "DATE:08/02/2012",
        "TIME:13:50",
        "UNIT:STA66",
        "ID:320720",
        "CALL:Fall",
        "ADDR:26210 EQUITY DR");

    doTest("T42",
        "(DA) 08-02-12 18:11: Station STA66 dispatched to Incident ID 320842 (Unconscious) at 201  DAPHMONT DR EXT",
        "DATE:08/02/2012",
        "TIME:18:11",
        "UNIT:STA66",
        "ID:320842",
        "CALL:Unconscious",
        "ADDR:201  DAPHMONT DR EXT",
        "MADDR:201  DAPHMONT DR");

    doTest("T43",
        "(DA) 08-02-12 18:47: Station STA66 dispatched to Incident ID 320857 (Fall) at 27296 COUNTY RD 13",
        "DATE:08/02/2012",
        "TIME:18:47",
        "UNIT:STA66",
        "ID:320857",
        "CALL:Fall",
        "ADDR:27296 COUNTY RD 13");

    doTest("T44",
        "(DA) 08-03-12 10:01: Station STA66 dispatched to Incident ID 321053 (Fire Alarm) at 7101 U S HWY 90",
        "DATE:08/03/2012",
        "TIME:10:01",
        "UNIT:STA66",
        "ID:321053",
        "CALL:Fire Alarm",
        "ADDR:7101 U S HWY 90");

    doTest("T45",
        "(DA) 08-03-12 12:06: Station STA66 dispatched to Incident ID 321109 (Chest Pain) at 2603 98",
        "DATE:08/03/2012",
        "TIME:12:06",
        "UNIT:STA66",
        "ID:321109",
        "CALL:Chest Pain",
        "ADDR:2603 RT 98");

    doTest("T46",
        "(DA) 08-03-12 13:19: Station STA66 dispatched to Incident ID 321144 (Welfare concern) at 27434 STRATFORD GLEN DR",
        "DATE:08/03/2012",
        "TIME:13:19",
        "UNIT:STA66",
        "ID:321144",
        "CALL:Welfare concern",
        "ADDR:27434 STRATFORD GLEN DR");

    doTest("T47",
        "(DA) 08-03-12 15:07: Station STA66 dispatched to Incident ID 321192 (General Weakness) at 101 VILLA DR (36526)",
        "DATE:08/03/2012",
        "TIME:15:07",
        "UNIT:STA66",
        "ID:321192",
        "CALL:General Weakness",
        "ADDR:101 VILLA DR");

    doTest("T48",
        "(DA) 08-03-12 19:02: Station STA66 dispatched to Incident ID 321282 (Bleeding) at 28611 U S HWY 98",
        "DATE:08/03/2012",
        "TIME:19:02",
        "UNIT:STA66",
        "ID:321282",
        "CALL:Bleeding",
        "ADDR:28611 U S HWY 98");

    doTest("T49",
        "(DA) 08-03-12 20:20: Station STA66 dispatched to Incident ID 321327 (Back Pain) at MCDONALD'S HWY98 DAPHNE,AL",
        "DATE:08/03/2012",
        "TIME:20:20",
        "UNIT:STA66",
        "ID:321327",
        "CALL:Back Pain",
        "ADDR:MCDONALD'S HWY98 DAPHNE,AL",
        "MADDR:MCDONALD'S HWY 98 DAPHNE,AL");

    doTest("T50",
        "(DA) 08-03-12 20:35: Station STA66 dispatched to Incident ID 321335 (Fire Alarm) at 28788 N MAIN ST",
        "DATE:08/03/2012",
        "TIME:20:35",
        "UNIT:STA66",
        "ID:321335",
        "CALL:Fire Alarm",
        "ADDR:28788 N MAIN ST");

    doTest("T51",
        "(DA) 08-04-12 04:21: Station STA66 dispatched to Incident ID 321481 (Neck Injury) at 104 CHATWOOD CIR",
        "DATE:08/04/2012",
        "TIME:04:21",
        "UNIT:STA66",
        "ID:321481",
        "CALL:Neck Injury",
        "ADDR:104 CHATWOOD CIR");

    doTest("T52",
        "(DA) 08-04-12 06:52: Station STA66 dispatched to Incident ID 321496 (Auto Accident) at I-10 EB MALBIS EX",
        "DATE:08/04/2012",
        "TIME:06:52",
        "UNIT:STA66",
        "ID:321496",
        "CALL:Auto Accident",
        "ADDR:I-10 EB MALBIS EX",
        "MADDR:I 10 MALBIS");

    doTest("T53",
        "(DA) 08-04-12 11:04: Station STA66 dispatched to Incident ID 321564 (Auto Accident) at HWY181 SB @ I-10 ON RAMP",
        "DATE:08/04/2012",
        "TIME:11:04",
        "UNIT:STA66",
        "ID:321564",
        "CALL:Auto Accident",
        "ADDR:HWY181 SB & I-10 ON RAMP",
        "MADDR:HWY 181 & I 10 ON RAMP");

    doTest("T54",
        "(DA) 08-04-12 12:24: Station STA66 dispatched to Incident ID 321599 (Auto Accident) at HWY181 SB  @ DUNMORE SUB",
        "DATE:08/04/2012",
        "TIME:12:24",
        "UNIT:STA66",
        "ID:321599",
        "CALL:Auto Accident",
        "ADDR:HWY181 SB & DUNMORE SUB",
        "MADDR:HWY 181 & DUNMORE SUB");

    doTest("T55",
        "(DA) 08-04-12 12:41: Station STA66 dispatched to Incident ID 321607 (Fall) at 10171 PAPAGEORGE ST (0)",
        "DATE:08/04/2012",
        "TIME:12:41",
        "UNIT:STA66",
        "ID:321607",
        "CALL:Fall",
        "ADDR:10171 PAPAGEORGE ST");

    doTest("T56",
        "(DA) 08-04-12 12:58: Station STA66 dispatched to Incident ID 321614 (Unknown Medical) at 3075 U S HWY 98 (0)",
        "DATE:08/04/2012",
        "TIME:12:58",
        "UNIT:STA66",
        "ID:321614",
        "CALL:Unknown Medical",
        "ADDR:3075 U S HWY 98");

    doTest("T57",
        "(DA) 08-04-12 17:22: Station STA66 dispatched to Incident ID 321719 (Personal Assist) at 27440 COUNTY RD 13",
        "DATE:08/04/2012",
        "TIME:17:22",
        "UNIT:STA66",
        "ID:321719",
        "CALL:Personal Assist",
        "ADDR:27440 COUNTY RD 13");

    doTest("T58",
        "(DA) 08-04-12 22:21: Station STA66 dispatched to Incident ID 321867 (Unknown Medical) at WALMART IN DAPHNE",
        "DATE:08/04/2012",
        "TIME:22:21",
        "UNIT:STA66",
        "ID:321867",
        "CALL:Unknown Medical",
        "ADDR:WALMART IN DAPHNE");

    doTest("T59",
        "(DA) 08-04-12 23:21: Station STA66 dispatched to Incident ID 321886 (Chest Pain) at 26920 POLLARD RD",
        "DATE:08/04/2012",
        "TIME:23:21",
        "UNIT:STA66",
        "ID:321886",
        "CALL:Chest Pain",
        "ADDR:26920 POLLARD RD");

    doTest("T60",
        "(DA) 08-05-12 00:18: Station STA66 dispatched to Incident ID 321914 (Unknown Medical) at 504 CHURCH AV",
        "DATE:08/05/2012",
        "TIME:00:18",
        "UNIT:STA66",
        "ID:321914",
        "CALL:Unknown Medical",
        "ADDR:504 CHURCH AV",
        "MADDR:504 CHURCH AVE");

    doTest("T61",
        "(DA) 08-05-12 01:28: Station STA66 dispatched to Incident ID 321944 (Unknown Medical) at 504 CHURCH AV",
        "DATE:08/05/2012",
        "TIME:01:28",
        "UNIT:STA66",
        "ID:321944",
        "CALL:Unknown Medical",
        "ADDR:504 CHURCH AV",
        "MADDR:504 CHURCH AVE");

    doTest("T62",
        "(DA) 08-05-12 03:49: Station STA66 dispatched to Incident ID 321963 (Difficulty Breathing) at 28509 2ND ST (36526)",
        "DATE:08/05/2012",
        "TIME:03:49",
        "UNIT:STA66",
        "ID:321963",
        "CALL:Difficulty Breathing",
        "ADDR:28509 2ND ST");

    doTest("T63",
        "(DA) 08-05-12 09:55: Station STA66 dispatched to Incident ID 322005 (Headache) at 10171 PAPAGEORGE ST (0)",
        "DATE:08/05/2012",
        "TIME:09:55",
        "UNIT:STA66",
        "ID:322005",
        "CALL:Headache",
        "ADDR:10171 PAPAGEORGE ST");

    doTest("T64",
        "(DA) 08-05-12 11:24: Station STA66 dispatched to Incident ID 322056 (Fall) at 27296 CO RD 13",
        "DATE:08/05/2012",
        "TIME:11:24",
        "UNIT:STA66",
        "ID:322056",
        "CALL:Fall",
        "ADDR:27296 CO RD 13",
        "MADDR:27296 COUNTY ROAD 13");

    doTest("T65",
        "(DA) 08-05-12 16:50: Station STA66 dispatched to Incident ID 322183 (Auto Accident) at HWY 98/ BEFORE I-10 OVERPASS",
        "DATE:08/05/2012",
        "TIME:16:50",
        "UNIT:STA66",
        "ID:322183",
        "CALL:Auto Accident",
        "ADDR:HWY 98 & BEFORE I-10 OVERPASS",
        "MADDR:HWY 98 & BEFORE I 10 OVERPASS");

    doTest("T66",
        "(DA) 08-05-12 17:08: Station STA66 dispatched to Incident ID 322192 (Mental Person) at 28609 CASCADES CT",
        "DATE:08/05/2012",
        "TIME:17:08",
        "UNIT:STA66",
        "ID:322192",
        "CALL:Mental Person",
        "ADDR:28609 CASCADES CT");

    doTest("T67",
        "(DA) 08-05-12 17:31: Station STA66 dispatched to Incident ID 322206 (Auto Accident) at I10 EB MM35B",
        "DATE:08/05/2012",
        "TIME:17:31",
        "UNIT:STA66",
        "ID:322206",
        "CALL:Auto Accident",
        "ADDR:I10 EB MM35B",
        "MADDR:I 10 MM35B");

    doTest("T68",
        "(DA) 08-05-12 20:57: Station STA66 dispatched to Incident ID 322288 (Fall) at 112 BUENA VISTA DR (0)",
        "DATE:08/05/2012",
        "TIME:20:57",
        "UNIT:STA66",
        "ID:322288",
        "CALL:Fall",
        "ADDR:112 BUENA VISTA DR");

    doTest("T69",
        "(DA) 08-05-12 21:41: Station STA66 dispatched to Incident ID 322306 (Diabetic) at 702 ADAMS AV S",
        "DATE:08/05/2012",
        "TIME:21:41",
        "UNIT:STA66",
        "ID:322306",
        "CALL:Diabetic",
        "ADDR:702 ADAMS AV S",
        "MADDR:702 ADAMS AVE S");

    doTest("T70",
        "(DA) 08-05-12 23:36: Station STA66 dispatched to Incident ID 322343 (Fall) at 2200 EAST BAY DR",
        "DATE:08/05/2012",
        "TIME:23:36",
        "UNIT:STA66",
        "ID:322343",
        "CALL:Fall",
        "ADDR:2200 EAST BAY DR");

    doTest("T71",
        "(DA) 08-06-12 08:16: Station STA66 dispatched to Incident ID 322409 (Fire Alarm) at 6840 U S HWY 90",
        "DATE:08/06/2012",
        "TIME:08:16",
        "UNIT:STA66",
        "ID:322409",
        "CALL:Fire Alarm",
        "ADDR:6840 U S HWY 90");

    doTest("T72",
        "(DA) 08-06-12 11:54: Station STA66 dispatched to Incident ID 322474 (Fire Alarm) at 101 VILLA DR",
        "DATE:08/06/2012",
        "TIME:11:54",
        "UNIT:STA66",
        "ID:322474",
        "CALL:Fire Alarm",
        "ADDR:101 VILLA DR");

    doTest("T73",
        "(DA) 08-06-12 12:09: Station STA66 dispatched to Incident ID 322480 (Unknown Medical) at 27961 U S HWY 98",
        "DATE:08/06/2012",
        "TIME:12:09",
        "UNIT:STA66",
        "ID:322480",
        "CALL:Unknown Medical",
        "ADDR:27961 U S HWY 98");

    doTest("T74",
        "(DA) 08-06-12 12:19: Station STA66 dispatched to Incident ID 322485 (Fire Alarm) at 1506 MAIN ST",
        "DATE:08/06/2012",
        "TIME:12:19",
        "UNIT:STA66",
        "ID:322485",
        "CALL:Fire Alarm",
        "ADDR:1506 MAIN ST");

    doTest("T75",
        "(DA) 08-06-12 15:20: Station STA66 dispatched to Incident ID 322538 (Auto Accident) at I-65 SB ON BRIDGE",
        "DATE:08/06/2012",
        "TIME:15:20",
        "UNIT:STA66",
        "ID:322538",
        "CALL:Auto Accident",
        "ADDR:I-65 SB ON BRIDGE",
        "MADDR:I 65 ON BRIDGE");

    doTest("T76",
        "(DA) 08-06-12 15:24: Station STA66 dispatched to Incident ID 322543 (General Illness) at 2505 POLLARD RD",
        "DATE:08/06/2012",
        "TIME:15:24",
        "UNIT:STA66",
        "ID:322543",
        "CALL:General Illness",
        "ADDR:2505 POLLARD RD");

    doTest("T77",
        "(DA) 08-06-12 17:38: Station STA66 dispatched to Incident ID 322590 (Auto Accident) at 64 AND 181",
        "DATE:08/06/2012",
        "TIME:17:38",
        "UNIT:STA66",
        "ID:322590",
        "CALL:Auto Accident",
        "ADDR:64 AND 181");

    doTest("T78",
        "(DA) 08-06-12 18:32: Station STA66 dispatched to Incident ID 322610 (Structure Fire) at 806 N GREENO RD",
        "DATE:08/06/2012",
        "TIME:18:32",
        "UNIT:STA66",
        "ID:322610",
        "CALL:Structure Fire",
        "ADDR:806 N GREENO RD");

    doTest("T79",
        "(DA) 08-06-12 18:37: Station STA66 dispatched to Incident ID 322615 (General Illness) at 2301 POLLARD RD (36526)",
        "DATE:08/06/2012",
        "TIME:18:37",
        "UNIT:STA66",
        "ID:322615",
        "CALL:General Illness",
        "ADDR:2301 POLLARD RD");

    doTest("T80",
        "(DA) 08-07-12 09:34: Station STA66 dispatched to Incident ID 322791 (Back Pain) at 507 TRACE CROSSING",
        "DATE:08/07/2012",
        "TIME:09:34",
        "UNIT:STA66",
        "ID:322791",
        "CALL:Back Pain",
        "ADDR:507 TRACE CROSSING");

    doTest("T81",
        "(DA) 08-07-12 16:40: Station STA66 dispatched to Incident ID 322947 (Fall) at 10291 FIONN LOOP",
        "DATE:08/07/2012",
        "TIME:16:40",
        "UNIT:STA66",
        "ID:322947",
        "CALL:Fall",
        "ADDR:10291 FIONN LOOP");

    doTest("T82",
        "(DA) 08-08-12 09:16: Station STA66 dispatched to Incident ID 323184 (Fire Alarm) at 101 VILLA DR",
        "DATE:08/08/2012",
        "TIME:09:16",
        "UNIT:STA66",
        "ID:323184",
        "CALL:Fire Alarm",
        "ADDR:101 VILLA DR");

    doTest("T83",
        "(DA) 08-08-12 09:37: Station STA66 dispatched to Incident ID 323188 (Vehicle Fire) at US HWY 98 @ I 10",
        "DATE:08/08/2012",
        "TIME:09:37",
        "UNIT:STA66",
        "ID:323188",
        "CALL:Vehicle Fire",
        "ADDR:US HWY 98 & I 10",
        "MADDR:US 98 & I 10");

    doTest("T84",
        "(DA) 08-08-12 12:06: Station STA66 dispatched to Incident ID 323215 (Difficulty Breathing) at 11626 U S HWY 90 (0)",
        "DATE:08/08/2012",
        "TIME:12:06",
        "UNIT:STA66",
        "ID:323215",
        "CALL:Difficulty Breathing",
        "ADDR:11626 U S HWY 90");

    doTest("T85",
        "(DA) 08-08-12 15:36: Station STA66 dispatched to Incident ID 323304 (Fire Alarm) at 27440 13",
        "DATE:08/08/2012",
        "TIME:15:36",
        "UNIT:STA66",
        "ID:323304",
        "CALL:Fire Alarm",
        "ADDR:27440 RT 13");

    doTest("T86",
        "(DA) 08-08-12 15:41: Station STA66 dispatched to Incident ID 323308 (Unknown Medical) at 2200 EAST BAY DR",
        "DATE:08/08/2012",
        "TIME:15:41",
        "UNIT:STA66",
        "ID:323308",
        "CALL:Unknown Medical",
        "ADDR:2200 EAST BAY DR");

    doTest("T87",
        "(DA) 08-08-12 15:44: Station STA66 dispatched to Incident ID 323313 (Fall) at DAPHNE JAIL",
        "DATE:08/08/2012",
        "TIME:15:44",
        "UNIT:STA66",
        "ID:323313",
        "CALL:Fall",
        "ADDR:DAPHNE JAIL");

  }
  
  public static void main(String[] args) {
    new ALBaldwinCountyParserTest().generateTests("T1", "SRC DATE TIME UNIT ID CALL ADDR APT");
  }
}