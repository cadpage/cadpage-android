package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lincoln County, MO
Contact: Active911
Agency name: Lincoln County Fire Protection District
Location: Troy, MO, United States
Sender: messaging@iamresponding.com

(LCFPD) OCC #13-748, INC #13-46201 - ALARM - Alarm\nTime Entered: 8/7/2013 10:13:31 PM\nReceived Via: Phone\n300 Marble St (Apt 20), Troy\n\nFIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\nNO FIRE \nNO SMOKE\n\nIncident Log:\n\n07-Aug-13 22:31:14 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-46201 (13-748)  ALARM - Alarm\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 22:25:08 - Memo by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\nSTATUS CLEAR FAULTY DETECTOR\n\n07-Aug-13 22:19:48 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n6414-- NOTHING SHOWING -- SINGLE STORY\n\n07-Aug-13 22:19:36 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n300 Marble St (Apt 20), Troy\n\n\n\n07-Aug-13 22:17:05 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n300 Marble St (Apt 20), Troy\n\n\n\n07-Aug-13 22:15:49 - Dispatched by: 674 (Tracy Eden)\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 22:15:23 - Memo by: 696 (Brittany Job)\nALARMS HAVE STOPPED FOR THE MOMENT \n\n\n\n07-Aug-13 22:15:00 - Memo by: 696 (Brittany Job)\nFIANCE AND DAUGHTER IS WITH HER\n\n\n\n07-Aug-13 22:13:31 - Entered by: 696 (Brittany Job)\nALARM - Alarm (Priority 5)\nSource: Phone\n\nReporting Person: ELIZABETH TAYLOR\nPhone: 63-358-8751\nLocation: 300 Marble St (Apt 20), Troy\n\nFIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\nNO FIRE \nNO SMOKE\n\n07-Aug-13 22:13:31 - Initiated by: 696 (Brittany Job)
(LCFPD) NEW Alarm 300 Marble St (Apt 20), Troy
(LCFPD) OCC #13-747, INC #13-46188 - TRAF H - Traffic Hazard\nTime Entered: 8/7/2013 9:02:53 PM\nReceived Via: Phone\nHarmony Grove Rd, Troy\n\nTREE LIMBS IN RDWAY \nCALLER ADV ITS POSING A HAZARD \nITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\nIncident Log:\n\n07-Aug-13 22:04:53 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 22:04:47 - Cleared Notebook by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Pumper 6444\n\n\n\n07-Aug-13 22:04:07 - Cleared Notebook by: 698 (Elliott Burkemper)\nClear Incident 13-46188 (13-16734)  TRAF H - Traffic Hazard\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\ntree removed\n\n07-Aug-13 22:03:53 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 22:03:27 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nTREE REMOVED\nCOUNTY HWY DEPT COME CHECK THE AREA\n\n07-Aug-13 21:53:01 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n480 OUT OF VEHICLE HELPING CLEAR THE ROADWAY\n\n07-Aug-13 21:48:53 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nUNITS ON SCENE CAN HANDLE\n\n07-Aug-13 21:47:41 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:47:38 - Backup by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 21:47:38 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 21:47:20 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:39:43 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n6438-- DRIVER ONLY\n\n07-Aug-13 21:39:15 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:39:12 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 21:39:12 - Backup by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 21:35:04 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6444\n\n500 Harmony Grove Rd, Troy\n\nX 1\n\n07-Aug-13 21:35:00 - Reassign by: 696 (Brittany Job)\n\n\n07-Aug-13 21:35:00 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Pumper 6444\n\n\n\n07-Aug-13 21:33:33 - Backup by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 21:33:33 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 21:29:19 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nBETWEEN PLUM TREE AND NATHANIEL ON THE STRAIGHT AWAY\n\n07-Aug-13 21:27:41 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nNORTH OF PLUM TREE LN\n\n07-Aug-13 21:26:55 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n480 REQ FIRE OR ROAD DEPT WITH CHAINSAWS\n\n07-Aug-13 21:25:22 - On Scene by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nHarmony Grove Rd, Troy\n\nATTEMPTING TO LOCATE\n\n07-Aug-13 21:08:28 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:08:23 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n\n\n07-Aug-13 21:02:53 - Entered by: 674 (Tracy Eden)\nTRAF H - Traffic Hazard (Priority 4)\nSource: Phone\n\nReporting Person: KATHY ATLER\nPhone: 314-749-2170\nLocation: Harmony Grove Rd, Troy\n\nTREE LIMBS IN RDWAY \nCALLER ADV ITS POSING A HAZARD \nITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\n07-Aug-13 21:02:53 - Initiated by: 674 (Tracy Eden)
(LCFPD) NEW 28-14-LL Traffic Hazard Harmony Grove Rd, Troy
(LCFPD) OCC #13-746, INC #13-46169 - 69 - Structure Fire\nTime Entered: 8/7/2013 7:10:18 PM\nReceived Via: Phone\n64 Cuivre River Dr, Troy\n\nCAMPER \nHEAVY WIRE ELECRTICAL SMELL \nCEILING IS HOT \n24FT ON WHEELS \nNOT ATTCHED \n\n\n\nIncident Log:\n\n07-Aug-13 19:40:16 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-46169 (13-746)  69 - Structure Fire\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 19:27:51 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46169 (13-746)  69 - Structure Fire\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:27:18 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n6403-- RETURNING IN SERVICE    6414 REMAINING ON SCENE\n\n07-Aug-13 19:25:09 - Memo by: 645 (Alisha Lewis)\nLincoln County Fire Fire Marshal 6403\n\nMEDCIS DISR PER FIRE \n\n\n07-Aug-13 19:25:03 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-46169 (13-3769)  69 - Structure Fire\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n07-Aug-13 19:24:49 - Reassign by: 645 (Alisha Lewis)\n\n\n07-Aug-13 19:24:49 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n07-Aug-13 19:24:41 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n6403  -- 10-25 MEIDCS\n\n07-Aug-13 19:23:39 - Backup by: 696 (Brittany Job)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n07-Aug-13 19:23:39 - Dispatched by: 696 (Brittany Job)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n07-Aug-13 19:20:20 - On Scene by: 645 (Alisha Lewis)\nLincoln County Fire Pumper 6414\n\n64 Cuivre River Dr, Troy\n\n\n\n07-Aug-13 19:16:47 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\nSTAT1  IN SERV WITH 2\n\n07-Aug-13 19:16:22 - Backup by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:16:22 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:14:55 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n6403-- WINEBEIGO\n\nSLIGHT SMELL OF SMOKE\n\nINSIDE CEILING CAMPER IS WARM\n\n07-Aug-13 19:14:52 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n64 Cuivre River Dr, Troy\n\n\n\n07-Aug-13 19:14:46 - Reassign by: 696 (Brittany Job)\n\n\n07-Aug-13 19:14:46 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 19:14:11 - Memo by: 645 (Alisha Lewis)\nLincoln County Fire Fire Station LCF Stn 1\n\nCALLER IS WITH HAWK POINT PD AND ADV THIS IS HIS PARENTS CAMPER \nHE ADV HE WANTS UNITS TO RESPOND NON CODE AND JUST WANTS A THERMAL IMAGE TO SEE WHERE ITS BURNING FROM \nHOWEVER CAN SMELL SOMETHING ELECTRICAL BURNING \nAND INSIDE CEILING IT HOTT\n\n07-Aug-13 19:13:43 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n6403  SINGLE STORY RANCH -- NOTHING SHOWING\n\n07-Aug-13 19:12:28 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n64 Cuivre River Dr, Troy\n[Entry Time: 07-Aug-13 19:16:28]\n\n\n\n07-Aug-13 19:12:14 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 19:11:36 - Memo by: 645 (Alisha Lewis)\nTHERMAL IMAGE NEEDED \n\n\n07-Aug-13 19:10:18 - Entered by: 645 (Alisha Lewis)\n69 - Structure Fire (Priority 5)\nSource: Phone\n\nReporting Person: 2607\nLocation: 64 Cuivre River Dr, Troy\n\nCAMPER \nHEAVY WIRE ELECRTICAL SMELL \nCEILING IS HOT \n24FT ON WHEELS \nNOT ATTCHED \n\n\n\n07-Aug-13 19:10:18 - Initiated by: 645 (Alisha Lewis)
(LCFPD) NEW 50-24-NN Structure Fire 64 Cuivre River Dr, Troy
(LCFPD) OCC #13-745, INC #13-45851 - 12 - Convulsions/Seizures\nTime Entered: 8/6/2013 2:08:21 PM\nReceived Via: WPH1\n1049 Sommerset Dr (Apt 109), Troy\n\nNEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\nIncident Log:\n\n06-Aug-13 14:28:49 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Ambulance Medic 2\n\n1 REFUSAL\n\n06-Aug-13 14:28:06 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:22:34 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45851 (13-745)  12 - Convulsions/Seizures\nLincoln County Fire Pumper 6414\n\nreleased from medics back in service\n\n06-Aug-13 14:19:41 - On Scene by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:16:07 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance 6705\n\npri three\n\n06-Aug-13 14:15:08 - On Scene by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:15:02 - On Scene by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:12:16 - Cleared Notebook by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n06-Aug-13 14:12:12 - Enroute by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:12:08 - Backup by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:12:08 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:11:58 - Enroute by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:11:54 - Backup by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n\n\n06-Aug-13 14:11:54 - Dispatched by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n\n\n06-Aug-13 14:11:23 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n119 advised.\n\n06-Aug-13 14:11:22 - Enroute by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:11:17 - Backup by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n\n\n06-Aug-13 14:11:17 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n\n\n06-Aug-13 14:10:13 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n06-Aug-13 14:08:21 - Entered by: 631 (Glen Moser)\n12 - Convulsions/Seizures (Priority 5)\nSource: WPH1\n\nReporting Person: CHEYNNE\nPhone: 636-775-0184\nAddress: AT&T MOBILITY - 769 Monroe St, Troy\nLocation: 1049 Sommerset Dr (Apt 109), Troy\n\nNEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\n06-Aug-13 14:08:21 - Initiated by: 631 (Glen Moser)
(LCFPD) NEW Convulsions/Seizures 1049 Sommerset Dr (Apt 109), Troy
(LCFPD) OCC #13-744, INC #13-45745 - ACC/MU - Motor Vehicle Accident Report\nTime Entered: 8/5/2013 10:10:43 PM\nReceived Via: Phone\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\nKID RAN OVER A PARKING CURB\n\nMALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\nDID NOT HIT BUILDING\n\nVEH-- WHITE BUICK \n\nNO INJURIES \n\n\n\nIncident Log:\n\n05-Aug-13 22:44:42 - Cleared Notebook by: 696 (Brittany Job)\nClear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n\n\n05-Aug-13 22:44:35 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n\n\n05-Aug-13 22:40:47 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n160-- PULLED CASE #\n\n05-Aug-13 22:38:03 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n160-- STATUS CLEAR\n\n05-Aug-13 22:18:40 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nPC2A0N\n\nROM-REVENUE     DATE: 08/05/2013  TIME: 22:18:57 DEST TERM: WC00FOXI\nDOR.GR70PC2A0N\n  OWNER NAME        CITY       LIC    LIY  VYR   VMA  KOV       VIN\nBROWN PATRICIA TO  TROY    *A PC2A0N   13   98   OLDS  P  1G3HN52K1W4823103 \n\n\n\nBROWN  JOSHUA B 1 30 1996  \n\nFROM-REVENUE     DATE: 08/05/2013  TIME: 22:19:34 DEST TERM: WC00FOXI\nQWRT.ORI/MO057013N.LNM/BROWN.FNM/JOSHUA.DOB/01301996\nDETAIL INFORMATION:\nOPER STAT/VALID               CDL STAT/\n LIC EXP DATE/03 04 2015   CLASS/F\n                       CURRENT NAME                                 DOB     SEX\n BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\nOLN/Y054221004\n                       ALIAS INFORMATION\n BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\nOLN/498114411\nSOC/498114411     HGT/507         WGT/130   EYE/BROWN\nRESIDENT ADDR/195 LEWIS ST APT 2         TROY                  MO  63379\n  PERMIT EXP/08 08 2013   CLASS/F\nISSUANCE INFORMATION:\n ENDORSEMENTS/\n  RESTRICTIONS/INTERMEDIATE LICENSE\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n\n\n05-Aug-13 22:17:24 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance 6705\n\nPT WITH LAW\n\n05-Aug-13 22:17:17 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n05-Aug-13 22:17:08 - On Scene by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:47 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n157--  CAN 10-25 MEIDCS AND FIRE\n\n05-Aug-13 22:16:47 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-744)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Fire Pumper 6414\n\n6705 ADVISED NO INJURIES ALL UNITS INCOMING CAN DISREGUARD\n\n05-Aug-13 22:16:21 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:17 - Reassign by: 698 (Elliott Burkemper)\n\n\n05-Aug-13 22:16:17 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 22:16:15 - On Scene by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:08 - Enroute by: 696 (Brittany Job)\nLincoln County Ambulance Ambulance Medic 5\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:49 - On Scene by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:44 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:35 - Enroute by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n76  FROM  CHERRY / LINCOLN\n\n05-Aug-13 22:15:32 - Backup by: 696 (Brittany Job)\nTroy Police Department Police Car 157\n\n\n\n05-Aug-13 22:15:32 - Dispatched by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n\n\n05-Aug-13 22:15:26 - Backup by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\n\n\n05-Aug-13 22:15:26 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\n\n\n05-Aug-13 22:14:12 - Enroute by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:14:08 - Backup by: 696 (Brittany Job)\nTroy Police Department Police Car 160\n\n\n\n05-Aug-13 22:14:08 - Dispatched by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n\n\n05-Aug-13 22:13:36 - Backup by: 698 (Elliott Burkemper)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n05-Aug-13 22:13:36 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n05-Aug-13 22:13:29 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n05-Aug-13 22:10:43 - Entered by: 696 (Brittany Job)\nACC/MU - Motor Vehicle Accident Report (Priority 5)\nSource: Phone\n\nReporting Person: KATE LANDRY\nPhone: 636-528-4918\nLocation: Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\nKID RAN OVER A PARKING CURB\n\nMALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\nDID NOT HIT BUILDING\n\nVEH-- WHITE BUICK \n\nNO INJURIES \n\n\n\n05-Aug-13 22:10:43 - Initiated by: 696 (Brittany Job)
(LCFPD) NEW Motor Vehicle Accident Report Hilltop Phillips 66 - 201 S Lincoln Dr, Troy
(LCFPD) OCC #13-743, INC #13-45673 - ACC/MU - Motor Vehicle Accident Report\nTime Entered: 8/5/2013 4:42:12 PM\nReceived Via: WPH1\nhwy 61 and hwy c - LINCOLN\n\nhwy c on the ramp nb offramp  \ntwo vehicles involved\nno ambulance\nyukon xl and  mazda 626\n\n\nIncident Log:\n\n05-Aug-13 17:01:40 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-3732)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n05-Aug-13 17:01:32 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\n1 refusal obtainied\n\n05-Aug-13 16:57:23 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-743)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:57:14 - Memo by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\ndisregarded by medics.\n\n05-Aug-13 16:57:10 - On Scene by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:55:53 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:53:25 - Cleared Notebook by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-6176)  ACC/MU - Motor Vehicle Accident Report\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\n\n\nMileage: 92592\n\n05-Aug-13 16:53:15 - On Scene by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\nhwy 61 and hwy c - LINCOLN\n\n\n\nMileage: 92592\n\n05-Aug-13 16:52:10 - Enroute by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:51:52 - Reassign by: 632 (Lori Reynolds)\n\n\n05-Aug-13 16:51:52 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n05-Aug-13 16:51:36 - Enroute by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:49:55 - Backup by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:49:55 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:49:49 - Backup by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\nMileage: 92592\n\n05-Aug-13 16:49:49 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n05-Aug-13 16:45:14 - Enroute by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\nhwy 61 and hwy c - LINCOLN\n\n\n\nMileage: 92592\n\n05-Aug-13 16:44:36 - Dispatched by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\n\n\nMileage: 92592\n\n05-Aug-13 16:42:12 - Entered by: 632 (Lori Reynolds)\nACC/MU - Motor Vehicle Accident Report (Priority 5)\nSource: WPH1\n\nReporting Person: jennifer\nPhone: 636-675-2032\nAddress: T-MOBILE USA - 83 DUGAN LN - SECTOR SE, LINCOLN\nLocation: hwy 61 and hwy c - LINCOLN\n\nhwy c on the ramp nb offramp  \ntwo vehicles involved\nno ambulance\nyukon xl and  mazda 626\n\n\n05-Aug-13 16:42:12 - Initiated by: 632 (Lori Reynolds)
(LCFPD) NEW Motor Vehicle Accident Report hwy 61 and hwy c - LINCOLN
(LCFPD) OCC #13-742, INC #13-45643 - 3 - Animal Bites/Attacks\nTime Entered: 8/5/2013 2:26:38 PM\nReceived Via: RESD\n6002 Saddle Ridge Rd, Troy\n\n11yo child bitten by a \ngreat dane \nbite to the left fore arm \n\n\nIncident Log:\n\n05-Aug-13 16:35:02 - Cleared RTF by: 686 (James Roberts)\nClear Incident 13-45643 (13-166)  3 - Animal Bites/Attacks\nOutside Agency Outside Agency Outside Ag\n\nlake st louis provide the info\n\n05-Aug-13 16:14:31 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 15:53:03 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 15:51:00 - Backup by: 686 (James Roberts)\nOutside Agency Outside Agency Outside Ag\n\n\n\n05-Aug-13 15:51:00 - Dispatched by: 686 (James Roberts)\nOutside Agency Outside Agency Outside Ag\n\n\n\n05-Aug-13 15:50:23 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nlake st louis will do the outside agency assit\n\n05-Aug-13 15:47:35 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-3729)  3 - Animal Bites/Attacks\nLincoln County Ambulance Ambulance Medic 3\n\n\n\n05-Aug-13 15:29:30 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\ncontact st charles co poss to do a outside agency assist to get info \njim and linda wilson with devon wilson\n\n05-Aug-13 15:15:45 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n05-Aug-13 15:14:55 - Memo by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nCANCEL REF LAST INFO ADDED\n\n05-Aug-13 15:14:11 - Memo by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n476 ADVISED TO CANCEL ANY FURTHER, SUBJ IS IN TEH LOBBY OF 65\n\n05-Aug-13 15:06:47 - On Scene by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 15:05:25 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nper 470 \n\nowner of the k-9 would like it put down and the human socity they wont come and get the dog\n\n05-Aug-13 14:53:00 - Cleared Notebook by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-742)  3 - Animal Bites/Attacks\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 14:52:46 - Enroute by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n05-Aug-13 14:43:49 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:38:46 - Backup by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\n\n\n\n05-Aug-13 14:38:46 - Dispatched by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 14:37:34 - Memo by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6414 ADV PRI THREE PATIENT\n\n05-Aug-13 14:36:13 - On Scene by: 612 (Margie Harrell)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:36:11 - On Scene by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:31:15 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nunsure if the dog was being aggressive  \nchild was going out to feed and water him \n the great dane is 9months old\n\n05-Aug-13 14:30:25 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nskin at the bite is ripped, not just a puncture wound \n\n\n05-Aug-13 14:30:08 - Enroute by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:30:02 - Reassign by: 632 (Lori Reynolds)\n\n\n05-Aug-13 14:30:02 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 14:29:21 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n17 got dog 2wks ago \nthey adv that he had his shots \ndoes  not have a record of the shots\ndoes not what vet goes to \nowner prior is unsure of the name \n\n\n05-Aug-13 14:29:15 - Enroute by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:28:59 - Backup by: 686 (James Roberts)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:52 - Backup by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:52 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:32 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nk9 is in the kennel \nall others are put up as well\n\n05-Aug-13 14:27:42 - Dispatched by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n\n\n05-Aug-13 14:26:38 - Entered by: 612 (Margie Harrell)\n3 - Animal Bites/Attacks (Priority 5)\nSource: RESD\n\nReporting Person: NAVOLT\nPhone: 636-4621325\nAddress: 6002 Saddle Ridge Rd, Troy\nLocation: 6002 Saddle Ridge Rd, Troy\n\n11yo child bitten by a \ngreat dane \nbite to the left fore arm \n\n\n05-Aug-13 14:26:38 - Initiated by: 612 (Margie Harrell)

Contact: Active911
Agency name: Eolia Community FPD
Location: Eolia, MO, United States
Sender: EnterpolAlerts@PikeCountySO.org, lincolncounty911@LC911Dispatch.org

(HISTORY FOR OCC #OUTS, INC #13-4717 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4717 - FIRE - Fire\nTime Entered: 8/7/2013 5:33:46 AM\nReceived Via: 911\n307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents\n\nIncident Log:\n\n07-Aug-13 14:05:28 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 12:55:33 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n412 at the SO with Samantha Wilson\n\n07-Aug-13 12:46:17 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n412 enroute to the SO with one white female beginning milage 97793\n\n07-Aug-13 12:46:12 - Reassign by: 20 (Kristina Garrison)\n\n\n07-Aug-13 12:46:12 - Dispatched by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 12:05:30 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 422\nPreston Hipes - 422\n\n422 enroute back to the SO\n\n07-Aug-13 12:02:17 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\n400 back in service\n\nMileage: 12339\n\n07-Aug-13 11:46:42 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\nback in service\n\n07-Aug-13 11:45:55 - Cleared RTF by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 11:45:41 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 410\nMike Starman - 410\n\n410 back in service\n\n07-Aug-13 11:01:15 - On Scene by: 20 (Kristina Garrison)\nPike County SO Patrol 422\nPreston Hipes - 422\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 11:01:12 - Backup by: 20 (Kristina Garrison)\nPike County SO Patrol 422\n\n07-Aug-13 11:01:12 - Dispatched by: 20 (Kristina Garrison)\nPike County SO Patrol 422\nPreston Hipes - 422\n\n07-Aug-13 10:25:33 - On Scene by: 27 (Jordan Anderson)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:10:32 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nsubject\nOPER STAT/VALID               CDL STAT/VALID\n LIC EXP DATE/08 22 2018   CLASS/A\n                       CURRENT NAME                                 DOB     SEX\n MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\nOLN/Y113233001\n                       ALIAS INFORMATION\n MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\nOLN/490662678\nSOC/490662678     HGT/604         WGT/208   EYE/HAZEL\nRESIDENT ADDR/29950 PIKE 338             NEW HARTFORD          MO  63359\n  PERMIT EXP/03 15 2006   CLASS/M\nPEND STAT/APPEAL                    SCHOOL BUS STAT/\nISSUANCE INFORMATION:\n ENDORSEMENTS/MOTORCYCLE                       DOUBLE AND TRIPLE TRAILERS\n  RESTRICTIONS/CORRECTIVE LENSES\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n ACTION INFORMATION:\n 1 TYPE/CHILD SUPPORT ENFORCEMENT SUSP      CASE NO/CS09002199  EFF DT/06062009\n   STATUS/STAYED APPEALED                 ELIGIBLE REI/           OFFENSE ST/\n OUT OF STATE CONVICTIONS:\n 1 CON TYPE/I CON DATE/11 18 2011 FAIL TO APPEAR FOR TRIAL       STATE/IN\n   OS LOCATOR/11112307078450     CMV/Y HAZ/N        ARREST DT/09 23 2011\n\n07-Aug-13 10:09:57 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nsubject\nOPER STAT/VALID               CDL STAT/\n LIC EXP DATE/05 09 2015   CLASS/E\n                       CURRENT NAME                                 DOB     SEX\n WILSON                   ,SAMANTHA        LEE                   05 09 1975  F\nOLN/G113273001\n                       ALIAS INFORMATION\n MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\nOLN/G113273001\n MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\nOLN/497766759\n JENNINGS                 ,SAMANTHA        LEE                   05 09 1975  F\nOLN/497766759\nSOC/497766759     HGT/501         WGT/190   EYE/BLUE\nRESIDENT ADDR/101 S. LOCUST APT E        CURRYVILLE            MO  63339\nMOST CUR ADDR/308 W MAPLE ST             CURRYVILLE            MO  633391016\nISSUANCE INFORMATION:\n ENDORSEMENTS/\n  RESTRICTIONS/\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n07-Aug-13 10:09:43 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:09:34 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 10:08:56 - Enroute by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:08:54 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 410\n\n07-Aug-13 10:08:54 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n07-Aug-13 10:08:51 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:08:49 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 412\n\nMileage: 12339\n\n07-Aug-13 10:08:49 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 10:05:47 - Enroute by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n307 W MAPLE ST, Curryville\n\n6900 enroute to curryville to assist 400\n\n07-Aug-13 10:05:43 - Backup by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\nMileage: 12339\n\n07-Aug-13 10:05:43 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 08:59:33 - Memo by: 27 (Jordan Anderson)\nCurryville FD Fire Station CurrFD Stn\n\nFire Marshal on scene\n\n07-Aug-13 08:59:30 - On Scene by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\n307 W MAPLE ST, Curryville\n\nMileage: 12339\n\n07-Aug-13 08:59:28 - Backup by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\n\n07-Aug-13 08:59:28 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\nMileage: 12339\n\n07-Aug-13 08:51:25 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Fire Station BGFD Stn\n\nall units clear scene\n\n07-Aug-13 08:51:22 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Pumper 1820\n\n07-Aug-13 08:51:18 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Pumper 1810\n\n07-Aug-13 08:37:40 - Memo by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n1820 Clear of scene returning to quarters\n\n07-Aug-13 08:35:54 - Memo by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n1810 Clear of scene returning to Bowling Green\n\n07-Aug-13 07:11:46 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\nClear of scene\n\n07-Aug-13 07:11:24 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 409\nJody Blaylock - 421\n\nClear of scene\n\n07-Aug-13 06:18:29 - On Scene by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 06:08:42 - Memo by: 229 (Josh Langley)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nPCMH ems on scene at 06:03\n\n07-Aug-13 06:08:01 - Enroute by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n307 W MAPLE ST, Curryville\n\n1810 en route with 4\n\n07-Aug-13 06:07:59 - Backup by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n07-Aug-13 06:07:59 - Dispatched by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n07-Aug-13 06:07:53 - On Scene by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 06:07:25 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1810 enroute at 06:09\n\n07-Aug-13 06:06:41 - Memo by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\ntime of second page 05:36\n\n07-Aug-13 06:06:26 - Memo by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\ntime of first page 05:34\n\n07-Aug-13 06:00:28 - On Scene by: 229 (Josh Langley)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n[Entry Time: 07-Aug-13 06:05:28]\n\n07-Aug-13 05:55:06 - Enroute by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n307 W MAPLE ST, Curryville\n\nen route with 2\n\n07-Aug-13 05:55:04 - Dispatched by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n07-Aug-13 05:55:04 - Backup by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n07-Aug-13 05:54:08 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1820 enroute to curryville\n\n07-Aug-13 05:48:44 - Enroute by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n307 W MAPLE ST, Curryville\n\n800 816 enroute at 05:50\n\n07-Aug-13 05:47:25 - Enroute by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n307 W MAPLE ST, Curryville\n\n824 enroute to station\n\n07-Aug-13 05:46:59 - Enroute by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 05:46:57 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 409\nJody Blaylock - 421\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 05:46:54 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 412\n\n07-Aug-13 05:46:54 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 05:46:50 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 409\n\n07-Aug-13 05:46:50 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 409\nJody Blaylock - 421\n\n07-Aug-13 05:45:26 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1220 enroute\n\n07-Aug-13 05:44:06 - Backup by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n07-Aug-13 05:44:06 - Dispatched by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n07-Aug-13 05:35:05 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1241 1242 1223 enroute to station 05:36\n\n07-Aug-13 05:35:02 - Dispatched by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n07-Aug-13 05:34:57 - Initiated by: 229 (Josh Langley)\n[Entry Time: 07-Aug-13 05:33:46]\n\n07-Aug-13 05:33:46 - Entered by: 229 (Josh Langley)\nFIRE - Fire (Priority 2)\nSource: 911\n\nReporting Person: HERSCHEL TALLEY\nPhone: 573-324-5711\nAddress: 307 W MAPLE ST, Curryville\nLocation: 307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents
(HISTORY FOR OCC #OUTS, INC #13-4729 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4729 - FIRE - Fire\nTime Entered: 8/7/2013 10:09:41 AM\nReceived Via: 911\n307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents\n\nIncident Log:\n\n07-Aug-13 11:11:21 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4729 (OUTS)  FIRE - Fire\nEolia FD Fire Station EFD Stn\n\n6900 back in quarters\n\n\n07-Aug-13 10:09:49 - Enroute by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:09:47 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 10:09:43 - Initiated by: 20 (Kristina Garrison)\n\n\n07-Aug-13 10:09:41 - Entered by: 20 (Kristina Garrison)
(NEWOCC #OUTS  FIRE - Fire) NEWOCC #OUTS  FIRE - Fire\nAddress: 307 W MAPLE ST, Curryville\nReporting Person: HERSCHEL Phone: 573-324-5711\nDetail: caller stated that house next to them is on fire and subject still in the residents
(HISTORY FOR OCC #OUTS, INC #13-4723 - MEDAID - Medical - Aid, AGENCY: Eolia FD) OCC #OUTS, INC #13-4723 - MEDAID - Medical - Aid\nTime Entered: 8/7/2013 8:00:55 AM\nReceived Via: 911\n196 N OLD HWY 61, Eolia\n\n86 yr old female possible stroke\n\nIncident Log:\n\n07-Aug-13 09:58:21 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 09:58:17 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\nEolia FD Utility Truck 6919\n\n07-Aug-13 08:45:43 - Memo by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\nper 6900 all units clear enroute to house one back in service\n\n07-Aug-13 08:45:01 - Memo by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\n6902 clear of scene back in service\n\n07-Aug-13 08:13:59 - On Scene by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n196 N OLD HWY 61, Eolia\n\n6908 on scene\n\n07-Aug-13 08:13:57 - Backup by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:13:57 - Dispatched by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:10:13 - Memo by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n6900 enroute direct\n\n07-Aug-13 08:09:02 - Memo by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n6908 enroute from Auburn junction\n\n07-Aug-13 08:08:39 - Reassign by: 20 (Kristina Garrison)\n\n\n07-Aug-13 08:08:39 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n07-Aug-13 08:08:25 - Enroute by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\n196 N OLD HWY 61, Eolia\n\n6919 responding with 2\n\n07-Aug-13 08:01:54 - Modified by: 27 (Jordan Anderson)\nReporting Person: Mills Shelia\n\n07-Aug-13 08:01:48 - Memo by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\nFirst page\n\n07-Aug-13 08:01:46 - Dispatched by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:01:11 - Initiated by: 27 (Jordan Anderson)\n\n\n07-Aug-13 08:00:55 - Entered by: 27 (Jordan Anderson)\nMEDAID - Medical - Aid (Priority 2)\nSource: 911\n\nReporting Person: CLYDE SHEPHERD\nPhone: 573-485-7983\nAddress: 196 N OLD HWY 61, Eolia\nLocation: 196 N OLD HWY 61, Eolia\n\n86 yr old female possible stroke
(NEWOCC #OUTS  MEDAID - Medical - Aid) NEWOCC #OUTS  MEDAID - Medical - Aid\nAddress: 196 N OLD HWY 61, Eolia\nReporting Person: CLYDE Phone: 573-485-7983\nDetail: 86 yr old female possible stroke
(HISTORY FOR OCC #13-17, INC #13-45229 - DOM VI - Domestic Violence, AGENCY: Eolia Fire) OCC #13-17, INC #13-45229 - DOM VI - Domestic Violence\nTime Entered: 8/3/2013 12:28:24 PM\nReceived Via: Phone\n11 White Ln, Eolia\n\n4 party call in ref to a male and female \nphysically fight in the yard\n\nIncident Log:\n\n03-Aug-13 14:50:16 - Cleared RTF by: 658 (Ronnie Martin)\nClear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 14:12:16 - On Scene by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n03-Aug-13 13:40:11 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n03-Aug-13 13:35:23 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n\n\n03-Aug-13 13:35:08 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n451- adv call was medical \nno domestic\n\n03-Aug-13 13:34:05 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n451-adv domestic unfounded \n\nfemale pat was transported - drank large amounts of alcohol and took s pills \n\n10-8\n\n03-Aug-13 13:28:19 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 13:28:16 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 13:03:48 - Memo by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\npri 3\n\n03-Aug-13 13:01:33 - On Scene by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 13:00:34 - On Scene by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n11 White Ln, Eolia\n[Entry Time: 03-Aug-13 13:03:34]\n\n\n\n03-Aug-13 12:59:51 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-106)  DOM VI - Domestic Violence\nARCH Helicopter ARCH ARCH\n\nstand down on air \n\n\n\n03-Aug-13 12:59:45 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:59:33 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-142)  DOM VI - Domestic Violence\nAir Evac Air Evac AIRE\n\nstand down air \n\n\n03-Aug-13 12:58:56 - Enroute by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:58:52 - Backup by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 12:58:52 - Dispatched by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 12:57:55 - Memo by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\nair 23 at base - adam is checking weather \n\n\n\n03-Aug-13 12:57:50 - Backup by: 692 (Stacey Miederhoff)\nARCH Helicopter ARCH ARCH\n\n\n\n03-Aug-13 12:57:50 - Dispatched by: 692 (Stacey Miederhoff)\nARCH Helicopter ARCH ARCH\n\n\n\n03-Aug-13 12:57:08 - Backup by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\n\n\n03-Aug-13 12:57:08 - Dispatched by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\n\n\n03-Aug-13 12:56:56 - Backup by: 645 (Alisha Lewis)\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 12:56:56 - Dispatched by: 645 (Alisha Lewis)\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 12:55:57 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\nunknown of what type of pills - subject is breathing but incherant\n\n03-Aug-13 12:51:41 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:51:38 - Backup by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:51:38 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:51:23 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:49:15 - Backup by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 12:49:15 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 12:48:44 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n414 - requesting medics respond \n\nmale subject - poss over dose with pills \n\nscene secure\n\n03-Aug-13 12:47:48 - On Scene by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:44:44 - On Scene by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:36:36 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:32:31 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:32:25 - Backup by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\n\n\n\n03-Aug-13 12:32:25 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n\n\n03-Aug-13 12:32:16 - Reassign by: 692 (Stacey Miederhoff)\n\n\n03-Aug-13 12:32:16 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n\n\n03-Aug-13 12:32:05 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 490 Beat: County\nMichael Pirtle - 490\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:31:10 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 490 Beat: County\nMichael Pirtle - 490\n\n\n\n03-Aug-13 12:28:24 - Entered by: 658 (Ronnie Martin)\nDOM VI - Domestic Violence (Priority 5)\nSource: Phone\n\nReporting Person: pike co\nLocation: 11 White Ln, Eolia\n\n4 party call in ref to a male and female \nphysically fight in the yard\n\n03-Aug-13 12:28:24 - Initiated by: 658 (Ronnie Martin)
(NEWOCC #13-17  Domestic Violence) NEW Domestic Violence 11 White Ln, Eolia
(HISTORY FOR OCC #OUTS, INC #13-44692 - TEST - Test, AGENCY: Eolia Fire) OCC #OUTS, INC #13-44692 - TEST - Test\nTime Entered: 7/31/2013 5:28:55 PM\nReceived Via: Phone\nLincoln Co 911 - 250 W College St, Troy\n\nTEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\nIncident Log:\n\n31-Jul-13 17:30:07 - Cleared Notebook by: 612 (Margie Harrell)\nClear Incident 13-44692 (OUTS)  TEST - Test\nEolia Fire Fire Station EOLIA FD\n\n\n\n31-Jul-13 17:29:50 - Memo by: 612 (Margie Harrell)\nEolia Fire Fire Station EOLIA FD\n\nTEST MESSAGE ONLY LET ME KNOW IF YOU GOT THIS \nTHANKS\n\n31-Jul-13 17:29:25 - Dispatched by: 612 (Margie Harrell)\nEolia Fire Fire Station EOLIA FD\n\n\n\n31-Jul-13 17:28:55 - Entered by: 612 (Margie Harrell)\nTEST - Test (Priority 2)\nSource: Phone\n\nLocation: Lincoln Co 911 - 250 W College St, Troy\n\nTEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\n31-Jul-13 17:28:55 - Initiated by: 612 (Margie Harrell)
(NEWOCC #OUTS  Test) NEW Test Lincoln Co 911 - 250 W College St, Troy
(HISTORY FOR OCC #OUTS, INC #13-4500 - MEDAID - Medical - Aid, AGENCY: Eolia FD) OCC #OUTS, INC #13-4500 - MEDAID - Medical - Aid\nTime Entered: 7/27/2013 10:29:52 AM\nReceived Via: 911\nCOMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\nHer name is Windell Shelton has fallin and hit her head.\n\nIncident Log:\n\n27-Jul-13 11:15:57 - Cleared Notebook by: 25 (Melinda Chatman)\nClear Incident 13-4500 (OUTS)  MEDAID - Medical - Aid\nEolia FD 1st Responders EFD 1st\n\n6902 called in and all units are clear\n[Entry Time: 27-Jul-13 11:27:57]\n\n27-Jul-13 10:45:46 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nper 6900 contacting PCMH to find out which unit is responding to this incident so that they can which over to the Eolia repeater\n\n27-Jul-13 10:43:30 - Modified by: 25 (Melinda Chatman)\nLocation: COMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\n27-Jul-13 10:42:54 - On Scene by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6901 on scene\n\n27-Jul-13 10:42:21 - On Scene by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6900 and 6902 on scene\n\n27-Jul-13 10:37:36 - Enroute by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6900 and 6902 e/r\n\n27-Jul-13 10:36:18 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\ntime of second page\n\n27-Jul-13 10:33:01 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nTime of first page\n\n27-Jul-13 10:32:57 - Dispatched by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\n27-Jul-13 10:32:44 - Initiated by: 25 (Melinda Chatman)\n[Entry Time: 27-Jul-13 10:29:52]\n\n27-Jul-13 10:29:52 - Entered by: 25 (Melinda Chatman)\nMEDAID - Medical - Aid (Priority 2)\nSource: 911\n\nReporting Person: Sharon nurse\nPhone: 573-324-3444\nAddress: COMMUNITY; IN-HOME SERVICES - 209 BUSINESS HIGHWAY 61 N, Bowling Green\nLocation: COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\nHer name is Windell Shelton has fallin and hit her head.
(NEWOCC #OUTS  MEDAID - Medical - Aid) NEWOCC #OUTS  MEDAID - Medical - Aid\nAddress: COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\nReporting Person: Sharon Phone: 573-324-3444\nDetail: Her name is Windell Shelton has fallin and hit her head.
(HISTORY FOR OCC #OUTS, INC #13-4457 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4457 - FIRE - Fire\nTime Entered: 7/25/2013 2:52:20 PM\nReceived Via: Phone\nEolia\n\ntest test test\n\nIncident Log:\n\n25-Jul-13 14:54:50 - Cleared Notebook by: 227 (Charlotte Schroeder)\nClear Incident 13-4457 (OUTS)  FIRE - Fire\nEolia FD Pumper/Rescue 6910\n\ntest test\n\n25-Jul-13 14:54:15 - On Scene by: 227 (Charlotte Schroeder)\nEolia FD Pumper/Rescue 6910\n\nEolia\n\ntest test test test\n\n25-Jul-13 14:53:02 - Dispatched by: 227 (Charlotte Schroeder)\nEolia FD Pumper/Rescue 6910\n\n25-Jul-13 14:52:48 - Initiated by: 227 (Charlotte Schroeder)\n\n\n25-Jul-13 14:52:20 - Entered by: 227 (Charlotte Schroeder)\nFIRE - Fire (Priority 2)\nSource: Phone\n\nReporting Person: test\nLocation: Eolia\n\ntest test test

*/

public class MOLincolnCountyParserTest extends BaseParserTest {
  
  public MOLincolnCountyParserTest() {
    setParser(new MOLincolnCountyParser(), "LINCOLN COUNTY", "MO");
  }

  @Test
  public void testLincolnCountyFireProtectionDistrict() {

    doTest("T1",
        "(LCFPD) OCC #13-748, INC #13-46201 - ALARM - Alarm\n" +
        "Time Entered: 8/7/2013 10:13:31 PM\n" +
        "Received Via: Phone\n" +
        "300 Marble St (Apt 20), Troy\n\n" +
        "FIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\n" +
        "NO FIRE \n" +
        "NO SMOKE\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 22:31:14 - Cleared RTF by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-46201 (13-748)  ALARM - Alarm\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "07-Aug-13 22:25:08 - Memo by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "STATUS CLEAR FAULTY DETECTOR\n\n" +
        "07-Aug-13 22:19:48 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6414-- NOTHING SHOWING -- SINGLE STORY\n\n" +
        "07-Aug-13 22:19:36 - On Scene by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "300 Marble St (Apt 20), Troy\n\n\n\n" +
        "07-Aug-13 22:17:05 - Enroute by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "300 Marble St (Apt 20), Troy\n\n\n\n" +
        "07-Aug-13 22:15:49 - Dispatched by: 674 (Tracy Eden)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "07-Aug-13 22:15:23 - Memo by: 696 (Brittany Job)\n" +
        "ALARMS HAVE STOPPED FOR THE MOMENT \n\n\n\n" +
        "07-Aug-13 22:15:00 - Memo by: 696 (Brittany Job)\n" +
        "FIANCE AND DAUGHTER IS WITH HER\n\n\n\n" +
        "07-Aug-13 22:13:31 - Entered by: 696 (Brittany Job)\n" +
        "ALARM - Alarm (Priority 5)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: ELIZABETH TAYLOR\n" +
        "Phone: 63-358-8751\n" +
        "Location: 300 Marble St (Apt 20), Troy\n\n" +
        "FIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\n" +
        "NO FIRE \n" +
        "NO SMOKE\n\n" +
        "07-Aug-13 22:13:31 - Initiated by: 696 (Brittany Job)",

        "CALL:RUN REPORT",
        "ID:13-46201",
        "PLACE:OCC #13-748, INC #13-46201 - ALARM - Alarm\nTime Entered: 8/7/2013 10:13:31 PM\nReceived Via: Phone\n300 Marble St (Apt 20), Troy\n\nFIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\nNO FIRE \nNO SMOKE\n\nIncident Log:\n\n07-Aug-13 22:31:14 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-46201 (13-748)  ALARM - Alarm\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 22:25:08 - Memo by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\nSTATUS CLEAR FAULTY DETECTOR\n\n07-Aug-13 22:19:48 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n6414-- NOTHING SHOWING -- SINGLE STORY\n\n07-Aug-13 22:19:36 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n300 Marble St (Apt 20), Troy\n\n\n\n07-Aug-13 22:17:05 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n300 Marble St (Apt 20), Troy\n\n\n\n07-Aug-13 22:15:49 - Dispatched by: 674 (Tracy Eden)\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 22:15:23 - Memo by: 696 (Brittany Job)\nALARMS HAVE STOPPED FOR THE MOMENT \n\n\n\n07-Aug-13 22:15:00 - Memo by: 696 (Brittany Job)\nFIANCE AND DAUGHTER IS WITH HER\n\n\n\n07-Aug-13 22:13:31 - Entered by: 696 (Brittany Job)\nALARM - Alarm (Priority 5)\nSource: Phone\n\nReporting Person: ELIZABETH TAYLOR\nPhone: 63-358-8751\nLocation: 300 Marble St (Apt 20), Troy\n\nFIRE ALAMRS KEEP GOIGN OFF RANDOMLY\n\nNO FIRE \nNO SMOKE\n\n07-Aug-13 22:13:31 - Initiated by: 696 (Brittany Job)");

    doTest("T2",
        "(LCFPD) NEW Alarm 300 Marble St (Apt 20), Troy",
        "CALL:Alarm",
        "ADDR:300 Marble St (Apt 20)",
        "MADDR:300 Marble St",
        "CITY:Troy");

    doTest("T3",
        "(LCFPD) OCC #13-747, INC #13-46188 - TRAF H - Traffic Hazard\n" +
        "Time Entered: 8/7/2013 9:02:53 PM\n" +
        "Received Via: Phone\n" +
        "Harmony Grove Rd, Troy\n\n" +
        "TREE LIMBS IN RDWAY \n" +
        "CALLER ADV ITS POSING A HAZARD \n" +
        "ITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 22:04:53 - Cleared RTF by: 696 (Brittany Job)\n" +
        "Clear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\n" +
        "Lincoln County Fire Brush 6448\n\n\n\n" +
        "07-Aug-13 22:04:47 - Cleared Notebook by: 696 (Brittany Job)\n" +
        "Clear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\n" +
        "Lincoln County Fire Pumper 6444\n\n\n\n" +
        "07-Aug-13 22:04:07 - Cleared Notebook by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-46188 (13-16734)  TRAF H - Traffic Hazard\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "tree removed\n\n" +
        "07-Aug-13 22:03:53 - Cleared RTF by: 696 (Brittany Job)\n" +
        "Clear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\n" +
        "Lincoln County Fire Brush 6438\n\n\n\n" +
        "07-Aug-13 22:03:27 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n" +
        "TREE REMOVED\n" +
        "COUNTY HWY DEPT COME CHECK THE AREA\n\n" +
        "07-Aug-13 21:53:01 - Memo by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "480 OUT OF VEHICLE HELPING CLEAR THE ROADWAY\n\n" +
        "07-Aug-13 21:48:53 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n" +
        "UNITS ON SCENE CAN HANDLE\n\n" +
        "07-Aug-13 21:47:41 - On Scene by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6448\n\n" +
        "Harmony Grove Rd, Troy\n\n\n\n" +
        "07-Aug-13 21:47:38 - Backup by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6448\n\n\n\n" +
        "07-Aug-13 21:47:38 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6448\n\n\n\n" +
        "07-Aug-13 21:47:20 - On Scene by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n" +
        "Harmony Grove Rd, Troy\n\n\n\n" +
        "07-Aug-13 21:39:43 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n" +
        "6438-- DRIVER ONLY\n\n" +
        "07-Aug-13 21:39:15 - Enroute by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n" +
        "Harmony Grove Rd, Troy\n\n\n\n" +
        "07-Aug-13 21:39:12 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n\n\n" +
        "07-Aug-13 21:39:12 - Backup by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Brush 6438\n\n\n\n" +
        "07-Aug-13 21:35:04 - Enroute by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6444\n\n" +
        "500 Harmony Grove Rd, Troy\n\n" +
        "X 1\n\n" +
        "07-Aug-13 21:35:00 - Reassign by: 696 (Brittany Job)\n\n\n" +
        "07-Aug-13 21:35:00 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6444\n\n\n\n" +
        "07-Aug-13 21:33:33 - Backup by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n\n\n" +
        "07-Aug-13 21:33:33 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n\n\n" +
        "07-Aug-13 21:29:19 - Memo by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "BETWEEN PLUM TREE AND NATHANIEL ON THE STRAIGHT AWAY\n\n" +
        "07-Aug-13 21:27:41 - Memo by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "NORTH OF PLUM TREE LN\n\n" +
        "07-Aug-13 21:26:55 - Memo by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "480 REQ FIRE OR ROAD DEPT WITH CHAINSAWS\n\n" +
        "07-Aug-13 21:25:22 - On Scene by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "Harmony Grove Rd, Troy\n\n" +
        "ATTEMPTING TO LOCATE\n\n" +
        "07-Aug-13 21:08:28 - Enroute by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n" +
        "Harmony Grove Rd, Troy\n\n\n\n" +
        "07-Aug-13 21:08:23 - Dispatched by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Sheriff Patrol Car 480 Beat: Zone-1\n" +
        "Joe Henke - 480\n\n\n\n" +
        "07-Aug-13 21:02:53 - Entered by: 674 (Tracy Eden)\n" +
        "TRAF H - Traffic Hazard (Priority 4)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: KATHY ATLER\n" +
        "Phone: 314-749-2170\n" +
        "Location: Harmony Grove Rd, Troy\n\n" +
        "TREE LIMBS IN RDWAY \n" +
        "CALLER ADV ITS POSING A HAZARD \n" +
        "ITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\n" +
        "07-Aug-13 21:02:53 - Initiated by: 674 (Tracy Eden)",

        "CALL:RUN REPORT",
        "ID:13-46188",
        "PLACE:OCC #13-747, INC #13-46188 - TRAF H - Traffic Hazard\nTime Entered: 8/7/2013 9:02:53 PM\nReceived Via: Phone\nHarmony Grove Rd, Troy\n\nTREE LIMBS IN RDWAY \nCALLER ADV ITS POSING A HAZARD \nITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\nIncident Log:\n\n07-Aug-13 22:04:53 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 22:04:47 - Cleared Notebook by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Pumper 6444\n\n\n\n07-Aug-13 22:04:07 - Cleared Notebook by: 698 (Elliott Burkemper)\nClear Incident 13-46188 (13-16734)  TRAF H - Traffic Hazard\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\ntree removed\n\n07-Aug-13 22:03:53 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46188 (13-747)  TRAF H - Traffic Hazard\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 22:03:27 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nTREE REMOVED\nCOUNTY HWY DEPT COME CHECK THE AREA\n\n07-Aug-13 21:53:01 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n480 OUT OF VEHICLE HELPING CLEAR THE ROADWAY\n\n07-Aug-13 21:48:53 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nUNITS ON SCENE CAN HANDLE\n\n07-Aug-13 21:47:41 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:47:38 - Backup by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 21:47:38 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Brush 6448\n\n\n\n07-Aug-13 21:47:20 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:39:43 - Memo by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n6438-- DRIVER ONLY\n\n07-Aug-13 21:39:15 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:39:12 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 21:39:12 - Backup by: 696 (Brittany Job)\nLincoln County Fire Brush 6438\n\n\n\n07-Aug-13 21:35:04 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6444\n\n500 Harmony Grove Rd, Troy\n\nX 1\n\n07-Aug-13 21:35:00 - Reassign by: 696 (Brittany Job)\n\n\n07-Aug-13 21:35:00 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Pumper 6444\n\n\n\n07-Aug-13 21:33:33 - Backup by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 21:33:33 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 21:29:19 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nBETWEEN PLUM TREE AND NATHANIEL ON THE STRAIGHT AWAY\n\n07-Aug-13 21:27:41 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nNORTH OF PLUM TREE LN\n\n07-Aug-13 21:26:55 - Memo by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n480 REQ FIRE OR ROAD DEPT WITH CHAINSAWS\n\n07-Aug-13 21:25:22 - On Scene by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nHarmony Grove Rd, Troy\n\nATTEMPTING TO LOCATE\n\n07-Aug-13 21:08:28 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\nHarmony Grove Rd, Troy\n\n\n\n07-Aug-13 21:08:23 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Sheriff Patrol Car 480 Beat: Zone-1\nJoe Henke - 480\n\n\n\n07-Aug-13 21:02:53 - Entered by: 674 (Tracy Eden)\nTRAF H - Traffic Hazard (Priority 4)\nSource: Phone\n\nReporting Person: KATHY ATLER\nPhone: 314-749-2170\nLocation: Harmony Grove Rd, Troy\n\nTREE LIMBS IN RDWAY \nCALLER ADV ITS POSING A HAZARD \nITS IN THE 500BLK OF HARMONY GROVE RD IN BETWEEN THE CEMETARY AND YATES DR \n\n\n07-Aug-13 21:02:53 - Initiated by: 674 (Tracy Eden)");

    doTest("T4",
        "(LCFPD) NEW 28-14-LL Traffic Hazard Harmony Grove Rd, Troy",
        "CALL:28-14-LL Traffic Hazard",
        "ADDR:Harmony Grove Rd",
        "CITY:Troy");

    doTest("T5",
        "(LCFPD) OCC #13-746, INC #13-46169 - 69 - Structure Fire\n" +
        "Time Entered: 8/7/2013 7:10:18 PM\n" +
        "Received Via: Phone\n" +
        "64 Cuivre River Dr, Troy\n\n" +
        "CAMPER \n" +
        "HEAVY WIRE ELECRTICAL SMELL \n" +
        "CEILING IS HOT \n" +
        "24FT ON WHEELS \n" +
        "NOT ATTCHED \n\n\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 19:40:16 - Cleared RTF by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-46169 (13-746)  69 - Structure Fire\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "07-Aug-13 19:27:51 - Cleared RTF by: 696 (Brittany Job)\n" +
        "Clear Incident 13-46169 (13-746)  69 - Structure Fire\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n\n\n" +
        "07-Aug-13 19:27:18 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n" +
        "6403-- RETURNING IN SERVICE    6414 REMAINING ON SCENE\n\n" +
        "07-Aug-13 19:25:09 - Memo by: 645 (Alisha Lewis)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n" +
        "MEDCIS DISR PER FIRE \n\n\n" +
        "07-Aug-13 19:25:03 - Cleared RTF by: 645 (Alisha Lewis)\n" +
        "Clear Incident 13-46169 (13-3769)  69 - Structure Fire\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n\n\n" +
        "07-Aug-13 19:24:49 - Reassign by: 645 (Alisha Lewis)\n\n\n" +
        "07-Aug-13 19:24:49 - Dispatched by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n\n\n" +
        "07-Aug-13 19:24:41 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n" +
        "6403  -- 10-25 MEIDCS\n\n" +
        "07-Aug-13 19:23:39 - Backup by: 696 (Brittany Job)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "07-Aug-13 19:23:39 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "07-Aug-13 19:20:20 - On Scene by: 645 (Alisha Lewis)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "64 Cuivre River Dr, Troy\n\n\n\n" +
        "07-Aug-13 19:16:47 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "STAT1  IN SERV WITH 2\n\n" +
        "07-Aug-13 19:16:22 - Backup by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n\n\n" +
        "07-Aug-13 19:16:22 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n\n\n" +
        "07-Aug-13 19:14:55 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6403-- WINEBEIGO\n\n" +
        "SLIGHT SMELL OF SMOKE\n\n" +
        "INSIDE CEILING CAMPER IS WARM\n\n" +
        "07-Aug-13 19:14:52 - Enroute by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "64 Cuivre River Dr, Troy\n\n\n\n" +
        "07-Aug-13 19:14:46 - Reassign by: 696 (Brittany Job)\n\n\n" +
        "07-Aug-13 19:14:46 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "07-Aug-13 19:14:11 - Memo by: 645 (Alisha Lewis)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n" +
        "CALLER IS WITH HAWK POINT PD AND ADV THIS IS HIS PARENTS CAMPER \n" +
        "HE ADV HE WANTS UNITS TO RESPOND NON CODE AND JUST WANTS A THERMAL IMAGE TO SEE WHERE ITS BURNING FROM \n" +
        "HOWEVER CAN SMELL SOMETHING ELECTRICAL BURNING \n" +
        "AND INSIDE CEILING IT HOTT\n\n" +
        "07-Aug-13 19:13:43 - Memo by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n" +
        "6403  SINGLE STORY RANCH -- NOTHING SHOWING\n\n" +
        "07-Aug-13 19:12:28 - On Scene by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Marshal 6403\n\n" +
        "64 Cuivre River Dr, Troy\n" +
        "[Entry Time: 07-Aug-13 19:16:28]\n\n\n\n" +
        "07-Aug-13 19:12:14 - Dispatched by: 696 (Brittany Job)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n\n\n" +
        "07-Aug-13 19:11:36 - Memo by: 645 (Alisha Lewis)\n" +
        "THERMAL IMAGE NEEDED \n\n\n" +
        "07-Aug-13 19:10:18 - Entered by: 645 (Alisha Lewis)\n" +
        "69 - Structure Fire (Priority 5)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: 2607\n" +
        "Location: 64 Cuivre River Dr, Troy\n\n" +
        "CAMPER \n" +
        "HEAVY WIRE ELECRTICAL SMELL \n" +
        "CEILING IS HOT \n" +
        "24FT ON WHEELS \n" +
        "NOT ATTCHED \n\n\n\n" +
        "07-Aug-13 19:10:18 - Initiated by: 645 (Alisha Lewis)",

        "CALL:RUN REPORT",
        "ID:13-46169",
        "PLACE:OCC #13-746, INC #13-46169 - 69 - Structure Fire\nTime Entered: 8/7/2013 7:10:18 PM\nReceived Via: Phone\n64 Cuivre River Dr, Troy\n\nCAMPER \nHEAVY WIRE ELECRTICAL SMELL \nCEILING IS HOT \n24FT ON WHEELS \nNOT ATTCHED \n\n\n\nIncident Log:\n\n07-Aug-13 19:40:16 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-46169 (13-746)  69 - Structure Fire\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 19:27:51 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-46169 (13-746)  69 - Structure Fire\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:27:18 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n6403-- RETURNING IN SERVICE    6414 REMAINING ON SCENE\n\n07-Aug-13 19:25:09 - Memo by: 645 (Alisha Lewis)\nLincoln County Fire Fire Marshal 6403\n\nMEDCIS DISR PER FIRE \n\n\n07-Aug-13 19:25:03 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-46169 (13-3769)  69 - Structure Fire\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n07-Aug-13 19:24:49 - Reassign by: 645 (Alisha Lewis)\n\n\n07-Aug-13 19:24:49 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n07-Aug-13 19:24:41 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n6403  -- 10-25 MEIDCS\n\n07-Aug-13 19:23:39 - Backup by: 696 (Brittany Job)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n07-Aug-13 19:23:39 - Dispatched by: 696 (Brittany Job)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n07-Aug-13 19:20:20 - On Scene by: 645 (Alisha Lewis)\nLincoln County Fire Pumper 6414\n\n64 Cuivre River Dr, Troy\n\n\n\n07-Aug-13 19:16:47 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\nSTAT1  IN SERV WITH 2\n\n07-Aug-13 19:16:22 - Backup by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:16:22 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n\n\n07-Aug-13 19:14:55 - Memo by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n6403-- WINEBEIGO\n\nSLIGHT SMELL OF SMOKE\n\nINSIDE CEILING CAMPER IS WARM\n\n07-Aug-13 19:14:52 - Enroute by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n64 Cuivre River Dr, Troy\n\n\n\n07-Aug-13 19:14:46 - Reassign by: 696 (Brittany Job)\n\n\n07-Aug-13 19:14:46 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Pumper 6414\n\n\n\n07-Aug-13 19:14:11 - Memo by: 645 (Alisha Lewis)\nLincoln County Fire Fire Station LCF Stn 1\n\nCALLER IS WITH HAWK POINT PD AND ADV THIS IS HIS PARENTS CAMPER \nHE ADV HE WANTS UNITS TO RESPOND NON CODE AND JUST WANTS A THERMAL IMAGE TO SEE WHERE ITS BURNING FROM \nHOWEVER CAN SMELL SOMETHING ELECTRICAL BURNING \nAND INSIDE CEILING IT HOTT\n\n07-Aug-13 19:13:43 - Memo by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n6403  SINGLE STORY RANCH -- NOTHING SHOWING\n\n07-Aug-13 19:12:28 - On Scene by: 696 (Brittany Job)\nLincoln County Fire Fire Marshal 6403\n\n64 Cuivre River Dr, Troy\n[Entry Time: 07-Aug-13 19:16:28]\n\n\n\n07-Aug-13 19:12:14 - Dispatched by: 696 (Brittany Job)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n07-Aug-13 19:11:36 - Memo by: 645 (Alisha Lewis)\nTHERMAL IMAGE NEEDED \n\n\n07-Aug-13 19:10:18 - Entered by: 645 (Alisha Lewis)\n69 - Structure Fire (Priority 5)\nSource: Phone\n\nReporting Person: 2607\nLocation: 64 Cuivre River Dr, Troy\n\nCAMPER \nHEAVY WIRE ELECRTICAL SMELL \nCEILING IS HOT \n24FT ON WHEELS \nNOT ATTCHED \n\n\n\n07-Aug-13 19:10:18 - Initiated by: 645 (Alisha Lewis)");

    doTest("T6",
        "(LCFPD) NEW 50-24-NN Structure Fire 64 Cuivre River Dr, Troy",
        "CALL:50-24-NN Structure Fire",
        "ADDR:64 Cuivre River Dr",
        "CITY:Troy");

    doTest("T7",
        "(LCFPD) OCC #13-745, INC #13-45851 - 12 - Convulsions/Seizures\n" +
        "Time Entered: 8/6/2013 2:08:21 PM\n" +
        "Received Via: WPH1\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n" +
        "NEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\n" +
        "Incident Log:\n\n" +
        "06-Aug-13 14:28:49 - Cleared RTF by: 631 (Glen Moser)\n" +
        "Clear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\n" +
        "Lincoln County Ambulance Ambulance Medic 2\n\n" +
        "1 REFUSAL\n\n" +
        "06-Aug-13 14:28:06 - Cleared RTF by: 631 (Glen Moser)\n" +
        "Clear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n\n\n" +
        "06-Aug-13 14:22:34 - Cleared RTF by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45851 (13-745)  12 - Convulsions/Seizures\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "released from medics back in service\n\n" +
        "06-Aug-13 14:19:41 - On Scene by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance Medic 2\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:16:07 - Memo by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "pri three\n\n" +
        "06-Aug-13 14:15:08 - On Scene by: 631 (Glen Moser)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:15:02 - On Scene by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:12:16 - Cleared Notebook by: 631 (Glen Moser)\n" +
        "Clear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "06-Aug-13 14:12:12 - Enroute by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:12:08 - Backup by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n\n\n" +
        "06-Aug-13 14:12:08 - Dispatched by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n\n\n" +
        "06-Aug-13 14:11:58 - Enroute by: 631 (Glen Moser)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:11:54 - Backup by: 631 (Glen Moser)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "06-Aug-13 14:11:54 - Dispatched by: 631 (Glen Moser)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "06-Aug-13 14:11:23 - Memo by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n" +
        "119 advised.\n\n" +
        "06-Aug-13 14:11:22 - Enroute by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance Medic 2\n\n" +
        "1049 Sommerset Dr (Apt 109), Troy\n\n\n\n" +
        "06-Aug-13 14:11:17 - Backup by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance Medic 2\n\n\n\n" +
        "06-Aug-13 14:11:17 - Dispatched by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Ambulance Medic 2\n\n\n\n" +
        "06-Aug-13 14:10:13 - Dispatched by: 631 (Glen Moser)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "06-Aug-13 14:08:21 - Entered by: 631 (Glen Moser)\n" +
        "12 - Convulsions/Seizures (Priority 5)\n" +
        "Source: WPH1\n\n" +
        "Reporting Person: CHEYNNE\n" +
        "Phone: 636-775-0184\n" +
        "Address: AT&T MOBILITY - 769 Monroe St, Troy\n" +
        "Location: 1049 Sommerset Dr (Apt 109), Troy\n\n" +
        "NEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\n" +
        "06-Aug-13 14:08:21 - Initiated by: 631 (Glen Moser)",

        "CALL:RUN REPORT",
        "ID:13-45851",
        "PLACE:OCC #13-745, INC #13-45851 - 12 - Convulsions/Seizures\nTime Entered: 8/6/2013 2:08:21 PM\nReceived Via: WPH1\n1049 Sommerset Dr (Apt 109), Troy\n\nNEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\nIncident Log:\n\n06-Aug-13 14:28:49 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Ambulance Medic 2\n\n1 REFUSAL\n\n06-Aug-13 14:28:06 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:22:34 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45851 (13-745)  12 - Convulsions/Seizures\nLincoln County Fire Pumper 6414\n\nreleased from medics back in service\n\n06-Aug-13 14:19:41 - On Scene by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:16:07 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance 6705\n\npri three\n\n06-Aug-13 14:15:08 - On Scene by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:15:02 - On Scene by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:12:16 - Cleared Notebook by: 631 (Glen Moser)\nClear Incident 13-45851 (13-3746)  12 - Convulsions/Seizures\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n06-Aug-13 14:12:12 - Enroute by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:12:08 - Backup by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:12:08 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance 6705\n\n\n\n06-Aug-13 14:11:58 - Enroute by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:11:54 - Backup by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n\n\n06-Aug-13 14:11:54 - Dispatched by: 631 (Glen Moser)\nLincoln County Fire Pumper 6414\n\n\n\n06-Aug-13 14:11:23 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n119 advised.\n\n06-Aug-13 14:11:22 - Enroute by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n1049 Sommerset Dr (Apt 109), Troy\n\n\n\n06-Aug-13 14:11:17 - Backup by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n\n\n06-Aug-13 14:11:17 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Ambulance Medic 2\n\n\n\n06-Aug-13 14:10:13 - Dispatched by: 631 (Glen Moser)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n06-Aug-13 14:08:21 - Entered by: 631 (Glen Moser)\n12 - Convulsions/Seizures (Priority 5)\nSource: WPH1\n\nReporting Person: CHEYNNE\nPhone: 636-775-0184\nAddress: AT&T MOBILITY - 769 Monroe St, Troy\nLocation: 1049 Sommerset Dr (Apt 109), Troy\n\nNEXTDOOR NEIGHBOR HAVING A SEIZURE   40'S  FEMALE  STILL SEIZING    UNCON  BTRATJING\n\n06-Aug-13 14:08:21 - Initiated by: 631 (Glen Moser)");

    doTest("T8",
        "(LCFPD) NEW Convulsions/Seizures 1049 Sommerset Dr (Apt 109), Troy",
        "CALL:Convulsions/Seizures",
        "ADDR:1049 Sommerset Dr (Apt 109)",
        "MADDR:1049 Sommerset Dr",
        "CITY:Troy");

    doTest("T9",
        "(LCFPD) OCC #13-744, INC #13-45745 - ACC/MU - Motor Vehicle Accident Report\n" +
        "Time Entered: 8/5/2013 10:10:43 PM\n" +
        "Received Via: Phone\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n" +
        "KID RAN OVER A PARKING CURB\n\n" +
        "MALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\n" +
        "DID NOT HIT BUILDING\n\n" +
        "VEH-- WHITE BUICK \n\n" +
        "NO INJURIES \n\n\n\n" +
        "Incident Log:\n\n" +
        "05-Aug-13 22:44:42 - Cleared Notebook by: 696 (Brittany Job)\n" +
        "Clear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n\n\n" +
        "05-Aug-13 22:44:35 - Cleared RTF by: 696 (Brittany Job)\n" +
        "Clear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n\n\n" +
        "05-Aug-13 22:40:47 - Memo by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n" +
        "160-- PULLED CASE #\n\n" +
        "05-Aug-13 22:38:03 - Memo by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n" +
        "160-- STATUS CLEAR\n\n" +
        "05-Aug-13 22:18:40 - Memo by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n" +
        "PC2A0N\n\n" +
        "ROM-REVENUE     DATE: 08/05/2013  TIME: 22:18:57 DEST TERM: WC00FOXI\n" +
        "DOR.GR70PC2A0N\n" +
        "  OWNER NAME        CITY       LIC    LIY  VYR   VMA  KOV       VIN\n" +
        "BROWN PATRICIA TO  TROY    *A PC2A0N   13   98   OLDS  P  1G3HN52K1W4823103 \n\n\n\n" +
        "BROWN  JOSHUA B 1 30 1996  \n\n" +
        "FROM-REVENUE     DATE: 08/05/2013  TIME: 22:19:34 DEST TERM: WC00FOXI\n" +
        "QWRT.ORI/MO057013N.LNM/BROWN.FNM/JOSHUA.DOB/01301996\n" +
        "DETAIL INFORMATION:\n" +
        "OPER STAT/VALID               CDL STAT/\n" +
        " LIC EXP DATE/03 04 2015   CLASS/F\n" +
        "                       CURRENT NAME                                 DOB     SEX\n" +
        " BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\n" +
        "OLN/Y054221004\n" +
        "                       ALIAS INFORMATION\n" +
        " BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\n" +
        "OLN/498114411\n" +
        "SOC/498114411     HGT/507         WGT/130   EYE/BROWN\n" +
        "RESIDENT ADDR/195 LEWIS ST APT 2         TROY                  MO  63379\n" +
        "  PERMIT EXP/08 08 2013   CLASS/F\n" +
        "ISSUANCE INFORMATION:\n" +
        " ENDORSEMENTS/\n" +
        "  RESTRICTIONS/INTERMEDIATE LICENSE\n" +
        "  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n\n\n" +
        "05-Aug-13 22:17:24 - Cleared RTF by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "PT WITH LAW\n\n" +
        "05-Aug-13 22:17:17 - Cleared RTF by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n\n\n" +
        "05-Aug-13 22:17:08 - On Scene by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:16:47 - Memo by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n" +
        "157--  CAN 10-25 MEIDCS AND FIRE\n\n" +
        "05-Aug-13 22:16:47 - Cleared RTF by: 698 (Elliott Burkemper)\n" +
        "Clear Incident 13-45745 (13-744)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6705 ADVISED NO INJURIES ALL UNITS INCOMING CAN DISREGUARD\n\n" +
        "05-Aug-13 22:16:21 - Enroute by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:16:17 - Reassign by: 698 (Elliott Burkemper)\n\n\n" +
        "05-Aug-13 22:16:17 - Dispatched by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 22:16:15 - On Scene by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:16:08 - Enroute by: 696 (Brittany Job)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:15:49 - On Scene by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:15:44 - Enroute by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:15:35 - Enroute by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n" +
        "76  FROM  CHERRY / LINCOLN\n\n" +
        "05-Aug-13 22:15:32 - Backup by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n\n\n\n" +
        "05-Aug-13 22:15:32 - Dispatched by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 157\n" +
        "Tyler Holton - 157\n\n\n\n" +
        "05-Aug-13 22:15:26 - Backup by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n\n\n" +
        "05-Aug-13 22:15:26 - Dispatched by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Ambulance Ambulance 6705\n\n\n\n" +
        "05-Aug-13 22:14:12 - Enroute by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n" +
        "Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n" +
        "05-Aug-13 22:14:08 - Backup by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n\n\n\n" +
        "05-Aug-13 22:14:08 - Dispatched by: 696 (Brittany Job)\n" +
        "Troy Police Department Police Car 160\n" +
        "Ryan Brown - 160\n\n\n\n" +
        "05-Aug-13 22:13:36 - Backup by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n\n\n" +
        "05-Aug-13 22:13:36 - Dispatched by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Fire Fire Station LCF Stn 1\n\n\n\n" +
        "05-Aug-13 22:13:29 - Dispatched by: 698 (Elliott Burkemper)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n\n\n" +
        "05-Aug-13 22:10:43 - Entered by: 696 (Brittany Job)\n" +
        "ACC/MU - Motor Vehicle Accident Report (Priority 5)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: KATE LANDRY\n" +
        "Phone: 636-528-4918\n" +
        "Location: Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n" +
        "KID RAN OVER A PARKING CURB\n\n" +
        "MALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\n" +
        "DID NOT HIT BUILDING\n\n" +
        "VEH-- WHITE BUICK \n\n" +
        "NO INJURIES \n\n\n\n" +
        "05-Aug-13 22:10:43 - Initiated by: 696 (Brittany Job)",

        "CALL:RUN REPORT",
        "ID:13-45745",
        "PLACE:OCC #13-744, INC #13-45745 - ACC/MU - Motor Vehicle Accident Report\nTime Entered: 8/5/2013 10:10:43 PM\nReceived Via: Phone\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\nKID RAN OVER A PARKING CURB\n\nMALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\nDID NOT HIT BUILDING\n\nVEH-- WHITE BUICK \n\nNO INJURIES \n\n\n\nIncident Log:\n\n05-Aug-13 22:44:42 - Cleared Notebook by: 696 (Brittany Job)\nClear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n\n\n05-Aug-13 22:44:35 - Cleared RTF by: 696 (Brittany Job)\nClear Incident 13-45745 (13-9441)  ACC/MU - Motor Vehicle Accident Report\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n\n\n05-Aug-13 22:40:47 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n160-- PULLED CASE #\n\n05-Aug-13 22:38:03 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n160-- STATUS CLEAR\n\n05-Aug-13 22:18:40 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nPC2A0N\n\nROM-REVENUE     DATE: 08/05/2013  TIME: 22:18:57 DEST TERM: WC00FOXI\nDOR.GR70PC2A0N\n  OWNER NAME        CITY       LIC    LIY  VYR   VMA  KOV       VIN\nBROWN PATRICIA TO  TROY    *A PC2A0N   13   98   OLDS  P  1G3HN52K1W4823103 \n\n\n\nBROWN  JOSHUA B 1 30 1996  \n\nFROM-REVENUE     DATE: 08/05/2013  TIME: 22:19:34 DEST TERM: WC00FOXI\nQWRT.ORI/MO057013N.LNM/BROWN.FNM/JOSHUA.DOB/01301996\nDETAIL INFORMATION:\nOPER STAT/VALID               CDL STAT/\n LIC EXP DATE/03 04 2015   CLASS/F\n                       CURRENT NAME                                 DOB     SEX\n BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\nOLN/Y054221004\n                       ALIAS INFORMATION\n BROWN                    ,JOSHUA          BRANDON               01 30 1996  M\nOLN/498114411\nSOC/498114411     HGT/507         WGT/130   EYE/BROWN\nRESIDENT ADDR/195 LEWIS ST APT 2         TROY                  MO  63379\n  PERMIT EXP/08 08 2013   CLASS/F\nISSUANCE INFORMATION:\n ENDORSEMENTS/\n  RESTRICTIONS/INTERMEDIATE LICENSE\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n\n\n05-Aug-13 22:17:24 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance 6705\n\nPT WITH LAW\n\n05-Aug-13 22:17:17 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-3737)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n05-Aug-13 22:17:08 - On Scene by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:47 - Memo by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n157--  CAN 10-25 MEIDCS AND FIRE\n\n05-Aug-13 22:16:47 - Cleared RTF by: 698 (Elliott Burkemper)\nClear Incident 13-45745 (13-744)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Fire Pumper 6414\n\n6705 ADVISED NO INJURIES ALL UNITS INCOMING CAN DISREGUARD\n\n05-Aug-13 22:16:21 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:17 - Reassign by: 698 (Elliott Burkemper)\n\n\n05-Aug-13 22:16:17 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 22:16:15 - On Scene by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:16:08 - Enroute by: 696 (Brittany Job)\nLincoln County Ambulance Ambulance Medic 5\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:49 - On Scene by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:44 - Enroute by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:15:35 - Enroute by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n76  FROM  CHERRY / LINCOLN\n\n05-Aug-13 22:15:32 - Backup by: 696 (Brittany Job)\nTroy Police Department Police Car 157\n\n\n\n05-Aug-13 22:15:32 - Dispatched by: 696 (Brittany Job)\nTroy Police Department Police Car 157\nTyler Holton - 157\n\n\n\n05-Aug-13 22:15:26 - Backup by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\n\n\n05-Aug-13 22:15:26 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance 6705\n\n\n\n05-Aug-13 22:14:12 - Enroute by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\nHilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\n\n\n05-Aug-13 22:14:08 - Backup by: 696 (Brittany Job)\nTroy Police Department Police Car 160\n\n\n\n05-Aug-13 22:14:08 - Dispatched by: 696 (Brittany Job)\nTroy Police Department Police Car 160\nRyan Brown - 160\n\n\n\n05-Aug-13 22:13:36 - Backup by: 698 (Elliott Burkemper)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n05-Aug-13 22:13:36 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Fire Fire Station LCF Stn 1\n\n\n\n05-Aug-13 22:13:29 - Dispatched by: 698 (Elliott Burkemper)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n05-Aug-13 22:10:43 - Entered by: 696 (Brittany Job)\nACC/MU - Motor Vehicle Accident Report (Priority 5)\nSource: Phone\n\nReporting Person: KATE LANDRY\nPhone: 636-528-4918\nLocation: Hilltop Phillips 66 - 201 S Lincoln Dr, Troy\n\nKID RAN OVER A PARKING CURB\n\nMALE HIT RETAINING WALL -- IS KNOCKED ALL THE WAY DOWN\n\nDID NOT HIT BUILDING\n\nVEH-- WHITE BUICK \n\nNO INJURIES \n\n\n\n05-Aug-13 22:10:43 - Initiated by: 696 (Brittany Job)");

    doTest("T10",
        "(LCFPD) NEW Motor Vehicle Accident Report Hilltop Phillips 66 - 201 S Lincoln Dr, Troy",
        "CALL:Motor Vehicle Accident Report Hilltop Phillips 66",
        "ADDR:201 S Lincoln Dr",
        "CITY:Troy");

    doTest("T11",
        "(LCFPD) OCC #13-743, INC #13-45673 - ACC/MU - Motor Vehicle Accident Report\n" +
        "Time Entered: 8/5/2013 4:42:12 PM\n" +
        "Received Via: WPH1\n" +
        "hwy 61 and hwy c - LINCOLN\n\n" +
        "hwy c on the ramp nb offramp  \n" +
        "two vehicles involved\n" +
        "no ambulance\n" +
        "yukon xl and  mazda 626\n\n\n" +
        "Incident Log:\n\n" +
        "05-Aug-13 17:01:40 - Cleared RTF by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45673 (13-3732)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n\n\n" +
        "05-Aug-13 17:01:32 - Memo by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n" +
        "1 refusal obtainied\n\n" +
        "05-Aug-13 16:57:23 - Cleared RTF by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45673 (13-743)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 16:57:14 - Memo by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "disregarded by medics.\n\n" +
        "05-Aug-13 16:57:10 - On Scene by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "05-Aug-13 16:55:53 - On Scene by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "05-Aug-13 16:53:25 - Cleared Notebook by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45673 (13-6176)  ACC/MU - Motor Vehicle Accident Report\n" +
        "Moscow Mills Police Department Muni Patrol 2102 05 (Car 05)\n" +
        "Danny Brown - 2102\n\n\n\n" +
        "Mileage: 92592\n\n" +
        "05-Aug-13 16:53:15 - On Scene by: 632 (Lori Reynolds)\n" +
        "Moscow Mills Police Department Muni Patrol 2102 05 (Car 05)\n" +
        "Danny Brown - 2102\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "Mileage: 92592\n\n" +
        "05-Aug-13 16:52:10 - Enroute by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "05-Aug-13 16:51:52 - Reassign by: 632 (Lori Reynolds)\n\n\n" +
        "05-Aug-13 16:51:52 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 1\n\n\n\n" +
        "05-Aug-13 16:51:36 - Enroute by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "05-Aug-13 16:49:55 - Backup by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 16:49:55 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 16:49:49 - Backup by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "Mileage: 92592\n\n" +
        "05-Aug-13 16:49:49 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Desk Amb LCAD\n\n\n\n" +
        "05-Aug-13 16:45:14 - Enroute by: 632 (Lori Reynolds)\n" +
        "Moscow Mills Police Department Muni Patrol 2102 05 (Car 05)\n" +
        "Danny Brown - 2102\n\n" +
        "hwy 61 and hwy c - LINCOLN\n\n\n\n" +
        "Mileage: 92592\n\n" +
        "05-Aug-13 16:44:36 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Moscow Mills Police Department Muni Patrol 2102 05 (Car 05)\n" +
        "Danny Brown - 2102\n\n\n\n" +
        "Mileage: 92592\n\n" +
        "05-Aug-13 16:42:12 - Entered by: 632 (Lori Reynolds)\n" +
        "ACC/MU - Motor Vehicle Accident Report (Priority 5)\n" +
        "Source: WPH1\n\n" +
        "Reporting Person: jennifer\n" +
        "Phone: 636-675-2032\n" +
        "Address: T-MOBILE USA - 83 DUGAN LN - SECTOR SE, LINCOLN\n" +
        "Location: hwy 61 and hwy c - LINCOLN\n\n" +
        "hwy c on the ramp nb offramp  \n" +
        "two vehicles involved\n" +
        "no ambulance\n" +
        "yukon xl and  mazda 626\n\n\n" +
        "05-Aug-13 16:42:12 - Initiated by: 632 (Lori Reynolds)",

        "CALL:RUN REPORT",
        "ID:13-45673",
        "PLACE:OCC #13-743, INC #13-45673 - ACC/MU - Motor Vehicle Accident Report\nTime Entered: 8/5/2013 4:42:12 PM\nReceived Via: WPH1\nhwy 61 and hwy c - LINCOLN\n\nhwy c on the ramp nb offramp  \ntwo vehicles involved\nno ambulance\nyukon xl and  mazda 626\n\n\nIncident Log:\n\n05-Aug-13 17:01:40 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-3732)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n05-Aug-13 17:01:32 - Memo by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\n1 refusal obtainied\n\n05-Aug-13 16:57:23 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-743)  ACC/MU - Motor Vehicle Accident Report\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:57:14 - Memo by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\ndisregarded by medics.\n\n05-Aug-13 16:57:10 - On Scene by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:55:53 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:53:25 - Cleared Notebook by: 632 (Lori Reynolds)\nClear Incident 13-45673 (13-6176)  ACC/MU - Motor Vehicle Accident Report\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\n\n\nMileage: 92592\n\n05-Aug-13 16:53:15 - On Scene by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\nhwy 61 and hwy c - LINCOLN\n\n\n\nMileage: 92592\n\n05-Aug-13 16:52:10 - Enroute by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:51:52 - Reassign by: 632 (Lori Reynolds)\n\n\n05-Aug-13 16:51:52 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 1\n\n\n\n05-Aug-13 16:51:36 - Enroute by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\nhwy 61 and hwy c - LINCOLN\n\n\n\n05-Aug-13 16:49:55 - Backup by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:49:55 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 16:49:49 - Backup by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\nMileage: 92592\n\n05-Aug-13 16:49:49 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Ambulance Desk Amb LCAD\n\n\n\n05-Aug-13 16:45:14 - Enroute by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\nhwy 61 and hwy c - LINCOLN\n\n\n\nMileage: 92592\n\n05-Aug-13 16:44:36 - Dispatched by: 632 (Lori Reynolds)\nMoscow Mills Police Department Muni Patrol 2102 05 (Car 05)\nDanny Brown - 2102\n\n\n\nMileage: 92592\n\n05-Aug-13 16:42:12 - Entered by: 632 (Lori Reynolds)\nACC/MU - Motor Vehicle Accident Report (Priority 5)\nSource: WPH1\n\nReporting Person: jennifer\nPhone: 636-675-2032\nAddress: T-MOBILE USA - 83 DUGAN LN - SECTOR SE, LINCOLN\nLocation: hwy 61 and hwy c - LINCOLN\n\nhwy c on the ramp nb offramp  \ntwo vehicles involved\nno ambulance\nyukon xl and  mazda 626\n\n\n05-Aug-13 16:42:12 - Initiated by: 632 (Lori Reynolds)");


    doTest("T12",
        "(LCFPD) NEW Motor Vehicle Accident Report hwy 61 and hwy c - LINCOLN",
        "CALL:Motor Vehicle Accident Report",
        "ADDR:hwy 61 and hwy c",
        "MADDR:hwy 61 & hwy c",  // Not mapping
        "CITY:LINCOLN");

    doTest("T13",
        "(LCFPD) OCC #13-742, INC #13-45643 - 3 - Animal Bites/Attacks\n" +
        "Time Entered: 8/5/2013 2:26:38 PM\n" +
        "Received Via: RESD\n" +
        "6002 Saddle Ridge Rd, Troy\n\n" +
        "11yo child bitten by a \n" +
        "great dane \n" +
        "bite to the left fore arm \n\n\n" +
        "Incident Log:\n\n" +
        "05-Aug-13 16:35:02 - Cleared RTF by: 686 (James Roberts)\n" +
        "Clear Incident 13-45643 (13-166)  3 - Animal Bites/Attacks\n" +
        "Outside Agency Outside Agency Outside Ag\n\n" +
        "lake st louis provide the info\n\n" +
        "05-Aug-13 16:14:31 - Cleared RTF by: 631 (Glen Moser)\n" +
        "Clear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n\n\n" +
        "05-Aug-13 15:53:03 - Cleared RTF by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n\n\n" +
        "05-Aug-13 15:51:00 - Backup by: 686 (James Roberts)\n" +
        "Outside Agency Outside Agency Outside Ag\n\n\n\n" +
        "05-Aug-13 15:51:00 - Dispatched by: 686 (James Roberts)\n" +
        "Outside Agency Outside Agency Outside Ag\n\n\n\n" +
        "05-Aug-13 15:50:23 - Memo by: 686 (James Roberts)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "lake st louis will do the outside agency assit\n\n" +
        "05-Aug-13 15:47:35 - Cleared RTF by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45643 (13-3729)  3 - Animal Bites/Attacks\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n\n\n" +
        "05-Aug-13 15:29:30 - Memo by: 686 (James Roberts)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "contact st charles co poss to do a outside agency assist to get info \n" +
        "jim and linda wilson with devon wilson\n\n" +
        "05-Aug-13 15:15:45 - On Scene by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "St Joseph West - Unknown, Lake St Louis\n\n\n\n" +
        "05-Aug-13 15:14:55 - Memo by: 631 (Glen Moser)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "CANCEL REF LAST INFO ADDED\n\n" +
        "05-Aug-13 15:14:11 - Memo by: 631 (Glen Moser)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "476 ADVISED TO CANCEL ANY FURTHER, SUBJ IS IN TEH LOBBY OF 65\n\n" +
        "05-Aug-13 15:06:47 - On Scene by: 686 (James Roberts)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 15:05:25 - Memo by: 686 (James Roberts)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n" +
        "per 470 \n\n" +
        "owner of the k-9 would like it put down and the human socity they wont come and get the dog\n\n" +
        "05-Aug-13 14:53:00 - Cleared Notebook by: 632 (Lori Reynolds)\n" +
        "Clear Incident 13-45643 (13-742)  3 - Animal Bites/Attacks\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 14:52:46 - Enroute by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "St Joseph West - Unknown, Lake St Louis\n\n\n\n" +
        "05-Aug-13 14:43:49 - On Scene by: 632 (Lori Reynolds)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 14:38:46 - Backup by: 631 (Glen Moser)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n\n\n\n" +
        "05-Aug-13 14:38:46 - Dispatched by: 631 (Glen Moser)\n" +
        "Lincoln County Sheriff Patrol Car 470 Beat: West\n" +
        "Adam Maschmidt - 470\n\n\n\n" +
        "05-Aug-13 14:37:34 - Memo by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6414 ADV PRI THREE PATIENT\n\n" +
        "05-Aug-13 14:36:13 - On Scene by: 612 (Margie Harrell)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 14:36:11 - On Scene by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 14:31:15 - Memo by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "unsure if the dog was being aggressive  \n" +
        "child was going out to feed and water him \n" +
        " the great dane is 9months old\n\n" +
        "05-Aug-13 14:30:25 - Memo by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "skin at the bite is ripped, not just a puncture wound \n\n\n" +
        "05-Aug-13 14:30:08 - Enroute by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 14:30:02 - Reassign by: 632 (Lori Reynolds)\n\n\n" +
        "05-Aug-13 14:30:02 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6414\n\n\n\n" +
        "05-Aug-13 14:29:21 - Memo by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "17 got dog 2wks ago \n" +
        "they adv that he had his shots \n" +
        "does  not have a record of the shots\n" +
        "does not what vet goes to \n" +
        "owner prior is unsure of the name \n\n\n" +
        "05-Aug-13 14:29:15 - Enroute by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "6002 Saddle Ridge Rd, Troy\n\n\n\n" +
        "05-Aug-13 14:28:59 - Backup by: 686 (James Roberts)\n" +
        "Lincoln County Fire Pumper 6444\n\n\n\n" +
        "05-Aug-13 14:28:52 - Backup by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6444\n\n\n\n" +
        "05-Aug-13 14:28:52 - Dispatched by: 632 (Lori Reynolds)\n" +
        "Lincoln County Fire Pumper 6444\n\n\n\n" +
        "05-Aug-13 14:28:32 - Memo by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n" +
        "k9 is in the kennel \n" +
        "all others are put up as well\n\n" +
        "05-Aug-13 14:27:42 - Dispatched by: 612 (Margie Harrell)\n" +
        "Lincoln County Ambulance Ambulance Medic 3\n\n\n\n" +
        "05-Aug-13 14:26:38 - Entered by: 612 (Margie Harrell)\n" +
        "3 - Animal Bites/Attacks (Priority 5)\n" +
        "Source: RESD\n\n" +
        "Reporting Person: NAVOLT\n" +
        "Phone: 636-4621325\n" +
        "Address: 6002 Saddle Ridge Rd, Troy\n" +
        "Location: 6002 Saddle Ridge Rd, Troy\n\n" +
        "11yo child bitten by a \n" +
        "great dane \n" +
        "bite to the left fore arm \n\n\n" +
        "05-Aug-13 14:26:38 - Initiated by: 612 (Margie Harrell)",

        "CALL:RUN REPORT",
        "ID:13-45643",
        "PLACE:OCC #13-742, INC #13-45643 - 3 - Animal Bites/Attacks\nTime Entered: 8/5/2013 2:26:38 PM\nReceived Via: RESD\n6002 Saddle Ridge Rd, Troy\n\n11yo child bitten by a \ngreat dane \nbite to the left fore arm \n\n\nIncident Log:\n\n05-Aug-13 16:35:02 - Cleared RTF by: 686 (James Roberts)\nClear Incident 13-45643 (13-166)  3 - Animal Bites/Attacks\nOutside Agency Outside Agency Outside Ag\n\nlake st louis provide the info\n\n05-Aug-13 16:14:31 - Cleared RTF by: 631 (Glen Moser)\nClear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 15:53:03 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-16551)  3 - Animal Bites/Attacks\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 15:51:00 - Backup by: 686 (James Roberts)\nOutside Agency Outside Agency Outside Ag\n\n\n\n05-Aug-13 15:51:00 - Dispatched by: 686 (James Roberts)\nOutside Agency Outside Agency Outside Ag\n\n\n\n05-Aug-13 15:50:23 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nlake st louis will do the outside agency assit\n\n05-Aug-13 15:47:35 - Cleared RTF by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-3729)  3 - Animal Bites/Attacks\nLincoln County Ambulance Ambulance Medic 3\n\n\n\n05-Aug-13 15:29:30 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\ncontact st charles co poss to do a outside agency assist to get info \njim and linda wilson with devon wilson\n\n05-Aug-13 15:15:45 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n05-Aug-13 15:14:55 - Memo by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nCANCEL REF LAST INFO ADDED\n\n05-Aug-13 15:14:11 - Memo by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n476 ADVISED TO CANCEL ANY FURTHER, SUBJ IS IN TEH LOBBY OF 65\n\n05-Aug-13 15:06:47 - On Scene by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 15:05:25 - Memo by: 686 (James Roberts)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\nper 470 \n\nowner of the k-9 would like it put down and the human socity they wont come and get the dog\n\n05-Aug-13 14:53:00 - Cleared Notebook by: 632 (Lori Reynolds)\nClear Incident 13-45643 (13-742)  3 - Animal Bites/Attacks\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 14:52:46 - Enroute by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n05-Aug-13 14:43:49 - On Scene by: 632 (Lori Reynolds)\nLincoln County Ambulance Ambulance Medic 3\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:38:46 - Backup by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\n\n\n\n05-Aug-13 14:38:46 - Dispatched by: 631 (Glen Moser)\nLincoln County Sheriff Patrol Car 470 Beat: West\nAdam Maschmidt - 470\n\n\n\n05-Aug-13 14:37:34 - Memo by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6414 ADV PRI THREE PATIENT\n\n05-Aug-13 14:36:13 - On Scene by: 612 (Margie Harrell)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:36:11 - On Scene by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:31:15 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nunsure if the dog was being aggressive  \nchild was going out to feed and water him \n the great dane is 9months old\n\n05-Aug-13 14:30:25 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nskin at the bite is ripped, not just a puncture wound \n\n\n05-Aug-13 14:30:08 - Enroute by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:30:02 - Reassign by: 632 (Lori Reynolds)\n\n\n05-Aug-13 14:30:02 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6414\n\n\n\n05-Aug-13 14:29:21 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n17 got dog 2wks ago \nthey adv that he had his shots \ndoes  not have a record of the shots\ndoes not what vet goes to \nowner prior is unsure of the name \n\n\n05-Aug-13 14:29:15 - Enroute by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n6002 Saddle Ridge Rd, Troy\n\n\n\n05-Aug-13 14:28:59 - Backup by: 686 (James Roberts)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:52 - Backup by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:52 - Dispatched by: 632 (Lori Reynolds)\nLincoln County Fire Pumper 6444\n\n\n\n05-Aug-13 14:28:32 - Memo by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\nk9 is in the kennel \nall others are put up as well\n\n05-Aug-13 14:27:42 - Dispatched by: 612 (Margie Harrell)\nLincoln County Ambulance Ambulance Medic 3\n\n\n\n05-Aug-13 14:26:38 - Entered by: 612 (Margie Harrell)\n3 - Animal Bites/Attacks (Priority 5)\nSource: RESD\n\nReporting Person: NAVOLT\nPhone: 636-4621325\nAddress: 6002 Saddle Ridge Rd, Troy\nLocation: 6002 Saddle Ridge Rd, Troy\n\n11yo child bitten by a \ngreat dane \nbite to the left fore arm \n\n\n05-Aug-13 14:26:38 - Initiated by: 612 (Margie Harrell)");
    
  }
  
  @Test
  public void testEoliaCommunityFPD() {

    doTest("T1",
        "(HISTORY FOR OCC #OUTS, INC #13-4717 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4717 - FIRE - Fire\n" +
        "Time Entered: 8/7/2013 5:33:46 AM\n" +
        "Received Via: 911\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "caller stated that house next to them is on fire and subject still in the residents\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 14:05:28 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (13-473)  FIRE - Fire\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "07-Aug-13 12:55:33 - Memo by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "412 at the SO with Samantha Wilson\n\n" +
        "07-Aug-13 12:46:17 - Memo by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "412 enroute to the SO with one white female beginning milage 97793\n\n" +
        "07-Aug-13 12:46:12 - Reassign by: 20 (Kristina Garrison)\n\n\n" +
        "07-Aug-13 12:46:12 - Dispatched by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "07-Aug-13 12:05:30 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4717 (13-473)  FIRE - Fire\n" +
        "Pike County SO Patrol 422\n" +
        "Preston Hipes - 422\n\n" +
        "422 enroute back to the SO\n\n" +
        "07-Aug-13 12:02:17 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4717 (13-473)  FIRE - Fire\n" +
        "Pike County SO Admin 400 400 (400)\n" +
        "Stephen Korte - 400\n\n" +
        "400 back in service\n\n" +
        "Mileage: 12339\n\n" +
        "07-Aug-13 11:46:42 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (13-473)  FIRE - Fire\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "back in service\n\n" +
        "07-Aug-13 11:45:55 - Cleared RTF by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "07-Aug-13 11:45:41 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Pike County SO Patrol 410\n" +
        "Mike Starman - 410\n\n" +
        "410 back in service\n\n" +
        "07-Aug-13 11:01:15 - On Scene by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 422\n" +
        "Preston Hipes - 422\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 11:01:12 - Backup by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 422\n\n" +
        "07-Aug-13 11:01:12 - Dispatched by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 422\n" +
        "Preston Hipes - 422\n\n" +
        "07-Aug-13 10:25:33 - On Scene by: 27 (Jordan Anderson)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 10:10:32 - Memo by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "subject\n" +
        "OPER STAT/VALID               CDL STAT/VALID\n" +
        " LIC EXP DATE/08 22 2018   CLASS/A\n" +
        "                       CURRENT NAME                                 DOB     SEX\n" +
        " MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\n" +
        "OLN/Y113233001\n" +
        "                       ALIAS INFORMATION\n" +
        " MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\n" +
        "OLN/490662678\n" +
        "SOC/490662678     HGT/604         WGT/208   EYE/HAZEL\n" +
        "RESIDENT ADDR/29950 PIKE 338             NEW HARTFORD          MO  63359\n" +
        "  PERMIT EXP/03 15 2006   CLASS/M\n" +
        "PEND STAT/APPEAL                    SCHOOL BUS STAT/\n" +
        "ISSUANCE INFORMATION:\n" +
        " ENDORSEMENTS/MOTORCYCLE                       DOUBLE AND TRIPLE TRAILERS\n" +
        "  RESTRICTIONS/CORRECTIVE LENSES\n" +
        "  LIC PROC CDE/REGULAR                LIC PROC REASON/\n" +
        " ACTION INFORMATION:\n" +
        " 1 TYPE/CHILD SUPPORT ENFORCEMENT SUSP      CASE NO/CS09002199  EFF DT/06062009\n" +
        "   STATUS/STAYED APPEALED                 ELIGIBLE REI/           OFFENSE ST/\n" +
        " OUT OF STATE CONVICTIONS:\n" +
        " 1 CON TYPE/I CON DATE/11 18 2011 FAIL TO APPEAR FOR TRIAL       STATE/IN\n" +
        "   OS LOCATOR/11112307078450     CMV/Y HAZ/N        ARREST DT/09 23 2011\n\n" +
        "07-Aug-13 10:09:57 - Memo by: 20 (Kristina Garrison)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "subject\n" +
        "OPER STAT/VALID               CDL STAT/\n" +
        " LIC EXP DATE/05 09 2015   CLASS/E\n" +
        "                       CURRENT NAME                                 DOB     SEX\n" +
        " WILSON                   ,SAMANTHA        LEE                   05 09 1975  F\n" +
        "OLN/G113273001\n" +
        "                       ALIAS INFORMATION\n" +
        " MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\n" +
        "OLN/G113273001\n" +
        " MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\n" +
        "OLN/497766759\n" +
        " JENNINGS                 ,SAMANTHA        LEE                   05 09 1975  F\n" +
        "OLN/497766759\n" +
        "SOC/497766759     HGT/501         WGT/190   EYE/BLUE\n" +
        "RESIDENT ADDR/101 S. LOCUST APT E        CURRYVILLE            MO  63339\n" +
        "MOST CUR ADDR/308 W MAPLE ST             CURRYVILLE            MO  633391016\n" +
        "ISSUANCE INFORMATION:\n" +
        " ENDORSEMENTS/\n" +
        "  RESTRICTIONS/\n" +
        "  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n" +
        "07-Aug-13 10:09:43 - On Scene by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 410\n" +
        "Mike Starman - 410\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 10:09:34 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "07-Aug-13 10:08:56 - Enroute by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 410\n" +
        "Mike Starman - 410\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 10:08:54 - Backup by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 410\n\n" +
        "07-Aug-13 10:08:54 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 410\n" +
        "Mike Starman - 410\n\n" +
        "07-Aug-13 10:08:51 - On Scene by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 10:08:49 - Backup by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n\n" +
        "Mileage: 12339\n\n" +
        "07-Aug-13 10:08:49 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "07-Aug-13 10:05:47 - Enroute by: 20 (Kristina Garrison)\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "6900 enroute to curryville to assist 400\n\n" +
        "07-Aug-13 10:05:43 - Backup by: 20 (Kristina Garrison)\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "Mileage: 12339\n\n" +
        "07-Aug-13 10:05:43 - Dispatched by: 20 (Kristina Garrison)\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "07-Aug-13 08:59:33 - Memo by: 27 (Jordan Anderson)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "Fire Marshal on scene\n\n" +
        "07-Aug-13 08:59:30 - On Scene by: 27 (Jordan Anderson)\n" +
        "Pike County SO Admin 400 400 (400)\n" +
        "Stephen Korte - 400\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "Mileage: 12339\n\n" +
        "07-Aug-13 08:59:28 - Backup by: 27 (Jordan Anderson)\n" +
        "Pike County SO Admin 400 400 (400)\n\n" +
        "07-Aug-13 08:59:28 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Pike County SO Admin 400 400 (400)\n" +
        "Stephen Korte - 400\n\n" +
        "Mileage: 12339\n\n" +
        "07-Aug-13 08:51:25 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Bowling Green FD Fire Station BGFD Stn\n\n" +
        "all units clear scene\n\n" +
        "07-Aug-13 08:51:22 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "07-Aug-13 08:51:18 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "07-Aug-13 08:37:40 - Memo by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "1820 Clear of scene returning to quarters\n\n" +
        "07-Aug-13 08:35:54 - Memo by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "1810 Clear of scene returning to Bowling Green\n\n" +
        "07-Aug-13 07:11:46 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "Clear of scene\n\n" +
        "07-Aug-13 07:11:24 - Cleared Notebook by: 27 (Jordan Anderson)\n" +
        "Clear Incident 13-4717 (OUTS)  FIRE - Fire\n" +
        "Pike County SO Patrol 409\n" +
        "Jody Blaylock - 421\n\n" +
        "Clear of scene\n\n" +
        "07-Aug-13 06:18:29 - On Scene by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 06:08:42 - Memo by: 229 (Josh Langley)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "PCMH ems on scene at 06:03\n\n" +
        "07-Aug-13 06:08:01 - Enroute by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "1810 en route with 4\n\n" +
        "07-Aug-13 06:07:59 - Backup by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "07-Aug-13 06:07:59 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1810\n\n" +
        "07-Aug-13 06:07:53 - On Scene by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 06:07:25 - Enroute by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "1810 enroute at 06:09\n\n" +
        "07-Aug-13 06:06:41 - Memo by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "time of second page 05:36\n\n" +
        "07-Aug-13 06:06:26 - Memo by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "time of first page 05:34\n\n" +
        "07-Aug-13 06:00:28 - On Scene by: 229 (Josh Langley)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "307 W MAPLE ST, Curryville\n" +
        "[Entry Time: 07-Aug-13 06:05:28]\n\n" +
        "07-Aug-13 05:55:06 - Enroute by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "en route with 2\n\n" +
        "07-Aug-13 05:55:04 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "07-Aug-13 05:55:04 - Backup by: 27 (Jordan Anderson)\n" +
        "Bowling Green FD Pumper 1820\n\n" +
        "07-Aug-13 05:54:08 - Enroute by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "1820 enroute to curryville\n\n" +
        "07-Aug-13 05:48:44 - Enroute by: 229 (Josh Langley)\n" +
        "Bowling Green FD Fire Station BGFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "800 816 enroute at 05:50\n\n" +
        "07-Aug-13 05:47:25 - Enroute by: 229 (Josh Langley)\n" +
        "Bowling Green FD Fire Station BGFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "824 enroute to station\n\n" +
        "07-Aug-13 05:46:59 - Enroute by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 05:46:57 - On Scene by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 409\n" +
        "Jody Blaylock - 421\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 05:46:54 - Backup by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n\n" +
        "07-Aug-13 05:46:54 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 412\n" +
        "Brenden McPike - 412\n\n" +
        "07-Aug-13 05:46:50 - Backup by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 409\n\n" +
        "07-Aug-13 05:46:50 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Pike County SO Patrol 409\n" +
        "Jody Blaylock - 421\n\n" +
        "07-Aug-13 05:45:26 - Enroute by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "1220 enroute\n\n" +
        "07-Aug-13 05:44:06 - Backup by: 229 (Josh Langley)\n" +
        "Bowling Green FD Fire Station BGFD Stn\n\n" +
        "07-Aug-13 05:44:06 - Dispatched by: 229 (Josh Langley)\n" +
        "Bowling Green FD Fire Station BGFD Stn\n\n" +
        "07-Aug-13 05:35:05 - Enroute by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "1241 1242 1223 enroute to station 05:36\n\n" +
        "07-Aug-13 05:35:02 - Dispatched by: 229 (Josh Langley)\n" +
        "Curryville FD Fire Station CurrFD Stn\n\n" +
        "07-Aug-13 05:34:57 - Initiated by: 229 (Josh Langley)\n" +
        "[Entry Time: 07-Aug-13 05:33:46]\n\n" +
        "07-Aug-13 05:33:46 - Entered by: 229 (Josh Langley)\n" +
        "FIRE - Fire (Priority 2)\n" +
        "Source: 911\n\n" +
        "Reporting Person: HERSCHEL TALLEY\n" +
        "Phone: 573-324-5711\n" +
        "Address: 307 W MAPLE ST, Curryville\n" +
        "Location: 307 W MAPLE ST, Curryville\n\n" +
        "caller stated that house next to them is on fire and subject still in the residents",

        "CALL:RUN REPORT",
        "ID:13-4717",
        "PLACE:OCC #OUTS, INC #13-4717 - FIRE - Fire\nTime Entered: 8/7/2013 5:33:46 AM\nReceived Via: 911\n307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents\n\nIncident Log:\n\n07-Aug-13 14:05:28 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 12:55:33 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n412 at the SO with Samantha Wilson\n\n07-Aug-13 12:46:17 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n412 enroute to the SO with one white female beginning milage 97793\n\n07-Aug-13 12:46:12 - Reassign by: 20 (Kristina Garrison)\n\n\n07-Aug-13 12:46:12 - Dispatched by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 12:05:30 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 422\nPreston Hipes - 422\n\n422 enroute back to the SO\n\n07-Aug-13 12:02:17 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\n400 back in service\n\nMileage: 12339\n\n07-Aug-13 11:46:42 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (13-473)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\nback in service\n\n07-Aug-13 11:45:55 - Cleared RTF by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 11:45:41 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 410\nMike Starman - 410\n\n410 back in service\n\n07-Aug-13 11:01:15 - On Scene by: 20 (Kristina Garrison)\nPike County SO Patrol 422\nPreston Hipes - 422\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 11:01:12 - Backup by: 20 (Kristina Garrison)\nPike County SO Patrol 422\n\n07-Aug-13 11:01:12 - Dispatched by: 20 (Kristina Garrison)\nPike County SO Patrol 422\nPreston Hipes - 422\n\n07-Aug-13 10:25:33 - On Scene by: 27 (Jordan Anderson)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:10:32 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nsubject\nOPER STAT/VALID               CDL STAT/VALID\n LIC EXP DATE/08 22 2018   CLASS/A\n                       CURRENT NAME                                 DOB     SEX\n MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\nOLN/Y113233001\n                       ALIAS INFORMATION\n MOSS                     ,JOSEPH          EUGENE       2ND      08 22 1972  M\nOLN/490662678\nSOC/490662678     HGT/604         WGT/208   EYE/HAZEL\nRESIDENT ADDR/29950 PIKE 338             NEW HARTFORD          MO  63359\n  PERMIT EXP/03 15 2006   CLASS/M\nPEND STAT/APPEAL                    SCHOOL BUS STAT/\nISSUANCE INFORMATION:\n ENDORSEMENTS/MOTORCYCLE                       DOUBLE AND TRIPLE TRAILERS\n  RESTRICTIONS/CORRECTIVE LENSES\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n ACTION INFORMATION:\n 1 TYPE/CHILD SUPPORT ENFORCEMENT SUSP      CASE NO/CS09002199  EFF DT/06062009\n   STATUS/STAYED APPEALED                 ELIGIBLE REI/           OFFENSE ST/\n OUT OF STATE CONVICTIONS:\n 1 CON TYPE/I CON DATE/11 18 2011 FAIL TO APPEAR FOR TRIAL       STATE/IN\n   OS LOCATOR/11112307078450     CMV/Y HAZ/N        ARREST DT/09 23 2011\n\n07-Aug-13 10:09:57 - Memo by: 20 (Kristina Garrison)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nsubject\nOPER STAT/VALID               CDL STAT/\n LIC EXP DATE/05 09 2015   CLASS/E\n                       CURRENT NAME                                 DOB     SEX\n WILSON                   ,SAMANTHA        LEE                   05 09 1975  F\nOLN/G113273001\n                       ALIAS INFORMATION\n MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\nOLN/G113273001\n MOSS                     ,SAMANTHA        LEE                   05 09 1975  F\nOLN/497766759\n JENNINGS                 ,SAMANTHA        LEE                   05 09 1975  F\nOLN/497766759\nSOC/497766759     HGT/501         WGT/190   EYE/BLUE\nRESIDENT ADDR/101 S. LOCUST APT E        CURRYVILLE            MO  63339\nMOST CUR ADDR/308 W MAPLE ST             CURRYVILLE            MO  633391016\nISSUANCE INFORMATION:\n ENDORSEMENTS/\n  RESTRICTIONS/\n  LIC PROC CDE/REGULAR                LIC PROC REASON/\n\n07-Aug-13 10:09:43 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:09:34 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 10:08:56 - Enroute by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:08:54 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 410\n\n07-Aug-13 10:08:54 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 410\nMike Starman - 410\n\n07-Aug-13 10:08:51 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:08:49 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 412\n\nMileage: 12339\n\n07-Aug-13 10:08:49 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 10:05:47 - Enroute by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n307 W MAPLE ST, Curryville\n\n6900 enroute to curryville to assist 400\n\n07-Aug-13 10:05:43 - Backup by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\nMileage: 12339\n\n07-Aug-13 10:05:43 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 08:59:33 - Memo by: 27 (Jordan Anderson)\nCurryville FD Fire Station CurrFD Stn\n\nFire Marshal on scene\n\n07-Aug-13 08:59:30 - On Scene by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\n307 W MAPLE ST, Curryville\n\nMileage: 12339\n\n07-Aug-13 08:59:28 - Backup by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\n\n07-Aug-13 08:59:28 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Admin 400 400 (400)\nStephen Korte - 400\n\nMileage: 12339\n\n07-Aug-13 08:51:25 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Fire Station BGFD Stn\n\nall units clear scene\n\n07-Aug-13 08:51:22 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Pumper 1820\n\n07-Aug-13 08:51:18 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nBowling Green FD Pumper 1810\n\n07-Aug-13 08:37:40 - Memo by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n1820 Clear of scene returning to quarters\n\n07-Aug-13 08:35:54 - Memo by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n1810 Clear of scene returning to Bowling Green\n\n07-Aug-13 07:11:46 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 412\nBrenden McPike - 412\n\nClear of scene\n\n07-Aug-13 07:11:24 - Cleared Notebook by: 27 (Jordan Anderson)\nClear Incident 13-4717 (OUTS)  FIRE - Fire\nPike County SO Patrol 409\nJody Blaylock - 421\n\nClear of scene\n\n07-Aug-13 06:18:29 - On Scene by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 06:08:42 - Memo by: 229 (Josh Langley)\nPike County SO Patrol 412\nBrenden McPike - 412\n\nPCMH ems on scene at 06:03\n\n07-Aug-13 06:08:01 - Enroute by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n307 W MAPLE ST, Curryville\n\n1810 en route with 4\n\n07-Aug-13 06:07:59 - Backup by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n07-Aug-13 06:07:59 - Dispatched by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1810\n\n07-Aug-13 06:07:53 - On Scene by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 06:07:25 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1810 enroute at 06:09\n\n07-Aug-13 06:06:41 - Memo by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\ntime of second page 05:36\n\n07-Aug-13 06:06:26 - Memo by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\ntime of first page 05:34\n\n07-Aug-13 06:00:28 - On Scene by: 229 (Josh Langley)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n[Entry Time: 07-Aug-13 06:05:28]\n\n07-Aug-13 05:55:06 - Enroute by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n307 W MAPLE ST, Curryville\n\nen route with 2\n\n07-Aug-13 05:55:04 - Dispatched by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n07-Aug-13 05:55:04 - Backup by: 27 (Jordan Anderson)\nBowling Green FD Pumper 1820\n\n07-Aug-13 05:54:08 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1820 enroute to curryville\n\n07-Aug-13 05:48:44 - Enroute by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n307 W MAPLE ST, Curryville\n\n800 816 enroute at 05:50\n\n07-Aug-13 05:47:25 - Enroute by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n307 W MAPLE ST, Curryville\n\n824 enroute to station\n\n07-Aug-13 05:46:59 - Enroute by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 05:46:57 - On Scene by: 27 (Jordan Anderson)\nPike County SO Patrol 409\nJody Blaylock - 421\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 05:46:54 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 412\n\n07-Aug-13 05:46:54 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 412\nBrenden McPike - 412\n\n07-Aug-13 05:46:50 - Backup by: 27 (Jordan Anderson)\nPike County SO Patrol 409\n\n07-Aug-13 05:46:50 - Dispatched by: 27 (Jordan Anderson)\nPike County SO Patrol 409\nJody Blaylock - 421\n\n07-Aug-13 05:45:26 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1220 enroute\n\n07-Aug-13 05:44:06 - Backup by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n07-Aug-13 05:44:06 - Dispatched by: 229 (Josh Langley)\nBowling Green FD Fire Station BGFD Stn\n\n07-Aug-13 05:35:05 - Enroute by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n307 W MAPLE ST, Curryville\n\n1241 1242 1223 enroute to station 05:36\n\n07-Aug-13 05:35:02 - Dispatched by: 229 (Josh Langley)\nCurryville FD Fire Station CurrFD Stn\n\n07-Aug-13 05:34:57 - Initiated by: 229 (Josh Langley)\n[Entry Time: 07-Aug-13 05:33:46]\n\n07-Aug-13 05:33:46 - Entered by: 229 (Josh Langley)\nFIRE - Fire (Priority 2)\nSource: 911\n\nReporting Person: HERSCHEL TALLEY\nPhone: 573-324-5711\nAddress: 307 W MAPLE ST, Curryville\nLocation: 307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents");

    doTest("T2",
        "(HISTORY FOR OCC #OUTS, INC #13-4729 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4729 - FIRE - Fire\n" +
        "Time Entered: 8/7/2013 10:09:41 AM\n" +
        "Received Via: 911\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "caller stated that house next to them is on fire and subject still in the residents\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 11:11:21 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4729 (OUTS)  FIRE - Fire\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "6900 back in quarters\n\n\n" +
        "07-Aug-13 10:09:49 - Enroute by: 20 (Kristina Garrison)\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "307 W MAPLE ST, Curryville\n\n" +
        "07-Aug-13 10:09:47 - Dispatched by: 20 (Kristina Garrison)\n" +
        "Eolia FD Fire Station EFD Stn\n\n" +
        "07-Aug-13 10:09:43 - Initiated by: 20 (Kristina Garrison)\n\n\n" +
        "07-Aug-13 10:09:41 - Entered by: 20 (Kristina Garrison)",

        "CALL:RUN REPORT",
        "ID:13-4729",
        "PLACE:OCC #OUTS, INC #13-4729 - FIRE - Fire\nTime Entered: 8/7/2013 10:09:41 AM\nReceived Via: 911\n307 W MAPLE ST, Curryville\n\ncaller stated that house next to them is on fire and subject still in the residents\n\nIncident Log:\n\n07-Aug-13 11:11:21 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4729 (OUTS)  FIRE - Fire\nEolia FD Fire Station EFD Stn\n\n6900 back in quarters\n\n\n07-Aug-13 10:09:49 - Enroute by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n307 W MAPLE ST, Curryville\n\n07-Aug-13 10:09:47 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Fire Station EFD Stn\n\n07-Aug-13 10:09:43 - Initiated by: 20 (Kristina Garrison)\n\n\n07-Aug-13 10:09:41 - Entered by: 20 (Kristina Garrison)");

    doTest("T3",
        "(NEWOCC #OUTS  FIRE - Fire) NEWOCC #OUTS  FIRE - Fire\n" +
        "Address: 307 W MAPLE ST, Curryville\n" +
        "Reporting Person: HERSCHEL Phone: 573-324-5711\n" +
        "Detail: caller stated that house next to them is on fire and subject still in the residents",

        "CODE:FIRE",
        "CALL:Fire",
        "ADDR:307 W MAPLE ST",
        "CITY:Curryville",
        "NAME:HERSCHEL",
        "PHONE:573-324-5711",
        "INFO:caller stated that house next to them is on fire and subject still in the residents");

    doTest("T4",
        "(HISTORY FOR OCC #OUTS, INC #13-4723 - MEDAID - Medical - Aid, AGENCY: Eolia FD) OCC #OUTS, INC #13-4723 - MEDAID - Medical - Aid\n" +
        "Time Entered: 8/7/2013 8:00:55 AM\n" +
        "Received Via: 911\n" +
        "196 N OLD HWY 61, Eolia\n\n" +
        "86 yr old female possible stroke\n\n" +
        "Incident Log:\n\n" +
        "07-Aug-13 09:58:21 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "07-Aug-13 09:58:17 - Cleared Notebook by: 20 (Kristina Garrison)\n" +
        "Clear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\n" +
        "Eolia FD Utility Truck 6919\n\n" +
        "07-Aug-13 08:45:43 - Memo by: 20 (Kristina Garrison)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "per 6900 all units clear enroute to house one back in service\n\n" +
        "07-Aug-13 08:45:01 - Memo by: 20 (Kristina Garrison)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "6902 clear of scene back in service\n\n" +
        "07-Aug-13 08:13:59 - On Scene by: 27 (Jordan Anderson)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "196 N OLD HWY 61, Eolia\n\n" +
        "6908 on scene\n\n" +
        "07-Aug-13 08:13:57 - Backup by: 27 (Jordan Anderson)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "07-Aug-13 08:13:57 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "07-Aug-13 08:10:13 - Memo by: 20 (Kristina Garrison)\n" +
        "Eolia FD Utility Truck 6919\n\n" +
        "6900 enroute direct\n\n" +
        "07-Aug-13 08:09:02 - Memo by: 20 (Kristina Garrison)\n" +
        "Eolia FD Utility Truck 6919\n\n" +
        "6908 enroute from Auburn junction\n\n" +
        "07-Aug-13 08:08:39 - Reassign by: 20 (Kristina Garrison)\n\n\n" +
        "07-Aug-13 08:08:39 - Dispatched by: 20 (Kristina Garrison)\n" +
        "Eolia FD Utility Truck 6919\n\n" +
        "07-Aug-13 08:08:25 - Enroute by: 20 (Kristina Garrison)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "196 N OLD HWY 61, Eolia\n\n" +
        "6919 responding with 2\n\n" +
        "07-Aug-13 08:01:54 - Modified by: 27 (Jordan Anderson)\n" +
        "Reporting Person: Mills Shelia\n\n" +
        "07-Aug-13 08:01:48 - Memo by: 27 (Jordan Anderson)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "First page\n\n" +
        "07-Aug-13 08:01:46 - Dispatched by: 27 (Jordan Anderson)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "07-Aug-13 08:01:11 - Initiated by: 27 (Jordan Anderson)\n\n\n" +
        "07-Aug-13 08:00:55 - Entered by: 27 (Jordan Anderson)\n" +
        "MEDAID - Medical - Aid (Priority 2)\n" +
        "Source: 911\n\n" +
        "Reporting Person: CLYDE SHEPHERD\n" +
        "Phone: 573-485-7983\n" +
        "Address: 196 N OLD HWY 61, Eolia\n" +
        "Location: 196 N OLD HWY 61, Eolia\n\n" +
        "86 yr old female possible stroke",

        "CALL:RUN REPORT",
        "ID:13-4723",
        "PLACE:OCC #OUTS, INC #13-4723 - MEDAID - Medical - Aid\nTime Entered: 8/7/2013 8:00:55 AM\nReceived Via: 911\n196 N OLD HWY 61, Eolia\n\n86 yr old female possible stroke\n\nIncident Log:\n\n07-Aug-13 09:58:21 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 09:58:17 - Cleared Notebook by: 20 (Kristina Garrison)\nClear Incident 13-4723 (OUTS)  MEDAID - Medical - Aid\nEolia FD Utility Truck 6919\n\n07-Aug-13 08:45:43 - Memo by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\nper 6900 all units clear enroute to house one back in service\n\n07-Aug-13 08:45:01 - Memo by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\n6902 clear of scene back in service\n\n07-Aug-13 08:13:59 - On Scene by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n196 N OLD HWY 61, Eolia\n\n6908 on scene\n\n07-Aug-13 08:13:57 - Backup by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:13:57 - Dispatched by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:10:13 - Memo by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n6900 enroute direct\n\n07-Aug-13 08:09:02 - Memo by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n6908 enroute from Auburn junction\n\n07-Aug-13 08:08:39 - Reassign by: 20 (Kristina Garrison)\n\n\n07-Aug-13 08:08:39 - Dispatched by: 20 (Kristina Garrison)\nEolia FD Utility Truck 6919\n\n07-Aug-13 08:08:25 - Enroute by: 20 (Kristina Garrison)\nEolia FD 1st Responders EFD 1st\n\n196 N OLD HWY 61, Eolia\n\n6919 responding with 2\n\n07-Aug-13 08:01:54 - Modified by: 27 (Jordan Anderson)\nReporting Person: Mills Shelia\n\n07-Aug-13 08:01:48 - Memo by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\nFirst page\n\n07-Aug-13 08:01:46 - Dispatched by: 27 (Jordan Anderson)\nEolia FD 1st Responders EFD 1st\n\n07-Aug-13 08:01:11 - Initiated by: 27 (Jordan Anderson)\n\n\n07-Aug-13 08:00:55 - Entered by: 27 (Jordan Anderson)\nMEDAID - Medical - Aid (Priority 2)\nSource: 911\n\nReporting Person: CLYDE SHEPHERD\nPhone: 573-485-7983\nAddress: 196 N OLD HWY 61, Eolia\nLocation: 196 N OLD HWY 61, Eolia\n\n86 yr old female possible stroke");

    doTest("T5",
        "(NEWOCC #OUTS  MEDAID - Medical - Aid) NEWOCC #OUTS  MEDAID - Medical - Aid\n" +
        "Address: 196 N OLD HWY 61, Eolia\n" +
        "Reporting Person: CLYDE Phone: 573-485-7983\n" +
        "Detail: 86 yr old female possible stroke",

        "CODE:MEDAID",
        "CALL:Medical - Aid",
        "ADDR:196 N OLD HWY 61",
        "CITY:Eolia",
        "NAME:CLYDE",
        "PHONE:573-485-7983",
        "INFO:86 yr old female possible stroke");

    doTest("T6",
        "(HISTORY FOR OCC #13-17, INC #13-45229 - DOM VI - Domestic Violence, AGENCY: Eolia Fire) OCC #13-17, INC #13-45229 - DOM VI - Domestic Violence\n" +
        "Time Entered: 8/3/2013 12:28:24 PM\n" +
        "Received Via: Phone\n" +
        "11 White Ln, Eolia\n\n" +
        "4 party call in ref to a male and female \n" +
        "physically fight in the yard\n\n" +
        "Incident Log:\n\n" +
        "03-Aug-13 14:50:16 - Cleared RTF by: 658 (Ronnie Martin)\n" +
        "Clear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n\n\n" +
        "03-Aug-13 14:12:16 - On Scene by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "St Joseph West - Unknown, Lake St Louis\n\n\n\n" +
        "03-Aug-13 13:40:11 - Enroute by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "St Joseph West - Unknown, Lake St Louis\n\n\n\n" +
        "03-Aug-13 13:35:23 - Cleared Notebook by: 692 (Stacey Miederhoff)\n" +
        "Clear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n" +
        "Demetrius Pride - 414\n\n\n\n" +
        "03-Aug-13 13:35:08 - Cleared Notebook by: 692 (Stacey Miederhoff)\n" +
        "Clear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n" +
        "451- adv call was medical \n" +
        "no domestic\n\n" +
        "03-Aug-13 13:34:05 - Memo by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n" +
        "451-adv domestic unfounded \n\n" +
        "female pat was transported - drank large amounts of alcohol and took s pills \n\n" +
        "10-8\n\n" +
        "03-Aug-13 13:28:19 - Cleared RTF by: 645 (Alisha Lewis)\n" +
        "Clear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n\n\n" +
        "03-Aug-13 13:28:16 - Cleared RTF by: 645 (Alisha Lewis)\n" +
        "Clear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\n" +
        "Eolia Fire Brush 6919\n\n\n\n" +
        "03-Aug-13 13:03:48 - Memo by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "pri 3\n\n" +
        "03-Aug-13 13:01:33 - On Scene by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Brush 6919\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 13:00:34 - On Scene by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "11 White Ln, Eolia\n" +
        "[Entry Time: 03-Aug-13 13:03:34]\n\n\n\n" +
        "03-Aug-13 12:59:51 - Cleared Notebook by: 692 (Stacey Miederhoff)\n" +
        "Clear Incident 13-45229 (13-106)  DOM VI - Domestic Violence\n" +
        "ARCH Helicopter ARCH ARCH\n\n" +
        "stand down on air \n\n\n\n" +
        "03-Aug-13 12:59:45 - Cleared RTF by: 645 (Alisha Lewis)\n" +
        "Clear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\n" +
        "Lincoln County Ambulance Ambulance 6704\n\n\n\n" +
        "03-Aug-13 12:59:33 - Cleared Notebook by: 692 (Stacey Miederhoff)\n" +
        "Clear Incident 13-45229 (13-142)  DOM VI - Domestic Violence\n" +
        "Air Evac Air Evac AIRE\n\n" +
        "stand down air \n\n\n" +
        "03-Aug-13 12:58:56 - Enroute by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Brush 6919\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:58:52 - Backup by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Brush 6919\n\n\n\n" +
        "03-Aug-13 12:58:52 - Dispatched by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Brush 6919\n\n\n\n" +
        "03-Aug-13 12:57:55 - Memo by: 692 (Stacey Miederhoff)\n" +
        "Air Evac Air Evac AIRE\n\n" +
        "air 23 at base - adam is checking weather \n\n\n\n" +
        "03-Aug-13 12:57:50 - Backup by: 692 (Stacey Miederhoff)\n" +
        "ARCH Helicopter ARCH ARCH\n\n\n\n" +
        "03-Aug-13 12:57:50 - Dispatched by: 692 (Stacey Miederhoff)\n" +
        "ARCH Helicopter ARCH ARCH\n\n\n\n" +
        "03-Aug-13 12:57:08 - Backup by: 692 (Stacey Miederhoff)\n" +
        "Air Evac Air Evac AIRE\n\n\n\n" +
        "03-Aug-13 12:57:08 - Dispatched by: 692 (Stacey Miederhoff)\n" +
        "Air Evac Air Evac AIRE\n\n\n\n" +
        "03-Aug-13 12:56:56 - Backup by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n\n\n" +
        "03-Aug-13 12:56:56 - Dispatched by: 645 (Alisha Lewis)\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n\n\n" +
        "03-Aug-13 12:55:57 - Memo by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n" +
        "unknown of what type of pills - subject is breathing but incherant\n\n" +
        "03-Aug-13 12:51:41 - Enroute by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance 6704\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:51:38 - Backup by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance 6704\n\n\n\n" +
        "03-Aug-13 12:51:38 - Dispatched by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance 6704\n\n\n\n" +
        "03-Aug-13 12:51:23 - Enroute by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:49:15 - Backup by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n\n\n" +
        "03-Aug-13 12:49:15 - Dispatched by: 645 (Alisha Lewis)\n" +
        "Lincoln County Ambulance Ambulance Medic 5\n\n\n\n" +
        "03-Aug-13 12:48:44 - Memo by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n" +
        "Demetrius Pride - 414\n\n" +
        "414 - requesting medics respond \n\n" +
        "male subject - poss over dose with pills \n\n" +
        "scene secure\n\n" +
        "03-Aug-13 12:47:48 - On Scene by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:44:44 - On Scene by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n" +
        "Demetrius Pride - 414\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:36:36 - Enroute by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n" +
        "Demetrius Pride - 414\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:32:31 - Enroute by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:32:25 - Backup by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n\n\n\n" +
        "03-Aug-13 12:32:25 - Dispatched by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 414 Beat: Zone-1\n" +
        "Demetrius Pride - 414\n\n\n\n" +
        "03-Aug-13 12:32:16 - Reassign by: 692 (Stacey Miederhoff)\n\n\n" +
        "03-Aug-13 12:32:16 - Dispatched by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 451 Beat: Zone-4\n" +
        "Tracy McCoy - 451\n\n\n\n" +
        "03-Aug-13 12:32:05 - Enroute by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 490 Beat: County\n" +
        "Michael Pirtle - 490\n\n" +
        "11 White Ln, Eolia\n\n\n\n" +
        "03-Aug-13 12:31:10 - Dispatched by: 692 (Stacey Miederhoff)\n" +
        "Lincoln County Sheriff Patrol Car 490 Beat: County\n" +
        "Michael Pirtle - 490\n\n\n\n" +
        "03-Aug-13 12:28:24 - Entered by: 658 (Ronnie Martin)\n" +
        "DOM VI - Domestic Violence (Priority 5)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: pike co\n" +
        "Location: 11 White Ln, Eolia\n\n" +
        "4 party call in ref to a male and female \n" +
        "physically fight in the yard\n\n" +
        "03-Aug-13 12:28:24 - Initiated by: 658 (Ronnie Martin)",

        "CALL:RUN REPORT",
        "ID:13-45229",
        "PLACE:OCC #13-17, INC #13-45229 - DOM VI - Domestic Violence\nTime Entered: 8/3/2013 12:28:24 PM\nReceived Via: Phone\n11 White Ln, Eolia\n\n4 party call in ref to a male and female \nphysically fight in the yard\n\nIncident Log:\n\n03-Aug-13 14:50:16 - Cleared RTF by: 658 (Ronnie Martin)\nClear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 14:12:16 - On Scene by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n03-Aug-13 13:40:11 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\nSt Joseph West - Unknown, Lake St Louis\n\n\n\n03-Aug-13 13:35:23 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n\n\n03-Aug-13 13:35:08 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-16432)  DOM VI - Domestic Violence\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n451- adv call was medical \nno domestic\n\n03-Aug-13 13:34:05 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n451-adv domestic unfounded \n\nfemale pat was transported - drank large amounts of alcohol and took s pills \n\n10-8\n\n03-Aug-13 13:28:19 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 13:28:16 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-17)  DOM VI - Domestic Violence\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 13:03:48 - Memo by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\npri 3\n\n03-Aug-13 13:01:33 - On Scene by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 13:00:34 - On Scene by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n11 White Ln, Eolia\n[Entry Time: 03-Aug-13 13:03:34]\n\n\n\n03-Aug-13 12:59:51 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-106)  DOM VI - Domestic Violence\nARCH Helicopter ARCH ARCH\n\nstand down on air \n\n\n\n03-Aug-13 12:59:45 - Cleared RTF by: 645 (Alisha Lewis)\nClear Incident 13-45229 (13-3677)  DOM VI - Domestic Violence\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:59:33 - Cleared Notebook by: 692 (Stacey Miederhoff)\nClear Incident 13-45229 (13-142)  DOM VI - Domestic Violence\nAir Evac Air Evac AIRE\n\nstand down air \n\n\n03-Aug-13 12:58:56 - Enroute by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:58:52 - Backup by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 12:58:52 - Dispatched by: 645 (Alisha Lewis)\nEolia Fire Brush 6919\n\n\n\n03-Aug-13 12:57:55 - Memo by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\nair 23 at base - adam is checking weather \n\n\n\n03-Aug-13 12:57:50 - Backup by: 692 (Stacey Miederhoff)\nARCH Helicopter ARCH ARCH\n\n\n\n03-Aug-13 12:57:50 - Dispatched by: 692 (Stacey Miederhoff)\nARCH Helicopter ARCH ARCH\n\n\n\n03-Aug-13 12:57:08 - Backup by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\n\n\n03-Aug-13 12:57:08 - Dispatched by: 692 (Stacey Miederhoff)\nAir Evac Air Evac AIRE\n\n\n\n03-Aug-13 12:56:56 - Backup by: 645 (Alisha Lewis)\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 12:56:56 - Dispatched by: 645 (Alisha Lewis)\nEolia Fire Fire Station EOLIA FD\n\n\n\n03-Aug-13 12:55:57 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\nunknown of what type of pills - subject is breathing but incherant\n\n03-Aug-13 12:51:41 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:51:38 - Backup by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:51:38 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance 6704\n\n\n\n03-Aug-13 12:51:23 - Enroute by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:49:15 - Backup by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 12:49:15 - Dispatched by: 645 (Alisha Lewis)\nLincoln County Ambulance Ambulance Medic 5\n\n\n\n03-Aug-13 12:48:44 - Memo by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n414 - requesting medics respond \n\nmale subject - poss over dose with pills \n\nscene secure\n\n03-Aug-13 12:47:48 - On Scene by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:44:44 - On Scene by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:36:36 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:32:31 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:32:25 - Backup by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\n\n\n\n03-Aug-13 12:32:25 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 414 Beat: Zone-1\nDemetrius Pride - 414\n\n\n\n03-Aug-13 12:32:16 - Reassign by: 692 (Stacey Miederhoff)\n\n\n03-Aug-13 12:32:16 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 451 Beat: Zone-4\nTracy McCoy - 451\n\n\n\n03-Aug-13 12:32:05 - Enroute by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 490 Beat: County\nMichael Pirtle - 490\n\n11 White Ln, Eolia\n\n\n\n03-Aug-13 12:31:10 - Dispatched by: 692 (Stacey Miederhoff)\nLincoln County Sheriff Patrol Car 490 Beat: County\nMichael Pirtle - 490\n\n\n\n03-Aug-13 12:28:24 - Entered by: 658 (Ronnie Martin)\nDOM VI - Domestic Violence (Priority 5)\nSource: Phone\n\nReporting Person: pike co\nLocation: 11 White Ln, Eolia\n\n4 party call in ref to a male and female \nphysically fight in the yard\n\n03-Aug-13 12:28:24 - Initiated by: 658 (Ronnie Martin)");

    doTest("T7",
        "(NEWOCC #13-17  Domestic Violence) NEW Domestic Violence 11 White Ln, Eolia",
        "CALL:Domestic Violence",
        "ADDR:11 White Ln",
        "CITY:Eolia");

    doTest("T8",
        "(HISTORY FOR OCC #OUTS, INC #13-44692 - TEST - Test, AGENCY: Eolia Fire) OCC #OUTS, INC #13-44692 - TEST - Test\n" +
        "Time Entered: 7/31/2013 5:28:55 PM\n" +
        "Received Via: Phone\n" +
        "Lincoln Co 911 - 250 W College St, Troy\n\n" +
        "TEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\n" +
        "Incident Log:\n\n" +
        "31-Jul-13 17:30:07 - Cleared Notebook by: 612 (Margie Harrell)\n" +
        "Clear Incident 13-44692 (OUTS)  TEST - Test\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n\n\n" +
        "31-Jul-13 17:29:50 - Memo by: 612 (Margie Harrell)\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n" +
        "TEST MESSAGE ONLY LET ME KNOW IF YOU GOT THIS \n" +
        "THANKS\n\n" +
        "31-Jul-13 17:29:25 - Dispatched by: 612 (Margie Harrell)\n" +
        "Eolia Fire Fire Station EOLIA FD\n\n\n\n" +
        "31-Jul-13 17:28:55 - Entered by: 612 (Margie Harrell)\n" +
        "TEST - Test (Priority 2)\n" +
        "Source: Phone\n\n" +
        "Location: Lincoln Co 911 - 250 W College St, Troy\n\n" +
        "TEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\n" +
        "31-Jul-13 17:28:55 - Initiated by: 612 (Margie Harrell)",

        "CALL:RUN REPORT",
        "ID:13-44692",
        "PLACE:OCC #OUTS, INC #13-44692 - TEST - Test\nTime Entered: 7/31/2013 5:28:55 PM\nReceived Via: Phone\nLincoln Co 911 - 250 W College St, Troy\n\nTEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\nIncident Log:\n\n31-Jul-13 17:30:07 - Cleared Notebook by: 612 (Margie Harrell)\nClear Incident 13-44692 (OUTS)  TEST - Test\nEolia Fire Fire Station EOLIA FD\n\n\n\n31-Jul-13 17:29:50 - Memo by: 612 (Margie Harrell)\nEolia Fire Fire Station EOLIA FD\n\nTEST MESSAGE ONLY LET ME KNOW IF YOU GOT THIS \nTHANKS\n\n31-Jul-13 17:29:25 - Dispatched by: 612 (Margie Harrell)\nEolia Fire Fire Station EOLIA FD\n\n\n\n31-Jul-13 17:28:55 - Entered by: 612 (Margie Harrell)\nTEST - Test (Priority 2)\nSource: Phone\n\nLocation: Lincoln Co 911 - 250 W College St, Troy\n\nTEST CALL REF TO ADDING THE NEW EMAIL TEXT ADDRESS\n\n31-Jul-13 17:28:55 - Initiated by: 612 (Margie Harrell)");

    doTest("T9",
        "(NEWOCC #OUTS  Test) NEW Test Lincoln Co 911 - 250 W College St, Troy",
        "CALL:Test Lincoln Co 911",
        "ADDR:250 W College St",
        "CITY:Troy");

    doTest("T10",
        "(HISTORY FOR OCC #OUTS, INC #13-4500 - MEDAID - Medical - Aid, AGENCY: Eolia FD) OCC #OUTS, INC #13-4500 - MEDAID - Medical - Aid\n" +
        "Time Entered: 7/27/2013 10:29:52 AM\n" +
        "Received Via: 911\n" +
        "COMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\n" +
        "Her name is Windell Shelton has fallin and hit her head.\n\n" +
        "Incident Log:\n\n" +
        "27-Jul-13 11:15:57 - Cleared Notebook by: 25 (Melinda Chatman)\n" +
        "Clear Incident 13-4500 (OUTS)  MEDAID - Medical - Aid\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "6902 called in and all units are clear\n" +
        "[Entry Time: 27-Jul-13 11:27:57]\n\n" +
        "27-Jul-13 10:45:46 - Memo by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "per 6900 contacting PCMH to find out which unit is responding to this incident so that they can which over to the Eolia repeater\n\n" +
        "27-Jul-13 10:43:30 - Modified by: 25 (Melinda Chatman)\n" +
        "Location: COMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\n" +
        "27-Jul-13 10:42:54 - On Scene by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n" +
        "6901 on scene\n\n" +
        "27-Jul-13 10:42:21 - On Scene by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n" +
        "6900 and 6902 on scene\n\n" +
        "27-Jul-13 10:37:36 - Enroute by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n" +
        "6900 and 6902 e/r\n\n" +
        "27-Jul-13 10:36:18 - Memo by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "time of second page\n\n" +
        "27-Jul-13 10:33:01 - Memo by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "Time of first page\n\n" +
        "27-Jul-13 10:32:57 - Dispatched by: 25 (Melinda Chatman)\n" +
        "Eolia FD 1st Responders EFD 1st\n\n" +
        "27-Jul-13 10:32:44 - Initiated by: 25 (Melinda Chatman)\n" +
        "[Entry Time: 27-Jul-13 10:29:52]\n\n" +
        "27-Jul-13 10:29:52 - Entered by: 25 (Melinda Chatman)\n" +
        "MEDAID - Medical - Aid (Priority 2)\n" +
        "Source: 911\n\n" +
        "Reporting Person: Sharon nurse\n" +
        "Phone: 573-324-3444\n" +
        "Address: COMMUNITY; IN-HOME SERVICES - 209 BUSINESS HIGHWAY 61 N, Bowling Green\n" +
        "Location: COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n" +
        "Her name is Windell Shelton has fallin and hit her head.",

        "CALL:RUN REPORT",
        "ID:13-4500",
        "PLACE:OCC #OUTS, INC #13-4500 - MEDAID - Medical - Aid\nTime Entered: 7/27/2013 10:29:52 AM\nReceived Via: 911\nCOMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\nHer name is Windell Shelton has fallin and hit her head.\n\nIncident Log:\n\n27-Jul-13 11:15:57 - Cleared Notebook by: 25 (Melinda Chatman)\nClear Incident 13-4500 (OUTS)  MEDAID - Medical - Aid\nEolia FD 1st Responders EFD 1st\n\n6902 called in and all units are clear\n[Entry Time: 27-Jul-13 11:27:57]\n\n27-Jul-13 10:45:46 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nper 6900 contacting PCMH to find out which unit is responding to this incident so that they can which over to the Eolia repeater\n\n27-Jul-13 10:43:30 - Modified by: 25 (Melinda Chatman)\nLocation: COMMUNITY; IN-HOME SERVICES - 212 W Elsom, Bowling Green\n\n27-Jul-13 10:42:54 - On Scene by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6901 on scene\n\n27-Jul-13 10:42:21 - On Scene by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6900 and 6902 on scene\n\n27-Jul-13 10:37:36 - Enroute by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nCOMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\n6900 and 6902 e/r\n\n27-Jul-13 10:36:18 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\ntime of second page\n\n27-Jul-13 10:33:01 - Memo by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\nTime of first page\n\n27-Jul-13 10:32:57 - Dispatched by: 25 (Melinda Chatman)\nEolia FD 1st Responders EFD 1st\n\n27-Jul-13 10:32:44 - Initiated by: 25 (Melinda Chatman)\n[Entry Time: 27-Jul-13 10:29:52]\n\n27-Jul-13 10:29:52 - Entered by: 25 (Melinda Chatman)\nMEDAID - Medical - Aid (Priority 2)\nSource: 911\n\nReporting Person: Sharon nurse\nPhone: 573-324-3444\nAddress: COMMUNITY; IN-HOME SERVICES - 209 BUSINESS HIGHWAY 61 N, Bowling Green\nLocation: COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n\nHer name is Windell Shelton has fallin and hit her head.");

    doTest("T11",
        "(NEWOCC #OUTS  MEDAID - Medical - Aid) NEWOCC #OUTS  MEDAID - Medical - Aid\n" +
        "Address: COMMUNITY; IN-HOME SERVICES - 21 W Elsom, Bowling Green\n" +
        "Reporting Person: Sharon Phone: 573-324-3444\n" +
        "Detail: Her name is Windell Shelton has fallin and hit her head.",

        "CODE:MEDAID",
        "CALL:Medical - Aid",
        "PLACE:COMMUNITY; IN-HOME SERVICES",
        "ADDR:21 W Elsom",
        "CITY:Bowling Green",  // Address not actuall in Bowling Green according to Google
        "NAME:Sharon",
        "PHONE:573-324-3444",
        "INFO:Her name is Windell Shelton has fallin and hit her head.");

    doTest("T12",
        "(HISTORY FOR OCC #OUTS, INC #13-4457 - FIRE - Fire, AGENCY: Eolia FD) OCC #OUTS, INC #13-4457 - FIRE - Fire\n" +
        "Time Entered: 7/25/2013 2:52:20 PM\n" +
        "Received Via: Phone\n" +
        "Eolia\n\n" +
        "test test test\n\n" +
        "Incident Log:\n\n" +
        "25-Jul-13 14:54:50 - Cleared Notebook by: 227 (Charlotte Schroeder)\n" +
        "Clear Incident 13-4457 (OUTS)  FIRE - Fire\n" +
        "Eolia FD Pumper/Rescue 6910\n\n" +
        "test test\n\n" +
        "25-Jul-13 14:54:15 - On Scene by: 227 (Charlotte Schroeder)\n" +
        "Eolia FD Pumper/Rescue 6910\n\n" +
        "Eolia\n\n" +
        "test test test test\n\n" +
        "25-Jul-13 14:53:02 - Dispatched by: 227 (Charlotte Schroeder)\n" +
        "Eolia FD Pumper/Rescue 6910\n\n" +
        "25-Jul-13 14:52:48 - Initiated by: 227 (Charlotte Schroeder)\n\n\n" +
        "25-Jul-13 14:52:20 - Entered by: 227 (Charlotte Schroeder)\n" +
        "FIRE - Fire (Priority 2)\n" +
        "Source: Phone\n\n" +
        "Reporting Person: test\n" +
        "Location: Eolia\n\n" +
        "test test test",

        "CALL:RUN REPORT",
        "ID:13-4457",
        "PLACE:OCC #OUTS, INC #13-4457 - FIRE - Fire\nTime Entered: 7/25/2013 2:52:20 PM\nReceived Via: Phone\nEolia\n\ntest test test\n\nIncident Log:\n\n25-Jul-13 14:54:50 - Cleared Notebook by: 227 (Charlotte Schroeder)\nClear Incident 13-4457 (OUTS)  FIRE - Fire\nEolia FD Pumper/Rescue 6910\n\ntest test\n\n25-Jul-13 14:54:15 - On Scene by: 227 (Charlotte Schroeder)\nEolia FD Pumper/Rescue 6910\n\nEolia\n\ntest test test test\n\n25-Jul-13 14:53:02 - Dispatched by: 227 (Charlotte Schroeder)\nEolia FD Pumper/Rescue 6910\n\n25-Jul-13 14:52:48 - Initiated by: 227 (Charlotte Schroeder)\n\n\n25-Jul-13 14:52:20 - Entered by: 227 (Charlotte Schroeder)\nFIRE - Fire (Priority 2)\nSource: Phone\n\nReporting Person: test\nLocation: Eolia\n\ntest test test");
   
  }
  
  public static void main(String[] args) {
    new MOLincolnCountyParserTest().generateTests("T1");
  }
}