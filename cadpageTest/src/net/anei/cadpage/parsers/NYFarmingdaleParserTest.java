package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYFarmingdaleParserTest extends BaseParserTest {
  
  public NYFarmingdaleParserTest() {
    setParser(new NYFarmingdaleParser(), "FARMINGDALE", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Signal 9 . . Stroke (CVA) at 64 DOUD ST. . 11:31:21",
        "CALL:Signal 9 - Stroke (CVA)",
        "ADDR:64 DOUD ST");
        
    doTest("T2",
        "General Alarm . . SMOKE ODOR IN AREA at 36 WAVERLY PL. . 17:04:46",
        "CALL:General Alarm - SMOKE ODOR IN AREA",
        "ADDR:36 WAVERLY PL");
        
    doTest("T3",
        "House Fire  Electrical Fire at 23 BEECHWOOD ST. . 18:24:03",
        "CALL:House Fire  Electrical Fire",
        "ADDR:23 BEECHWOOD ST");
        
    doTest("T4",
        "Motor Vehicle Accident . . With Aided at intersection of MAIN ST and FULTON ST. . 11:46:09",
        "CALL:Motor Vehicle Accident - With Aided",
        "ADDR:MAIN ST and FULTON ST");
        
    doTest("T5",
        "Signal 9 . . Cardiac / Respiratory Arrest at 610 CONKLIN ST. . 06:20:05",
        "CALL:Signal 9 - Cardiac / Respiratory Arrest",
        "ADDR:610 CONKLIN ST");
   
  }
}