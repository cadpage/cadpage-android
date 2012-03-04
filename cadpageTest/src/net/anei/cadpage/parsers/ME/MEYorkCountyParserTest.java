package net.anei.cadpage.parsers.ME;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MEYorkCountyParserTest extends BaseParserTest {
  
  public MEYorkCountyParserTest() {
    setParser(new MEYorkCountyParser(), "YORK COUNTY", "ME");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Sanford RCC Page) MEDICAL EMERGENCY\nGOODALL HOSPITAL URGENT CARE/PHARMACY\n10 GOODALL DR \nWaterboro\n2/13/2012 16:59",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GOODALL HOSPITAL URGENT CARE/PHARMACY",
        "ADDR:10 GOODALL DR",
        "CITY:Waterboro",
        "DATE:2/13/2012",
        "TIME:16:59");

    doTest("T2",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n22 COYNE RD \nWaterboro\n2/13/2012 10:51",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:22 COYNE RD",
        "CITY:Waterboro",
        "DATE:2/13/2012",
        "TIME:10:51");

    doTest("T3",
        "(Sanford RCC Page) FIRE, OTHER\n23 BACK ST \nWaterboro\n2/13/2012 18:58",
        "CALL:FIRE, OTHER",
        "ADDR:23 BACK ST",
        "CITY:Waterboro",
        "DATE:2/13/2012",
        "TIME:18:58");

    doTest("T4",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n50 SANFORD RD \nWaterboro\n2/14/2012 14:53",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:50 SANFORD RD",
        "CITY:Waterboro",
        "DATE:2/14/2012",
        "TIME:14:53");

    doTest("T5",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n77 SOKOKIS TRL \nWaterboro\n2/14/2012 20:07",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:77 SOKOKIS TRL",
        "CITY:Waterboro",
        "DATE:2/14/2012",
        "TIME:20:07");

    doTest("T6",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n22 MILL POND RD \nWaterboro\n2/15/2012 09:19",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:22 MILL POND RD",
        "CITY:Waterboro",
        "DATE:2/15/2012",
        "TIME:09:19");

    doTest("T7",
        "(Sanford RCC Page) MEDICAL EMERGENCY\nGOODALL HOSPITAL URGENT CARE/PHARMACY\n10 GOODALL DR \nWaterboro\n2/15/2012 10:30",
        "CALL:MEDICAL EMERGENCY",
        "PLACE:GOODALL HOSPITAL URGENT CARE/PHARMACY",
        "ADDR:10 GOODALL DR",
        "CITY:Waterboro",
        "DATE:2/15/2012",
        "TIME:10:30");

    doTest("T8",
        "(Sanford RCC Page) MEDICAL EMERGENCY\nLAKE ARROWHEAD\nWaterboro\n2/16/2012 14:53",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:LAKE ARROWHEAD",
        "CITY:Waterboro",
        "DATE:2/16/2012",
        "TIME:14:53");

    doTest("T9",
        "(Sanford RCC Page) MEDICAL EMERGENCY\n1331 SOKOKIS TRL \nWaterboro\n2/17/2012 05:41",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:1331 SOKOKIS TRL",
        "CITY:Waterboro",
        "DATE:2/17/2012",
        "TIME:05:41");

    doTest("T10",
        "(Sanford RCC Page) FIRE, OTHER\n26 LOGAN CIRCLE EXT \nWaterboro\n2/17/2012 11:29",
        "CALL:FIRE, OTHER",
        "ADDR:26 LOGAN CIRCLE EXT",
        "MADDR:26 LOGAN CIRCLE",
        "CITY:Waterboro",
        "DATE:2/17/2012",
        "TIME:11:29");
  }
  
  public static void main(String[] args) {
    new MEYorkCountyParserTest().generateTests("T1");
  }
}