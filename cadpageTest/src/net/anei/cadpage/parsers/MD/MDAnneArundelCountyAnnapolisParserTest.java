package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Anne Arundel county, MD (Annapolis)

Contact: Active911
Agency name: Annapolis Fire
Location: Annapolis, MD, United States
Sender: donotreply@annapolis.gov

(_subject_) INCIDENT 201332270\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n2371 SOLOMONS ISLAND RD-AN          SHOPPERS FOOD WAREHOUSE\n\nGrid 20     Map C10     Area 3540     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2200 FOREST DR-AN\n\nSecond cross street - 2038 SOMERVILLE RD\n\nNature: 17B03-FALL: UNKNOWN STATUS\n\nCall back: 301-261-8743\n\nVOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (000829-43)\nCommunity of ANNAPOLIS CITY (000829-43)\n4438371038 (000829-43)\nTAC CHANNEL B ASSIGNED (001252-)\nUnits 'on air': PM35 (001252-)\n\nPM35  \n\nHYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)\n\nTIME 18:43:40          DATE 06/10/13\nHOSPITAL STATUS   06/10/13   18:45:39\n\nJOHN HOPKINS HO    YELLOW\nBURN CENTER (BA    YELLOW
(_subject_) INCIDENT 201332249\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n85 MANRESA RD     304     SENIOR QUARTERS AT MANRESA\n\nGrid 20     Map K05     Area 1716A     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - B&A TRL-AN\n\nNature: 06C01-BREATHING PROB: ABNORMAL\n\nCall back: 410-349-8624\n\nCommunity of SEVERNSIDE (000897-48)\nTAC CHANNEL B ASSIGNED (001252-)\n\nE171  MU39  \n\nHYDRANTS: 85 MANRESA RD (SIDE A) (0) & 85 MANRESA RD (SIDE D/A) (0)\n\nCAUTION NOTES\n\nTIME 17:08:19          DATE 06/10/13\n\r\nHOSPITAL STATUS   06/10/13   17:09:01\n\nBURN CENTER (BA    YELLOW,  REROUTE
(_subject_) INCIDENT 201332246\n\nCODE L     LOCAL ALARM     ALARM 1\n\nRIVA RD-AN/RT665-AN          \n\nGrid 20     Map B09     Area 4028     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2398 FOREST DR-AN\n\nSecond cross street - 1900 TOWNE CENTRE BLVD-AN\n\nNature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\nCommunity of FESTIVAL PLAZA AT RIVA (009624-42)\nTAC CHANNEL B ASSIGNED (001252-)\nUnits 'on air': E351 (001252-)\n\nE351  \n\nHYDRANTS: 2509 RIVA RD-AN (0) & 2510 RIVA RD (SIDE A/D) (0)\n\nTIME 16:52:51          DATE 06/10/13
(_subject_) INCIDENT 201332245\n\nCODE SA     STILL ALARM     ALARM 1\n\n12 DOCK ST          ANNAPOLIS CRAB DECK\n\nGrid 21     Map A10     Area 3824     Preplan      Channel K    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - RANDALL ST\n\nSecond cross street - 98 CRAIG ST-AN\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: 800-356-2222\n\nCommunity of ANNAPOLIS CITY (000897-48)\nTAC CHANNEL K ASSIGNED (001252-)\n\nE361  LAD39  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nAUTO SPRINKLER SYSTEM\nFULLY SPRINKLERED.\n19001\nFDC LOCATED ON SIDE C, PRINCE GEORGE STREET.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 16:47:02          DATE 06/10/13
(_subject_) INCIDENT 201332244\n\nCODE FA     FIRE ALARM SOUNDING     ALARM 1\n\n203 CAPE ST JOHN RD          \n\nGrid 19     Map J13     Area 0312     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 ISLAND VIEW DR\n\nNature: F05-ALARMS/NON HIGH LIFE (HOT)\n\nCall back: 800-356-2222\n\nCommunity of CAPE SAINT JOHN (000829-43)\nAdded unit 'E351' via 'X' at Tac  (009623-39)\nTAC CHANNEL B ASSIGNED (009623-39)\nUnit 'ME2' had changed quarters for unit 'E21' (009623-39)\nUnits 'on air': ME2 (009623-39)\n\nME2  E351  \n\nHYDRANTS: 224 CAPE ST JOHN RD (0) & 245 CAPE ST JOHN RD (0)\nAREA CAUTION NOTES FOR 0312\nSTAGING AREA FOR W/R: RIVA RD AND CAPE ST JOHN RD\nBOAT RAMP: CAPE ST JOHN, DOGWOOD TRAIL OFF VALLEY VIEW.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 16:40:25          DATE 06/10/13
(_subject_) INCIDENT 201332240\n\nCODE B     BOX ASSIGNMENT     ALARM 1\n\n1994 BELL BRANCH RD          \n\nGrid 18     Map H10     Area 0723     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21054\n\nFirst cross street - RUTLAND RD-GM\n\nSecond cross street - RUTLAND RD-GM\n\nNature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\nCommunity of CARRIAGE ESTATES (000897-48)\nTAC CHANNEL E ASSIGNED (009623-39)\nUnit 'TW839' had changed quarters for unit 'TK839' (009623-39)\nUnit 'TW40' had changed quarters for unit 'TK40' (009623-39)\nUnits 'on air': BC3 (009623-39)\n\nE73  E31  E51  E816  TW839  TW40  SQ38  TA3  TA5  PM3  BC3  SCA  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0723\nCLOSEST HOSPITALS:  1)  AAMC  (2)  PGD  (3)  NAH\n\nTIME 16:27:26          DATE 06/10/13
(_subject_) INCIDENT 201332238\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n1021 CEDAR RIDGE CT          \n\nGrid 20     Map J13     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 920 BANK ST-EP\n\nNature: 01A01-ABDOM PAIN: OR PROBLEM\n\nCall back: 410-263-5325\n\nProQaA: 84 Year Old Man, Conscious, Breathing (000557-42)\nProQaA: ECHO was not selected from Case Entry. (000557-42)\nProQaA: This is a 1st party caller. (000557-42)\nProQaA: There is a single patient. (000557-42)\nProQaA: He is completely awake (alert). (000557-42)\nProQaA: He has not fainted. (000557-42)\nProQaA: He does not have pain above the belly button (navel). (000557-42)\nCommunity of ANNAPOLIS CITY (000557-42)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nPM36  \n\nHYDRANTS:  () &  ()\n\nTIME 16:15:11          DATE 06/10/13
(_subject_) INCIDENT 201332231\n\nCODE WRL     WATER RESCUE LOCAL     ALARM 1\n\nRIVER RD-LH/W NURSERY RD          \n\nGrid 02     Map B05     Area 3203     Preplan      Channel ~3~    MOA 1\n\nCensus Tract      Zip 21090\n\nFirst cross street - 1300 W NURSERY RD\n\nNature: F60-SERVICE CALL (COLD)\n\nNOT MOVING, UNSURE IF OCCUPIED (000958-48)\nTHEY JUST WANT THE VEHICEL CHECKED (000958-48)\nCommunity of PATAPSCO (000958-48)\nTAC CHANNEL ~3~ ASSIGNED (000777-38)\n\nE321  FB36  FB41  SNAP  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3203\nSTAGING AREA FOR W/R: AL'S LIQUORS, 6 NURSERY RD. , BOX 32-4\nBOAT RAMP: MUST CARRY BOAT AND LAUNCH AT COUNTY LINE ON RT. 648\nLZ: CLOSEST IN  BOX 32-6. WINTERSON RD./NEAR RT.295 OR AERO DR.\nAND CORPORATE DR.\n\nTIME 15:43:09          DATE 06/10/13
(_subject_) INCIDENT 201332224\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n151 MAIN ST-AN          GREAT FEATHERS\n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 CONDUIT ST\n\nSecond cross street - 2 FRANCIS ST\n\nNature: 32B03-UNKNOWN: 3RD PARTY CALL\n\nCall back: 410-990-0224\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\nFOR AN AMBO (000958-48)\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\nUnits 'on air': MU39 (009623-39)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 15:02:34          DATE 06/10/13\n\rINCIDENT 201332224\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n151 MAIN ST-AN          GREAT FEATHERS\n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 CONDUIT ST\n\nSecond cross street - 2 FRANCIS ST\n\nNature: 32B03-UNKNOWN: 3RD PARTY CALL\n\nCall back: 410-990-0224\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\nFOR AN AMBO (000958-48)\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\nUnits 'on air': MU39 (009623-39)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 15:02:34          DATE 06/10/13
(_subject_) INCIDENT 201332220\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n2371 SOLOMONS ISLAND RD-AN          SHOPPERS FOOD WAREHOUSE\n\nGrid 20     Map C10     Area 3540     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2200 FOREST DR-AN\n\nSecond cross street - 2038 SOMERVILLE RD\n\nNature: 30B01-TRAUMATIC INJURY? POSS DANGER\n\nCall back: 443-995-0500\n\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\nUnits 'on air': PM35 (009623-39)\n\nPM35  \n\nHYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)\n\nTIME 14:38:48          DATE 06/10/13
(_subject_) INCIDENT 201332202\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\nHOUSLEY RD/DEFENSE HWY-AN          \n\nGrid 20     Map A08     Area 4024     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 152 DEFENSE HWY-AN\n\nSecond cross street - 1 GATEWAY VILLAGE DR\n\nNature: 32B03-UNKNOWN: 3RD PARTY CALL\n\nCall back: 410-212-4273\n\nCommunity of GATEWAY VILLAGE PLAZA (000557-42)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE381  PM40  \n\nHYDRANTS: 2645 HOUSLEY RD (3685) & 2631 HOUSLEY RD (3685)\n\nTIME 13:22:48          DATE 06/10/13
(_subject_) INCIDENT 201332201\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n664 CENTRAL AVE E          SUMMIT SCHOOL\n\nGrid 25     Map C10     Area 0223     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 3700 CAMP LETTS RD\n\nSecond cross street - 500 LOCH HAVEN RD\n\nNature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\nCall back: 888-246-7539\n\nCommunity of CAMP LETTS (000557-42)\nTAC CHANNEL E ASSIGNED (009623-39)\nUnit 'ME2' had changed quarters for unit 'E21' (009623-39)\nUnit 'TW40' had changed quarters for unit 'TK40' (009623-39)\nUnits 'on air': ME2, TA3, E31, TW40, TA1 (009623-39)\n\nME2  E31  E12  E381  TW40  LAD39  SQ7  TA3  TA1  TA40  PM2  BC3  SCA  \n\nHYDRANTS: 664 CENTRAL AVE E (TANK) (0) &  ()\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0223\nSTAGING AREA FOR W/R: CAMP LETTS RD & RT 214\nBOAT RAMP: CAMP LETTS\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 13:20:41          DATE 06/10/13\n\rINCIDENT 201332201\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n664 CENTRAL AVE E          SUMMIT SCHOOL\n\nGrid 25     Map C10     Area 0223     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 3700 CAMP LETTS RD\n\nSecond cross street - 500 LOCH HAVEN RD\n\nNature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\nCall back: 888-246-7539\n\nCommunity of CAMP LETTS (000557-42)\nTAC CHANNEL E ASSIGNED (009623-39)\nUnit 'ME2' had changed quarters for unit 'E21' (009623-39)\nUnit 'TW40' had changed quarters for unit 'TK40' (009623-39)\nUnits 'on air': ME2, TA3, E31, TW40, TA1 (009623-39)\n\nME2  E31  E12  E381  TW40  LAD39  SQ7  TA3  TA1  TA40  PM2  BC3  SCA  \n\nHYDRANTS: 664 CENTRAL AVE E (TANK) (0) &  ()\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0223\nSTAGING AREA FOR W/R: CAMP LETTS RD & RT 214\nBOAT RAMP: CAMP LETTS\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 13:20:41          DATE 06/10/13
(_subject_) INCIDENT 201332200\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n235A FARRAGUT CT     101     \n\nGrid 20     Map G12     Area 3524     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 230 HILLTOP LN-EP\n\nNature: 00A2-MEDICAL SERVICE CALL (COLD)\n\nCall back: 443-994-1416\n\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE352  \n\nHYDRANTS:  () &  ()\n\nTIME 13:11:19          DATE 06/10/13
(_subject_) INCIDENT 201332191\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n809 MIDSHIP CT          \n\nGrid 19     Map G09     Area 4016     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 822 YARDARM WAY\n\nNature: 32B03-UNKNOWN: 3RD PARTY CALL\n\nCommunity of COOVER RD AREA COMMUNITY (000557-42)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE402  PM35  \n\nHYDRANTS:  (0) & 806 MIDSHIP CT (0)\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:\n\nTIME 11:43:31          DATE 06/10/13
(_subject_) INCIDENT 201332183\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n20 CHESTON AVE          \n\nGrid 20     Map J11     Area 3822     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 6 FRANKLIN ST-AN\n\nNature: 17B01-FALL: POSSIBLY DANGEROUS\n\nCall back: 443-848-9747\n\nProQaA: 94 Year Old Woman, Conscious, Breathing (000557-42)\nProQaA: ECHO was not selected from Case Entry. (000557-42)\nProQaA: The caller is with the patient. (000557-42)\nProQaA: There is a single patient. (000557-42)\nProQaA: It's not known when this happened. (000557-42)\nProQaA: The fall was less than six feet/two meters. (000557-42)\nProQaA: The fall was accidental. (000557-42)\nProQaA: She is completely awake (alert). (000557-42)\nProQaA: She is breathing normally. (000557-42)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (000557-42)\nProQaA: There is some bleeding, not serious. (000557-42)\nCommunity of ANNAPOLIS CITY (000557-42)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nMU39  \n\nHYDRANTS:  () &  ()\n\nTIME 11:22:14          DATE 06/10/13
(_subject_) INCIDENT 201332147\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n30 CARVER ST          \n\nGrid 20     Map D10     Area 3529     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 OAKLAWN AVE\n\nSecond cross street - 98 HOLECLOW ST\n\nNature: 06C01-BREATHING PROB: ABNORMAL\n\nCall back: 410-573-0050\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:38:23          DATE 06/10/13INCIDENT 201332147\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n30 CARVER ST          \n\nGrid 20     Map D10     Area 3529     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 OAKLAWN AVE\n\nSecond cross street - 98 HOLECLOW ST\n\nNature: 06C01-BREATHING PROB: ABNORMAL\n\nCall back: 410-573-0050\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\nCommunity of ANNAPOLIS CITY (000958-48)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:38:23          DATE 06/10/13
(_subject_) INCIDENT 201332141\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nADMIRAL DR/CAPTAINS CIR          \n\nGrid 20     Map E08     Area 3514     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 CAPTAINS CIR\n\nSecond cross street - 1978 MORELAND PKWY\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCall back: 410-507-1198\n\nVERIFY PD VERIFY FD VERIFY EMS (000781-43)\nCommunity of ANNAPOLIS CITY (000781-43)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:10:31          DATE 06/10/13INCIDENT 201332141\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nADMIRAL DR/CAPTAINS CIR          \n\nGrid 20     Map E08     Area 3514     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 CAPTAINS CIR\n\nSecond cross street - 1978 MORELAND PKWY\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCall back: 410-507-1198\n\nVERIFY PD VERIFY FD VERIFY EMS (000781-43)\nCommunity of ANNAPOLIS CITY (000781-43)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:10:31          DATE 06/10/13
(_subject_) INCIDENT 201332134\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1705 CEDAR PARK RD          \n\nGrid 20     Map E09     Area 3812     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 FORD CIR\n\nSecond cross street - BRISTOL DR\n\nNature: 19C04-HEART PROB: CARDIAC HX\n\nCall back: 410-280-0959\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-30)\nProQaA: 56 Year Old Man, Conscious, Breathing (009614-30)\nProQaA: ECHO was not selected from Case Entry. (009614-30)\nProQaA: The caller is with the patient. (009614-30)\nProQaA: There is a single patient. (009614-30)\nProQaA: He is completely awake (alert). (009614-30)\nProQaA: He is breathing normally. (009614-30)\nProQaA: He is not changing color. (009614-30)\nProQaA: It's not known if he is clammy. (009614-30)\nProQaA: He has a history of heart problems. (009614-30)\nProQaA: He does not have chest pain. (009614-30)\nProQaA: He took a prescribed medication in the past 12hrs: (009614-30)\nProQaA: ROUTINE (009614-30)\nProQaA: Instructions for taking a pulse have been given. (009614-30)\nProQaA: The caller tried but was unable to determine his pulse rate. (009614-30)\nCommunity of ANNAPOLIS CITY (009614-30)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 07:00:03          DATE 06/10/13\n\rINCIDENT 201332134\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1705 CEDAR PARK RD          \n\nGrid 20     Map E09     Area 3812     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 FORD CIR\n\nSecond cross street - BRISTOL DR\n\nNature: 19C04-HEART PROB: CARDIAC HX\n\nCall back: 410-280-0959\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-30)\nProQaA: 56 Year Old Man, Conscious, Breathing (009614-30)\nProQaA: ECHO was not selected from Case Entry. (009614-30)\nProQaA: The caller is with the patient. (009614-30)\nProQaA: There is a single patient. (009614-30)\nProQaA: He is completely awake (alert). (009614-30)\nProQaA: He is breathing normally. (009614-30)\nProQaA: He is not changing color. (009614-30)\nProQaA: It's not known if he is clammy. (009614-30)\nProQaA: He has a history of heart problems. (009614-30)\nProQaA: He does not have chest pain. (009614-30)\nProQaA: He took a prescribed medication in the past 12hrs: (009614-30)\nProQaA: ROUTINE (009614-30)\nProQaA: Instructions for taking a pulse have been given. (009614-30)\nProQaA: The caller tried but was unable to determine his pulse rate. (009614-30)\nCommunity of ANNAPOLIS CITY (009614-30)\nTAC CHANNEL B ASSIGNED (009623-39)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 07:00:03          DATE 06/10/13
(_subject_) INCIDENT 201332111\n\nCODE FA     FIRE ALARM SOUNDING     ALARM 1\n\n235 WESTWOOD RD-AN          \n\nGrid 20     Map H06     Area 3811     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 SCOTT DR-AN\n\nSecond cross street - 206 WARDOUR DR\n\nNature: F05-ALARMS/NON HIGH LIFE (HOT)\n\nCommunity of ANNAPOLIS CITY (009605-30)\nTAC CHANNEL B ASSIGNED (009624-39)\n\nE381  \n\nHYDRANTS:  () &  ()\n\nTIME 01:49:25          DATE 06/10/13
(_subject_) INCIDENT 201332106\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n461 HONERENG TRL          \n\nGrid 20     Map D04     Area 4026     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 1730 VINEYARD TRL\n\nNature: 21B01-HEMORAGE/LACER: POSS DANGER\n\nProQaA: 61 Year Old Man, Conscious, Breathing (000813-38)\nProQaA: There is a single patient. (000813-38)\nProQaA: ECHO was not selected from Case Entry. (000813-38)\nProQaA: This is a 1st party caller. (000813-38)\nProQaA: The cause of the bleeding is non-traumatic. (000813-38)\nProQaA: The bleeding is from a POSSIBLY DANGEROUS area. (000813-38)\nProQaA: He is completely awake (alert). (000813-38)\nProQaA: He is breathing normally. (000813-38)\nProQaA: There is no SERIOUS bleeding. (000813-38)\nProQaA: He does not have a bleeding disorder or is taking blood (000813-38)\nProQaA: thinners. (000813-38)\nBLOODY STOOL (000813-38)\nCommunity of EPPING FOREST (000813-38)\nTAC CHANNEL B ASSIGNED (009624-39)\n\nE402  PM35  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 4026\nSTAGING AREA FOR W/R:POWELL DRIVE AND NORTH HARBOUR COURT\nBOAT RAMP: SAFERN COMM MARINA, ON NORTH HARBOUR COURT\nLZ:\n\nTIME 00:16:42          DATE 06/10/13
(_subject_) INCIDENT 201332104\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n103 GREAT OAK DR          \n\nGrid 25     Map J04     Area 0817     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 412 HARBOR DR-EP\n\nSecond cross street - 416 HILLSMERE DR\n\nNature: 31D01-UNCONSCIOUS\n\nCall back: 443-223-5985\n\nVERIFY PD VERIFY FD VERIFY EMS (009605-30)\nProQaA: 58 Year Old Man, Unconscious, Breathing (009605-30)\nProQaA: There is a single patient. (009605-30)\nProQaA: ECHO was not selected from Case Entry. (009605-30)\nProQaA: The caller is with the patient. (009605-30)\nProQaA: He is not breathing normally. (009605-30)\nProQaA: He has a history of heart problems. (009605-30)\nProQaA: He is still unconscious. (009605-30)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (009605-30)\nTAC CHANNEL B ASSIGNED (009624-39)\nUnit 'E84' had changed quarters for unit 'E81' (009624-39)\n\nE84  MU8  PM36  TRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 23:41:00          DATE 06/09/13
(_subject_) INCIDENT 201332091\n\nCODE L     LOCAL ALARM     ALARM 1\n\nBELLE DR/ATWATER DR          \n\nGrid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 302 ATWATER DR\n\nSecond cross street - 30 BELLE CT-AN\n\nNature: F42-MISCELLANEOUS FIRE (SPVR)\n\nCall back: 443-714-7478\n\nWIRELESS CALLER VERIFY LOCATION VERIFY CALLBK# (009605-30)\nCommunity of ANNAPOLIS CITY (009605-30)\nTAC CHANNEL B ASSIGNED (009624-39)\n\nE352  \n\nHYDRANTS:  () &  ()\n\nTIME 21:32:15          DATE 06/09/13
(_subject_) INCIDENT 201332084\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n329 HILLSMERE DR          BRYAN PAINT CONTRACTING\n\nGrid 25     Map J04     Area 0817     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 400 DUVALL LN-EP\n\nSecond cross street - 100 MAGNOLIA LN\n\nNature: 10D01-CHEST PAIN: RESP DISTRESS\n\nCall back: 443-254-0579\n\nProQaA: 57 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: ECHO was not selected from Case Entry. (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: He is completely awake (alert). (001239-43)\nProQaA: He is breathing normally. (001239-43)\nProQaA: He is changing color. (001239-43)\nProQaA: He is not clammy. (001239-43)\nProQaA: He has a history of heart problems. (001239-43)\nProQaA: He took a prescribed medication in the past 12hrs: (001239-43)\nProQaA: NITRO (001239-43)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (001239-43)\nTAC CHANNEL B ASSIGNED (009624-39)\nUnit 'MU362' had changed quarters for unit 'MU36' (009624-39)\n\nE361  MU362  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 21:15:04          DATE 06/09/13\n\rINCIDENT 201332084\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n329 HILLSMERE DR          BRYAN PAINT CONTRACTING\n\nGrid 25     Map J04     Area 0817     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 400 DUVALL LN-EP\n\nSecond cross street - 100 MAGNOLIA LN\n\nNature: 10D01-CHEST PAIN: RESP DISTRESS\n\nCall back: 443-254-0579\n\nProQaA: 57 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: ECHO was not selected from Case Entry. (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: He is completely awake (alert). (001239-43)\nProQaA: He is breathing normally. (001239-43)\nProQaA: He is changing color. (001239-43)\nProQaA: He is not clammy. (001239-43)\nProQaA: He has a history of heart problems. (001239-43)\nProQaA: He took a prescribed medication in the past 12hrs: (001239-43)\nProQaA: NITRO (001239-43)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (001239-43)\nTAC CHANNEL B ASSIGNED (009624-39)\nUnit 'MU362' had changed quarters for unit 'MU36' (009624-39)\n\nE361  MU362  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 21:15:04          DATE 06/09/13
(_subject_) INCIDENT 201332083\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n101 MANSION DR          \n\nGrid 25     Map J06     Area 0817     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 610 DOVE LN\n\nSecond cross street - 600 HILLSMERE DR\n\nNature: 04A01A-ASSAULT: NOT DANGEROUS\n\nCall back: 443-924-1809\n\nVERIFY PD VERIFY FD VERIFY EMS (009605-30)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (009605-30)\nTAC CHANNEL B ASSIGNED (000582-38)\nUnit 'E84' had changed quarters for unit 'E81' (000582-38)\n\nE84  PM36  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 21:16:26          DATE 06/09/13
(_subject_) INCIDENT 201332076\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n831 RITCHIE HWY N-SP          KRIS LEIGH CATERED LIVING FACI\n\nGrid 15     Map D08     Area 2305     Preplan      Channel K    MOA 1\n\nCensus Tract      Zip 21146\n\nFirst cross street - 6 MANHATTAN LN\n\nSecond cross street - 2 CYPRESS COVE RD\n\nNature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\nCall back: 800-356-2222\n\nCommunity of MANHATTAN WOODS (009605-30)\nTAC CHANNEL K ASSIGNED (009624-39)\nUnit 'TK30' had changed quarters for unit 'QNT30' (009624-39)\nUnits 'on air': LAD39 (009624-39)\n\nE231  E171  E121  E191  TK30  LAD39  SQ23  PM17  BC2  SCA  \n\nHYDRANTS: 200 BAYLOR RD (0) & 831 RITCHIE HWY N-SP (0)\nAREA CAUTION NOTES FOR 2305\nSTAGING AREA: MCKINSEY ROAD\nBOAT RAMP: CAPE MCKINSEY\nLZ.\nCLOSEST HOSPITALS  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 20:44:24          DATE 06/09/13
(_subject_) INCIDENT 201332052\n\nCODE L     LOCAL ALARM     ALARM 1\n\nBAY RIDGE AVE/MONROE ST          \n\nGrid 20     Map K13     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 900 MONROE ST\n\nSecond cross street - 900 MADISON ST-AN\n\nNature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\nCall back: 864-561-3447\n\nVERIFY PD VERIFY FD VERIFY EMS (001239-43)\nCommunity of ANNAPOLIS CITY (001239-43)\nTAC CHANNEL B ASSIGNED (000582-38)\n\nE361  \n\nHYDRANTS:  () &  ()\n\nTIME 17:44:32          DATE 06/09/13
(_subject_) INCIDENT 201332043\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1424 BAY HEAD RD          \n\nGrid 22     Map A03     Area 1907     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street -  WILLOW LN\n\nSecond cross street - 2 COUNTRY LN\n\nNature: 17D02-FALL: LONG FALL >6 FEET\n\nCall back: 410-974-0976\n\nVOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (009605-30)\nProQaA: 53 Year Old Woman, Conscious, Breathing (009605-30)\nProQaA: There is a single patient. (009605-30)\nProQaA: ECHO was not selected from Case Entry. (009605-30)\nProQaA: The caller is with the patient. (009605-30)\nProQaA: This happened now (less than 6hrs ago). (009605-30)\nProQaA: The fall was greater than six feet/two meters. (009605-30)\nProQaA: The fall was accidental. (009605-30)\nProQaA: She is completely awake (alert). (009605-30)\nProQaA: She is breathing normally. (009605-30)\nProQaA: The injury is to a NOT DANGEROUS area. (009605-30)\nProQaA: There is no bleeding now. (009605-30)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (009605-30)\nCommunity of BAY HEAD (009605-30)\nTAC CHANNEL B ASSIGNED (009624-39)\n\nA199  PM35  \n\nHYDRANTS: 1423 BAY HEAD RD (TANK) (0) & 1566 BAY HEAD RD (0)\nAREA CAUTION NOTES FOR 1907\nSTAGING AREA FOR W/R:FAIRWINDS & LAYROBE DR(FAIRWINDS MARINA)\nBOAT RAMP : 1000 LAKE CLAIR DR (LAKE CLAIRE PIERS)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 17:12:41          DATE 06/09/13
(_subject_) INCIDENT 201332040\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n2422 ANNAPOLIS MALL          \n\nGrid 20     Map B08     Area 4024     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 2188 GENERALS HWY-AN\n\nNature: 21A01-HEMORRHAGE/LAC: NOT DANGER\n\nCall back: 410-507-7626\n\nProQaA: 32 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: ECHO was not selected from Case Entry. (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: The cause of the bleeding is traumatic. (001239-43)\nProQaA: The bleeding is from a NOT DANGEROUS area. (001239-43)\nProQaA: He is completely awake (alert). (001239-43)\nProQaA: He is breathing normally. (001239-43)\nProQaA: It's not known if there is any blood squirting or pouring out. (001239-43)\nProQaA: It's not known if he has a bleeding disorder or takes blood (001239-43)\nProQaA: thinners. (001239-43)\nCommunity of ANNAPOLIS MALL (001239-43)\nTAC CHANNEL B ASSIGNED (009624-39)\nUnits 'on air': E402, PM17 (009624-39)\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 2\nFire Incident location changed from: 2002 ANNAPOLIS MALL (001239-43)\nApt/Lot: SMAK (001239-43)\nNew Fire Incident location: 2422 ANNAPOLIS MALL (001239-43)\nOld Response area: 4024A\nUnits 'on air': PM35 (009624-39)\n\nE402  PM17  PM35  \n\nHYDRANTS: 2002 ANNAPOLIS MALL (0) & 2002 ANNAPOLIS MALL (0)\n\nTIME 16:50:30          DATE 06/09/13
(_subject_) INCIDENT 201332032\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n50 IRONSTONE CT     L     \n\nGrid 25     Map H02     Area 3522     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 1480 COBBLESTONE RD\n\nNature: F60-SERVICE CALL (COLD)\n\nCall back: 443-924-3575\n\nCommunity of ANNAPOLIS CITY (009623-43)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE351  \n\nHYDRANTS:  () &  ()\n\nTIME 15:38:49          DATE 06/09/13
(_subject_) INCIDENT 201332030\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nSOLOMONS ISLAND RD-AN/ANNAPOLIS HARBOR CTR DR          \n\nGrid 20     Map B11     Area 4028     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - SOLOMONS ISLAND RD-AN\n\nSecond cross street - 19 ARIS T ALLEN BLVD E\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCall back: 301-440-0443\n\nFULL ADDR: SOLOMONS ISLAND RD-AN/ANNAPOLIS HARBOR CTR DR\nCommunity of FESTIVAL PLAZA AT RIVA (001559-30)\nTAC CHANNEL B ASSIGNED (000777-38)\n\nE402  PM35  \n\nHYDRANTS:  () &  ()\n\nTIME 15:22:42          DATE 06/09/13
(_subject_) INCIDENT 201332022\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n3538 ROCKWAY AVE          \n\nGrid 26     Map D08     Area 0823     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1308 HOLLYWOOD AVE\n\nSecond cross street - 1314 OAK AVE-EP\n\nNature: 17B03-FALL: UNKNOWN STATUS\n\nCall back: 410-269-5667\n\nVOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (001559-30)\nProQaA: 68 Year Old Woman, Conscious, Breathing (001559-30)\nProQaA: ECHO was not selected from Case Entry. (001559-30)\nProQaA: The caller is with the patient. (001559-30)\nProQaA: There is a single patient. (001559-30)\nProQaA: This happened now (less than 6hrs ago). (001559-30)\nProQaA: It's reported that she fell at ground level. (001559-30)\nProQaA: The reason for the fall is not known. (001559-30)\nProQaA: She is completely awake (alert). (001559-30)\nProQaA: She is breathing normally. (001559-30)\nProQaA: The extent of her injuries is not known. (001559-30)\nProQaA: There is no bleeding now. (001559-30)\nCommunity of ARUNDEL ON THE BAY (001559-30)\nTAC CHANNEL B ASSIGNED (009614-)\nUnit 'E84' had changed quarters for unit 'E81' (009614-)\n\nE84  PM36  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0823\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\nARUNDEL ON THE BAY ASSOCIATION PIER: CORNER OF MAGNOLIA AVE AND\nNEWPORT AVE.\nLOCATION: ON THE GATE TO THE PIER.\nINCLUDES: KEY TO THE LOCK ON THE PIER.\n\nTIME 14:47:36          DATE 06/09/13
(_subject_) INCIDENT 201332015\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nBLADEN ST/CALVERT ST-AN          \n\nGrid 20     Map K09     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - CALVERT ST-AN\n\nSecond cross street - 92 STATE CIR\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCommunity of ANNAPOLIS CITY (009614-)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 13:14:48          DATE 06/09/13\n\rINCIDENT 201332015\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nBLADEN ST/CALVERT ST-AN          \n\nGrid 20     Map K09     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - CALVERT ST-AN\n\nSecond cross street - 92 STATE CIR\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCommunity of ANNAPOLIS CITY (009614-)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 13:14:48          DATE 06/09/13
(_subject_) INCIDENT 201332000\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\nCOLLEGE PKWY-AN/GREEN HOLLY DR          \n\nGrid 16     Map E12     Area 1901     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 1298 GREEN HOLLY DR\n\nSecond cross street - 500 BELLERIVE DR\n\nNature: 32B03-UNKNOWN: 3RD PARTY CALL\n\nCommunity of DEEP CREEK (EASTERN) (009623-43)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE191  PM39  \n\nHYDRANTS: 590 COLLEGE PKWY-AN (0) & 588 COLLEGE PKWY-AN (2623)\nAREA CAUTION NOTES FOR 1901\nSTAGING AREA FOR W/R : RAMBLEWOOD DR NEAR GATEWAY DR-E\nBOAT RAMP : HARBORVEIW AND GATEWAY DR-E(DEEP CREEK MARINA)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 11:40:25          DATE 06/09/13
(_subject_) INCIDENT 201331981\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n23 POCONO DR          \n\nGrid 20     Map H02     Area 1712     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21012\n\nFirst cross street - 32 SIERRA LN\n\nSecond cross street - 1484 GRANDVIEW RD-AR\n\nNature: 21D01-HEMORRHAGE/LAC: DANGEROUS\n\nCall back: 410-757-6287\n\nProQaA: VOMITING BLOOD AND FECEES 46 YOM (000825-43)\nProQaA: 46 Year Old Man, Conscious, Breathing (000825-43)\nProQaA: ECHO was not selected from Case Entry. (000825-43)\nProQaA: The caller is not with the patient. (000825-43)\nProQaA: There is a single patient. (000825-43)\nProQaA: The cause of the bleeding is non-traumatic. (000825-43)\nProQaA: The bleeding is from a DANGEROUS area. (000825-43)\nProQaA: He is completely awake (alert). (000825-43)\nProQaA: It's not known if he is breathing normally. (000825-43)\nCommunity of HIDDEN HILLS (000825-43)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE171  PM39  \n\nHYDRANTS: 30 POCONO DR (0) &  ()\nAREA CAUTION NOTES FOR 1712\nSTAGING AREA FOR W/R : WINCHESTER RD\nBOAT RAMP : THE END OF BEACH DR. OFF RIVERSIDE DR.\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 08:43:24          DATE 06/09/13
(_subject_) INCIDENT 201331975\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n502 S CHERRY GROVE AVE          CHESAPEAKE MARKET/CITGO\n\nGrid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - SKIPPERS LN-AN\n\nSecond cross street - 1738 FOREST DR-AN\n\nNature: 09E01-CARDIAC ARREST: WORKABLE ARRES\n\nCall back: 410-295-2325\n\nProQaA: 25 Year Old Man, Unconscious, Not Breathing (001559-30)\nProQaA: ECHO was not selected from Case Entry. (001559-30)\nProQaA: The caller is with the patient. (001559-30)\nProQaA: There is a single patient. (001559-30)\nCommunity of ANNAPOLIS CITY (001559-30)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE351  PM35  EMS36  \n\nHYDRANTS:  () &  ()\n\nTIME 08:05:07          DATE 06/09/13INCIDENT 201331975\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n502 S CHERRY GROVE AVE          CHESAPEAKE MARKET/CITGO\n\nGrid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - SKIPPERS LN-AN\n\nSecond cross street - 1738 FOREST DR-AN\n\nNature: 09E01-CARDIAC ARREST: WORKABLE ARRES\n\nCall back: 410-295-2325\n\nProQaA: 25 Year Old Man, Unconscious, Not Breathing (001559-30)\nProQaA: ECHO was not selected from Case Entry. (001559-30)\nProQaA: The caller is with the patient. (001559-30)\nProQaA: There is a single patient. (001559-30)\nCommunity of ANNAPOLIS CITY (001559-30)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE351  PM35  EMS36  \n\nHYDRANTS:  () &  ()\n\nTIME 08:05:07          DATE 06/09/13
(_subject_) INCIDENT 201331966\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n7 MIZZEN CT          \n\nGrid 26     Map A02     Area 3605     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 996 BREAKWATER DR\n\nNature: 10A01-CHEST PAIN: NORM BREATH <35\n\nCall back: 443-699-4749\n\nProQaA: CHEST PAINS TIMES COUPLE HOURS 28 YOM (000825-43)\nProQaA: 28 Year Old Man, Conscious, Breathing (000825-43)\nProQaA: ECHO was not selected from Case Entry. (000825-43)\nProQaA: This is a 1st party caller. (000825-43)\nProQaA: There is a single patient. (000825-43)\nProQaA: He is completely awake (alert). (000825-43)\nProQaA: He is breathing normally. (000825-43)\nProQaA: He is not clammy. (000825-43)\nProQaA: He has no history of heart problems. (000825-43)\nProQaA: He took a prescribed medication in the past 12hrs: (000825-43)\nProQaA: MUCINEX, XANAX (000825-43)\nCommunity of ANNAPOLIS CITY (000825-43)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 07:02:57          DATE 06/09/13\n\rINCIDENT 201331966\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n7 MIZZEN CT          \n\nGrid 26     Map A02     Area 3605     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 996 BREAKWATER DR\n\nNature: 10A01-CHEST PAIN: NORM BREATH <35\n\nCall back: 443-699-4749\n\nProQaA: CHEST PAINS TIMES COUPLE HOURS 28 YOM (000825-43)\nProQaA: 28 Year Old Man, Conscious, Breathing (000825-43)\nProQaA: ECHO was not selected from Case Entry. (000825-43)\nProQaA: This is a 1st party caller. (000825-43)\nProQaA: There is a single patient. (000825-43)\nProQaA: He is completely awake (alert). (000825-43)\nProQaA: He is breathing normally. (000825-43)\nProQaA: He is not clammy. (000825-43)\nProQaA: He has no history of heart problems. (000825-43)\nProQaA: He took a prescribed medication in the past 12hrs: (000825-43)\nProQaA: MUCINEX, XANAX (000825-43)\nCommunity of ANNAPOLIS CITY (000825-43)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 07:02:57          DATE 06/09/13
(_subject_) INCIDENT 201331963\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n701 GLENWOOD ST     213     GLENWOOD HIGHRISE\n\nGrid 20     Map H09     Area 3813     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 HARWOOD PLACE\n\nSecond cross street - 600 ADAMS PARK RD\n\nNature: 17B01-FALL: POSSIBLY DANGEROUS\n\nCommunity of ANNAPOLIS CITY (000716-38)\nTAC CHANNEL B ASSIGNED (009611-35)\n\nPM39  \n\nHYDRANTS:  () &  ()\nSIDE C TO RIGHT ON ENTRANCE DOOR.\n17415\nCONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\nFULLY SPRINKLERED.\n19008\nSTANDPIPES IN EACH STAIR TOWER.\nFDC AT SIDE C/D CORNER.\nFIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\nENTRANCE).\nFLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.\n\nTIME 06:15:19          DATE 06/09/13
(_subject_) INCIDENT 201331954\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n1100 E COLLEGE PKWY          SANDY POINT STATE PARK\n\nGrid 22     Map B06     Area 1912     Preplan      Channel I    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - OCEANIC DR\n\nSecond cross street - E BEACH RD\n\nNature: F60-SERVICE CALL (COLD)\n\nCall back: 410-974-2149\n\nCommunity of WALNUT RIDGE (000557-42)\nTAC CHANNEL B ASSIGNED (000557-42)\nUnits 'on air': A419 (000557-42)\nTactical channel changed from B to H (000557-42)\nTactical channel changed from H to I (000557-42)\nUnits 'on air': FB36 (000557-42)\n\nA419  CW2  CW3  FB41  PM17  FB36  \n\nHYDRANTS: 1100 COLLEGE PKWY (BOAT RAMP) (0) & 1100 COLLEGE PKWY (BAIT SHOP) (0)\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 1912\nSTAGING AREA FOR W/R : SOUTH BEACH RD (SANDY PT STATE PARK)OR\n                     : WESTINGHOUSE PARKING LOT\nBOAT RAMP : SOUTH BEACH RD (SANDY PT STATE PARK)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 05:02:13          DATE 06/09/13
(_subject_) INCIDENT 201331956\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n768 FAIRVIEW AVE-EP     B     \n\nGrid 21     Map A13     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - CROSS ST-EP\n\nNature: 06D01-BREATHING PROB: SEVERE DISTRES\n\nCall back: 443-255-7376\n\nProQaA: 74 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: ECHO was not selected from Case Entry. (009617-30)\nProQaA: The caller is not with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: She is able to talk. (009617-30)\nProQaA: She has difficulty speaking between breaths. (009617-30)\nProQaA: She is completely awake (alert). (009617-30)\nProQaA: It's not known if she is changing color. (009617-30)\nProQaA: It's not known if she is clammy. (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (000557-42)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 05:19:27          DATE 06/09/13\n\rINCIDENT 201331956\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n768 FAIRVIEW AVE-EP     B     \n\nGrid 21     Map A13     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - CROSS ST-EP\n\nNature: 06D01-BREATHING PROB: SEVERE DISTRES\n\nCall back: 443-255-7376\n\nProQaA: 74 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: ECHO was not selected from Case Entry. (009617-30)\nProQaA: The caller is not with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: She is able to talk. (009617-30)\nProQaA: She has difficulty speaking between breaths. (009617-30)\nProQaA: She is completely awake (alert). (009617-30)\nProQaA: It's not known if she is changing color. (009617-30)\nProQaA: It's not known if she is clammy. (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (000557-42)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 05:19:27          DATE 06/09/13
(_subject_) INCIDENT 201331951\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n1110 MADISON ST-AN     B2     \n\nGrid 20     Map K12     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 8 SPA CREEK LANDING\n\nSecond cross street - 1000 PRESIDENT ST\n\nNature: 26A01-SICK PERSON/ NO PRIORITY COMPL\n\nCall back: 410-212-1975\n\nProQaA: 47 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: ECHO was not selected from Case Entry. (009617-30)\nProQaA: This is a 1st party caller. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: She is breathing normally. (009617-30)\nProQaA: She does not have chest pain. (009617-30)\nProQaA: She is not bleeding (or vomiting blood). (009617-30)\nProQaA: She is completely awake (alert). (009617-30)\nProQaA: She has no history of heart problems. (009617-30)\nProQaA: No priority symptoms (conditions 2-28 not identified). (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (000557-42)\nTAC CHANNEL B ASSIGNED (000557-42)\n\nPM36  \n\nHYDRANTS:  () &  ()\nKNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n19256\nBY THE MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\nTIME 03:46:21          DATE 06/09/13
(_subject_) INCIDENT 201331944\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nCHESTERFIELD RD-AN/BRAMLEIGH LN          \n\nGrid 19     Map D06     Area 4014     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 960 BRAMLEIGH LN\n\nSecond cross street - 1800 CROSSPOINTE DR\n\nNature: 29B01-MVC: W/INJURIES\n\nCommunity of SYLMAC (000716-38)\nTAC CHANNEL B ASSIGNED (001571-)\n\nE402  PM35  A79  \n\nHYDRANTS:  (0) & 891 CHESTERFIELD RD-AN (2118)\n\nTIME 02:28:41          DATE 06/09/13
(_subject_) INCIDENT 201331900\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n170 MAYO RD-EW          LONDONTOWN COMMUNITY HALL\n\nGrid 24     Map K05     Area 0224     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 1904 BLUE RIDGE RD\n\nSecond cross street - 300 SALISBURY RD\n\nNature: 31C01-FAINTING: ABNORMAL BREATH\n\nCall back: 410-956-4808\n\nCommunity of WOODLAND BEACH (001571-)\nAdded unit 'SQ2' via 'X' at Tac  (001571-)\nTAC CHANNEL B ASSIGNED (001571-)\nUnit 'ME2' had changed quarters for unit 'E21' (001571-)\n\nME2  PM35  SQ2  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0224\nSTAGING AREA FOR W/R: STATION 2\nBOAT RAMP: GRANGE RD & SHORE DR.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 20:33:38          DATE 06/08/13
(_subject_) INCIDENT 201331891\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n701 GLENWOOD ST     706     GLENWOOD HIGHRISE\n\nGrid 20     Map H09     Area 3813     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 400 HARWOOD PLACE\n\nSecond cross street - 600 ADAMS PARK RD\n\nNature: 01C01-ABDOM PAIN: W/FAINT >=50\n\nCall back: 410-571-3093\n\nVERIFY PD VERIFY FD VERIFY EMS (000716-38)\nProQaA: AB PAIN (000716-38)\nProQaA: 57 Year Old Man, Conscious, Breathing (000716-38)\nProQaA: ECHO was not selected from Case Entry. (000716-38)\nProQaA: This is a 1st party caller. (000716-38)\nProQaA: There is a single patient. (000716-38)\nProQaA: He is completely awake (alert). (000716-38)\nProQaA: He has not fainted. (000716-38)\nProQaA: He had a near fainting episode. (000716-38)\nProQaA: He does not have pain above the belly button (navel). (000716-38)\nCommunity of ANNAPOLIS CITY (000716-38)\nProQa: AB PAIN (000716-38)\nTAC CHANNEL B ASSIGNED (009611-)\n\nPM39  \n\nHYDRANTS:  () &  ()\nSIDE C TO RIGHT ON ENTRANCE DOOR.\n17415\nCONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\nFULLY SPRINKLERED.\n19008\nSTANDPIPES IN EACH STAIR TOWER.\nFDC AT SIDE C/D CORNER.\nFIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\nENTRANCE).\nFLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.\n\nTIME 19:53:44          DATE 06/08/13
(_subject_) INCIDENT 201331873\n\nCODE SA     STILL ALARM     ALARM 1\n\n1401 CIRCLE DR-EW          \n\nGrid 24     Map K04     Area 0222     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 1410 PARK RD-EW\n\nNature: F50-ODOR OF SMOKE INSIDE (WARM)\n\nCall back: 410-956-8988\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\nIN BASEMENT (000557-42)\nCommunity of SOUTH RIVER PARK (000557-42)\nTAC CHANNEL E ASSIGNED (001571-)\nUnit 'ME2' had changed quarters for unit 'E21' (001571-)\nUnits 'on air': SQ2 (001571-)\n\nME2  E351  SQ2  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0222\nSTAGING AREA FOR W/R: EDGEWATER ELEMENTARY\nBOAT RAMP: RIVERSIDE RD AND PARK RD\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 18:20:51          DATE 06/08/13
(_subject_) INCIDENT 201331868\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n101 KUETHE DR          \n\nGrid 25     Map K05     Area 0817     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 601 HILLSMERE DR\n\nNature: 31D01-UNCONSCIOUS\n\nCall back: 410-268-5339\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\nProQaA: FALL (000557-42)\nProQaA: 2 Year Old Boy, Unconscious, Breathing (000557-42)\nProQaA: ECHO was not selected from Case Entry. (000557-42)\nProQaA: The caller is with the patient. (000557-42)\nProQaA: There is a single patient. (000557-42)\nProQaA: He is not breathing normally. (000557-42)\nProQaA: He is breathing normally. (000557-42)\nProQaA: It's not known if he is breathing normally. (000557-42)\nProQaA: He has no history of heart problems. (000557-42)\nProQaA: He is still unconscious. (000557-42)\nCHILD STRUCK HIS HEAD (000557-42)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (000557-42)\nTAC CHANNEL B ASSIGNED (009611-35)\nUnit 'E84' had changed quarters for unit 'E81' (009611-35)\n\nE84  MU8  PM36  TRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 18:04:54          DATE 06/08/13\n\r\nHOSPITAL STATUS   06/08/13   18:06:14\n\nBURN CENTER (BA    REROUTE
(_subject_) INCIDENT 201331863\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n722 CHILDS POINT RD          \n\nGrid 20     Map D13     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 316 EATONS LANDING DR\n\nSecond cross street - 704 PILOT HOUSE DR\n\nNature: 32B01-UNKNOWN: PERSON MOVING\n\nCall back: 8911\n\nAAPD ENROUTE (000557-42)\nCommunity of BYWATER ESTATES (000557-42)\nTAC CHANNEL B ASSIGNED (001571-)\nUnits 'on air': PM39, E381 (001571-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 17:34:02          DATE 06/08/13\n\r\nHOSPITAL STATUS   06/08/13   17:34:49\n\nBURN CENTER (BA    REROUTE\n\n\rINCIDENT 201331863\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n722 CHILDS POINT RD          \n\nGrid 20     Map D13     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 316 EATONS LANDING DR\n\nSecond cross street - 704 PILOT HOUSE DR\n\nNature: 32B01-UNKNOWN: PERSON MOVING\n\nCall back: 8911\n\nAAPD ENROUTE (000557-42)\nCommunity of BYWATER ESTATES (000557-42)\nTAC CHANNEL B ASSIGNED (001571-)\nUnits 'on air': PM39, E381 (001571-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 17:34:02          DATE 06/08/13\n\r\nHOSPITAL STATUS   06/08/13   17:34:49\n\nBURN CENTER (BA    REROUTE
(_subject_) INCIDENT 201331858\n\nCODE L     LOCAL ALARM     ALARM 1\n\n821 BETSY CT          \n\nGrid 20     Map E13     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 798 NEWTOWNE DR\n\nNature: F42-MISCELLANEOUS FIRE (SPVR)\n\nCall back: 410-263-6237\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\nBASKETBALL COURT ON FIRE (000557-42)\nCommunity of ANNAPOLIS CITY (000557-42)\nTAC CHANNEL B ASSIGNED (001571-)\n\nE351  \n\nHYDRANTS:  () &  ()\n\nTIME 17:04:07          DATE 06/08/13
(_subject_) INCIDENT 201331842\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2 COMPROMISE ST          ANNAPOLIS YACHT CLUB\n\nGrid 21     Map A11     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 6TH ST-AN\n\nNature: 28C03-STROKE: SPEECH/MOVMENT PROB\n\nCall back: 202-716-1103\n\nVERIFY PD VERIFY FD VERIFY EMS (000829-30)\nProQaA: 78 Year Old Man, Conscious, Breathing (000829-30)\nProQaA: He has flu symptoms. (000829-30)\nProQaA: ECHO was not selected from Case Entry. (000829-30)\nProQaA: The caller is with the patient. (000829-30)\nProQaA: There is a single patient. (000829-30)\nProQaA: He is completely awake (alert). (000829-30)\nProQaA: He is breathing normally. (000829-30)\nProQaA: He is able to talk normally. (000829-30)\nProQaA: He is having movement problems. (000829-30)\nProQaA: He was last reported to be without this problem: (000829-30)\nProQaA: THIS AM (000829-30)\nTAN (000829-30)\nCommunity of ANNAPOLIS CITY (000829-30)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nKNOX BOX\nKNOX BOX LOCATED TO THE LEFT OF THE MAIN ENTRY DOORS.\n19293\n\nAUTO SPRINKLER SYSTEM\nONLY THE BUILDING AT END OF PIER IS SPRINKLERED.\n18995\nTHE FDC IS FACING COMPROMISE ST ON A TWO STORY BUILDING IN THE PARKING LOT.\nMAIN VALVE BEHIND FDC.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 15:51:08          DATE 06/08/13\n\rINCIDENT 201331842\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2 COMPROMISE ST          ANNAPOLIS YACHT CLUB\n\nGrid 21     Map A11     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 6TH ST-AN\n\nNature: 28C03-STROKE: SPEECH/MOVMENT PROB\n\nCall back: 202-716-1103\n\nVERIFY PD VERIFY FD VERIFY EMS (000829-30)\nProQaA: 78 Year Old Man, Conscious, Breathing (000829-30)\nProQaA: He has flu symptoms. (000829-30)\nProQaA: ECHO was not selected from Case Entry. (000829-30)\nProQaA: The caller is with the patient. (000829-30)\nProQaA: There is a single patient. (000829-30)\nProQaA: He is completely awake (alert). (000829-30)\nProQaA: He is breathing normally. (000829-30)\nProQaA: He is able to talk normally. (000829-30)\nProQaA: He is having movement problems. (000829-30)\nProQaA: He was last reported to be without this problem: (000829-30)\nProQaA: THIS AM (000829-30)\nTAN (000829-30)\nCommunity of ANNAPOLIS CITY (000829-30)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nKNOX BOX\nKNOX BOX LOCATED TO THE LEFT OF THE MAIN ENTRY DOORS.\n19293\n\nAUTO SPRINKLER SYSTEM\nONLY THE BUILDING AT END OF PIER IS SPRINKLERED.\n18995\nTHE FDC IS FACING COMPROMISE ST ON A TWO STORY BUILDING IN THE PARKING LOT.\nMAIN VALVE BEHIND FDC.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 15:51:08          DATE 06/08/13
(_subject_) INCIDENT 201331836\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1121 LAKE HERON DR     1     \n\nGrid 26     Map B01     Area 3605     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1102 PINEMONT PL\n\nSecond cross street - 1200 OAK HILL PL\n\nNature: 06C01-BREATHING PROB: ABNORMAL\n\nCall back: 443-949-0942\n\nVERIFY PD VERIFY FD VERIFY EMS (000829-30)\nProQaA: BACK PAIN (000829-30)\nProQaA: 47 Year Old Woman, Conscious, Breathing (000829-30)\nProQaA: ECHO was not selected from Case Entry. (000829-30)\nProQaA: This is a 1st party caller. (000829-30)\nProQaA: There is a single patient. (000829-30)\nProQaA: This started (happened) more than 6hrs ago. (000829-30)\nProQaA: The cause of her back pain is reportedly a non-traumatic (000829-30)\nProQaA: medical condition. (000829-30)\nProQaA: She is having difficulty breathing. (000829-30)\nProQaA: She is able to talk. (000829-30)\nProQaA: She does not have any difficulty speaking between breaths. (000829-30)\nProQaA: She is completely awake (alert). (000829-30)\nProQaA: She is not clammy. (000829-30)\nProQaA: She has no history of heart problems. (000829-30)\nProQaA: She has asthma. (000829-30)\nProQaA: She has a prescribed inhaler. (000829-30)\nProQaA: She has used a prescribed inhaler. (000829-30)\nProQaA: N/A (000829-30)\nCommunity of ANNAPOLIS CITY (000829-30)\nProQa: BACK PAIN (000829-30)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE361  MU8  ATRO  \n\nHYDRANTS:  () &  ()\nFIRE ALARM PANEL IN UTILITY CLOSET, SIDE D.\n19208\nCOMBINATION IS 130\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 15:14:06          DATE 06/08/13
(_subject_) INCIDENT 201331833\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n2001 MEDICAL PKWY          AA MEDICAL CENTER HOSPITAL\n\nGrid 20     Map C08     Area 4024B     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - RT50 W-AN\n\nNature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\nCommunity of ANNE ARUNDEL MEDICAL OFFICE BLDGS (009624-43)\nTAC CHANNEL E ASSIGNED (009617-)\nUnit 'TW40' had changed quarters for unit 'TK40' (009617-)\nUnit 'E462' had changed quarters for unit 'QNT46' (009617-)\nUnits 'on air': BC35, BC3 (009617-)\n\nE402  E381  E461  E462  TW40  LAD39  SQ2  PM40  BC35  BC3  SCA  \n\nHYDRANTS:  (0) &  (0)\n\nCAUTION NOTES\n\nTIME 14:59:52          DATE 06/08/13
(_subject_) INCIDENT 201331832\n\nCODE LZ     LANDING ZONE     ALARM 1\n\n1399 FOREST DR-EP          ANNAPOLIS MIDDLE SCHOOL\n\nGrid 20     Map G13     Area 0813     Preplan      Channel C    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street -  OLD FOREST DR\n\nSecond cross street -  YOUNGS FARM RD\n\nNature: F82-HELICOPTER LANDING SITE (HOT)\n\nCall back: 410-267-8658\n\nCommunity of ANNAPOLIS JUNIOR HIGH SCHOOL (009617-)\nTAC CHANNEL C ASSIGNED (009617-)\n\nE351  TRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0813\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 14:52:51          DATE 06/08/13
(_subject_) INCIDENT 201331830\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\nHILLSMERE DR/MAGNOLIA LN          \n\nGrid 25     Map J04     Area 0817     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 100 MAGNOLIA LN\n\nSecond cross street - 300 BEACH DR-EP\n\nNature: 29D02B-MVC: INVOLVING BIKE/MOTORCYCLE\n\nCall back: 410-320-6079\n\nVERIFY PD VERIFY FD VERIFY EMS (000829-30)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (000829-30)\nTAC CHANNEL B ASSIGNED (000582-38)\nUnit 'E84' had changed quarters for unit 'E81' (000582-38)\n\nE84  PM35  TRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 14:42:39          DATE 06/08/13
(_subject_) INCIDENT 201331809\n\nCODE M     ALS W/O FIRST RESPONDER     ALARM 1\n\n620 TAYLOR AVE-AN          TAYLOR AVE FIRE STATION\n\nGrid 20     Map J08     Area 3811     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 RIDGELY AVE\n\nSecond cross street - 302 ROSCOE ROWE BLVD\n\nNature: 10C01-CHEST PAIN: ABNORMAL BREATH\n\nCall back: 410-222-8239\n\nCommunity of AACO FIRE-WATER WITCH CO 39 (009624-43)\nTAC CHANNEL B ASSIGNED (009605-)\n\nPM39  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nAUTO SPRINKLER SYSTEM\nFULLY SPRINKLERED.\n19263\nFDC ON SIDE 4.\nMAIN VALVE INSIDE, BEHIND FDC.\n\nTIME 12:30:17          DATE 06/08/13
(_subject_) INCIDENT 201331801\n\nCODE L     LOCAL ALARM     ALARM 1\n\n507 TULIP RD-EP          \n\nGrid 25     Map D02     Area 0812     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 2702 WILLOW HILL RD\n\nNature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\nCall back: 443-994-4154\n\nWIRELESS CALLER VERIFY LOCATION VERIFY CALLBK# (009624-43)\nCommunity of WILD ROSE SHORES (009624-43)\nTAC CHANNEL B ASSIGNED (009605-)\n\nE351  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0812\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 11:58:34          DATE 06/08/13
(_subject_) INCIDENT 201331796\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n1283 GRAFF CT          \n\nGrid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 1290 THOM DR\n\nNature: F60-SERVICE CALL (COLD)\n\nCommunity of ANNAPOLIS CITY (009624-43)\nTAC CHANNEL B ASSIGNED (009605-)\n\nE361  \n\nHYDRANTS:  () &  ()\n\nTIME 11:05:25          DATE 06/08/13
(_subject_) INCIDENT 201331777\n\nCODE CO     CO DETECTOR NO IJURIES     ALARM 1\n\n324 BURNSIDE ST          \n\nGrid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 700 SEVERN AVE-EP\n\nNature: F05A-CO DET./NO INJURIES (COLD)\n\nCommunity of ANNAPOLIS CITY (009624-43)\nTAC CHANNEL B ASSIGNED (009605-)\nUnit 'E84' had changed quarters for unit 'E81' (009605-)\n\nSQ38  E84  \n\nHYDRANTS:  () &  ()\n\nAUTO SPRINKLER SYSTEM\nDWELLING HAS A 13D TYPE RESIDENTIAL SPRINKLER SYSTEM.\n19210\nDOMESTICALLY FED, NO FDC.\n\nTIME 08:43:26          DATE 06/08/13
(_subject_) INCIDENT 201331757\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nFOREST DR-AN/HILLTOP LN-AN          \n\nGrid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 HILLTOP LN-AN\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (001583-)\n\nE351  PM35  ATRO  \n\nHYDRANTS: 2250 FOREST DR-AN (4490) & 2252 FOREST DR-AN (4490)\n\nTIME 04:02:20          DATE 06/08/13INCIDENT 201331757\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nFOREST DR-AN/HILLTOP LN-AN          \n\nGrid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 HILLTOP LN-AN\n\nNature: 29B06-MVC: UNKNOWN STATUS\n\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (001583-)\n\nE351  PM35  ATRO  \n\nHYDRANTS: 2250 FOREST DR-AN (4490) & 2252 FOREST DR-AN (4490)\n\nTIME 04:02:20          DATE 06/08/13
(_subject_) INCIDENT 201331751\n\nCODE SA     STILL ALARM     ALARM 1\n\n371 COLONY POINT PL          \n\nGrid 24     Map K05     Area 0224     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 301 HOWARDS POINT RD\n\nSecond cross street - 3702 BAYPORT DR\n\nNature: F50-ODOR OF SMOKE INSIDE (WARM)\n\nCall back: 410-956-2663\n\nCommunity of SOUTH RIVER COLONY (009617-30)\nTAC CHANNEL E ASSIGNED (001583-)\nUnit 'ME2' had changed quarters for unit 'E21' (001583-)\nUnit 'TW40' had changed quarters for unit 'TK40' (001583-)\n\nME2  E351  TW40  \n\nHYDRANTS: 383 COLONY POINT PL (0) &  (0)\nAREA CAUTION NOTES FOR 0224\nSTAGING AREA FOR W/R: STATION 2\nBOAT RAMP: GRANGE RD & SHORE DR.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 03:06:00          DATE 06/08/13
(_subject_) INCIDENT 201331741\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n225 BOXWOOD RD     105     \n\nGrid 20     Map G12     Area 3524     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 246 HILLTOP LN-EP\n\nSecond cross street - 205 BOXWOOD CT\n\nNature: 09E02-CARDIAC ARREST: AGONAL RESP\n\nCall back: 443-326-0075\n\nProQaA: GRANDFATHER SICK (009603-42)\nProQaA: 68 Year Old Man, Unconscious, Unknown Breathing (009603-42)\nProQaA: ECHO was not selected from Case Entry. (009603-42)\nProQaA: The caller is with the patient. (009603-42)\nProQaA: There is a single patient. (009603-42)\nCommunity of ANNAPOLIS CITY (009603-42)\nTAC CHANNEL B ASSIGNED (000829-35)\n\nE361  PM35  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 00:40:03          DATE 06/08/13
(_subject_) INCIDENT 201331739\n\nCODE SA     STILL ALARM     ALARM 1\n\n13 MARCS CT          \n\nGrid 25     Map K02     Area 3604     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 2 BENS DR\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: 877-898-2000\n\nCommunity of ANNAPOLIS CITY (009611-43)\nTAC CHANNEL E ASSIGNED (000829-35)\nUnit 'E84' had changed quarters for unit 'E81' (000829-35)\n\nE84  TK36  \n\nHYDRANTS:  () &  ()\n\nTIME 00:35:14          DATE 06/08/13

Contact: Active911
Agency name: Annapolis Fire
Location: Annapolis, MD, United States
Sender: donotreply@annapolis.gov

(_subject_) INCIDENT 201342685\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n9 BATES ST          \n\nGrid 20     Map J09     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 112 CLAY ST\n\nSecond cross street - 11 ABNEY LN\n\nNature: 26C01-ALTERED MENTAL STATUS\n\nCall back: 410-268-0962\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001488-30)\nProQaA: 8 Month Old Infant Girl, Conscious, Breathing (001488-30)\nProQaA: There is a single patient. (001488-30)\nProQaA: - (001488-30)\nProQaA: The caller is with the patient. (001488-30)\nProQaA: She is completely alert (responding appropriately). (001488-30)\nProQaA: She is not acting normal. (001488-30)\nProQaA: She is breathing normally. (001488-30)\nProQaA: She does not have any pain. (001488-30)\nProQaA: She is not bleeding (or vomiting blood). (001488-30)\nCommunity of ANNAPOLIS CITY (001488-30)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:28:41          DATE 07/29/13\n\rINCIDENT 201342685\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n9 BATES ST          \n\nGrid 20     Map J09     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 112 CLAY ST\n\nSecond cross street - 11 ABNEY LN\n\nNature: 26C01-ALTERED MENTAL STATUS\n\nCall back: 410-268-0962\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001488-30)\nProQaA: 8 Month Old Infant Girl, Conscious, Breathing (001488-30)\nProQaA: There is a single patient. (001488-30)\nProQaA: - (001488-30)\nProQaA: The caller is with the patient. (001488-30)\nProQaA: She is completely alert (responding appropriately). (001488-30)\nProQaA: She is not acting normal. (001488-30)\nProQaA: She is breathing normally. (001488-30)\nProQaA: She does not have any pain. (001488-30)\nProQaA: She is not bleeding (or vomiting blood). (001488-30)\nCommunity of ANNAPOLIS CITY (001488-30)\nTAC CHANNEL B ASSIGNED (009614-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:28:41          DATE 07/29/13
(_subject_) INCIDENT 201342681\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\nCHESTER AVE/FIRST ST-EP          \n\nGrid 21     Map B11     Area 3601     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 600 FIRST ST-EP\n\nSecond cross street - 398 RIVERVIEW AVE-EP\n\nNature: 17D03-FALL:NOT ALERT\n\nCall back: 281-414-2935\n\nProQaA: 64 Year Old Woman, Conscious, Breathing (009611-43)\nProQaA: - (009611-43)\nProQaA: The caller is with the patient. (009611-43)\nProQaA: There is a single patient. (009611-43)\nProQaA: This happened now (less than 6hrs ago). (009611-43)\nProQaA: It's reported that she fell at ground level. (009611-43)\nProQaA: The fall was accidental. (009611-43)\nProQaA: There is no bleeding now. (009611-43)\nProQaA: She is not completely alert (not responding appropriately). (009611-43)\nProQaA: The injury is to a NOT DANGEROUS area. (009611-43)\nCommunity of ANNAPOLIS CITY (009611-43)\nTAC CHANNEL B ASSIGNED (009614-)\nATRO Available 19:13:39 (009614-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:12:04          DATE 07/29/13\n\rINCIDENT 201342681\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\nCHESTER AVE/FIRST ST-EP          \n\nGrid 21     Map B11     Area 3601     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 600 FIRST ST-EP\n\nSecond cross street - 398 RIVERVIEW AVE-EP\n\nNature: 17D03-FALL:NOT ALERT\n\nCall back: 281-414-2935\n\nProQaA: 64 Year Old Woman, Conscious, Breathing (009611-43)\nProQaA: - (009611-43)\nProQaA: The caller is with the patient. (009611-43)\nProQaA: There is a single patient. (009611-43)\nProQaA: This happened now (less than 6hrs ago). (009611-43)\nProQaA: It's reported that she fell at ground level. (009611-43)\nProQaA: The fall was accidental. (009611-43)\nProQaA: There is no bleeding now. (009611-43)\nProQaA: She is not completely alert (not responding appropriately). (009611-43)\nProQaA: The injury is to a NOT DANGEROUS area. (009611-43)\nCommunity of ANNAPOLIS CITY (009611-43)\nTAC CHANNEL B ASSIGNED (009614-)\nATRO Available 19:13:39 (009614-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:12:04          DATE 07/29/13
(_subject_) INCIDENT 201342657\n\nCODE L     LOCAL ALARM     ALARM 1\n\n20 ELLINGTON DR-EP          \n\nGrid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 134 JANWALL ST\n\nNature: F15C-CONTROLLED BURNING (COLD)\n\nCommunity of ANNAPOLIS CITY (009611-)\nTAC CHANNEL B ASSIGNED (000777-38)\n\nE361  \n\nHYDRANTS:  () &  ()\n\nTIME 17:08:53          DATE 07/29/13
(_subject_) INCIDENT 201342652\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2700 S HAVEN RD     120A     HERITAGE HARBOUR NURSING\n\nGrid 19     Map F11     Area 4016     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 798 PINE WOOD DR\n\nSecond cross street - 882 BOATSWAIN WAY\n\nNature: 26C01-ALTERED MENTAL STATUS\n\nCall back: 4108971300 X202\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\nProQaA: 85 Year Old Man, Conscious, Breathing (000941-42)\nProQaA: - (000941-42)\nProQaA: The caller is not with the patient. (000941-42)\nProQaA: There is a single patient. (000941-42)\nProQaA: He is lethargic. (000941-42)\nProQaA: He is breathing normally. (000941-42)\nProQaA: He does not have any pain. (000941-42)\nProQaA: He is not bleeding (or vomiting blood). (000941-42)\nABNORMAL LABS (000941-42)\nCommunity of HERITAGE HARBOR (000941-42)\nTAC CHANNEL B ASSIGNED (009620-)\nUnit 'TW40' had changed quarters for unit 'TK40' (009620-)\nMU3 Available 16:38:56 (009620-)\n\nTW40  MU3  PM39  \n\nHYDRANTS: 2700 SOUTH HAVEN DR (SIDE C) (0) & 2700 SOUTH HAVEN DR (0)\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:\n\nTIME 16:37:10          DATE 07/29/13
(_subject_) INCIDENT 201342650\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n479 MERRYMAN RD          CREATIVE GARDENS LEARNING CTR\n\nGrid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 MERRYMAN CT\n\nSecond cross street - 2 HERITAGE CT\n\nNature: 17D03-FALL:NOT ALERT\n\nCall back: 410-268-0900\n\nProQaA: 60 Year Old Woman, Conscious, Breathing (001488-30)\nProQaA: There is a single patient. (001488-30)\nProQaA: - (001488-30)\nProQaA: The caller is with the patient. (001488-30)\nProQaA: This happened now (less than 6hrs ago). (001488-30)\nProQaA: It's reported that she fell at ground level. (001488-30)\nProQaA: The fall was accidental. (001488-30)\nProQaA: There is SERIOUS bleeding. (001488-30)\nProQaA: She is not completely alert (not responding appropriately). (001488-30)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (001488-30)\nCommunity of ANNAPOLIS CITY (001488-30)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nKNOX BOX\nRIGHT SIDE OF DOOR\n17415\nALARM CODE 1113\nGATE CODE - LEFT SIDE 0143\n\nTIME 16:30:57          DATE 07/29/13INCIDENT 201342650\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n479 MERRYMAN RD          CREATIVE GARDENS LEARNING CTR\n\nGrid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 MERRYMAN CT\n\nSecond cross street - 2 HERITAGE CT\n\nNature: 17D03-FALL:NOT ALERT\n\nCall back: 410-268-0900\n\nProQaA: 60 Year Old Woman, Conscious, Breathing (001488-30)\nProQaA: There is a single patient. (001488-30)\nProQaA: - (001488-30)\nProQaA: The caller is with the patient. (001488-30)\nProQaA: This happened now (less than 6hrs ago). (001488-30)\nProQaA: It's reported that she fell at ground level. (001488-30)\nProQaA: The fall was accidental. (001488-30)\nProQaA: There is SERIOUS bleeding. (001488-30)\nProQaA: She is not completely alert (not responding appropriately). (001488-30)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (001488-30)\nCommunity of ANNAPOLIS CITY (001488-30)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nKNOX BOX\nRIGHT SIDE OF DOOR\n17415\nALARM CODE 1113\nGATE CODE - LEFT SIDE 0143\n\nTIME 16:30:57          DATE 07/29/13
(_subject_) INCIDENT 201342639\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n899 REVELL HWY W-AN          BAY BRIDGE WESTBOUND SPAN\n\nGrid 21     Map A03     Area 1980     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - OCEANIC DR\n\nNature: 29B04A-MVC:UNKNOWN STATUS\n\nCommunity of CAPTAINS CHOICE (009620-39)\nRemove unit 'E172' via 'X' at Tac  (009620-39)\nRemove unit 'BC2' via 'X' at Tac  (009620-39)\nTAC CHANNEL B ASSIGNED (009620-39)\nUnits 'on air': BC2 (009620-39)\n\nPM39  E191  \n\nHYDRANTS: 1100 COLLEGE PKWY E - NEW HQ (0) & 1100 COLLEGE PKWY E, SB & EB (0)\n\nCAUTION NOTES\n\nTIME 15:48:10          DATE 07/29/13
(_subject_) INCIDENT 201342630\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n501 OAKLAWN AVE          \n\nGrid 20     Map C10     Area 3528     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street -  MIDDLE ST\n\nSecond cross street - 34 CARVER ST\n\nNature: 01C06-ABD PAIN:ABOVE NAVAL FEMALE\n\nCall back: 443-942-2270\n\nProQaA: 49 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: This is a 1st party caller. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: She is completely alert (responding appropriately). (009617-30)\nProQaA: She has difficulty speaking between breaths. (009617-30)\nNature Changed Via ProQA From: 01C06-ABD PAIN:ABOVE NAVAL FEMALE\nFire Priority Changed Via ProQA From: 2 to 2\nReConfig ProQaA: There was no mention of existing aortic aneurysm. (009617-30)\nReConfig ProQaA: She has not fainted or nearly fainted. (009617-30)\nReConfig ProQaA: She has pain above the belly button (navel). (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (009620-)\nUnit 'MU362' had changed quarters for unit 'MU36' (009620-)\n\nE351  MU362  \n\nHYDRANTS:  () &  ()\n\nTIME 14:57:02          DATE 07/29/13
(_subject_) INCIDENT 201342619\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n954 BAY RIDGE RD-EP          ROCCOS PIZZERA\n\nGrid 26     Map A03     Area 3605     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2898 CARROLLTON RD-EP\n\nSecond cross street -  EDGEWOOD RD-EP\n\nNature: 26D01-SICK PERSON:NOT ALERT\n\nCall back: 410-263-9449\n\nProQaA: 83 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: The caller is with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: This happened now (less than 6hrs ago). (009617-30)\nProQaA: It's reported that she fell at ground level. (009617-30)\nProQaA: The fall was accidental. (009617-30)\nProQaA: There is no bleeding now. (009617-30)\nProQaA: She is not completely alert (not responding appropriately). (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nAUTO SPRINKLER SYSTEM\nFDC LOCATED ON SIDE 3.\n19291\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 14:29:46          DATE 07/29/13\n\rINCIDENT 201342619\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n954 BAY RIDGE RD-EP          ROCCOS PIZZERA\n\nGrid 26     Map A03     Area 3605     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2898 CARROLLTON RD-EP\n\nSecond cross street -  EDGEWOOD RD-EP\n\nNature: 26D01-SICK PERSON:NOT ALERT\n\nCall back: 410-263-9449\n\nProQaA: 83 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: The caller is with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: This happened now (less than 6hrs ago). (009617-30)\nProQaA: It's reported that she fell at ground level. (009617-30)\nProQaA: The fall was accidental. (009617-30)\nProQaA: There is no bleeding now. (009617-30)\nProQaA: She is not completely alert (not responding appropriately). (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\n\nAUTO SPRINKLER SYSTEM\nFDC LOCATED ON SIDE 3.\n19291\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 14:29:46          DATE 07/29/13
(_subject_) INCIDENT 201342618\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n118 CARROLL DR-EP          \n\nGrid 25     Map J05     Area 0817     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 602 TAYMAN DR\n\nSecond cross street - 82 GREAT LAKE DR\n\nNature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\nCall back: 410-263-5101\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-43)\nCommunity of HILLSMERE SHORES-(IN COUNTY) (001239-43)\nTAC CHANNEL B ASSIGNED (009620-)\nUnit 'E84' had changed quarters for unit 'E81' (009620-)\n\nE84  MU8  PM36  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 14:27:27          DATE 07/29/13
(_subject_) INCIDENT 201342616\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2574 S HAVEN RD          LA CASA ASSISTED LIVING\n\nGrid 19     Map E10     Area 4016     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2598 HIDDEN COVE RD\n\nSecond cross street -  MASTLINE DR\n\nNature: 12A04-SEIZURE:FOCAL ALERT\n\nCall back: 410-224-5551\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009617-30)\nProQaA: 69 Year Old Man, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: The caller is with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: This is a FOCAL seizure. (009617-30)\nProQaA: He is not diabetic. (009617-30)\nProQaA: He is not an epileptic (not diagnosed with a seizure (009617-30)\nProQaA: disorder). (009617-30)\nProQaA: He does not have a history of STROKE or brain tumor. (009617-30)\nProQaA: He is completely alert (responding appropriately). (009617-30)\nCommunity of HERITAGE HARBOR (009617-30)\nTAC CHANNEL B ASSIGNED (009620-)\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\n\nE402  MU40  PM35  \n\nHYDRANTS: 2574 SOUTH HAVEN DR (2605) & 2600 SOUTH HAVEN DR (2605)\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:\n\nTIME 14:15:53          DATE 07/29/13
(_subject_) INCIDENT 201342609\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n21 CORNHILL ST          \n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 46 STATE CIR\n\nSecond cross street - 98 HYDE ALLEY\n\nNature: 21D03-HEMORRHAGE/LAC:DANGEROUS\n\nCall back: 443-615-3475\n\nVERIFY PD VERIFY FD VERIFY EMS (001239-43)\nProQaA: 73 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: - (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: The cause of the bleeding is non-traumatic. (001239-43)\nProQaA: He is coughing up blood. (001239-43)\nProQaA: He is completely alert (responding appropriately). (001239-43)\nProQaA: He is breathing normally. (001239-43)\nProQaA: There is SERIOUS bleeding. (001239-43)\nProQaA: He does not have a bleeding disorder or is taking blood (001239-43)\nProQaA: thinners. (001239-43)\nCommunity of ANNAPOLIS CITY (001239-43)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 13:34:01          DATE 07/29/13\n\rINCIDENT 201342609\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n21 CORNHILL ST          \n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 46 STATE CIR\n\nSecond cross street - 98 HYDE ALLEY\n\nNature: 21D03-HEMORRHAGE/LAC:DANGEROUS\n\nCall back: 443-615-3475\n\nVERIFY PD VERIFY FD VERIFY EMS (001239-43)\nProQaA: 73 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: - (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: The cause of the bleeding is non-traumatic. (001239-43)\nProQaA: He is coughing up blood. (001239-43)\nProQaA: He is completely alert (responding appropriately). (001239-43)\nProQaA: He is breathing normally. (001239-43)\nProQaA: There is SERIOUS bleeding. (001239-43)\nProQaA: He does not have a bleeding disorder or is taking blood (001239-43)\nProQaA: thinners. (001239-43)\nCommunity of ANNAPOLIS CITY (001239-43)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 13:34:01          DATE 07/29/13
(_subject_) INCIDENT 201342588\n\nCODE SA     STILL ALARM     ALARM 1\n\n1810 VIEW TOP CT          \n\nGrid 21     Map B03     Area 1715     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 1774 MEADOW HILL DR\n\nNature: F50-ODOR OF SMOKE INSIDE (WARM)\n\nCall back: 443-758-7431\n\nPROQA ABORTED\nCommunity of GREAT MEADOWS (009617-30)\nAdded unit 'E471' via 'X' at Tac  (009620-)\nTAC CHANNEL E ASSIGNED (009620-)\nUnit 'TW40' had changed quarters for unit 'TK40' (009620-)\n\nE172  TW40  E471  LAD39  \n\nHYDRANTS: 1810 VIEW TOP CT (0) & 1804 VIEW TOP CT (0)\nAREA CAUTION NOTES FOR 1715\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 11:58:45          DATE 07/29/13
(_subject_) INCIDENT 201342573\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n21 WATER ST-AN          \n\nGrid 20     Map J10     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 48 SHAW ST\n\nSecond cross street - 52 LARKIN ST\n\nNature: 26C01-ALTERED MENTAL STATUS\n\nCall back: 443-370-1017\n\nProQaA: 79 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: The caller is with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: She is not with it. (009617-30)\nProQaA: She is breathing normally. (009617-30)\nProQaA: She has other pain: (009617-30)\nProQaA: PAIN IN BED SORES (009617-30)\nProQaA: She is not bleeding (or vomiting blood). (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (009620-)\nUnit 'MU362' had changed quarters for unit 'MU36' (009620-)\nUnits 'on air': MU362 (009620-)\n\nE381  MU362  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 10:22:23          DATE 07/29/13
(_subject_) INCIDENT 201342569\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n105 ROSEWOOD ST          \n\nGrid 20     Map D10     Area 3529     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - OAKLAWN AVE\n\nSecond cross street - 36 HICKS AVE\n\nNature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\nProQaA: SOMETHING IN HIS EAR (000941-42)\nProQaA: 35 Year Old Man, Conscious, Breathing (000941-42)\nProQaA: - (000941-42)\nProQaA: This is a 1st party caller. (000941-42)\nProQaA: There is a single patient. (000941-42)\nProQaA: He is completely alert (responding appropriately). (000941-42)\nProQaA: He is breathing normally. (000941-42)\nProQaA: He has other pain: (000941-42)\nProQaA: FEELS SOMETHING INSIDE EAR (000941-42)\nProQaA: He is not bleeding (or vomiting blood). (000941-42)\nProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (000941-42)\nProQaA: No priority symptoms (OMEGA conditions 2-28 not identified). (000941-42)\nCommunity of ANNAPOLIS CITY (000941-42)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009620-)\nTAC CHANNEL B ASSIGNED (009620-)\n\nPM36  \n\nHYDRANTS:  () &  ()\n\nTIME 10:12:36          DATE 07/29/13
(_subject_) INCIDENT 201342567\n\nCODE SA     STILL ALARM     ALARM 1\n\n33 WEST ST          RAMS HEAD TAVERN FORDHAM BLDG\n\nGrid 20     Map J10     Area 3821     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - CATHEDRAL ST\n\nSecond cross street - 6 CHURCH CIR-AN\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: 410-268-4545\n\nCommunity of ANNAPOLIS CITY (001239-43)\nTAC CHANNEL E ASSIGNED (009620-)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\n\nTIME 09:53:54          DATE 07/29/13\n\rINCIDENT 201342567\n\nCODE SA     STILL ALARM     ALARM 1\n\n33 WEST ST          RAMS HEAD TAVERN FORDHAM BLDG\n\nGrid 20     Map J10     Area 3821     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - CATHEDRAL ST\n\nSecond cross street - 6 CHURCH CIR-AN\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: 410-268-4545\n\nCommunity of ANNAPOLIS CITY (001239-43)\nTAC CHANNEL E ASSIGNED (009620-)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\n\nTIME 09:53:54          DATE 07/29/13
(_subject_) INCIDENT 201342563\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n615 ADMIRAL DR     408     \n\nGrid 20     Map D07     Area 4032     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2024 HARBOUR GATES DR\n\nSecond cross street - 2058 OLD ADMIRAL CT\n\nNature: 17A02-FALL:NOT RECENT>6HRS\n\nCall back: 410-266-5322\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\nProQaA: FELL EARLIER, PAIN WORSE (000941-42)\nProQaA: 60 Year Old Man, Conscious, Breathing (000941-42)\nProQaA: - (000941-42)\nProQaA: The caller is with the patient. (000941-42)\nProQaA: There is a single patient. (000941-42)\nProQaA: This happened more than 6hrs ago. (000941-42)\nProQaA: It's reported that he fell at ground level. (000941-42)\nProQaA: The fall was accidental. (000941-42)\nProQaA: There is no bleeding now. (000941-42)\nProQaA: He is completely alert (responding appropriately). (000941-42)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (000941-42)\nProQaA: He is no longer on the floor (ground). (000941-42)\nCommunity of LINCOLN HEIGHTS (000941-42)\nTAC CHANNEL B ASSIGNED (009620-)\nUnits 'on air': E402, PM39 (009620-)\n\nE402  PM39  \n\nHYDRANTS: 616 ADMIRAL DR (0) & 608 ADMIRAL DR (1957)\n\nTIME 09:38:32          DATE 07/29/13
(_subject_) INCIDENT 201342554\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1881 BOWMAN CT          \n\nGrid 20     Map E09     Area 3514     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 1898 BOWMAN DR\n\nNature: 06D02-BREATHING PROB:TRBL SPEAKING\n\nCall back: 410-571-5725\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\nProQaA: TROUBLE BREATHING (000941-42)\nProQaA: 64 Year Old Woman, Conscious, Breathing (000941-42)\nProQaA: - (000941-42)\nProQaA: The caller is with the patient. (000941-42)\nProQaA: There is a single patient. (000941-42)\nProQaA: She is completely alert (responding appropriately). (000941-42)\nProQaA: She has difficulty speaking between breaths. (000941-42)\nCommunity of ANNAPOLIS CITY (000941-42)\nTAC CHANNEL B ASSIGNED (009620-)\nATRO Available 08:37:06 (009620-)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:36:06          DATE 07/29/13INCIDENT 201342554\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1881 BOWMAN CT          \n\nGrid 20     Map E09     Area 3514     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 1898 BOWMAN DR\n\nNature: 06D02-BREATHING PROB:TRBL SPEAKING\n\nCall back: 410-571-5725\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\nProQaA: TROUBLE BREATHING (000941-42)\nProQaA: 64 Year Old Woman, Conscious, Breathing (000941-42)\nProQaA: - (000941-42)\nProQaA: The caller is with the patient. (000941-42)\nProQaA: There is a single patient. (000941-42)\nProQaA: She is completely alert (responding appropriately). (000941-42)\nProQaA: She has difficulty speaking between breaths. (000941-42)\nCommunity of ANNAPOLIS CITY (000941-42)\nTAC CHANNEL B ASSIGNED (009620-)\nATRO Available 08:37:06 (009620-)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 08:36:06          DATE 07/29/13
(_subject_) INCIDENT 201342551\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n712 SYDNEY TER          \n\nGrid 19     Map G09     Area 4016     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 517 COOVER RD\n\nNature: 17D03-FALL:NOT ALERT\n\nCall back: 410-626-8053\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-43)\nProQaA: 87 Year Old Man, Conscious, Breathing (001239-43)\nProQaA: There is a single patient. (001239-43)\nProQaA: - (001239-43)\nProQaA: The caller is with the patient. (001239-43)\nProQaA: This happened now (less than 6hrs ago). (001239-43)\nProQaA: It's reported that he fell at ground level. (001239-43)\nProQaA: The reason for the fall is not known. (001239-43)\nProQaA: There is SERIOUS bleeding. (001239-43)\nProQaA: He is not completely alert (not responding appropriately). (001239-43)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (001239-43)\nCommunity of COOVER RD AREA COMMUNITY (001239-43)\nTAC CHANNEL B ASSIGNED (009620-)\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\n\nE402  MU40  PM35  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:\n\nTIME 07:59:00          DATE 07/29/13
(_subject_) INCIDENT 201342549\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n2000 FOREST DR-AN          \n\nGrid 20     Map D10     Area 3528     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 50 HICKS AVE\n\nSecond cross street - 2 BAUSUM DR\n\nNature: 00A2-MEDICAL SERVICE CALL (COLD)\n\nCommunity of ANNAPOLIS CITY (000557-30)\nTAC CHANNEL B ASSIGNED (009620-)\n\nE352  \n\nHYDRANTS: 2250 FOREST DR-AN (4490) &  ()\n\nKNOX BOX\nCODE FOR KEY BOX IS 19367\n19013\n\nTIME 07:40:17          DATE 07/29/13
(_subject_) INCIDENT 201342535\n\nCODE SA     STILL ALARM     ALARM 1\n\n4 DOCK ST     100     MULTI BUSINESS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: HL\n\nBUILDING (001252-42)\nCommunity of ANNAPOLIS CITY (001252-42)\nTAC CHANNEL B ASSIGNED (000557-30)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\nBUILDING IS SPRINKLERED.\n19265\nFDC LOCATED ON SIDE C.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:57:11          DATE 07/29/13\n\rINCIDENT 201342535\n\nCODE SA     STILL ALARM     ALARM 1\n\n4 DOCK ST     100     MULTI BUSINESS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\nCall back: HL\n\nBUILDING (001252-42)\nCommunity of ANNAPOLIS CITY (001252-42)\nTAC CHANNEL B ASSIGNED (000557-30)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\nBUILDING IS SPRINKLERED.\n19265\nFDC LOCATED ON SIDE C.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:57:11          DATE 07/29/13
(_subject_) INCIDENT 201342532\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\nWEST ST/CHURCH CIR-AN          \n\nGrid 20     Map J10     Area 3821     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 6 CHURCH CIR-AN\n\nNature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\nCommunity of ANNAPOLIS CITY (009611-35)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009617-)\nTAC CHANNEL B ASSIGNED (009617-)\n\nPM39  \n\nHYDRANTS:  (0) & 2087 WEST ST (0)\n\nTIME 01:19:01          DATE 07/29/13
(_subject_) INCIDENT 201342528\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n607 SEVERN ISLAND CT          \n\nGrid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - YAWL RD\n\nSecond cross street - YAWL RD\n\nNature: 23C01I-OVERDOSE:NOT ALERT/INTENTIONAL\n\nCall back: 202-230-3982\n\nProQaA: 41 Year Old Woman, Conscious, Breathing (009611-35)\nProQaA: - (009611-35)\nProQaA: The caller is with the patient. (009611-35)\nProQaA: There is a single patient. (009611-35)\nProQaA: She is out of it. (009611-35)\nProQaA: She is not acting right. (009611-35)\nProQaA: She is breathing normally. (009611-35)\nProQaA: She has chest pain. (009611-35)\nProQaA: It's not known if this was accidental or intentional. (009611-35)\nProQaA: She is not violent. (009611-35)\nProQaA: She is not changing color. (009611-35)\nProQaA: She has taken an unknown substance. (009611-35)\nProQaA: It's not known when she took it. (009611-35)\nProQaA: She took it now (less than 30 mins. ago). (009611-35)\nCommunity of ANNAPOLIS CITY (009611-35)\nTAC CHANNEL B ASSIGNED (000582-38)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 23:38:32          DATE 07/28/13INCIDENT 201342528\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n607 SEVERN ISLAND CT          \n\nGrid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - YAWL RD\n\nSecond cross street - YAWL RD\n\nNature: 23C01I-OVERDOSE:NOT ALERT/INTENTIONAL\n\nCall back: 202-230-3982\n\nProQaA: 41 Year Old Woman, Conscious, Breathing (009611-35)\nProQaA: - (009611-35)\nProQaA: The caller is with the patient. (009611-35)\nProQaA: There is a single patient. (009611-35)\nProQaA: She is out of it. (009611-35)\nProQaA: She is not acting right. (009611-35)\nProQaA: She is breathing normally. (009611-35)\nProQaA: She has chest pain. (009611-35)\nProQaA: It's not known if this was accidental or intentional. (009611-35)\nProQaA: She is not violent. (009611-35)\nProQaA: She is not changing color. (009611-35)\nProQaA: She has taken an unknown substance. (009611-35)\nProQaA: It's not known when she took it. (009611-35)\nProQaA: She took it now (less than 30 mins. ago). (009611-35)\nCommunity of ANNAPOLIS CITY (009611-35)\nTAC CHANNEL B ASSIGNED (000582-38)\n\nE352  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 23:38:32          DATE 07/28/13
(_subject_) INCIDENT 201342522\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n318 6TH ST-EP          FLEET FEET ANNAPOLIS\n\nGrid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 600 SEVERN AVE-EP\n\nSecond cross street - COMPROMISE ST\n\nNature: 31D02-UNCONSCIOUS:EFFECTIVE BREATH\n\nCall back: 410-570-4588\n\nVERIFY PD VERIFY FD VERIFY EMS (000557-30)\nProQaA: UNCONSCIOUS (000557-30)\nProQaA: Unknown age Male, Unconscious, Breathing (000557-30)\nProQaA: - (000557-30)\nProQaA: The caller is with the patient. (000557-30)\nProQaA: There is a single patient. (000557-30)\nProQaA: It's not known if his breathing is completely normal. (000557-30)\nProQaA: The caller is unable to assess the patient's breathing status. (000557-30)\nProQaA: The caller was asked if he is still unconscious. (000557-30)\nProQaA: He is still unconscious. (000557-30)\nCommunity of ANNAPOLIS CITY (000557-30)\nMAN LYING ON GROUND (000557-30)\nTAC CHANNEL B ASSIGNED (000897-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 22:40:46          DATE 07/28/13\n\rINCIDENT 201342522\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n318 6TH ST-EP          FLEET FEET ANNAPOLIS\n\nGrid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 600 SEVERN AVE-EP\n\nSecond cross street - COMPROMISE ST\n\nNature: 31D02-UNCONSCIOUS:EFFECTIVE BREATH\n\nCall back: 410-570-4588\n\nVERIFY PD VERIFY FD VERIFY EMS (000557-30)\nProQaA: UNCONSCIOUS (000557-30)\nProQaA: Unknown age Male, Unconscious, Breathing (000557-30)\nProQaA: - (000557-30)\nProQaA: The caller is with the patient. (000557-30)\nProQaA: There is a single patient. (000557-30)\nProQaA: It's not known if his breathing is completely normal. (000557-30)\nProQaA: The caller is unable to assess the patient's breathing status. (000557-30)\nProQaA: The caller was asked if he is still unconscious. (000557-30)\nProQaA: He is still unconscious. (000557-30)\nCommunity of ANNAPOLIS CITY (000557-30)\nMAN LYING ON GROUND (000557-30)\nTAC CHANNEL B ASSIGNED (000897-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 22:40:46          DATE 07/28/13
(_subject_) INCIDENT 201342502\n\nCODE B     BOX ASSIGNMENT     ALARM 1\n\n21 BEACON CT          \n\nGrid 25     Map G02     Area 3515     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21403\n\n\nSecond cross street -  HUNT MEADOW DR\n\nNature: F65D-DWELLING FIRE (HOT)\n\nCommunity of ANNAPOLIS CITY (001252-42)\nTAC CHANNEL E ASSIGNED (000897-39)\nUnit 'E84' had changed quarters for unit 'E81' (000897-39)\nUnit 'TW40' had changed quarters for unit 'TK40' (000897-39)\nUnits 'on air': BC35 (000897-39)\n\nE351  E84  E402  LAD39  TW40  SQ2  PM35  BC35  ANAC1  APD  \n\nHYDRANTS:  () &  ()\n\nTIME 20:29:38          DATE 07/28/13
(_subject_) INCIDENT 201342500\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n14 BRICIN ST     103     \n\nGrid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2 MELROB CT\n\nSecond cross street - 160 JANWALL ST\n\nNature: 13C03-DIABETIC PROB:ABNORM BREATH\n\nCall back: 410-263-5054\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-30)\nProQaA: DIABETIC (000557-30)\nProQaA: 79 Year Old Woman, Conscious, Breathing (000557-30)\nProQaA: - (000557-30)\nProQaA: This is a 1st party caller. (000557-30)\nProQaA: There is a single patient. (000557-30)\nProQaA: She is completely alert (responding appropriately). (000557-30)\nProQaA: She is behaving normally now. (000557-30)\nProQaA: She is not breathing normally. (000557-30)\nCommunity of ANNAPOLIS CITY (000557-30)\nTAC CHANNEL B ASSIGNED (000582-38)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nGAS AND ELECTRICAL SHUT-OFF IN FIRST FLOOR LAUNDRY ROOM.\n19195\nFIRE ALARM CONTROL PANEL IN FIRST FLOOR LAUNDRY ROOM.\n\nTIME 20:09:37          DATE 07/28/13\n\rINCIDENT 201342500\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n14 BRICIN ST     103     \n\nGrid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2 MELROB CT\n\nSecond cross street - 160 JANWALL ST\n\nNature: 13C03-DIABETIC PROB:ABNORM BREATH\n\nCall back: 410-263-5054\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-30)\nProQaA: DIABETIC (000557-30)\nProQaA: 79 Year Old Woman, Conscious, Breathing (000557-30)\nProQaA: - (000557-30)\nProQaA: This is a 1st party caller. (000557-30)\nProQaA: There is a single patient. (000557-30)\nProQaA: She is completely alert (responding appropriately). (000557-30)\nProQaA: She is behaving normally now. (000557-30)\nProQaA: She is not breathing normally. (000557-30)\nCommunity of ANNAPOLIS CITY (000557-30)\nTAC CHANNEL B ASSIGNED (000582-38)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nGAS AND ELECTRICAL SHUT-OFF IN FIRST FLOOR LAUNDRY ROOM.\n19195\nFIRE ALARM CONTROL PANEL IN FIRST FLOOR LAUNDRY ROOM.\n\nTIME 20:09:37          DATE 07/28/13
(_subject_) INCIDENT 201342496\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2012 WEST ST     B     LIGHTHOUSE WINE AND SPIRIT\n\nGrid 20     Map D09     Area 3529     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street -  GIBRALTER AVE\n\nSecond cross street - 2 HICKS AVE\n\nNature: 32B03-UNKNOWN MEDICAL EMERG\n\nCall back: 410-991-4073\n\nCommunity of ANNAPOLIS CITY (001252-42)\nTAC CHANNEL B ASSIGNED (000897-39)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:42:02          DATE 07/28/13INCIDENT 201342496\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n2012 WEST ST     B     LIGHTHOUSE WINE AND SPIRIT\n\nGrid 20     Map D09     Area 3529     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street -  GIBRALTER AVE\n\nSecond cross street - 2 HICKS AVE\n\nNature: 32B03-UNKNOWN MEDICAL EMERG\n\nCall back: 410-991-4073\n\nCommunity of ANNAPOLIS CITY (001252-42)\nTAC CHANNEL B ASSIGNED (000897-39)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:42:02          DATE 07/28/13
(_subject_) INCIDENT 201342464\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1609 CEDAR PARK RD          \n\nGrid 20     Map F09     Area 3812     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 FISKE CIR\n\nSecond cross street - 398 WINDELL AVE\n\nNature: 28C03F-STROKE:SPEECH PROB\n\nCall back: 410-267-0231\n\nVERIFY PD VERIFY FD VERIFY EMS (009614-42)\nProQaA: 91 Year Old Woman, Conscious, Breathing (009614-42)\nProQaA: Yes (009614-42)\nProQaA: - (009614-42)\nProQaA: The caller is with the patient. (009614-42)\nProQaA: There is a single patient. (009614-42)\nProQaA: She is completely alert (responding appropriately). (009614-42)\nProQaA: She is breathing normally. (009614-42)\nProQaA: She is having sudden speech problems. (009614-42)\nProQaA: The Stroke Diagnostic results indicate strong evidence of (009614-42)\nProQaA: stroke. (009614-42)\nProQaA: These symptoms (problem) started: (009614-42)\nProQaA: 2 HRS AGO (009614-42)\nProQaA: She has not had a STROKE before. (009614-42)\nCommunity of ANNAPOLIS CITY (009614-42)\nTAC CHANNEL B ASSIGNED (000777-38)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 15:26:00          DATE 07/28/13\n\rINCIDENT 201342464\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1609 CEDAR PARK RD          \n\nGrid 20     Map F09     Area 3812     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 FISKE CIR\n\nSecond cross street - 398 WINDELL AVE\n\nNature: 28C03F-STROKE:SPEECH PROB\n\nCall back: 410-267-0231\n\nVERIFY PD VERIFY FD VERIFY EMS (009614-42)\nProQaA: 91 Year Old Woman, Conscious, Breathing (009614-42)\nProQaA: Yes (009614-42)\nProQaA: - (009614-42)\nProQaA: The caller is with the patient. (009614-42)\nProQaA: There is a single patient. (009614-42)\nProQaA: She is completely alert (responding appropriately). (009614-42)\nProQaA: She is breathing normally. (009614-42)\nProQaA: She is having sudden speech problems. (009614-42)\nProQaA: The Stroke Diagnostic results indicate strong evidence of (009614-42)\nProQaA: stroke. (009614-42)\nProQaA: These symptoms (problem) started: (009614-42)\nProQaA: 2 HRS AGO (009614-42)\nProQaA: She has not had a STROKE before. (009614-42)\nCommunity of ANNAPOLIS CITY (009614-42)\nTAC CHANNEL B ASSIGNED (000777-38)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 15:26:00          DATE 07/28/13
(_subject_) INCIDENT 201342449\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\nCHINQUAPIN ROUND RD/GEORGE AVE-AN          \n\nGrid 20     Map E10     Area 3527     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 1898 GEORGE AVE-AN\n\nSecond cross street - 1900 MARGARET AVE-AN\n\nNature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\nCall back: 410-212-7445\n\n2 (009614-42)\nCommunity of ANNAPOLIS CITY (009614-42)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE351  PM39  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 13:51:59          DATE 07/28/13\n\rINCIDENT 201342449\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\nCHINQUAPIN ROUND RD/GEORGE AVE-AN          \n\nGrid 20     Map E10     Area 3527     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 1898 GEORGE AVE-AN\n\nSecond cross street - 1900 MARGARET AVE-AN\n\nNature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\nCall back: 410-212-7445\n\n2 (009614-42)\nCommunity of ANNAPOLIS CITY (009614-42)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE351  PM39  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 13:51:59          DATE 07/28/13
(_subject_) INCIDENT 201342441\n\nCODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\nDEFENSE HWY-AN/RT50 E          \n\nGrid 20     Map B09     Area 4024     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street -  JOHN HANSON HWY E-AN\n\nNature: 29B04-MVC:UNKNOWN STATUS\n\nCommunity of ANNAPOLIS RESTAURANT PARK (009614-42)\nTAC CHANNEL B ASSIGNED (001488-)\nUnit 'TW40' had changed quarters for unit 'TK40' (001488-)\n\nTW40  PM35  \n\nHYDRANTS: 100 DEFENSE HWY-AN (0) & 116 DEFENSE HWY-AN (0)\n\nTIME 13:15:40          DATE 07/28/13
(_subject_) INCIDENT 201342433\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n21 WATER ST-AN          \n\nGrid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 48 SHAW ST\n\nSecond cross street - 52 LARKIN ST\n\nNature: 26A10-SICK PERSON:FEELING ILL\n\nCall back: 443-370-1017\n\nVERIFY PD VERIFY FD VERIFY EMS (000781-30)\nProQaA: 79 Year Old Woman, Conscious, Breathing (000781-30)\nProQaA: - (000781-30)\nProQaA: The caller is with the patient. (000781-30)\nProQaA: There is a single patient. (000781-30)\nProQaA: She is completely alert (responding appropriately). (000781-30)\nProQaA: She is breathing normally. (000781-30)\nProQaA: It's not known if she has any pain. (000781-30)\nProQaA: She is not bleeding (or vomiting blood). (000781-30)\nProQaA: She is unwell/ill. (000781-30)\nCommunity of ANNAPOLIS CITY (000781-30)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (001488-)\nTAC CHANNEL B ASSIGNED (001488-)\nUnits 'on air': MU39 (001488-)\n\nMU39  \n\nHYDRANTS:  () &  ()\n\nTIME 12:47:14          DATE 07/28/13
(_subject_) INCIDENT 201342428\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n74 OLD MILL BOTTOM RD N     208     SUPER 8 MOTEL\n\nGrid 21     Map B02     Area 1710     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip \n\nFirst cross street - 1400 BRETTON VIEW RD\n\nSecond cross street - 1400 BRENWOODE RD\n\nNature: 32B03-UNKNOWN MEDICAL EMERG\n\nCommunity of ROUTE 50 BETWEEN ROUTE 648 AND (001488-39)\nTAC CHANNEL B ASSIGNED (001488-)\n\nE171  MU39  \n\nHYDRANTS: 30 OLD MILL BOTTOM RD N (1284) & 34 OLD MILL BOTTOM RD N (1284)\n\nCAUTION NOTES\nAREA CAUTION NOTES FOR 1710\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\nTIME 12:17:21          DATE 07/28/13
(_subject_) INCIDENT 201342427\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n140 GEORGETOWN RD     2     \n\nGrid 26     Map A01     Area 3604     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2 SILVERWOOD CIR\n\nSecond cross street - 2 SILVERWOOD CIR\n\nNature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\nCall back: 443-995-5090\n\nCommunity of ANNAPOLIS CITY (009614-42)\nTAC CHANNEL E ASSIGNED (001488-)\nUnit 'E84' had changed quarters for unit 'E81' (001488-)\nUnit 'TW40' had changed quarters for unit 'TK40' (001488-)\n\nE84  E361  E351  LAD39  TW40  SQ38  PM36  BC35  ANAC1  APD  \n\nHYDRANTS:  () &  ()\n\nTIME 12:06:34          DATE 07/28/13
(_subject_) INCIDENT 201342401\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n816 BESTGATE RD          FOWLERS UNITED METH CHURCH\n\nGrid 20     Map C07     Area 4027     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2200 FOWLERS DR\n\nSecond cross street - 2000 GATE DR\n\nNature: 09D01-CARDIAC ARREST:INEF BREATHING\n\nCall back: 410-224-2149\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-42)\nProQaA: 50 Year Old Man, Unconscious, Uncertain if Breathing (009614-42)\nProQaA: - (009614-42)\nProQaA: The caller is with the patient. (009614-42)\nProQaA: There is a single patient. (009614-42)\nProQaA: The cardiac arrest was witnessed. (009614-42)\nProQaA: A defibrillator (AED) is not available. (009614-42)\nCommunity of BESTGATE TERRACE (009614-42)\nTAC CHANNEL B ASSIGNED (001488-)\nUnit 'TW40' had changed quarters for unit 'TK40' (001488-)\nUnits 'on air': TW40 (001488-)\nUNIT TW40 IS RESPONDING WITHOUT OFFICER\nFrom TW40: PERSONS RESPONDING 3\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 2\n\nE402  MU3  MU39  TW40  EMS36  \n\nHYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)\n\nTIME 09:16:51          DATE 07/28/13
(_subject_) INCIDENT 201342401\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n816 BESTGATE RD          FOWLERS UNITED METH CHURCH\n\nGrid 20     Map C07     Area 4027     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2200 FOWLERS DR\n\nSecond cross street - 2000 GATE DR\n\nNature: 09D01-CARDIAC ARREST:INEF BREATHING\n\nCall back: 410-224-2149\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-42)\nProQaA: 50 Year Old Man, Unconscious, Uncertain if Breathing (009614-42)\nProQaA: - (009614-42)\nProQaA: The caller is with the patient. (009614-42)\nProQaA: There is a single patient. (009614-42)\nProQaA: The cardiac arrest was witnessed. (009614-42)\nProQaA: A defibrillator (AED) is not available. (009614-42)\nCommunity of BESTGATE TERRACE (009614-42)\nTAC CHANNEL B ASSIGNED (001488-)\n\nE402  MU3  MU39  \n\nHYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)\n\nTIME 09:16:51          DATE 07/28/13
(_subject_) INCIDENT 201342400\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n2178 CHESAPEAKE HARBOUR DR E          \n\nGrid 21     Map C13     Area 0836     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2156 SAND CASTLE DR\n\nSecond cross street - 2151 SAND CASTLE CT\n\nNature: 01A01-ABDOMINAL PAIN\n\nCall back: 410-280-1826\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000781-30)\nProQaA: 70 Year Old Woman, Conscious, Breathing (000781-30)\nProQaA: - (000781-30)\nProQaA: This is a 1st party caller. (000781-30)\nProQaA: There is a single patient. (000781-30)\nProQaA: She is completely alert (responding appropriately). (000781-30)\nProQaA: The pain is described as: (000781-30)\nProQaA: There was no mention of aortic aneurysm or a tearing or (000781-30)\nProQaA: ripping pain in the back or flank and abdomen. (000781-30)\nProQaA: She has not fainted or nearly fainted. (000781-30)\nProQaA: She does not have pain above the belly button (navel). (000781-30)\nCommunity of ANNAPOLIS ROADS (000781-30)\nTAC CHANNEL B ASSIGNED (001488-)\nUnits 'on air': MU362 (001488-)\n\nMU362  \n\nHYDRANTS:  () &  ()\n\nTIME 09:13:45          DATE 07/28/13
(_subject_) INCIDENT 201342391\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n511 ROYAL ST          \n\nGrid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - SCHOONER CT\n\nNature: 10C04-CHEST PAIN:NORMAL RESP >35\n\nCall back: 410-295-1596\n\nVERIFY PD VERIFY FD VERIFY EMS (000781-30)\nProQaA: 52 Year Old Woman, Conscious, Breathing (000781-30)\nProQaA: - (000781-30)\nProQaA: The caller is with the patient. (000781-30)\nProQaA: There is a single patient. (000781-30)\nProQaA: This started (happened) more than 6hrs ago. (000781-30)\nProQaA: Her back pain was caused by another, non-specified condition. (000781-30)\nProQaA: She is not having difficulty breathing. (000781-30)\nProQaA: She has chest pain. (000781-30)\nProQaA: She is completely alert (responding appropriately). (000781-30)\nProQaA: She is breathing normally. (000781-30)\nProQaA: She is not changing color. (000781-30)\nProQaA: She is not clammy. (000781-30)\nProQaA: She has not had a heart attack or angina (heart pains) before. (000781-30)\nProQaA: She took a prescribed medication in the past 12hrs: (000781-30)\nProQaA: TYLENOL (000781-30)\nCommunity of ANNAPOLIS CITY (000781-30)\nTAC CHANNEL B ASSIGNED (001488-)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 07:38:40          DATE 07/28/13\nHOSPITAL STATUS   07/28/13   07:40:48\n\nJOHN HOPKINS HO    REROUTEINCIDENT 201342391\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n511 ROYAL ST          \n\nGrid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - SCHOONER CT\n\nNature: 10C04-CHEST PAIN:NORMAL RESP >35\n\nCall back: 410-295-1596\n\nVERIFY PD VERIFY FD VERIFY EMS (000781-30)\nProQaA: 52 Year Old Woman, Conscious, Breathing (000781-30)\nProQaA: - (000781-30)\nProQaA: The caller is with the patient. (000781-30)\nProQaA: There is a single patient. (000781-30)\nProQaA: This started (happened) more than 6hrs ago. (000781-30)\nProQaA: Her back pain was caused by another, non-specified condition. (000781-30)\nProQaA: She is not having difficulty breathing. (000781-30)\nProQaA: She has chest pain. (000781-30)\nProQaA: She is completely alert (responding appropriately). (000781-30)\nProQaA: She is breathing normally. (000781-30)\nProQaA: She is not changing color. (000781-30)\nProQaA: She is not clammy. (000781-30)\nProQaA: She has not had a heart attack or angina (heart pains) before. (000781-30)\nProQaA: She took a prescribed medication in the past 12hrs: (000781-30)\nProQaA: TYLENOL (000781-30)\nCommunity of ANNAPOLIS CITY (000781-30)\nTAC CHANNEL B ASSIGNED (001488-)\n\nE351  PM35  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 07:38:40          DATE 07/28/13\nHOSPITAL STATUS   07/28/13   07:40:48\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342386\n\nCODE BTP     ASSIST WITH SUSPICIOUS PACKAGE     ALARM 1\n\n4211 MOUNTAIN RD-PA     GAS     SAFEWAY\n\nGrid 09     Map G10     Area 1004     Preplan      Channel K    MOA 1\n\nCensus Tract      Zip 21122\n\nFirst cross street - 4200 POSTAL CT\n\nSecond cross street - 2 MAGOTHY BEACH RD\n\nNature: F84A-ASSIST WITH SUSP. PKG. (HOT)\n\nCall back: 410-439-4560\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009624-42)\nCommunity of LAKE SHORE CENTER (009624-42)\nTAC CHANNEL B ASSIGNED (009611-39)\nUnits 'on air': FM865 (009611-39)\nAAPD Available 06:20:44 (009611-39)\nSCA Available 06:21:06 (001252-)\nUNIT FM860 IS RESPONDING WITH OFFICER\nUNIT FM865 IS RESPONDING WITHOUT OFFICER\nOPS3 Available 06:22:53 (000579-)\nPIO5 Available 06:22:57 (000579-)\nBC2 Available 06:23:02 (000579-)\nUNIT E101 IS RESPONDING WITH OFFICER\nFrom E101: PERSONS RESPONDING 2\nTactical channel changed from B to K (001488-)\n\nE101  BC2  FM860  PIO5  OPS3  AAPD  SCA  FM865  ESU35  \n\nHYDRANTS: 4302 MOUNTAIN RD-PA (9205) & 4105 MOUNTAIN RD-PA (0)\nAREA CAUTION NOTES FOR 1004\nCLOSEST HOSPITALS:  1)  NAH  (2)  AAMC  (3)  HHC\n\nTIME 06:18:09          DATE 07/28/13\nHOSPITAL STATUS   07/28/13   06:45:04\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342380\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n900 VAN BUREN ST     23B     NEW ANNAPOLIS NURSING & REHAB\n\nGrid 20     Map K13     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1298 BAY RIDGE AVE\n\nNature: 17B01-FALL:POSSIBLY DANGEROUS\n\nCall back: 410-268-2124\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\nProQaA: FALL (001239-30)\nProQaA: 86 Year Old Man, Conscious, Breathing (001239-30)\nProQaA: The caller is not with the patient. (001239-30)\nProQaA: There is a single patient. (001239-30)\nProQaA: This happened now (less than 6hrs ago). (001239-30)\nProQaA: It's reported that he fell at ground level. (001239-30)\nProQaA: The fall was accidental. (001239-30)\nProQaA: There is no bleeding now. (001239-30)\nProQaA: The reason for the fall is not known. (001239-30)\nProQaA: He is completely alert (responding appropriately). (001239-30)\nProQaA: The injury is to a POSSIBLY DANGEROUS area. (001239-30)\nProQaA: He is no longer on the floor (ground). (001239-30)\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL B ASSIGNED (000579-)\n\nMU36  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nFULLY SPRINKLERED.\n19261\nFDC LOCATED ON SIDE 1.\nMAIN VALVE LOCATED IN BASEMENT, IN CORNER OF LAUNDRY ROOM.\n\nTIME 04:45:57          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   04:47:54\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342379\n\nCODE CB     COMMERCIAL BOX     ALARM 1\n\n140 GEORGETOWN RD          \n\nGrid 26     Map A01     Area 3604     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 2 SILVERWOOD CIR\n\nSecond cross street - 2 SILVERWOOD CIR\n\nNature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\nCall back: 443-949-9336\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL E ASSIGNED (000579-)\nUnit 'E84' had changed quarters for unit 'E81' (000579-)\nUnit 'TW40' had changed quarters for unit 'TK40' (000579-)\n\nE84  E361  E351  LAD39  TW40  SQ38  MU8  BC35  ANAC1  APD  \n\nHYDRANTS:  () &  ()\n\nTIME 04:15:08          DATE 07/28/13
(_subject_) INCIDENT 201342376\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1103 SMITHVILLE ST     128     WILEY BATES SENIOR HOUSING\n\nGrid 20     Map G10     Area 3825     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 S VILLA AVE\n\nSecond cross street - 98 JOHNSON PL\n\nNature: 28C03U-STROKE:SPEECH PROB\n\nCall back: 410-263-0397\n\nProQaA: 72 Year Old Man, Conscious, Breathing (001252-35)\nProQaA: Yes (001252-35)\nProQaA: - (001252-35)\nProQaA: This is a 4th party caller. (001252-35)\nProQaA: There is a single patient. (001252-35)\nProQaA: He is completely alert (responding appropriately). (001252-35)\nProQaA: It's not known if he is breathing normally. (001252-35)\nProQaA: He is having sudden speech problems. (001252-35)\nProQaA: It's not known when this started. (001252-35)\nProQaA: He has not had a STROKE before. (001252-35)\nCommunity of ANNAPOLIS CITY (001252-35)\nTAC CHANNEL B ASSIGNED (000579-)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nKNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n19286\nTHERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\nTIME 03:01:25          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   03:03:18\n\nJOHN HOPKINS HO    REROUTE\n\n\rINCIDENT 201342376\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1103 SMITHVILLE ST     128     WILEY BATES SENIOR HOUSING\n\nGrid 20     Map G10     Area 3825     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 S VILLA AVE\n\nSecond cross street - 98 JOHNSON PL\n\nNature: 28C03U-STROKE:SPEECH PROB\n\nCall back: 410-263-0397\n\nProQaA: 72 Year Old Man, Conscious, Breathing (001252-35)\nProQaA: Yes (001252-35)\nProQaA: - (001252-35)\nProQaA: This is a 4th party caller. (001252-35)\nProQaA: There is a single patient. (001252-35)\nProQaA: He is completely alert (responding appropriately). (001252-35)\nProQaA: It's not known if he is breathing normally. (001252-35)\nProQaA: He is having sudden speech problems. (001252-35)\nProQaA: It's not known when this started. (001252-35)\nProQaA: He has not had a STROKE before. (001252-35)\nCommunity of ANNAPOLIS CITY (001252-35)\nTAC CHANNEL B ASSIGNED (000579-)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nKNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n19286\nTHERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\nTIME 03:01:25          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   03:03:18\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342371\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 GREEN ST\n\nSecond cross street - 98 RANDALL ST\n\nNature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\nCall back: 443-975-4212\n\nPROQA ABORTED\nCommunity of ANNAPOLIS CITY (009611-39)\nTAC CHANNEL B ASSIGNED (009611-39)\n\nE381  MU39  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:01:47          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   02:04:54\n\nJOHN HOPKINS HO    REROUTE\n\n\rINCIDENT 201342371\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 GREEN ST\n\nSecond cross street - 98 RANDALL ST\n\nNature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\nCall back: 443-975-4212\n\nPROQA ABORTED\nCommunity of ANNAPOLIS CITY (009611-39)\nTAC CHANNEL B ASSIGNED (009611-39)\n\nE381  MU39  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:01:47          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   02:04:54\n\nJOHN HOPKINS HO    REROUTE\n\n\rINCIDENT 201342371\n\nCODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 198 GREEN ST\n\nSecond cross street - 98 RANDALL ST\n\nNature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\nCall back: 443-975-4212\n\nPROQA ABORTED\nCommunity of ANNAPOLIS CITY (009611-39)\nTAC CHANNEL B ASSIGNED (009611-39)\n\nE381  MU39  EMS36  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:01:47          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   02:04:54\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342369\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n1148 MEDGAR EVERS ST          \n\nGrid 20     Map K12     Area 3602     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street - 1176 FREDERICK DOUGLASS ST\n\nNature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\nCall back: 443-924-3266\n\nProQaA: 37 Year Old Woman, Conscious, Breathing (009624-42)\nProQaA: - (009624-42)\nProQaA: This is a 1st party caller. (009624-42)\nProQaA: There is a single patient. (009624-42)\nProQaA: She is completely alert (responding appropriately). (009624-42)\nProQaA: She is breathing normally. (009624-42)\nProQaA: She has other pain: (009624-42)\nProQaA: NECK (009624-42)\nProQaA: She is not bleeding (or vomiting blood). (009624-42)\nProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (009624-42)\nProQaA: No priority symptoms (OMEGA conditions 2-28 not identified). (009624-42)\nCommunity of ANNAPOLIS CITY (009624-42)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009611-39)\nTAC CHANNEL B ASSIGNED (009611-39)\n\nMU36  \n\nHYDRANTS:  () &  ()\n\nTIME 01:50:53          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   01:53:17\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342366\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n17 BENS DR     E     \n\nGrid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1 MARCS CT\n\nSecond cross street - 1 MARCS CT\n\nNature: 12A01E-SEIZURES:BREATHING VERIFIED\n\nCall back: 410-268-1247\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009611-39)\nProQaA: 6 Year Old Girl, Conscious, Breathing (009611-39)\nProQaA: - (009611-39)\nProQaA: The caller is with the patient. (009611-39)\nProQaA: There is a single patient. (009611-39)\nProQaA: This is apparently a generalized (grand mal) seizure. (009611-39)\nProQaA: She has not had more than one seizure in a row. (009611-39)\nProQaA: She is not diabetic. (009611-39)\nProQaA: She is an epileptic (diagnosed with a seizure disorder). (009611-39)\nProQaA: She does not have a history of STROKE or brain tumor. (009611-39)\nProQaA: The jerking (twitching) has stopped. (009611-39)\nProQaA: She is breathing now. (009611-39)\nProQaA: Rate  =  18 breaths per minute (009611-39)\nProQaA: Normal or Abnormal* (009611-39)\nProQaA: She is breathing normally. (009611-39)\nCommunity of ANNAPOLIS CITY (009611-39)\nTAC CHANNEL B ASSIGNED (000579-)\n\nE361  MU8  ATRO  \n\nHYDRANTS:  () &  ()\nKNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n17429\nPROTECTED BY A 13R SPRINKLER SYSTEM.\n19044\nSINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\nCONTROL VALVE LOCATED BEHIND THE FDC.\n\nTIME 00:22:03          DATE 07/28/13\n\r\nHOSPITAL STATUS   07/28/13   00:25:41\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342345\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n1 DOCK ST     1     CITY DOCK\n\nGrid 21     Map A10     Area 3824A     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: 17A01-FALL:NOT DANGEROUS\n\nCall back: 410-263-7973\n\nProQaA: 40 Year Old Man, Conscious, Breathing (009624-42)\nProQaA: - (009624-42)\nProQaA: The caller is with the patient. (009624-42)\nProQaA: There is a single patient. (009624-42)\nProQaA: This happened now (less than 6hrs ago). (009624-42)\nProQaA: It's reported that he fell at ground level. (009624-42)\nProQaA: The fall was accidental. (009624-42)\nProQaA: There is no bleeding now. (009624-42)\nProQaA: He is completely alert (responding appropriately). (009624-42)\nProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\nProQaA: He is no longer on the floor (ground). (009624-42)\nCommunity of ANNAPOLIS CITY (009624-42)\nTAC CHANNEL B ASSIGNED (009617-)\nCall back number changed in ProQA from 8607161012 (009624-42)\n\nMU39  E381  \n\nHYDRANTS:  () &  ()\n\nTIME 21:56:43          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   22:00:37\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342345\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n1 DOCK ST     1     CITY DOCK\n\nGrid 21     Map A10     Area 3824A     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: 17A01-FALL:NOT DANGEROUS\n\nCall back: 860-716-1012\n\nProQaA: 40 Year Old Man, Conscious, Breathing (009624-42)\nProQaA: - (009624-42)\nProQaA: The caller is with the patient. (009624-42)\nProQaA: There is a single patient. (009624-42)\nProQaA: This happened now (less than 6hrs ago). (009624-42)\nProQaA: It's reported that he fell at ground level. (009624-42)\nProQaA: The fall was accidental. (009624-42)\nProQaA: There is no bleeding now. (009624-42)\nProQaA: He is completely alert (responding appropriately). (009624-42)\nProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\nProQaA: He is no longer on the floor (ground). (009624-42)\nCommunity of ANNAPOLIS CITY (009624-42)\nTAC CHANNEL B ASSIGNED (009617-)\n\nMU39  \n\nHYDRANTS:  () &  ()\n\nTIME 21:56:43          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   21:58:46\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342322\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n19 BENS DR     A     \n\nGrid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1 MARCS CT\n\nSecond cross street - 1 MARCS CT\n\nNature: 21B02-HEMORRHAGE/LAC:SERIOUS BLEED\n\nCall back: 410-268-1859\n\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\nProQaA: BLEEDING (001239-30)\nProQaA: 29 Year Old Woman, Conscious, Breathing (001239-30)\nProQaA: - (001239-30)\nProQaA: The caller is with the patient. (001239-30)\nProQaA: There is a single patient. (001239-30)\nProQaA: The cause of the bleeding is non-traumatic. (001239-30)\nProQaA: The bleeding is from a NOT DANGEROUS area. (001239-30)\nProQaA: She is completely alert (responding appropriately). (001239-30)\nProQaA: She is breathing normally. (001239-30)\nProQaA: There is SERIOUS bleeding. (001239-30)\nProQaA: She does not have a bleeding disorder or is taking blood (001239-30)\nProQaA: thinners. (001239-30)\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL B ASSIGNED (009617-)\n\nMU36  \n\nHYDRANTS:  () &  ()\nKNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n17429\nPROTECTED BY A 13R SPRINKLER SYSTEM.\n19044\nSINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\nCONTROL VALVE LOCATED BEHIND THE FDC.\n\nTIME 20:04:23          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   20:06:03\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342321\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n97 CLAY ST          \n\nGrid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 BREWER ST\n\nSecond cross street - 60 PLEASANT ST-AN\n\nNature: 10D04-CHEST PAIN:CLAMMY\n\nCall back: 443-481-8536\n\nProQaA: 57 Year Old Woman, Conscious, Breathing (009624-)\nProQaA: - (009624-)\nProQaA: The caller is with the patient. (009624-)\nProQaA: There is a single patient. (009624-)\nProQaA: She is completely alert (responding appropriately). (009624-)\nProQaA: She is breathing normally. (009624-)\nProQaA: She is not breathing normally. (009624-)\nProQaA: She does not have any difficulty speaking between breaths. (009624-)\nProQaA: She is not changing color. (009624-)\nProQaA: She is clammy. (009624-)\nCommunity of ANNAPOLIS CITY (009624-)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:53:47          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   19:55:17\n\nJOHN HOPKINS HO    REROUTE\n\n\rINCIDENT 201342321\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n97 CLAY ST          \n\nGrid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 BREWER ST\n\nSecond cross street - 60 PLEASANT ST-AN\n\nNature: 10D04-CHEST PAIN:CLAMMY\n\nCall back: 443-481-8536\n\nProQaA: 57 Year Old Woman, Conscious, Breathing (009624-)\nProQaA: - (009624-)\nProQaA: The caller is with the patient. (009624-)\nProQaA: There is a single patient. (009624-)\nProQaA: She is completely alert (responding appropriately). (009624-)\nProQaA: She is breathing normally. (009624-)\nProQaA: She is not breathing normally. (009624-)\nProQaA: She does not have any difficulty speaking between breaths. (009624-)\nProQaA: She is not changing color. (009624-)\nProQaA: She is clammy. (009624-)\nCommunity of ANNAPOLIS CITY (009624-)\nTAC CHANNEL B ASSIGNED (009617-)\n\nE381  MU39  ATRO  \n\nHYDRANTS:  () &  ()\n\nTIME 19:53:47          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   19:55:17\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342314\n\nCODE WRO     DROWNING OPEN WATER     ALARM 2\n\nBAY FRONT AVE/MYRTLE AVE-NB          \n\nGrid 36     Map E03     Area 4237     Preplan      Channel L    MOA 1\n\nCensus Tract      Zip 20714\n\nFirst cross street - 7000 MYRTLE AVE-NB\n\nSecond cross street - 7000 PALMETTO AVE\n\nNature: R39O-DROWNING OPEN WATER (HOT)\n\nCommunity of NORTH BEACH PARK (000579-)\nTAC CHANNEL L ASSIGNED (009617-)\nUnit 'FB60' had changed quarters for unit 'FB19' (009617-)\n\nFB60  FB41  CSQ5  E421  PM9  CTW1  FB36  U23  DU8  BC3  SCMD  USCG  DNR  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 4237\nSTAGING AREA FOR W/R: LAKESHORE DR & WALNUT AVE\nBOAT RAMP:(BOX 4217, HERRINGTON HARBOUR NORTH,RT256 & TRACY CK\n(Small sand beach at herrington harbour south can be used but\n4 wheel drive vehicles ( must be used )\nLZ:\n\nTIME 18:48:56          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   18:50:24\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342307\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n8 MILLHAVEN CT          \n\nGrid 24     Map J04     Area 0222     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21037\n\nFirst cross street - 2110 MILLHAVEN DR\n\nSecond cross street - 2110 MILLHAVEN DR\n\nNature: 03A03-ANIMAL BITE:SUPERFICIAL BITE\n\nCall back: 410-956-3267\n\nProQaA: 2 Year Old Boy, Conscious, Breathing (009624-42)\nProQaA: - (009624-42)\nProQaA: The caller is with the patient. (009624-42)\nProQaA: There is a single patient. (009624-42)\nProQaA: This happened now (less than 6hrs ago). (009624-42)\nProQaA: He was bitten/injured by a dog. (009624-42)\nProQaA: The animal has been locked up or captured. (009624-42)\nProQaA: There is some bleeding, not serious. (009624-42)\nProQaA: He is completely alert (responding appropriately). (009624-42)\nProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\nProQaA: He has a superficial bite. (009624-42)\nCommunity of RIVER OAKS (009624-42)\nTAC CHANNEL B ASSIGNED (000579-)\nUnit 'ME2' had changed quarters for unit 'E21' (000579-)\n\nME2  PM35  \n\nHYDRANTS: 12 MILLHAVEN CT (2638) & 36 MILLHAVEN CT (0)\nAREA CAUTION NOTES FOR 0222\nSTAGING AREA FOR W/R: EDGEWATER ELEMENTARY\nBOAT RAMP: RIVERSIDE RD AND PARK RD\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\nTIME 17:57:14          DATE 07/27/13\nHOSPITAL STATUS   07/27/13   17:59:48\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342305\n\nCODE WRL     WATER RESCUE LOCAL     ALARM 1\n\nE LAKE DR-AN/SANDS AVE          \n\nGrid 26     Map E03     Area 0819     Preplan      Channel K    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 12 SANDS AVE\n\nNature: R13-BOAT ACCIDENT (HOT)\n\nCommunity of BAY RIDGE (009624-42)\nTAC CHANNEL K ASSIGNED (000579-)\nUnit 'E84' had changed quarters for unit 'E81' (000579-)\n\nE84  FB36  FB41  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 0819\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\nTIME 17:51:52          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   17:53:50\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342301\n\nCODE SA     STILL ALARM     ALARM 1\n\n4 DOCK ST          MULTI BUSINESS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: F05W-ALARM: WATER FLOW (WARM)\n\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL E ASSIGNED (000579-)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 17:17:42          DATE 07/27/13\n\rINCIDENT 201342301\n\nCODE SA     STILL ALARM     ALARM 1\n\n4 DOCK ST          MULTI BUSINESS\n\nGrid 21     Map A10     Area 3824     Preplan      Channel E    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 98 CRAIG ST-AN\n\nNature: F05W-ALARM: WATER FLOW (WARM)\n\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL E ASSIGNED (000579-)\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 17:17:42          DATE 07/27/13
(_subject_) INCIDENT 201342264\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n48 FLEET ST          \n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 88 EAST ST\n\nSecond cross street - 2 CORNHILL ST\n\nNature: 28C01C-STROKE: NOT ALERT\n\nProQaA: 104 Year Old Woman, Unconscious, Breathing (001488-42)\nProQaA: There is a single patient. (001488-42)\nProQaA: Yes (001488-42)\nProQaA: - (001488-42)\nProQaA: The caller is with the patient. (001488-42)\nProQaA: She is breathing normally. (001488-42)\nProQaA: She is having sudden paralysis or facial droop on one side of (001488-42)\nProQaA: the body. (001488-42)\nProQaA: The Stroke Diagnostic results indicate partial evidence of (001488-42)\nProQaA: stroke. (001488-42)\nProQaA: These symptoms (problem) started: (001488-42)\nProQaA: 15 MINS (001488-42)\nProQaA: It's not known if she has had a STROKE before. (001488-42)\nCommunity of ANNAPOLIS CITY (001488-42)\nTAC CHANNEL B ASSIGNED (000781-39)\nUnits 'on air': E381 (000781-39)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 14:24:49          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   14:27:44\n\nJOHN HOPKINS HO    REROUTE\n\n\rINCIDENT 201342264\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n48 FLEET ST          \n\nGrid 20     Map K10     Area 3824     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 88 EAST ST\n\nSecond cross street - 2 CORNHILL ST\n\nNature: 28C01C-STROKE: NOT ALERT\n\nProQaA: 104 Year Old Woman, Unconscious, Breathing (001488-42)\nProQaA: There is a single patient. (001488-42)\nProQaA: Yes (001488-42)\nProQaA: - (001488-42)\nProQaA: The caller is with the patient. (001488-42)\nProQaA: She is breathing normally. (001488-42)\nProQaA: She is having sudden paralysis or facial droop on one side of (001488-42)\nProQaA: the body. (001488-42)\nProQaA: The Stroke Diagnostic results indicate partial evidence of (001488-42)\nProQaA: stroke. (001488-42)\nProQaA: These symptoms (problem) started: (001488-42)\nProQaA: 15 MINS (001488-42)\nProQaA: It's not known if she has had a STROKE before. (001488-42)\nCommunity of ANNAPOLIS CITY (001488-42)\nTAC CHANNEL B ASSIGNED (000781-39)\nUnits 'on air': E381 (000781-39)\n\nE381  PM39  ATRO  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 14:24:49          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   14:27:44\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342254\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n1507 WEST ST     A     \n\nGrid 20     Map F10     Area 3527     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 S HOMELAND AVE\n\nSecond cross street - 2 N SOUTHWOOD AVE\n\nNature: 25B03-PSYCH EMER:THREATENING SUICIDE\n\nCall back: 443-333-0761\n\nProQaA: 44 Year Old Man, Conscious, Breathing (001239-30)\nProQaA: There is a single patient. (001239-30)\nProQaA: - (001239-30)\nProQaA: This is a 1st party caller. (001239-30)\nProQaA: He is not completely alert (not responding appropriately). (001239-30)\nProQaA: His primary problem is that he needs transportation: (001239-30)\nProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (001239-30)\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL B ASSIGNED (000781-39)\n\nPM35  \n\nHYDRANTS:  () &  ()\n\nTIME 13:22:19          DATE 07/27/13\nHOSPITAL STATUS   07/27/13   13:24:51\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342253\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n940 BAY FOREST CT-EP          BAY FOREST SENIOR APTS\n\nGrid 26     Map A02     Area 3605     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 933 EDGEWOOD RD-EP\n\nNature: 32B02-MEDICAL ALERT ALARM\n\nCommunity of ANNAPOLIS CITY (001239-30)\nTAC CHANNEL B ASSIGNED (000781-39)\nUnit 'MU362' had changed quarters for unit 'PM36' (000781-39)\nUnits 'on air': MU362 (000781-39)\n\nMU362  \n\nHYDRANTS:  () &  ()\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX\n\nTIME 13:16:51          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   13:19:40\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342220\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n710 BALLAST WAY          \n\nGrid 19     Map F11     Area 4013     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\n\nSecond cross street - 2712 S HAVEN RD\n\nNature: 28C01J-STROKE: NOT ALERT\n\nCall back: 410-224-4687\n\nVERIFY PD VERIFY FD VERIFY EMS (001239-30)\nProQaA: 83 Year Old Woman, Conscious, Breathing (001239-30)\nProQaA: There is a single patient. (001239-30)\nProQaA: Yes (001239-30)\nProQaA: - (001239-30)\nProQaA: The caller is with the patient. (001239-30)\nProQaA: She is not completely alert (not responding appropriately). (001239-30)\nProQaA: She is breathing normally. (001239-30)\nProQaA: She is having sudden speech problems. (001239-30)\nProQaA: The Stroke Diagnostic results indicate clear evidence of (001239-30)\nProQaA: stroke. (001239-30)\nProQaA: These symptoms (problem) started: (001239-30)\nProQaA: 10 MINS AGO (001239-30)\nProQaA: She has had a STROKE before. (001239-30)\nCommunity of HERITAGE HARBOR (001239-30)\nTAC CHANNEL B ASSIGNED (000781-39)\nUnits 'on air': PM35 (000781-39)\n\nE402  PM35  \n\nHYDRANTS: 740 BALLAST WAY (0) & 701 BALLAST WAY (1487)\nAREA CAUTION NOTES FOR 4013\nSTAGING AREA FOR W/R: THE END OF SOUTH COURT\nBOAT RAMP: (BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE\nLZ:\n\nTIME 10:08:10          DATE 07/27/13\nHOSPITAL STATUS   07/27/13   10:11:05\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342198\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n1103 SMITHVILLE ST     223     WILEY BATES SENIOR HOUSING\n\nGrid 20     Map G10     Area 3825     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21401\n\nFirst cross street - 100 S VILLA AVE\n\nSecond cross street - 98 JOHNSON PL\n\nNature: 17B01-FALL:POSSIBLY DANGEROUS\n\nCommunity of ANNAPOLIS CITY (001488-43)\nTAC CHANNEL B ASSIGNED (000781-39)\n\nPM39  \n\nHYDRANTS:  () &  ()\n\nCAUTION NOTES\nKNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n19286\nTHERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\nTIME 08:03:03          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   08:04:13\n\nJOHN HOPKINS HO    REROUTE
(_subject_) INCIDENT 201342184\n\nCODE SA     STILL ALARM     ALARM 1\n\n6 SKIPPERS CT          \n\nGrid 26     Map A02     Area 3604     Preplan      Channel E    MOA 1\n\nCensus Tract      Zip 21403\n\n\nSecond cross street -  YACHTSMAN WAY\n\nNature: F50-ODOR OF SMOKE INSIDE (WARM)\n\nCall back: 410-268-1717\n\nIN KITCHEN (000557-35)\nCommunity of ANNAPOLIS CITY (000557-35)\nTAC CHANNEL E ASSIGNED (000579-)\nUnit 'E84' had changed quarters for unit 'E81' (000579-)\n\nE84  LAD39  \n\nHYDRANTS:  () &  ()\n\nTIME 04:45:56          DATE 07/27/13
(_subject_) INCIDENT 201342172\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n143 COMPROMISE ST          ANNAPOLIS SUMMER GARDEN\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 MAIN ST-AN\n\nSecond cross street - 98 NEWMAN ST\n\nNature: 21B02-HEMORRHAGE/LAC:SERIOUS BLEED\n\nCall back: 443-895-0049\n\nProQaA: 30 Year Old Woman, Conscious, Breathing (009617-30)\nProQaA: - (009617-30)\nProQaA: The caller is with the patient. (009617-30)\nProQaA: There is a single patient. (009617-30)\nProQaA: The cause of the bleeding is traumatic. (009617-30)\nProQaA: The bleeding is from a NOT DANGEROUS area. (009617-30)\nProQaA: She is completely alert (responding appropriately). (009617-30)\nProQaA: She is breathing normally. (009617-30)\nProQaA: There is blood spurting or pouring out (after dispatch, go to (009617-30)\nProQaA: Control Bleeding in DLS Links). (009617-30)\nProQaA: She does not have a bleeding disorder or is taking blood (009617-30)\nProQaA: thinners. (009617-30)\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (000579-)\nUnit 'MU362' had changed quarters for unit 'MU36' (000579-)\n\nE381  MU362  \n\nHYDRANTS:  () &  ()\n\nAUTO SPRINKLER SYSTEM\nDRY PIPE SPRINKLER SYSTEM.\n19011\nFDC LOCATED AT SIDE 1/2 CORNER.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 02:38:59          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   02:42:14\n\nJOHN HOPKINS HO    YELLOW
(_subject_) INCIDENT 201342168\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1175 MADISON ST-AN     B2     HARBOUR HOUSE APTS\n\nGrid 20     Map J12     Area 3602     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 8 SPA CREEK LANDING\n\nSecond cross street - 1000 PRESIDENT ST\n\nNature: 32B03-UNKNOWN MEDICAL EMERG\n\nCall back: 410-263-4275\n\n3RD PARTY (000582-39)\nPOSSIBLE LEG PAIN (000582-39)\n72YO FEMALE (000582-39)\nCommunity of ANNAPOLIS CITY (000582-39)\nTAC CHANNEL B ASSIGNED (000579-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\nKNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n17429\nBY MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\nTIME 02:01:32          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   02:02:40\n\nJOHN HOPKINS HO    YELLOW\n\n\rINCIDENT 201342168\n\nCODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n1175 MADISON ST-AN     B2     HARBOUR HOUSE APTS\n\nGrid 20     Map J12     Area 3602     Preplan      Channel B    MOA \n\nCensus Tract      Zip 21403\n\nFirst cross street - 8 SPA CREEK LANDING\n\nSecond cross street - 1000 PRESIDENT ST\n\nNature: 32B03-UNKNOWN MEDICAL EMERG\n\nCall back: 410-263-4275\n\n3RD PARTY (000582-39)\nPOSSIBLE LEG PAIN (000582-39)\n72YO FEMALE (000582-39)\nCommunity of ANNAPOLIS CITY (000582-39)\nTAC CHANNEL B ASSIGNED (000579-)\n\nE361  PM36  ATRO  \n\nHYDRANTS:  () &  ()\nKNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n17429\nBY MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\nTIME 02:01:32          DATE 07/27/13\n\r\nHOSPITAL STATUS   07/27/13   02:02:40\n\nJOHN HOPKINS HO    YELLOW
(_subject_) INCIDENT 201342154\n\nCODE LB     LOCAL BRUSH     ALARM 1\n\n4 BENS DR          \n\nGrid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21403\n\nFirst cross street - 1 MARCS CT\n\nSecond cross street - 1 MARCS CT\n\nNature: F15-BRUSH/WOODS/TRASH (SPVR)\n\nCall back: 410-991-9733\n\nDUMPSTER AND BRUSH (000716-39)\nCommunity of ANNAPOLIS CITY (000716-39)\nTAC CHANNEL B ASSIGNED (000716-39)\n\nE361  \n\nHYDRANTS:  () &  ()\n\nTIME 23:29:21          DATE 07/26/13
(_subject_) INCIDENT 201342148\n\nCODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n2141 GENERALS HWY-AN          APPLEBEES REST\n\nGrid 20     Map A08     Area 4024     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 1000 ANNAPOLIS MALL\n\nSecond cross street - 1000 BESTGATE RD\n\nNature: 04A01A-ASSAULT:NOT DANGEROUS\n\nCall back: 410-573-0078\n\nCommunity of ANNAPOLIS MALL (009611-43)\nTAC CHANNEL B ASSIGNED (000579-)\nUnit 'TW40' had changed quarters for unit 'TK40' (000579-)\n\nTW40  PM39  \n\nHYDRANTS: 2111 GENERALS HWY-AN (0) & 2115 GENERALS HWY-AN (3844)\n\nTIME 23:01:10          DATE 07/26/13\n\r\nHOSPITAL STATUS   07/26/13   23:02:46\n\nJOHN HOPKINS HO    YELLOW
(_subject_) INCIDENT 201342144\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n143 COMPROMISE ST          ANNAPOLIS SUMMER GARDEN\n\nGrid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2 MAIN ST-AN\n\nSecond cross street - 98 NEWMAN ST\n\nNature: F42-MISCELLANEOUS FIRE (SPVR)\n\nCall back: 203-767-0388\n\nCommunity of ANNAPOLIS CITY (009617-30)\nTAC CHANNEL B ASSIGNED (000716-39)\nUNIT E381 IS RESPONDING WITH OFFICER\nFrom E381: PERSONS RESPONDING 3\n\nE381  LAD39  \n\nHYDRANTS:  () &  ()\n\nAUTO SPRINKLER SYSTEM\nDRY PIPE SPRINKLER SYSTEM.\n19011\nFDC LOCATED AT SIDE 1/2 CORNER.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.\n\nTIME 22:39:37          DATE 07/26/13

Contact: Active911
Agency name: Annapolis Fire
Location: Annapolis, MD, United States
Sender: donotreply@annapolis.gov

(_subject_) INCIDENT 201343931\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\nLUC HALL HOLLOWAY          \n\nGrid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip \n\nNature: 00A6-MUTUAL AID MEDICAL\n\n*MEDIC ONLY, 58 (009611-42)\n58 YOM C/P (009611-42)\n*MEDIC ONLY WITH QNT 46 (009611-42)\n*Fire service incident 201343931 (009614-)\nTAC CHANNEL B ASSIGNED (009614-)\nUnits 'on air': PM39 (009611-42)\n\nPM39  A469  PM39  \n\nTIME 11:07:13          DATE 08/05/13\n\n
(_subject_) INCIDENT 201343931\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\nLUC HALL HOLLOWAY          \n\nGrid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip \n\nNature: 00A6-MUTUAL AID MEDICAL\n\n*MEDIC ONLY, 58 (009611-42)\n58 YOM C/P (009611-42)\n*MEDIC ONLY WITH QNT 46 (009611-42)\n*Fire service incident 201343931 (009614-)\nTAC CHANNEL B ASSIGNED (009614-)\n\nPM39  \n\nTIME 11:07:13          DATE 08/05/13\n\n
(_subject_) INCIDENT 201344368\n\nCODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n250 WOOD RD NAVAL MEDICAL CLINIC          \n\nGrid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip \n\nNature: 00A6-MUTUAL AID MEDICAL\n\n*POSS PUNCTURED LUNG (001488-43)\n*ALS (001488-43)\n*Fire service incident 201344368 (009603-)\nTAC CHANNEL B ASSIGNED (009603-)\n\nPM39  \n\nTIME 16:43:59          DATE 08/07/13
(_subject_) INCIDENT 201344256\n\nCODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n803 COXSWAIN WAY     104     BROAD CREEK CONDOS\n\nGrid 19     Map G10     Area 4016     Preplan      Channel B    MOA 1\n\nCensus Tract      Zip 21401\n\nFirst cross street - 2802 COXSWAIN CT\n\nNature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\nCall back: 410-266-5622\n\n*LOC CN: DISPATCH AN ENGINE ON ALL MEDICAL CALLS TO THIS \n*ADDRESS FOR KNOX BOX 511(12/27/95) \nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009623-39)\nCommunity of HERITAGE HARBOR (009623-39)\n*NOT SURE WHAT IS WRONG WITH HIM (009623-39)\n*HE WANTS AMBULANCE TO CHECK HIM OUT (009623-39)\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009623-39)\n*Fire service incident 201344256 (009623-39)\nAdded unit 'E402' via 'X' at Tac  (009623-39)\nTAC CHANNEL B ASSIGNED (009623-39)\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\n\nPM35  E402  PM35  \n\nHYDRANTS: 7335 FOREST AVE-HA (0) & 809 COXSWAIN WAY (1476)\n\nCAUTION NOTES\nDATE: 920619, BATTALION: 3, COMPANY: 40, BOX: 4016\n\n.\nKBOX BOX NOTES:\nLOCATION OF BOX IS RIGHT SIDE OF FRONT DOORS\nBOX CONTAINS:\n1.KEYS TO STORE ROOMS AND EXITS.\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:\n\nTIME 05:49:42          DATE 08/07/13

*/

public class MDAnneArundelCountyAnnapolisParserTest extends BaseParserTest {
  
  public MDAnneArundelCountyAnnapolisParserTest() {
    setParser(new MDAnneArundelCountyAnnapolisParser(), "ANNE ARUNDEL COUNTY", "MD");
  }
  
  @Test
  public void testAnnapolisFire() {

    doTest("T1",
        "(_subject_) INCIDENT 201332270\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "2371 SOLOMONS ISLAND RD-AN          SHOPPERS FOOD WAREHOUSE\n\n" +
        "Grid 20     Map C10     Area 3540     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2200 FOREST DR-AN\n\n" +
        "Second cross street - 2038 SOMERVILLE RD\n\n" +
        "Nature: 17B03-FALL: UNKNOWN STATUS\n\n" +
        "Call back: 301-261-8743\n\n" +
        "VOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (000829-43)\n" +
        "Community of ANNAPOLIS CITY (000829-43)\n" +
        "4438371038 (000829-43)\n" +
        "TAC CHANNEL B ASSIGNED (001252-)\n" +
        "Units 'on air': PM35 (001252-)\n\n" +
        "PM35  \n\n" +
        "HYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)\n\n" +
        "TIME 18:43:40          DATE 06/10/13\n" +
        "HOSPITAL STATUS   06/10/13   18:45:39\n\n" +
        "JOHN HOPKINS HO    YELLOW\n" +
        "BURN CENTER (BA    YELLOW",

        "ID:201332270",
        "CALL:BLS WITH FIRST RESPONDER - FALL: UNKNOWN STATUS",
        "ADDR:2371 SOLOMONS ISLAND RD",
        "CITY:ANNAPOLIS",
        "PLACE:SHOPPERS FOOD WAREHOUSE",
        "MAP:20-C10-3540",
        "CH:B",
        "X:2200 FOREST DR & 2038 SOMERVILLE RD",
        "CODE:17B03",
        "PHONE:4438371038",
        "INFO:HYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)",
        "UNIT:PM35",
        "TIME:18:43:40",
        "DATE:06/10/13");

    doTest("T2",
        "(_subject_) INCIDENT 201332249\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "85 MANRESA RD     304     SENIOR QUARTERS AT MANRESA\n\n" +
        "Grid 20     Map K05     Area 1716A     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - B&A TRL-AN\n\n" +
        "Nature: 06C01-BREATHING PROB: ABNORMAL\n\n" +
        "Call back: 410-349-8624\n\n" +
        "Community of SEVERNSIDE (000897-48)\n" +
        "TAC CHANNEL B ASSIGNED (001252-)\n\n" +
        "E171  MU39  \n\n" +
        "HYDRANTS: 85 MANRESA RD (SIDE A) (0) & 85 MANRESA RD (SIDE D/A) (0)\n\n" +
        "CAUTION NOTES\n\n" +
        "TIME 17:08:19          DATE 06/10/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   06/10/13   17:09:01\n\n" +
        "BURN CENTER (BA    YELLOW,  REROUTE",

        "ID:201332249",
        "CALL:ONE EMT/P RESPONSE - BREATHING PROB: ABNORMAL",
        "ADDR:85 MANRESA RD",
        "APT:304",
        "PLACE:SENIOR QUARTERS AT MANRESA",
        "MAP:20-K05-1716A",
        "CH:B",
        "CODE:06C01",
        "PHONE:410-349-8624",
        "INFO:HYDRANTS: 85 MANRESA RD (SIDE A) (0) & 85 MANRESA RD (SIDE D/A) (0)\nCAUTION NOTES",
        "UNIT:E171  MU39",
        "TIME:17:08:19",
        "DATE:06/10/13");

    doTest("T3",
        "(_subject_) INCIDENT 201332246\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "RIVA RD-AN/RT665-AN          \n\n" +
        "Grid 20     Map B09     Area 4028     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2398 FOREST DR-AN\n\n" +
        "Second cross street - 1900 TOWNE CENTRE BLVD-AN\n\n" +
        "Nature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\n" +
        "Community of FESTIVAL PLAZA AT RIVA (009624-42)\n" +
        "TAC CHANNEL B ASSIGNED (001252-)\n" +
        "Units 'on air': E351 (001252-)\n\n" +
        "E351  \n\n" +
        "HYDRANTS: 2509 RIVA RD-AN (0) & 2510 RIVA RD (SIDE A/D) (0)\n\n" +
        "TIME 16:52:51          DATE 06/10/13",

        "ID:201332246",
        "CALL:LOCAL ALARM - ELECTRIC WIRES OUTSIDE (COLD)",
        "ADDR:RIVA RD & RT665",
        "MADDR:RIVA RD & RT 665",
        "CITY:ANNAPOLIS",
        "PLACE:FESTIVAL PLAZA AT RIVA",
        "MAP:20-B09-4028",
        "CH:B",
        "X:2398 FOREST DR & 1900 TOWNE CENTRE BLVD",
        "CODE:F25",
        "INFO:HYDRANTS: 2509 RIVA RD-AN (0) & 2510 RIVA RD (SIDE A/D) (0)",
        "UNIT:E351",
        "TIME:16:52:51",
        "DATE:06/10/13");

    doTest("T4",
        "(_subject_) INCIDENT 201332245\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "12 DOCK ST          ANNAPOLIS CRAB DECK\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel K    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - RANDALL ST\n\n" +
        "Second cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: 800-356-2222\n\n" +
        "Community of ANNAPOLIS CITY (000897-48)\n" +
        "TAC CHANNEL K ASSIGNED (001252-)\n\n" +
        "E361  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "FULLY SPRINKLERED.\n" +
        "19001\n" +
        "FDC LOCATED ON SIDE C, PRINCE GEORGE STREET.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 16:47:02          DATE 06/10/13",

        "ID:201332245",
        "CALL:STILL ALARM - ANNAPOLIS CITY ALARMS (WARM)",
        "ADDR:12 DOCK ST",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS CRAB DECK",
        "MAP:21-A10-3824",
        "CH:K",
        "X:RANDALL ST & 98 CRAIG ST",
        "CODE:F05B",
        "PHONE:800-356-2222",
        "INFO:CAUTION NOTES\nAUTO SPRINKLER SYSTEM\nFULLY SPRINKLERED.\n19001\nFDC LOCATED ON SIDE C, PRINCE GEORGE STREET.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E361  LAD39",
        "TIME:16:47:02",
        "DATE:06/10/13");

    doTest("T5",
        "(_subject_) INCIDENT 201332244\n\n" +
        "CODE FA     FIRE ALARM SOUNDING     ALARM 1\n\n" +
        "203 CAPE ST JOHN RD          \n\n" +
        "Grid 19     Map J13     Area 0312     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 ISLAND VIEW DR\n\n" +
        "Nature: F05-ALARMS/NON HIGH LIFE (HOT)\n\n" +
        "Call back: 800-356-2222\n\n" +
        "Community of CAPE SAINT JOHN (000829-43)\n" +
        "Added unit 'E351' via 'X' at Tac  (009623-39)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (009623-39)\n" +
        "Units 'on air': ME2 (009623-39)\n\n" +
        "ME2  E351  \n\n" +
        "HYDRANTS: 224 CAPE ST JOHN RD (0) & 245 CAPE ST JOHN RD (0)\n" +
        "AREA CAUTION NOTES FOR 0312\n" +
        "STAGING AREA FOR W/R: RIVA RD AND CAPE ST JOHN RD\n" +
        "BOAT RAMP: CAPE ST JOHN, DOGWOOD TRAIL OFF VALLEY VIEW.\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 16:40:25          DATE 06/10/13",

        "ID:201332244",
        "CALL:FIRE ALARM SOUNDING - ALARMS/NON HIGH LIFE (HOT)",
        "ADDR:203 CAPE ST JOHN RD",
        "PLACE:CAPE SAINT JOHN",
        "MAP:19-J13-0312",
        "CH:B",
        "X:198 ISLAND VIEW DR",
        "CODE:F05",
        "PHONE:800-356-2222",
        "INFO:HYDRANTS: 224 CAPE ST JOHN RD (0) & 245 CAPE ST JOHN RD (0)\nAREA CAUTION NOTES FOR 0312\nSTAGING AREA FOR W/R: RIVA RD AND CAPE ST JOHN RD\nBOAT RAMP: CAPE ST JOHN, DOGWOOD TRAIL OFF VALLEY VIEW.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  E351",
        "TIME:16:40:25",
        "DATE:06/10/13");

    doTest("T6",
        "(_subject_) INCIDENT 201332240\n\n" +
        "CODE B     BOX ASSIGNMENT     ALARM 1\n\n" +
        "1994 BELL BRANCH RD          \n\n" +
        "Grid 18     Map H10     Area 0723     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21054\n\n" +
        "First cross street - RUTLAND RD-GM\n\n" +
        "Second cross street - RUTLAND RD-GM\n\n" +
        "Nature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\n" +
        "Community of CARRIAGE ESTATES (000897-48)\n" +
        "TAC CHANNEL E ASSIGNED (009623-39)\n" +
        "Unit 'TW839' had changed quarters for unit 'TK839' (009623-39)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009623-39)\n" +
        "Units 'on air': BC3 (009623-39)\n\n" +
        "E73  E31  E51  E816  TW839  TW40  SQ38  TA3  TA5  PM3  BC3  SCA  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0723\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  PGD  (3)  NAH\n\n" +
        "TIME 16:27:26          DATE 06/10/13",

        "ID:201332240",
        "CALL:BOX ASSIGNMENT - ODOR GAS IN STRUCTURE (WARM)",
        "ADDR:1994 BELL BRANCH RD",
        "PLACE:CARRIAGE ESTATES",
        "MAP:18-H10-0723",
        "CH:E",
        "X:RUTLAND RD & RUTLAND RD",
        "CODE:F50S",
        "INFO:AREA CAUTION NOTES FOR 0723\nCLOSEST HOSPITALS:  1)  AAMC  (2)  PGD  (3)  NAH",
        "UNIT:E73  E31  E51  E816  TW839  TW40  SQ38  TA3  TA5  PM3  BC3  SCA",
        "TIME:16:27:26",
        "DATE:06/10/13");

    doTest("T7",
        "(_subject_) INCIDENT 201332238\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "1021 CEDAR RIDGE CT          \n\n" +
        "Grid 20     Map J13     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 920 BANK ST-EP\n\n" +
        "Nature: 01A01-ABDOM PAIN: OR PROBLEM\n\n" +
        "Call back: 410-263-5325\n\n" +
        "ProQaA: 84 Year Old Man, Conscious, Breathing (000557-42)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000557-42)\n" +
        "ProQaA: This is a 1st party caller. (000557-42)\n" +
        "ProQaA: There is a single patient. (000557-42)\n" +
        "ProQaA: He is completely awake (alert). (000557-42)\n" +
        "ProQaA: He has not fainted. (000557-42)\n" +
        "ProQaA: He does not have pain above the belly button (navel). (000557-42)\n" +
        "Community of ANNAPOLIS CITY (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "PM36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 16:15:11          DATE 06/10/13",

        "ID:201332238",
        "CALL:BLS WITH FIRST RESPONDER - ABDOM PAIN: OR PROBLEM",
        "ADDR:1021 CEDAR RIDGE CT",
        "CITY:ANNAPOLIS",
        "MAP:20-J13-3602",
        "CH:B",
        "CODE:01A01",
        "PHONE:410-263-5325",
        "INFO:84 Year Old Man, Conscious, Breathing\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThere is a single patient.\nHe is completely awake (alert).\nHe has not fainted.\nHe does not have pain above the belly button (navel).",
        "UNIT:PM36",
        "TIME:16:15:11",
        "DATE:06/10/13");

    doTest("T8",
        "(_subject_) INCIDENT 201332231\n\n" +
        "CODE WRL     WATER RESCUE LOCAL     ALARM 1\n\n" +
        "RIVER RD-LH/W NURSERY RD          \n\n" +
        "Grid 02     Map B05     Area 3203     Preplan      Channel ~3~    MOA 1\n\n" +
        "Census Tract      Zip 21090\n\n" +
        "First cross street - 1300 W NURSERY RD\n\n" +
        "Nature: F60-SERVICE CALL (COLD)\n\n" +
        "NOT MOVING, UNSURE IF OCCUPIED (000958-48)\n" +
        "THEY JUST WANT THE VEHICEL CHECKED (000958-48)\n" +
        "Community of PATAPSCO (000958-48)\n" +
        "TAC CHANNEL ~3~ ASSIGNED (000777-38)\n\n" +
        "E321  FB36  FB41  SNAP  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3203\n" +
        "STAGING AREA FOR W/R: AL'S LIQUORS, 6 NURSERY RD. , BOX 32-4\n" +
        "BOAT RAMP: MUST CARRY BOAT AND LAUNCH AT COUNTY LINE ON RT. 648\n" +
        "LZ: CLOSEST IN  BOX 32-6. WINTERSON RD./NEAR RT.295 OR AERO DR.\n" +
        "AND CORPORATE DR.\n\n" +
        "TIME 15:43:09          DATE 06/10/13",

        "ID:201332231",
        "CALL:WATER RESCUE LOCAL - SERVICE CALL (COLD)",
        "ADDR:RIVER RD & W NURSERY RD",
        "CITY:LH",
        "PLACE:PATAPSCO",
        "MAP:02-B05-3203",
        "CH:~3~",
        "X:1300 W NURSERY RD",
        "CODE:F60",
        "INFO:NOT MOVING, UNSURE IF OCCUPIED\nTHEY JUST WANT THE VEHICEL CHECKED\nAREA CAUTION NOTES FOR 3203\nSTAGING AREA FOR W/R: AL'S LIQUORS, 6 NURSERY RD. , BOX 32-4\nBOAT RAMP: MUST CARRY BOAT AND LAUNCH AT COUNTY LINE ON RT. 648\nLZ: CLOSEST IN  BOX 32-6. WINTERSON RD./NEAR RT.295 OR AERO DR.\nAND CORPORATE DR.",
        "UNIT:E321  FB36  FB41  SNAP",
        "TIME:15:43:09",
        "DATE:06/10/13");

    doTest("T9",
        "(_subject_) INCIDENT 201332224\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "151 MAIN ST-AN          GREAT FEATHERS\n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 CONDUIT ST\n\n" +
        "Second cross street - 2 FRANCIS ST\n\n" +
        "Nature: 32B03-UNKNOWN: 3RD PARTY CALL\n\n" +
        "Call back: 410-990-0224\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\n" +
        "FOR AN AMBO (000958-48)\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n" +
        "Units 'on air': MU39 (009623-39)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 15:02:34          DATE 06/10/13\n" +
        "\rINCIDENT 201332224\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "151 MAIN ST-AN          GREAT FEATHERS\n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 CONDUIT ST\n\n" +
        "Second cross street - 2 FRANCIS ST\n\n" +
        "Nature: 32B03-UNKNOWN: 3RD PARTY CALL\n\n" +
        "Call back: 410-990-0224\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\n" +
        "FOR AN AMBO (000958-48)\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n" +
        "Units 'on air': MU39 (009623-39)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 15:02:34          DATE 06/10/13",

        "ID:201332224",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN: 3RD PARTY CALL",
        "ADDR:151 MAIN ST",
        "CITY:ANNAPOLIS",
        "PLACE:GREAT FEATHERS",
        "MAP:20-K10-3824",
        "CH:B",
        "X:198 CONDUIT ST & 2 FRANCIS ST",
        "CODE:32B03",
        "PHONE:410-990-0224",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nFOR AN AMBO\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  MU39  ATRO",
        "TIME:15:02:34",
        "DATE:06/10/13");

    doTest("T10",
        "(_subject_) INCIDENT 201332220\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "2371 SOLOMONS ISLAND RD-AN          SHOPPERS FOOD WAREHOUSE\n\n" +
        "Grid 20     Map C10     Area 3540     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2200 FOREST DR-AN\n\n" +
        "Second cross street - 2038 SOMERVILLE RD\n\n" +
        "Nature: 30B01-TRAUMATIC INJURY? POSS DANGER\n\n" +
        "Call back: 443-995-0500\n\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n" +
        "Units 'on air': PM35 (009623-39)\n\n" +
        "PM35  \n\n" +
        "HYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)\n\n" +
        "TIME 14:38:48          DATE 06/10/13",

        "ID:201332220",
        "CALL:BLS WITH FIRST RESPONDER - TRAUMATIC INJURY? POSS DANGER",
        "ADDR:2371 SOLOMONS ISLAND RD",
        "CITY:ANNAPOLIS",
        "PLACE:SHOPPERS FOOD WAREHOUSE",
        "MAP:20-C10-3540",
        "CH:B",
        "X:2200 FOREST DR & 2038 SOMERVILLE RD",
        "CODE:30B01",
        "PHONE:443-995-0500",
        "INFO:HYDRANTS: 2473 SOLOMONS ISLAND RD-AN (6864) & 2461 SOLOMONS ISLAND RD-AN (6864)",
        "UNIT:PM35",
        "TIME:14:38:48",
        "DATE:06/10/13");

    doTest("T11",
        "(_subject_) INCIDENT 201332202\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "HOUSLEY RD/DEFENSE HWY-AN          \n\n" +
        "Grid 20     Map A08     Area 4024     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 152 DEFENSE HWY-AN\n\n" +
        "Second cross street - 1 GATEWAY VILLAGE DR\n\n" +
        "Nature: 32B03-UNKNOWN: 3RD PARTY CALL\n\n" +
        "Call back: 410-212-4273\n\n" +
        "Community of GATEWAY VILLAGE PLAZA (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E381  PM40  \n\n" +
        "HYDRANTS: 2645 HOUSLEY RD (3685) & 2631 HOUSLEY RD (3685)\n\n" +
        "TIME 13:22:48          DATE 06/10/13",

        "ID:201332202",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN: 3RD PARTY CALL",
        "ADDR:HOUSLEY RD & DEFENSE HWY",
        "CITY:ANNAPOLIS",
        "PLACE:GATEWAY VILLAGE PLAZA",
        "MAP:20-A08-4024",
        "CH:B",
        "X:152 DEFENSE HWY & 1 GATEWAY VILLAGE DR",
        "CODE:32B03",
        "PHONE:410-212-4273",
        "INFO:HYDRANTS: 2645 HOUSLEY RD (3685) & 2631 HOUSLEY RD (3685)",
        "UNIT:E381  PM40",
        "TIME:13:22:48",
        "DATE:06/10/13");

    doTest("T12",
        "(_subject_) INCIDENT 201332201\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "664 CENTRAL AVE E          SUMMIT SCHOOL\n\n" +
        "Grid 25     Map C10     Area 0223     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 3700 CAMP LETTS RD\n\n" +
        "Second cross street - 500 LOCH HAVEN RD\n\n" +
        "Nature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\n" +
        "Call back: 888-246-7539\n\n" +
        "Community of CAMP LETTS (000557-42)\n" +
        "TAC CHANNEL E ASSIGNED (009623-39)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (009623-39)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009623-39)\n" +
        "Units 'on air': ME2, TA3, E31, TW40, TA1 (009623-39)\n\n" +
        "ME2  E31  E12  E381  TW40  LAD39  SQ7  TA3  TA1  TA40  PM2  BC3  SCA  \n\n" +
        "HYDRANTS: 664 CENTRAL AVE E (TANK) (0) &  ()\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 0223\n" +
        "STAGING AREA FOR W/R: CAMP LETTS RD & RT 214\n" +
        "BOAT RAMP: CAMP LETTS\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 13:20:41          DATE 06/10/13\n" +
        "\rINCIDENT 201332201\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "664 CENTRAL AVE E          SUMMIT SCHOOL\n\n" +
        "Grid 25     Map C10     Area 0223     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 3700 CAMP LETTS RD\n\n" +
        "Second cross street - 500 LOCH HAVEN RD\n\n" +
        "Nature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\n" +
        "Call back: 888-246-7539\n\n" +
        "Community of CAMP LETTS (000557-42)\n" +
        "TAC CHANNEL E ASSIGNED (009623-39)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (009623-39)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009623-39)\n" +
        "Units 'on air': ME2, TA3, E31, TW40, TA1 (009623-39)\n\n" +
        "ME2  E31  E12  E381  TW40  LAD39  SQ7  TA3  TA1  TA40  PM2  BC3  SCA  \n\n" +
        "HYDRANTS: 664 CENTRAL AVE E (TANK) (0) &  ()\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 0223\n" +
        "STAGING AREA FOR W/R: CAMP LETTS RD & RT 214\n" +
        "BOAT RAMP: CAMP LETTS\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 13:20:41          DATE 06/10/13",

        "ID:201332201",
        "CALL:COMMERCIAL BOX - HI LIFE/ALARMS SOUNDING (WARM)",
        "ADDR:664 CENTRAL AVE E",
        "PLACE:SUMMIT SCHOOL",
        "MAP:25-C10-0223",
        "CH:E",
        "X:3700 CAMP LETTS RD & 500 LOCH HAVEN RD",
        "CODE:F05H",
        "PHONE:888-246-7539",
        "INFO:HYDRANTS: 664 CENTRAL AVE E (TANK) (0) &  ()\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0223\nSTAGING AREA FOR W/R: CAMP LETTS RD & RT 214\nBOAT RAMP: CAMP LETTS\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  E31  E12  E381  TW40  LAD39  SQ7  TA3  TA1  TA40  PM2  BC3  SCA",
        "TIME:13:20:41",
        "DATE:06/10/13");

    doTest("T13",
        "(_subject_) INCIDENT 201332200\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "235A FARRAGUT CT     101     \n\n" +
        "Grid 20     Map G12     Area 3524     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 230 HILLTOP LN-EP\n\n" +
        "Nature: 00A2-MEDICAL SERVICE CALL (COLD)\n\n" +
        "Call back: 443-994-1416\n\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E352  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:11:19          DATE 06/10/13",

        "ID:201332200",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MEDICAL SERVICE CALL (COLD)",
        "ADDR:235A FARRAGUT CT",
        "APT:101",
        "CITY:ANNAPOLIS",
        "MAP:20-G12-3524",
        "CH:B",
        "CODE:00A2",
        "PHONE:443-994-1416",
        "UNIT:E352",
        "TIME:13:11:19",
        "DATE:06/10/13");

    doTest("T14",
        "(_subject_) INCIDENT 201332191\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "809 MIDSHIP CT          \n\n" +
        "Grid 19     Map G09     Area 4016     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 822 YARDARM WAY\n\n" +
        "Nature: 32B03-UNKNOWN: 3RD PARTY CALL\n\n" +
        "Community of COOVER RD AREA COMMUNITY (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E402  PM35  \n\n" +
        "HYDRANTS:  (0) & 806 MIDSHIP CT (0)\n" +
        "AREA CAUTION NOTES FOR 4016\n" +
        "STAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\n" +
        "BOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\n" +
        "LZ:\n\n" +
        "TIME 11:43:31          DATE 06/10/13",

        "ID:201332191",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN: 3RD PARTY CALL",
        "ADDR:809 MIDSHIP CT",
        "PLACE:COOVER RD AREA COMMUNITY",
        "MAP:19-G09-4016",
        "CH:B",
        "CODE:32B03",
        "INFO:HYDRANTS:  (0) & 806 MIDSHIP CT (0)\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:",
        "UNIT:E402  PM35",
        "TIME:11:43:31",
        "DATE:06/10/13");

    doTest("T15",
        "(_subject_) INCIDENT 201332183\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "20 CHESTON AVE          \n\n" +
        "Grid 20     Map J11     Area 3822     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 6 FRANKLIN ST-AN\n\n" +
        "Nature: 17B01-FALL: POSSIBLY DANGEROUS\n\n" +
        "Call back: 443-848-9747\n\n" +
        "ProQaA: 94 Year Old Woman, Conscious, Breathing (000557-42)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000557-42)\n" +
        "ProQaA: The caller is with the patient. (000557-42)\n" +
        "ProQaA: There is a single patient. (000557-42)\n" +
        "ProQaA: It's not known when this happened. (000557-42)\n" +
        "ProQaA: The fall was less than six feet/two meters. (000557-42)\n" +
        "ProQaA: The fall was accidental. (000557-42)\n" +
        "ProQaA: She is completely awake (alert). (000557-42)\n" +
        "ProQaA: She is breathing normally. (000557-42)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (000557-42)\n" +
        "ProQaA: There is some bleeding, not serious. (000557-42)\n" +
        "Community of ANNAPOLIS CITY (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "MU39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 11:22:14          DATE 06/10/13",

        "ID:201332183",
        "CALL:BLS WITH FIRST RESPONDER - FALL: POSSIBLY DANGEROUS",
        "ADDR:20 CHESTON AVE",
        "CITY:ANNAPOLIS",
        "MAP:20-J11-3822",
        "CH:B",
        "X:6 FRANKLIN ST",
        "CODE:17B01",
        "PHONE:443-848-9747",
        "INFO:94 Year Old Woman, Conscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.\nIt's not known when this happened.\nThe fall was less than six feet/two meters.\nThe fall was accidental.\nShe is completely awake (alert).\nShe is breathing normally.\nThe injury is to a POSSIBLY DANGEROUS area.\nThere is some bleeding, not serious.",
        "UNIT:MU39",
        "TIME:11:22:14",
        "DATE:06/10/13");

    doTest("T16",
        "(_subject_) INCIDENT 201332147\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "30 CARVER ST          \n\n" +
        "Grid 20     Map D10     Area 3529     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 OAKLAWN AVE\n\n" +
        "Second cross street - 98 HOLECLOW ST\n\n" +
        "Nature: 06C01-BREATHING PROB: ABNORMAL\n\n" +
        "Call back: 410-573-0050\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:38:23          DATE 06/10/13INCIDENT 201332147\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "30 CARVER ST          \n\n" +
        "Grid 20     Map D10     Area 3529     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 OAKLAWN AVE\n\n" +
        "Second cross street - 98 HOLECLOW ST\n\n" +
        "Nature: 06C01-BREATHING PROB: ABNORMAL\n\n" +
        "Call back: 410-573-0050\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000958-48)\n" +
        "Community of ANNAPOLIS CITY (000958-48)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:38:23          DATE 06/10/13",

        "ID:201332147",
        "CALL:ONE EMT/P RESPONSE - BREATHING PROB: ABNORMAL",
        "ADDR:30 CARVER ST",
        "CITY:ANNAPOLIS",
        "MAP:20-D10-3529",
        "CH:B",
        "X:400 OAKLAWN AVE & 98 HOLECLOW ST",
        "CODE:06C01",
        "PHONE:410-573-0050",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL",
        "UNIT:E352  PM35  ATRO",
        "TIME:08:38:23",
        "DATE:06/10/13");

    doTest("T17",
        "(_subject_) INCIDENT 201332141\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "ADMIRAL DR/CAPTAINS CIR          \n\n" +
        "Grid 20     Map E08     Area 3514     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 CAPTAINS CIR\n\n" +
        "Second cross street - 1978 MORELAND PKWY\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Call back: 410-507-1198\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000781-43)\n" +
        "Community of ANNAPOLIS CITY (000781-43)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:10:31          DATE 06/10/13INCIDENT 201332141\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "ADMIRAL DR/CAPTAINS CIR          \n\n" +
        "Grid 20     Map E08     Area 3514     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 CAPTAINS CIR\n\n" +
        "Second cross street - 1978 MORELAND PKWY\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Call back: 410-507-1198\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000781-43)\n" +
        "Community of ANNAPOLIS CITY (000781-43)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:10:31          DATE 06/10/13",

        "ID:201332141",
        "CALL:PX TYPE WITH E TK OR SQ - MVC: UNKNOWN STATUS",
        "ADDR:ADMIRAL DR & CAPTAINS CIR",
        "CITY:ANNAPOLIS",
        "MAP:20-E08-3514",
        "CH:B",
        "X:400 CAPTAINS CIR & 1978 MORELAND PKWY",
        "CODE:29B06",
        "PHONE:410-507-1198",
        "UNIT:E352  PM35  ATRO",
        "TIME:08:10:31",
        "DATE:06/10/13");

    doTest("T18",
        "(_subject_) INCIDENT 201332134\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1705 CEDAR PARK RD          \n\n" +
        "Grid 20     Map E09     Area 3812     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 FORD CIR\n\n" +
        "Second cross street - BRISTOL DR\n\n" +
        "Nature: 19C04-HEART PROB: CARDIAC HX\n\n" +
        "Call back: 410-280-0959\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-30)\n" +
        "ProQaA: 56 Year Old Man, Conscious, Breathing (009614-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009614-30)\n" +
        "ProQaA: The caller is with the patient. (009614-30)\n" +
        "ProQaA: There is a single patient. (009614-30)\n" +
        "ProQaA: He is completely awake (alert). (009614-30)\n" +
        "ProQaA: He is breathing normally. (009614-30)\n" +
        "ProQaA: He is not changing color. (009614-30)\n" +
        "ProQaA: It's not known if he is clammy. (009614-30)\n" +
        "ProQaA: He has a history of heart problems. (009614-30)\n" +
        "ProQaA: He does not have chest pain. (009614-30)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (009614-30)\n" +
        "ProQaA: ROUTINE (009614-30)\n" +
        "ProQaA: Instructions for taking a pulse have been given. (009614-30)\n" +
        "ProQaA: The caller tried but was unable to determine his pulse rate. (009614-30)\n" +
        "Community of ANNAPOLIS CITY (009614-30)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 07:00:03          DATE 06/10/13\n" +
        "\rINCIDENT 201332134\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1705 CEDAR PARK RD          \n\n" +
        "Grid 20     Map E09     Area 3812     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 FORD CIR\n\n" +
        "Second cross street - BRISTOL DR\n\n" +
        "Nature: 19C04-HEART PROB: CARDIAC HX\n\n" +
        "Call back: 410-280-0959\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-30)\n" +
        "ProQaA: 56 Year Old Man, Conscious, Breathing (009614-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009614-30)\n" +
        "ProQaA: The caller is with the patient. (009614-30)\n" +
        "ProQaA: There is a single patient. (009614-30)\n" +
        "ProQaA: He is completely awake (alert). (009614-30)\n" +
        "ProQaA: He is breathing normally. (009614-30)\n" +
        "ProQaA: He is not changing color. (009614-30)\n" +
        "ProQaA: It's not known if he is clammy. (009614-30)\n" +
        "ProQaA: He has a history of heart problems. (009614-30)\n" +
        "ProQaA: He does not have chest pain. (009614-30)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (009614-30)\n" +
        "ProQaA: ROUTINE (009614-30)\n" +
        "ProQaA: Instructions for taking a pulse have been given. (009614-30)\n" +
        "ProQaA: The caller tried but was unable to determine his pulse rate. (009614-30)\n" +
        "Community of ANNAPOLIS CITY (009614-30)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 07:00:03          DATE 06/10/13",

        "ID:201332134",
        "CALL:ONE EMT/P RESPONSE - HEART PROB: CARDIAC HX",
        "ADDR:1705 CEDAR PARK RD",
        "CITY:ANNAPOLIS",
        "MAP:20-E09-3812",
        "CH:B",
        "X:2 FORD CIR & BRISTOL DR",
        "CODE:19C04",
        "PHONE:410-280-0959",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n56 Year Old Man, Conscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.\nHe is completely awake (alert).\nHe is breathing normally.\nHe is not changing color.\nIt's not known if he is clammy.\nHe has a history of heart problems.\nHe does not have chest pain.\nHe took a prescribed medication in the past 12hrs:\nROUTINE\nInstructions for taking a pulse have been given.\nThe caller tried but was unable to determine his pulse rate.",
        "UNIT:E381  PM39  ATRO",
        "TIME:07:00:03",
        "DATE:06/10/13");

    doTest("T19",
        "(_subject_) INCIDENT 201332111\n\n" +
        "CODE FA     FIRE ALARM SOUNDING     ALARM 1\n\n" +
        "235 WESTWOOD RD-AN          \n\n" +
        "Grid 20     Map H06     Area 3811     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 SCOTT DR-AN\n\n" +
        "Second cross street - 206 WARDOUR DR\n\n" +
        "Nature: F05-ALARMS/NON HIGH LIFE (HOT)\n\n" +
        "Community of ANNAPOLIS CITY (009605-30)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n\n" +
        "E381  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 01:49:25          DATE 06/10/13",

        "ID:201332111",
        "CALL:FIRE ALARM SOUNDING - ALARMS/NON HIGH LIFE (HOT)",
        "ADDR:235 WESTWOOD RD",
        "CITY:ANNAPOLIS",
        "MAP:20-H06-3811",
        "CH:B",
        "X:100 SCOTT DR & 206 WARDOUR DR",
        "CODE:F05",
        "UNIT:E381",
        "TIME:01:49:25",
        "DATE:06/10/13");

    doTest("T20",
        "(_subject_) INCIDENT 201332106\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "461 HONERENG TRL          \n\n" +
        "Grid 20     Map D04     Area 4026     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 1730 VINEYARD TRL\n\n" +
        "Nature: 21B01-HEMORAGE/LACER: POSS DANGER\n\n" +
        "ProQaA: 61 Year Old Man, Conscious, Breathing (000813-38)\n" +
        "ProQaA: There is a single patient. (000813-38)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000813-38)\n" +
        "ProQaA: This is a 1st party caller. (000813-38)\n" +
        "ProQaA: The cause of the bleeding is non-traumatic. (000813-38)\n" +
        "ProQaA: The bleeding is from a POSSIBLY DANGEROUS area. (000813-38)\n" +
        "ProQaA: He is completely awake (alert). (000813-38)\n" +
        "ProQaA: He is breathing normally. (000813-38)\n" +
        "ProQaA: There is no SERIOUS bleeding. (000813-38)\n" +
        "ProQaA: He does not have a bleeding disorder or is taking blood (000813-38)\n" +
        "ProQaA: thinners. (000813-38)\n" +
        "BLOODY STOOL (000813-38)\n" +
        "Community of EPPING FOREST (000813-38)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n\n" +
        "E402  PM35  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 4026\n" +
        "STAGING AREA FOR W/R:POWELL DRIVE AND NORTH HARBOUR COURT\n" +
        "BOAT RAMP: SAFERN COMM MARINA, ON NORTH HARBOUR COURT\n" +
        "LZ:\n\n" +
        "TIME 00:16:42          DATE 06/10/13",

        "ID:201332106",
        "CALL:BLS WITH FIRST RESPONDER - HEMORAGE/LACER: POSS DANGER",
        "ADDR:461 HONERENG TRL",  // Not mapping
        "PLACE:EPPING FOREST",
        "MAP:20-D04-4026",
        "CH:B",
        "CODE:21B01",
        "INFO:61 Year Old Man, Conscious, Breathing\nThere is a single patient.\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a POSSIBLY DANGEROUS area.\nHe is completely awake (alert).\nHe is breathing normally.\nThere is no SERIOUS bleeding.\nHe does not have a bleeding disorder or is taking blood\nthinners.\nBLOODY STOOL\nAREA CAUTION NOTES FOR 4026\nSTAGING AREA FOR W/R:POWELL DRIVE AND NORTH HARBOUR COURT\nBOAT RAMP: SAFERN COMM MARINA, ON NORTH HARBOUR COURT\nLZ:",
        "UNIT:E402  PM35",
        "TIME:00:16:42",
        "DATE:06/10/13");

    doTest("T21",
        "(_subject_) INCIDENT 201332104\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "103 GREAT OAK DR          \n\n" +
        "Grid 25     Map J04     Area 0817     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 412 HARBOR DR-EP\n\n" +
        "Second cross street - 416 HILLSMERE DR\n\n" +
        "Nature: 31D01-UNCONSCIOUS\n\n" +
        "Call back: 443-223-5985\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (009605-30)\n" +
        "ProQaA: 58 Year Old Man, Unconscious, Breathing (009605-30)\n" +
        "ProQaA: There is a single patient. (009605-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009605-30)\n" +
        "ProQaA: The caller is with the patient. (009605-30)\n" +
        "ProQaA: He is not breathing normally. (009605-30)\n" +
        "ProQaA: He has a history of heart problems. (009605-30)\n" +
        "ProQaA: He is still unconscious. (009605-30)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (009605-30)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (009624-39)\n\n" +
        "E84  MU8  PM36  TRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 23:41:00          DATE 06/09/13",

        "ID:201332104",
        "CALL:2 EMT/P RESPONSE - UNCONSCIOUS",
        "ADDR:103 GREAT OAK DR",
        "PLACE:HILLSMERE SHORES-(IN COUNTY)",
        "MAP:25-J04-0817",
        "CH:B",
        "X:412 HARBOR DR & 416 HILLSMERE DR",
        "CODE:31D01",
        "PHONE:443-223-5985",
        "INFO:58 Year Old Man, Unconscious, Breathing\nThere is a single patient.\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nHe is not breathing normally.\nHe has a history of heart problems.\nHe is still unconscious.\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  MU8  PM36  TRO",
        "TIME:23:41:00",
        "DATE:06/09/13");

    doTest("T22",
        "(_subject_) INCIDENT 201332091\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "BELLE DR/ATWATER DR          \n\n" +
        "Grid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 302 ATWATER DR\n\n" +
        "Second cross street - 30 BELLE CT-AN\n\n" +
        "Nature: F42-MISCELLANEOUS FIRE (SPVR)\n\n" +
        "Call back: 443-714-7478\n\n" +
        "WIRELESS CALLER VERIFY LOCATION VERIFY CALLBK# (009605-30)\n" +
        "Community of ANNAPOLIS CITY (009605-30)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n\n" +
        "E352  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 21:32:15          DATE 06/09/13",

        "ID:201332091",
        "CALL:LOCAL ALARM - MISCELLANEOUS FIRE (SPVR)",
        "ADDR:BELLE DR & ATWATER DR",
        "CITY:ANNAPOLIS",
        "MAP:20-E12-3526",
        "CH:B",
        "X:302 ATWATER DR & 30 BELLE CT",
        "CODE:F42",
        "PHONE:443-714-7478",
        "UNIT:E352",
        "TIME:21:32:15",
        "DATE:06/09/13");

    doTest("T23",
        "(_subject_) INCIDENT 201332084\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "329 HILLSMERE DR          BRYAN PAINT CONTRACTING\n\n" +
        "Grid 25     Map J04     Area 0817     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 400 DUVALL LN-EP\n\n" +
        "Second cross street - 100 MAGNOLIA LN\n\n" +
        "Nature: 10D01-CHEST PAIN: RESP DISTRESS\n\n" +
        "Call back: 443-254-0579\n\n" +
        "ProQaA: 57 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: He is completely awake (alert). (001239-43)\n" +
        "ProQaA: He is breathing normally. (001239-43)\n" +
        "ProQaA: He is changing color. (001239-43)\n" +
        "ProQaA: He is not clammy. (001239-43)\n" +
        "ProQaA: He has a history of heart problems. (001239-43)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (001239-43)\n" +
        "ProQaA: NITRO (001239-43)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n" +
        "Unit 'MU362' had changed quarters for unit 'MU36' (009624-39)\n\n" +
        "E361  MU362  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 21:15:04          DATE 06/09/13\n" +
        "\rINCIDENT 201332084\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "329 HILLSMERE DR          BRYAN PAINT CONTRACTING\n\n" +
        "Grid 25     Map J04     Area 0817     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 400 DUVALL LN-EP\n\n" +
        "Second cross street - 100 MAGNOLIA LN\n\n" +
        "Nature: 10D01-CHEST PAIN: RESP DISTRESS\n\n" +
        "Call back: 443-254-0579\n\n" +
        "ProQaA: 57 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: He is completely awake (alert). (001239-43)\n" +
        "ProQaA: He is breathing normally. (001239-43)\n" +
        "ProQaA: He is changing color. (001239-43)\n" +
        "ProQaA: He is not clammy. (001239-43)\n" +
        "ProQaA: He has a history of heart problems. (001239-43)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (001239-43)\n" +
        "ProQaA: NITRO (001239-43)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n" +
        "Unit 'MU362' had changed quarters for unit 'MU36' (009624-39)\n\n" +
        "E361  MU362  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 21:15:04          DATE 06/09/13",

        "ID:201332084",
        "CALL:ONE EMT/P RESPONSE - CHEST PAIN: RESP DISTRESS",
        "ADDR:329 HILLSMERE DR",
        "PLACE:BRYAN PAINT CONTRACTING",
        "MAP:25-J04-0817",
        "CH:B",
        "X:400 DUVALL LN & 100 MAGNOLIA LN",
        "CODE:10D01",
        "PHONE:443-254-0579",
        "INFO:57 Year Old Man, Conscious, Breathing\nThere is a single patient.\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nHe is completely awake (alert).\nHe is breathing normally.\nHe is changing color.\nHe is not clammy.\nHe has a history of heart problems.\nHe took a prescribed medication in the past 12hrs:\nNITRO\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E361  MU362",
        "TIME:21:15:04",
        "DATE:06/09/13");

    doTest("T24",
        "(_subject_) INCIDENT 201332083\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "101 MANSION DR          \n\n" +
        "Grid 25     Map J06     Area 0817     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 610 DOVE LN\n\n" +
        "Second cross street - 600 HILLSMERE DR\n\n" +
        "Nature: 04A01A-ASSAULT: NOT DANGEROUS\n\n" +
        "Call back: 443-924-1809\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (009605-30)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (009605-30)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000582-38)\n\n" +
        "E84  PM36  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 21:16:26          DATE 06/09/13",

        "ID:201332083",
        "CALL:BLS WITH FIRST RESPONDER - ASSAULT: NOT DANGEROUS",
        "ADDR:101 MANSION DR",
        "PLACE:HILLSMERE SHORES-(IN COUNTY)",
        "MAP:25-J06-0817",
        "CH:B",
        "X:610 DOVE LN & 600 HILLSMERE DR",
        "CODE:04A01A",
        "PHONE:443-924-1809",
        "INFO:AREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  PM36",
        "TIME:21:16:26",
        "DATE:06/09/13");

    doTest("T25",
        "(_subject_) INCIDENT 201332076\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "831 RITCHIE HWY N-SP          KRIS LEIGH CATERED LIVING FACI\n\n" +
        "Grid 15     Map D08     Area 2305     Preplan      Channel K    MOA 1\n\n" +
        "Census Tract      Zip 21146\n\n" +
        "First cross street - 6 MANHATTAN LN\n\n" +
        "Second cross street - 2 CYPRESS COVE RD\n\n" +
        "Nature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\n" +
        "Call back: 800-356-2222\n\n" +
        "Community of MANHATTAN WOODS (009605-30)\n" +
        "TAC CHANNEL K ASSIGNED (009624-39)\n" +
        "Unit 'TK30' had changed quarters for unit 'QNT30' (009624-39)\n" +
        "Units 'on air': LAD39 (009624-39)\n\n" +
        "E231  E171  E121  E191  TK30  LAD39  SQ23  PM17  BC2  SCA  \n\n" +
        "HYDRANTS: 200 BAYLOR RD (0) & 831 RITCHIE HWY N-SP (0)\n" +
        "AREA CAUTION NOTES FOR 2305\n" +
        "STAGING AREA: MCKINSEY ROAD\n" +
        "BOAT RAMP: CAPE MCKINSEY\n" +
        "LZ.\n" +
        "CLOSEST HOSPITALS  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 20:44:24          DATE 06/09/13",

        "ID:201332076",
        "CALL:COMMERCIAL BOX - HI LIFE/ALARMS SOUNDING (WARM)",
        "ADDR:831 RITCHIE HWY N",
        "CITY:SERVERNA PARK",
        "PLACE:KRIS LEIGH CATERED LIVING FACI",
        "MAP:15-D08-2305",
        "CH:K",
        "X:6 MANHATTAN LN & 2 CYPRESS COVE RD",
        "CODE:F05H",
        "PHONE:800-356-2222",
        "INFO:HYDRANTS: 200 BAYLOR RD (0) & 831 RITCHIE HWY N-SP (0)\nAREA CAUTION NOTES FOR 2305\nSTAGING AREA: MCKINSEY ROAD\nBOAT RAMP: CAPE MCKINSEY\nLZ.\nCLOSEST HOSPITALS  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:E231  E171  E121  E191  TK30  LAD39  SQ23  PM17  BC2  SCA",
        "TIME:20:44:24",
        "DATE:06/09/13");

    doTest("T26",
        "(_subject_) INCIDENT 201332052\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "BAY RIDGE AVE/MONROE ST          \n\n" +
        "Grid 20     Map K13     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 900 MONROE ST\n\n" +
        "Second cross street - 900 MADISON ST-AN\n\n" +
        "Nature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\n" +
        "Call back: 864-561-3447\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (001239-43)\n" +
        "Community of ANNAPOLIS CITY (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n\n" +
        "E361  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 17:44:32          DATE 06/09/13",

        "ID:201332052",
        "CALL:LOCAL ALARM - ELECTRIC WIRES OUTSIDE (COLD)",
        "ADDR:BAY RIDGE AVE & MONROE ST",
        "CITY:ANNAPOLIS",
        "MAP:20-K13-3602",
        "CH:B",
        "X:900 MONROE ST & 900 MADISON ST",
        "CODE:F25",
        "PHONE:864-561-3447",
        "UNIT:E361",
        "TIME:17:44:32",
        "DATE:06/09/13");

    doTest("T27",
        "(_subject_) INCIDENT 201332043\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1424 BAY HEAD RD          \n\n" +
        "Grid 22     Map A03     Area 1907     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street -  WILLOW LN\n\n" +
        "Second cross street - 2 COUNTRY LN\n\n" +
        "Nature: 17D02-FALL: LONG FALL >6 FEET\n\n" +
        "Call back: 410-974-0976\n\n" +
        "VOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (009605-30)\n" +
        "ProQaA: 53 Year Old Woman, Conscious, Breathing (009605-30)\n" +
        "ProQaA: There is a single patient. (009605-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009605-30)\n" +
        "ProQaA: The caller is with the patient. (009605-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009605-30)\n" +
        "ProQaA: The fall was greater than six feet/two meters. (009605-30)\n" +
        "ProQaA: The fall was accidental. (009605-30)\n" +
        "ProQaA: She is completely awake (alert). (009605-30)\n" +
        "ProQaA: She is breathing normally. (009605-30)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009605-30)\n" +
        "ProQaA: There is no bleeding now. (009605-30)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (009605-30)\n" +
        "Community of BAY HEAD (009605-30)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n\n" +
        "A199  PM35  \n\n" +
        "HYDRANTS: 1423 BAY HEAD RD (TANK) (0) & 1566 BAY HEAD RD (0)\n" +
        "AREA CAUTION NOTES FOR 1907\n" +
        "STAGING AREA FOR W/R:FAIRWINDS & LAYROBE DR(FAIRWINDS MARINA)\n" +
        "BOAT RAMP : 1000 LAKE CLAIR DR (LAKE CLAIRE PIERS)\n" +
        "L/Z\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 17:12:41          DATE 06/09/13",

        "ID:201332043",
        "CALL:ONE EMT/P RESPONSE - FALL: LONG FALL >6 FEET",
        "ADDR:1424 BAY HEAD RD",
        "PLACE:BAY HEAD",
        "MAP:22-A03-1907",
        "CH:B",
        "X:WILLOW LN & 2 COUNTRY LN",
        "CODE:17D02",
        "PHONE:410-974-0976",
        "INFO:53 Year Old Woman, Conscious, Breathing\nThere is a single patient.\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThis happened now (less than 6hrs ago).\nThe fall was greater than six feet/two meters.\nThe fall was accidental.\nShe is completely awake (alert).\nShe is breathing normally.\nThe injury is to a NOT DANGEROUS area.\nThere is no bleeding now.\nThe injury is to a POSSIBLY DANGEROUS area.\nHYDRANTS: 1423 BAY HEAD RD (TANK) (0) & 1566 BAY HEAD RD (0)\nAREA CAUTION NOTES FOR 1907\nSTAGING AREA FOR W/R:FAIRWINDS & LAYROBE DR(FAIRWINDS MARINA)\nBOAT RAMP : 1000 LAKE CLAIR DR (LAKE CLAIRE PIERS)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:A199  PM35",
        "TIME:17:12:41",
        "DATE:06/09/13");

    doTest("T28",
        "(_subject_) INCIDENT 201332040\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "2422 ANNAPOLIS MALL          \n\n" +
        "Grid 20     Map B08     Area 4024     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 2188 GENERALS HWY-AN\n\n" +
        "Nature: 21A01-HEMORRHAGE/LAC: NOT DANGER\n\n" +
        "Call back: 410-507-7626\n\n" +
        "ProQaA: 32 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: The cause of the bleeding is traumatic. (001239-43)\n" +
        "ProQaA: The bleeding is from a NOT DANGEROUS area. (001239-43)\n" +
        "ProQaA: He is completely awake (alert). (001239-43)\n" +
        "ProQaA: He is breathing normally. (001239-43)\n" +
        "ProQaA: It's not known if there is any blood squirting or pouring out. (001239-43)\n" +
        "ProQaA: It's not known if he has a bleeding disorder or takes blood (001239-43)\n" +
        "ProQaA: thinners. (001239-43)\n" +
        "Community of ANNAPOLIS MALL (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009624-39)\n" +
        "Units 'on air': E402, PM17 (009624-39)\n" +
        "UNIT E402 IS RESPONDING WITH OFFICER\n" +
        "From E402: PERSONS RESPONDING 2\n" +
        "Fire Incident location changed from: 2002 ANNAPOLIS MALL (001239-43)\n" +
        "Apt/Lot: SMAK (001239-43)\n" +
        "New Fire Incident location: 2422 ANNAPOLIS MALL (001239-43)\n" +
        "Old Response area: 4024A\n" +
        "Units 'on air': PM35 (009624-39)\n\n" +
        "E402  PM17  PM35  \n\n" +
        "HYDRANTS: 2002 ANNAPOLIS MALL (0) & 2002 ANNAPOLIS MALL (0)\n\n" +
        "TIME 16:50:30          DATE 06/09/13",

        "ID:201332040",
        "CALL:BLS WITH FIRST RESPONDER - HEMORRHAGE/LAC: NOT DANGER",
        "ADDR:2422 ANNAPOLIS MALL",
        "PLACE:ANNAPOLIS MALL",
        "MAP:20-B08-4024",
        "CH:B",
        "CODE:21A01",
        "PHONE:410-507-7626",
        "INFO:32 Year Old Man, Conscious, Breathing\nThere is a single patient.\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThe cause of the bleeding is traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nHe is completely awake (alert).\nHe is breathing normally.\nIt's not known if there is any blood squirting or pouring out.\nIt's not known if he has a bleeding disorder or takes blood\nthinners.\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 2\nApt/Lot: SMAK\nOld Response area: 4024A\nHYDRANTS: 2002 ANNAPOLIS MALL (0) & 2002 ANNAPOLIS MALL (0)",
        "UNIT:E402  PM17  PM35",
        "TIME:16:50:30",
        "DATE:06/09/13");

    doTest("T29",
        "(_subject_) INCIDENT 201332032\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "50 IRONSTONE CT     L     \n\n" +
        "Grid 25     Map H02     Area 3522     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 1480 COBBLESTONE RD\n\n" +
        "Nature: F60-SERVICE CALL (COLD)\n\n" +
        "Call back: 443-924-3575\n\n" +
        "Community of ANNAPOLIS CITY (009623-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E351  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 15:38:49          DATE 06/09/13",

        "ID:201332032",
        "CALL:SPECIAL - UNIT REFERENCE CARD - SERVICE CALL (COLD)",
        "ADDR:50 IRONSTONE CT",
        "CITY:ANNAPOLIS",
        "PLACE:L",
        "MAP:25-H02-3522",
        "CH:B",
        "CODE:F60",
        "PHONE:443-924-3575",
        "UNIT:E351",
        "TIME:15:38:49",
        "DATE:06/09/13");

    doTest("T30",
        "(_subject_) INCIDENT 201332030\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "SOLOMONS ISLAND RD-AN/ANNAPOLIS HARBOR CTR DR          \n\n" +
        "Grid 20     Map B11     Area 4028     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - SOLOMONS ISLAND RD-AN\n\n" +
        "Second cross street - 19 ARIS T ALLEN BLVD E\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Call back: 301-440-0443\n\n" +
        "FULL ADDR: SOLOMONS ISLAND RD-AN/ANNAPOLIS HARBOR CTR DR\n" +
        "Community of FESTIVAL PLAZA AT RIVA (001559-30)\n" +
        "TAC CHANNEL B ASSIGNED (000777-38)\n\n" +
        "E402  PM35  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 15:22:42          DATE 06/09/13",

        "ID:201332030",
        "CALL:PX TYPE WITH E TK OR SQ - MVC: UNKNOWN STATUS",
        "ADDR:SOLOMONS ISLAND RD & ANNAPOLIS HARBOR CTR DR",
        "CITY:ANNAPOLIS",
        "MAP:20-B11-4028",
        "CH:B",
        "X:SOLOMONS ISLAND RD & 19 ARIS T ALLEN BLVD E",
        "CODE:29B06",
        "PHONE:301-440-0443",
        "PLACE:FESTIVAL PLAZA AT RIVA",
        "INFO:FULL ADDR: SOLOMONS ISLAND RD-AN/ANNAPOLIS HARBOR CTR DR",
        "UNIT:E402  PM35",
        "TIME:15:22:42",
        "DATE:06/09/13");

    doTest("T31",
        "(_subject_) INCIDENT 201332022\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "3538 ROCKWAY AVE          \n\n" +
        "Grid 26     Map D08     Area 0823     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1308 HOLLYWOOD AVE\n\n" +
        "Second cross street - 1314 OAK AVE-EP\n\n" +
        "Nature: 17B03-FALL: UNKNOWN STATUS\n\n" +
        "Call back: 410-269-5667\n\n" +
        "VOIP CALL QUERY CALLER FOR LOCATION QUERY CALLER FOR CALLBK# (001559-30)\n" +
        "ProQaA: 68 Year Old Woman, Conscious, Breathing (001559-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001559-30)\n" +
        "ProQaA: The caller is with the patient. (001559-30)\n" +
        "ProQaA: There is a single patient. (001559-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (001559-30)\n" +
        "ProQaA: It's reported that she fell at ground level. (001559-30)\n" +
        "ProQaA: The reason for the fall is not known. (001559-30)\n" +
        "ProQaA: She is completely awake (alert). (001559-30)\n" +
        "ProQaA: She is breathing normally. (001559-30)\n" +
        "ProQaA: The extent of her injuries is not known. (001559-30)\n" +
        "ProQaA: There is no bleeding now. (001559-30)\n" +
        "Community of ARUNDEL ON THE BAY (001559-30)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (009614-)\n\n" +
        "E84  PM36  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0823\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n" +
        "ARUNDEL ON THE BAY ASSOCIATION PIER: CORNER OF MAGNOLIA AVE AND\n" +
        "NEWPORT AVE.\n" +
        "LOCATION: ON THE GATE TO THE PIER.\n" +
        "INCLUDES: KEY TO THE LOCK ON THE PIER.\n\n" +
        "TIME 14:47:36          DATE 06/09/13",

        "ID:201332022",
        "CALL:BLS WITH FIRST RESPONDER - FALL: UNKNOWN STATUS",
        "ADDR:3538 ROCKWAY AVE",
        "PLACE:ARUNDEL ON THE BAY",
        "MAP:26-D08-0823",
        "CH:B",
        "X:1308 HOLLYWOOD AVE & 1314 OAK AVE",
        "CODE:17B03",
        "PHONE:410-269-5667",
        "INFO:68 Year Old Woman, Conscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that she fell at ground level.\nThe reason for the fall is not known.\nShe is completely awake (alert).\nShe is breathing normally.\nThe extent of her injuries is not known.\nThere is no bleeding now.\nAREA CAUTION NOTES FOR 0823\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\nARUNDEL ON THE BAY ASSOCIATION PIER: CORNER OF MAGNOLIA AVE AND\nNEWPORT AVE.\nLOCATION: ON THE GATE TO THE PIER.\nINCLUDES: KEY TO THE LOCK ON THE PIER.",
        "UNIT:E84  PM36",
        "TIME:14:47:36",
        "DATE:06/09/13");

    doTest("T32",
        "(_subject_) INCIDENT 201332015\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "BLADEN ST/CALVERT ST-AN          \n\n" +
        "Grid 20     Map K09     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - CALVERT ST-AN\n\n" +
        "Second cross street - 92 STATE CIR\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Community of ANNAPOLIS CITY (009614-)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:14:48          DATE 06/09/13\n" +
        "\rINCIDENT 201332015\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "BLADEN ST/CALVERT ST-AN          \n\n" +
        "Grid 20     Map K09     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - CALVERT ST-AN\n\n" +
        "Second cross street - 92 STATE CIR\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Community of ANNAPOLIS CITY (009614-)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:14:48          DATE 06/09/13",

        "ID:201332015",
        "CALL:PX TYPE WITH E TK OR SQ - MVC: UNKNOWN STATUS",
        "ADDR:BLADEN ST & CALVERT ST",
        "CITY:ANNAPOLIS",
        "MAP:20-K09-3821",
        "CH:B",
        "X:CALVERT ST & 92 STATE CIR",
        "CODE:29B06",
        "UNIT:E381  PM39  ATRO",
        "TIME:13:14:48",
        "DATE:06/09/13");

    doTest("T33",
        "(_subject_) INCIDENT 201332000\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "COLLEGE PKWY-AN/GREEN HOLLY DR          \n\n" +
        "Grid 16     Map E12     Area 1901     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 1298 GREEN HOLLY DR\n\n" +
        "Second cross street - 500 BELLERIVE DR\n\n" +
        "Nature: 32B03-UNKNOWN: 3RD PARTY CALL\n\n" +
        "Community of DEEP CREEK (EASTERN) (009623-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E191  PM39  \n\n" +
        "HYDRANTS: 590 COLLEGE PKWY-AN (0) & 588 COLLEGE PKWY-AN (2623)\n" +
        "AREA CAUTION NOTES FOR 1901\n" +
        "STAGING AREA FOR W/R : RAMBLEWOOD DR NEAR GATEWAY DR-E\n" +
        "BOAT RAMP : HARBORVEIW AND GATEWAY DR-E(DEEP CREEK MARINA)\n" +
        "L/Z\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 11:40:25          DATE 06/09/13",

        "ID:201332000",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN: 3RD PARTY CALL",
        "ADDR:COLLEGE PKWY & GREEN HOLLY DR",
        "CITY:ANNAPOLIS",
        "PLACE:DEEP CREEK (EASTERN)",
        "MAP:16-E12-1901",
        "CH:B",
        "X:1298 GREEN HOLLY DR & 500 BELLERIVE DR",
        "CODE:32B03",
        "INFO:HYDRANTS: 590 COLLEGE PKWY-AN (0) & 588 COLLEGE PKWY-AN (2623)\nAREA CAUTION NOTES FOR 1901\nSTAGING AREA FOR W/R : RAMBLEWOOD DR NEAR GATEWAY DR-E\nBOAT RAMP : HARBORVEIW AND GATEWAY DR-E(DEEP CREEK MARINA)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:E191  PM39",
        "TIME:11:40:25",
        "DATE:06/09/13");

    doTest("T34",
        "(_subject_) INCIDENT 201331981\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "23 POCONO DR          \n\n" +
        "Grid 20     Map H02     Area 1712     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21012\n\n" +
        "First cross street - 32 SIERRA LN\n\n" +
        "Second cross street - 1484 GRANDVIEW RD-AR\n\n" +
        "Nature: 21D01-HEMORRHAGE/LAC: DANGEROUS\n\n" +
        "Call back: 410-757-6287\n\n" +
        "ProQaA: VOMITING BLOOD AND FECEES 46 YOM (000825-43)\n" +
        "ProQaA: 46 Year Old Man, Conscious, Breathing (000825-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000825-43)\n" +
        "ProQaA: The caller is not with the patient. (000825-43)\n" +
        "ProQaA: There is a single patient. (000825-43)\n" +
        "ProQaA: The cause of the bleeding is non-traumatic. (000825-43)\n" +
        "ProQaA: The bleeding is from a DANGEROUS area. (000825-43)\n" +
        "ProQaA: He is completely awake (alert). (000825-43)\n" +
        "ProQaA: It's not known if he is breathing normally. (000825-43)\n" +
        "Community of HIDDEN HILLS (000825-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E171  PM39  \n\n" +
        "HYDRANTS: 30 POCONO DR (0) &  ()\n" +
        "AREA CAUTION NOTES FOR 1712\n" +
        "STAGING AREA FOR W/R : WINCHESTER RD\n" +
        "BOAT RAMP : THE END OF BEACH DR. OFF RIVERSIDE DR.\n" +
        "L/Z\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 08:43:24          DATE 06/09/13",

        "ID:201331981",
        "CALL:ONE EMT/P RESPONSE - HEMORRHAGE/LAC: DANGEROUS",
        "ADDR:23 POCONO DR",
        "PLACE:HIDDEN HILLS",
        "MAP:20-H02-1712",
        "CH:B",
        "X:32 SIERRA LN & 1484 GRANDVIEW RD",
        "CODE:21D01",
        "PHONE:410-757-6287",
        "INFO:VOMITING BLOOD AND FECEES 46 YOM\n46 Year Old Man, Conscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is not with the patient.\nThere is a single patient.\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a DANGEROUS area.\nHe is completely awake (alert).\nIt's not known if he is breathing normally.\nHYDRANTS: 30 POCONO DR (0) &  ()\nAREA CAUTION NOTES FOR 1712\nSTAGING AREA FOR W/R : WINCHESTER RD\nBOAT RAMP : THE END OF BEACH DR. OFF RIVERSIDE DR.\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:E171  PM39",
        "TIME:08:43:24",
        "DATE:06/09/13");

    doTest("T35",
        "(_subject_) INCIDENT 201331975\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "502 S CHERRY GROVE AVE          CHESAPEAKE MARKET/CITGO\n\n" +
        "Grid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - SKIPPERS LN-AN\n\n" +
        "Second cross street - 1738 FOREST DR-AN\n\n" +
        "Nature: 09E01-CARDIAC ARREST: WORKABLE ARRES\n\n" +
        "Call back: 410-295-2325\n\n" +
        "ProQaA: 25 Year Old Man, Unconscious, Not Breathing (001559-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001559-30)\n" +
        "ProQaA: The caller is with the patient. (001559-30)\n" +
        "ProQaA: There is a single patient. (001559-30)\n" +
        "Community of ANNAPOLIS CITY (001559-30)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E351  PM35  EMS36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:05:07          DATE 06/09/13INCIDENT 201331975\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "502 S CHERRY GROVE AVE          CHESAPEAKE MARKET/CITGO\n\n" +
        "Grid 20     Map E12     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - SKIPPERS LN-AN\n\n" +
        "Second cross street - 1738 FOREST DR-AN\n\n" +
        "Nature: 09E01-CARDIAC ARREST: WORKABLE ARRES\n\n" +
        "Call back: 410-295-2325\n\n" +
        "ProQaA: 25 Year Old Man, Unconscious, Not Breathing (001559-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (001559-30)\n" +
        "ProQaA: The caller is with the patient. (001559-30)\n" +
        "ProQaA: There is a single patient. (001559-30)\n" +
        "Community of ANNAPOLIS CITY (001559-30)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E351  PM35  EMS36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:05:07          DATE 06/09/13",

        "ID:201331975",
        "CALL:2 EMT/P RESPONSE - CARDIAC ARREST: WORKABLE ARRES",
        "ADDR:502 S CHERRY GROVE AVE",
        "CITY:ANNAPOLIS",
        "PLACE:CHESAPEAKE MARKET/CITGO",
        "MAP:20-E12-3526",
        "CH:B",
        "X:SKIPPERS LN & 1738 FOREST DR",
        "CODE:09E01",
        "PHONE:410-295-2325",
        "INFO:25 Year Old Man, Unconscious, Not Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.",
        "UNIT:E351  PM35  EMS36",
        "TIME:08:05:07",
        "DATE:06/09/13");

    doTest("T36",
        "(_subject_) INCIDENT 201331966\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "7 MIZZEN CT          \n\n" +
        "Grid 26     Map A02     Area 3605     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 996 BREAKWATER DR\n\n" +
        "Nature: 10A01-CHEST PAIN: NORM BREATH <35\n\n" +
        "Call back: 443-699-4749\n\n" +
        "ProQaA: CHEST PAINS TIMES COUPLE HOURS 28 YOM (000825-43)\n" +
        "ProQaA: 28 Year Old Man, Conscious, Breathing (000825-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000825-43)\n" +
        "ProQaA: This is a 1st party caller. (000825-43)\n" +
        "ProQaA: There is a single patient. (000825-43)\n" +
        "ProQaA: He is completely awake (alert). (000825-43)\n" +
        "ProQaA: He is breathing normally. (000825-43)\n" +
        "ProQaA: He is not clammy. (000825-43)\n" +
        "ProQaA: He has no history of heart problems. (000825-43)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (000825-43)\n" +
        "ProQaA: MUCINEX, XANAX (000825-43)\n" +
        "Community of ANNAPOLIS CITY (000825-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 07:02:57          DATE 06/09/13\n" +
        "\rINCIDENT 201331966\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "7 MIZZEN CT          \n\n" +
        "Grid 26     Map A02     Area 3605     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 996 BREAKWATER DR\n\n" +
        "Nature: 10A01-CHEST PAIN: NORM BREATH <35\n\n" +
        "Call back: 443-699-4749\n\n" +
        "ProQaA: CHEST PAINS TIMES COUPLE HOURS 28 YOM (000825-43)\n" +
        "ProQaA: 28 Year Old Man, Conscious, Breathing (000825-43)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000825-43)\n" +
        "ProQaA: This is a 1st party caller. (000825-43)\n" +
        "ProQaA: There is a single patient. (000825-43)\n" +
        "ProQaA: He is completely awake (alert). (000825-43)\n" +
        "ProQaA: He is breathing normally. (000825-43)\n" +
        "ProQaA: He is not clammy. (000825-43)\n" +
        "ProQaA: He has no history of heart problems. (000825-43)\n" +
        "ProQaA: He took a prescribed medication in the past 12hrs: (000825-43)\n" +
        "ProQaA: MUCINEX, XANAX (000825-43)\n" +
        "Community of ANNAPOLIS CITY (000825-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 07:02:57          DATE 06/09/13",

        "ID:201331966",
        "CALL:ONE EMT/P RESPONSE - CHEST PAIN: NORM BREATH <35",
        "ADDR:7 MIZZEN CT",
        "CITY:ANNAPOLIS",
        "MAP:26-A02-3605",
        "CH:B",
        "CODE:10A01",
        "PHONE:443-699-4749",
        "INFO:CHEST PAINS TIMES COUPLE HOURS 28 YOM\n28 Year Old Man, Conscious, Breathing\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThere is a single patient.\nHe is completely awake (alert).\nHe is breathing normally.\nHe is not clammy.\nHe has no history of heart problems.\nHe took a prescribed medication in the past 12hrs:\nMUCINEX, XANAX\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX",
        "UNIT:E361  PM36  ATRO",
        "TIME:07:02:57",
        "DATE:06/09/13");

    doTest("T37",
        "(_subject_) INCIDENT 201331963\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "701 GLENWOOD ST     213     GLENWOOD HIGHRISE\n\n" +
        "Grid 20     Map H09     Area 3813     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 HARWOOD PLACE\n\n" +
        "Second cross street - 600 ADAMS PARK RD\n\n" +
        "Nature: 17B01-FALL: POSSIBLY DANGEROUS\n\n" +
        "Community of ANNAPOLIS CITY (000716-38)\n" +
        "TAC CHANNEL B ASSIGNED (009611-35)\n\n" +
        "PM39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "SIDE C TO RIGHT ON ENTRANCE DOOR.\n" +
        "17415\n" +
        "CONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\n" +
        "FULLY SPRINKLERED.\n" +
        "19008\n" +
        "STANDPIPES IN EACH STAIR TOWER.\n" +
        "FDC AT SIDE C/D CORNER.\n" +
        "FIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\n" +
        "ENTRANCE).\n" +
        "FLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.\n\n" +
        "TIME 06:15:19          DATE 06/09/13",

        "ID:201331963",
        "CALL:BLS WITH FIRST RESPONDER - FALL: POSSIBLY DANGEROUS",
        "ADDR:701 GLENWOOD ST",
        "APT:213",
        "CITY:ANNAPOLIS",
        "PLACE:GLENWOOD HIGHRISE",
        "MAP:20-H09-3813",
        "CH:B",
        "X:400 HARWOOD PLACE & 600 ADAMS PARK RD",
        "CODE:17B01",
        "INFO:SIDE C TO RIGHT ON ENTRANCE DOOR.\n17415\nCONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\nFULLY SPRINKLERED.\n19008\nSTANDPIPES IN EACH STAIR TOWER.\nFDC AT SIDE C/D CORNER.\nFIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\nENTRANCE).\nFLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.",
        "UNIT:PM39",
        "TIME:06:15:19",
        "DATE:06/09/13");

    doTest("T38",
        "(_subject_) INCIDENT 201331954\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "1100 E COLLEGE PKWY          SANDY POINT STATE PARK\n\n" +
        "Grid 22     Map B06     Area 1912     Preplan      Channel I    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - OCEANIC DR\n\n" +
        "Second cross street - E BEACH RD\n\n" +
        "Nature: F60-SERVICE CALL (COLD)\n\n" +
        "Call back: 410-974-2149\n\n" +
        "Community of WALNUT RIDGE (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (000557-42)\n" +
        "Units 'on air': A419 (000557-42)\n" +
        "Tactical channel changed from B to H (000557-42)\n" +
        "Tactical channel changed from H to I (000557-42)\n" +
        "Units 'on air': FB36 (000557-42)\n\n" +
        "A419  CW2  CW3  FB41  PM17  FB36  \n\n" +
        "HYDRANTS: 1100 COLLEGE PKWY (BOAT RAMP) (0) & 1100 COLLEGE PKWY (BAIT SHOP) (0)\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 1912\n" +
        "STAGING AREA FOR W/R : SOUTH BEACH RD (SANDY PT STATE PARK)OR\n" +
        "                     : WESTINGHOUSE PARKING LOT\n" +
        "BOAT RAMP : SOUTH BEACH RD (SANDY PT STATE PARK)\n" +
        "L/Z\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 05:02:13          DATE 06/09/13",

        "ID:201331954",
        "CALL:SPECIAL - UNIT REFERENCE CARD - SERVICE CALL (COLD)",
        "ADDR:1100 E COLLEGE PKWY",
        "PLACE:SANDY POINT STATE PARK",
        "MAP:22-B06-1912",
        "CH:I",
        "X:OCEANIC DR & E BEACH RD",
        "CODE:F60",
        "PHONE:410-974-2149",
        "INFO:HYDRANTS: 1100 COLLEGE PKWY (BOAT RAMP) (0) & 1100 COLLEGE PKWY (BAIT SHOP) (0)\nCAUTION NOTES\nAREA CAUTION NOTES FOR 1912\nSTAGING AREA FOR W/R : SOUTH BEACH RD (SANDY PT STATE PARK)OR\n: WESTINGHOUSE PARKING LOT\nBOAT RAMP : SOUTH BEACH RD (SANDY PT STATE PARK)\nL/Z\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:A419  CW2  CW3  FB41  PM17  FB36",
        "TIME:05:02:13",
        "DATE:06/09/13");

    doTest("T39",
        "(_subject_) INCIDENT 201331956\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "768 FAIRVIEW AVE-EP     B     \n\n" +
        "Grid 21     Map A13     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - CROSS ST-EP\n\n" +
        "Nature: 06D01-BREATHING PROB: SEVERE DISTRES\n\n" +
        "Call back: 443-255-7376\n\n" +
        "ProQaA: 74 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009617-30)\n" +
        "ProQaA: The caller is not with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: She is able to talk. (009617-30)\n" +
        "ProQaA: She has difficulty speaking between breaths. (009617-30)\n" +
        "ProQaA: She is completely awake (alert). (009617-30)\n" +
        "ProQaA: It's not known if she is changing color. (009617-30)\n" +
        "ProQaA: It's not known if she is clammy. (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (000557-42)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 05:19:27          DATE 06/09/13\n" +
        "\rINCIDENT 201331956\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "768 FAIRVIEW AVE-EP     B     \n\n" +
        "Grid 21     Map A13     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - CROSS ST-EP\n\n" +
        "Nature: 06D01-BREATHING PROB: SEVERE DISTRES\n\n" +
        "Call back: 443-255-7376\n\n" +
        "ProQaA: 74 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009617-30)\n" +
        "ProQaA: The caller is not with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: She is able to talk. (009617-30)\n" +
        "ProQaA: She has difficulty speaking between breaths. (009617-30)\n" +
        "ProQaA: She is completely awake (alert). (009617-30)\n" +
        "ProQaA: It's not known if she is changing color. (009617-30)\n" +
        "ProQaA: It's not known if she is clammy. (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (000557-42)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 05:19:27          DATE 06/09/13",

        "ID:201331956",
        "CALL:ONE EMT/P RESPONSE - BREATHING PROB: SEVERE DISTRES",
        "ADDR:768 FAIRVIEW AVE",
        "CITY:ANNAPOLIS",
        "PLACE:B",
        "MAP:21-A13-3602",
        "CH:B",
        "X:CROSS ST",
        "CODE:06D01",
        "PHONE:443-255-7376",
        "INFO:74 Year Old Woman, Conscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is not with the patient.\nThere is a single patient.\nShe is able to talk.\nShe has difficulty speaking between breaths.\nShe is completely awake (alert).\nIt's not known if she is changing color.\nIt's not known if she is clammy.",
        "UNIT:E361  PM36  ATRO",
        "TIME:05:19:27",
        "DATE:06/09/13");

    doTest("T40",
        "(_subject_) INCIDENT 201331951\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "1110 MADISON ST-AN     B2     \n\n" +
        "Grid 20     Map K12     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 8 SPA CREEK LANDING\n\n" +
        "Second cross street - 1000 PRESIDENT ST\n\n" +
        "Nature: 26A01-SICK PERSON/ NO PRIORITY COMPL\n\n" +
        "Call back: 410-212-1975\n\n" +
        "ProQaA: 47 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009617-30)\n" +
        "ProQaA: This is a 1st party caller. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: She is breathing normally. (009617-30)\n" +
        "ProQaA: She does not have chest pain. (009617-30)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (009617-30)\n" +
        "ProQaA: She is completely awake (alert). (009617-30)\n" +
        "ProQaA: She has no history of heart problems. (009617-30)\n" +
        "ProQaA: No priority symptoms (conditions 2-28 not identified). (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (000557-42)\n\n" +
        "PM36  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "KNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n" +
        "19256\n" +
        "BY THE MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\n" +
        "TIME 03:46:21          DATE 06/09/13",

        "ID:201331951",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON/ NO PRIORITY COMPL",
        "ADDR:1110 MADISON ST",
        "CITY:ANNAPOLIS",
        "PLACE:B2",
        "MAP:20-K12-3602",
        "CH:B",
        "X:8 SPA CREEK LANDING & 1000 PRESIDENT ST",
        "CODE:26A01",
        "PHONE:410-212-1975",
        "INFO:47 Year Old Woman, Conscious, Breathing\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThere is a single patient.\nShe is breathing normally.\nShe does not have chest pain.\nShe is not bleeding (or vomiting blood).\nShe is completely awake (alert).\nShe has no history of heart problems.\nNo priority symptoms (conditions 2-28 not identified).\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A\nKNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n19256\nBY THE MAIN ENTRANCE AT THE TOP OF THE RAMP.",
        "UNIT:PM36",
        "TIME:03:46:21",
        "DATE:06/09/13");

    doTest("T41",
        "(_subject_) INCIDENT 201331944\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "CHESTERFIELD RD-AN/BRAMLEIGH LN          \n\n" +
        "Grid 19     Map D06     Area 4014     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 960 BRAMLEIGH LN\n\n" +
        "Second cross street - 1800 CROSSPOINTE DR\n\n" +
        "Nature: 29B01-MVC: W/INJURIES\n\n" +
        "Community of SYLMAC (000716-38)\n" +
        "TAC CHANNEL B ASSIGNED (001571-)\n\n" +
        "E402  PM35  A79  \n\n" +
        "HYDRANTS:  (0) & 891 CHESTERFIELD RD-AN (2118)\n\n" +
        "TIME 02:28:41          DATE 06/09/13",

        "ID:201331944",
        "CALL:PX TYPE WITH E TK OR SQ - MVC: W/INJURIES",
        "ADDR:CHESTERFIELD RD & BRAMLEIGH LN",
        "CITY:ANNAPOLIS",
        "PLACE:SYLMAC",
        "MAP:19-D06-4014",
        "CH:B",
        "X:960 BRAMLEIGH LN & 1800 CROSSPOINTE DR",
        "CODE:29B01",
        "INFO:HYDRANTS:  (0) & 891 CHESTERFIELD RD-AN (2118)",
        "UNIT:E402  PM35  A79",
        "TIME:02:28:41",
        "DATE:06/09/13");

    doTest("T42",
        "(_subject_) INCIDENT 201331900\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "170 MAYO RD-EW          LONDONTOWN COMMUNITY HALL\n\n" +
        "Grid 24     Map K05     Area 0224     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 1904 BLUE RIDGE RD\n\n" +
        "Second cross street - 300 SALISBURY RD\n\n" +
        "Nature: 31C01-FAINTING: ABNORMAL BREATH\n\n" +
        "Call back: 410-956-4808\n\n" +
        "Community of WOODLAND BEACH (001571-)\n" +
        "Added unit 'SQ2' via 'X' at Tac  (001571-)\n" +
        "TAC CHANNEL B ASSIGNED (001571-)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (001571-)\n\n" +
        "ME2  PM35  SQ2  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 0224\n" +
        "STAGING AREA FOR W/R: STATION 2\n" +
        "BOAT RAMP: GRANGE RD & SHORE DR.\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 20:33:38          DATE 06/08/13",

        "ID:201331900",
        "CALL:ONE EMT/P RESPONSE - FAINTING: ABNORMAL BREATH",
        "ADDR:170 MAYO RD",
        "CITY:EDGEWATER",
        "PLACE:LONDONTOWN COMMUNITY HALL",
        "MAP:24-K05-0224",
        "CH:B",
        "X:1904 BLUE RIDGE RD & 300 SALISBURY RD",
        "CODE:31C01",
        "PHONE:410-956-4808",
        "INFO:CAUTION NOTES\nAREA CAUTION NOTES FOR 0224\nSTAGING AREA FOR W/R: STATION 2\nBOAT RAMP: GRANGE RD & SHORE DR.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  PM35  SQ2",
        "TIME:20:33:38",
        "DATE:06/08/13");

    doTest("T43",
        "(_subject_) INCIDENT 201331891\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "701 GLENWOOD ST     706     GLENWOOD HIGHRISE\n\n" +
        "Grid 20     Map H09     Area 3813     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 400 HARWOOD PLACE\n\n" +
        "Second cross street - 600 ADAMS PARK RD\n\n" +
        "Nature: 01C01-ABDOM PAIN: W/FAINT >=50\n\n" +
        "Call back: 410-571-3093\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000716-38)\n" +
        "ProQaA: AB PAIN (000716-38)\n" +
        "ProQaA: 57 Year Old Man, Conscious, Breathing (000716-38)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000716-38)\n" +
        "ProQaA: This is a 1st party caller. (000716-38)\n" +
        "ProQaA: There is a single patient. (000716-38)\n" +
        "ProQaA: He is completely awake (alert). (000716-38)\n" +
        "ProQaA: He has not fainted. (000716-38)\n" +
        "ProQaA: He had a near fainting episode. (000716-38)\n" +
        "ProQaA: He does not have pain above the belly button (navel). (000716-38)\n" +
        "Community of ANNAPOLIS CITY (000716-38)\n" +
        "ProQa: AB PAIN (000716-38)\n" +
        "TAC CHANNEL B ASSIGNED (009611-)\n\n" +
        "PM39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "SIDE C TO RIGHT ON ENTRANCE DOOR.\n" +
        "17415\n" +
        "CONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\n" +
        "FULLY SPRINKLERED.\n" +
        "19008\n" +
        "STANDPIPES IN EACH STAIR TOWER.\n" +
        "FDC AT SIDE C/D CORNER.\n" +
        "FIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\n" +
        "ENTRANCE).\n" +
        "FLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.\n\n" +
        "TIME 19:53:44          DATE 06/08/13",

        "ID:201331891",
        "CALL:BLS WITH FIRST RESPONDER - ABDOM PAIN: W/FAINT >=50",
        "ADDR:701 GLENWOOD ST",
        "APT:706",
        "CITY:ANNAPOLIS",
        "PLACE:GLENWOOD HIGHRISE",
        "MAP:20-H09-3813",
        "CH:B",
        "X:400 HARWOOD PLACE & 600 ADAMS PARK RD",
        "CODE:01C01",
        "PHONE:410-571-3093",
        "INFO:AB PAIN\n57 Year Old Man, Conscious, Breathing\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThere is a single patient.\nHe is completely awake (alert).\nHe has not fainted.\nHe had a near fainting episode.\nHe does not have pain above the belly button (navel).\nProQa: AB PAIN\nSIDE C TO RIGHT ON ENTRANCE DOOR.\n17415\nCONTAINS DIRECT ACCESS KEYS TO ENTRANCE DOOR AND NORTH & SOUTH STAIRWAYS.\nFULLY SPRINKLERED.\n19008\nSTANDPIPES IN EACH STAIR TOWER.\nFDC AT SIDE C/D CORNER.\nFIRE ALARM PANEL IN TRASH ROOM (OVERHEAD ROLL-UP DOOR, RIGHT OF SIDE C\nENTRANCE).\nFLOORS 2-8 HAVE SHUTOFF VALVES IN EACH STAIRWELL. BOTH MUST BE TURNED OFF.",
        "UNIT:PM39",
        "TIME:19:53:44",
        "DATE:06/08/13");

    doTest("T44",
        "(_subject_) INCIDENT 201331873\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "1401 CIRCLE DR-EW          \n\n" +
        "Grid 24     Map K04     Area 0222     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 1410 PARK RD-EW\n\n" +
        "Nature: F50-ODOR OF SMOKE INSIDE (WARM)\n\n" +
        "Call back: 410-956-8988\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\n" +
        "IN BASEMENT (000557-42)\n" +
        "Community of SOUTH RIVER PARK (000557-42)\n" +
        "TAC CHANNEL E ASSIGNED (001571-)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (001571-)\n" +
        "Units 'on air': SQ2 (001571-)\n\n" +
        "ME2  E351  SQ2  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0222\n" +
        "STAGING AREA FOR W/R: EDGEWATER ELEMENTARY\n" +
        "BOAT RAMP: RIVERSIDE RD AND PARK RD\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 18:20:51          DATE 06/08/13",

        "ID:201331873",
        "CALL:STILL ALARM - ODOR OF SMOKE INSIDE (WARM)",
        "ADDR:1401 CIRCLE DR",
        "CITY:EDGEWATER",
        "PLACE:SOUTH RIVER PARK",
        "MAP:24-K04-0222",
        "CH:E",
        "X:1410 PARK RD",
        "CODE:F50",
        "PHONE:410-956-8988",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nIN BASEMENT\nAREA CAUTION NOTES FOR 0222\nSTAGING AREA FOR W/R: EDGEWATER ELEMENTARY\nBOAT RAMP: RIVERSIDE RD AND PARK RD\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  E351  SQ2",
        "TIME:18:20:51",
        "DATE:06/08/13");

    doTest("T45",
        "(_subject_) INCIDENT 201331868\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "101 KUETHE DR          \n\n" +
        "Grid 25     Map K05     Area 0817     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 601 HILLSMERE DR\n\n" +
        "Nature: 31D01-UNCONSCIOUS\n\n" +
        "Call back: 410-268-5339\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\n" +
        "ProQaA: FALL (000557-42)\n" +
        "ProQaA: 2 Year Old Boy, Unconscious, Breathing (000557-42)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000557-42)\n" +
        "ProQaA: The caller is with the patient. (000557-42)\n" +
        "ProQaA: There is a single patient. (000557-42)\n" +
        "ProQaA: He is not breathing normally. (000557-42)\n" +
        "ProQaA: He is breathing normally. (000557-42)\n" +
        "ProQaA: It's not known if he is breathing normally. (000557-42)\n" +
        "ProQaA: He has no history of heart problems. (000557-42)\n" +
        "ProQaA: He is still unconscious. (000557-42)\n" +
        "CHILD STRUCK HIS HEAD (000557-42)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (009611-35)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (009611-35)\n\n" +
        "E84  MU8  PM36  TRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 18:04:54          DATE 06/08/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   06/08/13   18:06:14\n\n" +
        "BURN CENTER (BA    REROUTE",

        "ID:201331868",
        "CALL:2 EMT/P RESPONSE - UNCONSCIOUS",
        "ADDR:101 KUETHE DR",
        "PLACE:HILLSMERE SHORES-(IN COUNTY)",
        "MAP:25-K05-0817",
        "CH:B",
        "X:601 HILLSMERE DR",
        "CODE:31D01",
        "PHONE:410-268-5339",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nFALL\n2 Year Old Boy, Unconscious, Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.\nHe is not breathing normally.\nHe is breathing normally.\nIt's not known if he is breathing normally.\nHe has no history of heart problems.\nHe is still unconscious.\nCHILD STRUCK HIS HEAD\nCAUTION NOTES\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  MU8  PM36  TRO",
        "TIME:18:04:54",
        "DATE:06/08/13");

    doTest("T46",
        "(_subject_) INCIDENT 201331863\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "722 CHILDS POINT RD          \n\n" +
        "Grid 20     Map D13     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 316 EATONS LANDING DR\n\n" +
        "Second cross street - 704 PILOT HOUSE DR\n\n" +
        "Nature: 32B01-UNKNOWN: PERSON MOVING\n\n" +
        "Call back: 8911\n\n" +
        "AAPD ENROUTE (000557-42)\n" +
        "Community of BYWATER ESTATES (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (001571-)\n" +
        "Units 'on air': PM39, E381 (001571-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 17:34:02          DATE 06/08/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   06/08/13   17:34:49\n\n" +
        "BURN CENTER (BA    REROUTE\n\n" +
        "\rINCIDENT 201331863\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "722 CHILDS POINT RD          \n\n" +
        "Grid 20     Map D13     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 316 EATONS LANDING DR\n\n" +
        "Second cross street - 704 PILOT HOUSE DR\n\n" +
        "Nature: 32B01-UNKNOWN: PERSON MOVING\n\n" +
        "Call back: 8911\n\n" +
        "AAPD ENROUTE (000557-42)\n" +
        "Community of BYWATER ESTATES (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (001571-)\n" +
        "Units 'on air': PM39, E381 (001571-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 17:34:02          DATE 06/08/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   06/08/13   17:34:49\n\n" +
        "BURN CENTER (BA    REROUTE",

        "ID:201331863",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN: PERSON MOVING",
        "ADDR:722 CHILDS POINT RD",
        "PLACE:BYWATER ESTATES",
        "MAP:20-D13-3526",
        "CH:B",
        "X:316 EATONS LANDING DR & 704 PILOT HOUSE DR",
        "CODE:32B01",
        "PHONE:8911",
        "INFO:AAPD ENROUTE",
        "UNIT:E381  PM39  ATRO",
        "TIME:17:34:02",
        "DATE:06/08/13");

    doTest("T47",
        "(_subject_) INCIDENT 201331858\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "821 BETSY CT          \n\n" +
        "Grid 20     Map E13     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 798 NEWTOWNE DR\n\n" +
        "Nature: F42-MISCELLANEOUS FIRE (SPVR)\n\n" +
        "Call back: 410-263-6237\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-42)\n" +
        "BASKETBALL COURT ON FIRE (000557-42)\n" +
        "Community of ANNAPOLIS CITY (000557-42)\n" +
        "TAC CHANNEL B ASSIGNED (001571-)\n\n" +
        "E351  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 17:04:07          DATE 06/08/13",

        "ID:201331858",
        "CALL:LOCAL ALARM - MISCELLANEOUS FIRE (SPVR)",
        "ADDR:821 BETSY CT",
        "CITY:ANNAPOLIS",
        "MAP:20-E13-3526",
        "CH:B",
        "CODE:F42",
        "PHONE:410-263-6237",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nBASKETBALL COURT ON FIRE",
        "UNIT:E351",
        "TIME:17:04:07",
        "DATE:06/08/13");

    doTest("T48",
        "(_subject_) INCIDENT 201331842\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2 COMPROMISE ST          ANNAPOLIS YACHT CLUB\n\n" +
        "Grid 21     Map A11     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 6TH ST-AN\n\n" +
        "Nature: 28C03-STROKE: SPEECH/MOVMENT PROB\n\n" +
        "Call back: 202-716-1103\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000829-30)\n" +
        "ProQaA: 78 Year Old Man, Conscious, Breathing (000829-30)\n" +
        "ProQaA: He has flu symptoms. (000829-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000829-30)\n" +
        "ProQaA: The caller is with the patient. (000829-30)\n" +
        "ProQaA: There is a single patient. (000829-30)\n" +
        "ProQaA: He is completely awake (alert). (000829-30)\n" +
        "ProQaA: He is breathing normally. (000829-30)\n" +
        "ProQaA: He is able to talk normally. (000829-30)\n" +
        "ProQaA: He is having movement problems. (000829-30)\n" +
        "ProQaA: He was last reported to be without this problem: (000829-30)\n" +
        "ProQaA: THIS AM (000829-30)\n" +
        "TAN (000829-30)\n" +
        "Community of ANNAPOLIS CITY (000829-30)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "KNOX BOX\n" +
        "KNOX BOX LOCATED TO THE LEFT OF THE MAIN ENTRY DOORS.\n" +
        "19293\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "ONLY THE BUILDING AT END OF PIER IS SPRINKLERED.\n" +
        "18995\n" +
        "THE FDC IS FACING COMPROMISE ST ON A TWO STORY BUILDING IN THE PARKING LOT.\n" +
        "MAIN VALVE BEHIND FDC.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 15:51:08          DATE 06/08/13\n" +
        "\rINCIDENT 201331842\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2 COMPROMISE ST          ANNAPOLIS YACHT CLUB\n\n" +
        "Grid 21     Map A11     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 6TH ST-AN\n\n" +
        "Nature: 28C03-STROKE: SPEECH/MOVMENT PROB\n\n" +
        "Call back: 202-716-1103\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000829-30)\n" +
        "ProQaA: 78 Year Old Man, Conscious, Breathing (000829-30)\n" +
        "ProQaA: He has flu symptoms. (000829-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000829-30)\n" +
        "ProQaA: The caller is with the patient. (000829-30)\n" +
        "ProQaA: There is a single patient. (000829-30)\n" +
        "ProQaA: He is completely awake (alert). (000829-30)\n" +
        "ProQaA: He is breathing normally. (000829-30)\n" +
        "ProQaA: He is able to talk normally. (000829-30)\n" +
        "ProQaA: He is having movement problems. (000829-30)\n" +
        "ProQaA: He was last reported to be without this problem: (000829-30)\n" +
        "ProQaA: THIS AM (000829-30)\n" +
        "TAN (000829-30)\n" +
        "Community of ANNAPOLIS CITY (000829-30)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "KNOX BOX\n" +
        "KNOX BOX LOCATED TO THE LEFT OF THE MAIN ENTRY DOORS.\n" +
        "19293\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "ONLY THE BUILDING AT END OF PIER IS SPRINKLERED.\n" +
        "18995\n" +
        "THE FDC IS FACING COMPROMISE ST ON A TWO STORY BUILDING IN THE PARKING LOT.\n" +
        "MAIN VALVE BEHIND FDC.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 15:51:08          DATE 06/08/13",

        "ID:201331842",
        "CALL:ONE EMT/P RESPONSE - STROKE: SPEECH/MOVMENT PROB",
        "ADDR:2 COMPROMISE ST",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS YACHT CLUB",
        "MAP:21-A11-3824",
        "CH:B",
        "X:6TH ST",
        "CODE:28C03",
        "PHONE:202-716-1103",
        "INFO:78 Year Old Man, Conscious, Breathing\nHe has flu symptoms.\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.\nHe is completely awake (alert).\nHe is breathing normally.\nHe is able to talk normally.\nHe is having movement problems.\nHe was last reported to be without this problem:\nTHIS AM\nTAN\nCAUTION NOTES\nKNOX BOX\nKNOX BOX LOCATED TO THE LEFT OF THE MAIN ENTRY DOORS.\n19293\nAUTO SPRINKLER SYSTEM\nONLY THE BUILDING AT END OF PIER IS SPRINKLERED.\n18995\nTHE FDC IS FACING COMPROMISE ST ON A TWO STORY BUILDING IN THE PARKING LOT.\nMAIN VALVE BEHIND FDC.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  PM39  ATRO",
        "TIME:15:51:08",
        "DATE:06/08/13");

    doTest("T49",
        "(_subject_) INCIDENT 201331836\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1121 LAKE HERON DR     1     \n\n" +
        "Grid 26     Map B01     Area 3605     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1102 PINEMONT PL\n\n" +
        "Second cross street - 1200 OAK HILL PL\n\n" +
        "Nature: 06C01-BREATHING PROB: ABNORMAL\n\n" +
        "Call back: 443-949-0942\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000829-30)\n" +
        "ProQaA: BACK PAIN (000829-30)\n" +
        "ProQaA: 47 Year Old Woman, Conscious, Breathing (000829-30)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (000829-30)\n" +
        "ProQaA: This is a 1st party caller. (000829-30)\n" +
        "ProQaA: There is a single patient. (000829-30)\n" +
        "ProQaA: This started (happened) more than 6hrs ago. (000829-30)\n" +
        "ProQaA: The cause of her back pain is reportedly a non-traumatic (000829-30)\n" +
        "ProQaA: medical condition. (000829-30)\n" +
        "ProQaA: She is having difficulty breathing. (000829-30)\n" +
        "ProQaA: She is able to talk. (000829-30)\n" +
        "ProQaA: She does not have any difficulty speaking between breaths. (000829-30)\n" +
        "ProQaA: She is completely awake (alert). (000829-30)\n" +
        "ProQaA: She is not clammy. (000829-30)\n" +
        "ProQaA: She has no history of heart problems. (000829-30)\n" +
        "ProQaA: She has asthma. (000829-30)\n" +
        "ProQaA: She has a prescribed inhaler. (000829-30)\n" +
        "ProQaA: She has used a prescribed inhaler. (000829-30)\n" +
        "ProQaA: N/A (000829-30)\n" +
        "Community of ANNAPOLIS CITY (000829-30)\n" +
        "ProQa: BACK PAIN (000829-30)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E361  MU8  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "FIRE ALARM PANEL IN UTILITY CLOSET, SIDE D.\n" +
        "19208\n" +
        "COMBINATION IS 130\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 15:14:06          DATE 06/08/13",

        "ID:201331836",
        "CALL:ONE EMT/P RESPONSE - BREATHING PROB: ABNORMAL",
        "ADDR:1121 LAKE HERON DR",
        "APT:1",
        "CITY:ANNAPOLIS",
        "MAP:26-B01-3605",
        "CH:B",
        "X:1102 PINEMONT PL & 1200 OAK HILL PL",
        "CODE:06C01",
        "PHONE:443-949-0942",
        "INFO:BACK PAIN\n47 Year Old Woman, Conscious, Breathing\nECHO was not selected from Case Entry.\nThis is a 1st party caller.\nThere is a single patient.\nThis started (happened) more than 6hrs ago.\nThe cause of her back pain is reportedly a non-traumatic\nmedical condition.\nShe is having difficulty breathing.\nShe is able to talk.\nShe does not have any difficulty speaking between breaths.\nShe is completely awake (alert).\nShe is not clammy.\nShe has no history of heart problems.\nShe has asthma.\nShe has a prescribed inhaler.\nShe has used a prescribed inhaler.\nN/A\nProQa: BACK PAIN\nFIRE ALARM PANEL IN UTILITY CLOSET, SIDE D.\n19208\nCOMBINATION IS 130\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX",
        "UNIT:E361  MU8  ATRO",
        "TIME:15:14:06",
        "DATE:06/08/13");

    doTest("T50",
        "(_subject_) INCIDENT 201331833\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "2001 MEDICAL PKWY          AA MEDICAL CENTER HOSPITAL\n\n" +
        "Grid 20     Map C08     Area 4024B     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - RT50 W-AN\n\n" +
        "Nature: F05H-HI LIFE/ALARMS SOUNDING (WARM)\n\n" +
        "Community of ANNE ARUNDEL MEDICAL OFFICE BLDGS (009624-43)\n" +
        "TAC CHANNEL E ASSIGNED (009617-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009617-)\n" +
        "Unit 'E462' had changed quarters for unit 'QNT46' (009617-)\n" +
        "Units 'on air': BC35, BC3 (009617-)\n\n" +
        "E402  E381  E461  E462  TW40  LAD39  SQ2  PM40  BC35  BC3  SCA  \n\n" +
        "HYDRANTS:  (0) &  (0)\n\n" +
        "CAUTION NOTES\n\n" +
        "TIME 14:59:52          DATE 06/08/13",

        "ID:201331833",
        "CALL:COMMERCIAL BOX - HI LIFE/ALARMS SOUNDING (WARM)",
        "ADDR:2001 MEDICAL PKWY",
        "PLACE:AA MEDICAL CENTER HOSPITAL",
        "MAP:20-C08-4024B",
        "CH:E",
        "X:RT50 W",
        "CODE:F05H",
        "INFO:CAUTION NOTES",
        "UNIT:E402  E381  E461  E462  TW40  LAD39  SQ2  PM40  BC35  BC3  SCA",
        "TIME:14:59:52",
        "DATE:06/08/13");

    doTest("T51",
        "(_subject_) INCIDENT 201331832\n\n" +
        "CODE LZ     LANDING ZONE     ALARM 1\n\n" +
        "1399 FOREST DR-EP          ANNAPOLIS MIDDLE SCHOOL\n\n" +
        "Grid 20     Map G13     Area 0813     Preplan      Channel C    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street -  OLD FOREST DR\n\n" +
        "Second cross street -  YOUNGS FARM RD\n\n" +
        "Nature: F82-HELICOPTER LANDING SITE (HOT)\n\n" +
        "Call back: 410-267-8658\n\n" +
        "Community of ANNAPOLIS JUNIOR HIGH SCHOOL (009617-)\n" +
        "TAC CHANNEL C ASSIGNED (009617-)\n\n" +
        "E351  TRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0813\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 14:52:51          DATE 06/08/13",

        "ID:201331832",
        "CALL:LANDING ZONE - HELICOPTER LANDING SITE (HOT)",
        "ADDR:1399 FOREST DR",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS MIDDLE SCHOOL",
        "MAP:20-G13-0813",
        "CH:C",
        "X:OLD FOREST DR & YOUNGS FARM RD",
        "CODE:F82",
        "PHONE:410-267-8658",
        "INFO:AREA CAUTION NOTES FOR 0813\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E351  TRO",
        "TIME:14:52:51",
        "DATE:06/08/13");

    doTest("T52",
        "(_subject_) INCIDENT 201331830\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "HILLSMERE DR/MAGNOLIA LN          \n\n" +
        "Grid 25     Map J04     Area 0817     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 100 MAGNOLIA LN\n\n" +
        "Second cross street - 300 BEACH DR-EP\n\n" +
        "Nature: 29D02B-MVC: INVOLVING BIKE/MOTORCYCLE\n\n" +
        "Call back: 410-320-6079\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000829-30)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (000829-30)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000582-38)\n\n" +
        "E84  PM35  TRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 14:42:39          DATE 06/08/13",

        "ID:201331830",
        "CALL:2 EMT/P RESPONSE - MVC: INVOLVING BIKE/MOTORCYCLE",
        "ADDR:HILLSMERE DR & MAGNOLIA LN",
        "PLACE:HILLSMERE SHORES-(IN COUNTY)",
        "MAP:25-J04-0817",
        "CH:B",
        "X:100 MAGNOLIA LN & 300 BEACH DR",
        "CODE:29D02B",
        "PHONE:410-320-6079",
        "INFO:AREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  PM35  TRO",
        "TIME:14:42:39",
        "DATE:06/08/13");

    doTest("T53",
        "(_subject_) INCIDENT 201331809\n\n" +
        "CODE M     ALS W/O FIRST RESPONDER     ALARM 1\n\n" +
        "620 TAYLOR AVE-AN          TAYLOR AVE FIRE STATION\n\n" +
        "Grid 20     Map J08     Area 3811     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 RIDGELY AVE\n\n" +
        "Second cross street - 302 ROSCOE ROWE BLVD\n\n" +
        "Nature: 10C01-CHEST PAIN: ABNORMAL BREATH\n\n" +
        "Call back: 410-222-8239\n\n" +
        "Community of AACO FIRE-WATER WITCH CO 39 (009624-43)\n" +
        "TAC CHANNEL B ASSIGNED (009605-)\n\n" +
        "PM39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "FULLY SPRINKLERED.\n" +
        "19263\n" +
        "FDC ON SIDE 4.\n" +
        "MAIN VALVE INSIDE, BEHIND FDC.\n\n" +
        "TIME 12:30:17          DATE 06/08/13",

        "ID:201331809",
        "CALL:ALS W/O FIRST RESPONDER - CHEST PAIN: ABNORMAL BREATH",
        "ADDR:620 TAYLOR AVE",
        "CITY:ANNAPOLIS",
        "PLACE:TAYLOR AVE FIRE STATION",
        "MAP:20-J08-3811",
        "CH:B",
        "X:2 RIDGELY AVE & 302 ROSCOE ROWE BLVD",
        "CODE:10C01",
        "PHONE:410-222-8239",
        "INFO:CAUTION NOTES\nAUTO SPRINKLER SYSTEM\nFULLY SPRINKLERED.\n19263\nFDC ON SIDE 4.\nMAIN VALVE INSIDE, BEHIND FDC.",
        "UNIT:PM39",
        "TIME:12:30:17",
        "DATE:06/08/13");

    doTest("T54",
        "(_subject_) INCIDENT 201331801\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "507 TULIP RD-EP          \n\n" +
        "Grid 25     Map D02     Area 0812     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2702 WILLOW HILL RD\n\n" +
        "Nature: F25-ELECTRIC WIRES OUTSIDE (COLD)\n\n" +
        "Call back: 443-994-4154\n\n" +
        "WIRELESS CALLER VERIFY LOCATION VERIFY CALLBK# (009624-43)\n" +
        "Community of WILD ROSE SHORES (009624-43)\n" +
        "TAC CHANNEL B ASSIGNED (009605-)\n\n" +
        "E351  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0812\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 11:58:34          DATE 06/08/13",

        "ID:201331801",
        "CALL:LOCAL ALARM - ELECTRIC WIRES OUTSIDE (COLD)",
        "ADDR:507 TULIP RD",
        "CITY:ANNAPOLIS",
        "PLACE:WILD ROSE SHORES",
        "MAP:25-D02-0812",
        "CH:B",
        "X:2702 WILLOW HILL RD",
        "CODE:F25",
        "PHONE:443-994-4154",
        "INFO:AREA CAUTION NOTES FOR 0812\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E351",
        "TIME:11:58:34",
        "DATE:06/08/13");

    doTest("T55",
        "(_subject_) INCIDENT 201331796\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "1283 GRAFF CT          \n\n" +
        "Grid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 1290 THOM DR\n\n" +
        "Nature: F60-SERVICE CALL (COLD)\n\n" +
        "Community of ANNAPOLIS CITY (009624-43)\n" +
        "TAC CHANNEL B ASSIGNED (009605-)\n\n" +
        "E361  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 11:05:25          DATE 06/08/13",

        "ID:201331796",
        "CALL:SPECIAL - UNIT REFERENCE CARD - SERVICE CALL (COLD)",
        "ADDR:1283 GRAFF CT",
        "CITY:ANNAPOLIS",
        "MAP:25-J01-3603",
        "CH:B",
        "CODE:F60",
        "UNIT:E361",
        "TIME:11:05:25",
        "DATE:06/08/13");

    doTest("T56",
        "(_subject_) INCIDENT 201331777\n\n" +
        "CODE CO     CO DETECTOR NO IJURIES     ALARM 1\n\n" +
        "324 BURNSIDE ST          \n\n" +
        "Grid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 700 SEVERN AVE-EP\n\n" +
        "Nature: F05A-CO DET./NO INJURIES (COLD)\n\n" +
        "Community of ANNAPOLIS CITY (009624-43)\n" +
        "TAC CHANNEL B ASSIGNED (009605-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (009605-)\n\n" +
        "SQ38  E84  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "DWELLING HAS A 13D TYPE RESIDENTIAL SPRINKLER SYSTEM.\n" +
        "19210\n" +
        "DOMESTICALLY FED, NO FDC.\n\n" +
        "TIME 08:43:26          DATE 06/08/13",

        "ID:201331777",
        "CALL:CO DETECTOR NO IJURIES - CO DET./NO INJURIES (COLD)",
        "ADDR:324 BURNSIDE ST",
        "CITY:ANNAPOLIS",
        "MAP:21-A11-3602",
        "CH:B",
        "X:700 SEVERN AVE",
        "CODE:F05A",
        "INFO:AUTO SPRINKLER SYSTEM\nDWELLING HAS A 13D TYPE RESIDENTIAL SPRINKLER SYSTEM.\n19210\nDOMESTICALLY FED, NO FDC.",
        "UNIT:SQ38  E84",
        "TIME:08:43:26",
        "DATE:06/08/13");

    doTest("T57",
        "(_subject_) INCIDENT 201331757\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "FOREST DR-AN/HILLTOP LN-AN          \n\n" +
        "Grid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 HILLTOP LN-AN\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (001583-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS: 2250 FOREST DR-AN (4490) & 2252 FOREST DR-AN (4490)\n\n" +
        "TIME 04:02:20          DATE 06/08/13INCIDENT 201331757\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "FOREST DR-AN/HILLTOP LN-AN          \n\n" +
        "Grid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 HILLTOP LN-AN\n\n" +
        "Nature: 29B06-MVC: UNKNOWN STATUS\n\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (001583-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS: 2250 FOREST DR-AN (4490) & 2252 FOREST DR-AN (4490)\n\n" +
        "TIME 04:02:20          DATE 06/08/13",

        "ID:201331757",
        "CALL:PX TYPE WITH E TK OR SQ - MVC: UNKNOWN STATUS",
        "ADDR:FOREST DR & HILLTOP LN",
        "CITY:ANNAPOLIS",
        "MAP:20-F12-3526",
        "CH:B",
        "X:2 HILLTOP LN",
        "CODE:29B06",
        "INFO:HYDRANTS: 2250 FOREST DR-AN (4490) & 2252 FOREST DR-AN (4490)",
        "UNIT:E351  PM35  ATRO",
        "TIME:04:02:20",
        "DATE:06/08/13");

    doTest("T58",
        "(_subject_) INCIDENT 201331751\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "371 COLONY POINT PL          \n\n" +
        "Grid 24     Map K05     Area 0224     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 301 HOWARDS POINT RD\n\n" +
        "Second cross street - 3702 BAYPORT DR\n\n" +
        "Nature: F50-ODOR OF SMOKE INSIDE (WARM)\n\n" +
        "Call back: 410-956-2663\n\n" +
        "Community of SOUTH RIVER COLONY (009617-30)\n" +
        "TAC CHANNEL E ASSIGNED (001583-)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (001583-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (001583-)\n\n" +
        "ME2  E351  TW40  \n\n" +
        "HYDRANTS: 383 COLONY POINT PL (0) &  (0)\n" +
        "AREA CAUTION NOTES FOR 0224\n" +
        "STAGING AREA FOR W/R: STATION 2\n" +
        "BOAT RAMP: GRANGE RD & SHORE DR.\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 03:06:00          DATE 06/08/13",

        "ID:201331751",
        "CALL:STILL ALARM - ODOR OF SMOKE INSIDE (WARM)",
        "ADDR:371 COLONY POINT PL",
        "PLACE:SOUTH RIVER COLONY",
        "MAP:24-K05-0224",
        "CH:E",
        "X:301 HOWARDS POINT RD & 3702 BAYPORT DR",
        "CODE:F50",
        "PHONE:410-956-2663",
        "INFO:HYDRANTS: 383 COLONY POINT PL (0) &  (0)\nAREA CAUTION NOTES FOR 0224\nSTAGING AREA FOR W/R: STATION 2\nBOAT RAMP: GRANGE RD & SHORE DR.\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  E351  TW40",
        "TIME:03:06:00",
        "DATE:06/08/13");

    doTest("T59",
        "(_subject_) INCIDENT 201331741\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "225 BOXWOOD RD     105     \n\n" +
        "Grid 20     Map G12     Area 3524     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 246 HILLTOP LN-EP\n\n" +
        "Second cross street - 205 BOXWOOD CT\n\n" +
        "Nature: 09E02-CARDIAC ARREST: AGONAL RESP\n\n" +
        "Call back: 443-326-0075\n\n" +
        "ProQaA: GRANDFATHER SICK (009603-42)\n" +
        "ProQaA: 68 Year Old Man, Unconscious, Unknown Breathing (009603-42)\n" +
        "ProQaA: ECHO was not selected from Case Entry. (009603-42)\n" +
        "ProQaA: The caller is with the patient. (009603-42)\n" +
        "ProQaA: There is a single patient. (009603-42)\n" +
        "Community of ANNAPOLIS CITY (009603-42)\n" +
        "TAC CHANNEL B ASSIGNED (000829-35)\n\n" +
        "E361  PM35  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 00:40:03          DATE 06/08/13",

        "ID:201331741",
        "CALL:2 EMT/P RESPONSE - CARDIAC ARREST: AGONAL RESP",
        "ADDR:225 BOXWOOD RD",
        "APT:105",
        "CITY:ANNAPOLIS",
        "MAP:20-G12-3524",
        "CH:B",
        "X:246 HILLTOP LN & 205 BOXWOOD CT",
        "CODE:09E02",
        "PHONE:443-326-0075",
        "INFO:GRANDFATHER SICK\n68 Year Old Man, Unconscious, Unknown Breathing\nECHO was not selected from Case Entry.\nThe caller is with the patient.\nThere is a single patient.",
        "UNIT:E361  PM35  EMS36  ATRO",
        "TIME:00:40:03",
        "DATE:06/08/13");

    doTest("T60",
        "(_subject_) INCIDENT 201331739\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "13 MARCS CT          \n\n" +
        "Grid 25     Map K02     Area 3604     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 2 BENS DR\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: 877-898-2000\n\n" +
        "Community of ANNAPOLIS CITY (009611-43)\n" +
        "TAC CHANNEL E ASSIGNED (000829-35)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000829-35)\n\n" +
        "E84  TK36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 00:35:14          DATE 06/08/13",

        "ID:201331739",
        "CALL:STILL ALARM - ANNAPOLIS CITY ALARMS (WARM)",
        "ADDR:13 MARCS CT",
        "CITY:ANNAPOLIS",
        "MAP:25-K02-3604",
        "CH:E",
        "CODE:F05B",
        "PHONE:877-898-2000",
        "UNIT:E84  TK36",
        "TIME:00:35:14",
        "DATE:06/08/13");

  }
  
  @Test
  public void testAnnapolisFire2() {

    doTest("T1",
        "(_subject_) INCIDENT 201342685\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "9 BATES ST          \n\n" +
        "Grid 20     Map J09     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 112 CLAY ST\n\n" +
        "Second cross street - 11 ABNEY LN\n\n" +
        "Nature: 26C01-ALTERED MENTAL STATUS\n\n" +
        "Call back: 410-268-0962\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001488-30)\n" +
        "ProQaA: 8 Month Old Infant Girl, Conscious, Breathing (001488-30)\n" +
        "ProQaA: There is a single patient. (001488-30)\n" +
        "ProQaA: - (001488-30)\n" +
        "ProQaA: The caller is with the patient. (001488-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (001488-30)\n" +
        "ProQaA: She is not acting normal. (001488-30)\n" +
        "ProQaA: She is breathing normally. (001488-30)\n" +
        "ProQaA: She does not have any pain. (001488-30)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (001488-30)\n" +
        "Community of ANNAPOLIS CITY (001488-30)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:28:41          DATE 07/29/13\n" +
        "\rINCIDENT 201342685\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "9 BATES ST          \n\n" +
        "Grid 20     Map J09     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 112 CLAY ST\n\n" +
        "Second cross street - 11 ABNEY LN\n\n" +
        "Nature: 26C01-ALTERED MENTAL STATUS\n\n" +
        "Call back: 410-268-0962\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001488-30)\n" +
        "ProQaA: 8 Month Old Infant Girl, Conscious, Breathing (001488-30)\n" +
        "ProQaA: There is a single patient. (001488-30)\n" +
        "ProQaA: - (001488-30)\n" +
        "ProQaA: The caller is with the patient. (001488-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (001488-30)\n" +
        "ProQaA: She is not acting normal. (001488-30)\n" +
        "ProQaA: She is breathing normally. (001488-30)\n" +
        "ProQaA: She does not have any pain. (001488-30)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (001488-30)\n" +
        "Community of ANNAPOLIS CITY (001488-30)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:28:41          DATE 07/29/13",

        "ID:201342685",
        "CALL:ONE EMT/P RESPONSE - ALTERED MENTAL STATUS",
        "ADDR:9 BATES ST",
        "CITY:ANNAPOLIS",
        "MAP:20-J09-3821",
        "CH:B",
        "X:112 CLAY ST & 11 ABNEY LN",
        "CODE:26C01",
        "PHONE:410-268-0962",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n8 Month Old Infant Girl, Conscious, Breathing\nThere is a single patient.\nThe caller is with the patient.\nShe is completely alert (responding appropriately).\nShe is not acting normal.\nShe is breathing normally.\nShe does not have any pain.\nShe is not bleeding (or vomiting blood).",
        "UNIT:E381  PM39  ATRO",
        "TIME:19:28:41",
        "DATE:07/29/13");

    doTest("T2",
        "(_subject_) INCIDENT 201342681\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "CHESTER AVE/FIRST ST-EP          \n\n" +
        "Grid 21     Map B11     Area 3601     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 600 FIRST ST-EP\n\n" +
        "Second cross street - 398 RIVERVIEW AVE-EP\n\n" +
        "Nature: 17D03-FALL:NOT ALERT\n\n" +
        "Call back: 281-414-2935\n\n" +
        "ProQaA: 64 Year Old Woman, Conscious, Breathing (009611-43)\n" +
        "ProQaA: - (009611-43)\n" +
        "ProQaA: The caller is with the patient. (009611-43)\n" +
        "ProQaA: There is a single patient. (009611-43)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009611-43)\n" +
        "ProQaA: It's reported that she fell at ground level. (009611-43)\n" +
        "ProQaA: The fall was accidental. (009611-43)\n" +
        "ProQaA: There is no bleeding now. (009611-43)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (009611-43)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009611-43)\n" +
        "Community of ANNAPOLIS CITY (009611-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n" +
        "ATRO Available 19:13:39 (009614-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:12:04          DATE 07/29/13\n" +
        "\rINCIDENT 201342681\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "CHESTER AVE/FIRST ST-EP          \n\n" +
        "Grid 21     Map B11     Area 3601     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 600 FIRST ST-EP\n\n" +
        "Second cross street - 398 RIVERVIEW AVE-EP\n\n" +
        "Nature: 17D03-FALL:NOT ALERT\n\n" +
        "Call back: 281-414-2935\n\n" +
        "ProQaA: 64 Year Old Woman, Conscious, Breathing (009611-43)\n" +
        "ProQaA: - (009611-43)\n" +
        "ProQaA: The caller is with the patient. (009611-43)\n" +
        "ProQaA: There is a single patient. (009611-43)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009611-43)\n" +
        "ProQaA: It's reported that she fell at ground level. (009611-43)\n" +
        "ProQaA: The fall was accidental. (009611-43)\n" +
        "ProQaA: There is no bleeding now. (009611-43)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (009611-43)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009611-43)\n" +
        "Community of ANNAPOLIS CITY (009611-43)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n" +
        "ATRO Available 19:13:39 (009614-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:12:04          DATE 07/29/13",

        "ID:201342681",
        "CALL:ONE EMT/P RESPONSE - FALL:NOT ALERT",
        "ADDR:CHESTER AVE & FIRST ST",
        "CITY:ANNAPOLIS",
        "MAP:21-B11-3601",
        "CH:B",
        "X:600 FIRST ST & 398 RIVERVIEW AVE",
        "CODE:17D03",
        "PHONE:281-414-2935",
        "INFO:64 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is not completely alert (not responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nATRO Available 19:13:39",
        "UNIT:E361  PM36  ATRO",
        "TIME:19:12:04",
        "DATE:07/29/13");

    doTest("T3",
        "(_subject_) INCIDENT 201342657\n\n" +
        "CODE L     LOCAL ALARM     ALARM 1\n\n" +
        "20 ELLINGTON DR-EP          \n\n" +
        "Grid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 134 JANWALL ST\n\n" +
        "Nature: F15C-CONTROLLED BURNING (COLD)\n\n" +
        "Community of ANNAPOLIS CITY (009611-)\n" +
        "TAC CHANNEL B ASSIGNED (000777-38)\n\n" +
        "E361  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 17:08:53          DATE 07/29/13",

        "ID:201342657",
        "CALL:LOCAL ALARM - CONTROLLED BURNING (COLD)",
        "ADDR:20 ELLINGTON DR",
        "CITY:ANNAPOLIS",
        "MAP:25-J01-3603",
        "CH:B",
        "CODE:F15C",
        "UNIT:E361",
        "TIME:17:08:53",
        "DATE:07/29/13");

    doTest("T4",
        "(_subject_) INCIDENT 201342652\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2700 S HAVEN RD     120A     HERITAGE HARBOUR NURSING\n\n" +
        "Grid 19     Map F11     Area 4016     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 798 PINE WOOD DR\n\n" +
        "Second cross street - 882 BOATSWAIN WAY\n\n" +
        "Nature: 26C01-ALTERED MENTAL STATUS\n\n" +
        "Call back: 4108971300 X202\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\n" +
        "ProQaA: 85 Year Old Man, Conscious, Breathing (000941-42)\n" +
        "ProQaA: - (000941-42)\n" +
        "ProQaA: The caller is not with the patient. (000941-42)\n" +
        "ProQaA: There is a single patient. (000941-42)\n" +
        "ProQaA: He is lethargic. (000941-42)\n" +
        "ProQaA: He is breathing normally. (000941-42)\n" +
        "ProQaA: He does not have any pain. (000941-42)\n" +
        "ProQaA: He is not bleeding (or vomiting blood). (000941-42)\n" +
        "ABNORMAL LABS (000941-42)\n" +
        "Community of HERITAGE HARBOR (000941-42)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009620-)\n" +
        "MU3 Available 16:38:56 (009620-)\n\n" +
        "TW40  MU3  PM39  \n\n" +
        "HYDRANTS: 2700 SOUTH HAVEN DR (SIDE C) (0) & 2700 SOUTH HAVEN DR (0)\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 4016\n" +
        "STAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\n" +
        "BOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\n" +
        "LZ:\n\n" +
        "TIME 16:37:10          DATE 07/29/13",

        "ID:201342652",
        "CALL:ONE EMT/P RESPONSE - ALTERED MENTAL STATUS",
        "ADDR:2700 S HAVEN RD",
        "APT:120A",
        "PLACE:HERITAGE HARBOUR NURSING",
        "MAP:19-F11-4016",
        "CH:B",
        "X:798 PINE WOOD DR & 882 BOATSWAIN WAY",
        "CODE:26C01",
        "PHONE:4108971300 X202",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n85 Year Old Man, Conscious, Breathing\nThe caller is not with the patient.\nThere is a single patient.\nHe is lethargic.\nHe is breathing normally.\nHe does not have any pain.\nHe is not bleeding (or vomiting blood).\nABNORMAL LABS\nMU3 Available 16:38:56\nHYDRANTS: 2700 SOUTH HAVEN DR (SIDE C) (0) & 2700 SOUTH HAVEN DR (0)\nCAUTION NOTES\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:",
        "UNIT:TW40  MU3  PM39",
        "TIME:16:37:10",
        "DATE:07/29/13");

    doTest("T5",
        "(_subject_) INCIDENT 201342650\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "479 MERRYMAN RD          CREATIVE GARDENS LEARNING CTR\n\n" +
        "Grid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 MERRYMAN CT\n\n" +
        "Second cross street - 2 HERITAGE CT\n\n" +
        "Nature: 17D03-FALL:NOT ALERT\n\n" +
        "Call back: 410-268-0900\n\n" +
        "ProQaA: 60 Year Old Woman, Conscious, Breathing (001488-30)\n" +
        "ProQaA: There is a single patient. (001488-30)\n" +
        "ProQaA: - (001488-30)\n" +
        "ProQaA: The caller is with the patient. (001488-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (001488-30)\n" +
        "ProQaA: It's reported that she fell at ground level. (001488-30)\n" +
        "ProQaA: The fall was accidental. (001488-30)\n" +
        "ProQaA: There is SERIOUS bleeding. (001488-30)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (001488-30)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (001488-30)\n" +
        "Community of ANNAPOLIS CITY (001488-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "KNOX BOX\n" +
        "RIGHT SIDE OF DOOR\n" +
        "17415\n" +
        "ALARM CODE 1113\n" +
        "GATE CODE - LEFT SIDE 0143\n\n" +
        "TIME 16:30:57          DATE 07/29/13INCIDENT 201342650\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "479 MERRYMAN RD          CREATIVE GARDENS LEARNING CTR\n\n" +
        "Grid 20     Map F12     Area 3526     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 MERRYMAN CT\n\n" +
        "Second cross street - 2 HERITAGE CT\n\n" +
        "Nature: 17D03-FALL:NOT ALERT\n\n" +
        "Call back: 410-268-0900\n\n" +
        "ProQaA: 60 Year Old Woman, Conscious, Breathing (001488-30)\n" +
        "ProQaA: There is a single patient. (001488-30)\n" +
        "ProQaA: - (001488-30)\n" +
        "ProQaA: The caller is with the patient. (001488-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (001488-30)\n" +
        "ProQaA: It's reported that she fell at ground level. (001488-30)\n" +
        "ProQaA: The fall was accidental. (001488-30)\n" +
        "ProQaA: There is SERIOUS bleeding. (001488-30)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (001488-30)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (001488-30)\n" +
        "Community of ANNAPOLIS CITY (001488-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "KNOX BOX\n" +
        "RIGHT SIDE OF DOOR\n" +
        "17415\n" +
        "ALARM CODE 1113\n" +
        "GATE CODE - LEFT SIDE 0143\n\n" +
        "TIME 16:30:57          DATE 07/29/13",

        "ID:201342650",
        "CALL:ONE EMT/P RESPONSE - FALL:NOT ALERT",
        "ADDR:479 MERRYMAN RD",
        "CITY:ANNAPOLIS",
        "PLACE:CREATIVE GARDENS LEARNING CTR",
        "MAP:20-F12-3526",
        "CH:B",
        "X:100 MERRYMAN CT & 2 HERITAGE CT",
        "CODE:17D03",
        "PHONE:410-268-0900",
        "INFO:60 Year Old Woman, Conscious, Breathing\nThere is a single patient.\nThe caller is with the patient.\nThis happened now (less than 6hrs ago).\nIt's reported that she fell at ground level.\nThe fall was accidental.\nThere is SERIOUS bleeding.\nShe is not completely alert (not responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nKNOX BOX\nRIGHT SIDE OF DOOR\n17415\nALARM CODE 1113\nGATE CODE - LEFT SIDE 0143",
        "UNIT:E351  PM35  ATRO",
        "TIME:16:30:57",
        "DATE:07/29/13");

    doTest("T6",
        "(_subject_) INCIDENT 201342639\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "899 REVELL HWY W-AN          BAY BRIDGE WESTBOUND SPAN\n\n" +
        "Grid 21     Map A03     Area 1980     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - OCEANIC DR\n\n" +
        "Nature: 29B04A-MVC:UNKNOWN STATUS\n\n" +
        "Community of CAPTAINS CHOICE (009620-39)\n" +
        "Remove unit 'E172' via 'X' at Tac  (009620-39)\n" +
        "Remove unit 'BC2' via 'X' at Tac  (009620-39)\n" +
        "TAC CHANNEL B ASSIGNED (009620-39)\n" +
        "Units 'on air': BC2 (009620-39)\n\n" +
        "PM39  E191  \n\n" +
        "HYDRANTS: 1100 COLLEGE PKWY E - NEW HQ (0) & 1100 COLLEGE PKWY E, SB & EB (0)\n\n" +
        "CAUTION NOTES\n\n" +
        "TIME 15:48:10          DATE 07/29/13",

        "ID:201342639",
        "CALL:PX TYPE WITH E TK OR SQ - MVC:UNKNOWN STATUS",
        "ADDR:899 REVELL HWY W",
        "CITY:ANNAPOLIS",
        "PLACE:BAY BRIDGE WESTBOUND SPAN",
        "MAP:21-A03-1980",
        "CH:B",
        "X:OCEANIC DR",
        "CODE:29B04A",
        "INFO:HYDRANTS: 1100 COLLEGE PKWY E - NEW HQ (0) & 1100 COLLEGE PKWY E, SB & EB (0)\nCAUTION NOTES",
        "UNIT:PM39  E191",
        "TIME:15:48:10",
        "DATE:07/29/13");

    doTest("T7",
        "(_subject_) INCIDENT 201342630\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "501 OAKLAWN AVE          \n\n" +
        "Grid 20     Map C10     Area 3528     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street -  MIDDLE ST\n\n" +
        "Second cross street - 34 CARVER ST\n\n" +
        "Nature: 01C06-ABD PAIN:ABOVE NAVAL FEMALE\n\n" +
        "Call back: 443-942-2270\n\n" +
        "ProQaA: 49 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: This is a 1st party caller. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009617-30)\n" +
        "ProQaA: She has difficulty speaking between breaths. (009617-30)\n" +
        "Nature Changed Via ProQA From: 01C06-ABD PAIN:ABOVE NAVAL FEMALE\n" +
        "Fire Priority Changed Via ProQA From: 2 to 2\n" +
        "ReConfig ProQaA: There was no mention of existing aortic aneurysm. (009617-30)\n" +
        "ReConfig ProQaA: She has not fainted or nearly fainted. (009617-30)\n" +
        "ReConfig ProQaA: She has pain above the belly button (navel). (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "Unit 'MU362' had changed quarters for unit 'MU36' (009620-)\n\n" +
        "E351  MU362  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 14:57:02          DATE 07/29/13",

        "ID:201342630",
        "CALL:BLS WITH FIRST RESPONDER - ABD PAIN:ABOVE NAVAL FEMALE",
        "ADDR:501 OAKLAWN AVE",
        "CITY:ANNAPOLIS",
        "MAP:20-C10-3528",
        "CH:B",
        "X:MIDDLE ST & 34 CARVER ST",
        "CODE:01C06",
        "PHONE:443-942-2270",
        "INFO:49 Year Old Woman, Conscious, Breathing\nThis is a 1st party caller.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nReConfig ProQaA: There was no mention of existing aortic aneurysm.\nReConfig ProQaA: She has not fainted or nearly fainted.\nReConfig ProQaA: She has pain above the belly button (navel).",
        "UNIT:E351  MU362",
        "TIME:14:57:02",
        "DATE:07/29/13");

    doTest("T8",
        "(_subject_) INCIDENT 201342619\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "954 BAY RIDGE RD-EP          ROCCOS PIZZERA\n\n" +
        "Grid 26     Map A03     Area 3605     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2898 CARROLLTON RD-EP\n\n" +
        "Second cross street -  EDGEWOOD RD-EP\n\n" +
        "Nature: 26D01-SICK PERSON:NOT ALERT\n\n" +
        "Call back: 410-263-9449\n\n" +
        "ProQaA: 83 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: The caller is with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009617-30)\n" +
        "ProQaA: It's reported that she fell at ground level. (009617-30)\n" +
        "ProQaA: The fall was accidental. (009617-30)\n" +
        "ProQaA: There is no bleeding now. (009617-30)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "FDC LOCATED ON SIDE 3.\n" +
        "19291\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 14:29:46          DATE 07/29/13\n" +
        "\rINCIDENT 201342619\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "954 BAY RIDGE RD-EP          ROCCOS PIZZERA\n\n" +
        "Grid 26     Map A03     Area 3605     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2898 CARROLLTON RD-EP\n\n" +
        "Second cross street -  EDGEWOOD RD-EP\n\n" +
        "Nature: 26D01-SICK PERSON:NOT ALERT\n\n" +
        "Call back: 410-263-9449\n\n" +
        "ProQaA: 83 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: The caller is with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009617-30)\n" +
        "ProQaA: It's reported that she fell at ground level. (009617-30)\n" +
        "ProQaA: The fall was accidental. (009617-30)\n" +
        "ProQaA: There is no bleeding now. (009617-30)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "FDC LOCATED ON SIDE 3.\n" +
        "19291\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 14:29:46          DATE 07/29/13",

        "ID:201342619",
        "CALL:ONE EMT/P RESPONSE - SICK PERSON:NOT ALERT",
        "ADDR:954 BAY RIDGE RD",
        "CITY:ANNAPOLIS",
        "PLACE:ROCCOS PIZZERA",
        "MAP:26-A03-3605",
        "CH:B",
        "X:2898 CARROLLTON RD & EDGEWOOD RD",
        "CODE:26D01",
        "PHONE:410-263-9449",
        "INFO:83 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that she fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nShe is not completely alert (not responding appropriately).\nCAUTION NOTES\nAUTO SPRINKLER SYSTEM\nFDC LOCATED ON SIDE 3.\n19291\nAREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX",
        "UNIT:E361  PM36  ATRO",
        "TIME:14:29:46",
        "DATE:07/29/13");

    doTest("T9",
        "(_subject_) INCIDENT 201342618\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "118 CARROLL DR-EP          \n\n" +
        "Grid 25     Map J05     Area 0817     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 602 TAYMAN DR\n\n" +
        "Second cross street - 82 GREAT LAKE DR\n\n" +
        "Nature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\n" +
        "Call back: 410-263-5101\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-43)\n" +
        "Community of HILLSMERE SHORES-(IN COUNTY) (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (009620-)\n\n" +
        "E84  MU8  PM36  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0817\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 14:27:27          DATE 07/29/13",

        "ID:201342618",
        "CALL:2 EMT/P RESPONSE - MVC:INVOLVING BIKE/MOTORCYCLE",
        "ADDR:118 CARROLL DR",
        "CITY:ANNAPOLIS",
        "PLACE:HILLSMERE SHORES-(IN COUNTY)",
        "MAP:25-J05-0817",
        "CH:B",
        "X:602 TAYMAN DR & 82 GREAT LAKE DR",
        "CODE:29D02L",
        "PHONE:410-263-5101",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nAREA CAUTION NOTES FOR 0817\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  MU8  PM36",
        "TIME:14:27:27",
        "DATE:07/29/13");

    doTest("T10",
        "(_subject_) INCIDENT 201342616\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2574 S HAVEN RD          LA CASA ASSISTED LIVING\n\n" +
        "Grid 19     Map E10     Area 4016     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2598 HIDDEN COVE RD\n\n" +
        "Second cross street -  MASTLINE DR\n\n" +
        "Nature: 12A04-SEIZURE:FOCAL ALERT\n\n" +
        "Call back: 410-224-5551\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009617-30)\n" +
        "ProQaA: 69 Year Old Man, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: The caller is with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: This is a FOCAL seizure. (009617-30)\n" +
        "ProQaA: He is not diabetic. (009617-30)\n" +
        "ProQaA: He is not an epileptic (not diagnosed with a seizure (009617-30)\n" +
        "ProQaA: disorder). (009617-30)\n" +
        "ProQaA: He does not have a history of STROKE or brain tumor. (009617-30)\n" +
        "ProQaA: He is completely alert (responding appropriately). (009617-30)\n" +
        "Community of HERITAGE HARBOR (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "UNIT E402 IS RESPONDING WITH OFFICER\n" +
        "From E402: PERSONS RESPONDING 3\n\n" +
        "E402  MU40  PM35  \n\n" +
        "HYDRANTS: 2574 SOUTH HAVEN DR (2605) & 2600 SOUTH HAVEN DR (2605)\n" +
        "AREA CAUTION NOTES FOR 4016\n" +
        "STAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\n" +
        "BOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\n" +
        "LZ:\n\n" +
        "TIME 14:15:53          DATE 07/29/13",

        "ID:201342616",
        "CALL:ONE EMT/P RESPONSE - SEIZURE:FOCAL ALERT",
        "ADDR:2574 S HAVEN RD",
        "PLACE:LA CASA ASSISTED LIVING",
        "MAP:19-E10-4016",
        "CH:B",
        "X:2598 HIDDEN COVE RD & MASTLINE DR",
        "CODE:12A04",
        "PHONE:410-224-5551",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n69 Year Old Man, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis is a FOCAL seizure.\nHe is not diabetic.\nHe is not an epileptic (not diagnosed with a seizure\ndisorder).\nHe does not have a history of STROKE or brain tumor.\nHe is completely alert (responding appropriately).\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\nHYDRANTS: 2574 SOUTH HAVEN DR (2605) & 2600 SOUTH HAVEN DR (2605)\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:",
        "UNIT:E402  MU40  PM35",
        "TIME:14:15:53",
        "DATE:07/29/13");

    doTest("T11",
        "(_subject_) INCIDENT 201342609\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "21 CORNHILL ST          \n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 46 STATE CIR\n\n" +
        "Second cross street - 98 HYDE ALLEY\n\n" +
        "Nature: 21D03-HEMORRHAGE/LAC:DANGEROUS\n\n" +
        "Call back: 443-615-3475\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (001239-43)\n" +
        "ProQaA: 73 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: - (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: The cause of the bleeding is non-traumatic. (001239-43)\n" +
        "ProQaA: He is coughing up blood. (001239-43)\n" +
        "ProQaA: He is completely alert (responding appropriately). (001239-43)\n" +
        "ProQaA: He is breathing normally. (001239-43)\n" +
        "ProQaA: There is SERIOUS bleeding. (001239-43)\n" +
        "ProQaA: He does not have a bleeding disorder or is taking blood (001239-43)\n" +
        "ProQaA: thinners. (001239-43)\n" +
        "Community of ANNAPOLIS CITY (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 13:34:01          DATE 07/29/13\n" +
        "\rINCIDENT 201342609\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "21 CORNHILL ST          \n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 46 STATE CIR\n\n" +
        "Second cross street - 98 HYDE ALLEY\n\n" +
        "Nature: 21D03-HEMORRHAGE/LAC:DANGEROUS\n\n" +
        "Call back: 443-615-3475\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (001239-43)\n" +
        "ProQaA: 73 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: - (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: The cause of the bleeding is non-traumatic. (001239-43)\n" +
        "ProQaA: He is coughing up blood. (001239-43)\n" +
        "ProQaA: He is completely alert (responding appropriately). (001239-43)\n" +
        "ProQaA: He is breathing normally. (001239-43)\n" +
        "ProQaA: There is SERIOUS bleeding. (001239-43)\n" +
        "ProQaA: He does not have a bleeding disorder or is taking blood (001239-43)\n" +
        "ProQaA: thinners. (001239-43)\n" +
        "Community of ANNAPOLIS CITY (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 13:34:01          DATE 07/29/13",

        "ID:201342609",
        "CALL:ONE EMT/P RESPONSE - HEMORRHAGE/LAC:DANGEROUS",
        "ADDR:21 CORNHILL ST",
        "CITY:ANNAPOLIS",
        "MAP:20-K10-3824",
        "CH:B",
        "X:46 STATE CIR & 98 HYDE ALLEY",
        "CODE:21D03",
        "PHONE:443-615-3475",
        "INFO:73 Year Old Man, Conscious, Breathing\nThere is a single patient.\nThe caller is with the patient.\nThe cause of the bleeding is non-traumatic.\nHe is coughing up blood.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nThere is SERIOUS bleeding.\nHe does not have a bleeding disorder or is taking blood\nthinners.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  PM39  ATRO",
        "TIME:13:34:01",
        "DATE:07/29/13");

    doTest("T12",
        "(_subject_) INCIDENT 201342588\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "1810 VIEW TOP CT          \n\n" +
        "Grid 21     Map B03     Area 1715     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 1774 MEADOW HILL DR\n\n" +
        "Nature: F50-ODOR OF SMOKE INSIDE (WARM)\n\n" +
        "Call back: 443-758-7431\n\n" +
        "PROQA ABORTED\n" +
        "Community of GREAT MEADOWS (009617-30)\n" +
        "Added unit 'E471' via 'X' at Tac  (009620-)\n" +
        "TAC CHANNEL E ASSIGNED (009620-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (009620-)\n\n" +
        "E172  TW40  E471  LAD39  \n\n" +
        "HYDRANTS: 1810 VIEW TOP CT (0) & 1804 VIEW TOP CT (0)\n" +
        "AREA CAUTION NOTES FOR 1715\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 11:58:45          DATE 07/29/13",

        "ID:201342588",
        "CALL:STILL ALARM - ODOR OF SMOKE INSIDE (WARM)",
        "ADDR:1810 VIEW TOP CT",
        "PLACE:GREAT MEADOWS",
        "MAP:21-B03-1715",
        "CH:E",
        "CODE:F50",
        "PHONE:443-758-7431",
        "INFO:PROQA ABORTED\nHYDRANTS: 1810 VIEW TOP CT (0) & 1804 VIEW TOP CT (0)\nAREA CAUTION NOTES FOR 1715\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:E172  TW40  E471  LAD39",
        "TIME:11:58:45",
        "DATE:07/29/13");

    doTest("T13",
        "(_subject_) INCIDENT 201342573\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "21 WATER ST-AN          \n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 48 SHAW ST\n\n" +
        "Second cross street - 52 LARKIN ST\n\n" +
        "Nature: 26C01-ALTERED MENTAL STATUS\n\n" +
        "Call back: 443-370-1017\n\n" +
        "ProQaA: 79 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: The caller is with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: She is not with it. (009617-30)\n" +
        "ProQaA: She is breathing normally. (009617-30)\n" +
        "ProQaA: She has other pain: (009617-30)\n" +
        "ProQaA: PAIN IN BED SORES (009617-30)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "Unit 'MU362' had changed quarters for unit 'MU36' (009620-)\n" +
        "Units 'on air': MU362 (009620-)\n\n" +
        "E381  MU362  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 10:22:23          DATE 07/29/13",

        "ID:201342573",
        "CALL:ONE EMT/P RESPONSE - ALTERED MENTAL STATUS",
        "ADDR:21 WATER ST",
        "CITY:ANNAPOLIS",
        "MAP:20-J10-3821",
        "CH:B",
        "X:48 SHAW ST & 52 LARKIN ST",
        "CODE:26C01",
        "PHONE:443-370-1017",
        "INFO:79 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nShe is not with it.\nShe is breathing normally.\nShe has other pain:\nPAIN IN BED SORES\nShe is not bleeding (or vomiting blood).",
        "UNIT:E381  MU362  ATRO",
        "TIME:10:22:23",
        "DATE:07/29/13");

    doTest("T14",
        "(_subject_) INCIDENT 201342569\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "105 ROSEWOOD ST          \n\n" +
        "Grid 20     Map D10     Area 3529     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - OAKLAWN AVE\n\n" +
        "Second cross street - 36 HICKS AVE\n\n" +
        "Nature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\n" +
        "ProQaA: SOMETHING IN HIS EAR (000941-42)\n" +
        "ProQaA: 35 Year Old Man, Conscious, Breathing (000941-42)\n" +
        "ProQaA: - (000941-42)\n" +
        "ProQaA: This is a 1st party caller. (000941-42)\n" +
        "ProQaA: There is a single patient. (000941-42)\n" +
        "ProQaA: He is completely alert (responding appropriately). (000941-42)\n" +
        "ProQaA: He is breathing normally. (000941-42)\n" +
        "ProQaA: He has other pain: (000941-42)\n" +
        "ProQaA: FEELS SOMETHING INSIDE EAR (000941-42)\n" +
        "ProQaA: He is not bleeding (or vomiting blood). (000941-42)\n" +
        "ProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (000941-42)\n" +
        "ProQaA: No priority symptoms (OMEGA conditions 2-28 not identified). (000941-42)\n" +
        "Community of ANNAPOLIS CITY (000941-42)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009620-)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "PM36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 10:12:36          DATE 07/29/13",

        "ID:201342569",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON:NO PRIORITY COMPL",
        "ADDR:105 ROSEWOOD ST",
        "CITY:ANNAPOLIS",
        "MAP:20-D10-3529",
        "CH:B",
        "X:OAKLAWN AVE & 36 HICKS AVE",
        "CODE:26A01",
        "INFO:SOMETHING IN HIS EAR\n35 Year Old Man, Conscious, Breathing\nThis is a 1st party caller.\nThere is a single patient.\nHe is completely alert (responding appropriately).\nHe is breathing normally.\nHe has other pain:\nFEELS SOMETHING INSIDE EAR\nHe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2-11 not identified).\nNo priority symptoms (OMEGA conditions 2-28 not identified).\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A",
        "UNIT:PM36",
        "TIME:10:12:36",
        "DATE:07/29/13");

    doTest("T15",
        "(_subject_) INCIDENT 201342567\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "33 WEST ST          RAMS HEAD TAVERN FORDHAM BLDG\n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - CATHEDRAL ST\n\n" +
        "Second cross street - 6 CHURCH CIR-AN\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: 410-268-4545\n\n" +
        "Community of ANNAPOLIS CITY (001239-43)\n" +
        "TAC CHANNEL E ASSIGNED (009620-)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 09:53:54          DATE 07/29/13\n" +
        "\rINCIDENT 201342567\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "33 WEST ST          RAMS HEAD TAVERN FORDHAM BLDG\n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - CATHEDRAL ST\n\n" +
        "Second cross street - 6 CHURCH CIR-AN\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: 410-268-4545\n\n" +
        "Community of ANNAPOLIS CITY (001239-43)\n" +
        "TAC CHANNEL E ASSIGNED (009620-)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 09:53:54          DATE 07/29/13",

        "ID:201342567",
        "CALL:STILL ALARM - ANNAPOLIS CITY ALARMS (WARM)",
        "ADDR:33 WEST ST",
        "CITY:ANNAPOLIS",
        "PLACE:RAMS HEAD TAVERN FORDHAM BLDG",
        "MAP:20-J10-3821",
        "CH:E",
        "X:CATHEDRAL ST & 6 CHURCH CIR",
        "CODE:F05B",
        "PHONE:410-268-4545",
        "UNIT:E381  LAD39",
        "TIME:09:53:54",
        "DATE:07/29/13");

    doTest("T16",
        "(_subject_) INCIDENT 201342563\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "615 ADMIRAL DR     408     \n\n" +
        "Grid 20     Map D07     Area 4032     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2024 HARBOUR GATES DR\n\n" +
        "Second cross street - 2058 OLD ADMIRAL CT\n\n" +
        "Nature: 17A02-FALL:NOT RECENT>6HRS\n\n" +
        "Call back: 410-266-5322\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\n" +
        "ProQaA: FELL EARLIER, PAIN WORSE (000941-42)\n" +
        "ProQaA: 60 Year Old Man, Conscious, Breathing (000941-42)\n" +
        "ProQaA: - (000941-42)\n" +
        "ProQaA: The caller is with the patient. (000941-42)\n" +
        "ProQaA: There is a single patient. (000941-42)\n" +
        "ProQaA: This happened more than 6hrs ago. (000941-42)\n" +
        "ProQaA: It's reported that he fell at ground level. (000941-42)\n" +
        "ProQaA: The fall was accidental. (000941-42)\n" +
        "ProQaA: There is no bleeding now. (000941-42)\n" +
        "ProQaA: He is completely alert (responding appropriately). (000941-42)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (000941-42)\n" +
        "ProQaA: He is no longer on the floor (ground). (000941-42)\n" +
        "Community of LINCOLN HEIGHTS (000941-42)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "Units 'on air': E402, PM39 (009620-)\n\n" +
        "E402  PM39  \n\n" +
        "HYDRANTS: 616 ADMIRAL DR (0) & 608 ADMIRAL DR (1957)\n\n" +
        "TIME 09:38:32          DATE 07/29/13",

        "ID:201342563",
        "CALL:BLS WITH FIRST RESPONDER - FALL:NOT RECENT>6HRS",
        "ADDR:615 ADMIRAL DR",
        "APT:408",
        "PLACE:LINCOLN HEIGHTS",
        "MAP:20-D07-4032",
        "CH:B",
        "X:2024 HARBOUR GATES DR & 2058 OLD ADMIRAL CT",
        "CODE:17A02",
        "PHONE:410-266-5322",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nFELL EARLIER, PAIN WORSE\n60 Year Old Man, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened more than 6hrs ago.\nIt's reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nHe is no longer on the floor (ground).\nHYDRANTS: 616 ADMIRAL DR (0) & 608 ADMIRAL DR (1957)",
        "UNIT:E402  PM39",
        "TIME:09:38:32",
        "DATE:07/29/13");

    doTest("T17",
        "(_subject_) INCIDENT 201342554\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1881 BOWMAN CT          \n\n" +
        "Grid 20     Map E09     Area 3514     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 1898 BOWMAN DR\n\n" +
        "Nature: 06D02-BREATHING PROB:TRBL SPEAKING\n\n" +
        "Call back: 410-571-5725\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\n" +
        "ProQaA: TROUBLE BREATHING (000941-42)\n" +
        "ProQaA: 64 Year Old Woman, Conscious, Breathing (000941-42)\n" +
        "ProQaA: - (000941-42)\n" +
        "ProQaA: The caller is with the patient. (000941-42)\n" +
        "ProQaA: There is a single patient. (000941-42)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000941-42)\n" +
        "ProQaA: She has difficulty speaking between breaths. (000941-42)\n" +
        "Community of ANNAPOLIS CITY (000941-42)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "ATRO Available 08:37:06 (009620-)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:36:06          DATE 07/29/13INCIDENT 201342554\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1881 BOWMAN CT          \n\n" +
        "Grid 20     Map E09     Area 3514     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 1898 BOWMAN DR\n\n" +
        "Nature: 06D02-BREATHING PROB:TRBL SPEAKING\n\n" +
        "Call back: 410-571-5725\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000941-42)\n" +
        "ProQaA: TROUBLE BREATHING (000941-42)\n" +
        "ProQaA: 64 Year Old Woman, Conscious, Breathing (000941-42)\n" +
        "ProQaA: - (000941-42)\n" +
        "ProQaA: The caller is with the patient. (000941-42)\n" +
        "ProQaA: There is a single patient. (000941-42)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000941-42)\n" +
        "ProQaA: She has difficulty speaking between breaths. (000941-42)\n" +
        "Community of ANNAPOLIS CITY (000941-42)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "ATRO Available 08:37:06 (009620-)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 08:36:06          DATE 07/29/13",

        "ID:201342554",
        "CALL:ONE EMT/P RESPONSE - BREATHING PROB:TRBL SPEAKING",
        "ADDR:1881 BOWMAN CT",
        "CITY:ANNAPOLIS",
        "MAP:20-E09-3514",
        "CH:B",
        "CODE:06D02",
        "PHONE:410-571-5725",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nTROUBLE BREATHING\n64 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe has difficulty speaking between breaths.\nATRO Available 08:37:06",
        "UNIT:E352  PM35  ATRO",
        "TIME:08:36:06",
        "DATE:07/29/13");

    doTest("T18",
        "(_subject_) INCIDENT 201342551\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "712 SYDNEY TER          \n\n" +
        "Grid 19     Map G09     Area 4016     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 517 COOVER RD\n\n" +
        "Nature: 17D03-FALL:NOT ALERT\n\n" +
        "Call back: 410-626-8053\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-43)\n" +
        "ProQaA: 87 Year Old Man, Conscious, Breathing (001239-43)\n" +
        "ProQaA: There is a single patient. (001239-43)\n" +
        "ProQaA: - (001239-43)\n" +
        "ProQaA: The caller is with the patient. (001239-43)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (001239-43)\n" +
        "ProQaA: It's reported that he fell at ground level. (001239-43)\n" +
        "ProQaA: The reason for the fall is not known. (001239-43)\n" +
        "ProQaA: There is SERIOUS bleeding. (001239-43)\n" +
        "ProQaA: He is not completely alert (not responding appropriately). (001239-43)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (001239-43)\n" +
        "Community of COOVER RD AREA COMMUNITY (001239-43)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n" +
        "UNIT E402 IS RESPONDING WITH OFFICER\n" +
        "From E402: PERSONS RESPONDING 3\n\n" +
        "E402  MU40  PM35  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 4016\n" +
        "STAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\n" +
        "BOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\n" +
        "LZ:\n\n" +
        "TIME 07:59:00          DATE 07/29/13",

        "ID:201342551",
        "CALL:ONE EMT/P RESPONSE - FALL:NOT ALERT",
        "ADDR:712 SYDNEY TER",
        "PLACE:COOVER RD AREA COMMUNITY",
        "MAP:19-G09-4016",
        "CH:B",
        "X:517 COOVER RD",
        "CODE:17D03",
        "PHONE:410-626-8053",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n87 Year Old Man, Conscious, Breathing\nThere is a single patient.\nThe caller is with the patient.\nThis happened now (less than 6hrs ago).\nIt's reported that he fell at ground level.\nThe reason for the fall is not known.\nThere is SERIOUS bleeding.\nHe is not completely alert (not responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:",
        "UNIT:E402  MU40  PM35",
        "TIME:07:59:00",
        "DATE:07/29/13");

    doTest("T19",
        "(_subject_) INCIDENT 201342549\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "2000 FOREST DR-AN          \n\n" +
        "Grid 20     Map D10     Area 3528     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 50 HICKS AVE\n\n" +
        "Second cross street - 2 BAUSUM DR\n\n" +
        "Nature: 00A2-MEDICAL SERVICE CALL (COLD)\n\n" +
        "Community of ANNAPOLIS CITY (000557-30)\n" +
        "TAC CHANNEL B ASSIGNED (009620-)\n\n" +
        "E352  \n\n" +
        "HYDRANTS: 2250 FOREST DR-AN (4490) &  ()\n\n" +
        "KNOX BOX\n" +
        "CODE FOR KEY BOX IS 19367\n" +
        "19013\n\n" +
        "TIME 07:40:17          DATE 07/29/13",

        "ID:201342549",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MEDICAL SERVICE CALL (COLD)",
        "ADDR:2000 FOREST DR",
        "CITY:ANNAPOLIS",
        "MAP:20-D10-3528",
        "CH:B",
        "X:50 HICKS AVE & 2 BAUSUM DR",
        "CODE:00A2",
        "INFO:HYDRANTS: 2250 FOREST DR-AN (4490) &  ()\nKNOX BOX\nCODE FOR KEY BOX IS 19367\n19013",
        "UNIT:E352",
        "TIME:07:40:17",
        "DATE:07/29/13");

    doTest("T20",
        "(_subject_) INCIDENT 201342535\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "4 DOCK ST     100     MULTI BUSINESS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: HL\n\n" +
        "BUILDING (001252-42)\n" +
        "Community of ANNAPOLIS CITY (001252-42)\n" +
        "TAC CHANNEL B ASSIGNED (000557-30)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "BUILDING IS SPRINKLERED.\n" +
        "19265\n" +
        "FDC LOCATED ON SIDE C.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:57:11          DATE 07/29/13\n" +
        "\rINCIDENT 201342535\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "4 DOCK ST     100     MULTI BUSINESS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: F05B-ANNAPOLIS CITY ALARMS (WARM)\n\n" +
        "Call back: HL\n\n" +
        "BUILDING (001252-42)\n" +
        "Community of ANNAPOLIS CITY (001252-42)\n" +
        "TAC CHANNEL B ASSIGNED (000557-30)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "BUILDING IS SPRINKLERED.\n" +
        "19265\n" +
        "FDC LOCATED ON SIDE C.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:57:11          DATE 07/29/13",

        "ID:201342535",
        "CALL:STILL ALARM - ANNAPOLIS CITY ALARMS (WARM)",
        "ADDR:4 DOCK ST",
        "APT:100",
        "CITY:ANNAPOLIS",
        "PLACE:MULTI BUSINESS",
        "MAP:21-A10-3824",
        "CH:B",
        "X:98 CRAIG ST",
        "CODE:F05B",
        "PHONE:HL",
        "INFO:BUILDING\nBUILDING IS SPRINKLERED.\n19265\nFDC LOCATED ON SIDE C.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  LAD39",
        "TIME:02:57:11",
        "DATE:07/29/13");

    doTest("T21",
        "(_subject_) INCIDENT 201342532\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "WEST ST/CHURCH CIR-AN          \n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 6 CHURCH CIR-AN\n\n" +
        "Nature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\n" +
        "Community of ANNAPOLIS CITY (009611-35)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009617-)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "PM39  \n\n" +
        "HYDRANTS:  (0) & 2087 WEST ST (0)\n\n" +
        "TIME 01:19:01          DATE 07/29/13",

        "ID:201342532",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON:NO PRIORITY COMPL",
        "ADDR:WEST ST & CHURCH CIR",
        "CITY:ANNAPOLIS",
        "MAP:20-J10-3821",
        "CH:B",
        "X:6 CHURCH CIR",
        "CODE:26A01",
        "INFO:DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A\nHYDRANTS:  (0) & 2087 WEST ST (0)",
        "UNIT:PM39",
        "TIME:01:19:01",
        "DATE:07/29/13");

    doTest("T22",
        "(_subject_) INCIDENT 201342528\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "607 SEVERN ISLAND CT          \n\n" +
        "Grid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - YAWL RD\n\n" +
        "Second cross street - YAWL RD\n\n" +
        "Nature: 23C01I-OVERDOSE:NOT ALERT/INTENTIONAL\n\n" +
        "Call back: 202-230-3982\n\n" +
        "ProQaA: 41 Year Old Woman, Conscious, Breathing (009611-35)\n" +
        "ProQaA: - (009611-35)\n" +
        "ProQaA: The caller is with the patient. (009611-35)\n" +
        "ProQaA: There is a single patient. (009611-35)\n" +
        "ProQaA: She is out of it. (009611-35)\n" +
        "ProQaA: She is not acting right. (009611-35)\n" +
        "ProQaA: She is breathing normally. (009611-35)\n" +
        "ProQaA: She has chest pain. (009611-35)\n" +
        "ProQaA: It's not known if this was accidental or intentional. (009611-35)\n" +
        "ProQaA: She is not violent. (009611-35)\n" +
        "ProQaA: She is not changing color. (009611-35)\n" +
        "ProQaA: She has taken an unknown substance. (009611-35)\n" +
        "ProQaA: It's not known when she took it. (009611-35)\n" +
        "ProQaA: She took it now (less than 30 mins. ago). (009611-35)\n" +
        "Community of ANNAPOLIS CITY (009611-35)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 23:38:32          DATE 07/28/13INCIDENT 201342528\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "607 SEVERN ISLAND CT          \n\n" +
        "Grid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - YAWL RD\n\n" +
        "Second cross street - YAWL RD\n\n" +
        "Nature: 23C01I-OVERDOSE:NOT ALERT/INTENTIONAL\n\n" +
        "Call back: 202-230-3982\n\n" +
        "ProQaA: 41 Year Old Woman, Conscious, Breathing (009611-35)\n" +
        "ProQaA: - (009611-35)\n" +
        "ProQaA: The caller is with the patient. (009611-35)\n" +
        "ProQaA: There is a single patient. (009611-35)\n" +
        "ProQaA: She is out of it. (009611-35)\n" +
        "ProQaA: She is not acting right. (009611-35)\n" +
        "ProQaA: She is breathing normally. (009611-35)\n" +
        "ProQaA: She has chest pain. (009611-35)\n" +
        "ProQaA: It's not known if this was accidental or intentional. (009611-35)\n" +
        "ProQaA: She is not violent. (009611-35)\n" +
        "ProQaA: She is not changing color. (009611-35)\n" +
        "ProQaA: She has taken an unknown substance. (009611-35)\n" +
        "ProQaA: It's not known when she took it. (009611-35)\n" +
        "ProQaA: She took it now (less than 30 mins. ago). (009611-35)\n" +
        "Community of ANNAPOLIS CITY (009611-35)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n\n" +
        "E352  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 23:38:32          DATE 07/28/13",

        "ID:201342528",
        "CALL:ONE EMT/P RESPONSE - OVERDOSE:NOT ALERT/INTENTIONAL",
        "ADDR:607 SEVERN ISLAND CT",
        "CITY:ANNAPOLIS",
        "MAP:20-E11-3526",
        "CH:B",
        "X:YAWL RD & YAWL RD",
        "CODE:23C01I",
        "PHONE:202-230-3982",
        "INFO:41 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nShe is out of it.\nShe is not acting right.\nShe is breathing normally.\nShe has chest pain.\nIt's not known if this was accidental or intentional.\nShe is not violent.\nShe is not changing color.\nShe has taken an unknown substance.\nIt's not known when she took it.\nShe took it now (less than 30 mins. ago).",
        "UNIT:E352  PM35  ATRO",
        "TIME:23:38:32",
        "DATE:07/28/13");

    doTest("T23",
        "(_subject_) INCIDENT 201342522\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "318 6TH ST-EP          FLEET FEET ANNAPOLIS\n\n" +
        "Grid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 600 SEVERN AVE-EP\n\n" +
        "Second cross street - COMPROMISE ST\n\n" +
        "Nature: 31D02-UNCONSCIOUS:EFFECTIVE BREATH\n\n" +
        "Call back: 410-570-4588\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000557-30)\n" +
        "ProQaA: UNCONSCIOUS (000557-30)\n" +
        "ProQaA: Unknown age Male, Unconscious, Breathing (000557-30)\n" +
        "ProQaA: - (000557-30)\n" +
        "ProQaA: The caller is with the patient. (000557-30)\n" +
        "ProQaA: There is a single patient. (000557-30)\n" +
        "ProQaA: It's not known if his breathing is completely normal. (000557-30)\n" +
        "ProQaA: The caller is unable to assess the patient's breathing status. (000557-30)\n" +
        "ProQaA: The caller was asked if he is still unconscious. (000557-30)\n" +
        "ProQaA: He is still unconscious. (000557-30)\n" +
        "Community of ANNAPOLIS CITY (000557-30)\n" +
        "MAN LYING ON GROUND (000557-30)\n" +
        "TAC CHANNEL B ASSIGNED (000897-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 22:40:46          DATE 07/28/13\n" +
        "\rINCIDENT 201342522\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "318 6TH ST-EP          FLEET FEET ANNAPOLIS\n\n" +
        "Grid 21     Map A11     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 600 SEVERN AVE-EP\n\n" +
        "Second cross street - COMPROMISE ST\n\n" +
        "Nature: 31D02-UNCONSCIOUS:EFFECTIVE BREATH\n\n" +
        "Call back: 410-570-4588\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000557-30)\n" +
        "ProQaA: UNCONSCIOUS (000557-30)\n" +
        "ProQaA: Unknown age Male, Unconscious, Breathing (000557-30)\n" +
        "ProQaA: - (000557-30)\n" +
        "ProQaA: The caller is with the patient. (000557-30)\n" +
        "ProQaA: There is a single patient. (000557-30)\n" +
        "ProQaA: It's not known if his breathing is completely normal. (000557-30)\n" +
        "ProQaA: The caller is unable to assess the patient's breathing status. (000557-30)\n" +
        "ProQaA: The caller was asked if he is still unconscious. (000557-30)\n" +
        "ProQaA: He is still unconscious. (000557-30)\n" +
        "Community of ANNAPOLIS CITY (000557-30)\n" +
        "MAN LYING ON GROUND (000557-30)\n" +
        "TAC CHANNEL B ASSIGNED (000897-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 22:40:46          DATE 07/28/13",

        "ID:201342522",
        "CALL:ONE EMT/P RESPONSE - UNCONSCIOUS:EFFECTIVE BREATH",
        "ADDR:318 6TH ST",
        "CITY:ANNAPOLIS",
        "PLACE:FLEET FEET ANNAPOLIS",
        "MAP:21-A11-3602",
        "CH:B",
        "X:600 SEVERN AVE & COMPROMISE ST",
        "CODE:31D02",
        "PHONE:410-570-4588",
        "INFO:UNCONSCIOUS\nUnknown age Male, Unconscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nIt's not known if his breathing is completely normal.\nThe caller is unable to assess the patient's breathing status.\nThe caller was asked if he is still unconscious.\nHe is still unconscious.\nMAN LYING ON GROUND",
        "UNIT:E361  PM36  ATRO",
        "TIME:22:40:46",
        "DATE:07/28/13");

    doTest("T24",
        "(_subject_) INCIDENT 201342502\n\n" +
        "CODE B     BOX ASSIGNMENT     ALARM 1\n\n" +
        "21 BEACON CT          \n\n" +
        "Grid 25     Map G02     Area 3515     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street -  HUNT MEADOW DR\n\n" +
        "Nature: F65D-DWELLING FIRE (HOT)\n\n" +
        "Community of ANNAPOLIS CITY (001252-42)\n" +
        "TAC CHANNEL E ASSIGNED (000897-39)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000897-39)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (000897-39)\n" +
        "Units 'on air': BC35 (000897-39)\n\n" +
        "E351  E84  E402  LAD39  TW40  SQ2  PM35  BC35  ANAC1  APD  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 20:29:38          DATE 07/28/13",

        "ID:201342502",
        "CALL:BOX ASSIGNMENT - DWELLING FIRE (HOT)",
        "ADDR:21 BEACON CT",
        "CITY:ANNAPOLIS",
        "MAP:25-G02-3515",
        "CH:E",
        "CODE:F65D",
        "UNIT:E351  E84  E402  LAD39  TW40  SQ2  PM35  BC35  ANAC1  APD",
        "TIME:20:29:38",
        "DATE:07/28/13");

    doTest("T25",
        "(_subject_) INCIDENT 201342500\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "14 BRICIN ST     103     \n\n" +
        "Grid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2 MELROB CT\n\n" +
        "Second cross street - 160 JANWALL ST\n\n" +
        "Nature: 13C03-DIABETIC PROB:ABNORM BREATH\n\n" +
        "Call back: 410-263-5054\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-30)\n" +
        "ProQaA: DIABETIC (000557-30)\n" +
        "ProQaA: 79 Year Old Woman, Conscious, Breathing (000557-30)\n" +
        "ProQaA: - (000557-30)\n" +
        "ProQaA: This is a 1st party caller. (000557-30)\n" +
        "ProQaA: There is a single patient. (000557-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000557-30)\n" +
        "ProQaA: She is behaving normally now. (000557-30)\n" +
        "ProQaA: She is not breathing normally. (000557-30)\n" +
        "Community of ANNAPOLIS CITY (000557-30)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "GAS AND ELECTRICAL SHUT-OFF IN FIRST FLOOR LAUNDRY ROOM.\n" +
        "19195\n" +
        "FIRE ALARM CONTROL PANEL IN FIRST FLOOR LAUNDRY ROOM.\n\n" +
        "TIME 20:09:37          DATE 07/28/13\n" +
        "\rINCIDENT 201342500\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "14 BRICIN ST     103     \n\n" +
        "Grid 25     Map J01     Area 3603     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2 MELROB CT\n\n" +
        "Second cross street - 160 JANWALL ST\n\n" +
        "Nature: 13C03-DIABETIC PROB:ABNORM BREATH\n\n" +
        "Call back: 410-263-5054\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000557-30)\n" +
        "ProQaA: DIABETIC (000557-30)\n" +
        "ProQaA: 79 Year Old Woman, Conscious, Breathing (000557-30)\n" +
        "ProQaA: - (000557-30)\n" +
        "ProQaA: This is a 1st party caller. (000557-30)\n" +
        "ProQaA: There is a single patient. (000557-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000557-30)\n" +
        "ProQaA: She is behaving normally now. (000557-30)\n" +
        "ProQaA: She is not breathing normally. (000557-30)\n" +
        "Community of ANNAPOLIS CITY (000557-30)\n" +
        "TAC CHANNEL B ASSIGNED (000582-38)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "GAS AND ELECTRICAL SHUT-OFF IN FIRST FLOOR LAUNDRY ROOM.\n" +
        "19195\n" +
        "FIRE ALARM CONTROL PANEL IN FIRST FLOOR LAUNDRY ROOM.\n\n" +
        "TIME 20:09:37          DATE 07/28/13",

        "ID:201342500",
        "CALL:ONE EMT/P RESPONSE - DIABETIC PROB:ABNORM BREATH",
        "ADDR:14 BRICIN ST",
        "APT:103",
        "CITY:ANNAPOLIS",
        "MAP:25-J01-3603",
        "CH:B",
        "X:2 MELROB CT & 160 JANWALL ST",
        "CODE:13C03",
        "PHONE:410-263-5054",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nDIABETIC\n79 Year Old Woman, Conscious, Breathing\nThis is a 1st party caller.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe is behaving normally now.\nShe is not breathing normally.\nCAUTION NOTES\nGAS AND ELECTRICAL SHUT-OFF IN FIRST FLOOR LAUNDRY ROOM.\n19195\nFIRE ALARM CONTROL PANEL IN FIRST FLOOR LAUNDRY ROOM.",
        "UNIT:E361  PM36  ATRO",
        "TIME:20:09:37",
        "DATE:07/28/13");

    doTest("T26",
        "(_subject_) INCIDENT 201342496\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2012 WEST ST     B     LIGHTHOUSE WINE AND SPIRIT\n\n" +
        "Grid 20     Map D09     Area 3529     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street -  GIBRALTER AVE\n\n" +
        "Second cross street - 2 HICKS AVE\n\n" +
        "Nature: 32B03-UNKNOWN MEDICAL EMERG\n\n" +
        "Call back: 410-991-4073\n\n" +
        "Community of ANNAPOLIS CITY (001252-42)\n" +
        "TAC CHANNEL B ASSIGNED (000897-39)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:42:02          DATE 07/28/13INCIDENT 201342496\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "2012 WEST ST     B     LIGHTHOUSE WINE AND SPIRIT\n\n" +
        "Grid 20     Map D09     Area 3529     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street -  GIBRALTER AVE\n\n" +
        "Second cross street - 2 HICKS AVE\n\n" +
        "Nature: 32B03-UNKNOWN MEDICAL EMERG\n\n" +
        "Call back: 410-991-4073\n\n" +
        "Community of ANNAPOLIS CITY (001252-42)\n" +
        "TAC CHANNEL B ASSIGNED (000897-39)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:42:02          DATE 07/28/13",

        "ID:201342496",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN MEDICAL EMERG",
        "ADDR:2012 WEST ST",
        "APT:B",
        "CITY:ANNAPOLIS",
        "PLACE:LIGHTHOUSE WINE AND SPIRIT",
        "MAP:20-D09-3529",
        "CH:B",
        "X:GIBRALTER AVE & 2 HICKS AVE",
        "CODE:32B03",
        "PHONE:410-991-4073",
        "UNIT:E351  PM35  ATRO",
        "TIME:19:42:02",
        "DATE:07/28/13");

    doTest("T27",
        "(_subject_) INCIDENT 201342464\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1609 CEDAR PARK RD          \n\n" +
        "Grid 20     Map F09     Area 3812     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 FISKE CIR\n\n" +
        "Second cross street - 398 WINDELL AVE\n\n" +
        "Nature: 28C03F-STROKE:SPEECH PROB\n\n" +
        "Call back: 410-267-0231\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (009614-42)\n" +
        "ProQaA: 91 Year Old Woman, Conscious, Breathing (009614-42)\n" +
        "ProQaA: Yes (009614-42)\n" +
        "ProQaA: - (009614-42)\n" +
        "ProQaA: The caller is with the patient. (009614-42)\n" +
        "ProQaA: There is a single patient. (009614-42)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009614-42)\n" +
        "ProQaA: She is breathing normally. (009614-42)\n" +
        "ProQaA: She is having sudden speech problems. (009614-42)\n" +
        "ProQaA: The Stroke Diagnostic results indicate strong evidence of (009614-42)\n" +
        "ProQaA: stroke. (009614-42)\n" +
        "ProQaA: These symptoms (problem) started: (009614-42)\n" +
        "ProQaA: 2 HRS AGO (009614-42)\n" +
        "ProQaA: She has not had a STROKE before. (009614-42)\n" +
        "Community of ANNAPOLIS CITY (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (000777-38)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 15:26:00          DATE 07/28/13\n" +
        "\rINCIDENT 201342464\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1609 CEDAR PARK RD          \n\n" +
        "Grid 20     Map F09     Area 3812     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 FISKE CIR\n\n" +
        "Second cross street - 398 WINDELL AVE\n\n" +
        "Nature: 28C03F-STROKE:SPEECH PROB\n\n" +
        "Call back: 410-267-0231\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (009614-42)\n" +
        "ProQaA: 91 Year Old Woman, Conscious, Breathing (009614-42)\n" +
        "ProQaA: Yes (009614-42)\n" +
        "ProQaA: - (009614-42)\n" +
        "ProQaA: The caller is with the patient. (009614-42)\n" +
        "ProQaA: There is a single patient. (009614-42)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009614-42)\n" +
        "ProQaA: She is breathing normally. (009614-42)\n" +
        "ProQaA: She is having sudden speech problems. (009614-42)\n" +
        "ProQaA: The Stroke Diagnostic results indicate strong evidence of (009614-42)\n" +
        "ProQaA: stroke. (009614-42)\n" +
        "ProQaA: These symptoms (problem) started: (009614-42)\n" +
        "ProQaA: 2 HRS AGO (009614-42)\n" +
        "ProQaA: She has not had a STROKE before. (009614-42)\n" +
        "Community of ANNAPOLIS CITY (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (000777-38)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 15:26:00          DATE 07/28/13",

        "ID:201342464",
        "CALL:ONE EMT/P RESPONSE - STROKE:SPEECH PROB",
        "ADDR:1609 CEDAR PARK RD",
        "CITY:ANNAPOLIS",
        "MAP:20-F09-3812",
        "CH:B",
        "X:2 FISKE CIR & 398 WINDELL AVE",
        "CODE:28C03F",
        "PHONE:410-267-0231",
        "INFO:91 Year Old Woman, Conscious, Breathing\nYes\nThe caller is with the patient.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe is having sudden speech problems.\nThe Stroke Diagnostic results indicate strong evidence of\nstroke.\nThese symptoms (problem) started:\n2 HRS AGO\nShe has not had a STROKE before.",
        "UNIT:E381  PM39  ATRO",
        "TIME:15:26:00",
        "DATE:07/28/13");

    doTest("T28",
        "(_subject_) INCIDENT 201342449\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "CHINQUAPIN ROUND RD/GEORGE AVE-AN          \n\n" +
        "Grid 20     Map E10     Area 3527     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 1898 GEORGE AVE-AN\n\n" +
        "Second cross street - 1900 MARGARET AVE-AN\n\n" +
        "Nature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\n" +
        "Call back: 410-212-7445\n\n" +
        "2 (009614-42)\n" +
        "Community of ANNAPOLIS CITY (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E351  PM39  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:51:59          DATE 07/28/13\n" +
        "\rINCIDENT 201342449\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "CHINQUAPIN ROUND RD/GEORGE AVE-AN          \n\n" +
        "Grid 20     Map E10     Area 3527     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 1898 GEORGE AVE-AN\n\n" +
        "Second cross street - 1900 MARGARET AVE-AN\n\n" +
        "Nature: 29D02L-MVC:INVOLVING BIKE/MOTORCYCLE\n\n" +
        "Call back: 410-212-7445\n\n" +
        "2 (009614-42)\n" +
        "Community of ANNAPOLIS CITY (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E351  PM39  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:51:59          DATE 07/28/13",

        "ID:201342449",
        "CALL:2 EMT/P RESPONSE - MVC:INVOLVING BIKE/MOTORCYCLE",
        "ADDR:CHINQUAPIN ROUND RD & GEORGE AVE",
        "CITY:ANNAPOLIS",
        "MAP:20-E10-3527",
        "CH:B",
        "X:1898 GEORGE AVE & 1900 MARGARET AVE",
        "CODE:29D02L",
        "PHONE:410-212-7445",
        "INFO:2",
        "UNIT:E351  PM39  EMS36  ATRO",
        "TIME:13:51:59",
        "DATE:07/28/13");

    doTest("T29",
        "(_subject_) INCIDENT 201342441\n\n" +
        "CODE MS1     PX TYPE WITH E TK OR SQ     ALARM 1\n\n" +
        "DEFENSE HWY-AN/RT50 E          \n\n" +
        "Grid 20     Map B09     Area 4024     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street -  JOHN HANSON HWY E-AN\n\n" +
        "Nature: 29B04-MVC:UNKNOWN STATUS\n\n" +
        "Community of ANNAPOLIS RESTAURANT PARK (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (001488-)\n\n" +
        "TW40  PM35  \n\n" +
        "HYDRANTS: 100 DEFENSE HWY-AN (0) & 116 DEFENSE HWY-AN (0)\n\n" +
        "TIME 13:15:40          DATE 07/28/13",

        "ID:201342441",
        "CALL:PX TYPE WITH E TK OR SQ - MVC:UNKNOWN STATUS",
        "ADDR:DEFENSE HWY & RT50 E",
        "MADDR:DEFENSE HWY & RT 50 E",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS RESTAURANT PARK",
        "MAP:20-B09-4024",
        "CH:B",
        "X:JOHN HANSON HWY E",
        "CODE:29B04",
        "INFO:HYDRANTS: 100 DEFENSE HWY-AN (0) & 116 DEFENSE HWY-AN (0)",
        "UNIT:TW40  PM35",
        "TIME:13:15:40",
        "DATE:07/28/13");

    doTest("T30",
        "(_subject_) INCIDENT 201342433\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "21 WATER ST-AN          \n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 48 SHAW ST\n\n" +
        "Second cross street - 52 LARKIN ST\n\n" +
        "Nature: 26A10-SICK PERSON:FEELING ILL\n\n" +
        "Call back: 443-370-1017\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000781-30)\n" +
        "ProQaA: 79 Year Old Woman, Conscious, Breathing (000781-30)\n" +
        "ProQaA: - (000781-30)\n" +
        "ProQaA: The caller is with the patient. (000781-30)\n" +
        "ProQaA: There is a single patient. (000781-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000781-30)\n" +
        "ProQaA: She is breathing normally. (000781-30)\n" +
        "ProQaA: It's not known if she has any pain. (000781-30)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (000781-30)\n" +
        "ProQaA: She is unwell/ill. (000781-30)\n" +
        "Community of ANNAPOLIS CITY (000781-30)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (001488-)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n" +
        "Units 'on air': MU39 (001488-)\n\n" +
        "MU39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 12:47:14          DATE 07/28/13",

        "ID:201342433",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON:FEELING ILL",
        "ADDR:21 WATER ST",
        "CITY:ANNAPOLIS",
        "MAP:20-J10-3821",
        "CH:B",
        "X:48 SHAW ST & 52 LARKIN ST",
        "CODE:26A10",
        "PHONE:443-370-1017",
        "INFO:79 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nIt's not known if she has any pain.\nShe is not bleeding (or vomiting blood).\nShe is unwell/ill.\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A",
        "UNIT:MU39",
        "TIME:12:47:14",
        "DATE:07/28/13");

    doTest("T31",
        "(_subject_) INCIDENT 201342428\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "74 OLD MILL BOTTOM RD N     208     SUPER 8 MOTEL\n\n" +
        "Grid 21     Map B02     Area 1710     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip \n\n" +
        "First cross street - 1400 BRETTON VIEW RD\n\n" +
        "Second cross street - 1400 BRENWOODE RD\n\n" +
        "Nature: 32B03-UNKNOWN MEDICAL EMERG\n\n" +
        "Community of ROUTE 50 BETWEEN ROUTE 648 AND (001488-39)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n\n" +
        "E171  MU39  \n\n" +
        "HYDRANTS: 30 OLD MILL BOTTOM RD N (1284) & 34 OLD MILL BOTTOM RD N (1284)\n\n" +
        "CAUTION NOTES\n" +
        "AREA CAUTION NOTES FOR 1710\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC\n\n" +
        "TIME 12:17:21          DATE 07/28/13",

        "ID:201342428",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN MEDICAL EMERG",
        "ADDR:74 OLD MILL BOTTOM RD N",
        "APT:208",
        "PLACE:SUPER 8 MOTEL",
        "MAP:21-B02-1710",
        "CH:B",
        "X:1400 BRETTON VIEW RD & 1400 BRENWOODE RD",
        "CODE:32B03",
        "INFO:HYDRANTS: 30 OLD MILL BOTTOM RD N (1284) & 34 OLD MILL BOTTOM RD N (1284)\nCAUTION NOTES\nAREA CAUTION NOTES FOR 1710\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  HHC",
        "UNIT:E171  MU39",
        "TIME:12:17:21",
        "DATE:07/28/13");

    doTest("T32",
        "(_subject_) INCIDENT 201342427\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "140 GEORGETOWN RD     2     \n\n" +
        "Grid 26     Map A01     Area 3604     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2 SILVERWOOD CIR\n\n" +
        "Second cross street - 2 SILVERWOOD CIR\n\n" +
        "Nature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\n" +
        "Call back: 443-995-5090\n\n" +
        "Community of ANNAPOLIS CITY (009614-42)\n" +
        "TAC CHANNEL E ASSIGNED (001488-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (001488-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (001488-)\n\n" +
        "E84  E361  E351  LAD39  TW40  SQ38  PM36  BC35  ANAC1  APD  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 12:06:34          DATE 07/28/13",

        "ID:201342427",
        "CALL:COMMERCIAL BOX - ODOR GAS IN STRUCTURE (WARM)",
        "ADDR:140 GEORGETOWN RD",
        "APT:2",
        "CITY:ANNAPOLIS",
        "MAP:26-A01-3604",
        "CH:E",
        "X:2 SILVERWOOD CIR & 2 SILVERWOOD CIR",
        "CODE:F50S",
        "PHONE:443-995-5090",
        "UNIT:E84  E361  E351  LAD39  TW40  SQ38  PM36  BC35  ANAC1  APD",
        "TIME:12:06:34",
        "DATE:07/28/13");

    doTest("T33",
        "(_subject_) INCIDENT 201342401\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "816 BESTGATE RD          FOWLERS UNITED METH CHURCH\n\n" +
        "Grid 20     Map C07     Area 4027     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2200 FOWLERS DR\n\n" +
        "Second cross street - 2000 GATE DR\n\n" +
        "Nature: 09D01-CARDIAC ARREST:INEF BREATHING\n\n" +
        "Call back: 410-224-2149\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-42)\n" +
        "ProQaA: 50 Year Old Man, Unconscious, Uncertain if Breathing (009614-42)\n" +
        "ProQaA: - (009614-42)\n" +
        "ProQaA: The caller is with the patient. (009614-42)\n" +
        "ProQaA: There is a single patient. (009614-42)\n" +
        "ProQaA: The cardiac arrest was witnessed. (009614-42)\n" +
        "ProQaA: A defibrillator (AED) is not available. (009614-42)\n" +
        "Community of BESTGATE TERRACE (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (001488-)\n" +
        "Units 'on air': TW40 (001488-)\n" +
        "UNIT TW40 IS RESPONDING WITHOUT OFFICER\n" +
        "From TW40: PERSONS RESPONDING 3\n" +
        "UNIT E402 IS RESPONDING WITH OFFICER\n" +
        "From E402: PERSONS RESPONDING 2\n\n" +
        "E402  MU3  MU39  TW40  EMS36  \n\n" +
        "HYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)\n\n" +
        "TIME 09:16:51          DATE 07/28/13",

        "ID:201342401",
        "CALL:2 EMT/P RESPONSE - CARDIAC ARREST:INEF BREATHING",
        "ADDR:816 BESTGATE RD",
        "PLACE:FOWLERS UNITED METH CHURCH",
        "MAP:20-C07-4027",
        "CH:B",
        "X:2200 FOWLERS DR & 2000 GATE DR",
        "CODE:09D01",
        "PHONE:410-224-2149",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n50 Year Old Man, Unconscious, Uncertain if Breathing\nThe caller is with the patient.\nThere is a single patient.\nThe cardiac arrest was witnessed.\nA defibrillator (AED) is not available.\nUNIT TW40 IS RESPONDING WITHOUT OFFICER\nFrom TW40: PERSONS RESPONDING 3\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 2\nHYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)",
        "UNIT:E402  MU3  MU39  TW40  EMS36",
        "TIME:09:16:51",
        "DATE:07/28/13");

    doTest("T34",
        "(_subject_) INCIDENT 201342401\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "816 BESTGATE RD          FOWLERS UNITED METH CHURCH\n\n" +
        "Grid 20     Map C07     Area 4027     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2200 FOWLERS DR\n\n" +
        "Second cross street - 2000 GATE DR\n\n" +
        "Nature: 09D01-CARDIAC ARREST:INEF BREATHING\n\n" +
        "Call back: 410-224-2149\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009614-42)\n" +
        "ProQaA: 50 Year Old Man, Unconscious, Uncertain if Breathing (009614-42)\n" +
        "ProQaA: - (009614-42)\n" +
        "ProQaA: The caller is with the patient. (009614-42)\n" +
        "ProQaA: There is a single patient. (009614-42)\n" +
        "ProQaA: The cardiac arrest was witnessed. (009614-42)\n" +
        "ProQaA: A defibrillator (AED) is not available. (009614-42)\n" +
        "Community of BESTGATE TERRACE (009614-42)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n\n" +
        "E402  MU3  MU39  \n\n" +
        "HYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)\n\n" +
        "TIME 09:16:51          DATE 07/28/13",

        "ID:201342401",
        "CALL:2 EMT/P RESPONSE - CARDIAC ARREST:INEF BREATHING",
        "ADDR:816 BESTGATE RD",
        "PLACE:FOWLERS UNITED METH CHURCH",
        "MAP:20-C07-4027",
        "CH:B",
        "X:2200 FOWLERS DR & 2000 GATE DR",
        "CODE:09D01",
        "PHONE:410-224-2149",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n50 Year Old Man, Unconscious, Uncertain if Breathing\nThe caller is with the patient.\nThere is a single patient.\nThe cardiac arrest was witnessed.\nA defibrillator (AED) is not available.\nHYDRANTS: 824 BESTGATE RD (0) & 814 BESTGATE RD (3387)",
        "UNIT:E402  MU3  MU39",
        "TIME:09:16:51",
        "DATE:07/28/13");

    doTest("T35",
        "(_subject_) INCIDENT 201342400\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "2178 CHESAPEAKE HARBOUR DR E          \n\n" +
        "Grid 21     Map C13     Area 0836     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2156 SAND CASTLE DR\n\n" +
        "Second cross street - 2151 SAND CASTLE CT\n\n" +
        "Nature: 01A01-ABDOMINAL PAIN\n\n" +
        "Call back: 410-280-1826\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (000781-30)\n" +
        "ProQaA: 70 Year Old Woman, Conscious, Breathing (000781-30)\n" +
        "ProQaA: - (000781-30)\n" +
        "ProQaA: This is a 1st party caller. (000781-30)\n" +
        "ProQaA: There is a single patient. (000781-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000781-30)\n" +
        "ProQaA: The pain is described as: (000781-30)\n" +
        "ProQaA: There was no mention of aortic aneurysm or a tearing or (000781-30)\n" +
        "ProQaA: ripping pain in the back or flank and abdomen. (000781-30)\n" +
        "ProQaA: She has not fainted or nearly fainted. (000781-30)\n" +
        "ProQaA: She does not have pain above the belly button (navel). (000781-30)\n" +
        "Community of ANNAPOLIS ROADS (000781-30)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n" +
        "Units 'on air': MU362 (001488-)\n\n" +
        "MU362  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 09:13:45          DATE 07/28/13",

        "ID:201342400",
        "CALL:BLS WITH FIRST RESPONDER - ABDOMINAL PAIN",
        "ADDR:2178 CHESAPEAKE HARBOUR DR E",
        "PLACE:ANNAPOLIS ROADS",
        "MAP:21-C13-0836",
        "CH:B",
        "X:2156 SAND CASTLE DR & 2151 SAND CASTLE CT",
        "CODE:01A01",
        "PHONE:410-280-1826",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n70 Year Old Woman, Conscious, Breathing\nThis is a 1st party caller.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nThe pain is described as:\nThere was no mention of aortic aneurysm or a tearing or\nripping pain in the back or flank and abdomen.\nShe has not fainted or nearly fainted.\nShe does not have pain above the belly button (navel).",
        "UNIT:MU362",
        "TIME:09:13:45",
        "DATE:07/28/13");

    doTest("T36",
        "(_subject_) INCIDENT 201342391\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "511 ROYAL ST          \n\n" +
        "Grid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - SCHOONER CT\n\n" +
        "Nature: 10C04-CHEST PAIN:NORMAL RESP >35\n\n" +
        "Call back: 410-295-1596\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000781-30)\n" +
        "ProQaA: 52 Year Old Woman, Conscious, Breathing (000781-30)\n" +
        "ProQaA: - (000781-30)\n" +
        "ProQaA: The caller is with the patient. (000781-30)\n" +
        "ProQaA: There is a single patient. (000781-30)\n" +
        "ProQaA: This started (happened) more than 6hrs ago. (000781-30)\n" +
        "ProQaA: Her back pain was caused by another, non-specified condition. (000781-30)\n" +
        "ProQaA: She is not having difficulty breathing. (000781-30)\n" +
        "ProQaA: She has chest pain. (000781-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000781-30)\n" +
        "ProQaA: She is breathing normally. (000781-30)\n" +
        "ProQaA: She is not changing color. (000781-30)\n" +
        "ProQaA: She is not clammy. (000781-30)\n" +
        "ProQaA: She has not had a heart attack or angina (heart pains) before. (000781-30)\n" +
        "ProQaA: She took a prescribed medication in the past 12hrs: (000781-30)\n" +
        "ProQaA: TYLENOL (000781-30)\n" +
        "Community of ANNAPOLIS CITY (000781-30)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 07:38:40          DATE 07/28/13\n" +
        "HOSPITAL STATUS   07/28/13   07:40:48\n\n" +
        "JOHN HOPKINS HO    REROUTEINCIDENT 201342391\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "511 ROYAL ST          \n\n" +
        "Grid 20     Map E11     Area 3526     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - SCHOONER CT\n\n" +
        "Nature: 10C04-CHEST PAIN:NORMAL RESP >35\n\n" +
        "Call back: 410-295-1596\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (000781-30)\n" +
        "ProQaA: 52 Year Old Woman, Conscious, Breathing (000781-30)\n" +
        "ProQaA: - (000781-30)\n" +
        "ProQaA: The caller is with the patient. (000781-30)\n" +
        "ProQaA: There is a single patient. (000781-30)\n" +
        "ProQaA: This started (happened) more than 6hrs ago. (000781-30)\n" +
        "ProQaA: Her back pain was caused by another, non-specified condition. (000781-30)\n" +
        "ProQaA: She is not having difficulty breathing. (000781-30)\n" +
        "ProQaA: She has chest pain. (000781-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (000781-30)\n" +
        "ProQaA: She is breathing normally. (000781-30)\n" +
        "ProQaA: She is not changing color. (000781-30)\n" +
        "ProQaA: She is not clammy. (000781-30)\n" +
        "ProQaA: She has not had a heart attack or angina (heart pains) before. (000781-30)\n" +
        "ProQaA: She took a prescribed medication in the past 12hrs: (000781-30)\n" +
        "ProQaA: TYLENOL (000781-30)\n" +
        "Community of ANNAPOLIS CITY (000781-30)\n" +
        "TAC CHANNEL B ASSIGNED (001488-)\n\n" +
        "E351  PM35  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 07:38:40          DATE 07/28/13\n" +
        "HOSPITAL STATUS   07/28/13   07:40:48\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342391",
        "CALL:ONE EMT/P RESPONSE - CHEST PAIN:NORMAL RESP >35",
        "ADDR:511 ROYAL ST",
        "CITY:ANNAPOLIS",
        "MAP:20-E11-3526",
        "CH:B",
        "X:SCHOONER CT",
        "CODE:10C04",
        "PHONE:410-295-1596",
        "INFO:52 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis started (happened) more than 6hrs ago.\nHer back pain was caused by another, non-specified condition.\nShe is not having difficulty breathing.\nShe has chest pain.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe is not changing color.\nShe is not clammy.\nShe has not had a heart attack or angina (heart pains) before.\nShe took a prescribed medication in the past 12hrs:\nTYLENOL",
        "UNIT:E351  PM35  ATRO",
        "TIME:07:38:40",
        "DATE:07/28/13");

    doTest("T37",
        "(_subject_) INCIDENT 201342386\n\n" +
        "CODE BTP     ASSIST WITH SUSPICIOUS PACKAGE     ALARM 1\n\n" +
        "4211 MOUNTAIN RD-PA     GAS     SAFEWAY\n\n" +
        "Grid 09     Map G10     Area 1004     Preplan      Channel K    MOA 1\n\n" +
        "Census Tract      Zip 21122\n\n" +
        "First cross street - 4200 POSTAL CT\n\n" +
        "Second cross street - 2 MAGOTHY BEACH RD\n\n" +
        "Nature: F84A-ASSIST WITH SUSP. PKG. (HOT)\n\n" +
        "Call back: 410-439-4560\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009624-42)\n" +
        "Community of LAKE SHORE CENTER (009624-42)\n" +
        "TAC CHANNEL B ASSIGNED (009611-39)\n" +
        "Units 'on air': FM865 (009611-39)\n" +
        "AAPD Available 06:20:44 (009611-39)\n" +
        "SCA Available 06:21:06 (001252-)\n" +
        "UNIT FM860 IS RESPONDING WITH OFFICER\n" +
        "UNIT FM865 IS RESPONDING WITHOUT OFFICER\n" +
        "OPS3 Available 06:22:53 (000579-)\n" +
        "PIO5 Available 06:22:57 (000579-)\n" +
        "BC2 Available 06:23:02 (000579-)\n" +
        "UNIT E101 IS RESPONDING WITH OFFICER\n" +
        "From E101: PERSONS RESPONDING 2\n" +
        "Tactical channel changed from B to K (001488-)\n\n" +
        "E101  BC2  FM860  PIO5  OPS3  AAPD  SCA  FM865  ESU35  \n\n" +
        "HYDRANTS: 4302 MOUNTAIN RD-PA (9205) & 4105 MOUNTAIN RD-PA (0)\n" +
        "AREA CAUTION NOTES FOR 1004\n" +
        "CLOSEST HOSPITALS:  1)  NAH  (2)  AAMC  (3)  HHC\n\n" +
        "TIME 06:18:09          DATE 07/28/13\n" +
        "HOSPITAL STATUS   07/28/13   06:45:04\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342386",
        "CALL:ASSIST WITH SUSPICIOUS PACKAGE - ASSIST WITH SUSP. PKG. (HOT)",
        "ADDR:4211 MOUNTAIN RD",
        "APT:GAS",
        "CITY:PA",
        "PLACE:SAFEWAY",
        "MAP:09-G10-1004",
        "CH:K",
        "X:4200 POSTAL CT & 2 MAGOTHY BEACH RD",
        "CODE:F84A",
        "PHONE:410-439-4560",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nAAPD Available 06:20:44\nSCA Available 06:21:06\nUNIT FM860 IS RESPONDING WITH OFFICER\nUNIT FM865 IS RESPONDING WITHOUT OFFICER\nOPS3 Available 06:22:53\nPIO5 Available 06:22:57\nBC2 Available 06:23:02\nUNIT E101 IS RESPONDING WITH OFFICER\nFrom E101: PERSONS RESPONDING 2\nHYDRANTS: 4302 MOUNTAIN RD-PA (9205) & 4105 MOUNTAIN RD-PA (0)\nAREA CAUTION NOTES FOR 1004\nCLOSEST HOSPITALS:  1)  NAH  (2)  AAMC  (3)  HHC",
        "UNIT:E101  BC2  FM860  PIO5  OPS3  AAPD  SCA  FM865  ESU35",
        "TIME:06:18:09",
        "DATE:07/28/13");

    doTest("T38",
        "(_subject_) INCIDENT 201342380\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "900 VAN BUREN ST     23B     NEW ANNAPOLIS NURSING & REHAB\n\n" +
        "Grid 20     Map K13     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1298 BAY RIDGE AVE\n\n" +
        "Nature: 17B01-FALL:POSSIBLY DANGEROUS\n\n" +
        "Call back: 410-268-2124\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\n" +
        "ProQaA: FALL (001239-30)\n" +
        "ProQaA: 86 Year Old Man, Conscious, Breathing (001239-30)\n" +
        "ProQaA: The caller is not with the patient. (001239-30)\n" +
        "ProQaA: There is a single patient. (001239-30)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (001239-30)\n" +
        "ProQaA: It's reported that he fell at ground level. (001239-30)\n" +
        "ProQaA: The fall was accidental. (001239-30)\n" +
        "ProQaA: There is no bleeding now. (001239-30)\n" +
        "ProQaA: The reason for the fall is not known. (001239-30)\n" +
        "ProQaA: He is completely alert (responding appropriately). (001239-30)\n" +
        "ProQaA: The injury is to a POSSIBLY DANGEROUS area. (001239-30)\n" +
        "ProQaA: He is no longer on the floor (ground). (001239-30)\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "MU36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "FULLY SPRINKLERED.\n" +
        "19261\n" +
        "FDC LOCATED ON SIDE 1.\n" +
        "MAIN VALVE LOCATED IN BASEMENT, IN CORNER OF LAUNDRY ROOM.\n\n" +
        "TIME 04:45:57          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   04:47:54\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342380",
        "CALL:BLS WITH FIRST RESPONDER - FALL:POSSIBLY DANGEROUS",
        "ADDR:900 VAN BUREN ST",
        "APT:23B",
        "CITY:ANNAPOLIS",
        "PLACE:NEW ANNAPOLIS NURSING & REHAB",
        "MAP:20-K13-3602",
        "CH:B",
        "X:1298 BAY RIDGE AVE",
        "CODE:17B01",
        "PHONE:410-268-2124",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nFALL\n86 Year Old Man, Conscious, Breathing\nThe caller is not with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nThe reason for the fall is not known.\nHe is completely alert (responding appropriately).\nThe injury is to a POSSIBLY DANGEROUS area.\nHe is no longer on the floor (ground).\nCAUTION NOTES\nFULLY SPRINKLERED.\n19261\nFDC LOCATED ON SIDE 1.\nMAIN VALVE LOCATED IN BASEMENT, IN CORNER OF LAUNDRY ROOM.",
        "UNIT:MU36",
        "TIME:04:45:57",
        "DATE:07/28/13");

    doTest("T39",
        "(_subject_) INCIDENT 201342379\n\n" +
        "CODE CB     COMMERCIAL BOX     ALARM 1\n\n" +
        "140 GEORGETOWN RD          \n\n" +
        "Grid 26     Map A01     Area 3604     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 2 SILVERWOOD CIR\n\n" +
        "Second cross street - 2 SILVERWOOD CIR\n\n" +
        "Nature: F50S-ODOR GAS IN STRUCTURE (WARM)\n\n" +
        "Call back: 443-949-9336\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL E ASSIGNED (000579-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000579-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (000579-)\n\n" +
        "E84  E361  E351  LAD39  TW40  SQ38  MU8  BC35  ANAC1  APD  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 04:15:08          DATE 07/28/13",

        "ID:201342379",
        "CALL:COMMERCIAL BOX - ODOR GAS IN STRUCTURE (WARM)",
        "ADDR:140 GEORGETOWN RD",
        "CITY:ANNAPOLIS",
        "MAP:26-A01-3604",
        "CH:E",
        "X:2 SILVERWOOD CIR & 2 SILVERWOOD CIR",
        "CODE:F50S",
        "PHONE:443-949-9336",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL",
        "UNIT:E84  E361  E351  LAD39  TW40  SQ38  MU8  BC35  ANAC1  APD",
        "TIME:04:15:08",
        "DATE:07/28/13");

    doTest("T40",
        "(_subject_) INCIDENT 201342376\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1103 SMITHVILLE ST     128     WILEY BATES SENIOR HOUSING\n\n" +
        "Grid 20     Map G10     Area 3825     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 S VILLA AVE\n\n" +
        "Second cross street - 98 JOHNSON PL\n\n" +
        "Nature: 28C03U-STROKE:SPEECH PROB\n\n" +
        "Call back: 410-263-0397\n\n" +
        "ProQaA: 72 Year Old Man, Conscious, Breathing (001252-35)\n" +
        "ProQaA: Yes (001252-35)\n" +
        "ProQaA: - (001252-35)\n" +
        "ProQaA: This is a 4th party caller. (001252-35)\n" +
        "ProQaA: There is a single patient. (001252-35)\n" +
        "ProQaA: He is completely alert (responding appropriately). (001252-35)\n" +
        "ProQaA: It's not known if he is breathing normally. (001252-35)\n" +
        "ProQaA: He is having sudden speech problems. (001252-35)\n" +
        "ProQaA: It's not known when this started. (001252-35)\n" +
        "ProQaA: He has not had a STROKE before. (001252-35)\n" +
        "Community of ANNAPOLIS CITY (001252-35)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "KNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n" +
        "19286\n" +
        "THERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\n" +
        "TIME 03:01:25          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   03:03:18\n\n" +
        "JOHN HOPKINS HO    REROUTE\n\n" +
        "\rINCIDENT 201342376\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1103 SMITHVILLE ST     128     WILEY BATES SENIOR HOUSING\n\n" +
        "Grid 20     Map G10     Area 3825     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 S VILLA AVE\n\n" +
        "Second cross street - 98 JOHNSON PL\n\n" +
        "Nature: 28C03U-STROKE:SPEECH PROB\n\n" +
        "Call back: 410-263-0397\n\n" +
        "ProQaA: 72 Year Old Man, Conscious, Breathing (001252-35)\n" +
        "ProQaA: Yes (001252-35)\n" +
        "ProQaA: - (001252-35)\n" +
        "ProQaA: This is a 4th party caller. (001252-35)\n" +
        "ProQaA: There is a single patient. (001252-35)\n" +
        "ProQaA: He is completely alert (responding appropriately). (001252-35)\n" +
        "ProQaA: It's not known if he is breathing normally. (001252-35)\n" +
        "ProQaA: He is having sudden speech problems. (001252-35)\n" +
        "ProQaA: It's not known when this started. (001252-35)\n" +
        "ProQaA: He has not had a STROKE before. (001252-35)\n" +
        "Community of ANNAPOLIS CITY (001252-35)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "KNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n" +
        "19286\n" +
        "THERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\n" +
        "TIME 03:01:25          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   03:03:18\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342376",
        "CALL:ONE EMT/P RESPONSE - STROKE:SPEECH PROB",
        "ADDR:1103 SMITHVILLE ST",
        "APT:128",
        "CITY:ANNAPOLIS",
        "PLACE:WILEY BATES SENIOR HOUSING",
        "MAP:20-G10-3825",
        "CH:B",
        "X:100 S VILLA AVE & 98 JOHNSON PL",
        "CODE:28C03U",
        "PHONE:410-263-0397",
        "INFO:72 Year Old Man, Conscious, Breathing\nYes\nThis is a 4th party caller.\nThere is a single patient.\nHe is completely alert (responding appropriately).\nIt's not known if he is breathing normally.\nHe is having sudden speech problems.\nIt's not known when this started.\nHe has not had a STROKE before.\nCAUTION NOTES\nKNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n19286\nTHERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.",
        "UNIT:E381  MU39  ATRO",
        "TIME:03:01:25",
        "DATE:07/28/13");

    doTest("T41",
        "(_subject_) INCIDENT 201342371\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 GREEN ST\n\n" +
        "Second cross street - 98 RANDALL ST\n\n" +
        "Nature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\n" +
        "Call back: 443-975-4212\n\n" +
        "PROQA ABORTED\n" +
        "Community of ANNAPOLIS CITY (009611-39)\n" +
        "TAC CHANNEL B ASSIGNED (009611-39)\n\n" +
        "E381  MU39  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:01:47          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   02:04:54\n\n" +
        "JOHN HOPKINS HO    REROUTE\n\n" +
        "\rINCIDENT 201342371\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 GREEN ST\n\n" +
        "Second cross street - 98 RANDALL ST\n\n" +
        "Nature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\n" +
        "Call back: 443-975-4212\n\n" +
        "PROQA ABORTED\n" +
        "Community of ANNAPOLIS CITY (009611-39)\n" +
        "TAC CHANNEL B ASSIGNED (009611-39)\n\n" +
        "E381  MU39  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:01:47          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   02:04:54\n\n" +
        "JOHN HOPKINS HO    REROUTE\n\n" +
        "\rINCIDENT 201342371\n\n" +
        "CODE PM2     2 EMT/P RESPONSE     ALARM 1\n\n" +
        "100 MAIN ST-AN     B     ZACHARYS JEWELERS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 198 GREEN ST\n\n" +
        "Second cross street - 98 RANDALL ST\n\n" +
        "Nature: 04D01A-ASSAULT:UNCONSCIOUS/ARREST\n\n" +
        "Call back: 443-975-4212\n\n" +
        "PROQA ABORTED\n" +
        "Community of ANNAPOLIS CITY (009611-39)\n" +
        "TAC CHANNEL B ASSIGNED (009611-39)\n\n" +
        "E381  MU39  EMS36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:01:47          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   02:04:54\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342371",
        "CALL:2 EMT/P RESPONSE - ASSAULT:UNCONSCIOUS/ARREST",
        "ADDR:100 MAIN ST",
        "APT:B",
        "CITY:ANNAPOLIS",
        "PLACE:ZACHARYS JEWELERS",
        "MAP:21-A10-3824",
        "CH:B",
        "X:198 GREEN ST & 98 RANDALL ST",
        "CODE:04D01A",
        "PHONE:443-975-4212",
        "INFO:PROQA ABORTED\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  MU39  EMS36  ATRO",
        "TIME:02:01:47",
        "DATE:07/28/13");

    doTest("T42",
        "(_subject_) INCIDENT 201342369\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "1148 MEDGAR EVERS ST          \n\n" +
        "Grid 20     Map K12     Area 3602     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street - 1176 FREDERICK DOUGLASS ST\n\n" +
        "Nature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\n" +
        "Call back: 443-924-3266\n\n" +
        "ProQaA: 37 Year Old Woman, Conscious, Breathing (009624-42)\n" +
        "ProQaA: - (009624-42)\n" +
        "ProQaA: This is a 1st party caller. (009624-42)\n" +
        "ProQaA: There is a single patient. (009624-42)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009624-42)\n" +
        "ProQaA: She is breathing normally. (009624-42)\n" +
        "ProQaA: She has other pain: (009624-42)\n" +
        "ProQaA: NECK (009624-42)\n" +
        "ProQaA: She is not bleeding (or vomiting blood). (009624-42)\n" +
        "ProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (009624-42)\n" +
        "ProQaA: No priority symptoms (OMEGA conditions 2-28 not identified). (009624-42)\n" +
        "Community of ANNAPOLIS CITY (009624-42)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009611-39)\n" +
        "TAC CHANNEL B ASSIGNED (009611-39)\n\n" +
        "MU36  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 01:50:53          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   01:53:17\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342369",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON:NO PRIORITY COMPL",
        "ADDR:1148 MEDGAR EVERS ST",
        "CITY:ANNAPOLIS",
        "MAP:20-K12-3602",
        "CH:B",
        "CODE:26A01",
        "PHONE:443-924-3266",
        "INFO:37 Year Old Woman, Conscious, Breathing\nThis is a 1st party caller.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe has other pain:\nNECK\nShe is not bleeding (or vomiting blood).\nNo priority symptoms (ALPHA conditions 2-11 not identified).\nNo priority symptoms (OMEGA conditions 2-28 not identified).\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A",
        "UNIT:MU36",
        "TIME:01:50:53",
        "DATE:07/28/13");

    doTest("T43",
        "(_subject_) INCIDENT 201342366\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "17 BENS DR     E     \n\n" +
        "Grid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1 MARCS CT\n\n" +
        "Second cross street - 1 MARCS CT\n\n" +
        "Nature: 12A01E-SEIZURES:BREATHING VERIFIED\n\n" +
        "Call back: 410-268-1247\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009611-39)\n" +
        "ProQaA: 6 Year Old Girl, Conscious, Breathing (009611-39)\n" +
        "ProQaA: - (009611-39)\n" +
        "ProQaA: The caller is with the patient. (009611-39)\n" +
        "ProQaA: There is a single patient. (009611-39)\n" +
        "ProQaA: This is apparently a generalized (grand mal) seizure. (009611-39)\n" +
        "ProQaA: She has not had more than one seizure in a row. (009611-39)\n" +
        "ProQaA: She is not diabetic. (009611-39)\n" +
        "ProQaA: She is an epileptic (diagnosed with a seizure disorder). (009611-39)\n" +
        "ProQaA: She does not have a history of STROKE or brain tumor. (009611-39)\n" +
        "ProQaA: The jerking (twitching) has stopped. (009611-39)\n" +
        "ProQaA: She is breathing now. (009611-39)\n" +
        "ProQaA: Rate  =  18 breaths per minute (009611-39)\n" +
        "ProQaA: Normal or Abnormal* (009611-39)\n" +
        "ProQaA: She is breathing normally. (009611-39)\n" +
        "Community of ANNAPOLIS CITY (009611-39)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "E361  MU8  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "KNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n" +
        "17429\n" +
        "PROTECTED BY A 13R SPRINKLER SYSTEM.\n" +
        "19044\n" +
        "SINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\n" +
        "CONTROL VALVE LOCATED BEHIND THE FDC.\n\n" +
        "TIME 00:22:03          DATE 07/28/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/28/13   00:25:41\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342366",
        "CALL:ONE EMT/P RESPONSE - SEIZURES:BREATHING VERIFIED",
        "ADDR:17 BENS DR",
        "CITY:ANNAPOLIS",
        "PLACE:E",
        "MAP:25-K02-3604",
        "CH:B",
        "X:1 MARCS CT & 1 MARCS CT",
        "CODE:12A01E",
        "PHONE:410-268-1247",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\n6 Year Old Girl, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis is apparently a generalized (grand mal) seizure.\nShe has not had more than one seizure in a row.\nShe is not diabetic.\nShe is an epileptic (diagnosed with a seizure disorder).\nShe does not have a history of STROKE or brain tumor.\nThe jerking (twitching) has stopped.\nShe is breathing now.\nRate  =  18 breaths per minute\nNormal or Abnormal*\nShe is breathing normally.\nKNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n17429\nPROTECTED BY A 13R SPRINKLER SYSTEM.\n19044\nSINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\nCONTROL VALVE LOCATED BEHIND THE FDC.",
        "UNIT:E361  MU8  ATRO",
        "TIME:00:22:03",
        "DATE:07/28/13");

    doTest("T44",
        "(_subject_) INCIDENT 201342345\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "1 DOCK ST     1     CITY DOCK\n\n" +
        "Grid 21     Map A10     Area 3824A     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: 17A01-FALL:NOT DANGEROUS\n\n" +
        "Call back: 410-263-7973\n\n" +
        "ProQaA: 40 Year Old Man, Conscious, Breathing (009624-42)\n" +
        "ProQaA: - (009624-42)\n" +
        "ProQaA: The caller is with the patient. (009624-42)\n" +
        "ProQaA: There is a single patient. (009624-42)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009624-42)\n" +
        "ProQaA: It's reported that he fell at ground level. (009624-42)\n" +
        "ProQaA: The fall was accidental. (009624-42)\n" +
        "ProQaA: There is no bleeding now. (009624-42)\n" +
        "ProQaA: He is completely alert (responding appropriately). (009624-42)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\n" +
        "ProQaA: He is no longer on the floor (ground). (009624-42)\n" +
        "Community of ANNAPOLIS CITY (009624-42)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n" +
        "Call back number changed in ProQA from 8607161012 (009624-42)\n\n" +
        "MU39  E381  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 21:56:43          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   22:00:37\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342345",
        "CALL:BLS WITH FIRST RESPONDER - FALL:NOT DANGEROUS",
        "ADDR:1 DOCK ST",
        "APT:1",
        "CITY:ANNAPOLIS",
        "PLACE:CITY DOCK",
        "MAP:21-A10-3824A",
        "CH:B",
        "X:98 CRAIG ST",
        "CODE:17A01",
        "PHONE:410-263-7973",
        "INFO:40 Year Old Man, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nHe is no longer on the floor (ground).\nCall back number changed in ProQA from 8607161012",
        "UNIT:MU39  E381",
        "TIME:21:56:43",
        "DATE:07/27/13");

    doTest("T45",
        "(_subject_) INCIDENT 201342345\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "1 DOCK ST     1     CITY DOCK\n\n" +
        "Grid 21     Map A10     Area 3824A     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: 17A01-FALL:NOT DANGEROUS\n\n" +
        "Call back: 860-716-1012\n\n" +
        "ProQaA: 40 Year Old Man, Conscious, Breathing (009624-42)\n" +
        "ProQaA: - (009624-42)\n" +
        "ProQaA: The caller is with the patient. (009624-42)\n" +
        "ProQaA: There is a single patient. (009624-42)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009624-42)\n" +
        "ProQaA: It's reported that he fell at ground level. (009624-42)\n" +
        "ProQaA: The fall was accidental. (009624-42)\n" +
        "ProQaA: There is no bleeding now. (009624-42)\n" +
        "ProQaA: He is completely alert (responding appropriately). (009624-42)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\n" +
        "ProQaA: He is no longer on the floor (ground). (009624-42)\n" +
        "Community of ANNAPOLIS CITY (009624-42)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "MU39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 21:56:43          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   21:58:46\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342345",
        "CALL:BLS WITH FIRST RESPONDER - FALL:NOT DANGEROUS",
        "ADDR:1 DOCK ST",
        "APT:1",
        "CITY:ANNAPOLIS",
        "PLACE:CITY DOCK",
        "MAP:21-A10-3824A",
        "CH:B",
        "X:98 CRAIG ST",
        "CODE:17A01",
        "PHONE:860-716-1012",
        "INFO:40 Year Old Man, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nIt's reported that he fell at ground level.\nThe fall was accidental.\nThere is no bleeding now.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nHe is no longer on the floor (ground).",
        "UNIT:MU39",
        "TIME:21:56:43",
        "DATE:07/27/13");

    doTest("T46",
        "(_subject_) INCIDENT 201342322\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "19 BENS DR     A     \n\n" +
        "Grid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1 MARCS CT\n\n" +
        "Second cross street - 1 MARCS CT\n\n" +
        "Nature: 21B02-HEMORRHAGE/LAC:SERIOUS BLEED\n\n" +
        "Call back: 410-268-1859\n\n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (001239-30)\n" +
        "ProQaA: BLEEDING (001239-30)\n" +
        "ProQaA: 29 Year Old Woman, Conscious, Breathing (001239-30)\n" +
        "ProQaA: - (001239-30)\n" +
        "ProQaA: The caller is with the patient. (001239-30)\n" +
        "ProQaA: There is a single patient. (001239-30)\n" +
        "ProQaA: The cause of the bleeding is non-traumatic. (001239-30)\n" +
        "ProQaA: The bleeding is from a NOT DANGEROUS area. (001239-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (001239-30)\n" +
        "ProQaA: She is breathing normally. (001239-30)\n" +
        "ProQaA: There is SERIOUS bleeding. (001239-30)\n" +
        "ProQaA: She does not have a bleeding disorder or is taking blood (001239-30)\n" +
        "ProQaA: thinners. (001239-30)\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "MU36  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "KNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n" +
        "17429\n" +
        "PROTECTED BY A 13R SPRINKLER SYSTEM.\n" +
        "19044\n" +
        "SINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\n" +
        "CONTROL VALVE LOCATED BEHIND THE FDC.\n\n" +
        "TIME 20:04:23          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   20:06:03\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342322",
        "CALL:BLS WITH FIRST RESPONDER - HEMORRHAGE/LAC:SERIOUS BLEED",
        "ADDR:19 BENS DR",
        "CITY:ANNAPOLIS",
        "PLACE:A",
        "MAP:25-K02-3604",
        "CH:B",
        "X:1 MARCS CT & 1 MARCS CT",
        "CODE:21B02",
        "PHONE:410-268-1859",
        "INFO:ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nBLEEDING\n29 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThe cause of the bleeding is non-traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is SERIOUS bleeding.\nShe does not have a bleeding disorder or is taking blood\nthinners.\nKNOX BOX ON SIDE 1 OF COMMUNITY CENTER AT 1 BENS DR, RIGHT OF ENTRY DOOR.\n17429\nPROTECTED BY A 13R SPRINKLER SYSTEM.\n19044\nSINGLE INLET FDC LOCATED TO THE LEFT OF THE MAIN ENTRANCE.\nCONTROL VALVE LOCATED BEHIND THE FDC.",
        "UNIT:MU36",
        "TIME:20:04:23",
        "DATE:07/27/13");

    doTest("T47",
        "(_subject_) INCIDENT 201342321\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "97 CLAY ST          \n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 BREWER ST\n\n" +
        "Second cross street - 60 PLEASANT ST-AN\n\n" +
        "Nature: 10D04-CHEST PAIN:CLAMMY\n\n" +
        "Call back: 443-481-8536\n\n" +
        "ProQaA: 57 Year Old Woman, Conscious, Breathing (009624-)\n" +
        "ProQaA: - (009624-)\n" +
        "ProQaA: The caller is with the patient. (009624-)\n" +
        "ProQaA: There is a single patient. (009624-)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009624-)\n" +
        "ProQaA: She is breathing normally. (009624-)\n" +
        "ProQaA: She is not breathing normally. (009624-)\n" +
        "ProQaA: She does not have any difficulty speaking between breaths. (009624-)\n" +
        "ProQaA: She is not changing color. (009624-)\n" +
        "ProQaA: She is clammy. (009624-)\n" +
        "Community of ANNAPOLIS CITY (009624-)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:53:47          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   19:55:17\n\n" +
        "JOHN HOPKINS HO    REROUTE\n\n" +
        "\rINCIDENT 201342321\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "97 CLAY ST          \n\n" +
        "Grid 20     Map J10     Area 3821     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 BREWER ST\n\n" +
        "Second cross street - 60 PLEASANT ST-AN\n\n" +
        "Nature: 10D04-CHEST PAIN:CLAMMY\n\n" +
        "Call back: 443-481-8536\n\n" +
        "ProQaA: 57 Year Old Woman, Conscious, Breathing (009624-)\n" +
        "ProQaA: - (009624-)\n" +
        "ProQaA: The caller is with the patient. (009624-)\n" +
        "ProQaA: There is a single patient. (009624-)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009624-)\n" +
        "ProQaA: She is breathing normally. (009624-)\n" +
        "ProQaA: She is not breathing normally. (009624-)\n" +
        "ProQaA: She does not have any difficulty speaking between breaths. (009624-)\n" +
        "ProQaA: She is not changing color. (009624-)\n" +
        "ProQaA: She is clammy. (009624-)\n" +
        "Community of ANNAPOLIS CITY (009624-)\n" +
        "TAC CHANNEL B ASSIGNED (009617-)\n\n" +
        "E381  MU39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 19:53:47          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   19:55:17\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342321",
        "CALL:ONE EMT/P RESPONSE - CHEST PAIN:CLAMMY",
        "ADDR:97 CLAY ST",
        "CITY:ANNAPOLIS",
        "MAP:20-J10-3821",
        "CH:B",
        "X:2 BREWER ST & 60 PLEASANT ST",
        "CODE:10D04",
        "PHONE:443-481-8536",
        "INFO:57 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nShe is not breathing normally.\nShe does not have any difficulty speaking between breaths.\nShe is not changing color.\nShe is clammy.",
        "UNIT:E381  MU39  ATRO",
        "TIME:19:53:47",
        "DATE:07/27/13");

    doTest("T48",
        "(_subject_) INCIDENT 201342314\n\n" +
        "CODE WRO     DROWNING OPEN WATER     ALARM 2\n\n" +
        "BAY FRONT AVE/MYRTLE AVE-NB          \n\n" +
        "Grid 36     Map E03     Area 4237     Preplan      Channel L    MOA 1\n\n" +
        "Census Tract      Zip 20714\n\n" +
        "First cross street - 7000 MYRTLE AVE-NB\n\n" +
        "Second cross street - 7000 PALMETTO AVE\n\n" +
        "Nature: R39O-DROWNING OPEN WATER (HOT)\n\n" +
        "Community of NORTH BEACH PARK (000579-)\n" +
        "TAC CHANNEL L ASSIGNED (009617-)\n" +
        "Unit 'FB60' had changed quarters for unit 'FB19' (009617-)\n\n" +
        "FB60  FB41  CSQ5  E421  PM9  CTW1  FB36  U23  DU8  BC3  SCMD  USCG  DNR  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 4237\n" +
        "STAGING AREA FOR W/R: LAKESHORE DR & WALNUT AVE\n" +
        "BOAT RAMP:(BOX 4217, HERRINGTON HARBOUR NORTH,RT256 & TRACY CK\n" +
        "(Small sand beach at herrington harbour south can be used but\n" +
        "4 wheel drive vehicles ( must be used )\n" +
        "LZ:\n\n" +
        "TIME 18:48:56          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   18:50:24\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342314",
        "CALL:DROWNING OPEN WATER     ALARM 2 - DROWNING OPEN WATER (HOT)",
        "ADDR:BAY FRONT AVE & MYRTLE AVE",
        "CITY:NB",
        "PLACE:NORTH BEACH PARK",
        "MAP:36-E03-4237",
        "CH:L",
        "X:7000 MYRTLE AVE & 7000 PALMETTO AVE",
        "CODE:R39O",
        "INFO:AREA CAUTION NOTES FOR 4237\nSTAGING AREA FOR W/R: LAKESHORE DR & WALNUT AVE\nBOAT RAMP:(BOX 4217, HERRINGTON HARBOUR NORTH,RT256 & TRACY CK\n(Small sand beach at herrington harbour south can be used but\n4 wheel drive vehicles ( must be used )\nLZ:",
        "UNIT:FB60  FB41  CSQ5  E421  PM9  CTW1  FB36  U23  DU8  BC3  SCMD  USCG  DNR",
        "TIME:18:48:56",
        "DATE:07/27/13");

    doTest("T49",
        "(_subject_) INCIDENT 201342307\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "8 MILLHAVEN CT          \n\n" +
        "Grid 24     Map J04     Area 0222     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21037\n\n" +
        "First cross street - 2110 MILLHAVEN DR\n\n" +
        "Second cross street - 2110 MILLHAVEN DR\n\n" +
        "Nature: 03A03-ANIMAL BITE:SUPERFICIAL BITE\n\n" +
        "Call back: 410-956-3267\n\n" +
        "ProQaA: 2 Year Old Boy, Conscious, Breathing (009624-42)\n" +
        "ProQaA: - (009624-42)\n" +
        "ProQaA: The caller is with the patient. (009624-42)\n" +
        "ProQaA: There is a single patient. (009624-42)\n" +
        "ProQaA: This happened now (less than 6hrs ago). (009624-42)\n" +
        "ProQaA: He was bitten/injured by a dog. (009624-42)\n" +
        "ProQaA: The animal has been locked up or captured. (009624-42)\n" +
        "ProQaA: There is some bleeding, not serious. (009624-42)\n" +
        "ProQaA: He is completely alert (responding appropriately). (009624-42)\n" +
        "ProQaA: The injury is to a NOT DANGEROUS area. (009624-42)\n" +
        "ProQaA: He has a superficial bite. (009624-42)\n" +
        "Community of RIVER OAKS (009624-42)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n" +
        "Unit 'ME2' had changed quarters for unit 'E21' (000579-)\n\n" +
        "ME2  PM35  \n\n" +
        "HYDRANTS: 12 MILLHAVEN CT (2638) & 36 MILLHAVEN CT (0)\n" +
        "AREA CAUTION NOTES FOR 0222\n" +
        "STAGING AREA FOR W/R: EDGEWATER ELEMENTARY\n" +
        "BOAT RAMP: RIVERSIDE RD AND PARK RD\n" +
        "LZ:\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG\n\n" +
        "TIME 17:57:14          DATE 07/27/13\n" +
        "HOSPITAL STATUS   07/27/13   17:59:48\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342307",
        "CALL:BLS WITH FIRST RESPONDER - ANIMAL BITE:SUPERFICIAL BITE",
        "ADDR:8 MILLHAVEN CT",
        "PLACE:RIVER OAKS",
        "MAP:24-J04-0222",
        "CH:B",
        "X:2110 MILLHAVEN DR & 2110 MILLHAVEN DR",
        "CODE:03A03",
        "PHONE:410-956-3267",
        "INFO:2 Year Old Boy, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThis happened now (less than 6hrs ago).\nHe was bitten/injured by a dog.\nThe animal has been locked up or captured.\nThere is some bleeding, not serious.\nHe is completely alert (responding appropriately).\nThe injury is to a NOT DANGEROUS area.\nHe has a superficial bite.\nHYDRANTS: 12 MILLHAVEN CT (2638) & 36 MILLHAVEN CT (0)\nAREA CAUTION NOTES FOR 0222\nSTAGING AREA FOR W/R: EDGEWATER ELEMENTARY\nBOAT RAMP: RIVERSIDE RD AND PARK RD\nLZ:\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGG",
        "UNIT:ME2  PM35",
        "TIME:17:57:14",
        "DATE:07/27/13");

    doTest("T50",
        "(_subject_) INCIDENT 201342305\n\n" +
        "CODE WRL     WATER RESCUE LOCAL     ALARM 1\n\n" +
        "E LAKE DR-AN/SANDS AVE          \n\n" +
        "Grid 26     Map E03     Area 0819     Preplan      Channel K    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 12 SANDS AVE\n\n" +
        "Nature: R13-BOAT ACCIDENT (HOT)\n\n" +
        "Community of BAY RIDGE (009624-42)\n" +
        "TAC CHANNEL K ASSIGNED (000579-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000579-)\n\n" +
        "E84  FB36  FB41  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 0819\n" +
        "CLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD\n\n" +
        "TIME 17:51:52          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   17:53:50\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342305",
        "CALL:WATER RESCUE LOCAL - BOAT ACCIDENT (HOT)",
        "ADDR:E LAKE DR & SANDS AVE",
        "CITY:ANNAPOLIS",
        "PLACE:BAY RIDGE",
        "MAP:26-E03-0819",
        "CH:K",
        "X:12 SANDS AVE",
        "CODE:R13",
        "INFO:AREA CAUTION NOTES FOR 0819\nCLOSEST HOSPITALS:  1)  AAMC  (2)  NAH  (3)  PGD",
        "UNIT:E84  FB36  FB41",
        "TIME:17:51:52",
        "DATE:07/27/13");

    doTest("T51",
        "(_subject_) INCIDENT 201342301\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "4 DOCK ST          MULTI BUSINESS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: F05W-ALARM: WATER FLOW (WARM)\n\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL E ASSIGNED (000579-)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 17:17:42          DATE 07/27/13\n" +
        "\rINCIDENT 201342301\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "4 DOCK ST          MULTI BUSINESS\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel E    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 98 CRAIG ST-AN\n\n" +
        "Nature: F05W-ALARM: WATER FLOW (WARM)\n\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL E ASSIGNED (000579-)\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 17:17:42          DATE 07/27/13",

        "ID:201342301",
        "CALL:STILL ALARM - ALARM: WATER FLOW (WARM)",
        "ADDR:4 DOCK ST",
        "CITY:ANNAPOLIS",
        "PLACE:MULTI BUSINESS",
        "MAP:21-A10-3824",
        "CH:E",
        "X:98 CRAIG ST",
        "CODE:F05W",
        "INFO:AREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  LAD39",
        "TIME:17:17:42",
        "DATE:07/27/13");

    doTest("T52",
        "(_subject_) INCIDENT 201342264\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "48 FLEET ST          \n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 88 EAST ST\n\n" +
        "Second cross street - 2 CORNHILL ST\n\n" +
        "Nature: 28C01C-STROKE: NOT ALERT\n\n" +
        "ProQaA: 104 Year Old Woman, Unconscious, Breathing (001488-42)\n" +
        "ProQaA: There is a single patient. (001488-42)\n" +
        "ProQaA: Yes (001488-42)\n" +
        "ProQaA: - (001488-42)\n" +
        "ProQaA: The caller is with the patient. (001488-42)\n" +
        "ProQaA: She is breathing normally. (001488-42)\n" +
        "ProQaA: She is having sudden paralysis or facial droop on one side of (001488-42)\n" +
        "ProQaA: the body. (001488-42)\n" +
        "ProQaA: The Stroke Diagnostic results indicate partial evidence of (001488-42)\n" +
        "ProQaA: stroke. (001488-42)\n" +
        "ProQaA: These symptoms (problem) started: (001488-42)\n" +
        "ProQaA: 15 MINS (001488-42)\n" +
        "ProQaA: It's not known if she has had a STROKE before. (001488-42)\n" +
        "Community of ANNAPOLIS CITY (001488-42)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n" +
        "Units 'on air': E381 (000781-39)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 14:24:49          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   14:27:44\n\n" +
        "JOHN HOPKINS HO    REROUTE\n\n" +
        "\rINCIDENT 201342264\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "48 FLEET ST          \n\n" +
        "Grid 20     Map K10     Area 3824     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 88 EAST ST\n\n" +
        "Second cross street - 2 CORNHILL ST\n\n" +
        "Nature: 28C01C-STROKE: NOT ALERT\n\n" +
        "ProQaA: 104 Year Old Woman, Unconscious, Breathing (001488-42)\n" +
        "ProQaA: There is a single patient. (001488-42)\n" +
        "ProQaA: Yes (001488-42)\n" +
        "ProQaA: - (001488-42)\n" +
        "ProQaA: The caller is with the patient. (001488-42)\n" +
        "ProQaA: She is breathing normally. (001488-42)\n" +
        "ProQaA: She is having sudden paralysis or facial droop on one side of (001488-42)\n" +
        "ProQaA: the body. (001488-42)\n" +
        "ProQaA: The Stroke Diagnostic results indicate partial evidence of (001488-42)\n" +
        "ProQaA: stroke. (001488-42)\n" +
        "ProQaA: These symptoms (problem) started: (001488-42)\n" +
        "ProQaA: 15 MINS (001488-42)\n" +
        "ProQaA: It's not known if she has had a STROKE before. (001488-42)\n" +
        "Community of ANNAPOLIS CITY (001488-42)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n" +
        "Units 'on air': E381 (000781-39)\n\n" +
        "E381  PM39  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 14:24:49          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   14:27:44\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342264",
        "CALL:ONE EMT/P RESPONSE - STROKE: NOT ALERT",
        "ADDR:48 FLEET ST",
        "CITY:ANNAPOLIS",
        "MAP:20-K10-3824",
        "CH:B",
        "X:88 EAST ST & 2 CORNHILL ST",
        "CODE:28C01C",
        "INFO:104 Year Old Woman, Unconscious, Breathing\nThere is a single patient.\nYes\nThe caller is with the patient.\nShe is breathing normally.\nShe is having sudden paralysis or facial droop on one side of\nthe body.\nThe Stroke Diagnostic results indicate partial evidence of\nstroke.\nThese symptoms (problem) started:\n15 MINS\nIt's not known if she has had a STROKE before.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  PM39  ATRO",
        "TIME:14:24:49",
        "DATE:07/27/13");

    doTest("T53",
        "(_subject_) INCIDENT 201342254\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "1507 WEST ST     A     \n\n" +
        "Grid 20     Map F10     Area 3527     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 S HOMELAND AVE\n\n" +
        "Second cross street - 2 N SOUTHWOOD AVE\n\n" +
        "Nature: 25B03-PSYCH EMER:THREATENING SUICIDE\n\n" +
        "Call back: 443-333-0761\n\n" +
        "ProQaA: 44 Year Old Man, Conscious, Breathing (001239-30)\n" +
        "ProQaA: There is a single patient. (001239-30)\n" +
        "ProQaA: - (001239-30)\n" +
        "ProQaA: This is a 1st party caller. (001239-30)\n" +
        "ProQaA: He is not completely alert (not responding appropriately). (001239-30)\n" +
        "ProQaA: His primary problem is that he needs transportation: (001239-30)\n" +
        "ProQaA: No priority symptoms (ALPHA conditions 2-11 not identified). (001239-30)\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n\n" +
        "PM35  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 13:22:19          DATE 07/27/13\n" +
        "HOSPITAL STATUS   07/27/13   13:24:51\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342254",
        "CALL:BLS WITH FIRST RESPONDER - PSYCH EMER:THREATENING SUICIDE",
        "ADDR:1507 WEST ST",
        "CITY:ANNAPOLIS",
        "PLACE:A",
        "MAP:20-F10-3527",
        "CH:B",
        "X:100 S HOMELAND AVE & 2 N SOUTHWOOD AVE",
        "CODE:25B03",
        "PHONE:443-333-0761",
        "INFO:44 Year Old Man, Conscious, Breathing\nThere is a single patient.\nThis is a 1st party caller.\nHe is not completely alert (not responding appropriately).\nHis primary problem is that he needs transportation:\nNo priority symptoms (ALPHA conditions 2-11 not identified).",
        "UNIT:PM35",
        "TIME:13:22:19",
        "DATE:07/27/13");

    doTest("T54",
        "(_subject_) INCIDENT 201342253\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "940 BAY FOREST CT-EP          BAY FOREST SENIOR APTS\n\n" +
        "Grid 26     Map A02     Area 3605     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 933 EDGEWOOD RD-EP\n\n" +
        "Nature: 32B02-MEDICAL ALERT ALARM\n\n" +
        "Community of ANNAPOLIS CITY (001239-30)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n" +
        "Unit 'MU362' had changed quarters for unit 'PM36' (000781-39)\n" +
        "Units 'on air': MU362 (000781-39)\n\n" +
        "MU362  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "AREA CAUTION NOTES FOR 3605\n" +
        "ADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\n" +
        "IN THE CHESAPEAKE APT. COMPLEX\n\n" +
        "TIME 13:16:51          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   13:19:40\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342253",
        "CALL:BLS WITH FIRST RESPONDER - MEDICAL ALERT ALARM",
        "ADDR:940 BAY FOREST CT",
        "CITY:ANNAPOLIS",
        "PLACE:BAY FOREST SENIOR APTS",
        "MAP:26-A02-3605",
        "CH:B",
        "X:933 EDGEWOOD RD",
        "CODE:32B02",
        "INFO:AREA CAUTION NOTES FOR 3605\nADDRESSES BETWEEN 1111 AND 1200 LAKE HERON DR. ARE LOCATED\nIN THE CHESAPEAKE APT. COMPLEX",
        "UNIT:MU362",
        "TIME:13:16:51",
        "DATE:07/27/13");

    doTest("T55",
        "(_subject_) INCIDENT 201342220\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "710 BALLAST WAY          \n\n" +
        "Grid 19     Map F11     Area 4013     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n\n" +
        "Second cross street - 2712 S HAVEN RD\n\n" +
        "Nature: 28C01J-STROKE: NOT ALERT\n\n" +
        "Call back: 410-224-4687\n\n" +
        "VERIFY PD VERIFY FD VERIFY EMS (001239-30)\n" +
        "ProQaA: 83 Year Old Woman, Conscious, Breathing (001239-30)\n" +
        "ProQaA: There is a single patient. (001239-30)\n" +
        "ProQaA: Yes (001239-30)\n" +
        "ProQaA: - (001239-30)\n" +
        "ProQaA: The caller is with the patient. (001239-30)\n" +
        "ProQaA: She is not completely alert (not responding appropriately). (001239-30)\n" +
        "ProQaA: She is breathing normally. (001239-30)\n" +
        "ProQaA: She is having sudden speech problems. (001239-30)\n" +
        "ProQaA: The Stroke Diagnostic results indicate clear evidence of (001239-30)\n" +
        "ProQaA: stroke. (001239-30)\n" +
        "ProQaA: These symptoms (problem) started: (001239-30)\n" +
        "ProQaA: 10 MINS AGO (001239-30)\n" +
        "ProQaA: She has had a STROKE before. (001239-30)\n" +
        "Community of HERITAGE HARBOR (001239-30)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n" +
        "Units 'on air': PM35 (000781-39)\n\n" +
        "E402  PM35  \n\n" +
        "HYDRANTS: 740 BALLAST WAY (0) & 701 BALLAST WAY (1487)\n" +
        "AREA CAUTION NOTES FOR 4013\n" +
        "STAGING AREA FOR W/R: THE END OF SOUTH COURT\n" +
        "BOAT RAMP: (BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE\n" +
        "LZ:\n\n" +
        "TIME 10:08:10          DATE 07/27/13\n" +
        "HOSPITAL STATUS   07/27/13   10:11:05\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342220",
        "CALL:ONE EMT/P RESPONSE - STROKE: NOT ALERT",
        "ADDR:710 BALLAST WAY",
        "PLACE:HERITAGE HARBOR",
        "MAP:19-F11-4013",
        "CH:B",
        "CODE:28C01J",
        "PHONE:410-224-4687",
        "INFO:83 Year Old Woman, Conscious, Breathing\nThere is a single patient.\nYes\nThe caller is with the patient.\nShe is not completely alert (not responding appropriately).\nShe is breathing normally.\nShe is having sudden speech problems.\nThe Stroke Diagnostic results indicate clear evidence of\nstroke.\nThese symptoms (problem) started:\n10 MINS AGO\nShe has had a STROKE before.\nHYDRANTS: 740 BALLAST WAY (0) & 701 BALLAST WAY (1487)\nAREA CAUTION NOTES FOR 4013\nSTAGING AREA FOR W/R: THE END OF SOUTH COURT\nBOAT RAMP: (BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE\nLZ:",
        "UNIT:E402  PM35",
        "TIME:10:08:10",
        "DATE:07/27/13");

    doTest("T56",
        "(_subject_) INCIDENT 201342198\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "1103 SMITHVILLE ST     223     WILEY BATES SENIOR HOUSING\n\n" +
        "Grid 20     Map G10     Area 3825     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 100 S VILLA AVE\n\n" +
        "Second cross street - 98 JOHNSON PL\n\n" +
        "Nature: 17B01-FALL:POSSIBLY DANGEROUS\n\n" +
        "Community of ANNAPOLIS CITY (001488-43)\n" +
        "TAC CHANNEL B ASSIGNED (000781-39)\n\n" +
        "PM39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "CAUTION NOTES\n" +
        "KNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n" +
        "19286\n" +
        "THERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.\n\n" +
        "TIME 08:03:03          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   08:04:13\n\n" +
        "JOHN HOPKINS HO    REROUTE",

        "ID:201342198",
        "CALL:BLS WITH FIRST RESPONDER - FALL:POSSIBLY DANGEROUS",
        "ADDR:1103 SMITHVILLE ST",
        "APT:223",
        "CITY:ANNAPOLIS",
        "PLACE:WILEY BATES SENIOR HOUSING",
        "MAP:20-G10-3825",
        "CH:B",
        "X:100 S VILLA AVE & 98 JOHNSON PL",
        "CODE:17B01",
        "INFO:CAUTION NOTES\nKNOX BOX LOCATED NEXT TO MAIN ENTRANCE.\n19286\nTHERE IS A KEY BOX IN THE FILE ROOM, WITH KEYS TO RESIDENCE ROOMS.",
        "UNIT:PM39",
        "TIME:08:03:03",
        "DATE:07/27/13");

    doTest("T57",
        "(_subject_) INCIDENT 201342184\n\n" +
        "CODE SA     STILL ALARM     ALARM 1\n\n" +
        "6 SKIPPERS CT          \n\n" +
        "Grid 26     Map A02     Area 3604     Preplan      Channel E    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n\n" +
        "Second cross street -  YACHTSMAN WAY\n\n" +
        "Nature: F50-ODOR OF SMOKE INSIDE (WARM)\n\n" +
        "Call back: 410-268-1717\n\n" +
        "IN KITCHEN (000557-35)\n" +
        "Community of ANNAPOLIS CITY (000557-35)\n" +
        "TAC CHANNEL E ASSIGNED (000579-)\n" +
        "Unit 'E84' had changed quarters for unit 'E81' (000579-)\n\n" +
        "E84  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 04:45:56          DATE 07/27/13",

        "ID:201342184",
        "CALL:STILL ALARM - ODOR OF SMOKE INSIDE (WARM)",
        "ADDR:6 SKIPPERS CT",
        "CITY:ANNAPOLIS",
        "MAP:26-A02-3604",
        "CH:E",
        "CODE:F50",
        "PHONE:410-268-1717",
        "INFO:IN KITCHEN",
        "UNIT:E84  LAD39",
        "TIME:04:45:56",
        "DATE:07/27/13");

    doTest("T58",
        "(_subject_) INCIDENT 201342172\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "143 COMPROMISE ST          ANNAPOLIS SUMMER GARDEN\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 MAIN ST-AN\n\n" +
        "Second cross street - 98 NEWMAN ST\n\n" +
        "Nature: 21B02-HEMORRHAGE/LAC:SERIOUS BLEED\n\n" +
        "Call back: 443-895-0049\n\n" +
        "ProQaA: 30 Year Old Woman, Conscious, Breathing (009617-30)\n" +
        "ProQaA: - (009617-30)\n" +
        "ProQaA: The caller is with the patient. (009617-30)\n" +
        "ProQaA: There is a single patient. (009617-30)\n" +
        "ProQaA: The cause of the bleeding is traumatic. (009617-30)\n" +
        "ProQaA: The bleeding is from a NOT DANGEROUS area. (009617-30)\n" +
        "ProQaA: She is completely alert (responding appropriately). (009617-30)\n" +
        "ProQaA: She is breathing normally. (009617-30)\n" +
        "ProQaA: There is blood spurting or pouring out (after dispatch, go to (009617-30)\n" +
        "ProQaA: Control Bleeding in DLS Links). (009617-30)\n" +
        "ProQaA: She does not have a bleeding disorder or is taking blood (009617-30)\n" +
        "ProQaA: thinners. (009617-30)\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n" +
        "Unit 'MU362' had changed quarters for unit 'MU36' (000579-)\n\n" +
        "E381  MU362  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "DRY PIPE SPRINKLER SYSTEM.\n" +
        "19011\n" +
        "FDC LOCATED AT SIDE 1/2 CORNER.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 02:38:59          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   02:42:14\n\n" +
        "JOHN HOPKINS HO    YELLOW",

        "ID:201342172",
        "CALL:BLS WITH FIRST RESPONDER - HEMORRHAGE/LAC:SERIOUS BLEED",
        "ADDR:143 COMPROMISE ST",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS SUMMER GARDEN",
        "MAP:21-A10-3824",
        "CH:B",
        "X:2 MAIN ST & 98 NEWMAN ST",
        "CODE:21B02",
        "PHONE:443-895-0049",
        "INFO:30 Year Old Woman, Conscious, Breathing\nThe caller is with the patient.\nThere is a single patient.\nThe cause of the bleeding is traumatic.\nThe bleeding is from a NOT DANGEROUS area.\nShe is completely alert (responding appropriately).\nShe is breathing normally.\nThere is blood spurting or pouring out (after dispatch, go to\nControl Bleeding in DLS Links).\nShe does not have a bleeding disorder or is taking blood\nthinners.\nAUTO SPRINKLER SYSTEM\nDRY PIPE SPRINKLER SYSTEM.\n19011\nFDC LOCATED AT SIDE 1/2 CORNER.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  MU362",
        "TIME:02:38:59",
        "DATE:07/27/13");

    doTest("T59",
        "(_subject_) INCIDENT 201342168\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1175 MADISON ST-AN     B2     HARBOUR HOUSE APTS\n\n" +
        "Grid 20     Map J12     Area 3602     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 8 SPA CREEK LANDING\n\n" +
        "Second cross street - 1000 PRESIDENT ST\n\n" +
        "Nature: 32B03-UNKNOWN MEDICAL EMERG\n\n" +
        "Call back: 410-263-4275\n\n" +
        "3RD PARTY (000582-39)\n" +
        "POSSIBLE LEG PAIN (000582-39)\n" +
        "72YO FEMALE (000582-39)\n" +
        "Community of ANNAPOLIS CITY (000582-39)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "KNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n" +
        "17429\n" +
        "BY MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\n" +
        "TIME 02:01:32          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   02:02:40\n\n" +
        "JOHN HOPKINS HO    YELLOW\n\n" +
        "\rINCIDENT 201342168\n\n" +
        "CODE PM1     ONE EMT/P RESPONSE     ALARM 1\n\n" +
        "1175 MADISON ST-AN     B2     HARBOUR HOUSE APTS\n\n" +
        "Grid 20     Map J12     Area 3602     Preplan      Channel B    MOA \n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 8 SPA CREEK LANDING\n\n" +
        "Second cross street - 1000 PRESIDENT ST\n\n" +
        "Nature: 32B03-UNKNOWN MEDICAL EMERG\n\n" +
        "Call back: 410-263-4275\n\n" +
        "3RD PARTY (000582-39)\n" +
        "POSSIBLE LEG PAIN (000582-39)\n" +
        "72YO FEMALE (000582-39)\n" +
        "Community of ANNAPOLIS CITY (000582-39)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n\n" +
        "E361  PM36  ATRO  \n\n" +
        "HYDRANTS:  () &  ()\n" +
        "KNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n" +
        "17429\n" +
        "BY MAIN ENTRANCE AT THE TOP OF THE RAMP.\n\n" +
        "TIME 02:01:32          DATE 07/27/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/27/13   02:02:40\n\n" +
        "JOHN HOPKINS HO    YELLOW",

        "ID:201342168",
        "CALL:ONE EMT/P RESPONSE - UNKNOWN MEDICAL EMERG",
        "ADDR:1175 MADISON ST",
        "APT:B2",
        "CITY:ANNAPOLIS",
        "PLACE:HARBOUR HOUSE APTS",
        "MAP:20-J12-3602",
        "CH:B",
        "X:8 SPA CREEK LANDING & 1000 PRESIDENT ST",
        "CODE:32B03",
        "PHONE:410-263-4275",
        "INFO:3RD PARTY\nPOSSIBLE LEG PAIN\n72YO FEMALE\nKNOX BOX ON SIDE 1 OF ANNAPOLIS HOUSING AUTHORITY, 1217 MADISON STREET,\n17429\nBY MAIN ENTRANCE AT THE TOP OF THE RAMP.",
        "UNIT:E361  PM36  ATRO",
        "TIME:02:01:32",
        "DATE:07/27/13");

    doTest("T60",
        "(_subject_) INCIDENT 201342154\n\n" +
        "CODE LB     LOCAL BRUSH     ALARM 1\n\n" +
        "4 BENS DR          \n\n" +
        "Grid 25     Map K02     Area 3604     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21403\n\n" +
        "First cross street - 1 MARCS CT\n\n" +
        "Second cross street - 1 MARCS CT\n\n" +
        "Nature: F15-BRUSH/WOODS/TRASH (SPVR)\n\n" +
        "Call back: 410-991-9733\n\n" +
        "DUMPSTER AND BRUSH (000716-39)\n" +
        "Community of ANNAPOLIS CITY (000716-39)\n" +
        "TAC CHANNEL B ASSIGNED (000716-39)\n\n" +
        "E361  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "TIME 23:29:21          DATE 07/26/13",

        "ID:201342154",
        "CALL:LOCAL BRUSH - BRUSH/WOODS/TRASH (SPVR)",
        "ADDR:4 BENS DR",
        "CITY:ANNAPOLIS",
        "MAP:25-K02-3604",
        "CH:B",
        "X:1 MARCS CT & 1 MARCS CT",
        "CODE:F15",
        "PHONE:410-991-9733",
        "INFO:DUMPSTER AND BRUSH",
        "UNIT:E361",
        "TIME:23:29:21",
        "DATE:07/26/13");

    doTest("T61",
        "(_subject_) INCIDENT 201342148\n\n" +
        "CODE AF     BLS WITH FIRST RESPONDER     ALARM 1\n\n" +
        "2141 GENERALS HWY-AN          APPLEBEES REST\n\n" +
        "Grid 20     Map A08     Area 4024     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 1000 ANNAPOLIS MALL\n\n" +
        "Second cross street - 1000 BESTGATE RD\n\n" +
        "Nature: 04A01A-ASSAULT:NOT DANGEROUS\n\n" +
        "Call back: 410-573-0078\n\n" +
        "Community of ANNAPOLIS MALL (009611-43)\n" +
        "TAC CHANNEL B ASSIGNED (000579-)\n" +
        "Unit 'TW40' had changed quarters for unit 'TK40' (000579-)\n\n" +
        "TW40  PM39  \n\n" +
        "HYDRANTS: 2111 GENERALS HWY-AN (0) & 2115 GENERALS HWY-AN (3844)\n\n" +
        "TIME 23:01:10          DATE 07/26/13\n" +
        "\r\n" +
        "HOSPITAL STATUS   07/26/13   23:02:46\n\n" +
        "JOHN HOPKINS HO    YELLOW",

        "ID:201342148",
        "CALL:BLS WITH FIRST RESPONDER - ASSAULT:NOT DANGEROUS",
        "ADDR:2141 GENERALS HWY",
        "CITY:ANNAPOLIS",
        "PLACE:APPLEBEES REST",
        "MAP:20-A08-4024",
        "CH:B",
        "X:1000 ANNAPOLIS MALL & 1000 BESTGATE RD",
        "CODE:04A01A",
        "PHONE:410-573-0078",
        "INFO:HYDRANTS: 2111 GENERALS HWY-AN (0) & 2115 GENERALS HWY-AN (3844)",
        "UNIT:TW40  PM39",
        "TIME:23:01:10",
        "DATE:07/26/13");

    doTest("T62",
        "(_subject_) INCIDENT 201342144\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "143 COMPROMISE ST          ANNAPOLIS SUMMER GARDEN\n\n" +
        "Grid 21     Map A10     Area 3824     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2 MAIN ST-AN\n\n" +
        "Second cross street - 98 NEWMAN ST\n\n" +
        "Nature: F42-MISCELLANEOUS FIRE (SPVR)\n\n" +
        "Call back: 203-767-0388\n\n" +
        "Community of ANNAPOLIS CITY (009617-30)\n" +
        "TAC CHANNEL B ASSIGNED (000716-39)\n" +
        "UNIT E381 IS RESPONDING WITH OFFICER\n" +
        "From E381: PERSONS RESPONDING 3\n\n" +
        "E381  LAD39  \n\n" +
        "HYDRANTS:  () &  ()\n\n" +
        "AUTO SPRINKLER SYSTEM\n" +
        "DRY PIPE SPRINKLER SYSTEM.\n" +
        "19011\n" +
        "FDC LOCATED AT SIDE 1/2 CORNER.\n" +
        "AREA CAUTION NOTES FOR 3824\n" +
        "ADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\n" +
        "IN AFFECT UNTIL 08:00 OCT 18.\n\n" +
        "TIME 22:39:37          DATE 07/26/13",

        "ID:201342144",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MISCELLANEOUS FIRE (SPVR)",
        "ADDR:143 COMPROMISE ST",
        "CITY:ANNAPOLIS",
        "PLACE:ANNAPOLIS SUMMER GARDEN",
        "MAP:21-A10-3824",
        "CH:B",
        "X:2 MAIN ST & 98 NEWMAN ST",
        "CODE:F42",
        "PHONE:203-767-0388",
        "INFO:UNIT E381 IS RESPONDING WITH OFFICER\nFrom E381: PERSONS RESPONDING 3\nAUTO SPRINKLER SYSTEM\nDRY PIPE SPRINKLER SYSTEM.\n19011\nFDC LOCATED AT SIDE 1/2 CORNER.\nAREA CAUTION NOTES FOR 3824\nADD ENG FROM NAVAL ACADEMY IF A FIRE AT BOAT SHOW.\nIN AFFECT UNTIL 08:00 OCT 18.",
        "UNIT:E381  LAD39",
        "TIME:22:39:37",
        "DATE:07/26/13");

  }
  
  @Test
  public void testAnnapolisFire3() {

    doTest("T1",
        "(_subject_) INCIDENT 201343931\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "LUC HALL HOLLOWAY          \n\n" +
        "Grid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip \n\n" +
        "Nature: 00A6-MUTUAL AID MEDICAL\n\n" +
        "*MEDIC ONLY, 58 (009611-42)\n" +
        "58 YOM C/P (009611-42)\n" +
        "*MEDIC ONLY WITH QNT 46 (009611-42)\n" +
        "*Fire service incident 201343931 (009614-)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n" +
        "Units 'on air': PM39 (009611-42)\n\n" +
        "PM39  A469  PM39  \n\n" +
        "TIME 11:07:13          DATE 08/05/13\n\n",

        "ID:201343931",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MUTUAL AID MEDICAL",
        "ADDR:LUC HALL HOLLOWAY",
        "MAP:4601--4601",
        "CH:B",
        "CODE:00A6",
        "INFO:MEDIC ONLY, 58\n58 YOM C/P\nMEDIC ONLY WITH QNT 46",
        "UNIT:PM39  A469  PM39",
        "DATE:08/05/13",
        "TIME:11:07:13");

    doTest("T2",
        "(_subject_) INCIDENT 201343931\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "LUC HALL HOLLOWAY          \n\n" +
        "Grid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip \n\n" +
        "Nature: 00A6-MUTUAL AID MEDICAL\n\n" +
        "*MEDIC ONLY, 58 (009611-42)\n" +
        "58 YOM C/P (009611-42)\n" +
        "*MEDIC ONLY WITH QNT 46 (009611-42)\n" +
        "*Fire service incident 201343931 (009614-)\n" +
        "TAC CHANNEL B ASSIGNED (009614-)\n\n" +
        "PM39  \n\n" +
        "TIME 11:07:13          DATE 08/05/13\n\n",

        "ID:201343931",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MUTUAL AID MEDICAL",
        "ADDR:LUC HALL HOLLOWAY",
        "MAP:4601--4601",
        "CH:B",
        "CODE:00A6",
        "INFO:MEDIC ONLY, 58\n58 YOM C/P\nMEDIC ONLY WITH QNT 46",
        "UNIT:PM39",
        "DATE:08/05/13",
        "TIME:11:07:13");

    doTest("T2",
        "(_subject_) INCIDENT 201344368\n\n" +
        "CODE S     SPECIAL - UNIT REFERENCE CARD     ALARM 1\n\n" +
        "250 WOOD RD NAVAL MEDICAL CLINIC          \n\n" +
        "Grid 4601     Map      Area 4601     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip \n\n" +
        "Nature: 00A6-MUTUAL AID MEDICAL\n\n" +
        "*POSS PUNCTURED LUNG (001488-43)\n" +
        "*ALS (001488-43)\n" +
        "*Fire service incident 201344368 (009603-)\n" +
        "TAC CHANNEL B ASSIGNED (009603-)\n\n" +
        "PM39  \n\n" +
        "TIME 16:43:59          DATE 08/07/13",

        "ID:201344368",
        "CALL:SPECIAL - UNIT REFERENCE CARD - MUTUAL AID MEDICAL",
        "ADDR:250 WOOD RD NAVAL MEDICAL CLINIC",
        "MAP:4601--4601",
        "CH:B",
        "CODE:00A6",
        "INFO:POSS PUNCTURED LUNG\nALS",
        "UNIT:PM39",
        "DATE:08/07/13",
        "TIME:16:43:59");

    doTest("T3",
        "(_subject_) INCIDENT 201344256\n\n" +
        "CODE A     BLS CALL W/O A 1ST RESPONDER     ALARM 1\n\n" +
        "803 COXSWAIN WAY     104     BROAD CREEK CONDOS\n\n" +
        "Grid 19     Map G10     Area 4016     Preplan      Channel B    MOA 1\n\n" +
        "Census Tract      Zip 21401\n\n" +
        "First cross street - 2802 COXSWAIN CT\n\n" +
        "Nature: 26A01-SICK PERSON:NO PRIORITY COMPL\n\n" +
        "Call back: 410-266-5622\n\n" +
        "*LOC CN: DISPATCH AN ENGINE ON ALL MEDICAL CALLS TO THIS \n" +
        "*ADDRESS FOR KNOX BOX 511(12/27/95) \n" +
        "ANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL (009623-39)\n" +
        "Community of HERITAGE HARBOR (009623-39)\n" +
        "*NOT SURE WHAT IS WRONG WITH HIM (009623-39)\n" +
        "*HE WANTS AMBULANCE TO CHECK HIM OUT (009623-39)\n" +
        "DISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A (009623-39)\n" +
        "*Fire service incident 201344256 (009623-39)\n" +
        "Added unit 'E402' via 'X' at Tac  (009623-39)\n" +
        "TAC CHANNEL B ASSIGNED (009623-39)\n" +
        "UNIT E402 IS RESPONDING WITH OFFICER\n" +
        "From E402: PERSONS RESPONDING 3\n\n" +
        "PM35  E402  PM35  \n\n" +
        "HYDRANTS: 7335 FOREST AVE-HA (0) & 809 COXSWAIN WAY (1476)\n\n" +
        "CAUTION NOTES\n" +
        "DATE: 920619, BATTALION: 3, COMPANY: 40, BOX: 4016\n\n" +
        ".\n" +
        "KBOX BOX NOTES:\n" +
        "LOCATION OF BOX IS RIGHT SIDE OF FRONT DOORS\n" +
        "BOX CONTAINS:\n" +
        "1.KEYS TO STORE ROOMS AND EXITS.\n" +
        "AREA CAUTION NOTES FOR 4016\n" +
        "STAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\n" +
        "BOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\n" +
        "LZ:\n\n" +
        "TIME 05:49:42          DATE 08/07/13",

        "ID:201344256",
        "CALL:BLS CALL W/O A 1ST RESPONDER - SICK PERSON:NO PRIORITY COMPL",
        "ADDR:803 COXSWAIN WAY",
        "APT:104",
        "PLACE:BROAD CREEK CONDOS",
        "MAP:19-G10-4016",
        "CH:B",
        "X:2802 COXSWAIN CT",
        "CODE:26A01",
        "PHONE:410-266-5622",
        "INFO:LOC CN: DISPATCH AN ENGINE ON ALL MEDICAL CALLS TO THIS\nADDRESS FOR KNOX BOX 511(12/27/95)\nANNE ARUNDEL ANNE ARUNDEL ANNE ARUNDEL\nNOT SURE WHAT IS WRONG WITH HIM\nHE WANTS AMBULANCE TO CHECK HIM OUT\nDISPATCH CODE WAS A - CHANGED TO ALTERNATE CODE A\nUNIT E402 IS RESPONDING WITH OFFICER\nFrom E402: PERSONS RESPONDING 3\nHYDRANTS: 7335 FOREST AVE-HA (0) & 809 COXSWAIN WAY (1476)\nCAUTION NOTES\nDATE: 920619, BATTALION: 3, COMPANY: 40, BOX: 4016\n.\nKBOX BOX NOTES:\nLOCATION OF BOX IS RIGHT SIDE OF FRONT DOORS\nBOX CONTAINS:\n1.KEYS TO STORE ROOMS AND EXITS.\nAREA CAUTION NOTES FOR 4016\nSTAGING AREA FOR W/R: SHOPPING CENTER, COMPASSWAY & S.HAVEN RD\nBOAT RAMP:(BOX 0315, HARBOUR HILLS, END OF CONSTELLATION DRIVE)\nLZ:",
        "UNIT:PM35  E402  PM35",
        "DATE:08/07/13",
        "TIME:05:49:42");

  }
  
  public static void main(String[] args) {
    new MDAnneArundelCountyAnnapolisParserTest().generateTests("T1");
  }
}