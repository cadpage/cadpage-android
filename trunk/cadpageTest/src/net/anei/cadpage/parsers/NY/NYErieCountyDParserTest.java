package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYErieCountyDParser;

import org.junit.Test;


public class NYErieCountyDParserTest extends BaseParserTest {
  
  public NYErieCountyDParserTest() {
    setParser(new NYErieCountyDParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testClarence() {

    doTest("T1",
        "CLA 10990 Keller Rd. EMS 80M slurred speech",
        "CITY:CLARENCE",
        "ADDR:10990 Keller Rd",
        "CALL:EMS 80M slurred speech");

    doTest("T2",
        "CLA 9970 Greiner Rd. EMS Finger laceration",
        "CITY:CLARENCE",
        "ADDR:9970 Greiner Rd",
        "CALL:EMS Finger laceration");

    doTest("T3",
        "CLA 5727 Marthas Vineyard EMS 55 y/o fell",
        "CITY:CLARENCE",
        "ADDR:5727 Marthas Vineyard",
        "CALL:EMS 55 y/o fell");

    doTest("T4",
        "CLA 5945 Vinecroft Dr. EMA apt. 401",
        "CITY:CLARENCE",
        "ADDR:5945 Vinecroft Dr",
        "CALL:EMA apt. 401");

    doTest("T5",
        "CLA Salt rd. & County rd. MVA. 1/2 mile north of county.",
        "CITY:CLARENCE",
        "ADDR:Salt rd & County rd",
        "CALL:MVA. 1/2 mile north of county.");

    doTest("T6",
        "CLA 5955 Elm St. EMS",
        "CITY:CLARENCE",
        "ADDR:5955 Elm St",
        "CALL:EMS");

    doTest("T7",
        "CLA 9690 Clarence Center Rd. EMS",
        "CITY:CLARENCE",
        "ADDR:9690 Clarence Center Rd",
        "CALL:EMS");
  }
  
  @Test
  public void testAmherst() {

    doTest("T1",
        "AMH 238 WESTFIELD RD EMS 79 YO F/  CHEST PAIN",
        "CITY:AMHERST",
        "ADDR:238 WESTFIELD RD",
        "CALL:EMS 79 YO F/  CHEST PAIN");

    doTest("T2",
        "AMH 52 ENDICOTT DR EMS 82 YO M",
        "CITY:AMHERST",
        "ADDR:52 ENDICOTT DR",
        "CALL:EMS 82 YO M");

    doTest("T3",
        "AMH 670 LONGMEADOW RD EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING",
        "CITY:AMHERST",
        "ADDR:670 LONGMEADOW RD",
        "CALL:EMS 71 Y/O F CHEST PAINS, DIFFICULTY BREATHING");

    doTest("T4",
        "AMH 3030 SHERIDAN DR EMS RM 146 58 M TROUBLE BREATHING",
        "CITY:AMHERST",
        "ADDR:3030 SHERIDAN DR",
        "CALL:EMS RM 146 58 M TROUBLE BREATHING");

    doTest("T5",
        "AMH 35 ELM RD EMS 69M CHEST/ARM PAIN",
        "CITY:AMHERST",
        "ADDR:35 ELM RD",
        "CALL:EMS 69M CHEST/ARM PAIN");

    doTest("T6",
        "ALERT@ERIE.GOV AMH KLEIN W RD&FOREST N RD MVA 2 CAR MVA - HEAD INJURY",
        "CITY:AMHERST",
        "ADDR:KLEIN W RD & FOREST N RD",
        "CALL:MVA 2 CAR MVA - HEAD INJURY");
  }
  
  @Test
  public void testWilliamsville() {

    doTest("T1",
        "ALERT@ERIE.GOV WMV 5403 MAIN ST EMA APT 308 /",
        "CITY:WILLIAMSVILLE",
        "ADDR:5403 MAIN ST",
        "CALL:EMA APT 308 /");
    
  }
  
  public static void main(String[] args) {
    new NYErieCountyDParserTest().generateTests("T1", "CITY ADDR CALL");
  }
}