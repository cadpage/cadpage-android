package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYUlsterCountyParser;

import org.junit.Test;

/*
Ulster County, NY
Contact: Andrew Buboltz <ajb5620@gmail.com>
Sender: cad@co.ulster.ny.us

((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl
((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl
((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt
((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE 

Contact: Stephen Quick <stephen.d.quick@gmail.com>
Sender: CAD@CO.ULSTER.NY.US
FRM:CAD@CO.ULSTER.NY.US\nSUBJ:(16733) MGAF/\nMSG:Unit:PG68-2 UnitSts: Loc:85 MAIN XSts:WALL/GREEN Venue:King City\nInc:Struct Fir\n(Con't) 2 of 2\nDate:01/31/2012 Time:14:32 BUILDING ON FIRE Addtl:CNTX:(End)

Contact: connor dugan <conman1288@hotmail.com>
Sender: CAD@co.ulster.ny.us
((20155) LQUI/) Unit:PG32 Loc:425 CHESTNUT XSts:LAUREL/RIDGEWOOD AV Venue:Hurley Inc:Crit/345 Date:01/15/2013 Time:04:14 80 YOF CHEST PAINS/DIFF BREATHING Addtl

Contact: James Schofield <schofield85@gmail.com>
Sender: 777329978991
ULSTER COUNTY/SHERIFF/911 ((27593) JWIN/ ) Unit:PG80 Inc:Stable Nature:88 Y/F R/O THROMBOSIS Loc:1 JANSEN RD UNIT A RM 10 SOUTH XSts:ROUTE 208/DUBOIS RD   Common:MOUNTAIN VIEW NURSIN  Venue:New Paltz Addtl:UNIT A ROOM 10 SOUTH 04/10/2013 15:17 TXT STOP to opt-out\r

Contact: Active911
Agency name: Glasco Fire Co
Location: Saugerties, NY, United States
Sender: Chris Winters <cwinters418@gmail.com>

{Ulster county 911} Subject:(39995) ACAF/ \nUnit:PG29 Inc:Carb Monox Nature:CHGE NEEDS ASSIST GAIING ACCESS-POSSIBLE Loc:8 TERRI DR XSts:SPAULDING LN/DEAD END  
{Ulster county 911} Subject:(32764) RRLY/ \nUnit:PG29 Loc:6 MOUNTAIN VIEW AV XSts:SIMMONS DR/DEAD END Venue:Saugerties Inc:Crit/345 Date:01/20/2013 Time:18:12 7
{Ulster county 911} Subject:(28430) BMCC/ \nUnit:PG29 Loc:3139 ROUTE 9W XSts:VILLAGE DR/AVON Venue:Saugerties Inc:PIAA/040 Date:01/18/2013 Time:18:25 PIAA Addtl
{Ulster County 911} Subject:(24318) PFLA/ \nUnit:PG29 Loc:5 TIGER MAPLE LN XSts:RED MAPLE RD/ROCK MAPLE RD Venue:Saugerties Inc:Misc Date:01/16/2013 Time:20:37 
{Ulster county 911} \n\nSubject:(12412) ACAF/ \nUnit:PG29 UnitSts: Loc:2035 ROUTE 32 XSts:CAFALDO DR/STEPHEN DR Venue:Saugerties Inc:PIAA/040 Date:01/11/2013 Time:0
{Ulster County 911} Subject:(63568) JADS/ \nUnit:PG29 UnitSts: Loc:113 COMMONS LN XSts:ROUTE 9W/ROUTE 32 Venue:Saugerties Inc:Crit/345 Date:01/04/2013 Time:12:3
{Ulster County 911} Subject:(62554) RQUI/ \nUnit:PG29 UnitSts: Loc:52 WASHINGTON AV XSts:CLERMONT/POST Venue:Saugerties Inc:Struct Fir Date:01/04/2013 Time:02:0
{Ulster County 911} Subject:(60567) ACAF/ \nUnit:PG29 UnitSts: Loc:5 AMERIBAG DR XSts:KUKUK LN/DEAD END Venue:Ulster Inc:Autoalarm Date:01/03/2013 Time:14:56 AL
{Ulster County 911 } Subject:(56110) MGAF/ \nUnit:PG29 UnitSts: Loc:13 VILLAGE DR APT 503 XSts:ROUTE 9W/STEVENS CT Venue:Saugerties Inc:Crit/345 Date:01/01/2013 
{Ulster County 911} Subject:(28440) JADS/ \nUnit:PG29 UnitSts: Loc:20 DEWITT DR XSts:BLUE HILLS DR/DEAD END Venue:Saugerties Inc:Struct Fir Date:12/21/2012 Time
{Ulster County 911} Subject:(6010) JWIN/ \nUnit:PG29 UnitSts: Loc:10 CEDAR LN XSts:BIRCHWOOD DR W/HIGHLAND AV Venue:Saugerties Inc:Autoalarm Date:12/11/2012 Tim
{Ulster County 911} \nSubject:(47925) VQUE/ \nUnit:PG29 UnitSts: Loc:114 BARCLAY LN XSts:ROUTE 9W/DEAD END Venue:Saugerties Inc:Struct Fir Date:12/01/2012 Time:16

Contact: Active911
Agency name: Cottekill Vol. Fire Co.
Location: Cottekill, NY, United States
Sender: CAD@CO.ULSTER.NY.US 

((59668) PFLA ) Unit:PG23 Inc:Stable Nature:81 YOM LIFT ASSISTANCE Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE   Common:  Venue:Rosendale Addtl: 01/30/2013 16:04
((39699) ACAF ) Unit:PG23 Inc:PIAA/040 Nature:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL Loc:MARCOTT RD/LUCAS XSts:LUCAS AV/MARCOTT RD   Common:  Venue:Rosendale Addtl: 01/23/2013 09:48
((38648) PFLA ) Unit:PG23 Inc:Struct Fir Nature:CHIMNEY FIRE Loc:162 STONE DOCK RD XSts:BERME RD/DEAD END   Common:  Venue:Marbletown Addtl: 01/22/2013 18:35
((10732) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SP7 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/10/2013 Time:10:03 28 YOM CHEST PAIN Addtl:APT SP7
((4648) MGAF ) Unit:PG23 UnitSts: Loc:60 LOWER 27 KNOLLS RD XSts:MOSSY BROOK RD/DEAD END Venue:Marbletown Inc:Autoalarm Date:01/07/2013 Time:12:39 FIRST FLOOR SMOKE DETECTOR ACTIVATION Addtl: 3384440
((63725) MDAV ) Unit:PG23 UnitSts: Loc:1000 MOUNTAIN REST RD XSts:SPIES RD/TOWN LINE Venue:Marbletown Inc:Autoalarm Date:01/04/2013 Time:13:37 FIRE ALARM Addtl:MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200
((59422) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD APT1C XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/02/2013 Time:22:45 31 YOM VOMITING BLOOD, CHEST PAINS Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C
((50585) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AV XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:PIAA/040 Date:12/30/2012 Time:10:20 MINOR INJURIES Addtl:VEH IN ROADWAY
((43038) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD DUPLEX B XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:12/27/2012 Time:20:28 62 YOF DIFFICULTY BREATHING Addtl:VOIP:  # B
((40982) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AVENUE EXT XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:Crit/345 Date:12/26/2012 Time:21:07 73 Y/M UNRESPONSIVE Addtl:VOIP:
((33793) MGAF ) Unit:PG23 UnitSts: Loc:19 COXING RD XSts:COTTEKILL RD/ROMNEY WAY Venue:Marbletown Inc:Crit/345 Date:12/23/2012 Time:22:14 90 YOF BLOODY NOSE Addtl:RESD:
((4737) BKIN ) Unit:PG23 UnitSts: Loc:3007 ROUTE 213 XSts:OAKWOOD DR/DISTRICT LINE Venue:Marbletown Inc:Struct Fir Date:12/11/2012 Time:07:22 FIRE IN THE TOASTER OVEN Addtl:REPORTED TO BE OUT
((61601) JWIN ) Unit:PG23 UnitSts: Loc:457 MOHONK RD XSts:STOKES WAY/COUNTY ROUTE 6 Venue:Marbletown Inc:Autoalarm Date:12/07/2012 Time:09:49 LIVING ROOM SMOKE DETECTOR Addtl:
((61063) RQUI ) Unit:PG23 UnitSts: Loc:247 MARCOTT RD XSts:DISTRICT LINE/COXING RD Venue:Marbletown Inc:Crit/345 Date:12/07/2012 Time:04:22 94 YOF SEMI RESPONSIVE SECONDARY TO A FALL Addtl:
((59162) LRME ) Unit:PG23 UnitSts: Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE Venue:Rosendale Inc:Crit/345 Date:12/06/2012 Time:10:52 80 YOM BACK PAIN UNABLE TO AMBULATE Addtl:FD FOR LIFTING
((10208) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/15/2012 Time:10:24 28 YOM ABDOMINAL PAIN Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C
((8143) VPHI ) Unit:PG23 UnitSts: Loc:MOSSY BROOK RD XSts:ROUTE 213/MOUNTAIN RD Venue:Rosendale Inc:Unkwn Fire Date:11/13/2012 Time:20:03 UNKNOWN FIRE Addtl:PARKING AREA ON THE RIGHT
((64420) MDAV ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SPORTS 2 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/10/2012 Time:08:08 35 YOF POSS OVERDOSE Addtl:RESD:  BLDG SPORTS APT 2
((39843) VPHI ) Unit:PG23 UnitSts: Loc:390 MARCOTT RD XSts:TOWN LINE/LUCAS AV Venue:Rosendale Inc:Crit/345 Date:11/01/2012 Time:08:44 78 YOM - NEAR SYNCOPAL EPISODE Addtl:POSSIBLE SOME DIFF BREATHING
((34220) PFLA ) Unit:PG23 UnitSts: Loc:21 FAIRVIEW AV XSts:LUCAS AVE NORTH/DEAD END Venue:Marbletown Inc:Autoalarm Date:10/30/2012 Time:15:06 FIRE ALARM Addtl:KEY PAD ALARM NO KEY HOLDER
((26678) MDAV ) Unit:PG23 UnitSts: Loc:SAWDUST AV/COTTEKILL XSts:COTTEKILL RD/SAWDUST AV Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:23 TRANSFORMER FIRE Addtl:
((26159) MDAV ) Unit:PG23 UnitSts: Loc:241 SAWDUST AV XSts:DISTRICT LINE/COTTEKILL RD Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:11 TREE HANGING LOW OVER ROADWAY-ROAD NEEDS Addtl:TO BE CLOSED-TREE IS ON WIRES
((19911) MDAV ) Unit:PG23 UnitSts: Loc:1 DUTCH BARN DR XSts:ROUTE 213/DEAD END Venue:Rosendale Inc:Brush Fire Date:10/29/2012 Time:12:51 BRUSH FIRE FROM DOWNED WIRE Addtl:VOIP:
((36855) JADS ) Unit:PG23 UnitSts: Loc:930 BERME RD XSts:LAFERA LN/STONE DOCK RD Venue:Marbletown Inc:Autoalarm Date:10/08/2012 Time:07:52 GENERAL FIRE ALARM Addtl:NO KEY HOLDER AS OF YET
((20561) APAS ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:10/01/2012 Time:23:04 UNKNOWN MEDICAL Addtl:L2 COMBS,PHILLIP

Contact: Active911
Agency name: Cottekill Vol. Fire Co.
Location: Cottekill, NY, United States
Sender: CAD@CO.ULSTER.NY.US 

((14991) BFIO ) Unit:PG23 Inc:Autoalarm Nature:FIRST FLR HALLWAY SMOKE DETECTOR Loc:2517 LUCAS TRNP XSts:BEACH LN/REST PLAUS RD   Common:  Venue:Marbletown Addtl: 02/07/2013 17:48
((59668) PFLA ) Unit:PG23 Inc:Stable Nature:81 YOM LIFT ASSISTANCE Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE   Common:  Venue:Rosendale Addtl: 01/30/2013 16:04
((39699) ACAF ) Unit:PG23 Inc:PIAA/040 Nature:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL Loc:MARCOTT RD/LUCAS XSts:LUCAS AV/MARCOTT RD   Common:  Venue:Rosendale Addtl: 01/23/2013 09:48
((38648) PFLA ) Unit:PG23 Inc:Struct Fir Nature:CHIMNEY FIRE Loc:162 STONE DOCK RD XSts:BERME RD/DEAD END   Common:  Venue:Marbletown Addtl: 01/22/2013 18:35
((10732) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SP7 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/10/2013 Time:10:03 28 YOM CHEST PAIN Addtl:APT SP7
((4648) MGAF ) Unit:PG23 UnitSts: Loc:60 LOWER 27 KNOLLS RD XSts:MOSSY BROOK RD/DEAD END Venue:Marbletown Inc:Autoalarm Date:01/07/2013 Time:12:39 FIRST FLOOR SMOKE DETECTOR ACTIVATION Addtl: 3384440
((63725) MDAV ) Unit:PG23 UnitSts: Loc:1000 MOUNTAIN REST RD XSts:SPIES RD/TOWN LINE Venue:Marbletown Inc:Autoalarm Date:01/04/2013 Time:13:37 FIRE ALARM Addtl:MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200
((59422) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD APT1C XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/02/2013 Time:22:45 31 YOM VOMITING BLOOD, CHEST PAINS Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C
((50585) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AV XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:PIAA/040 Date:12/30/2012 Time:10:20 MINOR INJURIES Addtl:VEH IN ROADWAY
((43038) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD DUPLEX B XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:12/27/2012 Time:20:28 62 YOF DIFFICULTY BREATHING Addtl:VOIP:  # B
((40982) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AVENUE EXT XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:Crit/345 Date:12/26/2012 Time:21:07 73 Y/M UNRESPONSIVE Addtl:VOIP:
((33793) MGAF ) Unit:PG23 UnitSts: Loc:19 COXING RD XSts:COTTEKILL RD/ROMNEY WAY Venue:Marbletown Inc:Crit/345 Date:12/23/2012 Time:22:14 90 YOF BLOODY NOSE Addtl:RESD:
((4737) BKIN ) Unit:PG23 UnitSts: Loc:3007 ROUTE 213 XSts:OAKWOOD DR/DISTRICT LINE Venue:Marbletown Inc:Struct Fir Date:12/11/2012 Time:07:22 FIRE IN THE TOASTER OVEN Addtl:REPORTED TO BE OUT
((61601) JWIN ) Unit:PG23 UnitSts: Loc:457 MOHONK RD XSts:STOKES WAY/COUNTY ROUTE 6 Venue:Marbletown Inc:Autoalarm Date:12/07/2012 Time:09:49 LIVING ROOM SMOKE DETECTOR Addtl:
((61063) RQUI ) Unit:PG23 UnitSts: Loc:247 MARCOTT RD XSts:DISTRICT LINE/COXING RD Venue:Marbletown Inc:Crit/345 Date:12/07/2012 Time:04:22 94 YOF SEMI RESPONSIVE SECONDARY TO A FALL Addtl:
((59162) LRME ) Unit:PG23 UnitSts: Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE Venue:Rosendale Inc:Crit/345 Date:12/06/2012 Time:10:52 80 YOM BACK PAIN UNABLE TO AMBULATE Addtl:FD FOR LIFTING
((10208) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/15/2012 Time:10:24 28 YOM ABDOMINAL PAIN Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C
((8143) VPHI ) Unit:PG23 UnitSts: Loc:MOSSY BROOK RD XSts:ROUTE 213/MOUNTAIN RD Venue:Rosendale Inc:Unkwn Fire Date:11/13/2012 Time:20:03 UNKNOWN FIRE Addtl:PARKING AREA ON THE RIGHT
((64420) MDAV ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SPORTS 2 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/10/2012 Time:08:08 35 YOF POSS OVERDOSE Addtl:RESD:  BLDG SPORTS APT 2
((39843) VPHI ) Unit:PG23 UnitSts: Loc:390 MARCOTT RD XSts:TOWN LINE/LUCAS AV Venue:Rosendale Inc:Crit/345 Date:11/01/2012 Time:08:44 78 YOM - NEAR SYNCOPAL EPISODE Addtl:POSSIBLE SOME DIFF BREATHING
((34220) PFLA ) Unit:PG23 UnitSts: Loc:21 FAIRVIEW AV XSts:LUCAS AVE NORTH/DEAD END Venue:Marbletown Inc:Autoalarm Date:10/30/2012 Time:15:06 FIRE ALARM Addtl:KEY PAD ALARM NO KEY HOLDER
((26678) MDAV ) Unit:PG23 UnitSts: Loc:SAWDUST AV/COTTEKILL XSts:COTTEKILL RD/SAWDUST AV Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:23 TRANSFORMER FIRE Addtl:
((26159) MDAV ) Unit:PG23 UnitSts: Loc:241 SAWDUST AV XSts:DISTRICT LINE/COTTEKILL RD Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:11 TREE HANGING LOW OVER ROADWAY-ROAD NEEDS Addtl:TO BE CLOSED-TREE IS ON WIRES
((19911) MDAV ) Unit:PG23 UnitSts: Loc:1 DUTCH BARN DR XSts:ROUTE 213/DEAD END Venue:Rosendale Inc:Brush Fire Date:10/29/2012 Time:12:51 BRUSH FIRE FROM DOWNED WIRE Addtl:VOIP:
((36855) JADS ) Unit:PG23 UnitSts: Loc:930 BERME RD XSts:LAFERA LN/STONE DOCK RD Venue:Marbletown Inc:Autoalarm Date:10/08/2012 Time:07:52 GENERAL FIRE ALARM Addtl:NO KEY HOLDER AS OF YET
((20561) APAS ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:10/01/2012 Time:23:04 UNKNOWN MEDICAL Addtl:L2 COMBS,PHILLIP

*/


public class NYUlsterCountyParserTest extends BaseParserTest {
  
  public NYUlsterCountyParserTest() {
    setParser(new NYUlsterCountyParser(), "ULSTER COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "UNIT:ENG6",
        "ADDR:487 WASHINGTON AV",
        "MADDR:487 WASHINGTON AVE",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "DATE:11/05/2010",
        "TIME:20:44",
        "INFO:GENERAL FIRE ALARM");

    doTest("T2",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "UNIT:ENG6",
        "ADDR:487 WASHINGTON AV",
        "MADDR:487 WASHINGTON AVE",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "DATE:11/05/2010",
        "TIME:20:44",
        "INFO:GENERAL FIRE ALARM");

    doTest("T3",
        "((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl",
        "UNIT:ENG6",
        "ADDR:86 HOFFMAN",
        "X:BROADWAY/MARYS  AV",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:11/03/2010",
        "TIME:21:22",
        "INFO:SMOKE CODITION IN  AREA");

    doTest("T4",
        "((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt",
        "UNIT:ENG6",
        "ADDR:77 CORNELL",
        "X:TREMPER AV/SMITH AV",
        "CITY:KINGSTON",
        "CALL:Haz Mat",
        "DATE:11/02/2010",
        "TIME:00:45",
        "INFO:UNKNOWN ODOR IN BUILDING");
        		

    doTest("T5",
        "((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE",
        "UNIT:ENG6",
        "ADDR:89 NEWKIRK AV",
        "MADDR:89 NEWKIRK AVE",
        "X:HASBROUCK AV/MAPLE",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:11/05/2010",
        "TIME:21:39",
        "INFO:BASEMENT FULL OF SMOKE");

    doTest("T6",
        "FRM:CAD@CO.ULSTER.NY.US\n" +
        "SUBJ:(16733) MGAF/\n" +
        "MSG:Unit:PG68-2 UnitSts: Loc:85 MAIN XSts:WALL/GREEN Venue:King City\n" +
        "Inc:Struct Fir\n" +
        "(Con't) 2 of 2\n" +
        "Date:01/31/2012 Time:14:32 BUILDING ON FIRE Addtl:CNTX:(End)",

        "UNIT:PG68-2",
        "ADDR:85 MAIN",
        "X:WALL/GREEN",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:01/31/2012",
        "TIME:14:32",
        "INFO:BUILDING ON FIRE");
   
  }
  
  @Test
  public void testConorDugan() {

    doTest("T1",
        "((20155) LQUI/) Unit:PG32 Loc:425 CHESTNUT XSts:LAUREL/RIDGEWOOD AV Venue:Hurley Inc:Crit/345 Date:01/15/2013 Time:04:14 80 YOF CHEST PAINS/DIFF BREATHING Addtl",
        "UNIT:PG32",
        "ADDR:425 CHESTNUT",
        "X:LAUREL/RIDGEWOOD AV",
        "CITY:Hurley",
        "CALL:Crit/345",
        "INFO:80 YOF CHEST PAINS/DIFF BREATHING",
        "DATE:01/15/2013",
        "TIME:04:14");

  }
  
  @Test
  public void testJamesSchofield() {

    doTest("T1",
        "ULSTER COUNTY/SHERIFF/911 ((27593) JWIN/ ) Unit:PG80 Inc:Stable Nature:88 Y/F R/O THROMBOSIS Loc:1 JANSEN RD UNIT A RM 10 SOUTH XSts:ROUTE 208/DUBOIS RD   Common:MOUNTAIN VIEW NURSIN  Venue:New Paltz Addtl:UNIT A ROOM 10 SOUTH 04/10/2013 15:17 TXT STOP to opt-out\r",
        "UNIT:PG80",
        "CALL:Stable",
        "INFO:88 Y/F R/O THROMBOSIS / UNIT A ROOM 10 SOUTH 04/10/2013 15:17",
        "ADDR:1 JANSEN RD",
        "APT:UNIT A RM 10 SOUTH",
        "CITY:New Paltz",
        "X:ROUTE 208/DUBOIS RD",
        "PLACE:MOUNTAIN VIEW NURSIN");
   
  }
  
  @Test
  public void testGlascoFire() {

    doTest("T1",
        "{Ulster county 911} Subject:(39995) ACAF/ \n" +
        "Unit:PG29 Inc:Carb Monox Nature:CHGE NEEDS ASSIST GAIING ACCESS-POSSIBLE Loc:8 TERRI DR XSts:SPAULDING LN/DEAD END  ",

        "UNIT:PG29",
        "ADDR:8 TERRI DR",
        "X:SPAULDING LN/DEAD END",
        "CALL:Carb Monox",
        "INFO:CHGE NEEDS ASSIST GAIING ACCESS-POSSIBLE");

    doTest("T2",
        "{Ulster county 911} Subject:(32764) RRLY/ \n" +
        "Unit:PG29 Loc:6 MOUNTAIN VIEW AV XSts:SIMMONS DR/DEAD END Venue:Saugerties Inc:Crit/345 Date:01/20/2013 Time:18:12 7",

        "UNIT:PG29",
        "ADDR:6 MOUNTAIN VIEW AV",
        "MADDR:6 MOUNTAIN VIEW AVE",
        "X:SIMMONS DR/DEAD END",
        "CITY:Saugerties",
        "CALL:Crit/345",
        "DATE:01/20/2013",
        "TIME:18:12",
        "INFO:7");

    doTest("T3",
        "{Ulster county 911} Subject:(28430) BMCC/ \n" +
        "Unit:PG29 Loc:3139 ROUTE 9W XSts:VILLAGE DR/AVON Venue:Saugerties Inc:PIAA/040 Date:01/18/2013 Time:18:25 PIAA Addtl",

        "UNIT:PG29",
        "ADDR:3139 ROUTE 9W",
        "X:VILLAGE DR/AVON",
        "CITY:Saugerties",
        "CALL:PIAA/040",
        "DATE:01/18/2013",
        "TIME:18:25",
        "INFO:PIAA");

    doTest("T4",
        "{Ulster County 911} Subject:(24318) PFLA/ \n" +
        "Unit:PG29 Loc:5 TIGER MAPLE LN XSts:RED MAPLE RD/ROCK MAPLE RD Venue:Saugerties Inc:Misc Date:01/16/2013 Time:20:37 ",

        "UNIT:PG29",
        "ADDR:5 TIGER MAPLE LN",
        "X:RED MAPLE RD/ROCK MAPLE RD",
        "CITY:Saugerties",
        "CALL:Misc",
        "DATE:01/16/2013",
        "TIME:20:37");

    doTest("T5",
        "{Ulster county 911} \n\n" +
        "Subject:(12412) ACAF/ \n" +
        "Unit:PG29 UnitSts: Loc:2035 ROUTE 32 XSts:CAFALDO DR/STEPHEN DR Venue:Saugerties Inc:PIAA/040 Date:01/11/2013 Time:0",

        "UNIT:PG29",
        "ADDR:2035 ROUTE 32",
        "X:CAFALDO DR/STEPHEN DR",
        "CITY:Saugerties",
        "CALL:PIAA/040",
        "DATE:01/11/2013");

    doTest("T6",
        "{Ulster County 911} Subject:(63568) JADS/ \n" +
        "Unit:PG29 UnitSts: Loc:113 COMMONS LN XSts:ROUTE 9W/ROUTE 32 Venue:Saugerties Inc:Crit/345 Date:01/04/2013 Time:12:3",

        "UNIT:PG29",
        "ADDR:113 COMMONS LN",
        "X:ROUTE 9W/ROUTE 32",
        "CITY:Saugerties",
        "CALL:Crit/345",
        "DATE:01/04/2013");

    doTest("T7",
        "{Ulster County 911} Subject:(62554) RQUI/ \n" +
        "Unit:PG29 UnitSts: Loc:52 WASHINGTON AV XSts:CLERMONT/POST Venue:Saugerties Inc:Struct Fir Date:01/04/2013 Time:02:0",

        "UNIT:PG29",
        "ADDR:52 WASHINGTON AV",
        "MADDR:52 WASHINGTON AVE",
        "X:CLERMONT/POST",
        "CITY:Saugerties",
        "CALL:Struct Fir",
        "DATE:01/04/2013");

    doTest("T8",
        "{Ulster County 911} Subject:(60567) ACAF/ \n" +
        "Unit:PG29 UnitSts: Loc:5 AMERIBAG DR XSts:KUKUK LN/DEAD END Venue:Ulster Inc:Autoalarm Date:01/03/2013 Time:14:56 AL",

        "UNIT:PG29",
        "ADDR:5 AMERIBAG DR",
        "X:KUKUK LN/DEAD END",
        "CITY:Ulster",
        "CALL:Autoalarm",
        "DATE:01/03/2013",
        "TIME:14:56",
        "INFO:AL");

    doTest("T9",
        "{Ulster County 911 } Subject:(56110) MGAF/ \n" +
        "Unit:PG29 UnitSts: Loc:13 VILLAGE DR APT 503 XSts:ROUTE 9W/STEVENS CT Venue:Saugerties Inc:Crit/345 Date:01/01/2013 ",

        "UNIT:PG29",
        "ADDR:13 VILLAGE DR",
        "APT:503",
        "X:ROUTE 9W/STEVENS CT",
        "CITY:Saugerties",
        "CALL:Crit/345",
        "DATE:01/01/2013");

    doTest("T10",
        "{Ulster County 911} Subject:(28440) JADS/ \n" +
        "Unit:PG29 UnitSts: Loc:20 DEWITT DR XSts:BLUE HILLS DR/DEAD END Venue:Saugerties Inc:Struct Fir Date:12/21/2012 Time",

        "UNIT:PG29",
        "ADDR:20 DEWITT DR",
        "X:BLUE HILLS DR/DEAD END",
        "CITY:Saugerties",
        "CALL:Struct Fir",
        "DATE:12/21/2012");

    doTest("T11",
        "{Ulster County 911} Subject:(6010) JWIN/ \n" +
        "Unit:PG29 UnitSts: Loc:10 CEDAR LN XSts:BIRCHWOOD DR W/HIGHLAND AV Venue:Saugerties Inc:Autoalarm Date:12/11/2012 Tim",

        "UNIT:PG29",
        "ADDR:10 CEDAR LN",
        "X:BIRCHWOOD DR W/HIGHLAND AV",
        "CITY:Saugerties",
        "CALL:Autoalarm",
        "DATE:12/11/2012");

    doTest("T12",
        "{Ulster County 911} \n" +
        "Subject:(47925) VQUE/ \n" +
        "Unit:PG29 UnitSts: Loc:114 BARCLAY LN XSts:ROUTE 9W/DEAD END Venue:Saugerties Inc:Struct Fir Date:12/01/2012 Time:16",

        "UNIT:PG29",
        "ADDR:114 BARCLAY LN",
        "X:ROUTE 9W/DEAD END",
        "CITY:Saugerties",
        "CALL:Struct Fir",
        "DATE:12/01/2012");
  }
  
  @Test
  public void testCottekillFire() {

    doTest("T1",
        "((59668) PFLA ) Unit:PG23 Inc:Stable Nature:81 YOM LIFT ASSISTANCE Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE   Common:  Venue:Rosendale Addtl: 01/30/2013 16:04",
        "UNIT:PG23",
        "ADDR:227 COTTEKILL RD",
        "X:LUCAS AV/TOWN LINE",
        "CITY:Rosendale",
        "CALL:Stable",
        "DATE:01/30/2013",
        "TIME:16:04",
        "INFO:81 YOM LIFT ASSISTANCE");

    doTest("T2",
        "((39699) ACAF ) Unit:PG23 Inc:PIAA/040 Nature:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL Loc:MARCOTT RD/LUCAS XSts:LUCAS AV/MARCOTT RD   Common:  Venue:Rosendale Addtl: 01/23/2013 09:48",
        "UNIT:PG23",
        "ADDR:MARCOTT RD & LUCAS",
        "X:LUCAS AV/MARCOTT RD",
        "CITY:Rosendale",
        "CALL:PIAA/040",
        "DATE:01/23/2013",
        "TIME:09:48",
        "INFO:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL");

    doTest("T3",
        "((38648) PFLA ) Unit:PG23 Inc:Struct Fir Nature:CHIMNEY FIRE Loc:162 STONE DOCK RD XSts:BERME RD/DEAD END   Common:  Venue:Marbletown Addtl: 01/22/2013 18:35",
        "UNIT:PG23",
        "ADDR:162 STONE DOCK RD",
        "X:BERME RD/DEAD END",
        "CITY:Marbletown",
        "CALL:Struct Fir",
        "DATE:01/22/2013",
        "TIME:18:35",
        "INFO:CHIMNEY FIRE");

    doTest("T4",
        "((10732) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SP7 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/10/2013 Time:10:03 28 YOM CHEST PAIN Addtl:APT SP7",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:7",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:01/10/2013",
        "TIME:10:03",
        "INFO:28 YOM CHEST PAIN / APT SP7");

    doTest("T5",
        "((4648) MGAF ) Unit:PG23 UnitSts: Loc:60 LOWER 27 KNOLLS RD XSts:MOSSY BROOK RD/DEAD END Venue:Marbletown Inc:Autoalarm Date:01/07/2013 Time:12:39 FIRST FLOOR SMOKE DETECTOR ACTIVATION Addtl: 3384440",
        "UNIT:PG23",
        "ADDR:60 LOWER 27 KNOLLS RD",
        "X:MOSSY BROOK RD/DEAD END",
        "CITY:Marbletown",
        "CALL:Autoalarm",
        "DATE:01/07/2013",
        "TIME:12:39",
        "INFO:FIRST FLOOR SMOKE DETECTOR ACTIVATION / 3384440");

    doTest("T6",
        "((63725) MDAV ) Unit:PG23 UnitSts: Loc:1000 MOUNTAIN REST RD XSts:SPIES RD/TOWN LINE Venue:Marbletown Inc:Autoalarm Date:01/04/2013 Time:13:37 FIRE ALARM Addtl:MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200",
        "UNIT:PG23",
        "ADDR:1000 MOUNTAIN REST RD",
        "X:SPIES RD/TOWN LINE",
        "CITY:Marbletown",
        "CALL:Autoalarm",
        "DATE:01/04/2013",
        "TIME:13:37",
        "INFO:FIRE ALARM / MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200");

    doTest("T7",
        "((59422) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD APT1C XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/02/2013 Time:22:45 31 YOM VOMITING BLOOD, CHEST PAINS Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:1C",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:01/02/2013",
        "TIME:22:45",
        "INFO:31 YOM VOMITING BLOOD, CHEST PAINS / RESD:  BLDG COLONIAL FLR 1 APT 1C");

    doTest("T8",
        "((50585) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AV XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:PIAA/040 Date:12/30/2012 Time:10:20 MINOR INJURIES Addtl:VEH IN ROADWAY",
        "UNIT:PG23",
        "ADDR:1654 LUCAS AV",
        "MADDR:1654 LUCAS AVE",
        "X:MARCOTT RD/COTTEKILL ESTATES RD",
        "CITY:Rosendale",
        "CALL:PIAA/040",
        "DATE:12/30/2012",
        "TIME:10:20",
        "INFO:MINOR INJURIES / VEH IN ROADWAY");

    doTest("T9",
        "((43038) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD DUPLEX B XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:12/27/2012 Time:20:28 62 YOF DIFFICULTY BREATHING Addtl:VOIP:  # B",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:DUPLEX B",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:12/27/2012",
        "TIME:20:28",
        "INFO:62 YOF DIFFICULTY BREATHING / VOIP:  # B");

    doTest("T10",
        "((40982) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AVENUE EXT XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:Crit/345 Date:12/26/2012 Time:21:07 73 Y/M UNRESPONSIVE Addtl:VOIP:",
        "UNIT:PG23",
        "ADDR:1654 LUCAS AVENUE EXT",
        "MADDR:1654 LUCAS AVENUE",
        "X:MARCOTT RD/COTTEKILL ESTATES RD",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:12/26/2012",
        "TIME:21:07",
        "INFO:73 Y/M UNRESPONSIVE / VOIP:");

    doTest("T11",
        "((33793) MGAF ) Unit:PG23 UnitSts: Loc:19 COXING RD XSts:COTTEKILL RD/ROMNEY WAY Venue:Marbletown Inc:Crit/345 Date:12/23/2012 Time:22:14 90 YOF BLOODY NOSE Addtl:RESD:",
        "UNIT:PG23",
        "ADDR:19 COXING RD",
        "X:COTTEKILL RD/ROMNEY WAY",
        "CITY:Marbletown",
        "CALL:Crit/345",
        "DATE:12/23/2012",
        "TIME:22:14",
        "INFO:90 YOF BLOODY NOSE / RESD:");

    doTest("T12",
        "((4737) BKIN ) Unit:PG23 UnitSts: Loc:3007 ROUTE 213 XSts:OAKWOOD DR/DISTRICT LINE Venue:Marbletown Inc:Struct Fir Date:12/11/2012 Time:07:22 FIRE IN THE TOASTER OVEN Addtl:REPORTED TO BE OUT",
        "UNIT:PG23",
        "ADDR:3007 ROUTE 213",
        "X:OAKWOOD DR/DISTRICT LINE",
        "CITY:Marbletown",
        "CALL:Struct Fir",
        "DATE:12/11/2012",
        "TIME:07:22",
        "INFO:FIRE IN THE TOASTER OVEN / REPORTED TO BE OUT");

    doTest("T13",
        "((61601) JWIN ) Unit:PG23 UnitSts: Loc:457 MOHONK RD XSts:STOKES WAY/COUNTY ROUTE 6 Venue:Marbletown Inc:Autoalarm Date:12/07/2012 Time:09:49 LIVING ROOM SMOKE DETECTOR Addtl:",
        "UNIT:PG23",
        "ADDR:457 MOHONK RD",
        "X:STOKES WAY/COUNTY ROUTE 6",
        "CITY:Marbletown",
        "CALL:Autoalarm",
        "DATE:12/07/2012",
        "TIME:09:49",
        "INFO:LIVING ROOM SMOKE DETECTOR");

    doTest("T14",
        "((61063) RQUI ) Unit:PG23 UnitSts: Loc:247 MARCOTT RD XSts:DISTRICT LINE/COXING RD Venue:Marbletown Inc:Crit/345 Date:12/07/2012 Time:04:22 94 YOF SEMI RESPONSIVE SECONDARY TO A FALL Addtl:",
        "UNIT:PG23",
        "ADDR:247 MARCOTT RD",
        "X:DISTRICT LINE/COXING RD",
        "CITY:Marbletown",
        "CALL:Crit/345",
        "DATE:12/07/2012",
        "TIME:04:22",
        "INFO:94 YOF SEMI RESPONSIVE SECONDARY TO A FALL");

    doTest("T15",
        "((59162) LRME ) Unit:PG23 UnitSts: Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE Venue:Rosendale Inc:Crit/345 Date:12/06/2012 Time:10:52 80 YOM BACK PAIN UNABLE TO AMBULATE Addtl:FD FOR LIFTING",
        "UNIT:PG23",
        "ADDR:227 COTTEKILL RD",
        "X:LUCAS AV/TOWN LINE",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:12/06/2012",
        "TIME:10:52",
        "INFO:80 YOM BACK PAIN UNABLE TO AMBULATE / FD FOR LIFTING");

    doTest("T16",
        "((10208) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/15/2012 Time:10:24 28 YOM ABDOMINAL PAIN Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:11/15/2012",
        "TIME:10:24",
        "INFO:28 YOM ABDOMINAL PAIN / RESD:  BLDG COLONIAL FLR 1 APT 1C");

    doTest("T17",
        "((8143) VPHI ) Unit:PG23 UnitSts: Loc:MOSSY BROOK RD XSts:ROUTE 213/MOUNTAIN RD Venue:Rosendale Inc:Unkwn Fire Date:11/13/2012 Time:20:03 UNKNOWN FIRE Addtl:PARKING AREA ON THE RIGHT",
        "UNIT:PG23",
        "ADDR:MOSSY BROOK RD",
        "MADDR:MOSSY BROOK RD & ROUTE 213",
        "X:ROUTE 213/MOUNTAIN RD",
        "CITY:Rosendale",
        "CALL:Unkwn Fire",
        "DATE:11/13/2012",
        "TIME:20:03",
        "INFO:UNKNOWN FIRE / PARKING AREA ON THE RIGHT");

    doTest("T18",
        "((64420) MDAV ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SPORTS 2 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/10/2012 Time:08:08 35 YOF POSS OVERDOSE Addtl:RESD:  BLDG SPORTS APT 2",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:SPORTS 2",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:11/10/2012",
        "TIME:08:08",
        "INFO:35 YOF POSS OVERDOSE / RESD:  BLDG SPORTS APT 2");

    doTest("T19",
        "((39843) VPHI ) Unit:PG23 UnitSts: Loc:390 MARCOTT RD XSts:TOWN LINE/LUCAS AV Venue:Rosendale Inc:Crit/345 Date:11/01/2012 Time:08:44 78 YOM - NEAR SYNCOPAL EPISODE Addtl:POSSIBLE SOME DIFF BREATHING",
        "UNIT:PG23",
        "ADDR:390 MARCOTT RD",
        "X:TOWN LINE/LUCAS AV",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:11/01/2012",
        "TIME:08:44",
        "INFO:78 YOM - NEAR SYNCOPAL EPISODE / POSSIBLE SOME DIFF BREATHING");

    doTest("T20",
        "((34220) PFLA ) Unit:PG23 UnitSts: Loc:21 FAIRVIEW AV XSts:LUCAS AVE NORTH/DEAD END Venue:Marbletown Inc:Autoalarm Date:10/30/2012 Time:15:06 FIRE ALARM Addtl:KEY PAD ALARM NO KEY HOLDER",
        "UNIT:PG23",
        "ADDR:21 FAIRVIEW AV",
        "MADDR:21 FAIRVIEW AVE",
        "X:LUCAS AVE NORTH/DEAD END",
        "CITY:Marbletown",
        "CALL:Autoalarm",
        "DATE:10/30/2012",
        "TIME:15:06",
        "INFO:FIRE ALARM / KEY PAD ALARM NO KEY HOLDER");

    doTest("T21",
        "((26678) MDAV ) Unit:PG23 UnitSts: Loc:SAWDUST AV/COTTEKILL XSts:COTTEKILL RD/SAWDUST AV Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:23 TRANSFORMER FIRE Addtl:",
        "UNIT:PG23",
        "ADDR:SAWDUST AV & COTTEKILL",
        "MADDR:SAWDUST AVE & COTTEKILL",
        "X:COTTEKILL RD/SAWDUST AV",
        "CITY:Rosendale",
        "CALL:Elec/Outdr",
        "DATE:10/29/2012",
        "TIME:18:23",
        "INFO:TRANSFORMER FIRE");

    doTest("T22",
        "((26159) MDAV ) Unit:PG23 UnitSts: Loc:241 SAWDUST AV XSts:DISTRICT LINE/COTTEKILL RD Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:11 TREE HANGING LOW OVER ROADWAY-ROAD NEEDS Addtl:TO BE CLOSED-TREE IS ON WIRES",
        "UNIT:PG23",
        "ADDR:241 SAWDUST AV",
        "MADDR:241 SAWDUST AVE",
        "X:DISTRICT LINE/COTTEKILL RD",
        "CITY:Rosendale",
        "CALL:Elec/Outdr",
        "DATE:10/29/2012",
        "TIME:18:11",
        "INFO:TREE HANGING LOW OVER ROADWAY-ROAD NEEDS / TO BE CLOSED-TREE IS ON WIRES");

    doTest("T23",
        "((19911) MDAV ) Unit:PG23 UnitSts: Loc:1 DUTCH BARN DR XSts:ROUTE 213/DEAD END Venue:Rosendale Inc:Brush Fire Date:10/29/2012 Time:12:51 BRUSH FIRE FROM DOWNED WIRE Addtl:VOIP:",
        "UNIT:PG23",
        "ADDR:1 DUTCH BARN DR",
        "X:ROUTE 213/DEAD END",
        "CITY:Rosendale",
        "CALL:Brush Fire",
        "DATE:10/29/2012",
        "TIME:12:51",
        "INFO:BRUSH FIRE FROM DOWNED WIRE / VOIP:");

    doTest("T24",
        "((36855) JADS ) Unit:PG23 UnitSts: Loc:930 BERME RD XSts:LAFERA LN/STONE DOCK RD Venue:Marbletown Inc:Autoalarm Date:10/08/2012 Time:07:52 GENERAL FIRE ALARM Addtl:NO KEY HOLDER AS OF YET",
        "UNIT:PG23",
        "ADDR:930 BERME RD",
        "X:LAFERA LN/STONE DOCK RD",
        "CITY:Marbletown",
        "CALL:Autoalarm",
        "DATE:10/08/2012",
        "TIME:07:52",
        "INFO:GENERAL FIRE ALARM / NO KEY HOLDER AS OF YET");

    doTest("T25",
        "((20561) APAS ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:10/01/2012 Time:23:04 UNKNOWN MEDICAL Addtl:L2 COMBS,PHILLIP",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "X:SAWDUST AV/MICHAEL DR",
        "CITY:Rosendale",
        "CALL:Crit/345",
        "DATE:10/01/2012",
        "TIME:23:04",
        "INFO:UNKNOWN MEDICAL / L2 COMBS,PHILLIP");

  }
  
  @Test
  public void testCottekillFire2() {

    doTest("T1",
        "((14991) BFIO ) Unit:PG23 Inc:Autoalarm Nature:FIRST FLR HALLWAY SMOKE DETECTOR Loc:2517 LUCAS TRNP XSts:BEACH LN/REST PLAUS RD   Common:  Venue:Marbletown Addtl: 02/07/2013 17:48",
        "UNIT:PG23",
        "CALL:Autoalarm",
        "INFO:FIRST FLR HALLWAY SMOKE DETECTOR",
        "DATE:02/07/2013",
        "TIME:17:48",
        "ADDR:2517 LUCAS TRNP",
        "CITY:Marbletown",
        "X:BEACH LN/REST PLAUS RD");

    doTest("T2",
        "((59668) PFLA ) Unit:PG23 Inc:Stable Nature:81 YOM LIFT ASSISTANCE Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE   Common:  Venue:Rosendale Addtl: 01/30/2013 16:04",
        "UNIT:PG23",
        "CALL:Stable",
        "INFO:81 YOM LIFT ASSISTANCE",
        "DATE:01/30/2013",
        "TIME:16:04",
        "ADDR:227 COTTEKILL RD",
        "CITY:Rosendale",
        "X:LUCAS AV/TOWN LINE");

    doTest("T3",
        "((39699) ACAF ) Unit:PG23 Inc:PIAA/040 Nature:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL Loc:MARCOTT RD/LUCAS XSts:LUCAS AV/MARCOTT RD   Common:  Venue:Rosendale Addtl: 01/23/2013 09:48",
        "UNIT:PG23",
        "CALL:PIAA/040",
        "INFO:2 VEH - AIRBAG DEPLOYMENT - PD REQ EVAL",
        "DATE:01/23/2013",
        "TIME:09:48",
        "ADDR:MARCOTT RD & LUCAS",
        "CITY:Rosendale",
        "X:LUCAS AV/MARCOTT RD");

    doTest("T4",
        "((38648) PFLA ) Unit:PG23 Inc:Struct Fir Nature:CHIMNEY FIRE Loc:162 STONE DOCK RD XSts:BERME RD/DEAD END   Common:  Venue:Marbletown Addtl: 01/22/2013 18:35",
        "UNIT:PG23",
        "CALL:Struct Fir",
        "INFO:CHIMNEY FIRE",
        "DATE:01/22/2013",
        "TIME:18:35",
        "ADDR:162 STONE DOCK RD",
        "CITY:Marbletown",
        "X:BERME RD/DEAD END");

    doTest("T5",
        "((10732) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SP7 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/10/2013 Time:10:03 28 YOM CHEST PAIN Addtl:APT SP7",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:7",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:01/10/2013",
        "TIME:10:03",
        "INFO:28 YOM CHEST PAIN / APT SP7");

    doTest("T6",
        "((4648) MGAF ) Unit:PG23 UnitSts: Loc:60 LOWER 27 KNOLLS RD XSts:MOSSY BROOK RD/DEAD END Venue:Marbletown Inc:Autoalarm Date:01/07/2013 Time:12:39 FIRST FLOOR SMOKE DETECTOR ACTIVATION Addtl: 3384440",
        "UNIT:PG23",
        "ADDR:60 LOWER 27 KNOLLS RD",
        "CITY:Marbletown",
        "X:MOSSY BROOK RD/DEAD END",
        "CALL:Autoalarm",
        "DATE:01/07/2013",
        "TIME:12:39",
        "INFO:FIRST FLOOR SMOKE DETECTOR ACTIVATION / 3384440");

    doTest("T7",
        "((63725) MDAV ) Unit:PG23 UnitSts: Loc:1000 MOUNTAIN REST RD XSts:SPIES RD/TOWN LINE Venue:Marbletown Inc:Autoalarm Date:01/04/2013 Time:13:37 FIRE ALARM Addtl:MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200",
        "UNIT:PG23",
        "ADDR:1000 MOUNTAIN REST RD",
        "CITY:Marbletown",
        "X:SPIES RD/TOWN LINE",
        "CALL:Autoalarm",
        "DATE:01/04/2013",
        "TIME:13:37",
        "INFO:FIRE ALARM / MAIN HOUSE SPRINKLER WATER FLOW CB 8458971200");

    doTest("T8",
        "((59422) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD APT1C XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:01/02/2013 Time:22:45 31 YOM VOMITING BLOOD, CHEST PAINS Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:1C",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:01/02/2013",
        "TIME:22:45",
        "INFO:31 YOM VOMITING BLOOD, CHEST PAINS / RESD:  BLDG COLONIAL FLR 1 APT 1C");

    doTest("T9",
        "((50585) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AV XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:PIAA/040 Date:12/30/2012 Time:10:20 MINOR INJURIES Addtl:VEH IN ROADWAY",
        "UNIT:PG23",
        "ADDR:1654 LUCAS AV",
        "MADDR:1654 LUCAS AVE",
        "CITY:Rosendale",
        "X:MARCOTT RD/COTTEKILL ESTATES RD",
        "CALL:PIAA/040",
        "DATE:12/30/2012",
        "TIME:10:20",
        "INFO:MINOR INJURIES / VEH IN ROADWAY");

    doTest("T10",
        "((43038) PFLA ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD DUPLEX B XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:12/27/2012 Time:20:28 62 YOF DIFFICULTY BREATHING Addtl:VOIP:  # B",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:DUPLEX B",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:12/27/2012",
        "TIME:20:28",
        "INFO:62 YOF DIFFICULTY BREATHING / VOIP:  # B");

    doTest("T11",
        "((40982) ACAF ) Unit:PG23 UnitSts: Loc:1654 LUCAS AVENUE EXT XSts:MARCOTT RD/COTTEKILL ESTATES RD Venue:Rosendale Inc:Crit/345 Date:12/26/2012 Time:21:07 73 Y/M UNRESPONSIVE Addtl:VOIP:",
        "UNIT:PG23",
        "ADDR:1654 LUCAS AVENUE EXT",
        "MADDR:1654 LUCAS AVENUE",
        "CITY:Rosendale",
        "X:MARCOTT RD/COTTEKILL ESTATES RD",
        "CALL:Crit/345",
        "DATE:12/26/2012",
        "TIME:21:07",
        "INFO:73 Y/M UNRESPONSIVE / VOIP:");

    doTest("T12",
        "((33793) MGAF ) Unit:PG23 UnitSts: Loc:19 COXING RD XSts:COTTEKILL RD/ROMNEY WAY Venue:Marbletown Inc:Crit/345 Date:12/23/2012 Time:22:14 90 YOF BLOODY NOSE Addtl:RESD:",
        "UNIT:PG23",
        "ADDR:19 COXING RD",
        "CITY:Marbletown",
        "X:COTTEKILL RD/ROMNEY WAY",
        "CALL:Crit/345",
        "DATE:12/23/2012",
        "TIME:22:14",
        "INFO:90 YOF BLOODY NOSE / RESD:");

    doTest("T13",
        "((4737) BKIN ) Unit:PG23 UnitSts: Loc:3007 ROUTE 213 XSts:OAKWOOD DR/DISTRICT LINE Venue:Marbletown Inc:Struct Fir Date:12/11/2012 Time:07:22 FIRE IN THE TOASTER OVEN Addtl:REPORTED TO BE OUT",
        "UNIT:PG23",
        "ADDR:3007 ROUTE 213",
        "CITY:Marbletown",
        "X:OAKWOOD DR/DISTRICT LINE",
        "CALL:Struct Fir",
        "DATE:12/11/2012",
        "TIME:07:22",
        "INFO:FIRE IN THE TOASTER OVEN / REPORTED TO BE OUT");

    doTest("T14",
        "((61601) JWIN ) Unit:PG23 UnitSts: Loc:457 MOHONK RD XSts:STOKES WAY/COUNTY ROUTE 6 Venue:Marbletown Inc:Autoalarm Date:12/07/2012 Time:09:49 LIVING ROOM SMOKE DETECTOR Addtl:",
        "UNIT:PG23",
        "ADDR:457 MOHONK RD",
        "CITY:Marbletown",
        "X:STOKES WAY/COUNTY ROUTE 6",
        "CALL:Autoalarm",
        "DATE:12/07/2012",
        "TIME:09:49",
        "INFO:LIVING ROOM SMOKE DETECTOR");

    doTest("T15",
        "((61063) RQUI ) Unit:PG23 UnitSts: Loc:247 MARCOTT RD XSts:DISTRICT LINE/COXING RD Venue:Marbletown Inc:Crit/345 Date:12/07/2012 Time:04:22 94 YOF SEMI RESPONSIVE SECONDARY TO A FALL Addtl:",
        "UNIT:PG23",
        "ADDR:247 MARCOTT RD",
        "CITY:Marbletown",
        "X:DISTRICT LINE/COXING RD",
        "CALL:Crit/345",
        "DATE:12/07/2012",
        "TIME:04:22",
        "INFO:94 YOF SEMI RESPONSIVE SECONDARY TO A FALL");

    doTest("T16",
        "((59162) LRME ) Unit:PG23 UnitSts: Loc:227 COTTEKILL RD XSts:LUCAS AV/TOWN LINE Venue:Rosendale Inc:Crit/345 Date:12/06/2012 Time:10:52 80 YOM BACK PAIN UNABLE TO AMBULATE Addtl:FD FOR LIFTING",
        "UNIT:PG23",
        "ADDR:227 COTTEKILL RD",
        "CITY:Rosendale",
        "X:LUCAS AV/TOWN LINE",
        "CALL:Crit/345",
        "DATE:12/06/2012",
        "TIME:10:52",
        "INFO:80 YOM BACK PAIN UNABLE TO AMBULATE / FD FOR LIFTING");

    doTest("T17",
        "((10208) VQUE ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/15/2012 Time:10:24 28 YOM ABDOMINAL PAIN Addtl:RESD:  BLDG COLONIAL FLR 1 APT 1C",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:11/15/2012",
        "TIME:10:24",
        "INFO:28 YOM ABDOMINAL PAIN / RESD:  BLDG COLONIAL FLR 1 APT 1C");

    doTest("T18",
        "((8143) VPHI ) Unit:PG23 UnitSts: Loc:MOSSY BROOK RD XSts:ROUTE 213/MOUNTAIN RD Venue:Rosendale Inc:Unkwn Fire Date:11/13/2012 Time:20:03 UNKNOWN FIRE Addtl:PARKING AREA ON THE RIGHT",
        "UNIT:PG23",
        "ADDR:MOSSY BROOK RD",
        "MADDR:MOSSY BROOK RD & ROUTE 213",
        "CITY:Rosendale",
        "X:ROUTE 213/MOUNTAIN RD",
        "CALL:Unkwn Fire",
        "DATE:11/13/2012",
        "TIME:20:03",
        "INFO:UNKNOWN FIRE / PARKING AREA ON THE RIGHT");

    doTest("T19",
        "((64420) MDAV ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD SPORTS 2 XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:11/10/2012 Time:08:08 35 YOF POSS OVERDOSE Addtl:RESD:  BLDG SPORTS APT 2",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "APT:SPORTS 2",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:11/10/2012",
        "TIME:08:08",
        "INFO:35 YOF POSS OVERDOSE / RESD:  BLDG SPORTS APT 2");

    doTest("T20",
        "((39843) VPHI ) Unit:PG23 UnitSts: Loc:390 MARCOTT RD XSts:TOWN LINE/LUCAS AV Venue:Rosendale Inc:Crit/345 Date:11/01/2012 Time:08:44 78 YOM - NEAR SYNCOPAL EPISODE Addtl:POSSIBLE SOME DIFF BREATHING",
        "UNIT:PG23",
        "ADDR:390 MARCOTT RD",
        "CITY:Rosendale",
        "X:TOWN LINE/LUCAS AV",
        "CALL:Crit/345",
        "DATE:11/01/2012",
        "TIME:08:44",
        "INFO:78 YOM - NEAR SYNCOPAL EPISODE / POSSIBLE SOME DIFF BREATHING");

    doTest("T21",
        "((34220) PFLA ) Unit:PG23 UnitSts: Loc:21 FAIRVIEW AV XSts:LUCAS AVE NORTH/DEAD END Venue:Marbletown Inc:Autoalarm Date:10/30/2012 Time:15:06 FIRE ALARM Addtl:KEY PAD ALARM NO KEY HOLDER",
        "UNIT:PG23",
        "ADDR:21 FAIRVIEW AV",
        "MADDR:21 FAIRVIEW AVE",
        "CITY:Marbletown",
        "X:LUCAS AVE NORTH/DEAD END",
        "CALL:Autoalarm",
        "DATE:10/30/2012",
        "TIME:15:06",
        "INFO:FIRE ALARM / KEY PAD ALARM NO KEY HOLDER");

    doTest("T22",
        "((26678) MDAV ) Unit:PG23 UnitSts: Loc:SAWDUST AV/COTTEKILL XSts:COTTEKILL RD/SAWDUST AV Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:23 TRANSFORMER FIRE Addtl:",
        "UNIT:PG23",
        "ADDR:SAWDUST AV & COTTEKILL",
        "MADDR:SAWDUST AVE & COTTEKILL",
        "CITY:Rosendale",
        "X:COTTEKILL RD/SAWDUST AV",
        "CALL:Elec/Outdr",
        "DATE:10/29/2012",
        "TIME:18:23",
        "INFO:TRANSFORMER FIRE");

    doTest("T23",
        "((26159) MDAV ) Unit:PG23 UnitSts: Loc:241 SAWDUST AV XSts:DISTRICT LINE/COTTEKILL RD Venue:Rosendale Inc:Elec/Outdr Date:10/29/2012 Time:18:11 TREE HANGING LOW OVER ROADWAY-ROAD NEEDS Addtl:TO BE CLOSED-TREE IS ON WIRES",
        "UNIT:PG23",
        "ADDR:241 SAWDUST AV",
        "MADDR:241 SAWDUST AVE",
        "CITY:Rosendale",
        "X:DISTRICT LINE/COTTEKILL RD",
        "CALL:Elec/Outdr",
        "DATE:10/29/2012",
        "TIME:18:11",
        "INFO:TREE HANGING LOW OVER ROADWAY-ROAD NEEDS / TO BE CLOSED-TREE IS ON WIRES");

    doTest("T24",
        "((19911) MDAV ) Unit:PG23 UnitSts: Loc:1 DUTCH BARN DR XSts:ROUTE 213/DEAD END Venue:Rosendale Inc:Brush Fire Date:10/29/2012 Time:12:51 BRUSH FIRE FROM DOWNED WIRE Addtl:VOIP:",
        "UNIT:PG23",
        "ADDR:1 DUTCH BARN DR",
        "CITY:Rosendale",
        "X:ROUTE 213/DEAD END",
        "CALL:Brush Fire",
        "DATE:10/29/2012",
        "TIME:12:51",
        "INFO:BRUSH FIRE FROM DOWNED WIRE / VOIP:");

    doTest("T25",
        "((36855) JADS ) Unit:PG23 UnitSts: Loc:930 BERME RD XSts:LAFERA LN/STONE DOCK RD Venue:Marbletown Inc:Autoalarm Date:10/08/2012 Time:07:52 GENERAL FIRE ALARM Addtl:NO KEY HOLDER AS OF YET",
        "UNIT:PG23",
        "ADDR:930 BERME RD",
        "CITY:Marbletown",
        "X:LAFERA LN/STONE DOCK RD",
        "CALL:Autoalarm",
        "DATE:10/08/2012",
        "TIME:07:52",
        "INFO:GENERAL FIRE ALARM / NO KEY HOLDER AS OF YET");

    doTest("T26",
        "((20561) APAS ) Unit:PG23 UnitSts: Loc:168 COTTEKILL RD XSts:SAWDUST AV/MICHAEL DR Venue:Rosendale Inc:Crit/345 Date:10/01/2012 Time:23:04 UNKNOWN MEDICAL Addtl:L2 COMBS,PHILLIP",
        "UNIT:PG23",
        "ADDR:168 COTTEKILL RD",
        "CITY:Rosendale",
        "X:SAWDUST AV/MICHAEL DR",
        "CALL:Crit/345",
        "DATE:10/01/2012",
        "TIME:23:04",
        "INFO:UNKNOWN MEDICAL / L2 COMBS,PHILLIP");

  }
  
  public static void main(String[] args) {
    new NYUlsterCountyParserTest().generateTests("T1");
  }
}
