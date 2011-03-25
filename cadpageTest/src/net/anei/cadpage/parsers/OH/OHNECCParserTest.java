package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHNECCParserTest extends BaseParserTest {
  
  public OHNECCParserTest() {
    setParser(new OHNECCParser(), "", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(NECC) [F] LV:1 ALARM CARBON MONOXIDE NO SYMPTOMS\n/\n1619 W LOVELAND AV\n(LV)\nXS: S LEBANON RD & HEIDELBURG DR\n\nRCVD AS Phone\n\nCOM:\nALARM ACTIVATED",
        "CALL:ALARM CARBON MONOXIDE NO SYMPTOMS",
        "ADDR:1619 W LOVELAND AV",
        "CITY:LOVELAND",
        "X:S LEBANON RD & HEIDELBURG DR",
        "INFO:ALARM ACTIVATED");

    doTest("T2",
        "[NECC]  [F] LV:1 ALARM FIRE\n/\nCHILI'S GRILL & BAR\n11329<tel:11329> MONTGOMERY RD\n(SY)\nXS: HARPERSPOINTE DR & E KEMPER RD\n\nRCVD AS Phone\n\nCOM:\nF28 FIRE DUCT ALARM\nE9",
        "CALL:ALARM FIRE",
        "PLACE:CHILI'S GRILL & BAR",
        "PHONE:11329",
        "ADDR:11329 MONTGOMERY RD",
        "CITY:SYMMES",
        "X:HARPERSPOINTE DR & E KEMPER RD",
        "INFO:F28 FIRE DUCT ALARM / E9");

    doTest("T3",
        "(NECC) [F] LV:1 AUTO ACCIDENT INJURY\n/\nFIELDS ERTEL RD/UNION CEMETERY RD\n(SY)\nXS: UNION CEMETERY RD & GREEN ARBORS LN\n\nRCVD AS Phone\n\nCOM:",
        "CALL:AUTO ACCIDENT INJURY",
        "ADDR:FIELDS ERTEL RD & UNION CEMETERY RD",
        "CITY:SYMMES",
        "X:UNION CEMETERY RD & GREEN ARBORS LN");

    doTest("T4",
        "(NECC) [F] LV:1 AUTO ACCIDENT VEHICLE FIRE\n/\nBECKER\n9695 LOVELAND MADEIRA RD\n(SY)\nXS: HUMPHREY RD & MORGANS TRACE\n\nRCVD AS Phone",
        "CALL:AUTO ACCIDENT VEHICLE FIRE",
        "PLACE:BECKER",
        "ADDR:9695 LOVELAND MADEIRA RD",
        "CITY:SYMMES",
        "X:HUMPHREY RD & MORGANS TRACE");
     
  }
  
  public static void main(String[] args) {
    new OHNECCParserTest().generateTests("T1");
  }
}