package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Burlington County, NJ
Contact: Active911

[] 22:41:04\n2012-00000107\nFIRE F Fire Call\n172 NAHMA TR\nCONAWAGA TR/CAYUSE TR\nSMELL OF SMOKE FROM BACK YARD\n3711\n
[] 14:48:13\n2012-00001094\nEMS E EMS Call\n650 TABERNACLE RD\nBEAR HEAD RD/TABERNACLE TWP LI\nMOTORCYCLE VS VEH MVA\n2510\n
[] 19:42:31\n2012-00000154\n132 E UnkMedEmrg\n110 NOKOMIS TR\nMISHE MOKWA TR/KAWESEA TR\n74F PAIN TO LEG UNABLE TO STAN\n3711\n
[] 21:04:44\n2012-00000112\n44 F Wires\n81 OSWEGO TR\nHIAWATHA TR/NANTUCKET TR\nPOSS. ELECTRICAL SURGE IN RES.\n3711\n
[] 13:27:05\n2012-00000113\nFIRE F Fire Call\n112 TABERNACLE RD\nMCKENDIMEN RD/TRADING POST WY\nWIRES SPARKING\n3711\n
[] 20:12:35\n2012-00000114\nFIRE F Fire Call\nSTOKES RD\nTABERNACLE RD\nSMOKE IN AREA NOT SURE WHERE I\n3711\n
[] 06:35:31\n2012-00000116\nFIRE F Fire Call\n100 STOKES RD\nMOHAWK TR/MINNETONKA TR\nFIRE ALARM...SMOKE AND HEAT IN\n3712\n

*/

public class NJBurlingtonCountyGParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyGParserTest() {
    setParser(new NJBurlingtonCountyGParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] 22:41:04\n2012-00000107\nFIRE F Fire Call\n172 NAHMA TR\nCONAWAGA TR/CAYUSE TR\nSMELL OF SMOKE FROM BACK YARD\n3711\n",
        "TIME:22:41:04",
        "ID:2012-00000107",
        "CALL:FIRE F Fire Call",
        "ADDR:172 NAHMA TR",
        "X:CONAWAGA TR/CAYUSE TR",
        "INFO:SMELL OF SMOKE FROM BACK YARD",
        "UNIT:3711");

    doTest("T2",
        "[] 14:48:13\n2012-00001094\nEMS E EMS Call\n650 TABERNACLE RD\nBEAR HEAD RD/TABERNACLE TWP LI\nMOTORCYCLE VS VEH MVA\n2510\n",
        "TIME:14:48:13",
        "ID:2012-00001094",
        "CALL:EMS E EMS Call",
        "ADDR:650 TABERNACLE RD",
        "X:BEAR HEAD RD/TABERNACLE TWP LI",
        "INFO:MOTORCYCLE VS VEH MVA",
        "UNIT:2510");

    doTest("T3",
        "[] 19:42:31\n2012-00000154\n132 E UnkMedEmrg\n110 NOKOMIS TR\nMISHE MOKWA TR/KAWESEA TR\n74F PAIN TO LEG UNABLE TO STAN\n3711\n",
        "TIME:19:42:31",
        "ID:2012-00000154",
        "CALL:132 E UnkMedEmrg",
        "ADDR:110 NOKOMIS TR",
        "X:MISHE MOKWA TR/KAWESEA TR",
        "INFO:74F PAIN TO LEG UNABLE TO STAN",
        "UNIT:3711");

    doTest("T4",
        "[] 21:04:44\n2012-00000112\n44 F Wires\n81 OSWEGO TR\nHIAWATHA TR/NANTUCKET TR\nPOSS. ELECTRICAL SURGE IN RES.\n3711\n",
        "TIME:21:04:44",
        "ID:2012-00000112",
        "CALL:44 F Wires",
        "ADDR:81 OSWEGO TR",
        "X:HIAWATHA TR/NANTUCKET TR",
        "INFO:POSS. ELECTRICAL SURGE IN RES.",
        "UNIT:3711");

    doTest("T5",
        "[] 13:27:05\n2012-00000113\nFIRE F Fire Call\n112 TABERNACLE RD\nMCKENDIMEN RD/TRADING POST WY\nWIRES SPARKING\n3711\n",
        "TIME:13:27:05",
        "ID:2012-00000113",
        "CALL:FIRE F Fire Call",
        "ADDR:112 TABERNACLE RD",
        "X:MCKENDIMEN RD/TRADING POST WY",
        "INFO:WIRES SPARKING",
        "UNIT:3711");

    doTest("T6",
        "[] 20:12:35\n2012-00000114\nFIRE F Fire Call\nSTOKES RD\nTABERNACLE RD\nSMOKE IN AREA NOT SURE WHERE I\n3711\n",
        "TIME:20:12:35",
        "ID:2012-00000114",
        "CALL:FIRE F Fire Call",
        "ADDR:STOKES RD",
        "MADDR:STOKES RD & TABERNACLE RD",
        "X:TABERNACLE RD",
        "INFO:SMOKE IN AREA NOT SURE WHERE I",
        "UNIT:3711");

    doTest("T7",
        "[] 06:35:31\n2012-00000116\nFIRE F Fire Call\n100 STOKES RD\nMOHAWK TR/MINNETONKA TR\nFIRE ALARM...SMOKE AND HEAT IN\n3712\n",
        "TIME:06:35:31",
        "ID:2012-00000116",
        "CALL:FIRE F Fire Call",
        "ADDR:100 STOKES RD",
        "X:MOHAWK TR/MINNETONKA TR",
        "INFO:FIRE ALARM...SMOKE AND HEAT IN",
        "UNIT:3712");

  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyGParserTest().generateTests("T1");
  }
}