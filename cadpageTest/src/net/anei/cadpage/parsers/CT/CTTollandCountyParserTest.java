package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTTollandCountyParserTest extends BaseParserTest {
  
  public CTTollandCountyParserTest() {
    setParser(new CTTollandCountyParser(), "TOLLAND COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(TN Alert) 10 COTTAGE ST / UNIT D Vernon ALS Difficulty Breathing 21:14 Cross Street ST BERNARDS TER / SCHOOL ST 2011-00001770",
        "ADDR:10 COTTAGE ST",
        "APT:UNIT D",
        "CITY:Vernon",
        "CALL:ALS Difficulty Breathing",
        "X:ST BERNARDS TER / SCHOOL ST",
        "ID:2011-00001770");

    doTest("T2",
        "[TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 2ND AMB  12:59 Cross Street 2011-00001773",
        "ADDR:DOBSON RD & CAMPBELL AVE",
        "CITY:Vernon",
        "CALL:Vehicle Accident 2ND AMB",
        "ID:2011-00001773");

    doTest("T3",
        "[TN Alert]  32 FRANKLIN PARK E / Vernon ALS DIFF BREATHING 09:07 Cross Street DEAD END / FRANKLIN ST 2011-00001772",
        "ADDR:32 FRANKLIN PARK E",
        "CITY:Vernon",
        "CALL:ALS DIFF BREATHING",
        "X:DEAD END / FRANKLIN ST",
        "ID:2011-00001772");

    doTest("T4",
        "[TN Alert]  140 WINDSORVILLE RD / Vernon BLS back pain 02:21 Cross Street PENFIELD AVE / SEPTIC TREATMENT PLANT 2011-00001771",
        "ADDR:140 WINDSORVILLE RD",
        "CITY:Vernon",
        "CALL:BLS back pain",
        "X:PENFIELD AVE / SEPTIC TREATMENT PLANT",
        "ID:2011-00001771");

    doTest("T5",
        "[TN Alert]  DOBSON RD / CAMPBELL AVE Vernon Vehicle Accident 12:59 Cross Street 2011-00001773",
        "ADDR:DOBSON RD & CAMPBELL AVE",
        "CITY:Vernon",
        "CALL:Vehicle Accident",
        "ID:2011-00001773");

    doTest("T6",
        "[TN Alert]  95 HARTFORD TPKE / Vernon * Golf Land Vehicle Accident MINOR INJURIES - EVALUATION",
        "ADDR:95 HARTFORD TPKE",
        "CITY:Vernon",
        "CALL:Golf Land Vehicle Accident MINOR INJURIES - EVALUATION");

    doTest("T7",
        "[TN Alert]  67 BLUE RIDGE DR / Vernon Tree/Wires Down 14:38 Cross Street HICKORY HL / AUTUMN WOOD LN 2011-00001775",
        "ADDR:67 BLUE RIDGE DR",
        "CITY:Vernon",
        "CALL:Tree/Wires Down",
        "X:HICKORY HL / AUTUMN WOOD LN",
        "ID:2011-00001775");

    doTest("T8",
        "(TN Alert) 155 W   MAIN ST 317 / Vernon ALS DIFFICULTY BREATHING 14:03 Cross Street ORCHARD ST, SPRING ST / WARD ST 2011-00001981",
        "ADDR:155 W MAIN ST 317",
        "CITY:Vernon",
        "CALL:ALS DIFFICULTY BREATHING",
        "X:ORCHARD ST, SPRING ST / WARD ST",
        "ID:2011-00001981");
  }
  
  public static void main(String[] args) {
    new CTTollandCountyParserTest().generateTests("T9", "ADDR APT CITY CALL X ID");
  }
}