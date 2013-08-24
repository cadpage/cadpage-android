package net.anei.cadpage.parsers.WI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*

Kenosha County, WI (variant C) Pleasant Prarie Dispatch
Contact: David Wilkinson <dwilkinson@plprairiewi.com>
Sender: CAD@plprairiewi.com
System: Prophoenix

Subject:Phoenix Notification\n2012000453 {04/15/2012 14:23:51}\r\nMED CALL - Medical Call{1}\r\n9747 84th Pl\r\nUnits:\r\n    5642    \r\nComments:\r\n\r
Subject:Phoenix Notification\n2012000454 {04/15/2012 17:21:48}\r\nFIRE SNG - Fire - Single Engine{1}\r\n905 114th St\r\nUnits:\r\n    5641    5611  \r
Subject:Phoenix Notification\n2012000454 {04/15/2012 17:21:48}\r\nFIRE SNG - Fire - Single Engine{1}\r\n905 114th St\r\nUnits:\r\n    5641    5611  \r
Subject:Phoenix Notification\n2012000619 {05/16/2012 17:47:56}\r\nFIRE ALA - Fire - Alarm{1}\r\n9901 77th St,CMPLX\r\nUnits:\r\n    5642    \r\nCommen\r
Subject:Phoenix Notification\n2012000618 {05/16/2012 13:31:17}\r\nMED CALL - Medical Call{1}\r\n13000BLK 104th St\r\nUnits:\r\n    5642    \r\nComment\r

Subject:Phoenix Notification\n2012000618 {05/16/2012 13:31:17}\nMED CALL - Medical Call{1}\n13000BLK 104th St\nUnits:\n    5642    \nComment

*/

public class WIKenoshaCountyCParserTest extends BaseParserTest {
  
  public WIKenoshaCountyCParserTest() {
    setParser(new WIKenoshaCountyCParser(), "KENOSHA COUNTY", "WI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:Phoenix Notification\n" +
        "2012000453 {04/15/2012 14:23:51}\r\n" +
        "MED CALL - Medical Call{1}\r\n" +
        "9747 84th Pl\r\n" +
        "Units:\r\n" +
        "    5642    \r\n" +
        "Comments:\r\n" +
        "\r",

        "ID:2012000453",
        "DATE:04/15/2012",
        "TIME:14:23:51",
        "CODE:MED CALL",
        "CALL:Medical Call",
        "PRI:1",
        "ADDR:9747 84th Pl",
        "UNIT:5642");

    doTest("T2",
        "Subject:Phoenix Notification\n" +
        "2012000454 {04/15/2012 17:21:48}\r\n" +
        "FIRE SNG - Fire - Single Engine{1}\r\n" +
        "905 114th St\r\n" +
        "Units:\r\n" +
        "    5641    5611  \r",

        "ID:2012000454",
        "DATE:04/15/2012",
        "TIME:17:21:48",
        "CODE:FIRE SNG",
        "CALL:Fire - Single Engine",
        "PRI:1",
        "ADDR:905 114th St",
        "UNIT:5641 5611");

    doTest("T3",
        "Subject:Phoenix Notification\n" +
        "2012000454 {04/15/2012 17:21:48}\r\n" +
        "FIRE SNG - Fire - Single Engine{1}\r\n" +
        "905 114th St\r\n" +
        "Units:\r\n" +
        "    5641    5611  \r",

        "ID:2012000454",
        "DATE:04/15/2012",
        "TIME:17:21:48",
        "CODE:FIRE SNG",
        "CALL:Fire - Single Engine",
        "PRI:1",
        "ADDR:905 114th St",
        "UNIT:5641 5611");

    doTest("T4",
        "Subject:Phoenix Notification\n" +
        "2012000619 {05/16/2012 17:47:56}\r\n" +
        "FIRE ALA - Fire - Alarm{1}\r\n" +
        "9901 77th St,CMPLX\r\n" +
        "Units:\r\n" +
        "    5642    \r\n" +
        "Commen\r",

        "ID:2012000619",
        "DATE:05/16/2012",
        "TIME:17:47:56",
        "CODE:FIRE ALA",
        "CALL:Fire - Alarm",
        "PRI:1",
        "ADDR:9901 77th St",
        "APT:CMPLX",
        "UNIT:5642");

    doTest("T5",
        "Subject:Phoenix Notification\n" +
        "2012000618 {05/16/2012 13:31:17}\r\n" +
        "MED CALL - Medical Call{1}\r\n" +
        "13000BLK 104th St\r\n" +
        "Units:\r\n" +
        "    5642    \r\n" +
        "Comment\r",

        "ID:2012000618",
        "DATE:05/16/2012",
        "TIME:13:31:17",
        "CODE:MED CALL",
        "CALL:Medical Call",
        "PRI:1",
        "ADDR:13000BLK 104th St",
        "MADDR:13000 104th St",
        "UNIT:5642");
 
  }
  
  public static void main(String[] args) {
    new WIKenoshaCountyCParserTest().generateTests("T1");
  }
}