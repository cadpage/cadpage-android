package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCHarnettCountyParserTest extends BaseParserTest {
  
  public NCHarnettCountyParserTest() {
    setParser(new NCHarnettCountyParser(), "HARNETT COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1102-012074*8326 NC 27 W***LILLINGTON***RESIDENTIAL STRUCTURE FIRE****1175****",
        "ID:1102-012074",
        "ADDR:8326 NC 27 W",
        "CITY:LILLINGTON",
        "CALL:RESIDENTIAL STRUCTURE FIRE");

    doTest("T2",
        "S: M:1107-061052*3058 CRAWFORD RD***ERWIN***MOTOR VEHICLE ACCIDENT****1186****\n",
        "ID:1107-061052",
        "ADDR:3058 CRAWFORD RD",
        "CITY:ERWIN",
        "CALL:MOTOR VEHICLE ACCIDENT");

    doTest("T3",
        "FRM:cadpage@harnett.org\nMSG:1108-070330*1995 BETHEL BAPTIST RD***SPRING LAKE***ELECTRICAL HAZARD****1120****",
        "ID:1108-070330",
        "ADDR:1995 BETHEL BAPTIST RD",
        "CITY:SPRING LAKE",
        "CALL:ELECTRICAL HAZARD");

    doTest("T4",
        "1109-079514*117 SCRANTON CT***CAMERON***EMS DEAD ON ARRIVAL CODE 3****1109****",
        "ID:1109-079514",
        "ADDR:117 SCRANTON CT",
        "CITY:CAMERON",
        "CALL:EMS DEAD ON ARRIVAL CODE 3");

    doTest("T5",
        "FRM:cadpage@harnett.org\nMSG:1111-092766*1 CLARK RD***LILLINGTON***MISC. FIRE****1175****",
        "ID:1111-092766",
        "ADDR:1 CLARK RD",
        "CITY:LILLINGTON",
        "CALL:MISC. FIRE");

    doTest("T6",
        "FRM:cadpage@harnett.org\nMSG:1111-093153*8030 RAY MEDE***SPRING LAKE***MUTUAL AID WITH OTHER COUNTY********",
        "ID:1111-093153",
        "ADDR:8030 RAY MEDE",
        "CITY:SPRING LAKE",
        "CALL:MUTUAL AID WITH OTHER COUNTY");

    doTest("T7",
        "FRM:cadpage@harnett.org\nMSG:1201-003613*2728 DARROCH RD*****FIRE OTHER*********",
        "ID:1201-003613",
        "ADDR:2728 DARROCH RD",
        "CALL:FIRE OTHER");

    doTest("T8",
        "FRM:cadpage@harnett.org\nMSG:1201-002111*11860 NC 210 S*****FIRE RES STR*********",
        "ID:1201-002111",
        "ADDR:11860 NC 210 S",
        "CALL:FIRE RES STR");

    doTest("T9",
        "1201-004551*11 BROOK LN*****EMS ABD PAIN*********",
        "ID:1201-004551",
        "ADDR:11 BROOK LN",
        "CALL:EMS ABD PAIN");

    doTest("T10",
        "FRM:cadpage@harnett.org\nMSG:1201-006955*2802 WALKER RD***LINDEN**FIRE RES STR*********",
        "ID:1201-006955",
        "ADDR:2802 WALKER RD",
        "CITY:LINDEN",
        "CALL:FIRE RES STR");

    doTest("T11",
        "1201-009149*1 YOUNG RD***ANGIER**FIRE ILLEGAL*********",
        "ID:1201-009149",
        "ADDR:1 YOUNG RD",
        "CITY:ANGIER",
        "CALL:FIRE ILLEGAL");

  }

  public static void main(String[] args) {
    new NCHarnettCountyParserTest().generateTests("T1");
  }
}
