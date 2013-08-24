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
[Incident Notification] 33A ROUTINE TRANSFER (ADDRESS): 720 W CENTRAL AVE El Dorado (MAP PAGE): 22C (CROSS ST): S ATCHISON ST / N TOPEKA ST, S TOPEKA ST SBA(NARR):  Transfer reason: heart problem;  Room # re 278;  Pt Age: 53m;  patient is conscious ;  Detination: ks heart;  Specials: telemetry, o2, heprin lock;  Routine Transfer ; \r\n\n

Contact: Active911
Agency name: Butler County Sheriffs Office
Location: El Doado, KS, United States
Sender: dispatch@bucoks.com

(Incident Notification) 254 111B DAMAGE (ADDRESS): 5317 SW 100TH ST County (CROSS ST): SW COUNTY SHOP RD / SW HIZEY RD (MAP PAGE): 26 (RP): Luke Willhite (RP PHONE NUMBER) 3166171332 (NARR):  rp will be in the shop  rp adv someone cut a hole in the fence and marked the hole with red tape 
(Incident Notification) 251 132B1 TRAFFIC HAZARD LOW (ADDRESS): (CROSS ST): SE HWY 400, SE BEAUMONT RD / SE HWY 400, SE SUMMIT RD (MAP PAGE): 30 (RP): natasha schamblin (RP PHONE NUMBER) MM319 HWY 400(NARR):  west bound  semi all over the road way maroon cab white fluid carrier 
(Incident Notification) 248 122B MISC NON URGENT REQUEST (ADDRESS): 4669 SW BOYER RD County (CROSS ST): SW 50TH ST / SW 40TH ST (MAP PAGE): 22 (RP): Lance Alexander (RP PHONE NUMBER) 3163232789 (NARR):  rp has an alarm on his driveway and wants to know why a deputy drove downhis driveway and then backed out 
(Incident Notification) 209 105A1 ANIMAL LOST STRAY (ADDRESS): SW HWY 254 SW RIVER VALLEY RD County (CROSS ST): (MAP PAGE): 23A (RP): Mary (RP PHONE NUMBER) 8413223 (NARR):  eb  red horse 
(Incident Notification) 205 104D ALARM (ADDRESS): 5576 SE GRAY RD County (CROSS ST): SE 60TH ST / SE 50TH ST (MAP PAGE): 19 (RP): Desiree (RP PHONE NUMBER) 8886424567 (NARR):  Alarms. Caller Statement: alarm.  1.The caller is not on scene.  2.This call is from an alarm monitoring company.  3.This is a holdup/panic/duress alarm.  ProQA Dispatch Message Sent; Chief Complaint Number: 104; Dispatch Level: 104D02; Response Text: Delta 
(Incident Notification) 197 T (ADDRESS): SW 60TH ST SW OHIO STREET RD County (CROSS ST): (MAP PAGE): 23D (RP): (RP PHONE NUMBER) (NARR): 
(Incident Notification) 193 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): 
(Incident Notification) 186 133D TRESPASS (ADDRESS): 1154 SE BLUESTEM RD County (CROSS ST): SE HWY 54 / SE 13TH TER (MAP PAGE): 21A (RP): Allen Potter (RP PHONE NUMBER) 3163217484 (NARR):  was wearing a drk blu sweatshirt, he is on foot, left to the north  subject stated he was chasing a code 3 that had been beating his wife  disregard per the rp.  He is going to inform him about coming around this time of night.  Rp adv. it's a subject named Tyler that he is familiar with.  subject coming up to his back porch.  Trespassing / Unwanted. Caller Statement: trespassing.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident is in progress.  3.This is not a referral call.  4.Weapons were not involved or mentioned.  ProQA Dispatch Message Sent; Chief Complaint Number: 133; Dispatch Level: 133D01; Response Text: Delta 
(Incident Notification) 180 T (ADDRESS): SW HWY 254 SW HWY 196 County (CROSS ST): (MAP PAGE): 22F (RP): (RP PHONE NUMBER) Y(NARR):  just north of 
(Incident Notification) 175 110B BURGLARY PAST (ADDRESS): 12477 SW 130TH ST County (CROSS ST): SW TAWAKONI RD / SW INDIANOLA RD (MAP PAGE): 36 (RP): Kelly Colborn (RP PHONE NUMBER) 3166446145 (NARR):  ProQA Police Questionnaire Completed; Dispatch Code: 110-B-01  Burglary (Break-and-Enter) / Home Invasion.  ProQA Police Dispatch Message Sent; Dispatch Code: 110-B-01  window was broken into  rp got home 45 mins ago and just now noticed that her house was broken into 
(Incident Notification) 173 T (ADDRESS): 18000 SW SANTA FE LAKE RD County (CROSS ST): SW 180TH ST / SW 190TH ST (MAP PAGE): 38 (RP): (RP PHONE NUMBER) (NARR): 
(Incident Notification) 172 129C SUSPICIOUS (ADDRESS): 219 E TOPEKA ST Whitewater (CROSS ST): S OAK ST / S ELM ST (MAP PAGE): 12A (RP): charlotte (RP PHONE NUMBER) 3164352003 (NARR):  wb on topeka  rp was just driving by  was sitting on the curb at the middle school and is now walking toward main street  book bag and trashbag  rp advised there is a man dressed in all blk 
(Incident Notification) 170 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): 
(Incident Notification) 162 119B3 THREAT PAST (ADDRESS): 610 E MILLS DR Towanda (CROSS ST): S PINE RIDGE DR / E WILSON DR (MAP PAGE): 23A (RP): Barbara Williams (RP PHONE NUMBER) 3168718145 (NARR):  susp was arrested in sept for dv with the rp and he has now made threats to harm her via a mutual friend  rp needs to speak to a deputy 
(Incident Notification) 161 1028 (ADDRESS): 8850 NW MEADOWLARK RD County (CROSS ST): NW 90TH ST / NW 87TH TER (MAP PAGE): 12B (RP): (RP PHONE NUMBER) REMINGTON HIGH SCHOOL(NARR): 
(Incident Notification) 153 STALL (ADDRESS): SE HWY 54 SE ELLIS RD County (CROSS ST): (MAP PAGE): 21 (RP): (RP PHONE NUMBER) (NARR):  now out at 54 and sunflower with same vehc  64 will be on scene while driver changes it  correction flat tire  vehc out of gas 
(Incident Notification) 155 131B Non injury accident (ADDRESS): 1957 SE ELLIS RD County (CROSS ST): SE 20TH ST / SE HWY 54 (MAP PAGE): 21 (RP): taylor sontag (RP PHONE NUMBER) 9139042827 (NARR):  wants a call to start  he is at home on se 60th  rp is not at this address  another vehicle left this address where rps car was parked and hit the rps car  yesterday  rp advised at this address on private property 
(Incident Notification) 140 119B1 STALKING PAST (ADDRESS): 220 N WALNUT LN Whitewater (CROSS ST): E 2ND ST / E 1ST ST (MAP PAGE): 12A (RP): lanette gillock (RP PHONE NUMBER) 6206608897 (NARR):  not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer 
(Incident Notification) 154 129C SUSPICIOUS (ADDRESS): NW DIAMOND RD NW 60TH ST County (CROSS ST): (MAP PAGE): 11 (RP): 66 (RP PHONE NUMBER) (NARR):  66 adv east of here looks like a subject with flash lights near some oil rigs 
(Incident Notification) 149 131B Non injury accident (ADDRESS): NW MEADOWLARK RD NW 170TH ST County (CROSS ST): (MAP PAGE): 1 (RP): gene atwood (RP PHONE NUMBER) 3162004073 (NARR):  ProQA Questionnaire Completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  11.Everyone is being cooperative.  12.Alcohol or drugs are not involved.  13.The vehicle description is not known.  14.The exact location of the vehicle(s) is not known.  15.No other property is damaged besides the vehicle(s).  ProQA Key Questions have been completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  2006 chevy impala, white  Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing \n is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  ProQA Dispatch Message Sent; Chief Complaint Number: 131;
(Incident Notification) 153 STALL (ADDRESS): SE HWY 54 SE ELLIS RD County (CROSS ST): (MAP PAGE): 21 (RP): (RP PHONE NUMBER) (NARR): 
(Incident Notification) 152 105D1 ANIMAL ATTACK (ADDRESS): 420 N 9TH ST Towanda (CROSS ST): E HIGHLAND ST / E CLAY HILL RD (MAP PAGE): 23A (RP): (RP PHONE NUMBER) (NARR): 
(Incident Notification) 149 131B Non injury accident (ADDRESS): NW MEADOWLARK RD NW 170TH ST County (CROSS ST): (MAP PAGE): 1 (RP): gene atwood (RP PHONE NUMBER) 3162004073 (NARR):  Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  ProQA Dispatch Message Sent; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  rp doesnt know his phone number, this is what shows up on ani  hit a cow  1.5 mi south of marion/ butler county line 
(Incident Notification) 147 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): 
(Incident Notification) 143 T (ADDRESS): SW 150TH ST SW SANTA FE LAKE RD County (CROSS ST): (MAP PAGE): 35 (RP): (RP PHONE NUMBER) (NARR): 
(Incident Notification) 140 119B1 STALKING PAST (ADDRESS): 220 N WALNUT LN Whitewater (CROSS ST): E 2ND ST / E 1ST ST (MAP PAGE): 12A (RP): lanette gillock (RP PHONE NUMBER) 6206608897 (NARR):  not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer 
(Incident Notification) 135 132B3 TRAFFIC VIOL/ COMPLAINT (ADDRESS): NW HWY 196 NW RIVER VALLEY RD County (CROSS ST): (MAP PAGE): 11 (RP): troy webster (RP PHONE NUMBER) 3166211145 (NARR):  ProQA Questionnaire Completed; Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  rp can no longer see the vehicle  Traffic Violation / Complaint / Hazard.  1.The caller is not on scene.  2.This incident is in progress.  3.This incident involves a TRAFFIC VIOLATION/COMPLAINT.  4.N/A  5.One vehicle is involved.  6.The vehicle description is not known.  7.N/A  8.The location where the vehicle was last seen is not known.  9.It is not known what direction the suspect was going.  10.The driver's description is not known.  11.The caller does not want to make an official complaint.  ProQA Dispatch Message Sent; Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  high rate of speed  passing in no passing zone i  white ford tempo  eb  vehicle driving recklessly 
(Incident Notification) 134 103A1 MESSAGE (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): Aaron Mccallister (RP PHONE NUMBER) SUB(NARR):  has questions about gun laws 
(Incident Notification) 118 122B MISC NON URGENT REQUEST (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): tammy lawson (RP PHONE NUMBER) 3163230532 SUB(NARR):  wants to know what she can do  she needs his help today  she already called the court of the district court and was told to fill out paperwork but she doesnt have time until tomorrow  she needs his help and she doesnt want him to get in trouble  rp has a restraining order against someone 
(Incident Notification) 109 118B FRAUD PAST (ADDRESS): 2515 SE COLE CREEK RD County (CROSS ST): SE 30TH ST / SE 20TH ST (MAP PAGE): 21 (RP): Judy Wilson (RP PHONE NUMBER) 3163239943 (NARR):  needing to make report of fraud  rp adv she has had charges made to both her checking accounts  ProQA Police Questionnaire Completed; Dispatch Code: 118-B-02  Fraud / Deception.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident happened in the past.  3.The suspect/person is not on scene or in the area.  4.This incident involves FRAUD.  ProQA Police Dispatch Message Sent; Dispatch Code: 118-B-02 
(Incident Notification) 107 118B FRAUD PAST (ADDRESS): 8689 NW 120TH ST County (CROSS ST): NW RIVER VALLEY RD / NW HUNTER RD (MAP PAGE): 11 (RP): matthew cutting (RP PHONE NUMBER) 2342059490 (NARR):  he was able to tell the location of the susp because it was done by cell phone  rp is requesting a phone call  ProQA Questionnaire Completed; Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  ProQA Dispatch Message Sent; Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  he advised someone in potwin is hacking into his email and changing his information  rp is in Ohio, his local PD told him to call this agency 
(Incident Notification) 92 130B THEFT PAST (ADDRESS): 9637 SE TETER RD County (CROSS ST): SE HWY 400 / SE 90TH ST (MAP PAGE): 28 (RP): MATT BIRD (RP PHONE NUMBER) 3168076271 (NARR):  WANTING TO REPORT THEFT OF CATTLE PANNELS 

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

    doTest("T11",
        "[Incident Notification] 33A ROUTINE TRANSFER (ADDRESS): 720 W CENTRAL AVE El Dorado (MAP PAGE): 22C (CROSS ST): S ATCHISON ST / N TOPEKA ST, S TOPEKA ST SBA(NARR):  Transfer reason: heart problem;  Room # re 278;  Pt Age: 53m;  patient is conscious ;  Detination: ks heart;  Specials: telemetry, o2, heprin lock;  Routine Transfer ; \r\n\n",
        "CALL:33A ROUTINE TRANSFER",
        "ADDR:720 W CENTRAL AVE",
        "CITY:El Dorado",
        "MAP:22C",
        "X:S ATCHISON ST / N TOPEKA ST, S TOPEKA ST SBA",
        "INFO:Transfer reason: heart problem;  Room # re 278;  Pt Age: 53m;  patient is conscious ;  Detination: ks heart;  Specials: telemetry, o2, heprin lock;  Routine Transfer ;");

   }
  
  @Test
  public void testButlerCountySherifsOffice() {

    doTest("T1",
        "(Incident Notification) 254 111B DAMAGE (ADDRESS): 5317 SW 100TH ST County (CROSS ST): SW COUNTY SHOP RD / SW HIZEY RD (MAP PAGE): 26 (RP): Luke Willhite (RP PHONE NUMBER) 3166171332 (NARR):  rp will be in the shop  rp adv someone cut a hole in the fence and marked the hole with red tape ",
        "CALL:254 111B DAMAGE",
        "ADDR:5317 SW 100TH ST",
        "X:SW COUNTY SHOP RD / SW HIZEY RD",
        "MAP:26",
        "NAME:Luke Willhite",
        "PHONE:3166171332",
        "INFO:rp will be in the shop  rp adv someone cut a hole in the fence and marked the hole with red tape");

    doTest("T2",
        "(Incident Notification) 251 132B1 TRAFFIC HAZARD LOW (ADDRESS): (CROSS ST): SE HWY 400, SE BEAUMONT RD / SE HWY 400, SE SUMMIT RD (MAP PAGE): 30 (RP): natasha schamblin (RP PHONE NUMBER) MM319 HWY 400(NARR):  west bound  semi all over the road way maroon cab white fluid carrier ",
        "CALL:251 132B1 TRAFFIC HAZARD LOW",
        "X:SE HWY 400, SE BEAUMONT RD / SE HWY 400, SE SUMMIT RD",
        "MAP:30",
        "NAME:natasha schamblin",
        "PHONE:MM319 HWY 400",
        "INFO:west bound  semi all over the road way maroon cab white fluid carrier");

    doTest("T3",
        "(Incident Notification) 248 122B MISC NON URGENT REQUEST (ADDRESS): 4669 SW BOYER RD County (CROSS ST): SW 50TH ST / SW 40TH ST (MAP PAGE): 22 (RP): Lance Alexander (RP PHONE NUMBER) 3163232789 (NARR):  rp has an alarm on his driveway and wants to know why a deputy drove downhis driveway and then backed out ",
        "CALL:248 122B MISC NON URGENT REQUEST",
        "ADDR:4669 SW BOYER RD",
        "X:SW 50TH ST / SW 40TH ST",
        "MAP:22",
        "NAME:Lance Alexander",
        "PHONE:3163232789",
        "INFO:rp has an alarm on his driveway and wants to know why a deputy drove downhis driveway and then backed out");

    doTest("T4",
        "(Incident Notification) 209 105A1 ANIMAL LOST STRAY (ADDRESS): SW HWY 254 SW RIVER VALLEY RD County (CROSS ST): (MAP PAGE): 23A (RP): Mary (RP PHONE NUMBER) 8413223 (NARR):  eb  red horse ",
        "CALL:209 105A1 ANIMAL LOST STRAY",
        "ADDR:SW HWY 254 & SW RIVER VALLEY RD",
        "MAP:23A",
        "NAME:Mary",
        "PHONE:8413223",
        "INFO:eb  red horse");

    doTest("T5",
        "(Incident Notification) 205 104D ALARM (ADDRESS): 5576 SE GRAY RD County (CROSS ST): SE 60TH ST / SE 50TH ST (MAP PAGE): 19 (RP): Desiree (RP PHONE NUMBER) 8886424567 (NARR):  Alarms. Caller Statement: alarm.  1.The caller is not on scene.  2.This call is from an alarm monitoring company.  3.This is a holdup/panic/duress alarm.  ProQA Dispatch Message Sent; Chief Complaint Number: 104; Dispatch Level: 104D02; Response Text: Delta ",
        "CALL:205 104D ALARM",
        "ADDR:5576 SE GRAY RD",
        "X:SE 60TH ST / SE 50TH ST",
        "MAP:19",
        "NAME:Desiree",
        "PHONE:8886424567",
        "INFO:Alarms. Caller Statement: alarm.  1.The caller is not on scene.  2.This call is from an alarm monitoring company.  3.This is a holdup/panic/duress alarm.  Chief Complaint Number: 104; Dispatch Level: 104D02; Response Text: Delta");

    doTest("T6",
        "(Incident Notification) 197 T (ADDRESS): SW 60TH ST SW OHIO STREET RD County (CROSS ST): (MAP PAGE): 23D (RP): (RP PHONE NUMBER) (NARR): ",
        "CALL:197 T",
        "ADDR:SW 60TH ST & SW OHIO STREET RD",
        "MAP:23D");

    doTest("T7",
        "(Incident Notification) 193 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): ",
        "CALL:193 1028",
        "ADDR:12991 SW HWY 54",
        "X:SW INDIANOLA RD / SW FIR RD",
        "MAP:25J",
        "PHONE:SUB");

    doTest("T8",
        "(Incident Notification) 186 133D TRESPASS (ADDRESS): 1154 SE BLUESTEM RD County (CROSS ST): SE HWY 54 / SE 13TH TER (MAP PAGE): 21A (RP): Allen Potter (RP PHONE NUMBER) 3163217484 (NARR):  was wearing a drk blu sweatshirt, he is on foot, left to the north  subject stated he was chasing a code 3 that had been beating his wife  disregard per the rp.  He is going to inform him about coming around this time of night.  Rp adv. it's a subject named Tyler that he is familiar with.  subject coming up to his back porch.  Trespassing / Unwanted. Caller Statement: trespassing.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident is in progress.  3.This is not a referral call.  4.Weapons were not involved or mentioned.  ProQA Dispatch Message Sent; Chief Complaint Number: 133; Dispatch Level: 133D01; Response Text: Delta ",
        "CALL:186 133D TRESPASS",
        "ADDR:1154 SE BLUESTEM RD",
        "X:SE HWY 54 / SE 13TH TER",
        "MAP:21A",
        "NAME:Allen Potter",
        "PHONE:3163217484",
        "INFO:was wearing a drk blu sweatshirt, he is on foot, left to the north  subject stated he was chasing a code 3 that had been beating his wife  disregard per the rp.  He is going to inform him about coming around this time of night.  Rp adv. it's a subject named Tyler that he is familiar with.  subject coming up to his back porch.  Trespassing / Unwanted. Caller Statement: trespassing.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident is in progress.  3.This is not a referral call.  4.Weapons were not involved or mentioned.  Chief Complaint Number: 133; Dispatch Level: 133D01; Response Text: Delta");

    doTest("T9",
        "(Incident Notification) 180 T (ADDRESS): SW HWY 254 SW HWY 196 County (CROSS ST): (MAP PAGE): 22F (RP): (RP PHONE NUMBER) Y(NARR):  just north of ",
        "CALL:180 T",
        "ADDR:SW HWY 254 & SW HWY 196",
        "MAP:22F",
        "PHONE:Y",
        "INFO:just north of");

    doTest("T10",
        "(Incident Notification) 175 110B BURGLARY PAST (ADDRESS): 12477 SW 130TH ST County (CROSS ST): SW TAWAKONI RD / SW INDIANOLA RD (MAP PAGE): 36 (RP): Kelly Colborn (RP PHONE NUMBER) 3166446145 (NARR):  ProQA Police Questionnaire Completed; Dispatch Code: 110-B-01  Burglary (Break-and-Enter) / Home Invasion.  ProQA Police Dispatch Message Sent; Dispatch Code: 110-B-01  window was broken into  rp got home 45 mins ago and just now noticed that her house was broken into ",
        "CALL:175 110B BURGLARY PAST",
        "ADDR:12477 SW 130TH ST",
        "X:SW TAWAKONI RD / SW INDIANOLA RD",
        "MAP:36",
        "NAME:Kelly Colborn",
        "PHONE:3166446145",
        "INFO:ProQA Police Questionnaire Completed; Dispatch Code: 110-B-01  Burglary (Break-and-Enter) / Home Invasion.  ProQA Police Dispatch Message Sent; Dispatch Code: 110-B-01  window was broken into  rp got home 45 mins ago and just now noticed that her house was broken into");

    doTest("T11",
        "(Incident Notification) 173 T (ADDRESS): 18000 SW SANTA FE LAKE RD County (CROSS ST): SW 180TH ST / SW 190TH ST (MAP PAGE): 38 (RP): (RP PHONE NUMBER) (NARR): ",
        "CALL:173 T",
        "ADDR:18000 SW SANTA FE LAKE RD",
        "X:SW 180TH ST / SW 190TH ST",
        "MAP:38");

    doTest("T12",
        "(Incident Notification) 172 129C SUSPICIOUS (ADDRESS): 219 E TOPEKA ST Whitewater (CROSS ST): S OAK ST / S ELM ST (MAP PAGE): 12A (RP): charlotte (RP PHONE NUMBER) 3164352003 (NARR):  wb on topeka  rp was just driving by  was sitting on the curb at the middle school and is now walking toward main street  book bag and trashbag  rp advised there is a man dressed in all blk ",
        "CALL:172 129C SUSPICIOUS",
        "ADDR:219 E TOPEKA ST",
        "CITY:Whitewater",
        "X:S OAK ST / S ELM ST",
        "MAP:12A",
        "NAME:charlotte",
        "PHONE:3164352003",
        "INFO:wb on topeka  rp was just driving by  was sitting on the curb at the middle school and is now walking toward main street  book bag and trashbag  rp advised there is a man dressed in all blk");

    doTest("T13",
        "(Incident Notification) 170 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): ",
        "CALL:170 1028",
        "ADDR:12991 SW HWY 54",
        "X:SW INDIANOLA RD / SW FIR RD",
        "MAP:25J",
        "PHONE:SUB");

    doTest("T14",
        "(Incident Notification) 162 119B3 THREAT PAST (ADDRESS): 610 E MILLS DR Towanda (CROSS ST): S PINE RIDGE DR / E WILSON DR (MAP PAGE): 23A (RP): Barbara Williams (RP PHONE NUMBER) 3168718145 (NARR):  susp was arrested in sept for dv with the rp and he has now made threats to harm her via a mutual friend  rp needs to speak to a deputy ",
        "CALL:162 119B3 THREAT PAST",
        "ADDR:610 E MILLS DR",
        "CITY:Towanda",
        "X:S PINE RIDGE DR / E WILSON DR",
        "MAP:23A",
        "NAME:Barbara Williams",
        "PHONE:3168718145",
        "INFO:susp was arrested in sept for dv with the rp and he has now made threats to harm her via a mutual friend  rp needs to speak to a deputy");

    doTest("T15",
        "(Incident Notification) 161 1028 (ADDRESS): 8850 NW MEADOWLARK RD County (CROSS ST): NW 90TH ST / NW 87TH TER (MAP PAGE): 12B (RP): (RP PHONE NUMBER) REMINGTON HIGH SCHOOL(NARR): ",
        "CALL:161 1028",
        "ADDR:8850 NW MEADOWLARK RD",
        "X:NW 90TH ST / NW 87TH TER",
        "MAP:12B",
        "PHONE:REMINGTON HIGH SCHOOL");

    doTest("T16",
        "(Incident Notification) 153 STALL (ADDRESS): SE HWY 54 SE ELLIS RD County (CROSS ST): (MAP PAGE): 21 (RP): (RP PHONE NUMBER) (NARR):  now out at 54 and sunflower with same vehc  64 will be on scene while driver changes it  correction flat tire  vehc out of gas ",
        "CALL:153 STALL",
        "ADDR:SE HWY 54 & SE ELLIS RD",
        "MAP:21",
        "INFO:now out at 54 and sunflower with same vehc  64 will be on scene while driver changes it  correction flat tire  vehc out of gas");

    doTest("T17",
        "(Incident Notification) 155 131B Non injury accident (ADDRESS): 1957 SE ELLIS RD County (CROSS ST): SE 20TH ST / SE HWY 54 (MAP PAGE): 21 (RP): taylor sontag (RP PHONE NUMBER) 9139042827 (NARR):  wants a call to start  he is at home on se 60th  rp is not at this address  another vehicle left this address where rps car was parked and hit the rps car  yesterday  rp advised at this address on private property ",
        "CALL:155 131B Non injury accident",
        "ADDR:1957 SE ELLIS RD",
        "X:SE 20TH ST / SE HWY 54",
        "MAP:21",
        "NAME:taylor sontag",
        "PHONE:9139042827",
        "INFO:wants a call to start  he is at home on se 60th  rp is not at this address  another vehicle left this address where rps car was parked and hit the rps car  yesterday  rp advised at this address on private property");

    doTest("T18",
        "(Incident Notification) 140 119B1 STALKING PAST (ADDRESS): 220 N WALNUT LN Whitewater (CROSS ST): E 2ND ST / E 1ST ST (MAP PAGE): 12A (RP): lanette gillock (RP PHONE NUMBER) 6206608897 (NARR):  not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer ",
        "CALL:140 119B1 STALKING PAST",
        "ADDR:220 N WALNUT LN",
        "CITY:Whitewater",
        "X:E 2ND ST / E 1ST ST",
        "MAP:12A",
        "NAME:lanette gillock",
        "PHONE:6206608897",
        "INFO:not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer");

    doTest("T19",
        "(Incident Notification) 154 129C SUSPICIOUS (ADDRESS): NW DIAMOND RD NW 60TH ST County (CROSS ST): (MAP PAGE): 11 (RP): 66 (RP PHONE NUMBER) (NARR):  66 adv east of here looks like a subject with flash lights near some oil rigs ",
        "CALL:154 129C SUSPICIOUS",
        "ADDR:NW DIAMOND RD & NW 60TH ST",
        "MAP:11",
        "NAME:66",
        "INFO:66 adv east of here looks like a subject with flash lights near some oil rigs");

    doTest("T20",
        "(Incident Notification) 149 131B Non injury accident (ADDRESS): NW MEADOWLARK RD NW 170TH ST County (CROSS ST): (MAP PAGE): 1 (RP): gene atwood (RP PHONE NUMBER) 3162004073 (NARR):  ProQA Questionnaire Completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  11.Everyone is being cooperative.  12.Alcohol or drugs are not involved.  13.The vehicle description is not known.  14.The exact location of the vehicle(s) is not known.  15.No other property is damaged besides the vehicle(s).  ProQA Key Questions have been completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  2006 chevy impala, white  Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing \n" +
        " is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  ProQA Dispatch Message Sent; Chief Complaint Number: 131;",

        "CALL:149 131B Non injury accident",
        "ADDR:NW MEADOWLARK RD & NW 170TH ST",
        "MAP:1",
        "NAME:gene atwood",
        "PHONE:3162004073",
        "INFO:ProQA Questionnaire Completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  11.Everyone is being cooperative.  12.Alcohol or drugs are not involved.  13.The vehicle description is not known.  14.The exact location of the vehicle(s) is not known.  15.No other property is damaged besides the vehicle(s).  ProQA Key Questions have been completed; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  2006 chevy impala, white  Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing \n is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  Chief Complaint Number: 131;");

    doTest("T21",
        "(Incident Notification) 153 STALL (ADDRESS): SE HWY 54 SE ELLIS RD County (CROSS ST): (MAP PAGE): 21 (RP): (RP PHONE NUMBER) (NARR): ",
        "CALL:153 STALL",
        "ADDR:SE HWY 54 & SE ELLIS RD",
        "MAP:21");

    doTest("T22",
        "(Incident Notification) 152 105D1 ANIMAL ATTACK (ADDRESS): 420 N 9TH ST Towanda (CROSS ST): E HIGHLAND ST / E CLAY HILL RD (MAP PAGE): 23A (RP): (RP PHONE NUMBER) (NARR): ",
        "CALL:152 105D1 ANIMAL ATTACK",
        "ADDR:420 N 9TH ST",
        "CITY:Towanda",
        "X:E HIGHLAND ST / E CLAY HILL RD",
        "MAP:23A");

    doTest("T23",
        "(Incident Notification) 149 131B Non injury accident (ADDRESS): NW MEADOWLARK RD NW 170TH ST County (CROSS ST): (MAP PAGE): 1 (RP): gene atwood (RP PHONE NUMBER) 3162004073 (NARR):  Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  ProQA Dispatch Message Sent; Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  rp doesnt know his phone number, this is what shows up on ani  hit a cow  1.5 mi south of marion/ butler county line ",
        "CALL:149 131B Non injury accident",
        "ADDR:NW MEADOWLARK RD & NW 170TH ST",
        "MAP:1",
        "NAME:gene atwood",
        "PHONE:3162004073",
        "INFO:Traffic / Transportation Accident (Crash).  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident just occurred.  3.This incident involves a TRAFFIC ACCIDENT.  4.No one is injured.  5.No one is pinned (trapped) in the vehicle(s).  6.No one was thrown from the vehicle(s).  7.There are no hazardous materials involved.  8.Nothing is blocking or slowing the flow of traffic.  9.One vehicle is involved.  10.All drivers are still on scene.  Chief Complaint Number: 131; Dispatch Level: 131B01; Response Text: Bravo  rp doesnt know his phone number, this is what shows up on ani  hit a cow  1.5 mi south of marion/ butler county line");

    doTest("T24",
        "(Incident Notification) 147 1028 (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): (RP PHONE NUMBER) SUB(NARR): ",
        "CALL:147 1028",
        "ADDR:12991 SW HWY 54",
        "X:SW INDIANOLA RD / SW FIR RD",
        "MAP:25J",
        "PHONE:SUB");

    doTest("T25",
        "(Incident Notification) 143 T (ADDRESS): SW 150TH ST SW SANTA FE LAKE RD County (CROSS ST): (MAP PAGE): 35 (RP): (RP PHONE NUMBER) (NARR): ",
        "CALL:143 T",
        "ADDR:SW 150TH ST & SW SANTA FE LAKE RD",
        "MAP:35");

    doTest("T26",
        "(Incident Notification) 140 119B1 STALKING PAST (ADDRESS): 220 N WALNUT LN Whitewater (CROSS ST): E 2ND ST / E 1ST ST (MAP PAGE): 12A (RP): lanette gillock (RP PHONE NUMBER) 6206608897 (NARR):  not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer ",
        "CALL:140 119B1 STALKING PAST",
        "ADDR:220 N WALNUT LN",
        "CITY:Whitewater",
        "X:E 2ND ST / E 1ST ST",
        "MAP:12A",
        "NAME:lanette gillock",
        "PHONE:6206608897",
        "INFO:not at the address right now  has a blocker on phone for unknown numbers will try to see if she can turn off for officer to call  phone call only  regarding harrassment  wants a phone call from an officer");

    doTest("T27",
        "(Incident Notification) 135 132B3 TRAFFIC VIOL/ COMPLAINT (ADDRESS): NW HWY 196 NW RIVER VALLEY RD County (CROSS ST): (MAP PAGE): 11 (RP): troy webster (RP PHONE NUMBER) 3166211145 (NARR):  ProQA Questionnaire Completed; Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  rp can no longer see the vehicle  Traffic Violation / Complaint / Hazard.  1.The caller is not on scene.  2.This incident is in progress.  3.This incident involves a TRAFFIC VIOLATION/COMPLAINT.  4.N/A  5.One vehicle is involved.  6.The vehicle description is not known.  7.N/A  8.The location where the vehicle was last seen is not known.  9.It is not known what direction the suspect was going.  10.The driver's description is not known.  11.The caller does not want to make an official complaint.  ProQA Dispatch Message Sent; Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  high rate of speed  passing in no passing zone i  white ford tempo  eb  vehicle driving recklessly ",
        "CALL:135 132B3 TRAFFIC VIOL/ COMPLAINT",
        "ADDR:NW HWY 196 & NW RIVER VALLEY RD",
        "MAP:11",
        "NAME:troy webster",
        "PHONE:3166211145",
        "INFO:ProQA Questionnaire Completed; Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  rp can no longer see the vehicle  Traffic Violation / Complaint / Hazard.  1.The caller is not on scene.  2.This incident is in progress.  3.This incident involves a TRAFFIC VIOLATION/COMPLAINT.  4.N/A  5.One vehicle is involved.  6.The vehicle description is not known.  7.N/A  8.The location where the vehicle was last seen is not known.  9.It is not known what direction the suspect was going.  10.The driver's description is not known.  11.The caller does not want to make an official complaint.  Chief Complaint Number: 132; Dispatch Level: 132B03; Response Text: Bravo  high rate of speed  passing in no passing zone i  white ford tempo  eb  vehicle driving recklessly");

    doTest("T28",
        "(Incident Notification) 134 103A1 MESSAGE (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): Aaron Mccallister (RP PHONE NUMBER) SUB(NARR):  has questions about gun laws ",
        "CALL:134 103A1 MESSAGE",
        "ADDR:12991 SW HWY 54",
        "X:SW INDIANOLA RD / SW FIR RD",
        "MAP:25J",
        "NAME:Aaron Mccallister",
        "PHONE:SUB",
        "INFO:has questions about gun laws");

    doTest("T29",
        "(Incident Notification) 118 122B MISC NON URGENT REQUEST (ADDRESS): 12991 SW HWY 54 County (CROSS ST): SW INDIANOLA RD / SW FIR RD (MAP PAGE): 25J (RP): tammy lawson (RP PHONE NUMBER) 3163230532 SUB(NARR):  wants to know what she can do  she needs his help today  she already called the court of the district court and was told to fill out paperwork but she doesnt have time until tomorrow  she needs his help and she doesnt want him to get in trouble  rp has a restraining order against someone ",
        "CALL:118 122B MISC NON URGENT REQUEST",
        "ADDR:12991 SW HWY 54",
        "X:SW INDIANOLA RD / SW FIR RD",
        "MAP:25J",
        "NAME:tammy lawson",
        "PHONE:3163230532 SUB",
        "INFO:wants to know what she can do  she needs his help today  she already called the court of the district court and was told to fill out paperwork but she doesnt have time until tomorrow  she needs his help and she doesnt want him to get in trouble  rp has a restraining order against someone");

    doTest("T30",
        "(Incident Notification) 109 118B FRAUD PAST (ADDRESS): 2515 SE COLE CREEK RD County (CROSS ST): SE 30TH ST / SE 20TH ST (MAP PAGE): 21 (RP): Judy Wilson (RP PHONE NUMBER) 3163239943 (NARR):  needing to make report of fraud  rp adv she has had charges made to both her checking accounts  ProQA Police Questionnaire Completed; Dispatch Code: 118-B-02  Fraud / Deception.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident happened in the past.  3.The suspect/person is not on scene or in the area.  4.This incident involves FRAUD.  ProQA Police Dispatch Message Sent; Dispatch Code: 118-B-02 ",
        "CALL:109 118B FRAUD PAST",
        "ADDR:2515 SE COLE CREEK RD",
        "X:SE 30TH ST / SE 20TH ST",
        "MAP:21",
        "NAME:Judy Wilson",
        "PHONE:3163239943",
        "INFO:needing to make report of fraud  rp adv she has had charges made to both her checking accounts  ProQA Police Questionnaire Completed; Dispatch Code: 118-B-02  Fraud / Deception.  1.The caller is on scene and is the victim/suspect (1st party).  2.This incident happened in the past.  3.The suspect/person is not on scene or in the area.  4.This incident involves FRAUD.  ProQA Police Dispatch Message Sent; Dispatch Code: 118-B-02");

    doTest("T31",
        "(Incident Notification) 107 118B FRAUD PAST (ADDRESS): 8689 NW 120TH ST County (CROSS ST): NW RIVER VALLEY RD / NW HUNTER RD (MAP PAGE): 11 (RP): matthew cutting (RP PHONE NUMBER) 2342059490 (NARR):  he was able to tell the location of the susp because it was done by cell phone  rp is requesting a phone call  ProQA Questionnaire Completed; Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  ProQA Dispatch Message Sent; Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  he advised someone in potwin is hacking into his email and changing his information  rp is in Ohio, his local PD told him to call this agency ",
        "CALL:107 118B FRAUD PAST",
        "ADDR:8689 NW 120TH ST",
        "X:NW RIVER VALLEY RD / NW HUNTER RD",
        "MAP:11",
        "NAME:matthew cutting",
        "PHONE:2342059490",
        "INFO:he was able to tell the location of the susp because it was done by cell phone  rp is requesting a phone call  ProQA Questionnaire Completed; Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  Chief Complaint Number: 118; Dispatch Level: 118B01; Response Text: Bravo  he advised someone in potwin is hacking into his email and changing his information  rp is in Ohio, his local PD told him to call this agency");

    doTest("T32",
        "(Incident Notification) 92 130B THEFT PAST (ADDRESS): 9637 SE TETER RD County (CROSS ST): SE HWY 400 / SE 90TH ST (MAP PAGE): 28 (RP): MATT BIRD (RP PHONE NUMBER) 3168076271 (NARR):  WANTING TO REPORT THEFT OF CATTLE PANNELS ",
        "CALL:92 130B THEFT PAST",
        "ADDR:9637 SE TETER RD",
        "X:SE HWY 400 / SE 90TH ST",
        "MAP:28",
        "NAME:MATT BIRD",
        "PHONE:3168076271",
        "INFO:WANTING TO REPORT THEFT OF CATTLE PANNELS");
 
  }
  
  public static void main(String[] args) {
    new KSButlerCountyParserTest().generateTests("T1");
  }
}
