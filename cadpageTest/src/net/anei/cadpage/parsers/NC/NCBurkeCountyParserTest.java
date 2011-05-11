package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCBurkeCountyParserTest extends BaseParserTest {
  
  public NCBurkeCountyParserTest() {
    setParser(new NCBurkeCountyParser(), "BURKE COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "|CAD:69;MED;10D01;2447 LAIL RD;RIVER CLUB DR;CANNONBALL ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 50 year old, Male, [1 of 2]",
        "SRC:69",
        "CALL:MED",
        "CODE:10D01",
        "ADDR:2447 LAIL RD",
        "X:RIVER CLUB DR & CANNONBALL ST",
        "INFO:50 year old, Male,");

    doTest("T2",
        "|CAD:69;MVAPI;TURKEY TAIL LN/LINVILLE ST;[LAW] SUBJECT`S VEHICLES HAS ROLLED OVER AND HE WANTS TO BE CHECKED OUT -- ROUTINE [02/25/11 19:[1 of 2]",
        "SRC:69",
        "CALL:MVAPI",
        "ADDR:TURKEY TAIL LN & LINVILLE ST",
        "INFO:SUBJECT`S VEHICLES HAS ROLLED OVER AND HE WANTS TO BE CHECKED OUT -- ROUTINE");

    doTest("T3",
        "|CAD:75;MED;17D03;5751 ABEE FARM ST;NURSERY RD;NEIL RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a [1 of 2]",
        "SRC:75",
        "CALL:MED",
        "CODE:17D03",
        "ADDR:5751 ABEE FARM ST",
        "X:NURSERY RD & NEIL RD",
        "INFO:You are responding to a");

    doTest("T4",
        "|CAD:75;FIRE;67B01;3678 SILVER CREEK CT;SILVER CREEK TER;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL [1 of 2]",
        "SRC:75",
        "CALL:FIRE",
        "CODE:67B01",
        "ADDR:3678 SILVER CREEK CT",
        "X:SILVER CREEK TER",
        "INFO:Outside Fire. SMALL");

    doTest("T5",
        "|CAD:75;MED;26D01;5134 RAIN HILL CHURCH RD;MOUNT OLIVE CHURCH RD;RAINHILL DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: [1 of 2]",
        "SRC:75",
        "CALL:MED",
        "CODE:26D01",
        "ADDR:5134 RAIN HILL CHURCH RD",
        "X:MOUNT OLIVE CHURCH RD & RAINHILL DR");

    doTest("T6",
        "CAD:75;MED;31D02;4612 AMBER LN;DENTONS CHAPEL RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is",
        "SRC:75",
        "CALL:MED",
        "CODE:31D02",
        "ADDR:4612 AMBER LN",
        "X:DENTONS CHAPEL RD",
        "INFO:You are responding to a patient who is");

    doTest("T7",
        "CAD:75;MED;10D02;1968 CONLEY RD;REESE STORE AV;FOREMAN ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 44 year old, Male, Conscious,",
        "SRC:75",
        "CALL:MED",
        "CODE:10D02",
        "ADDR:1968 CONLEY RD",
        "X:REESE STORE AV & FOREMAN ST",
        "INFO:44 year old, Male, Conscious,");
  }
  

  public static void main(String[] args) {
    new NCBurkeCountyParserTest().generateTests("T8");
  }
}
