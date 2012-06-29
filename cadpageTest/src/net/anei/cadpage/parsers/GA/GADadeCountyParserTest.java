package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class GADadeCountyParserTest extends BaseParserTest {
  
  public GADadeCountyParserTest() {
    setParser(new GADadeCountyParser(), "DADE COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Brush, Grass, Field, Woods 220 HOOKER CEMETERY RD DEAD END / HWY 299 WILDWOOD     BRUSH FIRE ON BOTH SIDES\n" +
        "(Con't) 2 of 2\n" +
        "OF THE RAILRIAD TRACKS  06/26/12 20:35(End)",

        "CALL:Brush, Grass, Field, Woods",
        "ADDR:220 HOOKER CEMETERY RD",
        "X:DEAD END / HWY 299",
        "CITY:WILDWOOD",
        "INFO:BRUSH FIRE ON BOTH SIDES OF THE RAILRIAD TRACKS",
        "DATE:06/26/12",
        "TIME:20:35");

    doTest("T2",
        " 1 of 2\n" +
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Convulsions/Seizures 93 MARCH LN DEAD END / HARRIS RD SLYGO     12 YOM, HAVING A SEIZURE, HISTORY OF\n" +
        "(Con't) 2 of 2\n" +
        "SEIZURE, HAS NOT COME  06/28/12 00:47(End)",

        "CALL:Convulsions/Seizures",
        "ADDR:93 MARCH LN",
        "X:DEAD END / HARRIS RD",
        "PLACE:SLYGO",
        "CITY:TRENTON",
        "INFO:12 YOM, HAVING A SEIZURE, HISTORY OF SEIZURE, HAS NOT COME",
        "DATE:06/28/12",
        "TIME:00:47");

    doTest("T3",
        "FRM:E911@dadega.com\n" +
        "SUBJ:!\n" +
        "MSG:Fall 650 HWY 299 WILDWOOD    Pilot Travel Center #254 E911 Info - Class of Service: BUSN  06/29/12 08:32",

        "CALL:Fall",
        "ADDR:650 HWY 299",
        "CITY:WILDWOOD",
        "INFO:Pilot Travel Center #254 E911 Info - Class of Service: BUSN",
        "DATE:06/29/12",
        "TIME:08:32");

  }
  
  public static void main(String[] args) {
    new GADadeCountyParserTest().generateTests("T1", "CALL ADDR APT X PLACE CITY INFO DATE TIME");
  }
}