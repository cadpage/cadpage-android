package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CAButteCountyParserTest extends BaseParserTest {
  
  public CAButteCountyParserTest() {
    setParser(new CAButteCountyParser(), "BUTTE COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Page) MEDICAL; 1759 12TH ST ,THERMALITO ; ; 1200 BLK TEHAMA AVE; Map: 6683; Inc# 002759; Date-Time: 21-Mar-2012/20:55:59; CARDIAC;",
        "CALL:MEDICAL / CARDIAC",
        "ADDR:1759 12TH ST",
        "CITY:THERMALITO",
        "X:1200 BLK TEHAMA AVE",
        "MAP:6683",
        "ID:002759",
        "DATE:21-Mar-2012",
        "TIME:20:55:59");

    doTest("T2",
        "(CAD Page) MEDICAL; 14897 DEL ORO DR ,MGLA ; ;  DEAD-END; Map: 5633; Inc# 002916; Date-Time: 26-Mar-2012/09:00:57; CARDIAC;",
        "CALL:MEDICAL / CARDIAC",
        "ADDR:14897 DEL ORO DR",
        "CITY:MAGALIA",
        "X:DEAD-END",
        "MAP:5633",
        "ID:002916",
        "DATE:26-Mar-2012",
        "TIME:09:00:57");

    doTest("T3",
        "(CAD Page) OTH,REFERRAL; 7540 OROVILLE BANGOR HWY / 2 BANGOR PARK RD ,BNGR ; ; ; Map: 6985; Inc# ; Date-Time: 28-Mar-2012/09:29:18; LOOSE HORSE ON BANGOR PARK RD",
        "CALL:OTH,REFERRAL / LOOSE HORSE ON BANGOR PARK RD",
        "ADDR:7540 OROVILLE BANGOR HWY & 2 BANGOR PARK RD",
        "MADDR:7540 OROVILLE BANGOR HWY",
        "CITY:BANGOR",
        "MAP:6985",
        "DATE:28-Mar-2012",
        "TIME:09:29:18");
 }
  
  @Test
  public void testChipFowler() {

    doTest("T1",
        "FRM:btucad@fire.ca.gov\n" +
        "SUBJ:CAD Page\n" +
        "MSG:MEDICAL; 6423 JACK HILL DR ,KELLY_RDGE ; ; 5499 BLK HIGH ROCKS CT; Map:6534; Inc# 003098;\n" +
        "(Con't) 2 of 2\n" +
        "Date-Time: 31-Mar-2012/22:38:02; ILL MALE; (End)",

        "CALL:MEDICAL / ILL MALE",
        "ADDR:6423 JACK HILL DR",
        "PLACE:KELLY RIDGE",
        "CITY:OROVILLE",
        "X:5499 BLK HIGH ROCKS CT",
        "MAP:6534",
        "ID:003098",
        "DATE:31-Mar-2012",
        "TIME:22:38:02");

  }
  
  public static void main(String[] args) {
    new CAButteCountyParserTest().generateTests("T1");
  }
}