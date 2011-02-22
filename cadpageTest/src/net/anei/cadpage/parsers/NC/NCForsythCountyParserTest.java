package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCForsythCountyParserTest extends BaseParserTest {
  
  public NCForsythCountyParserTest() {
    setParser(new NCForsythCountyParser(), "FORSYTH COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY: 2312 HWY 65 E Nature: Unconscious/Unresponsive/Syncope P:1  - default DISTRICT: R09 X Str: / CALLER NAME: STOK",
        "ADDR:2312 HWY 65 E",
        "CITY:STOKES COUNTY",
        "CALL:Unconscious/Unresponsive/Syncope",
        "UNIT:R09",
        "NAME:STOK");

    doTest("T2",
        "Location: 6206 REIDSVILLE RD FC: @CREEKSIDE MANOR Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: R31 X Str: GOODWILL CHURCH RD/PINEY GR",
        "ADDR:6206 REIDSVILLE RD",
        "PLACE:CREEKSIDE MANOR",
        "CALL:Chest Pain/Heart Problems",
        "UNIT:R31",
        "X:GOODWILL CHURCH RD/PINEY GR");

    doTest("T3",
        "Location: 9350 FREEMAN RD FC Nature: Headache P:1  - VISION_PROBLEMS DISTRICT: R31 X Str: PINEY GROVE RD/GOODWILL CHURCH RD CALLER NAME: MARTIN, NAOMI",
        "ADDR:9350 FREEMAN RD",
        "CALL:Headache",
        "UNIT:R31",
        "X:PINEY GROVE RD/GOODWILL CHURCH RD",
        "NAME:MARTIN, NAOMI");

    doTest("T4",
        "Location: 6000BLK REIDSVILLE RD FC Nature: PUBLIC SERVICE CALL P:3  - default DISTRICT: F31 X Str: BRINKLEY RD/GOODWILL CHURCH RD CALLER NAME:",
        "ADDR:6000BLK REIDSVILLE RD",
        "CALL:PUBLIC SERVICE CALL",
        "UNIT:F31",
        "X:BRINKLEY RD/GOODWILL CHURCH RD");

    doTest("T5",
        "Location: 1105 WHISPERING PINES DR FC Nature: Power Lines Arcing on Pole P:2  - default DISTRICT: F31 X Str: WARDS POND CT/QUAIL HOLLOW RD CALLER NAME:",
        "ADDR:1105 WHISPERING PINES DR",
        "CALL:Power Lines Arcing on Pole",
        "UNIT:F31",
        "X:WARDS POND CT/QUAIL HOLLOW RD");

    doTest("T6",
        "Location: 5825 POPPY SEED DR FC Nature: Brush Fire P:1  - default DISTRICT: F31 X Str: BRINKLEY PARK DR/JILAIN ST CALLER NAME: CARANNA, KENWYN",
        "ADDR:5825 POPPY SEED DR",
        "CALL:Brush Fire",
        "UNIT:F31",
        "X:BRINKLEY PARK DR/JILAIN ST",
        "NAME:CARANNA, KENWYN");
  }
  
  public static void main(String[] args) {
    new NCForsythCountyParserTest().generateTests("T1");
  }
}

