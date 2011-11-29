package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYOrangeCountyParser;

import org.junit.Test;


public class NYOrangeCountyParserTest extends BaseParserTest {
  
  public NYOrangeCountyParserTest() {
    setParser(new NYOrangeCountyParser(), "ORANGE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Vails Gate) CARBON MONOXIDE DETR  1 KEARNEY DR  NEW WINDSOR  DEPT 45 TIME: 19:17 XST: MARSHALL DR XST2: 17 TRUEX DR\n\n\nThis",
        "SRC:Vails Gate",
        "CALL:CARBON MONOXIDE DETR",
        "ADDR:1 KEARNEY DR",
        "CITY:NEW WINDSOR",
        "INFO:DEPT 45",
        "TIME:19:17",
        "X:MARSHALL DR & 17 TRUEX DR");

    doTest("T2",
        "(Vails Gate) EXTRICATION  ST RTE 32&amp;ORRS MILLS RD  CORNWALL  SPRINT PCS WIRELESS  CALLER REPORTS CAR INTO TREE POSS ENTRAPEMENT  Parent Inc MCO11112",
        "SRC:Vails Gate",
        "CALL:EXTRICATION",
        "ADDR:ST RTE 32 & ORRS MILLS RD",
        "MADDR:ST 32 & ORRS MILLS RD",
        "CITY:CORNWALL",
        "INFO:SPRINT PCS WIRELESS / CALLER REPORTS CAR INTO TREE POSS ENTRAPEMENT / Parent Inc MCO11112");

    doTest("T3",
        "(Vails Gate) ROLLOVER MVA  2406 ST RTE 32  CORNWALL  JESSICA  ONE CAR ROLLOVER//UNK INJS  Parent Inc MCO111126000959 UPDATE PriUnt to CO/CODIS TIME: 23:",
        "SRC:Vails Gate",
        "CALL:ROLLOVER MVA",
        "ADDR:2406 ST RTE 32",
        "MADDR:2406 ST 32",
        "CITY:CORNWALL",
        "INFO:JESSICA / ONE CAR ROLLOVER//UNK INJS / Parent Inc MCO111126000959 UPDATE PriUnt to CO/CODIS",
        "TIME:23:");

    doTest("T4",
        "(Vails Gate) AUTOMATIC FIRE ALARM  273 WINDSOR HWY  NEW WINDSOR  VECTOR SECURITY  LAUDRY ROOM SMOKE DETECTOR   Location : HUDSON VALLEY VETERIAN TIME: 1",
        "SRC:Vails Gate",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:273 WINDSOR HWY",
        "CITY:NEW WINDSOR",
        "INFO:VECTOR SECURITY / LAUDRY ROOM SMOKE DETECTOR / Location : HUDSON VALLEY VETERIAN",
        "TIME:1");

    doTest("T5",
        "(Vails Gate) AUTOMATIC FIRE ALARM  516 REED ST  NEW WINDSOR  SGT THOMAS  CALLER STS THERE IS A FIRE ALARM STS BLINKING SYSTEM TROUBLE AND ALSO SAY  S DA",
        "SRC:Vails Gate",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:516 REED ST",
        "CITY:NEW WINDSOR",
        "INFO:SGT THOMAS / CALLER STS THERE IS A FIRE ALARM STS BLINKING SYSTEM TROUBLE AND ALSO SAY / S DA");

    doTest("T6",
        "(Vails Gate) AUTOMATIC FIRE ALARM  935 UNION AVE  NEW WINDSOR  CENTRAL STATION  ZONE 32 OFFICE SMOKE DETECTOR/ ALARM CO IS ATTEMPTING KEY HOLDER/ PREM N",
        "SRC:Vails Gate",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:935 UNION AVE",
        "CITY:NEW WINDSOR",
        "INFO:CENTRAL STATION / ZONE 32 OFFICE SMOKE DETECTOR/ ALARM CO IS ATTEMPTING KEY HOLDER/ PREM N");
  }
  
  public static void main(String[] args) {
    new NYOrangeCountyParserTest().generateTests("T1");
  }
}