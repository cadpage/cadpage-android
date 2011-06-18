package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXWilliamsonCountyParserTest extends BaseParserTest {
  
  public TXWilliamsonCountyParserTest() {
    setParser(new TXWilliamsonCountyParser(), "WILLIAMSON COUNTY", "TX");
  }
  

  @Test
  public void testParser() {
    doTest("T1",
        "CAD:REQUEST EMS;501 EXCHANGE BLVD;HU;HUE1",
        "CALL:REQUEST EMS",
        "ADDR:501 EXCHANGE BLVD",
        "UNIT:HUE1");

    doTest("T2",
        "CAD:FYI: ;SA CITIZEN ASSIST;200-BLK ED SCHMIDT BLVD;HU",
        "CALL:SA CITIZEN ASSIST",
        "ADDR:200-BLK ED SCHMIDT BLVD",
        "UNIT:HU");

    doTest("T3",
        "CAD:REQUEST FIRE;201 ED SCHMIDT BLVD;HU;HUE1",
        "CALL:REQUEST FIRE",
        "ADDR:201 ED SCHMIDT BLVD",
        "UNIT:HUE1");

    doTest("T4",
        "CAD:FYI: ;SICK PERSON SPEC DIAGNOSIS;206 ARROWHEAD TRL;CP",
        "CALL:SICK PERSON SPEC DIAGNOSIS",
        "ADDR:206 ARROWHEAD TRL",
        "UNIT:CP");

    doTest("T5",
        "CAD:REQUEST FIRE;200-BLK BROOKE ST;HU;HUE1",
        "CALL:REQUEST FIRE",
        "ADDR:200-BLK BROOKE ST",
        "UNIT:HUE1");

    doTest("T6",
        "CAD:FYI: ;SA CITIZEN ASSIST;100 CR 165;HU",
        "CALL:SA CITIZEN ASSIST",
        "ADDR:100 CR 165",
        "UNIT:HU");

    doTest("T7",
        "CAD:FYI: ;GA OUTSIDE FIRE;5634 CHANDLER RD/SH 130 TOLL;HU",
        "CALL:GA OUTSIDE FIRE",
        "ADDR:5634 CHANDLER RD & TX 130",
        "UNIT:HU");

    doTest("T8",
        "CAD:Update: ;TRAFFIC TRANSPORTATION ACC;2058 LIMMER LOOP/CR 108;HU;HUE1",
        "CALL:TRAFFIC TRANSPORTATION ACC",
        "ADDR:2058 LIMMER LOOP & CR 108",
        "UNIT:HUE1");

    doTest("T9",
        "CAD:Update: ;GA OUTSIDE FIRE;5634 CHANDLER RD/SH 130 TOLL;HU;HUBT1,HUE1",
        "CALL:GA OUTSIDE FIRE",
        "ADDR:5634 CHANDLER RD & TX 130",
        "UNIT:HUBT1,HUE1");
    
  }
  
  public static void main(String[] args) {
    new TXWilliamsonCountyParserTest().generateTests("T1");
  }
}