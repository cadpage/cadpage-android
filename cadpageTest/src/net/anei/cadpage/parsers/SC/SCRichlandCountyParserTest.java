package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCRichlandCountyParserTest extends BaseParserTest {
  
  public SCRichlandCountyParserTest() {
    setParser(new SCRichlandCountyParser(), "RICHLAND COUNTY", "SC");
  }
  
  @Test
  public void testFreeForm() {
    
    doTest("T1",
        "RESD STRUCTURE FIRE (FLAMES SHOWING) - 1 SHAFTESBURY LN / BROWN",
        "CALL:RESD STRUCTURE FIRE (FLAMES SHOWING) -",
        "ADDR:1 SHAFTESBURY LN",
        "INFO:/ BROWN");
    
    doTest("T2",
        "SUSPICIOUS PACKAGE FOUND AT 7201 TWO NOTCH RD AT RCSD PARKING LOT / BROWN",
        "CALL:SUSPICIOUS PACKAGE FOUND AT",
        "ADDR:7201 TWO NOTCH RD",
        "INFO:AT RCSD PARKING LOT / BROWN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Address: 731 Horrell Hill Rd Problem: Seizure",
        "ADDR:731 Horrell Hill Rd",
        "CALL:Seizure");

    doTest("T2",
        "Address: 108 Kildare Dr Problem: Insulin Shock",
        "ADDR:108 Kildare Dr",
        "CALL:Insulin Shock");

    doTest("T3",
        "Address: Padgett Rd / Lower Richland Blvd Problem: Woods Fire",
        "ADDR:Padgett Rd & Lower Richland Blvd",
        "CALL:Woods Fire");

    doTest("T4",
        "Address: Caughman Rd / Teague Rd Problem: MVA",
        "ADDR:Caughman Rd & Teague Rd",
        "CALL:MVA");

    doTest("T5",
        "Address: Garners Ferry Rd / Trotter Rd Problem: MVA",
        "ADDR:Garners Ferry Rd & Trotter Rd",
        "CALL:MVA");

    doTest("T6",
        "Address: 8100 Garners Ferry Rd Problem: MVA",
        "ADDR:8100 Garners Ferry Rd",
        "CALL:MVA");

    doTest("T7",
        "Address: 217 Tilting Rock Dr Problem: Structure Fire - House",
        "ADDR:217 Tilting Rock Dr",
        "CALL:Structure Fire - House");

    doTest("T8",
        "Address: Welborn Rd / Leesburg Rd Problem: Fire Test",
        "ADDR:Welborn Rd & Leesburg Rd",
        "CALL:Fire Test");

    doTest("T9",
        "Address: Fairmont Rd / Leesburg Rd Problem: MVA",
        "ADDR:Fairmont Rd & Leesburg Rd",
        "CALL:MVA");

    doTest("T10",
        "Address: Leesburg Rd / Ulmer Rd Problem: MVA",
        "ADDR:Leesburg Rd & Ulmer Rd",
        "CALL:MVA");

    doTest("T11",
        "Address: 8000 Garners Ferry Rd Problem: Head Injury",
        "ADDR:8000 Garners Ferry Rd",
        "CALL:Head Injury");

    doTest("T12",
        "Address: 145 Ramblewood Dr Problem: Seizure",
        "ADDR:145 Ramblewood Dr",
        "CALL:Seizure");

    doTest("T13",
        "Address: 305 Shagbark Ave Problem: Coronary",
        "ADDR:305 Shagbark Ave",
        "CALL:Coronary");

    doTest("T14",
        "Address: 3644 Leesburg Rd Problem: Spinal Injury",
        "ADDR:3644 Leesburg Rd",
        "CALL:Spinal Injury");

    doTest("T15",
        "Address: 1114 Rabbit Run Problem: False Fire Alarm",
        "ADDR:1114 Rabbit Run",
        "CALL:False Fire Alarm");

    doTest("T16",
        "Address: Ridge Rd / Lower Richland Blvd Problem: Vehicle Fire Trailer/Bus/MHome",
        "ADDR:Ridge Rd & Lower Richland Blvd",
        "CALL:Vehicle Fire Trailer/Bus/MHome");
 
  }
  
  public static void main(String[] args) {
    new SCRichlandCountyParserTest().generateTests("T1");
  }
}