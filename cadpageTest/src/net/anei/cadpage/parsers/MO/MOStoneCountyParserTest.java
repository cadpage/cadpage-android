package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOStoneCountyParserTest extends BaseParserTest {
  
  public MOStoneCountyParserTest() {
    setParser(new MOStoneCountyParser(), "STONE COUNTY", "MO");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "911-CENTER:FMA MUTUAL AID/ASSIST OUTSIDE AGEN 214 E 5TH ST 4175270913 S MAPLE ST MUTUAL AID ASSIST OUTSIDE AGENCY",
        "CALL:FMA MUTUAL AID/ASSIST OUTSIDE AGEN",
        "ADDR:214 E 5TH ST",
        "PHONE:4175270913",
        "X:S MAPLE ST",
        "INFO:MUTUAL AID ASSIST OUTSIDE AGENCY");

    doTest("T2",
        "911-CENTER:FMVC MOTOR VEHICLE COLLISION STATE HWY TT&STATE HWY D 4178498278 STATE HWY D MOTOR VEHICLE COLLISION",
        "CALL:FMVC MOTOR VEHICLE COLLISION",
        "ADDR:STATE HWY TT & STATE HWY D",
        "PHONE:4178498278",
        "X:STATE HWY D",
        "INFO:MOTOR VEHICLE COLLISION");

    doTest("T3",
        "911-CENTER:FBF BRUSH/FOREST FIRE 546 CAMP CLARK HL 4175989172 SMALL ST BRUSH FIRE",
        "CALL:FBF BRUSH/FOREST FIRE",
        "ADDR:546 CAMP CLARK HL",
        "PHONE:4175989172",
        "X:SMALL ST",
        "INFO:BRUSH FIRE");

    doTest("T4",
        "911-CENTER:FIO FIRE INVESTIGATION OUTSIDE 110 S MAPLE ST 4173576116 E 4TH ST FIRE INVESTIGATION OUTSIDE",
        "CALL:FIO FIRE INVESTIGATION OUTSIDE",
        "ADDR:110 S MAPLE ST",
        "PHONE:4173576116",
        "X:E 4TH ST",
        "INFO:FIRE INVESTIGATION OUTSIDE");

    doTest("T5",
        "911-CENTER:FMVC MOTOR VEHICLE COLLISION 41604 STATE HWY 413 4178389861 MOTOR VEHICLE COLLISION",
        "CALL:FMVC MOTOR VEHICLE COLLISION",
        "ADDR:41604 STATE HWY 413",
        "PHONE:4178389861",
        "INFO:MOTOR VEHICLE COLLISION");

    doTest("T6",
        "911-CENTER:FRF RUBBISH FIRE NO EXPOSURES OLD WIRE RD&ROUNDHOUSE RD 417 ROUNDHOUSE RD RUBBISH FIRE.",
        "CALL:FRF RUBBISH FIRE NO EXPOSURES",
        "ADDR:OLD WIRE RD & ROUNDHOUSE RD",
        "APT:417",
        "X:ROUNDHOUSE RD",
        "INFO:RUBBISH FIRE");
  }
  
  public static void main(String[] args) {
    new MOStoneCountyParserTest().generateTests("T1", "CALL ADDR APT PHONE X INFO");
  }
}