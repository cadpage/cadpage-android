package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class COElPasoCountyParserTest extends BaseParserTest {
  
  public COElPasoCountyParserTest() {
    setParser(new COElPasoCountyParser(), "EL PASO COUNTY", "CO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAL FD - Unconscious / Fainti24615 Scott Rd                Big Cats of Ser[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See \" P\r",
        "SRC:CAL FD",
        "CALL:Unconscious / Fainti",
        "ADDR:24615 Scott Rd",
        "PLACE:Big Cats of Ser",
        "INFO:[Premise:  24615 SCOTT RD] [Low] [UNKNOWN] See \" P");

    doTest("T2",
        "CAL FD - Medical             1222 Ververs Ln                              1481 transporting,no further resp needed,Automatic\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:1222 Ververs Ln",
        "INFO:1481 transporting,no further resp needed,Automatic");

    doTest("T3",
        "CAL FD - Medical             5TH ST / CASCADE ST                          5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:5TH ST & CASCADE ST",  // Not mapping
        "INFO:5C42  NEED MEDICAL - SCRAPE ON HEAD -[Shared],5C42");

    doTest("T4",
        "CAL FD - Medical             1350 8th St                                  [Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4\r",
        "SRC:CAL FD",
        "CALL:Medical",
        "ADDR:1350 8th St",
        "INFO:[Page] Unit: 5c46, Sent From: EPSO4 ,MP , 5C46 5C4");

    doTest("T5",
        "CAL FD - Chest Pain          185 4th St                    Calhan Full Gos911ALI Info: Verizon WRLS 800-451-5242, Wireless,\r",
        "SRC:CAL FD",
        "CALL:Chest Pain",
        "ADDR:185 4th St",
        "PLACE:Calhan Full Gos",
        "INFO:911ALI Info: Verizon WRLS 800-451-5242, Wireless,");

  }
  
  public static void main(String[] args) {
    new COElPasoCountyParserTest().generateTests("T1", "SRC CALL ADDR APT PLACE INFO");
  }
}