package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Hardin County, KY

Contact: Active911
Agency name: Rineyville Fire Dept
Location: Rineyville, KY, United States
Sender: noreply@hckysar.appspotmail.com

(Incident: 2013027421) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1022 HUTCHERSON LN\nCross: WOLFE RUN RD & S WILSON RD\nTimeout: Wed May 08 15:18:00 UTC 2013\nInfo: someone  [05/08/13 15:17:15 HENSLEYM]\nin front of 1022  77 yr old female having chest pain  adv that they rear  \nended\nCS=239 CSS=2 (S)LORIEN (N)
(Incident: 2013026853) \nNature: FIRE OTHER\nAddress: 200-BLK DECKARD SCHOOL RD\nCross: BELAIRE DR & LISA LN\nTimeout: Mon May 06 11:20:00 UTC 2013\nInfo: roll over accident no injuries  [05/06/13 11:19:13 SJOHNSON]\nCS=159 CSS=9 (S) (N)STA.2
(Incident: 2013026796) \nNature: FIRE OTHER\nAddress: 6107 S WILSON RD\nCross: STADIUM DR & BLACK RAVENS CT\nTimeout: Mon May 06 02:14:00 UTC 2013\nInfo: [05/06/13 02:13:43 SEYMOURS]\nHAVE AN ISSUE WITH FURNACE, SMELL OF GAS IN THE RESIDENCE\nCALLER ADV THAT HER SUB PUMP HAS QUIT WORKING AND THAT MAY\nDIST: 364.89 FT
(Incident: 2013026532) \nNature: FIRE ACTIVATED ALARM\nAddress: 1484 HUTCHERSON LN\nCross: BARBARA CIR & WOLFE RUN RD\nTimeout: Sat May 04 17:11:00 UTC 2013
(Incident: 2013026059) \nNature: FIRE STRUCTURE\nAddress: 10642 HARDINSBURG RD\nCross: SALT RIVER RD & TOM DUVALL LN\nTimeout: Thu May 02 22:20:00 UTC 2013\nInfo: MLYDY]\n800 and 811 on scene fully involved attic structure fire  [05/02/13 22:20:22\n806 805 IN SERV  [05/02/13 22:18:38 MLYDY]\n800 IN SERV  [05/02/13 22:17:39 MLYDY]\n[05/02/13 22:14:51 CDUNN]\nADVISING BUILDING IS ON FIRE. FLAMES COMING OUT OF ROOF\nCS=446 CSS=1
(Incident: 2013025290) \nNature: FIRE STRUCTURE\nAddress: 141 TERESA RD\nCross: BIG WHEEL DR & N DIXIE HWY\nTimeout: Mon Apr 29 23:16:00 UTC 2013\nInfo: {1000} RVFD FOR A TANKER CODE3  [04/29/13 23:16:28 MYERST]\n[04/29/13 22:46:36 MYERST]\n{1064} WILL BE FILLING UP NEAR JHHS, ALARM MIGHT BE SET OFF\nRED CROSS NOTIFIED  [04/29/13 22:42:53 MYERST]\nNOLIN HAS BEEN NOTIFIED  [04/29/13 22:11:32 MYERST]\n{1000} NOTIFY UTILITY CO.  [04/29/13 22:10:31 MYERST]\nUNDERNEATH THE TRAILER  [04/29/13 22:06:13 MLYDY]\nAGO, NO ONE IS HOME, DOOR LOCKED, FIRE COMING OUT\n[EMS] {SQ5} NIEGHBOR ADV SQ5 THE OCCUPANTS LEFT A FEW HOURS\n22:02:46 MJOHNSON]\n[EMS] {SQ5} NO VEHICLES IN THE DRIVEWAY AT THIS TIME  [04/29/13\n105 10-8 ST.1  [04/29/13 22:02:26 MYERST]\n[EMS] {SQ5} FULLY INVOLVED  [04/29/13 22:01:29 MJOHNSON]\n100 10-8 ST.1  [04/29/13 22:01:13 MYERST]\n103 10-8 ST.1  [04/29/13 21:59:34 MYERST]\nvehicles in driveway, believes no one is home  [04/29/13 21:59:17 MLYDY]\nCan`t tell color of smoke, lots of smoke coming from house, doesn`t see any\n(S) (N)1110
(Incident: 2013024583) \nNature: FIRE OTHER\nAddress: 2929 RINEYVILLE BIG SPRINGS RD\nCross: ROUNDABOUT & OAKWOOD CT\nTimeout: Fri Apr 26 17:03:00 UTC 2013
(Incident: 2013024002) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1599 DECKARD SCHOOL RD/RINEYVILLE BIG\nTimeout: Wed Apr 24 12:03:00 UTC 2013
(Incident: 2013023398) \nNature: INJURY\nAddress: 4483 RINEYVILLE BIG SPRINGS RD\nCross: SAGE CT & RINEYVILLE RD\nTimeout: Sun Apr 21 12:24:00 UTC 2013\nInfo: fell on coffee table  [04/21/13 12:22:25 LEOM]\nunable to get bleeding to stop  [04/21/13 12:21:37 LEOM]\nLEOM]\nbleeding from  wrist, 37 y/o male  chevy, malbu sliver  [04/21/13 12:20:39\nCS=141 CSS=7 DIST: 22.96 FT
(Incident: 2013023322) \nNature: FIRE OTHER\nAddress: 906 THOMPSON RD\nCross: MCDREAMY CT & MASAKO CT\nTimeout: Sat Apr 20 22:58:00 UTC 2013\nInfo: ADV  [04/20/13 22:38:27 HENSLEYM]\nELEC IS OFF AT A RESIDENCE ADV POLE # 42827 I CALLED NOLIN AND\n962 ADV TO NOTIFY ELEC CO ADV THAT THE BUS HIT A POLE AND\nky  [04/20/13 22:27:27 LEOM]\n[04/20/13 22:20:47 CDUNN]\nRECKLESS. BUS #80. UNITS LOOKING FOR BUS AS POSSIBLE SUBJECT.\n3356 THOMAS RD. RECEIVED 911 CALL OF SCHOOL BUS DRIVING\nstolen from residence, poss passed  [04/20/13 21:03:10 LEOM]\n209 IN COMMAND  [04/20/13 21:03:04 HENSLEYM]\n2012 blk  crystal 300  [04/20/13 21:01:26 LEOM]\nSTEPHANIE IS DOWN THE STREET WAITING.  [04/20/13 20:41:09 CDUNN]\nHAVE CONTACT WITH HER.  [04/20/13 20:37:43 CDUNN]\nAGAINST HER. HER DAUGHTER IS HOME AND IS NOT SUPPOSE TO\nCOURTNEY ROBERTS IS AT HER HOUSE RIGHT NOW. HAS AN EPO OUT\n22:58:25 HENSLEYM]\nEvent spawned from POLICE CRIME AGAINST PEOPLE.  [04/20/2013\n(S)OSBORNE TRACE (N)
(Incident: 2013022145) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 76 CARROLL AVE\nCross: DILLARD AVE & RINEYVILLE BLVD\nTimeout: Mon Apr 15 20:54:00 UTC 2013\nInfo: MYERST]\nAND A CHILD. UNKNOWN TYPE OF INJURIES.  [04/15/13 20:54:19\nCALLER ADVISED OF A VEHICLE ACCIDENT, HIT AND RUN. 1 FEMALE\n(S)BLACKBURN ESTATES (N)
(Incident: 2013021921) \nNature: FIRE/SMOKE/ODOR COMPLAINT\nAddress: 440 CARROLL AVE\nCross: DILLARD AVE\nTimeout: Sun Apr 14 20:42:00 UTC 2013\nInfo: no one is around this burn, it keeps flaring up  [04/14/13 20:41:39  \nMLYDY]\n(S)BLACKBURN ESTATES (N)
(Incident: 2013021778) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1051 RINEYVILLE SCHOOL RD\nCross: FLUSHING MEADOWS DR & LAVISTA DR\nTimeout: Sun Apr 14 05:29:00 UTC 2013
(Incident: 2013021729) \nNature: FIRE GRASS WOODS\nAddress: 400-BLK CARROLL AVE\nCross: DILLARD AVE\nTimeout: Sat Apr 13 21:27:00 UTC 2013\nInfo: Has a really bad smell to it  [04/13/13 21:26:03 MLYDY]\nMLYDY]\npeople are burning torn down home, and trash in this area  [04/13/13  \n21:25:41\nCS=141 CSS=8  (S)BLACKBURN ESTATES (N)
(Incident: 2013020882) \nNature: FIRE GRASS WOODS\nAddress: 20 MUSTANG LN\nCross: RUNNING BEAR TR & BOONE RD\nTimeout: Wed Apr 10 15:13:00 UTC 2013\nInfo: NICHOLSG]\ncaller adv that the woods are on fire with trailer in danger.  [04/10/13  \n15:12:40\n(S)SUN AND FUN (N)
(Incident: 2013020814) \nNature: ALARM TEST\nAddress: 10503 RINEYVILLE BIG SPRINGS RD\nCross: SALT RIVER RD & HARRIS SCHOOL RD\nTimeout: Wed Apr 10 10:24:00 UTC 2013
(Incident: 2013020532) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 8998 RINEYVILLE RD/OWSLEY RD\nTimeout: Tue Apr 09 06:07:00 UTC 2013\nInfo: female with neck pain  [04/09/13 06:06:59 MPOWERS]\nCS=378 CSS=3
(Incident: 2013020525) \nNature: CARDIAC ARREST\nAddress: 110 TOMAHAWK TR\nCross: COCHISE CT & PINTO TR\nTimeout: Tue Apr 09 02:47:00 UTC 2013\nInfo: 78 female  [04/09/13 02:46:51 MPOWERS]\n(S)SUN AND FUN (N)
(Incident: 2013020145) \nNature: FIRE ACTIVATED ALARM\nAddress: 3106 BURNS RD\nCross: GENROSE DR & WARREN DR\nTimeout: Sun Apr 07 11:15:00 UTC 2013\nInfo: NHELTON]\nhallway smoke detecter, no keyholder contacted yet  [04/07/13 11:15:12\n(S)ABERDEEN ESTATES (N)
(Incident: 2013020052) \nNature: FIRE/SMOKE/ODOR COMPLAINT\nAddress: 360 SCHLAEFER WAY\nCross: RINEYVILLE RD\nTimeout: Sat Apr 06 21:22:00 UTC 2013\nInfo: kids poss having a  bon file,  [04/06/13 21:20:03 LEOM]\n(S)BRYAN ACRES (N)
(Incident: 2013020050) \nNature: FIRE GRASS WOODS\nAddress: 440 CARROLL AVE\nCross: DILLARD AVE\nTimeout: Sat Apr 06 21:00:00 UTC 2013\nInfo: FIRE HAS STARTED BACK UP.  [04/06/13 20:59:46 CDUNN]\nCS=141 CSS=8 (S)BLACKBURN ESTATES (N)
(Incident: 2013019998) \nNature: FIRE/SMOKE/ODOR COMPLAINT\nAddress: 498 CARROLL AVE\nCross: DILLARD AVE\nTimeout: Sat Apr 06 16:50:00 UTC 2013\nInfo: possible illegal burn  [04/06/13 16:50:30 HENSLEYM]\n(S)BLACKBURN ESTATES (N)
(Incident: 2013019932) \nNature: FIRE GRASS WOODS\nAddress: 14547 SAINT JOHN RD\nCross: TURKEY ROOST LN & SALT RIVER RD\nTimeout: Sat Apr 06 13:37:00 UTC 2013\nInfo: 800 adv put RVFD on stby  [04/06/13 13:37:11 SJOHNSON]\nTHE WIND HAS PICKED UP  [04/06/13 13:35:46 NICHOLSG]\nRCVD SECOND CALL ADV THAT FIRE IS GETTING WORSE BECAUSE\n800 RESPONDING TO THE SCENE  [04/06/13 13:34:20 MJOHNSON]\n810 10-8  [04/06/13 13:33:03 MJOHNSON]\n803 10-8  [04/06/13 13:32:38 MJOHNSON]\n800 10-8  [04/06/13 13:31:30 MJOHNSON]\n804 10-8  [04/06/13 13:30:53 MJOHNSON]\nSTRUCTURES IN DANGER AT THIS TIME  [04/06/13 13:27:10 MJOHNSON]\nWAS HAVING A CONTROL BURN FIRE IS NOW OUT OF CONTROL. NO\nCS=298 CSS=3 DIST: 583.28 FT
(Incident: 2013018974) \nNature: FIRE GRASS WOODS\nAddress: 8510 RINEYVILLE RD\nCross: OWSLEY RD & FLETCHER CT\nTimeout: Tue Apr 02 11:35:00 UTC 2013\nInfo: SJOHNSON]\nwas having a control burn that is out of control  [04/02/13 11:35:23\nDIST: 365.78 FT
(Incident: 2013018167) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 275 RINEYVILLE SCHOOL RD\nCross: STITH LN & PERKINS LN\nTimeout: Fri Mar 29 16:01:00 UTC 2013\nInfo: MJOHNSON]\nDIFF BREATHING. GO TO THE FRONT DOOR.  [03/29/13 15:59:30\nIN THE LIBRARY, 42 YO FEMALE NOT FEELING WELL. IN/OUT CONS,\nCS=141 CSS=2
(Incident: 2013017635) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 217 COCHISE CT\nCross: PINTO TR & TEE PEE RD\nTimeout: Wed Mar 27 00:16:00 UTC 2013\nInfo: 63 female unres. not breathing normal  [03/27/13 00:15:47 MPOWERS]\n(S)SUN AND FUN (N)
(Incident: 2013017404) \nNature: ACTIVATED MEDICAL ALARM\nAddress: 4417 RINEYVILLE RD\nCross: BRADLEY TR & TIMBERLINE TR\nTimeout: Mon Mar 25 19:23:00 UTC 2013
(Incident: 2013017293) \nNature: FIRE STRUCTURE\nAddress: 313 OAKWOOD CIR\nCross: HILLVIEW DR\nTimeout: Mon Mar 25 09:00:00 UTC 2013\nInfo: Flue Fire  [03/25/13 08:59:39 LCORDERO]\n(S)COUNTRY MEADOWS ESTATE (N)
(Incident: 2013017285) \nNature: FIRE STRUCTURE\nAddress: 132 HICKORY HILL DR\nCross: E AIRVIEW DR & W AIRVIEW DR\nTimeout: Mon Mar 25 07:54:00 UTC 2013\nInfo: 105 STA 1 I/S  [03/25/13 07:52:51 SEYMOURS]\n106 STA 2 I/S  [03/25/13 07:51:21 SEYMOURS]\n[EMS] {SQ1} OK ON PAGE  [03/25/13 07:49:49 PETERSONB]\nHOUSE ON FIRE. EVERYONE EVACED  [03/25/13 07:48:58 PETERSONB]\nCS=259 CSS=1  (S) (N)1120
(Incident: 2013017136) \nNature: FIRE STRUCTURE\nAddress: 132 E PIEDMONT DR\nCross: N RUSHMORE DR & E TWIN LAKES DR\nTimeout: Sun Mar 24 08:47:00 UTC 2013\nInfo: SJOHNSON]\ncaller adv can smell something buring and see smoke  [03/24/13 08:47:02\nCS=141 CSS=7 (S)HIGHLAND SPRINGS (N)

Contact: Active911
Agency name: Radcliff Fire
Location: Radcliff, KY, United States
Sender: noreply@hckysar.appspotmail.com

(Incident: 2013027760) \nNature: FIRE STRUCTURE\nAddress: 245 ELMWOOD DR\nCross: ELM RD\nTimeout: Fri May 10 01:33:00 UTC 2013\nInfo: 01:32:58 SEYMOURS]\nBURNING FROM THIS APT AND FIRE ALARM GOING OFF  [05/10/13\nAPT ACROSS FROM CALLER ADV THAT HE SMELLS SOMETHING\nAPT 507  CS=159 CSS=9 DIST: 8.76 FT  (S)
(Incident: 2013027628) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 9 JOE PRATHER HWY/S DIXIE BLVD\nTimeout: Thu May 09 13:20:00 UTC 2013\nInfo: SJOHNSON]\n2 vehicle accident adult male with injuries unknown extent  [05/09/13  \n13:19:52\nDIST: 393.63 FT (S) (N)STA.2
(Incident: 2013027251) \nNature: FIRE ACTIVATED ALARM\nAddress: 119 ACADEMY LN\nCross: W CROCUS DR & W VINE ST\nTimeout: Tue May 07 19:30:00 UTC 2013\nInfo: WILL NOT SHOW UP.  [05/07/13 19:30:08 MYERST]\nZONE: HALLWAY SMOKE DETEC. KEY HOLDER IS NOT HOME,  AND\n(S) (N)STA.1
(Incident: 2013027238) \nNature: FIRE/SMOKE/ODOR COMPLAINT\nAddress: 1117 HILL ST\nCross: EVELYN DR & CARTER DR\nTimeout: Tue May 07 18:36:00 UTC 2013\nInfo: GAS LINE STRUCK, LG&amp;E 30 MIN ETA  [05/07/13 18:35:43 MYERST]\n(S) (N)STA.1
(Incident: 2013027139) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 699 S WOODLAND DR/W VINE ST\nTimeout: Tue May 07 12:10:00 UTC 2013\nInfo: NHELTON]\n36 yo male, complaining of neck pain, RPD on scene  [05/07/13 12:09:51\nVehicle accident. unknown injuries  [05/07/13 12:05:01 LCORDERO]\n(S) (N)STA.1
(Incident: 2013027082) \nNature: UNRESPON W/NORMAL BREATHING\nAddress: 238 INDIANA TR\nCross: E LINCOLN TRAIL BLVD & E LINCOLN TRAIL BLVD\nTimeout: Tue May 07 08:35:00 UTC 2013\nInfo: {SQ5} REQUESTING FIRE CODE 3  [05/07/13 08:35:20 GRIFFISM]\nNOT SURE WHAT IS GOING ON.  [05/07/13 08:23:55 NICHOLSG]\nTHE BACKGROUND.  [05/07/13 08:23:35 NICHOLSG]\nCALLER ADV THAT 43 YO MALE IS NOT WAKING UP.  IS MOANING IN\n(S)LINCOLN TRAIL ACRES (N)STA.1
(Incident: 2013026819) \nNature: BREATHING DIFFICULTY\nAddress: 1145 N LOGSDON PKWY\nCross: RED HILL RD & MULBERRY ST\nTimeout: Mon May 06 08:41:00 UTC 2013\nInfo: {SQ2} SEND FIRE CODE 3  [05/06/13 08:41:06 LCORDERO]\nsemi-responsive. will not stay awake.  [05/06/13 08:33:11 LCORDERO]\n67 yo f,  D/B. 75% with 02.  [05/06/13 08:32:43 LCORDERO]\nDIST: 77.12 FT (S) (N)STA.1
(Incident: 2013026768) \nNature: DIABETIC EMERGENCY\nAddress: 1044 S WOODLAND DR\nCross: CYNTHIA CT & CAROLYN ST\nTimeout: Sun May 05 20:46:00 UTC 2013\nInfo: 20:45:01 MJOHNSON]\n21 YO FEMALE ADV BS IS HIGH VOMMITING. DIFF BREATHING  [05/05/13\nDIST: 99.48 FT (S)WOODLAWN ACRES
(Incident: 2013026765) \nNature: SEIZURE\nAddress: 1626 W CROCUS DR\nCross: S LORRAINE ST & ANDERSON CT\nTimeout: Sun May 05 20:38:00 UTC 2013\nInfo: MYERST]\n[SQ5-TRANSPORT] {SQ5} CODE3, NEED DRIVER  [05/05/13 20:38:20\nHX Brain surgery  [05/05/13 20:24:37 LEOM]\ngasping, foaming at mouth  [05/05/13 20:24:16 LEOM]\nposs having a seizure, 6 y/o male  [05/05/13 20:23:14 LEOM]\n(S) (N)STA.1
(Incident: 2013026746) \nNature: FIRE ACTIVATED ALARM\nAddress: 350 SNYDER WAY\nCross: N LOGSDON PKWY\nTimeout: Sun May 05 18:49:00 UTC 2013\nInfo: [05/05/13 18:49:36 MYERST]\nZONE: GENERAL ALARM, KEY HOLDER HAS NOT BEEN NOTIFIED.\n(S) (N)STA.1
(Incident: 2013026628) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1 N DIXIE HWY/MASTERS DR\nTimeout: Sun May 05 01:25:00 UTC 2013\nInfo: MALE WITH HAND AND NECKPAIN.  [05/05/13 01:25:01 PETERSONB]\nNON INJURY ACCIDENT  [05/05/13 01:02:37 PETERSONB]\nCS=159 CSS=9 DIST: 26.89 FT  (S) (N)STA.2
(Incident: 2013026588) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 836 BRIARGATE CT\nCross: W VINE ST\nTimeout: Sat May 04 20:41:00 UTC 2013\nInfo: MJOHNSON]\n70-80 FEMALE SEMI CONS, DIFF BREATHING.  [05/04/13 20:40:54\n(S) (N)STA.1
(Incident: 2013026473) \nNature: FIRE ACTIVATED ALARM\nAddress: 105 WAYNE WAY\nCross: S WOODLAND DR & BYERLY BLVD\nTimeout: Sat May 04 13:39:00 UTC 2013\nInfo: CO alarm zone 22  [05/04/13 13:39:11 SJOHNSON]\nFire alarm zone 21\n(S)HILLTOP TERRACE (N)STA.2
(Incident: 2013026391) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 599 ROGERSVILLE RD\nCross: SHELTON RD & WILLIS DR\nTimeout: Sat May 04 00:09:00 UTC 2013\nInfo: [05/04/13 00:08:44 PETERSONB]\nPT WALLCE MOFA F BLLEEDING FROM FACE. CON UNKNOWN.\n5 E BED2 (S) (N)STA.1
(Incident: 2013026298) \nNature: DIABETIC EMERGENCY\nAddress: 1165 WALMART WAY\nCross: N WILSON RD & N DIXIE BLVD\nTimeout: Fri May 03 18:19:00 UTC 2013\nInfo: IS CONS/SHAKING A LITTLE.  [05/03/13 18:17:43 MJOHNSON]\nRED VEHICLE. WILL WAVE DOWN EMS.  [05/03/13 18:17:37 MJOHNSON]\n18:17:18 MJOHNSON]\nDIB EMERGENCY. HAS HAD OJ AND CANDY DOING BETTER.  [05/03/13\n63 YO MALE IN PARKING LOT. ISLE 4 AT THE END BY GAS PUMPS. POSS\n(S) (N)STA.1
(Incident: 2013026266) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1 LAKE RD/S WILSON RD\nTimeout: Fri May 03 17:20:00 UTC 2013\nInfo: possible injuries  [05/03/13 17:20:31 MLYDY]\nCS=249 CSS=5 (S) (N)STA.2
(Incident: 2013026074) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 109 HAMILTON ST\nCross: FRANKLIN ST & WAGON WHEEL TR\nTimeout: Thu May 02 23:36:00 UTC 2013\nInfo: MYERST]\n55 Y/O MALE UNRESPONSIVE, DIFF BREATHING.  [05/02/13 23:36:18\n(S)WHISPERING HILLS (N)STA.2
(Incident: 2013025755) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 936 W VINE ST/S LOGSDON PKWY\nTimeout: Wed May 01 18:55:00 UTC 2013\nInfo: PT TRAPPED IN THE CAR  [05/01/13 18:55:13 MJOHNSON]\nair bag deployed, hit tree.  [05/01/13 18:54:58 MLYDY]\nCS=200 CSS=3 DIST: 24.84 FT (S) (N)STA.1
(Incident: 2013025653) \nNature: FALL\nAddress: 656 SOUTHLAND DR\nCross: JONES ST & ROMAN ST\nTimeout: Wed May 01 13:03:00 UTC 2013\nInfo: Bleeding from the head.  [05/01/13 13:02:34 LCORDERO]\nFather fell down 3 steps, unreponsive  [05/01/13 13:02:04 LCORDERO]\nDIST: 105.96 FT (S) (N)STA.1
(Incident: 2013025512) \nNature: BREATHING DIFFICULTY\nAddress: 383 W VINE ST\nCross: S WOODLAND DR & TROY AVE\nTimeout: Tue Apr 30 21:32:00 UTC 2013\nInfo: CDUNN]\n64 YO FEMALE HAVING DB. VERY INCOHEREANT.  [04/30/13 21:23:12\n(S) (N)STA.1
(Incident: 2013025385) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 995 ELM RD/N LOGSDON PKWY\nTimeout: Tue Apr 30 13:29:00 UTC 2013\nInfo: unknown injuries  [04/30/13 13:29:19 BENNETTK]\nBENNETTK]\nfemale on ground, no entrapment . motorcycle verses car.  [04/30/13 13:29:01\nDIST: 162.78 FT (S) (N)STA.1
(Incident: 2013025252) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 908 RHONDA CT\nCross: MULBERRY ST\nTimeout: Mon Apr 29 18:44:00 UTC 2013\nInfo: ELDERLY FEMALE  [04/29/13 18:44:44 MJOHNSON]\n18:44:29 MJOHNSON]\nFEMALE FELL POSS UNCONS, MAKING FUNNY NOISES  [04/29/13\n(S) (N)STA.1
(Incident: 2013024746) \nNature: FIRE OTHER\nAddress: 245-15 GLOBE ST\nCross: HILL ST & N DIXIE BLVD\nTimeout: Sat Apr 27 11:37:00 UTC 2013\nInfo: one.  [04/27/13 11:36:35 LCORDERO]\nYellow ambulance requesting lift assist for a 600 lbs male. 12 minute eta.  \nCode\n(S) (N)STA.1
(Incident: 2013024540) \nNature: FIRE STRUCTURE\nAddress: 2927-3 S WILSON RD\nCross: SKYLINE DR & MILLER AVE\nTimeout: Fri Apr 26 14:37:00 UTC 2013\nInfo: FORWARDED TO RPD  [04/26/13 14:37:16 NICHOLSG]\n14:37:09 LCORDERO]\nRPD requested FD smoke inside the apt. Water pouring out of apt  [04/26/13\n14:11:07 NICHOLSG]\nHERS IS FLOODING.  THERE IS WATER EVERYWHERE  [04/26/13\nCALLER ADV THAT HER APARTMENT AND THE BUILDING NEXT TO\nAPT 4DIST: 1656.78 FT  (S)HILLTOP
(Incident: 2013024476) \nNature: UNRESPON W/ABNORMAL BREATHING\nAddress: 772 MAGNOLIA DR\nCross: COTTONWOOD DR & CYPRESS DR\nTimeout: Fri Apr 26 10:35:00 UTC 2013\nInfo: BREATHING, HX OF CANCER  [04/26/13 10:34:53 BENNETTK]\n57 YO F, BLEEDING THROUGH RECTUM, UNRESPONSIVE ABNORMAL\n(S) (N)STA.1
(Incident: 2013024458) \nNature: CARDIAC ARREST\nAddress: 172 N DEEPWOOD DR\nCross: ELM RD & W LINCOLN TRAIL BLVD\nTimeout: Fri Apr 26 09:16:00 UTC 2013\nInfo: not breathing not consicous  [04/26/13 09:16:31 LCORDERO]\n(S) (N)STA.1
(Incident: 2013024348) \nNature: FIRE OTHER\nAddress: 140 SHELTON RD\nCross: TURNER DR & S WILSON RD\nTimeout: Thu Apr 25 18:17:00 UTC 2013\nInfo: 9 y/o daughter  is missing  [04/25/13 17:51:35 LEOM]\nDIST: 59.02 FT (S) (N)STA.2
(Incident: 2013024201) \nNature: FIRE STRUCTURE\nAddress: 102 WILLIS DR\nCross: DANIEL CT & ROGERSVILLE RD\nTimeout: Thu Apr 25 07:45:00 UTC 2013\nInfo: STOVE ON FIRE.  [04/25/13 07:44:55 PETERSONB]\nT (S)WOODLAWN ACRES (N)STA.1
(Incident: 2013024180) \nNature: INJURY VEHICLE ACCIDENT\nAddress: 1199 SUNSET DR/N LOGSDON PKWY\nTimeout: Thu Apr 25 06:55:00 UTC 2013\nInfo: MPOWERS]\nMALE LYING ON THE GROUND OUT SIDE OF THE CAR  [04/25/13 06:55:40\nVEHICLE ON IT  [04/25/13 06:55:05 PETERSONB]\n(S) (N)STA.1
(Incident: 2013024036) \nNature: FIRE ACTIVATED ALARM\nAddress: 424 MAYER LN\nCross: MARY LEE ST & SOUTH BOUNDARY RD\nTimeout: Wed Apr 24 15:03:00 UTC 2013\nInfo: general fire alarm, keyholder pending  [04/24/13 15:03:03 BENNETTK]\n(S) (N)STA.2

*/

public class KYHardinCountyAParserTest extends BaseParserTest {
  
  public KYHardinCountyAParserTest() {
    setParser(new KYHardinCountyParser(), "HARDIN COUNTY", "KY");
  }
  
  @Test
  public void testRineyvilleFireDept() {

    doTest("T1",
        "(Incident: 2013027421) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1022 HUTCHERSON LN\n" +
        "Cross: WOLFE RUN RD & S WILSON RD\n" +
        "Timeout: Wed May 08 15:18:00 UTC 2013\n" +
        "Info: someone  [05/08/13 15:17:15 HENSLEYM]\n" +
        "in front of 1022  77 yr old female having chest pain  adv that they rear  \n" +
        "ended\n" +
        "CS=239 CSS=2 (S)LORIEN (N)",

        "ID:2013027421",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:1022 HUTCHERSON LN",
        "X:WOLFE RUN RD & S WILSON RD",
        "DATE:05/08/2013",
        "TIME:15:18:00",
        "INFO:someone\nin front of 1022  77 yr old female having chest pain  adv that they rear\nended\nCS=239 CSS=2 (S)LORIEN (N)");

    doTest("T2",
        "(Incident: 2013026853) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 200-BLK DECKARD SCHOOL RD\n" +
        "Cross: BELAIRE DR & LISA LN\n" +
        "Timeout: Mon May 06 11:20:00 UTC 2013\n" +
        "Info: roll over accident no injuries  [05/06/13 11:19:13 SJOHNSON]\n" +
        "CS=159 CSS=9 (S) (N)STA.2",

        "ID:2013026853",
        "CALL:FIRE OTHER",
        "ADDR:200-BLK DECKARD SCHOOL RD",
        "MADDR:200 DECKARD SCHOOL RD",
        "X:BELAIRE DR & LISA LN",
        "DATE:05/06/2013",
        "TIME:11:20:00",
        "INFO:roll over accident no injuries\nCS=159 CSS=9 (S) (N)STA.2");

    doTest("T3",
        "(Incident: 2013026796) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 6107 S WILSON RD\n" +
        "Cross: STADIUM DR & BLACK RAVENS CT\n" +
        "Timeout: Mon May 06 02:14:00 UTC 2013\n" +
        "Info: [05/06/13 02:13:43 SEYMOURS]\n" +
        "HAVE AN ISSUE WITH FURNACE, SMELL OF GAS IN THE RESIDENCE\n" +
        "CALLER ADV THAT HER SUB PUMP HAS QUIT WORKING AND THAT MAY\n" +
        "DIST: 364.89 FT",

        "ID:2013026796",
        "CALL:FIRE OTHER",
        "ADDR:6107 S WILSON RD",
        "X:STADIUM DR & BLACK RAVENS CT",
        "DATE:05/06/2013",
        "TIME:02:14:00",
        "INFO:HAVE AN ISSUE WITH FURNACE, SMELL OF GAS IN THE RESIDENCE\nCALLER ADV THAT HER SUB PUMP HAS QUIT WORKING AND THAT MAY\nDIST: 364.89 FT");

    doTest("T4",
        "(Incident: 2013026532) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 1484 HUTCHERSON LN\n" +
        "Cross: BARBARA CIR & WOLFE RUN RD\n" +
        "Timeout: Sat May 04 17:11:00 UTC 2013",

        "ID:2013026532",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:1484 HUTCHERSON LN",
        "X:BARBARA CIR & WOLFE RUN RD",
        "DATE:05/04/2013",
        "TIME:17:11:00");

    doTest("T5",
        "(Incident: 2013026059) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 10642 HARDINSBURG RD\n" +
        "Cross: SALT RIVER RD & TOM DUVALL LN\n" +
        "Timeout: Thu May 02 22:20:00 UTC 2013\n" +
        "Info: MLYDY]\n" +
        "800 and 811 on scene fully involved attic structure fire  [05/02/13 22:20:22\n" +
        "806 805 IN SERV  [05/02/13 22:18:38 MLYDY]\n" +
        "800 IN SERV  [05/02/13 22:17:39 MLYDY]\n" +
        "[05/02/13 22:14:51 CDUNN]\n" +
        "ADVISING BUILDING IS ON FIRE. FLAMES COMING OUT OF ROOF\n" +
        "CS=446 CSS=1",

        "ID:2013026059",
        "CALL:FIRE STRUCTURE",
        "ADDR:10642 HARDINSBURG RD",
        "X:SALT RIVER RD & TOM DUVALL LN",
        "DATE:05/02/2013",
        "TIME:22:20:00",
        "INFO:800 and 811 on scene fully involved attic structure fire\n806 805 IN SERV\n800 IN SERV\nADVISING BUILDING IS ON FIRE. FLAMES COMING OUT OF ROOF\nCS=446 CSS=1");

    doTest("T6",
        "(Incident: 2013025290) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 141 TERESA RD\n" +
        "Cross: BIG WHEEL DR & N DIXIE HWY\n" +
        "Timeout: Mon Apr 29 23:16:00 UTC 2013\n" +
        "Info: {1000} RVFD FOR A TANKER CODE3  [04/29/13 23:16:28 MYERST]\n" +
        "[04/29/13 22:46:36 MYERST]\n" +
        "{1064} WILL BE FILLING UP NEAR JHHS, ALARM MIGHT BE SET OFF\n" +
        "RED CROSS NOTIFIED  [04/29/13 22:42:53 MYERST]\n" +
        "NOLIN HAS BEEN NOTIFIED  [04/29/13 22:11:32 MYERST]\n" +
        "{1000} NOTIFY UTILITY CO.  [04/29/13 22:10:31 MYERST]\n" +
        "UNDERNEATH THE TRAILER  [04/29/13 22:06:13 MLYDY]\n" +
        "AGO, NO ONE IS HOME, DOOR LOCKED, FIRE COMING OUT\n" +
        "[EMS] {SQ5} NIEGHBOR ADV SQ5 THE OCCUPANTS LEFT A FEW HOURS\n" +
        "22:02:46 MJOHNSON]\n" +
        "[EMS] {SQ5} NO VEHICLES IN THE DRIVEWAY AT THIS TIME  [04/29/13\n" +
        "105 10-8 ST.1  [04/29/13 22:02:26 MYERST]\n" +
        "[EMS] {SQ5} FULLY INVOLVED  [04/29/13 22:01:29 MJOHNSON]\n" +
        "100 10-8 ST.1  [04/29/13 22:01:13 MYERST]\n" +
        "103 10-8 ST.1  [04/29/13 21:59:34 MYERST]\n" +
        "vehicles in driveway, believes no one is home  [04/29/13 21:59:17 MLYDY]\n" +
        "Can`t tell color of smoke, lots of smoke coming from house, doesn`t see any\n" +
        "(S) (N)1110",

        "ID:2013025290",
        "CALL:FIRE STRUCTURE",
        "ADDR:141 TERESA RD",
        "X:BIG WHEEL DR & N DIXIE HWY",
        "DATE:04/29/2013",
        "TIME:23:16:00",
        "INFO:{1000} RVFD FOR A TANKER CODE3\n{1064} WILL BE FILLING UP NEAR JHHS, ALARM MIGHT BE SET OFF\nRED CROSS NOTIFIED\nNOLIN HAS BEEN NOTIFIED\n{1000} NOTIFY UTILITY CO.\nUNDERNEATH THE TRAILER\nAGO, NO ONE IS HOME, DOOR LOCKED, FIRE COMING OUT\n[EMS] {SQ5} NIEGHBOR ADV SQ5 THE OCCUPANTS LEFT A FEW HOURS\n[EMS] {SQ5} NO VEHICLES IN THE DRIVEWAY AT THIS TIME\n105 10-8 ST.1\n[EMS] {SQ5} FULLY INVOLVED\n100 10-8 ST.1\n103 10-8 ST.1\nvehicles in driveway, believes no one is home\nCan`t tell color of smoke, lots of smoke coming from house, doesn`t see any\n(S) (N)1110");

    doTest("T7",
        "(Incident: 2013024583) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 2929 RINEYVILLE BIG SPRINGS RD\n" +
        "Cross: ROUNDABOUT & OAKWOOD CT\n" +
        "Timeout: Fri Apr 26 17:03:00 UTC 2013",

        "ID:2013024583",
        "CALL:FIRE OTHER",
        "ADDR:2929 RINEYVILLE BIG SPRINGS RD",
        "X:ROUNDABOUT & OAKWOOD CT",
        "DATE:04/26/2013",
        "TIME:17:03:00");

    doTest("T8",
        "(Incident: 2013024002) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1599 DECKARD SCHOOL RD/RINEYVILLE BIG\n" +
        "Timeout: Wed Apr 24 12:03:00 UTC 2013",

        "ID:2013024002",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:1599 DECKARD SCHOOL RD & RINEYVILLE BIG",
        "MADDR:1599 DECKARD SCHOOL RD",
        "DATE:04/24/2013",
        "TIME:12:03:00");

    doTest("T9",
        "(Incident: 2013023398) \n" +
        "Nature: INJURY\n" +
        "Address: 4483 RINEYVILLE BIG SPRINGS RD\n" +
        "Cross: SAGE CT & RINEYVILLE RD\n" +
        "Timeout: Sun Apr 21 12:24:00 UTC 2013\n" +
        "Info: fell on coffee table  [04/21/13 12:22:25 LEOM]\n" +
        "unable to get bleeding to stop  [04/21/13 12:21:37 LEOM]\n" +
        "LEOM]\n" +
        "bleeding from  wrist, 37 y/o male  chevy, malbu sliver  [04/21/13 12:20:39\n" +
        "CS=141 CSS=7 DIST: 22.96 FT",

        "ID:2013023398",
        "CALL:INJURY",
        "ADDR:4483 RINEYVILLE BIG SPRINGS RD",
        "X:SAGE CT & RINEYVILLE RD",
        "DATE:04/21/2013",
        "TIME:12:24:00",
        "INFO:fell on coffee table\nunable to get bleeding to stop\nbleeding from  wrist, 37 y/o male  chevy, malbu sliver\nCS=141 CSS=7 DIST: 22.96 FT");

    doTest("T10",
        "(Incident: 2013023322) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 906 THOMPSON RD\n" +
        "Cross: MCDREAMY CT & MASAKO CT\n" +
        "Timeout: Sat Apr 20 22:58:00 UTC 2013\n" +
        "Info: ADV  [04/20/13 22:38:27 HENSLEYM]\n" +
        "ELEC IS OFF AT A RESIDENCE ADV POLE # 42827 I CALLED NOLIN AND\n" +
        "962 ADV TO NOTIFY ELEC CO ADV THAT THE BUS HIT A POLE AND\n" +
        "ky  [04/20/13 22:27:27 LEOM]\n" +
        "[04/20/13 22:20:47 CDUNN]\n" +
        "RECKLESS. BUS #80. UNITS LOOKING FOR BUS AS POSSIBLE SUBJECT.\n" +
        "3356 THOMAS RD. RECEIVED 911 CALL OF SCHOOL BUS DRIVING\n" +
        "stolen from residence, poss passed  [04/20/13 21:03:10 LEOM]\n" +
        "209 IN COMMAND  [04/20/13 21:03:04 HENSLEYM]\n" +
        "2012 blk  crystal 300  [04/20/13 21:01:26 LEOM]\n" +
        "STEPHANIE IS DOWN THE STREET WAITING.  [04/20/13 20:41:09 CDUNN]\n" +
        "HAVE CONTACT WITH HER.  [04/20/13 20:37:43 CDUNN]\n" +
        "AGAINST HER. HER DAUGHTER IS HOME AND IS NOT SUPPOSE TO\n" +
        "COURTNEY ROBERTS IS AT HER HOUSE RIGHT NOW. HAS AN EPO OUT\n" +
        "22:58:25 HENSLEYM]\n" +
        "Event spawned from POLICE CRIME AGAINST PEOPLE.  [04/20/2013\n" +
        "(S)OSBORNE TRACE (N)",

        "ID:2013023322",
        "CALL:FIRE OTHER",
        "ADDR:906 THOMPSON RD",
        "X:MCDREAMY CT & MASAKO CT",
        "DATE:04/20/2013",
        "TIME:22:58:00",
        "INFO:ADV\nELEC IS OFF AT A RESIDENCE ADV POLE # 42827 I CALLED NOLIN AND\n962 ADV TO NOTIFY ELEC CO ADV THAT THE BUS HIT A POLE AND\nky\nRECKLESS. BUS #80. UNITS LOOKING FOR BUS AS POSSIBLE SUBJECT.\n3356 THOMAS RD. RECEIVED 911 CALL OF SCHOOL BUS DRIVING\nstolen from residence, poss passed\n209 IN COMMAND\n2012 blk  crystal 300\nSTEPHANIE IS DOWN THE STREET WAITING.\nHAVE CONTACT WITH HER.\nAGAINST HER. HER DAUGHTER IS HOME AND IS NOT SUPPOSE TO\nCOURTNEY ROBERTS IS AT HER HOUSE RIGHT NOW. HAS AN EPO OUT\nEvent spawned from POLICE CRIME AGAINST PEOPLE.\n(S)OSBORNE TRACE (N)");

    doTest("T11",
        "(Incident: 2013022145) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 76 CARROLL AVE\n" +
        "Cross: DILLARD AVE & RINEYVILLE BLVD\n" +
        "Timeout: Mon Apr 15 20:54:00 UTC 2013\n" +
        "Info: MYERST]\n" +
        "AND A CHILD. UNKNOWN TYPE OF INJURIES.  [04/15/13 20:54:19\n" +
        "CALLER ADVISED OF A VEHICLE ACCIDENT, HIT AND RUN. 1 FEMALE\n" +
        "(S)BLACKBURN ESTATES (N)",

        "ID:2013022145",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:76 CARROLL AVE",
        "X:DILLARD AVE & RINEYVILLE BLVD",
        "DATE:04/15/2013",
        "TIME:20:54:00",
        "INFO:AND A CHILD. UNKNOWN TYPE OF INJURIES.\nCALLER ADVISED OF A VEHICLE ACCIDENT, HIT AND RUN. 1 FEMALE\n(S)BLACKBURN ESTATES (N)");

    doTest("T12",
        "(Incident: 2013021921) \n" +
        "Nature: FIRE/SMOKE/ODOR COMPLAINT\n" +
        "Address: 440 CARROLL AVE\n" +
        "Cross: DILLARD AVE\n" +
        "Timeout: Sun Apr 14 20:42:00 UTC 2013\n" +
        "Info: no one is around this burn, it keeps flaring up  [04/14/13 20:41:39  \n" +
        "MLYDY]\n" +
        "(S)BLACKBURN ESTATES (N)",

        "ID:2013021921",
        "CALL:FIRE/SMOKE/ODOR COMPLAINT",
        "ADDR:440 CARROLL AVE",
        "X:DILLARD AVE",
        "DATE:04/14/2013",
        "TIME:20:42:00",
        "INFO:no one is around this burn, it keeps flaring up\n(S)BLACKBURN ESTATES (N)");

    doTest("T13",
        "(Incident: 2013021778) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1051 RINEYVILLE SCHOOL RD\n" +
        "Cross: FLUSHING MEADOWS DR & LAVISTA DR\n" +
        "Timeout: Sun Apr 14 05:29:00 UTC 2013",

        "ID:2013021778",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:1051 RINEYVILLE SCHOOL RD",
        "X:FLUSHING MEADOWS DR & LAVISTA DR",
        "DATE:04/14/2013",
        "TIME:05:29:00");

    doTest("T14",
        "(Incident: 2013021729) \n" +
        "Nature: FIRE GRASS WOODS\n" +
        "Address: 400-BLK CARROLL AVE\n" +
        "Cross: DILLARD AVE\n" +
        "Timeout: Sat Apr 13 21:27:00 UTC 2013\n" +
        "Info: Has a really bad smell to it  [04/13/13 21:26:03 MLYDY]\n" +
        "MLYDY]\n" +
        "people are burning torn down home, and trash in this area  [04/13/13  \n" +
        "21:25:41\n" +
        "CS=141 CSS=8  (S)BLACKBURN ESTATES (N)",

        "ID:2013021729",
        "CALL:FIRE GRASS WOODS",
        "ADDR:400-BLK CARROLL AVE",
        "MADDR:400 CARROLL AVE",
        "X:DILLARD AVE",
        "DATE:04/13/2013",
        "TIME:21:27:00",
        "INFO:Has a really bad smell to it\npeople are burning torn down home, and trash in this area\nCS=141 CSS=8  (S)BLACKBURN ESTATES (N)");

    doTest("T15",
        "(Incident: 2013020882) \n" +
        "Nature: FIRE GRASS WOODS\n" +
        "Address: 20 MUSTANG LN\n" +
        "Cross: RUNNING BEAR TR & BOONE RD\n" +
        "Timeout: Wed Apr 10 15:13:00 UTC 2013\n" +
        "Info: NICHOLSG]\n" +
        "caller adv that the woods are on fire with trailer in danger.  [04/10/13  \n" +
        "15:12:40\n" +
        "(S)SUN AND FUN (N)",

        "ID:2013020882",
        "CALL:FIRE GRASS WOODS",
        "ADDR:20 MUSTANG LN",
        "X:RUNNING BEAR TR & BOONE RD",
        "DATE:04/10/2013",
        "TIME:15:13:00",
        "INFO:caller adv that the woods are on fire with trailer in danger.\n(S)SUN AND FUN (N)");

    doTest("T16",
        "(Incident: 2013020814) \n" +
        "Nature: ALARM TEST\n" +
        "Address: 10503 RINEYVILLE BIG SPRINGS RD\n" +
        "Cross: SALT RIVER RD & HARRIS SCHOOL RD\n" +
        "Timeout: Wed Apr 10 10:24:00 UTC 2013",

        "ID:2013020814",
        "CALL:ALARM TEST",
        "ADDR:10503 RINEYVILLE BIG SPRINGS RD",
        "X:SALT RIVER RD & HARRIS SCHOOL RD",
        "DATE:04/10/2013",
        "TIME:10:24:00");

    doTest("T17",
        "(Incident: 2013020532) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 8998 RINEYVILLE RD/OWSLEY RD\n" +
        "Timeout: Tue Apr 09 06:07:00 UTC 2013\n" +
        "Info: female with neck pain  [04/09/13 06:06:59 MPOWERS]\n" +
        "CS=378 CSS=3",

        "ID:2013020532",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:8998 RINEYVILLE RD & OWSLEY RD",
        "MADDR:8998 RINEYVILLE RD",
        "DATE:04/09/2013",
        "TIME:06:07:00",
        "INFO:female with neck pain\nCS=378 CSS=3");

    doTest("T18",
        "(Incident: 2013020525) \n" +
        "Nature: CARDIAC ARREST\n" +
        "Address: 110 TOMAHAWK TR\n" +
        "Cross: COCHISE CT & PINTO TR\n" +
        "Timeout: Tue Apr 09 02:47:00 UTC 2013\n" +
        "Info: 78 female  [04/09/13 02:46:51 MPOWERS]\n" +
        "(S)SUN AND FUN (N)",

        "ID:2013020525",
        "CALL:CARDIAC ARREST",
        "ADDR:110 TOMAHAWK TR",
        "X:COCHISE CT & PINTO TR",
        "DATE:04/09/2013",
        "TIME:02:47:00",
        "INFO:78 female\n(S)SUN AND FUN (N)");

    doTest("T19",
        "(Incident: 2013020145) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 3106 BURNS RD\n" +
        "Cross: GENROSE DR & WARREN DR\n" +
        "Timeout: Sun Apr 07 11:15:00 UTC 2013\n" +
        "Info: NHELTON]\n" +
        "hallway smoke detecter, no keyholder contacted yet  [04/07/13 11:15:12\n" +
        "(S)ABERDEEN ESTATES (N)",

        "ID:2013020145",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:3106 BURNS RD",
        "X:GENROSE DR & WARREN DR",
        "DATE:04/07/2013",
        "TIME:11:15:00",
        "INFO:hallway smoke detecter, no keyholder contacted yet\n(S)ABERDEEN ESTATES (N)");

    doTest("T20",
        "(Incident: 2013020052) \n" +
        "Nature: FIRE/SMOKE/ODOR COMPLAINT\n" +
        "Address: 360 SCHLAEFER WAY\n" +
        "Cross: RINEYVILLE RD\n" +
        "Timeout: Sat Apr 06 21:22:00 UTC 2013\n" +
        "Info: kids poss having a  bon file,  [04/06/13 21:20:03 LEOM]\n" +
        "(S)BRYAN ACRES (N)",

        "ID:2013020052",
        "CALL:FIRE/SMOKE/ODOR COMPLAINT",
        "ADDR:360 SCHLAEFER WAY",
        "X:RINEYVILLE RD",
        "DATE:04/06/2013",
        "TIME:21:22:00",
        "INFO:kids poss having a  bon file,\n(S)BRYAN ACRES (N)");

    doTest("T21",
        "(Incident: 2013020050) \n" +
        "Nature: FIRE GRASS WOODS\n" +
        "Address: 440 CARROLL AVE\n" +
        "Cross: DILLARD AVE\n" +
        "Timeout: Sat Apr 06 21:00:00 UTC 2013\n" +
        "Info: FIRE HAS STARTED BACK UP.  [04/06/13 20:59:46 CDUNN]\n" +
        "CS=141 CSS=8 (S)BLACKBURN ESTATES (N)",

        "ID:2013020050",
        "CALL:FIRE GRASS WOODS",
        "ADDR:440 CARROLL AVE",
        "X:DILLARD AVE",
        "DATE:04/06/2013",
        "TIME:21:00:00",
        "INFO:FIRE HAS STARTED BACK UP.\nCS=141 CSS=8 (S)BLACKBURN ESTATES (N)");

    doTest("T22",
        "(Incident: 2013019998) \n" +
        "Nature: FIRE/SMOKE/ODOR COMPLAINT\n" +
        "Address: 498 CARROLL AVE\n" +
        "Cross: DILLARD AVE\n" +
        "Timeout: Sat Apr 06 16:50:00 UTC 2013\n" +
        "Info: possible illegal burn  [04/06/13 16:50:30 HENSLEYM]\n" +
        "(S)BLACKBURN ESTATES (N)",

        "ID:2013019998",
        "CALL:FIRE/SMOKE/ODOR COMPLAINT",
        "ADDR:498 CARROLL AVE",
        "X:DILLARD AVE",
        "DATE:04/06/2013",
        "TIME:16:50:00",
        "INFO:possible illegal burn\n(S)BLACKBURN ESTATES (N)");

    doTest("T23",
        "(Incident: 2013019932) \n" +
        "Nature: FIRE GRASS WOODS\n" +
        "Address: 14547 SAINT JOHN RD\n" +
        "Cross: TURKEY ROOST LN & SALT RIVER RD\n" +
        "Timeout: Sat Apr 06 13:37:00 UTC 2013\n" +
        "Info: 800 adv put RVFD on stby  [04/06/13 13:37:11 SJOHNSON]\n" +
        "THE WIND HAS PICKED UP  [04/06/13 13:35:46 NICHOLSG]\n" +
        "RCVD SECOND CALL ADV THAT FIRE IS GETTING WORSE BECAUSE\n" +
        "800 RESPONDING TO THE SCENE  [04/06/13 13:34:20 MJOHNSON]\n" +
        "810 10-8  [04/06/13 13:33:03 MJOHNSON]\n" +
        "803 10-8  [04/06/13 13:32:38 MJOHNSON]\n" +
        "800 10-8  [04/06/13 13:31:30 MJOHNSON]\n" +
        "804 10-8  [04/06/13 13:30:53 MJOHNSON]\n" +
        "STRUCTURES IN DANGER AT THIS TIME  [04/06/13 13:27:10 MJOHNSON]\n" +
        "WAS HAVING A CONTROL BURN FIRE IS NOW OUT OF CONTROL. NO\n" +
        "CS=298 CSS=3 DIST: 583.28 FT",

        "ID:2013019932",
        "CALL:FIRE GRASS WOODS",
        "ADDR:14547 SAINT JOHN RD",
        "X:TURKEY ROOST LN & SALT RIVER RD",
        "DATE:04/06/2013",
        "TIME:13:37:00",
        "INFO:800 adv put RVFD on stby\nTHE WIND HAS PICKED UP\nRCVD SECOND CALL ADV THAT FIRE IS GETTING WORSE BECAUSE\n800 RESPONDING TO THE SCENE\n810 10-8\n803 10-8\n800 10-8\n804 10-8\nSTRUCTURES IN DANGER AT THIS TIME\nWAS HAVING A CONTROL BURN FIRE IS NOW OUT OF CONTROL. NO\nCS=298 CSS=3 DIST: 583.28 FT");

    doTest("T24",
        "(Incident: 2013018974) \n" +
        "Nature: FIRE GRASS WOODS\n" +
        "Address: 8510 RINEYVILLE RD\n" +
        "Cross: OWSLEY RD & FLETCHER CT\n" +
        "Timeout: Tue Apr 02 11:35:00 UTC 2013\n" +
        "Info: SJOHNSON]\n" +
        "was having a control burn that is out of control  [04/02/13 11:35:23\n" +
        "DIST: 365.78 FT",

        "ID:2013018974",
        "CALL:FIRE GRASS WOODS",
        "ADDR:8510 RINEYVILLE RD",
        "X:OWSLEY RD & FLETCHER CT",
        "DATE:04/02/2013",
        "TIME:11:35:00",
        "INFO:was having a control burn that is out of control\nDIST: 365.78 FT");

    doTest("T25",
        "(Incident: 2013018167) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 275 RINEYVILLE SCHOOL RD\n" +
        "Cross: STITH LN & PERKINS LN\n" +
        "Timeout: Fri Mar 29 16:01:00 UTC 2013\n" +
        "Info: MJOHNSON]\n" +
        "DIFF BREATHING. GO TO THE FRONT DOOR.  [03/29/13 15:59:30\n" +
        "IN THE LIBRARY, 42 YO FEMALE NOT FEELING WELL. IN/OUT CONS,\n" +
        "CS=141 CSS=2",

        "ID:2013018167",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:275 RINEYVILLE SCHOOL RD",
        "X:STITH LN & PERKINS LN",
        "DATE:03/29/2013",
        "TIME:16:01:00",
        "INFO:DIFF BREATHING. GO TO THE FRONT DOOR.\nIN THE LIBRARY, 42 YO FEMALE NOT FEELING WELL. IN/OUT CONS,\nCS=141 CSS=2");

    doTest("T26",
        "(Incident: 2013017635) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 217 COCHISE CT\n" +
        "Cross: PINTO TR & TEE PEE RD\n" +
        "Timeout: Wed Mar 27 00:16:00 UTC 2013\n" +
        "Info: 63 female unres. not breathing normal  [03/27/13 00:15:47 MPOWERS]\n" +
        "(S)SUN AND FUN (N)",

        "ID:2013017635",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:217 COCHISE CT",
        "X:PINTO TR & TEE PEE RD",
        "DATE:03/27/2013",
        "TIME:00:16:00",
        "INFO:63 female unres. not breathing normal\n(S)SUN AND FUN (N)");

    doTest("T27",
        "(Incident: 2013017404) \n" +
        "Nature: ACTIVATED MEDICAL ALARM\n" +
        "Address: 4417 RINEYVILLE RD\n" +
        "Cross: BRADLEY TR & TIMBERLINE TR\n" +
        "Timeout: Mon Mar 25 19:23:00 UTC 2013",

        "ID:2013017404",
        "CALL:ACTIVATED MEDICAL ALARM",
        "ADDR:4417 RINEYVILLE RD",
        "X:BRADLEY TR & TIMBERLINE TR",
        "DATE:03/25/2013",
        "TIME:19:23:00");

    doTest("T28",
        "(Incident: 2013017293) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 313 OAKWOOD CIR\n" +
        "Cross: HILLVIEW DR\n" +
        "Timeout: Mon Mar 25 09:00:00 UTC 2013\n" +
        "Info: Flue Fire  [03/25/13 08:59:39 LCORDERO]\n" +
        "(S)COUNTRY MEADOWS ESTATE (N)",

        "ID:2013017293",
        "CALL:FIRE STRUCTURE",
        "ADDR:313 OAKWOOD CIR",
        "X:HILLVIEW DR",
        "DATE:03/25/2013",
        "TIME:09:00:00",
        "INFO:Flue Fire\n(S)COUNTRY MEADOWS ESTATE (N)");

    doTest("T29",
        "(Incident: 2013017285) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 132 HICKORY HILL DR\n" +
        "Cross: E AIRVIEW DR & W AIRVIEW DR\n" +
        "Timeout: Mon Mar 25 07:54:00 UTC 2013\n" +
        "Info: 105 STA 1 I/S  [03/25/13 07:52:51 SEYMOURS]\n" +
        "106 STA 2 I/S  [03/25/13 07:51:21 SEYMOURS]\n" +
        "[EMS] {SQ1} OK ON PAGE  [03/25/13 07:49:49 PETERSONB]\n" +
        "HOUSE ON FIRE. EVERYONE EVACED  [03/25/13 07:48:58 PETERSONB]\n" +
        "CS=259 CSS=1  (S) (N)1120",

        "ID:2013017285",
        "CALL:FIRE STRUCTURE",
        "ADDR:132 HICKORY HILL DR",
        "X:E AIRVIEW DR & W AIRVIEW DR",
        "DATE:03/25/2013",
        "TIME:07:54:00",
        "INFO:105 STA 1 I/S\n106 STA 2 I/S\n[EMS] {SQ1} OK ON PAGE\nHOUSE ON FIRE. EVERYONE EVACED\nCS=259 CSS=1  (S) (N)1120");

    doTest("T30",
        "(Incident: 2013017136) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 132 E PIEDMONT DR\n" +
        "Cross: N RUSHMORE DR & E TWIN LAKES DR\n" +
        "Timeout: Sun Mar 24 08:47:00 UTC 2013\n" +
        "Info: SJOHNSON]\n" +
        "caller adv can smell something buring and see smoke  [03/24/13 08:47:02\n" +
        "CS=141 CSS=7 (S)HIGHLAND SPRINGS (N)",

        "ID:2013017136",
        "CALL:FIRE STRUCTURE",
        "ADDR:132 E PIEDMONT DR",
        "X:N RUSHMORE DR & E TWIN LAKES DR",
        "DATE:03/24/2013",
        "TIME:08:47:00",
        "INFO:caller adv can smell something buring and see smoke\nCS=141 CSS=7 (S)HIGHLAND SPRINGS (N)");

  }
  
  @Test
  public void testRadcliffFire() {

    doTest("T1",
        "(Incident: 2013027760) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 245 ELMWOOD DR\n" +
        "Cross: ELM RD\n" +
        "Timeout: Fri May 10 01:33:00 UTC 2013\n" +
        "Info: 01:32:58 SEYMOURS]\n" +
        "BURNING FROM THIS APT AND FIRE ALARM GOING OFF  [05/10/13\n" +
        "APT ACROSS FROM CALLER ADV THAT HE SMELLS SOMETHING\n" +
        "APT 507  CS=159 CSS=9 DIST: 8.76 FT  (S)",

        "ID:2013027760",
        "CALL:FIRE STRUCTURE",
        "ADDR:245 ELMWOOD DR",
        "X:ELM RD",
        "DATE:05/10/2013",
        "TIME:01:33:00",
        "INFO:BURNING FROM THIS APT AND FIRE ALARM GOING OFF\nAPT ACROSS FROM CALLER ADV THAT HE SMELLS SOMETHING\nAPT 507  CS=159 CSS=9 DIST: 8.76 FT  (S)");

    doTest("T2",
        "(Incident: 2013027628) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 9 JOE PRATHER HWY/S DIXIE BLVD\n" +
        "Timeout: Thu May 09 13:20:00 UTC 2013\n" +
        "Info: SJOHNSON]\n" +
        "2 vehicle accident adult male with injuries unknown extent  [05/09/13  \n" +
        "13:19:52\n" +
        "DIST: 393.63 FT (S) (N)STA.2",

        "ID:2013027628",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:9 JOE PRATHER HWY & S DIXIE BLVD",
        "MADDR:9 JOE PRATHER HWY",
        "DATE:05/09/2013",
        "TIME:13:20:00",
        "INFO:2 vehicle accident adult male with injuries unknown extent\nDIST: 393.63 FT (S) (N)STA.2");

    doTest("T3",
        "(Incident: 2013027251) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 119 ACADEMY LN\n" +
        "Cross: W CROCUS DR & W VINE ST\n" +
        "Timeout: Tue May 07 19:30:00 UTC 2013\n" +
        "Info: WILL NOT SHOW UP.  [05/07/13 19:30:08 MYERST]\n" +
        "ZONE: HALLWAY SMOKE DETEC. KEY HOLDER IS NOT HOME,  AND\n" +
        "(S) (N)STA.1",

        "ID:2013027251",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:119 ACADEMY LN",
        "X:W CROCUS DR & W VINE ST",
        "DATE:05/07/2013",
        "TIME:19:30:00",
        "INFO:WILL NOT SHOW UP.\nZONE: HALLWAY SMOKE DETEC. KEY HOLDER IS NOT HOME,  AND\n(S) (N)STA.1");

    doTest("T4",
        "(Incident: 2013027238) \n" +
        "Nature: FIRE/SMOKE/ODOR COMPLAINT\n" +
        "Address: 1117 HILL ST\n" +
        "Cross: EVELYN DR & CARTER DR\n" +
        "Timeout: Tue May 07 18:36:00 UTC 2013\n" +
        "Info: GAS LINE STRUCK, LG&amp;E 30 MIN ETA  [05/07/13 18:35:43 MYERST]\n" +
        "(S) (N)STA.1",

        "ID:2013027238",
        "CALL:FIRE/SMOKE/ODOR COMPLAINT",
        "ADDR:1117 HILL ST",
        "X:EVELYN DR & CARTER DR",
        "DATE:05/07/2013",
        "TIME:18:36:00",
        "INFO:GAS LINE STRUCK, LG&E 30 MIN ETA\n(S) (N)STA.1");

    doTest("T5",
        "(Incident: 2013027139) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 699 S WOODLAND DR/W VINE ST\n" +
        "Timeout: Tue May 07 12:10:00 UTC 2013\n" +
        "Info: NHELTON]\n" +
        "36 yo male, complaining of neck pain, RPD on scene  [05/07/13 12:09:51\n" +
        "Vehicle accident. unknown injuries  [05/07/13 12:05:01 LCORDERO]\n" +
        "(S) (N)STA.1",

        "ID:2013027139",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:699 S WOODLAND DR & W VINE ST",
        "MADDR:699 S WOODLAND DR",
        "DATE:05/07/2013",
        "TIME:12:10:00",
        "INFO:36 yo male, complaining of neck pain, RPD on scene\nVehicle accident. unknown injuries\n(S) (N)STA.1");

    doTest("T6",
        "(Incident: 2013027082) \n" +
        "Nature: UNRESPON W/NORMAL BREATHING\n" +
        "Address: 238 INDIANA TR\n" +
        "Cross: E LINCOLN TRAIL BLVD & E LINCOLN TRAIL BLVD\n" +
        "Timeout: Tue May 07 08:35:00 UTC 2013\n" +
        "Info: {SQ5} REQUESTING FIRE CODE 3  [05/07/13 08:35:20 GRIFFISM]\n" +
        "NOT SURE WHAT IS GOING ON.  [05/07/13 08:23:55 NICHOLSG]\n" +
        "THE BACKGROUND.  [05/07/13 08:23:35 NICHOLSG]\n" +
        "CALLER ADV THAT 43 YO MALE IS NOT WAKING UP.  IS MOANING IN\n" +
        "(S)LINCOLN TRAIL ACRES (N)STA.1",

        "ID:2013027082",
        "CALL:UNRESPON W/NORMAL BREATHING",
        "ADDR:238 INDIANA TR",
        "X:E LINCOLN TRAIL BLVD & E LINCOLN TRAIL BLVD",
        "DATE:05/07/2013",
        "TIME:08:35:00",
        "INFO:{SQ5} REQUESTING FIRE CODE 3\nNOT SURE WHAT IS GOING ON.\nTHE BACKGROUND.\nCALLER ADV THAT 43 YO MALE IS NOT WAKING UP.  IS MOANING IN\n(S)LINCOLN TRAIL ACRES (N)STA.1");

    doTest("T7",
        "(Incident: 2013026819) \n" +
        "Nature: BREATHING DIFFICULTY\n" +
        "Address: 1145 N LOGSDON PKWY\n" +
        "Cross: RED HILL RD & MULBERRY ST\n" +
        "Timeout: Mon May 06 08:41:00 UTC 2013\n" +
        "Info: {SQ2} SEND FIRE CODE 3  [05/06/13 08:41:06 LCORDERO]\n" +
        "semi-responsive. will not stay awake.  [05/06/13 08:33:11 LCORDERO]\n" +
        "67 yo f,  D/B. 75% with 02.  [05/06/13 08:32:43 LCORDERO]\n" +
        "DIST: 77.12 FT (S) (N)STA.1",

        "ID:2013026819",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:1145 N LOGSDON PKWY",
        "X:RED HILL RD & MULBERRY ST",
        "DATE:05/06/2013",
        "TIME:08:41:00",
        "INFO:{SQ2} SEND FIRE CODE 3\nsemi-responsive. will not stay awake.\n67 yo f,  D/B. 75% with 02.\nDIST: 77.12 FT (S) (N)STA.1");

    doTest("T8",
        "(Incident: 2013026768) \n" +
        "Nature: DIABETIC EMERGENCY\n" +
        "Address: 1044 S WOODLAND DR\n" +
        "Cross: CYNTHIA CT & CAROLYN ST\n" +
        "Timeout: Sun May 05 20:46:00 UTC 2013\n" +
        "Info: 20:45:01 MJOHNSON]\n" +
        "21 YO FEMALE ADV BS IS HIGH VOMMITING. DIFF BREATHING  [05/05/13\n" +
        "DIST: 99.48 FT (S)WOODLAWN ACRES",

        "ID:2013026768",
        "CALL:DIABETIC EMERGENCY",
        "ADDR:1044 S WOODLAND DR",
        "X:CYNTHIA CT & CAROLYN ST",
        "DATE:05/05/2013",
        "TIME:20:46:00",
        "INFO:21 YO FEMALE ADV BS IS HIGH VOMMITING. DIFF BREATHING\nDIST: 99.48 FT (S)WOODLAWN ACRES");

    doTest("T9",
        "(Incident: 2013026765) \n" +
        "Nature: SEIZURE\n" +
        "Address: 1626 W CROCUS DR\n" +
        "Cross: S LORRAINE ST & ANDERSON CT\n" +
        "Timeout: Sun May 05 20:38:00 UTC 2013\n" +
        "Info: MYERST]\n" +
        "[SQ5-TRANSPORT] {SQ5} CODE3, NEED DRIVER  [05/05/13 20:38:20\n" +
        "HX Brain surgery  [05/05/13 20:24:37 LEOM]\n" +
        "gasping, foaming at mouth  [05/05/13 20:24:16 LEOM]\n" +
        "poss having a seizure, 6 y/o male  [05/05/13 20:23:14 LEOM]\n" +
        "(S) (N)STA.1",

        "ID:2013026765",
        "CALL:SEIZURE",
        "ADDR:1626 W CROCUS DR",
        "X:S LORRAINE ST & ANDERSON CT",
        "DATE:05/05/2013",
        "TIME:20:38:00",
        "INFO:[SQ5-TRANSPORT] {SQ5} CODE3, NEED DRIVER\nHX Brain surgery\ngasping, foaming at mouth\nposs having a seizure, 6 y/o male\n(S) (N)STA.1");

    doTest("T10",
        "(Incident: 2013026746) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 350 SNYDER WAY\n" +
        "Cross: N LOGSDON PKWY\n" +
        "Timeout: Sun May 05 18:49:00 UTC 2013\n" +
        "Info: [05/05/13 18:49:36 MYERST]\n" +
        "ZONE: GENERAL ALARM, KEY HOLDER HAS NOT BEEN NOTIFIED.\n" +
        "(S) (N)STA.1",

        "ID:2013026746",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:350 SNYDER WAY",
        "X:N LOGSDON PKWY",
        "DATE:05/05/2013",
        "TIME:18:49:00",
        "INFO:ZONE: GENERAL ALARM, KEY HOLDER HAS NOT BEEN NOTIFIED.\n(S) (N)STA.1");

    doTest("T11",
        "(Incident: 2013026628) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1 N DIXIE HWY/MASTERS DR\n" +
        "Timeout: Sun May 05 01:25:00 UTC 2013\n" +
        "Info: MALE WITH HAND AND NECKPAIN.  [05/05/13 01:25:01 PETERSONB]\n" +
        "NON INJURY ACCIDENT  [05/05/13 01:02:37 PETERSONB]\n" +
        "CS=159 CSS=9 DIST: 26.89 FT  (S) (N)STA.2",

        "ID:2013026628",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:N DIXIE HWY & MASTERS DR",
        "DATE:05/05/2013",
        "TIME:01:25:00",
        "INFO:MALE WITH HAND AND NECKPAIN.\nNON INJURY ACCIDENT\nCS=159 CSS=9 DIST: 26.89 FT  (S) (N)STA.2");

    doTest("T12",
        "(Incident: 2013026588) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 836 BRIARGATE CT\n" +
        "Cross: W VINE ST\n" +
        "Timeout: Sat May 04 20:41:00 UTC 2013\n" +
        "Info: MJOHNSON]\n" +
        "70-80 FEMALE SEMI CONS, DIFF BREATHING.  [05/04/13 20:40:54\n" +
        "(S) (N)STA.1",

        "ID:2013026588",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:836 BRIARGATE CT",
        "X:W VINE ST",
        "DATE:05/04/2013",
        "TIME:20:41:00",
        "INFO:70-80 FEMALE SEMI CONS, DIFF BREATHING.\n(S) (N)STA.1");

    doTest("T13",
        "(Incident: 2013026473) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 105 WAYNE WAY\n" +
        "Cross: S WOODLAND DR & BYERLY BLVD\n" +
        "Timeout: Sat May 04 13:39:00 UTC 2013\n" +
        "Info: CO alarm zone 22  [05/04/13 13:39:11 SJOHNSON]\n" +
        "Fire alarm zone 21\n" +
        "(S)HILLTOP TERRACE (N)STA.2",

        "ID:2013026473",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:105 WAYNE WAY",
        "X:S WOODLAND DR & BYERLY BLVD",
        "DATE:05/04/2013",
        "TIME:13:39:00",
        "INFO:CO alarm zone 22\nFire alarm zone 21\n(S)HILLTOP TERRACE (N)STA.2");

    doTest("T14",
        "(Incident: 2013026391) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 599 ROGERSVILLE RD\n" +
        "Cross: SHELTON RD & WILLIS DR\n" +
        "Timeout: Sat May 04 00:09:00 UTC 2013\n" +
        "Info: [05/04/13 00:08:44 PETERSONB]\n" +
        "PT WALLCE MOFA F BLLEEDING FROM FACE. CON UNKNOWN.\n" +
        "5 E BED2 (S) (N)STA.1",

        "ID:2013026391",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:599 ROGERSVILLE RD",
        "X:SHELTON RD & WILLIS DR",
        "DATE:05/04/2013",
        "TIME:00:09:00",
        "INFO:PT WALLCE MOFA F BLLEEDING FROM FACE. CON UNKNOWN.\n5 E BED2 (S) (N)STA.1");

    doTest("T15",
        "(Incident: 2013026298) \n" +
        "Nature: DIABETIC EMERGENCY\n" +
        "Address: 1165 WALMART WAY\n" +
        "Cross: N WILSON RD & N DIXIE BLVD\n" +
        "Timeout: Fri May 03 18:19:00 UTC 2013\n" +
        "Info: IS CONS/SHAKING A LITTLE.  [05/03/13 18:17:43 MJOHNSON]\n" +
        "RED VEHICLE. WILL WAVE DOWN EMS.  [05/03/13 18:17:37 MJOHNSON]\n" +
        "18:17:18 MJOHNSON]\n" +
        "DIB EMERGENCY. HAS HAD OJ AND CANDY DOING BETTER.  [05/03/13\n" +
        "63 YO MALE IN PARKING LOT. ISLE 4 AT THE END BY GAS PUMPS. POSS\n" +
        "(S) (N)STA.1",

        "ID:2013026298",
        "CALL:DIABETIC EMERGENCY",
        "ADDR:1165 WALMART WAY",
        "X:N WILSON RD & N DIXIE BLVD",
        "DATE:05/03/2013",
        "TIME:18:19:00",
        "INFO:IS CONS/SHAKING A LITTLE.\nRED VEHICLE. WILL WAVE DOWN EMS.\nDIB EMERGENCY. HAS HAD OJ AND CANDY DOING BETTER.\n63 YO MALE IN PARKING LOT. ISLE 4 AT THE END BY GAS PUMPS. POSS\n(S) (N)STA.1");

    doTest("T16",
        "(Incident: 2013026266) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1 LAKE RD/S WILSON RD\n" +
        "Timeout: Fri May 03 17:20:00 UTC 2013\n" +
        "Info: possible injuries  [05/03/13 17:20:31 MLYDY]\n" +
        "CS=249 CSS=5 (S) (N)STA.2",

        "ID:2013026266",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:LAKE RD & S WILSON RD",
        "DATE:05/03/2013",
        "TIME:17:20:00",
        "INFO:possible injuries\nCS=249 CSS=5 (S) (N)STA.2");

    doTest("T17",
        "(Incident: 2013026074) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 109 HAMILTON ST\n" +
        "Cross: FRANKLIN ST & WAGON WHEEL TR\n" +
        "Timeout: Thu May 02 23:36:00 UTC 2013\n" +
        "Info: MYERST]\n" +
        "55 Y/O MALE UNRESPONSIVE, DIFF BREATHING.  [05/02/13 23:36:18\n" +
        "(S)WHISPERING HILLS (N)STA.2",

        "ID:2013026074",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:109 HAMILTON ST",
        "X:FRANKLIN ST & WAGON WHEEL TR",
        "DATE:05/02/2013",
        "TIME:23:36:00",
        "INFO:55 Y/O MALE UNRESPONSIVE, DIFF BREATHING.\n(S)WHISPERING HILLS (N)STA.2");

    doTest("T18",
        "(Incident: 2013025755) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 936 W VINE ST/S LOGSDON PKWY\n" +
        "Timeout: Wed May 01 18:55:00 UTC 2013\n" +
        "Info: PT TRAPPED IN THE CAR  [05/01/13 18:55:13 MJOHNSON]\n" +
        "air bag deployed, hit tree.  [05/01/13 18:54:58 MLYDY]\n" +
        "CS=200 CSS=3 DIST: 24.84 FT (S) (N)STA.1",

        "ID:2013025755",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:936 W VINE ST & S LOGSDON PKWY",
        "MADDR:936 W VINE ST",
        "DATE:05/01/2013",
        "TIME:18:55:00",
        "INFO:PT TRAPPED IN THE CAR\nair bag deployed, hit tree.\nCS=200 CSS=3 DIST: 24.84 FT (S) (N)STA.1");

    doTest("T19",
        "(Incident: 2013025653) \n" +
        "Nature: FALL\n" +
        "Address: 656 SOUTHLAND DR\n" +
        "Cross: JONES ST & ROMAN ST\n" +
        "Timeout: Wed May 01 13:03:00 UTC 2013\n" +
        "Info: Bleeding from the head.  [05/01/13 13:02:34 LCORDERO]\n" +
        "Father fell down 3 steps, unreponsive  [05/01/13 13:02:04 LCORDERO]\n" +
        "DIST: 105.96 FT (S) (N)STA.1",

        "ID:2013025653",
        "CALL:FALL",
        "ADDR:656 SOUTHLAND DR",
        "X:JONES ST & ROMAN ST",
        "DATE:05/01/2013",
        "TIME:13:03:00",
        "INFO:Bleeding from the head.\nFather fell down 3 steps, unreponsive\nDIST: 105.96 FT (S) (N)STA.1");

    doTest("T20",
        "(Incident: 2013025512) \n" +
        "Nature: BREATHING DIFFICULTY\n" +
        "Address: 383 W VINE ST\n" +
        "Cross: S WOODLAND DR & TROY AVE\n" +
        "Timeout: Tue Apr 30 21:32:00 UTC 2013\n" +
        "Info: CDUNN]\n" +
        "64 YO FEMALE HAVING DB. VERY INCOHEREANT.  [04/30/13 21:23:12\n" +
        "(S) (N)STA.1",

        "ID:2013025512",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:383 W VINE ST",
        "X:S WOODLAND DR & TROY AVE",
        "DATE:04/30/2013",
        "TIME:21:32:00",
        "INFO:64 YO FEMALE HAVING DB. VERY INCOHEREANT.\n(S) (N)STA.1");

    doTest("T21",
        "(Incident: 2013025385) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 995 ELM RD/N LOGSDON PKWY\n" +
        "Timeout: Tue Apr 30 13:29:00 UTC 2013\n" +
        "Info: unknown injuries  [04/30/13 13:29:19 BENNETTK]\n" +
        "BENNETTK]\n" +
        "female on ground, no entrapment . motorcycle verses car.  [04/30/13 13:29:01\n" +
        "DIST: 162.78 FT (S) (N)STA.1",

        "ID:2013025385",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:995 ELM RD & N LOGSDON PKWY",
        "MADDR:995 ELM RD",
        "DATE:04/30/2013",
        "TIME:13:29:00",
        "INFO:unknown injuries\nfemale on ground, no entrapment . motorcycle verses car.\nDIST: 162.78 FT (S) (N)STA.1");

    doTest("T22",
        "(Incident: 2013025252) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 908 RHONDA CT\n" +
        "Cross: MULBERRY ST\n" +
        "Timeout: Mon Apr 29 18:44:00 UTC 2013\n" +
        "Info: ELDERLY FEMALE  [04/29/13 18:44:44 MJOHNSON]\n" +
        "18:44:29 MJOHNSON]\n" +
        "FEMALE FELL POSS UNCONS, MAKING FUNNY NOISES  [04/29/13\n" +
        "(S) (N)STA.1",

        "ID:2013025252",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:908 RHONDA CT",
        "X:MULBERRY ST",
        "DATE:04/29/2013",
        "TIME:18:44:00",
        "INFO:ELDERLY FEMALE\nFEMALE FELL POSS UNCONS, MAKING FUNNY NOISES\n(S) (N)STA.1");

    doTest("T23",
        "(Incident: 2013024746) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 245-15 GLOBE ST\n" +
        "Cross: HILL ST & N DIXIE BLVD\n" +
        "Timeout: Sat Apr 27 11:37:00 UTC 2013\n" +
        "Info: one.  [04/27/13 11:36:35 LCORDERO]\n" +
        "Yellow ambulance requesting lift assist for a 600 lbs male. 12 minute eta.  \n" +
        "Code\n" +
        "(S) (N)STA.1",

        "ID:2013024746",
        "CALL:FIRE OTHER",
        "ADDR:245-15 GLOBE ST",
        "MADDR:245 GLOBE ST",
        "X:HILL ST & N DIXIE BLVD",
        "DATE:04/27/2013",
        "TIME:11:37:00",
        "INFO:one.\nYellow ambulance requesting lift assist for a 600 lbs male. 12 minute eta.\nCode\n(S) (N)STA.1");

    doTest("T24",
        "(Incident: 2013024540) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 2927-3 S WILSON RD\n" +
        "Cross: SKYLINE DR & MILLER AVE\n" +
        "Timeout: Fri Apr 26 14:37:00 UTC 2013\n" +
        "Info: FORWARDED TO RPD  [04/26/13 14:37:16 NICHOLSG]\n" +
        "14:37:09 LCORDERO]\n" +
        "RPD requested FD smoke inside the apt. Water pouring out of apt  [04/26/13\n" +
        "14:11:07 NICHOLSG]\n" +
        "HERS IS FLOODING.  THERE IS WATER EVERYWHERE  [04/26/13\n" +
        "CALLER ADV THAT HER APARTMENT AND THE BUILDING NEXT TO\n" +
        "APT 4DIST: 1656.78 FT  (S)HILLTOP",

        "ID:2013024540",
        "CALL:FIRE STRUCTURE",
        "ADDR:2927-3 S WILSON RD",
        "MADDR:2927 S WILSON RD",
        "X:SKYLINE DR & MILLER AVE",
        "DATE:04/26/2013",
        "TIME:14:37:00",
        "INFO:FORWARDED TO RPD\nRPD requested FD smoke inside the apt. Water pouring out of apt\nHERS IS FLOODING.  THERE IS WATER EVERYWHERE\nCALLER ADV THAT HER APARTMENT AND THE BUILDING NEXT TO\nAPT 4DIST: 1656.78 FT  (S)HILLTOP");

    doTest("T25",
        "(Incident: 2013024476) \n" +
        "Nature: UNRESPON W/ABNORMAL BREATHING\n" +
        "Address: 772 MAGNOLIA DR\n" +
        "Cross: COTTONWOOD DR & CYPRESS DR\n" +
        "Timeout: Fri Apr 26 10:35:00 UTC 2013\n" +
        "Info: BREATHING, HX OF CANCER  [04/26/13 10:34:53 BENNETTK]\n" +
        "57 YO F, BLEEDING THROUGH RECTUM, UNRESPONSIVE ABNORMAL\n" +
        "(S) (N)STA.1",

        "ID:2013024476",
        "CALL:UNRESPON W/ABNORMAL BREATHING",
        "ADDR:772 MAGNOLIA DR",
        "X:COTTONWOOD DR & CYPRESS DR",
        "DATE:04/26/2013",
        "TIME:10:35:00",
        "INFO:BREATHING, HX OF CANCER\n57 YO F, BLEEDING THROUGH RECTUM, UNRESPONSIVE ABNORMAL\n(S) (N)STA.1");

    doTest("T26",
        "(Incident: 2013024458) \n" +
        "Nature: CARDIAC ARREST\n" +
        "Address: 172 N DEEPWOOD DR\n" +
        "Cross: ELM RD & W LINCOLN TRAIL BLVD\n" +
        "Timeout: Fri Apr 26 09:16:00 UTC 2013\n" +
        "Info: not breathing not consicous  [04/26/13 09:16:31 LCORDERO]\n" +
        "(S) (N)STA.1",

        "ID:2013024458",
        "CALL:CARDIAC ARREST",
        "ADDR:172 N DEEPWOOD DR",
        "X:ELM RD & W LINCOLN TRAIL BLVD",
        "DATE:04/26/2013",
        "TIME:09:16:00",
        "INFO:not breathing not consicous\n(S) (N)STA.1");

    doTest("T27",
        "(Incident: 2013024348) \n" +
        "Nature: FIRE OTHER\n" +
        "Address: 140 SHELTON RD\n" +
        "Cross: TURNER DR & S WILSON RD\n" +
        "Timeout: Thu Apr 25 18:17:00 UTC 2013\n" +
        "Info: 9 y/o daughter  is missing  [04/25/13 17:51:35 LEOM]\n" +
        "DIST: 59.02 FT (S) (N)STA.2",

        "ID:2013024348",
        "CALL:FIRE OTHER",
        "ADDR:140 SHELTON RD",
        "X:TURNER DR & S WILSON RD",
        "DATE:04/25/2013",
        "TIME:18:17:00",
        "INFO:9 y/o daughter  is missing\nDIST: 59.02 FT (S) (N)STA.2");

    doTest("T28",
        "(Incident: 2013024201) \n" +
        "Nature: FIRE STRUCTURE\n" +
        "Address: 102 WILLIS DR\n" +
        "Cross: DANIEL CT & ROGERSVILLE RD\n" +
        "Timeout: Thu Apr 25 07:45:00 UTC 2013\n" +
        "Info: STOVE ON FIRE.  [04/25/13 07:44:55 PETERSONB]\n" +
        "T (S)WOODLAWN ACRES (N)STA.1",

        "ID:2013024201",
        "CALL:FIRE STRUCTURE",
        "ADDR:102 WILLIS DR",
        "X:DANIEL CT & ROGERSVILLE RD",
        "DATE:04/25/2013",
        "TIME:07:45:00",
        "INFO:STOVE ON FIRE.\nT (S)WOODLAWN ACRES (N)STA.1");

    doTest("T29",
        "(Incident: 2013024180) \n" +
        "Nature: INJURY VEHICLE ACCIDENT\n" +
        "Address: 1199 SUNSET DR/N LOGSDON PKWY\n" +
        "Timeout: Thu Apr 25 06:55:00 UTC 2013\n" +
        "Info: MPOWERS]\n" +
        "MALE LYING ON THE GROUND OUT SIDE OF THE CAR  [04/25/13 06:55:40\n" +
        "VEHICLE ON IT  [04/25/13 06:55:05 PETERSONB]\n" +
        "(S) (N)STA.1",

        "ID:2013024180",
        "CALL:INJURY VEHICLE ACCIDENT",
        "ADDR:1199 SUNSET DR & N LOGSDON PKWY",
        "MADDR:1199 SUNSET DR",
        "DATE:04/25/2013",
        "TIME:06:55:00",
        "INFO:MALE LYING ON THE GROUND OUT SIDE OF THE CAR\nVEHICLE ON IT\n(S) (N)STA.1");

    doTest("T30",
        "(Incident: 2013024036) \n" +
        "Nature: FIRE ACTIVATED ALARM\n" +
        "Address: 424 MAYER LN\n" +
        "Cross: MARY LEE ST & SOUTH BOUNDARY RD\n" +
        "Timeout: Wed Apr 24 15:03:00 UTC 2013\n" +
        "Info: general fire alarm, keyholder pending  [04/24/13 15:03:03 BENNETTK]\n" +
        "(S) (N)STA.2",

        "ID:2013024036",
        "CALL:FIRE ACTIVATED ALARM",
        "ADDR:424 MAYER LN",
        "X:MARY LEE ST & SOUTH BOUNDARY RD",
        "DATE:04/24/2013",
        "TIME:15:03:00",
        "INFO:general fire alarm, keyholder pending\n(S) (N)STA.2");
  
  }
  
  public static void main(String[] args) {
    new KYHardinCountyAParserTest().generateTests("T1");
  }
}