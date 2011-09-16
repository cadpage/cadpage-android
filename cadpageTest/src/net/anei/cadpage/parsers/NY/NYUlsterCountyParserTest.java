package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYUlsterCountyParser;

import org.junit.Test;


public class NYUlsterCountyParserTest extends BaseParserTest {
  
  public NYUlsterCountyParserTest() {
    setParser(new NYUlsterCountyParser(), "ULSTER COUNTY", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "UNIT:ENG6",
        "ADDR:487 WASHINGTON AV",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "INFO:GENERAL FIRE ALARM Addtl");

    doTest("T2",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "UNIT:ENG6",
        "ADDR:487 WASHINGTON AV",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "INFO:GENERAL FIRE ALARM Addtl");

    doTest("T3",
        "((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl",
        "UNIT:ENG6",
        "ADDR:86 HOFFMAN",
        "X:BROADWAY/MARYS  AV",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "INFO:SMOKE CODITION IN  AREA Addtl");

    doTest("T4",
        "((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt",
        "UNIT:ENG6",
        "ADDR:77 CORNELL",
        "X:TREMPER AV/SMITH AV",
        "CITY:KINGSTON",
        "CALL:Haz Mat",
        "INFO:UNKNOWN ODOR IN BUILDING  Addt");
        		

    doTest("T5",
        "((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE",
        "UNIT:ENG6",
        "ADDR:89 NEWKIRK AV",
        "X:HASBROUCK AV/MAPLE",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "INFO:BASEMENT FULL OF SMOKE");
    
  }
}
