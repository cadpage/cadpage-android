package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Tazewell County IL
Contact: Jarod Bradfield <jarod.bradfield@gmail.com>
Sender: cad@tazewell911.com
CAD:FYI: ;MAFD;10/20/2012 10:04:35;CHEST PAIN;500-C1 W 2ND ST
CAD:FYI: ;MAFD;11/06/2012 16:06:32;EMERGENCY MEDICAL;507 E FIFTH;KERLIN;S JULIANA
CAD:FYI: ;MAFD;11/03/2012 18:15:04;FALLS;108 W FIRST;E FIRST;S MONROE 
CAD:FYI: ;MAFD;11/31/2012 03:12:48;BACK PAIN;205 S ORCHARD;E MADISON;S FIFTH
CAD:FYI: ;MAFD;10/28/2012 11:08:07;EMERGENCY MEDICAL;212 E SECOND;S ORCHARD;S  WHITE

*/

public class ILTazewellCountyParserTest extends BaseParserTest {
  
  public ILTazewellCountyParserTest() {
    setParser(new ILTazewellCountyParser(), "TAZEWELL COUNTY", "IL");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CAD:FYI: ;MAFD;10/20/2012 10:04:35;CHEST PAIN;500-C1 W 2ND ST",
        "SRC:MAFD",
        "DATE:10/20/2012",
        "TIME:10:04:35",
        "CALL:CHEST PAIN",
        "ADDR:500-C1 W 2ND ST",
        "MADDR:500 W 2ND ST");

    doTest("T2",
        "CAD:FYI: ;MAFD;11/06/2012 16:06:32;EMERGENCY MEDICAL;507 E FIFTH;KERLIN;S JULIANA",
        "SRC:MAFD",
        "DATE:11/06/2012",
        "TIME:16:06:32",
        "CALL:EMERGENCY MEDICAL",
        "ADDR:507 E FIFTH",
        "X:KERLIN & S JULIANA");

    doTest("T3",
        "CAD:FYI: ;MAFD;11/03/2012 18:15:04;FALLS;108 W FIRST;E FIRST;S MONROE ",
        "SRC:MAFD",
        "DATE:11/03/2012",
        "TIME:18:15:04",
        "CALL:FALLS",
        "ADDR:108 W FIRST",
        "X:E FIRST & S MONROE");

    doTest("T4",
        "CAD:FYI: ;MAFD;11/31/2012 03:12:48;BACK PAIN;205 S ORCHARD;E MADISON;S FIFTH",
        "SRC:MAFD",
        "DATE:11/31/2012",
        "TIME:03:12:48",
        "CALL:BACK PAIN",
        "ADDR:205 S ORCHARD",
        "X:E MADISON & S FIFTH");

    doTest("T5",
        "CAD:FYI: ;MAFD;10/28/2012 11:08:07;EMERGENCY MEDICAL;212 E SECOND;S ORCHARD;S  WHITE",
        "SRC:MAFD",
        "DATE:10/28/2012",
        "TIME:11:08:07",
        "CALL:EMERGENCY MEDICAL",
        "ADDR:212 E SECOND",
        "X:S ORCHARD & S  WHITE");

  }
  
  public static void main(String[] args) {
    new ILTazewellCountyParserTest().generateTests("T1");
  }
}