package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYKingstonParserTest extends BaseParserTest {
  
  public NYKingstonParserTest() {
    setParser(new OHSugarCreekParser(), "Kingston", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "CALL:Autoalarm ",
        "X:TAYLOR & CITY LINE",
        "ADDR:487 WASHINGTON AV",
        "UNIT:ENG6"
        );

    /*
    ((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl

    ((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl

    ((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt

    ((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE ***/

    
  }
}
