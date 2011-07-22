package net.anei.cadpage.parsers.MD;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.MD.MDKentCountyParser;

import org.junit.Test;


public class MDKentCountyParserTest extends BaseParserTest {
  
  public MDKentCountyParserTest() {
    setParser(new MDKentCountyParser(), "KENT COUNTY", "MD");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "ADDR:ASSAULT 835 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T2",
        "CT:MVC/PT NOT ALERT W CAMPUS AVE / WASHINGTON AVE  BOX:6001 DUE:E6 R6 A8 PM1-1",
        "ADDR:MVC & PT NOT ALERT W CAMPUS AVE & WASHINGTON AVE",
        "BOX:6001",
        "UNIT:E6 R6 A8 PM1-1");

    doTest("T3",
        "CT:CARDIAC ARREST 25129 WYMONT PARK RD  BOX:5005 DUE:A8",
        "ADDR:CARDIAC ARREST 25129 WYMONT PARK RD",
        "BOX:5005",
        "UNIT:A8");

    doTest("T4",
        "CT:ASSAULT 835 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "ADDR:ASSAULT 835 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T5",
        "CT:UNCON/SYNCOPAL 818 HIGH ST  BOX:6001 DUE:A8 PM1-1",
        "ADDR:UNCON & SYNCOPAL 818 HIGH ST",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T6",
        "CT:EMOTIONAL DISORDER 104 VICKERS DR @KENT CO DETENTION CE  BOX:6001 DUE:A81",
        "ADDR:EMOTIONAL DISORDER 104 VICKERS DR @KENT CO DETENTION CE",
        "BOX:6001",
        "UNIT:A81");

    doTest("T7",
        "CT:ALLERGIC REACTION TACO BELL/KFC @709 WASHINGTON AVE  BOX:6001 DUE:A8 PM1-1",
        "ADDR:ALLERGIC REACTION TACO BELL & KFC @709 WASHINGTON AVE",
        "BOX:6001",
        "UNIT:A8 PM1-1");

    doTest("T8",
        "CT:MVC RT 213 / RT 291  BOX:6001 DUE:RA8E",
        "ADDR:MVC RT 213 & RT 291",
        "BOX:6001",
        "UNIT:RA8E");

    doTest("T9",
        "CT:MVC MORGNEC RD / TALBOT BLVD  BOX:6001 DUE:E6 A8 PM1-1",
        "ADDR:MVC MORGNEC RD & TALBOT BLVD",
        "BOX:6001",
        "UNIT:E6 A8 PM1-1");

    doTest("T10",
        "CT:STRUCTURE FIRE 408 MORGNEC RD APT 103  BOX:6001 DUE:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1",
        "ADDR:STRUCTURE FIRE 408 MORGNEC RD",
        "BOX:6001",
        "APT:103",
        "UNIT:E6 E4 QAE71 QAE52 TWR6 QATWL5 R6 RP4 A8 A81 PM1-1");

    doTest("T11",
        "CT:CHEST PAIN 11673 KENNEDYVILLE RD  BOX:4002 DUE:E4 A8 PM1-1",
        "ADDR:CHEST PAIN 11673 KENNEDYVILLE RD",
        "BOX:4002",
        "UNIT:E4 A8 PM1-1");
  
  }
  
  public static void main(String[] args) {
    new MDKentCountyParserTest().generateTests("T1", "ADDR BOX UNIT");
  }
}
