package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Waukesha County, WI
Contact: Active911
Agency name: Mukwonago
Location: Mukwonago, WI, United States
Sender: dispatch@mukwonagofire.org

(Phoenix Notification) 2013001175 {08/11/2013 12:36:16}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 cell transfer from Lisa who was requesting an ambo for herself because she was having a reaction to prescription medication for a bladder infection 
(Phoenix Notification) 2013001173 {08/11/2013 00:58:40}\nAMBO     - Ambulance Request{1}\n711 Fox St,BLDG\nUnits:\n    CAR1    3400A   3400    \nComments:\n John requesting an ambo for a 48 yoa female w/ severe chest pains. 
(Phoenix Notification) 2013001172 {08/10/2013 21:02:00}\nAMBO     - Ambulance Request{1}\n206 Jacobs Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n For parties with injuries to face and neck from possible physical altercation. Officers on scene. 
(Phoenix Notification) 2013001171 {08/10/2013 18:37:47}\nAMBO     - Ambulance Request{1}\n331 Westside Ave,3\nUnits:\n    CAR1    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001170 {08/10/2013 17:04:52}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\nCTH NN/N Rochester St\nUnits:\n    CAR1    3400A   3400    \nComments:\n Ladder in sewer drain on fire on CTH NN just east of STH 83; has been extinguished but officer would like fire dispatched due to drain still smoking. 
(Phoenix Notification) 2013001169 {08/10/2013 10:34:48}\nAMBO     - Ambulance Request{1}\n1545 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 1241 requesting 10-52 for unknown medical problem, possible vertigo 
(Phoenix Notification) 2013001168 {08/10/2013 10:08:45}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,119\nUnits:\n    3400    \nComments:\n 911 - non emergency request for a resident that is having difficulty walking and head pain. 
(Phoenix Notification) 2013001167 {08/10/2013 09:59:58}\nAMBO     - Ambulance Request{1}\nW335S8248 CTH E\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 - daughter requesting her 88 yoa father be transported to the hospital.  He is incoherant and has had some issues falling. 
(Phoenix Notification) 2013001165 {08/10/2013 02:43:18}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 cell transfer - Lisa requesting an ambo for herself due to abdominal pain and bowel issues. 
(Phoenix Notification) 2013001164 {08/09/2013 17:56:03}\nAMBO     - Ambulance Request{1}\n125 Michaels Ct,8\nUnits:\n    3400A   3400    \nComments:\n *911 - male request 10-52 for his wife who is having problems breathing.  
(Phoenix Notification) 2013001163 {08/09/2013 17:26:59}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,103\nUnits:\n    3400A   3400    \nComments:\n Kimberly/Linden Ridge requesting a 10-52 non-emergency for a female resident requesting to be transported to Oconomowoc for a lesion on her thigh. 
(Phoenix Notification) 2013001162 {08/09/2013 15:29:15}\nPARA     - Paramedic Intercept{2}\n1545 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n WWSO requesting ALS for ETFD to meet above.  They have a 38 yoa female w/ chest pain. 
(Phoenix Notification) 2013001161 {08/09/2013 11:00:54}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 79 yoa female with chest pain and dizzy. 
(Phoenix Notification) 2013001160 {08/09/2013 10:32:29}\nPARA     - Paramedic Intercept{2}\n1701 Steeple Dr\nUnits:\n    3488    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001159 {08/09/2013 08:38:46}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 53 yoa female w/ difficulty breathing. 
(Phoenix Notification) 2013001157 {08/09/2013 04:11:49}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 cell transfer - Listed subject requesting transport as she is feeling weak and having difficulty breathing. 
(Phoenix Notification) 2013001155 {08/09/2013 01:44:45}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 cell transfer - Lisa to advise she has ringing in her ears and feels warm.  Requesting a ambo. 
(Phoenix Notification) 2013001154 {08/08/2013 22:17:41}\nAMBO     - Ambulance Request{1}\n506 S Rochester St,D\nUnits:\n    3400A   3400    \nComments:\n Life Alert/800-638-8222 req 10-52 for an 74 yoa female that has fallen - unk injuries. History of diabetes and high BP. 
(Phoenix Notification) 2013001153 {08/08/2013 16:34:56}\nAMBO     - Ambulance Request{1}\n210 McDivitt Ln\nUnits:\n    3400A   3400    \nComments:\n *911 - employee req 10-52 for a female that fell and hit her head in room #11. C&A. 
(Phoenix Notification) 2013001152 {08/08/2013 12:10:48}\nPARA     - Paramedic Intercept{2}\nUnion St/Divisoin St\nUnits:\n    CAR1    3400A   3400    \nComments:\n WWSO adv via Point to Point of an ALS request for ETFD for a 50 yoa female they have on a TS that is having cardio issues. 
(Phoenix Notification) 2013001151 {08/08/2013 11:17:06}\nAMBO     - Ambulance Request{1}\n1460 Honeywell Rd\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 - request for transport of an elderly female w/ a bladder infection. 
(Phoenix Notification) 2013001150 {08/08/2013 08:49:24}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    3400    \nComments:\n Request for a 59 yoa male dizzy w/ abnormal EKG. 
(Phoenix Notification) 2013001149 {08/08/2013 08:48:30}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\n1054 River Park Cir W,PKL\nUnits:\n    CAR1    3400A   3400    \nComments:\n Station Dispatched : {ST2} Station Dispatched : {ST1} (3) 911 calls ref dumpster fire at the above location. 
(Phoenix Notification) 2013001148 {08/08/2013 07:58:36}\nAMBO     - Ambulance Request{1}\n1460 Honeywell Rd\nUnits:\n    3400A   3400    \nComments:\n *911 - male req 10-52 for a lift assist for his wife - no injuries. 
(Phoenix Notification) 2013001147 {08/07/2013 20:57:33}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Room #5 - Staff requesting ambo for a 49 yoa male with burns to his face and hands. 
(Phoenix Notification) 2013001146 {08/07/2013 18:54:53}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,119\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* Staff adv that a resident fell and hit her head. C & B 
(Phoenix Notification) 2013001145 {08/07/2013 12:37:51}\nMUTU     - Mutual Aid{2}\n8400 CTH ES\nUnits:\n    CAR1    3400A   3400    \nComments:\n WWSO called to req ambo response to Gus's 313 Main St for pregnant customer who passed out & is still currently unconscious 
(Phoenix Notification) 2013001144 {08/07/2013 08:35:38}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    3488    CAR1    3400A   3400    \nComments:\n WCC transferred 911 caller requesting ambo as she feels she is going to collapse & she states she is having "fetal symptoms" 
(Phoenix Notification) 2013001143 {08/07/2013 06:55:00}\nAMBO     - Ambulance Request{1}\n1022 River Park Cir W,201\nUnits:\n    3400A   3400    \nComments:\n WCC *911 cell transfer 262-385-1598 - male caller req 10-52 for himself for severe back pain and pain on his right side. 
(Phoenix Notification) 2013001142 {08/07/2013 05:57:38}\nAMBO     - Ambulance Request{1}\nW326S7156 Tower Hill Ct\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC *911 cell transfer 262-844-4279 - husband req 10-52 for his wife who is disoriented. Possible stroke. 
(Phoenix Notification) 2013001141 {08/07/2013 00:37:43}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,113\nUnits:\n    3400A   3400    \nComments:\n *911 - employee request 10-52 for a lift assist in room #113 - no injuries. 
(Phoenix Notification) 2013001140 {08/06/2013 21:11:43}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n In Urgent Care for a 74 yoa female w/bee sting. 
(Phoenix Notification) 2013001139 {08/06/2013 20:37:45}\nPARA     - Paramedic Intercept{2}\nN8705 Scout Rd\nUnits:\n    CAR1    3400A   3400    \nComments:\n WWSO requesting ALS at Timberlake Camp N8705 Scout Rd for a 13 yoa stung by bee and is allergic. 
(Phoenix Notification) 2013001136 {08/06/2013 16:22:45}\nAMBO     - Ambulance Request{1}\nS76W32800 Haywagon Ct\nUnits:\n    CAR1    3400A   3400    \nComments:\n Non-emergency call requesting a lift assist for her husband who tripped and fell, did not hurt himself, but cannot get up without assistance. 
(Phoenix Notification) 2013001135 {08/06/2013 12:05:11}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    3400A   3400    \nComments:\n WCC transferred 911 cell call from below req ambo for herself for poss allergic reaction to benzodiazapene 
(Phoenix Notification) 2013001134 {08/06/2013 11:33:20}\nAMBO     - Ambulance Request{1}\n420 CTH NN E,1\nUnits:\n    3453    3488    CAR1    3400A   3400    \nComments:\n 45 req ambo to transport female non-emer for direct admit - poss change in mental status 
(Phoenix Notification) 2013001133 {08/06/2013 09:49:18}\nAMBO     - Ambulance Request{1}\nFox River Run/Red Fox Run\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC transferred 911 caller for her 5 y/o daughter who fell off her bike & has chin/facial laceration.  Caller is mother & adv they're on a bike ride & has no veh access where they are 
(Phoenix Notification) 2013001132 {08/05/2013 21:51:13}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* Female adv she is having difficultly breathing and she took her inhauler and its not helping. 
(Phoenix Notification) 2013001131 {08/05/2013 18:04:59}\nAMBO     - Ambulance Request{1}\n401 Roberts Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 ambo request for an 83yoa male w/chest pains - has heart history 
(Phoenix Notification) 2013001130 {08/05/2013 14:42:52}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\n930 N Rochester St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 2 automated calls received reporting fire alarm activated 
(Phoenix Notification) 2013001127 {08/05/2013 03:40:30}\nAMBO     - Ambulance Request{1}\n627 S Rochester St,1\nUnits:\n    CAR1    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001126 {08/04/2013 17:16:56}\nMUTU     - Mutual Aid{2}\nW3581 HWY 20\nUnits:\n    3400A   3400    \nComments:\n WWSO requesting mutual aid, ambulance, for ETFD at W3581 HWY 20. 3453 cancelled by ETFD while en route. MFD fun sheet scanned and attached to CAD entry as well as faxed to MFD. 
(Phoenix Notification) 2013001125 {08/04/2013 17:14:50}\nAPI      - Personal Injury Accident{1}\nE Wolf Run/S Rochester St\nUnits:\n    3400A   3400    \nComments:\n (14:28) 911 - caller reporting a two vehicle out of traffic - hit head on steering wheel.\nMFD run sheet scanned and attached to CAD entry as well as faxed to MFD. 
(Phoenix Notification) 2013001124 {08/04/2013 17:02:25}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    3400A   3400    \nComments:\n (14:00) Ambulance request to Urgent Care for severe nose bleed. \nRun Sheet scanned and attached to CAD number as well as faxed to MFD.\nRun A0864 & F0167 assigned. 
(Phoenix Notification) 2013001123 {08/04/2013 08:42:48}\nMUTU     - Mutual Aid{2}\n34000 High Drive\nUnits:\n    CAR1    3400A   3400    \nComments:\n RASO requesting mutual aid for a PI accident at 34000 High Drive in the Town of Waterford 
(Phoenix Notification) 2013001121 {08/04/2013 07:00:01}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 - Listed subject requesting an ambo for herself.  She advised she took lorazapam and it is shutting her respitory system. 
(Phoenix Notification) 2013001120 {08/03/2013 23:02:40}\nAMBO     - Ambulance Request{1}\nS83W32938 S Oak Tree Ct\nUnits:\n    CAR1    3400A   3400    \nComments:\n **911** for a 12 yoa male having a seizure. 
(Phoenix Notification) 2013001119 {08/03/2013 21:39:03}\nAMBO     - Ambulance Request{1}\n191 Holz Pkwy\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC **911** for her 22 yoa grandson who feels like he is going to pass out in his vehicle. 
(Phoenix Notification) 2013001118 {08/03/2013 17:49:01}\nAMBO     - Ambulance Request{1}\nS75W31462 Arbor Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC **911** transfer for 3 yoa child having a seizure. 
(Phoenix Notification) 2013001117 {08/03/2013 14:19:48}\nAMBO     - Ambulance Request{1}\n837 CTH NN E\nUnits:\n    CAR1    3400A   3400    \nComments:\n Ambo request at the Grove for an elderly female resident with acute renal failure 
(Phoenix Notification) 2013001116 {08/03/2013 12:53:06}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Ambo request in urgent care for a 62yoa female with shortness of breath and fainting spells. 
(Phoenix Notification) 2013001115 {08/03/2013 12:10:07}\nPARA     - Paramedic Intercept{2}\nZ/NN\nUnits:\n    3488    3400A   3400    \nComments:\n WCC requesting paramedic for a MC vs pole, driver not wearing a helmet. 
(Phoenix Notification) 2013001108 {08/02/2013 10:00:31}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    3400A   3400    \nComments:\n Request for a 56 yoa female that is hypertensive and experiencing memory loss. 
(Phoenix Notification) 2013001106 {08/02/2013 04:09:04}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,118\nUnits:\n    CAR1    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001105 {08/01/2013 22:35:23}\nPARA     - Paramedic Intercept{2}\n810 Sutton Dr\nUnits:\n    3400A   3400    \nComments:\n 810 Sutton Dr - WCC req paramedic for EFD to the scene for a 71 yoa female C&A with chest pain. 
(Phoenix Notification) 2013001103 {08/01/2013 13:15:58}\nAMBO     - Ambulance Request{1}\nS74W31233 Arbor Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* Elderly male which fell outside. C & Breathing. 
(Phoenix Notification) 2013001102 {07/31/2013 18:39:15}\nAMBO     - Ambulance Request{1}\n1023 Sundown Ct\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC **911** transfer call requesting ambulance for a 77 yoa female who believes she may be having a heart attack. 
(Phoenix Notification) 2013001101 {07/31/2013 16:36:44}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC **911** transfer from Lisa who advised WCC she feels like she is going to pass away in a few minutes. Lisa was not on the line at transfer. 
(Phoenix Notification) 2013001099 {07/31/2013 08:53:04}\nAPI      - Personal Injury Accident{1}\nCTH EE/Split Rail Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* WCC transferred caller who was in an accident, currently in the veh and in the ditch. Bleeding from the hands. 
(Phoenix Notification) 2013001096 {07/30/2013 09:36:31}\nAMBO     - Ambulance Request{1}\n550 Bay View Rd,BLDG\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* Male fell, cut to the back of head. 
(Phoenix Notification) 2013001095 {07/30/2013 08:54:19}\nAPDO     - Property Damage Accident{2}\nS63W27465 River Rd\nUnits:\n    CAR1    3400A   3400    \nComments:\n Caller reporting a veh crash in her yard. Driver is out and the veh is smoking. 
(Phoenix Notification) 2013001094 {07/29/2013 21:51:23}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\n728 Clarendon Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Station Dispatched : {ST2} Station Dispatched : {ST1} WCC **911** transfer reporting Horn Feeds' abandoned building is just starting on fire. 
(Phoenix Notification) 2013001093 {07/29/2013 15:39:09}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 79 yoa female with shortness of breath. 
(Phoenix Notification) 2013001092 {07/29/2013 11:32:49}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 14 yoa female having an allergic reaction.  Unable to swallow. 
(Phoenix Notification) 2013001091 {07/29/2013 11:12:09}\nMABAS    - MABAS Request for FD{1}\nW990 Pell Lake Dr\nUnits:\n    3400A   3400    \nComments:\n Mabas request above for a structure fire.  Ambo/ALS only. 
(Phoenix Notification) 2013001090 {07/28/2013 19:11:03}\nMUTU     - Mutual Aid{2}\n1111 Fox St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 3404 advises their pagers were activated for Southwest RIT to respond to Mount Everest in Vernon for Chimney fire. 3404 will advise address when available. 
(Phoenix Notification) 2013001089 {07/28/2013 09:14:50}\nAMBO     - Ambulance Request{1}\n309 Gibson St,J\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 - 64 yoa feeling weak and disoriented. 
(Phoenix Notification) 2013001086 {07/28/2013 02:08:58}\nAMBO     - Ambulance Request{1}\nW307S8579 Woodland Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001085 {07/27/2013 09:56:11}\nPARA     - Paramedic Intercept{2}\nW313S6514 Spring Dr\nUnits:\n    3400A   3400    \nComments:\n WCC calling for a paramedic to respond above for a reaction to a bee sting. 
(Phoenix Notification) 2013001084 {07/27/2013 08:41:33}\nPARA     - Paramedic Intercept{2}\nW927 Harmony Ln\nUnits:\n    CAR1    3400A   3400    \nComments:\n ETFD requesting paramedic to respond to W927 Harmony Ln for  female w/ abdominal pain and swelling to the tongue and extremeties. 
(Phoenix Notification) 2013001083 {07/26/2013 19:52:46}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 cell - below experiencing difficulty breathing. 
(Phoenix Notification) 2013001082 {07/26/2013 18:44:38}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 41 yoa male w/ abdominal pain. 
(Phoenix Notification) 2013001081 {07/26/2013 15:03:30}\nAMBO     - Ambulance Request{1}\n301 N Rochester St\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911-ambo req for teller who fell & sustained head injury - she is unable to get up due to vertigo 
(Phoenix Notification) 2013001080 {07/26/2013 12:27:30}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\nI 43/S Rochester St\nUnits:\n    3401    CAR1    3400A   3400    \nComments:\n WCC transferred 911 cell caller reporting car fire N/B 43 N/O 83 - caller adv she thinks subjs are out of veh however unsure 
(Phoenix Notification) 2013001079 {07/26/2013 12:04:22}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\n890 Main St\nUnits:\n    CAR1    3400A   3400    \nComments:\n Alarm company called in w/smoke alarm activated at above 
(Phoenix Notification) 2013001078 {07/26/2013 05:54:31}\nPARA     - Paramedic Intercept{2}\n59/Oakridge\nUnits:\n    3400    \nComments:\n 59/Oakridge - WCC calling to request paramedic intercept at above for NPFD. Female w/abdominal pain. 
(Phoenix Notification) 2013001077 {07/26/2013 02:15:49}\nAMBO     - Ambulance Request{1}\n610 Main St\nUnits:\n    3400A   3400    \nComments:\n WCC *911 cell transfer 262-378-1408 - female req 10-52 for herself who believes she is having a panic attack and possible heart attack. 
(Phoenix Notification) 2013001076 {07/25/2013 19:51:50}\nPARA     - Paramedic Intercept{2}\nS106W36653 Saddleridge Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n EFD for pain management S106W36653 Saddleridge Dr. 
(Phoenix Notification) 2013001075 {07/25/2013 15:50:56}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Ambo req for young male who has passed out in front of bldg - there is a doctor & nurse out w/him & they're requesting ambo 
(Phoenix Notification) 2013001074 {07/25/2013 14:08:32}\nAMBO     - Ambulance Request{1}\n605 W School Rd\nUnits:\n    3400A   3400    \nComments:\n \n3352 en route Athletic director requests ambo for 17 y/o by the shed behind football field (blue shed w/"M" on it for 17 y/o male w/vision loss & headache for past 20 mins w/no improvement 
(Phoenix Notification) 2013001073 {07/25/2013 14:01:15}\nAMBO     - Ambulance Request{1}\n221 McDivitt Ln\nUnits:\n    3400A   3400    \nComments:\n 911 - 41 yoa male w/ rapid heartbeat. 
(Phoenix Notification) 2013001072 {07/25/2013 13:42:03}\nAMBO     - Ambulance Request{1}\nS Rochester St/Mukwonago River\nUnits:\n    3400A   3400    \nComments:\n 1243 adv of a child that fell.  10-52 needed. 
(Phoenix Notification) 2013001071 {07/25/2013 13:14:41}\nAMBO     - Ambulance Request{1}\nW312S8965 Moccasin Trl\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911-ambo req for female poss heart attack 
(Phoenix Notification) 2013001070 {07/24/2013 19:21:40}\nAMBO     - Ambulance Request{1}\nW309S10910 CTH I\nUnits:\n    CAR1    3400A   3400    \nComments:\n Staff requesting ambo for a camp member that has a head injury. No bleeding and C & B 
(Phoenix Notification) 2013001069 {07/24/2013 14:42:49}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 ambo request in urgent care for an 82yoa female with hypotension 
(Phoenix Notification) 2013001068 {07/24/2013 08:39:34}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 ambo request in the oncology dept for a male patient with neurological changes needing to be transported 
(Phoenix Notification) 2013001067 {07/23/2013 18:40:57}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n *911* Urgent Care - Chest pain, C & A Room A7 
(Phoenix Notification) 2013001066 {07/23/2013 17:49:46}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Allergy difficulty breathing room A8 
(Phoenix Notification) 2013001064 {07/23/2013 15:41:10}\nAUNK     - Unknown Accident{2}\nI 43/Fox River\nUnits:\n    CAR1    3400A   3400    \nComments:\n  
(Phoenix Notification) 2013001063 {07/23/2013 14:06:19}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,117\nUnits:\n    CAR1    3400A   3400    \nComments:\n 911 ambo request in room 117 for a female resident that fell and is complaining of back, hip and knee pain 
(Phoenix Notification) 2013001062 {07/23/2013 04:52:19}\nAMBO     - Ambulance Request{1}\nS76W31745 Arbor Dr\nUnits:\n    CAR1    3400A   3400    \nComments:\n **911** from above address.
(Phoenix Notification) 2013001061 {07/23/2013 01:39:28}\nAMBO     - Ambulance Request{1}\n513 Baron Rd\nUnits:\n    CAR1    3400A   3400    \nComments:\n **911** requesting an ambulance for herself (43 yoa) for severe abdominal pain. 
(Phoenix Notification) 2013001060 {07/22/2013 21:29:40}\nAMBO     - Ambulance Request{1}\n820 Main St,B\nUnits:\n    CAR1    3400A   3400    \nComments:\n Officer requesting 10-52, possible diabetic. 
(Phoenix Notification) 2013001059 {07/22/2013 20:04:45}\nMABAS    - MABAS Request for FD{1}\nW329S6410 CTH E\nUnits:\n    3400A   3400    \nComments:\n WCC called to say they are upgrading the dryer fire to MABAS - No code numbers given. Dispatch toned out for an Engine, Tender and Chief. 
(Phoenix Notification) 2013001058 {07/22/2013 19:56:32}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\nW329S6410 CTH E\nUnits:\n    3462    CAR1    3400A   3400    \nComments:\n 3462 adv they were requested by North Prairie directly to respond with a tanker and 3462. 
(Phoenix Notification) 2013001057 {07/22/2013 15:17:03}\nAMBO     - Ambulance Request{1}\n240 Maple Ave\nUnits:\n    CAR1    3400A   3400    \nComments:\n Request for a 69 yoa male w/ difficulty breathing. 
(Phoenix Notification) 2013001056 {07/22/2013 06:31:57}\nAMBO     - Ambulance Request{1}\n820 Swan Dr,BLDG\nUnits:\n    CAR1    3400A   3400    \nComments:\n Wcc *911 cell transfer 414-852-4660 requesting 10-52 for a male subj feeling dizzy and shakey. History of seizures. 
(Phoenix Notification) 2013001055 {07/22/2013 00:47:39}\nFIRE     - Report of Fire/Fire Alarm Activated{1}\n920 Greenwald Ct,100\nUnits:\n    CAR1    3400A   3400    \nComments:\n 1237 adv of a small fire coming from the sign attached to building. No flames showing but smoldering plastic on the ground. Employees are evacuating. 
(Phoenix Notification) 2013001054 {07/21/2013 20:53:37}\nAMBO     - Ambulance Request{1}\n841 CTH NN E,131\nUnits:\n    CAR1    3400A   3400    \nComments:\n **911** for resident who has fallen in Room 131, no injury reported. Requesting lift assist. 
(Phoenix Notification) 2013001052 {07/21/2013 16:12:30}\nMUTU     - Mutual Aid{2}\nW344S10801 CTH E\nUnits:\n    CAR1    3400A   3400    \nComments:\n WCC requesting smoke alarm activated at W344S10801 CTH E 

*/

public class WIWaukeshaCountyBParserTest extends BaseParserTest {
  
  public WIWaukeshaCountyBParserTest() {
    setParser(new DummyParser(), "WAUKESHA COUNTY", "WI");
  }
  
  @Test
  public void testParser() {


  }
  
  
  public static void main(String[] args) {
    new WIWaukeshaCountyBParserTest().generateTests("T1");
  }
}