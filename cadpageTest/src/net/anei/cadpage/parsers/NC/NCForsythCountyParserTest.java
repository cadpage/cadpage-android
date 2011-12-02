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
        "MADDR:6000 REIDSVILLE RD",
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

    doTest("T7",
        "Location: 1800 SPRINGFIELD FARM CT CL Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: SPRINGFIELD FARM RD/ CALLER NAME:",
        "ADDR:1800 SPRINGFIELD FARM CT",
        "CITY:CLEMMONS",
        "CALL:Breathing Difficulty",
        "UNIT:R11",
        "X:SPRINGFIELD FARM RD/");

    doTest("T8",
        "Location: 4595 STYERS FERRY RD WS Nature: Sick/Unknown P:1  - default DISTRICT: R11 X Str: FOX RIDGE LN/REMINGTON DR CALLER NAME:",
        "ADDR:4595 STYERS FERRY RD",
        "CITY:WINSTON-SALEM",
        "CALL:Sick/Unknown",
        "UNIT:R11",
        "X:FOX RIDGE LN/REMINGTON DR");

    doTest("T9",
        "Nature: Motor Vehicle Accident P:1  - default DISTRICT: R11 X Str: LEWISVILLE-CLEMMONS RD/REYNOLDS RD CALLER NAME:",
        "ADDR:LEWISVILLE-CLEMMONS RD & REYNOLDS RD",
        "CALL:Motor Vehicle Accident",
        "UNIT:R11");

    doTest("T10",
        "Location: NB 421 FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: R13 X Str: SCOTT RD/SB 421 CALLER NAME: FCSD",
        "ADDR:NB 421",
        "CALL:Motor Vehicle Accident",
        "UNIT:R13",
        "X:SCOTT RD/SB 421",
        "NAME:FCSD");

    doTest("T11",
        "Location: 191 LOWES FOOD DR FC: @A CLEANER WORLD Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F11 X Str: JENNINGS RD/SHALLOWFORD RD CALLER",
        "ADDR:191 LOWES FOOD DR",
        "PLACE:A CLEANER WORLD",
        "CALL:Alarms - Fire or Smoke",
        "UNIT:F11",
        "X:JENNINGS RD/SHALLOWFORD RD");

    doTest("T12",
        "Location: 6441 HOLDER RD CL,RM 8: @CLEMMONS VILLAGE II Nature: Breathing Difficulty P:1\2s- BREATHING_DIFF DISTRICT: R11 X Str: HOLDER CT/SOUTHWEST SCH",
        "ADDR:6441 HOLDER RD CL,RM 8",
        "PLACE:CLEMMONS VILLAGE II",
        "CALL:Breathing Difficulty",
        "UNIT:R11",
        "X:HOLDER CT/SOUTHWEST SCH");
 }
  
  public static void main(String[] args) {
    new NCForsythCountyParserTest().generateTests("T12");
  }
}

