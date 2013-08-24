package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Josephine County, OR
Contact: KEVIN HARRIS <kev911er@msn.com>
Sender: Dispatch@Pacific.com

S:!  M:Electrical Fire: 613 SW WESTERN AVE B , Grants Pass:  \n1/6/2013 12:29:06 AM: 208791: 7317, 7553, 7400: SMELLING WHAT SMELLS LIKE AN ELECTRICAL PROBLEM\nHAZE INSIDE..
S:!  M:Commercial Fire: 115 SW H ST, Grants Pass:  \n1/5/2013 9:17:02 PM: 208791: 7307, 7309, 7328, FA1, 7501, 7553, 161, 7531, 7353: AUDIBLE 2 HITS\nUPSTAIRS MOTION \nRP PENDING \n*RP:  BUD HOPSO..
S:!  M:TA1R - Traffic Accident Rollov: 5098 NEW HOPE RD, Grants Pass:  \n1/6/2013 12:09:35 AM: 201841: 7551, M1: JOSH MAIN 541-660-9673\nVEH ROLLED \nVEH IN THE DITCH\nIN THE ..
S:!  M:TA1R - Traffic Accident Rollov: 13000 REDWOOD HWY, Wilderville:  \n1/10/2013 7:48:12 AM: 204991: 7514, 7555: 
S:!  M:TA1R - Traffic Accident Rollov: 4520 JUMP OFF JOE CREEK RD, Grants Pass:  \n1/10/2013 10:44:44 AM: 108252: 7512, 7555, M3 : HE TOLD CALLER HE WAN'T INJURIED\n19 YOA MALE\nBETWEEN AND TH..
S:!  M:TA1R - Traffic Accident Rollov: 3279 FISH HATCHERY RD, Grants Pass:  \n1/10/2013 11:10:24 AM: 204991: 7514, 7551, M1: GREEN CAR
S:!  M:Large Vehicle Fire: 785 WILDERVILLE LN, Grants Pass:  \n1/10/2013 9:35:09 PM: 204991: 7309, 7514, 7541, 7551, 7200, COFD: 
S:!  M:Structure Fire: 1730 NE FOOTHILL BLVD, Grants Pass:  \n1/8/2013 3:33:58 PM: 308791: 7307, 7308, 7309, FA5, 7553, M12, 7531, 7353: WHITE SMOKE FROM ATTIC\nDOESN'T BELIEVE THEY HAVE A WOOD STO..
S:!  M:TA1 - Traffic Accident: WILLIAMS HWY@ SW GRANDVIEW AVE , Grants Pass:  \n1/12/2013 9:17:18 AM: 201897: 7501, 7553, M1, 171: single veh into pole
S:!  M:Grass Fire: ROUNDS AVE@ REDWOOD AVE , Grants Pass:  \n1/12/2013 6:45:11 PM: 109411: 7514, 7553, 7200, COFD: TREE ON FIRE
S:!  M:Grass Fire: 3345 REDWOOD HWY, Grants Pass: Rogue Community College \n2/12/2013 12:34:01 PM: 304911: 7309, 7541, 7555, 7200, COFD: 1 MILE UP BEHIND RCC\nIN THE MOUNTAIN\nSMOKE AND FLAMES\nTREES..\n
S:!  M:Water Rescue: LAT: 42.5639, LON: -123.57, Merlin:  \n4/12/2013 3:28:18 PM: ODF: 7512, 7553, M2: N OF ENNIS RIPPLE\nBOAT IS CAPSIZED\nYELLOW OR TAN\nDOESN'T SE..\n
S:!  M:UK1 - Unknown Medical Problem: 1640 WILLIAMS HWY, Grants Pass: Safeway South Grocery Store \n5/3/2013 7:28:05 PM: 201897:   7308, 7501, M1: BETWEEN SAFEWAY AND RITE AID\n18-20 YEAR OLD FEMALE\nDOUBLED ..\n
S:!  M:UN1 - Unconscious/Fainting: 1400 REDWOOD CIR 128 , Grants Pass: Emeritus Spring Pointe Care - Alzheimer \n5/14/2013 9:30:54 AM: 109187: 7511: unresponsive female\nblood in her vomit\n80's female\nroom 128

Contact: dennishoke34 <dennishoke34@gmail.com>
Sender: Dispatch@Pacific.com

S:!  M:3/21/2013 10:59:31 AM  BR1 - Breathing Problem/Chokin \n1938 REEVES CREEK RD 12 , Selma  38-8-25 RD / 38-8-13 RD, S SHORE DR\nUnits:8932, M4, 8900  \nDIFF BREATH\nMALE\nCONS\nFEELS LIKE HE IS ABOUT TO PASS OUT\nDIFF SPEAKING   \n\n
S:!  M:3/21/2013 11:33:27 AM  Lift Assist \n211 BARLOW ST, Cave Junction  SHERWOOD AVE / S JUNCTION AVE\nUnits:8931, 8900  \nLIFT ASSIST\nMALE\nJUST HAD TOES AMPUTATED\n87 YOM \nCONS/BREATH    \n\n
S:!  M:3/22/2013 11:53:33 AM  TR3 - Traumatic Injury \nINDIAN CREEK RD@ DRAPER VALLEY RD , Selma  No Cross Streets Found\nUnits:8932, M4, 8900  \n54 YO MALE\nCON/BREATHING\nUPPER LEG\nINDIAND CREEK LOGGING OPERATION   \n\n
S:!  M:3/22/2013 2:24:54 AM  Lift Assist \n222 OLLIS RD 72 , Cave Junction  W RIVER ST / DEAD END\nUnits:8931, 8951, 8953  \nNO INJURED \n79YOM\nC/B \nREF: 143336848\nPH: 541-592-3704\nWIFE OS: MICHELLE  AND J..   \n\n
S:!  M:3/23/2013 1:20:30 PM  TA2 - Traffic Accident Lane Bl \n18092 REDWOOD HWY, Selma  DRAPER VALLEY RD / CLEAR CREEK RD\nUnits: 8932, 8900  \nHAS NOT TALKED TO ANY DRIVERS\nIN THE DITCH\nFULL SIZE VAN WHITE \nNOT ABLE TO SEE..   \n\n
S:!  M:3/24/2013 5:31:07 AM  CH1 - Chest Pain/Heart Problem \n2604 CHAPMAN CREEK RD 1/2 , Cave Junction  UNKNOWN / CAVES HWY\nUnits:8931, 8900  \nPOSS HEART ATTACK \nDIFF BREATH \nNUMBS DOWN TO HANDS \nLEGS CRAMPED \nCHEST PAIN
S:!  M:4/8/2013 8:01:19 PM  UN1 - Unconscious/Fainting \n750 LOGAN CUT DR, Cave Junction  DEAD END / SIMMONS CUT DR\nUnits:8931,M4, 8900  \n65 YEAR OLD MALE FELL - NOT AWAKE\nHE'S BREATHING   \n\n
S:!  M:4/9/2013 4:07:17 PM  TA1 - Traffic Accident \n4000 REDWOOD HWY, Grants Pass  DAWN DR / MIDWAY AVE\nUnits:M4, 8900  \n   \n\n

Contact: Active911
Agency name: Rural/Metro Fire Department
Location: Grants Pass, OR, United States
Sender: Dispatch@Pacific.com

(! ) 834: TA1R - Traffic Accident Rollov: 1761 PLEASANT VALLEY RD, Merlin:  \n7500: 7/19/2013 9:06:36 PM:7307, 7512, 7553, M2: ROLLOVER\n1 PASS\nHE IS CON\nHE IS BREATHING\nNOT ON FIRE\nNOT R..
(! ) 829: Outdoor Smoke/Odor: 3100 MERLIN RD, Grants Pass:  \n: 7/19/2013 8:52:25 PM:7512: OLD FIRE IS STARTING TO SMOKE AGAIN\nGRY IN COLOR\nSOMEONE IS..
(! ) 725: Grass Fire: 14615 WATERGAP RD, Williams:  \n8700: 7/19/2013 2:13:46 PM:7352, 7357, 7368, 8962, 7511, 7514, 7541, 7542, 7547, 7551, 7555, M8, 8579, 8741, 8750, 8751, 8762, 8541, 8544, 8711, 8554: COLUMB OF SMOKE\nTOWARD JACKSONVILLE\nBACK OF..
(! ) 725: Grass Fire: 14615 WATERGAP RD, Williams:  \n8700: 7/19/2013 2:13:46 PM:7511, 8750, 8751, 8762, 8541, 8544: COLUMB OF SMOKE\nTOWARD JACKSONVILLE\nBACK OF..
(! ) 634: Fire Alarm: 625 BARBARA DR, Grants Pass: Forest Meadows \n7500: 7/19/2013 6:58:41 AM:7501: front door pull station
(! ) 486: Small Vehicle Fire: 1420 BROOKSIDE BLVD, Grants Pass: Josephine County Animal Control \n7500: 7/18/2013 2:25:43 PM:7502, 7553, 7200, COFD: CHEVY PICK UP ON FIRE\nCATCHING FIELD ON FIRE
(! ) 451: ST1 - Stroke: 240 NATURESCAPE RD, Grants Pass:  \n7500: 7/18/2013 12:37:44 PM:7511, M2: CAD WAS DOWN\nCALL TAKER R HAER AND DISPATCHER R HERNDON\n71 ..
(! ) 440: Lift Assist: 1973 HUGO RD, Merlin:  \n7500: 7/18/2013 11:28:57 AM:7512: 
(! ) 370: Fire Alarm - Commercial: 971 SE 6TH ST, Grants Pass: Taprock Northwest Grill Restaurant \n7300: 7/17/2013 10:12:28 PM:7328, 7501, 7353: KITCHEN ANSUL SYSTEM\nTAPROCK
(! ) 250: SZ1 - Seizures/Convulsions: 600 DUTCHY WAY, Grants Pass:  \n7500: 7/17/2013 12:30:52 PM:7514, M4: 58 YEAR OLD FEMALE IN A CONTINUOUS SEIZURE\nSHE DOES HAVE A ..
(! ) 236: TA2 - Traffic Accident Lane Bl: RIVERBANKS RD@ EAGLES VIEW DR , Grants Pass:  \n7500: 7/17/2013 11:32:59 AM:7514, M3: COMPL CAN SEE A WRECKED CAR DOWN IN A DITCH\nCAN'T SEE ANYON..
(! ) 219: BR3 - Breathing Problem/Chokin: 5229 REDWOOD AVE, Grants Pass: Jerome Prairie Store \n7500: 7/17/2013 10:37:31 AM:7514, M12: 11 YO MALE, DIFF BREATHNG WHEN HE STANDS UP\nNO XH\nCOLOR IS ..
(! ) 57: UK1 - Unknown Medical Problem: 129 PATRICK RD, Grants Pass:  \n7500: 7/16/2013 5:51:14 PM:7511, M12: HAS BEEN SICK\nHAS BEEN GOING THRU CANCER/RADIATION TREATMENT
(! ) 44: Power Line Problems: NEW HOPE RD@ WILLIAMS HWY , Grants Pass:  \n7500: 7/16/2013 4:54:03 PM:7501, 7200, COFD: VEH GRN GMC UTILITY, PARKED IN THE PARKING LOT\nPOWER DID GO..
(! ) 22: TA2 - Traffic Accident Lane Bl: ROBERTSON BRIDGE RD@ AZALEA DR , Grants Pass:  \n7500: 7/16/2013 3:15:17 PM:7512, M3: 
(! ) 994: CH1 - Chest Pain/Heart Problem: 320 SW RAMSEY AVE, Grants Pass: Crisis Resolution Center - L17 \n7300: 7/16/2013 1:20:05 PM:7308, 7501, M12: 46 YEAR OLD MALE W/ CHEST PAIN
(! ) 980: UK1 - Unknown Medical Problem: 1545 HARBECK RD, Grants Pass: Options for Southern Oregon Harbeck \n7300: 7/16/2013 12:41:44 PM:7308, 7511, M1: subj collapsed at Options\napprox 57 yoa
(! ) 971: CH3 - Chest Pain/Heart Problem: 261 KEEN RD, Grants Pass:  \n7500: 7/16/2013 11:59:28 AM:7511, M12: 62 YOM\nCONS/BREATH NORM\nCOLD CHILSS\nCHILLS\nLIGHT HEADED DIZ..
(! ) 911: BR1 - Breathing Problem/Chokin: 455 ERIC WAY, Grants Pass:  \n: 7/16/2013 6:58:05 AM:7512, M3: 96 YO MALE\nLABORED BREATHING\nNO CHEST PAIN SINCE YESTERDAY,..
(! ) 888: Open Burn-Illegal Materia: 700 MERLIN RD, Grants Pass:  \n7500: 7/16/2013 2:39:50 AM:7502, 7200, COFD: LOG PILE ON FIRE\nUNKNOWN IF IT'S A CONTROLLED BURN OR NOT
(! ) 861: TR0 - Traumatic Injury: 5076 LEONARD RD 100 , Grants Pass: Rogue Rivera Moble Home Park \n7500: 7/15/2013 10:43:39 PM:7514, M1: 85 YEAR OLD FEMALE FELL - HURT HER KNEE\nAWAKE, BREATHING IS..
(! ) 859: Structure Fire: 1700 NE BEVERLY DR, Grants Pass:  \n7300: 7/15/2013 10:38:54 PM:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353: FIRE BEHIND THE I/L\nPOSS THE HOME\nIT'S NEAR HILLCREST AND A..
(! ) 859: Structure Fire: 1701 NE BEVERLY DR, Grants Pass: Cheryl Brown Counseling \n7300: 7/15/2013 10:38:54 PM:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353: FIRE BEHIND THE I/L\nPOSS THE HOME\nIT'S NEAR HILLCREST AND A..
(! ) 815: BR1 - Breathing Problem/Chokin: 4068 NEW HOPE RD, Grants Pass:  \n7500: 7/15/2013 5:26:51 PM:7511, M12: 63 yo male\na month ago cardiac bypass\ncons/with breath diff
(! ) 805: Power Line Problems: 12235 REDWOOD HWY, Wilderville: Kate's Redwood Bar & Grill \n7500: 7/15/2013 5:02:34 PM:7514, 7200, COFD: VEH TIRE BLEW OUT\nNO INJURIES\nVEH HIT BUILDING\nBOAT IS ON T..
(! ) 808: Lift Assist: 3223 CAMP JOY RD, Grants Pass:  \n7500: 7/15/2013 4:57:20 PM:7512: 72 YEAR OLD FEMALE FELL ON THE FRONT DECK\nREQEUSTING FIRE O..
(! ) 800: Fire Assist to Public: 2128 CULLISON RD, Grants Pass:  \n7500: 7/15/2013 4:37:21 PM:7511, 7200, COFD: SOMEONE JUST DROVE BY THE COMPL'S HOME, THREW A PROPANE TAN..
(! ) 788: Fire Alarm: 1100 E PARK ST, Grants Pass:  \n7300: 7/15/2013 3:52:17 PM:7308, 7501, 7353: SMOKE DETECTOR IN THE GARAGE\nHOMEOWNERS: RICHARD AND VICKIE..
(! ) 748: UN1 - Unconscious/Fainting: 874 SUNNY VALLEY LOOP, Wolf Creek:  \n: 7/15/2013 12:44:47 PM:7512, M3: 83 YO FEMALE
(! ) 725: Fire Alarm - Commercial: 339 JUMP OFF JOE CREEK RD, Grants Pass:  \n7500: 7/15/2013 10:30:21 AM:7502, 7200, COFD: general fire signal
(! ) 686: CH1 - Chest Pain/Heart Problem: 609 RED MOUNTAIN DR, Grants Pass:  \n7500: 7/15/2013 4:08:52 AM:7512, M2: HX A FIB\n64 YO M\nSHORT OF BREATH
(! ) 675: AS1 - Assault/Rape/GSW/Stabbin: 265 LAPPLAND DR, Grants Pass:  \n7500: 7/15/2013 1:51:46 AM:7514, M3: REQ TO STAGE IN THE AREA\nVICTIM STATING SHE WAS SHOT\nSUPPOS..
(! ) 611: UN1 - Unconscious/Fainting: 140 OLD STAGE RD, Wolf Creek:  \n7500: 7/14/2013 6:20:23 PM:7512, M3: MALE OFF THE ROADWAY NOT RESPONDING - HE'S OFF TO THE SIDE ..
(! ) 607: Grass Fire: 74 NB I-5: 74 NB I-5 \n7500: 7/14/2013 5:59:38 PM:7502, 7542, 7551, 5904, 7200, COFD: SMOLDERING ON THE SIDE OF THE ROADWAY\nBETWEEN 74-75 NORTHBO..
(! ) 589: Small Vehicle Fire: 3000 REDWOOD HWY, Grants Pass:  \n7300: 7/14/2013 4:00:22 PM:7328, 7511, 7353: ON THE SIDE OF THE ROAD
(! ) 568: Grass Fire: 8131 LOWER RIVER RD, Grants Pass:  \n7500: 7/14/2013 2:40:32 PM:7307, 7506, 7512, 7515, 7541, 7542, 7551: SMALL FIRE EAST SIDE\nFLAMES ARE APPROX 3 FT HIGH\nSPREADING ..
(! ) 568: Grass Fire: 11845 LOWER RIVER RD, Grants Pass: WILDLIFE IMAGES \n7500: 7/14/2013 2:40:32 PM:7307, 7502, 7541, 7551, 7200, COFD: SMALL FIRE EAST SIDE
(! ) 543: UN1 - Unconscious/Fainting: 6101 RIVERBANKS RD, Grants Pass:  \n7500: 7/14/2013 12:18:16 PM:7514, M2: SEMI CONSC, STARING OUT IN TO SPACE\nPOSS HAVING A STROKE\nEL..
(! ) 536: CH1 - Chest Pain/Heart Problem: 1171 ORT LN, Merlin:  \n: 7/14/2013 11:41:16 AM:7512, M12: WITH BREATH DIFF\nNO CARDIAC HX\n41 YO MALE\nNAUSEATED AND BLO..
(! ) 531: Small Vehicle Fire: 76 NB I-5: 76 NB I-5 \n5900: 7/14/2013 11:15:04 AM:5951, 7512, 5904, 5961: JUST BEFORE EXIT 76,\nCAR IS SMOKING REALLY BAD\nEVERYONE OUT..
(! ) 460: BR3 - Breathing Problem/Chokin: 321 SHETLAND DR, Grants Pass:  \n7500: 7/13/2013 10:39:09 PM:7512, M3: ABD PAIN\n83\nYO FEMALE\nCON/DIFF BREATHING\nUPGRADED\nNO CHESTP..
(! ) 419: TA2 - Traffic Accident Lane Bl: 12000 REDWOOD HWY, Wilderville:  \n7500: 7/13/2013 7:38:39 PM:7514, M1: BLK SATURN\nBLOOD ON FACE\nFEMALE IS WANTING AMBULANCE\nNECK P..
(! ) 383: TA2 - Traffic Accident Lane Bl: 8500 GALICE RD, Merlin: Morrison's Lodge \n7500: 7/13/2013 4:21:55 PM:7512, M2: UNK INJURY
(! ) 362: Water Rescue: CHINOOK PARK LN@ GORDON WAY , Grants Pass:  \n7500: 7/13/2013 2:33:20 PM:7308, 7501, 7555, 7531: girl just swept down river\ngirl was found\n11 yo girl\n2ND CA..
(! ) 359: UN1 - Unconscious/Fainting: SLOAN MOUNTAIN LN@ LAPPLAND DR , Grants Pass:  \n7500: 7/13/2013 2:07:42 PM:7514, M1: 300 YARD UP FROM LAPPLAND DR\nMALE IN HIS LATE 60\nLYING ON T..
(! ) 288: Lift Assist: 309 SANDLEWOOD DR, Grants Pass:  \n7500: 7/13/2013 6:59:43 AM:7501: elderly female\ncompl is with hospice\nnot injured
(! ) 281: Trash Fire: 407 SW RAMSEY AVE, Grants Pass:  \n7300: 7/13/2013 6:35:23 AM:7308, 7501: 
(! ) 276: Fire Assist to Public: 71 SB I-5: 71 SB I-5 \n7500: 7/13/2013 5:47:18 AM:7512: 
(! ) 275: Small Vehicle Fire: 162 PLACER RD, Wolf Creek:  \n7500: 7/13/2013 5:06:21 AM:7512, 7555: in the middle of the road\nford pickup truck\nODF ADVISED\nOSP..
(! ) 275: Small Vehicle Fire: 200 PLACER RD, Wolf Creek:  \n7500: 7/13/2013 5:06:21 AM:7502, 7555, 7200, COFD: in the middle of the road\nford pickup truck
(! ) 221: TA1C - Traffic Accident Ped or: REDWOOD HWY@ ELLIOTT CREEK RD , Wilderville:  \n7500: 7/12/2013 10:36:23 PM:7514, M1: 25 YO MALE\nMC\nNO ROADWAY BLOCKAGE\nIN BOUND
(! ) 155: TA2 - Traffic Accident Lane Bl: 50 SB I-5: 50 SB I-5 \n7400: 7/12/2013 5:37:12 PM:7511, M1: TWO VEH, SB SIDE, DEBRIS IN THE RD, VEHICLES OUT OF THE RD
(! ) 49: OB3 - Pregnancy/Childbirth/Mis: 546 JAYNES DR, Grants Pass:  \n7500: 7/12/2013 8:27:16 AM:7511, M1: BABY IS BREATHING W SOME DIFF BREATH\nCHILD WAS BORN 45 MINA..
(! ) 18: ST1 - Stroke: 1700 KELLENBECK AVE 324 , Grants Pass: Country Side Village \n7300: 7/12/2013 4:25:32 AM:7501: MALE SLURRING HIS WORDS\n1925
(! ) 15: CH1 - Chest Pain/Heart Problem: 1270 MARCUS WAY, Grants Pass:  \n7300: 7/12/2013 3:40:06 AM:7307, 7511, M3: 64 YO MALE
(! ) 13: Structure Fire: 1621 ALLEN CREEK RD, Grants Pass:  \n7300: 7/12/2013 2:37:52 AM:7307, 7308, 7309, 7501, 7514, 7553, M1, 160, 155, 188, 7531, 7353: HOUSE ON FIRE\nTHE HOUSE IS ACROSS THE STREET FROM ALBERTSONS
(! ) 13: Structure Fire: 1690 ALLEN CREEK RD, Grants Pass: Albertsons South \n7300: 7/12/2013 2:37:52 AM:7308, 7309, FA4, 7511, 7514, 7553, M1, 7531, 7353: HOUSE ON FIRE\nTHE HOUSE IS ACROSS THE STREET FROM ALBERTSONS
(! ) 983: BR1 - Breathing Problem/Chokin: 2815 JUMP OFF JOE CREEK RD, Grants Pass:  \n7500: 7/11/2013 11:06:54 PM:7512, M2: 70'S YO MALE\nJUST CALLED COMPL\nPT: MALONE, MICHAEL\nHX BREAT..
(! ) 950: Small Vehicle Fire: Sexton Summit NB: Sexton Summit NB \n7500: 7/11/2013 8:48:09 PM:7502, 7553, 7200, COFD: PICK-UP TRUCK PULLING A TRAILER ON FIRE\nFLAMES UNDER THE EN..
(! ) 928: ST1 - Stroke: 1189 ABEGG RD, Merlin:  \n7500: 7/11/2013 7:36:35 PM:7512, M2: 66 YEAR OLD MALE HAVING A STROKE
(! ) 922: Structure Fire: 115 NW MORGAN LN 6 , Grants Pass: Mt View Trailer Park \n7300: 7/11/2013 7:17:51 PM:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\nIT'S C..
(! ) 922: Structure Fire: 115 NW MORGAN LN, Grants Pass: Mt View Trailer Park \n7300: 7/11/2013 7:17:51 PM:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\nIT'S C..
(! ) 922: Structure Fire: NW WASHINGTON BLVD@ NW MORGAN LN , Grants Pass:  \n7300: 7/11/2013 7:17:51 PM:7307, 7308, 7328, FA4, 7501, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\nIT'S C..
(! ) 904: Grass Fire: QUARTZ CREEK RD@ HUGO RD , Merlin:  \n7500: 7/11/2013 5:05:31 PM:7512: REPORTED BY 7512 HEARD FROM ODF LOOKOUT\n572 HAS ID'D A COLU..
(! ) 904: Outdoor Smoke/Odor: QUARTZ CREEK RD@ HUGO RD , Merlin:  \n7500: 7/11/2013 5:05:31 PM:7512: REPORTED BY 7512 HEARD FROM ODF LOOKOUT
(! ) 800: BR1 - Breathing Problem/Chokin: 721 DENVER AVE, Grants Pass:  \n7500: 7/11/2013 6:39:16 AM:7512, M2: 78 YO MALE\nDIFF BREATHING\nIS ON OXYGEN
(! ) 770: Fire Assist to Public: 1980 REGINA WAY, Grants Pass:  \n7300: 7/11/2013 12:09:43 AM:7511, M1: MEDICAL ALARM ACTIVATED\nNO RESPONSE\nHX SHOWS FEMALE\nNOW ANO..
(! ) 766: TA2 - Traffic Accident Lane Bl: 71 NB I-5: 71 NB I-5 \n7500: 7/10/2013 11:28:52 PM:7512, M3: PASS THE FIRST CONSTRUCTION AREA, ON THE SIDE OF THE HILL
(! ) 729: Fire Assist to Public: 11520 REDWOOD HWY, Wilderville:  \n7500: 7/10/2013 7:49:57 PM:7514, M2, 7200, COFD: TALKING ABOUT A FIRE, OXYGEN AND SOMETHING ABOUT HER CHEST
(! ) 682: TA2 - Traffic Accident Lane Bl: WILLIAMS HWY@ FRUITDALE DR , Grants Pass:  \n7300: 7/10/2013 4:25:18 PM:7308, 7511, M12, 147, 163: TWO VEH ACCIDENT\nVEHS ARE IN THE ROADWAY\nUNKNOWN IF ANYONE'..
(! ) 626: Outdoor Smoke/Odor: HARBECK RD@ GRANDVIEW LN , Grants Pass:  \n7300: 7/10/2013 12:30:42 PM:7308, 7501: DEF COLUMN OF SMOKE\nBROWN IN COLOR\nSTARTED TO REALLY GO NOW
(! ) 575: BR3 - Breathing Problem/Chokin: 882 ROGUELEA LN, Grants Pass:  \n7500: 7/10/2013 8:00:41 AM:7511, M2: dizzy, 58 yoa, consc, coherant, br ok\nsleepy\nhx of COPD and..
(! ) 569: BR1 - Breathing Problem/Chokin: 401 BAYARD DR, Grants Pass:  \n7300: 7/10/2013 7:29:07 AM:7308, 7501, M1: DIFF BREATH, ON O2, HX O BREATH PROBLEMS
(! ) 568: AS1 - Assault/Rape/GSW/Stabbin: 233 BARKER DR, Merlin:  \n: 7/10/2013 7:07:04 AM:7512, M2: MALE ON THE LINE\nWAS VERY HARD TO UNDERSTAND\nLISTENING BACK..
(! ) 443: UN1 - Unconscious/Fainting: FISH HATCHERY RD@ BECKY SPRINGS DR , Grants Pass:  \n7500: 7/9/2013 4:49:15 PM:7514, M3: GRY TANK TOP, SHORTS, BACK PACK\nLAYING AT THE SIDE OF THE R..
(! ) 339: ST1 - Stroke: 917 SLEEPY HOLLOW LOOP, Grants Pass:  \n: 7/9/2013 9:29:53 AM:7514, M1: 86 YO FEMALE\nALZEHIMER PT\nSITTING ON THE TOILET AT THIS TIME
(! ) 288: Open Burn-Illegal Materia: ALLEN CREEK RD@ REDWOOD HWY , Grants Pass:  \n7300: 7/8/2013 10:55:21 PM:7501: TEENS HAVE A FIRE IN THE OPEN DRY LOT NEAR I/L\nOPEN FIELD W..
(! ) 206: TA1 - Traffic Accident: 8785 REDWOOD HWY, Wilderville:  \n7500: 7/8/2013 5:10:43 PM:7514, 7591: PULLING PT OUT OF A TRUCK
(! ) 206: TA1 - Traffic Accident: 9000 REDWOOD HWY, Wilderville:  \n7500: 7/8/2013 5:10:43 PM:7514, 7591: PULLING PT OUT OF A TRUCK
(! ) 89: CH3 - Chest Pain/Heart Problem: 1151 SUMMIT LOOP, Grants Pass:  \n7500: 7/8/2013 10:29:52 AM:7511, M12: HEART RATE REALLY HIGH AND FEEL LIKE GOING TO PASS OUT
(! ) 86: UN1 - Unconscious/Fainting: 500 SW RAMSEY AVE, Grants Pass: Three Rivers Community Hospital TRH \n7300: 7/8/2013 10:10:22 AM:7328, 7501, M12: UNABLE TO TALK\nIFO THE ER AT THE HOSPITAL
(! ) 68: Structure Fire: 7501 LOWER RIVER RD, Grants Pass:  \n7500: 7/8/2013 8:35:57 AM:7308, 7501, 7502, 7541, 7542, 7555, 7531, 7200, COFD: right next door\napt
(! ) 28: Fire Assist to Public: 62 SB I-5: 62 SB I-5 \n7500: 7/8/2013 1:48:25 AM:7502, 7200, COFD: 
(! ) 15: CH1 - Chest Pain/Heart Problem: 2922 MERLIN RD 5 , Grants Pass: Shady Acres \n7500: 7/8/2013 12:03:51 AM:7512, M2: HX OF CANCER AND GALL BLADDER PROBLEMS\nNO BLEEDING\nLUKEMIA
(! ) 902: UN3 - Unconscious/Fainting: 62 SB I-5: 62 SB I-5 \n7500: 7/7/2013 12:28:23 PM:7512, M1: FEMALE PASSED OUT\nNO CHEST PAIN\nBREATH SEEMS OKAY\n77 YO F
(! ) 892: Fire Assist to Public: MONUMENT DR@ MERLIN RD , Grants Pass:  \n7500: 7/7/2013 11:11:56 AM:7511: PARTIALLY BLOCKING ROADWAY\nTHQ432
(! ) 892: <New Call>: MONUMENT DR@ MERLIN RD , Grants Pass:  \n7500: 7/7/2013 11:11:56 AM:7511: 
(! ) 883: Outdoor Smoke/Odor: 2000 CHENEY CREEK RD, Grants Pass:  \n7500: 7/7/2013 10:13:15 AM:7514, 7200, COFD: SMALL SMOULDERING CAMP FIRE NOT IN A FIRE PIT\nBURNING\nABOUT..

 */

public class ORJosephineCountyParserTest extends BaseParserTest {
  
  public ORJosephineCountyParserTest() {
    setParser(new ORJosephineCountyParser(), "JOSEPHINE COUNTY", "OR");
  }
  
  @Test
  public void testKevinHarris() {

    doTest("T1",
        "S:!  M:Electrical Fire: 613 SW WESTERN AVE B , Grants Pass:  \n" +
        "1/6/2013 12:29:06 AM: 208791: 7317, 7553, 7400: SMELLING WHAT SMELLS LIKE AN ELECTRICAL PROBLEM\n" +
        "HAZE INSIDE..",

        "CALL:Electrical Fire",
        "ADDR:613 SW WESTERN AVE",
        "APT:B",
        "CITY:Grants Pass",
        "DATE:01/06/2013",
        "TIME:00:29:06",
        "ID:208791",
        "UNIT:7317, 7553, 7400",
        "INFO:SMELLING WHAT SMELLS LIKE AN ELECTRICAL PROBLEM HAZE INSIDE..");

    doTest("T2",
        "S:!  M:Commercial Fire: 115 SW H ST, Grants Pass:  \n" +
        "1/5/2013 9:17:02 PM: 208791: 7307, 7309, 7328, FA1, 7501, 7553, 161, 7531, 7353: AUDIBLE 2 HITS\n" +
        "UPSTAIRS MOTION \n" +
        "RP PENDING \n" +
        "*RP:  BUD HOPSO..",

        "CALL:Commercial Fire",
        "ADDR:115 SW H ST",
        "CITY:Grants Pass",
        "DATE:01/05/2013",
        "TIME:21:17:02",
        "ID:208791",
        "UNIT:7307, 7309, 7328, FA1, 7501, 7553, 161, 7531, 7353",
        "INFO:AUDIBLE 2 HITS UPSTAIRS MOTION RP PENDING *RP BUD HOPSO..");

    doTest("T3",
        "S:!  M:TA1R - Traffic Accident Rollov: 5098 NEW HOPE RD, Grants Pass:  \n" +
        "1/6/2013 12:09:35 AM: 201841: 7551, M1: JOSH MAIN 541-660-9673\n" +
        "VEH ROLLED \n" +
        "VEH IN THE DITCH\n" +
        "IN THE ..",

        "CALL:TA1R - Traffic Accident Rollov",
        "ADDR:5098 NEW HOPE RD",
        "CITY:Grants Pass",
        "DATE:01/06/2013",
        "TIME:00:09:35",
        "ID:201841",
        "UNIT:7551, M1",
        "INFO:JOSH MAIN 541-660-9673 VEH ROLLED VEH IN THE DITCH IN THE ..");

    doTest("T4",
        "S:!  M:TA1R - Traffic Accident Rollov: 13000 REDWOOD HWY, Wilderville:  \n1/10/2013 7:48:12 AM: 204991: 7514, 7555: ",
        "CALL:TA1R - Traffic Accident Rollov",
        "ADDR:13000 REDWOOD HWY",
        "CITY:Wilderville",
        "DATE:01/10/2013",
        "TIME:07:48:12",
        "ID:204991",
        "UNIT:7514, 7555:");

    doTest("T5",
        "S:!  M:TA1R - Traffic Accident Rollov: 4520 JUMP OFF JOE CREEK RD, Grants Pass:  \n" +
        "1/10/2013 10:44:44 AM: 108252: 7512, 7555, M3 : HE TOLD CALLER HE WAN'T INJURIED\n" +
        "19 YOA MALE\n" +
        "BETWEEN AND TH..",

        "CALL:TA1R - Traffic Accident Rollov",
        "ADDR:4520 JUMP OFF JOE CREEK RD",
        "CITY:Grants Pass",
        "DATE:01/10/2013",
        "TIME:10:44:44",
        "ID:108252",
        "UNIT:7512, 7555, M3",
        "INFO:HE TOLD CALLER HE WAN'T INJURIED 19 YOA MALE BETWEEN AND TH..");

    doTest("T6",
        "S:!  M:TA1R - Traffic Accident Rollov: 3279 FISH HATCHERY RD, Grants Pass:  \n" +
        "1/10/2013 11:10:24 AM: 204991: 7514, 7551, M1: GREEN CAR",

        "CALL:TA1R - Traffic Accident Rollov",
        "ADDR:3279 FISH HATCHERY RD",
        "CITY:Grants Pass",
        "DATE:01/10/2013",
        "TIME:11:10:24",
        "ID:204991",
        "UNIT:7514, 7551, M1",
        "INFO:GREEN CAR");

    doTest("T7",
        "S:!  M:Large Vehicle Fire: 785 WILDERVILLE LN, Grants Pass:  \n1/10/2013 9:35:09 PM: 204991: 7309, 7514, 7541, 7551, 7200, COFD: ",
        "CALL:Large Vehicle Fire",
        "ADDR:785 WILDERVILLE LN",
        "CITY:Grants Pass",
        "DATE:01/10/2013",
        "TIME:21:35:09",
        "ID:204991",
        "UNIT:7309, 7514, 7541, 7551, 7200, COFD:");

    doTest("T8",
        "S:!  M:Structure Fire: 1730 NE FOOTHILL BLVD, Grants Pass:  \n" +
        "1/8/2013 3:33:58 PM: 308791: 7307, 7308, 7309, FA5, 7553, M12, 7531, 7353: WHITE SMOKE FROM ATTIC\n" +
        "DOESN'T BELIEVE THEY HAVE A WOOD STO..",

        "CALL:Structure Fire",
        "ADDR:1730 NE FOOTHILL BLVD",
        "CITY:Grants Pass",
        "DATE:01/08/2013",
        "TIME:15:33:58",
        "ID:308791",
        "UNIT:7307, 7308, 7309, FA5, 7553, M12, 7531, 7353",
        "INFO:WHITE SMOKE FROM ATTIC DOESN'T BELIEVE THEY HAVE A WOOD STO..");

    doTest("T9",
        "S:!  M:TA1 - Traffic Accident: WILLIAMS HWY@ SW GRANDVIEW AVE , Grants Pass:  \n" +
        "1/12/2013 9:17:18 AM: 201897: 7501, 7553, M1, 171: single veh into pole",

        "CALL:TA1 - Traffic Accident",
        "ADDR:WILLIAMS HWY & SW GRANDVIEW AVE",
        "CITY:Grants Pass",
        "DATE:01/12/2013",
        "TIME:09:17:18",
        "ID:201897",
        "UNIT:7501, 7553, M1, 171",
        "INFO:single veh into pole");

    doTest("T10",
        "S:!  M:Grass Fire: ROUNDS AVE@ REDWOOD AVE , Grants Pass:  \n1/12/2013 6:45:11 PM: 109411: 7514, 7553, 7200, COFD: TREE ON FIRE",
        "CALL:Grass Fire",
        "ADDR:ROUNDS AVE & REDWOOD AVE",
        "CITY:Grants Pass",
        "DATE:01/12/2013",
        "TIME:18:45:11",
        "ID:109411",
        "UNIT:7514, 7553, 7200, COFD",
        "INFO:TREE ON FIRE");

    doTest("T11",
        "S:!  M:Grass Fire: 3345 REDWOOD HWY, Grants Pass: Rogue Community College \n" +
        "2/12/2013 12:34:01 PM: 304911: 7309, 7541, 7555, 7200, COFD: 1 MILE UP BEHIND RCC\n" +
        "IN THE MOUNTAIN\n" +
        "SMOKE AND FLAMES\n" +
        "TREES..\n",

        "CALL:Grass Fire",
        "ADDR:3345 REDWOOD HWY",
        "CITY:Grants Pass",
        "PLACE:Rogue Community College",
        "DATE:02/12/2013",
        "TIME:12:34:01",
        "ID:304911",
        "UNIT:7309, 7541, 7555, 7200, COFD",
        "INFO:1 MILE UP BEHIND RCC IN THE MOUNTAIN SMOKE AND FLAMES TREES..");

    doTest("T12",
        "S:!  M:Water Rescue: LAT: 42.5639, LON: -123.57, Merlin:  \n" +
        "4/12/2013 3:28:18 PM: ODF: 7512, 7553, M2: N OF ENNIS RIPPLE\n" +
        "BOAT IS CAPSIZED\n" +
        "YELLOW OR TAN\n" +
        "DOESN'T SE..\n",

        "DATE:04/12/2013",
        "TIME:15:28:18",
        "CALL:Water Rescue",
        "ADDR:LAT: 42.5639, LON: -123.57",
        "MADDR:+42.563900,-123.570000",
        "CITY:Merlin",
        "ID:ODF",
        "UNIT:7512, 7553, M2",
        "INFO:N OF ENNIS RIPPLE BOAT IS CAPSIZED YELLOW OR TAN DOESN'T SE..");

    doTest("T13",
        "S:!  M:UK1 - Unknown Medical Problem: 1640 WILLIAMS HWY, Grants Pass: Safeway South Grocery Store \n" +
        "5/3/2013 7:28:05 PM: 201897: 7308, 7501, M1: BETWEEN SAFEWAY AND RITE AID\n" +
        "18-20 YEAR OLD FEMALE\n" +
        "DOUBLED ..\n",

        "DATE:05/03/2013",
        "TIME:19:28:05",
        "CALL:UK1 - Unknown Medical Problem",
        "ADDR:1640 WILLIAMS HWY",
        "CITY:Grants Pass",
        "PLACE:Safeway South Grocery Store",
        "ID:201897",
        "UNIT:7308, 7501, M1",
        "INFO:BETWEEN SAFEWAY AND RITE AID 18-20 YEAR OLD FEMALE DOUBLED ..");

    doTest("T14",
        "S:!  M:UN1 - Unconscious/Fainting: 1400 REDWOOD CIR 128 , Grants Pass: Emeritus Spring Pointe Care - Alzheimer \n" +
        "5/14/2013 9:30:54 AM: 109187: 7511: unresponsive female\n" +
        "blood in her vomit\n" +
        "80's female\n" +
        "room 128",

        "DATE:05/14/2013",
        "TIME:09:30:54",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:1400 REDWOOD CIR",
        "APT:128",
        "CITY:Grants Pass",
        "PLACE:Emeritus Spring Pointe Care - Alzheimer",
        "ID:109187",
        "UNIT:7511",
        "INFO:unresponsive female blood in her vomit 80's female room 128");

  }
  
  @Test
  public void testDennisHoke() {

    doTest("T1",
        "S:!  M:3/21/2013 10:59:31 AM  BR1 - Breathing Problem/Chokin \n" +
        "1938 REEVES CREEK RD 12 , Selma  38-8-25 RD / 38-8-13 RD, S SHORE DR\n" +
        "Units:8932, M4, 8900  \n" +
        "DIFF BREATH\n" +
        "MALE\n" +
        "CONS\n" +
        "FEELS LIKE HE IS ABOUT TO PASS OUT\n" +
        "DIFF SPEAKING   \n\n",

        "TIME:10:59:31",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:1938 REEVES CREEK RD",
        "APT:12",
        "CITY:Selma",
        "X:38-8-25 RD / 38-8-13 RD, S SHORE DR",
        "UNIT:8932, M4, 8900",
        "INFO:DIFF BREATH MALE CONS FEELS LIKE HE IS ABOUT TO PASS OUT DIFF SPEAKING");

    doTest("T2",
        "S:!  M:3/21/2013 11:33:27 AM  Lift Assist \n" +
        "211 BARLOW ST, Cave Junction  SHERWOOD AVE / S JUNCTION AVE\n" +
        "Units:8931, 8900  \n" +
        "LIFT ASSIST\n" +
        "MALE\n" +
        "JUST HAD TOES AMPUTATED\n" +
        "87 YOM \n" +
        "CONS/BREATH    \n\n",

        "TIME:11:33:27",
        "CALL:Lift Assist",
        "ADDR:211 BARLOW ST",
        "CITY:Cave Junction",
        "X:SHERWOOD AVE / S JUNCTION AVE",
        "UNIT:8931, 8900",
        "INFO:LIFT ASSIST MALE JUST HAD TOES AMPUTATED 87 YOM CONS/BREATH");

    doTest("T3",
        "S:!  M:3/22/2013 11:53:33 AM  TR3 - Traumatic Injury \n" +
        "INDIAN CREEK RD@ DRAPER VALLEY RD , Selma  No Cross Streets Found\n" +
        "Units:8932, M4, 8900  \n" +
        "54 YO MALE\n" +
        "CON/BREATHING\n" +
        "UPPER LEG\n" +
        "INDIAND CREEK LOGGING OPERATION   \n\n",

        "TIME:11:53:33",
        "CALL:TR3 - Traumatic Injury",
        "ADDR:INDIAN CREEK RD & DRAPER VALLEY RD",
        "CITY:Selma",
        "X:No Cross Streets Found",
        "UNIT:8932, M4, 8900",
        "INFO:54 YO MALE CON/BREATHING UPPER LEG INDIAND CREEK LOGGING OPERATION");

    doTest("T4",
        "S:!  M:3/22/2013 2:24:54 AM  Lift Assist \n" +
        "222 OLLIS RD 72 , Cave Junction  W RIVER ST / DEAD END\n" +
        "Units:8931, 8951, 8953  \n" +
        "NO INJURED \n" +
        "79YOM\n" +
        "C/B \n" +
        "REF: 143336848\n" +
        "PH: 541-592-3704\n" +
        "WIFE OS: MICHELLE  AND J..   \n\n",

        "TIME:02:24:54",
        "CALL:Lift Assist",
        "ADDR:222 OLLIS RD",
        "APT:72",
        "CITY:Cave Junction",
        "X:W RIVER ST / DEAD END",
        "UNIT:8931, 8951, 8953",
        "INFO:NO INJURED 79YOM C/B REF 143336848 PH 541-592-3704 WIFE OS MICHELLE  AND J..");

    doTest("T5",
        "S:!  M:3/23/2013 1:20:30 PM  TA2 - Traffic Accident Lane Bl \n" +
        "18092 REDWOOD HWY, Selma  DRAPER VALLEY RD / CLEAR CREEK RD\n" +
        "Units: 8932, 8900  \n" +
        "HAS NOT TALKED TO ANY DRIVERS\n" +
        "IN THE DITCH\n" +
        "FULL SIZE VAN WHITE \n" +
        "NOT ABLE TO SEE..   \n\n",

        "TIME:13:20:30",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:18092 REDWOOD HWY",
        "CITY:Selma",
        "X:DRAPER VALLEY RD / CLEAR CREEK RD",
        "UNIT:8932, 8900",
        "INFO:HAS NOT TALKED TO ANY DRIVERS IN THE DITCH FULL SIZE VAN WHITE NOT ABLE TO SEE..");

    doTest("T6",
        "S:!  M:3/24/2013 5:31:07 AM  CH1 - Chest Pain/Heart Problem \n" +
        "2604 CHAPMAN CREEK RD 1/2 , Cave Junction  UNKNOWN / CAVES HWY\n" +
        "Units:8931, 8900  \n" +
        "POSS HEART ATTACK \n" +
        "DIFF BREATH \n" +
        "NUMBS DOWN TO HANDS \n" +
        "LEGS CRAMPED \n" +
        "CHEST PAIN",

        "TIME:05:31:07",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:2604 CHAPMAN CREEK RD",
        "APT:1/2",
        "CITY:Cave Junction",
        "X:UNKNOWN / CAVES HWY",
        "UNIT:8931, 8900",
        "INFO:POSS HEART ATTACK DIFF BREATH NUMBS DOWN TO HANDS LEGS CRAMPED CHEST PAIN");

    doTest("T7",
        " S:!  M:4/8/2013 8:01:19 PM  UN1 - Unconscious/Fainting \n" +
        "750 LOGAN CUT DR, Cave Junction  DEAD END / SIMMONS CUT DR\n" +
        "Units:8931,M4, 8900  \n" +
        "65 YEAR OLD MALE FELL - NOT AWAKE\n" +
        "HE'S BREATHING   \n\n",

        "TIME:20:01:19",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:750 LOGAN CUT DR",
        "CITY:Cave Junction",
        "X:DEAD END / SIMMONS CUT DR",
        "UNIT:8931,M4, 8900",
        "INFO:65 YEAR OLD MALE FELL - NOT AWAKE HE'S BREATHING");

    doTest("T8",
        "S:!  M:4/9/2013 4:07:17 PM  TA1 - Traffic Accident \n4000 REDWOOD HWY, Grants Pass  DAWN DR / MIDWAY AVE\nUnits:M4, 8900  \n   \n\n",
        "TIME:16:07:17",
        "CALL:TA1 - Traffic Accident",
        "ADDR:4000 REDWOOD HWY",
        "CITY:Grants Pass",
        "X:DAWN DR / MIDWAY AVE",
        "UNIT:M4, 8900");
  
  }
  
  @Test
  public void testRuralMetroFireDepartment() {

    doTest("T1",
        "(! ) 834: TA1R - Traffic Accident Rollov: 1761 PLEASANT VALLEY RD, Merlin:  \n" +
        "7500: 7/19/2013 9:06:36 PM:7307, 7512, 7553, M2: ROLLOVER\n" +
        "1 PASS\n" +
        "HE IS CON\n" +
        "HE IS BREATHING\n" +
        "NOT ON FIRE\n" +
        "NOT R..",

        "ID:834",
        "CALL:TA1R - Traffic Accident Rollov",
        "ADDR:1761 PLEASANT VALLEY RD",
        "CITY:Merlin",
        "SRC:7500",
        "DATE:07/19/2013",
        "TIME:21:06:36",
        "UNIT:7307, 7512, 7553, M2",
        "INFO:ROLLOVER 1 PASS HE IS CON HE IS BREATHING NOT ON FIRE NOT R..");

    doTest("T2",
        "(! ) 829: Outdoor Smoke/Odor: 3100 MERLIN RD, Grants Pass:  \n" +
        ": 7/19/2013 8:52:25 PM:7512: OLD FIRE IS STARTING TO SMOKE AGAIN\n" +
        "GRY IN COLOR\n" +
        "SOMEONE IS..",

        "ID:829",
        "CALL:Outdoor Smoke/Odor",
        "ADDR:3100 MERLIN RD",
        "CITY:Grants Pass",
        "DATE:07/19/2013",
        "TIME:20:52:25",
        "UNIT:7512",
        "INFO:OLD FIRE IS STARTING TO SMOKE AGAIN GRY IN COLOR SOMEONE IS..");

    doTest("T3",
        "(! ) 725: Grass Fire: 14615 WATERGAP RD, Williams:  \n" +
        "8700: 7/19/2013 2:13:46 PM:7352, 7357, 7368, 8962, 7511, 7514, 7541, 7542, 7547, 7551, 7555, M8, 8579, 8741, 8750, 8751, 8762, 8541, 8544, 8711, 8554: COLUMB OF SMOKE\n" +
        "TOWARD JACKSONVILLE\n" +
        "BACK OF..",

        "ID:725",
        "CALL:Grass Fire",
        "ADDR:14615 WATERGAP RD",
        "CITY:Williams",
        "SRC:8700",
        "DATE:07/19/2013",
        "TIME:14:13:46",
        "UNIT:7352, 7357, 7368, 8962, 7511, 7514, 7541, 7542, 7547, 7551, 7555, M8, 8579, 8741, 8750, 8751, 8762, 8541, 8544, 8711, 8554",
        "INFO:COLUMB OF SMOKE TOWARD JACKSONVILLE BACK OF..");

    doTest("T4",
        "(! ) 725: Grass Fire: 14615 WATERGAP RD, Williams:  \n" +
        "8700: 7/19/2013 2:13:46 PM:7511, 8750, 8751, 8762, 8541, 8544: COLUMB OF SMOKE\n" +
        "TOWARD JACKSONVILLE\n" +
        "BACK OF..",

        "ID:725",
        "CALL:Grass Fire",
        "ADDR:14615 WATERGAP RD",
        "CITY:Williams",
        "SRC:8700",
        "DATE:07/19/2013",
        "TIME:14:13:46",
        "UNIT:7511, 8750, 8751, 8762, 8541, 8544",
        "INFO:COLUMB OF SMOKE TOWARD JACKSONVILLE BACK OF..");

    doTest("T5",
        "(! ) 634: Fire Alarm: 625 BARBARA DR, Grants Pass: Forest Meadows \n7500: 7/19/2013 6:58:41 AM:7501: front door pull station",
        "ID:634",
        "CALL:Fire Alarm",
        "ADDR:625 BARBARA DR",
        "CITY:Grants Pass",
        "PLACE:Forest Meadows",
        "SRC:7500",
        "DATE:07/19/2013",
        "TIME:06:58:41",
        "UNIT:7501",
        "INFO:front door pull station");

    doTest("T6",
        "(! ) 486: Small Vehicle Fire: 1420 BROOKSIDE BLVD, Grants Pass: Josephine County Animal Control \n" +
        "7500: 7/18/2013 2:25:43 PM:7502, 7553, 7200, COFD: CHEVY PICK UP ON FIRE\n" +
        "CATCHING FIELD ON FIRE",

        "ID:486",
        "CALL:Small Vehicle Fire",
        "ADDR:1420 BROOKSIDE BLVD",
        "CITY:Grants Pass",
        "PLACE:Josephine County Animal Control",
        "SRC:7500",
        "DATE:07/18/2013",
        "TIME:14:25:43",
        "UNIT:7502, 7553, 7200, COFD",
        "INFO:CHEVY PICK UP ON FIRE CATCHING FIELD ON FIRE");

    doTest("T7",
        "(! ) 451: ST1 - Stroke: 240 NATURESCAPE RD, Grants Pass:  \n" +
        "7500: 7/18/2013 12:37:44 PM:7511, M2: CAD WAS DOWN\n" +
        "CALL TAKER R HAER AND DISPATCHER R HERNDON\n" +
        "71 ..",

        "ID:451",
        "CALL:ST1 - Stroke",
        "ADDR:240 NATURESCAPE RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/18/2013",
        "TIME:12:37:44",
        "UNIT:7511, M2",
        "INFO:CAD WAS DOWN CALL TAKER R HAER AND DISPATCHER R HERNDON 71 ..");

    doTest("T8",
        "(! ) 440: Lift Assist: 1973 HUGO RD, Merlin:  \n7500: 7/18/2013 11:28:57 AM:7512: ",
        "ID:440",
        "CALL:Lift Assist",
        "ADDR:1973 HUGO RD",
        "CITY:Merlin",
        "SRC:7500",
        "DATE:07/18/2013",
        "TIME:11:28:57",
        "UNIT:7512:");

    doTest("T9",
        "(! ) 370: Fire Alarm - Commercial: 971 SE 6TH ST, Grants Pass: Taprock Northwest Grill Restaurant \n" +
        "7300: 7/17/2013 10:12:28 PM:7328, 7501, 7353: KITCHEN ANSUL SYSTEM\n" +
        "TAPROCK",

        "ID:370",
        "CALL:Fire Alarm - Commercial",
        "ADDR:971 SE 6TH ST",
        "CITY:Grants Pass",
        "PLACE:Taprock Northwest Grill Restaurant",
        "SRC:7300",
        "DATE:07/17/2013",
        "TIME:22:12:28",
        "UNIT:7328, 7501, 7353",
        "INFO:KITCHEN ANSUL SYSTEM TAPROCK");

    doTest("T10",
        "(! ) 250: SZ1 - Seizures/Convulsions: 600 DUTCHY WAY, Grants Pass:  \n" +
        "7500: 7/17/2013 12:30:52 PM:7514, M4: 58 YEAR OLD FEMALE IN A CONTINUOUS SEIZURE\n" +
        "SHE DOES HAVE A ..",

        "ID:250",
        "CALL:SZ1 - Seizures/Convulsions",
        "ADDR:600 DUTCHY WAY",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/17/2013",
        "TIME:12:30:52",
        "UNIT:7514, M4",
        "INFO:58 YEAR OLD FEMALE IN A CONTINUOUS SEIZURE SHE DOES HAVE A ..");

    doTest("T11",
        "(! ) 236: TA2 - Traffic Accident Lane Bl: RIVERBANKS RD@ EAGLES VIEW DR , Grants Pass:  \n" +
        "7500: 7/17/2013 11:32:59 AM:7514, M3: COMPL CAN SEE A WRECKED CAR DOWN IN A DITCH\n" +
        "CAN'T SEE ANYON..",

        "ID:236",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:RIVERBANKS RD & EAGLES VIEW DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/17/2013",
        "TIME:11:32:59",
        "UNIT:7514, M3",
        "INFO:COMPL CAN SEE A WRECKED CAR DOWN IN A DITCH CAN'T SEE ANYON..");

    doTest("T12",
        "(! ) 219: BR3 - Breathing Problem/Chokin: 5229 REDWOOD AVE, Grants Pass: Jerome Prairie Store \n" +
        "7500: 7/17/2013 10:37:31 AM:7514, M12: 11 YO MALE, DIFF BREATHNG WHEN HE STANDS UP\n" +
        "NO XH\n" +
        "COLOR IS ..",

        "ID:219",
        "CALL:BR3 - Breathing Problem/Chokin",
        "ADDR:5229 REDWOOD AVE",
        "CITY:Grants Pass",
        "PLACE:Jerome Prairie Store",
        "SRC:7500",
        "DATE:07/17/2013",
        "TIME:10:37:31",
        "UNIT:7514, M12",
        "INFO:11 YO MALE, DIFF BREATHNG WHEN HE STANDS UP NO XH COLOR IS ..");

    doTest("T13",
        "(! ) 57: UK1 - Unknown Medical Problem: 129 PATRICK RD, Grants Pass:  \n" +
        "7500: 7/16/2013 5:51:14 PM:7511, M12: HAS BEEN SICK\n" +
        "HAS BEEN GOING THRU CANCER/RADIATION TREATMENT",

        "ID:57",
        "CALL:UK1 - Unknown Medical Problem",
        "ADDR:129 PATRICK RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/16/2013",
        "TIME:17:51:14",
        "UNIT:7511, M12",
        "INFO:HAS BEEN SICK HAS BEEN GOING THRU CANCER/RADIATION TREATMENT");

    doTest("T14",
        "(! ) 44: Power Line Problems: NEW HOPE RD@ WILLIAMS HWY , Grants Pass:  \n" +
        "7500: 7/16/2013 4:54:03 PM:7501, 7200, COFD: VEH GRN GMC UTILITY, PARKED IN THE PARKING LOT\n" +
        "POWER DID GO..",

        "ID:44",
        "CALL:Power Line Problems",
        "ADDR:NEW HOPE RD & WILLIAMS HWY",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/16/2013",
        "TIME:16:54:03",
        "UNIT:7501, 7200, COFD",
        "INFO:VEH GRN GMC UTILITY, PARKED IN THE PARKING LOT POWER DID GO..");

    doTest("T15",
        "(! ) 22: TA2 - Traffic Accident Lane Bl: ROBERTSON BRIDGE RD@ AZALEA DR , Grants Pass:  \n7500: 7/16/2013 3:15:17 PM:7512, M3: ",
        "ID:22",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:ROBERTSON BRIDGE RD & AZALEA DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/16/2013",
        "TIME:15:15:17",
        "UNIT:7512, M3:");

    doTest("T16",
        "(! ) 994: CH1 - Chest Pain/Heart Problem: 320 SW RAMSEY AVE, Grants Pass: Crisis Resolution Center - L17 \n" +
        "7300: 7/16/2013 1:20:05 PM:7308, 7501, M12: 46 YEAR OLD MALE W/ CHEST PAIN",

        "ID:994",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:320 SW RAMSEY AVE",
        "CITY:Grants Pass",
        "PLACE:Crisis Resolution Center - L17",
        "SRC:7300",
        "DATE:07/16/2013",
        "TIME:13:20:05",
        "UNIT:7308, 7501, M12",
        "INFO:46 YEAR OLD MALE W/ CHEST PAIN");

    doTest("T17",
        "(! ) 980: UK1 - Unknown Medical Problem: 1545 HARBECK RD, Grants Pass: Options for Southern Oregon Harbeck \n" +
        "7300: 7/16/2013 12:41:44 PM:7308, 7511, M1: subj collapsed at Options\n" +
        "approx 57 yoa",

        "ID:980",
        "CALL:UK1 - Unknown Medical Problem",
        "ADDR:1545 HARBECK RD",
        "CITY:Grants Pass",
        "PLACE:Options for Southern Oregon Harbeck",
        "SRC:7300",
        "DATE:07/16/2013",
        "TIME:12:41:44",
        "UNIT:7308, 7511, M1",
        "INFO:subj collapsed at Options approx 57 yoa");

    doTest("T18",
        "(! ) 971: CH3 - Chest Pain/Heart Problem: 261 KEEN RD, Grants Pass:  \n" +
        "7500: 7/16/2013 11:59:28 AM:7511, M12: 62 YOM\n" +
        "CONS/BREATH NORM\n" +
        "COLD CHILSS\n" +
        "CHILLS\n" +
        "LIGHT HEADED DIZ..",

        "ID:971",
        "CALL:CH3 - Chest Pain/Heart Problem",
        "ADDR:261 KEEN RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/16/2013",
        "TIME:11:59:28",
        "UNIT:7511, M12",
        "INFO:62 YOM CONS/BREATH NORM COLD CHILSS CHILLS LIGHT HEADED DIZ..");

    doTest("T19",
        "(! ) 911: BR1 - Breathing Problem/Chokin: 455 ERIC WAY, Grants Pass:  \n" +
        ": 7/16/2013 6:58:05 AM:7512, M3: 96 YO MALE\n" +
        "LABORED BREATHING\n" +
        "NO CHEST PAIN SINCE YESTERDAY,..",

        "ID:911",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:455 ERIC WAY",
        "CITY:Grants Pass",
        "DATE:07/16/2013",
        "TIME:06:58:05",
        "UNIT:7512, M3",
        "INFO:96 YO MALE LABORED BREATHING NO CHEST PAIN SINCE YESTERDAY,..");

    doTest("T20",
        "(! ) 888: Open Burn-Illegal Materia: 700 MERLIN RD, Grants Pass:  \n" +
        "7500: 7/16/2013 2:39:50 AM:7502, 7200, COFD: LOG PILE ON FIRE\n" +
        "UNKNOWN IF IT'S A CONTROLLED BURN OR NOT",

        "ID:888",
        "CALL:Open Burn-Illegal Materia",
        "ADDR:700 MERLIN RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/16/2013",
        "TIME:02:39:50",
        "UNIT:7502, 7200, COFD",
        "INFO:LOG PILE ON FIRE UNKNOWN IF IT'S A CONTROLLED BURN OR NOT");

    doTest("T21",
        "(! ) 861: TR0 - Traumatic Injury: 5076 LEONARD RD 100 , Grants Pass: Rogue Rivera Moble Home Park \n" +
        "7500: 7/15/2013 10:43:39 PM:7514, M1: 85 YEAR OLD FEMALE FELL - HURT HER KNEE\n" +
        "AWAKE, BREATHING IS..",

        "ID:861",
        "CALL:TR0 - Traumatic Injury",
        "ADDR:5076 LEONARD RD",
        "APT:100",
        "CITY:Grants Pass",
        "PLACE:Rogue Rivera Moble Home Park",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:22:43:39",
        "UNIT:7514, M1",
        "INFO:85 YEAR OLD FEMALE FELL - HURT HER KNEE AWAKE, BREATHING IS..");

    doTest("T22",
        "(! ) 859: Structure Fire: 1700 NE BEVERLY DR, Grants Pass:  \n" +
        "7300: 7/15/2013 10:38:54 PM:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353: FIRE BEHIND THE I/L\n" +
        "POSS THE HOME\n" +
        "IT'S NEAR HILLCREST AND A..",

        "ID:859",
        "CALL:Structure Fire",
        "ADDR:1700 NE BEVERLY DR",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/15/2013",
        "TIME:22:38:54",
        "UNIT:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353",
        "INFO:FIRE BEHIND THE I/L POSS THE HOME IT'S NEAR HILLCREST AND A..");

    doTest("T23",
        "(! ) 859: Structure Fire: 1701 NE BEVERLY DR, Grants Pass: Cheryl Brown Counseling \n" +
        "7300: 7/15/2013 10:38:54 PM:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353: FIRE BEHIND THE I/L\n" +
        "POSS THE HOME\n" +
        "IT'S NEAR HILLCREST AND A..",

        "ID:859",
        "CALL:Structure Fire",
        "ADDR:1701 NE BEVERLY DR",
        "CITY:Grants Pass",
        "PLACE:Cheryl Brown Counseling",
        "SRC:7300",
        "DATE:07/15/2013",
        "TIME:22:38:54",
        "UNIT:7307, 7308, 7309, FA11, 7501, 7551, M2, 7531, 7353",
        "INFO:FIRE BEHIND THE I/L POSS THE HOME IT'S NEAR HILLCREST AND A..");

    doTest("T24",
        "(! ) 815: BR1 - Breathing Problem/Chokin: 4068 NEW HOPE RD, Grants Pass:  \n" +
        "7500: 7/15/2013 5:26:51 PM:7511, M12: 63 yo male\n" +
        "a month ago cardiac bypass\n" +
        "cons/with breath diff",

        "ID:815",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:4068 NEW HOPE RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:17:26:51",
        "UNIT:7511, M12",
        "INFO:63 yo male a month ago cardiac bypass cons/with breath diff");

    doTest("T25",
        "(! ) 805: Power Line Problems: 12235 REDWOOD HWY, Wilderville: Kate's Redwood Bar & Grill \n" +
        "7500: 7/15/2013 5:02:34 PM:7514, 7200, COFD: VEH TIRE BLEW OUT\n" +
        "NO INJURIES\n" +
        "VEH HIT BUILDING\n" +
        "BOAT IS ON T..",

        "ID:805",
        "CALL:Power Line Problems",
        "ADDR:12235 REDWOOD HWY",
        "CITY:Wilderville",
        "PLACE:Kate's Redwood Bar & Grill",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:17:02:34",
        "UNIT:7514, 7200, COFD",
        "INFO:VEH TIRE BLEW OUT NO INJURIES VEH HIT BUILDING BOAT IS ON T..");

    doTest("T26",
        "(! ) 808: Lift Assist: 3223 CAMP JOY RD, Grants Pass:  \n" +
        "7500: 7/15/2013 4:57:20 PM:7512: 72 YEAR OLD FEMALE FELL ON THE FRONT DECK\n" +
        "REQEUSTING FIRE O..",

        "ID:808",
        "CALL:Lift Assist",
        "ADDR:3223 CAMP JOY RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:16:57:20",
        "UNIT:7512",
        "INFO:72 YEAR OLD FEMALE FELL ON THE FRONT DECK REQEUSTING FIRE O..");

    doTest("T27",
        "(! ) 800: Fire Assist to Public: 2128 CULLISON RD, Grants Pass:  \n" +
        "7500: 7/15/2013 4:37:21 PM:7511, 7200, COFD: SOMEONE JUST DROVE BY THE COMPL'S HOME, THREW A PROPANE TAN..",

        "ID:800",
        "CALL:Fire Assist to Public",
        "ADDR:2128 CULLISON RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:16:37:21",
        "UNIT:7511, 7200, COFD",
        "INFO:SOMEONE JUST DROVE BY THE COMPL'S HOME, THREW A PROPANE TAN..");

    doTest("T28",
        "(! ) 788: Fire Alarm: 1100 E PARK ST, Grants Pass:  \n" +
        "7300: 7/15/2013 3:52:17 PM:7308, 7501, 7353: SMOKE DETECTOR IN THE GARAGE\n" +
        "HOMEOWNERS: RICHARD AND VICKIE..",

        "ID:788",
        "CALL:Fire Alarm",
        "ADDR:1100 E PARK ST",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/15/2013",
        "TIME:15:52:17",
        "UNIT:7308, 7501, 7353",
        "INFO:SMOKE DETECTOR IN THE GARAGE HOMEOWNERS RICHARD AND VICKIE..");

    doTest("T29",
        "(! ) 748: UN1 - Unconscious/Fainting: 874 SUNNY VALLEY LOOP, Wolf Creek:  \n: 7/15/2013 12:44:47 PM:7512, M3: 83 YO FEMALE",
        "ID:748",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:874 SUNNY VALLEY LOOP",
        "CITY:Wolf Creek",
        "DATE:07/15/2013",
        "TIME:12:44:47",
        "UNIT:7512, M3",
        "INFO:83 YO FEMALE");

    doTest("T30",
        "(! ) 725: Fire Alarm - Commercial: 339 JUMP OFF JOE CREEK RD, Grants Pass:  \n" +
        "7500: 7/15/2013 10:30:21 AM:7502, 7200, COFD: general fire signal",

        "ID:725",
        "CALL:Fire Alarm - Commercial",
        "ADDR:339 JUMP OFF JOE CREEK RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:10:30:21",
        "UNIT:7502, 7200, COFD",
        "INFO:general fire signal");

    doTest("T31",
        "(! ) 686: CH1 - Chest Pain/Heart Problem: 609 RED MOUNTAIN DR, Grants Pass:  \n" +
        "7500: 7/15/2013 4:08:52 AM:7512, M2: HX A FIB\n" +
        "64 YO M\n" +
        "SHORT OF BREATH",

        "ID:686",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:609 RED MOUNTAIN DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:04:08:52",
        "UNIT:7512, M2",
        "INFO:HX A FIB 64 YO M SHORT OF BREATH");

    doTest("T32",
        "(! ) 675: AS1 - Assault/Rape/GSW/Stabbin: 265 LAPPLAND DR, Grants Pass:  \n" +
        "7500: 7/15/2013 1:51:46 AM:7514, M3: REQ TO STAGE IN THE AREA\n" +
        "VICTIM STATING SHE WAS SHOT\n" +
        "SUPPOS..",

        "ID:675",
        "CALL:AS1 - Assault/Rape/GSW/Stabbin",
        "ADDR:265 LAPPLAND DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/15/2013",
        "TIME:01:51:46",
        "UNIT:7514, M3",
        "INFO:REQ TO STAGE IN THE AREA VICTIM STATING SHE WAS SHOT SUPPOS..");

    doTest("T33",
        "(! ) 611: UN1 - Unconscious/Fainting: 140 OLD STAGE RD, Wolf Creek:  \n" +
        "7500: 7/14/2013 6:20:23 PM:7512, M3: MALE OFF THE ROADWAY NOT RESPONDING - HE'S OFF TO THE SIDE ..",

        "ID:611",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:140 OLD STAGE RD",
        "CITY:Wolf Creek",
        "SRC:7500",
        "DATE:07/14/2013",
        "TIME:18:20:23",
        "UNIT:7512, M3",
        "INFO:MALE OFF THE ROADWAY NOT RESPONDING - HE'S OFF TO THE SIDE ..");

    doTest("T34",
        "(! ) 607: Grass Fire: 74 NB I-5: 74 NB I-5 \n" +
        "7500: 7/14/2013 5:59:38 PM:7502, 7542, 7551, 5904, 7200, COFD: SMOLDERING ON THE SIDE OF THE ROADWAY\n" +
        "BETWEEN 74-75 NORTHBO..",

        "ID:607",
        "CALL:Grass Fire",
        "ADDR:74 NB I-5",
        "MADDR:74 I 5",
        "PLACE:74 NB I-5",
        "SRC:7500",
        "DATE:07/14/2013",
        "TIME:17:59:38",
        "UNIT:7502, 7542, 7551, 5904, 7200, COFD",
        "INFO:SMOLDERING ON THE SIDE OF THE ROADWAY BETWEEN 74-75 NORTHBO..");

    doTest("T35",
        "(! ) 589: Small Vehicle Fire: 3000 REDWOOD HWY, Grants Pass:  \n" +
        "7300: 7/14/2013 4:00:22 PM:7328, 7511, 7353: ON THE SIDE OF THE ROAD",

        "ID:589",
        "CALL:Small Vehicle Fire",
        "ADDR:3000 REDWOOD HWY",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/14/2013",
        "TIME:16:00:22",
        "UNIT:7328, 7511, 7353",
        "INFO:ON THE SIDE OF THE ROAD");

    doTest("T36",
        "(! ) 568: Grass Fire: 8131 LOWER RIVER RD, Grants Pass:  \n" +
        "7500: 7/14/2013 2:40:32 PM:7307, 7506, 7512, 7515, 7541, 7542, 7551: SMALL FIRE EAST SIDE\n" +
        "FLAMES ARE APPROX 3 FT HIGH\n" +
        "SPREADING ..",

        "ID:568",
        "CALL:Grass Fire",
        "ADDR:8131 LOWER RIVER RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/14/2013",
        "TIME:14:40:32",
        "UNIT:7307, 7506, 7512, 7515, 7541, 7542, 7551",
        "INFO:SMALL FIRE EAST SIDE FLAMES ARE APPROX 3 FT HIGH SPREADING ..");

    doTest("T37",
        "(! ) 568: Grass Fire: 11845 LOWER RIVER RD, Grants Pass: WILDLIFE IMAGES \n" +
        "7500: 7/14/2013 2:40:32 PM:7307, 7502, 7541, 7551, 7200, COFD: SMALL FIRE EAST SIDE",

        "ID:568",
        "CALL:Grass Fire",
        "ADDR:11845 LOWER RIVER RD",
        "CITY:Grants Pass",
        "PLACE:WILDLIFE IMAGES",
        "SRC:7500",
        "DATE:07/14/2013",
        "TIME:14:40:32",
        "UNIT:7307, 7502, 7541, 7551, 7200, COFD",
        "INFO:SMALL FIRE EAST SIDE");

    doTest("T38",
        "(! ) 543: UN1 - Unconscious/Fainting: 6101 RIVERBANKS RD, Grants Pass:  \n" +
        "7500: 7/14/2013 12:18:16 PM:7514, M2: SEMI CONSC, STARING OUT IN TO SPACE\n" +
        "POSS HAVING A STROKE\n" +
        "EL..",

        "ID:543",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:6101 RIVERBANKS RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/14/2013",
        "TIME:12:18:16",
        "UNIT:7514, M2",
        "INFO:SEMI CONSC, STARING OUT IN TO SPACE POSS HAVING A STROKE EL..");

    doTest("T39",
        "(! ) 536: CH1 - Chest Pain/Heart Problem: 1171 ORT LN, Merlin:  \n" +
        ": 7/14/2013 11:41:16 AM:7512, M12: WITH BREATH DIFF\n" +
        "NO CARDIAC HX\n" +
        "41 YO MALE\n" +
        "NAUSEATED AND BLO..",

        "ID:536",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:1171 ORT LN",
        "CITY:Merlin",
        "DATE:07/14/2013",
        "TIME:11:41:16",
        "UNIT:7512, M12",
        "INFO:WITH BREATH DIFF NO CARDIAC HX 41 YO MALE NAUSEATED AND BLO..");

    doTest("T40",
        "(! ) 531: Small Vehicle Fire: 76 NB I-5: 76 NB I-5 \n" +
        "5900: 7/14/2013 11:15:04 AM:5951, 7512, 5904, 5961: JUST BEFORE EXIT 76,\n" +
        "CAR IS SMOKING REALLY BAD\n" +
        "EVERYONE OUT..",

        "ID:531",
        "CALL:Small Vehicle Fire",
        "ADDR:76 NB I-5",
        "MADDR:76 I 5",
        "PLACE:76 NB I-5",
        "SRC:5900",
        "DATE:07/14/2013",
        "TIME:11:15:04",
        "UNIT:5951, 7512, 5904, 5961",
        "INFO:JUST BEFORE EXIT 76, CAR IS SMOKING REALLY BAD EVERYONE OUT..");

    doTest("T41",
        "(! ) 460: BR3 - Breathing Problem/Chokin: 321 SHETLAND DR, Grants Pass:  \n" +
        "7500: 7/13/2013 10:39:09 PM:7512, M3: ABD PAIN\n" +
        "83\n" +
        "YO FEMALE\n" +
        "CON/DIFF BREATHING\n" +
        "UPGRADED\n" +
        "NO CHESTP..",

        "ID:460",
        "CALL:BR3 - Breathing Problem/Chokin",
        "ADDR:321 SHETLAND DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:22:39:09",
        "UNIT:7512, M3",
        "INFO:ABD PAIN 83 YO FEMALE CON/DIFF BREATHING UPGRADED NO CHESTP..");

    doTest("T42",
        "(! ) 419: TA2 - Traffic Accident Lane Bl: 12000 REDWOOD HWY, Wilderville:  \n" +
        "7500: 7/13/2013 7:38:39 PM:7514, M1: BLK SATURN\n" +
        "BLOOD ON FACE\n" +
        "FEMALE IS WANTING AMBULANCE\n" +
        "NECK P..",

        "ID:419",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:12000 REDWOOD HWY",
        "CITY:Wilderville",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:19:38:39",
        "UNIT:7514, M1",
        "INFO:BLK SATURN BLOOD ON FACE FEMALE IS WANTING AMBULANCE NECK P..");

    doTest("T43",
        "(! ) 383: TA2 - Traffic Accident Lane Bl: 8500 GALICE RD, Merlin: Morrison's Lodge \n" +
        "7500: 7/13/2013 4:21:55 PM:7512, M2: UNK INJURY",

        "ID:383",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:8500 GALICE RD",
        "CITY:Merlin",
        "PLACE:Morrison's Lodge",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:16:21:55",
        "UNIT:7512, M2",
        "INFO:UNK INJURY");

    doTest("T44",
        "(! ) 362: Water Rescue: CHINOOK PARK LN@ GORDON WAY , Grants Pass:  \n" +
        "7500: 7/13/2013 2:33:20 PM:7308, 7501, 7555, 7531: girl just swept down river\n" +
        "girl was found\n" +
        "11 yo girl\n" +
        "2ND CA..",

        "ID:362",
        "CALL:Water Rescue",
        "ADDR:CHINOOK PARK LN & GORDON WAY",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:14:33:20",
        "UNIT:7308, 7501, 7555, 7531",
        "INFO:girl just swept down river girl was found 11 yo girl 2ND CA..");

    doTest("T45",
        "(! ) 359: UN1 - Unconscious/Fainting: SLOAN MOUNTAIN LN@ LAPPLAND DR , Grants Pass:  \n" +
        "7500: 7/13/2013 2:07:42 PM:7514, M1: 300 YARD UP FROM LAPPLAND DR\n" +
        "MALE IN HIS LATE 60\n" +
        "LYING ON T..",

        "ID:359",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:SLOAN MOUNTAIN LN & LAPPLAND DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:14:07:42",
        "UNIT:7514, M1",
        "INFO:300 YARD UP FROM LAPPLAND DR MALE IN HIS LATE 60 LYING ON T..");

    doTest("T46",
        "(! ) 288: Lift Assist: 309 SANDLEWOOD DR, Grants Pass:  \n" +
        "7500: 7/13/2013 6:59:43 AM:7501: elderly female\n" +
        "compl is with hospice\n" +
        "not injured",

        "ID:288",
        "CALL:Lift Assist",
        "ADDR:309 SANDLEWOOD DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:06:59:43",
        "UNIT:7501",
        "INFO:elderly female compl is with hospice not injured");

    doTest("T47",
        "(! ) 281: Trash Fire: 407 SW RAMSEY AVE, Grants Pass:  \n7300: 7/13/2013 6:35:23 AM:7308, 7501: ",
        "ID:281",
        "CALL:Trash Fire",
        "ADDR:407 SW RAMSEY AVE",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/13/2013",
        "TIME:06:35:23",
        "UNIT:7308, 7501:");

    doTest("T48",
        "(! ) 276: Fire Assist to Public: 71 SB I-5: 71 SB I-5 \n7500: 7/13/2013 5:47:18 AM:7512: ",
        "ID:276",
        "CALL:Fire Assist to Public",
        "ADDR:71 SB I-5",
        "MADDR:71 I 5",
        "PLACE:71 SB I-5",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:05:47:18",
        "UNIT:7512:");

    doTest("T49",
        "(! ) 275: Small Vehicle Fire: 162 PLACER RD, Wolf Creek:  \n" +
        "7500: 7/13/2013 5:06:21 AM:7512, 7555: in the middle of the road\n" +
        "ford pickup truck\n" +
        "ODF ADVISED\n" +
        "OSP..",

        "ID:275",
        "CALL:Small Vehicle Fire",
        "ADDR:162 PLACER RD",
        "CITY:Wolf Creek",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:05:06:21",
        "UNIT:7512, 7555",
        "INFO:in the middle of the road ford pickup truck ODF ADVISED OSP..");

    doTest("T50",
        "(! ) 275: Small Vehicle Fire: 200 PLACER RD, Wolf Creek:  \n" +
        "7500: 7/13/2013 5:06:21 AM:7502, 7555, 7200, COFD: in the middle of the road\n" +
        "ford pickup truck",

        "ID:275",
        "CALL:Small Vehicle Fire",
        "ADDR:200 PLACER RD",
        "CITY:Wolf Creek",
        "SRC:7500",
        "DATE:07/13/2013",
        "TIME:05:06:21",
        "UNIT:7502, 7555, 7200, COFD",
        "INFO:in the middle of the road ford pickup truck");

    doTest("T51",
        "(! ) 221: TA1C - Traffic Accident Ped or: REDWOOD HWY@ ELLIOTT CREEK RD , Wilderville:  \n" +
        "7500: 7/12/2013 10:36:23 PM:7514, M1: 25 YO MALE\n" +
        "MC\n" +
        "NO ROADWAY BLOCKAGE\n" +
        "IN BOUND",

        "ID:221",
        "CALL:TA1C - Traffic Accident Ped or",
        "ADDR:REDWOOD HWY & ELLIOTT CREEK RD",
        "CITY:Wilderville",
        "SRC:7500",
        "DATE:07/12/2013",
        "TIME:22:36:23",
        "UNIT:7514, M1",
        "INFO:25 YO MALE MC NO ROADWAY BLOCKAGE IN BOUND");

    doTest("T52",
        "(! ) 155: TA2 - Traffic Accident Lane Bl: 50 SB I-5: 50 SB I-5 \n" +
        "7400: 7/12/2013 5:37:12 PM:7511, M1: TWO VEH, SB SIDE, DEBRIS IN THE RD, VEHICLES OUT OF THE RD",

        "ID:155",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:50 SB I-5",
        "MADDR:50 I 5",
        "PLACE:50 SB I-5",
        "SRC:7400",
        "DATE:07/12/2013",
        "TIME:17:37:12",
        "UNIT:7511, M1",
        "INFO:TWO VEH, SB SIDE, DEBRIS IN THE RD, VEHICLES OUT OF THE RD");

    doTest("T53",
        "(! ) 49: OB3 - Pregnancy/Childbirth/Mis: 546 JAYNES DR, Grants Pass:  \n" +
        "7500: 7/12/2013 8:27:16 AM:7511, M1: BABY IS BREATHING W SOME DIFF BREATH\n" +
        "CHILD WAS BORN 45 MINA..",

        "ID:49",
        "CALL:OB3 - Pregnancy/Childbirth/Mis",
        "ADDR:546 JAYNES DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/12/2013",
        "TIME:08:27:16",
        "UNIT:7511, M1",
        "INFO:BABY IS BREATHING W SOME DIFF BREATH CHILD WAS BORN 45 MINA..");

    doTest("T54",
        "(! ) 18: ST1 - Stroke: 1700 KELLENBECK AVE 324 , Grants Pass: Country Side Village \n" +
        "7300: 7/12/2013 4:25:32 AM:7501: MALE SLURRING HIS WORDS\n" +
        "1925",

        "ID:18",
        "CALL:ST1 - Stroke",
        "ADDR:1700 KELLENBECK AVE",
        "APT:324",
        "CITY:Grants Pass",
        "PLACE:Country Side Village",
        "SRC:7300",
        "DATE:07/12/2013",
        "TIME:04:25:32",
        "UNIT:7501",
        "INFO:MALE SLURRING HIS WORDS 1925");

    doTest("T55",
        "(! ) 15: CH1 - Chest Pain/Heart Problem: 1270 MARCUS WAY, Grants Pass:  \n7300: 7/12/2013 3:40:06 AM:7307, 7511, M3: 64 YO MALE",
        "ID:15",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:1270 MARCUS WAY",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/12/2013",
        "TIME:03:40:06",
        "UNIT:7307, 7511, M3",
        "INFO:64 YO MALE");

    doTest("T56",
        "(! ) 13: Structure Fire: 1621 ALLEN CREEK RD, Grants Pass:  \n" +
        "7300: 7/12/2013 2:37:52 AM:7307, 7308, 7309, 7501, 7514, 7553, M1, 160, 155, 188, 7531, 7353: HOUSE ON FIRE\n" +
        "THE HOUSE IS ACROSS THE STREET FROM ALBERTSONS",

        "ID:13",
        "CALL:Structure Fire",
        "ADDR:1621 ALLEN CREEK RD",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/12/2013",
        "TIME:02:37:52",
        "UNIT:7307, 7308, 7309, 7501, 7514, 7553, M1, 160, 155, 188, 7531, 7353",
        "INFO:HOUSE ON FIRE THE HOUSE IS ACROSS THE STREET FROM ALBERTSONS");

    doTest("T57",
        "(! ) 13: Structure Fire: 1690 ALLEN CREEK RD, Grants Pass: Albertsons South \n" +
        "7300: 7/12/2013 2:37:52 AM:7308, 7309, FA4, 7511, 7514, 7553, M1, 7531, 7353: HOUSE ON FIRE\n" +
        "THE HOUSE IS ACROSS THE STREET FROM ALBERTSONS",

        "ID:13",
        "CALL:Structure Fire",
        "ADDR:1690 ALLEN CREEK RD",
        "CITY:Grants Pass",
        "PLACE:Albertsons South",
        "SRC:7300",
        "DATE:07/12/2013",
        "TIME:02:37:52",
        "UNIT:7308, 7309, FA4, 7511, 7514, 7553, M1, 7531, 7353",
        "INFO:HOUSE ON FIRE THE HOUSE IS ACROSS THE STREET FROM ALBERTSONS");

    doTest("T58",
        "(! ) 983: BR1 - Breathing Problem/Chokin: 2815 JUMP OFF JOE CREEK RD, Grants Pass:  \n" +
        "7500: 7/11/2013 11:06:54 PM:7512, M2: 70'S YO MALE\n" +
        "JUST CALLED COMPL\n" +
        "PT: MALONE, MICHAEL\n" +
        "HX BREAT..",

        "ID:983",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:2815 JUMP OFF JOE CREEK RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:23:06:54",
        "UNIT:7512, M2",
        "INFO:70'S YO MALE JUST CALLED COMPL PT MALONE, MICHAEL HX BREAT..");

    doTest("T59",
        "(! ) 950: Small Vehicle Fire: Sexton Summit NB: Sexton Summit NB \n" +
        "7500: 7/11/2013 8:48:09 PM:7502, 7553, 7200, COFD: PICK-UP TRUCK PULLING A TRAILER ON FIRE\n" +
        "FLAMES UNDER THE EN..",

        "ID:950",
        "CALL:Small Vehicle Fire",
        "ADDR:Sexton Summit NB",
        "MADDR:Sexton Summit",
        "PLACE:Sexton Summit NB",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:20:48:09",
        "UNIT:7502, 7553, 7200, COFD",
        "INFO:PICK-UP TRUCK PULLING A TRAILER ON FIRE FLAMES UNDER THE EN..");

    doTest("T60",
        "(! ) 928: ST1 - Stroke: 1189 ABEGG RD, Merlin:  \n7500: 7/11/2013 7:36:35 PM:7512, M2: 66 YEAR OLD MALE HAVING A STROKE",
        "ID:928",
        "CALL:ST1 - Stroke",
        "ADDR:1189 ABEGG RD",
        "CITY:Merlin",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:19:36:35",
        "UNIT:7512, M2",
        "INFO:66 YEAR OLD MALE HAVING A STROKE");

    doTest("T61",
        "(! ) 922: Structure Fire: 115 NW MORGAN LN 6 , Grants Pass: Mt View Trailer Park \n" +
        "7300: 7/11/2013 7:17:51 PM:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\n" +
        "IT'S C..",

        "ID:922",
        "CALL:Structure Fire",
        "ADDR:115 NW MORGAN LN",
        "APT:6",
        "CITY:Grants Pass",
        "PLACE:Mt View Trailer Park",
        "SRC:7300",
        "DATE:07/11/2013",
        "TIME:19:17:51",
        "UNIT:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353",
        "INFO:SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION IT'S C..");

    doTest("T62",
        "(! ) 922: Structure Fire: 115 NW MORGAN LN, Grants Pass: Mt View Trailer Park \n" +
        "7300: 7/11/2013 7:17:51 PM:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\n" +
        "IT'S C..",

        "ID:922",
        "CALL:Structure Fire",
        "ADDR:115 NW MORGAN LN",
        "CITY:Grants Pass",
        "PLACE:Mt View Trailer Park",
        "SRC:7300",
        "DATE:07/11/2013",
        "TIME:19:17:51",
        "UNIT:7307, 7308, 7309, 7501, 7512, 7553, M2, 7531, 7353",
        "INFO:SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION IT'S C..");

    doTest("T63",
        "(! ) 922: Structure Fire: NW WASHINGTON BLVD@ NW MORGAN LN , Grants Pass:  \n" +
        "7300: 7/11/2013 7:17:51 PM:7307, 7308, 7328, FA4, 7501, 7553, M2, 7531, 7353: SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION\n" +
        "IT'S C..",

        "ID:922",
        "CALL:Structure Fire",
        "ADDR:NW WASHINGTON BLVD & NW MORGAN LN",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/11/2013",
        "TIME:19:17:51",
        "UNIT:7307, 7308, 7328, FA4, 7501, 7553, M2, 7531, 7353",
        "INFO:SMOKE COMING OUT OF A TRAILER NEAR THIS INTERSECTION IT'S C..");

    doTest("T64",
        "(! ) 904: Grass Fire: QUARTZ CREEK RD@ HUGO RD , Merlin:  \n" +
        "7500: 7/11/2013 5:05:31 PM:7512: REPORTED BY 7512 HEARD FROM ODF LOOKOUT\n" +
        "572 HAS ID'D A COLU..",

        "ID:904",
        "CALL:Grass Fire",
        "ADDR:QUARTZ CREEK RD & HUGO RD",
        "CITY:Merlin",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:17:05:31",
        "UNIT:7512",
        "INFO:REPORTED BY 7512 HEARD FROM ODF LOOKOUT 572 HAS ID'D A COLU..");

    doTest("T65",
        "(! ) 904: Outdoor Smoke/Odor: QUARTZ CREEK RD@ HUGO RD , Merlin:  \n" +
        "7500: 7/11/2013 5:05:31 PM:7512: REPORTED BY 7512 HEARD FROM ODF LOOKOUT",

        "ID:904",
        "CALL:Outdoor Smoke/Odor",
        "ADDR:QUARTZ CREEK RD & HUGO RD",
        "CITY:Merlin",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:17:05:31",
        "UNIT:7512",
        "INFO:REPORTED BY 7512 HEARD FROM ODF LOOKOUT");

    doTest("T66",
        "(! ) 800: BR1 - Breathing Problem/Chokin: 721 DENVER AVE, Grants Pass:  \n" +
        "7500: 7/11/2013 6:39:16 AM:7512, M2: 78 YO MALE\n" +
        "DIFF BREATHING\n" +
        "IS ON OXYGEN",

        "ID:800",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:721 DENVER AVE",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/11/2013",
        "TIME:06:39:16",
        "UNIT:7512, M2",
        "INFO:78 YO MALE DIFF BREATHING IS ON OXYGEN");

    doTest("T67",
        "(! ) 770: Fire Assist to Public: 1980 REGINA WAY, Grants Pass:  \n" +
        "7300: 7/11/2013 12:09:43 AM:7511, M1: MEDICAL ALARM ACTIVATED\n" +
        "NO RESPONSE\n" +
        "HX SHOWS FEMALE\n" +
        "NOW ANO..",

        "ID:770",
        "CALL:Fire Assist to Public",
        "ADDR:1980 REGINA WAY",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/11/2013",
        "TIME:00:09:43",
        "UNIT:7511, M1",
        "INFO:MEDICAL ALARM ACTIVATED NO RESPONSE HX SHOWS FEMALE NOW ANO..");

    doTest("T68",
        "(! ) 766: TA2 - Traffic Accident Lane Bl: 71 NB I-5: 71 NB I-5 \n" +
        "7500: 7/10/2013 11:28:52 PM:7512, M3: PASS THE FIRST CONSTRUCTION AREA, ON THE SIDE OF THE HILL",

        "ID:766",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:71 NB I-5",
        "MADDR:71 I 5",
        "PLACE:71 NB I-5",
        "SRC:7500",
        "DATE:07/10/2013",
        "TIME:23:28:52",
        "UNIT:7512, M3",
        "INFO:PASS THE FIRST CONSTRUCTION AREA, ON THE SIDE OF THE HILL");

    doTest("T69",
        "(! ) 729: Fire Assist to Public: 11520 REDWOOD HWY, Wilderville:  \n" +
        "7500: 7/10/2013 7:49:57 PM:7514, M2, 7200, COFD: TALKING ABOUT A FIRE, OXYGEN AND SOMETHING ABOUT HER CHEST",

        "ID:729",
        "CALL:Fire Assist to Public",
        "ADDR:11520 REDWOOD HWY",
        "CITY:Wilderville",
        "SRC:7500",
        "DATE:07/10/2013",
        "TIME:19:49:57",
        "UNIT:7514, M2, 7200, COFD",
        "INFO:TALKING ABOUT A FIRE, OXYGEN AND SOMETHING ABOUT HER CHEST");

    doTest("T70",
        "(! ) 682: TA2 - Traffic Accident Lane Bl: WILLIAMS HWY@ FRUITDALE DR , Grants Pass:  \n" +
        "7300: 7/10/2013 4:25:18 PM:7308, 7511, M12, 147, 163: TWO VEH ACCIDENT\n" +
        "VEHS ARE IN THE ROADWAY\n" +
        "UNKNOWN IF ANYONE'..",

        "ID:682",
        "CALL:TA2 - Traffic Accident Lane Bl",
        "ADDR:WILLIAMS HWY & FRUITDALE DR",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/10/2013",
        "TIME:16:25:18",
        "UNIT:7308, 7511, M12, 147, 163",
        "INFO:TWO VEH ACCIDENT VEHS ARE IN THE ROADWAY UNKNOWN IF ANYONE'..");

    doTest("T71",
        "(! ) 626: Outdoor Smoke/Odor: HARBECK RD@ GRANDVIEW LN , Grants Pass:  \n" +
        "7300: 7/10/2013 12:30:42 PM:7308, 7501: DEF COLUMN OF SMOKE\n" +
        "BROWN IN COLOR\n" +
        "STARTED TO REALLY GO NOW",

        "ID:626",
        "CALL:Outdoor Smoke/Odor",
        "ADDR:HARBECK RD & GRANDVIEW LN",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/10/2013",
        "TIME:12:30:42",
        "UNIT:7308, 7501",
        "INFO:DEF COLUMN OF SMOKE BROWN IN COLOR STARTED TO REALLY GO NOW");

    doTest("T72",
        "(! ) 575: BR3 - Breathing Problem/Chokin: 882 ROGUELEA LN, Grants Pass:  \n" +
        "7500: 7/10/2013 8:00:41 AM:7511, M2: dizzy, 58 yoa, consc, coherant, br ok\n" +
        "sleepy\n" +
        "hx of COPD and..",

        "ID:575",
        "CALL:BR3 - Breathing Problem/Chokin",
        "ADDR:882 ROGUELEA LN",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/10/2013",
        "TIME:08:00:41",
        "UNIT:7511, M2",
        "INFO:dizzy, 58 yoa, consc, coherant, br ok sleepy hx of COPD and..");

    doTest("T73",
        "(! ) 569: BR1 - Breathing Problem/Chokin: 401 BAYARD DR, Grants Pass:  \n" +
        "7300: 7/10/2013 7:29:07 AM:7308, 7501, M1: DIFF BREATH, ON O2, HX O BREATH PROBLEMS",

        "ID:569",
        "CALL:BR1 - Breathing Problem/Chokin",
        "ADDR:401 BAYARD DR",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/10/2013",
        "TIME:07:29:07",
        "UNIT:7308, 7501, M1",
        "INFO:DIFF BREATH, ON O2, HX O BREATH PROBLEMS");

    doTest("T74",
        "(! ) 568: AS1 - Assault/Rape/GSW/Stabbin: 233 BARKER DR, Merlin:  \n" +
        ": 7/10/2013 7:07:04 AM:7512, M2: MALE ON THE LINE\n" +
        "WAS VERY HARD TO UNDERSTAND\n" +
        "LISTENING BACK..",

        "ID:568",
        "CALL:AS1 - Assault/Rape/GSW/Stabbin",
        "ADDR:233 BARKER DR",
        "CITY:Merlin",
        "DATE:07/10/2013",
        "TIME:07:07:04",
        "UNIT:7512, M2",
        "INFO:MALE ON THE LINE WAS VERY HARD TO UNDERSTAND LISTENING BACK..");

    doTest("T75",
        "(! ) 443: UN1 - Unconscious/Fainting: FISH HATCHERY RD@ BECKY SPRINGS DR , Grants Pass:  \n" +
        "7500: 7/9/2013 4:49:15 PM:7514, M3: GRY TANK TOP, SHORTS, BACK PACK\n" +
        "LAYING AT THE SIDE OF THE R..",

        "ID:443",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:FISH HATCHERY RD & BECKY SPRINGS DR",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/09/2013",
        "TIME:16:49:15",
        "UNIT:7514, M3",
        "INFO:GRY TANK TOP, SHORTS, BACK PACK LAYING AT THE SIDE OF THE R..");

    doTest("T76",
        "(! ) 339: ST1 - Stroke: 917 SLEEPY HOLLOW LOOP, Grants Pass:  \n" +
        ": 7/9/2013 9:29:53 AM:7514, M1: 86 YO FEMALE\n" +
        "ALZEHIMER PT\n" +
        "SITTING ON THE TOILET AT THIS TIME",

        "ID:339",
        "CALL:ST1 - Stroke",
        "ADDR:917 SLEEPY HOLLOW LOOP",
        "CITY:Grants Pass",
        "DATE:07/09/2013",
        "TIME:09:29:53",
        "UNIT:7514, M1",
        "INFO:86 YO FEMALE ALZEHIMER PT SITTING ON THE TOILET AT THIS TIME");

    doTest("T77",
        "(! ) 288: Open Burn-Illegal Materia: ALLEN CREEK RD@ REDWOOD HWY , Grants Pass:  \n" +
        "7300: 7/8/2013 10:55:21 PM:7501: TEENS HAVE A FIRE IN THE OPEN DRY LOT NEAR I/L\n" +
        "OPEN FIELD W..",

        "ID:288",
        "CALL:Open Burn-Illegal Materia",
        "ADDR:ALLEN CREEK RD & REDWOOD HWY",
        "CITY:Grants Pass",
        "SRC:7300",
        "DATE:07/08/2013",
        "TIME:22:55:21",
        "UNIT:7501",
        "INFO:TEENS HAVE A FIRE IN THE OPEN DRY LOT NEAR I/L OPEN FIELD W..");

    doTest("T78",
        "(! ) 206: TA1 - Traffic Accident: 8785 REDWOOD HWY, Wilderville:  \n" +
        "7500: 7/8/2013 5:10:43 PM:7514, 7591: PULLING PT OUT OF A TRUCK",

        "ID:206",
        "CALL:TA1 - Traffic Accident",
        "ADDR:8785 REDWOOD HWY",
        "CITY:Wilderville",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:17:10:43",
        "UNIT:7514, 7591",
        "INFO:PULLING PT OUT OF A TRUCK");

    doTest("T79",
        "(! ) 206: TA1 - Traffic Accident: 9000 REDWOOD HWY, Wilderville:  \n" +
        "7500: 7/8/2013 5:10:43 PM:7514, 7591: PULLING PT OUT OF A TRUCK",

        "ID:206",
        "CALL:TA1 - Traffic Accident",
        "ADDR:9000 REDWOOD HWY",
        "CITY:Wilderville",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:17:10:43",
        "UNIT:7514, 7591",
        "INFO:PULLING PT OUT OF A TRUCK");

    doTest("T80",
        "(! ) 89: CH3 - Chest Pain/Heart Problem: 1151 SUMMIT LOOP, Grants Pass:  \n" +
        "7500: 7/8/2013 10:29:52 AM:7511, M12: HEART RATE REALLY HIGH AND FEEL LIKE GOING TO PASS OUT",

        "ID:89",
        "CALL:CH3 - Chest Pain/Heart Problem",
        "ADDR:1151 SUMMIT LOOP",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:10:29:52",
        "UNIT:7511, M12",
        "INFO:HEART RATE REALLY HIGH AND FEEL LIKE GOING TO PASS OUT");

    doTest("T81",
        "(! ) 86: UN1 - Unconscious/Fainting: 500 SW RAMSEY AVE, Grants Pass: Three Rivers Community Hospital TRH \n" +
        "7300: 7/8/2013 10:10:22 AM:7328, 7501, M12: UNABLE TO TALK\n" +
        "IFO THE ER AT THE HOSPITAL",

        "ID:86",
        "CALL:UN1 - Unconscious/Fainting",
        "ADDR:500 SW RAMSEY AVE",
        "CITY:Grants Pass",
        "PLACE:Three Rivers Community Hospital TRH",
        "SRC:7300",
        "DATE:07/08/2013",
        "TIME:10:10:22",
        "UNIT:7328, 7501, M12",
        "INFO:UNABLE TO TALK IFO THE ER AT THE HOSPITAL");

    doTest("T82",
        "(! ) 68: Structure Fire: 7501 LOWER RIVER RD, Grants Pass:  \n" +
        "7500: 7/8/2013 8:35:57 AM:7308, 7501, 7502, 7541, 7542, 7555, 7531, 7200, COFD: right next door\n" +
        "apt",

        "ID:68",
        "CALL:Structure Fire",
        "ADDR:7501 LOWER RIVER RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:08:35:57",
        "UNIT:7308, 7501, 7502, 7541, 7542, 7555, 7531, 7200, COFD",
        "INFO:right next door apt");

    doTest("T83",
        "(! ) 28: Fire Assist to Public: 62 SB I-5: 62 SB I-5 \n7500: 7/8/2013 1:48:25 AM:7502, 7200, COFD: ",
        "ID:28",
        "CALL:Fire Assist to Public",
        "ADDR:62 SB I-5",
        "MADDR:62 I 5",
        "PLACE:62 SB I-5",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:01:48:25",
        "UNIT:7502, 7200, COFD:");

    doTest("T84",
        "(! ) 15: CH1 - Chest Pain/Heart Problem: 2922 MERLIN RD 5 , Grants Pass: Shady Acres \n" +
        "7500: 7/8/2013 12:03:51 AM:7512, M2: HX OF CANCER AND GALL BLADDER PROBLEMS\n" +
        "NO BLEEDING\n" +
        "LUKEMIA",

        "ID:15",
        "CALL:CH1 - Chest Pain/Heart Problem",
        "ADDR:2922 MERLIN RD",
        "APT:5",
        "CITY:Grants Pass",
        "PLACE:Shady Acres",
        "SRC:7500",
        "DATE:07/08/2013",
        "TIME:00:03:51",
        "UNIT:7512, M2",
        "INFO:HX OF CANCER AND GALL BLADDER PROBLEMS NO BLEEDING LUKEMIA");

    doTest("T85",
        "(! ) 902: UN3 - Unconscious/Fainting: 62 SB I-5: 62 SB I-5 \n" +
        "7500: 7/7/2013 12:28:23 PM:7512, M1: FEMALE PASSED OUT\n" +
        "NO CHEST PAIN\n" +
        "BREATH SEEMS OKAY\n" +
        "77 YO F",

        "ID:902",
        "CALL:UN3 - Unconscious/Fainting",
        "ADDR:62 SB I-5",
        "MADDR:62 I 5",
        "PLACE:62 SB I-5",
        "SRC:7500",
        "DATE:07/07/2013",
        "TIME:12:28:23",
        "UNIT:7512, M1",
        "INFO:FEMALE PASSED OUT NO CHEST PAIN BREATH SEEMS OKAY 77 YO F");

    doTest("T86",
        "(! ) 892: Fire Assist to Public: MONUMENT DR@ MERLIN RD , Grants Pass:  \n" +
        "7500: 7/7/2013 11:11:56 AM:7511: PARTIALLY BLOCKING ROADWAY\n" +
        "THQ432",

        "ID:892",
        "CALL:Fire Assist to Public",
        "ADDR:MONUMENT DR & MERLIN RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/07/2013",
        "TIME:11:11:56",
        "UNIT:7511",
        "INFO:PARTIALLY BLOCKING ROADWAY THQ432");

    doTest("T87",
        "(! ) 892: <New Call>: MONUMENT DR@ MERLIN RD , Grants Pass:  \n7500: 7/7/2013 11:11:56 AM:7511: ",
        "ID:892",
        "CALL:<New Call>",
        "ADDR:MONUMENT DR & MERLIN RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/07/2013",
        "TIME:11:11:56",
        "UNIT:7511:");

    doTest("T88",
        "(! ) 883: Outdoor Smoke/Odor: 2000 CHENEY CREEK RD, Grants Pass:  \n" +
        "7500: 7/7/2013 10:13:15 AM:7514, 7200, COFD: SMALL SMOULDERING CAMP FIRE NOT IN A FIRE PIT\n" +
        "BURNING\n" +
        "ABOUT..",

        "ID:883",
        "CALL:Outdoor Smoke/Odor",
        "ADDR:2000 CHENEY CREEK RD",
        "CITY:Grants Pass",
        "SRC:7500",
        "DATE:07/07/2013",
        "TIME:10:13:15",
        "UNIT:7514, 7200, COFD",
        "INFO:SMALL SMOULDERING CAMP FIRE NOT IN A FIRE PIT BURNING ABOUT..");

  }
  
  public static void main(String args[]) {
    new ORJosephineCountyParserTest().generateTests("T1");
  }
}