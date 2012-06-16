package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ZCAABLacombeCountyParserTest extends BaseParserTest {
  
  public ZCAABLacombeCountyParserTest() {
    setParser(new ZCAABLacombeCountyParser(), "LACOMBE COUNTY", "AB");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Incident Message) Date: 2012-06-02 13:02:11\n" +
        "Type: GRASS - 2.3 Grass/ Brush/ Forest\n" +
        "Location: Unknown Location - Call Dispatch\n" +
        "Latitude: 52.38667500\n" +
        "Longitude: -113.81778000",

        "DATE:06/02/2012",
        "TIME:13:02:11",
        "CALL:GRASS - 2.3 Grass/ Brush/ Forest",
        "ADDR:52.38667500,-113.81778000",
        "MADDR:52.386675,-113.81778",
        "GPS:52.38667500,-113.81778000");

    doTest("T2",
        "(Incident Message) Date: 2012-06-02 13:02:11\n" +
        "Type: GRASS - 2.3 Grass/ Brush/ Forest\n" +
        "Location: 1 BLACKFALDS, TOWN OF, BLACKFALDS\n" +
        "Units Responding: BLKP4, BLKP2, BLKT1, BLKC",

        "DATE:06/02/2012",
        "TIME:13:02:11",
        "CALL:GRASS - 2.3 Grass/ Brush/ Forest",
        "ADDR:1 BLACKFALDS",
        "CITY:BLACKFALDS",
        "UNIT:BLKP4, BLKP2, BLKT1, BLKC");

    doTest("T3",
        "(Incident Message) Date: 2012-06-04 01:21:42\n" +
        "Type: ALARMS - 2.6 Alarms\n" +
        "Location: 7 GREYSTONE DR, BLACKFALDS RURAL\n" +
        "Units Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1",

        "DATE:06/04/2012",
        "TIME:01:21:42",
        "CALL:ALARMS - 2.6 Alarms",
        "ADDR:7 GREYSTONE DR",
        "CITY:BLACKFALDS RURAL",
        "UNIT:BLKP1, BLKP2, BLKR3, BLKC, BLKT1");

    doTest("T4",
        "(Incident Message) Date: 2012-06-06 12:23:42\n" +
        "Type: ALARMS - 2.6 Alarms\n" +
        "Location: 6 WINSTON PL, BLACKFALDS\n" +
        "Latitude: 52.38963050\n" +
        "Longitude: -113.79837571\n" +
        "Units Responding: BLKP1, BLKP2, BLKR3, BLKC, BLKT1",

        "DATE:06/06/2012",
        "TIME:00:23:42",
        "CALL:ALARMS - 2.6 Alarms",
        "ADDR:6 WINSTON PL",
        "CITY:BLACKFALDS",
        "GPS:52.38963050,-113.79837571",
        "UNIT:BLKP1, BLKP2, BLKR3, BLKC, BLKT1");

  }
  
  public static void main(String[] args) {
    new ZCAABLacombeCountyParserTest().generateTests("T1");
  }
}