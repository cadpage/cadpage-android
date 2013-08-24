package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Wilson County, NC
Contact: Lori OBriant <lobriant@gmail.com>
Sender: 930010NN

The CAD number associated with the call (1100831), the EMD code (06D02),
what the call is (BREATHING PROBLEMS), the address (5033 US 264A E), the
district associated with the CAD for assigning units (2C), cross streets for
address (RANCH FARM CR; HOLDERS CROSS RD) and the rest of the page is mostly
what is in the notes field of the call in CAD.  Most of the calls are
processed this way.

CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE:
CAD:OUTSIDE FIRE - SMALL;5047 SAWDUST RD;4C;LASSITER MILL RD;TARTTS MILL RD
CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que
CAD:STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;291-5847 [05/19/11 13:51:05 SBATTS]
CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que
CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPO
CAD:11000844;ACCIDENT PROPERTY DAMAGE;NC 222/ASPEN GROVE CHURCH RD;2A;on nc 222 just before aspen grove church while on the phone with hp she advised a hissing
CAD:B&E to occupied residence occurred at 612 Fairfax Ave. 2 suspects busted in the back door, homeowner yelled and subjects ran. One subject 10-72 at this time
CAD:ROLLING DOMESTIC - 701 HNES STREET - MALE PARTY STABBED - BOTH SUBJECTS 10-72 - MALE PARTY HAS NON-LIFE THREATNING INJURIES - AUTH 301 -- WILSON 911 TC LYLE
CAD:11000968;67D02R;OUTSIDE FIRE - WOODS/LRG BRUSH;4164 NC 42 E;4C;KENT RD;VARNELL RD;[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRI

Contact: bullboy65 <bullboy65@yahoo.com>
Sender: CAD@Wilson-co.com
S: M:CAD:11001633;FIRE ALARM 1;7005 SPRINGFIELD SCHOOL RD;6A;WILLING WORKER RD;PEELE RD\n

Contact: Active911
Agency name: Sanoca Rural Fire District 
Location: Stantonsburg, NC, United States
Sender: messaging@emergencysmc.com

(Sanoca) ;STRUCTURE FIRE 1;7514 GLOVER RD;1A;GOOD NEWS CHURCH RD;HOLDENS CROSS RD;dryer on fire is inside the resdience [08/03/13 14:17:40 GDURHAM]
(Sanoca) ;06D02;BREATHING PROBLEMS;6604 SPEIGHT SCHOOL RD;2D;GRIMSLEY STORE RD;PANTHER BRANCH RD;given out on wpd and so channels [07/31/13 00:46:26 SCARY] [Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 3. She is not changing color. 4. She is not clammy.
(Sanoca) ;7550 GOOD NEWS CHURCH RD;1A;GLOVER RD;NC 111 S
(Sanoca) ;TRAFFIC / TRANSPORTATION ACC;8513 NC 222;2A;ASPEN GROVE CHURCH RD;EAGLES CROSS RD;Event spawned from TRAFFIC / TRANSPORTATION ACC. [07/27/2013 17:25:50 PLVICK]  SE: MEDIC & FD RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Trans
(Sanoca) ;TRAFFIC / TRANSPORTATION ACC;53 US 264 E;2D;US 264A E;NC 222; SE: MEDIC & FD RESPONDER SCRIPT: 45 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Unknown status/Other codes not applicable. Caller Statement: TRAFFIC ACCIDENT. 1. The
(Sanoca) ;FIRE ALARM 1;324 E COMMERCIAL AVE;3G;N SARATOGA ST;COMMERCIAL AVE;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The inciden
(Sanoca) ;10D02;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 4. She is not changing color. 5. She is clammy. 6. She has had a heart attack before. 7. She took a prescribed m
(Sanoca) ;67B01;OUTSIDE FIRE - SMALL;8276 NC 222;2A;GALLOWAY RD;ASPEN GROVE CHURCH RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire.Caller Statement: field on fire. 1. The caller is not on scene. 2. This is a SMALL OUTSIDE fire. 3. The fire has not bee
(Sanoca) ;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD; SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pains and breathing problems . 1. Sh
(Sanoca) ;67B01;OUTSIDE FIRE - SMALL;6872 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire.Caller Statement: burning trash in the yard. 1. The caller is on scene (2nd party). 2. This is a SMALL O
(Sanoca) ;13D01;DIABETIC PROBLEM;5728 US 264A E;2C;WOODSIDE RD;BIRDIE RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 1. He is breathing normally. [07/20/13 10:08:28 SBEST]  SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Male, U
(Sanoca) ;10D01;CHEST PAIN;6916 SPEIGHT SCHOOL RD;2E;PANTHER BRANCH RD;NC 222; SE: MEDIC & FR RESPONDER SCRIPT: 22 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Not alert. Caller Statement: chest pain wife`s friend. 1. She is not completely aler
(Sanoca) ;60C01O;GAS LEAK OR ODOR;5740 US 264A E;2C;WOODSIDE RD;BIRDIE RD;[Fire Priority Info] Key Questions Complete RESPONSE: Charlie RESPONDER SCRIPT: 5. The gas is coming from: oven 6. No one is reportedly sick or injured. -Comments: oven- [07/18/13 18:35:30 MLAMM] [Fire Priority Update]
(Sanoca) ;06D02;BREATHING PROBLEMS;6604 SPEIGHT SCHOOL RD;2D;GRIMSLEY STORE RD;PANTHER BRANCH RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 3. She is not changing color. 4. She is clammy. 5. She does not have asthma. 6. N/A [07/16/13 22:09:09 MHAMM
(Sanoca) CAD:13001152;06D02;BREATHING PROBLEMS;6223 GOOD NEWS CHURCH RD;2A;NC 222;GUM POND RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 87 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: FEMALE DIFF BREATHING . 1. She
(Sanoca) CAD:13001145;31D03;UNCONSCIOUS / FAINTING;7244 PINEY GROVE CHURCH RD;2A;GOOD NEWS CHURCH RD;GUM POND RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 60 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: FEELS LIKE EVERYTHING GOING BLA
(Sanoca) CAD:13001054;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pain going down left arm. 1. She is
(Sanoca) CAD:13001052;17D03;FALLS;5104 WHITE OAK LOOP;2C;KENNEDY RD;US 264A E;[EMS] patient is really weak [06/25/13 21:06:27 RTSMITH] [Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 85 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: fall . 1. This happened now (les
(Sanoca) CAD:13001048;FIRE ALARM 1;5637 US 264A E;WHITES SIDING CO;2C;SECOND RD;WOODSIDE RD
(Sanoca) CAD:13001023;52B01S;FIRE ALARM 1;4317 KENT RD;4C;JONES RD;TARTTS MILL RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: residental fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3.
(Sanoca) CAD:13001013;10C02;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;GAVE OUT ON WCSO AND WPD [06/18/13 12:49:46 SBEST] [Medical Priority Info]
(Sanoca) CAD:13001010;06D02;BREATHING PROBLEMS;7109 MAIN ST;2E;SHACKLEFORD ST;US 264A E;[Medical Priority Info]
(Sanoca) CAD:13000979;ELECTRICAL HAZARD 1;6719 CHURCH ST;2E;REBECCA ST;ROGERS ST;Aborted by Fire Priority with code: Help arrived [06/13/13 18:48:15 CCADY] ELECTRICAL BOX ON SIDE OF HOUSE ARCHING [06/13/13 18:48:01 CCADY]
(Sanoca) CAD:13000968;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info]

*/

public class NCWilsonCountyParserTest extends BaseParserTest {
  
  public NCWilsonCountyParserTest() {
    setParser(new NCWilsonCountyParser(), "WILSON COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE:",
        "ID:11000831",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5036 US 264A E",
        "MADDR:5036 US 264 ALT",
        "SRC:2C",
        "X:RANCH FARM CT & HOLDENS CROSS RD");

    doTest("T2",
        "CAD:OUTSIDE FIRE - SMALL;5047 SAWDUST RD;4C;LASSITER MILL RD;TARTTS MILL RD",
        "CALL:OUTSIDE FIRE - SMALL",
        "ADDR:5047 SAWDUST RD",
        "SRC:4C",
        "X:LASSITER MILL RD & TARTTS MILL RD");

    doTest("T3",
        "CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que",
        "ID:11000827",
        "CODE:69D10",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:403 enroute",
        "DATE:05/19/11",
        "TIME:13:53:19");

    doTest("T4",
        "CAD:STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;291-5847 [05/19/11 13:51:05 SBATTS]",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:291-5847",
        "DATE:05/19/11",
        "TIME:13:51:05");

    doTest("T5",
        "CAD:11000827;69D10;STRUCTURE FIRE 1;4659 EVANSDALE RD;5B;OLD STANTONSBURG RD;CASTLEWOOD LN;403 enroute [05/19/11 13:53:19 DPITTMAN] [Fire Priority Info] Key Que",
        "ID:11000827",
        "CODE:69D10",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:4659 EVANSDALE RD",
        "SRC:5B",
        "X:OLD STANTONSBURG RD & CASTLEWOOD LN",
        "INFO:403 enroute",
        "DATE:05/19/11",
        "TIME:13:53:19");

    doTest("T6",
        "CAD:11000831;06D02;BREATHING PROBLEMS;5036 US 264A E;2C;RANCH FARM CT;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPO",
        "ID:11000831",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5036 US 264A E",
        "MADDR:5036 US 264 ALT",
        "SRC:2C",
        "X:RANCH FARM CT & HOLDENS CROSS RD");

    doTest("T7",
        "CAD:11000844;ACCIDENT PROPERTY DAMAGE;NC 222/ASPEN GROVE CHURCH RD;2A;on nc 222 just before aspen grove church while on the phone with hp she advised a hissing",
        "ID:11000844",
        "CALL:ACCIDENT PROPERTY DAMAGE",
        "ADDR:NC 222 & ASPEN GROVE CHURCH RD",
        "MADDR:STATE 222 & ASPEN GROVE CHURCH RD",
        "SRC:2A",
        "INFO:on nc 222 just before aspen grove church while on the phone with hp she advised a hissing");

    doTest("T8",
        "CAD:11000968;67D02R;OUTSIDE FIRE - WOODS/LRG BRUSH;4164 NC 42 E;4C;KENT RD;VARNELL RD;[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRI",
        "ID:11000968",
        "CODE:67D02R",
        "CALL:OUTSIDE FIRE - WOODS/LRG BRUSH",
        "ADDR:4164 NC 42 E",
        "MADDR:4164 STATE 42 E",
        "SRC:4C",
        "X:KENT RD & VARNELL RD");

    doTest("T8",
        "S: M:CAD:11001633;FIRE ALARM 1;7005 SPRINGFIELD SCHOOL RD;6A;WILLING WORKER RD;PEELE RD\n",
        "ID:11001633",
        "CALL:FIRE ALARM 1",
        "ADDR:7005 SPRINGFIELD SCHOOL RD",
        "SRC:6A",
        "X:WILLING WORKER RD & PEELE RD");
 }
  
  @Test
  public void testSanocaRuralFireDistrict() {

    doTest("T1",
        "(Sanoca) ;STRUCTURE FIRE 1;7514 GLOVER RD;1A;GOOD NEWS CHURCH RD;HOLDENS CROSS RD;dryer on fire is inside the resdience [08/03/13 14:17:40 GDURHAM]",
        "CALL:STRUCTURE FIRE 1",
        "ADDR:7514 GLOVER RD",
        "SRC:1A",
        "X:GOOD NEWS CHURCH RD & HOLDENS CROSS RD",
        "INFO:dryer on fire is inside the resdience",
        "DATE:08/03/13",
        "TIME:14:17:40");

    doTest("T2",
        "(Sanoca) ;06D02;BREATHING PROBLEMS;6604 SPEIGHT SCHOOL RD;2D;GRIMSLEY STORE RD;PANTHER BRANCH RD;given out on wpd and so channels [07/31/13 00:46:26 SCARY] [Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 3. She is not changing color. 4. She is not clammy.",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:6604 SPEIGHT SCHOOL RD",
        "SRC:2D",
        "X:GRIMSLEY STORE RD & PANTHER BRANCH RD",
        "INFO:given out on wpd and so channels / 3. She is not changing color. 4. She is not clammy.",
        "DATE:07/31/13",
        "TIME:00:46:26");

    doTest("T3",
        "(Sanoca) ;7550 GOOD NEWS CHURCH RD;1A;GLOVER RD;NC 111 S",
        "CALL:7550 GOOD NEWS CHURCH RD",
        "ADDR:1A",
        "MADDR:1A & STATE 111 S",
        "SRC:GLOVER RD",
        "X:NC 111 S");

    doTest("T4",
        "(Sanoca) ;TRAFFIC / TRANSPORTATION ACC;8513 NC 222;2A;ASPEN GROVE CHURCH RD;EAGLES CROSS RD;Event spawned from TRAFFIC / TRANSPORTATION ACC. [07/27/2013 17:25:50 PLVICK]  SE: MEDIC & FD RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Trans",
        "CALL:TRAFFIC / TRANSPORTATION ACC",
        "ADDR:8513 NC 222",
        "MADDR:8513 STATE 222",
        "SRC:2A",
        "X:ASPEN GROVE CHURCH RD & EAGLES CROSS RD",
        "INFO:Event spawned from TRAFFIC / TRANSPORTATION ACC. / SE: MEDIC & FD RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Trans",
        "DATE:07/27/2013",
        "TIME:17:25:50");

    doTest("T5",
        "(Sanoca) ;TRAFFIC / TRANSPORTATION ACC;53 US 264 E;2D;US 264A E;NC 222; SE: MEDIC & FD RESPONDER SCRIPT: 45 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Unknown status/Other codes not applicable. Caller Statement: TRAFFIC ACCIDENT. 1. The",
        "CALL:TRAFFIC / TRANSPORTATION ACC",
        "ADDR:53 US 264 E",
        "MADDR:53 US 264 ALT",
        "SRC:2D",
        "X:US 264A E & NC 222",
        "INFO:SE: MEDIC & FD RESPONDER SCRIPT: 45 year old, Male, Conscious, Breathing. Traffic / Transportation Incidents. Unknown status/Other codes not applicable. Caller Statement: TRAFFIC ACCIDENT. 1. The");

    doTest("T6",
        "(Sanoca) ;FIRE ALARM 1;324 E COMMERCIAL AVE;3G;N SARATOGA ST;COMMERCIAL AVE;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The inciden",
        "CALL:FIRE ALARM 1",
        "ADDR:324 E COMMERCIAL AVE",
        "SRC:3G",
        "X:N SARATOGA ST & COMMERCIAL AVE",
        "INFO:Alarms. Residential (single) (Smoke detector).Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The inciden");

    doTest("T7",
        "(Sanoca) ;10D02;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 4. She is not changing color. 5. She is clammy. 6. She has had a heart attack before. 7. She took a prescribed m",
        "CODE:10D02",
        "CALL:CHEST PAIN",
        "ADDR:6910 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD",
        "INFO:4. She is not changing color. 5. She is clammy. 6. She has had a heart attack before. 7. She took a prescribed m");

    doTest("T8",
        "(Sanoca) ;67B01;OUTSIDE FIRE - SMALL;8276 NC 222;2A;GALLOWAY RD;ASPEN GROVE CHURCH RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire.Caller Statement: field on fire. 1. The caller is not on scene. 2. This is a SMALL OUTSIDE fire. 3. The fire has not bee",
        "CODE:67B01",
        "CALL:OUTSIDE FIRE - SMALL",
        "ADDR:8276 NC 222",
        "MADDR:8276 STATE 222",
        "SRC:2A",
        "X:GALLOWAY RD & ASPEN GROVE CHURCH RD",
        "INFO:Outside Fire. SMALL OUTSIDE fire.Caller Statement: field on fire. 1. The caller is not on scene. 2. This is a SMALL OUTSIDE fire. 3. The fire has not bee");

    doTest("T9",
        "(Sanoca) ;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD; SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pains and breathing problems . 1. Sh",
        "CODE:10D04",
        "CALL:CHEST PAIN",
        "ADDR:6910 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD",
        "INFO:SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pains and breathing problems . 1. Sh");

    doTest("T10",
        "(Sanoca) ;67B01;OUTSIDE FIRE - SMALL;6872 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire.Caller Statement: burning trash in the yard. 1. The caller is on scene (2nd party). 2. This is a SMALL O",
        "CODE:67B01",
        "CALL:OUTSIDE FIRE - SMALL",
        "ADDR:6872 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD",
        "INFO:Outside Fire. SMALL OUTSIDE fire.Caller Statement: burning trash in the yard. 1. The caller is on scene (2nd party). 2. This is a SMALL O");

    doTest("T11",
        "(Sanoca) ;13D01;DIABETIC PROBLEM;5728 US 264A E;2C;WOODSIDE RD;BIRDIE RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 1. He is breathing normally. [07/20/13 10:08:28 SBEST]  SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Male, U",
        "CODE:13D01",
        "CALL:DIABETIC PROBLEM",
        "ADDR:5728 US 264A E",
        "MADDR:5728 US 264 ALT",
        "SRC:2C",
        "X:WOODSIDE RD & BIRDIE RD",
        "INFO:1. He is breathing normally. / SE: MEDIC & FR RESPONDER SCRIPT: 43 year old, Male, U",
        "DATE:07/20/13",
        "TIME:10:08:28");

    doTest("T12",
        "(Sanoca) ;10D01;CHEST PAIN;6916 SPEIGHT SCHOOL RD;2E;PANTHER BRANCH RD;NC 222; SE: MEDIC & FR RESPONDER SCRIPT: 22 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Not alert. Caller Statement: chest pain wife`s friend. 1. She is not completely aler",
        "CODE:10D01",
        "CALL:CHEST PAIN",
        "ADDR:6916 SPEIGHT SCHOOL RD",
        "SRC:2E",
        "X:PANTHER BRANCH RD & NC 222",
        "INFO:SE: MEDIC & FR RESPONDER SCRIPT: 22 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Not alert. Caller Statement: chest pain wife`s friend. 1. She is not completely aler");

    doTest("T13",
        "(Sanoca) ;60C01O;GAS LEAK OR ODOR;5740 US 264A E;2C;WOODSIDE RD;BIRDIE RD;[Fire Priority Info] Key Questions Complete RESPONSE: Charlie RESPONDER SCRIPT: 5. The gas is coming from: oven 6. No one is reportedly sick or injured. -Comments: oven- [07/18/13 18:35:30 MLAMM] [Fire Priority Update]",
        "CODE:60C01O",
        "CALL:GAS LEAK OR ODOR",
        "ADDR:5740 US 264A E",
        "MADDR:5740 US 264 ALT",
        "SRC:2C",
        "X:WOODSIDE RD & BIRDIE RD",
        "INFO:5. The gas is coming from: oven 6. No one is reportedly sick or injured. -Comments: oven-",
        "DATE:07/18/13",
        "TIME:18:35:30");

    doTest("T14",
        "(Sanoca) ;06D02;BREATHING PROBLEMS;6604 SPEIGHT SCHOOL RD;2D;GRIMSLEY STORE RD;PANTHER BRANCH RD;[Medical Priority Info] Key Questions Complete RESPONSE: MEDIC & FR RESPONDER SCRIPT: 3. She is not changing color. 4. She is clammy. 5. She does not have asthma. 6. N/A [07/16/13 22:09:09 MHAMM",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:6604 SPEIGHT SCHOOL RD",
        "SRC:2D",
        "X:GRIMSLEY STORE RD & PANTHER BRANCH RD",
        "INFO:3. She is not changing color. 4. She is clammy. 5. She does not have asthma. 6. N/A",
        "DATE:07/16/13",
        "TIME:22:09:09");

    doTest("T15",
        "(Sanoca) CAD:13001152;06D02;BREATHING PROBLEMS;6223 GOOD NEWS CHURCH RD;2A;NC 222;GUM POND RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 87 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: FEMALE DIFF BREATHING . 1. She",
        "ID:13001152",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:6223 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:NC 222 & GUM POND RD",
        "INFO:87 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: FEMALE DIFF BREATHING . 1. She");

    doTest("T16",
        "(Sanoca) CAD:13001145;31D03;UNCONSCIOUS / FAINTING;7244 PINEY GROVE CHURCH RD;2A;GOOD NEWS CHURCH RD;GUM POND RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 60 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: FEELS LIKE EVERYTHING GOING BLA",
        "ID:13001145",
        "CODE:31D03",
        "CALL:UNCONSCIOUS / FAINTING",
        "ADDR:7244 PINEY GROVE CHURCH RD",
        "SRC:2A",
        "X:GOOD NEWS CHURCH RD & GUM POND RD",
        "INFO:60 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: FEELS LIKE EVERYTHING GOING BLA");

    doTest("T17",
        "(Sanoca) CAD:13001054;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pain going down left arm. 1. She is",
        "ID:13001054",
        "CODE:10D04",
        "CALL:CHEST PAIN",
        "ADDR:6910 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD",
        "INFO:43 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. Caller Statement: chest pain going down left arm. 1. She is");

    doTest("T18",
        "(Sanoca) CAD:13001052;17D03;FALLS;5104 WHITE OAK LOOP;2C;KENNEDY RD;US 264A E;[EMS] patient is really weak [06/25/13 21:06:27 RTSMITH] [Medical Priority Info] RESPONSE: MEDIC &amp; FR RESPONDER SCRIPT: 85 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: fall . 1. This happened now (les",
        "ID:13001052",
        "CODE:17D03",
        "CALL:FALLS",
        "ADDR:5104 WHITE OAK LOOP",
        "SRC:2C",
        "X:KENNEDY RD & US 264A E",
        "INFO:patient is really weak / 85 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: fall . 1. This happened now (les",
        "DATE:06/25/13",
        "TIME:21:06:27");

    doTest("T19",
        "(Sanoca) CAD:13001048;FIRE ALARM 1;5637 US 264A E;WHITES SIDING CO;2C;SECOND RD;WOODSIDE RD",
        "ID:13001048",
        "CALL:FIRE ALARM 1",
        "ADDR:5637 US 264A E",
        "MADDR:5637 US 264 ALT",
        "SRC:WHITES SIDING CO",
        "INFO:2C / SECOND RD / WOODSIDE RD");

    doTest("T20",
        "(Sanoca) CAD:13001023;52B01S;FIRE ALARM 1;4317 KENT RD;4C;JONES RD;TARTTS MILL RD;[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: residental fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3.",
        "ID:13001023",
        "CODE:52B01S",
        "CALL:FIRE ALARM 1",
        "ADDR:4317 KENT RD",
        "SRC:4C",
        "X:JONES RD & TARTTS MILL RD",
        "INFO:Alarms. Residential (single) (Smoke detector).Caller Statement: residental fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3.");

    doTest("T21",
        "(Sanoca) CAD:13001013;10C02;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;GAVE OUT ON WCSO AND WPD [06/18/13 12:49:46 SBEST] [Medical Priority Info]",
        "ID:13001013",
        "CODE:10C02",
        "CALL:CHEST PAIN",
        "ADDR:6910 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD",
        "INFO:GAVE OUT ON WCSO AND WPD",
        "DATE:06/18/13",
        "TIME:12:49:46");

    doTest("T22",
        "(Sanoca) CAD:13001010;06D02;BREATHING PROBLEMS;7109 MAIN ST;2E;SHACKLEFORD ST;US 264A E;[Medical Priority Info]",
        "ID:13001010",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7109 MAIN ST",
        "SRC:2E",
        "X:SHACKLEFORD ST & US 264A E");

    doTest("T23",
        "(Sanoca) CAD:13000979;ELECTRICAL HAZARD 1;6719 CHURCH ST;2E;REBECCA ST;ROGERS ST;Aborted by Fire Priority with code: Help arrived [06/13/13 18:48:15 CCADY] ELECTRICAL BOX ON SIDE OF HOUSE ARCHING [06/13/13 18:48:01 CCADY]",
        "ID:13000979",
        "CALL:ELECTRICAL HAZARD 1",
        "ADDR:6719 CHURCH ST",
        "SRC:2E",
        "X:REBECCA ST & ROGERS ST",
        "INFO:Aborted by Fire Priority with code: Help arrived / ELECTRICAL BOX ON SIDE OF HOUSE ARCHING",
        "DATE:06/13/13",
        "TIME:18:48:15");

    doTest("T24",
        "(Sanoca) CAD:13000968;10D04;CHEST PAIN;6910 GOOD NEWS CHURCH RD;2A;PINEY GROVE CHURCH RD;HOLDENS CROSS RD;[Medical Priority Info]",
        "ID:13000968",
        "CODE:10D04",
        "CALL:CHEST PAIN",
        "ADDR:6910 GOOD NEWS CHURCH RD",
        "SRC:2A",
        "X:PINEY GROVE CHURCH RD & HOLDENS CROSS RD");

    doTest("T25",
        "(Sanoca) CAD:13000965;TRAFFIC / TRANSPORTATION ACC;53 US 264 E;2D;US 264A E;NC 222;[EMS] another call [06/12/13 13:47:24 MLAMM] gray truck flipped over.....caller was a paserby 29-d-2 [06/12/13 13:47:09 WWORRELLS]",
        "ID:13000965",
        "CALL:TRAFFIC / TRANSPORTATION ACC",
        "ADDR:53 US 264 E",
        "MADDR:53 US 264 ALT",
        "SRC:2D",
        "X:US 264A E & NC 222",
        "INFO:another call / gray truck flipped over.....caller was a paserby 29-d-2",
        "DATE:06/12/13",
        "TIME:13:47:24");

  }
  

  public static void main(String[] args) {
    new NCWilsonCountyParserTest().generateTests("T1");
  }
}
