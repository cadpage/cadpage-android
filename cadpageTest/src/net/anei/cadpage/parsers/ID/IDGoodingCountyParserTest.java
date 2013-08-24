package net.anei.cadpage.parsers.ID;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.ID.IDGoodingCountyParserTest;

import org.junit.Test;

/*
Gooding County, ID
Contact: Christopher Bailey <wvfd9240@yahoo.com>
Sender: PagingService@sircomm.com

 SIRCOMM / 1:34 PM\nNEW EVENT WND092\nFIRE\nFIRE ALL OTHER OR UN\n2000 E 3100 SOUTH\nWND AREA\n
 SIRCOMM / 1:55 AM\nNEW EVENT WND092\nACCU\nACCIDENT W/UNKNOWN I\n2285 E 3300 SOUTH\nWND AREA\n
 SIRCOMM / 9:59 PM\nNEW EVENT WND092\nFIREI\nFIRE INVESTIGATION\n1511 E 3600 SOUTH\nWND AREA\n
 SIRCOMM / 12:39 PM\nNEW EVENT WND092\n911\n911 DROP OFF/OPEN LI\n2175 E 3600 SOUTH\nWND AREA\n
 SIRCOMM / 7:39 AM\nNEW EVENT WND092\nFIREV\nVEHICLE FIRE\n3232 S 1800 EAST\nWND AREA\n
 SIRCOMM / 8:58 AM\nNEW EVENT WND092\nUT\nUTILITY PROBLEMS\n336 3RD AVE E\nWENDELL\n
 SIRCOMM / 7:33 AM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n1425 E 2700 SOUTH\nWND AREA\n
 SIRCOMM / 9:14 PM\nNEW EVENT WND092\nFIREI\nFIRE INVESTIGATION\n1800 E 2800 SOUTH\nWND AREA\n
 SIRCOMM / 8:28 PM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n2132 NIAGRA SPRINGS GR\nWND AREA\n
 SIRCOMM / 8:52 AM\nNEW EVENT WND092\nUT\nUTILITY PROBLEMS\n145 N HAGERMAN ST\nWENDELL\n
 SIRCOMM / 3:15 PM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n314 QUAIL RUN LN\n
 
Contact: dwayne woodbridge <wendellfire9219@gmail.com>
Sender: PagingService@sircomm.com
(SIRCOMM) 7:45 PM\r\nNEW EVENT GDG099\r\nMED\r\nMEDICAL CALL\r\n521 UTAH ST\r\nGOODING [Attachment(s) removed]
(SIRCOMM) 7:49 AM\r\nNEW EVENT GDG099\r\nACCI\r\nACCIDENT W/INJURIES\r\n2200 E 3000 SOUTH\r\nWND AREA [Attachment(s) removed]

*/

public class IDGoodingCountyParserTest extends BaseParserTest {
  
  public IDGoodingCountyParserTest() {
    setParser(new IDGoodingCountyParser(), "GOODING COUNTY", "ID");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        " SIRCOMM / 1:34 PM\nNEW EVENT WND092\nFIRE\nFIRE ALL OTHER OR UN\n2000 E 3100 SOUTH\nWND AREA\n",
        "TIME:13:34:00",
        "SRC:WND092",
        "CALL:FIRE ALL OTHER OR UN",
        "ADDR:2000 E 3100 SOUTH",
        "CITY:WENDELL");

    doTest("T2",
        " SIRCOMM / 1:55 AM\nNEW EVENT WND092\nACCU\nACCIDENT W/UNKNOWN I\n2285 E 3300 SOUTH\nWND AREA\n",
        "TIME:01:55:00",
        "SRC:WND092",
        "CALL:ACCIDENT W/UNKNOWN I",
        "ADDR:2285 E 3300 SOUTH",
        "CITY:WENDELL");

    doTest("T3",
        " SIRCOMM / 9:59 PM\nNEW EVENT WND092\nFIREI\nFIRE INVESTIGATION\n1511 E 3600 SOUTH\nWND AREA\n",
        "TIME:21:59:00",
        "SRC:WND092",
        "CALL:FIRE INVESTIGATION",
        "ADDR:1511 E 3600 SOUTH",
        "CITY:WENDELL");

    doTest("T4",
        " SIRCOMM / 12:39 PM\nNEW EVENT WND092\n911\n911 DROP OFF/OPEN LI\n2175 E 3600 SOUTH\nWND AREA\n",
        "TIME:12:39:00",
        "SRC:WND092",
        "CALL:911 DROP OFF/OPEN LI",
        "ADDR:2175 E 3600 SOUTH",
        "CITY:WENDELL");

    doTest("T5",
        " SIRCOMM / 7:39 AM\nNEW EVENT WND092\nFIREV\nVEHICLE FIRE\n3232 S 1800 EAST\nWND AREA\n",
        "TIME:07:39:00",
        "SRC:WND092",
        "CALL:VEHICLE FIRE",
        "ADDR:3232 S 1800 EAST",
        "CITY:WENDELL");

    doTest("T6",
        " SIRCOMM / 8:58 AM\nNEW EVENT WND092\nUT\nUTILITY PROBLEMS\n336 3RD AVE E\nWENDELL\n",
        "TIME:08:58:00",
        "SRC:WND092",
        "CALL:UTILITY PROBLEMS",
        "ADDR:336 3RD AVE E",
        "CITY:WENDELL");

    doTest("T7",
        " SIRCOMM / 7:33 AM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n1425 E 2700 SOUTH\nWND AREA\n",
        "TIME:07:33:00",
        "SRC:WND092",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:1425 E 2700 SOUTH",
        "CITY:WENDELL");

    doTest("T8",
        " SIRCOMM / 9:14 PM\nNEW EVENT WND092\nFIREI\nFIRE INVESTIGATION\n1800 E 2800 SOUTH\nWND AREA\n",
        "TIME:21:14:00",
        "SRC:WND092",
        "CALL:FIRE INVESTIGATION",
        "ADDR:1800 E 2800 SOUTH",
        "CITY:WENDELL");

    doTest("T9",
        " SIRCOMM / 8:28 PM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n2132 NIAGRA SPRINGS GR\nWND AREA\n",
        "TIME:20:28:00",
        "SRC:WND092",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:2132 NIAGRA SPRINGS GR",  // Should be NIAGRA SPRINTS RD
        "MADDR:2132 NIAGRA SPRINGS GRADE",
        "CITY:WENDELL");

    doTest("T10",
        " SIRCOMM / 8:52 AM\nNEW EVENT WND092\nUT\nUTILITY PROBLEMS\n145 N HAGERMAN ST\nWENDELL\n",
        "TIME:08:52:00",
        "SRC:WND092",
        "CALL:UTILITY PROBLEMS",
        "ADDR:145 N HAGERMAN ST",
        "CITY:WENDELL");

    doTest("T11",
        " SIRCOMM / 3:15 PM\nNEW EVENT WND092\nFIREB\nBRUSH/GRASS FIRE\n314 QUAIL RUN LN\n",
        "TIME:15:15:00",
        "SRC:WND092",
        "CALL:BRUSH/GRASS FIRE",
        "ADDR:314 QUAIL RUN LN");
 }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "(SIRCOMM) 7:45 PM\r\nNEW EVENT GDG099\r\nMED\r\nMEDICAL CALL\r\n521 UTAH ST\r\nGOODING [Attachment(s) removed]",
        "TIME:19:45:00",
        "SRC:GDG099",
        "CALL:MEDICAL CALL",
        "ADDR:521 UTAH ST",
        "CITY:GOODING");

    doTest("T2",
        "(SIRCOMM) 7:49 AM\r\nNEW EVENT GDG099\r\nACCI\r\nACCIDENT W/INJURIES\r\n2200 E 3000 SOUTH\r\nWND AREA [Attachment(s) removed]",
        "TIME:07:49:00",
        "SRC:GDG099",
        "CALL:ACCIDENT W/INJURIES",
        "ADDR:2200 E 3000 SOUTH",
        "CITY:WENDELL");

  }
  
  public static void main(String[] args) {
    new IDGoodingCountyParserTest().generateTests("T1");
  }
}