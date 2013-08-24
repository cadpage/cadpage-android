package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYHerkimerCountyParser;

import org.junit.Test;

/* 
Sample Herkimer Pages
Contact: Robert Tucker <mobilewlightn@gmail.com>
Sender: HC911@herkimercounty.org <From%3AHC911@herkimercounty.org>
(EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
(MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
(EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093
(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:,Cad: 2010-0000058750
(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399
(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384

Contact: Chris Conover <conovercj@ntcnet.com>
Sender: HC911@herkimercounty.org
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:

*/

public class NYHerkimerCountyParserTest extends BaseParserTest {
  
  public NYHerkimerCountyParserTest() {
    setParser(new NYHerkimerCountyParser(), "HERKIMER COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093",
        "CODE:EMS",
        "CALL:EMS CALL",
        "ADDR:3141 MECHANIC ST",
        "X:MAIN ST",
        "CITY:NEWPORT",
        "NAME:JOHN",
        "PHONE:3157179999",
        "ID:2010-0000058093");

    doTest("T2",
        "(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:, Cad: 2010-0000058750",
        "CODE:EMS",
        "CALL:EMS CALL",
        "ADDR:3746 BLACK CREEK RD",
        "APT:C Bldg",
        "X:TAYLOR BROOK RD",
        "CITY:RUSSIA",
        "NAME:SMITH, E",
        "PHONE:3158265805",
        "ID:2010-0000058750");
    
    doTest("T3",
        "(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399",
        "CODE:FIREST",
        "CALL:STRUCTURE FIRE",
        "ADDR:1316 HARD SCRABBLE RD",
        "X:BEGIN ESN 029",
        "CITY:FAIRFIELD",
        "NAME:JONES, CORA", 
        "PHONE:3158913818",
        "ID:2010-0000060399");
    
    doTest("T4",
        "(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384",
        "CODE:LIFT", 
        "CALL:LIFT ASSIST/NON EMER EMS",
        "ADDR:3746 BLACK CREEK RD",
        "APT:LOTC Bldg",
        "X:TAYLOR BROOK RD",
        "CITY:RUSSIA",
        "NAME:JOHN SMITH", 
        "PHONE:3158265805",
        "ID:2010-0000064384");
    
    doTest("T11",
        "(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:",
        "CODE:EMS",
        "CALL:EMS CALL",
        "ADDR:112 N Main St",
        "X:Fairfield St",
        "CITY:Middleville",
        "NAME:Smith, John", 
        "PHONE:5419991234");
    
    doTest("T12",
        "(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:",
        "CODE:EMS",
        "CALL:EMS CALL",
        "ADDR:54 Fairfield St",
        "X:Fairfield St",
        "CITY:Middleville",
        "NAME:Smith, John", 
        "PHONE:5419991234");
    
    doTest("T13",
        "(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:",
        "CODE:LIFT", 
        "CALL:LIFT ASSIST/NON EMER EMS",
        "ADDR:112 N Main St",
        "X:Fairfield St",
        "NAME:Smith, John",
        "PHONE:5419991234");
    
  }
  
  public static void main(String[] args) {
    new NYHerkimerCountyParserTest().generateTests("T1");
  }
}
