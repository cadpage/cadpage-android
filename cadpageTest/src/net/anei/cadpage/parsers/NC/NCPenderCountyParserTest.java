package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Pender County, NC
Contact: Tripp Lanier <triper99@gmail.com>
Sender: 911-@pendersheriff.com

911-:=12-010417* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-012441* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * BRUSH/FOREST FIRE (RP 1-4)* * * FD13* * * * *
911-:=12-012596* HOLLINGSWORTH DR // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-013390* 1520 OLD MAPLE HILL RD* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009752* 5471 NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *
911-:=12-009855* 14976 NC HWY 53 EAST* * * * * * * * * ASSIST EMS* * * FD13,FD15* * * * *

Contact: Trey <kidt71@aol.com>
Sender: GCM
911-:=12-047492* 245 N ST JOHNS CHURCH RD* * * * * * * * * FIRE/SMOKE ALARM* * * FD16,FD14,FD12* * * * *

*/

public class NCPenderCountyParserTest extends BaseParserTest {
  
  public NCPenderCountyParserTest() {
    setParser(new NCPenderCountyParser(), "PENDER COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "911-:=12-010417* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *",
        "ID:12-010417",
        "ADDR:OLD MAPLE HILL RD N & NC HWY 50",
        "MADDR:OLD MAPLE HILL RD N & STATE 50",
        "CALL:29-TRAFFIC/TRANSPORTATION ACCIDENTS",
        "UNIT:FD13");

    doTest("T2",
        "911-:=12-012441* OLD MAPLE HILL RD N // NC HWY 50* * * * * * * * * BRUSH/FOREST FIRE (RP 1-4)* * * FD13* * * * *",
        "ID:12-012441",
        "ADDR:OLD MAPLE HILL RD N & NC HWY 50",
        "MADDR:OLD MAPLE HILL RD N & STATE 50",
        "CALL:BRUSH/FOREST FIRE (RP 1-4)",
        "UNIT:FD13");

    doTest("T3",
        "911-:=12-012596* HOLLINGSWORTH DR // NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *",
        "ID:12-012596",
        "ADDR:HOLLINGSWORTH DR & NC HWY 50",
        "MADDR:HOLLINGSWORTH DR & STATE 50",
        "CALL:29-TRAFFIC/TRANSPORTATION ACCIDENTS",
        "UNIT:FD13");

    doTest("T4",
        "911-:=12-013390* 1520 OLD MAPLE HILL RD* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *",
        "ID:12-013390",
        "ADDR:1520 OLD MAPLE HILL RD",
        "CALL:29-TRAFFIC/TRANSPORTATION ACCIDENTS",
        "UNIT:FD13");

    doTest("T5",
        "911-:=12-009752* 5471 NC HWY 50* * * * * * * * * 29-TRAFFIC/TRANSPORTATION ACCIDENTS* * * FD13* * * * *",
        "ID:12-009752",
        "ADDR:5471 NC HWY 50",
        "MADDR:5471 STATE 50",
        "CALL:29-TRAFFIC/TRANSPORTATION ACCIDENTS",
        "UNIT:FD13");

    doTest("T6",
        "911-:=12-009855* 14976 NC HWY 53 EAST* * * * * * * * * ASSIST EMS* * * FD13,FD15* * * * *",
        "ID:12-009855",
        "ADDR:14976 NC HWY 53",
        "MADDR:14976 STATE 53",
        "PLACE:EAST",
        "CALL:ASSIST EMS",
        "UNIT:FD13,FD15");
  }
  
  @Test
  public void testTrey() {

    doTest("T1",
        "911-:=12-047492* 245 N ST JOHNS CHURCH RD* * * * * * * * * FIRE/SMOKE ALARM* * * FD16,FD14,FD12* * * * *",
        "ID:12-047492",
        "ADDR:245 N ST JOHNS CHURCH RD",
        "CALL:FIRE/SMOKE ALARM",
        "UNIT:FD16,FD14,FD12");

  }

  public static void main(String[] args) {
    new NCPenderCountyParserTest().generateTests("T1");
  }
}
