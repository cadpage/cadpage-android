package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCDuplinCountyParserTest extends BaseParserTest {
  
  public NCDuplinCountyParserTest() {
    setParser(new NCDuplinCountyParser(), "DUPLIN COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "D.CHAMBERS:113 GEORGE RD FAISON WARREN RD - SR 1301 X DEAD END 15:50:43 ILLNESS CALLER ADV SHE IS AT A NEIGHBORS HOUSE, BELIEVES HE IS INSIDE AND POSS SICK ADV HE HAS BEEN SICK RE @ 1322 WARREN RD SR 1301 TO DEAD END",
        "ADDR:113 GEORGE RD",  // Google calls this GEORGES RD
        "CITY:FAISON",
        "X:WARREN RD - SR 1301 / DEAD END",
        "TIME:15:50:43",
        "INFO:ILLNESS CALLER ADV SHE IS AT A NEIGHBORS HOUSE, BELIEVES HE IS INSIDE AND POSS SICK ADV HE HAS BEEN SICK RE @ 1322 WARREN RD SR 1301 TO DEAD END");

    doTest("T2",
        "T.KENNEDY:353 E I 40 MM CALLEWR DUPLIN 12:34:02",
        "ADDR:353 E I 40 MM CALLEWR",
        "TIME:12:34:02",
        "CALL:ALERT");

    doTest("T3",
        "T.KENNEDY:110 E MAIN ST EXT FAISON 16:15:11",
        "ADDR:110 E MAIN ST EXT",
        "MADDR:110 E MAIN ST",
        "CITY:FAISON",
        "TIME:16:15:11",
        "CALL:ALERT");

    doTest("T4",
        "T.KENNEDY:1 16:37:58 OUT OF SERVICE FOR ANY REASON FAISON RESCUE 5 10-17 BRUSH WILL RESPONSE IN THERE PLACE OCA: 2012001083",
        "ADDR:1",
        "TIME:16:37:58",
        "INFO:OUT OF SERVICE FOR ANY REASON FAISON RESCUE 5 10-17 BRUSH WILL RESPONSE IN THERE PLACE OCA: 2012001083");

    doTest("T5",
        "T.KENNEDY:364 I 40 MM DUPLIN 15:50:25 ACCIDENT-PROPERTY DAMAGE ONLY AND FAISON EXIT NO ONE IS HURT GREY HONDA AND A SILEVR TAURUS VEHICLES IN RD DUPLIN I 40",
        "ADDR:364 I 40 MM",
        "TIME:15:50:25",
        "INFO:ACCIDENT-PROPERTY DAMAGE ONLY AND FAISON EXIT NO ONE IS HURT GREY HONDA AND A SILEVR TAURUS VEHICLES IN RD DUPLIN I 40");
  }

  public static void main(String[] args) {
    new NCDuplinCountyParserTest().generateTests("T1", "ADDR APT CITY X ID TIME CALL INFO");
  }
}
