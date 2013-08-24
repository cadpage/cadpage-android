package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Porter County, IN
Contact: Chad Elwood <chadelwood@gmail.com>
Contact: "Gregory Adair" <gadair@washingtonfire.net>
Contact: Mike Luczak <firefighter3198@gmail.com>
Sender: pcdisp@porterco-ps.org
System: Tiberon

Subject:CAD Page\n\n#110089211 - \nF35P2:\nEMS AST-P2 @ 380 N 400 E,WGT\nCROSS: btwn AUGUSTINE DR and E 400 N\npcdisp@porterco-ps.orgGRP:WF\nPRI:2\ncomment: Medical P
Subject: CAD Page\n\n#110085268 - \nF35:\nMISC. AST EMS @ 4 WILLIAMSBURG DR,WGT\nCROSS: btwn DEAD END and VIRGINIA CT\nGRP:WF\nPRI:4\ncomment: UN
Subject: CAD Page\n\n#110085607 -\nF35P2:\nEMS AST-P2 @ 342 N 325 E,WGT\nCROSS: btwn LONG PRAIRIE RD and STREAMWOOD DR GRP:WF\nPRI:2\ncomment:
Subject: CAD Page\n\n#110086732 - \nF3:\nELECTRICAL FIRE @ 3705 VALE PARK RD,WGT\nCROSS: btwn ST RD 49 and BARTZ RD\nGRP:WF\nPRI:1\ncomment: 2 PO
Subject: CAD Page\n\n#110086764 - \nF33:\nMANPOWER AST EMS @ 13 WILLIAMSBURG DR,WGT\nCROSS: btwn DEAD END and JAMESTOWN AV\nGRP:WF\nPRI:1\ncommen
Subject: CAD Page\n\n#110087784 - \nF35P2:\nEMS AST-P2 @ WASHINGTON TWP HIGH SCHOOL,WGT\n - at 383 E ST RD 2,WGT\nCROSS: btwn E EVANS AV and N
Subject: CAD Page\n\n#110088677 - \nF41:\nMUT.AID/RESP. TO SCN @ 177 HEATHERHILL DR,CTT\nCROSS: btwn DEAD END and HACKNEY LN\nGRP:WF\nPRI:1\ncomm
Subject: CAD Page\n\n#110089211 - \nF35P2:\nEMS AST-P2 @ 380 N 400 E,WGT\nCROSS: btwn AUGUSTINE DR and E 400 N\nGRP:WF\nPRI:2\ncomment: Medical P
Subject: CAD Page\n\n#110089866 -\nE29\nMV CRASH/TRANS.ACC @ E US HWY 6 / EDMOND CT, LBT - < 0/ 801>\nGRP:PM\nPRI:1\ncomment: CAR VS PICKUP, CAR IS IN DITCH

Contact: firemedic3087 <firemedic3087@gmail.com>
Subject:CAD Page\n\n#110120370 - \nF5:\nBRUSH/GRASS FIRE @ E ENGEL DR / CAIN DR,WGT\n-  < 3900/ 1>\nGRP:WF\nPRI:1\ncomment: OPEN BURN IN AREA/
Subject:CAD Page\n\n#110127635 - \nF35:\nMISC. AST EMS @ PILOT TRAVEL CENTER,WGT\n- at 4105 E MORTHLAND DR,WGT\nCROSS: near DEAD END\nGRP:WF\nP
Subject:CAD Page\n\n#110137072 - \nF35P1:\nEMS AST-P1 @ 429 E ST RD 2,WGT\nCROSS: btwn N 400 E and N 450 E\nGRP:WF\nPRI:1\ncomment: Medical ProQ

Contact: "Kurtz, Eric [KurtzE@comcast.net] " <KurtzE@comcast.net>
Sender: pcdisp@porterco-ps.org
Subject:CAD Page\n\n#110166809 - \nF35P1:\nEMS AST-P1 @ 53 ASPEN RD,OGD\nCROSS: btwn BITTERSWEET LN and OGDEN RD\nGRP:OF\nPRI:1\ncomment: Medica

Contact: Gregory Adair <firemedic3087@gmail.com>
Sender: pcdisp@porterco-ps.org
Subject:CAD Page\n\n#120036045 - \nF35:\nMISC. AST EMS @ 253-1 N ST RD 2,WGT\nCROSS: btwn RIGG RD and E 300 N\nGRP:WF\nPRI:1\ncomment: COMPLAINI\r

Contact: Ems Medic 31 <emsmedic31@gmail.com>
Sender: pcdisp@porterco-ps.org
(CAD Page) #120048030 - \nE32:\nUNK.PROB.(MAN DOWN) @ MM22,BHB\n- at 240 I94,BHB\nCROSS: btwn I94&US20 D and ST RD 149\nGRP:PM\nPRI:1\ncomment: I 94 WESTBOUND 22 M

Contact: Michael Zappia <mk.zappia@gmail.com>
Sender: pcdisp@porterco-ps.org
(CAD Page) #120065003 - \nF35P1:\nEMS AST-P1 @ 1118 WINTER PARK DR,LBT\nCROSS: btwn ASPEN DR and SUN VALLEY DR\nGRP:LF\nPRI:1\ncomment: Medical ProQA recommends di

Contact: Contact: firemedic3087 <firemedic3087@gmail.com>
Subject:CAD Page\n\n#120110035 - \nF51:\nALARM:SMOKE/FIRE/CO @ 463 E US HWY 30,WGT\nCROSS: btwn N 450 E and N 575 E\nGRP:WF\nPRI:1\ncomment: ACT\r

Contact: Christopher Diaz <cdiaz@lofsfire.com>
Sender: messaging@iamresponding.com
Subject:LOFS\nF32:\nRESP.ARR.AST EMS @ CHICAGOLAND CHRISTIAN VILLAGE,WNT\n- at 6685 E 117TH AV,WNT\nCROSS: btwn GIBSON ST and JAY ST\n-\r

Contact: TOM SHAPEN <capt1903@gmail.com>
Sender: pcdisp@porterco-ps.org
(CAD Page)\n#130001233 - \nF32:\nRESP.ARR.AST EMS @ 76 W US HWY 6 #81,LBT\nCROSS: btwn N 75 W and N 125 W\nGRP:LF\nPRI:1\ncomment: CALLED 911 UNKNOWN PROBLEM

Contact: Active911
Agency name: Porter Fire Department
Location: Porter, IN, United States
Sender: pcdisp@porterco-ps.org

(CAD Page) \n#130016058 - \nF27:\nDROWNING RESCUE @ 7501 BELSHAW\nGRP:FS\nPRI:1\ncomment: ROLLOVER PI..VEH IN CREEK.10-0 ON SITE..UNK IF THERE'S OTHERS IN VEH...ST RD 2 TO JOE MARTIN RD..GO SOUTH TO THE "T" THEN RIGHT ON BELSHAW
(CAD Page) \n#130017162 - \nF35P1:\nEMS AST-P1 @ 246 BAILEY STATION RD,DAC\nCROSS: btwn BAILY GENERATING STA and BAILLY GENERATING STA\nGRP:PF\nPRI:1\ncomment: REQ AMBULANCE/LACERATION IN THE MACHINE SHOP/MALE/
(CAD Page) \n#130017015 - \nF21:\nMV CRASH @ INDIANA DUNES STATE PARK ENTRANCE,WCT\n - at 1530 N 25 E,WCT\nCROSS: btwn STATE PARK RD and DEAD END\nGRP:PF\nPRI:1\ncomment: SUBJECT HIT A BUILDING HEAD WENT THROUGH WINDSHIELD
(CAD Page) \n#130016721 - \nF15:\nSCHOOL BUILDING FIRE @ CHESTERTON HIGH SCHOOL,CHE\n - at 2125 S 11TH ST,CHE\nCROSS: btwn W 1100 N and E 1050 N\nGRP:CF\nPRI:1\ncomment: AUTOMATED SYSTEM // FIRE ALARM
(CAD Page) \n#130016046 - \nF32:\nRESP.ARR.AST EMS @ 310 MICHIGAMI TRL,PTR\nCROSS: btwn CHIEF CIR and STRONGBOW TRL\nGRP:PF\nPRI:1\ncomment: FELL YESTERDAY / BACK PAIN / 53 YOM DIFF BREATHING/ PRO Q/A WENT DOWN
(CAD Page) \n#130015942 - \nF35P1:\nEMS AST-P1 @ 20 FRANKLIN ST,PTR\nCROSS: btwn SEXTON AV and WAGNER RD\nGRP:PF\nPRI:1\ncomment: 73 YOF NOSEBLEED
(CAD Page) \n#130015685 - \nF32:\nRESP.ARR.AST EMS @ 1209 WAGNER RD,PTR\nCROSS: btwn W OAKHILL RD and DUNE MEADOWS DR\nGRP:PF\nPRI:1\ncomment: Medical ProQA recommends dispatch at this time
(CAD Page) \n#130015487 - \nF35P1:\nEMS AST-P1 @ 433 W US HWY 20,PTR\nCROSS: btwn W OAKHILL RD and WAGNER RD\nGRP:PF\nPRI:1\ncomment: Medical ProQA recommends dispatch at this time
(CAD Page) \n#130015200 - \nF21:\nMV CRASH @ MM21,BHB\n - at 340 I94,BHB\nCROSS: btwn ST RD 149 and JENSEN DR\nGRP:BH\nPRI:1\ncomment: SILVER VEHICLE VS WALL/ W/B  FEMALE STRUCK HER HEAD/ ISP ALREADY AWARE
(CAD Page) \n#130015179 - \nF32:\nRESP.ARR.AST EMS @ 950 W OAKHILL RD,PTR\nCROSS: btwn WAGNER RD and N MINERAL SPRINGS RD\nGRP:PF\nPRI:1\ncomment: 75 YOF CONSC / DIFF BREATHING / COPD

Contact: Active911
Agency name: Liberty Twp. Vol. Fire Dept.
Location: Chesterton, IN, United States
Sender: pcdisp@porterco-ps.org

(CAD Page) \n#130066994 - \nF12A01:\nCONVULS./SEIZURES @ 1209 ASPEN DR,LBT\nCROSS: btwn WINTER PARK DR and SUN VALLEY DR\nGRP:LF\nPRI:4\ncomment: Medical ProQA recommends dispatch at this time
(CAD Page) \n#130066832 - \nF21:\nMV CRASH @ N 50 W / W 700 N,LBT\n -  < 700/ 51>\nGRP:LF\nPRI:1\ncomment: CALLER ADV THEY ARE NEAR THE INTERSECTION AND A PASSERBY IS ADV THERE IS MOTORCYCLIST DOWN, NO OTHER VEH AROUND
(CAD Page) \n#130066585 - \nF17B03:\nFALLS @ 76 E US HWY 6 #261,LBT\nCROSS: btwn FARM RD and US6&SR49 A\nGRP:LF\nPRI:2\ncomment: Medical ProQA recommends dispatch at this time
(CAD Page) \n#130066505 - \nF21:\nMV CRASH @ 1046 N 100 E,LBT\nCROSS: btwn E 1050 N and E 1050 N\nGRP:LF\nPRI:1\ncomment: SOMEONE JUST HAD AN ACCIDENT OUTSIDE OF THE HOUSE...CAR STUCK TELEPHONE POLE.
(CAD Page) \n#130066342 - \nF17B03:\nFALLS @ 76 E US HWY 6 #261,LBT\nCROSS: btwn FARM RD and US6&SR49 A\nGRP:LF\nPRI:2\ncomment: 92YOF FELL INSIDE THE RES,COULD NOT SAY IF SHE WAS HURT OR NOT. BELIEVES SHE'S ALONE IN THE RES.KEY LOCATION, FROG IN THE FLOWER POT BY THE FRONT DOOR.LIFELINE/8882892018 REF/C-1607849 DIABETIC/HIGH BP/DIZZINESS-VERTIGO-ALERGIC TO CODIENE
(CAD Page) \n#130065753 - \nF26D01:\nSICK PER.(SPEC.DIAG) @ 436 E 900 N,JKT\nCROSS: btwn N 400 E and HIGH TOWER DR\nGRP:LF\nPRI:1\ncomment: Medical ProQA recommends dispatch at this time
(CAD Page) \n#130065305 - \nF21:\nMV CRASH @ N MERIDIAN RD / W US HWY 6,LBT\n -  < 800/ 1>\nGRP:LF\nPRI:1\ncomment: SIL PASS CAR /  UNK 2ND VEH
(CAD Page) \n#130065302 - \nF21:\nMV CRASH @ W 1050 N / N 50 W,LBT\n -  < 0/ 1048>\nGRP:LF\nPRI:1\ncomment: CAR/BICYCLE. LEG INJURIES.
(CAD Page) \n#130065230 - \nF5:\nBRUSH/GRASS FIRE @ 75 W US HWY 6,LBT\nCROSS: btwn N 75 W and N 125 W\nGRP:LF\nPRI:1\ncomment: CALLED IN BY PORTAGE EMS // LARGE BRUSH FIRE JUST SOUTH OF 6
(CAD Page) \n#130065070 - \nFE10:\nCHEST PAIN @ 411 SUNNYBROOKE CT,JKT\nCROSS: btwn N 400 E and DEAD END\nGRP:LF\nPRI:1\ncomment: 51 YOM UNCONS/NOT BREATHING

*/

public class INPorterCountyParserTest extends BaseParserTest {
  
  public INPorterCountyParserTest() {
    setParser(new INPorterCountyParser(), "PORTER COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:CAD Page\n\n#110089211 - \nF35P2:\nEMS AST-P2 @ 380 N 400 E,WGT\nCROSS: btwn AUGUSTINE DR and E 400 N\npcdisp@porterco-ps.orgGRP:WF\nPRI:2\ncomment: Medical P",
        "ID:110089211",
        "CODE:F35",
        "CALL:EMS AST-P2",
        "ADDR:380 N 400 E",
        "CITY:Washington Twp",
        "X:AUGUSTINE DR and E 400 N",
        "UNIT:WF",
        "PRI:2",
        "INFO:Medical P");

    doTest("T2",
        "Subject: CAD Page\n\n#110085268 - \nF35:\nMISC. AST EMS @ 4 WILLIAMSBURG DR,WGT\nCROSS: btwn DEAD END and VIRGINIA CT\nGRP:WF\nPRI:4\ncomment: UN",
        "ID:110085268",
        "CODE:F35",
        "CALL:MISC. AST EMS",
        "ADDR:4 WILLIAMSBURG DR",
        "CITY:Washington Twp",
        "X:DEAD END and VIRGINIA CT",
        "UNIT:WF",
        "PRI:4",
        "INFO:UN");

    doTest("T3",
        "Subject: CAD Page\n\n#110085607 -\nF35P2:\nEMS AST-P2 @ 342 N 325 E,WGT\nCROSS: btwn LONG PRAIRIE RD and STREAMWOOD DR GRP:WF\nPRI:2\ncomment:",
        "ID:110085607",
        "CODE:F35",
        "CALL:EMS AST-P2",
        "ADDR:342 N 325 E",
        "CITY:Washington Twp",
        "X:LONG PRAIRIE RD and STREAMWOOD DR",
        "UNIT:WF",
        "PRI:2");

    doTest("T4",
        "Subject: CAD Page\n\n#110086732 - \nF3:\nELECTRICAL FIRE @ 3705 VALE PARK RD,WGT\nCROSS: btwn ST RD 49 and BARTZ RD\nGRP:WF\nPRI:1\ncomment: 2 PO",
        "ID:110086732",
        "CODE:F3",
        "CALL:ELECTRICAL FIRE",
        "ADDR:3705 VALE PARK RD",
        "CITY:Washington Twp",
        "X:ST RD 49 and BARTZ RD",
        "UNIT:WF",
        "PRI:1",
        "INFO:2 PO");

    doTest("T5",
        "Subject: CAD Page\n\n#110086764 - \nF33:\nMANPOWER AST EMS @ 13 WILLIAMSBURG DR,WGT\nCROSS: btwn DEAD END and JAMESTOWN AV\nGRP:WF\nPRI:1\ncommen",
        "ID:110086764",
        "CODE:F33",
        "CALL:MANPOWER AST EMS",
        "ADDR:13 WILLIAMSBURG DR",
        "CITY:Washington Twp",
        "X:DEAD END and JAMESTOWN AV",
        "UNIT:WF",
        "PRI:1");

    doTest("T6",
        "Subject: CAD Page\n\n#110087784 - \nF35P2:\nEMS AST-P2 @ WASHINGTON TWP HIGH SCHOOL,WGT\n - at 383 E ST RD 2,WGT\nCROSS: btwn E EVANS AV and N",
        "ID:110087784",
        "CODE:F35",
        "PRI:2",
        "CALL:EMS AST-P2",
        "PLACE:WASHINGTON TWP HIGH SCHOOL",
        "ADDR:383 E ST RD 2",
        "MADDR:383 E IN 2",
        "CITY:Washington Twp",
        "X:E EVANS AV and N");

    doTest("T7",
        "Subject: CAD Page\n\n#110088677 - \nF41:\nMUT.AID/RESP. TO SCN @ 177 HEATHERHILL DR,CTT\nCROSS: btwn DEAD END and HACKNEY LN\nGRP:WF\nPRI:1\ncomm",
        "ID:110088677",
        "CODE:F41",
        "CALL:MUT.AID/RESP. TO SCN",
        "ADDR:177 HEATHERHILL DR",
        "CITY:Center Twp",
        "X:DEAD END and HACKNEY LN",
        "UNIT:WF",
        "PRI:1");

    doTest("T8",
        "Subject: CAD Page\n\n#110089211 - \nF35P2:\nEMS AST-P2 @ 380 N 400 E,WGT\nCROSS: btwn AUGUSTINE DR and E 400 N\nGRP:WF\nPRI:2\ncomment: Medical P",
        "ID:110089211",
        "CODE:F35",
        "CALL:EMS AST-P2",
        "ADDR:380 N 400 E",
        "CITY:Washington Twp",
        "X:AUGUSTINE DR and E 400 N",
        "UNIT:WF",
        "PRI:2",
        "INFO:Medical P");

    doTest("T9",
        "Subject: CAD Page\n\n#110089866 -\nE29\nMV CRASH/TRANS.ACC @ E US HWY 6 / EDMOND CT, LBT - < 0/ 801>\nGRP:PM\nPRI:1\ncomment: CAR VS PICKUP, CAR IS IN DITCH",
        "ID:110089866",
        "CODE:E29",
        "CALL:MV CRASH/TRANS.ACC",
        "ADDR:E US HWY 6 & EDMOND CT",
        "MADDR:E US 6 & EDMOND CT",
        "CITY:Liberty Twp",
        "UNIT:PM",
        "PRI:1",
        "INFO:CAR VS PICKUP, CAR IS IN DITCH");

    doTest("T10",
        "Subject:CAD Page\n\n#110120370 - \nF5:\nBRUSH/GRASS FIRE @ E ENGEL DR / CAIN DR,WGT\n-  < 3900/ 1>\nGRP:WF\nPRI:1\ncomment: OPEN BURN IN AREA/",
        "ID:110120370",
        "CODE:F5",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:E ENGEL DR & CAIN DR",
        "CITY:Washington Twp",
        "UNIT:WF",
        "PRI:1",
        "INFO:OPEN BURN IN AREA/");

    doTest("T11",
        "Subject:CAD Page\n\n#110127635 - \nF35:\nMISC. AST EMS @ PILOT TRAVEL CENTER,WGT\n- at 4105 E MORTHLAND DR,WGT\nCROSS: near DEAD END\nGRP:WF\nP",
        "ID:110127635",
        "CODE:F35",
        "CALL:MISC. AST EMS",
        "PLACE:PILOT TRAVEL CENTER",
        "ADDR:4105 E MORTHLAND DR",
        "CITY:Washington Twp",
        "X:near DEAD END",
        "UNIT:WF");

    doTest("T12",
        "Subject:CAD Page\n\n#110137072 - \nF35P1:\nEMS AST-P1 @ 429 E ST RD 2,WGT\nCROSS: btwn N 400 E and N 450 E\nGRP:WF\nPRI:1\ncomment: Medical ProQ",
        "ID:110137072",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:429 E ST RD 2",
        "MADDR:429 E IN 2",
        "CITY:Washington Twp",
        "X:N 400 E and N 450 E",
        "UNIT:WF",
        "PRI:1",
        "INFO:Medical ProQ");

    doTest("T13",
        "Subject:CAD Page\n\n#110166809 - \nF35P1:\nEMS AST-P1 @ 53 ASPEN RD,OGD\nCROSS: btwn BITTERSWEET LN and OGDEN RD\nGRP:OF\nPRI:1\ncomment: Medica ",
        "ID:110166809",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:53 ASPEN RD",
        "CITY:Ogden Dunes",
        "X:BITTERSWEET LN and OGDEN RD",
        "UNIT:OF",
        "PRI:1",
        "INFO:Medica");

    doTest("T14",
        "Subject:CAD Page\n\n" +
        "#120036045 - \n" +
        "F35:\n" +
        "MISC. AST EMS @ 253-1 N ST RD 2,WGT\n" +
        "CROSS: btwn RIGG RD and E 300 N\n" +
        "GRP:WF\n" +
        "PRI:1\n" +
        "comment: COMPLAINI\r",

        "ID:120036045",
        "CODE:F35",
        "CALL:MISC. AST EMS",
        "ADDR:253-1 N ST RD 2",
        "MADDR:253 N IN 2",
        "CITY:Washington Twp",
        "X:RIGG RD and E 300 N",
        "UNIT:WF",
        "PRI:1",
        "INFO:COMPLAINI");

    doTest("T15",
        "(CAD Page) #120048030 - \n" +
        "E32:\n" +
        "UNK.PROB.(MAN DOWN) @ MM22,BHB\n" +
        "- at 240 I94,BHB\n" +
        "CROSS: btwn I94&US20 D and ST RD 149\n" +
        "GRP:PM\n" +
        "PRI:1\n" +
        "comment: I 94 WESTBOUND 22 M",

        "ID:120048030",
        "CODE:E32",
        "CALL:UNK.PROB.(MAN DOWN)",
        "PLACE:MM22",
        "ADDR:240 I94",
        "MADDR:240 I 94",
        "CITY:Burns Harbor",
        "X:I94&US20 D and ST RD 149",
        "UNIT:PM",
        "PRI:1",
        "INFO:I 94 WESTBOUND 22 M");

    doTest("T16",
        "(CAD Page) #120065003 - \n" +
        "F35P1:\n" +
        "EMS AST-P1 @ 1118 WINTER PARK DR,LBT\n" +
        "CROSS: btwn ASPEN DR and SUN VALLEY DR\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: Medical ProQA recommends di",

        "ID:120065003",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:1118 WINTER PARK DR",
        "CITY:Liberty Twp",
        "X:ASPEN DR and SUN VALLEY DR",
        "UNIT:LF",
        "PRI:1",
        "INFO:Medical ProQA recommends di");

    doTest("T17",
        "Subject:CAD Page\n\n" +
        "#120110035 - \n" +
        "F51:\n" +
        "ALARM:SMOKE/FIRE/CO @ 463 E US HWY 30,WGT\n" +
        "CROSS: btwn N 450 E and N 575 E\n" +
        "GRP:WF\n" +
        "PRI:1\n" +
        "comment: ACT\r",

        "UNIT:WF",
        "ID:120110035",
        "CODE:F51",
        "CALL:ALARM:SMOKE/FIRE/CO",
        "ADDR:463 E US HWY 30",
        "MADDR:463 E US 30",
        "CITY:Washington Twp",
        "X:N 450 E and N 575 E",
        "PRI:1",
        "INFO:ACT");
  }
  
  @Test
  public void testLakeCounty() {
    
    setDefaults("LAKE COUNTY", "IN");

    doTest("T1",
        "Subject:LOFS\n" +
        "F32:\n" +
        "RESP.ARR.AST EMS @ CHICAGOLAND CHRISTIAN VILLAGE,WNT\n" +
        "- at 6685 E 117TH AV,WNT\n" +
        "CROSS: btwn GIBSON ST and JAY ST\n" +
        "-\r",

        "SRC:LOFS",
        "CODE:F32",
        "CALL:RESP.ARR.AST EMS",
        "PLACE:CHICAGOLAND CHRISTIAN VILLAGE",
        "ADDR:6685 E 117TH AV",
        "MADDR:6685 E 117TH AVE",
        "CITY:Winfield Twp",
        "X:GIBSON ST and JAY ST");
 }
  
  @Test
  public void testTomShapen() {

    doTest("T1",
        "(CAD Page)\n" +
        "#130001233 - \n" +
        "F32:\n" +
        "RESP.ARR.AST EMS @ 76 W US HWY 6 #81,LBT\n" +
        "CROSS: btwn N 75 W and N 125 W\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: CALLED 911 UNKNOWN PROBLEM",

        "UNIT:LF",
        "ID:130001233",
        "CODE:F32",
        "CALL:RESP.ARR.AST EMS",
        "ADDR:76 W US HWY 6",
        "MADDR:76 W US 6",
        "APT:81",
        "CITY:Liberty Twp",
        "X:N 75 W and N 125 W",
        "PRI:1",
        "INFO:CALLED 911 UNKNOWN PROBLEM");

  }
  
  @Test
  public void testPorterFire() {

    doTest("T1",
        "(CAD Page) \n" +
        "#130016058 - \n" +
        "F27:\n" +
        "DROWNING RESCUE @ 7501 BELSHAW\n" +
        "GRP:FS\n" +
        "PRI:1\n" +
        "comment: ROLLOVER PI..VEH IN CREEK.10-0 ON SITE..UNK IF THERE'S OTHERS IN VEH...ST RD 2 TO JOE MARTIN RD..GO SOUTH TO THE \"T\" THEN RIGHT ON BELSHAW",

        "UNIT:FS",
        "ID:130016058",
        "CODE:F27",
        "CALL:DROWNING RESCUE",
        "ADDR:7501 BELSHAW",
        "PRI:1",
        "INFO:ROLLOVER PI..VEH IN CREEK.10-0 ON SITE..UNK IF THERE'S OTHERS IN VEH...ST RD 2 TO JOE MARTIN RD..GO SOUTH TO THE \"T\" THEN RIGHT ON BELSHAW");

    doTest("T2",
        "(CAD Page) \n" +
        "#130017162 - \n" +
        "F35P1:\n" +
        "EMS AST-P1 @ 246 BAILEY STATION RD,DAC\n" +
        "CROSS: btwn BAILY GENERATING STA and BAILLY GENERATING STA\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: REQ AMBULANCE/LACERATION IN THE MACHINE SHOP/MALE/",

        "UNIT:PF",
        "ID:130017162",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:246 BAILEY STATION RD",
        "CITY:Dune Acres",
        "X:BAILY GENERATING STA and BAILLY GENERATING STA",
        "PRI:1",
        "INFO:REQ AMBULANCE/LACERATION IN THE MACHINE SHOP/MALE/");

    doTest("T3",
        "(CAD Page) \n" +
        "#130017015 - \n" +
        "F21:\n" +
        "MV CRASH @ INDIANA DUNES STATE PARK ENTRANCE,WCT\n" +
        " - at 1530 N 25 E,WCT\n" +
        "CROSS: btwn STATE PARK RD and DEAD END\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: SUBJECT HIT A BUILDING HEAD WENT THROUGH WINDSHIELD",

        "UNIT:PF",
        "ID:130017015",
        "CODE:F21",
        "CALL:MV CRASH",
        "PLACE:INDIANA DUNES STATE PARK ENTRANCE",
        "CITY:Westchester Twp",
        "ADDR:1530 N 25 E",
        "X:STATE PARK RD and DEAD END",
        "PRI:1",
        "INFO:SUBJECT HIT A BUILDING HEAD WENT THROUGH WINDSHIELD");

    doTest("T4",
        "(CAD Page) \n" +
        "#130016721 - \n" +
        "F15:\n" +
        "SCHOOL BUILDING FIRE @ CHESTERTON HIGH SCHOOL,CHE\n" +
        " - at 2125 S 11TH ST,CHE\n" +
        "CROSS: btwn W 1100 N and E 1050 N\n" +
        "GRP:CF\n" +
        "PRI:1\n" +
        "comment: AUTOMATED SYSTEM // FIRE ALARM",

        "UNIT:CF",
        "ID:130016721",
        "CODE:F15",
        "CALL:SCHOOL BUILDING FIRE",
        "PLACE:CHESTERTON HIGH SCHOOL",
        "CITY:Chesterton",
        "ADDR:2125 S 11TH ST",
        "X:W 1100 N and E 1050 N",
        "PRI:1",
        "INFO:AUTOMATED SYSTEM // FIRE ALARM");

    doTest("T5",
        "(CAD Page) \n" +
        "#130016046 - \n" +
        "F32:\n" +
        "RESP.ARR.AST EMS @ 310 MICHIGAMI TRL,PTR\n" +
        "CROSS: btwn CHIEF CIR and STRONGBOW TRL\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: FELL YESTERDAY / BACK PAIN / 53 YOM DIFF BREATHING/ PRO Q/A WENT DOWN",

        "UNIT:PF",
        "ID:130016046",
        "CODE:F32",
        "CALL:RESP.ARR.AST EMS",
        "ADDR:310 MICHIGAMI TRL",
        "CITY:Porter",
        "X:CHIEF CIR and STRONGBOW TRL",
        "PRI:1",
        "INFO:FELL YESTERDAY / BACK PAIN / 53 YOM DIFF BREATHING/ PRO Q/A WENT DOWN");

    doTest("T6",
        "(CAD Page) \n" +
        "#130015942 - \n" +
        "F35P1:\n" +
        "EMS AST-P1 @ 20 FRANKLIN ST,PTR\n" +
        "CROSS: btwn SEXTON AV and WAGNER RD\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: 73 YOF NOSEBLEED",

        "UNIT:PF",
        "ID:130015942",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:20 FRANKLIN ST",
        "CITY:Porter",
        "X:SEXTON AV and WAGNER RD",
        "PRI:1",
        "INFO:73 YOF NOSEBLEED");

    doTest("T7",
        "(CAD Page) \n" +
        "#130015685 - \n" +
        "F32:\n" +
        "RESP.ARR.AST EMS @ 1209 WAGNER RD,PTR\n" +
        "CROSS: btwn W OAKHILL RD and DUNE MEADOWS DR\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: Medical ProQA recommends dispatch at this time",

        "UNIT:PF",
        "ID:130015685",
        "CODE:F32",
        "CALL:RESP.ARR.AST EMS",
        "ADDR:1209 WAGNER RD",
        "CITY:Porter",
        "X:W OAKHILL RD and DUNE MEADOWS DR",
        "PRI:1",
        "INFO:Medical ProQA recommends dispatch at this time");

    doTest("T8",
        "(CAD Page) \n" +
        "#130015487 - \n" +
        "F35P1:\n" +
        "EMS AST-P1 @ 433 W US HWY 20,PTR\n" +
        "CROSS: btwn W OAKHILL RD and WAGNER RD\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: Medical ProQA recommends dispatch at this time",

        "UNIT:PF",
        "ID:130015487",
        "CODE:F35",
        "CALL:EMS AST-P1",
        "ADDR:433 W US HWY 20",
        "MADDR:433 W US 20",
        "CITY:Porter",
        "X:W OAKHILL RD and WAGNER RD",
        "PRI:1",
        "INFO:Medical ProQA recommends dispatch at this time");

    doTest("T9",
        "(CAD Page) \n" +
        "#130015200 - \n" +
        "F21:\n" +
        "MV CRASH @ MM21,BHB\n" +
        " - at 340 I94,BHB\n" +
        "CROSS: btwn ST RD 149 and JENSEN DR\n" +
        "GRP:BH\n" +
        "PRI:1\n" +
        "comment: SILVER VEHICLE VS WALL/ W/B  FEMALE STRUCK HER HEAD/ ISP ALREADY AWARE",

        "UNIT:BH",
        "ID:130015200",
        "CODE:F21",
        "CALL:MV CRASH",
        "PLACE:MM21",
        "CITY:Burns Harbor",
        "ADDR:340 I94",
        "MADDR:340 I 94",
        "X:ST RD 149 and JENSEN DR",
        "PRI:1",
        "INFO:SILVER VEHICLE VS WALL/ W/B  FEMALE STRUCK HER HEAD/ ISP ALREADY AWARE");

    doTest("T10",
        "(CAD Page) \n" +
        "#130015179 - \n" +
        "F32:\n" +
        "RESP.ARR.AST EMS @ 950 W OAKHILL RD,PTR\n" +
        "CROSS: btwn WAGNER RD and N MINERAL SPRINGS RD\n" +
        "GRP:PF\n" +
        "PRI:1\n" +
        "comment: 75 YOF CONSC / DIFF BREATHING / COPD",

        "UNIT:PF",
        "ID:130015179",
        "CODE:F32",
        "CALL:RESP.ARR.AST EMS",
        "ADDR:950 W OAKHILL RD",
        "CITY:Porter",
        "X:WAGNER RD and N MINERAL SPRINGS RD",
        "PRI:1",
        "INFO:75 YOF CONSC / DIFF BREATHING / COPD");

  }
  
  @Test
  public void testLibertyTwpFire() {

    doTest("T1",
        "(CAD Page) \n" +
        "#130066994 - \n" +
        "F12A01:\n" +
        "CONVULS./SEIZURES @ 1209 ASPEN DR,LBT\n" +
        "CROSS: btwn WINTER PARK DR and SUN VALLEY DR\n" +
        "GRP:LF\n" +
        "PRI:4\n" +
        "comment: Medical ProQA recommends dispatch at this time",

        "ID:130066994",
        "CODE:F12A01",
        "PRI:4",
        "CALL:CONVULS./SEIZURES",
        "ADDR:1209 ASPEN DR",
        "CITY:Liberty Twp",
        "X:WINTER PARK DR and SUN VALLEY DR",
        "UNIT:LF",
        "INFO:Medical ProQA recommends dispatch at this time");

    doTest("T2",
        "(CAD Page) \n" +
        "#130066832 - \n" +
        "F21:\n" +
        "MV CRASH @ N 50 W / W 700 N,LBT\n" +
        " -  < 700/ 51>\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: CALLER ADV THEY ARE NEAR THE INTERSECTION AND A PASSERBY IS ADV THERE IS MOTORCYCLIST DOWN, NO OTHER VEH AROUND",

        "ID:130066832",
        "CODE:F21",
        "PRI:1",
        "CALL:MV CRASH",
        "ADDR:N 50 W & W 700 N",
        "CITY:Liberty Twp",
        "UNIT:LF",
        "INFO:CALLER ADV THEY ARE NEAR THE INTERSECTION AND A PASSERBY IS ADV THERE IS MOTORCYCLIST DOWN, NO OTHER VEH AROUND");

    doTest("T3",
        "(CAD Page) \n" +
        "#130066585 - \n" +
        "F17B03:\n" +
        "FALLS @ 76 E US HWY 6 #261,LBT\n" +
        "CROSS: btwn FARM RD and US6&SR49 A\n" +
        "GRP:LF\n" +
        "PRI:2\n" +
        "comment: Medical ProQA recommends dispatch at this time",

        "ID:130066585",
        "CODE:F17B03",
        "PRI:2",
        "CALL:FALLS",
        "ADDR:76 E US HWY 6",
        "MADDR:76 E US 6",
        "APT:261",
        "CITY:Liberty Twp",
        "X:FARM RD and US6&SR49 A",
        "UNIT:LF",
        "INFO:Medical ProQA recommends dispatch at this time");

    doTest("T4",
        "(CAD Page) \n" +
        "#130066505 - \n" +
        "F21:\n" +
        "MV CRASH @ 1046 N 100 E,LBT\n" +
        "CROSS: btwn E 1050 N and E 1050 N\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: SOMEONE JUST HAD AN ACCIDENT OUTSIDE OF THE HOUSE...CAR STUCK TELEPHONE POLE.",

        "ID:130066505",
        "CODE:F21",
        "PRI:1",
        "CALL:MV CRASH",
        "ADDR:1046 N 100 E",
        "CITY:Liberty Twp",
        "X:E 1050 N and E 1050 N",
        "UNIT:LF",
        "INFO:SOMEONE JUST HAD AN ACCIDENT OUTSIDE OF THE HOUSE...CAR STUCK TELEPHONE POLE.");

    doTest("T5",
        "(CAD Page) \n" +
        "#130066342 - \n" +
        "F17B03:\n" +
        "FALLS @ 76 E US HWY 6 #261,LBT\n" +
        "CROSS: btwn FARM RD and US6&SR49 A\n" +
        "GRP:LF\n" +
        "PRI:2\n" +
        "comment: 92YOF FELL INSIDE THE RES,COULD NOT SAY IF SHE WAS HURT OR NOT. BELIEVES SHE'S ALONE IN THE RES.KEY LOCATION, FROG IN THE FLOWER POT BY THE FRONT DOOR.LIFELINE/8882892018 REF/C-1607849 DIABETIC/HIGH BP/DIZZINESS-VERTIGO-ALERGIC TO CODIENE",

        "ID:130066342",
        "CODE:F17B03",
        "PRI:2",
        "CALL:FALLS",
        "ADDR:76 E US HWY 6",
        "MADDR:76 E US 6",
        "APT:261",
        "CITY:Liberty Twp",
        "X:FARM RD and US6&SR49 A",
        "UNIT:LF",
        "INFO:92YOF FELL INSIDE THE RES,COULD NOT SAY IF SHE WAS HURT OR NOT. BELIEVES SHE'S ALONE IN THE RES.KEY LOCATION, FROG IN THE FLOWER POT BY THE FRONT DOOR.LIFELINE/8882892018 REF/C-1607849 DIABETIC/HIGH BP/DIZZINESS-VERTIGO-ALERGIC TO CODIENE");

    doTest("T6",
        "(CAD Page) \n" +
        "#130065753 - \n" +
        "F26D01:\n" +
        "SICK PER.(SPEC.DIAG) @ 436 E 900 N,JKT\n" +
        "CROSS: btwn N 400 E and HIGH TOWER DR\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: Medical ProQA recommends dispatch at this time",

        "ID:130065753",
        "CODE:F26D01",
        "PRI:1",
        "CALL:SICK PER.(SPEC.DIAG)",
        "ADDR:436 E 900 N",
        "CITY:Jackson Twp",
        "X:N 400 E and HIGH TOWER DR",
        "UNIT:LF",
        "INFO:Medical ProQA recommends dispatch at this time");

    doTest("T7",
        "(CAD Page) \n" +
        "#130065305 - \n" +
        "F21:\n" +
        "MV CRASH @ N MERIDIAN RD / W US HWY 6,LBT\n" +
        " -  < 800/ 1>\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: SIL PASS CAR /  UNK 2ND VEH",

        "ID:130065305",
        "CODE:F21",
        "PRI:1",
        "CALL:MV CRASH",
        "ADDR:N MERIDIAN RD & W US HWY 6",
        "MADDR:N MERIDIAN RD & W US 6",
        "CITY:Liberty Twp",
        "UNIT:LF",
        "INFO:SIL PASS CAR /  UNK 2ND VEH");

    doTest("T8",
        "(CAD Page) \n#130065302 - \nF21:\nMV CRASH @ W 1050 N / N 50 W,LBT\n -  < 0/ 1048>\nGRP:LF\nPRI:1\ncomment: CAR/BICYCLE. LEG INJURIES.",
        "ID:130065302",
        "CODE:F21",
        "PRI:1",
        "CALL:MV CRASH",
        "ADDR:W 1050 N & N 50 W",
        "CITY:Liberty Twp",
        "UNIT:LF",
        "INFO:CAR/BICYCLE. LEG INJURIES.");

    doTest("T9",
        "(CAD Page) \n" +
        "#130065230 - \n" +
        "F5:\n" +
        "BRUSH/GRASS FIRE @ 75 W US HWY 6,LBT\n" +
        "CROSS: btwn N 75 W and N 125 W\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: CALLED IN BY PORTAGE EMS // LARGE BRUSH FIRE JUST SOUTH OF 6",

        "ID:130065230",
        "CODE:F5",
        "PRI:1",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:75 W US HWY 6",
        "MADDR:75 W US 6",
        "CITY:Liberty Twp",
        "X:N 75 W and N 125 W",
        "UNIT:LF",
        "INFO:CALLED IN BY PORTAGE EMS // LARGE BRUSH FIRE JUST SOUTH OF 6");

    doTest("T10",
        "(CAD Page) \n" +
        "#130065070 - \n" +
        "FE10:\n" +
        "CHEST PAIN @ 411 SUNNYBROOKE CT,JKT\n" +
        "CROSS: btwn N 400 E and DEAD END\n" +
        "GRP:LF\n" +
        "PRI:1\n" +
        "comment: 51 YOM UNCONS/NOT BREATHING",

        "ID:130065070",
        "CODE:FE10",
        "PRI:1",
        "CALL:CHEST PAIN",
        "ADDR:411 SUNNYBROOKE CT",
        "CITY:Jackson Twp",
        "X:N 400 E and DEAD END",
        "UNIT:LF",
        "INFO:51 YOM UNCONS/NOT BREATHING");
   
  }
  
  public static void main(String[] args) {
    new INPorterCountyParserTest().generateTests("T1");
  }
}