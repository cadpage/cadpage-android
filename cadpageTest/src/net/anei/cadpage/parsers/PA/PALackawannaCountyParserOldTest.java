package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PALackawannaCountyParserOldTest extends BaseParserTest {
  
  public PALackawannaCountyParserOldTest() {
    setParser(new PALackawannaCountyParserOld(), "LACKAWANNA COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(Dispatch) Unit:14-9 Status:Dispatched Location:524 DEACON ST, 14 Call Type:BLS Call Time:12/7/2010 6:22:58 AM Call Number:245 Quadrant:F14 District:",
        "UNIT:14-9",
        "ADDR:524 DEACON ST",
        "CITY:COVINGTON TWP",
        "CALL:BLS",
        "ID:245",
        "MAP:F14");
    
    doTest("T2",
        "(Dispatch) Unit:14-9 Status:Dispatched Location:132 UNION MILL RD WINSHIP RD / LANGAN RD, VAN BRUNT ST, 14 Call Type:ALS Call Time:12/11/2010 11:27:5",
        "UNIT:14-9",
        "ADDR:132 UNION MILL RD",
        "CITY:COVINGTON TWP",
        "X:WINSHIP RD / LANGAN RD, VAN BRUNT ST",
        "CALL:ALS");

    doTest("T3",
        "(Dispatch) Unit:CH53 Status:Dispatched Location:0 ASTON MOUNTAIN RD, 53 Call Type:ACCI Call Time:12/11/2010 1:12:10 PM Call Number:446 Quadrant:F53 D",
        "UNIT:CH53",
        "ADDR:ASTON MOUNTAIN RD",
        "CITY:SPRING BROOK TWP",
        "CALL:ACCI",
        "ID:446",
        "MAP:F53");
    
    doTest("T4",
        "(Dispatch) Unit:ch14 Status:Dispatched Location:0 LEHIGH RD, 14 Call Type:BRSH Call Time:12/12/2010 9:01:17 AM Call Number:872 Quadrant:F14 District:",
        "UNIT:ch14",
        "ADDR:LEHIGH RD",
        "CITY:COVINGTON TWP",
        "CALL:BRSH",
        "ID:872",
        "MAP:F14");

    doTest("T5",
        "(Dispatch) Unit:14-9 Status:Dispatched Location:298 1ST AVE DEAD END / DRINKER TPKE, 14 Common Name:DIAPERS COM Call Type:BLS Call Time:12/12/2010 5:",
        "UNIT:14-9",
        "ADDR:298 1ST AVE",
        "CITY:COVINGTON TWP",
        "X:DEAD END / DRINKER TPKE",
        "PLACE:DIAPERS COM",
        "CALL:BLS");

    doTest("T6",
        "(Dispatch) Unit:CH53 Status:Dispatched Location:RT 690 / BOWENS RD, 53 Call Type:ACCI Call Time:12/17/2010 11:04:51 PM Call Number:413 Quadrant:F53 D",
        "UNIT:CH53",
        "ADDR:RT 690 & BOWENS RD",
        "CALL:ACCI",
        "CITY:SPRING BROOK TWP",
        "ID:413",
        "MAP:F53");

    doTest("T7",
        "[Dispatch]  Unit:ch14 Status:Dispatched Location:662 DRINKER TPKE AM HUGHES BLVD / ROSS DR, 14 Call Type:ACCI Call Time:12/18/2010 6:05:58 AM Call Num",
        "UNIT:ch14",
        "ADDR:662 DRINKER TPKE",
        "CITY:COVINGTON TWP",
        "X:AM HUGHES BLVD / ROSS DR",
        "CALL:ACCI");

    doTest("T8",
        "(Dispatch) Unit:T14 Status:Dispatched Location:SCRANTON POCONO HWY / DRINKER TPKE, 14 Call Type:AFA Call Time:12/21/2010 8:56:18 AM Call Number:802 Q",
        "UNIT:T14",
        "ADDR:SCRANTON POCONO HWY & DRINKER TPKE",
        "CITY:COVINGTON TWP",
        "CALL:AFA",
        "ID:802");
  }
  
  public static void main(String args[]) {
    new PALackawannaCountyParserOldTest().generateTests("T1");
  }
}