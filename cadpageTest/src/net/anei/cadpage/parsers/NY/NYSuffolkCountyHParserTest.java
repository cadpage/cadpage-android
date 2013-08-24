package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Suffolk County, NY (Variant H)
Contact: Christopher Hren <chren249@gmail.com>
Sender: communications@easthamptonvillageny.gov

(CALL) 07/26/2013 23:16 AUTOMATIC ALARM (CHIEFS) EH 9 CENTRAL AV EAST HAMPTON STOUTT RESIDENCE FIRE ALARM
(CALL) 07/19/2013 13:28 CHIEF INVESTIGATION EH 8 E HAMPTON DR W EAST HAMPTON TRANSFORMER ARCING
(CALL) 07/17/2013 14:52 CHIEF INVESTIGATION EH 124 OAKVIEW HWY EAST HAMPTON LIVE WIRE ARCING IN THE ROADWAY I/F/O THE ABOVE LOCATION

*/

public class NYSuffolkCountyHParserTest extends BaseParserTest {
  
  public NYSuffolkCountyHParserTest() {
    setParser(new NYSuffolkCountyHParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CALL) 07/26/2013 23:16 AUTOMATIC ALARM (CHIEFS) EH 9 CENTRAL AV EAST HAMPTON STOUTT RESIDENCE FIRE ALARM",
        "DATE:07/26/2013",
        "TIME:23:16",
        "CALL:AUTOMATIC ALARM (CHIEFS)",
        "SRC:EH",
        "ADDR:9 CENTRAL AV",
        "MADDR:9 CENTRAL AVE",
        "CITY:EAST HAMPTON",
        "INFO:STOUTT RESIDENCE FIRE ALARM");

    doTest("T2",
        "(CALL) 07/19/2013 13:28 CHIEF INVESTIGATION EH 8 E HAMPTON DR W EAST HAMPTON TRANSFORMER ARCING",
        "DATE:07/19/2013",
        "TIME:13:28",
        "CALL:CHIEF INVESTIGATION",
        "SRC:EH",
        "ADDR:8 E HAMPTON DR W",
        "CITY:EAST HAMPTON",
        "INFO:TRANSFORMER ARCING");

    doTest("T3",
        "(CALL) 07/17/2013 14:52 CHIEF INVESTIGATION EH 124 OAKVIEW HWY EAST HAMPTON LIVE WIRE ARCING IN THE ROADWAY I/F/O THE ABOVE LOCATION",
        "DATE:07/17/2013",
        "TIME:14:52",
        "CALL:CHIEF INVESTIGATION",
        "SRC:EH",
        "ADDR:124 OAKVIEW HWY",
        "CITY:EAST HAMPTON",
        "INFO:LIVE WIRE ARCING IN THE ROADWAY I/F/O THE ABOVE LOCATION");
  
  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyHParserTest().generateTests("T1");
  }
}