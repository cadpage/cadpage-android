package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYErieCountyParserTest extends BaseParserTest {
  
  public NYErieCountyParserTest() {
    setParser(new NYErieCountyParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN",
        "ADDR:238 WESTFIELD RD",
        "CALL:EMS 79 YO F / CHEST PAIN");
        
    doTest("T2",
        "AMH 52 ENDICOTT DR EMS 82 YO M",
        "ADDR:52 ENDICOTT DR",
        "CALL:EMS 82 YO M");
        
    doTest("T3",
        "AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING",
        "ADDR:670 LONGMEADOW RD",
        "CALL:EMS 71 Y / O F CHEST PAINS, DIFFICULTY BREATHING");
        
    doTest("T4",
        "AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING",
        "ADDR:3030 SHERIDAN DR",
        "CALL:EMS RM 146 58 M TROUBLE BREATHING");
        
    doTest("T5",
        "AMH 35 ELM RD EMS 69M CHEST/ARM PAIN",
        "ADDR:35 ELM RD",
        "CALL:EMS 69M CHEST / ARM PAIN");
        
  }
}