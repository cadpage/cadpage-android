package net.anei.cadpage;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmsMmsMessageTest {
  
  @Test
  public void testParseInfo() {
    
    doParseTest("T0",
        "JUST A PLAIN TEXT MESSAGE",
        "ken@cadpage.org",
        "JUST A PLAIN TEXT MESSAGE");
    
    doParseTest("T1", 
        "1 of 3\n"+
        "FRM:CAD@livingstoncounty.livco\n"+
        "MSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10\n" +
        "(Con't) 2 of 3\n" +
        "20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN \n" +
        "(Con 3 of 3\n" +
        "BREAK(End)",
        "CAD@livingstoncounty.livco",
        "CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/1020:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK");
    
    doParseTest("T2",
        "1 of 3\n"+
        "FRM:911dispatch@embarqmail.com\n"+ 
        "SUBJ:DO NOT REPLY\n"+
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway \n"+
        "(Con't) 2 of 3\n"+
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call \n"+
        "(Con't) 3 of 3\n"+
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "911dispatch@embarqmail.com",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29");

  }
  
  private void doParseTest(String title, String body, String expFrom, String expBody) {
    SmsMmsMessage msg = new SmsMmsMessage("ken@cadpage.org", body, 0L, 0);
    assertEquals(title + ":FROM", expFrom, msg.getAddress());
    assertEquals(title + ":BODY", expBody, msg.getMessageBody());
  }
}
