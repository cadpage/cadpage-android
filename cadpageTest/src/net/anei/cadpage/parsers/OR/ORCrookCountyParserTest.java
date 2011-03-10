package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORCrookCountyParser;

import org.junit.Test;


public class ORCrookCountyParserTest extends BaseParserTest {
  
  public ORCrookCountyParserTest() {
    setParser(new ORCrookCountyParser(), "CROOK COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(NEW INCIDENT) 3/10/2011 1003\nEVENT # 1103100020 PFD\nMABD - ABDOMINAL PAIN\nPRIORITY 1 \nLOCATION 2250 SE KYLE RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: HA",
        "ID:1103100020 PFD",
        "CALL:MABD - ABDOMINAL PAIN",
        "ADDR:2250 SE KYLE RD",
        "CITY:PRINEVILLE",
        "APT:PREMISE:",
        "INFO:HA");
  }
  
  public static void main(String[] args) {
    new ORCrookCountyParserTest().generateTests("T1");
  }
}