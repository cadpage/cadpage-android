package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyDParserTest extends BaseParserTest {
  
  public NYNassauCountyDParserTest() {
    setParser(new NYNassauCountyDParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*** 30) RESCUE-SIGNAL 9 *** 21 BELMONT AVE CS: DAVID CT TOA: 18:39 03-29-11",
        "CALL:30) RESCUE-SIGNAL 9",
        "ADDR:21 BELMONT AVE",
        "X:DAVID CT");

    doTest("T2",
        "*** 45) BRUSH *** 1 MILLER RD CS: HEMPSTEAD TPKE TOA: 14:48 03-29-11",
        "CALL:45) BRUSH",
        "ADDR:1 MILLER RD",
        "X:HEMPSTEAD TPKE");

    doTest("T3",
        "*** 11) AFA -HOUSE *** 21 CLARK ST CS: EILEEN AVE TOA: 08:09 03-29-11",
        "CALL:11) AFA -HOUSE",
        "ADDR:21 CLARK ST",
        "X:EILEEN AVE");

    doTest("T4",
        "*** 75) CARBON MONOXIDE ALARM *** 91 SUNBEAM AVE CS: SUNNY LN TOA: 04:08 03-26-11",
        "CALL:75) CARBON MONOXIDE ALARM",
        "ADDR:91 SUNBEAM AVE",
        "X:SUNNY LN");

    doTest("T5",
        "*** 13) SMOKE INVESTIGATION *** 56 APOLLO CIR CS: HICKEY BLVD TOA: 22:16 03-26-11",
        "CALL:13) SMOKE INVESTIGATION",
        "ADDR:56 APOLLO CIR",
        "X:HICKEY BLVD");

    doTest("T6",
        "*** 82) MUTUAL AID *** 930 HICKSVILLE FD TO STANDBY CS: CAROLINE ST TOA: 10:10 03-26-11",
        "CALL:82) MUTUAL AID",
        "ADDR:930 HICKSVILLE FD TO STANDBY",
        "X:CAROLINE ST");

    doTest("T7",
        "*** 20) BUILDING FIRE *** 4105 HEMPSTEAD TPKE CS: HICKSVILLE RD TOA: 20:48 03-21-11",
        "CALL:20) BUILDING FIRE",
        "ADDR:4105 HEMPSTEAD TPKE",
        "X:HICKSVILLE RD");

    doTest("T8",
        "*** 61) TRUCK FIRE *** HICKSVILLE RD CS: MARTIN RD N TOA: 19:35 03-21-11",
        "CALL:61) TRUCK FIRE",
        "ADDR:HICKSVILLE RD",
        "X:MARTIN RD N");

    doTest("T9",
        "*** 10) HOUSE FIRE *** 22 CRESTLINE AVE CS: HILLTOP AVE TOA: 15:41 03-21-11",
        "CALL:10) HOUSE FIRE",
        "ADDR:22 CRESTLINE AVE",
        "X:HILLTOP AVE");

    doTest("T10",
        "*** 10) HOUSE FIRE *** 212 GILLING RD CS: WHELAN PL TOA: 14:33 03-20-11",
        "CALL:10) HOUSE FIRE",
        "ADDR:212 GILLING RD",
        "X:WHELAN PL");
  }
  
  public static void main(String[] args) {
    new NYNassauCountyDParserTest().generateTests("T1");
  }
}