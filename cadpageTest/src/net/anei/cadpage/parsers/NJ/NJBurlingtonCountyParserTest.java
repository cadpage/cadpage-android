package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJBurlingtonCountyParserTest extends BaseParserTest {
  
  public NJBurlingtonCountyParserTest() {
    setParser(new NJBurlingtonCountyParser(), "BURLINGTON COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        ".... (Station 171) : 129F E Mva/Fire             Priority: 1  : RT206                                              Venue: Southamptn    Cross Street . : CARRANZA RD Call Time- 16:56:48                                : 1721 : (609) 668-8686                Caller : CHARITA.THOMAS Nature of Call : MVA UNK INJS/FIRE IN VEH Additional Info    WPH1:  RADIUS 02 MILES Additional Inc#s",
        "SRC:Station 171",
        "CALL:129F E Mva/Fire",
        "ADDR:RT206 & CARRANZA RD",
        "CITY:Southampton",
        "ID:1721",
        "PHONE:(609) 668-8686",
        "NAME:CHARITA.THOMAS",
        "INFO:MVA UNK INJS/FIRE IN VEH\nWPH1:  RADIUS 02 MILES");

    doTest("T2",
        ".... (Station 171) :   11 F StrctrFire           Priority: 1  : 4209 RT563                                 Venue: Woodland  Located Between  : RT532/S OOY PLACE RD Call Time- 19:30:14                                : 2911 : (609) 848-4053                Caller : RODNEY CONCILMAN  Complaintant: 4211 RT563 Nature of Call : FLAMES COMING OUT OF THE CHIMNEY// Additional Inc#s",
        "SRC:Station 171",
        "CALL:11 F StrctrFire",
        "ADDR:4209 RT563",
        "CITY:Woodland",
        "X:RT532/S OOY PLACE RD",
        "ID:2911",
        "PHONE:(609) 848-4053",
        "NAME:RODNEY CONCILMAN",
        "INFO:FLAMES COMING OUT OF THE CHIMNEY//");

    doTest("T3",
        ".... (Station 171) :  EMS E EMS Call             Priority: 1  : 1883 RT38                                          Venue: Southamptn  Located Between  : SMITHVILLE RD/RT206   : DIAMOND M LUMBER Call Time- 09:35:44                      : 1711: (609) 261-2701                Caller : NJSP Nature of Call : MVA / RQST EMS",
        "SRC:Station 171",
        "CALL:EMS E EMS Call",
        "ADDR:1883 RT38",
        "CITY:Southampton",
        "X:SMITHVILLE RD/RT206",
        "PLACE:DIAMOND M LUMBER",
        "PHONE:1711: (609) 261-2701",
        "NAME:NJSP",
        "INFO:MVA / RQST EMS");

    doTest("T4",
        ".... (Station 171) : FIRE F Fire Call            Priority: 1  : 26 NEW RD                                            Venue: Tabernacle  Located Between  : SOUTHAMPTON TWP LINE/WALTHAM DR Call Time- 19:50:50                                : 4312 : (609) 268-8218                Caller : JOHN JR MEALE Nature of Call : POSS CHIMNEY FIRE Additional Info    RESD:    MEMBER OF STATION 439 ON LOCATION (REEPORTING BY PHONE)      19:55:26   REPORTING A WORKING CHIMNEY FIRE //",
        "SRC:Station 171",
        "CALL:FIRE F Fire Call",
        "ADDR:26 NEW RD",
        "CITY:Tabernacle",
        "X:SOUTHAMPTON TWP LINE/WALTHAM DR",
        "ID:4312",
        "PHONE:(609) 268-8218",
        "NAME:JOHN JR MEALE",
        "INFO:POSS CHIMNEY FIRE\nRESD:    MEMBER OF STATION 439 ON LOCATION (REEPORTING BY PHONE)      19:55:26   REPORTING A WORKING CHIMNEY FIRE //");

    doTest("T5",
        ".... (Station 171) :  EMS E EMS Call             Priority: 1  : 2400 RT70                                            Venue: Southamptn  Located Between  : BURRS MILL RD/MILE RD Call Time- 15:16:39                                : 1723 : (732) 581-5640                Caller : JOEL MADDEN Nature of Call : VEH INTO TREE Additional Info    WPH2:  RADIUS 04 MILES Additional Inc#s",
        "SRC:Station 171",
        "CALL:EMS E EMS Call",
        "ADDR:2400 RT70",
        "CITY:Southampton",
        "X:BURRS MILL RD/MILE RD",
        "ID:1723",
        "PHONE:(732) 581-5640",
        "NAME:JOEL MADDEN",
        "INFO:VEH INTO TREE\nWPH2:  RADIUS 04 MILES");

    doTest("T6",
        ".... (Station 171) : 129F E Mva/Fire             Priority: 1  : 2400 RT70                                          Venue: Southamptn  Located Between  : BURRS MILL RD/MILE RD Call Time- 15:16:39                       : 1723 : (732) 581-5640                Caller : JOEL MADDEN Nature of Call : VEH INTO TREE Additional Info    WPH2:  MM24 Additional Inc#s",
        "SRC:Station 171",
        "CALL:129F E Mva/Fire",
        "ADDR:2400 RT70",
        "CITY:Southampton",
        "X:BURRS MILL RD/MILE RD",
        "ID:1723",
        "PHONE:(732) 581-5640",
        "NAME:JOEL MADDEN",
        "INFO:VEH INTO TREE\nWPH2:  MM24");
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyParserTest().generateTests("T1");
  }
}