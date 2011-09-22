package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VAOrangeCountyParserTest extends BaseParserTest {
  
  public VAOrangeCountyParserTest() {
    setParser(new VAOrangeCountyParser(), "ORANGE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[7/13/2011 08:26] orange911@oorange.org: [Orange911]  [LOCATION]: GERMANNA HWY  [NATURE]: AA- Auto Accident  [INCIDENT#]: 2011-00003013 00:41 Locust Grove BOX 2901 Map Page 20",
        "ADDR:GERMANNA HWY",
        "CALL:AA- Auto Accident",
        "ID:2011-00003013",
        "CITY:Locust Grove",
        "BOX:2901",
        "MAP:Page 20");

    doTest("T2",
        "[7/18/2011 08:42] orange911@oorange.org: [Orange911]  [LOCATION]: 11111 PLANK RD  [NATURE]: AA- Auto Accident  [INCIDENT#]: 2011-00003105 08:39",
        "ADDR:11111 PLANK RD",
        "CALL:AA- Auto Accident",
        "ID:2011-00003105");

    doTest("T3",
        "[7/20/2011 15:46] orange911@oorange.org: [Orange911]  [LOCATION]: 35059 GERMANNA HEIGHTS DR  [NATURE]: Medical Alarm  [INCIDENT#]: 2011-00003133 15:44 A AND K BLVD / GERMANNA HWY Locust Grove BOX 2901",
        "ADDR:35059 GERMANNA HEIGHTS DR",
        "CALL:Medical Alarm",
        "ID:2011-00003133",
        "X:A AND K BLVD / GERMANNA HWY",
        "CITY:Locust Grove",
        "BOX:2901");

    doTest("T4",
        "[7/21/2011 22:40] orange911@oorange.org: [Orange911]  [LOCATION]: 602 YORKTOWN BLVD  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003155 22:36 CONSTITUTION BLVD / HOLLYFIELD PARK RD Locust Grove BOX 290",
        "ADDR:602 YORKTOWN BLVD",
        "CALL:Unconscious",
        "ID:2011-00003155",
        "X:CONSTITUTION BLVD / HOLLYFIELD PARK RD",
        "CITY:Locust Grove",
        "BOX:290");

    doTest("T5",
        "[7/22/2011 04:30] orange911@oorange.org: [Orange911]  [LOCATION]: 504 CORNWALLIS AVE  [NATURE]: Fire Alarm RES  [INCIDENT#]: 2011-00003158 04:27 WOODLAWN TRL / WASHINGTON ST Locust Grove BOX 2900 Map",
        "ADDR:504 CORNWALLIS AVE",
        "CALL:Fire Alarm RES",
        "ID:2011-00003158",
        "X:WOODLAWN TRL / WASHINGTON ST",
        "CITY:Locust Grove",
        "BOX:2900");

    doTest("T6",
        "[7/22/2011 05:14] orange911@oorange.org: [Orange911]  [LOCATION]: 116 REPUBLIC AVE  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003159 05:11 PARLIAMENT ST / FREEDOM RD Locust Grove BOX 2900 Map Page 30",
        "ADDR:116 REPUBLIC AVE",
        "CALL:Unconscious",
        "ID:2011-00003159",
        "X:PARLIAMENT ST / FREEDOM RD",
        "CITY:Locust Grove",
        "BOX:2900",
        "MAP:Page 30");

    doTest("T7",
        "[7/22/2011 13:35] orange911@oorange.org: [Orange911]  [LOCATION]: 415 HARRISON CIR  [NATURE]: Public Service   [INCIDENT#]: 2011-00003167 13:33 MANASSAS PT / RAMSAY RD Locust Grove BOX 2900 Map Page 3",
        "ADDR:415 HARRISON CIR",
        "CALL:Public Service",
        "ID:2011-00003167",
        "X:MANASSAS PT / RAMSAY RD",
        "CITY:Locust Grove",
        "BOX:2900",
        "MAP:Page 3");

    doTest("T8",
        "[7/22/2011 18:17] orange911@oorange.org: [Orange911]  [LOCATION]: SCFR 7  [NATURE]: Station Fill  [INCIDENT#]: 2011-00003170 18:15 Spotsylvania County",
        "ADDR:SCFR 7",
        "CALL:Station Fill",
        "ID:2011-00003170",
        "CITY:Spotsylvania County");

    doTest("T9",
        "[7/22/2011 18:26] orange911@oorange.org: [Orange911]  [LOCATION]: 25505 ELYS FORD ROAD  [NATURE]: Smell of Smoke RES  [INCIDENT#]: 2011-00003171 18:24 Spotsylvania County",
        "ADDR:25505 ELYS FORD ROAD",
        "CALL:Smell of Smoke RES",
        "ID:2011-00003171",
        "CITY:Spotsylvania County");

    doTest("T10",
        "[7/22/2011 22:51] orange911@oorange.org: [Orange911]  [LOCATION]: 144 MADISON CIR  [NATURE]: Public Service   [INCIDENT#]: 2011-00003178 22:48 SUSSEX RD / LAKEVIEW PKWY Locust Grove BOX 2900 Map Page",
        "ADDR:144 MADISON CIR",
        "CALL:Public Service",
        "ID:2011-00003178",
        "X:SUSSEX RD / LAKEVIEW PKWY",
        "CITY:Locust Grove",
        "BOX:2900",
        "MAP:Page");

    doTest("T11",
        "[7/23/2011 08:53] orange911@oorange.org: [Orange911]  [LOCATION]: CHESTERFIELD RD  [NATURE]: Unconscious  [INCIDENT#]: 2011-00003183 08:49 Locust Grove BOX 2901 Map Page 5",
        "ADDR:CHESTERFIELD RD",
        "CALL:Unconscious",
        "ID:2011-00003183",
        "CITY:Locust Grove",
        "BOX:2901",
        "MAP:Page 5");

    doTest("T12",
        "[7/23/2011 20:36] orange911@oorange.org: [Orange911]  [LOCATION]: 33011 INDIANTOWN RD  [NATURE]: AA- W/ ENT  [INCIDENT#]: 2011-00003197 20:14 UNKNOWN / LILLY PAD LN Locust Grove BOX 2907 Map Page 4",
        "ADDR:33011 INDIANTOWN RD",
        "CALL:AA- W/ ENT",
        "ID:2011-00003197",
        "X:UNKNOWN / LILLY PAD LN",
        "CITY:Locust Grove",
        "BOX:2907",
        "MAP:Page 4");

    doTest("T13",
        "[7/23/2011 20:37] orange911@oorange.org: [Orange911]  [LOCATION]: 33011 INDIANTOWN RD  [NATURE]: AA- W/ ENT  [INCIDENT#]: 2011-00003197 20:14 UNKNOWN / LILLY PAD LN Locust Grove BOX 2907 Map Page 4",
        "ADDR:33011 INDIANTOWN RD",
        "CALL:AA- W/ ENT",
        "ID:2011-00003197",
        "X:UNKNOWN / LILLY PAD LN",
        "CITY:Locust Grove",
        "BOX:2907",
        "MAP:Page 4");

    doTest("T14",
        "[7/24/2011 09:39] orange911@oorange.org: [Orange911]  [LOCATION]: 112 JEFFERSON AVE  [NATURE]: Fire Alarm RES  [INCIDENT#]: 2011-00003204 09:36 MONTICELLO CIR / MONTICELLO CIR Locust Grove BOX 2900 Ma",
        "ADDR:112 JEFFERSON AVE",
        "CALL:Fire Alarm RES",
        "ID:2011-00003204",
        "X:MONTICELLO CIR / MONTICELLO CIR",
        "CITY:Locust Grove",
        "BOX:2900");

    doTest("T15",
        "[7/24/2011 13:34] orange911@oorange.org: [Orange911]  [LOCATION]: 838 EASTOVER PKWY  [NATURE]: Illness  [INCIDENT#]: 2011-00003208 13:14 LARKSPUR LN / WILDERNESS LN Locust Grove BOX 2900 Map Page 316",
        "ADDR:838 EASTOVER PKWY",
        "CALL:Illness",
        "ID:2011-00003208",
        "X:LARKSPUR LN / WILDERNESS LN",
        "CITY:Locust Grove",
        "BOX:2900",
        "MAP:Page 316");

    doTest("T16",
        "[7/25/2011 16:55] orange911@oorange.org: [Orange911]  [LOCATION]: 208 PINE VALLEY RD  [NATURE]: Structure Fire RES  [INCIDENT#]: 2011-00003226 16:52 DEAD END / APPLEVIEW CT Locust Grove BOX 2900 Map P",
        "ADDR:208 PINE VALLEY RD",
        "CALL:Structure Fire RES",
        "ID:2011-00003226",
        "X:DEAD END / APPLEVIEW CT",
        "CITY:Locust Grove",
        "BOX:2900",
        "MAP:P");

    doTest("T17",
        "[7/29/2011 14:17] orange911@oorange.org: [Orange911]  [LOCATION]: 2130 GERMANNA HWY  [NATURE]: Fire Alarm NHSA  [INCIDENT#]: 2011-00003273 14:15 SPOTSWOOD DR / HAMPTON LN Locust Grove BOX 2903 Map Pag",
        "ADDR:2130 GERMANNA HWY",
        "CALL:Fire Alarm NHSA",
        "ID:2011-00003273",
        "X:SPOTSWOOD DR / HAMPTON LN",
        "CITY:Locust Grove",
        "BOX:2903",
        "MAP:Pag");

    doTest("T18",
        "[7/29/2011 14:29] orange911@oorange.org: [Orange911]  [LOCATION]: 2130 GERMANNA HWY  [NATURE]: Fire Alarm NHSA  [INCIDENT#]: 2011-00003274 14:27 SPOTSWOOD DR / HAMPTON LN Locust Grove BOX 2903 Map Pag",
        "ADDR:2130 GERMANNA HWY",
        "CALL:Fire Alarm NHSA",
        "ID:2011-00003274",
        "X:SPOTSWOOD DR / HAMPTON LN",
        "CITY:Locust Grove",
        "BOX:2903",
        "MAP:Pag");

    doTest("T19",
        "[7/23/2011 15:36] orange911@oorange.org: [Orange911]  Orange County is under severe thunderstorm warning until 1545.  Storm is capable of producing damaging winds in excess of 60 mph.",
        "CALL:GENERAL ALERT",
        "PLACE:Orange County is under severe thunderstorm warning until 1545.  Storm is capable of producing damaging winds in excess of 60 mph.");
  }
  
  public static void main(String[] args) {
    new VAOrangeCountyParserTest().generateTests("T1");
  }
}