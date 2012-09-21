package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class WVMineralCountyParserTest extends BaseParserTest {
  
  public WVMineralCountyParserTest() {
    setParser(new WVMineralCountyParser(), "MINERAL COUNTY", "WV");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M: ??? PFD:2012:0140 >2012-06-17 21:14:30 >ALERTED >ODOR UNKNOWN >47 WEST HAMPSHIRE ST, PIEDMONT",
        "SRC:PFD",
        "ID:2012:0140",
        "DATE:06/17/2012",
        "TIME:21:14:30",
        "CALL:ODOR UNKNOWN",
        "ADDR:47 WEST HAMPSHIRE ST",
        "CITY:PIEDMONT");

    doTest("T2",
        "S: M: ??? PFD:2012:0143 >2012-06-24 12:47:25 >ALERTED >CARBON MONOXIDE/ETC-8 >49 1/2 THIRD STREET",
        "SRC:PFD",
        "ID:2012:0143",
        "DATE:06/24/2012",
        "TIME:12:47:25",
        "CALL:CARBON MONOXIDE/ETC-8",
        "ADDR:49 1/2 THIRD STREET");

    doTest("T3",
        "S: M: ??? PFD:2012:0142 >2012-06-23 11:27:29 >ALERTED >TREE DOWN >119 RIORDIN RD WESTERNPORT",
        "SRC:PFD",
        "ID:2012:0142",
        "DATE:06/23/2012",
        "TIME:11:27:29",
        "CALL:TREE DOWN",
        "ADDR:119 RIORDIN RD",
        "CITY:WESTERNPORT",
        "ST:MD");

    doTest("T4",
        "S: M: ??? PFD:2012:0144 >2012-06-25 18:45:52 >ALERTED >MVA W/INJURIES >RT 46, BETWEEN KEYSER& PIEDMONT",
        "SRC:PFD",
        "ID:2012:0144",
        "DATE:06/25/2012",
        "TIME:18:45:52",
        "CALL:MVA W/INJURIES",
        "ADDR:RT 46",
        "MADDR:RT 46 & KEYSER",
        "X:KEYSER& PIEDMONT");

    doTest("T5",
        "S: M: ??? PFD:2012:0145 >2012-06-28 18:43:10 >ALERTED >STAND BY >CO 20 STATION",
        "SRC:PFD",
        "ID:2012:0145",
        "DATE:06/28/2012",
        "TIME:18:43:10",
        "CALL:STAND BY",
        "ADDR:CO 20 STATION",
        "MADDR:COUNTY ROAD 20 STATION");

    doTest("T6",
        "S: M: ??? PFD:2012:0155 >2012-07-01 11:46:49 >ALERTED >TREE DOWN >322 GREEN ST WESTERNPORT",
        "SRC:PFD",
        "ID:2012:0155",
        "DATE:07/01/2012",
        "TIME:11:46:49",
        "CALL:TREE DOWN",
        "ADDR:322 GREEN ST",
        "CITY:WESTERNPORT",
        "ST:MD");

    doTest("T7",
        "S: M: ??? PFD:2012:0154 >2012-07-01 10:46:31 >ALERTED >FIRE GARAGE >OFF OF PLUM RUN RD TO ROGERS DRIVE; 1641 RIDGELEY, RIDGELEY, MNRL WV",
        "SRC:PFD",
        "ID:2012:0154",
        "DATE:07/01/2012",
        "TIME:10:46:31",
        "CALL:FIRE GARAGE",
        "INFO:OFF OF PLUM RUN RD TO ROGERS DRIVE",
        "ADDR:1641 RIDGELEY",  // Not mapping
        "CITY:RIDGELEY");

    doTest("T8",
        "S: M: ??? PFD:2012:0153 >2012-07-01 10:34:47 >ALERTED >UNCONSC/FAINT-31 >57 ERIN ST, PIEDMONT (;)",
        "SRC:PFD",
        "ID:2012:0153",
        "DATE:07/01/2012",
        "TIME:10:34:47",
        "CALL:UNCONSC/FAINT-31",
        "ADDR:57 ERIN ST",
        "CITY:PIEDMONT");

  }
  
  public static void main(String[] args) {
    new WVMineralCountyParserTest().generateTests("T1");
  }
}