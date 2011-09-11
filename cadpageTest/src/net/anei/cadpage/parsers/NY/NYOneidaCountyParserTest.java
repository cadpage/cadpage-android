package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYOneidaCountyParser;

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
    
    doTest("T5",
        "o;?WHIF:2010:0677\nDispatched\nEMS/PSYCHIATRIC/SUICIDE ATTEMPT\n19 ELLMORE DR, WHITESBORO VILLAGE (SAUQUOIT ST/WIND PL)",
        "ID:2010:0677",
        "CALL:EMS/PSYCHIATRIC/SUICIDE ATTEMPT",
        "ADDR:19 ELLMORE DR",
        "CITY:WHITESBORO VILLAGE",
        "X:SAUQUOIT ST/WIND PL");
    
    doTest("T6",
        "i>¿WEVF:2010:0170\nDispatched\nEMS/STROKE/CVA\n9132 MAIN ST, WESTERN (GIFFORD HILL RD/GEORGE STNear:WOODS VALLEY",
        "ID:2010:0170",
        "CALL:EMS/STROKE/CVA",
        "ADDR:9132 MAIN ST",
        "CITY:WESTERN",
        "X:GIFFORD HILL RD/GEORGE STNear:WOODS VALLEY");
    
    doTest("T7",
        "o;?WHIF:2010:0704>Dispatched>EMS/ABDOMINAL PAIN>20 MOHAWK ST, WHITESBORO VILLAGE (SAUQUOIT ST/FERNBANK CIR; Near:AMERICAN LEGION POST 1113)",
        "ID:2010:0704",
        "CALL:EMS/ABDOMINAL PAIN",
        "ADDR:20 MOHAWK ST",
        "CITY:WHITESBORO VILLAGE",
        "X:SAUQUOIT ST/FERNBANK CIR; Near:AMERICAN LEGION POST 1113");

    doTest("T8",
        "?LECF:2011:0085>Dispatched\n>17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)\n>5368 SLONE RD, LEE (LEE CENTER TABERG RD/SKINNER RD;)",
        "ID:2011:0085",
        "CALL:17A03 - PUBLIC ASSIST (NO INJURIES AND NO PRIORITY SYMPTOMS)",
        "ADDR:5368 SLONE RD",
        "CITY:LEE",
        "X:LEE CENTER TABERG RD/SKINNER RD;");

    doTest("T9",
        "Body:?DEEF:2011:0075>Dispatched\n>WIRES DOWN/BURN\n>6352 WALKER RD, DEERFIELD (CRUIKSHANK RD/MILLER RD;)",
        "ID:2011:0075",
        "CALL:WIRES DOWN/BURN",
        "ADDR:6352 WALKER RD",
        "CITY:DEERFIELD",
        "X:CRUIKSHANK RD/MILLER RD;");

    doTest("T10",
        "?LADF:2011:0165>Dispatched\n>FIRE STRUCTURE\n>8428 DAWN DR, ROME (EVENING RD/;)",
        "ID:2011:0165",
        "CALL:FIRE STRUCTURE",
        "ADDR:8428 DAWN DR",
        "CITY:ROME",
        "X:EVENING RD/;");

    doTest("T11",
        "?VEOF:2011:0407>Dispatched\n>ALARM FIRE\n>5218 PATRICK RD (COUNTY ROUTE 48A), VERONA (VERONA, ROUTE 365/SNYDER RD; Near:TURNING STONE CASINO)",
        "ID:2011:0407",
        "CALL:ALARM FIRE",
        "ADDR:5218 PATRICK RD",
        "CITY:VERONA",
        "X:VERONA, ROUTE 365/SNYDER RD; Near:TURNING STONE CASINO");
 }
  
  public static void main(String[] args) {
    new NYOneidaCountyParserTest().generateTests("T12", "ID CALL ADDR CITY X");
  }
}
