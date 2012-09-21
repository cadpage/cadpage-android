package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VARoanokeCityParserTest extends BaseParserTest {
  
  public VARoanokeCityParserTest() {
    setParser(new VARoanokeCityParser(), "ROANOKE CITY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Working Fire at 1401 ORANGE AVE NW",
        "CALL:Working Fire",
        "ADDR:1401 ORANGE AVE NW");

    doTest("T2",
        "Working Fire at 2802 COLONIAL AVE SWAPT 16",
        "CALL:Working Fire",
        "ADDR:2802 COLONIAL AVE SW",
        "APT:16");

    doTest("T3",
        "Working Fire at 5046 WILLIAMSON RD NW",
        "CALL:Working Fire",
        "ADDR:5046 WILLIAMSON RD NW");

  }
  
  public static void main(String[] args) {
    new VARoanokeCityParserTest().generateTests("T1", "CALL ADDR APT");
  }
}