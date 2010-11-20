package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYOneidaCountyParserTest extends BaseParserTest {
  
  public NYOneidaCountyParserTest() {
    setParser(new NYOneidaCountyParser(), "ONEIDA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "o;?WHIF:2010:0648\nDispatched\nEMS/BREATHING PROBLEMS\n111 HARDCASTLE AVE, WHITESBORO VILLAGE (MERITON DR/PERIMETER RD)",
        "ID:2010:0648",
        "CALL:EMS/BREATHING PROBLEMS",
        "ADDR:111 HARDCASTLE AVE",
        "CITY:WHITESBORO VILLAGE",
        "X:MERITON DR/PERIMETER RD");

    doTest("T2",
        "o;?WHIF:2010:0641\nDispatched\nEMS/DIABETIC PROBLEM\n31 MOHAWK ST, WHITESBORO VILLAGE (/SAUQUOIT STNear:AMERICAN LEGION POST",
        "ID:2010:0641",
        "CALL:EMS/DIABETIC PROBLEM",
        "ADDR:31 MOHAWK ST",
        "CITY:WHITESBORO VILLAGE",
        "X:/SAUQUOIT STNear:AMERICAN LEGION POST");
    
    doTest("T3",
        "o;?WHIF:2010:0636\nDispatched\nINVESTIGATE\n124 HARTS HILL TERR, WHITESTOWN (GILBERT RD/Near:HARTS HILL INN)",
        "ID:2010:0636",
        "CALL:INVESTIGATE",
        "ADDR:124 HARTS HILL TERR",
        "CITY:WHITESTOWN",
        "X:GILBERT RD/Near:HARTS HILL INN");
    
    doTest("T4",
        "o;?WHIF:2010:0644\nDispatched\nMVA-PI\nHUGHES ST, WHITESBORO VILLAGE/ WEST ST, WHITESBORO VILLAGE",
        "ID:2010:0644",
        "CALL:MVA-PI",
        "ADDR:HUGHES ST",
        "CITY:WHITESBORO VILLAGE",
        "X:WEST ST, WHITESBORO VILLAGE");
  }
}
