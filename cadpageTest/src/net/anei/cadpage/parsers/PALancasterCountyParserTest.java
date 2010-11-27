package net.anei.cadpage.parsers;

import org.junit.Test;


public class PALancasterCountyParserTest extends BaseParserTest {
  
  public PALancasterCountyParserTest() {
    setParser(new PALancasterCountyParser(), "LANCASTER COUNTY", "PA");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(VEH ACCIDENT-STANDBY) MANHEIM TWP~LITITZ PIKE / PETERSBURG RD~~ENG271,SQ27~20:19:57^",
        "CALL:VEH ACCIDENT-STANDBY",
        "CITY:MANHEIM TWP",
        "ADDR:LITITZ PIKE & PETERSBURG RD",
        "UNIT:ENG271,SQ27");
    
    doTest("T2",
        "(VEH ACCIDENT-MASS TRANSIT-1A) MANHEIM TWP~2475 OREGON PIKE~WHITEMARSH DR~VALLEY RD~ENG271~08:13:50^",
        "CALL:VEH ACCIDENT-MASS TRANSIT-1A",
        "CITY:MANHEIM TWP",
        "ADDR:2475 OREGON PIKE",
        "X:WHITEMARSH DR & VALLEY RD",
        "UNIT:ENG271");
        
    doTest("T3",
        "(SPILL CONTROL) EAST DONEGAL TWP~1158 RIVER RD~N BANK ST~ANDERSON FERRY RD~HAZ291~11:55:37^",
        "CALL:SPILL CONTROL",
        "CITY:EAST DONEGAL TWP",
        "ADDR:1158 RIVER RD",
        "X:N BANK ST & ANDERSON FERRY RD",
        "UNIT:HAZ291");

    doTest("T4",
        "(AUTO ALARM-HIGH OCCUPANCY) MANHEIM TWP~115 BLUE STREAK BLVD~SCHOOL RD~VALLEY RD~ENG271,ENG272~15:12:34^",
        "CALL:AUTO ALARM-HIGH OCCUPANCY",
        "CITY:MANHEIM TWP",
        "ADDR:115 BLUE STREAK BLVD",
        "X:SCHOOL RD & VALLEY RD",
        "UNIT:ENG271,ENG272");

    doTest("T5",
        "(HAZ MAT INCIDENT-1A) LANC CITY~753 S PLUM ST~17 ALY~JUNIATA ST~HAZ291~08:19:13^",
        "CALL:HAZ MAT INCIDENT-1A",
        "CITY:LANCASTER",
        "ADDR:753 S PLUM ST",
        "X:17 ALY & JUNIATA ST",
        "UNIT:HAZ291");
  }
}