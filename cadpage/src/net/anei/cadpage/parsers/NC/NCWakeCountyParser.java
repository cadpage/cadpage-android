package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;

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

public class NCWakeCountyParser extends FieldProgramParser {
  
  public NCWakeCountyParser() {
    super(CITY_CODES, "WAKE COUNTY", "NC",
           "Inc:CALL! Map:MAP! Add:ADDR! Loc:PLACE! Apt:APT! CS:X? Unt:UNIT! TG:CH! Cty:CITY! Comm:INFO INFO+");
  }
  
  @Override
  public String getFilter() {
    return "wcps@wakegov.com";
  }

  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!subject.equals("WCPS")) return false;
    return parseFields(body.split("\n"), data);
  }
  
  private class MyCallField extends CallField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(":")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyAddressField extends AddressField {
    @Override
    public void parse(String field, Data data) {
      field = field.replace(",", "");
      super.parse(field, data);
    }
  }
  
  private class MyCrossField extends CrossField {
    @Override
    public void parse(String field, Data data) {
      field = field.replaceAll("  +", " ");
      if (field.startsWith("/")) field = field.substring(1).trim();
      if (field.endsWith("/")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  private class MyUnitField extends UnitField {
    @Override
    public void parse(String field, Data data) {
      if (field.endsWith(",")) field = field.substring(0,field.length()-1).trim();
      super.parse(field, data);
    }
  }
  
  @Override
  public Field getField(String name) {
    if (name.equals("CALL")) return new MyCallField();
    if (name.equals("ADDR")) return new MyAddressField();
    if (name.equals("X")) return new MyCrossField();
    if (name.equals("UNIT")) return new MyUnitField();
    return super.getField(name);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "AN",     "ANGIER",
      "WCAN",   "ANGIER",
      "AP",     "APEX",
      "WCAP",   "APEX",
      "CA",     "CARY",
      "WCCA",   "CARY",
      "WCCL",   "CLAYTON",
      "WCCR",   "CREEDMOOR",
      "WCDU",   "DURHAM",
      "FV",     "FUQUAY-VARINA",
      "WCFV",   "FUQUAY-VARINA",
      "GR",     "GARNER",
      "WCGR",   "GARNER",
      "HS",     "HOLLY SPRINGS",
      "WCHS",   "HOLLY SPRINGS",
      "KD",     "KNIGHTDALE",
      "WCKD",   "KNIGHTDALE",
      "MV",     "MORRISVILLE",
      "WCMV",   "MORRISVILLE",
      "WCNH",   "NEW HILL",
      "RA",     "RALEIGH",
      "WCRA",   "WAKE COUNTY", // "RALEIGH",
      "RDU",    "RDU",
      "RO",     "ROLESVILLE",
      "WCRO",   "ROLESVILLE",
      "WF",     "WAKE FOREST",
      "WCWF",   "WAKE FOREST",
      "WD",     "WENDELL",
      "WCWD",   "WENDELL",
      "WCWS",   "WILLOW SPRINGS",
      "WCYV",   "YOUNGSVILLE",
      "ZB",     "ZEBULON",
      "WCZB",   "ZEBULON"
  });
}
