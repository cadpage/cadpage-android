package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYNassauCountyMassepequaParserTest extends BaseParserTest {
  
  public NYNassauCountyMassepequaParserTest() {
    setParser(new NYNassauCountyMassepequaParser(), "NASSAU COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Rescue: 100 VETERANS BLVD, Town: MASS, Cross: HICKSVILLE RD, Map: C-5, Block#: 160-NORTH, Time: 10:07:10",
        "CALL:Rescue",
        "ADDR:100 VETERANS BLVD",
        "CITY:MASSEPEQUA",
        "X:HICKSVILLE RD",
        "MAP:C-5",
        "INFO:160-NORTH");

    doTest("T2",
        "Washdown/spill: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:30:27",
        "CALL:Washdown/spill",
        "ADDR:21 LARCH LN",
        "CITY:MASSEPEQUA PARK",
        "X:WHITEWOOD DR",
        "MAP:E-8",
        "INFO:878-WEST");

    doTest("T3",
        "Vehicle Accident: 21 LARCH LN, Town: MPK, Cross: WHITEWOOD DR, Map: E-8, Block#: 878-WEST, Time: 09:28:13",
        "CALL:Vehicle Accident",
        "ADDR:21 LARCH LN",
        "CITY:MASSEPEQUA PARK",
        "X:WHITEWOOD DR",
        "MAP:E-8",
        "INFO:878-WEST");

    doTest("T4",
        "Automatic Alarm: 5500 SUNRISE HWY, Town: MASS, Cross: UNQUA RD, Map: G-5, Block#: 487 SOUTH, Time: 04:19:08",
        "CALL:Automatic Alarm",
        "ADDR:5500 SUNRISE HWY",
        "CITY:MASSEPEQUA",
        "X:UNQUA RD",
        "MAP:G-5",
        "INFO:487 SOUTH");

    doTest("T5",
        "Rescue: 217 EASTLAKE AVE, Town: MPK, Cross: MASSACHUSETTS AVE, Map: F-4, Block#: 262-EAST, Time: 03:35:56",
        "CALL:Rescue",
        "ADDR:217 EASTLAKE AVE",
        "CITY:MASSEPEQUA PARK",
        "X:MASSACHUSETTS AVE",
        "MAP:F-4",
        "INFO:262-EAST");

    doTest("T6",
        "Rescue: 66 HARBOR LN, Town: MPK, Cross: NASSAU ST, Map: D-8, Block#: 820-WEST, Time: 15:31:32",
        "CALL:Rescue",
        "ADDR:66 HARBOR LN",
        "CITY:MASSEPEQUA PARK",
        "X:NASSAU ST",
        "MAP:D-8",
        "INFO:820-WEST");

  }
  
  public static void main(String[] args) {
    new NYNassauCountyMassepequaParserTest().generateTests("T1");
  }
}