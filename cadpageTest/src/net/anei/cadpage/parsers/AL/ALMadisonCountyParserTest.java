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
    
    doTest("T7",
        "(IPS I/Page Notification) EVENT: E1105513 Loc: 116 DRYSDALE DR MDCO EVT#: E1105513 TYPE: M TIME: 08:48:15",
        "ADDR:116 DRYSDALE DR",
        "CITY:MADISON COUNTY",
        "ID:E1105513",
        "CALL:MEDICAL");

    doTest("T8",
        "(R1 IPS I/Page Notification) Loc: TIMBERLANE AV NW/POPLAR AV NW HSV  EVT#: E1120841 TYPE: MVA/E TIME: 13:42:06",
        "ADDR:TIMBERLANE AV NW & POPLAR AV NW",
        "MADDR:TIMBERLANE AVE NW & POPLAR AVE NW",
        "CITY:HUNTSVILLE",
        "ID:E1120841",
        "CALL:MVA W/ ENTRAPMENT");

    doTest("T9",
        "Subject:IPS I/Page Notification\nLoc: 2979 OLD HIGHWAY 431 OXRD: @NO NAME: COMMERCIAL & RESIDENTAL APT COMPLEX: alias 2979 OLD HWY 431 EVT",
        "ADDR:2979 OLD HIGHWAY 431",
        "PLACE:NO NAME: COMMERCIAL & RESIDENTAL APT COMPLEX: @2979 OLD HWY 431",
        "CITY:OWENS CROSS ROADS");

    doTest("T10",
        "(IPS I/Page Notification) Loc: 124 8TH ST TRI EVT#: C1205250 TYPE: FR TIME: 07:44:04 GRID ID: 2222",
        "ADDR:124 8TH ST",
        "CITY:TRIANA",
        "ID:C1205250",
        "CALL:FIRE/RESCUE");

    doTest("T11",
        "(IPS I/Page Notification) Loc: 140 FEARN DR TRI EVT#: C1205345 TYPE: DOM TIME: 19:54:32 GRID ID: 2225",
        "ADDR:140 FEARN DR",
        "CITY:TRIANA",
        "ID:C1205345",
        "CALL:DOM");
  }
  
  public static void main(String[] args) {
    new ALMadisonCountyParserTest().generateTests("T1", "ADDR PLACE CITY ID CALL");
  }
}