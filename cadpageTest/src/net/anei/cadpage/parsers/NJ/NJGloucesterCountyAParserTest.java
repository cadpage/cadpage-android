package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NJ.NJGloucesterCountyAParser;

import org.junit.Test;

/*
Gloucester County, NJ (version A)

Contact: "rich2118@comcast.net" <rich2118@comcast.net>
Dispatch Contact: jjones@co.gloucester.nj.us
Sender: 777259763803
GC ALERT (#423679) FD 9-2: {12/26/2012 10:42:45}\nSEIZ     - Seizures{3}\n135 Voyager DR;B STOP
GC ALERT (#426211) FD 9-2: {01/03/2013 09:54:56}\nCVA      - Stroke{2}\n441 Trowbridge AVE;B STOP
GC ALERT (#425595) FD 9-2: {01/01/2013 10:48:28}\nRE       - Respiratory Emergency{2}\n796 Tacoma BLVD;B STOP
GC ALERT (#425415) FD 9-2: {12/31/2012 17:57:48}\nDWEL     - Dwelling Fire{2}\n749 Quail PL;B STOP
GC ALERT (#425315) FD 9-1: {12/31/2012 12:49:16}\nALRM     - Fire Alarm System{3}\nGloucester Manor;B STOP
GC ALERT (#425253) FD 9-2: {12/31/2012 09:45:49}\nALRM     - Fire Alarm System{3}\n820 Cooper ST;B STOP

Contact: John Godish <jg10306@gmail.com>
System: Pro Phoenix
Fwd: GC ALERT (#427167) FD 10-3: {01/06/2013 17:49:14} FUME     - Fumes{3} 5 Downing LN;R STOP
Fwd: GC ALERT (#426947) FD 10-3: {01/06/2013 02:55:46} DWEL     - Dwelling Fire{2} 28 Cranford RD;R STOP
Fwd: GC ALERT (#426447) FD 10-3: {01/04/2013 06:01:34} RUB      - Rubbish Fire{3} 24 Venus WAY;R STOP
Fwd: GC ALERT (#425961) FD 10-3: {01/02/2013 14:45:22} ALMC     - CO Alarm{3} 411 Timothy TER;R STOP
Fwd: GC ALERT (#424219) FD 10-3: {12/27/2012 17:42:05} ALRM     - Fire Alarm System{3} 16 Ferro DR;R STOP

Contact:  Jay Hauss <jhauss9010@gmail.com>
Sender: 1410000250
FRM:GC RSAN #426585\nMSG:FD 22-1: {01/04/2013 14:52:09}\nSERV     - Service assignment (Fire){3}\n389 Breakneck RD;J=

Contact: Richard Harris <rwh037@gmail.com>
Sender: 777282007204
GC ALERT (#427869) FD 6-3: {01/09/2013 08:12:58}\nALMC     - CO Alarm{3}\n11 Victorian Way;T STOP

Contact: Todd Birdsall <toddbirdsall88@gmail.com>
Sender: 777284581792
GC ALERT (#429277) FD 43-5: {01/13/2013 18:30:03}\nALRM     - Fire Alarm System{3}\n114 W Arctic AVE;04 STOP

Contact: JEFF PACE <pacejk305@gmail.com>
Sender: alert428469@private.gloucesteralert.com
FD 11-2: {01/11/2013 06:55:05}\nMVC      - Motor Vehicle Crash{2}\nS Harding HWY/Rt 54

Contact: Active911
Agency name: Whitman Square Fire Hall
Location: Sewell, NJ, United States
Sender: gccad@co.gloucester.nj.us

(Phoenix Notification) 2012040028 {10/22/2012 18:07:14}\r\nALRM     - Fire Alarm System{3}\r\nBirches Apts,1;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} SOUNDS LIKE WHOLE BUILDING SOUNDING 600 BUILDING \r\n
(Phoenix Notification) 2012040026 {10/21/2012 16:04:17}\r\nDWEL     - Dwelling Fire{2}\r\nNiagara TER/Johnson RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{101},{102},{103} Station Dispatched : {103} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ,,,E1093;\r\nDispatched: {102}, {101}, {103}, E1093 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0103 - 10-2 Whitman Square FD        \r\n0113 - 10-2 Whitman Square FD        \r\n0104 - 10-9 Washington Township EMS        \r\n Brown 2 story smoke coming from call is on grenville dr Update reviewed by dispatcher- Zelinsky, Nicholas J \r\n
(Phoenix Notification) 2012040023 {10/20/2012 18:44:08}\r\nVEH      - Vehicle fire{3}\r\nTunes Compact Discs,12;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{101},{102} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102}, {101} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n0123 - 10-1 Grenloch FD        \r\n MERRC VILLAGER FLAMES UNDERNEATH Update reviewed by dispatcher- Talarico, Kevin P \r\n
(Phoenix Notification) 2012040022 {10/20/2012 15:58:07}\r\nALRM     - Fire Alarm System{3}\r\nPelican Fish Company;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n Toner Alert Instantiated, Following tones sent to device - F1   \r\n0143 - 10-3 Hurffville FD        \r\n Toner Alert Instantiated \r\n{103} Station Dispatched : {103} Units Recommended: ;\r\nDispatched: {103} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0143 - 10-3 Hurffville FD        \r\n DINING ROOM - SMOKES ALARM CO  CORRECT PASSCODE   FALSE ALARM\r\nNo reason given Names Added : Security, Jcs; \r\n Update reviewed by dispatcher- Talarico, Kevin P \r\n
(Phoenix Notification) 2012040019 {10/20/2012 11:49:05}\r\nALRM     - Fire Alarm System{3}\r\nPremier OBGYN Of South Jersey;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n 8563026266    ZONE 12 1ST FLOOR SMOKE DET\r\n2420468 Update reviewed by dispatcher- Gismondi, Mark P \r\n
(Phoenix Notification) 2012040013 {10/18/2012 17:48:13}\r\nALRM     - Fire Alarm System{3}\r\n151 Fries Mill RD,102;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n PRIEMER OBGYN OF SOUTH JERSEY/SUITE 105\r\nZONE 12 FIRST FLOOR SMOKE DETECTOR\r\nPREM NUMBER 8563026266\r\nOPERATOR NUMBER KEO8 Update reviewed by dispatcher- Richards, Bryan D \r\n
(Phoenix Notification) 2012040012 {10/18/2012 16:10:38}\r\nMVC      - Motor Vehicle Crash{1}\r\n502 Egg Harbor RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} PATIENT WITH CHEST PAIN IN RESULT OF CRASH \r\n
(Phoenix Notification) 2012040010 {10/18/2012 08:38:08}\r\nVEH      - Vehicle fire{3}\r\nBlack Horse PIKE/Fries Mill RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0103 - 10-2 Whitman Square FD        \r\n \r\n
(Phoenix Notification) 2012040009 {10/17/2012 22:50:22}\r\nUNC      - Unconscious Person{1}\r\n4 Antares CT;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} 79/F FELL OUT OF BED. IN/OUT OF CONSCIOUSNESS \r\n
(Phoenix Notification) 2012040008 {10/17/2012 23:07:57}\r\nBLED     - Bleeding{3}\r\n814 Flint RD;R\r\nUnits:\r\n    10-2    \r\nComments:\r\n Toner Alert Instantiated \r\n{102}[10-2] Units Recommended: E1093;\r\nDispatched: E1093, 10-2 50F WITH NOSE BLEED FOR ABOUT 2 HRS \r\n
(Phoenix Notification) 2012040006 {10/17/2012 18:59:15}\r\nFUME     - Fumes{3}\r\n65 Berlin Crosskeys RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n Update reviewed by dispatcher- Epright, Lewis E \r\n
(Phoenix Notification) 2012040005 {10/17/2012 18:45:59}\r\nDWEL     - Dwelling Fire{2}\r\n214 Johnson RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{101},{102},{103} Station Dispatched : {103} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ,,,E1093;\r\nDispatched: {102}, {101}, {103}, E1093 \r\nCALLER ADVISING HOUSE ON FIRE  Toner Alert Instantiated, Following tones sent to device - F1   \r\n0103 - 10-2 Whitman Square FD        \r\n0113 - 10-2 Whitman Square FD        \r\n0104 - 10-9 Washington Township EMS        \r\n Update reviewed by dispatcher- Basile, Christopher F Update reviewed by dispatcher- Epright, Lewis E \r\n
(Phoenix Notification) 2012040004 {10/17/2012 16:12:05}\r\nALRM     - Fire Alarm System{3}\r\n372 Pitman Downer RD;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0133 - 10-2 Whitman Square FD        \r\n Toner Alert Instantiated, Following tones sent to device - F1   \r\n0103 - 10-2 Whitman Square FD        \r\n General fire Update reviewed by dispatcher- Gismondi, Ettore J \r\n
(Phoenix Notification) 2012040000 {10/15/2012 14:39:36}\r\nASPD     - Assist PD{3}\r\n2108 Tanglewood CT;R\r\nUnits:\r\n    \r\nComments:\r\n Toner Alert Instantiated \r\n{102} Station Dispatched : {102} Units Recommended: ;\r\nDispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n0103 - 10-2 Whitman Square FD        \r\n REQUEST LADDERTO REACH SECOND FLOOR WINDOW Update reviewed by dispatcher- Lansdowne, Kenneth R \r\n

Contact: Active911
Agency name: Buena EMS
Location: Minotola, NJ, United States
Sender: gccad@co.gloucester.nj.us

(Phoenix Notification) 2012040067 {11/12/2012 21:48:10}\r\nPSYC     - Psychological Emergency{3}\r\nBuena Vista Campground;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040066 {11/12/2012 15:28:41}\r\nMEDE     - Medical Emergency{3}\r\n116 Smith AVE;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040065 {11/12/2012 07:31:12}\r\nMEDE     - Medical Emergency{3}\r\nBattelinis Garage;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Main Office //  48M Severe Back Pain\r\nUnk Med Hx Update reviewed by dispatcher- Lansdowne, Kenneth R \r\n
(Phoenix Notification) 2012040063 {11/11/2012 14:20:49}\r\nBLED     - Bleeding{3}\r\n211 W Pacific AVE;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 50M BLEEDING FROM HEAD, Update reviewed by dispatcher- Landwher, Mark D \r\n
(Phoenix Notification) 2012040062 {11/10/2012 15:05:39}\r\nMVC      - Motor Vehicle Crash{2}\r\nMvp Sports Bar;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Mvc that tunred into an assault pd req a bls Update reviewed by dispatcher- Woodward, Walter B \r\n
(Phoenix Notification) 2012040061 {11/09/2012 07:43:19}\r\nUNC      - Unconscious Person{1}\r\nWawa;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n In the store 65f unc, is breathing Update reviewed by dispatcher- Barnett, William S Update reviewed by dispatcher- Gismondi, Ettore J Update reviewed by dispatcher- Gismondi, Ettore J \r\n
(Phoenix Notification) 2012040060 {11/08/2012 14:06:36}\r\nMEDE     - Medical Emergency{3}\r\n709 Jackson RD;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040059 {11/07/2012 19:45:23}\r\nPSYC     - Psychological Emergency{3}\r\n124 E Weymouth RD;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n PD ON  SCENE REQUEST FOR AN EVAL Update reviewed by dispatcher- Talarico, Kevin P \r\n
(Phoenix Notification) 2012040058 {11/07/2012 15:44:43}\r\nMEDE     - Medical Emergency{3}\r\nBuena Gardens Senior Housing;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n RM 312, 83 YOF, CMS FOR A COUPLE DAYS, DAUGHTER WANTS HER CHECKED OUT, REQUESTING BRIDGETON HOSPITAL Update reviewed by dispatcher- Weston, Karlee J \r\n
(Phoenix Notification) 2012040057 {11/07/2012 14:23:31}\r\nRE       - Respiratory Emergency{2}\r\nVineland City;CU\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: Dispatched: E1192 \r\n
(Phoenix Notification) 2012040056 {11/07/2012 14:22:09}\r\nCVA      - Stroke{2}\r\nVineland City;CU\r\nUnits:\r\n    E1191   \r\nComments:\r\n Units Recommended: Dispatched: E1191 \r\n
(Phoenix Notification) 2012040055 {11/06/2012 03:50:23}\r\nMEDE     - Medical Emergency{3}\r\n34 Southwest BLVD;M\r\nUnits:\r\n    E1191   \r\nComments:\r\n  \r\n
(Phoenix Notification) 2012040054 {11/06/2012 02:32:32}\r\nMEDE     - Medical Emergency{3}\r\n207 S Nixon ST;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 73M BACK PAIN ABDM PAIN Update reviewed by dispatcher- Breyer, Michael R \r\n
(Phoenix Notification) 2012040053 {11/05/2012 14:13:28}\r\nMEDA     - Medical Alarm{3}\r\nBuena Gardens Senior Housing;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Apt 312 - \r\n
(Phoenix Notification) 2012040052 {11/04/2012 18:47:53}\r\nSEIZ     - Seizures{3}\r\n869 Main AVE;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040051 {11/04/2012 17:27:35}\r\nSEIZ     - Seizures{3}\r\n107 W Pacific AVE;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 20/f - in an extended period of acrtive seizure - no hx that caller is aware of. Update reviewed by dispatcher- Zelinsky, Nicholas J \r\n
(Phoenix Notification) 2012040050 {11/04/2012 04:29:21}\r\nPUB      - Public Service Assignment{3}\r\nBuena Gardens Senior Housing;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Apt 207//93f lift assist Update reviewed by dispatcher- Vassaras, George \r\n
(Phoenix Notification) 2012040049 {11/03/2012 20:24:23}\r\nCE       - Cardiac Emergency{2}\r\nWawa;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Pd on car stop pt complaining of chest pain Update reviewed by dispatcher- Vassaras, George \r\n
(Phoenix Notification) 2012040048 {11/03/2012 10:08:39}\r\nFALL     - Fall Victim{3}\r\nParkview Gardens Senior Complex;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0155 - 11-9 Buena Boro EMS        \r\n APT E4   FEMALE FELL FROM STANDING  KNEE PAIN Update reviewed by dispatcher- Gismondi, Mark P \r\n
(Phoenix Notification) 2012040047 {11/03/2012 09:50:59}\r\nCVA      - Stroke{2}\r\n1255 Harding HWY;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040046 {11/03/2012 03:43:28}\r\nCE       - Cardiac Emergency{2}\r\n643 Main AVE;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040045 {11/02/2012 17:42:49}\r\nMEDE     - Medical Emergency{3}\r\n216 Jonas AVE;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 60M c/o Leg Pain \r\nExt Med Hx \r\n Lat/Long +39.516095 -74.952121 Update reviewed by dispatcher- Taylor, Kathy R \r\n
(Phoenix Notification) 2012040044 {11/01/2012 15:38:25}\r\nMEDE     - Medical Emergency{3}\r\n216 Jonas AVE;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0155 - 11-9 Buena Boro EMS        \r\n 60M KNEE PAIN Update reviewed by dispatcher- Woodward, Walter B \r\n
(Phoenix Notification) 2012040043 {11/01/2012 14:50:56}\r\nDIAB     - Diabetic Emergency{2}\r\n611 Cedar AVE;05\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1292,51MED;\r\nDispatched: E1292, E1192 \r\n
(Phoenix Notification) 2012040042 {11/01/2012 14:40:59}\r\nCE       - Cardiac Emergency{2}\r\nWeymouth RD/Rt 54;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040041 {10/31/2012 23:28:56}\r\nFALL     - Fall Victim{3}\r\n600 S Central AVE;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n APT B4/63YOF KNEE PAIN FROM FALL Update reviewed by dispatcher- Epright, Lewis E \r\n
(Phoenix Notification) 2012040040 {10/31/2012 14:42:22}\r\nCE       - Cardiac Emergency{2}\r\nSt Augustine Prep;05\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1291,51MED;\r\nDispatched: E1291, E1192 \r\n
(Phoenix Notification) 2012040039 {10/31/2012 14:28:44}\r\nMEDE     - Medical Emergency{3}\r\nSt Augustine Prep;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1291;\r\nDispatched: E1191 \r\n
(Phoenix Notification) 2012040038 {10/30/2012 21:40:39}\r\nBLED     - Bleeding{3}\r\nWheat Manor Apts,29;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0155 - 11-9 Buena Boro EMS        \r\n 13/M OPENING CAN OF CAT FOOD CUT FINGER Update reviewed by dispatcher- Ross, William L \r\n
(Phoenix Notification) 2012040037 {10/30/2012 20:44:56}\r\nABDM     - Abdominal Pain{3}\r\nBuena MS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040036 {10/29/2012 21:57:15}\r\nCE       - Cardiac Emergency{2}\r\n100 N Willow ST;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Apt A     62m Hx:Card   Sudden onset of CP Update reviewed by dispatcher- Vassaras, George \r\n
(Phoenix Notification) 2012040035 {10/29/2012 15:17:25}\r\nMEDE     - Medical Emergency{3}\r\n104 Park DR;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n Needs dispatch for a pregant women to go to regional Update reviewed by dispatcher- Taylor, Kathy R \r\n
(Phoenix Notification) 2012040034 {10/29/2012 14:12:46}\r\nMEDE     - Medical Emergency{3}\r\nBuena MS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 \r\n
(Phoenix Notification) 2012040033 {10/29/2012 13:16:28}\r\nUNC      - Unconscious Person{1}\r\nBuena MS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191 (PARTIAL) ;\r\nDispatched: E1191, MED4 \r\n
(Phoenix Notification) 2012040032 {10/28/2012 23:47:18}\r\nCA       - Cardiac Arrest{1}\r\n654 Sixth RD;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040031 {10/28/2012 00:32:22}\r\nCE       - Cardiac Emergency{2}\r\nVineland City;CU\r\nUnits:\r\n    E1191   \r\nComments:\r\n  \r\n
(Phoenix Notification) 2012040030 {10/27/2012 14:53:20}\r\nPSYC     - Psychological Emergency{3}\r\n4154 Post RD;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1291;\r\nDispatched: E1191 \r\n
(Phoenix Notification) 2012040029 {10/26/2012 21:29:21}\r\nFALL     - Fall Victim{3}\r\nBuena Regional HS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1291;\r\nDispatched: E1191 \r\n
(Phoenix Notification) 2012040028 {10/26/2012 19:47:15}\r\nMEDA     - Medical Alarm{3}\r\nBuena Gardens Senior Housing;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n RM 107\r\nMAGARITA PEREZ PREM # 8566973074 (DISCONNECTED) Update reviewed by dispatcher- Reagan, Stephen W \r\n
(Phoenix Notification) 2012040027 {10/26/2012 18:45:13}\r\nSTBY     - Standby{3}\r\nBuena Regional HS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040026 {10/26/2012 17:10:45}\r\nCHOK     - Choking{2}\r\n107 S Nixon ST;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 8mom ; choked on a Update reviewed by dispatcher- Richards, Bryan D \r\n
(Phoenix Notification) 2012040025 {10/26/2012 10:10:42}\r\nRE       - Respiratory Emergency{2}\r\n420 Captain Smith LN;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040024 {10/26/2012 09:22:13}\r\nFALL     - Fall Victim{3}\r\n5319 Old Landis Ave;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] \r\n
(Phoenix Notification) 2012040023 {10/26/2012 07:20:12}\r\nCE       - Cardiac Emergency{2}\r\n242 Wheat RD;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Units Recommended: E1191,51MED;\r\nDispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 94m ; cp rad into left arm / sob\r\nhx htn Update reviewed by dispatcher- Richards, Bryan D \r\n
(Phoenix Notification) 2012040022 {10/26/2012 00:33:56}\r\nABDM     - Abdominal Pain{3}\r\n105 N Auburn ST;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 30f/6 mon pregnant/pain in abdm/ Update reviewed by dispatcher- Lawrence, Joseph B \r\n
(Phoenix Notification) 2012040021 {10/25/2012 07:33:17}\r\nSEIZ     - Seizures{3}\r\nBuena Regional HS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended:  (PARTIAL) ;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 14f active Update reviewed by dispatcher- Krier, Michael A \r\n
(Phoenix Notification) 2012040020 {10/24/2012 20:39:03}\r\nOD       - Overdose{3}\r\n408 Wheat RD,2;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 38/m took to many pills per caller around the back,unk type pills Update reviewed by dispatcher- Talarico, Kevin P \r\n
(Phoenix Notification) 2012040019 {10/24/2012 13:34:41}\r\nFALL     - Fall Victim{3}\r\nBuena Terrace Apts;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191;\r\nDispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n APT 304 \r\n94/F - FELL - PAIN IN LOWER EXTREMINTY Update reviewed by dispatcher- Krier, Michael A \r\n
(Phoenix Notification) 2012040018 {10/24/2012 08:44:44}\r\nMEDE     - Medical Emergency{3}\r\n120 Country LN;05\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] 61f dizzy, weak \r\n
(Phoenix Notification) 2012040017 {10/21/2012 13:12:22}\r\nMVC      - Motor Vehicle Crash{2}\r\nSixth RD/Ninth ST\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] NJSP req driver checked out who is feeling "woozy" R 12300, 12300A, 12600a, 1238/4 \r\n
(Phoenix Notification) 2012040016 {10/21/2012 02:24:15}\r\nRE       - Respiratory Emergency{2}\r\n207 E Pacific AVE;04\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: E1191,51MED;\r\nDispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 38F RESP DISTRESS WHEEZING-- NEB TREATMENT\r\n Lat/Long +39.517629 -74.945641 Update reviewed by dispatcher- Vassaras, George \r\n
(Phoenix Notification) 2012040015 {10/20/2012 22:24:51}\r\nMVC      - Motor Vehicle Crash{2}\r\nWeymouth RD/Walnut LN;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] AIR BAGS DEPLOYED PER PD \r\n
(Phoenix Notification) 2012040014 {10/20/2012 20:36:39}\r\nRE       - Respiratory Emergency{2}\r\nVineland City;CU\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended: Dispatched: E1191 Vineland Devlopmental Cneter 1676 E landis Ave Wolverton Cottage \r\n
(Phoenix Notification) 2012040013 {10/20/2012 10:13:51}\r\nMEDE     - Medical Emergency{3}\r\n1060 Harding HWY;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] PER 1292  GO TO MUTUAL AID\r\n 58F GENERALIZED PAIN \r\n
(Phoenix Notification) 2012040012 {10/19/2012 19:07:25}\r\nSTBY     - Standby{3}\r\nBuena Regional HS;05\r\nUnits:\r\n    E1191   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1191] Units Recommended:  (PARTIAL) ;\r\nDispatched: E1191 Football Standby - available for priority calls in local Update reviewed by dispatcher- Priggemeier, Bryce A \r\n
(Phoenix Notification) 2012040008 {10/19/2012 18:00:59}\r\nFALL     - Fall Victim{3}\r\n301 E Summer RD;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n ADD ALS//7 YOM fell down 13 steps, c/o shoulder injury, contusion on his hip, coa Update reviewed by dispatcher- Gallo, Andrew M \r\n
(Phoenix Notification) 2012040007 {10/19/2012 14:00:54}\r\nBLED     - Bleeding{3}\r\n710 Summer AVE;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 30 YOM, drill into his wrist Update reviewed by dispatcher- Taylor, Kathy R \r\n
(Phoenix Notification) 2012040006 {10/19/2012 11:06:02}\r\nCVA      - Stroke{2}\r\n204 S Nixon ST;04\r\nUnits:\r\n    E1192   \r\nComments:\r\n Toner Alert Instantiated \r\n{119}[E1192] Units Recommended: E1192,51MED;\r\nDispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n0145 - 11-9 Buena Boro EMS        \r\n 53m, numbness to left face, arm Update reviewed by dispatcher- Gallo, Andrew M \r\n

Contact: Active911
Agency name: Woodbury Heights Fire Department
Location: Woodbury Heights, NJ, United States
Sender: gccad@co.gloucester.nj.us

(Phoenix Notification) 2013000105 {07/25/2013 15:23:52}\nALRM     - Fire Alarm System{3}\n300 Beech AVE;W\nUnits:\n    \nComments:\n Toner Alert Initiated \n{151} Station Dispatched : {151} Units Recommended: ,,;\nDispatched: {151}, {131}, {091} Toner Alert Initiated, Following tones sent to device - F1   \n0211 - 15-1 Woodbury Heights FD        \n0210 - 13-1 Wenonah FD        \n0100 - 9-1 Oak Valley FD        \n0130 - 9-1 Oak Valley FD        \n General fire alarm\nPrm: 856-845-9530\nOper: 4106\n Update reviewed by dispatcher- Gismondi, Ettore J 
(Phoenix Notification) 2013000104 {07/25/2013 05:47:58}\nALRM     - Fire Alarm System{3}\n775 Tanyard RD;W\nUnits:\n    \nComments:\n Toner Alert Initiated \n{151} Station Dispatched : {151} Units Recommended: ,,,,E1519;\nDispatched: {151}, {131}, {091}, {094}, E1519 Toner Alert Initiated, Following tones sent to device - F1   \n0211 - 15-1 Woodbury Heights FD        \n0210 - 13-1 Wenonah FD        \n0100 - 9-1 Oak Valley FD        \n0130 - 9-1 Oak Valley FD        \n0151 - 9-4 Lake Tract FD        \n0221 - 15-9 Woobbury Heights EMS        \n 
(Phoenix Notification) 2013000246 {07/24/2013 21:54:31}\nSEIZ     - Seizures{3}\n779 Candidus AVE;W\nUnits:\n    E1519   \nComments:\n Toner Alert Initiated \n{159}[E1519] Units Recommended: E1519,LS-1;\nDispatched: E1519, LS-1 Toner Alert Initiated, Following tones sent to device - F1   \n0221 - 15-9 Woobbury Heights EMS        \n0258 - LS-1    \n 29 YOF / ACTIVE SEIZURE / 1 MIN\nHX: SEIZURES Names Updated : Name changed from Aegemian Pete to Aegemian, Pete; \n Update reviewed by dispatcher- Epright, Lewis E 
(Phoenix Notification) 2013000103 {07/24/2013 10:49:18}\nCE       - Cardiac Emergency{2}\n848 Lake AVE;W\nUnits:\n    F1518   \nComments:\n Toner Alert Initiated \n{151}[F1518] 57yom/hx card/ sweating vommiting weak pulse/ lathergic  
(Phoenix Notification) 2013000243 {07/24/2013 01:59:29}\nPUB      - Public Service Assignment{3}\n1051 Walnut AVE;W\nUnits:\n    E1519   \nComments:\n Toner Alert Instantiated \n{159}[E1519] Units Recommended: E1519;\nDispatched: E1519 Toner Alert Instantiated, Following tones sent to device - F1   \n0221 - 15-9 Woobbury Heights EMS        \n Lift assist Update reviewed by dispatcher- Mcgarvey, Raymond E 
(Phoenix Notification) 2013000102 {07/23/2013 07:50:46}\nALRM     - Fire Alarm System{3}\n775 Tanyard RD;W\nUnits:\n    \nComments:\n Toner Alert Instantiated \n{151} Station Dispatched : {151} Units Recommended: ,,,,E1519;\nDispatched: {151}, {131}, {091}, {094}, E1519 Toner Alert Instantiated, Following tones sent to device - F1   \n0211 - 15-1 Woodbury Heights FD        \n0210 - 13-1 Wenonah FD        \n0100 - 9-1 Oak Valley FD        \n0130 - 9-1 Oak Valley FD        \n0151 - 9-4 Lake Tract FD        \n Zone 001, called in by oper 3991 Update reviewed by dispatcher- Weston, Karlee J 
(Phoenix Notification) 2013000241 {07/22/2013 20:56:29}\nMEDE     - Medical Emergency{3}\n820 Cooper ST;B\nUnits:\n    E1519   \nComments:\n Toner Alert Instantiated \n{159}[E1519] Bls requested for PT in pain 
(Phoenix Notification) 2013000240 {07/21/2013 14:51:41}\nCE       - Cardiac Emergency{2}\n153 Vanderbilt AVE;W\nUnits:\n    E1519   \nComments:\n Units Recommended: E1519,LS-1;\nDispatched: E1519, LS-1 Toner Alert Instantiated, Following tones sent to device - F1   \n0221 - 15-9 Woobbury Heights EMS        \n0258 - LS-1    \n 56F, is feeling shakey and heart palps. N/V No CP, however is mildly SOB. Hx:anxiety attack. Update reviewed by dispatcher- Talarico, Kevin P 
(Phoenix Notification) 2013000101 {07/20/2013 21:18:44}\nWIRE     - Wires down or Arcing{3}\n748 Second ST;W\nUnits:\n    \nComments:\n Toner Alert Instantiated \n{151} Station Dispatched : {151} Units Recommended: ;\nDispatched: {151} Toner Alert Instantiated, Following tones sent to device - F1   \n0211 - 15-1 Woodbury Heights FD        \n 
(Phoenix Notification) 2013000239 {07/20/2013 13:53:49}\nCE       - Cardiac Emergency{2}\n106 Andaloro WAY;B\nUnits:\n    E1519   \nComments:\n Toner Alert Instantiated \n{159}[E1519] Units Recommended: E992,MEDIC;\nDispatched: E992, E1519 90F CP SOB PAIN IN R ARM CARD HX 

Contact: Rick <rwh037@verizon.net>
Sender: 7774
GC ALERT (#B0WT) FD 6-3: {08/18/2013 02:19:18}\nRUB      - Rubbish Fire{3}\n701 Red Bank AVE,COMPLEX;T STOP

*/


public class NJGloucesterCountyAParserTest extends BaseParserTest {
  
  public NJGloucesterCountyAParserTest() {
    setParser(new NJGloucesterCountyAParser(), "GLOUCESTER COUNTY", "NJ");
  }
  
  @Test
  public void testRich2118() {

    doTest("T1",
        "GC ALERT (#423679) FD 9-2: {12/26/2012 10:42:45}\nSEIZ     - Seizures{3}\n135 Voyager DR;B STOP",
        "ID:423679",
        "SRC:FD 9-2",
        "DATE:12/26/2012",
        "TIME:10:42:45",
        "CODE:SEIZ",
        "CALL:Seizures",
        "PRI:3",
        "ADDR:135 Voyager DR");

    doTest("T2",
        "GC ALERT (#426211) FD 9-2: {01/03/2013 09:54:56}\nCVA      - Stroke{2}\n441 Trowbridge AVE;B STOP",
        "ID:426211",
        "SRC:FD 9-2",
        "DATE:01/03/2013",
        "TIME:09:54:56",
        "CODE:CVA",
        "CALL:Stroke",
        "PRI:2",
        "ADDR:441 Trowbridge AVE");

    doTest("T3",
        "GC ALERT (#425595) FD 9-2: {01/01/2013 10:48:28}\nRE       - Respiratory Emergency{2}\n796 Tacoma BLVD;B STOP",
        "ID:425595",
        "SRC:FD 9-2",
        "DATE:01/01/2013",
        "TIME:10:48:28",
        "CODE:RE",
        "CALL:Respiratory Emergency",
        "PRI:2",
        "ADDR:796 Tacoma BLVD");

    doTest("T4",
        "GC ALERT (#425415) FD 9-2: {12/31/2012 17:57:48}\nDWEL     - Dwelling Fire{2}\n749 Quail PL;B STOP",
        "ID:425415",
        "SRC:FD 9-2",
        "DATE:12/31/2012",
        "TIME:17:57:48",
        "CODE:DWEL",
        "CALL:Dwelling Fire",
        "PRI:2",
        "ADDR:749 Quail PL");

    doTest("T5",
        "GC ALERT (#425315) FD 9-1: {12/31/2012 12:49:16}\nALRM     - Fire Alarm System{3}\nGloucester Manor;B STOP",
        "ID:425315",
        "SRC:FD 9-1",
        "DATE:12/31/2012",
        "TIME:12:49:16",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:Gloucester Manor");

    doTest("T6",
        "GC ALERT (#425253) FD 9-2: {12/31/2012 09:45:49}\nALRM     - Fire Alarm System{3}\n820 Cooper ST;B STOP",
        "ID:425253",
        "SRC:FD 9-2",
        "DATE:12/31/2012",
        "TIME:09:45:49",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:820 Cooper ST");

  }
  
  @Test
  public void testJohnGodish() {

    doTest("T1",
        "Fwd: GC ALERT (#427167) FD 10-3: {01/06/2013 17:49:14} FUME     - Fumes{3} 5 Downing LN;R STOP",
        "ID:427167",
        "SRC:FD 10-3",
        "DATE:01/06/2013",
        "TIME:17:49:14",
        "CODE:FUME",
        "CALL:Fumes",
        "PRI:3",
        "ADDR:5 Downing LN");

    doTest("T2",
        "Fwd: GC ALERT (#426947) FD 10-3: {01/06/2013 02:55:46} DWEL     - Dwelling Fire{2} 28 Cranford RD;R STOP",
        "ID:426947",
        "SRC:FD 10-3",
        "DATE:01/06/2013",
        "TIME:02:55:46",
        "CODE:DWEL",
        "CALL:Dwelling Fire",
        "PRI:2",
        "ADDR:28 Cranford RD");

    doTest("T3",
        "Fwd: GC ALERT (#426447) FD 10-3: {01/04/2013 06:01:34} RUB      - Rubbish Fire{3} 24 Venus WAY;R STOP",
        "ID:426447",
        "SRC:FD 10-3",
        "DATE:01/04/2013",
        "TIME:06:01:34",
        "CODE:RUB",
        "CALL:Rubbish Fire",
        "PRI:3",
        "ADDR:24 Venus WAY");

    doTest("T4",
        "Fwd: GC ALERT (#425961) FD 10-3: {01/02/2013 14:45:22} ALMC     - CO Alarm{3} 411 Timothy TER;R STOP",
        "ID:425961",
        "SRC:FD 10-3",
        "DATE:01/02/2013",
        "TIME:14:45:22",
        "CODE:ALMC",
        "CALL:CO Alarm",
        "PRI:3",
        "ADDR:411 Timothy TER");

    doTest("T5",
        "Fwd: GC ALERT (#424219) FD 10-3: {12/27/2012 17:42:05} ALRM     - Fire Alarm System{3} 16 Ferro DR;R STOP",
        "ID:424219",
        "SRC:FD 10-3",
        "DATE:12/27/2012",
        "TIME:17:42:05",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:16 Ferro DR");

  }
  
  @Test
  public void testJayHauss() {

    doTest("T1",
        "FRM:GC RSAN #426585\nMSG:FD 22-1: {01/04/2013 14:52:09}\nSERV     - Service assignment (Fire){3}\n389 Breakneck RD;J=",
        "ID:426585",
        "SRC:FD 22-1",
        "DATE:01/04/2013",
        "TIME:14:52:09",
        "CODE:SERV",
        "CALL:Service assignment (Fire)",
        "PRI:3",
        "ADDR:389 Breakneck RD");
    
  }
  
  @Test
  public void testRichardHarris() {

    doTest("T1",
        "GC ALERT (#427869) FD 6-3: {01/09/2013 08:12:58}\nALMC     - CO Alarm{3}\n11 Victorian Way;T STOP",
        "ID:427869",
        "SRC:FD 6-3",
        "DATE:01/09/2013",
        "TIME:08:12:58",
        "CODE:ALMC",
        "CALL:CO Alarm",
        "PRI:3",
        "ADDR:11 Victorian Way");

  }
  
  @Test
  public void testTomBirdsall() {

    doTest("T1",
        "GC ALERT (#429277) FD 43-5: {01/13/2013 18:30:03}\nALRM     - Fire Alarm System{3}\n114 W Arctic AVE;04 STOP",
        "ID:429277",
        "SRC:FD 43-5",
        "DATE:01/13/2013",
        "TIME:18:30:03",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:114 W Arctic AVE");

  }
  
  @Test
  public void testJeffPace() {

    doTest("T1",
        "FD 11-2: {01/11/2013 06:55:05}\nMVC      - Motor Vehicle Crash{2}\nS Harding HWY/Rt 54",
        "SRC:FD 11-2",
        "DATE:01/11/2013",
        "TIME:06:55:05",
        "CODE:MVC",
        "CALL:Motor Vehicle Crash",
        "PRI:2",
        "ADDR:S Harding HWY & Rt 54");

  }
  
  @Test
  public void testWhitmanSquareFire() {

    doTest("T1",
        "(Phoenix Notification) 2012040028 {10/22/2012 18:07:14}\r\n" +
        "ALRM     - Fire Alarm System{3}\r\n" +
        "Birches Apts,1;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} SOUNDS LIKE WHOLE BUILDING SOUNDING 600 BUILDING \r\n",

        "ID:2012040028",
        "DATE:10/22/2012",
        "TIME:18:07:14",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:Birches Apts",
        "APT:1",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:SOUNDS LIKE WHOLE BUILDING SOUNDING 600 BUILDING");

    doTest("T2",
        "(Phoenix Notification) 2012040026 {10/21/2012 16:04:17}\r\n" +
        "DWEL     - Dwelling Fire{2}\r\n" +
        "Niagara TER/Johnson RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{101},{102},{103} Station Dispatched : {103} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ,,,E1093;\r\n" +
        "Dispatched: {102}, {101}, {103}, E1093 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0103 - 10-2 Whitman Square FD        \r\n" +
        "0113 - 10-2 Whitman Square FD        \r\n" +
        "0104 - 10-9 Washington Township EMS        \r\n" +
        " Brown 2 story smoke coming from call is on grenville dr Update reviewed by dispatcher- Zelinsky, Nicholas J \r\n",

        "ID:2012040026",
        "DATE:10/21/2012",
        "TIME:16:04:17",
        "CODE:DWEL",
        "CALL:Dwelling Fire",
        "PRI:2",
        "ADDR:Niagara TER & Johnson RD",
        "CITY:WASHINGTON TWP",
        "UNIT:101 102 103",
        "INFO:0103 - 10-2 Whitman Square FD\n0113 - 10-2 Whitman Square FD\n0104 - 10-9 Washington Township EMS\nBrown 2 story smoke coming from call is on grenville dr");

    doTest("T3",
        "(Phoenix Notification) 2012040023 {10/20/2012 18:44:08}\r\n" +
        "VEH      - Vehicle fire{3}\r\n" +
        "Tunes Compact Discs,12;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{101},{102} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102}, {101} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        "0123 - 10-1 Grenloch FD        \r\n" +
        " MERRC VILLAGER FLAMES UNDERNEATH Update reviewed by dispatcher- Talarico, Kevin P \r\n",

        "ID:2012040023",
        "DATE:10/20/2012",
        "TIME:18:44:08",
        "CODE:VEH",
        "CALL:Vehicle fire",
        "PRI:3",
        "ADDR:Tunes Compact Discs",
        "APT:12",
        "CITY:WASHINGTON TWP",
        "UNIT:101 102",
        "INFO:0133 - 10-2 Whitman Square FD\n0123 - 10-1 Grenloch FD\nMERRC VILLAGER FLAMES UNDERNEATH");

    doTest("T4",
        "(Phoenix Notification) 2012040022 {10/20/2012 15:58:07}\r\n" +
        "ALRM     - Fire Alarm System{3}\r\n" +
        "Pelican Fish Company;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        " Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0143 - 10-3 Hurffville FD        \r\n" +
        " Toner Alert Instantiated \r\n" +
        "{103} Station Dispatched : {103} Units Recommended: ;\r\n" +
        "Dispatched: {103} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0143 - 10-3 Hurffville FD        \r\n" +
        " DINING ROOM - SMOKES ALARM CO  CORRECT PASSCODE   FALSE ALARM\r\n" +
        "No reason given Names Added : Security, Jcs; \r\n" +
        " Update reviewed by dispatcher- Talarico, Kevin P \r\n",

        "ID:2012040022",
        "DATE:10/20/2012",
        "TIME:15:58:07",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:Pelican Fish Company",
        "CITY:WASHINGTON TWP",
        "UNIT:102 103",
        "INFO:0133 - 10-2 Whitman Square FD\n0143 - 10-3 Hurffville FD\n0143 - 10-3 Hurffville FD\nDINING ROOM - SMOKES ALARM CO  CORRECT PASSCODE   FALSE ALARM\nNo reason given Names Added : Security, Jcs;");

    doTest("T5",
        "(Phoenix Notification) 2012040019 {10/20/2012 11:49:05}\r\n" +
        "ALRM     - Fire Alarm System{3}\r\n" +
        "Premier OBGYN Of South Jersey;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        " 8563026266    ZONE 12 1ST FLOOR SMOKE DET\r\n" +
        "2420468 Update reviewed by dispatcher- Gismondi, Mark P \r\n",

        "ID:2012040019",
        "DATE:10/20/2012",
        "TIME:11:49:05",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:Premier OBGYN Of South Jersey",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0133 - 10-2 Whitman Square FD\n8563026266    ZONE 12 1ST FLOOR SMOKE DET\n2420468");

    doTest("T6",
        "(Phoenix Notification) 2012040013 {10/18/2012 17:48:13}\r\n" +
        "ALRM     - Fire Alarm System{3}\r\n" +
        "151 Fries Mill RD,102;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        " PRIEMER OBGYN OF SOUTH JERSEY/SUITE 105\r\n" +
        "ZONE 12 FIRST FLOOR SMOKE DETECTOR\r\n" +
        "PREM NUMBER 8563026266\r\n" +
        "OPERATOR NUMBER KEO8 Update reviewed by dispatcher- Richards, Bryan D \r\n",

        "ID:2012040013",
        "DATE:10/18/2012",
        "TIME:17:48:13",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:151 Fries Mill RD",
        "APT:102",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0133 - 10-2 Whitman Square FD\nPRIEMER OBGYN OF SOUTH JERSEY/SUITE 105\nZONE 12 FIRST FLOOR SMOKE DETECTOR\nPREM NUMBER 8563026266\nOPERATOR NUMBER KEO8");

    doTest("T7",
        "(Phoenix Notification) 2012040012 {10/18/2012 16:10:38}\r\n" +
        "MVC      - Motor Vehicle Crash{1}\r\n" +
        "502 Egg Harbor RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} PATIENT WITH CHEST PAIN IN RESULT OF CRASH \r\n",

        "ID:2012040012",
        "DATE:10/18/2012",
        "TIME:16:10:38",
        "CODE:MVC",
        "CALL:Motor Vehicle Crash",
        "PRI:1",
        "ADDR:502 Egg Harbor RD",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:PATIENT WITH CHEST PAIN IN RESULT OF CRASH");

    doTest("T8",
        "(Phoenix Notification) 2012040010 {10/18/2012 08:38:08}\r\n" +
        "VEH      - Vehicle fire{3}\r\n" +
        "Black Horse PIKE/Fries Mill RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0103 - 10-2 Whitman Square FD        \r\n" +
        " \r\n",

        "ID:2012040010",
        "DATE:10/18/2012",
        "TIME:08:38:08",
        "CODE:VEH",
        "CALL:Vehicle fire",
        "PRI:3",
        "ADDR:Black Horse PIKE & Fries Mill RD",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0103 - 10-2 Whitman Square FD");

    doTest("T9",
        "(Phoenix Notification) 2012040009 {10/17/2012 22:50:22}\r\n" +
        "UNC      - Unconscious Person{1}\r\n" +
        "4 Antares CT;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} 79/F FELL OUT OF BED. IN/OUT OF CONSCIOUSNESS \r\n",

        "ID:2012040009",
        "DATE:10/17/2012",
        "TIME:22:50:22",
        "CODE:UNC",
        "CALL:Unconscious Person",
        "PRI:1",
        "ADDR:4 Antares CT",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:79/F FELL OUT OF BED. IN/OUT OF CONSCIOUSNESS");

    doTest("T10",
        "(Phoenix Notification) 2012040008 {10/17/2012 23:07:57}\r\n" +
        "BLED     - Bleeding{3}\r\n" +
        "814 Flint RD;R\r\n" +
        "Units:\r\n" +
        "    10-2    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102}[10-2] Units Recommended: E1093;\r\n" +
        "Dispatched: E1093, 10-2 50F WITH NOSE BLEED FOR ABOUT 2 HRS \r\n",

        "ID:2012040008",
        "DATE:10/17/2012",
        "TIME:23:07:57",
        "CODE:BLED",
        "CALL:Bleeding",
        "PRI:3",
        "ADDR:814 Flint RD",
        "CITY:WASHINGTON TWP",
        "UNIT:10-2 102",
        "INFO:Dispatched: E1093, 10-2 50F WITH NOSE BLEED FOR ABOUT 2 HRS");

    doTest("T11",
        "(Phoenix Notification) 2012040006 {10/17/2012 18:59:15}\r\n" +
        "FUME     - Fumes{3}\r\n" +
        "65 Berlin Crosskeys RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        " Update reviewed by dispatcher- Epright, Lewis E \r\n",

        "ID:2012040006",
        "DATE:10/17/2012",
        "TIME:18:59:15",
        "CODE:FUME",
        "CALL:Fumes",
        "PRI:3",
        "ADDR:65 Berlin Crosskeys RD",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0133 - 10-2 Whitman Square FD");

    doTest("T12",
        "(Phoenix Notification) 2012040005 {10/17/2012 18:45:59}\r\n" +
        "DWEL     - Dwelling Fire{2}\r\n" +
        "214 Johnson RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{101},{102},{103} Station Dispatched : {103} Station Dispatched : {101} Station Dispatched : {102} Units Recommended: ,,,E1093;\r\n" +
        "Dispatched: {102}, {101}, {103}, E1093 \r\n" +
        "CALLER ADVISING HOUSE ON FIRE  Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0103 - 10-2 Whitman Square FD        \r\n" +
        "0113 - 10-2 Whitman Square FD        \r\n" +
        "0104 - 10-9 Washington Township EMS        \r\n" +
        " Update reviewed by dispatcher- Basile, Christopher F Update reviewed by dispatcher- Epright, Lewis E \r\n",

        "ID:2012040005",
        "DATE:10/17/2012",
        "TIME:18:45:59",
        "CODE:DWEL",
        "CALL:Dwelling Fire",
        "PRI:2",
        "ADDR:214 Johnson RD",
        "CITY:WASHINGTON TWP",
        "UNIT:101 102 103",
        "INFO:E1093\n0103 - 10-2 Whitman Square FD\n0113 - 10-2 Whitman Square FD\n0104 - 10-9 Washington Township EMS");

    doTest("T13",
        "(Phoenix Notification) 2012040004 {10/17/2012 16:12:05}\r\n" +
        "ALRM     - Fire Alarm System{3}\r\n" +
        "372 Pitman Downer RD;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0133 - 10-2 Whitman Square FD        \r\n" +
        " Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0103 - 10-2 Whitman Square FD        \r\n" +
        " General fire Update reviewed by dispatcher- Gismondi, Ettore J \r\n",

        "ID:2012040004",
        "DATE:10/17/2012",
        "TIME:16:12:05",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:372 Pitman Downer RD",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0133 - 10-2 Whitman Square FD\n0103 - 10-2 Whitman Square FD\nGeneral fire");

    doTest("T14",
        "(Phoenix Notification) 2012040000 {10/15/2012 14:39:36}\r\n" +
        "ASPD     - Assist PD{3}\r\n" +
        "2108 Tanglewood CT;R\r\n" +
        "Units:\r\n" +
        "    \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{102} Station Dispatched : {102} Units Recommended: ;\r\n" +
        "Dispatched: {102} Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0103 - 10-2 Whitman Square FD        \r\n" +
        " REQUEST LADDERTO REACH SECOND FLOOR WINDOW Update reviewed by dispatcher- Lansdowne, Kenneth R \r\n",

        "ID:2012040000",
        "DATE:10/15/2012",
        "TIME:14:39:36",
        "CODE:ASPD",
        "CALL:Assist PD",
        "PRI:3",
        "ADDR:2108 Tanglewood CT",
        "CITY:WASHINGTON TWP",
        "UNIT:102",
        "INFO:0103 - 10-2 Whitman Square FD\nREQUEST LADDERTO REACH SECOND FLOOR WINDOW");

  }
  
  @Test
  public void testBuenaEMS() {

    doTest("T1",
        "(Phoenix Notification) 2012040067 {11/12/2012 21:48:10}\r\n" +
        "PSYC     - Psychological Emergency{3}\r\n" +
        "Buena Vista Campground;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040067",
        "DATE:11/12/2012",
        "TIME:21:48:10",
        "CODE:PSYC",
        "CALL:Psychological Emergency",
        "PRI:3",
        "ADDR:Buena Vista Campground",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T2",
        "(Phoenix Notification) 2012040066 {11/12/2012 15:28:41}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "116 Smith AVE;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040066",
        "DATE:11/12/2012",
        "TIME:15:28:41",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:116 Smith AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T3",
        "(Phoenix Notification) 2012040065 {11/12/2012 07:31:12}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "Battelinis Garage;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Main Office //  48M Severe Back Pain\r\n" +
        "Unk Med Hx Update reviewed by dispatcher- Lansdowne, Kenneth R \r\n",

        "ID:2012040065",
        "DATE:11/12/2012",
        "TIME:07:31:12",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:Battelinis Garage",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nMain Office //  48M Severe Back Pain\nUnk Med Hx");

    doTest("T4",
        "(Phoenix Notification) 2012040063 {11/11/2012 14:20:49}\r\n" +
        "BLED     - Bleeding{3}\r\n" +
        "211 W Pacific AVE;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 50M BLEEDING FROM HEAD, Update reviewed by dispatcher- Landwher, Mark D \r\n",

        "ID:2012040063",
        "DATE:11/11/2012",
        "TIME:14:20:49",
        "CODE:BLED",
        "CALL:Bleeding",
        "PRI:3",
        "ADDR:211 W Pacific AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n50M BLEEDING FROM HEAD,");

    doTest("T5",
        "(Phoenix Notification) 2012040062 {11/10/2012 15:05:39}\r\n" +
        "MVC      - Motor Vehicle Crash{2}\r\n" +
        "Mvp Sports Bar;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Mvc that tunred into an assault pd req a bls Update reviewed by dispatcher- Woodward, Walter B \r\n",

        "ID:2012040062",
        "DATE:11/10/2012",
        "TIME:15:05:39",
        "CODE:MVC",
        "CALL:Motor Vehicle Crash",
        "PRI:2",
        "ADDR:Mvp Sports Bar",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nMvc that tunred into an assault pd req a bls");

    doTest("T6",
        "(Phoenix Notification) 2012040061 {11/09/2012 07:43:19}\r\n" +
        "UNC      - Unconscious Person{1}\r\n" +
        "Wawa;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " In the store 65f unc, is breathing Update reviewed by dispatcher- Barnett, William S Update reviewed by dispatcher- Gismondi, Ettore J Update reviewed by dispatcher- Gismondi, Ettore J \r\n",

        "ID:2012040061",
        "DATE:11/09/2012",
        "TIME:07:43:19",
        "CODE:UNC",
        "CALL:Unconscious Person",
        "PRI:1",
        "ADDR:Wawa",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nIn the store 65f unc, is breathing");

    doTest("T7",
        "(Phoenix Notification) 2012040060 {11/08/2012 14:06:36}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "709 Jackson RD;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040060",
        "DATE:11/08/2012",
        "TIME:14:06:36",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:709 Jackson RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T8",
        "(Phoenix Notification) 2012040059 {11/07/2012 19:45:23}\r\n" +
        "PSYC     - Psychological Emergency{3}\r\n" +
        "124 E Weymouth RD;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " PD ON  SCENE REQUEST FOR AN EVAL Update reviewed by dispatcher- Talarico, Kevin P \r\n",

        "ID:2012040059",
        "DATE:11/07/2012",
        "TIME:19:45:23",
        "CODE:PSYC",
        "CALL:Psychological Emergency",
        "PRI:3",
        "ADDR:124 E Weymouth RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nPD ON  SCENE REQUEST FOR AN EVAL");

    doTest("T9",
        "(Phoenix Notification) 2012040058 {11/07/2012 15:44:43}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "Buena Gardens Senior Housing;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " RM 312, 83 YOF, CMS FOR A COUPLE DAYS, DAUGHTER WANTS HER CHECKED OUT, REQUESTING BRIDGETON HOSPITAL Update reviewed by dispatcher- Weston, Karlee J \r\n",

        "ID:2012040058",
        "DATE:11/07/2012",
        "TIME:15:44:43",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:Buena Gardens Senior Housing",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nRM 312, 83 YOF, CMS FOR A COUPLE DAYS, DAUGHTER WANTS HER CHECKED OUT, REQUESTING BRIDGETON HOSPITAL");

    doTest("T10",
        "(Phoenix Notification) 2012040057 {11/07/2012 14:23:31}\r\n" +
        "RE       - Respiratory Emergency{2}\r\n" +
        "Vineland City;CU\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: Dispatched: E1192 \r\n",

        "ID:2012040057",
        "DATE:11/07/2012",
        "TIME:14:23:31",
        "CODE:RE",
        "CALL:Respiratory Emergency",
        "PRI:2",
        "ADDR:Vineland City",
        "CITY:CUMBERLAND COUNTY",
        "UNIT:E1192 119");

    doTest("T11",
        "(Phoenix Notification) 2012040056 {11/07/2012 14:22:09}\r\n" +
        "CVA      - Stroke{2}\r\n" +
        "Vineland City;CU\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Units Recommended: Dispatched: E1191 \r\n",

        "ID:2012040056",
        "DATE:11/07/2012",
        "TIME:14:22:09",
        "CODE:CVA",
        "CALL:Stroke",
        "PRI:2",
        "ADDR:Vineland City",
        "CITY:CUMBERLAND COUNTY",
        "UNIT:E1191");

    doTest("T12",
        "(Phoenix Notification) 2012040055 {11/06/2012 03:50:23}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "34 Southwest BLVD;M\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        "  \r\n",

        "ID:2012040055",
        "DATE:11/06/2012",
        "TIME:03:50:23",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:34 Southwest BLVD",
        "CITY:NEWFIELD",
        "UNIT:E1191");

    doTest("T13",
        "(Phoenix Notification) 2012040054 {11/06/2012 02:32:32}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "207 S Nixon ST;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 73M BACK PAIN ABDM PAIN Update reviewed by dispatcher- Breyer, Michael R \r\n",

        "ID:2012040054",
        "DATE:11/06/2012",
        "TIME:02:32:32",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:207 S Nixon ST",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n73M BACK PAIN ABDM PAIN");

    doTest("T14",
        "(Phoenix Notification) 2012040053 {11/05/2012 14:13:28}\r\n" +
        "MEDA     - Medical Alarm{3}\r\n" +
        "Buena Gardens Senior Housing;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Apt 312 - \r\n",

        "ID:2012040053",
        "DATE:11/05/2012",
        "TIME:14:13:28",
        "CODE:MEDA",
        "CALL:Medical Alarm",
        "PRI:3",
        "ADDR:Buena Gardens Senior Housing",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nApt 312 -");

    doTest("T15",
        "(Phoenix Notification) 2012040052 {11/04/2012 18:47:53}\r\n" +
        "SEIZ     - Seizures{3}\r\n" +
        "869 Main AVE;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040052",
        "DATE:11/04/2012",
        "TIME:18:47:53",
        "CODE:SEIZ",
        "CALL:Seizures",
        "PRI:3",
        "ADDR:869 Main AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T16",
        "(Phoenix Notification) 2012040051 {11/04/2012 17:27:35}\r\n" +
        "SEIZ     - Seizures{3}\r\n" +
        "107 W Pacific AVE;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 20/f - in an extended period of acrtive seizure - no hx that caller is aware of. Update reviewed by dispatcher- Zelinsky, Nicholas J \r\n",

        "ID:2012040051",
        "DATE:11/04/2012",
        "TIME:17:27:35",
        "CODE:SEIZ",
        "CALL:Seizures",
        "PRI:3",
        "ADDR:107 W Pacific AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n20/f - in an extended period of acrtive seizure - no hx that caller is aware of.");

    doTest("T17",
        "(Phoenix Notification) 2012040050 {11/04/2012 04:29:21}\r\n" +
        "PUB      - Public Service Assignment{3}\r\n" +
        "Buena Gardens Senior Housing;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Apt 207//93f lift assist Update reviewed by dispatcher- Vassaras, George \r\n",

        "ID:2012040050",
        "DATE:11/04/2012",
        "TIME:04:29:21",
        "CODE:PUB",
        "CALL:Public Service Assignment",
        "PRI:3",
        "ADDR:Buena Gardens Senior Housing",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nApt 207//93f lift assist");

    doTest("T18",
        "(Phoenix Notification) 2012040049 {11/03/2012 20:24:23}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "Wawa;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Pd on car stop pt complaining of chest pain Update reviewed by dispatcher- Vassaras, George \r\n",

        "ID:2012040049",
        "DATE:11/03/2012",
        "TIME:20:24:23",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:Wawa",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nPd on car stop pt complaining of chest pain");

    doTest("T19",
        "(Phoenix Notification) 2012040048 {11/03/2012 10:08:39}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "Parkview Gardens Senior Complex;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0155 - 11-9 Buena Boro EMS        \r\n" +
        " APT E4   FEMALE FELL FROM STANDING  KNEE PAIN Update reviewed by dispatcher- Gismondi, Mark P \r\n",

        "ID:2012040048",
        "DATE:11/03/2012",
        "TIME:10:08:39",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:Parkview Gardens Senior Complex",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0155 - 11-9 Buena Boro EMS\nAPT E4   FEMALE FELL FROM STANDING  KNEE PAIN");

    doTest("T20",
        "(Phoenix Notification) 2012040047 {11/03/2012 09:50:59}\r\n" +
        "CVA      - Stroke{2}\r\n" +
        "1255 Harding HWY;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040047",
        "DATE:11/03/2012",
        "TIME:09:50:59",
        "CODE:CVA",
        "CALL:Stroke",
        "PRI:2",
        "ADDR:1255 Harding HWY",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T21",
        "(Phoenix Notification) 2012040046 {11/03/2012 03:43:28}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "643 Main AVE;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040046",
        "DATE:11/03/2012",
        "TIME:03:43:28",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:643 Main AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T22",
        "(Phoenix Notification) 2012040045 {11/02/2012 17:42:49}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "216 Jonas AVE;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 60M c/o Leg Pain \r\n" +
        "Ext Med Hx \r\n" +
        " Lat/Long +39.516095 -74.952121 Update reviewed by dispatcher- Taylor, Kathy R \r\n",

        "ID:2012040045",
        "DATE:11/02/2012",
        "TIME:17:42:49",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:216 Jonas AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n60M c/o Leg Pain\nExt Med Hx\nLat/Long +39.516095 -74.952121");

    doTest("T23",
        "(Phoenix Notification) 2012040044 {11/01/2012 15:38:25}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "216 Jonas AVE;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0155 - 11-9 Buena Boro EMS        \r\n" +
        " 60M KNEE PAIN Update reviewed by dispatcher- Woodward, Walter B \r\n",

        "ID:2012040044",
        "DATE:11/01/2012",
        "TIME:15:38:25",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:216 Jonas AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0155 - 11-9 Buena Boro EMS\n60M KNEE PAIN");

    doTest("T24",
        "(Phoenix Notification) 2012040043 {11/01/2012 14:50:56}\r\n" +
        "DIAB     - Diabetic Emergency{2}\r\n" +
        "611 Cedar AVE;05\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1292,51MED;\r\n" +
        "Dispatched: E1292, E1192 \r\n",

        "ID:2012040043",
        "DATE:11/01/2012",
        "TIME:14:50:56",
        "CODE:DIAB",
        "CALL:Diabetic Emergency",
        "PRI:2",
        "ADDR:611 Cedar AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:Dispatched: E1292, E1192");

    doTest("T25",
        "(Phoenix Notification) 2012040042 {11/01/2012 14:40:59}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "Weymouth RD/Rt 54;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040042",
        "DATE:11/01/2012",
        "TIME:14:40:59",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:Weymouth RD & Rt 54",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T26",
        "(Phoenix Notification) 2012040041 {10/31/2012 23:28:56}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "600 S Central AVE;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " APT B4/63YOF KNEE PAIN FROM FALL Update reviewed by dispatcher- Epright, Lewis E \r\n",

        "ID:2012040041",
        "DATE:10/31/2012",
        "TIME:23:28:56",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:600 S Central AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nAPT B4/63YOF KNEE PAIN FROM FALL");

    doTest("T27",
        "(Phoenix Notification) 2012040040 {10/31/2012 14:42:22}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "St Augustine Prep;05\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1291,51MED;\r\n" +
        "Dispatched: E1291, E1192 \r\n",

        "ID:2012040040",
        "DATE:10/31/2012",
        "TIME:14:42:22",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:St Augustine Prep",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:Dispatched: E1291, E1192");

    doTest("T28",
        "(Phoenix Notification) 2012040039 {10/31/2012 14:28:44}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "St Augustine Prep;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1291;\r\n" +
        "Dispatched: E1191 \r\n",

        "ID:2012040039",
        "DATE:10/31/2012",
        "TIME:14:28:44",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:St Augustine Prep",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191");

    doTest("T29",
        "(Phoenix Notification) 2012040038 {10/30/2012 21:40:39}\r\n" +
        "BLED     - Bleeding{3}\r\n" +
        "Wheat Manor Apts,29;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0155 - 11-9 Buena Boro EMS        \r\n" +
        " 13/M OPENING CAN OF CAT FOOD CUT FINGER Update reviewed by dispatcher- Ross, William L \r\n",

        "ID:2012040038",
        "DATE:10/30/2012",
        "TIME:21:40:39",
        "CODE:BLED",
        "CALL:Bleeding",
        "PRI:3",
        "ADDR:Wheat Manor Apts",
        "APT:29",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0155 - 11-9 Buena Boro EMS\n13/M OPENING CAN OF CAT FOOD CUT FINGER");

    doTest("T30",
        "(Phoenix Notification) 2012040037 {10/30/2012 20:44:56}\r\n" +
        "ABDM     - Abdominal Pain{3}\r\n" +
        "Buena MS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040037",
        "DATE:10/30/2012",
        "TIME:20:44:56",
        "CODE:ABDM",
        "CALL:Abdominal Pain",
        "PRI:3",
        "ADDR:Buena MS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T31",
        "(Phoenix Notification) 2012040036 {10/29/2012 21:57:15}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "100 N Willow ST;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Apt A     62m Hx:Card   Sudden onset of CP Update reviewed by dispatcher- Vassaras, George \r\n",

        "ID:2012040036",
        "DATE:10/29/2012",
        "TIME:21:57:15",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:100 N Willow ST",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nApt A     62m Hx:Card   Sudden onset of CP");

    doTest("T32",
        "(Phoenix Notification) 2012040035 {10/29/2012 15:17:25}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "104 Park DR;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " Needs dispatch for a pregant women to go to regional Update reviewed by dispatcher- Taylor, Kathy R \r\n",

        "ID:2012040035",
        "DATE:10/29/2012",
        "TIME:15:17:25",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:104 Park DR",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nNeeds dispatch for a pregant women to go to regional");

    doTest("T33",
        "(Phoenix Notification) 2012040034 {10/29/2012 14:12:46}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "Buena MS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 \r\n",

        "ID:2012040034",
        "DATE:10/29/2012",
        "TIME:14:12:46",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:Buena MS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191");

    doTest("T34",
        "(Phoenix Notification) 2012040033 {10/29/2012 13:16:28}\r\n" +
        "UNC      - Unconscious Person{1}\r\n" +
        "Buena MS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191 (PARTIAL) ;\r\n" +
        "Dispatched: E1191, MED4 \r\n",

        "ID:2012040033",
        "DATE:10/29/2012",
        "TIME:13:16:28",
        "CODE:UNC",
        "CALL:Unconscious Person",
        "PRI:1",
        "ADDR:Buena MS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191, MED4");

    doTest("T35",
        "(Phoenix Notification) 2012040032 {10/28/2012 23:47:18}\r\n" +
        "CA       - Cardiac Arrest{1}\r\n" +
        "654 Sixth RD;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040032",
        "DATE:10/28/2012",
        "TIME:23:47:18",
        "CODE:CA",
        "CALL:Cardiac Arrest",
        "PRI:1",
        "ADDR:654 Sixth RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T36",
        "(Phoenix Notification) 2012040031 {10/28/2012 00:32:22}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "Vineland City;CU\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        "  \r\n",

        "ID:2012040031",
        "DATE:10/28/2012",
        "TIME:00:32:22",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:Vineland City",
        "CITY:CUMBERLAND COUNTY",
        "UNIT:E1191");

    doTest("T37",
        "(Phoenix Notification) 2012040030 {10/27/2012 14:53:20}\r\n" +
        "PSYC     - Psychological Emergency{3}\r\n" +
        "4154 Post RD;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1291;\r\n" +
        "Dispatched: E1191 \r\n",

        "ID:2012040030",
        "DATE:10/27/2012",
        "TIME:14:53:20",
        "CODE:PSYC",
        "CALL:Psychological Emergency",
        "PRI:3",
        "ADDR:4154 Post RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191");

    doTest("T38",
        "(Phoenix Notification) 2012040029 {10/26/2012 21:29:21}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "Buena Regional HS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1291;\r\n" +
        "Dispatched: E1191 \r\n",

        "ID:2012040029",
        "DATE:10/26/2012",
        "TIME:21:29:21",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:Buena Regional HS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191");

    doTest("T39",
        "(Phoenix Notification) 2012040028 {10/26/2012 19:47:15}\r\n" +
        "MEDA     - Medical Alarm{3}\r\n" +
        "Buena Gardens Senior Housing;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " RM 107\r\n" +
        "MAGARITA PEREZ PREM # 8566973074 (DISCONNECTED) Update reviewed by dispatcher- Reagan, Stephen W \r\n",

        "ID:2012040028",
        "DATE:10/26/2012",
        "TIME:19:47:15",
        "CODE:MEDA",
        "CALL:Medical Alarm",
        "PRI:3",
        "ADDR:Buena Gardens Senior Housing",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nRM 107\nMAGARITA PEREZ PREM # 8566973074 (DISCONNECTED)");

    doTest("T40",
        "(Phoenix Notification) 2012040027 {10/26/2012 18:45:13}\r\n" +
        "STBY     - Standby{3}\r\n" +
        "Buena Regional HS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040027",
        "DATE:10/26/2012",
        "TIME:18:45:13",
        "CODE:STBY",
        "CALL:Standby",
        "PRI:3",
        "ADDR:Buena Regional HS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T41",
        "(Phoenix Notification) 2012040026 {10/26/2012 17:10:45}\r\n" +
        "CHOK     - Choking{2}\r\n" +
        "107 S Nixon ST;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 8mom ; choked on a Update reviewed by dispatcher- Richards, Bryan D \r\n",

        "ID:2012040026",
        "DATE:10/26/2012",
        "TIME:17:10:45",
        "CODE:CHOK",
        "CALL:Choking",
        "PRI:2",
        "ADDR:107 S Nixon ST",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n8mom ; choked on a");

    doTest("T42",
        "(Phoenix Notification) 2012040025 {10/26/2012 10:10:42}\r\n" +
        "RE       - Respiratory Emergency{2}\r\n" +
        "420 Captain Smith LN;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040025",
        "DATE:10/26/2012",
        "TIME:10:10:42",
        "CODE:RE",
        "CALL:Respiratory Emergency",
        "PRI:2",
        "ADDR:420 Captain Smith LN",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T43",
        "(Phoenix Notification) 2012040024 {10/26/2012 09:22:13}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "5319 Old Landis Ave;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] \r\n",

        "ID:2012040024",
        "DATE:10/26/2012",
        "TIME:09:22:13",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:5319 Old Landis Ave",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191]");

    doTest("T44",
        "(Phoenix Notification) 2012040023 {10/26/2012 07:20:12}\r\n" +
        "CE       - Cardiac Emergency{2}\r\n" +
        "242 Wheat RD;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 94m ; cp rad into left arm / sob\r\n" +
        "hx htn Update reviewed by dispatcher- Richards, Bryan D \r\n",

        "ID:2012040023",
        "DATE:10/26/2012",
        "TIME:07:20:12",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:242 Wheat RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191",
        "INFO:0145 - 11-9 Buena Boro EMS\n94m ; cp rad into left arm / sob\nhx htn");

    doTest("T45",
        "(Phoenix Notification) 2012040022 {10/26/2012 00:33:56}\r\n" +
        "ABDM     - Abdominal Pain{3}\r\n" +
        "105 N Auburn ST;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 30f/6 mon pregnant/pain in abdm/ Update reviewed by dispatcher- Lawrence, Joseph B \r\n",

        "ID:2012040022",
        "DATE:10/26/2012",
        "TIME:00:33:56",
        "CODE:ABDM",
        "CALL:Abdominal Pain",
        "PRI:3",
        "ADDR:105 N Auburn ST",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n30f/6 mon pregnant/pain in abdm/");

    doTest("T46",
        "(Phoenix Notification) 2012040021 {10/25/2012 07:33:17}\r\n" +
        "SEIZ     - Seizures{3}\r\n" +
        "Buena Regional HS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended:  (PARTIAL) ;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 14f active Update reviewed by dispatcher- Krier, Michael A \r\n",

        "ID:2012040021",
        "DATE:10/25/2012",
        "TIME:07:33:17",
        "CODE:SEIZ",
        "CALL:Seizures",
        "PRI:3",
        "ADDR:Buena Regional HS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n14f active");

    doTest("T47",
        "(Phoenix Notification) 2012040020 {10/24/2012 20:39:03}\r\n" +
        "OD       - Overdose{3}\r\n" +
        "408 Wheat RD,2;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 38/m took to many pills per caller around the back,unk type pills Update reviewed by dispatcher- Talarico, Kevin P \r\n",

        "ID:2012040020",
        "DATE:10/24/2012",
        "TIME:20:39:03",
        "CODE:OD",
        "CALL:Overdose",
        "PRI:3",
        "ADDR:408 Wheat RD",
        "APT:2",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n38/m took to many pills per caller around the back,unk type pills");

    doTest("T48",
        "(Phoenix Notification) 2012040019 {10/24/2012 13:34:41}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "Buena Terrace Apts;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191;\r\n" +
        "Dispatched: E1191 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " APT 304 \r\n" +
        "94/F - FELL - PAIN IN LOWER EXTREMINTY Update reviewed by dispatcher- Krier, Michael A \r\n",

        "ID:2012040019",
        "DATE:10/24/2012",
        "TIME:13:34:41",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:Buena Terrace Apts",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nAPT 304\n94/F - FELL - PAIN IN LOWER EXTREMINTY");

    doTest("T49",
        "(Phoenix Notification) 2012040018 {10/24/2012 08:44:44}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "120 Country LN;05\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] 61f dizzy, weak \r\n",

        "ID:2012040018",
        "DATE:10/24/2012",
        "TIME:08:44:44",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:120 Country LN",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:[E1192] 61f dizzy, weak");

    doTest("T50",
        "(Phoenix Notification) 2012040017 {10/21/2012 13:12:22}\r\n" +
        "MVC      - Motor Vehicle Crash{2}\r\n" +
        "Sixth RD/Ninth ST\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] NJSP req driver checked out who is feeling \"woozy\" R 12300, 12300A, 12600a, 1238/4 \r\n",

        "ID:2012040017",
        "DATE:10/21/2012",
        "TIME:13:12:22",
        "CODE:MVC",
        "CALL:Motor Vehicle Crash",
        "PRI:2",
        "ADDR:Sixth RD & Ninth ST",
        "UNIT:E1192 119",
        "INFO:[E1192] NJSP req driver checked out who is feeling \"woozy\" R 12300, 12300A, 12600a, 1238/4");

    doTest("T51",
        "(Phoenix Notification) 2012040016 {10/21/2012 02:24:15}\r\n" +
        "RE       - Respiratory Emergency{2}\r\n" +
        "207 E Pacific AVE;04\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: E1191,51MED;\r\n" +
        "Dispatched: E1191, 51MED Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 38F RESP DISTRESS WHEEZING-- NEB TREATMENT\r\n" +
        " Lat/Long +39.517629 -74.945641 Update reviewed by dispatcher- Vassaras, George \r\n",

        "ID:2012040016",
        "DATE:10/21/2012",
        "TIME:02:24:15",
        "CODE:RE",
        "CALL:Respiratory Emergency",
        "PRI:2",
        "ADDR:207 E Pacific AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n38F RESP DISTRESS WHEEZING-- NEB TREATMENT\nLat/Long +39.517629 -74.945641");

    doTest("T52",
        "(Phoenix Notification) 2012040015 {10/20/2012 22:24:51}\r\n" +
        "MVC      - Motor Vehicle Crash{2}\r\n" +
        "Weymouth RD/Walnut LN;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] AIR BAGS DEPLOYED PER PD \r\n",

        "ID:2012040015",
        "DATE:10/20/2012",
        "TIME:22:24:51",
        "CODE:MVC",
        "CALL:Motor Vehicle Crash",
        "PRI:2",
        "ADDR:Weymouth RD & Walnut LN",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191] AIR BAGS DEPLOYED PER PD");

    doTest("T53",
        "(Phoenix Notification) 2012040014 {10/20/2012 20:36:39}\r\n" +
        "RE       - Respiratory Emergency{2}\r\n" +
        "Vineland City;CU\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended: Dispatched: E1191 Vineland Devlopmental Cneter 1676 E landis Ave Wolverton Cottage \r\n",

        "ID:2012040014",
        "DATE:10/20/2012",
        "TIME:20:36:39",
        "CODE:RE",
        "CALL:Respiratory Emergency",
        "PRI:2",
        "ADDR:Vineland City",
        "CITY:CUMBERLAND COUNTY",
        "UNIT:E1191 119");

    doTest("T54",
        "(Phoenix Notification) 2012040013 {10/20/2012 10:13:51}\r\n" +
        "MEDE     - Medical Emergency{3}\r\n" +
        "1060 Harding HWY;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] PER 1292  GO TO MUTUAL AID\r\n" +
        " 58F GENERALIZED PAIN \r\n",

        "ID:2012040013",
        "DATE:10/20/2012",
        "TIME:10:13:51",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:1060 Harding HWY",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:[E1191] PER 1292  GO TO MUTUAL AID\n58F GENERALIZED PAIN");

    doTest("T55",
        "(Phoenix Notification) 2012040012 {10/19/2012 19:07:25}\r\n" +
        "STBY     - Standby{3}\r\n" +
        "Buena Regional HS;05\r\n" +
        "Units:\r\n" +
        "    E1191   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1191] Units Recommended:  (PARTIAL) ;\r\n" +
        "Dispatched: E1191 Football Standby - available for priority calls in local Update reviewed by dispatcher- Priggemeier, Bryce A \r\n",

        "ID:2012040012",
        "DATE:10/19/2012",
        "TIME:19:07:25",
        "CODE:STBY",
        "CALL:Standby",
        "PRI:3",
        "ADDR:Buena Regional HS",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1191 119",
        "INFO:Dispatched: E1191 Football Standby - available for priority calls in local");

    doTest("T56",
        "(Phoenix Notification) 2012040008 {10/19/2012 18:00:59}\r\n" +
        "FALL     - Fall Victim{3}\r\n" +
        "301 E Summer RD;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " ADD ALS//7 YOM fell down 13 steps, c/o shoulder injury, contusion on his hip, coa Update reviewed by dispatcher- Gallo, Andrew M \r\n",

        "ID:2012040008",
        "DATE:10/19/2012",
        "TIME:18:00:59",
        "CODE:FALL",
        "CALL:Fall Victim",
        "PRI:3",
        "ADDR:301 E Summer RD",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0145 - 11-9 Buena Boro EMS\nADD ALS//7 YOM fell down 13 steps, c/o shoulder injury, contusion on his hip, coa");

    doTest("T57",
        "(Phoenix Notification) 2012040007 {10/19/2012 14:00:54}\r\n" +
        "BLED     - Bleeding{3}\r\n" +
        "710 Summer AVE;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 30 YOM, drill into his wrist Update reviewed by dispatcher- Taylor, Kathy R \r\n",

        "ID:2012040007",
        "DATE:10/19/2012",
        "TIME:14:00:54",
        "CODE:BLED",
        "CALL:Bleeding",
        "PRI:3",
        "ADDR:710 Summer AVE",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n30 YOM, drill into his wrist");

    doTest("T58",
        "(Phoenix Notification) 2012040006 {10/19/2012 11:06:02}\r\n" +
        "CVA      - Stroke{2}\r\n" +
        "204 S Nixon ST;04\r\n" +
        "Units:\r\n" +
        "    E1192   \r\n" +
        "Comments:\r\n" +
        " Toner Alert Instantiated \r\n" +
        "{119}[E1192] Units Recommended: E1192,51MED;\r\n" +
        "Dispatched: E1192 Toner Alert Instantiated, Following tones sent to device - F1   \r\n" +
        "0145 - 11-9 Buena Boro EMS        \r\n" +
        " 53m, numbness to left face, arm Update reviewed by dispatcher- Gallo, Andrew M \r\n",

        "ID:2012040006",
        "DATE:10/19/2012",
        "TIME:11:06:02",
        "CODE:CVA",
        "CALL:Stroke",
        "PRI:2",
        "ADDR:204 S Nixon ST",
        "CITY:BUENA VISTA TWP",
        "UNIT:E1192 119",
        "INFO:0145 - 11-9 Buena Boro EMS\n53m, numbness to left face, arm");

  }
  
  @Test
  public void testWoodburyHeights() {

    doTest("T1",
        "(Phoenix Notification) 2013000105 {07/25/2013 15:23:52}\n" +
        "ALRM     - Fire Alarm System{3}\n" +
        "300 Beech AVE;W\n" +
        "Units:\n" +
        "    \n" +
        "Comments:\n" +
        " Toner Alert Initiated \n" +
        "{151} Station Dispatched : {151} Units Recommended: ,,;\n" +
        "Dispatched: {151}, {131}, {091} Toner Alert Initiated, Following tones sent to device - F1   \n" +
        "0211 - 15-1 Woodbury Heights FD        \n" +
        "0210 - 13-1 Wenonah FD        \n" +
        "0100 - 9-1 Oak Valley FD        \n" +
        "0130 - 9-1 Oak Valley FD        \n" +
        " General fire alarm\n" +
        "Prm: 856-845-9530\n" +
        "Oper: 4106\n" +
        " Update reviewed by dispatcher- Gismondi, Ettore J ",

        "ID:2013000105",
        "DATE:07/25/2013",
        "TIME:15:23:52",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:300 Beech AVE",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:151 131 091",
        "INFO:Toner Alert Initiated\nToner Alert Initiated, Following tones sent to device - F1\n0211 - 15-1 Woodbury Heights FD\n0210 - 13-1 Wenonah FD\n0100 - 9-1 Oak Valley FD\n0130 - 9-1 Oak Valley FD\nGeneral fire alarm\nPrm: 856-845-9530\nOper: 4106");

    doTest("T2",
        "(Phoenix Notification) 2013000104 {07/25/2013 05:47:58}\n" +
        "ALRM     - Fire Alarm System{3}\n" +
        "775 Tanyard RD;W\n" +
        "Units:\n" +
        "    \n" +
        "Comments:\n" +
        " Toner Alert Initiated \n" +
        "{151} Station Dispatched : {151} Units Recommended: ,,,,E1519;\n" +
        "Dispatched: {151}, {131}, {091}, {094}, E1519 Toner Alert Initiated, Following tones sent to device - F1   \n" +
        "0211 - 15-1 Woodbury Heights FD        \n" +
        "0210 - 13-1 Wenonah FD        \n" +
        "0100 - 9-1 Oak Valley FD        \n" +
        "0130 - 9-1 Oak Valley FD        \n" +
        "0151 - 9-4 Lake Tract FD        \n" +
        "0221 - 15-9 Woobbury Heights EMS        \n" +
        " ",

        "ID:2013000104",
        "DATE:07/25/2013",
        "TIME:05:47:58",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:775 Tanyard RD",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:151 131 091 094",
        "INFO:Toner Alert Initiated\nE1519 Toner Alert Initiated, Following tones sent to device - F1\n0211 - 15-1 Woodbury Heights FD\n0210 - 13-1 Wenonah FD\n0100 - 9-1 Oak Valley FD\n0130 - 9-1 Oak Valley FD\n0151 - 9-4 Lake Tract FD\n0221 - 15-9 Woobbury Heights EMS");

    doTest("T3",
        "(Phoenix Notification) 2013000246 {07/24/2013 21:54:31}\n" +
        "SEIZ     - Seizures{3}\n" +
        "779 Candidus AVE;W\n" +
        "Units:\n" +
        "    E1519   \n" +
        "Comments:\n" +
        " Toner Alert Initiated \n" +
        "{159}[E1519] Units Recommended: E1519,LS-1;\n" +
        "Dispatched: E1519, LS-1 Toner Alert Initiated, Following tones sent to device - F1   \n" +
        "0221 - 15-9 Woobbury Heights EMS        \n" +
        "0258 - LS-1    \n" +
        " 29 YOF / ACTIVE SEIZURE / 1 MIN\n" +
        "HX: SEIZURES Names Updated : Name changed from Aegemian Pete to Aegemian, Pete; \n" +
        " Update reviewed by dispatcher- Epright, Lewis E ",

        "ID:2013000246",
        "DATE:07/24/2013",
        "TIME:21:54:31",
        "CODE:SEIZ",
        "CALL:Seizures",
        "PRI:3",
        "ADDR:779 Candidus AVE",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:E1519 159",
        "INFO:Toner Alert Initiated\nDispatched: E1519, LS-1 Toner Alert Initiated, Following tones sent to device - F1\n0221 - 15-9 Woobbury Heights EMS\n0258 - LS-1\n29 YOF / ACTIVE SEIZURE / 1 MIN\nHX: SEIZURES Names Updated : Name changed from Aegemian Pete to Aegemian, Pete;");

    doTest("T4",
        "(Phoenix Notification) 2013000103 {07/24/2013 10:49:18}\n" +
        "CE       - Cardiac Emergency{2}\n" +
        "848 Lake AVE;W\n" +
        "Units:\n" +
        "    F1518   \n" +
        "Comments:\n" +
        " Toner Alert Initiated \n" +
        "{151}[F1518] 57yom/hx card/ sweating vommiting weak pulse/ lathergic  ",

        "ID:2013000103",
        "DATE:07/24/2013",
        "TIME:10:49:18",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:848 Lake AVE",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:F1518 151",
        "INFO:Toner Alert Initiated\n[F1518] 57yom/hx card/ sweating vommiting weak pulse/ lathergic");

    doTest("T5",
        "(Phoenix Notification) 2013000243 {07/24/2013 01:59:29}\n" +
        "PUB      - Public Service Assignment{3}\n" +
        "1051 Walnut AVE;W\n" +
        "Units:\n" +
        "    E1519   \n" +
        "Comments:\n" +
        " Toner Alert Instantiated \n" +
        "{159}[E1519] Units Recommended: E1519;\n" +
        "Dispatched: E1519 Toner Alert Instantiated, Following tones sent to device - F1   \n" +
        "0221 - 15-9 Woobbury Heights EMS        \n" +
        " Lift assist Update reviewed by dispatcher- Mcgarvey, Raymond E ",

        "ID:2013000243",
        "DATE:07/24/2013",
        "TIME:01:59:29",
        "CODE:PUB",
        "CALL:Public Service Assignment",
        "PRI:3",
        "ADDR:1051 Walnut AVE",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:E1519 159",
        "INFO:0221 - 15-9 Woobbury Heights EMS\nLift assist");

    doTest("T6",
        "(Phoenix Notification) 2013000102 {07/23/2013 07:50:46}\n" +
        "ALRM     - Fire Alarm System{3}\n" +
        "775 Tanyard RD;W\n" +
        "Units:\n" +
        "    \n" +
        "Comments:\n" +
        " Toner Alert Instantiated \n" +
        "{151} Station Dispatched : {151} Units Recommended: ,,,,E1519;\n" +
        "Dispatched: {151}, {131}, {091}, {094}, E1519 Toner Alert Instantiated, Following tones sent to device - F1   \n" +
        "0211 - 15-1 Woodbury Heights FD        \n" +
        "0210 - 13-1 Wenonah FD        \n" +
        "0100 - 9-1 Oak Valley FD        \n" +
        "0130 - 9-1 Oak Valley FD        \n" +
        "0151 - 9-4 Lake Tract FD        \n" +
        " Zone 001, called in by oper 3991 Update reviewed by dispatcher- Weston, Karlee J ",

        "ID:2013000102",
        "DATE:07/23/2013",
        "TIME:07:50:46",
        "CODE:ALRM",
        "CALL:Fire Alarm System",
        "PRI:3",
        "ADDR:775 Tanyard RD",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:151 131 091 094",
        "INFO:0211 - 15-1 Woodbury Heights FD\n0210 - 13-1 Wenonah FD\n0100 - 9-1 Oak Valley FD\n0130 - 9-1 Oak Valley FD\n0151 - 9-4 Lake Tract FD\nZone 001, called in by oper 3991");

    doTest("T7",
        "(Phoenix Notification) 2013000241 {07/22/2013 20:56:29}\n" +
        "MEDE     - Medical Emergency{3}\n" +
        "820 Cooper ST;B\n" +
        "Units:\n" +
        "    E1519   \n" +
        "Comments:\n" +
        " Toner Alert Instantiated \n" +
        "{159}[E1519] Bls requested for PT in pain ",

        "ID:2013000241",
        "DATE:07/22/2013",
        "TIME:20:56:29",
        "CODE:MEDE",
        "CALL:Medical Emergency",
        "PRI:3",
        "ADDR:820 Cooper ST",
        "CITY:DEPTFORD",
        "UNIT:E1519 159",
        "INFO:[E1519] Bls requested for PT in pain");

    doTest("T8",
        "(Phoenix Notification) 2013000240 {07/21/2013 14:51:41}\n" +
        "CE       - Cardiac Emergency{2}\n" +
        "153 Vanderbilt AVE;W\n" +
        "Units:\n" +
        "    E1519   \n" +
        "Comments:\n" +
        " Units Recommended: E1519,LS-1;\n" +
        "Dispatched: E1519, LS-1 Toner Alert Instantiated, Following tones sent to device - F1   \n" +
        "0221 - 15-9 Woobbury Heights EMS        \n" +
        "0258 - LS-1    \n" +
        " 56F, is feeling shakey and heart palps. N/V No CP, however is mildly SOB. Hx:anxiety attack. Update reviewed by dispatcher- Talarico, Kevin P ",

        "ID:2013000240",
        "DATE:07/21/2013",
        "TIME:14:51:41",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:153 Vanderbilt AVE",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:E1519",
        "INFO:0221 - 15-9 Woobbury Heights EMS\n0258 - LS-1\n56F, is feeling shakey and heart palps. N/V No CP, however is mildly SOB. Hx:anxiety attack.");

    doTest("T9",
        "(Phoenix Notification) 2013000101 {07/20/2013 21:18:44}\n" +
        "WIRE     - Wires down or Arcing{3}\n" +
        "748 Second ST;W\n" +
        "Units:\n" +
        "    \n" +
        "Comments:\n" +
        " Toner Alert Instantiated \n" +
        "{151} Station Dispatched : {151} Units Recommended: ;\n" +
        "Dispatched: {151} Toner Alert Instantiated, Following tones sent to device - F1   \n" +
        "0211 - 15-1 Woodbury Heights FD        \n" +
        " ",

        "ID:2013000101",
        "DATE:07/20/2013",
        "TIME:21:18:44",
        "CODE:WIRE",
        "CALL:Wires down or Arcing",
        "PRI:3",
        "ADDR:748 Second ST",
        "CITY:WOODBURY HEIGHTS",
        "UNIT:151",
        "INFO:0211 - 15-1 Woodbury Heights FD");

    doTest("T10",
        "(Phoenix Notification) 2013000239 {07/20/2013 13:53:49}\n" +
        "CE       - Cardiac Emergency{2}\n" +
        "106 Andaloro WAY;B\n" +
        "Units:\n" +
        "    E1519   \n" +
        "Comments:\n" +
        " Toner Alert Instantiated \n" +
        "{159}[E1519] Units Recommended: E992,MEDIC;\n" +
        "Dispatched: E992, E1519 90F CP SOB PAIN IN R ARM CARD HX ",

        "ID:2013000239",
        "DATE:07/20/2013",
        "TIME:13:53:49",
        "CODE:CE",
        "CALL:Cardiac Emergency",
        "PRI:2",
        "ADDR:106 Andaloro WAY",
        "CITY:DEPTFORD",
        "UNIT:E1519 159",
        "INFO:Dispatched: E992, E1519 90F CP SOB PAIN IN R ARM CARD HX");

  }
  
  @Test
  public void testRick() {

    doTest("T1",
        "GC ALERT (#B0WT) FD 6-3: {08/18/2013 02:19:18}\nRUB      - Rubbish Fire{3}\n701 Red Bank AVE,COMPLEX;T STOP",
        "ID:B0WT",
        "SRC:FD 6-3",
        "DATE:08/18/2013",
        "TIME:02:19:18",
        "CODE:RUB",
        "CALL:Rubbish Fire",
        "PRI:3",
        "ADDR:701 Red Bank AVE",
        "APT:COMPLEX");

  }
  
  public static void main(String[] args) {
    new NJGloucesterCountyAParserTest().generateTests("T1");
  }
}