package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYRocklandCountyAParserTest extends BaseParserTest {
  
  public NYRocklandCountyAParserTest() {
    setParser(new NYRocklandCountyAParser(), "ROCKLAND COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "AUTOMATIC ALARM at 254 S MAIN ST, New City c/s:ELINOR PL SCHRIEVER LN . . 18:59:20",
        "CALL:AUTOMATIC ALARM",
        "ADDR:254 S MAIN ST",
        "CITY:New City",
        "X:ELINOR PL SCHRIEVER LN",
        "TIME:18:59:20");

    doTest("T2",
        "NATURAL GAS - OUTSIDE at 108 BIRCH LN, New City c/s: OLD BRICK RD / RED HILLRD . . 22:15:43",
        "CALL:NATURAL GAS - OUTSIDE",
        "ADDR:108 BIRCH LN",
        "CITY:New City",
        "X:OLD BRICK RD / RED HILLRD",
        "TIME:22:15:43");

    doTest("T3",
        "AUTOMATIC ALARM at 129 STRAWTOWN RD, New City c/s: VILLAGE WAY / RONE CT . . 00:07:21",
        "CALL:AUTOMATIC ALARM",
        "ADDR:129 STRAWTOWN RD",
        "CITY:New City",
        "X:VILLAGE WAY / RONE CT",
        "TIME:00:07:21");

    doTest("T4",
        "VEHICLE FIRE at 48 GERMONDS RD, New City c/s: ROUTE 304 / LYNCREST AV . . 15:14:38",
        "CALL:VEHICLE FIRE",
        "ADDR:48 GERMONDS RD",
        "CITY:New City",
        "X:ROUTE 304 / LYNCREST AV",
        "TIME:15:14:38");

    doTest("T5",
        "CO W/ SYMPTOMS at 85 OLD PHILLIPS HILL RD, New City c/s: MAHONEY CT / BUENA VISTA RD . . 18:18:51",
        "CALL:CO W/ SYMPTOMS",
        "ADDR:85 OLD PHILLIPS HILL RD",
        "CITY:New City",
        "X:MAHONEY CT / BUENA VISTA RD",
        "TIME:18:18:51");

    doTest("T6",
        "BRUSH/MULCH/RUBBISH OUTSIDE at 14 OLD ROUTE 304, New City c/s: FAIR HAVEN DR, WESTGATE BLVD / N MAIN ST, ZUKOR RD 16:16:06",
        "CALL:BRUSH/MULCH/RUBBISH OUTSIDE",
        "ADDR:14 OLD ROUTE 304",
        "CITY:New City",
        "X:FAIR HAVEN DR",
        "INFO:WESTGATE BLVD / N MAIN ST, ZUKOR RD 16:16:06");

    doTest("T7",
        "HAAZMAT at CONGERS RD/MAIN ST, New City . . 10:40:52",
        "CALL:HAAZMAT",
        "ADDR:CONGERS RD & MAIN ST",
        "CITY:New City",
        "TIME:10:40:52");

    doTest("T8",
        "  / ALARM SOUNDING at 254 S MAIN ST, New City  c/s: ELINOR PL / SCHRIEVER LN . . 14:01:52\n",
        "CALL:ALARM SOUNDING",
        "ADDR:254 S MAIN ST",
        "CITY:New City",
        "X:ELINOR PL / SCHRIEVER LN",
        "TIME:14:01:52");

  }
  
  public static void main(String[] args) {
    new NYRocklandCountyAParserTest().generateTests("T1", "CALL ADDR CITY X TIME");
  }
}