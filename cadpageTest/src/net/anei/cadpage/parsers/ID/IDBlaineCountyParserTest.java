package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.ID.IDBlaineCountyParserTest;

import org.junit.Test;


public class IDBlaineCountyParserTest extends BaseParserTest {
  
  public IDBlaineCountyParserTest() {
    setParser(new IDBlaineCountyParser(), "BLAINE COUNTY", "ID");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page for CFS BC012512-12) FIRE ALARM\n314 S 7TH ST\nApt:\nBELLEVUE\nCross Streets : PINE ST * POPLAR ST",
        "ID:BC012512-12",
        "CALL:FIRE ALARM",
        "ADDR:314 S 7TH ST",
        "CITY:BELLEVUE",
        "X:PINE ST * POPLAR ST");

    doTest("T2",
        "(CAD Page for CFS BC013012-62) GAS LEAK-ODOR NO INJURY\n119 S MAIN ST\nApt:\nBELLEVUE\nCross Streets : ELM ST * OAK ST",
        "ID:BC013012-62",
        "CALL:GAS LEAK-ODOR NO INJURY",
        "ADDR:119 S MAIN ST",
        "CITY:BELLEVUE",
        "X:ELM ST * OAK ST");

    doTest("T3",
        "(CAD Page for CFS BC120311-14) STRUCTURE FIRE\n313 N 2ND AVE\nApt:\nHAILEY\nCross Streets : E GALENA ST * E SILVER ST",
        "ID:BC120311-14",
        "CALL:STRUCTURE FIRE",
        "ADDR:313 N 2ND AVE",
        "CITY:HAILEY",
        "X:E GALENA ST * E SILVER ST");

    doTest("T4",
        "(CAD Page for CFS BC111611-42) HAZMAT NO INJURY INCIDENT\n516 N MAIN ST\nApt:\nBELLEVUE\nCross Streets : BEECH ST * ASH ST",
        "ID:BC111611-42",
        "CALL:HAZMAT NO INJURY INCIDENT",
        "ADDR:516 N MAIN ST",
        "CITY:BELLEVUE",
        "X:BEECH ST * ASH ST");

    doTest("T5",
        "(CAD Page for CFS BC072511-60) FIRE-STRUCTURE\nCEDAR ST and N 4TH ST\nApt:\nBELLEVUE\nCross Streets : ELM ST * CEDAR ST",
        "ID:BC072511-60",
        "CALL:FIRE-STRUCTURE",
        "ADDR:CEDAR ST and N 4TH ST",
        "MADDR:CEDAR ST & N 4TH ST",
        "CITY:BELLEVUE",
        "X:ELM ST * CEDAR ST");

    doTest("T6",
        "(CAD Page for CFS BC021212-61) Convulsions-Seizures\n1160 ECHO HILL DR\nApt: \nHAILEY\nCross Streets : BUTTERFLY DR * BERRYCREEK DR",
        "ID:BC021212-61",
        "CALL:Convulsions-Seizures",
        "ADDR:1160 ECHO HILL DR",
        "CITY:HAILEY",
        "X:BUTTERFLY DR * BERRYCREEK DR");

  }
  
  public static void main(String[] args) {
    new IDBlaineCountyParserTest().generateTests("T1");
  }
}