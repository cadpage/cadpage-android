package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Cook County, IL
Contact: "Malcolm, John" <JMalcolm@mountprospect.org>
Sender: 911@NWCDS.org

[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3 \n
[20:10:53 11-07-2011] *D 1303 3F/409 OAK ST ,MP TWR13 E14 E12 A14 A12 BAT3
[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3
[13:03:43 11-11-2011] *D 1402 AFAF/1329 WOLF RD ,MP (EUCLID CROSSING) TWR13 E14 A14 BAT3
[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3
[17:38:36 11-08-2011] *D 1208 AFAF/803 GOLFVIEW DR ,MP TWR13 E12 A12 BAT3
[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3

*/

public class ILCookCountyParserTest extends BaseParserTest {
  
  public ILCookCountyParserTest() {
    setParser(new ILCookCountyParser(), "COOK COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3 \n",
        "TIME:10:20:32",
        "DATE:11/08/2011",
        "ID:1307",
        "CALL:AFAF",
        "ADDR:407 N MAIN ST",
        "CITY:MT PROSPECT",
        "PLACE:COMMUNITY PRESBYTERIAN CHURCH",
        "UNIT:TWR13 E13 A14 BAT3");

    doTest("T2",
        "[20:10:53 11-07-2011] *D 1303 3F/409 OAK ST ,MP TWR13 E14 E12 A14 A12 BAT3",
        "TIME:20:10:53",
        "DATE:11/07/2011",
        "ID:1303",
        "CALL:3F",
        "ADDR:409 OAK ST",
        "CITY:MT PROSPECT",
        "UNIT:TWR13 E14 E12 A14 A12 BAT3");

    doTest("T3",
        "[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3",
        "TIME:21:05:25",
        "DATE:11/10/2011",
        "ID:1202",
        "CALL:3F",
        "ADDR:725 HUNTINGTON COMMONS RD",
        "CITY:MT PROSPECT",
        "PLACE:LAKESIDE CONDOS",
        "UNIT:TWR13 E12 E13 A12 A13 BAT3");

    doTest("T4",
        "[13:03:43 11-11-2011] *D 1402 AFAF/1329 WOLF RD ,MP (EUCLID CROSSING) TWR13 E14 A14 BAT3",
        "TIME:13:03:43",
        "DATE:11/11/2011",
        "ID:1402",
        "CALL:AFAF",
        "ADDR:1329 WOLF RD",
        "CITY:MT PROSPECT",
        "PLACE:EUCLID CROSSING",
        "UNIT:TWR13 E14 A14 BAT3");

    doTest("T5",
        "[21:05:25 11-10-2011] *D 1202 3F/725 HUNTINGTON COMMONS RD ,MP (LAKESIDE CONDOS) TWR13 E12 E13 A12 A13 BAT3",
        "TIME:21:05:25",
        "DATE:11/10/2011",
        "ID:1202",
        "CALL:3F",
        "ADDR:725 HUNTINGTON COMMONS RD",
        "CITY:MT PROSPECT",
        "PLACE:LAKESIDE CONDOS",
        "UNIT:TWR13 E12 E13 A12 A13 BAT3");

    doTest("T6",
        "[17:38:36 11-08-2011] *D 1208 AFAF/803 GOLFVIEW DR ,MP TWR13 E12 A12 BAT3",
        "TIME:17:38:36",
        "DATE:11/08/2011",
        "ID:1208",
        "CALL:AFAF",
        "ADDR:803 GOLFVIEW DR",
        "CITY:MT PROSPECT",
        "UNIT:TWR13 E12 A12 BAT3");

    doTest("T7",
        "[10:20:32 11-08-2011] *D 1307 AFAF/407 N MAIN ST ,MP (COMMUNITY PRESBYTERIAN CHURCH) TWR13 E13 A14 BAT3",
        "TIME:10:20:32",
        "DATE:11/08/2011",
        "ID:1307",
        "CALL:AFAF",
        "ADDR:407 N MAIN ST",
        "CITY:MT PROSPECT",
        "PLACE:COMMUNITY PRESBYTERIAN CHURCH",
        "UNIT:TWR13 E13 A14 BAT3");
    
  }
  
  public static void main(String[] args) {
    new ILCookCountyParserTest().generateTests("T1");
  }
}