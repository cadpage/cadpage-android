package net.anei.cadpage.parsers.MD;


import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Charles County, MD
Contact: Darrin Tomlinson <lackeychargers08@verizon.net>
Contact: Emmitt Newman <bigpickles25@gmail.com> ,3013998478@messaging.sprintpcs.com
Contact: Mark Kaufmann <markeng1trk@gmail.com>
System: Keystone
Sender: rc.263@c-msg.net

(*CAD*) [CAD] UNDETERMINED FIRE MIDDLETOWN RD / LYLES PL 3H11-9G1 CALLER LIVES ON CADWELL ST AND CAN SEE A LARGE FIRE THRU THE WOODS...UNSURE WHAT IT IS F103490
(*CAD*) [CAD] TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 3465 LAUREL DR 7 H3 65 year old, Female, Conscious, Breathing. Breathing Problems. Abnor
(*CAD*) [CAD] CO DETECTOR, CARBON MONOXIDE, 8A 2204 JASON CT 7 K2 CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF. F103510001 1022578 02:01
(*CAD*) [CAD] UNKNOWN MEDICAL ALARM, EMS, BLS, 32B 3487 HIGHGROVE DR 8 H5 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown 
(*CAD*) [CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown n
(*CAD*) [CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 130 KALMIA CT 17 F6 DRYER ON FIRE / ADVISED TO GET OUT F103550006 1022816 12:07
Subject:*CAD*\n[CAD] GAS LEAK INSIDE\nA S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102
Subject:*CAD*\n[CAD] 10-50 PI EXTRICATION, TRAPPED, PINNED, EMS, ALS, 29B, 29D 9275 IRONSIDES RD RT 425, MT HOPE ELEM SCHOOL A/O 23 H4-
Subject:*CAD*\n[CAD] GAS LEAK\nINSIDE A S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102
Subject:*CAD*\n[CAD] 10-50 PI FIRE EMS APPARATUS TRUCK AMBULANCE HAWTHORNE RD / MANOR LA 15 J3 10-17 ADV SHE WAS ASSAULTED BY HER FRIEN
Subject:*CAD*\n[CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Bre
Subject:*CAD*\n[CAD] COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG, 4975 HAWTHORNE RD, PENNYS TAVERN NEXT TO 7 C7 NEXT TO BLDG, CHILD CARE
Subject:*CAD*\n[CAD] UNDETERMINED FIRE INNSBRUCK CT / MASONS SPRING RD 14 K7 CALLER REPORTING LARGE FIRE VISIBLE A/F INNBRUCK CT,UNK WH
Subject:*CAD*\n[CAD] 10-50 PI MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D RIPLEY RD, 2 MILES FROM ANNAPOLIS WOODS RD 15 F6 Age u
Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 1 HICKORY LN, APT #307 17 G6 CALLER ADVISED HAS ODOR OF SMOKE
Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 28 FAIRHILL LN 6 H6 ODER OF SMOKE IN EQUIPMENT ROOM. F10338000
Subject:*CAD*\n[CAD] AFA - SINGLE FAMILY DWELLING, FIRE ALARM, S/F HOUSE 6445 MASON SPRINGS RD 15 A4 HALLWAY S/D, PHONE WAS PUT DOWN, N

(*CAD*) [CAD] ASSIST THE AMBULANCE, MISC 10200 LA PLATA RD (RT 488), CCNH 109B 17 H6-K4 NEEDED FOR MANPOWER F110610005 1103803 11:10

Contact: JLM <akgnome@yahoo.com>
Sender: ems12alerting-bounces@sms.mdfiretech.com
10-50 PI MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D LEONARDTOWN RD / BILLINGSLEY RD 11 B8 Age unknown, Male, Conscious, Breathing.

Contact: Jason Brooks <jason.w.brooks2@gmail.com>
Sender: dispatch@ccso.us
TREE DOWN, MISC ROCK POINT RD / CEDAR LA 36 H5 TREE ACROSS ENTIRE RDWY F111240003 1107622 06:14
ANIMAL BITE, ATTACK , EMS ,BLS 3A, 3B 17971 CYPRESS DR 38 G4 3 year old, Male, Conscious, Breathing. Animal Bites / Attacks. SERIOUS hemorrhage. E111180034 1107296
FILL IN, MISCELLANEOUS TRANSFER 9765 BEL ALTON NEWTOWN RD, STATION 10 26 D6-F4 F111180003 1107250 05:19
DETACHED SHED / GARAGE FIRE 10855 CHARLES ST, BURCHS GARAGE 17 K12 OUT OF CONTROL BRUSH FIRE..DEPUTY FLICK ON SCENE F111180002 1107249 06:00
10-50 UNDETERMINED, EMS, BLS 29A SWAN POINT RD / ROCK PT RD 36 G11 ACCIDENT IS ON ROCK PT RD IAO SWAN PT RD, UNKNOWN INJURIES, SINGLE VEH INTO TELEPHONE POLE E1107[Class 1,2 & 3 days] ROCK POINT RD / DELOZIER FARM RD 34 A13 CALLER ADVISED FIRE IN FIELD SOMEONE IS TRYING TO PUT IT OUT F110710003 11044
MALFUNCTION ALARM 15224 POTOMAC RIVER DR 37 F3 SMOKE DETECTOR SOUNDING AND DOESN'T KNOW WHY. SEES NO SMOKE OR FIRE F122500008 1216155 10:30

Contact: Donald simms <fire_freak74@yahoo.com>, 2403461358@vtext.com
STRUC, ODOR OF SMOKE - NO FIRE, M/F DWELLING, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING KG COUNTY, 16257 DALGREN RD
BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days) CHARLES ST / COOKSEY RD 27 E1 GRASS ON FIRE  F111260014 this is donnie from Charles county md
10-50 PI, EMS, BLS, 29A FAULKNER RD / CRAIN HWY 26 D8 19 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Unknown sta
BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days) CHARLES ST / COOKSEY RD 27 E1 GRASS ON FIRE POSSIBLY WIRES DOWN F111260014 1107782 16:49 
FILL IN, MISCELLANEOUS TRANSFER 911 WASHINGTON AVE, STATION 1 17 E3-E4 ENGINE TO STATION 1 F111300021 1108052 19:50

Contact: Larry Johnson <LarryJ@csmd.edu>
Sender: Postmaster@ihvfd.com
HEMORRHAGE, NOSEBLEED, EMS, LACERATION BLS, 21A, 21B 28 GLYMONT RD 7 B6 89 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. Blood thinner

Contact: Sam Smith <noschool8167@yahoo.com>
Sender: WVFD EMS 12
 1 of 2\nFRM:WVFD EMS 12 \nMSG:ASSAULT, SEXUAL ASSAULT, EMS, BLS, 4A, 4B 3300 MIDDLETOWN RD, WESTLAKE HIGH BY TRACK 9 G1-F3 STAGE WELL IN AREA...\n(Con't) 2 of 2\nE112990016 1119562 12:33\n(End)
 1 of 2\nFRM:WVFD EMS 12 \nMSG:CHEST PAINS, EMS, ALS, 10C, 10D 5903 PUMPKINSEED CT 9 F7 81 year old, Female, Conscious, Breathing. Chest Pain\n(Con't) 2 of 2\n(Non-Traumatic). Heart attack or angina history. E112990015 1119561 12:05\n(End)
 1 of 2\nFRM:WVFD EMS 12 \nMSG:HEMORRHAGE, LACERATIONS, EMS ALS, 21C, 21D 1 MAGNOLIA DR, GENESIS LAPLATA RM 135 BED B 17 D5 78 year old, Female,\n(Con't) 2 of 2\nConscious, Breathing. Hemorrhage / Lacerations. DANGEROUS hemorrhage. E112990012 1119557 10:52\n(End)

Contact: Louis Ramer <wvfdems12b@gmail.com>
Sender: ems3alerting-bounces@sms.mdfiretech.com
GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY 12421 TURTLE DOVE PL 10 K4 ODOR OF GAS INSIDE,HOUSE IS EVACUATED F120080006 1200424
CHEST PAINS, EMS, ALS, 10C, 10D 3012 PALMER PL, APT F 10 E6 1. 47 year old, Female, Conscious, Breathing. E120080019 1200423 14:03
TRAUMATIC INJURY, EMS, BLS, 30A, 30B 2501 REGAL PL 4 F11 WILL ADVISE MORE IN A MINUTE.... E120080018 1200422 13:22
CHOKING, EMS, ALS, 11D 70 VILLAGE ST, NURSES OFFICE 3RD FLOOR 10 F6 1. 87 year old, Male, Conscious, Breathing. E120080017 1200421 13:21
SICK PERSON, EMS, ALS, 26C, 26D 3135 FLANDERS CT 10 H4 1. 66 year old, Male, Conscious, Breathing. E120080015 1200419 12:33
STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE 1504 BRYAN CT 10 F7 PROBLEMS WITH THE FIRE PLACE / SMIKE IN THE RESIDENCE F120080005 12
SICK PERSON, EMS, ALS, 26C, 26D MALL CIR, VAN GO BUS 702 10 C3 Age unknown, female, conscious, breathing. E120100069 1200551 18:24
TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 2547 MATTAWOMAN BEANTOWN RD 5 A12 81-year-old, female, conscious, breathing. Calle
SICK PERSON, EMS, ALS, 26C, 26D 9559 PEP RALLY LN 3 C13 13-month-old, male, conscious, breathing. Caller Statement: NOT RESPONDING. E120100
CHEST PAINS, EMS, ALS, 10C, 10D 12171 ELL LN, APT61 10 H4 42-year-old, female, conscious, breathing. Caller Statement: CHEST. E120100048 120
TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 402 GARNER AVE 10 B6 45-year-old, female, conscious, breathing. Caller Statement:

Contact: "rogersonjg@gmail.com" <rogersonjg@gmail.com>
Sender: fire12alerting-bounces@sms.mdfiretech.com
STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS 2007 SMALLWOOD DR W, WESTLAKE DASH IN 10 A3 F121590013 1209
LANDING SITE, LZ, MISC 10956 BEECHWOOD CT 4 A10 SET UP LZ F121540011 1209461 12:34

Contact: Jason Brooks <jason.w.brooks2@gmail.com>
Sender: dispatch@ccso.us
MALFUNCTION ALARM 15224 POTOMAC RIVER DR 37 F3 SMOKE DETECTOR SOUNDING AND DOESN'T KNOW WHY. SEES NO SMOKE OR FIRE F122500008 1216155 10:30

Contact: Charlie Allison <charlie@mleostorch.com>
Sender: rc.263@c-msg.net
DIABETIC ALS PG COUNTY, 1014 BOHAC LN 2 H12 E132250043 1314804 21:40\r\n

 */

public class MDCharlesCountyAParserTest extends BaseParserTest {
  
  public MDCharlesCountyAParserTest() {
    setParser(new MDCharlesCountyAParser(), "CHARLES COUNTY", "MD");
  }
  
  @Test
  public void badMsg() {
    doBadTest("Body:(Buddy White Co 7 died this morning. Arrangements ...) Buddy White Co 7 died this morning. Arrangements will follow.");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(*CAD*) [CAD] UNDETERMINED FIRE MIDDLETOWN RD / LYLES PL 3H11-9G1 CALLER LIVES ON CADWELL ST AND CAN SEE A LARGE FIRE THRU THE WOODS...UNSURE WHAT IT IS F103490",
        "CALL:UNDETERMINED FIRE",
        "ADDR:MIDDLETOWN RD & LYLES PL");

    doTest("T2",
        "(*CAD*) [CAD] TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 3465 LAUREL DR 7 H3 65 year old, Female, Conscious, Breathing. Breathing Problems. Abnor",
        "CALL:TROUBLE BREATHING, RESPIRATORY DISTRESS",
        "UNIT:EMS, ALS, 6C, 6D",
        "ADDR:3465 LAUREL DR",
        "MAP:7 H3",
        "INFO:65 year old, Female, Conscious, Breathing. Breathing Problems. Abnor");

    doTest("T3",
        "(*CAD*) [CAD] CO DETECTOR, CARBON MONOXIDE, 8A 2204 JASON CT 7 K2 CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF. F103510001 1022578 02:01",
        "CALL:CO DETECTOR, CARBON MONOXIDE",
        "UNIT:8A",
        "ADDR:2204 JASON CT",
        "MAP:7 K2",
        "INFO:CALLER ADVISED HIS BSMT CO DETECTOR IS GOING OFF.",
        "ID:F103510001-1022578",
        "TIME:02:01");

    doTest("T4",
        "(*CAD*) [CAD] UNKNOWN MEDICAL ALARM, EMS, BLS, 32B 3487 HIGHGROVE DR 8 H5 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown",
        "CALL:UNKNOWN MEDICAL ALARM",
        "UNIT:EMS, BLS, 32B",
        "ADDR:3487 HIGHGROVE DR",
        "MAP:8 H5",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown");

    doTest("T5",
        "(*CAD*) [CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown n",
        "CALL:10-50 PI",
        "UNIT:EMS, BLS, 29A",
        "ADDR:HAWTHORNE RD & CHICAMUXEN RD",
        "MAP:7 F11",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown n");

    doTest("T6",
        "(*CAD*) [CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 130 KALMIA CT 17 F6 DRYER ON FIRE / ADVISED TO GET OUT F103550006 1022816 12:07",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:130 KALMIA CT",
        "MAP:17 F6",
        "INFO:DRYER ON FIRE / ADVISED TO GET OUT",
        "ID:F103550006-1022816",
        "TIME:12:07");

    doTest("T7",
        "Subject:*CAD*\n[CAD] GAS LEAK INSIDE\nA S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102",
        "CALL:GAS LEAK INSIDE A S/F SINGLE FAMILY DWELLING",
        "ADDR:5748 OAK CT",
        "MAP:7 E11",
        "INFO:SMELLS GAS INSIDE HOME AND IN GARAGE",
        "ID:F103640012-102");

    doTest("T8",
        "Subject:*CAD*\n[CAD] 10-50 PI EXTRICATION, TRAPPED, PINNED, EMS, ALS, 29B, 29D 9275 IRONSIDES RD RT 425, MT HOPE ELEM SCHOOL A/O 23 H4-",
        "CALL:10-50 PI EXTRICATION, TRAPPED, PINNED",
        "UNIT:EMS, ALS, 29B, 29D",
        "ADDR:9275 IRONSIDES RD RT 425",
        "PLACE:MT HOPE ELEM SCHOOL A/O",
        "MAP:23 H4",
        "INFO:-");

    doTest("T9",
        "Subject:*CAD*\n[CAD] GAS LEAK\nINSIDE A S/F SINGLE FAMILY DWELLING 5748 OAK CT 7 E11 SMELLS GAS INSIDE HOME AND IN GARAGE F103640012 102",
        "CALL:GAS LEAK INSIDE A S/F SINGLE FAMILY DWELLING",
        "ADDR:5748 OAK CT",
        "MAP:7 E11",
        "INFO:SMELLS GAS INSIDE HOME AND IN GARAGE",
        "ID:F103640012-102");

    doTest("T10",
        "Subject:*CAD*\n[CAD] 10-50 PI FIRE EMS APPARATUS TRUCK AMBULANCE HAWTHORNE RD / MANOR LA 15 J3 10-17 ADV SHE WAS ASSAULTED BY HER FRIEN",
        "CALL:10-50 PI FIRE",
        "UNIT:EMS APPARATUS TRUCK AMBULANCE",
        "ADDR:HAWTHORNE RD & MANOR LA",
        "MAP:15 J3",
        "INFO:10-17 ADV SHE WAS ASSAULTED BY HER FRIEN");

    doTest("T11",
        "Subject:*CAD*\n[CAD] 10-50 PI, EMS, BLS, 29A HAWTHORNE RD / CHICAMUXEN RD 7 F11 Age unknown, Gender unknown, Consciousness unknown, Bre",
        "CALL:10-50 PI",
        "UNIT:EMS, BLS, 29A",
        "ADDR:HAWTHORNE RD & CHICAMUXEN RD",
        "MAP:7 F11",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Bre");

    doTest("T12",
        "Subject:*CAD*\n[CAD] COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG, 4975 HAWTHORNE RD, PENNYS TAVERN NEXT TO 7 C7 NEXT TO BLDG, CHILD CARE",
        "CALL:COMMERCIAL BUILDING FIRE, STRUCTURE, BLDG",
        "ADDR:4975 HAWTHORNE RD",
        "PLACE:PENNYS TAVERN NEXT TO",
        "MAP:7 C7",
        "INFO:NEXT TO BLDG, CHILD CARE");

    doTest("T13",
        "Subject:*CAD*\n[CAD] UNDETERMINED FIRE INNSBRUCK CT / MASONS SPRING RD 14 K7 CALLER REPORTING LARGE FIRE VISIBLE A/F INNBRUCK CT,UNK WH",
        "CALL:UNDETERMINED FIRE",
        "ADDR:INNSBRUCK CT & MASONS SPRING RD",
        "MAP:14 K7",
        "INFO:CALLER REPORTING LARGE FIRE VISIBLE A/F INNBRUCK CT,UNK WH");

    doTest("T14",
        "Subject:*CAD*\n[CAD] 10-50 PI MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D RIPLEY RD, 2 MILES FROM ANNAPOLIS WOODS RD 15 F6 Age u",
        "CALL:10-50 PI",
        "UNIT:MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D",
        "ADDR:RIPLEY RD",
        "PLACE:2 MILES FROM ANNAPOLIS WOODS RD",
        "MAP:15 F6",
        "INFO:Age u");

    doTest("T15",
        "Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 1 HICKORY LN, APT #307 17 G6 CALLER ADVISED HAS ODOR OF SMOKE",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:1 HICKORY LN",
        "APT:#307",
        "MAP:17 G6",
        "INFO:CALLER ADVISED HAS ODOR OF SMOKE");

    doTest("T16",
        "Subject:*CAD*\n[CAD] MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT, 28 FAIRHILL LN 6 H6 ODER OF SMOKE IN EQUIPMENT ROOM. F10338000",
        "CALL:MULTI FAMILY HOUSE FIRE, TOWNHOUSE, M/F, APARTMENT",
        "ADDR:28 FAIRHILL LN",
        "MAP:6 H6",
        "INFO:ODER OF SMOKE IN EQUIPMENT ROOM. F10338000");

    doTest("T17",
        "Subject:*CAD*\n[CAD] AFA - SINGLE FAMILY DWELLING, FIRE ALARM, S/F HOUSE 6445 MASON SPRINGS RD 15 A4 HALLWAY S/D, PHONE WAS PUT DOWN, N",
        "CALL:AFA - SINGLE FAMILY DWELLING, FIRE ALARM, S/F HOUSE",
        "ADDR:6445 MASON SPRINGS RD",
        "MAP:15 A4",
        "INFO:HALLWAY S/D, PHONE WAS PUT DOWN, N");

    doTest("T18",
        "(*CAD*) [CAD] ASSIST THE AMBULANCE, MISC 10200 LA PLATA RD (RT 488), CCNH 109B 17 H6-K4 NEEDED FOR MANPOWER F110610005 1103803 11:10",
        "CALL:ASSIST THE",
        "UNIT:AMBULANCE, MISC",
        "ADDR:10200 LA PLATA RD (RT 488)",
        "MADDR:10200 LA PLATA RD",
        "PLACE:CCNH 109B",
        "MAP:17 H6-K4",
        "INFO:NEEDED FOR MANPOWER",
        "ID:F110610005-1103803",
        "TIME:11:10");
  
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "10-50 PI MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D LEONARDTOWN RD / BILLINGSLEY RD 11 B8 Age unknown, Male, Conscious, Breathing.",
        "CALL:10-50 PI",
        "UNIT:MOTORCYCLE, EMS, ALS, ATV, BICYCLE, BIKE, 29B, 29D",
        "ADDR:LEONARDTOWN RD & BILLINGSLEY RD",
        "MAP:11 B8",
        "INFO:Age unknown, Male, Conscious, Breathing.");

    doTest("T2",
        "TREE DOWN, MISC ROCK POINT RD / CEDAR LA 36 H5 TREE ACROSS ENTIRE RDWY F111240003 1107622 06:14",
        "CALL:TREE DOWN",
        "UNIT:MISC",
        "ADDR:ROCK POINT RD & CEDAR LA",
        "MAP:36 H5",
        "INFO:TREE ACROSS ENTIRE RDWY",
        "ID:F111240003-1107622",
        "TIME:06:14");

    doTest("T3",
        "ANIMAL BITE, ATTACK , EMS ,BLS 3A, 3B 17971 CYPRESS DR 38 G4 3 year old, Male, Conscious, Breathing. Animal Bites / Attacks. SERIOUS hemorrhage. E111180034 1107296",
        "CALL:ANIMAL BITE, ATTACK , EMS ,BLS",
        "UNIT:3A, 3B",
        "ADDR:17971 CYPRESS DR",
        "MAP:38 G4",
        "INFO:3 year old, Male, Conscious, Breathing. Animal Bites / Attacks. SERIOUS hemorrhage.",
        "ID:E111180034-1107296");

    doTest("T5",
        "FILL IN, MISCELLANEOUS TRANSFER 9765 BEL ALTON NEWTOWN RD, STATION 10 26 D6-F4 F111180003 1107250 05:19",
        "CALL:FILL IN, MISCELLANEOUS TRANSFER",
        "ADDR:9765 BEL ALTON NEWTOWN RD",
        "PLACE:STATION 10",
        "MAP:26 D6-F4",
        "ID:F111180003-1107250",
        "TIME:05:19");

    doTest("T6",
        "DETACHED SHED / GARAGE FIRE 10855 CHARLES ST, BURCHS GARAGE 17 K12 OUT OF CONTROL BRUSH FIRE..DEPUTY FLICK ON SCENE F111180002 1107249 06:00",
        "CALL:DETACHED SHED / GARAGE FIRE",
        "ADDR:10855 CHARLES ST",
        "PLACE:BURCHS GARAGE",
        "MAP:17 K12",
        "INFO:OUT OF CONTROL BRUSH FIRE..DEPUTY FLICK ON SCENE",
        "ID:F111180002-1107249",
        "TIME:06:00");

    doTest("T7",
        "10-50 UNDETERMINED, EMS, BLS 29A SWAN POINT RD / ROCK PT RD 36 G11 ACCIDENT IS ON ROCK PT RD IAO SWAN PT RD, UNKNOWN INJURIES, SINGLE VEH INTO TELEPHONE POLE E1107[Class 1,2 & 3 days] ROCK POINT RD / DELOZIER FARM RD 34 A13 CALLER ADVISED FIRE IN FIELD SOMEONE IS TRYING TO PUT IT OUT F110710003 11044",
        "CALL:10-50 UNDETERMINED",
        "UNIT:EMS, BLS 29A",
        "ADDR:SWAN POINT RD & ROCK PT RD",
        "MAP:36 G11",
        "INFO:ACCIDENT IS ON ROCK PT RD IAO SWAN PT RD, UNKNOWN INJURIES, SINGLE VEH INTO TELEPHONE POLE E1107[Class 1,2 & 3 days] ROCK POINT RD / DELOZIER FARM RD 34 A13 CALLER ADVISED FIRE IN FIELD SOMEONE IS TRYING TO PUT IT OUT",
        "ID:F110710003-11044");

    doTest("T8",
        "STRUC, ODOR OF SMOKE - NO FIRE, M/F DWELLING, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING KG COUNTY, 16257 DALGREN RD",
        "CALL:STRUC, ODOR OF SMOKE - NO FIRE, M/F DWELLING, TOWNHOUSE, APARTMENT, COMMERCIAL BLDG, MULTI FAMILY HOUSE, BUILDING KG COUNTY",
        "ADDR:16257 DALGREN RD");

    doTest("T9",
        "BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days) CHARLES ST / COOKSEY RD 27 E1 GRASS ON FIRE  F111260014 this is donnie from Charles county md",
        "CALL:BRUSH, WOODS, FIELD FIRE (Class 1, 2 & 3 days)",
        "ADDR:CHARLES ST & COOKSEY RD",
        "MAP:27 E1",
        "INFO:GRASS ON FIRE  F111260014 this is donnie from Charles county md");

    doTest("T10",
        "10-50 PI, EMS, BLS, 29A FAULKNER RD / CRAIN HWY 26 D8 19 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Unknown sta",
        "CALL:10-50 PI",
        "UNIT:EMS, BLS, 29A",
        "ADDR:FAULKNER RD & CRAIN HWY",
        "MAP:26 D8",
        "INFO:19 year old, Female, Conscious, Breathing. Traffic / Transportation Incidents. Unknown sta");

    doTest("T11",
        "BRUSH, WOODS, FIELD FIRE (Class 1,2 & 3 days) CHARLES ST / COOKSEY RD 27 E1 GRASS ON FIRE POSSIBLY WIRES DOWN F111260014 1107782 16:49",
        "CALL:BRUSH, WOODS, FIELD FIRE (Class 1, 2 & 3 days)",
        "ADDR:CHARLES ST & COOKSEY RD",
        "MAP:27 E1",
        "INFO:GRASS ON FIRE POSSIBLY WIRES DOWN",
        "ID:F111260014-1107782",
        "TIME:16:49");

    doTest("T12",
        "FILL IN, MISCELLANEOUS TRANSFER 911 WASHINGTON AVE, STATION 1 17 E3-E4 ENGINE TO STATION 1 F111300021 1108052 19:50",
        "CALL:FILL IN, MISCELLANEOUS TRANSFER",
        "ADDR:911 WASHINGTON AVE",
        "PLACE:STATION 1",
        "MAP:17 E3-E4",
        "INFO:ENGINE TO STATION 1",
        "ID:F111300021-1108052",
        "TIME:19:50");

    doTest("T13",
        "HEMORRHAGE, NOSEBLEED, EMS, LACERATION BLS, 21A, 21B 28 GLYMONT RD 7 B6 89 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. Blood thinner",
        "CALL:HEMORRHAGE, NOSEBLEED, EMS, LACERATION",
        "UNIT:BLS, 21A, 21B",
        "ADDR:28 GLYMONT RD",
        "MAP:7 B6",
        "INFO:89 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. Blood thinner");
 
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        " 1 of 2\nFRM:WVFD EMS 12 \nMSG:ASSAULT, SEXUAL ASSAULT, EMS, BLS, 4A, 4B 3300 MIDDLETOWN RD, WESTLAKE HIGH BY TRACK 9 G1-F3 STAGE WELL IN AREA...\n(Con't) 2 of 2\nE112990016 1119562 12:33\n(End)",
        "CALL:ASSAULT, SEXUAL ASSAULT",
        "UNIT:EMS, BLS, 4A, 4B",
        "ADDR:3300 MIDDLETOWN RD",
        "PLACE:WESTLAKE HIGH BY TRACK",
        "MAP:9 G1-F3",
        "INFO:STAGE WELL IN AREA...",
        "ID:E112990016-1119562",
        "TIME:12:33");

    doTest("T2",
        " 1 of 2\nFRM:WVFD EMS 12 \nMSG:CHEST PAINS, EMS, ALS, 10C, 10D 5903 PUMPKINSEED CT 9 F7 81 year old, Female, Conscious, Breathing. Chest Pain\n(Con't) 2 of 2\n(Non-Traumatic). Heart attack or angina history. E112990015 1119561 12:05\n(End)",
        "CALL:CHEST PAINS",
        "UNIT:EMS, ALS, 10C, 10D",
        "ADDR:5903 PUMPKINSEED CT",
        "MAP:9 F7",
        "INFO:81 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Heart attack or angina history.",
        "ID:E112990015-1119561",
        "TIME:12:05");

    doTest("T3",
        " 1 of 2\nFRM:WVFD EMS 12 \nMSG:HEMORRHAGE, LACERATIONS, EMS ALS, 21C, 21D 1 MAGNOLIA DR, GENESIS LAPLATA RM 135 BED B 17 D5 78 year old, Female,\n(Con't) 2 of 2\nConscious, Breathing. Hemorrhage / Lacerations. DANGEROUS hemorrhage. E112990012 1119557 10:52\n(End)",
        "CALL:HEMORRHAGE, LACERATIONS",
        "UNIT:EMS ALS, 21C, 21D",
        "ADDR:1 MAGNOLIA DR",
        "PLACE:GENESIS LAPLATA RM 135 BED B",
        "MAP:17 D5",
        "INFO:78 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. DANGEROUS hemorrhage.",
        "ID:E112990012-1119557",
        "TIME:10:52");
    
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY 12421 TURTLE DOVE PL 10 K4 ODOR OF GAS INSIDE,HOUSE IS EVACUATED F120080006 1200424",
        "CALL:GAS LEAK INSIDE A COMMERCIAL BUILDING OR MF MULTI FAMILY",
        "ADDR:12421 TURTLE DOVE PL",
        "MAP:10 K4",
        "INFO:ODOR OF GAS INSIDE,HOUSE IS EVACUATED",
        "ID:F120080006-1200424");

    doTest("T2",
        "CHEST PAINS, EMS, ALS, 10C, 10D 3012 PALMER PL, APT F 10 E6 1. 47 year old, Female, Conscious, Breathing. E120080019 1200423 14:03",
        "CALL:CHEST PAINS",
        "UNIT:EMS, ALS, 10C, 10D",
        "ADDR:3012 PALMER PL",
        "APT:F",
        "MAP:10 E6",
        "INFO:1. 47 year old, Female, Conscious, Breathing.",
        "ID:E120080019-1200423",
        "TIME:14:03");

    doTest("T3",
        "TRAUMATIC INJURY, EMS, BLS, 30A, 30B 2501 REGAL PL 4 F11 WILL ADVISE MORE IN A MINUTE.... E120080018 1200422 13:22",
        "CALL:TRAUMATIC INJURY",
        "UNIT:EMS, BLS, 30A, 30B",
        "ADDR:2501 REGAL PL",
        "MAP:4 F11",
        "INFO:WILL ADVISE MORE IN A MINUTE....",
        "ID:E120080018-1200422",
        "TIME:13:22");

    doTest("T4",
        "CHOKING, EMS, ALS, 11D 70 VILLAGE ST, NURSES OFFICE 3RD FLOOR 10 F6 1. 87 year old, Male, Conscious, Breathing. E120080017 1200421 13:21",
        "CALL:CHOKING",
        "UNIT:EMS, ALS, 11D",
        "ADDR:70 VILLAGE ST",
        "PLACE:NURSES OFFICE 3RD FLOOR",
        "MAP:10 F6",
        "INFO:1. 87 year old, Male, Conscious, Breathing.",
        "ID:E120080017-1200421",
        "TIME:13:21");

    doTest("T5",
        "SICK PERSON, EMS, ALS, 26C, 26D 3135 FLANDERS CT 10 H4 1. 66 year old, Male, Conscious, Breathing. E120080015 1200419 12:33",
        "CALL:SICK PERSON",
        "UNIT:EMS, ALS, 26C, 26D",
        "ADDR:3135 FLANDERS CT",
        "MAP:10 H4",
        "INFO:1. 66 year old, Male, Conscious, Breathing.",
        "ID:E120080015-1200419",
        "TIME:12:33");

    doTest("T6",
        "STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE 1504 BRYAN CT 10 F7 PROBLEMS WITH THE FIRE PLACE / SMIKE IN THE RESIDENCE F120080005 12",
        "CALL:STRUC, SF HOUSE, TRAILER, ATTACHED SHED, GARAGE FIRE",
        "ADDR:1504 BRYAN CT",
        "MAP:10 F7",
        "INFO:PROBLEMS WITH THE FIRE PLACE / SMIKE IN THE RESIDENCE",
        "ID:F120080005-12");

    doTest("T7",
        "SICK PERSON, EMS, ALS, 26C, 26D MALL CIR, VAN GO BUS 702 10 C3 Age unknown, female, conscious, breathing. E120100069 1200551 18:24",
        "CALL:SICK PERSON",
        "UNIT:EMS, ALS, 26C, 26D",
        "ADDR:MALL CIR",
        "PLACE:VAN GO BUS 702",
        "MAP:10 C3",
        "INFO:Age unknown, female, conscious, breathing.",
        "ID:E120100069-1200551",
        "TIME:18:24");

    doTest("T8",
        "TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 2547 MATTAWOMAN BEANTOWN RD 5 A12 81-year-old, female, conscious, breathing. Calle",
        "CALL:TROUBLE BREATHING, RESPIRATORY DISTRESS",
        "UNIT:EMS, ALS, 6C, 6D",
        "ADDR:2547 MATTAWOMAN BEANTOWN RD",
        "MAP:5 A12",
        "INFO:81-year-old, female, conscious, breathing. Calle");

    doTest("T9",
        "SICK PERSON, EMS, ALS, 26C, 26D 9559 PEP RALLY LN 3 C13 13-month-old, male, conscious, breathing. Caller Statement: NOT RESPONDING. E120100",
        "CALL:SICK PERSON",
        "UNIT:EMS, ALS, 26C, 26D",
        "ADDR:9559 PEP RALLY LN",
        "MAP:3 C13",
        "INFO:13-month-old, male, conscious, breathing. Caller Statement: NOT RESPONDING. E120100");

    doTest("T10",
        "CHEST PAINS, EMS, ALS, 10C, 10D 12171 ELL LN, APT61 10 H4 42-year-old, female, conscious, breathing. Caller Statement: CHEST. E120100048 120",
        "CALL:CHEST PAINS",
        "UNIT:EMS, ALS, 10C, 10D",
        "ADDR:12171 ELL LN",
        "PLACE:APT61",
        "MAP:10 H4",
        "INFO:42-year-old, female, conscious, breathing. Caller Statement: CHEST.",
        "ID:E120100048-120");

    doTest("T11",
        "TROUBLE BREATHING, RESPIRATORY DISTRESS, EMS, ALS, 6C, 6D 402 GARNER AVE 10 B6 45-year-old, female, conscious, breathing. Caller Statement:",
        "CALL:TROUBLE BREATHING, RESPIRATORY DISTRESS",
        "UNIT:EMS, ALS, 6C, 6D",
        "ADDR:402 GARNER AVE",
        "MAP:10 B6",
        "INFO:45-year-old, female, conscious, breathing. Caller Statement:");

  }
  
  @Test
  public void testRogersonJG() {

    doTest("T1",
        "STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS 2007 SMALLWOOD DR W, WESTLAKE DASH IN 10 A3 F121590013 1209",
        "CALL:STRUC, COMMERCIAL BLDG, WAREHOUSE, STORAGE UNITS, BUSINESS",
        "ADDR:2007 SMALLWOOD DR W",
        "PLACE:WESTLAKE DASH IN",
        "MAP:10 A3",
        "ID:F121590013-1209");

    doTest("T2",
        "LANDING SITE, LZ, MISC 10956 BEECHWOOD CT 4 A10 SET UP LZ F121540011 1209461 12:34",
        "CALL:LANDING SITE, LZ",
        "UNIT:MISC",
        "ADDR:10956 BEECHWOOD CT",
        "MAP:4 A10",
        "INFO:SET UP LZ",
        "ID:F121540011-1209461",
        "TIME:12:34");
  }
  
  @Test
  public void testJasonBrooks() {

    doTest("T1",
        "MALFUNCTION ALARM 15224 POTOMAC RIVER DR 37 F3 SMOKE DETECTOR SOUNDING AND DOESN'T KNOW WHY. SEES NO SMOKE OR FIRE F122500008 1216155 10:30",
        "CALL:MALFUNCTION ALARM",
        "ADDR:15224 POTOMAC RIVER DR",
        "MAP:37 F3",
        "INFO:SMOKE DETECTOR SOUNDING AND DOESN'T KNOW WHY. SEES NO SMOKE OR FIRE",
        "ID:F122500008-1216155",
        "TIME:10:30");
 
  }
  
  @Test
  public void testCharlieAllison() {

    doTest("T1",
        "DIABETIC ALS PG COUNTY, 1014 BOHAC LN 2 H12 E132250043 1314804 21:40\r\n",
        "CALL:DIABETIC",
        "UNIT:ALS",
        "CITY:PRINCE GEORGES COUNTY",
        "ADDR:1014 BOHAC LN",
        "MAP:2 H12",
        "ID:E132250043-1314804",
        "TIME:21:40");
 
  }
    
  public static void main(String[] args) {
    new MDCharlesCountyAParserTest().generateTests("T1");
  }

}