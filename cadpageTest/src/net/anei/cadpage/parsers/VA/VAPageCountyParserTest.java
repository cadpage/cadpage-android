package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAPageCountyParserTest extends BaseParserTest {
  
  public VAPageCountyParserTest() {
    setParser(new VAPageCountyParser(), "PAGE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MAILBOX:RS3 PAIN 16 E MAIN ST LUR CFS# 2011-000782 CROSS: BROAD ST/TANNERY RD",
        "SRC:RS3",
        "CALL:PAIN",
        "ADDR:16 E MAIN ST",
        "CITY:LURAY",
        "ID:2011-000782",
        "X:BROAD ST/TANNERY RD");

    doTest("T2",
        "MAILBOX:RS4 CHEST PAINS 185 GRAY DR STA CFS# 2011-004572 CROSS: AYLOR GRUBBS AV",
        "SRC:RS4",
        "CALL:CHEST PAINS",
        "ADDR:185 GRAY DR",
        "CITY:STANLEY",
        "ID:2011-004572",
        "X:AYLOR GRUBBS AV");

    doTest("T3",
        "MAILBOX:RS1 GENERAL ILLNESS 117 PULASKI AV SHE CFS# 2011-004542 CROSS: S SECOND ST/FRONT ST",
        "SRC:RS1",
        "CALL:GENERAL ILLNESS",
        "ADDR:117 PULASKI AV",
        "CITY:SHENANDOAH",
        "ID:2011-004542",
        "X:S SECOND ST/FRONT ST");

    doTest("T4",
        "MAILBOX:CO24 COMMERCIAL ALARM 525 MIDDLEBURG RD STA CFS# 2011-005247 CROSS: US HWY BSN 340/GOODRICH RD",
        "SRC:CO24",
        "CALL:COMMERCIAL ALARM",
        "ADDR:525 MIDDLEBURG RD",
        "CITY:STANLEY",
        "ID:2011-005247",
        "X:US HWY BSN 340/GOODRICH RD");

    doTest("T5",
        "(RS1 INJURIES FROM A FALL 4472  US HWY 340    SHE  CFS# 2011-016573 CROSS) MAILBOX:HIDEAWAY LN/NEWPORT RD",
        "SRC:RS1",
        "CALL:INJURIES FROM A FALL",
        "ADDR:4472 US HWY 340",
        "CITY:SHENANDOAH",
        "ID:2011-016573",
        "X:HIDEAWAY LN/NEWPORT RD");
  }
  
  public static void main(String[] args) {
    new VAPageCountyParserTest().generateTests("T1", "SRC CALL ADDR CITY ID X");
  }
}