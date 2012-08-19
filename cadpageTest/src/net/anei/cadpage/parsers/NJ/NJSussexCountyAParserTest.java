package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NJSussexCountyAParserTest extends BaseParserTest {
  
  public NJSussexCountyAParserTest() {
    setParser(new NJSussexCountyAParser(), "SUSSEX COUNTY", "NJ");
  }
  
  @Test
  public void testParser1() {

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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "KBROWN@andpd (I-2011-000118) MVA-F @ DECKER POND ROAD/SUNSET DRIVE  , GREEN TWP - CAR VS GUARDRAIL - MINOR INJURIES.",
        "ID:I-2011-000118",
        "CALL:MVA-F",
        "ADDR:DECKER POND ROAD & SUNSET DRIVE",
        "CITY:GREEN TWP",
        "INFO:CAR VS GUARDRAIL - MINOR INJURIES.");

    doTest("T2",
        "KBROWN@andpd (I-2011-000121) MVA-F @ HIBLER ROAD/WINTERMUTE ROAD  , GREEN TWP - CALLER REPORTING MOTORCYCLE MVA -- CALLER STATES APPEARS NO L",
        "ID:I-2011-000121",
        "CALL:MVA-F",
        "ADDR:HIBLER ROAD & WINTERMUTE ROAD",
        "CITY:GREEN TWP",
        "INFO:CALLER REPORTING MOTORCYCLE MVA -- CALLER STATES APPEARS NO L");

    setDefaults("", "");
    doTest("T3",
        "dcrater@andpd (I-2011-000117) ASSIST-F @  OUT OF TOWN  ,  - 44 KISHPAUGH RD FULLY INVOLVED STRUCTURE",
        "ID:I-2011-000117",
        "CALL:ASSIST-F",
        "ADDR:44 KISHPAUGH RD",
        "INFO:FULLY INVOLVED STRUCTURE");
    setDefaults("SUSSEX COUNTY", "NJ");

    doTest("T4",
        "kwilson@andpd (I-2011-000099) BURN-F @ 1 SCENIC DRIVE  , GREEN TWP - permit: A-3251 burning all day ** DO NOT RESPOND**",
        "ID:I-2011-000099",
        "CALL:BURN-F",
        "ADDR:1 SCENIC DRIVE",
        "CITY:GREEN TWP",
        "INFO:permit: A-3251 burning all day ** DO NOT RESPOND**");

    doTest("T5",
        "jcasella@andpd (I-2011-000122) MVA-F @ 21 SUTTON ROAD  , GREEN TWP - CAR VS TREE",
        "ID:I-2011-000122",
        "CALL:MVA-F",
        "ADDR:21 SUTTON ROAD",
        "CITY:GREEN TWP",
        "INFO:CAR VS TREE");

    doTest("T6",
        "jragsdale@andpd (I-2011-000108) TRANSF @ 71 WOLFS CORNER ROAD  , GREEN TWP - MUNICIPAL BLDG CALLED- HAS PASSERBY ADV OF TRANSFORMER FIRE hasEML = false;",
        "ID:I-2011-000108",
        "CALL:TRANSF",
        "ADDR:71 WOLFS CORNER ROAD",
        "CITY:GREEN TWP",
        "INFO:MUNICIPAL BLDG CALLED- HAS PASSERBY ADV OF TRANSFORMER FIRE hasEML = false;");

    doTest("T7",
        "kbrown@andpd (I-2011-000155) PUMP @ 6 RAMSEY COURT  , FRELINGHUYSEN - WARREN COUNTY COMMUNICATIONS REQUESTING A PUMP OUT FOR THE FOOT OF WATER IN BASEMENT.",
        "ID:I-2011-000155",
        "CALL:PUMP",
        "ADDR:6 RAMSEY COURT",
        "CITY:FRELINGHUYSEN",
        "INFO:WARREN COUNTY COMMUNICATIONS REQUESTING A PUMP OUT FOR THE FOOT OF WATER IN BASEMENT.");

    doTest("T8",
        "jcasella@andpd (I-2011-000194) MVA-F @  ROUTE 94  , GREEN TWP - \nin front of wilbur's country storE",
        "ID:I-2011-000194",
        "CALL:MVA-F",
        "ADDR:ROUTE 94",
        "CITY:GREEN TWP",
        "INFO:in front of wilbur's country storE");

    doTest("T9",
        "JHOLMES@andpd (I-2011-000217) FUEL @ 231 PEQUEST ROAD  , GREEN TWP -",
        "ID:I-2011-000217",
        "CALL:FUEL",
        "ADDR:231 PEQUEST ROAD",
        "CITY:GREEN TWP");
 }
  
  @Test
  public void testNewMilford() {

    doTest("T1",
        "(I-2012-000063)FDPLANE @ 636 SCHAEFER AVENUE , ORADELL BORO - PLANE CRASH INTO HOT TUB TEST TEST TEST",
        "ID:I-2012-000063",
        "CALL:FDPLANE",
        "ADDR:636 SCHAEFER AVENUE",
        "CITY:ORADELL BORO",
        "INFO:PLANE CRASH INTO HOT TUB TEST TEST TEST");

    doTest("T2",
        "(I-2012-000063)FFIRA @ 105 OLD NEW BRIDGE ROAD  , NEW MILFORD BORO - WATER FLOW ALARM AT ZANZARI'S ",
        "ID:I-2012-000063",
        "CALL:FFIRA",
        "ADDR:105 OLD NEW BRIDGE ROAD",
        "CITY:NEW MILFORD BORO",
        "INFO:WATER FLOW ALARM AT ZANZARI'S");

    doTest("T3",
        "(I-2012-000067)FBRSH @ 413 BOULEVARD  , NEW MILFORD BORO - ",
        "ID:I-2012-000067",
        "CALL:FBRSH",
        "ADDR:413 BOULEVARD",
        "CITY:NEW MILFORD BORO");

  }
  
  @Test
  public void testOradel() {

    doTest("T1",
        "(I-2012-000192) FFIRA @ 386 KINDERKAMACK ROAD  , ORADELL BORO - zone 2 apartment back",
        "ID:I-2012-000192",
        "CALL:FFIRA",
        "ADDR:386 KINDERKAMACK ROAD",
        "CITY:ORADELL BORO",
        "INFO:zone 2 apartment back");

    doTest("T2",
        "(I-2012-000193) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - ",
        "ID:I-2012-000193",
        "CALL:FFIRA",
        "ADDR:549 CORBETT PLACE",
        "CITY:ORADELL BORO");

    doTest("T3",
        "(I-2012-000194) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - GENERAL",
        "ID:I-2012-000194",
        "CALL:FFIRA",
        "ADDR:549 CORBETT PLACE",
        "CITY:ORADELL BORO",
        "INFO:GENERAL");

  }
  
  public static void main(String[] args) {
    new NJSussexCountyAParserTest().generateTests("T1", "ID CALL ADDR CITY INFO");
  }
}