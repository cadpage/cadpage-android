package net.anei.cadpage;

import static org.junit.Assert.*;

import org.junit.Test;

public class SmsMmsMessageTest {
  
  @Test
  public void testParseInfo() {
    
    doParseTest("MILivingstonCounty",
        "Pagecopy-Fr:CAD@livingstoncounty.livco\nCAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:FYI: ;OVDOSE;4676 KENMORE DR;[Medical Priority Info] RESPONSE: P1 STA 1");
    
    doParseTest("MOPulaskiCounty",
        "1 of 3\n" +
        "FRM:911dispatch@embarqmail.com\n" + 
        "SUBJ:DO NOT REPLY\n" +
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n" +
        "(Con't) 2 of 3\n" +
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n" +
        "(Con't) 3 of 3\n" +
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "911dispatch@embarqmail.com",
        "DO NOT REPLY",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29");
    
    doParseTest("T0",
        "JUST A PLAIN TEXT MESSAGE",
        "ken@cadpage.org",
        "",
        "JUST A PLAIN TEXT MESSAGE");
    
    doParseTest("T1", 
        "1 of 3\n"+
        "FRM:CAD@livingstoncounty.livco\n"+
        "MSG:CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10\n" +
        "(Con't) 2 of 3\n" +
        "20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN\n" +
        "(Con 3 of 3\n" +
        "BREAK(End)",
        "CAD@livingstoncounty.livco",
        "",
        "CAD:FYI: ;CITAF;5579 E GRAND RIVER;WILDWOOD DR;Event spawned from CITIZEN ASSIST LAW. [12/10/10 20:08:59 SPHILLIPS] CALLER LIVES NEXT DOOR TO THE ADDRESS OF THE WATER MAINBREAK [12/10/10 20:04:40 HROSSNER] CALLER ADV OF A WATER MAIN BREAK");
    
    doParseTest("T2",
        "1 of 3\n"+
        "FRM:911dispatch@embarqmail.com\n"+ 
        "SUBJ:DO NOT REPLY\n"+
        "MSG:STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway\n"+
        "(Con't) 2 of 3\n"+
        "17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call\n"+
        "(Con't) 3 of 3\n"+
        "Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29(End)",
        "911dispatch@embarqmail.com",
        "DO NOT REPLY",
        "STRUCTURE FIRE RESIDENTIAL  11280 BATTLE LN  PULASKI COUNTY CrossStreets: Highway 17 0.42 mi W CFD1 DFD2 M23 TCFD1 DFD2 1553 1552 1562 1560 1351 1501 PCSD1 RESCUE MILLER T1 WRFD1 SRFD1 1902 1361 1952 T2 1650 HFD1 Call Received Time: 12/6/2010 20:46:54 Dispatch: 12/6/2010 21:50:29");
    
    doParseTest("MDPrinceGeorgesCounty",
        "FRM:e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>\n" +
        "MSG:48: TOWNHOUSE FIRE\n" +
        "E818 BO802\n" +
        "9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]\n" +
        "12/23 23:32\n" +
        "http://fireblitz.com/18/8.shtm",
        "e@fireblitz.com <Body%3AFRM%3Ae@fireblitz.com>",
        "",
        "48: TOWNHOUSE FIRE\n" +
        "E818 BO802\n" +
        "9903 BREEZY KNOLL CT [DEAD END & GREEN HAVEN RD]\n" +
        "12/23 23:32\n" +
        "http://fireblitz.com/18/8.shtm");
    
    doParseTest("MDAlleganyCounty",
        "FRM:LogiSYSCAD\nSUBJ:CAD Page for CFS 100110-96\nMSG:UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16",
        "LogiSYSCAD",
        "CAD Page for CFS 100110-96",
        "UNCONCIOUS/UNRESPONSIVE 91 S BROADWAY\nUnits: A53 CO16");
    
    doParseTest("NYOneidaCounty",
        "FRM:dispatch@oc911.org\nMSG:i>¿WEVF:2010:0181Dispatched10D02-DIFFICULTY SPEAKING BETWEEN BREATHS9071 DOPP HILL RD, WESTERN (ROUTE 46/;)",
        "dispatch@oc911.org",
        "",
        "i>¿WEVF:2010:0181Dispatched10D02-DIFFICULTY SPEAKING BETWEEN BREATHS9071 DOPP HILL RD, WESTERN (ROUTE 46/;)");
    
    doParseTest("TxCyCreekComCenter",
        "CommCenter@ccems.com <Body%3ACommCenter@ccems.com> [] TAP OUT (SAL)",
        "CommCenter@ccems.com <Body%3ACommCenter@ccems.com>",
        "",
        "TAP OUT (SAL)");
    
    doParseTest("MDHarford",
        "Subject:HCCAD\n[!] EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169",
        "ken@cadpage.org",
        "!",
        "EOC:F03 WIRES >WIRES/POLE SHAWNEE DR&WALTERS MILL RD XS: WALTERS MILL RD FOREST HILL NOT ENTERED Cad: 2010-000019169");
    
    doParseTest("shortMsg",
        "FRM:CommCenter@ccems.com\nMSG:BAD",
        "CommCenter@ccems.com",
        "",
        "BAD");
    
    doParseTest("(sub)msg",
        "(THE SUBJECT(ID 3342)) HELLO DOLLY",
        "ken@cadpage.org",
        "THE SUBJECT(ID 3342)",
        "HELLO DOLLY");
    
    doParseTest("[sub]msg",
        "[THE SUBJECT[ID 3342]] HELLO DOLLY",
        "ken@cadpage.org",
        "THE SUBJECT[ID 3342]",
        "HELLO DOLLY");
    
    doParseTest("(s1)[s2]",
        "(SUBJECT ONE) [ SUBJECT TWO ] HELLO BABE",
        "ken@cadpage.org",
        "SUBJECT TWO",
        "HELLO BABE");
    
    doParseTest("VAWaynesboro",
        "Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us> Msg: Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA",
        "Dispatch@ci.waynesboro.va.us <Body%3ADispatch@ci.waynesboro.va.us>",
        "",
        "Dispatch:2ND CALL 1001 HOPEMAN PKWY, ZAP12 INJURIES FROM PREVIOUS MVA");
    
    doParseTest("PABerksCounty",
        "FRM:\nSUBJ:1/2\nMSG:CAD MSG: *D TREESDWN FORGEDALE RD / CLAY VALLEY RD 0087 PSP IS REQ FIRE\nCO FOR TREE REMOVAL FROM ROADWAY // PSP NOT ON LOC BC",
        "",
        "1/2",
        "CAD MSG: *D TREESDWN FORGEDALE RD / CLAY VALLEY RD 0087 PSP IS REQ FIRE\nCO FOR TREE REMOVAL FROM ROADWAY // PSP NOT ON LOC BC");
  }
  
  private void doParseTest(String title, String body, String expFrom, String expSubject, String expBody) {
    SmsMmsMessage msg = new SmsMmsMessage("ken@cadpage.org", body, 0L, 0);
    assertEquals(title + ":FROM", expFrom, msg.getAddress());
    assertEquals(title + ":SUBJ", expSubject, msg.getSubject());
    assertEquals(title + ":BODY", expBody, msg.getMessageBody());
  }
}
