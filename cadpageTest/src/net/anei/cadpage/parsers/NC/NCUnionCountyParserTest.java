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
        "CAD:3812 E HWY 74;WINGATE;SICK PERSON EMD;S09;FX-CF2;BIVENS ST;N STEWART ST;02/18/2011 16:03:05;FOOD LION WINGATE",
        "ADDR:3812 E HWY 74",
        "CITY:WINGATE",
        "CALL:SICK PERSON EMD",
        "SRC:S09",
        "INFO:FX-CF2",
        "X:BIVENS ST & N STEWART ST",
        "PLACE:FOOD LION WINGATE");
  }
  

  public static void main(String[] args) {
    new NCUnionCountyParserTest().generateTests("T1");
  }
}
