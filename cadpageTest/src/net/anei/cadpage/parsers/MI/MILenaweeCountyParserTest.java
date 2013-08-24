package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Lenawee County, MI
Contact: Casidy Reiser <casidyreiser@gmail.com>
Sender: Lenawee@Lenawee.mi

Subject:!\nFire  102 TYRRELL ST TECUMSEH ST / JOSEPH KIES ST Clinton 42.0682269550001 -83.969574607 Common Name:  NO ARCING  LARGE LIMB Dr
Subject:!\nFire  10990 TECUMSEH CLINTON HWY VILLAGE LN, PENNINGTON RD / STAIB RD Clinton Twp 42.048519566 -83.9598904119999 Common Name: 
Subject:!\nFire  12174 MACON HWY SHORT ST / HACK RD, MACON RD Macon Twp 42.0689791780001 -83.865645211 Common Name:  TREES ACROSS THE ROAD
Subject:!\nMedical  8744 CLINTON MACON RD MILLS MACON HWY / MACON HWY Macon Twp 42.068935348 -83.8588074849999 Common Name:  ART VAN BUILD
Subject:!\nCrash - W/Injuries 12861 CLINTON RD ALLEN RD / FISK RD Out of County 42.0955255862698 -83.9694221524138 Common Name:  car vs tr

*/

public class MILenaweeCountyParserTest extends BaseParserTest {
  
  public MILenaweeCountyParserTest() {
	  setParser(new MILenaweeCountyParser(), "LENAWEE COUNTY", "MI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:!\n" +
        "Fire  102 TYRRELL ST TECUMSEH ST / JOSEPH KIES ST Clinton 42.0682269550001 -83.969574607 Common Name:  NO ARCING  LARGE LIMB Dr",

        "CALL:Fire",
        "ADDR:102 TYRRELL ST",
        "X:TECUMSEH ST / JOSEPH KIES ST",
        "CITY:Clinton",
        "GPS:+42.068227,-83.969575",
        "INFO:NO ARCING  LARGE LIMB Dr");

    doTest("T2",
        "Subject:!\n" +
        "Fire  10990 TECUMSEH CLINTON HWY VILLAGE LN, PENNINGTON RD / STAIB RD Clinton Twp 42.048519566 -83.9598904119999 Common Name: ",

        "CALL:Fire",
        "ADDR:10990 TECUMSEH CLINTON HWY",
        "X:VILLAGE LN, PENNINGTON RD / STAIB RD",
        "CITY:Clinton Twp",
        "GPS:+42.048520,-83.959890");

    doTest("T3",
        "Subject:!\n" +
        "Fire  12174 MACON HWY SHORT ST / HACK RD, MACON RD Macon Twp 42.0689791780001 -83.865645211 Common Name:  TREES ACROSS THE ROAD",

        "CALL:Fire",
        "ADDR:12174 MACON HWY",
        "X:SHORT ST / HACK RD, MACON RD",
        "CITY:Macon Twp",
        "GPS:+42.068979,-83.865645",
        "INFO:TREES ACROSS THE ROAD");

    doTest("T4",
        "Subject:!\n" +
        "Medical  8744 CLINTON MACON RD MILLS MACON HWY / MACON HWY Macon Twp 42.068935348 -83.8588074849999 Common Name:  ART VAN BUILD",

        "CALL:Medical",
        "ADDR:8744 CLINTON MACON RD",
        "X:MILLS MACON HWY / MACON HWY",
        "CITY:Macon Twp",
        "GPS:+42.068935,-83.858807",
        "INFO:ART VAN BUILD");

    setDefaults("", "MI");
    doTest("T5",
        "Subject:!\n" +
        "Crash - W/Injuries 12861 CLINTON RD ALLEN RD / FISK RD Out of County 42.0955255862698 -83.9694221524138 Common Name:  car vs tr",

        "CALL:Crash - W/Injuries",
        "ADDR:12861 CLINTON RD",
        "X:ALLEN RD / FISK RD",
        "GPS:+42.095526,-83.969422",
        "INFO:car vs tr");

  }
  
  public static void main(String[] args) {
    new MILenaweeCountyParserTest().generateTests("T1");
  }
}
