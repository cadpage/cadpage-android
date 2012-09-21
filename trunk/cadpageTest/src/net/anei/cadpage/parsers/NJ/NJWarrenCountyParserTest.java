package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;


import org.junit.Test;
/*
Warren County, NJ
Contact: David F <spankerdave69@gmail.com>
Sender: WC911@co.warren.nj.us

E94 ALERT: UNCONSC 41 YOF 1623 WARREN ST ALPHA BORO (SENT 09/16 19:29)\nCross Streets -  6th Ave & 7th Ave\nAlpha Boro
E94 ALERT: WEAKNESS 56 YOF 108 ARROWHEAD CT / SOUTH GATE APT 7D PHILLIPSBURG TOWN (SENT 09/17 06:57)\nCross Streets- Lock St\nTown of Phillipsburg
E94 ALERT: ABDOM PN 79 YOF 408 SAINT JAMES AVE POHATCONG TWP (SENT 09/17 10:22)\nCross Streets- Liggett Blvd & Pershing Ave\nPohatcong Twsp
E94 ALERT: ABDOM PN 68 YOF 719 SAMPSON AVE ALPHA BORO (SENT 09/17 14:42)\nCross St- Pearl St\nAlpha Boro
E94 ALERT: BLEEDING 6-7 YOM BARBER SCHOOL / 50 SARGENT AVE / 525 SARGENT AVE PHILLIPSBURG TOWN (SENT 09/17 11:25)\nCross Streets- Corliss Ave & Grave Ave\nTown of Phillipsburg

*/

public class NJWarrenCountyParserTest extends BaseParserTest {
  
  public NJWarrenCountyParserTest() {
    setParser(new NJWarrenCountyParser(), "WARREN COUNTY", "NJ");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "E94 ALERT: UNCONSC 41 YOF 1623 WARREN ST ALPHA BORO (SENT 09/16 19:29)\nCross Streets -  6th Ave & 7th Ave\nAlpha Boro",
        "UNIT:E94",
        "CALL:UNCONSC 41 YOF",
        "ADDR:1623 WARREN ST",
        "CITY:ALPHA",
        "DATE:09/16",
        "TIME:19:29");

    doTest("T2",
        "E94 ALERT: WEAKNESS 56 YOF 108 ARROWHEAD CT / SOUTH GATE APT 7D PHILLIPSBURG TOWN (SENT 09/17 06:57)\n" +
        "Cross Streets- Lock St\n" +
        "Town of Phillipsburg",

        "UNIT:E94",
        "CALL:WEAKNESS 56 YOF",
        "ADDR:108 ARROWHEAD CT & SOUTH GATE",
        "MADDR:108 ARROWHEAD CT",
        "APT:7D",
        "CITY:PHILLIPSBURG",
        "DATE:09/17",
        "TIME:06:57",
        "X:Lock St");

    doTest("T3",
        "E94 ALERT: ABDOM PN 79 YOF 408 SAINT JAMES AVE POHATCONG TWP (SENT 09/17 10:22)\n" +
        "Cross Streets- Liggett Blvd & Pershing Ave\n" +
        "Pohatcong Twsp",

        "UNIT:E94",
        "CALL:ABDOM PN 79 YOF",
        "ADDR:408 SAINT JAMES AVE",
        "CITY:POHATCONG TWP",
        "DATE:09/17",
        "TIME:10:22",
        "X:Liggett Blvd & Pershing Ave");

    doTest("T4",
        "E94 ALERT: ABDOM PN 68 YOF 719 SAMPSON AVE ALPHA BORO (SENT 09/17 14:42)\nCross St- Pearl St\nAlpha Boro",
        "UNIT:E94",
        "CALL:ABDOM PN 68 YOF",
        "ADDR:719 SAMPSON AVE",
        "CITY:ALPHA",
        "DATE:09/17",
        "TIME:14:42");

    doTest("T5",
        "E94 ALERT: BLEEDING 6-7 YOM BARBER SCHOOL / 50 SARGENT AVE / 525 SARGENT AVE PHILLIPSBURG TOWN (SENT 09/17 11:25)\n" +
        "Cross Streets- Corliss Ave & Grave Ave\n" +
        "Town of Phillipsburg",

        "UNIT:E94",
        "CALL:BLEEDING 6-7 YOM BARBER SCHOOL /",
        "ADDR:50 SARGENT AVE & 525 SARGENT AVE",
        "MADDR:50 SARGENT AVE",
        "CITY:PHILLIPSBURG",
        "DATE:09/17",
        "TIME:11:25",
        "X:Corliss Ave & Grave Ave");

  }
    
  public static void main(String[] args) {
    new NJWarrenCountyParserTest().generateTests("T1", "UNIT CALL ADDR APT CITY DATE TIME X");
  }
}