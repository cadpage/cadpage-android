package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAChesterCountyD2ParserTest extends BaseParserTest {
  
  public PAChesterCountyD2ParserTest() {
    setParser(new PAChesterCountyD2Parser(), "CHESTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(309 STARR ST ,15) ACCIDENT - INJURIES * * VEH VRS POLE\nDETAILS TO FOLLOW\nTYP: ACCUNK  --> ACCINJ  \nRSP: 0050   --> 0004   \n* 05/08/11 * 11:11 *",
        "ADDR:309 STARR ST",
        "CITY:PHOENIXVILLE",
        "CALL:ACCIDENT - INJURIES",
        "INFO:VEH VRS POLE DETAILS TO FOLLOW TYP: ACCUNK  --> ACCINJ   RSP: 0050   --> 0004");

    doTest("T2",
        "(300 W HIGH ST ,15) ALARM - FIRE * * AFA - GEN - ATN\n* 05/08/11 * 05:42 *",
        "ADDR:300 W HIGH ST",
        "CITY:PHOENIXVILLE",
        "CALL:ALARM - FIRE",
        "INFO:AFA - GEN - ATN");

    doTest("T3",
        "(325 BRIDGE ST ,15) ACCIDENT - PEDESTRIAN STRUCK * * PD OS WITH ONE  SUBJ ON THE GROUND\nLOC: 300 BRIDGE ST ,15 -->\2s325 BRIDGE ST ,15-\n- FAMILY DOLLAR S * 05/08/11",
        "ADDR:325 BRIDGE ST",
        "CITY:PHOENIXVILLE",
        "CALL:ACCIDENT - PEDESTRIAN STRUCK",
        "INFO:PD OS WITH ONE  SUBJ ON THE GROUND LOC: 300 BRIDGE ST ,15 -->\2s325 BRIDGE ST ,15- - FAMILY DOLLAR S");

    doTest("T4",
        "(2 N MAIN ST ,15) FUEL SPILL * * ENG65 IS RESPONDING\n* 05/07/11 * 13:31 *",
        "ADDR:2 N MAIN ST",
        "CITY:PHOENIXVILLE",
        "CALL:FUEL SPILL",
        "INFO:ENG65 IS RESPONDING");

    doTest("T5",
        "(724 WHEATLAND ST ,15) BRUSH FIRE * * DETAILS TO FOLLOW\n* 04/20/11 * 15:52 *",
        "ADDR:724 WHEATLAND ST",
        "CITY:PHOENIXVILLE",
        "CALL:BRUSH FIRE",
        "INFO:DETAILS TO FOLLOW");

    doTest("T6",
        "(140 NUTT RD ,15) ALARM - FIRE * * FIRE ALARM TWO SEPERATE SMOKE DETECTOR UNK LOC\n- DID NOT CALL THE HOSPITAL-WILL BE NOTIFING-\nDETAI * 04/25/11 * 12:47 *",
        "ADDR:140 NUTT RD",
        "CITY:PHOENIXVILLE",
        "CALL:ALARM - FIRE",
        "INFO:FIRE ALARM TWO SEPERATE SMOKE DETECTOR UNK LOC - DID NOT CALL THE HOSPITAL-WILL BE NOTIFING- DETAI");

    doTest("T7",
        "(213 W HIGH ST ,15) TRASH/DUMPSTER FIRE * * SMOLDERING FROM DUMPSTER -- DUMPSTER IS A \"2 L\nID\" DUMPSTER\nDETAILS TO FOLLOW\n* 05/01/11 * 20:28 *",
        "ADDR:213 W HIGH ST",
        "CITY:PHOENIXVILLE",
        "CALL:TRASH/DUMPSTER FIRE",
        "INFO:SMOLDERING FROM DUMPSTER -- DUMPSTER IS A \"2 L ID\" DUMPSTER DETAILS TO FOLLOW");

  }
  
  public static void main(String[] args) {
    new PAChesterCountyD2ParserTest().generateTests("T1");
  }
}
