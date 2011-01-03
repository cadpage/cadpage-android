package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYSouthhamptonVillageParserTest extends BaseParserTest {
  
  public NYSouthhamptonVillageParserTest() {
    setParser(new NYSouthhamptonVillageParser(), "SOUTHHAMPTON", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "ALARM - GENERAL at 64 COUNTY RD 39, SOUTHAMPTON  c/s: NORTH SEA RD   O: HAMPTONS CENTER FOR REHAB . . 11:09:34",
        "CALL:ALARM - GENERAL",
        "ADDR:64 COUNTY RD 39",
        "CITY:SOUTHAMPTON",
        "X:NORTH SEA RD",
        "INFO:HAMPTONS CENTER FOR REHAB");

    doTest("T2",
        "STRUCTURE FIRE, RESIDENTIAL at 133 North Magee St, Southampton  c/s: Sebonic Inlet Rd . . 16:42:18",
        "CALL:STRUCTURE FIRE- RESIDENTIAL",
        "ADDR:133 North Magee St",
        "CITY:Southampton",
        "X:Sebonic Inlet Rd");
    
    doTest("T3",
        "MISC ALARM, GAS LEAK at 271 Gin . . 09:24:18",
        "CALL:MISC ALARM- GAS LEAK",
        "ADDR:271 Gin"
        );
      
    doTest("T4",
        "ALARM - GENERAL at 151 WINDMILL LN, SOUTHAMPTON  c/s: JAGGER LN   O: SVPD HQ . . 12:02:10",
        "CALL:ALARM - GENERAL",
        "ADDR:151 WINDMILL LN",
        "CITY:SOUTHAMPTON",
        "X:JAGGER LN",
        "INFO:SVPD HQ");
    doTest("T5",
        "STRUCTURE FIRE, RESIDENTIAL at HILL ST / CAPTAINS NECK LN, SOUTHAMPTON . . 15:36:34",
        "CALL:STRUCTURE FIRE- RESIDENTIAL",
        "ADDR:HILL ST / CAPTAINS NECK LN",
        "CITY:SOUTHAMPTON"
        );
    
  }
}
