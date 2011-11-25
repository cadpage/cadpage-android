package net.anei.cadpage.parsers.FL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class FLCollierCountyParserTest extends BaseParserTest {
  
  public FLCollierCountyParserTest() {
    setParser(new FLCollierCountyParser(), "COLLIER COUNTY", "FL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FCC111115005334 TYP: MEDICAL CALL BLD: NW S AD: COLLIER BLVD&IMMOKALEE RD MAP: 376 LOC: PUBLIX CMT1: S02 - DIFF BREATHING",
        "ID:FCC111115005334",
        "CALL:MEDICAL CALL",
        "APT:NW S",
        "ADDR:COLLIER BLVD & IMMOKALEE RD",
        "MAP:376",
        "PLACE:PUBLIX",
        "INFO:S02 - DIFF BREATHING");

    doTest("T2",
        "FCC111115005335 TYP: MEDICAL CALL AD: 1234 35TH AVE NE MAP: 333 CMT1: CE: 52 YEAR OLD FEMALE CONSCIOUS BREATHING CALLER",
        "ID:FCC111115005335",
        "CALL:MEDICAL CALL",
        "ADDR:1234 35TH AVE NE",
        "MAP:333",
        "INFO:CE: 52 YEAR OLD FEMALE CONSCIOUS BREATHING CALLER");

    doTest("T3",
        "FCC111115005332 TYP: UNK PROBLEM BLD: COIN AD: PINE RIDGE RD&I 75 MAP: 571 LOC: VINEYARDS AMOCO CMT1: 71U/MALE LAYING UND",
        "ID:FCC111115005332",
        "CALL:UNK PROBLEM",
        "APT:COIN",
        "ADDR:PINE RIDGE RD & I 75",
        "MAP:571",
        "PLACE:VINEYARDS AMOCO",
        "INFO:71U/MALE LAYING UND");

    doTest("T4",
        "FCC111117005608 TYP: TRAUMATIC INJURIES AD: 3300 THOMASSON DR MAP: 944 LOC: AVALON ELEM CMT1: CE: 5 YEAR OLD MALE CONSCIO",
        "ID:FCC111117005608",
        "CALL:TRAUMATIC INJURIES",
        "ADDR:3300 THOMASSON DR",
        "MAP:944",
        "PLACE:AVALON ELEM",
        "INFO:CE: 5 YEAR OLD MALE CONSCIO");

    doTest("T5",
        "FCC111117005599 TYP: MEDICAL CALL APT: 105 AD: 600 MISTY PINES CIR MAP: 583 CMT1: CE: 1 MONTH OLD FEMALE CONSCIOUS BREATH",
        "ID:FCC111117005599",
        "CALL:MEDICAL CALL",
        "APT:105",
        "ADDR:600 MISTY PINES CIR",
        "MAP:583",
        "INFO:CE: 1 MONTH OLD FEMALE CONSCIOUS BREATH");
  }
  
  public static void main(String[] args) {
    new FLCollierCountyParserTest().generateTests("T1");
  }
}
  