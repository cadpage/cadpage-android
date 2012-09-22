package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Butler County, KS
Contact: Brandon Russell <brandon.russell11@gmail.com>
Sender: dispatch@bucoks.com
System: New World
he actual communication center is located in El
Doardo, KS. Other cities in the county include Augusta, Andover, Rose Hill,
Benton, Towanda, Leon, Douglass, Latham and Cassoday, KS.

Old text formats, before they swapped (MAP PAGE) and (ADDRESS)
[Incident Notification]  17D FALL (MAP PAGE): 26E (ADDRESS): 1611 N FAIRWAY DR Augusta (CROSS ST): N CLUB HOUSE DR / E FAIRWAY CT (NARR):  ProQA Medical Questionnai
[Incident Notification]  6D DIFF BREATHING (MAP PAGE): 22C (ADDRESS): 524 S EMPORIA ST El Dorado (CROSS ST): W CAVE SPRINGS AVE / W LOCUST AVE (NARR): ProQA Medica
(Incident Notification) 10D CHEST PAIN (MAP PAGE): 9 (ADDRESS): 5957 NE 80TH ST County (CROSS ST): NE ELLIS RD / NE HWY 177 (NARR):  ProQA Medical Questionnaire Co
(Incident Notification) 6E ECHO DIFF BREATH (MAP PAGE): 36F (ADDRESS): 218 E ROSEWOOD ST Rose Hill (CROSS ST): N MAIN ST / N MEEKER CT (NARR):  a  as fd3  es fd3
(Incident Notification) 31D UNCONCIOUS (MAP PAGE): 15 (ADDRESS): 955 N HAVERHILL RD El Dorado (CROSS ST): W PIONEER DR / W 6TH AVE (NARR):  acting alittle confused
[Incident Notification]  13D DIABETIC EMERGENCY (MAP PAGE): 25B (ADDRESS): 726 N PROSPERITY LN Andover (CROSS ST): W ELLEN LN / DEAD END (NARR):  rp

New text format
(Incident Notification) 10D CHEST PAIN (ADDRESS): 300 N MAIN ST El Dorado (MAP PAGE): 22C (CROSS ST): E 2ND AVE, W 2ND AVE / E 3RD AVE, W 3RD AVE (NARR):  ProQA Me

Contact: Active911
[Incident Notification] 6D DIFF BREATHING (ADDRESS): 812 N DENVER ST El Dorado (MAP PAGE): 15C (CROSS ST): W 7TH AVE / W 8TH AVE (NARR):  ProQA Medical Dispatch Message Sent; Dispatch Code: 06-D-02  67 year old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: cant breathe.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  Problem: cant breathe.  Patient Info: 1 patient(s); 67 Years old; Male; Conscious: Yes; Breathing: Yes; \r\n\n
[Incident Notification] 26D SICK CALL (ADDRESS): 200 N GORDY ST 210 El Dorado (MAP PAGE): 22C (CROSS ST): W 1ST AVE / W 2ND AVE Gordy Square Apartments(NARR):  ProQA Medical Key Questions have been completed; Dispatch Code: 26-D-01  2.No priority symptoms (ALPHA conditions 2-11 not identified).  Problem: shaking, .  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: shaking, .  1.She is not completely alert (not responding appropriately).  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-D-01  Problem: shak\r\n\n
[Incident Notification] 17B FALL (ADDRESS): 10352 SW EAGLE RD County (MAP PAGE): 26G (CROSS ST): SW 103RD CT / SW 104TH TER (NARR):  Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 17-B-01G  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  1.This happened now (less than 6hrs ago).  2.The fall was less than 10ft/3m (less than 1 story).  3.The fall was accidental.  4.There is some bleeding, not serious.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY\r\n\n
[Incident Notification] EMS (ADDRESS): 1139 N WASHINGTON ST El Dorado (MAP PAGE): 15C (CROSS ST): UNKNOWN / W 10TH AVE (NARR):  50 yom poss chest and back pain  leo out request ems at this location  Call Number 478 was created from Call Number 476(Sep 20 2012  9:03AM)  rp was VERY upset last night when he called it in  had a call last night of raccoon in the area  request officer 10-39 for back up  animal control at this location \r\n\n
[Incident Notification] 31C FAINTING (ADDRESS): 912 E KELLY AVE Augusta (MAP PAGE): 26E (CROSS ST): N HOOPER ST / N KELLY CT (NARR):  ProQA Medical Dispatch Message Sent; Dispatch Code: 31-C-02  Problem: passed out hit head.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (with cardiac history).  Caller Statement: passed out hit head.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has a history of \r\n\n
[Incident Notification] 26A SICK CALL (ADDRESS): 601 N ROSE HILL RD 117B Rose Hill (MAP PAGE): 36G (CROSS ST): W SMITH ST / E BERLIN DR Lakepoint Nursing Center Rose Hill(NARR):  wants tx to st joe  dvt thrombois  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  80 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: tx to st joe.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She does not have any pain.  4.She is not bleeding (or vomiting blood).  5.No priority symptoms (\r\n\n
[Incident Notification] 1A ABDOMINAL PAIN (ADDRESS): 2768 SE 13TH TER County (MAP PAGE): 21A (CROSS ST): SE WALKER RD / SE BLUESTEM RD (NARR):  40 year old, Female, Conscious, Breathing.  Abdominal Pain / Problems.  Abdominal pain.  Caller Statement: abdom.  1.She is completely alert (responding appropriately).  2.There was no mention of existing aortic aneurysm.  3.She has not fainted or nearly fainted.  Problem: abdom.  Patient Info: 1 patient(s); 40 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 01-A-01  abdominal and back pain \r\n\n
[Incident Notification] 26C SICK CALL (ADDRESS): 302 E WOODS AVE Andover (MAP PAGE): 25D (CROSS ST): N PORTH AVE / N SHAY RD (NARR):  breathing heavy  comp alert  36 yom con/bre  5.No priority symptoms (ALPHA conditions 2-11 not identified).  ProQA Medical Key Questions have been completed; Dispatch Code: 26-C-02  Patient Info: 1 patient(s); 36 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-C-02  36 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.He is completely alert (responding appropriately).  2.He is not breathing n\r\n\n
[Incident Notification] 21B HEMORRHAGE (ADDRESS): 6890 SW HOPKINS SWITCH RD County (MAP PAGE): 27 (CROSS ST): SW 70TH ST / SW 60TH ST (NARR):  51 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  POSSIBLY DANGEROUS hemorrhage.  Caller Statement: bleeding.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a POSSIBLY DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no SERIOUS bleeding.  6.She does not have a bleeding disorder or is taking blood thinners.  Problem: bleeding.  Patient Info: 1 patient(s); 51 Years old; Female; Conscious: \r\n\n
[Incident Notification] 26C SICK CALL (ADDRESS): 421 S PAWHUSKA ST County (MAP PAGE): 25I (CROSS ST): SW FAIRFAX ST / E HWY 54 (NARR):  51 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.It's not certain if she is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: arm pain  4.She is not bleeding (or vomiting blood).  -Comments: arm pain-  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  Patient Info: 1 patient(s); 51 Years old; Female; Conscious: Yes; Breathing: Yes; \r\n\n

*/

public class KSButlerCountyParserTest extends BaseParserTest {
  
  public KSButlerCountyParserTest() {
    setParser(new KSButlerCountyParser(), "BUTLER COUNTY", "KS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Incident Notification) 10D CHEST PAIN (ADDRESS): 300 N MAIN ST El Dorado (MAP PAGE): 22C (CROSS ST): E 2ND AVE, W 2ND AVE / E 3RD AVE, W 3RD AVE (NARR):  ProQA Me",
        "CALL:10D CHEST PAIN",
        "ADDR:300 N MAIN ST",
        "CITY:El Dorado",
        "MAP:22C",
        "X:E 2ND AVE, W 2ND AVE / E 3RD AVE, W 3RD AVE");
 }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[Incident Notification] 6D DIFF BREATHING (ADDRESS): 812 N DENVER ST El Dorado (MAP PAGE): 15C (CROSS ST): W 7TH AVE / W 8TH AVE (NARR):  ProQA Medical Dispatch Message Sent; Dispatch Code: 06-D-02  67 year old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: cant breathe.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  Problem: cant breathe.  Patient Info: 1 patient(s); 67 Years old; Male; Conscious: Yes; Breathing: Yes; \r\n\n",
        "CALL:6D DIFF BREATHING",
        "ADDR:812 N DENVER ST",
        "CITY:El Dorado",
        "MAP:15C",
        "X:W 7TH AVE / W 8TH AVE",
        "INFO:Dispatch Code: 06-D-02  67 year old, Male, Conscious, Breathing.  Breathing Problems.  DIFFICULTY SPEAKING BETWEEN BREATHS.  Caller Statement: cant breathe.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  Problem: cant breathe.  Patient Info: 1 patient(s); 67 Years old; Male; Conscious: Yes; Breathing: Yes;");

    doTest("T2",
        "[Incident Notification] 26D SICK CALL (ADDRESS): 200 N GORDY ST 210 El Dorado (MAP PAGE): 22C (CROSS ST): W 1ST AVE / W 2ND AVE Gordy Square Apartments(NARR):  ProQA Medical Key Questions have been completed; Dispatch Code: 26-D-01  2.No priority symptoms (ALPHA conditions 2-11 not identified).  Problem: shaking, .  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: shaking, .  1.She is not completely alert (not responding appropriately).  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-D-01  Problem: shak\r\n\n",
        "CALL:26D SICK CALL",
        "ADDR:200 N GORDY ST 210",
        "CITY:El Dorado",
        "MAP:22C",
        "X:W 1ST AVE / W 2ND AVE Gordy Square Apartments",
        "INFO:Dispatch Code: 26-D-01  2.No priority symptoms (ALPHA conditions 2-11 not identified).  Problem: shaking, .  Patient Info: 1 patient(s); 94 Years old; Female; Conscious: Yes; Breathing: Yes;  94 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Not alert.  Caller Statement: shaking, .  1.She is not completely alert (not responding appropriately).  Dispatch Code: 26-D-01  Problem: shak");

    doTest("T3",
        "[Incident Notification] 17B FALL (ADDRESS): 10352 SW EAGLE RD County (MAP PAGE): 26G (CROSS ST): SW 103RD CT / SW 104TH TER (NARR):  Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 17-B-01G  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  1.This happened now (less than 6hrs ago).  2.The fall was less than 10ft/3m (less than 1 story).  3.The fall was accidental.  4.There is some bleeding, not serious.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY\r\n\n",
        "CALL:17B FALL",
        "ADDR:10352 SW EAGLE RD",
        "MAP:26G",
        "X:SW 103RD CT / SW 104TH TER",
        "INFO:Patient Info: 1 patient(s); 52 Years old; Male; Conscious: Yes; Breathing: Yes;  Dispatch Code: 17-B-01G  52 year old, Male, Conscious, Breathing.  Falls.  POSSIBLY DANGEROUS body area  (On the ground or floor).  1.This happened now (less than 6hrs ago).  2.The fall was less than 10ft/3m (less than 1 story).  3.The fall was accidental.  4.There is some bleeding, not serious.  5.He is completely alert (responding appropriately).  6.The injury is to a POSSIBLY");

    doTest("T4",
        "[Incident Notification] EMS (ADDRESS): 1139 N WASHINGTON ST El Dorado (MAP PAGE): 15C (CROSS ST): UNKNOWN / W 10TH AVE (NARR):  50 yom poss chest and back pain  leo out request ems at this location  Call Number 478 was created from Call Number 476(Sep 20 2012  9:03AM)  rp was VERY upset last night when he called it in  had a call last night of raccoon in the area  request officer 10-39 for back up  animal control at this location \r\n\n",
        "CALL:EMS",
        "ADDR:1139 N WASHINGTON ST",
        "CITY:El Dorado",
        "MAP:15C",
        "X:UNKNOWN / W 10TH AVE",
        "INFO:50 yom poss chest and back pain  leo out request ems at this location  Call Number 478 was created from Call Number 476(Sep 20 2012  9:03AM)  rp was VERY upset last night when he called it in  had a call last night of raccoon in the area  request officer 10-39 for back up  animal control at this location");

    doTest("T5",
        "[Incident Notification] 31C FAINTING (ADDRESS): 912 E KELLY AVE Augusta (MAP PAGE): 26E (CROSS ST): N HOOPER ST / N KELLY CT (NARR):  ProQA Medical Dispatch Message Sent; Dispatch Code: 31-C-02  Problem: passed out hit head.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (with cardiac history).  Caller Statement: passed out hit head.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has a history of \r\n\n",
        "CALL:31C FAINTING",
        "ADDR:912 E KELLY AVE",
        "CITY:Augusta",
        "MAP:26E",
        "X:N HOOPER ST / N KELLY CT",
        "INFO:Dispatch Code: 31-C-02  Problem: passed out hit head.  Patient Info: 1 patient(s); 75 Years old; Female; Conscious: Yes; Breathing: Yes;  75 year old, Female, Conscious, Breathing.  Unconscious / Fainting (Near).  Fainting episode(s) and alert => 35 (with cardiac history).  Caller Statement: passed out hit head.  1.Her breathing is completely normal.  2.She is completely alert (responding appropriately).  3.She is not changing color.  4.She has a history of");

    doTest("T6",
        "[Incident Notification] 26A SICK CALL (ADDRESS): 601 N ROSE HILL RD 117B Rose Hill (MAP PAGE): 36G (CROSS ST): W SMITH ST / E BERLIN DR Lakepoint Nursing Center Rose Hill(NARR):  wants tx to st joe  dvt thrombois  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  80 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: tx to st joe.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She does not have any pain.  4.She is not bleeding (or vomiting blood).  5.No priority symptoms (\r\n\n",
        "CALL:26A SICK CALL",
        "ADDR:601 N ROSE HILL RD 117B",
        "CITY:Rose Hill",
        "MAP:36G",
        "X:W SMITH ST / E BERLIN DR Lakepoint Nursing Center Rose Hill",
        "INFO:wants tx to st joe  dvt thrombois  Chief Complaint Number: 26; Dispatch Level: 26A01; Response Text: Alpha  80 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  No priority symptoms (complaint conditions 2-11 not identified).  Caller Statement: tx to st joe.  1.She is completely alert (responding appropriately).  2.She is breathing normally.  3.She does not have any pain.  4.She is not bleeding (or vomiting blood).  5.No priority symptoms (");

    doTest("T7",
        "[Incident Notification] 1A ABDOMINAL PAIN (ADDRESS): 2768 SE 13TH TER County (MAP PAGE): 21A (CROSS ST): SE WALKER RD / SE BLUESTEM RD (NARR):  40 year old, Female, Conscious, Breathing.  Abdominal Pain / Problems.  Abdominal pain.  Caller Statement: abdom.  1.She is completely alert (responding appropriately).  2.There was no mention of existing aortic aneurysm.  3.She has not fainted or nearly fainted.  Problem: abdom.  Patient Info: 1 patient(s); 40 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 01-A-01  abdominal and back pain \r\n\n",
        "CALL:1A ABDOMINAL PAIN",
        "ADDR:2768 SE 13TH TER",
        "MAP:21A",
        "X:SE WALKER RD / SE BLUESTEM RD",
        "INFO:40 year old, Female, Conscious, Breathing.  Abdominal Pain / Problems.  Abdominal pain.  Caller Statement: abdom.  1.She is completely alert (responding appropriately).  2.There was no mention of existing aortic aneurysm.  3.She has not fainted or nearly fainted.  Problem: abdom.  Patient Info: 1 patient(s); 40 Years old; Female; Conscious: Yes; Breathing: Yes;  Dispatch Code: 01-A-01  abdominal and back pain");

    doTest("T8",
        "[Incident Notification] 26C SICK CALL (ADDRESS): 302 E WOODS AVE Andover (MAP PAGE): 25D (CROSS ST): N PORTH AVE / N SHAY RD (NARR):  breathing heavy  comp alert  36 yom con/bre  5.No priority symptoms (ALPHA conditions 2-11 not identified).  ProQA Medical Key Questions have been completed; Dispatch Code: 26-C-02  Patient Info: 1 patient(s); 36 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Dispatch Message Sent; Dispatch Code: 26-C-02  36 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.He is completely alert (responding appropriately).  2.He is not breathing n\r\n\n",
        "CALL:26C SICK CALL",
        "ADDR:302 E WOODS AVE",
        "CITY:Andover",
        "MAP:25D",
        "X:N PORTH AVE / N SHAY RD",
        "INFO:breathing heavy  comp alert  36 yom con/bre  5.No priority symptoms (ALPHA conditions 2-11 not identified).  Dispatch Code: 26-C-02  Patient Info: 1 patient(s); 36 Years old; Male; Conscious: Yes; Breathing: Yes;  Dispatch Code: 26-C-02  36 year old, Male, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.He is completely alert (responding appropriately).  2.He is not breathing n");

    doTest("T9",
        "[Incident Notification] 21B HEMORRHAGE (ADDRESS): 6890 SW HOPKINS SWITCH RD County (MAP PAGE): 27 (CROSS ST): SW 70TH ST / SW 60TH ST (NARR):  51 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  POSSIBLY DANGEROUS hemorrhage.  Caller Statement: bleeding.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a POSSIBLY DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no SERIOUS bleeding.  6.She does not have a bleeding disorder or is taking blood thinners.  Problem: bleeding.  Patient Info: 1 patient(s); 51 Years old; Female; Conscious: \r\n\n",
        "CALL:21B HEMORRHAGE",
        "ADDR:6890 SW HOPKINS SWITCH RD",
        "MAP:27",
        "X:SW 70TH ST / SW 60TH ST",
        "INFO:51 year old, Female, Conscious, Breathing.  Hemorrhage / Lacerations.  POSSIBLY DANGEROUS hemorrhage.  Caller Statement: bleeding.  1.The cause of the bleeding is non-traumatic.  2.The bleeding is from a POSSIBLY DANGEROUS area.  3.She is completely alert (responding appropriately).  4.She is breathing normally.  5.There is no SERIOUS bleeding.  6.She does not have a bleeding disorder or is taking blood thinners.  Problem: bleeding.  Patient Info: 1 patient(s); 51 Years old; Female; Conscious:");

    doTest("T10",
        "[Incident Notification] 26C SICK CALL (ADDRESS): 421 S PAWHUSKA ST County (MAP PAGE): 25I (CROSS ST): SW FAIRFAX ST / E HWY 54 (NARR):  51 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.It's not certain if she is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: arm pain  4.She is not bleeding (or vomiting blood).  -Comments: arm pain-  ProQA Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  Patient Info: 1 patient(s); 51 Years old; Female; Conscious: Yes; Breathing: Yes; \r\n\n",
        "CALL:26C SICK CALL",
        "ADDR:421 S PAWHUSKA ST",
        "MAP:25I",
        "X:SW FAIRFAX ST / E HWY 54",
        "INFO:51 year old, Female, Conscious, Breathing.  Sick Person (Specific Diagnosis).  Abnormal breathing.  1.It's not certain if she is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: arm pain  4.She is not bleeding (or vomiting blood).  -Comments: arm pain-  Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  Patient Info: 1 patient(s); 51 Years old; Female; Conscious: Yes; Breathing: Yes;");

  }
  
  public static void main(String[] args) {
    new KSButlerCountyParserTest().generateTests("T1");
  }
}
