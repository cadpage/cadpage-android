package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hamilton County, IN
Contact: Mitch Hazelbaker <mitch8123@gmail.com>
Sender: CAD@noblesville.in.us
System: OSSI

CAD:1 E81,E82 RESD ALM 15650 SHINING SPRING DR WES (S)VIKING MEADOWS ADDITION (N) 82 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The incident involves a single-family res:
CAD:1 A81,E81 SEIZURE 18200-94 US 31 WES (S)NORTH GLEN VILLAGE (N) 81 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 53-year-old female, who is unconscious and breathing. CONTINUOU:
CAD:1 E83,A82 METNL PT 4154 ELKHORN WAY WES (S)CREST VIEW ADDITION (N) 83 Event spawned from MENTAL/EMOTIONAL - DISORDERS. [10/19/2012 10:14:06 HSYLTE] MALE NEEDS TO BE TRANSPORTED TO COMMUNITY NORTH [10/19/12 09:52:34 RVAUGHAN] NO WEAPONS [10/19/12 09:51:50 RVAUGHAN]
CAD:1 E83,A82 BCK PAIN KROGER SUPERMARKET 17447 CAREY RD WES 83 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with non-traumatic back pain. The patient is a 42-year-old male, who is conscious and breathing. NON-TR:
(Text Message) CAD:E83,A82 INJ PRSN 4624 MCKINLEY CT WES (S)SUMMIT LAKES ADDITION (N) 83 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: Y responding to a patient involved in a fall. The patient is a 73-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On floor). Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fa accidental. 4. There is som

Contact: Active911
Agency name: Noblesville Fire Department
Location: Noblesville, IN, United States
Sender: CAD@noblesville.in.us

CAD:E73,A73 CHST PNS 10043 EXPEDITION PL NOB (S)CUMBERLAND POINTE APARTMENTS (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 37-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: numb left arm/chest. 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has diff\r
CAD:E76 GAS ODOR 6126 NEWARK DR NOB (S)LOCHAVEN AT NOBLE WEST (N) 76 smell of propane in the area [12/17/12 19:39:23 BIMMEL] [Fire Priority Update] Fire Priority reconfigured event from 66-A-02 to 60-B-02O. RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases). 1. The caller is on scene (1st party). 2. The odor is reportedly outside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is on scene (1st party). 5. The problem is rep\r
CAD:E73,A73 SEIZURE 15332 ATKINSON DR NOB (S)BRIGHTON KNOLL ADDITION (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 3-year-old female, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: siezure. 1. This is apparently a generalized (grand mal) seizure. 2. It`s not known if she ha\r
CAD:FYI: S77 ASST OTH 13914 SOUTHEASTERN PKY FIS 92 Aborted by Fire Priority with code: another dispatcher on call [12/17/12 18:21:14 BCRAIG] 4\r
CAD:10-50 PI 2 E 146TH ST/RIVER RD NOB (S)CAFD (N) 4th pt: 42 y/o female c/o back pain [12/17/12 17:59:05 BIMMEL] 3 pt`s: 70 y/o female c/o knee pain, 56 y/o female c/o chest pain, 68 y/o female leg pain [12/17/12 17:58:00 BIMMEL] Event spawned from PI ACCIDENT - SERIOUS RESP. [12/17/2012 17:53:52 BIMMEL] east of loc [12/17/12 17:53:16 AKENNEDY] smoke comming from veh [12/17/12 17:51:58 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding\r
CAD:E73,A73,E76,B7,R71 10-50 PI 2 E 146TH ST/RIVER RD NOB (S)CAFD (N) Event spawned from PI ACCIDENT - SERIOUS RESP. [12/17/2012 17:53:52 BIMMEL] east of loc [12/17/12 17:53:16 AKENNEDY] smoke comming from veh [12/17/12 17:51:58 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not app\r
CAD:A75,E73,E71 SICK PSN 1624 HARRISON ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 76-year-old female, who is conscious and breathing. Not alert. Sick Person (Specific Diagnosis). Caller Statement: sick. 1. She is not completely alert (not responding appropriately). [12/17/12 17:37:26 AKENNEDY] 1\r
CAD:B8 ASST OTH 16323 OLDENBURG CIR WES (S)COUNTRYSIDE ADDITION (N) 81 police req fire invest [12/17/12 16:58:43 AKENNEDY] Event spawned from EXPLOSIONS. [12/17/2012 16:58:12 AKENNEDY] explosive device made out of 2 liter bottle went off in her mailbox she took it out caused damage to mailbox [12/17/12 16:49:00 CTRAVIS] 4\r
CAD:E72,L74,B7 BUSN ALM NOBLESVILLE ATHLETIC CLUB 411 SOUTH HARBOUR DR NOB (S)SOUTH HARBOUR ADDITION (N) 72 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is not known. 5. The area or zone activated is: north area 6. The phone number of the business/resident/owner is: 317\r
CAD:E73,A73 UNCN PSN HAMILTON HEALTH CAMPUS 9669 E 146TH ST NOB 310 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 85-year-old male, who is unconscious and breathing. Unconscious -- Effective breathing. Unconscious / Fainting (Near). Caller Statement: uncon. 1. His breathing is completely normal. 2. He is still unconscious. [12/17/12 16:10:18 AKENNEDY] 1\r
CAD:E73,A73 SEIZURE 11465 HANBURY MANOR BLVD NOB (S)SAGAMORE AT NOBLESVILLE (N) 73 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 19-year-old female, who is conscious and breathing. FOCAL seizure (not alert) (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. She is not pregnant. 3. She is not diabetic. 4. S\r
CAD:A75,E71 OVERDOSE 1539 EVANS AVE NOB 71 2\r
CAD:A82,E81,E82,B8 GAS ODOR ST VINCENT MEDICAL PAVILLION 14828 GREYHOUND CT CAR SUITE 200 82 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: gas smell at business. 1. The caller is on scene (2nd party). 2. The problem is reportedly inside. 3. The gas can be smelled only. 4. The incident involves a COMMERCIAL/INDUSTRIAL building. [12/17/12 13:24:58 AKENNEDY] 1\r
CAD:E73,B7,L77 BUSN ALM O CHARLEYS 16725 MERCANTILE BLVD NOB 73 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is: andy loper 518-0144 5. The area or zone activated is: 2 6. The phone number of the business/resident/owner is: aleready obtained\r
CAD:A75,E75 STROKE 605 QUEENS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 77-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stroke. 1. She is not completely alert (not responding appropriately). 2. Sh\r
CAD:A81,E83 DIFF BRE BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR ROOM 3009 82 nurse on scne [12/17/12 10:58:35 AKENNEDY] door 3 [12/17/12 10:58:28 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 51-year-old male, who is conscious and breathing. Not alert. Caller Statement: breath prob. 1. He is not completely alert (not responding appropriately). 2. He has difficulty\r
CAD:S77,E73,B7,R71,L77 10-50 PI 1 E 146TH ST/OLIO RD NOB [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) Pinned (trapped) victim (Multiple patients and Additional response required). Multiple patients involved: 3. Traffic / Transportation Incidents. Caller Statement: pi. 1. The incident involves multiple vehicles. 2. A multip\r
CAD:A82,E82 DIFF BRE BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR ROOM 2012 82 2\r
CAD:A73 INJ PRSN PRAIRIE LAKES NURSING HOME 9730 PRAIRIE LAKES BLVD E NOB ROOM 305 73 fall [12/17/12 09:00:14 SAI] 2\r
CAD:A73,R71,E71 CHST PNS 131 S 6TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 61-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths. [12/17/12 01:48:49\r
CAD:A73,E72,E71 SICK PSN HARBOUR MANOR CARE CENTER 1667 SHERIDAN RD NOB 72 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 89-year-old female, who is conscious and breathing. ALTERED LEVEL OF CONSCIOUSNESS. Sick Person (Specific Diagnosis). Caller Statement: high blood pressure. 1. She is confused. 2. She is not breathing normally. 3. She has other pain: pai\r
CAD:L74,A72 SICK PSN 51 LIONS CREEK CT S NOB (S)LIONS CREEK APARTMENTS (N) 74 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 42-year-old female, who is conscious and breathing. No priority symptoms (complaint conditions 2-11 not identified). Sick Person (Specific Diagnosis). Caller Statement: SICK. 1. She is completely alert (responding appropriately). 2. She\r
CAD:A75,E71 CHST PNS JOHNSON,DONALD ISAAC 747 N 14TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 38-year-old male, who is conscious and breathing. Clammy. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color. 4. He is clammy. [12/16/12 23:30:32 MREED] 1\r
CAD:A75 INJ PRSN HAMILTON CO JAIL 18100 CUMBERLAND RD NOB 75 Aborted by Medical Priority with code: police on scene, checkout, bleeding from head [12/16/12 22:03:58 WMCGEE] 3\r
CAD:Update: MUTL AID 3801 E 196TH ST WES 83 [FIRE] ALARM CO IS ATTEMPTING REPS [12/16/12 19:27:15 KKEY] [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The ph\r
CAD:E83 RESD ALM 3801 E 196TH ST WES 83 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The phone number of the business/resident/owner is not known\r
CAD:A82,E82,B8 10-50 PI SPRING MILL RD/W GREYHOUND PASS WES 82 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a 45-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). Traffic / Transportation Incidents. Caller Statement: car vs motorcycle. 1. The incident involves an auto-motorcycle. [12/16/12 19:18:47 JMILLER] 1\r
CAD:E76,A72 CHST PNS 5682 FLINCHUM WAY N NOB (S)HAZEL DELL WOODS ADDITION (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 82-year-old male, who is conscious and breathing. Not alert. Chest Pain (Non-Traumatic). Caller Statement: heart attack. 1. He is not completely alert (not responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths.\r
CAD:A73,E71 SICK PSN 954-A DIVISION ST NOB 71 Event spawned from SERVICE CALL - WELFARE CHECK. [12/16/2012 16:48:47 JMILLER] 10-17 WORKS AT IMPD DISPATCH AND IS AT WORK NOW [12/16/12 16:31:57 NFAILOR] FATHER HOWARD VANSYCLE HAS BEEN SICK AND NOW THEY GET IN CONTACT WITH HIM. HIS PHONE NUMBER 410-2072 [12/16/12 16:31:21 NFAILOR] 3\r
CAD:E76 CARD ARR 5715 NOBLE CROSSING PKY E NOB (S)WEST HAVEN AT NOBLE WEST (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. [12/16/12 08:45:39 KGIBBONS] P\r
CAD:A82,E82 CARD ARR 5715 NOBLE CROSSING PKY E NOB (S)WEST HAVEN AT NOBLE WEST (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. [12/16/12 08:45:39 KGIBBONS] 1\r
CAD:E82 INVEST 1506 W 151ST ST WES 82 [LAW] VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY [12/16/12 03:08:47 JPOYNTER] Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r
CAD:Update: INVEST 1506 W 151ST ST WES 82 [LAW] VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY [12/16/12 03:08:47 JPOYNTER] Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r
CAD:FYI: ASST OTH 1506 W 151ST ST WES 82 Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r
CAD:E73,A73 HRT PROB NOBLESVILLE FIRE - STATION 73 2101 GREENFIELD AVE NOB (S)WELLINGTON NORTHEAST (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with heart problems. The patient is a 63-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Heart Problems / A.I.C.D.. Caller Statement: HEART PROBLEMS. 1. He is completely alert (responding appropriately). 2. He is not breathing normally.\r
CAD:A75,E75 ABD PAIN 19235 POTTERS BRIDGE RD NOB (S)POTTERS WOODS ADDITION (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with abdominal pain. The patient is a 70-year-old female, who is conscious and breathing. Females with pain above navel => 45. Abdominal Pain / Problems. Caller Statement: abdominal pain. 1. She is completely alert (responding appropriately). 2. The pain is described as: left side/dull side 3. T\r
CAD:E81,L81,B8 GAS ODOR 18200-135 US 31 WES (S)NORTH GLEN VILLAGE (N) 81 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: stove has on in residence. 1. The caller is not on scene. 2. The odor is reportedly inside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is not on scene. 5. The problem is reportedly inside. 6. The gas can be smelled only. 7. The incident\r
CAD:E73,A73 STROKE 14294-101 BALD EAGLE DR NOB (S)PRAIRIE LAKES APARTMENTS (N) 73 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 83-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). 1. She is not completely alert (not responding appropriately). 2. She is breathing\r
CAD:A75,E75,B7,R71 10-50 PI 2 19492 AMBER WAY NOB (S)MEADOWS (THE) (N) Radio Channel: FG 1 [12/15/12 19:53:31 NNELSON] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/15/2012 19:53:03 MBROWN] DRIVER WOULD LIKE A CHECK OUT [12/15/12 19:51:08 MBROWN] AIR BAGS DEPLOYED [12/15/12 19:50:33 MBROWN] VEH VS TREE [12/15/12 19:50:09 MBROWN] 75\r
CAD:MED ASST 19895 VICTORY CHAPEL RD NOB 15 1\r
CAD:FYI: MED ASST 19895 VICTORY CHAPEL RD NOB 15 2\r
CAD:A82 INJ PRSN MARSH SUPERMARKET 1960 E GREYHOUND PASS CAR 82 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 18-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now. 5. He is completely\r
CAD:E83 MINOR PI E 196TH ST/US 31 NB WES 83 Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/15/2012 16:05:01 MBROWN] ford flex it has a wheelchair ramp on back. one of the witnesses is a nurse [12/15/12 16:00:54 DCRAIG] IN INTERSECTION - AND ANOTHER CAR JUST NORTH OF [12/15/12 15:59:21 MBACH] 3\r
CAD:A75,E73 DIABETIC THIRD PHASE 15755 ALLISONVILLE RD NOB 73 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. [12/15/12 14:16:38 BIMMEL] 4\r
CAD:E71 DIABETIC THIRD PHASE 15755 ALLISONVILLE RD NOB 73 use the front ent [12/15/12 14:17:30 BIMMEL] [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. [12/15/12 14:16:38 BIMMEL] 4\r
CAD:A73 INJ PRSN 10524 CUMBERLAND POINTE BLVD NOB (S)CUMBERLAND POINTE ADDITION (N) 73 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 82-year-old male, who is conscious and breathing. NOT DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now.\r
CAD:E73,R71 CIT ASST 131 S 6TH ST NOB 71 FEMALE NEEDS HELP GETTING HIM DOWN THE STAIRS [12/15/12 12:22:50 KGIBBONS] [Fire Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: Citizen Assist / Service Call.Caller Statement: needs help down stairs. 1. The caller is on scene (1st party). 2. A CITIZEN ASSIST is needed: lift 3. No one is reportedly sick or injured. 4. The door is unlocked. -Comments: lift- [12/15/12 12:22:39 KGIBBONS] Aborted by Medical Priority with code:\r
CAD:A73,E71 INJ PRSN 1267 S 6TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s not known how far she fell. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. She is completel\r
CAD:Update: MUTL AID BLESSED THEODORE GUERIN HIGH S 15300 GRAY RD NOB 76 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known. [12/15/12 11:07:08 NNELSO\r
CAD:E76 INST ALM 2 BLESSED THEODORE GUERIN HIGH S 15300 GRAY RD NOB [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known. [12/15/12 11:07:08\r
CAD:E75,B7,E71 ODOR INV 19347 PACIFICA PL NOB (S)ROUDEBUSH FARMS ADDITION (N) 75 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire.Caller Statement: smell smoke in res. 1. The caller is on scene (1st party). 2. This is an odor of smoke with nothing visible. 3. The fire has not been extinguished. 4. The incident involves a single-family residential structure. 5. A multi-story structure is involved: 2 6. The caller has not indicated that there a\r
CAD:A75,E75 UNKN MED CONNER ST/SR 37 NOB 75 [LAW] REPORT OF ELDERLY MALE LAYI [12/15/12 07:35:11 DCRAIG] [Medical Priority Update] Medical Priority reconfigured event from to 32-D-01. RESPONDER SCRIPT: You are responding to a patient with an unknown problem (man down). The patient is a 55-year-old male, who is conscious and breathing. LIFE STATUS QUESTIONABLE. Caller Statement: man down. 1. No special circumstances. 2. He does not appear to be completely awake (alert).\r
CAD:E83,A82,E82 CARD ARR BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR 82 room 501 [12/15/12 07:28:23 JGIORDANO] [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 80-year-old male, who is unconscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: cardiac arrest. [12/15/12 07:28:15 JGIORDANO] P\r
CAD:A75,E75,B7,R71 10-50 PI 2 E 206TH ST/SR 37 NOB law enforcement on scene [12/15/12 03:43:33 JGIORDANO] 22 y/o co head pain from rolling his veh x2 [12/15/12 03:43:18 JGIORDANO] 75\r
CAD:A81,E83 INJ PRSN SANDERS GLEN APARTMENTS 334 S CHERRY ST WES 83 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 83-year-old male, who is conscious and breathing. Not alert. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. He is not compl\r
CAD:FYI: MUTL AID 10774 CLUB CHASE FIS 92 2\r
CAD:Update: E73,A73 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) Radio Channel: FG 3 [12/14/12 21:38:37 JMILLER] UDTS: {B7} WORKING INCIDENT - NOBLES [12/14/12 21:38:16 JMILLER] (B7) WATER ON THE FIRE [12/14/12 21:38:06 NNELSON] DUKE CLR--TICKET # D1525465--UNK ETA [12/14/12 21:36:25 MBROWN] Radio Channel: FG 3 [12/14/12 21:36:07 NNELSON] EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF [12/14/12 21:34:50 JMILLER] VECTREN DOES NOT SHOW GAS SERVICE AT THIS\r
CAD:{B7} WORKING INCIDENT - NOBLES;19502 ROCKY BEACH DR; NOB(S)MORSE POINTE ADDITION (N);STRUCTURE FIRE - RESIDENTIAL\r
CAD:RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) Radio Channel: FG 3 [12/14/12 21:36:07 NNELSON] EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF [12/14/12 21:34:50 JMILLER] VECTREN DOES NOT SHOW GAS SERVICE AT THIS ADDRESS [12/14/12 21:33:09 MBROWN] [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4.\r
CAD:Update: E83 MUTL AID 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) 72 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 2\r
CAD:E72,E76,L74,R71,A72 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r
CAD:E83 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r
CAD:E72,E76,L74,R71,A72 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r
CAD:E83 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r
CAD:B7,E71 METH LAB 4 LOPEZ RES 1098 S 8TH ST NOB Event spawned from SUPPLEMENTAL - CASE FOLLOW UP. [12/14/2012 21:27:53 MBROWN] CONTACTING STATE POLICE [12/14/12 21:27:17 CTRIETSCH] 10-17 at npd. no tx. was advised she could come and speak with offc hargrove ref susp drug activity in her home. [12/14/12 20:45:29 MHAMILTON] 71\r
CAD:VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 bat8 requested paddacks to call his cell and to respond to the scene [12/14/12 21:16:22 JMILLER] AFFECTED UNIT IS TOTAL ELECTRIC AND NO GAS SERVICE, ELECTRIC HAS BEEN SECURED [12/14/12 20:59:22 JMILLER] 131 CLEAR FOR UNITS TO ENTER [12/14/12 20:58:29 JMILLER] UNIT 127 CLEARED FOR RESIDENTS TO RETURN, UNIT 129 IS AFFECTED, UNIT 131 IS BEING CHECKED [12/14/12 20:50:27 JMILLER] screws entering structure to check f\r
CAD:L74,A72 UNKN MED EDMONDS,ANTHONY W 99 LIONS CREEK CT S NOB (S)LIONS CREEK APARTMENTS (N) 74 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient with an unknown problem (man down). The patient is a 30-year-old male, who is conscious and breathing. Standing, sitting, moving, or talking. Caller Statement: UNK. 1. No special circumstances. 2. It`s not known if he appears to be completely awake (alert). 3. He was heard talking.\r
CAD:E83,A82 DIFF BRE IMMI - INDIANA MILLS AND MFG 18881 US 31 WES 83 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 39-year-old male, who is conscious and breathing. Not alert. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. [12/14/12 20:19:49 NNELSON] 1\r
CAD:A75,E71 DIFF BRE MATTEOS RISTORANTE ITALIANO 40 N 9TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 70-year-old male, who is conscious and breathing. Not alert. Caller Statement: DIFF BREATHING. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. [12/14/12 20:15:40 MBROWN] 1\r
CAD:A81,TAC80,E81,E82,B8 VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 1\r
CAD:A81,TAC80,E81,E82,B8 VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 1\r
CAD:A73 INJ PRSN PRAIRIE LAKES NURSING HOME 9730 PRAIRIE LAKES BLVD E NOB 73 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 85-year-old male, who is conscious and breathing. POSSIBLY DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is some bleeding, not ser\r
CAD:Update: E83 MUTL AID 17967 CANDLEWOOD CT NOB (S)VILLAGES AT PEBBLE BROOK (N) 76 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is:\r
CAD:E76 RESD ALM 17967 CANDLEWOOD CT NOB (S)VILLAGES AT PEBBLE BROOK (N) 76 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner\r
CAD:E83,E81 RESD ALM 18525 HARVEST MEADOWS DR E WES (S)HARVEST MEADOWS (N) 83 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a keypad (manual) alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: MANEIRO 5. The area or zone activated is: KEY PAD, GEN FIRE 6. The phone number of the business/resident/owner\r
CAD:E81,E82,L81,B8 INST ALM 2 ST MARIA GORETTI SCHOOL 17104 SPRING MILL RD WES (S)MAPLE VILLAGE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a pull station. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: st maria 5. The exact area or zone activated is not known. 6. The phone number o\r
CAD:S77 SEIZURE EARTH FARE 13145 LEVINSON LN NOB 77 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 50-year-old male, who is unconscious and breathing. Effective breathing not verified => 35. Convulsions / Seizures. Caller Statement: SEIZ. 1. This is apparently a generalized (grand mal) seizure. 2. He has not had more than one seizure in a row. 3. It`s not known if he is diabetic.\r
CAD:E72 GAS ODOR PASADENA RD/SHERIDAN RD NOB 72 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: GAS ODOR. 1. The caller is not on scene. 2. The problem is reportedly outside. 3. The gas can be smelled only. 4. It is not known where the leak is coming from, but there is an odor. 5. No one is reportedly sick or injured. [12/14/12 13:42:23 HSYLTE] 3\r
CAD:A75,E75,B7,L77 10-50 PI 2 E SR 38/E SR 32 NOB [LAW] poss head injury [12/14/12 13:35:05 LUHRICK] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/14/2012 13:34:54 JGIORDANO] motorcycle [12/14/12 13:34:19 LUHRICK] 75\r
CAD:B7,R71,A72,E71 10-50 PI 2 RIVER RD/WESTFIELD RD NOB [LAW] female bleeding from mouth [12/14/12 12:52:44 LUHRICK] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/14/2012 12:52:39 JGIORDANO] small 4 dr beige car [12/14/12 12:52:12 LUHRICK] ADDITIONAL CALLER AMBER EATON 317-697-8326 [12/14/12 12:51:59 AHAAS] car vs pole [12/14/12 12:51:47 LUHRICK] 71\r
CAD:E81 SICK PSN 17735 JOLIET RD SHE (S)JOLIETVILLE (N) 81 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I\r
CAD:A81 SICK PSN 17735 JOLIET RD SHE (S)JOLIETVILLE (N) 81 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I\r
CAD:E73,A73 DIFF BRE 444 WESTMINSTER DR NOB (S)WELLINGTON NORTH (N) 73 81 y/o female awake and breathing. [12/14/12 12:30:39 JGIORDANO] 2\r
CAD:A82,E82 UNCN PSN BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR 82 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old male, who is conscious and breathing. CHANGING COLOR. Unconscious / Fainting (Near). 1. His breathing is completely normal. 2. He is completely alert (responding appropriately). 3. He is changing color. 4. His color change is ashen. [12\r
CAD:E83,E82,B8 INST ALM 2 RAINBOW CHILD DEVELOPMENT CTR 17457 GUNTHER BLVD WES [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: RCD 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is: 2485692500 -Comments: RC\r
CAD:A75,E71 STROKE HAM CO JUDICIAL CENTER 1 HAMILTON COUNTY SQ NOB 71 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 78-year-old female, who is conscious and breathing. Breathing normally => 35 (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stoke. 1. She is completely alert (responding appropriately).\r
CAD:A81,E83 MED ???? 414 SAVANNAH LN WES (S)SILVER LAKES (N) 83 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 61-year-old male, who is unconscious and breathing. FOCAL seizure (not alert). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. He is diabetic. 3. It`s not known if he is an epileptic (diagnosed with a seizure disorder). 4. He has a histor\r
CAD:A75,E75 DIFF BRE HAM CO COMMUNITY CORRECTIONS 18104 CUMBERLAND RD NOB 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: diff breathing. 1. He is completely alert (responding appropriately). 2. He does not have any difficulty speaking between breaths. 3. It`s not known if he is changing color.\r
CAD:A75,E75 DIFF BRE 555-I KINGS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 10-month-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: diff breath. 1. He is completely alert (responding appropriately). 2. He has difficulty crying between breaths. [12/13/12 22:29:52 DSTILTS] 1\r
CAD:A75,E75 DIABETIC 104 QUEENS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 49-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: DIAB. 1. He is completely alert (responding appropriately). 2. He is behaving normally now. 3. He is not breathing normally. [12/13/12 21:20:57 MBROWN] 2\r

*/

public class INHamiltonCountyBParserTest extends BaseParserTest {
  
  public INHamiltonCountyBParserTest() {
    setParser(new INHamiltonCountyBParser(), "HAMILTON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:1 E81,E82 RESD ALM 15650 SHINING SPRING DR WES (S)VIKING MEADOWS ADDITION (N) 82 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The incident involves a single-family res:",
        "PRI:1",
        "UNIT:E81,E82",
        "CALL:ALARM - RESIDENTIAL",
        "ADDR:15650 SHINING SPRING DR",
        "CITY:WESTFIELD",
        "PLACE:VIKING MEADOWS ADDITION",
        "SRC:82",
        "INFO:Alarms. 1. The caller is an alarm monitoring company. 2. It is a smoke detector alarm. 3. The incident involves a single-family res:");

    doTest("T2",
        "CAD:1 A81,E81 SEIZURE 18200-94 US 31 WES (S)NORTH GLEN VILLAGE (N) 81 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 53-year-old female, who is unconscious and breathing. CONTINUOU:",
        "PRI:1",
        "UNIT:A81,E81",
        "CALL:CONVULSIONS / SEIZURES",
        "ADDR:18200-94 US 31",
        "MADDR:18200 US 31",
        "CITY:WESTFIELD",
        "PLACE:NORTH GLEN VILLAGE",
        "SRC:81",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 53-year-old female, who is unconscious and breathing. CONTINUOU:");

    doTest("T3",
        "CAD:1 E83,A82 METNL PT 4154 ELKHORN WAY WES (S)CREST VIEW ADDITION (N) 83 Event spawned from MENTAL/EMOTIONAL - DISORDERS. [10/19/2012 10:14:06 HSYLTE] MALE NEEDS TO BE TRANSPORTED TO COMMUNITY NORTH [10/19/12 09:52:34 RVAUGHAN] NO WEAPONS [10/19/12 09:51:50 RVAUGHAN]",
        "PRI:1",
        "UNIT:E83,A82",
        "CALL:MENTAL EMOTIONAL / SUICIDE ATT",
        "ADDR:4154 ELKHORN WAY",
        "CITY:WESTFIELD",
        "PLACE:CREST VIEW ADDITION",
        "SRC:83",
        "INFO:MALE NEEDS TO BE TRANSPORTED TO COMMUNITY NORTH / NO WEAPONS",
        "DATE:10/19/2012",
        "TIME:10:14:06");

    doTest("T4",
        "CAD:1 E83,A82 BCK PAIN KROGER SUPERMARKET 17447 CAREY RD WES 83 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with non-traumatic back pain. The patient is a 42-year-old male, who is conscious and breathing. NON-TR:",
        "PRI:1",
        "UNIT:E83,A82",
        "CALL:BACK PAIN",
        "PLACE:KROGER SUPERMARKET",
        "ADDR:17447 CAREY RD",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:You are responding to a patient with non-traumatic back pain. The patient is a 42-year-old male, who is conscious and breathing. NON-TR:");

    doTest("T5",
        "(Text Message) CAD:E83,A82 INJ PRSN 4624 MCKINLEY CT WES (S)SUMMIT LAKES ADDITION (N) 83 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: Y responding to a patient involved in a fall. The patient is a 73-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On floor). Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fa accidental. 4. There is som",
        "UNIT:E83,A82",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:SUMMIT LAKES ADDITION",
        "ADDR:4624 MCKINLEY CT",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:Y responding to a patient involved in a fall. The patient is a 73-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On floor). Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fa accidental. 4. There is som");

  }
  
  @Test
  public void testNoblesvilleFire() {

    doTest("T1",
        "CAD:E73,A73 CHST PNS 10043 EXPEDITION PL NOB (S)CUMBERLAND POINTE APARTMENTS (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 37-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: numb left arm/chest. 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has diff\r",
        "UNIT:E73,A73",
        "CALL:CHEST PAINS",
        "ADDR:10043 EXPEDITION PL",
        "CITY:NOBLESVILLE",
        "PLACE:CUMBERLAND POINTE APARTMENTS",
        "SRC:73",
        "INFO:You are responding to a patient with chest pain. The patient is a 37-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: numb left arm/chest. 1. She is completely alert (responding appropriately). 2. She is not breathing normally. 3. She has diff");

    doTest("T2",
        "CAD:E76 GAS ODOR 6126 NEWARK DR NOB (S)LOCHAVEN AT NOBLE WEST (N) 76 smell of propane in the area [12/17/12 19:39:23 BIMMEL] [Fire Priority Update] Fire Priority reconfigured event from 66-A-02 to 60-B-02O. RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases). 1. The caller is on scene (1st party). 2. The odor is reportedly outside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is on scene (1st party). 5. The problem is rep\r",
        "UNIT:E76",
        "CALL:HAZMAT - GAS ODOR",
        "ADDR:6126 NEWARK DR",
        "CITY:NOBLESVILLE",
        "PLACE:LOCHAVEN AT NOBLE WEST",
        "SRC:76",
        "INFO:smell of propane in the area / Fire Priority reconfigured event from 66-A-02 to 60-B-02O. RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases). 1. The caller is on scene (1st party). 2. The odor is reportedly outside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is on scene (1st party). 5. The problem is rep",
        "DATE:12/17/12",
        "TIME:19:39:23");

    doTest("T3",
        "CAD:E73,A73 SEIZURE 15332 ATKINSON DR NOB (S)BRIGHTON KNOLL ADDITION (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 3-year-old female, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: siezure. 1. This is apparently a generalized (grand mal) seizure. 2. It`s not known if she ha\r",
        "UNIT:E73,A73",
        "CALL:CONVULSIONS / SEIZURES",
        "ADDR:15332 ATKINSON DR",
        "CITY:NOBLESVILLE",
        "PLACE:BRIGHTON KNOLL ADDITION",
        "SRC:73",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 3-year-old female, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: siezure. 1. This is apparently a generalized (grand mal) seizure. 2. It`s not known if she ha");

    doTest("T4",
        "CAD:FYI: S77 ASST OTH 13914 SOUTHEASTERN PKY FIS 92 Aborted by Fire Priority with code: another dispatcher on call [12/17/12 18:21:14 BCRAIG] 4\r",
        "UNIT:S77",
        "CALL:SERVICE CALL - ASSIST OTH DEPT",
        "ADDR:13914 SOUTHEASTERN PKY",
        "MADDR:13914 SOUTHEASTERN PKWY",
        "CITY:FISHERS",
        "SRC:92",
        "INFO:Aborted by Fire Priority with code: another dispatcher on call / 4",
        "DATE:12/17/12",
        "TIME:18:21:14");

    doTest("T5",
        "CAD:10-50 PI 2 E 146TH ST/RIVER RD NOB (S)CAFD (N) 4th pt: 42 y/o female c/o back pain [12/17/12 17:59:05 BIMMEL] 3 pt`s: 70 y/o female c/o knee pain, 56 y/o female c/o chest pain, 68 y/o female leg pain [12/17/12 17:58:00 BIMMEL] Event spawned from PI ACCIDENT - SERIOUS RESP. [12/17/2012 17:53:52 BIMMEL] east of loc [12/17/12 17:53:16 AKENNEDY] smoke comming from veh [12/17/12 17:51:58 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding\r",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:E 146TH ST & RIVER RD",
        "CITY:NOBLESVILLE",
        "PLACE:CAFD",
        "INFO:4th pt: 42 y/o female c/o back pain / 3 pt`s: 70 y/o female c/o knee pain, 56 y/o female c/o chest pain, 68 y/o female leg pain / Event spawned from PI ACCIDENT - SERIOUS RESP. / east of loc / smoke comming from veh / You are responding",
        "DATE:12/17/12",
        "TIME:17:59:05");

    doTest("T6",
        "CAD:E73,A73,E76,B7,R71 10-50 PI 2 E 146TH ST/RIVER RD NOB (S)CAFD (N) Event spawned from PI ACCIDENT - SERIOUS RESP. [12/17/2012 17:53:52 BIMMEL] east of loc [12/17/12 17:53:16 AKENNEDY] smoke comming from veh [12/17/12 17:51:58 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not app\r",
        "UNIT:E73,A73,E76,B7,R71",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:E 146TH ST & RIVER RD",
        "CITY:NOBLESVILLE",
        "PLACE:CAFD",
        "INFO:east of loc / smoke comming from veh / You are responding to a patient injured in a traffic incident. The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not app",
        "DATE:12/17/2012",
        "TIME:17:53:52");

    doTest("T7",
        "CAD:A75,E73,E71 SICK PSN 1624 HARRISON ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 76-year-old female, who is conscious and breathing. Not alert. Sick Person (Specific Diagnosis). Caller Statement: sick. 1. She is not completely alert (not responding appropriately). [12/17/12 17:37:26 AKENNEDY] 1\r",
        "UNIT:A75,E73,E71",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "ADDR:1624 HARRISON ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a 76-year-old female, who is conscious and breathing. Not alert. Sick Person (Specific Diagnosis). Caller Statement: sick. 1. She is not completely alert (not responding appropriately). / 1",
        "DATE:12/17/12",
        "TIME:17:37:26");

    doTest("T8",
        "CAD:B8 ASST OTH 16323 OLDENBURG CIR WES (S)COUNTRYSIDE ADDITION (N) 81 police req fire invest [12/17/12 16:58:43 AKENNEDY] Event spawned from EXPLOSIONS. [12/17/2012 16:58:12 AKENNEDY] explosive device made out of 2 liter bottle went off in her mailbox she took it out caused damage to mailbox [12/17/12 16:49:00 CTRAVIS] 4\r",
        "UNIT:B8",
        "CALL:SERVICE CALL - ASSIST OTH DEPT",
        "ADDR:16323 OLDENBURG CIR",
        "CITY:WESTFIELD",
        "PLACE:COUNTRYSIDE ADDITION",
        "SRC:81",
        "INFO:police req fire invest / Event spawned from EXPLOSIONS. / explosive device made out of 2 liter bottle went off in her mailbox she took it out caused damage to mailbox / 4",
        "DATE:12/17/12",
        "TIME:16:58:43");

    doTest("T9",
        "CAD:E72,L74,B7 BUSN ALM NOBLESVILLE ATHLETIC CLUB 411 SOUTH HARBOUR DR NOB (S)SOUTH HARBOUR ADDITION (N) 72 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is not known. 5. The area or zone activated is: north area 6. The phone number of the business/resident/owner is: 317\r",
        "UNIT:E72,L74,B7",
        "CALL:ALARM - COMMERICAL / BUSINESS",
        "PLACE:NOBLESVILLE ATHLETIC CLUB",
        "ADDR:411 SOUTH HARBOUR DR",
        "CITY:NOBLESVILLE",
        "PLACE:SOUTH HARBOUR ADDITION",
        "SRC:72",
        "INFO:Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is not known. 5. The area or zone activated is: north area 6. The phone number of the business/resident/owner is: 317");

    doTest("T10",
        "CAD:E73,A73 UNCN PSN HAMILTON HEALTH CAMPUS 9669 E 146TH ST NOB 310 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 85-year-old male, who is unconscious and breathing. Unconscious -- Effective breathing. Unconscious / Fainting (Near). Caller Statement: uncon. 1. His breathing is completely normal. 2. He is still unconscious. [12/17/12 16:10:18 AKENNEDY] 1\r",
        "UNIT:E73,A73",
        "CALL:UNCONSCIOUS / FAINTING",
        "PLACE:HAMILTON HEALTH CAMPUS",
        "ADDR:9669 E 146TH ST",
        "CITY:NOBLESVILLE",
        "INFO:310 73 / You are responding to a patient who is unconscious (or has fainted). The patient is a 85-year-old male, who is unconscious and breathing. Unconscious -- Effective breathing. Unconscious / Fainting (Near). Caller Statement: uncon. 1. His breathing is completely normal. 2. He is still unconscious. / 1",
        "DATE:12/17/12",
        "TIME:16:10:18");

    doTest("T11",
        "CAD:E73,A73 SEIZURE 11465 HANBURY MANOR BLVD NOB (S)SAGAMORE AT NOBLESVILLE (N) 73 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 19-year-old female, who is conscious and breathing. FOCAL seizure (not alert) (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. She is not pregnant. 3. She is not diabetic. 4. S\r",
        "UNIT:E73,A73",
        "CALL:CONVULSIONS / SEIZURES",
        "ADDR:11465 HANBURY MANOR BLVD",
        "CITY:NOBLESVILLE",
        "PLACE:SAGAMORE AT NOBLESVILLE",
        "SRC:73",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 19-year-old female, who is conscious and breathing. FOCAL seizure (not alert) (Epileptic or Previous seizure diagnosis). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. She is not pregnant. 3. She is not diabetic. 4. S");

    doTest("T12",
        "CAD:A75,E71 OVERDOSE 1539 EVANS AVE NOB 71 2\r",
        "UNIT:A75,E71",
        "CALL:OVERDOSE / POISONING",
        "ADDR:1539 EVANS AVE",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:2");

    doTest("T13",
        "CAD:A82,E81,E82,B8 GAS ODOR ST VINCENT MEDICAL PAVILLION 14828 GREYHOUND CT CAR SUITE 200 82 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: gas smell at business. 1. The caller is on scene (2nd party). 2. The problem is reportedly inside. 3. The gas can be smelled only. 4. The incident involves a COMMERCIAL/INDUSTRIAL building. [12/17/12 13:24:58 AKENNEDY] 1\r",
        "UNIT:A82,E81,E82,B8",
        "CALL:HAZMAT - GAS ODOR",
        "PLACE:ST VINCENT MEDICAL PAVILLION",
        "ADDR:14828 GREYHOUND CT",
        "APT:SUITE 200",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: gas smell at business. 1. The caller is on scene (2nd party). 2. The problem is reportedly inside. 3. The gas can be smelled only. 4. The incident involves a COMMERCIAL/INDUSTRIAL building. / 1",
        "DATE:12/17/12",
        "TIME:13:24:58");

    doTest("T14",
        "CAD:E73,B7,L77 BUSN ALM O CHARLEYS 16725 MERCANTILE BLVD NOB 73 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is: andy loper 518-0144 5. The area or zone activated is: 2 6. The phone number of the business/resident/owner is: aleready obtained\r",
        "UNIT:E73,B7,L77",
        "CALL:ALARM - COMMERICAL / BUSINESS",
        "PLACE:O CHARLEYS",
        "ADDR:16725 MERCANTILE BLVD",
        "CITY:NOBLESVILLE",
        "SRC:73",
        "INFO:Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a COMMERCIAL/INDUSTRIAL building. 4. The name of the business/resident/owner is: andy loper 518-0144 5. The area or zone activated is: 2 6. The phone number of the business/resident/owner is: aleready obtained");

    doTest("T15",
        "CAD:A75,E75 STROKE 605 QUEENS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 77-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stroke. 1. She is not completely alert (not responding appropriately). 2. Sh\r",
        "UNIT:A75,E75",
        "CALL:STROKE / CVA",
        "ADDR:605 QUEENS LN",
        "CITY:NOBLESVILLE",
        "PLACE:NOBLE MANOR APARTMENTS",
        "SRC:75",
        "INFO:You are responding to a patient who has apparently suffered a stroke. The patient is a 77-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stroke. 1. She is not completely alert (not responding appropriately). 2. Sh");

    doTest("T16",
        "CAD:A81,E83 DIFF BRE BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR ROOM 3009 82 nurse on scne [12/17/12 10:58:35 AKENNEDY] door 3 [12/17/12 10:58:28 AKENNEDY] [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 51-year-old male, who is conscious and breathing. Not alert. Caller Statement: breath prob. 1. He is not completely alert (not responding appropriately). 2. He has difficulty\r",
        "UNIT:A81,E83",
        "CALL:BREATHING PROBLEMS",
        "PLACE:BRIDGEWATER KINDRED TRANSITION",
        "ADDR:14751 CAREY RD",
        "APT:3009",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:nurse on scne / door 3 / You are responding to a patient with breathing problems. The patient is a 51-year-old male, who is conscious and breathing. Not alert. Caller Statement: breath prob. 1. He is not completely alert (not responding appropriately). 2. He has difficulty",
        "DATE:12/17/12",
        "TIME:10:58:35");

    doTest("T17",
        "CAD:S77,E73,B7,R71,L77 10-50 PI 1 E 146TH ST/OLIO RD NOB [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) Pinned (trapped) victim (Multiple patients and Additional response required). Multiple patients involved: 3. Traffic / Transportation Incidents. Caller Statement: pi. 1. The incident involves multiple vehicles. 2. A multip\r",
        "UNIT:S77,E73,B7,R71,L77",
        "CALL:PI ACCIDENT - REGULAR RESP 1",
        "ADDR:E 146TH ST & OLIO RD",
        "CITY:NOBLESVILLE",
        "INFO:You are responding to multiple patients involved in a traffic incident. (If known -- relay pertinent patient-specific information.) Pinned (trapped) victim (Multiple patients and Additional response required). Multiple patients involved: 3. Traffic / Transportation Incidents. Caller Statement: pi. 1. The incident involves multiple vehicles. 2. A multip");

    doTest("T18",
        "CAD:A82,E82 DIFF BRE BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR ROOM 2012 82 2\r",
        "UNIT:A82,E82",
        "CALL:BREATHING PROBLEMS",
        "PLACE:BRIDGEWATER KINDRED TRANSITION",
        "ADDR:14751 CAREY RD",
        "APT:2012",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:2");

    doTest("T19",
        "CAD:A73 INJ PRSN PRAIRIE LAKES NURSING HOME 9730 PRAIRIE LAKES BLVD E NOB ROOM 305 73 fall [12/17/12 09:00:14 SAI] 2\r",
        "UNIT:A73",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:PRAIRIE LAKES NURSING HOME",
        "ADDR:9730 PRAIRIE LAKES BLVD E",
        "APT:305",
        "CITY:NOBLESVILLE",
        "SRC:73",
        "INFO:fall / 2",
        "DATE:12/17/12",
        "TIME:09:00:14");

    doTest("T20",
        "CAD:A73,R71,E71 CHST PNS 131 S 6TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 61-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths. [12/17/12 01:48:49\r",
        "UNIT:A73,R71,E71",
        "CALL:CHEST PAINS",
        "ADDR:131 S 6TH ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient with chest pain. The patient is a 61-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths.",
        "DATE:12/17/12",
        "TIME:01:48:49");

    doTest("T21",
        "CAD:A73,E72,E71 SICK PSN HARBOUR MANOR CARE CENTER 1667 SHERIDAN RD NOB 72 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 89-year-old female, who is conscious and breathing. ALTERED LEVEL OF CONSCIOUSNESS. Sick Person (Specific Diagnosis). Caller Statement: high blood pressure. 1. She is confused. 2. She is not breathing normally. 3. She has other pain: pai\r",
        "UNIT:A73,E72,E71",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "PLACE:HARBOUR MANOR CARE CENTER",
        "ADDR:1667 SHERIDAN RD",
        "CITY:NOBLESVILLE",
        "SRC:72",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a 89-year-old female, who is conscious and breathing. ALTERED LEVEL OF CONSCIOUSNESS. Sick Person (Specific Diagnosis). Caller Statement: high blood pressure. 1. She is confused. 2. She is not breathing normally. 3. She has other pain: pai");

    doTest("T22",
        "CAD:L74,A72 SICK PSN 51 LIONS CREEK CT S NOB (S)LIONS CREEK APARTMENTS (N) 74 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a 42-year-old female, who is conscious and breathing. No priority symptoms (complaint conditions 2-11 not identified). Sick Person (Specific Diagnosis). Caller Statement: SICK. 1. She is completely alert (responding appropriately). 2. She\r",
        "UNIT:L74,A72",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "ADDR:51 LIONS CREEK CT S",
        "CITY:NOBLESVILLE",
        "PLACE:LIONS CREEK APARTMENTS",
        "SRC:74",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a 42-year-old female, who is conscious and breathing. No priority symptoms (complaint conditions 2-11 not identified). Sick Person (Specific Diagnosis). Caller Statement: SICK. 1. She is completely alert (responding appropriately). 2. She");

    doTest("T23",
        "CAD:A75,E71 CHST PNS JOHNSON,DONALD ISAAC 747 N 14TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 38-year-old male, who is conscious and breathing. Clammy. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color. 4. He is clammy. [12/16/12 23:30:32 MREED] 1\r",
        "UNIT:A75,E71",
        "CALL:CHEST PAINS",
        "PLACE:JOHNSON,DONALD ISAAC",
        "ADDR:747 N 14TH ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient with chest pain. The patient is a 38-year-old male, who is conscious and breathing. Clammy. Chest Pain (Non-Traumatic). Caller Statement: chest pain. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He is not changing color. 4. He is clammy. / 1",
        "DATE:12/16/12",
        "TIME:23:30:32");

    doTest("T24",
        "CAD:A75 INJ PRSN HAMILTON CO JAIL 18100 CUMBERLAND RD NOB 75 Aborted by Medical Priority with code: police on scene, checkout, bleeding from head [12/16/12 22:03:58 WMCGEE] 3\r",
        "UNIT:A75",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:HAMILTON CO JAIL",
        "ADDR:18100 CUMBERLAND RD",
        "CITY:NOBLESVILLE",
        "SRC:75",
        "INFO:Aborted by Medical Priority with code: police on scene, checkout, bleeding from head / 3",
        "DATE:12/16/12",
        "TIME:22:03:58");

    doTest("T25",
        "CAD:Update: MUTL AID 3801 E 196TH ST WES 83 [FIRE] ALARM CO IS ATTEMPTING REPS [12/16/12 19:27:15 KKEY] [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The ph\r",
        "CALL:MUTUAL AID - FIRE / HAZMAT",
        "ADDR:3801 E 196TH ST",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:ALARM CO IS ATTEMPTING REPS / Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The ph",
        "DATE:12/16/12",
        "TIME:19:27:15");

    doTest("T26",
        "CAD:E83 RESD ALM 3801 E 196TH ST WES 83 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The phone number of the business/resident/owner is not known\r",
        "UNIT:E83",
        "CALL:ALARM - RESIDENTIAL",
        "ADDR:3801 E 196TH ST",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:Alarms.Caller Statement: res fire alarm . 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: Melissa and brian Johnson 5. The area or zone activated is: gen smoke detector 6. The phone number of the business/resident/owner is not known");

    doTest("T27",
        "CAD:A82,E82,B8 10-50 PI SPRING MILL RD/W GREYHOUND PASS WES 82 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient injured in a traffic incident. The patient is a 45-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). Traffic / Transportation Incidents. Caller Statement: car vs motorcycle. 1. The incident involves an auto-motorcycle. [12/16/12 19:18:47 JMILLER] 1\r",
        "UNIT:A82,E82,B8",
        "CALL:PI ACCIDENT - REGULAR RESP",
        "ADDR:SPRING MILL RD & W GREYHOUND PASS",
        "CITY:WESTFIELD",
        "SRC:82",
        "INFO:You are responding to a patient injured in a traffic incident. The patient is a 45-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). Traffic / Transportation Incidents. Caller Statement: car vs motorcycle. 1. The incident involves an auto-motorcycle. / 1",
        "DATE:12/16/12",
        "TIME:19:18:47");

    doTest("T28",
        "CAD:E76,A72 CHST PNS 5682 FLINCHUM WAY N NOB (S)HAZEL DELL WOODS ADDITION (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with chest pain. The patient is a 82-year-old male, who is conscious and breathing. Not alert. Chest Pain (Non-Traumatic). Caller Statement: heart attack. 1. He is not completely alert (not responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths.\r",
        "UNIT:E76,A72",
        "CALL:CHEST PAINS",
        "ADDR:5682 FLINCHUM WAY N",
        "CITY:NOBLESVILLE",
        "PLACE:HAZEL DELL WOODS ADDITION",
        "SRC:76",
        "INFO:You are responding to a patient with chest pain. The patient is a 82-year-old male, who is conscious and breathing. Not alert. Chest Pain (Non-Traumatic). Caller Statement: heart attack. 1. He is not completely alert (not responding appropriately). 2. He is not breathing normally. 3. He has difficulty speaking between breaths.");

    doTest("T29",
        "CAD:A73,E71 SICK PSN 954-A DIVISION ST NOB 71 Event spawned from SERVICE CALL - WELFARE CHECK. [12/16/2012 16:48:47 JMILLER] 10-17 WORKS AT IMPD DISPATCH AND IS AT WORK NOW [12/16/12 16:31:57 NFAILOR] FATHER HOWARD VANSYCLE HAS BEEN SICK AND NOW THEY GET IN CONTACT WITH HIM. HIS PHONE NUMBER 410-2072 [12/16/12 16:31:21 NFAILOR] 3\r",
        "UNIT:A73,E71",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "ADDR:954-A DIVISION ST",
        "MADDR:954 DIVISION ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:10-17 WORKS AT IMPD DISPATCH AND IS AT WORK NOW / FATHER HOWARD VANSYCLE HAS BEEN SICK AND NOW THEY GET IN CONTACT WITH HIM. HIS PHONE NUMBER 410-2072 / 3",
        "DATE:12/16/2012",
        "TIME:16:48:47");

    doTest("T30",
        "CAD:E76 CARD ARR 5715 NOBLE CROSSING PKY E NOB (S)WEST HAVEN AT NOBLE WEST (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. [12/16/12 08:45:39 KGIBBONS] P\r",
        "UNIT:E76",
        "CALL:CARDIAC OR RESP ARREST / DEATH",
        "ADDR:5715 NOBLE CROSSING PKY E",
        "MADDR:5715 NOBLE CROSSING PKWY E",
        "CITY:NOBLESVILLE",
        "PLACE:WEST HAVEN AT NOBLE WEST",
        "SRC:76",
        "INFO:You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. / P",
        "DATE:12/16/12",
        "TIME:08:45:39");

    doTest("T31",
        "CAD:A82,E82 CARD ARR 5715 NOBLE CROSSING PKY E NOB (S)WEST HAVEN AT NOBLE WEST (N) 76 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. [12/16/12 08:45:39 KGIBBONS] 1\r",
        "UNIT:A82,E82",
        "CALL:CARDIAC OR RESP ARREST / DEATH",
        "ADDR:5715 NOBLE CROSSING PKY E",
        "MADDR:5715 NOBLE CROSSING PKWY E",
        "CITY:NOBLESVILLE",
        "PLACE:WEST HAVEN AT NOBLE WEST",
        "SRC:76",
        "INFO:You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 72-year-old female, who is conscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: poss doa. / 1",
        "DATE:12/16/12",
        "TIME:08:45:39");

    doTest("T32",
        "CAD:E82 INVEST 1506 W 151ST ST WES 82 [LAW] VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY [12/16/12 03:08:47 JPOYNTER] Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r",
        "UNIT:E82",
        "CALL:INVESTIGATION - FIRE",
        "ADDR:1506 W 151ST ST",
        "CITY:WESTFIELD",
        "SRC:82",
        "INFO:VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY / Event spawned from SERVICE CALL - SECURITY CHECK. / 4",
        "DATE:12/16/12",
        "TIME:03:08:47");

    doTest("T33",
        "CAD:Update: INVEST 1506 W 151ST ST WES 82 [LAW] VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY [12/16/12 03:08:47 JPOYNTER] Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r",
        "CALL:INVESTIGATION - FIRE",
        "ADDR:1506 W 151ST ST",
        "CITY:WESTFIELD",
        "SRC:82",
        "INFO:VACANT RES, SOMEONE HAS BURNED WOOD IN FIREPLACE. EVERYONE GONE THAT WAS THERE. HAVING WFD COME OUT AND DOUSE WOOD LOGS THAT WERE IN FIREPLACE JUST IN CASE. DON`T WANT RES TO CATCH FIRE ACCIDENTALLY / Event spawned from SERVICE CALL - SECURITY CHECK. / 4",
        "DATE:12/16/12",
        "TIME:03:08:47");

    doTest("T34",
        "CAD:FYI: ASST OTH 1506 W 151ST ST WES 82 Event spawned from SERVICE CALL - SECURITY CHECK. [12/16/2012 03:08:01 MWAGNER] 4\r",
        "CALL:SERVICE CALL - ASSIST OTH DEPT",
        "ADDR:1506 W 151ST ST",
        "CITY:WESTFIELD",
        "SRC:82",
        "INFO:4",
        "DATE:12/16/2012",
        "TIME:03:08:01");

    doTest("T35",
        "CAD:E73,A73 HRT PROB NOBLESVILLE FIRE - STATION 73 2101 GREENFIELD AVE NOB (S)WELLINGTON NORTHEAST (N) 73 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with heart problems. The patient is a 63-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Heart Problems / A.I.C.D.. Caller Statement: HEART PROBLEMS. 1. He is completely alert (responding appropriately). 2. He is not breathing normally.\r",
        "UNIT:E73,A73",
        "CALL:HEART PROBLEMS / A.I.C.D.",
        "PLACE:NOBLESVILLE FIRE - STATION",
        "ADDR:73 2101 GREENFIELD AVE",
        "CITY:NOBLESVILLE",
        "PLACE:WELLINGTON NORTHEAST",
        "SRC:73",
        "INFO:You are responding to a patient with heart problems. The patient is a 63-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Heart Problems / A.I.C.D.. Caller Statement: HEART PROBLEMS. 1. He is completely alert (responding appropriately). 2. He is not breathing normally.");

    doTest("T36",
        "CAD:A75,E75 ABD PAIN 19235 POTTERS BRIDGE RD NOB (S)POTTERS WOODS ADDITION (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with abdominal pain. The patient is a 70-year-old female, who is conscious and breathing. Females with pain above navel => 45. Abdominal Pain / Problems. Caller Statement: abdominal pain. 1. She is completely alert (responding appropriately). 2. The pain is described as: left side/dull side 3. T\r",
        "UNIT:A75,E75",
        "CALL:ABDOMINAL PAINS / PROBLEMS",
        "ADDR:19235 POTTERS BRIDGE RD",
        "CITY:NOBLESVILLE",
        "PLACE:POTTERS WOODS ADDITION",
        "SRC:75",
        "INFO:You are responding to a patient with abdominal pain. The patient is a 70-year-old female, who is conscious and breathing. Females with pain above navel => 45. Abdominal Pain / Problems. Caller Statement: abdominal pain. 1. She is completely alert (responding appropriately). 2. The pain is described as: left side/dull side 3. T");

    doTest("T37",
        "CAD:E81,L81,B8 GAS ODOR 18200-135 US 31 WES (S)NORTH GLEN VILLAGE (N) 81 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: stove has on in residence. 1. The caller is not on scene. 2. The odor is reportedly inside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is not on scene. 5. The problem is reportedly inside. 6. The gas can be smelled only. 7. The incident\r",
        "UNIT:E81,L81,B8",
        "CALL:HAZMAT - GAS ODOR",
        "ADDR:18200-135 US 31",
        "MADDR:18200 US 31",
        "CITY:WESTFIELD",
        "PLACE:NORTH GLEN VILLAGE",
        "SRC:81",
        "INFO:Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: stove has on in residence. 1. The caller is not on scene. 2. The odor is reportedly inside. ^ 3. The odor is of natural or LP gas. (Change from Protocol #66) 4. The caller is not on scene. 5. The problem is reportedly inside. 6. The gas can be smelled only. 7. The incident");

    doTest("T38",
        "CAD:E73,A73 STROKE 14294-101 BALD EAGLE DR NOB (S)PRAIRIE LAKES APARTMENTS (N) 73 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 83-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). 1. She is not completely alert (not responding appropriately). 2. She is breathing\r",
        "UNIT:E73,A73",
        "CALL:STROKE / CVA",
        "ADDR:14294-101 BALD EAGLE DR",
        "MADDR:14294 BALD EAGLE DR",
        "CITY:NOBLESVILLE",
        "PLACE:PRAIRIE LAKES APARTMENTS",
        "SRC:73",
        "INFO:You are responding to a patient who has apparently suffered a stroke. The patient is a 83-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). 1. She is not completely alert (not responding appropriately). 2. She is breathing");

    doTest("T39",
        "CAD:A75,E75,B7,R71 10-50 PI 2 19492 AMBER WAY NOB (S)MEADOWS (THE) (N) Radio Channel: FG 1 [12/15/12 19:53:31 NNELSON] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/15/2012 19:53:03 MBROWN] DRIVER WOULD LIKE A CHECK OUT [12/15/12 19:51:08 MBROWN] AIR BAGS DEPLOYED [12/15/12 19:50:33 MBROWN] VEH VS TREE [12/15/12 19:50:09 MBROWN] 75\r",
        "UNIT:A75,E75,B7,R71",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:19492 AMBER WAY",
        "CITY:NOBLESVILLE",
        "PLACE:MEADOWS (THE)",
        "INFO:Radio Channel: FG 1 / Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. / DRIVER WOULD LIKE A CHECK OUT / AIR BAGS DEPLOYED / VEH VS TREE / 75",
        "DATE:12/15/12",
        "TIME:19:53:31");

    doTest("T40",
        "CAD:MED ASST 19895 VICTORY CHAPEL RD NOB 15 1\r",
        "CALL:MUTUAL-AID - MEDICAL",
        "ADDR:19895 VICTORY CHAPEL RD",
        "CITY:NOBLESVILLE",
        "SRC:15",
        "INFO:1");

    doTest("T41",
        "CAD:FYI: MED ASST 19895 VICTORY CHAPEL RD NOB 15 2\r",
        "CALL:MUTUAL-AID - MEDICAL",
        "ADDR:19895 VICTORY CHAPEL RD",
        "CITY:NOBLESVILLE",
        "SRC:15",
        "INFO:2");

    doTest("T42",
        "CAD:A82 INJ PRSN MARSH SUPERMARKET 1960 E GREYHOUND PASS CAR 82 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 18-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now. 5. He is completely\r",
        "UNIT:A82",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:MARSH SUPERMARKET",
        "ADDR:1960 E GREYHOUND PASS",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:You are responding to a patient involved in a fall. The patient is a 18-year-old male, who is conscious and breathing. NOT DANGEROUS body area (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now. 5. He is completely");

    doTest("T43",
        "CAD:E83 MINOR PI E 196TH ST/US 31 NB WES 83 Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/15/2012 16:05:01 MBROWN] ford flex it has a wheelchair ramp on back. one of the witnesses is a nurse [12/15/12 16:00:54 DCRAIG] IN INTERSECTION - AND ANOTHER CAR JUST NORTH OF [12/15/12 15:59:21 MBACH] 3\r",
        "UNIT:E83",
        "CALL:PI ACCIDENT - MINOR RESP",
        "ADDR:E 196TH ST & US 31 NB",
        "MADDR:E 196TH ST & US 31",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:ford flex it has a wheelchair ramp on back. one of the witnesses is a nurse / IN INTERSECTION - AND ANOTHER CAR JUST NORTH OF / 3",
        "DATE:12/15/2012",
        "TIME:16:05:01");

    doTest("T44",
        "CAD:A75,E73 DIABETIC THIRD PHASE 15755 ALLISONVILLE RD NOB 73 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. [12/15/12 14:16:38 BIMMEL] 4\r",
        "UNIT:A75,E73",
        "CALL:DIABETIC PROBLEMS",
        "PLACE:THIRD PHASE",
        "ADDR:15755 ALLISONVILLE RD",
        "CITY:NOBLESVILLE",
        "SRC:73",
        "INFO:You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. / 4",
        "DATE:12/15/12",
        "TIME:14:16:38");

    doTest("T45",
        "CAD:E71 DIABETIC THIRD PHASE 15755 ALLISONVILLE RD NOB 73 use the front ent [12/15/12 14:17:30 BIMMEL] [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. [12/15/12 14:16:38 BIMMEL] 4\r",
        "UNIT:E71",
        "CALL:DIABETIC PROBLEMS",
        "PLACE:THIRD PHASE",
        "ADDR:15755 ALLISONVILLE RD",
        "CITY:NOBLESVILLE",
        "SRC:73",
        "INFO:use the front ent / You are responding to a patient with diabetic problems. The patient is a 45-year-old female, who is conscious and breathing. Alert and behaving normally. 1. She is completely alert (responding appropriately). 2. She is behaving normally now. 3. She is breathing normally. / 4",
        "DATE:12/15/12",
        "TIME:14:17:30");

    doTest("T46",
        "CAD:A73 INJ PRSN 10524 CUMBERLAND POINTE BLVD NOB (S)CUMBERLAND POINTE ADDITION (N) 73 [Medical Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 82-year-old male, who is conscious and breathing. NOT DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now.\r",
        "UNIT:A73",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "ADDR:10524 CUMBERLAND POINTE BLVD",
        "CITY:NOBLESVILLE",
        "PLACE:CUMBERLAND POINTE ADDITION",
        "SRC:73",
        "INFO:You are responding to a patient involved in a fall. The patient is a 82-year-old male, who is conscious and breathing. NOT DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is no bleeding now.");

    doTest("T47",
        "CAD:E73,R71 CIT ASST 131 S 6TH ST NOB 71 FEMALE NEEDS HELP GETTING HIM DOWN THE STAIRS [12/15/12 12:22:50 KGIBBONS] [Fire Priority Info] RESPONSE: Priority 4 RESPONDER SCRIPT: Citizen Assist / Service Call.Caller Statement: needs help down stairs. 1. The caller is on scene (1st party). 2. A CITIZEN ASSIST is needed: lift 3. No one is reportedly sick or injured. 4. The door is unlocked. -Comments: lift- [12/15/12 12:22:39 KGIBBONS] Aborted by Medical Priority with code:\r",
        "UNIT:E73,R71",
        "CALL:SERVICE CALL - ASSIST PUBLIC",
        "ADDR:131 S 6TH ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:FEMALE NEEDS HELP GETTING HIM DOWN THE STAIRS / Citizen Assist / Service Call.Caller Statement: needs help down stairs. 1. The caller is on scene (1st party). 2. A CITIZEN ASSIST is needed: lift 3. No one is reportedly sick or injured. 4. The door is unlocked. -Comments: lift- / Aborted by Medical Priority with code:",
        "DATE:12/15/12",
        "TIME:12:22:50");

    doTest("T48",
        "CAD:A73,E71 INJ PRSN 1267 S 6TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s not known how far she fell. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. She is completel\r",
        "UNIT:A73,E71",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "ADDR:1267 S 6TH ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient involved in a fall. The patient is a 87-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Falls. 1. This happened now (less than 6hrs ago). 2. It`s not known how far she fell. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. She is completel");

    doTest("T49",
        "CAD:Update: MUTL AID BLESSED THEODORE GUERIN HIGH S 15300 GRAY RD NOB 76 [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known. [12/15/12 11:07:08 NNELSO\r",
        "CALL:MUTUAL AID - FIRE / HAZMAT",
        "PLACE:BLESSED THEODORE GUERIN HIGH S",
        "ADDR:15300 GRAY RD",
        "CITY:NOBLESVILLE",
        "SRC:76",
        "INFO:Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known.",
        "DATE:12/15/12",
        "TIME:11:07:08");

    doTest("T50",
        "CAD:E76 INST ALM 2 BLESSED THEODORE GUERIN HIGH S 15300 GRAY RD NOB [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known. [12/15/12 11:07:08\r",
        "UNIT:E76",
        "CALL:ALARM - INSTITUTIONAL 2",
        "PLACE:BLESSED THEODORE GUERIN HIGH S",
        "ADDR:15300 GRAY RD",
        "CITY:NOBLESVILLE",
        "INFO:Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is not known. 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is not known.",
        "DATE:12/15/12",
        "TIME:11:07:08");

    doTest("T51",
        "CAD:E75,B7,E71 ODOR INV 19347 PACIFICA PL NOB (S)ROUDEBUSH FARMS ADDITION (N) 75 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire.Caller Statement: smell smoke in res. 1. The caller is on scene (1st party). 2. This is an odor of smoke with nothing visible. 3. The fire has not been extinguished. 4. The incident involves a single-family residential structure. 5. A multi-story structure is involved: 2 6. The caller has not indicated that there a\r",
        "UNIT:E75,B7,E71",
        "CALL:INVESTIGATION - ODOR",
        "ADDR:19347 PACIFICA PL",
        "CITY:NOBLESVILLE",
        "PLACE:ROUDEBUSH FARMS ADDITION",
        "SRC:75",
        "INFO:Structure Fire.Caller Statement: smell smoke in res. 1. The caller is on scene (1st party). 2. This is an odor of smoke with nothing visible. 3. The fire has not been extinguished. 4. The incident involves a single-family residential structure. 5. A multi-story structure is involved: 2 6. The caller has not indicated that there a");

    doTest("T52",
        "CAD:A75,E75 UNKN MED CONNER ST/SR 37 NOB 75 [LAW] REPORT OF ELDERLY MALE LAYI [12/15/12 07:35:11 DCRAIG] [Medical Priority Update] Medical Priority reconfigured event from to 32-D-01. RESPONDER SCRIPT: You are responding to a patient with an unknown problem (man down). The patient is a 55-year-old male, who is conscious and breathing. LIFE STATUS QUESTIONABLE. Caller Statement: man down. 1. No special circumstances. 2. He does not appear to be completely awake (alert).\r",
        "UNIT:A75,E75",
        "CALL:UNKNOWN MEDICAL PROBLEM",
        "ADDR:CONNER ST & SR 37",
        "MADDR:CONNER ST & IN 37",
        "CITY:NOBLESVILLE",
        "SRC:75",
        "INFO:REPORT OF ELDERLY MALE LAYI / Medical Priority reconfigured event from to 32-D-01. RESPONDER SCRIPT: You are responding to a patient with an unknown problem (man down). The patient is a 55-year-old male, who is conscious and breathing. LIFE STATUS QUESTIONABLE. Caller Statement: man down. 1. No special circumstances. 2. He does not appear to be completely awake (alert).",
        "DATE:12/15/12",
        "TIME:07:35:11");

    doTest("T53",
        "CAD:E83,A82,E82 CARD ARR BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR 82 room 501 [12/15/12 07:28:23 JGIORDANO] [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 80-year-old male, who is unconscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: cardiac arrest. [12/15/12 07:28:15 JGIORDANO] P\r",
        "UNIT:E83,A82,E82",
        "CALL:CARDIAC OR RESP ARREST / DEATH",
        "PLACE:BRIDGEWATER KINDRED TRANSITION",
        "ADDR:14751 CAREY RD",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:room 501 / You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 80-year-old male, who is unconscious and not breathing. Not breathing at all. Cardiac or Respiratory Arrest / Death. Caller Statement: cardiac arrest. / P",
        "DATE:12/15/12",
        "TIME:07:28:23");

    doTest("T54",
        "CAD:A75,E75,B7,R71 10-50 PI 2 E 206TH ST/SR 37 NOB law enforcement on scene [12/15/12 03:43:33 JGIORDANO] 22 y/o co head pain from rolling his veh x2 [12/15/12 03:43:18 JGIORDANO] 75\r",
        "UNIT:A75,E75,B7,R71",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:E 206TH ST & SR 37",
        "MADDR:E 206TH ST & IN 37",
        "CITY:NOBLESVILLE",
        "INFO:law enforcement on scene / 22 y/o co head pain from rolling his veh x2 / 75",
        "DATE:12/15/12",
        "TIME:03:43:33");

    doTest("T55",
        "CAD:A81,E83 INJ PRSN SANDERS GLEN APARTMENTS 334 S CHERRY ST WES 83 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 83-year-old male, who is conscious and breathing. Not alert. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. He is not compl\r",
        "UNIT:A81,E83",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:SANDERS GLEN APARTMENTS",
        "ADDR:334 S CHERRY ST",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:You are responding to a patient involved in a fall. The patient is a 83-year-old male, who is conscious and breathing. Not alert. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The reason for the fall is not known. 4. There is no bleeding now. 5. He is not compl");

    doTest("T56",
        "CAD:FYI: MUTL AID 10774 CLUB CHASE FIS 92 2\r",
        "CALL:MUTUAL AID - FIRE / HAZMAT",
        "ADDR:10774 CLUB CHASE",
        "CITY:FISHERS",
        "SRC:92",
        "INFO:2");

    doTest("T57",
        "CAD:Update: E73,A73 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) Radio Channel: FG 3 [12/14/12 21:38:37 JMILLER] UDTS: {B7} WORKING INCIDENT - NOBLES [12/14/12 21:38:16 JMILLER] (B7) WATER ON THE FIRE [12/14/12 21:38:06 NNELSON] DUKE CLR--TICKET # D1525465--UNK ETA [12/14/12 21:36:25 MBROWN] Radio Channel: FG 3 [12/14/12 21:36:07 NNELSON] EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF [12/14/12 21:34:50 JMILLER] VECTREN DOES NOT SHOW GAS SERVICE AT THIS\r",
        "UNIT:E73,A73",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "CH:FG 3",
        "INFO:Radio Channel: FG 3 / UDTS: {B7} WORKING INCIDENT - NOBLES / (B7) WATER ON THE FIRE / DUKE CLR--TICKET # D1525465--UNK ETA / EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF / VECTREN DOES NOT SHOW GAS SERVICE AT THIS",
        "DATE:12/14/12",
        "TIME:21:38:37");

    doTest("T58",
        "CAD:{B7} WORKING INCIDENT - NOBLES;19502 ROCKY BEACH DR; NOB(S)MORSE POINTE ADDITION (N);STRUCTURE FIRE - RESIDENTIAL\r",
        "CALL:{B7} WORKING INCIDENT - NOBLES",
        "INFO:19502 ROCKY BEACH DR / NOB(S)MORSE POINTE ADDITION (N) / STRUCTURE FIRE - RESIDENTIAL");

    doTest("T59",
        "CAD:RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) Radio Channel: FG 3 [12/14/12 21:36:07 NNELSON] EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF [12/14/12 21:34:50 JMILLER] VECTREN DOES NOT SHOW GAS SERVICE AT THIS ADDRESS [12/14/12 21:33:09 MBROWN] [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4.\r",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "INFO:Radio Channel: FG 3 / EVAC COMPLETE, LIGHT SMOKE SHOWING, FROM ROOF / VECTREN DOES NOT SHOW GAS SERVICE AT THIS ADDRESS / Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4.",
        "DATE:12/14/12",
        "TIME:21:36:07");

    doTest("T60",
        "CAD:Update: E83 MUTL AID 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) 72 [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 2\r",
        "UNIT:E83",
        "CALL:MUTUAL AID - FIRE / HAZMAT",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "SRC:72",
        "INFO:Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). / 2",
        "DATE:12/14/12",
        "TIME:21:29:26");

    doTest("T61",
        "CAD:E72,E76,L74,R71,A72 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r",
        "UNIT:E72,E76,L74,R71,A72",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "INFO:Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). / 72",
        "DATE:12/14/12",
        "TIME:21:29:26");

    doTest("T62",
        "CAD:E83 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r",
        "UNIT:E83",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "INFO:Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). / 72",
        "DATE:12/14/12",
        "TIME:21:29:26");

    doTest("T63",
        "CAD:E72,E76,L74,R71,A72 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r",
        "UNIT:E72,E76,L74,R71,A72",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "INFO:Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). / 72",
        "DATE:12/14/12",
        "TIME:21:29:26");

    doTest("T64",
        "CAD:E83 RES FIRE 1 19502 ROCKY BEACH DR NOB (S)MORSE POINTE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). [12/14/12 21:29:26 NNELSON] 72\r",
        "UNIT:E83",
        "CALL:STRUCTURE FIRE - RESIDENTIAL 1",
        "ADDR:19502 ROCKY BEACH DR",
        "CITY:NOBLESVILLE",
        "PLACE:MORSE POINTE ADDITION",
        "INFO:Structure Fire. 1. The caller is on scene (1st party). 2. Flames are visible. 3. The incident involves a single-family residential structure. 4. A single-level structure is involved. 5. The caller has not indicated that there are trapped person(s). / 72",
        "DATE:12/14/12",
        "TIME:21:29:26");

    doTest("T65",
        "CAD:B7,E71 METH LAB 4 LOPEZ RES 1098 S 8TH ST NOB Event spawned from SUPPLEMENTAL - CASE FOLLOW UP. [12/14/2012 21:27:53 MBROWN] CONTACTING STATE POLICE [12/14/12 21:27:17 CTRIETSCH] 10-17 at npd. no tx. was advised she could come and speak with offc hargrove ref susp drug activity in her home. [12/14/12 20:45:29 MHAMILTON] 71\r",
        "UNIT:B7,E71",
        "CALL:HAZMAT - METH / DRUG LABS",
        "ADDR:4 LOPEZ RES 1098 S 8TH ST",
        "CITY:NOBLESVILLE",
        "INFO:CONTACTING STATE POLICE / 10-17 at npd. no tx. was advised she could come and speak with offc hargrove ref susp drug activity in her home. / 71",
        "DATE:12/14/2012",
        "TIME:21:27:53");

    doTest("T66",
        "CAD:VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 bat8 requested paddacks to call his cell and to respond to the scene [12/14/12 21:16:22 JMILLER] AFFECTED UNIT IS TOTAL ELECTRIC AND NO GAS SERVICE, ELECTRIC HAS BEEN SECURED [12/14/12 20:59:22 JMILLER] 131 CLEAR FOR UNITS TO ENTER [12/14/12 20:58:29 JMILLER] UNIT 127 CLEARED FOR RESIDENTS TO RETURN, UNIT 129 IS AFFECTED, UNIT 131 IS BEING CHECKED [12/14/12 20:50:27 JMILLER] screws entering structure to check f\r",
        "CALL:PI ACCIDENT - VEH INTO BLDG",
        "ADDR:129 COATSVILLE DR",
        "CITY:WESTFIELD",
        "PLACE:COUNTRYSIDE ADDITION",
        "SRC:81",
        "INFO:bat8 requested paddacks to call his cell and to respond to the scene / AFFECTED UNIT IS TOTAL ELECTRIC AND NO GAS SERVICE, ELECTRIC HAS BEEN SECURED / 131 CLEAR FOR UNITS TO ENTER / UNIT 127 CLEARED FOR RESIDENTS TO RETURN, UNIT 129 IS AFFECTED, UNIT 131 IS BEING CHECKED / screws entering structure to check f",
        "DATE:12/14/12",
        "TIME:21:16:22");

    doTest("T67",
        "CAD:L74,A72 UNKN MED EDMONDS,ANTHONY W 99 LIONS CREEK CT S NOB (S)LIONS CREEK APARTMENTS (N) 74 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient with an unknown problem (man down). The patient is a 30-year-old male, who is conscious and breathing. Standing, sitting, moving, or talking. Caller Statement: UNK. 1. No special circumstances. 2. It`s not known if he appears to be completely awake (alert). 3. He was heard talking.\r",
        "UNIT:L74,A72",
        "CALL:UNKNOWN MEDICAL PROBLEM",
        "PLACE:EDMONDS,ANTHONY W",
        "ADDR:99 LIONS CREEK CT S",
        "CITY:NOBLESVILLE",
        "PLACE:LIONS CREEK APARTMENTS",
        "SRC:74",
        "INFO:You are responding to a patient with an unknown problem (man down). The patient is a 30-year-old male, who is conscious and breathing. Standing, sitting, moving, or talking. Caller Statement: UNK. 1. No special circumstances. 2. It`s not known if he appears to be completely awake (alert). 3. He was heard talking.");

    doTest("T68",
        "CAD:E83,A82 DIFF BRE IMMI - INDIANA MILLS AND MFG 18881 US 31 WES 83 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 39-year-old male, who is conscious and breathing. Not alert. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. [12/14/12 20:19:49 NNELSON] 1\r",
        "UNIT:E83,A82",
        "CALL:BREATHING PROBLEMS",
        "PLACE:IMMI - INDIANA MILLS AND MFG",
        "ADDR:18881 US 31",
        "CITY:WESTFIELD",
        "SRC:83",
        "INFO:You are responding to a patient with breathing problems. The patient is a 39-year-old male, who is conscious and breathing. Not alert. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. / 1",
        "DATE:12/14/12",
        "TIME:20:19:49");

    doTest("T69",
        "CAD:A75,E71 DIFF BRE MATTEOS RISTORANTE ITALIANO 40 N 9TH ST NOB 71 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 70-year-old male, who is conscious and breathing. Not alert. Caller Statement: DIFF BREATHING. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. [12/14/12 20:15:40 MBROWN] 1\r",
        "UNIT:A75,E71",
        "CALL:BREATHING PROBLEMS",
        "PLACE:MATTEOS RISTORANTE ITALIANO",
        "ADDR:40 N 9TH ST",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient with breathing problems. The patient is a 70-year-old male, who is conscious and breathing. Not alert. Caller Statement: DIFF BREATHING. 1. He is not completely alert (not responding appropriately). 2. He has difficulty speaking between breaths. / 1",
        "DATE:12/14/12",
        "TIME:20:15:40");

    doTest("T70",
        "CAD:A81,TAC80,E81,E82,B8 VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 1\r",
        "UNIT:A81,TAC80,E81,E82,B8",
        "CALL:PI ACCIDENT - VEH INTO BLDG",
        "ADDR:129 COATSVILLE DR",
        "CITY:WESTFIELD",
        "PLACE:COUNTRYSIDE ADDITION",
        "SRC:81",
        "INFO:1");

    doTest("T71",
        "CAD:A81,TAC80,E81,E82,B8 VEH BLDG 129 COATSVILLE DR WES (S)COUNTRYSIDE ADDITION (N) 81 1\r",
        "UNIT:A81,TAC80,E81,E82,B8",
        "CALL:PI ACCIDENT - VEH INTO BLDG",
        "ADDR:129 COATSVILLE DR",
        "CITY:WESTFIELD",
        "PLACE:COUNTRYSIDE ADDITION",
        "SRC:81",
        "INFO:1");

    doTest("T72",
        "CAD:A73 INJ PRSN PRAIRIE LAKES NURSING HOME 9730 PRAIRIE LAKES BLVD E NOB 73 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient involved in a fall. The patient is a 85-year-old male, who is conscious and breathing. POSSIBLY DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is some bleeding, not ser\r",
        "UNIT:A73",
        "CALL:TRAUMATIC INJURIES (SPECIFIC)",
        "PLACE:PRAIRIE LAKES NURSING HOME",
        "ADDR:9730 PRAIRIE LAKES BLVD E",
        "CITY:NOBLESVILLE",
        "SRC:73",
        "INFO:You are responding to a patient involved in a fall. The patient is a 85-year-old male, who is conscious and breathing. POSSIBLY DANGEROUS body area. Falls. Caller Statement: fall. 1. This happened now (less than 6hrs ago). 2. It`s reported that he fell at ground level. 3. The fall was accidental. 4. There is some bleeding, not ser");

    doTest("T73",
        "CAD:Update: E83 MUTL AID 17967 CANDLEWOOD CT NOB (S)VILLAGES AT PEBBLE BROOK (N) 76 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is:\r",
        "UNIT:E83",
        "CALL:MUTUAL AID - FIRE / HAZMAT",
        "ADDR:17967 CANDLEWOOD CT",
        "CITY:NOBLESVILLE",
        "PLACE:VILLAGES AT PEBBLE BROOK",
        "SRC:76",
        "INFO:Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is:");

    doTest("T74",
        "CAD:E76 RESD ALM 17967 CANDLEWOOD CT NOB (S)VILLAGES AT PEBBLE BROOK (N) 76 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner\r",
        "UNIT:E76",
        "CALL:ALARM - RESIDENTIAL",
        "ADDR:17967 CANDLEWOOD CT",
        "CITY:NOBLESVILLE",
        "PLACE:VILLAGES AT PEBBLE BROOK",
        "SRC:76",
        "INFO:Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: joe bejin 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner");

    doTest("T75",
        "CAD:E83,E81 RESD ALM 18525 HARVEST MEADOWS DR E WES (S)HARVEST MEADOWS (N) 83 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Alarms.Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a keypad (manual) alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: MANEIRO 5. The area or zone activated is: KEY PAD, GEN FIRE 6. The phone number of the business/resident/owner\r",
        "UNIT:E83,E81",
        "CALL:ALARM - RESIDENTIAL",
        "ADDR:18525 HARVEST MEADOWS DR E",
        "CITY:WESTFIELD",
        "PLACE:HARVEST MEADOWS",
        "SRC:83",
        "INFO:Alarms.Caller Statement: ALARM. 1. The caller is an alarm monitoring company. 2. It is a keypad (manual) alarm. 3. The incident involves a single-family residential structure. 4. The name of the business/resident/owner is: MANEIRO 5. The area or zone activated is: KEY PAD, GEN FIRE 6. The phone number of the business/resident/owner");

    doTest("T76",
        "CAD:E81,E82,L81,B8 INST ALM 2 ST MARIA GORETTI SCHOOL 17104 SPRING MILL RD WES (S)MAPLE VILLAGE ADDITION (N) [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a pull station. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: st maria 5. The exact area or zone activated is not known. 6. The phone number o\r",
        "UNIT:E81,E82,L81,B8",
        "CALL:ALARM - INSTITUTIONAL 2",
        "PLACE:ST MARIA GORETTI SCHOOL",
        "ADDR:17104 SPRING MILL RD",
        "CITY:WESTFIELD",
        "PLACE:MAPLE VILLAGE ADDITION",
        "INFO:Alarms.Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a pull station. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: st maria 5. The exact area or zone activated is not known. 6. The phone number o");

    doTest("T77",
        "CAD:S77 SEIZURE EARTH FARE 13145 LEVINSON LN NOB 77 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 50-year-old male, who is unconscious and breathing. Effective breathing not verified => 35. Convulsions / Seizures. Caller Statement: SEIZ. 1. This is apparently a generalized (grand mal) seizure. 2. He has not had more than one seizure in a row. 3. It`s not known if he is diabetic.\r",
        "UNIT:S77",
        "CALL:CONVULSIONS / SEIZURES",
        "PLACE:EARTH FARE",
        "ADDR:13145 LEVINSON LN",
        "CITY:NOBLESVILLE",
        "SRC:77",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 50-year-old male, who is unconscious and breathing. Effective breathing not verified => 35. Convulsions / Seizures. Caller Statement: SEIZ. 1. This is apparently a generalized (grand mal) seizure. 2. He has not had more than one seizure in a row. 3. It`s not known if he is diabetic.");

    doTest("T78",
        "CAD:E72 GAS ODOR PASADENA RD/SHERIDAN RD NOB 72 [Fire Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: GAS ODOR. 1. The caller is not on scene. 2. The problem is reportedly outside. 3. The gas can be smelled only. 4. It is not known where the leak is coming from, but there is an odor. 5. No one is reportedly sick or injured. [12/14/12 13:42:23 HSYLTE] 3\r",
        "UNIT:E72",
        "CALL:HAZMAT - GAS ODOR",
        "ADDR:PASADENA RD & SHERIDAN RD",
        "CITY:NOBLESVILLE",
        "SRC:72",
        "INFO:Gas Leak / Gas Odor (Natural and LP Gases).Caller Statement: GAS ODOR. 1. The caller is not on scene. 2. The problem is reportedly outside. 3. The gas can be smelled only. 4. It is not known where the leak is coming from, but there is an odor. 5. No one is reportedly sick or injured. / 3",
        "DATE:12/14/12",
        "TIME:13:42:23");

    doTest("T79",
        "CAD:A75,E75,B7,L77 10-50 PI 2 E SR 38/E SR 32 NOB [LAW] poss head injury [12/14/12 13:35:05 LUHRICK] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/14/2012 13:34:54 JGIORDANO] motorcycle [12/14/12 13:34:19 LUHRICK] 75\r",
        "UNIT:A75,E75,B7,L77",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:E SR 38 & E SR 32",
        "MADDR:E ST 38 & E ST 32",
        "CITY:NOBLESVILLE",
        "INFO:poss head injury / Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. / motorcycle / 75",
        "DATE:12/14/12",
        "TIME:13:35:05");

    doTest("T80",
        "CAD:B7,R71,A72,E71 10-50 PI 2 RIVER RD/WESTFIELD RD NOB [LAW] female bleeding from mouth [12/14/12 12:52:44 LUHRICK] Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. [12/14/2012 12:52:39 JGIORDANO] small 4 dr beige car [12/14/12 12:52:12 LUHRICK] ADDITIONAL CALLER AMBER EATON 317-697-8326 [12/14/12 12:51:59 AHAAS] car vs pole [12/14/12 12:51:47 LUHRICK] 71\r",
        "UNIT:B7,R71,A72,E71",
        "CALL:PI ACCIDENT - REGULAR RESP 2",
        "ADDR:RIVER RD & WESTFIELD RD",
        "CITY:NOBLESVILLE",
        "INFO:female bleeding from mouth / Event spawned from TRNSPRTN ACDNT - MV PRSNL INJ. / small 4 dr beige car / ADDITIONAL CALLER AMBER EATON 317-697-8326 / car vs pole / 71",
        "DATE:12/14/12",
        "TIME:12:52:44");

    doTest("T81",
        "CAD:E81 SICK PSN 17735 JOLIET RD SHE (S)JOLIETVILLE (N) 81 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I\r",
        "UNIT:E81",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "ADDR:17735 JOLIET RD",
        "CITY:SHERIDAN",
        "PLACE:JOLIETVILLE",
        "SRC:81",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I");

    doTest("T82",
        "CAD:A81 SICK PSN 17735 JOLIET RD SHE (S)JOLIETVILLE (N) 81 [Medical Priority Info] RESPONSE: Priority 3 RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I\r",
        "UNIT:A81",
        "CALL:SICK PRSN - SPECIFIC DIAGNOSIS",
        "ADDR:17735 JOLIET RD",
        "CITY:SHERIDAN",
        "PLACE:JOLIETVILLE",
        "SRC:81",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. Sick Person (Specific Diagnosis). Caller Statement: DIFF WALKING. 1. It`s not known if she is completely alert (responding appropriately). 2. I");

    doTest("T83",
        "CAD:E73,A73 DIFF BRE 444 WESTMINSTER DR NOB (S)WELLINGTON NORTH (N) 73 81 y/o female awake and breathing. [12/14/12 12:30:39 JGIORDANO] 2\r",
        "UNIT:E73,A73",
        "CALL:BREATHING PROBLEMS",
        "ADDR:444 WESTMINSTER DR",
        "CITY:NOBLESVILLE",
        "PLACE:WELLINGTON NORTH",
        "SRC:73",
        "INFO:81 y/o female awake and breathing. / 2",
        "DATE:12/14/12",
        "TIME:12:30:39");

    doTest("T84",
        "CAD:A82,E82 UNCN PSN BRIDGEWATER KINDRED TRANSITION 14751 CAREY RD CAR 82 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old male, who is conscious and breathing. CHANGING COLOR. Unconscious / Fainting (Near). 1. His breathing is completely normal. 2. He is completely alert (responding appropriately). 3. He is changing color. 4. His color change is ashen. [12\r",
        "UNIT:A82,E82",
        "CALL:UNCONSCIOUS / FAINTING",
        "PLACE:BRIDGEWATER KINDRED TRANSITION",
        "ADDR:14751 CAREY RD",
        "CITY:CARMEL",
        "SRC:82",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 66-year-old male, who is conscious and breathing. CHANGING COLOR. Unconscious / Fainting (Near). 1. His breathing is completely normal. 2. He is completely alert (responding appropriately). 3. He is changing color. 4. His color change is ashen.");

    doTest("T85",
        "CAD:E83,E82,B8 INST ALM 2 RAINBOW CHILD DEVELOPMENT CTR 17457 GUNTHER BLVD WES [Fire Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: RCD 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is: 2485692500 -Comments: RC\r",
        "UNIT:E83,E82,B8",
        "CALL:ALARM - INSTITUTIONAL 2",
        "PLACE:RAINBOW CHILD DEVELOPMENT CTR",
        "ADDR:17457 GUNTHER BLVD",
        "CITY:WESTFIELD",
        "INFO:Alarms. 1. The caller is an alarm monitoring company. 2. It is a general/fire alarm. 3. The type of structure (environment) involves a HIGH LIFE HAZARD. 4. The name of the business/resident/owner is: RCD 5. The exact area or zone activated is not known. 6. The phone number of the business/resident/owner is: 2485692500 -Comments: RC");

    doTest("T86",
        "CAD:A75,E71 STROKE HAM CO JUDICIAL CENTER 1 HAMILTON COUNTY SQ NOB 71 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has apparently suffered a stroke. The patient is a 78-year-old female, who is conscious and breathing. Breathing normally => 35 (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stoke. 1. She is completely alert (responding appropriately).\r",
        "UNIT:A75,E71",
        "CALL:STROKE / CVA",
        "PLACE:HAM CO JUDICIAL CENTER",
        "ADDR:1 HAMILTON COUNTY SQ",
        "CITY:NOBLESVILLE",
        "SRC:71",
        "INFO:You are responding to a patient who has apparently suffered a stroke. The patient is a 78-year-old female, who is conscious and breathing. Breathing normally => 35 (Less than ___ hours since the symptoms started). Stroke (CVA) / Transient Ischemic Attack (TIA). Caller Statement: stoke. 1. She is completely alert (responding appropriately).");

    doTest("T87",
        "CAD:A81,E83 MED ???? 414 SAVANNAH LN WES (S)SILVER LAKES (N) 83 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient who has had a seizure. The patient is a 61-year-old male, who is unconscious and breathing. FOCAL seizure (not alert). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. He is diabetic. 3. It`s not known if he is an epileptic (diagnosed with a seizure disorder). 4. He has a histor\r",
        "UNIT:A81,E83",
        "CALL:MED ????",
        "ADDR:414 SAVANNAH LN",
        "CITY:WESTFIELD",
        "PLACE:SILVER LAKES",
        "SRC:83",
        "INFO:You are responding to a patient who has had a seizure. The patient is a 61-year-old male, who is unconscious and breathing. FOCAL seizure (not alert). Convulsions / Seizures. Caller Statement: seizure. 1. This is a FOCAL seizure. 2. He is diabetic. 3. It`s not known if he is an epileptic (diagnosed with a seizure disorder). 4. He has a histor");

    doTest("T88",
        "CAD:A75,E75 DIFF BRE HAM CO COMMUNITY CORRECTIONS 18104 CUMBERLAND RD NOB 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: diff breathing. 1. He is completely alert (responding appropriately). 2. He does not have any difficulty speaking between breaths. 3. It`s not known if he is changing color.\r",
        "UNIT:A75,E75",
        "CALL:BREATHING PROBLEMS",
        "PLACE:HAM CO COMMUNITY CORRECTIONS",
        "ADDR:18104 CUMBERLAND RD",
        "CITY:NOBLESVILLE",
        "SRC:75",
        "INFO:You are responding to a patient with breathing problems. The patient is a 23-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: diff breathing. 1. He is completely alert (responding appropriately). 2. He does not have any difficulty speaking between breaths. 3. It`s not known if he is changing color.");

    doTest("T89",
        "CAD:A75,E75 DIFF BRE 555-I KINGS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 1 RESPONDER SCRIPT: You are responding to a patient with breathing problems. The patient is a 10-month-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: diff breath. 1. He is completely alert (responding appropriately). 2. He has difficulty crying between breaths. [12/13/12 22:29:52 DSTILTS] 1\r",
        "UNIT:A75,E75",
        "CALL:BREATHING PROBLEMS",
        "ADDR:555-I KINGS LN",
        "MADDR:555 KINGS LN",
        "CITY:NOBLESVILLE",
        "PLACE:NOBLE MANOR APARTMENTS",
        "SRC:75",
        "INFO:You are responding to a patient with breathing problems. The patient is a 10-month-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: diff breath. 1. He is completely alert (responding appropriately). 2. He has difficulty crying between breaths. / 1",
        "DATE:12/13/12",
        "TIME:22:29:52");

    doTest("T90",
        "CAD:A75,E75 DIABETIC 104 QUEENS LN NOB (S)NOBLE MANOR APARTMENTS (N) 75 [Medical Priority Info] RESPONSE: Priority 2 RESPONDER SCRIPT: You are responding to a patient with diabetic problems. The patient is a 49-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: DIAB. 1. He is completely alert (responding appropriately). 2. He is behaving normally now. 3. He is not breathing normally. [12/13/12 21:20:57 MBROWN] 2\r",
        "UNIT:A75,E75",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:104 QUEENS LN",
        "CITY:NOBLESVILLE",
        "PLACE:NOBLE MANOR APARTMENTS",
        "SRC:75",
        "INFO:You are responding to a patient with diabetic problems. The patient is a 49-year-old male, who is conscious and breathing. Abnormal breathing. Caller Statement: DIAB. 1. He is completely alert (responding appropriately). 2. He is behaving normally now. 3. He is not breathing normally. / 2",
        "DATE:12/13/12",
        "TIME:21:20:57");

  }
  
  public static void main(String[] args) {
    new INHamiltonCountyBParserTest().generateTests("T1");
  }
}