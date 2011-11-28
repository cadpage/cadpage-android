package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYChenangoCountyParserTest extends BaseParserTest {
  
  public NYChenangoCountyParserTest() {
    setParser(new NYChenangoCountyParser(), "CHENANGO COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[911 EVENT]  BREATHING PROBLEMS|XTRA MART- GREENE|94 GENESEE ST  STA GREENE XS STATE HWY 12 /BIRDSALL ST|NARR PROQA DETAIL:DELTA 06D02 ABD PAIN| YOU ARE RESPON",
        "CALL:BREATHING PROBLEMS",
        "PLACE:XTRA MART- GREENE",
        "ADDR:94 GENESEE ST",
        "SRC:GREENE",
        "X:STATE HWY 12 /BIRDSALL ST",
        "INFO:YOU ARE RESPON");

    doTest("T2",
        "[911 EVENT]  STANDBY|GREENE HIGH SCHOOL|40 S CANAL ST  STA GREENE XS PAGE ST/S CHENANGO ST EXT",
        "CALL:STANDBY",
        "PLACE:GREENE HIGH SCHOOL",
        "ADDR:40 S CANAL ST",
        "SRC:GREENE",
        "X:PAGE ST/S CHENANGO ST EXT");

    doTest("T3",
        "[911 EVENT]  CHEST PAIN|GREENE FAMILY MEDICINE|29 N CHENANGO ST  STA GREENE XS SCOTT  AV/ELM ST|NARR PROQA DETAIL:CHARLIE 10C04 CHEST PAIN| YOU ARE RESPONDING",
        "CALL:CHEST PAIN",
        "PLACE:GREENE FAMILY MEDICINE",
        "ADDR:29 N CHENANGO ST",
        "SRC:GREENE",
        "X:SCOTT  AV/ELM ST",
        "INFO:YOU ARE RESPONDING");

    doTest("T4",
        "[911 EVENT]  HEMORRHAGE / LACERATION|NYS VETS HOME|4207 STATE HWY 220   STA OXFORD XS COUNTY RD 35 /COUNTY RD 32|NARR SPRUCE COTTAGE - 68YOM - NOSE BLEED - 21-",
        "CALL:HEMORRHAGE / LACERATION",
        "PLACE:NYS VETS HOME",
        "ADDR:4207 STATE HWY 220",
        "MADDR:4207 STATE 220",
        "SRC:OXFORD",
        "X:COUNTY RD 35 /COUNTY RD 32");

    doTest("T5",
        "[911 EVENT]  STRUCTURE FIRE/RESIDENTIAL||103 CURTIS COURT   STA SMITHVILLE XS ROUND POND  RD/***DEAD END***|NARR PERSON: (COMPLAINANT) (FMLS) VICKY CURTIS  NO",
        "CALL:STRUCTURE FIRE/RESIDENTIAL",
        "ADDR:103 CURTIS COURT",
        "SRC:SMITHVILLE",
        "X:ROUND POND  RD/***DEAD END***");
    
  }
  
  public static void main(String[] args) {
    new NYChenangoCountyParserTest().generateTests("T1");
  }
}