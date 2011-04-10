package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOGreeneCountyParserTest extends BaseParserTest {
  
  public MOGreeneCountyParserTest() {
    setParser(new MOGreeneCountyParser(), "GREENE COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TYP: RESIDENTIAL FIRE AD: 500 S VENTURA AVE CTY: REPUBLIC MAP: U-8 CN: JOE SNYDER CMT1: * * * CLONE STRUCTURE FIRES TO GF/FHOUSE-FBLDG/BF10/ CMT:AUTO_AID * * * TIME: 22:21 UNTS: RF/BRUSH1 XST: 598 S FOREST LN XST2: 600 W ONEAL RD",
        "CALL:RESIDENTIAL FIRE",
        "ADDR:500 S VENTURA AVE",
        "CITY:REPUBLIC",
        "MAP:U-8",
        "NAME:JOE SNYDER",
        "INFO:* * * CLONE STRUCTURE FIRES TO GF/FHOUSE-FBLDG/BF10/ CMT:AUTO_AID * * *",
        "UNIT:RF/BRUSH1",
        "X:598 S FOREST LN & 600 W ONEAL RD");

    doTest("T2",
        "TYP: MEDICAL AD: 1013 E US60 EAST CTY: REPUBLIC MAP: T-9 LOC: PRICE CUTTER CMT1: * * * CLONE STRUCTURE FIRES TO GF/ FHOUSE-FBLDG/BF10/CMT:AUTO_AID * * * CMT2: PERSON FELL OFF BICYCLE -ELDERLY TIME: 19:12 UNTS: RF/ST1",
        "CALL:MEDICAL",
        "ADDR:1013 E US60 EAST",
        "CITY:REPUBLIC",
        "MAP:T-9",
        "PLACE:PRICE CUTTER",
        "INFO:* * * CLONE STRUCTURE FIRES TO GF/ FHOUSE-FBLDG/BF10/CMT:AUTO_AID * * * / PERSON FELL OFF BICYCLE -ELDERLY",
        "UNIT:RF/ST1");
  }

  public static void main(String[] args) {
    new MOGreeneCountyParserTest().generateTests("T1");
  }
}
