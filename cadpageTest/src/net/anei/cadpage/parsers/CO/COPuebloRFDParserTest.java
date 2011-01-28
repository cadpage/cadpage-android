package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.CO.COPuebloRFDParser;

import org.junit.Test;


public class COPuebloRFDParserTest extends BaseParserTest {
  
  public COPuebloRFDParserTest() {
    setParser(new COPuebloRFDParser(), "PUEBLO COUNTY", "CO");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(Page ) 12:43PM 11/28 RURAL FIRE in the area of 1543 Cooper Pl report of heavy smoke no flames showing...kr",
        "ADDR:1543 Cooper Pl",
        "CALL:RURAL FIRE in the area of",
        "INFO:report of heavy smoke no flames showing");
    
    doTest("T2",
        "(Page ) 04:26PM 12/13 rural fire:  hwy 50 & 27th ln; north side, 10 ft fire...tdb",
        "ADDR:hwy 50",
        "CALL:rural fire:",
        "INFO:& 27th ln; north side, 10 ft fire");
    
    doTest("T3", 
        "(Page ) 04:52PM 11/27 ATTN RURAL FIRE: 28141 south rd....male poss overdose...jaa",
        "ADDR:28141 south rd",
        "CALL:ATTN RURAL FIRE:",
        "INFO:#.male poss overdose#jaa");
    
    doTest("T4",
        "(Page ) 09:18AM 12/11 rural fire  33550 hwy 96 E Lot 379 35 yof convulsions",
        "ADDR:33550 hwy 96 E",
        "CALL:rural fire",
        "INFO:Lot 379 35 yof convulsions");
    
    doTest("T5",
        "(Page ) 11:45PM 11/15 ATTN RURAL FIRE: 1917 n santa fe ave...at the car wash....39yof...seizure...jaa",
        "ADDR:1917 n santa fe ave",
        "CALL:ATTN RURAL FIRE:",
        "INFO:#at the car wash#.39yof#seizure#jaa");
    
    
  }
}   