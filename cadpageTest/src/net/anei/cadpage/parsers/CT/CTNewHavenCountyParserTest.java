package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTNewHavenCountyParserTest extends BaseParserTest {
  
  public CTNewHavenCountyParserTest() {
    setParser(new CTNewHavenCountyParser(), "NEW HAVEN COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MARINE INCIDENT, - SEARCH at BLOCK ISLAND RD BRANFORD, GUILFORD . . 14:27:56",
        "CALL:MARINE INCIDENT - SEARCH",
        "ADDR:BLOCK ISLAND RD",
        "CITY:BRANFORD",
        "SRC:GUILFORD");

    doTest("T2",
        "CODE 5,- AUTOMATIC FIRE ALARM at 275 LAKE DRIVE GUILFORD 15:57",
        "PRI:5",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:275 LAKE DRIVE",
        "CITY:GUILFORD");

    doTest("T3",
        "CODE 1,- AUTOMATIC FIRE ALARM at 35 STATE STREET, GUILFORD 17:15 cross street 1-begins at broad st;115-Boston Post Road;180-North Street",
        "PRI:1",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:35 STATE STREET",
        "CITY:GUILFORD",
        "SRC:GUILFORD",
        "INFO:cross street 1-begins at broad st;115-Boston Post Road;180-North Street");

    doTest("T4",
        "CODE 2,- DTN MEDICAL EMERGENCY at 669 BOSTON POST ROAD, GUILFORD 10:19",
        "PRI:2",
        "CALL:DTN MEDICAL EMERGENCY",
        "ADDR:669 BOSTON POST ROAD",
        "CITY:GUILFORD",
        "SRC:GUILFORD");

    doTest("T5",
        "CODE 1,- APPLIANCE,TV,ETC. at 258 CHESTNUT GROVE ROAD 19:50",
        "PRI:1",
        "CALL:APPLIANCE,TV,ETC.",
        "ADDR:258 CHESTNUT GROVE ROAD");

    doTest("T6",
        "CODE 2,-DTN MEDICAL EMERGENCY at 49 GUILFORD COURT, GUILFORD 15:47",
        "PRI:2",
        "CALL:DTN MEDICAL EMERGENCY",
        "ADDR:49 GUILFORD COURT",
        "CITY:GUILFORD",
        "SRC:GUILFORD");

    doTest("T7",
        "CODE 5,- AUTOMATIC FIRE ALARM at 159 LEDGE HILL ROAD, GUILFORD 11:40",
        "PRI:5",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:159 LEDGE HILL ROAD",
        "CITY:GUILFORD",
        "SRC:GUILFORD");


    doTest("T8",
        "CODE 1,- AUTOMATIC FIRE ALARM at 53 IRONWOOD ROAD, GUILFORD 11:43",
        "PRI:1",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:53 IRONWOOD ROAD",
        "CITY:GUILFORD",
        "SRC:GUILFORD");


    doTest("T9",
        "CODE 2,-DTN MEDICAL EMERGENCY at 51 WATER STREET, GUILFORD 10:46",
        "PRI:2",
        "CALL:DTN MEDICAL EMERGENCY",
        "ADDR:51 WATER STREET",
        "CITY:GUILFORD",
        "SRC:GUILFORD");


    doTest("T10",
        "CODE 4, - DTN STRUCTURE FIRE at 9 OLD BARN LN, GUILFORD 08:33",
        "PRI:4",
        "CALL:DTN STRUCTURE FIRE",
        "ADDR:9 OLD BARN LN",
        "CITY:GUILFORD",
        "SRC:GUILFORD");

    doTest("T11",
        "CODE 4, - DTN STRUCTURE FIRE at 125 GOOSE LANE, GUILFORD 09:32",
        "PRI:4",
        "CALL:DTN STRUCTURE FIRE",
        "ADDR:125 GOOSE LANE",
        "CITY:GUILFORD",
        "SRC:GUILFORD");

  }
  
  public static void main(String[] args) {
    new CTNewHavenCountyParserTest().generateTests("T1", "PRI CALL ADDR CITY SRC INFO");
  }
}