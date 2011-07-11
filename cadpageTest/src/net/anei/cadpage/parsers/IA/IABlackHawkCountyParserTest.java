package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IA.IABlackHawkCountyParser;

import org.junit.Test;


public class IABlackHawkCountyParserTest extends BaseParserTest {
  
  public IABlackHawkCountyParserTest() {
    setParser(new IABlackHawkCountyParser(), "BLACK HAWK COUNTY", "IA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "10-127299 MVA ROLLOVER/20 HWY SERGEANT RD WATERLOO",
        "ID:10-127299",
        "CALL:MVA ROLLOVER /",
        "ADDR:20 HWY SERGEANT RD",
        "CITY:WATERLOO");
    
    doTest("T2",
        "10-124880 MVA ROLLOVER 1941 W 6TH ST EUREKA/ MITCHELL/WATERLOO",
        "ID:10-124880",
        "CALL:MVA ROLLOVER",
        "ADDR:1941 W 6TH ST",
        "X:EUREKA / MITCHELL",
        "CITY:WATERLOO");
   
  }
}