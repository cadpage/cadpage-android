package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CAElDoradoCountyParserTest extends BaseParserTest {
  
  public CAElDoradoCountyParserTest() {
    setParser(new CAElDoradoCountyParser(), "EL DORADO COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page) 15-May-2011/16:10:27: HAZ, ELECTRICAL: Inc# 010021: 5537 MORGAN RANCH LOOP ,GEORGETOWN  GEOCHF GEOENG M61 61; ; X: -120 50.5096  Y: 38 54.859",
        "CALL:HAZ, ELECTRICAL",
        "ID:010021",
        "ADDR:5537 MORGAN RANCH LOOP",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENG M61 61",
        "GPS:X: -120 50.5096  Y: 38 54.859");

    doTest("T2",
        "(CAD Page) 19-May-2011/12:37:08: MEDICAL: Inc# 010306: 6530 WENTWORTH SPRINGS RD ,GEORGETOWN (GEORGETOWN ELEMENTARY SCHOOL) GEOCHF GEOENG M89 61; ; X: -120 49.84",
        "CALL:MEDICAL",
        "ID:010306",
        "ADDR:6530 WENTWORTH SPRINGS RD",
        "CITY:GEORGETOWN",
        "PLACE:GEORGETOWN ELEMENTARY SCHOOL",
        "UNIT:GEOCHF GEOENG M89 61",
        "GPS:X: -120 49.84");

    doTest("T3",
        "(CAD Page) 17-May-2011/01:52:37: MED, TRAFFIC COLLISION: Inc# 010121: 4800 BLACK OAK MINE RD / 4702 MARSHALL RD ,GARDEN_VALLEY  GRVCHF E2772 E251N M61 51 GEOENGN",
        "CALL:MED, TRAFFIC COLLISION",
        "ID:010121",
        "ADDR:4800 BLACK OAK MINE RD & 4702 MARSHALL RD",
        "CITY:GARDEN VALLEY",
        "UNIT:GRVCHF E2772 E251N M61 51 GEOENGN");

    doTest("T4",
        "(CAD Page) 20-May-2011/12:16:59: MED, CODE 2: Inc# 010397: 5961 RESERVOIR RD ,GEORGETOWN  GEOCHF GEOENG M89 61; ; X: -120 51.3994  Y: 38",
        "CALL:MED, CODE 2",
        "ID:010397",
        "ADDR:5961 RESERVOIR RD",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENG M89 61",
        "GPS:X: -120 51.3994  Y: 38");

    doTest("T5",
        "(CAD Page) 20-May-2011/18:24:36: FIRE, SMOKE CHECK: Inc# 010430: 2990 GREENWOOD RD / 6272 HY 193 ,GEORGETOWN  GEOENGN M61 61; ; X: -120 50.5456  Y: 38 54.4036;",
        "CALL:FIRE, SMOKE CHECK",
        "ID:010430",
        "ADDR:2990 GREENWOOD RD & 6272 HY 193",
        "CITY:GEORGETOWN",
        "UNIT:GEOENGN M61 61",
        "GPS:X: -120 50.5456  Y: 38 54.4036");

    doTest("T6",
        "(CAD Page) 21-May-2011/19:39:31: MEDICAL: Inc# 010537: 2850 DERRICK DR ,GREENWOOD  GRVCHF GEOENGN M25 53 E251N; ; X: -120 54.1379  Y: 38 53.9151;",
        "CALL:MEDICAL",
        "ID:010537",
        "ADDR:2850 DERRICK DR",
        "CITY:GREENWOOD",
        "UNIT:GRVCHF GEOENGN M25 53 E251N",
        "GPS:X: -120 54.1379  Y: 38 53.9151");

    doTest("T7",
        "(CAD Page) 20-Jun-2011/16:46:01: MEDICAL: Inc# 013054: UNIVERSITY FALLS GATE @ =L(38.906110,-120.645832) ,GEORGETOWN  GEOCHF E33F M61 65 GEOENG; ; X: -120 38.749",
        "CALL:MEDICAL",
        "ID:013054",
        "ADDR:=L(38.906110,-120.645832)",
        "CITY:GEORGETOWN",
        "PLACE:UNIVERSITY FALLS GATE",
        "UNIT:GEOCHF E33F M61 65 GEOENG",
        "GPS:X: -120 38.749");


    doTest("T8",
        "(CAD Page) 11-Aug-2011/06:18:13: MEDICAL: Inc# 018175: 5031 CEDAR DR ,GEORGETOWN  GEOCHF GEOENGN M61 61; ; X: -120 49.9174  Y: 38 53.4478;",
        "CALL:MEDICAL",
        "ID:018175",
        "ADDR:5031 CEDAR DR",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENGN M61 61",
        "GPS:X: -120 49.9174  Y: 38 53.4478");

    doTest("T9",
        "(CAD Page) 10-Aug-2011/10:03:52: MED, TRAFFIC COLLISION: Inc# 018090: 15250 WENTWORTH SPRINGS RD / 999998 ELEVEN PINES 14N08 ,GEORGETOWN_RANGER_DISTRI GEOCHF E54",
        "CALL:MED, TRAFFIC COLLISION",
        "ID:018090",
        "ADDR:15250 WENTWORTH SPRINGS RD & 999998 ELEVEN PINES 14N08",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF E54");
  }
  
  public static void main(String[] args) {
    new CAElDoradoCountyParserTest().generateTests("T9", "CALL ID ADDR CITY PLACE UNIT GPS");
  }
}