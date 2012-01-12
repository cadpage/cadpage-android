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
        "SICK PERSON\n90 KERN RD BENT (Between ERIE CO LINE & URF RD) ADULT FML NOT FEELING WELL",
        "CALL:SICK PERSON",
        "ADDR:90 KERN RD",
        "CITY:BENNINGTON",
        "X:ERIE CO LINE & URF RD",
        "INFO:ADULT FML NOT FEELING WELL");

    doTest("T2",
        "FALLS\n1387 ROUTE 77 BENT (Between ROUTE 354 & POLAND HILL RD)",
        "CALL:FALLS",
        "ADDR:1387 ROUTE 77",
        "CITY:BENNINGTON",
        "X:ROUTE 354 & POLAND HILL RD");

    doTest("T3",
        "HEART PROBLEMS\n1535 FRIEDMAN RD BENT (Between ROUTE 77 & TINKHAM RD)",
        "CALL:HEART PROBLEMS",
        "ADDR:1535 FRIEDMAN RD",
        "CITY:BENNINGTON",
        "X:ROUTE 77 & TINKHAM RD");

    doTest("T4",
        "STRUCTURE FIRE\nFRENCH RD BENT (Between ROUTE 354 & HOOVER RD) barn fire",
        "CALL:STRUCTURE FIRE",
        "ADDR:FRENCH RD",
        "MADDR:FRENCH RD & ROUTE 354",
        "CITY:BENNINGTON",
        "X:ROUTE 354 & HOOVER RD",
        "INFO:barn fire");

    doTest("T5",
        "SEIZURE/CONVULSION\n1375 ROUTE 354 BENT (Between ROUTE 77 & GRAFF RD)",
        "CALL:SEIZURE/CONVULSION",
        "ADDR:1375 ROUTE 354",
        "CITY:BENNINGTON",
        "X:ROUTE 77 & GRAFF RD");

    doTest("T6",
        "STRUCTURE FIRE\n1649 ROUTE 238 ATTT (Between NESBITT RD & ATTICA TOWN LINE)",
        "CALL:STRUCTURE FIRE",
        "ADDR:1649 ROUTE 238",
        "CITY:ATTICA",
        "X:NESBITT RD & ATTICA TOWN LINE");

    doTest("T7",
        "SICK PERSON\n1258 BURROUGH RD BENT (Between ROUTE 354 & SCHOELLKOPF RD)Post surgical abdominal pain.",
        "CALL:SICK PERSON",
        "ADDR:1258 BURROUGH RD",
        "CITY:BENNINGTON",
        "X:ROUTE 354 & SCHOELLKOPF RD",
        "INFO:Post surgical abdominal pain.");
   
  }
  
  public static void main(String[] args) {
    new NYWyomingCountyParserTest().generateTests("T1", "CALL ADDR APT CITY X INFO");
  }
}