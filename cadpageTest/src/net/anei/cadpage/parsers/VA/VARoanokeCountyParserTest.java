package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class VARoanokeCountyParserTest extends BaseParserTest {
  
  public VARoanokeCountyParserTest() {
    setParser(new VARoanokeCountyParser(), "ROANOKE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "RES3 R33 CO3 W3 EMS2  ACCIDENT PERSONAL INJURY CHAPARRAL DR XST  PENN FOREST",
        "UNIT:RES3 R33 CO3 W3 EMS2",
        "CALL:ACCIDENT PERSONAL INJURY",
        "ADDR:CHAPARRAL DR",
        "MADDR:CHAPARRAL DR & PENN FOREST",
        "X:PENN FOREST");

    doTest("T2",
        "CO9 W9 CO10 W10 CO3 W3 RES9 M92 TOWR9 BATT1 EMS2  COMMERCIAL FIRE ALARM(RKCHFIELD MEMORY CARE CENTER3719 KNOLLRIDGE RD XST 5/5/2012 11:38:29 AM",
        "UNIT:CO9 W9 CO10 W10 CO3 W3 RES9 M92 TOWR9 BATT1 EMS2",
        "CALL:COMMERCIAL FIRE ALARM(RKCHFIELD MEMORY CARE CENTER3719",
        "ADDR:KNOLLRIDGE RD",
        "DATE:5/5/2012",
        "TIME:11:38:29");

    doTest("T3",
        "COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER 3719 KNOLLRIDGE RD XST 5/5/2012 11:40:27 AM",
        "CALL:COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER",
        "ADDR:3719 KNOLLRIDGE RD",
        "DATE:5/5/2012",
        "TIME:11:40:27");

    doTest("T4",
        "CO3 W3 CO11 E11 CO7 W7 RES3 M31 L3 EMS2 Commercial Structure Fire 3155 Berry LN XST ELECTRIC RD POSTAL DR DEAD END",
        "UNIT:CO3 W3 CO11 E11 CO7 W7 RES3 M31 L3 EMS2",
        "CALL:Commercial Structure Fire",
        "ADDR:3155 Berry LN",
        "X:ELECTRIC RD POSTAL DR DEAD END");

    doTest("T5",
        "COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER 3719 KNOLLRIDGE RD XST",
        "CALL:COMMERCIAL FIRE ALARM RICHFIELD MEMORY CARE CENTER",
        "ADDR:3719 KNOLLRIDGE RD");

    doTest("T6",
        "RES3 M33 CO3 W3 EMS2  ACCIDENT PERSONAL INJURY 5807 PENN FOREST PL XST  MERRIMAN RD   DEAD END 5/6/2012 3:10:28 PM",
        "UNIT:RES3 M33 CO3 W3 EMS2",
        "CALL:ACCIDENT PERSONAL INJURY",
        "ADDR:5807 PENN FOREST PL",
        "X:MERRIMAN RD & DEAD END",
        "DATE:5/6/2012",
        "TIME:15:10:28");

    doTest("T7",
        "W3  ALS 3556 KENWICK TRL XST  VERONA TRL   OVERHILL TRL 5/6/2012 3:56:38 PM",
        "UNIT:W3",
        "CALL:ALS",
        "ADDR:3556 KENWICK TRL",
        "X:VERONA TRL & OVERHILL TRL",
        "DATE:5/6/2012",
        "TIME:15:56:38");

    doTest("T8",
        "CO7 W7 CO3 W3 RES7 M7 L3 BATT1 EMS2  Residential Structure Fire 7249 BIRCH CT XST  SOUTH MOUNTAIN DR   PINE CT 5/6/2012 4:56:42 PM",
        "UNIT:CO7 W7 CO3 W3 RES7 M7 L3 BATT1 EMS2",
        "CALL:Residential Structure Fire",
        "ADDR:7249 BIRCH CT",
        "X:SOUTH MOUNTAIN DR & PINE CT",
        "DATE:5/6/2012",
        "TIME:16:56:42");
    
  }
  
  public static void main(String[] args) {
    new VARoanokeCountyParserTest().generateTests("T1", "UNIT CALL ADDR APT X DATE TIME");
  }
}