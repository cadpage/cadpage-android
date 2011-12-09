package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXNuecesCountyParserTest extends BaseParserTest {
  
  public TXNuecesCountyParserTest() {
    setParser(new TXNuecesCountyParser(), "NUECES COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:CAD Notify\nTRAUMA - INJURY ALRM: 0 PRI: 1 ESZ: 67 / 11308 GUESS DR CC NUECS EV: 1110029194\n",
        "CALL:TRAUMA - INJURY",
        "PRI:1",
        "UNIT:67",
        "ADDR:11308 GUESS DR",
        "CITY:CORPUS CHRISTI",
        "ID:1110029194");

    doTest("T2",
        "Subject:CAD Notify\nINV-FIRE - SMOKE ALRM: 0 PRI: 2 ESZ: 107 / 3695 CR 61 NUECS EV: 1110029353",
        "CALL:INV-FIRE - SMOKE",
        "PRI:2",
        "UNIT:107",
        "ADDR:3695 CR 61",
        "MADDR:3695 COUNTY ROAD 61",
        "ID:1110029353");

    doTest("T3",
        "Subject:CAD Notify\nTA - EMS ALRM: 0 PRI: 1 ESZ: 107 / CR 48/HWY 77 FWY SB NUECS EV: 1110031040\n\n",
        "CALL:TA - EMS",
        "PRI:1",
        "UNIT:107",
        "ADDR:CR 48 & HWY 77 FWY SB",
        "MADDR:COUNTY ROAD 48 & HWY 77 FWY",
        "ID:1110031040");

    doTest("T4",
        "Subject:CAD Notify\nMEDICAL - SICK ALRM: 0 PRI: 1 ESZ: 6 / 4909 FM 2826 NUECS: @LABROCK CORRECTIONS SERVICES EV: 1110031803\n\n",
        "CALL:MEDICAL - SICK",
        "PRI:1",
        "UNIT:6",
        "ADDR:4909 FM 2826",
        "PLACE:LABROCK CORRECTIONS SERVICES",
        "ID:1110031803");

    doTest("T5",
        "Subject:CAD Notify\nFIRE-OTHER - VEH-OUTSIDE ALRM: 0 PRI: 1 ESZ: 104 / 1332 FM 665 NUECS: @MEMORY GARDENS CEMETERY - FM 665 EV: 111003414",
        "CALL:FIRE-OTHER - VEH-OUTSIDE",
        "PRI:1",
        "UNIT:104",
        "ADDR:1332 FM 665",
        "PLACE:MEMORY GARDENS CEMETERY - FM 665",
        "ID:111003414");

    doTest("T6",
        "Subject:CAD Notify\nTRAUMA - INJURY ALRM: 0 PRI: 1 ESZ: 67 / 4729 CALALLEN DR CC NUECS EV: 1110034169\n\n",
        "CALL:TRAUMA - INJURY",
        "PRI:1",
        "UNIT:67",
        "ADDR:4729 CALALLEN DR",
        "CITY:CORPUS CHRISTI",
        "ID:1110034169");

    doTest("T7",
        "Subject:CAD Notify\nTA - RESCUE ALRM: 0 PRI: 1 ESZ: 2 / FM 665/FM 70 NUECS EV: 1110034392\n\n",
        "CALL:TA - RESCUE",
        "PRI:1",
        "UNIT:2",
        "ADDR:FM 665 & FM 70",
        "ID:1110034392");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:CAD Notify\nNCFIRE: 1111017168 MEDICAL-DIABETIC ALRM: 0 PRI: 1 ESZ: 107 / 3906 REAGAN LN NUECS\n",
        "ID:1111017168",
        "CALL:MEDICAL-DIABETIC",
        "PRI:1",
        "UNIT:107",
        "ADDR:3906 REAGAN LN");

  }
  
  public static void main(String[] args) {
    new TXNuecesCountyParserTest().generateTests("T1");
  }
}
