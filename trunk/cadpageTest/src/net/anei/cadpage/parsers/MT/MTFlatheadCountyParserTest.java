package net.anei.cadpage.parsers.MT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MTFlatheadCountyParserTest extends BaseParserTest {
  
  public MTFlatheadCountyParserTest() {
    setParser(new MTFlatheadCountyParser(), "FLATHEAD COUNTY", "MT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: 417 1ST AVE N Martin City Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 06:29 Info:  ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV \n(Con't) 3 of 3\ncpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now  \n(End)",
        "UNIT:MCFD",
        "ADDR:417 1ST AVE N",
        "CITY:Martin City",
        "CALL:Medical ALS",
        "INFO:ton of cars in front drive, thengo to back yard  had chest pains prior to this  CO UNITS ADV  cpr in progress  50 ACK  55 ACK  turning blue  unk what happened, goingto him now");

    doTest("T2",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Hungry Horse Reservoir Call\n(Con't) 2 of 3\nType: Medical ALS Call Time: 21:13 Info:  RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501\n(Con't) 3 of 3\nACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS\n(End)",
        "UNIT:MCFD",
        "ADDR:Hungry Horse Reservoir",
        "CALL:Medical ALS",
        "INFO:RUN CARD SHOWED NO FIRE UNITS TODISPATCH, DISPATCHED HHFD AND MCFD FROM MEMORY  1602 AND 1501 ACK  RP CALLED BACK....FATHER IS FEELING WEAK AND SLEEPY  ADV TO CALL BACKWHEN GETS");

    doTest("T3",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: HIGHWAY 2 E Hungry Horse Call\n(Con't) 2 of 3\nType: F Smoke Investigation - Outside Call Time: 20:00 Info:  RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD\n(Con't) 3 of 3\nCOMING FORM THE AREA OF HUNGRY HORSE. \n(End)",
        "UNIT:MCFD",
        "ADDR:HIGHWAY 2 E",
        "CITY:Hungry Horse",
        "CALL:F Smoke Investigation - Outside",
        "INFO:RP LIVES AT844 WOODLAND AVE  CAN SEE WHAT APPEARS TO BE A SMOKE CLOUD COMING FORM THE AREA OF HUNGRY HORSE.");

    doTest("T4",
        "1 of 3\nFRM:dispatch@communicationcenter.com\nSUBJ:Dispatch Information\nMSG:Unit:MCFD Status:Dispatched Location: Call Type: MVA Injury Call Time:\n(Con't) 2 of 3\n17:03 Info:  RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS \n(Con't) 3 of 3\n4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK\n(End)",
        "UNIT:MCFD",
        "CALL:MVA Injury",
        "INFO:RP STATED THEY DID NOT NEED ALERT  KIDC SAYS TREMS CAN MAKEIT UP THERE...LOWER LEFT LEG PAIN, NO LOC & SOME HEAD ABRASIONS  4 MILES UP RD #497//TOWARD DESERT MTN RD  LEG AND BACK");

  }
  
  public static void main(String[] args) {
    new MTFlatheadCountyParserTest().generateTests("T1");
  }
}
