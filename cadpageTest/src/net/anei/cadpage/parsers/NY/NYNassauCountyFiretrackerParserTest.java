package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Nassau County, NY (Firetracker)
Contact: peter Griebel <griebz217@yahoo.com>
Sender: dispatch@firetracker.net

(FirePage) ** FFD FIRE CALL ** GENERAL PROB WITH GAS STOVE-POSS LEAK 170 JAY ST\nC/S: DEAN (E) ST / MILTON (E) ST TOA: 17:02 [FireTracker]
(FirePage) ** FFD FIRE CALL ** DISTRIC DIST CALL FOR SMOKE IN THE AREA CHURCH ST\nC/S: ARCHER ST TOA: 19:12 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL APT 72 / 3RD FLOOR / SMOKE 100 N MAIN ST\nC/S: RANDALL AVE / GRAND AVE TOA: 18:50 [FireTracker]
(FirePage) ** FFD FIRE CALL ** STILL WILLOWBROOK LA C/S: BROOKSIDE (N) AVE TOA:\n09:16 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL ELEC PROBLEM/APT 415 45 WALLACE ST C/S:\nBROOKLYN AVE / RANDALL AVE TOA: 18:26 [FireTracker]
(FirePage) ** FFD FIRE CALL ** CARBON APT 33 116 WEST END AVE C/S: RAY ST / ELINOR\nPL TOA: 11:23 [FireTracker]
(FirePage) ** FFD FIRE CALL ** GENERAL 22 PEARSALL AVE C/S: LONG BEACH (N) AVE /\nPENNSYLVANIA AVE TOA: 15:56 [FireTracker]

Contact: Nick Stein <snickphotos@gmail.com>
Sender: +15163018638
FirePage / ** FFD SIGNAL 9 ** SIG 9 MALE VOMITTING 21 NORTON ST C/S: GUY LOMBARDO\nAVE / HUDSON AVE TOA: 18:42 [FireTracker]\n
** FFD FIRE CALL ** CARBON AUTOMATIC/NO PERMIT 109 MARYLAND AVE C/S: SEAMAN (W) AVE / CALIFORNIA AVE TOA: 20:55 [FireTracker]

Contact: Louis Sabatino <lousab1@optonline.net>
Contact: Mike Torregrossa <torr393@gmail.com>
Sender: dispatch@firetracker.net
(FirePage) *FSMFD* 4/22/2011 TOA:20:47 AMBU [AMBU] 178 RINTIN ST BENRIS AVE ARM\nINJURY [FireTracker]
(FirePage) *FSMFD* 4/27/2011 TOA:21:12 AMBU [AMBU] 820 FRANKLIN PL GARDEN CITY ROAD\nDIZZY FEMALE VOMITING [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:14:59 AMBU [AMBU] 1150 HEMPSTEAD TPK RENKEN BLVD\nIN THE SICK BAY SICK FEMALE [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:19:45 AMBU [AMBU] 947 MAPLE DR COURT HOUSE ROAD\nMALE,SHORT OF BREATH [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE\nFEMALE FELL,WRIST INJURY [FireTracker]
[FirePage]  *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE FEMALE FELL,WRIST INJURY [FireTracker]
(FirePage) *FSMFD* 4/28/2011 TOA:23:14 CARB 1 [CARB] 551 CHESMAN ST NASSAU BLVD NO\nAIDED [FireTracker]
(FirePage) *FSMFD* 4/29/2011 TOA:19:21 AMBU [AMBU] 775 CORNELL ROAD ETON ROAD MALE\nFELL-HIP INJURY [FireTracker]
(FirePage) *FSMFD* 4/29/2011 TOA:21:59 MUTUAID [MAF] 125 MEACHAM AVE POST AVE\n[FireTracker]
(FirePage) FSMFD 5/2/2011 TOA:17:36 AMBU [AMBU] 766 WILLOW ROAD BIRCH ST BROKEN\nHIP [FireTracker]

Contact: J N <shadymailman@gmail.com>,Jason Ng <jasonkwng@gmail.com>
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [HOUSE] 7 ARMS AVE C/S: CAMP AVE / GARFIELD (E) ST -\nM/A 64 UPSTAIRS\n(Con' 2 of 2\nTOA:01:57 6/20/2011 Town Of: MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 119 RHODE AVE C/S: HENRY ROAD / WILLIAM ST - M/A\n65 PAIN IN LEFT\n(Con' 2 of 2\nSIDE TOA:09:46 6/21/2011 Town Of: NO MERRICK\n[FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 4 WILLIAM ST C/S: BRIARCLIFF DR / RICHARD AVE -\nM/A 65 93F\n(Con't) 2 of 2\nCARDIAC/CARDIAC HISTORY TOA:14:02 6/21/2011 Town Of: NO\nMERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [CARB] 185 E LOINES AV C/S: GRACE AVE / -DEAD END--\nM/A 64 TOA:12:20\n(Con 2 of 2\n6/22/2011 Town Of: MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 28 SURREY DR C/S: BAKER AVE / CROYDON DR - M/A 65\nFM FAINTING\n(Con't) 2 of 2\nTOA:16:41 6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] MERRICK AVE C/S: JERUSALEM AVE - M/A 65 FEMALE\nLYING IN ROADWAY\n(Con't 2 of 2\nTOA:16:52 6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] PARK AVE C/S: CAMERON AVE - M/A 65 AIDED WITH CHEST\nPAINS TOA:23:00\n(Con 2 of 2\n6/23/2011 Town Of: NO MERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1817 WILLIS AVE [ALARM PENDING] C/S: STATE ST /\nSCHERMERHORN ST -\n(C 2 of 2\nM/A 64 PERSON CHOKING TOA:12:22 6/25/2011 Town Of:\nMERRICK [FireTracker](End)
1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1766 MERRICK AVE [DUNKIN DONUTS] C/S: WEBSTER ST\n/ GARFIELD ST -\n(Co 2 of 2\nM/A 64 ASSAULT VICTIM / R/O TOA:15:51 6/25/2011 Town Of:\nNO MERRICK [FireTracker](End)
FRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] WEBSTER ST C/S: MERRICK AVE - M/A 64 TOA:11:56\n6/28/2011 Town Of: MERRICK [FireTracker

Contact: FRED DAVIS <fred.davis337@gmail.com>, "derf337@aol.com" <derf337@aol.com>
Sender: dispatch@firetracker.net
(FirePage) **WPFD** [CARBON] (CARB) [UPSTAIRS BEDROOM-NO AIDED] 141 COLLINS AVE\nWILLISTON PARK C/S:LAFAYETTE ST / CENTER ST TOA:18:12 4/4/2012\n[

Contact: Tracy Bowdwin <bowdwin32@gmail.com>
Sender: dispatch@firetracker.net
(FirePage) **RFD** CHIEF 2 [INVE] ALARM SOUNDING 68 DEBEVOISE AVE C/S:GILBERT PL /\r\nCHARLES ST TOA:02:26 [FireTracker]
(FirePage) **RFD** AUTOACC [MVA] E/B E/O 21 SOUTHERN STATE PKWY E/B C/S:NASSAU ROAD\r\n/ EXIT 21 TOA:10:37 [FireTracker]

Contact: Active911
Agency name: Mineola Vac
Location: Mineola, NY, United States
Sender: dispatch@firetracker.net

(FirePage) **MVAC SIG 9** [DIFF BREATHING] WINTHROP PULMONARY CENTER 222 N STATION\r\nPLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/19/2012 TOA: 16:12\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [25M DISORIENTED] 103 JEFFERSON AVE C/S: MAPLE PL /\r\nWILLIS AVE - C-3 DATE: 11/19/2012 TOA: 16:09 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SUITE 310/55F DIFF BREATHING] WINTHROP PULMONARY CENTER\r\n222 N STATION PLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/19/2012\r\nTOA: 15:20 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [LEFT ARM PAIN] 50 BERKLEY ROAD C/S: DROESCH PL /\r\nALBERTSON PL - D-5 DATE: 11/18/2012 TOA: 16:07 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [MALE BLEEDING] WINTHROP DIALYSIS CENTER 200 OLD COUNTRY\r\nROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/18/2012 TOA: 10:10\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [CHEST PAINS] FIRST MED 292 HERRICKS ROAD C/S: CLARISSA\r\nROAD / HELEN ROAD - B-1 DATE: 11/17/2012 TOA: 13:44 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [FEMALE DIFF BREATHING] WINTHROP DIALYSIS CENTER 200 OLD\r\nCOUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/16/2012 TOA:\r\n18:59 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [52FEM CHEST PAINS] 464 JACKSON AVE C/S: WARDWELL ROAD /\r\nHERRICKS ROAD - C-1 DATE: 11/16/2012 TOA: 16:06 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [ROOM 310/ HYPERTENSIVE MALE] 222 N STATION PLAZ C/S:\r\nMINEOLA BLVD / 3RD AVE - D-3 DATE: 11/16/2012 TOA: 15:01 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [FEMALE BLEEDING/BASEMENT] WINTHROP RADIOLOGY 120 MINEOLA\r\nBLVD C/S: 2ND ST / 1ST ST - D-3 DATE: 11/16/2012 TOA: 14:23\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [RAPID HEART RATE/SUITE 410] 120 MINEOLA BLVD C/S: 2ND ST\r\n/ 1ST ST - D-3 DATE: 11/16/2012 TOA: 10:18 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [STROKE/LOBBY] 101 LINCOLN AVE C/S: WILLIS AVE / -DEAD\r\nEND- - C-3 DATE: 11/15/2012 TOA: 14:38 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [APT 2-E/ 82 YO FELL] 135 3RD AVE C/S: HARRISON AVE / 1ST\r\nST - D-3 DATE: 11/14/2012 TOA: 20:01 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [MAN IN BLACK JEEP/SEIZURE/IN PARKING LOT] CVS 17 E\r\nJERICHO TPK C/S: ROSLYN ROAD / ROYAL AVE - B-4 DATE: 11/14/2012 TOA:\r\n17:33 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [HIP INJURY] 171 BANBURY ROAD C/S: MINEOLA BLVD / WILLIS\r\nAVE - B-3 DATE: 11/14/2012 TOA: 09:28 [FireTracker]\r\n
(FirePage) ** MVAC AUTO ACCIDENT ** W JERICHO TPK C/S: BEEBE ROAD - C-1 DATE:\r\n11/13/2012 TOA: 16:04 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SUITE 135 - REAR ENT - M/LOW BP] 200 OLD COUNTRY ROAD\r\nC/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/12/2012 TOA: 17:52\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SUITE 450/DIFF BREATHING] WINTHROP DIALYSIS CENTER 200\r\nOLD COUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/12/2012 TOA:\r\n14:13 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SUITE 330 - F/SLOW HEART RATE] 120 MINEOLA BLVD C/S: 2ND\r\nST / 1ST ST - D-3 DATE: 11/12/2012 TOA: 12:52 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [BOWELL OBSTRUCT/SUITE 31] 300 OLD COUNTRY ROAD C/S: 7TH\r\nAVE / 6TH AVE - D-2 DATE: 11/12/2012 TOA: 11:05 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [MVA] WILLIS AVE C/S: LINCOLN AVE - C-3 DATE: 11/11/2012\r\nTOA: 15:13 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [PRIEST STROKE SIDE DOOR] CORPUS CHRISTI CHURCH RECTORY\r\n155 GARFIELD AVE C/S: WILLIS AVE / MINEOLA BLVD - C-3 DATE: 11/11/2012\r\nTOA: 11:45 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SICK FEMALE] 306 MARCELLUS ROAD C/S: WALTER AVE /\r\nCOOLIDGE AVE - B-2 DATE: 11/11/2012 TOA: 10:31 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [WEAK PERSON/CODE 26] 116 WHEELER AVE C/S: NASSAU BLVD /\r\nWILLIS AVE - B-3 DATE: 11/11/2012 TOA: 10:11 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [W/B SIDE-INTOX] LIRR MINEOLA STATION W/B N/S N STATION\r\nPLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/10/2012 TOA: 19:11\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [ABDOM PAIN-USE REAR ENTRANCE] WINTHROP DIALYSIS CENTER\r\n200 OLD COUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/10/2012\r\nTOA: 18:44 [FireTracker]\r\n
(FirePage) ** MVAC AUTO ACCIDENT ** [LOWER LEG PAIN] ROSLYN ROAD C/S: 2ND (E) ST -\r\nD-4 DATE: 11/10/2012 TOA: 17:08 [FireTracker]\r\n
(FirePage) ** MVAC AUTO ACCIDENT ** MINEOLA BLVD C/S: JERICHO (W) TPK - B-3 DATE:\r\n11/10/2012 TOA: 15:03 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [DIFF BREATHING] FIRST MED 292 HERRICKS ROAD C/S:\r\nCLARISSA ROAD / HELEN ROAD - B-1 DATE: 11/10/2012 TOA: 12:19\r\n[FireTracker]\r\n
(FirePage) **MVAC SIG 9** [FEMALE FELL/ BACK INJ] 135 ROSLYN ROAD C/S: SEARING AVE\r\n/ CLINTON AVE - C-4 DATE: 11/10/2012 TOA: 06:40 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [1 AMBU TO SCENE] 56 OAK AVE C/S: INGRAHAM ST / BALDWIN\r\nROAD DATE: 11/10/2012 TOA: 02:26 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [INTOX MALE] MINEOLA FD HEADQUARTERS 170 WASHINGTON AVE\r\nC/S: WILLIS AVE / MINEOLA BLVD - B-3 DATE: 11/9/2012 TOA: 19:55\r\n[FireTracker]\r\n
(FirePage) ** MVAC AUTO ACCIDENT ** [2602 ONLY] E OLD COUNTRY ROAD C/S: BERKLEY\r\nROAD - D-5 DATE: 11/9/2012 TOA: 15:40 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [MALE VOMITITNG BLOOD] 86 ROSLYN ROAD C/S: 2ND (E) ST /\r\nLIBERTY AVE - D-4 DATE: 11/9/2012 TOA: 15:34 [FireTracker]\r\n
(FirePage) **MVAC SIG 9** [SUIT 31-LOWER LEVEL-CARDIAC] 300 OLD COUNTRY ROAD C/S:\r\n7TH AVE / 6TH AVE - D-2 DATE: 11/9/2012 TOA: 13:57 [FireTracker]\r\n

Contact: Active911
Agency name: East Williston Fire Department
Location: East Willistion, NY, United States
Sender: dispatch@firetracker.net

(FirePage) *EWFD* [9A 911] AMBU M/VOMITING 212 DERBY ST C/S:ROSLYN ROAD / HIGH ST\nHYD:197/ 12/2/2012 TOA:03:58 [FireTracker]
(FirePage) *EWFD* [CARB 1] CARB NO ILLNESS 36 DOWNING ST C/S:LATHAM LA / CONGRESS\nAVE 11/29/2012 TOA:21:41 [FireTracker]
(FirePage) *EWFD* [INVEST] WIRE 33 FAIRVIEW AVE C/S:ROSLYN ROAD / SCHOOL ST\nHYD:19/37 11/24/2012 TOA:18:11 [FireTracker]
(FirePage) *EWFD* [GEN 1] AUTO 81A178/WICKES RES 143 CHARLES ST C/S:CONGRESS AVE /\nFEATHER LA HYD:137/154 11/22/2012 TOA:15:26 [FireTracker]
(FirePage) *EWFD* [CARB 1] CARB AUTOMATIC/FAMPOGNA RES 40 FAIRVIEW AVE C/S:ROSLYN\nROAD / SCHOOL ST HYD:19/37 11/21/2012 TOA:14:12 [FireTracker]
(FirePage) *EWFD* [GEN 1] WIRES 8100 TO RESP ONLY MERITORIA DR C/S:ROBBINS DR\n11/18/2012 TOA:13:07 [FireTracker]
(FirePage) *EWFD* [GEN 1] AUTO RES SOLOEMANS 84 ROBBINS DR C/S:MERITORIA DR / - - -\nHYD:42,62/84 11/18/2012 TOA:03:32 [FireTracker]
(FirePage) *EWFD* [GEN 1] AUTO NO PERMIT/SCHIREFER RES 150 CHARLES ST C/S:CONGRESS\nAVE / FEATHER LA HYD:137/154 11/15/2012 TOA:07:07 [FireTracker]
(FirePage) *EWFD* [9A FCOM] AMBU SICK PERSON 386 ROSLYN ROAD C/S:COLEMAN DR /\nDOWNING ST HYD:OPP/387 11/13/2012 TOA:06:36 [FireTracker]
(FirePage) *EWFD* [CARB 1] CARB NO AIDED 45 ORCHARD MEADOW ROAD C/S:MEADOW LA /\nRIDGE ROAD 11/12/2012 TOA:14:05 [FireTracker]
(FirePage) *EWFD* [GEN 1] NATU OUTSIDE WEEKS ROAD C/S:GLENMORE ST 11/11/2012\nTOA:13:39 [FireTracker]
(FirePage) *EWFD* [GEN 1] NATU ODOR IN AREA 110 HILLSIDE AVE C/S:WHEATLEY AVE /\nANDREWS ROAD 11/8/2012 TOA:13:05 [FireTracker]
(FirePage) *EWFD* [GEN 1] NAT ODOR IN AREA 28 DOWNING ST C/S:ROSLYN ROAD / LATHAM\nLA HYD:17/ 11/8/2012 TOA:13:05 [FireTracker]
(FirePage) *EWFD* [9A FCOM] AMBU WEAK FEMALE 120 WEEKS ROAD C/S:GLENMORE ST /\nBENGEYFIELD DR HYD:99/109 11/8/2012 TOA:10:21 [FireTracker]
(FirePage) *EWFD* [CARB 1] CARB AUTO / KARIKAS RESD / 816532620 382 ANDREWS ROAD\nC/S:CHARLES ST / DOWNING ST 11/8/2012 TOA:08:24 [FireTracker]
(FirePage) *EWFD* [GEN 1] WIRE TREE AND WIRES DOWN 113 LEHIGH ST C/S:STRATFORD AVE\n/ -DEAD END- 11/8/2012 TOA:03:24 [FireTracker]
(FirePage) *EWFD* [GEN 1] WIRE DOWN IN THE DRIVEWAY-PERSON IN CAR 38 EAST WILLISTON\nAVE C/S:POST LA / ROSLYN ROAD HYD:18,38/54 11/7/2012 TOA:23:27\n[FireTracker]
(FirePage) *EWFD* [GEN 1] WIRES ROSLYN ROAD C/S:ROBBINS DR 11/7/2012 TOA:22:09\n[FireTracker]
(FirePage) *EWFD* [GEN 1] WIRE PRIMARY DOWN ROSLYN ROAD C/S:POST AVE 11/7/2012\nTOA:19:59 [FireTracker]
(FirePage) *EWFD* [GEN 1] WIRES AND TREE 120 CHARLES ST C/S:CONGRESS AVE / COLUMBUS\nPKWY HYD:120/ 11/7/2012 TOA:18:49 [FireTracker]
(FirePage) *EWFD* [CARB 1] CARB AUTOMATIC/FAMPOGNA RES 40 FAIRVIEW AVE C/S:ROSLYN\r\nROAD / SCHOOL ST HYD:19/37 11/21/2012 TOA:14:12 [FireTracker]\r\n
(FirePage) *EWFD* [GEN 1] AUTO 81A178/WICKES RES 143 CHARLES ST C/S:CONGRESS AVE /\r\nFEATHER LA HYD:137/154 11/22/2012 TOA:15:26 [FireTracker]\r\n
(FirePage) *EWFD* [INVEST] WIRE 33 FAIRVIEW AVE C/S:ROSLYN ROAD / SCHOOL ST\r\nHYD:19/37 11/24/2012 TOA:18:11 [FireTracker]\r\n
(FirePage) *EWFD* [CARB 1] CARB NO ILLNESS 36 DOWNING ST C/S:LATHAM LA / CONGRESS\r\nAVE 11/29/2012 TOA:21:41 [FireTracker]\r\n
(FirePage) *EWFD* [9A 911] AMBU M/VOMITING 212 DERBY ST C/S:ROSLYN ROAD / HIGH ST\r\nHYD:197/ 12/2/2012 TOA:03:58 [FireTracker]\r\n

*/

public class NYNassauCountyFiretrackerParserTest extends BaseParserTest {
  
  public NYNassauCountyFiretrackerParserTest() {
    setParser(new NYNassauCountyFiretrackerParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testFFDParser() {

    doTest("T1",
        "(FirePage) ** FFD FIRE CALL ** GENERAL PROB WITH GAS STOVE-POSS LEAK 170 JAY ST\nC/S: DEAN (E) ST / MILTON (E) ST TOA: 17:02 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL PROB WITH GAS STOVE-POSS LEAK",
        "ADDR:170 JAY ST",
        "X:DEAN (E) ST / MILTON (E) ST",
        "TIME:17:02");

    doTest("T2",
        "(FirePage) ** FFD FIRE CALL ** DISTRIC DIST CALL FOR SMOKE IN THE AREA CHURCH ST\nC/S: ARCHER ST TOA: 19:12 [FireTracker]",
        "SRC:FFD",
        "CALL:DISTRIC DIST CALL FOR SMOKE IN THE AREA",
        "ADDR:CHURCH ST",
        "MADDR:CHURCH ST & ARCHER ST",
        "X:ARCHER ST",
        "TIME:19:12");

    doTest("T3",
        "(FirePage) ** FFD FIRE CALL ** GENERAL APT 72 / 3RD FLOOR / SMOKE 100 N MAIN ST\nC/S: RANDALL AVE / GRAND AVE TOA: 18:50 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL  / 3RD FLOOR / SMOKE",
        "APT:72",
        "ADDR:100 N MAIN ST",
        "X:RANDALL AVE / GRAND AVE",
        "TIME:18:50");

    doTest("T4",
        "(FirePage) ** FFD FIRE CALL ** STILL WILLOWBROOK LA C/S: BROOKSIDE (N) AVE TOA:\n09:16 [FireTracker]",
        "SRC:FFD",
        "CALL:STILL",
        "ADDR:WILLOWBROOK LA",
        "MADDR:WILLOWBROOK LN & BROOKSIDE AVE",
        "X:BROOKSIDE (N) AVE",
        "TIME:09:16");

    doTest("T5",
        "(FirePage) ** FFD FIRE CALL ** GENERAL ELEC PROBLEM/APT 415 45 WALLACE ST C/S:\nBROOKLYN AVE / RANDALL AVE TOA: 18:26 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL ELEC PROBLEM/",
        "APT:415",
        "ADDR:45 WALLACE ST",
        "X:BROOKLYN AVE / RANDALL AVE",
        "TIME:18:26");


    doTest("T6",
        "(FirePage) ** FFD FIRE CALL ** CARBON APT 33 116 WEST END AVE C/S: RAY ST / ELINOR\nPL TOA: 11:23 [FireTracker]",
        "SRC:FFD",
        "CALL:CARBON",
        "ADDR:116 WEST END AVE",
        "APT:33",
        "X:RAY ST / ELINOR PL",
        "TIME:11:23");

    doTest("T7",
        "(FirePage) ** FFD FIRE CALL ** GENERAL 22 PEARSALL AVE C/S: LONG BEACH (N) AVE /\nPENNSYLVANIA AVE TOA: 15:56 [FireTracker]",
        "SRC:FFD",
        "CALL:GENERAL",
        "ADDR:22 PEARSALL AVE",
        "X:LONG BEACH (N) AVE / PENNSYLVANIA AVE",
        "TIME:15:56");

    doTest("T8",
        "FirePage / ** FFD SIGNAL 9 ** SIG 9 MALE VOMITTING 21 NORTON ST C/S: GUY LOMBARDO\nAVE / HUDSON AVE TOA: 18:42 [FireTracker]\n",
        "SRC:FFD",
        "CALL:SIG 9 MALE VOMITTING",
        "ADDR:21 NORTON ST",
        "X:GUY LOMBARDO AVE / HUDSON AVE",
        "TIME:18:42");

    doTest("T9",
        "FirePage / ** FFD SIGNAL 9 ** SIG 9 MALE VOMITTING 21 NORTON ST C/S: GUY LOMBARDO\nAVE / HUDSON AVE TOA: 18:42 [FireTracker]\n",
        "SRC:FFD",
        "CALL:SIG 9 MALE VOMITTING",
        "ADDR:21 NORTON ST",
        "X:GUY LOMBARDO AVE / HUDSON AVE",
        "TIME:18:42");

    doTest("T10",
        "** FFD FIRE CALL ** CARBON AUTOMATIC/NO PERMIT 109 MARYLAND AVE C/S: SEAMAN (W) AVE / CALIFORNIA AVE TOA: 20:55 [FireTracker]",
        "SRC:FFD",
        "CALL:CARBON AUTOMATIC/NO PERMIT",
        "ADDR:109 MARYLAND AVE",
        "X:SEAMAN (W) AVE / CALIFORNIA AVE",
        "TIME:20:55");
 
  }
  
  @Test
  public void testFSMFDParser() {

    doTest("T1",
        "(FirePage) *FSMFD* 4/22/2011 TOA:20:47 AMBU [AMBU] 178 RINTIN ST BENRIS AVE ARM\nINJURY [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/22/2011",
        "TIME:20:47",
        "CALL:AMBU",
        "ADDR:178 RINTIN ST",
        "X:BENRIS AVE",
        "INFO:ARM INJURY");

    doTest("T2",
        "(FirePage) *FSMFD* 4/27/2011 TOA:21:12 AMBU [AMBU] 820 FRANKLIN PL GARDEN CITY ROAD\nDIZZY FEMALE VOMITING [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/27/2011",
        "TIME:21:12",
        "CALL:AMBU",
        "ADDR:820 FRANKLIN PL",
        "X:GARDEN CITY ROAD",
        "INFO:DIZZY FEMALE VOMITING");

    doTest("T3",
        "(FirePage) *FSMFD* 4/28/2011 TOA:14:59 AMBU [AMBU] 1150 HEMPSTEAD TPK RENKEN BLVD\nIN THE SICK BAY SICK FEMALE [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/28/2011",
        "TIME:14:59",
        "CALL:AMBU",
        "ADDR:1150 HEMPSTEAD TPK",
        "X:RENKEN BLVD",
        "INFO:IN THE SICK BAY SICK FEMALE");

    doTest("T4",
        "(FirePage) *FSMFD* 4/28/2011 TOA:19:45 AMBU [AMBU] 947 MAPLE DR COURT HOUSE ROAD\nMALE,SHORT OF BREATH [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/28/2011",
        "TIME:19:45",
        "CALL:AMBU",
        "ADDR:947 MAPLE DR",
        "X:COURT HOUSE ROAD",
        "INFO:MALE,SHORT OF BREATH");

    doTest("T5",
        "(FirePage) *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE\nFEMALE FELL,WRIST INJURY [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/28/2011",
        "TIME:22:16",
        "CALL:AMBU",
        "ADDR:1031 MOSEFAN ST",
        "X:WILLIAM AVE",
        "INFO:FEMALE FELL,WRIST INJURY");

    doTest("T6",
        "[FirePage]  *FSMFD* 4/28/2011 TOA:22:16 AMBU [AMBU] 1031 MOSEFAN ST WILLIAM AVE FEMALE FELL,WRIST INJURY [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/28/2011",
        "TIME:22:16",
        "CALL:AMBU",
        "ADDR:1031 MOSEFAN ST",
        "X:WILLIAM AVE",
        "INFO:FEMALE FELL,WRIST INJURY");

    doTest("T7",
        "(FirePage) *FSMFD* 4/28/2011 TOA:23:14 CARB 1 [CARB] 551 CHESMAN ST NASSAU BLVD NO\nAIDED [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/28/2011",
        "TIME:23:14",
        "CALL:CARB 1",
        "ADDR:551 CHESMAN ST",
        "X:NASSAU BLVD",
        "INFO:NO AIDED");

    doTest("T8",
        "(FirePage) *FSMFD* 4/29/2011 TOA:19:21 AMBU [AMBU] 775 CORNELL ROAD ETON ROAD MALE\nFELL-HIP INJURY [FireTracker]",
        "SRC:FSMFD",
        "DATE:4/29/2011",
        "TIME:19:21",
        "CALL:AMBU",
        "ADDR:775 CORNELL ROAD",
        "X:ETON ROAD",
        "INFO:MALE FELL-HIP INJURY");

    doTest("T9",
        "(FirePage) *FSMFD* 4/29/2011 TOA:21:59 MUTUAID [MAF] 125 MEACHAM AVE POST AVE\n[FireTracker]",
        "SRC:FSMFD",
        "DATE:4/29/2011",
        "TIME:21:59",
        "CALL:MUTUAID",
        "ADDR:125 MEACHAM AVE",
        "X:POST AVE");

    doTest("T10",
        "(FirePage) FSMFD 5/2/2011 TOA:17:36 AMBU [AMBU] 766 WILLOW ROAD BIRCH ST BROKEN\nHIP [FireTracker]",
        "SRC:FSMFD",
        "DATE:5/2/2011",
        "TIME:17:36",
        "CALL:AMBU",
        "ADDR:766 WILLOW ROAD",
        "X:BIRCH ST",
        "INFO:BROKEN HIP");
    
  }
  
  @Test
  public void testNMFDParser() {

    doTest("T1",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [HOUSE] 7 ARMS AVE C/S: CAMP AVE / GARFIELD (E) ST -\nM/A 64 UPSTAIRS\n(Con' 2 of 2\nTOA:01:57 6/20/2011 Town Of: MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:GENERAL HOUSE - M/A 64 UPSTAIRS",
        "ADDR:7 ARMS AVE",
        "X:CAMP AVE / GARFIELD (E) ST",
        "TIME:01:57",
        "DATE:6/20/2011",
        "CITY:MERRICK");

    doTest("T2",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 119 RHODE AVE C/S: HENRY ROAD / WILLIAM ST - M/A\n65 PAIN IN LEFT\n(Con' 2 of 2\nSIDE TOA:09:46 6/21/2011 Town Of: NO MERRICK\n[FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 65 PAIN IN LEFT SIDE",
        "ADDR:119 RHODE AVE",
        "X:HENRY ROAD / WILLIAM ST",
        "TIME:09:46", 
        "DATE:6/21/2011",
        "CITY:NO MERRICK");

    doTest("T3",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 4 WILLIAM ST C/S: BRIARCLIFF DR / RICHARD AVE -\nM/A 65 93F\n(Con't) 2 of 2\nCARDIAC/CARDIAC HISTORY TOA:14:02 6/21/2011 Town Of: NO\nMERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 65 93F CARDIAC/CARDIAC HISTORY",
        "ADDR:4 WILLIAM ST",
        "X:BRIARCLIFF DR / RICHARD AVE",
        "TIME:14:02",
        "DATE:6/21/2011",
        "CITY:NO MERRICK");
    
    doTest("T4",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [GENERAL] [CARB] 185 E LOINES AV C/S: GRACE AVE / -DEAD END--\nM/A 64 TOA:12:20\n(Con 2 of 2\n6/22/2011 Town Of: MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:GENERAL CARB - M/A 64",
        "ADDR:185 E LOINES AV",
        "MADDR:185 E LOINES AVE",
        "X:GRACE AVE / DEAD END",
        "TIME:12:20",
        "DATE:6/22/2011",
        "CITY:MERRICK");

    doTest("T5",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 28 SURREY DR C/S: BAKER AVE / CROYDON DR - M/A 65\nFM FAINTING\n(Con't) 2 of 2\nTOA:16:41 6/23/2011 Town Of: NO MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 65 FM FAINTING",
        "ADDR:28 SURREY DR",
        "X:BAKER AVE / CROYDON DR",
        "TIME:16:41",
        "DATE:6/23/2011",
        "CITY:NO MERRICK");

    doTest("T6",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] MERRICK AVE C/S: JERUSALEM AVE - M/A 65 FEMALE\nLYING IN ROADWAY\n(Con't 2 of 2\nTOA:16:52 6/23/2011 Town Of: NO MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 65 FEMALE LYING IN ROADWAY",
        "ADDR:MERRICK AVE",
        "MADDR:MERRICK AVE & JERUSALEM AVE",
        "X:JERUSALEM AVE",
        "TIME:16:52", 
        "DATE:6/23/2011",
        "CITY:NO MERRICK");

    doTest("T7",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] PARK AVE C/S: CAMERON AVE - M/A 65 AIDED WITH CHEST\nPAINS TOA:23:00\n(Con 2 of 2\n6/23/2011 Town Of: NO MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:MVA - M/A 65 AIDED WITH CHEST PAINS",
        "ADDR:PARK AVE",
        "MADDR:PARK AVE & CAMERON AVE",
        "X:CAMERON AVE",
        "TIME:23:00",
        "DATE:6/23/2011",
        "CITY:NO MERRICK");

    doTest("T8",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1817 WILLIS AVE [ALARM PENDING] C/S: STATE ST /\nSCHERMERHORN ST -\n(C 2 of 2\nM/A 64 PERSON CHOKING TOA:12:22 6/25/2011 Town Of:\nMERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 64 PERSON CHOKING",
        "ADDR:1817 WILLIS AVE",
        "PLACE:[ALARM PENDING]",
        "X:STATE ST / SCHERMERHORN ST",
        "TIME:12:22", 
        "DATE:6/25/2011",
        "CITY:MERRICK");

    doTest("T9",
        "1 of 2\nFRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [AMBU] [AMBU] 1766 MERRICK AVE [DUNKIN DONUTS] C/S: WEBSTER ST\n/ GARFIELD ST -\n(Co 2 of 2\nM/A 64 ASSAULT VICTIM / R/O TOA:15:51 6/25/2011 Town Of:\nNO MERRICK [FireTracker](End)",
        "SRC:NMFD",
        "CALL:AMBU - M/A 64 ASSAULT VICTIM / R/O",
        "ADDR:1766 MERRICK AVE",
        "PLACE:[DUNKIN DONUTS]",
        "X:WEBSTER ST / GARFIELD ST",
        "TIME:15:51",
        "DATE:6/25/2011",
        "CITY:NO MERRICK");

    doTest("T10",
        "FRM:dispatch@firetracker.net\nSUBJ:FirePage\nMSG:**NMFD** [MVA] [MVA] WEBSTER ST C/S: MERRICK AVE - M/A 64 TOA:11:56\n6/28/2011 Town Of: MERRICK [FireTracker",
        "SRC:NMFD",
        "CALL:MVA - M/A 64",
        "ADDR:WEBSTER ST",
        "MADDR:WEBSTER ST & MERRICK AVE",
        "X:MERRICK AVE",
        "TIME:11:56", 
        "DATE:6/28/2011",
        "CITY:MERRICK");
 }
  
  @Test
  public void testWPFDParser() {

    doTest("T1",
        "(FirePage) **WPFD** [CARBON] (CARB) [UPSTAIRS BEDROOM-NO AIDED] 141 COLLINS AVE\n" +
        "WILLISTON PARK C/S:LAFAYETTE ST / CENTER ST TOA:18:12 4/4/2012\n" +
        "[",

        "SRC:WPFD",
        "CALL:CARBON (CARB) UPSTAIRS BEDROOM-NO AIDED",
        "ADDR:141 COLLINS AVE",
        "PLACE:WILLISTON PARK",
        "X:LAFAYETTE ST / CENTER ST",
        "TIME:18:12",
        "DATE:4/4/2012");

  }
  
  @Test
  public void testTracyBodwin() {

    doTest("T1",
        "(FirePage) **RFD** CHIEF 2 [INVE] ALARM SOUNDING 68 DEBEVOISE AVE C/S:GILBERT PL /\r\nCHARLES ST TOA:02:26 [FireTracker]",
        "SRC:RFD",
        "CALL:CHIEF 2 [INVE] ALARM SOUNDING",
        "ADDR:68 DEBEVOISE AVE",
        "X:GILBERT PL / CHARLES ST",
        "TIME:02:26");

    doTest("T2",
        "(FirePage) **RFD** AUTOACC [MVA] E/B E/O 21 SOUTHERN STATE PKWY E/B C/S:NASSAU ROAD\r\n/ EXIT 21 TOA:10:37 [FireTracker]",
        "SRC:RFD",
        "CALL:AUTOACC [MVA] EB E/O",
        "ADDR:21 SOUTHERN STATE PKWY EB",
        "MADDR:21 SOUTHERN STATE PKWY",
        "X:NASSAU ROAD / EXIT 21",
        "TIME:10:37");

  }
  
  @Test
  public void testMinolaVac() {

    doTest("T1",
        "(FirePage) **MVAC SIG 9** [DIFF BREATHING] WINTHROP PULMONARY CENTER 222 N STATION\r\n" +
        "PLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/19/2012 TOA: 16:12\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - DIFF BREATHING",
        "ADDR:222 N STATION PLAZ",
        "MADDR:222 N STATION PLAZA",
        "PLACE:WINTHROP PULMONARY CENTER",
        "X:MINEOLA BLVD / 3RD AVE",
        "MAP:D-3",
        "DATE:11/19/2012",
        "TIME:16:12");

    doTest("T2",
        "(FirePage) **MVAC SIG 9** [25M DISORIENTED] 103 JEFFERSON AVE C/S: MAPLE PL /\r\n" +
        "WILLIS AVE - C-3 DATE: 11/19/2012 TOA: 16:09 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - 25M DISORIENTED",
        "ADDR:103 JEFFERSON AVE",
        "X:MAPLE PL / WILLIS AVE",
        "MAP:C-3",
        "DATE:11/19/2012",
        "TIME:16:09");

    doTest("T3",
        "(FirePage) **MVAC SIG 9** [SUITE 310/55F DIFF BREATHING] WINTHROP PULMONARY CENTER\r\n" +
        "222 N STATION PLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/19/2012\r\n" +
        "TOA: 15:20 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SUITE 310/55F DIFF BREATHING",
        "ADDR:222 N STATION PLAZ",
        "MADDR:222 N STATION PLAZA",
        "PLACE:WINTHROP PULMONARY CENTER",
        "X:MINEOLA BLVD / 3RD AVE",
        "MAP:D-3",
        "DATE:11/19/2012",
        "TIME:15:20");

    doTest("T4",
        "(FirePage) **MVAC SIG 9** [LEFT ARM PAIN] 50 BERKLEY ROAD C/S: DROESCH PL /\r\n" +
        "ALBERTSON PL - D-5 DATE: 11/18/2012 TOA: 16:07 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - LEFT ARM PAIN",
        "ADDR:50 BERKLEY ROAD",
        "X:DROESCH PL / ALBERTSON PL",
        "MAP:D-5",
        "DATE:11/18/2012",
        "TIME:16:07");

    doTest("T5",
        "(FirePage) **MVAC SIG 9** [MALE BLEEDING] WINTHROP DIALYSIS CENTER 200 OLD COUNTRY\r\n" +
        "ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/18/2012 TOA: 10:10\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - MALE BLEEDING",
        "ADDR:200 OLD COUNTRY ROAD",
        "PLACE:WINTHROP DIALYSIS CENTER",
        "X:MAIN ST / MINEOLA BLVD",
        "MAP:D-3",
        "DATE:11/18/2012",
        "TIME:10:10");

    doTest("T6",
        "(FirePage) **MVAC SIG 9** [CHEST PAINS] FIRST MED 292 HERRICKS ROAD C/S: CLARISSA\r\n" +
        "ROAD / HELEN ROAD - B-1 DATE: 11/17/2012 TOA: 13:44 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - CHEST PAINS",
        "ADDR:292 HERRICKS ROAD",
        "PLACE:FIRST MED",
        "X:CLARISSA ROAD / HELEN ROAD",
        "MAP:B-1",
        "DATE:11/17/2012",
        "TIME:13:44");

    doTest("T7",
        "(FirePage) **MVAC SIG 9** [FEMALE DIFF BREATHING] WINTHROP DIALYSIS CENTER 200 OLD\r\n" +
        "COUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/16/2012 TOA:\r\n" +
        "18:59 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - FEMALE DIFF BREATHING",
        "ADDR:200 OLD COUNTRY ROAD",
        "PLACE:WINTHROP DIALYSIS CENTER",
        "X:MAIN ST / MINEOLA BLVD",
        "MAP:D-3",
        "DATE:11/16/2012",
        "TIME:18:59");

    doTest("T8",
        "(FirePage) **MVAC SIG 9** [52FEM CHEST PAINS] 464 JACKSON AVE C/S: WARDWELL ROAD /\r\n" +
        "HERRICKS ROAD - C-1 DATE: 11/16/2012 TOA: 16:06 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - 52FEM CHEST PAINS",
        "ADDR:464 JACKSON AVE",
        "X:WARDWELL ROAD / HERRICKS ROAD",
        "MAP:C-1",
        "DATE:11/16/2012",
        "TIME:16:06");

    doTest("T9",
        "(FirePage) **MVAC SIG 9** [ROOM 310/ HYPERTENSIVE MALE] 222 N STATION PLAZ C/S:\r\n" +
        "MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/16/2012 TOA: 15:01 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - ROOM 310/ HYPERTENSIVE MALE",
        "ADDR:222 N STATION PLAZ",
        "MADDR:222 N STATION PLAZA",
        "X:MINEOLA BLVD / 3RD AVE",
        "MAP:D-3",
        "DATE:11/16/2012",
        "TIME:15:01");

    doTest("T10",
        "(FirePage) **MVAC SIG 9** [FEMALE BLEEDING/BASEMENT] WINTHROP RADIOLOGY 120 MINEOLA\r\n" +
        "BLVD C/S: 2ND ST / 1ST ST - D-3 DATE: 11/16/2012 TOA: 14:23\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - FEMALE BLEEDING/BASEMENT",
        "ADDR:120 MINEOLA BLVD",
        "PLACE:WINTHROP RADIOLOGY",
        "X:2ND ST / 1ST ST",
        "MAP:D-3",
        "DATE:11/16/2012",
        "TIME:14:23");

    doTest("T11",
        "(FirePage) **MVAC SIG 9** [RAPID HEART RATE/SUITE 410] 120 MINEOLA BLVD C/S: 2ND ST\r\n" +
        "/ 1ST ST - D-3 DATE: 11/16/2012 TOA: 10:18 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - RAPID HEART RATE/SUITE 410",
        "ADDR:120 MINEOLA BLVD",
        "X:2ND ST / 1ST ST",
        "MAP:D-3",
        "DATE:11/16/2012",
        "TIME:10:18");

    doTest("T12",
        "(FirePage) **MVAC SIG 9** [STROKE/LOBBY] 101 LINCOLN AVE C/S: WILLIS AVE / -DEAD\r\n" +
        "END- - C-3 DATE: 11/15/2012 TOA: 14:38 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - STROKE/LOBBY",
        "ADDR:101 LINCOLN AVE",
        "X:WILLIS AVE / DEAD END",
        "MAP:C-3",
        "DATE:11/15/2012",
        "TIME:14:38");

    doTest("T13",
        "(FirePage) **MVAC SIG 9** [APT 2-E/ 82 YO FELL] 135 3RD AVE C/S: HARRISON AVE / 1ST\r\n" +
        "ST - D-3 DATE: 11/14/2012 TOA: 20:01 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - / 82 YO FELL",
        "ADDR:135 3RD AVE",
        "APT:2-E",
        "X:HARRISON AVE / 1ST ST",
        "MAP:D-3",
        "DATE:11/14/2012",
        "TIME:20:01");

    doTest("T14",
        "(FirePage) **MVAC SIG 9** [MAN IN BLACK JEEP/SEIZURE/IN PARKING LOT] CVS 17 E\r\n" +
        "JERICHO TPK C/S: ROSLYN ROAD / ROYAL AVE - B-4 DATE: 11/14/2012 TOA:\r\n" +
        "17:33 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - MAN IN BLACK JEEP/SEIZURE/IN PARKING LOT",
        "ADDR:17 E JERICHO TPK",
        "PLACE:CVS",
        "X:ROSLYN ROAD / ROYAL AVE",
        "MAP:B-4",
        "DATE:11/14/2012",
        "TIME:17:33");

    doTest("T15",
        "(FirePage) **MVAC SIG 9** [HIP INJURY] 171 BANBURY ROAD C/S: MINEOLA BLVD / WILLIS\r\n" +
        "AVE - B-3 DATE: 11/14/2012 TOA: 09:28 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - HIP INJURY",
        "ADDR:171 BANBURY ROAD",
        "X:MINEOLA BLVD / WILLIS AVE",
        "MAP:B-3",
        "DATE:11/14/2012",
        "TIME:09:28");

    doTest("T16",
        "(FirePage) ** MVAC AUTO ACCIDENT ** W JERICHO TPK C/S: BEEBE ROAD - C-1 DATE:\r\n11/13/2012 TOA: 16:04 [FireTracker]\r\n",
        "SRC:MVAC",
        "CALL:AUTO ACCIDENT / W",
        "ADDR:JERICHO TPK",
        "MADDR:JERICHO TPK & BEEBE ROAD",
        "X:BEEBE ROAD",
        "MAP:C-1",
        "DATE:11/13/2012",
        "TIME:16:04");

    doTest("T17",
        "(FirePage) **MVAC SIG 9** [SUITE 135 - REAR ENT - M/LOW BP] 200 OLD COUNTRY ROAD\r\n" +
        "C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/12/2012 TOA: 17:52\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SUITE 135 - REAR ENT - M/LOW BP",
        "ADDR:200 OLD COUNTRY ROAD",
        "X:MAIN ST / MINEOLA BLVD",
        "MAP:D-3",
        "DATE:11/12/2012",
        "TIME:17:52");

    doTest("T18",
        "(FirePage) **MVAC SIG 9** [SUITE 450/DIFF BREATHING] WINTHROP DIALYSIS CENTER 200\r\n" +
        "OLD COUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/12/2012 TOA:\r\n" +
        "14:13 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SUITE 450/DIFF BREATHING",
        "ADDR:200 OLD COUNTRY ROAD",
        "PLACE:WINTHROP DIALYSIS CENTER",
        "X:MAIN ST / MINEOLA BLVD",
        "MAP:D-3",
        "DATE:11/12/2012",
        "TIME:14:13");

    doTest("T19",
        "(FirePage) **MVAC SIG 9** [SUITE 330 - F/SLOW HEART RATE] 120 MINEOLA BLVD C/S: 2ND\r\n" +
        "ST / 1ST ST - D-3 DATE: 11/12/2012 TOA: 12:52 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SUITE 330 - F/SLOW HEART RATE",
        "ADDR:120 MINEOLA BLVD",
        "X:2ND ST / 1ST ST",
        "MAP:D-3",
        "DATE:11/12/2012",
        "TIME:12:52");

    doTest("T20",
        "(FirePage) **MVAC SIG 9** [BOWELL OBSTRUCT/SUITE 31] 300 OLD COUNTRY ROAD C/S: 7TH\r\n" +
        "AVE / 6TH AVE - D-2 DATE: 11/12/2012 TOA: 11:05 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - BOWELL OBSTRUCT/SUITE 31",
        "ADDR:300 OLD COUNTRY ROAD",
        "X:7TH AVE / 6TH AVE",
        "MAP:D-2",
        "DATE:11/12/2012",
        "TIME:11:05");

    doTest("T21",
        "(FirePage) **MVAC SIG 9** [MVA] WILLIS AVE C/S: LINCOLN AVE - C-3 DATE: 11/11/2012\r\nTOA: 15:13 [FireTracker]\r\n",
        "SRC:MVAC",
        "CALL:SIG 9 - MVA",
        "ADDR:WILLIS AVE",
        "MADDR:WILLIS AVE & LINCOLN AVE",
        "X:LINCOLN AVE",
        "MAP:C-3",
        "DATE:11/11/2012",
        "TIME:15:13");

    doTest("T22",
        "(FirePage) **MVAC SIG 9** [PRIEST STROKE SIDE DOOR] CORPUS CHRISTI CHURCH RECTORY\r\n" +
        "155 GARFIELD AVE C/S: WILLIS AVE / MINEOLA BLVD - C-3 DATE: 11/11/2012\r\n" +
        "TOA: 11:45 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - PRIEST STROKE SIDE DOOR",
        "ADDR:155 GARFIELD AVE",
        "PLACE:CORPUS CHRISTI CHURCH RECTORY",
        "X:WILLIS AVE / MINEOLA BLVD",
        "MAP:C-3",
        "DATE:11/11/2012",
        "TIME:11:45");

    doTest("T23",
        "(FirePage) **MVAC SIG 9** [SICK FEMALE] 306 MARCELLUS ROAD C/S: WALTER AVE /\r\n" +
        "COOLIDGE AVE - B-2 DATE: 11/11/2012 TOA: 10:31 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SICK FEMALE",
        "ADDR:306 MARCELLUS ROAD",
        "X:WALTER AVE / COOLIDGE AVE",
        "MAP:B-2",
        "DATE:11/11/2012",
        "TIME:10:31");

    doTest("T24",
        "(FirePage) **MVAC SIG 9** [WEAK PERSON/CODE 26] 116 WHEELER AVE C/S: NASSAU BLVD /\r\n" +
        "WILLIS AVE - B-3 DATE: 11/11/2012 TOA: 10:11 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - WEAK PERSON/CODE 26",
        "ADDR:116 WHEELER AVE",
        "X:NASSAU BLVD / WILLIS AVE",
        "MAP:B-3",
        "DATE:11/11/2012",
        "TIME:10:11");

    doTest("T25",
        "(FirePage) **MVAC SIG 9** [W/B SIDE-INTOX] LIRR MINEOLA STATION W/B N/S N STATION\r\n" +
        "PLAZ C/S: MINEOLA BLVD / 3RD AVE - D-3 DATE: 11/10/2012 TOA: 19:11\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - WB SIDE-INTOX",
        "ADDR:N STATION PLAZ",
        "MADDR:N STATION PLAZA & MINEOLA BLVD",
        "PLACE:LIRR MINEOLA STATION WB N/S",
        "X:MINEOLA BLVD / 3RD AVE",
        "MAP:D-3",
        "DATE:11/10/2012",
        "TIME:19:11");

    doTest("T26",
        "(FirePage) **MVAC SIG 9** [ABDOM PAIN-USE REAR ENTRANCE] WINTHROP DIALYSIS CENTER\r\n" +
        "200 OLD COUNTRY ROAD C/S: MAIN ST / MINEOLA BLVD - D-3 DATE: 11/10/2012\r\n" +
        "TOA: 18:44 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - ABDOM PAIN-USE REAR ENTRANCE",
        "ADDR:200 OLD COUNTRY ROAD",
        "PLACE:WINTHROP DIALYSIS CENTER",
        "X:MAIN ST / MINEOLA BLVD",
        "MAP:D-3",
        "DATE:11/10/2012",
        "TIME:18:44");

    doTest("T27",
        "(FirePage) ** MVAC AUTO ACCIDENT ** [LOWER LEG PAIN] ROSLYN ROAD C/S: 2ND (E) ST -\r\n" +
        "D-4 DATE: 11/10/2012 TOA: 17:08 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:AUTO ACCIDENT - LOWER LEG PAIN",
        "ADDR:ROSLYN ROAD",
        "MADDR:ROSLYN ROAD & 2ND ST",
        "X:2ND (E) ST",
        "MAP:D-4",
        "DATE:11/10/2012",
        "TIME:17:08");

    doTest("T28",
        "(FirePage) ** MVAC AUTO ACCIDENT ** MINEOLA BLVD C/S: JERICHO (W) TPK - B-3 DATE:\r\n11/10/2012 TOA: 15:03 [FireTracker]\r\n",
        "SRC:MVAC",
        "CALL:AUTO ACCIDENT / MINEOLA BLVD",
        "ADDR:JERICHO (W) TPK",
        "MADDR:JERICHO TPK",
        "MAP:B-3",
        "DATE:11/10/2012",
        "TIME:15:03");

    doTest("T29",
        "(FirePage) **MVAC SIG 9** [DIFF BREATHING] FIRST MED 292 HERRICKS ROAD C/S:\r\n" +
        "CLARISSA ROAD / HELEN ROAD - B-1 DATE: 11/10/2012 TOA: 12:19\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - DIFF BREATHING",
        "ADDR:292 HERRICKS ROAD",
        "PLACE:FIRST MED",
        "X:CLARISSA ROAD / HELEN ROAD",
        "MAP:B-1",
        "DATE:11/10/2012",
        "TIME:12:19");

    doTest("T30",
        "(FirePage) **MVAC SIG 9** [FEMALE FELL/ BACK INJ] 135 ROSLYN ROAD C/S: SEARING AVE\r\n" +
        "/ CLINTON AVE - C-4 DATE: 11/10/2012 TOA: 06:40 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - FEMALE FELL/ BACK INJ",
        "ADDR:135 ROSLYN ROAD",
        "X:SEARING AVE / CLINTON AVE",
        "MAP:C-4",
        "DATE:11/10/2012",
        "TIME:06:40");

    doTest("T31",
        "(FirePage) **MVAC SIG 9** [1 AMBU TO SCENE] 56 OAK AVE C/S: INGRAHAM ST / BALDWIN\r\n" +
        "ROAD DATE: 11/10/2012 TOA: 02:26 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - 1 AMBU TO SCENE",
        "ADDR:56 OAK AVE",
        "X:INGRAHAM ST / BALDWIN ROAD",
        "DATE:11/10/2012",
        "TIME:02:26");

    doTest("T32",
        "(FirePage) **MVAC SIG 9** [INTOX MALE] MINEOLA FD HEADQUARTERS 170 WASHINGTON AVE\r\n" +
        "C/S: WILLIS AVE / MINEOLA BLVD - B-3 DATE: 11/9/2012 TOA: 19:55\r\n" +
        "[FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - INTOX MALE",
        "ADDR:170 WASHINGTON AVE",
        "PLACE:MINEOLA FD HEADQUARTERS",
        "X:WILLIS AVE / MINEOLA BLVD",
        "MAP:B-3",
        "DATE:11/9/2012",
        "TIME:19:55");

    doTest("T33",
        "(FirePage) ** MVAC AUTO ACCIDENT ** [2602 ONLY] E OLD COUNTRY ROAD C/S: BERKLEY\r\n" +
        "ROAD - D-5 DATE: 11/9/2012 TOA: 15:40 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:AUTO ACCIDENT - 2602 ONLY",
        "ADDR:E OLD COUNTRY ROAD",
        "MADDR:E OLD COUNTRY ROAD & BERKLEY ROAD",
        "X:BERKLEY ROAD",
        "MAP:D-5",
        "DATE:11/9/2012",
        "TIME:15:40");

    doTest("T34",
        "(FirePage) **MVAC SIG 9** [MALE VOMITITNG BLOOD] 86 ROSLYN ROAD C/S: 2ND (E) ST /\r\n" +
        "LIBERTY AVE - D-4 DATE: 11/9/2012 TOA: 15:34 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - MALE VOMITITNG BLOOD",
        "ADDR:86 ROSLYN ROAD",
        "X:2ND (E) ST / LIBERTY AVE",
        "MAP:D-4",
        "DATE:11/9/2012",
        "TIME:15:34");

    doTest("T35",
        "(FirePage) **MVAC SIG 9** [SUIT 31-LOWER LEVEL-CARDIAC] 300 OLD COUNTRY ROAD C/S:\r\n" +
        "7TH AVE / 6TH AVE - D-2 DATE: 11/9/2012 TOA: 13:57 [FireTracker]\r\n",

        "SRC:MVAC",
        "CALL:SIG 9 - SUIT 31-LOWER LEVEL-CARDIAC",
        "ADDR:300 OLD COUNTRY ROAD",
        "X:7TH AVE / 6TH AVE",
        "MAP:D-2",
        "DATE:11/9/2012",
        "TIME:13:57");

  }
  
  @Test
  public void testEastWillistonFire() {

    doTest("T1",
        "(FirePage) *EWFD* [9A 911] AMBU M/VOMITING 212 DERBY ST C/S:ROSLYN ROAD / HIGH ST\nHYD:197/ 12/2/2012 TOA:03:58 [FireTracker]",
        "SRC:EWFD",
        "CALL:9A 911 / AMBU M/VOMITING",
        "ADDR:212 DERBY ST",
        "X:ROSLYN ROAD / HIGH ST",
        "INFO:HYD:197/",
        "DATE:12/2/2012",
        "TIME:03:58");

    doTest("T2",
        "(FirePage) *EWFD* [CARB 1] CARB NO ILLNESS 36 DOWNING ST C/S:LATHAM LA / CONGRESS\nAVE 11/29/2012 TOA:21:41 [FireTracker]",
        "SRC:EWFD",
        "CALL:CARB 1 / CARB NO ILLNESS",
        "ADDR:36 DOWNING ST",
        "X:LATHAM LA / CONGRESS AVE",
        "DATE:11/29/2012",
        "TIME:21:41");

    doTest("T3",
        "(FirePage) *EWFD* [INVEST] WIRE 33 FAIRVIEW AVE C/S:ROSLYN ROAD / SCHOOL ST\nHYD:19/37 11/24/2012 TOA:18:11 [FireTracker]",
        "SRC:EWFD",
        "CALL:INVEST / WIRE",
        "ADDR:33 FAIRVIEW AVE",
        "X:ROSLYN ROAD / SCHOOL ST",
        "INFO:HYD:19/37",
        "DATE:11/24/2012",
        "TIME:18:11");

    doTest("T4",
        "(FirePage) *EWFD* [GEN 1] AUTO 81A178/WICKES RES 143 CHARLES ST C/S:CONGRESS AVE /\n" +
        "FEATHER LA HYD:137/154 11/22/2012 TOA:15:26 [FireTracker]",

        "SRC:EWFD",
        "CALL:GEN 1 / AUTO 81A178/WICKES RES",
        "ADDR:143 CHARLES ST",
        "X:CONGRESS AVE / FEATHER LA",
        "INFO:HYD:137/154",
        "DATE:11/22/2012",
        "TIME:15:26");

    doTest("T5",
        "(FirePage) *EWFD* [CARB 1] CARB AUTOMATIC/FAMPOGNA RES 40 FAIRVIEW AVE C/S:ROSLYN\n" +
        "ROAD / SCHOOL ST HYD:19/37 11/21/2012 TOA:14:12 [FireTracker]",

        "SRC:EWFD",
        "CALL:CARB 1 / CARB AUTOMATIC/FAMPOGNA RES",
        "ADDR:40 FAIRVIEW AVE",
        "X:ROSLYN ROAD / SCHOOL ST",
        "INFO:HYD:19/37",
        "DATE:11/21/2012",
        "TIME:14:12");

    doTest("T6",
        "(FirePage) *EWFD* [GEN 1] WIRES 8100 TO RESP ONLY MERITORIA DR C/S:ROBBINS DR\n11/18/2012 TOA:13:07 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / WIRES 8100 TO RESP ONLY",
        "ADDR:MERITORIA DR",
        "MADDR:MERITORIA DR & ROBBINS DR",
        "X:ROBBINS DR",
        "DATE:11/18/2012",
        "TIME:13:07");

    doTest("T7",
        "(FirePage) *EWFD* [GEN 1] AUTO RES SOLOEMANS 84 ROBBINS DR C/S:MERITORIA DR / - - -\n" +
        "HYD:42,62/84 11/18/2012 TOA:03:32 [FireTracker]",

        "SRC:EWFD",
        "CALL:GEN 1 / AUTO RES SOLOEMANS - - -",
        "ADDR:84 ROBBINS DR",
        "X:MERITORIA DR /",
        "INFO:HYD:42,62/84",
        "DATE:11/18/2012",
        "TIME:03:32");

    doTest("T8",
        "(FirePage) *EWFD* [GEN 1] AUTO NO PERMIT/SCHIREFER RES 150 CHARLES ST C/S:CONGRESS\n" +
        "AVE / FEATHER LA HYD:137/154 11/15/2012 TOA:07:07 [FireTracker]",

        "SRC:EWFD",
        "CALL:GEN 1 / AUTO NO PERMIT/SCHIREFER RES",
        "ADDR:150 CHARLES ST",
        "X:CONGRESS AVE / FEATHER LA",
        "INFO:HYD:137/154",
        "DATE:11/15/2012",
        "TIME:07:07");

    doTest("T9",
        "(FirePage) *EWFD* [9A FCOM] AMBU SICK PERSON 386 ROSLYN ROAD C/S:COLEMAN DR /\n" +
        "DOWNING ST HYD:OPP/387 11/13/2012 TOA:06:36 [FireTracker]",

        "SRC:EWFD",
        "CALL:9A FCOM / AMBU SICK PERSON",
        "ADDR:386 ROSLYN ROAD",
        "X:COLEMAN DR / DOWNING ST",
        "INFO:HYD:OPP/387",
        "DATE:11/13/2012",
        "TIME:06:36");

    doTest("T10",
        "(FirePage) *EWFD* [CARB 1] CARB NO AIDED 45 ORCHARD MEADOW ROAD C/S:MEADOW LA /\nRIDGE ROAD 11/12/2012 TOA:14:05 [FireTracker]",
        "SRC:EWFD",
        "CALL:CARB 1 / CARB NO AIDED",
        "ADDR:45 ORCHARD MEADOW ROAD",
        "X:MEADOW LA / RIDGE ROAD",
        "DATE:11/12/2012",
        "TIME:14:05");

    doTest("T11",
        "(FirePage) *EWFD* [GEN 1] NATU OUTSIDE WEEKS ROAD C/S:GLENMORE ST 11/11/2012\nTOA:13:39 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / NATU OUTSIDE",
        "ADDR:WEEKS ROAD",
        "MADDR:WEEKS ROAD & GLENMORE ST",
        "X:GLENMORE ST",
        "DATE:11/11/2012",
        "TIME:13:39");

    doTest("T12",
        "(FirePage) *EWFD* [GEN 1] NATU ODOR IN AREA 110 HILLSIDE AVE C/S:WHEATLEY AVE /\nANDREWS ROAD 11/8/2012 TOA:13:05 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / NATU ODOR IN AREA",
        "ADDR:110 HILLSIDE AVE",
        "X:WHEATLEY AVE / ANDREWS ROAD",
        "DATE:11/8/2012",
        "TIME:13:05");

    doTest("T13",
        "(FirePage) *EWFD* [GEN 1] NAT ODOR IN AREA 28 DOWNING ST C/S:ROSLYN ROAD / LATHAM\nLA HYD:17/ 11/8/2012 TOA:13:05 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / NAT ODOR IN AREA",
        "ADDR:28 DOWNING ST",
        "X:ROSLYN ROAD / LATHAM LA",
        "INFO:HYD:17/",
        "DATE:11/8/2012",
        "TIME:13:05");

    doTest("T14",
        "(FirePage) *EWFD* [9A FCOM] AMBU WEAK FEMALE 120 WEEKS ROAD C/S:GLENMORE ST /\n" +
        "BENGEYFIELD DR HYD:99/109 11/8/2012 TOA:10:21 [FireTracker]",

        "SRC:EWFD",
        "CALL:9A FCOM / AMBU WEAK FEMALE",
        "ADDR:120 WEEKS ROAD",
        "X:GLENMORE ST / BENGEYFIELD DR",
        "INFO:HYD:99/109",
        "DATE:11/8/2012",
        "TIME:10:21");

    doTest("T15",
        "(FirePage) *EWFD* [CARB 1] CARB AUTO / KARIKAS RESD / 816532620 382 ANDREWS ROAD\n" +
        "C/S:CHARLES ST / DOWNING ST 11/8/2012 TOA:08:24 [FireTracker]",

        "SRC:EWFD",
        "CALL:CARB 1 / CARB AUTO / KARIKAS RESD / 816532620",
        "ADDR:382 ANDREWS ROAD",
        "X:CHARLES ST / DOWNING ST",
        "DATE:11/8/2012",
        "TIME:08:24");

    doTest("T16",
        "(FirePage) *EWFD* [GEN 1] WIRE TREE AND WIRES DOWN 113 LEHIGH ST C/S:STRATFORD AVE\n/ -DEAD END- 11/8/2012 TOA:03:24 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / WIRE TREE AND WIRES DOWN",
        "ADDR:113 LEHIGH ST",
        "X:STRATFORD AVE / DEAD END",
        "DATE:11/8/2012",
        "TIME:03:24");

    doTest("T17",
        "(FirePage) *EWFD* [GEN 1] WIRE DOWN IN THE DRIVEWAY-PERSON IN CAR 38 EAST WILLISTON\n" +
        "AVE C/S:POST LA / ROSLYN ROAD HYD:18,38/54 11/7/2012 TOA:23:27\n" +
        "[FireTracker]",

        "SRC:EWFD",
        "CALL:GEN 1 / WIRE DOWN IN THE DRIVEWAY-PERSON IN CAR",
        "ADDR:38 EAST WILLISTON AVE",
        "X:POST LA / ROSLYN ROAD",
        "INFO:HYD:18,38/54",
        "DATE:11/7/2012",
        "TIME:23:27");

    doTest("T18",
        "(FirePage) *EWFD* [GEN 1] WIRES ROSLYN ROAD C/S:ROBBINS DR 11/7/2012 TOA:22:09\n[FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / WIRES",
        "ADDR:ROSLYN ROAD",
        "MADDR:ROSLYN ROAD & ROBBINS DR",
        "X:ROBBINS DR",
        "DATE:11/7/2012",
        "TIME:22:09");

    doTest("T19",
        "(FirePage) *EWFD* [GEN 1] WIRE PRIMARY DOWN ROSLYN ROAD C/S:POST AVE 11/7/2012\nTOA:19:59 [FireTracker]",
        "SRC:EWFD",
        "CALL:GEN 1 / WIRE PRIMARY DOWN",
        "ADDR:ROSLYN ROAD",
        "MADDR:ROSLYN ROAD & POST AVE",
        "X:POST AVE",
        "DATE:11/7/2012",
        "TIME:19:59");

    doTest("T20",
        "(FirePage) *EWFD* [GEN 1] WIRES AND TREE 120 CHARLES ST C/S:CONGRESS AVE / COLUMBUS\n" +
        "PKWY HYD:120/ 11/7/2012 TOA:18:49 [FireTracker]",

        "SRC:EWFD",
        "CALL:GEN 1 / WIRES AND TREE",
        "ADDR:120 CHARLES ST",
        "X:CONGRESS AVE / COLUMBUS PKWY",
        "INFO:HYD:120/",
        "DATE:11/7/2012",
        "TIME:18:49");

    doTest("T21",
        "(FirePage) *EWFD* [CARB 1] CARB AUTOMATIC/FAMPOGNA RES 40 FAIRVIEW AVE C/S:ROSLYN\r\n" +
        "ROAD / SCHOOL ST HYD:19/37 11/21/2012 TOA:14:12 [FireTracker]\r\n",

        "SRC:EWFD",
        "CALL:CARB 1 / CARB AUTOMATIC/FAMPOGNA RES",
        "ADDR:40 FAIRVIEW AVE",
        "X:ROSLYN ROAD / SCHOOL ST",
        "INFO:HYD:19/37",
        "DATE:11/21/2012",
        "TIME:14:12");

    doTest("T22",
        "(FirePage) *EWFD* [GEN 1] AUTO 81A178/WICKES RES 143 CHARLES ST C/S:CONGRESS AVE /\r\n" +
        "FEATHER LA HYD:137/154 11/22/2012 TOA:15:26 [FireTracker]\r\n",

        "SRC:EWFD",
        "CALL:GEN 1 / AUTO 81A178/WICKES RES",
        "ADDR:143 CHARLES ST",
        "X:CONGRESS AVE / FEATHER LA",
        "INFO:HYD:137/154",
        "DATE:11/22/2012",
        "TIME:15:26");

    doTest("T23",
        "(FirePage) *EWFD* [INVEST] WIRE 33 FAIRVIEW AVE C/S:ROSLYN ROAD / SCHOOL ST\r\nHYD:19/37 11/24/2012 TOA:18:11 [FireTracker]\r\n",
        "SRC:EWFD",
        "CALL:INVEST / WIRE",
        "ADDR:33 FAIRVIEW AVE",
        "X:ROSLYN ROAD / SCHOOL ST",
        "INFO:HYD:19/37",
        "DATE:11/24/2012",
        "TIME:18:11");

    doTest("T24",
        "(FirePage) *EWFD* [CARB 1] CARB NO ILLNESS 36 DOWNING ST C/S:LATHAM LA / CONGRESS\r\nAVE 11/29/2012 TOA:21:41 [FireTracker]\r\n",
        "SRC:EWFD",
        "CALL:CARB 1 / CARB NO ILLNESS",
        "ADDR:36 DOWNING ST",
        "X:LATHAM LA / CONGRESS AVE",
        "DATE:11/29/2012",
        "TIME:21:41");

    doTest("T25",
        "(FirePage) *EWFD* [9A 911] AMBU M/VOMITING 212 DERBY ST C/S:ROSLYN ROAD / HIGH ST\r\nHYD:197/ 12/2/2012 TOA:03:58 [FireTracker]\r\n",
        "SRC:EWFD",
        "CALL:9A 911 / AMBU M/VOMITING",
        "ADDR:212 DERBY ST",
        "X:ROSLYN ROAD / HIGH ST",
        "INFO:HYD:197/",
        "DATE:12/2/2012",
        "TIME:03:58");
   
  }    
  
  public static void main(String[] args) {
    new NYNassauCountyFiretrackerParserTest().generateTests("T21");
    //new NYNassauCountyFiretrackerParserTest().generateTests("T21", "SRC CALL ADDR X INFO");
  }
}