package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Washington County, MD
Contact: "Snyder, Jon" <JSnyder@sems79.org>
Sender: "Dispatch@washco-md.net" <Dispatch@washco-md.net>
System: Keystone Public Safety

MAPLEVILLE RD / CHEWSVILLE RD - PIC, PERS INJURY COLLISION - CO16,RSQE7,R79,SO20 - 1106957 15:38
73 S MAIN ST - FALLS,BACK INJURIES - R79 - 1106940 12:07 2nd ALERT!
14518 MARYLAND AVE - STROKE - FAA4,R79,CO9 - 1106937 11:31
13730 MAUGANSVILLE RD, MAUGANSVILLE FIRE COMPANY - TRANSFER OF UNIT, - CO26,CO9 - 1106889 16:55
LEHMANS MILL RD - WATER RESCUE - - CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79 - 1106823 23:27 2nd ALERT!
FRE CO, N FRANKLINVILLE RD/RT15 - THURMONT - WATER RESCUE - - RSQE7 - TAC 30 1106797 21:01
FRE CO, 15204 QUIRAUK SCHOOL RD - NAT GAS LEAK - CO7,R79,P791,RSQE7 - FIRE 60 1106779 19:49
21348 OLD FORGE RD, ST PETERS BEARD LUTHERAN CHURCH - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO9 - 1106753 16:45
INTERSTATE 70, EXIT35 I70 EB - PIC, PERS INJURY COLLISION - CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75 - 1106746 16:21
22507 JEFFERSON BLVD, AC&T SMITHSBURG - EYE PROBLEMS,INJURIES - R79 - 1106670 16:20
20354 LEITERSBURG PIKE, PEN MAR TRAILER SALES INC - NAT GAS ODOR - CO9 - 1106635 00:13
LEITERSBURG PIKE / MILLERS CHURCH RD - PIC, PERS INJURY COLLISION - CO9,R75,P753,R79 - 1106553 22:22
MAPLEVILLE RD / JEFFERSON BLVD - PIC, PERS INJURY COLLISION - CO7,R79,M791,SUP70,P792,C79,RSQE7 - 1106339 12:40
INTERSTATE 70, 32MM I70 AT REST AREA - ABDOMINAL PAIN - PROBLEMS - R75,R79,CO10 - 1106419 16:28\nDo Not REPLY to this email!!!

Contact: Jim A <skidooxman@gmail.com>
Sender: TextAlert@sems79.org
CHEWSVILLE RD / WHITE HALL RD, AREA - SMOKE INVESTIGATION - CO16,SO20,CO7,RS20,E161,E74,ET7 - 1117561 07:46\nDo Not REPLY to this email!!!

Contact: cj rinehart <cjrr_10@hotmail.com>
Sender: rc.429@c-msg.net
S:WCo M:[!] 136 WISHING STAR CT  ,STAB  ,GUNSHOT  ,R75  ,CO10  ,1120268 23:48\n\n\n
S:WCo M:[!] 11403 STONECROFT CT  , STONECROFT APARTMENTS BUILDING A APT 209  ,CHEST PAIN  ,R75  ,CO10  ,1120271 02:16
S:WCo M:[!] 1800 DUAL HWY  , SUSQUEHANNA BANK STE 100 REAR OF  ,SMOKE INVESTIGATION  ,E03  ,CO10  ,UT3  ,1120229 07:12
S:WCo M:[!] 300 N COLONIAL DR  , APT E  ,HOUSE FIRE  ,CO10  ,E03  ,E01  ,TRK1  ,S75  ,R75  ,SO20  ,1120236 09:48
S:WCo M:[!] 136 WISHING STAR CT  ,STAB  ,GUNSHOT  ,R75  ,CO10  ,1120268 23:48
S:WCo M:[!] 17567 YORK RD  , WESTERN SIZZLIN STEAK HOUSE  ,ODOR OF SMOKE  ,CO26  ,CO10  ,CO2  ,TWR26  ,RS10  ,R26  ,1120262 22:1

Contact: "ForbergerJames@yahoo.com" <ForbergerJames@yahoo.com>
Sender: support@cadpage.org
WCo / [!] 1396 S POTOMAC ST, SHEETZ - PIC, PERS INJURY COLLISION - E05,R75,UT3 - 1200168 10:39\n\n

Contact: richard Gilbert <rgilbert65@gmail.com>
Sender: rc.327@c-msg.net
Subject:CAD\n[!] W FRANKLIN ST / N BURHANS BLVD - PIC, PERS INJURY COLLISION - E04,S75,S754,UT3 - Traffic / Transportation Accident (Crash). 12\r

Contact:  francisco martinez <franco26_99@yahoo.com>
Sender: rc.257@c-msg.net
485 ANTIETAM DR, AREA OF - [JEFFERSON BLVD - SECURITY RD @ RR TRACKS] - PIC, PERS INJURY COLLISION - CO27,E03,R75 - Age unknown, F

Contact: support@active911.com
Sender: rc.337@c-msg.net
Subject: WCo\n[!] 17850 GARLAND GROH BLVD, SUPER WALMART CENTER - Accident - Property Damage - 9C16 - Traffic / Transportation Accident (Crash). 11:57
Subject: WCo\n[!] INTERSTATE 81 / I70 - PIC, PERS INJURY COLLISION - CO26,CO2,RSQE2,R26,R2 - 1208763 11:59
Subject: WCo\n[!] VIRGINIA AVE / W WILSON BLVD - Accident - Property Damage - 9C21 - Traffic / Transportation Accident (Crash). 12:10
Subject: WCo\n[!] 222 OTHO HOLLAND DR - UNCONSCIOUSNESS,FAINTING - R26 - 87 year old, Female, Unconscious, Breathing. - **ALS HOT*- Unconscious – Effective breathing 1208767 12:41 2nd ALERT!
Subject: WCo\n[!] 365 WOODPOINT AVE - PSYCHIATRIC,SUICIDE ATTEMPT - R26,E04 - Mental Disorder (Behavioral Problems). 1208777 13:32
Subject: WCo\n[!] 11346 LAKESIDE DR - FALLS,BACK INJURIES - R49,CO26 - 85 year old, Male, Conscious, Breathing. - **BLS-ALPHA *** On ground or floor - PUBLIC ASSIST (no injuries and no priority symptoms) 1208778 13:36
Subject: WCo\n[!] 1321 S POTOMAC ST, E RUSSELL HICKS MIDDLE SCHOOL - Accident - Property Damage - 9C20 - Traffic / Transportation Accident (Crash). 16:01
Subject: WCo\n[!] JONATHAN ST / CHURCH ST - Accident - Property Damage - 9E32 - 16:01
Subject: WCo\n[!] 14 N POTOMAC ST - OUTSIDE FIRE - E01,UT3 - ProQA Fire abort reason: DISCONNECTED CALL. Outside Fire. 1208845 11:22
Subject: WCo\n[!] 18 DOWNSVILLE RD - CHEST PAIN - R75,P751,R26,E05 - 81 year old, Male, Conscious, Breathing. - **ALS HOT*-Abnormal breathing 1208790 16:29
Subject: WCo\n[!] 601 DUAL HWY, SUPER SHOE STORE - Accident - Property Damage - 9A13 - Traffic / Transportation Accident (Crash). 16:41
Subject: WCo\n[!] 16533 TAMMANY LN - MEDICAL EMERGENCY - R26 - 83 year old, Female, Conscious, Breathing. - **BLS-ALPHA *** No priority symptoms (complaint conditions 2–11 not identified) 1208833 06:06
Subject: CAD\n[!] 895 W WASHINGTON ST, IFO - FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL - E04,UT3 - Fuel Spill. - UNKNOWN SITUATION (Investigation)-Outside 1208801 17:43
Subject: WCo\n[!] 16843 LONGFELLOW CT - FALLS,BACK INJURIES - R26 - 86 year old, Female, Conscious, Breathing. - **BLS HOT*** On ground or floor - Unknown status/Other codes not applicable 1208807 18:41
Subject: WCo\n[!] 151 N BURHANS BLVD, GOODWILL INDUSTRIES - Accident - Property Damage - 9A17 - Traffic / Transportation Accident (Crash). 18:59
Subject: WCo\n[!] 300 NORTHERN AVE, LONGMEADOW APTS. BLDG 3 APT A - UNSPECIFIED ALARM - E02,CO27,TRK1,UT3,BC1 - Alarms. - HIGH RISE-UNKNOWN 1208818 21:25
Subject: WCo\n[!] 10138 ST GEORGE CIR - CONVULSIONS,SEIZURE - R26,CO10 - 54 year old, Male, Unconscious, Breathing. - **ALS HOT*-CONTINUOUS or MULTIPLE seizure 1208819 21:38
Subject: CAD\n[!] 860 PINE ST - UNCONSCIOUSNESS,FAINTING - S754,E05,UT3 - 44 year old, Male, Unconscious, Breathing. - **ALS HOT*- Unconscious – AGONAL/INEFFECTIVE BREATHING 1208821 00:09
Subject: CAD\n[!] 12927 LITTLE ELLIOTT DR APT 9 - CARDIAC,RESPIRATORY ARREST - R75,E03,UT3 - 26 year old, Male, Unconscious, Not breathing. - **ALS HOT*-ECHO- Not breathing at all 1208824 00:45
Subject: WCo\n[!] SHARPSBURG PIKE - UNCONSCIOUSNESS,FAINTING - R26 - 1208825 01:39
Subject: WCo\n[!] 443 S BURHANS BLVD, HAGERSTOWN MOPED - Accident - Property Damage - 9C21 - 11:47
Subject: CAD\n[!] 243 SUMMIT AVE, - CHEST PAIN - R75,E02,UT3 - 42 year old, Female, Conscious, Breathing. - **ALS HOT*- Breathing normally =>35 1208849 11:54
Subject: WCo\n[!] 38 E NORTH AVE - Accident - Property Damage - 9C17 - 1. Traffic / Transportation Accident (Crash). 12:08
Subject: WCo\n[!] 148 SUNFLOWER DR - DIABETIC PROBLEMS - R26 - 83 year old, Female, Conscious, Breathing. - **BLS-ALPHA**- Alert and behaving normally 1208783 14:48
Subject: CAD\n[!] 11110 MEDICAL CAMPUS RD, ROBINWOOD URGENT CARE- STE.147(BLU) - STROKE - R75,P756,CO10,UT3 - 80 year old, Male, Conscious, Breathing. - *ALS HOT*- Sudden weakness or numbness (one side)- (No test evidence (Less than 3 hrs) 1208754 10:05
Subject: WCo\n[!] 234 JONATHAN ST, THREE MINUTE CAR WASH - Accident - Property Damage - 9C15 - 11:00
Subject: WCo\n[!] 517 CHURCH ST - Accident - Property Damage - 9C17 - Traffic / Transportation Accident (Crash). 08:52
Subject: WCo\n[!] 50 W WASHINGTON ST, UNIVERSITY OF MARYLAND-HAGERSTOWN - Accident - Property Damage - 9718 - 11:38
Subject: WCo\n[!] DUAL HWY, AMES SHOPPING CENTER - Accident - Property Damage - 9C17 - Traffic / Transportation Accident (Crash). 08:24
Subject: WCo\n[!] Recall Reason: ALERTED FAA3\n365 WOODPOINT AVE - PSYCHIATRIC,SUICIDE ATTEMPT - R26,E04 - Mental Disorder (Behavioral Problems). 1208777 13:32


Contact: Jon Snyder <jsnyder886@gmail.com>
Sender: rc.104@c-msg.net
[!] 17910 COLLEGE RD, WCARC GROUP HOME - [RR TRACKS - CARTER LN] - CONVULSIONS,SEIZURE - R26 - - **BLS-ALPHA **Epileptic or Previous history-Not seizing now & breathing regularly(verified 1221489 13:58 2nd ALERT!
[!] 16921 HALFWAY BLVD, MCDONALDS (PILOT) - [HOPEWELL RD - STOTLER RD] - CONVULSIONS,SEIZURE - R26 - - **ALS HOT* Epileptic or Previous history - CONTINUOUS or MULTIPLE seizures 1221478 09:58 
FRE CO, 4600 BLK MIDDLEPOINT RD - [ - ] - ASSAULT - R79 - 1221465 02:50
[!] Recall Reason: M754 RE\n7 E WASHINGTON ST, ALEXANDER HOUSE APT 502 - [ - ] - MEDICAL EMERGENCY - R26,E03,M754 - - **ALS HOT* - Not alert 1221459 22:19
[!] 7 E WASHINGTON ST, ALEXANDER HOUSE APT 502 - [ - ] - MEDICAL EMERGENCY - R26,E03 - - **ALS HOT* - Not alert 1221459 22:19
ROBINWOOD CT / ROBINWOOD DR - [ROBINWOOD CT APTS - ROBINWOOD CT APTS] - PIC, PERS INJURY COLLISION - E102,UT3,P756,R79 - 1221441 19:34 2nd ALERT!
[!] 11564 HOPEWELL RD, AC&T FUEL CENTER - [FROM STAPLES - HALFWAY BLVD] - NAT GAS LEAK - CO26 - - Outside commerical line or Outside tank => 5 gallons/23 liters 1221427 16:29
FRE CO, 14756 HERMAN HAUVER RD - [ - ] - BREATHING PROBLEMS - R79 - 1221412 11:28 2nd ALERT!
[!] 17026 VIRGINIA AVE, ACROSS FROM - [DONELSON DR - BOWER AVE] - SHED, SMALL OUT BUILDING FIRE - CO26,CO2,TWR26,E261,C26,CA26,ET2,TRK2,ET26 - - Small NON-DWELLING building/structure (shed detached garage) 1221403 05:16
FRA CO, 1503 E MAIN ST - [ - ] - COMMERCIAL - BUILDING FIRE - CO9 - 1221375 17:53
17912 BROADFORDING RD - [POINT SALEM RD - HOLLYHOCK LN] - MEDICAL EMERGENCY - S759,R26,CO13,P759 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1221336 03:11
[!] 11014 LAKEVIEW DR - [ - ] - MEDICAL EMERGENCY - R26 - - **BLS-ALPHA *** Dizziness/vertigo 1221332 00:01
REIDTOWN RD - [BYERS RD - PARADISE CHURCH RD] - BARN FIRE - CO27,CO13,CO9,T13,FAET3,T09,QNT27,FARS3,S759 - - Large NON-DWELLING building/structure (barn storage building) 1221326 21:50
[!] INTERSTATE 81, 8MM I81 NB - [ - ] - PIC, PERS INJURY COLLISION - CO13,CO26,RS13,R75,P753,P754,C13,8FP273,E264,E131,ET26 - - **BLS HOT* - Unknown status/Other codes not applicable- Unknown number of patients 1221314 19:14
Completed: Cancelled By Caller, Changed Mind\nFRA CO, 9931 BIRCHWOOD LN - [ - ] - DIABETIC PROBLEMS - R79,P7920 - 1221265 03:04
ROBINWOOD CT / ROBINWOOD DR - [ROBINWOOD CT APTS - ROBINWOOD CT APTS] - PIC, PERS INJURY COLLISION - E102,UT3,P756,R79 - 1221441 19:34 2nd ALERT!
[!] Recall Reason: CANCEL\n17912 BROADFORDING RD - [POINT SALEM RD - HOLLYHOCK LN] - MEDICAL EMERGENCY - S759,R26,CO13,P759 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1221336 03:11


Contact: Active911
Agency name: Hagerstown Police Auxiliary
Location: Hagerstown, MD, United States
Sender: perkycrash210@gmail.com

235 S LOCUST ST, REAR TOP FLOOR APT - [CRAMERS ALY - BESTER ST] - CITIZEN ASSIST - UT3,TRK1 - - OTHER ASSIST 1307466 19:55 
141 S MAIN ST, BURNSIDE HALL @ REEDERS MEMORIAL HM BOONSBORO - [ - ] - FALLS,BACK INJURIES - R19,P1820,CO6 - - **ALS HOT* - Not alert 1307465 19:39 -  
ELGIN BLVD / W WASHINGTON ST - [W WASHINGTON ST - COURT ALY] - PIC, PERS INJURY COLLISION - E04,S754,UT3 - - **BLS HOT* - Injuries 1307462 18:44 
219 N MULBERRY ST, APT 2R - [JEFFERSON ST - RANDOLPH AVE] - FIRE REPORTED OUT, INSIDE - E01,E03,TRK1$AA33,CA31,UT3 - - Residential (multiple) 1307459 17:54 
INTERSTATE 81, SB 2MM - [ - ] - PIC, PERS INJURY COLLISION - CO2,RSQE2,R2,C2,P29,ET2 - - **BLS HOT* - Injuries 1307457 17:42 
1500 PENNSYLVANIA AVE, TWO WEST OF WESTERN MD CENTER - [ - ] - UNCONSCIOUSNESS,FAINTING - R75,E02,UT3 - - **ALS HOT*- Unconscious ? AGONAL/INEFFECTIVE BREATHING 1307458 17:43 
INTERSTATE 81, SB 2MM - [ - ] - PIC, PERS INJURY COLLISION - CO2,RSQE2,R2 - - **BLS HOT* - Injuries 1307457 17:42 
7859 ABBOTT DR - [RD END - MCCLELLAN AVE] - MEDICAL EMERGENCY - R19,P1820,SUP14 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307451 14:50 -  
805 MARYLAND AVE - [W HOWARD ST - W FIRST ST] - GAS DETECTOR - E05,UT3 - - RESIDENTIAL, MULTIPLE-CO DETECTOR 1307448 13:37
940 BOWMAN AVE, HAGERSTOWN TRAINING ACADEMY - [WILLOW CIR - FREDERICK ST] - PUBLIC SERVICE - TRK2 - 1307447 12:30 -  
17723 BROADFORDING RD - [MCDADE RD - POINT SALEM RD] - BREATHING PROBLEMS - S759,P759,CO13 - - **ALS HOT*-Abnormal breathing 1307443 11:15 -  
FRE CO, 11600 HARP HILL RD - BLACOK AREA - [ - ] - GARAGE - BUILDING FIRE - CO7,ET7,TRK6 - 1307439 09:38 -  
249 S CONOCOCHEAGUE ST, WILLIAMSPORT LAUNDRY CENTER - [FREDERICK ST - SUNSET AVE] - MEDICAL EMERGENCY - R2 - - **BLS-ALPHA *** Unwell / ill 1307438 09:31 -  
Recall Reason: PER CO35\n18632 JARKEY DR, SIERRA NEVADA CORP (BLDG 67) - [TERMINAL DR - RD END] - BREATHING PROBLEMS - S759,CO35,CO13 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307428 06:03 -  
Recall Reason: E101 HANDLING\nINTERSTATE 70, EB 33 MM - [ - ] - TRAUMATIC INJURIES, SPECIFIC - R75,R79,CO10,P751,P793,CO16,E101 - 1307426 05:56 -  
17707 STONE VALLEY DR - [CLINTON AVE - STONE VALLEY CIR] - OVERDOSE,INGESTION,POISONING - R26,A268,R2 - - **ALS HOT* - Violent or Combative - Not alert 1307427 05:58 -  
INTERSTATE 70, EB 33 MM - [ - ] - TRAUMATIC INJURIES, SPECIFIC - R75,R79,CO10,P751,P793,CO16 - 1307426 05:56 -  
12525 GREENCASTLE PIKE - [NATIONAL PIKE - UPTO RESH RD] - NAT GAS LEAK - CO13,RS13 - - RESIDENTIAL (Single) 1307422 00:26 -  
16128 CLOVERTON LN - [APPLETREE LN - PEARTREE LN] - MEDICAL EMERGENCY - R2 - - **BLS-ALPHA *** No priority symptoms (complaint conditions 2?11 not identified) 1307417 23:04 -  
Recall Reason: CANCELLED PER FRANKLIN\nFRA CO, 200 S ANTRIM WAY ANTRIM WAY HONDA - [ - ] - VEHICLE, AUTO FIRE - QNT27,RS13 - 1307414 22:48 -  
FRA CO, 200 S ANTRIM WAY ANTRIM WAY HONDA - [ - ] - VEHICLE, AUTO FIRE - QNT27,RS13 - 1307414 22:48 -  
30 NOTTINGHAM RD, KINGDOM HALL OF JEHOVAHS WITNESSES - [W WASHINGTON ST - WASHINGTON AVE] - ELECTRICAL HAZARD - OUTSIDE INVESTIGATION - E04,UT3 - - ELECTRICAL ARCING 1307410 21:00
20351 LEITERSBURG PIKE - [JOHN WAYNE DR - MILLERS CHURCH RD] - GRASS, BRUSH, FIELD FIRE - CO9,BR9,T09 - - LARGE BRUSH/GRASS FIRE-UNKNOWN 1307408 20:18 -  
ROBINWOOD DR / MEDICAL CAMPUS RD - [MEDICAL CAMPUS RD - ROBINWOOD CT] - PIC, PERS INJURY COLLISION - CO10,RS10,R75 - 1307402 17:02 2nd ALERT! -  
LONGMEADOW RD / MARSH PIKE - [MARSH PIKE - PARAMOUNT TER] - FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL - CO27 - - CONTAINED SMALL SPILL <50 Gallons-Outside 1307399 16:20 -  
Recall Reason: CANCELLED\n42 WEST SIDE AVE, 1ST FLR - [DALE ST - W WASHINGTON AVE] - OBVIOUS CODE GRAY - S754,E04,UT3 - - *BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment 1307397 15:19
42 WEST SIDE AVE, 1ST FLR - [DALE ST - W WASHINGTON AVE] - OBVIOUS CODE GRAY - S754,E04,UT3 - - *BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment 1307397 15:19
28 W SALISBURY ST, WILLIAMSPORT POST OFFICE - [CONOCOCHEAGUE ST - VERMONT ST] - WIRES DOWN, MISC FIRE CALLS, ETC. - CO2,C2,TRK2 - - WIRES DOWN, NO SMOKE OR ARCING 1307396 15:06 -  
16538 NATIONAL PIKE - [GREENCASTLE PIKE - RYELAND LN] - MEDICAL EMERGENCY - R2,CO13 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1307395 14:36 -  
16921 HALFWAY BLVD, PILOT TRAVEL CENTER #179 - [HOPEWELL RD - STOTLER RD] - CHEST PAIN - R26,M268,E264 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307390 13:36 -  
17301 VALLEY MALL RD, J C PENNEY CO INC STE 400 - [ - ] - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO26,C26,E264 - - COMMERCIAL/INDUSTRIAL Building-WATERFLOW ALARM 1307385 13:14 -  
Recall Reason: FAILED\n7448 SHARPSBURG PIKE - [BAKERSVILLE RD - GRANT AVE] - CHIMNEY FIRE - - CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP,8FP022,8FP111 - 1307376 10:01 -  
7448 SHARPSBURG PIKE - [BAKERSVILLE RD - GRANT AVE] - CHIMNEY FIRE - - CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP - 1307376 10:09 -  
214.5 JONATHAN ST - [CHURCH ST - WILLIAMS AVE] - STANDBY FOR POLICE EMERGENCY - UT3,TRK1 - 1307373 09:09
14014 MARSH PIKE, NMS- FOUNTHEAD HL TO REAR - [ - ] - BREATHING PROBLEMS - S759,P759,CO27 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307371 08:55 -  
21 S MARTIN ST, APT.A - [CUMBERLAND ST - WEST ALY] - STROKE - R49,M491,CO4 - - **ALS HOT-Not Alert- < 3HRS SINCE SYMPTOMS STARTED 1307370 07:22 -  
SHARPSBURG PIKE / LESLIE DR - [LESLIE DR - KENT AVE] - PIC, PERS INJURY COLLISION - CO10,R26,SUP14,TRP3,P1820,M268,E101,E05,RS10 - - **ALS HOT* HIGH MECHANISM- Auto-bicycle/motorcycle 1307364 05:02 -  
6 OAKTREE LN, APT G - [MILESTONE GRDN APTS - ] - FALLS,BACK INJURIES - R2 - - **BLS HOT*** On ground or floor - POSSIBLY DANGEROUS body area 1307363 04:48 -  
11 W BALTIMORE ST, POTOMAC TOWERS - [ - ] - PSYCHIATRIC,SUICIDE ATTEMPT - R75,UT3 - 1307354 22:51
505 CHURCH ST APT 2B - [HIGH ST - JAMES ST] - OPEN BURNING -"OUT" of CONTROL - E04,UT3 - 1307352 22:19
14410 NATIONAL PIKE - [CLEAR BROOK LN - SPICKLER RD] - FALLS,BACK INJURIES - R49,P491,CO4 - - **BLS-ALPHA *** On ground or floor - NOT DANGEROUS body area 1307350 21:35 -  
VIRGINIA AVE / W WILSON BLVD - [W WILSON BLVD - SNYDER AVE] - PIC, PERS INJURY COLLISION - E05,R26,UT3 - - **BLS HOT* - Injuries 1307343 19:26
133 W BETHEL ST - [JONATHAN ST - N PROSPECT ST] - STAB,GUNSHOT - R75,P753,UT3 - 1307342 19:03
Recall Reason: CANCELLED\n322 S LOCUST ST - [LEE ST - ELM ST] - HOUSE FIRE - E01,E04,E05,TRK1,TWR26,UT3,CA32,BC2 - - Residential (single) - 1307334 17:16 -  
322 S LOCUST ST - [LEE ST - ELM ST] - HOUSE FIRE - E01,E04,E05,TRK1,TWR26,UT3,CA32 - - Residential (single) - 1307334 17:16
4296 CHESTNUT GROVE RD - [ELKRIDGE DR - MT BRIAR RD] - VEHICLE, AUTO FIRE - CO11 - - VEHICLE FIRE 1307332 16:58 -  
PEN MAR HIGH ROCK RD, HIGH ROCK - [TOP OF MOUNTIAN - PEN MAR RD] - FALLS,BACK INJURIES - FAA4,R79,CO9,TRP3,SO20,C79,A791,RS20,P7910,RSQE91,C9,FAA48,C20,SAF200,D20,TRP5,FA4,RSQE7 - - **ALS HOT* - EXTREME FALL (=> 30ft/10m) 1307328 16:23 -  
1108 POPE AVE - [THIRD ST - FOURTH ST] - INVESTIGATION, OUTSIDE - FM2 - 1307324 14:24 -  
1321 S POTOMAC ST, E RUSSELL HICKS MIDDLE SCHOOL ACROSS FROM - [ - ] - PIC, PERS INJURY COLLISION - E05,S754,UT3 - 1307323 14:08
11633 GREENCASTLE PIKE, PILOT TRAVEL CENTER #150 ACROSS THE STREET - [I70 OVERPASS - ABERDEEN DR] - VEHICLE, AUTO FIRE - CO2,P29,E24,ET2 - - VEHICLE FIRE 1307318 13:05 -  
334 E SUNSET AVE, SPRINGFIELD MIDDLE SCHOOL - [BRITNER AVE - CLIFTON DR] - CHEST PAIN - R2 - - **BLS-ALPHA**-Breathing normally <35 1307313 11:18 -  
221 W ANTIETAM ST - [MECHANIC ST - RD END] - CARDIAC,RESPIRATORY ARREST - R19,CO1,P1820,P192,CA1,E14 - - **ALS HOT*-ECHO- Not breathing at all 1307311 11:11 -  
209 S MONT VALLA AVE - [W WASHINGTON ST - MAIN AVE] - NAT GAS LEAK - E04,E05,E01,TRK4,QNT27,BC2,UT3 - 1307308 11:05
750 DUAL HWY, GOLDEN LIVING CENTER - [ - ] - CARDIAC,RESPIRATORY ARREST - R75,E03,UT3 - - **ALS HOT*-ECHO- Not breathing at all 1307306 10:48
41 BRYAN CIR, TRUTH CHRISTIAN ACADEMY - [AVALON AVE - WASHINGTON AVE] - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - E04,TRK4,UT3,BC2 - - COMMERCIAL/INDUSTRIAL Building -SMOKE DETECTOR 1307304 10:37
INTERSTATE 68, SIDELING HILL REST AREA E/B - [ - ] - VEHICLE, AUTO FIRE - CO5,AL43,R59,M593,ET5 - 1307303 10:26 -  
S PROSPECT ST / WASHINGTON ST - [W WASHINGTON ST - W ANTIETAM ST] - WIRES DOWN, MISC FIRE CALLS, ETC. - E04,UT3 - - WIRES DOWN, NO SMOKE OR ARCING 1307302 09:58
HAGERSTOWN - [ - ] - FUNERAL DETAIL - CO25,AU251,AU252,TWR26,U255 - 1307300 09:32 -  
11902 INDIAN LN - [ - ] - FALLS,BACK INJURIES - S759,P759,P751,CO27 - - *ALS HOT* - Fainting or near fainting => 50 1307301 09:05 -  
HAGERSTOWN - [ - ] - FUNERAL DETAIL - CO25,AU251,AU252,TWR26 - 1307300 08:41 -  
HAGERSTOWN - [ - ] - PUBLIC SERVICE - CO25 - 1307300 08:35

*/

public class MDWashingtonCountyParserTest extends BaseParserTest {
  
  public MDWashingtonCountyParserTest() {
    setParser(new MDWashingtonCountyParser(), "WASHINGTON COUNTY", "MD");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MAPLEVILLE RD / CHEWSVILLE RD - PIC, PERS INJURY COLLISION - CO16,RSQE7,R79,SO20 - 1106957 15:38",
        "ADDR:MAPLEVILLE RD & CHEWSVILLE RD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO16,RSQE7,R79,SO20",
        "ID:1106957",
        "TIME:15:38");

    doTest("T2",
        "73 S MAIN ST - FALLS,BACK INJURIES - R79 - 1106940 12:07 2nd ALERT!",
        "ADDR:73 S MAIN ST",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R79",
        "ID:1106940",
        "INFO:2nd ALERT!",
        "TIME:12:07");

    doTest("T3",
        "14518 MARYLAND AVE - STROKE - FAA4,R79,CO9 - 1106937 11:31",
        "ADDR:14518 MARYLAND AVE",
        "CALL:STROKE",
        "UNIT:FAA4,R79,CO9",
        "ID:1106937",
        "TIME:11:31");

    doTest("T4",
        "13730 MAUGANSVILLE RD, MAUGANSVILLE FIRE COMPANY - TRANSFER OF UNIT, - CO26,CO9 - 1106889 16:55",
        "ADDR:13730 MAUGANSVILLE RD",
        "PLACE:MAUGANSVILLE FIRE COMPANY",
        "CALL:TRANSFER OF UNIT,",
        "UNIT:CO26,CO9",
        "ID:1106889",
        "TIME:16:55");

    doTest("T5",
        "LEHMANS MILL RD - WATER RESCUE - - CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79 - 1106823 23:27 2nd ALERT!",
        "ADDR:LEHMANS MILL RD",
        "CALL:WATER RESCUE",
        "UNIT:CO9,RS13,R75,BT20,SO20,RS2001,D20,M753,RSQE91,DC9,R79",
        "ID:1106823",
        "INFO:2nd ALERT!",
        "TIME:23:27");

    doTest("T6",
        "FRE CO, N FRANKLINVILLE RD/RT15 - THURMONT - WATER RESCUE - - RSQE7 - TAC 30 1106797 21:01",
        "ADDR:N FRANKLINVILLE RD & RT15",
        "MADDR:N FRANKLINVILLE RD & RT 15",
        "CITY:THURMONT",
        "CALL:WATER RESCUE",
        "UNIT:RSQE7",
        "ID:1106797",
        "INFO:TAC 30",
        "TIME:21:01");

    doTest("T7",
        "FRE CO, 15204 QUIRAUK SCHOOL RD - NAT GAS LEAK - CO7,R79,P791,RSQE7 - FIRE 60 1106779 19:49",
        "ADDR:15204 QUIRAUK SCHOOL RD",
        "CITY:FREDERICK COUNTY",
        "CALL:NAT GAS LEAK",
        "UNIT:CO7,R79,P791,RSQE7",
        "ID:1106779",
        "INFO:FIRE 60",
        "TIME:19:49");

    doTest("T8",
        "21348 OLD FORGE RD, ST PETERS BEARD LUTHERAN CHURCH - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO9 - 1106753 16:45",
        "ADDR:21348 OLD FORGE RD",
        "PLACE:ST PETERS BEARD LUTHERAN CHURCH",
        "CALL:AUTOMATIC FIRE ALARM - COMMERCIAL , IND",
        "UNIT:CO9",
        "ID:1106753",
        "TIME:16:45");

    doTest("T9",
        "INTERSTATE 70, EXIT35 I70 EB - PIC, PERS INJURY COLLISION - CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75 - 1106746 16:21",
        "ADDR:INTERSTATE 70",
        "PLACE:EXIT35 I70 EB",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO16,CO10,R75,R79,E101,P791,P751,SUP160,DC10,RS10,E161,CA75",
        "ID:1106746",
        "TIME:16:21");

    doTest("T10",
        "22507 JEFFERSON BLVD, AC&T SMITHSBURG - EYE PROBLEMS,INJURIES - R79 - 1106670 16:20",
        "ADDR:22507 JEFFERSON BLVD",
        "PLACE:AC&T SMITHSBURG",
        "CALL:EYE PROBLEMS,INJURIES",
        "UNIT:R79",
        "ID:1106670",
        "TIME:16:20");

    doTest("T11",
        "20354 LEITERSBURG PIKE, PEN MAR TRAILER SALES INC - NAT GAS ODOR - CO9 - 1106635 00:13",
        "ADDR:20354 LEITERSBURG PIKE",
        "PLACE:PEN MAR TRAILER SALES INC",
        "CALL:NAT GAS ODOR",
        "UNIT:CO9",
        "ID:1106635",
        "TIME:00:13");

    doTest("T12",
        "LEITERSBURG PIKE / MILLERS CHURCH RD - PIC, PERS INJURY COLLISION - CO9,R75,P753,R79 - 1106553 22:22",
        "ADDR:LEITERSBURG PIKE & MILLERS CHURCH RD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO9,R75,P753,R79",
        "ID:1106553",
        "TIME:22:22");

    doTest("T13",
        "MAPLEVILLE RD / JEFFERSON BLVD - PIC, PERS INJURY COLLISION - CO7,R79,M791,SUP70,P792,C79,RSQE7 - 1106339 12:40",
        "ADDR:MAPLEVILLE RD & JEFFERSON BLVD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO7,R79,M791,SUP70,P792,C79,RSQE7",
        "ID:1106339",
        "TIME:12:40");

    doTest("T14",
        "INTERSTATE 70, 32MM I70 AT REST AREA - ABDOMINAL PAIN - PROBLEMS - R75,R79,CO10 - 1106419 16:28\nDo Not REPLY to this email!!!",
        "ADDR:INTERSTATE 70",
        "PLACE:32MM I70 AT REST AREA",
        "CALL:ABDOMINAL PAIN - PROBLEMS",
        "UNIT:R75,R79,CO10",
        "ID:1106419",
        "TIME:16:28");

    doTest("T15",
        "CHEWSVILLE RD / WHITE HALL RD, AREA - SMOKE INVESTIGATION - CO16,SO20,CO7,RS20,E161,E74,ET7 - 1117561 07:46\nDo Not REPLY to this email!!!",
        "ADDR:CHEWSVILLE RD & WHITE HALL RD",
        "PLACE:AREA",
        "CALL:SMOKE INVESTIGATION",
        "UNIT:CO16,SO20,CO7,RS20,E161,E74,ET7",
        "ID:1117561",
        "TIME:07:46");
   
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "S:WCo M:[!] 136 WISHING STAR CT  ,STAB  ,GUNSHOT  ,R75  ,CO10  ,1120268 23:48\n\n\n",
        "SRC:WCo",
        "ADDR:136 WISHING STAR CT",
        "CALL:STAB - GUNSHOT",
        "UNIT:R75,CO10",
        "ID:1120268",
        "TIME:23:48");

    doTest("T2",
        "S:WCo M:[!] 11403 STONECROFT CT  , STONECROFT APARTMENTS BUILDING A APT 209  ,CHEST PAIN  ,R75  ,CO10  ,1120271 02:16",
        "SRC:WCo",
        "ADDR:11403 STONECROFT CT",
        "CALL:STONECROFT APARTMENTS BUILDING A APT 209 - CHEST PAIN",
        "UNIT:R75,CO10",
        "ID:1120271",
        "TIME:02:16");

    doTest("T3",
        "S:WCo M:[!] 1800 DUAL HWY  , SUSQUEHANNA BANK STE 100 REAR OF  ,SMOKE INVESTIGATION  ,E03  ,CO10  ,UT3  ,1120229 07:12",
        "SRC:WCo",
        "ADDR:1800 DUAL HWY",
        "CALL:SUSQUEHANNA BANK STE 100 REAR OF - SMOKE INVESTIGATION",
        "UNIT:E03,CO10,UT3",
        "ID:1120229",
        "TIME:07:12");

    doTest("T4",
        "S:WCo M:[!] 300 N COLONIAL DR  , APT E  ,HOUSE FIRE  ,CO10  ,E03  ,E01  ,TRK1  ,S75  ,R75  ,SO20  ,1120236 09:48",
        "SRC:WCo",
        "ADDR:300 N COLONIAL DR",
        "CALL:APT E - HOUSE FIRE",
        "UNIT:CO10,E03,E01,TRK1,S75,R75,SO20",
        "ID:1120236",
        "TIME:09:48");

    doTest("T5",
        "S:WCo M:[!] 136 WISHING STAR CT  ,STAB  ,GUNSHOT  ,R75  ,CO10  ,1120268 23:48",
        "SRC:WCo",
        "ADDR:136 WISHING STAR CT",
        "CALL:STAB - GUNSHOT",
        "UNIT:R75,CO10",
        "ID:1120268",
        "TIME:23:48");

    doTest("T6",
        "S:WCo M:[!] 17567 YORK RD  , WESTERN SIZZLIN STEAK HOUSE  ,ODOR OF SMOKE  ,CO26  ,CO10  ,CO2  ,TWR26  ,RS10  ,R26  ,1120262 22:1",
        "SRC:WCo",
        "ADDR:17567 YORK RD",
        "CALL:WESTERN SIZZLIN STEAK HOUSE - ODOR OF SMOKE",
        "UNIT:CO26,CO10,CO2,TWR26,RS10,R26",
        "ID:1120262");
    
  }
  
  @Test
  public void testparser3() {

    doTest("T1",
        
        "WCo / [!] 1396 S POTOMAC ST, SHEETZ - PIC, PERS INJURY COLLISION - E05,R75,UT3 - 1200168 10:39\n\n",
        "SRC:WCo",
        "ADDR:1396 S POTOMAC ST",
        "PLACE:SHEETZ",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E05,R75,UT3",
        "ID:1200168",
        "TIME:10:39");
  }
  
  @Test
  public void testRichardGilbert() {

    doTest("T1",
        "Subject:CAD\n" +
        "[!] W FRANKLIN ST / N BURHANS BLVD - PIC, PERS INJURY COLLISION - E04,S75,S754,UT3 - Traffic / Transportation Accident (Crash). 12\r",

        "ADDR:W FRANKLIN ST & N BURHANS BLVD",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E04,S75,S754,UT3",
        "INFO:Traffic / Transportation Accident (Crash).");

  }
  
  @Test
  public void testFranciscoMartinez() {
    

    doTest("T1",
        "485 ANTIETAM DR, AREA OF - [JEFFERSON BLVD - SECURITY RD @ RR TRACKS] - PIC, PERS INJURY COLLISION - CO27,E03,R75 - Age unknown, F",
        "ADDR:485 ANTIETAM DR",
        "PLACE:AREA OF",
        "X:JEFFERSON BLVD & SECURITY RD @ RR TRACKS",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO27,E03,R75",
        "INFO:Age unknown, F");
}
  
  @Test
  public void testActive911() {

    doTest("T1",
        "Subject: WCo\n" +
        "[!] 17850 GARLAND GROH BLVD, SUPER WALMART CENTER - Accident - Property Damage - 9C16 - Traffic / Transportation Accident (Crash). 11:57",

        "SRC:WCo",
        "ADDR:17850 GARLAND GROH BLVD",
        "PLACE:SUPER WALMART CENTER",
        "CALL:Accident - Property Damage",
        "UNIT:9C16",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:11:57");

    doTest("T2",
        "Subject: WCo\n[!] INTERSTATE 81 / I70 - PIC, PERS INJURY COLLISION - CO26,CO2,RSQE2,R26,R2 - 1208763 11:59",
        "SRC:WCo",
        "ADDR:INTERSTATE 81 & I70",
        "MADDR:INTERSTATE 81 & I 70",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO26,CO2,RSQE2,R26,R2",
        "ID:1208763",
        "TIME:11:59");

    doTest("T3",
        "Subject: WCo\n" +
        "[!] VIRGINIA AVE / W WILSON BLVD - Accident - Property Damage - 9C21 - Traffic / Transportation Accident (Crash). 12:10",

        "SRC:WCo",
        "ADDR:VIRGINIA AVE & W WILSON BLVD",
        "CALL:Accident - Property Damage",
        "UNIT:9C21",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:12:10");

    doTest("T4",
        "Subject: WCo\n" +
        "[!] 222 OTHO HOLLAND DR - UNCONSCIOUSNESS,FAINTING - R26 - 87 year old, Female, Unconscious, Breathing. - **ALS HOT*- Unconscious – Effective breathing 1208767 12:41 2nd ALERT!",

        "SRC:WCo",
        "ADDR:222 OTHO HOLLAND DR",
        "CALL:UNCONSCIOUSNESS,FAINTING",
        "UNIT:R26",
        "INFO:87 year old, Female, Unconscious, Breathing. - **ALS HOT*- Unconscious – Effective breathing - 2nd ALERT!",
        "ID:1208767",
        "TIME:12:41");

    doTest("T5",
        "Subject: WCo\n[!] 365 WOODPOINT AVE - PSYCHIATRIC,SUICIDE ATTEMPT - R26,E04 - Mental Disorder (Behavioral Problems). 1208777 13:32",
        "SRC:WCo",
        "ADDR:365 WOODPOINT AVE",
        "CALL:PSYCHIATRIC,SUICIDE ATTEMPT",
        "UNIT:R26,E04",
        "INFO:Mental Disorder (Behavioral Problems).",
        "ID:1208777",
        "TIME:13:32");

    doTest("T6",
        "Subject: WCo\n" +
        "[!] 11346 LAKESIDE DR - FALLS,BACK INJURIES - R49,CO26 - 85 year old, Male, Conscious, Breathing. - **BLS-ALPHA *** On ground or floor - PUBLIC ASSIST (no injuries and no priority symptoms) 1208778 13:36",

        "SRC:WCo",
        "ADDR:11346 LAKESIDE DR",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R49,CO26",
        "INFO:85 year old, Male, Conscious, Breathing. - **BLS-ALPHA *** On ground or floor - PUBLIC ASSIST (no injuries and no priority symptoms)",
        "ID:1208778",
        "TIME:13:36");

    doTest("T7",
        "Subject: WCo\n" +
        "[!] 1321 S POTOMAC ST, E RUSSELL HICKS MIDDLE SCHOOL - Accident - Property Damage - 9C20 - Traffic / Transportation Accident (Crash). 16:01",

        "SRC:WCo",
        "ADDR:1321 S POTOMAC ST",
        "PLACE:E RUSSELL HICKS MIDDLE SCHOOL",
        "CALL:Accident - Property Damage",
        "UNIT:9C20",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:16:01");

    doTest("T8",
        "Subject: WCo\n[!] JONATHAN ST / CHURCH ST - Accident - Property Damage - 9E32 - 16:01",
        "SRC:WCo",
        "ADDR:JONATHAN ST & CHURCH ST",
        "CALL:Accident - Property Damage",
        "UNIT:9E32",
        "TIME:16:01");

    doTest("T9",
        "Subject: WCo\n" +
        "[!] 14 N POTOMAC ST - OUTSIDE FIRE - E01,UT3 - ProQA Fire abort reason: DISCONNECTED CALL. Outside Fire. 1208845 11:22",

        "SRC:WCo",
        "ADDR:14 N POTOMAC ST",
        "CALL:OUTSIDE FIRE",
        "UNIT:E01,UT3",
        "INFO:ProQA Fire abort reason: DISCONNECTED CALL. Outside Fire.",
        "ID:1208845",
        "TIME:11:22");

    doTest("T10",
        "Subject: WCo\n" +
        "[!] 18 DOWNSVILLE RD - CHEST PAIN - R75,P751,R26,E05 - 81 year old, Male, Conscious, Breathing. - **ALS HOT*-Abnormal breathing 1208790 16:29",

        "SRC:WCo",
        "ADDR:18 DOWNSVILLE RD",
        "CALL:CHEST PAIN",
        "UNIT:R75,P751,R26,E05",
        "INFO:81 year old, Male, Conscious, Breathing. - **ALS HOT*-Abnormal breathing",
        "ID:1208790",
        "TIME:16:29");

    doTest("T11",
        "Subject: WCo\n" +
        "[!] 601 DUAL HWY, SUPER SHOE STORE - Accident - Property Damage - 9A13 - Traffic / Transportation Accident (Crash). 16:41",

        "SRC:WCo",
        "ADDR:601 DUAL HWY",
        "PLACE:SUPER SHOE STORE",
        "CALL:Accident - Property Damage",
        "UNIT:9A13",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:16:41");

    doTest("T12",
        "Subject: WCo\n" +
        "[!] 16533 TAMMANY LN - MEDICAL EMERGENCY - R26 - 83 year old, Female, Conscious, Breathing. - **BLS-ALPHA *** No priority symptoms (complaint conditions 2–11 not identified) 1208833 06:06",

        "SRC:WCo",
        "ADDR:16533 TAMMANY LN",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R26",
        "INFO:83 year old, Female, Conscious, Breathing. - **BLS-ALPHA *** No priority symptoms (complaint conditions 2–11 not identified)",
        "ID:1208833",
        "TIME:06:06");

    doTest("T13",
        "Subject: CAD\n" +
        "[!] 895 W WASHINGTON ST, IFO - FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL - E04,UT3 - Fuel Spill. - UNKNOWN SITUATION (Investigation)-Outside 1208801 17:43",

        "ADDR:895 W WASHINGTON ST",
        "PLACE:IFO",
        "CALL:FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL",
        "UNIT:E04,UT3",
        "INFO:Fuel Spill. - UNKNOWN SITUATION (Investigation)-Outside",
        "ID:1208801",
        "TIME:17:43");

    doTest("T14",
        "Subject: WCo\n" +
        "[!] 16843 LONGFELLOW CT - FALLS,BACK INJURIES - R26 - 86 year old, Female, Conscious, Breathing. - **BLS HOT*** On ground or floor - Unknown status/Other codes not applicable 1208807 18:41",

        "SRC:WCo",
        "ADDR:16843 LONGFELLOW CT",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R26",
        "INFO:86 year old, Female, Conscious, Breathing. - **BLS HOT*** On ground or floor - Unknown status/Other codes not applicable",
        "ID:1208807",
        "TIME:18:41");

    doTest("T15",
        "Subject: WCo\n" +
        "[!] 151 N BURHANS BLVD, GOODWILL INDUSTRIES - Accident - Property Damage - 9A17 - Traffic / Transportation Accident (Crash). 18:59",

        "SRC:WCo",
        "ADDR:151 N BURHANS BLVD",
        "PLACE:GOODWILL INDUSTRIES",
        "CALL:Accident - Property Damage",
        "UNIT:9A17",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:18:59");

    doTest("T16",
        "Subject: WCo\n" +
        "[!] 300 NORTHERN AVE, LONGMEADOW APTS. BLDG 3 APT A - UNSPECIFIED ALARM - E02,CO27,TRK1,UT3,BC1 - Alarms. - HIGH RISE-UNKNOWN 1208818 21:25",

        "SRC:WCo",
        "ADDR:300 NORTHERN AVE",
        "PLACE:LONGMEADOW APTS. BLDG 3 APT A",
        "CALL:UNSPECIFIED ALARM",
        "UNIT:E02,CO27,TRK1,UT3,BC1",
        "INFO:Alarms. - HIGH RISE-UNKNOWN",
        "ID:1208818",
        "TIME:21:25");

    doTest("T17",
        "Subject: WCo\n" +
        "[!] 10138 ST GEORGE CIR - CONVULSIONS,SEIZURE - R26,CO10 - 54 year old, Male, Unconscious, Breathing. - **ALS HOT*-CONTINUOUS or MULTIPLE seizure 1208819 21:38",

        "SRC:WCo",
        "ADDR:10138 ST GEORGE CIR",
        "CALL:CONVULSIONS,SEIZURE",
        "UNIT:R26,CO10",
        "INFO:54 year old, Male, Unconscious, Breathing. - **ALS HOT*-CONTINUOUS or MULTIPLE seizure",
        "ID:1208819",
        "TIME:21:38");

    doTest("T18",
        "Subject: CAD\n" +
        "[!] 860 PINE ST - UNCONSCIOUSNESS,FAINTING - S754,E05,UT3 - 44 year old, Male, Unconscious, Breathing. - **ALS HOT*- Unconscious – AGONAL/INEFFECTIVE BREATHING 1208821 00:09",

        "ADDR:860 PINE ST",
        "CALL:UNCONSCIOUSNESS,FAINTING",
        "UNIT:S754,E05,UT3",
        "INFO:44 year old, Male, Unconscious, Breathing. - **ALS HOT*- Unconscious – AGONAL/INEFFECTIVE BREATHING",
        "ID:1208821",
        "TIME:00:09");

    doTest("T19",
        "Subject: CAD\n" +
        "[!] 12927 LITTLE ELLIOTT DR APT 9 - CARDIAC,RESPIRATORY ARREST - R75,E03,UT3 - 26 year old, Male, Unconscious, Not breathing. - **ALS HOT*-ECHO- Not breathing at all 1208824 00:45",

        "ADDR:12927 LITTLE ELLIOTT DR",
        "CALL:CARDIAC,RESPIRATORY ARREST",
        "UNIT:R75,E03,UT3",
        "INFO:26 year old, Male, Unconscious, Not breathing. - **ALS HOT*-ECHO- Not breathing at all",
        "APT:9",
        "ID:1208824",
        "TIME:00:45");

    doTest("T20",
        "Subject: WCo\n[!] SHARPSBURG PIKE - UNCONSCIOUSNESS,FAINTING - R26 - 1208825 01:39",
        "SRC:WCo",
        "ADDR:SHARPSBURG PIKE",
        "CALL:UNCONSCIOUSNESS,FAINTING",
        "UNIT:R26",
        "ID:1208825",
        "TIME:01:39");

    doTest("T21",
        "Subject: WCo\n[!] 443 S BURHANS BLVD, HAGERSTOWN MOPED - Accident - Property Damage - 9C21 - 11:47",
        "SRC:WCo",
        "ADDR:443 S BURHANS BLVD",
        "PLACE:HAGERSTOWN MOPED",
        "CALL:Accident - Property Damage",
        "UNIT:9C21",
        "TIME:11:47");

    doTest("T22",
        "Subject: CAD\n" +
        "[!] 243 SUMMIT AVE, - CHEST PAIN - R75,E02,UT3 - 42 year old, Female, Conscious, Breathing. - **ALS HOT*- Breathing normally =>35 1208849 11:54",

        "ADDR:243 SUMMIT AVE",
        "CALL:CHEST PAIN",
        "UNIT:R75,E02,UT3",
        "INFO:42 year old, Female, Conscious, Breathing. - **ALS HOT*- Breathing normally =>35",
        "ID:1208849",
        "TIME:11:54");

    doTest("T23",
        "Subject: WCo\n[!] 38 E NORTH AVE - Accident - Property Damage - 9C17 - 1. Traffic / Transportation Accident (Crash). 12:08",
        "SRC:WCo",
        "ADDR:38 E NORTH AVE",
        "CALL:Accident - Property Damage",
        "UNIT:9C17",
        "INFO:1. Traffic / Transportation Accident (Crash).",
        "TIME:12:08");

    doTest("T24",
        "Subject: WCo\n" +
        "[!] 148 SUNFLOWER DR - DIABETIC PROBLEMS - R26 - 83 year old, Female, Conscious, Breathing. - **BLS-ALPHA**- Alert and behaving normally 1208783 14:48",

        "SRC:WCo",
        "ADDR:148 SUNFLOWER DR",
        "CALL:DIABETIC PROBLEMS",
        "UNIT:R26",
        "INFO:83 year old, Female, Conscious, Breathing. - **BLS-ALPHA**- Alert and behaving normally",
        "ID:1208783",
        "TIME:14:48");

    doTest("T25",
        "Subject: CAD\n" +
        "[!] 11110 MEDICAL CAMPUS RD, ROBINWOOD URGENT CARE- STE.147(BLU) - STROKE - R75,P756,CO10,UT3 - 80 year old, Male, Conscious, Breathing. - *ALS HOT*- Sudden weakness or numbness (one side)- (No test evidence (Less than 3 hrs) 1208754 10:05",

        "ADDR:11110 MEDICAL CAMPUS RD",
        "PLACE:ROBINWOOD URGENT CARE- STE.147(BLU)",
        "CALL:STROKE",
        "UNIT:R75,P756,CO10,UT3",
        "INFO:80 year old, Male, Conscious, Breathing. - *ALS HOT*- Sudden weakness or numbness (one side)- (No test evidence (Less than 3 hrs)",
        "ID:1208754",
        "TIME:10:05");

    doTest("T26",
        "Subject: WCo\n[!] 234 JONATHAN ST, THREE MINUTE CAR WASH - Accident - Property Damage - 9C15 - 11:00",
        "SRC:WCo",
        "ADDR:234 JONATHAN ST",
        "PLACE:THREE MINUTE CAR WASH",
        "CALL:Accident - Property Damage",
        "UNIT:9C15",
        "TIME:11:00");

    doTest("T27",
        "Subject: WCo\n[!] 517 CHURCH ST - Accident - Property Damage - 9C17 - Traffic / Transportation Accident (Crash). 08:52",
        "SRC:WCo",
        "ADDR:517 CHURCH ST",
        "CALL:Accident - Property Damage",
        "UNIT:9C17",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:08:52");

    doTest("T28",
        "Subject: WCo\n[!] 50 W WASHINGTON ST, UNIVERSITY OF MARYLAND-HAGERSTOWN - Accident - Property Damage - 9718 - 11:38",
        "SRC:WCo",
        "ADDR:50 W WASHINGTON ST",
        "PLACE:UNIVERSITY OF MARYLAND-HAGERSTOWN",
        "CALL:Accident - Property Damage",
        "UNIT:9718",
        "TIME:11:38");

    doTest("T29",
        "Subject: WCo\n" +
        "[!] DUAL HWY, AMES SHOPPING CENTER - Accident - Property Damage - 9C17 - Traffic / Transportation Accident (Crash). 08:24",

        "SRC:WCo",
        "ADDR:DUAL HWY",
        "PLACE:AMES SHOPPING CENTER",
        "CALL:Accident - Property Damage",
        "UNIT:9C17",
        "INFO:Traffic / Transportation Accident (Crash).",
        "TIME:08:24");

    doTest("T30",
        "Subject: WCo\n" +
        "[!] Recall Reason: ALERTED FAA3\n" +
        "365 WOODPOINT AVE - PSYCHIATRIC,SUICIDE ATTEMPT - R26,E04 - Mental Disorder (Behavioral Problems). 1208777 13:32",

        "SRC:WCo",
        "ADDR:365 WOODPOINT AVE",
        "CALL:Recall Reason: ALERTED FAA3 - PSYCHIATRIC,SUICIDE ATTEMPT",
        "UNIT:R26,E04",
        "INFO:Mental Disorder (Behavioral Problems).",
        "ID:1208777",
        "TIME:13:32");
  
  }
  
  @Test
  public void testJonSnyder() {

    doTest("T1",
        "[!] 17910 COLLEGE RD, WCARC GROUP HOME - [RR TRACKS - CARTER LN] - CONVULSIONS,SEIZURE - R26 - - **BLS-ALPHA **Epileptic or Previous history-Not seizing now & breathing regularly(verified 1221489 13:58 2nd ALERT!",
        "ADDR:17910 COLLEGE RD",
        "PLACE:WCARC GROUP HOME",
        "X:RR TRACKS & CARTER LN",
        "CALL:CONVULSIONS,SEIZURE",
        "UNIT:R26",
        "INFO:**BLS-ALPHA **Epileptic or Previous history-Not seizing now & breathing regularly(verified - 2nd ALERT!",
        "ID:1221489",
        "TIME:13:58");

    doTest("T2",
        "[!] 16921 HALFWAY BLVD, MCDONALDS (PILOT) - [HOPEWELL RD - STOTLER RD] - CONVULSIONS,SEIZURE - R26 - - **ALS HOT* Epileptic or Previous history - CONTINUOUS or MULTIPLE seizures 1221478 09:58 ",
        "ADDR:16921 HALFWAY BLVD",
        "PLACE:MCDONALDS (PILOT)",
        "X:HOPEWELL RD & STOTLER RD",
        "CALL:CONVULSIONS,SEIZURE",
        "UNIT:R26",
        "INFO:**ALS HOT* Epileptic or Previous history - CONTINUOUS or MULTIPLE seizures",
        "ID:1221478",
        "TIME:09:58");

    doTest("T3",
        "FRE CO, 4600 BLK MIDDLEPOINT RD - [ - ] - ASSAULT - R79 - 1221465 02:50",
        "ADDR:4600 BLK MIDDLEPOINT RD",
        "MADDR:4600  MIDDLEPOINT RD",
        "CITY:FREDERICK COUNTY",
        "CALL:ASSAULT",
        "UNIT:R79",
        "ID:1221465",
        "TIME:02:50");

    doTest("T4",
        "[!] Recall Reason: M754 RE\n" +
        "7 E WASHINGTON ST, ALEXANDER HOUSE APT 502 - [ - ] - MEDICAL EMERGENCY - R26,E03,M754 - - **ALS HOT* - Not alert 1221459 22:19",

        "ADDR:7 E WASHINGTON ST",
        "PLACE:ALEXANDER HOUSE APT 502",
        "CALL:Recall Reason: M754 RE - MEDICAL EMERGENCY",
        "UNIT:R26,E03,M754",
        "INFO:**ALS HOT* - Not alert",
        "ID:1221459",
        "TIME:22:19");

    doTest("T5",
        "[!] 7 E WASHINGTON ST, ALEXANDER HOUSE APT 502 - [ - ] - MEDICAL EMERGENCY - R26,E03 - - **ALS HOT* - Not alert 1221459 22:19",
        "ADDR:7 E WASHINGTON ST",
        "PLACE:ALEXANDER HOUSE APT 502",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R26,E03",
        "INFO:**ALS HOT* - Not alert",
        "ID:1221459",
        "TIME:22:19");

    doTest("T6",
        "ROBINWOOD CT / ROBINWOOD DR - [ROBINWOOD CT APTS - ROBINWOOD CT APTS] - PIC, PERS INJURY COLLISION - E102,UT3,P756,R79 - 1221441 19:34 2nd ALERT!",
        "ADDR:ROBINWOOD CT & ROBINWOOD DR",
        "X:ROBINWOOD CT APTS & ROBINWOOD CT APTS",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E102,UT3,P756,R79",
        "INFO:2nd ALERT!",
        "ID:1221441",
        "TIME:19:34");

    doTest("T7",
        "[!] 11564 HOPEWELL RD, AC&T FUEL CENTER - [FROM STAPLES - HALFWAY BLVD] - NAT GAS LEAK - CO26 - - Outside commerical line or Outside tank => 5 gallons/23 liters 1221427 16:29",
        "ADDR:11564 HOPEWELL RD",
        "PLACE:AC&T FUEL CENTER",
        "X:FROM STAPLES & HALFWAY BLVD",
        "CALL:NAT GAS LEAK",
        "UNIT:CO26",
        "INFO:Outside commerical line or Outside tank => 5 gallons/23 liters",
        "ID:1221427",
        "TIME:16:29");

    doTest("T8",
        "FRE CO, 14756 HERMAN HAUVER RD - [ - ] - BREATHING PROBLEMS - R79 - 1221412 11:28 2nd ALERT!",
        "ADDR:14756 HERMAN HAUVER RD",
        "CITY:FREDERICK COUNTY",
        "CALL:BREATHING PROBLEMS",
        "UNIT:R79",
        "INFO:2nd ALERT!",
        "ID:1221412",
        "TIME:11:28");

    doTest("T9",
        "[!] 17026 VIRGINIA AVE, ACROSS FROM - [DONELSON DR - BOWER AVE] - SHED, SMALL OUT BUILDING FIRE - CO26,CO2,TWR26,E261,C26,CA26,ET2,TRK2,ET26 - - Small NON-DWELLING building/structure (shed detached garage) 1221403 05:16",
        "ADDR:17026 VIRGINIA AVE",
        "PLACE:ACROSS FROM",
        "X:DONELSON DR & BOWER AVE",
        "CALL:SHED, SMALL OUT BUILDING FIRE",
        "UNIT:CO26,CO2,TWR26,E261,C26,CA26,ET2,TRK2,ET26",
        "INFO:Small NON-DWELLING building/structure (shed detached garage)",
        "ID:1221403",
        "TIME:05:16");

    doTest("T10",
        "FRA CO, 1503 E MAIN ST - [ - ] - COMMERCIAL - BUILDING FIRE - CO9 - 1221375 17:53",
        "ADDR:1503 E MAIN ST",
        "CITY:FRANKLIN COUNTY",
        "ST:PA",
        "CALL:COMMERCIAL - BUILDING FIRE",
        "UNIT:CO9",
        "ID:1221375",
        "TIME:17:53");

    doTest("T11",
        "17912 BROADFORDING RD - [POINT SALEM RD - HOLLYHOCK LN] - MEDICAL EMERGENCY - S759,R26,CO13,P759 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1221336 03:11",
        "ADDR:17912 BROADFORDING RD",
        "X:POINT SALEM RD & HOLLYHOCK LN",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:S759,R26,CO13,P759",
        "INFO:**ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS",
        "ID:1221336",
        "TIME:03:11");

    doTest("T12",
        "[!] 11014 LAKEVIEW DR - [ - ] - MEDICAL EMERGENCY - R26 - - **BLS-ALPHA *** Dizziness/vertigo 1221332 00:01",
        "ADDR:11014 LAKEVIEW DR",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R26",
        "INFO:**BLS-ALPHA *** Dizziness/vertigo",
        "ID:1221332",
        "TIME:00:01");

    doTest("T13",
        "REIDTOWN RD - [BYERS RD - PARADISE CHURCH RD] - BARN FIRE - CO27,CO13,CO9,T13,FAET3,T09,QNT27,FARS3,S759 - - Large NON-DWELLING building/structure (barn storage building) 1221326 21:50",
        "ADDR:REIDTOWN RD",
        "MADDR:REIDTOWN RD & BYERS RD",
        "X:BYERS RD & PARADISE CHURCH RD",
        "CALL:BARN FIRE",
        "UNIT:CO27,CO13,CO9,T13,FAET3,T09,QNT27,FARS3,S759",
        "INFO:Large NON-DWELLING building/structure (barn storage building)",
        "ID:1221326",
        "TIME:21:50");

    doTest("T14",
        "[!] INTERSTATE 81, 8MM I81 NB - [ - ] - PIC, PERS INJURY COLLISION - CO13,CO26,RS13,R75,P753,P754,C13,8FP273,E264,E131,ET26 - - **BLS HOT* - Unknown status/Other codes not applicable- Unknown number of patients 1221314 19:14",
        "ADDR:INTERSTATE 81",
        "PLACE:8MM I81 NB",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO13,CO26,RS13,R75,P753,P754,C13,8FP273,E264,E131,ET26",
        "INFO:**BLS HOT* - Unknown status/Other codes not applicable- Unknown number of patients",
        "ID:1221314",
        "TIME:19:14");

    doTest("T15",
        "Completed: Cancelled By Caller, Changed Mind\nFRA CO, 9931 BIRCHWOOD LN - [ - ] - DIABETIC PROBLEMS - R79,P7920 - 1221265 03:04",
        "ADDR:9931 BIRCHWOOD LN",
        "CITY:FRANKLIN COUNTY",
        "ST:PA",
        "CALL:Completed: Cancelled By Caller, Changed Mind - DIABETIC PROBLEMS",
        "UNIT:R79,P7920",
        "ID:1221265",
        "TIME:03:04");

    doTest("T16",
        "ROBINWOOD CT / ROBINWOOD DR - [ROBINWOOD CT APTS - ROBINWOOD CT APTS] - PIC, PERS INJURY COLLISION - E102,UT3,P756,R79 - 1221441 19:34 2nd ALERT!",
        "ADDR:ROBINWOOD CT & ROBINWOOD DR",
        "X:ROBINWOOD CT APTS & ROBINWOOD CT APTS",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E102,UT3,P756,R79",
        "INFO:2nd ALERT!",
        "ID:1221441",
        "TIME:19:34");

    doTest("T17",
        "[!] Recall Reason: CANCEL\n" +
        "17912 BROADFORDING RD - [POINT SALEM RD - HOLLYHOCK LN] - MEDICAL EMERGENCY - S759,R26,CO13,P759 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1221336 03:11",

        "ADDR:17912 BROADFORDING RD",
        "X:POINT SALEM RD & HOLLYHOCK LN",
        "CALL:Recall Reason: CANCEL - MEDICAL EMERGENCY",
        "UNIT:S759,R26,CO13,P759",
        "INFO:**ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS",
        "ID:1221336",
        "TIME:03:11");

  }
  
  @Test
  public void testHagerstownPoliceAuxiliary() {

    doTest("T1",
        "235 S LOCUST ST, REAR TOP FLOOR APT - [CRAMERS ALY - BESTER ST] - CITIZEN ASSIST - UT3,TRK1 - - OTHER ASSIST 1307466 19:55 ",
        "ADDR:235 S LOCUST ST",
        "PLACE:REAR TOP FLOOR APT",
        "X:CRAMERS ALY & BESTER ST",
        "CALL:CITIZEN ASSIST",
        "UNIT:UT3,TRK1",
        "INFO:OTHER ASSIST",
        "ID:1307466",
        "TIME:19:55");

    doTest("T2",
        "141 S MAIN ST, BURNSIDE HALL @ REEDERS MEMORIAL HM BOONSBORO - [ - ] - FALLS,BACK INJURIES - R19,P1820,CO6 - - **ALS HOT* - Not alert 1307465 19:39 -  ",
        "ADDR:141 S MAIN ST",
        "PLACE:BURNSIDE HALL @ REEDERS MEMORIAL HM BOONSBORO",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R19,P1820,CO6",
        "INFO:**ALS HOT* - Not alert - -",
        "ID:1307465",
        "TIME:19:39");

    doTest("T3",
        "ELGIN BLVD / W WASHINGTON ST - [W WASHINGTON ST - COURT ALY] - PIC, PERS INJURY COLLISION - E04,S754,UT3 - - **BLS HOT* - Injuries 1307462 18:44 ",
        "ADDR:ELGIN BLVD & W WASHINGTON ST",
        "X:W WASHINGTON ST & COURT ALY",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E04,S754,UT3",
        "INFO:**BLS HOT* - Injuries",
        "ID:1307462",
        "TIME:18:44");

    doTest("T4",
        "219 N MULBERRY ST, APT 2R - [JEFFERSON ST - RANDOLPH AVE] - FIRE REPORTED OUT, INSIDE - E01,E03,TRK1$AA33,CA31,UT3 - - Residential (multiple) 1307459 17:54 ",
        "ADDR:219 N MULBERRY ST",
        "PLACE:APT 2R",
        "X:JEFFERSON ST & RANDOLPH AVE",
        "CALL:FIRE REPORTED OUT, INSIDE",
        "UNIT:E01,E03,TRK1$AA33,CA31,UT3",
        "INFO:Residential (multiple)",
        "ID:1307459",
        "TIME:17:54");

    doTest("T5",
        "INTERSTATE 81, SB 2MM - [ - ] - PIC, PERS INJURY COLLISION - CO2,RSQE2,R2,C2,P29,ET2 - - **BLS HOT* - Injuries 1307457 17:42 ",
        "ADDR:INTERSTATE 81",
        "PLACE:SB 2MM",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO2,RSQE2,R2,C2,P29,ET2",
        "INFO:**BLS HOT* - Injuries",
        "ID:1307457",
        "TIME:17:42");

    doTest("T6",
        "1500 PENNSYLVANIA AVE, TWO WEST OF WESTERN MD CENTER - [ - ] - UNCONSCIOUSNESS,FAINTING - R75,E02,UT3 - - **ALS HOT*- Unconscious ? AGONAL/INEFFECTIVE BREATHING 1307458 17:43 ",
        "ADDR:1500 PENNSYLVANIA AVE",
        "PLACE:TWO WEST OF WESTERN MD CENTER",
        "CALL:UNCONSCIOUSNESS,FAINTING",
        "UNIT:R75,E02,UT3",
        "INFO:**ALS HOT*- Unconscious ? AGONAL/INEFFECTIVE BREATHING",
        "ID:1307458",
        "TIME:17:43");

    doTest("T7",
        "INTERSTATE 81, SB 2MM - [ - ] - PIC, PERS INJURY COLLISION - CO2,RSQE2,R2 - - **BLS HOT* - Injuries 1307457 17:42 ",
        "ADDR:INTERSTATE 81",
        "PLACE:SB 2MM",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO2,RSQE2,R2",
        "INFO:**BLS HOT* - Injuries",
        "ID:1307457",
        "TIME:17:42");

    doTest("T8",
        "7859 ABBOTT DR - [RD END - MCCLELLAN AVE] - MEDICAL EMERGENCY - R19,P1820,SUP14 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307451 14:50 -  ",
        "ADDR:7859 ABBOTT DR",
        "X:RD END & MCCLELLAN AVE",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R19,P1820,SUP14",
        "INFO:**ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS - -",
        "ID:1307451",
        "TIME:14:50");

    doTest("T9",
        "805 MARYLAND AVE - [W HOWARD ST - W FIRST ST] - GAS DETECTOR - E05,UT3 - - RESIDENTIAL, MULTIPLE-CO DETECTOR 1307448 13:37",
        "ADDR:805 MARYLAND AVE",
        "X:W HOWARD ST & W FIRST ST",
        "CALL:GAS DETECTOR",
        "UNIT:E05,UT3",
        "INFO:RESIDENTIAL, MULTIPLE-CO DETECTOR",
        "ID:1307448",
        "TIME:13:37");

    doTest("T10",
        "940 BOWMAN AVE, HAGERSTOWN TRAINING ACADEMY - [WILLOW CIR - FREDERICK ST] - PUBLIC SERVICE - TRK2 - 1307447 12:30 -  ",
        "ADDR:940 BOWMAN AVE",
        "PLACE:HAGERSTOWN TRAINING ACADEMY",
        "X:WILLOW CIR & FREDERICK ST",
        "CALL:PUBLIC SERVICE",
        "UNIT:TRK2",
        "ID:1307447",
        "INFO:-",
        "TIME:12:30");

    doTest("T11",
        "17723 BROADFORDING RD - [MCDADE RD - POINT SALEM RD] - BREATHING PROBLEMS - S759,P759,CO13 - - **ALS HOT*-Abnormal breathing 1307443 11:15 -  ",
        "ADDR:17723 BROADFORDING RD",
        "X:MCDADE RD & POINT SALEM RD",
        "CALL:BREATHING PROBLEMS",
        "UNIT:S759,P759,CO13",
        "INFO:**ALS HOT*-Abnormal breathing - -",
        "ID:1307443",
        "TIME:11:15");

    doTest("T12",
        "FRE CO, 11600 HARP HILL RD - BLACOK AREA - [ - ] - GARAGE - BUILDING FIRE - CO7,ET7,TRK6 - 1307439 09:38 -  ",
        "ADDR:11600 HARP HILL RD",
        "CITY:FREDERICK COUNTY",
        "CALL:BLACOK AREA - [ & ] - GARAGE - BUILDING FIRE",
        "UNIT:CO7,ET7,TRK6",
        "ID:1307439",
        "INFO:-",
        "TIME:09:38");

    doTest("T13",
        "249 S CONOCOCHEAGUE ST, WILLIAMSPORT LAUNDRY CENTER - [FREDERICK ST - SUNSET AVE] - MEDICAL EMERGENCY - R2 - - **BLS-ALPHA *** Unwell / ill 1307438 09:31 -  ",
        "ADDR:249 S CONOCOCHEAGUE ST",
        "PLACE:WILLIAMSPORT LAUNDRY CENTER",
        "X:FREDERICK ST & SUNSET AVE",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R2",
        "INFO:**BLS-ALPHA *** Unwell / ill - -",
        "ID:1307438",
        "TIME:09:31");

    doTest("T14",
        "Recall Reason: PER CO35\n" +
        "18632 JARKEY DR, SIERRA NEVADA CORP (BLDG 67) - [TERMINAL DR - RD END] - BREATHING PROBLEMS - S759,CO35,CO13 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307428 06:03 -  ",

        "ADDR:18632 JARKEY DR",
        "PLACE:SIERRA NEVADA CORP (BLDG 67)",
        "X:TERMINAL DR & RD END",
        "CALL:Recall Reason: PER CO35 - BREATHING PROBLEMS",
        "UNIT:S759,CO35,CO13",
        "INFO:**ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS - -",
        "ID:1307428",
        "TIME:06:03");

    doTest("T15",
        "Recall Reason: E101 HANDLING\n" +
        "INTERSTATE 70, EB 33 MM - [ - ] - TRAUMATIC INJURIES, SPECIFIC - R75,R79,CO10,P751,P793,CO16,E101 - 1307426 05:56 -  ",

        "ADDR:INTERSTATE 70",
        "PLACE:EB 33 MM",
        "CALL:Recall Reason: E101 HANDLING - TRAUMATIC INJURIES, SPECIFIC",
        "UNIT:R75,R79,CO10,P751,P793,CO16,E101",
        "ID:1307426",
        "INFO:-",
        "TIME:05:56");

    doTest("T16",
        "17707 STONE VALLEY DR - [CLINTON AVE - STONE VALLEY CIR] - OVERDOSE,INGESTION,POISONING - R26,A268,R2 - - **ALS HOT* - Violent or Combative - Not alert 1307427 05:58 -  ",
        "ADDR:17707 STONE VALLEY DR",
        "X:CLINTON AVE & STONE VALLEY CIR",
        "CALL:OVERDOSE,INGESTION,POISONING",
        "UNIT:R26,A268,R2",
        "INFO:**ALS HOT* - Violent or Combative - Not alert - -",
        "ID:1307427",
        "TIME:05:58");

    doTest("T17",
        "INTERSTATE 70, EB 33 MM - [ - ] - TRAUMATIC INJURIES, SPECIFIC - R75,R79,CO10,P751,P793,CO16 - 1307426 05:56 -  ",
        "ADDR:INTERSTATE 70",
        "PLACE:EB 33 MM",
        "CALL:TRAUMATIC INJURIES, SPECIFIC",
        "UNIT:R75,R79,CO10,P751,P793,CO16",
        "ID:1307426",
        "INFO:-",
        "TIME:05:56");

    doTest("T18",
        "12525 GREENCASTLE PIKE - [NATIONAL PIKE - UPTO RESH RD] - NAT GAS LEAK - CO13,RS13 - - RESIDENTIAL (Single) 1307422 00:26 -  ",
        "ADDR:12525 GREENCASTLE PIKE",
        "X:NATIONAL PIKE & UPTO RESH RD",
        "CALL:NAT GAS LEAK",
        "UNIT:CO13,RS13",
        "INFO:RESIDENTIAL (Single) - -",
        "ID:1307422",
        "TIME:00:26");

    doTest("T19",
        "16128 CLOVERTON LN - [APPLETREE LN - PEARTREE LN] - MEDICAL EMERGENCY - R2 - - **BLS-ALPHA *** No priority symptoms (complaint conditions 2?11 not identified) 1307417 23:04 -  ",
        "ADDR:16128 CLOVERTON LN",
        "X:APPLETREE LN & PEARTREE LN",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R2",
        "INFO:**BLS-ALPHA *** No priority symptoms (complaint conditions 2?11 not identified) - -",
        "ID:1307417",
        "TIME:23:04");

    doTest("T20",
        "Recall Reason: CANCELLED PER FRANKLIN\n" +
        "FRA CO, 200 S ANTRIM WAY ANTRIM WAY HONDA - [ - ] - VEHICLE, AUTO FIRE - QNT27,RS13 - 1307414 22:48 -  ",

        "ADDR:200 S ANTRIM WAY ANTRIM WAY HONDA",
        "CITY:FRANKLIN COUNTY",
        "ST:PA",
        "CALL:Recall Reason: CANCELLED PER FRANKLIN - VEHICLE, AUTO FIRE",
        "UNIT:QNT27,RS13",
        "ID:1307414",
        "INFO:-",
        "TIME:22:48");

    doTest("T21",
        "FRA CO, 200 S ANTRIM WAY ANTRIM WAY HONDA - [ - ] - VEHICLE, AUTO FIRE - QNT27,RS13 - 1307414 22:48 -  ",
        "ADDR:200 S ANTRIM WAY ANTRIM WAY HONDA",
        "CITY:FRANKLIN COUNTY",
        "ST:PA",
        "CALL:VEHICLE, AUTO FIRE",
        "UNIT:QNT27,RS13",
        "ID:1307414",
        "INFO:-",
        "TIME:22:48");

    doTest("T22",
        "30 NOTTINGHAM RD, KINGDOM HALL OF JEHOVAHS WITNESSES - [W WASHINGTON ST - WASHINGTON AVE] - ELECTRICAL HAZARD - OUTSIDE INVESTIGATION - E04,UT3 - - ELECTRICAL ARCING 1307410 21:00",
        "ADDR:30 NOTTINGHAM RD",
        "PLACE:KINGDOM HALL OF JEHOVAHS WITNESSES",
        "X:W WASHINGTON ST & WASHINGTON AVE",
        "CALL:ELECTRICAL HAZARD - OUTSIDE INVESTIGATION",
        "UNIT:E04,UT3",
        "INFO:ELECTRICAL ARCING",
        "ID:1307410",
        "TIME:21:00");

    doTest("T23",
        "20351 LEITERSBURG PIKE - [JOHN WAYNE DR - MILLERS CHURCH RD] - GRASS, BRUSH, FIELD FIRE - CO9,BR9,T09 - - LARGE BRUSH/GRASS FIRE-UNKNOWN 1307408 20:18 -  ",
        "ADDR:20351 LEITERSBURG PIKE",
        "X:JOHN WAYNE DR & MILLERS CHURCH RD",
        "CALL:GRASS, BRUSH, FIELD FIRE",
        "UNIT:CO9,BR9,T09",
        "INFO:LARGE BRUSH/GRASS FIRE-UNKNOWN - -",
        "ID:1307408",
        "TIME:20:18");

    doTest("T24",
        "ROBINWOOD DR / MEDICAL CAMPUS RD - [MEDICAL CAMPUS RD - ROBINWOOD CT] - PIC, PERS INJURY COLLISION - CO10,RS10,R75 - 1307402 17:02 2nd ALERT! -  ",
        "ADDR:ROBINWOOD DR & MEDICAL CAMPUS RD",
        "X:MEDICAL CAMPUS RD & ROBINWOOD CT",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO10,RS10,R75",
        "ID:1307402",
        "INFO:2nd ALERT! -",
        "TIME:17:02");

    doTest("T25",
        "LONGMEADOW RD / MARSH PIKE - [MARSH PIKE - PARAMOUNT TER] - FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL - CO27 - - CONTAINED SMALL SPILL <50 Gallons-Outside 1307399 16:20 -  ",
        "ADDR:LONGMEADOW RD & MARSH PIKE",
        "X:MARSH PIKE & PARAMOUNT TER",
        "CALL:FUEL,GAS,OIL,ANTIFREEZE,DIESEL SPILL",
        "UNIT:CO27",
        "INFO:CONTAINED SMALL SPILL <50 Gallons-Outside - -",
        "ID:1307399",
        "TIME:16:20");

    doTest("T26",
        "Recall Reason: CANCELLED\n" +
        "42 WEST SIDE AVE, 1ST FLR - [DALE ST - W WASHINGTON AVE] - OBVIOUS CODE GRAY - S754,E04,UT3 - - *BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment 1307397 15:19",

        "ADDR:42 WEST SIDE AVE",
        "PLACE:1ST FLR",
        "X:DALE ST & W WASHINGTON AVE",
        "CALL:Recall Reason: CANCELLED - OBVIOUS CODE GRAY",
        "UNIT:S754,E04,UT3",
        "INFO:*BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment",
        "ID:1307397",
        "TIME:15:19");

    doTest("T27",
        "42 WEST SIDE AVE, 1ST FLR - [DALE ST - W WASHINGTON AVE] - OBVIOUS CODE GRAY - S754,E04,UT3 - - *BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment 1307397 15:19",
        "ADDR:42 WEST SIDE AVE",
        "PLACE:1ST FLR",
        "X:DALE ST & W WASHINGTON AVE",
        "CALL:OBVIOUS CODE GRAY",
        "UNIT:S754,E04,UT3",
        "INFO:*BLS HOT* OBVIOUS DEATH (Cold & Stiff in warm environment",
        "ID:1307397",
        "TIME:15:19");

    doTest("T28",
        "28 W SALISBURY ST, WILLIAMSPORT POST OFFICE - [CONOCOCHEAGUE ST - VERMONT ST] - WIRES DOWN, MISC FIRE CALLS, ETC. - CO2,C2,TRK2 - - WIRES DOWN, NO SMOKE OR ARCING 1307396 15:06 -  ",
        "ADDR:28 W SALISBURY ST",
        "PLACE:WILLIAMSPORT POST OFFICE",
        "X:CONOCOCHEAGUE ST & VERMONT ST",
        "CALL:WIRES DOWN, MISC FIRE CALLS, ETC.",
        "UNIT:CO2,C2,TRK2",
        "INFO:WIRES DOWN, NO SMOKE OR ARCING - -",
        "ID:1307396",
        "TIME:15:06");

    doTest("T29",
        "16538 NATIONAL PIKE - [GREENCASTLE PIKE - RYELAND LN] - MEDICAL EMERGENCY - R2,CO13 - - **ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS 1307395 14:36 -  ",
        "ADDR:16538 NATIONAL PIKE",
        "X:GREENCASTLE PIKE & RYELAND LN",
        "CALL:MEDICAL EMERGENCY",
        "UNIT:R2,CO13",
        "INFO:**ALS HOT* - ALTERED LEVEL OF CONSCIOUSNESS - -",
        "ID:1307395",
        "TIME:14:36");

    doTest("T30",
        "16921 HALFWAY BLVD, PILOT TRAVEL CENTER #179 - [HOPEWELL RD - STOTLER RD] - CHEST PAIN - R26,M268,E264 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307390 13:36 -  ",
        "ADDR:16921 HALFWAY BLVD",
        "PLACE:PILOT TRAVEL CENTER #179",
        "X:HOPEWELL RD & STOTLER RD",
        "CALL:CHEST PAIN",
        "UNIT:R26,M268,E264",
        "INFO:**ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS - -",
        "ID:1307390",
        "TIME:13:36");

    doTest("T31",
        "17301 VALLEY MALL RD, J C PENNEY CO INC STE 400 - [ - ] - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - CO26,C26,E264 - - COMMERCIAL/INDUSTRIAL Building-WATERFLOW ALARM 1307385 13:14 -  ",
        "ADDR:17301 VALLEY MALL RD",
        "PLACE:J C PENNEY CO INC STE 400",
        "CALL:AUTOMATIC FIRE ALARM - COMMERCIAL , IND",
        "UNIT:CO26,C26,E264",
        "INFO:COMMERCIAL/INDUSTRIAL Building-WATERFLOW ALARM - -",
        "ID:1307385",
        "TIME:13:14");

    doTest("T32",
        "Recall Reason: FAILED\n" +
        "7448 SHARPSBURG PIKE - [BAKERSVILLE RD - GRANT AVE] - CHIMNEY FIRE - - CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP,8FP022,8FP111 - 1307376 10:01 -  ",

        "ADDR:7448 SHARPSBURG PIKE",
        "X:BAKERSVILLE RD & GRANT AVE",
        "CALL:Recall Reason: FAILED - CHIMNEY FIRE",
        "UNIT:CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP,8FP022,8FP111",
        "ID:1307376",
        "INFO:-",
        "TIME:10:01");

    doTest("T33",
        "7448 SHARPSBURG PIKE - [BAKERSVILLE RD - GRANT AVE] - CHIMNEY FIRE - - CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP - 1307376 10:09 -  ",
        "ADDR:7448 SHARPSBURG PIKE",
        "X:BAKERSVILLE RD & GRANT AVE",
        "CALL:CHIMNEY FIRE",
        "UNIT:CO1,CO2,ET1,TRK2,R19,SUP14,P192,ET2,E11,ET26,FP",
        "ID:1307376",
        "INFO:-",
        "TIME:10:09");

    doTest("T34",
        "214.5 JONATHAN ST - [CHURCH ST - WILLIAMS AVE] - STANDBY FOR POLICE EMERGENCY - UT3,TRK1 - 1307373 09:09",
        "ADDR:214.5 JONATHAN ST",
        "MADDR:214.5 JONATHAN ST & CHURCH ST",
        "X:CHURCH ST & WILLIAMS AVE",
        "CALL:STANDBY FOR POLICE EMERGENCY",
        "UNIT:UT3,TRK1",
        "ID:1307373",
        "TIME:09:09");

    doTest("T35",
        "14014 MARSH PIKE, NMS- FOUNTHEAD HL TO REAR - [ - ] - BREATHING PROBLEMS - S759,P759,CO27 - - **ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS 1307371 08:55 -  ",
        "ADDR:14014 MARSH PIKE",
        "PLACE:NMS- FOUNTHEAD HL TO REAR",
        "CALL:BREATHING PROBLEMS",
        "UNIT:S759,P759,CO27",
        "INFO:**ALS HOT*- DIFFICULTY SPEAKING BETWEEN BREATHS - -",
        "ID:1307371",
        "TIME:08:55");

    doTest("T36",
        "21 S MARTIN ST, APT.A - [CUMBERLAND ST - WEST ALY] - STROKE - R49,M491,CO4 - - **ALS HOT-Not Alert- < 3HRS SINCE SYMPTOMS STARTED 1307370 07:22 -  ",
        "ADDR:21 S MARTIN ST",
        "PLACE:APT.A",
        "X:CUMBERLAND ST & WEST ALY",
        "CALL:STROKE",
        "UNIT:R49,M491,CO4",
        "INFO:**ALS HOT-Not Alert- < 3HRS SINCE SYMPTOMS STARTED - -",
        "ID:1307370",
        "TIME:07:22");

    doTest("T37",
        "SHARPSBURG PIKE / LESLIE DR - [LESLIE DR - KENT AVE] - PIC, PERS INJURY COLLISION - CO10,R26,SUP14,TRP3,P1820,M268,E101,E05,RS10 - - **ALS HOT* HIGH MECHANISM- Auto-bicycle/motorcycle 1307364 05:02 -  ",
        "ADDR:SHARPSBURG PIKE & LESLIE DR",
        "X:LESLIE DR & KENT AVE",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:CO10,R26,SUP14,TRP3,P1820,M268,E101,E05,RS10",
        "INFO:**ALS HOT* HIGH MECHANISM- Auto-bicycle/motorcycle - -",
        "ID:1307364",
        "TIME:05:02");

    doTest("T38",
        "6 OAKTREE LN, APT G - [MILESTONE GRDN APTS - ] - FALLS,BACK INJURIES - R2 - - **BLS HOT*** On ground or floor - POSSIBLY DANGEROUS body area 1307363 04:48 -  ",
        "ADDR:6 OAKTREE LN",
        "PLACE:APT G",
        "X:MILESTONE GRDN APTS",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R2",
        "INFO:**BLS HOT*** On ground or floor - POSSIBLY DANGEROUS body area - -",
        "ID:1307363",
        "TIME:04:48");

    doTest("T39",
        "11 W BALTIMORE ST, POTOMAC TOWERS - [ - ] - PSYCHIATRIC,SUICIDE ATTEMPT - R75,UT3 - 1307354 22:51",
        "ADDR:11 W BALTIMORE ST",
        "PLACE:POTOMAC TOWERS",
        "CALL:PSYCHIATRIC,SUICIDE ATTEMPT",
        "UNIT:R75,UT3",
        "ID:1307354",
        "TIME:22:51");

    doTest("T40",
        "505 CHURCH ST APT 2B - [HIGH ST - JAMES ST] - OPEN BURNING -\"OUT\" of CONTROL - E04,UT3 - 1307352 22:19",
        "ADDR:505 CHURCH ST",
        "APT:2B",
        "X:HIGH ST & JAMES ST",
        "CALL:OPEN BURNING -\"OUT\" of CONTROL",
        "UNIT:E04,UT3",
        "ID:1307352",
        "TIME:22:19");

    doTest("T41",
        "14410 NATIONAL PIKE - [CLEAR BROOK LN - SPICKLER RD] - FALLS,BACK INJURIES - R49,P491,CO4 - - **BLS-ALPHA *** On ground or floor - NOT DANGEROUS body area 1307350 21:35 -  ",
        "ADDR:14410 NATIONAL PIKE",
        "X:CLEAR BROOK LN & SPICKLER RD",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:R49,P491,CO4",
        "INFO:**BLS-ALPHA *** On ground or floor - NOT DANGEROUS body area - -",
        "ID:1307350",
        "TIME:21:35");

    doTest("T42",
        "VIRGINIA AVE / W WILSON BLVD - [W WILSON BLVD - SNYDER AVE] - PIC, PERS INJURY COLLISION - E05,R26,UT3 - - **BLS HOT* - Injuries 1307343 19:26",
        "ADDR:VIRGINIA AVE & W WILSON BLVD",
        "X:W WILSON BLVD & SNYDER AVE",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E05,R26,UT3",
        "INFO:**BLS HOT* - Injuries",
        "ID:1307343",
        "TIME:19:26");

    doTest("T43",
        "133 W BETHEL ST - [JONATHAN ST - N PROSPECT ST] - STAB,GUNSHOT - R75,P753,UT3 - 1307342 19:03",
        "ADDR:133 W BETHEL ST",
        "X:JONATHAN ST & N PROSPECT ST",
        "CALL:STAB,GUNSHOT",
        "UNIT:R75,P753,UT3",
        "ID:1307342",
        "TIME:19:03");

    doTest("T44",
        "Recall Reason: CANCELLED\n" +
        "322 S LOCUST ST - [LEE ST - ELM ST] - HOUSE FIRE - E01,E04,E05,TRK1,TWR26,UT3,CA32,BC2 - - Residential (single) - 1307334 17:16 -  ",

        "ADDR:322 S LOCUST ST",
        "X:LEE ST & ELM ST",
        "CALL:Recall Reason: CANCELLED - HOUSE FIRE",
        "UNIT:E01,E04,E05,TRK1,TWR26,UT3,CA32,BC2",
        "INFO:Residential (single) - -",
        "ID:1307334",
        "TIME:17:16");

    doTest("T45",
        "322 S LOCUST ST - [LEE ST - ELM ST] - HOUSE FIRE - E01,E04,E05,TRK1,TWR26,UT3,CA32 - - Residential (single) - 1307334 17:16",
        "ADDR:322 S LOCUST ST",
        "X:LEE ST & ELM ST",
        "CALL:HOUSE FIRE",
        "UNIT:E01,E04,E05,TRK1,TWR26,UT3,CA32",
        "INFO:Residential (single)",
        "ID:1307334",
        "TIME:17:16");

    doTest("T46",
        "4296 CHESTNUT GROVE RD - [ELKRIDGE DR - MT BRIAR RD] - VEHICLE, AUTO FIRE - CO11 - - VEHICLE FIRE 1307332 16:58 -  ",
        "ADDR:4296 CHESTNUT GROVE RD",
        "X:ELKRIDGE DR & MT BRIAR RD",
        "CALL:VEHICLE, AUTO FIRE",
        "UNIT:CO11",
        "INFO:VEHICLE FIRE - -",
        "ID:1307332",
        "TIME:16:58");

    doTest("T47",
        "PEN MAR HIGH ROCK RD, HIGH ROCK - [TOP OF MOUNTIAN - PEN MAR RD] - FALLS,BACK INJURIES - FAA4,R79,CO9,TRP3,SO20,C79,A791,RS20,P7910,RSQE91,C9,FAA48,C20,SAF200,D20,TRP5,FA4,RSQE7 - - **ALS HOT* - EXTREME FALL (=> 30ft/10m) 1307328 16:23 -  ",
        "ADDR:PEN MAR HIGH ROCK RD",
        "MADDR:PEN MAR HIGH ROCK RD & TOP OF MOUNTIAN",
        "PLACE:HIGH ROCK",
        "X:TOP OF MOUNTIAN & PEN MAR RD",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:FAA4,R79,CO9,TRP3,SO20,C79,A791,RS20,P7910,RSQE91,C9,FAA48,C20,SAF200,D20,TRP5,FA4,RSQE7",
        "INFO:**ALS HOT* - EXTREME FALL (=> 30ft/10m) - -",
        "ID:1307328",
        "TIME:16:23");

    doTest("T48",
        "1108 POPE AVE - [THIRD ST - FOURTH ST] - INVESTIGATION, OUTSIDE - FM2 - 1307324 14:24 -  ",
        "ADDR:1108 POPE AVE",
        "X:THIRD ST & FOURTH ST",
        "CALL:INVESTIGATION, OUTSIDE",
        "UNIT:FM2",
        "ID:1307324",
        "INFO:-",
        "TIME:14:24");

    doTest("T49",
        "1321 S POTOMAC ST, E RUSSELL HICKS MIDDLE SCHOOL ACROSS FROM - [ - ] - PIC, PERS INJURY COLLISION - E05,S754,UT3 - 1307323 14:08",
        "ADDR:1321 S POTOMAC ST",
        "PLACE:E RUSSELL HICKS MIDDLE SCHOOL ACROSS FROM",
        "CALL:PIC, PERS INJURY COLLISION",
        "UNIT:E05,S754,UT3",
        "ID:1307323",
        "TIME:14:08");

    doTest("T50",
        "11633 GREENCASTLE PIKE, PILOT TRAVEL CENTER #150 ACROSS THE STREET - [I70 OVERPASS - ABERDEEN DR] - VEHICLE, AUTO FIRE - CO2,P29,E24,ET2 - - VEHICLE FIRE 1307318 13:05 -  ",
        "ADDR:11633 GREENCASTLE PIKE",
        "PLACE:PILOT TRAVEL CENTER #150 ACROSS THE STREET",
        "X:I70 OVERPASS & ABERDEEN DR",
        "CALL:VEHICLE, AUTO FIRE",
        "UNIT:CO2,P29,E24,ET2",
        "INFO:VEHICLE FIRE - -",
        "ID:1307318",
        "TIME:13:05");

    doTest("T51",
        "334 E SUNSET AVE, SPRINGFIELD MIDDLE SCHOOL - [BRITNER AVE - CLIFTON DR] - CHEST PAIN - R2 - - **BLS-ALPHA**-Breathing normally <35 1307313 11:18 -  ",
        "ADDR:334 E SUNSET AVE",
        "PLACE:SPRINGFIELD MIDDLE SCHOOL",
        "X:BRITNER AVE & CLIFTON DR",
        "CALL:CHEST PAIN",
        "UNIT:R2",
        "INFO:**BLS-ALPHA**-Breathing normally <35 - -",
        "ID:1307313",
        "TIME:11:18");

    doTest("T52",
        "221 W ANTIETAM ST - [MECHANIC ST - RD END] - CARDIAC,RESPIRATORY ARREST - R19,CO1,P1820,P192,CA1,E14 - - **ALS HOT*-ECHO- Not breathing at all 1307311 11:11 -  ",
        "ADDR:221 W ANTIETAM ST",
        "X:MECHANIC ST & RD END",
        "CALL:CARDIAC,RESPIRATORY ARREST",
        "UNIT:R19,CO1,P1820,P192,CA1,E14",
        "INFO:**ALS HOT*-ECHO- Not breathing at all - -",
        "ID:1307311",
        "TIME:11:11");

    doTest("T53",
        "209 S MONT VALLA AVE - [W WASHINGTON ST - MAIN AVE] - NAT GAS LEAK - E04,E05,E01,TRK4,QNT27,BC2,UT3 - 1307308 11:05",
        "ADDR:209 S MONT VALLA AVE",
        "X:W WASHINGTON ST & MAIN AVE",
        "CALL:NAT GAS LEAK",
        "UNIT:E04,E05,E01,TRK4,QNT27,BC2,UT3",
        "ID:1307308",
        "TIME:11:05");

    doTest("T54",
        "750 DUAL HWY, GOLDEN LIVING CENTER - [ - ] - CARDIAC,RESPIRATORY ARREST - R75,E03,UT3 - - **ALS HOT*-ECHO- Not breathing at all 1307306 10:48",
        "ADDR:750 DUAL HWY",
        "PLACE:GOLDEN LIVING CENTER",
        "CALL:CARDIAC,RESPIRATORY ARREST",
        "UNIT:R75,E03,UT3",
        "INFO:**ALS HOT*-ECHO- Not breathing at all",
        "ID:1307306",
        "TIME:10:48");

    doTest("T55",
        "41 BRYAN CIR, TRUTH CHRISTIAN ACADEMY - [AVALON AVE - WASHINGTON AVE] - AUTOMATIC FIRE ALARM - COMMERCIAL , IND - E04,TRK4,UT3,BC2 - - COMMERCIAL/INDUSTRIAL Building -SMOKE DETECTOR 1307304 10:37",
        "ADDR:41 BRYAN CIR",
        "PLACE:TRUTH CHRISTIAN ACADEMY",
        "X:AVALON AVE & WASHINGTON AVE",
        "CALL:AUTOMATIC FIRE ALARM - COMMERCIAL , IND",
        "UNIT:E04,TRK4,UT3,BC2",
        "INFO:COMMERCIAL/INDUSTRIAL Building -SMOKE DETECTOR",
        "ID:1307304",
        "TIME:10:37");

    doTest("T56",
        "INTERSTATE 68, SIDELING HILL REST AREA E/B - [ - ] - VEHICLE, AUTO FIRE - CO5,AL43,R59,M593,ET5 - 1307303 10:26 -  ",
        "ADDR:INTERSTATE 68",
        "PLACE:SIDELING HILL REST AREA E/B",
        "CALL:VEHICLE, AUTO FIRE",
        "UNIT:CO5,AL43,R59,M593,ET5",
        "ID:1307303",
        "INFO:-",
        "TIME:10:26");

    doTest("T57",
        "S PROSPECT ST / WASHINGTON ST - [W WASHINGTON ST - W ANTIETAM ST] - WIRES DOWN, MISC FIRE CALLS, ETC. - E04,UT3 - - WIRES DOWN, NO SMOKE OR ARCING 1307302 09:58",
        "ADDR:S PROSPECT ST & WASHINGTON ST",
        "X:W WASHINGTON ST & W ANTIETAM ST",
        "CALL:WIRES DOWN, MISC FIRE CALLS, ETC.",
        "UNIT:E04,UT3",
        "INFO:WIRES DOWN, NO SMOKE OR ARCING",
        "ID:1307302",
        "TIME:09:58");

    doTest("T58",
        "HAGERSTOWN - [ - ] - FUNERAL DETAIL - CO25,AU251,AU252,TWR26,U255 - 1307300 09:32 -  ",
        "ADDR:HAGERSTOWN",
        "CALL:FUNERAL DETAIL",
        "UNIT:CO25,AU251,AU252,TWR26,U255",
        "ID:1307300",
        "INFO:-",
        "TIME:09:32");

    doTest("T59",
        "11902 INDIAN LN - [ - ] - FALLS,BACK INJURIES - S759,P759,P751,CO27 - - *ALS HOT* - Fainting or near fainting => 50 1307301 09:05 -  ",
        "ADDR:11902 INDIAN LN",
        "CALL:FALLS,BACK INJURIES",
        "UNIT:S759,P759,P751,CO27",
        "INFO:*ALS HOT* - Fainting or near fainting => 50 - -",
        "ID:1307301",
        "TIME:09:05");

    doTest("T60",
        "HAGERSTOWN - [ - ] - FUNERAL DETAIL - CO25,AU251,AU252,TWR26 - 1307300 08:41 -  ",
        "ADDR:HAGERSTOWN",
        "CALL:FUNERAL DETAIL",
        "UNIT:CO25,AU251,AU252,TWR26",
        "ID:1307300",
        "INFO:-",
        "TIME:08:41");

    doTest("T61",
        "HAGERSTOWN - [ - ] - PUBLIC SERVICE - CO25 - 1307300 08:35",
        "ADDR:HAGERSTOWN",
        "CALL:PUBLIC SERVICE",
        "UNIT:CO25",
        "ID:1307300",
        "TIME:08:35");

  }
  
  public static void main(String[] args) {
    new MDWashingtonCountyParserTest().generateTests("T1");
  }
}
