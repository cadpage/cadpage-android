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
        "PRI:1",
        "UNIT:R09",
        "NAME:STOK");

    doTest("T2",
        "Location: 6206 REIDSVILLE RD FC: @CREEKSIDE MANOR Nature: Chest Pain/Heart Problems P:1  - WITH_SYMPTOMS DISTRICT: R31 X Str: GOODWILL CHURCH RD/PINEY GR",
        "ADDR:6206 REIDSVILLE RD",
        "PLACE:CREEKSIDE MANOR",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:R31",
        "X:GOODWILL CHURCH RD/PINEY GR");

    doTest("T3",
        "Location: 9350 FREEMAN RD FC Nature: Headache P:1  - VISION_PROBLEMS DISTRICT: R31 X Str: PINEY GROVE RD/GOODWILL CHURCH RD CALLER NAME: MARTIN, NAOMI",
        "ADDR:9350 FREEMAN RD",
        "CALL:Headache",
        "PRI:1",
        "UNIT:R31",
        "X:PINEY GROVE RD/GOODWILL CHURCH RD",
        "NAME:MARTIN, NAOMI");

    doTest("T4",
        "Location: 6000BLK REIDSVILLE RD FC Nature: PUBLIC SERVICE CALL P:3  - default DISTRICT: F31 X Str: BRINKLEY RD/GOODWILL CHURCH RD CALLER NAME:",
        "ADDR:6000BLK REIDSVILLE RD",
        "MADDR:6000 REIDSVILLE RD",
        "CALL:PUBLIC SERVICE CALL",
        "PRI:3",
        "UNIT:F31",
        "X:BRINKLEY RD/GOODWILL CHURCH RD");

    doTest("T5",
        "Location: 1105 WHISPERING PINES DR FC Nature: Power Lines Arcing on Pole P:2  - default DISTRICT: F31 X Str: WARDS POND CT/QUAIL HOLLOW RD CALLER NAME:",
        "ADDR:1105 WHISPERING PINES DR",
        "CALL:Power Lines Arcing on Pole",
        "PRI:2",
        "UNIT:F31",
        "X:WARDS POND CT/QUAIL HOLLOW RD");

    doTest("T6",
        "Location: 5825 POPPY SEED DR FC Nature: Brush Fire P:1  - default DISTRICT: F31 X Str: BRINKLEY PARK DR/JILAIN ST CALLER NAME: CARANNA, KENWYN",
        "ADDR:5825 POPPY SEED DR",
        "CALL:Brush Fire",
        "PRI:1",
        "UNIT:F31",
        "X:BRINKLEY PARK DR/JILAIN ST",
        "NAME:CARANNA, KENWYN");

    doTest("T7",
        "Location: 1800 SPRINGFIELD FARM CT CL Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: SPRINGFIELD FARM RD/ CALLER NAME:",
        "ADDR:1800 SPRINGFIELD FARM CT",
        "CITY:CLEMMONS",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:R11",
        "X:SPRINGFIELD FARM RD/");

    doTest("T8",
        "Location: 4595 STYERS FERRY RD WS Nature: Sick/Unknown P:1  - default DISTRICT: R11 X Str: FOX RIDGE LN/REMINGTON DR CALLER NAME:",
        "ADDR:4595 STYERS FERRY RD",
        "CITY:WINSTON-SALEM",
        "CALL:Sick/Unknown",
        "PRI:1",
        "UNIT:R11",
        "X:FOX RIDGE LN/REMINGTON DR");

    doTest("T9",
        "Nature: Motor Vehicle Accident P:1  - default DISTRICT: R11 X Str: LEWISVILLE-CLEMMONS RD/REYNOLDS RD CALLER NAME:",
        "ADDR:LEWISVILLE-CLEMMONS RD & REYNOLDS RD",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:R11");

    doTest("T10",
        "Location: NB 421 FC Nature: Motor Vehicle Accident P:1  - default DISTRICT: R13 X Str: SCOTT RD/SB 421 CALLER NAME: FCSD",
        "ADDR:NB 421",
        "MADDR:421 & SCOTT RD",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:R13",
        "X:SCOTT RD/SB 421",
        "NAME:FCSD");

    doTest("T11",
        "Location: 191 LOWES FOOD DR FC: @A CLEANER WORLD Nature: Alarms - Fire or Smoke P:1  - default DISTRICT: F11 X Str: JENNINGS RD/SHALLOWFORD RD CALLER",
        "ADDR:191 LOWES FOOD DR",
        "PLACE:A CLEANER WORLD",
        "CALL:Alarms - Fire or Smoke",
        "PRI:1",
        "UNIT:F11",
        "X:JENNINGS RD/SHALLOWFORD RD");

    doTest("T12",
        "Location: 6441 HOLDER RD CL,RM 8: @CLEMMONS VILLAGE II Nature: Breathing Difficulty P:1  - BREATHING_DIFF DISTRICT: R11 X Str: HOLDER CT/SOUTHWEST SCH",
        "ADDR:6441 HOLDER RD",
        "CITY:CLEMMONS",
        "APT:8",
        "PLACE:CLEMMONS VILLAGE II",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:R11",
        "X:HOLDER CT/SOUTHWEST SCH");
    
    doTest("T13",
        "Location: 1 STOKES COUNTY: @STOKES COUNTY:511 WINDMILL ST Nature: DOA P:1  - default DISTRICT: F09 X Str: / CALLER NAME: 1224",
        "ADDR:511 WINDMILL ST",
        "CITY:STOKES COUNTY",
        "CALL:DOA",
        "PRI:1",
        "UNIT:F09",
        "NAME:1224");

    doTest("T14",
        "Location: NB 311 WS Nature: Motor Vehicle Accident P:1  - default DISTRICT: F28 X Str: UNION CROSS RD_NB 311 RA/NB 311_RIDGEWOOD",
        "ADDR:NB 311",
        "MADDR:311 & UNION CROSS RD 311",
        "CITY:WINSTON-SALEM",
        "CALL:Motor Vehicle Accident",
        "PRI:1",
        "UNIT:F28",
        "X:UNION CROSS RD NB 311 RA/NB 311 RIDGEWOOD");

    doTest("T15",
        "Location: 125 CHAUCER VIEW CIR KE Nature: Chest Pain/Heart Problems P:1  - default DISTRICT: F41 X Str: CHAUCER MANOR LN/CHAUCER",
        "ADDR:125 CHAUCER VIEW CIR",
        "CITY:KERNERSVILLE",
        "CALL:Chest Pain/Heart Problems",
        "PRI:1",
        "UNIT:F41",
        "X:CHAUCER MANOR LN/CHAUCER");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Location: 6010 MEADOWBROOK MALL CT CL: @CREST OF CLEMMONS Nature: Unconscious/Unresponsive/Syncope P:1  - CONFIRMED DISTRICT: F14 X Str: RAMADA DR/ CALLER NAME: THE CREST OF CLEMMONS",
        "ADDR:6010 MEADOWBROOK MALL CT",
        "CITY:CLEMMONS",
        "PLACE:CREST OF CLEMMONS",
        "CALL:Unconscious/Unresponsive/Syncope",
        "PRI:1",
        "UNIT:F14",
        "X:RAMADA DR/",
        "NAME:THE CREST OF CLEMMONS");

    doTest("T2",
        "Location: 3905 CLEMMONS RD CL: @REGENCY CARE OF CLEMMONS Nature: Breathing Difficulty P:1  - OVER_50_DIFF DISTRICT: F14 X Str: BRIDGEWATER DR/JOY PARK LN CALLER NAME: DOMINION MANAGEMENT GROUP / FORS",
        "ADDR:3905 CLEMMONS RD",
        "CITY:CLEMMONS",
        "PLACE:REGENCY CARE OF CLEMMONS",
        "CALL:Breathing Difficulty",
        "PRI:1",
        "UNIT:F14",
        "X:BRIDGEWATER DR/JOY PARK LN",
        "NAME:DOMINION MANAGEMENT GROUP / FORS");

  }
  
  public static void main(String[] args) {
    new NCForsythCountyParserTest().generateTests("T16");
  }
}

