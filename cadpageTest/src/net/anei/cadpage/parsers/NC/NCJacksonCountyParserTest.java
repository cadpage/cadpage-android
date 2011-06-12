package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCJacksonCountyParserTest extends BaseParserTest {
  
  public NCJacksonCountyParserTest() {
    setParser(new NCJacksonCountyParser(), "JACKSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "Bill:9783 CHARLEYS CREEK RD TUCKASEGEE MDL 26A03 2011009480 22:20:01 SICK PERSON (SPECIFIC DIAGNOSIS) CALLER ADV SHE HAD HEART SURGERY A LITTLE WHILE AGO AND HER",
        "ADDR:9783 CHARLEYS CREEK RD",
        "CITY:TUCKASEGEE",
        "CODE:26A03",
        "ID:2011009480",
        "CALL:SICK PERSON",
        "INFO:(SPECIFIC DIAGNOSIS) CALLER ADV SHE HAD HEART SURGERY A LITTLE WHILE AGO AND HER");

    doTest("T2",
        "Bill:1 CHARLEYS CREEK RD/NEDDY MTN 2011010597 08:40:01 10-50D ACCIDENT/PROPERTY DAMAGE ADVS SINGLE CAR 10-50, NO PI",
        "ADDR:1 CHARLEYS CREEK RD",
        "PLACE:/ NEDDY MTN",
        "ID:2011010597",
        "INFO:10-50D ACCIDENT/PROPERTY DAMAGE ADVS SINGLE CAR 10-50, NO PI");
  }
  
  public static void main(String[] args) {
    new NCJacksonCountyParserTest().generateTests("T1", "ADDR CITY PLACE CODE ID CALL INFO");
  }
}
