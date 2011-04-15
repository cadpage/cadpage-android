package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyFiretrackerParserTest extends BaseParserTest {
  
  public NYNassauCountyFiretrackerParserTest() {
    setParser(new NYNassauCountyFiretrackerParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(FirePage) ** FFD FIRE CALL ** GENERAL PROB WITH GAS STOVE-POSS LEAK 170 JAY ST\nC/S: DEAN (E) ST / MILTON (E) ST TOA: 17:02 [FireTracker]",
        "CALL:GENERAL PROB WITH GAS STOVE-POSS LEAK",
        "ADDR:170 JAY ST",
        "X:DEAN (E) ST / MILTON (E) ST");

    doTest("T2",
        "(FirePage) ** FFD FIRE CALL ** DISTRIC DIST CALL FOR SMOKE IN THE AREA CHURCH ST\nC/S: ARCHER ST TOA: 19:12 [FireTracker]",
        "CALL:DISTRIC DIST CALL FOR SMOKE IN THE AREA",
        "ADDR:CHURCH ST",
        "X:ARCHER ST");

    doTest("T3",
        "(FirePage) ** FFD FIRE CALL ** GENERAL APT 72 / 3RD FLOOR / SMOKE 100 N MAIN ST\nC/S: RANDALL AVE / GRAND AVE TOA: 18:50 [FireTracker]",
        "CALL:GENERAL/3RD FLOOR/SMOKE",
        "APT:72",
        "ADDR:100 N MAIN ST",
        "X:RANDALL AVE / GRAND AVE");

    doTest("T4",
        "(FirePage) ** FFD FIRE CALL ** STILL WILLOWBROOK LA C/S: BROOKSIDE (N) AVE TOA:\n09:16 [FireTracker]",
        "CALL:STILL",
        "ADDR:WILLOWBROOK LN",
        "X:BROOKSIDE (N) AVE");

    doTest("T5",
        "(FirePage) ** FFD FIRE CALL ** GENERAL ELEC PROBLEM/APT 415 45 WALLACE ST C/S:\nBROOKLYN AVE / RANDALL AVE TOA: 18:26 [FireTracker]",
        "CALL:GENERAL ELEC PROBLEM /",
        "APT:415",
        "ADDR:45 WALLACE ST",
        "X:BROOKLYN AVE / RANDALL AVE");


    doTest("T6",
        "(FirePage) ** FFD FIRE CALL ** CARBON APT 33 116 WEST END AVE C/S: RAY ST / ELINOR\nPL TOA: 11:23 [FireTracker]",
        "CALL:CARBON",
        "ADDR:116 WEST END AVE",
        "APT:33",
        "X:RAY ST / ELINOR PL");

    doTest("T7",
        "(FirePage) ** FFD FIRE CALL ** GENERAL 22 PEARSALL AVE C/S: LONG BEACH (N) AVE /\nPENNSYLVANIA AVE TOA: 15:56 [FireTracker]",
        "CALL:GENERAL",
        "ADDR:22 PEARSALL AVE",
        "X:LONG BEACH (N) AVE / PENNSYLVANIA AVE");
  
  }
  
  public static void main(String[] args) {
    new NYNassauCountyFiretrackerParserTest().generateTests("T6");
  }
}