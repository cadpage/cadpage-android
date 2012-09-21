package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Guilford County, NC
Contact: Shane Taylor <dstaylor9@gmail.com>
Sender: @edispatches.com 
System: OSSI CAD?
[summerfieldfiredist Jan24-10:01]  CAD:SMFD;ST09;1;52C03C;FIRAL;7607 BLUE SAGE CT
[summerfieldfiredist Jan19-18:15]  CAD:SMFD;ST29;1;50PI;SCALESVILLE RD/LAKE BRANDT RD
[summerfieldfiredist Jan18-19:08]  CAD:1;MUTUAL;150 WAYNOR DR;GALLENT RD;STRUCTURE FIRE
(summerfieldfiredist Jan18-17:00) CAD:SMFD;ST29;1;25D01;PSYCH;8579 HUDSON JAMES RD;WRIGHTS FARM LN
[summerfieldfiredist Jan18-03:16]  CAD:SMFD;ST39;1;29B01;50PI;PLAINFIELD RD/LAKE BRANDT RD;BETWEEN LAKE BRANDT AND CHURCH ST
(summerfieldfiredist Jan21-03:25) CAD:SMFD;ST09;1;67B01;OSFIR;2523 PLEASANT RIDGE RD;SADDLEWOOD DR;DIST: 35.58 FT
(summerfieldfiredist Jan23-06:49) CAD:SMFD;ST39;1;17B03;FALL;6251 LAKE BRANDT RD;HI-LO LN
[summerfieldfiredist Jan23-19:20]  CAD:OKRD;ST51;1;69D11;STRUC;4529 PEEPLES RD;RIDING TRAIL CT
[summerfieldfiredist Jan23-19:18]  CAD:OKRD;ST51;1;STRUC;4529 PEEPLES RD;RIDING TRAIL CT
[summerfieldfiredist Jan23-20:23]  CAD:OKRD;ST51;1;69D06;STRUC;5371 NORTHWEST SCHOOL RD;TRAIL PIEDMONT GREENWAY
(summerfieldfiredist Jan24-10:31) CAD:UNDER CONTROL;7607 BLUE SAGE CT; SU
(summerfieldfiredist Jan23-11:25) CAD:UNDER CONTROL;6308 PEPPERMILL DR; OAK
(summerfieldfiredist Jan23-19:48) CAD:UNDER CONTROL;4529 PEEPLES RD; OAK
(summerfieldfiredist Jun10-01:00) summerfieldfiredist\nCAD:UNDER CONTROL;5322 BUNCH RD; SU
(summerfieldfiredist Jun10-19:27) summerfieldfiredist\nCAD:FD13;ST58;1;60C02;GAS;210 JAMES DOAK PKWY;BRIXHAM DR

Contact: krpaschal@gmail.com <krpaschal@gmail.com>
Sender: CAD@greensboro-nc.gov
CAD@greensboro-nc.gov:CAD:CODE 47;7700 NEWSOME CT; B;CARDIAC / RESPIRATORY ARREST

Contact: "Michael Capps" <firefightercapps@yahoo.com>
FRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun11-00:23\nMSG:summerfieldfiredist\nCAD:UNDER CONTROL;210 JAMES DOAK PKWY; G\n
1 of 2\nFRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun17-16:22\nMSG:summerfieldfiredist\nCAD:OPA4;OPA4;1;MEDEM;5570 US 220 N;M AND M\n(Con't) 2 of 2\nTIRE AND AUTOMOTIVE;SPOTSWOOD RD\n(End)
FRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun17-14:57\nMSG:summerfieldfiredist\nCAD:SMFD;ST39;1;09E02;CARDIA;5718 OAK TREE RD;AIR HARBOR RD\n

Contact: Greg Creech <gcreech1551@gmail.com>
CAD:UNDER CONTROL;878 CROSSCREEK RD; K ;. [27]

Contact: Matt Young <myoung92939@gmail.com>
Contact: John Stanley <summerfield248@gmail.com>
Contact:Brian Bradley <bkbradley@gmail.com>
Sender: dispatch@edispatches.com
Subject:summerfieldfiredist Aug06-16:44\nsummerfieldfiredist \nCAD:SMFD;ST09;1;31D02;UNCON;7912 SUMMERFIELD RD;FAIRGROVE BAPTIST CHURCH; 
Subject:summerfieldfiredist Aug06-06:57\nsummerfieldfiredist \nCAD:OKRD;ST15;1;69D03;STRUC;8005 MARKETPLACE DR;TRACTOR SUPPLY CO;NC 68 N 
Subject:summerfieldfiredist Aug08-11:36\nsummerfieldfiredist \nCAD:SMFD;ST39;1;19D01;HEART;1007 NC 150 W;SPEAR CLINIC;LAKE BRANDT RD;ROO 
Subject:summerfieldfiredist Aug23-03:00\nsummerfieldfiredist\nCAD:SMFD;ST29;1;18C04;HEAD;8562 HUDSON JAMES RD;WRIGHTS FARM LN\n
Subject:summerfieldfiredist Aug23-02:49\nsummerfieldfiredist\nCAD:SMFD;ST09;1;25B03;PSYCH;7619 BRISBANE DR;OAK RIDGE RD\n
Subject:summerfieldfiredist Aug21-19:49\nsummerfieldfiredist\nCAD:SMFD;ST09;1;23C02A;OVDOSE;2307 SCALESVILLE RD;ROBINSON RD;HOUSE\n
Subject:summerfieldfiredist Aug21-16:02\nsummerfieldfiredist\nCAD:OKRD;ST51;1;STRUC;6401 W BELGRAVE TER\n
S:summerfieldfiredist Oct17-12:45 M:summerfieldfiredist\nCAD:UNDER CONTROL;808 JAMES DOAK PKWY; G\n\n
Subject:summerfieldfiredist Oct17-13:50\nsummerfieldfiredist\nCAD:SMFD;ST29;1;MED;180 QUAL RIDGE RD;SADDLEBROOK DR\n
S:summerfieldfiredist Oct21-13:14 M:summerfieldfiredist\nCAD:CODE 47;330 GEMSTONE LOOP; ROCK;ST 29 CARDIAC ARREST CALL\n\n

Contact: Jamie Burgess <jrburgess87@gmail.com>
Sender: 93001024 
CAD@greensboro-nc.gov:CAD:MCVL;ST37;1;60B01;GAS;922 GOLF HOUSE ROAD EAST;HADDINGTON RD;ACROSS FROM THIS ADDRESS

Contact: Brian Bradley <bkbradley@gmail.com>
Subject:summerfieldfiredist Oct27-23:05\nsummerfieldfiredist\nCAD:UNDER CONTROL;300 NIBLICK DR; ROCK;REF FALL\n
Subject:summerfieldfiredist Nov06-22:05\nsummerfieldfiredist\nCAD:SMFD;ST09;1;STROKE;5109 MEDEARIS ST;AYERS LN\n

Contact: Jenna Daniels <ffjdaniels@gmail.com>
Sender: dispatch@edispatches.com
Subject:summerfieldfiredist Nov26-03:56\nsummerfieldfiredist\nCAD:SMFD;ST29;1;MED;132 LAKE DR;OLD MILL DR\n
Subject:summerfieldfiredist Nov27-19:50\nsummerfieldfiredist\nCAD:SMFD;ST29;1;OSFIR;1359 SCALESVILLE RD;CARTER FARM RD\n

Contact: Jamie Burgess <jrburgess87@gmail.com>
Contact: Craig Hollar <spanky4142@gmail.com>
Sender: firedistrict13@listserve.com
Subject:[Firedistrict13] (no subject)\nCAD:UNDER CONTROL;616 SIMPSON-CALHOUN RD; G ;TAC 10\n\n_____________________________________
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;29D02p;50PI;US 29 N/HICONE RD;29 NB NORTH OF HICONE\n\n_____________________
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST58;1;26B01;SICK;7830 SUTTER RD;NC 150 W\n\n______________________________________
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;03D00;ANBITE;2706 BRAME RD;WHITE ELDER RD;DIST: 245.80 FT\n\n_______________
Subject:[Firedistrict13] (no subject)\nCAD:UNDER CONTROL;2706 BRAME RD; G ;DIST: 245.80 FT\n\n_____________________________________
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;29D02p;50PI;US 29 N/HICONE RD;29 NB NORTH OF HICONE\n\n_____________________
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST13;1;FIRAL;5207 OLD MINE RD\n\n_______________________________________________\nF
Subject:[Firedistrict13] (no subject)\nCAD:NEFD;ST32;1;EXPLO;6303 THREE LOY RD\n\n_______________________________________________\n
Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;FIRAL;4006 STARLING CT\n\n_______________________________________________\nF
Subject:[Firedistrict13] (no subject)\nCAD:NEFD;ST33;1;52B01S;FIRAL;7707 FRENCH DR;YANCEYVILLE RD;JOHNSON WILLIMS\n\n______________

Contact: Active911
???
Contact: Active911.com
Agency name: Stokesdale Fire Department Location: Stokesdale, NC 
From: CAD@greensboro-nc.gov
CAD:STKD;ST12;1;SICK;7717 ATHENS RD;SOUTHERN MEADOWS DR;26C02
CAD:UNDER CONTROL;7717 ATHENS RD; ST
CAD:SMFD;ST29;1;OSFIR;US 158/HUDSON RD;67D02B
CAD:STKD;ST12;1;FIRAST;7848 US 158;ATHENS RD
CAD:UNDER CONTROL;7848 US 158; ST
CAD:STKD;ST12;1;MED;1895 GIDEON GROVE CHURCH RD;EDDIES TR;CHEST PAIN
CAD:UNDER CONTROL;1895 GIDEON GROVE CHURCH RD; ROCK; CHEST PAIN
CAD:OKRD;ST15;1;50PI;NC 68 N/FOGLEMAN RD;29B04
CAD:STKD;ST12;1;STROKE;8971 OSAGE RD;TYSOR RD
CAD:UNDER CONTROL;8971 OSAGE RD; ROCK
CAD:STKD;ST12;1;MED;160 SEVEN CREEKS DR;FOREST RIDGE DR;CHEST PAIN
CAD:UNDER CONTROL;160 SEVEN CREEKS DR; ROCK;CHEST PAIN
CAD:STKD;ST12;1;STROKE;7700 US 158;COUNTRYSIDE MANOR;ATHENS RD;ROOM A10 ASSISTED LIVING;28C10U
CAD:UNDER CONTROL;7700 US 158; ST ;ROOM A10 ASSISTED LIVING
CAD:STKD;ST12;1;ABDOM;7242 US 158;B & G CT;01C05
CAD:UNDER CONTROL;7242 US 158; ST
CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;DIST: 33.67 FT;29B01
CAD:STKD;ST12;1;ANBITE;8255 CURRAGHMORE CT;STOKESDALE PARK;CURRAGHMORE DR;DIST: 517.83 ft;03D00
CAD:UNDER CONTROL;8255 CURRAGHMORE CT; ST ;DIST: 517.83 ft
CAD:1;MUTUAL;13863 US 158;GLENCOE CHURCH LOOP;FIRE ALARM
CAD:STKD;ST12;1;FIRAST;435 HUMPHREYS RIDGE DR;HUMPHREYS RIDGE MARINA;WEST RIDGE CIR
CAD:UNDER CONTROL;435 HUMPHREYS RIDGE DR; ROCK
CAD:STKD;ST12;1;BREATH;8129 FLATROCK RD;06D02
CAD:UNDER CONTROL;8129 FLATROCK RD; ST
CAD:STKD;ST12;1;UNCON;7848 US 158;ATHENS RD;31C00
CAD:UNDER CONTROL;7848 US 158; ST
CAD:STKD;ST12;1;MED;8306 PATRICIA DR;US 158
CAD:STKD;ST12;1;MED;8312 SOUTHARD RD;US 158;HOUSE
CAD:UNDER CONTROL;8306 PATRICIA DR; ST
CAD:STKD;ST12;1;MEDEM;8312 SOUTHARD RD;US 158;HOUSE
CAD:UNDER CONTROL;8312 SOUTHARD RD; ST ;HOUSE
CAD:STKD;ST12;1;MED;151 DIONNE WAY;MOUNT ZION CHURCH RD;21-D-3 HEMORRHAGE
CAD:UNDER CONTROL;151 DIONNE WAY; ROCK;21-D-3 HEMORRHAGE
CAD:1;MUTUAL;361 SARDIS CHURCH RD;LINDSEY BRIDGE RD;FIRE ALARM
CAD:STKD;ST12;1;50PI;8945 BELEWS CREEK RD;SHEDAN RD;DIST: 109.55 ft;29D02l
CAD:UNDER CONTROL;8945 BELEWS CREEK RD; ST ;DIST: 109.55 ft
CAD:STKD;ST12;1;FIRAST;US 158/BELEWS CREEK RD
CAD:CANCEL;US 158/BELEWS CREEK RD; ST
CAD:STKD;ST12;1;FALL;8303 KNIGHT VILLAGE CIR;ATHENS RD;HOUSE;17B03
CAD:UNDER CONTROL;8303 KNIGHT VILLAGE CIR; ST ;HOUSE
CAD:STKD;ST12;1;BLEED;8108 BAYWOOD DR;NC 68 N;21D04
CAD:UNDER CONTROL;8108 BAYWOOD DR; ST
CAD:STKD;ST12;1;SEIZUR;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST
CAD:UNDER CONTROL;8401 US 158; ST
CAD:1;MUTUAL;SIMPSON RD/GIDEON GROVE CHURCH RD
CAD:1;MUTUAL;SIMPSON RD/GIDEON GROVE CHURCH RD;STRUCT
CAD:OKRD;ST15;1;FIRAL;8315 HAW RIVER RD;ANTHONY RD
CAD:UNDER CONTROL;8315 HAW RIVER RD; OAK
CAD:STKD;ST12;1;MED;366 FRIDDLE RD;PIN OAK DR;FALL
CAD:STKD;ST12;1;FIRAST;366 FRIDDLE RD;PIN OAK DR;CARDIAC
CAD:UNDER CONTROL;366 FRIDDLE RD; ROCK;CARDIAC
CAD:STKD;ST12;1;FALL;7258 US 158;B & G CT;17B01G
CAD:UNDER CONTROL;7258 US 158; ST
CAD:STKD;ST12;1;FIRAST;4860 ELLISBORO RD;CAROUSEL LN
CAD:UNDER CONTROL;4860 ELLISBORO RD; ROCK
CAD:OKRD;ST15;1;FIRAL;2205 OAK RIDGE RD;LOWES FOOD;CADET DR;SUITE B
CAD:STKD;ST12;1;STRUC;8107 DORSETT DOWNS DR;WESSEX DR;HOUSE;69D06
CAD:STKD;ST12;1;BURN;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST
CAD:UNDER CONTROL;8401 US 158; ST
CAD:STKD;ST12;1;SERV;3774 ELLISBORO RD;WOODFORD LN
CAD:STKD;ST12;1;50PI;564 NC 68 N;SYLVANIA RD;10-50 UNKN
CAD:UNDER CONTROL;564 NC 68 N; ROCK;10-50 UNKN
CAD:STKD;ST12;1;STRUC;4329 ELLISBORO RD;RENN RD;ROCKINGHAM
CAD:UNDER CONTROL;4329 ELLISBORO RD; ROCK
CAD:STKD;ST12;1;MED;138 GROVE DR;GIDEON GROVE CHURCH RD;FALL 17-B
CAD:UNDER CONTROL;138 GROVE DR; ROCK;FALL 17-B
CAD:STKD;ST12;1;MED;454 SADDLEBRED LOOP;SHETLAND CT
CAD:STKD;ST12;1;UNCON;7300 US 158;B & G CT;APT 406;31D02
CAD:STKD;ST12;1;FALL;8473 SOUTHARD RD;THOMAS RD;17D03
CAD:UNDER CONTROL;8473 SOUTHARD RD; ST
CAD:STKD;ST12;1;FALL;8598 BELEWS CREEK RD;WINDING HILL DR;DIST: 43.09 FT;28C10U
CAD:STKD;ST12;1;ALLERG;7151 ELLISON RD;OAK CREEK DR;02C01M
CAD:UNDER CONTROL;7151 ELLISON RD; ST
CAD:STKD;ST12;1;FIRAST;112 KINGSBRANCH DR;OGBURN MILL RD
CAD:STKD;ST12;1;MED;112 KINGSBRANCH DR;OGBURN MILL RD
CAD:UNDER CONTROL;112 KINGSBRANCH DR; ROCK
CAD:STKD;ST12;1;BREATH;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST
CAD:UNDER CONTROL;8401 US 158; ST
CAD:STKD;ST12;1;TRAUM;7605 NC 68 N;FOOD LION 2146;CHARTRESS RD;30B01
CAD:UNDER CONTROL;7605 NC 68 N; ST
CAD:1;FIRAST;1133 SARDIS CHURCH RD;ELLISBORO RD;STATION 150.....REF FILL IN
CAD:1;SERV;8440 SHEWING ST
CAD:STKD;ST12;1;SERV;8410 SHILLING ST;NEWBERRY ST
CAD:UNDER CONTROL;8410 SHILLING ST; ST
CAD:UNDER CONTROL;1133 SARDIS CHURCH RD; ROCK;STATION 150--FILL IN
CAD:STKD;ST12;1;MED;345 OGBURN MILL RD;EXCALIBER DR;CHEST PAIN
CAD:UNDER CONTROL;345 OGBURN MILL RD; ROCK;CHEST PAIN
CAD:1;MUTUAL;9069 BELEWS CREEK RD;PLUNKETT RD
CAD:POVS 10-22 RESPONSE;9069 BELEWS CREEK RD; FORS
CAD:1;SERV;8205 CANDY
CAD:STKD;ST12;1;SERV;8205 KANDI DR;WENDY GAYLE DR
CAD:UNDER CONTROL;8205 KANDI DR; ST
CAD:STKD;ST12;1;FIRAST;NC 68 N/SYLVANIA RD;WASHDOWN
CAD:UNDER CONTROL;NC 68 N/SYLVANIA RD; ROCK;WASHDOWN
CAD:1;MUTUAL;7335 PEGRAM RD;BELEWS CREEK RD;FIRE ALARM
CAD:STKD;ST12;1;FALL;7500 US 158;B & G CT;COUNTRYSIDE MANOR;17D02
CAD:UNDER CONTROL;7500 US 158; ST ;COUNTRYSIDE MANOR
CAD:SMFD;ST09;1;OSFIR;SCALESVILLE RD/ROBINSON RD;DIST: 10.55 FT
CAD:1;MUTUAL;158/WHITTY
CAD:STKD;ST12;1;SERV;8480 SOUTHARD RD;THOMAS RD;53A05
CAD:UNDER CONTROL;8480 SOUTHARD RD; ST
CAD:STKD;ST12;1;MED;4585 ELLISBORO RD;CHRISTOPHER RD;10-50 PI PIN IN
CAD:UNDER CONTROL;4585 ELLISBORO RD; ROCK;10-50 PI PIN IN

ERIC PSYCHO <psycho5444@gmail.com>
Sender: vtext.com@mailsquad.groupspaces.com
CAD:UNDER CONTROL;3608 E LEE ST; G ;LOT 17

*/

public class NCGuilfordCountyParserTest extends BaseParserTest {
  
  public NCGuilfordCountyParserTest() {
    setParser(new NCGuilfordCountyParser(), "GUILFORD COUNTY", "NC");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "[summerfieldfiredist Jan24-10:01]  CAD:SMFD;ST09;1;52C03C;FIRAL;7607 BLUE SAGE CT",
        "SRC:summerfieldfiredist",
        "SRC:SMFD-ST09",
        "PRI:1",
        "CODE:52C03C",
        "CALL:FIRAL",
        "ADDR:7607 BLUE SAGE CT");

    doTest("T2",
        "[summerfieldfiredist Jan19-18:15]  CAD:SMFD;ST29;1;50PI;SCALESVILLE RD/LAKE BRANDT RD",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CALL:50PI",
        "ADDR:SCALESVILLE RD & LAKE BRANDT RD");

    setDefaults("","NC");
    doTest("T3",
        "[summerfieldfiredist Jan18-19:08]  CAD:1;MUTUAL;150 WAYNOR DR;GALLENT RD;STRUCTURE FIRE",
        "PRI:1",
        "CALL:MUTUAL",
        "ADDR:150 WAYNOR DR",
        "X:GALLENT RD",
        "INFO:STRUCTURE FIRE");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T4",
        "(summerfieldfiredist Jan18-17:00) CAD:SMFD;ST29;1;25D01;PSYCH;8579 HUDSON JAMES RD;WRIGHTS FARM LN",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CODE:25D01",
        "CALL:PSYCH",
        "ADDR:8579 HUDSON JAMES RD",
        "X:WRIGHTS FARM LN");

    doTest("T5",
        "[summerfieldfiredist Jan18-03:16]  CAD:SMFD;ST39;1;29B01;50PI;PLAINFIELD RD/LAKE BRANDT RD;BETWEEN LAKE BRANDT AND CHURCH ST",
        "SRC:SMFD-ST39",
        "PRI:1",
        "CODE:29B01",
        "CALL:50PI",
        "ADDR:PLAINFIELD RD & LAKE BRANDT RD",
        "INFO:BETWEEN LAKE BRANDT AND CHURCH ST");

    doTest("T6",
        "(summerfieldfiredist Jan21-03:25) CAD:SMFD;ST09;1;67B01;OSFIR;2523 PLEASANT RIDGE RD;SADDLEWOOD DR;DIST: 35.58 FT",
        "SRC:SMFD-ST09",
        "PRI:1",
        "CODE:67B01",
        "CALL:OSFIR",
        "ADDR:2523 PLEASANT RIDGE RD",
        "X:SADDLEWOOD DR",
        "INFO:DIST: 35.58 FT");

    doTest("T7",
        "(summerfieldfiredist Jan23-06:49) CAD:SMFD;ST39;1;17B03;FALL;6251 LAKE BRANDT RD;HI-LO LN",
        "SRC:SMFD-ST39",
        "PRI:1",
        "CODE:17B03",
        "CALL:FALL",
        "ADDR:6251 LAKE BRANDT RD",
        "X:HI-LO LN");

    doTest("T8",
        "[summerfieldfiredist Jan23-19:20]  CAD:OKRD;ST51;1;69D11;STRUC;4529 PEEPLES RD;RIDING TRAIL CT",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CODE:69D11",
        "CALL:STRUC",
        "ADDR:4529 PEEPLES RD",
        "X:RIDING TRAIL CT");

    doTest("T9",
        "[summerfieldfiredist Jan23-19:18]  CAD:OKRD;ST51;1;STRUC;4529 PEEPLES RD;RIDING TRAIL CT",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:4529 PEEPLES RD",
        "X:RIDING TRAIL CT");

    doTest("T10",
        "[summerfieldfiredist Jan23-20:23]  CAD:OKRD;ST51;1;69D06;STRUC;5371 NORTHWEST SCHOOL RD;TRAIL PIEDMONT GREENWAY",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CODE:69D06",
        "CALL:STRUC",
        "ADDR:5371 NORTHWEST SCHOOL RD",
        "INFO:TRAIL PIEDMONT GREENWAY");

    doTest("T11",
        "(summerfieldfiredist Jan24-10:31) CAD:UNDER CONTROL;7607 BLUE SAGE CT; SU",
        "CALL:UNDER CONTROL",
        "ADDR:7607 BLUE SAGE CT",
        "INFO:SU");

    doTest("T12",
        "(summerfieldfiredist Jan23-11:25) CAD:UNDER CONTROL;6308 PEPPERMILL DR; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:6308 PEPPERMILL DR",
        "INFO:OAK");

    doTest("T13",
        "(summerfieldfiredist Jan23-19:48) CAD:UNDER CONTROL;4529 PEEPLES RD; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:4529 PEEPLES RD",
        "INFO:OAK");

    doTest("T14",
        "(summerfieldfiredist Jun10-01:00) summerfieldfiredist\nCAD:UNDER CONTROL;5322 BUNCH RD; SU",
        "ADDR:5322 BUNCH RD",
        "CALL:UNDER CONTROL",
        "INFO:SU");

    doTest("T15",
        "(summerfieldfiredist Jun10-19:27) summerfieldfiredist\nCAD:FD13;ST58;1;60C02;GAS;210 JAMES DOAK PKWY;BRIXHAM DR",
        "SRC:FD13-ST58",
        "PRI:1",
        "ADDR:210 JAMES DOAK PKWY",
        "CODE:60C02",
        "CALL:GAS",
        "X:BRIXHAM DR");

    doTest("T16",
        "CAD@greensboro-nc.gov:CAD:CODE 47;7700 NEWSOME CT; B;CARDIAC / RESPIRATORY ARREST",
        "ADDR:7700 NEWSOME CT",
        "CALL:CODE 47",
        "INFO:B / CARDIAC / RESPIRATORY ARREST");

    doTest("T17",
        "FRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun11-00:23\nMSG:summerfieldfiredist\nCAD:UNDER CONTROL;210 JAMES DOAK PKWY; G\n",
        "ADDR:210 JAMES DOAK PKWY",
        "INFO:G",
        "CALL:UNDER CONTROL");

    doTest("T18",
        "1 of 2\nFRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun17-16:22\nMSG:summerfieldfiredist\nCAD:OPA4;OPA4;1;MEDEM;5570 US 220 N;M AND M\n(Con't) 2 of 2\nTIRE AND AUTOMOTIVE;SPOTSWOOD RD\n(End)",
        "SRC:OPA4-OPA4",
        "PRI:1",
        "CALL:MEDEM",
        "ADDR:5570 US 220 N",
        "INFO:M AND M TIRE AND AUTOMOTIVE",
        "X:SPOTSWOOD RD");

    doTest("T19",
        "FRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun17-14:57\nMSG:summerfieldfiredist\nCAD:SMFD;ST39;1;09E02;CARDIA;5718 OAK TREE RD;AIR HARBOR RD\n",
        "ADDR:5718 OAK TREE RD",
        "SRC:SMFD-ST39",
        "CODE:09E02",
        "PRI:1",
        "CALL:CARDIA",
        "X:AIR HARBOR RD");

    doTest("T20",
        "CAD:UNDER CONTROL;878 CROSSCREEK RD; K ;. [27]",
        "ADDR:878 CROSSCREEK RD",
        "INFO:K / .",
        "CALL:UNDER CONTROL");

    doTest("T21",
        "Subject:summerfieldfiredist Aug06-16:44\nsummerfieldfiredist \nCAD:SMFD;ST09;1;31D02;UNCON;7912 SUMMERFIELD RD;FAIRGROVE BAPTIST CHURCH;",
        "SRC:SMFD-ST09",
        "PRI:1",
        "INFO:FAIRGROVE BAPTIST CHURCH",
        "ADDR:7912 SUMMERFIELD RD",
        "CODE:31D02",
        "CALL:UNCON");

    doTest("T22",
        "Subject:summerfieldfiredist Aug06-06:57\nsummerfieldfiredist \nCAD:OKRD;ST15;1;69D03;STRUC;8005 MARKETPLACE DR;TRACTOR SUPPLY CO;NC 68 N",
        "SRC:OKRD-ST15",
        "PRI:1",
        "INFO:TRACTOR SUPPLY CO",
        "CODE:69D03",
        "CALL:STRUC",
        "ADDR:8005 MARKETPLACE DR",
        "INFO:TRACTOR SUPPLY CO",
        "X:NC 68 N");

    doTest("T23",
        "Subject:summerfieldfiredist Aug08-11:36\nsummerfieldfiredist \nCAD:SMFD;ST39;1;19D01;HEART;1007 NC 150 W;SPEAR CLINIC;LAKE BRANDT RD;ROO",
        "SRC:SMFD-ST39",
        "PRI:1",
        "CODE:19D01",
        "CALL:HEART",
        "ADDR:1007 NC 150 W",
        "INFO:SPEAR CLINIC / ROO",
        "X:LAKE BRANDT RD");

    doTest("T24",
        "Subject:summerfieldfiredist Aug23-03:00\nsummerfieldfiredist\nCAD:SMFD;ST29;1;18C04;HEAD;8562 HUDSON JAMES RD;WRIGHTS FARM LN\n",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CODE:18C04",
        "CALL:HEAD",
        "ADDR:8562 HUDSON JAMES RD",
        "X:WRIGHTS FARM LN");

    doTest("T25",
        "Subject:summerfieldfiredist Aug23-02:49\nsummerfieldfiredist\nCAD:SMFD;ST09;1;25B03;PSYCH;7619 BRISBANE DR;OAK RIDGE RD\n",
        "SRC:SMFD-ST09",
        "PRI:1",
        "CODE:25B03",
        "CALL:PSYCH",
        "ADDR:7619 BRISBANE DR",
        "X:OAK RIDGE RD");

    doTest("T26",
        "Subject:summerfieldfiredist Aug21-19:49\nsummerfieldfiredist\nCAD:SMFD;ST09;1;23C02A;OVDOSE;2307 SCALESVILLE RD;ROBINSON RD;HOUSE\n",
        "SRC:SMFD-ST09",
        "PRI:1",
        "CODE:23C02A",
        "CALL:OVDOSE",
        "ADDR:2307 SCALESVILLE RD",
        "INFO:HOUSE",
        "X:ROBINSON RD");

    doTest("T27",
        "Subject:summerfieldfiredist Aug21-16:02\nsummerfieldfiredist\nCAD:OKRD;ST51;1;STRUC;6401 W BELGRAVE TER\n",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:6401 W BELGRAVE TER");

    doTest("T28",
        "S:summerfieldfiredist Oct17-12:45 M:summerfieldfiredist\nCAD:UNDER CONTROL;808 JAMES DOAK PKWY; G\n\n",
        "CALL:UNDER CONTROL",
        "ADDR:808 JAMES DOAK PKWY",
        "INFO:G");

    doTest("T29",
        "Subject:summerfieldfiredist Oct17-13:50\nsummerfieldfiredist\nCAD:SMFD;ST29;1;MED;180 QUAL RIDGE RD;SADDLEBROOK DR\n",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CALL:MED",
        "ADDR:180 QUAL RIDGE RD",
        "X:SADDLEBROOK DR");

    doTest("T30",
        "S:summerfieldfiredist Oct21-13:14 M:summerfieldfiredist\nCAD:CODE 47;330 GEMSTONE LOOP; ROCK;ST 29 CARDIAC ARREST CALL\n\n",
        "ADDR:330 GEMSTONE LOOP",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:ST 29 CARDIAC ARREST CALL",
        "CALL:CODE 47");

    doTest("T31",
        "CAD@greensboro-nc.gov:CAD:MCVL;ST37;1;60B01;GAS;922 GOLF HOUSE ROAD EAST;HADDINGTON RD;ACROSS FROM THIS ADDRESS",
        "SRC:MCVL-ST37",
        "PRI:1",
        "CODE:60B01",
        "CALL:GAS",
        "ADDR:922 GOLF HOUSE ROAD EAST",
        "INFO:ACROSS FROM THIS ADDRESS",
        "X:HADDINGTON RD");

    doTest("T32",
        "Subject:summerfieldfiredist Oct27-23:05\nsummerfieldfiredist\nCAD:UNDER CONTROL;300 NIBLICK DR; ROCK;REF FALL\n",
        "ADDR:300 NIBLICK DR",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:REF FALL",
        "CALL:UNDER CONTROL");

    doTest("T33",
        "Subject:summerfieldfiredist Nov06-22:05\nsummerfieldfiredist\nCAD:SMFD;ST09;1;STROKE;5109 MEDEARIS ST;AYERS LN\n",
        "SRC:SMFD-ST09",
        "PRI:1",
        "CALL:STROKE",
        "ADDR:5109 MEDEARIS ST",
        "X:AYERS LN");

    doTest("T34",
        "Subject:summerfieldfiredist Nov26-03:56\nsummerfieldfiredist\nCAD:SMFD;ST29;1;MED;132 LAKE DR;OLD MILL DR\n",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CALL:MED",
        "ADDR:132 LAKE DR",
        "X:OLD MILL DR");

    doTest("T35",
        "Subject:summerfieldfiredist Nov27-19:50\nsummerfieldfiredist\nCAD:SMFD;ST29;1;OSFIR;1359 SCALESVILLE RD;CARTER FARM RD\n",
        "SRC:SMFD-ST29",
        "PRI:1",
        "CALL:OSFIR",
        "ADDR:1359 SCALESVILLE RD",
        "X:CARTER FARM RD");
 }
  
  @Test
  public void testFireDistrict13() {

    doTest("T1",
        "Subject:[Firedistrict13] (no subject)\nCAD:UNDER CONTROL;616 SIMPSON-CALHOUN RD; G ;TAC 10\n\n_____________________________________",
        "ADDR:616 SIMPSON-CALHOUN RD",
        "INFO:G / TAC 10",
        "CALL:UNDER CONTROL");

    doTest("T2",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;29D02p;50PI;US 29 N/HICONE RD;29 NB NORTH OF HICONE\n\n_____________________",
        "SRC:FD13-ST55",
        "PRI:1",
        "ADDR:US 29 N & HICONE RD",
        "CODE:29D02p",
        "CALL:50PI",
        "INFO:29 NB NORTH OF HICONE");

    doTest("T3",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST58;1;26B01;SICK;7830 SUTTER RD;NC 150 W\n\n______________________________________",
        "SRC:FD13-ST58",
        "PRI:1",
        "CODE:26B01",
        "CALL:SICK",
        "ADDR:7830 SUTTER RD",
        "X:NC 150 W");

    doTest("T4",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;03D00;ANBITE;2706 BRAME RD;WHITE ELDER RD;DIST: 245.80 FT\n\n_______________",
        "SRC:FD13-ST55",
        "PRI:1",
        "CODE:03D00",
        "CALL:ANBITE",
        "ADDR:2706 BRAME RD",
        "INFO:DIST: 245.80 FT",
        "X:WHITE ELDER RD");

    doTest("T5",
        "Subject:[Firedistrict13] (no subject)\nCAD:UNDER CONTROL;2706 BRAME RD; G ;DIST: 245.80 FT\n\n_____________________________________",
        "CALL:UNDER CONTROL",
        "ADDR:2706 BRAME RD",
        "INFO:G / DIST: 245.80 FT");

    doTest("T6",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;29D02p;50PI;US 29 N/HICONE RD;29 NB NORTH OF HICONE\n\n_____________________",
        "SRC:FD13-ST55",
        "PRI:1",
        "CODE:29D02p",
        "CALL:50PI",
        "ADDR:US 29 N & HICONE RD",
        "INFO:29 NB NORTH OF HICONE");

    doTest("T7",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST13;1;FIRAL;5207 OLD MINE RD\n\n_______________________________________________\nF",
        "SRC:FD13-ST13",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:5207 OLD MINE RD");

    doTest("T8",
        "Subject:[Firedistrict13] (no subject)\nCAD:NEFD;ST32;1;EXPLO;6303 THREE LOY RD\n\n_______________________________________________\n",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:EXPLO",
        "ADDR:6303 THREE LOY RD");

    doTest("T9",
        "Subject:[Firedistrict13] (no subject)\nCAD:FD13;ST55;1;FIRAL;4006 STARLING CT\n\n_______________________________________________\nF",
        "SRC:FD13-ST55",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:4006 STARLING CT");

    doTest("T10",
        "Subject:[Firedistrict13] (no subject)\nCAD:NEFD;ST33;1;52B01S;FIRAL;7707 FRENCH DR;YANCEYVILLE RD;JOHNSON WILLIMS\n\n______________",
        "SRC:NEFD-ST33",
        "PRI:1",
        "CODE:52B01S",
        "CALL:FIRAL",
        "ADDR:7707 FRENCH DR",
        "X:YANCEYVILLE RD",
        "INFO:JOHNSON WILLIMS");
    
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "CAD:STKD;ST12;1;SICK;7717 ATHENS RD;SOUTHERN MEADOWS DR;26C02",
        "SRC:STKD-ST12",
        "ADDR:7717 ATHENS RD",
        "PRI:1",
        "CALL:SICK",
        "X:SOUTHERN MEADOWS DR",
        "INFO:26C02");

    doTest("T2",
        "CAD:UNDER CONTROL;7717 ATHENS RD; ST",
        "ADDR:7717 ATHENS RD",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T3",
        "CAD:SMFD;ST29;1;OSFIR;US 158/HUDSON RD;67D02B",
        "SRC:SMFD-ST29",
        "ADDR:US 158 & HUDSON RD", // Google knows this as HUDSON JAMES RD
        "PRI:1",
        "CALL:OSFIR",
        "INFO:67D02B");

    doTest("T4",
        "CAD:STKD;ST12;1;FIRAST;7848 US 158;ATHENS RD",
        "SRC:STKD-ST12",
        "ADDR:7848 US 158",
        "PRI:1",
        "CALL:FIRAST",
        "X:ATHENS RD");

    doTest("T5",
        "CAD:UNDER CONTROL;7848 US 158; ST",
        "ADDR:7848 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T6",
        "CAD:STKD;ST12;1;MED;1895 GIDEON GROVE CHURCH RD;EDDIES TR;CHEST PAIN",
        "SRC:STKD-ST12",
        "ADDR:1895 GIDEON GROVE CHURCH RD",
        "PRI:1",
        "CALL:MED",
        "X:EDDIES TR",
        "INFO:CHEST PAIN");

    doTest("T7",
        "CAD:UNDER CONTROL;1895 GIDEON GROVE CHURCH RD; ROCK; CHEST PAIN",
        "ADDR:1895 GIDEON GROVE CHURCH RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:CHEST PAIN");

    doTest("T8",
        "CAD:OKRD;ST15;1;50PI;NC 68 N/FOGLEMAN RD;29B04",
        "SRC:OKRD-ST15",
        "ADDR:NC 68 N & FOGLEMAN RD",
        "PRI:1",
        "CALL:50PI",
        "INFO:29B04");

    doTest("T9",
        "CAD:STKD;ST12;1;STROKE;8971 OSAGE RD;TYSOR RD",
        "SRC:STKD-ST12",
        "ADDR:8971 OSAGE RD",
        "PRI:1",
        "CALL:STROKE",
        "X:TYSOR RD");

    doTest("T10",
        "CAD:UNDER CONTROL;8971 OSAGE RD; ROCK",
        "ADDR:8971 OSAGE RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY");

    doTest("T11",
        "CAD:STKD;ST12;1;MED;160 SEVEN CREEKS DR;FOREST RIDGE DR;CHEST PAIN",
        "SRC:STKD-ST12",
        "ADDR:160 SEVEN CREEKS DR",
        "PRI:1",
        "CALL:MED",
        "X:FOREST RIDGE DR",
        "INFO:CHEST PAIN");

    doTest("T12",
        "CAD:UNDER CONTROL;160 SEVEN CREEKS DR; ROCK;CHEST PAIN",
        "ADDR:160 SEVEN CREEKS DR",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:CHEST PAIN");

    doTest("T13",
        "CAD:STKD;ST12;1;STROKE;7700 US 158;COUNTRYSIDE MANOR;ATHENS RD;ROOM A10 ASSISTED LIVING;28C10U",
        "SRC:STKD-ST12",
        "ADDR:7700 US 158",
        "PRI:1",
        "CALL:STROKE",
        "X:ATHENS RD",
        "INFO:COUNTRYSIDE MANOR / ROOM A10 ASSISTED LIVING / 28C10U");

    doTest("T14",
        "CAD:UNDER CONTROL;7700 US 158; ST ;ROOM A10 ASSISTED LIVING",
        "ADDR:7700 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST / ROOM A10 ASSISTED LIVING");

    doTest("T15",
        "CAD:STKD;ST12;1;ABDOM;7242 US 158;B & G CT;01C05",
        "SRC:STKD-ST12",
        "ADDR:7242 US 158",
        "PRI:1",
        "CALL:ABDOM",
        "INFO:B & G CT / 01C05");

    doTest("T16",
        "CAD:UNDER CONTROL;7242 US 158; ST",
        "ADDR:7242 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T17",
        "CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;DIST: 33.67 FT;29B01",
        "SRC:OKRD-ST15",
        "ADDR:NC 68 N & E HARRELL RD",
        "PRI:1",
        "CALL:50PI",
        "INFO:DIST: 33.67 FT / 29B01");

    doTest("T18",
        "CAD:STKD;ST12;1;ANBITE;8255 CURRAGHMORE CT;STOKESDALE PARK;CURRAGHMORE DR;DIST: 517.83 ft;03D00",
        "SRC:STKD-ST12",
        "ADDR:8255 CURRAGHMORE CT",
        "PRI:1",
        "CALL:ANBITE",
        "X:CURRAGHMORE DR",
        "INFO:STOKESDALE PARK / DIST: 517.83 ft / 03D00");

    doTest("T19",
        "CAD:UNDER CONTROL;8255 CURRAGHMORE CT; ST ;DIST: 517.83 ft",
        "ADDR:8255 CURRAGHMORE CT",
        "CALL:UNDER CONTROL",
        "INFO:ST / DIST: 517.83 ft");

    setDefaults("", "NC");
    doTest("T20",
        "CAD:1;MUTUAL;13863 US 158;GLENCOE CHURCH LOOP;FIRE ALARM",
        "PRI:1",
        "ADDR:13863 US 158",
        "CALL:MUTUAL",
        "X:GLENCOE CHURCH LOOP",
        "INFO:FIRE ALARM");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T21",
        "CAD:STKD;ST12;1;FIRAST;435 HUMPHREYS RIDGE DR;HUMPHREYS RIDGE MARINA;WEST RIDGE CIR",
        "SRC:STKD-ST12",
        "ADDR:435 HUMPHREYS RIDGE DR",
        "PRI:1",
        "CALL:FIRAST",
        "X:WEST RIDGE CIR",
        "INFO:HUMPHREYS RIDGE MARINA");

    doTest("T22",
        "CAD:UNDER CONTROL;435 HUMPHREYS RIDGE DR; ROCK",
        "ADDR:435 HUMPHREYS RIDGE DR",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY");

    doTest("T23",
        "CAD:STKD;ST12;1;BREATH;8129 FLATROCK RD;06D02",
        "SRC:STKD-ST12",
        "ADDR:8129 FLATROCK RD",
        "PRI:1",
        "CALL:BREATH",
        "INFO:06D02");

    doTest("T24",
        "CAD:UNDER CONTROL;8129 FLATROCK RD; ST",
        "ADDR:8129 FLATROCK RD",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T25",
        "CAD:STKD;ST12;1;UNCON;7848 US 158;ATHENS RD;31C00",
        "SRC:STKD-ST12",
        "ADDR:7848 US 158",
        "PRI:1",
        "CALL:UNCON",
        "X:ATHENS RD",
        "INFO:31C00");

    doTest("T26",
        "CAD:UNDER CONTROL;7848 US 158; ST",
        "ADDR:7848 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T27",
        "CAD:STKD;ST12;1;MED;8306 PATRICIA DR;US 158",
        "SRC:STKD-ST12",
        "ADDR:8306 PATRICIA DR",
        "PRI:1",
        "CALL:MED",
        "X:US 158");

    doTest("T28",
        "CAD:STKD;ST12;1;MED;8312 SOUTHARD RD;US 158;HOUSE",
        "SRC:STKD-ST12",
        "ADDR:8312 SOUTHARD RD",
        "PRI:1",
        "CALL:MED",
        "X:US 158",
        "INFO:HOUSE");

    doTest("T29",
        "CAD:UNDER CONTROL;8306 PATRICIA DR; ST",
        "ADDR:8306 PATRICIA DR",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T30",
        "CAD:STKD;ST12;1;MEDEM;8312 SOUTHARD RD;US 158;HOUSE",
        "SRC:STKD-ST12",
        "ADDR:8312 SOUTHARD RD",
        "PRI:1",
        "CALL:MEDEM",
        "X:US 158",
        "INFO:HOUSE");

    doTest("T31",
        "CAD:UNDER CONTROL;8312 SOUTHARD RD; ST ;HOUSE",
        "ADDR:8312 SOUTHARD RD",
        "CALL:UNDER CONTROL",
        "INFO:ST / HOUSE");

    doTest("T32",
        "CAD:STKD;ST12;1;MED;151 DIONNE WAY;MOUNT ZION CHURCH RD;21-D-3 HEMORRHAGE",
        "SRC:STKD-ST12",
        "ADDR:151 DIONNE WAY",
        "PRI:1",
        "CALL:MED",
        "X:MOUNT ZION CHURCH RD",
        "INFO:21-D-3 HEMORRHAGE");

    doTest("T33",
        "CAD:UNDER CONTROL;151 DIONNE WAY; ROCK;21-D-3 HEMORRHAGE",
        "ADDR:151 DIONNE WAY",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:21-D-3 HEMORRHAGE");

    setDefaults("", "NC");
    doTest("T34",
        "CAD:1;MUTUAL;361 SARDIS CHURCH RD;LINDSEY BRIDGE RD;FIRE ALARM",
        "ADDR:361 SARDIS CHURCH RD",
        "PRI:1",
        "CALL:MUTUAL",
        "X:LINDSEY BRIDGE RD",
        "INFO:FIRE ALARM");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T35",
        "CAD:STKD;ST12;1;50PI;8945 BELEWS CREEK RD;SHEDAN RD;DIST: 109.55 ft;29D02l",
        "SRC:STKD-ST12",
        "ADDR:8945 BELEWS CREEK RD",
        "PRI:1",
        "CALL:50PI",
        "X:SHEDAN RD",
        "INFO:DIST: 109.55 ft / 29D02l");

    doTest("T36",
        "CAD:UNDER CONTROL;8945 BELEWS CREEK RD; ST ;DIST: 109.55 ft",
        "ADDR:8945 BELEWS CREEK RD",
        "CALL:UNDER CONTROL",
        "INFO:ST / DIST: 109.55 ft");

    doTest("T37",
        "CAD:STKD;ST12;1;FIRAST;US 158/BELEWS CREEK RD",
        "SRC:STKD-ST12",
        "ADDR:US 158 & BELEWS CREEK RD",
        "PRI:1",
        "CALL:FIRAST");

    doTest("T38",
        "CAD:CANCEL;US 158/BELEWS CREEK RD; ST",
        "ADDR:US 158 & BELEWS CREEK RD",
        "CALL:CANCEL",
        "INFO:ST");

    doTest("T39",
        "CAD:STKD;ST12;1;FALL;8303 KNIGHT VILLAGE CIR;ATHENS RD;HOUSE;17B03",
        "SRC:STKD-ST12",
        "ADDR:8303 KNIGHT VILLAGE CIR",
        "PRI:1",
        "CALL:FALL",
        "X:ATHENS RD",
        "INFO:HOUSE / 17B03");

    doTest("T40",
        "CAD:UNDER CONTROL;8303 KNIGHT VILLAGE CIR; ST ;HOUSE",
        "ADDR:8303 KNIGHT VILLAGE CIR",
        "CALL:UNDER CONTROL",
        "INFO:ST / HOUSE");

    doTest("T41",
        "CAD:STKD;ST12;1;BLEED;8108 BAYWOOD DR;NC 68 N;21D04",
        "SRC:STKD-ST12",
        "ADDR:8108 BAYWOOD DR",
        "PRI:1",
        "CALL:BLEED",
        "X:NC 68 N",
        "INFO:21D04");

    doTest("T42",
        "CAD:UNDER CONTROL;8108 BAYWOOD DR; ST",
        "ADDR:8108 BAYWOOD DR",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T43",
        "CAD:STKD;ST12;1;SEIZUR;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST",
        "SRC:STKD-ST12",
        "ADDR:8401 US 158",
        "PRI:1",
        "CALL:SEIZUR",
        "X:STOKESDALE FIRE ST 12 & SHILLING ST");

    doTest("T44",
        "CAD:UNDER CONTROL;8401 US 158; ST",
        "ADDR:8401 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    setDefaults("", "NC");
    doTest("T45",
        "CAD:1;MUTUAL;SIMPSON RD/GIDEON GROVE CHURCH RD",
        "ADDR:SIMPSON RD & GIDEON GROVE CHURCH RD",
        "PRI:1",
        "CALL:MUTUAL");

    doTest("T46",
        "CAD:1;MUTUAL;SIMPSON RD/GIDEON GROVE CHURCH RD;STRUCT",
        "ADDR:SIMPSON RD & GIDEON GROVE CHURCH RD",
        "PRI:1",
        "CALL:MUTUAL",
        "INFO:STRUCT");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T47",
        "CAD:OKRD;ST15;1;FIRAL;8315 HAW RIVER RD;ANTHONY RD",
        "SRC:OKRD-ST15",
        "ADDR:8315 HAW RIVER RD",
        "PRI:1",
        "CALL:FIRAL",
        "X:ANTHONY RD");

    doTest("T48",
        "CAD:UNDER CONTROL;8315 HAW RIVER RD; OAK",
        "ADDR:8315 HAW RIVER RD",
        "CALL:UNDER CONTROL",
        "INFO:OAK");

    doTest("T49",
        "CAD:STKD;ST12;1;MED;366 FRIDDLE RD;PIN OAK DR;FALL",
        "SRC:STKD-ST12",
        "ADDR:366 FRIDDLE RD",
        "PRI:1",
        "CALL:MED",
        "X:PIN OAK DR",
        "INFO:FALL");

    doTest("T50",
        "CAD:STKD;ST12;1;FIRAST;366 FRIDDLE RD;PIN OAK DR;CARDIAC",
        "SRC:STKD-ST12",
        "ADDR:366 FRIDDLE RD",
        "PRI:1",
        "CALL:FIRAST",
        "X:PIN OAK DR",
        "INFO:CARDIAC");

    doTest("T51",
        "CAD:UNDER CONTROL;366 FRIDDLE RD; ROCK;CARDIAC",
        "ADDR:366 FRIDDLE RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:CARDIAC");

    doTest("T52",
        "CAD:STKD;ST12;1;FALL;7258 US 158;B & G CT;17B01G",
        "SRC:STKD-ST12",
        "ADDR:7258 US 158",
        "PRI:1",
        "CALL:FALL",
        "INFO:B & G CT / 17B01G");

    doTest("T53",
        "CAD:UNDER CONTROL;7258 US 158; ST",
        "ADDR:7258 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T54",
        "CAD:STKD;ST12;1;FIRAST;4860 ELLISBORO RD;CAROUSEL LN",
        "SRC:STKD-ST12",
        "ADDR:4860 ELLISBORO RD",
        "PRI:1",
        "CALL:FIRAST",
        "X:CAROUSEL LN");

    doTest("T55",
        "CAD:UNDER CONTROL;4860 ELLISBORO RD; ROCK",
        "ADDR:4860 ELLISBORO RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY");

    doTest("T56",
        "CAD:OKRD;ST15;1;FIRAL;2205 OAK RIDGE RD;LOWES FOOD;CADET DR;SUITE B",
        "SRC:OKRD-ST15",
        "ADDR:2205 OAK RIDGE RD",
        "PRI:1",
        "CALL:FIRAL",
        "X:CADET DR",
        "INFO:LOWES FOOD / SUITE B");

    doTest("T57",
        "CAD:STKD;ST12;1;STRUC;8107 DORSETT DOWNS DR;WESSEX DR;HOUSE;69D06",
        "SRC:STKD-ST12",
        "ADDR:8107 DORSETT DOWNS DR",
        "PRI:1",
        "CALL:STRUC",
        "X:WESSEX DR",
        "INFO:HOUSE / 69D06");

    doTest("T58",
        "CAD:STKD;ST12;1;BURN;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST",
        "SRC:STKD-ST12",
        "ADDR:8401 US 158",
        "PRI:1",
        "CALL:BURN",
        "X:STOKESDALE FIRE ST 12 & SHILLING ST");

    doTest("T59",
        "CAD:UNDER CONTROL;8401 US 158; ST",
        "ADDR:8401 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T60",
        "CAD:STKD;ST12;1;SERV;3774 ELLISBORO RD;WOODFORD LN",
        "SRC:STKD-ST12",
        "ADDR:3774 ELLISBORO RD",
        "PRI:1",
        "CALL:SERV",
        "X:WOODFORD LN");

    doTest("T61",
        "CAD:STKD;ST12;1;50PI;564 NC 68 N;SYLVANIA RD;10-50 UNKN",
        "SRC:STKD-ST12",
        "ADDR:564 NC 68 N",
        "PRI:1",
        "CALL:50PI",
        "X:SYLVANIA RD",
        "INFO:10-50 UNKN");

    doTest("T62",
        "CAD:UNDER CONTROL;564 NC 68 N; ROCK;10-50 UNKN",
        "ADDR:564 NC 68 N",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:10-50 UNKN");

    doTest("T63",
        "CAD:STKD;ST12;1;STRUC;4329 ELLISBORO RD;RENN RD;ROCKINGHAM",
        "SRC:STKD-ST12",
        "ADDR:4329 ELLISBORO RD",
        "PRI:1",
        "CALL:STRUC",
        "X:RENN RD",
        "INFO:ROCKINGHAM");

    doTest("T64",
        "CAD:UNDER CONTROL;4329 ELLISBORO RD; ROCK",
        "ADDR:4329 ELLISBORO RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY");

    doTest("T65",
        "CAD:STKD;ST12;1;MED;138 GROVE DR;GIDEON GROVE CHURCH RD;FALL 17-B",
        "SRC:STKD-ST12",
        "ADDR:138 GROVE DR",
        "PRI:1",
        "CALL:MED",
        "X:GIDEON GROVE CHURCH RD",
        "INFO:FALL 17-B");

    doTest("T66",
        "CAD:UNDER CONTROL;138 GROVE DR; ROCK;FALL 17-B",
        "ADDR:138 GROVE DR",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:FALL 17-B");

    doTest("T67",
        "CAD:STKD;ST12;1;MED;454 SADDLEBRED LOOP;SHETLAND CT",
        "SRC:STKD-ST12",
        "ADDR:454 SADDLEBRED LOOP",
        "PRI:1",
        "CALL:MED",
        "X:SHETLAND CT");

    doTest("T68",
        "CAD:STKD;ST12;1;UNCON;7300 US 158;B & G CT;APT 406;31D02",
        "SRC:STKD-ST12",
        "ADDR:7300 US 158",
        "PRI:1",
        "CALL:UNCON",
        "INFO:B & G CT / APT 406 / 31D02");

    doTest("T69",
        "CAD:STKD;ST12;1;FALL;8473 SOUTHARD RD;THOMAS RD;17D03",
        "SRC:STKD-ST12",
        "ADDR:8473 SOUTHARD RD",
        "PRI:1",
        "CALL:FALL",
        "X:THOMAS RD",
        "INFO:17D03");

    doTest("T70",
        "CAD:UNDER CONTROL;8473 SOUTHARD RD; ST",
        "ADDR:8473 SOUTHARD RD",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T71",
        "CAD:STKD;ST12;1;FALL;8598 BELEWS CREEK RD;WINDING HILL DR;DIST: 43.09 FT;28C10U",
        "SRC:STKD-ST12",
        "ADDR:8598 BELEWS CREEK RD",
        "PRI:1",
        "CALL:FALL",
        "X:WINDING HILL DR",
        "INFO:DIST: 43.09 FT / 28C10U");

    doTest("T72",
        "CAD:STKD;ST12;1;ALLERG;7151 ELLISON RD;OAK CREEK DR;02C01M",
        "SRC:STKD-ST12",
        "ADDR:7151 ELLISON RD",
        "PRI:1",
        "CALL:ALLERG",
        "X:OAK CREEK DR",
        "INFO:02C01M");

    doTest("T73",
        "CAD:UNDER CONTROL;7151 ELLISON RD; ST",
        "ADDR:7151 ELLISON RD",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T74",
        "CAD:STKD;ST12;1;FIRAST;112 KINGSBRANCH DR;OGBURN MILL RD",
        "SRC:STKD-ST12",
        "ADDR:112 KINGSBRANCH DR",
        "PRI:1",
        "CALL:FIRAST",
        "X:OGBURN MILL RD");

    doTest("T75",
        "CAD:STKD;ST12;1;MED;112 KINGSBRANCH DR;OGBURN MILL RD",
        "SRC:STKD-ST12",
        "ADDR:112 KINGSBRANCH DR",
        "PRI:1",
        "CALL:MED",
        "X:OGBURN MILL RD");

    doTest("T76",
        "CAD:UNDER CONTROL;112 KINGSBRANCH DR; ROCK",
        "ADDR:112 KINGSBRANCH DR",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY");

    doTest("T77",
        "CAD:STKD;ST12;1;BREATH;8401 US 158;STOKESDALE FIRE ST 12;SHILLING ST",
        "SRC:STKD-ST12",
        "ADDR:8401 US 158",
        "PRI:1",
        "CALL:BREATH",
        "X:STOKESDALE FIRE ST 12 & SHILLING ST");

    doTest("T78",
        "CAD:UNDER CONTROL;8401 US 158; ST",
        "ADDR:8401 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T79",
        "CAD:STKD;ST12;1;TRAUM;7605 NC 68 N;FOOD LION 2146;CHARTRESS RD;30B01",
        "SRC:STKD-ST12",
        "ADDR:7605 NC 68 N",
        "PRI:1",
        "CALL:TRAUM",
        "X:CHARTRESS RD",
        "INFO:FOOD LION 2146 / 30B01");

    doTest("T80",
        "CAD:UNDER CONTROL;7605 NC 68 N; ST",
        "ADDR:7605 NC 68 N",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T81",
        "CAD:1;FIRAST;1133 SARDIS CHURCH RD;ELLISBORO RD;STATION 150.....REF FILL IN",
        "ADDR:1133 SARDIS CHURCH RD",
        "PRI:1",
        "CALL:FIRAST",
        "X:ELLISBORO RD",
        "INFO:STATION 150.....REF FILL IN");

    doTest("T82",
        "CAD:1;SERV;8440 SHEWING ST",
        "ADDR:8440 SHEWING ST",
        "PRI:1",
        "CALL:SERV");

    doTest("T83",
        "CAD:STKD;ST12;1;SERV;8410 SHILLING ST;NEWBERRY ST",
        "SRC:STKD-ST12",
        "ADDR:8410 SHILLING ST",
        "PRI:1",
        "CALL:SERV",
        "X:NEWBERRY ST");

    doTest("T84",
        "CAD:UNDER CONTROL;8410 SHILLING ST; ST",
        "ADDR:8410 SHILLING ST",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T85",
        "CAD:UNDER CONTROL;1133 SARDIS CHURCH RD; ROCK;STATION 150--FILL IN",
        "ADDR:1133 SARDIS CHURCH RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:STATION 150--FILL IN");

    doTest("T86",
        "CAD:STKD;ST12;1;MED;345 OGBURN MILL RD;EXCALIBER DR;CHEST PAIN",
        "SRC:STKD-ST12",
        "ADDR:345 OGBURN MILL RD",
        "PRI:1",
        "CALL:MED",
        "X:EXCALIBER DR",
        "INFO:CHEST PAIN");

    doTest("T87",
        "CAD:UNDER CONTROL;345 OGBURN MILL RD; ROCK;CHEST PAIN",
        "ADDR:345 OGBURN MILL RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:CHEST PAIN");

    setDefaults("", "NC");
    doTest("T88",
        "CAD:1;MUTUAL;9069 BELEWS CREEK RD;PLUNKETT RD",
        "ADDR:9069 BELEWS CREEK RD",
        "PRI:1",
        "CALL:MUTUAL",
        "X:PLUNKETT RD");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T89",
        "CAD:POVS 10-22 RESPONSE;9069 BELEWS CREEK RD; FORS",
        "ADDR:9069 BELEWS CREEK RD",
        "CALL:POVS 10-22 RESPONSE",
        "INFO:FORS");

    doTest("T90",
        "CAD:1;SERV;8205 CANDY",
        "ADDR:8205 CANDY",
        "PRI:1",
        "CALL:SERV");

    doTest("T91",
        "CAD:STKD;ST12;1;SERV;8205 KANDI DR;WENDY GAYLE DR",
        "SRC:STKD-ST12",
        "ADDR:8205 KANDI DR",
        "PRI:1",
        "CALL:SERV",
        "X:WENDY GAYLE DR");

    doTest("T92",
        "CAD:UNDER CONTROL;8205 KANDI DR; ST",
        "ADDR:8205 KANDI DR",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T93",
        "CAD:STKD;ST12;1;FIRAST;NC 68 N/SYLVANIA RD;WASHDOWN",
        "SRC:STKD-ST12",
        "ADDR:NC 68 N & SYLVANIA RD",
        "PRI:1",
        "CALL:FIRAST",
        "INFO:WASHDOWN");

    doTest("T94",
        "CAD:UNDER CONTROL;NC 68 N/SYLVANIA RD; ROCK;WASHDOWN",
        "ADDR:NC 68 N & SYLVANIA RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:WASHDOWN");

    setDefaults("", "NC");
    doTest("T95",
        "CAD:1;MUTUAL;7335 PEGRAM RD;BELEWS CREEK RD;FIRE ALARM",
        "ADDR:7335 PEGRAM RD",
        "PRI:1",
        "CALL:MUTUAL",
        "X:BELEWS CREEK RD",
        "INFO:FIRE ALARM");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T96",
        "CAD:STKD;ST12;1;FALL;7500 US 158;B & G CT;COUNTRYSIDE MANOR;17D02",
        "SRC:STKD-ST12",
        "ADDR:7500 US 158",
        "PRI:1",
        "CALL:FALL",
        "INFO:B & G CT / COUNTRYSIDE MANOR / 17D02");

    doTest("T97",
        "CAD:UNDER CONTROL;7500 US 158; ST ;COUNTRYSIDE MANOR",
        "ADDR:7500 US 158",
        "CALL:UNDER CONTROL",
        "INFO:ST / COUNTRYSIDE MANOR");

    doTest("T98",
        "CAD:SMFD;ST09;1;OSFIR;SCALESVILLE RD/ROBINSON RD;DIST: 10.55 FT",
        "SRC:SMFD-ST09",
        "ADDR:SCALESVILLE RD & ROBINSON RD",
        "PRI:1",
        "CALL:OSFIR",
        "INFO:DIST: 10.55 FT");

    setDefaults("", "NC");
    doTest("T99",
        "CAD:1;MUTUAL;158/WHITTY",
        "ADDR:158 & WHITTY",
        "PRI:1",
        "CALL:MUTUAL");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T100",
        "CAD:STKD;ST12;1;SERV;8480 SOUTHARD RD;THOMAS RD;53A05",
        "SRC:STKD-ST12",
        "ADDR:8480 SOUTHARD RD",
        "PRI:1",
        "CALL:SERV",
        "X:THOMAS RD",
        "INFO:53A05");

    doTest("T101",
        "CAD:UNDER CONTROL;8480 SOUTHARD RD; ST",
        "ADDR:8480 SOUTHARD RD",
        "CALL:UNDER CONTROL",
        "INFO:ST");

    doTest("T102",
        "CAD:STKD;ST12;1;MED;4585 ELLISBORO RD;CHRISTOPHER RD;10-50 PI PIN IN",
        "SRC:STKD-ST12",
        "ADDR:4585 ELLISBORO RD",
        "PRI:1",
        "CALL:MED",
        "X:CHRISTOPHER RD",
        "INFO:10-50 PI PIN IN");

    doTest("T103",
        "CAD:UNDER CONTROL;4585 ELLISBORO RD; ROCK;10-50 PI PIN IN",
        "ADDR:4585 ELLISBORO RD",
        "CALL:UNDER CONTROL",
        "CITY:ROCKINGHAM COUNTY",
        "INFO:10-50 PI PIN IN");

  }
  

  public static void main(String[] args) {
    new NCGuilfordCountyParserTest().generateTests("T1");
  }
}
