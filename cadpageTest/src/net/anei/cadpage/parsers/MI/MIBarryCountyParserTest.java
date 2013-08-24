package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Barry County, MI
Contact: Matt Elkins <melkins83@gmail.com>

[CAD Page for CFS 051213-48]  ASSUALT , 4282 PICKEREL COVE RD\n20:31\nORESIK FLED ON FOOT\n\nCROSS OF MARSH RD / RIGHT BEHIND GILLE
[CAD Page for CFS 031913-37]  MEDICAL EMERGENCY , 9500 BEVER RD\n12:16\nResponder Script6.She did not take any drugs (medications)
[CAD Page for CFS 051113-57]  MEDICAL EMERGENCY , 4734 TORSTEN DR\n13:44\nResponder ScriptHAS PACE\n\nResponder Script5.She is unwe
[CAD Page for CFS 050813-17]  FIRE , 11965 FARM VIEW DR\n09:08\nCOMP CAN SMELL SMOKE FROM UNDER THE TRAILER.  CAN NOT SEE ANY SMOKE
[CAD Page for CFS 050313-44]  MEDICALTRANSFER , 11075 KELLER RD\n13:43\nTRANSPORT TO MAGNUM\nhttp://maps.google.com/maps?q=+42.5629

*/

public class MIBarryCountyParserTest extends BaseParserTest {
  
  public MIBarryCountyParserTest() {
	  setParser(new MIBarryCountyParser(), "BARRY COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[CAD Page for CFS 051213-48]  ASSUALT , 4282 PICKEREL COVE RD\n20:31\nORESIK FLED ON FOOT\n\nCROSS OF MARSH RD / RIGHT BEHIND GILLE",
        "ID:051213-48",
        "CALL:ASSUALT",
        "ADDR:4282 PICKEREL COVE RD",
        "TIME:20:31",
        "INFO:ORESIK FLED ON FOOT / CROSS OF MARSH RD / RIGHT BEHIND GILLE");

    doTest("T2",
        "[CAD Page for CFS 031913-37]  MEDICAL EMERGENCY , 9500 BEVER RD\n12:16\nResponder Script6.She did not take any drugs (medications)",
        "ID:031913-37",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:9500 BEVER RD",
        "TIME:12:16",
        "INFO:Responder Script6.She did not take any drugs (medications)");

    doTest("T3",
        "[CAD Page for CFS 051113-57]  MEDICAL EMERGENCY , 4734 TORSTEN DR\n13:44\nResponder ScriptHAS PACE\n\nResponder Script5.She is unwe",
        "ID:051113-57",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:4734 TORSTEN DR",
        "TIME:13:44",
        "INFO:Responder ScriptHAS PACE / Responder Script5.She is unwe");

    doTest("T4",
        "[CAD Page for CFS 050813-17]  FIRE , 11965 FARM VIEW DR\n09:08\nCOMP CAN SMELL SMOKE FROM UNDER THE TRAILER.  CAN NOT SEE ANY SMOKE",
        "ID:050813-17",
        "CALL:FIRE",
        "ADDR:11965 FARM VIEW DR",  // Not mapping
        "TIME:09:08",
        "INFO:COMP CAN SMELL SMOKE FROM UNDER THE TRAILER.  CAN NOT SEE ANY SMOKE");

    doTest("T5",
        "[CAD Page for CFS 050313-44]  MEDICALTRANSFER , 11075 KELLER RD\n13:43\nTRANSPORT TO MAGNUM\nhttp://maps.google.com/maps?q=+42.5629",
        "ID:050313-44",
        "CALL:MEDICALTRANSFER",
        "ADDR:11075 KELLER RD",
        "TIME:13:43",
        "INFO:TRANSPORT TO MAGNUM / http://maps.google.com/maps?q=+42.5629");

  }
  
  public static void main(String[] args) {
    new MIBarryCountyParserTest().generateTests("T1");
  }
}
