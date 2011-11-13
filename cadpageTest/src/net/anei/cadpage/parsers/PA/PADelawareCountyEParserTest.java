package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PADelawareCountyEParserTest extends BaseParserTest {
  
  public PADelawareCountyEParserTest() {
    setParser(new PADelawareCountyEParser(), "DELAWARE COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "18:03\nHAVERFORD RD & WOODCREST AV\nFD INVESTIGATION\nHAVERFORD RD\nWOODCREST AV",
        "TIME:18:03",
        "ADDR:HAVERFORD RD & WOODCREST AV",
        "CALL:FD INVESTIGATION",
        "X:HAVERFORD RD & WOODCREST AV");
  }
  
  public static void main(String[] args) {
    new PADelawareCountyEParserTest().generateTests("T1");
  }
}
