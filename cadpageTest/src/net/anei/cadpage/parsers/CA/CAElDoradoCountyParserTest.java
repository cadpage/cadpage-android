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
        "DATE:05/15/2011",
        "TIME:16:10:27",
        "CALL:HAZ, ELECTRICAL",
        "ID:010021",
        "ADDR:5537 MORGAN RANCH LOOP",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENG M61 61",
        "GPS:X: -120 50.5096  Y: 38 54.859");

    doTest("T2",
        "(CAD Page) 19-May-2011/12:37:08: MEDICAL: Inc# 010306: 6530 WENTWORTH SPRINGS RD ,GEORGETOWN (GEORGETOWN ELEMENTARY SCHOOL) GEOCHF GEOENG M89 61; ; X: -120 49.84",
        "DATE:05/19/2011",
        "TIME:12:37:08",
        "CALL:MEDICAL",
        "ID:010306",
        "ADDR:6530 WENTWORTH SPRINGS RD",
        "CITY:GEORGETOWN",
        "PLACE:GEORGETOWN ELEMENTARY SCHOOL",
        "UNIT:GEOCHF GEOENG M89 61",
        "GPS:X: -120 49.84");

    doTest("T3",
        "(CAD Page) 17-May-2011/01:52:37: MED, TRAFFIC COLLISION: Inc# 010121: 4800 BLACK OAK MINE RD / 4702 MARSHALL RD ,GARDEN_VALLEY  GRVCHF E2772 E251N M61 51 GEOENGN",
        "DATE:05/17/2011",
        "TIME:01:52:37",
        "CALL:MED, TRAFFIC COLLISION",
        "ID:010121",
        "ADDR:4800 BLACK OAK MINE RD & 4702 MARSHALL RD",
        "MADDR:4800 BLACK OAK MINE RD",
        "CITY:GARDEN VALLEY",
        "UNIT:GRVCHF E2772 E251N M61 51 GEOENGN");

    doTest("T4",
        "(CAD Page) 20-May-2011/12:16:59: MED, CODE 2: Inc# 010397: 5961 RESERVOIR RD ,GEORGETOWN  GEOCHF GEOENG M89 61; ; X: -120 51.3994  Y: 38",
        "DATE:05/20/2011",
        "TIME:12:16:59",
        "CALL:MED, CODE 2",
        "ID:010397",
        "ADDR:5961 RESERVOIR RD",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENG M89 61",
        "GPS:X: -120 51.3994  Y: 38");

    doTest("T5",
        "(CAD Page) 20-May-2011/18:24:36: FIRE, SMOKE CHECK: Inc# 010430: 2990 GREENWOOD RD / 6272 HY 193 ,GEORGETOWN  GEOENGN M61 61; ; X: -120 50.5456  Y: 38 54.4036;",
        "DATE:05/20/2011",
        "TIME:18:24:36",
        "CALL:FIRE, SMOKE CHECK",
        "ID:010430",
        "ADDR:2990 GREENWOOD RD & 6272 HY 193",
        "MADDR:2990 GREENWOOD RD",
        "CITY:GEORGETOWN",
        "UNIT:GEOENGN M61 61",
        "GPS:X: -120 50.5456  Y: 38 54.4036");

    doTest("T6",
        "(CAD Page) 21-May-2011/19:39:31: MEDICAL: Inc# 010537: 2850 DERRICK DR ,GREENWOOD  GRVCHF GEOENGN M25 53 E251N; ; X: -120 54.1379  Y: 38 53.9151;",
        "DATE:05/21/2011",
        "TIME:19:39:31",
        "CALL:MEDICAL",
        "ID:010537",
        "ADDR:2850 DERRICK DR",
        "CITY:GREENWOOD",
        "UNIT:GRVCHF GEOENGN M25 53 E251N",
        "GPS:X: -120 54.1379  Y: 38 53.9151");

    doTest("T7",
        "(CAD Page) 20-Jun-2011/16:46:01: MEDICAL: Inc# 013054: UNIVERSITY FALLS GATE @ =L(38.906110,-120.645832) ,GEORGETOWN  GEOCHF E33F M61 65 GEOENG; ; X: -120 38.749",
        "CALL:MEDICAL",
        "DATE:06/20/2011",
        "TIME:16:46:01",
        "ID:013054",
        "ADDR:=L(38.906110,-120.645832)",
        "MADDR:38.90611,-120.645832",
        "CITY:GEORGETOWN",
        "PLACE:UNIVERSITY FALLS GATE",
        "UNIT:GEOCHF E33F M61 65 GEOENG",
        "GPS:X: -120 38.749");

    doTest("T8",
        "(CAD Page) 11-Aug-2011/06:18:13: MEDICAL: Inc# 018175: 5031 CEDAR DR ,GEORGETOWN  GEOCHF GEOENGN M61 61; ; X: -120 49.9174  Y: 38 53.4478;",
        "DATE:08/11/2011",
        "TIME:06:18:13",
        "CALL:MEDICAL",
        "ID:018175",
        "ADDR:5031 CEDAR DR",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENGN M61 61",
        "GPS:X: -120 49.9174  Y: 38 53.4478");

    doTest("T9",
        "(CAD Page) 10-Aug-2011/10:03:52: MED, TRAFFIC COLLISION: Inc# 018090: 15250 WENTWORTH SPRINGS RD / 999998 ELEVEN PINES 14N08 ,GEORGETOWN_RANGER_DISTRI GEOCHF E54",
        "DATE:08/10/2011",
        "TIME:10:03:52",
        "CALL:MED, TRAFFIC COLLISION",
        "ID:018090",
        "ADDR:15250 WENTWORTH SPRINGS RD & 999998 ELEVEN PINES 14N08",
        "MADDR:15250 WENTWORTH SPRINGS RD",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF E54");

    doTest("T10",
        "(CAD Page) 25-Sep-2011/19:06:43: MED, CODE 2: Inc# 022661: 1000 HY 193 / 3000 HY 49 ,COOL  E22 M61 72; ; X: -121 0.9537  Y: 38 53.2183;",
        "DATE:09/25/2011",
        "TIME:19:06:43",
        "CALL:MED, CODE 2",
        "ID:022661",
        "ADDR:1000 HY 193 & 3000 HY 49",
        "MADDR:1000 HWY 193",
        "CITY:COOL",
        "UNIT:E22 M61 72",
        "GPS:X: -121 0.9537  Y: 38 53.2183");

    doTest("T11",
        "(CAD Page) 21-Jul-2012/18:36:57; FIRE, WILDLAND; Inc# 016722; 6085BLK W CHINA HILL RD ,EL_DORADO; B2709 U8113 E2751 E2769 E2784 E2774 E2752 E2782 E46 D2741 W46 W",
        "DATE:07/21/2012",
        "TIME:18:36:57",
        "CALL:FIRE, WILDLAND",
        "ID:016722",
        "ADDR:6085BLK W CHINA HILL RD",
        "MADDR:6085 W CHINA HILL RD",
        "CITY:EL DORADO",
        "UNIT:B2709 U8113 E2751 E2769 E2784 E2774 E2752 E2782 E46 D2741 W46 W");

    doTest("T12",
        "(CAD Page) 22-Jul-2012/12:23:38; MED, TRAFFIC COLLISION; Inc# 016781; 4732 HY 193 / 4600 MALTBY MINE RD ,GEORGETOWN; GEOCHF GEOENG M61 61 E51 E2752; X: -120 53.3",
        "DATE:07/22/2012",
        "TIME:12:23:38",
        "CALL:MED, TRAFFIC COLLISION",
        "ID:016781",
        "ADDR:4732 HY 193 & 4600 MALTBY MINE RD",
        "MADDR:4732 HWY 193",
        "CITY:GEORGETOWN",
        "UNIT:GEOCHF GEOENG M61 61 E51 E2752",
        "GPS:X: -120 53.3");

    doTest("T13",
        "(CAD Page) 26-Jul-2012/02:31:20; MEDICAL; Inc# 017152; 5780 TRAVERSE CREEK RD ,GARDEN_VALLEY; E2752 M61 52 E51; X: -120 48.3054 Y: 38 49.5004;",
        "DATE:07/26/2012",
        "TIME:02:31:20",
        "CALL:MEDICAL",
        "ID:017152",
        "ADDR:5780 TRAVERSE CREEK RD",
        "CITY:GARDEN VALLEY",
        "UNIT:E2752 M61 52 E51",
        "GPS:X: -120 48.3054 Y: 38 49.5004");

    doTest("T14",
        "(CAD Page) 03-Sep-2012/15:43:58; FIRE, SMOKE CHECK; Inc# 020679; =B(BALD MOUNTAIN LOOKOUT@272.5,6.0),GEORGETOWN; GEOENG M61 61 E2762; X: -120 48.7971 Y: 38 54.32",
        "DATE:09/03/2012",
        "TIME:15:43:58",
        "CALL:FIRE, SMOKE CHECK",
        "ID:020679",
        "ADDR:=B(BALD MOUNTAIN LOOKOUT@272.5,6.0)",
        "CITY:GEORGETOWN",
        "UNIT:GEOENG M61 61 E2762",
        "GPS:X: -120 48.7971 Y: 38 54.32");
  }
  
  public static void main(String[] args) {
    new CAElDoradoCountyParserTest().generateTests("T1", "DATE TIME CALL ID ADDR CITY PLACE UNIT GPS");
  }
}