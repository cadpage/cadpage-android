package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Lacombe County, AB, CA
Contact: support@active911.com
Sender: RedDeer911 <reddeer911@reddeer.ca>
https://www.active911.com/interface/parser_report.php?key=636-3GXrP

(Incident Message) Date: 2012-06-02 13:02:11\nType: GRASS - 2.3 Grass/ Brush/ Forest\nLocation: Unknown Location - Call Dispatch\nLatitude: 52.38667500\nLongitude: -113.81778000
(Incident Message) Date: 2012-06-02 13:02:11\nType: GRASS - 2.3 Grass/ Brush/ Forest\nLocation: 1 BLACKFALDS, TOWN OF, BLACKFALDS\nUnits Responding: BLKP4, BLKP2, BLKT1, BLKC
(Incident Message) Date: 2012-06-04 01:21:42\nType: ALARMS - 2.6 Alarms\nLocation: 7 GREYSTONE DR, BLACKFALDS RURAL\nUnits Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1
(Incident Message) Date: 2012-06-06 12:23:42\nType: ALARMS - 2.6 Alarms\nLocation: 6 WINSTON PL, BLACKFALDS\nLatitude: 52.38963050\nLongitude: -113.79837571\nUnits Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1

Lamont County, AB
Contact: Colin Candy <colincandy51@gmail.com>
Sender: scesitgroup@strathcona.ca
Sender: messaging@iamresponding.com
(CAD Message) Date: 2012-07-29 10:48:02\nType: 29D2k - Traffic Incidents\nLocation: TWP RD 550 /Rng rd 171, Lamont County\nUnits Respo
(Mundare Station) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Respondi
(CAD Message) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Responding: LCC1,
(CAD Message) Date: 2012-08-23 17:36:56\nType: 71 - Vehicle Fire\nLocation: 9999 NE 25 53 17 W4, Mundare Rural Area\nUnits Responding:
(CAD Message) Date: 2012-09-04 14:25:32\nType: 9E1 - Cardiac Arrest\nLocation: Unknown Location - Call Dispatch\nUnits Responding: LCC

Contact: Active911
Agency name: Bruderheim Fire Department
Location: Bruderheim, Alberta, Canada
Sender: messaging@iamresponding.com

(Bruderheim) Date: 2013-02-09 23:10:27\nType: 29B1 - Traffic Incidents\nLocation: Hwy 831 \Twp rd 582, Lamont County\nUnits: LCC1, A2034, A2125, AHS1, AHS2, AHS3, BdE22, BdE21, BdFA2, BdTA2\nLatitude: 54.00711\nLongitude: -112.77755
(Bruderheim) Date: 2013-02-09 21:32:27\nType: 29D2p - Traffic Incidents\nLocation: Hwy 15 \Rng rd 203, Lamont County\nUnits: LCC1, BdE22, BdE21, BdFA2, BdTA2, AHS1\nLatitude: 53.77425\nLongitude: -112.90146

Contact: Active911
Agency name: Leduc Fire Services
Location: Leduc, Alberta, Canada
Sender: "SCES 911 Centre" <scesitgroup@strathcona.ca>

(CAD Message) Date: 2013-03-20 14:57:49\nType: 29D2p - Traffic Incidents\nLocation: Hwy 2 \TWP RD 490, Leduc County\nUnits: LdP8, PTime, LdE2, LdTA4, LdRQ1, AHS1, LdC2\nLatitude: 53.18916\nLongitude: -113.59841
(CAD Message) Date: 2013-03-20 10:41:38\nType: 52C4G - Alarms\nLocation: 184 BRIDGEPORT BLVD, Leduc\nUnits: 1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2\nLatitude: 53.26874\nLongitude: -113.57259
(CAD Message) Date: 2013-03-20 10:07:21\nType: 29B1 - Traffic Incidents\nLocation: HWY 2 \HWY 2 S-HWY 2A EXIT, Leduc\nUnits: 3Alarm, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP\nLatitude: 53.25651\nLongitude: -113.56183
(CAD Message) Date: 2013-03-19 12:03:24\nType: 60B1O - Gas Leak\nLocation: 422 REED CR, Leduc\nUnits: 1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2, LdRQ1\nLatitude: 53.24285\nLongitude: -113.50865
(CAD Message) Date: 2013-03-18 16:05:21\nType: 52C3 - Alarms\nLocation: 6051 47 ST, Leduc\nUnits: FTime, AHS1, LdE1, LdC2, LdTO1, LdE2, LdRQ1\nLatitude: 53.27290\nLongitude: -113.54806
(CAD Message) Date: 2013-03-17 08:25:56\nType: 52 - Alarms\nLocation: Unit 205, 4415 48 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25897\nLongitude: -113.54587
(CAD Message) Date: 2013-03-15 19:48:32\nType: 56A1 - Elevator Rescue\nLocation: 5705 50 ST, Leduc\nUnits: LdRQ1, AHS1, LdE1, LdE2, LdTO1, LdC2\nLatitude: 53.27145\nLongitude: -113.55098
(CAD Message) Date: 2013-03-15 19:48:32\nType: 56 - Elevator Rescue\nLocation: 5705 50 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdTO1, LdC2\nLatitude: 53.27145\nLongitude: -113.55098
(CAD Message) Date: 2013-03-15 17:03:54\nType: 52B1S - Alarms\nLocation: 4412 46A AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.26168\nLongitude: -113.53871
(CAD Message) Date: 2013-03-15 16:03:14\nType: 52 - Alarms\nLocation: Unit 112, 3912 77 AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.29976\nLongitude: -113.53254
(CAD Message) Date: 2013-03-15 16:03:14\nType: 52 - Alarms\nLocation: Unit 112, 3912 77 AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.29976\nLongitude: -113.53254
(CAD Message) Date: 2013-03-14 19:44:48\nType: 52 - Alarms\nLocation: 4330 BLACK GOLD DR, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25712\nLongitude: -113.53013
(CAD Message) Date: 2013-03-11 20:20:59\nType: 60B2 - Gas Leak\nLocation: 3308 44 ST, Leduc\nUnits: LdC2, LdTO1, AHS1, LdE1, LdE2
(CAD Message) Date: 2013-03-11 20:20:59\nType: 60 - Gas Leak\nLocation: 3308 44 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2
(CAD Message) Date: 2013-03-09 13:53:30\nType: 52 - Alarms\nLocation: 5115 44 AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25946\nLongitude: -113.55610
(CAD Message) Date: 2013-03-09 13:53:30\nType: 52 - Alarms\nLocation: 5115 44 AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25946\nLongitude: -113.55610
(CAD Message) Date: 2013-03-08 09:04:22\nType: 52 - Alarms\nLocation: 6112 50 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.27623\nLongitude: -113.54901
(CAD Message) Date: 2013-03-08 09:04:22\nType: 52 - Alarms\nLocation: 6112 50 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.27623\nLongitude: -113.54901
(CAD Message) Date: 2013-03-06 15:11:54\nType: 61 - Hazmat\nLocation: TWP RD 492 \RNG RD 250, Leduc County\nUnits: PTime, LdE2, LdTA4, LdRQ1, LdC2\nLatitude: 53.22147\nLongitude: -113.51288
(CAD Message) Date: 2013-03-06 08:58:29\nType: 29 - Traffic Incident\nLocation: Twp rd 502 \Sparrow DR, Leduc County\nUnits: LdC2, LdE1, LdRQ1\nLatitude: 53.30879\nLongitude: -113.54045
(CAD Message) Date: 2013-03-06 06:45:37\nType: 29B3 - Traffic Incidents\nLocation: BLACK GOLD DR\46 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP\nLatitude: 53.25799\nLongitude: -113.54276
(CAD Message) Date: 2013-03-06 06:45:37\nType: 29 - Traffic Incident\nLocation: BLACK GOLD DR\46 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdRQ1\nLatitude: 53.25799\nLongitude: -113.54276
(CAD Message) Date: 2013-03-05 22:03:10\nType: 52 - Alarms\nLocation: 4503 45 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.26043\nLongitude: -113.54010
(CAD Message) Date: 2013-03-04 11:44:13\nType: 52 - Alarms\nLocation: 5210 50 AV, Leduc\nUnits: ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.26487\nLongitude: -113.55816
(CAD Message) Date: 2013-03-04 07:41:48\nType: 29D2p - Traffic Incidents\nLocation: Exit 522 QE2 to EIA\nUnits: ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP\nLatitude: 53.30882\nLongitude: -113.54901
(CAD Message) Date: 2013-03-04 07:41:48\nType: 29 - Traffic Incident\nLocation: Exit 522 QE2 to EIA\nUnits: ACall, AHS1, LdE1, LdRQ1\nLatitude: 53.30882\nLongitude: -113.54901
(CAD Message) Date: 2013-03-04 02:37:10\nType: 52 - Alarms\nLocation: 7020 45 ST, Leduc\nUnits: ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.29263\nLongitude: -113.53770
(CAD Message) Date: 2013-03-02 13:26:30\nType: 69 - Structure Fire\nLocation: 7603 39 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2\nLatitude: 53.29627\nLongitude: -113.52679
(CAD Message) Date: 2013-03-01 13:17:55\nType: FPI - \nLocation: 7603 39 ST, Leduc\nUnits: LdE1, LdE2\nLatitude: 53.29627\nLongitude: -113.52679
(CAD Message) Date: 2013-02-28 16:05:30\nType: 69D3 - Structure Fire\nLocation: 7603 39 ST, Leduc\nUnits: LdP8, LdE1, LdE2, LdTO1, LdRQ1, LdC2, LdE3, RCMP, LdS1\nLatitude: 53.29627\nLongitude: -113.52679
(CAD Message) Date: 2013-02-28 20:04:18\nType: 52 - Alarms\nLocation: 8230 SPARROW DR, Leduc\nUnits: LdP8, ACall, AHS1\nLatitude: 53.30457\nLongitude: -113.54245
(CAD Message) Date: 2013-02-28 20:04:18\nType: 52 - Alarms\nLocation: 8230 SPARROW DR, Leduc\nUnits: ACall, AHS1\nLatitude: 53.30457\nLongitude: -113.54245
(CAD Message) Date: 2013-02-28 16:05:30\nType: 69 - Structure Fire\nLocation: 7603 39 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2\nLatitude: 53.29627\nLongitude: -113.52679
(CAD Message) Date: 2013-02-28 08:42:56\nType: 52 - Alarms\nLocation: 1 CAMELOT AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25554\nLongitude: -113.55680
(CAD Message) Date: 2013-02-27 17:48:05\nType: 52 - Alarms\nLocation: 1118 ASPEN DR W, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25193\nLongitude: -113.59765
(CAD Message) Date: 2013-02-27 12:26:01\nType: 52 - Alarms\nLocation: 4209 43B AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25747\nLongitude: -113.53378
(CAD Message) Date: 2013-02-27 12:26:01\nType: 52 - Alarms\nLocation: 4209 43B AV, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25747\nLongitude: -113.53378
(CAD Message) Date: 2013-02-26 03:08:53\nType: 29D2p - Traffic Incidents\nLocation: Exit 517 QE2 Northbound to 50th Ave, Leduc (Hwy 39)\nUnits: ACall, AHS2, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP\nLatitude: 53.26305\nLongitude: -113.56223
(CAD Message) Date: 2013-02-25 18:31:52\nType: 29D2p - Traffic Incidents\nLocation: 49278 Hwy 2, Leduc County (Hwy 2 Weigh Station)\nUnits: PTime, LdE2, LdTA4, LdRQ1, LdP8, AHS1, LdC2\nLatitude: 53.22925\nLongitude: -113.57358
(CAD Message) Date: 2013-02-25 18:31:52\nType: 29 - Traffic Incident\nLocation: 49278 Hwy 2, Leduc County (Hwy 2 Weigh Station)\nUnits: PTime, LdE2, LdTA4, LdRQ1, LdC2\nLatitude: 53.22925\nLongitude: -113.57358
(CAD Message) Date: 2013-02-25 16:30:07\nType: 52B1S - Alarms\nLocation: 27 SUNTREE PR, Leduc\nUnits: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\nLatitude: 53.25578\nLongitude: -113.58918
(CAD Message) Date: 2013-02-25 16:30:07\nType: 52 - Alarms\nLocation: 27 SUNTREE PR, Leduc\nUnits: ACall\nLatitude: 53.25578\nLongitude: -113.58918

*/
public class ZCAABRedDeerCountyParserTest extends BaseParserTest {
  
  public ZCAABRedDeerCountyParserTest() {
    setParser(new ZCAABRedDeerCountyParser(), "RED DEER COUNTY", "AB");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Incident Message) Date: 2012-06-02 13:02:11\n" +
        "Type: GRASS - 2.3 Grass/ Brush/ Forest\n" +
        "Location: Unknown Location - Call Dispatch\n" +
        "Latitude: 52.38667500\n" +
        "Longitude: -113.81778000",

        "DATE:06/02/2012",
        "TIME:13:02:11",
        "CALL:GRASS - 2.3 Grass/ Brush/ Forest",
        "ADDR:+52.386675,-113.817780",
        "GPS:+52.386675,-113.817780");

    doTest("T2",
        "(Incident Message) Date: 2012-06-02 13:02:11\n" +
        "Type: GRASS - 2.3 Grass/ Brush/ Forest\n" +
        "Location: 1 BLACKFALDS, TOWN OF, BLACKFALDS\n" +
        "Units Responding: BLKP4, BLKP2, BLKT1, BLKC",

        "DATE:06/02/2012",
        "TIME:13:02:11",
        "CALL:GRASS - 2.3 Grass/ Brush/ Forest",
        "ADDR:1 BLACKFALDS",
        "CITY:BLACKFALDS",
        "UNIT:BLKP4, BLKP2, BLKT1, BLKC");

    doTest("T3",
        "(Incident Message) Date: 2012-06-04 01:21:42\n" +
        "Type: ALARMS - 2.6 Alarms\n" +
        "Location: 7 GREYSTONE DR, BLACKFALDS RURAL\n" +
        "Units Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1",

        "DATE:06/04/2012",
        "TIME:01:21:42",
        "CALL:ALARMS - 2.6 Alarms",
        "ADDR:7 GREYSTONE DR",
        "CITY:BLACKFALDS RURAL",
        "UNIT:BLKP1, BLKP2, BLKR3, BLKC, BLKT1");

    doTest("T4",
        "(Incident Message) Date: 2012-06-06 12:23:42\n" +
        "Type: ALARMS - 2.6 Alarms\n" +
        "Location: 6 WINSTON PL, BLACKFALDS\n" +
        "Latitude: 52.38963050\n" +
        "Longitude: -113.79837571\n" +
        "Units Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1",

        "DATE:06/06/2012",
        "TIME:00:23:42",
        "CALL:ALARMS - 2.6 Alarms",
        "ADDR:6 WINSTON PL",
        "CITY:BLACKFALDS",
        "GPS:+52.389631,-113.798376",
        "UNIT:BLKP1, BLKP2, BLKR3, BLKC, BLKT1");

  }
  
  @Test
  public void testLamontCounty() {

    doTest("T1",
        "(CAD Message) Date: 2012-07-29 10:48:02\n" +
        "Type: 29D2k - Traffic Incidents\n" +
        "Location: TWP RD 550 /Rng rd 171, Lamont County\n" +
        "Units Respo",

        "DATE:07/29/2012",
        "TIME:10:48:02",
        "CALL:29D2k - Traffic Incidents",
        "ADDR:TWP RD 550 & Rng rd 171",
        "MADDR:TWP RD 550 & Range rd 171",
        "CITY:Lamont County");

    doTest("T2",
        "(Mundare Station) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Respondi",
        "DATE:08/14/2012",
        "TIME:06:55:06",
        "CALL:29 - Traffic Incidents",
        "ADDR:171016 Hwy 16",
        "MADDR:171016 RT 16",
        "CITY:Lamont County");

    doTest("T3",
        "(CAD Message) Date: 2012-08-14 06:55:06\n" +
        "Type: 29 - Traffic Incidents\n" +
        "Location: 171016 Hwy 16, Lamont County\n" +
        "Units Responding: LCC1,",

        "DATE:08/14/2012",
        "TIME:06:55:06",
        "CALL:29 - Traffic Incidents",
        "ADDR:171016 Hwy 16",
        "MADDR:171016 RT 16",    // Can't find address
        "CITY:Lamont County",
        "UNIT:LCC1,");

    doTest("T4",
        "(CAD Message) Date: 2012-08-23 17:36:56\n" +
        "Type: 71 - Vehicle Fire\n" +
        "Location: 9999 NE 25 53 17 W4, Mundare Rural Area\n" +
        "Units Responding:",

        "DATE:08/23/2012",
        "TIME:17:36:56",
        "CALL:71 - Vehicle Fire",
        "ADDR:9999 NE 25 53 17 W4", // What is this??
        "CITY:Mundare Rural Area");

    doTest("T5",
        "(CAD Message) Date: 2012-09-04 14:25:32\n" +
        "Type: 9E1 - Cardiac Arrest\n" +
        "Location: Unknown Location - Call Dispatch\n" +
        "Units Responding: LCC",

        "DATE:09/04/2012",
        "TIME:14:25:32",
        "CALL:9E1 - Cardiac Arrest",
        "ADDR:Unknown Location - Call Dispatch",
        "UNIT:LCC");

  }
  
  @Test
  public void testBruderheimFire() {

    doTest("T1",
        "(Bruderheim) Date: 2013-02-09 23:10:27\n" +
        "Type: 29B1 - Traffic Incidents\n" +
        "Location: Hwy 831 \\Twp rd 582, Lamont County\n" +
        "Units: LCC1, A2034, A2125, AHS1, AHS2, AHS3, BdE22, BdE21, BdFA2, BdTA2\n" +
        "Latitude: 54.00711\n" +
        "Longitude: -112.77755",

        "DATE:02/09/2013",
        "TIME:23:10:27",
        "CALL:29B1 - Traffic Incidents",
        "ADDR:Hwy 831 & Twp rd 582",
        "MADDR:RT 831 & Twp rd 582",
        "CITY:Lamont County",
        "UNIT:LCC1, A2034, A2125, AHS1, AHS2, AHS3, BdE22, BdE21, BdFA2, BdTA2",
        "GPS:+54.007110,-112.777550");

    doTest("T2",
        "(Bruderheim) Date: 2013-02-09 21:32:27\n" +
        "Type: 29D2p - Traffic Incidents\n" +
        "Location: Hwy 15 \\Rng rd 203, Lamont County\n" +
        "Units: LCC1, BdE22, BdE21, BdFA2, BdTA2, AHS1\n" +
        "Latitude: 53.77425\n" +
        "Longitude: -112.90146",

        "DATE:02/09/2013",
        "TIME:21:32:27",
        "CALL:29D2p - Traffic Incidents",
        "ADDR:Hwy 15 & Rng rd 203",
        "MADDR:RT 15 & Range rd 203",
        "CITY:Lamont County",
        "UNIT:LCC1, BdE22, BdE21, BdFA2, BdTA2, AHS1",
        "GPS:+53.774250,-112.901460");
  
  }
  
  @Test
  public void testLeducFireService() {

    doTest("T1",
        "(CAD Message) Date: 2013-03-20 14:57:49\n" +
        "Type: 29D2p - Traffic Incidents\n" +
        "Location: Hwy 2 \\TWP RD 490, Leduc County\n" +
        "Units: LdP8, PTime, LdE2, LdTA4, LdRQ1, AHS1, LdC2\n" +
        "Latitude: 53.18916\n" +
        "Longitude: -113.59841",

        "DATE:03/20/2013",
        "TIME:14:57:49",
        "CALL:29D2p - Traffic Incidents",
        "ADDR:Hwy 2 & TWP RD 490",
        "MADDR:RT 2 & TWP RD 490",
        "CITY:Leduc County",
        "UNIT:LdP8, PTime, LdE2, LdTA4, LdRQ1, AHS1, LdC2",
        "GPS:+53.189160,-113.598410");

    doTest("T2",
        "(CAD Message) Date: 2013-03-20 10:41:38\n" +
        "Type: 52C4G - Alarms\n" +
        "Location: 184 BRIDGEPORT BLVD, Leduc\n" +
        "Units: 1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2\n" +
        "Latitude: 53.26874\n" +
        "Longitude: -113.57259",

        "DATE:03/20/2013",
        "TIME:10:41:38",
        "CALL:52C4G - Alarms",
        "ADDR:184 BRIDGEPORT BLVD",
        "CITY:Leduc",
        "UNIT:1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2",
        "GPS:+53.268740,-113.572590");

    doTest("T3",
        "(CAD Message) Date: 2013-03-20 10:07:21\n" +
        "Type: 29B1 - Traffic Incidents\n" +
        "Location: HWY 2 \\HWY 2 S-HWY 2A EXIT, Leduc\n" +
        "Units: 3Alarm, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP\n" +
        "Latitude: 53.25651\n" +
        "Longitude: -113.56183",

        "DATE:03/20/2013",
        "TIME:10:07:21",
        "CALL:29B1 - Traffic Incidents",
        "ADDR:HWY 2 & HWY 2 S-HWY 2A EXIT",
        "MADDR:RT 2 & RT 2 S-RT 2A EXIT",
        "CITY:Leduc",
        "UNIT:3Alarm, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP",
        "GPS:+53.256510,-113.561830");

    doTest("T4",
        "(CAD Message) Date: 2013-03-19 12:03:24\n" +
        "Type: 60B1O - Gas Leak\n" +
        "Location: 422 REED CR, Leduc\n" +
        "Units: 1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2, LdRQ1\n" +
        "Latitude: 53.24285\n" +
        "Longitude: -113.50865",

        "DATE:03/19/2013",
        "TIME:00:03:24",
        "CALL:60B1O - Gas Leak",
        "ADDR:422 REED CR",
        "MADDR:422 REED CRES",
        "CITY:Leduc",
        "UNIT:1Alarm, LdE1, 2Alarm, LdC2, LdTO1, LdE2, LdRQ1",
        "GPS:+53.242850,-113.508650");

    doTest("T5",
        "(CAD Message) Date: 2013-03-18 16:05:21\n" +
        "Type: 52C3 - Alarms\n" +
        "Location: 6051 47 ST, Leduc\n" +
        "Units: FTime, AHS1, LdE1, LdC2, LdTO1, LdE2, LdRQ1\n" +
        "Latitude: 53.27290\n" +
        "Longitude: -113.54806",

        "DATE:03/18/2013",
        "TIME:16:05:21",
        "CALL:52C3 - Alarms",
        "ADDR:6051 47 ST",
        "CITY:Leduc",
        "UNIT:FTime, AHS1, LdE1, LdC2, LdTO1, LdE2, LdRQ1",
        "GPS:+53.272900,-113.548060");

    doTest("T6",
        "(CAD Message) Date: 2013-03-17 08:25:56\n" +
        "Type: 52 - Alarms\n" +
        "Location: Unit 205, 4415 48 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25897\n" +
        "Longitude: -113.54587",

        "DATE:03/17/2013",
        "TIME:08:25:56",
        "CALL:52 - Alarms",
        "APT:205",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.258970,-113.545870",
        "MADDR:+53.258970,-113.545870");

    doTest("T7",
        "(CAD Message) Date: 2013-03-15 19:48:32\n" +
        "Type: 56A1 - Elevator Rescue\n" +
        "Location: 5705 50 ST, Leduc\n" +
        "Units: LdRQ1, AHS1, LdE1, LdE2, LdTO1, LdC2\n" +
        "Latitude: 53.27145\n" +
        "Longitude: -113.55098",

        "DATE:03/15/2013",
        "TIME:19:48:32",
        "CALL:56A1 - Elevator Rescue",
        "ADDR:5705 50 ST",
        "CITY:Leduc",
        "UNIT:LdRQ1, AHS1, LdE1, LdE2, LdTO1, LdC2",
        "GPS:+53.271450,-113.550980");

    doTest("T8",
        "(CAD Message) Date: 2013-03-15 19:48:32\n" +
        "Type: 56 - Elevator Rescue\n" +
        "Location: 5705 50 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdTO1, LdC2\n" +
        "Latitude: 53.27145\n" +
        "Longitude: -113.55098",

        "DATE:03/15/2013",
        "TIME:19:48:32",
        "CALL:56 - Elevator Rescue",
        "ADDR:5705 50 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdTO1, LdC2",
        "GPS:+53.271450,-113.550980");

    doTest("T9",
        "(CAD Message) Date: 2013-03-15 17:03:54\n" +
        "Type: 52B1S - Alarms\n" +
        "Location: 4412 46A AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.26168\n" +
        "Longitude: -113.53871",

        "DATE:03/15/2013",
        "TIME:17:03:54",
        "CALL:52B1S - Alarms",
        "ADDR:4412 46A AV",
        "MADDR:4412 46A AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.261680,-113.538710");

    doTest("T10",
        "(CAD Message) Date: 2013-03-15 16:03:14\n" +
        "Type: 52 - Alarms\n" +
        "Location: Unit 112, 3912 77 AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.29976\n" +
        "Longitude: -113.53254",

        "DATE:03/15/2013",
        "TIME:16:03:14",
        "CALL:52 - Alarms",
        "APT:112",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.299760,-113.532540",
        "MADDR:+53.299760,-113.532540");

    doTest("T11",
        "(CAD Message) Date: 2013-03-15 16:03:14\n" +
        "Type: 52 - Alarms\n" +
        "Location: Unit 112, 3912 77 AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.29976\n" +
        "Longitude: -113.53254",

        "DATE:03/15/2013",
        "TIME:16:03:14",
        "CALL:52 - Alarms",
        "APT:112",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.299760,-113.532540",
        "MADDR:+53.299760,-113.532540");

    doTest("T12",
        "(CAD Message) Date: 2013-03-14 19:44:48\n" +
        "Type: 52 - Alarms\n" +
        "Location: 4330 BLACK GOLD DR, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25712\n" +
        "Longitude: -113.53013",

        "DATE:03/14/2013",
        "TIME:19:44:48",
        "CALL:52 - Alarms",
        "ADDR:4330 BLACK GOLD DR",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.257120,-113.530130");

    doTest("T13",
        "(CAD Message) Date: 2013-03-11 20:20:59\nType: 60B2 - Gas Leak\nLocation: 3308 44 ST, Leduc\nUnits: LdC2, LdTO1, AHS1, LdE1, LdE2",
        "DATE:03/11/2013",
        "TIME:20:20:59",
        "CALL:60B2 - Gas Leak",
        "ADDR:3308 44 ST",
        "CITY:Leduc",
        "UNIT:LdC2, LdTO1, AHS1, LdE1, LdE2");

    doTest("T14",
        "(CAD Message) Date: 2013-03-11 20:20:59\nType: 60 - Gas Leak\nLocation: 3308 44 ST, Leduc\nUnits: ACall, AHS1, LdE1, LdE2",
        "DATE:03/11/2013",
        "TIME:20:20:59",
        "CALL:60 - Gas Leak",
        "ADDR:3308 44 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2");

    doTest("T15",
        "(CAD Message) Date: 2013-03-09 13:53:30\n" +
        "Type: 52 - Alarms\n" +
        "Location: 5115 44 AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25946\n" +
        "Longitude: -113.55610",

        "DATE:03/09/2013",
        "TIME:13:53:30",
        "CALL:52 - Alarms",
        "ADDR:5115 44 AV",
        "MADDR:5115 44 AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.259460,-113.556100");

    doTest("T16",
        "(CAD Message) Date: 2013-03-09 13:53:30\n" +
        "Type: 52 - Alarms\n" +
        "Location: 5115 44 AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25946\n" +
        "Longitude: -113.55610",

        "DATE:03/09/2013",
        "TIME:13:53:30",
        "CALL:52 - Alarms",
        "ADDR:5115 44 AV",
        "MADDR:5115 44 AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.259460,-113.556100");

    doTest("T17",
        "(CAD Message) Date: 2013-03-08 09:04:22\n" +
        "Type: 52 - Alarms\n" +
        "Location: 6112 50 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.27623\n" +
        "Longitude: -113.54901",

        "DATE:03/08/2013",
        "TIME:09:04:22",
        "CALL:52 - Alarms",
        "ADDR:6112 50 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.276230,-113.549010");

    doTest("T18",
        "(CAD Message) Date: 2013-03-08 09:04:22\n" +
        "Type: 52 - Alarms\n" +
        "Location: 6112 50 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.27623\n" +
        "Longitude: -113.54901",

        "DATE:03/08/2013",
        "TIME:09:04:22",
        "CALL:52 - Alarms",
        "ADDR:6112 50 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.276230,-113.549010");

    doTest("T19",
        "(CAD Message) Date: 2013-03-06 15:11:54\n" +
        "Type: 61 - Hazmat\n" +
        "Location: TWP RD 492 \\RNG RD 250, Leduc County\n" +
        "Units: PTime, LdE2, LdTA4, LdRQ1, LdC2\n" +
        "Latitude: 53.22147\n" +
        "Longitude: -113.51288",

        "DATE:03/06/2013",
        "TIME:15:11:54",
        "CALL:61 - Hazmat",
        "ADDR:TWP RD 492 & RNG RD 250",
        "MADDR:TWP RD 492 & Range RD 250",
        "CITY:Leduc County",
        "UNIT:PTime, LdE2, LdTA4, LdRQ1, LdC2",
        "GPS:+53.221470,-113.512880");

    doTest("T20",
        "(CAD Message) Date: 2013-03-06 08:58:29\n" +
        "Type: 29 - Traffic Incident\n" +
        "Location: Twp rd 502 \\Sparrow DR, Leduc County\n" +
        "Units: LdC2, LdE1, LdRQ1\n" +
        "Latitude: 53.30879\n" +
        "Longitude: -113.54045",

        "DATE:03/06/2013",
        "TIME:08:58:29",
        "CALL:29 - Traffic Incident",
        "ADDR:Twp rd 502 & Sparrow DR",
        "CITY:Leduc County",
        "UNIT:LdC2, LdE1, LdRQ1",
        "GPS:+53.308790,-113.540450");

    doTest("T21",
        "(CAD Message) Date: 2013-03-06 06:45:37\n" +
        "Type: 29B3 - Traffic Incidents\n" +
        "Location: BLACK GOLD DR\\46 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP\n" +
        "Latitude: 53.25799\n" +
        "Longitude: -113.54276",

        "DATE:03/06/2013",
        "TIME:06:45:37",
        "CALL:29B3 - Traffic Incidents",
        "ADDR:BLACK GOLD DR & 46 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP",
        "GPS:+53.257990,-113.542760");

    doTest("T22",
        "(CAD Message) Date: 2013-03-06 06:45:37\n" +
        "Type: 29 - Traffic Incident\n" +
        "Location: BLACK GOLD DR\\46 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdRQ1\n" +
        "Latitude: 53.25799\n" +
        "Longitude: -113.54276",

        "DATE:03/06/2013",
        "TIME:06:45:37",
        "CALL:29 - Traffic Incident",
        "ADDR:BLACK GOLD DR & 46 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdRQ1",
        "GPS:+53.257990,-113.542760");

    doTest("T23",
        "(CAD Message) Date: 2013-03-05 22:03:10\n" +
        "Type: 52 - Alarms\n" +
        "Location: 4503 45 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.26043\n" +
        "Longitude: -113.54010",

        "DATE:03/05/2013",
        "TIME:22:03:10",
        "CALL:52 - Alarms",
        "ADDR:4503 45 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.260430,-113.540100");

    doTest("T24",
        "(CAD Message) Date: 2013-03-04 11:44:13\n" +
        "Type: 52 - Alarms\n" +
        "Location: 5210 50 AV, Leduc\n" +
        "Units: ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.26487\n" +
        "Longitude: -113.55816",

        "DATE:03/04/2013",
        "TIME:11:44:13",
        "CALL:52 - Alarms",
        "ADDR:5210 50 AV",
        "MADDR:5210 50 AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.264870,-113.558160");

    doTest("T25",
        "(CAD Message) Date: 2013-03-04 07:41:48\n" +
        "Type: 29D2p - Traffic Incidents\n" +
        "Location: Exit 522 QE2 to EIA\n" +
        "Units: ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP\n" +
        "Latitude: 53.30882\n" +
        "Longitude: -113.54901",

        "DATE:03/04/2013",
        "TIME:07:41:48",
        "CALL:29D2p - Traffic Incidents",
        "ADDR:Exit 522 QE2 to EIA",
        "UNIT:ACall, AHS1, LdE1, LdRQ1, LdE2, LdTO1, LdC2, RCMP",
        "GPS:+53.308820,-113.549010");

    doTest("T26",
        "(CAD Message) Date: 2013-03-04 07:41:48\n" +
        "Type: 29 - Traffic Incident\n" +
        "Location: Exit 522 QE2 to EIA\n" +
        "Units: ACall, AHS1, LdE1, LdRQ1\n" +
        "Latitude: 53.30882\n" +
        "Longitude: -113.54901",

        "DATE:03/04/2013",
        "TIME:07:41:48",
        "CALL:29 - Traffic Incident",
        "ADDR:Exit 522 QE2 to EIA",
        "UNIT:ACall, AHS1, LdE1, LdRQ1",
        "GPS:+53.308820,-113.549010");

    doTest("T27",
        "(CAD Message) Date: 2013-03-04 02:37:10\n" +
        "Type: 52 - Alarms\n" +
        "Location: 7020 45 ST, Leduc\n" +
        "Units: ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.29263\n" +
        "Longitude: -113.53770",

        "DATE:03/04/2013",
        "TIME:02:37:10",
        "CALL:52 - Alarms",
        "ADDR:7020 45 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS2, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.292630,-113.537700");

    doTest("T28",
        "(CAD Message) Date: 2013-03-02 13:26:30\n" +
        "Type: 69 - Structure Fire\n" +
        "Location: 7603 39 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2\n" +
        "Latitude: 53.29627\n" +
        "Longitude: -113.52679",

        "DATE:03/02/2013",
        "TIME:13:26:30",
        "CALL:69 - Structure Fire",
        "ADDR:7603 39 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2",
        "GPS:+53.296270,-113.526790");

    doTest("T29",
        "(CAD Message) Date: 2013-03-01 13:17:55\n" +
        "Type: FPI - \n" +
        "Location: 7603 39 ST, Leduc\n" +
        "Units: LdE1, LdE2\n" +
        "Latitude: 53.29627\n" +
        "Longitude: -113.52679",

        "DATE:03/01/2013",
        "TIME:13:17:55",
        "CALL:FPI -",
        "ADDR:7603 39 ST",
        "CITY:Leduc",
        "UNIT:LdE1, LdE2",
        "GPS:+53.296270,-113.526790");

    doTest("T30",
        "(CAD Message) Date: 2013-02-28 16:05:30\n" +
        "Type: 69D3 - Structure Fire\n" +
        "Location: 7603 39 ST, Leduc\n" +
        "Units: LdP8, LdE1, LdE2, LdTO1, LdRQ1, LdC2, LdE3, RCMP, LdS1\n" +
        "Latitude: 53.29627\n" +
        "Longitude: -113.52679",

        "DATE:02/28/2013",
        "TIME:16:05:30",
        "CALL:69D3 - Structure Fire",
        "ADDR:7603 39 ST",
        "CITY:Leduc",
        "UNIT:LdP8, LdE1, LdE2, LdTO1, LdRQ1, LdC2, LdE3, RCMP, LdS1",
        "GPS:+53.296270,-113.526790");

    doTest("T31",
        "(CAD Message) Date: 2013-02-28 20:04:18\n" +
        "Type: 52 - Alarms\n" +
        "Location: 8230 SPARROW DR, Leduc\n" +
        "Units: LdP8, ACall, AHS1\n" +
        "Latitude: 53.30457\n" +
        "Longitude: -113.54245",

        "DATE:02/28/2013",
        "TIME:20:04:18",
        "CALL:52 - Alarms",
        "ADDR:8230 SPARROW DR",
        "CITY:Leduc",
        "UNIT:LdP8, ACall, AHS1",
        "GPS:+53.304570,-113.542450");

    doTest("T32",
        "(CAD Message) Date: 2013-02-28 20:04:18\n" +
        "Type: 52 - Alarms\n" +
        "Location: 8230 SPARROW DR, Leduc\n" +
        "Units: ACall, AHS1\n" +
        "Latitude: 53.30457\n" +
        "Longitude: -113.54245",

        "DATE:02/28/2013",
        "TIME:20:04:18",
        "CALL:52 - Alarms",
        "ADDR:8230 SPARROW DR",
        "CITY:Leduc",
        "UNIT:ACall, AHS1",
        "GPS:+53.304570,-113.542450");

    doTest("T33",
        "(CAD Message) Date: 2013-02-28 16:05:30\n" +
        "Type: 69 - Structure Fire\n" +
        "Location: 7603 39 ST, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2\n" +
        "Latitude: 53.29627\n" +
        "Longitude: -113.52679",

        "DATE:02/28/2013",
        "TIME:16:05:30",
        "CALL:69 - Structure Fire",
        "ADDR:7603 39 ST",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdTO1, LdRQ1, LdC2",
        "GPS:+53.296270,-113.526790");

    doTest("T34",
        "(CAD Message) Date: 2013-02-28 08:42:56\n" +
        "Type: 52 - Alarms\n" +
        "Location: 1 CAMELOT AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25554\n" +
        "Longitude: -113.55680",

        "DATE:02/28/2013",
        "TIME:08:42:56",
        "CALL:52 - Alarms",
        "ADDR:1 CAMELOT AV",
        "MADDR:1 CAMELOT AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.255540,-113.556800");

    doTest("T35",
        "(CAD Message) Date: 2013-02-27 17:48:05\n" +
        "Type: 52 - Alarms\n" +
        "Location: 1118 ASPEN DR W, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25193\n" +
        "Longitude: -113.59765",

        "DATE:02/27/2013",
        "TIME:17:48:05",
        "CALL:52 - Alarms",
        "ADDR:1118 ASPEN DR W",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.251930,-113.597650");

    doTest("T36",
        "(CAD Message) Date: 2013-02-27 12:26:01\n" +
        "Type: 52 - Alarms\n" +
        "Location: 4209 43B AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25747\n" +
        "Longitude: -113.53378",

        "DATE:02/27/2013",
        "TIME:00:26:01",
        "CALL:52 - Alarms",
        "ADDR:4209 43B AV",
        "MADDR:4209 43B AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.257470,-113.533780");

    doTest("T37",
        "(CAD Message) Date: 2013-02-27 12:26:01\n" +
        "Type: 52 - Alarms\n" +
        "Location: 4209 43B AV, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25747\n" +
        "Longitude: -113.53378",

        "DATE:02/27/2013",
        "TIME:00:26:01",
        "CALL:52 - Alarms",
        "ADDR:4209 43B AV",
        "MADDR:4209 43B AVE",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.257470,-113.533780");

    doTest("T38",
        "(CAD Message) Date: 2013-02-26 03:08:53\n" +
        "Type: 29D2p - Traffic Incidents\n" +
        "Location: Exit 517 QE2 Northbound to 50th Ave, Leduc (Hwy 39)\n" +
        "Units: ACall, AHS2, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP\n" +
        "Latitude: 53.26305\n" +
        "Longitude: -113.56223",

        "DATE:02/26/2013",
        "TIME:03:08:53",
        "CALL:29D2p - Traffic Incidents",
        "ADDR:Exit 517 QE2 Northbound to 50th Ave",
        "CITY:Leduc (Hwy 39)",
        "UNIT:ACall, AHS2, LdE1, LdE2, LdTO1, LdRQ1, LdC2, RCMP",
        "GPS:+53.263050,-113.562230");

    doTest("T39",
        "(CAD Message) Date: 2013-02-25 18:31:52\n" +
        "Type: 29D2p - Traffic Incidents\n" +
        "Location: 49278 Hwy 2, Leduc County (Hwy 2 Weigh Station)\n" +
        "Units: PTime, LdE2, LdTA4, LdRQ1, LdP8, AHS1, LdC2\n" +
        "Latitude: 53.22925\n" +
        "Longitude: -113.57358",

        "DATE:02/25/2013",
        "TIME:18:31:52",
        "CALL:29D2p - Traffic Incidents",
        "ADDR:49278 Hwy 2",
        "MADDR:49278 RT 2",
        "CITY:Leduc County (Hwy 2 Weigh Station)",
        "UNIT:PTime, LdE2, LdTA4, LdRQ1, LdP8, AHS1, LdC2",
        "GPS:+53.229250,-113.573580");

    doTest("T40",
        "(CAD Message) Date: 2013-02-25 18:31:52\n" +
        "Type: 29 - Traffic Incident\n" +
        "Location: 49278 Hwy 2, Leduc County (Hwy 2 Weigh Station)\n" +
        "Units: PTime, LdE2, LdTA4, LdRQ1, LdC2\n" +
        "Latitude: 53.22925\n" +
        "Longitude: -113.57358",

        "DATE:02/25/2013",
        "TIME:18:31:52",
        "CALL:29 - Traffic Incident",
        "ADDR:49278 Hwy 2",
        "MADDR:49278 RT 2",
        "CITY:Leduc County (Hwy 2 Weigh Station)",
        "UNIT:PTime, LdE2, LdTA4, LdRQ1, LdC2",
        "GPS:+53.229250,-113.573580");

    doTest("T41",
        "(CAD Message) Date: 2013-02-25 16:30:07\n" +
        "Type: 52B1S - Alarms\n" +
        "Location: 27 SUNTREE PR, Leduc\n" +
        "Units: ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1\n" +
        "Latitude: 53.25578\n" +
        "Longitude: -113.58918",

        "DATE:02/25/2013",
        "TIME:16:30:07",
        "CALL:52B1S - Alarms",
        "ADDR:27 SUNTREE PR",
        "CITY:Leduc",
        "UNIT:ACall, AHS1, LdE1, LdE2, LdRQ1, LdTO1",
        "GPS:+53.255780,-113.589180");

    doTest("T42",
        "(CAD Message) Date: 2013-02-25 16:30:07\n" +
        "Type: 52 - Alarms\n" +
        "Location: 27 SUNTREE PR, Leduc\n" +
        "Units: ACall\n" +
        "Latitude: 53.25578\n" +
        "Longitude: -113.58918",

        "DATE:02/25/2013",
        "TIME:16:30:07",
        "CALL:52 - Alarms",
        "ADDR:27 SUNTREE PR",
        "CITY:Leduc",
        "UNIT:ACall",
        "GPS:+53.255780,-113.589180");

  }
  
  public static void main(String[] args) {
    new ZCAABRedDeerCountyParserTest().generateTests("T1");
  }
}