package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Knox County, ME
Contact: Richard Bates <richard.bates@stgeorge.me>
Sender: @knoxcountymaine.gov

(KNOX COUNTY (ME)) 449 island ave structure fire explosion in basement
(KNOX COUNTY (ME)) 19 barter Hill Road, Tenants Harbor.  37 yo f fell possible broken knee
(KNOX COUNTY (ME)) 210 kinney woods rd 53 yo f diff breathing
(KNOX COUNTY (ME)) 86 Port Clyde Rd/ Advent Christian Church for a female
(KNOX COUNTY (ME)) amb needs help lifting patient 130 turkey cove rd

*/

public class MEKnoxCountyParserTest extends BaseParserTest {
  
  public MEKnoxCountyParserTest() {
    setParser(new MEKnoxCountyParser(), "KNOX COUNTY", "ME");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(KNOX COUNTY (ME)) 449 island ave structure fire explosion in basement",
        "CALL:structure fire explosion in basement",
        "ADDR:449 island ave");

    doTest("T2",
        "(KNOX COUNTY (ME)) 19 barter Hill Road, Tenants Harbor.  37 yo f fell possible broken knee",
        "CALL:37 yo f fell possible broken knee",
        "ADDR:19 barter Hill Road",
        "CITY:Tenants Harbor");

    doTest("T3",
        "(KNOX COUNTY (ME)) 210 kinney woods rd 53 yo f diff breathing",
        "CALL:53 yo f diff breathing",
        "ADDR:210 kinney woods rd");

    doTest("T4",
        "(KNOX COUNTY (ME)) 86 Port Clyde Rd/ Advent Christian Church for a female",
        "CALL:Advent Christian Church for a female",
        "ADDR:86 Port Clyde Rd");

    doTest("T5",
        "(KNOX COUNTY (ME)) amb needs help lifting patient 130 turkey cove rd",
        "CALL:amb needs help lifting patient",
        "ADDR:130 turkey cove rd");

  }
  
  public static void main(String[] args) {
    new MEKnoxCountyParserTest().generateTests("T1");
  }
}