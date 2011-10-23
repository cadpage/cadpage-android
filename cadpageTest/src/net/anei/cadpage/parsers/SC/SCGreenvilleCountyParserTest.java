package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCGreenvilleCountyParserTest extends BaseParserTest {
  
  public SCGreenvilleCountyParserTest() {
    setParser(new SCGreenvilleCountyParser(), "GREENVILLE COUNTY", "SC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:ACKNOWLEDGE CALL;105 CRIMSON GLORY WAY; TRAV;(S) (N)19V",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:105 CRIMSON GLORY WAY",
        "CITY:TRAVELERS REST",
        "MAP:19V");

    doTest("T2",
        "CAD:FALLS;105 CRIMSON GLORY WAY;TRAV;MIRANDY CT;TINEKE WAY;(S) (N)19V;NG1",
        "CALL:FALLS",
        "ADDR:105 CRIMSON GLORY WAY",
        "CITY:TRAVELERS REST",
        "X:MIRANDY CT & TINEKE WAY",
        "MAP:19V",
        "INFO:NG1");

    doTest("T3",
        "CAD:FIRE ALARM;8 ANDERS RD;GRVL;OLD MCELHANEY RD;(S) (N)24F;Kristy- AOA: sprinkler trip [04/26/11 12:28:12 THILL] ;NG1",
        "CALL:FIRE ALARM",
        "ADDR:8 ANDERS RD",
        "CITY:GREENVILLE",
        "X:OLD MCELHANEY RD",
        "MAP:24F",
        "INFO:Kristy- AOA: sprinkler trip / NG1");

    doTest("T4",
        "CAD:ACKNOWLEDGE CALL;8 ANDERS RD; GRVL;(S) (N)24F",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:8 ANDERS RD",
        "CITY:GREENVILLE",
        "MAP:24F");

    doTest("T5",
        "CAD:FIRE ALARM;32 HUNT ST;TRAV;ELIZABETH LN;ELIZABETH LN;(S) (N)17O;NAME: CHARLA SMITH, [04/26/11 13:34:03 THILL] SMOKE ALARM GOING OFF [04/26/11 13:33:49",
        "CALL:FIRE ALARM",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "X:ELIZABETH LN & ELIZABETH LN",
        "MAP:17O",
        "NAME:CHARLA SMITH,",
        "INFO:SMOKE ALARM GOING OFF");

    doTest("T6",
        "CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "MAP:17O");

    doTest("T7",
        "CAD:ACKNOWLEDGE CALL;32 HUNT ST; TRAV;(S) (N)17O",
        "CALL:ACKNOWLEDGE CALL",
        "ADDR:32 HUNT ST",
        "CITY:TRAVELERS REST",
        "MAP:17O");

    doTest("T8",
        "CAD:FALLS;124 JAMISON RD;TRAV;FARMINGTON TRL;WEBB CREEK CT;(S) (N)18F;NG1",
        "CALL:FALLS",
        "ADDR:124 JAMISON RD",
        "CITY:TRAVELERS REST",
        "X:FARMINGTON TRL & WEBB CREEK CT",
        "MAP:18F",
        "INFO:NG1");

    doTest("T9",
        "CAD:DIABETIC PROBLEM;518 GOFORTH RD;LAND;BUTTER ST;BUTTER ST;(S) (N)4H;GM1",
        "CALL:DIABETIC PROBLEM",
        "ADDR:518 GOFORTH RD",
        "CITY:LANDRUM",
        "X:BUTTER ST & BUTTER ST",
        "MAP:4H",
        "INFO:GM1");
   
  }
  
  public static void main(String[] args) {
    new SCGreenvilleCountyParserTest().generateTests("T1");
  }
}