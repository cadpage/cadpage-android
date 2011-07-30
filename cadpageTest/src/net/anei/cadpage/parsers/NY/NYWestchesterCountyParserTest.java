package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYWestchesterCountyParserTest extends BaseParserTest {
  
  public NYWestchesterCountyParserTest() {
    setParser(new NYWestchesterCountyParser(), "WESTCHESTER COUNTY", "NY");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "Subject:IPage\n50 ELKAN RD MAMARONECK_T: @ELKAN APARTMENTS, Cross: PALMER AVE, Type:ALS, , Time out: 12:12:51 Area: LARCH,Alarm lev: 0 ,Comments:   DIFF BREATHING",
        "ADDR:50 ELKAN RD",
        "CITY:LARCHMONT",
        "PLACE:ELKAN APARTMENTS",
        "X:PALMER AVE",
        "CALL:ALS",
        "INFO:DIFF BREATHING");

    doTest("T2",
        "Subject:IPage\nMAMARONECK_T: @I95 NB 07.1 EXIT 17 (CHATSWORTH AVE), Cross: , Type:MVA, INJURIES, Time out: 11:03:47 Area: LARCH,Alarm",
        "ADDR:I95 NB 07.1 EXIT 17 (CHATSWORTH AVE)",
        "CITY:LARCHMONT",
        "CALL:MVA / INJURIES");

    doTest("T3",
        "Subject:IPage\n30 HALSTEAD PL RYE, Cross: ORMOND PL, Type:STRU, , Time out: 21:00:33 Area: RYE,Alarm lev: 1 ,Comments:   WPH1",
        "ADDR:30 HALSTEAD PL",
        "CITY:RYE",
        "X:ORMOND PL",
        "CALL:STRU",
        "INFO:WPH1");

    doTest("T4",
        "Subject:IPage\nMADISON AVE/JEFFERSON ST MAMARONECK_T, Cross: MADISON AVE, Type:HAZARD, FLUID, Time out: 14:30:33 Area: MAMTW,Alarm",
        "ADDR:MADISON AVE & JEFFERSON ST",
        "CITY:MAMARONECK",
        "X:MADISON AVE",
        "CALL:HAZARD / FLUID");

    doTest("T5",
        "Subject:IPage\n35 N CHATSWORTH AVE MAMARONECK_T: @CARLTON HOUSE APARTMENTS, Cross: JEFFERSON ST, Type:ALARM, COMM, Time out: 19:27:55",
        "ADDR:35 N CHATSWORTH AVE",
        "CITY:MAMARONECK",
        "PLACE:CARLTON HOUSE APARTMENTS",
        "X:JEFFERSON ST",
        "CALL:ALARM / COMM");

    doTest("T6",
        "Subject:IPage\n280 WEAVER ST MAMARONECK_T: @ST JOHN & PAUL SCHOOL, Cross: EDGEWOOD AVE, Type:ALARM, COMM, Time out: 23:48:57 Area: MAMTW,Alarm lev: 0 ,Comments:   GENERAL FIRE ALARM",
        "ADDR:280 WEAVER ST",
        "CITY:MAMARONECK",
        "PLACE:ST JOHN & PAUL SCHOOL",
        "X:EDGEWOOD AVE",
        "CALL:ALARM / COMM",
        "INFO:GENERAL FIRE ALARM");

    doTest("T7",
        "Subject:IPage\n833 FENIMORE RD MAMARONECK_T, Cross: MOHEGAN RD, Type:ALARM, CO, Time out: 13:39:20 Area: MAMTW,Alarm lev: 0",
        "ADDR:833 FENIMORE RD",
        "CITY:MAMARONECK",
        "X:MOHEGAN RD",
        "CALL:ALARM / CO");

    doTest("T8",
        "Subject:IPage\n35 N CHATSWORTH AVE MAMARONECK_T: @CARLTON HOUSE APARTMENTS:APT 3W, Cross: JEFFERSON ST, Type:ALS, , Time out:",
        "ADDR:35 N CHATSWORTH AVE",
        "CITY:MAMARONECK",
        "PLACE:CARLTON HOUSE APARTMENTS",
        "APT:3W",
        "X:JEFFERSON ST",
        "CALL:ALS");

    doTest("T9",
        "(IPage) 2 PRINCE WILLOW LN MAMARONECK_T, Cross: OLD WHITE PLAINS RD, Type:SERVICE, WATER, Time out: 17:22:17 Area: MAMTW,Alarm lev: 0 ,Comments:   WATER CONDITION",
        "ADDR:2 PRINCE WILLOW LN",
        "CITY:MAMARONECK",
        "X:OLD WHITE PLAINS RD",
        "CALL:SERVICE / WATER",
        "INFO:WATER CONDITION");
  }
  
  @Test
  public void testParserFail() {
    doBadTest("Subject:IPage\n-073.684659 +040.978189   Duplicate Event:Location = HALSTEAD PL/ORMOND PL, Cross Street 1 = HALSTEAD PL   GARAGE FIRE   ORMOND PL, Cross Street 2 = ORMOND PL,");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "IPage / 4 DUDLEY LN MAMARONECK_T, Cross: FENIMORE RD, Type:ALARM, RESD, Time out: 09:42:46 Area: MAMTW,Alarm lev: 0 ,Comments:",
        "ADDR:4 DUDLEY LN",
        "CITY:MAMARONECK",
        "X:FENIMORE RD",
        "CALL:ALARM / RESD");

    doTest("T2",
        "IPage / 50 ELKAN RD MAMARONECK_T: @ELKAN APARTMENTS, Cross: PALMER AVE, Type:ALS, , Time out: 12:12:51 Area: LARCH,Alarm lev:",
        "ADDR:50 ELKAN RD",
        "CITY:LARCHMONT",
        "PLACE:ELKAN APARTMENTS",
        "X:PALMER AVE",
        "CALL:ALS");

    doTest("T3",
        "IPage / MAMARONECK_T: @I95 NB 07.3, Cross: , Type:MVF, CAR, Time out: 22:12:12 Area: MAMTW,Alarm lev: 0 ,Comments:",
        "ADDR:I95 NB 07.3",
        "CITY:MAMARONECK",
        "CALL:MVF / CAR");

    doTest("T4",
        "IPage / MAMARONECK_T: @I95 NB 07.1 EXIT 17 (CHATSWORTH AVE), Cross: , Type:MVA, INJURIES, Time out: 11:03:47 Area: LARCH,Alarm",
        "ADDR:I95 NB 07.1 EXIT 17 (CHATSWORTH AVE)",
        "CITY:LARCHMONT",
        "CALL:MVA / INJURIES");

    doTest("T5",
        "IPage / 42 MAPLEWOOD ST MAMARONECK_T, Cross: MURRAY AVE, Type:SERVICE, LOCKOUT, Time out: 17:27:08 Area: MAMTW,Alarm lev: 0",
        "ADDR:42 MAPLEWOOD ST",
        "CITY:MAMARONECK",
        "X:MURRAY AVE",
        "CALL:SERVICE / LOCKOUT");

    doTest("T6",
        "IPage / 30 HALSTEAD PL RYE, Cross: ORMOND PL, Type:STRU, , Time out: 21:00:33 Area: RYE,Alarm lev: 1 ,Comments:   WPH1",
        "ADDR:30 HALSTEAD PL",
        "CITY:RYE",
        "X:ORMOND PL",
        "CALL:STRU",
        "INFO:WPH1");

    doTest("T7",
        "Subject:IPage\n15 MADISON AVE MAMARONECK_T: @NEW YORK SPORTS CLUB, Cross: BYRON PL, Type:ALS, , Time out: 15:34:49 Area: LARCH,Alarm lev: 0 ,Comments:   KNOX BOX ON PREMISE   DISLOCATED SHOULDER",
        "ADDR:15 MADISON AVE",
        "CITY:LARCHMONT",
        "PLACE:NEW YORK SPORTS CLUB",
        "X:BYRON PL",
        "CALL:ALS",
        "INFO:KNOX BOX ON PREMISE   DISLOCATED SHOULDER");
    
  }
  
  @Test
  public void testParser3() {
    doTest("T1",
        "(IPage) 21 HEMLOCK HILLS NEW_CASTLE, Cross: HILLTOP DR, Type:STRU, , Time out: 17:39:49 Area: MILLW,Alarm lev: 0 ,Comments:",
        "ADDR:21 HEMLOCK HILLS",
        "CITY:MILLWOOD",
        "X:HILLTOP DR",
        "CALL:STRU");
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "(IPage) 2365 BOSTON POST RD LARCHMONT, Cross: DEANE PL, Type:MVA, INJURIES, Time out: 19:23:17 Area: LARCH,Alarm lev: 0",
        "ADDR:2365 BOSTON POST RD",
        "CITY:LARCHMONT",
        "X:DEANE PL",
        "CALL:MVA / INJURIES");
  }
  
  public static void main(String[] args) {
    new NYWestchesterCountyParserTest().generateTests("T1");
  }
}