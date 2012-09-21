package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VALunenburgCountyParserTest extends BaseParserTest {
  
  public VALunenburgCountyParserTest() {
    setParser(new VALunenburgCountyParser(), "LUNENBURG COUNTY", "VA");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "VFDS-T ACCIDENT 1133 COURT ST CFS# 2012-005551",
        "SRC:VFDS-T",
        "CALL:ACCIDENT",
        "ADDR:1133 COURT ST",
        "ID:2012-005551");

    doTest("T2",
        "VRS-T ACCIDENT 1133 COURT ST CFS# 2012-005551",
        "SRC:VRS-T",
        "CALL:ACCIDENT",
        "ADDR:1133 COURT ST",
        "ID:2012-005551");

    doTest("T3",
        "VRS-T CHEST PAINS 2209 LINCOLN AVE CFS# 2012-005569",
        "SRC:VRS-T",
        "CALL:CHEST PAINS",
        "ADDR:2209 LINCOLN AVE",
        "ID:2012-005569");

    doTest("T4",
        "VRS-T RESCUE 1404 10TH ST CFS# 2012-005571",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1404 10TH ST",
        "ID:2012-005571");

    doTest("T5",
        "VFDS-T OTHER TRAINING CFS# 2012-005577",
        "SRC:VFDS-T",
        "CALL:OTHER",
        "ADDR:TRAINING",
        "ID:2012-005577");

    doTest("T6",
        "VRS-T ALLERGIC REACT 1849 OLD COURT ST CFS# 2012-005585",
        "SRC:VRS-T",
        "CALL:ALLERGIC REACT",
        "ADDR:1849 OLD COURT ST",
        "ID:2012-005585");

    doTest("T7",
        "VRS-T ASTHMA 215 FOSTER RD CFS# 2012-005606",
        "SRC:VRS-T",
        "CALL:ASTHMA",
        "ADDR:215 FOSTER RD",
        "ID:2012-005606");

    doTest("T8",
        "VRS-T RESCUE 173 TRAILER PK CFS# 2012-005614",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:173 TRAILER PARK RD",
        "ID:2012-005614");

    doTest("T9",
        "VRS-T RESCUE 1609 LUNENBURG AVE CFS# 2012-005626",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1609 LUNENBURG AVE",
        "ID:2012-005626");

    doTest("T10",
        "VRS-T RESCUE 1409 VICTORIA PLACE CFS# 2012-005627",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1409 VICTORIA PLACE",  // Not mapping, mahy be apt complex
        "ID:2012-005627");

    doTest("T11",
        "VRS-T FALLEN 2406 MAIN ST CFS# 2012-005645",
        "SRC:VRS-T",
        "CALL:FALLEN",
        "ADDR:2406 MAIN ST",
        "ID:2012-005645");

    doTest("T12",
        "VRS-T RESCUE CLAY'S ASSISTED LIVING CFS# 2012-005664",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:CLAY'S ASSISTED LIVING",
        "ID:2012-005664");

    doTest("T13",
        "VRS-T MUTUAL AID 1810 TURKEY ISLAND CFS# 2012-005672",
        "SRC:VRS-T",
        "CALL:MUTUAL AID",
        "ADDR:1810 TURKEY ISLAND", // Mutual aid to Nottoway county
        "ID:2012-005672");

    doTest("T14",
        "VRS-T PREGNANCY 1601 5TH ST CFS# 2012-005676",
        "SRC:VRS-T",
        "CALL:PREGNANCY",
        "ADDR:1601 5TH ST",
        "ID:2012-005676");

    doTest("T15",
        "VRS-T ACCIDENT 601 MECKLENBURG AVE CFS# 2012-005687",
        "SRC:VRS-T",
        "CALL:ACCIDENT",
        "ADDR:601 MECKLENBURG AVE",
        "ID:2012-005687");

    doTest("T16",
        "VRS-T RESCUE 1504 2ND ST CFS# 2012-005698",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1504 2ND ST",
        "ID:2012-005698");

    doTest("T17",
        "VRS-T RESCUE 1605 10TH ST CFS# 2012-005719",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1605 10TH ST",
        "ID:2012-005719");

    doTest("T18",
        "VRS-T ACCIDENT 500 MAIN ST CFS# 2012-005732",
        "SRC:VRS-T",
        "CALL:ACCIDENT",
        "ADDR:500 MAIN ST",
        "ID:2012-005732");

    doTest("T19",
        "VRS-T PASSED OUT 110 E 7TH AVE CFS# 2012-005733",
        "SRC:VRS-T",
        "CALL:PASSED OUT",
        "ADDR:110 E 7TH AVE",
        "ID:2012-005733");

    doTest("T20",
        "VRS-T RESCUE 327 K-V RD CFS# 2012-005734",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:327 K-V RD",
        "ID:2012-005734");

    doTest("T21",
        "VRS-T SICK 221 N CIRCLE BVD CFS# 2012-005742",
        "SRC:VRS-T",
        "CALL:SICK",
        "ADDR:221 N CIRCLE BVD",
        "ID:2012-005742");

    doTest("T22",
        "VRS-T FALLEN MARKERS TRIFT CFS# 2012-005753",
        "SRC:VRS-T",
        "CALL:FALLEN",
        "ADDR:MARKERS TRIFT",
        "ID:2012-005753");

    doTest("T23",
        "VRS-T RESCUE 1449 MAYFLOWER RD CFS# 2012-005755",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1449 MAYFLOWER RD",
        "ID:2012-005755");

    doTest("T24",
        "VRS-T RESCUE 138 CENTRAL LANE CFS# 2012-005772",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:138 CENTRAL LANE", // Not mapping
        "ID:2012-005772");

    doTest("T25",
        "VFDS-T BRUSH FIRE 1817 GALLION TOWN RD CFS# 2012-005794",
        "SRC:VFDS-T",
        "CALL:BRUSH FIRE",
        "ADDR:1817 GALLION TOWN RD",
        "ID:2012-005794");

    doTest("T26",
        "VRS-T BRUSH FIRE 1817 GALLION TOWN RD CFS# 2012-005794",
        "SRC:VRS-T",
        "CALL:BRUSH FIRE",
        "ADDR:1817 GALLION TOWN RD",
        "ID:2012-005794");

    doTest("T27",
        "VFDS-T TREE IN ROAD 1900 8TH ST CFS# 2012-005798",
        "SRC:VFDS-T",
        "CALL:TREE IN ROAD",
        "ADDR:1900 8TH ST",
        "ID:2012-005798");

    doTest("T28",
        "VRS-T TREE IN ROAD 1900 8TH ST CFS# 2012-005798",
        "SRC:VRS-T",
        "CALL:TREE IN ROAD",
        "ADDR:1900 8TH ST",
        "ID:2012-005798");

    doTest("T29",
        "VFDS-T FIRE ALARM MIDDLE SCHOOL CFS# 2012-005811",
        "SRC:VFDS-T",
        "CALL:FIRE ALARM",
        "ADDR:MIDDLE SCHOOL",
        "ID:2012-005811");

    doTest("T30",
        "VFDS-T BRUSH FIRE BATTES RD CFS# 2012-005833",
        "SRC:VFDS-T",
        "CALL:BRUSH FIRE",
        "ADDR:BATTES RD",
        "ID:2012-005833");

    doTest("T31",
        "VFDS-T DUMPSTER FIRE 000000 BAILEY RD CFS# 2012-005849",
        "SRC:VFDS-T",
        "CALL:DUMPSTER FIRE",
        "ADDR:000000 BAILEY RD",
        "ID:2012-005849");

    doTest("T32",
        "VRS-T BLEEDING 2585 MARSHALLTOWN RD CFS# 2012-005852",
        "SRC:VRS-T",
        "CALL:BLEEDING",
        "ADDR:2585 MARSHALLTOWN RD",
        "ID:2012-005852");

    doTest("T33",
        "VFDS-T ALARM 583 TOMLINSON RD CFS# 2012-005860",
        "SRC:VFDS-T",
        "CALL:ALARM",
        "ADDR:583 TOMLINSON RD",
        "ID:2012-005860");

    doTest("T34",
        "VFDS-T FIRE DAVIS LOWGROUND RD CFS# 2012-005862",
        "SRC:VFDS-T",
        "CALL:FIRE",
        "ADDR:DAVIS LOWGROUND RD",
        "ID:2012-005862");

    doTest("T35",
        "VRS-T FIRE 000000 COURTHOUSE SQ CFS# 2012-005862",
        "SRC:VRS-T",
        "CALL:FIRE",
        "ADDR:000000 COURTHOUSE SQ",
        "ID:2012-005862");

    doTest("T36",
        "VFDS-T BRUSH FIRE DAVIS LOWGROUND RD CFS# 2012-005869",
        "SRC:VFDS-T",
        "CALL:BRUSH FIRE",
        "ADDR:DAVIS LOWGROUND RD",
        "ID:2012-005869");

    doTest("T37",
        "VFDS-T PUBLIC SERVICE MECKLENBURG AVE CFS# 2012-005902",
        "SRC:VFDS-T",
        "CALL:PUBLIC SERVICE",
        "ADDR:MECKLENBURG AVE",
        "ID:2012-005902");

    doTest("T38",
        "VRS-T SICK 4242 FALLS RD CFS# 2012-005920",
        "SRC:VRS-T",
        "CALL:SICK",
        "ADDR:4242 FALLS RD",
        "ID:2012-005920");

    doTest("T39",
        "VRS-T FALLEN 12995 PLANK CFS# 2012-005921",
        "SRC:VRS-T",
        "CALL:FALLEN",
        "ADDR:12995 PLANK",
        "ID:2012-005921");

    doTest("T40",
        "VRS-T RESCUE 2209 LINCOLN AVE CFS# 2012-005971",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:2209 LINCOLN AVE",
        "ID:2012-005971");

    doTest("T41",
        "VRS-T STAND BY MEHERRIN CFS# 2012-005988",
        "SRC:VRS-T",
        "CALL:STAND BY",
        "ADDR:MEHERRIN",
        "ID:2012-005988");

    doTest("T42",
        "VRS-T RESCUE CFS# 2012-006003",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ID:2012-006003");

    doTest("T43",
        "VFDS-T BRUSH FIRE 4391 POORHOUSE RD CFS# 2012-006022",
        "SRC:VFDS-T",
        "CALL:BRUSH FIRE",
        "ADDR:4391 POORHOUSE RD",
        "ID:2012-006022");

    doTest("T44",
        "VRS-T BRUSH FIRE 4391 POORHOUSE RD CFS# 2012-006022",
        "SRC:VRS-T",
        "CALL:BRUSH FIRE",
        "ADDR:4391 POORHOUSE RD",
        "ID:2012-006022");

    doTest("T45",
        "VRS-T UNRESPONSIVE 2952 REEDY CREEK RD CFS# 2012-006027",
        "SRC:VRS-T",
        "CALL:UNRESPONSIVE",
        "ADDR:2952 REEDY CREEK RD",
        "ID:2012-006027");

    doTest("T46",
        "VRS-T RESCUE 519 MAIN ST 106 CFS# 2012-006034",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:519 MAIN ST 106",
        "ID:2012-006034");

    doTest("T47",
        "VFDS-T ACCIDENT FOWLKES RD CFS# 2012-006066",
        "SRC:VFDS-T",
        "CALL:ACCIDENT",
        "ADDR:FOWLKES RD",
        "ID:2012-006066");

    doTest("T48",
        "VRS-T ACCIDENT FOWLKES RD CFS# 2012-006066",
        "SRC:VRS-T",
        "CALL:ACCIDENT",
        "ADDR:FOWLKES RD",
        "ID:2012-006066");

    doTest("T49",
        "VRS-T DIFF BREATHING 690 FALLS RD CFS# 2012-006085",
        "SRC:VRS-T",
        "CALL:DIFF BREATHING",
        "ADDR:690 FALLS RD",
        "ID:2012-006085");

    doTest("T50",
        "VRS-T RESCUE 2574 NUTBUSH RD CFS# 2012-006094",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:2574 NUTBUSH RD",
        "ID:2012-006094");

    doTest("T51",
        "VRS-T RESCUE 1409 TIDEWATER AVE CFS# 2012-006111",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1409 TIDEWATER AVE",
        "ID:2012-006111");

    doTest("T52",
        "VRS-T RESCUE 634 THOMAS ST CFS# 2012-006125",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:634 THOMAS ST",
        "ID:2012-006125");

    doTest("T53",
        "VFDS-T FIRE ALARM 583 THOMLINSON CFS# 2012-006150",
        "SRC:VFDS-T",
        "CALL:FIRE ALARM",
        "ADDR:583 THOMLINSON",
        "ID:2012-006150");

    doTest("T54",
        "VFDS-T FIRE 3374 POORHOUSE RD CFS# 2012-006152",
        "SRC:VFDS-T",
        "CALL:FIRE",
        "ADDR:3374 POORHOUSE RD",
        "ID:2012-006152");

    doTest("T55",
        "VRS-T RESCUE 476 CLARKS FARM RD CFS# 2012-006206",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:476 CLARKS FARM RD",
        "ID:2012-006206");

    doTest("T56",
        "VRS-T PUBLIC SERVICE NEBLETT FIELD CFS# 2012-006303",
        "SRC:VRS-T",
        "CALL:PUBLIC SERVICE",
        "ADDR:NEBLETT FIELD",
        "ID:2012-006303");

    doTest("T57",
        "VRS-T RESCUE 1413 11TH ST CFS# 2012-006353",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:1413 11TH ST",
        "ID:2012-006353");

    doTest("T58",
        "VRS-T SICK 391 TRAILER PARK RD CFS# 2012-006354",
        "SRC:VRS-T",
        "CALL:SICK",
        "ADDR:391 TRAILER PARK RD",
        "ID:2012-006354");

    doTest("T59",
        "VRS-T RESCUE 221 N CIRCLE BVD CFS# 2012-006355",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:221 N CIRCLE BVD",
        "ID:2012-006355");

    doTest("T60",
        "VRS-T RESCUE VICTORIA PLACE APTS 302 CFS# 2012-006356",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:VICTORIA PLACE",
        "APT:302",
        "ID:2012-006356");

    doTest("T61",
        "VRS-T OTHER NEBLETT FIELD RD CFS# 2012-006357",
        "SRC:VRS-T",
        "CALL:OTHER",
        "ADDR:NEBLETT FIELD RD",
        "ID:2012-006357");

    doTest("T62",
        "VRS-T RESCUE 359 HART RD CFS# 2012-006366",
        "SRC:VRS-T",
        "CALL:RESCUE",
        "ADDR:359 HART RD",
        "ID:2012-006366");

    doTest("T63",
        "VRS-T ARGUEMENT 1115 MECKLENBURG AVE CFS# 2012-006381",
        "SRC:VRS-T",
        "CALL:ARGUEMENT",
        "ADDR:1115 MECKLENBURG AVE",
        "ID:2012-006381");
    
  }
  
  public static void main(String[] args) {
    new VALunenburgCountyParserTest().generateTests("T1");
  }
}