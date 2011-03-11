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
        "ID:2011-004572",
        "X:AYLOR GRUBBS AV");

    doTest("T3",
        "MAILBOX:RS1 GENERAL ILLNESS 117 PULASKI AV SHE CFS# 2011-004542 CROSS: S SECOND ST/FRONT ST",
        "SRC:RS1",
        "CALL:GENERAL ILLNESS",
        "ADDR:117 PULASKI AV",
        "ID:2011-004542",
        "X:S SECOND ST/FRONT ST");
  }
  
  public static void main(String[] args) {
    new VAPageCountyParserTest().generateTests("T1", "SRC CALL ADDR CITY ID X");
  }
}