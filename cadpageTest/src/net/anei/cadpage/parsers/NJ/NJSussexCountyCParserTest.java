package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sussex County, NJ

Contact: Mark Snook <msnook1@gmail.com>
Sender: donotreply@vernonpolice.com
(WTFD) 13-07508\n7/1/2013 4:34:22 PM\n144  Lower Unionville Road\nFire O (Other Type)\nNotes: transformer blew- pole on fire\n\n\n-- \nThis message has
(WTFD) 13-07454\n6/30/2013 4:01:12 PM\n2 Morgan Drive\nFire O (Other Type)\nNotes: C/O Alarm - no symptoms\n\n\n-- \nThis message has been scanned for v
(WTFD) 13-07043\n6/24/2013 12:38:55 AM\n934 State Hwy 23\nMVA / Motor Vehicle Crash\nNotes: 1 car on its side with entrapment\n\n\n-- \nThis message has
(WTFD) 13-06760\n6/19/2013 5:45:37 PM\n135 Old Clove Road\nFire O (Other Type)\nNotes: wire on fire on pole across street\n\n\n-- \nThis message has bee
(WTFD) 13-07454\n6/30/2013 4:01:12 PM\n2 Morgan Drive\nFire O (Other Type)\nNotes: C/O Alarm - no symptoms\n\n\n-- \nThis message has been scanned for v
(WTFD) 13-07508\n7/1/2013 4:34:22 PM\n144  Lower Unionville Road\nFire O (Other Type)\nNotes: transformer blew- pole on fire\n\n\n-- \nThis message has
(WTFD) 13-07437\n6/30/2013 12:39:18 AM\n218 County Route 519\nFire O (Other Type)\nNotes: Pole and wires in roadway from MVA\n\n\n-- \nThis message has

 */

public class NJSussexCountyCParserTest extends BaseParserTest {
  
  public NJSussexCountyCParserTest() {
    setParser(new NJSussexCountyCParser(), "SUSSEX COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(WTFD) 13-07508\n" +
        "7/1/2013 4:34:22 PM\n" +
        "144  Lower Unionville Road\n" +
        "Fire O (Other Type)\n" +
        "Notes: transformer blew- pole on fire\n\n\n" +
        "-- \n" +
        "This message has",

        "SRC:WTFD",
        "ID:13-07508",
        "DATE:07/01/2013",
        "TIME:16:34:22",
        "ADDR:144  Lower Unionville Road",
        "CALL:Fire O (Other Type)",
        "INFO:transformer blew- pole on fire");

    doTest("T2",
        "(WTFD) 13-07454\n" +
        "6/30/2013 4:01:12 PM\n" +
        "2 Morgan Drive\n" +
        "Fire O (Other Type)\n" +
        "Notes: C/O Alarm - no symptoms\n\n\n" +
        "-- \n" +
        "This message has been scanned for v",

        "SRC:WTFD",
        "ID:13-07454",
        "DATE:06/30/2013",
        "TIME:16:01:12",
        "ADDR:2 Morgan Drive",
        "CALL:Fire O (Other Type)",
        "INFO:C/O Alarm - no symptoms");

    doTest("T3",
        "(WTFD) 13-07043\n" +
        "6/24/2013 12:38:55 AM\n" +
        "934 State Hwy 23\n" +
        "MVA / Motor Vehicle Crash\n" +
        "Notes: 1 car on its side with entrapment\n\n\n" +
        "-- \n" +
        "This message has",

        "SRC:WTFD",
        "ID:13-07043",
        "DATE:06/24/2013",
        "TIME:00:38:55",
        "ADDR:934 State Hwy 23",
        "MADDR:934 STATE 23",
        "CALL:MVA / Motor Vehicle Crash",
        "INFO:1 car on its side with entrapment");

    doTest("T4",
        "(WTFD) 13-06760\n" +
        "6/19/2013 5:45:37 PM\n" +
        "135 Old Clove Road\n" +
        "Fire O (Other Type)\n" +
        "Notes: wire on fire on pole across street\n\n\n" +
        "-- \n" +
        "This message has bee",

        "SRC:WTFD",
        "ID:13-06760",
        "DATE:06/19/2013",
        "TIME:17:45:37",
        "ADDR:135 Old Clove Road",
        "CALL:Fire O (Other Type)",
        "INFO:wire on fire on pole across street");

    doTest("T5",
        "(WTFD) 13-07454\n" +
        "6/30/2013 4:01:12 PM\n" +
        "2 Morgan Drive\n" +
        "Fire O (Other Type)\n" +
        "Notes: C/O Alarm - no symptoms\n\n\n" +
        "-- \n" +
        "This message has been scanned for v",

        "SRC:WTFD",
        "ID:13-07454",
        "DATE:06/30/2013",
        "TIME:16:01:12",
        "ADDR:2 Morgan Drive",
        "CALL:Fire O (Other Type)",
        "INFO:C/O Alarm - no symptoms");

    doTest("T6",
        "(WTFD) 13-07508\n" +
        "7/1/2013 4:34:22 PM\n" +
        "144  Lower Unionville Road\n" +
        "Fire O (Other Type)\n" +
        "Notes: transformer blew- pole on fire\n\n\n" +
        "-- \n" +
        "This message has",

        "SRC:WTFD",
        "ID:13-07508",
        "DATE:07/01/2013",
        "TIME:16:34:22",
        "ADDR:144  Lower Unionville Road",
        "CALL:Fire O (Other Type)",
        "INFO:transformer blew- pole on fire");

    doTest("T7",
        "(WTFD) 13-07437\n" +
        "6/30/2013 12:39:18 AM\n" +
        "218 County Route 519\n" +
        "Fire O (Other Type)\n" +
        "Notes: Pole and wires in roadway from MVA\n\n\n" +
        "-- \n" +
        "This message has",

        "SRC:WTFD",
        "ID:13-07437",
        "DATE:06/30/2013",
        "TIME:00:39:18",
        "ADDR:218 County Route 519",
        "MADDR:218 COUNTY ROAD 519",
        "CALL:Fire O (Other Type)",
        "INFO:Pole and wires in roadway from MVA");

  }
  
  public static void main(String[] args) {
    new NJSussexCountyCParserTest().generateTests("T1");
  }
}