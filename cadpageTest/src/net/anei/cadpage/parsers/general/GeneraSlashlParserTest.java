package net.anei.cadpage.parsers.general;

import net.anei.cadpage.TestManagePreferences;
import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.general.GeneralSlashParser;

import org.junit.BeforeClass;
import org.junit.Test;


public class GeneraSlashlParserTest extends BaseParserTest {
  
  public GeneraSlashlParserTest() {
    setParser(new GeneralSlashParser(), "", "");
  }
  
  @SuppressWarnings("static-access")
  @BeforeClass
  public static void classSetup() {
    TestManagePreferences pmgr = new TestManagePreferences();
    pmgr.setLocation("GeneralSlash");
    pmgr.setOverrideDefault(true);
    pmgr.setFilter("1112223333");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(- part 1 of 1) RC:Run# 4581/General Transport/STUBBS/ JAMES/1718 S I  ST//ER-10//TACOMA/773 G6/11315 BRIDGEPORT WAY SW",
        "ID:4581",
        "CALL:JAMES",
        "ADDR:1718 S I ST",
        "INFO:ER-10 | TACOMA | 773 G6",
        "X:11315 BRIDGEPORT WAY SW");
  }
}