package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyElmontParserTest extends BaseParserTest {
  
  public NYNassauCountyElmontParserTest() {
    setParser(new NYNassauCountyElmontParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {


    doTest("T1",
        "Subject:4/4/2011 03:24\nCall: SPILL Sub: SPILL LINDEN BLVD ELMONT Cross: ELMONT ROAD &  11-A6, ZONE 5",
        "CALL:SPILL / SPILL",
        "ADDR:LINDEN BLVD",
        "CITY:ELMONT",
        "INFO:ELMONT ROAD &",
        "MAP:11-A6",
        "UNIT:ZONE 5");

    doTest("T2",
        "(4/7/2011 10:37) Call:  Sub: RESC 2095 DUTCH BROADWAY ELMONT Cross: GLAFIL ST & ELMONT ROADMALE WITH HAND STUCK IN BOX CRUSHER 12-B5, ZONE 5",
        "CALL:RESC",
        "ADDR:2095 DUTCH BROADWAY",
        "CITY:ELMONT",
        "INFO:GLAFIL ST & ELMONT ROADMALE WITH HAND STUCK IN BOX CRUSHER",
        "MAP:12-B5",
        "UNIT:ZONE 5");

    doTest("T3",
        "(4/11/2011 16:24) Call: MVAFIRE Sub: MVA 2095 DUTCH BROADWAY ELMONT Cross: GLAFIL ST & ELMONT ROADCAR INTO POLE CAR SMOKING 12-B5, ZONE 5",
        "CALL:MVAFIRE / MVA",
        "ADDR:2095 DUTCH BROADWAY",
        "CITY:ELMONT",
        "INFO:GLAFIL ST & ELMONT ROADCAR INTO POLE CAR SMOKING",
        "MAP:12-B5",
        "UNIT:ZONE 5");

    doTest("T4",
        "(4/11/2011 13:33) Call: GENERAL Sub: AUTO 2150 HEMPSTEAD TPK ELMONT Cross: CROSS ISLAND PKWY & PLAINFIELD AVE MAP 21, ZONE 1",
        "CALL:GENERAL / AUTO",
        "ADDR:2150 HEMPSTEAD TPK",
        "CITY:ELMONT",
        "INFO:CROSS ISLAND PKWY & PLAINFIELD AVE",
        "MAP:MAP 21",
        "UNIT:ZONE 1");

    doTest("T5",
        "(4/11/2011 13:32) Call: GENERAL Sub: AUTO 1835 CENTRAL AVE NO VALLEY STREAM Cross: FENWOOD DR & STUART AVENO PERMIT 16-B7, ZONE 5",
        "CALL:GENERAL / AUTO",
        "ADDR:1835 CENTRAL AVE",
        "CITY:NO VALLEY STREAM",
        "INFO:FENWOOD DR & STUART AVENO PERMIT",
        "MAP:16-B7",
        "UNIT:ZONE 5");

    doTest("T6",
        "(4/11/2011 05:46) Call:  Sub: AMBU 333 BILTMORE AVE ELMONT Cross: BONTA ST & MURRAY HILL STMALE RESP DISTRESS/ CODE 91 7-A4, ZONE 1",
        "CALL:AMBU",
        "ADDR:333 BILTMORE AVE",
        "CITY:ELMONT",
        "INFO:BONTA ST & MURRAY HILL STMALE RESP DISTRESS/ CODE 91",
        "MAP:7-A4",
        "UNIT:ZONE 1");

    doTest("T7",
        "(4/14/2011 07:54) Call: AUTOMAT Sub: AUTO 219 HEMPSTEAD TPK ELMONT Cross: STERLING ROAD & WARWICK ROADNO PERMIT 7-A3, ZONE 1",
        "CALL:AUTOMAT / AUTO",
        "ADDR:219 HEMPSTEAD TPK",
        "CITY:ELMONT",
        "INFO:STERLING ROAD & WARWICK ROADNO PERMIT",
        "MAP:7-A3",
        "UNIT:ZONE 1");

    doTest("T8",
        "(4/13/2011 23:35) Call: AUTOMAT Sub: AUTO 817 PRESCOTT ST NO VALLEY STREAM Cross: FLETCHER (N) AVE & LEE ST70146485 - KAHN RES 13-C6, ZONE 5",
        "CALL:AUTOMAT / AUTO",
        "ADDR:817 PRESCOTT ST",
        "CITY:NO VALLEY STREAM",
        "INFO:FLETCHER (N) AVE & LEE ST70146485 - KAHN RES",
        "MAP:13-C6",
        "UNIT:ZONE 5");

  }
  
  public static void main(String[] args) {
    new NYNassauCountyElmontParserTest().generateTests("T7");
  }
}