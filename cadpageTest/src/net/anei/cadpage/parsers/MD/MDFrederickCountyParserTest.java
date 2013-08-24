package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDFrederickCountyParser;

import org.junit.Test;

/*
Frederick County, MD
Contact: dalefogle@aol.com
Contact: Dale Fogle <pullersnet@gmail.com>
Contact: Brian Kelch <flamekiller20@gmail.com>
Sender:  www.codemessaging.net,CAD@psb.net
 
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 6801 HARBAUGH RD CSAB:NEXT TO HER HOME ESZ: 626 MAP: 3996A6 Disp: [23]
(CAD) [FredCo] CT: WOODS FIRE 7819-B FRIENDS CREEK RD CEMB ESZ: 627 MAP: 3996F6 Disp: E63,B66,DNR [36]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 4 PAWS PL THUR: @CATOCTIN VETERINARY CLINIC ESZ: 1001 MAP: 4108E9 Disp: E102,TWR6 [37]
(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO: @RT15SB/BOYLE RD ESZ: -1 Disp: E63 [38]
       This was a mutual aid call to Adams Co. Pa at Rt.15 South Bound at the Boyle Rd. overpass
(CAD) [FredCo] CT: HOUSE / ODOR 9152 OLD KILN RD CEMB ESZ: 617 MAP: 4109E4 Disp: E63,E102,A268,TWR6,ET64 [39]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 102 OLD OAK PL THUR ESZ: 1001 MAP: 4222D2 Disp: E102,TWR6 [41]
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / WATERFLOW 100 CREAMERY CT: @EMMITSBURG GLASS CO ESZ: 620 MAP: 3997K9 Disp: E63,TWR6 [42]
(CAD) [FredCo] CT: PERSON FIRE (INSIDE) 16825 S SETON AVE CEMB: @NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB ESZ: 620 MAP: 3997H9 Disp: [34]                    Rmk:"
(FredCo) [CAD] CT: CHEST PAIN  1811 MONOCACY BLVD FRE1: @WAL MART: PHARMACY  ESZ: 215 MAP: 4448J9  Disp: A29,A247,M17

Contact: Mike Ringer <mpr0317@gmail.com>
Sender: rc.360@c-msg.net <From%3Arc.360@c-msg.net>
(CAD) [FredCo] CT: TROUBLE BREATHING 142 E SOUTH ST FRE1 ESZ: 303 MAP: 4566E5 Disp: A38,M31 [85]

Contact: "windyhollowgrowers@hotmail.com" <windyhollowgrowers@hotmail.com>
(FredCo) [CAD] CT: HOUSE / FIRE-VISIBLE CACO: @MA CARRCO: 1594 BAUST CHURCH RD ESZ: 9902 Disp: ET94,
(FredCo) [CAD] CT: HEMORRHAGE CACO: @MA CARRCO: 915 FRANCIS SCOTT KEY HWY ESZ: 9902 Disp: SU9

[FredCo] CT: INJURY FROM VEHICLE ACCIDENT LL(-77:23:59.6013,39:21:53.1520): @I270NB / MONOCACY RIVER ESZ: 327002 MAP: 46

Contact: Bill Green <wbgreen1@gmail.com>
(CAD) [FredCo] CT: HOUSE / SMOKE 238 DEPAUL ST EMMB ESZ: 601 MAP: 3997J8 Disp: E63,ACE232,E102,CCE111,E132,A268,RS6,TWR6,CCLDR5,BAT900,SFT900

Contact: "bubbaclary@yahoo.com" <bubbaclary@yahoo.com>
(CAD) [FredCo] CT: CARDIAC PATIENT 12 AFTON CT BRUN ESZ: 502 MAP: 4683C9 SUBDIV: GALYN MANOR Disp: A199,M20,A209,5FR [93]

Contact: Bill Stearn <wstearn@gmail.com>
Sender: rc.404@c-msg.net,messaging@iamresponding.com
(CAD) [FredCo] CT: TROUBLE BREATHING / default 13862-A OLD NATIONAL PIKE CMTY TIME: 01:39:41 ESZ: 1521 MAP: 4690B2 Disp: CCM19,CCLS1,RE153
(CAD) [FredCo] CT: HOUSE / APPLIANCE FIRE (STRUCTURE PRE-ALERT) / default 6405 SPRING FOREST RD CFR1 TIME: 17:14:24 ESZ: 3302 MAP: 4567F5 SUBDIV: SPRING RIDGE Dis
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 808 E SOUTH ST FRE1 TIME: 03:24:42 ESZ: 308 MAP: 4566G5 Disp: E31,E22,E331,E311,A38,RS3,TR42,TWR1,T1,ET233,ET154,BAT900,SF
(CAD) [FredCo] CT: TROUBLE BREATHING / default 7 S FEDERAL ST NEWM TIME: 12:02:44 ESZ: 1501 MAP: 4568H9 Disp: A159,M17
(CAD) [FredCo] CT: OUTSIDE INVESTIGATION / default 5018 GREEN VALLEY RD CMON TIME: 21:24:52 ESZ: 1503 MAP: 4688G1 Disp: RE153
(CAD) [FredCo] CT: SICK PERSON / default 5850 EAGLEHEAD DR CIJM: @OAKDALE HIGH SCHOOL TIME: 08:52:07 ESZ: 1513 MAP: 4568A7 Disp: A159
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default BELLS LN/BALTIMORE RD CFR4 TIME: 09:58:14 ESZ: 3306 MAP: 4567F7 Disp: A339,RE153,E331
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 1103 VILLAGE GATE DR MTAY: NEXT TOO TIME: 11:20:23 ESZ: 1527 MAP: 4570C10 Disp: RE153,E251,TWR23

Contact: Derek Wildasin <wildasindc@gmail.com>
Sender: rc.393@c-msg.net
(CAD) [!] CT: ASSIST PATIENT - NON-EMERGENCY RESPONSE / default 222 BROADWAY ST FRE1: @WEINBERG HOUSE MAP: 4566D5 Disp: A38,E31

Contact: Bill Stearn <wstearn@gmail.com>
Sender: rc.404@c-msg.net
(CAD) [FredCo] CT: ENGINE TRANSFER / default 14026 GRACEHAM RD CTHU: @STATION 18 MAP: 4222J2 Disp: ET154
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default CMON: @RT80 / KEMPTOWN CHURCH RD MAP: 4689D7 Disp: A259,RE153,ET254

Contact: Joseph Wentz <ccsgt82@gmail.com>
Sender: messaging@iamresponding.com
(JFC 2) CT: BACK PAIN /  801 TOLL HOUSE AVE FRE1: SUITE C-3 MAP: 4566D3  Disp: A29

Contact: Kyle Stull <ktstull@gmail.com>
CT: INJURED PERSON /  160 WILLOWDALE DR FRE2: @BROOKSIDE II APTS: APT M-403 MAP: 4565J3  Disp: A28

Contact: Bill Stearn <wstearn@gmail.com>
Sender: messaging@iamresponding.com
(Company 15) CT: UNKNOWN MEDICAL EMERGENCY / default 12565 BROWLAND DR CMTY MAP: 4689D2  Disp: A158

Contact: John Ruppel <jruppel@emmitsburgems.org>
Sender: rc.415@c-msg.net
Subject:CAD\n[FredCo] CT: TROUBLE BREATHING / default 401 W LINCOLN AVE EMMB: @LINCOLN ON THE PARK APT# 216 MAP: 3997H8 Disp: A268,M30\r\n
Subject:CAD\n[FredCo] CT: VEHICLE ACCIDENT WITH ENTRAPMENT / default ADCO: @MA ADAMCO:RT15SB 1MM MAP: 3998B2 Disp: RS6,A268,ET64,E63\r\n\r

Contact: 4n3yac <4n3yac@gmail.com>
Sender: GCM
[FredCo] CT: INJURED PERSON (SPECIFY NATURE) / default 4925 MARIANNE DR CMTY MAP: 4689D2 Disp: A259,CCM18

Contact: Active911.com
[CAD] [FredCo] CT: STROKE / default 216 THIRD AVE BRUN MAP: 4683A10 Disp: A197,M20\n
[CAD] [FredCo] CT: VEHICLE ACCIDENT / default LL(-77:38:25.0189,39:20:22.5676): @RT340EB / RT17 MAP: 4682H6 Disp: A197,A199,RS19,E51,LCE616\n
[CAD] [FredCo] CT: HEMORRHAGE / default 22 E C ST BRUN MAP: 4682K10 Disp: A197,M20\n
[CAD] [FredCo] CT: INJURED PERSON / default 303 E POTOMAC ST BRUN MAP: 4803A1 Disp: A197\n
Subject:CAD\n[FredCo] CT: STROKE / default ADCO: @MA ADAMCO: 7 SNOWPLOW TRAIL MAP: 3998B2 Disp: A269\r\n\r

Contact: Active911
Agency name: Independent Hose Company
Location: Frederick, MD, United States

CT: DECREASED LEVEL OF CONSCIOUSNESS / default 100 HILL ST FRE3: @HILL STREET SKATE PARK MAP: 4565J5  Disp: A18,M1,RE11\r\n\r\n
CT: TROUBLE BREATHING / default FRE1: @RT15 / ROSEMONT AVE: AT END OF RAMP MAP: 4566B3  Disp: A18,M1,RE11\r\n\r\n
CT: HAZMAT INCIDENT (SPECIFY) / default 4301 OLD NATIONAL PIKE CMID: @MIDDLETOWN SHELL: @HIGHS STORE MAP: 4564G1  Disp: RE74,E122,A78,A129,A18,M31,RE11,SOPS50,HIRT31,BAT900,SFT900,EMS900\r\n\r\n
CT: VEHICLE ACCIDENT  / default FRE1: @RT15SB / RT40 MAP: 4566A4  Disp: A18,A39,RE11,E12,E31,E502\r\n\r\n
CT: VEHICLE ACCIDENT  / default LL(-77:30:13.3095,39:21:58.0321): @RT340WB / RT15 (JEFFERSON) MAP: 4684K2  Disp: A39,A38,RS20,E201,E31,C3-3,C20-2,RE11\r\n\r\n
CT: UNCONSCIOUS PERSON / default 125 FAIRVIEW AVE FRE1 MAP: 4566B3  Disp: A19,M1,1FR,EMS900\r\n\r\n
CT: UNCONSCIOUS DIABETIC / default 1333 MULBERRY CT FRE3 MAP: 4565H4  Disp: A19,M1,1FR,EMS900\r\n\r\n
CT: VEHICLE ACCIDENT  / default FRE3: @RT15SB / RAMP RT15SB TO RT15-340WB MAP: 4566A5  Disp: A18,A39,RE11,E12,E31,E22\r\n\r\n
CT: VEHICLE ACCIDENT WITH ENTRAPMENT / default BEL AIRE LN/KEY PKWY FRE2 MAP: 4565K3  Disp: A18,M1,RE11,E12,E31,EMS900\r\n\r\n
CT: COMMERCIAL FIRE ALARM / AUTOMATIC 148 WILLOWDALE DR FRE2: @WILLOWDALE CROSSING APTS MAP: 4565J3  Disp: RE11\r\n\r\n

Agency name: Brunswick  Volunteer  Fire Co
Location: Brunswick, MD, United States
Contact: Active911
Sender: rc.419@c-msg.net

(CAD) [FredCo] CT: SICK PERSON / default 9 S MARYLAND AVE BRUN MAP: 4682K10 Disp: A197
(CAD) [FredCo] CT: STROKE / default 3306 CARLISLE DR CKNO MAP: 4683H9 Disp: 5FR,A209,WCM1820
(CAD) [FredCo] CT: INJURED PERSON (SPECIFY NATURE) / default 321 E POTOMAC ST BRUN MAP: 4803A1 Disp: A197,M20
(CAD) [FredCo] CT: CHEST PAIN / default 2531 POINT OF ROCKS RD CKNO MAP: 4683G8 Disp: A197,WCM1820
(CAD) [FredCo] CT: TROUBLE BREATHING / default 649-A JEFFERSON PIKE CKNO MAP: 4682G8 Disp: A197,M20
(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 8 DONOVAN CT BRUN MAP: 4683C8 Disp: A197,WCM1820
(CAD) [FredCo] CT: TRUCK TRANSFER / default BOON WACO: @WASHINGTON STATION 6 - 5 SAINT PAUL ST Disp: TR5
(CAD) [FredCo] CT: INJURY FROM VEHICLE ACCIDENT / default LL(-77:38:18.0376,39:21:15.8676): @RT17 / BRENTLAND RD MAP: 4682H4 Disp: A197,E51
(CAD) [FredCo] CT: SPECIFY NATURE / default 405 E F ST BRUN MAP: 4683A10 Disp: E51
(CAD) [FredCo] CT: CARDIAC PATIENT / default 635 CENTRAL AVE BRUN MAP: 4682J9 Disp: A197,WCM1820
(CAD) [FredCo] CT: SERVICE CALL - SPECIFY / default 40 SOUDER RD BRUN: @FRESH & GREENS: @FRESH & GREENS// IFO MAP: 4683A9 Disp: E51
(CAD) [FredCo] CT: SICK PERSON / default 1201 MAPLE TERRACE LN BRUN: @MAPLE TERRACE APTS// APT 403 MAP: 4683A9 Disp: A198
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 308 E POTOMAC ST BRUN: #C003554 * BRUNSWICK WATER TREATMENT MAP: 4803A1 Disp: E51
(CAD) [FredCo] CT: CHEST PAIN / default 1100 PEACH ORCHARD LN BRUN: @BRUNSWICK HOUSE APTS * APT 121 MAP: 4682K9 Disp: A198,M20
(CAD) [FredCo] CT: CHEST PAIN / default 104 W E ST BRUN MAP: 4682K10 Disp: A198,M20,LCA6121,5FR
(CAD) [FredCo] CT: CHEST PAIN / default 104 W E ST BRUN MAP: 4682K10 Disp: A198,M20
(CAD) [FredCo] CT: LARGE NON-DWELLING FIRE / BARN LOCO: @MA LOUDCO: 38546 RICKERT RD MAP: 4803J3 Disp: E51,TR5
(CAD) [FredCo] CT: ENGINE TRANSFER / default JECO: @MA JEFFCO:STATION 4 Disp: E51
(CAD) [FredCo] CT: TROUBLE BREATHING / default 24 W ORNDORFF DR BRUN MAP: 4683A9 Disp: A199,M20
(CAD) [FredCo] CT: INJURED PERSON / default 3829 BURKITTSVILLE RD CKNO MAP: 4682H7 Disp: A198
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: HARPERS FERRY RD/ BACK RD MAP: 4331B3 Disp: A199,RS19
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: RT340 / RT67: RT67/ RT340 Disp: RS19,A199
(CAD) [FredCo] CT: AMBULANCE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: A197
(CAD) [FredCo] CT: ENGINE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: E51
(CAD) [FredCo] CT: SICK PERSON / default 505 W POTOMAC ST BRUN MAP: 4682J10 Disp: A198,E51
(CAD) [FredCo] CT: SICK PERSON / default 505 W POTOMAC ST BRUN MAP: 4682J10 Disp: A198
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 2940 POINT OF ROCKS RD CJEF: @SHEPPARD PRATT JEFFERSON SCHOOL MAP: 4684A7 Disp: E201,TR5
(CAD) [FredCo] CT: TROUBLE BREATHING / default 2721 WOLFE DR CKNO MAP: 4683H9 Disp: A198,M20
(CAD) [FredCo] CT: RESIDENTIAL FIRE ALARM / default WACO: @MA WASHCO: 17900 PLEASANT VALLEY RD MAP: 4331B3 Disp: E51
(CAD) [FredCo] CT: TROUBLE BREATHING / default 229-A JEFFERSON PIKE CKNO MAP: 4682D8 Disp: A198,M20
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: 340EB / KEEP TRYST RD MAP: 4331B3 Disp: A199,RS19
(CAD) [FredCo] CT: ABDOMINAL PAIN / default 517 W B ST BRUN MAP: 4682J10 Disp: A199
(CAD) [FredCo] CT: CARDIAC PATIENT / default WACO: @MA WASHCO 19054 MILLER AVE MAP: 4331B3 Disp: A198
(CAD) [FredCo] CT: FLOODING CONDITION / default 18 E D ST BRUN MAP: 4682K10 Disp: E51
(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 245 KNOXVILLE RD CKNO MAP: 4682D8 Disp: A198,M20
(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 116 W B ST BRUN MAP: 4682K10 Disp: A198,M20,E51
(CAD) [FredCo] CT: AUTOMATIC MEDICAL ALARM / default WACO: @MA WASHCO 19061 MILLER AVE MAP: 4331B3 Disp: A198
(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 8 DONOVAN CT BRUN MAP: 4683C8 Disp: A199,M20
(CAD) [FredCo] CT: PEDESTRIAN STRUCK / default WACO: @MA WASHCO: 820 HOFMASTER RD MAP: 4331B3 Disp: A198,RS19,E51
(CAD) [FredCo] CT: EXPIRED PERSON / default 205 E F ST BRUN MAP: 4683A10 Disp: A198
(CAD) [FredCo] CT: OVERDOSE BLS / default 9 W POTOMAC ST BRUN: APT 2 MAP: 4682K10 Disp: A198
(CAD) [FredCo] CT: SICK PERSON / default 18 W MAIN ST MIDD MAP: 4446C9 Disp: A198
(CAD) [FredCo] CT: INJURED PERSON / default 7417 RIDGE RD BRAD CFR2 MAP: 4564K1 Disp: A198,12FR
(CAD) [FredCo] CT: ENGINE TRANSFER / default 4603 LANDER RD CJEF: @STATION 20 MAP: 4684F3 Disp: RS14,E51
(CAD) [FredCo] CT: AMBULANCE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: A198
(CAD) [FredCo] CT: SICK PERSON / default 116 W B ST BRUN: APT 8 MAP: 4682K10 Disp: A197,LCA6121,5FR
(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC LOCO: @MA LOUDCO: 34 E BROADWAY: MAD HORSE BREWERY MAP: 4803J3 Disp: E51
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE LOCO: @MA LOUDCO: 12800 TAYLORS VALLEY LANE MAP: 4803J3 Disp: E51,ET284,Q14,ET143
(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: RT340/ RT67 MAP: 4331B3 Disp: A197,RS19
(CAD) [FredCo] CT: INJURED PERSON / default WACO: @MA WASHCO: 1326 WEAVERTON RD MAP: 4331B3 Disp: A197
(CAD) [FredCo] CT: UNCONSCIOUS DIABETIC / default 122 FIFTH AVE BRUN MAP: 4683A10 Disp: A197,M20,E51
(CAD) [FredCo] CT: FLOODING CONDITION / default 411 E D ST BRUN MAP: 4683A10 Disp: E51
(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE WACO: @MA WASHCO: 1834 HOFFMASTER RD BOX 11-2 MAP: 4331B3 Disp: E51,T5,TR5,RS19
(CAD) [FredCo] CT: AUTOMATIC MEDICAL ALARM / default 814 TRITAPOE DR CKNO MAP: 4682G10 Disp: A197,E51

***/

public class MDFrederickCountyParserTest extends BaseParserTest {
  
  public MDFrederickCountyParserTest() {
    setParser(new MDFrederickCountyParser(), "FREDERICK COUNTY", "MD");
  }
  
  @Test
  public void testBadMsg() {
    doBadTest("I will be there till about 11 so if u want come on in");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 6801 HARBAUGH RD CSAB:NEXT TO HER HOME ESZ: 626 MAP: 3996A6 Disp: [23]",
        "SRC:FredCo",
        "CALL:HOUSE / FIRE-VISIBLE",
        "ADDR:6801 HARBAUGH RD",
        "CITY:Sabillasville",
        "PLACE:NEXT TO HER HOME",
        "BOX:626",
        "MAP:3996A6");

    doTest("T2",
        "(CAD) [FredCo] CT: WOODS FIRE 7819-B FRIENDS CREEK RD CEMB ESZ: 627 MAP: 3996F6 Disp: E63,B66,DNR [36]",
        "SRC:FredCo",
        "CALL:WOODS FIRE",
        "ADDR:7819-B FRIENDS CREEK RD",
        "MADDR:7819 FRIENDS CREEK RD",
        "CITY:Emmitsburg",
        "BOX:627",
        "MAP:3996F6",
        "UNIT:E63,B66,DNR");

    doTest("T3",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 4 PAWS PL THUR: @CATOCTIN VETERINARY CLINIC ESZ: 1001 MAP: 4108E9 Disp: E102,TWR6 [37]",
        "SRC:FredCo",
        "CALL:COMMERCIAL FIRE ALARM / AUTOMATIC",
        "ADDR:4 PAWS PL",
        "CITY:Thurmont",
        "PLACE:CATOCTIN VETERINARY CLINIC",
        "BOX:1001",
        "MAP:4108E9",
        "UNIT:E102,TWR6");

    doTest("T4",
        "(CAD) [FredCo] CT: OUTSIDE INVESTIGATION @MA ADAM CO: @RT15SB/BOYLE RD ESZ: -1 Disp: E63 [38]",
        "SRC:FredCo",
        "CALL:Mutual Aid: OUTSIDE INVESTIGATION",
        "ADDR:RT15SB & BOYLE RD",
        "MADDR:RT 15 & BOYLE RD",
        "CITY:Adams County",
        "ST:PA",
        "BOX:-1",
        "UNIT:E63");

    doTest("T5",
        "(CAD) [FredCo] CT: HOUSE / ODOR 9152 OLD KILN RD CEMB ESZ: 617 MAP: 4109E4 Disp: E63,E102,A268,TWR6,ET64 [39]",
        "SRC:FredCo",
        "CALL:HOUSE / ODOR",
        "ADDR:9152 OLD KILN RD",
        "CITY:Emmitsburg",
        "BOX:617",
        "MAP:4109E4",
        "UNIT:E63,E102,A268,TWR6,ET64");

    doTest("T6",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 102 OLD OAK PL THUR ESZ: 1001 MAP: 4222D2 Disp: E102,TWR6 [41]",
        "SRC:FredCo",
        "CALL:COMMERCIAL FIRE ALARM / AUTOMATIC",
        "ADDR:102 OLD OAK PL",
        "CITY:Thurmont",
        "BOX:1001",
        "MAP:4222D2",
        "UNIT:E102,TWR6");

    doTest("T7",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / WATERFLOW 100 CREAMERY CT: @EMMITSBURG GLASS CO ESZ: 620 MAP: 3997K9 Disp: E63,TWR6 [42]",
        "SRC:FredCo",
        "CALL:COMMERCIAL FIRE ALARM / WATERFLOW",
        "ADDR:100 CREAMERY CT",
        "PLACE:EMMITSBURG GLASS CO",
        "BOX:620",
        "MAP:3997K9",
        "UNIT:E63,TWR6");

    doTest("T8",
        "(CAD) [FredCo] CT: PERSON FIRE (INSIDE) 16825 S SETON AVE CEMB: @NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB ESZ: 620 MAP: 3997H9 Disp: [34]                    Rmk:\"",
        "SRC:FredCo",
        "CALL:PERSON FIRE (INSIDE)",
        "ADDR:16825 S SETON AVE",
        "CITY:Emmitsburg",
        "PLACE:NATIONAL EMERGENCY TRAINING CENTER:SIMULATION LAB",
        "BOX:620",
        "MAP:3997H9");

    doTest("T9",
        "(FredCo) [CAD] CT: CHEST PAIN  1811 MONOCACY BLVD FRE1: @WAL MART: PHARMACY  ESZ: 215 MAP: 4448J9  Disp: A29,A247,M17",
        "SRC:FredCo",
        "CALL:CHEST PAIN",
        "ADDR:1811 MONOCACY BLVD",
        "CITY:Frederick City",
        "PLACE:WAL MART: PHARMACY",
        "BOX:215",
        "MAP:4448J9",
        "UNIT:A29,A247,M17");

    doTest("T10",
        "(CAD) [FredCo] CT: TROUBLE BREATHING 142 E SOUTH ST FRE1 ESZ: 303 MAP: 4566E5 Disp: A38,M31 [85]",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:142 E SOUTH ST",
        "CITY:Frederick City",
        "BOX:303",
        "MAP:4566E5",
        "UNIT:A38,M31");

    doTest("T11",
        "(FredCo) [CAD] CT: HOUSE / FIRE-VISIBLE CACO: @MA CARRCO: 1594 BAUST CHURCH RD ESZ: 9902 Disp: ET94,",
        "SRC:FredCo",
        "CALL:Mutual Aid: HOUSE / FIRE-VISIBLE CACO:",
        "ADDR:1594 BAUST CHURCH RD",
        "CITY:Carroll County",
        "BOX:9902",
        "UNIT:ET94,");

    doTest("T12",
        "(FredCo) [CAD] CT: HEMORRHAGE CACO: @MA CARRCO: 915 FRANCIS SCOTT KEY HWY ESZ: 9902 Disp: SU9",
        "SRC:FredCo",
        "CALL:Mutual Aid: HEMORRHAGE CACO:",
        "ADDR:915 FRANCIS SCOTT KEY HWY",
        "CITY:Carroll County",
        "BOX:9902",
        "UNIT:SU9");

    doTest("T13",
        "[FredCo] CT: INJURY FROM VEHICLE ACCIDENT LL(-77:23:59.6013,39:21:53.1520): @I270NB / MONOCACY RIVER ESZ: 327002 MAP: 46",
        "SRC:FredCo",
        "CALL:INJURY FROM VEHICLE ACCIDENT",
        "ADDR:LL(-77:23:59.6013,39:21:53.1520)",
        "MADDR:+39.364764,-77.399889",
        "PLACE:I270NB / MONOCACY RIVER",
        "BOX:327002",
        "MAP:46");

    doTest("T14",
        "(CAD) [FredCo] CT: HOUSE / SMOKE 238 DEPAUL ST EMMB ESZ: 601 MAP: 3997J8 Disp: E63,ACE232,E102,CCE111,E132,A268,RS6,TWR6,CCLDR5,BAT900,SFT900",
        "SRC:FredCo",
        "CALL:HOUSE / SMOKE",
        "ADDR:238 DEPAUL ST",
        "CITY:Emmitsburg",
        "BOX:601",
        "MAP:3997J8",
        "UNIT:E63,ACE232,E102,CCE111,E132,A268,RS6,TWR6,CCLDR5,BAT900,SFT900");

    doTest("T15",
        "(CAD) [FredCo] CT: CARDIAC PATIENT 12 AFTON CT BRUN ESZ: 502 MAP: 4683C9 SUBDIV: GALYN MANOR Disp: A199,M20,A209,5FR [93]",
        "SRC:FredCo",
        "CALL:CARDIAC PATIENT",
        "ADDR:12 AFTON CT",
        "CITY:Brunswick",
        "BOX:502",
        "MAP:4683C9 SUBDIV: GALYN MANOR",
        "UNIT:A199,M20,A209,5FR");

    doTest("T16",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 13862-A OLD NATIONAL PIKE CMTY TIME: 01:39:41 ESZ: 1521 MAP: 4690B2 Disp: CCM19,CCLS1,RE153",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:13862-A OLD NATIONAL PIKE",
        "MADDR:13862 OLD NATIONAL PIKE",
        "CITY:Mt Airy",
        "TIME:01:39:41",
        "BOX:1521",
        "MAP:4690B2",
        "UNIT:CCM19,CCLS1,RE153");

    doTest("T17",
        "(CAD) [FredCo] CT: HOUSE / APPLIANCE FIRE (STRUCTURE PRE-ALERT) / default 6405 SPRING FOREST RD CFR1 TIME: 17:14:24 ESZ: 3302 MAP: 4567F5 SUBDIV: SPRING RIDGE Dis",
        "SRC:FredCo",
        "CALL:HOUSE / APPLIANCE FIRE (STRUCTURE PRE-ALERT)",
        "ADDR:6405 SPRING FOREST RD",
        "CITY:Frederick City",
        "TIME:17:14:24",
        "BOX:3302",
        "MAP:4567F5 SUBDIV: SPRING RIDGE");

    doTest("T18",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 808 E SOUTH ST FRE1 TIME: 03:24:42 ESZ: 308 MAP: 4566G5 Disp: E31,E22,E331,E311,A38,RS3,TR42,TWR1,T1,ET233,ET154,BAT900,SF",
        "SRC:FredCo",
        "CALL:HOUSE / FIRE-VISIBLE",
        "ADDR:808 E SOUTH ST",
        "CITY:Frederick City",
        "TIME:03:24:42",
        "BOX:308",
        "MAP:4566G5",
        "UNIT:E31,E22,E331,E311,A38,RS3,TR42,TWR1,T1,ET233,ET154,BAT900,SF");

    doTest("T19",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 7 S FEDERAL ST NEWM TIME: 12:02:44 ESZ: 1501 MAP: 4568H9 Disp: A159,M17",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:7 S FEDERAL ST",
        "CITY:New Market",
        "TIME:12:02:44",
        "BOX:1501",
        "MAP:4568H9",
        "UNIT:A159,M17");

    doTest("T20",
        "(CAD) [FredCo] CT: OUTSIDE INVESTIGATION / default 5018 GREEN VALLEY RD CMON TIME: 21:24:52 ESZ: 1503 MAP: 4688G1 Disp: RE153",
        "SRC:FredCo",
        "CALL:OUTSIDE INVESTIGATION",
        "ADDR:5018 GREEN VALLEY RD",
        "CITY:Monrovia",
        "TIME:21:24:52",
        "BOX:1503",
        "MAP:4688G1",
        "UNIT:RE153");

    doTest("T21",
        "(CAD) [FredCo] CT: SICK PERSON / default 5850 EAGLEHEAD DR CIJM: @OAKDALE HIGH SCHOOL TIME: 08:52:07 ESZ: 1513 MAP: 4568A7 Disp: A159",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:5850 EAGLEHEAD DR",
        "CITY:New Market",
        "PLACE:OAKDALE HIGH SCHOOL",
        "TIME:08:52:07",
        "BOX:1513",
        "MAP:4568A7",
        "UNIT:A159");

    doTest("T22",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default BELLS LN/BALTIMORE RD CFR4 TIME: 09:58:14 ESZ: 3306 MAP: 4567F7 Disp: A339,RE153,E331",
        "SRC:FredCo",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:BELLS LN & BALTIMORE RD",
        "CITY:Frederick City",
        "TIME:09:58:14",
        "BOX:3306",
        "MAP:4567F7",
        "UNIT:A339,RE153,E331");

    doTest("T23",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE 1103 VILLAGE GATE DR MTAY: NEXT TOO TIME: 11:20:23 ESZ: 1527 MAP: 4570C10 Disp: RE153,E251,TWR23",
        "SRC:FredCo",
        "CALL:HOUSE / FIRE-VISIBLE",
        "ADDR:1103 VILLAGE GATE DR",
        "CITY:Mt Airy",
        "PLACE:NEXT TOO",
        "TIME:11:20:23",
        "BOX:1527",
        "MAP:4570C10",
        "UNIT:RE153,E251,TWR23");

    doTest("T24",
        "(CAD) [!] CT: ASSIST PATIENT - NON-EMERGENCY RESPONSE / default 222 BROADWAY ST FRE1: @WEINBERG HOUSE MAP: 4566D5 Disp: A38,E31",
        "SRC:!",
        "CALL:ASSIST PATIENT - NON-EMERGENCY RESPONSE",
        "ADDR:222 BROADWAY ST",
        "CITY:Frederick City",
        "PLACE:WEINBERG HOUSE",
        "MAP:4566D5",
        "UNIT:A38,E31");

    doTest("T25",
        "(CAD) [FredCo] CT: ENGINE TRANSFER / default 14026 GRACEHAM RD CTHU: @STATION 18 MAP: 4222J2 Disp: ET154",
        "SRC:FredCo",
        "CALL:ENGINE TRANSFER",
        "ADDR:14026 GRACEHAM RD",
        "CITY:Thurmont",
        "PLACE:STATION 18",
        "MAP:4222J2",
        "UNIT:ET154");

    doTest("T26",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default CMON: @RT80 / KEMPTOWN CHURCH RD MAP: 4689D7 Disp: A259,RE153,ET254",
        "SRC:FredCo",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:RT80 & KEMPTOWN CHURCH RD",
        "MADDR:RT 80 & KEMPTOWN CHURCH RD",
        "CITY:Monrovia",
        "MAP:4689D7",
        "UNIT:A259,RE153,ET254");

    doTest("T27",
        "(JFC 2) CT: BACK PAIN /  801 TOLL HOUSE AVE FRE1: SUITE C-3 MAP: 4566D3  Disp: A29",
        "SRC:JFC 2",
        "CALL:BACK PAIN /",
        "ADDR:801 TOLL HOUSE AVE",
        "CITY:Frederick City",
        "PLACE:SUITE C-3",
        "MAP:4566D3",
        "UNIT:A29");

    doTest("T28",
        "CT: INJURED PERSON /  160 WILLOWDALE DR FRE2: @BROOKSIDE II APTS: APT M-403 MAP: 4565J3  Disp: A28",
        "CALL:INJURED PERSON /",
        "ADDR:160 WILLOWDALE DR",
        "CITY:Frederick City",
        "PLACE:BROOKSIDE II APTS: APT M-403",
        "MAP:4565J3",
        "UNIT:A28");

    doTest("T29",
        "(Company 15) CT: UNKNOWN MEDICAL EMERGENCY / default 12565 BROWLAND DR CMTY MAP: 4689D2  Disp: A158",
        "SRC:Company 15",
        "CALL:UNKNOWN MEDICAL EMERGENCY",
        "ADDR:12565 BROWLAND DR",
        "CITY:Mt Airy",
        "MAP:4689D2",
        "UNIT:A158");
  }
  
  @Test
  public void testJohnRuppel() {

    doTest("T1",
        "Subject:CAD\n" +
        "[FredCo] CT: TROUBLE BREATHING / default 401 W LINCOLN AVE EMMB: @LINCOLN ON THE PARK APT# 216 MAP: 3997H8 Disp: A268,M30\r\n",

        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:401 W LINCOLN AVE",
        "CITY:Emmitsburg",
        "PLACE:LINCOLN ON THE PARK APT# 216",
        "MAP:3997H8",
        "UNIT:A268,M30");

    doTest("T2",
        "Subject:CAD\n" +
        "[FredCo] CT: VEHICLE ACCIDENT WITH ENTRAPMENT / default ADCO: @MA ADAMCO:RT15SB 1MM MAP: 3998B2 Disp: RS6,A268,ET64,E63\r\n" +
        "\r",

        "SRC:FredCo",
        "CALL:Mutual Aid: VEHICLE ACCIDENT WITH ENTRAPMENT / default ADCO:",
        "ADDR:RT15SB 1MM",
        "MADDR:RT 15 1MM",
        "CITY:Adams County",
        "ST:PA",
        "MAP:3998B2",
        "UNIT:RS6,A268,ET64,E63");
  }
  
  @Test
  public void test4n3yac() {

    doTest("T1",
        "[FredCo] CT: INJURED PERSON (SPECIFY NATURE) / default 4925 MARIANNE DR CMTY MAP: 4689D2 Disp: A259,CCM18",
        "SRC:FredCo",
        "CALL:INJURED PERSON (SPECIFY NATURE)",
        "ADDR:4925 MARIANNE DR",
        "CITY:Mt Airy",
        "MAP:4689D2",
        "UNIT:A259,CCM18");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[CAD] [FredCo] CT: STROKE / default 216 THIRD AVE BRUN MAP: 4683A10 Disp: A197,M20\n",
        "SRC:FredCo",
        "CALL:STROKE",
        "ADDR:216 THIRD AVE",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:A197,M20");

    doTest("T2",
        "[CAD] [FredCo] CT: STROKE / default 216 THIRD AVE BRUN MAP: 4683A10 Disp: A197,M20\n",
        "SRC:FredCo",
        "CALL:STROKE",
        "ADDR:216 THIRD AVE",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:A197,M20");

    doTest("T3",
        "[CAD] [FredCo] CT: VEHICLE ACCIDENT / default LL(-77:38:25.0189,39:20:22.5676): @RT340EB / RT17 MAP: 4682H6 Disp: A197,A199,RS19,E51,LCE616\n",
        "SRC:FredCo",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77:38:25.0189,39:20:22.5676)",
        "MADDR:+39.339602,-77.640283",
        "PLACE:RT340EB / RT17",
        "MAP:4682H6",
        "UNIT:A197,A199,RS19,E51,LCE616");

    doTest("T4",
        "[CAD] [FredCo] CT: VEHICLE ACCIDENT / default LL(-77:38:25.0189,39:20:22.5676): @RT340EB / RT17 MAP: 4682H6 Disp: A197,A199,RS19,E51,LCE616\n",
        "SRC:FredCo",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77:38:25.0189,39:20:22.5676)",
        "MADDR:+39.339602,-77.640283",
        "PLACE:RT340EB / RT17",
        "MAP:4682H6",
        "UNIT:A197,A199,RS19,E51,LCE616");

    doTest("T5",
        "[CAD] [FredCo] CT: VEHICLE ACCIDENT / default LL(-77:38:25.0189,39:20:22.5676): @RT340EB / RT17 MAP: 4682H6 Disp: A197,A199,RS19,E51,LCE616\n",
        "SRC:FredCo",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77:38:25.0189,39:20:22.5676)",
        "MADDR:+39.339602,-77.640283",
        "PLACE:RT340EB / RT17",
        "MAP:4682H6",
        "UNIT:A197,A199,RS19,E51,LCE616");

    doTest("T6",
        "[CAD] [FredCo] CT: HEMORRHAGE / default 22 E C ST BRUN MAP: 4682K10 Disp: A197,M20\n",
        "SRC:FredCo",
        "CALL:HEMORRHAGE",
        "ADDR:22 E C ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A197,M20");

    doTest("T7",
        "[CAD] [FredCo] CT: HEMORRHAGE / default 22 E C ST BRUN MAP: 4682K10 Disp: A197,M20\n",
        "SRC:FredCo",
        "CALL:HEMORRHAGE",
        "ADDR:22 E C ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A197,M20");

    doTest("T8",
        "[CAD] [FredCo] CT: INJURED PERSON / default 303 E POTOMAC ST BRUN MAP: 4803A1 Disp: A197\n",
        "SRC:FredCo",
        "CALL:INJURED PERSON",
        "ADDR:303 E POTOMAC ST",
        "CITY:Brunswick",
        "MAP:4803A1",
        "UNIT:A197");

    doTest("T9",
        "[CAD] [FredCo] CT: INJURED PERSON / default 303 E POTOMAC ST BRUN MAP: 4803A1 Disp: A197\n",
        "SRC:FredCo",
        "CALL:INJURED PERSON",
        "ADDR:303 E POTOMAC ST",
        "CITY:Brunswick",
        "MAP:4803A1",
        "UNIT:A197");

    doTest("T10",
        "Subject:CAD\n[FredCo] CT: STROKE / default ADCO: @MA ADAMCO: 7 SNOWPLOW TRAIL MAP: 3998B2 Disp: A269\r\n\r",
        "SRC:FredCo",
        "CALL:Mutual Aid: STROKE / default ADCO:",
        "ADDR:7 SNOWPLOW TRAIL",
        "CITY:Adams County",
        "ST:PA",
        "MAP:3998B2",
        "UNIT:A269");


  }
  
  @Test
  public void testActive911B() {

    doTest("T1",
        "CT: DECREASED LEVEL OF CONSCIOUSNESS / default 100 HILL ST FRE3: @HILL STREET SKATE PARK MAP: 4565J5  Disp: A18,M1,RE11\r\n\r\n",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "ADDR:100 HILL ST",
        "CITY:Frederick City",
        "PLACE:HILL STREET SKATE PARK",
        "MAP:4565J5",
        "UNIT:A18,M1,RE11");

    doTest("T2",
        "CT: TROUBLE BREATHING / default FRE1: @RT15 / ROSEMONT AVE: AT END OF RAMP MAP: 4566B3  Disp: A18,M1,RE11\r\n\r\n",
        "CALL:TROUBLE BREATHING",
        "ADDR:RT15 & ROSEMONT AVE",
        "MADDR:RT 15 & ROSEMONT AVE",
        "CITY:Frederick City",
        "PLACE:END OF RAMP",
        "MAP:4566B3",
        "UNIT:A18,M1,RE11");

    doTest("T3",
        "CT: HAZMAT INCIDENT (SPECIFY) / default 4301 OLD NATIONAL PIKE CMID: @MIDDLETOWN SHELL: @HIGHS STORE MAP: 4564G1  Disp: RE74,E122,A78,A129,A18,M31,RE11,SOPS50,HIRT31,BAT900,SFT900,EMS900\r\n" +
        "\r\n",

        "CALL:HAZMAT INCIDENT (SPECIFY)",
        "ADDR:4301 OLD NATIONAL PIKE",
        "CITY:Middletown",
        "PLACE:MIDDLETOWN SHELL: @HIGHS STORE",
        "MAP:4564G1",
        "UNIT:RE74,E122,A78,A129,A18,M31,RE11,SOPS50,HIRT31,BAT900,SFT900,EMS900");

    doTest("T4",
        "CT: VEHICLE ACCIDENT  / default FRE1: @RT15SB / RT40 MAP: 4566A4  Disp: A18,A39,RE11,E12,E31,E502\r\n\r\n",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:RT15SB & RT40",
        "MADDR:RT 15 & RT 40",
        "CITY:Frederick City",
        "MAP:4566A4",
        "UNIT:A18,A39,RE11,E12,E31,E502");

    doTest("T5",
        "CT: VEHICLE ACCIDENT  / default LL(-77:30:13.3095,39:21:58.0321): @RT340WB / RT15 (JEFFERSON) MAP: 4684K2  Disp: A39,A38,RS20,E201,E31,C3-3,C20-2,RE11\r\n" +
        "\r\n",

        "CALL:VEHICLE ACCIDENT",
        "ADDR:LL(-77:30:13.3095,39:21:58.0321)",
        "MADDR:+39.366120,-77.503697",
        "PLACE:RT340WB / RT15 (JEFFERSON)",
        "MAP:4684K2",
        "UNIT:A39,A38,RS20,E201,E31,C3-3,C20-2,RE11");

    doTest("T6",
        "CT: UNCONSCIOUS PERSON / default 125 FAIRVIEW AVE FRE1 MAP: 4566B3  Disp: A19,M1,1FR,EMS900\r\n\r\n",
        "CALL:UNCONSCIOUS PERSON",
        "ADDR:125 FAIRVIEW AVE",
        "CITY:Frederick City",
        "MAP:4566B3",
        "UNIT:A19,M1,1FR,EMS900");

    doTest("T7",
        "CT: UNCONSCIOUS DIABETIC / default 1333 MULBERRY CT FRE3 MAP: 4565H4  Disp: A19,M1,1FR,EMS900\r\n\r\n",
        "CALL:UNCONSCIOUS DIABETIC",
        "ADDR:1333 MULBERRY CT",
        "CITY:Frederick City",
        "MAP:4565H4",
        "UNIT:A19,M1,1FR,EMS900");

    doTest("T8",
        "CT: VEHICLE ACCIDENT  / default FRE3: @RT15SB / RAMP RT15SB TO RT15-340WB MAP: 4566A5  Disp: A18,A39,RE11,E12,E31,E22\r\n\r\n",
        "CALL:VEHICLE ACCIDENT",
        "ADDR:RT15SB",
        "MADDR:RT 15",
        "CITY:Frederick City",
        "PLACE:/ RAMP RT15SB TO RT15-340WB",
        "MAP:4566A5",
        "UNIT:A18,A39,RE11,E12,E31,E22");

    doTest("T9",
        "CT: VEHICLE ACCIDENT WITH ENTRAPMENT / default BEL AIRE LN/KEY PKWY FRE2 MAP: 4565K3  Disp: A18,M1,RE11,E12,E31,EMS900\r\n\r\n",
        "CALL:VEHICLE ACCIDENT WITH ENTRAPMENT",
        "ADDR:BEL AIRE LN & KEY PKWY",
        "CITY:Frederick City",
        "MAP:4565K3",
        "UNIT:A18,M1,RE11,E12,E31,EMS900");

    doTest("T10",
        "CT: COMMERCIAL FIRE ALARM / AUTOMATIC 148 WILLOWDALE DR FRE2: @WILLOWDALE CROSSING APTS MAP: 4565J3  Disp: RE11\r\n\r\n",
        "CALL:COMMERCIAL FIRE ALARM / AUTOMATIC",
        "ADDR:148 WILLOWDALE DR",
        "CITY:Frederick City",
        "PLACE:WILLOWDALE CROSSING APTS",
        "MAP:4565J3",
        "UNIT:RE11");

  }
  
  @Test
  public void testBrunswickVolunteerFire() {

    doTest("T1",
        "(CAD) [FredCo] CT: SICK PERSON / default 9 S MARYLAND AVE BRUN MAP: 4682K10 Disp: A197",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:9 S MARYLAND AVE",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A197");

    doTest("T2",
        "(CAD) [FredCo] CT: STROKE / default 3306 CARLISLE DR CKNO MAP: 4683H9 Disp: 5FR,A209,WCM1820",
        "SRC:FredCo",
        "CALL:STROKE",
        "ADDR:3306 CARLISLE DR",
        "PLACE:CKNO",
        "MAP:4683H9",
        "UNIT:5FR,A209,WCM1820");

    doTest("T3",
        "(CAD) [FredCo] CT: INJURED PERSON (SPECIFY NATURE) / default 321 E POTOMAC ST BRUN MAP: 4803A1 Disp: A197,M20",
        "SRC:FredCo",
        "CALL:INJURED PERSON (SPECIFY NATURE)",
        "ADDR:321 E POTOMAC ST",
        "CITY:Brunswick",
        "MAP:4803A1",
        "UNIT:A197,M20");

    doTest("T4",
        "(CAD) [FredCo] CT: CHEST PAIN / default 2531 POINT OF ROCKS RD CKNO MAP: 4683G8 Disp: A197,WCM1820",
        "SRC:FredCo",
        "CALL:CHEST PAIN",
        "ADDR:2531 POINT OF ROCKS RD",
        "PLACE:CKNO",
        "MAP:4683G8",
        "UNIT:A197,WCM1820");

    doTest("T5",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 649-A JEFFERSON PIKE CKNO MAP: 4682G8 Disp: A197,M20",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:649-A JEFFERSON PIKE",
        "MADDR:649 JEFFERSON PIKE",
        "PLACE:CKNO",
        "MAP:4682G8",
        "UNIT:A197,M20");

    doTest("T6",
        "(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 8 DONOVAN CT BRUN MAP: 4683C8 Disp: A197,WCM1820",
        "SRC:FredCo",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "ADDR:8 DONOVAN CT",
        "CITY:Brunswick",
        "MAP:4683C8",
        "UNIT:A197,WCM1820");

    doTest("T7",
        "(CAD) [FredCo] CT: TRUCK TRANSFER / default BOON WACO: @WASHINGTON STATION 6 - 5 SAINT PAUL ST Disp: TR5",
        "SRC:FredCo",
        "CALL:TRUCK TRANSFER",
        "ADDR:BOON WACO",
        "PLACE:WASHINGTON STATION 6 - 5 SAINT PAUL ST",
        "UNIT:TR5");

    doTest("T8",
        "(CAD) [FredCo] CT: INJURY FROM VEHICLE ACCIDENT / default LL(-77:38:18.0376,39:21:15.8676): @RT17 / BRENTLAND RD MAP: 4682H4 Disp: A197,E51",
        "SRC:FredCo",
        "CALL:INJURY FROM VEHICLE ACCIDENT",
        "ADDR:LL(-77:38:18.0376,39:21:15.8676)",
        "MADDR:+39.354408,-77.638344",
        "PLACE:RT17 / BRENTLAND RD",
        "MAP:4682H4",
        "UNIT:A197,E51");

    doTest("T9",
        "(CAD) [FredCo] CT: SPECIFY NATURE / default 405 E F ST BRUN MAP: 4683A10 Disp: E51",
        "SRC:FredCo",
        "CALL:SPECIFY NATURE",
        "ADDR:405 E F ST",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:E51");

    doTest("T10",
        "(CAD) [FredCo] CT: CARDIAC PATIENT / default 635 CENTRAL AVE BRUN MAP: 4682J9 Disp: A197,WCM1820",
        "SRC:FredCo",
        "CALL:CARDIAC PATIENT",
        "ADDR:635 CENTRAL AVE",
        "CITY:Brunswick",
        "MAP:4682J9",
        "UNIT:A197,WCM1820");

    doTest("T11",
        "(CAD) [FredCo] CT: SERVICE CALL - SPECIFY / default 40 SOUDER RD BRUN: @FRESH & GREENS: @FRESH & GREENS// IFO MAP: 4683A9 Disp: E51",
        "SRC:FredCo",
        "CALL:SERVICE CALL - SPECIFY",
        "ADDR:40 SOUDER RD",
        "CITY:Brunswick",
        "PLACE:FRESH & GREENS: @FRESH & GREENS// IFO",
        "MAP:4683A9",
        "UNIT:E51");

    doTest("T12",
        "(CAD) [FredCo] CT: SICK PERSON / default 1201 MAPLE TERRACE LN BRUN: @MAPLE TERRACE APTS// APT 403 MAP: 4683A9 Disp: A198",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:1201 MAPLE TERRACE LN",
        "CITY:Brunswick",
        "PLACE:MAPLE TERRACE APTS// APT 403",
        "MAP:4683A9",
        "UNIT:A198");

    doTest("T13",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 308 E POTOMAC ST BRUN: #C003554 * BRUNSWICK WATER TREATMENT MAP: 4803A1 Disp: E51",
        "SRC:FredCo",
        "CALL:COMMERCIAL FIRE ALARM / AUTOMATIC",
        "ADDR:308 E POTOMAC ST",
        "CITY:Brunswick",
        "PLACE:#C003554 * BRUNSWICK WATER TREATMENT",
        "MAP:4803A1",
        "UNIT:E51");

    doTest("T14",
        "(CAD) [FredCo] CT: CHEST PAIN / default 1100 PEACH ORCHARD LN BRUN: @BRUNSWICK HOUSE APTS * APT 121 MAP: 4682K9 Disp: A198,M20",
        "SRC:FredCo",
        "CALL:CHEST PAIN",
        "ADDR:1100 PEACH ORCHARD LN",
        "CITY:Brunswick",
        "PLACE:BRUNSWICK HOUSE APTS * APT 121",
        "MAP:4682K9",
        "UNIT:A198,M20");

    doTest("T15",
        "(CAD) [FredCo] CT: CHEST PAIN / default 104 W E ST BRUN MAP: 4682K10 Disp: A198,M20,LCA6121,5FR",
        "SRC:FredCo",
        "CALL:CHEST PAIN",
        "ADDR:104 W E ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A198,M20,LCA6121,5FR");

    doTest("T16",
        "(CAD) [FredCo] CT: CHEST PAIN / default 104 W E ST BRUN MAP: 4682K10 Disp: A198,M20",
        "SRC:FredCo",
        "CALL:CHEST PAIN",
        "ADDR:104 W E ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A198,M20");

    doTest("T17",
        "(CAD) [FredCo] CT: LARGE NON-DWELLING FIRE / BARN LOCO: @MA LOUDCO: 38546 RICKERT RD MAP: 4803J3 Disp: E51,TR5",
        "SRC:FredCo",
        "CALL:Mutual Aid: LARGE NON-DWELLING FIRE / BARN LOCO:",
        "ADDR:38546 RICKERT RD",
        "CITY:Loudoun County",
        "ST:VA",
        "MAP:4803J3",
        "UNIT:E51,TR5");

    doTest("T18",
        "(CAD) [FredCo] CT: ENGINE TRANSFER / default JECO: @MA JEFFCO:STATION 4 Disp: E51",
        "SRC:FredCo",
        "CALL:Mutual Aid: ENGINE TRANSFER / default JECO:",
        "ADDR:STATION 4",
        "CITY:Jefferson County",
        "ST:WV",
        "UNIT:E51");

    doTest("T19",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 24 W ORNDORFF DR BRUN MAP: 4683A9 Disp: A199,M20",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:24 W ORNDORFF DR",
        "CITY:Brunswick",
        "MAP:4683A9",
        "UNIT:A199,M20");

    doTest("T20",
        "(CAD) [FredCo] CT: INJURED PERSON / default 3829 BURKITTSVILLE RD CKNO MAP: 4682H7 Disp: A198",
        "SRC:FredCo",
        "CALL:INJURED PERSON",
        "ADDR:3829 BURKITTSVILLE RD",
        "PLACE:CKNO",
        "MAP:4682H7",
        "UNIT:A198");

    doTest("T21",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: HARPERS FERRY RD/ BACK RD MAP: 4331B3 Disp: A199,RS19",
        "SRC:FredCo",
        "CALL:Mutual Aid: VEHICLE ACCIDENT / default WACO:",
        "ADDR:HARPERS FERRY RD & BACK RD",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:A199,RS19");

    doTest("T22",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: RT340 / RT67: RT67/ RT340 Disp: RS19,A199",
        "SRC:FredCo",
        "CALL:Mutual Aid: VEHICLE ACCIDENT / default WACO:",
        "ADDR:RT340 & RT67: RT67 & RT340",
        "MADDR:RT 340 & RT 67: RT 67 & RT 340",
        "CITY:Washington County",
        "ST:MD",
        "UNIT:RS19,A199");

    doTest("T23",
        "(CAD) [FredCo] CT: AMBULANCE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: A197",
        "SRC:FredCo",
        "CALL:AMBULANCE TRANSFER",
        "ADDR:13 S CHURCH ST",
        "CITY:Middletown",
        "PLACE:STATION 7",
        "MAP:4446C10",
        "UNIT:A197");

    doTest("T24",
        "(CAD) [FredCo] CT: ENGINE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: E51",
        "SRC:FredCo",
        "CALL:ENGINE TRANSFER",
        "ADDR:13 S CHURCH ST",
        "CITY:Middletown",
        "PLACE:STATION 7",
        "MAP:4446C10",
        "UNIT:E51");

    doTest("T25",
        "(CAD) [FredCo] CT: SICK PERSON / default 505 W POTOMAC ST BRUN MAP: 4682J10 Disp: A198,E51",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:505 W POTOMAC ST",
        "CITY:Brunswick",
        "MAP:4682J10",
        "UNIT:A198,E51");

    doTest("T26",
        "(CAD) [FredCo] CT: SICK PERSON / default 505 W POTOMAC ST BRUN MAP: 4682J10 Disp: A198",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:505 W POTOMAC ST",
        "CITY:Brunswick",
        "MAP:4682J10",
        "UNIT:A198");

    doTest("T27",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC 2940 POINT OF ROCKS RD CJEF: @SHEPPARD PRATT JEFFERSON SCHOOL MAP: 4684A7 Disp: E201,TR5",
        "SRC:FredCo",
        "CALL:COMMERCIAL FIRE ALARM / AUTOMATIC",
        "ADDR:2940 POINT OF ROCKS RD",
        "CITY:Jefferson",
        "PLACE:SHEPPARD PRATT JEFFERSON SCHOOL",
        "MAP:4684A7",
        "UNIT:E201,TR5");

    doTest("T28",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 2721 WOLFE DR CKNO MAP: 4683H9 Disp: A198,M20",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:2721 WOLFE DR",
        "PLACE:CKNO",
        "MAP:4683H9",
        "UNIT:A198,M20");

    doTest("T29",
        "(CAD) [FredCo] CT: RESIDENTIAL FIRE ALARM / default WACO: @MA WASHCO: 17900 PLEASANT VALLEY RD MAP: 4331B3 Disp: E51",
        "SRC:FredCo",
        "CALL:Mutual Aid: RESIDENTIAL FIRE ALARM / default WACO:",
        "ADDR:17900 PLEASANT VALLEY RD",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:E51");

    doTest("T30",
        "(CAD) [FredCo] CT: TROUBLE BREATHING / default 229-A JEFFERSON PIKE CKNO MAP: 4682D8 Disp: A198,M20",
        "SRC:FredCo",
        "CALL:TROUBLE BREATHING",
        "ADDR:229-A JEFFERSON PIKE",
        "MADDR:229 JEFFERSON PIKE",
        "PLACE:CKNO",
        "MAP:4682D8",
        "UNIT:A198,M20");

    doTest("T31",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: 340EB / KEEP TRYST RD MAP: 4331B3 Disp: A199,RS19",
        "SRC:FredCo",
        "CALL:Mutual Aid: VEHICLE ACCIDENT / default WACO:",
        "ADDR:340EB & KEEP TRYST RD",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:A199,RS19");

    doTest("T32",
        "(CAD) [FredCo] CT: ABDOMINAL PAIN / default 517 W B ST BRUN MAP: 4682J10 Disp: A199",
        "SRC:FredCo",
        "CALL:ABDOMINAL PAIN",
        "ADDR:517 W B ST",
        "CITY:Brunswick",
        "MAP:4682J10",
        "UNIT:A199");

    doTest("T33",
        "(CAD) [FredCo] CT: CARDIAC PATIENT / default WACO: @MA WASHCO 19054 MILLER AVE MAP: 4331B3 Disp: A198",
        "SRC:FredCo",
        "CALL:Mutual Aid: CARDIAC PATIENT / default WACO:",
        "CITY:WASHCO 19054 MILLER AVE",
        "MAP:4331B3",
        "UNIT:A198");

    doTest("T34",
        "(CAD) [FredCo] CT: FLOODING CONDITION / default 18 E D ST BRUN MAP: 4682K10 Disp: E51",
        "SRC:FredCo",
        "CALL:FLOODING CONDITION",
        "ADDR:18 E D ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:E51");

    doTest("T35",
        "(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 245 KNOXVILLE RD CKNO MAP: 4682D8 Disp: A198,M20",
        "SRC:FredCo",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "ADDR:245 KNOXVILLE RD",
        "PLACE:CKNO",
        "MAP:4682D8",
        "UNIT:A198,M20");

    doTest("T36",
        "(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 116 W B ST BRUN MAP: 4682K10 Disp: A198,M20,E51",
        "SRC:FredCo",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "ADDR:116 W B ST",
        "CITY:Brunswick",
        "MAP:4682K10",
        "UNIT:A198,M20,E51");

    doTest("T37",
        "(CAD) [FredCo] CT: AUTOMATIC MEDICAL ALARM / default WACO: @MA WASHCO 19061 MILLER AVE MAP: 4331B3 Disp: A198",
        "SRC:FredCo",
        "CALL:Mutual Aid: AUTOMATIC MEDICAL ALARM / default WACO:",
        "CITY:WASHCO 19061 MILLER AVE",
        "MAP:4331B3",
        "UNIT:A198");

    doTest("T38",
        "(CAD) [FredCo] CT: DECREASED LEVEL OF CONSCIOUSNESS / default 8 DONOVAN CT BRUN MAP: 4683C8 Disp: A199,M20",
        "SRC:FredCo",
        "CALL:DECREASED LEVEL OF CONSCIOUSNESS",
        "ADDR:8 DONOVAN CT",
        "CITY:Brunswick",
        "MAP:4683C8",
        "UNIT:A199,M20");

    doTest("T39",
        "(CAD) [FredCo] CT: PEDESTRIAN STRUCK / default WACO: @MA WASHCO: 820 HOFMASTER RD MAP: 4331B3 Disp: A198,RS19,E51",
        "SRC:FredCo",
        "CALL:Mutual Aid: PEDESTRIAN STRUCK / default WACO:",
        "ADDR:820 HOFMASTER RD",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:A198,RS19,E51");

    doTest("T40",
        "(CAD) [FredCo] CT: EXPIRED PERSON / default 205 E F ST BRUN MAP: 4683A10 Disp: A198",
        "SRC:FredCo",
        "CALL:EXPIRED PERSON",
        "ADDR:205 E F ST",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:A198");

    doTest("T41",
        "(CAD) [FredCo] CT: OVERDOSE BLS / default 9 W POTOMAC ST BRUN: APT 2 MAP: 4682K10 Disp: A198",
        "SRC:FredCo",
        "CALL:OVERDOSE BLS",
        "ADDR:9 W POTOMAC ST",
        "CITY:Brunswick",
        "PLACE:APT 2",
        "MAP:4682K10",
        "UNIT:A198");

    doTest("T42",
        "(CAD) [FredCo] CT: SICK PERSON / default 18 W MAIN ST MIDD MAP: 4446C9 Disp: A198",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:18 W MAIN ST",
        "CITY:Middletown",
        "MAP:4446C9",
        "UNIT:A198");

    doTest("T43",
        "(CAD) [FredCo] CT: INJURED PERSON / default 7417 RIDGE RD BRAD CFR2 MAP: 4564K1 Disp: A198,12FR",
        "SRC:FredCo",
        "CALL:INJURED PERSON",
        "ADDR:7417 RIDGE RD",
        "CITY:Braddock Heights",
        "MAP:4564K1",
        "UNIT:A198,12FR");

    doTest("T44",
        "(CAD) [FredCo] CT: ENGINE TRANSFER / default 4603 LANDER RD CJEF: @STATION 20 MAP: 4684F3 Disp: RS14,E51",
        "SRC:FredCo",
        "CALL:ENGINE TRANSFER",
        "ADDR:4603 LANDER RD",
        "CITY:Jefferson",
        "PLACE:STATION 20",
        "MAP:4684F3",
        "UNIT:RS14,E51");

    doTest("T45",
        "(CAD) [FredCo] CT: AMBULANCE TRANSFER / default 13 S CHURCH ST MIDD: @STATION 7 MAP: 4446C10 Disp: A198",
        "SRC:FredCo",
        "CALL:AMBULANCE TRANSFER",
        "ADDR:13 S CHURCH ST",
        "CITY:Middletown",
        "PLACE:STATION 7",
        "MAP:4446C10",
        "UNIT:A198");

    doTest("T46",
        "(CAD) [FredCo] CT: SICK PERSON / default 116 W B ST BRUN: APT 8 MAP: 4682K10 Disp: A197,LCA6121,5FR",
        "SRC:FredCo",
        "CALL:SICK PERSON",
        "ADDR:116 W B ST",
        "CITY:Brunswick",
        "PLACE:APT 8",
        "MAP:4682K10",
        "UNIT:A197,LCA6121,5FR");

    doTest("T47",
        "(CAD) [FredCo] CT: COMMERCIAL FIRE ALARM / AUTOMATIC LOCO: @MA LOUDCO: 34 E BROADWAY: MAD HORSE BREWERY MAP: 4803J3 Disp: E51",
        "SRC:FredCo",
        "CALL:Mutual Aid: COMMERCIAL FIRE ALARM / AUTOMATIC LOCO:",
        "ADDR:34 E BROADWAY: MAD HORSE BREWERY",
        "CITY:Loudoun County",
        "ST:VA",
        "MAP:4803J3",
        "UNIT:E51");

    doTest("T48",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE LOCO: @MA LOUDCO: 12800 TAYLORS VALLEY LANE MAP: 4803J3 Disp: E51,ET284,Q14,ET143",
        "SRC:FredCo",
        "CALL:Mutual Aid: HOUSE / FIRE-VISIBLE LOCO:",
        "ADDR:12800 TAYLORS VALLEY LANE",
        "CITY:Loudoun County",
        "ST:VA",
        "MAP:4803J3",
        "UNIT:E51,ET284,Q14,ET143");

    doTest("T49",
        "(CAD) [FredCo] CT: VEHICLE ACCIDENT / default WACO: @MA WASHCO: RT340/ RT67 MAP: 4331B3 Disp: A197,RS19",
        "SRC:FredCo",
        "CALL:Mutual Aid: VEHICLE ACCIDENT / default WACO:",
        "ADDR:RT340 & RT67",
        "MADDR:RT 340 & RT 67",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:A197,RS19");

    doTest("T50",
        "(CAD) [FredCo] CT: INJURED PERSON / default WACO: @MA WASHCO: 1326 WEAVERTON RD MAP: 4331B3 Disp: A197",
        "SRC:FredCo",
        "CALL:Mutual Aid: INJURED PERSON / default WACO:",
        "ADDR:1326 WEAVERTON RD",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:A197");

    doTest("T51",
        "(CAD) [FredCo] CT: UNCONSCIOUS DIABETIC / default 122 FIFTH AVE BRUN MAP: 4683A10 Disp: A197,M20,E51",
        "SRC:FredCo",
        "CALL:UNCONSCIOUS DIABETIC",
        "ADDR:122 FIFTH AVE",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:A197,M20,E51");

    doTest("T52",
        "(CAD) [FredCo] CT: FLOODING CONDITION / default 411 E D ST BRUN MAP: 4683A10 Disp: E51",
        "SRC:FredCo",
        "CALL:FLOODING CONDITION",
        "ADDR:411 E D ST",
        "CITY:Brunswick",
        "MAP:4683A10",
        "UNIT:E51");

    doTest("T53",
        "(CAD) [FredCo] CT: HOUSE / FIRE-VISIBLE WACO: @MA WASHCO: 1834 HOFFMASTER RD BOX 11-2 MAP: 4331B3 Disp: E51,T5,TR5,RS19",
        "SRC:FredCo",
        "CALL:Mutual Aid: HOUSE / FIRE-VISIBLE WACO:",
        "ADDR:1834 HOFFMASTER RD BOX 11-2",
        "CITY:Washington County",
        "ST:MD",
        "MAP:4331B3",
        "UNIT:E51,T5,TR5,RS19");

    doTest("T54",
        "(CAD) [FredCo] CT: AUTOMATIC MEDICAL ALARM / default 814 TRITAPOE DR CKNO MAP: 4682G10 Disp: A197,E51",
        "SRC:FredCo",
        "CALL:AUTOMATIC MEDICAL ALARM",
        "ADDR:814 TRITAPOE DR",
        "PLACE:CKNO",
        "MAP:4682G10",
        "UNIT:A197,E51");
    
  }
  
  public static void main(String[] args) {
    new MDFrederickCountyParserTest().generateTests("T1");
  }
}