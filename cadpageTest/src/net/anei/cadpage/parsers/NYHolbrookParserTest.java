package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYHolbrookParserTest extends BaseParserTest {
  
  public NYHolbrookParserTest() {
    setParser(new NYHolbrookParser(), "HOLBROOK", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "MOTOR VEHICLE ACCIDENT . . MVA 29D4 at intersection of GREENBELT PKWY and PATCHOGUE-HOLBROOK RD. . 10:48:57",
        "CALL:MOTOR VEHICLE ACCIDENT - MVA 29D4",
        "ADDR:GREENBELT PKWY and PATCHOGUE-HOLBROOK RD");
    
    doTest("T2",
        "WIRES . . POWER CONDENSER FIRE at intersection of PATCHOGUE-HOLBROOK RD and FURROWS RD. . 07:14:36",
        "CALL:WIRES - POWER CONDENSER FIRE",
        "ADDR:PATCHOGUE-HOLBROOK RD and FURROWS RD");
    
    doTest("T3",
        "WORKING STRUCTURE FIRE at 223 SPRINGMEADOW DR. . 16:22:21",
        "CALL:WORKING STRUCTURE FIRE",
        "ADDR:223 SPRINGMEADOW DR");
        
    doTest("T4",
        "AMBULANCE CALL . . E/M RESP 6D2 at 76 LINCOLN AVE. . 17:48:14",
        "CALL:AMBULANCE CALL - E/M RESP 6D2",
        "ADDR:76 LINCOLN AVE");
  }
}