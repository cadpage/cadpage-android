package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYDixHillsParser;

import org.junit.Test;


public class NYDixHillsParserTest extends BaseParserTest {
  
  public NYDixHillsParserTest() {
    setParser(new NYDixHillsParser(), "DIX HILLS", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "2010-001784 23:36 *** 16- Rescue *** 17 BRYCEWOOD DR SPIEGEL, LORI A Dix Hills HQ ARISTA DR 31-A-1 UNCONSCIOUS / FAINTING (NEAR) CEWOOD DR DIXHIL TYPE:",
        "ID:2010-001784",
        "CALL:16- Rescue",
        "ADDR:17 BRYCEWOOD DR");

    doTest("T2",
        "2010-001779 10:34 *** 24/16- Mutual Aid *** 51 BALDWIN PATH  Dix Hills HQ",
        "ID:2010-001779",
        "CALL:24/16- Mutual Aid",
        "ADDR:51 BALDWIN PATH");
    
    doTest("T3",
        "2010-001777 15:54 *** 16- Rescue ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST",
        "ID:2010-001777",
        "CALL:16- Rescue",
        "ADDR:DEER PARK AV & MARYLAND ST");
        
    doTest("T4",
        "2010-001774 11:56 *** 13- Structure Fire *** 29 WHITE BIRCH DR FULGONI, MARISSA Dix Hills HQ BALSAM DR 52-B-1G ALARMS TE BIRCH DR DIXHIL TYPE: ALARMS",
        "ID:2010-001774",
        "CALL:13- Structure Fire",
        "ADDR:29 WHITE BIRCH DR");
        
    doTest("T5",
        "2010-001766 05:54 *** 13- Structure Fire *** 29 WILDWOOD DR TRUEN, CRAIG Dix Hills HQ WHITNEY CT 60-C-1O GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) DWOOD",
        "ID:2010-001766",
        "CALL:13- Structure Fire",
        "ADDR:29 WILDWOOD DR");
    
    doTest("T6",
        "2010-001919 01:48 *** 16- Rescue *** 179 OAKFIELD AV BRUZZESE, ROCCO  SEAMAN NECK RD 6-D-3 RESPIRATORY KFIELD AV DIXHIL TYPE: RESPIRATORY LOC: 179  OAKFI",
        "ID:2010-001919",
        "CALL:16- Rescue",
        "ADDR:179 OAKFIELD AV");
    
    doTest("T7",
        "2010-001923 11:44 *** 16- Rescue *** 337 DEER PARK AV SUNRISE ASSISTED LIVING RED MAPLE LA Alert",
        "ID:2010-001923",
        "CALL:16- Rescue",
        "ADDR:337 DEER PARK AV");

    doTest("T8",
        "2010-001991 08:42 *** 23- Misc Fire ***  CARLLS STRAIGHT PATH CARLLS STRAIGHT PA & S SERVICE RD S SERVICE RD",
        "ID:2010-001991",
        "CALL:23- Misc Fire",
        "ADDR:CARLLS STRAIGHT PATH & S SERVICE RD S");
  }
}
