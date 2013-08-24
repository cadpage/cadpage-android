package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Lincoln County, NC
Contact: Jason Reed <jreed@denverfd.com>
Contact: Matt Bandieramonte <mbandieramonte@eastlincolnfd.org>
Contact: J Owens, Andromeda Pet Services <james@dogscantdrive.com>
Contact: Kevin Yount <unionfd622@yahoo.com>
Contact: Lisa Dellinger <lisadellinger2@gmail.com>
Contact: Michelle Paget <mpaget71@gmail.com>
Sender: cad@lincolnsheriff.org
Sender: 93001xxx
System: OSSI CAD
System: CAD@lincolne911.org

4567:CAD:KFD-26D01-26-D-1 SICK PERSON-9999 PALMETTO LN-PANORAMIC LN-TODD LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and
4568:CAD:KFD3-06D04-6-D-4 BREATHING PROBLEMS-8888 N NC 16 HWY-DELLING COMMUNICATIONS-CHARTER LN-HAGERS HOLLOW DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have
4569:CAD:KFD-06D02-6-D-2 BREATHING PROBLEMS-7777 DICK WILSON RD-CAMPGROUND RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND
4570:CAD:KLF-201101460-SMOKE INVESTIGATION-N LITTLE EGYPT RD/NC 73 HWY-near the ball field [03/22/11 10:13:09 DISPATCHER] blk smoke near track unkn source [03/22/11 10:12:22]
4571:CAD:KFD-201101410-67D02-OUTSIDE FIRE-1111 SAILVIEW DR-CREPE RIDGE DR-CHAPEL CREEK DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of
1221:CAD:DFD-201101274-ASSIST MOTORIST AGENCY OFFICER-5555 KING WILKINSON RD-CALVARY BAPTIST CHURCH-MOUNTAINBROOK LN-DELLING DOWNS DR-Event spawned from LOG CALL FOR RECORDS. [03/10/2011 20:03:33 SAM] TREE ACROSS THE ROAD [03/10/11 20:03:06 SAM]
1873:CAD:JLFD-201101315-52C03U-ALARMS FOR FIRE-888 OPTIMIST CLUB RD-WOODMONT CARE CENTER-FORNEY CREEK PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm
2647:CAD:AFD-201102514-69D09- OUTSIDE FIRE-1394 MICK LN-ORCHARD RD-[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRIPT: 6.A single-level structure is involved. 7.No one is reported to be injured. [05/03/11 20:54:48 SLINGERFELT] [Fire P
2646:CAD:ELF-31D03-31-D-3 UNCONSCIOUS/FAINTING-6471 NC 73 HWY-EAST LINCOLN HIGH SI-320-S INGLESIDE FARM RD-N LITTLE EGYPT RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 17-year-old female, who is conscious and breathing. No
2642:CAD:ELF-201102489-29B01-29-B-1 TRAFFIC ACCIDENT-N NC 16 HWY/NC 73 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. Caller Statement: 2 veh . 1.The incident involves m
2616:CAD:ELF-201102226-107B01-ASSIST MOTORIST AGENCY OFFICER-5514 NC 73 HWY-SCHRONCE RD-INVERLOCHY RD-JUST BEFORE EAST LINCOLN HIGH SCHOOL [04/19/11 05:22:28 CGRANTLAND] CALLER IS EXTREMELY UPSET [04/19/11 05:21:48 CGRANTLAND] RIGHT HAND SIDE OF RD COMING FROM LINCOLNTON [04/19/11 05:21:39 CGRANT
915:CAD:ADMN-201103837-29D02m-29-D-2 TRAFFIC ACCIDENT-3068 CAT SQUARE RD-HENRY RD-PALM TREE DR-669 IS OUT WITH MALE AND ROUTINE RESPONSE RAN OVER BY FARM EQU
455:CAD:UFD-1100005100-29B04-29-B-4 TRAFFIC ACCIDENT-1513 ALF HOOVER RD-REEPSVILLE BAPTIST CHURCH-J RHYNE REEP RD-REEPSVILLE RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod
1112:CAD:FYI: -EMSC-201201013-TRANSFER-433 MCALISTER RD-CMC LINCOLN (NEW)-BEECHNUT ST-MEDICAL CENTER DR-going to brian center/ no special :1of2\n\n\nDISCLAIMER: Pu
634:CAD:UFD-1200000194-SERVICE CALL OR CITIZEN ASSIST-2700 TRINITY CHURCH RD-TRINITY LUTHERAN CHURCH-REEPSVILLE RD-ZUR LEONARD RD-9am-10am [10/18/12 11:27:38 SPITTS] Aborted by Fire Priority with code: unk [10/18/12 11:27:26 SPITTS] standby for fire prevention community service presetation at the daycare [10/18/12 11:27:13
635:CAD:UFD-10D01-10-D-1 CHEST PAIN-1237 HOWARDS CREEK MILL RD-ABERNETHY FARM RD-REEPSVILLE RD-[EMS] BRICK HOUSE-BURGANDY MOUNTAINEER AND BLUE CAR AND GRY CAR IN DRIVE [10/19/12 10:46:07 MMCNEELY] [Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 74 year old, Female, Conscious, Br
636:CAD:UFD-1200000196-29B04-29-B-4 TRAFFIC ACCIDENT-REEPSVILLE RD/TRINITY CHURCH RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod
637:CAD:UFD-26C01-26-C-1 SICK PERSON-1237 HOWARDS CREEK MILL RD-ABERNETHY FARM RD-REEPSVILLE RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 73 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). ALTERED LEVEL OF CONSCIOUSNESS. Caller Statement: LETHAR
17827:CAD:Update: -EMSE-201211435-113D02-4-A-1 ASSAULT-7860 BLACKWOOD RD-BURBANK LN-CHEVAL LN-Event spawned from DISTURBANCE OF ANY TYPE. [
21644:CAD:FYI: -EMSC-201303340-26A01-26-A-1 SICK PERSON-1099 LITHIA LN-LITHIA INN RD-[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: 82 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). No priority symptoms (complaint conditions 2-11 not identified). Caller Statement: UTI. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain. 4. He is not bleeding (or vomiting blood).

Contact: support@active911.com
[] 1:CAD:HCF-VEHICLE ACC PD ONLY-7046787685-AT&T MOBILITY-SHOAL RD/LAMA LN-VEH IS PARTLY IN RDWY [05/25/12 20:19:16 CHARKEY]\n
[] 4:CAD:N3F-1200000772-OUTSIDE FIRE-BUFFALO SHOALS RD/BLAIR RD-Event spawned from LARCENY / THEFT. [05/27/2012 18:18:31 CLAFFERTY] {L182} x1 detained [05/27/12 18:09:22 SPITTS] gave to county [05/27/12 18:03:27 SPITTS] {CITY15} red chevy tk right on buffalo\n

Contact: active911.com
Agency name: Boger City Fire Department 
Location: Lincolnton, NC 
Sender: CAD@do-not-reply-lincolne911.org
CAD:BCF-ALLERGIES ALLERGIC REACTION-410 MCALISTER RD-POSSIBLE ALLERGIC REACTION TO BEE STING. TK40 ADV STANDBY ON EMS [07/02/2012 21:07:31 TRAPER] -BEECHNUT ST-MEDICAL CENTER DR
CAD:BCF-17D04-17-D-4 FALLS-441 BUFFALO SHOALS RD-HIGHLAND DR-INDIAN TR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 61 year old, Female, Conscious, Breathing. Falls. Chest or Neck injury (with difficulty breathing). 1.This happened now (less than 6hr
CAD:N3F-1200000490-52C03G-ALARMS FOR FIRE-621 LINCOLN COUNTY PARKWAY EXT-CRATE AND BARREL-FINGER MILL RD-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I

Contact: Active911
Agency name: East Lincoln Fire Department
Location: Stanley, NC, United States
Sender: CAD@lincolne911.org

504:CAD:ELF-02D02-2-D-2 ALLERGIES-501 N NC 16 HWY-THE DENTAL ZONE-N PILOT KNOB RD-TOWNSEND DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 60 year old, Male, Conscious, Breathing. Allergies (Reactions) / Envenomations (Stings, Bites). DIFFICULTY SPEAKING BETWEEN BREATHS. Caller St\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
503:CAD:ELF-1300000186-69C01-STRUCTURE FIRE-6676 OLD PLANK RD-HINES CIRCLE RD-MAGNET LN-{E30} STEAM COMING FROM HVAC NO FIRE [03/08/13 07:50:11 RROMBS] [FIRE] {LRF} LRF DISPATCHED [03/08/13 07:49:26 RROMBS] [Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Structure Fire.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
502:CAD:ELF2-VEHICLE ACC PD ONLY-7045779100-HELFORD,RHONDA-N NC 16 HWY/SMITH HARBOUR DR-SATURN/NISSAN [03/08/13 07:42:33 RROMBS] [Law Priority Info] RESPONSE: Omega RESPONDER SCRIPT: Traffic / Transportation Accident (Crash). Caller Statement: 1050PD. 1.The caller is on scene and i\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
501:CAD:ELF-1300000186-69C01-STRUCTURE FIRE-6676 OLD PLANK RD-HINES CIRCLE RD-MAGNET LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Structure Fire. Appliance (contained).Caller Statement: smoke coming from a/c unit. 1.The caller is on scene (1st party). 2.Smoke is vis\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
500:CAD:ELF2-19D02-19-D-2 HEART PROBLEMS-8233 CAMELIA LN-WILLOW COVE LN-WINTERBURY CT-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 43 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: POSS HEART A\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
499:CAD:ELF-1300000184-69D11-STRUCTURE FIRE-8086 OPTIMIST CLUB RD-EAST LINCOLN OPTIMIST CLUB-BROOK LN-PHEASANT LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Unknown situation (investigation).Caller Statement: SMOKE COMING FROM ELECTRICAL BOX. 1.The caller is on scene (1st party).\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
498:CAD:ELF-21B02-21-B-2 HEMORRHAGE-7259 NC 73 HWY-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 30 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. 1.The cause of the bleeding is traumatic. 2.T\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
497:CAD:ELF-02C02I-2-C-2 ALLERGIES-275-T N NC 16 HWY-LAKESHORE PEDIATRICS-NC 73 HWY-FOREST OAK DR-[EMS] CALLER VERY UPSET [03/07/13 07:54:49 HJENKINS] [EMS] PATIENT HAS BEEN VOMITTING AND THROAT IS DRY [03/07/13 07:54:44 HJENKINS] [EMS] SAID DOCTORS OFFICE OPENS AT 8AM [03/07/13 07:54:22 HJEN\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
496:CAD:DFD3-1300000181-69D06O-STRUCTURE FIRE-3873 BURTON LN-HOLLY CT-WESTCAPE DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single) (Odor of smoke).Caller Statement: SMELLS ELECTRICAL BURNING. 1.The caller is on scene (1st party). 2\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
495:CAD:ELF-1300000180-52C03G-ALARMS FOR FIRE-206 N LITTLE EGYPT RD-CATAWBA SPRINGS ELM SI-314-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE ALARM. 3.T\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
494:CAD:ELF-23C07I-23-C-7 OVERDOSE POISONING-6718 LOWESVILLE LN-RED BIRD LN-LARK LN-[LAW] CALL FROM FEMALE ADV MALE CALLER IS 1056 AND HAS DEPRESSION [03/03/13 22:43:48 TRAPER] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 53 year old, Female, Consciousness unknow\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
493:CAD:ELF-23D01I-23-D-1 OVERDOSE POISONING-1834 HINES CIRCLE RD-COUNTRY LN-LAMAR LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 19 year old, Female, Unconscious, Breathing. Overdose / Poisoning (Ingestion). Unconscious (Intentional Overdose). Caller Statement: o\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
492:CAD:ELF-1300000177-131B01B-29-A-1 TRAFFIC ACCIDENT-258 N NC 16 HWY-WENDYS DENVER-NC 73 HWY-FOREST OAK DR-Event spawned from VEHICLE ACC PD ONLY. [03/01/2013 13:21:47 TRAPER] [Law Priority Info] ***[Vehicle Info-- - VINDEX: 1 - TYPE: Suspect - COLOR: grn - MAKE: honda - BODY: civic ] ***[Vehi\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
491:CAD:ELF-1300000176-TRAFFIC TRANSPO ACCIDENT-S NC 16 HWY/BEN MCLAIN LN-Event spawned from VEHICLE ACC PD ONLY. [03/01/2013 10:15:28 HJENKINS] Aborted by Law Priority with code: unk [03/01/13 10:06:02 SPITTS] have the caller blocked in and she thinks the male is intox\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
490:CAD:ELF2-26C02-26-C-2 SICK PERSON-8285 STRIPER COVE LN-PRIMM RD-RANGER ISLAND RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 23 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
489:CAD:ELF2-13C03-13-C-3 DIABETIC PROBLEMS-8176 MARIONS CT-LEES WAY LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Diabetic Problems. Abnormal breathing. Caller Statement: DIABTIC PROBLEMS . 1.She is com\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
488:CAD:ELF2-25B06-25-B-6 SUICIDE-7674 PINK DOGWOOD TR-HICKORY CREEK DR-[EMS] CALLER ADV THAT SUBJ TOOK SOME TYPE OF PILLS UNK FURTHER [03/01/13 00:30:07 CGRANTLAND] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 50 year old, Male, Consciousness unknown,\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
487:CAD:ELF-1300000171-30A01-30-A-1 TRAUMATIC INJURIES-8218 BRIGHT WATER LN-HAGERS FERRY RD-BAYTREE LN-ADV PT HIT THE DOCK AND FELL IN THE WATER [02/28/13 15:50:26 ADEAN] ON THE SHORE LAYING IN THE EDGE OF THE WATER [02/28/13 15:49:24 ADEAN] CALLER ADV SUBJ FELL INTO WATER POSS BROKEN COLLAR BONE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
486:CAD:ELF-1300000170-129C03-SERVICE CALL OR CITIZEN ASSIST-6973 SIFFORD RD-BLUE BIRD LN-EXETER LN-Event spawned from SUSPICIOUS / WANTED. [02/28/2013 15:34:49 ADEAN] VEH IS RUNNING KEYS IN VEH [02/28/13 15:34:26 ADEAN] [Law Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Suspicious / Wanted\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
485:CAD:ELF2-25B03B-25-B-3 SUICIDE-7630-BLK HICKORY CREEK DR-PINK DOGWOOD TR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 21 year old, Gender unknown, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. THREATE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
484:CAD:ELF-1300000168-131B01B-29-B-2 TRAFFIC ACCIDENT-6592 NC 73 HWY-STATE EMPLOYEES CREDIT FI-307-N LITTLE EGYPT RD-CROSSCUT DR-Event spawned from VEHICLE ACC PD ONLY. [02/26/2013 19:59:03 SPITTS] {L180} ADV NEEDS 1 EMS UNIT REF HEAD INJURY NO BLEEDING [02/26/13 19:58:25 ABURNETTE] [Law Priority Info] ***[Vehicle Info--\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
483:CAD:DFD3-1300000166-STRUCTURE FIRE-7409 WEBBS RD-CVS-N NC 16 HWY-WATER HAVEN TR-ON OLD NC 16 HWY [02/26/13 15:02:21 DWALKER] USED CAR LOT ON HWY 16 CLOSE TO CVS ON WEBBS RD [02/26/13 15:02:08 DWALKER]\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
482:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-7274 NC 73 HWY-CHESTERBROOK ACADEMY-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Age unknown, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is compl\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
481:CAD:ELF-10C04-10-C-4 CHEST PAIN-7476-600 WATERSIDE LOOP RD-WATERSIDE CROSSING BLVD-WATERSIDE CROSSING BLVD-[EMS] GO TO SIDE DOOR [02/26/13 10:01:52 DWALKER] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 60 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing nor\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
480:CAD:ELF-1300000163-69D06-STRUCTURE FIRE-783 SLOAN ST-ALDWYCH LN-DRURY LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is visible. 3.The incident involves a single-family\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
479:CAD:ELF-1300000162-67B03U-OUTSIDE FIRE-6238-BLK MCINTOSH RD-STERLING CT-CALLER DID NOT WANT TO GIVE INFORMATION [02/24/13 18:05:57 ADEAN] CALLER ADV OUTSIDE FIRE, FIRE IS OUT AT THIS TIME [02/24/13 18:05:46 ADEAN] [Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT:\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
478:CAD:ELF-1300000161-52B01G-ALARMS FOR FIRE-8186 WATERFORD DR-STARBOARD LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
477:CAD:ELF-1300000161-52B01G-ALARMS FOR FIRE-8186 WATERFORD DR-STARBOARD LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
476:CAD:ELF-VEHICLE FRE-N NC 16 HWY/NC 73 HWY-VEHICLE ON FIRE [02/24/13 14:50:25 JHENDERSON]\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
475:CAD:DFD-1300000159-69D06-STRUCTURE FIRE-6498 AMEBA LN-DUSTY RIDGE CT-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1. The caller is on scene (1st party). 2. Both smoke and flames are visible. 3. The incident invo\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
474:CAD:ELF-1300000158-52C03G-ALARMS FOR FIRE-7733 OLD PLANK RD-JULIUS BLUM INC-MIKRON DR-S NC 16 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm monitoring company. 2.It is a general/fire alarm. 3.T\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
473:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-7850 LUCKY CREEK LN-MORRELL LN-MORRELL LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 52 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is not\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
472:CAD:ELF2-1300000156-67B03U-OUTSIDE FIRE-UNITY CHURCH RD/CHERRY LN-smells strong odor of a fire does not see [02/21/13 22:17:12 WRUSSELL] [Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. Unknown situation (investigation) (Unknown).Caller Sta\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
471:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-7773 CLOVER LN-BLACKWOOD RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 66 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.Sh\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
470:CAD:ELF-1300000153-53A01-SERVICE CALL OR CITIZEN ASSIST-7486 WATERSIDE LOOP RD-WATERSIDE CROSSING BLVD-WATERSIDE CROSSING BLVD-[Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Citizen Assist / Service Call. Locked in/out of building (non-medical assistance).Caller Statement: CHILD LOCKED IN CAR. 1.The caller is on\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
469:CAD:DFD-1300000152-69D06O-STRUCTURE FIRE-3844 BRYN MAR LN-N NC 16 HWY-[Fire Priority Update] Fire Priority reconfigured event from 69-D-06O to 69-D-06T. RESPONSE: Delta RESPONDER SCRIPT: Residential (single) (Trapped person(s)). 7.Someone is trapped inside th\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
468:CAD:ELF-1300000150-52C03G-ALARMS FOR FIRE-7981 OPTIMIST CLUB RD-LAKEWOOD CARE CENTER-AIRLIE PKWY-WOODS LN-SHOWING CENTER ACTIVATION [02/19/13 10:56:50 ADEAN] [Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm mon\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
467:CAD:ELF-VEHICLE ACC PD ONLY-7047283145-VERIZON WIRELESS-NC 73 HWY/N INGLESIDE FARM RD-[Law Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: TRAFFIC / TRANSPORTATION ACCIDENT (CRASH).TRAFFIC ACCIDENT (NO INJURY) (BLOCKING TRAFFIC). CALLER STATEMENT: 1050-PD. 1.THE CALLER IS NOT ON\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
466:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-404 S NC 16 HWY-S LITTLE EGYPT RD-S PILOT KNOB RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 56 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFF BREATHING. 1\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
465:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-1957 SENNEBOGEN TR-SENNEBOGEN CO-OLD PLANK RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Age unknown, Female, Unconscious, Breathing status unknown. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Caller State\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
464:CAD:ELF-1300000145-52C03G-ALARMS FOR FIRE-206 N LITTLE EGYPT RD-CATAWBA SPRINGS ELM SI-314-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
463:CAD:ELF-1300000144-52B01S-ALARMS FOR FIRE-310 N LITTLE EGYPT RD-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
462:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-2065 BASIN LN-BEDROCK LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 70 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING . 1.S\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
461:CAD:ELF-26C02-26-C-2 SICK PERSON-253 COWANS FORD RD-CHIPMUNK TR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 40 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
460:CAD:ELF-06C01-6-C-1 BREATHING PROBLEMS-1222 S NC 16 HWY-SIFFORD RD-BOB WHITE TR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 86 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing. Caller Statement: SHORTNESS OF BREATH. 1.She is\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
459:CAD:ELF2-19C02-19-C-2 HEART PROBLEMS-9124 UNITY CHURCH RD-BEATTYS FORD ACCESS-SHIPLEY LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 71 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Abnormal breathing. Caller Statement: heart racing/poss broken ar\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
458:CAD:DFD3-1300000139-52B01G-ALARMS FOR FIRE-7987 WESTBAY RD-BAY POINTE DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
457:CAD:ELF-1300000138-52B01C-52-B-1C CO ALARM-7418 GATE KEY CT-SEDGEBROOK DR WEST-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (CARBON MONOXIDE).CALLER STATEMENT: CARBON MIN GOING OFF. 1.THIS IS A PRIVATE CALLER. 2.THE CALLER IS ON SCE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
456:CAD:ELF2-17B03G-17-B-3 FALLS-2874 MORRIS LN-SHERRILL COVE WAY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 76 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: wi\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
455:CAD:ELF-1300000136-29B04-29-B-4 TRAFFIC ACCIDENT-134 N NC 16 HWY-BOJANGLES-NC 73 HWY-FOREST OAK DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
454:CAD:ELF-1300000135-52B01S-ALARMS FOR FIRE-8098 MALIBU POINTE LN-N NC 16 HWY-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: ALARMS. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETE\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
453:CAD:ELF-10C01-10-C-1 CHEST PAIN-2065 BASIN LN-BEDROCK LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 72 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. 1.He is completely alert (responding approp\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
452:CAD:ELF-10C04-10-C-4 CHEST PAIN-1723 NEWLAND RD-EAST BERKELEY RD-NATALIE COMMONS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 48 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. 1.She is completely alert (respond\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
451:CAD:ELF-17D03-17-D-3 FALLS-1604 S NC 16 HWY-KET TRANSPORTATION-MCINTOSH RD-OREGON TR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 54 year old, Female, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less than 6hrs ago). 2. It\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
450:CAD:ELF2-1300000131-69D06-STRUCTURE FIRE-2558 RANGER ISLAND RD-RANGER ISLAND MARINA RD-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single).Caller Statement: STRUCTURE FIRE. 1.The caller is not on scene. 2.Both smoke and flames are visible.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
449:CAD:ELF-10D04-10-D-4 CHEST PAIN-553 S INGLESIDE FARM RD-STABLEVIEW LN-TYCO MEADOWS LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 76 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. 1.She is completely alert (responding appropriately).\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
448:CAD:ELF2-21B02-21-B-2 HEMORRHAGE-7840 GALWAY LN-EAST LINCOLN CHARTER SCHOOL-N NC 16 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 35 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. Caller Statement: cut finger. 1.The cause of\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
447:CAD:ELF-28C10L-28-C-10 STROKE-7606 WEST BERKELEY RD-CALEY ST-NATALIE COMMONS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 89 year old, Male, Conscious, Breathing. Stroke (CVA). Breathing normally => 35 (Less than ___ hours since the symptoms started). Ca\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
446:CAD:ELF-1300000127-52B01S-ALARMS FOR FIRE-7977 HAGERS FERRY RD-DUCKWORTH LN-GRANT DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smok\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
445:CAD:ELF-19C04-19-C-4 HEART PROBLEMS-149 CROSS CENTER RD-HARRIS TEETER-NC 73 HWY-E CROSS DR-[EMS] WILL HAVE HIS FLASHERS ON [02/11/13 17:00:45 HJENKINS] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Car\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
444:CAD:ELF-19C04-19-C-4 HEART PROBLEMS-149 CROSS CENTER RD-HARRIS TEETER-NC 73 HWY-E CROSS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Cardiac history. Caller Statement: HEART PROBLEMS. 1.He is comp\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
443:CAD:ELF-1300000124-71D03-VEHICLE FRE-789 S INGLESIDE FARM RD-TYCO MEADOWS LN-TOPAZ LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Vehicle Fire. Vehicle fire with THREATENED building/structure.Caller Statement: veh on fire. 1.The caller is on scene (1st party). 2.No on\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
442:CAD:ELF-1300000123-29B04-29-B-4 TRAFFIC ACCIDENT-135 N NEW NC 16 HWY-OPTIMIST CLUB RD-NC 73 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
441:CAD:ELF-1300000122-55C01-ELECTRICAL HAZARD-1742 MAGNET LN-OLD PLANK RD-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Electrical Hazard. Electrical hazard with or near water. 1.The caller is on scene (1st party). 2.Electrical equipment is involved. 3.S\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
440:CAD:ELF-28C02L-28-C-2 STROKE-7736 TURNBERRY LN-BENT TREE DR-CLUB DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 62 year old, Male, Conscious, Breathing. Stroke (CVA). Abnormal breathing (Less than ___ hours since the symptoms started). Caller S\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
439:CAD:ELF-10C04-10-C-4 CHEST PAIN-7456 WATERLEAF CT-SEDGEBROOK DR WEST-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 62 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. Caller Statement: wife chest pains.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
438:CAD:ELF2-1300000119-52B01S-ALARMS FOR FIRE-2572 LAKE SHORE RD S-LAKEVIEW DR-LAKEVIEW DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETECTOR ALARM. 3.THE INCID\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
437:CAD:ELF-06C01A-6-C-1 BREATHING PROBLEMS-7804 CLOVER LN-BLACKWOOD RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFFICULTY BREATHING.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
436:CAD:ELF-17B03G-17-B-3 FALLS-231 N NC 16 HWY-RIVERWALK APARTMENTS BLDG 3-NC 73 HWY-FOREST OAK DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 88 year old, Female, Consciousness unknown, Breathing status unknown. Falls. Unknown status/Other codes not applicable (On the ground or fl\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
435:CAD:ELF-1300000116-69D11-STRUCTURE FIRE-7617 WEST BERKELEY RD-NATALIE COMMONS DR-WOODS LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Unknown situation (investigation).Caller Statement: HOUSE FIRE . 1.The caller is not on scene. 2.Both smoke and flames are\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
434:CAD:ELF-1300000115-29B04-29-B-4 TRAFFIC ACCIDENT-SIFFORD RD/S NC 16 HWY-[Medical Priority Update] Medical Priority reconfigured event from 13-1-B01 to 29-B-04. RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Transporta\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
433:CAD:ELF-1300000114-67B01B-OUTSIDE FIRE-8512-BLK NC 73 HWY-COWANS FORD OVERLOOK-CASWELL RD-EASTLAKE LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire (Buildings).Caller Statement: FIRE BY THE ROAD AND NEAR TREES. 1.The caller is not on scene. 2.This is a\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
432:CAD:DFD3-32B02-32-B-2 UNKNOWN PROBLEM-5096 WINDWARD POINT LN-MCCONNELL RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
431:CAD:DFD-1300000112-69D09-STRUCTURE FIRE-6400 WILDWOOD TR-PIEDMONT TR-HENDERSON ST-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Small NON-DWELLING building/structure (shed, detached garage).Caller Statement: OUTBUILDING ON FIRE. 1.The caller is on scen\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
430:CAD:ELF-1300000111-29B01-29-B-1 TRAFFIC ACCIDENT-7131 NC 73 HWY-WALMART DENVER-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Injuries. Caller Statem\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
429:CAD:ELF-06C01A-6-C-1 BREATHING PROBLEMS-6911 SIFFORD RD-BLUE BIRD LN-EXETER LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 69 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFF BREATHING. 1. She\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
428:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-2140 JUNE DELLINGER RD-OLD PLANK RD-HINES CIRCLE RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 95 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.He i\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
427:CAD:ELF-1300000108-52C03G-ALARMS FOR FIRE-7733 OLD PLANK RD-JULIUS BLUM INC-MIKRON DR-S NC 16 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire).Caller Statement: FIRE ALARM . 1.The caller is an alarm monitoring company. 2.It\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
426:CAD:ELF2-1300000107-52B01C-ALARMS FOR FIRE-7906 MARINERS POINTE CIR-SAIL POINTE LN-SAIL POINTE LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Carbon monoxide).Caller Statement: CARBON MONOXIDE ALARM GOING OFF. 1.The caller is an alarm monitoring compa\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
425:CAD:ELF-VEHICLE ACC PD ONLY-7048229999-HUGGINS,MELISSA-1182 S NC 16 HWY-Aborted by Medical Priority with code: UNK [02/06/13 11:23:55 SPITTS] ANTIFREEZE LEAKING FROM THE VEH [02/06/13 11:22:51 SPITTS] [Law Priority Info] ***[Vehicle Info-- - VINDEX: 1 - TYPE: Suspe-SIFFORD RD-BOB WHITE TR\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
424:CAD:ELF-1300000105-53O06-SERVICE CALL OR CITIZEN ASSIST-7981 OPTIMIST CLUB RD-LAKEWOOD CARE CENTER-AIRLIE PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Omega RESPONDER SCRIPT: Citizen Assist / Service Call. Other. 1.The caller is on scene (1st party). 2.Assistance is needed for another type of problem: RESET PULL\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
423:CAD:ELF-10C01-10-C-1 CHEST PAIN-7682 OTTS CIR-NC 73 HWY-AUSTIN LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 52 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Caller Statement: chest. 1.He is completel\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
422:CAD:ELF-17B03G-17-B-3 FALLS-823 KILLIAN FARM RD-SIFFORD RD-ROXBORO LN-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 73 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: FA\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
421:CAD:ELF-10D01-10-D-1 CHEST PAIN-8223 OPTIMIST CLUB RD-CRUSE LN-RUFUS RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 87 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Not alert. Caller Statement: MOTHER HAVING CHEST PAIN . 1. She is\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
420:CAD:ELF-32B02-32-B-2 UNKNOWN PROBLEM-896 DOVE CT-VIRGINIA CAROLINA REFRACTORY-TOWNSEND DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
419:CAD:ELF-1300000100-68A02-SMOKE INVESTIGATION-OPTIMIST CLUB RD/N NEW NC 16 HWY-AIRLIE BUSINESS PARK-[Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Smoke Investigation (Outside). Odor of smoke.Caller Statement: SMOKE NEAR THE RAILROAD TRACKS. 1.The caller is not on scene. 2.The caller\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
418:CAD:ELF-10D04-10-D-4 CHEST PAIN-7700 SEDGEBROOK DR EAST-GLENCREST DR-STONEMONT WAY-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. 1.He is completely alert (responding appropriately). 2.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
417:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-6911 SIFFORD RD-BLUE BIRD LN-EXETER LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 69 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: breathing prob. 1.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
416:CAD:ELF-1300000096-67D02U-OUTSIDE FIRE-6592 NC 73 HWY-STATE EMPLOYEES CREDIT FI-307-N LITTLE EGYPT RD-CROSSCUT DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. LARGE BRUSH/GRASS fire (Unknown).Caller Statement: outside fire. 1. The caller is not on scene. 2. This is a LARGE BRUSH/GR\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
415:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-7359 RED FOX LN-KILLIAN FARM RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 89 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOM HAVING A HARD\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
414:CAD:ELF-1300000094-59C04U-FUEL SPILL-TREETOPS DR/NC 73 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Fuel Spill. Unknown situation (investigation) (Unknown).Caller Statement: gas leak in roadway. 1.The caller is not on scene. 2.It is no\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
413:CAD:ELF-10C02-10-C-2 CHEST PAIN-8062 BLACKWOOD RD-CHEVAL LN-CHEVAL LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 50 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Heart attack or angina history. Caller Statement: tightness in\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
412:CAD:ELF2-25B06V-25-B-6 SUICIDE-8386 NORMANDY RD-HARMONY LN-VANDALAY DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 24 year old, Female, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. Unknown status/\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
411:CAD:ELF-1300000091-29B04-29-B-4 TRAFFIC ACCIDENT-7405 NC 73 HWY-KANGAROO-S NC 16 HWY-CROSS CENTER RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
410:CAD:DFD3-1300000090-WATERCRAFT IN DISTRESS-8094 BRADFORD LN-BURTON LN-Event spawned from ANY BOATING COMPLAINT. [01/31/13 15:55:20 RROMBS] MECK NOTIFIED [01/31/13 15:51:41 RROMBS] BETWEEN MARKERS 6 AND MARKERS 7 [01/31/13 15:46:46 RROMBS] ELONGATED FISHING BOAT -\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
409:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-5706 DAYBROOK CT-HINES CIRCLE RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 75 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOTHER CAN`T BREATH.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
408:CAD:ELF-1300000088-67B01U-ELECTRICAL HAZARD-7085 OLD PLANK RD-KILLIAN CREEK WATER TRTMT PLNT-SAUNDERS FAMILY LN-JUNE DELLINGER RD-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire (Unknown).Caller Statement: TREE IN POWERLINE ON FIRE . 1. The caller is not on scene. 2. Other electric\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
407:CAD:ELF-1300000087-29B04-29-B-4 TRAFFIC ACCIDENT-SIFFORD RD/S NC 16 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
406:CAD:ELF-32B03-32-B-3 UNKNOWN PROBLEM-7914 OPTIMIST CLUB RD-OPTIMIST CLUB RD CONVENIENCE-FORNEY CREEK PKWY-AIRLIE PKWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Unknown status/Other codes not applicable.\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.
405:CAD:ELF2-1300000085-67B03U-OUTSIDE FIRE-ALLISON CT/LAKE SHORE RD S-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. Unknown situation (investigation) (Unknown). 1.The caller is on scene (1st party). 2.This is a controlled burn. 3.The fir\n\n\nDISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \nPublic Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \nsent in response to it may be considered public record and as such subject to request and review by anyone at any time.

Contact: Active911
Agency name: Cornelius-Lemley Fire  Rescue
Location: Cornelius, NC, United States
Sender: CAD@lincolne911.org

895:CAD:DFD-1300000607-69D06-STRUCT FIRE -RESIDENTIAL SNGL-6505 PERSIMMON LN-AIRVIEW LN-DENVER SHORES LN-[PROQA] Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. [08/07/13 02:10:12 KWILLIS] [PROQA] RESPONSE: Hot Response Caller Statement: trailer on fire Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident invol\r\n
886:CAD:DFD3-1300000593-60B02O-GAS LEAK - OUTSIDE ODOR-2460 N NC 16 HWY-HAGERS HOLLOW DR-SARAH DR-[PROQA] RESPONSE: Hot Response Caller Statement: smell of natural gas at the lift station Chief Complaint: Gas Leak / Gas Odor (Natural and LP Gases) Suffix Info: Odor only Questions: It is not known where the leak is coming from, but there is an odor. The problem is reportedly outside. The gas can be smelled only. The caller is on scene (1st party). [08/02/13 12\r\n
882:CAD:ELF-1300000584-69D06-STRUCT FIRE -RESIDENTIAL SNGL-7629 BLUFF POINT LN-WATERSIDE CROSSING BLVD-[PROQA] Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. Floor: 1ST [07/30/13 10:01:31 HJENKINS] [PROQA] RESPONSE: Hot Response Caller Statement: STOVE ON FIRE Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident\r\n

*/

public class NCLincolnCountyParserTest extends BaseParserTest {
  
  public NCLincolnCountyParserTest() {
    setParser(new NCLincolnCountyParser(), "LINCOLN COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "4567:CAD:KFD-26D01-26-D-1 SICK PERSON-9999 PALMETTO LN-PANORAMIC LN-TODD LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and",
        "SRC:KFD",
        "ID:4567",
        "CODE:26D01",
        "CALL:SICK PERSON",
        "ADDR:9999 PALMETTO LN",
        "X:PANORAMIC LN & TODD LN",
        "INFO:You are responding to a patient who is sick (or has a current medical condition). The patient is a <REMOVED PT DATA>, who is conscious and");

    doTest("T2",
        "4568:CAD:KFD3-06D04-6-D-4 BREATHING PROBLEMS-8888 N NC 16 HWY-DELLING COMMUNICATIONS-CHARTER LN-HAGERS HOLLOW DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have",
        "SRC:KFD3",
        "ID:4568",
        "CODE:06D04",
        "CALL:BREATHING PROBLEMS",
        "ADDR:8888 N NC 16 HWY",
        "MADDR:8888 N STATE 16",
        "PLACE:DELLING COMMUNICATIONS",
        "X:CHARTER LN & HAGERS HOLLOW DR",
        "INFO:<REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. Clammy. 1.He is completely alert (responding appropriately). 2.He does not have");

    doTest("T3",
        "4569:CAD:KFD-06D02-6-D-2 BREATHING PROBLEMS-7777 DICK WILSON RD-CAMPGROUND RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: <REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND",
        "SRC:KFD",
        "ID:4569",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7777 DICK WILSON RD",
        "X:CAMPGROUND RD",
        "INFO:<REMOVED PT DATA>, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFFICULTY BREATHING AND");

    doTest("T4",
        "4570:CAD:KLF-201101460-SMOKE INVESTIGATION-N LITTLE EGYPT RD/NC 73 HWY-near the ball field [03/22/11 10:13:09 DISPATCHER] blk smoke near track unkn source [03/22/11 10:12:22]",
        "SRC:KLF",
        "ID:201101460",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:N LITTLE EGYPT RD & NC 73 HWY",
        "MADDR:N LITTLE EGYPT RD & STATE 73",
        "INFO:near the ball field / blk smoke near track unkn source",
        "DATE:03/22/11",
        "TIME:10:13:09");

    doTest("T5",
        "4571:CAD:KFD-201101410-67D02-OUTSIDE FIRE-1111 SAILVIEW DR-CREPE RIDGE DR-CHAPEL CREEK DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of",
        "SRC:KFD",
        "ID:201101410",
        "CODE:67D02",
        "CALL:OUTSIDE FIRE",
        "ADDR:1111 SAILVIEW DR",
        "X:CREPE RIDGE DR & CHAPEL CREEK DR",
        "INFO:Outside Fire. Brush/grass fire.Caller Statement: burning brush . 2.The caller is safe and out of danger. 3.Everyone else is safe and out of");

    doTest("T6",
        "1221:CAD:DFD-201101274-ASSIST MOTORIST AGENCY OFFICER-5555 KING WILKINSON RD-CALVARY BAPTIST CHURCH-MOUNTAINBROOK LN-DELLING DOWNS DR-Event spawned from LOG CALL FOR RECORDS. [03/10/2011 20:03:33 SAM] TREE ACROSS THE ROAD [03/10/11 20:03:06 SAM]",
        "SRC:DFD",
        "ID:201101274",
        "CALL:ASSIST MOTORIST AGENCY OFFICER",
        "ADDR:5555 KING WILKINSON RD",
        "PLACE:CALVARY BAPTIST CHURCH",
        "X:MOUNTAINBROOK LN & DELLING DOWNS DR",
        "INFO:Event spawned from LOG CALL FOR RECORDS. / TREE ACROSS THE ROAD",
        "DATE:03/10/2011",
        "TIME:20:03:33");

    doTest("T7",
        "1873:CAD:JLFD-201101315-52C03U-ALARMS FOR FIRE-888 OPTIMIST CLUB RD-WOODMONT CARE CENTER-FORNEY CREEK PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm",
        "SRC:JLFD",
        "ID:201101315",
        "CODE:52C03U",
        "CALL:ALARMS FOR FIRE",
        "ADDR:888 OPTIMIST CLUB RD",
        "PLACE:WOODMONT CARE CENTER",
        "X:FORNEY CREEK PKWY & WOODS LN",
        "INFO:Alarms. COMMERCIAL structure (Unknown).Caller Statement: FIRE ALARM . 1.The caller is an alarm");

    doTest("T8",
        "2647:CAD:AFD-201102514-69D09- OUTSIDE FIRE-1394 MICK LN-ORCHARD RD-[Fire Priority Info] Key Questions Complete RESPONSE: Delta RESPONDER SCRIPT: 6.A single-level structure is involved. 7.No one is reported to be injured. [05/03/11 20:54:48 SLINGERFELT] [Fire P",
        "SRC:AFD",
        "ID:201102514",
        "CODE:69D09",
        "CALL:OUTSIDE FIRE",
        "ADDR:1394 MICK LN",
        "X:ORCHARD RD",
        "INFO:6.A single / level structure is involved. 7.No one is reported to be injured.",
        "DATE:05/03/11",
        "TIME:20:54:48");

    doTest("T9",
        "2646:CAD:ELF-31D03-31-D-3 UNCONSCIOUS/FAINTING-6471 NC 73 HWY-EAST LINCOLN HIGH SI-320-S INGLESIDE FARM RD-N LITTLE EGYPT RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: You are responding to a patient who is unconscious (or has fainted). The patient is a 17-year-old female, who is conscious and breathing. No",
        "SRC:ELF",
        "ID:2646",
        "CODE:31D03",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:6471 NC 73 HWY",
        "MADDR:6471 STATE 73",
        "INFO:EAST LINCOLN HIGH SI / 320 / S INGLESIDE FARM RD / N LITTLE EGYPT RD / You are responding to a patient who is unconscious (or has fainted). The patient is a 17 / year / old female, who is conscious and breathing. No");

    doTest("T10",
        "2642:CAD:ELF-201102489-29B01-29-B-1 TRAFFIC ACCIDENT-N NC 16 HWY/NC 73 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. Caller Statement: 2 veh . 1.The incident involves m",
        "SRC:ELF",
        "ID:201102489",
        "CODE:29B01",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:N NC 16 HWY & NC 73 HWY",
        "MADDR:N STATE 16 & STATE 73",
        "INFO:Age unknown, Female, Conscious, Breathing. Traffic / Transportation Incidents. Injuries. Caller Statement: 2 veh . 1.The incident involves m");

    doTest("T11",
        "2616:CAD:ELF-201102226-107B01-ASSIST MOTORIST AGENCY OFFICER-5514 NC 73 HWY-SCHRONCE RD-INVERLOCHY RD-JUST BEFORE EAST LINCOLN HIGH SCHOOL [04/19/11 05:22:28 CGRANTLAND] CALLER IS EXTREMELY UPSET [04/19/11 05:21:48 CGRANTLAND] RIGHT HAND SIDE OF RD COMING FROM LINCOLNTON [04/19/11 05:21:39 CGRANT",
        "SRC:ELF",
        "ID:201102226",
        "CODE:107B01",
        "CALL:ASSIST MOTORIST AGENCY OFFICER",
        "ADDR:5514 NC 73 HWY",
        "MADDR:5514 STATE 73",
        "X:SCHRONCE RD & INVERLOCHY RD",
        "INFO:JUST BEFORE EAST LINCOLN HIGH SCHOOL / CALLER IS EXTREMELY UPSET / RIGHT HAND SIDE OF RD COMING FROM LINCOLNTON",
        "DATE:04/19/11",
        "TIME:05:22:28");

    doTest("T12",
        "915:CAD:ADMN-201103837-29D02m-29-D-2 TRAFFIC ACCIDENT-3068 CAT SQUARE RD-HENRY RD-PALM TREE DR-669 IS OUT WITH MALE AND ROUTINE RESPONSE RAN OVER BY FARM EQU",
        "SRC:ADMN",
        "ID:201103837",
        "CODE:29D02m",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:3068 CAT SQUARE RD",
        "X:HENRY RD & PALM TREE DR",
        "INFO:669 IS OUT WITH MALE AND ROUTINE RESPONSE RAN OVER BY FARM EQU");

    doTest("T13",
        "455:CAD:UFD-1100005100-29B04-29-B-4 TRAFFIC ACCIDENT-1513 ALF HOOVER RD-REEPSVILLE BAPTIST CHURCH-J RHYNE REEP RD-REEPSVILLE RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod",
        "SRC:UFD",
        "ID:1100005100",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:1513 ALF HOOVER RD",
        "PLACE:REEPSVILLE BAPTIST CHURCH",
        "X:J RHYNE REEP RD & REEPSVILLE RD",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T14",
        "1112:CAD:FYI: -EMSC-201201013-TRANSFER-433 MCALISTER RD-CMC LINCOLN (NEW)-BEECHNUT ST-MEDICAL CENTER DR-going to brian center/ no special :1of2\n\n\n" +
        "DISCLAIMER: Pu",

        "ID:201201013",
        "SRC:EMSC",
        "CALL:TRANSFER",
        "ADDR:433 MCALISTER RD",
        "PLACE:CMC LINCOLN (NEW)",
        "X:BEECHNUT ST & MEDICAL CENTER DR",
        "INFO:going to brian center/ no special");

    doTest("T15",
        "634:CAD:UFD-1200000194-SERVICE CALL OR CITIZEN ASSIST-2700 TRINITY CHURCH RD-TRINITY LUTHERAN CHURCH-REEPSVILLE RD-ZUR LEONARD RD-9am-10am [10/18/12 11:27:38 SPITTS] Aborted by Fire Priority with code: unk [10/18/12 11:27:26 SPITTS] standby for fire prevention community service presetation at the daycare [10/18/12 11:27:13",
        "ID:1200000194",
        "SRC:UFD",
        "CALL:SERVICE CALL OR CITIZEN ASSIST",
        "ADDR:2700 TRINITY CHURCH RD",
        "X:REEPSVILLE RD & ZUR LEONARD RD",
        "PLACE:TRINITY LUTHERAN CHURCH",
        "INFO:9am / 10am / Aborted by Fire Priority with code: unk / standby for fire prevention community service presetation at the daycare",
        "DATE:10/18/12",
        "TIME:11:27:38");

    doTest("T16",
        "635:CAD:UFD-10D01-10-D-1 CHEST PAIN-1237 HOWARDS CREEK MILL RD-ABERNETHY FARM RD-REEPSVILLE RD-[EMS] BRICK HOUSE-BURGANDY MOUNTAINEER AND BLUE CAR AND GRY CAR IN DRIVE [10/19/12 10:46:07 MMCNEELY] [Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 74 year old, Female, Conscious, Br",
        "ID:635",
        "SRC:UFD",
        "CODE:10D01",
        "CALL:CHEST PAIN",
        "ADDR:1237 HOWARDS CREEK MILL RD",
        "X:ABERNETHY FARM RD & REEPSVILLE RD",
        "INFO:BRICK HOUSE / BURGANDY MOUNTAINEER AND BLUE CAR AND GRY CAR IN DRIVE / 74 year old, Female, Conscious, Br",
        "DATE:10/19/12",
        "TIME:10:46:07");

    doTest("T17",
        "636:CAD:UFD-1200000196-29B04-29-B-4 TRAFFIC ACCIDENT-REEPSVILLE RD/TRINITY CHURCH RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod",
        "ID:1200000196",
        "SRC:UFD",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:REEPSVILLE RD & TRINITY CHURCH RD",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T18",
        "637:CAD:UFD-26C01-26-C-1 SICK PERSON-1237 HOWARDS CREEK MILL RD-ABERNETHY FARM RD-REEPSVILLE RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 73 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). ALTERED LEVEL OF CONSCIOUSNESS. Caller Statement: LETHAR",
        "ID:637",
        "SRC:UFD",
        "CODE:26C01",
        "CALL:SICK PERSON",
        "ADDR:1237 HOWARDS CREEK MILL RD",
        "X:ABERNETHY FARM RD & REEPSVILLE RD",
        "INFO:73 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). ALTERED LEVEL OF CONSCIOUSNESS. Caller Statement: LETHAR");

    doTest("T19",
        "17827:CAD:Update: -EMSE-201211435-113D02-4-A-1 ASSAULT-7860 BLACKWOOD RD-BURBANK LN-CHEVAL LN-Event spawned from DISTURBANCE OF ANY TYPE. [",
        "ID:201211435",
        "SRC:EMSE",
        "CODE:113D02",
        "CALL:ASSAULT",
        "ADDR:7860 BLACKWOOD RD",
        "X:BURBANK LN & CHEVAL LN",
        "INFO:Event spawned from DISTURBANCE OF ANY TYPE.");

    doTest("T20",
        "21644:CAD:FYI: -EMSC-201303340-26A01-26-A-1 SICK PERSON-1099 LITHIA LN-LITHIA INN RD-[Medical Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: 82 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). No priority symptoms (complaint conditions 2-11 not identified). Caller Statement: UTI. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain. 4. He is not bleeding (or vomiting blood).",
        "ID:201303340",
        "SRC:EMSC",
        "CODE:26A01",
        "CALL:SICK PERSON",
        "ADDR:1099 LITHIA LN",
        "X:LITHIA INN RD",
        "INFO:82 year old, Male, Conscious, Breathing. Sick Person (Specific Diagnosis). No priority symptoms (complaint conditions 2 / 11 not identified). Caller Statement: UTI. 1. He is completely alert (responding appropriately). 2. He is breathing normally. 3. He has other pain. 4. He is not bleeding (or vomiting blood).");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] 1:CAD:HCF-VEHICLE ACC PD ONLY-7046787685-AT&T MOBILITY-SHOAL RD/LAMA LN-VEH IS PARTLY IN RDWY [05/25/12 20:19:16 CHARKEY]\n",
        "ID:1",
        "SRC:HCF",
        "CALL:VEHICLE ACC PD ONLY",
        "PHONE:7046787685",
        "ADDR:SHOAL RD & LAMA LN",
        "INFO:VEH IS PARTLY IN RDWY",
        "DATE:05/25/12",
        "TIME:20:19:16");

    doTest("T2",
        "[] 4:CAD:N3F-1200000772-OUTSIDE FIRE-BUFFALO SHOALS RD/BLAIR RD-Event spawned from LARCENY / THEFT. [05/27/2012 18:18:31 CLAFFERTY] {L182} x1 detained [05/27/12 18:09:22 SPITTS] gave to county [05/27/12 18:03:27 SPITTS] {CITY15} red chevy tk right on buffalo\n",
        "ID:1200000772",
        "SRC:N3F",
        "CALL:OUTSIDE FIRE",
        "ADDR:BUFFALO SHOALS RD & BLAIR RD",
        "INFO:Event spawned from LARCENY / THEFT. / {L182} x1 detained / gave to county / {CITY15} red chevy tk right on buffalo",
        "DATE:05/27/2012",
        "TIME:18:18:31");
    
  }
  
  @Test
  public void testActive911B() {
   

    doTest("T1",
        "CAD:BCF-ALLERGIES ALLERGIC REACTION-410 MCALISTER RD-POSSIBLE ALLERGIC REACTION TO BEE STING. TK40 ADV STANDBY ON EMS [07/02/2012 21:07:31 TRAPER] -BEECHNUT ST-MEDICAL CENTER DR",
        "ID:0",
        "SRC:BCF",
        "CALL:ALLERGIES ALLERGIC REACTION",
        "ADDR:410 MCALISTER RD",
        "INFO:POSSIBLE ALLERGIC REACTION TO BEE STING. TK40 ADV STANDBY ON EMS",
        "X:BEECHNUT ST & MEDICAL CENTER DR",
        "DATE:07/02/2012",
        "TIME:21:07:31");

    doTest("T2",
        "CAD:BCF-17D04-17-D-4 FALLS-441 BUFFALO SHOALS RD-HIGHLAND DR-INDIAN TR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 61 year old, Female, Conscious, Breathing. Falls. Chest or Neck injury (with difficulty breathing). 1.This happened now (less than 6hr",
        "ID:0",
        "SRC:BCF",
        "CODE:17D04",
        "CALL:FALLS",
        "ADDR:441 BUFFALO SHOALS RD",
        "X:HIGHLAND DR & INDIAN TR",
        "INFO:61 year old, Female, Conscious, Breathing. Falls. Chest or Neck injury (with difficulty breathing). 1.This happened now (less than 6hr");

    doTest("T3",
        "CAD:N3F-1200000490-52C03G-ALARMS FOR FIRE-621 LINCOLN COUNTY PARKWAY EXT-CRATE AND BARREL-FINGER MILL RD-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I",
        "ID:1200000490",
        "SRC:N3F",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:621 LINCOLN COUNTY PARKWAY EXT",
        "MADDR:621 LINCOLN COUNTY PARKWAY",
        "X:FINGER MILL RD",
        "PLACE:CRATE AND BARREL",
        "INFO:ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I");
  }
  
  @Test
  public void testEastLincolnFire() {

    doTest("T1",
        "504:CAD:ELF-02D02-2-D-2 ALLERGIES-501 N NC 16 HWY-THE DENTAL ZONE-N PILOT KNOB RD-TOWNSEND DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 60 year old, Male, Conscious, Breathing. Allergies (Reactions) / Envenomations (Stings, Bites). DIFFICULTY SPEAKING BETWEEN BREATHS. Caller St\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:504",
        "SRC:ELF",
        "CODE:02D02",
        "CALL:ALLERGIES",
        "ADDR:501 N NC 16 HWY",
        "MADDR:501 N STATE 16",
        "PLACE:THE DENTAL ZONE",
        "X:N PILOT KNOB RD & TOWNSEND DR",
        "INFO:60 year old, Male, Conscious, Breathing. Allergies (Reactions) / Envenomations (Stings, Bites). DIFFICULTY SPEAKING BETWEEN BREATHS. Caller St");

    doTest("T2",
        "503:CAD:ELF-1300000186-69C01-STRUCTURE FIRE-6676 OLD PLANK RD-HINES CIRCLE RD-MAGNET LN-{E30} STEAM COMING FROM HVAC NO FIRE [03/08/13 07:50:11 RROMBS] [FIRE] {LRF} LRF DISPATCHED [03/08/13 07:49:26 RROMBS] [Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Structure Fire.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000186",
        "SRC:ELF",
        "CODE:69C01",
        "CALL:STRUCTURE FIRE",
        "ADDR:6676 OLD PLANK RD",
        "X:HINES CIRCLE RD & MAGNET LN",
        "INFO:{E30} STEAM COMING FROM HVAC NO FIRE / {LRF} LRF DISPATCHED / Structure Fire.",
        "DATE:03/08/13",
        "TIME:07:50:11");

    doTest("T3",
        "502:CAD:ELF2-VEHICLE ACC PD ONLY-7045779100-HELFORD,RHONDA-N NC 16 HWY/SMITH HARBOUR DR-SATURN/NISSAN [03/08/13 07:42:33 RROMBS] [Law Priority Info] RESPONSE: Omega RESPONDER SCRIPT: Traffic / Transportation Accident (Crash). Caller Statement: 1050PD. 1.The caller is on scene and i\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:502",
        "SRC:ELF2",
        "CALL:VEHICLE ACC PD ONLY",
        "PHONE:7045779100",
        "NAME:HELFORD,RHONDA",
        "ADDR:N NC 16 HWY & SMITH HARBOUR DR",
        "MADDR:N STATE 16 & SMITH HARBOUR DR",
        "INFO:SATURN/NISSAN / Traffic / Transportation Accident (Crash). Caller Statement: 1050PD. 1.The caller is on scene and i",
        "DATE:03/08/13",
        "TIME:07:42:33");

    doTest("T4",
        "501:CAD:ELF-1300000186-69C01-STRUCTURE FIRE-6676 OLD PLANK RD-HINES CIRCLE RD-MAGNET LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Structure Fire. Appliance (contained).Caller Statement: smoke coming from a/c unit. 1.The caller is on scene (1st party). 2.Smoke is vis\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000186",
        "SRC:ELF",
        "CODE:69C01",
        "CALL:STRUCTURE FIRE",
        "ADDR:6676 OLD PLANK RD",
        "X:HINES CIRCLE RD & MAGNET LN",
        "INFO:Structure Fire. Appliance (contained).Caller Statement: smoke coming from a/c unit. 1.The caller is on scene (1st party). 2.Smoke is vis");

    doTest("T5",
        "500:CAD:ELF2-19D02-19-D-2 HEART PROBLEMS-8233 CAMELIA LN-WILLOW COVE LN-WINTERBURY CT-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 43 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: POSS HEART A\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:500",
        "SRC:ELF2",
        "CODE:19D02",
        "CALL:HEART PROBLEMS",
        "ADDR:8233 CAMELIA LN",
        "X:WILLOW COVE LN & WINTERBURY CT",
        "INFO:43 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: POSS HEART A");

    doTest("T6",
        "499:CAD:ELF-1300000184-69D11-STRUCTURE FIRE-8086 OPTIMIST CLUB RD-EAST LINCOLN OPTIMIST CLUB-BROOK LN-PHEASANT LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Unknown situation (investigation).Caller Statement: SMOKE COMING FROM ELECTRICAL BOX. 1.The caller is on scene (1st party).\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000184",
        "SRC:ELF",
        "CODE:69D11",
        "CALL:STRUCTURE FIRE",
        "ADDR:8086 OPTIMIST CLUB RD",
        "PLACE:EAST LINCOLN OPTIMIST CLUB",
        "X:BROOK LN & PHEASANT LN",
        "INFO:Structure Fire. Unknown situation (investigation).Caller Statement: SMOKE COMING FROM ELECTRICAL BOX. 1.The caller is on scene (1st party).");

    doTest("T7",
        "498:CAD:ELF-21B02-21-B-2 HEMORRHAGE-7259 NC 73 HWY-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 30 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. 1.The cause of the bleeding is traumatic. 2.T\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:498",
        "SRC:ELF",
        "CODE:21B02",
        "CALL:HEMORRHAGE",
        "ADDR:7259 NC 73 HWY",
        "MADDR:7259 STATE 73",
        "X:S NEW NC 16 HWY & COTTONWOOD COMMONS DR",
        "INFO:30 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. 1.The cause of the bleeding is traumatic. 2.T");

    doTest("T8",
        "497:CAD:ELF-02C02I-2-C-2 ALLERGIES-275-T N NC 16 HWY-LAKESHORE PEDIATRICS-NC 73 HWY-FOREST OAK DR-[EMS] CALLER VERY UPSET [03/07/13 07:54:49 HJENKINS] [EMS] PATIENT HAS BEEN VOMITTING AND THROAT IS DRY [03/07/13 07:54:44 HJENKINS] [EMS] SAID DOCTORS OFFICE OPENS AT 8AM [03/07/13 07:54:22 HJEN\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:497",
        "SRC:ELF",
        "CODE:02C02I",
        "CALL:ALLERGIES",
        "ADDR:275-T N NC 16 HWY",
        "MADDR:275 N STATE 16",
        "PLACE:LAKESHORE PEDIATRICS",
        "X:NC 73 HWY & FOREST OAK DR",
        "INFO:CALLER VERY UPSET / PATIENT HAS BEEN VOMITTING AND THROAT IS DRY / SAID DOCTORS OFFICE OPENS AT 8AM",
        "DATE:03/07/13",
        "TIME:07:54:49");

    doTest("T9",
        "496:CAD:DFD3-1300000181-69D06O-STRUCTURE FIRE-3873 BURTON LN-HOLLY CT-WESTCAPE DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single) (Odor of smoke).Caller Statement: SMELLS ELECTRICAL BURNING. 1.The caller is on scene (1st party). 2\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000181",
        "SRC:DFD3",
        "CODE:69D06O",
        "CALL:STRUCTURE FIRE",
        "ADDR:3873 BURTON LN",
        "X:HOLLY CT & WESTCAPE DR",
        "INFO:Structure Fire. Residential (single) (Odor of smoke).Caller Statement: SMELLS ELECTRICAL BURNING. 1.The caller is on scene (1st party). 2");

    doTest("T10",
        "495:CAD:ELF-1300000180-52C03G-ALARMS FOR FIRE-206 N LITTLE EGYPT RD-CATAWBA SPRINGS ELM SI-314-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE ALARM. 3.T\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000180",
        "SRC:ELF",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:206 N LITTLE EGYPT RD",
        "INFO:CATAWBA SPRINGS ELM SI / 314 / CATAWBA SPRINGS RD / ALDWYCH LN / ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE ALARM. 3.T");

    doTest("T11",
        "494:CAD:ELF-23C07I-23-C-7 OVERDOSE POISONING-6718 LOWESVILLE LN-RED BIRD LN-LARK LN-[LAW] CALL FROM FEMALE ADV MALE CALLER IS 1056 AND HAS DEPRESSION [03/03/13 22:43:48 TRAPER] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 53 year old, Female, Consciousness unknow\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:494",
        "SRC:ELF",
        "CODE:23C07I",
        "CALL:OVERDOSE POISONING",
        "ADDR:6718 LOWESVILLE LN",
        "X:RED BIRD LN & LARK LN",
        "INFO:CALL FROM FEMALE ADV MALE CALLER IS 1056 AND HAS DEPRESSION / 53 year old, Female, Consciousness unknow",
        "DATE:03/03/13",
        "TIME:22:43:48");

    doTest("T12",
        "493:CAD:ELF-23D01I-23-D-1 OVERDOSE POISONING-1834 HINES CIRCLE RD-COUNTRY LN-LAMAR LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 19 year old, Female, Unconscious, Breathing. Overdose / Poisoning (Ingestion). Unconscious (Intentional Overdose). Caller Statement: o\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:493",
        "SRC:ELF",
        "CODE:23D01I",
        "CALL:OVERDOSE POISONING",
        "ADDR:1834 HINES CIRCLE RD",
        "X:COUNTRY LN & LAMAR LN",
        "INFO:19 year old, Female, Unconscious, Breathing. Overdose / Poisoning (Ingestion). Unconscious (Intentional Overdose). Caller Statement: o");

    doTest("T13",
        "492:CAD:ELF-1300000177-131B01B-29-A-1 TRAFFIC ACCIDENT-258 N NC 16 HWY-WENDYS DENVER-NC 73 HWY-FOREST OAK DR-Event spawned from VEHICLE ACC PD ONLY. [03/01/2013 13:21:47 TRAPER] [Law Priority Info] ***[Vehicle Info-- - VINDEX: 1 - TYPE: Suspect - COLOR: grn - MAKE: honda - BODY: civic ] ***[Vehi\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000177",
        "SRC:ELF",
        "CODE:131B01B",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:258 N NC 16 HWY",
        "MADDR:258 N STATE 16",
        "PLACE:WENDYS DENVER",
        "X:NC 73 HWY & FOREST OAK DR",
        "INFO:Event spawned from VEHICLE ACC PD ONLY. / ***",
        "DATE:03/01/2013",
        "TIME:13:21:47");

    doTest("T14",
        "491:CAD:ELF-1300000176-TRAFFIC TRANSPO ACCIDENT-S NC 16 HWY/BEN MCLAIN LN-Event spawned from VEHICLE ACC PD ONLY. [03/01/2013 10:15:28 HJENKINS] Aborted by Law Priority with code: unk [03/01/13 10:06:02 SPITTS] have the caller blocked in and she thinks the male is intox\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000176",
        "SRC:ELF",
        "CALL:TRAFFIC TRANSPO ACCIDENT",
        "ADDR:S NC 16 HWY & BEN MCLAIN LN",
        "MADDR:S STATE 16 & BEN MCLAIN LN",
        "INFO:Event spawned from VEHICLE ACC PD ONLY. / Aborted by Law Priority with code: unk / have the caller blocked in and she thinks the male is intox",
        "DATE:03/01/2013",
        "TIME:10:15:28");

    doTest("T15",
        "490:CAD:ELF2-26C02-26-C-2 SICK PERSON-8285 STRIPER COVE LN-PRIMM RD-RANGER ISLAND RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 23 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:490",
        "SRC:ELF2",
        "CODE:26C02",
        "CALL:SICK PERSON",
        "ADDR:8285 STRIPER COVE LN",
        "X:PRIMM RD & RANGER ISLAND RD",
        "INFO:23 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi");

    doTest("T16",
        "489:CAD:ELF2-13C03-13-C-3 DIABETIC PROBLEMS-8176 MARIONS CT-LEES WAY LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Diabetic Problems. Abnormal breathing. Caller Statement: DIABTIC PROBLEMS . 1.She is com\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:489",
        "SRC:ELF2",
        "CODE:13C03",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:8176 MARIONS CT",
        "INFO:LEES WAY LN / 72 year old, Female, Conscious, Breathing. Diabetic Problems. Abnormal breathing. Caller Statement: DIABTIC PROBLEMS . 1.She is com");

    doTest("T17",
        "488:CAD:ELF2-25B06-25-B-6 SUICIDE-7674 PINK DOGWOOD TR-HICKORY CREEK DR-[EMS] CALLER ADV THAT SUBJ TOOK SOME TYPE OF PILLS UNK FURTHER [03/01/13 00:30:07 CGRANTLAND] [Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 50 year old, Male, Consciousness unknown,\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:488",
        "SRC:ELF2",
        "CODE:25B06",
        "CALL:SUICIDE",
        "ADDR:7674 PINK DOGWOOD TR",
        "X:HICKORY CREEK DR",
        "INFO:CALLER ADV THAT SUBJ TOOK SOME TYPE OF PILLS UNK FURTHER / 50 year old, Male, Consciousness unknown,",
        "DATE:03/01/13",
        "TIME:00:30:07");

    doTest("T18",
        "487:CAD:ELF-1300000171-30A01-30-A-1 TRAUMATIC INJURIES-8218 BRIGHT WATER LN-HAGERS FERRY RD-BAYTREE LN-ADV PT HIT THE DOCK AND FELL IN THE WATER [02/28/13 15:50:26 ADEAN] ON THE SHORE LAYING IN THE EDGE OF THE WATER [02/28/13 15:49:24 ADEAN] CALLER ADV SUBJ FELL INTO WATER POSS BROKEN COLLAR BONE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000171",
        "SRC:ELF",
        "CODE:30A01",
        "CALL:TRAUMATIC INJURIES",
        "ADDR:8218 BRIGHT WATER LN",
        "X:HAGERS FERRY RD & BAYTREE LN",
        "INFO:ADV PT HIT THE DOCK AND FELL IN THE WATER / ON THE SHORE LAYING IN THE EDGE OF THE WATER / CALLER ADV SUBJ FELL INTO WATER POSS BROKEN COLLAR BONE",
        "DATE:02/28/13",
        "TIME:15:50:26");

    doTest("T19",
        "486:CAD:ELF-1300000170-129C03-SERVICE CALL OR CITIZEN ASSIST-6973 SIFFORD RD-BLUE BIRD LN-EXETER LN-Event spawned from SUSPICIOUS / WANTED. [02/28/2013 15:34:49 ADEAN] VEH IS RUNNING KEYS IN VEH [02/28/13 15:34:26 ADEAN] [Law Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Suspicious / Wanted\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000170",
        "SRC:ELF",
        "CODE:129C03",
        "CALL:SERVICE CALL OR CITIZEN ASSIST",
        "ADDR:6973 SIFFORD RD",
        "X:BLUE BIRD LN & EXETER LN",
        "INFO:Event spawned from SUSPICIOUS / WANTED. / VEH IS RUNNING KEYS IN VEH / Suspicious / Wanted",
        "DATE:02/28/2013",
        "TIME:15:34:49");

    doTest("T20",
        "485:CAD:ELF2-25B03B-25-B-3 SUICIDE-7630-BLK HICKORY CREEK DR-PINK DOGWOOD TR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 21 year old, Gender unknown, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. THREATE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:485",
        "SRC:ELF2",
        "CODE:25B03B",
        "CALL:SUICIDE",
        "ADDR:7630-BLK HICKORY CREEK DR",
        "MADDR:7630 HICKORY CREEK DR",
        "X:PINK DOGWOOD TR",
        "INFO:21 year old, Gender unknown, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. THREATE");

    doTest("T21",
        "484:CAD:ELF-1300000168-131B01B-29-B-2 TRAFFIC ACCIDENT-6592 NC 73 HWY-STATE EMPLOYEES CREDIT FI-307-N LITTLE EGYPT RD-CROSSCUT DR-Event spawned from VEHICLE ACC PD ONLY. [02/26/2013 19:59:03 SPITTS] {L180} ADV NEEDS 1 EMS UNIT REF HEAD INJURY NO BLEEDING [02/26/13 19:58:25 ABURNETTE] [Law Priority Info] ***[Vehicle Info--\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000168",
        "SRC:ELF",
        "CODE:131B01B",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:6592 NC 73 HWY",
        "MADDR:6592 STATE 73",
        "INFO:STATE EMPLOYEES CREDIT FI / 307 / N LITTLE EGYPT RD / CROSSCUT DR / Event spawned from VEHICLE ACC PD ONLY. / {L180} ADV NEEDS 1 EMS UNIT REF HEAD INJURY NO BLEEDING",
        "DATE:02/26/2013",
        "TIME:19:59:03");

    doTest("T22",
        "483:CAD:DFD3-1300000166-STRUCTURE FIRE-7409 WEBBS RD-CVS-N NC 16 HWY-WATER HAVEN TR-ON OLD NC 16 HWY [02/26/13 15:02:21 DWALKER] USED CAR LOT ON HWY 16 CLOSE TO CVS ON WEBBS RD [02/26/13 15:02:08 DWALKER]\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000166",
        "SRC:DFD3",
        "CALL:STRUCTURE FIRE",
        "ADDR:7409 WEBBS RD",
        "PLACE:CVS",
        "X:N NC 16 HWY & WATER HAVEN TR",
        "INFO:ON OLD NC 16 HWY / USED CAR LOT ON HWY 16 CLOSE TO CVS ON WEBBS RD",
        "DATE:02/26/13",
        "TIME:15:02:21");

    doTest("T23",
        "482:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-7274 NC 73 HWY-CHESTERBROOK ACADEMY-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Age unknown, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is compl\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:482",
        "SRC:ELF",
        "CODE:31D02",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:7274 NC 73 HWY",
        "MADDR:7274 STATE 73",
        "PLACE:CHESTERBROOK ACADEMY",
        "X:S NEW NC 16 HWY & COTTONWOOD COMMONS DR",
        "INFO:Age unknown, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is compl");

    doTest("T24",
        "481:CAD:ELF-10C04-10-C-4 CHEST PAIN-7476-600 WATERSIDE LOOP RD-WATERSIDE CROSSING BLVD-WATERSIDE CROSSING BLVD-[EMS] GO TO SIDE DOOR [02/26/13 10:01:52 DWALKER] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 60 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing nor\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:481",
        "SRC:ELF",
        "CODE:10C04",
        "CALL:CHEST PAIN",
        "ADDR:7476-600 WATERSIDE LOOP RD",
        "MADDR:7476 WATERSIDE LOOP RD",
        "X:WATERSIDE CROSSING BLVD & WATERSIDE CROSSING BLVD",
        "INFO:GO TO SIDE DOOR / 60 year old, Male, Conscious, Breathing. Chest Pain (Non / Traumatic). Breathing nor",
        "DATE:02/26/13",
        "TIME:10:01:52");

    doTest("T25",
        "480:CAD:ELF-1300000163-69D06-STRUCTURE FIRE-783 SLOAN ST-ALDWYCH LN-DRURY LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is visible. 3.The incident involves a single-family\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000163",
        "SRC:ELF",
        "CODE:69D06",
        "CALL:STRUCTURE FIRE",
        "ADDR:783 SLOAN ST",
        "X:ALDWYCH LN & DRURY LN",
        "INFO:Structure Fire. Residential (single). 1.The caller is on scene (1st party). 2.Smoke is visible. 3.The incident involves a single / family");

    doTest("T26",
        "479:CAD:ELF-1300000162-67B03U-OUTSIDE FIRE-6238-BLK MCINTOSH RD-STERLING CT-CALLER DID NOT WANT TO GIVE INFORMATION [02/24/13 18:05:57 ADEAN] CALLER ADV OUTSIDE FIRE, FIRE IS OUT AT THIS TIME [02/24/13 18:05:46 ADEAN] [Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT:\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000162",
        "SRC:ELF",
        "CODE:67B03U",
        "CALL:OUTSIDE FIRE",
        "ADDR:6238-BLK MCINTOSH RD",
        "MADDR:6238 MCINTOSH RD",
        "X:STERLING CT",
        "INFO:CALLER DID NOT WANT TO GIVE INFORMATION / CALLER ADV OUTSIDE FIRE, FIRE IS OUT AT THIS TIME",
        "DATE:02/24/13",
        "TIME:18:05:57");

    doTest("T27",
        "478:CAD:ELF-1300000161-52B01G-ALARMS FOR FIRE-8186 WATERFORD DR-STARBOARD LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000161",
        "SRC:ELF",
        "CODE:52B01G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:8186 WATERFORD DR",
        "X:STARBOARD LN",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE");

    doTest("T28",
        "477:CAD:ELF-1300000161-52B01G-ALARMS FOR FIRE-8186 WATERFORD DR-STARBOARD LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000161",
        "SRC:ELF",
        "CODE:52B01G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:8186 WATERFORD DR",
        "X:STARBOARD LN",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/FIRE");

    doTest("T29",
        "476:CAD:ELF-VEHICLE FRE-N NC 16 HWY/NC 73 HWY-VEHICLE ON FIRE [02/24/13 14:50:25 JHENDERSON]\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:476",
        "SRC:ELF",
        "CALL:VEHICLE FRE",
        "ADDR:N NC 16 HWY & NC 73 HWY",
        "MADDR:N STATE 16 & STATE 73",
        "INFO:VEHICLE ON FIRE",
        "DATE:02/24/13",
        "TIME:14:50:25");

    doTest("T30",
        "475:CAD:DFD-1300000159-69D06-STRUCTURE FIRE-6498 AMEBA LN-DUSTY RIDGE CT-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single). 1. The caller is on scene (1st party). 2. Both smoke and flames are visible. 3. The incident invo\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000159",
        "SRC:DFD",
        "CODE:69D06",
        "CALL:STRUCTURE FIRE",
        "ADDR:6498 AMEBA LN",
        "X:DUSTY RIDGE CT",
        "INFO:Structure Fire. Residential (single). 1. The caller is on scene (1st party). 2. Both smoke and flames are visible. 3. The incident invo");

    doTest("T31",
        "474:CAD:ELF-1300000158-52C03G-ALARMS FOR FIRE-7733 OLD PLANK RD-JULIUS BLUM INC-MIKRON DR-S NC 16 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm monitoring company. 2.It is a general/fire alarm. 3.T\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000158",
        "SRC:ELF",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7733 OLD PLANK RD",
        "PLACE:JULIUS BLUM INC",
        "X:MIKRON DR & S NC 16 HWY",
        "INFO:Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm monitoring company. 2.It is a general/fire alarm. 3.T");

    doTest("T32",
        "473:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-7850 LUCKY CREEK LN-MORRELL LN-MORRELL LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 52 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is not\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:473",
        "SRC:ELF",
        "CODE:31D02",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:7850 LUCKY CREEK LN",
        "X:MORRELL LN & MORRELL LN",
        "INFO:52 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. 1.Her breathing is not");

    doTest("T33",
        "472:CAD:ELF2-1300000156-67B03U-OUTSIDE FIRE-UNITY CHURCH RD/CHERRY LN-smells strong odor of a fire does not see [02/21/13 22:17:12 WRUSSELL] [Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. Unknown situation (investigation) (Unknown).Caller Sta\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000156",
        "SRC:ELF2",
        "CODE:67B03U",
        "CALL:OUTSIDE FIRE",
        "ADDR:UNITY CHURCH RD & CHERRY LN",
        "INFO:smells strong odor of a fire does not see / Outside Fire. Unknown situation (investigation) (Unknown).Caller Sta",
        "DATE:02/21/13",
        "TIME:22:17:12");

    doTest("T34",
        "471:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-7773 CLOVER LN-BLACKWOOD RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 66 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.Sh\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:471",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7773 CLOVER LN",
        "X:BLACKWOOD RD",
        "INFO:66 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.Sh");

    doTest("T35",
        "470:CAD:ELF-1300000153-53A01-SERVICE CALL OR CITIZEN ASSIST-7486 WATERSIDE LOOP RD-WATERSIDE CROSSING BLVD-WATERSIDE CROSSING BLVD-[Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Citizen Assist / Service Call. Locked in/out of building (non-medical assistance).Caller Statement: CHILD LOCKED IN CAR. 1.The caller is on\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000153",
        "SRC:ELF",
        "CODE:53A01",
        "CALL:SERVICE CALL OR CITIZEN ASSIST",
        "ADDR:7486 WATERSIDE LOOP RD",
        "X:WATERSIDE CROSSING BLVD & WATERSIDE CROSSING BLVD",
        "INFO:Citizen Assist / Service Call. Locked in/out of building (non / medical assistance).Caller Statement: CHILD LOCKED IN CAR. 1.The caller is on");

    doTest("T36",
        "469:CAD:DFD-1300000152-69D06O-STRUCTURE FIRE-3844 BRYN MAR LN-N NC 16 HWY-[Fire Priority Update] Fire Priority reconfigured event from 69-D-06O to 69-D-06T. RESPONSE: Delta RESPONDER SCRIPT: Residential (single) (Trapped person(s)). 7.Someone is trapped inside th\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000152",
        "SRC:DFD",
        "CODE:69D06O",
        "CALL:STRUCTURE FIRE",
        "ADDR:3844 BRYN MAR LN",
        "X:N NC 16 HWY",
        "INFO:Fire Priority reconfigured event from 69 / D / 06O to 69 / D / 06T. RESPONSE: Delta RESPONDER SCRIPT: Residential (single) (Trapped person(s)). 7.Someone is trapped inside th");

    doTest("T37",
        "468:CAD:ELF-1300000150-52C03G-ALARMS FOR FIRE-7981 OPTIMIST CLUB RD-LAKEWOOD CARE CENTER-AIRLIE PKWY-WOODS LN-SHOWING CENTER ACTIVATION [02/19/13 10:56:50 ADEAN] [Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm mon\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000150",
        "SRC:ELF",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7981 OPTIMIST CLUB RD",
        "PLACE:LAKEWOOD CARE CENTER",
        "X:AIRLIE PKWY & WOODS LN",
        "INFO:SHOWING CENTER ACTIVATION / Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire). 1.The caller is an alarm mon",
        "DATE:02/19/13",
        "TIME:10:56:50");

    doTest("T38",
        "467:CAD:ELF-VEHICLE ACC PD ONLY-7047283145-VERIZON WIRELESS-NC 73 HWY/N INGLESIDE FARM RD-[Law Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: TRAFFIC / TRANSPORTATION ACCIDENT (CRASH).TRAFFIC ACCIDENT (NO INJURY) (BLOCKING TRAFFIC). CALLER STATEMENT: 1050-PD. 1.THE CALLER IS NOT ON\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:467",
        "SRC:ELF",
        "CALL:VEHICLE ACC PD ONLY",
        "PHONE:7047283145",
        "ADDR:NC 73 HWY & N INGLESIDE FARM RD",
        "MADDR:STATE 73 & N INGLESIDE FARM RD",
        "INFO:TRAFFIC / TRANSPORTATION ACCIDENT (CRASH).TRAFFIC ACCIDENT (NO INJURY) (BLOCKING TRAFFIC). CALLER STATEMENT: 1050 / PD. 1.THE CALLER IS NOT ON");

    doTest("T39",
        "466:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-404 S NC 16 HWY-S LITTLE EGYPT RD-S PILOT KNOB RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 56 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFF BREATHING. 1\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:466",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:404 S NC 16 HWY",
        "MADDR:404 S STATE 16",
        "X:S LITTLE EGYPT RD & S PILOT KNOB RD",
        "INFO:56 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: DIFF BREATHING. 1");

    doTest("T40",
        "465:CAD:ELF-31D02-31-D-2 UNCONSCIOUS/FAINTING-1957 SENNEBOGEN TR-SENNEBOGEN CO-OLD PLANK RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Age unknown, Female, Unconscious, Breathing status unknown. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Caller State\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:465",
        "SRC:ELF",
        "CODE:31D02",
        "CALL:UNCONSCIOUS/FAINTING",
        "ADDR:1957 SENNEBOGEN TR",
        "PLACE:SENNEBOGEN CO",
        "X:OLD PLANK RD",
        "INFO:Age unknown, Female, Unconscious, Breathing status unknown. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Caller State");

    doTest("T41",
        "464:CAD:ELF-1300000145-52C03G-ALARMS FOR FIRE-206 N LITTLE EGYPT RD-CATAWBA SPRINGS ELM SI-314-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000145",
        "SRC:ELF",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:206 N LITTLE EGYPT RD",
        "INFO:CATAWBA SPRINGS ELM SI / 314 / CATAWBA SPRINGS RD / ALDWYCH LN / ALARMS. COMMERCIAL/INDUSTRIAL BUILDING (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT I");

    doTest("T42",
        "463:CAD:ELF-1300000144-52B01S-ALARMS FOR FIRE-310 N LITTLE EGYPT RD-CATAWBA SPRINGS RD-ALDWYCH LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000144",
        "SRC:ELF",
        "CODE:52B01S",
        "CALL:ALARMS FOR FIRE",
        "ADDR:310 N LITTLE EGYPT RD",
        "X:CATAWBA SPRINGS RD & ALDWYCH LN",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE");

    doTest("T43",
        "462:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-2065 BASIN LN-BEDROCK LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 70 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING . 1.S\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:462",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:2065 BASIN LN",
        "X:BEDROCK LN",
        "INFO:70 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING . 1.S");

    doTest("T44",
        "461:CAD:ELF-26C02-26-C-2 SICK PERSON-253 COWANS FORD RD-CHIPMUNK TR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 40 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:461",
        "SRC:ELF",
        "CODE:26C02",
        "CALL:SICK PERSON",
        "ADDR:253 COWANS FORD RD",
        "X:CHIPMUNK TR",
        "INFO:40 year old, Female, Conscious, Breathing. Sick Person (Specific Diagnosis). Abnormal breathing. 1.She is completely alert (respondi");

    doTest("T45",
        "460:CAD:ELF-06C01-6-C-1 BREATHING PROBLEMS-1222 S NC 16 HWY-SIFFORD RD-BOB WHITE TR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 86 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing. Caller Statement: SHORTNESS OF BREATH. 1.She is\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:460",
        "SRC:ELF",
        "CODE:06C01",
        "CALL:BREATHING PROBLEMS",
        "ADDR:1222 S NC 16 HWY",
        "MADDR:1222 S STATE 16",
        "X:SIFFORD RD & BOB WHITE TR",
        "INFO:86 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing. Caller Statement: SHORTNESS OF BREATH. 1.She is");

    doTest("T46",
        "459:CAD:ELF2-19C02-19-C-2 HEART PROBLEMS-9124 UNITY CHURCH RD-BEATTYS FORD ACCESS-SHIPLEY LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 71 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Abnormal breathing. Caller Statement: heart racing/poss broken ar\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:459",
        "SRC:ELF2",
        "CODE:19C02",
        "CALL:HEART PROBLEMS",
        "ADDR:9124 UNITY CHURCH RD",
        "PLACE:BEATTYS FORD ACCESS",
        "X:SHIPLEY LN",
        "INFO:71 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Abnormal breathing. Caller Statement: heart racing/poss broken ar");

    doTest("T47",
        "458:CAD:DFD3-1300000139-52B01G-ALARMS FOR FIRE-7987 WESTBAY RD-BAY POINTE DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000139",
        "SRC:DFD3",
        "CODE:52B01G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7987 WESTBAY RD",
        "X:BAY POINTE DR",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (GENERAL/FIRE).CALLER STATEMENT: FIRE ALARM. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A GENERAL/");

    doTest("T48",
        "457:CAD:ELF-1300000138-52B01C-52-B-1C CO ALARM-7418 GATE KEY CT-SEDGEBROOK DR WEST-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (CARBON MONOXIDE).CALLER STATEMENT: CARBON MIN GOING OFF. 1.THIS IS A PRIVATE CALLER. 2.THE CALLER IS ON SCE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000138",
        "SRC:ELF",
        "CODE:52B01C",
        "CALL:52",
        "ADDR:B",
        "MADDR:B & 7418 GATE KEY CT",
        "PLACE:1C CO ALARM",
        "X:7418 GATE KEY CT",
        "INFO:SEDGEBROOK DR WEST / ALARMS. RESIDENTIAL (SINGLE) (CARBON MONOXIDE).CALLER STATEMENT: CARBON MIN GOING OFF. 1.THIS IS A PRIVATE CALLER. 2.THE CALLER IS ON SCE");

    doTest("T49",
        "456:CAD:ELF2-17B03G-17-B-3 FALLS-2874 MORRIS LN-SHERRILL COVE WAY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 76 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: wi\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:456",
        "SRC:ELF2",
        "CODE:17B03G",
        "CALL:FALLS",
        "ADDR:2874 MORRIS LN",
        "X:SHERRILL COVE WAY",
        "INFO:76 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: wi");

    doTest("T50",
        "455:CAD:ELF-1300000136-29B04-29-B-4 TRAFFIC ACCIDENT-134 N NC 16 HWY-BOJANGLES-NC 73 HWY-FOREST OAK DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000136",
        "SRC:ELF",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:134 N NC 16 HWY",
        "MADDR:134 N STATE 16",
        "PLACE:BOJANGLES",
        "X:NC 73 HWY & FOREST OAK DR",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T51",
        "454:CAD:ELF-1300000135-52B01S-ALARMS FOR FIRE-8098 MALIBU POINTE LN-N NC 16 HWY-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: ALARMS. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETE\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000135",
        "SRC:ELF",
        "CODE:52B01S",
        "CALL:ALARMS FOR FIRE",
        "ADDR:8098 MALIBU POINTE LN",
        "X:N NC 16 HWY",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR).CALLER STATEMENT: ALARMS. 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETE");

    doTest("T52",
        "453:CAD:ELF-10C01-10-C-1 CHEST PAIN-2065 BASIN LN-BEDROCK LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 72 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. 1.He is completely alert (responding approp\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:453",
        "SRC:ELF",
        "CODE:10C01",
        "CALL:CHEST PAIN",
        "ADDR:2065 BASIN LN",
        "X:BEDROCK LN",
        "INFO:72 year old, Male, Conscious, Breathing. Chest Pain (Non / Traumatic). Abnormal breathing. 1.He is completely alert (responding approp");

    doTest("T53",
        "452:CAD:ELF-10C04-10-C-4 CHEST PAIN-1723 NEWLAND RD-EAST BERKELEY RD-NATALIE COMMONS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 48 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. 1.She is completely alert (respond\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:452",
        "SRC:ELF",
        "CODE:10C04",
        "CALL:CHEST PAIN",
        "ADDR:1723 NEWLAND RD",
        "X:EAST BERKELEY RD & NATALIE COMMONS DR",
        "INFO:48 year old, Female, Conscious, Breathing. Chest Pain (Non / Traumatic). Breathing normally => 35. 1.She is completely alert (respond");

    doTest("T54",
        "451:CAD:ELF-17D03-17-D-3 FALLS-1604 S NC 16 HWY-KET TRANSPORTATION-MCINTOSH RD-OREGON TR-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 54 year old, Female, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less than 6hrs ago). 2. It\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:451",
        "SRC:ELF",
        "CODE:17D03",
        "CALL:FALLS",
        "ADDR:1604 S NC 16 HWY",
        "MADDR:1604 S STATE 16",
        "PLACE:KET TRANSPORTATION",
        "X:MCINTOSH RD & OREGON TR",
        "INFO:54 year old, Female, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less than 6hrs ago). 2. It");

    doTest("T55",
        "450:CAD:ELF2-1300000131-69D06-STRUCTURE FIRE-2558 RANGER ISLAND RD-RANGER ISLAND MARINA RD-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Residential (single).Caller Statement: STRUCTURE FIRE. 1.The caller is not on scene. 2.Both smoke and flames are visible.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000131",
        "SRC:ELF2",
        "CODE:69D06",
        "CALL:STRUCTURE FIRE",
        "ADDR:2558 RANGER ISLAND RD",
        "X:RANGER ISLAND MARINA RD",
        "INFO:Structure Fire. Residential (single).Caller Statement: STRUCTURE FIRE. 1.The caller is not on scene. 2.Both smoke and flames are visible.");

    doTest("T56",
        "449:CAD:ELF-10D04-10-D-4 CHEST PAIN-553 S INGLESIDE FARM RD-STABLEVIEW LN-TYCO MEADOWS LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 76 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. 1.She is completely alert (responding appropriately).\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:449",
        "SRC:ELF",
        "CODE:10D04",
        "CALL:CHEST PAIN",
        "ADDR:553 S INGLESIDE FARM RD",
        "X:STABLEVIEW LN & TYCO MEADOWS LN",
        "INFO:76 year old, Female, Conscious, Breathing. Chest Pain (Non / Traumatic). Clammy. 1.She is completely alert (responding appropriately).");

    doTest("T57",
        "448:CAD:ELF2-21B02-21-B-2 HEMORRHAGE-7840 GALWAY LN-EAST LINCOLN CHARTER SCHOOL-N NC 16 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 35 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. Caller Statement: cut finger. 1.The cause of\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:448",
        "SRC:ELF2",
        "CODE:21B02",
        "CALL:HEMORRHAGE",
        "ADDR:7840 GALWAY LN",
        "PLACE:EAST LINCOLN CHARTER SCHOOL",
        "X:N NC 16 HWY",
        "INFO:35 year old, Female, Conscious, Breathing. Hemorrhage / Lacerations. SERIOUS hemorrhage. Caller Statement: cut finger. 1.The cause of");

    doTest("T58",
        "447:CAD:ELF-28C10L-28-C-10 STROKE-7606 WEST BERKELEY RD-CALEY ST-NATALIE COMMONS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 89 year old, Male, Conscious, Breathing. Stroke (CVA). Breathing normally => 35 (Less than ___ hours since the symptoms started). Ca\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:447",
        "SRC:ELF",
        "CODE:28C10L",
        "CALL:STROKE",
        "ADDR:7606 WEST BERKELEY RD",
        "X:CALEY ST & NATALIE COMMONS DR",
        "INFO:89 year old, Male, Conscious, Breathing. Stroke (CVA). Breathing normally => 35 (Less than ___ hours since the symptoms started). Ca");

    doTest("T59",
        "446:CAD:ELF-1300000127-52B01S-ALARMS FOR FIRE-7977 HAGERS FERRY RD-DUCKWORTH LN-GRANT DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Smoke detector).Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smok\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000127",
        "SRC:ELF",
        "CODE:52B01S",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7977 HAGERS FERRY RD",
        "X:DUCKWORTH LN & GRANT DR",
        "INFO:Alarms. Residential (single) (Smoke detector).Caller Statement: fire alarm. 1. The caller is an alarm monitoring company. 2. It is a smok");

    doTest("T60",
        "445:CAD:ELF-19C04-19-C-4 HEART PROBLEMS-149 CROSS CENTER RD-HARRIS TEETER-NC 73 HWY-E CROSS DR-[EMS] WILL HAVE HIS FLASHERS ON [02/11/13 17:00:45 HJENKINS] [Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Car\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:445",
        "SRC:ELF",
        "CODE:19C04",
        "CALL:HEART PROBLEMS",
        "ADDR:149 CROSS CENTER RD",
        "PLACE:HARRIS TEETER",
        "X:NC 73 HWY & E CROSS DR",
        "INFO:WILL HAVE HIS FLASHERS ON / 18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Car",
        "DATE:02/11/13",
        "TIME:17:00:45");

    doTest("T61",
        "444:CAD:ELF-19C04-19-C-4 HEART PROBLEMS-149 CROSS CENTER RD-HARRIS TEETER-NC 73 HWY-E CROSS DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Cardiac history. Caller Statement: HEART PROBLEMS. 1.He is comp\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:444",
        "SRC:ELF",
        "CODE:19C04",
        "CALL:HEART PROBLEMS",
        "ADDR:149 CROSS CENTER RD",
        "PLACE:HARRIS TEETER",
        "X:NC 73 HWY & E CROSS DR",
        "INFO:18 year old, Male, Conscious, Breathing. Heart Problems / A.I.C.D.. Cardiac history. Caller Statement: HEART PROBLEMS. 1.He is comp");

    doTest("T62",
        "443:CAD:ELF-1300000124-71D03-VEHICLE FRE-789 S INGLESIDE FARM RD-TYCO MEADOWS LN-TOPAZ LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Vehicle Fire. Vehicle fire with THREATENED building/structure.Caller Statement: veh on fire. 1.The caller is on scene (1st party). 2.No on\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000124",
        "SRC:ELF",
        "CODE:71D03",
        "CALL:VEHICLE FRE",
        "ADDR:789 S INGLESIDE FARM RD",
        "X:TYCO MEADOWS LN & TOPAZ LN",
        "INFO:Vehicle Fire. Vehicle fire with THREATENED building/structure.Caller Statement: veh on fire. 1.The caller is on scene (1st party). 2.No on");

    doTest("T63",
        "442:CAD:ELF-1300000123-29B04-29-B-4 TRAFFIC ACCIDENT-135 N NEW NC 16 HWY-OPTIMIST CLUB RD-NC 73 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000123",
        "SRC:ELF",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:135 N NEW NC 16 HWY",
        "MADDR:135 N NEW STATE 16",
        "X:OPTIMIST CLUB RD & NC 73 HWY",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T64",
        "441:CAD:ELF-1300000122-55C01-ELECTRICAL HAZARD-1742 MAGNET LN-OLD PLANK RD-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Electrical Hazard. Electrical hazard with or near water. 1.The caller is on scene (1st party). 2.Electrical equipment is involved. 3.S\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000122",
        "SRC:ELF",
        "CODE:55C01",
        "CALL:ELECTRICAL HAZARD",
        "ADDR:1742 MAGNET LN",
        "X:OLD PLANK RD",
        "INFO:Electrical Hazard. Electrical hazard with or near water. 1.The caller is on scene (1st party). 2.Electrical equipment is involved. 3.S");

    doTest("T65",
        "440:CAD:ELF-28C02L-28-C-2 STROKE-7736 TURNBERRY LN-BENT TREE DR-CLUB DR-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 62 year old, Male, Conscious, Breathing. Stroke (CVA). Abnormal breathing (Less than ___ hours since the symptoms started). Caller S\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:440",
        "SRC:ELF",
        "CODE:28C02L",
        "CALL:STROKE",
        "ADDR:7736 TURNBERRY LN",
        "X:BENT TREE DR & CLUB DR",
        "INFO:62 year old, Male, Conscious, Breathing. Stroke (CVA). Abnormal breathing (Less than ___ hours since the symptoms started). Caller S");

    doTest("T66",
        "439:CAD:ELF-10C04-10-C-4 CHEST PAIN-7456 WATERLEAF CT-SEDGEBROOK DR WEST-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 62 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Breathing normally => 35. Caller Statement: wife chest pains.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:439",
        "SRC:ELF",
        "CODE:10C04",
        "CALL:CHEST PAIN",
        "ADDR:7456 WATERLEAF CT",
        "INFO:SEDGEBROOK DR WEST / 62 year old, Female, Conscious, Breathing. Chest Pain (Non / Traumatic). Breathing normally => 35. Caller Statement: wife chest pains.");

    doTest("T67",
        "438:CAD:ELF2-1300000119-52B01S-ALARMS FOR FIRE-2572 LAKE SHORE RD S-LAKEVIEW DR-LAKEVIEW DR-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETECTOR ALARM. 3.THE INCID\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000119",
        "SRC:ELF2",
        "CODE:52B01S",
        "CALL:ALARMS FOR FIRE",
        "ADDR:2572 LAKE SHORE RD S",
        "X:LAKEVIEW DR & LAKEVIEW DR",
        "INFO:ALARMS. RESIDENTIAL (SINGLE) (SMOKE DETECTOR). 1.THE CALLER IS AN ALARM MONITORING COMPANY. 2.IT IS A SMOKE DETECTOR ALARM. 3.THE INCID");

    doTest("T68",
        "437:CAD:ELF-06C01A-6-C-1 BREATHING PROBLEMS-7804 CLOVER LN-BLACKWOOD RD-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFFICULTY BREATHING.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:437",
        "SRC:ELF",
        "CODE:06C01A",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7804 CLOVER LN",
        "X:BLACKWOOD RD",
        "INFO:79 year old, Male, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFFICULTY BREATHING.");

    doTest("T69",
        "436:CAD:ELF-17B03G-17-B-3 FALLS-231 N NC 16 HWY-RIVERWALK APARTMENTS BLDG 3-NC 73 HWY-FOREST OAK DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 88 year old, Female, Consciousness unknown, Breathing status unknown. Falls. Unknown status/Other codes not applicable (On the ground or fl\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:436",
        "SRC:ELF",
        "CODE:17B03G",
        "CALL:FALLS",
        "ADDR:231 N NC 16 HWY",
        "MADDR:231 N STATE 16",
        "PLACE:RIVERWALK APARTMENTS BLDG 3",
        "X:NC 73 HWY & FOREST OAK DR",
        "INFO:88 year old, Female, Consciousness unknown, Breathing status unknown. Falls. Unknown status/Other codes not applicable (On the ground or fl");

    doTest("T70",
        "435:CAD:ELF-1300000116-69D11-STRUCTURE FIRE-7617 WEST BERKELEY RD-NATALIE COMMONS DR-WOODS LN-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Unknown situation (investigation).Caller Statement: HOUSE FIRE . 1.The caller is not on scene. 2.Both smoke and flames are\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000116",
        "SRC:ELF",
        "CODE:69D11",
        "CALL:STRUCTURE FIRE",
        "ADDR:7617 WEST BERKELEY RD",
        "X:NATALIE COMMONS DR & WOODS LN",
        "INFO:Structure Fire. Unknown situation (investigation).Caller Statement: HOUSE FIRE . 1.The caller is not on scene. 2.Both smoke and flames are");

    doTest("T71",
        "434:CAD:ELF-1300000115-29B04-29-B-4 TRAFFIC ACCIDENT-SIFFORD RD/S NC 16 HWY-[Medical Priority Update] Medical Priority reconfigured event from 13-1-B01 to 29-B-04. RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Transporta\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000115",
        "SRC:ELF",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:SIFFORD RD & S NC 16 HWY",
        "MADDR:SIFFORD RD & S STATE 16",
        "INFO:Medical Priority reconfigured event from 13 / 1 / B01 to 29 / B / 04. RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Conscious, Breathing. Traffic / Transporta");

    doTest("T72",
        "433:CAD:ELF-1300000114-67B01B-OUTSIDE FIRE-8512-BLK NC 73 HWY-COWANS FORD OVERLOOK-CASWELL RD-EASTLAKE LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire (Buildings).Caller Statement: FIRE BY THE ROAD AND NEAR TREES. 1.The caller is not on scene. 2.This is a\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000114",
        "SRC:ELF",
        "CODE:67B01B",
        "CALL:OUTSIDE FIRE",
        "ADDR:8512-BLK NC 73 HWY",
        "MADDR:8512 STATE 73",
        "PLACE:COWANS FORD OVERLOOK",
        "X:CASWELL RD & EASTLAKE LN",
        "INFO:Outside Fire. SMALL OUTSIDE fire (Buildings).Caller Statement: FIRE BY THE ROAD AND NEAR TREES. 1.The caller is not on scene. 2.This is a");

    doTest("T73",
        "432:CAD:DFD3-32B02-32-B-2 UNKNOWN PROBLEM-5096 WINDWARD POINT LN-MCCONNELL RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:432",
        "SRC:DFD3",
        "CODE:32B02",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:5096 WINDWARD POINT LN",
        "X:MCCONNELL RD",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati");

    doTest("T74",
        "431:CAD:DFD-1300000112-69D09-STRUCTURE FIRE-6400 WILDWOOD TR-PIEDMONT TR-HENDERSON ST-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Structure Fire. Small NON-DWELLING building/structure (shed, detached garage).Caller Statement: OUTBUILDING ON FIRE. 1.The caller is on scen\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000112",
        "SRC:DFD",
        "CODE:69D09",
        "CALL:STRUCTURE FIRE",
        "ADDR:6400 WILDWOOD TR",
        "X:PIEDMONT TR & HENDERSON ST",
        "INFO:Structure Fire. Small NON / DWELLING building/structure (shed, detached garage).Caller Statement: OUTBUILDING ON FIRE. 1.The caller is on scen");

    doTest("T75",
        "430:CAD:ELF-1300000111-29B01-29-B-1 TRAFFIC ACCIDENT-7131 NC 73 HWY-WALMART DENVER-S NEW NC 16 HWY-COTTONWOOD COMMONS DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Injuries. Caller Statem\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000111",
        "SRC:ELF",
        "CODE:29B01",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:7131 NC 73 HWY",
        "MADDR:7131 STATE 73",
        "PLACE:WALMART DENVER",
        "X:S NEW NC 16 HWY & COTTONWOOD COMMONS DR",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Injuries. Caller Statem");

    doTest("T76",
        "429:CAD:ELF-06C01A-6-C-1 BREATHING PROBLEMS-6911 SIFFORD RD-BLUE BIRD LN-EXETER LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 69 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFF BREATHING. 1. She\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:429",
        "SRC:ELF",
        "CODE:06C01A",
        "CALL:BREATHING PROBLEMS",
        "ADDR:6911 SIFFORD RD",
        "X:BLUE BIRD LN & EXETER LN",
        "INFO:69 year old, Female, Conscious, Breathing. Breathing Problems. Abnormal breathing (Asthma). Caller Statement: DIFF BREATHING. 1. She");

    doTest("T77",
        "428:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-2140 JUNE DELLINGER RD-OLD PLANK RD-HINES CIRCLE RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 95 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.He i\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:428",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:2140 JUNE DELLINGER RD",
        "X:OLD PLANK RD & HINES CIRCLE RD",
        "INFO:95 year old, Male, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: BREATHING. 1.He i");

    doTest("T78",
        "427:CAD:ELF-1300000108-52C03G-ALARMS FOR FIRE-7733 OLD PLANK RD-JULIUS BLUM INC-MIKRON DR-S NC 16 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire).Caller Statement: FIRE ALARM . 1.The caller is an alarm monitoring company. 2.It\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000108",
        "SRC:ELF",
        "CODE:52C03G",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7733 OLD PLANK RD",
        "PLACE:JULIUS BLUM INC",
        "X:MIKRON DR & S NC 16 HWY",
        "INFO:Alarms. COMMERCIAL/INDUSTRIAL building (General/Fire).Caller Statement: FIRE ALARM . 1.The caller is an alarm monitoring company. 2.It");

    doTest("T79",
        "426:CAD:ELF2-1300000107-52B01C-ALARMS FOR FIRE-7906 MARINERS POINTE CIR-SAIL POINTE LN-SAIL POINTE LN-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Alarms. Residential (single) (Carbon monoxide).Caller Statement: CARBON MONOXIDE ALARM GOING OFF. 1.The caller is an alarm monitoring compa\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000107",
        "SRC:ELF2",
        "CODE:52B01C",
        "CALL:ALARMS FOR FIRE",
        "ADDR:7906 MARINERS POINTE CIR",
        "X:SAIL POINTE LN & SAIL POINTE LN",
        "INFO:Alarms. Residential (single) (Carbon monoxide).Caller Statement: CARBON MONOXIDE ALARM GOING OFF. 1.The caller is an alarm monitoring compa");

    doTest("T80",
        "425:CAD:ELF-VEHICLE ACC PD ONLY-7048229999-HUGGINS,MELISSA-1182 S NC 16 HWY-Aborted by Medical Priority with code: UNK [02/06/13 11:23:55 SPITTS] ANTIFREEZE LEAKING FROM THE VEH [02/06/13 11:22:51 SPITTS] [Law Priority Info] ***[Vehicle Info-- - VINDEX: 1 - TYPE: Suspe-SIFFORD RD-BOB WHITE TR\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:425",
        "SRC:ELF",
        "CALL:VEHICLE ACC PD ONLY",
        "PHONE:7048229999",
        "NAME:HUGGINS,MELISSA",
        "ADDR:1182 S NC 16 HWY",
        "MADDR:1182 S STATE 16",
        "INFO:Aborted by Medical Priority with code: UNK / ANTIFREEZE LEAKING FROM THE VEH",
        "DATE:02/06/13",
        "TIME:11:23:55");

    doTest("T81",
        "424:CAD:ELF-1300000105-53O06-SERVICE CALL OR CITIZEN ASSIST-7981 OPTIMIST CLUB RD-LAKEWOOD CARE CENTER-AIRLIE PKWY-WOODS LN-[Fire Priority Info] RESPONSE: Omega RESPONDER SCRIPT: Citizen Assist / Service Call. Other. 1.The caller is on scene (1st party). 2.Assistance is needed for another type of problem: RESET PULL\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000105",
        "SRC:ELF",
        "CODE:53O06",
        "CALL:SERVICE CALL OR CITIZEN ASSIST",
        "ADDR:7981 OPTIMIST CLUB RD",
        "PLACE:LAKEWOOD CARE CENTER",
        "X:AIRLIE PKWY & WOODS LN",
        "INFO:Citizen Assist / Service Call. Other. 1.The caller is on scene (1st party). 2.Assistance is needed for another type of problem: RESET PULL");

    doTest("T82",
        "423:CAD:ELF-10C01-10-C-1 CHEST PAIN-7682 OTTS CIR-NC 73 HWY-AUSTIN LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 52 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Caller Statement: chest. 1.He is completel\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:423",
        "SRC:ELF",
        "CODE:10C01",
        "CALL:CHEST PAIN",
        "ADDR:7682 OTTS CIR",
        "X:NC 73 HWY & AUSTIN LN",
        "INFO:52 year old, Male, Conscious, Breathing. Chest Pain (Non / Traumatic). Abnormal breathing. Caller Statement: chest. 1.He is completel");

    doTest("T83",
        "422:CAD:ELF-17B03G-17-B-3 FALLS-823 KILLIAN FARM RD-SIFFORD RD-ROXBORO LN-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 73 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: FA\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:422",
        "SRC:ELF",
        "CODE:17B03G",
        "CALL:FALLS",
        "ADDR:823 KILLIAN FARM RD",
        "X:SIFFORD RD & ROXBORO LN",
        "INFO:73 year old, Female, Conscious, Breathing. Falls. Unknown status/Other codes not applicable (On the ground or floor). Caller Statement: FA");

    doTest("T84",
        "421:CAD:ELF-10D01-10-D-1 CHEST PAIN-8223 OPTIMIST CLUB RD-CRUSE LN-RUFUS RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 87 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Not alert. Caller Statement: MOTHER HAVING CHEST PAIN . 1. She is\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:421",
        "SRC:ELF",
        "CODE:10D01",
        "CALL:CHEST PAIN",
        "ADDR:8223 OPTIMIST CLUB RD",
        "X:CRUSE LN & RUFUS RD",
        "INFO:87 year old, Female, Conscious, Breathing. Chest Pain (Non / Traumatic). Not alert. Caller Statement: MOTHER HAVING CHEST PAIN . 1. She is");

    doTest("T85",
        "420:CAD:ELF-32B02-32-B-2 UNKNOWN PROBLEM-896 DOVE CT-VIRGINIA CAROLINA REFRACTORY-TOWNSEND DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:420",
        "SRC:ELF",
        "CODE:32B02",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:896 DOVE CT",
        "PLACE:VIRGINIA CAROLINA REFRACTORY",
        "X:TOWNSEND DR",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Medical Alarm (Alert) notificati");

    doTest("T86",
        "419:CAD:ELF-1300000100-68A02-SMOKE INVESTIGATION-OPTIMIST CLUB RD/N NEW NC 16 HWY-AIRLIE BUSINESS PARK-[Fire Priority Info] RESPONSE: Alpha RESPONDER SCRIPT: Smoke Investigation (Outside). Odor of smoke.Caller Statement: SMOKE NEAR THE RAILROAD TRACKS. 1.The caller is not on scene. 2.The caller\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000100",
        "SRC:ELF",
        "CODE:68A02",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:OPTIMIST CLUB RD & N NEW NC 16 HWY",
        "MADDR:OPTIMIST CLUB RD & N NEW STATE 16",
        "INFO:AIRLIE BUSINESS PARK / Smoke Investigation (Outside). Odor of smoke.Caller Statement: SMOKE NEAR THE RAILROAD TRACKS. 1.The caller is not on scene. 2.The caller");

    doTest("T87",
        "418:CAD:ELF-10D04-10-D-4 CHEST PAIN-7700 SEDGEBROOK DR EAST-GLENCREST DR-STONEMONT WAY-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 79 year old, Male, Conscious, Breathing. Chest Pain (Non-Traumatic). Clammy. 1.He is completely alert (responding appropriately). 2.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:418",
        "SRC:ELF",
        "CODE:10D04",
        "CALL:CHEST PAIN",
        "ADDR:7700 SEDGEBROOK DR EAST",
        "X:GLENCREST DR & STONEMONT WAY",
        "INFO:79 year old, Male, Conscious, Breathing. Chest Pain (Non / Traumatic). Clammy. 1.He is completely alert (responding appropriately). 2.");

    doTest("T88",
        "417:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-6911 SIFFORD RD-BLUE BIRD LN-EXETER LN-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 69 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: breathing prob. 1.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:417",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:6911 SIFFORD RD",
        "X:BLUE BIRD LN & EXETER LN",
        "INFO:69 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: breathing prob. 1.");

    doTest("T89",
        "416:CAD:ELF-1300000096-67D02U-OUTSIDE FIRE-6592 NC 73 HWY-STATE EMPLOYEES CREDIT FI-307-N LITTLE EGYPT RD-CROSSCUT DR-[Fire Priority Info] RESPONSE: Delta RESPONDER SCRIPT: Outside Fire. LARGE BRUSH/GRASS fire (Unknown).Caller Statement: outside fire. 1. The caller is not on scene. 2. This is a LARGE BRUSH/GR\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000096",
        "SRC:ELF",
        "CODE:67D02U",
        "CALL:OUTSIDE FIRE",
        "ADDR:6592 NC 73 HWY",
        "MADDR:6592 STATE 73",
        "INFO:STATE EMPLOYEES CREDIT FI / 307 / N LITTLE EGYPT RD / CROSSCUT DR / Outside Fire. LARGE BRUSH/GRASS fire (Unknown).Caller Statement: outside fire. 1. The caller is not on scene. 2. This is a LARGE BRUSH/GR");

    doTest("T90",
        "415:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-7359 RED FOX LN-KILLIAN FARM RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 89 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOM HAVING A HARD\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:415",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:7359 RED FOX LN",
        "X:KILLIAN FARM RD",
        "INFO:89 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOM HAVING A HARD");

    doTest("T91",
        "414:CAD:ELF-1300000094-59C04U-FUEL SPILL-TREETOPS DR/NC 73 HWY-[Fire Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: Fuel Spill. Unknown situation (investigation) (Unknown).Caller Statement: gas leak in roadway. 1.The caller is not on scene. 2.It is no\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000094",
        "SRC:ELF",
        "CODE:59C04U",
        "CALL:FUEL SPILL",
        "ADDR:TREETOPS DR & NC 73 HWY",
        "MADDR:TREETOPS DR & STATE 73",
        "INFO:Fuel Spill. Unknown situation (investigation) (Unknown).Caller Statement: gas leak in roadway. 1.The caller is not on scene. 2.It is no");

    doTest("T92",
        "413:CAD:ELF-10C02-10-C-2 CHEST PAIN-8062 BLACKWOOD RD-CHEVAL LN-CHEVAL LN-[Medical Priority Info] RESPONSE: Charlie RESPONDER SCRIPT: 50 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Heart attack or angina history. Caller Statement: tightness in\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:413",
        "SRC:ELF",
        "CODE:10C02",
        "CALL:CHEST PAIN",
        "ADDR:8062 BLACKWOOD RD",
        "X:CHEVAL LN & CHEVAL LN",
        "INFO:50 year old, Female, Conscious, Breathing. Chest Pain (Non / Traumatic). Heart attack or angina history. Caller Statement: tightness in");

    doTest("T93",
        "412:CAD:ELF2-25B06V-25-B-6 SUICIDE-8386 NORMANDY RD-HARMONY LN-VANDALAY DR-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: 24 year old, Female, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. Unknown status/\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:412",
        "SRC:ELF2",
        "CODE:25B06V",
        "CALL:SUICIDE",
        "ADDR:8386 NORMANDY RD",
        "X:HARMONY LN & VANDALAY DR",
        "INFO:24 year old, Female, Consciousness unknown, Breathing status unknown. Psychiatric / Abnormal Behavior / Suicide Attempt. Unknown status/");

    doTest("T94",
        "411:CAD:ELF-1300000091-29B04-29-B-4 TRAFFIC ACCIDENT-7405 NC 73 HWY-KANGAROO-S NC 16 HWY-CROSS CENTER RD-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000091",
        "SRC:ELF",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:7405 NC 73 HWY",
        "MADDR:7405 STATE 73",
        "PLACE:KANGAROO",
        "X:S NC 16 HWY & CROSS CENTER RD",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T95",
        "410:CAD:DFD3-1300000090-WATERCRAFT IN DISTRESS-8094 BRADFORD LN-BURTON LN-Event spawned from ANY BOATING COMPLAINT. [01/31/13 15:55:20 RROMBS] MECK NOTIFIED [01/31/13 15:51:41 RROMBS] BETWEEN MARKERS 6 AND MARKERS 7 [01/31/13 15:46:46 RROMBS] ELONGATED FISHING BOAT -\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000090",
        "SRC:DFD3",
        "CALL:WATERCRAFT IN DISTRESS",
        "ADDR:8094 BRADFORD LN",
        "X:BURTON LN",
        "INFO:Event spawned from ANY BOATING COMPLAINT. / MECK NOTIFIED / BETWEEN MARKERS 6 AND MARKERS 7 / ELONGATED FISHING BOAT",
        "DATE:01/31/13",
        "TIME:15:55:20");

    doTest("T96",
        "409:CAD:ELF-06D02-6-D-2 BREATHING PROBLEMS-5706 DAYBROOK CT-HINES CIRCLE RD-[Medical Priority Info] RESPONSE: Delta RESPONDER SCRIPT: 75 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOTHER CAN`T BREATH.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:409",
        "SRC:ELF",
        "CODE:06D02",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5706 DAYBROOK CT",
        "X:HINES CIRCLE RD",
        "INFO:75 year old, Female, Conscious, Breathing. Breathing Problems. DIFFICULTY SPEAKING BETWEEN BREATHS. Caller Statement: MOTHER CAN`T BREATH.");

    doTest("T97",
        "408:CAD:ELF-1300000088-67B01U-ELECTRICAL HAZARD-7085 OLD PLANK RD-KILLIAN CREEK WATER TRTMT PLNT-SAUNDERS FAMILY LN-JUNE DELLINGER RD-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. SMALL OUTSIDE fire (Unknown).Caller Statement: TREE IN POWERLINE ON FIRE . 1. The caller is not on scene. 2. Other electric\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000088",
        "SRC:ELF",
        "CODE:67B01U",
        "CALL:ELECTRICAL HAZARD",
        "ADDR:7085 OLD PLANK RD",
        "PLACE:KILLIAN CREEK WATER TRTMT PLNT",
        "X:SAUNDERS FAMILY LN & JUNE DELLINGER RD",
        "INFO:Outside Fire. SMALL OUTSIDE fire (Unknown).Caller Statement: TREE IN POWERLINE ON FIRE . 1. The caller is not on scene. 2. Other electric");

    doTest("T98",
        "407:CAD:ELF-1300000087-29B04-29-B-4 TRAFFIC ACCIDENT-SIFFORD RD/S NC 16 HWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000087",
        "SRC:ELF",
        "CODE:29B04",
        "CALL:TRAFFIC ACCIDENT",
        "ADDR:SIFFORD RD & S NC 16 HWY",
        "MADDR:SIFFORD RD & S STATE 16",
        "INFO:Age unknown, Gender unknown, Consciousness unknown, Breathing status unknown. Traffic / Transportation Incidents. Unknown status/Other cod");

    doTest("T99",
        "406:CAD:ELF-32B03-32-B-3 UNKNOWN PROBLEM-7914 OPTIMIST CLUB RD-OPTIMIST CLUB RD CONVENIENCE-FORNEY CREEK PKWY-AIRLIE PKWY-[Medical Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Age unknown, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Unknown status/Other codes not applicable.\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:406",
        "SRC:ELF",
        "CODE:32B03",
        "CALL:UNKNOWN PROBLEM",
        "ADDR:7914 OPTIMIST CLUB RD",
        "PLACE:OPTIMIST CLUB RD CONVENIENCE",
        "X:FORNEY CREEK PKWY & AIRLIE PKWY",
        "INFO:Age unknown, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Unknown status/Other codes not applicable.");

    doTest("T100",
        "405:CAD:ELF2-1300000085-67B03U-OUTSIDE FIRE-ALLISON CT/LAKE SHORE RD S-[Fire Priority Info] RESPONSE: Bravo RESPONDER SCRIPT: Outside Fire. Unknown situation (investigation) (Unknown). 1.The caller is on scene (1st party). 2.This is a controlled burn. 3.The fir\n\n\n" +
        "DISCLAIMER: Pursuant to the Freedom of Information-Privacy Acts (FOIPA) and North Carolina General Statutes Chapter 132, \n" +
        "Public Records, this electronic mail message and any attachments hereto, as well as any electronic mail message(s) \n" +
        "sent in response to it may be considered public record and as such subject to request and review by anyone at any time.",

        "ID:1300000085",
        "SRC:ELF2",
        "CODE:67B03U",
        "CALL:OUTSIDE FIRE",
        "ADDR:ALLISON CT & LAKE SHORE RD S",
        "INFO:Outside Fire. Unknown situation (investigation) (Unknown). 1.The caller is on scene (1st party). 2.This is a controlled burn. 3.The fir");

  }
  
  
  @Test 
  public void testCorneliusLemleyFireRescue() {

    doTest("T1",
        "895:CAD:DFD-1300000607-69D06-STRUCT FIRE -RESIDENTIAL SNGL-6505 PERSIMMON LN-AIRVIEW LN-DENVER SHORES LN-[PROQA] Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. [08/07/13 02:10:12 KWILLIS] [PROQA] RESPONSE: Hot Response Caller Statement: trailer on fire Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident invol\r\n",
        "ID:1300000607",
        "SRC:DFD",
        "CODE:69D06",
        "CALL:STRUCT FIRE -RESIDENTIAL SNGL",
        "ADDR:6505 PERSIMMON LN",
        "X:AIRVIEW LN & DENVER SHORES LN",
        "INFO:Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. / RESPONSE: Hot Response Caller Statement: trailer on fire Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident invol",
        "DATE:08/07/13",
        "TIME:02:10:12");

    doTest("T2",
        "886:CAD:DFD3-1300000593-60B02O-GAS LEAK - OUTSIDE ODOR-2460 N NC 16 HWY-HAGERS HOLLOW DR-SARAH DR-[PROQA] RESPONSE: Hot Response Caller Statement: smell of natural gas at the lift station Chief Complaint: Gas Leak / Gas Odor (Natural and LP Gases) Suffix Info: Odor only Questions: It is not known where the leak is coming from, but there is an odor. The problem is reportedly outside. The gas can be smelled only. The caller is on scene (1st party). [08/02/13 12\r\n",
        "ID:1300000593",
        "SRC:DFD3",
        "CODE:60B02O",
        "CALL:GAS LEAK - OUTSIDE ODOR",
        "ADDR:2460 N NC 16 HWY",
        "MADDR:2460 N STATE 16",
        "X:HAGERS HOLLOW DR & SARAH DR",
        "INFO:RESPONSE: Hot Response Caller Statement: smell of natural gas at the lift station Chief Complaint: Gas Leak / Gas Odor (Natural and LP Gases) Suffix Info: Odor only Questions: It is not known where the leak is coming from, but there is an odor. The problem is reportedly outside. The gas can be smelled only. The caller is on scene (1st party).");

    doTest("T3",
        "882:CAD:ELF-1300000584-69D06-STRUCT FIRE -RESIDENTIAL SNGL-7629 BLUFF POINT LN-WATERSIDE CROSSING BLVD-[PROQA] Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. Floor: 1ST [07/30/13 10:01:31 HJENKINS] [PROQA] RESPONSE: Hot Response Caller Statement: STOVE ON FIRE Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident\r\n",
        "ID:1300000584",
        "SRC:ELF",
        "CODE:69D06",
        "CALL:STRUCT FIRE -RESIDENTIAL SNGL",
        "ADDR:7629 BLUFF POINT LN",
        "X:WATERSIDE CROSSING BLVD",
        "INFO:Key Questions Complete RESPONSE: Hot Response Questions: No one is trapped inside the structure. Floor: 1ST / RESPONSE: Hot Response Caller Statement: STOVE ON FIRE Chief Complaint: Structure Fire Questions: The caller has not indicated that there are trapped person(s). Both smoke and flames are visible. The incident",
        "DATE:07/30/13",
        "TIME:10:01:31");
 
  }
  

  public static void main(String[] args) {
    new NCLincolnCountyParserTest().generateTests("T1");
  }
}
