package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MEYorkCountyParserTest extends BaseParserTest {
  
  public MEYorkCountyParserTest() {
    setParser(new MEYorkCountyParser(), "YORK COUNTY", "ME");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Page]  MEDICAL EMERGENCY26 EAST SHORE RD Waterboro7/4/2011 12:36",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:26 EAST SHORE RD",
        "CITY:Waterboro");

    doTest("T2",
        "[Page]  FIRE, OTHER161 BEAVER DAM RD Waterboro7/4/2011 11:43",
        "CALL:FIRE, OTHER",
        "ADDR:161 BEAVER DAM RD",
        "CITY:Waterboro");

    doTest("T3",
        "[Page]  MEDICAL EMERGENCYMX 270 MOTOR CROSS TRACKLyman7/3/2011 11:24",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:MX 270 MOTOR CROSS TRACK",
        "CITY:Lyman");

    doTest("T4",
        "[Page]  MEDICAL EMERGENCY54 ROCKY RD Lyman7/2/2011 17:51",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:54 ROCKY RD",
        "CITY:Lyman");

    doTest("T5",
        "[Page]  FIRE, OTHERDEERING RIDGE RD.PHEASANT RUN RD Waterboro7/2/2011 03:22",
        "CALL:FIRE, OTHER",
        "ADDR:DEERING RIDGE RD & PHEASANT RUN RD",
        "CITY:Waterboro");
  }
  
  public static void main(String[] args) {
    new MEYorkCountyParserTest().generateTests("T1", "CALL ADDR CITY");
  }
}