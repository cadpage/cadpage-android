package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Wake County, NC

Wake County, NC
Contact: "A.C. Rich" <ac_rich@earthlink.net>  (Chief)
Sender: wcps@wakegov.com
System: Motorola Printrax

[WCPS] Inc: FBD : \nMap: 010Q \nAdd: 2412 MOLLYNICK LN \nLoc:  \nApt:  \nCS:    /   THOMPSON MILL RD \nUnt: SHB263,\nTG: T15\nCty: WCWF \nComm:
[WCPS] Inc: FBD : \nMap: 002X \nAdd: 3229 OLIVE GROVE CHURCH RD \nLoc:  \nApt:  \nCS:  OLD WEAVER TRL   /   \nUnt: SHB399,\nTG: T15\nCty: WCCR
[WCPS] Inc: FWF : \nMap: 039W \nAdd: 6160 JOHNSDALE RD \nLoc:  \nApt:  \nUnt: RFC20,RFAIR1,RFC10,\nTG: \nCty: RA
[WCPS] Inc: FBD : \nMap: 009O \nAdd: 12525 ONEAL RD \nLoc:  \nApt:  \nCS:  MONTHAVEN DR   /   NOLABEE LN \nUnt: SHB263,\nTG: T14\nCty: WCWF 

Contact: "wendelldispatch@yahoo.com" <wendelldispatch@yahoo.com>
Sender: wcps@wakegov.com

(WCPS) Inc: FHEART: \nMap: 066O \nAdd: 6437 FALCONWOOD DR \nLoc:  \nApt:  \nCS:  CARRINGTON WOODS DR   /   MARTIN POND RD \nUnt: WEB114,\nTG: T16\nCty: WCWD \nComm: **CARDIAC**\nPRIMARY UNIT CHANGED TO: FD/WEB114\nR\n
(WCPS) Inc: FGRASS: \nMap: 066I \nAdd: US 64, HWY EB / WENDELL BLVD \nLoc: EXIT 429 WENDELL BLV \nApt:  \nCS: \nUnt: WEB114,\nTG: O1\nCty: WCKD \nComm: **GRASS FIRE**\nORIGINAL LOCATION : EXIT 429 WENDELL BLV\nON RI\n
(WCPS) Inc: F50IC : \nMap: 066D \nAdd: US 64, HWY E / ROLESVILLE RD \nLoc: EXIT 430 WB ROLESVIL \nApt:  \nCS: \nUnt: WEE113,WER110,\nTG: T16\nCty: WCWD \nComm: **ACCIDENT-WITH INJURIES**\n4 VEH ACCIDENT ....JUST EAS\n
(WCPS) Inc: FSEIZ : \nMap: 066D \nAdd: US 64, HWY E / ROLESVILLE RD \nLoc:  \nApt:  \nCS: \nUnt: WEB114,\nTG: T17\nCty: WCWD \nComm: **SEIZURES**\nON THE EB, PASSED THE EXIT, IN THE MEDIAN, PT IS INSIDE A GRY NISSAN

Contact: Active911
Agency name: Bay Leaf Fire Department Location: Raleigh, NC 
Sender: wcps@wakegov.com

 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 09, 2012 4:24 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53A1 : \nMap: 028A\nAdd: 11710 PACESFERRY DR\nLoc:  \nApt:  \nCS:  WOODMANOR DR   /   \nUnt: BLP251,\nTG: O1\nCty: WCRA\nComm: .: EC/MELVIN, THERESA\nREF MOTHER HAS LOCKED HERSELF OUT OF THE HOUSE...2 CHILDREN ARE\nINSIDE...DEPUTY I
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 10, 2012 7:48 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FHEMS : \nMap: 027X\nAdd: 1012 OLD MEETINGHOUSE WAY\nLoc:  \nApt:  \nCS:  WHITE CHAPEL WAY   /   \nUnt: BLP251,\nTG: T13\nCty: WCRA\nComm: **HEMORRHAGE**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 12, 2012 10:48 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1G : \nMap: 027A\nAdd: 1912 PASSMORE CT\nLoc:  \nApt:  \nCS:    /   PARK RIDGE WAY \nUnt: BLP361,BLL25,\nTG: O2\nCty: WCRA\nComm: .: EC/CORBETT, HEATHER R\nPH:919-341-7323.....\nF ALARMS RESIDENTIAL (SINGLE) (GENERAL/FIRE)CALLER
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 12, 2012 11:38 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D11 : \nMap: 045D\nAdd: 2009 JADEWOOD DR\nLoc:  \nApt:  \nCS:  MASON FARM RD   /   ELLENBURG CT \nUnt: MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1,\nTG: \nCty: MV\nComm: .: EC/TESSARI, SHANNON P.\n732-790-5518..WOMAN CALL
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 12, 2012 6:01 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 60C1O : \nMap: 045D\nAdd: 1604 EVERETTE FIELDS RD\nLoc:  \nApt:  \nCS:  MASON FARM RD   /   \nUnt: MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1,\nTG: \nCty: MV\nComm: .: EC/DUVAL, BRIAN\nF GAS LEAK / GAS ODOR (NATURAL AND LP
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 12, 2012 9:06 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 67B3 : \nMap: 027M\nAdd: MT VERNON CHURCH RD / SIX FORKS RD\nLoc:  \nApt:  \nCS: \nUnt: BLP251,BLP258,BLP366,BLP122,BLL25,\nTG: O3\nCty: WCRA\nComm: .: EC/GARRIS, KELLY\nON MT VERNON CHURCH JUST OFF SIX FORKS IN THE DRAINAGE DITCH
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Friday, July 13, 2012 7:53 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 67A1 : \nMap: 027A\nAdd: NORWOOD RD / MT VERNON CHURCH RD\nLoc:  \nApt:  \nCS: \nUnt: BLP251,\nTG: \nCty: WCRA\nComm: .: EC/DUVAL, BRIAN\nF OUTSIDE FIRE TRANSFORMER (WIRE OR POLE)\n\nPU  FD/BLP361\n.: . FFD120713015937 - .  FD/BLP36
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Friday, July 13, 2012 9:52 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 016U\nAdd: 12928 VICTORY CHURCH RD\nLoc:  \nApt:  \nCS:  TERRA COTTA DR   /  KEMP RD \nUnt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/SPINELL, LAUREN\nGRANDER RESD\nF ALARMS RESIDENTIAL
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 15, 2012 11:25 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FHEART: \nMap: 026U\nAdd: I 540, WB / LEESVILLE RD\nLoc: EXIT 7 LEESVILLE RD\nApt:  \nCS: \nUnt: DHP1,BLP361,\nTG: T13\nCty: WCRA\nComm: **CARDIAC**\nTHIRD PARTY CALLER IN A BLUE NISSAN MAXIMA ON 540 BEFORE LEESVILLE RD EXIT\nPANIC
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 15, 2012 5:46 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1C : \nMap: 027E\nAdd: 12044 DEER RUN\nLoc:  \nApt:  \nCS:  COACHMANS WAY   /   MOORFOOTE CT \nUnt: BLP251,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/RYAN, STEPHEN P.\nF ALARMS RESIDENTIAL (SINGLE) (CARBON MONOXIDE)-.:\nMARYBETH--.:
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 16, 2012 6:14 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52C3G : \nMap: 026E\nAdd: 13116 NORWOOD RD\nLoc: BAYLEAF FIRE STA 2\nApt:  \nCS:  CREEDMOOR RD   /   NORWOOD OAKS DR \nUnt: BLP361,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/MEEHAN, TOM\n. : BAYLEAF FIRE STA 2\nF ALARMS COMMERCIAL/INDU
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 17, 2012 5:08 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50I : \nMap: 026S\nAdd: MILE MARKER 9 I540 EB\nLoc: MILE MARKER 9 I540 EB\nApt:  \nCS: \nUnt: DHP1,BLP361,\nTG: T14\nCty: WCRA\nComm: **ACCIDENT-WITH INJURIES**\nMILE MARKER 9.8 EB I 540\nPU  FD/DHP1\n.: . FFD120717016226 - .  FD/
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 18, 2012 3:12 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D10 : \nMap: 003J\nAdd: 1025 EVANS RIDGE RD\nLoc:  \nApt:  \nCS:  NEW LIGHT RD   /   \nUnt:\nSHP392,SHP395,SHP261,SHR26,BLP258,BLP366,BLL25,DHP1,WFE5,CRD,BRASS,FMA1,\nTG: \nCty: WCWF\nComm: .: EC/LAUZON, DAWN\nLIGHTING STRUCK THE R
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 18, 2012 3:33 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50I : \nMap: 026D\nAdd: CREEDMOOR RD / NORWOOD RD\nLoc:  \nApt:  \nCS: \nUnt: BLP361,BLR36,\nTG: T17\nCty: WCRA\nComm: **ACCIDENT-WITH INJURIES**\nSHP IS NOT ON SCENE\nPU  FD/BLP361
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 18, 2012 3:59 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D6O : \nMap: 026J\nAdd: 5529 OVERLEAF CT\nLoc:  \nApt:  \nCS:    /   KINSDALE DR \nUnt: BLP361,BLP366,BLP258,BLL25,DHP1,\nTG: T23\nCty: WCRA\nComm: .: EC/ROBINSON, JACQUELINE\nLIGHT STRUCK HOUSE. SMELL SMOKE\nF STRUCTURE FIRE RESI
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 18, 2012 4:17 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D6 : \nMap: 026W\nAdd: 10312 BAILEYWICK RD\nLoc:  \nApt:  \nCS:  WILDWOOD LINKS   /   STRICKLAND RD \nUnt: DHP1,DHP4,DHP3,DHR5,BLP122,BLP258,BLL25,RFE18,\nTG: T26\nCty: WCRA\nComm: .: EC/CREECH, JESSE\nF STRUCTURE FIRE RESIDENTIAL
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 18, 2012 8:00 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FCHOKE: \nMap: 026T\nAdd: 8809 OLD CREEDMOOR RD\nLoc:  \nApt:  \nCS:  BAILEYWICK RD   /   \nUnt: BLP361,RFE18,\nTG: T16\nCty: WCRA\nComm: **CHOKING**\n10 MOTH OLD BABY\nPU  FD/BLP361\n.: . FFD120718016313 - .  FD/BLP361\nPARENT INC
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 19, 2012 4:18 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FCVA : \nMap: 016R\nAdd: 11637 APPALOOSA RUN W\nLoc:  \nApt:  \nCS:  BLACK HORSE RUN   /   APPALOOSA RUN E \nUnt: BLP361,\nTG: T15\nCty: WCRA\nComm: **CVA**\nPU  FD/BLP361
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 19, 2012 8:10 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FHEART: \nMap: 028K\nAdd: 10805 HONEYCUTT RD\nLoc:  \nApt:  \nCS:  ENDERBURY DR   /   DEER FOREST TRL \nUnt: BLP251,\nTG: T14\nCty: WCRA\nComm: **CARDIAC**\nATRIAL FIB, FEELING FAINT\nPU  FD/BLP251\n.: . FFD120719016414 - .  FD/BLP2
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Friday, July 20, 2012 3:11 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FIPS : \nMap: 026C\nAdd: 11401 OLD CREEDMOOR RD\nLoc:  \nApt:  \nCS:  CHESTOA LN   /   WINTERWOOD DR \nUnt: BLP361,\nTG: T15\nCty: WCRA\nComm: .: EC/BARNARD, STEPHANIE\nPU  FD/BLP361
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Friday, July 20, 2012 5:37 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53O2 : \nMap: 017G\nAdd: SIX FORKS RD / DUXFORD DR\nLoc:  \nApt:  \nCS: \nUnt: BLP251,\nTG: O4\nCty: WCRA\nComm: .: EC/CORBETT, HEATHER R\nF CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER\nSTATEMENT: TREE FELL ON CAR A
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 21, 2012 5:18 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 026K\nAdd: 11701 NORWOOD RD\nLoc:  \nApt:  \nCS:  HALBERD CT   /   OLD HOLIDAY RD \nUnt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/TESSARI, SHANNON P.\nF ALARMS RESIDENTIAL (SINGLE) (SMO
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 21, 2012 5:32 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50MC : \nMap: 027D\nAdd: NORWOOD RD / SIX FORKS RD\nLoc:  \nApt:  \nCS: \nUnt: BLP251,BLR36,\nTG: T14\nCty: WCRA\nComm: **ACCIDENT-MOTORCYCLE**\nMOTORCYCLE VS VAN...EMS REQUESTED\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 21, 2012 7:34 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50I : \nMap: 026U\nAdd: LEESVILLE RD / I 540, EB\nLoc:  \nApt:  \nCS: \nUnt: DHP1,BLP361,\nTG: T13\nCty: WCRA\nComm: **ACCIDENT-WITH INJURIES**\nPARENT INC MEM120721047389 UPDATE RESP TO PARENT INC MEM120721047389 UPDATE\nCMNT * TO
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 21, 2012 10:00 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50I : \nMap: 037E\nAdd: BRENNAN DR / CREEDMOOR RD\nLoc:  \nApt:  \nCS: \nUnt: RFE18,BLP361,\nTG: T14\nCty: RA\nComm: **ACCIDENT VEHICLE/INJURIES**\nBAYLEAF FIRE ONSCENE ADVISING PI\nPU  RF/RFE18
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 22, 2012 3:30 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FAR : \nMap: 027O\nAdd: 10912 CAHILL RD\nLoc:  \nApt:  \nCS:  NORTHCHESTER WAY   /   BRASSFIELD RD \nUnt: BLP251,\nTG: T16\nCty: WCRA\nComm: **ALLERGIC REACTION**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 23, 2012 3:52 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D6 : \nMap: 028I\nAdd: 11805 FALLS OF NEUSE RD\nLoc:  \nApt:  \nCS:  LAKE VILLA WAY   /   WATERWOOD CT \nUnt: BLP258,SHP261,WFE5,WFE2,WFE3,WFS5,WFBAT1,\nTG: T17\nCty: RA\nComm: .: EC/DAVIS, AMANDA\nF STRUCTURE FIRE RESIDENTIAL (SI
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 23, 2012 6:39 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 69D3 : \nMap: 045E\nAdd: 1900 CARRINGTON PARK CIR\nLoc:  \nApt:  \nCS: STONE VIEW CRSG\nUnt: MFE2,MFE1,MFC3,MFC1,BLL25,DHR5,DURHCTY,CARYFD,FMA1,\nTG: \nCty: MV\nComm: .: EC/WELLS, JENINE\nPU  FD/MFE2\n.: . FFD120723016729 - .  FD/MF
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 23, 2012 6:46 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53O2 : \nMap: 016R\nAdd: OLD CREEDMOOR RD / APPALOOSA RUN W\nLoc:  \nApt:  \nCS: \nUnt: BLP361,\nTG: O1\nCty: WCRA\nComm: .: EC/SUZIK, MICHAEL\nF CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER\nSTATEMENT: TREE ACROSS R
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 23, 2012 10:13 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53A5 : \nMap: 026T\nAdd: I 540, EB / CREEDMOOR RD\nLoc: EXIT 9 CREEDMOOR RD\nApt:  \nCS: \nUnt: DHP1,BLP361,\nTG: O1\nCty: WCRA\nComm: .: EC/SHEAR, KRIS\n. : EXIT 9 CREEDMOOR RD\n5 CARS FOR FLUID ON THE ROAD ..\nPU  FD/DHP1\n.: . F
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Monday, July 23, 2012 10:29 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50IC : \nMap: 026U\nAdd: I 540, EB / LEESVILLE RD\nLoc:  \nApt:  \nCS: \nUnt: DHP4,BLP366,\nTG: T16\nCty: WCRA\nComm: **ACCIDENT-WITH INJURIES**\nJUST WEST OF THE EXIT - UNKNOWN PT AGE - PT IS WALKING AROUND BUT\nCOMPLAINING OF LEG
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 24, 2012 1:56 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FSEIZ : \nMap: 017T\nAdd: 12709 ALPERN CT\nLoc:  \nApt:  \nCS:  TUTMAN CT   /   \nUnt: BLP251,\nTG: T13\nCty: WCRA\nComm: **SEIZURES**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 24, 2012 3:56 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53A5 : \nMap: 026D\nAdd: NORWOOD RD / OLD CREEDMOOR RD\nLoc:  \nApt:  \nCS: \nUnt: BLP361,\nTG: O11\nCty: WCRA\nComm: .: EC/HECKLER, ROBERT\nF CITIZEN ASSIST / SERVICE CALL SERVICE CALLCALLER STATEMENT: TREE DOWN IN\nROADWAY-.: TREE
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 25, 2012 5:09 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 025J\nAdd: 5012 BARTONS ENCLAVE LN\nLoc:  \nApt:  \nCS:  AMORETTO WAY   /   INDIGO MOON WAY \nUnt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,WFL1,\nTG: O1\nCty: WCRA\nComm: .: EC/CORBETT, HEATHER R\nF ALARMS RESIDENTIAL (SING
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 25, 2012 4:36 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FTEST : \nMap: 027D\nAdd: 11713 SIX FORKS RD\nLoc: BAYLEAF FIRE STA 1\nApt:  \nCS:  NORWOOD RD   /   POSSUM TRACK RD \nUnt: BLP251,\nTG: \nCty: WCRA\nComm: **TEST CALL**\n. : BAYLEAF FIRE STA 1\nPU  FD/BLP251,\n.: . FFD120725016990
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, July 25, 2012 7:00 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 72D6 : \nMap: 003W\nAdd: NEW LIGHT RD / GHOSTON RD\nLoc: FALLS LAKE\nApt:  \nCS: \nUnt: BLP251,\nTG: \nCty: WCWF\nComm: .: EC/DACOSTA, JOANNA\n. : FALLS LAKE\nON THE LAKE, SWIMMER STRUGGLING, 50 BOAT L9OFT F WATER RESCUE INLAND\nWA0000103TER RESCUE\n\nPU  FD/SHP392\n.: . FFD120725017003 - .  FD/SHP392\n. MEM120725048308 UPDATE RESP TO\n. MEM120725048308 UPDATE CMNT * TO 01\n. MEM120725048308 UPDATE PRIUNT TO EM/EMS12 UNIT FD/SHP392 MILEAGE ENTERED\nODO: 0000.0 ADV SHE IS O
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 26, 2012 1:44 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FHEART: \nMap: 027X\nAdd: 1012 OLD MEETINGHOUSE WAY\nLoc:  \nApt:  \nCS:  WHITE CHAPEL WAY   /   \nUnt: BLP251,\nTG: T14\nCty: WCRA\nComm: **CARDIAC**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Thursday, July 26, 2012 10:35 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FUNCON: \nMap: 027H\nAdd: 213 TROTTERS RIDGE DR\nLoc:  \nApt:  \nCS:  PACER CT   /   BRIDLE LN \nUnt: BLP251,\nTG: T21\nCty: WCRA\nComm: **UNCONSCIOUS**\nPARENT INC MEM120726048444 UPDATE RESP TO PARENT INC MEM120726048444 UPDATE\nC
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 28, 2012 12:25 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FBD : \nMap: 003L\nAdd: 13900 CREEDMOOR RD\nLoc: FALLS LAKE NC HWY 50 BOAT RAMP\nApt:  \nCS:  GRANITE HILL TRL   /   EASY HORSE TRL \nUnt: BLP361,\nTG: T20\nCty: WCWF\nComm: **BREATHING DIFFICULTY**\nBAYLEAF 203 ONSCENE.. TAC 20\nP
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 28, 2012 7:45 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 027D\nAdd: 209 CARRIAGE TRL\nLoc:  \nApt:  \nCS:  DUNSTABLE CT   /   COACHMANS WAY \nUnt: BLP251,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/SLOHN, NEAL\nF ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)-.:\nBOLLIBGER--.: KIT
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 28, 2012 8:03 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FAR : \nMap: 037J\nAdd: 2713 FARNBOROUGH RD\nLoc:  \nApt:  \nCS: HOWARD RD\nUnt: BLP121,RFE18,\nTG: T14\nCty: WCRA\nComm: **ALLERGIC REACTION**\nDAUGHTER STUNG BY SOMETHING ON FOOT\nPARENT INC MEM120728049056 UPDATE RESP TO PARENT
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 28, 2012 9:12 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53O2 : \nMap: 016W\nAdd: BLACK HORSE RUN / MAN O WAR TRL\nLoc:  \nApt:  \nCS: \nUnt: BLP361,\nTG: O3\nCty: WCRA\nComm: .: EC/COOKE, WILLIAM J\nF CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTS\n\nPU  FD/BLP361\n.: . FFD120728
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Saturday, July 28, 2012 11:12 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FHEART: \nMap: 027C\nAdd: 1001 MOLLINGTON CT\nLoc:  \nApt:  \nCS:  BRASS KETTLE RD   /   \nUnt: BLP251,\nTG: T15\nCty: WCRA\nComm: **CARDIAC**\nREQ NO SIRENS\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 29, 2012 5:58 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53O2 : \nMap: 026T\nAdd: OLD CREEDMOOR RD / BEECHNUT TRL\nLoc:  \nApt:  \nCS: \nUnt: BLP361,RFE18,\nTG: O1\nCty: WCRA\nComm: .: EC/BANNING, LINDSAY\nBETWEEN BEECHNUT AND NORWOOD BEFORE ENTRANCE TO OLD CREEDMOOR SUBDIVISION F\nCITIZ
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 29, 2012 5:33 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FBD : \nMap: 026Y\nAdd: 2416 BEECHVIEW CT\nLoc:  \nApt:  \nCS:  KINGS MILL PL   /   STAGE FORD RD \nUnt: BLP361,RFE18,\nTG: T15\nCty: WCRA\nComm: **BREATHING DIFFICULTY**\nPU  FD/BLP361
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Sunday, July 29, 2012 6:06 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 53A2 : \nMap: 037I\nAdd: 8809 SLEEPY CREEK DR\nLoc:  \nApt:  \nCS:  WELLSLEY WAY   /   \nUnt: BLP121,RFE18,\nTG: T13\nCty: WCRA\nComm: .: EC/SANDERS, ALAN\nEMS6 ONSCENE REQUIRING LIFT ASSISTANCE.. ROUTINE RESPONSE.. TAC 13 PU  FD/B
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 1:54 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FDIAB : \nMap: 017G\nAdd: 13036 SIX FORKS RD\nLoc:  \nApt:  \nCS:  IMAGE PT   /   DUXFORD DR \nUnt: BLP251,\nTG: T14\nCty: WCRA\nComm: **DIABETIC PROBLEM**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 9:01 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 027J\nAdd: 5528 PEAKTON DR\nLoc:  \nApt:  \nCS:    /   HONEYCUTT RD \nUnt: BLP251,BLL25,\nTG: O2\nCty: WCRA\nComm: .: EC/DAVIS, AMANDA\nF ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEMENT: FIRE\nALM-.: HORT
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 10:54 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FCVA : \nMap: 017X\nAdd: 12109 DEER RUN\nLoc:  \nApt:  \nCS:  MOORFOOTE CT   /   HONEYCUTT RD \nUnt: BLP251,\nTG: T16\nCty: WCRA\nComm: **CVA**\nPU  FD/BLP251
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 11:09 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FSEIZ : \nMap: 027J\nAdd: 2001 BRASSFIELD RD\nLoc: BRASSFIELD ELEMENTARY\nApt:  \nCS:  SARANT OAKS CT   /   HONEYCUTT RD \nUnt: BLB259,\nTG: T19\nCty: WCRA\nComm: **SEIZURES**\nPT IN RM 118\nPU  FD/BLB259\n.: . FFD120731017506 - .
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 4:12 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: FIPS : \nMap: 027K\nAdd: 900 CARRINGTON DR\nLoc: STONEBRIDGE SWIMMING\nApt:  \nCS:  WHITESTONE RD   /   COUNTRYWOOD NORTH RD \nUnt: BLC360,\nTG: T19\nCty: WCRA\nComm: .: EC/MCDOW, J.\n\nPU  FD/BLC360\n.: . FFD120731017523 - .  FD/B
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Tuesday, July 31, 2012 8:23 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 67B1 : \nMap: 027B\nAdd: 14201 NORWOOD RD\nLoc:  \nApt:  \nCS:  CAVANAUGH DR   /   RAVEN ROCK DR \nUnt: BLB259,\nTG: O2\nCty: WCRA\nComm: .: EC/ANDERSON, KEVIN\nF OUTSIDE FIRE SMALL OUTSIDE FIRECALLER STATEMENT: BRANCH ON A LINE
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, August 01, 2012 7:32 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 52B1S : \nMap: 027M\nAdd: 10325 SIX FORKS RD\nLoc:  \nApt:  \nCS:  JANSMITH LN   /   WYNDFIELD CIR \nUnt: BLP251,BLL25,\nTG: O1\nCty: WCRA\nComm: .: EC/RATTELADE, JESSICA\nF ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEME
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, August 01, 2012 11:35 AM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: F50I : \nMap: 027W\nAdd: I 540, EB / SIX FORKS RD\nLoc: EXIT 11 SIX FORKS RD\nApt:  \nCS: \nUnt: BLP122,WFE5,\nTG: T20\nCty: WCRA\nComm: **ACCIDENT-WITH INJURIES**\nWHITE 4DR SEDAN\nPU  FD/BLP122\n.: . FFD120801017590 - .  FD/BLP12
 \n\n-----Original Message-----\nFrom: wcps@wakegov.com [mailto:wcps@wakegov.com] \nSent: Wednesday, August 01, 2012 6:11 PM\nTo: pageserver@earthlink.net\nSubject: WCPS\n\nInc: 63B1 : \nMap: 017A\nAdd: 1116 TACKETTS POND DR\nLoc:  \nApt:  \nCS:  QUIET RIDGE CIR   /   SUNSET GLEN PT \nUnt: BLR36,\nTG: \nCty: WCRA\nComm: .: EC/MARTIN, DAVID\nF LIGHTNING STRIKE (INVESTIGATION) RESIDENTIAL (SINGLE)CALLER\nSTATE0000203MENT:\nHOUSE HIT BY LIGHTENING\n\nDUPCALL: WCRA\nCNAME: AT / T MOBILITY CPH: 9196964952\nCADDR: 12205 CREEDMOOR RD\nTYPE: CONTACT COMP: FAS: N SS:\nPRI: SRC: 1 MC: DISPO:\nPU  FD/SHP261\n.: . FFD120801017624 - .  FD/SHP261\nDISPO NON-PRIMAR

*/
public class NCWakeCountyParserTest extends BaseParserTest {
  
  public NCWakeCountyParserTest() {
    setParser(new NCWakeCountyParser(), "WAKE COUNTY", "NC");
  }
  
  @Test
  public void testACRich() {

    doTest("T1",
        "[WCPS] Inc: FBD : \n" +
        "Map: 010Q \n" +
        "Add: 2412 MOLLYNICK LN \n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:    /   THOMPSON MILL RD \n" +
        "Unt: SHB263,\n" +
        "TG: T15\n" +
        "Cty: WCWF \n" +
        "Comm:",

        "CODE:FBD",
        "CALL:RESPIRATORY DISTRESS",
        "MAP:010Q",
        "ADDR:2412 MOLLYNICK LN",
        "X:THOMPSON MILL RD",
        "UNIT:SHB263",
        "CH:T15",
        "CITY:WAKE FOREST");

    doTest("T2",
        "[WCPS] Inc: FBD : \n" +
        "Map: 002X \n" +
        "Add: 3229 OLIVE GROVE CHURCH RD \n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  OLD WEAVER TRL   /   \n" +
        "Unt: SHB399,\n" +
        "TG: T15\n" +
        "Cty: WCCR",

        "CODE:FBD",
        "CALL:RESPIRATORY DISTRESS",
        "MAP:002X",
        "ADDR:3229 OLIVE GROVE CHURCH RD",
        "X:OLD WEAVER TRL",
        "UNIT:SHB399",
        "CH:T15",
        "CITY:CREEDMOOR");

    doTest("T3",
        "[WCPS] Inc: FWF : \nMap: 039W \nAdd: 6160 JOHNSDALE RD \nLoc:  \nApt:  \nUnt: RFC20,RFAIR1,RFC10,\nTG: \nCty: RA",
        "CODE:FWF",
        "CALL:WORKING FIRE",
        "MAP:039W",
        "ADDR:6160 JOHNSDALE RD",
        "UNIT:RFC20,RFAIR1,RFC10",
        "CITY:RALEIGH");

    doTest("T4",
        "[WCPS] Inc: FBD : \n" +
        "Map: 009O \n" +
        "Add: 12525 ONEAL RD \n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  MONTHAVEN DR   /   NOLABEE LN \n" +
        "Unt: SHB263,\n" +
        "TG: T14\n" +
        "Cty: WCWF ",

        "CODE:FBD",
        "CALL:RESPIRATORY DISTRESS",
        "MAP:009O",
        "ADDR:12525 ONEAL RD",
        "X:MONTHAVEN DR / NOLABEE LN",
        "UNIT:SHB263",
        "CH:T14",
        "CITY:WAKE FOREST");

  }
  
  @Test
  public void testWendellDispatch() {
 

    doTest("T1",
        "(WCPS) Inc: FHEART: \n" +
        "Map: 066O \n" +
        "Add: 6437 FALCONWOOD DR \n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  CARRINGTON WOODS DR   /   MARTIN POND RD \n" +
        "Unt: WEB114,\n" +
        "TG: T16\n" +
        "Cty: WCWD \n" +
        "Comm: **CARDIAC**\n" +
        "PRIMARY UNIT CHANGED TO: FD/WEB114\n" +
        "R\n",

        "CODE:FHEART",
        "CALL:CARDIAC",
        "MAP:066O",
        "ADDR:6437 FALCONWOOD DR",
        "X:CARRINGTON WOODS DR / MARTIN POND RD",
        "UNIT:WEB114",
        "CH:T16",
        "CITY:WENDELL",
        "INFO:**CARDIAC** / PRIMARY UNIT CHANGED TO: FD/WEB114 / R");

    doTest("T2",
        "(WCPS) Inc: FGRASS: \n" +
        "Map: 066I \n" +
        "Add: US 64, HWY EB / WENDELL BLVD \n" +
        "Loc: EXIT 429 WENDELL BLV \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: WEB114,\n" +
        "TG: O1\n" +
        "Cty: WCKD \n" +
        "Comm: **GRASS FIRE**\n" +
        "ORIGINAL LOCATION : EXIT 429 WENDELL BLV\n" +
        "ON RI\n",

        "CALL:FGRASS",
        "MAP:066I",
        "ADDR:US 64 HWY EB & WENDELL BLVD",   // I don't understand this
        "MADDR:US 64 & WENDELL BLVD",
        "PLACE:EXIT 429 WENDELL BLV",
        "UNIT:WEB114",
        "CH:O1",
        "CITY:KNIGHTDALE",
        "INFO:**GRASS FIRE** / ORIGINAL LOCATION : EXIT 429 WENDELL BLV / ON RI");

    doTest("T3",
        "(WCPS) Inc: F50IC : \n" +
        "Map: 066D \n" +
        "Add: US 64, HWY E / ROLESVILLE RD \n" +
        "Loc: EXIT 430 WB ROLESVIL \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: WEE113,WER110,\n" +
        "TG: T16\n" +
        "Cty: WCWD \n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "4 VEH ACCIDENT ....JUST EAS\n",

        "CODE:F50IC",
        "CALL:10-50/INJURIES COUNTY ONLY",
        "MAP:066D",
        "ADDR:US 64 HWY E & ROLESVILLE RD",
        "MADDR:US 64 E & ROLESVILLE RD",
        "PLACE:EXIT 430 WB ROLESVIL",
        "UNIT:WEE113,WER110",
        "CH:T16",
        "CITY:WENDELL",
        "INFO:**ACCIDENT-WITH INJURIES** / 4 VEH ACCIDENT ....JUST EAS");

    doTest("T4",
        "(WCPS) Inc: FSEIZ : \n" +
        "Map: 066D \n" +
        "Add: US 64, HWY E / ROLESVILLE RD \n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: WEB114,\n" +
        "TG: T17\n" +
        "Cty: WCWD \n" +
        "Comm: **SEIZURES**\n" +
        "ON THE EB, PASSED THE EXIT, IN THE MEDIAN, PT IS INSIDE A GRY NISSAN",

        "CODE:FSEIZ",
        "CALL:SEIZURE",
        "MAP:066D",
        "ADDR:US 64 HWY E & ROLESVILLE RD",
        "MADDR:US 64 E & ROLESVILLE RD",
        "UNIT:WEB114",
        "CH:T17",
        "CITY:WENDELL",
        "INFO:**SEIZURES** / ON THE EB, PASSED THE EXIT, IN THE MEDIAN, PT IS INSIDE A GRY NISSAN");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 09, 2012 4:24 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53A1 : \n" +
        "Map: 028A\n" +
        "Add: 11710 PACESFERRY DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  WOODMANOR DR   /   \n" +
        "Unt: BLP251,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/MELVIN, THERESA\n" +
        "REF MOTHER HAS LOCKED HERSELF OUT OF THE HOUSE...2 CHILDREN ARE\n" +
        "INSIDE...DEPUTY I",

        "CODE:53A1",
        "CALL:Citizen assist/service call - Locked in/out of building (non-medical assistance)",
        "MAP:028A",
        "ADDR:11710 PACESFERRY DR",
        "X:WOODMANOR DR",
        "UNIT:BLP251",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/MELVIN, THERESA / REF MOTHER HAS LOCKED HERSELF OUT OF THE HOUSE...2 CHILDREN ARE / INSIDE...DEPUTY I");

    doTest("T2",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 10, 2012 7:48 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FHEMS : \n" +
        "Map: 027X\n" +
        "Add: 1012 OLD MEETINGHOUSE WAY\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  WHITE CHAPEL WAY   /   \n" +
        "Unt: BLP251,\n" +
        "TG: T13\n" +
        "Cty: WCRA\n" +
        "Comm: **HEMORRHAGE**\n" +
        "PU  FD/BLP251",

        "CODE:FHEMS",
        "CALL:HEMORRHAGE SERIOUS",
        "MAP:027X",
        "ADDR:1012 OLD MEETINGHOUSE WAY",
        "X:WHITE CHAPEL WAY",
        "UNIT:BLP251",
        "CH:T13",
        "CITY:WAKE COUNTY",
        "INFO:**HEMORRHAGE** / PU  FD/BLP251");

    doTest("T3",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 12, 2012 10:48 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1G : \n" +
        "Map: 027A\n" +
        "Add: 1912 PASSMORE CT\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:    /   PARK RIDGE WAY \n" +
        "Unt: BLP361,BLL25,\n" +
        "TG: O2\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/CORBETT, HEATHER R\n" +
        "PH:919-341-7323.....\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (GENERAL/FIRE)CALLER",

        "CODE:52B1G",
        "CALL:Alarms - Residential    - General/Fire",
        "MAP:027A",
        "ADDR:1912 PASSMORE CT",
        "X:PARK RIDGE WAY",
        "UNIT:BLP361,BLL25",
        "CH:O2",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/CORBETT, HEATHER R / PH:919-341-7323..... / F ALARMS RESIDENTIAL (SINGLE) (GENERAL/FIRE)CALLER");

    doTest("T4",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 12, 2012 11:38 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D11 : \n" +
        "Map: 045D\n" +
        "Add: 2009 JADEWOOD DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  MASON FARM RD   /   ELLENBURG CT \n" +
        "Unt: MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1,\n" +
        "TG: \n" +
        "Cty: MV\n" +
        "Comm: .: EC/TESSARI, SHANNON P.\n" +
        "732-790-5518..WOMAN CALL",

        "CODE:69D11",
        "CALL:Structure Fire - Unknown situation",
        "MAP:045D",
        "ADDR:2009 JADEWOOD DR",
        "X:MASON FARM RD / ELLENBURG CT",
        "UNIT:MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1",
        "CITY:MORRISVILLE",
        "INFO:.: EC/TESSARI, SHANNON P. / 732-790-5518..WOMAN CALL");

    doTest("T5",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 12, 2012 6:01 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 60C1O : \n" +
        "Map: 045D\n" +
        "Add: 1604 EVERETTE FIELDS RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  MASON FARM RD   /   \n" +
        "Unt: MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1,\n" +
        "TG: \n" +
        "Cty: MV\n" +
        "Comm: .: EC/DUVAL, BRIAN\n" +
        "F GAS LEAK / GAS ODOR (NATURAL AND LP",

        "CODE:60C1O",
        "CALL:Gas leak/Gas odor - Residential (single) - Odor only",
        "MAP:045D",
        "ADDR:1604 EVERETTE FIELDS RD",
        "X:MASON FARM RD",
        "UNIT:MFE2,MFE1,MFC3,MFC1,BLL25,WWR295,DURHCTY,CARYFD,FMA1",
        "CITY:MORRISVILLE",
        "INFO:.: EC/DUVAL, BRIAN / F GAS LEAK / GAS ODOR (NATURAL AND LP");

    doTest("T6",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 12, 2012 9:06 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 67B3 : \n" +
        "Map: 027M\n" +
        "Add: MT VERNON CHURCH RD / SIX FORKS RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP251,BLP258,BLP366,BLP122,BLL25,\n" +
        "TG: O3\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/GARRIS, KELLY\n" +
        "ON MT VERNON CHURCH JUST OFF SIX FORKS IN THE DRAINAGE DITCH",

        "CODE:67B3",
        "CALL:Outside Fire - Unknown situation",
        "MAP:027M",
        "ADDR:MT VERNON CHURCH RD & SIX FORKS RD",
        "UNIT:BLP251,BLP258,BLP366,BLP122,BLL25",
        "CH:O3",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/GARRIS, KELLY / ON MT VERNON CHURCH JUST OFF SIX FORKS IN THE DRAINAGE DITCH");

    doTest("T7",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Friday, July 13, 2012 7:53 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 67A1 : \n" +
        "Map: 027A\n" +
        "Add: NORWOOD RD / MT VERNON CHURCH RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP251,\n" +
        "TG: \n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/DUVAL, BRIAN\n" +
        "F OUTSIDE FIRE TRANSFORMER (WIRE OR POLE)\n\n" +
        "PU  FD/BLP361\n" +
        ".: . FFD120713015937 - .  FD/BLP36",

        "CODE:67A1",
        "CALL:Outside Fire - Transformer",
        "MAP:027A",
        "ADDR:NORWOOD RD & MT VERNON CHURCH RD",
        "UNIT:BLP251",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/DUVAL, BRIAN / F OUTSIDE FIRE TRANSFORMER (WIRE OR POLE) / PU  FD/BLP361 / .: . FFD120713015937 - .  FD/BLP36");

    doTest("T8",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Friday, July 13, 2012 9:52 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 016U\n" +
        "Add: 12928 VICTORY CHURCH RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  TERRA COTTA DR   /  KEMP RD \n" +
        "Unt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/SPINELL, LAUREN\n" +
        "GRANDER RESD\n" +
        "F ALARMS RESIDENTIAL",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:016U",
        "ADDR:12928 VICTORY CHURCH RD",
        "X:TERRA COTTA DR / KEMP RD",
        "UNIT:DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/SPINELL, LAUREN / GRANDER RESD / F ALARMS RESIDENTIAL");

    doTest("T9",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 15, 2012 11:25 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FHEART: \n" +
        "Map: 026U\n" +
        "Add: I 540, WB / LEESVILLE RD\n" +
        "Loc: EXIT 7 LEESVILLE RD\n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: DHP1,BLP361,\n" +
        "TG: T13\n" +
        "Cty: WCRA\n" +
        "Comm: **CARDIAC**\n" +
        "THIRD PARTY CALLER IN A BLUE NISSAN MAXIMA ON 540 BEFORE LEESVILLE RD EXIT\n" +
        "PANIC",

        "CODE:FHEART",
        "CALL:CARDIAC",
        "MAP:026U",
        "ADDR:I 540 WB & LEESVILLE RD",
        "MADDR:I 540 & LEESVILLE RD",
        "PLACE:EXIT 7 LEESVILLE RD",
        "UNIT:DHP1,BLP361",
        "CH:T13",
        "CITY:WAKE COUNTY",
        "INFO:**CARDIAC** / THIRD PARTY CALLER IN A BLUE NISSAN MAXIMA ON 540 BEFORE LEESVILLE RD EXIT / PANIC");

    doTest("T10",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 15, 2012 5:46 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1C : \n" +
        "Map: 027E\n" +
        "Add: 12044 DEER RUN\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  COACHMANS WAY   /   MOORFOOTE CT \n" +
        "Unt: BLP251,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/RYAN, STEPHEN P.\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (CARBON MONOXIDE)-.:\n" +
        "MARYBETH--.:",

        "CODE:52B1C",
        "CALL:Alarms - Residential    - Carbon Monoxide",
        "MAP:027E",
        "ADDR:12044 DEER RUN",
        "X:COACHMANS WAY / MOORFOOTE CT",
        "UNIT:BLP251,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/RYAN, STEPHEN P. / F ALARMS RESIDENTIAL (SINGLE) (CARBON MONOXIDE)-.: / MARYBETH--.:");

    doTest("T11",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 16, 2012 6:14 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52C3G : \n" +
        "Map: 026E\n" +
        "Add: 13116 NORWOOD RD\n" +
        "Loc: BAYLEAF FIRE STA 2\n" +
        "Apt:  \n" +
        "CS:  CREEDMOOR RD   /   NORWOOD OAKS DR \n" +
        "Unt: BLP361,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/MEEHAN, TOM\n" +
        ". : BAYLEAF FIRE STA 2\n" +
        "F ALARMS COMMERCIAL/INDU",

        "CODE:52C3G",
        "CALL:Alarms - Commercial/industrial building - General/Fire",
        "MAP:026E",
        "ADDR:13116 NORWOOD RD",
        "PLACE:BAYLEAF FIRE STA 2",
        "X:CREEDMOOR RD / NORWOOD OAKS DR",
        "UNIT:BLP361,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/MEEHAN, TOM / . : BAYLEAF FIRE STA 2 / F ALARMS COMMERCIAL/INDU");

    doTest("T12",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 17, 2012 5:08 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50I : \n" +
        "Map: 026S\n" +
        "Add: MILE MARKER 9 I540 EB\n" +
        "Loc: MILE MARKER 9 I540 EB\n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: DHP1,BLP361,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "MILE MARKER 9.8 EB I 540\n" +
        "PU  FD/DHP1\n" +
        ".: . FFD120717016226 - .  FD/",

        "CODE:F50I",
        "CALL:10-50/INJURIES",
        "MAP:026S",
        "ADDR:MILE MARKER 9 I540 EB",
        "MADDR:MILE MARKER 9 I 540",
        "PLACE:MILE MARKER 9 I540 EB",
        "UNIT:DHP1,BLP361",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-WITH INJURIES** / MILE MARKER 9.8 EB I 540 / PU  FD/DHP1 / .: . FFD120717016226 - .  FD/");

    doTest("T13",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 18, 2012 3:12 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D10 : \n" +
        "Map: 003J\n" +
        "Add: 1025 EVANS RIDGE RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  NEW LIGHT RD   /   \n" +
        "Unt:\n" +
        "SHP392,SHP395,SHP261,SHR26,BLP258,BLP366,BLL25,DHP1,WFE5,CRD,BRASS,FMA1,\n" +
        "TG: \n" +
        "Cty: WCWF\n" +
        "Comm: .: EC/LAUZON, DAWN\n" +
        "LIGHTING STRUCK THE R",

        "CODE:69D10",
        "CALL:Structure Fire - Mobile home, house trailer, portable office",
        "MAP:003J",
        "ADDR:1025 EVANS RIDGE RD",
        "X:NEW LIGHT RD",
        "CITY:WAKE FOREST",
        "INFO:.: EC/LAUZON, DAWN / LIGHTING STRUCK THE R");

    doTest("T14",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 18, 2012 3:33 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50I : \n" +
        "Map: 026D\n" +
        "Add: CREEDMOOR RD / NORWOOD RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP361,BLR36,\n" +
        "TG: T17\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "SHP IS NOT ON SCENE\n" +
        "PU  FD/BLP361",

        "CODE:F50I",
        "CALL:10-50/INJURIES",
        "MAP:026D",
        "ADDR:CREEDMOOR RD & NORWOOD RD",
        "UNIT:BLP361,BLR36",
        "CH:T17",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-WITH INJURIES** / SHP IS NOT ON SCENE / PU  FD/BLP361");

    doTest("T15",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 18, 2012 3:59 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D6O : \n" +
        "Map: 026J\n" +
        "Add: 5529 OVERLEAF CT\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:    /   KINSDALE DR \n" +
        "Unt: BLP361,BLP366,BLP258,BLL25,DHP1,\n" +
        "TG: T23\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/ROBINSON, JACQUELINE\n" +
        "LIGHT STRUCK HOUSE. SMELL SMOKE\n" +
        "F STRUCTURE FIRE RESI",

        "CODE:69D6O",
        "CALL:Structure Fire - Residential (single) - Odor of smoke",
        "MAP:026J",
        "ADDR:5529 OVERLEAF CT",
        "X:KINSDALE DR",
        "UNIT:BLP361,BLP366,BLP258,BLL25,DHP1",
        "CH:T23",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/ROBINSON, JACQUELINE / LIGHT STRUCK HOUSE. SMELL SMOKE / F STRUCTURE FIRE RESI");

    doTest("T16",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 18, 2012 4:17 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D6 : \n" +
        "Map: 026W\n" +
        "Add: 10312 BAILEYWICK RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  WILDWOOD LINKS   /   STRICKLAND RD \n" +
        "Unt: DHP1,DHP4,DHP3,DHR5,BLP122,BLP258,BLL25,RFE18,\n" +
        "TG: T26\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/CREECH, JESSE\n" +
        "F STRUCTURE FIRE RESIDENTIAL",

        "CODE:69D6",
        "CALL:Structure Fire - Residential (single)",
        "MAP:026W",
        "ADDR:10312 BAILEYWICK RD",
        "X:WILDWOOD LINKS / STRICKLAND RD",
        "UNIT:DHP1,DHP4,DHP3,DHR5,BLP122,BLP258,BLL25,RFE18",
        "CH:T26",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/CREECH, JESSE / F STRUCTURE FIRE RESIDENTIAL");

    doTest("T17",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 18, 2012 8:00 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FCHOKE: \n" +
        "Map: 026T\n" +
        "Add: 8809 OLD CREEDMOOR RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  BAILEYWICK RD   /   \n" +
        "Unt: BLP361,RFE18,\n" +
        "TG: T16\n" +
        "Cty: WCRA\n" +
        "Comm: **CHOKING**\n" +
        "10 MOTH OLD BABY\n" +
        "PU  FD/BLP361\n" +
        ".: . FFD120718016313 - .  FD/BLP361\n" +
        "PARENT INC",

        "CODE:FCHOKE",
        "CALL:SUBJECT CHOKING",
        "MAP:026T",
        "ADDR:8809 OLD CREEDMOOR RD",
        "X:BAILEYWICK RD",
        "UNIT:BLP361,RFE18",
        "CH:T16",
        "CITY:WAKE COUNTY",
        "INFO:**CHOKING** / 10 MOTH OLD BABY / PU  FD/BLP361 / .: . FFD120718016313 - .  FD/BLP361 / PARENT INC");

    doTest("T18",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 19, 2012 4:18 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FCVA : \n" +
        "Map: 016R\n" +
        "Add: 11637 APPALOOSA RUN W\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  BLACK HORSE RUN   /   APPALOOSA RUN E \n" +
        "Unt: BLP361,\n" +
        "TG: T15\n" +
        "Cty: WCRA\n" +
        "Comm: **CVA**\n" +
        "PU  FD/BLP361",

        "CODE:FCVA",
        "CALL:CVA/STROKE",
        "MAP:016R",
        "ADDR:11637 APPALOOSA RUN W",
        "X:BLACK HORSE RUN / APPALOOSA RUN E",
        "UNIT:BLP361",
        "CH:T15",
        "CITY:WAKE COUNTY",
        "INFO:**CVA** / PU  FD/BLP361");

    doTest("T19",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 19, 2012 8:10 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FHEART: \n" +
        "Map: 028K\n" +
        "Add: 10805 HONEYCUTT RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  ENDERBURY DR   /   DEER FOREST TRL \n" +
        "Unt: BLP251,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **CARDIAC**\n" +
        "ATRIAL FIB, FEELING FAINT\n" +
        "PU  FD/BLP251\n" +
        ".: . FFD120719016414 - .  FD/BLP2",

        "CODE:FHEART",
        "CALL:CARDIAC",
        "MAP:028K",
        "ADDR:10805 HONEYCUTT RD",
        "X:ENDERBURY DR / DEER FOREST TRL",
        "UNIT:BLP251",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**CARDIAC** / ATRIAL FIB, FEELING FAINT / PU  FD/BLP251 / .: . FFD120719016414 - .  FD/BLP2");

    doTest("T20",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Friday, July 20, 2012 3:11 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FIPS : \n" +
        "Map: 026C\n" +
        "Add: 11401 OLD CREEDMOOR RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  CHESTOA LN   /   WINTERWOOD DR \n" +
        "Unt: BLP361,\n" +
        "TG: T15\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/BARNARD, STEPHANIE\n" +
        "PU  FD/BLP361",

        "CODE:FIPS",
        "CALL:INJURED PERSON SERIOUS",
        "MAP:026C",
        "ADDR:11401 OLD CREEDMOOR RD",
        "X:CHESTOA LN / WINTERWOOD DR",
        "UNIT:BLP361",
        "CH:T15",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/BARNARD, STEPHANIE / PU  FD/BLP361");

    doTest("T21",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Friday, July 20, 2012 5:37 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53O2 : \n" +
        "Map: 017G\n" +
        "Add: SIX FORKS RD / DUXFORD DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP251,\n" +
        "TG: O4\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/CORBETT, HEATHER R\n" +
        "F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER\n" +
        "STATEMENT: TREE FELL ON CAR A",

        "CODE:53O2",
        "CALL:Citizen assist/service call - Outside resource complaints",
        "MAP:017G",
        "ADDR:SIX FORKS RD & DUXFORD DR",
        "UNIT:BLP251",
        "CH:O4",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/CORBETT, HEATHER R / F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER / STATEMENT: TREE FELL ON CAR A");

    doTest("T22",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 21, 2012 5:18 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 026K\n" +
        "Add: 11701 NORWOOD RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  HALBERD CT   /   OLD HOLIDAY RD \n" +
        "Unt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/TESSARI, SHANNON P.\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (SMO",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:026K",
        "ADDR:11701 NORWOOD RD",
        "X:HALBERD CT / OLD HOLIDAY RD",
        "UNIT:DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/TESSARI, SHANNON P. / F ALARMS RESIDENTIAL (SINGLE) (SMO");

    doTest("T23",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 21, 2012 5:32 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50MC : \n" +
        "Map: 027D\n" +
        "Add: NORWOOD RD / SIX FORKS RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP251,BLR36,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-MOTORCYCLE**\n" +
        "MOTORCYCLE VS VAN...EMS REQUESTED\n" +
        "PU  FD/BLP251",

        "CODE:F50MC",
        "CALL:10-50/INJURIES/MOTORCYCLE",
        "MAP:027D",
        "ADDR:NORWOOD RD & SIX FORKS RD",
        "UNIT:BLP251,BLR36",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-MOTORCYCLE** / MOTORCYCLE VS VAN...EMS REQUESTED / PU  FD/BLP251");

    doTest("T24",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 21, 2012 7:34 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50I : \n" +
        "Map: 026U\n" +
        "Add: LEESVILLE RD / I 540, EB\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: DHP1,BLP361,\n" +
        "TG: T13\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "PARENT INC MEM120721047389 UPDATE RESP TO PARENT INC MEM120721047389 UPDATE\n" +
        "CMNT * TO",

        "CODE:F50I",
        "CALL:10-50/INJURIES",
        "MAP:026U",
        "ADDR:LEESVILLE RD & I 540 EB",
        "MADDR:LEESVILLE RD & I 540",
        "UNIT:DHP1,BLP361",
        "CH:T13",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-WITH INJURIES** / PARENT INC MEM120721047389 UPDATE RESP TO PARENT INC MEM120721047389 UPDATE / CMNT * TO");

    doTest("T25",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 21, 2012 10:00 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50I : \n" +
        "Map: 037E\n" +
        "Add: BRENNAN DR / CREEDMOOR RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: RFE18,BLP361,\n" +
        "TG: T14\n" +
        "Cty: RA\n" +
        "Comm: **ACCIDENT VEHICLE/INJURIES**\n" +
        "BAYLEAF FIRE ONSCENE ADVISING PI\n" +
        "PU  RF/RFE18",

        "CODE:F50I",
        "CALL:10-50/INJURIES",
        "MAP:037E",
        "ADDR:BRENNAN DR & CREEDMOOR RD",
        "UNIT:RFE18,BLP361",
        "CH:T14",
        "CITY:RALEIGH",
        "INFO:**ACCIDENT VEHICLE/INJURIES** / BAYLEAF FIRE ONSCENE ADVISING PI / PU  RF/RFE18");

    doTest("T26",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 22, 2012 3:30 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FAR : \n" +
        "Map: 027O\n" +
        "Add: 10912 CAHILL RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  NORTHCHESTER WAY   /   BRASSFIELD RD \n" +
        "Unt: BLP251,\n" +
        "TG: T16\n" +
        "Cty: WCRA\n" +
        "Comm: **ALLERGIC REACTION**\n" +
        "PU  FD/BLP251",

        "CODE:FAR",
        "CALL:ALLERGIC REACTION",
        "MAP:027O",
        "ADDR:10912 CAHILL RD",
        "X:NORTHCHESTER WAY / BRASSFIELD RD",
        "UNIT:BLP251",
        "CH:T16",
        "CITY:WAKE COUNTY",
        "INFO:**ALLERGIC REACTION** / PU  FD/BLP251");

    doTest("T27",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 23, 2012 3:52 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D6 : \n" +
        "Map: 028I\n" +
        "Add: 11805 FALLS OF NEUSE RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  LAKE VILLA WAY   /   WATERWOOD CT \n" +
        "Unt: BLP258,SHP261,WFE5,WFE2,WFE3,WFS5,WFBAT1,\n" +
        "TG: T17\n" +
        "Cty: RA\n" +
        "Comm: .: EC/DAVIS, AMANDA\n" +
        "F STRUCTURE FIRE RESIDENTIAL (SI",

        "CODE:69D6",
        "CALL:Structure Fire - Residential (single)",
        "MAP:028I",
        "ADDR:11805 FALLS OF NEUSE RD",
        "X:LAKE VILLA WAY / WATERWOOD CT",
        "UNIT:BLP258,SHP261,WFE5,WFE2,WFE3,WFS5,WFBAT1",
        "CH:T17",
        "CITY:RALEIGH",
        "INFO:.: EC/DAVIS, AMANDA / F STRUCTURE FIRE RESIDENTIAL (SI");

    doTest("T28",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 23, 2012 6:39 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 69D3 : \n" +
        "Map: 045E\n" +
        "Add: 1900 CARRINGTON PARK CIR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: STONE VIEW CRSG\n" +
        "Unt: MFE2,MFE1,MFC3,MFC1,BLL25,DHR5,DURHCTY,CARYFD,FMA1,\n" +
        "TG: \n" +
        "Cty: MV\n" +
        "Comm: .: EC/WELLS, JENINE\n" +
        "PU  FD/MFE2\n" +
        ".: . FFD120723016729 - .  FD/MF",

        "CODE:69D3",
        "CALL:Structure Fire - Commercial/industrial building",
        "MAP:045E",
        "ADDR:1900 CARRINGTON PARK CIR",
        "X:STONE VIEW CRSG",
        "UNIT:MFE2,MFE1,MFC3,MFC1,BLL25,DHR5,DURHCTY,CARYFD,FMA1",
        "CITY:MORRISVILLE",
        "INFO:.: EC/WELLS, JENINE / PU  FD/MFE2 / .: . FFD120723016729 - .  FD/MF");

    doTest("T29",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 23, 2012 6:46 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53O2 : \n" +
        "Map: 016R\n" +
        "Add: OLD CREEDMOOR RD / APPALOOSA RUN W\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP361,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/SUZIK, MICHAEL\n" +
        "F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER\n" +
        "STATEMENT: TREE ACROSS R",

        "CODE:53O2",
        "CALL:Citizen assist/service call - Outside resource complaints",
        "MAP:016R",
        "ADDR:OLD CREEDMOOR RD & APPALOOSA RUN W",
        "UNIT:BLP361",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/SUZIK, MICHAEL / F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTSCALLER / STATEMENT: TREE ACROSS R");

    doTest("T30",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 23, 2012 10:13 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53A5 : \n" +
        "Map: 026T\n" +
        "Add: I 540, EB / CREEDMOOR RD\n" +
        "Loc: EXIT 9 CREEDMOOR RD\n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: DHP1,BLP361,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/SHEAR, KRIS\n" +
        ". : EXIT 9 CREEDMOOR RD\n" +
        "5 CARS FOR FLUID ON THE ROAD ..\n" +
        "PU  FD/DHP1\n" +
        ".: . F",

        "CODE:53A5",
        "CALL:Citizen assist/service call - Service call",
        "MAP:026T",
        "ADDR:I 540 EB & CREEDMOOR RD",
        "MADDR:I 540 & CREEDMOOR RD",
        "PLACE:EXIT 9 CREEDMOOR RD",
        "UNIT:DHP1,BLP361",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/SHEAR, KRIS / . : EXIT 9 CREEDMOOR RD / 5 CARS FOR FLUID ON THE ROAD .. / PU  FD/DHP1 / .: . F");

    doTest("T31",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Monday, July 23, 2012 10:29 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50IC : \n" +
        "Map: 026U\n" +
        "Add: I 540, EB / LEESVILLE RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: DHP4,BLP366,\n" +
        "TG: T16\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "JUST WEST OF THE EXIT - UNKNOWN PT AGE - PT IS WALKING AROUND BUT\n" +
        "COMPLAINING OF LEG",

        "CODE:F50IC",
        "CALL:10-50/INJURIES COUNTY ONLY",
        "MAP:026U",
        "ADDR:I 540 EB & LEESVILLE RD",
        "MADDR:I 540 & LEESVILLE RD",
        "UNIT:DHP4,BLP366",
        "CH:T16",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-WITH INJURIES** / JUST WEST OF THE EXIT - UNKNOWN PT AGE - PT IS WALKING AROUND BUT / COMPLAINING OF LEG");

    doTest("T32",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 24, 2012 1:56 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FSEIZ : \n" +
        "Map: 017T\n" +
        "Add: 12709 ALPERN CT\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  TUTMAN CT   /   \n" +
        "Unt: BLP251,\n" +
        "TG: T13\n" +
        "Cty: WCRA\n" +
        "Comm: **SEIZURES**\n" +
        "PU  FD/BLP251",

        "CODE:FSEIZ",
        "CALL:SEIZURE",
        "MAP:017T",
        "ADDR:12709 ALPERN CT",
        "X:TUTMAN CT",
        "UNIT:BLP251",
        "CH:T13",
        "CITY:WAKE COUNTY",
        "INFO:**SEIZURES** / PU  FD/BLP251");

    doTest("T33",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 24, 2012 3:56 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53A5 : \n" +
        "Map: 026D\n" +
        "Add: NORWOOD RD / OLD CREEDMOOR RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP361,\n" +
        "TG: O11\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/HECKLER, ROBERT\n" +
        "F CITIZEN ASSIST / SERVICE CALL SERVICE CALLCALLER STATEMENT: TREE DOWN IN\n" +
        "ROADWAY-.: TREE",

        "CODE:53A5",
        "CALL:Citizen assist/service call - Service call",
        "MAP:026D",
        "ADDR:NORWOOD RD & OLD CREEDMOOR RD",
        "UNIT:BLP361",
        "CH:O11",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/HECKLER, ROBERT / F CITIZEN ASSIST / SERVICE CALL SERVICE CALLCALLER STATEMENT: TREE DOWN IN / ROADWAY-.: TREE");

    doTest("T34",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 25, 2012 5:09 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 025J\n" +
        "Add: 5012 BARTONS ENCLAVE LN\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  AMORETTO WAY   /   INDIGO MOON WAY \n" +
        "Unt: DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,WFL1,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/CORBETT, HEATHER R\n" +
        "F ALARMS RESIDENTIAL (SING",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:025J",
        "ADDR:5012 BARTONS ENCLAVE LN",
        "X:AMORETTO WAY / INDIGO MOON WAY",
        "UNIT:DHP1,DHP4,DHP3,DHR5,BLP366,BLP258,WFL1",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/CORBETT, HEATHER R / F ALARMS RESIDENTIAL (SING");

    doTest("T35",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 25, 2012 4:36 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FTEST : \n" +
        "Map: 027D\n" +
        "Add: 11713 SIX FORKS RD\n" +
        "Loc: BAYLEAF FIRE STA 1\n" +
        "Apt:  \n" +
        "CS:  NORWOOD RD   /   POSSUM TRACK RD \n" +
        "Unt: BLP251,\n" +
        "TG: \n" +
        "Cty: WCRA\n" +
        "Comm: **TEST CALL**\n" +
        ". : BAYLEAF FIRE STA 1\n" +
        "PU  FD/BLP251,\n" +
        ".: . FFD120725016990",

        "CODE:FTEST",
        "CALL:TEST",
        "MAP:027D",
        "ADDR:11713 SIX FORKS RD",
        "PLACE:BAYLEAF FIRE STA 1",
        "X:NORWOOD RD / POSSUM TRACK RD",
        "UNIT:BLP251",
        "CITY:WAKE COUNTY",
        "INFO:**TEST CALL** / . : BAYLEAF FIRE STA 1 / PU  FD/BLP251, / .: . FFD120725016990");

    doTest("T36",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, July 25, 2012 7:00 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 72D6 : \n" +
        "Map: 003W\n" +
        "Add: NEW LIGHT RD / GHOSTON RD\n" +
        "Loc: FALLS LAKE\n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP251,\n" +
        "TG: \n" +
        "Cty: WCWF\n" +
        "Comm: .: EC/DACOSTA, JOANNA\n" +
        ". : FALLS LAKE\n" +
        "ON THE LAKE, SWIMMER STRUGGLING, 50 BOAT L9OFT F WATER RESCUE INLAND\n" +
        "WA0000103TER RESCUE\n\n" +
        "PU  FD/SHP392\n" +
        ".: . FFD120725017003 - .  FD/SHP392\n" +
        ". MEM120725048308 UPDATE RESP TO\n" +
        ". MEM120725048308 UPDATE CMNT * TO 01\n" +
        ". MEM120725048308 UPDATE PRIUNT TO EM/EMS12 UNIT FD/SHP392 MILEAGE ENTERED\n" +
        "ODO: 0000.0 ADV SHE IS O",

        "CODE:72D6",
        "CALL:Water Rescue - Inland water rescue",
        "MAP:003W",
        "ADDR:NEW LIGHT RD & GHOSTON RD",
        "PLACE:FALLS LAKE",
        "UNIT:BLP251",
        "CITY:WAKE FOREST",
        "INFO:.: EC/DACOSTA, JOANNA / . : FALLS LAKE / ON THE LAKE, SWIMMER STRUGGLING, 50 BOAT L9OFT F WATER RESCUE INLAND / WA0000103TER RESCUE / PU  FD/SHP392 / .: . FFD120725017003 - .  FD/SHP392 / . MEM120725048308 UPDATE RESP TO / . MEM120725048308 UPDATE CMNT * TO 01 / . MEM120725048308 UPDATE PRIUNT TO EM/EMS12 UNIT FD/SHP392 MILEAGE ENTERED / ODO: 0000.0 ADV SHE IS O");

    doTest("T37",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 26, 2012 1:44 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FHEART: \n" +
        "Map: 027X\n" +
        "Add: 1012 OLD MEETINGHOUSE WAY\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  WHITE CHAPEL WAY   /   \n" +
        "Unt: BLP251,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **CARDIAC**\n" +
        "PU  FD/BLP251",

        "CODE:FHEART",
        "CALL:CARDIAC",
        "MAP:027X",
        "ADDR:1012 OLD MEETINGHOUSE WAY",
        "X:WHITE CHAPEL WAY",
        "UNIT:BLP251",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**CARDIAC** / PU  FD/BLP251");

    doTest("T38",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Thursday, July 26, 2012 10:35 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FUNCON: \n" +
        "Map: 027H\n" +
        "Add: 213 TROTTERS RIDGE DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  PACER CT   /   BRIDLE LN \n" +
        "Unt: BLP251,\n" +
        "TG: T21\n" +
        "Cty: WCRA\n" +
        "Comm: **UNCONSCIOUS**\n" +
        "PARENT INC MEM120726048444 UPDATE RESP TO PARENT INC MEM120726048444 UPDATE\n" +
        "C",

        "CODE:FUNCON",
        "CALL:UNCONSCIOUS/FAINTING",
        "MAP:027H",
        "ADDR:213 TROTTERS RIDGE DR",
        "X:PACER CT / BRIDLE LN",
        "UNIT:BLP251",
        "CH:T21",
        "CITY:WAKE COUNTY",
        "INFO:**UNCONSCIOUS** / PARENT INC MEM120726048444 UPDATE RESP TO PARENT INC MEM120726048444 UPDATE / C");

    doTest("T39",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 28, 2012 12:25 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FBD : \n" +
        "Map: 003L\n" +
        "Add: 13900 CREEDMOOR RD\n" +
        "Loc: FALLS LAKE NC HWY 50 BOAT RAMP\n" +
        "Apt:  \n" +
        "CS:  GRANITE HILL TRL   /   EASY HORSE TRL \n" +
        "Unt: BLP361,\n" +
        "TG: T20\n" +
        "Cty: WCWF\n" +
        "Comm: **BREATHING DIFFICULTY**\n" +
        "BAYLEAF 203 ONSCENE.. TAC 20\n" +
        "P",

        "CODE:FBD",
        "CALL:RESPIRATORY DISTRESS",
        "MAP:003L",
        "ADDR:13900 CREEDMOOR RD",
        "PLACE:FALLS LAKE NC HWY 50 BOAT RAMP",
        "X:GRANITE HILL TRL / EASY HORSE TRL",
        "UNIT:BLP361",
        "CH:T20",
        "CITY:WAKE FOREST",
        "INFO:**BREATHING DIFFICULTY** / BAYLEAF 203 ONSCENE.. TAC 20 / P");

    doTest("T40",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 28, 2012 7:45 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 027D\n" +
        "Add: 209 CARRIAGE TRL\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  DUNSTABLE CT   /   COACHMANS WAY \n" +
        "Unt: BLP251,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/SLOHN, NEAL\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)-.:\n" +
        "BOLLIBGER--.: KIT",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:027D",
        "ADDR:209 CARRIAGE TRL",
        "X:DUNSTABLE CT / COACHMANS WAY",
        "UNIT:BLP251,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/SLOHN, NEAL / F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)-.: / BOLLIBGER--.: KIT");

    doTest("T41",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 28, 2012 8:03 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FAR : \n" +
        "Map: 037J\n" +
        "Add: 2713 FARNBOROUGH RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: HOWARD RD\n" +
        "Unt: BLP121,RFE18,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **ALLERGIC REACTION**\n" +
        "DAUGHTER STUNG BY SOMETHING ON FOOT\n" +
        "PARENT INC MEM120728049056 UPDATE RESP TO PARENT",

        "CODE:FAR",
        "CALL:ALLERGIC REACTION",
        "MAP:037J",
        "ADDR:2713 FARNBOROUGH RD",
        "X:HOWARD RD",
        "UNIT:BLP121,RFE18",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**ALLERGIC REACTION** / DAUGHTER STUNG BY SOMETHING ON FOOT / PARENT INC MEM120728049056 UPDATE RESP TO PARENT");

    doTest("T42",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 28, 2012 9:12 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53O2 : \n" +
        "Map: 016W\n" +
        "Add: BLACK HORSE RUN / MAN O WAR TRL\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP361,\n" +
        "TG: O3\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/COOKE, WILLIAM J\n" +
        "F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTS\n\n" +
        "PU  FD/BLP361\n" +
        ".: . FFD120728",

        "CODE:53O2",
        "CALL:Citizen assist/service call - Outside resource complaints",
        "MAP:016W",
        "ADDR:BLACK HORSE RUN & MAN O WAR TRL",
        "UNIT:BLP361",
        "CH:O3",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/COOKE, WILLIAM J / F CITIZEN ASSIST / SERVICE CALL DOWNED TREES AND OBJECTS / PU  FD/BLP361 / .: . FFD120728");

    doTest("T43",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Saturday, July 28, 2012 11:12 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FHEART: \n" +
        "Map: 027C\n" +
        "Add: 1001 MOLLINGTON CT\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  BRASS KETTLE RD   /   \n" +
        "Unt: BLP251,\n" +
        "TG: T15\n" +
        "Cty: WCRA\n" +
        "Comm: **CARDIAC**\n" +
        "REQ NO SIRENS\n" +
        "PU  FD/BLP251",

        "CODE:FHEART",
        "CALL:CARDIAC",
        "MAP:027C",
        "ADDR:1001 MOLLINGTON CT",
        "X:BRASS KETTLE RD",
        "UNIT:BLP251",
        "CH:T15",
        "CITY:WAKE COUNTY",
        "INFO:**CARDIAC** / REQ NO SIRENS / PU  FD/BLP251");

    doTest("T44",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 29, 2012 5:58 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53O2 : \n" +
        "Map: 026T\n" +
        "Add: OLD CREEDMOOR RD / BEECHNUT TRL\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP361,RFE18,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/BANNING, LINDSAY\n" +
        "BETWEEN BEECHNUT AND NORWOOD BEFORE ENTRANCE TO OLD CREEDMOOR SUBDIVISION F\n" +
        "CITIZ",

        "CODE:53O2",
        "CALL:Citizen assist/service call - Outside resource complaints",
        "MAP:026T",
        "ADDR:OLD CREEDMOOR RD & BEECHNUT TRL",
        "UNIT:BLP361,RFE18",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/BANNING, LINDSAY / BETWEEN BEECHNUT AND NORWOOD BEFORE ENTRANCE TO OLD CREEDMOOR SUBDIVISION F / CITIZ");

    doTest("T45",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 29, 2012 5:33 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FBD : \n" +
        "Map: 026Y\n" +
        "Add: 2416 BEECHVIEW CT\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  KINGS MILL PL   /   STAGE FORD RD \n" +
        "Unt: BLP361,RFE18,\n" +
        "TG: T15\n" +
        "Cty: WCRA\n" +
        "Comm: **BREATHING DIFFICULTY**\n" +
        "PU  FD/BLP361",

        "CODE:FBD",
        "CALL:RESPIRATORY DISTRESS",
        "MAP:026Y",
        "ADDR:2416 BEECHVIEW CT",
        "X:KINGS MILL PL / STAGE FORD RD",
        "UNIT:BLP361,RFE18",
        "CH:T15",
        "CITY:WAKE COUNTY",
        "INFO:**BREATHING DIFFICULTY** / PU  FD/BLP361");

    doTest("T46",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Sunday, July 29, 2012 6:06 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 53A2 : \n" +
        "Map: 037I\n" +
        "Add: 8809 SLEEPY CREEK DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  WELLSLEY WAY   /   \n" +
        "Unt: BLP121,RFE18,\n" +
        "TG: T13\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/SANDERS, ALAN\n" +
        "EMS6 ONSCENE REQUIRING LIFT ASSISTANCE.. ROUTINE RESPONSE.. TAC 13 PU  FD/B",

        "CODE:53A2",
        "CALL:Citizen assist/service call - Citizen assist (non-medical assistance)",
        "MAP:037I",
        "ADDR:8809 SLEEPY CREEK DR",
        "X:WELLSLEY WAY",
        "UNIT:BLP121,RFE18",
        "CH:T13",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/SANDERS, ALAN / EMS6 ONSCENE REQUIRING LIFT ASSISTANCE.. ROUTINE RESPONSE.. TAC 13 PU  FD/B");

    doTest("T47",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 1:54 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FDIAB : \n" +
        "Map: 017G\n" +
        "Add: 13036 SIX FORKS RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  IMAGE PT   /   DUXFORD DR \n" +
        "Unt: BLP251,\n" +
        "TG: T14\n" +
        "Cty: WCRA\n" +
        "Comm: **DIABETIC PROBLEM**\n" +
        "PU  FD/BLP251",

        "CODE:FDIAB",
        "CALL:DIABETIC CRISIS",
        "MAP:017G",
        "ADDR:13036 SIX FORKS RD",
        "X:IMAGE PT / DUXFORD DR",
        "UNIT:BLP251",
        "CH:T14",
        "CITY:WAKE COUNTY",
        "INFO:**DIABETIC PROBLEM** / PU  FD/BLP251");

    doTest("T48",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 9:01 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 027J\n" +
        "Add: 5528 PEAKTON DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:    /   HONEYCUTT RD \n" +
        "Unt: BLP251,BLL25,\n" +
        "TG: O2\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/DAVIS, AMANDA\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEMENT: FIRE\n" +
        "ALM-.: HORT",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:027J",
        "ADDR:5528 PEAKTON DR",
        "X:HONEYCUTT RD",
        "UNIT:BLP251,BLL25",
        "CH:O2",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/DAVIS, AMANDA / F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEMENT: FIRE / ALM-.: HORT");

    doTest("T49",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 10:54 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FCVA : \n" +
        "Map: 017X\n" +
        "Add: 12109 DEER RUN\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  MOORFOOTE CT   /   HONEYCUTT RD \n" +
        "Unt: BLP251,\n" +
        "TG: T16\n" +
        "Cty: WCRA\n" +
        "Comm: **CVA**\n" +
        "PU  FD/BLP251",

        "CODE:FCVA",
        "CALL:CVA/STROKE",
        "MAP:017X",
        "ADDR:12109 DEER RUN",
        "X:MOORFOOTE CT / HONEYCUTT RD",
        "UNIT:BLP251",
        "CH:T16",
        "CITY:WAKE COUNTY",
        "INFO:**CVA** / PU  FD/BLP251");

    doTest("T50",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 11:09 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FSEIZ : \n" +
        "Map: 027J\n" +
        "Add: 2001 BRASSFIELD RD\n" +
        "Loc: BRASSFIELD ELEMENTARY\n" +
        "Apt:  \n" +
        "CS:  SARANT OAKS CT   /   HONEYCUTT RD \n" +
        "Unt: BLB259,\n" +
        "TG: T19\n" +
        "Cty: WCRA\n" +
        "Comm: **SEIZURES**\n" +
        "PT IN RM 118\n" +
        "PU  FD/BLB259\n" +
        ".: . FFD120731017506 - .",

        "CODE:FSEIZ",
        "CALL:SEIZURE",
        "MAP:027J",
        "ADDR:2001 BRASSFIELD RD",
        "PLACE:BRASSFIELD ELEMENTARY",
        "X:SARANT OAKS CT / HONEYCUTT RD",
        "UNIT:BLB259",
        "CH:T19",
        "CITY:WAKE COUNTY",
        "INFO:**SEIZURES** / PT IN RM 118 / PU  FD/BLB259 / .: . FFD120731017506 - .");

    doTest("T51",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 4:12 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: FIPS : \n" +
        "Map: 027K\n" +
        "Add: 900 CARRINGTON DR\n" +
        "Loc: STONEBRIDGE SWIMMING\n" +
        "Apt:  \n" +
        "CS:  WHITESTONE RD   /   COUNTRYWOOD NORTH RD \n" +
        "Unt: BLC360,\n" +
        "TG: T19\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/MCDOW, J.\n\n" +
        "PU  FD/BLC360\n" +
        ".: . FFD120731017523 - .  FD/B",

        "CODE:FIPS",
        "CALL:INJURED PERSON SERIOUS",
        "MAP:027K",
        "ADDR:900 CARRINGTON DR",
        "PLACE:STONEBRIDGE SWIMMING",
        "X:WHITESTONE RD / COUNTRYWOOD NORTH RD",
        "UNIT:BLC360",
        "CH:T19",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/MCDOW, J. / PU  FD/BLC360 / .: . FFD120731017523 - .  FD/B");

    doTest("T52",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Tuesday, July 31, 2012 8:23 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 67B1 : \n" +
        "Map: 027B\n" +
        "Add: 14201 NORWOOD RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  CAVANAUGH DR   /   RAVEN ROCK DR \n" +
        "Unt: BLB259,\n" +
        "TG: O2\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/ANDERSON, KEVIN\n" +
        "F OUTSIDE FIRE SMALL OUTSIDE FIRECALLER STATEMENT: BRANCH ON A LINE",

        "CODE:67B1",
        "CALL:Outside Fire - Smal outside fire",
        "MAP:027B",
        "ADDR:14201 NORWOOD RD",
        "X:CAVANAUGH DR / RAVEN ROCK DR",
        "UNIT:BLB259",
        "CH:O2",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/ANDERSON, KEVIN / F OUTSIDE FIRE SMALL OUTSIDE FIRECALLER STATEMENT: BRANCH ON A LINE");

    doTest("T53",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, August 01, 2012 7:32 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 52B1S : \n" +
        "Map: 027M\n" +
        "Add: 10325 SIX FORKS RD\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  JANSMITH LN   /   WYNDFIELD CIR \n" +
        "Unt: BLP251,BLL25,\n" +
        "TG: O1\n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/RATTELADE, JESSICA\n" +
        "F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEME",

        "CODE:52B1S",
        "CALL:Alarms - Residential    - Smoke Detector",
        "MAP:027M",
        "ADDR:10325 SIX FORKS RD",
        "X:JANSMITH LN / WYNDFIELD CIR",
        "UNIT:BLP251,BLL25",
        "CH:O1",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/RATTELADE, JESSICA / F ALARMS RESIDENTIAL (SINGLE) (SMOKE DETECTOR)CALLER STATEME");

    doTest("T54",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, August 01, 2012 11:35 AM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: F50I : \n" +
        "Map: 027W\n" +
        "Add: I 540, EB / SIX FORKS RD\n" +
        "Loc: EXIT 11 SIX FORKS RD\n" +
        "Apt:  \n" +
        "CS: \n" +
        "Unt: BLP122,WFE5,\n" +
        "TG: T20\n" +
        "Cty: WCRA\n" +
        "Comm: **ACCIDENT-WITH INJURIES**\n" +
        "WHITE 4DR SEDAN\n" +
        "PU  FD/BLP122\n" +
        ".: . FFD120801017590 - .  FD/BLP12",

        "CODE:F50I",
        "CALL:10-50/INJURIES",
        "MAP:027W",
        "ADDR:I 540 EB & SIX FORKS RD",
        "MADDR:I 540 & SIX FORKS RD",
        "PLACE:EXIT 11 SIX FORKS RD",
        "UNIT:BLP122,WFE5",
        "CH:T20",
        "CITY:WAKE COUNTY",
        "INFO:**ACCIDENT-WITH INJURIES** / WHITE 4DR SEDAN / PU  FD/BLP122 / .: . FFD120801017590 - .  FD/BLP12");

    doTest("T55",
        " \n\n" +
        "-----Original Message-----\n" +
        "From: wcps@wakegov.com [mailto:wcps@wakegov.com] \n" +
        "Sent: Wednesday, August 01, 2012 6:11 PM\n" +
        "To: pageserver@earthlink.net\n" +
        "Subject: WCPS\n\n" +
        "Inc: 63B1 : \n" +
        "Map: 017A\n" +
        "Add: 1116 TACKETTS POND DR\n" +
        "Loc:  \n" +
        "Apt:  \n" +
        "CS:  QUIET RIDGE CIR   /   SUNSET GLEN PT \n" +
        "Unt: BLR36,\n" +
        "TG: \n" +
        "Cty: WCRA\n" +
        "Comm: .: EC/MARTIN, DAVID\n" +
        "F LIGHTNING STRIKE (INVESTIGATION) RESIDENTIAL (SINGLE)CALLER\n" +
        "STATE0000203MENT:\n" +
        "HOUSE HIT BY LIGHTENING\n\n" +
        "DUPCALL: WCRA\n" +
        "CNAME: AT / T MOBILITY CPH: 9196964952\n" +
        "CADDR: 12205 CREEDMOOR RD\n" +
        "TYPE: CONTACT COMP: FAS: N SS:\n" +
        "PRI: SRC: 1 MC: DISPO:\n" +
        "PU  FD/SHP261\n" +
        ".: . FFD120801017624 - .  FD/SHP261\n" +
        "DISPO NON-PRIMAR",

        "CODE:63B1",
        "CALL:Lightning Strike - Residential (single)",
        "MAP:017A",
        "ADDR:1116 TACKETTS POND DR",
        "X:QUIET RIDGE CIR / SUNSET GLEN PT",
        "UNIT:BLR36",
        "CITY:WAKE COUNTY",
        "INFO:.: EC/MARTIN, DAVID / F LIGHTNING STRIKE (INVESTIGATION) RESIDENTIAL (SINGLE)CALLER / STATE0000203MENT: / HOUSE HIT BY LIGHTENING / DUPCALL: WCRA / CNAME: AT / T MOBILITY CPH: 9196964952 / CADDR: 12205 CREEDMOOR RD / TYPE: CONTACT COMP: FAS: N SS: / PRI: SRC: 1 MC: DISPO: / PU  FD/SHP261 / .: . FFD120801017624 - .  FD/SHP261 / DISPO NON-PRIMAR");

  }

  public static void main(String[] args) {
    new NCWakeCountyParserTest().generateTests("T1");
  }
}
