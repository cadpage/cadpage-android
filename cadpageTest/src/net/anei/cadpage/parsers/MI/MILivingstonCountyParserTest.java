package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MI.MILivingstonCountyParser;

import org.junit.Test;

/*
Livingston County, MI
Sender: CAD@livingstoncounty.livco

CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10 04:17:07 ECOOK]
CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE [09/23/10 21:45:06 ECOOK]
CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal
CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.
CAD:FYI: ;HEMLAC;SHEHAN RD/WHITEWOOD RD;[Medical Priority Info]RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 35 year old, Female, Conscious, Brea

Pagecopy-Fr:CAD@lc911\nCAD:FYI: ;CHSTPN;7251 HAMBURG RD;WELLE RD;[Medical Priority Info] RESPONSE: P1 STA 1 3 4 5 6 7 8 FC FT RESPONDER S

Contact: John Masek <john.sta33@gmail.com>
CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10 20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAIN BREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK

CAD:FYI: ;UNCON;SANCTURY OF WOODLAND;7533 W GRAND RIVER;COURT ST;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 80 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Eff
CAD:FYI: ;DIABET;31 STRATFORD LN;NEWCASTLE LN;[Medical Priority Info] RESPONSE: P1 STA 1 2 4 5 6 7 8 FC FT RESPONDER SCRIPT: 47 year old, Female, :1of2

Contact: Jordan Zernick <zernick1115@gmail.com>
Pagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1

Contact: Casey Yost <caseyyost@gmail.com>
firediver11+caf_=5176671194=vtext.com@gmail.comPagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;SEIZUR;131 STRATFORD LN;BELMONT LN;[Medical Priority Info]

Contact: Jeff Vaden <jeffvaden@gmail.com>
Pagecopy-Fr:CAD@livingstoncounty.livco CAD:Update: ;FALL;3031 WM36;[EMS] HAS BEEN VOMITTING - DIABETIC [02/14/11 09:55:08 RLADOUCEUR] [Me

Contact: Aaron Gage <aarongage16@gmail.com>
Sender: 93001011
CAD:FYI: ;OPENBU;8360 MCCLEMENTS RD;DEKASSEL DR;BURNING GARBAGE ONE HOUSE EAST OF CALLER [07/01/11 19:44:56 SSTURGIS]

Contact: Steve Hoyer <nottheface@gmail.com>
Sender: CAD@livingstoncounty.livco
FYI: ;SMKOUT;CHEROKEE BEND DR/RED OAKS DR;CALLER HEARD AN EXPLOSION ON CHEROKEE BEND, DOES NOT SEE ANYTHING AT THIS TIME. SMELLS SMOKE. [09/21/11 21:53:2
FYI: ;CHOKE;SORG RESIDENCE;2917 LANIER CT;TAHOE BLVD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 3 year old, Male, C

Contact: John Masek <john.sta33@gmail.com>
Sender: CAD@livingstoncounty.livco
FRM:CAD@livingstoncounty.livco\nMSG:CAD:FYI: ;PIA;DORR RD/E GRAND RIVER;JEEP LIBERTY VS SILVER VAN [11/30/11 09:18:58 CWESTPHAL]

Contact: James P Krywko <James.Krywko@ipaper.com>
Sender: CAD@livingstoncounty.livco
CAD:CANCEL;N NATIONAL ST/E GRAND RIVER AVE; HOWL;AT CORNER
CAD:Update: ;OIOUT;REGAL RECYCLERS;645 LUCY RD;INDUSTRIAL ST;{EN34} REQ CONSUMERS [12/28/11 17:51:25 LLOWE]
CAD:FYI: ;CHOKE;5385 GREEN RD;CLYDE RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8<tel:12345678> FC FT RESPONDER SCRIPT: 78 year old, Male, Conscious, Not breathing. Choking. Not alert. Caller Statement: CHOKING ON FOOD . 1.He is n
CAD:FYI: ;PIA;N LATSON RD/E HIGHLAND RD;RED TRUCK VS SMALL SEDAN PER CALLER SUBJECT IS NOT OK [12/28/11 19:50:00 MSPICER]

Contact: Dave Korponic <dkorps@gmail.com>
Sender: Dave Korponic <dkorps@gmail.com>
CAD:FYI: ;SICK;10165 CARLEE JUNE DR;RUNYAN LAKE RD;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 37 year old, Male, Consci

Contact: Steve Hoyer <nottheface@gmail.com>
Update: ;TREEF;5117 CULVER RD;CANYON OAKS DR;CALLER STATES TREE COMPLETELY BLOCKING CULVER RD, [08/11/12 02:25:45 JMURPHY-KE]
Update: ;DEATH;4601 GOLF VIEW DR;GOLF VIEW CT;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 83 year old, Male, Unconsc

Contact: Tyler Hammock <hamtyl07@sbcglobal.net>
Sender: CAD@livingstoncounty.livco
FRM:CAD@livingstoncounty.livco\nSUB:\nMSG:CAD:PIA;CHILSON RD/E GRAND RIVER;[LAW] RED BID AS PIA [07/11/13 14:35:24 DDEMAN] CAR IS PINNED AGAINST THE TOR OF THE CONSTRUCTION VEHICLE [07/11/13 14:34:31 CWESTPHAL] BID [07/11/13 14:33:51 DDEMAN] BLK TRAILBLAZER VS CONSTRUCTION VEHICLE

Contact: Active911
Agency name: Liv. Co Disaster Assistance Response Team Location: Howell, MI 
Sender: CAD@livingstoncounty.livco
CAD:DART;1279 RICKETT RD; BRTN;STRUCTURE FIRE
CAD:DART;S US23/NORTH TERRITORIAL;MUTUAL AID TO OTHER FD OR EMS

Contact: Active911
[] CAD:ALARMF;6435 THOMPSON POND DR;CANCELING FIRE ALARM [09/17/12 22:14:51 RKRAMER] MIKE REARDON RESD TX IS 313-215-6084 TRIP IS GEN FIRE ATT KEYHOLDER [09/17/12 22:13:23 RKRAMER] Aborted by Medical Priority with code: CREATED I;WHIT\r\n\n
[] CAD:FALL3;3855 RUSH LAKE RD;VAN HORN DR;[Medical Priority Info] RESPONSE: P3 STA 1 4 5 EN80 RESPONDER SCRIPT: 94 year old, Female, Conscious, Breathing. Falls. PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor);PI\r\n\n
[] CAD:TRAUMA;MERRILL RD/SHELDON RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 25 year old, Male, Conscious, Breathing. Traumatic Injuries (Specific). POSSIBLY DANGEROUS body area. Caller Stateme;WHIT\r\n\n
[] CAD:FALL;10892 MONTICELLO RD;REVERE RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 86 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less tha;PINK\r\n\n
[] CAD:UNCON;10024 MARGARET DR;KRESS RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 61 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Call;LKLD\r\n\n
[] CAD:CO;11259 ALGONQUIN DR;WAYNE DR;CALLER WAS ADVISED TO EVACUATE HIS HOME [09/19/12 11:19:02 EPERRY] CALLER IS REQUESTING NO SIRENS [09/19/12 11:18:18 EPERRY] CALLER STATES HIS CARBON MONOXIDE ALARM IS GOING OFF. HE CHECKED THE BA;PINK\r\n\n
[] CAD:CVA;5269 NAVAJO TRL;CHILSON RD;[Medical Priority Update] Medical Priority reconfigured event from 28-C-06L to 28-C-06J. RESPONDER SCRIPT: Sudden loss of balance or coordination (Clear evidence of stroke (< X hours)). 6. Dispat;PINK\r\n\n
[] CAD:SEIZUR;PATHFINDER SCHOOL;2100 E M36;EMERALD CT;[EMS] PT IS BREATHING [09/19/12 14:06:52 EPERRY] [LAW] BID [09/19/12 14:06:50 DDEMAN] [Medical Priority Info] RESPONSE: P1 STA 1 4 5 7 8 RESPONDER SCRIPT: 10 year old, Female, Consciousness\r\n\n
[] CAD:OTH;51 DOVE AVE;EAGLE ST;MICROWAVE CAUGHT FIRE -- SMOKE EVERYWHERE, MADE A NOISE , DOES NOT SEE FLAMES -- THERE WAS A SPARKING AT TEH ELECTRICAL CORD [09/19/12 17:34:41 CWESTPHAL] ;WHIT\r\n\n
CAD:FYI: ;ME;10533 KENICOTT TRL;OVERHILL DR;Event spawned from SICK PERSON. [09/26/2012 10:50:56 AHUGHES] Aborted by Medical Priority with code: CREATED IN ERROR [09/26/12 10:40:58 DONEILL] [Medical Priority Info] RESPONSE: P3 STA 1 EN80 RE
CAD:OTH;8001 CHALLIS RD;KARL GREIMEL DR;THE CITY HAS BEEN NOTIFIED [09/26/12 15:47:04 LBOURBEAU] CALLER STATES THE OFFICE BUILDING IS FLOODING DUE TO A SEWAGE ISSUE. IS CONCERNED ABOUT ELECTRICAL WIRING AND DEVICES CAUSING HAZARD DUE TO ;BR
CAD:APD;3844 BAUER RD;ILA LN;Event spawned from ANIMAL COMPLAINT. [09/27/2012 08:20:42 AHUGHES] DEER STUCK IN A FENCE [09/27/12 07:46:46 AHUGHES] ;BRTN
CAD:UNCON;315 W NORTH ST;PIERCE ST;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 73 year old, Male, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: PATIENT ALT;BRTN
CAD:PIA;E GRAND RIVER/GOLF CLUB RD;RED STA WGN 1 MALE WITH BACK INJURIES WHT SEDAN STILL IN INTERSECTION [09/27/12 12:33:54 MREED] HHR VS BUICK - 1 VEH BLOCKING WB SIDE [09/27/12 12:33:18 DLABERDIE] ;HOWL
CAD:HEMLAC;CARETEL INN;1014 E GRAND RIVER AVE;ACORN DR;[LAW] BID [09/28/12 09:29:40 JWITHERS] [Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 92 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations
CAD:UNKMED;W GRAND RIVER/HILTON RD;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 7 8 RESPONDER SCRIPT: 55 year old, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Standing, sitting, moving, or tal;BRTN
CAD:ALARMF;5579 MOUNTAIN RD;EGGERT PL;ADVISED UNK WHY FIRE IS GOING OFF MADE CONTACT WITH KH NO FIRE NO SMOE [09/28/12 10:44:35 EPERRY] OLDFORD. 810-229-5004. FIRE ALARM. ATT KH. [09/28/12 10:44:22 EPERRY] ;BRTN
CAD:ENVIR;E GRAND RIVER AVE/E MAIN ST;[LAW] {3931} CORRIGANS EN ROUTE [09/28/12 19:33:43 JSTIDHAM] Event spawned from PDA. [09/28/2012 19:32:11 JSTIDHAM] {3931} REQ CORRIGANS W 2 WRECKERS & FIRE FOR ENVIR [09/28/12 19:32:06 JSTIDHAM];BRTN
CAD:SMKOUT;ETHEL BLVD/BURSON DR;CALLERS NEIGH`S ARE BURNING GARBAGE... SHE SEES AND SMELLS SMOKE. NO CONTACT. [09/28/12 20:09:35 BKENNEDY] ;BRTN
CAD:ANBITE;1022 S HUGHES RD;WATER WILLOW DR;[EMS] UDTS: {A102} EMS & FD UNIT ACK DISP [09/29/12 09:27:47 JWITHERS] 27 YOM, BIT BY DOG HAND, AWAKE, CONS, PASSED OUT, NOW CONC, DOG IN IN PEN OUTSIDE, NOT SERIOUS BLEEDING, NOT ALERT, GREY IN C
CAD:UNCON;4033 ST ANDREWS;[EMS] PREV HISTORY OF A HEMATOMA [09/29/12 15:34:47 EPERRY] [EMS] IN BACKYARD UNDER A TENT [09/29/12 15:34:05 EPERRY] [Medical Priority Info] Key Questions Complete RESPONSE: P1 STA 1 2 3 4 5 6 7 ;HOWL
CAD:SEIZUR;8501 W GRAND RIVER AVE;BEST BUY DR;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 46 year old, Female, Unconscious, Breathing. Convulsions / Seizures. CONTINUOUS or MULTIPLE seizures (Epileptic o

**  NOT PARSING ***
Contact: Aaron Gage <AGage@brightonareafire.com>
Sender: CAD@livingstoncounty.livco
(SEIZUR;8501 W GRAND RIVER AVE;BEST BUY DR;[Medical Priority Info] RESPONSE) CAD:P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 46 year old, Female, Unco
(ANBITE;1022 S HUGHES RD;WATER WILLOW DR;[EMS] UDTS) CAD:{A102} EMS & FD UNIT ACK DISP [09/29/12 09:27:47 JWITHERS] 27 YOM, BIT BY DOG HAND, AWAKE, CONS,
(Text Message) CAD:SMKOUT;ETHEL BLVD/BURSON DR;CALLERS NEIGH`S ARE BURNING GARBAGE... SHE SEES AND SMELLS SMOKE. NO CONTACT. [09/28/12 20:09:35 BKENNEDY]

*/

public class MILivingstonCountyParserTest extends BaseParserTest {
  
  public MILivingstonCountyParserTest() {
    setParser(new MILivingstonCountyParser(), "LIVINGSTON COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;ALARMF;11555 PLEASANT VIEW DR;INDIAN TRL;SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING [09/24/10 04:17:07 ECOOK]",
        "CALL:ALARMF",
        "ADDR:11555 PLEASANT VIEW DR",
        "X:INDIAN TRL",
        "INFO:SMOKE ALARMS GOING OFF IN THE HOUSE FOR THE LAST 30 MIN ON AND OFF/ NO SMOKE OR SMOKE SHOWING",
        "DATE:09/24/10",
        "TIME:04:17:07");

    doTest("T2",
        "CAD:FYI: ;UNKACC;E M36/PETTYS RD;VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE [09/23/10 21:45:06 ECOOK]",
        "CALL:UNKACC",
        "ADDR:E M36 & PETTYS RD",
        "INFO:VEHICLE HIT A POLE/ MALE RUNNING E/B FROM SCENE",
        "DATE:09/23/10",
        "TIME:21:45:06");

    doTest("T3",
        "CAD:FYI: ;CHSTPN;8422 PAWNEE TRL;SHOSHONI PASS;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal",
        "CALL:CHSTPN",
        "ADDR:8422 PAWNEE TRL",
        "X:SHOSHONI PASS",
        "INFO:72 year old, Female, Conscious, Breathing. Chest Pain (Non-Traumatic). Abnormal breathing. Cal");

    doTest("T4",
        "CAD:FYI: ;UNCON;8732 RIVER VALLEY RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.",
        "CALL:UNCON",
        "ADDR:8732 RIVER VALLEY RD",
        "INFO:63 year old, Female, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: UNCON.");

    doTest("T5",
        "CAD:FYI: ;HEMLAC;SHEHAN RD/WHITEWOOD RD;[Medical Priority Info]RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 35 year old, Female, Conscious, Brea",
        "CALL:HEMLAC",
        "ADDR:SHEHAN RD & WHITEWOOD RD",
        "INFO:35 year old, Female, Conscious, Brea");

    doTest("T6",
        "Pagecopy-Fr:CAD@lc911\nCAD:FYI: ;CHSTPN;7251 HAMBURG RD;WELLE RD;[Medical Priority Info] RESPONSE: P1 STA 1 3 4 5 6 7 8 FC FT RESPONDER S",
        "CALL:CHSTPN",
        "ADDR:7251 HAMBURG RD",
        "X:WELLE RD");

    doTest("T7",
        "CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10 20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAIN BREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK",
        "CALL:CITAF",
        "ADDR:5579 E GRAND RIVER",
        "X:WILDWOOD DR",
        "INFO:Event spawned from CITIZEN ASSIST LAW. / CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAIN BREAK / CALLER ADV OF A WATER MAIN BREAK",
        "DATE:12/10/10",
        "TIME:20:08:59");

    doTest("T8",
        "CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10 20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAIN BREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK",
        "CALL:CITAF",
        "ADDR:5579 E GRAND RIVER",
        "X:WILDWOOD DR",
        "INFO:Event spawned from CITIZEN ASSIST LAW. / CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAIN BREAK / CALLER ADV OF A WATER MAIN BREAK",
        "DATE:12/10/10",
        "TIME:20:08:59");

    doTest("T9",
        "CAD:FYI: ;UNCON;SANCTURY OF WOODLAND;7533 W GRAND RIVER;COURT ST;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 80 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Eff",
        "CALL:UNCON",
        "ADDR:7533 W GRAND RIVER",
        "PLACE:SANCTURY OF WOODLAND",
        "X:COURT ST",
        "INFO:80 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Eff");

    doTest("T10",
        "CAD:FYI: ;DIABET;31 STRATFORD LN;NEWCASTLE LN;[Medical Priority Info] RESPONSE: P1 STA 1 2 4 5 6 7 8 FC FT RESPONDER SCRIPT: 47 year old, Female, :1of2",
        "CALL:DIABET",
        "ADDR:31 STRATFORD LN",
        "X:NEWCASTLE LN",
        "INFO:47 year old, Female,");

    doTest("T11",
        "Pagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1",
        "CALL:OVDOSE",
        "ADDR:4676 KENMORE DR");

    doTest("T12",
        "firediver11+caf_=5176671194=vtext.com@gmail.comPagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;SEIZUR;131 STRATFORD LN;BELMONT LN;[Medical Priority Info]",
        "CALL:SEIZUR",
        "ADDR:131 STRATFORD LN",
        "X:BELMONT LN");

    doTest("T13",
        "Pagecopy-Fr:CAD@livingstoncounty.livco CAD:Update: ;FALL;3031 WM36;[EMS] HAS BEEN VOMITTING - DIABETIC [02/14/11 09:55:08 RLADOUCEUR] [Me",
        "CALL:FALL",
        "ADDR:3031 WM36",
        "INFO:HAS BEEN VOMITTING - DIABETIC",
        "DATE:02/14/11",
        "TIME:09:55:08");

    doTest("T14",
        "CAD:FYI: ;OPENBU;8360 MCCLEMENTS RD;DEKASSEL DR;BURNING GARBAGE ONE HOUSE EAST OF CALLER [07/01/11 19:44:56 SSTURGIS]",
        "CALL:OPENBU",
        "ADDR:8360 MCCLEMENTS RD",
        "X:DEKASSEL DR",
        "INFO:BURNING GARBAGE ONE HOUSE EAST OF CALLER",
        "DATE:07/01/11",
        "TIME:19:44:56");

    doTest("T15",
        "FYI: ;SMKOUT;CHEROKEE BEND DR/RED OAKS DR;CALLER HEARD AN EXPLOSION ON CHEROKEE BEND, DOES NOT SEE ANYTHING AT THIS TIME. SMELLS SMOKE. [09/21/11 21:53:2",
        "CALL:SMKOUT",
        "ADDR:CHEROKEE BEND DR & RED OAKS DR",
        "INFO:CALLER HEARD AN EXPLOSION ON CHEROKEE BEND, DOES NOT SEE ANYTHING AT THIS TIME. SMELLS SMOKE.");

    doTest("T16",
        "FYI: ;CHOKE;SORG RESIDENCE;2917 LANIER CT;TAHOE BLVD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 3 year old, Male, C",
        "CALL:CHOKE",
        "ADDR:2917 LANIER CT",
        "PLACE:SORG RESIDENCE",
        "X:TAHOE BLVD",
        "INFO:3 year old, Male, C");

    doTest("T17",
        "FRM:CAD@livingstoncounty.livco\nMSG:CAD:FYI: ;PIA;DORR RD/E GRAND RIVER;JEEP LIBERTY VS SILVER VAN [11/30/11 09:18:58 CWESTPHAL]",
        "CALL:PIA",
        "ADDR:DORR RD & E GRAND RIVER",
        "INFO:JEEP LIBERTY VS SILVER VAN",
        "DATE:11/30/11",
        "TIME:09:18:58");

    doTest("T18",
        "CAD:CANCEL;N NATIONAL ST/E GRAND RIVER AVE; HOWL;AT CORNER",
        "CALL:CANCEL",
        "ADDR:N NATIONAL ST & E GRAND RIVER AVE",
        "CITY:HOWELL",
        "INFO:AT CORNER");

    doTest("T19",
        "CAD:Update: ;OIOUT;REGAL RECYCLERS;645 LUCY RD;INDUSTRIAL ST;{EN34} REQ CONSUMERS [12/28/11 17:51:25 LLOWE]",
        "CALL:OIOUT",
        "ADDR:645 LUCY RD",
        "PLACE:REGAL RECYCLERS",
        "X:INDUSTRIAL ST",
        "INFO:{EN34} REQ CONSUMERS",
        "DATE:12/28/11",
        "TIME:17:51:25");

    doTest("T20",
        "CAD:FYI: ;CHOKE;5385 GREEN RD;CLYDE RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8<tel:12345678> FC FT RESPONDER SCRIPT: 78 year old, Male, Conscious, Not breathing. Choking. Not alert. Caller Statement: CHOKING ON FOOD . 1.He is n",
        "CALL:CHOKE",
        "ADDR:5385 GREEN RD",
        "X:CLYDE RD",
        "INFO:78 year old, Male, Conscious, Not breathing. Choking. Not alert. Caller Statement: CHOKING ON FOOD . 1.He is n");

    doTest("T21",
        "CAD:FYI: ;PIA;N LATSON RD/E HIGHLAND RD;RED TRUCK VS SMALL SEDAN PER CALLER SUBJECT IS NOT OK [12/28/11 19:50:00 MSPICER]",
        "CALL:PIA",
        "ADDR:N LATSON RD & E HIGHLAND RD",
        "INFO:RED TRUCK VS SMALL SEDAN PER CALLER SUBJECT IS NOT OK",
        "DATE:12/28/11",
        "TIME:19:50:00");

    doTest("T22",
        "CAD:FYI: ;SICK;10165 CARLEE JUNE DR;RUNYAN LAKE RD;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 6 7 8 FC FT RESPONDER SCRIPT: 37 year old, Male, Consci",
        "CALL:SICK",
        "ADDR:10165 CARLEE JUNE DR",
        "X:RUNYAN LAKE RD",
        "INFO:37 year old, Male, Consci");

    doTest("T23",
        "Update: ;TREEF;5117 CULVER RD;CANYON OAKS DR;CALLER STATES TREE COMPLETELY BLOCKING CULVER RD, [08/11/12 02:25:45 JMURPHY-KE]",
        "CALL:TREEF",
        "ADDR:5117 CULVER RD",
        "X:CANYON OAKS DR",
        "INFO:CALLER STATES TREE COMPLETELY BLOCKING CULVER RD,",
        "DATE:08/11/12",
        "TIME:02:25:45");

    doTest("T24",
        "Update: ;DEATH;4601 GOLF VIEW DR;GOLF VIEW CT;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 83 year old, Male, Unconsc",
        "CALL:DEATH",
        "ADDR:4601 GOLF VIEW DR",
        "X:GOLF VIEW CT",
        "INFO:83 year old, Male, Unconsc");

    doTest("T25",
        "FRM:CAD@livingstoncounty.livco\n" +
        "SUB:\n" +
        "MSG:CAD:PIA;CHILSON RD/E GRAND RIVER;[LAW] RED BID AS PIA [07/11/13 14:35:24 DDEMAN] CAR IS PINNED AGAINST THE TOR OF THE CONSTRUCTION VEHICLE [07/11/13 14:34:31 CWESTPHAL] BID [07/11/13 14:33:51 DDEMAN] BLK TRAILBLAZER VS CONSTRUCTION VEHICLE",

        "CALL:PIA",
        "ADDR:CHILSON RD & E GRAND RIVER",
        "INFO:RED BID AS PIA / CAR IS PINNED AGAINST THE TOR OF THE CONSTRUCTION VEHICLE / BID / BLK TRAILBLAZER VS CONSTRUCTION VEHICLE",
        "DATE:07/11/13",
        "TIME:14:35:24");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "CAD:DART;1279 RICKETT RD; BRTN;STRUCTURE FIRE",
        "CALL:STRUCTURE FIRE",
        "ADDR:1279 RICKETT RD",
        "CITY:BRIGHTON",
        "SRC:DART");

    doTest("T2",
        "CAD:DART;S US23/NORTH TERRITORIAL;MUTUAL AID TO OTHER FD OR EMS",
        "CALL:MUTUAL AID TO OTHER FD OR EMS",
        "ADDR:S US23 & NORTH TERRITORIAL",
        "MADDR:S US 23 & NORTH TERRITORIAL",
        "SRC:DART");
 }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "[] CAD:ALARMF;6435 THOMPSON POND DR;CANCELING FIRE ALARM [09/17/12 22:14:51 RKRAMER] MIKE REARDON RESD TX IS 313-215-6084 TRIP IS GEN FIRE ATT KEYHOLDER [09/17/12 22:13:23 RKRAMER] Aborted by Medical Priority with code: CREATED I;WHIT\r\n\n",
        "CALL:ALARMF",
        "ADDR:6435 THOMPSON POND DR",
        "CITY:WHITMORE LAKE",
        "INFO:CANCELING FIRE ALARM / MIKE REARDON RESD TX IS 313-215-6084 TRIP IS GEN FIRE ATT KEYHOLDER / Aborted by Medical Priority with code: CREATED I",
        "DATE:09/17/12",
        "TIME:22:14:51");

    doTest("T2",
        "[] CAD:FALL3;3855 RUSH LAKE RD;VAN HORN DR;[Medical Priority Info] RESPONSE: P3 STA 1 4 5 EN80 RESPONDER SCRIPT: 94 year old, Female, Conscious, Breathing. Falls. PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor);PI\r\n\n",
        "CALL:FALL3",
        "ADDR:3855 RUSH LAKE RD",
        "CITY:PINCKNEY",
        "X:VAN HORN DR",
        "INFO:94 year old, Female, Conscious, Breathing. Falls. PUBLIC ASSIST (no injuries and no priority symptoms) (On the ground or floor)");

    doTest("T3",
        "[] CAD:TRAUMA;MERRILL RD/SHELDON RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 25 year old, Male, Conscious, Breathing. Traumatic Injuries (Specific). POSSIBLY DANGEROUS body area. Caller Stateme;WHIT\r\n\n",
        "CALL:TRAUMA",
        "ADDR:MERRILL RD & SHELDON RD",
        "CITY:WHITMORE LAKE",
        "INFO:25 year old, Male, Conscious, Breathing. Traumatic Injuries (Specific). POSSIBLY DANGEROUS body area. Caller Stateme");

    doTest("T4",
        "[] CAD:FALL;10892 MONTICELLO RD;REVERE RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 86 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less tha;PINK\r\n\n",
        "CALL:REVERE RD",
        "ADDR:10892 MONTICELLO RD",
        "CITY:PINCKNEY",
        "SRC:FALL",
        "INFO:86 year old, Male, Conscious, Breathing. Falls. Not alert. Caller Statement: FALL. 1. This happened now (less tha");

    doTest("T5",
        "[] CAD:UNCON;10024 MARGARET DR;KRESS RD;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 61 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Call;LKLD\r\n\n",
        "CALL:UNCON",
        "ADDR:10024 MARGARET DR",
        "CITY:LAKELAND",
        "X:KRESS RD",
        "INFO:61 year old, Female, Unconscious, Breathing. Unconscious / Fainting (Near). Unconscious -- Effective breathing. Call");

    doTest("T6",
        "[] CAD:CO;11259 ALGONQUIN DR;WAYNE DR;CALLER WAS ADVISED TO EVACUATE HIS HOME [09/19/12 11:19:02 EPERRY] CALLER IS REQUESTING NO SIRENS [09/19/12 11:18:18 EPERRY] CALLER STATES HIS CARBON MONOXIDE ALARM IS GOING OFF. HE CHECKED THE BA;PINK\r\n\n",
        "CALL:CO",
        "ADDR:11259 ALGONQUIN DR",
        "CITY:PINCKNEY",
        "X:WAYNE DR",
        "INFO:CALLER WAS ADVISED TO EVACUATE HIS HOME / CALLER IS REQUESTING NO SIRENS / CALLER STATES HIS CARBON MONOXIDE ALARM IS GOING OFF. HE CHECKED THE BA",
        "DATE:09/19/12",
        "TIME:11:19:02");

    doTest("T7",
        "[] CAD:CVA;5269 NAVAJO TRL;CHILSON RD;[Medical Priority Update] Medical Priority reconfigured event from 28-C-06L to 28-C-06J. RESPONDER SCRIPT: Sudden loss of balance or coordination (Clear evidence of stroke (< X hours)). 6. Dispat;PINK\r\n\n",
        "CALL:CVA",
        "ADDR:5269 NAVAJO TRL",
        "CITY:PINCKNEY",
        "X:CHILSON RD",
        "INFO:Medical Priority reconfigured event from 28-C-06L to 28-C-06J. RESPONDER SCRIPT: Sudden loss of balance or coordination (Clear evidence of stroke (< X hours)). 6. Dispat");

    doTest("T8",
        "[] CAD:SEIZUR;PATHFINDER SCHOOL;2100 E M36;EMERALD CT;[EMS] PT IS BREATHING [09/19/12 14:06:52 EPERRY] [LAW] BID [09/19/12 14:06:50 DDEMAN] [Medical Priority Info] RESPONSE: P1 STA 1 4 5 7 8 RESPONDER SCRIPT: 10 year old, Female, Consciousness\r\n\n",
        "CALL:SEIZUR",
        "ADDR:2100 E M36",            // Does not map - BID undefined
        "PLACE:PATHFINDER SCHOOL",
        "X:EMERALD CT",
        "INFO:PT IS BREATHING / BID / 10 year old, Female, Consciousness",
        "DATE:09/19/12",
        "TIME:14:06:52");

    doTest("T9",
        "[] CAD:OTH;51 DOVE AVE;EAGLE ST;MICROWAVE CAUGHT FIRE -- SMOKE EVERYWHERE, MADE A NOISE , DOES NOT SEE FLAMES -- THERE WAS A SPARKING AT TEH ELECTRICAL CORD [09/19/12 17:34:41 CWESTPHAL] ;WHIT\r\n\n",
        "CALL:OTH",
        "ADDR:51 DOVE AVE",
        "CITY:WHITMORE LAKE",
        "X:EAGLE ST",
        "INFO:MICROWAVE CAUGHT FIRE -- SMOKE EVERYWHERE, MADE A NOISE , DOES NOT SEE FLAMES -- THERE WAS A SPARKING AT TEH ELECTRICAL CORD",
        "DATE:09/19/12",
        "TIME:17:34:41");

    doTest("T10",
        "CAD:FYI: ;ME;10533 KENICOTT TRL;OVERHILL DR;Event spawned from SICK PERSON. [09/26/2012 10:50:56 AHUGHES] Aborted by Medical Priority with code: CREATED IN ERROR [09/26/12 10:40:58 DONEILL] [Medical Priority Info] RESPONSE: P3 STA 1 EN80 RE",
        "CALL:ME",
        "ADDR:10533 KENICOTT TRL",
        "X:OVERHILL DR",
        "INFO:Event spawned from SICK PERSON. / Aborted by Medical Priority with code: CREATED IN ERROR",
        "DATE:09/26/2012",
        "TIME:10:50:56");

    doTest("T11",
        "CAD:OTH;8001 CHALLIS RD;KARL GREIMEL DR;THE CITY HAS BEEN NOTIFIED [09/26/12 15:47:04 LBOURBEAU] CALLER STATES THE OFFICE BUILDING IS FLOODING DUE TO A SEWAGE ISSUE. IS CONCERNED ABOUT ELECTRICAL WIRING AND DEVICES CAUSING HAZARD DUE TO ;BR",
        "CALL:OTH",
        "ADDR:8001 CHALLIS RD",
        "CITY:BRIGHTON",
        "X:KARL GREIMEL DR",
        "INFO:THE CITY HAS BEEN NOTIFIED / CALLER STATES THE OFFICE BUILDING IS FLOODING DUE TO A SEWAGE ISSUE. IS CONCERNED ABOUT ELECTRICAL WIRING AND DEVICES CAUSING HAZARD DUE TO",
        "DATE:09/26/12",
        "TIME:15:47:04");

    doTest("T12",
        "CAD:APD;3844 BAUER RD;ILA LN;Event spawned from ANIMAL COMPLAINT. [09/27/2012 08:20:42 AHUGHES] DEER STUCK IN A FENCE [09/27/12 07:46:46 AHUGHES] ;BRTN",
        "CALL:APD",
        "ADDR:3844 BAUER RD",
        "CITY:BRIGHTON",
        "X:ILA LN",
        "INFO:Event spawned from ANIMAL COMPLAINT. / DEER STUCK IN A FENCE",
        "DATE:09/27/2012",
        "TIME:08:20:42");

    doTest("T13",
        "CAD:UNCON;315 W NORTH ST;PIERCE ST;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 73 year old, Male, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: PATIENT ALT;BRTN",
        "CALL:UNCON",
        "ADDR:315 W NORTH ST",
        "CITY:BRIGHTON",
        "X:PIERCE ST",
        "INFO:73 year old, Male, Conscious, Breathing. Unconscious / Fainting (Near). Not alert. Caller Statement: PATIENT ALT");

    doTest("T14",
        "CAD:PIA;E GRAND RIVER/GOLF CLUB RD;RED STA WGN 1 MALE WITH BACK INJURIES WHT SEDAN STILL IN INTERSECTION [09/27/12 12:33:54 MREED] HHR VS BUICK - 1 VEH BLOCKING WB SIDE [09/27/12 12:33:18 DLABERDIE] ;HOWL",
        "CALL:PIA",
        "ADDR:E GRAND RIVER & GOLF CLUB RD",
        "CITY:HOWELL",
        "INFO:RED STA WGN 1 MALE WITH BACK INJURIES WHT SEDAN STILL IN INTERSECTION / HHR VS BUICK - 1 VEH BLOCKING WB SIDE",
        "DATE:09/27/12",
        "TIME:12:33:54");

    doTest("T15",
        "CAD:HEMLAC;CARETEL INN;1014 E GRAND RIVER AVE;ACORN DR;[LAW] BID [09/28/12 09:29:40 JWITHERS] [Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 92 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations",
        "CALL:HEMLAC",
        "ADDR:1014 E GRAND RIVER AVE",
        "PLACE:CARETEL INN",
        "X:ACORN DR",
        "INFO:BID / 92 year old, Male, Conscious, Breathing. Hemorrhage / Lacerations",
        "DATE:09/28/12",
        "TIME:09:29:40");

    doTest("T16",
        "CAD:UNKMED;W GRAND RIVER/HILTON RD;[Medical Priority Info] RESPONSE: P1 STA 1 4 5 7 8 RESPONDER SCRIPT: 55 year old, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Standing, sitting, moving, or tal;BRTN",
        "CALL:UNKMED",
        "ADDR:W GRAND RIVER & HILTON RD",
        "CITY:BRIGHTON",
        "INFO:55 year old, Male, Consciousness unknown, Breathing status unknown. Unknown Problem (Man Down). Standing, sitting, moving, or tal");

    doTest("T17",
        "CAD:ALARMF;5579 MOUNTAIN RD;EGGERT PL;ADVISED UNK WHY FIRE IS GOING OFF MADE CONTACT WITH KH NO FIRE NO SMOE [09/28/12 10:44:35 EPERRY] OLDFORD. 810-229-5004. FIRE ALARM. ATT KH. [09/28/12 10:44:22 EPERRY] ;BRTN",
        "CALL:ALARMF",
        "ADDR:5579 MOUNTAIN RD",
        "CITY:BRIGHTON",
        "X:EGGERT PL",
        "INFO:ADVISED UNK WHY FIRE IS GOING OFF MADE CONTACT WITH KH NO FIRE NO SMOE / OLDFORD. 810-229-5004. FIRE ALARM. ATT KH.",
        "DATE:09/28/12",
        "TIME:10:44:35");

    doTest("T18",
        "CAD:ENVIR;E GRAND RIVER AVE/E MAIN ST;[LAW] {3931} CORRIGANS EN ROUTE [09/28/12 19:33:43 JSTIDHAM] Event spawned from PDA. [09/28/2012 19:32:11 JSTIDHAM] {3931} REQ CORRIGANS W 2 WRECKERS & FIRE FOR ENVIR [09/28/12 19:32:06 JSTIDHAM];BRTN",
        "CALL:ENVIR",
        "ADDR:E GRAND RIVER AVE & E MAIN ST",
        "CITY:BRIGHTON",
        "INFO:{3931} CORRIGANS EN ROUTE / Event spawned from PDA. / {3931} REQ CORRIGANS W 2 WRECKERS & FIRE FOR ENVIR",
        "DATE:09/28/12",
        "TIME:19:33:43");

    doTest("T19",
        "CAD:SMKOUT;ETHEL BLVD/BURSON DR;CALLERS NEIGH`S ARE BURNING GARBAGE... SHE SEES AND SMELLS SMOKE. NO CONTACT. [09/28/12 20:09:35 BKENNEDY] ;BRTN",
        "CALL:SMKOUT",
        "ADDR:ETHEL BLVD & BURSON DR",
        "CITY:BRIGHTON",
        "INFO:CALLERS NEIGH`S ARE BURNING GARBAGE... SHE SEES AND SMELLS SMOKE. NO CONTACT.",
        "DATE:09/28/12",
        "TIME:20:09:35");

    doTest("T20",
        "CAD:ANBITE;1022 S HUGHES RD;WATER WILLOW DR;[EMS] UDTS: {A102} EMS & FD UNIT ACK DISP [09/29/12 09:27:47 JWITHERS] 27 YOM, BIT BY DOG HAND, AWAKE, CONS, PASSED OUT, NOW CONC, DOG IN IN PEN OUTSIDE, NOT SERIOUS BLEEDING, NOT ALERT, GREY IN C",
        "CALL:ANBITE",
        "ADDR:1022 S HUGHES RD",
        "X:WATER WILLOW DR",
        "INFO:UDTS: {A102} EMS & FD UNIT ACK DISP / 27 YOM, BIT BY DOG HAND, AWAKE, CONS, PASSED OUT, NOW CONC, DOG IN IN PEN OUTSIDE, NOT SERIOUS BLEEDING, NOT ALERT, GREY IN C",
        "DATE:09/29/12",
        "TIME:09:27:47");

    doTest("T21",
        "CAD:UNCON;4033 ST ANDREWS;[EMS] PREV HISTORY OF A HEMATOMA [09/29/12 15:34:47 EPERRY] [EMS] IN BACKYARD UNDER A TENT [09/29/12 15:34:05 EPERRY] [Medical Priority Info] Key Questions Complete RESPONSE: P1 STA 1 2 3 4 5 6 7 ;HOWL",
        "CALL:UNCON",
        "ADDR:4033 ST ANDREWS",
        "CITY:HOWELL",
        "INFO:PREV HISTORY OF A HEMATOMA / IN BACKYARD UNDER A TENT",
        "DATE:09/29/12",
        "TIME:15:34:47");

    doTest("T22",
        "CAD:SEIZUR;8501 W GRAND RIVER AVE;BEST BUY DR;[Medical Priority Info] RESPONSE: P1 STA 1 2 3 4 5 6 7 8 FC FT RESPONDER SCRIPT: 46 year old, Female, Unconscious, Breathing. Convulsions / Seizures. CONTINUOUS or MULTIPLE seizures (Epileptic o",
        "CALL:SEIZUR",
        "ADDR:8501 W GRAND RIVER AVE",  // Not mapping
        "X:BEST BUY DR",
        "INFO:46 year old, Female, Unconscious, Breathing. Convulsions / Seizures. CONTINUOUS or MULTIPLE seizures (Epileptic o");

  }
  
  public static void main(String[] args) {
    new MILivingstonCountyParserTest().generateTests("T1");
  }
}
