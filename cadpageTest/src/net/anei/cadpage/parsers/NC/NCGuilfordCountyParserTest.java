package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Guilford County, NC
GreensBoro, NC
Contact: Jeff Boyers <jtboyers@gmail.com>
Sender: 93001050 (increments)

388:CAD@greensboro-nc.gov:CAD:FYI: ;1137919;CARDIAC / RESPIRATORY ARREST;1202 BILBRO ST;W WHITTINGTON ST;IRELAND ST;09E01
397:CAD@greensboro-nc.gov:CAD:1138157;STAB / GUNSHOT WOUND;707 W FLORIDA ST;DIST: 25.68 FT;HUDGINS DR;HUDGINS DR;27D01G;SMITH HOMES
392:CAD@greensboro-nc.gov:CAD:FYI: ;1138044;CARDIAC / RESPIRATORY ARREST;827 GARDENGATE RD;WOODEDGE DR;09E02
400:CAD@greensboro-nc.gov:CAD:1138253;BREATHING PROBLEMS;1515 WOODMERE DR;APT L;TEXTILE DR;PHILLIPS AV;06D02
393:CAD@greensboro-nc.gov:CAD:1138092;ACCIDENT WITH PERSONAL INJURY;E CONE BLVD/CHESHIRE WAY;DIST: 32.08 FT;29D02p
395:CAD@greensboro-nc.gov:CAD:1138115;ACCIDENT WITH PERSONAL INJURY;2615 HIGH POINT RD;MAYWOOD ST;W FLORIDA ST;SUNSET CLEANERS

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

Contact: "Bailey, Michael" <Michael.Bailey@greensboro-nc.gov>
Sender: cad
FRM:cad \nMSG:CAD:UNDER CONTROL;3204 YANCEYVILLE ST; G ;APT C
FRM:cad \nMSG:CAD:FYI: ;GFD1;ST07;1;STRUC;303 WINSTON ST;CHARLOTTE ST;APT A\r\n
FRM:cad \nMSG:CAD:FYI: ;GFD2;ST05;1;STRUC;507 STIRLING ST;UNCG ELLIOTT BUILDING;WALKER AV\r\n

ERIC PSYCHO <psycho5444@gmail.com>
Sender: vtext.com@mailsquad.groupspaces.com
CAD:UNDER CONTROL;3608 E LEE ST; G ;LOT 17

Contact: Jonathan Moore <88truckco@gmail.com>
Sender: :station10paging@gmail.com
FRM:station10paging@gmail.com\nMSG:station10paging:MVFD;ST10;1;UNCON;1960 FLAT ROCK RD;MCCOY RD;31D02

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

Contact: Active911
Agency name: Greensboro Fire Department
Location: Greensboro, NC, United States
Sender: CAD@greensboro-nc.gov

CAD:FYI: ;STRUC;2407 PHILLIPS AV;LOMBARDY ST;1;C1,E1,L14,E56,L7,E7;GFD1;ST07;69D05
CAD:FYI: ;STRUC;2407 PHILLIPS AV;LOMBARDY ST;1;C1,E1,L14,E56,L7,E7;GFD1;ST07
CAD:Update: ;1;STRUC;512 LAMA ST;ASHE ST;69D06;E61,C2,L11,L5,E8,E4
CAD:FYI: ;1;STRUC;LAMA ST/SOUTH ST;69D06;E61,C2,L11,L5,E8,E4
CAD:FYI: ;1;STRUC;LAMA ST/SOUTH ST;E61,C2,L11,L5,E8,E4
CAD:FYI: ;1;STRUC;417 BANKS ST;SALEM ST;69D06;C1,E1,L7,L5,E7,E4
CAD:FYI: ;1;STRUC;417 BANKS ST;SALEM ST;L7,E7,E4
CAD:FYI: ;1;STRUC;1705 16TH ST;OFF RAMP;C1,E1,AIR1
CAD:FYI: ;1;STRUC;1705 16TH ST;OFF RAMP;69D05;C1,E1,E14,L14,AIR1,L7,E7
CAD:FYI: ;1;STRUC;4038 BATTLEGROUND AV;BATTLEGROUND NORTH APTS;OLD BATTLEGROUND RD;69D05;C4,E21,L21,L5,E40,E41
CAD:FYI: ;1;STRUC;4038 BATTLEGROUND AV;BATTLEGROUND NORTH APTS;OLD BATTLEGROUND RD;C4,E21,L21,L5,E40,E41
CAD:FYI: ;1;STRUC;2304 BLAIR-KHAZAN DR;FRANKLIN MCCAIN CT;C1,E1,E14,L14,E43,L7
CAD:FYI: ;1;STRUC;2306 MEADOW GATE DR;LAKE JEANETTE RD;69D06;C4,L14,E43,E40,E7,L43
CAD:FYI: ;1;STRUC;2306 MEADOW GATE DR;LAKE JEANETTE RD;C4,L14,E43,E40,E41,L43
CAD:FYI: ;MCVL;ST57;1;STRUC;117 WAGONER BEND RD;OLD BURLINGTON RD;69D10;R50,E56,T56,E37,T37,E47,T47,L57
CAD:FYI: ;MCVL;ST57;1;STRUC;117 WAGONER BEND RD;OLD BURLINGTON RD;R50,E56,T56,E37,T37,E47,T47,L57
CAD:FYI: ;GFD2;ST61;1;STRUC;302 W MONTCASTLE DR;WINCHESTER DR;69D06;E61,E11,C2,E48,L10,L11
CAD:FYI: ;GFD2;ST61;1;STRUC;302 W MONTCASTLE DR;WINCHESTER DR;E61,E11,C2,E48,L10,L11
CAD:FYI: ;GFD2;ST08;1;STRUC;2807 WILDWOOD DR;DEXTER AV;69D06;L10,E8
CAD:FYI: ;GFD2;ST08;1;STRUC;2807 WILDWOOD DR;DEXTER AV;C2,E10,E48,L10,L11,E8
CAD:FYI: ;GFD2;ST48;1;STRUC;2400 PHOENIX DR;SANTA FE TR;69D06O;E61,C2,E10,E48,L10,L11
CAD:FYI: ;GFD2;ST48;1;STRUC;2400 PHOENIX DR;SANTA FE TR;E61,C2,E10,E48,L10,L11
CAD:FYI: ;GFD2;ST08;1;STRUC;2525 E MARKET ST;FALSE DR;69D05;E11,C2,L11,L5,E8,E53
CAD:FYI: ;GFD1;ST01;1;STRUC;2105 YANCEYVILLE ST;REVOLUTION MILL DR;69D03;C1,E1,C4,E5,AIR1,L7,L5,E7,E4
CAD:FYI: ;GFD1;ST01;1;STRUC;2105 YANCEYVILLE ST;REVOLUTION MILL DR;C1,E5,AIR1,L7,L5,E7,E4
CAD:FYI: ;GFD2;ST08;1;STRUC;2525 E MARKET ST;FALSE DR;69D05;E11,C2,L11,L5,E8,E53
CAD:FYI: ;GFD2;ST56;1;STRUC;1416 DANS RD;PEAR ST;69D06;C2,E56,L7,L11,E53,E4
CAD:FYI: ;GFD1;ST07;1;STRUC;709 MCPHERSON ST;KENTWOOD ST;69C01;C1,E1,L14,E56,L7,E7
CAD:FYI: ;GFD1;ST07;1;STRUC;709 MCPHERSON ST;KENTWOOD ST;C1,E1,L14,E56,L7,E7
CAD:FYI: ;GFD2;ST08;1;STRUC;2101 W MEADOWVIEW RD;RED ROOF INN;TERRACE WAY;69D01;C1,L49,C2,E10,E48,L5,E8

Contact: Active911
Agency name: Colfax Fire Department
Location: Colfax, NC, United States
Sender: CAD@greensboro-nc.gov

CAD:UNDER CONTROL;SANDY RIDGE RD/SQUIRE DAVIS RD; COL ;DIST: 67.10 FT
CAD:CLFX;ST26;1;50PI;SANDY RIDGE RD/SQUIRE DAVIS RD;DIST: 67.10 FT;29D02l
CAD:HPFD;HPFD;1;FIRAST;5342 CALVIN CT;WITHERSPOON DR;(S)River Landing at Sandy Ridge (N)
CAD:GFD3;ST19;1;VFIRE;211 I-40 E;OFF RAMP I-40 E;EB 40;71B01
CAD:GFD3;ST16;1;CARDIA;I-40 W/SANDY RIDGE RD;WB;09E01
CAD:UNDER CONTROL;405 N BUNKER HILL RD; COL
CAD:CLFX;ST16;1;CHEST;405 N BUNKER HILL RD;MARSHALL SMITH RD;10C02
CAD:CLFX;ST16;1;FALL;1025 NC 68 N;EDGEFIELD RD;17B03
CAD:UNDER CONTROL;2914 SANDY RIDGE RD; COL
CAD:CLFX;ST26;1;FIRAL;2914 SANDY RIDGE RD;FARMERS MARKET;TYNER RD;52C03G
CAD:UNDER CONTROL;1813 QUAIL CREEK CT; COL
CAD:CLFX;ST16;1;SEIZUR;1813 QUAIL CREEK CT;12C04
CAD:PTIA;PTIA;1;ALRT1L;1000 TED JOHNSON PKWY;AIRPORT;EMPLOYEE LOT RD
CAD:UNDER CONTROL;131 KIDD RD; COL ;ROBERT COOPER
CAD:CLFX;ST16;1;FALL;131 KIDD RD;W MARKET ST;ROBERT COOPER;17B03G
CAD:PCSF;ST46;1;STROKE;2005 SHANNON GRAY CT;SHANNON GRAY NURSING CENTER;RM 211;28C03D
CAD:1;MUTUAL;40/66
CAD:UNDER CONTROL;8700 TRIAD DR; COL ;DIST: 341.12 FT TRANSOURCE
CAD:GFD3;ST16;1;OSFIR;8700 TRIAD DR;SANDY RIDGE RD;DIST: 341.12 FT TRANSOURCE;67B01V
CAD:GFD3;ST16;1;OSFIR;8700 TRIAD DR;SANDY RIDGE RD;DIST: 341.12 FT TRANSOURCE
CAD:CLFX;ST16;1;FIRAL;1507 EAST MOUNTAIN ST;KINGDOM HALL OF JEHOVAHS;PRATT RD;52C03G
CAD:CLFX;ST16;1;FIRAL;1507 EAST MOUNTAIN ST;KINGDOM HALL OF JEHOVAHS;PRATT RD

Contact: Active911
Agency name: Oak Ridge Fire Department
Location: Oak Ridge, NC, United States
Sender: <CAD@greensboro-nc.gov>

CAD:UNDER CONTROL;2050 OAK RIDGE RD; OAK ;ROOM 610
CAD:OKRD;ST15;1;SEIZUR;2050 OAK RIDGE RD;OAK RIDGE ELEMENTARY SCHOOL;AUTUMN GATE DR;ROOM 610;12C00
CAD:UNDER CONTROL;7608 TREBBIANO DR; K
CAD:STKD;ST12;1;FIRAL;7608 TREBBIANO DR;HAW RIVER RD
CAD:OKRD;ST15;1;50PI;HAW RIVER RD/PEPPER RD;NEAR THE COUNTY LINE
CAD:OKRD;ST15;1;50PI;7900-BLK ALCORN RD;NC 68 N
CAD:FORS;FORS;1;FIRAST;9030 GORTMAN RD;STRUCT FIRE
CAD:UNDER CONTROL;5362 BUNCH RD; SU
CAD:OKRD;ST51;1;UNCON;5362 BUNCH RD;GWYNEDD RD;31D03
CAD:UNDER CONTROL;1350 FORSYTH RD; K
CAD:OKRD;ST15;1;DIABET;1350 FORSYTH RD;13C02
CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;TAC 16;29B04
CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;DIST: 478.79 FT;29B04
CAD:STKD;ST12;1;FIRAL;7700 US 158;COUNTRYSIDE MANOR;ATHENS RD;52C01U
CAD:UNDER CONTROL;8185 GRAY LEIGH CT; OAK ;DIST: 182.10 FT
CAD:OKRD;ST15;1;SICK;8185 GRAY LEIGH CT;GRAY LEIGH DR;DIST: 182.10 FT;26A11
CAD:UNDER CONTROL;2200 OAK RIDGE RD; OAK
CAD:OKRD;ST15;1;CHEST;2200 OAK RIDGE RD;CADET DR;10D04
CAD:UNDER CONTROL;4100 CASTLEFORD DR; COL
CAD:OKRD;ST51;1;CHEST;4100 CASTLEFORD DR;HARDCASTLE DR;10D02

Contact: Active911
Agency name: Northeast Guilford Volunteer Fire Department
Location: Brown Summit, NC, United States
Sender: CAD@greensboro-nc.gov

CAD:UNDER CONTROL;4936 OLDWAY RD; B
CAD:NEFD;ST32;1;EHAZ;4936 OLDWAY RD;MCLEANSVILLE RD;55B03P
CAD:NEFD;ST32;1;EHAZ;4936 OLDWAY RD;MCLEANSVILLE RD
CAD:NEFD;ST33;1;STROKE;1807 TOWNSEND FOREST LN;OAK VALLEY LN;DIST: 118.56 FT
CAD:NEFD;ST32;1;50PI;SUMMIT AV/BROWN SUMMIT RD;29B04U
CAD:1;FIRAST;3545 SUTTON ST;ALTAMAHAW CHURCH ST;DIST: 22.92 FT
CAD:NEFD;ST32;1;50PI;NC 150 E/OLD REIDSVILLE RD;29B04
CAD:NEFD;ST32;1;UNKNWN;6181 BENTHAM RD;ELBOW OAK LN;32B02
CAD:UNDER CONTROL;5411 TURNER SMITH RD; B
CAD:NEFD;ST32;1;UNCON;5411 TURNER SMITH RD;GOLDEN NEEDLE DR;31C01
CAD:UNDER CONTROL;7219 FRIENDSHIP CHURCH RD; B ;DIST: 40.94 FT
CAD:NEFD;ST32;1;ASSLT;7219 FRIENDSHIP CHURCH RD;TURNER SMITH RD;DIST: 40.94 FT;04B01A
CAD:NEFD;ST32;1;SICK;5409 PINE LEVEL DR;MALLARD DR;26B00
CAD:FD13;ST55;1;50PI;5108 HICONE RD;HINES CHAPEL RD
CAD:UNDER CONTROL;7734 US 29 N; B ;APT 6
CAD:NEFD;ST32;1;SICK;7734 US 29 N;MONTICELLO APTS;BENAJA RD;APT 6;26C02
CAD:UNDER CONTROL;NC 150 E/POLEY RD; B ;DIST: 40.54 FT
CAD:NEFD;ST32;1;50PI;NC 150 E/POLEY RD;DIST: 40.54 FT;29B01M
CAD:NEFD;ST32;1;EXPLO;US 29 N/NC 150 E;BEHIND BLOOMS AND BUDS;57B03
CAD:UNDER CONTROL;3976 HIGH ROCK RD; GI ;DIST: 127.69 FT
CAD:MCVL;ST27;1;STRUC;3976 HIGH ROCK RD;BITTLE RD;DIST: 127.69 FT;69D08

*/

public class NCGuilfordCountyParserTest extends BaseParserTest {
  
  public NCGuilfordCountyParserTest() {
    setParser(new NCGuilfordCountyParser(), "GUILFORD COUNTY", "NC");
  }
  
  @Test
  public void testJeffBoyers() {

    doTest("T1",
        "388:CAD@greensboro-nc.gov:CAD:FYI: ;1137919;CARDIAC / RESPIRATORY ARREST;1202 BILBRO ST;W WHITTINGTON ST;IRELAND ST;09E01",
        "ID:1137919",
        "CALL:CARDIAC / RESPIRATORY ARREST",
        "ADDR:1202 BILBRO ST",
        "X:W WHITTINGTON ST & IRELAND ST",
        "CODE:09E01");

    doTest("T2",
        "397:CAD@greensboro-nc.gov:CAD:1138157;STAB / GUNSHOT WOUND;707 W FLORIDA ST;DIST: 25.68 FT;HUDGINS DR;HUDGINS DR;27D01G;SMITH HOMES",
        "ID:1138157",
        "CALL:STAB / GUNSHOT WOUND",
        "ADDR:707 W FLORIDA ST",
        "INFO:DIST: 25.68 FT / SMITH HOMES",
        "X:HUDGINS DR & HUDGINS DR",
        "CODE:27D01G");

    doTest("T3",
        "392:CAD@greensboro-nc.gov:CAD:FYI: ;1138044;CARDIAC / RESPIRATORY ARREST;827 GARDENGATE RD;WOODEDGE DR;09E02",
        "ID:1138044",
        "CALL:CARDIAC / RESPIRATORY ARREST",
        "ADDR:827 GARDENGATE RD",
        "X:WOODEDGE DR",
        "CODE:09E02");

    doTest("T4",
        "400:CAD@greensboro-nc.gov:CAD:1138253;BREATHING PROBLEMS;1515 WOODMERE DR;APT L;TEXTILE DR;PHILLIPS AV;06D02",
        "ID:1138253",
        "CALL:BREATHING PROBLEMS",
        "ADDR:1515 WOODMERE DR",
        "APT:L",
        "X:TEXTILE DR & PHILLIPS AV",
        "CODE:06D02");

    doTest("T5",
        "393:CAD@greensboro-nc.gov:CAD:1138092;ACCIDENT WITH PERSONAL INJURY;E CONE BLVD/CHESHIRE WAY;DIST: 32.08 FT;29D02p",
        "ID:1138092",
        "CALL:ACCIDENT WITH PERSONAL INJURY",
        "ADDR:E CONE BLVD & CHESHIRE WAY",
        "INFO:DIST: 32.08 FT",
        "CODE:29D02p");

    doTest("T6",
        "395:CAD@greensboro-nc.gov:CAD:1138115;ACCIDENT WITH PERSONAL INJURY;2615 HIGH POINT RD;MAYWOOD ST;W FLORIDA ST;SUNSET CLEANERS",
        "ID:1138115",
        "CALL:ACCIDENT WITH PERSONAL INJURY",
        "ADDR:2615 HIGH POINT RD",
        "X:MAYWOOD ST & W FLORIDA ST",
        "INFO:SUNSET CLEANERS");
  }
 
  @Test
  public void testShaneTaylor() {
    
    doTest("T1",
        "[summerfieldfiredist Jan24-10:01]  CAD:SMFD;ST09;1;52C03C;FIRAL;7607 BLUE SAGE CT",
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
        "CITY:SUMMERFIELD");

    doTest("T12",
        "(summerfieldfiredist Jan23-11:25) CAD:UNDER CONTROL;6308 PEPPERMILL DR; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:6308 PEPPERMILL DR",
        "CITY:OAK RIDGE");

    doTest("T13",
        "(summerfieldfiredist Jan23-19:48) CAD:UNDER CONTROL;4529 PEEPLES RD; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:4529 PEEPLES RD",
        "CITY:OAK RIDGE");

    doTest("T14",
        "(summerfieldfiredist Jun10-01:00) summerfieldfiredist\nCAD:UNDER CONTROL;5322 BUNCH RD; SU",
        "ADDR:5322 BUNCH RD",
        "CALL:UNDER CONTROL",
        "CITY:SUMMERFIELD");

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
        "CITY:BROWN SUMMIT",
        "INFO:CARDIAC / RESPIRATORY ARREST");

    doTest("T17",
        "FRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun11-00:23\nMSG:summerfieldfiredist\nCAD:UNDER CONTROL;210 JAMES DOAK PKWY; G\n",
        "ADDR:210 JAMES DOAK PKWY",
        "CITY:GREENSBORO",
        "CALL:UNDER CONTROL");

    doTest("T18",
        "1 of 2\nFRM:dispatch@edispatches.com\nSUBJ:summerfieldfiredist Jun17-16:22\nMSG:summerfieldfiredist\nCAD:OPA4;OPA4;1;MEDEM;5570 US 220 N;M AND M\n(Con't) 2 of 2\nTIRE AND AUTOMOTIVE;SPOTSWOOD RD\n(End)",
        "SRC:OPA4-OPA4",
        "PRI:1",
        "CALL:MEDEM",
        "ADDR:5570 US 220 N",
        "PLACE:M AND M TIRE AND AUTOMOTIVE",
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
        "CITY:KERNERSVILLE",
        "INFO:.",
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
        "CODE:69D03",
        "CALL:STRUC",
        "ADDR:8005 MARKETPLACE DR",
        "PLACE:TRACTOR SUPPLY CO",
        "X:NC 68 N");

    doTest("T23",
        "Subject:summerfieldfiredist Aug08-11:36\nsummerfieldfiredist \nCAD:SMFD;ST39;1;19D01;HEART;1007 NC 150 W;SPEAR CLINIC;LAKE BRANDT RD;ROO",
        "SRC:SMFD-ST39",
        "PRI:1",
        "CODE:19D01",
        "CALL:HEART",
        "ADDR:1007 NC 150 W",
        "MADDR:1007 STATE 150 W",
        "PLACE:SPEAR CLINIC",
        "INFO:ROO",
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
        "CITY:GREENSBORO");

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
        "CITY:GREENSBORO",
        "CH:TAC 10",
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
        "CITY:GREENSBORO",
        "INFO:DIST: 245.80 FT");

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
  public void testMichaelBailey() {
    
    doTest("T1",
        "FRM:cad \nMSG:CAD:UNDER CONTROL;3204 YANCEYVILLE ST; G ;APT C",
        "ADDR:3204 YANCEYVILLE ST",
        "CALL:UNDER CONTROL",
        "CITY:GREENSBORO",
        "APT:C");

    doTest("T2",
        "FRM:cad \nMSG:CAD:FYI: ;GFD1;ST07;1;STRUC;303 WINSTON ST;CHARLOTTE ST;APT A\r\n",
        "SRC:GFD1-ST07",
        "ADDR:303 WINSTON ST",
        "PRI:1",
        "CALL:STRUC",
        "X:CHARLOTTE ST",
        "APT:A");

    doTest("T3",
        "FRM:cad \nMSG:CAD:FYI: ;GFD2;ST05;1;STRUC;507 STIRLING ST;UNCG ELLIOTT BUILDING;WALKER AV\r\n",
        "SRC:GFD2-ST05",
        "ADDR:507 STIRLING ST",
        "PRI:1",
        "CALL:STRUC",
        "PLACE:UNCG ELLIOTT BUILDING",
        "X:WALKER AV");
  }
  
  @Test
  public void testEricPsycho() {

    doTest("T1",
        "CAD:UNDER CONTROL;3608 E LEE ST; G ;LOT 17",
        "ADDR:3608 E LEE ST",
        "CALL:UNDER CONTROL",
        "CITY:GREENSBORO",
        "INFO:LOT 17");

  }
  
  @Test
  public void testJonathanMoore() {

    doTest("T1",
        "FRM:station10paging@gmail.com\nMSG:station10paging:MVFD;ST10;1;UNCON;1960 FLAT ROCK RD;MCCOY RD;31D02",
        "SRC:MVFD-ST10",
        "PRI:1",
        "CALL:UNCON",
        "ADDR:1960 FLAT ROCK RD",
        "X:MCCOY RD",
        "CODE:31D02");
  
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
        "CODE:26C02");

    doTest("T2",
        "CAD:UNDER CONTROL;7717 ATHENS RD; ST",
        "ADDR:7717 ATHENS RD",
        "CALL:UNDER CONTROL",
        "CITY:STOKESDALE");

    doTest("T3",
        "CAD:SMFD;ST29;1;OSFIR;US 158/HUDSON RD;67D02B",
        "SRC:SMFD-ST29",
        "ADDR:US 158 & HUDSON RD", // Google knows this as HUDSON JAMES RD
        "PRI:1",
        "CALL:OSFIR",
        "CODE:67D02B");

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
        "CITY:STOKESDALE");

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
        "MADDR:STATE 68 N & FOGLEMAN RD",
        "PRI:1",
        "CALL:50PI",
        "CODE:29B04");

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
        "PLACE:COUNTRYSIDE MANOR",
        "X:ATHENS RD",
        "APT:A10",
        "INFO:ASSISTED LIVING",
        "CODE:28C10U");

    doTest("T14",
        "CAD:UNDER CONTROL;7700 US 158; ST ;ROOM A10 ASSISTED LIVING",
        "ADDR:7700 US 158",
        "CALL:UNDER CONTROL",
        "CITY:STOKESDALE",
        "APT:A10",
        "INFO:ASSISTED LIVING");

    doTest("T15",
        "CAD:STKD;ST12;1;ABDOM;7242 US 158;B & G CT;01C05",
        "SRC:STKD-ST12",
        "ADDR:7242 US 158",
        "PRI:1",
        "CALL:ABDOM",
        "INFO:B & G CT",
        "CODE:01C05");

    doTest("T16",
        "CAD:UNDER CONTROL;7242 US 158; ST",
        "ADDR:7242 US 158",
        "CALL:UNDER CONTROL",
        "CITY:STOKESDALE");

    doTest("T17",
        "CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;DIST: 33.67 FT;29B01",
        "SRC:OKRD-ST15",
        "ADDR:NC 68 N & E HARRELL RD",
        "MADDR:STATE 68 N & E HARRELL RD",
        "PRI:1",
        "CALL:50PI",
        "INFO:DIST: 33.67 FT",
        "CODE:29B01");

    doTest("T18",
        "CAD:STKD;ST12;1;ANBITE;8255 CURRAGHMORE CT;STOKESDALE PARK;CURRAGHMORE DR;DIST: 517.83 ft;03D00",
        "SRC:STKD-ST12",
        "ADDR:8255 CURRAGHMORE CT",
        "PRI:1",
        "CALL:ANBITE",
        "PLACE:STOKESDALE PARK",
        "X:CURRAGHMORE DR",
        "INFO:DIST: 517.83 ft",
        "CODE:03D00");

    doTest("T19",
        "CAD:UNDER CONTROL;8255 CURRAGHMORE CT; ST ;DIST: 517.83 ft",
        "ADDR:8255 CURRAGHMORE CT",
        "CALL:UNDER CONTROL",
        "CITY:STOKESDALE",
        "INFO:DIST: 517.83 ft");

    setDefaults("", "NC");
    doTest("T20",
        "CAD:1;MUTUAL;13863 US 158;GLENCOE CHURCH LOOP;FIRE ALARM",
        "PRI:1",
        "ADDR:13863 US 158",
        "CALL:MUTUAL",
        "X:GLENCOE CHURCH LOOP",
        "INFO:FIRE ALARM");
    setDefaults("GUILFORD COUNTY", "NC");

  }
  
  @Test
  public void testGreensboroFire() {

    doTest("T1",
        "CAD:FYI: ;STRUC;2407 PHILLIPS AV;LOMBARDY ST;1;C1,E1,L14,E56,L7,E7;GFD1;ST07;69D05",
        "CALL:STRUC",
        "ADDR:2407 PHILLIPS AV",
        "MADDR:2407 PHILLIPS AVE",
        "X:LOMBARDY ST",
        "PRI:1",
        "UNIT:C1,E1,L14,E56,L7,E7",
        "SRC:GFD1-ST07",
        "CODE:69D05");

    doTest("T2",
        "CAD:FYI: ;STRUC;2407 PHILLIPS AV;LOMBARDY ST;1;C1,E1,L14,E56,L7,E7;GFD1;ST07",
        "CALL:STRUC",
        "ADDR:2407 PHILLIPS AV",
        "MADDR:2407 PHILLIPS AVE",
        "X:LOMBARDY ST",
        "PRI:1",
        "UNIT:C1,E1,L14,E56,L7,E7",
        "SRC:GFD1-ST07");

    doTest("T3",
        "CAD:Update: ;1;STRUC;512 LAMA ST;ASHE ST;69D06;E61,C2,L11,L5,E8,E4",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:512 LAMA ST",
        "X:ASHE ST",
        "CODE:69D06",
        "UNIT:E61,C2,L11,L5,E8,E4");

    doTest("T4",
        "CAD:FYI: ;1;STRUC;LAMA ST/SOUTH ST;69D06;E61,C2,L11,L5,E8,E4",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:LAMA ST & SOUTH ST",
        "CODE:69D06",
        "UNIT:E61,C2,L11,L5,E8,E4");

    doTest("T5",
        "CAD:FYI: ;1;STRUC;LAMA ST/SOUTH ST;E61,C2,L11,L5,E8,E4",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:LAMA ST & SOUTH ST",
        "UNIT:E61,C2,L11,L5,E8,E4");

    doTest("T6",
        "CAD:FYI: ;1;STRUC;417 BANKS ST;SALEM ST;69D06;C1,E1,L7,L5,E7,E4",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:417 BANKS ST",
        "X:SALEM ST",
        "CODE:69D06",
        "UNIT:C1,E1,L7,L5,E7,E4");

    doTest("T7",
        "CAD:FYI: ;1;STRUC;417 BANKS ST;SALEM ST;L7,E7,E4",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:417 BANKS ST",
        "X:SALEM ST",
        "UNIT:L7,E7,E4");

    doTest("T8",
        "CAD:FYI: ;1;STRUC;1705 16TH ST;OFF RAMP;C1,E1,AIR1",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:1705 16TH ST",
        "INFO:OFF RAMP",
        "UNIT:C1,E1,AIR1");

    doTest("T9",
        "CAD:FYI: ;1;STRUC;1705 16TH ST;OFF RAMP;69D05;C1,E1,E14,L14,AIR1,L7,E7",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:1705 16TH ST",
        "INFO:OFF RAMP",
        "CODE:69D05",
        "UNIT:C1,E1,E14,L14,AIR1,L7,E7");

    doTest("T10",
        "CAD:FYI: ;1;STRUC;4038 BATTLEGROUND AV;BATTLEGROUND NORTH APTS;OLD BATTLEGROUND RD;69D05;C4,E21,L21,L5,E40,E41",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:4038 BATTLEGROUND AV",
        "MADDR:4038 BATTLEGROUND AVE",
        "PLACE:BATTLEGROUND NORTH APTS",
        "X:OLD BATTLEGROUND RD",
        "CODE:69D05",
        "UNIT:C4,E21,L21,L5,E40,E41");

    doTest("T11",
        "CAD:FYI: ;1;STRUC;4038 BATTLEGROUND AV;BATTLEGROUND NORTH APTS;OLD BATTLEGROUND RD;C4,E21,L21,L5,E40,E41",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:4038 BATTLEGROUND AV",
        "MADDR:4038 BATTLEGROUND AVE",
        "PLACE:BATTLEGROUND NORTH APTS",
        "X:OLD BATTLEGROUND RD",
        "UNIT:C4,E21,L21,L5,E40,E41");

    doTest("T12",
        "CAD:FYI: ;1;STRUC;2304 BLAIR-KHAZAN DR;FRANKLIN MCCAIN CT;C1,E1,E14,L14,E43,L7",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2304 BLAIR-KHAZAN DR",  // Google says this is BLAIR-KAHZAN DR
        "X:FRANKLIN MCCAIN CT",
        "UNIT:C1,E1,E14,L14,E43,L7");

    doTest("T13",
        "CAD:FYI: ;1;STRUC;2306 MEADOW GATE DR;LAKE JEANETTE RD;69D06;C4,L14,E43,E40,E7,L43",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2306 MEADOW GATE DR",
        "X:LAKE JEANETTE RD",
        "CODE:69D06",
        "UNIT:C4,L14,E43,E40,E7,L43");

    doTest("T14",
        "CAD:FYI: ;1;STRUC;2306 MEADOW GATE DR;LAKE JEANETTE RD;C4,L14,E43,E40,E41,L43",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2306 MEADOW GATE DR",
        "X:LAKE JEANETTE RD",
        "UNIT:C4,L14,E43,E40,E41,L43");

    doTest("T15",
        "CAD:FYI: ;MCVL;ST57;1;STRUC;117 WAGONER BEND RD;OLD BURLINGTON RD;69D10;R50,E56,T56,E37,T37,E47,T47,L57",
        "SRC:MCVL-ST57",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:117 WAGONER BEND RD",
        "X:OLD BURLINGTON RD",
        "CODE:69D10",
        "UNIT:R50,E56,T56,E37,T37,E47,T47,L57");

    doTest("T16",
        "CAD:FYI: ;MCVL;ST57;1;STRUC;117 WAGONER BEND RD;OLD BURLINGTON RD;R50,E56,T56,E37,T37,E47,T47,L57",
        "SRC:MCVL-ST57",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:117 WAGONER BEND RD",
        "X:OLD BURLINGTON RD",
        "UNIT:R50,E56,T56,E37,T37,E47,T47,L57");

    doTest("T17",
        "CAD:FYI: ;GFD2;ST61;1;STRUC;302 W MONTCASTLE DR;WINCHESTER DR;69D06;E61,E11,C2,E48,L10,L11",
        "SRC:GFD2-ST61",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:302 W MONTCASTLE DR",
        "X:WINCHESTER DR",
        "CODE:69D06",
        "UNIT:E61,E11,C2,E48,L10,L11");

    doTest("T18",
        "CAD:FYI: ;GFD2;ST61;1;STRUC;302 W MONTCASTLE DR;WINCHESTER DR;E61,E11,C2,E48,L10,L11",
        "SRC:GFD2-ST61",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:302 W MONTCASTLE DR",
        "X:WINCHESTER DR",
        "UNIT:E61,E11,C2,E48,L10,L11");

    doTest("T19",
        "CAD:FYI: ;GFD2;ST08;1;STRUC;2807 WILDWOOD DR;DEXTER AV;69D06;L10,E8",
        "SRC:GFD2-ST08",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2807 WILDWOOD DR",
        "X:DEXTER AV",
        "CODE:69D06",
        "UNIT:L10,E8");

    doTest("T20",
        "CAD:FYI: ;GFD2;ST08;1;STRUC;2807 WILDWOOD DR;DEXTER AV;C2,E10,E48,L10,L11,E8",
        "SRC:GFD2-ST08",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2807 WILDWOOD DR",
        "X:DEXTER AV",
        "UNIT:C2,E10,E48,L10,L11,E8");

    doTest("T21",
        "CAD:FYI: ;GFD2;ST48;1;STRUC;2400 PHOENIX DR;SANTA FE TR;69D06O;E61,C2,E10,E48,L10,L11",
        "SRC:GFD2-ST48",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2400 PHOENIX DR",
        "X:SANTA FE TR",
        "CODE:69D06O",
        "UNIT:E61,C2,E10,E48,L10,L11");

    doTest("T22",
        "CAD:FYI: ;GFD2;ST48;1;STRUC;2400 PHOENIX DR;SANTA FE TR;E61,C2,E10,E48,L10,L11",
        "SRC:GFD2-ST48",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2400 PHOENIX DR",
        "X:SANTA FE TR",
        "UNIT:E61,C2,E10,E48,L10,L11");

    doTest("T23",
        "CAD:FYI: ;GFD2;ST08;1;STRUC;2525 E MARKET ST;FALSE DR;69D05;E11,C2,L11,L5,E8,E53",
        "SRC:GFD2-ST08",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2525 E MARKET ST",
        "X:FALSE DR",
        "CODE:69D05",
        "UNIT:E11,C2,L11,L5,E8,E53");

    doTest("T24",
        "CAD:FYI: ;GFD1;ST01;1;STRUC;2105 YANCEYVILLE ST;REVOLUTION MILL DR;69D03;C1,E1,C4,E5,AIR1,L7,L5,E7,E4",
        "SRC:GFD1-ST01",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2105 YANCEYVILLE ST",
        "X:REVOLUTION MILL DR",
        "CODE:69D03",
        "UNIT:C1,E1,C4,E5,AIR1,L7,L5,E7,E4");

    doTest("T25",
        "CAD:FYI: ;GFD1;ST01;1;STRUC;2105 YANCEYVILLE ST;REVOLUTION MILL DR;C1,E5,AIR1,L7,L5,E7,E4",
        "SRC:GFD1-ST01",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2105 YANCEYVILLE ST",
        "X:REVOLUTION MILL DR",
        "UNIT:C1,E5,AIR1,L7,L5,E7,E4");

    doTest("T26",
        "CAD:FYI: ;GFD2;ST08;1;STRUC;2525 E MARKET ST;FALSE DR;69D05;E11,C2,L11,L5,E8,E53",
        "SRC:GFD2-ST08",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2525 E MARKET ST",
        "X:FALSE DR",
        "CODE:69D05",
        "UNIT:E11,C2,L11,L5,E8,E53");

    doTest("T27",
        "CAD:FYI: ;GFD2;ST56;1;STRUC;1416 DANS RD;PEAR ST;69D06;C2,E56,L7,L11,E53,E4",
        "SRC:GFD2-ST56",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:1416 DANS RD",
        "X:PEAR ST",
        "CODE:69D06",
        "UNIT:C2,E56,L7,L11,E53,E4");

    doTest("T28",
        "CAD:FYI: ;GFD1;ST07;1;STRUC;709 MCPHERSON ST;KENTWOOD ST;69C01;C1,E1,L14,E56,L7,E7",
        "SRC:GFD1-ST07",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:709 MCPHERSON ST",
        "X:KENTWOOD ST",
        "CODE:69C01",
        "UNIT:C1,E1,L14,E56,L7,E7");

    doTest("T29",
        "CAD:FYI: ;GFD1;ST07;1;STRUC;709 MCPHERSON ST;KENTWOOD ST;C1,E1,L14,E56,L7,E7",
        "SRC:GFD1-ST07",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:709 MCPHERSON ST",
        "X:KENTWOOD ST",
        "UNIT:C1,E1,L14,E56,L7,E7");

    doTest("T30",
        "CAD:FYI: ;GFD2;ST08;1;STRUC;2101 W MEADOWVIEW RD;RED ROOF INN;TERRACE WAY;69D01;C1,L49,C2,E10,E48,L5,E8",
        "SRC:GFD2-ST08",
        "PRI:1",
        "CALL:STRUC",
        "ADDR:2101 W MEADOWVIEW RD",
        "PLACE:RED ROOF INN",
        "X:TERRACE WAY",
        "CODE:69D01",
        "UNIT:C1,L49,C2,E10,E48,L5,E8");
  }
  
  @Test
  public void testColfaxFire() {

    doTest("T1",
        "CAD:UNDER CONTROL;SANDY RIDGE RD/SQUIRE DAVIS RD; COL ;DIST: 67.10 FT",
        "CALL:UNDER CONTROL",
        "ADDR:SANDY RIDGE RD & SQUIRE DAVIS RD",
        "CITY:COLFAX",
        "INFO:DIST: 67.10 FT");

    doTest("T2",
        "CAD:CLFX;ST26;1;50PI;SANDY RIDGE RD/SQUIRE DAVIS RD;DIST: 67.10 FT;29D02l",
        "SRC:CLFX-ST26",
        "PRI:1",
        "CALL:50PI",
        "ADDR:SANDY RIDGE RD & SQUIRE DAVIS RD",
        "INFO:DIST: 67.10 FT",
        "CODE:29D02l");

    doTest("T3",
        "CAD:HPFD;HPFD;1;FIRAST;5342 CALVIN CT;WITHERSPOON DR;(S)River Landing at Sandy Ridge (N)",
        "SRC:HPFD-HPFD",
        "PRI:1",
        "CALL:FIRAST",
        "ADDR:5342 CALVIN CT",
        "X:WITHERSPOON DR",
        "INFO:(S)River Landing at Sandy Ridge (N)");

    doTest("T4",
        "CAD:GFD3;ST19;1;VFIRE;211 I-40 E;OFF RAMP I-40 E;EB 40;71B01",
        "SRC:GFD3-ST19",
        "PRI:1",
        "CALL:VFIRE",
        "ADDR:211 I-40 E",
        "MADDR:211 I 40 E",
        "INFO:OFF RAMP I-40 E / EB 40",
        "CODE:71B01");

    doTest("T5",
        "CAD:GFD3;ST16;1;CARDIA;I-40 W/SANDY RIDGE RD;WB;09E01",
        "SRC:GFD3-ST16",
        "PRI:1",
        "CALL:CARDIA",
        "ADDR:I-40 W & SANDY RIDGE RD",
        "MADDR:I 40 W & SANDY RIDGE RD",
        "INFO:WB",
        "CODE:09E01");

    doTest("T6",
        "CAD:UNDER CONTROL;405 N BUNKER HILL RD; COL",
        "CALL:UNDER CONTROL",
        "ADDR:405 N BUNKER HILL RD",
        "CITY:COLFAX");

    doTest("T7",
        "CAD:CLFX;ST16;1;CHEST;405 N BUNKER HILL RD;MARSHALL SMITH RD;10C02",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:CHEST",
        "ADDR:405 N BUNKER HILL RD",
        "X:MARSHALL SMITH RD",
        "CODE:10C02");

    doTest("T8",
        "CAD:CLFX;ST16;1;FALL;1025 NC 68 N;EDGEFIELD RD;17B03",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:FALL",
        "ADDR:1025 NC 68 N",
        "MADDR:1025 STATE 68 N",
        "X:EDGEFIELD RD",
        "CODE:17B03");

    doTest("T9",
        "CAD:UNDER CONTROL;2914 SANDY RIDGE RD; COL",
        "CALL:UNDER CONTROL",
        "ADDR:2914 SANDY RIDGE RD",
        "CITY:COLFAX");

    doTest("T10",
        "CAD:CLFX;ST26;1;FIRAL;2914 SANDY RIDGE RD;FARMERS MARKET;TYNER RD;52C03G",
        "SRC:CLFX-ST26",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:2914 SANDY RIDGE RD",
        "PLACE:FARMERS MARKET",
        "X:TYNER RD",
        "CODE:52C03G");

    doTest("T11",
        "CAD:UNDER CONTROL;1813 QUAIL CREEK CT; COL",
        "CALL:UNDER CONTROL",
        "ADDR:1813 QUAIL CREEK CT",
        "CITY:COLFAX");

    doTest("T12",
        "CAD:CLFX;ST16;1;SEIZUR;1813 QUAIL CREEK CT;12C04",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:SEIZUR",
        "ADDR:1813 QUAIL CREEK CT",
        "CODE:12C04");

    doTest("T13",
        "CAD:PTIA;PTIA;1;ALRT1L;1000 TED JOHNSON PKWY;AIRPORT;EMPLOYEE LOT RD",
        "SRC:PTIA-PTIA",
        "PRI:1",
        "CALL:ALRT1L",
        "ADDR:1000 TED JOHNSON PKWY",
        "PLACE:AIRPORT",
        "X:EMPLOYEE LOT RD");

    doTest("T14",
        "CAD:UNDER CONTROL;131 KIDD RD; COL ;ROBERT COOPER",
        "CALL:UNDER CONTROL",
        "ADDR:131 KIDD RD",
        "CITY:COLFAX",
        "INFO:ROBERT COOPER");

    doTest("T15",
        "CAD:CLFX;ST16;1;FALL;131 KIDD RD;W MARKET ST;ROBERT COOPER;17B03G",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:FALL",
        "ADDR:131 KIDD RD",
        "X:W MARKET ST",
        "INFO:ROBERT COOPER",
        "CODE:17B03G");

    doTest("T16",
        "CAD:PCSF;ST46;1;STROKE;2005 SHANNON GRAY CT;SHANNON GRAY NURSING CENTER;RM 211;28C03D",
        "SRC:PCSF-ST46",
        "PRI:1",
        "CALL:STROKE",
        "ADDR:2005 SHANNON GRAY CT",
        "INFO:SHANNON GRAY NURSING CENTER / RM 211",
        "CODE:28C03D");

    setDefaults("", "NC");
    doTest("T17",
        "CAD:1;MUTUAL;40/66",
        "PRI:1",
        "CALL:MUTUAL",
        "ADDR:40 & 66");
    setDefaults("GUILFORD COUNTY", "NC");

    doTest("T18",
        "CAD:UNDER CONTROL;8700 TRIAD DR; COL ;DIST: 341.12 FT TRANSOURCE",
        "CALL:UNDER CONTROL",
        "ADDR:8700 TRIAD DR",
        "CITY:COLFAX",
        "INFO:DIST: 341.12 FT TRANSOURCE");

    doTest("T19",
        "CAD:GFD3;ST16;1;OSFIR;8700 TRIAD DR;SANDY RIDGE RD;DIST: 341.12 FT TRANSOURCE;67B01V",
        "SRC:GFD3-ST16",
        "PRI:1",
        "CALL:OSFIR",
        "ADDR:8700 TRIAD DR",
        "X:SANDY RIDGE RD",
        "INFO:DIST: 341.12 FT TRANSOURCE",
        "CODE:67B01V");

    doTest("T20",
        "CAD:GFD3;ST16;1;OSFIR;8700 TRIAD DR;SANDY RIDGE RD;DIST: 341.12 FT TRANSOURCE",
        "SRC:GFD3-ST16",
        "PRI:1",
        "CALL:OSFIR",
        "ADDR:8700 TRIAD DR",
        "X:SANDY RIDGE RD",
        "INFO:DIST: 341.12 FT TRANSOURCE");

    doTest("T21",
        "CAD:CLFX;ST16;1;FIRAL;1507 EAST MOUNTAIN ST;KINGDOM HALL OF JEHOVAHS;PRATT RD;52C03G",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:1507 EAST MOUNTAIN ST",
        "PLACE:KINGDOM HALL OF JEHOVAHS",
        "X:PRATT RD",
        "CODE:52C03G");

    doTest("T22",
        "CAD:CLFX;ST16;1;FIRAL;1507 EAST MOUNTAIN ST;KINGDOM HALL OF JEHOVAHS;PRATT RD",
        "SRC:CLFX-ST16",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:1507 EAST MOUNTAIN ST",
        "PLACE:KINGDOM HALL OF JEHOVAHS",
        "X:PRATT RD");
    
  }
  
  
  @Test
  public void testOakRidgeFireDepartment() {

    doTest("T1",
        "CAD:UNDER CONTROL;2050 OAK RIDGE RD; OAK ;ROOM 610",
        "CALL:UNDER CONTROL",
        "ADDR:2050 OAK RIDGE RD",
        "CITY:OAK RIDGE",
        "APT:610");

    doTest("T2",
        "CAD:OKRD;ST15;1;SEIZUR;2050 OAK RIDGE RD;OAK RIDGE ELEMENTARY SCHOOL;AUTUMN GATE DR;ROOM 610;12C00",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:SEIZUR",
        "ADDR:2050 OAK RIDGE RD",
        "PLACE:OAK RIDGE ELEMENTARY SCHOOL",
        "X:AUTUMN GATE DR",
        "APT:610",
        "CODE:12C00");

    doTest("T3",
        "CAD:UNDER CONTROL;7608 TREBBIANO DR; K",
        "CALL:UNDER CONTROL",
        "ADDR:7608 TREBBIANO DR",
        "CITY:KERNERSVILLE");

    doTest("T4",
        "CAD:STKD;ST12;1;FIRAL;7608 TREBBIANO DR;HAW RIVER RD",
        "SRC:STKD-ST12",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:7608 TREBBIANO DR",
        "X:HAW RIVER RD");

    doTest("T5",
        "CAD:OKRD;ST15;1;50PI;HAW RIVER RD/PEPPER RD;NEAR THE COUNTY LINE",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:50PI",
        "ADDR:HAW RIVER RD & PEPPER RD",
        "INFO:NEAR THE COUNTY LINE");

    doTest("T6",
        "CAD:OKRD;ST15;1;50PI;7900-BLK ALCORN RD;NC 68 N",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:50PI",
        "ADDR:7900-BLK ALCORN RD",
        "MADDR:7900 ALCORN RD",
        "X:NC 68 N");

    doTest("T7",
        "CAD:FORS;FORS;1;FIRAST;9030 GORTMAN RD;STRUCT FIRE",
        "SRC:FORS-FORS",
        "PRI:1",
        "CALL:FIRAST",
        "ADDR:9030 GORTMAN RD",
        "INFO:STRUCT FIRE");

    doTest("T8",
        "CAD:UNDER CONTROL;5362 BUNCH RD; SU",
        "CALL:UNDER CONTROL",
        "ADDR:5362 BUNCH RD",
        "CITY:SUMMERFIELD");

    doTest("T9",
        "CAD:OKRD;ST51;1;UNCON;5362 BUNCH RD;GWYNEDD RD;31D03",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CALL:UNCON",
        "ADDR:5362 BUNCH RD",
        "X:GWYNEDD RD",
        "CODE:31D03");

    doTest("T10",
        "CAD:UNDER CONTROL;1350 FORSYTH RD; K",
        "CALL:UNDER CONTROL",
        "ADDR:1350 FORSYTH RD",
        "CITY:KERNERSVILLE");

    doTest("T11",
        "CAD:OKRD;ST15;1;DIABET;1350 FORSYTH RD;13C02",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:DIABET",
        "ADDR:1350 FORSYTH RD",
        "CODE:13C02");

    doTest("T12",
        "CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;TAC 16;29B04",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:50PI",
        "ADDR:NC 68 N & E HARRELL RD",
        "MADDR:STATE 68 N & E HARRELL RD",
        "CODE:29B04",
        "CH:TAC 16");

    doTest("T13",
        "CAD:OKRD;ST15;1;50PI;NC 68 N/E HARRELL RD;DIST: 478.79 FT;29B04",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:50PI",
        "ADDR:NC 68 N & E HARRELL RD",
        "MADDR:STATE 68 N & E HARRELL RD",
        "INFO:DIST: 478.79 FT",
        "CODE:29B04");

    doTest("T14",
        "CAD:STKD;ST12;1;FIRAL;7700 US 158;COUNTRYSIDE MANOR;ATHENS RD;52C01U",
        "SRC:STKD-ST12",
        "PRI:1",
        "CALL:FIRAL",
        "ADDR:7700 US 158",
        "PLACE:COUNTRYSIDE MANOR",
        "X:ATHENS RD",
        "CODE:52C01U");

    doTest("T15",
        "CAD:UNDER CONTROL;8185 GRAY LEIGH CT; OAK ;DIST: 182.10 FT",
        "CALL:UNDER CONTROL",
        "ADDR:8185 GRAY LEIGH CT",
        "CITY:OAK RIDGE",
        "INFO:DIST: 182.10 FT");

    doTest("T16",
        "CAD:OKRD;ST15;1;SICK;8185 GRAY LEIGH CT;GRAY LEIGH DR;DIST: 182.10 FT;26A11",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:SICK",
        "ADDR:8185 GRAY LEIGH CT",
        "X:GRAY LEIGH DR",
        "INFO:DIST: 182.10 FT",
        "CODE:26A11");

    doTest("T17",
        "CAD:UNDER CONTROL;2200 OAK RIDGE RD; OAK",
        "CALL:UNDER CONTROL",
        "ADDR:2200 OAK RIDGE RD",
        "CITY:OAK RIDGE");

    doTest("T18",
        "CAD:OKRD;ST15;1;CHEST;2200 OAK RIDGE RD;CADET DR;10D04",
        "SRC:OKRD-ST15",
        "PRI:1",
        "CALL:CHEST",
        "ADDR:2200 OAK RIDGE RD",
        "X:CADET DR",
        "CODE:10D04");

    doTest("T19",
        "CAD:UNDER CONTROL;4100 CASTLEFORD DR; COL",
        "CALL:UNDER CONTROL",
        "ADDR:4100 CASTLEFORD DR",
        "CITY:COLFAX");

    doTest("T20",
        "CAD:OKRD;ST51;1;CHEST;4100 CASTLEFORD DR;HARDCASTLE DR;10D02",
        "SRC:OKRD-ST51",
        "PRI:1",
        "CALL:CHEST",
        "ADDR:4100 CASTLEFORD DR",
        "X:HARDCASTLE DR",
        "CODE:10D02");
    
  }
  
  
  @Test
  public void testNortheastGuilfordFire() {

    doTest("T1",
        "CAD:UNDER CONTROL;4936 OLDWAY RD; B",
        "CALL:UNDER CONTROL",
        "ADDR:4936 OLDWAY RD",
        "CITY:BROWN SUMMIT");

    doTest("T2",
        "CAD:NEFD;ST32;1;EHAZ;4936 OLDWAY RD;MCLEANSVILLE RD;55B03P",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:EHAZ",
        "ADDR:4936 OLDWAY RD",
        "X:MCLEANSVILLE RD",
        "CODE:55B03P");

    doTest("T3",
        "CAD:NEFD;ST32;1;EHAZ;4936 OLDWAY RD;MCLEANSVILLE RD",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:EHAZ",
        "ADDR:4936 OLDWAY RD",
        "X:MCLEANSVILLE RD");

    doTest("T4",
        "CAD:NEFD;ST33;1;STROKE;1807 TOWNSEND FOREST LN;OAK VALLEY LN;DIST: 118.56 FT",
        "SRC:NEFD-ST33",
        "PRI:1",
        "CALL:STROKE",
        "ADDR:1807 TOWNSEND FOREST LN",
        "X:OAK VALLEY LN",
        "INFO:DIST: 118.56 FT");

    doTest("T5",
        "CAD:NEFD;ST32;1;50PI;SUMMIT AV/BROWN SUMMIT RD;29B04U",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:50PI",
        "ADDR:SUMMIT AV & BROWN SUMMIT RD",
        "MADDR:SUMMIT AVE & BROWN SUMMIT RD",
        "CODE:29B04U");

    doTest("T6",
        "CAD:1;FIRAST;3545 SUTTON ST;ALTAMAHAW CHURCH ST;DIST: 22.92 FT",
        "PRI:1",
        "CALL:FIRAST",
        "ADDR:3545 SUTTON ST",
        "X:ALTAMAHAW CHURCH ST",
        "INFO:DIST: 22.92 FT");

    doTest("T7",
        "CAD:NEFD;ST32;1;50PI;NC 150 E/OLD REIDSVILLE RD;29B04",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:50PI",
        "ADDR:NC 150 E & OLD REIDSVILLE RD",
        "MADDR:STATE 150 E & OLD REIDSVILLE RD",
        "CODE:29B04");

    doTest("T8",
        "CAD:NEFD;ST32;1;UNKNWN;6181 BENTHAM RD;ELBOW OAK LN;32B02",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:UNKNWN",
        "ADDR:6181 BENTHAM RD",
        "X:ELBOW OAK LN",
        "CODE:32B02");

    doTest("T9",
        "CAD:UNDER CONTROL;5411 TURNER SMITH RD; B",
        "CALL:UNDER CONTROL",
        "ADDR:5411 TURNER SMITH RD",
        "CITY:BROWN SUMMIT");

    doTest("T10",
        "CAD:NEFD;ST32;1;UNCON;5411 TURNER SMITH RD;GOLDEN NEEDLE DR;31C01",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:UNCON",
        "ADDR:5411 TURNER SMITH RD",
        "X:GOLDEN NEEDLE DR",
        "CODE:31C01");

    doTest("T11",
        "CAD:UNDER CONTROL;7219 FRIENDSHIP CHURCH RD; B ;DIST: 40.94 FT",
        "CALL:UNDER CONTROL",
        "ADDR:7219 FRIENDSHIP CHURCH RD",
        "CITY:BROWN SUMMIT",
        "INFO:DIST: 40.94 FT");

    doTest("T12",
        "CAD:NEFD;ST32;1;ASSLT;7219 FRIENDSHIP CHURCH RD;TURNER SMITH RD;DIST: 40.94 FT;04B01A",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:ASSLT",
        "ADDR:7219 FRIENDSHIP CHURCH RD",
        "X:TURNER SMITH RD",
        "INFO:DIST: 40.94 FT",
        "CODE:04B01A");

    doTest("T13",
        "CAD:NEFD;ST32;1;SICK;5409 PINE LEVEL DR;MALLARD DR;26B00",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:SICK",
        "ADDR:5409 PINE LEVEL DR",
        "X:MALLARD DR",
        "CODE:26B00");

    doTest("T14",
        "CAD:FD13;ST55;1;50PI;5108 HICONE RD;HINES CHAPEL RD",
        "SRC:FD13-ST55",
        "PRI:1",
        "CALL:50PI",
        "ADDR:5108 HICONE RD",
        "X:HINES CHAPEL RD");

    doTest("T15",
        "CAD:UNDER CONTROL;7734 US 29 N; B ;APT 6",
        "CALL:UNDER CONTROL",
        "ADDR:7734 US 29 N",
        "APT:6",
        "CITY:BROWN SUMMIT");

    doTest("T16",
        "CAD:NEFD;ST32;1;SICK;7734 US 29 N;MONTICELLO APTS;BENAJA RD;APT 6;26C02",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:SICK",
        "ADDR:7734 US 29 N",
        "APT:6",
        "PLACE:MONTICELLO APTS",
        "X:BENAJA RD",
        "CODE:26C02");

    doTest("T17",
        "CAD:UNDER CONTROL;NC 150 E/POLEY RD; B ;DIST: 40.54 FT",
        "CALL:UNDER CONTROL",
        "ADDR:NC 150 E & POLEY RD",
        "MADDR:STATE 150 E & POLEY RD",
        "CITY:BROWN SUMMIT",
        "INFO:DIST: 40.54 FT");

    doTest("T18",
        "CAD:NEFD;ST32;1;50PI;NC 150 E/POLEY RD;DIST: 40.54 FT;29B01M",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:50PI",
        "ADDR:NC 150 E & POLEY RD",
        "MADDR:STATE 150 E & POLEY RD",
        "INFO:DIST: 40.54 FT",
        "CODE:29B01M");

    doTest("T19",
        "CAD:NEFD;ST32;1;EXPLO;US 29 N/NC 150 E;BEHIND BLOOMS AND BUDS;57B03",
        "SRC:NEFD-ST32",
        "PRI:1",
        "CALL:EXPLO",
        "ADDR:US 29 N & NC 150 E",
        "MADDR:US 29 N & STATE 150 E",
        "INFO:BEHIND BLOOMS AND BUDS",
        "CODE:57B03");

    doTest("T20",
        "CAD:UNDER CONTROL;3976 HIGH ROCK RD; GI ;DIST: 127.69 FT",
        "CALL:UNDER CONTROL",
        "ADDR:3976 HIGH ROCK RD",
        "CITY:GIBSONVILLE",
        "INFO:DIST: 127.69 FT");
   
  }
  

  public static void main(String[] args) {
    new NCGuilfordCountyParserTest().generateTests("T1");
  }
}
