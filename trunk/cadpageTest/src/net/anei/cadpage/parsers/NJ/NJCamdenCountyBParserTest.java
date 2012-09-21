package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJCamdenCountyBParserTest extends BaseParserTest {
  
  public NJCamdenCountyBParserTest() {
    setParser(new NJCamdenCountyBParser(), "CAMDEN COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CCCAlert) REQ FOR FM TO RESPOND - 508 MAIN AVE. BEDROOM FIRE. UNDER CONTROL.",
        "CALL:REQ FOR FM TO RESPOND -",
        "ADDR:508 MAIN AVE",
        "INFO:BEDROOM FIRE UNDER CONTROL");

    doTest("T2",
        "(CCCAlert) 2 BLS UNITS AND RESCUE OPERATING AT RT 561 AND MORRIS DRIVE FOR AN OVERTURNED DUMP TRUCK ON TOP OF A VEHICLE",
        "CALL:2 BLS UNITS AND RESCUE OPERATING",
        "ADDR:RT 561 AND MORRIS DRIVE",
        "INFO:FOR AN OVERTURNED DUMP TRUCK ON TOP OF A VEHICLE");

    doTest("T3",
        "(CCCAlert) 2 BLS UNITS AND RESCUE OPERATING AT RT 561 AND MORRIS DRIVE FOR AN OVERTURNED DUMP TRUCK ON TOP OF A VEHICLE",
        "CALL:2 BLS UNITS AND RESCUE OPERATING",
        "ADDR:RT 561 AND MORRIS DRIVE",
        "INFO:FOR AN OVERTURNED DUMP TRUCK ON TOP OF A VEHICLE");

    doTest("T4",
        "(CCCAlert) e1351 ol at s135 with a vehicle that has hit the side of the building reporting structural damage ",
        "CALL:e1351 ol",
        "ADDR:s135 with a vehicle that has hit the side of the building reporting structural damage");

    doTest("T5",
        "(CCCAlert) REQ FOR FM TO RESPOND - 508 MAIN AVE. BEDROOM FIRE. UNDER CONTROL.",
        "CALL:REQ FOR FM TO RESPOND -",
        "ADDR:508 MAIN AVE",
        "INFO:BEDROOM FIRE UNDER CONTROL");

    doTest("T6",
        "(CCCAlert) DWELLING 1513 BRICK RD / SQ1331 ON LOCATION REPORTING  2 STY SINGLE FAMILY SMOKE SHOWING FROM FRONT DOOR",
        "CALL:DWELLING",
        "ADDR:1513 BRICK RD",
        "INFO:/ SQ1331 ON LOCATION REPORTING 2 STY SINGLE FAMILY SMOKE SHOWING FROM FRONT DOOR");
  }
  
  public static void main(String[] args) {
    new NJCamdenCountyBParserTest().generateTests("T1", "CALL ADDR APT INFO");
  }
}