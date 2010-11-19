package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYHerkimerCountyParserTest extends BaseParserTest {
  
  public NYHerkimerCountyParserTest() {
    setParser(new NYHerkimerCountyParser(), "HERKIMER COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093",
        "CALL:EMS>EMS CALL",
        "ADDR:3141 MECHANIC ST",
        "X:MAIN ST",
        "CITY:NEWPORT",
        "ID:2010-0000058093");

    doTest("T2",
        "(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:, Cad: 2010-0000058750",
        "CALL:EMS>EMS CALL",
        "ADDR:3746 BLACK CREEK RD",
        "APT:C Bldg",
        "X:TAYLOR BROOK RD",
        "CITY:RUSSIA",
        "ID:2010-0000058750");
    
    doTest("T3",
        "(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399",
        "CALL:FIREST>STRUCTURE FIRE",
        "ADDR:1316 HARD SCRABBLE RD",
        "X:BEGIN ESN 029",
        "CITY:FAIRFIELD",
        "ID:2010-0000060399");
    
    doTest("T4",
      "(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384",
      "CALL:LIFT>LIFT ASSIST/NON EMER EMS",
      "ADDR:3746 BLACK CREEK RD",
      "APT:LOTC Bldg",
      "X:TAYLOR BROOK RD",
      "CITY:RUSSIA",
      "ID:2010-0000064384");

  }
}
