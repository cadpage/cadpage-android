package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYHerkimerCountyParser;

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
    
    doTest("T11",
        "(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:",
        "CALL:EMS>EMS CALL",
        "ADDR:112 N Main St",
        "X:Fairfield St",
        "CITY:Middleville");
    
    doTest("T12",
        "(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:",
        "CALL:EMS>EMS CALL",
        "ADDR:54 Fairfield St",
        "X:Fairfield St",
        "CITY:Middleville");
    
    doTest("T13",
        "(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:",
        "CALL:LIFT>LIFT ASSIST/NON EMER EMS",
        "ADDR:112 N Main St",
        "X:Fairfield St");

    doTest("21",
        "264 CHURCH ST XS: N ANN ST LITTLE FALLS CITY SLABE,CAROL 3158231466 Map: Grids:, Cad: 2010-0000068836",
        "ADDR:264 CHURCH ST",
        "X:N ANN ST",
        "CITY:LITTLE FALLS CITY",
        "ID:2010-0000068836");

    doTest("T22",
        "168 FURNACE ST Apt: 1 Bldg XS: W MAIN ST LITTLE FALLS CITY SCLARZ, RANDY 3155085302 Map: Grids:, Cad: 2010-0000068790I",
        "ADDR:168 FURNACE ST",
        "APT:1 Bldg",
        "X:W MAIN ST",
        "CITY:LITTLE FALLS CITY",
        "ID:2010-0000068790I");
    
  }
}
