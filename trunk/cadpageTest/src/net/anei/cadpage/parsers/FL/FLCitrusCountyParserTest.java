package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class FLCitrusCountyParserTest extends BaseParserTest {
  
  public FLCitrusCountyParserTest() {
    setParser(new FLCitrusCountyParser(), "CITRUS COUNTY", "FL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FDF01 TYP: MISC FIRE AD: 8038 W PURVIS CT CTY: CRYSTAL RIVER CN: PHILIP CMT1: TREE ON POWERLINE SMOKING. PROGRESS ENERGY FDCA07 FDSTA1 XST2:",
        "SRC:FDF01",
        "CALL:MISC FIRE",
        "ADDR:8038 W PURVIS CT",
        "CITY:CRYSTAL RIVER",
        "NAME:PHILIP",
        "INFO:TREE ON POWERLINE SMOKING. PROGRESS ENERGY FDCA07 FDSTA1");

    doTest("T2",
        "FDF01 TYP: VEHICLE FIRE AD: 1035 S SUNCOAST BLVD CTY: HOMOSASSA LOC: CRYSTAL CHEVROLET CMT1: Original Location : CRYSTAL CHEVROLET CMT2: S/B",
        "SRC:FDF01",
        "CALL:VEHICLE FIRE",
        "ADDR:1035 S SUNCOAST BLVD",
        "CITY:HOMOSASSA",
        "PLACE:CRYSTAL CHEVROLET",
        "INFO:Original Location : CRYSTAL CHEVROLET / S/B");

    doTest("T3",
        "FDF01 TYP: BRUSH FIRE AD: N BASSWOOD AVE&W CHECKERBERRY CTY: CRYSTAL RIVER CMT1: BRUSHFIRE 1/2 ACRE IN THE AREA OF THE ABOVE FDSTA9 FDSTA1 [",
        "SRC:FDF01",
        "CALL:BRUSH FIRE",
        "ADDR:N BASSWOOD AVE & W CHECKERBERRY",
        "CITY:CRYSTAL RIVER",
        "INFO:BRUSHFIRE 1/2 ACRE IN THE AREA OF THE ABOVE FDSTA9 FDSTA1 [");

    doTest("T4",
        "FDF01 TYP: STRUCTURE FIRE AD: 2525 S PINE RIDGE AVE CTY: HOMOSASSA CN: MCKELVEY, JOHN CMT1: SMOKE COMING FROM THE BACK OF THE AREA FDCA03 FD",
        "SRC:FDF01",
        "CALL:STRUCTURE FIRE",
        "ADDR:2525 S PINE RIDGE AVE",
        "CITY:HOMOSASSA",
        "NAME:MCKELVEY, JOHN",
        "INFO:SMOKE COMING FROM THE BACK OF THE AREA FDCA03 FD");
  }
  
  public static void main(String[] args) {
    new FLCitrusCountyParserTest().generateTests("T1");
  }
}
  