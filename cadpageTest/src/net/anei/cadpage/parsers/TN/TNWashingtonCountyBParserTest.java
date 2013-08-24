package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/* 
Washington County, TN (B)
Contact: Nathan Ward <wardn39@gmail.com>
Contact: Luke Story <firedog458@yahoo.com>
Sender: user phone

JVFD-Motor Vehicle Crash - Injury AT 215 ROY PHILLIPS RD -X-ST:BRANDON LN-RIDGECREST RD MAP-67C 00:18
WVFD.GVFD.AGENCY(-1)-House/Residential Fire AT 583 MISSION WY -X-ST:FAIRHAVEN RD;160 BLK-DEAD END MAP-39A 23:42
WVFD-Motor Vehicle Crash - Injury AT 557 AUSTIN SPRINGS RD -X-ST:RACCOON RIDGE LN-CASH HOLLOW RD MAP-30B 16:38
SIGNAL 9 ON Motor Vehicle Crash - Injury AT 557 AUSTIN SPRINGS RD SIGNAL 9 17:01

*/
public class TNWashingtonCountyBParserTest extends BaseParserTest {
  
  public TNWashingtonCountyBParserTest() {
    setParser(new TNWashingtonCountyBParser(), "WASHINGTON COUNTY", "TN");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "JVFD-Motor Vehicle Crash - Injury AT 215 ROY PHILLIPS RD -X-ST:BRANDON LN-RIDGECREST RD MAP-67C 00:18",
        "SRC:JVFD",
        "CALL:Motor Vehicle Crash - Injury",
        "ADDR:215 ROY PHILLIPS RD",
        "X:BRANDON LN & RIDGECREST RD",
        "MAP:67C",
        "TIME:00:18");

    doTest("T2",
        "WVFD.GVFD.AGENCY(-1)-House/Residential Fire AT 583 MISSION WY -X-ST:FAIRHAVEN RD;160 BLK-DEAD END MAP-39A 23:42",
        "SRC:WVFD",
        "CALL:House/Residential Fire",
        "ADDR:583 MISSION WY",  // Cannot find MISSION WY
        "X:FAIRHAVEN RD;160 BLK & DEAD END",
        "MAP:39A",
        "TIME:23:42");

    doTest("T3",
        "WVFD-Motor Vehicle Crash - Injury AT 557 AUSTIN SPRINGS RD -X-ST:RACCOON RIDGE LN-CASH HOLLOW RD MAP-30B 16:38",
        "SRC:WVFD",
        "CALL:Motor Vehicle Crash - Injury",
        "ADDR:557 AUSTIN SPRINGS RD",
        "X:RACCOON RIDGE LN & CASH HOLLOW RD",
        "MAP:30B",
        "TIME:16:38");

    doTest("T4",
        "SIGNAL 9 ON Motor Vehicle Crash - Injury AT 557 AUSTIN SPRINGS RD SIGNAL 9 17:01",
        "CALL:SIGNAL 9 ON Motor Vehicle Crash - Injury",
        "ADDR:557 AUSTIN SPRINGS RD",
        "INFO:SIGNAL 9",
        "TIME:17:01");

  }
  

  public static void main(String[] args) {
    new TNWashingtonCountyBParserTest().generateTests("T1");
  }
}
