package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TNJeffersonCountyParserTest extends BaseParserTest {
  
  public TNJeffersonCountyParserTest() {
    setParser(new TNJeffersonCountyParser(), "JEFFERSON COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "DISPATCH:1718 BROOKLINE CT JEFFERSON CITY 2011-611597 22:43:08  BREATHING DIFFICULTY",
        "ADDR:1718 BROOKLINE CT",
        "CITY:JEFFERSON CITY",
        "ID:2011-611597",
        "TIME:22:43:08",
        "CALL:BREATHING DIFFICULTY");

    doTest("T2",
        "DISPATCH:675 E BROADWAY BLVD JEFFERSON CITY 2011-613869 11:31:12 FIRE BRUSH  GRASS FOREST",
        "ADDR:675 E BROADWAY BLVD",
        "CITY:JEFFERSON CITY",
        "ID:2011-613869",
        "TIME:11:31:12",
        "INFO:FIRE BRUSH  GRASS FOREST");

    doTest("T3",
        "DISPATCH:1727 EASLEY RD JEFFERSON CITY 2011-613628 20:57:53 FIRE SMOKE INVESTIGATION",
        "ADDR:1727 EASLEY RD",
        "CITY:JEFFERSON CITY",
        "ID:2011-613628",
        "TIME:20:57:53",
        "INFO:FIRE SMOKE INVESTIGATION");

    doTest("T4",
        "DISPATCH:283 W BROADWAY BLVD 513 JEFFERSON CITY 08:00:21 CARDIAC ARREST CPR IN USE",
        "ADDR:283 W BROADWAY BLVD 513",
        "CITY:JEFFERSON CITY",
        "TIME:08:00:21",
        "INFO:CARDIAC ARREST CPR IN USE");
  
  }
  

  public static void main(String[] args) {
    new TNJeffersonCountyParserTest().generateTests("T1", "ADDR CITY PLACE CODE ID TIME CALL INFO");
  }
}
