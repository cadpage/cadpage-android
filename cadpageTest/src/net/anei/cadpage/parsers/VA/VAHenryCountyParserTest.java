package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Henry County, VA
Contact: Hamp Ingram <emt.basics@gmail.com>
Sender: MHC911@co.henry.va.us

480 LEWIS RD MARTINSVILLE 2011095252 12:30:03 RFA-(3) FALL - FRACTURE
2900 DILLONS FORK RD FIELDALE 2011095631 08:16:38 ROV-(2) OVERDOSE
2487 SPRUCE ST MARTINSVILLE 2011095614 06:57:08 RFA-(3) FALL - FRACTURE
1890 DANIELS CREEK RD COLLINSVILLE 2011095584 22:15:45 RSI-(2) SICK
2630 VIRGINIA AVE COLLINSVILLE 2011095480 11:35:03 RDZ-(3) DIZZINESS, WEAKNESS
1385 WINGFIELD ORCHARD RD MARTINSVILLE 2011095447 07:31:58 R3-(1) CHEST PAINS

Contact: Bob Phillips <bobphillips2685@gmail.com>
904 MOUNTAIN RD 11 MARTINSVILLE 2011097764 21:12:40 R3-(1) CHEST PAINS

Contact: Active911
[] 36 TERRY CT 7 COLLINSVILLE ROCKFORD RD X DEAD END 2012083814 01:48:06 -CARDIAC (WITH PREVIOUS HISTORY) 24 YOA, DIFF BREATHING, CHEST PAINS, Radiating TO HER BACK.\r\n\n

*/

public class VAHenryCountyParserTest extends BaseParserTest {
  
  public VAHenryCountyParserTest() {
    setParser(new VAHenryCountyParser(), "HENRY COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "480 LEWIS RD MARTINSVILLE 2011095252 12:30:03 RFA-(3) FALL - FRACTURE",
        "ADDR:480 LEWIS RD",
        "CITY:MARTINSVILLE",
        "ID:2011095252",
        "TIME:12:30:03",
        "UNIT:RFA-(3)",
        "CALL:FALL - FRACTURE");

    doTest("T2",
        "2900 DILLONS FORK RD FIELDALE 2011095631 08:16:38 ROV-(2) OVERDOSE",
        "ADDR:2900 DILLONS FORK RD",
        "CITY:FIELDALE",
        "ID:2011095631",
        "TIME:08:16:38",
        "UNIT:ROV-(2)",
        "CALL:OVERDOSE");

    doTest("T3",
        "2487 SPRUCE ST MARTINSVILLE 2011095614 06:57:08 RFA-(3) FALL - FRACTURE",
        "ADDR:2487 SPRUCE ST",
        "CITY:MARTINSVILLE",
        "ID:2011095614",
        "TIME:06:57:08",
        "UNIT:RFA-(3)",
        "CALL:FALL - FRACTURE");

    doTest("T4",
        "1890 DANIELS CREEK RD COLLINSVILLE 2011095584 22:15:45 RSI-(2) SICK",
        "ADDR:1890 DANIELS CREEK RD",
        "CITY:COLLINSVILLE",
        "ID:2011095584",
        "TIME:22:15:45",
        "UNIT:RSI-(2)",
        "CALL:SICK");

    doTest("T5",
        "2630 VIRGINIA AVE COLLINSVILLE 2011095480 11:35:03 RDZ-(3) DIZZINESS, WEAKNESS",
        "ADDR:2630 VIRGINIA AVE",
        "CITY:COLLINSVILLE",
        "ID:2011095480",
        "TIME:11:35:03",
        "UNIT:RDZ-(3)",
        "CALL:DIZZINESS",
        "INFO:WEAKNESS");

    doTest("T6",
        "1385 WINGFIELD ORCHARD RD MARTINSVILLE 2011095447 07:31:58 R3-(1) CHEST PAINS",
        "ADDR:1385 WINGFIELD ORCHARD RD",
        "CITY:MARTINSVILLE",
        "ID:2011095447",
        "TIME:07:31:58",
        "UNIT:R3-(1)",
        "CALL:CHEST PAINS");

    doTest("T7",
        "904 MOUNTAIN RD 11 MARTINSVILLE 2011097764 21:12:40 R3-(1) CHEST PAINS",
        "ADDR:904 MOUNTAIN RD 11",
        "CITY:MARTINSVILLE",
        "ID:2011097764",
        "TIME:21:12:40",
        "UNIT:R3-(1)",
        "CALL:CHEST PAINS");

  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "[] 36 TERRY CT 7 COLLINSVILLE ROCKFORD RD X DEAD END 2012083814 01:48:06 -CARDIAC (WITH PREVIOUS HISTORY) 24 YOA, DIFF BREATHING, CHEST PAINS, Radiating TO HER BACK.\r\n\n",
        "ADDR:36 TERRY CT 7",
        "CITY:COLLINSVILLE",
        "X:ROCKFORD RD / DEAD END",
        "ID:2012083814",
        "TIME:01:48:06",
        "INFO:CARDIAC (WITH PREVIOUS HISTORY) 24 YOA, DIFF BREATHING, CHEST PAINS, Radiating TO HER BACK.");

  }
  
  public static void main(String[] args) {
    new VAHenryCountyParserTest().generateTests("T1", "ADDR CITY X ID TIME UNIT CALL INFO");
  }
}