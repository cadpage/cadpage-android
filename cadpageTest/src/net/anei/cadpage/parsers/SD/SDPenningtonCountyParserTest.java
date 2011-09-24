package net.anei.cadpage.parsers.SD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
        "INFO:fire alarm showing downstairs smoke detector DEPT56 PREM PHONE 605-574-2512");

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
        "INFO:unk age / unk specifics / rp will come back to the phone / possible heart attack");

    doTest("T8",
        "(page ) Unit:29H1 Status:dispatched breath 101 main st exxon Hill City 52 year old, male, conscious, breathing, breathing problems. difficulty speaking",
        "UNIT:29H1",
        "CALL:dispatched breath",
        "ADDR:101 main st",
        "PLACE:exxon",
        "CITY:Hill City",
        "INFO:52 year old, male, conscious, breathing, breathing problems difficulty speaking");

    doTest("T9",
        "(page ) Unit:29H1 Status:Dispatched Stroke 24185 Tin Horse Trl pennco 61 year old, female, conscious, breathing, abnormal breathing (clear evidence of stroke)",
        "UNIT:29H1",
        "CALL:Dispatched Stroke",
        "ADDR:24185 Tin Horse Trl",
        "INFO:61 year old, female, conscious, breathing, abnormal breathing (clear evidence of stroke)");
  }
  
  public static void main(String[] args) {
    new SDPenningtonCountyParserTest().generateTests("T1");
  }
}