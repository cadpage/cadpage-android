package net.anei.cadpage.parsers.KS;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class KSButlerCountyParserTest extends BaseParserTest {
  
  public KSButlerCountyParserTest() {
    setParser(new KSButlerCountyParser(), "BUTLER COUNTY", "KS");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Incident Notification) 10D CHEST PAIN (ADDRESS): 300 N MAIN ST El Dorado (MAP PAGE): 22C (CROSS ST): E 2ND AVE, W 2ND AVE / E 3RD AVE, W 3RD AVE (NARR):  ProQA Me",
        "CALL:10D CHEST PAIN",
        "ADDR:300 N MAIN ST",
        "CITY:El Dorado",
        "MAP:22C",
        "X:E 2ND AVE, W 2ND AVE / E 3RD AVE, W 3RD AVE",
        "INFO:ProQA Me");
 }
  
  public static void main(String[] args) {
    new KSButlerCountyParserTest().generateTests("T7");
  }
}
