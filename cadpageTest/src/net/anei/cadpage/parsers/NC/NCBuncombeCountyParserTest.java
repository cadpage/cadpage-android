package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCBuncombeCountyParserTest extends BaseParserTest {
  
  public NCBuncombeCountyParserTest() {
    setParser(new NCBuncombeCountyParser(), "BUNCOMBE COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:433 LONG SHOALS RD;B21U;SUBJECT STILL DOWN;EDGAR BULLUCK;FALLS;LEDBETTER RD;CLAYTON RD",
        "ADDR:433 LONG SHOALS RD",
        "UNIT:B21U",
        "CALL:FALLS",
        "INFO:SUBJECT STILL DOWN / EDGAR BULLUCK",
        "X:LEDBETTER RD & CLAYTON RD");

    doTest("T2",
        "CAD:1 HAMBY DR;B9;(FR) STRUCTURE FIRE;OWENBY COVE RD",
        "ADDR:1 HAMBY DR",
        "UNIT:B9",
        "CALL:(FR) STRUCTURE FIRE",
        "X:OWENBY COVE RD");

    doTest("T3",
        "CAD:411 POCONO CT;B21U;EGERTON, NANCY;CHEST PAIN;ROCKY MOUNTAIN WAY",
        "ADDR:411 POCONO CT",
        "UNIT:B21U",
        "CALL:CHEST PAIN",
        "NAME:EGERTON, NANCY",
        "X:ROCKY MOUNTAIN WAY");

    doTest("T4",
        "CAD:3055 SWEETEN CREEK RD;SMOKE DET/;PECHINEY PLASTIC PACKAGIN;ADT;(FR) FIRE ALARM;WESLEY DR;FAR HORIZONS LN;10015419",
        "ADDR:3055 SWEETEN CREEK RD",
        "CALL:SMOKE DET/ / (FR) FIRE ALARM",
        "INFO:PECHINEY PLASTIC PACKAGIN / ADT",
        "X:WESLEY DR & FAR HORIZONS LN",
        "ID:10015419");

    doTest("T5",
        "CAD:206 ROYAL PINES DR;B21;TAYLOR, ROBERT E;UNCONSCIOUS/ FAINTING;SWEETEN CREEK RD;APPIAN WAY",
        "ADDR:206 ROYAL PINES DR",
        "UNIT:B21",
        "CALL:UNCONSCIOUS/ FAINTING",
        "NAME:TAYLOR, ROBERT E",
        "X:SWEETEN CREEK RD & APPIAN WAY");

    doTest("T6",
        "CAD:345 I26 W;8283372724 DIST: 1003.28 FT;VERIZON WIRELESS;CHEST PAIN;I26 W TO BREVARD RD;10015456",
        "ADDR:345 I26 W",
        "CALL:CHEST PAIN",
        "INFO:I26 W TO BREVARD RD",
        "ID:10015456");

    doTest("T7",
        "CAD:59 SMOKEMONT DR;B21U;BEYER,JAMES;HEART PROBLEMS;BEAR PAW LN;BOUNDARY TREE PASS",
        "ADDR:59 SMOKEMONT DR",
        "UNIT:B21U",
        "CALL:HEART PROBLEMS",
        "NAME:BEYER,JAMES",
        "X:BEAR PAW LN & BOUNDARY TREE PASS");

    doTest("T8",
        "CAD:100 OAK TER;B21;TREE DOWN IN POWERLINES;VERIZON;(FR) LINES DOWN;N OAK TER;ROYAL PINES DR",
        "ADDR:100 OAK TER",
        "UNIT:B21",
        "CALL:(FR) LINES DOWN",
        "INFO:TREE DOWN IN POWERLINES",
        "X:N OAK TER & ROYAL PINES DR");

    doTest("T9",
        "CAD:16 BLUE HERON DR;B213;BECKHAM, LINDA & MALACHY;FALLS;RIVER CANE DR",
        "ADDR:16 BLUE HERON DR",
        "UNIT:B213",
        "CALL:FALLS",
        "NAME:BECKHAM, LINDA & MALACHY",
        "X:RIVER CANE DR");

    doTest("T10",
        "CAD:BCFR ASSISTANCE REQUESTED;32 MCINTYRE DR;AS03;Event spawned from ASSIST LAW ENFORCEMENT.  [12/23/10 16:54:46 HONEYCJ] [LAW] COMP IS REQ EMS COME TO CHECK HER  [12/23/10 16:54:08 BRADLEYC]\nEvent spawned from DOMESTIC DISTURBANCE.  [12/23",
        "ADDR:32 MCINTYRE DR",
        "CALL:BCFR ASSISTANCE REQUESTED",
        "INFO:AS03 / Event spawned from ASSIST LAW ENFORCEMENT. / COMP IS REQ EMS COME TO CHECK HER / Event spawned from DOMESTIC DISTURBANCE.");

    doTest("T11",
        "CAD:2147 BREVARD RD;B21U;APT 4;HEART PROBLEMS;CARLAND DR;GLENN BRIDGE RD",
        "ADDR:2147 BREVARD RD",
        "UNIT:B21U",
        "APT:4",
        "CALL:HEART PROBLEMS",
        "X:CARLAND DR & GLENN BRIDGE RD");

    doTest("T12",
        "CAD:1849 BREVARD RD;B212;BORG WARNER;(FR) VEHICLE FIRE;PLATINUM CT;HOLLY ACRES LN",
        "ADDR:1849 BREVARD RD",
        "UNIT:B212",
        "CALL:(FR) VEHICLE FIRE",
        "INFO:BORG WARNER",
        "X:PLATINUM CT & HOLLY ACRES LN");

    doTest("T13",
        "CAD:245 CEDAR LN;B21;KALOGERAKIS, ARNOLD S;ABDOMINAL PAINS / PROBLEMS;SWEETEN CREEK RD;MAPLE CT",
        "ADDR:245 CEDAR LN",
        "UNIT:B21",
        "CALL:ABDOMINAL PAINS / PROBLEMS",
        "NAME:KALOGERAKIS, ARNOLD S",
        "X:SWEETEN CREEK RD & MAPLE CT");

    doTest("T14",
        "CAD:183 WESTON RD;B21;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN;TAMPA CIR;TAMPA CIR",
        "ADDR:183 WESTON RD",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "X:TAMPA CIR & TAMPA CIR");

    doTest("T15",
        "CAD:579-BLK MILLS GAP RD;B213;8287720618 DIST: 107.57 FT;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN;CENTRAL PARK DR;DRAKES MEADOW LN",
        "ADDR:579-BLK MILLS GAP RD",
        "UNIT:B213",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "X:CENTRAL PARK DR & DRAKES MEADOW LN");

    doTest("T16",
        "CAD:357 I26 E;B21;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN;I26 E TO LONG SHOALS RD",
        "ADDR:357 I26 E",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "INFO:I26 E TO LONG SHOALS RD");

    doTest("T17",
        "CAD:365 I26 W;B21;(Z)MOTOR VEH ACCIDENT UNKNOWN;LONG SHOALS RD TO I26 W",
        "ADDR:365 I26 W",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "INFO:LONG SHOALS RD TO I26 W");

    doTest("T18",
        "CAD:375 I26 W;B21;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN;I26 W TO LONG SHOALS RD;AIRPORT RD TO I26 W",
        "ADDR:375 I26 W",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "INFO:I26 W TO LONG SHOALS RD / AIRPORT RD TO I26 W");

    doTest("T19",
        "CAD:275 MILLS GAP RD;B213;VERIZON;(Z)MOTOR VEH ACCIDENT INJURY;PINNERS COVE RD;SURREY RUN",
        "ADDR:275 MILLS GAP RD",
        "UNIT:B213",
        "CALL:(Z)MOTOR VEH ACCIDENT INJURY",
        "X:PINNERS COVE RD & SURREY RUN");

    doTest("T20",
        "CAD:355 I26 W;B21;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN;LONG SHOALS RD TO I26 W",
        "ADDR:355 I26 W",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "INFO:LONG SHOALS RD TO I26 W");

    doTest("T21",
        "CAD:900-BLK CANE CREEK RD;B213;SHP;(FR)TREE DOWN;FAIR OAKS EST;RIVER CANE DR",
        "ADDR:900-BLK CANE CREEK RD",
        "UNIT:B213",
        "CALL:(FR)TREE DOWN",
        "X:FAIR OAKS EST & RIVER CANE DR",
        "INFO:SHP");

    doTest("T22",
        "CAD:33 THOROUGHBRED CIR;B21;ASSIST OFF FLOOR;(FR) SERVICE ANY TYPE;SADDLEWOOD LN;WATSON RD",
        "ADDR:33 THOROUGHBRED CIR",
        "UNIT:B21",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST OFF FLOOR",
        "X:SADDLEWOOD LN & WATSON RD");

    doTest("T23",
        "CAD:354 I26 W;B21;VERIZON;(FR)TREE DOWN;LONG SHOALS RD TO I26 W",
        "ADDR:354 I26 W",
        "UNIT:B21",
        "CALL:(FR)TREE DOWN",
        "INFO:LONG SHOALS RD TO I26 W");

    doTest("T24",
        "CAD:244 WILLIS WAY;B21;Buncombe County;BREATHING PROBLEMS",
        "ADDR:244 WILLIS WAY",
        "UNIT:B21",
        "CALL:BREATHING PROBLEMS",
        "INFO:Buncombe County");

    doTest("T25",
        "CAD:8 DANSFORD LN;B21U;MARFLAK, JOHN & AMBER;FALLS;WELBOURN WAY",
        "ADDR:8 DANSFORD LN",
        "UNIT:B21U",
        "CALL:FALLS",
        "NAME:MARFLAK, JOHN & AMBER",
        "X:WELBOURN WAY");

    doTest("T26",
        "CAD:31 HEYWOOD RD;B21;DIST: 1.51 FT;(Z)MOTOR VEH ACCIDENT UNKNOWN;HENDERSONVILLE RD;OLD HEYWOOD RD",
        "ADDR:31 HEYWOOD RD",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "X:HENDERSONVILLE RD & OLD HEYWOOD RD");

    doTest("T27",
        "CAD:11 SABRINA DR;B21U;SMOKE IN RESIDENCE;MILLER, JAMES A;(FR) STRUCTURE FIRE;ERIKA LN",
        "ADDR:11 SABRINA DR",
        "UNIT:B21U",
        "CALL:(FR) STRUCTURE FIRE",
        "NAME:MILLER, JAMES A",
        "INFO:SMOKE IN RESIDENCE",
        "X:ERIKA LN");

    doTest("T28",
        "CAD:475 MILLS GAP RD;B213;8289892954 DIST: 27.37 ft;VERIZON;(FR)TREE DOWN;CENTRAL PARK DR;FOUR OAKS DR",
        "ADDR:475 MILLS GAP RD",
        "UNIT:B213",
        "CALL:(FR)TREE DOWN",
        "X:CENTRAL PARK DR & FOUR OAKS DR");

    doTest("T29",
        "CAD:862 CANE CREEK RD/CROSS CREEK FARM RD;B213;(FR)TREE DOWN",
        "ADDR:862 CANE CREEK RD & CROSS CREEK FARM RD",
        "UNIT:B213",
        "CALL:(FR)TREE DOWN");

    doTest("T30",
        "CAD:29 HIGHBRIDGE XING;GENERAL FA;DEERFIELD ASSISTED LIVING;SIMPLEX;(FR) FIRE ALARM;LAMBETH DR;SALISBURY DR;10015610",
        "ADDR:29 HIGHBRIDGE XING",
        "CALL:(FR) FIRE ALARM",
        "INFO:GENERAL FA / DEERFIELD ASSISTED LIVING / SIMPLEX",
        "X:LAMBETH DR & SALISBURY DR",
        "ID:10015610");

    doTest("T31",
        "CAD:226-B TAMPA CIR;B21;VERIZON;HEMORRHAGE / LACERATION;WESTON RD;WESTON RD",
        "ADDR:226-B TAMPA CIR",
        "UNIT:B21",
        "CALL:HEMORRHAGE / LACERATION",
        "X:WESTON RD & WESTON RD");

    doTest("T32",
        "CAD:35 AIRPORT RD;COM. LIFE CENTER;ARDEN SEVENTH DAY ADVENTIST;DANIELS;(FR) FIRE ALARM;OLD SHOALS RD;WELLINGTON DR;10015618",
        "ADDR:35 AIRPORT RD",
        "CALL:(FR) FIRE ALARM",
        "INFO:COM. LIFE CENTER / ARDEN SEVENTH DAY ADVENTIST / DANIELS",
        "X:OLD SHOALS RD & WELLINGTON DR",
        "ID:10015618");

    doTest("T33",
        "CAD:20 GLENN BRIDGE RD;B21;8286990135;HUBBELL;HAYNES;(FR) FIRE ALARM;HENDERSONVILLE RD;WALDEN DR",
        "ADDR:20 GLENN BRIDGE RD",
        "UNIT:B21",
        "CALL:(FR) FIRE ALARM",
        "PHONE:8286990135",
        "INFO:HUBBELL / HAYNES",
        "X:HENDERSONVILLE RD & WALDEN DR");

    doTest("T34",
        "CAD:4 WALDEN RIDGE DR;GENERAL ALARM;SIMPLEX;(FR) FIRE ALARM;HENDERSONVILLE RD;10015640",
        "ADDR:4 WALDEN RIDGE DR",
        "CALL:(FR) FIRE ALARM",
        "INFO:GENERAL ALARM / SIMPLEX",
        "X:HENDERSONVILLE RD & 10015640");

    doTest("T35",
        "CAD:50 PINEHURST CIR;B21;GENERAL ALARM;GLEN ARDEN ELEMENTARY SCHOOL;SIMPLEX;(FR) FIRE ALARM;SAINT JOHNS ST",
        "ADDR:50 PINEHURST CIR",
        "UNIT:B21",
        "CALL:(FR) FIRE ALARM",
        "INFO:GENERAL ALARM / GLEN ARDEN ELEMENTARY SCHOOL / SIMPLEX",
        "X:SAINT JOHNS ST");

    doTest("T36",
        "CAD:1 HENDERSON COUNTY HWY;B21;710 LINDSEY LOOP RD;(FR) MUTUAL AID;HENDERSONVILLE RD",
        "ADDR:1 HENDERSON COUNTY HWY",
        "UNIT:B21",
        "CALL:(FR) MUTUAL AID",
        "INFO:710 LINDSEY LOOP RD",
        "X:HENDERSONVILLE RD");

    doTest("T37",
        "CAD:202 SOUTHWAY GARDEN RD;B21;FALLS;SWEETEN CREEK RD",
        "ADDR:202 SOUTHWAY GARDEN RD",
        "UNIT:B21",
        "CALL:FALLS",
        "X:SWEETEN CREEK RD");

    doTest("T38",
        "CAD:1845 BREVARD RD;B212;LUNCHROOM;CPU INC;CONVULSIONS / SEIZURES;COMMERCE WAY;PLATINUM CT",
        "ADDR:1845 BREVARD RD",
        "UNIT:B212",
        "CALL:CONVULSIONS / SEIZURES",
        "INFO:LUNCHROOM / CPU INC",
        "X:COMMERCE WAY & PLATINUM CT");

    doTest("T39",
        "CAD:50-BLK CONCORD RD;B213;ASST STRANDED MOTORIST;RAINEY, AARON;(FR) SERVICE ANY TYPE;LAURELTON LN;WALSH TRCE",
        "ADDR:50-BLK CONCORD RD",
        "UNIT:B213",
        "CALL:(FR) SERVICE ANY TYPE",
        "NAME:RAINEY, AARON",
        "INFO:ASST STRANDED MOTORIST",
        "X:LAURELTON LN & WALSH TRCE");

    doTest("T40",
        "CAD:2251 HENDERSONVILLE RD;B21;MOUNTAIN ENERGY;ABDOMINAL PAINS / PROBLEMS;FOREST LN S;ROYAL PINES DR",
        "ADDR:2251 HENDERSONVILLE RD",
        "UNIT:B21",
        "CALL:ABDOMINAL PAINS / PROBLEMS",
        "INFO:MOUNTAIN ENERGY",
        "X:FOREST LN S & ROYAL PINES DR");

    doTest("T41",
        "CAD:331 CEDAR LN;B21;SWAIN, J WEAVER;DIABETIC PROBLEMS;MAPLE CT;MOSS LN",
        "ADDR:331 CEDAR LN",
        "UNIT:B21",
        "CALL:DIABETIC PROBLEMS",
        "NAME:SWAIN, J WEAVER",
        "X:MAPLE CT & MOSS LN");

    doTest("T42",
        "CAD:25 OLD SHOALS RD;SIMPLEX;(FR) FIRE ALARM;DOWNING DR;GLENN BRIDGE RD;10015691",
        "ADDR:25 OLD SHOALS RD",
        "CALL:(FR) FIRE ALARM",
        "INFO:SIMPLEX",
        "X:DOWNING DR & GLENN BRIDGE RD",
        "ID:10015691");

    doTest("T43",
        "CAD:277 MILLS GAP RD;B213;SMOKE DETECTOR;CPI;(FR) FIRE ALARM;PINNERS COVE RD;SURREY RUN",
        "ADDR:277 MILLS GAP RD",
        "UNIT:B213",
        "CALL:(FR) FIRE ALARM",
        "INFO:SMOKE DETECTOR / CPI",
        "X:PINNERS COVE RD & SURREY RUN");

    doTest("T44",
        "CAD:156 LOWER CHRIST SCHOOL RD/BALDWIN RD;B213;VERIZON;(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "ADDR:156 LOWER CHRIST SCHOOL RD & BALDWIN RD",
        "UNIT:B213",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN");

    doTest("T45",
        "CAD:280 BALL GAP RD;B212;ASSIST RTS;JEFF AT FIGHT WATCH;(FR) SERVICE ANY TYPE;LAKOTA TRL;BREVARD RD",
        "ADDR:280 BALL GAP RD",
        "UNIT:B212",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST RTS / JEFF AT FIGHT WATCH",
        "X:LAKOTA TRL & BREVARD RD");

    doTest("T46",
        "CAD:2607 HENDERSONVILLE RD;B21;OOB GO GROCERY;SWAN,JOHN;(FR) ASSIST LAW ENFORCEMENT;S PARK CT;WATSON RD",
        "ADDR:2607 HENDERSONVILLE RD",
        "UNIT:B21",
        "CALL:(FR) ASSIST LAW ENFORCEMENT",
        "INFO:OOB GO GROCERY",
        "NAME:SWAN,JOHN",
        "X:S PARK CT & WATSON RD");

    doTest("T47",
        "CAD:280 BALL GAP RD;B212;ASSIST PAT UNLOADING;RTS;(FR) SERVICE ANY TYPE;LAKOTA TRL;BREVARD RD",
        "ADDR:280 BALL GAP RD",
        "UNIT:B212",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST PAT UNLOADING / RTS",
        "X:LAKOTA TRL & BREVARD RD");

    doTest("T48",
        "CAD:100-BLK LEDBETTER RD;B21U;(Z)MOTOR VEH ACCIDENT UNKNOWN;LARK HL;CAVE LN",
        "ADDR:100-BLK LEDBETTER RD",
        "UNIT:B21U",
        "CALL:(Z)MOTOR VEH ACCIDENT UNKNOWN",
        "INFO:LARK HL",
        "X:CAVE LN");

    doTest("T49",
        "CAD:14 FOUR OAKS DR;B213;(FR) STRUCTURE FIRE;MILLS GAP RD",
        "ADDR:14 FOUR OAKS DR",
        "UNIT:B213",
        "CALL:(FR) STRUCTURE FIRE",
        "X:MILLS GAP RD");

    doTest("T50",
        "CAD:75 WHITE PINE DR;B213;WATER HEATER CAUGHT ON FIRE;(FR) INVESTIGATION;MAPLE ST;TROY HILL DR",
        "ADDR:75 WHITE PINE DR",
        "UNIT:B213",
        "CALL:WATER HEATER CAUGHT ON FIRE / (FR) INVESTIGATION",
        "X:MAPLE ST & TROY HILL DR");

    doTest("T51",
        "CAD:37 FOXBERRY DR;B21;ASIST WITH WATER SHUT OFF;(FR) SERVICE ANY TYPE;NEW ROCKWOOD RD;SPRING HILL DR",
        "ADDR:37 FOXBERRY DR",
        "UNIT:B21",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASIST WITH WATER SHUT OFF",
        "X:NEW ROCKWOOD RD & SPRING HILL DR");

    doTest("T52",
        "CAD:503 AVERY CREEK RD;B21U;ASSIST SUBJ UP;MCCLURE,RONALD;(FR) SERVICE ANY TYPE;NEWMAN COVE RD;OWENBY LN",
        "ADDR:503 AVERY CREEK RD",
        "UNIT:B21U",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST SUBJ UP",
        "NAME:MCCLURE,RONALD",
        "X:NEWMAN COVE RD & OWENBY LN");

    doTest("T53",
        "CAD:32 HOLLY ACRES LN;B212;(FR) SERVICE ANY TYPE;BREVARD RD",
        "ADDR:32 HOLLY ACRES LN",
        "UNIT:B212",
        "CALL:(FR) SERVICE ANY TYPE",
        "X:BREVARD RD");

    doTest("T54",
        "CAD:162 CAROLINA BLUE BIRD LOOP;B212;CLOSE,DAN & MARIE;UNKNOWN PROBLEM;ASHLEY WOODS DR",
        "ADDR:162 CAROLINA BLUE BIRD LOOP",
        "UNIT:B212",
        "CALL:UNKNOWN PROBLEM",
        "NAME:CLOSE,DAN & MARIE",
        "X:ASHLEY WOODS DR");

    doTest("T55",
        "CAD:600 BARRETT LN;ADMIN OFFICES;GIVENS ESTATE HEALTH CENTER;GIVENS ESTATES - HEALTH CENTER;(FR) FIRE ALARM;WESLEY DR;HEMLOCK DR;11000026",
        "ADDR:600 BARRETT LN",
        "CALL:(FR) FIRE ALARM",
        "INFO:ADMIN OFFICES / GIVENS ESTATE HEALTH CENTER / GIVENS ESTATES - HEALTH CENTER",
        "X:WESLEY DR & HEMLOCK DR",
        "ID:11000026");

    doTest("T56",
        "CAD:1310 FANNING BRIDGE RD;ELECTROLUX;ADT;(FR) FIRE ALARM;UNDERWOOD RD;NEW AIRPORT RD;10015794",
        "ADDR:1310 FANNING BRIDGE RD",
        "CALL:(FR) FIRE ALARM",
        "INFO:ELECTROLUX / ADT",
        "X:UNDERWOOD RD & NEW AIRPORT RD",
        "ID:10015794");

    doTest("T57",
        "CAD:1301 FANNING BRIDGE RD;B21;STANDBY;WNC AGRICULTURAL CENTER;(FR) SERVICE ANY TYPE;UNDERWOOD RD;NEW AIRPORT RD",
        "ADDR:1301 FANNING BRIDGE RD",
        "UNIT:B21",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:STANDBY / WNC AGRICULTURAL CENTER",
        "X:UNDERWOOD RD & NEW AIRPORT RD");

    doTest("T58",
        "CAD:208 MILLS GAP RD;B213;CHECK O2 ON TODLER;(FR) SERVICE ANY TYPE;SOUTHSIDE VILLAGE DR;PINNERS COVE RD",
        "ADDR:208 MILLS GAP RD",
        "UNIT:B213",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:CHECK O2 ON TODLER",
        "X:SOUTHSIDE VILLAGE DR & PINNERS COVE RD");

    doTest("T59",
        "CAD:9 SHADY OAK LN;B21U;ASSIST WITH  SMOKE DETECTOR;SPRINT PCS;(FR) SERVICE ANY TYPE;BREVARD RD",
        "ADDR:9 SHADY OAK LN",
        "UNIT:B21U",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST WITH  SMOKE DETECTOR / SPRINT PCS",
        "X:BREVARD RD");

    doTest("T60",
        "CAD:210 SUMMERGLEN DR;B212;CANNON, GLENDA;UNCONSCIOUS/ FAINTING;CASTLEROCK DR;DONNYBROOK DR",
        "ADDR:210 SUMMERGLEN DR",
        "UNIT:B212",
        "CALL:UNCONSCIOUS/ FAINTING",
        "NAME:CANNON, GLENDA",
        "X:CASTLEROCK DR & DONNYBROOK DR");

    doTest("T61",
        "CAD:615 POLE CREASMAN RD;B212;SIMS, BETTY;BREATHING PROBLEMS;HOLLY LN;HAYES GREEN RD",
        "ADDR:615 POLE CREASMAN RD",
        "UNIT:B212",
        "CALL:BREATHING PROBLEMS",
        "NAME:SIMS, BETTY",
        "X:HOLLY LN & HAYES GREEN RD");

    doTest("T62",
        "CAD:2533 HENDERSONVILLE RD;B21;APT 102;CRESCENT VIEW;CRESCENT VIEW;UNCONSCIOUS/ FAINTING;UPPER LAUREL DR;NESBITT DR",
        "ADDR:2533 HENDERSONVILLE RD",
        "UNIT:B21",
        "APT:102",
        "CALL:UNCONSCIOUS/ FAINTING",
        "INFO:CRESCENT VIEW / CRESCENT VIEW",
        "X:UPPER LAUREL DR & NESBITT DR");

    doTest("T63",
        "CAD:347 I26 E;B21;8282169743;T-Mobile USA;(Z)MOTOR VEH ACCIDENT INJURY;I26 E TO LONG SHOALS RD",
        "ADDR:347 I26 E",
        "UNIT:B21",
        "CALL:(Z)MOTOR VEH ACCIDENT INJURY",
        "PHONE:8282169743",
        "INFO:I26 E TO LONG SHOALS RD");

    doTest("T64",
        "CAD:103 APPALACHIAN BLVD;B212;RM 309;HEATHER GLEN AT ARDEN WOODS;HEATHER GLEN AT ARDENWOODS;BREATHING PROBLEMS;ROCKY MOUNTAIN WAY",
        "ADDR:103 APPALACHIAN BLVD",
        "UNIT:B212",
        "CALL:BREATHING PROBLEMS",
        "INFO:RM 309 / HEATHER GLEN AT ARDEN WOODS / HEATHER GLEN AT ARDENWOODS",
        "X:ROCKY MOUNTAIN WAY");

    doTest("T65",
        "CAD:2533 HENDERSONVILLE RD;B21;RM 242;CRESCENT VIEW;CRESCENT VIEW;UNCONSCIOUS/ FAINTING;UPPER LAUREL DR;NESBITT DR",
        "ADDR:2533 HENDERSONVILLE RD",
        "UNIT:B21",
        "CALL:UNCONSCIOUS/ FAINTING",
        "INFO:RM 242 / CRESCENT VIEW / CRESCENT VIEW",
        "X:UPPER LAUREL DR & NESBITT DR");

    doTest("T66",
        "CAD:122 EDGEWOOD DR;BOTSFORD , BARBERA;LIFE-LINE;FALLS;DOWNING DR;DOWNING DR;11000163",
        "ADDR:122 EDGEWOOD DR",
        "CALL:FALLS",
        "NAME:BOTSFORD , BARBERA",
        "INFO:LIFE-LINE",
        "X:DOWNING DR & DOWNING DR",
        "ID:11000163");

    doTest("T67",
        "CAD:342 DONNYBROOK DR;B212;SMELL OF GAS IN THE AREA;BOB ANDERSON;(FR) INVESTIGATION;AUBURNDALE DR",
        "ADDR:342 DONNYBROOK DR",
        "UNIT:B212",
        "CALL:(FR) INVESTIGATION",
        "INFO:SMELL OF GAS IN THE AREA / BOB ANDERSON",
        "X:AUBURNDALE DR");

    doTest("T68",
        "CAD:2400 APPALACHIAN BLVD;B212;CLUBHOUSE DINING RM;ARDENWOODS - CLUB HOUSE;ARDENWOODS RETIREMENT COMMUNIT;CHOKING;ROCKY MOUNTAIN WAY",
        "ADDR:2400 APPALACHIAN BLVD",
        "UNIT:B212",
        "CALL:CHOKING",
        "INFO:CLUBHOUSE DINING RM / ARDENWOODS - CLUB HOUSE / ARDENWOODS RETIREMENT COMMUNIT",
        "X:ROCKY MOUNTAIN WAY");

    doTest("T69",
        "CAD:30 HUNTER DR;B21U;STROKE;SLEEPY GAP RD",
        "ADDR:30 HUNTER DR",
        "UNIT:B21U",
        "CALL:STROKE",
        "X:SLEEPY GAP RD");

    doTest("T70",
        "CAD:202 SUMMERGLEN DR;B212;ONEILL STEPHEN AND LESA;FALLS;BENT CREEK RANCH RD;CASTLEROCK DR",
        "ADDR:202 SUMMERGLEN DR",
        "UNIT:B212",
        "CALL:FALLS",
        "INFO:ONEILL STEPHEN AND LESA",
        "X:BENT CREEK RANCH RD & CASTLEROCK DR");

    doTest("T71",
        "CAD:424 MILLS GAP RD;B213;GUTIERREZ, ROSENDO;CHEST PAIN;WESTON RD;BRAE BURN DR",
        "ADDR:424 MILLS GAP RD",
        "UNIT:B213",
        "CALL:CHEST PAIN",
        "NAME:GUTIERREZ, ROSENDO",
        "X:WESTON RD & BRAE BURN DR");

    doTest("T72",
        "CAD:7 SAINT ANDREWS RD;B213;JEFFRIES,DON;FALLS;CHIPPING GREEN DR;FOREST RIDGE DR",
        "ADDR:7 SAINT ANDREWS RD",
        "UNIT:B213",
        "CALL:FALLS",
        "NAME:JEFFRIES,DON",
        "X:CHIPPING GREEN DR & FOREST RIDGE DR");

    doTest("T73",
        "CAD:13 MCKENNA RD;MARSHALLS;(FR) FIRE ALARM;11000217",
        "ADDR:13 MCKENNA RD",
        "CALL:(FR) FIRE ALARM",
        "INFO:MARSHALLS",
        "ID:11000217");

    doTest("T74",
        "CAD:12 BERLINS VW;B102;8287120800;VERIZON;(FR) STRUCTURE FIRE;N LUTHER RD",
        "ADDR:12 BERLINS VW",
        "UNIT:B102",
        "CALL:(FR) STRUCTURE FIRE",
        "PHONE:8287120800",
        "X:N LUTHER RD");

    doTest("T75",
        "CAD:206 ROYAL PINES DR;B21;TAYLOR, ROBERT E;BREATHING PROBLEMS;SWEETEN CREEK RD;APPIAN WAY",
        "ADDR:206 ROYAL PINES DR",
        "UNIT:B21",
        "CALL:BREATHING PROBLEMS",
        "NAME:TAYLOR, ROBERT E",
        "X:SWEETEN CREEK RD & APPIAN WAY");

    doTest("T76",
        "CAD:10 BENNINGTON CT;B21;SMITH, ANN & BILL;HEART PROBLEMS;OVERLOOK RD",
        "ADDR:10 BENNINGTON CT",
        "UNIT:B21",
        "CALL:HEART PROBLEMS",
        "NAME:SMITH, ANN & BILL",
        "X:OVERLOOK RD");

    doTest("T77",
        "CAD:800 MILLS GAP RD;B213;INSIDE THE STORE;MOLLYS MARKET;MOLLY`S MARKET,;HEART PROBLEMS;CANE CREEK RD;PENLEY RD",
        "ADDR:800 MILLS GAP RD",
        "UNIT:B213",
        "CALL:HEART PROBLEMS",
        "INFO:INSIDE THE STORE / MOLLYS MARKET",
        "NAME:MOLLY`S MARKET,",
        "X:CANE CREEK RD & PENLEY RD");

    doTest("T78",
        "CAD:100 FREDERICK LAW OLMSTED WAY;B212;ARBORETUM;Buncombe County;(Z)MOTOR VEH ACCIDENT INJURY;GREENHOUSE WAY",
        "ADDR:100 FREDERICK LAW OLMSTED WAY",
        "UNIT:B212",
        "CALL:(Z)MOTOR VEH ACCIDENT INJURY",
        "INFO:ARBORETUM / Buncombe County",
        "X:GREENHOUSE WAY");

    doTest("T79",
        "CAD:280 BALL GAP RD;B212;ASSIST RTS LOADING A PATIENT;(FR) SERVICE ANY TYPE;LAKOTA TRL;BREVARD RD",
        "ADDR:280 BALL GAP RD",
        "UNIT:B212",
        "CALL:(FR) SERVICE ANY TYPE",
        "INFO:ASSIST RTS LOADING A PATIENT",
        "X:LAKOTA TRL & BREVARD RD");

    doTest("T80",
        "CAD:53 DRIFTSTONE CIR;B212;WEERASIRI,DON;(FR) HAZARDOUS MATERIAL;RIVERCREST BLVD;RIVERCREST BLVD",
        "ADDR:53 DRIFTSTONE CIR",
        "UNIT:B212",
        "CALL:(FR) HAZARDOUS MATERIAL",
        "NAME:WEERASIRI,DON",
        "X:RIVERCREST BLVD & RIVERCREST BLVD");

    doTest("T81",
        "CAD:2 BENT OAK LN;SIZEMORE, E;(FR) STRUCTURE FIRE;OVERLOOK RD;DEERHAVEN LN;11000280",
        "ADDR:2 BENT OAK LN",
        "CALL:(FR) STRUCTURE FIRE",
        "NAME:SIZEMORE, E",
        "X:OVERLOOK RD & DEERHAVEN LN",
        "ID:11000280");

    doTest("T82",
        "CAD:25 OLD SHOALS RD;WATER FLOW ZONE M-123;FLINT GROUP;SIMPLEX;(FR) FIRE ALARM;DOWNING DR;GLENN BRIDGE RD;11000292",
        "ADDR:25 OLD SHOALS RD",
        "CALL:(FR) FIRE ALARM",
        "INFO:WATER FLOW ZONE M-123 / FLINT GROUP / SIMPLEX",
        "X:DOWNING DR & GLENN BRIDGE RD",
        "ID:11000292");

    doTest("T83",
        "CAD:49 HIGHBRIDGE XING;RM 4101/ASSIST SUB. OFF FLOOR;DEERFIELD SKILLED CARE;DEERFIELD RETIREMENT;(FR) SERVICE ANY TYPE;LAMBETH DR;SALISBURY DR;11000293",
        "ADDR:49 HIGHBRIDGE XING",
        "CALL:RM 4101/ASSIST SUB. OFF FLOOR / (FR) SERVICE ANY TYPE",
        "INFO:DEERFIELD SKILLED CARE / DEERFIELD RETIREMENT",
        "X:LAMBETH DR & SALISBURY DR",
        "ID:11000293");

    doTest("T84",
        "CAD:100 VISTA BLVD;B212;NYPRO;(Z)MOTOR VEH ACCIDENT INJURY;BREVARD RD;TRIDENT DR",
        "ADDR:100 VISTA BLVD",
        "UNIT:B212",
        "CALL:(Z)MOTOR VEH ACCIDENT INJURY",
        "INFO:NYPRO",
        "X:BREVARD RD & TRIDENT DR");

    doTest("T85",
        "CAD:607 PARK SOUTH BLVD;B212;(FR) SERVICE ANY TYPE;BREVARD RD;PARK SOUTH CT",
        "ADDR:607 PARK SOUTH BLVD",
        "UNIT:B212",
        "CALL:(FR) SERVICE ANY TYPE",
        "X:BREVARD RD & PARK SOUTH CT");

    doTest("T86",
        "CAD:2533 HENDERSONVILLE RD;B21;RM 321;CRESCENT VIEW;CRESCENT VIEW;FALLS;UPPER LAUREL DR;NESBITT DR",
        "ADDR:2533 HENDERSONVILLE RD",
        "UNIT:B21",
        "CALL:FALLS",
        "INFO:RM 321 / CRESCENT VIEW / CRESCENT VIEW",
        "X:UPPER LAUREL DR & NESBITT DR");

    doTest("T87",
        "CAD:92 FAIR OAKS RD;B21;LIFELINE;UNKNOWN PROBLEM;ROYAL OAKS RD;N FAIR OAKS RD",
        "ADDR:92 FAIR OAKS RD",
        "UNIT:B21",
        "CALL:UNKNOWN PROBLEM",
        "INFO:LIFELINE",
        "X:ROYAL OAKS RD & N FAIR OAKS RD");

    doTest("T88",
        "CAD:4 HICKORY TREE RD;B11;VERIZON;(Z)MOTOR VEH ACCIDENT INJURY;LOWER GRASSY BRANCH RD;JULIANNE PL",
        "ADDR:4 HICKORY TREE RD",
        "UNIT:B11",
        "CALL:(Z)MOTOR VEH ACCIDENT INJURY",
        "X:LOWER GRASSY BRANCH RD & JULIANNE PL");

    doTest("T89",
        "S:CAD:111 OLD WEAVERVILLE RD;B20;BLAZER, RUTH;UNCONSCIOUS/ FAINTING M:",
        "ADDR:111 OLD WEAVERVILLE RD",
        "UNIT:B20",
        "CALL:UNCONSCIOUS/ FAINTING",
        "NAME:BLAZER, RUTH");
  }
  

  public static void main(String[] args) {
    new NCBuncombeCountyParserTest().generateTests("T89");
  }
}
