package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYRockyPointParserTest extends BaseParserTest {
  
  public NYRockyPointParserTest() {
    setParser(new NYRockyPointParser(), "ROCKY POINT", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Automatic Alarm, Residential at 38 CHERYL DR, SHOREHAM  c/s: COBBLESTONE DR . . 08:23:03",
        "CALL:Automatic Alarm, Residential",
        "ADDR:38 CHERYL DR",
        "CITY:SHOREHAM",
        "X:COBBLESTONE DR");

    doTest("T2",
        "Breathing Problems, Abnormal breathing at 151 BROADWAY, ROCKY POINT  c/s: CLUBHOUSE DR . . 12:42:23<br>",
        "CALL:Breathing Problems, Abnormal breathing",
        "ADDR:151 BROADWAY",
        "CITY:ROCKY POINT",
        "X:CLUBHOUSE DR");
    
    doTest("T3",
        "Breathing Problems, Difficulty Speaking Between Breaths at 6 CROWN RD, ROCKY POINT  c/s: FISH RD . . 16:09:05<br>",
        "CALL:Breathing Problems, Difficulty Speaking Between Breaths",
        "ADDR:6 CROWN RD",
        "CITY:ROCKY POINT",
        "X:FISH RD");
      
    doTest("T4",
        "Cardiac or Respiratory Arrest, Not breathing at all at 258 GLEN DR, SHOREHAM  c/s: LEISURE DR . . 14:31:40<br>",
        "CALL:Cardiac or Respiratory Arrest, Not breathing at all",
        "ADDR:258 GLEN DR",
        "CITY:SHOREHAM",
        "X:LEISURE DR");
    
  }
}
