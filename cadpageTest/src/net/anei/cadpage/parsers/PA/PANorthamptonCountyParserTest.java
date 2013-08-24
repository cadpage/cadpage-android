package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PANorthamptonCountyParser;

import org.junit.Test;

/*
Northampton County, PA
Contact: Matt Winter <mattgwinter@gmail.com>
Sender: @notifync.org

[e49]ALS >ADVANCED LIFE SUPPORT CALL 602 E 21ST ST Apt: 119 Bldg NORTHAMPTON DIANE ECK Map: Grids:0,0 Cad: 2011-0000086714
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE Apt: REAR Bldg NORTHAMPTON TONY FERRERA Map: Grids:0,0 Cad: 2011-00000
[e49]MVAI >MVA WITH INJURIES 248 AT PENNSVILLE LIGHT LEHIGH TWP NATALIE BRODIANO Cad: 2011-0000086361
[e49]ALS >ADVANCED LIFE SUPPORT CALL 612 E 10TH ST NORTHAMPTON ROBERTS PAMELA Map: Grids:0,0 Cad: 2011-0000086262
[e49]BLS >BASIC LIFE SUPPORT CALL 1001 WASHINGTON AVE Apt: 105 Bldg NORTHAMPTON MEGAN MOREY Map: Grids:0,0 Cad: 2011-000008
[e49]ALS >ADVANCED LIFE SUPPORT CALL 5962 KEYSTONE DR EAST ALLEN CHRISTINA WIGMER Map: Grids:0,0 Cad: 2011-0000086103
[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE NORTHAMPTON TONY CABRERA Map: Grids:0,0 Cad: 2011-0000086010

Contact: "richierrs@aol.com" <richierrs@aol.com>
Sender: alert@notifync.org
Subject:#6550\n[f14]MVAU >MVA WITH UNKNOW INJUIRIES WILLOW PARK RD BETHLEHEM TWP P1736 Map: Grids:0,0 Cad: 2011-0000131105

Contact: Edmund Lamontagne <edmundl79@gmail.com>
*3750: *alert_6JP4@notifync.org /  / [f25]ODOR >ODOR / OTHER THAN SMOKE ARNDT RD FORKS Map: Grids:0,0 Cad: 2011-0000171220 <20110000171220>

Contact: david burgin <daveburgin2001@gmail.com>
Sender: _AOSQ@notifync.org
[f35]RES >RESCUE (TYPE) 951 S BROADWAY WIND GAP FEMALE CALLER Map: Grids:0,0 Cad: 2013-0000027694

Contact: Me <softail2@ptd.net>
Sender: alrt_AT3A@notifync.org
[f26]FIRE >FIRE GENERIC (TYPE) 4911 CEDAR GROVE PARK LOWER MT BETHEL WESCOE SHARON Map: Grids:0,0 Cad: 2013-0000037135

Contact: support@active911.com
[#8ICT  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 6303 HANOVERVILLE RD EAST ALLEN SARA HILBERT Map: Grids:0,0 Cad: 2012-0000098761\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397037&c=f5d0d for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IJN  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5516 LOIS LN EAST ALLEN HOSER, CHRISTINE Map: Grids:0,0 Cad: 2012-0000099349\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397283&c=8e4b8 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IKZ  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 251 S GREENBRIAR DR EAST ALLEN HORTON, ROBERT Map: Grids:0,0 Cad: 2012-0000099450\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397331&c=4e113 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IMN  Northampton County PA CAD] [e46]MVA >MVA NONE INJURY AIRPORT RD EAST ALLEN 4676 Map: Grids:0,0 Cad: 2012-0000099584\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397391&c=b9536 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8IXF  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 478 BLUE MOUNTAIN DR LEHIGH KARMONICK, TERRY Map: Grids:0,0 Cad: 2012-0000100411\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397779&c=77340 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J0R  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5701 COLONY DR EAST ALLEN MARY JOE DEEGAN Map: Grids:0,0 Cad: 2012-0000100593\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397899&c=90443 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J2X  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 5745 COLONY DR EAST ALLEN WENGRYN HELEN Map: Grids:0,0 Cad: 2012-0000100697\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=397977&c=2f09b for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n
[#8J6H  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5897 LEHIGH LN EAST ALLEN WALTON, CECELIA Map: Grids:0,0 Cad: 2012-0000100946\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\nVisit https://www.notifync.org/am.php?a=398105&c=61154 for the map of the area\n--\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n

Contact: Henry Hennings <myofb23@gmail.com>
[f20]FIRED >DWELLING FIRE 912-14 CENTRE ST EASTON MALE CALLER Map: Grids:0,0 Cad: 2012-0000136112
 
Contact: Active911
Agency name: Pen Argyl Fire
Location: Pen Argyl, PA, United States
Sender: "NCEMS CAD" <Alert@notifync.org>

(#ABBE  Northampton County PA CAD) [f32]FIRED >DWELLING FIRE 1573 DELABOLE RD PLAINFIELD RILEY,DENNIS Map: Grids:0,0 Cad: 2013-0000001381\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=481226&c=58158 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#AACA  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 201 W MAIN ST PEN ARGYL DORIS GILBERT Map: Grids:0,0 Cad: 2012-0000234804\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=479962&c=962d0 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#AA96  Northampton County PA CAD) [f32]FIREW >FIRE TRANSFORMER / WIRES 300 N SCHANCK AVE - BLK OF CRAIG KUSTER Cad: 2012-0000234655\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=479850&c=19a04 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A74O  Northampton County PA CAD) [f32]RES >RESCUE (TYPE) 202 N LOBB AVE PEN ARGYL WILLIS BROWN Map: Grids:0,0 Cad: 2012-0000229180\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=475800&c=fdb56 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A71O  Northampton County PA CAD) [f32]WIRE >WIRE (GENERAL PROBLEM) 121 JACKSON AVE PEN ARGYL WILLIAM BIECHY Map: Grids:0,0 Cad: 2012-0000228997\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=475692&c=feb38 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A610  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 509 E MAIN ST PEN ARGYL THE SLATE HOTEL & PUB Map: Grids:0,0 Cad: 2012-0000226994\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=474372&c=2eb24 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A5SI  Northampton County PA CAD) [f32]PC >PHONE CALL 44 W BELL AVE PEN ARGYL P3211 Map: Grids:0,0 Cad: 2012-0000226490\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=474066&c=84a21 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A4JO  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 301 W MAIN ST PEN ARGYL THE SALVATION ARMY Map: Grids:0,0 Cad: 2012-0000223781\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=472452&c=31c06 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A4IA  Northampton County PA CAD) [f32]FIREV >VEHICLE FIRE 202 E MAIN ST PEN ARGYL PASTER FRANK Map: Grids:0,0 Cad: 2012-0000223678\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=472402&c=4182a for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A4BS  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 513 WOOD AVE S PEN ARGYL PANKO, ALICE J Map: Grids:0,0 Cad: 2012-0000223306\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=472168&c=d22c4 for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 
(#A38Y  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 509 E MAIN ST PEN ARGYL THE SLATE HOTEL & PUB Map: Grids:0,0 Cad: 2012-0000221222\n\nSent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\nVisit https://www.notifync.org/am.php?a=470770&c=84fef for the map of the area\r\n--\r\nYou received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n\r\nTell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org 


*/

public class PANorthamptonCountyParserTest extends BaseParserTest {
  
  public PANorthamptonCountyParserTest() {
    setParser(new PANorthamptonCountyParser(), "NORTHAMPTON COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 602 E 21ST ST Apt: 119 Bldg NORTHAMPTON DIANE ECK Map: Grids:0,0 Cad: 2011-0000086714",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:602 E 21ST ST",
        "APT:119 Bldg",
        "CITY:NORTHAMPTON",
        "NAME:DIANE ECK",
        "ID:2011-0000086714");

    doTest("T2",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE Apt: REAR Bldg NORTHAMPTON TONY FERRERA Map: Grids:0,0 Cad: 2011-00000",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1323 NEWPORT AVE",
        "APT:REAR Bldg",
        "CITY:NORTHAMPTON",
        "NAME:TONY FERRERA",
        "ID:2011-00000");

    doTest("T3",
        "[e49]MVAI >MVA WITH INJURIES 248 AT PENNSVILLE LIGHT LEHIGH TWP NATALIE BRODIANO Cad: 2011-0000086361",
        "UNIT:e49",
        "CALL:MVA WITH INJURIES",
        "ADDR:248 AT PENNSVILLE LIGHT",
        "CITY:LEHIGH TWP",
        "NAME:NATALIE BRODIANO",
        "ID:2011-0000086361");

    doTest("T4",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 612 E 10TH ST NORTHAMPTON ROBERTS PAMELA Map: Grids:0,0 Cad: 2011-0000086262",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:612 E 10TH ST",
        "CITY:NORTHAMPTON",
        "NAME:ROBERTS PAMELA",
        "ID:2011-0000086262");

    doTest("T5",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1001 WASHINGTON AVE Apt: 105 Bldg NORTHAMPTON MEGAN MOREY Map: Grids:0,0 Cad: 2011-000008",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1001 WASHINGTON AVE",
        "APT:105 Bldg",
        "CITY:NORTHAMPTON",
        "NAME:MEGAN MOREY",
        "ID:2011-000008");

    doTest("T6",
        "[e49]ALS >ADVANCED LIFE SUPPORT CALL 5962 KEYSTONE DR EAST ALLEN CHRISTINA WIGMER Map: Grids:0,0 Cad: 2011-0000086103",
        "UNIT:e49",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:5962 KEYSTONE DR",
        "CITY:EAST ALLEN",
        "NAME:CHRISTINA WIGMER",
        "ID:2011-0000086103");

    doTest("T7",
        "[e49]BLS >BASIC LIFE SUPPORT CALL 1323 NEWPORT AVE NORTHAMPTON TONY CABRERA Map: Grids:0,0 Cad: 2011-0000086010",
        "UNIT:e49",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:1323 NEWPORT AVE",
        "CITY:NORTHAMPTON",
        "NAME:TONY CABRERA",
        "ID:2011-0000086010");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Subject:#6550\n[f14]MVAU >MVA WITH UNKNOW INJUIRIES WILLOW PARK RD BETHLEHEM TWP P1736 Map: Grids:0,0 Cad: 2011-0000131105",
        "UNIT:f14",
        "CALL:MVA WITH UNKNOW INJUIRIES",
        "ADDR:WILLOW PARK RD",
        "CITY:BETHLEHEM TWP",
        "NAME:P1736",
        "ID:2011-0000131105");
   
  }
  
  public void testParsaer3() {

    doTest("T1",
        "*3750: *alert_6JP4@notifync.org /  / [f25]ODOR >ODOR / OTHER THAN SMOKE ARNDT RD FORKS Map: Grids:0,0 Cad: 2011-0000171220 <20110000171220>",
        "UNIT:f25",
        "CALL:ODOR/OTHER THAN SMOKE",
        "ADDR:ARNDT RD",
        "NAME:FORKS",
        "ID:2011-0000171220 <20110000171220>");

  }
  
  @Test
  public void testDavidBurgin() {

    doTest("T1",
        "[f35]RES >RESCUE (TYPE) 951 S BROADWAY WIND GAP FEMALE CALLER Map: Grids:0,0 Cad: 2013-0000027694",
        "UNIT:f35",
        "CALL:RESCUE (TYPE)",
        "ADDR:951 S BROADWAY",
        "CITY:WIND GAP",
        "NAME:FEMALE CALLER",
        "ID:2013-0000027694");

  }
  
  @Test
  public void testSoftail2() {

    doTest("T1",
        "[f26]FIRE >FIRE GENERIC (TYPE) 4911 CEDAR GROVE PARK LOWER MT BETHEL WESCOE SHARON Map: Grids:0,0 Cad: 2013-0000037135",
        "UNIT:f26",
        "CALL:FIRE GENERIC (TYPE)",
        "ADDR:4911 CEDAR GROVE PARK",
        "CITY:LOWER MT BETHEL",
        "NAME:WESCOE SHARON",
        "ID:2013-0000037135");

  }
 
  @Test
  public void testActive911() {

    doTest("T1",
        "[#8ICT  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 6303 HANOVERVILLE RD EAST ALLEN SARA HILBERT Map: Grids:0,0 Cad: 2012-0000098761\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397037&c=f5d0d for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:6303 HANOVERVILLE RD",
        "CITY:EAST ALLEN",
        "NAME:SARA HILBERT",
        "ID:2012-0000098761");

    doTest("T2",
        "[#8IJN  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5516 LOIS LN EAST ALLEN HOSER, CHRISTINE Map: Grids:0,0 Cad: 2012-0000099349\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397283&c=8e4b8 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:5516 LOIS LN",
        "CITY:EAST ALLEN",
        "NAME:HOSER, CHRISTINE",
        "ID:2012-0000099349");

    doTest("T3",
        "[#8IKZ  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 251 S GREENBRIAR DR EAST ALLEN HORTON, ROBERT Map: Grids:0,0 Cad: 2012-0000099450\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397331&c=4e113 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:251 S GREENBRIAR DR",
        "CITY:EAST ALLEN",
        "NAME:HORTON, ROBERT",
        "ID:2012-0000099450");

    doTest("T4",
        "[#8IMN  Northampton County PA CAD] [e46]MVA >MVA NONE INJURY AIRPORT RD EAST ALLEN 4676 Map: Grids:0,0 Cad: 2012-0000099584\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397391&c=b9536 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:MVA NONE INJURY",
        "ADDR:AIRPORT RD",
        "CITY:EAST ALLEN",
        "NAME:4676",
        "ID:2012-0000099584");

    doTest("T5",
        "[#8IXF  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 478 BLUE MOUNTAIN DR LEHIGH KARMONICK, TERRY Map: Grids:0,0 Cad: 2012-0000100411\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397779&c=77340 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:478 BLUE MOUNTAIN DR",
        "CITY:LEHIGH",
        "NAME:KARMONICK, TERRY",
        "ID:2012-0000100411");

    doTest("T6",
        "[#8J0R  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5701 COLONY DR EAST ALLEN MARY JOE DEEGAN Map: Grids:0,0 Cad: 2012-0000100593\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397899&c=90443 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:5701 COLONY DR",
        "CITY:EAST ALLEN",
        "NAME:MARY JOE DEEGAN",
        "ID:2012-0000100593");

    doTest("T7",
        "[#8J2X  Northampton County PA CAD] [e46]BLS >BASIC LIFE SUPPORT CALL 5745 COLONY DR EAST ALLEN WENGRYN HELEN Map: Grids:0,0 Cad: 2012-0000100697\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=397977&c=2f09b for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:BASIC LIFE SUPPORT",
        "ADDR:5745 COLONY DR",
        "CITY:EAST ALLEN",
        "NAME:WENGRYN HELEN",
        "ID:2012-0000100697");

    doTest("T8",
        "[#8J6H  Northampton County PA CAD] [e46]ALS >ADVANCED LIFE SUPPORT CALL 5897 LEHIGH LN EAST ALLEN WALTON, CECELIA Map: Grids:0,0 Cad: 2012-0000100946\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\n" +
        "Visit https://www.notifync.org/am.php?a=398105&c=61154 for the map of the area\n" +
        "--\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org \n",

        "UNIT:e46",
        "CALL:ADVANCED LIFE SUPPORT",
        "ADDR:5897 LEHIGH LN",
        "CITY:EAST ALLEN",
        "NAME:WALTON, CECELIA",
        "ID:2012-0000100946");

    doTest("T9",
        "[f20]FIRED >DWELLING FIRE 912-14 CENTRE ST EASTON MALE CALLER Map: Grids:0,0 Cad: 2012-0000136112",
        "UNIT:f20",
        "CALL:DWELLING FIRE",
        "ADDR:912-14 CENTRE ST",
        "MADDR:912 CENTRE ST",
        "CITY:EASTON",
        "NAME:MALE CALLER",
        "ID:2012-0000136112");
  }
  
  @Test
  public void testPenArgylFire() {

    doTest("T1",
        "(#ABBE  Northampton County PA CAD) [f32]FIRED >DWELLING FIRE 1573 DELABOLE RD PLAINFIELD RILEY,DENNIS Map: Grids:0,0 Cad: 2013-0000001381\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=481226&c=58158 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:DWELLING FIRE",
        "ADDR:1573 DELABOLE RD",
        "CITY:PLAINFIELD",
        "NAME:RILEY,DENNIS",
        "ID:2013-0000001381");

    doTest("T2",
        "(#AACA  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 201 W MAIN ST PEN ARGYL DORIS GILBERT Map: Grids:0,0 Cad: 2012-0000234804\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=479962&c=962d0 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE ALARM",
        "ADDR:201 W MAIN ST",
        "CITY:PEN ARGYL",
        "NAME:DORIS GILBERT",
        "ID:2012-0000234804");

    doTest("T3",
        "(#AA96  Northampton County PA CAD) [f32]FIREW >FIRE TRANSFORMER / WIRES 300 N SCHANCK AVE - BLK OF CRAIG KUSTER Cad: 2012-0000234655\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=479850&c=19a04 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE TRANSFORMER / WIRES",
        "ADDR:300 N SCHANCK AVE",
        "NAME:- BLK OF CRAIG KUSTER",
        "ID:2012-0000234655");

    doTest("T4",
        "(#A74O  Northampton County PA CAD) [f32]RES >RESCUE (TYPE) 202 N LOBB AVE PEN ARGYL WILLIS BROWN Map: Grids:0,0 Cad: 2012-0000229180\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=475800&c=fdb56 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:RESCUE (TYPE)",
        "ADDR:202 N LOBB AVE",
        "CITY:PEN ARGYL",
        "NAME:WILLIS BROWN",
        "ID:2012-0000229180");

    doTest("T5",
        "(#A71O  Northampton County PA CAD) [f32]WIRE >WIRE (GENERAL PROBLEM) 121 JACKSON AVE PEN ARGYL WILLIAM BIECHY Map: Grids:0,0 Cad: 2012-0000228997\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=475692&c=feb38 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:WIRE (GENERAL PROBLEM)",
        "ADDR:121 JACKSON AVE",
        "CITY:PEN ARGYL",
        "NAME:WILLIAM BIECHY",
        "ID:2012-0000228997");

    doTest("T6",
        "(#A610  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 509 E MAIN ST PEN ARGYL THE SLATE HOTEL & PUB Map: Grids:0,0 Cad: 2012-0000226994\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=474372&c=2eb24 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE ALARM",
        "ADDR:509 E MAIN ST",
        "CITY:PEN ARGYL",
        "NAME:THE SLATE HOTEL & PUB",
        "ID:2012-0000226994");

    doTest("T7",
        "(#A5SI  Northampton County PA CAD) [f32]PC >PHONE CALL 44 W BELL AVE PEN ARGYL P3211 Map: Grids:0,0 Cad: 2012-0000226490\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=474066&c=84a21 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:PHONE",
        "ADDR:44 W BELL AVE",
        "CITY:PEN ARGYL",
        "NAME:P3211",
        "ID:2012-0000226490");

    doTest("T8",
        "(#A4JO  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 301 W MAIN ST PEN ARGYL THE SALVATION ARMY Map: Grids:0,0 Cad: 2012-0000223781\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=472452&c=31c06 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE ALARM",
        "ADDR:301 W MAIN ST",
        "CITY:PEN ARGYL",
        "NAME:THE SALVATION ARMY",
        "ID:2012-0000223781");

    doTest("T9",
        "(#A4IA  Northampton County PA CAD) [f32]FIREV >VEHICLE FIRE 202 E MAIN ST PEN ARGYL PASTER FRANK Map: Grids:0,0 Cad: 2012-0000223678\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=472402&c=4182a for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:VEHICLE FIRE",
        "ADDR:202 E MAIN ST",
        "CITY:PEN ARGYL",
        "NAME:PASTER FRANK",
        "ID:2012-0000223678");

    doTest("T10",
        "(#A4BS  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 513 WOOD AVE S PEN ARGYL PANKO, ALICE J Map: Grids:0,0 Cad: 2012-0000223306\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=472168&c=d22c4 for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE ALARM",
        "ADDR:513 WOOD AVE S",
        "CITY:PEN ARGYL",
        "NAME:PANKO, ALICE J",
        "ID:2012-0000223306");

    doTest("T11",
        "(#A38Y  Northampton County PA CAD) [f32]FIREA >FIRE ALARM 509 E MAIN ST PEN ARGYL THE SLATE HOTEL & PUB Map: Grids:0,0 Cad: 2012-0000221222\n\n" +
        "Sent by Northampton County Alert Network powered by Cooper Notification's Roam Secure Alert Network\r\n" +
        "Visit https://www.notifync.org/am.php?a=470770&c=84fef for the map of the area\r\n" +
        "--\r\n" +
        "You received this message because you registered on Northampton County Alert Network . To change your alerting preferences go to www.notifync.org/mygroups.php\r\n" +
        "\r\n" +
        "Tell a friend/co-worker about Northampton County Alert Network! Forward this message to them and have them register for this free service at www.notifync.org ",

        "UNIT:f32",
        "CALL:FIRE ALARM",
        "ADDR:509 E MAIN ST",
        "CITY:PEN ARGYL",
        "NAME:THE SLATE HOTEL & PUB",
        "ID:2012-0000221222");

  }
  
  public static void main(String[] args) {
    new PANorthamptonCountyParserTest().generateTests("T1");
  }
}

