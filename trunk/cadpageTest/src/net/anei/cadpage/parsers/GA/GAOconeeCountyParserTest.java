package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.GA.GAOconeeCountyParser;

import org.junit.Test;


public class GAOconeeCountyParserTest extends BaseParserTest {
  
  public GAOconeeCountyParserTest() {
    setParser(new GAOconeeCountyParser(), "OCONEE COUNTY", "GA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 4047 COLHAM FERRY RD 8583046",
        "PHONE:7060000000",
        "CALL:S28 SICK PERSON",
        "ADDR:4047 COLHAM FERRY RD");

    doTest("T2",
        "OCSO E911:Return Phone: 7060000000 S28 SICK PERSON 385 JEFFERSON AVE 2029728",
        "PHONE:7060000000",
        "CALL:S28 SICK PERSON",
        "ADDR:385 JEFFERSON AVE");
    
    doTest("T3",
        "OCSO E911:1090F FIRE ALARM 1021 WOOD HOLLOW LN 5482767 CRYSTAL HILLS DR",
        "CALL:1090F FIRE ALARM",
        "ADDR:1021 WOOD HOLLOW LN",
        "X:CRYSTAL HILLS DR");
    
    doTest("T4",
        "OCSO E911:1073 SMOKE 1421 BEVERLY DR 5495253 NONA DRIVE",
        "CALL:1073 SMOKE",
        "ADDR:1421 BEVERLY DR",
        "X:NONA DRIVE");

    doTest("T5",
        "OCSO E911:1070 FIRE 1280 ASHLAND DR 7250300 HWY 53",
        "CALL:1070 FIRE",
        "ADDR:1280 ASHLAND DR",
        "X:HWY 53");
  }
}
