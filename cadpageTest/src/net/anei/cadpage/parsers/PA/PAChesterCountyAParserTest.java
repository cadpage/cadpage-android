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
        "Initial Type: ACCINJA    Final Type:ACCINJA (ACCIDENT - INJURIES / ALS *)\n" +  
        "Loc: W BALTIMORE PK/SCARLETT RD ,60    (V) AKA:",
        "CALL:ACCINJA (ACCIDENT - INJURIES / ALS *)",
        "ADDR:W BALTIMORE PK & SCARLETT RD");
    
    doTest("T2",
        "Initial Type: ACCINJA    Final Type:ACCINJA (ACCIDENT - INJURIES / ALS *)\n" + 
        "Loc: W BALTIMORE PK/SCARLETT RD ,60    (V) AKA:",
        "CALL:ACCINJA (ACCIDENT - INJURIES / ALS *)",
        "ADDR:W BALTIMORE PK & SCARLETT RD");

    doTest("T3",
        "Initial Type: BSICK      Final Type: BSICK   (SICK PERSON - BLS *)\n" + 
        "Loc: 415 MEGAN CT ,62  btwn VICTORIA GARDENS DR & AZALEA LA (V)\n" +
        "AKA",
        "CALL:BSICK   (SICK PERSON - BLS *)",
        "ADDR:415 MEGAN CT",
        "X:VICTORIA GARDENS DR & AZALEA LA (V)");

    doTest("T4",
        "Initial Type: ACVA       Final Type: ACVA    (CVA/STROKE - ALS *)\n" +
        "Loc: 509 HAZEL AV ,03  btwn N WALNUT ST & WILSON RD (V)\n" +
        "AKA:   Munic",
        "CALL:ACVA    (CVA/STROKE - ALS *)",
        "ADDR:509 HAZEL AV",
        "X:N WALNUT ST & WILSON RD (V)",
        "INFO:Munic");

    doTest("T5",
        "(Station 24 EMS Call) Initial Type: BSICK      Final Type: BSICK (SICK PERSON - BLS *)\n" +
        "Loc: 301 VICTORIA GARDENS DR ,62 -- BRANDYWINE ASSISTED LIVNG btwn L",
        "CALL:BSICK (SICK PERSON - BLS *)",
        "ADDR:301 VICTORIA GARDENS DR",
        "X:L");
    
    doTest("T6",
        "Subject:Station24 Fire Call<br>\n" + 
        " Initial Type: ACCUNK     Final Type: ACCUNK  (ACCIDENT - UNKNOWN INJURIES *)  Loc: SB RT 82 SO E SOUTH ST ,0&#13;<br>",
        "CALL:ACCUNK  (ACCIDENT - UNKNOWN INJURIES *)",
        "ADDR:SB RT 82 SO E SOUTH ST");

  }
}
