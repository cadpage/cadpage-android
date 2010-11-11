package net.anei.cadpage.parsers;

import org.junit.Test;


public class GAOSmyrnaParserTest extends BaseParserTest {
  
  public GAOSmyrnaParserTest() {
    setParser(new GASmyrnaParser(), "SMYRNA", "GA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:FYI: ;STRUCTURE FIRE;2501 WOODLANDS DR SE;FLAMES INSIDE FUSE BOX INSIDE CALLERS APARTMENT. SMELLS WIRES BURNING. [08/08/10 22:53:28 DTHACKER];103157",
        "CALL:STRUCTURE FIRE",
        "ADDR:2501 WOODLANDS DR SE",
        "INFO:FLAMES INSIDE FUSE BOX INSIDE CALLERS APARTMENT. SMELLS WIRES BURNING.");

    doTest("T2",
        "CAD:Update: ;VEHICLE FIRE;S COBB DR SE/BOURNE DR SE;METRO PCS;OWNER OF VEH CALLED --- ADV ON 280 AT WH [10/11/10 17:46:52 ABERRY] blk dodge charger on fire [10/",
        "CALL:VEHICLE FIRE",
        "ADDR:S COBB DR SE & BOURNE DR SE",
        "X:METRO PCS",
        "INFO:OWNER OF VEH CALLED --- ADV ON 280 AT WH");

    doTest("T3",
        "CAD:FYI: ;VEHICLE FIRE;WINDY HILL RD SE/S COBB DR SE;METRO PCS;blk dodge charger on fire [10/11/10 17:46:16 DSNIVELY] ;104107",
        "CALL:VEHICLE FIRE",
        "ADDR:WINDY HILL RD SE & S COBB DR SE",
        "X:METRO PCS",
        "INFO:blk dodge charger on fire");
    
    doTest("T4",
        "CAD:Update: ;STRUCTURE FIRE;501 WALTON WAY SE;S COBB DR SE;apt 501 [09/23/10 15:17:59 MBAGNATO] ;103832",
        "CALL:STRUCTURE FIRE",
        "ADDR:501 WALTON WAY SE",
        "X:S COBB DR SE",
        "INFO:apt 501");
    
    doTest("T5",
        "CAD:FYI: ;FIRE GENERAL;4586-W VALLEY PKWY SE;S COBB DR SE;ASHLEY;heavy smoke [10/09/10 03:49:27 SMAHAMA] smoke coming from the unit below her [10/09/10 03:48:51",
        "CALL:FIRE GENERAL",
        "ADDR:4586 W VALLEY PKWY SE",
        "X:S COBB DR SE & ASHLEY",
        "INFO:heavy smoke");
 }
}
