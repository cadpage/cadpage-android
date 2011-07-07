package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSussexCountyParserTest extends BaseParserTest {
  
  public NJSussexCountyParserTest() {
    setParser(new NJSussexCountyParser(), "SUSSEX COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(I-B2011-004928) ALARMF @ 172 LACKAWANNA DRIVE  , BYRAM - PROTECTIVE SERVICES (800-633-2677) OPERATOR 1663. GENERAL FIRE.",
        "ID:I-B2011-004928",
        "CALL:ALARMF",
        "ADDR:172 LACKAWANNA DRIVE",
        "CITY:BYRAM",
        "INFO:PROTECTIVE SERVICES (800-633-2677) OPERATOR 1663. GENERAL FIRE.");

    doTest("T2",
        "[I-B2010-009210]  ALARMF @ 7 WATERLOO ROAD  , BYRAM - ALL AMERICAN CRAFT. ALARMS PLUS (800-932-3822) OPERATOR 1224. UTILITY ROOM",
        "ID:I-B2010-009210",
        "CALL:ALARMF",
        "ADDR:7 WATERLOO ROAD",
        "CITY:BYRAM",
        "INFO:ALL AMERICAN CRAFT. ALARMS PLUS (800-932-3822) OPERATOR 1224. UTILITY ROOM");

    doTest("T3",
        "[I-B2011-004688]  FIRE @ 33 SLEEPY HOLLOW ROAD  , BYRAM - CALLER REPORTS HIS LIVING ROOM IS SMOKING.",
        "ID:I-B2011-004688",
        "CALL:FIRE",
        "ADDR:33 SLEEPY HOLLOW ROAD",
        "CITY:BYRAM",
        "INFO:CALLER REPORTS HIS LIVING ROOM IS SMOKING.");

    doTest("T4",
        "(I-B2011-003217) FIREPD @ 4 MOUNTAIN AVENUE  , BYRAM - CALLER REPORTS THICK BLACK SMOKE COMING FROM THE RESIDENCE.",
        "ID:I-B2011-003217",
        "CALL:FIREPD",
        "ADDR:4 MOUNTAIN AVENUE",
        "CITY:BYRAM",
        "INFO:CALLER REPORTS THICK BLACK SMOKE COMING FROM THE RESIDENCE.");

    doTest("T5",
        "[I-B2011-000701]  FIRE @ 228 TOMAHAWK TRAIL  , BYRAM - STRUCTURE FIRE",
        "ID:I-B2011-000701",
        "CALL:FIRE",
        "ADDR:228 TOMAHAWK TRAIL",
        "CITY:BYRAM",
        "INFO:STRUCTURE FIRE");
 }
  
  public static void main(String[] args) {
    new NJSussexCountyParserTest().generateTests("T1", "ID CALL ADDR CITY INFO");
  }
}