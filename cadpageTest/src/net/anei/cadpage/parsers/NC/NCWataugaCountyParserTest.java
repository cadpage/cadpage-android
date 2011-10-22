package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCWataugaCountyParserTest extends BaseParserTest {
  
  public NCWataugaCountyParserTest() {
    setParser(new NCWataugaCountyParser(), "WATAUGA COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "524 JONES DR BOONE MDL 01A01 2011013875 02:10:09 ABDOMINAL PAIN 194S-CHESTNUT GRV RD-LT COBBS CREEK RD-1ST RT JONES DR",
        "ADDR:524 JONES DR",
        "CITY:BOONE",
        "CODE:01A01",
        "ID:2011013875",
        "TIME:02:10:09",
        "CALL:ABDOMINAL PAIN",
        "INFO:194S-CHESTNUT GRV RD-LT COBBS CREEK RD-1ST RT JONES DR");

    doTest("T2",
        "131 BIG VALLEY ST BOONE 2011013813 13:15:57 STRUCTURE FIRE 321S-LT DEERFIELD RD-TRAVEL 2.0 MI-RT BIG VALLEY ST INTO DEERFIELD MEADOWS BUSINESS PARK",
        "ADDR:131 BIG VALLEY ST",
        "CITY:BOONE",
        "ID:2011013813",
        "TIME:13:15:57",
        "CALL:STRUCTURE FIRE",
        "INFO:321S-LT DEERFIELD RD-TRAVEL 2.0 MI-RT BIG VALLEY ST INTO DEERFIELD MEADOWS BUSINESS PARK");

    doTest("T3",
        "200 QUAIL ST BOONE 2011013939 03:11:32 STANDBY",
        "ADDR:200 QUAIL ST",
        "CITY:BOONE",
        "ID:2011013939",
        "TIME:03:11:32",
        "CALL:STANDBY");

    doTest("T4",
        "853 HIDDEN VALLEY DR BOONE MDL 09E01 2011013997 20:13:36 ARREST-ADULT 105S-BESIDE HIDDEN VALLEY MOTEL-LT HIDDEN VALLEY DR",
        "ADDR:853 HIDDEN VALLEY DR",
        "CITY:BOONE",
        "CODE:09E01",
        "ID:2011013997",
        "TIME:20:13:36",
        "CALL:ARREST-ADULT",
        "INFO:105S-BESIDE HIDDEN VALLEY MOTEL-LT HIDDEN VALLEY DR");

  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "wcso911:190 MCGUIRE MOUNTAIN RD BANNER ELK 2011015829 22:33:54 10-50 PI 105S-RT BROADSTONE RD-LT 194S TO MATNEY-LT PIGEON ROOST RD-3RD LT MCGUIRE MTN RD",
        "ADDR:190 MCGUIRE MOUNTAIN RD",
        "PLACE:BANNER ELK",
        "ID:2011015829",
        "TIME:22:33:54",
        "CALL:10-50 PI",
        "INFO:105S-RT BROADSTONE RD-LT 194S TO MATNEY-LT PIGEON ROOST RD-3RD LT MCGUIRE MTN RD");

  }
  
  
  @Test
  public void testParser3() {

    doTest("T1",
        "wcso911@wataugacounty.org 164 BERTON ST BOONE MDL 06D02 2011017104 01:24:25 SICK PERSON 421S-RT OLD 421S-RT BROWNS CHAPEL RD-2ND LT NORTHRDG DR-1ST RT BERTON ST",
        "ADDR:164 BERTON ST",
        "CITY:BOONE",
        "CODE:06D02",
        "ID:2011017104",
        "TIME:01:24:25",
        "CALL:SICK PERSON",
        "INFO:421S-RT OLD 421S-RT BROWNS CHAPEL RD-2ND LT NORTHRDG DR-1ST RT BERTON ST");

    doTest("T2",
        "wcso911@wataugacounty.org 347 HOWARDS KNOB RD BOONE 2011017402 01:10:55 FALLS JUNALUSKA RD-RT HOWARDS KNOB RD",
        "ADDR:347 HOWARDS KNOB RD",
        "CITY:BOONE",
        "ID:2011017402",
        "TIME:01:10:55",
        "CALL:FALLS JUNALUSKA",
        "INFO:RD-RT HOWARDS KNOB RD");

  }

  public static void main(String[] args) {
    new NCWataugaCountyParserTest().generateTests("T2", "ADDR CITY PLACE CODE ID TIME CALL INFO");
  }
}
