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
        ".... (Station 171) : 1  \n: 10 WINDING WY                                        Venue: Southamptn  \nLocated Between  : PHEASANT CL/DEAD END \n\nCall Time- 19:13:51                                : 1711 \n\n: (856) 287-8607                Caller : VERIZON WIRELESS \n\nNature of Call : MALE UNCONSCIOUS POSS OVERDOSE \n\nAdditional Info  \n  WPH2:  RADIUS 02 MILES",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:10 WINDING WY",
        "CITY:Southampton",
        "X:PHEASANT CL/DEAD END",
        "ID:1711",
        "PHONE:(856) 287-8607",
        "NAME:VERIZON WIRELESS",
        "INFO:MALE UNCONSCIOUS POSS OVERDOSE / WPH2: RADIUS 02 MILES");

    doTest("T2",
        ".... (Station 171) : 1  \n: STOCKTONS BRIDGE RD                                  Venue: Pembtn Twp  \n  Cross Street . : SIMONTOWN RD \n\nCall Time- 19:47:43                                : 1822 \n\n: (000) 000-0000                Caller : KGB CARRIER \n\nNature of Call : TRAILER FIRE \n\n  \nF1911 RSPNDING/COLUMN IN SIGHT                               19:50:52 \n\nAdditional Inc#s",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:STOCKTONS BRIDGE RD & SIMONTOWN RD",
        "CITY:Pemberton Twp",
        "ID:1822",
        "PHONE:(000) 000-0000",
        "NAME:KGB CARRIER",
        "INFO:TRAILER FIRE / F1911 RSPNDING/COLUMN IN SIGHT 19:50:52");

    doTest("T3",
        ".... (Station 171) : 1  \n: 6 PLEASANT ST                                        Venue: Southamptn  \nLocated Between  : MAIN ST/CHURCH ST \n\nCall Time- 13:27:39                                : 1700 \n\n: (609) 859-2302                Caller : RICHARD E FRANTZMAN \n\nNature of Call : MVA//VEH HIT THE HOUSE \n\nAdditional Info \n  RESD: \n\nAdditional Inc#s \n  RESD:  \n  VEHICLE TRYING TO LEAVE SCENE / NO REPORTED INJURIES \n\nAdditional Inc#s",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:6 PLEASANT ST",
        "CITY:Southampton",
        "X:MAIN ST/CHURCH ST",
        "ID:1700",
        "PHONE:(609) 859-2302",
        "NAME:RICHARD E FRANTZMAN",
        "INFO:MVA//VEH HIT THE HOUSE / RESD:");

    doTest("T4",
        ".... (Station 171) : 1  \n: 6 PLEASANT ST                                        Venue: Southamptn  \nLocated Between  : MAIN ST/CHURCH ST \n\nCall Time- 13:27:39                                : 1700 \n\n: (609) 859-2302                Caller : RICHARD E FRANTZMAN \n\nNature of Call : MVA//VEH HIT THE HOUSE \n\nAdditional Info",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:6 PLEASANT ST",
        "CITY:Southampton",
        "X:MAIN ST/CHURCH ST",
        "ID:1700",
        "PHONE:(609) 859-2302",
        "NAME:RICHARD E FRANTZMAN",
        "INFO:MVA//VEH HIT THE HOUSE");

    doTest("T5",
        ".... (Station 171) : 1  \n: 2 RIDGE RD                                           Venue: Southamptn  \nLocated Between  : RED LION RD/RT206  \n: VERIZON 17 \n\nCallTime- 01:28:31                                : 1712 \n\n: (800) 685-1608                Caller : VERIZON SEC  \nComplaintant: OP SHARON \n\nNature of Call : GENERAL FIRE ALARM/NO PHONE ON SITE",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:2 RIDGE RD",
        "CITY:Southampton",
        "X:RED LION RD/RT206",
        "PLACE:VERIZON 17",
        "NAME:VERIZON SEC",
        "INFO:GENERAL FIRE ALARM/NO PHONE ON SITE");

    doTest("T6",
        ".... (Station 171) : 1  \n: 19 FALCON DR                                         Venue: Southamptn  \nLocated Between  : NEW RD/ROBBINS WY \n\nCall Time- 12:33:33                                  : 1728 \n\n: (609) 859-0179                Caller : T R SUNDSTROM \n\nNature of Call : POSSIBLE FIRE/SMELL AND SEE SMOKE COMING FROM\n\nAdditional Info  \n  NEW RD AREA  \n  NW/AND INSIDE RES /TOT NJSP \n\nAdditional Inc#s",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:19 FALCON DR",
        "CITY:Southampton",
        "X:NEW RD/ROBBINS WY",
        "ID:1728",
        "PHONE:(609) 859-0179",
        "NAME:T R SUNDSTROM",
        "INFO:POSSIBLE FIRE/SMELL AND SEE SMOKE COMING FROM / NEW RD AREA NW/AND INSIDE RES /TOT NJSP");

    doTest("T7",
        ".... (Station 171) : 1  \n: 1771 RT206                                           Venue: Southamptn  \nLocated Between  : RT70/RIDGE RD  \n: EXXON 17 (RT206)\n\nCall Time- 07:12:50                              : 1712 \n\n: (609) 859-0060                Caller : E1782 \n\nNature of Call : 2 CAR MVA / \n\nAdditional Inc#s",
        "SRC:Station 171",
        "PRI:1",
        "ADDR:1771 RT206",
        "CITY:Southampton",
        "X:RT70/RIDGE RD",
        "PLACE:EXXON 17 (RT206)",
        "ID:1712",
        "PHONE:(609) 859-0060",
        "NAME:E1782",
        "INFO:2 CAR MVA /");
  }
  
  public static void main(String[] args) {
    new NJBurlingtonCountyParserTest().generateTests("T8");
  }
}