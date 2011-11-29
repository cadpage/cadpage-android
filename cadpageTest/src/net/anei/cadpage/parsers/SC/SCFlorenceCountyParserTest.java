package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class SCFlorenceCountyParserTest extends BaseParserTest {
  
  public SCFlorenceCountyParserTest() {
    setParser(new SCFlorenceCountyParser(), "FLORENCE COUNTY", "SC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FLORENCE CO 911:21B2 >HEM/LACER-SERIOUS 2004 NEW HOPE DR XS: W MCARTHUR DR OFF MECHANICSVILLE RD FLORENCE BARR, ETHEL Map: Grids:0,0 Cad: 2011-0000105",
        "CODE:21B2",
        "CALL:HEM/LACER-SERIOUS",
        "ADDR:2004 NEW HOPE DR",
        "X:W MCARTHUR DR OFF MECHANICSVILLE RD",
        "CITY:FLORENCE",
        "NAME:BARR, ETHEL",
        "ID:2011-0000105");

    doTest("T2",
        "FLORENCE CO 911:32D1 >UNK PROBLEM-LIFE STAT QUESTION W MARION ST XS: N ALEXANDER FLORENCE DAWN WITHERSPOON Cad: 2011-0000103800",
        "CODE:32D1",
        "CALL:UNK PROBLEM-LIFE STAT QUESTION",
        "ADDR:W MARION ST",
        "MADDR:W MARION ST & N ALEXANDER",
        "X:N ALEXANDER",
        "CITY:FLORENCE",
        "NAME:DAWN WITHERSPOON",
        "ID:2011-0000103800");

    doTest("T3",
        "FLORENCE CO 911:FIRE >FIRE CALL 1912 ENTERPRISE DR XS: W LUCAS ST FLORENCE SEC CENT 7186 Map: Grids:0,0 Cad: 2011-0000104914",
        "CODE:FIRE",
        "CALL:FIRE CALL",
        "ADDR:1912 ENTERPRISE DR",
        "X:W LUCAS ST",
        "CITY:FLORENCE",
        "NAME:SEC CENT 7186",
        "ID:2011-0000104914");

    doTest("T4",
        "FLORENCE CO 911:52C1G >HGH LIFE HZD ALRM GEN 3006 HOFFMEYER RD XS: WINDSOR FOREST DR FLORENCE SIMPLEX Map: Grids:0,0 Cad: 2011-0000104810",
        "CODE:52C1G",
        "CALL:HGH LIFE HZD ALRM GEN",
        "ADDR:3006 HOFFMEYER RD",
        "X:WINDSOR FOREST DR",
        "CITY:FLORENCE",
        "NAME:SIMPLEX",
        "ID:2011-0000104810");

    doTest("T5",
        "FLORENCE CO 911:32D1 >UNK PROBLEM-LIFE STAT QUESTION 2438 WILLWOOD DR Apt: A Bldg XS: BENTREE LN OFF W PALMETTO ST FLORENCE RAMANDA Cad: 2011-00001032",
        "CODE:32D1",
        "CALL:UNK PROBLEM-LIFE STAT QUESTION",
        "ADDR:2438 WILLWOOD DR",
        "APT:A Bldg",
        "X:BENTREE LN OFF W PALMETTO ST",
        "CITY:FLORENCE",
        "NAME:RAMANDA",
        "ID:2011-00001032");
  }
  
  public static void main(String[] args) {
    new SCFlorenceCountyParserTest().generateTests("T1", "CODE CALL ADDR APT X CITY NAME BOX MAP ID");
  }
}