package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kankakee County, IL
Contact: "Steven Spraker" <sspraker@k3twpfire.com>
Sender: dispatchmessage@nwsmessage.net

[NWS Message]  ALARM:FIRE Location: KANKAKEE TERRACE 100 BELLE AIRE AVE Bourbonnais 05/27/11 05:29 Incident #: 2011-00001016
[NWS Message]  SMOKE/ODOR Location: COURT STREET FORD 558 WILLIAM LATHAM DR Bourbonnais 05/09/11 15:57 Incident #: 2011-00000889
[NWS Message]  WIRES DOWN Location: 968 N 2750E RD Kankakee 05/30/11 11:09 Incident #: 2011-00000111
[NWS Message]  AMB:MUTUAL AID Location: 4552/3400N RD 06/01/11 14:00 Incident #: 2011-00000113
[NWS Message]  AMBULANCE Location: 55 SAINT FRANCIS DR Bourbonnais 06/01/11 12:38 Incident #: 2011-00001056
[NWS Message] AMBULANCE Location: 1355 N  ARTHUR BURCH DR F11 Bourbonnais 06/03/11 14:32 Incident #: 2011-00001066
[NWS Message]  AMBULANCE Location: 874 EDWIN DR Bourbonnais 06/01/11 14:24 Incident #: 2011-00004870

Contact: Active911
Agency name: Bourbonnais Fire Protection District
Location: Bourbonnais, IL, United States
Sender: DispatchMessage@NWSMessage.net

(NWS Message) AMBULANCE Location: NORTHFIELD SHELL1711 N  STHY 50 Bourbonnais 03/25/13 08:19 Incident #: 2013-00000584
(NWS Message) AMBULANCE Location: OLIVET NAZARENE UNIVERSITY1 UNIVERSITY AVE Bourbonnais 03/25/13 07:30 Incident #: 2013-00000583
(NWS Message) AMBULANCE Location: 830 HERITAGE DR Bourbonnais 03/25/13 07:26 Incident #: 2013-00000582
(NWS Message) AMBULANCE Location: 1325 N  ARTHUR BURCH DR AD15 Bourbonnais 03/25/13 03:24 Incident #: 2013-00000581
(NWS Message) ACCIDENT Location: ST GEORGE CHURCH5272 E  5000N RD Bourbonnais 03/24/13 21:41 Incident #: 2013-00009763
(NWS Message) AMBULANCE Location: 2848 SPORTSMAN CLUB RD Bourbonnais 03/24/13 19:35 Incident #: 2013-00000579
(NWS Message) 911:ABANDONED Location: 139 MEADOWS RD S SOUTH Bourbonnais 03/24/13 12:01 Incident #: 2013-00002369
(NWS Message) AMBULANCE Location: 1325 N  ARTHUR BURCH DR B9 Bourbonnais 03/24/13 04:42 Incident #: 2013-00000577
(NWS Message) NEW Location: KANKAKEE TERRACE100 BELLE AIRE AVE Bourbonnais 03/24/13 01:31 Incident #: 2013-00000576
(NWS Message) AMBULANCE Location: 105 MEADOWS CT Bourbonnais 03/23/13 21:18 Incident #: 2013-00000575
(NWS Message) AMBULANCE Location: 386 BELLE AIRE AVE Bourbonnais 03/23/13 12:41 Incident #: 2013-00000574
(NWS Message) CONTROL BURN Location: 2000 E  5000N RD Bourbonnais 03/23/13 10:22 Incident #:
(NWS Message) AMBULANCE Location: CLANCYS FUNERAL HOME295 MAIN ST NW Bourbonnais 03/23/13 10:39 Incident #: 2013-00000572
(NWS Message) AMBULANCE Location: 270 N  STADIUM DR 8 Bourbonnais 03/23/13 09:37 Incident #: 2013-00000571
(NWS Message) AMBULANCE Location: 47 EMERY DR Bourbonnais 03/23/13 06:13 Incident #: 2013-00000570
(NWS Message) AMBULANCE Location: 1355 N  ARTHUR BURCH DR N1 Bourbonnais 03/23/13 00:45 Incident #: 2013-00000569
(NWS Message) NEW Location: 282 E  BEAUDOIN AVE Bourbonnais 03/22/13 18:39 Incident #: 2013-00000568
(NWS Message) ALARM:CO DET Location: 341 MOHAWK DR D Bourbonnais 03/22/13 18:26 Incident #: 2013-00000567
(NWS Message) AMBULANCE Location: 349 PRINCETON AVE Bourbonnais 03/22/13 18:09 Incident #: 2013-00002314
(NWS Message) AMBULANCE Location: 2293 W  3100N RD Bourbonnais 03/22/13 17:24 Incident #: 2013-00000565
(NWS Message) ALARM:FIRE Location: 585 WILLIAM LATHAM DR Bourbonnais 03/22/13 17:11 Incident #: 2013-00000564
(NWS Message) AMBULANCE Location: FARM AND FLEET1811 N  STHY 50 Bourbonnais 03/22/13 15:19 Incident #: 2013-00000563
(NWS Message) NEW Location: 581 WILLIAM LATHAM M DR 03/22/13 14:40 Incident #: 2013-00000562
(NWS Message) CONTROL BURN Location: ACME AUTO PARTS2016 E  1000N RD Kankakee 03/22/13 09:31 Incident #:
(NWS Message) AMBULANCE Location: 1133 MEADOWS WALK DR Bourbonnais 03/22/13 01:04 Incident #: 2013-00000561
(NWS Message) AMBULANCE Location: 1 UNIVERSITY AVE Bourbonnais 03/22/13 00:13 Incident #: 2013-00000560

*/

public class ILKankakeeCountyParserTest extends BaseParserTest {
  
  public ILKankakeeCountyParserTest() {
    setParser(new ILKankakeeCountyParser(), "KANKAKEE COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[NWS Message]  ALARM:FIRE Location: KANKAKEE TERRACE 100 BELLE AIRE AVE Bourbonnais 05/27/11 05:29 Incident #: 2011-00001016",
        "CALL:ALARM:FIRE",
        "PLACE:KANKAKEE TERRACE",
        "ADDR:100 BELLE AIRE AVE",
        "CITY:Bourbonnais",
        "ID:2011-00001016");

    doTest("T2",
        "[NWS Message]  SMOKE/ODOR Location: COURT STREET FORD 558 WILLIAM LATHAM DR Bourbonnais 05/09/11 15:57 Incident #: 2011-00000889",
        "CALL:SMOKE/ODOR",
        "PLACE:COURT STREET FORD",
        "ADDR:558 WILLIAM LATHAM DR",
        "CITY:Bourbonnais",
        "ID:2011-00000889");

    doTest("T3",
        "[NWS Message]  WIRES DOWN Location: 968 N 2750E RD Kankakee 05/30/11 11:09 Incident #: 2011-00000111",
        "CALL:WIRES DOWN",
        "ADDR:968 N 2750E RD",
        "CITY:Kankakee",
        "ID:2011-00000111");

    doTest("T4",
        "[NWS Message]  AMB:MUTUAL AID Location: 4552/3400N RD 06/01/11 14:00 Incident #: 2011-00000113",
        "CALL:AMB:MUTUAL AID",
        "ADDR:4552 3400N RD",
        "ID:2011-00000113");

    doTest("T5",
        "[NWS Message]  AMBULANCE Location: 55 SAINT FRANCIS DR Bourbonnais 06/01/11 12:38 Incident #: 2011-00001056",
        "CALL:AMBULANCE",
        "ADDR:55 SAINT FRANCIS DR",
        "CITY:Bourbonnais",
        "ID:2011-00001056");

    doTest("T6",
        "[NWS Message] AMBULANCE Location: 1355 N  ARTHUR BURCH DR F11 Bourbonnais 06/03/11 14:32 Incident #: 2011-00001066",
        "CALL:AMBULANCE",
        "ADDR:1355 N ARTHUR BURCH DR",
        "APT:F11",
        "CITY:Bourbonnais",
        "ID:2011-00001066");

    doTest("T7",
        "[NWS Message]  AMBULANCE Location: 874 EDWIN DR Bourbonnais 06/01/11 14:24 Incident #: 2011-00004870",
        "CALL:AMBULANCE",
        "ADDR:874 EDWIN DR",
        "CITY:Bourbonnais",
        "ID:2011-00004870");
    
  }
  
  @Test
  public void testBourbonnaisFire() {

    doTest("T1",
        "(NWS Message) AMBULANCE Location: NORTHFIELD SHELL1711 N  STHY 50 Bourbonnais 03/25/13 08:19 Incident #: 2013-00000584",
        "CALL:AMBULANCE",
        "PLACE:NORTHFIELD SHELL1711",
        "ADDR:N STHY 50",
        "MADDR:N ST 50",
        "CITY:Bourbonnais",
        "ID:2013-00000584");

    doTest("T2",
        "(NWS Message) AMBULANCE Location: OLIVET NAZARENE UNIVERSITY1 UNIVERSITY AVE Bourbonnais 03/25/13 07:30 Incident #: 2013-00000583",
        "CALL:AMBULANCE",
        "PLACE:OLIVET NAZARENE UNIVERSITY1",
        "ADDR:UNIVERSITY AVE",
        "CITY:Bourbonnais",
        "ID:2013-00000583");

    doTest("T3",
        "(NWS Message) AMBULANCE Location: 830 HERITAGE DR Bourbonnais 03/25/13 07:26 Incident #: 2013-00000582",
        "CALL:AMBULANCE",
        "ADDR:830 HERITAGE DR",
        "CITY:Bourbonnais",
        "ID:2013-00000582");

    doTest("T4",
        "(NWS Message) AMBULANCE Location: 1325 N  ARTHUR BURCH DR AD15 Bourbonnais 03/25/13 03:24 Incident #: 2013-00000581",
        "CALL:AMBULANCE",
        "ADDR:1325 N ARTHUR BURCH DR",
        "APT:AD15",
        "CITY:Bourbonnais",
        "ID:2013-00000581");

    doTest("T5",
        "(NWS Message) ACCIDENT Location: ST GEORGE CHURCH5272 E  5000N RD Bourbonnais 03/24/13 21:41 Incident #: 2013-00009763",
        "CALL:ACCIDENT",
        "PLACE:ST GEORGE CHURCH5272",
        "ADDR:E 5000N RD",
        "CITY:Bourbonnais",
        "ID:2013-00009763");

    doTest("T6",
        "(NWS Message) AMBULANCE Location: 2848 SPORTSMAN CLUB RD Bourbonnais 03/24/13 19:35 Incident #: 2013-00000579",
        "CALL:AMBULANCE",
        "ADDR:2848 SPORTSMAN CLUB RD",
        "CITY:Bourbonnais",
        "ID:2013-00000579");

    doTest("T7",
        "(NWS Message) 911:ABANDONED Location: 139 MEADOWS RD S SOUTH Bourbonnais 03/24/13 12:01 Incident #: 2013-00002369",
        "CALL:911:ABANDONED",
        "ADDR:139 MEADOWS RD S",
        "APT:SOUTH",
        "CITY:Bourbonnais",
        "ID:2013-00002369");

    doTest("T8",
        "(NWS Message) AMBULANCE Location: 1325 N  ARTHUR BURCH DR B9 Bourbonnais 03/24/13 04:42 Incident #: 2013-00000577",
        "CALL:AMBULANCE",
        "ADDR:1325 N ARTHUR BURCH DR",
        "APT:B9",
        "CITY:Bourbonnais",
        "ID:2013-00000577");

    doTest("T9",
        "(NWS Message) NEW Location: KANKAKEE TERRACE100 BELLE AIRE AVE Bourbonnais 03/24/13 01:31 Incident #: 2013-00000576",
        "CALL:NEW",
        "PLACE:KANKAKEE TERRACE100 BELLE",
        "ADDR:AIRE AVE",
        "CITY:Bourbonnais",
        "ID:2013-00000576");

    doTest("T10",
        "(NWS Message) AMBULANCE Location: 105 MEADOWS CT Bourbonnais 03/23/13 21:18 Incident #: 2013-00000575",
        "CALL:AMBULANCE",
        "ADDR:105 MEADOWS CT",
        "CITY:Bourbonnais",
        "ID:2013-00000575");

    doTest("T11",
        "(NWS Message) AMBULANCE Location: 386 BELLE AIRE AVE Bourbonnais 03/23/13 12:41 Incident #: 2013-00000574",
        "CALL:AMBULANCE",
        "ADDR:386 BELLE AIRE AVE",
        "CITY:Bourbonnais",
        "ID:2013-00000574");

    doTest("T12",
        "(NWS Message) CONTROL BURN Location: 2000 E  5000N RD Bourbonnais 03/23/13 10:22 Incident #:",
        "CALL:CONTROL BURN",
        "ADDR:2000 E 5000N RD",
        "CITY:Bourbonnais");

    doTest("T13",
        "(NWS Message) AMBULANCE Location: CLANCYS FUNERAL HOME295 MAIN ST NW Bourbonnais 03/23/13 10:39 Incident #: 2013-00000572",
        "CALL:AMBULANCE",
        "PLACE:CLANCYS FUNERAL HOME295",
        "ADDR:MAIN ST NW",
        "CITY:Bourbonnais",
        "ID:2013-00000572");

    doTest("T14",
        "(NWS Message) AMBULANCE Location: 270 N  STADIUM DR 8 Bourbonnais 03/23/13 09:37 Incident #: 2013-00000571",
        "CALL:AMBULANCE",
        "ADDR:270 N STADIUM DR",
        "APT:8",
        "CITY:Bourbonnais",
        "ID:2013-00000571");

    doTest("T15",
        "(NWS Message) AMBULANCE Location: 47 EMERY DR Bourbonnais 03/23/13 06:13 Incident #: 2013-00000570",
        "CALL:AMBULANCE",
        "ADDR:47 EMERY DR",
        "CITY:Bourbonnais",
        "ID:2013-00000570");

    doTest("T16",
        "(NWS Message) AMBULANCE Location: 1355 N  ARTHUR BURCH DR N1 Bourbonnais 03/23/13 00:45 Incident #: 2013-00000569",
        "CALL:AMBULANCE",
        "ADDR:1355 N ARTHUR BURCH DR",
        "APT:N1",
        "CITY:Bourbonnais",
        "ID:2013-00000569");

    doTest("T17",
        "(NWS Message) NEW Location: 282 E  BEAUDOIN AVE Bourbonnais 03/22/13 18:39 Incident #: 2013-00000568",
        "CALL:NEW",
        "ADDR:282 E BEAUDOIN AVE",
        "CITY:Bourbonnais",
        "ID:2013-00000568");

    doTest("T18",
        "(NWS Message) ALARM:CO DET Location: 341 MOHAWK DR D Bourbonnais 03/22/13 18:26 Incident #: 2013-00000567",
        "CALL:ALARM:CO DET",
        "ADDR:341 MOHAWK DR",
        "APT:D",
        "CITY:Bourbonnais",
        "ID:2013-00000567");

    doTest("T19",
        "(NWS Message) AMBULANCE Location: 349 PRINCETON AVE Bourbonnais 03/22/13 18:09 Incident #: 2013-00002314",
        "CALL:AMBULANCE",
        "ADDR:349 PRINCETON AVE",
        "CITY:Bourbonnais",
        "ID:2013-00002314");

    doTest("T20",
        "(NWS Message) AMBULANCE Location: 2293 W  3100N RD Bourbonnais 03/22/13 17:24 Incident #: 2013-00000565",
        "CALL:AMBULANCE",
        "ADDR:2293 W 3100N RD",
        "CITY:Bourbonnais",
        "ID:2013-00000565");

    doTest("T21",
        "(NWS Message) ALARM:FIRE Location: 585 WILLIAM LATHAM DR Bourbonnais 03/22/13 17:11 Incident #: 2013-00000564",
        "CALL:ALARM:FIRE",
        "ADDR:585 WILLIAM LATHAM DR",
        "CITY:Bourbonnais",
        "ID:2013-00000564");

    doTest("T22",
        "(NWS Message) AMBULANCE Location: FARM AND FLEET1811 N  STHY 50 Bourbonnais 03/22/13 15:19 Incident #: 2013-00000563",
        "CALL:AMBULANCE",
        "PLACE:FARM AND FLEET1811",
        "ADDR:N STHY 50",
        "MADDR:N ST 50",
        "CITY:Bourbonnais",
        "ID:2013-00000563");

    doTest("T23",
        "(NWS Message) NEW Location: 581 WILLIAM LATHAM M DR 03/22/13 14:40 Incident #: 2013-00000562",
        "CALL:NEW",
        "ADDR:581 WILLIAM LATHAM M DR",
        "ID:2013-00000562");

    doTest("T24",
        "(NWS Message) CONTROL BURN Location: ACME AUTO PARTS2016 E  1000N RD Kankakee 03/22/13 09:31 Incident #:",
        "CALL:CONTROL BURN",
        "PLACE:ACME AUTO PARTS2016",
        "ADDR:E 1000N RD",
        "CITY:Kankakee");

    doTest("T25",
        "(NWS Message) AMBULANCE Location: 1133 MEADOWS WALK DR Bourbonnais 03/22/13 01:04 Incident #: 2013-00000561",
        "CALL:AMBULANCE",
        "ADDR:1133 MEADOWS WALK DR",
        "CITY:Bourbonnais",
        "ID:2013-00000561");

    doTest("T26",
        "(NWS Message) AMBULANCE Location: 1 UNIVERSITY AVE Bourbonnais 03/22/13 00:13 Incident #: 2013-00000560",
        "CALL:AMBULANCE",
        "ADDR:1 UNIVERSITY AVE",
        "CITY:Bourbonnais",
        "ID:2013-00000560");
  
  }
  
  public static void main(String[] args) {
    new ILKankakeeCountyParserTest().generateTests("T1");
  }
}