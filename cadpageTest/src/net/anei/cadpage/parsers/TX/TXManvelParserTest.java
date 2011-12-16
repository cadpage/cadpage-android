package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXManvelParserTest extends BaseParserTest {
  
  public TXManvelParserTest() {
    setParser(new TXManvelParser(), "MANVEL", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[ NEW CALL ]  MVFD\nALFIRE\n3403 SOUTHFORK PARKWAY\nMANVEL\n1103200011 12:50 PM",
        "SRC:MVFD",
        "CALL:ALFIRE",
        "ADDR:3403 SOUTHFORK PARKWAY",
        "CITY:MANVEL");

    doTest("T2",
        "[ NEW CALL ]  MVFD\nACCUNK\nS. MASTER / JUST PAST GATES LOOP\nMANVEL\n1102210022 5:25 PM",
        "SRC:MVFD",
        "CALL:ACCUNK",
        "ADDR:S MASTER & JUST PAST GATES LOOP",
        "CITY:MANVEL");

    doTest("T3",
        "[ NEW CALL ]  MVFD\nFIRE\n13508 AUTUMN ASH CT\nMANVEL\n1103030017 3:36 PM",
        "SRC:MVFD",
        "CALL:FIRE",
        "ADDR:13508 AUTUMN ASH CT",
        "CITY:MANVEL");

    doTest("T4",
        "[ NEW CALL ]  MVFD\nFIRE\n10516 LEEDY RD\nMANVEL\n1103010018 6:21 PM",
        "SRC:MVFD",
        "CALL:FIRE",
        "ADDR:10516 LEEDY RD",
        "CITY:MANVEL");

    doTest("T5",
        "[ NEW CALL ]  MVFD\nALFIRE\n3602 BEHLER\nMANVEL\n1102230010 3:30 PM",
        "SRC:MVFD",
        "CALL:ALFIRE",
        "ADDR:3602 BEHLER",
        "CITY:MANVEL");

    doTest("T6",
        "[ NEW CALL ]  MVFD\nFIRE\n815 CR 393\nMANVEL\n1102280014 2:47 PM",
        "SRC:MVFD",
        "CALL:FIRE",
        "ADDR:815 CR 393",
        "MADDR:815 COUNTY ROAD 393",
        "CITY:MANVEL");

    doTest("T7",
        "[ NEW CALL ]  MVFD\nACCUNK\n288/6\nMANVEL\n1102220014 12:04 PM",
        "SRC:MVFD",
        "CALL:ACCUNK",
        "ADDR:288 & 6",
        "CITY:MANVEL");
    
    doTest("T8",
        "NEW CALL / MVFD\nFIRE\n3110 EWING CT\nMANVEL\n1103270030 3:37 PM",
        "SRC:MVFD",
        "CALL:FIRE",
        "ADDR:3110 EWING CT",
        "CITY:MANVEL");

  }
  
  public static void main(String[] args) {
    new TXManvelParserTest().generateTests("T1");
  }
}
