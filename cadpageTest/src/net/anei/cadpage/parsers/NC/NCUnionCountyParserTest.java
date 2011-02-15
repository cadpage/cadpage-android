package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCUnionCountyParserTest extends BaseParserTest {
  
  public NCUnionCountyParserTest() {
    setParser(new NCUnionCountyParser(), "UNION COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:3711 WHITE STORE RD;WINGATE;OUTSIDE FIRE;S09;WITMORE RD;NASH RD;02/15/2011 13:21:38",
        "ADDR:3711 WHITE STORE RD",
        "CITY:WINGATE",
        "CALL:OUTSIDE FIRE",
        "SRC:S09",
        "X:WITMORE RD & NASH RD");

  }
  

  public static void main(String[] args) {
    new NCUnionCountyParserTest().generateTests("T1");
  }
}
