package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTTrumbullParserTest extends BaseParserTest {
  
  public CTTrumbullParserTest() {
    setParser(new CTTrumbullParser(), "TRUMBULL", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "LH/TC/N FC2 AREA OF 82 CANOE BROOK RD  DIVE TEAM TO ASSIST PD WITH MISSING PERSON",
        "SRC:LH/TC/N",
        "UNIT:FC2",
        "PLACE:AREA OF",
        "ADDR:82 CANOE BROOK RD",
        "INFO:DIVE TEAM TO ASSIST PD WITH MISSING PERSON");

    doTest("T2",
        "TC FC1 IFO 271 PUTTING GREEN RD TREE LIMB ON WIRES 102 WILL HANDLE CALL W/ CREW THAT IS IN QUARTERS",
        "SRC:TC",
        "UNIT:FC1 IFO",
        "ADDR:271 PUTTING GREEN RD",
        "INFO:TREE LIMB ON WIRES 102 WILL HANDLE CALL W / CREW THAT IS IN QUARTERS");

    doTest("T3",
        "TC FC1 91 MOOSE HILL RD 2-3 FEET WATER IN BASEMENT",
        "SRC:TC",
        "UNIT:FC1",
        "ADDR:91 MOOSE HILL RD",
        "INFO:2-3 FEET WATER IN BASEMENT");

    doTest("T4",
        "LH/TC FC1 5065 MAIN ST WST ASSEMBLY OF ENGINE STRIKE TEAM 7122B PER REQUEST BPT 1 ENGINE FROM LH 1 ENGINE FROM TC",
        "SRC:LH/TC",
        "UNIT:FC1",
        "ADDR:5065 MAIN ST",
        "INFO:WST ASSEMBLY OF ENGINE STRIKE TEAM 7122B PER REQUEST BPT 1 ENGINE FROM LH 1 ENGINE FROM TC");

    doTest("T5",
        "TC FC2 72 STROBEL RD TRUM HIGH SCHOOL F/A",
        "SRC:TC",
        "UNIT:FC2",
        "ADDR:72 STROBEL RD",
        "INFO:TRUM HIGH SCHOOL F / A");

    doTest("T6",
        "TC FC1 43 HAWTHORNE RIDGE CL F/A",
        "SRC:TC",
        "UNIT:FC1",
        "ADDR:43 HAWTHORNE RIDGE CL",
        "INFO:F / A");
  }
  
  public static void main(String[] args) {
    new CTTrumbullParserTest().generateTests("T1", "SRC UNIT PLACE ADDR INFO");
  }
}