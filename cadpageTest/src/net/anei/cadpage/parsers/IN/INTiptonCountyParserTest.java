package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.IN.INTiptonCountyParser;

import org.junit.Test;


public class INTiptonCountyParserTest extends BaseParserTest {
  
  public INTiptonCountyParserTest() {
    setParser(new INTiptonCountyParser(), "TIPTON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:A5,R45,T43,E42,E41,T46;STRUCTURE FIRE RESIDENTIAL;4003;3000 N US 31 NB",
        "UNIT:A5,R45,T43,E42,E41,T46",
        "CALL:STRUCTURE FIRE RESIDENTIAL",
        "ID:4003",
        "ADDR:3000 N US 31 NB",
        "MADDR:3000 N US 31");

    doTest("T2",
        "CAD:WEATHER;SEVERE WEATHER;CITY;121-A W MADISON ST",
        "UNIT:WEATHER",
        "CALL:SEVERE WEATHER",
        "ID:CITY",
        "ADDR:121-A W MADISON ST",
        "MADDR:121 W MADISON ST");
    
    doTest("T3",
        "CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E",
        "UNIT:G49",
        "CALL:OUTSIDE FIRE-FIELD/WOODS",
        "ID:6001",
        "ADDR:6500 N 400 E");
    
    doTest("T4",
        "CAD:A5,R45;INJURED IN FALL;4000;E VINE ST/S WASHINGTON ST;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall",
        "UNIT:A5,R45",
        "CALL:INJURED IN FALL",
        "ID:4000",
        "ADDR:E VINE ST & S WASHINGTON ST",
        "INFO:You are responding to a patient involved in a fall");
    
    doTest("T5",
        "CAD:A5,R45;UNKNOWN MEDICAL PROBLEM;4004;3421 N SR 19;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient with an unknown problem",
        "UNIT:A5,R45",
        "CALL:UNKNOWN MEDICAL PROBLEM",
        "ID:4004",
        "ADDR:3421 N SR 19",
        "INFO:You are responding to a patient with an unknown problem");
    
    doTest("T6",
        "CAD:A5,R45;INJURED IN FALL;4002;304 E 625 N;hx of dementia [10/06/10 18:51:56 DARCIR] [Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to",
        "UNIT:A5,R45",
        "CALL:INJURED IN FALL",
        "ID:4002",
        "ADDR:304 E 625 N",
        "INFO:hx of dementia / You are responding to");
    
    doTest("T7",
        "CAD:G49;OUTSIDE FIRE-FIELD/WOODS;6001;6500 N 400 E",
        "UNIT:G49",
        "CALL:OUTSIDE FIRE-FIELD/WOODS",
        "ID:6001",
        "ADDR:6500 N 400 E");
    
  }
}