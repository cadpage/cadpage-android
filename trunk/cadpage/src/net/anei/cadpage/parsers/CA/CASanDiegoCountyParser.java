package net.anei.cadpage.parsers.CA;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

/*
San Diego County, CA
Contact: Active911
Agency name: San Marcos Fire Location: San Marcos, CA 
Sender: cad@jpapage.net,cad@sdrecc.org

(CAD MESSAGE) ALM:1\MSTR INC#:2012-071122   \TYP:MEDICAL AID           \ADR:420 N Twin Oaks Valley Rd               \LOC:POST OFFICE-SMC-420 N TO\APT\SP:          \TB:1108H7\MAP:5624A \XST:RICHMAR AV/CHRISTEN WY                  \TG:. TAC 1 INDIA  \TIMEDSP:12:03:48\UNITS:1411,1491\PREPLN;\TXT:CELL SITE ADDRESS: 201 TRADE,This incident 2012-071122 has been sent to RCIP via the CAD2CAD Interfa\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071231   \TYP:FIRE ALARM - APARTMENT\ADR:652 Vineyard Rd                         \LOC:KNOLL APTS (652)        \APT\SP:APT 104   \TB:1108J6\MAP:5724C \XST:BORDEN RD/CHENIN WY                     \TG:. TAC 1 INDIA  \TIMEDSP:16:42:42\UNITS:1411\PREPLN;\TXT:This incident 2012-071231 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071347   \TYP:RESCUE - TC / VEH     \ADR:104 - 106 N Twin Oaks Valley Rd         \LOC:                        \APT\SP:          \TB:1128H1\MAP:5624A \XST:SR78 WB/SR78 ON RA WB                   \TG:. TAC 1 INDIA  \TIMEDSP:23:01:03\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-071347 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071383   \TYP:MEDICAL AID           \ADR:343 Autumn Dr                           \LOC:MISSION VIEW APTS.      \APT\SP:APT 122   \TB:1108H7\MAP:5623C \XST:CHINABERRY LN/UNNAMED                   \TG:. TAC 1 INDIA  \TIMEDSP:02:07:33\UNITS:1411,1491\PREPLN;\TXT:[Premise:  343 AUTUMN DR] [ ] [UNKNOWN] S.A.M.   J26-04,CELL SITE ADDRESS: 567 GRAND AV,This inciden\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071387   \TYP:POISONING             \ADR:Mulberry Dr / Borden Rd                 \LOC:                        \APT\SP:          \TB:1109A6\MAP:5725A \XST:                                        \TG:. TAC 1 INDIA  \TIMEDSP:03:09:01\UNITS:1411,1491\PREPLN;\TXT:CELL SITE ADDRESS: 570 RANCHEROS DR,This incident 2012-071387 has been sent to RCIP via the CAD2CAD \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071405   \TYP:ABDOMINAL PAIN        \ADR:500 Rancheros Dr                        \LOC:RANCHEROS SAN MARCOS MHP\APT\SP:SP 136    \TB:1108J7\MAP:5624C \XST:TERRACE LN/MATA WY                      \TG:. TAC 1 INDIA  \TIMEDSP:04:25:56\UNITS:1411,1491\PREPLN;\TXT:[Premise:  500 RANCHEROS DR] [ ] [UNKNOWN] S.A.M. PG #K26-01,This incident 2012-071405 has been sent\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071411   \TYP:DIFFICULTY BREATHING  \ADR:701 Marcos Vista Ln                     \LOC:                        \APT\SP:          \TB:1108C6\MAP:5721C \XST:OLEANDER AV/Dead End                    \TG:. TAC 1 INDIA  \TIMEDSP:05:03:49\UNITS:1411,1492\PREPLN;\TXT:CELL SITE ADDRESS: 2128 THIBIDO CT,This incident 2012-071411 has been sent to RCIP via the CAD2CAD I\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071429   \TYP:SEIZURE               \ADR:3421 Polley Dr                          \LOC:                        \APT\SP:4         \TB:1108D5\MAP:5722A \XST:LAS FLORES DR/Dead End                  \TG:. TAC 1 INDIA  \TIMEDSP:06:47:44\UNITS:1411,1491\PREPLN;\TXT:CELL SITE ADDRESS: 100 SANTA FE RD,This incident 2012-071429 has been sent to RCIP via the CAD2CAD I\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071919   \TYP:SNAKE REMOVAL         \ADR:1010 N Twin Oaks Valley Rd              \LOC:                        \APT\SP:          \TB:1108J5\MAP:5724A \XST:LEGACY DR/DEL ROY DR                    \TG:. TAC 1 INDIA  \TIMEDSP:13:24:05\UNITS:1471\PREPLN;\TXT:CELL SITE ADDRESS: 1441 N. TWIN OAKS VALLEY ROAD,This incident 2012-071919 has been sent to RCIP via\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071967   \TYP:LIFT ASSIST           \ADR:1750 Marilyn Ln                         \LOC:                        \APT\SP:          \TB:1109A3\MAP:5925A \XST:PARSONS LN/BIRCHWOOD DR                 \TG:. TAC 1 INDIA  \TIMEDSP:15:25:15\UNITS:1471\PREPLN;\TXT:This incident 2012-071967 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-071990   \TYP:ABDOMINAL PAIN        \ADR:420 Smilax Rd                           \LOC:NORTHWOOD APTS (420)    \APT\SP:SPT 105   \TB:1108C5\MAP:5722A \XST:MIMOSA AV/ADELINE CT                    \TG:. TAC 1 INDIA  \TIMEDSP:16:34:20\UNITS:1471,1492\PREPLN;\TXT:CELL SITE ADDRESS: 2951 NORMAN STRASSE RD,This incident 2012-071990 has been sent to RCIP via the CA\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-072060   \TYP:MEDICAL AID           \ADR:650 S Rancho Santa Fe Rd                \LOC:PALOMAR ESTATES MHP-EAST\APT\SP:SP 129    \TB:1128C1\MAP:5522A \XST:UNNAMED/W SAN MARCOS BLVD               \TG:. TAC 1 INDIA  \TIMEDSP:19:01:00\UNITS:1471,1493\PREPLN;\TXT:This incident 2012-072060 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-072248   \TYP:COMMERCIAL FIRE       \ADR:333 S Twin Oaks Valley Rd               \LOC:CAL STATE SAN MARCOS    \APT\SP:          \TB:1128H2\MAP:5524A \XST:DISCOVERY ST/CRAVEN RD                  \TG:. TAC 1 KILO   \TIMEDSP:09:35:59\UNITS:1471,1411,1414,1274,1491,1403,\PREPLN;\TXT:CELL SITE ADDRESS: 324 TWIN OAKS VALLEY RD,This incident 2012-072248 has been sent to RCIP via the C\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-072311   \TYP:MEDICAL AID           \ADR:1316 Knob Hill Rd                       \LOC:                        \APT\SP:          \TB:1109C7\MAP:5625C \XST:CAMINO MATEO/GLEN AVON DR               \TG:. TAC 1 INDIA  \TIMEDSP:11:42:16\UNITS:1471,1491\PREPLN;\TXT:This incident 2012-072311 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-072323   \TYP:SICK PERSON (SPEC DIAG\ADR:1590 W San Marcos Bl                    \LOC:BROOKDALE PLACE         \APT\SP:RM 350    \TB:1128D2\MAP:5522A \XST:DISCOVERY ST/KNIGHTS REALM              \TG:. TAC 1 INDIA  \TIMEDSP:12:03:55\UNITS:1471,1491\PREPLN;\TXT:This incident 2012-072323 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-072593   \TYP:LOCKOUT - STRUCTURE   \ADR:125 N Twin Oaks Valley Rd               \LOC:LA FITNESS-SMC-125 TOV  \APT\SP:          \TB:1128H1\MAP:5624A \XST:SR78 OFF RA WB/VIA DEL PRADO            \TG:. TAC 1 INDIA  \TIMEDSP:23:16:00\UNITS:1471\PREPLN;\TXT:SDSO STATES SOMEONE IS LOCKED INSIDE, REQ FD TO ASSIST,This incident 2012-072593 has been sent to RC\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073036   \TYP:MEDICAL AID           \ADR:883 Discovery St                        \LOC:                        \APT\SP:          \TB:1128F2\MAP:5523A \XST:JOY CT/VIA VERA CRUZ                    \TG:. TAC 1 INDIA  \TIMEDSP:07:04:00\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-073036 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073042   \TYP:FIRE ALARM - COMM     \ADR:700 N Twin Oaks Valley Rd               \LOC:KRC ROCK                \APT\SP:          \TB:1108H6\MAP:5724A \XST:W BORDEN RD/WINDY WY                    \TG:. TAC 1 INDIA  \TIMEDSP:07:27:25\UNITS:1411\PREPLN;\TXT:CVOVERS UPSTAIRS SMOKE DETECTOR, HAS  RESET, CB IS PENDING,This incident 2012-073042 has been sent t\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073260   \TYP:FALL - NOT HEIGHT     \ADR:1105 Elfin Forest Rd                    \LOC:SAN ELIJO PARK          \APT\SP:          \TB:1128D6\MAP:5222A \XST:SAN ELIJO RD/ARCHER RD                  \TG:. TAC 1 INDIA  \TIMEDSP:17:13:05\UNITS:1414,1494\PREPLN;\TXT:CELL SITE ADDRESS: 1686 LOMAS SANTA FE DR,This incident 2012-073260 has been sent to RCIP via the CA\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073324   \TYP:ALLERGIES             \ADR:400 Craven Rd                           \LOC:KAISER PERMANENTE-SMC-40\APT\SP:          \TB:1128G2\MAP:5523C \XST:RUSH DR/ECHO LN                         \TG:. TAC 1 INDIA  \TIMEDSP:19:59:40\UNITS:1414,1494\PREPLN;\TXT:[Premise:  400 CRAVEN RD] [ ] [UNKNOWN] KNOX LOCATED SE CORNER OF FRONT ENTRANCE BLDG 2.  **FD ENTRA\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073404   \TYP:FIRE ALARM - COMM     \ADR:333 S Twin Oaks Valley Rd               \LOC:CSU SAN MARCOS.         \APT\SP:          \TB:1128H2\MAP:5524A \XST:DISCOVERY ST/CRAVEN RD                  \TG:. TAC 1 INDIA  \TIMEDSP:01:42:26\UNITS:1414\PREPLN;\TXT:ARTS BUILDING #26,This incident 2012-073404 has been sent to RCIP via the CAD2CAD Interface.,Acknowl\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073443   \TYP:MEDICAL AID           \ADR:333 S Twin Oaks Valley Rd               \LOC:CSUSM - CRAVEN HALL (BLD\APT\SP:RM 3700   \TB:1128H2\MAP:5524A \XST:DISCOVERY ST/CRAVEN RD                  \TG:. TAC 1 INDIA  \TIMEDSP:07:03:10\UNITS:1414,1494\PREPLN;\TXT:[Premise:  333 S TWIN OAKS VALLEY RD] [ ] [UNKNOWN] KNOX: ON WEST SIDE  750-4510,This incident 2012-\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-073956   \TYP:LABOR / BIRTH         \ADR:400 Craven Rd                           \LOC:KAISER PERMANENTE-SMC-40\APT\SP:1ST FL;R  \TB:1128G2\MAP:5523C \XST:RUSH DR/ECHO LN                         \TG:. TAC 1 INDIA  \TIMEDSP:10:58:05\UNITS:1414,1491\PREPLN;\TXT:[Premise:  400 CRAVEN RD] [ ] [UNKNOWN] KNOX LOCATED SE CORNER OF FRONT ENTRANCE BLDG 2.  **FD ENTRA\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-074030   \TYP:UNKNOWN PROBLEM       \ADR:932 Bridgeport Ct                       \LOC:                        \APT\SP:          \TB:1128F3\MAP:5423A \XST:VIA VERA CRUZ/Dead End                  \TG:. TAC 1 INDIA  \TIMEDSP:14:19:50\UNITS:1414,1492\PREPLN;\TXT:This incident 2012-074030 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-074123   \TYP:MEDICAL AID           \ADR:1571 San Elijo Rd                       \LOC:                        \APT\SP:          \TB:1128D7\MAP:5222A \XST:MARKET ST/UNNAMED                       \TG:. TAC 1 INDIA  \TIMEDSP:18:25:30\UNITS:1414,1494\PREPLN;\TXT:This incident 2012-074123 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-074156   \TYP:SNAKE REMOVAL         \ADR:1000 - 1068 Stephanie Ct                \LOC:                        \APT\SP:          \TB:1128E6\MAP:5222C \XST:STEPHANIE ST/Dead End                   \TG:. TAC 1 INDIA  \TIMEDSP:20:05:47\UNITS:1414\PREPLN;\TXT:CELL SITE ADDRESS: 1790 RANCHO SUMMIT DR,This incident 2012-074156 has been sent to RCIP via the CAD\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-076272   \TYP:MEDICAL AID           \ADR:400 Craven Rd                           \LOC:KAISER PERMANENTE-SMC-40\APT\SP:          \TB:1128G2\MAP:5523C \XST:RUSH DR/ECHO LN                         \TG:. TAC 1 INDIA  \TIMEDSP:05:31:56\UNITS:1414,1494\PREPLN;\TXT:[Premise:  400 CRAVEN RD] [ ] [UNKNOWN] KNOX LOCATED SE CORNER OF FRONT ENTRANCE BLDG 2.  **FD ENTRA\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-076842   \TYP:SNAKE REMOVAL         \ADR:727 Leeward Av                          \LOC:                        \APT\SP:          \TB:1128G6\MAP:5223A \XST:HOLLOWBROOK CT/HOLLOWBROOK CT           \TG:. TAC 1 INDIA  \TIMEDSP:12:46:15\UNITS:1414\PREPLN;\TXT:This incident 2012-076842 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-076864   \TYP:CHEST PAIN            \ADR:1530 Glencrest Dr                       \LOC:                        \APT\SP:          \TB:1128D5\MAP:5322A \XST:WINDEMERE DR/LIGHTHOUSE RD              \TG:. TAC 1 INDIA  \TIMEDSP:14:02:25\UNITS:1414,1494\PREPLN;\TXT:This incident 2012-076864 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-077941   \TYP:FLOODING PROB - FD    \ADR:920 Wasatch Pl                          \LOC:                        \APT\SP:          \TB:1109B5\MAP:5725A \XST:RICHLAND RD/Dead End                    \TG:. TAC 1 INDIA  \TIMEDSP:12:28:42\UNITS:1413\PREPLN;\TXT:CELL SITE ADDRESS: 1901 WOODLAND HEIGHTS GLEN,This incident 2012-077941 has been sent to RCIP via th\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-078112   \TYP:STROKE (CVA)          \ADR:1219 E Barham Dr                        \LOC:CASITAS DEL SOL MHP-SMC \APT\SP:SP 75     \TB:1129C1\MAP:5525C \XST:SR78 ON RA EB/UNNAMED                   \TG:. TAC 1 INDIA  \TIMEDSP:18:13:21\UNITS:1413,1491\PREPLN;\TXT:[Premise:  1219 E BARHAM DR] [ ] [UNKNOWN] S.A.M. PG #L27-01,[Address:  1219 E BARHAM DR] [ ] [UNKNO\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-079562   \TYP:FALL - NOT HEIGHT     \ADR:33 06'55.25"n & 117 10'37.89"w          \LOC:                        \APT\SP:          \TB:1128G4\MAP:5423C \XST:                                        \TG:. TAC 1 INDIA  \TIMEDSP:11:39:45\UNITS:1412,1492,1414\PREPLN;\TXT:CELL SITE ADDRESS: 999-B LINDA VISTA DR,ON HIKING TRAIL, NEAR WATER TOWER, PASS REST STOP,This incid\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-079632   \TYP:FIRE ALARM - COMM     \ADR:1 Mission Hills Ct                      \LOC:MISSION HILLS HIGH SCHOO\APT\SP:BLD 900   \TB:1109A7\MAP:5625A \XST:E MISSION RD/UNNAMED                    \TG:. TAC 1 INDIA  \TIMEDSP:14:16:46\UNITS:1413,1414\PREPLN;\TXT:COVERS SMOKE BLDG 900 SECOND***NO RESET,This incident 2012-079632 has been sent to RCIP via the CAD2\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-079679   \TYP:MEDICAL AID           \ADR:1347 Sky Ridge Ct                       \LOC:                        \APT\SP:          \TB:1128E6\MAP:5222C \XST:HIGHBLUFF AV/HIGHBLUFF AV               \TG:. TAC 1 INDIA  \TIMEDSP:16:25:09\UNITS:1414,1494\PREPLN;\TXT:This incident 2012-079679 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM: \MSTR INC#:2012-079772   \TYP:MOVE-UP               \ADR:404 Woodland Py                         \LOC:SMC3.                   \APT\SP:          \TB:1109C7\MAP:5625C \XST:FAIRLANE AV/ROCK SPRINGS RD-SMC CITY    \TG:. TAC 1 INDIA  \TIMEDSP:20:50:56\UNITS:1414\PREPLN;\TXT:[Premise:  404 WOODLAND PY] [ ] [UNKNOWN] SAN MARCOS FIRE STATION 3 AT 404 WOODLAND PKWY IN SAN MARC\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-079818   \TYP:COMMERCIAL FIRE       \ADR:E Mission Rd / Mulberry Dr              \LOC:                        \APT\SP:          \TB:1109A7\MAP:5624C \XST:                                        \TG:. TAC 1 KILO   \TIMEDSP:22:59:37\UNITS:1471,1411,1413,1414,1491,1405,\PREPLN;\TXT:CELL SITE ADDRESS: 550 RANCHEROS DR,This incident 2012-079818 has been sent to RCIP via the CAD2CAD \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-080340   \TYP:MEDICAL ALARM         \ADR:1255 Highbluff Av                       \LOC:                        \APT\SP:          \TB:1128E6\MAP:5222C \XST:Dead End/SKY RIDGE CT                   \TG:. TAC 1 INDIA  \TIMEDSP:13:09:52\UNITS:1414,1494\PREPLN;\TXT:This incident 2012-080340 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-080391   \TYP:SNAKE REMOVAL         \ADR:842 Covington Av                        \LOC:                        \APT\SP:          \TB:1128J3\MAP:5424A \XST:MAHOGANY ST/BALLOW WY                   \TG:. TAC 1 INDIA  \TIMEDSP:15:39:23\UNITS:1471,14R1,1414\PREPLN;\TXT:This incident 2012-080391 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-080450   \TYP:SNAKE REMOVAL         \ADR:1607 Sagewood Wy                        \LOC:                        \APT\SP:          \TB:1128C6\MAP:5222A \XST:CRESCENT PL/RIVER CREST RD              \TG:. TAC 1 INDIA  \TIMEDSP:19:20:53\UNITS:1414\PREPLN;\TXT:This incident 2012-080450 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM: \MSTR INC#:2012-080471   \TYP:MOVE-UP               \ADR:404 Woodland Py                         \LOC:SMC3.                   \APT\SP:          \TB:1109C7\MAP:5625C \XST:FAIRLANE AV/ROCK SPRINGS RD-SMC CITY    \TG:. TAC 1 INDIA  \TIMEDSP:19:44:53\UNITS:1414\PREPLN;\TXT:[Premise:  404 WOODLAND PY] [ ] [UNKNOWN] SAN MARCOS FIRE STATION 3 AT 404 WOODLAND PKWY IN SAN MARC\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-081799   \TYP:TC - TRAF COLLISION   \ADR:Via Vera Cruz / Grand Av                \LOC:                        \APT\SP:          \TB:1108E7\MAP:5622C \XST:                                        \TG:. TAC 1 INDIA  \TIMEDSP:08:29:42\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-081799 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-081886   \TYP:SOB - SHORT OF BREATH \ADR:955 Boardwalk                           \LOC:GHOSH KRIS              \APT\SP:SUITE 100 \TB:1128F1\MAP:5623A \XST:PARK PL/VIA VERA CRUZ                   \TG:. TAC 1 INDIA  \TIMEDSP:12:17:38\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-081886 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-081914   \TYP:SICK PERSON (SPEC DIAG\ADR:331 Richmar Av                          \LOC:EL CID APTS             \APT\SP:APT 7     \TB:1108H7\MAP:5624A \XST:PICO AV/PLEASANT WY                     \TG:. TAC 1 INDIA  \TIMEDSP:13:29:12\UNITS:1411,1494\PREPLN;\TXT:CELL SITE ADDRESS: 201 TRADE,This incident 2012-081914 has been sent to RCIP via the CAD2CAD Interfa\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-081920   \TYP:MEDICAL AID           \ADR:681 Shenandoah Av                       \LOC:                        \APT\SP:          \TB:1128G2\MAP:5523C \XST:LUPINE DR/FOXHALL DR                    \TG:. TAC 1 INDIA  \TIMEDSP:13:59:37\UNITS:1411,1491\PREPLN;\TXT:CELL SITE ADDRESS: 999-B LINDA VISTA DR,This incident 2012-081920 has been sent to RCIP via the CAD2\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-081969   \TYP:MEDICAL AID           \ADR:650 Woodward St                         \LOC:ROYAL OAKS SENIOR APARTM\APT\SP:APT 324   \TB:1108J6\MAP:5724A \XST:WIL-EV DR/ROLLING HILLS LN              \TG:. TAC 1 INDIA  \TIMEDSP:15:54:25\UNITS:1411,1491\PREPLN;\TXT:[Premise:  650 WOODWARD ST] [ ] [UNKNOWN] KNOX AT FRONT ENTRANCE.  SECURITY GATE CAN BE OPENED WITH \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-082028   \TYP:MEDICAL AID           \ADR:288 Rancheros Dr                        \LOC:HOME TOWN BUFFET        \APT\SP:          \TB:1128J1\MAP:5624C \XST:CIVIC CENTER DR/VALPREDA RD             \TG:. TAC 1 INDIA  \TIMEDSP:17:54:11\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-082028 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-082149   \TYP:ASSAULT               \ADR:411 Autumn Dr                           \LOC:                        \APT\SP:          \TB:1108G7\MAP:5623C \XST:CHINABERRY LN/KNOLL RD                  \TG:. TAC 1 INDIA  \TIMEDSP:00:41:53\UNITS:1411,1491\PREPLN;\TXT:CELL SITE ADDRESS: 420 N TWIN OAKS VALLEY RD,This incident 2012-082149 has been sent to RCIP via the\LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-082611   \TYP:STROKE (CVA)          \ADR:1930 W San Marcos Bl                    \LOC:PALOMAR ESTATES MHP - WE\APT\SP:25        \TB:1128B2\MAP:5521C \XST:VIEWPOINT DR/AVNDA CIELO                \TG:. TAC 1 INDIA  \TIMEDSP:09:31:31\UNITS:1411,1491\PREPLN;\TXT:[Premise:  1930 W SAN MARCOS BL] [ ] [UNKNOWN] S.A.M. PG #H27-02,This incident 2012-082611 has been \LOC CMNTS:
(CAD MESSAGE) ALM:1\MSTR INC#:2012-082655   \TYP:MEDICAL AID           \ADR:180 W Mission Rd                        \LOC:SMC1.                   \APT\SP:          \TB:1108H7\MAP:5624A \XST:N TWIN OAKS VALLEY RD/FIREBIRD LN       \TG:. TAC 1 INDIA  \TIMEDSP:11:59:42\UNITS:1411,1491\PREPLN;\TXT:This incident 2012-082655 has been sent to RCIP via the CAD2CAD Interface.,Acknowledgement Received \LOC CMNTS:

 */

public class CASanDiegoCountyParser extends FieldProgramParser {

  public CASanDiegoCountyParser() {
    super("SAN DIEGO COUNTY", "CA",
           "ALM:PRI! MSTR_INC#:ID! TYP:CALL! ADR:ADDR! LOC:PLACE! SP:APT! TB:MAP! MAP:MAP! XST:X! TG:CH! TIMEDSP:TIME! UNITS:UNIT! TXT:INFO LOC_CMNTS:INFO");
  }

  @Override
  public String getFilter() {
    return "cad@jpapage.net,cad@sdrecc.org";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("CAD MESSAGE")) return false;
    return parseFields(body.split("\\\\"), data);
  }

  private static final Pattern APT_TITLE_PTN = Pattern.compile("^(?:APT|SUITE|SPT?|RM) *", Pattern.CASE_INSENSITIVE);

  private class MyAptField extends AptField {
    @Override
    public void parse(String field, Data data) {
      Matcher match = APT_TITLE_PTN.matcher(field);
      if (match.find())
        field = field.substring(match.end());
      super.parse(field, data);
    }
  }

  private class MyMapField extends MapField {
    @Override
    public void parse(String field, Data data) {
      data.strMap = append(data.strMap, "-", field);
    }
  }

  private class MyChannelField extends ChannelField {
    @Override
    public void parse(String field, Data data) {
      if (field.startsWith("."))
        field = field.substring(1).trim();
      super.parse(field, data);
    }
  }
  
  private static final Pattern SKIP_PTN = Pattern.compile("(?:^| *,) *This incident \\d{4}.*$");
  private class MyInfoField extends InfoField {
    @Override
    public void parse(String field, Data data) {
      field = SKIP_PTN.matcher(field).replaceAll("");
      super.parse(field, data);
    }
  }

  @Override
  public Field getField(String name) {
    if (name.equals("APT")) return new MyAptField();
    if (name.equals("MAP")) return new MyMapField();
    if (name.equals("CH")) return new MyChannelField();
    if (name.equals("INFO")) return new MyInfoField();
    return super.getField(name);
  }
}
