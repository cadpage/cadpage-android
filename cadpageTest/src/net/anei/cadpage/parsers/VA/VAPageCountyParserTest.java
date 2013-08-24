package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Page County, VA
Contact: Shane Taylor <hm88jr@gmail.com>
Sender: 93001045

MAILBOX:RS3 PAIN 16 E MAIN ST LUR CFS# 2011-000782 CROSS: BROAD ST/TANNERY RD
MAILBOX:RS4 CHEST PAINS 185 GRAY DR STA CFS# 2011-004572 CROSS: AYLOR GRUBBS AV
MAILBOX:RS1 GENERAL ILLNESS 117 PULASKI AV SHE CFS# 2011-004542 CROSS: S SECOND ST/FRONT ST

Contact: Ben Zimmerman <zimmerbm@gmail.com>
MAILBOX:CO24 COMMERCIAL ALARM 525 MIDDLEBURG RD STA CFS# 2011-005247 CROSS: US HWY BSN 340/GOODRICH RD

Contact: Lindsey Sullivan <lds2011.ls@gmail.com>
Sender: MAILBOX@pagesheriff.COM
(RS1 INJURIES FROM A FALL 4472  US HWY 340    SHE  CFS# 2011-016573 CROSS) MAILBOX:HIDEAWAY LN/NEWPORT RD

Contact: greg seal <grgifts02@yahoo.com>
Sender: MAILBOX@hrecc.org
R30 TRAFFIC CRASH 14171 SPOTSWOOD TRL ELK CFS# 2011-066741 CROSS: WALKING HORSE LN/MOUNT HERMON RD

Contact: Shane Taylor <vtdb8829taylor@gmail.com>
Sender: MAILBOX@hrecc.org
R35 EMS-ILLNESS 201 HILL AVE ELK CFS# 2011-073441 CROSS: W C ST/W D ST

Contact: Shannon Freeze <sfreeze435@gmail.com>
Sender: +15402446442
MAILBOX:RS4 TRAFFIC CRASH US HWY CFS# 2012-004561

Contact: Shawn <shawngochenour3@aol.com>
Sender: MAILBOX@pagesheriff.COM
MAILBOX:RS4 DIZZINESS 1036 US HWY 211 W LUR CFS# 2012-021955 CROSS: W MAIN ST/SPIROS LN

*/
public class VAPageCountyParserTest extends BaseParserTest {
  
  public VAPageCountyParserTest() {
    setParser(new VAPageCountyParser(), "PAGE COUNTY", "VA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MAILBOX:RS3 PAIN 16 E MAIN ST LUR CFS# 2011-000782 CROSS: BROAD ST/TANNERY RD",
        "SRC:RS3",
        "CALL:PAIN",
        "ADDR:16 E MAIN ST",
        "CITY:LURAY",
        "ID:2011-000782",
        "X:BROAD ST/TANNERY RD");

    doTest("T2",
        "MAILBOX:RS4 CHEST PAINS 185 GRAY DR STA CFS# 2011-004572 CROSS: AYLOR GRUBBS AV",
        "SRC:RS4",
        "CALL:CHEST PAINS",
        "ADDR:185 GRAY DR",
        "CITY:STANLEY",
        "ID:2011-004572",
        "X:AYLOR GRUBBS AV");

    doTest("T3",
        "MAILBOX:RS1 GENERAL ILLNESS 117 PULASKI AV SHE CFS# 2011-004542 CROSS: S SECOND ST/FRONT ST",
        "SRC:RS1",
        "CALL:GENERAL ILLNESS",
        "ADDR:117 PULASKI AV",
        "MADDR:117 PULASKI AVE",
        "CITY:SHENANDOAH",
        "ID:2011-004542",
        "X:S SECOND ST/FRONT ST");

    doTest("T4",
        "MAILBOX:CO24 COMMERCIAL ALARM 525 MIDDLEBURG RD STA CFS# 2011-005247 CROSS: US HWY BSN 340/GOODRICH RD",
        "SRC:CO24",
        "CALL:COMMERCIAL ALARM",
        "ADDR:525 MIDDLEBURG RD",
        "CITY:STANLEY",
        "ID:2011-005247",
        "X:US HWY BSN 340/GOODRICH RD");

    doTest("T5",
        "(RS1 INJURIES FROM A FALL 4472  US HWY 340    SHE  CFS# 2011-016573 CROSS) MAILBOX:HIDEAWAY LN/NEWPORT RD",
        "SRC:RS1",
        "CALL:INJURIES FROM A FALL",
        "ADDR:4472 US HWY 340",
        "MADDR:4472 US 340",
        "CITY:SHENANDOAH",
        "ID:2011-016573",
        "X:HIDEAWAY LN/NEWPORT RD");

    doTest("T6",
        "R30 TRAFFIC CRASH 14171 SPOTSWOOD TRL ELK CFS# 2011-066741 CROSS: WALKING HORSE LN/MOUNT HERMON RD",
        "SRC:R30",
        "CALL:TRAFFIC CRASH",
        "ADDR:14171 SPOTSWOOD TRL",
        "CITY:ELKTON",
        "ID:2011-066741",
        "X:WALKING HORSE LN/MOUNT HERMON RD");

    doTest("T7",
        "R35 EMS-ILLNESS 201 HILL AVE ELK CFS# 2011-073441 CROSS: W C ST/W D ST",
        "SRC:R35",
        "CALL:EMS-ILLNESS",
        "ADDR:201 HILL AVE",
        "CITY:ELKTON",
        "ID:2011-073441",
        "X:W C ST/W D ST");

    doTest("T8",
        "MAILBOX:RS4 TRAFFIC CRASH US HWY CFS# 2012-004561",
        "SRC:RS4",
        "CALL:TRAFFIC CRASH",
        "ADDR:US HWY",
        "ID:2012-004561");

    doTest("T9",
        "MAILBOX:RS4 DIZZINESS 1036 US HWY 211 W LUR CFS# 2012-021955 CROSS: W MAIN ST/SPIROS LN",
        "SRC:RS4",
        "CALL:DIZZINESS",
        "ADDR:1036 US HWY 211 W",
        "MADDR:1036 US 211 W",
        "CITY:LURAY",
        "ID:2012-021955",
        "X:W MAIN ST/SPIROS LN");

 }
  
  public static void main(String[] args) {
    new VAPageCountyParserTest().generateTests("T1");
  }
}