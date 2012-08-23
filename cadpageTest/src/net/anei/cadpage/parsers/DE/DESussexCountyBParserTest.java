package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.DE.DESussexCountyBParser;

import org.junit.Test;

public class DESussexCountyBParserTest extends BaseParserTest {
  
  public DESussexCountyBParserTest() {
    setParser(new DESussexCountyBParser(), "SUSEX COUNTY", "DE");
  }
  
  @Test
  public void testRichardShort() {

    doTest("T1",
        "(CAD Alert) 78ST   Call at: 21303 Airport Rd         Loc: TEST CALL TEST CALL      City:19947  Problem:  Structure Fire                  Inc#: 2012-018545   ",
        "ID:2012-018545",
        "SRC:78ST",
        "ADDR:21303 Airport Rd",
        "PLACE:TEST CALL TEST CALL",
        "CITY:GEORGETOWN",
        "CALL:Structure Fire");

    doTest("T2",
        "(CAD Alert) Inc#: 2012-018946 78AS3  Call at: 10064 Memory Rd          Loc:                          City:19952  Problem:  Sick Person(Specific Diag)-BLS   D",
        "ID:2012-018946",
        "SRC:78AS3",
        "ADDR:10064 Memory Rd",
        "CITY:HARRINGTON",
        "CALL:Sick Person(Specific Diag)-BLS");

    doTest("T3",
        "(CAD Alert) Inc#: 2012-018835 78AST  Call at: 14514 Oak Rd             Loc:                          City:19950  Problem:  Assault/Sexual Assault-BLS       D",
        "ID:2012-018835",
        "SRC:78AST",
        "ADDR:14514 Oak Rd",
        "CITY:GREENWOOD",
        "CALL:Assault/Sexual Assault-BLS");

    doTest("T4",
        "(CAD Alert) 78AST  Call at: 6300 Seashore Hwy        Loc: USE BACK DOOR            City:19933  Problem:  Chest Pain-ALS                  Inc#: 2012-018955    ",
        "ID:2012-018955",
        "SRC:78AST",
        "ADDR:6300 Seashore Hwy",
        "PLACE:USE BACK DOOR",
        "CITY:BRIDGEVILLE",
        "CALL:Chest Pain-ALS");

  }
  
  @Test
  public void testCodeMessaging1() {

    doTest("T1",
        "Sta: Inc#: 2012-018227 78AS3 Loc:: 14042 Mile Stretch Rd Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS DISP: 16:23:46 Cross St: ADAMS RD/STONE LN",
        "ID:2012-018227",
        "SRC:78AS3",
        "ADDR:14042 Mile Stretch Rd",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:16:23:46",
        "X:ADAMS RD/STONE LN");

    doTest("T2",
        "Sta: 78AST Loc:: Redden Rd & Sussex Hwy Loc: City: :19933 ---: Traffic/TransportationAcdntBLS Inc#: 2012-016829 Lat: 38749167 Long: 75593147 DISP: 17:43:24 Cross St:",
        "ID:2012-016829",
        "SRC:78AST",
        "ADDR:Redden Rd & Sussex Hwy",
        "CITY:BRIDGEVILLE",
        "CALL:Traffic/TransportationAcdntBLS",
        "GPS:38.749167 75.593147",
        "TIME:17:43:24");

    doTest("T3",
        "Sta: Inc#: 2012-018395 78AST Loc:: 12046 Sunset Ln Loc: Country Rest Home, new seCity: :19950 ---: Interfacillity/Palliative-ALS DISP: 12:11:29 Cross St: YODER DR/MARELLA LN",
        "ID:2012-018395",
        "SRC:78AST",
        "ADDR:12046 Sunset Ln",
        "PLACE:Country Rest Home, new se",
        "CITY:GREENWOOD",
        "CALL:Interfacillity/Palliative-ALS",
        "TIME:12:11:29",
        "X:YODER DR/MARELLA LN");

    doTest("T4",
        "Sta: 78AST Loc:: 6496 Seashore Hwy Loc: white hse black suv in drCity: :19933 ---: Convulsions/Seizures-ALS Inc#: 2012-016825 Lat: 38759789 Long: 75637263 DISP: 16:16:57 Cross St: POLK RD/TWIN LANES FARM RD",
        "ID:2012-016825",
        "SRC:78AST",
        "ADDR:6496 Seashore Hwy",
        "PLACE:white hse black suv in dr",
        "CITY:BRIDGEVILLE",
        "CALL:Convulsions/Seizures-ALS",
        "GPS:38.759789 75.637263",
        "TIME:16:16:57",
        "X:POLK RD/TWIN LANES FARM RD");

    doTest("T5",
        "Sta: Inc#: 2012-018289 78ST Loc:: 12502 Woodbridge Rd Loc: City: :19950 ---: Breathing ---s-ALS DISP: 12:12:50 Cross St: MC DOWELL RD/DEER MEADOWS RD",
        "ID:2012-018289",
        "SRC:78ST",
        "ADDR:12502 Woodbridge Rd",
        "CITY:GREENWOOD",
        "CALL:Breathing ---s-ALS",
        "TIME:12:12:50",
        "X:MC DOWELL RD/DEER MEADOWS RD");

    doTest("T6",
        "Sta: Inc#: 2012-018284 78AST Loc:: 11120 - 11123 Coon Den RdLoc: 11192 City: :19950 ---: Sick Person(Specific Diag)-BLS DISP: 11:40:15 Cross St: JOHNSON HUNT RN/SHAWNEE RD",
        "ID:2012-018284",
        "SRC:78AST",
        "ADDR:11120 - 11123 Coon Den Rd",
        "MADDR:11120 Coon Den Rd",
        "PLACE:11192",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:11:40:15",
        "X:JOHNSON HUNT RN/SHAWNEE RD");

    doTest("T7",
        "Sta: 78ST Loc:: 19 Haven Dr Loc: City: :19947 ---: Breathing ---s-ALS Inc#: 2012-018709 Lat: 38656946 Long: 75321836 DISP: 08:10:20 Cross St: PETERKINS RD/OAK KNOLL CT",
        "ID:2012-018709",
        "SRC:78ST",
        "ADDR:19 Haven Dr",
        "CITY:GEORGETOWN",
        "CALL:Breathing ---s-ALS",
        "GPS:38.656946 75.321836",
        "TIME:08:10:20",
        "X:PETERKINS RD/OAK KNOLL CT");

    doTest("T8",
        "Sta: Inc#: 2012-018708 78ST Loc:: 292 Staytonville Rd Loc: tanker compant assist StaCity: :19952 ---: Structure Fire DISP: 08:08:35 Cross St: WOLFS TRAIL END DR/WOODYARD RD",
        "ID:2012-018708",
        "SRC:78ST",
        "ADDR:292 Staytonville Rd",
        "PLACE:tanker compant assist Sta",
        "CITY:HARRINGTON",
        "CALL:Structure Fire",
        "TIME:08:08:35",
        "X:WOLFS TRAIL END DR/WOODYARD RD");

    doTest("T9",
        "Sta: 78AS2 Loc:: 7 W Market St Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017442 DISP: 12:35:34 Cross St: Dead End/N CHURCH ST",
        "ID:2012-017442",
        "SRC:78AS2",
        "ADDR:7 W Market St",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:12:35:34",
        "X:Dead End/N CHURCH ST");

    doTest("T10",
        "Sta: Inc#: 2012-018217 78AS3 Loc:: 13469 Wolf Rd Loc: City: :19950 ---: Assault/Sexual Assault-BLS DISP: 14:40:31 Cross St: OWENS RD/Dead End",
        "ID:2012-018217",
        "SRC:78AS3",
        "ADDR:13469 Wolf Rd",
        "CITY:GREENWOOD",
        "CALL:Assault/Sexual Assault-BLS",
        "TIME:14:40:31",
        "X:OWENS RD/Dead End");

    doTest("T11",
        "Sta: 78C Loc:: 12808 Mennonite School RdLoc: City: :19950 ---: Alarm Company Inc#: 2012-016589 DISP: 01:28:21 Cross St: WOOD LN/VANITY LN",
        "ID:2012-016589",
        "SRC:78C",
        "ADDR:12808 Mennonite School Rd",
        "CITY:GREENWOOD",
        "CALL:Alarm Company",
        "TIME:01:28:21",
        "X:WOOD LN/VANITY LN");

    doTest("T12",
        "Sta: 78AS3 Loc:: 13600 - 13738 Mile StretcLoc: stage City: :19950 ---: Overdose/Poisoning-ALS Inc#: 2012-016170 DISP: 20:12:27 Cross St: JAMESWAY LN/SCOTTS STORE RD",
        "ID:2012-016170",
        "SRC:78AS3",
        "ADDR:13600 - 13738 Mile Stretc",
        "MADDR:13600 Mile Stretc",
        "PLACE:stage",
        "CITY:GREENWOOD",
        "CALL:Overdose/Poisoning-ALS",
        "TIME:20:12:27",
        "X:JAMESWAY LN/SCOTTS STORE RD");

    doTest("T13",
        "Sta: 78AS3 Loc:: 11595 Sussex Hwy Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017516 DISP: 08:55:58 Cross St: NANTICOKE BUSINESS PARK DR/GREENWOOD RD",
        "ID:2012-017516",
        "SRC:78AS3",
        "ADDR:11595 Sussex Hwy",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:08:55:58",
        "X:NANTICOKE BUSINESS PARK DR/GREENWOOD RD");

    doTest("T14",
        "Sta: 78C Loc:: 0 Seachase Ln Loc: Seachase of Greenwood 304City: :19950 ---: Appliance Fire Inc#: 2012-017559 DISP: 18:55:11 Cross St: Cart Branch Cir/Cart Branch Cir",
        "ID:2012-017559",
        "SRC:78C",
        "ADDR:Seachase Ln",
        "MADDR:Seachase Ln & Cart Branch Cir",
        "PLACE:Seachase of Greenwood 304",
        "CITY:GREENWOOD",
        "CALL:Appliance Fire",
        "TIME:18:55:11",
        "X:Cart Branch Cir/Cart Branch Cir");

    doTest("T15",//start check here
        "Sta: 78AS1 Loc:: 13230 Hunters Cove Rd Loc: City: :19950 ---: Stroke-ALS Inc#: 2012-017266 DISP: 16:49:32 Cross St: Dead End/OWENS RD",
        "ID:2012-017266",
        "SRC:78AS1",
        "ADDR:13230 Hunters Cove Rd",
        "CITY:GREENWOOD",
        "CALL:Stroke-ALS",
        "TIME:16:49:32",
        "X:Dead End/OWENS RD");

    doTest("T16",
        "Sta: 78AS3 Loc:: 6190 Hickman Rd Loc: City: :19950 ---: Chest Pain-ALS Inc#: 2012-016107 DISP: 22:35:27 Cross St: NINE FOOT RD/Dead End",
        "ID:2012-016107",
        "SRC:78AS3",
        "ADDR:6190 Hickman Rd",
        "CITY:GREENWOOD",
        "CALL:Chest Pain-ALS",
        "TIME:22:35:27",
        "X:NINE FOOT RD/Dead End");

    doTest("T17",
        "Sta: 78AST Loc:: 100 W Market St Loc: City: :19950 ---: Psychiatric/Abnormal Behvr-BLS Inc#: 2012-016101 DISP: 21:26:39 Cross St: N CHURCH ST/N FIRST ST",
        "ID:2012-016101",
        "SRC:78AST",
        "ADDR:100 W Market St",
        "CITY:GREENWOOD",
        "CALL:Psychiatric/Abnormal Behvr-BLS",
        "TIME:21:26:39",
        "X:N CHURCH ST/N FIRST ST");

    doTest("T18",
        "Sta: 78AS3 Loc:: 0 Lester Ave Loc: yellow and white trailor City: :19950 ---: Headache-BLS Inc#: 2012-016006 Lat: 38789084 Long: 75596637 DISP: 20:20:43 Cross St: ALPHA ST/ADAMS RD",
        "ID:2012-016006",
        "SRC:78AS3",
        "ADDR:Lester Ave",
        "MADDR:Lester Ave & ALPHA ST",
        "PLACE:yellow and white trailor",
        "CITY:GREENWOOD",
        "CALL:Headache-BLS",
        "GPS:38.789084 75.596637",
        "TIME:20:20:43",
        "X:ALPHA ST/ADAMS RD");

    doTest("T19",
        "Sta: 78AS3 Loc:: 205 Governors Ave Loc: City: :19950 ---: Breathing ---s-ALS Inc#: 2012-016260 DISP: 20:19:51 Cross St: SUSSEX AVE/MARYLAND AVE",
        "ID:2012-016260",
        "SRC:78AS3",
        "ADDR:205 Governors Ave",
        "CITY:GREENWOOD",
        "CALL:Breathing ---s-ALS",
        "TIME:20:19:51",
        "X:SUSSEX AVE/MARYLAND AVE");

    doTest("T20",
        "Sta: 78AST Loc:: 6788 Whiteleysburg Rd Loc: amb 78 City: :19952 ---: Psychiatric/Abnormal Behvr-BLS Inc#: 2012-017161 DISP: 11:48:09 Cross St: BROWNSVILLE RD/Dead End",
        "ID:2012-017161",
        "SRC:78AST",
        "ADDR:6788 Whiteleysburg Rd",
        "PLACE:amb 78",
        "CITY:HARRINGTON",
        "CALL:Psychiatric/Abnormal Behvr-BLS",
        "TIME:11:48:09",
        "X:BROWNSVILLE RD/Dead End");

    doTest("T21",
        "Sta: 78AS1 Loc:: Sussex Hwy & Greenwood RdLoc: City: :19950 ---: Traffic/TransportationAcdntBLS Inc#: 2012-017619 DISP: 13:18:01 Cross St:",
        "ID:2012-017619",
        "SRC:78AS1",
        "ADDR:Sussex Hwy & Greenwood Rd",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntBLS",
        "TIME:13:18:01");

    doTest("T22",
        "Sta: 78C Loc:: 13149 Mennonite School RdLoc: City: :19950 ---: Outside Fire Inc#: 2012-017948 DISP: 16:11:32 Cross St: VANITY LN/BEACH HWY",
        "ID:2012-017948",
        "SRC:78C",
        "ADDR:13149 Mennonite School Rd",
        "CITY:GREENWOOD",
        "CALL:Outside Fire",
        "TIME:16:11:32",
        "X:VANITY LN/BEACH HWY");

    doTest("T23",
        "Sta: 78AST Loc:: Sussex Hwy & Newton Way Loc: n/b City: :19950 ---: Traffic/TransportationAcdntBLS Inc#: 2012-018120 Lat: 38767148 Long: 75592781 DISP: 15:21:34 Cross St:",
        "ID:2012-018120",
        "SRC:78AST",
        "ADDR:Sussex Hwy & Newton Way",
        "PLACE:n/b",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntBLS",
        "GPS:38.767148 75.592781",
        "TIME:15:21:34");

    doTest("T24",
        "Sta: 78AS3 Loc:: 8862 Greenwood Rd Loc: City: :19950 ---: Convulsions/Seizures-ALS Inc#: 2012-016681 DISP: 01:19:12 Cross St: FIRST ST/NANTICOKE BUSINESS PARK DR",
        "ID:2012-016681",
        "SRC:78AS3",
        "ADDR:8862 Greenwood Rd",
        "CITY:GREENWOOD",
        "CALL:Convulsions/Seizures-ALS",
        "TIME:01:19:12",
        "X:FIRST ST/NANTICOKE BUSINESS PARK DR");

    doTest("T25",
        "Sta: 78AS2 Loc:: 2985 Seashore Hwy Loc: City: :19950 ---: Unconscious/Fainting(Near)-ALS Inc#: 2012-017090 DISP: 13:20:29 Cross St: WOODENHAWK RD/WALNUT TREE FARM RD",
        "ID:2012-017090",
        "SRC:78AS2",
        "ADDR:2985 Seashore Hwy",
        "CITY:GREENWOOD",
        "CALL:Unconscious/Fainting(Near)-ALS",
        "TIME:13:20:29",
        "X:WOODENHAWK RD/WALNUT TREE FARM RD");

    doTest("T26",
        "Sta: 78AST Loc:: Tower Hill Rd & S Dupont Loc: amb 78 assist sta 50 City: :19952 ---: Traffic/TransportationAcdntBLS Inc#: 2012-017409 DISP: 01:10:36 Cross St:",
        "ID:2012-017409",
        "SRC:78AST",
        "ADDR:Tower Hill Rd & S Dupont",
        "PLACE:amb 78 assist sta 50",
        "CITY:HARRINGTON",
        "CALL:Traffic/TransportationAcdntBLS",
        "TIME:01:10:36");

    doTest("T27",
        "Sta: 78AST Loc:: 502 E Market St Loc: Discover Bank City: :19950 ---: Falls-BLS Inc#: 2012-017901 DISP: 10:45:15 Cross St: Sussex Hwy/Duck Creek Ln",
        "ID:2012-017901",
        "SRC:78AST",
        "ADDR:502 E Market St",
        "PLACE:Discover Bank",
        "CITY:GREENWOOD",
        "CALL:Falls-BLS",
        "TIME:10:45:15",
        "X:Sussex Hwy/Duck Creek Ln");

    doTest("T28",
        "Sta: Inc#: 2012-017990 78AS3 Loc:: 300 W Market St Loc: City: :19950 ---: Abdominal Pain-ALS DISP: 08:15:44 Cross St: N FIRST ST/S 2ND ST",
        "ID:2012-017990",
        "SRC:78AS3",
        "ADDR:300 W Market St",
        "CITY:GREENWOOD",
        "CALL:Abdominal Pain-ALS",
        "TIME:08:15:44",
        "X:N FIRST ST/S 2ND ST");

    doTest("T29",
        "Sta: 78AST Loc:: Redden Rd & Apple Tree RdLoc: City: :19933 ---: Traffic/TransportationAcdntALS Inc#: 2012-018637 Lat: 38748040 Long: 75551423 DISP: 11:57:02 Cross St:",
        "ID:2012-018637",
        "SRC:78AST",
        "ADDR:Redden Rd & Apple Tree Rd",
        "CITY:BRIDGEVILLE",
        "CALL:Traffic/TransportationAcdntALS",
        "GPS:38.748040 75.551423",
        "TIME:11:57:02");

    doTest("T30",
        "Sta: 78ST Loc:: 14530 Sparrow Dr Loc: City: :19950 ---: Chest Pain-ALS Inc#: 2012-017078 DISP: 10:45:22 Cross St: ADAMS RD/Dead End",
        "ID:2012-017078",
        "SRC:78ST",
        "ADDR:14530 Sparrow Dr",
        "CITY:GREENWOOD",
        "CALL:Chest Pain-ALS",
        "TIME:10:45:22",
        "X:ADAMS RD/Dead End");

    doTest("T31",
        "Sta: 78AST Loc:: 18427 - 18501 Sussex Hwy Loc: S/B City: :19933 ---: Traffic/TransportationAcdntALS Inc#: 2012-017808 Lat: 38729900 Long: 75591016 DISP: 12:38:11 Cross St: RIFLE RANGE RD/CONNECTING ROAD",
        "ID:2012-017808",
        "SRC:78AST",
        "ADDR:18427 - 18501 Sussex Hwy",
        "MADDR:18427 Sussex Hwy",
        "PLACE:S/B",
        "CITY:BRIDGEVILLE",
        "CALL:Traffic/TransportationAcdntALS",
        "GPS:38.729900 75.591016",
        "TIME:12:38:11",
        "X:RIFLE RANGE RD/CONNECTING ROAD");

    doTest("T32",
        "Sta: 78AST Loc:: 4003 Seashore Hwy Loc: City: :19933 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017809 DISP: 13:09:24 Cross St: WOODENHAWK RD/WALNUT TREE FARM RD",
        "ID:2012-017809",
        "SRC:78AST",
        "ADDR:4003 Seashore Hwy",
        "CITY:BRIDGEVILLE",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:13:09:24",
        "X:WOODENHAWK RD/WALNUT TREE FARM RD");

    doTest("T33",
        "Sta: Inc#: 2012-018589 78AS1 Loc:: 12733 Shawnee Rd Loc: City: :19950 ---: Chest Pain-ALS DISP: 21:29:15 Cross St: VICTORY LN/BEACH HWY",
        "ID:2012-018589",
        "SRC:78AS1",
        "ADDR:12733 Shawnee Rd",
        "CITY:GREENWOOD",
        "CALL:Chest Pain-ALS",
        "TIME:21:29:15",
        "X:VICTORY LN/BEACH HWY");

    doTest("T34",
        "Sta: 78AS3 Loc:: 8460 - 8518 Hickman Rd Loc: City: :19950 ---: Traffic/TransportationAcdntBLS Inc#: 2012-015931 Lat: 38808690 Long: 75600119 DISP: 07:32:05 Cross St: DELAWARE DR/W MARKET ST",
        "ID:2012-015931",
        "SRC:78AS3",
        "ADDR:8460 - 8518 Hickman Rd",
        "MADDR:8460 Hickman Rd",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntBLS",
        "GPS:38.808690 75.600119",
        "TIME:07:32:05",
        "X:DELAWARE DR/W MARKET ST");

    doTest("T35",
        "Sta: 78AST Loc:: 13384 Saint Johnstown Rd Loc: City: :19950 ---: Diabetic ---s-BLS Inc#: 2012-016052 Lat: 38804634 Long: 75575759 DISP: 11:45:43 Cross St: SHAWNEE RD/SUGAR HILL RD",
        "ID:2012-016052",
        "SRC:78AST",
        "ADDR:13384 Saint Johnstown Rd",
        "CITY:GREENWOOD",
        "CALL:Diabetic ---s-BLS",
        "GPS:38.804634 75.575759",
        "TIME:11:45:43",
        "X:SHAWNEE RD/SUGAR HILL RD");

    doTest("T36",
        "Sta: 78AST Loc:: 2985 Seashore Hwy Loc: City: :19950 ---: Chest Pain-ALS Inc#: 2012-016130 DISP: 10:04:39 Cross St: WOODENHAWK RD/WALNUT TREE FARM RD",
        "ID:2012-016130",
        "SRC:78AST",
        "ADDR:2985 Seashore Hwy",
        "CITY:GREENWOOD",
        "CALL:Chest Pain-ALS",
        "TIME:10:04:39",
        "X:WOODENHAWK RD/WALNUT TREE FARM RD");

    doTest("T37",
        "Sta: 78AST Loc:: 15639 Sharps Mill Rd Loc: City: : ---: Convulsions/Seizures-ALS Inc#: 2012-016126 DISP: 08:40:41 Cross St:",
        "ID:2012-016126",
        "SRC:78AST",
        "ADDR:15639 Sharps Mill Rd",
        "CALL:Convulsions/Seizures-ALS",
        "TIME:08:40:41");

    doTest("T38",
        "Sta: 78AS3 Loc:: 5 W Market St Loc: City: :19950 ---: Traumatic Injuries-BLS Inc#: 2012-016324 DISP: 13:16:55 Cross St: Dead End/N CHURCH ST",
        "ID:2012-016324",
        "SRC:78AS3",
        "ADDR:5 W Market St",
        "CITY:GREENWOOD",
        "CALL:Traumatic Injuries-BLS",
        "TIME:13:16:55",
        "X:Dead End/N CHURCH ST");

    doTest("T39",
        "Sta: 78AS3 Loc:: 600 E Market St Loc: royal farms City: :19950 ---: Hemorrhage/Lacerations-ALS Inc#: 2012-016531 DISP: 11:32:21 Cross St: DUCK CREEK LN/SUSSEX HWY",
        "ID:2012-016531",
        "SRC:78AS3",
        "ADDR:600 E Market St",
        "PLACE:royal farms",
        "CITY:GREENWOOD",
        "CALL:Hemorrhage/Lacerations-ALS",
        "TIME:11:32:21",
        "X:DUCK CREEK LN/SUSSEX HWY");

    doTest("T40",
        "Sta: 78AS3 Loc:: 12608 Webb Farm Rd Loc: City: :19950 ---: Stroke-ALS Inc#: 2012-016972 DISP: 06:12:40 Cross St: CENTURY FARM RD/BEACH HWY",
        "ID:2012-016972",
        "SRC:78AS3",
        "ADDR:12608 Webb Farm Rd",
        "CITY:GREENWOOD",
        "CALL:Stroke-ALS",
        "TIME:06:12:40",
        "X:CENTURY FARM RD/BEACH HWY");

    doTest("T41",
        "Sta: 78AST Loc:: Hickman Rd & Scotts StoreLoc: City: :19950 ---: Traffic/TransportationAcdntBLS Inc#: 2012-017076 DISP: 10:16:55 Cross St:",
        "ID:2012-017076",
        "SRC:78AST",
        "ADDR:Hickman Rd & Scotts Store",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntBLS",
        "TIME:10:16:55");

    doTest("T42",
        "Sta: 78AST Loc:: 12388 - 12408 Sussex Hwy Loc: smiths City: :19950 ---: Falls-BLS Inc#: 2012-017062 DISP: 08:26:36 Cross St: GREENWOOD RD/CONNECTING ROAD",
        "ID:2012-017062",
        "SRC:78AST",
        "ADDR:12388 - 12408 Sussex Hwy",
        "MADDR:12388 Sussex Hwy",
        "PLACE:smiths",
        "CITY:GREENWOOD",
        "CALL:Falls-BLS",
        "TIME:08:26:36",
        "X:GREENWOOD RD/CONNECTING ROAD");

    doTest("T43",
        "Sta: 78AS2 Loc:: 980 Gallo Rd Loc: City: :19952 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017318 DISP: 05:53:01 Cross St: ANDREWVILLE RD/Dead End",
        "ID:2012-017318",
        "SRC:78AS2",
        "ADDR:980 Gallo Rd",
        "CITY:HARRINGTON",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:05:53:01",
        "X:ANDREWVILLE RD/Dead End");

    doTest("T44",
        "Sta: 78AST Loc:: 2667 Seashore Hwy Loc: City: :19950 ---: Traffic/TransportationAcdntBLS Inc#: 2012-017476 DISP: 18:13:25 Cross St: ADAMSVILLE RD/WOODENHAWK RD",
        "ID:2012-017476",
        "SRC:78AST",
        "ADDR:2667 Seashore Hwy",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntBLS",
        "TIME:18:13:25",
        "X:ADAMSVILLE RD/WOODENHAWK RD");

    doTest("T45",
        "Sta: 78AST Loc:: 12154 Deer Forest Rd Loc: City: :19933 ---: Hemorrhage/Lacerations-BLS Inc#: 2012-016445 Lat: 38749267 Long: 75540050 DISP: 14:43:34 Cross St: JENNA LN/OAK RD",
        "ID:2012-016445",
        "SRC:78AST",
        "ADDR:12154 Deer Forest Rd",
        "CITY:BRIDGEVILLE",
        "CALL:Hemorrhage/Lacerations-BLS",
        "GPS:38.749267 75.540050",
        "TIME:14:43:34",
        "X:JENNA LN/OAK RD");

    doTest("T46",
        "Sta: 78C Loc:: 13544 Owens Rd Loc: City: :19950 ---: Field Fire Inc#: 2012-016461 DISP: 16:02:32 Cross St: WOLF RD/LOYDS LN",
        "ID:2012-016461",
        "SRC:78C",
        "ADDR:13544 Owens Rd",
        "CITY:GREENWOOD",
        "CALL:Field Fire",
        "TIME:16:02:32",
        "X:WOLF RD/LOYDS LN");

    doTest("T47",
        "Sta: 78AST Loc:: Hunters Cove Rd & Beach HLoc: City: :19950 ---: Traffic/TransportationAcdntALS Inc#: 2012-016476 DISP: 19:00:49 Cross St:",
        "ID:2012-016476",
        "SRC:78AST",
        "ADDR:Hunters Cove Rd & Beach H",
        "CITY:GREENWOOD",
        "CALL:Traffic/TransportationAcdntALS",
        "TIME:19:00:49");

    doTest("T48",
        "Sta: 78AST Loc:: 104 N Church St Loc: unit 4 City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-016742 DISP: 20:00:54 Cross St: W MINOR ST/BROAD ST",
        "ID:2012-016742",
        "SRC:78AST",
        "ADDR:104 N Church St",
        "PLACE:unit 4",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:20:00:54",
        "X:W MINOR ST/BROAD ST");

    doTest("T49",
        "Sta: 78AS3 Loc:: 8182 Stone Ln Loc: City: :19950 ---: Falls-BLS Inc#: 2012-016867 DISP: 23:58:58 Cross St: MILE STRETCH RD/Dead End",
        "ID:2012-016867",
        "SRC:78AS3",
        "ADDR:8182 Stone Ln",
        "CITY:GREENWOOD",
        "CALL:Falls-BLS",
        "TIME:23:58:58",
        "X:MILE STRETCH RD/Dead End");

    doTest("T50",
        "Sta: 78AST Loc:: 103 Sussex Ave Loc: City: :19933 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-016933 Lat: 38738785 Long: 75598120 DISP: 17:44:55 Cross St: S MAIN ST/LAWS ST",
        "ID:2012-016933",
        "SRC:78AST",
        "ADDR:103 Sussex Ave",
        "CITY:BRIDGEVILLE",
        "CALL:Sick Person(Specific Diag)-BLS",
        "GPS:38.738785 75.598120",
        "TIME:17:44:55",
        "X:S MAIN ST/LAWS ST");

    doTest("T51",
        "Sta: 78AST Loc:: 416 Market St Loc: Jeffs Tap Room City: :19933 ---: Burns(Scalds)/Explosion-BLS Inc#: 2012-016951 Lat: 38742585 Long: 75604883 DISP: 21:07:15 Cross St: Mill St/N Cannon St",
        "ID:2012-016951",
        "SRC:78AST",
        "ADDR:416 Market St",
        "PLACE:Jeffs Tap Room",
        "CITY:BRIDGEVILLE",
        "CALL:Burns(Scalds)/Explosion-BLS",
        "GPS:38.742585 75.604883",
        "TIME:21:07:15",
        "X:Mill St/N Cannon St");

    doTest("T52",
        "Sta: 78AST Loc:: Rock Rd & Sussex Hwy Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017031 DISP: 18:51:25 Cross St:",
        "ID:2012-017031",
        "SRC:78AST",
        "ADDR:Rock Rd & Sussex Hwy",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:18:51:25");

    doTest("T53",
        "Sta: 78AST Loc:: 2381 Andrewville Rd Loc: City: :19950 ---: Breathing ---s-ALS Inc#: 2012-017041 DISP: 22:26:18 Cross St: PROSPECT CHURCH RD/Dead End",
        "ID:2012-017041",
        "SRC:78AST",
        "ADDR:2381 Andrewville Rd",
        "CITY:GREENWOOD",
        "CALL:Breathing ---s-ALS",
        "TIME:22:26:18",
        "X:PROSPECT CHURCH RD/Dead End");

    doTest("T54",
        "Sta: 78C Loc:: 12018 Adamsville Rd Loc: City: :19950 ---: House Fire Inc#: 2012-017043 DISP: 23:16:29 Cross St: SQUIRREL LN/Dead End",
        "ID:2012-017043",
        "SRC:78C",
        "ADDR:12018 Adamsville Rd",
        "CITY:GREENWOOD",
        "CALL:House Fire",
        "TIME:23:16:29",
        "X:SQUIRREL LN/Dead End");

    doTest("T55",
        "Sta: 78AST Loc:: 14577 Sussex Hwy Loc: City: :19950 ---: Breathing ---s-ALS Inc#: 2012-017493 DISP: 23:35:28 Cross St: CONNECTING ROAD/CAMPBELL LN",
        "ID:2012-017493",
        "SRC:78AST",
        "ADDR:14577 Sussex Hwy",
        "CITY:GREENWOOD",
        "CALL:Breathing ---s-ALS",
        "TIME:23:35:28",
        "X:CONNECTING ROAD/CAMPBELL LN");

    doTest("T56",
        "Sta: 78AST Loc:: 14458 Owens Rd Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017570 DISP: 21:02:53 Cross St: CLARDON FARM LN/TUCKERS RD",
        "ID:2012-017570",
        "SRC:78AST",
        "ADDR:14458 Owens Rd",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:21:02:53",
        "X:CLARDON FARM LN/TUCKERS RD");

    doTest("T57",
        "Sta: 78AST Loc:: 12551 Beach Hwy Loc: City: :19950 ---: Choking-BLS Inc#: 2012-017676 DISP: 21:55:33 Cross St: JUDY RD/BLACKSMITH SHOP RD",
        "ID:2012-017676",
        "SRC:78AST",
        "ADDR:12551 Beach Hwy",
        "CITY:GREENWOOD",
        "CALL:Choking-BLS",
        "TIME:21:55:33",
        "X:JUDY RD/BLACKSMITH SHOP RD");

    doTest("T58",
        "Sta: 78AS3 Loc:: 12456 Woodbridge Rd Loc: City: :19950 ---: Sick Person(Specific Diag)-BLS Inc#: 2012-017681 DISP: 23:09:59 Cross St: MC DOWELL RD/DEER MEADOWS RD",
        "ID:2012-017681",
        "SRC:78AS3",
        "ADDR:12456 Woodbridge Rd",
        "CITY:GREENWOOD",
        "CALL:Sick Person(Specific Diag)-BLS",
        "TIME:23:09:59",
        "X:MC DOWELL RD/DEER MEADOWS RD");

    doTest("T59",
        "Sta: 78AS3 Loc:: 0 E Market St Loc: Yoder's Market City: :19950 ---: Abdominal Pain-BLS Inc#: 2012-017726 DISP: 14:02:39 Cross St: Dead End/RAILROAD AVE",
        "ID:2012-017726",
        "SRC:78AS3",
        "ADDR:E Market St",
        "MADDR:E Market St & Dead End",
        "PLACE:Yoder's Market",
        "CITY:GREENWOOD",
        "CALL:Abdominal Pain-BLS",
        "TIME:14:02:39",
        "X:Dead End/RAILROAD AVE");

    doTest("T60",
        "Sta: 78AST Loc:: 1735 Woodyard Rd Loc: assist r47 City: :19952 ---: Abdominal Pain-BLS Inc#: 2012-017732 DISP: 15:54:19 Cross St: COON DEN RD/STAYTONVILLE RD",
        "ID:2012-017732",
        "SRC:78AST",
        "ADDR:1735 Woodyard Rd",
        "PLACE:assist r47",
        "CITY:HARRINGTON",
        "CALL:Abdominal Pain-BLS",
        "TIME:15:54:19",
        "X:COON DEN RD/STAYTONVILLE RD");

    doTest("T61",
        "Sta: 78AST Loc:: 13978 Mile Stretch Rd Loc: City: :19950 ---: Convulsions/Seizures-ALS Inc#: 2012-017843 DISP: 19:52:37 Cross St: CHAMPION LN/JAMESWAY LN",
        "ID:2012-017843",
        "SRC:78AST",
        "ADDR:13978 Mile Stretch Rd",
        "CITY:GREENWOOD",
        "CALL:Convulsions/Seizures-ALS",
        "TIME:19:52:37",
        "X:CHAMPION LN/JAMESWAY LN");

    doTest("T62",
        "Sta: 78AST Loc:: 508 N Cannon St Loc: City: :19933 ---: Assault/Sexual Assault-BLS Inc#: 2012-017845 Lat: 38746952 Long: 75603992 DISP: 20:54:38 Cross St: OAK ST/SECOND ST",
        "ID:2012-017845",
        "SRC:78AST",
        "ADDR:508 N Cannon St",
        "CITY:BRIDGEVILLE",
        "CALL:Assault/Sexual Assault-BLS",
        "GPS:38.746952 75.603992",
        "TIME:20:54:38",
        "X:OAK ST/SECOND ST");

    doTest("T63",
        "Sta: Inc#: 2012-018334 78AS3 Loc:: 499 Governors Ave Loc: Woodbridge Elementary SchCity: :19950 ---: Breathing ---s-ALS DISP: 20:07:09 Cross St: Sussex Hwy/Queen Ave",
        "ID:2012-018334",
        "SRC:78AS3",
        "ADDR:499 Governors Ave",
        "PLACE:Woodbridge Elementary Sch",
        "CITY:GREENWOOD",
        "CALL:Breathing ---s-ALS",
        "TIME:20:07:09",
        "X:Sussex Hwy/Queen Ave");

    doTest("T64",
        "Sta: Inc#: 2012-018512 78AS2 Loc:: 12036 Sussex Hwy Loc: Greenwood Inn/ RM11 City: :19950 ---: Headache-BLS DISP: 21:09:24 Cross St: Greenwood Rd/Nanticoke Business Park Dr",
        "ID:2012-018512",
        "SRC:78AS2",
        "ADDR:12036 Sussex Hwy",
        "PLACE:Greenwood Inn/ RM11",
        "CITY:GREENWOOD",
        "CALL:Headache-BLS",
        "TIME:21:09:24",
        "X:Greenwood Rd/Nanticoke Business Park Dr");

  }

  public static void main(String[] args) {
    new DESussexCountyBParserTest().generateTests("T1");
  }
}
