package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Harris County ESD #1, TX
Contact: Nathan Mathews <nbmathews807@gmail.com>
Contact: Richy Hancock <richy@huffmanfire.org>
Contact: Ennio Ponte <EPonte@channelviewfire.com>
Sender: cadnoreply@proxy.hcec.com
Sender: 930010nn
ID#:11-06-20685 - - TRASH FIRE - 111 Bayou Dr - Apt:C - Bldg: - Key Map: 498D - Cross Streets:EAST FWY/MARKET - Box #:2002
ID#:11-06-20710 - - FIRE - PreAlert - 16217 Ridlon - Apt: - Bldg: intra SERVICES - Key Map: 498C - Cross Streets:SHEILA LN/WOODLAND D
ID#:11-06-20658 - - 29A1 MOTOR VEHICLE A - East Fwy / Delldale - Apt: - Bldg: - Key Map: 498E - Cross Streets: - Box #:2004
ID#:11-06-20627 - - 29A1 MOTOR VEHICLE A - 16410 Ave D - Apt:1 - Bldg: AVE D APTS - Key Map: 498D - Cross Streets:WOODLAND DR/CEDAR L

ID#:11-07-25331 - - ALARMS - 1518 Great Dover Cir - Apt: - Bldg: - Key Map: 458W
ID#:11-07-25341 - 06D02 - 6D1 RESPIRATORY - 11870 Greenloch Ln - Apt: - Bldg: - Key Map: 416K - Cross Streets:GREENCANYON DR/GREENROC 
ID#:11-07-25342 - 25A01 - PSYCHIATRIC - 15215 S Brentwood Dr - Apt: - Bldg: - Key Map: 498E - Cross Streets:Dead End/DELLDALE - Box #:2004
ID#:11-07-25378 - - Stroke (CVA) - 11715 Greenglen Dr - Apt: - Bldg: - Key Map: 416K - Cross Streets:JOHN RALSTON RD/GREENROCK LN - B 
ID#:11-07-25416 - - HEMORRHAGE/LACERATIO - 12370 S San Circle Dr - Apt: - Bldg: UNK TRAILER PARK - Key Map: 456C - Cross Streets:BARK 
ID#:11-08-25733 - 55B04 - ELECTRICAL HAZARD - 16102 E Ih 10 - Apt: - Bldg: OLD RIVER CHURCH DAY - Key Map: 498G - Cross Streets:IH 10 EAST BAYOU RAMP/IH 10 SH -
ID#:11-08-25969 - 29D02m - 29D5 MOTOR VEHICLE A - 539 S Sheldon Rd - Apt: - Bldg: - Key Map: 498K - Cross Streets:JACINTO PORT BLVD/MARKET - Box #:2001
ID#:11-08-25936 - 29B04 - Traffic/Trans Incide - E BW 8 N / WOODFOREST BW 8 NB - Apt: - Bldg: - Key Map: 457Y - Cross Streets: - Box #:2005
ID#:11-08-26006 - - Citizen Assist - 5500 E Bw 8 N - Apt: - Bldg: big tex storage - Key Map: 457Y - Cross Streets:BW 8 NB WALLISVILLE EXIT RAMP/ - Box #:2005
ID#:11-08-28674 - Units:M151 - 32B01 - 32B1 UNKNOWN PROBLEM - 606 Commons Vista Dr - Apt: - Bldg: - Key Map: 298Q - Cross Streets:COM
ID#:11-08-29430 - - FALLS - 17015 Faring Rd - Apt: - Bldg: - Key Map: 418X - Cro
ID#:11-08-29436 - - ALARMS - 1714 Hidden Terrace Dr - Apt: - Bldg: - Key Map: 458S - Cross Streets:HIDDEN CREST DR/HIDDEN MANOR D - Box #:2005
ID#:11-08-26039 - - FUEL SPILL - 15880 Wallisville Rd - Apt: - Bldg: LEGEND OAKS - EAST - Key Map: 457V - Cross Streets:HIDDEN PARK DR/HYACINTH PATH W - Box #:2005
ID#:11-08-26105 - 21B01 - HEMORRHAGE/LACERATIO - 11803 Greenmesa Dr - Apt: - Bld
ID#:11-08-26080 - 13D01 - DIABETIC PROBLEMS - 10710 Green River Dr - Apt: - Bldg
ID#:11-08-26159 - - Stab / GSW (B) - 919 Holbech - Apt: - Bldg: - Key Map: 497D
ID#:11-08-26160 - - HEART PROBLEMS - 9402 Abbotshall Ln - Apt: - Bldg: - Key Map: 456D - Cross Streets:ARBOR FIELD LN/STONEFIELD MANO - Box #:3304

 1 of 2\nFRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170 - 67D02 - 67D2 LG GRASS AND WO - US 90 / SHELDON US 90 RAMP - Apt: - Bldg: - Key Map:\n(Con't) 2 of 2\n458C - Cross Streets: - Box #:3304(End)

ID#:11-08-29410 - Address changed to:uvalde/kinsman - Cross Streets: - Key Map:NOT F
ID#:11-08-26067 - Address changed to:620 SHELDON RD - Cross Streets:AVE C/RIDLON - Key Map:498B
ID#:11-08-26080 - Address changed to:10710 Greens Crossing Blvd - Cross Streets

ID#:11-08-29436 - UNIT:L32 - DISP: 21:06:25 - ER: - OUT: - TO: - AT: - AIR: 21:0
FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:E13 - DISP: 11:19:11 - ER: - OUT: - AIR: 11:23:42
FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:BRU23 - DISP: 10:57:35 - ER: - OUT: - AIR: 11:23:56

Contact: Active911
[] ID#:12-06-23555 - - 60B1 GAS LEAK/ODOR ( - 11000 E Canal Rd - Apt: - Bldg: - Key Map: 460J - Cross Streets:OAK AVE/HOLLY DR - Box #:1705\n
[]  ID#:12-06-23555 - Address changed to:1100 E CANAL RD - Cross Streets:OAK AVE/HOLLY DR - Key Map:460J\n
[]  ID#:12-06-23588 - Address changed to:ORLEANS ST / COTTONTAIL DR - Cross Streets: - Key Map:420W\n
[]  ID#:12-06-23588 - Address changed to:630 COTTONTAIL DR - Cross Streets:JOAN OF ARC ST/ORLEANS ST - Key Map:419Z\n

Contact: Active911
Agency name: Aldine Fire Department Location: Aldine, TX 
Sender: cadnoreply@proxy.hcec.com

ID#:12-07-26086 - UNIT:GPE1 - Call Rcvd: 10:35:44 - DISP: 10:47:25 - ER: - OUT: - TO: - AT: - AIR: 10:57:50
ID#:12-07-26106 - UNIT:E11 - DISP: 12:30:22 - ER: - OUT: - AIR: 12:31:28
ID#:12-07-26109 - UNIT:E31 - Call Rcvd: 12:37:33 - DISP: 12:38:15 - ER: - OUT: - TO: - AT: - AIR: 12:44:01
ID#:12-07-26309 - UNIT:E31 - Call Rcvd: 22:36:45 - DISP: 22:37:39 - ER: 22:40:01 - OUT: 22:47:50 - TO: - AT: - AIR: 23:05:03
ID#:12-07-26353 - UNIT:SQ31 - Call Rcvd: 06:57:00 - DISP: 06:58:43 - ER: - OUT: 07:06:50 - TO: - AT: - AIR: 07:11:00
ID#:12-07-26416 - UNIT:E21 - Call Rcvd: 16:40:37 - DISP: 16:41:39 - ER: 16:43:12 - OUT: 16:44:28 - TO: - AT: - AIR: 17:19:35

ID#:12-07-26090 - - FIRE - PreAlert - 2409 Foley Rd - Apt: - Bldg: CROSBY FIRE STATION - Key Map: NOT F - Cross Streets:BRIDGEWOOD DR/SUMMIT TRAIL RD - Box #:8004
 ID#:12-07-26090 - Address changed to:123 TEST STREET - Cross Streets:Dead End/Dead End - Key Map:496K
 ID#:12-07-26090 - Address changed to:5335 ALDINE BENDER RD - Cross Streets:CROSSWINDS DR/SURLES DR - Key Map:374Z
GPM1 - - MEDICAL - PreAlert - 5335 ALDINE BENDER RD - Apt: - Bldg: TIMBER RID - Key Map:374Z - Cross Streets:CROSSWINDS DR/SURLES DR - Box #:2601
 ID#:12-07-26090 - Address changed to:123 S DIAMONDHEAD BLVD - Cross Streets:CORAL BAY ST/PORT OCALL ST - Key Map:419C
ID#:12-07-26090 - - MEDICAL - PreAlert - 123 S DIAMONDHEAD BLVD - Apt: - Bldg: - Key Map: 419C - Cross Streets:CORAL BAY ST/PORT OCALL ST - Box #:8005
SQ31 - 31D03 - 31D3 UNCONSCIOUS PAR - 433 Northpark Central Dr - Apt: - Bldg: ZOYTO - Key Map:332Y - Cross Streets:NORTHVIEW PARK DR/WOODHAM DR - Box #:1101
E11 - 69D06T - 69D6 FIRE IN THE RE - 4723 Cicada Ln - Apt: - Bldg: - Key Map:414G - Cross Streets:BOREAS/CRIEFFE RD - Box #:2506
 ID#:12-07-26186 - Address changed to:4715 CICADA LN - Cross Streets:BOREAS/CRIEFFE RD - Key Map:414G
SQ31 - 06E01 - 6E1 RESPIRATORY - 503 Salma Ct - Apt: - Bldg: - Key Map:372H - Cross Streets:Dead End/DESERT MARIGOLD DR - Box #:1103
SQ31 - - 12A1 SEIZURES - 15516 Martineau St - Apt: - Bldg: - Key Map:373R - Cross Streets:MARVELL DR/GREENBRIAR COLONY D - Box #:1106
E11 - 12C01E - 12C1 SEIZURES - 15516 Martineau St - Apt: - Bldg: - Key Map:373R - Cross Streets:MARVELL DR/GREENBRIAR COLONY D - Box #:1106
E11 - 69D01 - 69D1 STRUCTURE FIRE - 12345 Vickery St - Apt: - Bldg: OLESON ELE - Key Map:414G - Cross Streets:CHARRITON DR/ALDINE MAIL RD - Box #:2506
E31 - 29D02m - 29D2 MOTOR VEHICLE A - 14900 North Fwy - Apt: 203 - Bldg: VALUE PLAC - Key Map:372C - Cross Streets:Dead End/AIRTEX ENTR NB 45 - Box #:1103
E11 - - 69D6 FIRE IN THE RE - 823 Bandon Ln - Apt: - Bldg: - Key Map:372H - Cross Streets:PRAIRIE LARKSPUR DR/REMINGTON - Box #:1103
SQ31 - - 29A1 MOTOR VEHICLE A - Hardy Toll Rd / Rankin Hardy Toll R - Apt: - Bldg: - Key Map:373F - Cross Streets: - Box #:1104
 - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Hardy Bw 8 W - Apt: - Bldg: - Key Map:373S - Cross Streets: - Box #:4102
E11 - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Hardy Bw 8 W - Apt: - Bldg: - Key Map:373S - Cross Streets: - Box #:4102
SQ31 - 29D02n - 29D2 MOTOR VEHICLE A - E Hardy Rd / N Sam Houston Pkwy E - Apt: - Bldg: THE PIT HA - Key Map:373T - Cross Streets: - Box #:1106
SQ31 - - BREATHING PROBLEMS - 17630 Wayforest Dr - Apt: 390 - Bldg: AGUSTA - Key Map:373J - Cross Streets:HARVEST TIME LN/RICHCREST DR - Box #:1106
E11 - 06C01A - 6C1 RESPIRATORY - 17630 Wayforest Dr - Apt: 390 - Bldg: AGUSTA - Key Map:373J - Cross Streets:HARVEST TIME LN/RICHCREST DR - Box #:1106
SQ31 - - 29A1 MOTOR VEHICLE A - E Richey Rd / Oil Center Blvd - Apt: - Bldg: - Key Map:333X - Cross Streets: - Box #:1102
SQ31 - - 29A1 MOTOR VEHICLE A - 16600 E Hardy Rd - Apt: - Bldg: - Key Map:373K - Cross Streets:Dead End/RANKIN RD - Box #:1106
E11 - - 69D6 FIRE IN THE RE - 14330 E Hardy Rd - Apt: - Bldg: MOGAS - Key Map:373X - Cross Streets:PINAFORE LN/BUSCHONG - Box #:1107
E31 - 69D03 - 69D3 COMMERCIAL BUI - 14330 E Hardy Rd - Apt: - Bldg: MOGAS - Key Map:373X - Cross Streets:PINAFORE LN/BUSCHONG - Box #:1107
SQ31 - 12A02E - 12A2 SEIZURES - 830 Vista Grove Cir - Apt: - Bldg: - Key Map:332Z - Cross Streets:GROVEDALE DR/GROVEDALE DR - Box #:1108
E11 - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Aldine Westf - Apt: - Bldg: - Key Map:373U - Cross Streets: - Box #:1106
E31 - - ODOR(STRANGE, UNKNOW - 507 Remington Lodge Ct - Apt: - Bldg: - Key Map:372D - Cross Streets:REMINGTON PARK DR/Dead End - Box #:1103
E11 - 69D09 - 69D9 SHED ON FIRE - 14615 Aldine Westfield Rd - Apt: - Bldg: CHRISTIAN - Key Map:373Z - Cross Streets:BUSCHONG/ALDINE BENDER RD - Box #:1107
SQ31 - 29D02m - 29D2 MOTOR VEHICLE A - 818 Richcrest Dr - Apt: - Bldg: GREENBRIAR - Key Map:373J - Cross Streets:CHISHOLM TRL/WAYFOREST DR - Box #:1106
SQ31 - - 29A1 MOTOR VEHICLE A - North Fwy / Airtex - Apt: - Bldg: - Key Map:372C - Cross Streets: - Box #:1103
E31 - 52C03G - 52C3 ALARMS - 16110 North Fwy - Apt: - Bldg: CARMAX - Key Map:332U - Cross Streets:RICHEY EXIT NB 45/RICHEY ENTR - Box #:1101
E31 - - 53A1 CITIZEN ASSIST - 19423 Remington Prairie Dr - Apt: - Bldg: - Key Map:372G - Cross Streets:REMINGTON GREEN CT/REMINGTON B - Box #:1103
E11 - 69D06 - 69D6 FIRE IN THE RE - 2719 Brea Crest St - Apt: - Bldg: - Key Map:414N - Cross Streets:INNSBURY DR/SHADY LN - Box #:2502
E21 - - 52B1 ALARMS - 2700 W W Thorne Blvd - Apt: - Bldg: N HARRIS C - Key Map:333S - Cross Streets:E HARDY RD/OIL CENTER BLVD - Box #:1102
SQ31 - 10D04 - 10D4 CARDIAC - 22226 Queenbury Hills Dr - Apt: - Bldg: - Key Map:332R - Cross Streets:LANCASTER LAKE DR/RED ALDER CI - Box #:1108
SQ31 - - BREATHING PROBLEMS - 15403 E Vantage Pkwy - Apt: - Bldg: THE WORD C - Key Map:373V - Cross Streets:N SAM HOUSTON PKWY E/WAVERLY D - Box #:1106
E11 - 06D02 - 6D2 RESPIRATORY - 15403 E Vantage Pkwy - Apt: - Bldg: THE WORD C - Key Map:373V - Cross Streets:N SAM HOUSTON PKWY E/WAVERLY D - Box #:1106
E7 - 67B01 - 67B1 SMALL TRASH FIR - 11025 United St - Apt: - Bldg: - Key Map:414U - Cross Streets:ELL RD/LONE OAK RD - Box #:2505

Contact: Active911
Agency name: Atascocita Volunteer Fire Department - FIRE
Location: Humble, TX, United States
Sender: cadnoreply@proxy.hcec.com

ID#:13-02-05942 - UNIT:E19 - Call Rcvd: 18:31:52 - DISP: 18:35:07 - ER: 18:35:11 - OUT: 18:36:57 - TO: - AT: - AIR: 18:50:58
E29 - 29B04U - 29B4 MOTOR VEHICLE A - 8300 E Fm 1960 - Apt: - Bldg: - Key Map:338S - Cross Streets:FAIRWAY ISLAND DR/PINE ECHO DR - Box #:A1901
E29 - - 29A1 MOTOR VEHICLE A - 8300 E Fm 1960 - Apt: - Bldg: - Key Map:338S - Cross Streets:FAIRWAY ISLAND DR/PINE ECHO DR - Box #:A1901
E39 - 29B01 - 29B1 MOTOR VEHICLE A - Will Clayton Pkwy / Tabor Brook Dr - Apt: - Bldg: - Key Map:377C - Cross Streets: - Box #:A1901
E39 - 31D02 - 31D2 UNCONSCIOUS PAR - 5806 Ancient Oaks Dr - Apt: - Bldg: - Key Map:337T - Cross Streets:OAK STATION DR/OAK BRIAR DR - Box #:A3901
ID#:13-02-05928 - UNIT:D9 - Call Rcvd: 15:27:36 - DISP: 15:31:24 - ER: 15:31:29 - OUT: 15:33:52 - TO: - AT: - AIR: 16:23:03
D9 - - 29A1 MOTOR VEHICLE A - W Lake Houston Pkwy / Kings Park Wa - Apt: - Bldg: - Key Map:337U - Cross Streets: - Box #:A1901
ID#:13-02-05909 - UNIT:E39 - Call Rcvd: 12:35:59 - DISP: 12:36:53 - ER: - OUT: 12:47:45 - TO: - AT: - AIR: 12:53:04
E39 - - 52B1 ALARMS - 12706 Wolf Creek Ct - Apt: - Bldg: - Key Map:337X - Cross Streets:Dead End/WOLF CREEK TRL - Box #:A3901
ID#:13-02-05823 - UNIT:D29 - Call Rcvd: 18:18:52 - DISP: 18:22:07 - ER: 18:22:07 - OUT: - TO: - AT: - AIR: 18:27:57

Contact: Active911
Agency name: Westfield Fire
Location: Houston, TX, United States
Sender: cadnoreply@proxy.hcec.com

D25 -29D02p-29D2 MOTOR VEHICLE A-1830 Aldine Mail Rd - Apt: - Bldg:SEFTON STE- Key Map:413H - Cross Streets:CHRISMAN RD/ROBERTCREST ST - Box #:2501
ID#:13-05-18501 - UNIT:E7 - Call Rcvd: 10:00:02 - DISP: 10:01:08 - ER: 10:03:19 - OUT: 10:06:07 - TO: - AT: - AIR: 10:13:54
E7 - -CITIZEN ASSIST -3306 Charriton Dr - Apt: - Bldg: - Key Map:414E - Cross Streets:FALL MEADOW LN/FERN MEADOW LN - Box #:2503
E7 - -29A1 MOTOR VEHICLE A-Lauder Rd / John F Kennedy Blvd - Apt: - Bldg:TEXACO - Key Map:414B - Cross Streets: - Box #:2501
ID#:13-05-18399 - UNIT:E7 - DISP: 17:23:42 - ER: 17:25:22 - OUT: - AIR: 17:27:20
E7 - -FIRE ALARM -12959 Aldine Westfield Rd - Apt: - Bldg:WALGREENS - Key Map:413H - Cross Streets:ISOM ST/ALDINE MAIL RD - Box #:2503
E7 -29D01b-29D1 MOTOR VEHICLE A-3600 Mooney Rd - Apt: - Bldg: - Key Map:414P - Cross Streets:BENTLEY RD/WARDVILLE - Box #:2505
ID#:13-05-18269 - UNIT:E7 - Call Rcvd: 19:52:50 - DISP: 19:55:01 - ER: 19:57:22 - OUT: 19:59:08 - TO: - AT: - AIR: 20:15:25
E7 -53O02 -CITIZEN ASSIST -2439 Lauder Rd - Apt: - Bldg: - Key Map:414A - Cross Streets:ALDINE WESTFIELD RD/GREENRANCH- Box #:2501
ID#:13-05-18159 - UNIT:D25 - Call Rcvd: 08:10:32 - DISP: 08:14:41 - ER: 08:16:38 - OUT: 08:18:20 - TO: - AT: - AIR: 09:01:28
T5 -69D03 -69D3 COMMERCIAL BUI-13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501
SQ25 -69D03 -69D3 COMMERCIAL BUI-13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501
E7 - -FIRE ALARM -13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501
ID#:13-05-18152 - UNIT:E7 - Call Rcvd: 07:20:04 - DISP: 07:24:10 - ER: - OUT: - TO: - AT: - AIR: 07:46:50
E7 -09E02 -9E2 FULL ARREST -4826 Aldine Mail Rd - Apt:9 - Bldg:ALDINE APT- Key Map:414G - Cross Streets:BOREAS/MACNAUGHTON DR - Box #:2506
E7 -13C03 -13C3 DIABETIC -10902 United St - Apt: - Bldg: - Key Map:414U - Cross Streets:LONE OAK RD/LITTLECREST RD - Box #:2505
E7 -10D01 -10D1 CARDIAC -1918 Isom St - Apt: - Bldg: - Key Map:413M - Cross Streets:ISOM RD/ALDINE WESTFIELD RD - Box #:2501
E7 -29B01 -29B1 MOTOR VEHICLE A-11730 Vickery St - Apt: - Bldg: - Key Map:414L - Cross Streets:ORANGE GROVE DR/MOUNT HOUSTON - Box #:2505
E7 - -29A1 MOTOR VEHICLE A-Eastex Fwy / Hopper Entr 59 Sb - Apt: - Bldg: - Key Map:414Q - Cross Streets: - Box #:2505
L8 -29B04 -29B4 MOTOR VEHICLE A-1900 Isom St - Apt: - Bldg: - Key Map:413M - Cross Streets:ISOM RD/ALDINE WESTFIELD RD - Box #:2501

*** Not parsing 
[]  - - 32B1 UNKNOWN PROBLEM - 123 Test Street - Apt: - Bldg: TESTING AP - Key Map:496K - Cross Streets:Dead End/Dead End - Box #:4104\n

*/

public class TXHarrisCountyESD1BParserTest extends BaseParserTest {
  
  public TXHarrisCountyESD1BParserTest() {
    setParser(new TXHarrisCountyESD1BParser(), "HARRIS COUNTY", "TX");
  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "ID#:11-08-29436 - UNIT:L32 - DISP: 21:06:25 - ER: - OUT: - TO: - AT: - AIR: 21:0",
        "CALL:RUN REPORT",
        "PLACE:ID#:11-08-29436 - UNIT:L32 - DISP: 21:06:25 - ER: - OUT: - TO: - AT: - AIR: 21:0");

    doTest("T2",
        "FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:E13 - DISP: 11:19:11 - ER: - OUT: - AIR: 11:23:42",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-06-21170- UNIT:E13 - DISP: 11:19:11 - ER: - OUT: - AIR: 11:23:42");

    doTest("T3",
        "FRM:cadnoreply@proxy.hcec.com\nMSG:ID#:12-06-21170- UNIT:BRU23 - DISP: 10:57:35 - ER: - OUT: - AIR: 11:23:56",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-06-21170- UNIT:BRU23 - DISP: 10:57:35 - ER: - OUT: - AIR: 11:23:56");

  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ID#:11-06-20685 - - TRASH FIRE - 111 Bayou Dr - Apt:C - Bldg: - Key Map: 498D - Cross Streets:EAST FWY/MARKET - Box #:2002",
        "ID:11-06-20685",
        "CALL:TRASH FIRE",
        "ADDR:111 Bayou Dr",
        "APT:C",
        "MAP:498D",
        "X:EAST FWY/MARKET",
        "BOX:2002");

    doTest("T2",
        "ID#:11-06-20710 - - FIRE - PreAlert - 16217 Ridlon - Apt: - Bldg: intra SERVICES - Key Map: 498C - Cross Streets:SHEILA LN/WOODLAND D",
        "ID:11-06-20710",
        "CALL:FIRE - PreAlert",
        "ADDR:16217 Ridlon",
        "PLACE:intra SERVICES",
        "MAP:498C",
        "X:SHEILA LN/WOODLAND D");

    doTest("T3",
        "ID#:11-06-20658 - - 29A1 MOTOR VEHICLE A - East Fwy / Delldale - Apt: - Bldg: - Key Map: 498E - Cross Streets: - Box #:2004",
        "ID:11-06-20658",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:East Fwy & Delldale",
        "MAP:498E",
        "BOX:2004");

    doTest("T4",
        "ID#:11-06-20627 - - 29A1 MOTOR VEHICLE A - 16410 Ave D - Apt:1 - Bldg: AVE D APTS - Key Map: 498D - Cross Streets:WOODLAND DR/CEDAR L",
        "ID:11-06-20627",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:16410 Ave D",
        "PLACE:AVE D APTS",
        "APT:1",
        "MAP:498D",
        "X:WOODLAND DR/CEDAR L");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "ID#:11-07-25331 - - ALARMS - 1518 Great Dover Cir - Apt: - Bldg: - Key Map: 458W",
        "ID:11-07-25331",
        "CALL:ALARMS",
        "ADDR:1518 Great Dover Cir",
        "MAP:458W");

    doTest("T2",
        "ID#:11-07-25341 - 06D02 - 6D1 RESPIRATORY - 11870 Greenloch Ln - Apt: - Bldg: - Key Map: 416K - Cross Streets:GREENCANYON DR/GREENROC",
        "ID:11-07-25341",
        "CODE:06D02",
        "CALL:6D1 RESPIRATORY",
        "ADDR:11870 Greenloch Ln",
        "MAP:416K",
        "X:GREENCANYON DR/GREENROC");

    doTest("T3",
        "ID#:11-07-25342 - 25A01 - PSYCHIATRIC - 15215 S Brentwood Dr - Apt: - Bldg: - Key Map: 498E - Cross Streets:Dead End/DELLDALE - Box #:2004",
        "ID:11-07-25342",
        "CODE:25A01",
        "CALL:PSYCHIATRIC",
        "ADDR:15215 S Brentwood Dr",
        "MAP:498E",
        "X:Dead End/DELLDALE",
        "BOX:2004");

    doTest("T4",
        "ID#:11-07-25378 - - Stroke (CVA) - 11715 Greenglen Dr - Apt: - Bldg: - Key Map: 416K - Cross Streets:JOHN RALSTON RD/GREENROCK LN - B",
        "ID:11-07-25378",
        "CALL:Stroke (CVA)",
        "ADDR:11715 Greenglen Dr",
        "MAP:416K",
        "X:JOHN RALSTON RD/GREENROCK LN");

    doTest("T5",
        "ID#:11-07-25416 - - HEMORRHAGE/LACERATIO - 12370 S San Circle Dr - Apt: - Bldg: UNK TRAILER PARK - Key Map: 456C - Cross Streets:BARK",
        "ID:11-07-25416",
        "CALL:HEMORRHAGE/LACERATIO",
        "ADDR:12370 S San Circle Dr",
        "PLACE:UNK TRAILER PARK",
        "MAP:456C",
        "X:BARK");

    doTest("T6",
        "ID#:11-08-25733 - 55B04 - ELECTRICAL HAZARD - 16102 E Ih 10 - Apt: - Bldg: OLD RIVER CHURCH DAY - Key Map: 498G - Cross Streets:IH 10 EAST BAYOU RAMP/IH 10 SH -",
        "ID:11-08-25733",
        "CODE:55B04",
        "CALL:ELECTRICAL HAZARD",
        "ADDR:16102 E Ih 10",
        "PLACE:OLD RIVER CHURCH DAY",
        "MAP:498G",
        "X:IH 10 EAST BAYOU RAMP/IH 10 SH");

    doTest("T7",
        "ID#:11-08-25969 - 29D02m - 29D5 MOTOR VEHICLE A - 539 S Sheldon Rd - Apt: - Bldg: - Key Map: 498K - Cross Streets:JACINTO PORT BLVD/MARKET - Box #:2001",
        "ID:11-08-25969",
        "CODE:29D02m",
        "CALL:29D5 MOTOR VEHICLE A",
        "ADDR:539 S Sheldon Rd",
        "MAP:498K",
        "X:JACINTO PORT BLVD/MARKET",
        "BOX:2001");

    doTest("T8",
        "ID#:11-08-25936 - 29B04 - Traffic/Trans Incide - E BW 8 N / WOODFOREST BW 8 NB - Apt: - Bldg: - Key Map: 457Y - Cross Streets: - Box #:2005",
        "ID:11-08-25936",
        "CODE:29B04",
        "CALL:Traffic/Trans Incide",
        "ADDR:E BW 8 N & WOODFOREST BW 8 NB",
        "MADDR:E BW 8 N & WOODFOREST BW 8",
        "MAP:457Y",
        "BOX:2005");


    doTest("T9",
        "ID#:11-08-26006 - - Citizen Assist - 5500 E Bw 8 N - Apt: - Bldg: big tex storage - Key Map: 457Y - Cross Streets:BW 8 NB WALLISVILLE EXIT RAMP/ - Box #:2005",
        "ID:11-08-26006",
        "CALL:Citizen Assist",
        "ADDR:5500 E Bw 8 N",
        "PLACE:big tex storage",
        "MAP:457Y",
        "X:BW 8 NB WALLISVILLE EXIT RAMP/",
        "BOX:2005");

    doTest("T10",
        "ID#:11-08-28674 - Units:M151 - 32B01 - 32B1 UNKNOWN PROBLEM - 606 Commons Vista Dr - Apt: - Bldg: - Key Map: 298Q - Cross Streets:COM",
        "ID:11-08-28674",
        "UNIT:M151",
        "CODE:32B01",
        "CALL:32B1 UNKNOWN PROBLEM",
        "ADDR:606 Commons Vista Dr",
        "MAP:298Q",
        "X:COM");

    doTest("T11",
        "ID#:11-08-29430 - - FALLS - 17015 Faring Rd - Apt: - Bldg: - Key Map: 418X - Cro",
        "ID:11-08-29430",
        "CALL:FALLS",
        "ADDR:17015 Faring Rd",
        "MAP:418X");

    doTest("T12",
        "ID#:11-08-29436 - - ALARMS - 1714 Hidden Terrace Dr - Apt: - Bldg: - Key Map: 458S - Cross Streets:HIDDEN CREST DR/HIDDEN MANOR D - Box #:2005",
        "ID:11-08-29436",
        "CALL:ALARMS",
        "ADDR:1714 Hidden Terrace Dr",
        "MAP:458S",
        "X:HIDDEN CREST DR/HIDDEN MANOR D",
        "BOX:2005");

    doTest("T13",
        "ID#:11-08-26039 - - FUEL SPILL - 15880 Wallisville Rd - Apt: - Bldg: LEGEND OAKS - EAST - Key Map: 457V - Cross Streets:HIDDEN PARK DR/HYACINTH PATH W - Box #:2005",
        "ID:11-08-26039",
        "CALL:FUEL SPILL",
        "ADDR:15880 Wallisville Rd",
        "PLACE:LEGEND OAKS",
        "MAP:457V",
        "X:HIDDEN PARK DR/HYACINTH PATH W",
        "BOX:2005");

    doTest("T14",
        "ID#:11-08-26105 - 21B01 - HEMORRHAGE/LACERATIO - 11803 Greenmesa Dr - Apt: - Bld",
        "ID:11-08-26105",
        "CODE:21B01",
        "CALL:HEMORRHAGE/LACERATIO",
        "ADDR:11803 Greenmesa Dr");

    doTest("T15",
        "ID#:11-08-26080 - 13D01 - DIABETIC PROBLEMS - 10710 Green River Dr - Apt: - Bldg",
        "ID:11-08-26080",
        "CODE:13D01",
        "CALL:DIABETIC PROBLEMS",
        "ADDR:10710 Green River Dr");

    doTest("T16",
        "ID#:11-08-26159 - - Stab / GSW (B) - 919 Holbech - Apt: - Bldg: - Key Map: 497D",
        "ID:11-08-26159",
        "CALL:Stab / GSW (B)",
        "ADDR:919 Holbech",
        "MAP:497D");

    doTest("T17",
        "ID#:11-08-26160 - - HEART PROBLEMS - 9402 Abbotshall Ln - Apt: - Bldg: - Key Map: 456D - Cross Streets:ARBOR FIELD LN/STONEFIELD MANO - Box #:3304",
        "ID:11-08-26160",
        "CALL:HEART PROBLEMS",
        "ADDR:9402 Abbotshall Ln",
        "MAP:456D",
        "X:ARBOR FIELD LN/STONEFIELD MANO",
        "BOX:3304");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:cadnoreply@proxy.hcec.com\n" +
        "MSG:ID#:12-06-21170 - 67D02 - 67D2 LG GRASS AND WO - US 90 / SHELDON US 90 RAMP - Apt: - Bldg: - Key Map:\n" +
        "(Con't) 2 of 2\n" +
        "458C - Cross Streets: - Box #:3304(End)",

        "ID:12-06-21170",
        "ADDR:US 90 & SHELDON US 90 RAMP",
        "MAP:458C",
        "CODE:67D02",
        "CALL:67D2 LG GRASS AND WO",
        "BOX:3304");

  }
  
  @Test
  public void testAddrChangeParser() {

    doTest("T1",
        "ID#:11-08-29410 - Address changed to:uvalde/kinsman - Cross Streets: - Key Map:NOT F",
        "ID:11-08-29410",
        "CALL:Address changed to:",
        "ADDR:uvalde & kinsman",
        "MAP:NOT F");

    doTest("T2",
        "ID#:11-08-26067 - Address changed to:620 SHELDON RD - Cross Streets:AVE C/RIDLON - Key Map:498B",
        "ID:11-08-26067",
        "CALL:Address changed to:",
        "ADDR:620 SHELDON RD",
        "X:AVE C/RIDLON",
        "MAP:498B");

    doTest("T3",
        "ID#:11-08-26080 - Address changed to:10710 Greens Crossing Blvd - Cross Streets",
        "CALL:Address changed to:",
        "ID:11-08-26080",
        "ADDR:10710 Greens Crossing Blvd");

  }
  
  @Test
  public void testAcive911A() {

    doTest("T1",
        "[] ID#:12-06-23555 - - 60B1 GAS LEAK/ODOR ( - 11000 E Canal Rd - Apt: - Bldg: - Key Map: 460J - Cross Streets:OAK AVE/HOLLY DR - Box #:1705\n",
        "ID:12-06-23555",
        "ADDR:11000 E Canal Rd",
        "X:OAK AVE/HOLLY DR",
        "MAP:460J",
        "CALL:60B1 GAS LEAK/ODOR (",
        "BOX:1705");

    doTest("T2",
        "[]  ID#:12-06-23555 - Address changed to:1100 E CANAL RD - Cross Streets:OAK AVE/HOLLY DR - Key Map:460J\n",
        "ID:12-06-23555",
        "ADDR:1100 E CANAL RD",
        "X:OAK AVE/HOLLY DR",
        "MAP:460J",
        "CALL:Address changed to:");

    doTest("T3",
        "[]  ID#:12-06-23588 - Address changed to:ORLEANS ST / COTTONTAIL DR - Cross Streets: - Key Map:420W\n",
        "ID:12-06-23588",
        "ADDR:ORLEANS ST & COTTONTAIL DR",
        "MAP:420W",
        "CALL:Address changed to:");

    doTest("T4",
        "[]  ID#:12-06-23588 - Address changed to:630 COTTONTAIL DR - Cross Streets:JOAN OF ARC ST/ORLEANS ST - Key Map:419Z\n",
        "ID:12-06-23588",
        "ADDR:630 COTTONTAIL DR",
        "X:JOAN OF ARC ST/ORLEANS ST",
        "MAP:419Z",
        "CALL:Address changed to:");
    
  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "ID#:12-07-26086 - UNIT:GPE1 - Call Rcvd: 10:35:44 - DISP: 10:47:25 - ER: - OUT: - TO: - AT: - AIR: 10:57:50",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26086 - UNIT:GPE1 - Call Rcvd: 10:35:44 - DISP: 10:47:25 - ER: - OUT: - TO: - AT: - AIR: 10:57:50");

    doTest("T2",
        "ID#:12-07-26106 - UNIT:E11 - DISP: 12:30:22 - ER: - OUT: - AIR: 12:31:28",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26106 - UNIT:E11 - DISP: 12:30:22 - ER: - OUT: - AIR: 12:31:28");

    doTest("T3",
        "ID#:12-07-26109 - UNIT:E31 - Call Rcvd: 12:37:33 - DISP: 12:38:15 - ER: - OUT: - TO: - AT: - AIR: 12:44:01",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26109 - UNIT:E31 - Call Rcvd: 12:37:33 - DISP: 12:38:15 - ER: - OUT: - TO: - AT: - AIR: 12:44:01");

    doTest("T4",
        "ID#:12-07-26309 - UNIT:E31 - Call Rcvd: 22:36:45 - DISP: 22:37:39 - ER: 22:40:01 - OUT: 22:47:50 - TO: - AT: - AIR: 23:05:03",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26309 - UNIT:E31 - Call Rcvd: 22:36:45 - DISP: 22:37:39 - ER: 22:40:01 - OUT: 22:47:50 - TO: - AT: - AIR: 23:05:03");

    doTest("T5",
        "ID#:12-07-26353 - UNIT:SQ31 - Call Rcvd: 06:57:00 - DISP: 06:58:43 - ER: - OUT: 07:06:50 - TO: - AT: - AIR: 07:11:00",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26353 - UNIT:SQ31 - Call Rcvd: 06:57:00 - DISP: 06:58:43 - ER: - OUT: 07:06:50 - TO: - AT: - AIR: 07:11:00");

    doTest("T6",
        "ID#:12-07-26416 - UNIT:E21 - Call Rcvd: 16:40:37 - DISP: 16:41:39 - ER: 16:43:12 - OUT: 16:44:28 - TO: - AT: - AIR: 17:19:35",
        "CALL:RUN REPORT",
        "PLACE:ID#:12-07-26416 - UNIT:E21 - Call Rcvd: 16:40:37 - DISP: 16:41:39 - ER: 16:43:12 - OUT: 16:44:28 - TO: - AT: - AIR: 17:19:35");
    
  }
  
  @Test
  public void testActive911C() {

    doTest("T1",
        "ID#:12-07-26090 - - FIRE - PreAlert - 2409 Foley Rd - Apt: - Bldg: CROSBY FIRE STATION - Key Map: NOT F - Cross Streets:BRIDGEWOOD DR/SUMMIT TRAIL RD - Box #:8004",
        "ID:12-07-26090",
        "ADDR:2409 Foley Rd",
        "PLACE:CROSBY FIRE STATION",
        "X:BRIDGEWOOD DR/SUMMIT TRAIL RD",
        "MAP:NOT F",
        "CALL:FIRE - PreAlert",
        "BOX:8004");

    doTest("T2",
        " ID#:12-07-26090 - Address changed to:123 TEST STREET - Cross Streets:Dead End/Dead End - Key Map:496K",
        "ID:12-07-26090",
        "ADDR:123 TEST STREET",
        "X:Dead End/Dead End",
        "MAP:496K",
        "CALL:Address changed to:");

    doTest("T3",
        " ID#:12-07-26090 - Address changed to:5335 ALDINE BENDER RD - Cross Streets:CROSSWINDS DR/SURLES DR - Key Map:374Z",
        "ID:12-07-26090",
        "ADDR:5335 ALDINE BENDER RD",
        "X:CROSSWINDS DR/SURLES DR",
        "MAP:374Z",
        "CALL:Address changed to:");

    doTest("T4",
        "GPM1 - - MEDICAL - PreAlert - 5335 ALDINE BENDER RD - Apt: - Bldg: TIMBER RID - Key Map:374Z - Cross Streets:CROSSWINDS DR/SURLES DR - Box #:2601",
        "ADDR:5335 ALDINE BENDER RD",
        "PLACE:TIMBER RID",
        "X:CROSSWINDS DR/SURLES DR",
        "MAP:374Z",
        "UNIT:GPM1",
        "CALL:MEDICAL - PreAlert",
        "BOX:2601");

    doTest("T5",
        " ID#:12-07-26090 - Address changed to:123 S DIAMONDHEAD BLVD - Cross Streets:CORAL BAY ST/PORT OCALL ST - Key Map:419C",
        "ID:12-07-26090",
        "ADDR:123 S DIAMONDHEAD BLVD",
        "X:CORAL BAY ST/PORT OCALL ST",
        "MAP:419C",
        "CALL:Address changed to:");

    doTest("T6",
        "ID#:12-07-26090 - - MEDICAL - PreAlert - 123 S DIAMONDHEAD BLVD - Apt: - Bldg: - Key Map: 419C - Cross Streets:CORAL BAY ST/PORT OCALL ST - Box #:8005",
        "ID:12-07-26090",
        "ADDR:123 S DIAMONDHEAD BLVD",
        "X:CORAL BAY ST/PORT OCALL ST",
        "MAP:419C",
        "CALL:MEDICAL - PreAlert",
        "BOX:8005");

    doTest("T7",
        "SQ31 - 31D03 - 31D3 UNCONSCIOUS PAR - 433 Northpark Central Dr - Apt: - Bldg: ZOYTO - Key Map:332Y - Cross Streets:NORTHVIEW PARK DR/WOODHAM DR - Box #:1101",
        "ADDR:433 Northpark Central Dr",
        "PLACE:ZOYTO",
        "X:NORTHVIEW PARK DR/WOODHAM DR",
        "MAP:332Y",
        "UNIT:SQ31",
        "CODE:31D03",
        "CALL:31D3 UNCONSCIOUS PAR",
        "BOX:1101");

    doTest("T8",
        "E11 - 69D06T - 69D6 FIRE IN THE RE - 4723 Cicada Ln - Apt: - Bldg: - Key Map:414G - Cross Streets:BOREAS/CRIEFFE RD - Box #:2506",
        "ADDR:4723 Cicada Ln",
        "X:BOREAS/CRIEFFE RD",
        "MAP:414G",
        "UNIT:E11",
        "CODE:69D06T",
        "CALL:69D6 FIRE IN THE RE",
        "BOX:2506");

    doTest("T9",
        " ID#:12-07-26186 - Address changed to:4715 CICADA LN - Cross Streets:BOREAS/CRIEFFE RD - Key Map:414G",
        "ID:12-07-26186",
        "ADDR:4715 CICADA LN",
        "X:BOREAS/CRIEFFE RD",
        "MAP:414G",
        "CALL:Address changed to:");

    doTest("T10",
        "SQ31 - 06E01 - 6E1 RESPIRATORY - 503 Salma Ct - Apt: - Bldg: - Key Map:372H - Cross Streets:Dead End/DESERT MARIGOLD DR - Box #:1103",
        "ADDR:503 Salma Ct",
        "X:Dead End/DESERT MARIGOLD DR",
        "MAP:372H",
        "UNIT:SQ31",
        "CODE:06E01",
        "CALL:6E1 RESPIRATORY",
        "BOX:1103");

    doTest("T11",
        "SQ31 - - 12A1 SEIZURES - 15516 Martineau St - Apt: - Bldg: - Key Map:373R - Cross Streets:MARVELL DR/GREENBRIAR COLONY D - Box #:1106",
        "ADDR:15516 Martineau St",
        "X:MARVELL DR/GREENBRIAR COLONY D",
        "MAP:373R",
        "UNIT:SQ31",
        "CALL:12A1 SEIZURES",
        "BOX:1106");

    doTest("T12",
        "E11 - 12C01E - 12C1 SEIZURES - 15516 Martineau St - Apt: - Bldg: - Key Map:373R - Cross Streets:MARVELL DR/GREENBRIAR COLONY D - Box #:1106",
        "ADDR:15516 Martineau St",
        "X:MARVELL DR/GREENBRIAR COLONY D",
        "MAP:373R",
        "UNIT:E11",
        "CODE:12C01E",
        "CALL:12C1 SEIZURES",
        "BOX:1106");

    doTest("T13",
        "E11 - 69D01 - 69D1 STRUCTURE FIRE - 12345 Vickery St - Apt: - Bldg: OLESON ELE - Key Map:414G - Cross Streets:CHARRITON DR/ALDINE MAIL RD - Box #:2506",
        "ADDR:12345 Vickery St",
        "PLACE:OLESON ELE",
        "X:CHARRITON DR/ALDINE MAIL RD",
        "MAP:414G",
        "UNIT:E11",
        "CODE:69D01",
        "CALL:69D1 STRUCTURE FIRE",
        "BOX:2506");

    doTest("T14",
        "E31 - 29D02m - 29D2 MOTOR VEHICLE A - 14900 North Fwy - Apt: 203 - Bldg: VALUE PLAC - Key Map:372C - Cross Streets:Dead End/AIRTEX ENTR NB 45 - Box #:1103",
        "ADDR:14900 North Fwy",
        "APT:203",
        "PLACE:VALUE PLAC",
        "X:Dead End/AIRTEX ENTR NB 45",
        "MAP:372C",
        "UNIT:E31",
        "CODE:29D02m",
        "CALL:29D2 MOTOR VEHICLE A",
        "BOX:1103");

    doTest("T15",
        "E11 - - 69D6 FIRE IN THE RE - 823 Bandon Ln - Apt: - Bldg: - Key Map:372H - Cross Streets:PRAIRIE LARKSPUR DR/REMINGTON - Box #:1103",
        "ADDR:823 Bandon Ln",
        "X:PRAIRIE LARKSPUR DR/REMINGTON",
        "MAP:372H",
        "UNIT:E11",
        "CALL:69D6 FIRE IN THE RE",
        "BOX:1103");

    doTest("T16",
        "SQ31 - - 29A1 MOTOR VEHICLE A - Hardy Toll Rd / Rankin Hardy Toll R - Apt: - Bldg: - Key Map:373F - Cross Streets: - Box #:1104",
        "ADDR:Hardy Toll Rd & Rankin Hardy Toll R",
        "MAP:373F",
        "UNIT:SQ31",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:1104");

    doTest("T17",
        " - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Hardy Bw 8 W - Apt: - Bldg: - Key Map:373S - Cross Streets: - Box #:4102",
        "ADDR:N Sam Houston Pkwy E & Hardy Bw 8 W",
        "MAP:373S",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:4102");

    doTest("T18",
        "E11 - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Hardy Bw 8 W - Apt: - Bldg: - Key Map:373S - Cross Streets: - Box #:4102",
        "ADDR:N Sam Houston Pkwy E & Hardy Bw 8 W",
        "MAP:373S",
        "UNIT:E11",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:4102");

    doTest("T19",
        "SQ31 - 29D02n - 29D2 MOTOR VEHICLE A - E Hardy Rd / N Sam Houston Pkwy E - Apt: - Bldg: THE PIT HA - Key Map:373T - Cross Streets: - Box #:1106",
        "ADDR:E Hardy Rd & N Sam Houston Pkwy E",
        "PLACE:THE PIT HA",
        "MAP:373T",
        "UNIT:SQ31",
        "CODE:29D02n",
        "CALL:29D2 MOTOR VEHICLE A",
        "BOX:1106");

    doTest("T20",
        "SQ31 - - BREATHING PROBLEMS - 17630 Wayforest Dr - Apt: 390 - Bldg: AGUSTA - Key Map:373J - Cross Streets:HARVEST TIME LN/RICHCREST DR - Box #:1106",
        "ADDR:17630 Wayforest Dr",
        "APT:390",
        "PLACE:AGUSTA",
        "X:HARVEST TIME LN/RICHCREST DR",
        "MAP:373J",
        "UNIT:SQ31",
        "CALL:BREATHING PROBLEMS",
        "BOX:1106");

    doTest("T21",
        "E11 - 06C01A - 6C1 RESPIRATORY - 17630 Wayforest Dr - Apt: 390 - Bldg: AGUSTA - Key Map:373J - Cross Streets:HARVEST TIME LN/RICHCREST DR - Box #:1106",
        "ADDR:17630 Wayforest Dr",
        "APT:390",
        "PLACE:AGUSTA",
        "X:HARVEST TIME LN/RICHCREST DR",
        "MAP:373J",
        "UNIT:E11",
        "CODE:06C01A",
        "CALL:6C1 RESPIRATORY",
        "BOX:1106");

    doTest("T22",
        "SQ31 - - 29A1 MOTOR VEHICLE A - E Richey Rd / Oil Center Blvd - Apt: - Bldg: - Key Map:333X - Cross Streets: - Box #:1102",
        "ADDR:E Richey Rd & Oil Center Blvd",
        "MAP:333X",
        "UNIT:SQ31",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:1102");

    doTest("T23",
        "SQ31 - - 29A1 MOTOR VEHICLE A - 16600 E Hardy Rd - Apt: - Bldg: - Key Map:373K - Cross Streets:Dead End/RANKIN RD - Box #:1106",
        "ADDR:16600 E Hardy Rd",
        "X:Dead End/RANKIN RD",
        "MAP:373K",
        "UNIT:SQ31",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:1106");

    doTest("T24",
        "E11 - - 69D6 FIRE IN THE RE - 14330 E Hardy Rd - Apt: - Bldg: MOGAS - Key Map:373X - Cross Streets:PINAFORE LN/BUSCHONG - Box #:1107",
        "ADDR:14330 E Hardy Rd",
        "PLACE:MOGAS",
        "X:PINAFORE LN/BUSCHONG",
        "MAP:373X",
        "UNIT:E11",
        "CALL:69D6 FIRE IN THE RE",
        "BOX:1107");

    doTest("T25",
        "E31 - 69D03 - 69D3 COMMERCIAL BUI - 14330 E Hardy Rd - Apt: - Bldg: MOGAS - Key Map:373X - Cross Streets:PINAFORE LN/BUSCHONG - Box #:1107",
        "ADDR:14330 E Hardy Rd",
        "PLACE:MOGAS",
        "X:PINAFORE LN/BUSCHONG",
        "MAP:373X",
        "UNIT:E31",
        "CODE:69D03",
        "CALL:69D3 COMMERCIAL BUI",
        "BOX:1107");

    doTest("T26",
        "SQ31 - 12A02E - 12A2 SEIZURES - 830 Vista Grove Cir - Apt: - Bldg: - Key Map:332Z - Cross Streets:GROVEDALE DR/GROVEDALE DR - Box #:1108",
        "ADDR:830 Vista Grove Cir",
        "X:GROVEDALE DR/GROVEDALE DR",
        "MAP:332Z",
        "UNIT:SQ31",
        "CODE:12A02E",
        "CALL:12A2 SEIZURES",
        "BOX:1108");

    doTest("T27",
        "E11 - - 29A1 MOTOR VEHICLE A - N Sam Houston Pkwy E / Aldine Westf - Apt: - Bldg: - Key Map:373U - Cross Streets: - Box #:1106",
        "ADDR:N Sam Houston Pkwy E & Aldine Westf",
        "MAP:373U",
        "UNIT:E11",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:1106");

    doTest("T28",
        "E31 - - ODOR(STRANGE, UNKNOW - 507 Remington Lodge Ct - Apt: - Bldg: - Key Map:372D - Cross Streets:REMINGTON PARK DR/Dead End - Box #:1103",
        "ADDR:507 Remington Lodge Ct",
        "X:REMINGTON PARK DR/Dead End",
        "MAP:372D",
        "UNIT:E31",
        "CALL:ODOR(STRANGE, UNKNOW",
        "BOX:1103");

    doTest("T29",
        "E11 - 69D09 - 69D9 SHED ON FIRE - 14615 Aldine Westfield Rd - Apt: - Bldg: CHRISTIAN - Key Map:373Z - Cross Streets:BUSCHONG/ALDINE BENDER RD - Box #:1107",
        "ADDR:14615 Aldine Westfield Rd",
        "PLACE:CHRISTIAN",
        "X:BUSCHONG/ALDINE BENDER RD",
        "MAP:373Z",
        "UNIT:E11",
        "CODE:69D09",
        "CALL:69D9 SHED ON FIRE",
        "BOX:1107");

    doTest("T30",
        "SQ31 - 29D02m - 29D2 MOTOR VEHICLE A - 818 Richcrest Dr - Apt: - Bldg: GREENBRIAR - Key Map:373J - Cross Streets:CHISHOLM TRL/WAYFOREST DR - Box #:1106",
        "ADDR:818 Richcrest Dr",
        "PLACE:GREENBRIAR",
        "X:CHISHOLM TRL/WAYFOREST DR",
        "MAP:373J",
        "UNIT:SQ31",
        "CODE:29D02m",
        "CALL:29D2 MOTOR VEHICLE A",
        "BOX:1106");

    doTest("T31",
        "SQ31 - - 29A1 MOTOR VEHICLE A - North Fwy / Airtex - Apt: - Bldg: - Key Map:372C - Cross Streets: - Box #:1103",
        "ADDR:North Fwy & Airtex",
        "MAP:372C",
        "UNIT:SQ31",
        "CALL:29A1 MOTOR VEHICLE A",
        "BOX:1103");

    doTest("T32",
        "E31 - 52C03G - 52C3 ALARMS - 16110 North Fwy - Apt: - Bldg: CARMAX - Key Map:332U - Cross Streets:RICHEY EXIT NB 45/RICHEY ENTR - Box #:1101",
        "ADDR:16110 North Fwy",
        "PLACE:CARMAX",
        "X:RICHEY EXIT NB 45/RICHEY ENTR",
        "MAP:332U",
        "UNIT:E31",
        "CODE:52C03G",
        "CALL:52C3 ALARMS",
        "BOX:1101");

    doTest("T33",
        "E31 - - 53A1 CITIZEN ASSIST - 19423 Remington Prairie Dr - Apt: - Bldg: - Key Map:372G - Cross Streets:REMINGTON GREEN CT/REMINGTON B - Box #:1103",
        "ADDR:19423 Remington Prairie Dr",
        "X:REMINGTON GREEN CT/REMINGTON B",
        "MAP:372G",
        "UNIT:E31",
        "CALL:53A1 CITIZEN ASSIST",
        "BOX:1103");

    doTest("T34",
        "E11 - 69D06 - 69D6 FIRE IN THE RE - 2719 Brea Crest St - Apt: - Bldg: - Key Map:414N - Cross Streets:INNSBURY DR/SHADY LN - Box #:2502",
        "ADDR:2719 Brea Crest St",
        "X:INNSBURY DR/SHADY LN",
        "MAP:414N",
        "UNIT:E11",
        "CODE:69D06",
        "CALL:69D6 FIRE IN THE RE",
        "BOX:2502");

    doTest("T35",
        "E21 - - 52B1 ALARMS - 2700 W W Thorne Blvd - Apt: - Bldg: N HARRIS C - Key Map:333S - Cross Streets:E HARDY RD/OIL CENTER BLVD - Box #:1102",
        "ADDR:2700 W W Thorne Blvd",
        "PLACE:N HARRIS C",
        "X:E HARDY RD/OIL CENTER BLVD",
        "MAP:333S",
        "UNIT:E21",
        "CALL:52B1 ALARMS",
        "BOX:1102");

    doTest("T36",
        "SQ31 - 10D04 - 10D4 CARDIAC - 22226 Queenbury Hills Dr - Apt: - Bldg: - Key Map:332R - Cross Streets:LANCASTER LAKE DR/RED ALDER CI - Box #:1108",
        "ADDR:22226 Queenbury Hills Dr",
        "X:LANCASTER LAKE DR/RED ALDER CI",
        "MAP:332R",
        "UNIT:SQ31",
        "CODE:10D04",
        "CALL:10D4 CARDIAC",
        "BOX:1108");

    doTest("T37",
        "SQ31 - - BREATHING PROBLEMS - 15403 E Vantage Pkwy - Apt: - Bldg: THE WORD C - Key Map:373V - Cross Streets:N SAM HOUSTON PKWY E/WAVERLY D - Box #:1106",
        "ADDR:15403 E Vantage Pkwy",
        "PLACE:THE WORD C",
        "X:N SAM HOUSTON PKWY E/WAVERLY D",
        "MAP:373V",
        "UNIT:SQ31",
        "CALL:BREATHING PROBLEMS",
        "BOX:1106");

    doTest("T38",
        "E11 - 06D02 - 6D2 RESPIRATORY - 15403 E Vantage Pkwy - Apt: - Bldg: THE WORD C - Key Map:373V - Cross Streets:N SAM HOUSTON PKWY E/WAVERLY D - Box #:1106",
        "ADDR:15403 E Vantage Pkwy",
        "PLACE:THE WORD C",
        "X:N SAM HOUSTON PKWY E/WAVERLY D",
        "MAP:373V",
        "UNIT:E11",
        "CODE:06D02",
        "CALL:6D2 RESPIRATORY",
        "BOX:1106");

    doTest("T39",
        "E7 - 67B01 - 67B1 SMALL TRASH FIR - 11025 United St - Apt: - Bldg: - Key Map:414U - Cross Streets:ELL RD/LONE OAK RD - Box #:2505",
        "ADDR:11025 United St",
        "X:ELL RD/LONE OAK RD",
        "MAP:414U",
        "UNIT:E7",
        "CODE:67B01",
        "CALL:67B1 SMALL TRASH FIR",
        "BOX:2505");

  }
  
  @Test
  public void testAtascocitaFire() {

    doTest("T1",
        "ID#:13-02-05942 - UNIT:E19 - Call Rcvd: 18:31:52 - DISP: 18:35:07 - ER: 18:35:11 - OUT: 18:36:57 - TO: - AT: - AIR: 18:50:58",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-02-05942 - UNIT:E19 - Call Rcvd: 18:31:52 - DISP: 18:35:07 - ER: 18:35:11 - OUT: 18:36:57 - TO: - AT: - AIR: 18:50:58");

    doTest("T2",
        "E29 - 29B04U - 29B4 MOTOR VEHICLE A - 8300 E Fm 1960 - Apt: - Bldg: - Key Map:338S - Cross Streets:FAIRWAY ISLAND DR/PINE ECHO DR - Box #:A1901",
        "UNIT:E29",
        "CODE:29B04U",
        "CALL:29B4 MOTOR VEHICLE A",
        "ADDR:8300 E Fm 1960",
        "MAP:338S",
        "X:FAIRWAY ISLAND DR/PINE ECHO DR",
        "BOX:A1901");

    doTest("T3",
        "E29 - - 29A1 MOTOR VEHICLE A - 8300 E Fm 1960 - Apt: - Bldg: - Key Map:338S - Cross Streets:FAIRWAY ISLAND DR/PINE ECHO DR - Box #:A1901",
        "UNIT:E29",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:8300 E Fm 1960",
        "MAP:338S",
        "X:FAIRWAY ISLAND DR/PINE ECHO DR",
        "BOX:A1901");

    doTest("T4",
        "E39 - 29B01 - 29B1 MOTOR VEHICLE A - Will Clayton Pkwy / Tabor Brook Dr - Apt: - Bldg: - Key Map:377C - Cross Streets: - Box #:A1901",
        "UNIT:E39",
        "CODE:29B01",
        "CALL:29B1 MOTOR VEHICLE A",
        "ADDR:Will Clayton Pkwy & Tabor Brook Dr",
        "MAP:377C",
        "BOX:A1901");

    doTest("T5",
        "E39 - 31D02 - 31D2 UNCONSCIOUS PAR - 5806 Ancient Oaks Dr - Apt: - Bldg: - Key Map:337T - Cross Streets:OAK STATION DR/OAK BRIAR DR - Box #:A3901",
        "UNIT:E39",
        "CODE:31D02",
        "CALL:31D2 UNCONSCIOUS PAR",
        "ADDR:5806 Ancient Oaks Dr",
        "MAP:337T",
        "X:OAK STATION DR/OAK BRIAR DR",
        "BOX:A3901");

    doTest("T6",
        "ID#:13-02-05928 - UNIT:D9 - Call Rcvd: 15:27:36 - DISP: 15:31:24 - ER: 15:31:29 - OUT: 15:33:52 - TO: - AT: - AIR: 16:23:03",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-02-05928 - UNIT:D9 - Call Rcvd: 15:27:36 - DISP: 15:31:24 - ER: 15:31:29 - OUT: 15:33:52 - TO: - AT: - AIR: 16:23:03");

    doTest("T7",
        "D9 - - 29A1 MOTOR VEHICLE A - W Lake Houston Pkwy / Kings Park Wa - Apt: - Bldg: - Key Map:337U - Cross Streets: - Box #:A1901",
        "UNIT:D9",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:W Lake Houston Pkwy & Kings Park Wa",
        "MAP:337U",
        "BOX:A1901");

    doTest("T8",
        "ID#:13-02-05909 - UNIT:E39 - Call Rcvd: 12:35:59 - DISP: 12:36:53 - ER: - OUT: 12:47:45 - TO: - AT: - AIR: 12:53:04",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-02-05909 - UNIT:E39 - Call Rcvd: 12:35:59 - DISP: 12:36:53 - ER: - OUT: 12:47:45 - TO: - AT: - AIR: 12:53:04");

    doTest("T9",
        "E39 - - 52B1 ALARMS - 12706 Wolf Creek Ct - Apt: - Bldg: - Key Map:337X - Cross Streets:Dead End/WOLF CREEK TRL - Box #:A3901",
        "UNIT:E39",
        "CALL:52B1 ALARMS",
        "ADDR:12706 Wolf Creek Ct",
        "MAP:337X",
        "X:Dead End/WOLF CREEK TRL",
        "BOX:A3901");

    doTest("T10",
        "ID#:13-02-05823 - UNIT:D29 - Call Rcvd: 18:18:52 - DISP: 18:22:07 - ER: 18:22:07 - OUT: - TO: - AT: - AIR: 18:27:57",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-02-05823 - UNIT:D29 - Call Rcvd: 18:18:52 - DISP: 18:22:07 - ER: 18:22:07 - OUT: - TO: - AT: - AIR: 18:27:57");

  }
  
  @Test
  public void testWestfieldFire() {

    doTest("T1",
        "D25 -29D02p-29D2 MOTOR VEHICLE A-1830 Aldine Mail Rd - Apt: - Bldg:SEFTON STE- Key Map:413H - Cross Streets:CHRISMAN RD/ROBERTCREST ST - Box #:2501",
        "UNIT:D25",
        "CODE:29D02p",
        "CALL:29D2 MOTOR VEHICLE A",
        "ADDR:1830 Aldine Mail Rd",
        "PLACE:SEFTON STE",
        "MAP:413H",
        "X:CHRISMAN RD/ROBERTCREST ST",
        "BOX:2501");

    doTest("T2",
        "ID#:13-05-18501 - UNIT:E7 - Call Rcvd: 10:00:02 - DISP: 10:01:08 - ER: 10:03:19 - OUT: 10:06:07 - TO: - AT: - AIR: 10:13:54",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-05-18501 - UNIT:E7 - Call Rcvd: 10:00:02 - DISP: 10:01:08 - ER: 10:03:19 - OUT: 10:06:07 - TO: - AT: - AIR: 10:13:54");

    doTest("T3",
        "E7 - -CITIZEN ASSIST -3306 Charriton Dr - Apt: - Bldg: - Key Map:414E - Cross Streets:FALL MEADOW LN/FERN MEADOW LN - Box #:2503",
        "UNIT:E7",
        "CALL:CITIZEN ASSIST",
        "ADDR:3306 Charriton Dr",
        "MAP:414E",
        "X:FALL MEADOW LN/FERN MEADOW LN",
        "BOX:2503");

    doTest("T4",
        "E7 - -29A1 MOTOR VEHICLE A-Lauder Rd / John F Kennedy Blvd - Apt: - Bldg:TEXACO - Key Map:414B - Cross Streets: - Box #:2501",
        "UNIT:E7",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:Lauder Rd & John F Kennedy Blvd",
        "PLACE:TEXACO",
        "MAP:414B",
        "BOX:2501");

    doTest("T5",
        "ID#:13-05-18399 - UNIT:E7 - DISP: 17:23:42 - ER: 17:25:22 - OUT: - AIR: 17:27:20",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-05-18399 - UNIT:E7 - DISP: 17:23:42 - ER: 17:25:22 - OUT: - AIR: 17:27:20");

    doTest("T6",
        "E7 - -FIRE ALARM -12959 Aldine Westfield Rd - Apt: - Bldg:WALGREENS - Key Map:413H - Cross Streets:ISOM ST/ALDINE MAIL RD - Box #:2503",
        "UNIT:E7",
        "CALL:FIRE ALARM",
        "ADDR:12959 Aldine Westfield Rd",
        "PLACE:WALGREENS",
        "MAP:413H",
        "X:ISOM ST/ALDINE MAIL RD",
        "BOX:2503");

    doTest("T7",
        "E7 -29D01b-29D1 MOTOR VEHICLE A-3600 Mooney Rd - Apt: - Bldg: - Key Map:414P - Cross Streets:BENTLEY RD/WARDVILLE - Box #:2505",
        "UNIT:E7",
        "CODE:29D01b",
        "CALL:29D1 MOTOR VEHICLE A",
        "ADDR:3600 Mooney Rd",
        "MAP:414P",
        "X:BENTLEY RD/WARDVILLE",
        "BOX:2505");

    doTest("T8",
        "ID#:13-05-18269 - UNIT:E7 - Call Rcvd: 19:52:50 - DISP: 19:55:01 - ER: 19:57:22 - OUT: 19:59:08 - TO: - AT: - AIR: 20:15:25",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-05-18269 - UNIT:E7 - Call Rcvd: 19:52:50 - DISP: 19:55:01 - ER: 19:57:22 - OUT: 19:59:08 - TO: - AT: - AIR: 20:15:25");

    doTest("T9",
        "E7 -53O02 -CITIZEN ASSIST -2439 Lauder Rd - Apt: - Bldg: - Key Map:414A - Cross Streets:ALDINE WESTFIELD RD/GREENRANCH- Box #:2501",
        "UNIT:E7",
        "CODE:53O02",
        "CALL:CITIZEN ASSIST",
        "ADDR:2439 Lauder Rd",
        "MAP:414A",
        "X:ALDINE WESTFIELD RD/GREENRANCH",
        "BOX:2501");

    doTest("T10",
        "ID#:13-05-18159 - UNIT:D25 - Call Rcvd: 08:10:32 - DISP: 08:14:41 - ER: 08:16:38 - OUT: 08:18:20 - TO: - AT: - AIR: 09:01:28",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-05-18159 - UNIT:D25 - Call Rcvd: 08:10:32 - DISP: 08:14:41 - ER: 08:16:38 - OUT: 08:18:20 - TO: - AT: - AIR: 09:01:28");

    doTest("T11",
        "T5 -69D03 -69D3 COMMERCIAL BUI-13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501",
        "UNIT:T5",
        "CODE:69D03",
        "CALL:69D3 COMMERCIAL BUI",
        "ADDR:13639 Aldine Westfield Rd",
        "PLACE:APPLETON",
        "MAP:413D",
        "X:CONNORVALE RD/LAUDER RD",
        "BOX:2501");

    doTest("T12",
        "SQ25 -69D03 -69D3 COMMERCIAL BUI-13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501",
        "UNIT:SQ25",
        "CODE:69D03",
        "CALL:69D3 COMMERCIAL BUI",
        "ADDR:13639 Aldine Westfield Rd",
        "PLACE:APPLETON",
        "MAP:413D",
        "X:CONNORVALE RD/LAUDER RD",
        "BOX:2501");

    doTest("T13",
        "E7 - -FIRE ALARM -13639 Aldine Westfield Rd - Apt: - Bldg:APPLETON - Key Map:413D - Cross Streets:CONNORVALE RD/LAUDER RD - Box #:2501",
        "UNIT:E7",
        "CALL:FIRE ALARM",
        "ADDR:13639 Aldine Westfield Rd",
        "PLACE:APPLETON",
        "MAP:413D",
        "X:CONNORVALE RD/LAUDER RD",
        "BOX:2501");

    doTest("T14",
        "ID#:13-05-18152 - UNIT:E7 - Call Rcvd: 07:20:04 - DISP: 07:24:10 - ER: - OUT: - TO: - AT: - AIR: 07:46:50",
        "CALL:RUN REPORT",
        "PLACE:ID#:13-05-18152 - UNIT:E7 - Call Rcvd: 07:20:04 - DISP: 07:24:10 - ER: - OUT: - TO: - AT: - AIR: 07:46:50");

    doTest("T15",
        "E7 -09E02 -9E2 FULL ARREST -4826 Aldine Mail Rd - Apt:9 - Bldg:ALDINE APT- Key Map:414G - Cross Streets:BOREAS/MACNAUGHTON DR - Box #:2506",
        "UNIT:E7",
        "CODE:09E02",
        "CALL:9E2 FULL ARREST",
        "ADDR:4826 Aldine Mail Rd",
        "APT:9",
        "PLACE:ALDINE APT",
        "MAP:414G",
        "X:BOREAS/MACNAUGHTON DR",
        "BOX:2506");

    doTest("T16",
        "E7 -13C03 -13C3 DIABETIC -10902 United St - Apt: - Bldg: - Key Map:414U - Cross Streets:LONE OAK RD/LITTLECREST RD - Box #:2505",
        "UNIT:E7",
        "CODE:13C03",
        "CALL:13C3 DIABETIC",
        "ADDR:10902 United St",
        "MAP:414U",
        "X:LONE OAK RD/LITTLECREST RD",
        "BOX:2505");

    doTest("T17",
        "E7 -10D01 -10D1 CARDIAC -1918 Isom St - Apt: - Bldg: - Key Map:413M - Cross Streets:ISOM RD/ALDINE WESTFIELD RD - Box #:2501",
        "UNIT:E7",
        "CODE:10D01",
        "CALL:10D1 CARDIAC",
        "ADDR:1918 Isom St",
        "MAP:413M",
        "X:ISOM RD/ALDINE WESTFIELD RD",
        "BOX:2501");

    doTest("T18",
        "E7 -29B01 -29B1 MOTOR VEHICLE A-11730 Vickery St - Apt: - Bldg: - Key Map:414L - Cross Streets:ORANGE GROVE DR/MOUNT HOUSTON - Box #:2505",
        "UNIT:E7",
        "CODE:29B01",
        "CALL:29B1 MOTOR VEHICLE A",
        "ADDR:11730 Vickery St",
        "MAP:414L",
        "X:ORANGE GROVE DR/MOUNT HOUSTON",
        "BOX:2505");

    doTest("T19",
        "E7 - -29A1 MOTOR VEHICLE A-Eastex Fwy / Hopper Entr 59 Sb - Apt: - Bldg: - Key Map:414Q - Cross Streets: - Box #:2505",
        "UNIT:E7",
        "CALL:29A1 MOTOR VEHICLE A",
        "ADDR:Eastex Fwy & Hopper Entr 59 Sb",
        "MADDR:Eastex Fwy & Hopper Entr 59",
        "MAP:414Q",
        "BOX:2505");

    doTest("T20",
        "L8 -29B04 -29B4 MOTOR VEHICLE A-1900 Isom St - Apt: - Bldg: - Key Map:413M - Cross Streets:ISOM RD/ALDINE WESTFIELD RD - Box #:2501",
        "UNIT:L8",
        "CODE:29B04",
        "CALL:29B4 MOTOR VEHICLE A",
        "ADDR:1900 Isom St",
        "MAP:413M",
        "X:ISOM RD/ALDINE WESTFIELD RD",
        "BOX:2501");
   
  }

  public static void main(String[] args) {
    new TXHarrisCountyESD1BParserTest().generateTests("T1");
  }

}