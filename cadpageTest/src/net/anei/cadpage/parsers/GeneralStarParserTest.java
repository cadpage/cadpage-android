package net.anei.cadpage.parsers;

import net.anei.cadpage.TestManagePreferences;

import org.junit.BeforeClass;
import org.junit.Test;


public class GeneralStarParserTest extends BaseParserTest {
  
  public GeneralStarParserTest() {
    setParser(new GeneralStarParser(), "", "");
  }
  
  @BeforeClass
  public static void classSetup() {
    TestManagePreferences pmgr = new TestManagePreferences();
    pmgr.setOverrideDefault(true);
    pmgr.setFilter("1112223333");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "2010-189098*1211 PECAN ST***CONOVER**OVERDOSE*********",
        "CALL:2010-189098",
        "ADDR:1211 PECAN ST",
        "INFO:CONOVER OVERDOSE");
        
  }
}