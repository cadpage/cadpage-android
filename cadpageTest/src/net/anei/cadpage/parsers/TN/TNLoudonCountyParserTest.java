package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNLoudonCountyParserTest extends BaseParserTest {
  
  public TNLoudonCountyParserTest() {
    setParser(new TNLoudonCountyParser(), "LOUDON COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M:KHICKS:8069 HUFFS FERRY RD NORTH LOUDON 2011028604 18:12:18 FIRE ALARM RES/SCOTT PH/988-8351 AREA/GENERAL FIRE",
        "ADDR:8069 HUFFS FERRY RD NORTH",
        "CITY:LOUDON",
        "ID:2011028604",
        "INFO:FIRE ALARM RES/SCOTT PH/988-8351 AREA/GENERAL FIRE");

    doTest("T2",
        "S: M:KHICKS:8533 POND CREEK RD PHILADELPHIA 2011035525 15:28:16 STRUCTURE FIRE UNK WHAT STARTED THE FIRE",
        "ADDR:8533 POND CREEK RD",
        "CITY:PHILADELPHIA",
        "ID:2011035525",
        "INFO:STRUCTURE FIRE UNK WHAT STARTED THE FIRE");

    doTest("T3",
        "S: M:JBLAKESLEE:1 WHITE WING RD//BIRD RD LENOIR CITY 2011030010 22:52:18 SMOKE INVESTIGATION COMPL SMELLS SMOKE IN THE ARE",
        "ADDR:1 WHITE WING RD & BIRD RD",
        "CITY:LENOIR CITY",
        "ID:2011030010",
        "INFO:SMOKE INVESTIGATION COMPL SMELLS SMOKE IN THE ARE");
  
  }
  

  public static void main(String[] args) {
    new TNLoudonCountyParserTest().generateTests("T5", "ADDR CITY PLACE CODE ID CALL INFO");
  }
}
