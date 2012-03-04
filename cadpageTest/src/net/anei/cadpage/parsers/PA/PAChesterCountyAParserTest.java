package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyAParserTest extends BaseParserTest {
  
  public PAChesterCountyAParserTest() {
    setParser(new PAChesterCountyAParser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Initial Type: ACCINJA    Final Type:ACCINJA (ACCIDENT - INJURIES / ALS *)\nLoc: W BALTIMORE PK/SCARLETT RD ,60    (V) AKA:",
        "CALL:ACCINJA (ACCIDENT - INJURIES / ALS *)",
        "ADDR:W BALTIMORE PK & SCARLETT RD",
        "MADDR:W BALTIMORE PIKE & SCARLETT RD",
        "CITY:NEW GARDEN TWP");

    doTest("T2",
        "Initial Type: BFALL      Final Type: BFALL   (FALLS - BLS / LIFT ASSIST *)\nLoc: 118 RACE ST ,03 -- RACE PARK APTS btwn E STATE ST & E C",
        "CALL:BFALL (FALLS - BLS / LIFT ASSIST *)",
        "ADDR:118 RACE ST",
        "CITY:KENNETT SQUARE",
        "PLACE:RACE PARK APTS",
        "X:E STATE ST & E C");

    doTest("T3",
        "Initial Type: BSICK      Final Type: BSICK   (SICK PERSON - BLS *)\nLoc: 415 MEGAN CT ,62  btwn VICTORIA GARDENS DR & AZALEA LA (V) AKA",
        "CALL:BSICK (SICK PERSON - BLS *)",
        "ADDR:415 MEGAN CT",
        "CITY:KENNETT TWP",
        "X:VICTORIA GARDENS DR & AZALEA LA");

    doTest("T4",
        "Initial Type: ACVA       Final Type: ACVA    (CVA/STROKE - ALS *)\nLoc: 509 HAZEL AV ,03  btwn N WALNUT ST & WILSON RD (V) AKA:   Munic",
        "CALL:ACVA (CVA/STROKE - ALS *)",
        "ADDR:509 HAZEL AV",
        "MADDR:509 HAZEL AVE",
        "CITY:KENNETT SQUARE",
        "X:N WALNUT ST & WILSON RD",
        "INFO:Munic");

    doTest("T5",
        "Initial Type: ALARMF     Final Type: ALARMF  (ALARM - FIRE *)\nLoc: 100 E SOUTH ST ,03 -- KENNETT HIGH SCHOOL btwn S BROAD ST & CHURCH A",
        "CALL:ALARMF (ALARM - FIRE *)",
        "ADDR:100 E SOUTH ST",
        "CITY:KENNETT SQUARE",
        "PLACE:KENNETT HIGH SCHOOL",
        "X:S BROAD ST & CHURCH");

    doTest("T6",
        "Initial Type: AOD        Final Type: AOD     (OVERDOSE - ALS *)\nLoc: 6 WAYS LA ,62  btwn MUNICIPAL BOUNDARY & E CYPRESS ST (V) AKA:",
        "CALL:AOD (OVERDOSE - ALS *)",
        "ADDR:6 WAYS LA",
        "MADDR:6 WAYS LN",
        "CITY:KENNETT TWP",
        "X:MUNICIPAL BOUNDARY & E CYPRESS ST");

    doTest("T7",
        "(Station 24 EMS Call) Initial Type: BSICK      Final Type: BSICK (SICK PERSON - BLS *)\nLoc: 301 VICTORIA GARDENS DR ,62 -- BRANDYWINE ASSISTED LIVNG btwn L",
        "SRC:Station 24 EMS Call",
        "CALL:BSICK (SICK PERSON - BLS *)",
        "ADDR:301 VICTORIA GARDENS DR",
        "CITY:KENNETT TWP",
        "PLACE:BRANDYWINE ASSISTED LIVNG",
        "X:L");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(Station 36) NOTIFFC    Final Type: NOTIFFC (NOTIFY FIRE CHIEF)\nLoc: 1351 SCOTT RD ,49  btwn MUNICIPAL BOUNDARY &amp; POWELL RD (V) \nAKA:   Municipali",
        "SRC:Station 36",
        "CALL:NOTIFFC (NOTIFY FIRE CHIEF)",
        "ADDR:1351 SCOTT RD",
        "CITY:NEWLIN TWP",
        "X:MUNICIPAL BOUNDARY & POWELL RD",
        "INFO:Municipali");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyAParserTest().generateTests("T1");
  }
}
