package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORPrinevilleParser;

import org.junit.Test;


public class ORPrinevilleParserTest extends BaseParserTest {
  
  public ORPrinevilleParserTest() {
    setParser(new ORPrinevilleParser(), "PRINEVILLE", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[NEW INCIDENT]  INCIDENT NEW\n3/9/2011 1003\nEVENT # 1103090013 PFD\nTEST-FIRE - TEST INCIDENT\nPRIORITY 2 \nLOCATION 387 NE 3RD ST\nCITY PRINEVILLE\nAPT \nPREMISE",
        "ID:1103090013 PFD",
        "CALL:TEST-FIRE - TEST INCIDENT",
        "ADDR:387 NE 3RD ST",
        "CITY:PRINEVILLE");

    doTest("T2",
        "[UNIT DISPATCH]  UNIT DISPATCH\n3/9/2011 1203\nUNITS 1291 \nEVENT # 1103090021 PFD\nFSMK - SMOKE UNKNOWN FIRE S...\nPRIORITY 1 \nLOCATION 1231 SE 5TH ST\nCITY PRI",
        "UNIT:1291",
        "ID:1103090021 PFD",
        "CALL:FSMK - SMOKE UNKNOWN FIRE S...",
        "ADDR:1231 SE 5TH ST",
        "CITY:PRI");

    doTest("T3",
        "[NEW INCIDENT]  INCIDENT NEW\n3/9/2011 1203\nEVENT # 1103090021 PFD\nFSMK - SMOKE UNKNOWN FIRE S...\nPRIORITY 1 \nLOCATION 1231 SE 5TH ST\nCITY PRINEVILLE\nAPT \nP",
        "ID:1103090021 PFD",
        "CALL:FSMK - SMOKE UNKNOWN FIRE S...",
        "ADDR:1231 SE 5TH ST",
        "CITY:PRINEVILLE");

    doTest("T4",
        "(NEW INCIDENT) INCIDENT NEW\n3/9/2011 1203\nEVENT # 1103090021 PFD\nFSMK - SMOKE UNKNOWN FIRE S...\nPRIORITY 1 \nLOCATION 1231 SE 5TH ST\nCITY PRINEVILLE\nAPT \nP",
        "ID:1103090021 PFD",
        "CALL:FSMK - SMOKE UNKNOWN FIRE S...",
        "ADDR:1231 SE 5TH ST",
        "CITY:PRINEVILLE");

    doTest("T5",
        "(NEW INCIDENT) INCIDENT NEW\n3/9/2011 1203\nEVENT # 1103090021 PFD\nFSMK - SMOKE UNKNOWN FIRE S...\nPRIORITY 1 \nLOCATION 1231 SE 5TH ST\nCITY PRINEVILLE\nAPT \nP",
        "ID:1103090021 PFD",
        "CALL:FSMK - SMOKE UNKNOWN FIRE S...",
        "ADDR:1231 SE 5TH ST",
        "CITY:PRINEVILLE");
  }
  
  public static void main(String[] args) {
    new ORPrinevilleParserTest().generateTests("T1");
  }
}