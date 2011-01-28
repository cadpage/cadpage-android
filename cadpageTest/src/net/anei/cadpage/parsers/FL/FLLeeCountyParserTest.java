package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.FL.FLLeeCountyParser;

import org.junit.Test;


public class FLLeeCountyParserTest extends BaseParserTest {
  
  public FLLeeCountyParserTest() {
    setParser(new FLLeeCountyParser(), "LEE COUNTY", "FL");
  
  
  doTest("T1",
      "10116004231 TYP: SEIZURES AD: 1051 FIFTH ST CTY: FT MYERS BEACH LOC: LIGHTHOUSE RESORT TIKI BAR CN: VERIZON WIRELESS CMT1: CONVULSIONS /ZURES CMT2: Original Location : LIGHTHOUSE RESORT TIKI BAR TIME: 16:34 FBFBA32 FBFBE31 XST: 1 MATANZAS BRIDGE XST2: 1067 FOURTH ST",
      "SRC:DEPTWK",
      "X:",
      "CALL:",
      "ADDR:",
      "CITY:",
      "NAME:",
      "INFO:");
  
  doTest("T",
      "",
      "SRC:DEPTWK",
      "X:",
      "CALL:",
      "ADDR:",
      "CITY:",
      "NAME:",
      "INFO:");
  
  doTest("T",
      "",
      "SRC:DEPTWK",
      "X:",
      "CALL:",
      "ADDR:",
      "CITY:",
      "NAME:",
      "INFO:");
  }
}
  