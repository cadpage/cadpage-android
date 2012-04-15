package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOJasperCountyParserTest extends BaseParserTest {
  
  public MOJasperCountyParserTest() {
    setParser(new MOJasperCountyParser(), "JASPER COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "S: M:LONE ELM/ESTATE LN- ROLLOVER\n",
        "ADDR:LONE ELM & ESTATE LN",
        "CALL:ROLLOVER");

    doTest("T2",
        "S: M:1725B Redbud dr- 87 yom fall - back pain\n",
        "ADDR:1725B Redbud dr",
        "CALL:87 yom fall - back pain");

    doTest("T3",
        "S: M:VEHICLE FIRE FIR AND BLACK CAT\n",
        "CALL:VEHICLE FIRE FIR AND BLACK CAT");

    doTest("T4",
        "S: M:6653 PARK CIR APTD - 87 YOM FELL\n",
        "ADDR:6653 PARK CIR",
        "APT:D",
        "CALL:87 YOM FELL");

    doTest("T5",
        "S: M:3169 N MISSOURI 20 DAY OLD DIFF BREATING DELTA MBP 51C\n\n\n\n\n\n",
        "ADDR:3169 N MISSOURI 20 DAY OLD DIFF BREATING DELTA MBP 51C");

    doTest("T6",
        "S: M:302 KEENEY DR - CJ JUNIOR HIGH - POSSIBLE SEIZURE\n",
        "ADDR:302 KEENEY DR",
        "CALL:CJ JUNIOR HIGH - POSSIBLE SEIZURE");

    doTest("T7",
        "S: M:25589 TABOR MAIN - DIFF BREATHING\n",
        "ADDR:25589 TABOR MAIN",
        "CALL:DIFF BREATHING");

  }
  
  public static void main(String[] args) {
    new MOJasperCountyParserTest().generateTests("T1", "ADDR APT CALL INFO");
  }
}