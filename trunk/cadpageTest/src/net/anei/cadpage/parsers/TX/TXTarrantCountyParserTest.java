package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXTarrantCountyParserTest extends BaseParserTest {
  
  public TXTarrantCountyParserTest() {
    setParser(new TXTarrantCountyParser(), "TARRANT COUNTY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "TRAUMA, GROUND LVL FALL: EMS FALL 99 YO/M  at 5604 N SCHILDER DR, RIVER OAKS  c/s: WALTER DR Box: 61S . . 10:12:42",
        "CALL:TRAUMA, GROUND LVL FALL",
        "INFO:EMS FALL 99 YO/M",
        "ADDR:5604 N SCHILDER DR",
        "CITY:RIVER OAKS",
        "X:WALTER DR",
        "BOX:61S",
        "TIME:10:12:42");

    doTest("T2",
        "STRUCTURE FIRE, Duplex/ Condo at 117 ST CLARE DR, TARRANT COUNTY c/s ST ELIZABETH DR Box 101U.. 23:57:40",
        "CALL:STRUCTURE FIRE, Duplex/ Condo",
        "ADDR:117 ST CLARE DR",
        "CITY:TARRANT COUNTY",
        "X:ST ELIZABETH DR",
        "BOX:101U",
        "TIME:23:57:40");

    doTest("T3",
        "MEDICAL, Cardiac Problem: 45 YO/F C&B, HAVING PALPITATIONS at 5130 BEN DAY MURRIN RD LOT 725, TARRANT COUNTY c/s: HWY 377 S Box: 99T. . 19:00:18",
        "CALL:MEDICAL, Cardiac Problem",
        "INFO:45 YO/F C&B, HAVING PALPITATIONS",
        "ADDR:5130 BEN DAY MURRIN RD",
        "APT:725",
        "CITY:TARRANT COUNTY",
        "X:HWY 377 S",
        "BOX:99T",
        "TIME:19:00:18");

    doTest("T4",
        "M V A, Unknown: DUMP TRUCK VS SUV, POSS DISMEMBERMENT at 7936 CONFEDERATE PARK RD, TARRANT COUNTY c/s: SILVER CREEK AZLE RD Box: 49P. . 17:25:51",
        "CALL:M V A, Unknown",
        "INFO:DUMP TRUCK VS SUV, POSS DISMEMBERMENT",
        "ADDR:7936 CONFEDERATE PARK RD",
        "CITY:TARRANT COUNTY",
        "X:SILVER CREEK AZLE RD",
        "BOX:49P",
        "TIME:17:25:51");

    doTest("T5",
        "GRASS FIRE, Single Station: REPORTED SMALL GRASS FIRE at 12100 OLD GRANBURY RD, TARRANT COUNTY c/s: FLOYD HAMPTON RD Box: 116X. . 17:30:33",
        "CALL:GRASS FIRE, Single Station",
        "INFO:REPORTED SMALL GRASS FIRE",
        "ADDR:12100 OLD GRANBURY RD",
        "CITY:TARRANT COUNTY",
        "X:FLOYD HAMPTON RD",
        "BOX:116X",
        "TIME:17:30:33");

    doTest("T6",
        "TRAUMA, GROUND LVL FALL: 80 YO/M FALL. HIP PAIN. C/B at 300 N OLD DECATUR RD, SAGINAW c/s: W MCLEROY BLVD Box: 33X O: FIRST BAPTIST CHURCH. . 10:52:00",
        "CALL:TRAUMA, GROUND LVL FALL",
        "INFO:80 YO/M FALL. HIP PAIN. C/B",
        "ADDR:300 N OLD DECATUR RD",
        "CITY:SAGINAW",
        "X:W MCLEROY BLVD",
        "BOX:33X",
        "PLACE:FIRST BAPTIST CHURCH",
        "TIME:10:52:00");

    doTest("T7",
        "MEDICAL, MEDICAL ALARM: NO ANSWER ON CALL BACK at 5913 ED COADY RD, EDGECLIFF VILLAGE c/s: SYCAMORE CREEK RD Box: 90Z. . 03:02:46",
        "CALL:MEDICAL, MEDICAL ALARM",
        "INFO:NO ANSWER ON CALL BACK",
        "ADDR:5913 ED COADY RD",
        "CITY:EDGECLIFF VILLAGE",
        "X:SYCAMORE CREEK RD",
        "BOX:90Z",
        "TIME:03:02:46");

  }
  
  public static void main(String[] args) {
    new TXTarrantCountyParserTest().generateTests("T1", "CALL INFO ADDR CITY X BOX PLACE TIME");
  }
}