package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAWashingtonCountyParserTest extends BaseParserTest {
  
  public PAWashingtonCountyParserTest() {
    setParser(new PAWashingtonCountyParser(), "WASHINGTON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Location: 116 GRANT ST MCDO Xstreet: NORTH ST STATION ST TYPE: STRUCTURE FIRE TIME: 23:42:41 Comments: IN THE BACK POSS 112 OR 114",
        "ADDR:116 GRANT ST",
        "CITY:MCDONALD",
        "X:NORTH ST & STATION ST",
        "CALL:STRUCTURE FIRE");

    doTest("T2",
        "Location: 50 STONECREST LN CECI Xstreet: MCCONNELL RD DEAD END TYPE: FIRE TIME: 23:40:09 Comments:",
        "ADDR:50 STONECREST LN",
        "CITY:CECIL TWP",
        "X:MCCONNELL RD DEAD END",
        "CALL:FIRE");

    doTest("T3",
        "Location: 1647 MILLERS RUN RD MTPL: @KEEPSAKE ARABIANS Xstreet: PLEASANT RD FORT CHERRY RD TYPE: FIRE ALARM TIME: 22:31:54 Comments:",
        "ADDR:1647 MILLERS RUN RD",
        "CITY:MT PLEASANT TWP",
        "PLACE:KEEPSAKE ARABIANS",
        "X:PLEASANT RD & FORT CHERRY RD",
        "CALL:FIRE ALARM");

    doTest("T4",
        "Location: 22 2ND ST CECI Xstreet: SCHOOL ST BOYCE ST TYPE: STRUCTURE FIRE TIME: 22:40:10 Comments:",
        "ADDR:22 2ND ST",
        "CITY:CECIL TWP",
        "X:SCHOOL ST & BOYCE ST",
        "CALL:STRUCTURE FIRE");

    doTest("T5",
        "Location: 345 SOUTHPOINTE BLVD CECI: @LOCAL 23 UFCW Xstreet: SOUTHPOINTE BLVD NB SOUTHPOINTE BLVD NB TYPE: FIRE ALARM TIME: 11:39:27 Comments:",
        "ADDR:345 SOUTHPOINTE BLVD",
        "CITY:CECIL TWP",
        "PLACE:LOCAL 23 UFCW",
        "X:SOUTHPOINTE BLVD NB & SOUTHPOINTE BLVD NB",
        "CALL:FIRE ALARM");

    doTest("T6",
        "Xstreet: REISSING RD SR 50 TYPE: GRASS OR FIELD FIRE TIME: 15:07:34 Comments: ON REISSING NEAR SR 50",
        "ADDR:REISSING RD & SR 50",
        "CALL:GRASS OR FIELD FIRE");

    doTest("T7",
        "Xstreet: REISSING RD TAYLOR DR TYPE: VEHICLE ACCIDENT WITH UNKNOWN INJURIES TIME: 05:36:10 Comments:",
        "ADDR:REISSING RD & TAYLOR DR",
        "CALL:VEHICLE ACCIDENT WITH UNKNOWN INJURIES");

    doTest("T8",
        "Xstreet: SR 980 HIGHLAND DR TYPE: VEHICLE ACCIDENT WITH INJURIES TIME: 14:17:43 Comments: JUST PASSED HIGHLAND HEADED TOWARD CECIL",
        "ADDR:SR 980 & HIGHLAND DR",
        "CALL:VEHICLE ACCIDENT WITH INJURIES");
   
  }
  
  public static void main(String[] args) {
    new PAWashingtonCountyParserTest().generateTests("T1");
  }
}
