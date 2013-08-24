package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Brunswick County, NC
Contact: "~Heather~" <sunshine5grl@gmail.com>
Contact: Tom Rogers <tomrogers2@gmail.com
Sender: pagegate@brunswickes.com
System: Southern Software

Contact: Anthony Nathan <tnathan55@gmail.com>
1333 SOUTH DICKINSON DR LELAND 11-053813 10:30:06 Take Written Report (10-92) AT SUITE 110....10-83 WITH MIRANDA REF PROPERTY DAMAGE TO VEH
1111 NEW POINTE BLVD LELAND 11-053827 11:42:05 911 HANG UP ON CALL BACK SPOKE W/ LAURA ADVD SUBJS SHE WAS CALLING IN REF TO LEFT THE BUSN

Contact: Christopher Grace Jr <cgracejr@gmail.com>
Sender: lelandems+bncCOqwh4kZEO2g9_EEGgTkSK1X@googlegroups.com
2192:BRUNSWICK COVE NURSING HOME 1478 RIVER RD SE WINNABOW 11-062488 19:38:00 Falls

Contact: Doritto <no1bravesfancandy@gmail.com>
1051:MT PISGAH BAPTIST CHURCH 494 MT PISGAH RD SW SUPPLY 11-085300 18:43:59 Brush Fire ON THE RIGHT IF GOING TOWARDS HOLDEN BEACH RD JUST PASSED MT PISGAH CHURCH ... ADVD SMALL FIRE IN T

Contact: Joe Jenkins <chasenfins@gmail.com>
Sender: vtext.com@returns.groups.yahoo.com
sentto-81008140-155-1334858821-9109162452=vtext.com@returns.groups.yahoo.com ([northwestvfd] ) 812:9035 DALES HAVEN RD NE NORTHWEST MDL 17B03-G 12-029328 14:02:41 Falls MEDICAL ALA
sentto-81008140-157-1334863333-9109162452=vtext.com@returns.groups.yahoo.com ([northwestvfd] ) 814:6598 NEW GROUND TR NE NORTHWEST MDL 26C02 12-029355 15:17:43 Sick Person (Specifi

Contact: Luke Duke <bigcountrymud@gmail.com>
Sender: vtext.com@returns.groups.yahoo.com
([civietownvfd] )\n1644:375 HIGH HILL DR SW SHALLOTTE 12-030794 18:13:00 Traffic-Transportation Incident

Contact: Daniel McCarthy <mcca6564@student.brunswickcc.edu>
Sender: pagegate@brunswickes.com
S:[calabashvems]  M:7045:998 WATERVIEW LN CAROLINA SHORES 12-034031 17:20:33 Sick Person (Specific Diagnosis) 2 YOM SICK AND THROWING UP FOR 5 DAYS\n

Contact: Keith Richardson <aldo4371@gmail.com>
Sender: vtext.com@returns.groups.yahoo.com
sentto-81052485-2179-1340294796-8439951185= vtext.com@returns.groups.yahoo.com ([calabashvems]) 7678:204 AZALEA CIR SUNSET BEACH 12-048247 12:04:31 Breathing Problems BREATHING PROB

Contact: Brian Campbell <bcampbell1404@gmail.com>
Sender: pagegate@brunswickes.com
Subject:[sunsetbeachfd] \n3287:424 EGRET DR SUNSET BEACH, MDL 17D02, 12-077164, 13:36:06, Falls, CALLER ADV NEIGHBOR HAS FALLEN\r
Subject:[sunsetbeachfd] \n3291:413 WATER OAK WYND SW SUNSET BEACH, MDL 23B01-I, 12-077314, 21:32:48, Overdose-Poisoning (Ingestion), WI\r

Contact: Mark <powers1127@atmc.net>
Sender: pagegate@brunswickes.com
9333:OLD GEORGETOWN RD SW / OCEAN ISLE BEACH RD SW, MDL 29B04, 12-077625, 23:38:01, Traffic-Transportation Incidents, GEORGETOWN TOWARD 904 ....BLK MOTORCYCLE

Contact: "dafarrisinbsl@yahoo.com" <dafarrisinbsl@yahoo.com>
Sender: From:pagegate@brunswickes.com
FRM:pagegate@brunswickes.com\nSUBJ:[bslvfd]\nMSG:2534:1171 SOUTH SHORE DR BOILING SPRING LAKES, MDL 26O07, 12-077822, 17:05:49, Sick Person (Specific Diagnosis),

Contact: Heather Heigl <hheigl@brunswickes.com>
Sender: pagegate@brunswickes.com
FRM:pagegate@brunswickes.com\nMSG:1553:8470 RIVER RD SE SOUTHPORT, MDL 10C01, 12-079416, 08:38:26, Chest Pain (Non-Traumatic),
 1 of 2\nFRM:pagegate@brunswickes.com\nMSG:1552:10181 STONEY BROOK CT SE LELAND, 12-079285, 17:22:53, Gas Leak-Spill-Odor, REF TO AN ODOR IN THE\n(Con't) 2 of 2\nRESIDENCE FROM A BURNT OUT LIGHT BULB(End)
FRM:pagegate@brunswickes.com\nMSG:1551:UNION PRIMARY SCHOOL 180 UNION SCHOOL RD NW SHALLOTTE, 12-079246, 15:10:36, Gas Leak-Spill-Odor, BUS294
 1 of 2\nFRM:pagegate@brunswickes.com\nMSG:1550:3243 MARSH VIEW DR SW SUPPLY, 12-079235, 14:43:36, Lifting Assistance (Request By EMS), NEED\n(Con't) 2 of 2\nLIFTING ASSISTANCE REF BARRIATRIC PT.(End)
 1 of 2\nFRM:pagegate@brunswickes.com\nMSG:1548:2975 SHELL POINT RD SW SHALLOTTE, 12-079174, 10:41:43, Cardiac or Respiratiory Arrest - Death, ADVD\n(Con't) 2 of 2\nTHAT HE THINKS HE FOUND HIS CO-WORKER DEAD..(End)

Contact: dsprather40@aol.com <dsprather40@aol.com>
Sender: vtext.com@returns.groups.yahoo.com
sentto-80999237-3362-1362685070-3013992617=vtext.com@returns.groups.yahoo.com ([calabashvfd]) 6354:7114 OLD GEORGETOWN RD SW OCEAN ISLE BEACH, 13-018209, 14:37:23, Structure Fire (

Contact: Active911
Agency name: Brunswick County Fire Marshall
Location: Bolivia, NC, United States
Sender: pagegate@brunswickes.com

(27 PAISLEY DR APT 103 SHALLOTTE, MDL 09E01, 13-001668, 06) 7:34:58, Cardiac or Respiratiory Arrest - Death, HUSBAND LAYING ON THE BED WITH HIS EYES IN THE BACK ON HIS HEAD....
(5073 GLEN COVE DR OAK ISLAND, 13-001658, 04) 6:25:23, Structure Fire (Smoke/Flames Visible)(Confirmed), FIRE ALARM ACTIVATED AND THERE IS SMOKE IN THE RESD....ADVD CALLER TO GET EVERYONE OUT OF THE RESD
(3500 MACO RD NE LELAND, MDL 17D02, 13-001446, 05) 5:20:29, Falls,
(OLD FAYETTEVILLE RD NE / SUNNY TR NE LELAND, 13-001245, 14) 2:14:16, Structure Fire (Smoke/Flames Visible)(Confirmed), 3 BIG SHEDS ON FIRE BEHIND A HOUSE
(3325 OLD OCEAN HWY BOLIVIA, 13-000946, 15) 1:27:41, Test Call (Training-Maint.), TESTING SMTP PAGING SCHEME\r\n
(2424 BELSHAW DR LELAND, MDL 09E01, 13-006044, 17) 70:42:13, Cardiac or Respiratiory Arrest - Death,\r\n
(7177 BONAVENTURE ST SW OCEAN ISLE BEACH, MDL 28C01-I, 13-005347, 08) 62:18:39, Cardiac or Respiratiory Arrest - Death,\r\n
(3155 MT MISERY RD NE LELAND, MDL 27B02-S, 13-005234, 19) 57:54:50, Stab-Gunshot-Penetrating Trauma,\r\n
(5130 MELINDA CT OAK ISLAND, MDL 09E01, 13-004813, 11) 49:09:58, Cardiac or Respiratiory Arrest - Death,\r\n
(38 BROOKS CT 205 SHALLOTTE, MDL 09E01, 13-004743, 01) 47:31:35, Cardiac or Respiratiory Arrest - Death,\r\n
(400 N MULBERRY RD SHALLOTTE, MDL 29D02-m, 13-004099, 20) 34:05:47, Traffic-Transportation Incidents,\r\n

Contact: Active911
Agency name: St James FD
Location: Southport, NC, United States
Sender: pagegate@brunswickes.com

([stjamesvrs] ) 2125:13-068360, ST47(DS)15:49:25|4795(ER)15:55:06|ST47(IS)15:55:06|4795(AS)15:58:56|4795(TR)16:03:20|4795(DEST)16:26:56|4795(IS)16:34:28|
([stjamesvrs] ) 2124:3269 WILD AZALEA WAY ST JAMES, MDL 26O05, 13-068360, 15:49:25, Sick Person (Specific Diagnosis),
([stjamesvrs] ) 2123:13-068295, ST47(DS)11:43:27|4795(ER)11:44:58|ST47(IS)11:44:58|4795(AS)11:47:57|4795(TR)11:58:36|4795(DEST)12:14:20|4795(IS)12:22:49|
([stjamesvrs] ) 2122:3582 RUDDY DUCK WYND ST JAMES, MDL 02D01, 13-068295, 11:43:27, Allergies (Reactions) - Envenomations (Stings Bite, POSSIBLE REACTION TO MEDICATIONS
([stjamesvfd] ) 632:13-067969, ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|3780C(DS)12:59:03|3780C(AS)12:59:06|3780C(IS)13:00:25|
([stjamesvfd] ) 631:13-067969, ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|
([stjamesvrs] ) 2121:13-067969, ST47(DS)12:50:43|4795(ER)12:55:47|ST47(IS)12:55:47|4795(IS)12:55:50|
([stjamesvfd] ) 630:SOUTHPORT-SUPPLY RD SE / ST JAMES DR ST JAMES, MDL 29B04-U, 13-067969, 12:50:43, Traffic-Transportation Incidents, CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT
([stjamesvrs] ) 2120:SOUTHPORT-SUPPLY RD SE / ST JAMES DR ST JAMES, MDL 29B04-U, 13-067969, 12:50:43, Traffic-Transportation Incidents, CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT
([stjamesvrs] ) 2119:13-067860, ST47(DS)03:44:30|4795(ER)03:54:43|ST47(IS)03:54:43|4795(IS)03:58:48|
([stjamesvrs] ) 2118:3921 PEPPERBERRY LN SE SOUTHPORT, MDL 17B03-G, 13-067860, 03:44:30, Falls, FROMMATER RESD... PT HAS FALLEN IN THE BATHROOM...HAS PT ON THE PHONE BUT PT CANT HEAR HER..RECD 336
([stjamesvrs] ) 2117:13-067699, ST47(DS)17:47:05|4795(ER)17:51:53|ST47(IS)17:51:53|4795(AS)17:57:24|4795(IS)18:15:02|
([stjamesvrs] ) 2116:3939 HARMONY CIR SE SOUTHPORT, MDL 17B03-G, 13-067699, 17:47:05, Falls,
([stjamesvrs] ) 2115:13-067606, ST47(DS)13:51:40|4795(ER)13:56:27|ST47(IS)13:56:27|4795(AS)14:06:32|4795(TR)14:39:31|4795(DEST)14:54:02|4795(IS)15:00:52|
([stjamesvrs] ) 2114:MIDWAY RD SE / GREEN LEWIS RD SE BOLIVIA, MDL 25B03, 13-067606, 13:51:40, Psychiatric-Abnormal Behavior- Suicide Attempt, COMP DAUGHTER KEEPS CALLING ADVD THERE IS A DISTURBANCE ...WANTS LEO TO MEET HER ...10-12 GRAY PONTI
([stjamesvrs] ) 2113:13-067535, ST47(DS)09:44:49|4795(ER)09:47:11|ST47(IS)09:47:11|4795(AS)09:54:21|4795(TR)10:14:21|4795(DEST)10:26:58|4795(IS)10:50:30|
([stjamesvrs] ) 2112:4021 BRICK PATH LN SE SOUTHPORT, MDL 13A01, 13-067535, 09:44:49, Diabetic Problems, MOTHER IS DIABETIC CANT GET READING AND WEAK
([stjamesvfd] ) 629:13-067432, ST37(DS)23:21:26|3780C(ER)23:24:26|ST37(IS)23:24:26|3771E(DS)23:30:53|3771E(ER)23:30:56|3780C(IS)23:33:18|3771E(IS)23:33:20|
([stjamesvfd] ) 628:4020 E DOLPHIN DR OAK ISLAND, 13-067432, 23:21:26, Structure Fire (Smoke/Flames Visible)(Confirmed),
([stjamesvrs] ) 2111:13-067283, ST47(DS)15:23:58|4795(ER)15:27:23|ST47(IS)15:27:23|4795(AS)15:31:08|4795(IS)15:47:04|
([stjamesvrs] ) 2110:3851 MEMBERS CLUB BLVD ST JAMES, MDL 19D04, 13-067283, 15:23:58, Heart Problems - A.I.C.D.,
([stjamesvfd] ) 627:13-067146, ST37(DS)04:54:44|3780C(ER)04:58:38|ST37(IS)04:58:38|3771E(ER)05:05:18|3771E(IS)05:10:39|3780C(AS)05:10:41|3780C(IS)05:15:34|
([stjamesvfd] ) 626:CHASERS SPORTS BAR & GRILL 8520 E OAK ISLAND DR OAK ISLAND, 13-067146, 04:54:44, Structure Fire (Smoke/Flames Visible)(Confirmed), IS ON FIRE..
([stjamesvfd] ) 625:13-067022, ST37(DS)19:45:26|3780C(ER)19:50:58|ST37(IS)19:50:58|3771E(ER)19:58:47|3780C(AS)19:59:59|3777B(AS)20:02:35|3771E(ER2)20:02:48|3771E(AS2)20:04:45|3771E(IS)20:38:47|3777B(IS)20:51:42|3780C(IS)20:51:44|
([stjamesvfd] ) 624:4388 SEA PINES DR SE SOUTHPORT, 13-067022, 19:45:26, Woods Fire, CALLER ADV OF SEEING A LARGE PLUM OF SMOKE SAME IS NOT COMING FROM ST JAMES BUT BACK TOWARDS THE AIR
([stjamesvrs] ) 2109:13-066955, ST47(DS)16:49:03|4795(ER)16:49:50|ST47(IS)16:49:50|4795(IS)16:59:57|
([stjamesvrs] ) 2108:2810 BROWN RD SE BOLIVIA, MDL 19D04, 13-066955, 16:49:03, Heart Problems - A.I.C.D.,
([stjamesvrs] ) 2107:13-066943, ST47(DS)16:12:02|4795(ER)16:15:47|ST47(IS)16:15:47|4795(AS)16:20:02|4795(IS)16:41:38|
([stjamesvrs] ) 2106:3234 EAST LAGOON CT ST JAMES, MDL 31D03, 13-066943, 16:12:02, Unconscious-Fainting (Near),
([stjamesvrs] ) 2105:13-066819, ST47(DS)08:26:55|4795(ER)08:28:38|ST47(IS)08:28:38|4795(AS)08:41:59|4795(IS)09:04:03|
([stjamesvrs] ) 2104:904 GREEN LEWIS RD SE BOLIVIA, MDL 31D03, 13-066819, 08:26:55, Unconscious-Fainting (Near),
([stjamesvrs] ) 2103:13-066813, ST47(DS)08:06:26|4795(ER)08:13:41|ST47(IS)08:13:41|4795(IS)08:14:32|
([stjamesvrs] ) 2102:780 MCKAY RD SE BOLIVIA, MDL 09B01-a, 13-066813, 08:06:26, Cardiac or Respiratiory Arrest - Death,
([stjamesvfd] ) 623:13-066604, ST37(DS)14:23:59|3780C(ER)14:25:58|ST37(IS)14:25:58|3771E(DS)14:33:19|3771E(ER)14:33:22|3780C(IS)14:35:01|3771E(IS)14:35:14|
([stjamesvfd] ) 622:4207 E OAK ISLAND DR OAK ISLAND, 13-066604, 14:23:59, Structure Fire (Reported), ADVD WATER HEATER CAUGHT ON FIRE, FIRE IS OUT NOW BUT REQ FIRE DEPT CHECK SAME BECAUSE THIS RESD IS
([stjamesvrs] ) 2101:13-066475, ST47(DS)04:36:21|4795(ER)04:46:48|ST47(IS)04:46:48|4795(AS)04:50:23|4795(IS)05:00:27|
([stjamesvrs] ) 2100:4176 SKEFFINGTON CT ST JAMES, MDL 17B03, 13-066475, 04:36:21, Falls, WIFE IS INVALID
([stjamesvrs] ) 2099:13-066169, ST47(DS)09:24:47|4795(ER)09:28:55|ST47(IS)09:28:56|4795(AS)09:33:25|4795(IS)09:48:32|
([stjamesvrs] ) 2098:4176 SKEFFINGTON CT ST JAMES, MDL 26A01, 13-066169, 09:24:47, Sick Person (Specific Diagnosis),
([stjamesvrs] ) 2097:13-066131, ST47(DS)04:37:14|4795(ER)04:45:35|ST47(IS)04:45:35|4795(IS)04:47:47|
([stjamesvrs] ) 2096:4176 SKEFFINGTON CT ST JAMES, MDL 26A01, 13-066131, 04:37:14, Sick Person (Specific Diagnosis), REF TO ASSISTING HIS WIFE TO GO TO THE BATHROOM...ADV SHE CANT WALK... FEMALE HAD CANCER...
([stjamesvrs] ) 2095:13-066000, ST47(DS)18:45:47|4795(ER)18:52:20|ST47(IS)18:52:20|4795(AS)19:07:57|4795(TR)19:23:15|4795(DEST)19:55:38|4795(IS)20:13:03|
([stjamesvrs] ) 2094:3692 LAW RD SE BOLIVIA, MDL 17A02, 13-066000, 18:45:47, Falls,
([stjamesvfd] ) 621:13-065985, ST37(DS)17:54:45|ST37(IS)18:05:01|
([stjamesvfd] ) 620:5204 E BEACH DR OAK ISLAND, 13-065985, 17:54:46, Structure Fire (Smoke/Flames Visible)(Confirmed), A/C REPAIR MAN IS WORKING ON A/C UNIT AND SMELL SMOKE
([stjamesvrs] ) 2093:13-065900, ST47(DS)12:41:21|4795(ER)12:48:15|ST47(IS)12:48:15|4795(IS)12:49:04|
([stjamesvrs] ) 2092:2988 BROWN RD SE BOLIVIA, MDL 31D03, 13-065900, 12:41:21, Unconscious-Fainting (Near),
([stjamesvrs] ) 2091:13-065814, ST47(DS)05:37:09|4795(ER)05:46:02|ST47(IS)05:46:02|4795(AS)05:50:49|4795(IS)05:57:30|
([stjamesvrs] ) 2090:3619 MEMBERS CLUB BLVD ST JAMES, MDL 01C06, 13-065814, 05:37:09, Abdominal Pains - Problems, WIFE HAS SMALL BOWEL CANCER AND IS IN EXTREME PAIN
([stjamesvrs] ) 2089:13-065456, ST47(DS)07:08:15|4795(ER)07:14:48|ST47(IS)07:14:48|4795(IS)07:19:13|
([stjamesvrs] ) 2088:3660 WILLOW LAKE DR SE SOUTHPORT, MDL 26C01, 13-065456, 07:08:15, Sick Person (Specific Diagnosis),
([stjamesvrs] ) 2087:13-065446, ST47(DS)04:57:24|4795(ER)05:06:49|ST47(IS)05:06:49|4795(AS)05:11:26|4795(IS)05:13:20|
([stjamesvrs] ) 2086:4176 SKEFFINGTON CT ST JAMES, MDL 17A03, 13-065446, 04:57:24, Falls, INVALID WIFE UNABLE TO WALK...NEEDS ASSISTANCE GETTING FROM BED TO BATHROOM
([stjamesvfd] ) 619:13-065089, ST37(DS)07:03:31|3780C(ER)07:05:38|ST37(IS)07:05:38|3771E(DS)07:13:56|3771E(ER)07:14:00|3780C(IS)07:15:21|3771E(IS)07:15:24|
([stjamesvfd] ) 618:65 YAUPON WAY OAK ISLAND, 13-065089, 07:03:31, Structure Fire (Reported), TURNED ON LIGHT SWITCH IN HOUSE AND COULD SMELL AND SEE SMOKE IN THE RESIDENCE ..SAME OCCURED 10 MIN
([stjamesvrs] ) 2085:13-065078, ST47(DS)05:55:34|4795(ER)06:02:39|ST47(IS)06:02:39|4795(AS)06:06:07|4795(IS)06:11:52|
([stjamesvrs] ) 2084:3269 WILD AZALEA WAY ST JAMES, MDL 10D04, 13-065078, 05:55:34, Chest Pain (Non-Traumatic),
([stjamesvrs] ) 2083:13-065069, ST47(DS)04:00:43|ST47(IS)04:10:24|
([stjamesvrs] ) 2082:MIDWAY SEAFOOD 1446 MIDWAY RD SE BOLIVIA, MDL 29D02-p, 13-065069, 04:00:43, Traffic-Transportation Incidents, ON MIDWAY RD JUST BEFORE MIDWAY SEAFOOD IS A DARK COLORED PC IN DITCH...CALLER ADV SAME IS ON THE R
([stjamesvfd] ) 617:13-064772, ST37(DS)05:30:11|3780C(ER)05:32:59|ST37(IS)05:32:59|3780C(AS)05:35:20|3772E(ER)05:40:20|3771E(ER)05:43:49|3773TO(ER)05:44:32|3772E(AS)05:44:58|3771E(AS)05:48:21|3773TO(AS)05:49:13|3773TO(IS)05:58:00|3771E(IS)05:58:15|3772E(IS
([stjamesvfd] ) 616:2760 LONG BAY DR ST JAMES, 13-064772, 05:30:11, Fire Alarm Activation, MARINA AT ST JAMES ZONE 42 RACK C HEAT DETECTOR
([stjamesvrs] ) 2081:13-064571, ST47(DS)13:47:54|4795(ER)13:53:11|ST47(IS)13:53:11|4795(AS)13:55:42|4795(IS)14:07:53|
([stjamesvrs] ) 2080:4143 AMBLESTONE WAY ST JAMES, MDL 28C01-L, 13-064571, 13:47:54, Stroke (CVA), STROKE
([stjamesvrs] ) 2079:13-064385, ST47(DS)20:30:00|4795(ER)20:33:01|ST47(IS)20:33:01|4795(AS)20:34:33|4795(IS)20:56:25|
([stjamesvrs] ) 2078:3628 PLAYERS CLUB DR ST JAMES, MDL 17B03-G, 13-064385, 20:30:00, Falls, SUSAN CHILDS.. FELL.. 9104549831...
([stjamesvrs] ) 2077:13-064368, ST47(DS)19:30:18|4795(ER)19:37:00|ST47(IS)19:37:00|4795(AS)19:41:27|4795(IS)19:59:37|
([stjamesvrs] ) 2076:2571 ST JAMES DR HARBORSIDE @ ST ST JAMES, MDL 17B03-G, 13-064368, 19:30:18, Falls, ADV A FEMALE FALL..CALLER IS NOT WITH HER
([stjamesvrs] ) 2075:13-064305, ST47(DS)16:27:55|4795(ER)16:32:58|ST47(IS)16:32:58|4795(AS)16:44:23|4795(IS)17:16:16|
([stjamesvfd] ) 615:13-064309, ST37(DS)16:20:30|3780C(ER)16:22:22|ST37(IS)16:22:22|3780C(IS)16:28:15|
([stjamesvrs] ) 2074:2004 W OAK ISLAND DR OAK ISLAND, MDL 06D02-A, 13-064305, 16:27:55, Cardiac or Respiratiory Arrest - Death,
([stjamesvfd] ) 614:116 SW 21ST ST OAK ISLAND, 13-064309, 16:20:30, Fire Alarm Activation, ROBERT LUDWIG RESD......UPSTAIRS SMOKE DET AND KEYPAD FIRE ALARM.....910-278-6712
([stjamesvfd] ) 613:13-064260, ST37(DS)13:26:28|3780C(ER)13:28:03|ST37(IS)13:28:03|3780C(AS)13:33:02|3772E(DS)13:34:46|3772E(ER)13:34:50|3771E(DS)13:37:55|3771E(ER)13:37:57|3772E(AS)13:38:37|3771E(AS)13:42:31|3772E(IS)13:52:30|3771E(IS)13:52:38|3780C(IS)13
([stjamesvfd] ) 612:3210 EAST LAGOON CT ST JAMES, 13-064260, 13:26:28, Fire Alarm Activation, KEITH MARTIN ..910-253-7567..FIRE ALARM ACTIVATION GENERAL FIRE ZONE 17 ..WILL ATT KH
([stjamesvrs] ) 2073:13-064198, ST47(DS)09:33:29|4795(ER)09:40:55|ST47(IS)09:40:55|4795(IS)09:42:32|
([stjamesvrs] ) 2072:3685 ORCHID LN SE BOLIVIA, 13-064198, 09:33:29, Subject Locked in Vehicle, 17 MONTH OLD LOCKED IN VEH ... CHILD NOT IN DISTRESS .. VEH IS NOT RUNNING
([stjamesvrs] ) 2071:13-064043, ST47(DS)17:30:16|4795(ER)17:36:40|ST47(IS)17:36:40|4795(AS)17:51:36|4795(TR)18:06:54|4795(DEST)18:19:51|4795(IS)18:30:47|
([stjamesvrs] ) 2070:MIDWAY RD SE / OLD OCEAN HWY BOLIVIA, MDL 29D02-p, 13-064043, 17:30:16, Traffic-Transportation Incidents, ON MIDWAY RD JUST DOWN FROM OLD OCEAN HWY...GREEN DODGE TRK....ROLLOVER
([stjamesvrs] ) 2069:13-063942, ST47(DS)12:10:29|4795(ER)12:17:56|ST47(IS)12:17:56|4795(AS)12:28:20|4795(TR)13:31:10|4795(DEST)14:25:12|4795(IS)14:25:28|
([stjamesvrs] ) 2068:146 NW 11TH ST OAK ISLAND, MDL 09E01, 13-063942, 12:10:29, Cardiac or Respiratiory Arrest - Death,
([stjamesvfd] ) 611:13-063742, ST37(DS)18:29:01|ST37(IS)18:36:19|
([stjamesvfd] ) 610:GEORGE II HWY SE / OCEAN HWY E (HWY 17 N) WINNABOW, 13-063742, 18:29:01, Standby, REQ STA37 MOVE UP TO 17/87 FOR NORTH END STANDBY
([stjamesvrs] ) 2067:13-063395, ST47(DS)17:36:51|4795(ER)17:43:03|ST47(IS)17:43:03|4795(AS)17:46:35|4795(IS)18:23:59|
([stjamesvrs] ) 2066:FOUNDERS CLUB (ST JAMES) & POOL 3021 BEAVER CREEK DR ST JAMES, MDL 20A01-H, 13-063395, 17:36:51, Heat - Cold Exposure, MALE SUBJ CRAMPING UP
([stjamesvfd] ) 609:13-062923, ST37(DS)12:09:39|3780C(ER)12:12:08|ST37(IS)12:12:08|3780C(IS)12:17:14|
([stjamesvfd] ) 608:3002 E OAK ISLAND DR OAK ISLAND, 13-062923, 12:09:39, Structure Fire (Smoke/Flames Visible)(Confirmed),
([stjamesvrs] ) 2065:13-062761, ST47(DS)21:22:20|ST47(IS)23:52:48|
([stjamesvfd] ) 607:13-062754, ST37(DS)20:58:30|3780C(ER)21:00:53|ST37(IS)21:00:53|3771E(ER)21:08:18|3771E(AS)21:20:54|3780C(AS)21:42:08|3780C(IS)23:27:28|3771E(IS)23:30:09|
([stjamesvrs] ) 2064:ST JAMES FIRE (STATION 37) 3628 ST JAMES DR ST JAMES, 13-062761, 21:22:21, Standby,
([stjamesvfd] ) 606:SOUTHPORT FIRE (STATION 3) 1011 N HOWE ST SOUTHPORT, 13-062754, 20:58:30, Standby,
([stjamesvrs] ) 2063:13-062124, ST47(DS)01:31:34|ST47(IS)01:42:36|
([stjamesvrs] ) 2062:2930 HEWETT RD SE BOLIVIA, MDL 26A11, 13-062124, 01:31:34, Sick Person (Specific Diagnosis),
([stjamesvrs] ) 2061:13-061829, ST47(DS)02:33:49|4795(ER)02:43:35|ST47(IS)02:43:35|4795(IS)02:53:59|
([stjamesvrs] ) 2060:2930 HEWETT RD SE BOLIVIA, MDL 26A11, 13-061829, 02:33:49, Sick Person (Specific Diagnosis), DAUGHTER IS SICK
([stjamesvrs] ) 2059:13-061801, ST47(DS)23:56:18|4795(ER)00:04:31|ST47(IS)00:04:32|4795(AS)00:08:45|4795(IS)00:27:22|
([stjamesvrs] ) 2058:3619 MEMBERS CLUB BLVD ST JAMES, MDL 06D01, 13-061801, 23:56:18, Breathing Problems,
([stjamesvfd] ) 605:13-061161, ST37(DS)23:12:35|3780C(ER)23:16:22|ST37(IS)23:16:22|3771E(ER)23:23:26|3780C(AS)23:29:30|3771E(AS)23:39:43|3780C(IS)23:47:10|3771E(IS)23:47:13|
([stjamesvfd] ) 604:4602 E DOLPHIN DR OAK ISLAND, 13-061161, 23:12:35, Structure Fire (Smoke/Flames Visible)(Confirmed), ADV THE RESD IS ON FIRE..SMOKE IN THE RESD...
([stjamesvrs] ) 2057:13-060997, ST47(DS)13:39:09|4795(ER)13:52:03|ST47(IS)13:52:03|4795(AS)13:58:50|4795(IS)13:59:05|
([stjamesvrs] ) 2056:2810 BROWN RD SE BOLIVIA, MDL 31D03, 13-060997, 13:39:09, Unconscious-Fainting (Near),
([stjamesvfd] ) 603:13-060741, ST37(DS)18:22:11|3780C(ER)18:24:20|ST37(IS)18:24:20|3780C(AS)18:28:06|3772E(ER)18:31:39|3772E(AS)18:36:30|3772E(IS)18:44:47|3780C(IS)18:46:56|

*/

public class NCBrunswickCountyParserTest extends BaseParserTest {
  
  public NCBrunswickCountyParserTest() {
    setParser(new NCBrunswickCountyParser(), "BRUNSWICK COUNTY", "NC");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "1333 SOUTH DICKINSON DR LELAND 11-053813 10:30:06 Take Written Report (10-92) AT SUITE 110....10-83 WITH MIRANDA REF PROPERTY DAMAGE TO VEH",
        "ADDR:1333 SOUTH DICKINSON DR",
        "CITY:LELAND",
        "ID:11-053813",
        "TIME:10:30:06",
        "INFO:Take Written Report (10-92) AT SUITE 110....10-83 WITH MIRANDA REF PROPERTY DAMAGE TO VEH");

    doTest("T2",
        "1111 NEW POINTE BLVD LELAND 11-053827 11:42:05 911 HANG UP ON CALL BACK SPOKE W/ LAURA ADVD SUBJS SHE WAS CALLING IN REF TO LEFT THE BUSN",
        "ADDR:1111 NEW POINTE BLVD",
        "CITY:LELAND",
        "ID:11-053827",
        "TIME:11:42:05",
        "INFO:911 HANG UP ON CALL BACK SPOKE W/ LAURA ADVD SUBJS SHE WAS CALLING IN REF TO LEFT THE BUSN");
   
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "2192:BRUNSWICK COVE NURSING HOME 1478 RIVER RD SE WINNABOW 11-062488 19:38:00 Falls",
        "PLACE:BRUNSWICK COVE NURSING HOME",
        "ADDR:1478 RIVER RD SE",
        "CITY:WINNABOW",
        "ID:11-062488",
        "TIME:19:38:00",
        "CALL:Falls");
  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "1051:MT PISGAH BAPTIST CHURCH 494 MT PISGAH RD SW SUPPLY 11-085300 18:43:59 Brush Fire ON THE RIGHT IF GOING TOWARDS HOLDEN BEACH RD JUST PASSED MT PISGAH CHURCH ... ADVD SMALL FIRE IN T",
        "PLACE:MT PISGAH BAPTIST CHURCH",
        "ADDR:494 MT PISGAH RD SW",
        "CITY:SUPPLY",
        "ID:11-085300",
        "TIME:18:43:59",
        "INFO:Brush Fire ON THE RIGHT IF GOING TOWARDS HOLDEN BEACH RD JUST PASSED MT PISGAH CHURCH ... ADVD SMALL FIRE IN T");

  }
  
  @Test
  public void testJoeJenkins() {

    doTest("T1",
        "sentto-81008140-155-1334858821-9109162452=vtext.com@returns.groups.yahoo.com ([northwestvfd] ) 812:9035 DALES HAVEN RD NE NORTHWEST MDL 17B03-G 12-029328 14:02:41 Falls MEDICAL ALA",
        "SRC:northwestvfd",
        "ADDR:9035 DALES HAVEN RD NE",
        "CITY:NORTHWEST",
        "CODE:17B03-G",
        "ID:12-029328",
        "TIME:14:02:41",
        "CALL:Falls MEDICAL ALA");

    doTest("T2",
        "sentto-81008140-157-1334863333-9109162452=vtext.com@returns.groups.yahoo.com ([northwestvfd] ) 814:6598 NEW GROUND TR NE NORTHWEST MDL 26C02 12-029355 15:17:43 Sick Person (Specifi",
        "SRC:northwestvfd",
        "ADDR:6598 NEW GROUND TR NE",
        "CITY:NORTHWEST",
        "CODE:26C02",
        "ID:12-029355",
        "TIME:15:17:43",
        "CALL:Sick Person (Specifi");
    
  }
  
  @Test
  public void testLukeDuke() {

    doTest("T1",
        "([civietownvfd] )\n1644:375 HIGH HILL DR SW SHALLOTTE 12-030794 18:13:00 Traffic-Transportation Incident",
        "SRC:civietownvfd",
        "ADDR:375 HIGH HILL DR SW",
        "CITY:SHALLOTTE",
        "ID:12-030794",
        "TIME:18:13:00",
        "INFO:Traffic-Transportation Incident");

  }
  
  @Test
  public void testDanielMcCarthy() {

    doTest("T1",
        "S:[calabashvems]  M:7045:998 WATERVIEW LN CAROLINA SHORES 12-034031 17:20:33 Sick Person (Specific Diagnosis) 2 YOM SICK AND THROWING UP FOR 5 DAYS\n",
        "SRC:calabashvems",
        "ADDR:998 WATERVIEW LN",
        "CITY:CAROLINA SHORES",
        "ID:12-034031",
        "TIME:17:20:33",
        "INFO:Sick Person (Specific Diagnosis) 2 YOM SICK AND THROWING UP FOR 5 DAYS");
  }
  
  @Test
  public void testKeithRichardson() {

    doTest("T1",
        "sentto-81052485-2179-1340294796-8439951185= vtext.com@returns.groups.yahoo.com ([calabashvems]) 7678:204 AZALEA CIR SUNSET BEACH 12-048247 12:04:31 Breathing Problems BREATHING PROB",
        "SRC:calabashvems",
        "ADDR:204 AZALEA CIR",
        "CITY:SUNSET BEACH",
        "ID:12-048247",
        "TIME:12:04:31",
        "INFO:Breathing Problems BREATHING PROB");
    
  } 
  
  @Test
  public void testBrianCampbell() {

    doTest("T1",
        "Subject:[sunsetbeachfd] \n3287:424 EGRET DR SUNSET BEACH, MDL 17D02, 12-077164, 13:36:06, Falls, CALLER ADV NEIGHBOR HAS FALLEN\r",
        "SRC:sunsetbeachfd",
        "ADDR:424 EGRET DR",
        "CITY:SUNSET BEACH",
        "CODE:17D02",
        "ID:12-077164",
        "TIME:13:36:06",
        "CALL:Falls",
        "INFO:CALLER ADV NEIGHBOR HAS FALLEN");

    doTest("T1",
        "Subject:[sunsetbeachfd] \n" +
        "3291:413 WATER OAK WYND SW SUNSET BEACH, MDL 23B01-I, 12-077314, 21:32:48, Overdose-Poisoning (Ingestion), WI\r",

        "SRC:sunsetbeachfd",
        "ADDR:413 WATER OAK WYND SW",
        "CITY:SUNSET BEACH",
        "CODE:23B01-I",
        "ID:12-077314",
        "TIME:21:32:48",
        "CALL:Overdose-Poisoning (Ingestion)",
        "INFO:WI");

  }
  
  @Test
  public void testMark() {

    doTest("T1",
        "9333:OLD GEORGETOWN RD SW / OCEAN ISLE BEACH RD SW, MDL 29B04, 12-077625, 23:38:01, Traffic-Transportation Incidents, GEORGETOWN TOWARD 904 ....BLK MOTORCYCLE",
        "ADDR:OLD GEORGETOWN RD SW & OCEAN ISLE BEACH RD SW",
        "CODE:29B04",
        "ID:12-077625",
        "TIME:23:38:01",
        "CALL:Traffic-Transportation Incidents",
        "INFO:GEORGETOWN TOWARD 904 ....BLK MOTORCYCLE");

  }
  
  @Test
  public void testDafarrisinbsl() {

    doTest("T1",
        "FRM:pagegate@brunswickes.com\n" +
        "SUBJ:[bslvfd]\n" +
        "MSG:2534:1171 SOUTH SHORE DR BOILING SPRING LAKES, MDL 26O07, 12-077822, 17:05:49, Sick Person (Specific Diagnosis),",

        "SRC:bslvfd",
        "ADDR:1171 SOUTH SHORE DR",
        "CITY:BOILING SPRING LAKES",
        "CODE:26O07",
        "ID:12-077822",
        "TIME:17:05:49",
        "CALL:Sick Person (Specific Diagnosis)");
   
  }
  
  @Test
  public void testHeatherHeigl() {

    doTest("T1",
        "FRM:pagegate@brunswickes.com\nMSG:1553:8470 RIVER RD SE SOUTHPORT, MDL 10C01, 12-079416, 08:38:26, Chest Pain (Non-Traumatic),",
        "ADDR:8470 RIVER RD SE",
        "CITY:SOUTHPORT",
        "CODE:10C01",
        "ID:12-079416",
        "TIME:08:38:26",
        "CALL:Chest Pain (Non-Traumatic)");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:pagegate@brunswickes.com\n" +
        "MSG:1552:10181 STONEY BROOK CT SE LELAND, 12-079285, 17:22:53, Gas Leak-Spill-Odor, REF TO AN ODOR IN THE\n" +
        "(Con't) 2 of 2\n" +
        "RESIDENCE FROM A BURNT OUT LIGHT BULB(End)",

        "ADDR:10181 STONEY BROOK CT SE",
        "CITY:LELAND",
        "ID:12-079285",
        "TIME:17:22:53",
        "CALL:Gas Leak-Spill-Odor",
        "INFO:REF TO AN ODOR IN THE RESIDENCE FROM A BURNT OUT LIGHT BULB");

    doTest("T3",
        "FRM:pagegate@brunswickes.com\n" +
        "MSG:1551:UNION PRIMARY SCHOOL 180 UNION SCHOOL RD NW SHALLOTTE, 12-079246, 15:10:36, Gas Leak-Spill-Odor, BUS294",

        "PLACE:UNION PRIMARY SCHOOL",
        "ADDR:180 UNION SCHOOL RD NW",
        "CITY:SHALLOTTE",
        "ID:12-079246",
        "TIME:15:10:36",
        "CALL:Gas Leak-Spill-Odor",
        "INFO:BUS294");

    doTest("T4",
        " 1 of 2\n" +
        "FRM:pagegate@brunswickes.com\n" +
        "MSG:1550:3243 MARSH VIEW DR SW SUPPLY, 12-079235, 14:43:36, Lifting Assistance (Request By EMS), NEED\n" +
        "(Con't) 2 of 2\n" +
        "LIFTING ASSISTANCE REF BARRIATRIC PT.(End)",

        "ADDR:3243 MARSH VIEW DR SW",
        "CITY:SUPPLY",
        "ID:12-079235",
        "TIME:14:43:36",
        "CALL:Lifting Assistance (Request By EMS)",
        "INFO:NEED LIFTING ASSISTANCE REF BARRIATRIC PT.");

    doTest("T5",
        " 1 of 2\n" +
        "FRM:pagegate@brunswickes.com\n" +
        "MSG:1548:2975 SHELL POINT RD SW SHALLOTTE, 12-079174, 10:41:43, Cardiac or Respiratiory Arrest - Death, ADVD\n" +
        "(Con't) 2 of 2\n" +
        "THAT HE THINKS HE FOUND HIS CO-WORKER DEAD..(End)",

        "ADDR:2975 SHELL POINT RD SW",
        "CITY:SHALLOTTE",
        "ID:12-079174",
        "TIME:10:41:43",
        "CALL:Cardiac or Respiratiory Arrest - Death",
        "INFO:ADVD THAT HE THINKS HE FOUND HIS CO-WORKER DEAD..");
   
  }
  
  @Test
  public void testdsprather40() {

    doTest("T1",
        "sentto-80999237-3362-1362685070-3013992617=vtext.com@returns.groups.yahoo.com ([calabashvfd]) 6354:7114 OLD GEORGETOWN RD SW OCEAN ISLE BEACH, 13-018209, 14:37:23, Structure Fire (",
        "SRC:calabashvfd",
        "ADDR:7114 OLD GEORGETOWN RD SW",
        "CITY:OCEAN ISLE BEACH",
        "ID:13-018209",
        "TIME:14:37:23",
        "CALL:Structure Fire (");
 
  }
  
  @Test
  public void testBrunswickCountyFireMarshal() {

    doTest("T1",
        "(27 PAISLEY DR APT 103 SHALLOTTE, MDL 09E01, 13-001668, 06) 7:34:58, Cardiac or Respiratiory Arrest - Death, HUSBAND LAYING ON THE BED WITH HIS EYES IN THE BACK ON HIS HEAD....",
        "ADDR:27 PAISLEY DR",
        "APT:103",
        "CITY:SHALLOTTE",
        "CODE:09E01",
        "ID:13-001668",
        "TIME:06:34:58",
        "CALL:Cardiac or Respiratiory Arrest - Death",
        "INFO:HUSBAND LAYING ON THE BED WITH HIS EYES IN THE BACK ON HIS HEAD....");

    doTest("T2",
        "(5073 GLEN COVE DR OAK ISLAND, 13-001658, 04) 6:25:23, Structure Fire (Smoke/Flames Visible)(Confirmed), FIRE ALARM ACTIVATED AND THERE IS SMOKE IN THE RESD....ADVD CALLER TO GET EVERYONE OUT OF THE RESD",
        "ADDR:5073 GLEN COVE DR",
        "CITY:OAK ISLAND",
        "ID:13-001658",
        "TIME:04:25:23",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)",
        "INFO:FIRE ALARM ACTIVATED AND THERE IS SMOKE IN THE RESD....ADVD CALLER TO GET EVERYONE OUT OF THE RESD");

    doTest("T3",
        "(3500 MACO RD NE LELAND, MDL 17D02, 13-001446, 05) 5:20:29, Falls,",
        "ADDR:3500 MACO RD NE",
        "CITY:LELAND",
        "CODE:17D02",
        "ID:13-001446",
        "TIME:05:20:29",
        "CALL:Falls");

    doTest("T4",
        "(OLD FAYETTEVILLE RD NE / SUNNY TR NE LELAND, 13-001245, 14) 2:14:16, Structure Fire (Smoke/Flames Visible)(Confirmed), 3 BIG SHEDS ON FIRE BEHIND A HOUSE",
        "ADDR:OLD FAYETTEVILLE RD NE & SUNNY TR NE",
        "CITY:LELAND",
        "ID:13-001245",
        "TIME:14:14:16",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)",
        "INFO:3 BIG SHEDS ON FIRE BEHIND A HOUSE");

    doTest("T5",
        "(3325 OLD OCEAN HWY BOLIVIA, 13-000946, 15) 1:27:41, Test Call (Training-Maint.), TESTING SMTP PAGING SCHEME\r\n",
        "ADDR:3325 OLD OCEAN HWY",
        "CITY:BOLIVIA",
        "ID:13-000946",
        "TIME:15:27:41",
        "CALL:Test Call (Training-Maint.)",
        "INFO:TESTING SMTP PAGING SCHEME");

    doTest("T6",
        "(2424 BELSHAW DR LELAND, MDL 09E01, 13-006044, 17) 70:42:13, Cardiac or Respiratiory Arrest - Death,\r\n",
        "ADDR:2424 BELSHAW DR",
        "CITY:LELAND",
        "CODE:09E01",
        "ID:13-006044",
        "TIME:17:42:13",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T7",
        "(7177 BONAVENTURE ST SW OCEAN ISLE BEACH, MDL 28C01-I, 13-005347, 08) 62:18:39, Cardiac or Respiratiory Arrest - Death,\r\n",
        "ADDR:7177 BONAVENTURE ST SW",
        "CITY:OCEAN ISLE BEACH",
        "CODE:28C01-I",
        "ID:13-005347",
        "TIME:08:18:39",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T8",
        "(3155 MT MISERY RD NE LELAND, MDL 27B02-S, 13-005234, 19) 57:54:50, Stab-Gunshot-Penetrating Trauma,\r\n",
        "ADDR:3155 MT MISERY RD NE",
        "CITY:LELAND",
        "CODE:27B02-S",
        "ID:13-005234",
        "TIME:19:54:50",
        "CALL:Stab-Gunshot-Penetrating Trauma");

    doTest("T9",
        "(5130 MELINDA CT OAK ISLAND, MDL 09E01, 13-004813, 11) 49:09:58, Cardiac or Respiratiory Arrest - Death,\r\n",
        "ADDR:5130 MELINDA CT",
        "CITY:OAK ISLAND",
        "CODE:09E01",
        "ID:13-004813",
        "TIME:11:09:58",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T10",
        "(38 BROOKS CT 205 SHALLOTTE, MDL 09E01, 13-004743, 01) 47:31:35, Cardiac or Respiratiory Arrest - Death,\r\n",
        "ADDR:38 BROOKS CT 205",
        "CITY:SHALLOTTE",
        "CODE:09E01",
        "ID:13-004743",
        "TIME:01:31:35",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T11",
        "(400 N MULBERRY RD SHALLOTTE, MDL 29D02-m, 13-004099, 20) 34:05:47, Traffic-Transportation Incidents,\r\n",
        "ADDR:400 N MULBERRY RD",
        "CITY:SHALLOTTE",
        "CODE:29D02-m",
        "ID:13-004099",
        "TIME:20:05:47",
        "CALL:Traffic-Transportation Incidents");
  
  }
  
  @Test
  public void testStJamesFD() {

    doTest("T1",
        "([stjamesvrs] ) 2125:13-068360, ST47(DS)15:49:25|4795(ER)15:55:06|ST47(IS)15:55:06|4795(AS)15:58:56|4795(TR)16:03:20|4795(DEST)16:26:56|4795(IS)16:34:28|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-068360",
        "PLACE:ST47(DS)15:49:25|4795(ER)15:55:06|ST47(IS)15:55:06|4795(AS)15:58:56|4795(TR)16:03:20|4795(DEST)16:26:56|4795(IS)16:34:28|");

    doTest("T2",
        "([stjamesvrs] ) 2124:3269 WILD AZALEA WAY ST JAMES, MDL 26O05, 13-068360, 15:49:25, Sick Person (Specific Diagnosis),",
        "SRC:stjamesvrs",
        "ADDR:3269 WILD AZALEA WAY",
        "CITY:ST JAMES",
        "CODE:26O05",
        "ID:13-068360",
        "TIME:15:49:25",
        "CALL:Sick Person (Specific Diagnosis)");

    doTest("T3",
        "([stjamesvrs] ) 2123:13-068295, ST47(DS)11:43:27|4795(ER)11:44:58|ST47(IS)11:44:58|4795(AS)11:47:57|4795(TR)11:58:36|4795(DEST)12:14:20|4795(IS)12:22:49|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-068295",
        "PLACE:ST47(DS)11:43:27|4795(ER)11:44:58|ST47(IS)11:44:58|4795(AS)11:47:57|4795(TR)11:58:36|4795(DEST)12:14:20|4795(IS)12:22:49|");

    doTest("T4",
        "([stjamesvrs] ) 2122:3582 RUDDY DUCK WYND ST JAMES, MDL 02D01, 13-068295, 11:43:27, Allergies (Reactions) - Envenomations (Stings Bite, POSSIBLE REACTION TO MEDICATIONS",
        "SRC:stjamesvrs",
        "ADDR:3582 RUDDY DUCK WYND",
        "CITY:ST JAMES",
        "CODE:02D01",
        "ID:13-068295",
        "TIME:11:43:27",
        "CALL:Allergies (Reactions) - Envenomations (Stings Bite",
        "INFO:POSSIBLE REACTION TO MEDICATIONS");

    doTest("T5",
        "([stjamesvfd] ) 632:13-067969, ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|3780C(DS)12:59:03|3780C(AS)12:59:06|3780C(IS)13:00:25|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-067969",
        "PLACE:ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|3780C(DS)12:59:03|3780C(AS)12:59:06|3780C(IS)13:00:25|");

    doTest("T6",
        "([stjamesvfd] ) 631:13-067969, ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-067969",
        "PLACE:ST37(DS)12:50:43|3780C(ER)12:51:47|ST37(IS)12:51:47|3780C(IS)12:57:33|");

    doTest("T7",
        "([stjamesvrs] ) 2121:13-067969, ST47(DS)12:50:43|4795(ER)12:55:47|ST47(IS)12:55:47|4795(IS)12:55:50|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067969",
        "PLACE:ST47(DS)12:50:43|4795(ER)12:55:47|ST47(IS)12:55:47|4795(IS)12:55:50|");

    doTest("T8",
        "([stjamesvfd] ) 630:SOUTHPORT-SUPPLY RD SE / ST JAMES DR ST JAMES, MDL 29B04-U, 13-067969, 12:50:43, Traffic-Transportation Incidents, CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT",
        "SRC:stjamesvfd",
        "ADDR:SOUTHPORT-SUPPLY RD SE & ST JAMES DR",
        "CITY:ST JAMES",
        "CODE:29B04-U",
        "ID:13-067969",
        "TIME:12:50:43",
        "CALL:Traffic-Transportation Incidents",
        "INFO:CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT");

    doTest("T9",
        "([stjamesvrs] ) 2120:SOUTHPORT-SUPPLY RD SE / ST JAMES DR ST JAMES, MDL 29B04-U, 13-067969, 12:50:43, Traffic-Transportation Incidents, CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT",
        "SRC:stjamesvrs",
        "ADDR:SOUTHPORT-SUPPLY RD SE & ST JAMES DR",
        "CITY:ST JAMES",
        "CODE:29B04-U",
        "ID:13-067969",
        "TIME:12:50:43",
        "CALL:Traffic-Transportation Incidents",
        "INFO:CREAM COLORED SEDAN IN DITCH.... DID NOT SEE ANYONE OUTSIDE OF VEHICLE... CALLER DRIVING BY DID NOT");

    doTest("T10",
        "([stjamesvrs] ) 2119:13-067860, ST47(DS)03:44:30|4795(ER)03:54:43|ST47(IS)03:54:43|4795(IS)03:58:48|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067860",
        "PLACE:ST47(DS)03:44:30|4795(ER)03:54:43|ST47(IS)03:54:43|4795(IS)03:58:48|");

    doTest("T11",
        "([stjamesvrs] ) 2118:3921 PEPPERBERRY LN SE SOUTHPORT, MDL 17B03-G, 13-067860, 03:44:30, Falls, FROMMATER RESD... PT HAS FALLEN IN THE BATHROOM...HAS PT ON THE PHONE BUT PT CANT HEAR HER..RECD 336",
        "SRC:stjamesvrs",
        "ADDR:3921 PEPPERBERRY LN SE",
        "CITY:SOUTHPORT",
        "CODE:17B03-G",
        "ID:13-067860",
        "TIME:03:44:30",
        "CALL:Falls",
        "INFO:FROMMATER RESD... PT HAS FALLEN IN THE BATHROOM...HAS PT ON THE PHONE BUT PT CANT HEAR HER..RECD 336");

    doTest("T12",
        "([stjamesvrs] ) 2117:13-067699, ST47(DS)17:47:05|4795(ER)17:51:53|ST47(IS)17:51:53|4795(AS)17:57:24|4795(IS)18:15:02|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067699",
        "PLACE:ST47(DS)17:47:05|4795(ER)17:51:53|ST47(IS)17:51:53|4795(AS)17:57:24|4795(IS)18:15:02|");

    doTest("T13",
        "([stjamesvrs] ) 2116:3939 HARMONY CIR SE SOUTHPORT, MDL 17B03-G, 13-067699, 17:47:05, Falls,",
        "SRC:stjamesvrs",
        "ADDR:3939 HARMONY CIR SE",
        "CITY:SOUTHPORT",
        "CODE:17B03-G",
        "ID:13-067699",
        "TIME:17:47:05",
        "CALL:Falls");

    doTest("T14",
        "([stjamesvrs] ) 2115:13-067606, ST47(DS)13:51:40|4795(ER)13:56:27|ST47(IS)13:56:27|4795(AS)14:06:32|4795(TR)14:39:31|4795(DEST)14:54:02|4795(IS)15:00:52|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067606",
        "PLACE:ST47(DS)13:51:40|4795(ER)13:56:27|ST47(IS)13:56:27|4795(AS)14:06:32|4795(TR)14:39:31|4795(DEST)14:54:02|4795(IS)15:00:52|");

    doTest("T15",
        "([stjamesvrs] ) 2114:MIDWAY RD SE / GREEN LEWIS RD SE BOLIVIA, MDL 25B03, 13-067606, 13:51:40, Psychiatric-Abnormal Behavior- Suicide Attempt, COMP DAUGHTER KEEPS CALLING ADVD THERE IS A DISTURBANCE ...WANTS LEO TO MEET HER ...10-12 GRAY PONTI",
        "SRC:stjamesvrs",
        "ADDR:MIDWAY RD SE & GREEN LEWIS RD SE",
        "CITY:BOLIVIA",
        "CODE:25B03",
        "ID:13-067606",
        "TIME:13:51:40",
        "CALL:Psychiatric-Abnormal Behavior- Suicide Attempt",
        "INFO:COMP DAUGHTER KEEPS CALLING ADVD THERE IS A DISTURBANCE ...WANTS LEO TO MEET HER ...10-12 GRAY PONTI");

    doTest("T16",
        "([stjamesvrs] ) 2113:13-067535, ST47(DS)09:44:49|4795(ER)09:47:11|ST47(IS)09:47:11|4795(AS)09:54:21|4795(TR)10:14:21|4795(DEST)10:26:58|4795(IS)10:50:30|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067535",
        "PLACE:ST47(DS)09:44:49|4795(ER)09:47:11|ST47(IS)09:47:11|4795(AS)09:54:21|4795(TR)10:14:21|4795(DEST)10:26:58|4795(IS)10:50:30|");

    doTest("T17",
        "([stjamesvrs] ) 2112:4021 BRICK PATH LN SE SOUTHPORT, MDL 13A01, 13-067535, 09:44:49, Diabetic Problems, MOTHER IS DIABETIC CANT GET READING AND WEAK",
        "SRC:stjamesvrs",
        "ADDR:4021 BRICK PATH LN SE",
        "CITY:SOUTHPORT",
        "CODE:13A01",
        "ID:13-067535",
        "TIME:09:44:49",
        "CALL:Diabetic Problems",
        "INFO:MOTHER IS DIABETIC CANT GET READING AND WEAK");

    doTest("T18",
        "([stjamesvfd] ) 629:13-067432, ST37(DS)23:21:26|3780C(ER)23:24:26|ST37(IS)23:24:26|3771E(DS)23:30:53|3771E(ER)23:30:56|3780C(IS)23:33:18|3771E(IS)23:33:20|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-067432",
        "PLACE:ST37(DS)23:21:26|3780C(ER)23:24:26|ST37(IS)23:24:26|3771E(DS)23:30:53|3771E(ER)23:30:56|3780C(IS)23:33:18|3771E(IS)23:33:20|");

    doTest("T19",
        "([stjamesvfd] ) 628:4020 E DOLPHIN DR OAK ISLAND, 13-067432, 23:21:26, Structure Fire (Smoke/Flames Visible)(Confirmed),",
        "SRC:stjamesvfd",
        "ADDR:4020 E DOLPHIN DR",
        "CITY:OAK ISLAND",
        "ID:13-067432",
        "TIME:23:21:26",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)");

    doTest("T20",
        "([stjamesvrs] ) 2111:13-067283, ST47(DS)15:23:58|4795(ER)15:27:23|ST47(IS)15:27:23|4795(AS)15:31:08|4795(IS)15:47:04|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-067283",
        "PLACE:ST47(DS)15:23:58|4795(ER)15:27:23|ST47(IS)15:27:23|4795(AS)15:31:08|4795(IS)15:47:04|");

    doTest("T21",
        "([stjamesvrs] ) 2110:3851 MEMBERS CLUB BLVD ST JAMES, MDL 19D04, 13-067283, 15:23:58, Heart Problems - A.I.C.D.,",
        "SRC:stjamesvrs",
        "ADDR:3851 MEMBERS CLUB BLVD",
        "CITY:ST JAMES",
        "CODE:19D04",
        "ID:13-067283",
        "TIME:15:23:58",
        "CALL:Heart Problems - A.I.C.D.");

    doTest("T22",
        "([stjamesvfd] ) 627:13-067146, ST37(DS)04:54:44|3780C(ER)04:58:38|ST37(IS)04:58:38|3771E(ER)05:05:18|3771E(IS)05:10:39|3780C(AS)05:10:41|3780C(IS)05:15:34|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-067146",
        "PLACE:ST37(DS)04:54:44|3780C(ER)04:58:38|ST37(IS)04:58:38|3771E(ER)05:05:18|3771E(IS)05:10:39|3780C(AS)05:10:41|3780C(IS)05:15:34|");

    doTest("T23",
        "([stjamesvfd] ) 626:CHASERS SPORTS BAR & GRILL 8520 E OAK ISLAND DR OAK ISLAND, 13-067146, 04:54:44, Structure Fire (Smoke/Flames Visible)(Confirmed), IS ON FIRE..",
        "SRC:stjamesvfd",
        "PLACE:CHASERS SPORTS BAR & GRILL",
        "ADDR:8520 E OAK ISLAND DR",
        "CITY:OAK ISLAND",
        "ID:13-067146",
        "TIME:04:54:44",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)",
        "INFO:IS ON FIRE..");

    doTest("T24",
        "([stjamesvfd] ) 625:13-067022, ST37(DS)19:45:26|3780C(ER)19:50:58|ST37(IS)19:50:58|3771E(ER)19:58:47|3780C(AS)19:59:59|3777B(AS)20:02:35|3771E(ER2)20:02:48|3771E(AS2)20:04:45|3771E(IS)20:38:47|3777B(IS)20:51:42|3780C(IS)20:51:44|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-067022",
        "PLACE:ST37(DS)19:45:26|3780C(ER)19:50:58|ST37(IS)19:50:58|3771E(ER)19:58:47|3780C(AS)19:59:59|3777B(AS)20:02:35|3771E(ER2)20:02:48|3771E(AS2)20:04:45|3771E(IS)20:38:47|3777B(IS)20:51:42|3780C(IS)20:51:44|");

    doTest("T25",
        "([stjamesvfd] ) 624:4388 SEA PINES DR SE SOUTHPORT, 13-067022, 19:45:26, Woods Fire, CALLER ADV OF SEEING A LARGE PLUM OF SMOKE SAME IS NOT COMING FROM ST JAMES BUT BACK TOWARDS THE AIR",
        "SRC:stjamesvfd",
        "ADDR:4388 SEA PINES DR SE",
        "CITY:SOUTHPORT",
        "ID:13-067022",
        "TIME:19:45:26",
        "CALL:Woods Fire",
        "INFO:CALLER ADV OF SEEING A LARGE PLUM OF SMOKE SAME IS NOT COMING FROM ST JAMES BUT BACK TOWARDS THE AIR");

    doTest("T26",
        "([stjamesvrs] ) 2109:13-066955, ST47(DS)16:49:03|4795(ER)16:49:50|ST47(IS)16:49:50|4795(IS)16:59:57|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066955",
        "PLACE:ST47(DS)16:49:03|4795(ER)16:49:50|ST47(IS)16:49:50|4795(IS)16:59:57|");

    doTest("T27",
        "([stjamesvrs] ) 2108:2810 BROWN RD SE BOLIVIA, MDL 19D04, 13-066955, 16:49:03, Heart Problems - A.I.C.D.,",
        "SRC:stjamesvrs",
        "ADDR:2810 BROWN RD SE",
        "CITY:BOLIVIA",
        "CODE:19D04",
        "ID:13-066955",
        "TIME:16:49:03",
        "CALL:Heart Problems - A.I.C.D.");

    doTest("T28",
        "([stjamesvrs] ) 2107:13-066943, ST47(DS)16:12:02|4795(ER)16:15:47|ST47(IS)16:15:47|4795(AS)16:20:02|4795(IS)16:41:38|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066943",
        "PLACE:ST47(DS)16:12:02|4795(ER)16:15:47|ST47(IS)16:15:47|4795(AS)16:20:02|4795(IS)16:41:38|");

    doTest("T29",
        "([stjamesvrs] ) 2106:3234 EAST LAGOON CT ST JAMES, MDL 31D03, 13-066943, 16:12:02, Unconscious-Fainting (Near),",
        "SRC:stjamesvrs",
        "ADDR:3234 EAST LAGOON CT",
        "CITY:ST JAMES",
        "CODE:31D03",
        "ID:13-066943",
        "TIME:16:12:02",
        "CALL:Unconscious-Fainting (Near)");

    doTest("T30",
        "([stjamesvrs] ) 2105:13-066819, ST47(DS)08:26:55|4795(ER)08:28:38|ST47(IS)08:28:38|4795(AS)08:41:59|4795(IS)09:04:03|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066819",
        "PLACE:ST47(DS)08:26:55|4795(ER)08:28:38|ST47(IS)08:28:38|4795(AS)08:41:59|4795(IS)09:04:03|");

    doTest("T31",
        "([stjamesvrs] ) 2104:904 GREEN LEWIS RD SE BOLIVIA, MDL 31D03, 13-066819, 08:26:55, Unconscious-Fainting (Near),",
        "SRC:stjamesvrs",
        "ADDR:904 GREEN LEWIS RD SE",
        "CITY:BOLIVIA",
        "CODE:31D03",
        "ID:13-066819",
        "TIME:08:26:55",
        "CALL:Unconscious-Fainting (Near)");

    doTest("T32",
        "([stjamesvrs] ) 2103:13-066813, ST47(DS)08:06:26|4795(ER)08:13:41|ST47(IS)08:13:41|4795(IS)08:14:32|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066813",
        "PLACE:ST47(DS)08:06:26|4795(ER)08:13:41|ST47(IS)08:13:41|4795(IS)08:14:32|");

    doTest("T33",
        "([stjamesvrs] ) 2102:780 MCKAY RD SE BOLIVIA, MDL 09B01-a, 13-066813, 08:06:26, Cardiac or Respiratiory Arrest - Death,",
        "SRC:stjamesvrs",
        "ADDR:780 MCKAY RD SE",
        "CITY:BOLIVIA",
        "CODE:09B01-a",
        "ID:13-066813",
        "TIME:08:06:26",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T34",
        "([stjamesvfd] ) 623:13-066604, ST37(DS)14:23:59|3780C(ER)14:25:58|ST37(IS)14:25:58|3771E(DS)14:33:19|3771E(ER)14:33:22|3780C(IS)14:35:01|3771E(IS)14:35:14|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-066604",
        "PLACE:ST37(DS)14:23:59|3780C(ER)14:25:58|ST37(IS)14:25:58|3771E(DS)14:33:19|3771E(ER)14:33:22|3780C(IS)14:35:01|3771E(IS)14:35:14|");

    doTest("T35",
        "([stjamesvfd] ) 622:4207 E OAK ISLAND DR OAK ISLAND, 13-066604, 14:23:59, Structure Fire (Reported), ADVD WATER HEATER CAUGHT ON FIRE, FIRE IS OUT NOW BUT REQ FIRE DEPT CHECK SAME BECAUSE THIS RESD IS",
        "SRC:stjamesvfd",
        "ADDR:4207 E OAK ISLAND DR",
        "CITY:OAK ISLAND",
        "ID:13-066604",
        "TIME:14:23:59",
        "CALL:Structure Fire (Reported)",
        "INFO:ADVD WATER HEATER CAUGHT ON FIRE / FIRE IS OUT NOW BUT REQ FIRE DEPT CHECK SAME BECAUSE THIS RESD IS");

    doTest("T36",
        "([stjamesvrs] ) 2101:13-066475, ST47(DS)04:36:21|4795(ER)04:46:48|ST47(IS)04:46:48|4795(AS)04:50:23|4795(IS)05:00:27|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066475",
        "PLACE:ST47(DS)04:36:21|4795(ER)04:46:48|ST47(IS)04:46:48|4795(AS)04:50:23|4795(IS)05:00:27|");

    doTest("T37",
        "([stjamesvrs] ) 2100:4176 SKEFFINGTON CT ST JAMES, MDL 17B03, 13-066475, 04:36:21, Falls, WIFE IS INVALID",
        "SRC:stjamesvrs",
        "ADDR:4176 SKEFFINGTON CT",
        "CITY:ST JAMES",
        "CODE:17B03",
        "ID:13-066475",
        "TIME:04:36:21",
        "CALL:Falls",
        "INFO:WIFE IS INVALID");

    doTest("T38",
        "([stjamesvrs] ) 2099:13-066169, ST47(DS)09:24:47|4795(ER)09:28:55|ST47(IS)09:28:56|4795(AS)09:33:25|4795(IS)09:48:32|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066169",
        "PLACE:ST47(DS)09:24:47|4795(ER)09:28:55|ST47(IS)09:28:56|4795(AS)09:33:25|4795(IS)09:48:32|");

    doTest("T39",
        "([stjamesvrs] ) 2098:4176 SKEFFINGTON CT ST JAMES, MDL 26A01, 13-066169, 09:24:47, Sick Person (Specific Diagnosis),",
        "SRC:stjamesvrs",
        "ADDR:4176 SKEFFINGTON CT",
        "CITY:ST JAMES",
        "CODE:26A01",
        "ID:13-066169",
        "TIME:09:24:47",
        "CALL:Sick Person (Specific Diagnosis)");

    doTest("T40",
        "([stjamesvrs] ) 2097:13-066131, ST47(DS)04:37:14|4795(ER)04:45:35|ST47(IS)04:45:35|4795(IS)04:47:47|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066131",
        "PLACE:ST47(DS)04:37:14|4795(ER)04:45:35|ST47(IS)04:45:35|4795(IS)04:47:47|");

    doTest("T41",
        "([stjamesvrs] ) 2096:4176 SKEFFINGTON CT ST JAMES, MDL 26A01, 13-066131, 04:37:14, Sick Person (Specific Diagnosis), REF TO ASSISTING HIS WIFE TO GO TO THE BATHROOM...ADV SHE CANT WALK... FEMALE HAD CANCER...",
        "SRC:stjamesvrs",
        "ADDR:4176 SKEFFINGTON CT",
        "CITY:ST JAMES",
        "CODE:26A01",
        "ID:13-066131",
        "TIME:04:37:14",
        "CALL:Sick Person (Specific Diagnosis)",
        "INFO:REF TO ASSISTING HIS WIFE TO GO TO THE BATHROOM...ADV SHE CANT WALK... FEMALE HAD CANCER...");

    doTest("T42",
        "([stjamesvrs] ) 2095:13-066000, ST47(DS)18:45:47|4795(ER)18:52:20|ST47(IS)18:52:20|4795(AS)19:07:57|4795(TR)19:23:15|4795(DEST)19:55:38|4795(IS)20:13:03|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-066000",
        "PLACE:ST47(DS)18:45:47|4795(ER)18:52:20|ST47(IS)18:52:20|4795(AS)19:07:57|4795(TR)19:23:15|4795(DEST)19:55:38|4795(IS)20:13:03|");

    doTest("T43",
        "([stjamesvrs] ) 2094:3692 LAW RD SE BOLIVIA, MDL 17A02, 13-066000, 18:45:47, Falls,",
        "SRC:stjamesvrs",
        "ADDR:3692 LAW RD SE",
        "CITY:BOLIVIA",
        "CODE:17A02",
        "ID:13-066000",
        "TIME:18:45:47",
        "CALL:Falls");

    doTest("T44",
        "([stjamesvfd] ) 621:13-065985, ST37(DS)17:54:45|ST37(IS)18:05:01|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-065985",
        "PLACE:ST37(DS)17:54:45|ST37(IS)18:05:01|");

    doTest("T45",
        "([stjamesvfd] ) 620:5204 E BEACH DR OAK ISLAND, 13-065985, 17:54:46, Structure Fire (Smoke/Flames Visible)(Confirmed), A/C REPAIR MAN IS WORKING ON A/C UNIT AND SMELL SMOKE",
        "SRC:stjamesvfd",
        "ADDR:5204 E BEACH DR",
        "CITY:OAK ISLAND",
        "ID:13-065985",
        "TIME:17:54:46",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)",
        "INFO:A/C REPAIR MAN IS WORKING ON A/C UNIT AND SMELL SMOKE");

    doTest("T46",
        "([stjamesvrs] ) 2093:13-065900, ST47(DS)12:41:21|4795(ER)12:48:15|ST47(IS)12:48:15|4795(IS)12:49:04|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065900",
        "PLACE:ST47(DS)12:41:21|4795(ER)12:48:15|ST47(IS)12:48:15|4795(IS)12:49:04|");

    doTest("T47",
        "([stjamesvrs] ) 2092:2988 BROWN RD SE BOLIVIA, MDL 31D03, 13-065900, 12:41:21, Unconscious-Fainting (Near),",
        "SRC:stjamesvrs",
        "ADDR:2988 BROWN RD SE",
        "CITY:BOLIVIA",
        "CODE:31D03",
        "ID:13-065900",
        "TIME:12:41:21",
        "CALL:Unconscious-Fainting (Near)");

    doTest("T48",
        "([stjamesvrs] ) 2091:13-065814, ST47(DS)05:37:09|4795(ER)05:46:02|ST47(IS)05:46:02|4795(AS)05:50:49|4795(IS)05:57:30|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065814",
        "PLACE:ST47(DS)05:37:09|4795(ER)05:46:02|ST47(IS)05:46:02|4795(AS)05:50:49|4795(IS)05:57:30|");

    doTest("T49",
        "([stjamesvrs] ) 2090:3619 MEMBERS CLUB BLVD ST JAMES, MDL 01C06, 13-065814, 05:37:09, Abdominal Pains - Problems, WIFE HAS SMALL BOWEL CANCER AND IS IN EXTREME PAIN",
        "SRC:stjamesvrs",
        "ADDR:3619 MEMBERS CLUB BLVD",
        "CITY:ST JAMES",
        "CODE:01C06",
        "ID:13-065814",
        "TIME:05:37:09",
        "CALL:Abdominal Pains - Problems",
        "INFO:WIFE HAS SMALL BOWEL CANCER AND IS IN EXTREME PAIN");

    doTest("T50",
        "([stjamesvrs] ) 2089:13-065456, ST47(DS)07:08:15|4795(ER)07:14:48|ST47(IS)07:14:48|4795(IS)07:19:13|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065456",
        "PLACE:ST47(DS)07:08:15|4795(ER)07:14:48|ST47(IS)07:14:48|4795(IS)07:19:13|");

    doTest("T51",
        "([stjamesvrs] ) 2088:3660 WILLOW LAKE DR SE SOUTHPORT, MDL 26C01, 13-065456, 07:08:15, Sick Person (Specific Diagnosis),",
        "SRC:stjamesvrs",
        "ADDR:3660 WILLOW LAKE DR SE",
        "CITY:SOUTHPORT",
        "CODE:26C01",
        "ID:13-065456",
        "TIME:07:08:15",
        "CALL:Sick Person (Specific Diagnosis)");

    doTest("T52",
        "([stjamesvrs] ) 2087:13-065446, ST47(DS)04:57:24|4795(ER)05:06:49|ST47(IS)05:06:49|4795(AS)05:11:26|4795(IS)05:13:20|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065446",
        "PLACE:ST47(DS)04:57:24|4795(ER)05:06:49|ST47(IS)05:06:49|4795(AS)05:11:26|4795(IS)05:13:20|");

    doTest("T53",
        "([stjamesvrs] ) 2086:4176 SKEFFINGTON CT ST JAMES, MDL 17A03, 13-065446, 04:57:24, Falls, INVALID WIFE UNABLE TO WALK...NEEDS ASSISTANCE GETTING FROM BED TO BATHROOM",
        "SRC:stjamesvrs",
        "ADDR:4176 SKEFFINGTON CT",
        "CITY:ST JAMES",
        "CODE:17A03",
        "ID:13-065446",
        "TIME:04:57:24",
        "CALL:Falls",
        "INFO:INVALID WIFE UNABLE TO WALK...NEEDS ASSISTANCE GETTING FROM BED TO BATHROOM");

    doTest("T54",
        "([stjamesvfd] ) 619:13-065089, ST37(DS)07:03:31|3780C(ER)07:05:38|ST37(IS)07:05:38|3771E(DS)07:13:56|3771E(ER)07:14:00|3780C(IS)07:15:21|3771E(IS)07:15:24|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-065089",
        "PLACE:ST37(DS)07:03:31|3780C(ER)07:05:38|ST37(IS)07:05:38|3771E(DS)07:13:56|3771E(ER)07:14:00|3780C(IS)07:15:21|3771E(IS)07:15:24|");

    doTest("T55",
        "([stjamesvfd] ) 618:65 YAUPON WAY OAK ISLAND, 13-065089, 07:03:31, Structure Fire (Reported), TURNED ON LIGHT SWITCH IN HOUSE AND COULD SMELL AND SEE SMOKE IN THE RESIDENCE ..SAME OCCURED 10 MIN",
        "SRC:stjamesvfd",
        "ADDR:65 YAUPON WAY",
        "CITY:OAK ISLAND",
        "ID:13-065089",
        "TIME:07:03:31",
        "CALL:Structure Fire (Reported)",
        "INFO:TURNED ON LIGHT SWITCH IN HOUSE AND COULD SMELL AND SEE SMOKE IN THE RESIDENCE ..SAME OCCURED 10 MIN");

    doTest("T56",
        "([stjamesvrs] ) 2085:13-065078, ST47(DS)05:55:34|4795(ER)06:02:39|ST47(IS)06:02:39|4795(AS)06:06:07|4795(IS)06:11:52|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065078",
        "PLACE:ST47(DS)05:55:34|4795(ER)06:02:39|ST47(IS)06:02:39|4795(AS)06:06:07|4795(IS)06:11:52|");

    doTest("T57",
        "([stjamesvrs] ) 2084:3269 WILD AZALEA WAY ST JAMES, MDL 10D04, 13-065078, 05:55:34, Chest Pain (Non-Traumatic),",
        "SRC:stjamesvrs",
        "ADDR:3269 WILD AZALEA WAY",
        "CITY:ST JAMES",
        "CODE:10D04",
        "ID:13-065078",
        "TIME:05:55:34",
        "CALL:Chest Pain (Non-Traumatic)");

    doTest("T58",
        "([stjamesvrs] ) 2083:13-065069, ST47(DS)04:00:43|ST47(IS)04:10:24|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-065069",
        "PLACE:ST47(DS)04:00:43|ST47(IS)04:10:24|");

    doTest("T59",
        "([stjamesvrs] ) 2082:MIDWAY SEAFOOD 1446 MIDWAY RD SE BOLIVIA, MDL 29D02-p, 13-065069, 04:00:43, Traffic-Transportation Incidents, ON MIDWAY RD JUST BEFORE MIDWAY SEAFOOD IS A DARK COLORED PC IN DITCH...CALLER ADV SAME IS ON THE R",
        "SRC:stjamesvrs",
        "PLACE:MIDWAY SEAFOOD",
        "ADDR:1446 MIDWAY RD SE",
        "CITY:BOLIVIA",
        "CODE:29D02-p",
        "ID:13-065069",
        "TIME:04:00:43",
        "CALL:Traffic-Transportation Incidents",
        "INFO:ON MIDWAY RD JUST BEFORE MIDWAY SEAFOOD IS A DARK COLORED PC IN DITCH...CALLER ADV SAME IS ON THE R");

    doTest("T60",
        "([stjamesvfd] ) 617:13-064772, ST37(DS)05:30:11|3780C(ER)05:32:59|ST37(IS)05:32:59|3780C(AS)05:35:20|3772E(ER)05:40:20|3771E(ER)05:43:49|3773TO(ER)05:44:32|3772E(AS)05:44:58|3771E(AS)05:48:21|3773TO(AS)05:49:13|3773TO(IS)05:58:00|3771E(IS)05:58:15|3772E(IS",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-064772",
        "PLACE:ST37(DS)05:30:11|3780C(ER)05:32:59|ST37(IS)05:32:59|3780C(AS)05:35:20|3772E(ER)05:40:20|3771E(ER)05:43:49|3773TO(ER)05:44:32|3772E(AS)05:44:58|3771E(AS)05:48:21|3773TO(AS)05:49:13|3773TO(IS)05:58:00|3771E(IS)05:58:15|3772E(IS");

    doTest("T61",
        "([stjamesvfd] ) 616:2760 LONG BAY DR ST JAMES, 13-064772, 05:30:11, Fire Alarm Activation, MARINA AT ST JAMES ZONE 42 RACK C HEAT DETECTOR",
        "SRC:stjamesvfd",
        "ADDR:2760 LONG BAY DR",
        "CITY:ST JAMES",
        "ID:13-064772",
        "TIME:05:30:11",
        "CALL:Fire Alarm Activation",
        "INFO:MARINA AT ST JAMES ZONE 42 RACK C HEAT DETECTOR");

    doTest("T62",
        "([stjamesvrs] ) 2081:13-064571, ST47(DS)13:47:54|4795(ER)13:53:11|ST47(IS)13:53:11|4795(AS)13:55:42|4795(IS)14:07:53|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064571",
        "PLACE:ST47(DS)13:47:54|4795(ER)13:53:11|ST47(IS)13:53:11|4795(AS)13:55:42|4795(IS)14:07:53|");

    doTest("T63",
        "([stjamesvrs] ) 2080:4143 AMBLESTONE WAY ST JAMES, MDL 28C01-L, 13-064571, 13:47:54, Stroke (CVA), STROKE",
        "SRC:stjamesvrs",
        "ADDR:4143 AMBLESTONE WAY",
        "CITY:ST JAMES",
        "CODE:28C01-L",
        "ID:13-064571",
        "TIME:13:47:54",
        "CALL:Stroke (CVA)",
        "INFO:STROKE");

    doTest("T64",
        "([stjamesvrs] ) 2079:13-064385, ST47(DS)20:30:00|4795(ER)20:33:01|ST47(IS)20:33:01|4795(AS)20:34:33|4795(IS)20:56:25|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064385",
        "PLACE:ST47(DS)20:30:00|4795(ER)20:33:01|ST47(IS)20:33:01|4795(AS)20:34:33|4795(IS)20:56:25|");

    doTest("T65",
        "([stjamesvrs] ) 2078:3628 PLAYERS CLUB DR ST JAMES, MDL 17B03-G, 13-064385, 20:30:00, Falls, SUSAN CHILDS.. FELL.. 9104549831...",
        "SRC:stjamesvrs",
        "ADDR:3628 PLAYERS CLUB DR",
        "CITY:ST JAMES",
        "CODE:17B03-G",
        "ID:13-064385",
        "TIME:20:30:00",
        "CALL:Falls",
        "INFO:SUSAN CHILDS.. FELL.. 9104549831...");

    doTest("T66",
        "([stjamesvrs] ) 2077:13-064368, ST47(DS)19:30:18|4795(ER)19:37:00|ST47(IS)19:37:00|4795(AS)19:41:27|4795(IS)19:59:37|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064368",
        "PLACE:ST47(DS)19:30:18|4795(ER)19:37:00|ST47(IS)19:37:00|4795(AS)19:41:27|4795(IS)19:59:37|");

    doTest("T67",
        "([stjamesvrs] ) 2076:2571 ST JAMES DR HARBORSIDE @ ST ST JAMES, MDL 17B03-G, 13-064368, 19:30:18, Falls, ADV A FEMALE FALL..CALLER IS NOT WITH HER",
        "SRC:stjamesvrs",
        "PLACE:2571 ST JAMES DR HARBORSIDE",
        "ADDR:ST ST JAMES",
        "CODE:17B03-G",
        "ID:13-064368",
        "TIME:19:30:18",
        "CALL:Falls",
        "INFO:ADV A FEMALE FALL..CALLER IS NOT WITH HER");

    doTest("T68",
        "([stjamesvrs] ) 2075:13-064305, ST47(DS)16:27:55|4795(ER)16:32:58|ST47(IS)16:32:58|4795(AS)16:44:23|4795(IS)17:16:16|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064305",
        "PLACE:ST47(DS)16:27:55|4795(ER)16:32:58|ST47(IS)16:32:58|4795(AS)16:44:23|4795(IS)17:16:16|");

    doTest("T69",
        "([stjamesvfd] ) 615:13-064309, ST37(DS)16:20:30|3780C(ER)16:22:22|ST37(IS)16:22:22|3780C(IS)16:28:15|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-064309",
        "PLACE:ST37(DS)16:20:30|3780C(ER)16:22:22|ST37(IS)16:22:22|3780C(IS)16:28:15|");

    doTest("T70",
        "([stjamesvrs] ) 2074:2004 W OAK ISLAND DR OAK ISLAND, MDL 06D02-A, 13-064305, 16:27:55, Cardiac or Respiratiory Arrest - Death,",
        "SRC:stjamesvrs",
        "ADDR:2004 W OAK ISLAND DR",
        "CITY:OAK ISLAND",
        "CODE:06D02-A",
        "ID:13-064305",
        "TIME:16:27:55",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T71",
        "([stjamesvfd] ) 614:116 SW 21ST ST OAK ISLAND, 13-064309, 16:20:30, Fire Alarm Activation, ROBERT LUDWIG RESD......UPSTAIRS SMOKE DET AND KEYPAD FIRE ALARM.....910-278-6712",
        "SRC:stjamesvfd",
        "ADDR:116 SW 21ST ST",
        "CITY:OAK ISLAND",
        "ID:13-064309",
        "TIME:16:20:30",
        "CALL:Fire Alarm Activation",
        "INFO:ROBERT LUDWIG RESD......UPSTAIRS SMOKE DET AND KEYPAD FIRE ALARM.....910-278-6712");

    doTest("T72",
        "([stjamesvfd] ) 613:13-064260, ST37(DS)13:26:28|3780C(ER)13:28:03|ST37(IS)13:28:03|3780C(AS)13:33:02|3772E(DS)13:34:46|3772E(ER)13:34:50|3771E(DS)13:37:55|3771E(ER)13:37:57|3772E(AS)13:38:37|3771E(AS)13:42:31|3772E(IS)13:52:30|3771E(IS)13:52:38|3780C(IS)13",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-064260",
        "PLACE:ST37(DS)13:26:28|3780C(ER)13:28:03|ST37(IS)13:28:03|3780C(AS)13:33:02|3772E(DS)13:34:46|3772E(ER)13:34:50|3771E(DS)13:37:55|3771E(ER)13:37:57|3772E(AS)13:38:37|3771E(AS)13:42:31|3772E(IS)13:52:30|3771E(IS)13:52:38|3780C(IS)13");

    doTest("T73",
        "([stjamesvfd] ) 612:3210 EAST LAGOON CT ST JAMES, 13-064260, 13:26:28, Fire Alarm Activation, KEITH MARTIN ..910-253-7567..FIRE ALARM ACTIVATION GENERAL FIRE ZONE 17 ..WILL ATT KH",
        "SRC:stjamesvfd",
        "ADDR:3210 EAST LAGOON CT",
        "CITY:ST JAMES",
        "ID:13-064260",
        "TIME:13:26:28",
        "CALL:Fire Alarm Activation",
        "INFO:KEITH MARTIN ..910-253-7567..FIRE ALARM ACTIVATION GENERAL FIRE ZONE 17 ..WILL ATT KH");

    doTest("T74",
        "([stjamesvrs] ) 2073:13-064198, ST47(DS)09:33:29|4795(ER)09:40:55|ST47(IS)09:40:55|4795(IS)09:42:32|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064198",
        "PLACE:ST47(DS)09:33:29|4795(ER)09:40:55|ST47(IS)09:40:55|4795(IS)09:42:32|");

    doTest("T75",
        "([stjamesvrs] ) 2072:3685 ORCHID LN SE BOLIVIA, 13-064198, 09:33:29, Subject Locked in Vehicle, 17 MONTH OLD LOCKED IN VEH ... CHILD NOT IN DISTRESS .. VEH IS NOT RUNNING",
        "SRC:stjamesvrs",
        "ADDR:3685 ORCHID LN SE",
        "CITY:BOLIVIA",
        "ID:13-064198",
        "TIME:09:33:29",
        "CALL:Subject Locked in Vehicle",
        "INFO:17 MONTH OLD LOCKED IN VEH ... CHILD NOT IN DISTRESS .. VEH IS NOT RUNNING");

    doTest("T76",
        "([stjamesvrs] ) 2071:13-064043, ST47(DS)17:30:16|4795(ER)17:36:40|ST47(IS)17:36:40|4795(AS)17:51:36|4795(TR)18:06:54|4795(DEST)18:19:51|4795(IS)18:30:47|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-064043",
        "PLACE:ST47(DS)17:30:16|4795(ER)17:36:40|ST47(IS)17:36:40|4795(AS)17:51:36|4795(TR)18:06:54|4795(DEST)18:19:51|4795(IS)18:30:47|");

    doTest("T77",
        "([stjamesvrs] ) 2070:MIDWAY RD SE / OLD OCEAN HWY BOLIVIA, MDL 29D02-p, 13-064043, 17:30:16, Traffic-Transportation Incidents, ON MIDWAY RD JUST DOWN FROM OLD OCEAN HWY...GREEN DODGE TRK....ROLLOVER",
        "SRC:stjamesvrs",
        "ADDR:MIDWAY RD SE & OLD OCEAN HWY",
        "CITY:BOLIVIA",
        "CODE:29D02-p",
        "ID:13-064043",
        "TIME:17:30:16",
        "CALL:Traffic-Transportation Incidents",
        "INFO:ON MIDWAY RD JUST DOWN FROM OLD OCEAN HWY...GREEN DODGE TRK....ROLLOVER");

    doTest("T78",
        "([stjamesvrs] ) 2069:13-063942, ST47(DS)12:10:29|4795(ER)12:17:56|ST47(IS)12:17:56|4795(AS)12:28:20|4795(TR)13:31:10|4795(DEST)14:25:12|4795(IS)14:25:28|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-063942",
        "PLACE:ST47(DS)12:10:29|4795(ER)12:17:56|ST47(IS)12:17:56|4795(AS)12:28:20|4795(TR)13:31:10|4795(DEST)14:25:12|4795(IS)14:25:28|");

    doTest("T79",
        "([stjamesvrs] ) 2068:146 NW 11TH ST OAK ISLAND, MDL 09E01, 13-063942, 12:10:29, Cardiac or Respiratiory Arrest - Death,",
        "SRC:stjamesvrs",
        "ADDR:146 NW 11TH ST",
        "CITY:OAK ISLAND",
        "CODE:09E01",
        "ID:13-063942",
        "TIME:12:10:29",
        "CALL:Cardiac or Respiratiory Arrest - Death");

    doTest("T80",
        "([stjamesvfd] ) 611:13-063742, ST37(DS)18:29:01|ST37(IS)18:36:19|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-063742",
        "PLACE:ST37(DS)18:29:01|ST37(IS)18:36:19|");

    doTest("T81",
        "([stjamesvfd] ) 610:GEORGE II HWY SE / OCEAN HWY E (HWY 17 N) WINNABOW, 13-063742, 18:29:01, Standby, REQ STA37 MOVE UP TO 17/87 FOR NORTH END STANDBY",
        "SRC:stjamesvfd",
        "PLACE:GEORGE II HWY SE / OCEAN HWY E (HWY",
        "ADDR:17 N)",
        "CITY:WINNABOW",
        "ID:13-063742",
        "TIME:18:29:01",
        "CALL:Standby",
        "INFO:REQ STA37 MOVE UP TO 17/87 FOR NORTH END STANDBY");

    doTest("T82",
        "([stjamesvrs] ) 2067:13-063395, ST47(DS)17:36:51|4795(ER)17:43:03|ST47(IS)17:43:03|4795(AS)17:46:35|4795(IS)18:23:59|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-063395",
        "PLACE:ST47(DS)17:36:51|4795(ER)17:43:03|ST47(IS)17:43:03|4795(AS)17:46:35|4795(IS)18:23:59|");

    doTest("T83",
        "([stjamesvrs] ) 2066:FOUNDERS CLUB (ST JAMES) & POOL 3021 BEAVER CREEK DR ST JAMES, MDL 20A01-H, 13-063395, 17:36:51, Heat - Cold Exposure, MALE SUBJ CRAMPING UP",
        "SRC:stjamesvrs",
        "PLACE:FOUNDERS CLUB (ST JAMES) & POOL",
        "ADDR:3021 BEAVER CREEK DR",
        "CITY:ST JAMES",
        "CODE:20A01-H",
        "ID:13-063395",
        "TIME:17:36:51",
        "CALL:Heat - Cold Exposure",
        "INFO:MALE SUBJ CRAMPING UP");

    doTest("T84",
        "([stjamesvfd] ) 609:13-062923, ST37(DS)12:09:39|3780C(ER)12:12:08|ST37(IS)12:12:08|3780C(IS)12:17:14|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-062923",
        "PLACE:ST37(DS)12:09:39|3780C(ER)12:12:08|ST37(IS)12:12:08|3780C(IS)12:17:14|");

    doTest("T85",
        "([stjamesvfd] ) 608:3002 E OAK ISLAND DR OAK ISLAND, 13-062923, 12:09:39, Structure Fire (Smoke/Flames Visible)(Confirmed),",
        "SRC:stjamesvfd",
        "ADDR:3002 E OAK ISLAND DR",
        "CITY:OAK ISLAND",
        "ID:13-062923",
        "TIME:12:09:39",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)");

    doTest("T86",
        "([stjamesvrs] ) 2065:13-062761, ST47(DS)21:22:20|ST47(IS)23:52:48|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-062761",
        "PLACE:ST47(DS)21:22:20|ST47(IS)23:52:48|");

    doTest("T87",
        "([stjamesvfd] ) 607:13-062754, ST37(DS)20:58:30|3780C(ER)21:00:53|ST37(IS)21:00:53|3771E(ER)21:08:18|3771E(AS)21:20:54|3780C(AS)21:42:08|3780C(IS)23:27:28|3771E(IS)23:30:09|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-062754",
        "PLACE:ST37(DS)20:58:30|3780C(ER)21:00:53|ST37(IS)21:00:53|3771E(ER)21:08:18|3771E(AS)21:20:54|3780C(AS)21:42:08|3780C(IS)23:27:28|3771E(IS)23:30:09|");

    doTest("T88",
        "([stjamesvrs] ) 2064:ST JAMES FIRE (STATION 37) 3628 ST JAMES DR ST JAMES, 13-062761, 21:22:21, Standby,",
        "SRC:stjamesvrs",
        "PLACE:ST JAMES FIRE (STATION 37)",
        "ADDR:3628 ST JAMES DR",
        "CITY:ST JAMES",
        "ID:13-062761",
        "TIME:21:22:21",
        "CALL:Standby");

    doTest("T89",
        "([stjamesvfd] ) 606:SOUTHPORT FIRE (STATION 3) 1011 N HOWE ST SOUTHPORT, 13-062754, 20:58:30, Standby,",
        "SRC:stjamesvfd",
        "PLACE:SOUTHPORT FIRE (STATION 3)",
        "ADDR:1011 N HOWE ST",
        "CITY:SOUTHPORT",
        "ID:13-062754",
        "TIME:20:58:30",
        "CALL:Standby");

    doTest("T90",
        "([stjamesvrs] ) 2063:13-062124, ST47(DS)01:31:34|ST47(IS)01:42:36|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-062124",
        "PLACE:ST47(DS)01:31:34|ST47(IS)01:42:36|");

    doTest("T91",
        "([stjamesvrs] ) 2062:2930 HEWETT RD SE BOLIVIA, MDL 26A11, 13-062124, 01:31:34, Sick Person (Specific Diagnosis),",
        "SRC:stjamesvrs",
        "ADDR:2930 HEWETT RD SE",
        "CITY:BOLIVIA",
        "CODE:26A11",
        "ID:13-062124",
        "TIME:01:31:34",
        "CALL:Sick Person (Specific Diagnosis)");

    doTest("T92",
        "([stjamesvrs] ) 2061:13-061829, ST47(DS)02:33:49|4795(ER)02:43:35|ST47(IS)02:43:35|4795(IS)02:53:59|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-061829",
        "PLACE:ST47(DS)02:33:49|4795(ER)02:43:35|ST47(IS)02:43:35|4795(IS)02:53:59|");

    doTest("T93",
        "([stjamesvrs] ) 2060:2930 HEWETT RD SE BOLIVIA, MDL 26A11, 13-061829, 02:33:49, Sick Person (Specific Diagnosis), DAUGHTER IS SICK",
        "SRC:stjamesvrs",
        "ADDR:2930 HEWETT RD SE",
        "CITY:BOLIVIA",
        "CODE:26A11",
        "ID:13-061829",
        "TIME:02:33:49",
        "CALL:Sick Person (Specific Diagnosis)",
        "INFO:DAUGHTER IS SICK");

    doTest("T94",
        "([stjamesvrs] ) 2059:13-061801, ST47(DS)23:56:18|4795(ER)00:04:31|ST47(IS)00:04:32|4795(AS)00:08:45|4795(IS)00:27:22|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-061801",
        "PLACE:ST47(DS)23:56:18|4795(ER)00:04:31|ST47(IS)00:04:32|4795(AS)00:08:45|4795(IS)00:27:22|");

    doTest("T95",
        "([stjamesvrs] ) 2058:3619 MEMBERS CLUB BLVD ST JAMES, MDL 06D01, 13-061801, 23:56:18, Breathing Problems,",
        "SRC:stjamesvrs",
        "ADDR:3619 MEMBERS CLUB BLVD",
        "CITY:ST JAMES",
        "CODE:06D01",
        "ID:13-061801",
        "TIME:23:56:18",
        "CALL:Breathing Problems");

    doTest("T96",
        "([stjamesvfd] ) 605:13-061161, ST37(DS)23:12:35|3780C(ER)23:16:22|ST37(IS)23:16:22|3771E(ER)23:23:26|3780C(AS)23:29:30|3771E(AS)23:39:43|3780C(IS)23:47:10|3771E(IS)23:47:13|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-061161",
        "PLACE:ST37(DS)23:12:35|3780C(ER)23:16:22|ST37(IS)23:16:22|3771E(ER)23:23:26|3780C(AS)23:29:30|3771E(AS)23:39:43|3780C(IS)23:47:10|3771E(IS)23:47:13|");

    doTest("T97",
        "([stjamesvfd] ) 604:4602 E DOLPHIN DR OAK ISLAND, 13-061161, 23:12:35, Structure Fire (Smoke/Flames Visible)(Confirmed), ADV THE RESD IS ON FIRE..SMOKE IN THE RESD...",
        "SRC:stjamesvfd",
        "ADDR:4602 E DOLPHIN DR",
        "CITY:OAK ISLAND",
        "ID:13-061161",
        "TIME:23:12:35",
        "CALL:Structure Fire (Smoke/Flames Visible)(Confirmed)",
        "INFO:ADV THE RESD IS ON FIRE..SMOKE IN THE RESD...");

    doTest("T98",
        "([stjamesvrs] ) 2057:13-060997, ST47(DS)13:39:09|4795(ER)13:52:03|ST47(IS)13:52:03|4795(AS)13:58:50|4795(IS)13:59:05|",
        "CALL:RUN REPORT",
        "SRC:stjamesvrs",
        "ID:13-060997",
        "PLACE:ST47(DS)13:39:09|4795(ER)13:52:03|ST47(IS)13:52:03|4795(AS)13:58:50|4795(IS)13:59:05|");

    doTest("T99",
        "([stjamesvrs] ) 2056:2810 BROWN RD SE BOLIVIA, MDL 31D03, 13-060997, 13:39:09, Unconscious-Fainting (Near),",
        "SRC:stjamesvrs",
        "ADDR:2810 BROWN RD SE",
        "CITY:BOLIVIA",
        "CODE:31D03",
        "ID:13-060997",
        "TIME:13:39:09",
        "CALL:Unconscious-Fainting (Near)");

    doTest("T100",
        "([stjamesvfd] ) 603:13-060741, ST37(DS)18:22:11|3780C(ER)18:24:20|ST37(IS)18:24:20|3780C(AS)18:28:06|3772E(ER)18:31:39|3772E(AS)18:36:30|3772E(IS)18:44:47|3780C(IS)18:46:56|",
        "CALL:RUN REPORT",
        "SRC:stjamesvfd",
        "ID:13-060741",
        "PLACE:ST37(DS)18:22:11|3780C(ER)18:24:20|ST37(IS)18:24:20|3780C(AS)18:28:06|3772E(ER)18:31:39|3772E(AS)18:36:30|3772E(IS)18:44:47|3780C(IS)18:46:56|");

  }

  public static void main(String[] args) {
    new NCBrunswickCountyParserTest().generateTests("T1");
  }
}
