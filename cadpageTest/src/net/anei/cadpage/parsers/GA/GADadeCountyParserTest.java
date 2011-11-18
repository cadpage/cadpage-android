package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GADadeCountyParserTest extends BaseParserTest {
  
  public GADadeCountyParserTest() {
    setParser(new GADadeCountyParser(), "DADE COUNTY", "GA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "DADE COUNTY 911:M10 >CHEST PAIN 367 GRAY RD XS: 224 FAWN DAWN DR. NEW SALEM KATY DILLS Map:10-D1,E1 Grids:0,0 Cad: 2011-0000000796",
        "CALL:CHEST PAIN",
        "ADDR:367 GRAY RD",
        "X:224 FAWN DAWN DR",
        "PLACE:NEW SALEM",
        "NAME:KATY DILLS",
        "MAP:10-D1,E1",
        "ID:2011-0000000796");
    
    doTest("T2",
        "DADE COUNTY 911:M26 >SICK PERSON 391 BIBLE GULF RD XS: 869 TATUM GULF RD OFF OLD STATE RD HEAD RIVER KEATON, GLENN Map:12-D2 Grids:0,0 Cad: 2011-0000000651",
        "CALL:SICK PERSON",
        "ADDR:391 BIBLE GULF RD",
        "X:869 TATUM GULF RD OFF OLD STATE RD",
        "PLACE:HEAD RIVER",
        "NAME:KEATON, GLENN",
        "MAP:12-D2",
        "ID:2011-0000000651");

    doTest("T3",
        "DADE COUNTY 911:M5 >FALL - ANY 2862 YANKEE RD XS: HWY 157 S HEAD RIVER KEENER, CAROL Map:11,12 Grids:0,0 Cad: 2011-0000001152",
        "CALL:FALL - ANY",
        "ADDR:2862 YANKEE RD",
        "X:HWY 157 S",
        "PLACE:HEAD RIVER",
        "NAME:KEENER, CAROL",
        "MAP:11,12",
        "ID:2011-0000001152");
        
    doTest("T4",
        "DADE COUNTY 911:50PI >M.V.A. - POSSIBLE INJURIES 13500 HWY 136 E XS: N & S MOORE RD NEW SALEM ROBERTS, CHIP Map:6,15 Grids:0,0 Cad: 2011-0000000992",
        "CALL:MVA - POSSIBLE INJURIES",
        "ADDR:13500 HWY 136 E",
        "X:N & S MOORE RD",
        "PLACE:NEW SALEM",
        "NAME:ROBERTS, CHIP",
        "MAP:6,15",
        "ID:2011-0000000992");
        
    doTest("T5",
        "DADE COUNTY 911:M1 >ABDOMINAL PAIN/PROBLEM 2321 OLD STATE RD XS: 16548 HWY 157 S HEAD RIVER CHAD LANIER Map:11,12 Grids:0,0 Cad: 2011-0000001270",
        "CALL:ABDOMINAL PAIN/PROBLEM",
        "ADDR:2321 OLD STATE RD",
        "X:16548 HWY 157 S",
        "PLACE:HEAD RIVER",
        "NAME:CHAD LANIER",
        "MAP:11,12",
        "ID:2011-0000001270");
        
    doTest("T6",
        "DADE COUNTY 911:78 >ASSISTANCE/ MUTUAL AID 84 RUSHING WATER TRL CHRISTY / WALKER Cad: 2011-0000001334",
        "CALL:ASSISTANCE/MUTUAL AID",
        "ADDR:84 RUSHING WATER TRL",
        "NAME:CHRISTY / WALKER",
        "ID:2011-0000001334");

    doTest("T7",
        "DADE COUNTY 911:78 >ASSISTANCE/ MUTUAL AID 8376 HWY 157 S HEAD RIVER WALKER CO Cad: 2011-0000015531",
        "CALL:ASSISTANCE/MUTUAL AID",
        "ADDR:8376 HWY 157 S",
        "PLACE:HEAD RIVER",
        "NAME:WALKER CO",
        "ID:2011-0000015531");
        
  }
  
  public static void main(String[] args) {
    new GADadeCountyParserTest().generateTests("T7", "CALL ADDR X PLACE NAME ID");
  }
}