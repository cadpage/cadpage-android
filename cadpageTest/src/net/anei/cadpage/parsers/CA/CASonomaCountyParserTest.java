package net.anei.cadpage.parsers.CA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CASonomaCountyParserTest extends BaseParserTest {
  
  public CASonomaCountyParserTest() {
    setParser(new CASonomaCountyParser(), "SONOMA COUNTY", "CA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Loc: HWY1/VALLEY FORD ROAD VFR BOX: 3540 TYP:TC CN: CHP LOG # 632 C#: TYPE CODE: TC CALLER NAME: CHP LOG # 632 CALLER ADDR:  TIME: 11:07:31 COM: ** Case n",
        "ADDR:HWY-1 & VALLEY FORD ROAD",
        "SRC:VFR",
        "BOX:3540",
        "CALL:TC",
        "NAME:CHP LOG # 632",
        "INFO:** Case n");

    doTest("T2",
        "Loc: 1320 BAY VIEW ST BBY:@ BODEGA UNION CHURCH BOX: 3433 B3 TYP: GAS-IN CN: BODEGA BAY UNION CHURCH C#: (707)875-3559 TYPE CODE: GAS-IN CALLER NAME: BODEGA",
        "ADDR:1320 BAY VIEW ST",
        "SRC:BBY",
        "PLACE:BODEGA UNION CHURCH",
        "BOX:3433 B3",
        "CALL:GAS-IN",
        "NAME:BODEGA",
        "PHONE:(707)875-3559");

    doTest("T3",
        "Loc: BBY:@HWY 1MM012.42 BOX:3332 B TYP: TC-EX CN: CHP LOG 344 C#: TYPE CODE: TC_EX CALLER NAME:CHP LOG 344 CALLER ADDR:  TIME: 03:44:34 COM: OVER TURN",
        "ADDR:HWY 1MM012.42",
        "SRC:BBY",
        "BOX:3332 B",
        "CALL:TC-EX",
        "NAME:CHP LOG 344",
        "INFO:OVER TURN");

    doTest("T4",
        "Loc: 1400 VALLEY FORD FREESTONE RD VFR BOX: 3439 B TYP: SER-PA CN: JOANNA C#: (707) 876-3288 TYPE CODE: SER-PA CALLER NAME: JOANNA CALLER ADDR:  TIME: 13:01",
        "ADDR:1400 VALLEY FORD FREESTONE RD",
        "SRC:VFR",
        "BOX:3439 B",
        "CALL:SER-PA",
        "NAME:JOANNA",
        "PHONE:(707) 876-3288");
        
  }
  
  public static void main(String[] args) {
    new CASonomaCountyParserTest().generateTests("T1");
  }
}