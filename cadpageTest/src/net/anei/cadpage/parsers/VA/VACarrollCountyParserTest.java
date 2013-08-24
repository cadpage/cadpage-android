package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Carroll County, VA
Contact:  Corey Scearce <csmedic85@gmail.com>
Sender: MAILBOX@GalaxVa.com

MAILBOX:CANARS 17:23 EMS - PAIN 000000 S I-77 CFS# 2013-001974 CROSS: EX 14 CARROLLTON PIKE/EX 8 CHANCES CREEK RD
MAILBOX:CANARS 17:55 EMS - DIABETIC 000126 MAYES DR CFS# 2013-001987
MAILBOX@GalaxVa.com MAILBOX:CANARS 19:47 EMS - BREATHING DIFFICULTY 000000 S I-77 CFS# 2013-002044 CROSS: EX 8 CHANCES CREEK RD/EX 1 LAMBSBURG RD
MAILBOX:CANARS 00:49 FIRE - ELECTRICAL 005613 CHANCES CREEK RD CFS# 2013-002102
MAILBOX:CANARS 23:16 EMS - NAUSEA / VOMITING 000021 BECKY'S LN CFS# 2013-001739
MAILBOX:CANARS 20:23 FIRE - VEHICLE 000000 FISH LAKE RD CFS# 2013-001732

*/
public class VACarrollCountyParserTest extends BaseParserTest {
  
  public VACarrollCountyParserTest() {
    setParser(new VACarrollCountyParser(), "CARROLL COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MAILBOX:CANARS 17:23 EMS - PAIN 000000 S I-77 CFS# 2013-001974 CROSS: EX 14 CARROLLTON PIKE/EX 8 CHANCES CREEK RD",
        "SRC:CANARS",
        "TIME:17:23",
        "CALL:EMS - PAIN",
        "ADDR:S I-77",
        "MADDR:S I 77 & EX 14 CARROLLTON PIKE",
        "ID:2013-001974",
        "X:EX 14 CARROLLTON PIKE/EX 8 CHANCES CREEK RD");

    doTest("T2",
        "MAILBOX:CANARS 17:55 EMS - DIABETIC 000126 MAYES DR CFS# 2013-001987",
        "SRC:CANARS",
        "TIME:17:55",
        "CALL:EMS - DIABETIC",
        "ADDR:126 MAYES DR",
        "ID:2013-001987");

    doTest("T3",
        "MAILBOX@GalaxVa.com MAILBOX:CANARS 19:47 EMS - BREATHING DIFFICULTY 000000 S I-77 CFS# 2013-002044 CROSS: EX 8 CHANCES CREEK RD/EX 1 LAMBSBURG RD",
        "SRC:CANARS",
        "TIME:19:47",
        "CALL:EMS - BREATHING DIFFICULTY",
        "ADDR:S I-77",
        "MADDR:S I 77 & EX 8 CHANCES CREEK RD",
        "ID:2013-002044",
        "X:EX 8 CHANCES CREEK RD/EX 1 LAMBSBURG RD");

    doTest("T4",
        "MAILBOX:CANARS 00:49 FIRE - ELECTRICAL 005613 CHANCES CREEK RD CFS# 2013-002102",
        "SRC:CANARS",
        "TIME:00:49",
        "CALL:FIRE - ELECTRICAL",
        "ADDR:5613 CHANCES CREEK RD",
        "ID:2013-002102");

    doTest("T5",
        "MAILBOX:CANARS 23:16 EMS - NAUSEA / VOMITING 000021 BECKY'S LN CFS# 2013-001739",
        "SRC:CANARS",
        "TIME:23:16",
        "CALL:EMS - NAUSEA / VOMITING",
        "ADDR:21 BECKY'S LN",
        "ID:2013-001739");

    doTest("T6",
        "MAILBOX:CANARS 20:23 FIRE - VEHICLE 000000 FISH LAKE RD CFS# 2013-001732",
        "SRC:CANARS",
        "TIME:20:23",
        "CALL:FIRE - VEHICLE",
        "ADDR:FISH LAKE RD",
        "ID:2013-001732");

 }
  
  public static void main(String[] args) {
    new VACarrollCountyParserTest().generateTests("T1");
  }
}