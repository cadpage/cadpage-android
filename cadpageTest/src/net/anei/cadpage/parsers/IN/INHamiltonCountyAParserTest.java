package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hamilton County, IN
Contact: Mitch Hazelbaker <mitch8123@gmail.com>
Sender: dispatch@hamiltoncounty.in.gov
System: New World

Subject:CADPage\nUnit:T15 Status:Dispatched Location: 108 WINDING WAY  /   Quad: 73 Units: T15  Type: F Fire Residence NOC: Narr:\r
Subject:CADPage\nUnit:C15 Status:Dispatched Location: 16205 E  216TH ST  /   Quad: 15B Units: C15  Type: F ALS NOC: Narr:  You ar\r
Subject:CADPage\nUnit:R15 Status:Dispatched Location: 16205 E  216TH ST  /   Quad: 15B Units: R15 A15 M75 HFG01  Type: F ALS NOC:\r
Subject:CADPage\nUnit:E15 Status:Dispatched Location: E  196TH ST  /   MYSTIC RD Quad: 15C Units: E15 R15 A15 M75 HFG01  Type: Ac\r
Subject:CADPage\nUnit:C15 Status:Dispatched Location: PRAIRIE BAPTIST RD  /   E  SR 32 Quad: 15D Units: C15  Type: Acc PI NOC: Na\r
Subject:CADPage\nUnit:R15 Status:Dispatched Location: 13914 SOUTHEASTERN PKY  /   Quad: 92T Units: L92 L77 E95 R15 BAT9 HFG01  Ty\r
Subject:CADPage\nUnit:R15 Status:Dispatched Location: 15042 E  SR 32 11  /   Quad: 15D Units: R15 A15 M75 HFG01  Type: F ALS NOC:\r

Contact: Active911
Agency name: Fishers Fire Department - ALL
Location: Fishers, IN, United States
Sender: dispatch@hamiltoncounty.in.gov

(CADPage) Unit:BAT9 Status:Dispatched Location: W MAIN ST  /   TOWNE RD Quad: 42G Units: BAT9 E91 R91 L91 M92 TAC92  Type: F Rescue Water NOC: Narr:  CPD would like dive team started, check with fishers  HAS TOWNE RD COMMAND  auth police... DOA  there is someone in the veh  ON SCENE/ONE VEHICLE COMPLETELY SUBMERGED/HAS MAIN ST COMMAND  looks like it has been there for a while  auth police air bags deployed cannot tell if anyone is in the veh  TEAL VEHICLE  TOP OF VEHICLE IS CRUSHED IN, ROOF RIPPED OPEN  SOMEONE INSIDE THE VEHICLE, COMPLETELY UNDERWATER, PERSON NOT MOVING  there is someone inside the veh  ref 5556  UNK IF OCCUPIED  VEH IN POND  CFS:  129
(CADPage) Unit:E95 Status:Dispatched Location: 10933 ASHWOOD DR  /   Quad: 95H Units: E95 M95 ME95  Type: F ALS NOC: DIFF BREATHING Narr:  Nature Of Call: DIFF BREATHING  New ProQA Medical Case Number has been assigned: -1247725  CFS:  139
(CADPage) Unit:E94 Status:Dispatched Location: 9256 WADSWORTH CT  /   Quad: 94A Units: E94 M94 ME94  Type: F ALS NOC: Narr:  Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  5.Her primary problem is fever/chills.  Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  New ProQA Medical Case Number has been assigned: -1247710  CFS:  124
(CADPage) Unit:E91 Status:Dispatched Location: 4 MUNICIPAL DR  /   Quad: 91A Units: E91 M93 ME91  Type: F ALS NOC: Narr:  FEMALE WITH CHEST PAIN  ProQA Medical Questionnaire Aborted - POLICE REQUEST  New ProQA Medical Case Number has been assigned: -1247701  CFS:  115
(CADPage) Unit:M92 Status:Dispatched Location: 13145 CRESSWELL PL  /   Quad: 92T Units: M92  Type: F BLS NOC: Narr:  You are responding to a patient with an unknown problem (man down).  The  patient is a male of unknown age, whose consciousness and breathing  is unknown. Caller's language not understood (no interpreter in center).  Caller Statement: unk.  1.The EMD cannot understand the caller's language (no interpreter in center).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 32; Dispatch Level: 32B04; Response Text: Bravo  Problem: unk.  Patient Info: 1 patient(s); Unknown Range old; Male; Conscious: Unknown; Breathing: Unknown;  New ProQA Medical Case Number has been assigned: -1247621  CFS:  35
(CADPage) Unit:E93 Status:Dispatched Location: 10312 ALLISONVILLE RD  /   Quad: 93A Units: E93 M93 ME93  Type: F ALS NOC: Narr:  Problem: DIF BREATHING.  Patient Info: 1 patient(s); 75 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with breathing problems.  The patient is a  75-year-old male, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: DIF BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Medical Case Number has been assigned: -1247602  CFS:  16
(CADPage) Location: 8355 E  116TH ST  /   Quad: 91B Units:  Type: F Invest NOC: @ mcallisters deli Narr:  Nature Of Call: @ mcallisters deli  electrical outlet throwing sparks, breaker tripped  CFS:  956
(CADPage) Unit:E91 Status:Dispatched Location: 8355 E  116TH ST  /   Quad: 91B Units: E91  Type: F Invest NOC: Narr:  CFS:  956
(CADPage) Unit:E91 Status:Dispatched Location: 12471 SAKSONS BLVD  /   Quad: 91A Units: E91 M93 ME91  Type: F ALS NOC: Narr:  You are responding to a patient with breathing problems.  The patient is a  93-year-old female, who is conscious and breathing. Not alert.  1.She is not completely alert (not responding appropriately).  2.She has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D01; Response Text: Delta  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned: -1247520  CFS:  933
(CADPage) Unit:MA94 Status:Dispatched Location: 12273 STAGE COACH TRL  /   Quad: 94F Units: MA94  Type: F BLS NOC: Narr:  You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  front door unlocked, no pets  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  New ProQA Medical Case Number has been assigned: -1247413  CFS:  826

Contact: Active911
Agency name: Fishers Fire Department - SERIOUS
Location: Fishers, IN, United States

(CADPage) Location: 11099 VILLAGE SQUARE LN  /   Quad: 93C Units:  Type: F Rescue Technical NOC: Narr:  STAGE PAGE VHF AND ALPHA SENT  E93 ON SCENE 1 STORY COMM BUILDING, STRUCTURE DAMAGE TO OUTSIDE BUILDING NO SMOKE NO FIRE, E93 HAS COMMAND FG  Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van  CFS:  807
(CADPage) Unit:E93 Status:Dispatched Location: 11301 VILLAGE SQUARE LN  /   Quad: 93C Units: E93 E91 L91 R91 TAC91 BAT9 H45 1801 M93 HFG01 TAC80  Type: F Rescue Technical NOC: Narr:  Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van  CFS:  807
(CADPage) Unit:E93 Status:Dispatched Location: 7680 E  96TH ST  /   Quad: 93A Units: E93 E94 E95 L91 R91 M94 M95 MA94 ME94 BAT9 HFG01 HFG02  Type: F Fire Commercial NOC: fire in fryer Narr:  Nature Of Call: fire in fryer  CFS:  776
(CADPage) Unit:L92 Status:Dispatched Location: 10350 GLASER WAY  /   Quad: 92A Units: L92 E94 E95 L91 R91 M92 M94 MA92 ML92 BAT9 HFG01 HFG02  Type: F Fire Inst/Multi Family NOC: poss fire Narr:  thinks the fire is behind the wall--possibly an electrical fire--evacuating at this time  Nature Of Call: poss fire  CFS:  650
(CADPage) Unit:E91 Status:Dispatched Location: 11750 COMMERCIAL DR  /   Quad: 91C Units: E91 E95 E94 L91 R91 M95 M94 ME91 MA95 BAT9 HFG01 HFG03  Type: F Fire Commercial NOC: in the back of the building\r\n Narr:  evac in progress  recieved call from alarm company//trash compactor alarm and water flow alarm  out of the baylior in the back room  Nature Of Call: in the back of the building  CFS:  17
(CADPage) Unit:L92 Status:Dispatched Location: 18000 DURBIN RD  /   Quad: 15C Units: E15 E75 T15 LAPEL-T76 L92 R15 A15 M75 HFG02  Type: F Fire Inst/Multi Family NOC: Narr:  EVAC IS COMPLETE  BURNING SMELL IN THE KITCHEN AREA AND ELECTRICITY WENT OUT  CFS:  596
(CADPage) Unit:E95 Status:Dispatched Location: 12948 SINCLAIR PL  /   Quad: 95D Units: E95 E94 E91 L92 R91 M95 M94 ML92 MA95 BAT9 HFG01 HFG02  Type: F Fire Residence NOC: Narr:  everyone is out of house  was advised to yell to get everyone out and stay out  trying to get dogs out  unk if husband is out  on main floor  CFS:  415
(CADPage) Unit:TAC91 Status:Dispatched Location: 10353 LAKESHORE DR E  /   Quad: 43C Units: E45 H45 E43 E41 L41 A45 BAT4 TAC91 TAC80 CFG01  Type: F Rescue Technical NOC: Unconcious Male Narr:  ProQA Medical Key Questions have been completed; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  1.The cardiac arrest was not witnessed.  2.A defibrillator (AED) is not available.  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Male under vehicle // unk if car came down on male  Nature Of Call: Unconcious Male  CFS:  960
(CADPage) Unit:E91 Status:Dispatched Location: 2 MUNICIPAL DR  /   Quad: 91A Units: E91 E93 E94 L91 R91 M93 M94 ME91 MA93 BAT9 HFG01 HFG02  Type: F Fire Commercial NOC: TEST Narr:  looking for page screens  test call only  New ProQA Medical Case Number has been assigned: -1237264  Nature Of Call: TEST  CFS:  666
(CADPage) Unit:E94 Status:Dispatched Location: 10823 KNIGHTSBRIDGE LN  /   Quad: 94D Units: E94 E91 E95 L91 R91 M94 M92 ME94 MA94 BAT9 HFG01 HFG02  Type: F Fire Residence NOC: SMOKE ALARM Narr:  STOVE SMOKING  Nature Of Call: SMOKE ALARM  CFS:  262

Contact: Active911
Agency name: Carmel Fire Department - ALL
Location: Carmel, IN, United States
Sender: dispatch@hamiltoncounty.in.gov

(CADPage) Unit:E46 Status:Dispatched Location: 1284 IRONWOOD DR W  /   Quad: 44F Units: E46 A44  Type: F ALS NOC: Narr:  FEMALE/STROKE  CFS:  67 Coord: 39.991917055 -86.1043384819999 Venue: Carmel Inc #: 2013-00001891
(CADPage) Unit:E44 Status:Dispatched Location: 15960 BRIDGEWATER CLUB BLVD  /   Quad: 83N Units: E44  Type: F Assist NOC: Narr:  CFS:  58 Coord: 40.019020525 -86.102160673 Venue: Carmel Inc #: 2013-00001890
(CADPage) Unit:E43 Status:Dispatched Location: E  96TH ST  /   LAKESHORE DR E Quad: 43C Units: E43 L41 A41 BAT4 CFG01  Type: Acc PI NOC: 10-50 UNKNOWN Narr:  Call Number 1000 was created from Call Number 987(May  8 2013  5:49PM)  medics for two females comp of arm pain  Nature Of Call: 10-50 UNKNOWN  2 VEH//WB HONDA ACCORD AND UNSURE OF OTHER VEH  CFS:  1000 Coord: 39.926893724 -86.1034859 Venue: Indianapolis Inc #: 2013-00001889
(CADPage) Unit:L41 Status:Dispatched Location: 1919 TROWBRIDGE HIGH ST  /   Quad: 46G Units: L41 A45  Type: F ALS NOC: fall Narr:  Nature Of Call: fall  CFS:  980 Coord: 39.975969214 -86.194399563 Venue: Carmel Inc #: 2013-00001888
(CADPage) Location: 12863 OLD MERIDIAN ST  /   Quad: 41A Units:  Type: F ALS NOC: unconscious Narr:  front door, will have someone lead FD in  VFW  65yom, now conscious,  New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious  CFS:  971 Coord: 39.9747543820001 -86.146917827 Venue: Carmel Inc #: 2013-00001887
(CADPage) Unit:E46 Status:Dispatched Location: 12863 OLD MERIDIAN ST  /   Quad: 41A Units: E46 A46  Type: F ALS NOC: unconscious Narr:  New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious  CFS:  971 Coord: 39.9747543820001 -86.146917827 Venue: Carmel Inc #: 2013-00001887
(CADPage) Unit:E45 Status:Dispatched Location: 11610 TECHNOLOGY DR  /   Quad: 45B Units: E45 A41  Type: F ALS NOC: fall Narr:  Nature Of Call: fall  CFS:  871 Coord: 39.9574094490001 -86.148113399 Venue: Carmel Inc #: 2013-00001886
(CADPage) Unit:E45 Status:Dispatched Location: 11184 RUCKLE ST  /   Quad: 45B Units: E45  Type: F Assist NOC: Narr:  Call Number 815 was created from Call Number 811(May  8 2013 12:48PM)  asst cfd  screaming in house  uncontained toddlers  16 month twins locked in res  CFS:  815 Coord: 39.9514024330001 -86.150504527 Venue: Carmel Inc #: 2013-00001885
(CADPage) Location: 11335 N  MICHIGAN RD  /   Quad: 42E Units:  Type: F Fire Misc/Unknown NOC: Narr:  auth boone county / e91,l91 both marked back in service  e42 on scene of altums with fire large burn pile, will be investigating with cmd on fg2  boone county clear for apparatus  boone co disp contacted/ they have not received calls/ not responding to the area  10-17 is a passerby/ heavy black smoke  east of/ heavy smoke showing/ behind huntington bank/ between 106th and 116th  CFS:  619 Coord: 39.948726541 -86.23938201 Venue: Zionsville Inc #: 2013-00001880
(CADPage) Location: 118 MEDICAL DR 317b  /   Quad: 41C Units:  Type: F ALS NOC: unresp female Narr:  enter in main doors  breathing normal, high pulse, is diab, history of seiz  57yr old female, not awake, breathing  Nature Of Call: unresp female  CFS:  660 Coord: 39.9585212472877 -86.1259618342936 Venue: Carmel Inc #: 2013-00001884

*/

public class INHamiltonCountyAParserTest extends BaseParserTest {
  
  public INHamiltonCountyAParserTest() {
    setParser(new INHamiltonCountyAParser(), "HAMILTON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:CADPage\nUnit:T15 Status:Dispatched Location: 108 WINDING WAY  /   Quad: 73 Units: T15  Type: F Fire Residence NOC: Narr:\r",
        "ADDR:108 WINDING WAY",
        "MAP:73",
        "UNIT:T15",
        "CALL:F Fire Residence NOC:");

    doTest("T2",
        "Subject:CADPage\nUnit:C15 Status:Dispatched Location: 16205 E  216TH ST  /   Quad: 15B Units: C15  Type: F ALS NOC: Narr:  You ar\r",
        "ADDR:16205 E 216TH ST",
        "MAP:15B",
        "UNIT:C15",
        "CALL:F ALS NOC:",
        "INFO:You ar");

    doTest("T3",
        "Subject:CADPage\nUnit:R15 Status:Dispatched Location: 16205 E  216TH ST  /   Quad: 15B Units: R15 A15 M75 HFG01  Type: F ALS NOC:\r",
        "ADDR:16205 E 216TH ST",
        "MAP:15B",
        "UNIT:R15 A15 M75 HFG01",
        "CALL:F ALS NOC:");

    doTest("T4",
        "Subject:CADPage\nUnit:E15 Status:Dispatched Location: E  196TH ST  /   MYSTIC RD Quad: 15C Units: E15 R15 A15 M75 HFG01  Type: Ac\r",
        "ADDR:E 196TH ST & MYSTIC RD",  // Not mapping
        "MAP:15C",
        "UNIT:E15 R15 A15 M75 HFG01",
        "CALL:Ac");

    doTest("T5",
        "Subject:CADPage\nUnit:C15 Status:Dispatched Location: PRAIRIE BAPTIST RD  /   E  SR 32 Quad: 15D Units: C15  Type: Acc PI NOC: Na\r",
        "ADDR:PRAIRIE BAPTIST RD & E SR 32",
        "MADDR:PRAIRIE BAPTIST RD & E ST 32",
        "MAP:15D",
        "UNIT:C15",
        "CALL:Acc PI NOC:");

    doTest("T6",
        "Subject:CADPage\nUnit:R15 Status:Dispatched Location: 13914 SOUTHEASTERN PKY  /   Quad: 92T Units: L92 L77 E95 R15 BAT9 HFG01  Ty\r",
        "ADDR:13914 SOUTHEASTERN PKY",
        "MADDR:13914 SOUTHEASTERN PKWY",
        "MAP:92T",
        "UNIT:L92 L77 E95 R15 BAT9 HFG01",
        "CALL:ALERT");

    doTest("T7",
        "Subject:CADPage\nUnit:R15 Status:Dispatched Location: 15042 E  SR 32 11  /   Quad: 15D Units: R15 A15 M75 HFG01  Type: F ALS NOC:\r",
        "ADDR:15042 E SR 32",
        "APT:11",
        "MADDR:15042 E IN 32",
        "MAP:15D",
        "UNIT:R15 A15 M75 HFG01",
        "CALL:F ALS NOC:");

  }
  
  @Test
  public void testFischerFire() {

    doTest("T1",
        "(CADPage) Unit:BAT9 Status:Dispatched Location: W MAIN ST  /   TOWNE RD Quad: 42G Units: BAT9 E91 R91 L91 M92 TAC92  Type: F Rescue Water NOC: Narr:  CPD would like dive team started, check with fishers  HAS TOWNE RD COMMAND  auth police... DOA  there is someone in the veh  ON SCENE/ONE VEHICLE COMPLETELY SUBMERGED/HAS MAIN ST COMMAND  looks like it has been there for a while  auth police air bags deployed cannot tell if anyone is in the veh  TEAL VEHICLE  TOP OF VEHICLE IS CRUSHED IN, ROOF RIPPED OPEN  SOMEONE INSIDE THE VEHICLE, COMPLETELY UNDERWATER, PERSON NOT MOVING  there is someone inside the veh  ref 5556  UNK IF OCCUPIED  VEH IN POND  CFS:  129",
        "ADDR:W MAIN ST & TOWNE RD",  // Not mapping
        "MAP:42G",
        "UNIT:BAT9 E91 R91 L91 M92 TAC92",
        "CALL:F Rescue Water NOC:",
        "INFO:CPD would like dive team started, check with fishers  HAS TOWNE RD COMMAND  auth police... DOA  there is someone in the veh  ON SCENE/ONE VEHICLE COMPLETELY SUBMERGED/HAS MAIN ST COMMAND  looks like it has been there for a while  auth police air bags deployed cannot tell if anyone is in the veh  TEAL VEHICLE  TOP OF VEHICLE IS CRUSHED IN, ROOF RIPPED OPEN  SOMEONE INSIDE THE VEHICLE, COMPLETELY UNDERWATER, PERSON NOT MOVING  there is someone inside the veh  ref 5556  UNK IF OCCUPIED  VEH IN POND",
        "ID:129");

    doTest("T2",
        "(CADPage) Unit:E95 Status:Dispatched Location: 10933 ASHWOOD DR  /   Quad: 95H Units: E95 M95 ME95  Type: F ALS NOC: DIFF BREATHING Narr:  Nature Of Call: DIFF BREATHING  New ProQA Medical Case Number has been assigned: -1247725  CFS:  139",
        "ADDR:10933 ASHWOOD DR",
        "MAP:95H",
        "UNIT:E95 M95 ME95",
        "CALL:F ALS NOC: DIFF BREATHING",
        "INFO:Nature Of Call: DIFF BREATHING  New ProQA Medical Case Number has been assigned: -1247725",
        "ID:139");

    doTest("T3",
        "(CADPage) Unit:E94 Status:Dispatched Location: 9256 WADSWORTH CT  /   Quad: 94A Units: E94 M94 ME94  Type: F ALS NOC: Narr:  Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  5.Her primary problem is fever/chills.  Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  New ProQA Medical Case Number has been assigned: -1247710  CFS:  124",
        "ADDR:9256 WADSWORTH CT",
        "MAP:94A",
        "UNIT:E94 M94 ME94",
        "CALL:F ALS NOC:",
        "INFO:Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  ProQA Medical Key Questions have been completed; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  5.Her primary problem is fever/chills.  Problem: NOT FEELING WELL.  Patient Info: 1 patient(s); 62 Years old; Female; Conscious: Yes; Breathing: Yes;  You are responding to a patient who is sick (or has a current medical condition).  The patient is a 62-year-old female, who is conscious and breathing.  Abnormal breathing.  Sick Person (Specific Diagnosis).  Caller Statement: NOT FEELING WELL.  1.She is completely alert (responding appropriately).  2.She is not breathing normally.  3.She has other pain: PANCREAS PAIN  4.She is not bleeding (or vomiting blood).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 26; Dispatch Level: 26C02; Response Text: Charlie  New ProQA Medical Case Number has been assigned: -1247710",
        "ID:124");

    doTest("T4",
        "(CADPage) Unit:E91 Status:Dispatched Location: 4 MUNICIPAL DR  /   Quad: 91A Units: E91 M93 ME91  Type: F ALS NOC: Narr:  FEMALE WITH CHEST PAIN  ProQA Medical Questionnaire Aborted - POLICE REQUEST  New ProQA Medical Case Number has been assigned: -1247701  CFS:  115",
        "ADDR:4 MUNICIPAL DR",
        "MAP:91A",
        "UNIT:E91 M93 ME91",
        "CALL:F ALS NOC:",
        "INFO:FEMALE WITH CHEST PAIN  ProQA Medical Questionnaire Aborted - POLICE REQUEST  New ProQA Medical Case Number has been assigned: -1247701",
        "ID:115");

    doTest("T5",
        "(CADPage) Unit:M92 Status:Dispatched Location: 13145 CRESSWELL PL  /   Quad: 92T Units: M92  Type: F BLS NOC: Narr:  You are responding to a patient with an unknown problem (man down).  The  patient is a male of unknown age, whose consciousness and breathing  is unknown. Caller's language not understood (no interpreter in center).  Caller Statement: unk.  1.The EMD cannot understand the caller's language (no interpreter in center).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 32; Dispatch Level: 32B04; Response Text: Bravo  Problem: unk.  Patient Info: 1 patient(s); Unknown Range old; Male; Conscious: Unknown; Breathing: Unknown;  New ProQA Medical Case Number has been assigned: -1247621  CFS:  35",
        "ADDR:13145 CRESSWELL PL",
        "MAP:92T",
        "UNIT:M92",
        "CALL:F BLS NOC:",
        "INFO:You are responding to a patient with an unknown problem (man down).  The  patient is a male of unknown age, whose consciousness and breathing  is unknown. Caller's language not understood (no interpreter in center).  Caller Statement: unk.  1.The EMD cannot understand the caller's language (no interpreter in center).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 32; Dispatch Level: 32B04; Response Text: Bravo  Problem: unk.  Patient Info: 1 patient(s); Unknown Range old; Male; Conscious: Unknown; Breathing: Unknown;  New ProQA Medical Case Number has been assigned: -1247621",
        "ID:35");

    doTest("T6",
        "(CADPage) Unit:E93 Status:Dispatched Location: 10312 ALLISONVILLE RD  /   Quad: 93A Units: E93 M93 ME93  Type: F ALS NOC: Narr:  Problem: DIF BREATHING.  Patient Info: 1 patient(s); 75 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with breathing problems.  The patient is a  75-year-old male, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: DIF BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Medical Case Number has been assigned: -1247602  CFS:  16",
        "ADDR:10312 ALLISONVILLE RD",
        "MAP:93A",
        "UNIT:E93 M93 ME93",
        "CALL:F ALS NOC:",
        "INFO:Problem: DIF BREATHING.  Patient Info: 1 patient(s); 75 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient with breathing problems.  The patient is a  75-year-old male, who is conscious and breathing. DIFFICULTY  SPEAKING BETWEEN BREATHS.  Caller Statement: DIF BREATHING.  1.He is completely alert (responding appropriately).  2.He has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D02; Response Text: Delta  New ProQA Medical Case Number has been assigned: -1247602",
        "ID:16");

    doTest("T7",
        "(CADPage) Location: 8355 E  116TH ST  /   Quad: 91B Units:  Type: F Invest NOC: @ mcallisters deli Narr:  Nature Of Call: @ mcallisters deli  electrical outlet throwing sparks, breaker tripped  CFS:  956",
        "ADDR:8355 E 116TH ST",
        "MAP:91B",
        "CALL:F Invest NOC: @ mcallisters deli",
        "INFO:Nature Of Call: @ mcallisters deli  electrical outlet throwing sparks, breaker tripped",
        "ID:956");

    doTest("T8",
        "(CADPage) Unit:E91 Status:Dispatched Location: 8355 E  116TH ST  /   Quad: 91B Units: E91  Type: F Invest NOC: Narr:  CFS:  956",
        "ADDR:8355 E 116TH ST",
        "MAP:91B",
        "UNIT:E91",
        "CALL:F Invest NOC:",
        "ID:956");

    doTest("T9",
        "(CADPage) Unit:E91 Status:Dispatched Location: 12471 SAKSONS BLVD  /   Quad: 91A Units: E91 M93 ME91  Type: F ALS NOC: Narr:  You are responding to a patient with breathing problems.  The patient is a  93-year-old female, who is conscious and breathing. Not alert.  1.She is not completely alert (not responding appropriately).  2.She has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D01; Response Text: Delta  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned: -1247520  CFS:  933",
        "ADDR:12471 SAKSONS BLVD",
        "MAP:91A",
        "UNIT:E91 M93 ME91",
        "CALL:F ALS NOC:",
        "INFO:You are responding to a patient with breathing problems.  The patient is a  93-year-old female, who is conscious and breathing. Not alert.  1.She is not completely alert (not responding appropriately).  2.She has difficulty speaking between breaths.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 6; Dispatch Level: 06D01; Response Text: Delta  Patient Info: 1 patient(s); 93 Years old; Female; Conscious: Yes; Breathing: Yes;  New ProQA Medical Case Number has been assigned: -1247520",
        "ID:933");

    doTest("T10",
        "(CADPage) Unit:MA94 Status:Dispatched Location: 12273 STAGE COACH TRL  /   Quad: 94F Units: MA94  Type: F BLS NOC: Narr:  You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  front door unlocked, no pets  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  New ProQA Medical Case Number has been assigned: -1247413  CFS:  826",
        "ADDR:12273 STAGE COACH TRL",
        "MAP:94F",
        "UNIT:MA94",
        "CALL:F BLS NOC:",
        "INFO:You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  ProQA Medical Questionnaire Completed; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  front door unlocked, no pets  Problem: fall.  Patient Info: 1 patient(s); 71 Years old; Male; Conscious: Yes; Breathing: Yes;  You are responding to a patient involved in a fall.  The patient is a 71-year-old  male, who is conscious and breathing. PUBLIC ASSIST (no injuries and no  priority symptoms)  (On the ground or floor).  Falls.  Caller Statement: fall.  1.This happened now (less than 6hrs ago).  2.It's reported that he fell at ground level.  3.The fall was accidental.  4.There is no bleeding now.  5.He is completely alert (responding appropriately).  6.He has no injuries.  7.He is still on the floor (ground).  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 17; Dispatch Level: 17A03; Dispatch Level Suffix: G; Response Text: Alpha  New ProQA Medical Case Number has been assigned: -1247413",
        "ID:826");

  }
  
  @Test
  public void testFischerFire2() {

    doTest("T1",
        "(CADPage) Location: 11099 VILLAGE SQUARE LN  /   Quad: 93C Units:  Type: F Rescue Technical NOC: Narr:  STAGE PAGE VHF AND ALPHA SENT  E93 ON SCENE 1 STORY COMM BUILDING, STRUCTURE DAMAGE TO OUTSIDE BUILDING NO SMOKE NO FIRE, E93 HAS COMMAND FG  Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van  CFS:  807",
        "ADDR:11099 VILLAGE SQUARE LN",
        "MAP:93C",
        "CALL:F Rescue Technical NOC:",
        "INFO:STAGE PAGE VHF AND ALPHA SENT  E93 ON SCENE 1 STORY COMM BUILDING, STRUCTURE DAMAGE TO OUTSIDE BUILDING NO SMOKE NO FIRE, E93 HAS COMMAND FG  Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van",
        "ID:807");

    doTest("T2",
        "(CADPage) Unit:E93 Status:Dispatched Location: 11301 VILLAGE SQUARE LN  /   Quad: 93C Units: E93 E91 L91 R91 TAC91 BAT9 H45 1801 M93 HFG01 TAC80  Type: F Rescue Technical NOC: Narr:  Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van  CFS:  807",
        "ADDR:11301 VILLAGE SQUARE LN",
        "MAP:93C",
        "UNIT:E93 E91 L91 R91 TAC91 BAT9 H45 1801 M93 HFG01 TAC80",
        "CALL:F Rescue Technical NOC:",
        "INFO:Call Number 807 was created from Call Number 804(Nov 23 2012  3:03PM)  adv he has backed back out of the building  he hit the building, adv the building does have structural  damage-language barrier  white work van",
        "ID:807");

    doTest("T3",
        "(CADPage) Unit:E93 Status:Dispatched Location: 7680 E  96TH ST  /   Quad: 93A Units: E93 E94 E95 L91 R91 M94 M95 MA94 ME94 BAT9 HFG01 HFG02  Type: F Fire Commercial NOC: fire in fryer Narr:  Nature Of Call: fire in fryer  CFS:  776",
        "ADDR:7680 E 96TH ST",
        "MAP:93A",
        "UNIT:E93 E94 E95 L91 R91 M94 M95 MA94 ME94 BAT9 HFG01 HFG02",
        "CALL:F Fire Commercial NOC: fire in fryer",
        "INFO:Nature Of Call: fire in fryer",
        "ID:776");

    doTest("T4",
        "(CADPage) Unit:L92 Status:Dispatched Location: 10350 GLASER WAY  /   Quad: 92A Units: L92 E94 E95 L91 R91 M92 M94 MA92 ML92 BAT9 HFG01 HFG02  Type: F Fire Inst/Multi Family NOC: poss fire Narr:  thinks the fire is behind the wall--possibly an electrical fire--evacuating at this time  Nature Of Call: poss fire  CFS:  650",
        "ADDR:10350 GLASER WAY",
        "MAP:92A",
        "UNIT:L92 E94 E95 L91 R91 M92 M94 MA92 ML92 BAT9 HFG01 HFG02",
        "CALL:F Fire Inst/Multi Family NOC: poss fire",
        "INFO:thinks the fire is behind the wall--possibly an electrical fire--evacuating at this time  Nature Of Call: poss fire",
        "ID:650");

    doTest("T5",
        "(CADPage) Unit:E91 Status:Dispatched Location: 11750 COMMERCIAL DR  /   Quad: 91C Units: E91 E95 E94 L91 R91 M95 M94 ME91 MA95 BAT9 HFG01 HFG03  Type: F Fire Commercial NOC: in the back of the building\r\n" +
        " Narr:  evac in progress  recieved call from alarm company//trash compactor alarm and water flow alarm  out of the baylior in the back room  Nature Of Call: in the back of the building  CFS:  17",

        "ADDR:11750 COMMERCIAL DR",
        "MAP:91C",
        "UNIT:E91 E95 E94 L91 R91 M95 M94 ME91 MA95 BAT9 HFG01 HFG03",
        "CALL:F Fire Commercial NOC: in the back of the building",
        "INFO:evac in progress  recieved call from alarm company//trash compactor alarm and water flow alarm  out of the baylior in the back room  Nature Of Call: in the back of the building",
        "ID:17");

    doTest("T6",
        "(CADPage) Unit:L92 Status:Dispatched Location: 18000 DURBIN RD  /   Quad: 15C Units: E15 E75 T15 LAPEL-T76 L92 R15 A15 M75 HFG02  Type: F Fire Inst/Multi Family NOC: Narr:  EVAC IS COMPLETE  BURNING SMELL IN THE KITCHEN AREA AND ELECTRICITY WENT OUT  CFS:  596",
        "ADDR:18000 DURBIN RD",
        "MAP:15C",
        "UNIT:E15 E75 T15 LAPEL-T76 L92 R15 A15 M75 HFG02",
        "CALL:F Fire Inst/Multi Family NOC:",
        "INFO:EVAC IS COMPLETE  BURNING SMELL IN THE KITCHEN AREA AND ELECTRICITY WENT OUT",
        "ID:596");

    doTest("T7",
        "(CADPage) Unit:E95 Status:Dispatched Location: 12948 SINCLAIR PL  /   Quad: 95D Units: E95 E94 E91 L92 R91 M95 M94 ML92 MA95 BAT9 HFG01 HFG02  Type: F Fire Residence NOC: Narr:  everyone is out of house  was advised to yell to get everyone out and stay out  trying to get dogs out  unk if husband is out  on main floor  CFS:  415",
        "ADDR:12948 SINCLAIR PL",
        "MAP:95D",
        "UNIT:E95 E94 E91 L92 R91 M95 M94 ML92 MA95 BAT9 HFG01 HFG02",
        "CALL:F Fire Residence NOC:",
        "INFO:everyone is out of house  was advised to yell to get everyone out and stay out  trying to get dogs out  unk if husband is out  on main floor",
        "ID:415");

    doTest("T8",
        "(CADPage) Unit:TAC91 Status:Dispatched Location: 10353 LAKESHORE DR E  /   Quad: 43C Units: E45 H45 E43 E41 L41 A45 BAT4 TAC91 TAC80 CFG01  Type: F Rescue Technical NOC: Unconcious Male Narr:  ProQA Medical Key Questions have been completed; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  1.The cardiac arrest was not witnessed.  2.A defibrillator (AED) is not available.  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Male under vehicle // unk if car came down on male  Nature Of Call: Unconcious Male  CFS:  960",
        "ADDR:10353 LAKESHORE DR E",
        "MAP:43C",
        "UNIT:E45 H45 E43 E41 L41 A45 BAT4 TAC91 TAC80 CFG01",
        "CALL:F Rescue Technical NOC: Unconcious Male",
        "INFO:ProQA Medical Key Questions have been completed; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  1.The cardiac arrest was not witnessed.  2.A defibrillator (AED) is not available.  Problem: UNFCONSCIOUS MALE.  Patient Info: 1 patient(s); 51 Years old; Male; Conscious: No; Breathing: No;  You are responding to a patient in apparent cardiac (respiratory) arrest.  The  patient is a 51-year-old male, who is unconscious and not breathing.  Not breathing at all.  Cardiac or Respiratory Arrest / Death.  Caller Statement: UNFCONSCIOUS MALE.  ProQA Medical Dispatch Message Sent; Chief Complaint Number: 9; Dispatch Level: 09E01; Response Text: Echo  Male under vehicle // unk if car came down on male  Nature Of Call: Unconcious Male",
        "ID:960");

    doTest("T9",
        "(CADPage) Unit:E91 Status:Dispatched Location: 2 MUNICIPAL DR  /   Quad: 91A Units: E91 E93 E94 L91 R91 M93 M94 ME91 MA93 BAT9 HFG01 HFG02  Type: F Fire Commercial NOC: TEST Narr:  looking for page screens  test call only  New ProQA Medical Case Number has been assigned: -1237264  Nature Of Call: TEST  CFS:  666",
        "ADDR:2 MUNICIPAL DR",
        "MAP:91A",
        "UNIT:E91 E93 E94 L91 R91 M93 M94 ME91 MA93 BAT9 HFG01 HFG02",
        "CALL:F Fire Commercial NOC: TEST",
        "INFO:looking for page screens  test call only  New ProQA Medical Case Number has been assigned: -1237264  Nature Of Call: TEST",
        "ID:666");

    doTest("T10",
        "(CADPage) Unit:E94 Status:Dispatched Location: 10823 KNIGHTSBRIDGE LN  /   Quad: 94D Units: E94 E91 E95 L91 R91 M94 M92 ME94 MA94 BAT9 HFG01 HFG02  Type: F Fire Residence NOC: SMOKE ALARM Narr:  STOVE SMOKING  Nature Of Call: SMOKE ALARM  CFS:  262",
        "ADDR:10823 KNIGHTSBRIDGE LN",
        "MAP:94D",
        "UNIT:E94 E91 E95 L91 R91 M94 M92 ME94 MA94 BAT9 HFG01 HFG02",
        "CALL:F Fire Residence NOC: SMOKE ALARM",
        "INFO:STOVE SMOKING  Nature Of Call: SMOKE ALARM",
        "ID:262");

  }
  
  @Test
  public void testCarmelFire() {


    doTest("T1",
        "(CADPage) Unit:E46 Status:Dispatched Location: 1284 IRONWOOD DR W  /   Quad: 44F Units: E46 A44  Type: F ALS NOC: Narr:  FEMALE/STROKE  CFS:  67 Coord: 39.991917055 -86.1043384819999 Venue: Carmel Inc #: 2013-00001891",
        "ADDR:1284 IRONWOOD DR W",
        "CITY:Carmel",
        "MAP:44F",
        "UNIT:E46 A44",
        "CALL:F ALS NOC:",
        "INFO:FEMALE/STROKE",
        "ID:2013-00001891",
        "GPS:+39.991917,-86.104338");

    doTest("T2",
        "(CADPage) Unit:E44 Status:Dispatched Location: 15960 BRIDGEWATER CLUB BLVD  /   Quad: 83N Units: E44  Type: F Assist NOC: Narr:  CFS:  58 Coord: 40.019020525 -86.102160673 Venue: Carmel Inc #: 2013-00001890",
        "ADDR:15960 BRIDGEWATER CLUB BLVD",
        "CITY:Carmel",
        "MAP:83N",
        "UNIT:E44",
        "CALL:F Assist NOC:",
        "ID:2013-00001890",
        "GPS:+40.019021,-86.102161");

    doTest("T3",
        "(CADPage) Unit:E43 Status:Dispatched Location: E  96TH ST  /   LAKESHORE DR E Quad: 43C Units: E43 L41 A41 BAT4 CFG01  Type: Acc PI NOC: 10-50 UNKNOWN Narr:  Call Number 1000 was created from Call Number 987(May  8 2013  5:49PM)  medics for two females comp of arm pain  Nature Of Call: 10-50 UNKNOWN  2 VEH//WB HONDA ACCORD AND UNSURE OF OTHER VEH  CFS:  1000 Coord: 39.926893724 -86.1034859 Venue: Indianapolis Inc #: 2013-00001889",
        "ADDR:E 96TH ST & LAKESHORE DR E",
        "CITY:Indianapolis",
        "MAP:43C",
        "UNIT:E43 L41 A41 BAT4 CFG01",
        "CALL:Acc PI NOC: 10-50 UNKNOWN",
        "INFO:Call Number 1000 was created from Call Number 987(May  8 2013  5:49PM)  medics for two females comp of arm pain  Nature Of Call: 10-50 UNKNOWN  2 VEH//WB HONDA ACCORD AND UNSURE OF OTHER VEH",
        "ID:2013-00001889",
        "GPS:+39.926894,-86.103486");

    doTest("T4",
        "(CADPage) Unit:L41 Status:Dispatched Location: 1919 TROWBRIDGE HIGH ST  /   Quad: 46G Units: L41 A45  Type: F ALS NOC: fall Narr:  Nature Of Call: fall  CFS:  980 Coord: 39.975969214 -86.194399563 Venue: Carmel Inc #: 2013-00001888",
        "ADDR:1919 TROWBRIDGE HIGH ST",
        "CITY:Carmel",
        "MAP:46G",
        "UNIT:L41 A45",
        "CALL:F ALS NOC: fall",
        "INFO:Nature Of Call: fall",
        "ID:2013-00001888",
        "GPS:+39.975969,-86.194400");

    doTest("T5",
        "(CADPage) Location: 12863 OLD MERIDIAN ST  /   Quad: 41A Units:  Type: F ALS NOC: unconscious Narr:  front door, will have someone lead FD in  VFW  65yom, now conscious,  New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious  CFS:  971 Coord: 39.9747543820001 -86.146917827 Venue: Carmel Inc #: 2013-00001887",
        "ADDR:12863 OLD MERIDIAN ST",
        "CITY:Carmel",
        "MAP:41A",
        "CALL:F ALS NOC: unconscious",
        "INFO:front door, will have someone lead FD in  VFW  65yom, now conscious,  New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious",
        "ID:2013-00001887",
        "GPS:+39.974754,-86.146918");

    doTest("T6",
        "(CADPage) Unit:E46 Status:Dispatched Location: 12863 OLD MERIDIAN ST  /   Quad: 41A Units: E46 A46  Type: F ALS NOC: unconscious Narr:  New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious  CFS:  971 Coord: 39.9747543820001 -86.146917827 Venue: Carmel Inc #: 2013-00001887",
        "ADDR:12863 OLD MERIDIAN ST",
        "CITY:Carmel",
        "MAP:41A",
        "UNIT:E46 A46",
        "CALL:F ALS NOC: unconscious",
        "INFO:New ProQA Medical Case Number has been assigned: -1339464  Nature Of Call: unconscious",
        "ID:2013-00001887",
        "GPS:+39.974754,-86.146918");

    doTest("T7",
        "(CADPage) Unit:E45 Status:Dispatched Location: 11610 TECHNOLOGY DR  /   Quad: 45B Units: E45 A41  Type: F ALS NOC: fall Narr:  Nature Of Call: fall  CFS:  871 Coord: 39.9574094490001 -86.148113399 Venue: Carmel Inc #: 2013-00001886",
        "ADDR:11610 TECHNOLOGY DR",
        "CITY:Carmel",
        "MAP:45B",
        "UNIT:E45 A41",
        "CALL:F ALS NOC: fall",
        "INFO:Nature Of Call: fall",
        "ID:2013-00001886",
        "GPS:+39.957409,-86.148113");

    doTest("T8",
        "(CADPage) Unit:E45 Status:Dispatched Location: 11184 RUCKLE ST  /   Quad: 45B Units: E45  Type: F Assist NOC: Narr:  Call Number 815 was created from Call Number 811(May  8 2013 12:48PM)  asst cfd  screaming in house  uncontained toddlers  16 month twins locked in res  CFS:  815 Coord: 39.9514024330001 -86.150504527 Venue: Carmel Inc #: 2013-00001885",
        "ADDR:11184 RUCKLE ST",
        "CITY:Carmel",
        "MAP:45B",
        "UNIT:E45",
        "CALL:F Assist NOC:",
        "INFO:Call Number 815 was created from Call Number 811(May  8 2013 12:48PM)  asst cfd  screaming in house  uncontained toddlers  16 month twins locked in res",
        "ID:2013-00001885",
        "GPS:+39.951402,-86.150505");

    doTest("T9",
        "(CADPage) Location: 11335 N  MICHIGAN RD  /   Quad: 42E Units:  Type: F Fire Misc/Unknown NOC: Narr:  auth boone county / e91,l91 both marked back in service  e42 on scene of altums with fire large burn pile, will be investigating with cmd on fg2  boone county clear for apparatus  boone co disp contacted/ they have not received calls/ not responding to the area  10-17 is a passerby/ heavy black smoke  east of/ heavy smoke showing/ behind huntington bank/ between 106th and 116th  CFS:  619 Coord: 39.948726541 -86.23938201 Venue: Zionsville Inc #: 2013-00001880",
        "ADDR:11335 N MICHIGAN RD",
        "CITY:Zionsville",
        "MAP:42E",
        "CALL:F Fire Misc/Unknown NOC:",
        "INFO:auth boone county / e91,l91 both marked back in service  e42 on scene of altums with fire large burn pile, will be investigating with cmd on fg2  boone county clear for apparatus  boone co disp contacted/ they have not received calls/ not responding to the area  10-17 is a passerby/ heavy black smoke  east of/ heavy smoke showing/ behind huntington bank/ between 106th and 116th",
        "ID:2013-00001880",
        "GPS:+39.948727,-86.239382");

    doTest("T10",
        "(CADPage) Location: 118 MEDICAL DR 317b  /   Quad: 41C Units:  Type: F ALS NOC: unresp female Narr:  enter in main doors  breathing normal, high pulse, is diab, history of seiz  57yr old female, not awake, breathing  Nature Of Call: unresp female  CFS:  660 Coord: 39.9585212472877 -86.1259618342936 Venue: Carmel Inc #: 2013-00001884",
        "ADDR:118 MEDICAL DR",
        "APT:317b",
        "CITY:Carmel",
        "MAP:41C",
        "CALL:F ALS NOC: unresp female",
        "INFO:enter in main doors  breathing normal, high pulse, is diab, history of seiz  57yr old female, not awake, breathing  Nature Of Call: unresp female",
        "ID:2013-00001884",
        "GPS:+39.958521,-86.125962");
}
  
  public static void main(String[] args) {
    new INHamiltonCountyAParserTest().generateTests("T1");
  }
}