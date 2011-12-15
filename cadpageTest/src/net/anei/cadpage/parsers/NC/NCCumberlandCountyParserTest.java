package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCCumberlandCountyParserTest extends BaseParserTest {
  
  public NCCumberlandCountyParserTest() {
    setParser(new NCCumberlandCountyParser(), "CUMBERLAND COUNTY", "NC");
  }
  
  @Test
  public void testParser1() {

    doTest("T1",
        "[S] DEERFIELD (N)C4;01/28/2011 13:19:07;POSS DANGEROUS BODY AREA FALL;ST22;441 WAPITI DR;WILDERNESS DR",
        "PLACE:DEERFIELD",
        "UNIT:C4",
        "DATE:01/28/2011",
        "TIME:13:19:07",
        "CALL:POSS DANGEROUS BODY AREA FALL",
        "SRC:ST22",
        "ADDR:441 WAPITI DR",
        "X:WILDERNESS DR");

    doTest("T2",
        "[S] SPRING LAKE (PLAT BOOK 11, PAGE 3)+/- (N)C4;01/27/2011 22:09:28;CLAMMY BREATHING PROBLEMS;ST22;115-401 LAKE AVE;S FIRST ST;GATEWAY IN",
        "PLACE:GATEWAY IN",
        "UNIT:C4",
        "DATE:01/27/2011",
        "TIME:22:09:28",
        "CALL:CLAMMY BREATHING PROBLEMS",
        "SRC:ST22",
        "ADDR:115-401 LAKE AVE",
        "MADDR:115 LAKE AVE",
        "X:S FIRST ST");

    doTest("T3",
        "[S]  (N)C4;01/27/2011 17:08:27;UNKNOWN STATUS TRAFFIC ACCIDEN;ST22;670 LILLINGTON HWY;HOLLAND DR;WALMART",
        "UNIT:C4",
        "PLACE:WALMART",
        "DATE:01/27/2011",
        "TIME:17:08:27",
        "CALL:UNKNOWN STATUS TRAFFIC ACCIDEN",
        "SRC:ST22",
        "ADDR:670 LILLINGTON HWY",
        "X:HOLLAND DR");

    doTest("T4",
        "[S] OVERHILLS PARK (N)C4;01/27/2011 15:20:35;ABNORMAL BREATHING SICK PERSON;ST22;3110 HUNTLEY ST;ROBBIE CIR",
        "PLACE:OVERHILLS PARK",
        "UNIT:C4",
        "DATE:01/27/2011",
        "TIME:15:20:35",
        "CALL:ABNORMAL BREATHING SICK PERSON",
        "SRC:ST22",
        "ADDR:3110 HUNTLEY ST",
        "X:ROBBIE CIR");

    doTest("T5",
        "[S] R G CREECH (N)C4;01/27/2011 13:23:42;WIRES DOWN (NO SMOKE OR ARC);ST22;200 RUPE ST;SCARBOROUGH ST",
        "PLACE:R G CREECH",
        "UNIT:C4",
        "DATE:01/27/2011",
        "TIME:13:23:42",
        "CALL:WIRES DOWN (NO SMOKE OR ARC)",
        "SRC:ST22",
        "ADDR:200 RUPE ST",
        "X:SCARBOROUGH ST");

    doTest("T6",
        "CAD:(S) (N)C4;03/04/2011 21:18:43;UNKNOWN OUTSIDE FIRE;ST22;2700-BLK BRAGG BLVD",
        "UNIT:C4",
        "DATE:03/04/2011",
        "TIME:21:18:43",
        "CALL:UNKNOWN OUTSIDE FIRE",
        "SRC:ST22",
        "ADDR:2700-BLK BRAGG BLVD",
        "MADDR:2700 BRAGG BLVD");

    doTest("T7",
        "CAD:DIST: 174.69 FT (S)UPTON TYSON (BELRIDGR DR) (N)C10;05/20/2011 08:34:01;CLAMMY CHEST PAIN;ST18;3570 LACEWOOD CT;NC HWY 87 S",
        "PLACE:UPTON TYSON (BELRIDGR DR)",
        "UNIT:C10",
        "DATE:05/20/2011",
        "TIME:08:34:01",
        "CALL:CLAMMY CHEST PAIN",
        "SRC:ST18",
        "ADDR:3570 LACEWOOD CT",
        "X:NC HWY 87 S");

  }
  
  @Test
  public void testStation13() {

    doTest("T1",
        "(Station 13) 2011 07:30:53;ALERT WITH ABNORMAL BREATHING;ST13;2881 STRICKLAND BRIDGE RD;CENTURY CIR",
        "TIME:07:30:53",
        "CALL:ALERT WITH ABNORMAL BREATHING",
        "SRC:ST13",
        "ADDR:2881 STRICKLAND BRIDGE RD",
        "X:CENTURY CIR");

    doTest("T2",
        "(Station 13) 08/2011 18:00:08;RESIDENTIAL ALARM;0431,2131,ST13,ST19;5681 CAMDEN RD;STATE ST",
        "TIME:18:00:08",
        "CALL:RESIDENTIAL ALARM",
        "SRC:0431,2131,ST13,ST19",
        "ADDR:5681 CAMDEN RD",
        "X:STATE ST");

    doTest("T3",
        "(Station 13) 7/11/2011 16:16:30;DIFFICULTY SPEAKING BREATHING;ST13,ST19;4737 DESERT RIDGE RD;HYPONY TRL",
        "TIME:16:16:30",
        "CALL:DIFFICULTY SPEAKING BREATHING",
        "SRC:ST13,ST19",
        "ADDR:4737 DESERT RIDGE RD",
        "X:HYPONY TRL");

    doTest("T4",
        "(Station 13) POINT (N)C8;07/18/2011 16:13:08;NOT ALERT BREATHING PROBSLEMS;ST13;6240 STONEY POINT LOOP;SPRINGRUN RD",
        "UNIT:C8",
        "DATE:07/18/2011",
        "TIME:16:13:08",
        "CALL:NOT ALERT BREATHING PROBSLEMS",
        "SRC:ST13",
        "ADDR:6240 STONEY POINT LOOP",
        "X:SPRINGRUN RD");

    doTest("T5",
        "(Station 13) 2011 07:30:53;ALERT WITH ABNORMAL BREATHING;ST13;2881 STRICKLAND BRIDGE RD;CENTURY CIR",
        "TIME:07:30:53",
        "CALL:ALERT WITH ABNORMAL BREATHING",
        "SRC:ST13",
        "ADDR:2881 STRICKLAND BRIDGE RD",
        "X:CENTURY CIR");

    doTest("T6",
        "(Station 13) 08/2011 18:00:08;RESIDENTIAL ALARM;0431,2131,ST13,ST19;5681 CAMDEN RD;STATE ST",
        "TIME:18:00:08",
        "CALL:RESIDENTIAL ALARM",
        "SRC:0431,2131,ST13,ST19",
        "ADDR:5681 CAMDEN RD",
        "X:STATE ST");

  }
  
  @Test
  public void testStartion4() {

    doTest("T1",
        "(Station #4) PAPER MILL 12/09/2011 22:21:31;ABNORMAL BREATHING CHEST PN;4474 CAMERON RD;PECAN DR",
        "PLACE:PAPER MILL",
        "DATE:12/09/2011",
        "TIME:22:21:31",
        "CALL:ABNORMAL BREATHING CHEST PN",
        "SRC:4474 CAMERON RD",
        "ADDR:PECAN DR",
        "MADDR:PAPER MILL,PECAN DR");

  }
  

  public static void main(String[] args) {
    new NCCumberlandCountyParserTest().generateTests("T3");
  }
}
