package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Warren County, VA
Contact: Scott Richardson <srichardson@warrencountyfire.com>
Sender: mailbox@warrencountysheriff.org

MAILBOX:ST1C 12:22 FALL/FRACTURE 000061 ROYAL LN 1 FRO CFS# 2013-071404
MAILBOX:ST1C 12:11 MVA / UNKNOWN INJURY 000000 NEWTON DR LIN CFS# 2013-071402
MAILBOX:ST1C 11:43 DISORIENTED 000277 APPALACHIAN LN LIN CFS# 2013-071398 CROSS: FREEZELAND RD
MAILBOX:ST1C 10:27 CHANGE IN MENTAL STATUS 000408 SOUTH ST FRO CFS# 2013-071395 CROSS: S COMMERCE AVE/S ROYAL AVE
MAILBOX:ST1C 10:04 BREATHING DIFFICULTY 000675 MCCOYS FORD RD FRO CFS# 2013-071394 CROSS: EAGLE DR/POWELL LANE

 */
public class VAWarrenCountyParserTest extends BaseParserTest {
  
  public VAWarrenCountyParserTest() {
    setParser(new VAWarrenCountyParser(), "WARREN COUNTY", "VA");
  }
  
  @Test
  public void testScottRichardson() {

    doTest("T1",
        "MAILBOX:ST1C 12:22 FALL/FRACTURE 000061 ROYAL LN 1 FRO CFS# 2013-071404",
        "SRC:ST1C",
        "TIME:12:22",
        "CALL:FALL/FRACTURE",
        "ADDR:61 ROYAL LN 1",
        "CITY:FRONT ROYAL",
        "ID:2013-071404");

    doTest("T2",
        "MAILBOX:ST1C 12:11 MVA / UNKNOWN INJURY 000000 NEWTON DR LIN CFS# 2013-071402",
        "SRC:ST1C",
        "TIME:12:11",
        "CALL:MVA / UNKNOWN INJURY",
        "ADDR:NEWTON DR",
        "CITY:LINDEN",
        "ID:2013-071402");

    doTest("T3",
        "MAILBOX:ST1C 11:43 DISORIENTED 000277 APPALACHIAN LN LIN CFS# 2013-071398 CROSS: FREEZELAND RD",
        "SRC:ST1C",
        "TIME:11:43",
        "CALL:DISORIENTED",
        "ADDR:277 APPALACHIAN LN",
        "CITY:LINDEN",
        "ID:2013-071398",
        "X:FREEZELAND RD");

    doTest("T4",
        "MAILBOX:ST1C 10:27 CHANGE IN MENTAL STATUS 000408 SOUTH ST FRO CFS# 2013-071395 CROSS: S COMMERCE AVE/S ROYAL AVE",
        "SRC:ST1C",
        "TIME:10:27",
        "CALL:CHANGE IN MENTAL STATUS",
        "ADDR:408 SOUTH ST",
        "CITY:FRONT ROYAL",
        "ID:2013-071395",
        "X:S COMMERCE AVE/S ROYAL AVE");

    doTest("T5",
        "MAILBOX:ST1C 10:04 BREATHING DIFFICULTY 000675 MCCOYS FORD RD FRO CFS# 2013-071394 CROSS: EAGLE DR/POWELL LANE",
        "SRC:ST1C",
        "TIME:10:04",
        "CALL:BREATHING DIFFICULTY",
        "ADDR:675 MCCOYS FORD RD",
        "CITY:FRONT ROYAL",
        "ID:2013-071394",
        "X:EAGLE DR/POWELL LANE");

  }
  
  public static void main(String args[]) {
    new VAWarrenCountyParserTest().generateTests("T1");
  }
}
  