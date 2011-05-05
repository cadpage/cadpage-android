package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class ORLinnCountyParserTest extends BaseParserTest {
  
  public ORLinnCountyParserTest() {
    setParser(new ORLinnCountyParser(), "LINN COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "OTH STRCT FIRE/40560 MCQUEEN DR Linn County/HWY 228 &/6654B23*21/ E23 PT23 STN23 SF M21 A201 E21 E25 STN21 TONE WT21 1ST E22 STN22 WT22 STN24",
        "CALL:OTH STRCT FIRE",
        "ADDR:40560 MCQUEEN DR",
        "CITY:Linn County",
        "X:HWY 228 &",
        "ID:6654B23*21",
        "UNIT:E23 PT23 STN23 SF M21 A201 E21 E25 STN21 TONE WT21 1ST E22 STN22 WT22 STN24");

    doTest("T2",
        "UNCONC/FAINTING/ 300 W HOLLEY RD Sweet Home STONEBROOK APARTMENTS/ 61602221/ F",
        "CALL:UNCONC/FAINTING",
        "ADDR:300 W HOLLEY RD",
        "CITY:Sweet Home",
        "PLACE:STONEBROOK APARTMENTS",
        "ID:61602221",
        "UNIT:F");

    doTest("T3",
        "BREATH PROB/ 5050 MOUNTAIN FIR ST Sweet Home WILEY CREEK COMMUNITY/ 59662221/",
        "CALL:BREATH PROB",
        "ADDR:5050 MOUNTAIN FIR ST",
        "CITY:Sweet Home",
        "PLACE:WILEY CREEK COMMUNITY",
        "ID:59662221");

    doTest("T4",
        "SICK PERSON/ 1048 26TH CT Sweet Home/ 60632221/",
        "CALL:SICK PERSON",
        "ADDR:1048 26TH CT",
        "CITY:Sweet Home",
        "ID:60632221");

    doTest("T5",
        "SICK PERSON/ 24490 WEST BRUSH CREEK RD Linn County/ 705023*21/",
        "CALL:SICK PERSON",
        "ADDR:24490 WEST BRUSH CREEK RD",
        "CITY:Linn County",
        "ID:705023*21");

    doTest("T6",
        "SICK PERSON/ 45265 SUNNYSIDE RD Linn County/ 547021*21/",
        "CALL:SICK PERSON",
        "ADDR:45265 SUNNYSIDE RD",
        "CITY:Linn County",
        "ID:547021*21");

    doTest("T7",
        "TRAUMA INJ/ 43813 WILEY CREEK DR Linn County/ 587022*21/",
        "CALL:TRAUMA INJ",
        "ADDR:43813 WILEY CREEK DR",
        "CITY:Linn County",
        "ID:587022*21");

    doTest("T8",
        "STROKE/CVA/ 43786 WILEY CREEK DR Linn County/ 587022*21/",
        "CALL:STROKE/CVA",
        "ADDR:43786 WILEY CREEK DR",
        "CITY:Linn County",
        "ID:587022*21");

    doTest("T9",
        "SICK PERSON/ 1177 1ST AV Sweet Home/ 60602221/",
        "CALL:SICK PERSON",
        "ADDR:1177 1ST AV",
        "CITY:Sweet Home",
        "ID:60602221");

    doTest("T10",
        "UNK PROB (man down)/ 1228 4TH AV Sweet Home/ 60602221/",
        "CALL:UNK PROB (man down)",
        "ADDR:1228 4TH AV",
        "CITY:Sweet Home",
        "ID:60602221");

    doTest("T11",
        "O D/INGESTION/POISONING/ 1131 29TH AV #C2 Sweet Home/ 60632221/",
        "CALL:O D/INGESTION/POISONING",
        "ADDR:1131 29TH AV",
        "APT:#C2",
        "CITY:Sweet Home",
        "ID:60632221");

    doTest("T12",
        "DIABETIC PROB/ 950 NANDINA ST Sweet Home TWIN OAKS CARE CENTER/ 60612221/",
        "CALL:DIABETIC PROB",
        "ADDR:950 NANDINA ST",
        "CITY:Sweet Home",
        "PLACE:TWIN OAKS CARE CENTER",
        "ID:60612221");

    doTest("T13",
        "BREATH PROB/ 43156 NORTH RIVER DR Linn County/ 586622*21/",
        "CALL:BREATH PROB",
        "ADDR:43156 NORTH RIVER DR",
        "CITY:Linn County",
        "ID:586622*21");

    doTest("T14",
        "BREATH PROB/ 38110 HWY 228 Linn County/ 6649A23*21/",
        "CALL:BREATH PROB",
        "ADDR:38110 HWY 228",
        "CITY:Linn County",
        "ID:6649A23*21");

    doTest("T15",
        "ALARM-FIRE/ 1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/ 60612221/",
        "CALL:ALARM-FIRE",
        "ADDR:1400 18TH AV",
        "CITY:Sweet Home",
        "PLACE:LINMAR INDUSTRIES LLC",
        "ID:60612221");

    doTest("T16",
        "ALARM-FIRE/1400 18TH AV Sweet Home LINMAR INDUSTRIES LLC/HWY 20 & TAMARACK ST/60612221/ E21 STN21/Overhead door ~ water flow ~ zone 3 ~ riser 1",
        "CALL:ALARM-FIRE",
        "ADDR:1400 18TH AV",
        "CITY:Sweet Home",
        "PLACE:LINMAR INDUSTRIES LLC",
        "X:HWY 20 & TAMARACK ST",
        "ID:60612221",
        "UNIT:E21 STN21",
        "INFO:Overhead door ~ water flow ~ zone 3 ~ riser 1");

    doTest("T17",
        "SICK PERSON/ 1099 LONG ST Sweet Home SWEET HOME FIRE DEPARTMENT/ 60612221/",
        "CALL:SICK PERSON",
        "ADDR:1099 LONG ST",
        "CITY:Sweet Home",
        "PLACE:SWEET HOME FIRE DEPARTMENT",
        "ID:60612221");

    doTest("T18",
        "CHEST PAIN/ 1530 TAMARACK ST #62 Sweet Home MT SHADOW TRAILER PARK/ 60612221/",
        "CALL:CHEST PAIN",
        "ADDR:1530 TAMARACK ST",
        "APT:#62",
        "CITY:Sweet Home",
        "PLACE:MT SHADOW TRAILER PARK",
        "ID:60612221");

    doTest("T19",
        "CARDIAC/RESP ARREST/ 930 POPLAR ST Sweet Home/ 60602221/",
        "CALL:CARDIAC/RESP ARREST",
        "ADDR:930 POPLAR ST",
        "CITY:Sweet Home",
        "ID:60602221");

    doTest("T20",
        "CARDIAC/RESP ARREST/930 POPLAR ST Sweet Home/9TH AV & 11TH AV/60602221/ E21 RESCUE M21/neighbor came over and found her",
        "CALL:CARDIAC/RESP ARREST",
        "ADDR:930 POPLAR ST",
        "CITY:Sweet Home",
        "X:9TH AV & 11TH AV",
        "ID:60602221",
        "UNIT:E21 RESCUE M21",
        "INFO:neighbor came over and found her");

    doTest("T21",
        "EYE PROB/INJURIES/ 1530 TAMARACK ST #218 Sweet Home MT SHADOW TRAILER PARK/ 60612221/",
        "CALL:EYE PROB/INJURIES",
        "ADDR:1530 TAMARACK ST",
        "APT:#218",
        "CITY:Sweet Home",
        "PLACE:MT SHADOW TRAILER PARK",
        "ID:60612221");

    doTest("T22",
        "TRAUMA INJ/ 3137 SANTIAM HWY SP 11 Sweet Home TRAILER VILLA/ 60632221/",
        "CALL:TRAUMA INJ",
        "ADDR:3137 SANTIAM HWY SP 11",
        "CITY:Sweet Home",
        "PLACE:TRAILER VILLA",
        "ID:60632221");
  }
  
  public static void main(String[] args) {
    new ORLinnCountyParserTest().generateTests("T1");
  }
}