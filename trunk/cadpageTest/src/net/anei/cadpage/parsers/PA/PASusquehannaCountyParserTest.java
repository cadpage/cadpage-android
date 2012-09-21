package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PASusquehannaCountyParserTest extends BaseParserTest {
  
  public PASusquehannaCountyParserTest() {
    setParser(new PASusquehannaCountyParser(), "SUSQUEHANNA COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MVA >MOTOR VEHICLE ACCIDENT 228 I81 S GREAT BEND TWP PHAN,ABDUL Map: Grids:0,0 Cad: 2012-0000006018 (HSF)",
        "CALL:MOTOR VEHICLE ACCIDENT",
        "ADDR:228 I81 S",
        "MADDR:228 I 81 S",
        "CITY:GREAT BEND TWP",
        "NAME:PHAN,ABDUL",
        "ID:2012-0000006018",
        "INFO:(HSF)");

    doTest("T2",
        "TREES >TREES DOWN 21907 SR 11 GREAT BEND Map: Grids:, Cad: 2012-0000006063 (HSF)",
        "CALL:TREES DOWN",
        "ADDR:21907 SR 11",
        "MADDR:21907 PA 11",
        "CITY:GREAT BEND",
        "ID:2012-0000006063",
        "INFO:(HSF)");

    doTest("T3",
        "BRUSH >BRUSH FIRE HARMONY RD GREAT BEND GALLELLI,JOHN Map: Grids:, Cad: 2012-0000006113 (HSF)",
        "CALL:BRUSH FIRE",
        "ADDR:HARMONY RD",
        "CITY:GREAT BEND",
        "NAME:GALLELLI,JOHN",
        "ID:2012-0000006113",
        "INFO:(HSF)");

    doTest("T4",
        "WIRES >WIRES DOWN SR 11 GREAT BEND ANTHONY Map: Grids:, Cad: 2012-0000006114 (HSF)",
        "CALL:WIRES DOWN",
        "ADDR:SR 11",
        "MADDR:PA 11",
        "CITY:GREAT BEND",
        "NAME:ANTHONY",
        "ID:2012-0000006114",
        "INFO:(HSF)");

    doTest("T5",
        "17 >FALLS 1004 HARMONY RD GREAT BEND CST - LINK TO LIFE Map: Grids:, Cad: 2012-0000006142 (HSF)",
        "CALL:FALLS",
        "ADDR:1004 HARMONY RD",
        "CITY:GREAT BEND",
        "NAME:CST - LINK TO LIFE",
        "ID:2012-0000006142",
        "INFO:(HSF)");
  }
  
  public static void main(String[] args) {
    new PASusquehannaCountyParserTest().generateTests("T1", "CALL ADDR APT X CITY PLACE NAME PHONE MAP ID INFO");
  }
}
