package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Onondaga County, NY
Contact: Andrew Clark <ajc0079@gmail.com>
Sender: e9web1@ongov.net
[CAD MSG POF 18:04:47 7461 BROADFIELD RD TPO XTS:SWEET RD] HENNEBERRY RD,  , UNCP - P:1 Lev:0 X:  TWCBL BUSHNECK, JOHN VOIP 02/14 18:03:57 911 CC RE 1 YO UNCP/NOT BREATH IS CON. IS BREATHING A LITTLE BIT FACE IS A LITTLE BLU  Disp: 51C1,51C2,51C3,51C4,51RP51,5

Contact: Al Pola <alpola828@gmail.com>

....(Skaneateles Fire) I/CAD MSG SKF 22:14:04 3104 W Lake Rd TSK XTS: FIRE LANE 9/THE LANE, , WIRE -E P:1 Lev:0 X: M911 - CC - Electric Wire Against A Tree - Is arcing and sparking - compl has no power now Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1
....(Skaneateles Fire) I/CAD MSG CAYFC 22:28:30 3801 SWARTOUT RD  OTOW CAY XTS:MARTIN RD/CEDAR SWAMP RD,  , FIRE -R P:1 Lev:0 X: 54C5 AND E 11 ER - ACTIV
....(Skaneateles Fire) I/CAD MSG SKF 01:07:57  3150 W LAKE RD TSK XTS:BENSON RD/ANDREWS RD, , ALRM -C P:1 Lev:0 X: COUNTY FIRE- OPERATOR#1144-#800-932-93
(Skaneateles Fire) I/CAD MSG SKF 09:42:52  52 W GENESEE ST  VSK XTS:W LAKE ST/GRIFFIN ST,  , FIRE -E P:1 Lev:0 X: LINDSEY, CRAIG &amp; JUDITH  RESD 01/03 9:41:18  911 CC: CALLER SAYS SMELLS LIKE SOMETHING ELECTRICAL IS BURNING  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54TK1
(Skaneateles Fire) I/CAD MSG SKF 17:58:51 1563 NEW SENECA TPKE  TSK XTS: LUCINDA DR/KNIGHTSBRIDGE RD,  , FIRE -F P:2 Lev:0 X:TWCBL MCGEE, KAREN VOIP 01/02 17:57:49  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54SD1, CFCTAC3
(Skaneateles Fire) I/CAD MSG SKF 16:03:15  4061 STATE STREET RD TSK: EST XTS: JEWETT RD/OLD SENECA TPKE,  , MVC -IB P:1 Lev:0 X: NW SECTOR -076.426885 042.968098 01/06  16:02:26 VEH IN A DITCH IS SMOKING Disp:38RP1, 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1, 54TK1
(Skaneateles Fire)  I/CAD MSG SKF 16:52:38 2745 E LAKE RD TSK: @SKANEATELES SAILING CLUB XTS:BUFFS BLUFF RD/COON HILL RD, , LOCK -R P:2 Lev:0 X:  M911 CC RE LOCKED IN THE BLDG -- COMPL USES A WALKER AND IS UNABLE TO MOVE  Disp: 54E21, 54MI1, 54R1, 54TK1
(Skaneateles Fire) I/CAD MSG SKF 04:37:24  110 FENNELL ST VSK XTS:PACKSWOOD PL/OLD SENECA TPK, APT B IN BACK, UNCP - P:1 Lev:0 X: M911//88 YO MALE UNCP/NOT BREATHING// IS AN EXPECTED DEATH// HAS BEEN ILL FOR SOME TIME// REQ NO LIGHTS AND SIRENS// Disp: 54C1, 54C2, 54C3, 54E12
[Skaneateles Fire] I/CAD MSG SKF 08:17:45 55 JORDAN ST VSK: @VILLAGE LANDING XTS: ACADEMY ST/E ELIZABETH ST, APT 109, UNCP - P:1 Lev:0 X: PH BROCK, ESTHER M RESD 01/22 08:15:44 SEE ADDIE COGGEN, 100 YOF, PH # 685-5355 FEELING FAINT/HX OF HEART Number of patients: 1 Responder sc
[Skaneateles Fire] I/CAD MSG MRF 11:23:17 3800 LEE MULROY RD TMR:@ULTIMATE GOAL XTS:BISHOP HILL RD/LAWRENCE RD, IFO , MVC -IB P:1 Lev:0 X: M911 CC RE A 2 CARS 1 ROLL OVER THERE IS STILL OCCP IN THE ROLL OVER Disp: 33C1, 33C2, 33C3, 33C4, 33E2, 33R1, 54E11

Contact: Adam <wiseman3a@gmail.com>
Sender: e9web1@ongov.net
I/CAD MSG BOF 15:59:34 XTS:EIBERT RD/SUNSET COVE,  , MVC -IB P:1 Lev:0 X:  CELL = 2026 SECTOR = 2 -076.367533 042.876698 CAUTION:

Contact: Active911
[Liverpool Fire] I/CAD MSG LVF 09:15:32 BUCKLEY RD/SEVENTH NORTH ST TSL XTS:BUCKLEY RD/SEVENTH NORTH ST, IFO SUBWAY , MVC -IB P:1 Lev:0 X:  M911- C\r\r\n\r\r\n\r\n\r\n\r\n

*/


public class NYOnondagaCountyAParserTest extends BaseParserTest {
  
  public NYOnondagaCountyAParserTest() {
    setParser(new NYOnondagaCountyAParser(), "ONONDAGA COUNTY", "NY");
  }
  
  @Test
  public void testBad() {
    doBadTest(
        "(Dispatch) Dispatch ** 07:06:07 ** E-PERSONAL INJURY ** 916 STATE FAIR BLVD ** SNOWBIRDS LANDING II-NEAR THE **  ** (315) 460-0168 **  **  ** MALE FELL APPEARS UNSTABLE\n" +
        "Number of patients: 1\n" +
        "Responder script: 86 year old, Male, Conscious, Breathing. Falls. Caller\n" +
        "Statement: MALE FELL APPEARS UNSTABLE .\n" +
        "MALE FELL APPEARS UNSTABLE\n" +
        "Respon ** 05/26/12 ** PINJ ** WVE128700889 ** WVE ** Fire Station Dispatch Report   Dispatch Time:  05-26-2012  07:06:07\n" +
        "Agency: GBE \n" +
        "    Event: E12052600040\n\n" +
        "Case Number: WVE128700889\n" +
        "Event Type Code: PINJ PERSONAL INJURY\n" +
        "Event Subtype Code:         \n\n" +
        "Address:\n" +
        "SNOWBIRDS LANDING II\n" +
        "916  STATE FAIR BLVD \n" +
        "Location Info: NEAR THE ST IFO THIS LOCATION \n\n" +
        "Municipality: TGD\n" +
        "Cross Street: CONKLIN ST AND SENECA ST\n\n" +
        "Caller Information:\n\n" +
        "  Caller Name: \n" +
        "  Caller Phone Number: (315) 460-0168\n" +
        "  Caller Address: \n\n" +
        "Responding Units:\n\n" +
        "  87A3  WVE1  EMS\n" +
        " ** TGD **  ** GB **  ** CONKLIN ST AND SENECA ST **  ** A3, ** ");
  }
  
  @Test
  public void testPompey() {

    doTest("T1",
        "[CAD MSG POF 18:04:47 7461 BROADFIELD RD TPO XTS:SWEET RD] HENNEBERRY RD,  , UNCP - P:1 Lev:0 X:  TWCBL BUSHNECK, JOHN VOIP 02/14 18:03:57 911 CC RE 1 YO UNCP/NOT BREATH IS CON. IS BREATHING A LITTLE BIT FACE IS A LITTLE BLU  Disp: 51C1,51C2,51C3,51C4,51RP51,5",
        "SRC:POF",
        "TIME:18:04:47",
        "ADDR:7461 BROADFIELD RD",
        "CITY:POMPEY",
        "X:SWEET RD HENNEBERRY RD",
        "CALL:UNCP",
        "PRI:1",
        "INFO:TWCBL BUSHNECK, JOHN VOIP 02/14 18:03:57 911 CC RE 1 YO UNCP/NOT BREATH IS CON. IS BREATHING A LITTLE BIT FACE IS A LITTLE BLU",
        "UNIT:51C1,51C2,51C3,51C4,51RP51,5");
    
  }
  
  @Test
  public void testSkaneateles() {

    doTest("T1",
        "....(Skaneateles Fire) I/CAD MSG SKF 22:14:04 3104 W Lake Rd TSK XTS: FIRE LANE 9/THE LANE, , WIRE -E P:1 Lev:0 X: M911 - CC - Electric Wire Against A Tree - Is arcing and sparking - compl has no power now Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1",
        "SRC:SKF",
        "TIME:22:14:04",
        "ADDR:3104 W Lake Rd",
        "CITY:SKANEATELES",
        "X:FIRE LANE 9/THE LANE",
        "CALL:WIRE -E",
        "PRI:1",
        "INFO:M911 - CC - Electric Wire Against A Tree - Is arcing and sparking - compl has no power now",
        "UNIT:54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1");

    doTest("T2",
        "....(Skaneateles Fire) I/CAD MSG CAYFC 22:28:30 3801 SWARTOUT RD  OTOW CAY XTS:MARTIN RD/CEDAR SWAMP RD,  , FIRE -R P:1 Lev:0 X: 54C5 AND E 11 ER - ACTIV",
        "SRC:CAYFC",
        "TIME:22:28:30",
        "ADDR:3801 SWARTOUT RD",
        "CITY:OWASCO",
        "PLACE:CAY",
        "X:MARTIN RD/CEDAR SWAMP RD",
        "CALL:FIRE -R",
        "PRI:1",
        "INFO:54C5 AND E 11 ER - ACTIV");

    doTest("T3",
        "....(Skaneateles Fire) I/CAD MSG SKF 01:07:57  3150 W LAKE RD TSK XTS:BENSON RD/ANDREWS RD, , ALRM -C P:1 Lev:0 X: COUNTY FIRE- OPERATOR#1144-#800-932-93",
        "SRC:SKF",
        "TIME:01:07:57",
        "ADDR:3150 W LAKE RD",
        "CITY:SKANEATELES",
        "X:BENSON RD/ANDREWS RD",
        "CALL:ALRM -C",
        "PRI:1",
        "INFO:COUNTY FIRE- OPERATOR#1144-#800-932-93");

    doTest("T4",
        "(Skaneateles Fire) I/CAD MSG SKF 09:42:52  52 W GENESEE ST  VSK XTS:W LAKE ST/GRIFFIN ST,  , FIRE -E P:1 Lev:0 X: LINDSEY, CRAIG &amp; JUDITH  RESD 01/03 9:41:18  911 CC: CALLER SAYS SMELLS LIKE SOMETHING ELECTRICAL IS BURNING  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54TK1",
        "SRC:SKF",
        "TIME:09:42:52",
        "ADDR:52 W GENESEE ST",
        "CITY:SKANEATELES",
        "X:W LAKE ST/GRIFFIN ST",
        "CALL:FIRE -E",
        "PRI:1",
        "INFO:LINDSEY, CRAIG & JUDITH RESD 01/03 9:41:18 911 CC: CALLER SAYS SMELLS LIKE SOMETHING ELECTRICAL IS BURNING",
        "UNIT:54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54TK1");

    doTest("T5",
        "(Skaneateles Fire) I/CAD MSG SKF 17:58:51 1563 NEW SENECA TPKE  TSK XTS: LUCINDA DR/KNIGHTSBRIDGE RD,  , FIRE -F P:2 Lev:0 X:TWCBL MCGEE, KAREN VOIP 01/02 17:57:49  Disp: 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54SD1, CFCTAC3",
        "SRC:SKF",
        "TIME:17:58:51",
        "ADDR:1563 NEW SENECA TPKE",
        "CITY:SKANEATELES",
        "X:LUCINDA DR/KNIGHTSBRIDGE RD",
        "CALL:FIRE -F",
        "PRI:2",
        "INFO:TWCBL MCGEE, KAREN VOIP 01/02 17:57:49",
        "UNIT:54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54R1, 54SD1, CFCTAC3");

    doTest("T6",
        "(Skaneateles Fire) I/CAD MSG SKF 16:03:15  4061 STATE STREET RD TSK: EST XTS: JEWETT RD/OLD SENECA TPKE,  , MVC -IB P:1 Lev:0 X: NW SECTOR -076.426885 042.968098 01/06  16:02:26 VEH IN A DITCH IS SMOKING Disp:38RP1, 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1, 54TK1",
        "SRC:SKF",
        "TIME:16:03:15",
        "ADDR:4061 STATE STREET RD",
        "CITY:SKANEATELES",
        "PLACE:EST",
        "X:JEWETT RD/OLD SENECA TPKE",
        "CALL:MVC -IB",
        "PRI:1",
        "INFO:NW SECTOR -076.426885 042.968098 01/06 16:02:26 VEH IN A DITCH IS SMOKING",
        "UNIT:38RP1, 54C1, 54C2, 54C3, 54E11, 54E12, 54E21, 54E31, 54MI1, 54R1, 54SD1, 54TK1");

    doTest("T7",
        "(Skaneateles Fire)  I/CAD MSG SKF 16:52:38 2745 E LAKE RD TSK: @SKANEATELES SAILING CLUB XTS:BUFFS BLUFF RD/COON HILL RD, , LOCK -R P:2 Lev:0 X:  M911 CC RE LOCKED IN THE BLDG -- COMPL USES A WALKER AND IS UNABLE TO MOVE  Disp: 54E21, 54MI1, 54R1, 54TK1",
        "SRC:SKF",
        "TIME:16:52:38",
        "ADDR:2745 E LAKE RD",
        "CITY:SKANEATELES",
        "PLACE:SKANEATELES SAILING CLUB",
        "X:BUFFS BLUFF RD/COON HILL RD",
        "CALL:LOCK -R",
        "PRI:2",
        "INFO:M911 CC RE LOCKED IN THE BLDG -- COMPL USES A WALKER AND IS UNABLE TO MOVE",
        "UNIT:54E21, 54MI1, 54R1, 54TK1");

    doTest("T8",
        "(Skaneateles Fire) I/CAD MSG SKF 04:37:24  110 FENNELL ST VSK XTS:PACKSWOOD PL/OLD SENECA TPK, APT B IN BACK, UNCP - P:1 Lev:0 X: M911//88 YO MALE UNCP/NOT BREATHING// IS AN EXPECTED DEATH// HAS BEEN ILL FOR SOME TIME// REQ NO LIGHTS AND SIRENS// Disp: 54C1, 54C2, 54C3, 54E12",
        "SRC:SKF",
        "TIME:04:37:24",
        "ADDR:110 FENNELL ST",
        "CITY:SKANEATELES",
        "X:PACKSWOOD PL/OLD SENECA TPK",
        "APT:B IN BACK",
        "CALL:UNCP",
        "PRI:1",
        "INFO:M911//88 YO MALE UNCP/NOT BREATHING// IS AN EXPECTED DEATH// HAS BEEN ILL FOR SOME TIME// REQ NO LIGHTS AND SIRENS//",
        "UNIT:54C1, 54C2, 54C3, 54E12");

    doTest("T9",
        "[Skaneateles Fire] I/CAD MSG SKF 08:17:45 55 JORDAN ST VSK: @VILLAGE LANDING XTS: ACADEMY ST/E ELIZABETH ST, APT 109, UNCP - P:1 Lev:0 X: PH BROCK, ESTHER M RESD 01/22 08:15:44 SEE ADDIE COGGEN, 100 YOF, PH # 685-5355 FEELING FAINT/HX OF HEART Number of patients: 1 Responder sc",
        "SRC:SKF",
        "TIME:08:17:45",
        "ADDR:55 JORDAN ST",
        "CITY:SKANEATELES",
        "PLACE:VILLAGE LANDING",
        "X:ACADEMY ST/E ELIZABETH ST",
        "APT:109",
        "CALL:UNCP",
        "PRI:1",
        "INFO:PH BROCK, ESTHER M RESD 01/22 08:15:44 SEE ADDIE COGGEN, 100 YOF, PH # 685-5355 FEELING FAINT/HX OF HEART Number of patients: 1 Responder sc");

    doTest("T10",
        "[Skaneateles Fire] I/CAD MSG MRF 11:23:17 3800 LEE MULROY RD TMR:@ULTIMATE GOAL XTS:BISHOP HILL RD/LAWRENCE RD, IFO , MVC -IB P:1 Lev:0 X: M911 CC RE A 2 CARS 1 ROLL OVER THERE IS STILL OCCP IN THE ROLL OVER Disp: 33C1, 33C2, 33C3, 33C4, 33E2, 33R1, 54E11",
        "SRC:MRF",
        "TIME:11:23:17",
        "ADDR:3800 LEE MULROY RD",
        "CITY:MARCELLUS",
        "PLACE:ULTIMATE GOAL",
        "X:BISHOP HILL RD/LAWRENCE RD",
        "CALL:MVC -IB",
        "PRI:1",
        "INFO:M911 CC RE A 2 CARS 1 ROLL OVER THERE IS STILL OCCP IN THE ROLL OVER",
        "UNIT:33C1, 33C2, 33C3, 33C4, 33E2, 33R1, 54E11");
  }
  
  @Test
  public void testActive911() {

    doTest("T9",
        "[Liverpool Fire] I/CAD MSG LVF 09:15:32 BUCKLEY RD/SEVENTH NORTH ST TSL XTS:BUCKLEY RD/SEVENTH NORTH ST, IFO SUBWAY , MVC -IB P:1 Lev:0 X:  M911- C\r\r\n" +
        "\r\r\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "SRC:LVF",
        "TIME:09:15:32",
        "ADDR:BUCKLEY RD & SEVENTH NORTH ST",
        "CITY:SALINA",
        "PLACE:SUBWAY",
        "X:BUCKLEY RD/SEVENTH NORTH ST",
        "CALL:MVC -IB",
        "PRI:1",
        "INFO:M911- C");

  }
  
  public static void main(String[] args) {
    new NYOnondagaCountyAParserTest().generateTests("T9");
  }
}