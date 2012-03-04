package net.anei.cadpage.parsers.MN;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MNHennepinCountyParserTest extends BaseParserTest {
  
  public MNHennepinCountyParserTest() {
    setParser(new MNHennepinCountyParser(), "HENNEPIN COUNTY", "MN");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "NAME-KENDRA;  LOC-4001 STINSON BLVD NE [#404;  EVTYPE-STROKE;  COMMENTS-POSSIBLE STROKE --- USE MAIN ENTRANCE TO THE 4TH FL",
        "NAME:KENDRA",
        "ADDR:4001 STINSON BLVD NE",
        "APT:404",
        "CALL:STROKE",
        "INFO:POSSIBLE STROKE --- USE MAIN ENTRANCE TO THE 4TH FL");

    doTest("T2",
        "NAME-BRINATTE,HELEN;  LOC-2626 KENZIE TER [#114 [@WALKER ON KENZIE APT;  EVTYPE-ILL;  COMMENTS-2626 KENZIE TER : cross stre",
        "NAME:BRINATTE,HELEN",
        "ADDR:2626 KENZIE TER",
        "APT:114",
        "PLACE:WALKER ON KENZIE APT",
        "CALL:ILL");

    doTest("T3",
        "NAME-;  LOC-2600 39TH AVE NE [#100 [@SILVER LAKE CLINIC;  EVTYPE-BREATH;  COMMENTS-2600 39TH AVE NE : cross streets : SILVE",
        "ADDR:2600 39TH AVE NE",
        "APT:100",
        "PLACE:SILVER LAKE CLINIC",
        "CALL:BREATH",
        "X:SILVE");

    doTest("T4",
        "NAME-MRS SILGE;  LOC-3804 HIGHCREST RD [#109 [@LAKEHILL APT;  EVTYPE-ASTFIR;  COMMENTS-3804 HIGHCREST RD : cross streets :",
        "ADDR:3804 HIGHCREST RD",
        "NAME:MRS SILGE",
        "APT:109",
        "PLACE:LAKEHILL APT",
        "CALL:ASTFIR");

    doTest("T5",
        "NAME-areson, dale;  LOC-2512 SILVER LA [#204 [@EQUINOX APT;  EVTYPE-FALL;  COMMENTS-2512 SILVER LA : cross streets : SILVER",
        "NAME:areson, dale",
        "ADDR:2512 SILVER LA",
        "MADDR:2512 SILVER LN",
        "APT:204",
        "PLACE:EQUINOX APT",
        "CALL:FALL",
        "X:SILVER");

    doTest("T6",
        "NAME-SARAH;  LOC-3701 CHANDLER DR [#312 [@CHANDLER PLACE APT;  EVTYPE-ILL;  COMMENTS-3701 CHANDLER DR : cross streets : DIA",
        "NAME:SARAH",
        "ADDR:3701 CHANDLER DR",
        "APT:312",
        "PLACE:CHANDLER PLACE APT",
        "CALL:ILL",
        "X:DIA");

    doTest("T7",
        "NAME-;  LOC-3700 FOSS RD [#152;  EVTYPE-ILL;  COMMENTS-3700 FOSS RD : cross streets : CHANDLER DR  75 YO FEMALE - ILL",
        "ADDR:3700 FOSS RD",
        "APT:152",
        "CALL:ILL",
        "INFO:75 YO FEMALE - ILL",
        "X:CHANDLER DR");

    doTest("T8",
        "NAME-STANLEY SEC;  LOC-2804 29TH AVE NE;  EVTYPE-ALMHSE;  COMMENTS-2804 29TH AVE NE: cross streets : COOLIDGE ST NE & WILSO",
        "NAME:STANLEY SEC",
        "ADDR:2804 29TH AVE NE",
        "CALL:ALMHSE",
        "X:COOLIDGE ST NE & WILSO");

    doTest("T9",
        "NAME-DIANE;  LOC-2600 KENZIE TER [@AUTUMN WOODS APT#208;  EVTYPE-FALL;  COMMENTS-2600 KENZIE TER : cross streets : LOWRY GR",
        "NAME:DIANE",
        "ADDR:2600 KENZIE TER",
        "PLACE:AUTUMN WOODS APT#208",
        "CALL:FALL",
        "X:LOWRY GR");

    doTest("T10",
        "NAME-ERIC;  LOC-3201 DIAMOND EIGHT TER [#106 [@DIAMOND EIGHT TERRACE APT;  EVTYPE-CHOKE;  COMMENTS-3201 DIAMOND EIGHT TER :",
        "NAME:ERIC",
        "ADDR:3201 DIAMOND EIGHT TER",
        "APT:106",
        "PLACE:DIAMOND EIGHT TERRACE APT",
        "CALL:CHOKE");

    doTest("T11",
        "NAME-;  LOC-3114 RANKIN RD;  EVTYPE-ALLERG;  COMMENTS-3114 RANKIN RD : cross streets : 32ND AVE NE & TOWNVIEW AVE  thinks s",
        "ADDR:3114 RANKIN RD",
        "CALL:ALLERG",
        "INFO:thinks s",
        "X:32ND AVE NE & TOWNVIEW AVE");

    doTest("T12",
        "NAME-PEKAREK;  LOC-3008 RANKIN RD;  EVTYPE-HEART;  COMMENTS-3008 RANKIN RD : cross streets : EAST GATE RD & CROFT DR  43 YO",
        "NAME:PEKAREK",
        "ADDR:3008 RANKIN RD",
        "CALL:HEART",
        "INFO:43 YO",
        "X:EAST GATE RD & CROFT DR");
         
  }
  
  public static void main(String[] args) {
    new MNHennepinCountyParserTest().generateTests("T1");
  }
}
