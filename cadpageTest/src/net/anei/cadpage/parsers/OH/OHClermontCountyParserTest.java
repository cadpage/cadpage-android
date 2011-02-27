package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHClermontCountyParserTest extends BaseParserTest {
  
  public OHClermontCountyParserTest() {
    setParser(new OHClermontCountyParser(), "CLERMONT COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FSTRUC>STRUCTURE FIRE 1890 SR 232 XS: LAUREL POINT ISABEL RD LAUREL BUTLER, SHAWN Map: Grids:, Cad: 2011-0000014744",
        "CALL:STRUCTURE FIRE",
        "ADDR:1890 SR 232",
        "X:LAUREL POINT ISABEL RD",
        "CITY:LAUREL",
        "NAME:BUTLER, SHAWN",
        "ID:2011-0000014744");

    doTest("T2",
        "MED >MED GENERIC DO NOT DELETE 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP BETTLES,LINDA Map: Grids:, Cad: 2011-0000015125",
        "CALL:MED GENERIC DO NOT DELETE",
        "ADDR:2458 SR 756",
        "X:SR 743",
        
        "CITY:WASHINGTON TOWNSHIP",
        "NAME:BETTLES,LINDA",
        "ID:2011-0000015125");

    doTest("T3",
        "FDUMP >DUMPSTER FIRE 2601 WILDWOOD LN XS: SR 222 TATE TOWNSHIP WIRELESS-VERIZON(XYP) Map: Grids:, Cad: 2011-0000015892",
        "CALL:DUMPSTER FIRE",
        "ADDR:2601 WILDWOOD LN",
        "X:SR 222",
        "CITY:TATE TOWNSHIP",
        "NAME:WIRELESS-VERIZON(XYP)",
        "ID:2011-0000015892");

    doTest("T4",
        "06D02 >BREATHING PROBLEMS 2458 SR 756 XS: SR 743 WASHINGTON TOWNSHIP LESTER,CURTIS Map: Grids:, Cad: 2011-0000016117",
        "CALL:BREATHING PROBLEMS",
        "ADDR:2458 SR 756",
        "X:SR 743",
        "CITY:WASHINGTON TOWNSHIP",
        "NAME:LESTER,CURTIS",
        "ID:2011-0000016117");

    doTest("T5",
        "29B01 >TRAFF OR TRANSPT ACC/MVA W/INJ BETHEL HYGIENE RD&amp;SR 133 XS: SR 133 TATE TOWNSHIP Cad: 2011-0000016983",
        "CALL:TRAFF OR TRANSPT ACC/MVA W/INJ BETHEL",
        "ADDR:HYGIENE RD & SR 133",
        "X:SR 133",
        "CITY:TATE TOWNSHIP",
        "ID:2011-0000016983");
      
  }
  
  public static void main(String[] args) {
    new OHClermontCountyParserTest().generateTests("T5", "CALL ADDR X CITY NAME ID");
  }
}