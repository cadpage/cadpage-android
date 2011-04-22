package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MISaginawCountyParserTest extends BaseParserTest {
  
  public MISaginawCountyParserTest() {
	  setParser(new MISaginawCountyParser(), "SAGINAW COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TRITWP *: FIRE ALARM *: 5100 S GRAHAM RD CTY: 23 *: *WILLIAMS RES - GENERAL FIRE",
        "CALL:FIRE ALARM",
        "ADDR:5100 S GRAHAM RD",
        "MAP:23",
        "INFO:*WILLIAMS RES - GENERAL FIRE");

    doTest("T2",
        "TRITWP *: FIRE ALARM *: 5401 S GRAHAM RD CTY: 23 *: *APOTHECARY PRODUCTS/SMK DET",
        "CALL:FIRE ALARM",
        "ADDR:5401 S GRAHAM RD",
        "MAP:23",
        "INFO:*APOTHECARY PRODUCTS/SMK DET");

    doTest("T3",
        "TRITWP *: PI PIN-IN *: S FORDNEY RD&NELSON RD CTY: 12 *: *OCCD VEH ROLLED OVER IN DITCH",
        "CALL:PI PIN-IN",
        "ADDR:S FORDNEY RD & NELSON RD",
        "MAP:12",
        "INFO:*OCCD VEH ROLLED OVER IN DITCH");

    doTest("T4",
        "TRITWP *: STAND BY *: BENTLEY ST&FIRWOOD ST CTY: 46 *: STANDBY REF POSS FIRE IN CHESA",
        "CALL:STAND BY",
        "ADDR:BENTLEY ST & FIRWOOD ST",
        "MAP:46",
        "INFO:STANDBY REF POSS FIRE IN CHESA");

    doTest("T5",
        "TRITWP *: MUTUAL AID *: 2385 S FORDNEY RD CTY: 12 *: NEED LZ SET UP",
        "CALL:MUTUAL AID",
        "ADDR:2385 S FORDNEY RD",
        "MAP:12",
        "INFO:NEED LZ SET UP");

    doTest("T6",
        "TRITWP *: WIRES UP/ARCING *: 1125 W BELLE CTY: 21 *: *TREE ON WIRE SPARKING",
        "CALL:WIRES UP/ARCING",
        "ADDR:1125 W BELLE",
        "MAP:21",
        "INFO:*TREE ON WIRE SPARKING");

    doTest("T7",
        "TRITWP  *: FIRE OUTSIDE *: PARKWAY&N SAGINAW CTY: 39 *: *BARREL ON FIRE AT PARK",
        "CALL:FIRE OUTSIDE",
        "ADDR:PARKWAY & N SAGINAW",
        "MAP:39",
        "INFO:*BARREL ON FIRE AT PARK");
  }
  
  public static void main(String[] args) {
    new MISaginawCountyParserTest().generateTests("T1");
  }
}
