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
        "INFO:WITMORE RD",
        "X:NASH RD");

    doTest("T2",
        "CAD:3812 E HWY 74;WINGATE;SICK PERSON EMD;S09;FX-CF2;BIVENS ST;N STEWART ST;02/18/2011 16:03:05;FOOD LION WINGATE",
        "ADDR:3812 E HWY 74",
        "CITY:WINGATE",
        "CALL:SICK PERSON EMD",
        "SRC:S09",
        "INFO:FX-CF2",
        "X:BIVENS ST & N STEWART ST",
        "PLACE:FOOD LION WINGATE");

    doTest("T3",
        "CAD:3626 HAYES RD;INDIAN TRAIL;BREATHING PROBLEMS EMD;S19;BR-2;OLD CHARLOTTE HWY;OLD CHARLOTTE HWY;09/26/2011 19:37:34",
        "ADDR:3626 HAYES RD",
        "CITY:INDIAN TRAIL",
        "CALL:BREATHING PROBLEMS EMD",
        "SRC:S19",
        "INFO:BR-2",
        "X:OLD CHARLOTTE HWY & OLD CHARLOTTE HWY");

    doTest("T4",
        "CAD:604 SUNSET ST;MARSHVILLE;STRUCTURE FIRE EFD;CFD;S08",
        "ADDR:604 SUNSET ST",
        "CITY:MARSHVILLE",
        "CALL:STRUCTURE FIRE EFD",
        "SRC:CFD",
        "INFO:S08");
  }
  

  public static void main(String[] args) {
    new NCUnionCountyParserTest().generateTests("T1");
  }
}
