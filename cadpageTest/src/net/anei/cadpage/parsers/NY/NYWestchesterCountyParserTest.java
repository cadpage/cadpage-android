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
    
  }
  
  public static void main(String[] args) {
    new NYWestchesterCountyParserTest().generateTests("T1");
  }
}