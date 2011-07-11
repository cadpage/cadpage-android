package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NJ.NJGloucesterCountyParser;

import org.junit.Test;


public class NJGloucesterCountyParserTest extends BaseParserTest {
  
  public NJGloucesterCountyParserTest() {
    setParser(new NJGloucesterCountyParser(), "GLOUCESTER COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Sta:23-1\nType:MVC\nLoc:233 N MAIN ST\nVen:HARRISON\nDsp-07:56:31\nClr-",
        "SRC:23-1",
        "CALL:MVC",
        "ADDR:233 N MAIN ST",
        "CITY:HARRISON TWP");

    doTest("T2",
        "Sta:23-1\nType:DWEL\nLoc:296 WESTBROOK DR\nVen:WOOLWICH\nDsp-08:16:44\nClr-", 
        "SRC:23-1",
        "CALL:DWEL",
        "ADDR:296 WESTBROOK DR",
        "CITY:WOOLWICH TWP");
    
    doTest("T3",
        "Sta:23-1\nType:ALRM\nLoc:7 FERRELL RD APT A\nVen:S\nDsp-14:55:22\nClr-", 
        "SRC:23-1",
        "CALL:ALRM",
        "ADDR:7 FERRELL RD APT A",
        "CITY:S HARRISON TWP");

    doTest("T4",
        "Sta:23-1\nType:BRSH\nLoc:54 VESTRY RD\nVen:S\nDsp-12:40:42\nClr-",
        "SRC:23-1",
        "CALL:BRSH",
        "ADDR:54 VESTRY RD",
        "CITY:S HARRISON TWP");
  }
}