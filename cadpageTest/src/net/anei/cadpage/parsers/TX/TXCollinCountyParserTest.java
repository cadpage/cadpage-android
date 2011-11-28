package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXCollinCountyParserTest extends BaseParserTest {
  
  public TXCollinCountyParserTest() {
    setParser(new TXCollinCountyParser(), "COLLIN COUNTY", "TX");
  }
  
  @Test
  public void testCCSOParser() {

    doTest("T1",
        "Message From Dispatch 11043265  MAJOR ACCIDENT 10/50  COUNTY ROAD 398  / COUNTY ROAD 447 IN COLLIN COUNTY  [CCSO DIST: 131 GRID: 1322]  UNITS: 1206 131B AMRF LCF1  ST RMK: 8K4  CFS RMK 16:24 CAR ON IT'S ROOF ON CR 398....UNK IF  {C (01/02)",
        "ID:11043265",
        "CALL:MAJOR ACCIDENT 10/50",
        "ADDR:COUNTY ROAD 398 & COUNTY ROAD 447",
        "SRC:CCSO",
        "MAP:1322",
        "UNIT:1206 131B AMRF LCF1",
        "INFO:8K4 / 16:24 CAR ON IT'S ROOF ON CR 398....UNK IF");

    doTest("T2",
        "Message From Dispatch 11039781  INJURED PERSON  2665 BRIAR TR IN COLLIN COUNTY  COUNTY ROAD 324  [CCSO DIST: 131 GRID: 1331]  UNITS: AMRP LCF1  ST RMK: 8H2  CFS RMK 13:54 RP HAS FALLEN AND AND INJURIED BOTH   {CAD003 14:01}",
        "ID:11039781",
        "CALL:INJURED PERSON",
        "ADDR:2665 BRIAR TR",
        "X:COUNTY ROAD 324",
        "SRC:CCSO",
        "MAP:1331",
        "UNIT:AMRP LCF1",
        "INFO:8H2 / 13:54 RP HAS FALLEN AND AND INJURIED BOTH");
   
  }
  
  @Test
  public void testLCFDParser() {

    doTest("T1",
        "11048794  FIRE PUBLIC ASSIST  2701 ASPEN CT IN COLLIN COUNTY  COUNTY ROAD 392  [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: 7K4  CFS RMK 22:10 REQ FD TO CHECK BP...40 YRO FEMALE.   {CAD001 22:13}",
        "ID:11048794",
        "CALL:FIRE PUBLIC ASSIST",
        "ADDR:2701 ASPEN CT",
        "X:COUNTY ROAD 392",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:LCF1",
        "INFO:7K4 / 22:10 REQ FD TO CHECK BP...40 YRO FEMALE.");

    doTest("T2",
        "11031079 First Responders 3274 Almeta LN in Collin County FM 546 [LCFD DIST: LCF1 GRID: 1331]",
        "ID:11031079",
        "CALL:First Responders",
        "ADDR:3274 Almeta LN",
        "X:FM 546",
        "SRC:LCFD",
        "MAP:1331");

    doTest("T3",
        "11047502 INJURED PERSON 3610 FM 546 IN COLLIN COUNTY COUNTY ROAD 398 / COUNTY RO;16AD 394 [LCFD DIST: LCF1 GRID: 1322] UNITS: AMRP LCF1 ST RMK: <NONE> CFS RMK 19:16 MALE SUB BLEEDING FROM HIS THROAT {CAD004 19:17}",
        "ID:11047502",
        "CALL:INJURED PERSON",
        "ADDR:3610 FM 546",
        "X:COUNTY ROAD 398 / COUNTY RO;16AD 394",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:AMRP LCF1",
        "INFO:<NONE> / 19:16 MALE SUB BLEEDING FROM HIS THROAT");

    doTest("T4",
        "11047405 FISRT RESPONDERS 2897 COUNTY ROAD 914 IN COLLIN COUNTY COUNTY ROAD 392 [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 AMRP ST RMK: DUTCH ACRES CFS RMK 12:59 68 YOA FALLEN IN FRONT YARD UNABLE T {CAD001 13:00}",
        "ID:11047405",
        "CALL:FISRT RESPONDERS",
        "ADDR:2897 COUNTY ROAD 914",
        "X:COUNTY ROAD 392",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:LCF1 AMRP",
        "INFO:DUTCH ACRES / 12:59 68 YOA FALLEN IN FRONT YARD UNABLE T");

    doTest("T5",
        "11046597 MAJOR ACCIDENT 10/50 COUNTY ROAD 393 / FM 546 IN COLLIN COUNTY [LCFD DIST: LCF1 GRID: 1322] UNITS: LCF1 ST RMK: 8J1 CFS RMK 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK {CAD004 21:40}",
        "ID:11046597",
        "CALL:MAJOR ACCIDENT 10 /",
        "ADDR:50 COUNTY ROAD 393 & FM 546",
        "MADDR:COUNTY ROAD 393 & FM 546",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:LCF1",
        "INFO:8J1 / 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK");

    doTest("T6",
        "11044587 FIRST RESPONDERS 730 CROSS TIMBERS DR IN LOWRY CROSSING CROSS TRAIL LN [LCFD DIST: LCF1 GRID: 3100] UNITS: LCF1 AMRP ST RMK: <NONE> CFS RMK 13:14 37 YOA MALE / FELL YESTERDAY AND IS {CAD004 13:14}",
        "ID:11044587",
        "CALL:FIRST RESPONDERS",
        "ADDR:730 CROSS TIMBERS DR",
        "CITY:LOWRY CROSSING",
        "X:CROSS TRAIL LN",
        "SRC:LCFD",
        "MAP:3100",
        "UNIT:LCF1 AMRP",
        "INFO:<NONE> / 13:14 37 YOA MALE / FELL YESTERDAY AND IS");

    doTest("T7",
        "11056387  TRASH FIRE  2701 PECAN CT IN COLLIN COUNTY  COUNTY ROAD 392  [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: <NONE>  CFS RMK 15:09 8 HOUSES DOWN  ITEMS LEFT OVER FR A   {CAD004 15:09}",
        "ID:11056387",
        "CALL:TRASH FIRE",
        "ADDR:2701 PECAN CT",
        "X:COUNTY ROAD 392",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:LCF1",
        "INFO:<NONE> / 15:09 8 HOUSES DOWN");

    doTest("T8",
        "11055307  MEDICATION OVERDOSE  415 S BRIDGEFARMER RD IN LOWRY CROSSING  E US HIGHWAY 380 / COUNTY ROAD 403  [LCFD DIST: LCF1 GRID: 3100]  UNITS: LCF2  ST RMK: 10J3  CFS RMK 19:34 36 YOA FEMALE TOOK SOMETYPE OF SLEEP  {CAD004 19:35}",
        "ID:11055307",
        "CALL:MEDICATION OVERDOSE",
        "ADDR:415 S BRIDGEFARMER RD",
        "CITY:LOWRY CROSSING",
        "X:E US HIGHWAY 380 / COUNTY ROAD 403",
        "SRC:LCFD",
        "MAP:3100",
        "UNIT:LCF2",
        "INFO:10J3 / 19:34 36 YOA FEMALE TOOK SOMETYPE OF SLEEP");

    doTest("T9",
        "11044930  FIRST RESPONDERS  3737 E UNIVERSITY DR IN COLLIN COUNTY  COUNTY ROAD 407 / COUNTY ROAD 404  [LCFD DIST: LCF1 GRID: 1211]  UNITS: LCF1  ST RMK: <NONE>  CFS RMK 17:52 7 YOA FEMALE WITH ABDOMINAL PAINS///  {CAD004 17:52}",
        "ID:11044930",
        "CALL:FIRST RESPONDERS",
        "ADDR:3737 E UNIVERSITY DR",
        "X:COUNTY ROAD 407 / COUNTY ROAD 404",
        "SRC:LCFD",
        "MAP:1211",
        "UNIT:LCF1",
        "INFO:<NONE> / 17:52 7 YOA FEMALE WITH ABDOMINAL PAINS///");

    doTest("T10",
        "11046597  MAJOR ACCIDENT 10/50  COUNTY ROAD 393  /  FM 546 IN COLLIN COUNTY [LCFD DIST: LCF1 GRID: 1322]  UNITS: LCF1  ST RMK: 8J1  CFS RMK 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK  {CAD004 21:40}",
        "ID:11046597",
        "CALL:MAJOR ACCIDENT 10/50",
        "ADDR:COUNTY ROAD 393 & FM 546",
        "SRC:LCFD",
        "MAP:1322",
        "UNIT:LCF1",
        "INFO:8J1 / 21:40 SOMEONE HAS FALLEN OUT OF A TRUCK");

  }
  
  @Test
  public void testBRFDParser() {

    doTest("T1",
        "11056128  GRASS FIRE  10753 COUNTY ROAD 903 IN COLLIN COUNTY  COUNTY ROAD 902  UNITS: BRF1  ST RMK: <NONE>  CFS RMK 21:52 RIGHT ON",
        "ID:11056128",
        "CALL:GRASS FIRE",
        "ADDR:10753 COUNTY ROAD 903",
        "X:COUNTY ROAD 902",
        "UNIT:BRF1",
        "INFO:<NONE> / 21:52 RIGHT ON");
  
  }
  
  public static void main(String[] args) {
    new TXCollinCountyParserTest().generateTests("T7", "ID CALL ADDR CITY X SRC MAP UNIT INFO");
  }
}
