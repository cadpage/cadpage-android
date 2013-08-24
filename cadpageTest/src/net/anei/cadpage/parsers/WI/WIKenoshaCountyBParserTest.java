package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kenosha County, WI Village of Pleasant Prairie, Pleasant Prairie Fire & Rescue
Contact: David Wilkinson <dwilkinson@plprairiewi.com>
Sender: CAD@plprairiewi.com
System: Prophoenix

6245  CAD¡plprairiewi.com Subject:Phoenix Notification 2012000155 ä02/09/2012 03:24:52ñ MED CALL - Medical Callä1ñ 11623 28th Ave Units: 5641 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000152 ä02/08/2012 16:54:48ñ MED CALL - Medical Callä1ñ 9500BLK 88th Ave Units: 5642 Comments
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000153 ä02/08/2012 17:47:01ñ FIRE STR - Fire - Structureä1ñ 8000 95th St Units: 5691 5641 56
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000154 ä02/08/2012 18:09:17ñ ELEV ALM - Elevator Alarmä1ñ 8330 82nd St,CMPLX Units: 5642 Comm
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000151 ä02/08/2012 07:18:41ñ MED CALL - Medical Callä1ñ 11831 120th Ct Units: 5642 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000157 ä02/09/2012 18:43:23ñ MED CALL - Medical Callä1ñ 8109 57th Ave Units: 5641 Comments:
6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000158 ä02/09/2012 18:53:48ñ MED CALL - Medical Callä1ñ 10106 29th Ave Units: 5642 Comments:

*/

public class WIKenoshaCountyBParserTest extends BaseParserTest {
  
  public WIKenoshaCountyBParserTest() {
    setParser(new WIKenoshaCountyBParser(), "KENOSHA COUNTY", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "6245  CAD¡plprairiewi.com Subject:Phoenix Notification 2012000155 ä02/09/2012 03:24:52ñ MED CALL - Medical Callä1ñ 11623 28th Ave Units: 5641 Comments:",
        "ID:2012000155",
        "DATE:02/09/2012",
        "TIME:03:24:52",
        "CALL:MED CALL - Medical Call",
        "PRI:1",
        "ADDR:11623 28th Ave",
        "UNIT:5641");

    doTest("T2",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000152 ä02/08/2012 16:54:48ñ MED CALL - Medical Callä1ñ 9500BLK 88th Ave Units: 5642 Comments",
        "ID:2012000152",
        "DATE:02/08/2012",
        "TIME:16:54:48",
        "CALL:MED CALL - Medical Call",
        "PRI:1",
        "ADDR:9500BLK 88th Ave",
        "MADDR:9500 88th Ave",
        "UNIT:5642");

    doTest("T3",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000153 ä02/08/2012 17:47:01ñ FIRE STR - Fire - Structureä1ñ 8000 95th St Units: 5691 5641 56",
        "ID:2012000153",
        "DATE:02/08/2012",
        "TIME:17:47:01",
        "CALL:FIRE STR - Fire - Structure",
        "PRI:1",
        "ADDR:8000 95th St",
        "UNIT:5691 5641 56");

    doTest("T4",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000154 ä02/08/2012 18:09:17ñ ELEV ALM - Elevator Alarmä1ñ 8330 82nd St,CMPLX Units: 5642 Comm",
        "ID:2012000154",
        "DATE:02/08/2012",
        "TIME:18:09:17",
        "CALL:ELEV ALM - Elevator Alarm",
        "PRI:1",
        "ADDR:8330 82nd St",
        "PLACE:CMPLX",
        "UNIT:5642");

    doTest("T5",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000151 ä02/08/2012 07:18:41ñ MED CALL - Medical Callä1ñ 11831 120th Ct Units: 5642 Comments:",
        "ID:2012000151",
        "DATE:02/08/2012",
        "TIME:07:18:41",
        "CALL:MED CALL - Medical Call",
        "PRI:1",
        "ADDR:11831 120th Ct",
        "UNIT:5642");

    doTest("T6",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000157 ä02/09/2012 18:43:23ñ MED CALL - Medical Callä1ñ 8109 57th Ave Units: 5641 Comments:",
        "ID:2012000157",
        "DATE:02/09/2012",
        "TIME:18:43:23",
        "CALL:MED CALL - Medical Call",
        "PRI:1",
        "ADDR:8109 57th Ave",
        "UNIT:5641");

    doTest("T7",
        "6245: CAD¡plprairiewi.com Subject:Phoenix Notification 2012000158 ä02/09/2012 18:53:48ñ MED CALL - Medical Callä1ñ 10106 29th Ave Units: 5642 Comments:",
        "ID:2012000158",
        "DATE:02/09/2012",
        "TIME:18:53:48",
        "CALL:MED CALL - Medical Call",
        "PRI:1",
        "ADDR:10106 29th Ave",
        "UNIT:5642");
  
  }
  
  public static void main(String[] args) {
    new WIKenoshaCountyBParserTest().generateTests("T1");
  }
}