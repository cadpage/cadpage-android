package net.anei.cadpage.parsers.ZCAAB;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ZCAABLacombeCountyParserTest extends BaseParserTest {
  
  public ZCAABLacombeCountyParserTest() {
    setParser(new ZCAABRedDeerCountyParser(), "RED DEER COUNTY", "AB");
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
  
  @Test
  public void testLamontCounty() {

    doTest("T1",
        "(CAD Message) Date: 2012-07-29 10:48:02\n" +
        "Type: 29D2k - Traffic Incidents\n" +
        "Location: TWP RD 550 /Rng rd 171, Lamont County\n" +
        "Units Respo",

        "DATE:07/29/2012",
        "TIME:10:48:02",
        "CALL:29D2k - Traffic Incidents",
        "ADDR:TWP RD 550 & Rng rd 171",
        "MADDR:TWP RD 550 & Range rd 171",
        "CITY:Lamont County");

    doTest("T2",
        "(Mundare Station) Date: 2012-08-14 06:55:06\nType: 29 - Traffic Incidents\nLocation: 171016 Hwy 16, Lamont County\nUnits Respondi",
        "DATE:08/14/2012",
        "TIME:06:55:06",
        "CALL:29 - Traffic Incidents",
        "ADDR:171016 Hwy 16",
        "MADDR:171016 RT 16",
        "CITY:Lamont County");

    doTest("T3",
        "(CAD Message) Date: 2012-08-14 06:55:06\n" +
        "Type: 29 - Traffic Incidents\n" +
        "Location: 171016 Hwy 16, Lamont County\n" +
        "Units Responding: LCC1,",

        "DATE:08/14/2012",
        "TIME:06:55:06",
        "CALL:29 - Traffic Incidents",
        "ADDR:171016 Hwy 16",
        "MADDR:171016 RT 16",    // Can't find address
        "CITY:Lamont County",
        "UNIT:LCC1,");

    doTest("T4",
        "(CAD Message) Date: 2012-08-23 17:36:56\n" +
        "Type: 71 - Vehicle Fire\n" +
        "Location: 9999 NE 25 53 17 W4, Mundare Rural Area\n" +
        "Units Responding:",

        "DATE:08/23/2012",
        "TIME:17:36:56",
        "CALL:71 - Vehicle Fire",
        "ADDR:9999 NE 25 53 17 W4", // What is this??
        "CITY:Mundare Rural Area");

    doTest("T5",
        "(CAD Message) Date: 2012-09-04 14:25:32\n" +
        "Type: 9E1 - Cardiac Arrest\n" +
        "Location: Unknown Location - Call Dispatch\n" +
        "Units Responding: LCC",

        "DATE:09/04/2012",
        "TIME:14:25:32",
        "CALL:9E1 - Cardiac Arrest",
        "ADDR:Unknown Location - Call Dispatch",
        "UNIT:LCC");

  }
  
  public static void main(String[] args) {
    new ZCAABLacombeCountyParserTest().generateTests("T1");
  }
}