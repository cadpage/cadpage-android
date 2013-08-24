package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Wilmington (brandywine), DE
Contact: "cmwetherby@aol.com" <cmwetherby@aol.com>
Contact: Michael DiMauro <mdimaurojr@gmail.com>
Contact: "backusgj@hotmail.com" <backusgj@hotmail.com>
Sender: brandywinefireco@comcast.net

06/06/2011*21:22*L1*SMOKE INVESTIGATION*8 E LEA BL btwn N MARKET ST & *PENNROSE
06/21/2011*06:01*ASSAULT - UNKNOWN*1202 FAIRVIEW AV btwn MAPLE AV*HOLLY OAK TERRACE*MALE SUBJECT MACED //NCCPD ENR
08/14/2011*08:19*CVA - NOT ALERT*207 ROWLAND PARK BL btwn HILLS*CARRCROFT
08/14/2011*16:00*L2*ELECTRICAL ODOR INSIDE*1304 HILLSIDE AV btwn W CLEARV*HOLLY OAK TERRACE
[Update]*08/10/2011*14:27*SYNCOPE - DIFF BREATHING*9 NEWARK UNION PUBLI RD btwn B*NORMANDY MANOR

 */

public class DEWilmingtonAParserTest extends BaseParserTest {
  
  public DEWilmingtonAParserTest() {
    setParser(new DEWilmingtonAParser(), "WILMINGTON", "DE");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "06/06/2011*21:22*L1*SMOKE INVESTIGATION*8 E LEA BL btwn N MARKET ST & *PENNROSE",
        "DATE:06/06/2011",
        "TIME:21:22",
        "PRI:L1",
        "CALL:SMOKE INVESTIGATION",
        "ADDR:8 E LEA BL",
        "X:N MARKET ST &",
        "PLACE:PENNROSE");

    doTest("T2",
        "06/21/2011*06:01*ASSAULT - UNKNOWN*1202 FAIRVIEW AV btwn MAPLE AV*HOLLY OAK TERRACE*MALE SUBJECT MACED //NCCPD ENR",
        "DATE:06/21/2011",
        "TIME:06:01",
        "CALL:ASSAULT - UNKNOWN",
        "ADDR:1202 FAIRVIEW AV",
        "MADDR:1202 FAIRVIEW AVE",
        "X:MAPLE AV",
        "PLACE:HOLLY OAK TERRACE",
        "INFO:MALE SUBJECT MACED //NCCPD ENR");

    doTest("T3",
        "08/14/2011*08:19*CVA - NOT ALERT*207 ROWLAND PARK BL btwn HILLS*CARRCROFT",
        "DATE:08/14/2011",
        "TIME:08:19",
        "CALL:CVA - NOT ALERT",
        "ADDR:207 ROWLAND PARK BL",
        "X:HILLS",
        "PLACE:CARRCROFT");

    doTest("T4",
        "08/14/2011*16:00*L2*ELECTRICAL ODOR INSIDE*1304 HILLSIDE AV btwn W CLEARV*HOLLY OAK TERRACE",
        "DATE:08/14/2011",
        "TIME:16:00",
        "PRI:L2",
        "CALL:ELECTRICAL ODOR INSIDE",
        "ADDR:1304 HILLSIDE AV",
        "MADDR:1304 HILLSIDE AVE",
        "X:W CLEARV",
        "PLACE:HOLLY OAK TERRACE");

    doTest("T5",
        "[Update]*08/10/2011*14:27*SYNCOPE - DIFF BREATHING*9 NEWARK UNION PUBLI RD btwn B*NORMANDY MANOR",
        "DATE:08/10/2011",
        "TIME:14:27",
        "CALL:SYNCOPE - DIFF BREATHING",
        "ADDR:9 NEWARK UNION PUBLI RD",
        "X:B",
        "PLACE:NORMANDY MANOR");
    
  }
  
  public static void main(String[] args) {
    new DEWilmingtonAParserTest().generateTests("T1");
  }
}
    		