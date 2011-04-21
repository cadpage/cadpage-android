package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYCayugaCountyParserTest extends BaseParserTest {
  
  public NYCayugaCountyParserTest() {
    setParser(new NYCayugaCountyParser(), "CAYUGA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(From 911 Center) 02/14/11 16:26 5 CEDAR LN BRUTUS Cardiac",
        "ADDR:5 CEDAR LN",
        "CITY:BRUTUS",
        "CALL:Cardiac");

    doTest("T2",
        "(From 911 Center) 02/14/11 14:59 8318 W  LOOP RD MONTEZUMA General",
        "ADDR:8318 W LOOP RD",
        "CITY:MONTEZUMA",
        "CALL:General");

    doTest("T3",
        "(From 911 Center) 02/14/11 12:19 PINE ST & PARK ST PORT BYRON Collapse",
        "ADDR:PINE ST & PARK ST",
        "CITY:PORT BYRON",
        "CALL:Collapse");

    doTest("T4",
        "(From 911 Center) 02/14/11 10:29 7 EVERGREEN LN BRUTUS Stroke",
        "ADDR:7 EVERGREEN LN",
        "CITY:BRUTUS",
        "CALL:Stroke");

    doTest("T5",
        "FRM:cayuga911@co.cayuga.ny.us\nSUBJ:From911Center\nMSG:\n04/20/11 13:51 3204 FRANKLIN STREET RD SENNETT Alarm - Fire\n",
        "ADDR:3204 FRANKLIN STREET RD",
        "CITY:SENNETT",
        "CALL:Alarm - Fire");
  }
  
  public static void main(String[] args) {
    new NYCayugaCountyParserTest().generateTests("T1", "ADDR CITY CALL");
  }
}