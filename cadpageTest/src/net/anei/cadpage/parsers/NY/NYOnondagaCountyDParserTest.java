package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Onondaga County, NY (Alternate)
Contact: Mark Fowler <mark.fowler@gmail.com>
Sender: onondagahillfd@rednmxcad.com

CARD - CHEST PAIN-POSS HEART, lt at 100 SUMMERFIELD VILLAGE LN  c/s:  VELASKO RD AND DEAD END,  B: ALTERRA VILLAS
ALRM - ALARM, Fire at 3380 MILTON AVE  c/s:  SAWYER ST AND N ONONDAGA RD,  B: COPPERTOP TAVERN
ALRM - ALARM, Fire at 100 GOLFVIEW DR  c/s:  KASSON RD AND DEAD END,  B: WESTVALE GOLF COURSE
CARD - CHEST PAIN-POSS HEART, lt at 112 CHICOPEE MEWS  c/s:  WEATHERIDGE DR AND DEAD END,
UNCP - UNCONSCIOUS PERSON, lt at 129 RANSOM MACKENZIE DR E  c/s:  OCC CIR AND RANSOM MACKENZIE 
GILL - GENERAL ILLNESS, lt at 5080 REINMAN RD  c/s:  MCDONALD RD AND DEAD END,  B: NYS COM RESIDENCE
UNCP - UNCONSCIOUS PERSON, lt at 4168 GRIFFIN RD  c/s:  MALONE RD AND MAKYES RD,
CVA - POSSIBLE STROKE, lt at 4849 GLENFIELD DR  c/s:  DEAD END AND ROSEMARY LN,

*/

public class NYOnondagaCountyDParserTest extends BaseParserTest {
  
  public NYOnondagaCountyDParserTest() {
    setParser(new NYOnondagaCountyDParser(), "ONONDAGA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CARD - CHEST PAIN-POSS HEART, lt at 100 SUMMERFIELD VILLAGE LN  c/s:  VELASKO RD AND DEAD END,  B: ALTERRA VILLAS",
        "CALL:CARD - CHEST PAIN-POSS HEART, lt",
        "ADDR:100 SUMMERFIELD VILLAGE LN",
        "X:VELASKO RD AND DEAD END",
        "PLACE:ALTERRA VILLAS");

    doTest("T2",
        "ALRM - ALARM, Fire at 3380 MILTON AVE  c/s:  SAWYER ST AND N ONONDAGA RD,  B: COPPERTOP TAVERN",
        "CALL:ALRM - ALARM, Fire",
        "ADDR:3380 MILTON AVE",
        "X:SAWYER ST AND N ONONDAGA RD",
        "PLACE:COPPERTOP TAVERN");

    doTest("T3",
        "ALRM - ALARM, Fire at 100 GOLFVIEW DR  c/s:  KASSON RD AND DEAD END,  B: WESTVALE GOLF COURSE",
        "CALL:ALRM - ALARM, Fire",
        "ADDR:100 GOLFVIEW DR",  // Not mapping
        "X:KASSON RD AND DEAD END",
        "PLACE:WESTVALE GOLF COURSE");

    doTest("T4",
        "CARD - CHEST PAIN-POSS HEART, lt at 112 CHICOPEE MEWS  c/s:  WEATHERIDGE DR AND DEAD END,",
        "CALL:CARD - CHEST PAIN-POSS HEART, lt",
        "ADDR:112 CHICOPEE MEWS",
        "X:WEATHERIDGE DR AND DEAD END");

    doTest("T5",
        "UNCP - UNCONSCIOUS PERSON, lt at 129 RANSOM MACKENZIE DR E  c/s:  OCC CIR AND RANSOM MACKENZIE ",
        "CALL:UNCP - UNCONSCIOUS PERSON, lt",
        "ADDR:129 RANSOM MACKENZIE DR E",  // Not mapping
        "X:OCC CIR AND RANSOM MACKENZIE");

    doTest("T6",
        "GILL - GENERAL ILLNESS, lt at 5080 REINMAN RD  c/s:  MCDONALD RD AND DEAD END,  B: NYS COM RESIDENCE",
        "CALL:GILL - GENERAL ILLNESS, lt",
        "ADDR:5080 REINMAN RD",
        "X:MCDONALD RD AND DEAD END",
        "PLACE:NYS COM RESIDENCE");

    doTest("T7",
        "UNCP - UNCONSCIOUS PERSON, lt at 4168 GRIFFIN RD  c/s:  MALONE RD AND MAKYES RD,",
        "CALL:UNCP - UNCONSCIOUS PERSON, lt",
        "ADDR:4168 GRIFFIN RD",
        "X:MALONE RD AND MAKYES RD");

    doTest("T8",
        "CVA - POSSIBLE STROKE, lt at 4849 GLENFIELD DR  c/s:  DEAD END AND ROSEMARY LN,",
        "CALL:CVA - POSSIBLE STROKE, lt",
        "ADDR:4849 GLENFIELD DR",
        "X:DEAD END AND ROSEMARY LN");

  }
  
  public static void main(String[] args) {
    new NYOnondagaCountyDParserTest().generateTests("T1");
  }
}
