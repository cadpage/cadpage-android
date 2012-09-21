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
        "MADDR:487 WASHINGTON AVE",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "DATE:11/05/2010",
        "TIME:20:44",
        "INFO:GENERAL FIRE ALARM Addtl");

    doTest("T2",
        "((2058) RLIN/ ) Unit:ENG6 UnitSts: Loc:487 WASHINGTON AV  XSts:TAYLOR/CITY LINE Venue:King City Inc:Autoalarm Date:11/05/2010  Time:20:44 GENERAL FIRE ALARM Addtl",
        "UNIT:ENG6",
        "ADDR:487 WASHINGTON AV",
        "MADDR:487 WASHINGTON AVE",
        "X:TAYLOR/CITY LINE",
        "CITY:KINGSTON",
        "CALL:Autoalarm",
        "DATE:11/05/2010",
        "TIME:20:44",
        "INFO:GENERAL FIRE ALARM Addtl");

    doTest("T3",
        "((63937) MDAV/ ) Unit:ENG6 UnitSts: Loc:86 HOFFMAN XSts:BROADWAY/MARYS  AV Venue:King City Inc:Struct Fir Date:11/03/2010 Time:21:22 SMOKE CODITION IN  AREA Addtl",
        "UNIT:ENG6",
        "ADDR:86 HOFFMAN",
        "X:BROADWAY/MARYS  AV",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:11/03/2010",
        "TIME:21:22",
        "INFO:SMOKE CODITION IN  AREA Addtl");

    doTest("T4",
        "((59728) SQUI/ )  Unit:ENG6 UnitSts: Loc:77 CORNELL XSts:TREMPER AV/SMITH AV Venue:King  City Inc:Haz Mat Date:11/02/2010 Time:00:45 UNKNOWN ODOR IN BUILDING  Addt",
        "UNIT:ENG6",
        "ADDR:77 CORNELL",
        "X:TREMPER AV/SMITH AV",
        "CITY:KINGSTON",
        "CALL:Haz Mat",
        "DATE:11/02/2010",
        "TIME:00:45",
        "INFO:UNKNOWN ODOR IN BUILDING  Addt");
        		

    doTest("T5",
        "((2203) BKIN/ ) Unit:ENG6 UnitSts: Loc:89 NEWKIRK AV XSts:HASBROUCK AV/MAPLE  Venue:King City Inc:Struct Fir Date:11/05/2010 Time:21:39 BASEMENT FULL OF SMOKE",
        "UNIT:ENG6",
        "ADDR:89 NEWKIRK AV",
        "MADDR:89 NEWKIRK AVE",
        "X:HASBROUCK AV/MAPLE",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:11/05/2010",
        "TIME:21:39",
        "INFO:BASEMENT FULL OF SMOKE");

    doTest("T6",
        "FRM:CAD@CO.ULSTER.NY.US\n" +
        "SUBJ:(16733) MGAF/\n" +
        "MSG:Unit:PG68-2 UnitSts: Loc:85 MAIN XSts:WALL/GREEN Venue:King City\n" +
        "Inc:Struct Fir\n" +
        "(Con't) 2 of 2\n" +
        "Date:01/31/2012 Time:14:32 BUILDING ON FIRE Addtl:CNTX:(End)",

        "UNIT:PG68-2",
        "ADDR:85 MAIN",
        "X:WALL/GREEN",
        "CITY:KINGSTON",
        "CALL:Struct Fir",
        "DATE:01/31/2012",
        "TIME:14:32",
        "INFO:BUILDING ON FIRE Addtl:CNTX:");
   
  }
  
  public static void main(String[] args) {
    new NYUlsterCountyParserTest().generateTests("T1", "UNIT ADDR X CITY CALL INFO");
  }
}
