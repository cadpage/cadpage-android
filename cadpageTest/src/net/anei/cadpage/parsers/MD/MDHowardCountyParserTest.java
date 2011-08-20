package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MDHowardCountyParserTest extends BaseParserTest {
  
  public MDHowardCountyParserTest() {
    setParser(new MDHowardCountyParser(), "HOWARD COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[CAD] RT 32/LINDEN CHURCH RD WS CLK TYPE: RESCUE--UNKNOW @ 23:29:39 BEAT/BOX: 032119",
        "ADDR:RT 32 & LINDEN CHURCH RD WS",
        "CITY:CLARKSVILLE",
        "CALL:RESCUE--UNKNOW",
        "BOX:032119");

    doTest("T2",
        "[CAD] 14470 TRIADELPHIA MILL RD DYTN TYPE: WIRES-WIRES @ 13:52:21 BEAT/BOX: 0540",
        "ADDR:14470 TRIADELPHIA MILL RD",
        "CITY:DAYTON",
        "CALL:WIRES-WIRES",
        "BOX:0540");

    doTest("T3",
        "[CAD] 6005 DAYBREAK CIR CLK: @RIVER HILL VC TYPE: LOCKV-ANIMAL @ 12:13:57 BEAT/BOX: 0501",
        "ADDR:6005 DAYBREAK CIR",
        "CITY:CLARKSVILLE",
        "PLACE:RIVER HILL VC",
        "CALL:LOCKV-ANIMAL",
        "BOX:0501");

    doTest("T4",
        "[CAD] 6348 MORNING TIME LN WCOL TYPE: MEDICAL-BLS-COLD @ 13:59:49 BEAT/BOX: 0561",
        "ADDR:6348 MORNING TIME LN",
        "CITY:COLUMBIA",
        "CALL:MEDICAL-BLS-COLD",
        "BOX:0561");

    doTest("T5",
        "[CAD] RT 32/ROSEMARY LN ECW TYPE: RESCUE--UNKNOW @ 06:03:24 BEAT/BOX: 032145",
        "ADDR:RT 32 & ROSEMARY LN",
        "CITY:ELLICOTT CITY",
        "CALL:RESCUE--UNKNOW",
        "BOX:032145");

    doTest("T6",
        "[CAD] 12700 HALL SHOP RD HIGH: @SAINT MARKS EPISCOPAL CHURCH TYPE: GASLEAK-OUTSIDE/FIRE @ 01:28:32 BEAT/BOX: 0564",
        "ADDR:12700 HALL SHOP RD",
        "CITY:HIGHLAND",
        "PLACE:SAINT MARKS EPISCOPAL CHURCH",
        "CALL:GASLEAK-OUTSIDE/FIRE",
        "BOX:0564");

    doTest("T7",
        "[CAD] 5764 STEVENS FOREST RD ECOL,111: @GRANDE POINT APARTMENTS TYPE: SMOKE-INSIDE/HIGHOCC @ 23:28:39 BEAT/BOX: 0908",
        "ADDR:5764 STEVENS FOREST RD",
        "CITY:COLUMBIA",
        "APT:111",
        "PLACE:GRANDE POINT APARTMENTS",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "BOX:0908");

    doTest("T8",
        "[CAD] 14101 HOWARD RD DYTN: @SMITH RESIDENCE TYPE: MEDICAL-*********** @ 08:30:53 BEAT/BOX: 0545",
        "ADDR:14101 HOWARD RD",
        "CITY:DAYTON",
        "PLACE:SMITH RESIDENCE",
        "CALL:MEDICAL-***********",
        "BOX:0545");

    doTest("T9",
        "(CAD) [CAD] EVENT: F11023456 7110 MINSTREL WAY ECOL: @BRIGHTON GARDENS TYPE: SMOKE-INSIDE/HIGHOCC @ 10:38:22 BEAT/BOX: 1034",
        "ID:F11023456",
        "ADDR:7110 MINSTREL WAY",
        "CITY:COLUMBIA",
        "PLACE:BRIGHTON GARDENS",
        "CALL:SMOKE-INSIDE/HIGHOCC",
        "BOX:1034");

    doTest("T10",
        "(CAD) [CAD] EVENT: F11023457 RT 29 SB/RIVERS EDGE RD SCOL TYPE: RESCUE--UNKNOW @ 10:56:54 BEAT/BOX: 029086",
        "ID:F11023457",
        "ADDR:RT 29 SB & RIVERS EDGE RD",
        "CITY:COLUMBIA",
        "CALL:RESCUE--UNKNOW",
        "BOX:029086");
  }
  
  public static void main(String[] args) {
    new MDHowardCountyParserTest().generateTests("T9");
  }
}