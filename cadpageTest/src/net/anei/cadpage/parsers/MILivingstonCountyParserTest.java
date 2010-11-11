package net.anei.cadpage.parsers;

import org.junit.Test;


public class MILivingstonCountyParserTest extends BaseParserTest {
  
  public MILivingstonCountyParserTest() {
    setParser(new GASmyrnaParser(), "SMYRNA", "GA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10 04:17:07 ECOOK]",
        "CALL:ALARMF",
        "ADDR:11555 PLEASANT VIEW DR",
        "X:INDIAN TRL",
        "INFO:SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING");

    doTest("T2",
        "CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE [09/23/10 21:45:06 ECOOK]",
        "CALL:UNKACC",
        "ADDR:E M36 & PETTYS RD",
        "INFO:VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE");
    
    doTest("T3",
        "CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal",
        "CALL:CHSTPN",
        "ADDR:8422 PAWNEE TRL",
        "X:SHOSHONI PASS");
        
    doTest("T4",
        "CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.",
        "CALL:UNCON",
        "ADDR:8732 RIVER VALLEY RD");
        
    doTest("T5",
        "Pagecopy-Fr:CAD@lc911\nCAD:FYI: ;CHSTPN;7251 HAMBURG RD;WELLE RD;[Medical Priority Info] RESPONSE: P1 STA 1 3 4 5 6 7 8 FC FT RESPONDER S",
        "CALL:CHSTPN",
        "ADDR:7251 HAMBURG RD",
        "X:WELLE RD");
 }
}
