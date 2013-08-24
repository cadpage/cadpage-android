package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Louisville, KY
Contact: Active911
Agency name: Anchorage Fire and EMS
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: S 4TH ST/W OAK ST LVIL TYPE CODE: 12D02 SUB TYPE: default TIME: 13:37:05 Comments:  SEIZURE ProQA dispatch code: 12D02 Responder script: You are responding to a patient who has had a seizure. The patient is a 49-year-old female, who is conscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. 49-50 YOF GRN SHIRT, BLK JACKET, TAN PANTS, AT BUS STOP JUST COMING OUT OF SEIZURE, NOT ALERT 2081-1/CHESTNUT 
(IPS I/Page Notification) Location: 4320 TULIP GROVE CT LVIL TYPE CODE: 28C04X SUB TYPE: default TIME: 11:04:46 Comments:  DIZZY ProQA dispatch code: 31C02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 75-year-old male, who is conscious and breathing. Fainting episode(s) and alert => 35 (with cardiac history). Fainting episode(s) and alert => 35 (with cardiac history). -Comments: VALVE REPLACEMENT 1 YR AGO- FEELING FAINT, DIZZY, NUMBNESS IN HIS TONGUE AND LIPS KO ANCH 
(IPS I/Page Notification) Location: JUNEAU DR/SHELBYVILLE RD MTWN TYPE CODE: 31A01 SUB TYPE: default TIME: 10:05:30 Comments:  FEMALE FELL ProQA dispatch code: 31A01 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 58-year-old female, who is conscious and breathing. Fainting episode(s) and alert => 35 (without cardiac history). Fainting episode(s) and alert => 35 (without cardiac history). AT MCDONALDS ON THE SIDE IS SITTING IN HER VEH MERCEDES 
(IPS I/Page Notification) Location: 2960 GOOSE CREEK RD MHIL,D111:BROWNSBORO PARK TYPE CODE: 17A01G SUB TYPE: default TIME: 22:27:13 Comments:  FELL ProQA dispatch code: 17A01 Responder script: You are responding to a patient involved in a fall. The patient is a 94-year-old male, who is conscious and breathing. NOT DANGEROUS PROXIMAL body area (On the ground or floor). NOT DANGEROUS PROXIMAL body area (On the ground or floor). REF - 143241611 94YOM FELL ADV SOMEONE ON SITE IS GOING TO OPEN THE FRONT DOOR ADV PT IS ALLERGIC TO PENICILLAN AND HAS LIMITED MOBILITY REQ RESPONDERS TO RESET LIFELINE 
(IPS I/Page Notification) Location: 901 BLANKENBAKER PKY MTWN,1113: @HORIZON BAY NURSING HOME TYPE CODE: 10C02 SUB TYPE: default TIME: 21:14:05 Comments:  ProQA dispatch code: 10C02 Responder script: You are responding to a patient with chest pain. The patient is a 85-year-old female, who is conscious and breathing. Heart attack or angina history. -Comments: REG MEDS- 85 YO F CHEST PAIN 
(IPS I/Page Notification) Location: 3001 CHAMBERLAIN LN LVIL: @FORD TRUCK PLANT - CHAMBERLAIN TYPE CODE: 33C06T SUB TYPE: default TIME: 19:20:51 Comments:  ProQA dispatch code: 33C06 Responder script: You are responding to a patient transfer or medical care facility situation. The patient is a 54-year-old male, who is conscious and breathing. Emergency response requested (Transfer). ENTER AT GATE 2 , PT IS AT THE MEDICAL DEPT PT PASSED OUT, HAVING BLOOD PRESSURE PROBLEM 
(IPS I/Page Notification) Location: 14620 AIKEN RD LVIL: LAKE FOREST GOLD CLUB, MAINTENANCE TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 17:17:10 Comments:  GEN FIRE ** Case number 9913000386 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000119 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 3407 ASCOT CIR MCRE TYPE CODE: 10D04 SUB TYPE: default TIME: 14:58:37 Comments:  CHEST PAIN ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 81-year-old female, who is conscious and breathing. Clammy. 
(IPS I/Page Notification) Location: 10480 SHELBYVILLE RD BRM:FRESH MARKET TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:50:50 Comments:  GENERAL ALARM NTFY ** Case number 9913000382 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000118 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 1001 GLENRIDGE DR LYND,212 TYPE CODE: 10D04 SUB TYPE: default TIME: 12:40:18 Comments:  ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy. ** Case number 1613000386 has been assigned for 16:CNTY ** >>>> by: PATRICIA PUENTE on terminal: 911ms20 

Contact: Active911
Agency name: Okolona Fire
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 3142 CHINQUAPIN LN LVIL TYPE CODE: FIRE SUB TYPE: CLOSE_TO_STRUCT TIME: 13:19:53 Comments:  DUMPSTER ON FIRE CALLER ADV CLOSE TO STRUCTURE TWIN OAKS APT ** Case number 8013000491 has been assigned for 80:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 5013000143 has been assigned for 50:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 FIRE 6 
(IPS I/Page Notification) Location: 9110 COVENTRY LN LVIL TYPE CODE: LOCK_OUT/IN SUB TYPE: CHILD_IN_CAR TIME: 11:43:53 Comments:  2YO LOCKED IN 2003 FORD GRAY TAURUS NOT RUNNING ** Case number 8013000490 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 4801 COMMERCE CROSSINGS DR LVIL,10 TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:19:30 Comments:  HAGEMEYER NORTH AMERICA WEST SIDE NTFY ** Case number 8013000489 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 4611 BITTERSWEET RD LVIL;H:DRENAN EQUIPMENT COMPANY TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:08 Comments:  SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD ** Case number 5013000140 has been assigned for 50:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 8013000488 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 3713000227 has been assigned for 37:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 5001 ROSETTE BLVD LVIL TYPE CODE: ALARM SUB TYPE: RESIDENTIAL TIME: 19:57:15 Comments:  DRAIN RESD HALLWAY HEAT AND SMOKE WILL NTFY ** Case number 8013000487 has been assigned for 80:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 ** Case number 5013000139 has been assigned for 50:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 FIRE 6 
(IPS I/Page Notification) Location: 3702 FALCON CREST DR LVIL,104 TYPE CODE: FIRE SUB TYPE: FOOD_ON_STOVE TIME: 19:40:24 Comments:  SKILLET WAS BURNING, IS OUT NOW, APT FULL OF SMOKE 1 SUBJ IN THE APT ** Case number 8013000486 has been assigned for 80:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ** Case number 9013000206 has been assigned for 90:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: SHEPHERDSVILLE RD/POPLAR LEVEL RD LVIL:TURNING LANE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:35:40 Comments:  MALE DOWN ProQA dispatch code: 32B03 Responder script: You are responding to a patient with an unknown problem (man down). The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. -Comments: TURNING LN ON SHEP- CALLER 3PC...TARC DRIVER STATED WHI CAR IN TURNING LN, MALE SLUMPED OVER 123-OL/NOLT YOUNG MALE UNCON UNRESPONSIVE, HR UNK IF BREATHING 733A ROLLED UP ON EMS COMING CODE 3 PD ALSO REQ FIRE ** Case number 8013000485 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 9215 PRESTON HWY LVIL TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 15:39:56 Comments:  Traffic / Transportation Incidents ProQA dispatch code: 29B01 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 56-year-old female, who is conscious and breathing. Injuries. 2.Chemicals or other hazards are not involved. BLK CADILLAC AND A TAN NISSAN 272- 274-65/ARTHER CX EMS PER 763, REQ FIRE FOR MITIGATION OF DEBRIS AND FLUID EMS OK ON CX ** Case number 8013000484 has been assigned for 80:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 
(IPS I/Page Notification) Location: PRESTON HWY/MOUNT WASHINGTON RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:55:39 Comments:  IN FRONT OF WALMART ON PRESTON HWY 529 (LMPD) ON SCENE WILL ADV FURTHER ** Case number 8013000483 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 6301 GEIL LN LVIL:KENTUCKY CONTAINER SERVICES TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:34:26 Comments:  1ST FLOOR OFFICE SMOKE DETECTOR NTFY ** Case number 8013000482 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 5013000138 has been assigned for 50:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 

Contact: Active911
Agency name: Buechel Fire Protection District
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 4611 BITTERSWEET RD LVIL;H:DRENAN EQUIPMENT COMPANY TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:08 Comments:  SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD ** Case number 5013000140 has been assigned for 50:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 8013000488 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 3713000227 has been assigned for 37:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 5000 BARDSTOWN RD LVIL:WILDWOOD COUNTRY CLUB TYPE CODE: FIRE SUB TYPE: ELEC_ODOR_INSIDE TIME: 17:05:17 Comments:  SMELLS SOMETHING BURNING INSIDE THE DINING ROOM ** Case number 3713000226 has been assigned for 37:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 7113000197 has been assigned for 71:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 2819 RIO RITA AVE LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:47:48 Comments:  poss stroke ProQA dispatch code: 28C01 Responder script: You are responding to a patient who has apparently suffered a stroke. The patient is a 85-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Not alert (Less than ___ hours since the symptoms started). -Comments: soeech- -Comments: 30 mins- 85 Y/O FEMALE, POSS STROKE, DLOC, SLURRED SPEECH, HX OF STROKE 127-BARD/BUECHEL LOU FIRE ON WORKING FIRE IN THE 4TH ** Alternate Dispatch Group CNTY used for 37/CNTY in event creation CAD SEL/REC IS BUECHEL, LFD CHIEF 5 OKAY ** Case number 3713000225 has been assigned for 37:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: BRECKENRIDGE LN/NACHAND LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 08:20:27 Comments:  ProQA dispatch code: 12D02 Responder script: You are responding to a patient who has had a seizure. The patient is a male of unknown age, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. UNK AGE MALE IN MAR MAZADA HAVING SZ HIT TREE SENDING FIRE VEH IS SMOKING PT IS STILL IN VEH ** Case number 3713000224 has been assigned for 37:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4201 ST FRANCIS LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 05:14:50 Comments:  ProQA dispatch code: 13C01 Responder script: You are responding to a patient with diabetic problems. The patient is a 64-year-old male, who is conscious and breathing. Not alert (Combative or Aggressive). Not alert (Combative or Aggressive). VERY COMBATIVE LARGE M FIGHTING HIS ELDERLY MOTHER SHE IS WATCHING PT, DOOR IS OPEN, SHE ADV HAVE RESPONDERS COME IN 1086 FOR EMS PD REQS FIRE CODE 3 ** Case number 3713000223 has been assigned for 37:CNTY ** >>>> by: EDITH HIGGINS on terminal: 911ms20 
(IPS I/Page Notification) Location: 4342 NEWPORT RD LVIL,1 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 04:24:49 Comments:  ProQA dispatch code: 09E02 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 21-year-old female, who is unconscious and whose breathing is uncertain. Breathing uncertain (AGONAL). ** Case number 3713000222 has been assigned for 37:CNTY ** >>>> by: ROBIN LEWIS on terminal: 911ms21 127@BFD 
(IPS I/Page Notification) Location: 3806 GREENWICH WAY LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 17:41:04 Comments:  ProQA dispatch code: 09E01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and not breathing. Not breathing at all. ** Case number 3713000221 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: BARDSTOWN RD/HIKES LN LVIL TYPE CODE: FIRE SUB TYPE: AUTOMOBILE TIME: 15:48:06 Comments:  DRK GRY NISSAN ALTIMA VS TREE TONES CAR WAS SMOKING COPYING FIRE ** Case number 5013000137 has been assigned for 50:CNTY ** >>>> by: JENNIFER THOMPSON on terminal: 911ms28 FIRE5 ** Case number 3713000220 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 2100 BASHFORD MANOR LN WB:LOWE'S TYPE CODE: GAS_LEAK SUB TYPE: INSIDE TIME: 15:27:39 Comments:  @INSIDE REAR OF STORE, SMELLING GAS, NO SEEN SMOKE/FIRE ** Case number 3713000219 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 5013000136 has been assigned for 50:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 5329 RANGELAND RD LVIL,1 TYPE CODE: ACCIDENT SUB TYPE: VS_STRUCTURE TIME: 04:19:47 Comments:  APPEARS UNK VEH STRUCK WALL OF BLDG, THEN LEFT CALLER FOUND LARGE HOLE IN HIS WALL & DOOR IS GONE CAN'T SEE A VEH ANY LONGER HAVE PD VERI THIS IS THE CASE ADV IF FD IS NEEDED FOR STRUCTURE CK REQ FIRE TO CHECK BLDG THERE DOES APPEAR TO BE SOE STRUCTURAL DAMAGE ** Case number 8013000475 has been assigned for 80:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ** Case number 5013000133 has been assigned for 50:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ** Case number 3713000218 has been assigned for 37:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 

Contact: Active911
Agency name: Middletown Fire Protection District
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 10503 TIMBERWOOD CIR JTN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:07:10 Comments:  NTS PLAINVIEW 3..GENERAL FIRE ALARM.. ** Case number 9913000389 has been assigned for 99:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 3313000508 has been assigned for 33:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 
(IPS I/Page Notification) Location: 12206 HARDWICK RD WDHI TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 22:51:07 Comments:  ProQA dispatch code: 13D01 Responder script: You are responding to a patient with diabetic problems. The patient is a 47-year-old male, who is unconscious and breathing. Unconscious. 112A 60/URTON ** Case number 9913000388 has been assigned for 99:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms27 
(IPS I/Page Notification) Location: 9802 VIEUX CARRE DR LVIL,2 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 21:54:28 Comments:  NOT CONSC/BREATHIN ProQA dispatch code: 09E01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 25-year-old female, who is unconscious and not breathing. Not breathing at all. 25YO F NOT CONSC/BREATH LANG BARRIER ** Case number 9913000387 has been assigned for 99:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms27 
(IPS I/Page Notification) Location: 14620 AIKEN RD LVIL: LAKE FOREST GOLD CLUB, MAINTENANCE TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 17:17:10 Comments:  GEN FIRE ** Case number 9913000386 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000119 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 NOT GETTING ANY OTHER CALLS ON THIS 272A-MCMAHAN 2ND CALL OF THIS NATURE THIS DATE - UNFOUNDED EARLIER Duplicate Event: : @I64E TO BLANKENBAKER PKY N, Type = 29B01 MEDICAL 1050 MVA (INJURIES) MEDICAL INJURY ACCIDENT, Subtype = default MED_CALL default Med Call, Caller Name = KELLY MITCHELL, Caller Ph Number = (502) 876-4530, Call Source = 2-Phone, Alarm Level = 1 SPECIAL ADDRESS COMMENT: End of Duplicate Event data I64E TO BLANKENBAKER PKY N P/U OVERTURNED UNABLE TO GET OUT OF VEH FEMALE SAID SHE IS UNABLE TO MOVE FEM PT ARM INJURY, CONSCIOUS AND ALERT YEMS ENRT 
(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 641 S HURSTBOURNE PKY JTN:GORDON FOOD SERVICE MARKETPLACE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:39:44 Comments:  YEMS REQ FIRE FOR 54 YOM W/CP PT IN THE FRONT OF THE STORE ** Case number 9913000384 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: FACTORY LN/LA GRANGE RD LVIL TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 15:42:13 Comments:  BETWEE THORTON'S AND BANK OF OLDHAM CO., THE TURNING LANE IS VERY SLICK, POSS OIL ON ROAD VEHS SLIDING ** Case number 9913000383 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 10480 SHELBYVILLE RD BRM:FRESH MARKET TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:50:50 Comments:  GENERAL ALARM NTFY ** Case number 9913000382 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000118 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY IN JTN TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:36:15 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN JTN VEHICLE OVERTURNED OCCUPANT OUT OF THE VEHICLE WALKING AROUND 2ND VEHICLE IS ON THE EXIT ** Case number 9913000381 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 

Contact: Active911
Agency name: McMahan Fire Department
Location: Lousiville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: S HURSTBOURNE PKY/HURSTBOURNE LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:07:36 Comments:  X736D ROLLED UP ON 3 VEHS, AIRBAGS DEPLOYED ** Case number 5513000238 has been assigned for 55:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: 7902 KINGMAN WAY LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 17:24:06 Comments:  ProQA dispatch code: 17B03 Responder script: You are responding to a patient involved in a fall. The patient is a 69-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Unknown status/Other codes not applicable (On the ground or floor). REF 143237424 272A MCMAHAN NORMA FLETCHER502-493-4642 MED INFO :HIP FRACTURE NO KEY INFO COPYING FIRE FOR POSS FORCED ENTRY ** Case number 5513000237 has been assigned for 55:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 2811 BROWNS LN SRPK TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:25:04 Comments:  soa ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000236 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 62 Y/O MALE, SOA FIRE 5 FLUSHED 255BRECK DUTCH 
(IPS I/Page Notification) Location: 2811 BROWNS LN SRPK TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:25:04 Comments:  soa ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000236 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 9902 TAYLORSVILLE RD JTN:PUPPY LOVE PET RESORT TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 10:59:53 Comments:  POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B ** Case number 3313000503 has been assigned for 33:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000235 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7113000195 has been assigned for 71:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:51:52 Comments:  897-8100, WILL NTFY FIRE ALARM FROM DAYCARE ** Case number 2613000258 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000234 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:18:04 Comments:  DAYCARE NTFY LIC 114 ** Case number 2613000257 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000233 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4620 TAYLORSVILLE RD JTN:LA FITNESS ON TAYLORSVILLE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:30:44 Comments:  ProQA dispatch code: 10D02 Responder script: You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000232 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 FIRE 5 YELLOW OK 
(IPS I/Page Notification) Location: 4620 TAYLORSVILLE RD JTN:LA FITNESS ON TAYLORSVILLE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:30:44 Comments:  ProQA dispatch code: 10D02 Responder script: You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000232 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 3410 BRECKENRIDGE LN LVIL,2 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 21:52:39 Comments:  SOA ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. Reconfigured dispatch code: 06D02 Responder script: SPEAKING BETWEEN BREATHS (Asthma). DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). ** Case number 5513000231 has been assigned for 55:CNTY ** >>>> by: ROBIN LEWIS on terminal: 911ms21 Chief complaint code of last reconfigure: 6 FIRE5 161@ BRECK/TAYLORSVILLE 

Contact: Active911
Agency name: Lyndon Fire Department
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 9505 WILLIAMSBURG PLZ HURS:BUSN BLDG TYPE CODE: WATER_LEAK SUB TYPE: INSIDE TIME: 00:43:56 Comments:  ADV LRG STREAM OF WATER SHOOTING OUT FROM THE VINYL SIDING POS WATER LEAK INSIDE THE BLDG ** Case number 1613000390 has been assigned for 16:CNTY ** >>>> by: COLLEEN KATS on terminal: 911ms28 ADV THERE IS NO INFO ON THE DOORS AS FAR AS WHO TO CONTACT 
(IPS I/Page Notification) Location: 3500 SPRINGHURST COMMONS DR LVIL:@MARRIOTT TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 18:50:59 Comments:  ZONE E113, WATERFLOW PREM# 412-1311 NOTI ** Case number 1613000389 has been assigned for 16:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ** Case number 1813000216 has been assigned for 18:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: 10007 WHIPPS MILL RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:41:53 Comments:  ProQA dispatch code: 32B02 Responder script: You are responding to a patient with an unknown problem (man down). The patient is of unknown age and gender, whose consciousness and breathing is unknown. Medical Alarm (Alert) notifications (no patient information). REC MEDICAL ALARM FROM PENDANT 502-333-0208 CAROLYN FISHER NO KEY INFO, NA ON PHONE, COPYING FIRE FOR POSS FORCED ENTRY Duplicate Event:Location = 10007 WHIPPS MILL RD LVIL, Cross Street 1 = LA GRANGE RD, Cross Street 2 = KEENELAND BLVD, Type = 1032 TROUBLE, Subtype = 911 911 HANG UP, Caller Name = CAROLYN FISCHER, Caller Ph Number = (502) 333-0208, Caller Address = 10007 WHIPPS MILL RD LOUISVILLE, Call Source = ANI/ALI, Alarm Level = 1 End of Duplicate Event data FROM RESD VM ON CV CORR CB ** Case number 1613000388 has been assigned for 16:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: 1801 LYNN WAY GMOR: @JEFFERSON MANOR NURSING HOME TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 12:40:55 Comments:  502-426-4513, GENERAL FIRE ALARM, NTFY ** Case number 1613000387 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 2613000259 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 1001 GLENRIDGE DR LYND,212 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 12:40:18 Comments:  ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy. ** Case number 1613000386 has been assigned for 16:CNTY ** >>>> by: PATRICIA PUENTE on terminal: 911ms20 
(IPS I/Page Notification) Location: NEW LA GRANGE RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:31:09 Comments:  WHITE CAR VS BLK SUV 758-1610 ADV NEED EMS - STARTING EMS ProQA dispatch code: 29B04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 30-year-old male, who is conscious and breathing. Unknown status/Other codes not applicable. Unknown status/Other codes not applicable. 2.Chemicals or other hazards are not involved. 111/ST MATH 30YO MALE ASKED PM TO CALL EMS DUE TO AIRBAG DEPLOYING ** Case number 1613000385 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 120 BLAINE RD BELM TYPE CODE: FIRE SUB TYPE: RESIDENTIAL TIME: 18:34:00 Comments:  ** Case number 1613000384 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 9604 SOMERFORD CT MEDV TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:16:23 Comments:  ProQA dispatch code: 09D01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and whose breathing is unknown. INEFFECTIVE BREATHING. 1.The cardiac arrest was witnessed. ADV HAS DEFIB IN CHEST 119...MT3 PT UNCON, UNSURE IF BREATHING ** Case number 1613000383 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 9300BLK WHIPPS MILL RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:19:07 Comments:  @THE LYNDON BALL PARK 80YOF, FAINTED, UNCON PT IS BREATHING HE SAID THEY ARE IN THE 2ND LOT BACK, NEAR THE BALL FIELD ** Case number 1613000382 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 3500 SPRINGHURST COMMONS DR LVIL:MARRIOT RESIDENCE INN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 09:59:53 Comments:  502-412-1311, WILL NTFY SMOKE ALARM ** Case number 1613000381 has been assigned for 16:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms20 ** Case number 1813000213 has been assigned for 18:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms20 

Contact: Active911
Agency name: St. Matthews Fire Protection District
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 1801 LYNN WAY GMOR: @JEFFERSON MANOR NURSING HOME TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 12:40:55 Comments:  502-426-4513, GENERAL FIRE ALARM, NTFY ** Case number 1613000387 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 2613000259 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:51:52 Comments:  897-8100, WILL NTFY FIRE ALARM FROM DAYCARE ** Case number 2613000258 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000234 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:18:04 Comments:  DAYCARE NTFY LIC 114 ** Case number 2613000257 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000233 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 992 BRECKENRIDGE LN STM: BOOKS A MILLION TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 22:42:22 Comments:  ProQA dispatch code: 31D02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 40-year-old female, who is unconscious and breathing. Unconscious -- Effective breathing. ** Case number 2613000255 has been assigned for 26:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 
(IPS I/Page Notification) Location: 958 MALLARD CREEK RD STM TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 06:18:42 Comments:  OVERDOSE ProQA dispatch code: 23D01 Responder script: You are responding to a patient who has apparently overdosed/been poisoned. The patient is a 44-year-old female, who is unconscious and breathing. Unconscious (Intentional Overdose). 1.This was intentional. ALT# 502-510-3352 -085.631645 +38.233601 ** Case number 2613000253 has been assigned for 26:CNTY ** >>>> by: JOHN WEIBLE on terminal: 911ms21 
(IPS I/Page Notification) Location: 3921 SHELBYVILLE RD STM:TINROOF TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 01:52:17 Comments:  THROUGH BUILDING X 3 ** Case number 2613000252 has been assigned for 26:CNTY ** >>>> by: TARI BROOKS on terminal: 911ms21 
(IPS I/Page Notification) Location: 5000 SHELBYVILLE RD STM: @MALL ST MATTHEWS TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:13:48 Comments:  IN THE LOBBY AREA UNCONS ProQA dispatch code: 31D02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a female of unknown age, who is unconscious and whose breathing is unknown. Unconscious -- Effective breathing. E111...60/THIE Chief complaint code of last reconfigure: 31 UNCONS NOW CONS Reconfigured dispatch code: 31D03 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 0-month-old female, who is unconscious and whose breathing is unknown. Not alert. 3RD PARTY CALL ** Case number 2613000251 has been assigned for 26:CNTY ** >>>> by: MELISSA HARLEY on terminal: 911ms28 
(IPS I/Page Notification) Location: 1615 MILITARY AVE LYND TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 20:12:57 Comments:  COMP SEES SMOKE COMING FROM BUILDING BEHIND CHILDRENS HOME ** Case number 1613000378 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 9913000358 has been assigned for 99:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2013000111 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2613000250 has been assigned for 26:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 100 MALLARD CREEK RD STM:LAKE VIEW TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 15:51:27 Comments:  WATER FLOW, 502-326-1166, NTFY ** Case number 2613000248 has been assigned for 26:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 5513000223 has been assigned for 55:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 400 MALLARD CREEK RD STM:MALLARD CROSSING LEASING OFFICES TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:14:54 Comments:  SMOKE DET, RECREATION AREA NTFY ** Case number 2613000247 has been assigned for 26:CNTY ** >>>> by: TRENTON ALDRIDGE on terminal: 911ms27 ** Case number 1613000367 has been assigned for 16:CNTY ** >>>> by: TRENTON ALDRIDGE on terminal: 911ms27 

Contact: Active911
Agency name: Jeffersontown Fire
Location: Jeffersontown, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 11405 BLUEGRASS PKY JTN: ADP TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 13:48:19 Comments:  55-60YO F UNK PROBLEM YELLOW OK ** Case number 3313000511 has been assigned for 33:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 9207 PINE LAKE DR JTN,201 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 13:32:56 Comments:  YELLOW REQ FIRE FOR 15MONTH OLD THAT SWOLLEN SCREW ** Case number 3313000510 has been assigned for 33:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 8306 SUNNY RIDGE CT LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:02:35 Comments:  ProQA dispatch code: 17D03 Responder script: You are responding to a patient involved in a fall. The patient is a 54-year-old male, who is conscious and breathing. Not alert. 54YOM FELL NOT ALERT INJURED BACK ** Case number 3313000509 has been assigned for 33:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 
(IPS I/Page Notification) Location: 10503 TIMBERWOOD CIR JTN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:07:10 Comments:  NTS PLAINVIEW 3..GENERAL FIRE ALARM.. ** Case number 9913000389 has been assigned for 99:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 3313000508 has been assigned for 33:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 
(IPS I/Page Notification) Location: S HURSTBOURNE PKY/SIX MILE LN LVIL:S OF LOC TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 22:09:03 Comments:  REF EMS ADV FUEL LEAKING BLK CIVIC VS WHT GALANT COPYING FIRE FIRE FIVE ** Case number 3313000507 has been assigned for 33:CNTY ** >>>> by: COLLEEN KATS on terminal: 911ms28 
(IPS I/Page Notification) Location: 8714 LANTERN LITE PKY JTN TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:57:19 Comments:  31 YO F SOA CHEST PAIN YLW EMS OK HX OF STROKE FIRE CODE 3 ** Case number 3313000506 has been assigned for 33:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: 6415 CALM RIVER WAY LVIL:GLENRIDGE HEALTH CAMPUS TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 19:20:03 Comments:  GENERAL FIRE NTFY ** Case number 3313000505 has been assigned for 33:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 
(IPS I/Page Notification) Location: 9902 TAYLORSVILLE RD JTN:PUPPY LOVE PET RESORT TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 10:59:53 Comments:  POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B ** Case number 3313000503 has been assigned for 33:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000235 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7113000195 has been assigned for 71:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 11500 FALLING BROOK DR LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:35:16 Comments:  ProQA dispatch code: 10D01 Responder script: You are responding to a patient with chest pain. The patient is a 77-year-old female, who is conscious and breathing. Not alert. DELAY MULT RUNS TO DISPATCH ** Case number 3313000502 has been assigned for 33:CNTY ** >>>> by: LORI BAKER on terminal: 911ms20 

Contact: Active911
Agency name: Eastwood Fire District
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 15405 BECKLEY HILLS DR LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 19:04:20 Comments:  ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 47-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. HX KIDNEY FAILURE ** Case number 7713000103 has been assigned for 77:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 
(IPS I/Page Notification) Location: @I265N AT LA GRANGE RD TYPE CODE: ACCIDENT SUB TYPE: RESCUE TIME: 06:25:21 Comments:  SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD ProQA dispatch code: 29D04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK ** Case number 9913000376 has been assigned for 99:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7713000102 has been assigned for 77:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 112A/MT1 
(IPS I/Page Notification) Location: @I265N AT LA GRANGE RD TYPE CODE: ACCIDENT SUB TYPE: RESCUE TIME: 06:25:21 Comments:  SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD ProQA dispatch code: 29D04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK ** Case number 9913000376 has been assigned for 99:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7713000102 has been assigned for 77:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 1309 FLAT ROCK RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:23:32 Comments:  HEART PROBLEMS ProQA dispatch code: 32B03 Responder script: You are responding to a patient with an unknown problem (man down). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. DOES LMPD NEED TO MAKE THE HEART PROBLEMS/ ELDERLY FEMALE HEART PROBLEMS CHIEF DAVENPORT ADV SEND FIRE WAS VERY COOPERATIVE IN ANSWERING QUESTIONS ** Case number 7713000101 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: @24 I64W TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:08:10 Comments:  SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT ** Case number 7713000100 has been assigned for 77:CNTY ** >>>> by: ANITA BILYEU on terminal: 911ms27 
(IPS I/Page Notification) Location: @24 I64W TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:08:10 Comments:  SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT ** Case number 7713000100 has been assigned for 77:CNTY ** >>>> by: ANITA BILYEU on terminal: 911ms27 
(IPS I/Page Notification) Location: 3306 PROTEGE PL LVIL TYPE CODE: FIRE SUB TYPE: FIELD/GRASS/BRSH TIME: 21:03:29 Comments:  CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT ** Case number 2013000113 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000099 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 FIRE 5 
(IPS I/Page Notification) Location: 3306 PROTEGE PL LVIL TYPE CODE: FIRE SUB TYPE: FIELD/GRASS/BRSH TIME: 21:03:29 Comments:  CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT ** Case number 2013000113 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000099 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 1202 ISLEWORTH DR LVIL TYPE CODE: FIRE SUB TYPE: RESIDENTIAL TIME: 20:09:31 Comments:  FLAMES COMING FROM BACK OF HOUSE COMP IS NEIGHBOR BEHIND HIM, ADV NO ONE IS HOME NOW ** Case number 9913000364 has been assigned for 99:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2013000112 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000098 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 16412 TAUNTON VALE RD LVIL TYPE CODE: ALARM SUB TYPE: RESIDENTIAL TIME: 19:34:09 Comments:  KEYPAD FIRE PANIC ** Case number 7713000097 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 9913000361 has been assigned for 99:CNTY PREM NM EDDIE AND ANGIE ESCAMILLA, PREM PH 832-563-3070 ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: FLAT ROCK RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:13:35 Comments:  ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s). ** Case number 7713000096 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 Duplicate Event:Location = 503 FLAT ROCK RD LVIL, Cross Street 1 = GLEN LAKES VEH VS POLE DR, Cross Street 2 = TURTLE CREEK TRL, Type = 1049 NON INJ ACCI, Subtype = default, Caller Name = MRS HANLON, Caller Ph Number = (502) 245-9571, Caller IN FRONT OF LOC Address = 503 FLAT ROCK RD LOUISVILLE, Call Source = ANI/ALI, Alarm Level = 1 WHITE PU End of Duplicate Event data FIRE 5 119A MID 3 SINGLE VEH ROLLOVER, PT OUT AND WALKING AROUND BLOODY NOSE 
(IPS I/Page Notification) Location: FLAT ROCK RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:13:35 Comments:  ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s). ** Case number 7713000096 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 
(IPS I/Page Notification) Location: 100 HUNTINGTON RIDGE DR MTWN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:03 Comments:  GOODWILL 489-8344, GENERAL, WILL NTFY, PERMIT--NONE, REF--0838090 ** Case number 9913000354 has been assigned for 99:CNTY ** >>>> by: STEPHANIE ASHBY on terminal: 911ms21 ** Case number 7713000095 has been assigned for 77:CNTY ** >>>> by: STEPHANIE ASHBY on terminal: 911ms21 
(IPS I/Page Notification) Location: 100 HUNTINGTON RIDGE DR MTWN: GOODWILL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 04:48:21 Comments:  502-489-8344, GENERAL FIRE, NTFY ** Case number 9913000352 has been assigned for 99:CNTY ** >>>> by: TRAVIS BROWN on terminal: 911ms21 ** Case number 7713000094 has been assigned for 77:CNTY ** >>>> by: TRAVIS BROWN on terminal: 911ms21 
(IPS I/Page Notification) Location: 2405 CRYSTAL SPRINGS PL LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 02:28:37 Comments:  SOA ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 65-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. 65 Y/O FEMALE, SOA ** Case number 7713000093 has been assigned for 77:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms21 

Contact: Active911
Agency name: Prospect Police
Location: Prospect, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 9200 U S HIGHWAY 42 PRO: @PROSPECT POLICE DEPARTMENT TYPE CODE: SC1021 SUB TYPE: default TIME: 22:23:48 
(IPS I/Page Notification) Location: 6410 DEEP CREEK DR PRO TYPE CODE: SC1041 SUB TYPE: default TIME: 21:03:57 Comments:  SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK 
(IPS I/Page Notification) Location: 6410 DEEP CREEK DR PRO TYPE CODE: SC1041 SUB TYPE: default TIME: 21:03:57 Comments:  SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK 
(IPS I/Page Notification) Location: @CAL TYPE CODE: SC1021 SUB TYPE: default TIME: 16:32:09 Comments:  HAS QUESTIONS ABOUT REPORT SHE FILED AGAINST HER HUSBAND 
(IPS I/Page Notification) Location: 7206 COVERED BRIDGE RD PRO TYPE CODE: SC1021 SUB TYPE: default TIME: 16:06:49 Comments:  IRT REPORT OF VEH HITTING HIS HOUSE ON 12/15 
(IPS I/Page Notification) Location: @CAL:WYTHE HILL CIR TYPE CODE: SC1036 SUB TYPE: VEHICLE TIME: 14:31:16 
(IPS I/Page Notification) Location: PINE KNOLL CIR/FOX MEADOW WAY PRO TYPE CODE: SC1054 SUB TYPE: default TIME: 11:51:02 Comments:  CHOC LAB ROAMING AROUND NO TAGS 
(IPS I/Page Notification) Location: 5609 TIMBER RIDGE DR PRO TYPE CODE: SC1037 SUB TYPE: default TIME: 11:46:12 Comments:  VIA 911 ACTIVE FIGHT 2 MALES A FEM IRT A DOG BITING A SUBJ NO WEAPONS 
(IPS I/Page Notification) Location: 4002 HARRODS LANDING DR PRO TYPE CODE: SC1035 SUB TYPE: AUDIBLE TIME: 05:21:08 Comments:  DOWNSTAIRS WINDOWS ATTEMPTED TO CONTACT NO ANSWER 
(IPS I/Page Notification) Location: 6508 GUNPOWDER LN PRO TYPE CODE: SC1033 SUB TYPE: default TIME: 03:02:47 Comments:  COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN 

Contact: Active911
Agency name: Graymoor-Devondale Police Department
Location: Louisville, KY, United States
Sender: MetroSafeTech <MetroSafeTech@louisvilleky.gov>

(IPS I/Page Notification) Location: 114 WOOD RD LYND TYPE CODE: SC1036 SUB TYPE: VEHICLE TIME: 12:09:13 Comments:  COMLP ADV WHT CARGO VAN WITH DRK TINTED WINDOWS DRIVING AROUND NEIGHBORHOOD SLOWING DOWN LOOKING AT HOUSES COMPL REQ OFC TO RIDE THRU AREA NO 1042 
(IPS I/Page Notification) Location: 1500 LYNN WAY GMOR: @GRAYMOOR POLICE DEPARTMENT TYPE CODE: SC1021 SUB TYPE: default TIME: 09:46:41 Comments:  IN REF TO SOME POSS GUNSHOTS FIRED LAST NIGHT 
(IPS I/Page Notification) Location: BROWNSBORO RD/N HUBBARDS LN WHIL TYPE CODE: SC1048 SUB TYPE: default TIME: 09:35:47 Comments:  LINCOLN NAVIGATOR 
(IPS I/Page Notification) Location: 1918 BUTTONWOOD RD GMOR TYPE CODE: SC1021 SUB TYPE: default TIME: 08:36:13 Comments:  IN REF TO SOME PARKING PERMITS FOR THE STREET 
(IPS I/Page Notification) Location: 1504 APPLEWOOD LN GMOR TYPE CODE: SC1036 SUB TYPE: PERSON TIME: 18:09:19 Comments:  BETWEEN OXTED/WESTPORT RD WM LONG WHT HAIR HOLDING A CROBAR UNK IF WENT DOWN OXTED OR STAYED ON OXTED WEARING ALL BLK 
(IPS I/Page Notification) Location: 6508 GUNPOWDER LN PRO TYPE CODE: SC1033 SUB TYPE: default TIME: 03:06:40 Comments:  COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN ANOTHER SON IN UPSTAIRS BEDROOM NUMBER 403-7201 NUMBER IS FOR SON MOTHER IS ON HER WAY TO LOCATION IN A BUICK STATION WAGON 5 MIN ETA 
(IPS I/Page Notification) Location: 10003 WHIPPS MILL RD LVIL TYPE CODE: SC1032 SUB TYPE: CIT TIME: 02:01:44 Comments:  HER FRIEND;S HUSBAND IS THREATENING SUICIDE- IS ARMED W. A KNIFE - FRIEND IS TEXTING THIS INFO HUSBAND IS 28 YOA WM, INTOX ON RX MEDS, JARRED RIFFE, - WIFE NAME IS JESSICA - SHE AT LOC W/ HER HUSBAND SUSP HAS HX OF MENTAL ILLNESS- DEPRESSION AND ANXIETY- THERE ARE 2 CHILDREN INSIDE THE HOME- JESSICA'S CB IS 439-7152 F JUST TEXTED COMPL SHE WAS AFRAID TO LEAVE THE ROOM TO OPEN DOOR F ADVS THE SIDE DOOR IS UNLOCK- IT IS LOCATED OFF THE DRIVEWAY GM112 
(IPS I/Page Notification) Location: 7508 WESTDALE RD GMOR TYPE CODE: SC1054 SUB TYPE: default TIME: 21:33:16 Comments:  COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA 
(IPS I/Page Notification) Location: 12609 TAYLORSVILLE RD LVIL:PNC BANK TYPE CODE: SC1034 SUB TYPE: ALARM TIME: 21:43:05 Comments:  DURESS SILENT ON OPEN NTFY PER# - 53262 P4 PD3 TCIS / ROBBERY 941 OK 
(IPS I/Page Notification) Location: 7508 WESTDALE RD GMOR TYPE CODE: SC1054 SUB TYPE: default TIME: 21:33:16 Comments:  COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA 

 */


public class KYLouisvilleParserTest extends BaseParserTest {
  
  public KYLouisvilleParserTest() {
    setParser(new KYLouisvilleParser(), "LOUISVILLE", "KY");
  }
  
  @Test
  public void testAnchorageFireAndEms() {

    doTest("T1",
        "(IPS I/Page Notification) Location: S 4TH ST/W OAK ST LVIL TYPE CODE: 12D02 SUB TYPE: default TIME: 13:37:05 Comments:  SEIZURE ProQA dispatch code: 12D02 Responder script: You are responding to a patient who has had a seizure. The patient is a 49-year-old female, who is conscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. 49-50 YOF GRN SHIRT, BLK JACKET, TAN PANTS, AT BUS STOP JUST COMING OUT OF SEIZURE, NOT ALERT 2081-1/CHESTNUT ",
        "ADDR:S 4TH ST & W OAK ST",
        "CITY:LOUISVILLE",
        "CODE:12D02",
        "CALL:Seizure - Continuous or multiple seizures",
        "TIME:13:37:05",
        "INFO:SEIZURE / You are responding to a patient who has had a seizure. The patient is a 49-year-old female, who is conscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. 49-50 YOF GRN SHIRT, BLK JACKET, TAN PANTS, AT BUS STOP JUST COMING OUT OF SEIZURE, NOT ALERT 2081-1/CHESTNUT");

    doTest("T2",
        "(IPS I/Page Notification) Location: 4320 TULIP GROVE CT LVIL TYPE CODE: 28C04X SUB TYPE: default TIME: 11:04:46 Comments:  DIZZY ProQA dispatch code: 31C02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 75-year-old male, who is conscious and breathing. Fainting episode(s) and alert => 35 (with cardiac history). Fainting episode(s) and alert => 35 (with cardiac history). -Comments: VALVE REPLACEMENT 1 YR AGO- FEELING FAINT, DIZZY, NUMBNESS IN HIS TONGUE AND LIPS KO ANCH ",
        "ADDR:4320 TULIP GROVE CT",
        "CITY:LOUISVILLE",
        "CODE:28C04X",
        "CALL:Stroke - Numbness, paralysis, or movement problems",
        "TIME:11:04:46",
        "INFO:DIZZY / You are responding to a patient who is unconscious (or has fainted). The patient is a 75-year-old male, who is conscious and breathing. Fainting episode(s) and alert => 35 (with cardiac history). Fainting episode(s) and alert => 35 (with cardiac history). -Comments: VALVE REPLACEMENT 1 YR AGO- FEELING FAINT, DIZZY, NUMBNESS IN HIS TONGUE AND LIPS KO ANCH");

    doTest("T3",
        "(IPS I/Page Notification) Location: JUNEAU DR/SHELBYVILLE RD MTWN TYPE CODE: 31A01 SUB TYPE: default TIME: 10:05:30 Comments:  FEMALE FELL ProQA dispatch code: 31A01 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 58-year-old female, who is conscious and breathing. Fainting episode(s) and alert => 35 (without cardiac history). Fainting episode(s) and alert => 35 (without cardiac history). AT MCDONALDS ON THE SIDE IS SITTING IN HER VEH MERCEDES ",
        "ADDR:JUNEAU DR & SHELBYVILLE RD",
        "CITY:MIDDLETOWN",
        "CODE:31A01",
        "CALL:Fainting episode(s) and alert >35 (w/o cardiac history)",
        "TIME:10:05:30",
        "INFO:FEMALE FELL / You are responding to a patient who is unconscious (or has fainted). The patient is a 58-year-old female, who is conscious and breathing. Fainting episode(s) and alert => 35 (without cardiac history). Fainting episode(s) and alert => 35 (without cardiac history). AT MCDONALDS ON THE SIDE IS SITTING IN HER VEH MERCEDES");

    doTest("T4",
        "(IPS I/Page Notification) Location: 2960 GOOSE CREEK RD MHIL,D111:BROWNSBORO PARK TYPE CODE: 17A01G SUB TYPE: default TIME: 22:27:13 Comments:  FELL ProQA dispatch code: 17A01 Responder script: You are responding to a patient involved in a fall. The patient is a 94-year-old male, who is conscious and breathing. NOT DANGEROUS PROXIMAL body area (On the ground or floor). NOT DANGEROUS PROXIMAL body area (On the ground or floor). REF - 143241611 94YOM FELL ADV SOMEONE ON SITE IS GOING TO OPEN THE FRONT DOOR ADV PT IS ALLERGIC TO PENICILLAN AND HAS LIMITED MOBILITY REQ RESPONDERS TO RESET LIFELINE ",
        "ADDR:2960 GOOSE CREEK RD",
        "APT:D111",
        "CITY:MURRAY HILL",
        "PLACE:BROWNSBORO PARK",
        "CODE:17A01G",
        "CALL:Fall - Not dangerous body area",
        "TIME:22:27:13",
        "INFO:FELL / You are responding to a patient involved in a fall. The patient is a 94-year-old male, who is conscious and breathing. NOT DANGEROUS PROXIMAL body area (On the ground or floor). NOT DANGEROUS PROXIMAL body area (On the ground or floor). REF - 143241611 94YOM FELL ADV SOMEONE ON SITE IS GOING TO OPEN THE FRONT DOOR ADV PT IS ALLERGIC TO PENICILLAN AND HAS LIMITED MOBILITY REQ RESPONDERS TO RESET LIFELINE");

    doTest("T5",
        "(IPS I/Page Notification) Location: 901 BLANKENBAKER PKY MTWN,1113: @HORIZON BAY NURSING HOME TYPE CODE: 10C02 SUB TYPE: default TIME: 21:14:05 Comments:  ProQA dispatch code: 10C02 Responder script: You are responding to a patient with chest pain. The patient is a 85-year-old female, who is conscious and breathing. Heart attack or angina history. -Comments: REG MEDS- 85 YO F CHEST PAIN ",
        "ADDR:901 BLANKENBAKER PKY",
        "MADDR:901 BLANKENBAKER PKWY",
        "APT:1113",
        "CITY:MIDDLETOWN",
        "PLACE:HORIZON BAY NURSING HOME",
        "CODE:10C02",
        "CALL:Chest Pain - Cardiac history",
        "TIME:21:14:05",
        "INFO:You are responding to a patient with chest pain. The patient is a 85-year-old female, who is conscious and breathing. Heart attack or angina history. -Comments: REG MEDS- 85 YO F CHEST PAIN");

    doTest("T6",
        "(IPS I/Page Notification) Location: 3001 CHAMBERLAIN LN LVIL: @FORD TRUCK PLANT - CHAMBERLAIN TYPE CODE: 33C06T SUB TYPE: default TIME: 19:20:51 Comments:  ProQA dispatch code: 33C06 Responder script: You are responding to a patient transfer or medical care facility situation. The patient is a 54-year-old male, who is conscious and breathing. Emergency response requested (Transfer). ENTER AT GATE 2 , PT IS AT THE MEDICAL DEPT PT PASSED OUT, HAVING BLOOD PRESSURE PROBLEM ",
        "ADDR:3001 CHAMBERLAIN LN",
        "CITY:LOUISVILLE",
        "PLACE:FORD TRUCK PLANT - CHAMBERLAIN",
        "CODE:33C06T",
        "CALL:Transfer - Emergency response requested",
        "TIME:19:20:51",
        "INFO:You are responding to a patient transfer or medical care facility situation. The patient is a 54-year-old male, who is conscious and breathing. Emergency response requested (Transfer). ENTER AT GATE 2 , PT IS AT THE MEDICAL DEPT PT PASSED OUT, HAVING BLOOD PRESSURE PROBLEM");

    doTest("T7",
        "(IPS I/Page Notification) Location: 14620 AIKEN RD LVIL: LAKE FOREST GOLD CLUB, MAINTENANCE TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 17:17:10 Comments:  GEN FIRE ** Case number 9913000386 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000119 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:14620 AIKEN RD",
        "CITY:LOUISVILLE",
        "PLACE:LAKE FOREST GOLD CLUB, MAINTENANCE",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:17:17:10",
        "INFO:GEN FIRE");

    doTest("T8",
        "(IPS I/Page Notification) Location: 3407 ASCOT CIR MCRE TYPE CODE: 10D04 SUB TYPE: default TIME: 14:58:37 Comments:  CHEST PAIN ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 81-year-old female, who is conscious and breathing. Clammy. ",
        "ADDR:3407 ASCOT CIR",
        "CITY:MANOR CREEK",
        "CODE:10D04",
        "CALL:Chest Pain - Clammy",
        "TIME:14:58:37",
        "INFO:CHEST PAIN / You are responding to a patient with chest pain. The patient is a 81-year-old female, who is conscious and breathing. Clammy.");

    doTest("T9",
        "(IPS I/Page Notification) Location: 10480 SHELBYVILLE RD BRM:FRESH MARKET TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:50:50 Comments:  GENERAL ALARM NTFY ** Case number 9913000382 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000118 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:10480 SHELBYVILLE RD",
        "CITY:BLUE RIDGE MANOR",
        "PLACE:FRESH MARKET",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:14:50:50",
        "INFO:GENERAL ALARM NTFY");

    doTest("T10",
        "(IPS I/Page Notification) Location: 1001 GLENRIDGE DR LYND,212 TYPE CODE: 10D04 SUB TYPE: default TIME: 12:40:18 Comments:  ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy. ** Case number 1613000386 has been assigned for 16:CNTY ** >>>> by: PATRICIA PUENTE on terminal: 911ms20 ",
        "ADDR:1001 GLENRIDGE DR",
        "APT:212",
        "CITY:LYNDON",
        "CODE:10D04",
        "CALL:Chest Pain - Clammy",
        "TIME:12:40:18",
        "INFO:You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy.");

  }
  
  @Test
  public void testOklonaFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 3142 CHINQUAPIN LN LVIL TYPE CODE: FIRE SUB TYPE: CLOSE_TO_STRUCT TIME: 13:19:53 Comments:  DUMPSTER ON FIRE CALLER ADV CLOSE TO STRUCTURE TWIN OAKS APT ** Case number 8013000491 has been assigned for 80:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 5013000143 has been assigned for 50:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 FIRE 6 ",
        "ADDR:3142 CHINQUAPIN LN",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:CLOSE_TO_STRUCT",
        "TIME:13:19:53",
        "INFO:DUMPSTER ON FIRE CALLER ADV CLOSE TO STRUCTURE TWIN OAKS APT");

    doTest("T2",
        "(IPS I/Page Notification) Location: 9110 COVENTRY LN LVIL TYPE CODE: LOCK_OUT/IN SUB TYPE: CHILD_IN_CAR TIME: 11:43:53 Comments:  2YO LOCKED IN 2003 FORD GRAY TAURUS NOT RUNNING ** Case number 8013000490 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:9110 COVENTRY LN",
        "CITY:LOUISVILLE",
        "CODE:LOCK_OUT/IN",
        "CALL:CHILD_IN_CAR",
        "TIME:11:43:53",
        "INFO:2YO LOCKED IN 2003 FORD GRAY TAURUS NOT RUNNING");

    doTest("T3",
        "(IPS I/Page Notification) Location: 4801 COMMERCE CROSSINGS DR LVIL,10 TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:19:30 Comments:  HAGEMEYER NORTH AMERICA WEST SIDE NTFY ** Case number 8013000489 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:4801 COMMERCE CROSSINGS DR",
        "APT:10",
        "CITY:LOUISVILLE",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:19:30",
        "INFO:HAGEMEYER NORTH AMERICA WEST SIDE NTFY");

    doTest("T4",
        "(IPS I/Page Notification) Location: 4611 BITTERSWEET RD LVIL;H:DRENAN EQUIPMENT COMPANY TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:08 Comments:  SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD ** Case number 5013000140 has been assigned for 50:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 8013000488 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 3713000227 has been assigned for 37:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:4611 BITTERSWEET RD",
        "CITY:LOUISVILLE",
        "APT:H",
        "PLACE:DRENAN EQUIPMENT COMPANY",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:08:52:08",
        "INFO:SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD");

    doTest("T5",
        "(IPS I/Page Notification) Location: 5001 ROSETTE BLVD LVIL TYPE CODE: ALARM SUB TYPE: RESIDENTIAL TIME: 19:57:15 Comments:  DRAIN RESD HALLWAY HEAT AND SMOKE WILL NTFY ** Case number 8013000487 has been assigned for 80:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 ** Case number 5013000139 has been assigned for 50:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 FIRE 6 ",
        "ADDR:5001 ROSETTE BLVD",
        "CITY:LOUISVILLE",
        "CODE:ALARM",
        "CALL:RESIDENTIAL",
        "TIME:19:57:15",
        "INFO:DRAIN RESD HALLWAY HEAT AND SMOKE WILL NTFY");

    doTest("T6",
        "(IPS I/Page Notification) Location: 3702 FALCON CREST DR LVIL,104 TYPE CODE: FIRE SUB TYPE: FOOD_ON_STOVE TIME: 19:40:24 Comments:  SKILLET WAS BURNING, IS OUT NOW, APT FULL OF SMOKE 1 SUBJ IN THE APT ** Case number 8013000486 has been assigned for 80:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ** Case number 9013000206 has been assigned for 90:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:3702 FALCON CREST DR",
        "APT:104",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:FOOD_ON_STOVE",
        "TIME:19:40:24",
        "INFO:SKILLET WAS BURNING, IS OUT NOW, APT FULL OF SMOKE 1 SUBJ IN THE APT");

    doTest("T7",
        "(IPS I/Page Notification) Location: SHEPHERDSVILLE RD/POPLAR LEVEL RD LVIL:TURNING LANE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:35:40 Comments:  MALE DOWN ProQA dispatch code: 32B03 Responder script: You are responding to a patient with an unknown problem (man down). The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. -Comments: TURNING LN ON SHEP- CALLER 3PC...TARC DRIVER STATED WHI CAR IN TURNING LN, MALE SLUMPED OVER 123-OL/NOLT YOUNG MALE UNCON UNRESPONSIVE, HR UNK IF BREATHING 733A ROLLED UP ON EMS COMING CODE 3 PD ALSO REQ FIRE ** Case number 8013000485 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:SHEPHERDSVILLE RD & POPLAR LEVEL RD",
        "CITY:LOUISVILLE",
        "PLACE:TURNING LANE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:16:35:40",
        "INFO:MALE DOWN / You are responding to a patient with an unknown problem (man down). The patient is a male of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. -Comments: TURNING LN ON SHEP- CALLER 3PC...TARC DRIVER STATED WHI CAR IN TURNING LN, MALE SLUMPED OVER 123-OL/NOLT YOUNG MALE UNCON UNRESPONSIVE, HR UNK IF BREATHING 733A ROLLED UP ON EMS COMING CODE 3 PD ALSO REQ FIRE");

    doTest("T8",
        "(IPS I/Page Notification) Location: 9215 PRESTON HWY LVIL TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 15:39:56 Comments:  Traffic / Transportation Incidents ProQA dispatch code: 29B01 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 56-year-old female, who is conscious and breathing. Injuries. 2.Chemicals or other hazards are not involved. BLK CADILLAC AND A TAN NISSAN 272- 274-65/ARTHER CX EMS PER 763, REQ FIRE FOR MITIGATION OF DEBRIS AND FLUID EMS OK ON CX ** Case number 8013000484 has been assigned for 80:CNTY ** >>>> by: JENNIFER MILBURN on terminal: 911ms27 ",
        "ADDR:9215 PRESTON HWY",
        "CITY:LOUISVILLE",
        "CODE:CHEMICAL",
        "CALL:MITIGATION",
        "TIME:15:39:56",
        "INFO:Traffic / Transportation Incidents / You are responding to a patient injured in a traffic incident. The patient is a 56-year-old female, who is conscious and breathing. Injuries. 2.Chemicals or other hazards are not involved. BLK CADILLAC AND A TAN NISSAN 272- 274-65/ARTHER CX EMS PER 763, REQ FIRE FOR MITIGATION OF DEBRIS AND FLUID EMS OK ON CX");

    doTest("T9",
        "(IPS I/Page Notification) Location: PRESTON HWY/MOUNT WASHINGTON RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:55:39 Comments:  IN FRONT OF WALMART ON PRESTON HWY 529 (LMPD) ON SCENE WILL ADV FURTHER ** Case number 8013000483 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:PRESTON HWY & MOUNT WASHINGTON RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:14:55:39",
        "INFO:IN FRONT OF WALMART ON PRESTON HWY 529 (LMPD) ON SCENE WILL ADV FURTHER");

    doTest("T10",
        "(IPS I/Page Notification) Location: 6301 GEIL LN LVIL:KENTUCKY CONTAINER SERVICES TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:34:26 Comments:  1ST FLOOR OFFICE SMOKE DETECTOR NTFY ** Case number 8013000482 has been assigned for 80:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 5013000138 has been assigned for 50:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:6301 GEIL LN",
        "CITY:LOUISVILLE",
        "PLACE:KENTUCKY CONTAINER SERVICES",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:14:34:26",
        "INFO:1ST FLOOR OFFICE SMOKE DETECTOR NTFY");

  }
  
  @Test
  public void testBuechelFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 4611 BITTERSWEET RD LVIL;H:DRENAN EQUIPMENT COMPANY TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:08 Comments:  SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD ** Case number 5013000140 has been assigned for 50:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 8013000488 has been assigned for 80:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ** Case number 3713000227 has been assigned for 37:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:4611 BITTERSWEET RD",
        "APT:H",
        "CITY:LOUISVILLE",
        "PLACE:DRENAN EQUIPMENT COMPANY",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:08:52:08",
        "INFO:SHOWING ON KEYPAD FIRE ALARM MULTIPLE TRIPS 4611 1/2 BITTERSWEET RD");

    doTest("T2",
        "(IPS I/Page Notification) Location: 5000 BARDSTOWN RD LVIL:WILDWOOD COUNTRY CLUB TYPE CODE: FIRE SUB TYPE: ELEC_ODOR_INSIDE TIME: 17:05:17 Comments:  SMELLS SOMETHING BURNING INSIDE THE DINING ROOM ** Case number 3713000226 has been assigned for 37:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 7113000197 has been assigned for 71:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:5000 BARDSTOWN RD",
        "CITY:LOUISVILLE",
        "PLACE:WILDWOOD COUNTRY CLUB",
        "CODE:FIRE",
        "CALL:ELEC_ODOR_INSIDE",
        "TIME:17:05:17",
        "INFO:SMELLS SOMETHING BURNING INSIDE THE DINING ROOM");

    doTest("T3",
        "(IPS I/Page Notification) Location: 2819 RIO RITA AVE LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:47:48 Comments:  poss stroke ProQA dispatch code: 28C01 Responder script: You are responding to a patient who has apparently suffered a stroke. The patient is a 85-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Not alert (Less than ___ hours since the symptoms started). -Comments: soeech- -Comments: 30 mins- 85 Y/O FEMALE, POSS STROKE, DLOC, SLURRED SPEECH, HX OF STROKE 127-BARD/BUECHEL LOU FIRE ON WORKING FIRE IN THE 4TH ** Alternate Dispatch Group CNTY used for 37/CNTY in event creation CAD SEL/REC IS BUECHEL, LFD CHIEF 5 OKAY ** Case number 3713000225 has been assigned for 37:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:2819 RIO RITA AVE",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:14:47:48",
        "INFO:poss stroke / You are responding to a patient who has apparently suffered a stroke. The patient is a 85-year-old female, who is conscious and breathing. Not alert (Less than ___ hours since the symptoms started). Not alert (Less than ___ hours since the symptoms started). -Comments: soeech- -Comments: 30 mins- 85 Y/O FEMALE, POSS STROKE, DLOC, SLURRED SPEECH, HX OF STROKE 127-BARD/BUECHEL LOU FIRE ON WORKING FIRE IN THE 4TH ** Alternate Dispatch Group CNTY used for 37/CNTY in event creation CAD SEL/REC IS BUECHEL, LFD CHIEF 5 OKAY");

    doTest("T4",
        "(IPS I/Page Notification) Location: BRECKENRIDGE LN/NACHAND LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 08:20:27 Comments:  ProQA dispatch code: 12D02 Responder script: You are responding to a patient who has had a seizure. The patient is a male of unknown age, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. UNK AGE MALE IN MAR MAZADA HAVING SZ HIT TREE SENDING FIRE VEH IS SMOKING PT IS STILL IN VEH ** Case number 3713000224 has been assigned for 37:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:BRECKENRIDGE LN & NACHAND LN",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:08:20:27",
        "INFO:You are responding to a patient who has had a seizure. The patient is a male of unknown age, who is unconscious and breathing. CONTINUOUS or MULTIPLE seizures. CONTINUOUS or MULTIPLE seizures. UNK AGE MALE IN MAR MAZADA HAVING SZ HIT TREE SENDING FIRE VEH IS SMOKING PT IS STILL IN VEH");

    doTest("T5",
        "(IPS I/Page Notification) Location: 4201 ST FRANCIS LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 05:14:50 Comments:  ProQA dispatch code: 13C01 Responder script: You are responding to a patient with diabetic problems. The patient is a 64-year-old male, who is conscious and breathing. Not alert (Combative or Aggressive). Not alert (Combative or Aggressive). VERY COMBATIVE LARGE M FIGHTING HIS ELDERLY MOTHER SHE IS WATCHING PT, DOOR IS OPEN, SHE ADV HAVE RESPONDERS COME IN 1086 FOR EMS PD REQS FIRE CODE 3 ** Case number 3713000223 has been assigned for 37:CNTY ** >>>> by: EDITH HIGGINS on terminal: 911ms20 ",
        "ADDR:4201 ST FRANCIS LN",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:05:14:50",
        "INFO:You are responding to a patient with diabetic problems. The patient is a 64-year-old male, who is conscious and breathing. Not alert (Combative or Aggressive). Not alert (Combative or Aggressive). VERY COMBATIVE LARGE M FIGHTING HIS ELDERLY MOTHER SHE IS WATCHING PT, DOOR IS OPEN, SHE ADV HAVE RESPONDERS COME IN 1086 FOR EMS PD REQS FIRE CODE 3");

    doTest("T6",
        "(IPS I/Page Notification) Location: 4342 NEWPORT RD LVIL,1 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 04:24:49 Comments:  ProQA dispatch code: 09E02 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 21-year-old female, who is unconscious and whose breathing is uncertain. Breathing uncertain (AGONAL). ** Case number 3713000222 has been assigned for 37:CNTY ** >>>> by: ROBIN LEWIS on terminal: 911ms21 127@BFD ",
        "ADDR:4342 NEWPORT RD",
        "APT:1",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:04:24:49",
        "INFO:You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 21-year-old female, who is unconscious and whose breathing is uncertain. Breathing uncertain (AGONAL).");

    doTest("T7",
        "(IPS I/Page Notification) Location: 3806 GREENWICH WAY LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 17:41:04 Comments:  ProQA dispatch code: 09E01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and not breathing. Not breathing at all. ** Case number 3713000221 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:3806 GREENWICH WAY",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:17:41:04",
        "INFO:You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and not breathing. Not breathing at all.");

    doTest("T8",
        "(IPS I/Page Notification) Location: BARDSTOWN RD/HIKES LN LVIL TYPE CODE: FIRE SUB TYPE: AUTOMOBILE TIME: 15:48:06 Comments:  DRK GRY NISSAN ALTIMA VS TREE TONES CAR WAS SMOKING COPYING FIRE ** Case number 5013000137 has been assigned for 50:CNTY ** >>>> by: JENNIFER THOMPSON on terminal: 911ms28 FIRE5 ** Case number 3713000220 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:BARDSTOWN RD & HIKES LN",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:AUTOMOBILE",
        "TIME:15:48:06",
        "INFO:DRK GRY NISSAN ALTIMA VS TREE TONES CAR WAS SMOKING COPYING FIRE");

    doTest("T9",
        "(IPS I/Page Notification) Location: 2100 BASHFORD MANOR LN WB:LOWE'S TYPE CODE: GAS_LEAK SUB TYPE: INSIDE TIME: 15:27:39 Comments:  @INSIDE REAR OF STORE, SMELLING GAS, NO SEEN SMOKE/FIRE ** Case number 3713000219 has been assigned for 37:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 5013000136 has been assigned for 50:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:2100 BASHFORD MANOR LN WB",
        "MADDR:2100 BASHFORD MANOR LN",
        "PLACE:LOWE'S",
        "CODE:GAS_LEAK",
        "CALL:INSIDE",
        "TIME:15:27:39",
        "INFO:@INSIDE REAR OF STORE, SMELLING GAS, NO SEEN SMOKE/FIRE");

    doTest("T10",
        "(IPS I/Page Notification) Location: 5329 RANGELAND RD LVIL,1 TYPE CODE: ACCIDENT SUB TYPE: VS_STRUCTURE TIME: 04:19:47 Comments:  APPEARS UNK VEH STRUCK WALL OF BLDG, THEN LEFT CALLER FOUND LARGE HOLE IN HIS WALL & DOOR IS GONE CAN'T SEE A VEH ANY LONGER HAVE PD VERI THIS IS THE CASE ADV IF FD IS NEEDED FOR STRUCTURE CK REQ FIRE TO CHECK BLDG THERE DOES APPEAR TO BE SOE STRUCTURAL DAMAGE ** Case number 8013000475 has been assigned for 80:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ** Case number 5013000133 has been assigned for 50:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ** Case number 3713000218 has been assigned for 37:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ",
        "ADDR:5329 RANGELAND RD",
        "APT:1",
        "CITY:LOUISVILLE",
        "CODE:ACCIDENT",
        "CALL:VS_STRUCTURE",
        "TIME:04:19:47",
        "INFO:APPEARS UNK VEH STRUCK WALL OF BLDG, THEN LEFT CALLER FOUND LARGE HOLE IN HIS WALL & DOOR IS GONE CAN'T SEE A VEH ANY LONGER HAVE PD VERI THIS IS THE CASE ADV IF FD IS NEEDED FOR STRUCTURE CK REQ FIRE TO CHECK BLDG THERE DOES APPEAR TO BE SOE STRUCTURAL DAMAGE");
    
  }
  
  @Test
  public void testMiddletownFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 10503 TIMBERWOOD CIR JTN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:07:10 Comments:  NTS PLAINVIEW 3..GENERAL FIRE ALARM.. ** Case number 9913000389 has been assigned for 99:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 3313000508 has been assigned for 33:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ",
        "ADDR:10503 TIMBERWOOD CIR",
        "CITY:JEFFERSONTOWN",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:07:10",
        "INFO:NTS PLAINVIEW 3..GENERAL FIRE ALARM..");

    doTest("T2",
        "(IPS I/Page Notification) Location: 12206 HARDWICK RD WDHI TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 22:51:07 Comments:  ProQA dispatch code: 13D01 Responder script: You are responding to a patient with diabetic problems. The patient is a 47-year-old male, who is unconscious and breathing. Unconscious. 112A 60/URTON ** Case number 9913000388 has been assigned for 99:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms27 ",
        "ADDR:12206 HARDWICK RD",
        "CITY:WOODLAND HILLS",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:22:51:07",
        "INFO:You are responding to a patient with diabetic problems. The patient is a 47-year-old male, who is unconscious and breathing. Unconscious. 112A 60/URTON");

    doTest("T3",
        "(IPS I/Page Notification) Location: 9802 VIEUX CARRE DR LVIL,2 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 21:54:28 Comments:  NOT CONSC/BREATHIN ProQA dispatch code: 09E01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 25-year-old female, who is unconscious and not breathing. Not breathing at all. 25YO F NOT CONSC/BREATH LANG BARRIER ** Case number 9913000387 has been assigned for 99:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms27 ",
        "ADDR:9802 VIEUX CARRE DR",
        "APT:2",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:21:54:28",
        "INFO:NOT CONSC/BREATHIN / You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 25-year-old female, who is unconscious and not breathing. Not breathing at all. 25YO F NOT CONSC/BREATH LANG BARRIER");

    doTest("T4",
        "(IPS I/Page Notification) Location: 14620 AIKEN RD LVIL: LAKE FOREST GOLD CLUB, MAINTENANCE TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 17:17:10 Comments:  GEN FIRE ** Case number 9913000386 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000119 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:14620 AIKEN RD",
        "CITY:LOUISVILLE",
        "PLACE:LAKE FOREST GOLD CLUB, MAINTENANCE",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:17:17:10",
        "INFO:GEN FIRE");

    doTest("T5",
        "(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 NOT GETTING ANY OTHER CALLS ON THIS 272A-MCMAHAN 2ND CALL OF THIS NATURE THIS DATE - UNFOUNDED EARLIER Duplicate Event: : @I64E TO BLANKENBAKER PKY N, Type = 29B01 MEDICAL 1050 MVA (INJURIES) MEDICAL INJURY ACCIDENT, Subtype = default MED_CALL default Med Call, Caller Name = KELLY MITCHELL, Caller Ph Number = (502) 876-4530, Call Source = 2-Phone, Alarm Level = 1 SPECIAL ADDRESS COMMENT: End of Duplicate Event data I64E TO BLANKENBAKER PKY N P/U OVERTURNED UNABLE TO GET OUT OF VEH FEMALE SAID SHE IS UNABLE TO MOVE FEM PT ARM INJURY, CONSCIOUS AND ALERT YEMS ENRT ",
        "ADDR:I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD",
        "MADDR:I 64 AT BLANKENBAKER PKWY EAST SIDE IN LMPD",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:16:50:26",
        "INFO:SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER / You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS...");

    doTest("T6",
        "(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD",
        "MADDR:I 64 AT BLANKENBAKER PKWY EAST SIDE IN LMPD",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:16:50:26",
        "INFO:SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER / You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS...");

    doTest("T7",
        "(IPS I/Page Notification) Location: 641 S HURSTBOURNE PKY JTN:GORDON FOOD SERVICE MARKETPLACE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:39:44 Comments:  YEMS REQ FIRE FOR 54 YOM W/CP PT IN THE FRONT OF THE STORE ** Case number 9913000384 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:641 S HURSTBOURNE PKY",
        "CITY:JEFFERSONTOWN",
        "MADDR:641 S HURSTBOURNE PKWY",
        "CITY:JEFFERSONTOWN",
        "PLACE:GORDON FOOD SERVICE MARKETPLACE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:16:39:44",
        "INFO:YEMS REQ FIRE FOR 54 YOM W/CP PT IN THE FRONT OF THE STORE");

    doTest("T8",
        "(IPS I/Page Notification) Location: FACTORY LN/LA GRANGE RD LVIL TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 15:42:13 Comments:  BETWEE THORTON'S AND BANK OF OLDHAM CO., THE TURNING LANE IS VERY SLICK, POSS OIL ON ROAD VEHS SLIDING ** Case number 9913000383 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:FACTORY LN & LA GRANGE RD",
        "CITY:LOUISVILLE",
        "CODE:CHEMICAL",
        "CALL:MITIGATION",
        "TIME:15:42:13",
        "INFO:BETWEE THORTON'S AND BANK OF OLDHAM CO., THE TURNING LANE IS VERY SLICK, POSS OIL ON ROAD VEHS SLIDING");

    doTest("T9",
        "(IPS I/Page Notification) Location: 10480 SHELBYVILLE RD BRM:FRESH MARKET TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:50:50 Comments:  GENERAL ALARM NTFY ** Case number 9913000382 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 2013000118 has been assigned for 20:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:10480 SHELBYVILLE RD",
        "CITY:BLUE RIDGE MANOR",
        "PLACE:FRESH MARKET",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:14:50:50",
        "INFO:GENERAL ALARM NTFY");

    doTest("T10",
        "(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY IN JTN TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 14:36:15 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN JTN VEHICLE OVERTURNED OCCUPANT OUT OF THE VEHICLE WALKING AROUND 2ND VEHICLE IS ON THE EXIT ** Case number 9913000381 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:I64E AT BLANKENBAKER PKY IN",
        "CITY:JEFFERSONTOWN",
        "MADDR:I 64 AT BLANKENBAKER PKWY IN",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:14:36:15",
        "INFO:SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN JTN VEHICLE OVERTURNED OCCUPANT OUT OF THE VEHICLE WALKING AROUND 2ND VEHICLE IS ON THE EXIT");


  }
  
  @Test
  public void testMcMahanFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: S HURSTBOURNE PKY/HURSTBOURNE LN LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:07:36 Comments:  X736D ROLLED UP ON 3 VEHS, AIRBAGS DEPLOYED ** Case number 5513000238 has been assigned for 55:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:S HURSTBOURNE PKY & HURSTBOURNE LN",
        "MADDR:S HURSTBOURNE PKWY & HURSTBOURNE LN",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:20:07:36",
        "INFO:X736D ROLLED UP ON 3 VEHS, AIRBAGS DEPLOYED");

    doTest("T2",
        "(IPS I/Page Notification) Location: 7902 KINGMAN WAY LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 17:24:06 Comments:  ProQA dispatch code: 17B03 Responder script: You are responding to a patient involved in a fall. The patient is a 69-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Unknown status/Other codes not applicable (On the ground or floor). REF 143237424 272A MCMAHAN NORMA FLETCHER502-493-4642 MED INFO :HIP FRACTURE NO KEY INFO COPYING FIRE FOR POSS FORCED ENTRY ** Case number 5513000237 has been assigned for 55:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:7902 KINGMAN WAY",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:17:24:06",
        "INFO:You are responding to a patient involved in a fall. The patient is a 69-year-old female, who is conscious and breathing. Unknown status/Other codes not applicable (On the ground or floor). Unknown status/Other codes not applicable (On the ground or floor). REF 143237424 272A MCMAHAN NORMA FLETCHER502-493-4642 MED INFO :HIP FRACTURE NO KEY INFO COPYING FIRE FOR POSS FORCED ENTRY");

    doTest("T3",
        "(IPS I/Page Notification) Location: 2811 BROWNS LN SRPK TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:25:04 Comments:  soa ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000236 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 62 Y/O MALE, SOA FIRE 5 FLUSHED 255BRECK DUTCH ",
        "ADDR:2811 BROWNS LN",
        "CITY:ST REGIS PARK",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:11:25:04",
        "INFO:soa / You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS.");

    doTest("T4",
        "(IPS I/Page Notification) Location: 2811 BROWNS LN SRPK TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:25:04 Comments:  soa ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000236 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:2811 BROWNS LN",
        "CITY:ST REGIS PARK",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:11:25:04",
        "INFO:soa / You are responding to a patient with breathing problems. The patient is a 62-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS.");

    doTest("T5",
        "(IPS I/Page Notification) Location: 9902 TAYLORSVILLE RD JTN:PUPPY LOVE PET RESORT TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 10:59:53 Comments:  POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B ** Case number 3313000503 has been assigned for 33:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000235 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7113000195 has been assigned for 71:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:9902 TAYLORSVILLE RD",
        "CITY:JEFFERSONTOWN",
        "PLACE:PUPPY LOVE PET RESORT",
        "CODE:FIRE",
        "CALL:COMMERCIAL",
        "TIME:10:59:53",
        "INFO:POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B");

    doTest("T6",
        "(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:51:52 Comments:  897-8100, WILL NTFY FIRE ALARM FROM DAYCARE ** Case number 2613000258 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000234 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:4000 KRESGE WAY",
        "CITY:ST MATTHEWS",
        "PLACE:BAPTIST EAST HOSPITAL",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:51:52",
        "INFO:897-8100, WILL NTFY FIRE ALARM FROM DAYCARE");

    doTest("T7",
        "(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:18:04 Comments:  DAYCARE NTFY LIC 114 ** Case number 2613000257 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000233 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:4000 KRESGE WAY",
        "CITY:ST MATTHEWS",
        "PLACE:BAPTIST EAST HOSPITAL",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:18:04",
        "INFO:DAYCARE NTFY LIC 114");

    doTest("T8",
        "(IPS I/Page Notification) Location: 4620 TAYLORSVILLE RD JTN:LA FITNESS ON TAYLORSVILLE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:30:44 Comments:  ProQA dispatch code: 10D02 Responder script: You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000232 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 FIRE 5 YELLOW OK ",
        "ADDR:4620 TAYLORSVILLE RD",
        "CITY:JEFFERSONTOWN",
        "PLACE:LA FITNESS ON TAYLORSVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:09:30:44",
        "INFO:You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS.");

    doTest("T9",
        "(IPS I/Page Notification) Location: 4620 TAYLORSVILLE RD JTN:LA FITNESS ON TAYLORSVILLE TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:30:44 Comments:  ProQA dispatch code: 10D02 Responder script: You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. ** Case number 5513000232 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:4620 TAYLORSVILLE RD",
        "CITY:JEFFERSONTOWN",
        "PLACE:LA FITNESS ON TAYLORSVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:09:30:44",
        "INFO:You are responding to a patient with chest pain. The patient is a 24-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS.");

    doTest("T10",
        "(IPS I/Page Notification) Location: 3410 BRECKENRIDGE LN LVIL,2 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 21:52:39 Comments:  SOA ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 62-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. Reconfigured dispatch code: 06D02 Responder script: SPEAKING BETWEEN BREATHS (Asthma). DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma). ** Case number 5513000231 has been assigned for 55:CNTY ** >>>> by: ROBIN LEWIS on terminal: 911ms21 Chief complaint code of last reconfigure: 6 FIRE5 161@ BRECK/TAYLORSVILLE ",
        "ADDR:3410 BRECKENRIDGE LN",
        "APT:2",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:21:52:39",
        "INFO:SOA / You are responding to a patient with breathing problems. The patient is a 62-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. Reconfigured dispatch code: 06D02 Responder script: SPEAKING BETWEEN BREATHS (Asthma). DIFFICULTY SPEAKING BETWEEN BREATHS (Asthma).");

  }
  
  @Test
  public void testLyndonFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 9505 WILLIAMSBURG PLZ HURS:BUSN BLDG TYPE CODE: WATER_LEAK SUB TYPE: INSIDE TIME: 00:43:56 Comments:  ADV LRG STREAM OF WATER SHOOTING OUT FROM THE VINYL SIDING POS WATER LEAK INSIDE THE BLDG ** Case number 1613000390 has been assigned for 16:CNTY ** >>>> by: COLLEEN KATS on terminal: 911ms28 ADV THERE IS NO INFO ON THE DOORS AS FAR AS WHO TO CONTACT ",
        "ADDR:9505 WILLIAMSBURG PLZ",
        "CITY:HURSTBOURNE",
        "PLACE:BUSN BLDG",
        "CODE:WATER_LEAK",
        "CALL:INSIDE",
        "TIME:00:43:56",
        "INFO:ADV LRG STREAM OF WATER SHOOTING OUT FROM THE VINYL SIDING POS WATER LEAK INSIDE THE BLDG");

    doTest("T2",
        "(IPS I/Page Notification) Location: 3500 SPRINGHURST COMMONS DR LVIL:@MARRIOTT TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 18:50:59 Comments:  ZONE E113, WATERFLOW PREM# 412-1311 NOTI ** Case number 1613000389 has been assigned for 16:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ** Case number 1813000216 has been assigned for 18:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:3500 SPRINGHURST COMMONS DR",
        "CITY:LOUISVILLE",
        "PLACE:MARRIOTT",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:18:50:59",
        "INFO:ZONE E113, WATERFLOW PREM# 412-1311 NOTI");

    doTest("T3",
        "(IPS I/Page Notification) Location: 10007 WHIPPS MILL RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:41:53 Comments:  ProQA dispatch code: 32B02 Responder script: You are responding to a patient with an unknown problem (man down). The patient is of unknown age and gender, whose consciousness and breathing is unknown. Medical Alarm (Alert) notifications (no patient information). REC MEDICAL ALARM FROM PENDANT 502-333-0208 CAROLYN FISHER NO KEY INFO, NA ON PHONE, COPYING FIRE FOR POSS FORCED ENTRY Duplicate Event:Location = 10007 WHIPPS MILL RD LVIL, Cross Street 1 = LA GRANGE RD, Cross Street 2 = KEENELAND BLVD, Type = 1032 TROUBLE, Subtype = 911 911 HANG UP, Caller Name = CAROLYN FISCHER, Caller Ph Number = (502) 333-0208, Caller Address = 10007 WHIPPS MILL RD LOUISVILLE, Call Source = ANI/ALI, Alarm Level = 1 End of Duplicate Event data FROM RESD VM ON CV CORR CB ** Case number 1613000388 has been assigned for 16:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:10007 WHIPPS MILL RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:18:41:53",
        "INFO:You are responding to a patient with an unknown problem (man down). The patient is of unknown age and gender, whose consciousness and breathing is unknown. Medical Alarm (Alert) notifications (no patient information). REC MEDICAL ALARM FROM PENDANT 502-333-0208 CAROLYN FISHER NO KEY INFO, NA ON PHONE, COPYING FIRE FOR POSS FORCED ENTRY Duplicate Event:Location = 10007 WHIPPS MILL RD LVIL, Cross Street 1 = LA GRANGE RD, Cross Street 2 = KEENELAND BLVD, Type = 1032 TROUBLE, Subtype = 911 911 HANG UP, Caller Name = CAROLYN FISCHER, Caller Ph Number = (502) 333-0208, Caller Address = 10007 WHIPPS MILL RD LOUISVILLE, Call Source = ANI/ALI, Alarm Level = 1 End of Duplicate Event data FROM RESD VM ON CV CORR CB");

    doTest("T4",
        "(IPS I/Page Notification) Location: 1801 LYNN WAY GMOR: @JEFFERSON MANOR NURSING HOME TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 12:40:55 Comments:  502-426-4513, GENERAL FIRE ALARM, NTFY ** Case number 1613000387 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 2613000259 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:1801 LYNN WAY",
        "CITY:GRAYMOOR-DEVONDALE",
        "PLACE:JEFFERSON MANOR NURSING HOME",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:12:40:55",
        "INFO:502-426-4513, GENERAL FIRE ALARM, NTFY");

    doTest("T5",
        "(IPS I/Page Notification) Location: 1001 GLENRIDGE DR LYND,212 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 12:40:18 Comments:  ProQA dispatch code: 10D04 Responder script: You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy. ** Case number 1613000386 has been assigned for 16:CNTY ** >>>> by: PATRICIA PUENTE on terminal: 911ms20 ",
        "ADDR:1001 GLENRIDGE DR",
        "APT:212",
        "CITY:LYNDON",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:12:40:18",
        "INFO:You are responding to a patient with chest pain. The patient is a 51-year-old female, who is conscious and breathing. Clammy.");

    doTest("T6",
        "(IPS I/Page Notification) Location: NEW LA GRANGE RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 09:31:09 Comments:  WHITE CAR VS BLK SUV 758-1610 ADV NEED EMS - STARTING EMS ProQA dispatch code: 29B04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 30-year-old male, who is conscious and breathing. Unknown status/Other codes not applicable. Unknown status/Other codes not applicable. 2.Chemicals or other hazards are not involved. 111/ST MATH 30YO MALE ASKED PM TO CALL EMS DUE TO AIRBAG DEPLOYING ** Case number 1613000385 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:NEW LA GRANGE RD & SHELBYVILLE RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:09:31:09",
        "INFO:WHITE CAR VS BLK SUV 758-1610 ADV NEED EMS - STARTING EMS / You are responding to a patient injured in a traffic incident. The patient is a 30-year-old male, who is conscious and breathing. Unknown status/Other codes not applicable. Unknown status/Other codes not applicable. 2.Chemicals or other hazards are not involved. 111/ST MATH 30YO MALE ASKED PM TO CALL EMS DUE TO AIRBAG DEPLOYING");

    doTest("T7",
        "(IPS I/Page Notification) Location: 120 BLAINE RD BELM TYPE CODE: FIRE SUB TYPE: RESIDENTIAL TIME: 18:34:00 Comments:  ** Case number 1613000384 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:120 BLAINE RD",
        "CITY:BELLEMEADE",
        "CODE:FIRE",
        "CALL:RESIDENTIAL",
        "TIME:18:34:00");

    doTest("T8",
        "(IPS I/Page Notification) Location: 9604 SOMERFORD CT MEDV TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:16:23 Comments:  ProQA dispatch code: 09D01 Responder script: You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and whose breathing is unknown. INEFFECTIVE BREATHING. 1.The cardiac arrest was witnessed. ADV HAS DEFIB IN CHEST 119...MT3 PT UNCON, UNSURE IF BREATHING ** Case number 1613000383 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:9604 SOMERFORD CT",
        "CITY:MEADOWVALE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:18:16:23",
        "INFO:You are responding to a patient in apparent cardiac (respiratory) arrest. The patient is a 54-year-old female, who is unconscious and whose breathing is unknown. INEFFECTIVE BREATHING. 1.The cardiac arrest was witnessed. ADV HAS DEFIB IN CHEST 119...MT3 PT UNCON, UNSURE IF BREATHING");

    doTest("T9",
        "(IPS I/Page Notification) Location: 9300BLK WHIPPS MILL RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:19:07 Comments:  @THE LYNDON BALL PARK 80YOF, FAINTED, UNCON PT IS BREATHING HE SAID THEY ARE IN THE 2ND LOT BACK, NEAR THE BALL FIELD ** Case number 1613000382 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:9300BLK WHIPPS MILL RD",
        "MADDR:9300 WHIPPS MILL RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:15:19:07",
        "INFO:@THE LYNDON BALL PARK 80YOF, FAINTED, UNCON PT IS BREATHING HE SAID THEY ARE IN THE 2ND LOT BACK, NEAR THE BALL FIELD");

    doTest("T10",
        "(IPS I/Page Notification) Location: 3500 SPRINGHURST COMMONS DR LVIL:MARRIOT RESIDENCE INN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 09:59:53 Comments:  502-412-1311, WILL NTFY SMOKE ALARM ** Case number 1613000381 has been assigned for 16:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms20 ** Case number 1813000213 has been assigned for 18:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms20 ",
        "ADDR:3500 SPRINGHURST COMMONS DR",
        "CITY:LOUISVILLE",
        "PLACE:MARRIOT RESIDENCE INN",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:09:59:53",
        "INFO:502-412-1311, WILL NTFY SMOKE ALARM");

  }
  
  @Test
  public void testStMatthewsFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 1801 LYNN WAY GMOR: @JEFFERSON MANOR NURSING HOME TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 12:40:55 Comments:  502-426-4513, GENERAL FIRE ALARM, NTFY ** Case number 1613000387 has been assigned for 16:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 2613000259 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:1801 LYNN WAY",
        "CITY:GRAYMOOR-DEVONDALE",
        "PLACE:JEFFERSON MANOR NURSING HOME",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:12:40:55",
        "INFO:502-426-4513, GENERAL FIRE ALARM, NTFY");

    doTest("T2",
        "(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:51:52 Comments:  897-8100, WILL NTFY FIRE ALARM FROM DAYCARE ** Case number 2613000258 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000234 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:4000 KRESGE WAY",
        "CITY:ST MATTHEWS",
        "PLACE:BAPTIST EAST HOSPITAL",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:51:52",
        "INFO:897-8100, WILL NTFY FIRE ALARM FROM DAYCARE");

    doTest("T3",
        "(IPS I/Page Notification) Location: 4000 KRESGE WAY STM: @BAPTIST EAST HOSPITAL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:18:04 Comments:  DAYCARE NTFY LIC 114 ** Case number 2613000257 has been assigned for 26:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000233 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:4000 KRESGE WAY",
        "CITY:ST MATTHEWS",
        "PLACE:BAPTIST EAST HOSPITAL",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:18:04",
        "INFO:DAYCARE NTFY LIC 114");

    doTest("T4",
        "(IPS I/Page Notification) Location: 992 BRECKENRIDGE LN STM: BOOKS A MILLION TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 22:42:22 Comments:  ProQA dispatch code: 31D02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 40-year-old female, who is unconscious and breathing. Unconscious -- Effective breathing. ** Case number 2613000255 has been assigned for 26:CNTY ** >>>> by: ANTHONY MCGARRY on terminal: 911ms20 ",
        "ADDR:992 BRECKENRIDGE LN",
        "CITY:ST MATTHEWS",
        "PLACE:BOOKS A MILLION",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:22:42:22",
        "INFO:You are responding to a patient who is unconscious (or has fainted). The patient is a 40-year-old female, who is unconscious and breathing. Unconscious -- Effective breathing.");

    doTest("T5",
        "(IPS I/Page Notification) Location: 958 MALLARD CREEK RD STM TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 06:18:42 Comments:  OVERDOSE ProQA dispatch code: 23D01 Responder script: You are responding to a patient who has apparently overdosed/been poisoned. The patient is a 44-year-old female, who is unconscious and breathing. Unconscious (Intentional Overdose). 1.This was intentional. ALT# 502-510-3352 -085.631645 +38.233601 ** Case number 2613000253 has been assigned for 26:CNTY ** >>>> by: JOHN WEIBLE on terminal: 911ms21 ",
        "ADDR:958 MALLARD CREEK RD",
        "CITY:ST MATTHEWS",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:06:18:42",
        "INFO:OVERDOSE / You are responding to a patient who has apparently overdosed/been poisoned. The patient is a 44-year-old female, who is unconscious and breathing. Unconscious (Intentional Overdose). 1.This was intentional. ALT# 502-510-3352 -085.631645 +38.233601");

    doTest("T6",
        "(IPS I/Page Notification) Location: 3921 SHELBYVILLE RD STM:TINROOF TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 01:52:17 Comments:  THROUGH BUILDING X 3 ** Case number 2613000252 has been assigned for 26:CNTY ** >>>> by: TARI BROOKS on terminal: 911ms21 ",
        "ADDR:3921 SHELBYVILLE RD",
        "CITY:ST MATTHEWS",
        "PLACE:TINROOF",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:01:52:17",
        "INFO:THROUGH BUILDING X 3");

    doTest("T7",
        "(IPS I/Page Notification) Location: 5000 SHELBYVILLE RD STM: @MALL ST MATTHEWS TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:13:48 Comments:  IN THE LOBBY AREA UNCONS ProQA dispatch code: 31D02 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a female of unknown age, who is unconscious and whose breathing is unknown. Unconscious -- Effective breathing. E111...60/THIE Chief complaint code of last reconfigure: 31 UNCONS NOW CONS Reconfigured dispatch code: 31D03 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 0-month-old female, who is unconscious and whose breathing is unknown. Not alert. 3RD PARTY CALL ** Case number 2613000251 has been assigned for 26:CNTY ** >>>> by: MELISSA HARLEY on terminal: 911ms28 ",
        "ADDR:5000 SHELBYVILLE RD",
        "CITY:ST MATTHEWS",
        "PLACE:MALL ST MATTHEWS",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:20:13:48",
        "INFO:IN THE LOBBY AREA UNCONS / You are responding to a patient who is unconscious (or has fainted). The patient is a female of unknown age, who is unconscious and whose breathing is unknown. Unconscious -- Effective breathing. E111...60/THIE Chief complaint code of last reconfigure: 31 UNCONS NOW CONS Reconfigured dispatch code: 31D03 Responder script: You are responding to a patient who is unconscious (or has fainted). The patient is a 0-month-old female, who is unconscious and whose breathing is unknown. Not alert. 3RD PARTY CALL");

    doTest("T8",
        "(IPS I/Page Notification) Location: 1615 MILITARY AVE LYND TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 20:12:57 Comments:  COMP SEES SMOKE COMING FROM BUILDING BEHIND CHILDRENS HOME ** Case number 1613000378 has been assigned for 16:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 9913000358 has been assigned for 99:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2013000111 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2613000250 has been assigned for 26:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:1615 MILITARY AVE",
        "CITY:LYNDON",
        "CODE:FIRE",
        "CALL:COMMERCIAL",
        "TIME:20:12:57",
        "INFO:COMP SEES SMOKE COMING FROM BUILDING BEHIND CHILDRENS HOME");

    doTest("T9",
        "(IPS I/Page Notification) Location: 100 MALLARD CREEK RD STM:LAKE VIEW TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 15:51:27 Comments:  WATER FLOW, 502-326-1166, NTFY ** Case number 2613000248 has been assigned for 26:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 5513000223 has been assigned for 55:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:100 MALLARD CREEK RD",
        "CITY:ST MATTHEWS",
        "PLACE:LAKE VIEW",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:15:51:27",
        "INFO:WATER FLOW, 502-326-1166, NTFY");

    doTest("T10",
        "(IPS I/Page Notification) Location: 400 MALLARD CREEK RD STM:MALLARD CROSSING LEASING OFFICES TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 14:14:54 Comments:  SMOKE DET, RECREATION AREA NTFY ** Case number 2613000247 has been assigned for 26:CNTY ** >>>> by: TRENTON ALDRIDGE on terminal: 911ms27 ** Case number 1613000367 has been assigned for 16:CNTY ** >>>> by: TRENTON ALDRIDGE on terminal: 911ms27 ",
        "ADDR:400 MALLARD CREEK RD",
        "CITY:ST MATTHEWS",
        "PLACE:MALLARD CROSSING LEASING OFFICES",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:14:14:54",
        "INFO:SMOKE DET, RECREATION AREA NTFY");

  }
  
  @Test
  public void testJeffersontownFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 11405 BLUEGRASS PKY JTN: ADP TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 13:48:19 Comments:  55-60YO F UNK PROBLEM YELLOW OK ** Case number 3313000511 has been assigned for 33:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:11405 BLUEGRASS PKY",
        "MADDR:11405 BLUEGRASS PKWY",
        "CITY:JEFFERSONTOWN",
        "PLACE:ADP",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:13:48:19",
        "INFO:55-60YO F UNK PROBLEM YELLOW OK");

    doTest("T2",
        "(IPS I/Page Notification) Location: 9207 PINE LAKE DR JTN,201 TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 13:32:56 Comments:  YELLOW REQ FIRE FOR 15MONTH OLD THAT SWOLLEN SCREW ** Case number 3313000510 has been assigned for 33:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:9207 PINE LAKE DR",
        "APT:201",
        "CITY:JEFFERSONTOWN",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:13:32:56",
        "INFO:YELLOW REQ FIRE FOR 15MONTH OLD THAT SWOLLEN SCREW");

    doTest("T3",
        "(IPS I/Page Notification) Location: 8306 SUNNY RIDGE CT LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:02:35 Comments:  ProQA dispatch code: 17D03 Responder script: You are responding to a patient involved in a fall. The patient is a 54-year-old male, who is conscious and breathing. Not alert. 54YOM FELL NOT ALERT INJURED BACK ** Case number 3313000509 has been assigned for 33:CNTY ** >>>> by: DEANNA SEABOLT on terminal: 911ms21 ",
        "ADDR:8306 SUNNY RIDGE CT",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:11:02:35",
        "INFO:You are responding to a patient involved in a fall. The patient is a 54-year-old male, who is conscious and breathing. Not alert. 54YOM FELL NOT ALERT INJURED BACK");

    doTest("T4",
        "(IPS I/Page Notification) Location: 10503 TIMBERWOOD CIR JTN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 10:07:10 Comments:  NTS PLAINVIEW 3..GENERAL FIRE ALARM.. ** Case number 9913000389 has been assigned for 99:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ** Case number 3313000508 has been assigned for 33:CNTY ** >>>> by: TOMIKO COATES on terminal: 911ms20 ",
        "ADDR:10503 TIMBERWOOD CIR",
        "CITY:JEFFERSONTOWN",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:10:07:10",
        "INFO:NTS PLAINVIEW 3..GENERAL FIRE ALARM..");

    doTest("T5",
        "(IPS I/Page Notification) Location: S HURSTBOURNE PKY/SIX MILE LN LVIL:S OF LOC TYPE CODE: CHEMICAL SUB TYPE: MITIGATION TIME: 22:09:03 Comments:  REF EMS ADV FUEL LEAKING BLK CIVIC VS WHT GALANT COPYING FIRE FIRE FIVE ** Case number 3313000507 has been assigned for 33:CNTY ** >>>> by: COLLEEN KATS on terminal: 911ms28 ",
        "ADDR:S HURSTBOURNE PKY & SIX MILE LN",
        "MADDR:S HURSTBOURNE PKWY & SIX MILE LN",
        "CITY:LOUISVILLE",
        "PLACE:S OF LOC",
        "CODE:CHEMICAL",
        "CALL:MITIGATION",
        "TIME:22:09:03",
        "INFO:REF EMS ADV FUEL LEAKING BLK CIVIC VS WHT GALANT COPYING FIRE FIRE FIVE");

    doTest("T6",
        "(IPS I/Page Notification) Location: 8714 LANTERN LITE PKY JTN TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:57:19 Comments:  31 YO F SOA CHEST PAIN YLW EMS OK HX OF STROKE FIRE CODE 3 ** Case number 3313000506 has been assigned for 33:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:8714 LANTERN LITE PKY",
        "MADDR:8714 LANTERN LITE PKWY",
        "CITY:JEFFERSONTOWN",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:20:57:19",
        "INFO:31 YO F SOA CHEST PAIN YLW EMS OK HX OF STROKE FIRE CODE 3");

    doTest("T7",
        "(IPS I/Page Notification) Location: 6415 CALM RIVER WAY LVIL:GLENRIDGE HEALTH CAMPUS TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 19:20:03 Comments:  GENERAL FIRE NTFY ** Case number 3313000505 has been assigned for 33:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:6415 CALM RIVER WAY",
        "CITY:LOUISVILLE",
        "PLACE:GLENRIDGE HEALTH CAMPUS",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:19:20:03",
        "INFO:GENERAL FIRE NTFY");

    doTest("T8",
        "(IPS I/Page Notification) Location: @I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 16:50:26 Comments:  SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS... ** Case number 9913000385 has been assigned for 99:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ** Case number 3313000504 has been assigned for 33:CNTY ** >>>> by: GERRI GRIDER on terminal: 911ms26 ",
        "ADDR:I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD",
        "MADDR:I 64 AT BLANKENBAKER PKWY EAST SIDE IN LMPD",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:16:50:26",
        "INFO:SPECIAL ADDRESS COMMENT: I64E AT BLANKENBAKER PKY EAST SIDE IN LMPD ROLLOVER / You are responding to a patient injured in a traffic incident. The patient is of unknown age and gender, whose consciousness and breathing is unknown. HIGH MECHANISM (k through s). WHI SUV ROLLOVER IN GRASS...");

    doTest("T9",
        "(IPS I/Page Notification) Location: 9902 TAYLORSVILLE RD JTN:PUPPY LOVE PET RESORT TYPE CODE: FIRE SUB TYPE: COMMERCIAL TIME: 10:59:53 Comments:  POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B ** Case number 3313000503 has been assigned for 33:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 5513000235 has been assigned for 55:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7113000195 has been assigned for 71:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:9902 TAYLORSVILLE RD",
        "CITY:JEFFERSONTOWN",
        "PLACE:PUPPY LOVE PET RESORT",
        "CODE:FIRE",
        "CALL:COMMERCIAL",
        "TIME:10:59:53",
        "INFO:POSS STRUCTURE FIRE CALL WAS DISCONNECTED, B");

    doTest("T10",
        "(IPS I/Page Notification) Location: 11500 FALLING BROOK DR LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 11:35:16 Comments:  ProQA dispatch code: 10D01 Responder script: You are responding to a patient with chest pain. The patient is a 77-year-old female, who is conscious and breathing. Not alert. DELAY MULT RUNS TO DISPATCH ** Case number 3313000502 has been assigned for 33:CNTY ** >>>> by: LORI BAKER on terminal: 911ms20 ",
        "ADDR:11500 FALLING BROOK DR",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:11:35:16",
        "INFO:You are responding to a patient with chest pain. The patient is a 77-year-old female, who is conscious and breathing. Not alert. DELAY MULT RUNS TO DISPATCH");

  }
  
  @Test
  public void testEastwoodFire() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 15405 BECKLEY HILLS DR LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 19:04:20 Comments:  ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 47-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. HX KIDNEY FAILURE ** Case number 7713000103 has been assigned for 77:CNTY ** >>>> by: PATRICK RIORDAN on terminal: 911ms26 ",
        "ADDR:15405 BECKLEY HILLS DR",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:19:04:20",
        "INFO:You are responding to a patient with breathing problems. The patient is a 47-year-old male, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. HX KIDNEY FAILURE");

    doTest("T2",
        "(IPS I/Page Notification) Location: @I265N AT LA GRANGE RD TYPE CODE: ACCIDENT SUB TYPE: RESCUE TIME: 06:25:21 Comments:  SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD ProQA dispatch code: 29D04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK ** Case number 9913000376 has been assigned for 99:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7713000102 has been assigned for 77:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 112A/MT1 ",
        "ADDR:I265N AT LA GRANGE RD",
        "MADDR:I 265 AT LA GRANGE RD",
        "CODE:ACCIDENT",
        "CALL:RESCUE",
        "TIME:06:25:21",
        "INFO:SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD / You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK");

    doTest("T3",
        "(IPS I/Page Notification) Location: @I265N AT LA GRANGE RD TYPE CODE: ACCIDENT SUB TYPE: RESCUE TIME: 06:25:21 Comments:  SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD ProQA dispatch code: 29D04 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK ** Case number 9913000376 has been assigned for 99:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ** Case number 7713000102 has been assigned for 77:CNTY ** >>>> by: VIOLA BROWN on terminal: 911ms21 ",
        "ADDR:I265N AT LA GRANGE RD",
        "MADDR:I 265 AT LA GRANGE RD",
        "CODE:ACCIDENT",
        "CALL:RESCUE",
        "TIME:06:25:21",
        "INFO:SPECIAL ADDRESS COMMENT: I265N AT LA GRANGE RD / You are responding to a patient injured in a traffic incident. The patient is a 59-year-old female, who is conscious and breathing. Pinned (trapped) victim. Pinned (trapped) victim. 2.Chemicals or other hazards are not involved. 59YO F IN THE DITCH IN THE CREEK NT AV SHE IS STUCK");

    doTest("T4",
        "(IPS I/Page Notification) Location: 1309 FLAT ROCK RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 20:23:32 Comments:  HEART PROBLEMS ProQA dispatch code: 32B03 Responder script: You are responding to a patient with an unknown problem (man down). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. DOES LMPD NEED TO MAKE THE HEART PROBLEMS/ ELDERLY FEMALE HEART PROBLEMS CHIEF DAVENPORT ADV SEND FIRE WAS VERY COOPERATIVE IN ANSWERING QUESTIONS ** Case number 7713000101 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:1309 FLAT ROCK RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:20:23:32",
        "INFO:HEART PROBLEMS / You are responding to a patient with an unknown problem (man down). The patient is a female of unknown age, whose consciousness and breathing is unknown. Unknown status/Other codes not applicable. DOES LMPD NEED TO MAKE THE HEART PROBLEMS/ ELDERLY FEMALE HEART PROBLEMS CHIEF DAVENPORT ADV SEND FIRE WAS VERY COOPERATIVE IN ANSWERING QUESTIONS");

    doTest("T5",
        "(IPS I/Page Notification) Location: @24 I64W TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:08:10 Comments:  SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT ** Case number 7713000100 has been assigned for 77:CNTY ** >>>> by: ANITA BILYEU on terminal: 911ms27 ",
        "ADDR:24 I-64W",
        "MADDR:24 I 64",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:15:08:10",
        "INFO:SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT");

    doTest("T6",
        "(IPS I/Page Notification) Location: @24 I64W TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 15:08:10 Comments:  SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT ** Case number 7713000100 has been assigned for 77:CNTY ** >>>> by: ANITA BILYEU on terminal: 911ms27 ",
        "ADDR:24 I-64W",
        "MADDR:24 I 64",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:15:08:10",
        "INFO:SPECIAL ADDRESS COMMENT: IN SHELBY COUNTY ***25MM I64W REQ EASTWOOD FIRE FOR INJURY ACCIDENT NOT ABLE TO ADV OF ANY EXTENT");

    doTest("T7",
        "(IPS I/Page Notification) Location: 3306 PROTEGE PL LVIL TYPE CODE: FIRE SUB TYPE: FIELD/GRASS/BRSH TIME: 21:03:29 Comments:  CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT ** Case number 2013000113 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000099 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 FIRE 5 ",
        "ADDR:3306 PROTEGE PL",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:FIELD/GRASS/BRSH",
        "TIME:21:03:29",
        "INFO:CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT");

    doTest("T8",
        "(IPS I/Page Notification) Location: 3306 PROTEGE PL LVIL TYPE CODE: FIRE SUB TYPE: FIELD/GRASS/BRSH TIME: 21:03:29 Comments:  CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT ** Case number 2013000113 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000099 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:3306 PROTEGE PL",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:FIELD/GRASS/BRSH",
        "TIME:21:03:29",
        "INFO:CORN FIELD ON FIRE CLLER ADV FIRE NOW OUT");

    doTest("T9",
        "(IPS I/Page Notification) Location: 1202 ISLEWORTH DR LVIL TYPE CODE: FIRE SUB TYPE: RESIDENTIAL TIME: 20:09:31 Comments:  FLAMES COMING FROM BACK OF HOUSE COMP IS NEIGHBOR BEHIND HIM, ADV NO ONE IS HOME NOW ** Case number 9913000364 has been assigned for 99:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 2013000112 has been assigned for 20:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 7713000098 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:1202 ISLEWORTH DR",
        "CITY:LOUISVILLE",
        "CODE:FIRE",
        "CALL:RESIDENTIAL",
        "TIME:20:09:31",
        "INFO:FLAMES COMING FROM BACK OF HOUSE COMP IS NEIGHBOR BEHIND HIM, ADV NO ONE IS HOME NOW");

    doTest("T10",
        "(IPS I/Page Notification) Location: 16412 TAUNTON VALE RD LVIL TYPE CODE: ALARM SUB TYPE: RESIDENTIAL TIME: 19:34:09 Comments:  KEYPAD FIRE PANIC ** Case number 7713000097 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ** Case number 9913000361 has been assigned for 99:CNTY PREM NM EDDIE AND ANGIE ESCAMILLA, PREM PH 832-563-3070 ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:16412 TAUNTON VALE RD",
        "CITY:LOUISVILLE",
        "CODE:ALARM",
        "CALL:RESIDENTIAL",
        "TIME:19:34:09",
        "INFO:KEYPAD FIRE PANIC");

    doTest("T11",
        "(IPS I/Page Notification) Location: FLAT ROCK RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:13:35 Comments:  ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s). ** Case number 7713000096 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 Duplicate Event:Location = 503 FLAT ROCK RD LVIL, Cross Street 1 = GLEN LAKES VEH VS POLE DR, Cross Street 2 = TURTLE CREEK TRL, Type = 1049 NON INJ ACCI, Subtype = default, Caller Name = MRS HANLON, Caller Ph Number = (502) 245-9571, Caller IN FRONT OF LOC Address = 503 FLAT ROCK RD LOUISVILLE, Call Source = ANI/ALI, Alarm Level = 1 WHITE PU End of Duplicate Event data FIRE 5 119A MID 3 SINGLE VEH ROLLOVER, PT OUT AND WALKING AROUND BLOODY NOSE ",
        "ADDR:FLAT ROCK RD & SHELBYVILLE RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:18:13:35",
        "INFO:ROLLOVER / You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s).");

    doTest("T12",
        "(IPS I/Page Notification) Location: FLAT ROCK RD/SHELBYVILLE RD LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 18:13:35 Comments:  ROLLOVER ProQA dispatch code: 29D02 Responder script: You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s). ** Case number 7713000096 has been assigned for 77:CNTY ** >>>> by: HEATHER WATSON on terminal: 911ms26 ",
        "ADDR:FLAT ROCK RD & SHELBYVILLE RD",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:18:13:35",
        "INFO:ROLLOVER / You are responding to a patient injured in a traffic incident. The patient is a 40-year-old male, who is conscious and breathing. HIGH MECHANISM (k through s). HIGH MECHANISM (k through s).");

    doTest("T13",
        "(IPS I/Page Notification) Location: 100 HUNTINGTON RIDGE DR MTWN TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 08:52:03 Comments:  GOODWILL 489-8344, GENERAL, WILL NTFY, PERMIT--NONE, REF--0838090 ** Case number 9913000354 has been assigned for 99:CNTY ** >>>> by: STEPHANIE ASHBY on terminal: 911ms21 ** Case number 7713000095 has been assigned for 77:CNTY ** >>>> by: STEPHANIE ASHBY on terminal: 911ms21 ",
        "ADDR:100 HUNTINGTON RIDGE DR",
        "CITY:MIDDLETOWN",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:08:52:03",
        "INFO:GOODWILL 489-8344, GENERAL, WILL NTFY, PERMIT--NONE, REF--0838090");

    doTest("T14",
        "(IPS I/Page Notification) Location: 100 HUNTINGTON RIDGE DR MTWN: GOODWILL TYPE CODE: ALARM SUB TYPE: COMMERCIAL TIME: 04:48:21 Comments:  502-489-8344, GENERAL FIRE, NTFY ** Case number 9913000352 has been assigned for 99:CNTY ** >>>> by: TRAVIS BROWN on terminal: 911ms21 ** Case number 7713000094 has been assigned for 77:CNTY ** >>>> by: TRAVIS BROWN on terminal: 911ms21 ",
        "ADDR:100 HUNTINGTON RIDGE DR",
        "CITY:MIDDLETOWN",
        "PLACE:GOODWILL",
        "CODE:ALARM",
        "CALL:COMMERCIAL",
        "TIME:04:48:21",
        "INFO:502-489-8344, GENERAL FIRE, NTFY");

    doTest("T15",
        "(IPS I/Page Notification) Location: 2405 CRYSTAL SPRINGS PL LVIL TYPE CODE: MEDICAL SUB TYPE: MED_CALL TIME: 02:28:37 Comments:  SOA ProQA dispatch code: 06D02 Responder script: You are responding to a patient with breathing problems. The patient is a 65-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. 65 Y/O FEMALE, SOA ** Case number 7713000093 has been assigned for 77:CNTY ** >>>> by: DEANNA WETTER on terminal: 911ms21 ",
        "ADDR:2405 CRYSTAL SPRINGS PL",
        "CITY:LOUISVILLE",
        "CODE:MEDICAL",
        "CALL:MED_CALL",
        "TIME:02:28:37",
        "INFO:SOA / You are responding to a patient with breathing problems. The patient is a 65-year-old female, who is conscious and breathing. DIFFICULTY SPEAKING BETWEEN BREATHS. DIFFICULTY SPEAKING BETWEEN BREATHS. 65 Y/O FEMALE, SOA");

  }
  
  @Test
  public void testProspectPolice() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 9200 U S HIGHWAY 42 PRO: @PROSPECT POLICE DEPARTMENT TYPE CODE: SC1021 SUB TYPE: default TIME: 22:23:48 ",
        "ADDR:9200 US HIGHWAY 42",
        "MADDR:9200 US 42",
        "CITY:PROSPECT",
        "PLACE:PROSPECT POLICE DEPARTMENT",
        "CODE:SC1021",
        "TIME:22:23:48");

    doTest("T2",
        "(IPS I/Page Notification) Location: 6410 DEEP CREEK DR PRO TYPE CODE: SC1041 SUB TYPE: default TIME: 21:03:57 Comments:  SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK ",
        "ADDR:6410 DEEP CREEK DR",
        "CITY:PROSPECT",
        "CODE:SC1041",
        "TIME:21:03:57",
        "INFO:SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK");

    doTest("T3",
        "(IPS I/Page Notification) Location: 6410 DEEP CREEK DR PRO TYPE CODE: SC1041 SUB TYPE: default TIME: 21:03:57 Comments:  SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK ",
        "ADDR:6410 DEEP CREEK DR",
        "CITY:PROSPECT",
        "CODE:SC1041",
        "TIME:21:03:57",
        "INFO:SOMEONE JUST RAN OVER HIS MAIBOX *MAILBOX FORD FOCUS DARK 4DR YOUNG FEMALE DRIVER WENT DOWN HILL ON DEEP CREEK");

    doTest("T4",
        "(IPS I/Page Notification) Location: @CAL TYPE CODE: SC1021 SUB TYPE: default TIME: 16:32:09 Comments:  HAS QUESTIONS ABOUT REPORT SHE FILED AGAINST HER HUSBAND ",
        "ADDR:CAL",
        "CODE:SC1021",
        "TIME:16:32:09",
        "INFO:HAS QUESTIONS ABOUT REPORT SHE FILED AGAINST HER HUSBAND");

    doTest("T5",
        "(IPS I/Page Notification) Location: 7206 COVERED BRIDGE RD PRO TYPE CODE: SC1021 SUB TYPE: default TIME: 16:06:49 Comments:  IRT REPORT OF VEH HITTING HIS HOUSE ON 12/15 ",
        "ADDR:7206 COVERED BRIDGE RD",
        "CITY:PROSPECT",
        "CODE:SC1021",
        "TIME:16:06:49",
        "INFO:IRT REPORT OF VEH HITTING HIS HOUSE ON 12/15");

    doTest("T6",
        "(IPS I/Page Notification) Location: @CAL:WYTHE HILL CIR TYPE CODE: SC1036 SUB TYPE: VEHICLE TIME: 14:31:16 ",
        "ADDR:CAL",
        "PLACE:WYTHE HILL CIR",
        "CODE:SC1036",
        "CALL:VEHICLE",
        "TIME:14:31:16");

    doTest("T7",
        "(IPS I/Page Notification) Location: PINE KNOLL CIR/FOX MEADOW WAY PRO TYPE CODE: SC1054 SUB TYPE: default TIME: 11:51:02 Comments:  CHOC LAB ROAMING AROUND NO TAGS ",
        "ADDR:PINE KNOLL CIR & FOX MEADOW WAY",
        "CITY:PROSPECT",
        "CODE:SC1054",
        "TIME:11:51:02",
        "INFO:CHOC LAB ROAMING AROUND NO TAGS");

    doTest("T8",
        "(IPS I/Page Notification) Location: 5609 TIMBER RIDGE DR PRO TYPE CODE: SC1037 SUB TYPE: default TIME: 11:46:12 Comments:  VIA 911 ACTIVE FIGHT 2 MALES A FEM IRT A DOG BITING A SUBJ NO WEAPONS ",
        "ADDR:5609 TIMBER RIDGE DR",
        "CITY:PROSPECT",
        "CODE:SC1037",
        "TIME:11:46:12",
        "INFO:VIA 911 ACTIVE FIGHT 2 MALES A FEM IRT A DOG BITING A SUBJ NO WEAPONS");

    doTest("T9",
        "(IPS I/Page Notification) Location: 4002 HARRODS LANDING DR PRO TYPE CODE: SC1035 SUB TYPE: AUDIBLE TIME: 05:21:08 Comments:  DOWNSTAIRS WINDOWS ATTEMPTED TO CONTACT NO ANSWER ",
        "ADDR:4002 HARRODS LANDING DR",
        "CITY:PROSPECT",
        "CODE:SC1035",
        "CALL:AUDIBLE",
        "TIME:05:21:08",
        "INFO:DOWNSTAIRS WINDOWS ATTEMPTED TO CONTACT NO ANSWER");

    doTest("T10",
        "(IPS I/Page Notification) Location: 6508 GUNPOWDER LN PRO TYPE CODE: SC1033 SUB TYPE: default TIME: 03:02:47 Comments:  COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN ",
        "ADDR:6508 GUNPOWDER LN",
        "CITY:PROSPECT",
        "CODE:SC1033",
        "TIME:03:02:47",
        "INFO:COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN");

  }
  
  @Test
  public void testGraymoorDevondale() {

    doTest("T1",
        "(IPS I/Page Notification) Location: 114 WOOD RD LYND TYPE CODE: SC1036 SUB TYPE: VEHICLE TIME: 12:09:13 Comments:  COMLP ADV WHT CARGO VAN WITH DRK TINTED WINDOWS DRIVING AROUND NEIGHBORHOOD SLOWING DOWN LOOKING AT HOUSES COMPL REQ OFC TO RIDE THRU AREA NO 1042 ",
        "ADDR:114 WOOD RD",
        "CITY:LYNDON",
        "CODE:SC1036",
        "CALL:VEHICLE",
        "TIME:12:09:13",
        "INFO:COMLP ADV WHT CARGO VAN WITH DRK TINTED WINDOWS DRIVING AROUND NEIGHBORHOOD SLOWING DOWN LOOKING AT HOUSES COMPL REQ OFC TO RIDE THRU AREA NO 1042");

    doTest("T2",
        "(IPS I/Page Notification) Location: 1500 LYNN WAY GMOR: @GRAYMOOR POLICE DEPARTMENT TYPE CODE: SC1021 SUB TYPE: default TIME: 09:46:41 Comments:  IN REF TO SOME POSS GUNSHOTS FIRED LAST NIGHT ",
        "ADDR:1500 LYNN WAY",
        "CITY:GRAYMOOR-DEVONDALE",
        "PLACE:GRAYMOOR POLICE DEPARTMENT",
        "CODE:SC1021",
        "TIME:09:46:41",
        "INFO:IN REF TO SOME POSS GUNSHOTS FIRED LAST NIGHT");

    doTest("T3",
        "(IPS I/Page Notification) Location: BROWNSBORO RD/N HUBBARDS LN WHIL TYPE CODE: SC1048 SUB TYPE: default TIME: 09:35:47 Comments:  LINCOLN NAVIGATOR ",
        "ADDR:BROWNSBORO RD & N HUBBARDS LN",
        "CITY:WINDY HILLS",
        "CODE:SC1048",
        "TIME:09:35:47",
        "INFO:LINCOLN NAVIGATOR");

    doTest("T4",
        "(IPS I/Page Notification) Location: 1918 BUTTONWOOD RD GMOR TYPE CODE: SC1021 SUB TYPE: default TIME: 08:36:13 Comments:  IN REF TO SOME PARKING PERMITS FOR THE STREET ",
        "ADDR:1918 BUTTONWOOD RD",
        "CITY:GRAYMOOR-DEVONDALE",
        "CODE:SC1021",
        "TIME:08:36:13",
        "INFO:IN REF TO SOME PARKING PERMITS FOR THE STREET");

    doTest("T5",
        "(IPS I/Page Notification) Location: 1504 APPLEWOOD LN GMOR TYPE CODE: SC1036 SUB TYPE: PERSON TIME: 18:09:19 Comments:  BETWEEN OXTED/WESTPORT RD WM LONG WHT HAIR HOLDING A CROBAR UNK IF WENT DOWN OXTED OR STAYED ON OXTED WEARING ALL BLK ",
        "ADDR:1504 APPLEWOOD LN",
        "CITY:GRAYMOOR-DEVONDALE",
        "CODE:SC1036",
        "CALL:PERSON",
        "TIME:18:09:19",
        "INFO:BETWEEN OXTED/WESTPORT RD WM LONG WHT HAIR HOLDING A CROBAR UNK IF WENT DOWN OXTED OR STAYED ON OXTED WEARING ALL BLK");

    doTest("T6",
        "(IPS I/Page Notification) Location: 6508 GUNPOWDER LN PRO TYPE CODE: SC1033 SUB TYPE: default TIME: 03:06:40 Comments:  COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN ANOTHER SON IN UPSTAIRS BEDROOM NUMBER 403-7201 NUMBER IS FOR SON MOTHER IS ON HER WAY TO LOCATION IN A BUICK STATION WAGON 5 MIN ETA ",
        "ADDR:6508 GUNPOWDER LN",
        "CITY:PROSPECT",
        "CODE:SC1033",
        "TIME:03:06:40",
        "INFO:COMP NOT AT LOC SON IS IN BASEMENT, ADV SOMEONE IS BREAKING IN KITCHEN ANOTHER SON IN UPSTAIRS BEDROOM NUMBER 403-7201 NUMBER IS FOR SON MOTHER IS ON HER WAY TO LOCATION IN A BUICK STATION WAGON 5 MIN ETA");

    doTest("T7",
        "(IPS I/Page Notification) Location: 10003 WHIPPS MILL RD LVIL TYPE CODE: SC1032 SUB TYPE: CIT TIME: 02:01:44 Comments:  HER FRIEND;S HUSBAND IS THREATENING SUICIDE- IS ARMED W. A KNIFE - FRIEND IS TEXTING THIS INFO HUSBAND IS 28 YOA WM, INTOX ON RX MEDS, JARRED RIFFE, - WIFE NAME IS JESSICA - SHE AT LOC W/ HER HUSBAND SUSP HAS HX OF MENTAL ILLNESS- DEPRESSION AND ANXIETY- THERE ARE 2 CHILDREN INSIDE THE HOME- JESSICA'S CB IS 439-7152 F JUST TEXTED COMPL SHE WAS AFRAID TO LEAVE THE ROOM TO OPEN DOOR F ADVS THE SIDE DOOR IS UNLOCK- IT IS LOCATED OFF THE DRIVEWAY GM112 ",
        "ADDR:10003 WHIPPS MILL RD",
        "CITY:LOUISVILLE",
        "CODE:SC1032",
        "CALL:CIT",
        "TIME:02:01:44",
        "INFO:HER FRIEND;S HUSBAND IS THREATENING SUICIDE- IS ARMED W. A KNIFE - FRIEND IS TEXTING THIS INFO HUSBAND IS 28 YOA WM, INTOX ON RX MEDS, JARRED RIFFE, - WIFE NAME IS JESSICA - SHE AT LOC W/ HER HUSBAND SUSP HAS HX OF MENTAL ILLNESS- DEPRESSION AND ANXIETY- THERE ARE 2 CHILDREN INSIDE THE HOME- JESSICA'S CB IS 439-7152 F JUST TEXTED COMPL SHE WAS AFRAID TO LEAVE THE ROOM TO OPEN DOOR F ADVS THE SIDE DOOR IS UNLOCK- IT IS LOCATED OFF THE DRIVEWAY GM112");

    doTest("T8",
        "(IPS I/Page Notification) Location: 7508 WESTDALE RD GMOR TYPE CODE: SC1054 SUB TYPE: default TIME: 21:33:16 Comments:  COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA ",
        "ADDR:7508 WESTDALE RD",
        "CITY:GRAYMOOR-DEVONDALE",
        "CODE:SC1054",
        "TIME:21:33:16",
        "INFO:COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA");

    doTest("T9",
        "(IPS I/Page Notification) Location: 12609 TAYLORSVILLE RD LVIL:PNC BANK TYPE CODE: SC1034 SUB TYPE: ALARM TIME: 21:43:05 Comments:  DURESS SILENT ON OPEN NTFY PER# - 53262 P4 PD3 TCIS / ROBBERY 941 OK ",
        "ADDR:12609 TAYLORSVILLE RD",
        "CITY:LOUISVILLE",
        "PLACE:PNC BANK",
        "CODE:SC1034",
        "CALL:ALARM",
        "TIME:21:43:05",
        "INFO:DURESS SILENT ON OPEN NTFY PER# - 53262 P4 PD3 TCIS / ROBBERY 941 OK");

    doTest("T10",
        "(IPS I/Page Notification) Location: 7508 WESTDALE RD GMOR TYPE CODE: SC1054 SUB TYPE: default TIME: 21:33:16 Comments:  COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA ",
        "ADDR:7508 WESTDALE RD",
        "CITY:GRAYMOOR-DEVONDALE",
        "CODE:SC1054",
        "TIME:21:33:16",
        "INFO:COMP ADV SOMEONE SHOT BB GUN AT BACK WINDOW COMP DOES NOT WANT 10-42 COMP DOES NOT WANT 10-21 NO VISIBLE PROPERTY DAMAGE COMP ADV JUST WANTS AN OFC TO SEARCH THE AREA");

  }
  
  public static void main(String[] args) {
    new KYLouisvilleParserTest().generateTests("T1");
  }
}