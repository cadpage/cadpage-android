package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYWayneCountyParserTest extends BaseParserTest {
  
  public NYWayneCountyParserTest() {
    setParser(new NYWayneCountyParser(), "WAYNE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Dispatch\nDispatch ** 05:32 ** FALLS ** 1542 STEBBINS RD ** HERMAN, ELAINE ** STUART AVE * TELLIER RD ** 315-331-6505 ** \n",
        "TIME:05:32",
        "CALL:FALLS",
        "ADDR:1542 STEBBINS RD",
        "NAME:HERMAN, ELAINE",
        "X:STUART AVE & TELLIER RD",
        "PHONE:315-331-6505");

    doTest("T2",
        "Subject:Dispatch\nDispatch ** 23:01 ** MEDICAL ALARM ACTIVATION ** 790 E MAPLE AVE ** ADT ** DRUMLIN CT * CUYLER ST ** 877-238-7730 ** \n",
        "TIME:23:01",
        "CALL:MEDICAL ALARM ACTIVATION",
        "ADDR:790 E MAPLE AVE",
        "NAME:ADT",
        "X:DRUMLIN CT & CUYLER ST",
        "PHONE:877-238-7730");

    doTest("T3",
        "Subject:Dispatch\nDispatch ** 21:01 ** BREATHING PROBLEMS ** 5400 ROUTE 31 ** HALL, JANET ** WHITBECK RD * W UNION ST ** 315-359-3978 ** \n",
        "TIME:21:01",
        "CALL:BREATHING PROBLEMS",
        "ADDR:5400 ROUTE 31",
        "NAME:HALL, JANET",
        "X:WHITBECK RD & W UNION ST",
        "PHONE:315-359-3978");

    doTest("T4",
        "Subject:Dispatch\nDispatch ** 20:11 ** HOUSE FIRE ** 106 HILL ST ** VZW CALL ** LYONS ST * STANSELL ST ** 315-690-9286 ** \n",
        "TIME:20:11",
        "CALL:HOUSE FIRE",
        "ADDR:106 HILL ST",
        "NAME:VZW CALL",
        "X:LYONS ST & STANSELL ST",
        "PHONE:315-690-9286");

    doTest("T5",
        "Subject:Dispatch\nDispatch ** 10:49 ** ABDOMINAL PAIN / PROBLEMS ** 101 COBBLESTONE TER ** FINGER LAKES DD ** VIENNA ST * VIENNA ST ** 315-",
        "TIME:10:49",
        "CALL:ABDOMINAL PAIN / PROBLEMS",
        "ADDR:101 COBBLESTONE TER",
        "PLACE:FINGER LAKES DD",
        "X:VIENNA ST & VIENNA ST",
        "PHONE:315-");

    doTest("T6",
        "Subject:Dispatch\nDispatch ** 18:28 ** TRANSPORT-MEDICAL ** 1200 DRIVING PARK AVE ** NEWARK WAYNE CO ** SUNSET DR * FREY ST ** 332-2494 **",
        "TIME:18:28",
        "CALL:TRANSPORT-MEDICAL",
        "ADDR:1200 DRIVING PARK AVE",
        "PLACE:NEWARK WAYNE CO",
        "X:SUNSET DR & FREY ST",
        "PHONE:332-2494");

    doTest("T7",
        "Subject:Dispatch\nDispatch ** 22:04 ** BARN/GARAGE FIRE ** 735 BOHNER ** - ** ONTARIO COUNTY **  ** ",
        "TIME:22:04",
        "CALL:BARN/GARAGE FIRE",
        "ADDR:735 BOHNER",
        "CITY:ONTARIO COUNTY");
  }
  
  @Test
  public void testJeffZorn() {

    doTest("T1",
        "(6556 LAKE AVE) Dispatch ** 09:44 ** HAZARDOUS CONDITIONS ** 6556 LAKE AVE ** RAILROAD AVE * POUND RD ** -Apt: 8 **  **",
        "TIME:09:44",
        "CALL:HAZARDOUS CONDITIONS",
        "ADDR:6556 LAKE AVE",
        "X:RAILROAD AVE & POUND RD",
        "APT:8");
  }
  
  public static void main(String[] args) {
    new NYWayneCountyParserTest().generateTests("T1");
  }
}