package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Garrett County, MD
Contact: Active911
Agency name: Garrett County Public Safety
Location: Oakland, MD, United States
Sender: garrettco911@garrettcounty.org

SEIZURES STA3 () Loc:1202 HOYES SANG RUN RD Rcvd: 12:36:57 Units: STA3 CA2012017412 Comments:  
STROKE / CVA STA9 () Loc:1113 MARY DR Rcvd: 00:5:33 Units: 9A1 CA2012017399 Comments: 11/24/2012 00:05:40 FAR EAST WING 
MVC / INJURIES STA3 () Loc:24541 GARRETT HWY [@SUSQUEHANNA BANK Rcvd: 12:16:29 Units: 3A1 CA2012017367 Comments:  
MEDICAL EMERGENCY STA3 () Loc:949 OLD RIVER RD [#E2  Rcvd: 08:9:53 Units: 3A1 CA2012017355 Comments:  
(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:BULLDOZER RD, GRANT CO Rcvd: 22:52:5 Comments:  
MEDIC ASSIST STA9 () Loc:BULLDOZER RD, GRANT CO Rcvd: 22:45:21 Units: 9A1 CA2012017347 Comments: 11/22/2012 22:44:54 FULL CREW NEEDED--CARDIAC ARREST 
(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:101 E WATER ST [#2 Rcvd: 21:27:14 Comments:  
DIFFICULTY BREATHING STA9 () Loc:101 E WATER ST [#2 Rcvd: 21:21:20 Units: 9A1 CA2012017342 Comments: 11/22/2012 21:21:02 ST-9 NEEDS FULL CREW 
(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:KITZMILLER RD Rcvd: 18:48:37 Comments:  
MEDIC ASSIST STA9 () Loc:KITZMILLER RD Rcvd: 18:40:36 Units: 9A1 CA2012017336 Comments: 11/22/2012 18:40:32 FULL CREW NEEDED 
MVC / INJURIES STA9 () Loc:HERRINGTON MANOR RD & FINGERBOARD RD Rcvd: 15:7:35 Units: 9A1 CA2012017320 Comments:  
LIFT ASSIST STA9 () Loc:804 WINTER PL Rcvd: 13:36:59 Units: 9A1 CA2012017315 Comments:  
MVC / UNK INJURIES STA9 () Loc:GORMAN RD & WAYNE HARVEY RD Rcvd: 12:56:34 Units: 9A1 CA2012017310 Comments:  
MEDICAL EMERGENCY STA9 () Loc:704 RHODODENDRON DR Rcvd: 09:53:28 Units: 9A1 CA2012017306 Comments:  
MEDICAL ALARM STA9 () Loc:504 L ST Rcvd: 08:15:35 Units: 9A1 CA2012017304 Comments: 11/22/2012 08:15:28 80 YO F NOT FEELING WELL  
EMOTIONAL PROBLEM STA9 () Loc:607 P ST [@MEADOW WOODS EAST Rcvd: 02:27:41 Units: 9A1 CA2012017298 Comments:  
FLUE FIRE STA9 () Loc:770 TANNERY RD Rcvd: 23:0:20 Units: 9A1 CA2012017293 Comments:  
MEDICAL EMERGENCY STA9 () Loc:1401 BROADFORD RD Rcvd: 22:24:44 Units: 9A1 CA2012017292 Comments: 11/21/2012 22:24:22 FULL CREW NEEDED 
MOTOR VEHICLE CRASH STA9 () Loc:GEORGE WASHINGTON HWY & MASON SCHOOL RD Rcvd: 15:14:48 Units: 9A1 CA2012017221 Comments:  
MEDICAL EMERGENCY STA9 () Loc:3748 GORMAN RD Rcvd: 13:30:40 Units: 9A1 CA2012017214 Comments:  
FALL INJURY STA9 () Loc:823 E GREEN ST Rcvd: 09:10:13 Units: 9A1 CA2012017201 Comments:  
EMOTIONAL PROBLEM STA9 () Loc:607 P ST [@MEADOW WOODS EAST Rcvd: 23:56:9 Units: 9A1 CA2012017191 Comments:  
MEDICAL EMERGENCY STA9 () Loc:LIBERTY SQ #8 Rcvd: 20:49:59 Units: 9A1 CA2012017187 Comments:  
MEDICAL EMERGENCY STA9 () Loc:110 A ST Rcvd: 16:47:39 Units: 9A1 CA2012017177 Comments: 11/20/2012 16:47:43 9A1 D 
DIFFICULTY BREATHING STA9 () Loc:4711 KITZMILLER RD Rcvd: 12:52:35 Units: 9A1 CA2012017158 Comments:  
MEDICAL EMERGENCY STA9 () Loc:6002 GEORGE WASHINGTON HWY Rcvd: 10:9:36 Units: 9A1 CA2012017152 Comments:  
(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:265 GLASS DR Rcvd: 22:11:39 Comments:  
SMOKE IN BUILDING STA9 () Loc:265 GLASS DR Rcvd: 22:1:25 Units: 9A2 CA2012017136 Comments:  
FALL INJURY STA9 () Loc:108 DECATUR ST [@PARKWOOD VIL EAST# 32 Rcvd: 21:52:44 Units: 9A1 CA2012017135 Comments:  
DIABETIC EMERGENCY STA9 () Loc:20 E OAK ST Rcvd: 20:11:0 Units: 9A1 CA2012017129 Comments:  

*/

public class MDGarrettCountyParserTest extends BaseParserTest {
  
  public MDGarrettCountyParserTest() {
    setParser(new MDGarrettCountyParser(), "GARRETT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SEIZURES STA3 () Loc:1202 HOYES SANG RUN RD Rcvd: 12:36:57 Units: STA3 CA2012017412 Comments:  ",
        "CALL:SEIZURES STA3",
        "ADDR:1202 HOYES SANG RUN RD",
        "TIME:12:36:57",
        "UNIT:STA3",
        "ID:CA2012017412");

    doTest("T2",
        "STROKE / CVA STA9 () Loc:1113 MARY DR Rcvd: 00:5:33 Units: 9A1 CA2012017399 Comments: 11/24/2012 00:05:40 FAR EAST WING ",
        "CALL:STROKE / CVA STA9",
        "ADDR:1113 MARY DR",
        "TIME:00:5:33",
        "UNIT:9A1",
        "ID:CA2012017399",
        "INFO:11/24/2012 00:05:40 FAR EAST WING");

    doTest("T3",
        "MVC / INJURIES STA3 () Loc:24541 GARRETT HWY [@SUSQUEHANNA BANK Rcvd: 12:16:29 Units: 3A1 CA2012017367 Comments:  ",
        "CALL:MVC / INJURIES STA3",
        "ADDR:24541 GARRETT HWY",
        "PLACE:SUSQUEHANNA BANK",
        "TIME:12:16:29",
        "UNIT:3A1",
        "ID:CA2012017367");

    doTest("T4",
        "MEDICAL EMERGENCY STA3 () Loc:949 OLD RIVER RD [#E2  Rcvd: 08:9:53 Units: 3A1 CA2012017355 Comments:  ",
        "CALL:MEDICAL EMERGENCY STA3",
        "ADDR:949 OLD RIVER RD",
        "APT:E2",
        "TIME:08:9:53",
        "UNIT:3A1",
        "ID:CA2012017355");

    doTest("T5",
        "(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:BULLDOZER RD, GRANT CO Rcvd: 22:52:5 Comments:  ",
        "CALL:SECOND ALERT STA9",
        "ADDR:BULLDOZER RD",
        "CITY:GRANT COUNTY",
        "ST:WV",
        "TIME:22:52:5");

    doTest("T6",
        "MEDIC ASSIST STA9 () Loc:BULLDOZER RD, GRANT CO Rcvd: 22:45:21 Units: 9A1 CA2012017347 Comments: 11/22/2012 22:44:54 FULL CREW NEEDED--CARDIAC ARREST ",
        "CALL:MEDIC ASSIST STA9",
        "ADDR:BULLDOZER RD",
        "CITY:GRANT COUNTY",
        "ST:WV",
        "TIME:22:45:21",
        "UNIT:9A1",
        "ID:CA2012017347",
        "INFO:11/22/2012 22:44:54 FULL CREW NEEDED--CARDIAC ARREST");

    doTest("T7",
        "(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:101 E WATER ST [#2 Rcvd: 21:27:14 Comments:  ",
        "CALL:SECOND ALERT STA9",
        "ADDR:101 E WATER ST",
        "APT:2",
        "TIME:21:27:14");

    doTest("T8",
        "DIFFICULTY BREATHING STA9 () Loc:101 E WATER ST [#2 Rcvd: 21:21:20 Units: 9A1 CA2012017342 Comments: 11/22/2012 21:21:02 ST-9 NEEDS FULL CREW ",
        "CALL:DIFFICULTY BREATHING STA9",
        "ADDR:101 E WATER ST",
        "APT:2",
        "TIME:21:21:20",
        "UNIT:9A1",
        "ID:CA2012017342",
        "INFO:11/22/2012 21:21:02 ST-9 NEEDS FULL CREW");

    doTest("T9",
        "(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:KITZMILLER RD Rcvd: 18:48:37 Comments:  ",
        "CALL:SECOND ALERT STA9",
        "ADDR:KITZMILLER RD",
        "TIME:18:48:37");

    doTest("T10",
        "MEDIC ASSIST STA9 () Loc:KITZMILLER RD Rcvd: 18:40:36 Units: 9A1 CA2012017336 Comments: 11/22/2012 18:40:32 FULL CREW NEEDED ",
        "CALL:MEDIC ASSIST STA9",
        "ADDR:KITZMILLER RD",
        "TIME:18:40:36",
        "UNIT:9A1",
        "ID:CA2012017336",
        "INFO:11/22/2012 18:40:32 FULL CREW NEEDED");

    doTest("T11",
        "MVC / INJURIES STA9 () Loc:HERRINGTON MANOR RD & FINGERBOARD RD Rcvd: 15:7:35 Units: 9A1 CA2012017320 Comments:  ",
        "CALL:MVC / INJURIES STA9",
        "ADDR:HERRINGTON MANOR RD & FINGERBOARD RD",
        "TIME:15:7:35",
        "UNIT:9A1",
        "ID:CA2012017320");

    doTest("T12",
        "LIFT ASSIST STA9 () Loc:804 WINTER PL Rcvd: 13:36:59 Units: 9A1 CA2012017315 Comments:  ",
        "CALL:LIFT ASSIST STA9",
        "ADDR:804 WINTER PL",
        "TIME:13:36:59",
        "UNIT:9A1",
        "ID:CA2012017315");

    doTest("T13",
        "MVC / UNK INJURIES STA9 () Loc:GORMAN RD & WAYNE HARVEY RD Rcvd: 12:56:34 Units: 9A1 CA2012017310 Comments:  ",
        "CALL:MVC / UNK INJURIES STA9",
        "ADDR:GORMAN RD & WAYNE HARVEY RD",
        "TIME:12:56:34",
        "UNIT:9A1",
        "ID:CA2012017310");

    doTest("T14",
        "MEDICAL EMERGENCY STA9 () Loc:704 RHODODENDRON DR Rcvd: 09:53:28 Units: 9A1 CA2012017306 Comments:  ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:704 RHODODENDRON DR",
        "TIME:09:53:28",
        "UNIT:9A1",
        "ID:CA2012017306");

    doTest("T15",
        "MEDICAL ALARM STA9 () Loc:504 L ST Rcvd: 08:15:35 Units: 9A1 CA2012017304 Comments: 11/22/2012 08:15:28 80 YO F NOT FEELING WELL  ",
        "CALL:MEDICAL ALARM STA9",
        "ADDR:504 L ST",
        "TIME:08:15:35",
        "UNIT:9A1",
        "ID:CA2012017304",
        "INFO:11/22/2012 08:15:28 80 YO F NOT FEELING WELL");

    doTest("T16",
        "EMOTIONAL PROBLEM STA9 () Loc:607 P ST [@MEADOW WOODS EAST Rcvd: 02:27:41 Units: 9A1 CA2012017298 Comments:  ",
        "CALL:EMOTIONAL PROBLEM STA9",
        "ADDR:607 P ST",
        "PLACE:MEADOW WOODS EAST",
        "TIME:02:27:41",
        "UNIT:9A1",
        "ID:CA2012017298");

    doTest("T17",
        "FLUE FIRE STA9 () Loc:770 TANNERY RD Rcvd: 23:0:20 Units: 9A1 CA2012017293 Comments:  ",
        "CALL:FLUE FIRE STA9",
        "ADDR:770 TANNERY RD",
        "TIME:23:0:20",
        "UNIT:9A1",
        "ID:CA2012017293");

    doTest("T18",
        "MEDICAL EMERGENCY STA9 () Loc:1401 BROADFORD RD Rcvd: 22:24:44 Units: 9A1 CA2012017292 Comments: 11/21/2012 22:24:22 FULL CREW NEEDED ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:1401 BROADFORD RD",
        "TIME:22:24:44",
        "UNIT:9A1",
        "ID:CA2012017292",
        "INFO:11/21/2012 22:24:22 FULL CREW NEEDED");

    doTest("T19",
        "MOTOR VEHICLE CRASH STA9 () Loc:GEORGE WASHINGTON HWY & MASON SCHOOL RD Rcvd: 15:14:48 Units: 9A1 CA2012017221 Comments:  ",
        "CALL:MOTOR VEHICLE CRASH STA9",
        "ADDR:GEORGE WASHINGTON HWY & MASON SCHOOL RD",
        "TIME:15:14:48",
        "UNIT:9A1",
        "ID:CA2012017221");

    doTest("T20",
        "MEDICAL EMERGENCY STA9 () Loc:3748 GORMAN RD Rcvd: 13:30:40 Units: 9A1 CA2012017214 Comments:  ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:3748 GORMAN RD",
        "TIME:13:30:40",
        "UNIT:9A1",
        "ID:CA2012017214");

    doTest("T21",
        "FALL INJURY STA9 () Loc:823 E GREEN ST Rcvd: 09:10:13 Units: 9A1 CA2012017201 Comments:  ",
        "CALL:FALL INJURY STA9",
        "ADDR:823 E GREEN ST",
        "TIME:09:10:13",
        "UNIT:9A1",
        "ID:CA2012017201");

    doTest("T22",
        "EMOTIONAL PROBLEM STA9 () Loc:607 P ST [@MEADOW WOODS EAST Rcvd: 23:56:9 Units: 9A1 CA2012017191 Comments:  ",
        "CALL:EMOTIONAL PROBLEM STA9",
        "ADDR:607 P ST",
        "PLACE:MEADOW WOODS EAST",
        "TIME:23:56:9",
        "UNIT:9A1",
        "ID:CA2012017191");

    doTest("T23",
        "MEDICAL EMERGENCY STA9 () Loc:LIBERTY SQ #8 Rcvd: 20:49:59 Units: 9A1 CA2012017187 Comments:  ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:LIBERTY SQ",
        "APT:8",
        "TIME:20:49:59",
        "UNIT:9A1",
        "ID:CA2012017187");

    doTest("T24",
        "MEDICAL EMERGENCY STA9 () Loc:110 A ST Rcvd: 16:47:39 Units: 9A1 CA2012017177 Comments: 11/20/2012 16:47:43 9A1 D ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:110 A ST",
        "TIME:16:47:39",
        "UNIT:9A1",
        "ID:CA2012017177",
        "INFO:11/20/2012 16:47:43 9A1 D");

    doTest("T25",
        "DIFFICULTY BREATHING STA9 () Loc:4711 KITZMILLER RD Rcvd: 12:52:35 Units: 9A1 CA2012017158 Comments:  ",
        "CALL:DIFFICULTY BREATHING STA9",
        "ADDR:4711 KITZMILLER RD",
        "TIME:12:52:35",
        "UNIT:9A1",
        "ID:CA2012017158");

    doTest("T26",
        "MEDICAL EMERGENCY STA9 () Loc:6002 GEORGE WASHINGTON HWY Rcvd: 10:9:36 Units: 9A1 CA2012017152 Comments:  ",
        "CALL:MEDICAL EMERGENCY STA9",
        "ADDR:6002 GEORGE WASHINGTON HWY",
        "TIME:10:9:36",
        "UNIT:9A1",
        "ID:CA2012017152");

    doTest("T27",
        "(Notification - STA9 - SECOND ALERT) (5) SECOND ALERT STA9 () Loc:265 GLASS DR Rcvd: 22:11:39 Comments:  ",
        "CALL:SECOND ALERT STA9",
        "ADDR:265 GLASS DR",
        "TIME:22:11:39");

    doTest("T28",
        "SMOKE IN BUILDING STA9 () Loc:265 GLASS DR Rcvd: 22:1:25 Units: 9A2 CA2012017136 Comments:  ",
        "CALL:SMOKE IN BUILDING STA9",
        "ADDR:265 GLASS DR",
        "TIME:22:1:25",
        "UNIT:9A2",
        "ID:CA2012017136");

    doTest("T29",
        "FALL INJURY STA9 () Loc:108 DECATUR ST [@PARKWOOD VIL EAST# 32 Rcvd: 21:52:44 Units: 9A1 CA2012017135 Comments:  ",
        "CALL:FALL INJURY STA9",
        "ADDR:108 DECATUR ST",
        "PLACE:PARKWOOD VIL EAST",
        "APT:32",
        "TIME:21:52:44",
        "UNIT:9A1",
        "ID:CA2012017135");

    doTest("T30",
        "DIABETIC EMERGENCY STA9 () Loc:20 E OAK ST Rcvd: 20:11:0 Units: 9A1 CA2012017129 Comments:  ",
        "CALL:DIABETIC EMERGENCY STA9",
        "ADDR:20 E OAK ST",
        "TIME:20:11:0",
        "UNIT:9A1",
        "ID:CA2012017129");

  }
  
  public static void main(String args[]) {
    new MDGarrettCountyParserTest().generateTests("T1");
  }
}