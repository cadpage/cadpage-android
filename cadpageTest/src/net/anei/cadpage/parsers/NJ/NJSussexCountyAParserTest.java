package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Sussex County, NJ (Bryam TWP FD)  (Sparta Dispatch - not entire county but 8 departments)
Contact:Todd Rudloff <btfd43capt2@gmail.com>

(I-B2011-004928) ALARMF @ 172 LACKAWANNA DRIVE  , BYRAM - PROTECTIVE SERVICES (800-633-2677) OPERATOR 1663. GENERAL FIRE.
[I-B2010-009210]  ALARMF @ 7 WATERLOO ROAD  , BYRAM - ALL AMERICAN CRAFT. ALARMS PLUS (800-932-3822) OPERATOR 1224. UTILITY ROOM
[I-B2011-004688]  FIRE @ 33 SLEEPY HOLLOW ROAD  , BYRAM - CALLER REPORTS HIS LIVING ROOM IS SMOKING.
(I-B2011-003217) FIREPD @ 4 MOUNTAIN AVENUE  , BYRAM - CALLER REPORTS THICK BLACK SMOKE COMING FROM THE RESIDENCE.
[I-B2011-000701]  FIRE @ 228 TOMAHAWK TRAIL  , BYRAM - STRUCTURE FIRE

Contact: Michael Rafferty <mpraff15@yahoo.com>
KBROWN@andpd (I-2011-000118) MVA-F @ DECKER POND ROAD/SUNSET DRIVE  , GREEN TWP - CAR VS GUARDRAIL - MINOR INJURIES.
KBROWN@andpd (I-2011-000121) MVA-F @ HIBLER ROAD/WINTERMUTE ROAD  , GREEN TWP - CALLER REPORTING MOTORCYCLE MVA -- CALLER STATES APPEARS NO L
dcrater@andpd (I-2011-000117) ASSIST-F @  OUT OF TOWN  ,  - 44 KISHPAUGH RD FULLY INVOLVED STRUCTURE
kwilson@andpd (I-2011-000099) BURN-F @ 1 SCENIC DRIVE  , GREEN TWP - permit: A-3251 burning all day ** DO NOT RESPOND**
jcasella@andpd (I-2011-000122) MVA-F @ 21 SUTTON ROAD  , GREEN TWP - CAR VS TREE
jragsdale@andpd (I-2011-000108) TRANSF @ 71 WOLFS CORNER ROAD  , GREEN TWP - MUNICIPAL BLDG CALLED- HAS PASSERBY ADV OF TRANSFORMER FIRE hasEML = false;

Contact: mpraff15 <mpraff15@gmail.com>
Sender: 6245
kbrown@andpd (I-2011-000155) PUMP @ 6 RAMSEY COURT  , FRELINGHUYSEN - WARREN COUNTY COMMUNICATIONS REQUESTING A PUMP OUT FOR THE FOOT OF WATER IN BASEMENT.
jcasella@andpd (I-2011-000194) MVA-F @  ROUTE 94  , GREEN TWP - \nin front of wilbur's country storE
JHOLMES@andpd (I-2011-000217) FUEL @ 231 PEQUEST ROAD  , GREEN TWP -

New Milford, NJ
Contact: Active911.com
Sender: miccom@nnjmicu.org <miccom@nnjmicu.org>
(I-2012-000063)FDPLANE @ 636 SCHAEFER AVENUE , ORADELL BORO - PLANE CRASH INTO HOT TUB TEST TEST TEST
(I-2012-000063)FFIRA @ 105 OLD NEW BRIDGE ROAD  , NEW MILFORD BORO - WATER FLOW ALARM AT ZANZARI'S 
(I-2012-000067)FBRSH @ 413 BOULEVARD  , NEW MILFORD BORO - 

Contact: Active911.com
Agency name: Oradell Fire Department Location: Oradell, NJ
Sender: @nwbcd.org 
(I-2012-000192) FFIRA @ 386 KINDERKAMACK ROAD  , ORADELL BORO - zone 2 apartment back
(I-2012-000193) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - 
(I-2012-000194) FFIRA @ 549 CORBETT PLACE  , ORADELL BORO - GENERAL

Contact: Active911
Agency name: Fort Lee Fire Department Location: Fort Lee, NJ 
Sender: @fortleepolice.org

(I-2012-000814) 1045F @ 1350 15TH STREET  , FORT LEE - garage, north and south, waterflow
(I-2012-000815) 1045F @ 250 HOYM STREET  , FORT LEE - 1ST FL HOYM SIDE
(I-2012-000816) 1045F @ 1616 PALISADE AVENUE  , FORT LEE - ZONE 0 AND 2ND FL MENS RM SMOKE
(I-2012-000817) 1045F @ 250 HOYM STREET  , FORT LEE - 2ND FL HOYM ST WING
(I-2012-000818) 1045F @ 1 HORIZON ROAD  , FORT LEE - fan room
(I-2012-000819) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - LL Level
(I-2012-000820) 1045F @ 1081 INWOOD TERRACE  , FORT LEE - Cheung - smoke detector
(I-2012-000821) 1045F @ 1115 BUCKINGHAM ROAD  , FORT LEE - OFFICE SMOKE DETECTOR
(I-2012-000822) 1045F @ 3021 EDWIN AVENUE  , FORT LEE - 5th floor elevator activation
(I-2012-000823) 1035 @ 3081 EDWIN AVENUE  , FORT LEE - Reported Stuck Occupied Elevator between 3rd. & 4th. flrs.
(I-2012-000824) 1037 @  ROUTE 95 NORTH  , FORT LEE - Leonia Boro, rt 95 north express 120.7 -...\n\nActive Units: FL-R
(I-2012-000825) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - penthouse activation
(I-2012-000826) 1045F @ 1600 PARKER AVENUE  , FORT LEE - General alarm
(I-2012-000827) 1032 @ 2170 FLETCHER AVENUE  , FORT LEE - report of vehicle fire in taco bell parking lot, 551-574-0053
(I-2012-000828) 1033 @ 1 PIP  , FORT LEE - brush fire  caller is by cannons
(I-2012-000829) 1045F @ 2053 ELLERY AVENUE  , FORT LEE - First fl smoke Canerparo residence   apt. building   alarm co to noty   owner cell  854-304-3491
(I-2012-000830) 1035 @ 1000 OVERLOOK DRIVE  , FORT LEE - check for blocked fire exit, on south side of 2nd floor, previously reported to management, 908-249-2449, mr. lacher.
(I-2012-000831) 1045F @ 2 HORIZON ROAD  , FORT LEE - laundry room 8 and basement north

 */

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
  
  @Test
  public void testFortLee() {

    doTest("T1",
        "(I-2012-000814) 1045F @ 1350 15TH STREET  , FORT LEE - garage, north and south, waterflow",
        "ID:I-2012-000814",
        "CALL:1045F",
        "ADDR:1350 15TH STREET",
        "CITY:FORT LEE",
        "INFO:garage, north and south, waterflow");

    doTest("T2",
        "(I-2012-000815) 1045F @ 250 HOYM STREET  , FORT LEE - 1ST FL HOYM SIDE",
        "ID:I-2012-000815",
        "CALL:1045F",
        "ADDR:250 HOYM STREET",
        "CITY:FORT LEE",
        "INFO:1ST FL HOYM SIDE");

    doTest("T3",
        "(I-2012-000816) 1045F @ 1616 PALISADE AVENUE  , FORT LEE - ZONE 0 AND 2ND FL MENS RM SMOKE",
        "ID:I-2012-000816",
        "CALL:1045F",
        "ADDR:1616 PALISADE AVENUE",
        "CITY:FORT LEE",
        "INFO:ZONE 0 AND 2ND FL MENS RM SMOKE");

    doTest("T4",
        "(I-2012-000817) 1045F @ 250 HOYM STREET  , FORT LEE - 2ND FL HOYM ST WING",
        "ID:I-2012-000817",
        "CALL:1045F",
        "ADDR:250 HOYM STREET",
        "CITY:FORT LEE",
        "INFO:2ND FL HOYM ST WING");

    doTest("T5",
        "(I-2012-000818) 1045F @ 1 HORIZON ROAD  , FORT LEE - fan room",
        "ID:I-2012-000818",
        "CALL:1045F",
        "ADDR:1 HORIZON ROAD",
        "CITY:FORT LEE",
        "INFO:fan room");

    doTest("T6",
        "(I-2012-000819) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - LL Level",
        "ID:I-2012-000819",
        "CALL:1045F",
        "ADDR:1 EXECUTIVE DRIVE",
        "CITY:FORT LEE",
        "INFO:LL Level");

    doTest("T7",
        "(I-2012-000820) 1045F @ 1081 INWOOD TERRACE  , FORT LEE - Cheung - smoke detector",
        "ID:I-2012-000820",
        "CALL:1045F",
        "ADDR:1081 INWOOD TERRACE",
        "CITY:FORT LEE",
        "INFO:Cheung - smoke detector");

    doTest("T8",
        "(I-2012-000821) 1045F @ 1115 BUCKINGHAM ROAD  , FORT LEE - OFFICE SMOKE DETECTOR",
        "ID:I-2012-000821",
        "CALL:1045F",
        "ADDR:1115 BUCKINGHAM ROAD",
        "CITY:FORT LEE",
        "INFO:OFFICE SMOKE DETECTOR");

    doTest("T9",
        "(I-2012-000822) 1045F @ 3021 EDWIN AVENUE  , FORT LEE - 5th floor elevator activation",
        "ID:I-2012-000822",
        "CALL:1045F",
        "ADDR:3021 EDWIN AVENUE",
        "CITY:FORT LEE",
        "INFO:5th floor elevator activation");

    doTest("T10",
        "(I-2012-000823) 1035 @ 3081 EDWIN AVENUE  , FORT LEE - Reported Stuck Occupied Elevator between 3rd. & 4th. flrs.",
        "ID:I-2012-000823",
        "CALL:1035",
        "ADDR:3081 EDWIN AVENUE",
        "CITY:FORT LEE",
        "INFO:Reported Stuck Occupied Elevator between 3rd. & 4th. flrs.");

    doTest("T11",
        "(I-2012-000824) 1037 @  ROUTE 95 NORTH  , FORT LEE - Leonia Boro, rt 95 north express 120.7 -...\n\nActive Units: FL-R",
        "ID:I-2012-000824",
        "CALL:1037",
        "ADDR:ROUTE 95 NORTH",
        "CITY:FORT LEE",
        "INFO:Leonia Boro, rt 95 north express 120.7 -...  Active Units: FL-R");

    doTest("T12",
        "(I-2012-000825) 1045F @ 1 EXECUTIVE DRIVE  , FORT LEE - penthouse activation",
        "ID:I-2012-000825",
        "CALL:1045F",
        "ADDR:1 EXECUTIVE DRIVE",
        "CITY:FORT LEE",
        "INFO:penthouse activation");

    doTest("T13",
        "(I-2012-000826) 1045F @ 1600 PARKER AVENUE  , FORT LEE - General alarm",
        "ID:I-2012-000826",
        "CALL:1045F",
        "ADDR:1600 PARKER AVENUE",
        "CITY:FORT LEE",
        "INFO:General alarm");

    doTest("T14",
        "(I-2012-000827) 1032 @ 2170 FLETCHER AVENUE  , FORT LEE - report of vehicle fire in taco bell parking lot, 551-574-0053",
        "ID:I-2012-000827",
        "CALL:1032",
        "ADDR:2170 FLETCHER AVENUE",
        "CITY:FORT LEE",
        "INFO:report of vehicle fire in taco bell parking lot, 551-574-0053");

    doTest("T15",
        "(I-2012-000828) 1033 @ 1 PIP  , FORT LEE - brush fire  caller is by cannons",
        "ID:I-2012-000828",
        "CALL:1033",
        "ADDR:1 PIP",
        "CITY:FORT LEE",
        "INFO:brush fire  caller is by cannons");

    doTest("T16",
        "(I-2012-000829) 1045F @ 2053 ELLERY AVENUE  , FORT LEE - First fl smoke Canerparo residence   apt. building   alarm co to noty   owner cell  854-304-3491",
        "ID:I-2012-000829",
        "CALL:1045F",
        "ADDR:2053 ELLERY AVENUE",
        "CITY:FORT LEE",
        "INFO:First fl smoke Canerparo residence   apt. building   alarm co to noty   owner cell  854-304-3491");

    doTest("T17",
        "(I-2012-000830) 1035 @ 1000 OVERLOOK DRIVE  , FORT LEE - check for blocked fire exit, on south side of 2nd floor, previously reported to management, 908-249-2449, mr. lacher.",
        "ID:I-2012-000830",
        "CALL:1035",
        "ADDR:1000 OVERLOOK DRIVE",
        "CITY:FORT LEE",
        "INFO:check for blocked fire exit, on south side of 2nd floor, previously reported to management, 908-249-2449, mr. lacher.");

    doTest("T18",
        "(I-2012-000831) 1045F @ 2 HORIZON ROAD  , FORT LEE - laundry room 8 and basement north",
        "ID:I-2012-000831",
        "CALL:1045F",
        "ADDR:2 HORIZON ROAD",
        "CITY:FORT LEE",
        "INFO:laundry room 8 and basement north");

  }
  
  public static void main(String[] args) {
    new NJSussexCountyAParserTest().generateTests("T1");
  }
}