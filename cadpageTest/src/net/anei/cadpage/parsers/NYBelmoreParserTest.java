package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYBelmoreParserTest extends BaseParserTest {
  
  public NYBelmoreParserTest() {
    setParser(new NYBelmoreParser(), "BELLMORE", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "RESCUE at 2438 BEDFORD PLACE. . 11:34:04",
        "CALL:RESCUE",
        "ADDR:2438 BEDFORD PLACE");

    doTest("T2",
        "AUTO ACCIDENT at intersection of BELTAGH AVENUE and BELLMORE AVENUE. . 15:03:39",
        "CALL:AUTO ACCIDENT",
        "ADDR:BELTAGH AVENUE and BELLMORE AVENUE");
    
    doTest("T3",
        "AUTO ACCIDENT at 2971 LEE PLACE. . 04:08:29",
        "CALL:AUTO ACCIDENT",
        "ADDR:2971 LEE PLACE");
    
    doTest("T4",
        "MUTUAL AID RESCUE at 3015 CHERYL ROAD. . 19:12:04",
        "CALL:MUTUAL AID RESCUE",
        "ADDR:3015 CHERYL ROAD");
    
    doTest("T5",
        "AUTOMATIC ALARM BUILDING . . UNREGISTERED ALARM at 609 SUNRISE HIGHWAY. . 11:46:13",
        "CALL:AUTOMATIC ALARM BUILDING",
        "INFO:UNREGISTERED ALARM",
        "ADDR:609 SUNRISE HIGHWAY");
    
    doTest("T6",
        "HAZMAT - NATURAL GAS INTERIOR . . ODOR INSIDE at 1 SUNRISE HIGHWAY. . 05:07:37",
        "CALL:HAZMAT - NATURAL GAS INTERIOR",
        "INFO:ODOR INSIDE",
        "ADDR:1 SUNRISE HIGHWAY");
    
    doTest("T7",
        "HOUSE FIRE . . SMOKE IN THE HOUSE at 2764 MARTIN AVENUE. . 17:09:53",
        "CALL:HOUSE FIRE",
        "INFO:SMOKE IN THE HOUSE",
        "ADDR:2764 MARTIN AVENUE");
  }
}