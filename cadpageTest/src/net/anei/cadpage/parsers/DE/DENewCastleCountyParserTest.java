package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class DENewCastleCountyParserTest extends BaseParserTest {
  
  public DENewCastleCountyParserTest() {
    setParser(new DENewCastleCountyParser(), "NEW CASTLE COUNTY", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(25CAD) [FB] F00 19:58 1 - T:69D5 (L3*MULTI-RESIDENTIAL FIRE) L:755 MONTCLAIR DR #2 ,PF *NAAMANS APTS - X:btwn NAAMANS RD ~ SOCIETY DR DESC: smoke fromneighbors",
        "CALL:69D5 (L3*MULTI-RESIDENTIAL FIRE)",
        "ADDR:755 MONTCLAIR DR",
        "APT:2",
        "PLACE:NAAMANS APTS",
        "X:btwn NAAMANS RD ~ SOCIETY DR",
        "INFO:smoke fromneighbors");

    doTest("T2",
        "(25CAD) [FB] F00 12:11 1 - T:69D7 (L3*CHIMNEY FIRE) L:2007 FERNDALE DR ,X1 *WESTWOOD MANOR - X:btwn FORREST RD ~ VEALE RD DESC: chimney.?!?!",
        "CALL:69D7 (L3*CHIMNEY FIRE)",
        "ADDR:2007 FERNDALE DR",
        "PLACE:WESTWOOD MANOR",
        "X:btwn FORREST RD ~ VEALE RD",
        "INFO:chimney.?!?!");

    doTest("T3",
        "[FB] F00 03:14 1 - T:69D6 (L3*RESIDENTIAL FIRE) L:108 CARLIE RD ,NT *LYNNFIELD - X:btwn HOMEWOOD RD ~ RIDGELAND RD",
        "CALL:69D6 (L3*RESIDENTIAL FIRE)",
        "ADDR:108 CARLIE RD",
        "PLACE:LYNNFIELD",
        "X:btwn HOMEWOOD RD ~ RIDGELAND RD");

    doTest("T4",
        "[FB] F00 08:06 1 - T:55B2 (L1*ELECTRICAL HAZARD-WIRES DWN) L:ELGIN LA~SHIPLEY RD ,QB *OAK LANE MANOR - X: DESC: WIRES DOWN.?!?!",
        "CALL:55B2 (L1*ELECTRICAL HAZARD-WIRES DWN)",
        "ADDR:ELGIN LA & SHIPLEY RD",
        "PLACE:OAK LANE MANOR",
        "INFO:WIRES DOWN.?!?!");

    doTest("T5",
        "(25CAD) [FB] F00 01:38 1 - T:52C3S (L1*COMMERCIAL FIRE ALARM) L:4130 CONCORD PK ,HU06 -- 6TH AVE ELECTRONIC - X:btwn SILVERSIDE RD ~ PASSMORE RD DESC: fire alar",
        "CALL:52C3S (L1*COMMERCIAL FIRE ALARM)",
        "ADDR:4130 CONCORD PK",
        "PLACE:6TH AVE ELECTRONIC",
        "X:btwn SILVERSIDE RD ~ PASSMORE RD",
        "INFO:fire alar");

    doTest("T6",
        "(25CAD) [FB] F00 08:35 1 - T:69D4O (L3*COMMERCIAL STRUC FIRE W~HZ) L:4238 PHILADELPHIA PK ,HU06 -- CLAYMONT STEEL PLA - LI:PLATE MILL - X:btwn ALCOTT AV ~ NAAMANS RD",
        "CALL:69D4O (L3*COMMERCIAL STRUC FIRE W~HZ)",
        "ADDR:4238 PHILADELPHIA PK",
        "PLACE:CLAYMONT STEEL PLA - LI:PLATE MILL",
        "X:btwn ALCOTT AV ~ NAAMANS RD");

    doTest("T7",
        "(25CAD) [FB] F00 11:48 1 - T:52C3G (L1*COMMERCIAL FIRE ALARM) L:1801 AUGUSTINE CUT OFF ,HU06 -- ACCENTURE CONSULTI - X:btwn W EIGHTEENTH ST ~ STONE HILL RD DESC",
        "CALL:52C3G (L1*COMMERCIAL FIRE ALARM)",
        "ADDR:1801 AUGUSTINE CUT OFF",
        "PLACE:ACCENTURE CONSULTI",
        "X:btwn W EIGHTEENTH ST ~ STONE HILL RD");

    doTest("T8",
        "(25CAD) [FB] F00 22:27 1 - T:52C1G (L1*FIRE ALARM~GENERAL) L:4641 WELDIN RD ,XF -- MARY CAMPBELL CNTR *WELDIN WOODS - X:btwn JACOB WELDIN PL ~ WELDIN CI DESC: F",
        "CALL:52C1G (L1*FIRE ALARM~GENERAL)",
        "ADDR:4641 WELDIN RD",
        "PLACE:MARY CAMPBELL CNTR *WELDIN WOODS",
        "X:btwn JACOB WELDIN PL ~ WELDIN CI",
        "INFO:F");
   
  }
  
  public static void main(String[] args) {
    new DENewCastleCountyParserTest().generateTests("T1");
  }
}
    		