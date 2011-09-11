package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCSurryCountyParserTest extends BaseParserTest {
  
  public NCSurryCountyParserTest() {
    setParser(new NCSurryCountyParser(), "SURRY COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110425-043* Address - 105 DUTCH LN* City - MOUNT AIRY* Call Type - CARDIAC D* *﻿",
        "ID:110425-043",
        "ADDR:105 DUTCH LN",
        "CITY:MOUNT AIRY",
        "CALL:CARDIAC D");

    doTest("T2",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110424-196* Address - 1642 S MAIN ST* City - MOUNT AIRY* Call Type - RESP DIS D* *﻿",
        "ID:110424-196",
        "ADDR:1642 S MAIN ST",
        "CITY:MOUNT AIRY",
        "CALL:RESP DIS D");

    doTest("T3",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110424-100* Address - 120 W PINE ST* City - MOUNT AIRY* Call Type - UNRESPONSIVE* *﻿",
        "ID:110424-100",
        "ADDR:120 W PINE ST",
        "CITY:MOUNT AIRY",
        "CALL:UNRESPONSIVE");

    doTest("T4",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110420-120* Address - 70 MAYBERRY MALL RD* City - MOUNT AIRY* Call Type - FALL* *﻿",
        "ID:110420-120",
        "ADDR:70 MAYBERRY MALL RD",
        "CITY:MOUNT AIRY",
        "CALL:FALL");

    doTest("T5",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110419-061* Address - 908 REEVES DR* City - MOUNT AIRY* Call Type - CARD ARR E* *﻿",
        "ID:110419-061",
        "ADDR:908 REEVES DR",
        "CITY:MOUNT AIRY",
        "CALL:CARD ARR E");

    doTest("T6",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110419-291* Address - 1053 N MAIN ST* City - MOUNT AIRY* Call Type - SICK C* *﻿",
        "ID:110419-291",
        "ADDR:1053 N MAIN ST",
        "CITY:MOUNT AIRY",
        "CALL:SICK C");

    doTest("T7",
        "SC911-CallAlert!!@co.surry.nc.us S: M:SC911 - Call Alert!!:Call Number - 110430-103* Address - 1020 NEWSOME ST* City - MOUNT AIRY* Call Type - ACCIDENT PI* *",
        "ID:110430-103",
        "ADDR:1020 NEWSOME ST",
        "CITY:MOUNT AIRY",
        "CALL:ACCIDENT PI");

    doTest("T8",
        "SC911-CallAlert!!@co.surry.nc.us SC911 - Call Alert!!:Call Number - 110906-334* Address - 304 JEFFERIES ST* City - MOUNT AIRY* Call Type - LIFELINE* *",
        "ID:110906-334",
        "ADDR:304 JEFFERIES ST",
        "CITY:MOUNT AIRY",
        "CALL:LIFELINE");
  }
  

  public static void main(String[] args) {
    new NCSurryCountyParserTest().generateTests("T1", "ID ADDR CITY CALL");
  }
}
