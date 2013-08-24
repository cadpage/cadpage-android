package net.anei.cadpage.parsers.SD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Pennington county, SD
Contact: josh van Vlack <joshvanvlack@live.com>
Sender: dispatch@co.pennington.sd.us

(page ) Unit:29H1 Status:dispatched diabetic 12823 old hill city rd pennco Problem: blood sugar issues. Patient info: 1 patient(s) 58 years old; female
(page ) Unit:29H1 Status:dispatched seizure 209 Main St Hill City Cafe ProQA Medical Dispatch Message Sent; Dispatch code: 12-D-02 Problem :SE
(page ) Unit:HC Status:Dispatched FALARM 23835 Highway 385 Mistletoe Ranch pennco fire alarm showing downstairs smoke detector DEPT56. PREM PHONE 605-574-2512
(page ) Unit:HC Status:dispatched Falarm 602 Main St Hillyo Manor Hill City Pull Station fire alarm prem#605-574-2476
(page ) Unit:29H2 Status:Dispatched fall 302 Main Street Hill city Elementary Hill City ProQA medical dispatch code 17-b-01G
(page ) Unit:29H2 Status:dispatched breath 745 chute Rooster dr Matkins trailer court Hill City ProQA medical dispatch message sent; dispatch code: 06
(page ) Unit:29H2 Status:EMS 133 Main St Alpine Inn hill city unk age/unk specifics/rp will come back to the phone/possible heart attack
(page ) Unit:29H1 Status:disatched EMS 557 e main street Hill City call at the Hill City Clinic
(page ) Unit:29H1 Status:dispatched breath 101 main st exxon Hill City 52 year old, male, conscious, breathing, breathing problems. difficulty speaking
(page ) Unit:29H1 Status:Dispatched Stroke 24185 Tin Horse Trl pennco 61 year old, female, conscious, breathing, abnormal breathing (clear evidence of stroke)

Contact: Alexander Ingalls <alexingalls09@gmail.com>
(Page ) Unit:RV Status:DISPATCHED FIRE 300 E  SIGNAL DR NATIONAL WEATHER SERVICERapid City  1/4 ACRE MOVING TO THE WEST TOWARDS THE TALL GRASS.  1/4 ACRE
(Page ) Unit:RV Status:DISPATCHED SUIC 2064 S VALLEY DR PENNCO  RPT**  MALE SUBJ HUNG HIMSELF AT ABOVE LOC  13:10
(Page) Unit:RV Status:DISPATCHED STRUCF CALLBK=(605)391-43 NW Sector Rapid City  69D10  TRAILER HOUSE ON FIRE.  AT THE END OF 150TH AV  09:50

Contact: Rick Huling <hardface.rh@gmail.com>
Sender: dispatch@co.pennington.sd.us
(Page) Unit:NH Status:DISPATCHED FIRE HORSESHOE RD ELK VALE RD Box Elder  STRUCTURES BEING THREATEN  ON PRAIRIE     GRASS FIRE***  NORTH OF THE FLYING
(Page) Unit:NH Status:DISPATCHED SRV 9116 WOODLAND DR Black Hawk  ProQA Fire Questionnaire Aborted - 8. Non-fire call; Dispatch Code: --  RESIDENT: SHE
(Page) Unit:NH Status:DISPATCHED STRUCF 11651 FOUNTAIN PL North Haines  Structure Fire.  0 Mobile home, house trailer, portable office.Caller Statement

*/
public class SDPenningtonCountyParserTest extends BaseParserTest {
  
  public SDPenningtonCountyParserTest() {
    setParser(new SDPenningtonCountyParser(), "PENNINGTON COUNTY", "SD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(page ) Unit:29H1 Status:dispatched diabetic 12823 old hill city rd pennco Problem: blood sugar issues. Patient info: 1 patient(s) 58 years old; female",
        "UNIT:29H1",
        "CALL:dispatched diabetic",
        "ADDR:12823 old hill city rd",
        "INFO:blood sugar issues. / 1 patient(s) 58 years old; female");

    doTest("T2",
        "(page ) Unit:29H1 Status:dispatched seizure 209 Main St Hill City Cafe ProQA Medical Dispatch Message Sent; Dispatch code: 12-D-02 Problem :SE",
        "UNIT:29H1",
        "CALL:dispatched seizure",
        "ADDR:209 Main St",
        "CITY:Hill City",
        "INFO:Cafe / SE",
        "CODE:12-D-02");

    doTest("T3",
        "(page ) Unit:HC Status:Dispatched FALARM 23835 Highway 385 Mistletoe Ranch pennco fire alarm showing downstairs smoke detector DEPT56. PREM PHONE 605-574-2512",
        "UNIT:HC",
        "CALL:Dispatched FALARM",
        "ADDR:23835 Highway 385",
        "PLACE:Mistletoe Ranch",
        "INFO:fire alarm showing downstairs smoke detector DEPT56. PREM PHONE 605-574-2512");

    doTest("T4",
        "(page ) Unit:HC Status:dispatched Falarm 602 Main St Hillyo Manor Hill City Pull Station fire alarm prem#605-574-2476",
        "UNIT:HC",
        "CALL:dispatched Falarm",
        "ADDR:602 Main St",
        "PLACE:Hillyo Manor",
        "CITY:Hill City",
        "INFO:Pull Station fire alarm prem#605-574-2476");

    doTest("T5",
        "(page ) Unit:29H2 Status:Dispatched fall 302 Main Street Hill city Elementary Hill City ProQA medical dispatch code 17-b-01G",
        "UNIT:29H2",
        "CALL:Dispatched fall",
        "ADDR:302 Main Street",
        "PLACE:Hill city Elementary",
        "CITY:Hill City",
        "CODE:17-b-01G");

    doTest("T6",
        "(page ) Unit:29H2 Status:dispatched breath 745 chute Rooster dr Matkins trailer court Hill City ProQA medical dispatch message sent; dispatch code: 06",
        "UNIT:29H2",
        "CALL:dispatched breath",
        "ADDR:745 chute Rooster dr",
        "PLACE:Matkins trailer court",
        "CITY:Hill City");

    doTest("T7",
        "(page ) Unit:29H2 Status:EMS 133 Main St Alpine Inn hill city unk age/unk specifics/rp will come back to the phone/possible heart attack",
        "UNIT:29H2",
        "CALL:EMS",
        "ADDR:133 Main St",
        "PLACE:Alpine Inn",
        "CITY:hill city",
        "INFO:unk age/unk specifics/rp will come back to the phone/possible heart attack");

    doTest("T8",
        "(page ) Unit:29H1 Status:dispatched breath 101 main st exxon Hill City 52 year old, male, conscious, breathing, breathing problems. difficulty speaking",
        "UNIT:29H1",
        "CALL:dispatched breath",
        "ADDR:101 main st",
        "PLACE:exxon",
        "CITY:Hill City",
        "INFO:52 year old, male, conscious, breathing, breathing problems. difficulty speaking");

    doTest("T9",
        "(page ) Unit:29H1 Status:Dispatched Stroke 24185 Tin Horse Trl pennco 61 year old, female, conscious, breathing, abnormal breathing (clear evidence of stroke)",
        "UNIT:29H1",
        "CALL:Dispatched Stroke",
        "ADDR:24185 Tin Horse Trl",
        "INFO:61 year old, female, conscious, breathing, abnormal breathing (clear evidence of stroke)");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(Page ) Unit:RV Status:DISPATCHED FIRE 300 E  SIGNAL DR NATIONAL WEATHER SERVICERapid City  1/4 ACRE MOVING TO THE WEST TOWARDS THE TALL GRASS.  1/4 ACRE",
        "UNIT:RV",
        "CALL:DISPATCHED FIRE",
        "ADDR:300 E SIGNAL DR",
        "INFO:NATIONAL WEATHER SERVICERapid City  1/4 ACRE MOVING TO THE WEST TOWARDS THE TALL GRASS.  1/4 ACRE");

    doTest("T2",
        "(Page ) Unit:RV Status:DISPATCHED SUIC 2064 S VALLEY DR PENNCO  RPT**  MALE SUBJ HUNG HIMSELF AT ABOVE LOC  13:10",
        "UNIT:RV",
        "CALL:DISPATCHED SUIC",
        "ADDR:2064 S VALLEY DR",
        "INFO:RPT**  MALE SUBJ HUNG HIMSELF AT ABOVE LOC",
        "TIME:13:10");

    doTest("T3",
        "(Page) Unit:RV Status:DISPATCHED STRUCF CALLBK=(605)391-43 NW Sector Rapid City  69D10  TRAILER HOUSE ON FIRE.  AT THE END OF 150TH AV  09:50",
        "UNIT:RV",
        "CALL:DISPATCHED STRUCF",
        "PHONE:(605)391-43",
        "ADDR:NW Sector",
        "CITY:Rapid City",
        "INFO:TRAILER HOUSE ON FIRE.  AT THE END OF 150TH AV",
        "CODE:69D10",
        "TIME:09:50");

  }
  
  @Test
  public void testRickHulling() {

    doTest("T1",
        "(Page) Unit:NH Status:DISPATCHED FIRE HORSESHOE RD ELK VALE RD Box Elder  STRUCTURES BEING THREATEN  ON PRAIRIE     GRASS FIRE***  NORTH OF THE FLYING",
        "UNIT:NH",
        "CALL:DISPATCHED FIRE",
        "ADDR:HORSESHOE RD & ELK VALE RD",
        "CITY:Box Elder",
        "INFO:STRUCTURES BEING THREATEN  ON PRAIRIE     GRASS FIRE***  NORTH OF THE FLYING");

    doTest("T2",
        "(Page) Unit:NH Status:DISPATCHED SRV 9116 WOODLAND DR Black Hawk  ProQA Fire Questionnaire Aborted - 8. Non-fire call; Dispatch Code: --  RESIDENT: SHE",
        "UNIT:NH",
        "CALL:DISPATCHED SRV",
        "ADDR:9116 WOODLAND DR",
        "INFO:Black Hawk");

    doTest("T3",
        "(Page) Unit:NH Status:DISPATCHED STRUCF 11651 FOUNTAIN PL North Haines  Structure Fire.  0 Mobile home, house trailer, portable office.Caller Statement",
        "UNIT:NH",
        "CALL:DISPATCHED STRUCF",
        "ADDR:11651 FOUNTAIN PL",
        "INFO:North Haines  Structure Fire.  0 Mobile home, house trailer, portable office.Caller Statement");
   
  }
  
  public static void main(String[] args) {
    new SDPenningtonCountyParserTest().generateTests("T1");
  }
}