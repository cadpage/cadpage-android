package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Burke County, NC
Contact: kevin head <headly1531@gmail.com>
Sender: CAD@bceoc.org

|CAD:69;MED;10D01;2447 LAIL RD;RIVER CLUB DR;CANNONBALL ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 50 year old, Male, [1 of 2]
|CAD:69;MVAPI;TURKEY TAIL LN/LINVILLE ST;[LAW] SUBJECT`S VEHICLES HAS ROLLED OVER AND HE WANTS TO BE CHECKED OUT -- ROUTINE [02/25/11 19:[1 of 2]
|CAD:75;MED;17D03;5751 ABEE FARM ST;NURSERY RD;NEIL RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a [1 of 2]
|CAD:75;FIRE;67B01;3678 SILVER CREEK CT;SILVER CREEK TER;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL [1 of 2]
|CAD:75;MED;26D01;5134 RAIN HILL CHURCH RD;MOUNT OLIVE CHURCH RD;RAINHILL DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: [1 of 2]

Contact: john huffman <threeammetal@gmail.com>
CAD:75;MED;31D02;4612 AMBER LN;DENTONS CHAPEL RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is
CAD:75;MED;10D02;1968 CONLEY RD;REESE STORE AV;FOREMAN ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 44 year old, Male, Conscious,

Contact: Shane Bowman <foothillsfireandsafety@gmail.com>
Sender: CAD@burke.local
CAD:73;MED;12D02;5473 MILLER MILL RD;PYRAMID RD;CRAFTON FARM RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 18 year old, Male, Unconscious, Breathing.

Contact: Active911
Agency name: Oak Hill Fire  Rescue
Location: Morganton, NC, United States
Sender: CAD@burke.local

CAD:62;MED;12D02;2810 HILL TOP AV;BOWMAN AV EXT;NC 181;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 29-year-old female, who is unconscious and breathing. CONTINUOUS o
CAD:62;MED;10D02;2909 BOWMAN AV;TOM FOX ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 74-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING
CAD:62;TRAP;FRANK WHISNANT RD/NC 126;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) HIGH M
CAD:EMS1;MED;31C02;904 N GREEN ST;INDEPENDENCE BLVD;BOST RD;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 60-year-old male, who is conscious and breathing.
CAD:62;MED;21D03;2616 CARL FREEMAN AV;ESTELLE SMITH DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is hemorrhaging. The patient is a 57-year-old female, who is conscious and breathing. DANGEROUS hemor
CAD:UNPR;FIRE;71D05;8098 NC 181;FS 496;WINDSONG LN;[Wireless Re-bid] Caller`s closest address is 7648 NC 181 (DIST: 82.57 ft). [03/17/13 19:17:26 AKANIPE] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Vehicle Fire. LARGE FUEL/FIRE LOAD v
CAD:EMS1;MED;31C02;116 N COUNCIL OAKS ST;COUNCIL OAKS BLVD;WOODCLIFF DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 91-year-old female, who is conscious and breathing
CAD:62;MED;17B03G;1460 AVERY RD;FRANK WHISNANT RD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 68 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement:
CAD:62;MED;06C01;3319 IDLEWILD DR;W WADE AV;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 64-year-old female, who is conscious and breathing. Abnormal
CAD:62;MED;1344 OAK HILL DR;FALLING BROOK LN;OAK FOREST DR;[Medical Priority Info] RESPONSE: Echo RESPONDER SCRIPT: 70 year old, Male, Unconscious, Not breathing. Cardiac or Respiratory Arrest / Death. Not breathing at all. [03/15/13 17:09:41 ATHOMAS]
CAD:62;TRAP;127 BRANSTROM DR;SAM WALL AV
CAD:62;MED;1299 WATERMILL RD;SOLID ROCK COVE RD;NC 126
CAD:62;MED;10C02;1917 DEERFIELD DR;LAKE DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 69-year-old male, who is conscious and breathing. Heart attack or angi
CAD:62;MED;10C04;2616 CARL FREEMAN AV;ESTELLE SMITH DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 58 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. -Comments: PAIN PILL- [03/14/13 07:31
CAD:EMS3;MEDA;17A03G;108 CROSSCREEK DR;NC 126;[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 74-year-old female, who is conscious and breathing. PUBLIC ASSIST (no
CAD:62;MED99;125 CAMELLIA GARDEN ST;NC 126;21-B-99 73 Y/O FEMALE RECTAL BLEED, 0700 HRS THIS DATE [03/13/13 10:37:47 AELLIS]
CAD:62;MED;17B01G;101 CANOE DR;EMORYWOOD DR;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. POSSIBLY DANGEROU
CAD:62;FIRE;52B01S;2983 OAK FOREST LN;NC 181;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. [03/12/13 18:54:36 YSTANLEY]
CAD:62;MED;06D04;1790 WATERMILL RD;SOLID ROCK COVE RD;NC 126;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 70 year old, Male, Conscious, Breathing. Breathing Problems. Clammy. Caller Statement: HUSBAND HAVING TROUBLE BREATHING. [03/12/13 10:05
CAD:62;MED;1895 ROY CALDWELL ST;WOERNER WAY;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 56 year old, Male, Unconscious, Breathing. Cardiac or Respiratory Arrest / Death. INEFFECTIVE BREATHING. [03/11/13 14:58:08 ATHOMAS]
CAD:UNPR;MED;8093 NC 181;STREAMSIDE DR;FS 496;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 51 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. [03/11/13 14:30:14 ATHOMAS]
CAD:62;MED99;201 MULL LN;MEADOW VIEW ST;HILLCREST ST;17-B-99 [03/11/13 10:07:08 ATHOMAS]
CAD:62;MED;1460 AVERY RD;FRANK WHISNANT RD;RESIDENT NUMBER 828-439-9892 [03/10/13 08:33:23 RLIPFORD]
CAD:62;MED;13C03;2436 WILLOWTREE CHURCH AV;FOTA LYRUMA LN;SCENIC VIEW LN;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 50-year-old male, who is conscious and breathing. Abnormal brea
CAD:76;BRUSH;67D02;3998 PAX HILL RD;CORPENING BRIDGE RD;JIM MCCALL RD;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. LARGE BRUSH/GRASS fire. [03/09/13 11:14:12 SMILLER] ON THE RIGHT PAST CORPENING BRIDGE RD [03/09/13 11:14:40 SMILLER] UDTS:
CAD:EMS1;MED;17D03;116 N COUNCIL OAKS ST;COUNCIL OAKS BLVD;WOODCLIFF DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 91 year old, Female, Conscious, Breathing. Falls. Not alert. [03/09/13 10:20:48 SMILLER] RIGHT TO HOUSE ON THE RIGHT WITH RED PICKUP IN
CAD:62;FIRE;71B01;NC 126/BEECHMONT DR;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Vehicle Fire. [03/09/13 02:14:47 TCOLEMAN]
CAD:EMS1;MED;12B01E;863 N GREEN ST;DIST: 114.43 FT;WAMSUTTA MILL RD;INDEPENDENCE BLVD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 2 year old, Male, Unconscious, Breathing. Convulsions / Seizures. Effective breathing not verified < 35 (Epileptic or Previous seizure di
CAD:62;MED;29B01;1827 HARMON ST;NC 181;TONI BUNNELL LN;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 30 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. [03/08/13 18:25:44 CTAYLOR]
CAD:62;FIRE99;3615 PIEDMONT RD;JOHNS RIVER RD;PARK LANE DR;67-B-99 [03/08/13 12:28:49 RLIPFORD]
CAD:62;STRU;69D06;2865 NC 181;CARL FREEMAN AV;PAUL & LULA MILLER RD;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. [03/07/13 10:24:31 BROLAND]
CAD:CANCEL;3641 PIEDMONT RD; MORG
CAD:62;MED;12D02;3641 PIEDMONT RD;JOHNS RIVER RD;PARK LANE DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 45-year-old male, who is unconscious and breathing. CONTINUOUS or

*/
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
  
  @Test
  public void testShaneBowman() {

    doTest("T1",
        "CAD:73;MED;12D02;5473 MILLER MILL RD;PYRAMID RD;CRAFTON FARM RD;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 18 year old, Male, Unconscious, Breathing.",
        "SRC:73",
        "CALL:MED",
        "CODE:12D02",
        "ADDR:5473 MILLER MILL RD",
        "X:PYRAMID RD & CRAFTON FARM RD",
        "INFO:18 year old, Male, Unconscious, Breathing.");

  }

  @Test
  public void testOakHillFireRescue() {

    doTest("T1",
        "CAD:62;MED;12D02;2810 HILL TOP AV;BOWMAN AV EXT;NC 181;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 29-year-old female, who is unconscious and breathing. CONTINUOUS o",
        "SRC:62",
        "CALL:MED",
        "CODE:12D02",
        "ADDR:2810 HILL TOP AV",
        "MADDR:2810 HILL TOP AVE",
        "X:BOWMAN AV EXT & NC 181",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 29-year-old female, who is unconscious and breathing. CONTINUOUS o");

    doTest("T2",
        "CAD:62;MED;10D02;2909 BOWMAN AV;TOM FOX ST;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 74-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING",
        "SRC:62",
        "CALL:MED",
        "CODE:10D02",
        "ADDR:2909 BOWMAN AV",
        "MADDR:2909 BOWMAN AVE",
        "X:TOM FOX ST",
        "INFO:You are responding to a patient with chest pain. The patient is a 74-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING");

    doTest("T3",
        "CAD:62;TRAP;FRANK WHISNANT RD/NC 126;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) HIGH M",
        "SRC:62",
        "CALL:TRAP",
        "ADDR:FRANK WHISNANT RD & NC 126",
        "MADDR:FRANK WHISNANT RD & STATE 126",
        "INFO:You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) HIGH M");

    doTest("T4",
        "CAD:EMS1;MED;31C02;904 N GREEN ST;INDEPENDENCE BLVD;BOST RD;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 60-year-old male, who is conscious and breathing.",
        "SRC:EMS1",
        "CALL:MED",
        "CODE:31C02",
        "ADDR:904 N GREEN ST",
        "X:INDEPENDENCE BLVD & BOST RD",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 60-year-old male, who is conscious and breathing.");

    doTest("T5",
        "CAD:62;MED;21D03;2616 CARL FREEMAN AV;ESTELLE SMITH DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is hemorrhaging. The patient is a 57-year-old female, who is conscious and breathing. DANGEROUS hemor",
        "SRC:62",
        "CALL:MED",
        "CODE:21D03",
        "ADDR:2616 CARL FREEMAN AV",
        "MADDR:2616 CARL FREEMAN AVE",
        "X:ESTELLE SMITH DR",
        "INFO:You are responding to a patient who is hemorrhaging. The patient is a 57-year-old female, who is conscious and breathing. DANGEROUS hemor");

    doTest("T6",
        "CAD:UNPR;FIRE;71D05;8098 NC 181;FS 496;WINDSONG LN;[Wireless Re-bid] Caller`s closest address is 7648 NC 181 (DIST: 82.57 ft). [03/17/13 19:17:26 AKANIPE] [Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Vehicle Fire. LARGE FUEL/FIRE LOAD v",
        "SRC:UNPR",
        "CALL:FIRE",
        "CODE:71D05",
        "ADDR:8098 NC 181",
        "MADDR:8098 STATE 181",
        "X:FS 496 & WINDSONG LN",
        "INFO:Caller`s closest address is 7648 NC 181 (DIST: 82.57 ft). / Vehicle Fire. LARGE FUEL/FIRE LOAD v",
        "DATE:03/17/13",
        "TIME:19:17:26");

    doTest("T7",
        "CAD:EMS1;MED;31C02;116 N COUNCIL OAKS ST;COUNCIL OAKS BLVD;WOODCLIFF DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 91-year-old female, who is conscious and breathing",
        "SRC:EMS1",
        "CALL:MED",
        "CODE:31C02",
        "ADDR:116 N COUNCIL OAKS ST",
        "X:COUNCIL OAKS BLVD & WOODCLIFF DR",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 91-year-old female, who is conscious and breathing");

    doTest("T8",
        "CAD:62;MED;17B03G;1460 AVERY RD;FRANK WHISNANT RD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 68 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement:",
        "SRC:62",
        "CALL:MED",
        "CODE:17B03G",
        "ADDR:1460 AVERY RD",
        "X:FRANK WHISNANT RD",
        "INFO:68 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement:");

    doTest("T9",
        "CAD:62;MED;06C01;3319 IDLEWILD DR;W WADE AV;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 64-year-old female, who is conscious and breathing. Abnormal",
        "SRC:62",
        "CALL:MED",
        "CODE:06C01",
        "ADDR:3319 IDLEWILD DR",
        "X:W WADE AV",
        "INFO:You are responding to a patient with breathing problems. The patient is a 64-year-old female, who is conscious and breathing. Abnormal");

    doTest("T10",
        "CAD:62;MED;1344 OAK HILL DR;FALLING BROOK LN;OAK FOREST DR;[Medical Priority Info] RESPONSE: Echo RESPONDER SCRIPT: 70 year old, Male, Unconscious, Not breathing. Cardiac or Respiratory Arrest / Death. Not breathing at all. [03/15/13 17:09:41 ATHOMAS]",
        "SRC:62",
        "CALL:MED",
        "ADDR:1344 OAK HILL DR",
        "X:FALLING BROOK LN & OAK FOREST DR",
        "INFO:70 year old, Male, Unconscious, Not breathing. Cardiac or Respiratory Arrest / Death. Not breathing at all.",
        "DATE:03/15/13",
        "TIME:17:09:41");

    doTest("T11",
        "CAD:62;TRAP;127 BRANSTROM DR;SAM WALL AV",
        "SRC:62",
        "CALL:TRAP",
        "ADDR:127 BRANSTROM DR",
        "X:SAM WALL AV");

    doTest("T12",
        "CAD:62;MED;1299 WATERMILL RD;SOLID ROCK COVE RD;NC 126",
        "SRC:62",
        "CALL:MED",
        "ADDR:1299 WATERMILL RD",
        "X:SOLID ROCK COVE RD & NC 126");

    doTest("T13",
        "CAD:62;MED;10C02;1917 DEERFIELD DR;LAKE DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 69-year-old male, who is conscious and breathing. Heart attack or angi",
        "SRC:62",
        "CALL:MED",
        "CODE:10C02",
        "ADDR:1917 DEERFIELD DR",
        "X:LAKE DR",
        "INFO:You are responding to a patient with chest pain. The patient is a 69-year-old male, who is conscious and breathing. Heart attack or angi");

    doTest("T14",
        "CAD:62;MED;10C04;2616 CARL FREEMAN AV;ESTELLE SMITH DR;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 58 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. -Comments: PAIN PILL- [03/14/13 07:31",
        "SRC:62",
        "CALL:MED",
        "CODE:10C04",
        "ADDR:2616 CARL FREEMAN AV",
        "MADDR:2616 CARL FREEMAN AVE",
        "X:ESTELLE SMITH DR",
        "INFO:58 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. -Comments: PAIN PILL-");

    doTest("T15",
        "CAD:EMS3;MEDA;17A03G;108 CROSSCREEK DR;NC 126;[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 74-year-old female, who is conscious and breathing. PUBLIC ASSIST (no",
        "SRC:EMS3",
        "CALL:MEDA",
        "CODE:17A03G",
        "ADDR:108 CROSSCREEK DR",
        "X:NC 126",
        "INFO:You are responding to a patient involved in a fall. The patient is a 74-year-old female, who is conscious and breathing. PUBLIC ASSIST (no");

    doTest("T16",
        "CAD:62;MED99;125 CAMELLIA GARDEN ST;NC 126;21-B-99 73 Y/O FEMALE RECTAL BLEED, 0700 HRS THIS DATE [03/13/13 10:37:47 AELLIS]",
        "SRC:62",
        "CALL:MED99",
        "ADDR:125 CAMELLIA GARDEN ST",
        "X:NC 126",
        "INFO:21-B-99 73 Y/O FEMALE RECTAL BLEED, 0700 HRS THIS DATE",
        "DATE:03/13/13",
        "TIME:10:37:47");

    doTest("T17",
        "CAD:62;MED;17B01G;101 CANOE DR;EMORYWOOD DR;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. POSSIBLY DANGEROU",
        "SRC:62",
        "CALL:MED",
        "CODE:17B01G",
        "ADDR:101 CANOE DR",
        "X:EMORYWOOD DR",
        "INFO:You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. POSSIBLY DANGEROU");

    doTest("T18",
        "CAD:62;FIRE;52B01S;2983 OAK FOREST LN;NC 181;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. [03/12/13 18:54:36 YSTANLEY]",
        "SRC:62",
        "CALL:FIRE",
        "CODE:52B01S",
        "ADDR:2983 OAK FOREST LN",
        "X:NC 181",
        "INFO:Alarms.",
        "DATE:03/12/13",
        "TIME:18:54:36");

    doTest("T19",
        "CAD:62;MED;06D04;1790 WATERMILL RD;SOLID ROCK COVE RD;NC 126;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 70 year old, Male, Conscious, Breathing. Breathing Problems. Clammy. Caller Statement: HUSBAND HAVING TROUBLE BREATHING. [03/12/13 10:05",
        "SRC:62",
        "CALL:MED",
        "CODE:06D04",
        "ADDR:1790 WATERMILL RD",
        "X:SOLID ROCK COVE RD & NC 126",
        "INFO:70 year old, Male, Conscious, Breathing. Breathing Problems. Clammy. Caller Statement: HUSBAND HAVING TROUBLE BREATHING.");

    doTest("T20",
        "CAD:62;MED;1895 ROY CALDWELL ST;WOERNER WAY;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 56 year old, Male, Unconscious, Breathing. Cardiac or Respiratory Arrest / Death. INEFFECTIVE BREATHING. [03/11/13 14:58:08 ATHOMAS]",
        "SRC:62",
        "CALL:MED",
        "ADDR:1895 ROY CALDWELL ST",
        "X:WOERNER WAY",
        "INFO:56 year old, Male, Unconscious, Breathing. Cardiac or Respiratory Arrest / Death. INEFFECTIVE BREATHING.",
        "DATE:03/11/13",
        "TIME:14:58:08");

    doTest("T21",
        "CAD:UNPR;MED;8093 NC 181;STREAMSIDE DR;FS 496;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 51 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. [03/11/13 14:30:14 ATHOMAS]",
        "SRC:UNPR",
        "CALL:MED",
        "ADDR:8093 NC 181",
        "MADDR:8093 STATE 181",
        "X:STREAMSIDE DR & FS 496",
        "INFO:51 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Injuries.",
        "DATE:03/11/13",
        "TIME:14:30:14");

    doTest("T22",
        "CAD:62;MED99;201 MULL LN;MEADOW VIEW ST;HILLCREST ST;17-B-99 [03/11/13 10:07:08 ATHOMAS]",
        "SRC:62",
        "CALL:MED99",
        "ADDR:201 MULL LN",
        "X:MEADOW VIEW ST & HILLCREST ST",
        "INFO:17-B-99",
        "DATE:03/11/13",
        "TIME:10:07:08");

    doTest("T23",
        "CAD:62;MED;1460 AVERY RD;FRANK WHISNANT RD;RESIDENT NUMBER 828-439-9892 [03/10/13 08:33:23 RLIPFORD]",
        "SRC:62",
        "CALL:MED",
        "ADDR:1460 AVERY RD",
        "X:FRANK WHISNANT RD",
        "INFO:RESIDENT NUMBER 828-439-9892",
        "DATE:03/10/13",
        "TIME:08:33:23");

    doTest("T24",
        "CAD:62;MED;13C03;2436 WILLOWTREE CHURCH AV;FOTA LYRUMA LN;SCENIC VIEW LN;[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 50-year-old male, who is conscious and breathing. Abnormal brea",
        "SRC:62",
        "CALL:MED",
        "CODE:13C03",
        "ADDR:2436 WILLOWTREE CHURCH AV",
        "MADDR:2436 WILLOWTREE CHURCH AVE",
        "X:FOTA LYRUMA LN & SCENIC VIEW LN",
        "INFO:You are responding to a patient with diabetic problems. The patient is a 50-year-old male, who is conscious and breathing. Abnormal brea");

    doTest("T25",
        "CAD:76;BRUSH;67D02;3998 PAX HILL RD;CORPENING BRIDGE RD;JIM MCCALL RD;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. LARGE BRUSH/GRASS fire. [03/09/13 11:14:12 SMILLER] ON THE RIGHT PAST CORPENING BRIDGE RD [03/09/13 11:14:40 SMILLER] UDTS:",
        "SRC:76",
        "CALL:BRUSH",
        "CODE:67D02",
        "ADDR:3998 PAX HILL RD",
        "X:CORPENING BRIDGE RD & JIM MCCALL RD",
        "INFO:Outside Fire. LARGE BRUSH/GRASS fire. / ON THE RIGHT PAST CORPENING BRIDGE RD / UDTS:",
        "DATE:03/09/13",
        "TIME:11:14:12");

    doTest("T26",
        "CAD:EMS1;MED;17D03;116 N COUNCIL OAKS ST;COUNCIL OAKS BLVD;WOODCLIFF DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 91 year old, Female, Conscious, Breathing. Falls. Not alert. [03/09/13 10:20:48 SMILLER] RIGHT TO HOUSE ON THE RIGHT WITH RED PICKUP IN",
        "SRC:EMS1",
        "CALL:MED",
        "CODE:17D03",
        "ADDR:116 N COUNCIL OAKS ST",
        "X:COUNCIL OAKS BLVD & WOODCLIFF DR",
        "INFO:91 year old, Female, Conscious, Breathing. Falls. Not alert. / RIGHT TO HOUSE ON THE RIGHT WITH RED PICKUP IN",
        "DATE:03/09/13",
        "TIME:10:20:48");

    doTest("T27",
        "CAD:62;FIRE;71B01;NC 126/BEECHMONT DR;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Vehicle Fire. [03/09/13 02:14:47 TCOLEMAN]",
        "SRC:62",
        "CALL:FIRE",
        "CODE:71B01",
        "ADDR:NC 126 & BEECHMONT DR",
        "MADDR:STATE 126 & BEECHMONT DR",
        "INFO:Vehicle Fire.",
        "DATE:03/09/13",
        "TIME:02:14:47");

    doTest("T28",
        "CAD:EMS1;MED;12B01E;863 N GREEN ST;DIST: 114.43 FT;WAMSUTTA MILL RD;INDEPENDENCE BLVD;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 2 year old, Male, Unconscious, Breathing. Convulsions / Seizures. Effective breathing not verified < 35 (Epileptic or Previous seizure di",
        "SRC:EMS1",
        "CALL:MED",
        "CODE:12B01E",
        "ADDR:863 N GREEN ST",
        "INFO:DIST: 114.43 FT / WAMSUTTA MILL RD / INDEPENDENCE BLVD / 2 year old, Male, Unconscious, Breathing. Convulsions / Seizures. Effective breathing not verified < 35 (Epileptic or Previous seizure di");

    doTest("T29",
        "CAD:62;MED;29B01;1827 HARMON ST;NC 181;TONI BUNNELL LN;[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 30 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. [03/08/13 18:25:44 CTAYLOR]",
        "SRC:62",
        "CALL:MED",
        "CODE:29B01",
        "ADDR:1827 HARMON ST",
        "X:NC 181 & TONI BUNNELL LN",
        "INFO:30 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries.",
        "DATE:03/08/13",
        "TIME:18:25:44");

    doTest("T30",
        "CAD:62;FIRE99;3615 PIEDMONT RD;JOHNS RIVER RD;PARK LANE DR;67-B-99 [03/08/13 12:28:49 RLIPFORD]",
        "SRC:62",
        "CALL:FIRE99",
        "ADDR:3615 PIEDMONT RD",
        "X:JOHNS RIVER RD & PARK LANE DR",
        "INFO:67-B-99",
        "DATE:03/08/13",
        "TIME:12:28:49");

    doTest("T31",
        "CAD:62;STRU;69D06;2865 NC 181;CARL FREEMAN AV;PAUL & LULA MILLER RD;[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. [03/07/13 10:24:31 BROLAND]",
        "SRC:62",
        "CALL:STRU",
        "CODE:69D06",
        "ADDR:2865 NC 181",
        "MADDR:2865 STATE 181",
        "X:CARL FREEMAN AV",
        "INFO:PAUL & LULA MILLER RD / Structure Fire.",
        "DATE:03/07/13",
        "TIME:10:24:31");

    doTest("T32",
        "CAD:CANCEL;3641 PIEDMONT RD; MORG",
        "CALL:CANCEL",
        "ADDR:3641 PIEDMONT RD",
        "INFO:MORG");

    doTest("T33",
        "CAD:62;MED;12D02;3641 PIEDMONT RD;JOHNS RIVER RD;PARK LANE DR;[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 45-year-old male, who is unconscious and breathing. CONTINUOUS or",
        "SRC:62",
        "CALL:MED",
        "CODE:12D02",
        "ADDR:3641 PIEDMONT RD",
        "X:JOHNS RIVER RD & PARK LANE DR",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 45-year-old male, who is unconscious and breathing. CONTINUOUS or");
   
  }

  public static void main(String[] args) {
    new NCBurkeCountyParserTest().generateTests("T1");
  }
}
