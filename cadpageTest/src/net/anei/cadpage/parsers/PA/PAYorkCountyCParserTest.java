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
  
  @Test
  public void testMatthewRuss() {

    doTest("T1",
        "Subject:Station 41\n  752 OLD COMMONS RD \r\n   LOWER WINDSOR TWP\r\n  \r\nWINTERS RD / ADAIR RD\r\n    3638\r\n     FIRE STRUCT ENTRAP\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:752 OLD COMMONS RD",
        "CITY:LOWER WINDSOR TWP",
        "X:WINTERS RD / ADAIR RD",
        "MAP:3638",
        "CALL:FIRE STRUCT ENTRAP");

    doTest("T2",
        "Subject:Station 41\n  295 FRYSVILLE RD \r\n   HALLAM BORO\r\n  \r\nPRINCE MHP / VALLEY ACRES RD\r\n    5813\r\n     RESC WATER CL 2\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:295 FRYSVILLE RD",
        "CITY:HALLAM",
        "X:PRINCE MHP / VALLEY ACRES RD",
        "MAP:5813",
        "CALL:RESC WATER CL 2");

    doTest("T3",
        "Subject:Station 41\n  340 HELLAM ST \r\nCommon Name  TURKEY HILL WRIGHTSVILLE BORO\r\n   \r\n\r\n     FIRE WIRES\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:340 HELLAM ST",
        "PLACE:TURKEY HILL",
        "CITY:WRIGHTSVILLE",
        "CALL:FIRE WIRES");

    doTest("T4",
        "Subject:Station 41\n" +
        "  1675 NEW BRIDGEVILLE RD \r\n" +
        "   CHANCEFORD TWP\r\n" +
        "  \r\n" +
        "WHITE OAK RD / BURKHOLDER RD\r\n" +
        "FURNACE RD\r\n" +
        "    6294\r\n" +
        "     FIR\r",

        "SRC:Station 41",
        "ADDR:1675 NEW BRIDGEVILLE RD",
        "CITY:CHANCEFORD TWP",
        "X:WHITE OAK RD / BURKHOLDER RD & FURNACE RD",
        "MAP:6294",
        "CALL:FIR");

    doTest("T5",
        "Subject:Station 41\n  2266 SPANGLER CIR \r\n   SPRINGETTSBURY TWP\r\n  \r\nPOSES PL / ST JOHNS CT\r\n    6277\r\n     FIRE STRUCT RESID\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:2266 SPANGLER CIR",
        "CITY:SPRINGETTSBURY TWP",
        "X:POSES PL / ST JOHNS CT",
        "MAP:6277",
        "CALL:FIRE STRUCT RESID");

    doTest("T6",
        "Subject:Station 41\n  1972 W  PHILADELPHIA ST \r\nCommon Name  STOUGH DENTAL LAB\r\n   \r\n\r\n     FIRE STRUCT RESID\r\n\r\n\r",
        "SRC:Station 41",
        "ADDR:1972 W  PHILADELPHIA ST",
        "CALL:FIRE STRUCT RESID");

  }
  
  public static void main(String[] args) {
    new PAYorkCountyCParserTest().generateTests("T1");
  }
}
