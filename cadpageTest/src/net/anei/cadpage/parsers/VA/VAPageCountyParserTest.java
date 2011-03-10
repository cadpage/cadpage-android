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
  }
  
  public static void main(String[] args) {
    new VAPageCountyParserTest().generateTests("T1", "SRC CALL ADDR CITY ID X");
  }
}