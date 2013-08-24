package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PALackawannaCountyAParser;

import org.junit.Test;

/*
Lackawanna County, PA
Contact: greg rhodes <grhodes908@gmail.com>
Contact: Mark Krzan <mkrzan1@gmail.com>
Contact: Randy Kochanowski <rkochdcfd@gmail.com>     
Sender: aegispage@lackawannacounty.org

    ** OLD FORMAT - NO LONGER ACCEPTED **
Unit  Location: 206 MILLER RD STEVENSON RD / CARBONDALE RD 1 Common Name: Call Type: ALS Call Time: 09/26/11 17:02 Narrative  pd notified  POSS CONFUSED ALSO  Nature Of Call: 79YOF FEELING WEEK. SHE DID FALL EARLIER
Unit  Location: 711 MAY ST MAPLE ST / DEAD END 59 Common Name: Call Type: ALS Call Time: 09/26/11 21:33 Narrative  PD ADVISED  REF EMD  HX OF HEART PROBLEMS  Nature Of Call: 56 YOM RAPID HEART RATE
Unit  Location: 108 TERRACE DR STURGES RD / SCRANTON CARBONDALE HWY 20 Common Name: LACKAWANNA HEALTH AND REHABCall Type: ALS Call Time: 09/26/11 21:02 Narrative  22-9/LA4 TO MOSES TAYLOR  22-9 ENRT MOMENTARILY  Nature Of Call: in c-2 -- 90 yo f diff breathing low o2 sats
Unit  Location: 601 6TH ST DEAD END / MOOSIC HEIGHTS 94 Common Name: Call Type: ALS Call Time: 09/26/11 22:27 Narrative  94PD ADVISED  UNKNOWN DRUGS  MALE TOOK DRUGS  IS BREATHING - IS SEMI-RESPONSIVE  Nature Of Call: 24 YOM COLLAPSED
Unit  Location: 116 FULTON ST PROSPECT ST / PROSPECT ST 61 Common Name: Call Type: BLS Call Time: 09/27/11 13:56 Narrative  CALLER REFUSED EMD  REQ NO SIRENS  Nature Of Call: 85 YOF PAIN IN THE SHOULDER
Unit  Location: 2500 N  WASHINGTON AVE DEAD END / HIGHNETT PL 50 Common Name: MU WOODLAND APARTMENTSCall Type: AFA Call Time: 09/27/11 14:53 Narrative  simplex panel PHN 5703486242// ATT KH  Nature Of Call: bldg 2,4,6
Unit  Location: 2500 N  WASHINGTON AVE DEAD END / HIGHNETT PL 50 Common Name: MU WOODLAND APARTMENTSCall Type: AFA Call Time: 09/27/11 14:53 Narrative  simplex panel PHN 5703486242// ATT KH  Nature Of Call: bldg 2,4,6
Unit  Location: 415 VENARD RD TEDRICK ST / ELAN GARDENS 2 Common Name: HERITAGE BAPTIST CHURCHCall Type: AFA Call Time: 09/27/11 15:07 Narrative  2pd advised  Nature Of Call: GEN FIRE ALRM ZONE 1
Unit  Location: 1196 CHAPMAN LAKE RD 28 Common Name: Call Type: AFA Call Time: 09/27/11 16:07 Narrative  Nature Of Call: res fire/ cutler res/ gen fire
Unit  Location: 40 GORDON AVE UN-NAMED / GORDAN AVE 51 Common Name: Call Type: STRT Call Time: 09/27/11 19:16 Narrative  tree that is in fire is 10 ft from residence  Nature Of Call: tree on fire
Unit 21-9  Location: 40 VALLEY VIEW ESTS EYNON JERMYN RD / EYNON JERMYN RD 33 Common Name: Call Type: BLS Call Time: 09/27/11 19:43 Narrative  21 pd notified  POSS CONSTIPATED  Nature Of Call: 10 MOS OLD. RIGID ABDOMEN.
Unit 21-9 R25  Location: 215 ERIE ST UN-NAMED / CHURCH ST 25 Common Name: Call Type: BLS Call Time: 09/28/11 10:00 Narrative  25PD ADVISED  UNABLE TO GET UP  Nature Of Call: 79 YOF FALL VICTIM, FELL ONTO FLOOR FROM COUCH
Unit E22 E20 L20 R23 22-9 SQ22  Location: 8 SCOTT RD W MOUNTAIN RD, E MOUNTAIN RD / GREEN GROVE RD 22 Common Name: MUSTANG MOTORSCall Type: STRT Call Time: 11/22/11 13:11 Narrative  BLACK SMOKE  Nature Of Call: SMOKE COMING FROM BUILDING

Contact: Active911
Agency name: Archbald Community Ambulance and Rescue
Location: Archbald, PA, United States
Sender: aegispage@lackawannacounty.org

(Dispatch) Unit 25-8 21-9  Location: 1222 WINTHROP ST FILBERT ST / SINIAWA DR 25 Common Name: Call Type: ALS Call Time: 02/20/13 22:09 Nature of Call: 64 YOM DIFF BREATHING - HX OF CANCER CFS Number 135
(Dispatch) Unit 21-9  Location: 7 HENRY DR GIBSON ST / GIBSON ST 58 7A Common Name: Call Type: DISO Call Time: 02/20/13 21:25 Nature of Call: 31 yom diso in the home CFS Number 116
(Dispatch) Unit  Location: 0 SCRANTON CARBONDALE HWY 20 Common Name: Call Type: ACCI Call Time: 02/20/13 12:14 Nature of Call: mva inj CFS Number 883
(Dispatch) Unit R21 21-9 21-8  Location: 0 SCRANTON CARBONDALE HWY 33 Common Name: Call Type: ACCI Call Time: 02/20/13 12:14 Nature of Call: mva inj CFS Number 883
(Dispatch) Unit  Location: 352 N MAIN ST OLD RIDGE RD / MONROE ST 21 Common Name: Call Type: ACCI Call Time: 02/19/13 10:54 Nature of Call: VEHICLE INTO A TREE CFS Number 420
(Dispatch) Unit 21-9 R59  Location: 348 N  MAIN ST OLD RIDGE RD / MONROE ST 21 Common Name: Call Type: ACCI Call Time: 02/19/13 10:54 Nature of Call: VEHICLE INTO A TREE CFS Number 420
(Dispatch) Unit 21-9  Location: 360 N MAIN ST MONROE ST / OLD RIDGE RD 21 Common Name: Call Type: ALS Call Time: 02/19/13 09:47 Nature of Call: elderly fem simi resp CFS Number 391
(Dispatch) Unit 21-9  Location: 1310 WINTON ST R WINTON ST / WINTON RD, HIGH ST 21 Common Name: Call Type: BLS Call Time: 02/19/13 04:43 Nature of Call: 61 yof cant get out of bed CFS Number 326
(Dispatch) Unit 21-9  Location: 426 2ND ST MILL ST / CHURCH ST 33 Common Name: Call Type: ALS Call Time: 02/18/13 17:36 Nature of Call: 67 yof Short of Breath, Abdominal Pain CFS Number 169
(Dispatch) Unit 21-9 QR25  Location: 404 1ST AVE CHURCH ST / DEAD END 25 Common Name: Call Type: ALS Call Time: 02/18/13 11:17 Nature of Call: 91 YOM SHAKING - LABORED BREATHING CFS Number 5
(Dispatch) Unit 21-9 LA10  Location: 807 HENRY ST CHARLES ST / PROPST ST 21 Common Name: Call Type: ALS Call Time: 02/18/13 00:27 Nature of Call: rectal bleed 79 y of  CFS Number 882
(Dispatch) Unit 21-9  Location: 503 LACKAWANNA ST HEMLOCK ST / MUCHAL LN 21 Common Name: Call Type: ALS Call Time: 02/17/13 19:07 Nature of Call: 77 yof chest pains CFS Number 786
(Dispatch) Unit 21-9  Location: 380 N MAIN ST MONROE ST / BANK ST 21 Common Name: ARCHBALD HOSE CO 1Call Type: ALS Call Time: 02/17/13 16:22 Nature of Call: 41 m diabetic emer  CFS Number 701
(Dispatch) Unit qr59 21-9  Location: 530 JEFFERSON AVE FRANKLIN ST / BACON ST 58 Common Name: COLLINS PARTY TENTCall Type: ALS Call Time: 02/17/13 15:41 Nature of Call: 56 YOM CANCER PT.  DEHYDRATED. CFS Number 681
(Dispatch) Unit 21-9 QR25  Location: 256 BRIDGE ST CONSTITUTION AVE / KINBACK ST 25 APT REAR Common Name: Call Type: ALS Call Time: 02/17/13 15:03 Nature of Call: 72 yom diff breathing CFS Number 667
(Dispatch) Unit 21-9  Location: 419 WHITE BIRCH DR KNOB HILL DR / MARIA BLVD 21 Common Name: Call Type: ALS Call Time: 02/17/13 10:31 Nature of Call: 45 YOM SYNCOPAL EPISODES CFS Number 570
(Dispatch) Unit 21-9  Location: 203 SALEM RD PINE ST / SPRUCE ST 21 Common Name: Call Type: ALS Call Time: 02/16/13 23:01 Nature of Call: 51/yf panic attack CFS Number 401
(Dispatch) Unit 21-9 QR25  Location: 225 CHERRY ST CONSTITUTION AVE / 4TH AVE 25 Common Name: Call Type: ALS Call Time: 02/16/13 14:48 Nature of Call: 73 YOF CHEST PAIN AND DIFF BREATHIGN CFS Number 227
(Dispatch) Unit 21-9  Location: 390 N MAIN ST MONROE ST / BANK ST 21 Common Name: Call Type: BLS Call Time: 02/16/13 09:19 Nature of Call: 16 YOM EYES WILL NOT OPEN - UNK MEDICAL CFS Number 70
(Dispatch) Unit 21-9 QR25  Location: 211 LANE ST POWDER MILL RD / WALSH ST 25 Common Name: Call Type: ALS Call Time: 02/16/13 06:10 Nature of Call: 41\n2M/FALL/BATHROOM/SLURING WORDS CFS Number 36
(Dispatch) Unit 21-9 QR25  Location: 310 1ST AVE UN-NAMED ALLEY / HAND ST 25 Common Name: Call Type: BLS Call Time: 02/14/13 11:04 Nature of Call: 80yom Bleeding from Penis CFS Number 101
(Dispatch) Unit 21-9  Location: 19 VALLEY VIEW ESTS EYNON JERMYN RD / EYNON JERMYN RD 33 Common Name: Call Type: BLS Call Time: 02/14/13 03:03 Nature of Call: LOT 19, 65 YOM PAIN IN KNEE CFS Number 971
(Dispatch) Unit 21-9  Location: 134 EAST ST WALNUT ST / MAIN ST 33 Common Name: Call Type: ALS Call Time: 02/14/13 02:49 Nature of Call: 87 yf/pounding heart beat/labored breathing CFS Number 969
(Dispatch) Unit 21-9  Location: 382 N MAIN ST MONROE ST / BANK ST 21 Common Name: Call Type: BLS Call Time: 02/13/13 21:54 Nature of Call: 66 yo m -- pain in his r side  CFS Number 930
(Dispatch) Unit 21-9  Location: 816 CHURCH ST FRONT ST / CLARKSON AVE 25 Common Name: Call Type: ALS Call Time: 02/13/13 13:12 Nature of Call: 57 yof dizzy feels like passing out CFS Number 721
(Dispatch) Unit 21-9 QR25  Location: 40 HILL ST UN-NAMED ALLEY / BASALYGA ST, RIVERVIEW DR 25 Common Name: Call Type: ALS Call Time: 02/13/13 10:14 Nature of Call: elderly fem simi resp CFS Number 651
(Dispatch) Unit 21-9  Location: 145 PINE ST WAYNE ST / PIKE ST 21 Common Name: Call Type: BLS Call Time: 02/13/13 10:02 Nature of Call: 32 y/male in alcohol withdrawl  CFS Number 639
(Dispatch) Unit 21-9 QR25  Location: 2 RIVER ST UNKNOWN / MT VERNON RD 25 Common Name: Call Type: BLS Call Time: 02/12/13 15:01 Nature of Call: 60 YOF VOMITING WEAK CFS Number 311
(Dispatch) Unit  Location: 202 HARRISON ST N MAIN ST / DELAWARE ST, EXPORT LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280
(Dispatch) Unit  Location: 202 DELAWARE ST EXPORT LN, HARRISON ST / WISTERIA LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280
(Dispatch) Unit 21-9  Location: 202 HARRISON ST N MAIN ST / DELAWARE ST, EXPORT LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280
(Dispatch) Unit 21-9  Location: 131 BEVERLY DR PIERCE ST / CATHERINE DR 33 Common Name: Call Type: ALS Call Time: 02/12/13 06:32 Nature of Call: 48 YOF IN AND OUT OF CONSC CFS Number 128
(Dispatch) Unit 21-9  Location: 460 DELAWARE ST HEMLOCK ST / CEMETERY ST 21 Common Name: Call Type: BLS Call Time: 02/11/13 19:05 Nature of Call: RESD MEDICAL ALARM - NO RESPONSE CFS Number 2
(Dispatch) Unit  Location: 295 DELAWARE ST EXPORT LN, HARRISON ST / UN-NAMED 21 Common Name: ARCHBALD AMBULANCECall Type: TEST Call Time: 02/11/13 15:14 Nature of Call: TEST CALL CFS Number 882
(Dispatch) Unit  Location: 197 MCANDREW DR LINE ST / DIVISION ST 21  UNIT A Common Name: Call Type: ALS Call Time: 02/11/13 08:08 Nature of Call: 51 yof/ fall victim ~head injury  CFS Number 707
(Dispatch) Unit 21-9  Location: 197 MCANDREW DR LINE ST / DIVISION ST 21 Common Name: Call Type: ALS Call Time: 02/11/13 08:08 Nature of Call: 51 yof/ fall victim ~head injury  CFS Number 707
(Dispatch) Unit 21-9 QR25  Location: 102 OLGA ST HILL ST / SAXON ST 25 Common Name: Call Type: ALS Call Time: 02/10/13 15:59 Nature of Call: male diabetic  CFS Number 465
(Dispatch) Unit 21-9  Location: 213 MCANDREW DR DIVISION ST / LINE ST 21  213D Common Name: Call Type: ALS Call Time: 02/10/13 08:27 Nature of Call: 46 YOF POSSIBLE HEART ATTACK CFS Number 332
(Dispatch) Unit qr59 21-9  Location: 119 FRANKLIN ST MADISON AVE / JOHNSON CT 58 Common Name: Call Type: BLS Call Time: 02/10/13 03:49 Nature of Call: 57 YOF IN SEVERE PAIN FROM A FALL LAST NIGHT CFS Number 301
(Dispatch) Unit 21-9  Location: 127 CEMETERY ST MONROE ST / PIKE ST 21 Common Name: Call Type: ALS Call Time: 02/09/13 15:49 Nature of Call: 88yof not responding CFS Number 50
(Dispatch) Unit  Location: 2 RIVER ST UNKNOWN / MT VERNON RD 25 Common Name: Call Type: ALS Call Time: 02/09/13 14:58 Nature of Call: 60 yof/ weak and blood in stool CFS Number 39
(Dispatch) Unit 21-9  Location: 2 RIVER ST 21 Common Name: Call Type: ALS Call Time: 02/09/13 14:58 Nature of Call: 60 yof/ weak and blood in stool CFS Number 39
(Dispatch) Unit qr59 21-9  Location: 752 JEFFERSON AVE DIVISION ST, WHITMORE AVE / RUSHBROOK ST 58 Common Name: Call Type: ALS Call Time: 02/09/13 08:11 Nature of Call: 25 yom/ diff breathing  CFS Number 895
(Dispatch) Unit 21-9  Location: 722 3RD ST PIERCE AVE / KENNEDY DR 33 Common Name: Call Type: BLS Call Time: 02/09/13 09:06 Nature of Call: 75 YOM FALL VICTEM LEG INJURY CANNOT GET UP CFS Number 919

 */

public class PALackawannaCountyAParserTest extends BaseParserTest {
  
  public PALackawannaCountyAParserTest() {
    setParser(new PALackawannaCountyAParser(), "LACKAWANNA COUNTY", "PA");
  }
  
  @Test
  public void testArchbaldCommunityAmbulanceAndRescue() {
 

    doTest("T1",
        "(Dispatch) Unit 25-8 21-9  Location: 1222 WINTHROP ST FILBERT ST / SINIAWA DR 25 Common Name: Call Type: ALS Call Time: 02/20/13 22:09 Nature of Call: 64 YOM DIFF BREATHING - HX OF CANCER CFS Number 135",
        "ADDR:1222 WINTHROP ST",
        "X:FILBERT ST / SINIAWA DR 25",
        "CALL:ALS",
        "DATE:02/20/13",
        "TIME:22:09",
        "INFO:64 YOM DIFF BREATHING - HX OF CANCER",
        "ID:135");

    doTest("T2",
        "(Dispatch) Unit 21-9  Location: 7 HENRY DR GIBSON ST / GIBSON ST 58 7A Common Name: Call Type: DISO Call Time: 02/20/13 21:25 Nature of Call: 31 yom diso in the home CFS Number 116",
        "ADDR:7 HENRY DR",
        "X:GIBSON ST / GIBSON ST 58 7A",
        "CALL:DISO",
        "DATE:02/20/13",
        "TIME:21:25",
        "INFO:31 yom diso in the home",
        "ID:116");

    doTest("T3",
        "(Dispatch) Unit  Location: 0 SCRANTON CARBONDALE HWY 20 Common Name: Call Type: ACCI Call Time: 02/20/13 12:14 Nature of Call: mva inj CFS Number 883",
        "ADDR:SCRANTON CARBONDALE HWY",
        "APT:20",
        "CALL:ACCI",
        "DATE:02/20/13",
        "TIME:12:14",
        "INFO:mva inj",
        "ID:883");

    doTest("T4",
        "(Dispatch) Unit R21 21-9 21-8  Location: 0 SCRANTON CARBONDALE HWY 33 Common Name: Call Type: ACCI Call Time: 02/20/13 12:14 Nature of Call: mva inj CFS Number 883",
        "ADDR:SCRANTON CARBONDALE HWY",
        "APT:33",
        "CALL:ACCI",
        "DATE:02/20/13",
        "TIME:12:14",
        "INFO:mva inj",
        "ID:883");

    doTest("T5",
        "(Dispatch) Unit  Location: 352 N MAIN ST OLD RIDGE RD / MONROE ST 21 Common Name: Call Type: ACCI Call Time: 02/19/13 10:54 Nature of Call: VEHICLE INTO A TREE CFS Number 420",
        "ADDR:352 N MAIN ST",
        "X:OLD RIDGE RD / MONROE ST 21",
        "CALL:ACCI",
        "DATE:02/19/13",
        "TIME:10:54",
        "INFO:VEHICLE INTO A TREE",
        "ID:420");

    doTest("T6",
        "(Dispatch) Unit 21-9 R59  Location: 348 N  MAIN ST OLD RIDGE RD / MONROE ST 21 Common Name: Call Type: ACCI Call Time: 02/19/13 10:54 Nature of Call: VEHICLE INTO A TREE CFS Number 420",
        "ADDR:348 N MAIN ST",
        "X:OLD RIDGE RD / MONROE ST 21",
        "CALL:ACCI",
        "DATE:02/19/13",
        "TIME:10:54",
        "INFO:VEHICLE INTO A TREE",
        "ID:420");

    doTest("T7",
        "(Dispatch) Unit 21-9  Location: 360 N MAIN ST MONROE ST / OLD RIDGE RD 21 Common Name: Call Type: ALS Call Time: 02/19/13 09:47 Nature of Call: elderly fem simi resp CFS Number 391",
        "ADDR:360 N MAIN ST",
        "X:MONROE ST / OLD RIDGE RD 21",
        "CALL:ALS",
        "DATE:02/19/13",
        "TIME:09:47",
        "INFO:elderly fem simi resp",
        "ID:391");

    doTest("T8",
        "(Dispatch) Unit 21-9  Location: 1310 WINTON ST R WINTON ST / WINTON RD, HIGH ST 21 Common Name: Call Type: BLS Call Time: 02/19/13 04:43 Nature of Call: 61 yof cant get out of bed CFS Number 326",
        "ADDR:1310 WINTON ST",
        "X:R WINTON ST / WINTON RD, HIGH ST 21",
        "CALL:BLS",
        "DATE:02/19/13",
        "TIME:04:43",
        "INFO:61 yof cant get out of bed",
        "ID:326");

    doTest("T9",
        "(Dispatch) Unit 21-9  Location: 426 2ND ST MILL ST / CHURCH ST 33 Common Name: Call Type: ALS Call Time: 02/18/13 17:36 Nature of Call: 67 yof Short of Breath, Abdominal Pain CFS Number 169",
        "ADDR:426 2ND ST",
        "X:MILL ST / CHURCH ST 33",
        "CALL:ALS",
        "DATE:02/18/13",
        "TIME:17:36",
        "INFO:67 yof Short of Breath, Abdominal Pain",
        "ID:169");

    doTest("T10",
        "(Dispatch) Unit 21-9 QR25  Location: 404 1ST AVE CHURCH ST / DEAD END 25 Common Name: Call Type: ALS Call Time: 02/18/13 11:17 Nature of Call: 91 YOM SHAKING - LABORED BREATHING CFS Number 5",
        "ADDR:404 1ST AVE",
        "X:CHURCH ST / DEAD END 25",
        "CALL:ALS",
        "DATE:02/18/13",
        "TIME:11:17",
        "INFO:91 YOM SHAKING - LABORED BREATHING",
        "ID:5");

    doTest("T11",
        "(Dispatch) Unit 21-9 LA10  Location: 807 HENRY ST CHARLES ST / PROPST ST 21 Common Name: Call Type: ALS Call Time: 02/18/13 00:27 Nature of Call: rectal bleed 79 y of  CFS Number 882",
        "ADDR:807 HENRY ST",
        "X:CHARLES ST / PROPST ST 21",
        "CALL:ALS",
        "DATE:02/18/13",
        "TIME:00:27",
        "INFO:rectal bleed 79 y of",
        "ID:882");

    doTest("T12",
        "(Dispatch) Unit 21-9  Location: 503 LACKAWANNA ST HEMLOCK ST / MUCHAL LN 21 Common Name: Call Type: ALS Call Time: 02/17/13 19:07 Nature of Call: 77 yof chest pains CFS Number 786",
        "ADDR:503 LACKAWANNA ST",
        "X:HEMLOCK ST / MUCHAL LN 21",
        "CALL:ALS",
        "DATE:02/17/13",
        "TIME:19:07",
        "INFO:77 yof chest pains",
        "ID:786");

    doTest("T13",
        "(Dispatch) Unit 21-9  Location: 380 N MAIN ST MONROE ST / BANK ST 21 Common Name: ARCHBALD HOSE CO 1Call Type: ALS Call Time: 02/17/13 16:22 Nature of Call: 41 m diabetic emer  CFS Number 701",
        "ADDR:380 N MAIN ST",
        "X:MONROE ST / BANK ST 21",
        "PLACE:ARCHBALD HOSE CO 1",
        "CALL:ALS",
        "DATE:02/17/13",
        "TIME:16:22",
        "INFO:41 m diabetic emer",
        "ID:701");

    doTest("T14",
        "(Dispatch) Unit qr59 21-9  Location: 530 JEFFERSON AVE FRANKLIN ST / BACON ST 58 Common Name: COLLINS PARTY TENTCall Type: ALS Call Time: 02/17/13 15:41 Nature of Call: 56 YOM CANCER PT.  DEHYDRATED. CFS Number 681",
        "ADDR:530 JEFFERSON AVE",
        "X:FRANKLIN ST / BACON ST 58",
        "PLACE:COLLINS PARTY TENT",
        "CALL:ALS",
        "DATE:02/17/13",
        "TIME:15:41",
        "INFO:56 YOM CANCER PT.  DEHYDRATED.",
        "ID:681");

    doTest("T15",
        "(Dispatch) Unit 21-9 QR25  Location: 256 BRIDGE ST CONSTITUTION AVE / KINBACK ST 25 APT REAR Common Name: Call Type: ALS Call Time: 02/17/13 15:03 Nature of Call: 72 yom diff breathing CFS Number 667",
        "ADDR:256 BRIDGE ST",
        "X:CONSTITUTION AVE / KINBACK ST 25 APT REAR",
        "CALL:ALS",
        "DATE:02/17/13",
        "TIME:15:03",
        "INFO:72 yom diff breathing",
        "ID:667");

    doTest("T16",
        "(Dispatch) Unit 21-9  Location: 419 WHITE BIRCH DR KNOB HILL DR / MARIA BLVD 21 Common Name: Call Type: ALS Call Time: 02/17/13 10:31 Nature of Call: 45 YOM SYNCOPAL EPISODES CFS Number 570",
        "ADDR:419 WHITE BIRCH DR",
        "X:KNOB HILL DR / MARIA BLVD 21",
        "CALL:ALS",
        "DATE:02/17/13",
        "TIME:10:31",
        "INFO:45 YOM SYNCOPAL EPISODES",
        "ID:570");

    doTest("T17",
        "(Dispatch) Unit 21-9  Location: 203 SALEM RD PINE ST / SPRUCE ST 21 Common Name: Call Type: ALS Call Time: 02/16/13 23:01 Nature of Call: 51/yf panic attack CFS Number 401",
        "ADDR:203 SALEM RD",
        "X:PINE ST / SPRUCE ST 21",
        "CALL:ALS",
        "DATE:02/16/13",
        "TIME:23:01",
        "INFO:51/yf panic attack",
        "ID:401");

    doTest("T18",
        "(Dispatch) Unit 21-9 QR25  Location: 225 CHERRY ST CONSTITUTION AVE / 4TH AVE 25 Common Name: Call Type: ALS Call Time: 02/16/13 14:48 Nature of Call: 73 YOF CHEST PAIN AND DIFF BREATHIGN CFS Number 227",
        "ADDR:225 CHERRY ST",
        "X:CONSTITUTION AVE / 4TH AVE 25",
        "CALL:ALS",
        "DATE:02/16/13",
        "TIME:14:48",
        "INFO:73 YOF CHEST PAIN AND DIFF BREATHIGN",
        "ID:227");

    doTest("T19",
        "(Dispatch) Unit 21-9  Location: 390 N MAIN ST MONROE ST / BANK ST 21 Common Name: Call Type: BLS Call Time: 02/16/13 09:19 Nature of Call: 16 YOM EYES WILL NOT OPEN - UNK MEDICAL CFS Number 70",
        "ADDR:390 N MAIN ST",
        "X:MONROE ST / BANK ST 21",
        "CALL:BLS",
        "DATE:02/16/13",
        "TIME:09:19",
        "INFO:16 YOM EYES WILL NOT OPEN - UNK MEDICAL",
        "ID:70");

    doTest("T20",
        "(Dispatch) Unit 21-9 QR25  Location: 211 LANE ST POWDER MILL RD / WALSH ST 25 Common Name: Call Type: ALS Call Time: 02/16/13 06:10 Nature of Call: 41\n" +
        "2M/FALL/BATHROOM/SLURING WORDS CFS Number 36",

        "ADDR:211 LANE ST",
        "X:POWDER MILL RD / WALSH ST 25",
        "CALL:ALS",
        "DATE:02/16/13",
        "TIME:06:10",
        "INFO:41 2M/FALL/BATHROOM/SLURING WORDS",
        "ID:36");

    doTest("T21",
        "(Dispatch) Unit 21-9 QR25  Location: 310 1ST AVE UN-NAMED ALLEY / HAND ST 25 Common Name: Call Type: BLS Call Time: 02/14/13 11:04 Nature of Call: 80yom Bleeding from Penis CFS Number 101",
        "ADDR:310 1ST AVE",
        "X:UN-NAMED ALLEY / HAND ST 25",
        "CALL:BLS",
        "DATE:02/14/13",
        "TIME:11:04",
        "INFO:80yom Bleeding from Penis",
        "ID:101");

    doTest("T22",
        "(Dispatch) Unit 21-9  Location: 19 VALLEY VIEW ESTS EYNON JERMYN RD / EYNON JERMYN RD 33 Common Name: Call Type: BLS Call Time: 02/14/13 03:03 Nature of Call: LOT 19, 65 YOM PAIN IN KNEE CFS Number 971",
        "ADDR:19 VALLEY VIEW ESTS",
        "X:EYNON JERMYN RD / EYNON JERMYN RD 33",
        "CALL:BLS",
        "DATE:02/14/13",
        "TIME:03:03",
        "INFO:LOT 19, 65 YOM PAIN IN KNEE",
        "ID:971");

    doTest("T23",
        "(Dispatch) Unit 21-9  Location: 134 EAST ST WALNUT ST / MAIN ST 33 Common Name: Call Type: ALS Call Time: 02/14/13 02:49 Nature of Call: 87 yf/pounding heart beat/labored breathing CFS Number 969",
        "ADDR:134 EAST ST",
        "X:WALNUT ST / MAIN ST 33",
        "CALL:ALS",
        "DATE:02/14/13",
        "TIME:02:49",
        "INFO:87 yf/pounding heart beat/labored breathing",
        "ID:969");

    doTest("T24",
        "(Dispatch) Unit 21-9  Location: 382 N MAIN ST MONROE ST / BANK ST 21 Common Name: Call Type: BLS Call Time: 02/13/13 21:54 Nature of Call: 66 yo m -- pain in his r side  CFS Number 930",
        "ADDR:382 N MAIN ST",
        "X:MONROE ST / BANK ST 21",
        "CALL:BLS",
        "DATE:02/13/13",
        "TIME:21:54",
        "INFO:66 yo m -- pain in his r side",
        "ID:930");

    doTest("T25",
        "(Dispatch) Unit 21-9  Location: 816 CHURCH ST FRONT ST / CLARKSON AVE 25 Common Name: Call Type: ALS Call Time: 02/13/13 13:12 Nature of Call: 57 yof dizzy feels like passing out CFS Number 721",
        "ADDR:816 CHURCH ST",
        "X:FRONT ST / CLARKSON AVE 25",
        "CALL:ALS",
        "DATE:02/13/13",
        "TIME:13:12",
        "INFO:57 yof dizzy feels like passing out",
        "ID:721");

    doTest("T26",
        "(Dispatch) Unit 21-9 QR25  Location: 40 HILL ST UN-NAMED ALLEY / BASALYGA ST, RIVERVIEW DR 25 Common Name: Call Type: ALS Call Time: 02/13/13 10:14 Nature of Call: elderly fem simi resp CFS Number 651",
        "ADDR:40 HILL ST",
        "X:UN-NAMED ALLEY / BASALYGA ST, RIVERVIEW DR 25",
        "CALL:ALS",
        "DATE:02/13/13",
        "TIME:10:14",
        "INFO:elderly fem simi resp",
        "ID:651");

    doTest("T27",
        "(Dispatch) Unit 21-9  Location: 145 PINE ST WAYNE ST / PIKE ST 21 Common Name: Call Type: BLS Call Time: 02/13/13 10:02 Nature of Call: 32 y/male in alcohol withdrawl  CFS Number 639",
        "ADDR:145 PINE ST",
        "X:WAYNE ST / PIKE ST 21",
        "CALL:BLS",
        "DATE:02/13/13",
        "TIME:10:02",
        "INFO:32 y/male in alcohol withdrawl",
        "ID:639");

    doTest("T28",
        "(Dispatch) Unit 21-9 QR25  Location: 2 RIVER ST UNKNOWN / MT VERNON RD 25 Common Name: Call Type: BLS Call Time: 02/12/13 15:01 Nature of Call: 60 YOF VOMITING WEAK CFS Number 311",
        "ADDR:2 RIVER ST",
        "X:UNKNOWN / MT VERNON RD 25",
        "CALL:BLS",
        "DATE:02/12/13",
        "TIME:15:01",
        "INFO:60 YOF VOMITING WEAK",
        "ID:311");

    doTest("T29",
        "(Dispatch) Unit  Location: 202 HARRISON ST N MAIN ST / DELAWARE ST, EXPORT LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280",
        "ADDR:202 HARRISON ST",
        "X:N MAIN ST / DELAWARE ST, EXPORT LN 21",
        "CALL:ALS",
        "DATE:02/12/13",
        "TIME:13:24",
        "INFO:72 YOM DISORIENTED TROUBLE BREATHING",
        "ID:280");

    doTest("T30",
        "(Dispatch) Unit  Location: 202 DELAWARE ST EXPORT LN, HARRISON ST / WISTERIA LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280",
        "ADDR:202 DELAWARE ST",
        "X:EXPORT LN, HARRISON ST / WISTERIA LN 21",
        "CALL:ALS",
        "DATE:02/12/13",
        "TIME:13:24",
        "INFO:72 YOM DISORIENTED TROUBLE BREATHING",
        "ID:280");

    doTest("T31",
        "(Dispatch) Unit 21-9  Location: 202 HARRISON ST N MAIN ST / DELAWARE ST, EXPORT LN 21 Common Name: Call Type: ALS Call Time: 02/12/13 13:24 Nature of Call: 72 YOM DISORIENTED TROUBLE BREATHING CFS Number 280",
        "ADDR:202 HARRISON ST",
        "X:N MAIN ST / DELAWARE ST, EXPORT LN 21",
        "CALL:ALS",
        "DATE:02/12/13",
        "TIME:13:24",
        "INFO:72 YOM DISORIENTED TROUBLE BREATHING",
        "ID:280");

    doTest("T32",
        "(Dispatch) Unit 21-9  Location: 131 BEVERLY DR PIERCE ST / CATHERINE DR 33 Common Name: Call Type: ALS Call Time: 02/12/13 06:32 Nature of Call: 48 YOF IN AND OUT OF CONSC CFS Number 128",
        "ADDR:131 BEVERLY DR",
        "X:PIERCE ST / CATHERINE DR 33",
        "CALL:ALS",
        "DATE:02/12/13",
        "TIME:06:32",
        "INFO:48 YOF IN AND OUT OF CONSC",
        "ID:128");

    doTest("T33",
        "(Dispatch) Unit 21-9  Location: 460 DELAWARE ST HEMLOCK ST / CEMETERY ST 21 Common Name: Call Type: BLS Call Time: 02/11/13 19:05 Nature of Call: RESD MEDICAL ALARM - NO RESPONSE CFS Number 2",
        "ADDR:460 DELAWARE ST",
        "X:HEMLOCK ST / CEMETERY ST 21",
        "CALL:BLS",
        "DATE:02/11/13",
        "TIME:19:05",
        "INFO:RESD MEDICAL ALARM - NO RESPONSE",
        "ID:2");

    doTest("T34",
        "(Dispatch) Unit  Location: 295 DELAWARE ST EXPORT LN, HARRISON ST / UN-NAMED 21 Common Name: ARCHBALD AMBULANCECall Type: TEST Call Time: 02/11/13 15:14 Nature of Call: TEST CALL CFS Number 882",
        "ADDR:295 DELAWARE ST",
        "X:EXPORT LN, HARRISON ST / UN-NAMED 21",
        "PLACE:ARCHBALD AMBULANCE",
        "CALL:TEST",
        "DATE:02/11/13",
        "TIME:15:14",
        "INFO:TEST CALL",
        "ID:882");

    doTest("T35",
        "(Dispatch) Unit  Location: 197 MCANDREW DR LINE ST / DIVISION ST 21  UNIT A Common Name: Call Type: ALS Call Time: 02/11/13 08:08 Nature of Call: 51 yof/ fall victim ~head injury  CFS Number 707",
        "ADDR:197 MCANDREW DR",
        "X:LINE ST / DIVISION ST 21  UNIT A",
        "CALL:ALS",
        "DATE:02/11/13",
        "TIME:08:08",
        "INFO:51 yof/ fall victim ~head injury",
        "ID:707");

    doTest("T36",
        "(Dispatch) Unit 21-9  Location: 197 MCANDREW DR LINE ST / DIVISION ST 21 Common Name: Call Type: ALS Call Time: 02/11/13 08:08 Nature of Call: 51 yof/ fall victim ~head injury  CFS Number 707",
        "ADDR:197 MCANDREW DR",
        "X:LINE ST / DIVISION ST 21",
        "CALL:ALS",
        "DATE:02/11/13",
        "TIME:08:08",
        "INFO:51 yof/ fall victim ~head injury",
        "ID:707");

    doTest("T37",
        "(Dispatch) Unit 21-9 QR25  Location: 102 OLGA ST HILL ST / SAXON ST 25 Common Name: Call Type: ALS Call Time: 02/10/13 15:59 Nature of Call: male diabetic  CFS Number 465",
        "ADDR:102 OLGA ST",
        "X:HILL ST / SAXON ST 25",
        "CALL:ALS",
        "DATE:02/10/13",
        "TIME:15:59",
        "INFO:male diabetic",
        "ID:465");

    doTest("T38",
        "(Dispatch) Unit 21-9  Location: 213 MCANDREW DR DIVISION ST / LINE ST 21  213D Common Name: Call Type: ALS Call Time: 02/10/13 08:27 Nature of Call: 46 YOF POSSIBLE HEART ATTACK CFS Number 332",
        "ADDR:213 MCANDREW DR",
        "X:DIVISION ST / LINE ST 21  213D",
        "CALL:ALS",
        "DATE:02/10/13",
        "TIME:08:27",
        "INFO:46 YOF POSSIBLE HEART ATTACK",
        "ID:332");

    doTest("T39",
        "(Dispatch) Unit qr59 21-9  Location: 119 FRANKLIN ST MADISON AVE / JOHNSON CT 58 Common Name: Call Type: BLS Call Time: 02/10/13 03:49 Nature of Call: 57 YOF IN SEVERE PAIN FROM A FALL LAST NIGHT CFS Number 301",
        "ADDR:119 FRANKLIN ST",
        "X:MADISON AVE / JOHNSON CT 58",
        "CALL:BLS",
        "DATE:02/10/13",
        "TIME:03:49",
        "INFO:57 YOF IN SEVERE PAIN FROM A FALL LAST NIGHT",
        "ID:301");

    doTest("T40",
        "(Dispatch) Unit 21-9  Location: 127 CEMETERY ST MONROE ST / PIKE ST 21 Common Name: Call Type: ALS Call Time: 02/09/13 15:49 Nature of Call: 88yof not responding CFS Number 50",
        "ADDR:127 CEMETERY ST",
        "X:MONROE ST / PIKE ST 21",
        "CALL:ALS",
        "DATE:02/09/13",
        "TIME:15:49",
        "INFO:88yof not responding",
        "ID:50");

    doTest("T41",
        "(Dispatch) Unit  Location: 2 RIVER ST UNKNOWN / MT VERNON RD 25 Common Name: Call Type: ALS Call Time: 02/09/13 14:58 Nature of Call: 60 yof/ weak and blood in stool CFS Number 39",
        "ADDR:2 RIVER ST",
        "X:UNKNOWN / MT VERNON RD 25",
        "CALL:ALS",
        "DATE:02/09/13",
        "TIME:14:58",
        "INFO:60 yof/ weak and blood in stool",
        "ID:39");

    doTest("T42",
        "(Dispatch) Unit 21-9  Location: 2 RIVER ST 21 Common Name: Call Type: ALS Call Time: 02/09/13 14:58 Nature of Call: 60 yof/ weak and blood in stool CFS Number 39",
        "ADDR:2 RIVER ST",
        "APT:21",
        "CALL:ALS",
        "DATE:02/09/13",
        "TIME:14:58",
        "INFO:60 yof/ weak and blood in stool",
        "ID:39");

    doTest("T43",
        "(Dispatch) Unit qr59 21-9  Location: 752 JEFFERSON AVE DIVISION ST, WHITMORE AVE / RUSHBROOK ST 58 Common Name: Call Type: ALS Call Time: 02/09/13 08:11 Nature of Call: 25 yom/ diff breathing  CFS Number 895",
        "ADDR:752 JEFFERSON AVE",
        "X:DIVISION ST, WHITMORE AVE / RUSHBROOK ST 58",
        "CALL:ALS",
        "DATE:02/09/13",
        "TIME:08:11",
        "INFO:25 yom/ diff breathing",
        "ID:895");

    doTest("T44",
        "(Dispatch) Unit 21-9  Location: 722 3RD ST PIERCE AVE / KENNEDY DR 33 Common Name: Call Type: BLS Call Time: 02/09/13 09:06 Nature of Call: 75 YOM FALL VICTEM LEG INJURY CANNOT GET UP CFS Number 919",
        "ADDR:722 3RD ST",
        "X:PIERCE AVE / KENNEDY DR 33",
        "CALL:BLS",
        "DATE:02/09/13",
        "TIME:09:06",
        "INFO:75 YOM FALL VICTEM LEG INJURY CANNOT GET UP",
        "ID:919");
 }
  
  public static void main(String args[]) {
    new PALackawannaCountyAParserTest().generateTests("T1");
  }
}