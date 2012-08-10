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
        "CALL:FIRE BRUSH  GRASS FOREST");

    doTest("T3",
        "DISPATCH:1727 EASLEY RD JEFFERSON CITY 2011-613628 20:57:53 FIRE SMOKE INVESTIGATION",
        "ADDR:1727 EASLEY RD",
        "CITY:JEFFERSON CITY",
        "ID:2011-613628",
        "TIME:20:57:53",
        "CALL:FIRE SMOKE INVESTIGATION");

    doTest("T4",
        "DISPATCH:283 W BROADWAY BLVD 513 JEFFERSON CITY 08:00:21 CARDIAC ARREST CPR IN USE",
        "ADDR:283 W BROADWAY BLVD 513",
        "CITY:JEFFERSON CITY",
        "TIME:08:00:21",
        "CALL:CARDIAC ARREST CPR IN USE");
  
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:542 COUNTY LINE RD DANDRIDGE 10:47:55 SICK PERSON (SPECIFIC DIAGNOSIS)\r\n",
        "ADDR:542 COUNTY LINE RD",
        "CITY:DANDRIDGE",
        "TIME:10:47:55",
        "CALL:SICK PERSON",
        "INFO:(SPECIFIC DIAGNOSIS)");

    doTest("T2",
        "FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:4800 TIMBER WAY SEVIERVILLE 20:28:20 CHEST PAIN HEART PROBLEMS\r\n",
        "ADDR:4800 TIMBER WAY",
        "CITY:SEVIERVILLE",
        "TIME:20:28:20",
        "CALL:CHEST PAIN HEART PROBLEMS");

    doTest("T3",
        "FRM:DISPATCH@jeffersoncountytn.gov\r\nMSG:DISPATCH:542 COUNTY LINE RD DANDRIDGE 10:01:21 STROKE (CVA)\r\n",
        "ADDR:542 COUNTY LINE RD",
        "CITY:DANDRIDGE",
        "TIME:10:01:21",
        "CALL:STROKE",
        "INFO:(CVA)");
   
  }
  

  public static void main(String[] args) {
    new TNJeffersonCountyParserTest().generateTests("T1", "ADDR CITY PLACE CODE ID TIME CALL INFO");
  }
}
