package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAYorkCountyCParserTest extends BaseParserTest {
  
  public PAYorkCountyCParserTest() {
    setParser(new PAYorkCountyCParser(), "YORK COUNTY", "PA");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "(Station 68) : 203 LOCUST DR \n" +
        "  FAIRVIEW TWP\n" +
        "  \n" +
        "LONGVIEW AVE / PLEASANT VIEW RD\n" +
        "District: 68-02\n\n" +
        "    FIRE STRUCT RESID\n" +
        "Units Sent: 2\n" +
        "FIRESTA68, 52-03",

        "SRC:Station 68",
        "ADDR:203 LOCUST DR",
        "CITY:FAIRVIEW TWP",
        "X:LONGVIEW AVE / PLEASANT VIEW RD",
        "MAP:68-02",
        "CALL:FIRE STRUCT RESID",
        "UNIT:FIRESTA68, 52-03");

    doTest("T2",
        "(Station 68) : 378 PLEASANT VIEW RD \n" +
        "  FAIRVIEW TWP\n" +
        "  \n" +
        "GURTNER RD / LANE\n" +
        "District: 68-02\n\n" +
        "    FIRE STRUCT RESID\n" +
        "Units Sent: 2\n" +
        "FIRESTA68, 52-12 \n\n" +
        "   ",

        "SRC:Station 68",
        "ADDR:378 PLEASANT VIEW RD",
        "CITY:FAIRVIEW TWP",
        "X:GURTNER RD / LANE",
        "MAP:68-02",
        "CALL:FIRE STRUCT RESID",
        "UNIT:FIRESTA68, 52-12");

    doTest("T3",
        "(Station 68) : 6000 LEWISBERRY RD \n" +
        "Additional Location Information:BLK\n" +
        "  CONEWAGO TWP\n" +
        "  \n" +
        "BREMER RD / ANDERSONTOWN RD\n" +
        "COPENHAFFER RD\n" +
        "District: 26-09",

        "SRC:Station 68",
        "ADDR:6000 LEWISBERRY RD",
        "PLACE:BLK",
        "CITY:CONEWAGO TWP",
        "X:BREMER RD / ANDERSONTOWN RD & COPENHAFFER RD",
        "MAP:26-09");

  }
  
  public static void main(String[] args) {
    new PAYorkCountyCParserTest().generateTests("T1");
  }
}
