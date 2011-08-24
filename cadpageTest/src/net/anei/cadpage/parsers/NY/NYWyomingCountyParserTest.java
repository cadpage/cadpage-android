package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYWyomingCountyParserTest extends BaseParserTest {
  
  public NYWyomingCountyParserTest() {
    setParser(new NYWyomingCountyParser(), "WYOMING COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "2314, STEDMAN RD;BENNINGTON TOWN (TINKHAM RD / GEISE RD)\n4105-Fire Alarm\nBE:2011:59\nThe document(s) accompanying t",
        "ADDR:2314 STEDMAN RD",
        "CITY:BENNINGTON",
        "X:TINKHAM RD / GEISE RD",
        "CALL:4105-Fire Alarm",
        "SRC:BE",
        "MAP:2011:59");

    doTest("T2",
        "560, BURROUGH RD;BENNINGTON TOWN (GETMAN RD / FRIEDMAN RD)\n4001-Abdominal Pain\nBE:2011:57\nThe document(s) accompan",
        "ADDR:560 BURROUGH RD",
        "CITY:BENNINGTON",
        "X:GETMAN RD / FRIEDMAN RD",
        "CALL:4001-Abdominal Pain",
        "SRC:BE",
        "MAP:2011:57");

    doTest("T3",
        "ATTICA RODEO GROUNDS ;ATTICA VILLAGE ( 230 EXCHANGE ST)\n4109-Stand-by\nAT:2011:211",
        "ADDR:ATTICA RODEO GROUNDS",
        "CITY:ATTICA",
        "X: 230 EXCHANGE ST",
        "CALL:4109-Stand-by",
        "SRC:AT",
        "MAP:2011:211");

    doTest("T4",
        "709, BURROUGH RD;BENNINGTON TOWN (FRIEDMAN RD / ROUTE 354)\n4026-Sick Person\nBE:2011:54",
        "ADDR:709 BURROUGH RD",
        "CITY:BENNINGTON",
        "X:FRIEDMAN RD / ROUTE 354",
        "CALL:4026-Sick Person",
        "SRC:BE",
        "MAP:2011:54");

    doTest("T5",
        "1204, FRENCH RD;BENNINGTON TOWN (ROUTE 354 / HOOVER RD)\n4001-Abdominal Pain\nBE:2011:51",
        "ADDR:1204 FRENCH RD",
        "CITY:BENNINGTON",
        "X:ROUTE 354 / HOOVER RD",
        "CALL:4001-Abdominal Pain",
        "SRC:BE",
        "MAP:2011:51");

    doTest("T6",
        "2050, ROUTE 354 #PH;BENNINGTON TOWN (FRENCH RD / MAXON RD)\n4002-Allergies\nBE:2011:46",
        "ADDR:2050 ROUTE 354",
        "CITY:BENNINGTON",
        "X:FRENCH RD / MAXON RD",
        "CALL:4002-Allergies",
        "SRC:BE",
        "MAP:2011:46");

    doTest("T7",
        "1950, ROUTE 354 ;BENNINGTON TOWN (FRENCH RD / MAXON RD)\n6302-MVA/INJURY\nBE:2011:45",
        "ADDR:1950 ROUTE 354",
        "CITY:BENNINGTON",
        "X:FRENCH RD / MAXON RD",
        "CALL:6302-MVA/INJURY",
        "SRC:BE",
        "MAP:2011:45");

    doTest("T8",
        "32,S PEARL ST #APT LOWER;ATTICA VILLAGE (MAIN ST / DEAD END)\n4010-Chest Pain\nAT:2011:174",
        "ADDR:32 S PEARL ST",
        "APT:LOWER",
        "CITY:ATTICA",
        "X:MAIN ST / DEAD END",
        "CALL:4010-Chest Pain",
        "SRC:AT",
        "MAP:2011:174");

    doTest("T9",
        "380, ROUTE 77 ;BENNINGTON TOWN (GENESEE CO LINE / CHURCH RD)\n4030-Traumatic Injury\nBE:2011:42",
        "ADDR:380 ROUTE 77",
        "CITY:BENNINGTON",
        "X:GENESEE CO LINE / CHURCH RD",
        "CALL:4030-Traumatic Injury",
        "SRC:BE",
        "MAP:2011:42");

    doTest("T10",
        "(!BE) BURROUGHS RD/ROUTE 20A\n4029-Traffic Accident\nHC:2011:17",
        "ADDR:BURROUGHS RD & ROUTE 20A",
        "CALL:4029-Traffic Accident",
        "SRC:HC",
        "MAP:2011:17");
 }
  
  public static void main(String[] args) {
    new NYWyomingCountyParserTest().generateTests("T1");
  }
}