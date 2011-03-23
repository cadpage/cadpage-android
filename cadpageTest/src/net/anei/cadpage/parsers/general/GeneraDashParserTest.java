package net.anei.cadpage.parsers.general;

import net.anei.cadpage.TestManagePreferences;
import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.BeforeClass;
import org.junit.Test;


public class GeneraDashParserTest extends BaseParserTest {
  
  public GeneraDashParserTest() {
    setParser(new GeneralDashParser(), "", "");
  }
  
  @SuppressWarnings("static-access")
  @BeforeClass
  public static void classSetup() {
    TestManagePreferences pmgr = new TestManagePreferences();
    pmgr.setLocation("GeneralDash");
    pmgr.setOverrideFilter(true);
    pmgr.setFilter("1112223333");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "Chief ALT / [STA:7] -- Fire Alarm System -- 11 Kent Ave Pennsville Township NJ - Cross STS:North Broadway -- Caller: FRANKLIN ALARMS 633267",
        "SRC:7]",
        "CALL:Fire Alarm System",
        "ADDR:11 Kent Ave",
        "INFO:Pennsville Township NJ",
        "X:North Broadway",
        "NAME:FRANKLIN ALARMS 633267");
  }
}