package net.anei.cadpage.parsers.MS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MSCalhounCountyParserTest extends BaseParserTest {
  
  public MSCalhounCountyParserTest() {
    setParser(new MSCalhounCountyParser(), "CALHOUN COUNTY", "MS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch Alert) Call Type: BANNER EMR\nCity: VARDAMAN\nAddress: 10 CR 117",
        "CALL:BANNER EMR",
        "ADDR:10 CR 117",
        "MADDR:10 COUNTY ROAD 117",
        "CITY:VARDAMAN");

    doTest("T2",
        "(Dispatch Alert) Call Type: BANNER EMR\nCity: VARDAMAN\nAddress: 123 N MAIN ST",
        "CALL:BANNER EMR",
        "ADDR:123 N MAIN ST",
        "CITY:VARDAMAN");

    doTest("T3",
        "(Dispatch Alert) Call Type: BANNER EMR\nCity: PITTSBORO\nAddress: 45 CR 104",
        "CALL:BANNER EMR",
        "ADDR:45 CR 104",
        "MADDR:45 COUNTY ROAD 104",
        "CITY:PITTSBORO");

  }
  
  public static void main(String[] args) {
    new MSCalhounCountyParserTest().generateTests("T1", "CALL ADDR X CITY NAME PHONE MAP ID");
  }
}