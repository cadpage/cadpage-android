package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSomersetCountyBParserTest extends BaseParserTest {
  
  public NJSomersetCountyBParserTest() {
    setParser(new NJSomersetCountyBParser(), "SOMERSET COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[CAD]  [CAD] EFD-FD:11051201:05/12/2011 15:44:57:FIRE ALARM: FRANKLI-CARING HOUSE PROJECTS / 18 BLOOMFIELD AVE",
        "SRC:EFD-FD",
        "ID:11051201",
        "DATE:05/12/2011",
        "TIME:15:44:57",
        "CALL:FIRE ALARM",
        "CITY:FRANKLIN TWP",
        "PLACE:CARING HOUSE PROJECTS",
        "ADDR:18 BLOOMFIELD AVE");

  }
  
  
  public static void main(String[] args) {
    new NJSomersetCountyBParserTest().generateTests("T1");
  }
}