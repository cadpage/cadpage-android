package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCMontgomeryCountyParserTest extends BaseParserTest {
  
  public NCMontgomeryCountyParserTest() {
    setParser(new NCMontgomeryCountyParser(), "MONTGOMERY COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SDUNN:201107504 105 WHITE TAIL RUN MT GILEAD MAN WITH A GUN jeremy collins is there arguing/ has a gun/subject is in the yard",
        "ID:201107504",
        "ADDR:105 WHITE TAIL RUN",
        "CITY:MT GILEAD",
        "CALL:MAN WITH A GUN",
        "INFO:jeremy collins is there arguing / has a gun / subject is in the yard");

    doTest("T2",
        "JWHITAKER:106 EAST ALLENTON ST MT GILEAD STATION 2 PAGE 201107494 16:44:24 station 2 will be having cpr class at 7 on Monday the 28th",
        "ID:201107494",
        "ADDR:106 EAST ALLENTON ST",
        "CITY:MT GILEAD",
        "CALL:STATION 2 PAGE",
        "INFO:station 2 will be having cpr class at 7 on Monday the 28th");

    doTest("T3",
        "MDAVIS:201107560 179 TILLERY DAM RD MT GILEAD ILLEGAL BURN MAN BURNING TRASH NEAR PLANT ON RIVERBED, HAVE ASKED HIM TO PUT IT OUT, REFUSING. EXT 0.",
        "ID:201107560",
        "ADDR:179 TILLERY DAM RD",
        "CITY:MT GILEAD",
        "CALL:ALERT",
        "INFO:ILLEGAL BURN MAN BURNING TRASH NEAR PLANT ON RIVERBED, HAVE ASKED HIM TO PUT IT OUT, REFUSING EXT 0");

    doTest("T4",
        "JWHITAKER:201107575 644 BISCOE RD TROY FIRE ALARM tommy and debbie honeycutt,gen fire and gen burg,no contact on premise,audible",
        "ID:201107575",
        "ADDR:644 BISCOE RD",
        "CITY:TROY",
        "CALL:FIRE ALARM",
        "INFO:tommy and debbie honeycutt,gen fire and gen burg,no contact on premise,audible");

    doTest("T5",
        "JWHITAKER:201107593 468 EAST MAIN ST CANDOR FIRE ALARM plant 28,riser 1 water flow",
        "ID:201107593",
        "ADDR:468 EAST MAIN ST",
        "CITY:CANDOR",
        "CALL:FIRE ALARM",
        "INFO:plant 28,riser 1 water flow");

    doTest("T6",
        "KMORRIS:1895 NC HWY 24-27 E INT BISCOE INFORMATION 201107696 12:09:59 test",
        "ID:201107696",
        "ADDR:1895 NC HWY 24 27 E",
        "MADDR:1895 NC 24 27 E",
        "CITY:BISCOE",
        "CALL:INFORMATION",
        "INFO:test");
  }
  

  public static void main(String[] args) {
    new NCMontgomeryCountyParserTest().generateTests("T1", "ID ADDR CITY CALL INFO");
  }
}
