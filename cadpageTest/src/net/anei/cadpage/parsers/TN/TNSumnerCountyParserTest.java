package net.anei.cadpage.parsers.TN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sumner County, TN
Contact: Eddie Durham <edurham4530@gmail.com>
Sender: e911@sumnersheriff.com
* 1105 DOUGLAS PL* * * GALLATIN* * FIRE GRS WDS* * * * * * * * *
* 1303 SHORESIDE DR* * * HENDERSONVILLE* * CHEST PAIN* * * * * * * * *
* 154 LEE ETTA DR* * * GALLATIN* * UNCONSCIOUS* * * * * * * * *
* 2470 CAGES BEND RD* * * GALLATIN* * ACC IJ* * * * * * * * *
* 101 LAKESIDE CIR* * * HENDERSONVILLE* * NONSPECIFIC* * * * * * * * *
* 153 TANASI SHORES* * * HENDERSONVILLE* * RESPIRATORY* * * * * * * * *
 
Contact: robby.klotz@gmail.com <robby.klotz@gmail.com>
* 3571 TYREE SPRINGS RD* * * HENDERSONVILLE* HARRINGTON PVT HOLLO* BEN ALBERT RD* SUMNER* * OVERDOSE* * * * * * Line16=* Line17=* Line18=*

*/

public class TNSumnerCountyParserTest extends BaseParserTest {
  
  public TNSumnerCountyParserTest() {
    setParser(new TNSumnerCountyParser(), "SUMNER COUNTY", "TN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "* 1105 DOUGLAS PL* * * GALLATIN* * FIRE GRS WDS* * * * * * * * *",
        "ADDR:1105 DOUGLAS PL",
        "CITY:GALLATIN",
        "CALL:FIRE GRS WDS");

    doTest("T2",
        "* 1303 SHORESIDE DR* * * HENDERSONVILLE* * CHEST PAIN* * * * * * * * *",
        "ADDR:1303 SHORESIDE DR",
        "CITY:HENDERSONVILLE",
        "CALL:CHEST PAIN");

    doTest("T3",
        "* 154 LEE ETTA DR* * * GALLATIN* * UNCONSCIOUS* * * * * * * * *",
        "ADDR:154 LEE ETTA DR",
        "CITY:GALLATIN",
        "CALL:UNCONSCIOUS");

    doTest("T4",
        "* 2470 CAGES BEND RD* * * GALLATIN* * ACC IJ* * * * * * * * *",
        "ADDR:2470 CAGES BEND RD",
        "CITY:GALLATIN",
        "CALL:ACC IJ");

    doTest("T5",
        "* 101 LAKESIDE CIR* * * HENDERSONVILLE* * NONSPECIFIC* * * * * * * * *",
        "ADDR:101 LAKESIDE CIR",
        "CITY:HENDERSONVILLE",
        "CALL:NONSPECIFIC");

    doTest("T6",
        "* 153 TANASI SHORES* * * HENDERSONVILLE* * RESPIRATORY* * * * * * * * *",
        "ADDR:153 TANASI SHORES",
        "CITY:HENDERSONVILLE",
        "CALL:RESPIRATORY");
    
  }
  
  @Test
  public void testRobyKlotz() {

    doTest("T1",
        "* 3571 TYREE SPRINGS RD* * * HENDERSONVILLE* HARRINGTON PVT HOLLO* BEN ALBERT RD* SUMNER* * OVERDOSE* * * * * * Line16=* Line17=* Line18=*",
        "ADDR:3571 TYREE SPRINGS RD",
        "CITY:HENDERSONVILLE",
        "PLACE:HARRINGTON PVT HOLLO",
        "CALL:BEN ALBERT RD",
        "INFO:SUMNER / OVERDOSE");

  }
  
  public static void main(String[] args) {
    new TNSumnerCountyParserTest().generateTests("T1");
  }
}
