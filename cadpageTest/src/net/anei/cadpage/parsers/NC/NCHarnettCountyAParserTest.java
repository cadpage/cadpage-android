package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Harnett County, NC
Contact: Beverly Williams <bwilliams.co9@gmail.com>
Contact: Keith combs <keithcombs2007@gmail.com>
Contact: Michael Moston <mikemoston@gmail.com>
Contact: edward woodall <ewoodall1971@gmail.com>
Sender: cadpage@harnett.org

1102-012074*8326 NC 27 W***LILLINGTON***RESIDENTIAL STRUCTURE FIRE****1175****
S: M:1107-061052*3058 CRAWFORD RD***ERWIN***MOTOR VEHICLE ACCIDENT****1186****\n
FRM:cadpage@harnett.org\nMSG:1108-070330*1995 BETHEL BAPTIST RD***SPRING LAKE***ELECTRICAL HAZARD****1120****
1109-079514*117 SCRANTON CT***CAMERON***EMS DEAD ON ARRIVAL CODE 3****1109****

Contact: Chris McCormick <mac3295@gmail.com>
FRM:cadpage@harnett.org\nMSG:1111-092766*1 CLARK RD***LILLINGTON***MISC. FIRE****1175****
FRM:cadpage@harnett.org\nMSG:1111-093153*8030 RAY MEDE***SPRING LAKE***MUTUAL AID WITH OTHER COUNTY********
FRM:cadpage@harnett.org\nMSG:1201-003613*2728 DARROCH RD*****FIRE OTHER*********
FRM:cadpage@harnett.org\nMSG:1201-002111*11860 NC 210 S*****FIRE RES STR*********

Contact: Roy Gibbs <boham29@gmail.com>
B1201-004551*11 BROOK LN*****EMS ABD PAIN*********
1201-009149*1 YOUNG RD***ANGIER**FIRE ILLEGAL*********
1202-010125*1101 SILAS MOORE RD***BENSON**EMS SICK*********
1202-010135*51 ELLIE CT***FUQUAY VARINA**FIRE RES STR*********

Contact: Chris McCormick <mac3295@gmail.com>
FRM:cadpage@harnett.org\nMSG:1201-006955*2802 WALKER RD***LINDEN**FIRE RES STR*********

Contact: Roy Gibbs <boham29@gmail.com>
1202-017757*137 MERCHANT DR***ANGIER**EMS BACK PN*******Hazards: No**

Contact: Ryan Davis <hemifreak16@gmail.com>
1203-021836*DARK WOOD DR***SPRING LAKE**FIRE SMO INV*******Hazards: No**

Contact: Jeff Johnson <rfdjjohnson@gmail.com>
1112-103007*2915 MATTHEWS MILL POND RD***ANGIER***MOTOR VEHICLE ACCIDENT****1143****

Contact: Keith Pollard <keithluvs2fish@gmail.com>
Sender: cadpage@harnett.org
1210-092849*460 BAILEY RD***COATS*RED HILL CHURCH RD (*KELLY LN***EMS BREATHIN*******Hazards: No**
1210-092971*130 E MCIVER ST***ANGIER**S POPLAR ST***FIRE ALARM C*******Hazards: No**

Contact: Ethan Hardison <ehardison870@gmail.com>
Sender: cadpage@harnett.org
FRM:cadpage@harnett.org\nMSG:1210-093840*9090 NC 210 S***BUNNLEVEL*SOUTH HARNETT LN*ANDERSON CREEK SCHOOL RD***MVA*********

Contact: allenja@embarqmail.com <allenja@embarqmail.com>
Sender: cadpage@harnett.org
1308-071722*688 CIRCLE DR***ANGIER*APRIL CT*BOWDEN FAMILY LN***FIRE RES STR*******Hazards: No**

*/

public class NCHarnettCountyAParserTest extends BaseParserTest {
  
  public NCHarnettCountyAParserTest() {
    setParser(new NCHarnettCountyAParser(), "HARNETT COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1102-012074*8326 NC 27 W***LILLINGTON***RESIDENTIAL STRUCTURE FIRE****1175****",
        "ID:1102-012074",
        "ADDR:8326 NC 27 W",
        "MADDR:8326 STATE 27 W",
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
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "FRM:cadpage@harnett.org\nMSG:1111-092766*1 CLARK RD***LILLINGTON***MISC. FIRE****1175****",
        "ID:1111-092766",
        "ADDR:1 CLARK RD",
        "CITY:LILLINGTON",
        "CALL:MISC. FIRE");

    doTest("T2",
        "FRM:cadpage@harnett.org\nMSG:1111-093153*8030 RAY MEDE***SPRING LAKE***MUTUAL AID WITH OTHER COUNTY********",
        "ID:1111-093153",
        "ADDR:8030 RAY MEDE",
        "CITY:SPRING LAKE",
        "CALL:MUTUAL AID WITH OTHER COUNTY");

    doTest("T3",
        "FRM:cadpage@harnett.org\nMSG:1201-003613*2728 DARROCH RD*****FIRE OTHER*********",
        "ID:1201-003613",
        "ADDR:2728 DARROCH RD",
        "CALL:FIRE OTHER");

    doTest("T4",
        "FRM:cadpage@harnett.org\nMSG:1201-002111*11860 NC 210 S*****FIRE RES STR*********",
        "ID:1201-002111",
        "ADDR:11860 NC 210 S",
        "MADDR:11860 STATE 210 S",
        "CALL:FIRE RES STR");

    doTest("T5",
        "FRM:cadpage@harnett.org\nMSG:1201-006955*2802 WALKER RD***LINDEN**FIRE RES STR*********",
        "ID:1201-006955",
        "ADDR:2802 WALKER RD",
        "CITY:LINDEN",
        "CALL:FIRE RES STR");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "1201-004551*11 BROOK LN*****EMS ABD PAIN*********",
        "ID:1201-004551",
        "ADDR:11 BROOK LN",
        "CALL:EMS ABD PAIN");

    doTest("T2",
        "1201-009149*1 YOUNG RD***ANGIER**FIRE ILLEGAL*********",
        "ID:1201-009149",
        "ADDR:1 YOUNG RD",
        "CITY:ANGIER",
        "CALL:FIRE ILLEGAL");

    doTest("T3",
        "1202-010125*1101 SILAS MOORE RD***BENSON**EMS SICK*********",
        "ID:1202-010125",
        "ADDR:1101 SILAS MOORE RD",
        "CITY:BENSON",
        "CALL:EMS SICK");

    doTest("T4",
        "1202-010135*51 ELLIE CT***FUQUAY VARINA**FIRE RES STR*********",
        "ID:1202-010135",
        "ADDR:51 ELLIE CT",
        "CITY:FUQUAY VARINA",
        "CALL:FIRE RES STR");

    doTest("T5",
        "1202-017757*137 MERCHANT DR***ANGIER**EMS BACK PN*******Hazards: No**",
        "ID:1202-017757",
        "ADDR:137 MERCHANT DR",
        "CITY:ANGIER",
        "CALL:EMS BACK PN");

    doTest("T6",
        "1203-021836*DARK WOOD DR***SPRING LAKE**FIRE SMO INV*******Hazards: No**",
        "ID:1203-021836",
        "ADDR:DARK WOOD DR",
        "CITY:SPRING LAKE",
        "CALL:FIRE SMO INV");

    doTest("T7",
        "1112-103007*2915 MATTHEWS MILL POND RD***ANGIER***MOTOR VEHICLE ACCIDENT****1143****",
        "ID:1112-103007",
        "ADDR:2915 MATTHEWS MILL POND RD",
        "CITY:ANGIER",
        "CALL:MOTOR VEHICLE ACCIDENT");

  }
  
  @Test
  public void testKeithPollard() {

    doTest("T1",
        "1210-092849*460 BAILEY RD***COATS*RED HILL CHURCH RD (*KELLY LN***EMS BREATHIN*******Hazards: No**",
        "ID:1210-092849",
        "ADDR:460 BAILEY RD",
        "CITY:COATS",
        "X:RED HILL CHURCH RD ( & KELLY LN",
        "CALL:EMS BREATHIN");

    doTest("T2",
        "1210-092971*130 E MCIVER ST***ANGIER**S POPLAR ST***FIRE ALARM C*******Hazards: No**",
        "ID:1210-092971",
        "ADDR:130 E MCIVER ST",
        "CITY:ANGIER",
        "CALL:S POPLAR ST");

  }
  
  @Test
  public void testEthanHardison() {

    doTest("T1",
        "FRM:cadpage@harnett.org\nMSG:1210-093840*9090 NC 210 S***BUNNLEVEL*SOUTH HARNETT LN*ANDERSON CREEK SCHOOL RD***MVA*********",
        "ID:1210-093840",
        "ADDR:9090 NC 210 S",
        "MADDR:9090 STATE 210 S",
        "CITY:BUNNLEVEL",
        "X:SOUTH HARNETT LN & ANDERSON CREEK SCHOOL RD",
        "CALL:MVA");

  }
  
  @Test
  public void testAllenJA() {

    doTest("T1",
        "1308-071722*688 CIRCLE DR***ANGIER*APRIL CT*BOWDEN FAMILY LN***FIRE RES STR*******Hazards: No**",
        "ID:1308-071722",
        "ADDR:688 CIRCLE DR",
        "CITY:ANGIER",
        "X:APRIL CT & BOWDEN FAMILY LN",
        "CALL:FIRE RES STR");

  }

  public static void main(String[] args) {
    new NCHarnettCountyAParserTest().generateTests("T1");
  }
}
