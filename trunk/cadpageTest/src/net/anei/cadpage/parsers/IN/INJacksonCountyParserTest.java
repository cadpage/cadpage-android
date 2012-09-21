package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INJacksonCountyParserTest extends BaseParserTest {
  
  public INJacksonCountyParserTest() {
    setParser(new INJacksonCountyParser(), "JACKSON COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(medical run) 1047 E CR 400 S Wegan Church 80 y/o/f unconscious",
        "CALL:Wegan Church 80 y / o / f unconscious",
        "ADDR:1047 E CR 400 S",
        "MADDR:1047 E COUNTY ROAD 400 S");

    doTest("T2",
        "(medical) 4904 W CR 440 N\n25yom Chest Pain",
        "CALL:25yom Chest Pain",
        "ADDR:4904 W CR 440 N",
        "MADDR:4904 W COUNTY ROAD 440 N");

    doTest("T3",
        "(Brownstown VFD) 10-50 Rollover 4062 N CR 225 W",
        "SRC:Brownstown VFD",
        "CALL:10-50 Rollover",
        "ADDR:4062 N CR 225 W",
        "MADDR:4062 N COUNTY ROAD 225 W");

    doTest("T4",
        "(medical) 383 S Circle Dr medical unresponsive male",
        "CALL:medical unresponsive male",
        "ADDR:383 S Circle Dr");

    doTest("T5",
        "(medical run) 1047 E CR 400 S Wegan Church 80 y/o/f unconscious",
        "CALL:Wegan Church 80 y / o / f unconscious",
        "ADDR:1047 E CR 400 S",
        "MADDR:1047 E COUNTY ROAD 400 S");
  }
  
  public static void main(String[] args) {
    new INJacksonCountyParserTest().generateTests("T1", "SRC CALL ADDR APT INFO");
  }
}