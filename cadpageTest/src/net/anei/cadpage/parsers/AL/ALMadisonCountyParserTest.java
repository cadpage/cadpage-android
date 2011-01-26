package net.anei.cadpage.parsers.AL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ALMadisonCountyParserTest extends BaseParserTest {
  
  public ALMadisonCountyParserTest() {
    setParser(new ALMadisonCountyParser(), "MADISON COUNTY", "AL");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "IPS I/Page Notification / Loc: 7583 WALL TRIANA HWY MDCO: @URGENT MEDCARE EVT#: C1009726 TYPE: M TIME: 13:36:55",
        "ADDR:7583 WALL TRIANA HWY",
        "CITY:MADISON COUNTY",
        "PLACE:URGENT MEDCARE",
        "ID:C1009726",
        "CALL:MEDICAL");
        
    doTest("T2",
        "IPS I/Page Notification / Loc: 2525 OLD RAILROAD BED RD MDCO EVT#: C1009579 TYPE: M TIME: 16:53:25",
        "ADDR:2525 OLD RAILROAD BED RD",
        "CITY:MADISON COUNTY",
        "ID:C1009579",
        "CALL:MEDICAL");
  
    doTest("T3",
        "IPS I/Page Notification / Loc: HIGHWAY 53/KELLY SPRING RD HSV: alias HWY 53/KELLY SPRING EVT#: C1009577 TYPE: MVA/I TIME: 14:12:44",
        "ADDR:HIGHWAY 53 & KELLY SPRING RD",
        "CITY:HUNTSVILLE",
        "PLACE:HWY 53/KELLY SPRING",
        "ID:C1009577",
        "CALL:MVA W/ INJURY");
    
    doTest("T4",
        "IPS I/Page Notification / Loc: 101 VASSER CIR MDCO EVT#: C1009575 TYPE: M TIME: 13:54:54",
        "ADDR:101 VASSER CIR",
        "CITY:MADISON COUNTY",
        "ID:C1009575",
        "CALL:MEDICAL");
    
    doTest("T5",
        "IPS I/Page Notification / Loc: 106 CHESAPEAKE BLVD MDCO EVT#: C1009490 TYPE: M TIME: 16:04:25",
        "ADDR:106 CHESAPEAKE BLVD",
        "CITY:MADISON COUNTY",
        "ID:C1009490",
        "CALL:MEDICAL");
    
    doTest("T6",
        "IPS I/Page Notification / Loc: 120 EMERALD DR MDCO EVT#: C1009484 TYPE: M TIME: 12:07:46",
        "ADDR:120 EMERALD DR",
        "CITY:MADISON COUNTY",
        "ID:C1009484",
        "CALL:MEDICAL");
    
        
  }
}