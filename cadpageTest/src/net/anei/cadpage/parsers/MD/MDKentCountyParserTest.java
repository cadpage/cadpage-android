package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDKentCountyParser;

import org.junit.Test;

/*
Kent County, MD
Contact: Travis Nelson <tnelson5135@gmail.com>
Sender: 911@kentgov.org
System: PSSI

CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:MVC/PT NOT ALERT W CAMPUS AVE / WASHINGTON AVE  BOX:6001 DUE:E6 R6 A8 PM1-1
CT:CARDIAC ARREST 25129 WYMONT PARK RD  BOX:5005 DUE:A8
CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:UNCON/SYNCOPAL 818 HIGH ST  BOX:6001 DUE:A8 PM1-1
CT:EMOTIONAL DISORDER 104 VICKERS DR @KENT CO DETENTION CE  BOX:6001 DUE:A81
CT:ALLERGIC REACTION TACO BELL/KFC @709 WASHINGTON AVE  BOX:6001 DUE:A8 PM1-1
CT:MVC RT 213 / RT 291  BOX:6001 DUE:RA8E
CT:MVC MORGNEC RD / TALBOT BLVD  BOX:6001 DUE:E6 A8 PM1-1
CT:STRUCTURE FIRE 408 MORGNEC RD APT 103  BOX:6001 DUE:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1
CT:CHEST PAIN 11673 KENNEDYVILLE RD  BOX:4002 DUE:E4 A8 PM1-1

Contact: "jahurlock@cvfd7.com" <jahurlock@cvfd7.com>
Sender: 911@kentgov.org
(CAD) CT:STRUCTURE FIRE 205 ROOSEVELT DR  BOX:6001 DUE:RA6F

*/

public class MDKentCountyParserTest extends BaseParserTest {
  
  public MDKentCountyParserTest() {
    setParser(new MDKentCountyParser(), "KENT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "CALL:ASSAULT",
        "ADDR:835 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T2",
        "CT:MVC/PT NOT ALERT W CAMPUS AVE / WASHINGTON AVE  BOX:6001 DUE:E6 R6 A8 PM1-1",
        "CALL:MVC/PT NOT ALERT",
        "ADDR:W CAMPUS AVE & WASHINGTON AVE",
        "BOX:6001",
        "UNIT:E6 R6 A8 PM1-1");

    doTest("T3",
        "CT:CARDIAC ARREST 25129 WYMONT PARK RD  BOX:5005 DUE:A8",
        "CALL:CARDIAC ARREST",
        "ADDR:25129 WYMONT PARK RD",
        "BOX:5005",
        "UNIT:A8");

    doTest("T4",
        "CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "CALL:ASSAULT",
        "ADDR:835 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T5",
        "CT:UNCON/SYNCOPAL 818 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "CALL:UNCON/SYNCOPAL",
        "ADDR:818 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T6",
        "CT:EMOTIONAL DISORDER 104 VICKERS DR @KENT CO DETENTION CE  BOX:6001 DUE:A81",
        "CALL:EMOTIONAL DISORDER",
        "ADDR:104 VICKERS DR",
        "PLACE:KENT CO DETENTION CE",
        "BOX:6001",
        "UNIT:A81");

    doTest("T7",
        "CT:ALLERGIC REACTION TACO BELL/KFC @709 WASHINGTON AVE  BOX:6001 DUE:A8 PM1-1",
        "CALL:ALLERGIC REACTION TACO BELL/KFC",
        "ADDR:709 WASHINGTON AVE",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T8",
        "CT:MVC RT 213 / RT 291  BOX:6001 DUE:RA8E",
        "CALL:MVC",
        "ADDR:RT 213 & RT 291",
        "BOX:6001",
        "UNIT:RA8E");

    doTest("T9",
        "CT:MVC MORGNEC RD / TALBOT BLVD  BOX:6001 DUE:E6 A8 PM1-1",
        "CALL:MVC",
        "ADDR:MORGNEC RD & TALBOT BLVD",
        "BOX:6001",
        "UNIT:E6 A8 PM1-1");

    doTest("T10",
        "CT:STRUCTURE FIRE 408 MORGNEC RD APT 103  BOX:6001 DUE:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1",
        "CALL:STRUCTURE FIRE",
        "ADDR:408 MORGNEC RD",
        "BOX:6001",
        "APT:103",
        "UNIT:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1");

    doTest("T11",
        "CT:CHEST PAIN 11673 KENNEDYVILLE RD  BOX:4002 DUE:E4 A8 PM1-1",
        "CALL:CHEST PAIN",
        "ADDR:11673 KENNEDYVILLE RD",
        "BOX:4002",
        "UNIT:E4 A8 PM1-1");

    doTest("T12",
        "(CAD) CT:STRUCTURE FIRE 205 ROOSEVELT DR  BOX:6001 DUE:RA6F",
        "CALL:STRUCTURE FIRE",
        "ADDR:205 ROOSEVELT DR",
        "BOX:6001",
        "UNIT:RA6F");
 
  }
  
  public static void main(String[] args) {
    new MDKentCountyParserTest().generateTests("T1");
  }
}
