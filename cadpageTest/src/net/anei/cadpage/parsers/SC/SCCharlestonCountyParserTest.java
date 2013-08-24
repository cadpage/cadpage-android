package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.SC.SCCharlestonCountyParser;

import org.junit.Test;

/*
Charleston County, SC
Contact: Gary Durgin <gary.durgin@charlestonrescue.com>
Contact: 5155707818@vtext.com
Sender: CDC_Dispatch@charlestoncounty.org ??
1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04
1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann
1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04
1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid
1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident
1110-0001582 District 01 Rescue Water Rescue Strnd Motorist  B Address: Jetty's Of Charelston Harbor X Street:  Charleston Harbor
1110-0001589 District 11 A Entrapment Unknown B Address: HIGHWAY 41 / N HIGHWAY 17 X Street:  COSMIC DOGS HOT DOG STAND Cmd Channe
1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04
1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident
1110-0001562 District 02 Rescue MVA Unknown B Address: Rivers Av / Mark Clark Expwy X Street:  On Mark Clark East Bound Cmd Channel:
1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd ...
1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd / Dogwood Rd X Street:  ALT# 843-327-8597 Cmd Channel:
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel:
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...
1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel: Incident 10
1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:
1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04
1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:
1211-0002346 District 09 Rescue Entrapment Unknown B Address: Dorchester Rd / Hill Blvd X Street:  IFO HUNLEY PARK Cmd Channel:  In

Contact: Michael Helms <mhelms1125@gmail.com>
Sender: CDC_Dispatch@charlestoncounty.org
Medical Assist Charlie Respons 1605 Highway 41 X Street: JOE ROUSE RD/JOE ROUSE RD Op Channel: EMS OPS

Contact: Gregory Kramer <g.j.kramer@gmail.com>
(Dispatch Info) ANY MEMBER AVAILABLE TO ASSIST WITH THE SOCON BASEBALL TOURNAMENT TOMM CONTACT 619 AS SOON AS POSSIBLE. OPR#5

Contact: Patrick Phillips <james.patrick.phillips@gmail.com>
(Dispatch Info) Medical Assist Bravo Response 1717 River Rd X Street: TOBY RD/UNNAMED_298 ST Cmnd Channel: EMS OPS

 
Contact: Josh Sims <josh.sims00@gmail.com>
From: CDC_Dispatch@charlestoncounty.org
(Dispatch Info) M04           0338252             District 04 EMS     04B01A    1402 Camp Rd        XS:SECESSIONVILLE RD/JAMES POINT DR  Apt/Bldg: 8           04B_Assault Poss Dang Area    Location Name:Fini Event Planning
(Dispatch Info) M04           0347732             District 04 EMS     06D02A    311 Fleming Rd      XS:MAYBANK HWY/STIRCREEK RD          Apt/Bldg:
(Dispatch Info) M04           0348340             District 04 EMS     33C06T    2 Bishop Gadsden WayXS:CAMP RD/CHESIRE DR                Apt/Bldg: 1059        33C_Transfer Emrgncy Respnse TLocation Name:MEYERS HALL
(Dispatch Info) M04           0348332             District 04 EMS     26C02     2 BISHOP GADSDEN WAYXS:CAMP RD/CHESIRE DR                Apt/Bldg: APT 1002    26C_Sick Abnormal Breathing   Location Name:
(Dispatch Info) M04           0348435             District 01 EMS     01C05     573 Meeting St      XS:JOHNSON ST/STUART ST              Apt/Bldg:             01C_Abn Pain Abv Navl Male >35Location Name:Crisis Ministries Sh
(Dispatch Info) M04           0348430             District 04 EMS     131C01    Riverland Dr / CanalXS:                                  Apt/Bldg:             29B_Accident MVA Unknown      Location Name:

Contact: John G. McClure <scimmitar@bellsouth.net>
Sender: MBall@charlestoncounty.org
(Dispatch Info) Medical Assist Charlie Respons 4758 Wilson Rd X Street: UNNAMED_4623 ST/TOOGOODOO FARM RD Cmnd Channel: 1_Incident 16 Units Assign

Contact: Roger Walsh <rwalsh2432@gmail.com>
Medical Assist Alpha Response 1121 Sampson Rd X Street: N HIGHWAY 17/Dead End Cmnd Channel: 1_Incident 16 Units Assigned: E902 Time: 06:42

Agency name: CDC
Location: North Charleston, SC, United States
Contact: Active911
Sender: <CDC_Dispatch@charlestoncounty.org>

(Dispatch Info) Medical Assist Charlie Respons Response Area: NCFD SOUTH 07 2663 Lawrence St X Street: OREGON AV/DECATUR ST Cmnd Channel:  Units Assigned: E207
(Dispatch Info) Medical Assist Delta Response 5752 N Jupiter Hill Rd X Street: TOOTH FAIRY WAY/Dead End Cmnd Channel:  Units Assigned: E1405
(Dispatch Info) Medical Assist Delta Response Response Area: NCFD SOUTH 01 4543 Holly St X Street: FERN PL/DURANT AV Cmnd Channel: 1_Incident 16 Units Assigned: E201
(Dispatch Info) Medical Assist Charlie Respons 6260 Highway 162 X Street: HOLLYWOOD DR/HIGHWAY 165 Cmnd Channel: 1_Incident 16 Units Assigned: E1401
(Dispatch Info) Medical Assist Delta Response Response Area: NCFD EAST 10 2814 Penobscott Dr X Street: KITTERY AV/Dead End Cmnd Channel: 1_Incident 16 Units Assigned: E210
(Dispatch Info) Medical Assist Bravo Response Response Area: NCFD EAST 06 7373 Northwoods Blvd X Street: UNNAMED_5089 ST/ASHLEY PHOSPHATE RD Cmnd Channel: 1_Incident 16 Units Assigned: E210
(Dispatch Info) Medical Assist Bravo Response 7146 Savannah Hwy X Street: UNNAMED_3522 ST/MEDIAN CROSSOVER Cmnd Channel: 1_Incident 16 Units Assigned: E1404
(Dispatch Info) Medical Assist Bravo Response Response Area: JIFD 183 1707 Mcleod Av X Street: FOLLY RD/YALE DR Cmnd Channel: 1_Incident 16 Units Assigned: E113
(Dispatch Info) Medical Assist Delta Response 5651 Heyward Smalls Rd X Street: Dead End/SALTERS HILL RD Cmnd Channel: 1_Incident 16 Units Assigned: E1401
(Dispatch Info) Medical Assist Delta Response Response Area: FD WEST ASHLEY RIVER 3342 Stonehaven Dr X Street: BRANDYWINE RD/PEPPERCORN LN Cmnd Channel: 1_Incident 16 Units Assigned: E206

 */

public class SCCharlestonCountyParserTest extends BaseParserTest {
  
  public SCCharlestonCountyParserTest() {
    setParser(new SCCharlestonCountyParser(), "CHARLESTON COUNTY", "SC");
  }
  
  @Test
  public void testBad() {
    doBadTest("Dispatch Info) ANY MEMBER AVAILABLE TO ASSIST WITH THE SOCON BASEBALL TOURNAMENT TOMM CONTACT 619 AS SOON AS POSSIBLE. OPR#5");
  }
  
  @Test
  public void testAParser() {
    doTest("T1",
        "1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04" ,
        "SRC:03",
        "CALL:Rescue Rescue Needed",
        "ADDR:Orleans Rd & Sam Rittenberg Blvd",
        "ID:1110-0001587",
        "CH:Incident 04");
    
    doTest("T2",
        "1110-0001574 District 03 Rescue MVA Entrapment D Address: Playground Rd / Ashley River Rd X Street:   Cmd Channel: Incident 07" ,
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Playground Rd & Ashley River Rd",
        "ID:1110-0001574",
        "CH:Incident 07");
    
    doTest("T3",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Chann" ,
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "ID:1110-0001568");
    
    doTest("T4",
        "1110-0001577 District 09 Rescue Rescue Needed Address: Ashley Phosphate Rd / Stall Rd X Street:   Cmd Channel: Incident 04" ,
        "SRC:09",
        "CALL:Rescue Rescue Needed",
        "ADDR:Ashley Phosphate Rd & Stall Rd",
        "ID:1110-0001577",
        "CH:Incident 04");
    
    doTest("T5",
        "1110-0001580 District 12 Rescue MVA Major Incident D Address: International Blvd / Mark Clark Expwy X Street:   Cmd Channel: Incid" ,
        "SRC:12",
        "CALL:Rescue MVA Major Incident D",
        "ADDR:International Blvd & Mark Clark Expwy",
        "ID:1110-0001580",
        "CH:Incid");
    
    doTest("T6",
        "1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident" ,
        "SRC:11",
        "CALL:A Rescue Needed",
        "ADDR:2324 Andover Way",
        "X:PARSONAGE WOODS LN/BANCROFT LN",
        "ID:1110-0001581",
        "CH:Incident");

    doTest("T7",
        "1110-0001582 District 01 Rescue Water Rescue Strnd Motorist  B Address: Jetty's Of Charelston Harbor X Street:  Charleston Harbor",
        "ID:1110-0001582",
        "SRC:01",
        "CALL:Rescue Water Rescue Strnd Motorist  B",
        "ADDR:Jetty's Of Charelston Harbor",
        "MADDR:Jetty's Of Charelston Harbor & Charleston Harbor",
        "X:Charleston Harbor");

    doTest("T8",
        "1110-0001589 District 11 A Entrapment Unknown B Address: HIGHWAY 41 / N HIGHWAY 17 X Street:  COSMIC DOGS HOT DOG STAND Cmd Channe",
        "ID:1110-0001589",
        "SRC:11",
        "CALL:A Entrapment Unknown B",
        "ADDR:HIGHWAY 41 & N HIGHWAY 17",
        "X:COSMIC DOGS HOT DOG STAND");

    doTest("T9",
        "1110-0001587 District 03 Rescue Rescue Needed Address: Orleans Rd / Sam Rittenberg Blvd X Street:   Cmd Channel: Incident 04",
        "ID:1110-0001587",
        "SRC:03",
        "CALL:Rescue Rescue Needed",
        "ADDR:Orleans Rd & Sam Rittenberg Blvd",
        "CH:Incident 04");

    doTest("T10",
        "1110-0001581 District 11 A Rescue Needed Address: 2324 Andover Way X Street: PARSONAGE WOODS LN/BANCROFT LN  Cmd Channel: Incident",
        "ID:1110-0001581",
        "SRC:11",
        "CALL:A Rescue Needed",
        "ADDR:2324 Andover Way",
        "X:PARSONAGE WOODS LN/BANCROFT LN",
        "CH:Incident");

    doTest("T11",
        "1110-0001562 District 02 Rescue MVA Unknown B Address: Rivers Av / Mark Clark Expwy X Street:  On Mark Clark East Bound Cmd Channel:",
        "ID:1110-0001562",
        "SRC:02",
        "CALL:Rescue MVA Unknown B",
        "ADDR:Rivers Av & Mark Clark Expwy",
        "MADDR:Rivers Ave & Mark Clark Expwy",
        "X:On Mark Clark East Bound");

    doTest("T12",
        "1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd ...",
        "ID:1110-0001564",
        "SRC:03",
        "CALL:Rescue MVA Other Hazards B",
        "ADDR:Ashley River Rd");

    doTest("T13",
        "1110-0001564 District 03 Rescue MVA Other Hazards B Address: Ashley River Rd / Dogwood Rd X Street:  ALT# 843-327-8597 Cmd Channel:",
        "ID:1110-0001564",
        "SRC:03",
        "CALL:Rescue MVA Other Hazards B",
        "ADDR:Ashley River Rd & Dogwood Rd",
        "X:ALT# 843-327-8597");

    doTest("T14",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savanna");

    doTest("T15",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel:",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savannah Hwy");

    doTest("T16",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savanna...",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savanna");

    doTest("T17",
        "1110-0001567 District 03 Rescue MVA Entrapment D Address: Wappoo Rd / Savannah Hwy X Street:   Cmd Channel: Incident 10",
        "ID:1110-0001567",
        "SRC:03",
        "CALL:Rescue MVA Entrapment D",
        "ADDR:Wappoo Rd & Savannah Hwy",
        "CH:Incident 10");

    doTest("T18",
        "1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA w/Injury B",
        "ADDR:JAMES ISLAND EXPWY");

    doTest("T19",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T20",
        "1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:",
        "ID:1110-0001570",
        "SRC:01",
        "CALL:Rescue Medical Assist Bravo Response",
        "ADDR:93 America St",
        "X:E HAMPSTEAD SQUARE/BLAKE ST");

    doTest("T21",
        "1110-0001568 District 04 Rescue MVA w/Injury B Address: JAMES ISLAND EXPWY / ...",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA w/Injury B",
        "ADDR:JAMES ISLAND EXPWY");

    doTest("T22",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T23",
        "1110-0001568 District 04 Rescue MVA  w/Injury B Address: JAMES ISLAND EXPWY / FOLLY RD X Street:  JAMES ISLAND CONNECTOR Cmd Channel: Incident 04",
        "ID:1110-0001568",
        "SRC:04",
        "CALL:Rescue MVA  w/Injury B",
        "ADDR:JAMES ISLAND EXPWY & FOLLY RD",
        "X:JAMES ISLAND CONNECTOR",
        "CH:Incident 04");

    doTest("T24",
        "1110-0001570 District 01 Rescue Medical Assist Bravo Response Address: 93 America St X Street: E HAMPSTEAD SQUARE/BLAKE ST  Cmd Channel:",
        "ID:1110-0001570",
        "SRC:01",
        "CALL:Rescue Medical Assist Bravo Response",
        "ADDR:93 America St",
        "X:E HAMPSTEAD SQUARE/BLAKE ST");

    doTest("T25",
        "1211-0002346 District 09 Rescue Entrapment Unknown B Address: Dorchester Rd / Hill Blvd X Street:  IFO HUNLEY PARK Cmd Channel:  In",
        "ID:1211-0002346",
        "SRC:09",
        "ADDR:Dorchester Rd & Hill Blvd",
        "X:IFO HUNLEY PARK",
        "CH:In",
        "CALL:Rescue Entrapment Unknown B");
    
  }
  
  @Test
  public void testBParser() {

    doTest("T1",
        "Medical Assist Charlie Respons 1605 Highway 41 X Street: JOE ROUSE RD/JOE ROUSE RD Op Channel: EMS OPS",
        "CALL:Medical Assist Charlie Respons",
        "ADDR:1605 Highway 41",
        "X:JOE ROUSE RD/JOE ROUSE RD",
        "CH:EMS OPS");
    

    doTest("T2",
        "(Dispatch Info) Medical Assist Bravo Response 1717 River Rd X Street: TOBY RD/UNNAMED_298 ST Cmnd Channel: EMS OPS",
        "ADDR:1717 River Rd",
        "X:TOBY RD/UNNAMED_298 ST",
        "CH:EMS OPS",
        "CALL:Medical Assist Bravo Response");
  }
  
  @Test
  public void testFixedLengthParser() {

    doTest("T1",
        "(Dispatch Info) M04           0338252             District 04 EMS     04B01A    1402 Camp Rd        XS:SECESSIONVILLE RD/JAMES POINT DR  Apt/Bldg: 8           04B_Assault Poss Dang Area    Location Name:Fini Event Planning",
        "UNIT:M04",
        "ID:0338252",
        "SRC:04",
        "CALL:EMS",
        "CODE:04B01A",
        "ADDR:1402 Camp Rd",
        "APT:8",
        "X:SECESSIONVILLE RD/JAMES POINT DR",
        "INFO:04B_Assault Poss Dang Area",
        "PLACE:Fini Event Planning");

    doTest("T2",
        "(Dispatch Info) M04           0347732             District 04 EMS     06D02A    311 Fleming Rd      XS:MAYBANK HWY/STIRCREEK RD          Apt/Bldg:",
        "UNIT:M04",
        "ID:0347732",
        "SRC:04",
        "CALL:EMS",
        "CODE:06D02A",
        "ADDR:311 Fleming Rd",
        "X:MAYBANK HWY/STIRCREEK RD");

    doTest("T3",
        "(Dispatch Info) M04           0348340             District 04 EMS     33C06T    2 Bishop Gadsden WayXS:CAMP RD/CHESIRE DR                Apt/Bldg: 1059        33C_Transfer Emrgncy Respnse TLocation Name:MEYERS HALL",
        "UNIT:M04",
        "ID:0348340",
        "SRC:04",
        "CALL:EMS",
        "CODE:33C06T",
        "ADDR:2 Bishop Gadsden Way",
        "APT:1059",
        "X:CAMP RD/CHESIRE DR",
        "INFO:33C_Transfer Emrgncy Respnse T",
        "PLACE:MEYERS HALL");

    doTest("T4",
        "(Dispatch Info) M04           0348332             District 04 EMS     26C02     2 BISHOP GADSDEN WAYXS:CAMP RD/CHESIRE DR                Apt/Bldg: APT 1002    26C_Sick Abnormal Breathing   Location Name:",
        "UNIT:M04",
        "ID:0348332",
        "SRC:04",
        "CALL:EMS",
        "CODE:26C02",
        "ADDR:2 BISHOP GADSDEN WAY",
        "APT:APT 1002",
        "X:CAMP RD/CHESIRE DR",
        "INFO:26C_Sick Abnormal Breathing");

    doTest("T5",
        "(Dispatch Info) M04           0348435             District 01 EMS     01C05     573 Meeting St      XS:JOHNSON ST/STUART ST              Apt/Bldg:             01C_Abn Pain Abv Navl Male >35Location Name:Crisis Ministries Sh",
        "UNIT:M04",
        "ID:0348435",
        "SRC:01",
        "CALL:EMS",
        "CODE:01C05",
        "ADDR:573 Meeting St",
        "X:JOHNSON ST/STUART ST",
        "INFO:01C_Abn Pain Abv Navl Male >35",
        "PLACE:Crisis Ministries Sh");

    doTest("T6",
        "(Dispatch Info) M04           0348430             District 04 EMS     131C01    Riverland Dr / CanalXS:                                  Apt/Bldg:             29B_Accident MVA Unknown      Location Name:",
        "UNIT:M04",
        "ID:0348430",
        "SRC:04",
        "CALL:EMS",
        "CODE:131C01",
        "ADDR:Riverland Dr & Canal",
        "INFO:29B_Accident MVA Unknown");

  }
  
  @Test
  public void testJohnCMcClure() {

    doTest("T1",
        "(Dispatch Info) Medical Assist Charlie Respons 4758 Wilson Rd X Street: UNNAMED_4623 ST/TOOGOODOO FARM RD Cmnd Channel: 1_Incident 16 Units Assign",
        "CALL:Medical Assist Charlie Respons",
        "ADDR:4758 Wilson Rd",
        "X:UNNAMED_4623 ST/TOOGOODOO FARM RD",
        "CH:1_Incident 16");
 
  }
  
  @Test
  public void testRogerWalsh() {

    doTest("T1",
        "Medical Assist Alpha Response 1121 Sampson Rd X Street: N HIGHWAY 17/Dead End Cmnd Channel: 1_Incident 16 Units Assigned: E902 Time: 06:42",
        "UNIT:E902",
        "CALL:Medical Assist Alpha Response",
        "ADDR:1121 Sampson Rd",
        "X:N HIGHWAY 17/Dead End",
        "CH:1_Incident 16",
        "TIME:06:42");
 
  }
  
  @Test
  public void testCDC() {

    doTest("T1",
        "(Dispatch Info) Medical Assist Charlie Respons Response Area: NCFD SOUTH 07 2663 Lawrence St X Street: OREGON AV/DECATUR ST Cmnd Channel:  Units Assigned: E207",
        "CALL:Medical Assist Charlie Respons",
        "MAP:NCFD SOUTH 07",
        "ADDR:2663 Lawrence St",
        "X:OREGON AV/DECATUR ST",
        "UNIT:E207");

    doTest("T2",
        "(Dispatch Info) Medical Assist Delta Response 5752 N Jupiter Hill Rd X Street: TOOTH FAIRY WAY/Dead End Cmnd Channel:  Units Assigned: E1405",
        "CALL:Medical Assist Delta Response",
        "ADDR:5752 N Jupiter Hill Rd",
        "X:TOOTH FAIRY WAY/Dead End",
        "UNIT:E1405");

    doTest("T3",
        "(Dispatch Info) Medical Assist Delta Response Response Area: NCFD SOUTH 01 4543 Holly St X Street: FERN PL/DURANT AV Cmnd Channel: 1_Incident 16 Units Assigned: E201",
        "CALL:Medical Assist Delta Response",
        "MAP:NCFD SOUTH 01",
        "ADDR:4543 Holly St",
        "X:FERN PL/DURANT AV",
        "CH:1_Incident 16",
        "UNIT:E201");

    doTest("T4",
        "(Dispatch Info) Medical Assist Charlie Respons 6260 Highway 162 X Street: HOLLYWOOD DR/HIGHWAY 165 Cmnd Channel: 1_Incident 16 Units Assigned: E1401",
        "CALL:Medical Assist Charlie Respons",
        "ADDR:6260 Highway 162",
        "X:HOLLYWOOD DR/HIGHWAY 165",
        "CH:1_Incident 16",
        "UNIT:E1401");

    doTest("T5",
        "(Dispatch Info) Medical Assist Delta Response Response Area: NCFD EAST 10 2814 Penobscott Dr X Street: KITTERY AV/Dead End Cmnd Channel: 1_Incident 16 Units Assigned: E210",
        "CALL:Medical Assist Delta Response",
        "MAP:NCFD EAST 10",
        "ADDR:2814 Penobscott Dr",
        "X:KITTERY AV/Dead End",
        "CH:1_Incident 16",
        "UNIT:E210");

    doTest("T6",
        "(Dispatch Info) Medical Assist Bravo Response Response Area: NCFD EAST 06 7373 Northwoods Blvd X Street: UNNAMED_5089 ST/ASHLEY PHOSPHATE RD Cmnd Channel: 1_Incident 16 Units Assigned: E210",
        "CALL:Medical Assist Bravo Response",
        "MAP:NCFD EAST 06",
        "ADDR:7373 Northwoods Blvd",
        "X:UNNAMED_5089 ST/ASHLEY PHOSPHATE RD",
        "CH:1_Incident 16",
        "UNIT:E210");

    doTest("T7",
        "(Dispatch Info) Medical Assist Bravo Response 7146 Savannah Hwy X Street: UNNAMED_3522 ST/MEDIAN CROSSOVER Cmnd Channel: 1_Incident 16 Units Assigned: E1404",
        "CALL:Medical Assist Bravo Response",
        "ADDR:7146 Savannah Hwy",
        "X:UNNAMED_3522 ST/MEDIAN CROSSOVER",
        "CH:1_Incident 16",
        "UNIT:E1404");

    doTest("T8",
        "(Dispatch Info) Medical Assist Bravo Response Response Area: JIFD 183 1707 Mcleod Av X Street: FOLLY RD/YALE DR Cmnd Channel: 1_Incident 16 Units Assigned: E113",
        "CALL:Medical Assist Bravo Response",
        "MAP:JIFD 183",
        "ADDR:1707 Mcleod Av",
        "MADDR:1707 Mcleod Ave",
        "X:FOLLY RD/YALE DR",
        "CH:1_Incident 16",
        "UNIT:E113");

    doTest("T9",
        "(Dispatch Info) Medical Assist Delta Response 5651 Heyward Smalls Rd X Street: Dead End/SALTERS HILL RD Cmnd Channel: 1_Incident 16 Units Assigned: E1401",
        "CALL:Medical Assist Delta Response",
        "ADDR:5651 Heyward Smalls Rd",
        "X:Dead End/SALTERS HILL RD",
        "CH:1_Incident 16",
        "UNIT:E1401");

    doTest("T10",
        "(Dispatch Info) Medical Assist Delta Response Response Area: FD WEST ASHLEY RIVER 3342 Stonehaven Dr X Street: BRANDYWINE RD/PEPPERCORN LN Cmnd Channel: 1_Incident 16 Units Assigned: E206",
        "CALL:Medical Assist Delta Response",
        "MAP:FD WEST ASHLEY RIVER",
        "ADDR:3342 Stonehaven Dr",
        "X:BRANDYWINE RD/PEPPERCORN LN",
        "CH:1_Incident 16",
        "UNIT:E206");

  }
  
  public static void main(String[] args) {
    new SCCharlestonCountyParserTest().generateTests("T1");
  }
}