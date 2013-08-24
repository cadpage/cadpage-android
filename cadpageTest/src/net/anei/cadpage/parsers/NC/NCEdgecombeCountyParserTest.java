package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Edgecombe County, NC
Contact: Battleboro Fire Dept. <bcvfd@suddenlinkmail.com>
Sender: edgecombecentral@co.edgecombe.nc.us
System: Pagegate

*** Not parsing - these are early calls taht no longer appear to be supported
S: M:Edgecombe911:* 2031 TANNER RD* * * ROCKY MOUNT* * Line7=* Line8=* Line9=* Line10=* Line11=STRUCTURE FIRE – HOUSE, CHURCH, OCCUPIED DWELLING* Line12=* Line13=* L 
S: M:Edgecombe911:* 720 DUNBAR WOODS RD* * * BATTLEBORO* * Line7=* Line8=* Line9=* Line10=* Line11=FIRE ALARM ACTIVATION* Line12=* Line13=* Line14=18FD1,19FD1,9FDNAS 

S: M:Edgecombe911:6120 OLD BATTLEBORO RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,WHITAKERS1
S: M:EdgecombeCentral:4371 BATTLEBORO-LEGGETT RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,ROCKYMT1
S: M:Edgecombe911:6120 OLD BATTLEBORO RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,WHITAKERS1
S: M:EdgecombeCentral:5590 MORNING STAR CH RD BATTLEBORO Chest Pain CODE 3 9FRNASH,WHITAKERS2
S: M:EdgecombeCentral:1024 AFT LN BATTLEBORO FIRE ALARM ACTIVATION 12FD1,18FD1,9FDNASH1 

*/

public class NCEdgecombeCountyParserTest extends BaseParserTest {
  
  public NCEdgecombeCountyParserTest() {
    setParser(new NCEdgecombeCountyParser(), "EDGECOMBE COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M:Edgecombe911:6120 OLD BATTLEBORO RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,WHITAKERS1",
        "ADDR:6120 OLD BATTLEBORO RD",
        "CITY:BATTLEBORO",
        "CALL:Breathing Problems",
        "PRI:3",
        "UNIT:9FDNASH1,WHITAKERS1");

    doTest("T2",
        "S: M:EdgecombeCentral:4371 BATTLEBORO-LEGGETT RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,ROCKYMT1",
        "ADDR:4371 BATTLEBORO-LEGGETT RD",
        "CITY:BATTLEBORO",
        "CALL:Breathing Problems",
        "PRI:3",
        "UNIT:9FDNASH1,ROCKYMT1");

    doTest("T3",
        "S: M:Edgecombe911:6120 OLD BATTLEBORO RD BATTLEBORO Breathing Problems CODE 3 9FDNASH1,WHITAKERS1",
        "ADDR:6120 OLD BATTLEBORO RD",
        "CITY:BATTLEBORO",
        "CALL:Breathing Problems",
        "PRI:3",
        "UNIT:9FDNASH1,WHITAKERS1");

    doTest("T4",
        "S: M:EdgecombeCentral:5590 MORNING STAR CH RD BATTLEBORO Chest Pain CODE 3 9FRNASH,WHITAKERS2",
        "ADDR:5590 MORNING STAR CH RD",
        "MADDR:5590 MORNING STAR CHURCH RD",
        "CITY:BATTLEBORO",
        "CALL:Chest Pain",
        "PRI:3",
        "UNIT:9FRNASH,WHITAKERS2");

    doTest("T5",
        "S: M:EdgecombeCentral:1024 AFT LN BATTLEBORO FIRE ALARM ACTIVATION 12FD1,18FD1,9FDNASH1 ",
        "ADDR:1024 AFT LN",
        "CITY:BATTLEBORO",
        "CALL:FIRE ALARM ACTIVATION",
        "UNIT:12FD1,18FD1,9FDNASH1");

  }

  public static void main(String[] args) {
    new NCEdgecombeCountyParserTest().generateTests("T1");
  }
}
