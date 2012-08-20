package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class DEKentCountyBParserTest extends BaseParserTest {
  
  public DEKentCountyBParserTest() {
    setParser(new DEKentCountyBParser(), "KENT COUNTY", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Chief ALT) [40 EMS] - 26A10 - Sick Person - Unwell/Ill -- 2536 Skeeter Neck Rd, Frederica -- Xst's: Bowers Beach Rd / E Front St -- Caller: High Vue Logging Inc",
        "SRC:40 EMS",
        "CODE:26A10",
        "CALL:Sick Person - Unwell/Ill",
        "ADDR:2536 Skeeter Neck Rd",
        "CITY:Frederica",
        "X:Bowers Beach Rd / E Front St",
        "NAME:High Vue Logging Inc");

    doTest("T2",
        "(Chief ALT) [KCPS] - [911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.",
        "SRC:KCPS",
        "CALL:GENERAL ALERT",
        "PLACE:[911, Kent] NWS UPGRADED LAST TO A WARNING, WILL BE IN WESTERN KENT COUNTY AROUND 22:30 HRS.");

    doTest("T3",
        "(Chief ALT) [40 EMS] - 23C1V - Overdose/Poisoning -- 181 Holly Dr, Frederica -- High Point Mhp -- Xst's: Garden Pl / Maple Dr -- Caller: Marrillo Paul",
        "SRC:40 EMS",
        "CALL:23C1V - Overdose/Poisoning",
        "ADDR:181 Holly Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Garden Pl / Maple Dr",
        "NAME:Marrillo Paul");

    doTest("T4",
        "(Chief ALT) [55 EMS 1] - 2D2 - Allergic Reaction -- 149 Juanita Dr, Magnolia -- London Village -- Xst's: Jeffrey Dr / Millchop Ln -- Caller: Price Laura",
        "CODE:2D2",
        "SRC:55 EMS 1",
        "CALL:Allergic Reaction",
        "ADDR:149 Juanita Dr",
        "CITY:Magnolia",
        "PLACE:London Village",
        "X:Jeffrey Dr / Millchop Ln",
        "NAME:Price Laura");

    doTest("T5",
        "(Chief ALT) [40 EMS] - 29B4 - MVC Unknown -- Mulberrie Point Rd, Frederica",
        "SRC:40 EMS",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:Mulberrie Point Rd",
        "CITY:Frederica");

    doTest("T6",
        "(Chief ALT) [40 EMS] - 10D2 - Chest Pains -- 196 N  Bayshore Dr, Frederica -- Bowers Beach -- Xst's: N Flack Ave / Main St -- Caller: Margaret",
        "SRC:40 EMS",
        "CODE:10D2",
        "CALL:Chest Pains",
        "ADDR:196 N  Bayshore Dr",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:N Flack Ave / Main St",
        "NAME:Margaret");

    doTest("T7",
        "(Chief ALT) [40 EMS] - 26C2 - Sick Person -- 201 Hubbard Ave, Frederica -- Bowers Beach -- Xst's: Dead End / Canal St -- Caller: Ingle Heather",
        "SRC:40 EMS",
        "CODE:26C2",
        "CALL:Sick Person",
        "ADDR:201 Hubbard Ave",
        "CITY:Frederica",
        "PLACE:Bowers Beach",
        "X:Dead End / Canal St",
        "NAME:Ingle Heather");

    doTest("T8",
        "(Chief ALT) [40 EMS] - 10C4 - Chest Pains -- 302 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Second St, Sycamore Dr / Lorna Ln -- Caller: Thom Ronald",
        "SRC:40 EMS",
        "CODE:10C4",
        "CALL:Chest Pains",
        "ADDR:302 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Second St, Sycamore Dr / Lorna Ln",
        "NAME:Thom Ronald");

    doTest("T9",
        "(Chief ALT) [40 EMS] - 6C1 - Breathing Problems -- 294 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Kiwi Ct / Kylie Ln -- Caller: Hurd Shirley",
        "SRC:40 EMS",
        "CODE:6C1",
        "CALL:Breathing Problems",
        "ADDR:294 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Kiwi Ct / Kylie Ln",
        "NAME:Hurd Shirley");

    doTest("T10",
        "(Chief ALT) [40 Fire] - 17A2 - Falls - Non-Recent -- 254 Lake Shore Dr, Frederica -- High Point Mhp -- Xst's: Tyson Ln / Ibis Ct -- Caller: Spink Kimberley",
        "SRC:40 Fire",
        "CODE:17A2",
        "CALL:Falls - Non-Recent",
        "ADDR:254 Lake Shore Dr",
        "CITY:Frederica",
        "PLACE:High Point Mhp",
        "X:Tyson Ln / Ibis Ct",
        "NAME:Spink Kimberley");

    doTest("T11",
        "(Chief ALT) [40 Fire] - Outside Fire-Unknown 2124 BOWERS BEACH RD, Frederica -- Xst's: Grm Dr / Whitwell Delight Rd",
        "SRC:40 Fire",
        "CALL:Outside Fire-Unknown",
        "ADDR:2124 BOWERS BEACH RD",
        "CITY:Frederica",
        "X:Grm Dr / Whitwell Delight Rd");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 110 Firehouse Ln Marydel - Cross Sts: Strauss Av\n",
        "SRC:46 Fire",
        "CALL:Stand-By,Cover-up",
        "ADDR:110 Firehouse Ln",
        "CITY:Marydel",
        "X:Strauss Av");

    doTest("T2",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- Wolf Creek Blvd/ Glenda Rd Dover - Cross Sts: None\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:Wolf Creek Blvd & Glenda Rd", // Google calls this Wolf Creek
        "CITY:Dover");

    doTest("T3",
        "[Chief ALT] [46 Fire] -- Stand-By,Cover-up -- 2898 Arthursville Rd Hartly - Cross Sts: Main St\n" +
        " Everetts Corner R Cross St2: Main St\n" +
        " Everetts\n",

        "SRC:46 Fire",
        "CALL:Stand-By,Cover-up",
        "ADDR:2898 Arthursville Rd",
        "CITY:Hartly",
        "X:Main St\n Everetts Corner R Cross St2: Main St\n Everetts");

    doTest("T4",
        "[Chief ALT] [46 Fire] -- Structure-Commercial -- 1481 N Dupont Hwy Dover - Cross Sts: W Rustic L - Caller:HILL, ANTONETTE\n",
        "SRC:46 Fire",
        "CALL:Structure-Commercial",
        "ADDR:1481 N Dupont Hwy",
        "CITY:Dover",
        "X:W Rustic L",
        "NAME:HILL, ANTONETTE");

    doTest("T5",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 40 Saulsbury Rd Dover - Cross Sts: Carver R\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:40 Saulsbury Rd",
        "CITY:Dover",
        "X:Carver R");

    doTest("T6",
        "[Chief ALT] [46 Fire] -- Outside Fire-Field,Grass,Woods -- 1365 N Dupont Hwy Dover - Cross Sts: Dover Mal - Caller:dfd\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Field,Grass,Woods",
        "ADDR:1365 N Dupont Hwy",
        "CITY:Dover",
        "X:Dover Mal",
        "NAME:dfd");

    doTest("T7",
        "[Chief ALT] [46 Fire] -- 29D2L MVC Motorcycle/Bicycle -- 1131 N Dupont Hwy Dover - Cross Sts: Unknow - Caller:CODY\n",
        "SRC:46 Fire",
        "CALL:29D2L MVC Motorcycle/Bicycle",
        "ADDR:1131 N Dupont Hwy",
        "CITY:Dover",
        "X:Unknow",
        "NAME:CODY");

    doTest("T8",
        "[Chief ALT] [46 Fire] -- 29B4 MVC Unknown -- College Rd/ Mckee Rd Dover - Cross Sts: None - Caller:JAKE\n",
        "SRC:46 Fire",
        "CODE:29B4",
        "CALL:MVC Unknown",
        "ADDR:College Rd & Mckee Rd",
        "CITY:Dover",
        "NAME:JAKE");

    doTest("T9",
        "[Chief ALT] [46 Fire] -- Electrical Hazard-Arcing -- 1001 Forrest Ave Dover - Cross Sts: Saulsbury Rd\n" +
        " Forest S Cross St2: Saulsbury\n",

        "SRC:46 Fire",
        "CALL:Electrical Hazard-Arcing",
        "ADDR:1001 Forrest Ave",
        "CITY:Dover",
        "X:Saulsbury Rd\n Forest S Cross St2: Saulsbury");

    doTest("T10",
        "[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- 411 S Queen St Dover - Cross Sts: Dupont S\n",
        "SRC:46 Fire",
        "CALL:Fuel Spill (Small)",
        "ADDR:411 S Queen St",
        "CITY:Dover",
        "X:Dupont S");

    doTest("T11",
        "[Chief ALT] [46 Fire] -- Alarms CO-Residential (single) -- 39 Kentwood Dr Dover - Cross Sts: Bismark D\n",
        "SRC:46 Fire",
        "CALL:Alarms CO-Residential (single)",
        "ADDR:39 Kentwood Dr",
        "CITY:Dover",
        "X:Bismark D");

    doTest("T12",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 1368 Rose Valley School Rd Dover - Cross Sts: Unknow\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:1368 Rose Valley School Rd",
        "CITY:Dover",
        "X:Unknow");

    doTest("T13",
        "[Chief ALT] [46 Fire] -- Search -- 1200 N Dupont Hwy Dover - Cross Sts: College R - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Search",
        "ADDR:1200 N Dupont Hwy",
        "CITY:Dover",
        "X:College R",
        "NAME:DFD");

    doTest("T14",
        "[Chief ALT] [46 Fire] -- 6D1 Breathing Problems -- 14 Fair Wind Pl Dover - Cross Sts: Bay Tree R - Caller:LUKE\n",
        "SRC:46 Fire",
        "CODE:6D1",
        "CALL:Breathing Problems",
        "ADDR:14 Fair Wind Pl",
        "CITY:Dover",
        "X:Bay Tree R",
        "NAME:LUKE");

    doTest("T15",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 100 Haman Dr Dover - Cross Sts: Kesselring Av - Caller:TORRES, DIANNA\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:100 Haman Dr",
        "CITY:Dover",
        "X:Kesselring Av",
        "NAME:TORRES, DIANNA");

    doTest("T16",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 217 Rose Valley School Rd Dover - Cross Sts: Hazlettville R - Caller:KWNTCOM\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:217 Rose Valley School Rd",
        "CITY:Dover",
        "X:Hazlettville R",
        "NAME:KWNTCOM");

    doTest("T17",
        "[Chief ALT] [46 Fire] -- Vehicle Fire -- 439 Phoenix Dr Dover - Cross Sts: Santa Fe D - Caller:RILEY, EDEDE, E\n",
        "SRC:46 Fire",
        "CALL:Vehicle Fire",
        "ADDR:439 Phoenix Dr",
        "CITY:Dover",
        "X:Santa Fe D",
        "NAME:RILEY, EDEDE, E");

    doTest("T18",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- 75 Quail Hollow Dr Dover - Cross Sts: Village D - Caller:AUSTIN, THERESA\n",
        "SRC:46 Fire",
        "CALL:Outside Fire-Small",
        "ADDR:75 Quail Hollow Dr",
        "CITY:Dover",
        "X:Village D",
        "NAME:AUSTIN, THERESA");

    doTest("T19",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 868 Woodcrest Dr Dover - Cross Sts: Woodcrest Tur - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:868 Woodcrest Dr",
        "CITY:Dover",
        "X:Woodcrest Tur",
        "NAME:DFD");

    doTest("T20",
        "[Chief ALT] [46 Fire] -- Outside Fire-Small -- State Hwy 1  - Cross Sts: None - Caller:BAER, BRETT\n",
        "SRC:46 Fire",
        "CALL:GENERAL ALERT",
        "PLACE:Outside Fire-Small -- State Hwy 1  - Xst's: None - Caller:BAER, BRETT");

    doTest("T21",
        "[Chief ALT] [46 Fire] -- Structure-Residential Single -- 880 Buttner Pl Dover - Cross Sts: Dead En\n",
        "SRC:46 Fire",
        "CALL:Structure-Residential Single",
        "ADDR:880 Buttner Pl",
        "CITY:Dover",
        "X:Dead En");

    doTest("T22",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:800 Otis Dr",
        "CITY:Dover",
        "X:Fowler C",
        "NAME:DFD");

    doTest("T23",
        "[Chief ALT] [46 Fire] -- Fuel Spill (Small) -- KENT CO COURT HOUSE -- 414 Federal St Dover - Cross Sts: William Penn S - Caller:SHANER, DISPATCHER\n",
        "SRC:46 Fire",
        "CALL:Fuel Spill (Small) - KENT CO COURT HOUSE",
        "ADDR:414 Federal St",
        "CITY:Dover",
        "X:William Penn S",
        "NAME:SHANER, DISPATCHER");

    doTest("T24",
        "[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- LUTHER VILLAGE 1, LUTHER VILLAGE 2 -- 101 Babb Dr Dover - Cross Sts: Nob Hill R\n",
        "SRC:46 Fire",
        "CALL:Alarms-High Life Hazard - LUTHER VILLAGE 1, LUTHER VILLAGE 2",
        "ADDR:101 Babb Dr",
        "CITY:Dover",
        "X:Nob Hill R");

    doTest("T25",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- COMPASSIONATE PAIN MANAGEMENT -- 740 S New St Dover - Cross Sts: South S - Caller:44, DES\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial - COMPASSIONATE PAIN MANAGEMENT",
        "ADDR:740 S New St",
        "CITY:Dover",
        "X:South S",
        "NAME:44, DES");

    doTest("T26",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (multiple) -- APT-PINE GROVE APTS -- 255 Webbs Ln Dover - Cross Sts: John Clark Rd\n" +
        " Mayberry L Cross St2: John Clark R - Caller:DFD\n",

        "SRC:46 Fire",
        "CALL:Alarms-Residential (multiple) - APT-PINE GROVE APTS",
        "ADDR:255 Webbs Ln",
        "CITY:Dover",
        "X:John Clark Rd\n Mayberry L Cross St2: John Clark R",
        "NAME:DFD");

    doTest("T27",
        "[Chief ALT] [46 Fire] -- Alarms-High Life Hazard -- SILVER LAKE CENTER -- 1080 Silver Lake Blvd Dover - Cross Sts: Unknow - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-High Life Hazard - SILVER LAKE CENTER",
        "ADDR:1080 Silver Lake Blvd",
        "CITY:Dover",
        "X:Unknow",
        "NAME:DFD");

    doTest("T28",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 22 The Green Dover - Cross Sts: Bank L - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:22 The Green",
        "CITY:Dover",
        "X:Bank L",
        "NAME:DFD");

    doTest("T29",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- CHRIST CHURCH -- 501 S State St Dover - Cross Sts: W Water St\n" +
        " Water S Cross St2: W Water S - Caller:DFD\n",

        "SRC:46 Fire",
        "CALL:Alarms-Commercial - CHRIST CHURCH",
        "ADDR:501 S State St",
        "CITY:Dover",
        "X:W Water St\n Water S Cross St2: W Water S",
        "NAME:DFD");

    doTest("T30",
        "[Chief ALT] [46 Fire] -- Alarms-Commercial -- 800 Otis Dr Dover - Cross Sts: Fowler C - Caller:DFD\n",
        "SRC:46 Fire",
        "CALL:Alarms-Commercial",
        "ADDR:800 Otis Dr",
        "CITY:Dover",
        "X:Fowler C",
        "NAME:DFD");

    doTest("T31",
        "[Chief ALT] [46 Fire] -- Alarms-Residential (single) -- 281 Sheffield Dr Dover - Cross Sts: Norwich Wa - Caller:ADT\n",
        "SRC:46 Fire",
        "CALL:Alarms-Residential (single)",
        "ADDR:281 Sheffield Dr",
        "CITY:Dover",
        "X:Norwich Wa",
        "NAME:ADT");

    doTest("T32",
        "[Chief ALT] [46 Fire] -- Structure-Mobile Home/Trailer -- 243 Kentwood Dr Dover - Cross Sts: Phoenix D - Caller:SHANON\n",
        "SRC:46 Fire",
        "CALL:Structure-Mobile Home/Trailer",
        "ADDR:243 Kentwood Dr",
        "CITY:Dover",
        "X:Phoenix D",
        "NAME:SHANON");

  }
  
  public static void main(String[] args) {
    new DEKentCountyBParserTest().generateTests("T1");
  }
}
    		