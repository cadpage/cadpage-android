package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMontgomeryCountyParserTest extends BaseParserTest {
  
  public NCMontgomeryCountyParserTest() {
    setParser(new NCMontgomeryCountyParser(), "MONTGOMERY COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:DAYS INN 531 EAST MAIN ST 105 BISCOE 14:14:20 ASSAULT - SEXUAL ASSAULT man an woman was fighting and then fm turned on caller.",
        "PLACE:DAYS INN",
        "ADDR:531 EAST MAIN ST 105",
        "CITY:BISCOE",
        "TIME:14:14:20",
        "CALL:ASSAULT",
        "INFO:SEXUAL ASSAULT man an woman was fighting and then fm turned on caller.");

    doTest("T2",
        "CAD:1344 NC HWY 109 S MT GILEAD MDL 09E01 19:26:03 CARDIAC OR RESPIRATORY ARREST - DEATH",
        "ADDR:1344 NC HWY 109 S",
        "MADDR:1344 NC 109 S",
        "CITY:MT GILEAD",
        "CODE:09E01",
        "TIME:19:26:03",
        "CALL:CARDIAC OR RESPIRATORY ARREST",
        "INFO:DEATH");

    doTest("T3",
        "CAD:1344 NC HWY 109 S MT GILEAD 19:21:52 UNCONSCIOUS - FAINTING (NEAR) E",
        "ADDR:1344 NC HWY 109 S",
        "MADDR:1344 NC 109 S",
        "CITY:MT GILEAD",
        "TIME:19:21:52",
        "CALL:UNCONSCIOUS",
        "INFO:FAINTING (NEAR) E");

    doTest("T4",
        "CAD:348 AUMAN RD BISCOE 17:25:35 ASSAULT - SEXUAL ASSAULT ASSAULT CALLERS SON GAVE FM BLACK EYE",
        "ADDR:348 AUMAN RD",
        "CITY:BISCOE",
        "TIME:17:25:35",
        "CALL:ASSAULT",
        "INFO:SEXUAL ASSAULT ASSAULT CALLERS SON GAVE FM BLACK EYE");
  }
  

  public static void main(String[] args) {
    new NCMontgomeryCountyParserTest().generateTests("T1", "PLACE ADDR APT CITY CODE TIME CALL INFO");
  }
}
