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
        "TIME:23:36",
        "CALL:16- Rescue",
        "ADDR:17 BRYCEWOOD DR",
        "NAME:SPIEGEL, LORI A",
        "INFO:HQ ARISTA DR 31-A-1 UNCONSCIOUS / FAINTING (NEAR) CEWOOD DR DIXHIL TYPE:");

    doTest("T2",
        "2010-001779 10:34 *** 24/16- Mutual Aid *** 51 BALDWIN PATH  Dix Hills HQ",
        "ID:2010-001779",
        "TIME:10:34",
        "CALL:24/16- Mutual Aid",
        "ADDR:51 BALDWIN PATH",
        "INFO:Dix Hills HQ");

    doTest("T3",
        "2010-001777 15:54 *** 16- Rescue ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST",
        "ID:2010-001777",
        "TIME:15:54",
        "CALL:16- Rescue",
        "ADDR:DEER PARK AV & MARYLAND ST",
        "MADDR:DEER PARK AVE & MARYLAND ST",
        "INFO:Dix Hills HQ MARYLAND ST");

    doTest("T4",
        "2010-001778 15:54 *** 23- Misc Fire ***  DEER PARK AV DEER PARK AV & MARYLAND ST Dix Hills HQ MARYLAND ST",
        "ID:2010-001778",
        "TIME:15:54",
        "CALL:23- Misc Fire",
        "ADDR:DEER PARK AV & MARYLAND ST",
        "MADDR:DEER PARK AVE & MARYLAND ST",
        "INFO:Dix Hills HQ MARYLAND ST");

    doTest("T5",
        "2010-001774 11:56 *** 13- Structure Fire *** 29 WHITE BIRCH DR FULGONI, MARISSA Dix Hills HQ BALSAM DR 52-B-1G ALARMS TE BIRCH DR DIXHIL TYPE: ALARMS ",
        "ID:2010-001774",
        "TIME:11:56",
        "CALL:13- Structure Fire",
        "ADDR:29 WHITE BIRCH DR",
        "NAME:FULGONI, MARISSA",
        "INFO:HQ BALSAM DR 52-B-1G ALARMS TE BIRCH DR DIXHIL TYPE: ALARMS");

    doTest("T6",
        "2010-001766 05:54 *** 13- Structure Fire *** 29 WILDWOOD DR TRUEN, CRAIG Dix Hills HQ WHITNEY CT 60-C-1O GAS LEAKS / GAS ODOR (NATURAL / L.P.G.) DWOOD",
        "ID:2010-001766",
        "TIME:05:54",
        "CALL:13- Structure Fire",
        "ADDR:29 WILDWOOD DR",
        "NAME:TRUEN, CRAIG",
        "INFO:HQ WHITNEY CT 60-C-1O GAS LEAKS / GAS ODOR (NATURAL / LPG) DWOOD");

    doTest("T7",
        "2010-001919 01:48 *** 16- Rescue *** 179 OAKFIELD AV BRUZZESE, ROCCO  SEAMAN NECK RD 6-D-3 RESPIRATORY KFIELD AV DIXHIL TYPE: RESPIRATORY LOC: 179  OAKFI",
        "ID:2010-001919",
        "TIME:01:48",
        "CALL:16- Rescue",
        "ADDR:179 OAKFIELD AV",
        "MADDR:179 OAKFIELD AVE",
        "INFO:BRUZZESE, ROCCO SEAMAN NECK RD 6-D-3 RESPIRATORY KFIELD AV DIXHIL TYPE: RESPIRATORY LOC: 179 OAKFI");

    doTest("T8",
        "2010-001923 11:44 *** 16- Rescue *** 337 DEER PARK AV SUNRISE ASSISTED LIVING RED MAPLE LA Alert",
        "ID:2010-001923",
        "TIME:11:44",
        "CALL:16- Rescue",
        "ADDR:337 DEER PARK AV",
        "MADDR:337 DEER PARK AVE",
        "INFO:SUNRISE ASSISTED LIVING RED MAPLE LA Alert");

    doTest("T9",
        "2010-001991 08:42 *** 23- Misc Fire ***  CARLLS STRAIGHT PATH CARLLS STRAIGHT PA & S SERVICE RD S SERVICE RD",
        "ID:2010-001991",
        "TIME:08:42",
        "CALL:23- Misc Fire",
        "ADDR:CARLLS STRAIGHT PATH & S SERVICE RD S",
        "INFO:SERVICE RD");
  }
  
  public static void main(String[] args) {
    new NYDixHillsParserTest().generateTests("T1", "ID TIME CALL ADDR NAME INFO");
  }
}
