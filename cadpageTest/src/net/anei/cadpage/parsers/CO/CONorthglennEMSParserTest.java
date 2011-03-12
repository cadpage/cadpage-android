package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.CO.CONorthglennEMSParser;

import org.junit.Test;


public class CONorthglennEMSParserTest extends BaseParserTest {
  
  public CONorthglennEMSParserTest() {
    setParser(new CONorthglennEMSParser(), "ADAMS COUNTY", "CO");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "- part 1 of 1 / RC:Run# 10174/6211 OLIVE ST///Pregnancy / Childbirth/",
        "ID:10174",
        "ADDR:6211 OLIVE ST",
        "CALL:Pregnancy / Childbirth");

    doTest("T2",
        "- part 1 of 1 / RC:Run# 9913/5541 E 67TH AVE//med alarm/Not Available/",
        "ID:9913",
        "ADDR:5541 E 67TH AVE",
        "CALL:med alarm / Not Available");
    
    doTest("T3",
        "- part 1 of 1 / RC:Run# 9911/7373 BIRCH ST///Unconscious / Fainting/",
        "ID:9911",
        "ADDR:7373 BIRCH ST",
        "CALL:Unconscious / Fainting");
    
    doTest("T4",
        "- part 1 of 1 / RC:Run# 10172/8810 E 88TH AVE///Assault/",
        "ID:10172",
        "ADDR:8810 E 88TH AVE",
        "CALL:Assault");
    
    doTest("T5",
        "- part 1 of 1 / RC:Run# 10119/E 60TH AVE & DAHLIA ST//./Unconscious / Fainting/",
        "ID:10119",
        "ADDR:E 60TH AVE & DAHLIA ST",
        "CALL:. / Unconscious / Fainting");
 }
}