package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Montgomery County, PA
System: ADI
Contact: Keith Meserole <kmes98@gmail.com>
Sender: adi53@comcast.net

FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:18:02 ** VEHICLE ACCIDENT STAND-BY ** 2623 RIDGE PIKE ** TD BANK- ** 66-03 ** S TROOPER RD AND CLEARFIELD AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:00:39 ** UNKNOWN TYPE FIRE ** SUNDERLAND DR AND EAGLE STREAM DR ** - ** 66-02 ** SUNDERLAND DR A ND EAGLE STREAM DR **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:15:07 ** ELECTRICAL FIRE OUTSIDE ** 3108 MT KIRK AVE W ** - ** 66-02 ** MARILYN AVE AND OAKLYN AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:18:50 ** RESCUE - ELEVATOR ** 20000 SHANNONDELL DR ** BRADFORD CLUBHOUSE - SHANNONDELL- ** 66-07   ** SHANNONDELL BLVD **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:20:21 ** TRASH/DUMPSTER FIRE ** 2965 2ND ST ** - ** 66-03 ** HILLSIDE AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:20:46 ** FIRE ALARM ** 2769 RIDGE PIKE ** PARK RIDGE SHOPPING CENTER- ** 66-03 ** WAYNE AVE AND S PARK AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:19:34 ** FIRE ALARM ** 100 EAGLEVILLE RD ** LEVY BUILDING - EAGLEVILLE HOSPITAL- ** 66-02 ** PRISON RD AND MARILYN AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:23:13 ** FIRE INVESTIGATION ** 132 EVANSBURG RD ** - ** 66-01 ** GREENE MEADOW DR AND GERMANTOWN PIK **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:23:59 ** VEHICLE ACCIDENT RESCUE ** RIDGE PIKE AND N PARK AVE ** - ** 66-03 ** RIDGE PIKE AND N PARK AVE **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:04:38 ** BUILDING FIRE COMMERCIAL ** 623 WILLOWBROOK DR ** - ** 62-05 ** EGYPT RD AND EGYPT RD **
FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:23:41 ** FIRE INVESTIGATION ** 2607 WOODLAND AVE ** - ** 66-03 ** S TROOPER RD AND ROGERS RD **

Contact: Active911
Agency name: Second Alarmers Rescue Squad Location: Willow Grove, PA 
Sender: Beryl0908@comcast.net

(Dispatch) Dispatch ** 16:09:15 ** HEAD INJURY ** 795 PENLLYN BLUE BELL PIKE ** SUNRISE ASSISTED LIVING- **  **  ** 46-18 **  ** SPECIAL ADDRESS COMMENT:\nAFTER A FALL -STRUCK HEAD ON PIANO\nIN LOBBY AREA\nOBTAIN ROOM NUMBER\n ** 06/18/12 ** MHI ** E1232165 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232165\nIncident Received: 06-18-2012  16:09:15              Call Source:      911\n\nCODE: MHI-HEAD INJURY \nSUNRISE ASSISTED LIVING\n795 PENLLYN BLUE BELL PIKE \nCross Street: VILLAGE CIR AND PHIPPS WAY\n\nMap: 46-18  Plan:   ADC: 3256H6  MUN: WHPN\n\nUnits Due:   QX33  385-10\n\nAdditional Info:\n---------- ----\nDOOR CODE 4445*  - DO NOT BROADCAST\n\nCABINET STYLE BOX LOCATED INSIDE OF BLDG,\nON RIGHT SIDE\n\n\nEvent Comments:\n----- ---------\n16:09  SPECIAL ADDRESS COMMENT:\n16:09  AFTER A FALL -STRUCK HEAD ON PIANO\n16:09  IN LOBBY AREA\n16:09  OBTAIN ROOM NUMBER\n\nPrior Events:\n----- -------\nE1231853    06-16-2012    FEVER\nE1229958    06-06-2012    ABDOMINAL PAINS\nE1229801    06-06-2012    CVA/STROKE\nE1226499    05-20-2012    HEAD INJURY\nE1226410    05-19-2012    ASSAULT VICTIM\n\n\n ** WHPN **  **  **  ** VILLAGE CIR AND PHIPPS WAY **  ** QX33  385-10 **
(Dispatch) Dispatch ** 16:26:25 ** FALL VICTIM NON-TRAUMA ** 1521 BIRCHWOOD AVE ** - **  **  ** 29-B2 **  ** FELL GETTING OUT OF VEHICLE\nPT LOCATED INSIDE THE HOME\nPOSSIBLE BROKEN RIGHT HIP\n82 YOM\nC/A\n ** 06/18/12 ** MFV ** E1232169 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232169\nIncident Received: 06-18-2012  16:26:25              Call Source:      911\n\nCODE: MFV-FALL VICTIM NON-TRAUMA\n\n1521 BIRCHWOOD AVE \nCross Street: PATANE AVE AND MIRIAM AVE\n\nMap: 29-B2  Plan:   ADC: 3258J9  MUN: ABGN\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n16:26  FELL GETTING OUT OF VEHICLE\n16:26  PT LOCATED INSIDE THE HOME\n16:26  POSSIBLE BROKEN RIGHT HIP\n16:26  82 YOM\n16:26  C/A\n\nPrior Events:\n----- -------\nE1166907    12-17-2011    FALL VICTIM\nE1162913    11-26-2011    GENERAL WEAKNESS\n\n\n ** ABGN **  **  **  ** PATANE AVE AND MIRIAM AVE **  ** 381-5 ** 
(Dispatch) Dispatch ** 17:17:02 ** SEIZURES ** 409 EASTON RD  Apt# H2 ** WILLOW HILL APARTMENTS- **  **  ** 35-42 **  ** FEMALE ACTIVELY SEIZING\n ** 06/18/12 ** MSE ** E1232179 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232179\nIncident Received: 06-18-2012  17:17:02              Call Source:  10DIGIT\n\nCODE: MSE-SEIZURES \nWILLOW HILL APARTMENTS\n409 EASTON RD  Apt# H2\nCross Street: ALLISON RD AND BARRETT RD\n\nMap: 35-42  Plan:   ADC: 3259A7  MUN: UMOR\n\nUnits Due:   QX10  381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n17:17  FEMALE ACTIVELY SEIZING\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** ALLISON RD AND BARRETT RD **  ** QX10  381-5 ** 
(Dispatch) Dispatch ** 17:57:08 ** ASSAULT VICTIM ** 1200 OLD YORK RD ** ABINGTON MEMORIAL HOSPITAL - AMH- **  **  ** 29-D3 **  ** SPECIAL ADDRESS COMMENT:\n+ ABINGTON MEMORIAL HOSPITAL\nnot in progress\nemployee vs employee.\nin the er. room 206.\n ** 06/18/12 ** MAS ** E1232190 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232190\nIncident Received: 06-18-2012  17:57:08              Call Source:  10DIGIT\n\nCODE: MAS-ASSAULT VICTIM \nABINGTON MEMORIAL HOSPITAL - AMH\n1200 OLD YORK RD \nCross Street: HORACE AVE AND WOODLAND RD\n\nMap: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\nLOCATED AT THE FOLLOWING LOCATIONS:\n1) ELKINS BUILDING- YORK RD ENTRANCE\n\n2) WIDENER BUILDING - SHORDAY LOBBY\n\n3) PROFESSIONAL BUILDING - WUNDERLE LOBBY\n\n4) TOLL BUILDING - E.R. TTRANSPORT (AMBULANCE) ENTRANCE\nON N. SIDE OF BUILDING.  BOX CONTAINS GRANDMASTER AND KEY\nTO CONTROL GATE FOR UNDERGROUND LOADING DOCK.\n\nUpdated: 01/09/06 - 541\n\n\nEvent Comments:\n----- ---------\n17:57  SPECIAL ADDRESS COMMENT:\n17:57  + ABINGTON MEMORIAL HOSPITAL\n17:57  not in progress\n17:57  employee vs employee.\n17:57  in the er. room 206.\n\nPrior Events:\n----- -------\nE1230299    06-08-2012    UNKNOWN MEDICAL EMERGENCY\nE1225645    05-15-2012    BEHAVIORAL/PSYCH EMERGENCY\nE1222139    04-27-2012    FALL VICTIM\nE1219693    04-15-2012    BEHAVIORAL/PSYCH EMERGENCY\nE1219514    04-14-2012    BEHAVIORAL/PSYCH EMERGENCY\n\n\n ** ABGN **  **  **  ** HORACE AVE AND WOODLAND RD **  ** 381-5 ** 
(Dispatch) Dispatch ** 18:35:29 ** ABDOMINAL PAINS ** 46 BARBARA RD ** - **  **  ** 35-80 **  ** ABDOMINAL PAINS ALSO BACK PAINS\nC/A\n89 YOM\nUNABLE TO WALK\n ** 06/18/12 ** MAP ** E1232193 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232193\nIncident Received: 06-18-2012  18:35:29              Call Source:      911\n\nCODE: MAP-ABDOMINAL PAINS \n\n46 BARBARA RD \nCross Street: CRESCENT RD AND NORWYN RD\n\nMap: 35-80  Plan:   ADC: 3147C10  MUN: UMOR\n\nUnits Due:   QX10  384-4\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n18:35  ABDOMINAL PAINS ALSO BACK PAINS\n18:35  C/A\n18:35  89 YOM\n18:35  UNABLE TO WALK\n\nPrior Events:\n----- -------\nE1207336    02-09-2012    OVERDOSE\n\n\n ** UMOR **  **  **  ** CRESCENT RD AND NORWYN RD **  ** QX10  384-4 ** 
(Dispatch) Dispatch ** 18:59:12 ** SEIZURES ** 240 COUNTY LINE RD E Apt# E3 ** LIVINGSTONE APARTMENTS- **  **  ** 37-20 **  ** 82/F HAVING A DIABETIC SEIZURE\n ** 06/18/12 ** MSE ** E1232199 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232199\nIncident Received: 06-18-2012  18:59:12              Call Source:      911\n\nCODE: MSE-SEIZURES \nLIVINGSTONE APARTMENTS\n240 COUNTY LINE RD E Apt# E3\nCross Street: MADISON AVE AND PARK AVE\n\nMap: 37-20  Plan:   ADC: 3259E1  MUN: HATB\n\nUnits Due:   NC384\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n18:59  82/F HAVING A DIABETIC SEIZURE\n\nPrior Events:\n----- -------\nE1133514    06-26-2011    FALL VICTIM\n\n\n ** HATB **  **  **  ** MADISON AVE AND PARK AVE **  ** NC384 ** 
(Dispatch) Dispatch ** 19:29:31 ** CARDIAC EMERGENCY ** 2329 OLD WELSH RD ** - **  **  ** 29-C1 **  ** ROOMING HOUSE\nPT IS UPSTAIRS\n66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\nC/A BREATHING LABORED\n ** 06/18/12 ** MCE ** E1232202 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232202\nIncident Received: 06-18-2012  19:29:31              Call Source:  10DIGIT\n\nCODE: MCE-CARDIAC EMERGENCY \n\n2329 OLD WELSH RD \nCross Street: SUMMIT AVE AND EASTON RD\n\nMap: 29-C1  Plan:   ADC: 3259A9  MUN: ABGN\n\nUnits Due:   NC381\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n19:29  ROOMING HOUSE\n19:29  PT IS UPSTAIRS\n19:29  66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\n19:29  C/A BREATHING LABORED\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** ABGN **  **  **  ** SUMMIT AVE AND EASTON RD **  ** NC381 ** 
(Dispatch) Dispatch ** 19:29:49 ** CARDIAC EMERGENCY ** 3940 COMMERCE AVE  Apt# A ** DA VITA DIALYSIS ABINGTON (DAVITA)- **  **  ** 35-58 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\nCHEST PAIN / INCREASED HEART RATE\nF/60'S\nC/A - BREATHING NORMAL\nMED STAFF WITH PT\n ** 06/18/12 ** MCE ** E1232203 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232203\nIncident Received: 06-18-2012  19:29:49              Call Source:      911\n\nCODE: MCE-CARDIAC EMERGENCY \nDA VITA DIALYSIS ABINGTON (DAVITA)\n3940 COMMERCE AVE  Apt# A\nCross Street: MARYLAND RD AND MARYLAND RD\n\nMap: 35-58  Plan:   ADC: 3258J4  MUN: UMOR\n\nUnits Due:   QX10  NC384\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n19:29  SPECIAL ADDRESS COMMENT:\n19:29  VALID SUITES AT LOCATION - REVERIFY\n19:29  CHEST PAIN / INCREASED HEART RATE\n19:29  F/60'S\n19:29  C/A - BREATHING NORMAL\n19:29  MED STAFF WITH PT\n\nPrior Events:\n----- -------\nE1227259    05-24-2012    CARDIAC EMERGENCY\nE1219148    04-12-2012    FALL VICTIM\nE1217228    04-02-2012    CARDIAC EMERGENCY\nE1212374    03-07-2012    CARDIAC EMERGENCY\nE1210345    02-25-2012    CARDIAC EMERGENCY\n\n\n ** UMOR **  **  **  ** MARYLAND RD AND MARYLAND RD **  ** QX10  NC384 ** 
(Dispatch) Dispatch ** 19:45:05 ** FALL VICTIM TRAUMA ** 1750 ARCH STREET RD ** - **  **  ** 46-36 **  ** LANGUAGE BARRIER\nCALLER STATING SOMEONE FELL OFF A LADDER\n ** 06/18/12 ** MFV ** E1232207 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232207\nIncident Received: 06-18-2012  19:45:05              Call Source:  10DIGIT\n\nCODE: MFV-FALL VICTIM TRAUMA\n\n1750 ARCH STREET RD \nCross Street: NETHERWOOD DR AND COOPER AVE\n\nMap: 46-36  Plan:   ADC: 3256C7  MUN: WHPN\n\nUnits Due:   385-3\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n19:45  LANGUAGE BARRIER\n19:45  CALLER STATING SOMEONE FELL OFF A LADDER\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** WHPN **  **  **  ** NETHERWOOD DR AND COOPER AVE **  ** 385-3 ** 
(Dispatch) Dispatch ** 03:23:37 ** RESPIRATORY EMERGENCY ** 11 WOODHILL DR ** - **  **  ** 35-47 **  ** DIF BREATHING\nPT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\nC/A\nM/57\n ** 06/19/12 ** MRE ** E1232242 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232242\nIncident Received: 06-19-2012  03:23:37              Call Source:      911\n\nCODE: MRE-RESPIRATORY EMERGENCY \n\n11 WOODHILL DR \nCross Street: FITZWATERTOWN RD AND RUSSELL RD\n\nMap: 35-47  Plan:   ADC: 3258K6  MUN: UMOR\n\nUnits Due:   381-2\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n03:23  DIF BREATHING\n03:23  PT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\n03:23  C/A\n03:23  M/57\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** FITZWATERTOWN RD AND RUSSELL RD **  ** 381-2 ** 
(Dispatch) Dispatch ** 07:09:31 ** RESPIRATORY EMERGENCY ** 1120 YORK RD N Apt# 322 ** WILLOW LAKE RETIREMENT HOME- **  **  ** 35-35 **  ** 70 YOM\nMEDICAL STAFF ON SCENE\nPULSE OX 94&#x45;\n ** 06/19/12 ** MRE ** E1232256 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232256\nIncident Received: 06-19-2012  07:09:31              Call Source:      911\n\nCODE: MRE-RESPIRATORY EMERGENCY \nWILLOW LAKE RETIREMENT HOME\n1120 YORK RD N Apt# 322\nCross Street: LAKEVUE DR AND FITZWATERTOWN RD\n\nMap: 35-35  Plan:   ADC: 3259B5  MUN: UMOR\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n07:09  70 YOM\n07:09  MEDICAL STAFF ON SCENE\n07:09  PULSE OX 94&#x45;\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** LAKEVUE DR AND FITZWATERTOWN RD **  ** 381-5 ** 
(Dispatch) Dispatch ** 09:02:11 ** VEHICLE ACCIDENT INJURIES ** 3390 PENNSYLVANIA TPKE WB ** - **  **  ** 41-34 **  ** REC VEH INTO TT\nDRIVER OF REC VEH APPEARS TO BE INJ\nREC VEH/MOBILE HOME\nWINDSHIELD CRACKED\nCALLER IS PASSERBY\n ** 06/19/12 ** VAI ** E1232273 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232273\nIncident Received: 06-19-2012  09:02:11              Call Source:  10DIGIT\n\nCODE: VA-VEHICLE ACCIDENT INJURIES\n\n3390 PENNSYLVANIA TPKE WB\nCross Street: CAMP HILL RD OVERPASS AND RAMP VIRGINIA DR TO I276 WB\n\nMap: 41-34  Plan:   ADC: 3258A9  MUN: UDUB\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n09:02  REC VEH INTO TT\n09:02  DRIVER OF REC VEH APPEARS TO BE INJ\n09:02  REC VEH/MOBILE HOME\n09:02  WINDSHIELD CRACKED\n09:02  CALLER IS PASSERBY\n\nPrior Events:\n----- -------\nE1221542    04-24-2012    CARDIAC EMERGENCY\n\n\n ** UDUB **  **  **  ** CAMP HILL RD OVERPASS AND RAMP VIRGINIA DR TO I276 WB **  ** 381-5 ** 
(Dispatch) Dispatch ** 10:04:05 ** CVA/STROKE ** 721 SKIPPACK PIKE  Apt# 3 ** BROAD AXE FAMILY MEDICINE- **  **  ** 46-15 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\n78 YOF\nMEDICAL STAFF ON SCENE\nC/A\nBREATHING OK\nHX: NONE\n ** 06/19/12 ** MCV ** E1232286 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232286\nIncident Received: 06-19-2012  10:04:05              Call Source:      911\n\nCODE: MCV-CVA/STROKE \nBROAD AXE FAMILY MEDICINE\n721 SKIPPACK PIKE  Apt# 3\nCross Street: PENLLYN BLUE BELL PIKE AND LENMAR DR\n\nMap: 46-15  Plan:   ADC: 3256G6  MUN: WHPN\n\nUnits Due:   385-10\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n10:04  SPECIAL ADDRESS COMMENT:\n10:04  VALID SUITES AT LOCATION - REVERIFY\n10:04  78 YOF\n10:04  MEDICAL STAFF ON SCENE\n10:04  C/A\n10:04  BREATHING OK\n10:04  HX: NONE\n\nPrior Events:\n----- -------\nE1228888    06-01-2012    BACK PAINS/INJURY\nE1222075    04-27-2012    RESPIRATORY EMERGENCY\nE1209632    02-21-2012    HEAD INJURY\nE1167853    12-22-2011    GENERAL WEAKNESS\nE1162172    11-22-2011    FEVER\n\n\n ** WHPN **  **  **  ** PENLLYN BLUE BELL PIKE AND LENMAR DR **  ** 385-10 ** 
(Dispatch) Dispatch ** 10:40:08 ** FRACTURE ** 324 PENN ST N ** - **  **  ** 37-19 **  ** Event stacked at: 06/19/12 10:39:56\n ** 06/19/12 ** MFX ** E1232297 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232297\nIncident Received: 06-19-2012  10:40:08              Call Source:  10DIGIT\n\nCODE: MFX-FRACTURE \n\n324 PENN ST N\nCross Street: SUMMIT AVE AND MEADOWBROOK AVE\n\nMap: 37-19  Plan:   ADC: 3259D1  MUN: HATB\n\nUnits Due:   384-4\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n10:40  Event stacked at: 06/19/12 10:39:56\n\nPrior Events:\n----- -------\nE1203368    01-19-2012    RESPIRATORY EMERGENCY\nE1159293    11-07-2011    RESPIRATORY EMERGENCY\n\n\n ** HATB **  **  **  ** SUMMIT AVE AND MEADOWBROOK AVE **  ** 384-4 ** 
(Dispatch) Dispatch ** 11:28:32 ** CVA/STROKE ** 39 MORELAND AVE E ** - **  **  ** 37-13 **  ** 83/F\n ** 06/19/12 ** MCV ** E1232300 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232300\nIncident Received: 06-19-2012  11:28:32              Call Source:      911\n\nCODE: MCV-CVA/STROKE \n\n39 MORELAND AVE E\nCross Street: N YORK RD AND N PENN ST\n\nMap: 37-13  Plan:   ADC: 3259D2  MUN: HATB\n\nUnits Due:   384-4\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n11:28  83/F\n\nPrior Events:\n----- -------\nE1214760    03-20-2012    RESPIRATORY EMERGENCY\nE1153829    10-09-2011    MEDICAL ALERT ALARM\n\n\n ** HATB **  **  **  ** N YORK RD AND N PENN ST **  ** 384-4 ** 
(Dispatch) Dispatch ** 11:41:02 ** HEMORRHAGING ** 1001 EASTON RD  Apt# 803 ** REGENCY PARK TOWERS MANOR BUILDING- **  **  ** 35-44 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\n86/F FINGER STILL BLEEDING FROM A PAST LACERATION\nVALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\n ** 06/19/12 ** MHM ** E1232302 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232302\nIncident Received: 06-19-2012  11:41:02              Call Source:      911\n\nCODE: MHM-HEMORRHAGING \nREGENCY PARK TOWERS MANOR BUILDING\n1001 EASTON RD  Apt# 803\nCross Street: RUSSELL RD AND FITZWATERTOWN RD\n\nMap: 35-44  Plan:   ADC: 3259A6  MUN: UMOR\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n11:41  SPECIAL ADDRESS COMMENT:\n11:41  VALID SUITES AT LOCATION - REVERIFY\n11:41  86/F FINGER STILL BLEEDING FROM A PAST LACERATION\n11:41  VALID SUITES AT LOCATION - REVERIFY\n11:41  SPECIAL ADDRESS COMMENT:\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** RUSSELL RD AND FITZWATERTOWN RD **  ** 381-5 ** 
(Dispatch) Dispatch ** 11:56:01 ** ALTERED MENTAL STATUS ** 777 DEKALB PIKE  Apt# 234 ** BLUE BELL PLACE- **  **  ** 46-07 **  ** C/NOT ALERT\n ** 06/19/12 ** MMS ** E1232303 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232303\nIncident Received: 06-19-2012  11:56:01              Call Source:  10DIGIT\n\nCODE: MMS-ALTERED MENTAL STATUS \nBLUE BELL PLACE\n777 DEKALB PIKE  Apt# 234\nCross Street: BLUE BELL SPRINGS DR AND SKIPPACK PIKE\n\nMap: 46-07  Plan:   ADC: 3256D3  MUN: WHPN\n\nUnits Due:   385-10\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n11:56  C/NOT ALERT\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** WHPN **  **  **  ** BLUE BELL SPRINGS DR AND SKIPPACK PIKE **  ** 385-10 ** 
(Dispatch) Dispatch ** 12:33:07 ** SEIZURES ** 2600 TURNPIKE DR ** READ'S VAN SERVICE- **  **  ** 35-77 **  ** MALE\nAGE UNKNOWN/EMPLOYEE\nPT LOCATED IN WAREHOUSE\n ** 06/19/12 ** MSE ** E1232319 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232319\nIncident Received: 06-19-2012  12:33:07              Call Source:      911\n\nCODE: MSE-SEIZURES \nREAD'S VAN SERVICE\n2600 TURNPIKE DR \nCross Street: DAVISVILLE RD \n\nMap: 35-77  Plan:   ADC: 3259E4  MUN: UMOR\n\nUnits Due:   QX10  381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n12:33  MALE\n12:33  AGE UNKNOWN/EMPLOYEE\n12:33  PT LOCATED IN WAREHOUSE\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** DAVISVILLE RD **  ** QX10  381-5 ** 
(Dispatch) Dispatch ** 14:30:48 ** UNKNOWN MEDICAL EMERGENCY ** 1741 ROCKWELL RD ** - **  **  ** 29-C1 **  ** UNCLE VS 13 YO NEICE\nSTILL ACTING UP FROM EARLIER TODAY\nCALLER WANTS PD TO REMOVE HER\nFEM IS ANNIE MYERS\nW/F WEARING BLU SHIRT  and  JEAN SHORTS\nNO WEAPONS, NO INTOX\nFEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n2911 -- DISREGARD STATUS CHECKS\n2914- EMS TO CHECK ON FEMALE SUBJ\n ** 06/19/12 ** MUN ** E1232336 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232336\nIncident Received: 06-19-2012  14:30:48              Call Source:  10DIGIT\n\nCODE: MUN-UNKNOWN MEDICAL EMERGENCY \n\n1741 ROCKWELL RD \nCross Street: RUBICAM AVE AND TREMONT AVE\n\nMap: 29-C1  Plan:   ADC: 3259B9  MUN: ABGN\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n14:09  UNCLE VS 13 YO NEICE\n14:09  STILL ACTING UP FROM EARLIER TODAY\n14:09  CALLER WANTS PD TO REMOVE HER\n14:09  FEM IS ANNIE MYERS\n14:10  W/F WEARING BLU SHIRT  and  JEAN SHORTS\n14:10  NO WEAPONS, NO INTOX\n14:10  FEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n14:17  2911 -- DISREGARD STATUS CHECKS\n14:30  2914- EMS TO CHECK ON FEMALE SUBJ\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** ABGN **  **  **  ** RUBICAM AVE AND TREMONT AVE **  ** 381-5 ** 
(Dispatch) Dispatch ** 15:29:36 ** VEHICLE ACCIDENT INJURIES ** 2200 MT CARMEL AVE ** - **  **  ** 29-C6 **  ** 4 VEHS - REQ EMS\nON THE 2200 BLOCK OF...\n ** 06/19/12 ** VAI ** E1232350 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232350\nIncident Received: 06-19-2012  15:29:36              Call Source:  10DIGIT\n\nCODE: VA-VEHICLE ACCIDENT INJURIES\n\n2200 MT CARMEL AVE \nCross Street: KESWICK AVE AND WOODLYN AVE\n\nMap: 29-C6  Plan:   ADC: 3370G4  MUN: ABGN\n\nUnits Due:   383-13\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n15:29  4 VEHS - REQ EMS\n15:29  ON THE 2200 BLOCK OF...\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** ABGN **  **  **  ** KESWICK AVE AND WOODLYN AVE **  ** 383-13 ** 
(Dispatch) Dispatch ** 16:08:21 ** BUILDING FIRE NON-COMMERCIAL ** 3 HIGH GATE LN ** - **  **  ** 46-28 **  ** ELECTRIC OVEN\nCALLER STATING EXPLODING\nFLAMES\n ** 06/19/12 ** FBL ** E1232354 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232354\nIncident Received: 06-19-2012  16:08:21              Call Source:      911\n\nCODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n3 HIGH GATE LN \nCross Street: PENLLYN BLUE BELL PIKE \n\nMap: 46-28  Plan:   ADC: 3256H6  MUN: WHPN\n\nUnits Due:   QX33  385-10\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n16:08  ELECTRIC OVEN\n16:08  CALLER STATING EXPLODING\n16:08  FLAMES\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** WHPN **  **  **  ** PENLLYN BLUE BELL PIKE **  ** QX33  385-10 ** 
(Dispatch) Dispatch ** 16:21:03 ** DIZZINESS ** 2300 COMPUTER AVE  Apt# E25 ** ABINGTON WOMANS PRIMARY GROUP- **  **  ** 35-59 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\n+ EXECUTIVE MEWS\nPT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n40 YOF\nSTILL LIGHTHEADED\nC/A\nBREATHING OK\n ** 06/19/12 ** MDZ ** E1232356 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232356\nIncident Received: 06-19-2012  16:21:03              Call Source:  10DIGIT\n\nCODE: MDZ-DIZZINESS \nABINGTON WOMANS PRIMARY GROUP\n2300 COMPUTER AVE  Apt# E25\nCross Street: WELSH RD AND MARYLAND RD\n\nMap: 35-59  Plan:   ADC: 3258J5  MUN: UMOR\n\nUnits Due:   QX10  384-4\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n16:21  SPECIAL ADDRESS COMMENT:\n16:21  VALID SUITES AT LOCATION - REVERIFY\n16:21  SPECIAL ADDRESS COMMENT:\n16:21  + EXECUTIVE MEWS\n16:21  PT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n16:21  40 YOF\n16:21  STILL LIGHTHEADED\n16:21  C/A\n16:21  BREATHING OK\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** UMOR **  **  **  ** WELSH RD AND MARYLAND RD **  ** QX10  384-4 ** 
(Dispatch) Dispatch ** 17:57:23 ** ALLERGIC REACTION ** 2254 PLEASANT AVE ** - **  **  ** 29-C5 **  ** STUNG BY A BEE\n ** 06/19/12 ** MAR ** E1232369 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232369\nIncident Received: 06-19-2012  17:57:23              Call Source:  10DIGIT\n\nCODE: MAR-ALLERGIC REACTION \n\n2254 PLEASANT AVE \nCross Street: GARDEN RD AND EASTON RD\n\nMap: 29-C5  Plan:   ADC: 3370H3  MUN: ABGN\n\nUnits Due:   383-13\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n17:57  STUNG BY A BEE\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** ABGN **  **  **  ** GARDEN RD AND EASTON RD **  ** 383-13 ** 
(Dispatch) Dispatch ** 19:03:09 ** RESPIRATORY EMERGENCY ** 2478 LAFAYETTE AVE ** - **  **  ** 29-B3 **  ** 53/F\nTROUBLE BREATHING, HIVES ALL OVER BODY\n ** 06/19/12 ** MRE ** E1232384 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232384\nIncident Received: 06-19-2012  19:03:09              Call Source:  10DIGIT\n\nCODE: MRE-RESPIRATORY EMERGENCY \n\n2478 LAFAYETTE AVE \nCross Street: BRADFIELD RD AND COLONIAL AVE\n\nMap: 29-B3  Plan:   ADC: 3258J10  MUN: ABGN\n\nUnits Due:   381-2\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n19:03  53/F\n19:03  TROUBLE BREATHING, HIVES ALL OVER BODY\n\nPrior Events:\n----- -------\nE1169015    12-29-2011    SYNCOPAL EPISODE\n\n\n ** ABGN **  **  **  ** BRADFIELD RD AND COLONIAL AVE **  ** 381-2 ** 
(Dispatch) Dispatch ** 20:44:19 ** RESPIRATORY EMERGENCY ** 291 KESWICK AVE ** KESWICK THEATER- **  **  ** 29-C5 **  ** F/48\nDIF BREATHING\nC/SEMI ALERT\nPT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\n ** 06/19/12 ** MRE ** E1232396 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232396\nIncident Received: 06-19-2012  20:44:19              Call Source:      911\n\nCODE: MRE-RESPIRATORY EMERGENCY \nKESWICK THEATER\n291 KESWICK AVE \nCross Street: THE KESWICK ROTARY LOOP AND EASTON RD\n\nMap: 29-C5  Plan:   ADC: 3370G3  MUN: ABGN\n\nUnits Due:   NC383\n\nAdditional Info:\n---------- ----\n...............KEY BOX....................\nKEY BOX MOUNTED HIGH ON SIDE "B" WALL IN THE ALLEY CLOSE TO THE LEFT SIDE FRONT DOOR.\n\nEvent Comments:\n----- ---------\n20:44  F/48\n20:44  DIF BREATHING\n20:44  C/SEMI ALERT\n20:44  PT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\n\nPrior Events:\n----- -------\nE1158725    11-03-2011    DIABETIC EMERGENCY\n\n\n ** ABGN **  **  **  ** THE KESWICK ROTARY LOOP AND EASTON RD **  ** NC383 ** 
(Dispatch) Dispatch ** 21:44:47 ** BUILDING FIRE COMMERCIAL ** 1400 UNION MEETING RD  Apt# 100 ** CERTAINTEED CORPORATION TECHNICAL CENTER- **  **  ** 46-57 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\nBOILER ROOM IS SMOKING\nSMELLS LIKE SMOKE- POSS ELECTRICAL\nADVISED TO EVACUATE\n ** 06/19/12 ** FBL ** E1232405 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232405\nIncident Received: 06-19-2012  21:44:47              Call Source:  10DIGIT\n\nCODE: FBL-BUILDING FIRE COMMERCIAL\nCERTAINTEED CORPORATION TECHNICAL CENTER\n1400 UNION MEETING RD  Apt# 100\nCross Street: HARVEST DR AND JOLLY RD\n\nMap: 46-57  Plan:   ADC: 3256E7  MUN: WHPN\n\nUnits Due:   385-3\n\nAdditional Info:\n---------- ----\nWALL NON-COMBUSTIBLE\nKNOX BOX LOCATED RIGHT SIDE OF MAIN DOOR\n\nEvent Comments:\n----- ---------\n21:44  SPECIAL ADDRESS COMMENT:\n21:44  VALID SUITES AT LOCATION - REVERIFY\n21:44  BOILER ROOM IS SMOKING\n21:44  SMELLS LIKE SMOKE- POSS ELECTRICAL\n21:44  ADVISED TO EVACUATE\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** WHPN **  **  **  ** HARVEST DR AND JOLLY RD **  ** 385-3 ** 
(Dispatch) Dispatch ** 02:16:29 ** OVERDOSE ** 409 EASTON RD  Apt# C3 ** WILLOW HILL APARTMENTS- **  **  ** 35-42 **  ** DIF TO UNDERSTAND\nALCOHOL AND MEDICINE\nPT IS GASPING FOR AIR\nNOT C/A\nNOW SAYING UNK IF C/A\nF/42\n ** 06/20/12 ** MOD ** E1232438 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232438\nIncident Received: 06-20-2012  02:16:29              Call Source:  10DIGIT\n\nCODE: MOD-OVERDOSE \nWILLOW HILL APARTMENTS\n409 EASTON RD  Apt# C3\nCross Street: ALLISON RD AND BARRETT RD\n\nMap: 35-42  Plan:   ADC: 3259A7  MUN: UMOR\n\nUnits Due:   QX10  381-2\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n02:16  DIF TO UNDERSTAND\n02:16  ALCOHOL AND MEDICINE\n02:16  PT IS GASPING FOR AIR\n02:16  NOT C/A\n02:16  NOW SAYING UNK IF C/A\n02:16  F/42\n\nPrior Events:\n----- -------\nE1140756    08-03-2011    ASSAULT VICTIM\n\n\n ** UMOR **  **  **  ** ALLISON RD AND BARRETT RD **  ** QX10  381-2 ** 
(Dispatch) Dispatch ** 04:30:47 ** RESPIRATORY EMERGENCY ** 2746 FERNWOOD AVE ** - **  **  ** 29-B3 **  ** TROUBLE BREATHING- SOB\n56/M\nC/A\nMED HX- NONE\n ** 06/20/12 ** MRE ** E1232444 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232444\nIncident Received: 06-20-2012  04:30:47              Call Source:  10DIGIT\n\nCODE: MRE-RESPIRATORY EMERGENCY \n\n2746 FERNWOOD AVE \nCross Street: THOMSON RD AND NOLEN RD\n\nMap: 29-B3  Plan:   ADC: 3258H10  MUN: ABGN\n\nUnits Due:   381-2\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n04:30  TROUBLE BREATHING- SOB\n04:30  56/M\n04:30  C/A\n04:30  MED HX- NONE\n\nPrior Events:\n----- -------\n*** NOT FOUND ***\n\n\n ** ABGN **  **  **  ** THOMSON RD AND NOLEN RD **  ** 381-2 ** 
(Dispatch) Dispatch ** 05:53:55 ** ALTERED MENTAL STATUS ** 174 BETHLEHEM PIKE S Apt# A2 ** MATTISON HOUSE APARTMENTS- **  **  ** 43-07 **  ** 84/F - CONS - CONFUSED\nHX: COPD; CHF\nHAS FALLEN AS WELL\n ** 06/20/12 ** MMS ** E1232447 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232447\nIncident Received: 06-20-2012  05:53:55              Call Source:  10DIGIT\n\nCODE: MMS-ALTERED MENTAL STATUS \nMATTISON HOUSE APARTMENTS\n174 BETHLEHEM PIKE S Apt# A2\nCross Street: MATTISON AVE AND CHURCH ST\n\nMap: 43-07  Plan:   ADC: 3257F6  MUN: AMBL\n\nUnits Due:   NC351  385-3\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n05:53  84/F - CONS - CONFUSED\n05:53  HX: COPD; CHF\n05:53  HAS FALLEN AS WELL\n\nPrior Events:\n----- -------\nE1225519    05-15-2012    HEMORRHAGING\nE1223962    05-07-2012    RESPIRATORY EMERGENCY\nE1221345    04-23-2012    CARDIAC EMERGENCY\nE1216023    03-26-2012    CARDIAC EMERGENCY\nE1212938    03-10-2012    RESPIRATORY EMERGENCY\n\n\n ** AMBL **  **  **  ** MATTISON AVE AND CHURCH ST **  ** NC351  385-3 ** 
(Dispatch) Dispatch ** 07:54:09 ** SYNCOPAL EPISODE ** 1235 OLD YORK RD  Apt# G23 ** LEVY MEDICAL PLAZA - AMH- **  **  ** 29-D3 **  ** SPECIAL ADDRESS COMMENT:\nVALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\n+ LEVY MEDICAL PLAZA - AMH\n60'S/F ABOUT TO PASS OUT\nC/A\nBREATHING OK\nREQ ABINGTON HOSPITAL\n ** 06/20/12 ** MSY ** E1232466 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232466\nIncident Received: 06-20-2012  07:54:09              Call Source:      911\n\nCODE: MSY-SYNCOPAL EPISODE \nLEVY MEDICAL PLAZA - AMH\n1235 OLD YORK RD  Apt# G23\nCross Street: HORACE AVE AND WOODLAND RD\n\nMap: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\nUnits Due:   381-2\n\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\nEvent Comments:\n----- ---------\n07:54  SPECIAL ADDRESS COMMENT:\n07:54  VALID SUITES AT LOCATION - REVERIFY\n07:54  SPECIAL ADDRESS COMMENT:\n07:54  + LEVY MEDICAL PLAZA - AMH\n07:54  60'S/F ABOUT TO PASS OUT\n07:54  C/A\n07:54  BREATHING OK\n07:54  REQ ABINGTON HOSPITAL\n\nPrior Events:\n----- -------\nE1231442    06-14-2012    ABDOMINAL PAINS\nE1231229    06-13-2012    ABDOMINAL PAINS\nE1231190    06-13-2012    RESPIRATORY EMERGENCY\nE1229671    06-05-2012    ABDOMINAL PAINS\nE1216389    03-28-2012    ABDOMINAL PAINS\n\n\n ** ABGN **  **  **  ** HORACE AVE AND WOODLAND RD **  ** 381-2 ** 

Contact: Active911
Agency name: Worcester Fire Department
Location: Worcester, PA, United States
Sender: worcesterfd@comcast.net

(GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING) Dispatch ** 11:19 ** GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING ** 301 PRIMROSE DR ** RESERVE AT GWYNEDD FITNESS CEN **  **  ** 51-81 **  ** 05/03/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309199\nIncident Received: 05-03-2013  11:19:07              Call Source:      911\n\nCODE: FGL-GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING\nRESERVE AT GWYNEDD FITNESS CENTER\n301 PRIMROSE DR \nCross Street: MORRIS RD AND MAHOGANY WAY\n\nMap: 51-81  Plan: 51-81 ADC: 3144C9  MUN: UGWY\n\nUnits Due:   E83  TW33  E62  TW80  E80\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n11:19  BUILDING 1000\n11:19  GO TO BUILDING 1000 ON LILAC CT\n11:19  2ND FLOOR AND FIRE TOWER, ODOR OF GAS\n\nPrior Events:\n----- -------\nF1225774    10-29-2012    FIRE ALARM\nF1213987    06-23-2012    GAS-ODOR/LEAK\n\n\n ** UGWY ** MORRIS RD AND MAHOGANY WA ** E83  TW33  E62  TW80  E80 ** 
(FIRE ALARM) Dispatch ** 17:38 ** FIRE ALARM ** 1520 GREEN HILL RD ** - **  **  ** 64-16 **  ** 05/02/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309146\nIncident Received: 05-02-2013  17:38:25              Call Source:  10DIGIT\n\nCODE: FAL-FIRE ALARM \n\n1520 GREEN HILL RD \nCross Street: STUMP HALL RD AND ANDERS RD\n\nMap: 64-16  Plan:   ADC: 3142J9  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n17:38  SMOKE\n17:38  W/N\n17:38  RES; TOM DICKENSON PH: 610.584.5773\n17:38  DOES NOT LIST LOCATION\n\nPrior Events:\n----- -------\n\n\n ** WORC ** STUMP HALL RD AND ANDERS ** T83  E83 ** 
(BUILDING FIRE NON-COMMERCIAL) Dispatch ** 09:24 ** BUILDING FIRE NON-COMMERCIAL ** 2595 HILLCREST DR ** - **  **  ** 64-05 **  ** 05/02/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309092\nIncident Received: 05-02-2013  09:24:14              Call Source:      911\n\nCODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n2595 HILLCREST DR \nCross Street: COUNTRY VIEW LN AND BETHEL RD\n\nMap: 64-05  Plan:   ADC: 3144A9  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n09:24  USED GAS GRILL LAST EVEING\n09:24  NOW SMELLING GAS/GRILL HOT\n09:24  GAS LINE ATTACHED TO HOME\n09:24  GRILL LOCATED ON REAR DECK\n\nPrior Events:\n----- -------\n\n\n ** WORC ** COUNTRY VIEW LN AND BETHE ** T83  E83 ** 
(VEHICLE ACCIDENT STAND-BY) Dispatch ** 12:45 ** VEHICLE ACCIDENT STAND-BY ** 1221 QUARRY HALL RD ** - **  **  ** 64-22 **  ** 04/30/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308951\nIncident Received: 04-30-2013  12:45:29              Call Source:  10DIGIT\n\nCODE: VA-VEHICLE ACCIDENT STAND-BY\n\n1221 QUARRY HALL RD \nCross Street: DELL RD AND WATER STREET RD\n\nMap: 64-22B Plan:   ADC: 3254K3  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n12:26  -075.424425 +040.211935\n12:26  TT HIT WIRES AND TOOK THE WIRES DOWN , NOT SPARKING\n12:26  OFF TO THE SIDE\n12:41  CALLER BACK ON THE LINE\n12:42  LOOKING FOR AN ETA ON TROOPER\n12:44  PSP - DISP FD - WIRES ARE LIVE\n\nPrior Events:\n----- -------\n\n\n ** WORC ** DELL RD AND WATER STREET ** T83  E83 ** 
(FIRE ALARM) Dispatch ** 12:56 ** FIRE ALARM ** 1133 HOLLOW RD ** - **  **  ** 64-22 **  ** 04/29/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308877\nIncident Received: 04-29-2013  12:56:13              Call Source:  10DIGIT\n\nCODE: FAL-FIRE ALARM \n\n1133 HOLLOW RD \nCross Street: MILL RD AND SLOUGH DR\n\nMap: 64-22A Plan:   ADC: 3254J2  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n12:56  GENERAL FIRE\n12:56  W/N\n12:56  RES: ROBERT JOHNSON, 702 596 2777\n\nPrior Events:\n----- -------\n\n\n ** WORC ** MILL RD AND SLOUGH DR ** T83  E83 ** 
(FIRE ALARM) Dispatch ** 10:28 ** FIRE ALARM ** 3205 SKIPPACK PIKE  Apt# 144 ** MEADOWOOD RETIREMENT COMMUNITY **  **  ** 64-07 **  ** 04/29/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308859\nIncident Received: 04-29-2013  10:28:47              Call Source:  10DIGIT\n\nCODE: FAL-FIRE ALARM \nMEADOWOOD RETIREMENT COMMUNITY\n3205 SKIPPACK PIKE  Apt# 144\nCross Street: MEADOWOOD DR AND HOLLOW RD\n\nMap: 64-07A Plan:   ADC: 3143E7  MUN: WORC\n\nUnits Due:   E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n10:28  SPECIAL ADDRESS COMMENT:\n10:28  + MEADOWOOD RETIREMENT COMMUNITY\n10:28  OBTAIN ROOM NUMBER  and  WING\n10:28  HEALTH CARE FIRST FLOOR\n10:28  SPECIAL ADDRESS COMMENT:\n10:28  SMOKE DETECTOR\n10:28  + MEADOWOOD RETIREMENT COMMUNITY\n10:28  OBTAIN ROOM NUMBER  and  WING\n10:29  610-584-1000\n10:29  W/N\n\nPrior Events ** WORC ** MEADOWOOD DR AND HOLLOW R ** E83 ** 
(UNKNOWN TYPE FIRE) Dispatch ** 18:44 ** UNKNOWN TYPE FIRE ** 14 ADAIR DR E ** - **  **  ** 64-25 **  ** 04/27/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308754\nIncident Received: 04-27-2013  18:44:40              Call Source:  10DIGIT\n\nCODE: FUN-UNKNOWN TYPE FIRE \n\n14 ADAIR DR E\nCross Street: GERMANTOWN PIKE AND METHACTON AVE\n\nMap: 64-25  Plan:   ADC: 3254H3  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n18:44  SEE FLAMES IN THE MIDDLE OF THE YARD\n18:44  FIRE IN THE BACKYARD\n\nPrior Events:\n----- -------\n\n\n ** WORC ** GERMANTOWN PIKE AND METHA ** T83  E83 ** 
(TRASH/DUMPSTER FIRE) Dispatch ** 17:35 ** TRASH/DUMPSTER FIRE ** VALLEY FORGE RD AND MORRIS RD ** - **  **  ** 64-02 **  ** 04/27/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308750\nIncident Received: 04-27-2013  17:35:53              Call Source:  10DIGIT\n\nCODE: FTR-TRASH/DUMPSTER FIRE \n\n   \nCross Street: VALLEY FORGE RD AND MORRIS RD\n\nMap: 64-02  Plan:   ADC: 3143H6  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n17:35  MALE SUBJ POSS W CONTROLLED BURN BUT ITS AT THE EDGE OF THE STREET\n17:35  ON MORRIS BY 363 IF GOING TWDS BLUE BELL\n\nPrior Events:\n----- -------\nF1226539    10-31-2012    FIRE POLICE NEEDED\nF1224143    10-18-2012    VEHICLE FIRE\n\n\n ** WORC ** VALLEY FORGE RD AND MORRI ** T83  E83 ** 
(FIRE ALARM) Dispatch ** 16:59 ** FIRE ALARM ** 3337 SKIPPACK PIKE ** - **  **  ** 64-06 **  ** 04/23/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308412\nIncident Received: 04-23-2013  16:59:10              Call Source:  10DIGIT\n\nCODE: FAL-FIRE ALARM \n\n3337 SKIPPACK PIKE \nCross Street: GREEN HILL RD AND CEDARS HILL RD\n\nMap: 64-06B Plan:   ADC: 3143B7  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n16:59  RESD-LAWRENCE TAYLOR 610/584-4905\n16:59  WILL ATTEMPT TO NOTIFY\n16:59  GENERALL FIRE ALARM\n\nPrior Events:\n----- -------\nF1214278    06-27-2012    FIRE ALARM\n\n\n ** WORC ** GREEN HILL RD AND CEDARS ** T83  E83 ** 
(BUILDING FIRE NON-COMMERCIAL) Dispatch ** 11:47 ** BUILDING FIRE NON-COMMERCIAL ** 3122 WATER STREET RD ** - **  **  ** 64-22 **  ** 04/21/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308226\nIncident Received: 04-21-2013  11:47:32              Call Source:  10DIGIT\n\nCODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n3122 WATER STREET RD \nCross Street: QUARRY HALL RD AND HOLLOW RD\n\nMap: 64-22B Plan:   ADC: 3255A2  MUN: WORC\n\nUnits Due:   T83  E83\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n11:47  HOUSE ON FIRE\n11:47  OUT OF THE HOUSE\n11:47  CAT INSIDE THE HOUSE\n11:48  BUSH ON FIRE UP AGAINST THE HOUSE\n\nPrior Events:\n----- -------\n\n\n ** WORC ** QUARRY HALL RD AND HOLLOW ** T83  E83 ** 

Contact: Active911
Agency name: Second Alarmers Rescue Squad
Location: Willow Grove, PA, United States
Sender: Beryl0908@comcast.net

(Dispatch) Dispatch ** 15:05:34 ** VEHICLE ACCIDENT INJURIES ** EASTON RD AND FITZWATERTOWN RD ** - **  **  ** 35-44 **  ** 2 VEH\n1 PARTY WITH NECK PAIN\n ** 05/08/13 ** VAI ** E1325328 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325328\nIncident Received: 05-08-2013  15:05:34              Call Source:  10DIGIT\n\nCODE: VA-VEHICLE ACCIDENT INJURIES\n\n   \nCross Street: EASTON RD AND FITZWATERTOWN RD\n\nMap: 35-44  Plan:   ADC: 3259A6  MUN: UMOR\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n15:05  2 VEH\n15:05  1 PARTY WITH NECK PAIN\n\nPrior Events:\n----- -------\nE1312954    03-05-2013    VEHICLE ACCIDENT\nE1306959    02-02-2013    VEHICLE ACCIDENT\n\n\n ** UMOR **  **  **  ** EASTON RD AND FITZWATERTOWN RD **  ** 381-5 ** 
(Dispatch) Dispatch ** 14:12:41 ** NAUSEA/VOMITING ** 1565 PROSPECT AVE ** - **  **  ** 29-C2 **  ** -075.122795 +040.131307\nVOMITING, SHAKING\n36/F\n ** 05/08/13 ** MNV ** E1325321 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325321\nIncident Received: 05-08-2013  14:12:41              Call Source:  10DIGIT\n\nCODE: MNV-NAUSEA/VOMITING \n\n1565 PROSPECT AVE \nCross Street: WASHINGTON AVE AND HAMILTON AVE\n\nMap: 29-C2  Plan:   ADC: 3259A10  MUN: ABGN\n\nUnits Due:   NC381\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n14:12  -075.122795 +040.131307\n14:12  VOMITING, SHAKING\n14:12  36/F\n\nPrior Events:\n----- -------\n\n\n ** ABGN **  **  **  ** WASHINGTON AVE AND HAMILTON AVE **  ** NC381 ** 
(Dispatch) Dispatch ** 13:52:59 ** ABDOMINAL PAINS ** 345 YORK RD N Apt# 1 ** HATBORO MEDICAL ASSOCIATES- **  **  ** 37-19 **  ** SPECIAL ADDRESS COMMENT:\nABDOMINAL PAIN\n59/F\nVALID SUITES AT LOCATION - REVERIFY\n ** 05/08/13 ** MAP ** E1325317 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325317\nIncident Received: 05-08-2013  13:52:59              Call Source:      911\n\nCODE: MAP-ABDOMINAL PAINS \nHATBORO MEDICAL ASSOCIATES\n345 YORK RD N Apt# 1\nCross Street: VILLAGE PL AND HOME RD\n\nMap: 37-19  Plan:   ADC: 3259D1  MUN: HATB\n\nUnits Due:   NC384\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n13:52  SPECIAL ADDRESS COMMENT:\n13:52  ABDOMINAL PAIN\n13:52  59/F\n13:52  VALID SUITES AT LOCATION - REVERIFY\n\nPrior Events:\n----- -------\nE1315621    03-19-2013    RESPIRATORY EMERGENCY\nE1310395    02-20-2013    CARDIAC EMERGENCY\nE1309974    02-18-2013    DIZZINESS\nE1309434    02-15-2013    RESPIRATORY EMERGENCY\nE1269892    12-27-2012    CARDIAC EMERGENCY\n\n\n ** HATB **  **  **  ** VILLAGE PL AND HOME RD **  ** NC384 ** 
(Dispatch) Dispatch ** 13:49:06 ** VEHICLE ACCIDENT INJURIES ** 3432 PENNSYLVANIA TPKE EB ** - **  **  ** 35-38 **  ** -075.120005 +040.161509\nBLK LINCOLN TOWNCAR\nDRIVER HAS BACK PAIN\n ** 05/08/13 ** VAI ** E1325316 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325316\nIncident Received: 05-08-2013  13:49:06              Call Source:      911\n\nCODE: VA-VEHICLE ACCIDENT INJURIES\n\n3432 PENNSYLVANIA TPKE EB\nCross Street: S YORK RD UNDERPASS AND RAMP RT611 TO I276 EB\n\nMap: 35-38  Plan:   ADC: 3259B5  MUN: UMOR\n\nUnits Due:   384-8\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n13:49  -075.120005 +040.161509\n13:49  BLK LINCOLN TOWNCAR\n13:49  DRIVER HAS BACK PAIN\n\nPrior Events:\n----- -------\nE1269860    12-27-2012    VEHICLE FIRE\n\n\n ** UMOR **  **  **  ** S YORK RD UNDERPASS AND RAMP RT611 TO I276 EB **  ** 384-8 ** 
(Dispatch) Dispatch ** 13:43:27 ** CVA/STROKE ** 1439 ST CHARLES PL ** - **  **  ** 29-B2 **  ** 46/M POSSIBLY HAVING A STROKE\nSLURRED SPEACH, PRIOR STROKE\nC/A\n ** 05/08/13 ** MCV ** E1325314 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325314\nIncident Received: 05-08-2013  13:43:27              Call Source:  10DIGIT\n\nCODE: MCV-CVA/STROKE \n\n1439 ST CHARLES PL \nCross Street: PERSHING AVE AND PATANE AVE\n\nMap: 29-B2  Plan:   ADC: 3258J9  MUN: ABGN\n\nUnits Due:   381-5\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n13:43  46/M POSSIBLY HAVING A STROKE\n13:43  SLURRED SPEACH, PRIOR STROKE\n13:43  C/A\n\nPrior Events:\n----- -------\nE1323448    04-29-2013    MEDICAL ALERT ALARM\nE1318405    04-03-2013    ABDOMINAL PAINS\nE1308892    02-12-2013    MEDICAL ALERT ALARM\nE1258039    10-30-2012    RESPIRATORY EMERGENCY\nE1246922    09-03-2012    DIABETIC EMERGENCY\n\n\n ** ABGN **  **  **  ** PERSHING AVE AND PATANE AVE **  ** 381-5 ** 
(Dispatch) Dispatch ** 11:24:31 ** MEDICAL ALERT ALARM ** 310 RAILROAD AVE ** - **  **  ** 46-21 **  ** ACTIVATION FROM PENDANT\nSTACY BREWER RESD\n267-460-8365\nNO CALL LIST\nHAVE PD CHECK THE RESD, NO EMS DISPATCH\n46-133 WILL VERIFY\nSUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\n ** 05/08/13 ** MMA ** E1325295 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325295\nIncident Received: 05-08-2013  11:24:31              Call Source:  10DIGIT\n\nCODE: MMA-MEDICAL ALERT ALARM \n\n310 RAILROAD AVE \nCross Street: W MT PLEASANT AVE AND OAK ST\n\nMap: 46-21  Plan:   ADC: 3257D5  MUN: WHPN\n\nUnits Due:   385ST\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n11:24  ACTIVATION FROM PENDANT\n11:24  STACY BREWER RESD\n11:24  267-460-8365\n11:24  NO CALL LIST\n11:26  HAVE PD CHECK THE RESD, NO EMS DISPATCH\n11:26  46-133 WILL VERIFY\n11:26  SUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\n\nPrior Events:\n----- -------\nE1325284    05-08-2013    CARDIAC EMERGENCY\nE1307493    02-05-2013    MEDICAL ALERT ALARM\nE1246911    09-03-2012    SEIZURES\n\n\n ** WHPN **  **  **  ** W MT PLEASANT AVE AND OAK ST **  ** 385ST ** 
(Dispatch) Dispatch ** 10:56:48 ** FEVER ** 3855 BLAIR MILL RD  Apt# 239D ** BLAIR MILL VILLAGE EAST APARTMENTS- **  **  ** 35-52 **  ** FEVER OF 100+\nCELULLIUS IN LEGS\n72/F\nC/A\n ** 05/08/13 ** MFE ** E1325291 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325291\nIncident Received: 05-08-2013  10:56:48              Call Source:      911\n\nCODE: MFE-FEVER \nBLAIR MILL VILLAGE EAST APARTMENTS\n3855 BLAIR MILL RD  Apt# 239D\nCross Street: W MORELAND AVE AND ALISON RD\n\nMap: 35-52  Plan:   ADC: 3259A2  MUN: UMOR\n\nUnits Due:   QX10  384-8\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n10:56  FEVER OF 100+\n10:56  CELULLIUS IN LEGS\n10:56  72/F\n10:56  C/A\n\nPrior Events:\n----- -------\nE1312301    03-02-2013    FALL VICTIM\nE1265983    12-08-2012    SUBJECT IN PAIN\n\n\n ** UMOR **  **  **  ** W MORELAND AVE AND ALISON RD **  ** QX10  384-8 ** 
(Dispatch) Dispatch ** 10:26:19 ** CARDIAC EMERGENCY ** 310 RAILROAD AVE ** - **  **  ** 46-21 **  ** CHEST PAINS\n3RD PARTY\n42/F\nC/A\nSOB\n ** 05/08/13 ** MCE ** E1325284 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325284\nIncident Received: 05-08-2013  10:26:19              Call Source:  10DIGIT\n\nCODE: MCE-CARDIAC EMERGENCY \n\n310 RAILROAD AVE \nCross Street: W MT PLEASANT AVE AND OAK ST\n\nMap: 46-21  Plan:   ADC: 3257D5  MUN: WHPN\n\nUnits Due:   385-3\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n10:26  CHEST PAINS\n10:26  3RD PARTY\n10:26  42/F\n10:27  C/A\n10:27  SOB\n\nPrior Events:\n----- -------\nE1307493    02-05-2013    MEDICAL ALERT ALARM\nE1246911    09-03-2012    SEIZURES\n\n\n ** WHPN **  **  **  ** W MT PLEASANT AVE AND OAK ST **  ** 385-3 ** 
(Dispatch) Dispatch ** 10:20:46 ** CVA/STROKE ** 1073 OLD YORK RD ** ABINGTON YMCA- **  **  ** 29-D3 **  **  ** 05/08/13 ** MCV ** E1325280 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325280\nIncident Received: 05-08-2013  10:20:46              Call Source:  10DIGIT\n\nCODE: MCV-CVA/STROKE \nABINGTON YMCA\n1073 OLD YORK RD \nCross Street: ADAMS AVE AND SUSQUEHANNA RD\n\nMap: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\nUnits Due:   NC382  383-13\n\nAdditional Info:\n---------- ----\nKNOX BOX LOCATED TO RIGHT OF PARKING LOT ATRIUM ENTRANCE APPROX 12FT HIGH (LADDER NEEDED).  BOX CONTAINS MASTER KEY, CONTACT INFO, ALARM CODE INFO.\n\nEvent Comments:\n----- ---------\n\nPrior Events:\n----- -------\nE1313951    03-11-2013    FALL VICTIM\nE1307253    02-04-2013    FRACTURE\nE1306667    02-01-2013    RESPIRATORY EMERGENCY\nE1306245    01-30-2013    FALL VICTIM\nE1252330    10-01-2012    UNCONSCIOUS SUBJECT\n\n\n ** ABGN **  **  **  ** ADAMS AVE AND SUSQUEHANNA RD **  ** NC382  383-13 ** 
(Dispatch) Dispatch ** 10:19:28 ** RESPIRATORY EMERGENCY ** 1515 THE FAIRWAY   Apt# 514 ** RYDAL PARK NURSING HOME- **  **  ** 29-E4 **  ** SPECIAL ADDRESS COMMENT:\n+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\nACCESS INFO AVAIL SEE AI NOTES.\nSPECIAL ADDRESS COMMENT:\nTROUBLE BREATHING/LABORED\nACCESS INFO AVAIL SEE AI NOTES.\n87/F\nMINIMALLY RESPONSIVE\n+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n ** 05/08/13 ** MRE ** E1325279 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325279\nIncident Received: 05-08-2013  10:19:28              Call Source:      911\n\nCODE: MRE-RESPIRATORY EMERGENCY \nRYDAL PARK NURSING HOME\n1515 THE FAIRWAY   Apt# 514\nCross Street: RYDAL RD AND RYDAL RD\n\nMap: 29-E4  Plan:   ADC: 3371B3  MUN: ABGN\n\nUnits Due:   NC382  383-13\n\nAdditional Info:\n---------- ----\n\nEvent Comments:\n----- ---------\n10:19  SPECIAL ADDRESS COMMENT:\n10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n10:19  ACCESS INFO AVAIL SEE AI NOTES.\n10:19  SPECIAL ADDRESS COMMENT:\n10:19  TROUBLE BREATHING/LABORED\n10:19  ACCESS INFO AVAIL SEE AI NOTES.\n10:19  87/F\n10:19  MINIMALLY RESPONSIVE\n10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n\nPrior Events:\n----- -------\nE1316058    03-21-2013    UNCONSCIOUS SUBJECT\n\n\n ** ABGN **  **  **  ** RYDAL RD AND RYDAL RD **  ** NC382  383-13 ** 

*/

public class PAMontgomeryCountyBParserTest extends BaseParserTest {
  
  public PAMontgomeryCountyBParserTest() {
    setParser(new PAMontgomeryCountyBParser(), "MONTGOMERY COUNTY", "PA");
  }
  
  @Test
  public void testKeithMeserole() {

    doTest("T1",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:18:02 ** VEHICLE ACCIDENT STAND-BY ** 2623 RIDGE PIKE ** TD BANK- ** 66-03 ** S TROOPER RD AND CLEARFIELD AVE **",

        "TIME:18:02",
        "CALL:VEHICLE ACCIDENT STAND-BY",
        "ADDR:2623 RIDGE PIKE",
        "PLACE:TD BANK",
        "MAP:66-03",
        "X:S TROOPER RD AND CLEARFIELD AVE");

    doTest("T2",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:00:39 ** UNKNOWN TYPE FIRE ** SUNDERLAND DR AND EAGLE STREAM DR ** - ** 66-02 ** SUNDERLAND DR A ND EAGLE STREAM DR **",

        "TIME:00:39",
        "CALL:UNKNOWN TYPE FIRE",
        "ADDR:SUNDERLAND DR AND EAGLE STREAM DR",
        "MADDR:SUNDERLAND DR & EAGLE STREAM DR",
        "MAP:66-02",
        "X:SUNDERLAND DR A ND EAGLE STREAM DR");

    doTest("T3",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:15:07 ** ELECTRICAL FIRE OUTSIDE ** 3108 MT KIRK AVE W ** - ** 66-02 ** MARILYN AVE AND OAKLYN AVE **",

        "TIME:15:07",
        "CALL:ELECTRICAL FIRE OUTSIDE",
        "ADDR:3108 MT KIRK AVE W",
        "MAP:66-02",
        "X:MARILYN AVE AND OAKLYN AVE");

    doTest("T4",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:18:50 ** RESCUE - ELEVATOR ** 20000 SHANNONDELL DR ** BRADFORD CLUBHOUSE - SHANNONDELL- ** 66-07   ** SHANNONDELL BLVD **",

        "TIME:18:50",
        "CALL:RESCUE - ELEVATOR",
        "ADDR:20000 SHANNONDELL DR",
        "PLACE:BRADFORD CLUBHOUSE - SHANNONDELL",
        "MAP:66-07",
        "X:SHANNONDELL BLVD");

    doTest("T5",
        "FRM:adi53@comcast.net\nSUBJ:Dispatch\nMSG:20:21 ** TRASH/DUMPSTER FIRE ** 2965 2ND ST ** - ** 66-03 ** HILLSIDE AVE **",
        "TIME:20:21",
        "CALL:TRASH/DUMPSTER FIRE",
        "ADDR:2965 2ND ST",
        "MAP:66-03",
        "X:HILLSIDE AVE");

    doTest("T6",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:20:46 ** FIRE ALARM ** 2769 RIDGE PIKE ** PARK RIDGE SHOPPING CENTER- ** 66-03 ** WAYNE AVE AND S PARK AVE **",

        "TIME:20:46",
        "CALL:FIRE ALARM",
        "ADDR:2769 RIDGE PIKE",
        "PLACE:PARK RIDGE SHOPPING CENTER",
        "MAP:66-03",
        "X:WAYNE AVE AND S PARK AVE");

    doTest("T7",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:19:34 ** FIRE ALARM ** 100 EAGLEVILLE RD ** LEVY BUILDING - EAGLEVILLE HOSPITAL- ** 66-02 ** PRISON RD AND MARILYN AVE **",

        "TIME:19:34",
        "CALL:FIRE ALARM",
        "ADDR:100 EAGLEVILLE RD",
        "PLACE:LEVY BUILDING - EAGLEVILLE HOSPITAL",
        "MAP:66-02",
        "X:PRISON RD AND MARILYN AVE");

    doTest("T8",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:23:13 ** FIRE INVESTIGATION ** 132 EVANSBURG RD ** - ** 66-01 ** GREENE MEADOW DR AND GERMANTOWN PIK **",

        "TIME:23:13",
        "CALL:FIRE INVESTIGATION",
        "ADDR:132 EVANSBURG RD",
        "MAP:66-01",
        "X:GREENE MEADOW DR AND GERMANTOWN PIK");

    doTest("T9",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:23:59 ** VEHICLE ACCIDENT RESCUE ** RIDGE PIKE AND N PARK AVE ** - ** 66-03 ** RIDGE PIKE AND N PARK AVE **",

        "TIME:23:59",
        "CALL:VEHICLE ACCIDENT RESCUE",
        "ADDR:RIDGE PIKE AND N PARK AVE",
        "MADDR:RIDGE PIKE & N PARK AVE",
        "MAP:66-03",
        "X:RIDGE PIKE AND N PARK AVE");

    doTest("T10",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:04:38 ** BUILDING FIRE COMMERCIAL ** 623 WILLOWBROOK DR ** - ** 62-05 ** EGYPT RD AND EGYPT RD **",

        "TIME:04:38",
        "CALL:BUILDING FIRE COMMERCIAL",
        "ADDR:623 WILLOWBROOK DR",
        "MAP:62-05",
        "X:EGYPT RD AND EGYPT RD");

    doTest("T11",
        "FRM:adi53@comcast.net\n" +
        "SUBJ:Dispatch\n" +
        "MSG:23:41 ** FIRE INVESTIGATION ** 2607 WOODLAND AVE ** - ** 66-03 ** S TROOPER RD AND ROGERS RD **",

        "TIME:23:41",
        "CALL:FIRE INVESTIGATION",
        "ADDR:2607 WOODLAND AVE",
        "MAP:66-03",
        "X:S TROOPER RD AND ROGERS RD");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Dispatch) Dispatch ** 16:09:15 ** HEAD INJURY ** 795 PENLLYN BLUE BELL PIKE ** SUNRISE ASSISTED LIVING- **  **  ** 46-18 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "AFTER A FALL -STRUCK HEAD ON PIANO\n" +
        "IN LOBBY AREA\n" +
        "OBTAIN ROOM NUMBER\n" +
        " ** 06/18/12 ** MHI ** E1232165 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232165\n" +
        "Incident Received: 06-18-2012  16:09:15              Call Source:      911\n\n" +
        "CODE: MHI-HEAD INJURY \n" +
        "SUNRISE ASSISTED LIVING\n" +
        "795 PENLLYN BLUE BELL PIKE \n" +
        "Cross Street: VILLAGE CIR AND PHIPPS WAY\n\n" +
        "Map: 46-18  Plan:   ADC: 3256H6  MUN: WHPN\n\n" +
        "Units Due:   QX33  385-10\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "DOOR CODE 4445*  - DO NOT BROADCAST\n\n" +
        "CABINET STYLE BOX LOCATED INSIDE OF BLDG,\n" +
        "ON RIGHT SIDE\n\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "16:09  SPECIAL ADDRESS COMMENT:\n" +
        "16:09  AFTER A FALL -STRUCK HEAD ON PIANO\n" +
        "16:09  IN LOBBY AREA\n" +
        "16:09  OBTAIN ROOM NUMBER\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1231853    06-16-2012    FEVER\n" +
        "E1229958    06-06-2012    ABDOMINAL PAINS\n" +
        "E1229801    06-06-2012    CVA/STROKE\n" +
        "E1226499    05-20-2012    HEAD INJURY\n" +
        "E1226410    05-19-2012    ASSAULT VICTIM\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** VILLAGE CIR AND PHIPPS WAY **  ** QX33  385-10 **",

        "TIME:16:09:15",
        "CALL:HEAD INJURY",
        "ADDR:795 PENLLYN BLUE BELL PIKE",
        "PLACE:SUNRISE ASSISTED LIVING",
        "MAP:46-18",
        "INFO:AFTER A FALL -STRUCK HEAD ON PIANO\nIN LOBBY AREA\nOBTAIN ROOM NUMBER\nAdditional Info:\n---------- ----\nDOOR CODE 4445*  - DO NOT BROADCAST\nCABINET STYLE BOX LOCATED INSIDE OF BLDG,\nON RIGHT SIDE\nEvent Comments:\n----- ---------\n16:09  SPECIAL ADDRESS COMMENT:\n16:09  AFTER A FALL -STRUCK HEAD ON PIANO\n16:09  IN LOBBY AREA\n16:09  OBTAIN ROOM NUMBER\nPrior Events:\n----- -------\nE1231853    06-16-2012    FEVER\nE1229958    06-06-2012    ABDOMINAL PAINS\nE1229801    06-06-2012    CVA/STROKE\nE1226499    05-20-2012    HEAD INJURY\nE1226410    05-19-2012    ASSAULT VICTIM",
        "DATE:06/18/12",
        "CODE:MHI",
        "ID:E1232165",
        "CITY:WHITPAIN TWP",
        "X:VILLAGE CIR AND PHIPPS WAY",
        "UNIT:QX33  385-10");

    doTest("T2",
        "(Dispatch) Dispatch ** 16:26:25 ** FALL VICTIM NON-TRAUMA ** 1521 BIRCHWOOD AVE ** - **  **  ** 29-B2 **  ** FELL GETTING OUT OF VEHICLE\n" +
        "PT LOCATED INSIDE THE HOME\n" +
        "POSSIBLE BROKEN RIGHT HIP\n" +
        "82 YOM\n" +
        "C/A\n" +
        " ** 06/18/12 ** MFV ** E1232169 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232169\n" +
        "Incident Received: 06-18-2012  16:26:25              Call Source:      911\n\n" +
        "CODE: MFV-FALL VICTIM NON-TRAUMA\n\n" +
        "1521 BIRCHWOOD AVE \n" +
        "Cross Street: PATANE AVE AND MIRIAM AVE\n\n" +
        "Map: 29-B2  Plan:   ADC: 3258J9  MUN: ABGN\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "16:26  FELL GETTING OUT OF VEHICLE\n" +
        "16:26  PT LOCATED INSIDE THE HOME\n" +
        "16:26  POSSIBLE BROKEN RIGHT HIP\n" +
        "16:26  82 YOM\n" +
        "16:26  C/A\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1166907    12-17-2011    FALL VICTIM\n" +
        "E1162913    11-26-2011    GENERAL WEAKNESS\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** PATANE AVE AND MIRIAM AVE **  ** 381-5 ** ",

        "TIME:16:26:25",
        "CALL:FALL VICTIM NON-TRAUMA",
        "ADDR:1521 BIRCHWOOD AVE",
        "MAP:29-B2",
        "INFO:FELL GETTING OUT OF VEHICLE\nPT LOCATED INSIDE THE HOME\nPOSSIBLE BROKEN RIGHT HIP\n82 YOM\nC/A\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n16:26  FELL GETTING OUT OF VEHICLE\n16:26  PT LOCATED INSIDE THE HOME\n16:26  POSSIBLE BROKEN RIGHT HIP\n16:26  82 YOM\n16:26  C/A\nPrior Events:\n----- -------\nE1166907    12-17-2011    FALL VICTIM\nE1162913    11-26-2011    GENERAL WEAKNESS",
        "DATE:06/18/12",
        "CODE:MFV",
        "ID:E1232169",
        "CITY:ABINGTON TWP",
        "X:PATANE AVE AND MIRIAM AVE",
        "UNIT:381-5");

    doTest("T3",
        "(Dispatch) Dispatch ** 17:17:02 ** SEIZURES ** 409 EASTON RD  Apt# H2 ** WILLOW HILL APARTMENTS- **  **  ** 35-42 **  ** FEMALE ACTIVELY SEIZING\n" +
        " ** 06/18/12 ** MSE ** E1232179 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232179\n" +
        "Incident Received: 06-18-2012  17:17:02              Call Source:  10DIGIT\n\n" +
        "CODE: MSE-SEIZURES \n" +
        "WILLOW HILL APARTMENTS\n" +
        "409 EASTON RD  Apt# H2\n" +
        "Cross Street: ALLISON RD AND BARRETT RD\n\n" +
        "Map: 35-42  Plan:   ADC: 3259A7  MUN: UMOR\n\n" +
        "Units Due:   QX10  381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:17  FEMALE ACTIVELY SEIZING\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** ALLISON RD AND BARRETT RD **  ** QX10  381-5 ** ",

        "TIME:17:17:02",
        "CALL:SEIZURES",
        "ADDR:409 EASTON RD",
        "APT:H2",
        "PLACE:WILLOW HILL APARTMENTS",
        "MAP:35-42",
        "INFO:FEMALE ACTIVELY SEIZING\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n17:17  FEMALE ACTIVELY SEIZING\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/18/12",
        "CODE:MSE",
        "ID:E1232179",
        "CITY:UPPER MORELAND TWP",
        "X:ALLISON RD AND BARRETT RD",
        "UNIT:QX10  381-5");

    doTest("T4",
        "(Dispatch) Dispatch ** 17:57:08 ** ASSAULT VICTIM ** 1200 OLD YORK RD ** ABINGTON MEMORIAL HOSPITAL - AMH- **  **  ** 29-D3 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "+ ABINGTON MEMORIAL HOSPITAL\n" +
        "not in progress\n" +
        "employee vs employee.\n" +
        "in the er. room 206.\n" +
        " ** 06/18/12 ** MAS ** E1232190 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232190\n" +
        "Incident Received: 06-18-2012  17:57:08              Call Source:  10DIGIT\n\n" +
        "CODE: MAS-ASSAULT VICTIM \n" +
        "ABINGTON MEMORIAL HOSPITAL - AMH\n" +
        "1200 OLD YORK RD \n" +
        "Cross Street: HORACE AVE AND WOODLAND RD\n\n" +
        "Map: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "LOCATED AT THE FOLLOWING LOCATIONS:\n" +
        "1) ELKINS BUILDING- YORK RD ENTRANCE\n\n" +
        "2) WIDENER BUILDING - SHORDAY LOBBY\n\n" +
        "3) PROFESSIONAL BUILDING - WUNDERLE LOBBY\n\n" +
        "4) TOLL BUILDING - E.R. TTRANSPORT (AMBULANCE) ENTRANCE\n" +
        "ON N. SIDE OF BUILDING.  BOX CONTAINS GRANDMASTER AND KEY\n" +
        "TO CONTROL GATE FOR UNDERGROUND LOADING DOCK.\n\n" +
        "Updated: 01/09/06 - 541\n\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:57  SPECIAL ADDRESS COMMENT:\n" +
        "17:57  + ABINGTON MEMORIAL HOSPITAL\n" +
        "17:57  not in progress\n" +
        "17:57  employee vs employee.\n" +
        "17:57  in the er. room 206.\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1230299    06-08-2012    UNKNOWN MEDICAL EMERGENCY\n" +
        "E1225645    05-15-2012    BEHAVIORAL/PSYCH EMERGENCY\n" +
        "E1222139    04-27-2012    FALL VICTIM\n" +
        "E1219693    04-15-2012    BEHAVIORAL/PSYCH EMERGENCY\n" +
        "E1219514    04-14-2012    BEHAVIORAL/PSYCH EMERGENCY\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** HORACE AVE AND WOODLAND RD **  ** 381-5 ** ",

        "TIME:17:57:08",
        "CALL:ASSAULT VICTIM",
        "ADDR:1200 OLD YORK RD",
        "PLACE:ABINGTON MEMORIAL HOSPITAL - AMH",
        "MAP:29-D3",
        "INFO:+ ABINGTON MEMORIAL HOSPITAL\nnot in progress\nemployee vs employee.\nin the er. room 206.\nAdditional Info:\n---------- ----\nLOCATED AT THE FOLLOWING LOCATIONS:\n1) ELKINS BUILDING- YORK RD ENTRANCE\n2) WIDENER BUILDING - SHORDAY LOBBY\n3) PROFESSIONAL BUILDING - WUNDERLE LOBBY\n4) TOLL BUILDING - E.R. TTRANSPORT (AMBULANCE) ENTRANCE\nON N. SIDE OF BUILDING.  BOX CONTAINS GRANDMASTER AND KEY\nTO CONTROL GATE FOR UNDERGROUND LOADING DOCK.\nUpdated: 01/09/06 - 541\nEvent Comments:\n----- ---------\n17:57  SPECIAL ADDRESS COMMENT:\n17:57  + ABINGTON MEMORIAL HOSPITAL\n17:57  not in progress\n17:57  employee vs employee.\n17:57  in the er. room 206.\nPrior Events:\n----- -------\nE1230299    06-08-2012    UNKNOWN MEDICAL EMERGENCY\nE1225645    05-15-2012    BEHAVIORAL/PSYCH EMERGENCY\nE1222139    04-27-2012    FALL VICTIM\nE1219693    04-15-2012    BEHAVIORAL/PSYCH EMERGENCY\nE1219514    04-14-2012    BEHAVIORAL/PSYCH EMERGENCY",
        "DATE:06/18/12",
        "CODE:MAS",
        "ID:E1232190",
        "CITY:ABINGTON TWP",
        "X:HORACE AVE AND WOODLAND RD",
        "UNIT:381-5");

    doTest("T5",
        "(Dispatch) Dispatch ** 18:35:29 ** ABDOMINAL PAINS ** 46 BARBARA RD ** - **  **  ** 35-80 **  ** ABDOMINAL PAINS ALSO BACK PAINS\n" +
        "C/A\n" +
        "89 YOM\n" +
        "UNABLE TO WALK\n" +
        " ** 06/18/12 ** MAP ** E1232193 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232193\n" +
        "Incident Received: 06-18-2012  18:35:29              Call Source:      911\n\n" +
        "CODE: MAP-ABDOMINAL PAINS \n\n" +
        "46 BARBARA RD \n" +
        "Cross Street: CRESCENT RD AND NORWYN RD\n\n" +
        "Map: 35-80  Plan:   ADC: 3147C10  MUN: UMOR\n\n" +
        "Units Due:   QX10  384-4\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:35  ABDOMINAL PAINS ALSO BACK PAINS\n" +
        "18:35  C/A\n" +
        "18:35  89 YOM\n" +
        "18:35  UNABLE TO WALK\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1207336    02-09-2012    OVERDOSE\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** CRESCENT RD AND NORWYN RD **  ** QX10  384-4 ** ",

        "TIME:18:35:29",
        "CALL:ABDOMINAL PAINS",
        "ADDR:46 BARBARA RD",
        "MAP:35-80",
        "INFO:ABDOMINAL PAINS ALSO BACK PAINS\nC/A\n89 YOM\nUNABLE TO WALK\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n18:35  ABDOMINAL PAINS ALSO BACK PAINS\n18:35  C/A\n18:35  89 YOM\n18:35  UNABLE TO WALK\nPrior Events:\n----- -------\nE1207336    02-09-2012    OVERDOSE",
        "DATE:06/18/12",
        "CODE:MAP",
        "ID:E1232193",
        "CITY:UPPER MORELAND TWP",
        "X:CRESCENT RD AND NORWYN RD",
        "UNIT:QX10  384-4");

    doTest("T6",
        "(Dispatch) Dispatch ** 18:59:12 ** SEIZURES ** 240 COUNTY LINE RD E Apt# E3 ** LIVINGSTONE APARTMENTS- **  **  ** 37-20 **  ** 82/F HAVING A DIABETIC SEIZURE\n" +
        " ** 06/18/12 ** MSE ** E1232199 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232199\n" +
        "Incident Received: 06-18-2012  18:59:12              Call Source:      911\n\n" +
        "CODE: MSE-SEIZURES \n" +
        "LIVINGSTONE APARTMENTS\n" +
        "240 COUNTY LINE RD E Apt# E3\n" +
        "Cross Street: MADISON AVE AND PARK AVE\n\n" +
        "Map: 37-20  Plan:   ADC: 3259E1  MUN: HATB\n\n" +
        "Units Due:   NC384\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:59  82/F HAVING A DIABETIC SEIZURE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1133514    06-26-2011    FALL VICTIM\n" +
        "\n\n" +
        " ** HATB **  **  **  ** MADISON AVE AND PARK AVE **  ** NC384 ** ",

        "TIME:18:59:12",
        "CALL:SEIZURES",
        "ADDR:240 COUNTY LINE RD E",
        "APT:E3",
        "PLACE:LIVINGSTONE APARTMENTS",
        "MAP:37-20",
        "INFO:82/F HAVING A DIABETIC SEIZURE\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n18:59  82/F HAVING A DIABETIC SEIZURE\nPrior Events:\n----- -------\nE1133514    06-26-2011    FALL VICTIM",
        "DATE:06/18/12",
        "CODE:MSE",
        "ID:E1232199",
        "CITY:HATBORO",
        "X:MADISON AVE AND PARK AVE",
        "UNIT:NC384");

    doTest("T7",
        "(Dispatch) Dispatch ** 19:29:31 ** CARDIAC EMERGENCY ** 2329 OLD WELSH RD ** - **  **  ** 29-C1 **  ** ROOMING HOUSE\n" +
        "PT IS UPSTAIRS\n" +
        "66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\n" +
        "C/A BREATHING LABORED\n" +
        " ** 06/18/12 ** MCE ** E1232202 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232202\n" +
        "Incident Received: 06-18-2012  19:29:31              Call Source:  10DIGIT\n\n" +
        "CODE: MCE-CARDIAC EMERGENCY \n\n" +
        "2329 OLD WELSH RD \n" +
        "Cross Street: SUMMIT AVE AND EASTON RD\n\n" +
        "Map: 29-C1  Plan:   ADC: 3259A9  MUN: ABGN\n\n" +
        "Units Due:   NC381\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:29  ROOMING HOUSE\n" +
        "19:29  PT IS UPSTAIRS\n" +
        "19:29  66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\n" +
        "19:29  C/A BREATHING LABORED\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** SUMMIT AVE AND EASTON RD **  ** NC381 ** ",

        "TIME:19:29:31",
        "CALL:CARDIAC EMERGENCY",
        "ADDR:2329 OLD WELSH RD",
        "MAP:29-C1",
        "INFO:ROOMING HOUSE\nPT IS UPSTAIRS\n66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\nC/A BREATHING LABORED\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n19:29  ROOMING HOUSE\n19:29  PT IS UPSTAIRS\n19:29  66/M WITH CHEST PAIN AND TINGLING IN HIS ARMS\n19:29  C/A BREATHING LABORED\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/18/12",
        "CODE:MCE",
        "ID:E1232202",
        "CITY:ABINGTON TWP",
        "X:SUMMIT AVE AND EASTON RD",
        "UNIT:NC381");

    doTest("T8",
        "(Dispatch) Dispatch ** 19:29:49 ** CARDIAC EMERGENCY ** 3940 COMMERCE AVE  Apt# A ** DA VITA DIALYSIS ABINGTON (DAVITA)- **  **  ** 35-58 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "CHEST PAIN / INCREASED HEART RATE\n" +
        "F/60'S\n" +
        "C/A - BREATHING NORMAL\n" +
        "MED STAFF WITH PT\n" +
        " ** 06/18/12 ** MCE ** E1232203 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232203\n" +
        "Incident Received: 06-18-2012  19:29:49              Call Source:      911\n\n" +
        "CODE: MCE-CARDIAC EMERGENCY \n" +
        "DA VITA DIALYSIS ABINGTON (DAVITA)\n" +
        "3940 COMMERCE AVE  Apt# A\n" +
        "Cross Street: MARYLAND RD AND MARYLAND RD\n\n" +
        "Map: 35-58  Plan:   ADC: 3258J4  MUN: UMOR\n\n" +
        "Units Due:   QX10  NC384\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:29  SPECIAL ADDRESS COMMENT:\n" +
        "19:29  VALID SUITES AT LOCATION - REVERIFY\n" +
        "19:29  CHEST PAIN / INCREASED HEART RATE\n" +
        "19:29  F/60'S\n" +
        "19:29  C/A - BREATHING NORMAL\n" +
        "19:29  MED STAFF WITH PT\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1227259    05-24-2012    CARDIAC EMERGENCY\n" +
        "E1219148    04-12-2012    FALL VICTIM\n" +
        "E1217228    04-02-2012    CARDIAC EMERGENCY\n" +
        "E1212374    03-07-2012    CARDIAC EMERGENCY\n" +
        "E1210345    02-25-2012    CARDIAC EMERGENCY\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** MARYLAND RD AND MARYLAND RD **  ** QX10  NC384 ** ",

        "TIME:19:29:49",
        "CALL:CARDIAC EMERGENCY",
        "ADDR:3940 COMMERCE AVE",
        "APT:A",
        "PLACE:DA VITA DIALYSIS ABINGTON (DAVITA)",
        "MAP:35-58",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\nCHEST PAIN / INCREASED HEART RATE\nF/60'S\nC/A - BREATHING NORMAL\nMED STAFF WITH PT\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n19:29  SPECIAL ADDRESS COMMENT:\n19:29  VALID SUITES AT LOCATION - REVERIFY\n19:29  CHEST PAIN / INCREASED HEART RATE\n19:29  F/60'S\n19:29  C/A - BREATHING NORMAL\n19:29  MED STAFF WITH PT\nPrior Events:\n----- -------\nE1227259    05-24-2012    CARDIAC EMERGENCY\nE1219148    04-12-2012    FALL VICTIM\nE1217228    04-02-2012    CARDIAC EMERGENCY\nE1212374    03-07-2012    CARDIAC EMERGENCY\nE1210345    02-25-2012    CARDIAC EMERGENCY",
        "DATE:06/18/12",
        "CODE:MCE",
        "ID:E1232203",
        "CITY:UPPER MORELAND TWP",
        "X:MARYLAND RD AND MARYLAND RD",
        "UNIT:QX10  NC384");

    doTest("T9",
        "(Dispatch) Dispatch ** 19:45:05 ** FALL VICTIM TRAUMA ** 1750 ARCH STREET RD ** - **  **  ** 46-36 **  ** LANGUAGE BARRIER\n" +
        "CALLER STATING SOMEONE FELL OFF A LADDER\n" +
        " ** 06/18/12 ** MFV ** E1232207 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232207\n" +
        "Incident Received: 06-18-2012  19:45:05              Call Source:  10DIGIT\n\n" +
        "CODE: MFV-FALL VICTIM TRAUMA\n\n" +
        "1750 ARCH STREET RD \n" +
        "Cross Street: NETHERWOOD DR AND COOPER AVE\n\n" +
        "Map: 46-36  Plan:   ADC: 3256C7  MUN: WHPN\n\n" +
        "Units Due:   385-3\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:45  LANGUAGE BARRIER\n" +
        "19:45  CALLER STATING SOMEONE FELL OFF A LADDER\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** NETHERWOOD DR AND COOPER AVE **  ** 385-3 ** ",

        "TIME:19:45:05",
        "CALL:FALL VICTIM TRAUMA",
        "ADDR:1750 ARCH STREET RD",
        "MAP:46-36",
        "INFO:LANGUAGE BARRIER\nCALLER STATING SOMEONE FELL OFF A LADDER\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n19:45  LANGUAGE BARRIER\n19:45  CALLER STATING SOMEONE FELL OFF A LADDER\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/18/12",
        "CODE:MFV",
        "ID:E1232207",
        "CITY:WHITPAIN TWP",
        "X:NETHERWOOD DR AND COOPER AVE",
        "UNIT:385-3");

    doTest("T10",
        "(Dispatch) Dispatch ** 03:23:37 ** RESPIRATORY EMERGENCY ** 11 WOODHILL DR ** - **  **  ** 35-47 **  ** DIF BREATHING\n" +
        "PT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\n" +
        "C/A\n" +
        "M/57\n" +
        " ** 06/19/12 ** MRE ** E1232242 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232242\n" +
        "Incident Received: 06-19-2012  03:23:37              Call Source:      911\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n\n" +
        "11 WOODHILL DR \n" +
        "Cross Street: FITZWATERTOWN RD AND RUSSELL RD\n\n" +
        "Map: 35-47  Plan:   ADC: 3258K6  MUN: UMOR\n\n" +
        "Units Due:   381-2\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "03:23  DIF BREATHING\n" +
        "03:23  PT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\n" +
        "03:23  C/A\n" +
        "03:23  M/57\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** FITZWATERTOWN RD AND RUSSELL RD **  ** 381-2 ** ",

        "TIME:03:23:37",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:11 WOODHILL DR",
        "MAP:35-47",
        "INFO:DIF BREATHING\nPT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\nC/A\nM/57\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n03:23  DIF BREATHING\n03:23  PT FEEL OUT OF BED - PT IS IN PAIN - UNK WHERE\n03:23  C/A\n03:23  M/57\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MRE",
        "ID:E1232242",
        "CITY:UPPER MORELAND TWP",
        "X:FITZWATERTOWN RD AND RUSSELL RD",
        "UNIT:381-2");

    doTest("T11",
        "(Dispatch) Dispatch ** 07:09:31 ** RESPIRATORY EMERGENCY ** 1120 YORK RD N Apt# 322 ** WILLOW LAKE RETIREMENT HOME- **  **  ** 35-35 **  ** 70 YOM\n" +
        "MEDICAL STAFF ON SCENE\n" +
        "PULSE OX 94&#x45;\n" +
        " ** 06/19/12 ** MRE ** E1232256 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232256\n" +
        "Incident Received: 06-19-2012  07:09:31              Call Source:      911\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n" +
        "WILLOW LAKE RETIREMENT HOME\n" +
        "1120 YORK RD N Apt# 322\n" +
        "Cross Street: LAKEVUE DR AND FITZWATERTOWN RD\n\n" +
        "Map: 35-35  Plan:   ADC: 3259B5  MUN: UMOR\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "07:09  70 YOM\n" +
        "07:09  MEDICAL STAFF ON SCENE\n" +
        "07:09  PULSE OX 94&#x45;\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** LAKEVUE DR AND FITZWATERTOWN RD **  ** 381-5 ** ",

        "TIME:07:09:31",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:1120 YORK RD N",
        "APT:322",
        "PLACE:WILLOW LAKE RETIREMENT HOME",
        "MAP:35-35",
        "INFO:70 YOM\nMEDICAL STAFF ON SCENE\nPULSE OX 94&#x45;\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n07:09  70 YOM\n07:09  MEDICAL STAFF ON SCENE\n07:09  PULSE OX 94&#x45;\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MRE",
        "ID:E1232256",
        "CITY:UPPER MORELAND TWP",
        "X:LAKEVUE DR AND FITZWATERTOWN RD",
        "UNIT:381-5");

    doTest("T12",
        "(Dispatch) Dispatch ** 09:02:11 ** VEHICLE ACCIDENT INJURIES ** 3390 PENNSYLVANIA TPKE WB ** - **  **  ** 41-34 **  ** REC VEH INTO TT\n" +
        "DRIVER OF REC VEH APPEARS TO BE INJ\n" +
        "REC VEH/MOBILE HOME\n" +
        "WINDSHIELD CRACKED\n" +
        "CALLER IS PASSERBY\n" +
        " ** 06/19/12 ** VAI ** E1232273 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232273\n" +
        "Incident Received: 06-19-2012  09:02:11              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT INJURIES\n\n" +
        "3390 PENNSYLVANIA TPKE WB\n" +
        "Cross Street: CAMP HILL RD OVERPASS AND RAMP VIRGINIA DR TO I276 WB\n\n" +
        "Map: 41-34  Plan:   ADC: 3258A9  MUN: UDUB\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:02  REC VEH INTO TT\n" +
        "09:02  DRIVER OF REC VEH APPEARS TO BE INJ\n" +
        "09:02  REC VEH/MOBILE HOME\n" +
        "09:02  WINDSHIELD CRACKED\n" +
        "09:02  CALLER IS PASSERBY\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1221542    04-24-2012    CARDIAC EMERGENCY\n" +
        "\n\n" +
        " ** UDUB **  **  **  ** CAMP HILL RD OVERPASS AND RAMP VIRGINIA DR TO I276 WB **  ** 381-5 ** ",

        "TIME:09:02:11",
        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:3390 PENNSYLVANIA TPKE WB",
        "MADDR:3390 PENNSYLVANIA TPKE",
        "MAP:41-34",
        "INFO:REC VEH INTO TT\nDRIVER OF REC VEH APPEARS TO BE INJ\nREC VEH/MOBILE HOME\nWINDSHIELD CRACKED\nCALLER IS PASSERBY\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n09:02  REC VEH INTO TT\n09:02  DRIVER OF REC VEH APPEARS TO BE INJ\n09:02  REC VEH/MOBILE HOME\n09:02  WINDSHIELD CRACKED\n09:02  CALLER IS PASSERBY\nPrior Events:\n----- -------\nE1221542    04-24-2012    CARDIAC EMERGENCY",
        "DATE:06/19/12",
        "CODE:VAI",
        "ID:E1232273",
        "CITY:UPPER DUBLIN TWP",
        "X:CAMP HILL RD OVERPASS AND RAMP VIRGINIA DR TO I276 WB",
        "UNIT:381-5");

    doTest("T13",
        "(Dispatch) Dispatch ** 10:04:05 ** CVA/STROKE ** 721 SKIPPACK PIKE  Apt# 3 ** BROAD AXE FAMILY MEDICINE- **  **  ** 46-15 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "78 YOF\n" +
        "MEDICAL STAFF ON SCENE\n" +
        "C/A\n" +
        "BREATHING OK\n" +
        "HX: NONE\n" +
        " ** 06/19/12 ** MCV ** E1232286 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232286\n" +
        "Incident Received: 06-19-2012  10:04:05              Call Source:      911\n\n" +
        "CODE: MCV-CVA/STROKE \n" +
        "BROAD AXE FAMILY MEDICINE\n" +
        "721 SKIPPACK PIKE  Apt# 3\n" +
        "Cross Street: PENLLYN BLUE BELL PIKE AND LENMAR DR\n\n" +
        "Map: 46-15  Plan:   ADC: 3256G6  MUN: WHPN\n\n" +
        "Units Due:   385-10\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:04  SPECIAL ADDRESS COMMENT:\n" +
        "10:04  VALID SUITES AT LOCATION - REVERIFY\n" +
        "10:04  78 YOF\n" +
        "10:04  MEDICAL STAFF ON SCENE\n" +
        "10:04  C/A\n" +
        "10:04  BREATHING OK\n" +
        "10:04  HX: NONE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1228888    06-01-2012    BACK PAINS/INJURY\n" +
        "E1222075    04-27-2012    RESPIRATORY EMERGENCY\n" +
        "E1209632    02-21-2012    HEAD INJURY\n" +
        "E1167853    12-22-2011    GENERAL WEAKNESS\n" +
        "E1162172    11-22-2011    FEVER\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** PENLLYN BLUE BELL PIKE AND LENMAR DR **  ** 385-10 ** ",

        "TIME:10:04:05",
        "CALL:CVA/STROKE",
        "ADDR:721 SKIPPACK PIKE",
        "APT:3",
        "PLACE:BROAD AXE FAMILY MEDICINE",
        "MAP:46-15",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\n78 YOF\nMEDICAL STAFF ON SCENE\nC/A\nBREATHING OK\nHX: NONE\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n10:04  SPECIAL ADDRESS COMMENT:\n10:04  VALID SUITES AT LOCATION - REVERIFY\n10:04  78 YOF\n10:04  MEDICAL STAFF ON SCENE\n10:04  C/A\n10:04  BREATHING OK\n10:04  HX: NONE\nPrior Events:\n----- -------\nE1228888    06-01-2012    BACK PAINS/INJURY\nE1222075    04-27-2012    RESPIRATORY EMERGENCY\nE1209632    02-21-2012    HEAD INJURY\nE1167853    12-22-2011    GENERAL WEAKNESS\nE1162172    11-22-2011    FEVER",
        "DATE:06/19/12",
        "CODE:MCV",
        "ID:E1232286",
        "CITY:WHITPAIN TWP",
        "X:PENLLYN BLUE BELL PIKE AND LENMAR DR",
        "UNIT:385-10");

    doTest("T14",
        "(Dispatch) Dispatch ** 10:40:08 ** FRACTURE ** 324 PENN ST N ** - **  **  ** 37-19 **  ** Event stacked at: 06/19/12 10:39:56\n" +
        " ** 06/19/12 ** MFX ** E1232297 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232297\n" +
        "Incident Received: 06-19-2012  10:40:08              Call Source:  10DIGIT\n\n" +
        "CODE: MFX-FRACTURE \n\n" +
        "324 PENN ST N\n" +
        "Cross Street: SUMMIT AVE AND MEADOWBROOK AVE\n\n" +
        "Map: 37-19  Plan:   ADC: 3259D1  MUN: HATB\n\n" +
        "Units Due:   384-4\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:40  Event stacked at: 06/19/12 10:39:56\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1203368    01-19-2012    RESPIRATORY EMERGENCY\n" +
        "E1159293    11-07-2011    RESPIRATORY EMERGENCY\n" +
        "\n\n" +
        " ** HATB **  **  **  ** SUMMIT AVE AND MEADOWBROOK AVE **  ** 384-4 ** ",

        "TIME:10:40:08",
        "CALL:FRACTURE",
        "ADDR:324 PENN ST N",
        "MAP:37-19",
        "INFO:Event stacked at: 06/19/12 10:39:56\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n10:40  Event stacked at: 06/19/12 10:39:56\nPrior Events:\n----- -------\nE1203368    01-19-2012    RESPIRATORY EMERGENCY\nE1159293    11-07-2011    RESPIRATORY EMERGENCY",
        "DATE:06/19/12",
        "CODE:MFX",
        "ID:E1232297",
        "CITY:HATBORO",
        "X:SUMMIT AVE AND MEADOWBROOK AVE",
        "UNIT:384-4");

    doTest("T15",
        "(Dispatch) Dispatch ** 11:28:32 ** CVA/STROKE ** 39 MORELAND AVE E ** - **  **  ** 37-13 **  ** 83/F\n" +
        " ** 06/19/12 ** MCV ** E1232300 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232300\n" +
        "Incident Received: 06-19-2012  11:28:32              Call Source:      911\n\n" +
        "CODE: MCV-CVA/STROKE \n\n" +
        "39 MORELAND AVE E\n" +
        "Cross Street: N YORK RD AND N PENN ST\n\n" +
        "Map: 37-13  Plan:   ADC: 3259D2  MUN: HATB\n\n" +
        "Units Due:   384-4\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:28  83/F\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1214760    03-20-2012    RESPIRATORY EMERGENCY\n" +
        "E1153829    10-09-2011    MEDICAL ALERT ALARM\n" +
        "\n\n" +
        " ** HATB **  **  **  ** N YORK RD AND N PENN ST **  ** 384-4 ** ",

        "TIME:11:28:32",
        "CALL:CVA/STROKE",
        "ADDR:39 MORELAND AVE E",
        "MAP:37-13",
        "INFO:83/F\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n11:28  83/F\nPrior Events:\n----- -------\nE1214760    03-20-2012    RESPIRATORY EMERGENCY\nE1153829    10-09-2011    MEDICAL ALERT ALARM",
        "DATE:06/19/12",
        "CODE:MCV",
        "ID:E1232300",
        "CITY:HATBORO",
        "X:N YORK RD AND N PENN ST",
        "UNIT:384-4");

    doTest("T16",
        "(Dispatch) Dispatch ** 11:41:02 ** HEMORRHAGING ** 1001 EASTON RD  Apt# 803 ** REGENCY PARK TOWERS MANOR BUILDING- **  **  ** 35-44 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "86/F FINGER STILL BLEEDING FROM A PAST LACERATION\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        " ** 06/19/12 ** MHM ** E1232302 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232302\n" +
        "Incident Received: 06-19-2012  11:41:02              Call Source:      911\n\n" +
        "CODE: MHM-HEMORRHAGING \n" +
        "REGENCY PARK TOWERS MANOR BUILDING\n" +
        "1001 EASTON RD  Apt# 803\n" +
        "Cross Street: RUSSELL RD AND FITZWATERTOWN RD\n\n" +
        "Map: 35-44  Plan:   ADC: 3259A6  MUN: UMOR\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:41  SPECIAL ADDRESS COMMENT:\n" +
        "11:41  VALID SUITES AT LOCATION - REVERIFY\n" +
        "11:41  86/F FINGER STILL BLEEDING FROM A PAST LACERATION\n" +
        "11:41  VALID SUITES AT LOCATION - REVERIFY\n" +
        "11:41  SPECIAL ADDRESS COMMENT:\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** RUSSELL RD AND FITZWATERTOWN RD **  ** 381-5 ** ",

        "TIME:11:41:02",
        "CALL:HEMORRHAGING",
        "ADDR:1001 EASTON RD",
        "APT:803",
        "PLACE:REGENCY PARK TOWERS MANOR BUILDING",
        "MAP:35-44",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\n86/F FINGER STILL BLEEDING FROM A PAST LACERATION\nVALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n11:41  SPECIAL ADDRESS COMMENT:\n11:41  VALID SUITES AT LOCATION - REVERIFY\n11:41  86/F FINGER STILL BLEEDING FROM A PAST LACERATION\n11:41  VALID SUITES AT LOCATION - REVERIFY\n11:41  SPECIAL ADDRESS COMMENT:\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MHM",
        "ID:E1232302",
        "CITY:UPPER MORELAND TWP",
        "X:RUSSELL RD AND FITZWATERTOWN RD",
        "UNIT:381-5");

    doTest("T17",
        "(Dispatch) Dispatch ** 11:56:01 ** ALTERED MENTAL STATUS ** 777 DEKALB PIKE  Apt# 234 ** BLUE BELL PLACE- **  **  ** 46-07 **  ** C/NOT ALERT\n" +
        " ** 06/19/12 ** MMS ** E1232303 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232303\n" +
        "Incident Received: 06-19-2012  11:56:01              Call Source:  10DIGIT\n\n" +
        "CODE: MMS-ALTERED MENTAL STATUS \n" +
        "BLUE BELL PLACE\n" +
        "777 DEKALB PIKE  Apt# 234\n" +
        "Cross Street: BLUE BELL SPRINGS DR AND SKIPPACK PIKE\n\n" +
        "Map: 46-07  Plan:   ADC: 3256D3  MUN: WHPN\n\n" +
        "Units Due:   385-10\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:56  C/NOT ALERT\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** BLUE BELL SPRINGS DR AND SKIPPACK PIKE **  ** 385-10 ** ",

        "TIME:11:56:01",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:777 DEKALB PIKE",
        "APT:234",
        "PLACE:BLUE BELL PLACE",
        "MAP:46-07",
        "INFO:C/NOT ALERT\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n11:56  C/NOT ALERT\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MMS",
        "ID:E1232303",
        "CITY:WHITPAIN TWP",
        "X:BLUE BELL SPRINGS DR AND SKIPPACK PIKE",
        "UNIT:385-10");

    doTest("T18",
        "(Dispatch) Dispatch ** 12:33:07 ** SEIZURES ** 2600 TURNPIKE DR ** READ'S VAN SERVICE- **  **  ** 35-77 **  ** MALE\n" +
        "AGE UNKNOWN/EMPLOYEE\n" +
        "PT LOCATED IN WAREHOUSE\n" +
        " ** 06/19/12 ** MSE ** E1232319 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232319\n" +
        "Incident Received: 06-19-2012  12:33:07              Call Source:      911\n\n" +
        "CODE: MSE-SEIZURES \n" +
        "READ'S VAN SERVICE\n" +
        "2600 TURNPIKE DR \n" +
        "Cross Street: DAVISVILLE RD \n\n" +
        "Map: 35-77  Plan:   ADC: 3259E4  MUN: UMOR\n\n" +
        "Units Due:   QX10  381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "12:33  MALE\n" +
        "12:33  AGE UNKNOWN/EMPLOYEE\n" +
        "12:33  PT LOCATED IN WAREHOUSE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** DAVISVILLE RD **  ** QX10  381-5 ** ",

        "TIME:12:33:07",
        "CALL:SEIZURES",
        "ADDR:2600 TURNPIKE DR",
        "PLACE:READ'S VAN SERVICE",
        "MAP:35-77",
        "INFO:MALE\nAGE UNKNOWN/EMPLOYEE\nPT LOCATED IN WAREHOUSE\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n12:33  MALE\n12:33  AGE UNKNOWN/EMPLOYEE\n12:33  PT LOCATED IN WAREHOUSE\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MSE",
        "ID:E1232319",
        "CITY:UPPER MORELAND TWP",
        "X:DAVISVILLE RD",
        "UNIT:QX10  381-5");

    doTest("T19",
        "(Dispatch) Dispatch ** 14:30:48 ** UNKNOWN MEDICAL EMERGENCY ** 1741 ROCKWELL RD ** - **  **  ** 29-C1 **  ** UNCLE VS 13 YO NEICE\n" +
        "STILL ACTING UP FROM EARLIER TODAY\n" +
        "CALLER WANTS PD TO REMOVE HER\n" +
        "FEM IS ANNIE MYERS\n" +
        "W/F WEARING BLU SHIRT  and  JEAN SHORTS\n" +
        "NO WEAPONS, NO INTOX\n" +
        "FEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n" +
        "2911 -- DISREGARD STATUS CHECKS\n" +
        "2914- EMS TO CHECK ON FEMALE SUBJ\n" +
        " ** 06/19/12 ** MUN ** E1232336 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232336\n" +
        "Incident Received: 06-19-2012  14:30:48              Call Source:  10DIGIT\n\n" +
        "CODE: MUN-UNKNOWN MEDICAL EMERGENCY \n\n" +
        "1741 ROCKWELL RD \n" +
        "Cross Street: RUBICAM AVE AND TREMONT AVE\n\n" +
        "Map: 29-C1  Plan:   ADC: 3259B9  MUN: ABGN\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "14:09  UNCLE VS 13 YO NEICE\n" +
        "14:09  STILL ACTING UP FROM EARLIER TODAY\n" +
        "14:09  CALLER WANTS PD TO REMOVE HER\n" +
        "14:09  FEM IS ANNIE MYERS\n" +
        "14:10  W/F WEARING BLU SHIRT  and  JEAN SHORTS\n" +
        "14:10  NO WEAPONS, NO INTOX\n" +
        "14:10  FEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n" +
        "14:17  2911 -- DISREGARD STATUS CHECKS\n" +
        "14:30  2914- EMS TO CHECK ON FEMALE SUBJ\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** RUBICAM AVE AND TREMONT AVE **  ** 381-5 ** ",

        "TIME:14:30:48",
        "CALL:UNKNOWN MEDICAL EMERGENCY",
        "ADDR:1741 ROCKWELL RD",
        "MAP:29-C1",
        "INFO:UNCLE VS 13 YO NEICE\nSTILL ACTING UP FROM EARLIER TODAY\nCALLER WANTS PD TO REMOVE HER\nFEM IS ANNIE MYERS\nW/F WEARING BLU SHIRT  and  JEAN SHORTS\nNO WEAPONS, NO INTOX\nFEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n2911 -- DISREGARD STATUS CHECKS\n2914- EMS TO CHECK ON FEMALE SUBJ\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n14:09  UNCLE VS 13 YO NEICE\n14:09  STILL ACTING UP FROM EARLIER TODAY\n14:09  CALLER WANTS PD TO REMOVE HER\n14:09  FEM IS ANNIE MYERS\n14:10  W/F WEARING BLU SHIRT  and  JEAN SHORTS\n14:10  NO WEAPONS, NO INTOX\n14:10  FEM IS IN THE LIVING ROOM, CALLER IS WAITING ON THE FRONT PORCH\n14:17  2911 -- DISREGARD STATUS CHECKS\n14:30  2914- EMS TO CHECK ON FEMALE SUBJ\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MUN",
        "ID:E1232336",
        "CITY:ABINGTON TWP",
        "X:RUBICAM AVE AND TREMONT AVE",
        "UNIT:381-5");

    doTest("T20",
        "(Dispatch) Dispatch ** 15:29:36 ** VEHICLE ACCIDENT INJURIES ** 2200 MT CARMEL AVE ** - **  **  ** 29-C6 **  ** 4 VEHS - REQ EMS\n" +
        "ON THE 2200 BLOCK OF...\n" +
        " ** 06/19/12 ** VAI ** E1232350 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232350\n" +
        "Incident Received: 06-19-2012  15:29:36              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT INJURIES\n\n" +
        "2200 MT CARMEL AVE \n" +
        "Cross Street: KESWICK AVE AND WOODLYN AVE\n\n" +
        "Map: 29-C6  Plan:   ADC: 3370G4  MUN: ABGN\n\n" +
        "Units Due:   383-13\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "15:29  4 VEHS - REQ EMS\n" +
        "15:29  ON THE 2200 BLOCK OF...\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** KESWICK AVE AND WOODLYN AVE **  ** 383-13 ** ",

        "TIME:15:29:36",
        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:2200 MT CARMEL AVE",
        "MAP:29-C6",
        "INFO:4 VEHS - REQ EMS\nON THE 2200 BLOCK OF...\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n15:29  4 VEHS - REQ EMS\n15:29  ON THE 2200 BLOCK OF...\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:VAI",
        "ID:E1232350",
        "CITY:ABINGTON TWP",
        "X:KESWICK AVE AND WOODLYN AVE",
        "UNIT:383-13");

    doTest("T21",
        "(Dispatch) Dispatch ** 16:08:21 ** BUILDING FIRE NON-COMMERCIAL ** 3 HIGH GATE LN ** - **  **  ** 46-28 **  ** ELECTRIC OVEN\n" +
        "CALLER STATING EXPLODING\n" +
        "FLAMES\n" +
        " ** 06/19/12 ** FBL ** E1232354 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232354\n" +
        "Incident Received: 06-19-2012  16:08:21              Call Source:      911\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "3 HIGH GATE LN \n" +
        "Cross Street: PENLLYN BLUE BELL PIKE \n\n" +
        "Map: 46-28  Plan:   ADC: 3256H6  MUN: WHPN\n\n" +
        "Units Due:   QX33  385-10\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "16:08  ELECTRIC OVEN\n" +
        "16:08  CALLER STATING EXPLODING\n" +
        "16:08  FLAMES\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** PENLLYN BLUE BELL PIKE **  ** QX33  385-10 ** ",

        "TIME:16:08:21",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:3 HIGH GATE LN",
        "MAP:46-28",
        "INFO:ELECTRIC OVEN\nCALLER STATING EXPLODING\nFLAMES\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n16:08  ELECTRIC OVEN\n16:08  CALLER STATING EXPLODING\n16:08  FLAMES\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:FBL",
        "ID:E1232354",
        "CITY:WHITPAIN TWP",
        "X:PENLLYN BLUE BELL PIKE",
        "UNIT:QX33  385-10");

    doTest("T22",
        "(Dispatch) Dispatch ** 16:21:03 ** DIZZINESS ** 2300 COMPUTER AVE  Apt# E25 ** ABINGTON WOMANS PRIMARY GROUP- **  **  ** 35-59 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "+ EXECUTIVE MEWS\n" +
        "PT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n" +
        "40 YOF\n" +
        "STILL LIGHTHEADED\n" +
        "C/A\n" +
        "BREATHING OK\n" +
        " ** 06/19/12 ** MDZ ** E1232356 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232356\n" +
        "Incident Received: 06-19-2012  16:21:03              Call Source:  10DIGIT\n\n" +
        "CODE: MDZ-DIZZINESS \n" +
        "ABINGTON WOMANS PRIMARY GROUP\n" +
        "2300 COMPUTER AVE  Apt# E25\n" +
        "Cross Street: WELSH RD AND MARYLAND RD\n\n" +
        "Map: 35-59  Plan:   ADC: 3258J5  MUN: UMOR\n\n" +
        "Units Due:   QX10  384-4\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "16:21  SPECIAL ADDRESS COMMENT:\n" +
        "16:21  VALID SUITES AT LOCATION - REVERIFY\n" +
        "16:21  SPECIAL ADDRESS COMMENT:\n" +
        "16:21  + EXECUTIVE MEWS\n" +
        "16:21  PT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n" +
        "16:21  40 YOF\n" +
        "16:21  STILL LIGHTHEADED\n" +
        "16:21  C/A\n" +
        "16:21  BREATHING OK\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** WELSH RD AND MARYLAND RD **  ** QX10  384-4 ** ",

        "TIME:16:21:03",
        "CALL:DIZZINESS",
        "ADDR:2300 COMPUTER AVE",
        "APT:E25",
        "PLACE:ABINGTON WOMANS PRIMARY GROUP",
        "MAP:35-59",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\n+ EXECUTIVE MEWS\nPT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n40 YOF\nSTILL LIGHTHEADED\nC/A\nBREATHING OK\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n16:21  SPECIAL ADDRESS COMMENT:\n16:21  VALID SUITES AT LOCATION - REVERIFY\n16:21  SPECIAL ADDRESS COMMENT:\n16:21  + EXECUTIVE MEWS\n16:21  PT HAD BIOPSY/SYNCOPAL EPISODE 40 MIN AGON\n16:21  40 YOF\n16:21  STILL LIGHTHEADED\n16:21  C/A\n16:21  BREATHING OK\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MDZ",
        "ID:E1232356",
        "CITY:UPPER MORELAND TWP",
        "X:WELSH RD AND MARYLAND RD",
        "UNIT:QX10  384-4");

    doTest("T23",
        "(Dispatch) Dispatch ** 17:57:23 ** ALLERGIC REACTION ** 2254 PLEASANT AVE ** - **  **  ** 29-C5 **  ** STUNG BY A BEE\n" +
        " ** 06/19/12 ** MAR ** E1232369 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232369\n" +
        "Incident Received: 06-19-2012  17:57:23              Call Source:  10DIGIT\n\n" +
        "CODE: MAR-ALLERGIC REACTION \n\n" +
        "2254 PLEASANT AVE \n" +
        "Cross Street: GARDEN RD AND EASTON RD\n\n" +
        "Map: 29-C5  Plan:   ADC: 3370H3  MUN: ABGN\n\n" +
        "Units Due:   383-13\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:57  STUNG BY A BEE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** GARDEN RD AND EASTON RD **  ** 383-13 ** ",

        "TIME:17:57:23",
        "CALL:ALLERGIC REACTION",
        "ADDR:2254 PLEASANT AVE",
        "MAP:29-C5",
        "INFO:STUNG BY A BEE\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n17:57  STUNG BY A BEE\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:MAR",
        "ID:E1232369",
        "CITY:ABINGTON TWP",
        "X:GARDEN RD AND EASTON RD",
        "UNIT:383-13");

    doTest("T24",
        "(Dispatch) Dispatch ** 19:03:09 ** RESPIRATORY EMERGENCY ** 2478 LAFAYETTE AVE ** - **  **  ** 29-B3 **  ** 53/F\n" +
        "TROUBLE BREATHING, HIVES ALL OVER BODY\n" +
        " ** 06/19/12 ** MRE ** E1232384 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232384\n" +
        "Incident Received: 06-19-2012  19:03:09              Call Source:  10DIGIT\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n\n" +
        "2478 LAFAYETTE AVE \n" +
        "Cross Street: BRADFIELD RD AND COLONIAL AVE\n\n" +
        "Map: 29-B3  Plan:   ADC: 3258J10  MUN: ABGN\n\n" +
        "Units Due:   381-2\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:03  53/F\n" +
        "19:03  TROUBLE BREATHING, HIVES ALL OVER BODY\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1169015    12-29-2011    SYNCOPAL EPISODE\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** BRADFIELD RD AND COLONIAL AVE **  ** 381-2 ** ",

        "TIME:19:03:09",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:2478 LAFAYETTE AVE",
        "MAP:29-B3",
        "INFO:53/F\nTROUBLE BREATHING, HIVES ALL OVER BODY\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n19:03  53/F\n19:03  TROUBLE BREATHING, HIVES ALL OVER BODY\nPrior Events:\n----- -------\nE1169015    12-29-2011    SYNCOPAL EPISODE",
        "DATE:06/19/12",
        "CODE:MRE",
        "ID:E1232384",
        "CITY:ABINGTON TWP",
        "X:BRADFIELD RD AND COLONIAL AVE",
        "UNIT:381-2");

    doTest("T25",
        "(Dispatch) Dispatch ** 20:44:19 ** RESPIRATORY EMERGENCY ** 291 KESWICK AVE ** KESWICK THEATER- **  **  ** 29-C5 **  ** F/48\n" +
        "DIF BREATHING\n" +
        "C/SEMI ALERT\n" +
        "PT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\n" +
        " ** 06/19/12 ** MRE ** E1232396 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232396\n" +
        "Incident Received: 06-19-2012  20:44:19              Call Source:      911\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n" +
        "KESWICK THEATER\n" +
        "291 KESWICK AVE \n" +
        "Cross Street: THE KESWICK ROTARY LOOP AND EASTON RD\n\n" +
        "Map: 29-C5  Plan:   ADC: 3370G3  MUN: ABGN\n\n" +
        "Units Due:   NC383\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "...............KEY BOX....................\n" +
        "KEY BOX MOUNTED HIGH ON SIDE \"B\" WALL IN THE ALLEY CLOSE TO THE LEFT SIDE FRONT DOOR.\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "20:44  F/48\n" +
        "20:44  DIF BREATHING\n" +
        "20:44  C/SEMI ALERT\n" +
        "20:44  PT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1158725    11-03-2011    DIABETIC EMERGENCY\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** THE KESWICK ROTARY LOOP AND EASTON RD **  ** NC383 ** ",

        "TIME:20:44:19",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:291 KESWICK AVE",
        "PLACE:KESWICK THEATER",
        "MAP:29-C5",
        "INFO:F/48\nDIF BREATHING\nC/SEMI ALERT\nPT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\nAdditional Info:\n---------- ----\n...............KEY BOX....................\nKEY BOX MOUNTED HIGH ON SIDE \"B\" WALL IN THE ALLEY CLOSE TO THE LEFT SIDE FRONT DOOR.\nEvent Comments:\n----- ---------\n20:44  F/48\n20:44  DIF BREATHING\n20:44  C/SEMI ALERT\n20:44  PT IS ON THE SECOND FLOOR - SECURITY WILL TAKE RESPONDERS TO PT\nPrior Events:\n----- -------\nE1158725    11-03-2011    DIABETIC EMERGENCY",
        "DATE:06/19/12",
        "CODE:MRE",
        "ID:E1232396",
        "CITY:ABINGTON TWP",
        "X:THE KESWICK ROTARY LOOP AND EASTON RD",
        "UNIT:NC383");

    doTest("T26",
        "(Dispatch) Dispatch ** 21:44:47 ** BUILDING FIRE COMMERCIAL ** 1400 UNION MEETING RD  Apt# 100 ** CERTAINTEED CORPORATION TECHNICAL CENTER- **  **  ** 46-57 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "BOILER ROOM IS SMOKING\n" +
        "SMELLS LIKE SMOKE- POSS ELECTRICAL\n" +
        "ADVISED TO EVACUATE\n" +
        " ** 06/19/12 ** FBL ** E1232405 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232405\n" +
        "Incident Received: 06-19-2012  21:44:47              Call Source:  10DIGIT\n\n" +
        "CODE: FBL-BUILDING FIRE COMMERCIAL\n" +
        "CERTAINTEED CORPORATION TECHNICAL CENTER\n" +
        "1400 UNION MEETING RD  Apt# 100\n" +
        "Cross Street: HARVEST DR AND JOLLY RD\n\n" +
        "Map: 46-57  Plan:   ADC: 3256E7  MUN: WHPN\n\n" +
        "Units Due:   385-3\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "WALL NON-COMBUSTIBLE\n" +
        "KNOX BOX LOCATED RIGHT SIDE OF MAIN DOOR\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "21:44  SPECIAL ADDRESS COMMENT:\n" +
        "21:44  VALID SUITES AT LOCATION - REVERIFY\n" +
        "21:44  BOILER ROOM IS SMOKING\n" +
        "21:44  SMELLS LIKE SMOKE- POSS ELECTRICAL\n" +
        "21:44  ADVISED TO EVACUATE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** HARVEST DR AND JOLLY RD **  ** 385-3 ** ",

        "TIME:21:44:47",
        "CALL:BUILDING FIRE COMMERCIAL",
        "ADDR:1400 UNION MEETING RD",
        "APT:100",
        "PLACE:CERTAINTEED CORPORATION TECHNICAL CENTER",
        "MAP:46-57",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\nBOILER ROOM IS SMOKING\nSMELLS LIKE SMOKE- POSS ELECTRICAL\nADVISED TO EVACUATE\nAdditional Info:\n---------- ----\nWALL NON-COMBUSTIBLE\nKNOX BOX LOCATED RIGHT SIDE OF MAIN DOOR\nEvent Comments:\n----- ---------\n21:44  SPECIAL ADDRESS COMMENT:\n21:44  VALID SUITES AT LOCATION - REVERIFY\n21:44  BOILER ROOM IS SMOKING\n21:44  SMELLS LIKE SMOKE- POSS ELECTRICAL\n21:44  ADVISED TO EVACUATE\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/19/12",
        "CODE:FBL",
        "ID:E1232405",
        "CITY:WHITPAIN TWP",
        "X:HARVEST DR AND JOLLY RD",
        "UNIT:385-3");

    doTest("T27",
        "(Dispatch) Dispatch ** 02:16:29 ** OVERDOSE ** 409 EASTON RD  Apt# C3 ** WILLOW HILL APARTMENTS- **  **  ** 35-42 **  ** DIF TO UNDERSTAND\n" +
        "ALCOHOL AND MEDICINE\n" +
        "PT IS GASPING FOR AIR\n" +
        "NOT C/A\n" +
        "NOW SAYING UNK IF C/A\n" +
        "F/42\n" +
        " ** 06/20/12 ** MOD ** E1232438 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232438\n" +
        "Incident Received: 06-20-2012  02:16:29              Call Source:  10DIGIT\n\n" +
        "CODE: MOD-OVERDOSE \n" +
        "WILLOW HILL APARTMENTS\n" +
        "409 EASTON RD  Apt# C3\n" +
        "Cross Street: ALLISON RD AND BARRETT RD\n\n" +
        "Map: 35-42  Plan:   ADC: 3259A7  MUN: UMOR\n\n" +
        "Units Due:   QX10  381-2\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "02:16  DIF TO UNDERSTAND\n" +
        "02:16  ALCOHOL AND MEDICINE\n" +
        "02:16  PT IS GASPING FOR AIR\n" +
        "02:16  NOT C/A\n" +
        "02:16  NOW SAYING UNK IF C/A\n" +
        "02:16  F/42\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1140756    08-03-2011    ASSAULT VICTIM\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** ALLISON RD AND BARRETT RD **  ** QX10  381-2 ** ",

        "TIME:02:16:29",
        "CALL:OVERDOSE",
        "ADDR:409 EASTON RD",
        "APT:C3",
        "PLACE:WILLOW HILL APARTMENTS",
        "MAP:35-42",
        "INFO:DIF TO UNDERSTAND\nALCOHOL AND MEDICINE\nPT IS GASPING FOR AIR\nNOT C/A\nNOW SAYING UNK IF C/A\nF/42\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n02:16  DIF TO UNDERSTAND\n02:16  ALCOHOL AND MEDICINE\n02:16  PT IS GASPING FOR AIR\n02:16  NOT C/A\n02:16  NOW SAYING UNK IF C/A\n02:16  F/42\nPrior Events:\n----- -------\nE1140756    08-03-2011    ASSAULT VICTIM",
        "DATE:06/20/12",
        "CODE:MOD",
        "ID:E1232438",
        "CITY:UPPER MORELAND TWP",
        "X:ALLISON RD AND BARRETT RD",
        "UNIT:QX10  381-2");

    doTest("T28",
        "(Dispatch) Dispatch ** 04:30:47 ** RESPIRATORY EMERGENCY ** 2746 FERNWOOD AVE ** - **  **  ** 29-B3 **  ** TROUBLE BREATHING- SOB\n" +
        "56/M\n" +
        "C/A\n" +
        "MED HX- NONE\n" +
        " ** 06/20/12 ** MRE ** E1232444 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232444\n" +
        "Incident Received: 06-20-2012  04:30:47              Call Source:  10DIGIT\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n\n" +
        "2746 FERNWOOD AVE \n" +
        "Cross Street: THOMSON RD AND NOLEN RD\n\n" +
        "Map: 29-B3  Plan:   ADC: 3258H10  MUN: ABGN\n\n" +
        "Units Due:   381-2\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "04:30  TROUBLE BREATHING- SOB\n" +
        "04:30  56/M\n" +
        "04:30  C/A\n" +
        "04:30  MED HX- NONE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** THOMSON RD AND NOLEN RD **  ** 381-2 ** ",

        "TIME:04:30:47",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:2746 FERNWOOD AVE",
        "MAP:29-B3",
        "INFO:TROUBLE BREATHING- SOB\n56/M\nC/A\nMED HX- NONE\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n04:30  TROUBLE BREATHING- SOB\n04:30  56/M\n04:30  C/A\n04:30  MED HX- NONE\nPrior Events:\n----- -------\n*** NOT FOUND ***",
        "DATE:06/20/12",
        "CODE:MRE",
        "ID:E1232444",
        "CITY:ABINGTON TWP",
        "X:THOMSON RD AND NOLEN RD",
        "UNIT:381-2");

    doTest("T29",
        "(Dispatch) Dispatch ** 05:53:55 ** ALTERED MENTAL STATUS ** 174 BETHLEHEM PIKE S Apt# A2 ** MATTISON HOUSE APARTMENTS- **  **  ** 43-07 **  ** 84/F - CONS - CONFUSED\n" +
        "HX: COPD; CHF\n" +
        "HAS FALLEN AS WELL\n" +
        " ** 06/20/12 ** MMS ** E1232447 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232447\n" +
        "Incident Received: 06-20-2012  05:53:55              Call Source:  10DIGIT\n\n" +
        "CODE: MMS-ALTERED MENTAL STATUS \n" +
        "MATTISON HOUSE APARTMENTS\n" +
        "174 BETHLEHEM PIKE S Apt# A2\n" +
        "Cross Street: MATTISON AVE AND CHURCH ST\n\n" +
        "Map: 43-07  Plan:   ADC: 3257F6  MUN: AMBL\n\n" +
        "Units Due:   NC351  385-3\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "05:53  84/F - CONS - CONFUSED\n" +
        "05:53  HX: COPD; CHF\n" +
        "05:53  HAS FALLEN AS WELL\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1225519    05-15-2012    HEMORRHAGING\n" +
        "E1223962    05-07-2012    RESPIRATORY EMERGENCY\n" +
        "E1221345    04-23-2012    CARDIAC EMERGENCY\n" +
        "E1216023    03-26-2012    CARDIAC EMERGENCY\n" +
        "E1212938    03-10-2012    RESPIRATORY EMERGENCY\n" +
        "\n\n" +
        " ** AMBL **  **  **  ** MATTISON AVE AND CHURCH ST **  ** NC351  385-3 ** ",

        "TIME:05:53:55",
        "CALL:ALTERED MENTAL STATUS",
        "ADDR:174 BETHLEHEM PIKE S",
        "APT:A2",
        "PLACE:MATTISON HOUSE APARTMENTS",
        "MAP:43-07",
        "INFO:84/F - CONS - CONFUSED\nHX: COPD; CHF\nHAS FALLEN AS WELL\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n05:53  84/F - CONS - CONFUSED\n05:53  HX: COPD; CHF\n05:53  HAS FALLEN AS WELL\nPrior Events:\n----- -------\nE1225519    05-15-2012    HEMORRHAGING\nE1223962    05-07-2012    RESPIRATORY EMERGENCY\nE1221345    04-23-2012    CARDIAC EMERGENCY\nE1216023    03-26-2012    CARDIAC EMERGENCY\nE1212938    03-10-2012    RESPIRATORY EMERGENCY",
        "DATE:06/20/12",
        "CODE:MMS",
        "ID:E1232447",
        "CITY:AMBLER",
        "X:MATTISON AVE AND CHURCH ST",
        "UNIT:NC351  385-3");

    doTest("T30",
        "(Dispatch) Dispatch ** 07:54:09 ** SYNCOPAL EPISODE ** 1235 OLD YORK RD  Apt# G23 ** LEVY MEDICAL PLAZA - AMH- **  **  ** 29-D3 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "+ LEVY MEDICAL PLAZA - AMH\n" +
        "60'S/F ABOUT TO PASS OUT\n" +
        "C/A\n" +
        "BREATHING OK\n" +
        "REQ ABINGTON HOSPITAL\n" +
        " ** 06/20/12 ** MSY ** E1232466 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1232466\n" +
        "Incident Received: 06-20-2012  07:54:09              Call Source:      911\n\n" +
        "CODE: MSY-SYNCOPAL EPISODE \n" +
        "LEVY MEDICAL PLAZA - AMH\n" +
        "1235 OLD YORK RD  Apt# G23\n" +
        "Cross Street: HORACE AVE AND WOODLAND RD\n\n" +
        "Map: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\n" +
        "Units Due:   381-2\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "07:54  SPECIAL ADDRESS COMMENT:\n" +
        "07:54  VALID SUITES AT LOCATION - REVERIFY\n" +
        "07:54  SPECIAL ADDRESS COMMENT:\n" +
        "07:54  + LEVY MEDICAL PLAZA - AMH\n" +
        "07:54  60'S/F ABOUT TO PASS OUT\n" +
        "07:54  C/A\n" +
        "07:54  BREATHING OK\n" +
        "07:54  REQ ABINGTON HOSPITAL\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1231442    06-14-2012    ABDOMINAL PAINS\n" +
        "E1231229    06-13-2012    ABDOMINAL PAINS\n" +
        "E1231190    06-13-2012    RESPIRATORY EMERGENCY\n" +
        "E1229671    06-05-2012    ABDOMINAL PAINS\n" +
        "E1216389    03-28-2012    ABDOMINAL PAINS\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** HORACE AVE AND WOODLAND RD **  ** 381-2 ** ",

        "TIME:07:54:09",
        "CALL:SYNCOPAL EPISODE",
        "ADDR:1235 OLD YORK RD",
        "APT:G23",
        "PLACE:LEVY MEDICAL PLAZA - AMH",
        "MAP:29-D3",
        "INFO:VALID SUITES AT LOCATION - REVERIFY\nSPECIAL ADDRESS COMMENT:\n+ LEVY MEDICAL PLAZA - AMH\n60'S/F ABOUT TO PASS OUT\nC/A\nBREATHING OK\nREQ ABINGTON HOSPITAL\nAdditional Info:\n---------- ----\n*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\nEvent Comments:\n----- ---------\n07:54  SPECIAL ADDRESS COMMENT:\n07:54  VALID SUITES AT LOCATION - REVERIFY\n07:54  SPECIAL ADDRESS COMMENT:\n07:54  + LEVY MEDICAL PLAZA - AMH\n07:54  60'S/F ABOUT TO PASS OUT\n07:54  C/A\n07:54  BREATHING OK\n07:54  REQ ABINGTON HOSPITAL\nPrior Events:\n----- -------\nE1231442    06-14-2012    ABDOMINAL PAINS\nE1231229    06-13-2012    ABDOMINAL PAINS\nE1231190    06-13-2012    RESPIRATORY EMERGENCY\nE1229671    06-05-2012    ABDOMINAL PAINS\nE1216389    03-28-2012    ABDOMINAL PAINS",
        "DATE:06/20/12",
        "CODE:MSY",
        "ID:E1232466",
        "CITY:ABINGTON TWP",
        "X:HORACE AVE AND WOODLAND RD",
        "UNIT:381-2");

  }
  
  @Test
  public void testWorcesterFire() {

    doTest("T1",
        "(GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING) Dispatch ** 11:19 ** GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING ** 301 PRIMROSE DR ** RESERVE AT GWYNEDD FITNESS CEN **  **  ** 51-81 **  ** 05/03/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309199\n" +
        "Incident Received: 05-03-2013  11:19:07              Call Source:      911\n\n" +
        "CODE: FGL-GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING\n" +
        "RESERVE AT GWYNEDD FITNESS CENTER\n" +
        "301 PRIMROSE DR \n" +
        "Cross Street: MORRIS RD AND MAHOGANY WAY\n\n" +
        "Map: 51-81  Plan: 51-81 ADC: 3144C9  MUN: UGWY\n\n" +
        "Units Due:   E83  TW33  E62  TW80  E80\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:19  BUILDING 1000\n" +
        "11:19  GO TO BUILDING 1000 ON LILAC CT\n" +
        "11:19  2ND FLOOR AND FIRE TOWER, ODOR OF GAS\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1225774    10-29-2012    FIRE ALARM\n" +
        "F1213987    06-23-2012    GAS-ODOR/LEAK\n" +
        "\n\n" +
        " ** UGWY ** MORRIS RD AND MAHOGANY WA ** E83  TW33  E62  TW80  E80 ** ",

        "TIME:11:19",
        "CALL:GAS-ODOR/LEAK INSIDE COMMERCIAL BUILDING",
        "ADDR:301 PRIMROSE DR",
        "PLACE:RESERVE AT GWYNEDD FITNESS CEN",
        "MAP:51-81",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n11:19  BUILDING 1000\n11:19  GO TO BUILDING 1000 ON LILAC CT\n11:19  2ND FLOOR AND FIRE TOWER, ODOR OF GAS\nPrior Events:\n----- -------\nF1225774    10-29-2012    FIRE ALARM\nF1213987    06-23-2012    GAS-ODOR/LEAK",
        "DATE:05/03/13",
        "CITY:UPPER GWYNEDD TWP",
        "X:MORRIS RD AND MAHOGANY WA",
        "UNIT:E83  TW33  E62  TW80  E80");

    doTest("T2",
        "(FIRE ALARM) Dispatch ** 17:38 ** FIRE ALARM ** 1520 GREEN HILL RD ** - **  **  ** 64-16 **  ** 05/02/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309146\n" +
        "Incident Received: 05-02-2013  17:38:25              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "1520 GREEN HILL RD \n" +
        "Cross Street: STUMP HALL RD AND ANDERS RD\n\n" +
        "Map: 64-16  Plan:   ADC: 3142J9  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:38  SMOKE\n" +
        "17:38  W/N\n" +
        "17:38  RES; TOM DICKENSON PH: 610.584.5773\n" +
        "17:38  DOES NOT LIST LOCATION\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** STUMP HALL RD AND ANDERS ** T83  E83 ** ",

        "TIME:17:38",
        "CALL:FIRE ALARM",
        "ADDR:1520 GREEN HILL RD",
        "MAP:64-16",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n17:38  SMOKE\n17:38  W/N\n17:38  RES; TOM DICKENSON PH: 610.584.5773\n17:38  DOES NOT LIST LOCATION\nPrior Events:\n----- -------",
        "DATE:05/02/13",
        "CITY:WORCESTER TWP",
        "X:STUMP HALL RD AND ANDERS",
        "UNIT:T83  E83");

    doTest("T3",
        "(BUILDING FIRE NON-COMMERCIAL) Dispatch ** 09:24 ** BUILDING FIRE NON-COMMERCIAL ** 2595 HILLCREST DR ** - **  **  ** 64-05 **  ** 05/02/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1309092\n" +
        "Incident Received: 05-02-2013  09:24:14              Call Source:      911\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "2595 HILLCREST DR \n" +
        "Cross Street: COUNTRY VIEW LN AND BETHEL RD\n\n" +
        "Map: 64-05  Plan:   ADC: 3144A9  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:24  USED GAS GRILL LAST EVEING\n" +
        "09:24  NOW SMELLING GAS/GRILL HOT\n" +
        "09:24  GAS LINE ATTACHED TO HOME\n" +
        "09:24  GRILL LOCATED ON REAR DECK\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** COUNTRY VIEW LN AND BETHE ** T83  E83 ** ",

        "TIME:09:24",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:2595 HILLCREST DR",
        "MAP:64-05",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n09:24  USED GAS GRILL LAST EVEING\n09:24  NOW SMELLING GAS/GRILL HOT\n09:24  GAS LINE ATTACHED TO HOME\n09:24  GRILL LOCATED ON REAR DECK\nPrior Events:\n----- -------",
        "DATE:05/02/13",
        "CITY:WORCESTER TWP",
        "X:COUNTRY VIEW LN AND BETHE",
        "UNIT:T83  E83");

    doTest("T4",
        "(VEHICLE ACCIDENT STAND-BY) Dispatch ** 12:45 ** VEHICLE ACCIDENT STAND-BY ** 1221 QUARRY HALL RD ** - **  **  ** 64-22 **  ** 04/30/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308951\n" +
        "Incident Received: 04-30-2013  12:45:29              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT STAND-BY\n\n" +
        "1221 QUARRY HALL RD \n" +
        "Cross Street: DELL RD AND WATER STREET RD\n\n" +
        "Map: 64-22B Plan:   ADC: 3254K3  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "12:26  -075.424425 +040.211935\n" +
        "12:26  TT HIT WIRES AND TOOK THE WIRES DOWN , NOT SPARKING\n" +
        "12:26  OFF TO THE SIDE\n" +
        "12:41  CALLER BACK ON THE LINE\n" +
        "12:42  LOOKING FOR AN ETA ON TROOPER\n" +
        "12:44  PSP - DISP FD - WIRES ARE LIVE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** DELL RD AND WATER STREET ** T83  E83 ** ",

        "TIME:12:45",
        "CALL:VEHICLE ACCIDENT STAND-BY",
        "ADDR:1221 QUARRY HALL RD",
        "MAP:64-22",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n12:26  -075.424425 +040.211935\n12:26  TT HIT WIRES AND TOOK THE WIRES DOWN , NOT SPARKING\n12:26  OFF TO THE SIDE\n12:41  CALLER BACK ON THE LINE\n12:42  LOOKING FOR AN ETA ON TROOPER\n12:44  PSP - DISP FD - WIRES ARE LIVE\nPrior Events:\n----- -------",
        "DATE:04/30/13",
        "CITY:WORCESTER TWP",
        "X:DELL RD AND WATER STREET",
        "UNIT:T83  E83");

    doTest("T5",
        "(FIRE ALARM) Dispatch ** 12:56 ** FIRE ALARM ** 1133 HOLLOW RD ** - **  **  ** 64-22 **  ** 04/29/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308877\n" +
        "Incident Received: 04-29-2013  12:56:13              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "1133 HOLLOW RD \n" +
        "Cross Street: MILL RD AND SLOUGH DR\n\n" +
        "Map: 64-22A Plan:   ADC: 3254J2  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "12:56  GENERAL FIRE\n" +
        "12:56  W/N\n" +
        "12:56  RES: ROBERT JOHNSON, 702 596 2777\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** MILL RD AND SLOUGH DR ** T83  E83 ** ",

        "TIME:12:56",
        "CALL:FIRE ALARM",
        "ADDR:1133 HOLLOW RD",
        "MAP:64-22",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n12:56  GENERAL FIRE\n12:56  W/N\n12:56  RES: ROBERT JOHNSON, 702 596 2777\nPrior Events:\n----- -------",
        "DATE:04/29/13",
        "CITY:WORCESTER TWP",
        "X:MILL RD AND SLOUGH DR",
        "UNIT:T83  E83");

    doTest("T6",
        "(FIRE ALARM) Dispatch ** 10:28 ** FIRE ALARM ** 3205 SKIPPACK PIKE  Apt# 144 ** MEADOWOOD RETIREMENT COMMUNITY **  **  ** 64-07 **  ** 04/29/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308859\n" +
        "Incident Received: 04-29-2013  10:28:47              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n" +
        "MEADOWOOD RETIREMENT COMMUNITY\n" +
        "3205 SKIPPACK PIKE  Apt# 144\n" +
        "Cross Street: MEADOWOOD DR AND HOLLOW RD\n\n" +
        "Map: 64-07A Plan:   ADC: 3143E7  MUN: WORC\n\n" +
        "Units Due:   E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:28  SPECIAL ADDRESS COMMENT:\n" +
        "10:28  + MEADOWOOD RETIREMENT COMMUNITY\n" +
        "10:28  OBTAIN ROOM NUMBER  and  WING\n" +
        "10:28  HEALTH CARE FIRST FLOOR\n" +
        "10:28  SPECIAL ADDRESS COMMENT:\n" +
        "10:28  SMOKE DETECTOR\n" +
        "10:28  + MEADOWOOD RETIREMENT COMMUNITY\n" +
        "10:28  OBTAIN ROOM NUMBER  and  WING\n" +
        "10:29  610-584-1000\n" +
        "10:29  W/N\n\n" +
        "Prior Events ** WORC ** MEADOWOOD DR AND HOLLOW R ** E83 ** ",

        "TIME:10:28",
        "CALL:FIRE ALARM",
        "ADDR:3205 SKIPPACK PIKE",
        "APT:144",
        "PLACE:MEADOWOOD RETIREMENT COMMUNITY",
        "MAP:64-07",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n10:28  SPECIAL ADDRESS COMMENT:\n10:28  + MEADOWOOD RETIREMENT COMMUNITY\n10:28  OBTAIN ROOM NUMBER  and  WING\n10:28  HEALTH CARE FIRST FLOOR\n10:28  SPECIAL ADDRESS COMMENT:\n10:28  SMOKE DETECTOR\n10:28  + MEADOWOOD RETIREMENT COMMUNITY\n10:28  OBTAIN ROOM NUMBER  and  WING\n10:29  610-584-1000\n10:29  W/N\nPrior Events",
        "DATE:04/29/13",
        "CITY:WORCESTER TWP",
        "X:MEADOWOOD DR AND HOLLOW R",
        "UNIT:E83");

    doTest("T7",
        "(UNKNOWN TYPE FIRE) Dispatch ** 18:44 ** UNKNOWN TYPE FIRE ** 14 ADAIR DR E ** - **  **  ** 64-25 **  ** 04/27/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308754\n" +
        "Incident Received: 04-27-2013  18:44:40              Call Source:  10DIGIT\n\n" +
        "CODE: FUN-UNKNOWN TYPE FIRE \n\n" +
        "14 ADAIR DR E\n" +
        "Cross Street: GERMANTOWN PIKE AND METHACTON AVE\n\n" +
        "Map: 64-25  Plan:   ADC: 3254H3  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:44  SEE FLAMES IN THE MIDDLE OF THE YARD\n" +
        "18:44  FIRE IN THE BACKYARD\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** GERMANTOWN PIKE AND METHA ** T83  E83 ** ",

        "TIME:18:44",
        "CALL:UNKNOWN TYPE FIRE",
        "ADDR:14 ADAIR DR E",
        "MAP:64-25",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n18:44  SEE FLAMES IN THE MIDDLE OF THE YARD\n18:44  FIRE IN THE BACKYARD\nPrior Events:\n----- -------",
        "DATE:04/27/13",
        "CITY:WORCESTER TWP",
        "X:GERMANTOWN PIKE AND METHA",
        "UNIT:T83  E83");

    doTest("T8",
        "(TRASH/DUMPSTER FIRE) Dispatch ** 17:35 ** TRASH/DUMPSTER FIRE ** VALLEY FORGE RD AND MORRIS RD ** - **  **  ** 64-02 **  ** 04/27/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308750\n" +
        "Incident Received: 04-27-2013  17:35:53              Call Source:  10DIGIT\n\n" +
        "CODE: FTR-TRASH/DUMPSTER FIRE \n\n" +
        "   \n" +
        "Cross Street: VALLEY FORGE RD AND MORRIS RD\n\n" +
        "Map: 64-02  Plan:   ADC: 3143H6  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:35  MALE SUBJ POSS W CONTROLLED BURN BUT ITS AT THE EDGE OF THE STREET\n" +
        "17:35  ON MORRIS BY 363 IF GOING TWDS BLUE BELL\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1226539    10-31-2012    FIRE POLICE NEEDED\n" +
        "F1224143    10-18-2012    VEHICLE FIRE\n" +
        "\n\n" +
        " ** WORC ** VALLEY FORGE RD AND MORRI ** T83  E83 ** ",

        "TIME:17:35",
        "CALL:TRASH/DUMPSTER FIRE",
        "ADDR:VALLEY FORGE RD AND MORRIS RD",
        "MADDR:VALLEY FORGE RD & MORRIS RD",
        "MAP:64-02",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n17:35  MALE SUBJ POSS W CONTROLLED BURN BUT ITS AT THE EDGE OF THE STREET\n17:35  ON MORRIS BY 363 IF GOING TWDS BLUE BELL\nPrior Events:\n----- -------\nF1226539    10-31-2012    FIRE POLICE NEEDED\nF1224143    10-18-2012    VEHICLE FIRE",
        "DATE:04/27/13",
        "CITY:WORCESTER TWP",
        "X:VALLEY FORGE RD AND MORRI",
        "UNIT:T83  E83");

    doTest("T9",
        "(FIRE ALARM) Dispatch ** 16:59 ** FIRE ALARM ** 3337 SKIPPACK PIKE ** - **  **  ** 64-06 **  ** 04/23/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308412\n" +
        "Incident Received: 04-23-2013  16:59:10              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "3337 SKIPPACK PIKE \n" +
        "Cross Street: GREEN HILL RD AND CEDARS HILL RD\n\n" +
        "Map: 64-06B Plan:   ADC: 3143B7  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "16:59  RESD-LAWRENCE TAYLOR 610/584-4905\n" +
        "16:59  WILL ATTEMPT TO NOTIFY\n" +
        "16:59  GENERALL FIRE ALARM\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1214278    06-27-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** WORC ** GREEN HILL RD AND CEDARS ** T83  E83 ** ",

        "TIME:16:59",
        "CALL:FIRE ALARM",
        "ADDR:3337 SKIPPACK PIKE",
        "MAP:64-06",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n16:59  RESD-LAWRENCE TAYLOR 610/584-4905\n16:59  WILL ATTEMPT TO NOTIFY\n16:59  GENERALL FIRE ALARM\nPrior Events:\n----- -------\nF1214278    06-27-2012    FIRE ALARM",
        "DATE:04/23/13",
        "CITY:WORCESTER TWP",
        "X:GREEN HILL RD AND CEDARS",
        "UNIT:T83  E83");

    doTest("T10",
        "(BUILDING FIRE NON-COMMERCIAL) Dispatch ** 11:47 ** BUILDING FIRE NON-COMMERCIAL ** 3122 WATER STREET RD ** - **  **  ** 64-22 **  ** 04/21/13 ** ------ Dispatch Report v1.3SP ------                   INCIDENT: F1308226\n" +
        "Incident Received: 04-21-2013  11:47:32              Call Source:  10DIGIT\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "3122 WATER STREET RD \n" +
        "Cross Street: QUARRY HALL RD AND HOLLOW RD\n\n" +
        "Map: 64-22B Plan:   ADC: 3255A2  MUN: WORC\n\n" +
        "Units Due:   T83  E83\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:47  HOUSE ON FIRE\n" +
        "11:47  OUT OF THE HOUSE\n" +
        "11:47  CAT INSIDE THE HOUSE\n" +
        "11:48  BUSH ON FIRE UP AGAINST THE HOUSE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** WORC ** QUARRY HALL RD AND HOLLOW ** T83  E83 ** ",

        "TIME:11:47",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:3122 WATER STREET RD",
        "MAP:64-22",
        "INFO:Additional Info:\n---------- ----\nEvent Comments:\n----- ---------\n11:47  HOUSE ON FIRE\n11:47  OUT OF THE HOUSE\n11:47  CAT INSIDE THE HOUSE\n11:48  BUSH ON FIRE UP AGAINST THE HOUSE\nPrior Events:\n----- -------",
        "DATE:04/21/13",
        "CITY:WORCESTER TWP",
        "X:QUARRY HALL RD AND HOLLOW",
        "UNIT:T83  E83");
  
  }
  
  @Test
  public void testSecondAlarmersRescueSquad() {

    doTest("T1",
        "(Dispatch) Dispatch ** 15:05:34 ** VEHICLE ACCIDENT INJURIES ** EASTON RD AND FITZWATERTOWN RD ** - **  **  ** 35-44 **  ** 2 VEH\n" +
        "1 PARTY WITH NECK PAIN\n" +
        " ** 05/08/13 ** VAI ** E1325328 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325328\n" +
        "Incident Received: 05-08-2013  15:05:34              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT INJURIES\n\n" +
        "   \n" +
        "Cross Street: EASTON RD AND FITZWATERTOWN RD\n\n" +
        "Map: 35-44  Plan:   ADC: 3259A6  MUN: UMOR\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "15:05  2 VEH\n" +
        "15:05  1 PARTY WITH NECK PAIN\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1312954    03-05-2013    VEHICLE ACCIDENT\n" +
        "E1306959    02-02-2013    VEHICLE ACCIDENT\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** EASTON RD AND FITZWATERTOWN RD **  ** 381-5 ** ",

        "TIME:15:05:34",
        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:EASTON RD AND FITZWATERTOWN RD",
        "MADDR:EASTON RD & FITZWATERTOWN RD",
        "MAP:35-44",
        "INFO:2 VEH\n1 PARTY WITH NECK PAIN\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n15:05  2 VEH\n15:05  1 PARTY WITH NECK PAIN\nPrior Events:\n----- -------\nE1312954    03-05-2013    VEHICLE ACCIDENT\nE1306959    02-02-2013    VEHICLE ACCIDENT",
        "DATE:05/08/13",
        "CODE:VAI",
        "ID:E1325328",
        "CITY:UPPER MORELAND TWP",
        "X:EASTON RD AND FITZWATERTOWN RD",
        "UNIT:381-5");

    doTest("T2",
        "(Dispatch) Dispatch ** 14:12:41 ** NAUSEA/VOMITING ** 1565 PROSPECT AVE ** - **  **  ** 29-C2 **  ** -075.122795 +040.131307\n" +
        "VOMITING, SHAKING\n" +
        "36/F\n" +
        " ** 05/08/13 ** MNV ** E1325321 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325321\n" +
        "Incident Received: 05-08-2013  14:12:41              Call Source:  10DIGIT\n\n" +
        "CODE: MNV-NAUSEA/VOMITING \n\n" +
        "1565 PROSPECT AVE \n" +
        "Cross Street: WASHINGTON AVE AND HAMILTON AVE\n\n" +
        "Map: 29-C2  Plan:   ADC: 3259A10  MUN: ABGN\n\n" +
        "Units Due:   NC381\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "14:12  -075.122795 +040.131307\n" +
        "14:12  VOMITING, SHAKING\n" +
        "14:12  36/F\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** WASHINGTON AVE AND HAMILTON AVE **  ** NC381 ** ",

        "TIME:14:12:41",
        "CALL:NAUSEA/VOMITING",
        "ADDR:1565 PROSPECT AVE",
        "MAP:29-C2",
        "INFO:-075.122795 +040.131307\nVOMITING, SHAKING\n36/F\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n14:12  -075.122795 +040.131307\n14:12  VOMITING, SHAKING\n14:12  36/F\nPrior Events:\n----- -------",
        "DATE:05/08/13",
        "CODE:MNV",
        "ID:E1325321",
        "CITY:ABINGTON TWP",
        "X:WASHINGTON AVE AND HAMILTON AVE",
        "UNIT:NC381");

    doTest("T3",
        "(Dispatch) Dispatch ** 13:52:59 ** ABDOMINAL PAINS ** 345 YORK RD N Apt# 1 ** HATBORO MEDICAL ASSOCIATES- **  **  ** 37-19 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "ABDOMINAL PAIN\n" +
        "59/F\n" +
        "VALID SUITES AT LOCATION - REVERIFY\n" +
        " ** 05/08/13 ** MAP ** E1325317 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325317\n" +
        "Incident Received: 05-08-2013  13:52:59              Call Source:      911\n\n" +
        "CODE: MAP-ABDOMINAL PAINS \n" +
        "HATBORO MEDICAL ASSOCIATES\n" +
        "345 YORK RD N Apt# 1\n" +
        "Cross Street: VILLAGE PL AND HOME RD\n\n" +
        "Map: 37-19  Plan:   ADC: 3259D1  MUN: HATB\n\n" +
        "Units Due:   NC384\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "13:52  SPECIAL ADDRESS COMMENT:\n" +
        "13:52  ABDOMINAL PAIN\n" +
        "13:52  59/F\n" +
        "13:52  VALID SUITES AT LOCATION - REVERIFY\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1315621    03-19-2013    RESPIRATORY EMERGENCY\n" +
        "E1310395    02-20-2013    CARDIAC EMERGENCY\n" +
        "E1309974    02-18-2013    DIZZINESS\n" +
        "E1309434    02-15-2013    RESPIRATORY EMERGENCY\n" +
        "E1269892    12-27-2012    CARDIAC EMERGENCY\n" +
        "\n\n" +
        " ** HATB **  **  **  ** VILLAGE PL AND HOME RD **  ** NC384 ** ",

        "TIME:13:52:59",
        "CALL:ABDOMINAL PAINS",
        "ADDR:345 YORK RD N",
        "APT:1",
        "PLACE:HATBORO MEDICAL ASSOCIATES",
        "MAP:37-19",
        "INFO:ABDOMINAL PAIN\n59/F\nVALID SUITES AT LOCATION - REVERIFY\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n13:52  SPECIAL ADDRESS COMMENT:\n13:52  ABDOMINAL PAIN\n13:52  59/F\n13:52  VALID SUITES AT LOCATION - REVERIFY\nPrior Events:\n----- -------\nE1315621    03-19-2013    RESPIRATORY EMERGENCY\nE1310395    02-20-2013    CARDIAC EMERGENCY\nE1309974    02-18-2013    DIZZINESS\nE1309434    02-15-2013    RESPIRATORY EMERGENCY\nE1269892    12-27-2012    CARDIAC EMERGENCY",
        "DATE:05/08/13",
        "CODE:MAP",
        "ID:E1325317",
        "CITY:HATBORO",
        "X:VILLAGE PL AND HOME RD",
        "UNIT:NC384");

    doTest("T4",
        "(Dispatch) Dispatch ** 13:49:06 ** VEHICLE ACCIDENT INJURIES ** 3432 PENNSYLVANIA TPKE EB ** - **  **  ** 35-38 **  ** -075.120005 +040.161509\n" +
        "BLK LINCOLN TOWNCAR\n" +
        "DRIVER HAS BACK PAIN\n" +
        " ** 05/08/13 ** VAI ** E1325316 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325316\n" +
        "Incident Received: 05-08-2013  13:49:06              Call Source:      911\n\n" +
        "CODE: VA-VEHICLE ACCIDENT INJURIES\n\n" +
        "3432 PENNSYLVANIA TPKE EB\n" +
        "Cross Street: S YORK RD UNDERPASS AND RAMP RT611 TO I276 EB\n\n" +
        "Map: 35-38  Plan:   ADC: 3259B5  MUN: UMOR\n\n" +
        "Units Due:   384-8\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "13:49  -075.120005 +040.161509\n" +
        "13:49  BLK LINCOLN TOWNCAR\n" +
        "13:49  DRIVER HAS BACK PAIN\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1269860    12-27-2012    VEHICLE FIRE\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** S YORK RD UNDERPASS AND RAMP RT611 TO I276 EB **  ** 384-8 ** ",

        "TIME:13:49:06",
        "CALL:VEHICLE ACCIDENT INJURIES",
        "ADDR:3432 PENNSYLVANIA TPKE EB",
        "MADDR:3432 PENNSYLVANIA TPKE",
        "MAP:35-38",
        "INFO:-075.120005 +040.161509\nBLK LINCOLN TOWNCAR\nDRIVER HAS BACK PAIN\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n13:49  -075.120005 +040.161509\n13:49  BLK LINCOLN TOWNCAR\n13:49  DRIVER HAS BACK PAIN\nPrior Events:\n----- -------\nE1269860    12-27-2012    VEHICLE FIRE",
        "DATE:05/08/13",
        "CODE:VAI",
        "ID:E1325316",
        "CITY:UPPER MORELAND TWP",
        "X:S YORK RD UNDERPASS AND RAMP RT611 TO I276 EB",
        "UNIT:384-8");

    doTest("T5",
        "(Dispatch) Dispatch ** 13:43:27 ** CVA/STROKE ** 1439 ST CHARLES PL ** - **  **  ** 29-B2 **  ** 46/M POSSIBLY HAVING A STROKE\n" +
        "SLURRED SPEACH, PRIOR STROKE\n" +
        "C/A\n" +
        " ** 05/08/13 ** MCV ** E1325314 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325314\n" +
        "Incident Received: 05-08-2013  13:43:27              Call Source:  10DIGIT\n\n" +
        "CODE: MCV-CVA/STROKE \n\n" +
        "1439 ST CHARLES PL \n" +
        "Cross Street: PERSHING AVE AND PATANE AVE\n\n" +
        "Map: 29-B2  Plan:   ADC: 3258J9  MUN: ABGN\n\n" +
        "Units Due:   381-5\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "13:43  46/M POSSIBLY HAVING A STROKE\n" +
        "13:43  SLURRED SPEACH, PRIOR STROKE\n" +
        "13:43  C/A\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1323448    04-29-2013    MEDICAL ALERT ALARM\n" +
        "E1318405    04-03-2013    ABDOMINAL PAINS\n" +
        "E1308892    02-12-2013    MEDICAL ALERT ALARM\n" +
        "E1258039    10-30-2012    RESPIRATORY EMERGENCY\n" +
        "E1246922    09-03-2012    DIABETIC EMERGENCY\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** PERSHING AVE AND PATANE AVE **  ** 381-5 ** ",

        "TIME:13:43:27",
        "CALL:CVA/STROKE",
        "ADDR:1439 ST CHARLES PL",
        "MAP:29-B2",
        "INFO:46/M POSSIBLY HAVING A STROKE\nSLURRED SPEACH, PRIOR STROKE\nC/A\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n13:43  46/M POSSIBLY HAVING A STROKE\n13:43  SLURRED SPEACH, PRIOR STROKE\n13:43  C/A\nPrior Events:\n----- -------\nE1323448    04-29-2013    MEDICAL ALERT ALARM\nE1318405    04-03-2013    ABDOMINAL PAINS\nE1308892    02-12-2013    MEDICAL ALERT ALARM\nE1258039    10-30-2012    RESPIRATORY EMERGENCY\nE1246922    09-03-2012    DIABETIC EMERGENCY",
        "DATE:05/08/13",
        "CODE:MCV",
        "ID:E1325314",
        "CITY:ABINGTON TWP",
        "X:PERSHING AVE AND PATANE AVE",
        "UNIT:381-5");

    doTest("T6",
        "(Dispatch) Dispatch ** 11:24:31 ** MEDICAL ALERT ALARM ** 310 RAILROAD AVE ** - **  **  ** 46-21 **  ** ACTIVATION FROM PENDANT\n" +
        "STACY BREWER RESD\n" +
        "267-460-8365\n" +
        "NO CALL LIST\n" +
        "HAVE PD CHECK THE RESD, NO EMS DISPATCH\n" +
        "46-133 WILL VERIFY\n" +
        "SUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\n" +
        " ** 05/08/13 ** MMA ** E1325295 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325295\n" +
        "Incident Received: 05-08-2013  11:24:31              Call Source:  10DIGIT\n\n" +
        "CODE: MMA-MEDICAL ALERT ALARM \n\n" +
        "310 RAILROAD AVE \n" +
        "Cross Street: W MT PLEASANT AVE AND OAK ST\n\n" +
        "Map: 46-21  Plan:   ADC: 3257D5  MUN: WHPN\n\n" +
        "Units Due:   385ST\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:24  ACTIVATION FROM PENDANT\n" +
        "11:24  STACY BREWER RESD\n" +
        "11:24  267-460-8365\n" +
        "11:24  NO CALL LIST\n" +
        "11:26  HAVE PD CHECK THE RESD, NO EMS DISPATCH\n" +
        "11:26  46-133 WILL VERIFY\n" +
        "11:26  SUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1325284    05-08-2013    CARDIAC EMERGENCY\n" +
        "E1307493    02-05-2013    MEDICAL ALERT ALARM\n" +
        "E1246911    09-03-2012    SEIZURES\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** W MT PLEASANT AVE AND OAK ST **  ** 385ST ** ",

        "TIME:11:24:31",
        "CALL:MEDICAL ALERT ALARM",
        "ADDR:310 RAILROAD AVE",
        "MAP:46-21",
        "INFO:ACTIVATION FROM PENDANT\nSTACY BREWER RESD\n267-460-8365\nNO CALL LIST\nHAVE PD CHECK THE RESD, NO EMS DISPATCH\n46-133 WILL VERIFY\nSUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n11:24  ACTIVATION FROM PENDANT\n11:24  STACY BREWER RESD\n11:24  267-460-8365\n11:24  NO CALL LIST\n11:26  HAVE PD CHECK THE RESD, NO EMS DISPATCH\n11:26  46-133 WILL VERIFY\n11:26  SUBJ WAS TRANSPORTED TO THE HOSP WITH THE PENDANT\nPrior Events:\n----- -------\nE1325284    05-08-2013    CARDIAC EMERGENCY\nE1307493    02-05-2013    MEDICAL ALERT ALARM\nE1246911    09-03-2012    SEIZURES",
        "DATE:05/08/13",
        "CODE:MMA",
        "ID:E1325295",
        "CITY:WHITPAIN TWP",
        "X:W MT PLEASANT AVE AND OAK ST",
        "UNIT:385ST");

    doTest("T7",
        "(Dispatch) Dispatch ** 10:56:48 ** FEVER ** 3855 BLAIR MILL RD  Apt# 239D ** BLAIR MILL VILLAGE EAST APARTMENTS- **  **  ** 35-52 **  ** FEVER OF 100+\n" +
        "CELULLIUS IN LEGS\n" +
        "72/F\n" +
        "C/A\n" +
        " ** 05/08/13 ** MFE ** E1325291 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325291\n" +
        "Incident Received: 05-08-2013  10:56:48              Call Source:      911\n\n" +
        "CODE: MFE-FEVER \n" +
        "BLAIR MILL VILLAGE EAST APARTMENTS\n" +
        "3855 BLAIR MILL RD  Apt# 239D\n" +
        "Cross Street: W MORELAND AVE AND ALISON RD\n\n" +
        "Map: 35-52  Plan:   ADC: 3259A2  MUN: UMOR\n\n" +
        "Units Due:   QX10  384-8\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:56  FEVER OF 100+\n" +
        "10:56  CELULLIUS IN LEGS\n" +
        "10:56  72/F\n" +
        "10:56  C/A\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1312301    03-02-2013    FALL VICTIM\n" +
        "E1265983    12-08-2012    SUBJECT IN PAIN\n" +
        "\n\n" +
        " ** UMOR **  **  **  ** W MORELAND AVE AND ALISON RD **  ** QX10  384-8 ** ",

        "TIME:10:56:48",
        "CALL:FEVER",
        "ADDR:3855 BLAIR MILL RD",
        "APT:239D",
        "PLACE:BLAIR MILL VILLAGE EAST APARTMENTS",
        "MAP:35-52",
        "INFO:FEVER OF 100+\nCELULLIUS IN LEGS\n72/F\nC/A\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n10:56  FEVER OF 100+\n10:56  CELULLIUS IN LEGS\n10:56  72/F\n10:56  C/A\nPrior Events:\n----- -------\nE1312301    03-02-2013    FALL VICTIM\nE1265983    12-08-2012    SUBJECT IN PAIN",
        "DATE:05/08/13",
        "CODE:MFE",
        "ID:E1325291",
        "CITY:UPPER MORELAND TWP",
        "X:W MORELAND AVE AND ALISON RD",
        "UNIT:QX10  384-8");

    doTest("T8",
        "(Dispatch) Dispatch ** 10:26:19 ** CARDIAC EMERGENCY ** 310 RAILROAD AVE ** - **  **  ** 46-21 **  ** CHEST PAINS\n" +
        "3RD PARTY\n" +
        "42/F\n" +
        "C/A\n" +
        "SOB\n" +
        " ** 05/08/13 ** MCE ** E1325284 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325284\n" +
        "Incident Received: 05-08-2013  10:26:19              Call Source:  10DIGIT\n\n" +
        "CODE: MCE-CARDIAC EMERGENCY \n\n" +
        "310 RAILROAD AVE \n" +
        "Cross Street: W MT PLEASANT AVE AND OAK ST\n\n" +
        "Map: 46-21  Plan:   ADC: 3257D5  MUN: WHPN\n\n" +
        "Units Due:   385-3\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:26  CHEST PAINS\n" +
        "10:26  3RD PARTY\n" +
        "10:26  42/F\n" +
        "10:27  C/A\n" +
        "10:27  SOB\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1307493    02-05-2013    MEDICAL ALERT ALARM\n" +
        "E1246911    09-03-2012    SEIZURES\n" +
        "\n\n" +
        " ** WHPN **  **  **  ** W MT PLEASANT AVE AND OAK ST **  ** 385-3 ** ",

        "TIME:10:26:19",
        "CALL:CARDIAC EMERGENCY",
        "ADDR:310 RAILROAD AVE",
        "MAP:46-21",
        "INFO:CHEST PAINS\n3RD PARTY\n42/F\nC/A\nSOB\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n10:26  CHEST PAINS\n10:26  3RD PARTY\n10:26  42/F\n10:27  C/A\n10:27  SOB\nPrior Events:\n----- -------\nE1307493    02-05-2013    MEDICAL ALERT ALARM\nE1246911    09-03-2012    SEIZURES",
        "DATE:05/08/13",
        "CODE:MCE",
        "ID:E1325284",
        "CITY:WHITPAIN TWP",
        "X:W MT PLEASANT AVE AND OAK ST",
        "UNIT:385-3");

    doTest("T9",
        "(Dispatch) Dispatch ** 10:20:46 ** CVA/STROKE ** 1073 OLD YORK RD ** ABINGTON YMCA- **  **  ** 29-D3 **  **  ** 05/08/13 ** MCV ** E1325280 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325280\n" +
        "Incident Received: 05-08-2013  10:20:46              Call Source:  10DIGIT\n\n" +
        "CODE: MCV-CVA/STROKE \n" +
        "ABINGTON YMCA\n" +
        "1073 OLD YORK RD \n" +
        "Cross Street: ADAMS AVE AND SUSQUEHANNA RD\n\n" +
        "Map: 29-D3  Plan:   ADC: 3371A2  MUN: ABGN\n\n" +
        "Units Due:   NC382  383-13\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "KNOX BOX LOCATED TO RIGHT OF PARKING LOT ATRIUM ENTRANCE APPROX 12FT HIGH (LADDER NEEDED).  BOX CONTAINS MASTER KEY, CONTACT INFO, ALARM CODE INFO.\n\n" +
        "Event Comments:\n" +
        "----- ---------\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1313951    03-11-2013    FALL VICTIM\n" +
        "E1307253    02-04-2013    FRACTURE\n" +
        "E1306667    02-01-2013    RESPIRATORY EMERGENCY\n" +
        "E1306245    01-30-2013    FALL VICTIM\n" +
        "E1252330    10-01-2012    UNCONSCIOUS SUBJECT\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** ADAMS AVE AND SUSQUEHANNA RD **  ** NC382  383-13 ** ",

        "TIME:10:20:46",
        "CALL:CVA/STROKE",
        "ADDR:1073 OLD YORK RD",
        "PLACE:ABINGTON YMCA",
        "MAP:29-D3",
        "INFO:Additional Info:\n---------- ----\nKNOX BOX LOCATED TO RIGHT OF PARKING LOT ATRIUM ENTRANCE APPROX 12FT HIGH (LADDER NEEDED).  BOX CONTAINS MASTER KEY, CONTACT INFO, ALARM CODE INFO.\nEvent Comments:\n----- ---------\nPrior Events:\n----- -------\nE1313951    03-11-2013    FALL VICTIM\nE1307253    02-04-2013    FRACTURE\nE1306667    02-01-2013    RESPIRATORY EMERGENCY\nE1306245    01-30-2013    FALL VICTIM\nE1252330    10-01-2012    UNCONSCIOUS SUBJECT",
        "DATE:05/08/13",
        "CODE:MCV",
        "ID:E1325280",
        "CITY:ABINGTON TWP",
        "X:ADAMS AVE AND SUSQUEHANNA RD",
        "UNIT:NC382  383-13");

    doTest("T10",
        "(Dispatch) Dispatch ** 10:19:28 ** RESPIRATORY EMERGENCY ** 1515 THE FAIRWAY   Apt# 514 ** RYDAL PARK NURSING HOME- **  **  ** 29-E4 **  ** SPECIAL ADDRESS COMMENT:\n" +
        "+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n" +
        "ACCESS INFO AVAIL SEE AI NOTES.\n" +
        "SPECIAL ADDRESS COMMENT:\n" +
        "TROUBLE BREATHING/LABORED\n" +
        "ACCESS INFO AVAIL SEE AI NOTES.\n" +
        "87/F\n" +
        "MINIMALLY RESPONSIVE\n" +
        "+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n" +
        " ** 05/08/13 ** MRE ** E1325279 **  ** ------ Dispatch Report v1.3SP ------                   INCIDENT: E1325279\n" +
        "Incident Received: 05-08-2013  10:19:28              Call Source:      911\n\n" +
        "CODE: MRE-RESPIRATORY EMERGENCY \n" +
        "RYDAL PARK NURSING HOME\n" +
        "1515 THE FAIRWAY   Apt# 514\n" +
        "Cross Street: RYDAL RD AND RYDAL RD\n\n" +
        "Map: 29-E4  Plan:   ADC: 3371B3  MUN: ABGN\n\n" +
        "Units Due:   NC382  383-13\n\n" +
        "Additional Info:\n" +
        "---------- ----\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:19  SPECIAL ADDRESS COMMENT:\n" +
        "10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n" +
        "10:19  ACCESS INFO AVAIL SEE AI NOTES.\n" +
        "10:19  SPECIAL ADDRESS COMMENT:\n" +
        "10:19  TROUBLE BREATHING/LABORED\n" +
        "10:19  ACCESS INFO AVAIL SEE AI NOTES.\n" +
        "10:19  87/F\n" +
        "10:19  MINIMALLY RESPONSIVE\n" +
        "10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "E1316058    03-21-2013    UNCONSCIOUS SUBJECT\n" +
        "\n\n" +
        " ** ABGN **  **  **  ** RYDAL RD AND RYDAL RD **  ** NC382  383-13 ** ",

        "TIME:10:19:28",
        "CALL:RESPIRATORY EMERGENCY",
        "ADDR:1515 THE FAIRWAY",
        "APT:514",
        "PLACE:RYDAL PARK NURSING HOME",
        "MAP:29-E4",
        "INFO:+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\nACCESS INFO AVAIL SEE AI NOTES.\nSPECIAL ADDRESS COMMENT:\nTROUBLE BREATHING/LABORED\nACCESS INFO AVAIL SEE AI NOTES.\n87/F\nMINIMALLY RESPONSIVE\n+ RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\nAdditional Info:\n---------- ----\nEvent Comments:\n----- ---------\n10:19  SPECIAL ADDRESS COMMENT:\n10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\n10:19  ACCESS INFO AVAIL SEE AI NOTES.\n10:19  SPECIAL ADDRESS COMMENT:\n10:19  TROUBLE BREATHING/LABORED\n10:19  ACCESS INFO AVAIL SEE AI NOTES.\n10:19  87/F\n10:19  MINIMALLY RESPONSIVE\n10:19  + RYDAL PARK NURSING HOME - OBTAIN BUILDING NAME\nPrior Events:\n----- -------\nE1316058    03-21-2013    UNCONSCIOUS SUBJECT",
        "DATE:05/08/13",
        "CODE:MRE",
        "ID:E1325279",
        "CITY:ABINGTON TWP",
        "X:RYDAL RD AND RYDAL RD",
        "UNIT:NC382  383-13");
  }
  
  public static void main(String[] args) {
    new PAMontgomeryCountyBParserTest().generateTests("T1");
  }
}
