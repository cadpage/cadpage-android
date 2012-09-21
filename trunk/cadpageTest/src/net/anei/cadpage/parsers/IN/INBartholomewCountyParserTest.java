package net.anei.cadpage.parsers.IN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class INBartholomewCountyParserTest extends BaseParserTest {
  
  public INBartholomewCountyParserTest() {
    setParser(new INBartholomewCountyParser(), "BARTHOLOMEW COUNTY", "IN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FYI: ;08/30/2012 16:36:02;GAS ODOR 651;610 WEST DR;HOPE;WASHINGTON ST;JACKSON ST   - File Messenger Login",
        "DATE:08/30/2012",
        "TIME:16:36:02",
        "CALL:GAS ODOR 651",
        "ADDR:610 WEST DR",
        "CITY:HOPE",
        "X:WASHINGTON ST & JACKSON ST");

    doTest("T2",
        "FYI: ;08/23/2012 18:06:28;STRUCTURE FIRE 111;2018 FREMONT DR;COL;CLARK BLVD;HARRISON DR   - File Messenger Login",
        "DATE:08/23/2012",
        "TIME:18:06:28",
        "CALL:STRUCTURE FIRE 111",
        "ADDR:2018 FREMONT DR",
        "CITY:COLUMBUS",
        "X:CLARK BLVD & HARRISON DR");

    doTest("T3",
        "FYI: ;08/22/2012 21:52:37;ACCIDENT PERSONAL INJURY;N MARR RD/E 550 N;COL   - File Messenger Login",
        "DATE:08/22/2012",
        "TIME:21:52:37",
        "CALL:ACCIDENT PERSONAL INJURY",
        "ADDR:N MARR RD & E 550 N",
        "CITY:COLUMBUS");

    doTest("T4",
        "FYI: ;08/20/2012 08:51:11;POSSIBLE HEART;7185 N 250 E;COL;E 450 N;E 500 N   - File Messenger Login",
        "DATE:08/20/2012",
        "TIME:08:51:11",
        "CALL:POSSIBLE HEART",
        "ADDR:7185 N 250 E",
        "CITY:COLUMBUS",
        "X:E 450 N & E 500 N");

    doTest("T5",
        "FYI: ;08/13/2012 17:32:26;POSSIBLE HEART;8058 N EAST ST;CLIF   - File Messenger Login",
        "DATE:08/13/2012",
        "TIME:17:32:26",
        "CALL:POSSIBLE HEART",
        "ADDR:8058 N EAST ST",
        "CITY:CLIFFORD");

    doTest("T6",
        "Update: ;08/12/2012 13:20:43;DIABETIC REACTION;12301 E 800 N;HOPE;N 575 E;N 670 E   - File Messenger Login",
        "DATE:08/12/2012",
        "TIME:13:20:43",
        "CALL:DIABETIC REACTION",
        "ADDR:12301 E 800 N",
        "CITY:HOPE",
        "X:N 575 E & N 670 E");

    doTest("T7",
        "FYI: ;08/15/2012 04:18:54;STRUCTURE FIRE 111;9341 N 250 W;COL;N CHERRY HILLS DR;N CHERRY HILLS DR   - File Messenger Login",
        "DATE:08/15/2012",
        "TIME:04:18:54",
        "CALL:STRUCTURE FIRE 111",
        "ADDR:9341 N 250 W",
        "CITY:COLUMBUS",
        "X:N CHERRY HILLS DR & N CHERRY HILLS DR");

  }
  
  public static void main(String[] args) {
    new INBartholomewCountyParserTest().generateTests("T1");
  }
}