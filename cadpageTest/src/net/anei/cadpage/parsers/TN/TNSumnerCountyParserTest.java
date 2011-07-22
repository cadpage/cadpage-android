package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNSumnerCountyParserTest extends BaseParserTest {
  
  public TNSumnerCountyParserTest() {
    setParser(new TNSumnerCountyParser(), "SUMNER COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "INITIAL.\nSC EMS COMMUNICATIONS:42 >NON-SPECIFIC DIAGNOSIS 521 SHUTE LN XS: SHORESIDE DR HENDERSONVILLE  MIKE 6158249869 Map: Grids:0,0",
        "ID:42",
        "CALL:NON-SPECIFIC DIAGNOSIS",
        "ADDR:521 SHUTE LN",
        "X:SHORESIDE DR",
        "CITY:HENDERSONVILLE",
        "NAME:MIKE",
        "PHONE:6158249869");

    doTest("T2",
        "INITIAL.\nSC EMS COMMUNICATIONS:50 >STROKE-CVA 114 MOONLIGHT DR HENDERSONVILLE AT&T MOBILITY 6153058788 Map: Grids:0,0",
        "ID:50",
        "CALL:STROKE-CVA",
        "ADDR:114 MOONLIGHT DR",
        "CITY:HENDERSONVILLE",
        "NAME:AT&T MOBILITY",
        "PHONE:6153058788");

    doTest("T3",
        "INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1109 LAKE RISE OVERLOOK HENDERSONVILLE L., JOHN 6158264086 Map: Grids:0,0",
        "ID:2",
        "CALL:FIRE ALARM",
        "ADDR:1109 LAKE RISE OVERLOOK",
        "CITY:HENDERSONVILLE",
        "NAME:L, JOHN",
        "PHONE:6158264086");

    doTest("T4",
        "INITIAL.\nSC EMS COMMUNICATIONS:43 >OTHER-FIRE 209 BROOKHAVEN DR GALLATIN W., MYRA 6154529951 Map: Grids:0,0",
        "ID:43",
        "CALL:OTHER-FIRE",
        "ADDR:209 BROOKHAVEN DR",
        "CITY:GALLATIN",
        "NAME:W, MYRA",
        "PHONE:6154529951");

    doTest("T5",
        "INITIAL.\nSC EMS COMMUNICATIONS:32 >HAZARDOUS MATERIALS 2079 MORGANS WAY GALLATIN Map: Grids:0,0",
        "ID:32",
        "CALL:HAZARDOUS MATERIALS",
        "ADDR:2079 MORGANS WAY",
        "CITY:GALLATIN");

    doTest("T6",
        "INITIAL.\nSC EMS COMMUNICATIONS:10 >BREATHING PROBLEMS A 1080 BRADLEY RD GALLATIN E., ROGER D 6154528905 Map: Grids:0,0",
        "ID:10",
        "CALL:BREATHING PROBLEMS A",
        "ADDR:1080 BRADLEY RD",
        "CITY:GALLATIN",
        "NAME:E, ROGER D",
        "PHONE:6154528905");

    doTest("T7",
        "INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1005 LAKE RISE PL HENDERSONVILLE HAY, BRUCE 6158262033 Map: Grids:0,0",
        "ID:2",
        "CALL:FIRE ALARM",
        "ADDR:1005 LAKE RISE PL",
        "CITY:HENDERSONVILLE",
        "NAME:HAY, BRUCE",
        "PHONE:6158262033");
  }
  
  public static void main(String[] args) {
    new TNSumnerCountyParserTest().generateTests("T1", "ID CALL ADDR X CITY NAME PHONE MAP");
  }
}
