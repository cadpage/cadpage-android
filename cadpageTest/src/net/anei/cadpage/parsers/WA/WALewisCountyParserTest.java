package net.anei.cadpage.parsers.WA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lewis County, WA
Contact: Active911
Agency name: Lewis County Fire District 5
Location: Napavine, WA, United States
Sender: dispatch@lewiscountywa.gov

FD05_;fipo; 11/23/12 20:18:44; Fire -Brush; Jackson Hwy & State Route 508; north side of the road on hwy 508 about 50 ft from jackson hwy,  line of fire\nabout 25 ft long \n; [D00900820] - AlarmMessenger
FD05_;fipo; 11/23/12 11:55:03; Sickness; 292 S Prairie Rd; bls sickness 75 yoa male conc and breathing normal. disconnected illeostomy bag\n; [D00900752] - AlarmMessenger
FD05_;fipo; 11/23/12 00:36:06; Head Pain; Exit 74 NB Off; ALS SICKNESS  27 YOM   ALMOST LIKE AN ANXIETY ATTACK  \nHEAD PAIN AND NOT FEELING RIGHT\nPULLED OFF EXIT 74 OFF RAMP \n; [D00900693] - AlarmMessenger
FD05_;fipo; 11/22/12 16:47:31; Breathing; 144 Wind River Dr; als diff breathing h/o copd 80 yof no loc \n; [D00900630] - AlarmMessenger
FD05_;fipo; 11/22/12 01:40:34; Diabetic Prob; 1517 Highway 603; als low blood sugar...27...alt loc 37 yom \n; [D00900526] - AlarmMessenger
FD05_;fipo; 11/21/12 20:48:30; 882 Accident; 7000 I 5 NB; MP 70; ALS 2 VEH ACCIDENT, UNKN IF INJ, VEH ON TOP OF BARRIER FACING SB LANE\n; [D00900441] - AlarmMessenger
FD05_;fipo; 11/21/12 18:40:17; Head Pain; 133 Hilley Dr; als head pain, 80 yr fem, right arm and hand are numb\n; [D00900395] - AlarmMessenger
FD05_;fipo; 11/21/12 13:56:11; Breathing; 116 US Highway 12; Am pm hy 12;ampm; als diff breathing, 25 yom; [D00900340] - AlarmMessenger
FD05_;fipo; 11/20/12 10:48:14; Unconsciousness; 404 4th Ave NE; NAPAVINE HIGH SCHOOL; ALS UNCON \n10:49:04 11/20/2012 - Brockmueller L\n15 YOM..  \n10:49:20 11/20/2012 - Brockmueller L\nIS NOW CONC.   \n10:49:26 11/20/2012 - Brockmueller L\nIN THE OFFICE NOW..; [D00900076] - AlarmMessenger
FD05_;fipo; 11/19/12 15:45:21; 882 Accident; 6820 I 5 NB; MP 68; ALS UNK IF INJ ACCIDENT.  VEH INTO THE WALL..   MP 68 - 69 \n15:46:14 11/19/2012 - Brockmueller L\n1/2 MILE S OF MP 69..   \n15:46:18 11/19/2012 - Brockmueller L\nWHI CAR; [D00899892] - AlarmMessenger
FD05_;fipo; 11/19/12 12:47:32; Fire -Other; 178 Haight Rd; trees with power lines down.  Dist 5 on scene.; [D00899831] - AlarmMessenger
FD05_;fipo; 11/19/12 12:37:35; Fire -Other; 240 Haight Rd; SERVICE CALL.   ELECTRICAL PROBLEM; [D00899826] - AlarmMessenger
FD05_;fipo; 11/19/12 12:33:31; Fire -Other; 200 Haywire Rd; req for run#  trees down.; [D00899825] - AlarmMessenger
FD05_;fipo; 11/19/12 11:07:42; Fire -Other; Jackson Hwy & Koontz Rd; trees across power line   arcing   trees partially blking rdway; [D00899792] - AlarmMessenger
FD05_;fipo; 11/19/12 08:46:45; Breathing; 117 Woodard Rd; ALS  47yr female,  resp dist.; [D00899753] - AlarmMessenger
FD05_;fipo; 11/19/12 06:51:38; Fire -Alarm Com; 150 North Star Dr; braun nw; com fire alarm..   west pull smoke        custom   op 50 800 752 2490; [D00899745] - AlarmMessenger
FD05_;fipo; 11/19/12 03:11:25; Fire -Alarm Res; 195 Holloway Dr; RESD FIRE ALARM - DINING ROOM - OP 677 W/PENIT  800 482 9800; [D00899736] - AlarmMessenger
FD05_;fipo; 11/19/12 00:01:58; Sickness; 121 Markum Ln; ALS UNK MED -; [D00899720] - AlarmMessenger
FD05_;fipo; 11/16/12 20:46:18; Trauma; 822 W Vine St; physical dispute\n20:45:47 11/16/2012 - Connor E Dis\nrp's mom poss has broken ribs...\n20:46:05 11/16/2012 - Connor E Dis\nsubj slammed the door on the female\n20:46:12 11/16/2012 - Connor E Dis\nbls, poss broken ribs; [D00899303] - AlarmMessenger
FD05_;fipo; 11/16/12 20:06:34; Sickness; 389 Raubuck Rd; ALS, ANXIETY ATTACK, FEMALE KEEPS CALLING 911 "MOM"\n20:08:12 11/16/2012 - Yund J Dis\nRP ADV SHE IS 2 YOA HOWEVER SOUNDS LIKE AN ADULT FEMALE, IS NOT USING TODAY,\nUSED ABOUT A WEEK AGO\n20:08:28 11/16/2012 - Yund J Dis\nRP ADV HER FRIEND IS THERE\n20:08:37 11/16/2012 - Yund J Dis\nNOW HAVE THE FRIEND ON THE LINE; [D00899297] - AlarmMessenger
FD05_;fipo; 11/16/12 02:46:42; Sickness; 3047 Jackson Hwy; bls, breathing is fine/cons alert son having problems with a tooth\n02:47:06 11/16/2012 - Connor E Dis\n24 yom...arms and legs are moving on there own; [D00899127] - AlarmMessenger
FD05_;fipo; 11/15/12 05:50:10; Diabetic Prob; 907 W Grand Blvd; ALS, DIABETIC, BLOOD SUGAR IS 39 , 63 YOF; [D00898929] - AlarmMessenger
FD05_;fipo; 11/14/12 11:27:10; Breathing; 3149 Jackson Hwy; SAFE FAMILY MINISTRY; ALS DIFF BREATHING - 63YOF, NO LOC, VERY SLEEPY -- COME IN THE DRIVEWAY, STAY TO\nTHE RIGHT - IN THE PACE ARROW MOTORHOME BEHIND THE\nBUILDING \n11:27:42 11/14/2012 - Pense T Dis\n5M2; [D00898800] - AlarmMessenger
FD05_;fipo; 11/14/12 02:44:25; Fire -Alarm Com; 400 2nd Ave SE; Lumber mill; one of the box on fire flames seen; [D00898742] - AlarmMessenger
FD05_;fipo; 11/13/12 10:52:23; Sickness; 1033 Chieri Ct; als sickness, 57 yom, pale, sweating, cons; [D00898587] - AlarmMessenger
FD05_;fipo; 11/12/12 22:44:17; Sickness; 104 Villageway Dr; 911 hangup fast busy signal; on callback spoke w/male subj said he had a scare\nwith his wife, but she appears to be fine now, rp adv she was sleeping and rp\nthought she was talking in her sleep. now thinks needs aid to ck her out...63\nyof, no diff breathing no loc just wasn't normal for her; [D00898507] - AlarmMessenger
FD05_;fipo; 11/12/12 18:00:42; Fire -Other; Rosebrook Rd & Middle Fork Rd; ROSEBROOK OFF MIDDLEFORK HUGE FIRE TO THE EAST, NOT BONFIRE HUGE GLOWING YELLOW,\nGLOWING IN SKY COULDN'T GET RP TO GUESS HOW BIG, LOOKS LIKE 2 FIRES \n18:01:23 11/12/2012 - Rodocker D Sup \nON ROSEBROOK SEEN FROM MIDDLEFORK; [D00898453] - AlarmMessenger
FD05_;fipo; 11/11/12 17:23:16; Vomiting; 1214 Koontz Rd; bls vomitting \n17:23:42 11/11/2012 - Phillips L Dis\n89 yof cons/ breathing normally; [D00898288] - AlarmMessenger
FD05_;fipo; 11/11/12 10:37:24; Chest Pain; 4224 Jackson Hwy; als chest pains, jackson prairie church.; [D00898227] - AlarmMessenger
FD05_;fipo; 11/10/12 20:53:51; 882 Accident; 600 US Highway 12; MP 69; ALS, UNK DETAIL COLLISON, \n20:54:42 11/10/2012 - Yund J Dis\nVEH IS IN THE BAR DITCH, VEH-SMALLER, NO FUTHER INFO \n20:55:27 11/10/2012 - Yund J Dis     \nSTATE ADV; [D00898149] - AlarmMessenger

Agency name: Lewis County Fire Dist 6
Location: Chehalis, WA, United States
Contact: Active911
Sender: dispatch@lewiscountywa.gov

FD6B_;fipo; 11/23/12 23:44:23; Breathing; 110 Brockway Rd; als, dif breathing \n; [D00900848] - AlarmMessenger
FD6B_;fipo; 11/21/12 11:03:46; Breathing; 108 Elm View Ave; als passed out poss\n11:04:44 11/21/2012 - Phillips L Dis\nshe had not breathing for a moment & was uncon but now conw/ \n11:05:03 11/21/2012 - Phillips L Dis\ncons/ alt loc; [D00900301] - AlarmMessenger
FD6A_;fipo; 11/21/12 09:35:06; Fall; 1795 Bishop Rd; als fall patient; unresponsive \n09:35:42 11/21/2012 - OConner J Dis\nfell to the floor, now trying to talk, bp 89/54 \n09:36:07 11/21/2012 - OConner J Dis\nbreathing ok, on floor unable to get him up; [D00900285] - AlarmMessenger
FD6B_;fipo; 11/20/12 12:54:17; Bleeding; 779 Highway 603; als  nose bleed; [D00900106] - AlarmMessenger
FD6A_;fipo; 11/20/12 06:52:55; Fire -Other; Jackson Hwy & Rush Rd; smell of propane in the area of ferrill gas   check area; [D00900032] - AlarmMessenger
FD6B_;fipo; 11/19/12 15:11:08; Fire -Other; 100 Logan Hill Rd; chim fire, on logan hill rd. 3rd or 4th houses up from mary mccranks.; [D00899882] - AlarmMessenger
FD6A_;fipo; 11/18/12 20:07:22; 882 Accident; Exit 74 SB Off; ALS ONE VEH UNK INJ COLLISION - DRK COLORED PC - ITS DOWN BY THE FENCE - WILL BE\nON THE RIGHT SIDE OF THE RAMP; [D00899697] - AlarmMessenger
FD6A_;fipo; 11/18/12 17:34:23; Fire -Other; Exit 74 SB On; veh fire .. from the haybales.. 06 ford escape; [D00899650] - AlarmMessenger
FD6B_;fipo; 11/18/12 15:26:00; Suicide-Attempt; Devereese Rd & Shorey Rd; trooper saying out with suicide, no further.; [D00899623] - AlarmMessenger
FD6B_;fipo; 11/18/12 13:29:06; Stroke; 934 Logan Hill Rd; als poss stroke .. passed out in the hall .. pt is conc and talking now .. 80\nyoa male; [D00899603] - AlarmMessenger

*/

public class WALewisCountyParserTest extends BaseParserTest {
  
  public WALewisCountyParserTest() {
    setParser(new WALewisCountyParser(), "LEWIS COUNTY", "WA");
  }
  
  @Test
  public void testLewisCountyFireDist6() {

    doTest("T1",
        "FD05_;fipo; 11/23/12 20:18:44; Fire -Brush; Jackson Hwy & State Route 508; north side of the road on hwy 508 about 50 ft from jackson hwy,  line of fire\n" +
        "about 25 ft long \n" +
        "; [D00900820] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/23/12",
        "TIME:20:18:44",
        "CALL:Fire -Brush",
        "ADDR:Jackson Hwy & State Route 508",
        "MADDR:Jackson Hwy & STATE 508",
        "INFO:north side of the road on hwy 508 about 50 ft from jackson hwy,  line of fire / about 25 ft long",
        "ID:D00900820");

    doTest("T2",
        "FD05_;fipo; 11/23/12 11:55:03; Sickness; 292 S Prairie Rd; bls sickness 75 yoa male conc and breathing normal. disconnected illeostomy bag\n" +
        "; [D00900752] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/23/12",
        "TIME:11:55:03",
        "CALL:Sickness",
        "ADDR:292 S Prairie Rd",
        "INFO:bls sickness 75 yoa male conc and breathing normal. disconnected illeostomy bag",
        "ID:D00900752");

    doTest("T3",
        "FD05_;fipo; 11/23/12 00:36:06; Head Pain; Exit 74 NB Off; ALS SICKNESS  27 YOM   ALMOST LIKE AN ANXIETY ATTACK  \n" +
        "HEAD PAIN AND NOT FEELING RIGHT\n" +
        "PULLED OFF EXIT 74 OFF RAMP \n" +
        "; [D00900693] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/23/12",
        "TIME:00:36:06",
        "CALL:Head Pain",
        "ADDR:Exit 74 NB Off",
        "MADDR:Exit 74 &",
        "INFO:ALS SICKNESS  27 YOM   ALMOST LIKE AN ANXIETY ATTACK / HEAD PAIN AND NOT FEELING RIGHT / PULLED OFF EXIT 74 OFF RAMP",
        "ID:D00900693");

    doTest("T4",
        "FD05_;fipo; 11/22/12 16:47:31; Breathing; 144 Wind River Dr; als diff breathing h/o copd 80 yof no loc \n" +
        "; [D00900630] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/22/12",
        "TIME:16:47:31",
        "CALL:Breathing",
        "ADDR:144 Wind River Dr",
        "INFO:als diff breathing h/o copd 80 yof no loc",
        "ID:D00900630");

    doTest("T5",
        "FD05_;fipo; 11/22/12 01:40:34; Diabetic Prob; 1517 Highway 603; als low blood sugar...27...alt loc 37 yom \n" +
        "; [D00900526] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/22/12",
        "TIME:01:40:34",
        "CALL:Diabetic Prob",
        "ADDR:1517 Highway 603",
        "INFO:als low blood sugar...27...alt loc 37 yom",
        "ID:D00900526");

    doTest("T6",
        "FD05_;fipo; 11/21/12 20:48:30; 882 Accident; 7000 I 5 NB; MP 70; ALS 2 VEH ACCIDENT, UNKN IF INJ, VEH ON TOP OF BARRIER FACING SB LANE\n" +
        "; [D00900441] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/21/12",
        "TIME:20:48:30",
        "CALL:882 Accident",
        "ADDR:7000 I 5 NB",
        "MADDR:7000 I 5",
        "INFO:MP 70 / ALS 2 VEH ACCIDENT, UNKN IF INJ, VEH ON TOP OF BARRIER FACING SB LANE",
        "ID:D00900441");

    doTest("T7",
        "FD05_;fipo; 11/21/12 18:40:17; Head Pain; 133 Hilley Dr; als head pain, 80 yr fem, right arm and hand are numb\n" +
        "; [D00900395] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/21/12",
        "TIME:18:40:17",
        "CALL:Head Pain",
        "ADDR:133 Hilley Dr",
        "INFO:als head pain, 80 yr fem, right arm and hand are numb",
        "ID:D00900395");

    doTest("T8",
        "FD05_;fipo; 11/21/12 13:56:11; Breathing; 116 US Highway 12; Am pm hy 12;ampm; als diff breathing, 25 yom; [D00900340] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/21/12",
        "TIME:13:56:11",
        "CALL:Breathing",
        "ADDR:116 US Highway 12",
        "MADDR:116 US 12",
        "INFO:Am pm hy 12 / ampm / als diff breathing, 25 yom",
        "ID:D00900340");

    doTest("T9",
        "FD05_;fipo; 11/20/12 10:48:14; Unconsciousness; 404 4th Ave NE; NAPAVINE HIGH SCHOOL; ALS UNCON \n" +
        "10:49:04 11/20/2012 - Brockmueller L\n" +
        "15 YOM..  \n" +
        "10:49:20 11/20/2012 - Brockmueller L\n" +
        "IS NOW CONC.   \n" +
        "10:49:26 11/20/2012 - Brockmueller L\n" +
        "IN THE OFFICE NOW..; [D00900076] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/20/2012",
        "TIME:10:49:26",
        "CALL:Unconsciousness",
        "ADDR:404 4th Ave NE",
        "INFO:NAPAVINE HIGH SCHOOL / ALS UNCON / 15 YOM.. / IS NOW CONC. / IN THE OFFICE NOW..",
        "ID:D00900076");

    doTest("T10",
        "FD05_;fipo; 11/19/12 15:45:21; 882 Accident; 6820 I 5 NB; MP 68; ALS UNK IF INJ ACCIDENT.  VEH INTO THE WALL..   MP 68 - 69 \n" +
        "15:46:14 11/19/2012 - Brockmueller L\n" +
        "1/2 MILE S OF MP 69..   \n" +
        "15:46:18 11/19/2012 - Brockmueller L\n" +
        "WHI CAR; [D00899892] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/19/2012",
        "TIME:15:46:18",
        "CALL:882 Accident",
        "ADDR:6820 I 5 NB",
        "MADDR:6820 I 5",
        "INFO:MP 68 / ALS UNK IF INJ ACCIDENT.  VEH INTO THE WALL..   MP 68 - 69 / 1/2 MILE S OF MP 69.. / WHI CAR",
        "ID:D00899892");

    doTest("T11",
        "FD05_;fipo; 11/19/12 12:47:32; Fire -Other; 178 Haight Rd; trees with power lines down.  Dist 5 on scene.; [D00899831] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:12:47:32",
        "CALL:Fire -Other",
        "ADDR:178 Haight Rd",
        "INFO:trees with power lines down.  Dist 5 on scene.",
        "ID:D00899831");

    doTest("T12",
        "FD05_;fipo; 11/19/12 12:37:35; Fire -Other; 240 Haight Rd; SERVICE CALL.   ELECTRICAL PROBLEM; [D00899826] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:12:37:35",
        "CALL:Fire -Other",
        "ADDR:240 Haight Rd",
        "INFO:SERVICE CALL.   ELECTRICAL PROBLEM",
        "ID:D00899826");

    doTest("T13",
        "FD05_;fipo; 11/19/12 12:33:31; Fire -Other; 200 Haywire Rd; req for run#  trees down.; [D00899825] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:12:33:31",
        "CALL:Fire -Other",
        "ADDR:200 Haywire Rd",
        "INFO:req for run#  trees down.",
        "ID:D00899825");

    doTest("T14",
        "FD05_;fipo; 11/19/12 11:07:42; Fire -Other; Jackson Hwy & Koontz Rd; trees across power line   arcing   trees partially blking rdway; [D00899792] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:11:07:42",
        "CALL:Fire -Other",
        "ADDR:Jackson Hwy & Koontz Rd",
        "INFO:trees across power line   arcing   trees partially blking rdway",
        "ID:D00899792");

    doTest("T15",
        "FD05_;fipo; 11/19/12 08:46:45; Breathing; 117 Woodard Rd; ALS  47yr female,  resp dist.; [D00899753] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:08:46:45",
        "CALL:Breathing",
        "ADDR:117 Woodard Rd",
        "INFO:ALS  47yr female,  resp dist.",
        "ID:D00899753");

    doTest("T16",
        "FD05_;fipo; 11/19/12 06:51:38; Fire -Alarm Com; 150 North Star Dr; braun nw; com fire alarm..   west pull smoke        custom   op 50 800 752 2490; [D00899745] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:06:51:38",
        "CALL:Fire -Alarm Com",
        "ADDR:150 North Star Dr",
        "INFO:braun nw / com fire alarm..   west pull smoke        custom   op 50 800 752 2490",
        "ID:D00899745");

    doTest("T17",
        "FD05_;fipo; 11/19/12 03:11:25; Fire -Alarm Res; 195 Holloway Dr; RESD FIRE ALARM - DINING ROOM - OP 677 W/PENIT  800 482 9800; [D00899736] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:03:11:25",
        "CALL:Fire -Alarm Res",
        "ADDR:195 Holloway Dr",
        "INFO:RESD FIRE ALARM - DINING ROOM - OP 677 W/PENIT  800 482 9800",
        "ID:D00899736");

    doTest("T18",
        "FD05_;fipo; 11/19/12 00:01:58; Sickness; 121 Markum Ln; ALS UNK MED -; [D00899720] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/19/12",
        "TIME:00:01:58",
        "CALL:Sickness",
        "ADDR:121 Markum Ln",
        "INFO:ALS UNK MED -",
        "ID:D00899720");

    doTest("T19",
        "FD05_;fipo; 11/16/12 20:46:18; Trauma; 822 W Vine St; physical dispute\n" +
        "20:45:47 11/16/2012 - Connor E Dis\n" +
        "rp's mom poss has broken ribs...\n" +
        "20:46:05 11/16/2012 - Connor E Dis\n" +
        "subj slammed the door on the female\n" +
        "20:46:12 11/16/2012 - Connor E Dis\n" +
        "bls, poss broken ribs; [D00899303] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/16/2012",
        "TIME:20:46:12",
        "CALL:Trauma",
        "ADDR:822 W Vine St",
        "INFO:physical dispute / rp's mom poss has broken ribs... / subj slammed the door on the female / bls, poss broken ribs",
        "ID:D00899303");

    doTest("T20",
        "FD05_;fipo; 11/16/12 20:06:34; Sickness; 389 Raubuck Rd; ALS, ANXIETY ATTACK, FEMALE KEEPS CALLING 911 \"MOM\"\n" +
        "20:08:12 11/16/2012 - Yund J Dis\n" +
        "RP ADV SHE IS 2 YOA HOWEVER SOUNDS LIKE AN ADULT FEMALE, IS NOT USING TODAY,\n" +
        "USED ABOUT A WEEK AGO\n" +
        "20:08:28 11/16/2012 - Yund J Dis\n" +
        "RP ADV HER FRIEND IS THERE\n" +
        "20:08:37 11/16/2012 - Yund J Dis\n" +
        "NOW HAVE THE FRIEND ON THE LINE; [D00899297] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/16/2012",
        "TIME:20:08:37",
        "CALL:Sickness",
        "ADDR:389 Raubuck Rd",
        "INFO:ALS, ANXIETY ATTACK, FEMALE KEEPS CALLING 911 \"MOM\" / RP ADV SHE IS 2 YOA HOWEVER SOUNDS LIKE AN ADULT FEMALE, IS NOT USING TODAY, / USED ABOUT A WEEK AGO / RP ADV HER FRIEND IS THERE / NOW HAVE THE FRIEND ON THE LINE",
        "ID:D00899297");

    doTest("T21",
        "FD05_;fipo; 11/16/12 02:46:42; Sickness; 3047 Jackson Hwy; bls, breathing is fine/cons alert son having problems with a tooth\n" +
        "02:47:06 11/16/2012 - Connor E Dis\n" +
        "24 yom...arms and legs are moving on there own; [D00899127] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/16/2012",
        "TIME:02:47:06",
        "CALL:Sickness",
        "ADDR:3047 Jackson Hwy",
        "INFO:bls, breathing is fine/cons alert son having problems with a tooth / 24 yom...arms and legs are moving on there own",
        "ID:D00899127");

    doTest("T22",
        "FD05_;fipo; 11/15/12 05:50:10; Diabetic Prob; 907 W Grand Blvd; ALS, DIABETIC, BLOOD SUGAR IS 39 , 63 YOF; [D00898929] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/15/12",
        "TIME:05:50:10",
        "CALL:Diabetic Prob",
        "ADDR:907 W Grand Blvd",
        "INFO:ALS, DIABETIC, BLOOD SUGAR IS 39 , 63 YOF",
        "ID:D00898929");

    doTest("T23",
        "FD05_;fipo; 11/14/12 11:27:10; Breathing; 3149 Jackson Hwy; SAFE FAMILY MINISTRY; ALS DIFF BREATHING - 63YOF, NO LOC, VERY SLEEPY -- COME IN THE DRIVEWAY, STAY TO\n" +
        "THE RIGHT - IN THE PACE ARROW MOTORHOME BEHIND THE\n" +
        "BUILDING \n" +
        "11:27:42 11/14/2012 - Pense T Dis\n" +
        "5M2; [D00898800] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/14/2012",
        "TIME:11:27:42",
        "CALL:Breathing",
        "ADDR:3149 Jackson Hwy",
        "INFO:SAFE FAMILY MINISTRY / ALS DIFF BREATHING - 63YOF, NO LOC, VERY SLEEPY -- COME IN THE DRIVEWAY, STAY TO / THE RIGHT - IN THE PACE ARROW MOTORHOME BEHIND THE / BUILDING / 5M2",
        "ID:D00898800");

    doTest("T24",
        "FD05_;fipo; 11/14/12 02:44:25; Fire -Alarm Com; 400 2nd Ave SE; Lumber mill; one of the box on fire flames seen; [D00898742] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/14/12",
        "TIME:02:44:25",
        "CALL:Fire -Alarm Com",
        "ADDR:400 2nd Ave SE",
        "INFO:Lumber mill / one of the box on fire flames seen",
        "ID:D00898742");

    doTest("T25",
        "FD05_;fipo; 11/13/12 10:52:23; Sickness; 1033 Chieri Ct; als sickness, 57 yom, pale, sweating, cons; [D00898587] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/13/12",
        "TIME:10:52:23",
        "CALL:Sickness",
        "ADDR:1033 Chieri Ct",
        "INFO:als sickness, 57 yom, pale, sweating, cons",
        "ID:D00898587");

    doTest("T26",
        "FD05_;fipo; 11/12/12 22:44:17; Sickness; 104 Villageway Dr; 911 hangup fast busy signal; on callback spoke w/male subj said he had a scare\n" +
        "with his wife, but she appears to be fine now, rp adv she was sleeping and rp\n" +
        "thought she was talking in her sleep. now thinks needs aid to ck her out...63\n" +
        "yof, no diff breathing no loc just wasn't normal for her; [D00898507] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/12/12",
        "TIME:22:44:17",
        "CALL:Sickness",
        "ADDR:104 Villageway Dr",   // Google says this is VILLAGE WAY DR
        "INFO:911 hangup fast busy signal / on callback spoke w/male subj said he had a scare / with his wife, but she appears to be fine now, rp adv she was sleeping and rp / thought she was talking in her sleep. now thinks needs aid to ck her out...63 / yof, no diff breathing no loc just wasn't normal for her",
        "ID:D00898507");

    doTest("T27",
        "FD05_;fipo; 11/12/12 18:00:42; Fire -Other; Rosebrook Rd & Middle Fork Rd; ROSEBROOK OFF MIDDLEFORK HUGE FIRE TO THE EAST, NOT BONFIRE HUGE GLOWING YELLOW,\n" +
        "GLOWING IN SKY COULDN'T GET RP TO GUESS HOW BIG, LOOKS LIKE 2 FIRES \n" +
        "18:01:23 11/12/2012 - Rodocker D Sup \n" +
        "ON ROSEBROOK SEEN FROM MIDDLEFORK; [D00898453] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/12/2012",
        "TIME:18:01:23",
        "CALL:Fire -Other",
        "ADDR:Rosebrook Rd & Middle Fork Rd",
        "INFO:ROSEBROOK OFF MIDDLEFORK HUGE FIRE TO THE EAST, NOT BONFIRE HUGE GLOWING YELLOW, / GLOWING IN SKY COULDN'T GET RP TO GUESS HOW BIG, LOOKS LIKE 2 FIRES / ON ROSEBROOK SEEN FROM MIDDLEFORK",
        "ID:D00898453");

    doTest("T28",
        "FD05_;fipo; 11/11/12 17:23:16; Vomiting; 1214 Koontz Rd; bls vomitting \n" +
        "17:23:42 11/11/2012 - Phillips L Dis\n" +
        "89 yof cons/ breathing normally; [D00898288] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/11/2012",
        "TIME:17:23:42",
        "CALL:Vomiting",
        "ADDR:1214 Koontz Rd",
        "INFO:bls vomitting / 89 yof cons/ breathing normally",
        "ID:D00898288");

    doTest("T29",
        "FD05_;fipo; 11/11/12 10:37:24; Chest Pain; 4224 Jackson Hwy; als chest pains, jackson prairie church.; [D00898227] - AlarmMessenger",
        "SRC:FD05",
        "DATE:11/11/12",
        "TIME:10:37:24",
        "CALL:Chest Pain",
        "ADDR:4224 Jackson Hwy",
        "INFO:als chest pains, jackson prairie church.",
        "ID:D00898227");

    doTest("T30",
        "FD05_;fipo; 11/10/12 20:53:51; 882 Accident; 600 US Highway 12; MP 69; ALS, UNK DETAIL COLLISON, \n" +
        "20:54:42 11/10/2012 - Yund J Dis\n" +
        "VEH IS IN THE BAR DITCH, VEH-SMALLER, NO FUTHER INFO \n" +
        "20:55:27 11/10/2012 - Yund J Dis     \n" +
        "STATE ADV; [D00898149] - AlarmMessenger",

        "SRC:FD05",
        "DATE:11/10/2012",
        "TIME:20:55:27",
        "CALL:882 Accident",
        "ADDR:600 US Highway 12",
        "MADDR:600 US 12",
        "INFO:MP 69 / ALS, UNK DETAIL COLLISON, / VEH IS IN THE BAR DITCH, VEH-SMALLER, NO FUTHER INFO / STATE ADV",
        "ID:D00898149");

  }
  
  @Test
  public void testLewisCountyFireDist5() {

    doTest("T1",
        "FD6B_;fipo; 11/23/12 23:44:23; Breathing; 110 Brockway Rd; als, dif breathing \n; [D00900848] - AlarmMessenger",
        "SRC:FD6B",
        "DATE:11/23/12",
        "TIME:23:44:23",
        "CALL:Breathing",
        "ADDR:110 Brockway Rd",
        "INFO:als, dif breathing",
        "ID:D00900848");

    doTest("T2",
        "FD6B_;fipo; 11/21/12 11:03:46; Breathing; 108 Elm View Ave; als passed out poss\n" +
        "11:04:44 11/21/2012 - Phillips L Dis\n" +
        "she had not breathing for a moment & was uncon but now conw/ \n" +
        "11:05:03 11/21/2012 - Phillips L Dis\n" +
        "cons/ alt loc; [D00900301] - AlarmMessenger",

        "SRC:FD6B",
        "DATE:11/21/2012",
        "TIME:11:05:03",
        "CALL:Breathing",
        "ADDR:108 Elm View Ave",
        "INFO:als passed out poss / she had not breathing for a moment & was uncon but now conw/ / cons/ alt loc",
        "ID:D00900301");

    doTest("T3",
        "FD6A_;fipo; 11/21/12 09:35:06; Fall; 1795 Bishop Rd; als fall patient; unresponsive \n" +
        "09:35:42 11/21/2012 - OConner J Dis\n" +
        "fell to the floor, now trying to talk, bp 89/54 \n" +
        "09:36:07 11/21/2012 - OConner J Dis\n" +
        "breathing ok, on floor unable to get him up; [D00900285] - AlarmMessenger",

        "SRC:FD6A",
        "DATE:11/21/2012",
        "TIME:09:36:07",
        "CALL:Fall",
        "ADDR:1795 Bishop Rd",
        "INFO:als fall patient / unresponsive / fell to the floor, now trying to talk, bp 89/54 / breathing ok, on floor unable to get him up",
        "ID:D00900285");

    doTest("T4",
        "FD6B_;fipo; 11/20/12 12:54:17; Bleeding; 779 Highway 603; als  nose bleed; [D00900106] - AlarmMessenger",
        "SRC:FD6B",
        "DATE:11/20/12",
        "TIME:12:54:17",
        "CALL:Bleeding",
        "ADDR:779 Highway 603",
        "INFO:als  nose bleed",
        "ID:D00900106");

    doTest("T5",
        "FD6A_;fipo; 11/20/12 06:52:55; Fire -Other; Jackson Hwy & Rush Rd; smell of propane in the area of ferrill gas   check area; [D00900032] - AlarmMessenger",
        "SRC:FD6A",
        "DATE:11/20/12",
        "TIME:06:52:55",
        "CALL:Fire -Other",
        "ADDR:Jackson Hwy & Rush Rd",
        "INFO:smell of propane in the area of ferrill gas   check area",
        "ID:D00900032");

    doTest("T6",
        "FD6B_;fipo; 11/19/12 15:11:08; Fire -Other; 100 Logan Hill Rd; chim fire, on logan hill rd. 3rd or 4th houses up from mary mccranks.; [D00899882] - AlarmMessenger",
        "SRC:FD6B",
        "DATE:11/19/12",
        "TIME:15:11:08",
        "CALL:Fire -Other",
        "ADDR:100 Logan Hill Rd",
        "INFO:chim fire, on logan hill rd. 3rd or 4th houses up from mary mccranks.",
        "ID:D00899882");

    doTest("T7",
        "FD6A_;fipo; 11/18/12 20:07:22; 882 Accident; Exit 74 SB Off; ALS ONE VEH UNK INJ COLLISION - DRK COLORED PC - ITS DOWN BY THE FENCE - WILL BE\n" +
        "ON THE RIGHT SIDE OF THE RAMP; [D00899697] - AlarmMessenger",

        "SRC:FD6A",
        "DATE:11/18/12",
        "TIME:20:07:22",
        "CALL:882 Accident",
        "ADDR:Exit 74 SB Off",
        "MADDR:Exit 74 &",
        "INFO:ALS ONE VEH UNK INJ COLLISION - DRK COLORED PC - ITS DOWN BY THE FENCE - WILL BE / ON THE RIGHT SIDE OF THE RAMP",
        "ID:D00899697");

    doTest("T8",
        "FD6A_;fipo; 11/18/12 17:34:23; Fire -Other; Exit 74 SB On; veh fire .. from the haybales.. 06 ford escape; [D00899650] - AlarmMessenger",
        "SRC:FD6A",
        "DATE:11/18/12",
        "TIME:17:34:23",
        "CALL:Fire -Other",
        "ADDR:Exit 74 SB On",
        "MADDR:Exit 74 On",
        "INFO:veh fire .. from the haybales.. 06 ford escape",
        "ID:D00899650");

    doTest("T9",
        "FD6B_;fipo; 11/18/12 15:26:00; Suicide-Attempt; Devereese Rd & Shorey Rd; trooper saying out with suicide, no further.; [D00899623] - AlarmMessenger",
        "SRC:FD6B",
        "DATE:11/18/12",
        "TIME:15:26:00",
        "CALL:Suicide-Attempt",
        "ADDR:Devereese Rd & Shorey Rd",
        "INFO:trooper saying out with suicide, no further.",
        "ID:D00899623");

    doTest("T10",
        "FD6B_;fipo; 11/18/12 13:29:06; Stroke; 934 Logan Hill Rd; als poss stroke .. passed out in the hall .. pt is conc and talking now .. 80\n" +
        "yoa male; [D00899603] - AlarmMessenger",

        "SRC:FD6B",
        "DATE:11/18/12",
        "TIME:13:29:06",
        "CALL:Stroke",
        "ADDR:934 Logan Hill Rd",
        "INFO:als poss stroke .. passed out in the hall .. pt is conc and talking now .. 80 / yoa male",
        "ID:D00899603");

  }
  
  public static void main(String[] args) {
    new WALewisCountyParserTest().generateTests("T1");
  }
}