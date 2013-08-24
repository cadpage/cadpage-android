package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Franklin County, VA
Contact: Ricky Grizzard <rickygrizzard@gmail.com>
Sender: 777

CITY OF FRANKLIN dledbetter:32417 RIVERDALE DR FRANKLIN 00:09:03 RESCUE EMS- AP ELDERLY FEMALE CHEST PAINS,NOT RESPONDING,NURSE ON DUTY AT RESIDENCE
CITY OF FRANKLIN mhturner:16 CRESCENT DR FRANKLIN N HIGH ST X MCCUTCHEON ST 14:40:37 RESCUE EMS- AP MEDICAL ALARM
CITY OF FRANKLIN ajustus:1401 N HIGH ST Rm 1007 FRANKLIN OAKWOOD DR X CITY LIMITS 05:40:29 RESCUE EMS- AP elderly female severe nose bleed
CITY OF FRANKLIN mhturner:117 BEECHWOOD DR FRANKLIN OAKWOOD DR X N HIGH ST 18:02:51 RESCUE EMS- AP 74 YO FEMALE - POSSIBLE STROKE

*/

public class VAFranklinParserTest extends BaseParserTest {
  
  public VAFranklinParserTest() {
    setParser(new VAFranklinParser(), "FRANKLIN", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CITY OF FRANKLIN dledbetter:32417 RIVERDALE DR FRANKLIN 00:09:03 RESCUE EMS- AP ELDERLY FEMALE CHEST PAINS,NOT RESPONDING,NURSE ON DUTY AT RESIDENCE",
        "ADDR:32417 RIVERDALE DR",
        "CITY:FRANKLIN",
        "TIME:00:09:03",
        "CALL:RESCUE EMS- AP",
        "INFO:ELDERLY FEMALE CHEST PAINS,NOT RESPONDING,NURSE ON DUTY AT RESIDENCE");

    doTest("T2",
        "CITY OF FRANKLIN mhturner:16 CRESCENT DR FRANKLIN N HIGH ST X MCCUTCHEON ST 14:40:37 RESCUE EMS- AP MEDICAL ALARM",
        "ADDR:16 CRESCENT DR",
        "CITY:FRANKLIN",
        "X:N HIGH ST / MCCUTCHEON ST",
        "TIME:14:40:37",
        "CALL:RESCUE EMS- AP MEDICAL ALARM");

    doTest("T3",
        "CITY OF FRANKLIN ajustus:1401 N HIGH ST Rm 1007 FRANKLIN OAKWOOD DR X CITY LIMITS 05:40:29 RESCUE EMS- AP elderly female severe nose bleed",
        "ADDR:1401 N HIGH ST",
        "APT:1007",
        "CITY:FRANKLIN",
        "X:OAKWOOD DR / CITY LIMITS",
        "TIME:05:40:29",
        "CALL:RESCUE EMS- AP",
        "INFO:elderly female severe nose bleed");

    doTest("T4",
        "CITY OF FRANKLIN mhturner:117 BEECHWOOD DR FRANKLIN OAKWOOD DR X N HIGH ST 18:02:51 RESCUE EMS- AP 74 YO FEMALE - POSSIBLE STROKE",
        "ADDR:117 BEECHWOOD DR",
        "CITY:FRANKLIN",
        "X:OAKWOOD DR / N HIGH ST",
        "TIME:18:02:51",
        "CALL:RESCUE EMS- AP",
        "INFO:74 YO FEMALE - POSSIBLE STROKE");

  }
  
  public static void main(String[] args) {
    new VAFranklinParserTest().generateTests("T1");
  }
}
