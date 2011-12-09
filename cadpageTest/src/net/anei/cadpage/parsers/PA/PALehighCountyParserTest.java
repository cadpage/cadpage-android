package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PALehighCountyParser;

import org.junit.Test;


public class PALehighCountyParserTest extends BaseParserTest {
  
  public PALehighCountyParserTest() {
    setParser(new PALehighCountyParser(), "LEHIGH COUNTY", "PA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "ST0100 TYP: RESP DIST-ABN BREATH APT: 8 AD: 4015 SCHOENECK RD CTY: LOWER MACUNGIE LOC: BIG O MHP CN: NURSE JULIE CMT1: **CHARLIE BREATHING PROBLEMS - ABNORMAL REATHING CMT2: 57 YEAR OLD MALE | 502 LBS | FULL OF FLUID | BLOOD IN STOOL | TIME: 10:11 UNTS: FD/30CHIEFS FD/ST01 XST2: MOUNTAIN RD",
        "SRC:ST0100",
        "CALL:RESP DIST-ABN BREATH",
        "APT:8",
        "ADDR:4015 SCHOENECK RD",
        "CITY:LOWER MACUNGIE TWP",
        "PLACE:BIG O MHP",
        "NAME:NURSE JULIE",
        "INFO:**CHARLIE BREATHING PROBLEMS - ABNORMAL REATHING / 57 YEAR OLD MALE | 502 LBS | FULL OF FLUID | BLOOD IN STOOL |",
        "UNIT:FD/30CHIEFS FD/ST01",
        "X:MOUNTAIN RD");

    doTest("T2",
        "ST0100 TYP: NON-DWELL STRUCTURE AD: 8635 HENSINGERSVILLE RD CTY: 06 LONGSWAMP CMT1: **NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) CMT2: FULLY INVOLVED STRUCTURE FIRE TIME: 01:37 UNTS: FD/ST01 XST: WALKER RD XST2: 8603 OAK HOLLOW LN",
        "SRC:ST0100",
        "CALL:NON-DWELL STRUCTURE",
        "ADDR:8635 HENSINGERSVILLE RD",
        "CITY:LONGSWAMP TWP",
        "INFO:**NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) / FULLY INVOLVED STRUCTURE FIRE",
        "UNIT:FD/ST01",
        "X:WALKER RD & 8603 OAK HOLLOW LN");

    doTest("T3",
        "ST0100 TYP: APARTMENT BLDG FIRE AD: 2130 STATE ST CTY: 06 LONGSWAMP CN: BERKS CMT1: **APARTMENT BUILDING FIRE (MULTI-OCCUPANCY RESIDENTIAL) CMT2: REQ ST 01 WIT BERKS ST21 SMOKE FROM BASEMENT IN APT BUILDING TIME: 14:22 UNTS: FD/E111 XST: 175 SCHLOSSBURG ST XST2: 380 JAMES LN",
        "SRC:ST0100",
        "CALL:APARTMENT BLDG FIRE",
        "ADDR:2130 STATE ST",
        "CITY:LONGSWAMP TWP",
        "NAME:BERKS",
        "INFO:**APARTMENT BUILDING FIRE (MULTI-OCCUPANCY RESIDENTIAL) / REQ ST 01 WIT BERKS ST21 SMOKE FROM BASEMENT IN APT BUILDING",
        "UNIT:FD/E111",
        "X:175 SCHLOSSBURG ST & 380 JAMES LN");

    doTest("T4",
        "ST0100 TYP: TRAFFIC CONTROL AD: CHURCH ST&THOMAS ST CTY: ALBURTIS LOC: ON THOMAS CN: RONALD CONRAD CMT1: **TRAFFIC CONTROL CMT2: ASST WITH WATER MAIN TIME: 08:",
        "SRC:ST0100",
        "CALL:TRAFFIC CONTROL",
        "ADDR:CHURCH ST & THOMAS ST",
        "CITY:ALBURTIS",
        "PLACE:ON THOMAS",
        "NAME:RONALD CONRAD",
        "INFO:**TRAFFIC CONTROL / ASST WITH WATER MAIN");

    doTest("T5",
        "ST0100 TYP: MVA WITH RESCUE AD: S RT100&SCHANTZ RD CTY: UPPER MACUNGIE CN: TIM MARTIN CMT1: **BRAVO MVA - WITH INJURIES CMT2: PER PASSERBY AIRBAGS DEPLOYED TIM 14:06 UNTS: FD/ST25 FD/A6295 FD/E2511 FD/R141 FD/06R21",
        "SRC:ST0100",
        "CALL:MVA WITH RESCUE",
        "ADDR:S RT100 & SCHANTZ RD",
        "MADDR:S RT 100 & SCHANTZ RD",
        "CITY:UPPER MACUNGIE TWP",
        "NAME:TIM MARTIN",
        "INFO:**BRAVO MVA - WITH INJURIES / PER PASSERBY AIRBAGS DEPLOYED TIM 14:06",
        "UNIT:FD/ST25 FD/A6295 FD/E2511 FD/R141 FD/06R21");

    doTest("T6",
        "ST0100 TYP: RESCUE-SPECIFY TYPE AD: GAP RD&WALKER RD CTY: 06 LONGSWAMP CN: BERKS CMT1: **DELTA TRENCH COLLAPSE WITH RESCUE (ALERT RESCUE TONES) CMT2: ST 1 AND T66 WITH ATV RIGHT ON TO WALKER TO THE DEAD END BERK EMS AND FI TIME: 02:19 UNTS: FD/E112",
        "SRC:ST0100",
        "CALL:RESCUE-SPECIFY TYPE",
        "ADDR:GAP RD & WALKER RD",
        "CITY:LONGSWAMP TWP",
        "NAME:BERKS",
        "INFO:**DELTA TRENCH COLLAPSE WITH RESCUE (ALERT RESCUE TONES) / ST 1 AND T66 WITH ATV RIGHT ON TO WALKER TO THE DEAD END BERK EMS AND FI",
        "UNIT:FD/E112");

    doTest("T7",
        "ST3000 TYP: FD STANDBY AT OWN ST AD: ALLENTOWN FD CTY: ALLENTOWN LOC: ALLENTOWN FD CMT1: **FIRE STANDBY - AT OWN STATION CMT2: Original Location : ALLENTOWN FD TIME: 17:43 UNTS: FD/E3711 FD/E3012 FD/E1112 FD/E3112 FD/TK231 FD/E2711 FD/R1141&nbsp;",
        "SRC:ST3000",
        "CALL:FD STANDBY AT OWN ST",
        "ADDR:ALLENTOWN FD",
        "CITY:ALLENTOWN",
        "PLACE:ALLENTOWN FD",
        "INFO:**FIRE STANDBY - AT OWN STATION / Original Location : ALLENTOWN FD",
        "UNIT:FD/E3711 FD/E3012 FD/E1112 FD/E3112 FD/TK231 FD/E2711 FD/R1141");

    doTest("T8",
        "ST3000 TYP: EMS ASSIST AD: 3510 MACUNGIE RD CTY: LOWER MACUNGIE CN: JARRETT DENNIS CMT1: **ECHO CARDIAC ARREST - NOT BREATHING CMT2: 0010001030 WIFE WONT WAKE UP SNORING RESP 55 YEAR OLD FEMALE UNCONSCIO TIME: 10:07 UNTS: FD/30CHIEFS FD/ST30 XST: 3157 WATERMILL DR XST2: 5248 INDIAN CREEK RD",
        "SRC:ST3000",
        "CALL:EMS ASSIST",
        "ADDR:3510 MACUNGIE RD",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:JARRETT DENNIS",
        "INFO:**ECHO CARDIAC ARREST - NOT BREATHING / 0010001030 WIFE WONT WAKE UP SNORING RESP 55 YEAR OLD FEMALE UNCONSCIO",
        "UNIT:FD/30CHIEFS FD/ST30",
        "X:3157 WATERMILL DR & 5248 INDIAN CREEK RD");

    doTest("T9",
        "ST3000 TYP: SMOKE IN DWELLING AD: 2008 ELBOW LN CTY: LOWER MACUNGIE CN: LINDA STROHL CMT1: **SMOKE IN THE DWELLING CMT2: SMOKE COMING FROM THE EXHAUST PIPE OF HEATING SYSTEM FILLING BASEMENT WIT TIME: 06:58 UNTS: FD/30CHIEFS FD/ST30 FD/A6681 FD/ST66 FD/R3041 FD/E3012 FD/TK3031 FD/E3112 XST: 4486 REDWOOD LN XST2: HESS CIR",
        "SRC:ST3000",
        "CALL:SMOKE IN DWELLING",
        "ADDR:2008 ELBOW LN",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:LINDA STROHL",
        "INFO:**SMOKE IN THE DWELLING / SMOKE COMING FROM THE EXHAUST PIPE OF HEATING SYSTEM FILLING BASEMENT WIT",
        "UNIT:FD/30CHIEFS FD/ST30 FD/A6681 FD/ST66 FD/R3041 FD/E3012 FD/TK3031 FD/E3112",
        "X:4486 REDWOOD LN & HESS CIR");

    doTest("T10",
        "ST6651 TYP: NON-DWELL STRUCTURE AD: 8635 HENSINGERSVILLE RD CTY: 06 LONGSWAMP CMT1: **NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) CMT2: FULLY INVOLVED STRUCTURE FIRE TIME: 01:37 UNTS: FD/6651 XST: WALKER RD XST2: 8603 OAK HOLLOW LN",
        "SRC:ST6651",
        "CALL:NON-DWELL STRUCTURE",
        "ADDR:8635 HENSINGERSVILLE RD",
        "CITY:LONGSWAMP TWP",
        "INFO:**NON-DWELLING STRUCTURE FIRE (SHED, DETATCHED GARAGE) / FULLY INVOLVED STRUCTURE FIRE",
        "UNIT:FD/6651",
        "X:WALKER RD & 8603 OAK HOLLOW LN");

    doTest("T11",
        "ST3000 TYP: CHIMNEY FIRE AD: 6043 LOWER MACUNGIE RD CTY: LOWER MACUNGIE LOC: LOWER MACUNGIE ELEMENTARY CN: MR FELDMAN CMT1: **CHIMNEY FIRE CMT2: SMOKE COMING FROM THE CHIMNEY TIME: 22:09 UNTS: FD/30CHIEFS FD/ST30 FD/ST66 FD/A6683 FD/E3012 FD/TK3031 FD/R3041 FD/E2511 XST: S KROCKS RD XST2: SPRING CREEK RD",
        "SRC:ST3000",
        "CALL:CHIMNEY FIRE",
        "ADDR:6043 LOWER MACUNGIE RD",
        "CITY:LOWER MACUNGIE TWP",
        "PLACE:LOWER MACUNGIE ELEMENTARY",
        "NAME:MR FELDMAN",
        "INFO:**CHIMNEY FIRE / SMOKE COMING FROM THE CHIMNEY",
        "UNIT:FD/30CHIEFS FD/ST30 FD/ST66 FD/A6683 FD/E3012 FD/TK3031 FD/R3041 FD/E2511",
        "X:S KROCKS RD & SPRING CREEK RD");

    doTest("T12",
        "ST3000 TYP: UNCONSC-EFFECTIVE BR AD: 7547 CATALPA DR CTY: LOWER MACUNGIE CN: DAVE KOWALICK CMT1: **DELTA UNCONSCIOUS - EFFECTIVE BREATHING CMT2: 0110000513 UNCON 30 YEAR OLD MALE UNCONSCIOUS BREATHING STATUS UNKNOW TIME: 19:30 UNTS: FD/R3041 XST: WOODBINE RD XST2: RED OAK LN",
        "SRC:ST3000",
        "CALL:UNCONSC-EFFECTIVE BR",
        "ADDR:7547 CATALPA DR",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:DAVE KOWALICK",
        "INFO:**DELTA UNCONSCIOUS - EFFECTIVE BREATHING / 0110000513 UNCON 30 YEAR OLD MALE UNCONSCIOUS BREATHING STATUS UNKNOW",
        "UNIT:FD/R3041",
        "X:WOODBINE RD & RED OAK LN");

    doTest("T13",
        "ST3000 TYP: STRUCT/DWELL-UNK SIT AD: SPRINGHOUSE RD&amp;TREXLER BLVD CTY: SOUTH WHITEHALL LOC: . CN: CHRIS BENALE CMT1: **STRUCTURE OR&nbsp;DWELLING FIRE - UNKNOWN SITUATION CMT2: ABANDONED BARN WITH SMOKE COMING OUT OFROOF CAN SEE FLAMES ALSO TIME: 14:45 UNTS: FD/TK3031",
        "SRC:ST3000",
        "CALL:STRUCT/DWELL-UNK SIT",
        "ADDR:SPRINGHOUSE RD & TREXLER BLVD",
        "CITY:SOUTH WHITEHALL TWP",
        "PLACE:.",
        "NAME:CHRIS BENALE",
        "INFO:**STRUCTURE OR DWELLING FIRE - UNKNOWN SITUATION / ABANDONED BARN WITH SMOKE COMING OUT OFROOF CAN SEE FLAMES ALSO",
        "UNIT:FD/TK3031");

    doTest("T14",
        "ST3000 TYP: ALARM-FIRE-DWELLING AD: 4129 FAWN TRAIL RD CTY: SOUTH WHITEHALL LOC: CRON RES 610-530-0708 CN: OPER MANDI CMT1: **RESIDENTIAL FIRE ALARM - SINGLE-FAMILY OCCUPANCY CMT2: ZONE 6 SMOKE DETECTOR / ATTEMPTED KEYHOLDER TIME: 17:49 UNTS: FD/ST32 FD/E3212&nbsp;FD/TA3221 FD/SP3291 FD/E1111 FD/TK3031 FD/R1141 XST: 1382 BUCK TRAIL RD XST2: 1386 DOE TRAIL RD",
        "SRC:ST3000",
        "CALL:ALARM-FIRE-DWELLING",
        "ADDR:4129 FAWN TRAIL RD",
        "CITY:SOUTH WHITEHALL TWP",
        "PLACE:CRON RES 610-530-0708",
        "NAME:OPER MANDI",
        "INFO:**RESIDENTIAL FIRE ALARM - SINGLE-FAMILY OCCUPANCY / ZONE 6 SMOKE DETECTOR / ATTEMPTED KEYHOLDER",
        "UNIT:FD/ST32 FD/E3212 FD/TA3221 FD/SP3291 FD/E1111 FD/TK3031 FD/R1141",
        "X:1382 BUCK TRAIL RD & 1386 DOE TRAIL RD");

    doTest("T15",
        "ST3000 TYP: SPILL &lt;50 GAL UNCNTD AD: KROCKS RD&amp;HAMILTON BLVD CTY: LOWER MACUNGIE CN: JAMES FOREMAN CMT1: **BRAVO MVA - WITH INJURIES CMT2: TWO VEHICLES / ONE FEMALE 40'S POSS BROKEN NOSE TIME: 16:13 UNTS: FD/30CHIEFS FD/ST30",
        "SRC:ST3000",
        "CALL:SPILL <50 GAL UNCNTD",
        "ADDR:KROCKS RD & HAMILTON BLVD",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:JAMES FOREMAN",
        "INFO:**BRAVO MVA - WITH INJURIES / TWO VEHICLES / ONE FEMALE 40'S POSS BROKEN NOSE",
        "UNIT:FD/30CHIEFS FD/ST30");

    doTest("T16",
        "ST3000 TYP: MVA-ROLLOVER AD: I476MM57 4NB CTY: SOUTH WHITEHALL LOC: I476MM57 4NB CMT1: **DELTA MVA WITH ROLLOVER CMT2: ONE VEHICLE&nbsp;ON THE TURNPIKE ANOTHER POSSIBLY FLIPPED OVER THE GUARDRAIL TIME: 11:57 UNTS: FD/30CHIEFS FD/ST30 FD/A6298 FD/ST62MN FD/R3041 FD/E3012 XST: TILGHMAN ST XST2: RT22",
        "SRC:ST3000",
        "CALL:MVA-ROLLOVER",
        "ADDR:I476MM57 4NB",
        "MADDR:I476MM57 4NB & TILGHMAN ST",
        "CITY:SOUTH WHITEHALL TWP",
        "PLACE:I476MM57 4NB",
        "INFO:**DELTA MVA WITH ROLLOVER / ONE VEHICLE ON THE TURNPIKE ANOTHER POSSIBLY FLIPPED OVER THE GUARDRAIL",
        "UNIT:FD/30CHIEFS FD/ST30 FD/A6298 FD/ST62MN FD/R3041 FD/E3012",
        "X:TILGHMAN ST & RT22");

    doTest("T17",
        "ST3000 TYP: MVA WITH RESCUE AD: WILD CHERRY LN&amp;VALLEY STREAM L CTY: LOWER MACUNGIE CN: DALE METZGER CMT1: **DELTA MVA WITH RESCUE (ALERT RESCUE TONES AS NECESSARY) CMT2: VEHICLE HIT HTE BRIDGE | MALE TRAPPED INTHE VEHICLE TIME: 07:04 UNTS: FD/30CHIEFS FD/ST30&nbsp;FD/A6682 FD/ST66 FD/E3012 FD/R3041",
        "SRC:ST3000",
        "CALL:MVA WITH RESCUE",
        "ADDR:WILD CHERRY LN & VALLEY STREAM L",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:DALE METZGER",
        "INFO:**DELTA MVA WITH RESCUE (ALERT RESCUE TONES AS NECESSARY) / VEHICLE HIT HTE BRIDGE | MALE TRAPPED INTHE VEHICLE",
        "UNIT:FD/30CHIEFS FD/ST30 FD/A6682 FD/ST66 FD/E3012 FD/R3041");

    doTest("T18",
        "ST3000 TYP: MVA-AUTO-PEDESTRIAN AD: RT222&KROCKS RD CTY: LOWER MACUNGIE CN: JOHN TILGHMAN CMT1: **DELTA PEDESTRIAN STRUCK CMT2: PED TIME: 21:51 UNTS: FD/E3012",
        "SRC:ST3000",
        "CALL:MVA-AUTO-PEDESTRIAN",
        "ADDR:RT222 & KROCKS RD",
        "MADDR:RT 222 & KROCKS RD",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:JOHN TILGHMAN",
        "INFO:**DELTA PEDESTRIAN STRUCK / PED",
        "UNIT:FD/E3012");

    doTest("T19",
        "ST3000 TYP: FALL-LONG FALL AD: 1525 SHASTA LN CTY: LOWER MACUNGIE CN: BROOK MYERS CMT1: **DELTA FALL VICTIM - LONG FALL (>6 FT) CMT2: 62499 ST RD13 GOSHENAmbulance CallCLIN,M1J01/16/2011 10:46:33 : pos7 : HARMOF   Geo Comment: 00120D  CLIN CEN  CLINTON BRICK MENNONITE CHURCH.....GO TO THE SPRING CREEK RD",
        "SRC:ST3000",
        "CALL:FALL-LONG FALL",
        "ADDR:1525 SHASTA LN",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:BROOK MYERS",
        "INFO:**DELTA FALL VICTIM - LONG FALL (>6 FT) / 62499 ST RD13 GOSHENAmbulance CallCLIN,M1J01/16/2011 10:46:33 : pos7 : HARMOF   Geo Comment: 00120D  CLIN CEN  CLINTON BRICK MENNONITE CHURCH.....GO TO THE SPRING CREEK RD");

    doTest("T20",
        "ST3000 TYP: DWEL/STRUCT W/ENTRAP AD: 2573 MILL HOUSE RD CTY: LOWER MACUNGIE CN: LORI BOWICR CMT1: **ECHO DWELLING OR STRUCTURE FIRE WITH ENTRAPMENT CMT2: FIRE IN THE DRYER CAN NOT FIND HER DAUGHTER TIME: 10:25 UNTS: FD/ST30 FD/ST66 FD/E3012 FD/E3011 FD/E1512 FD/E1511 FD/TK3031 FD/ST60RIT XST: 5753 FRESH MEADOW DR XST2: SAUERKRAUT LN",
        "SRC:ST3000",
        "CALL:DWEL/STRUCT W/ENTRAP",
        "ADDR:2573 MILL HOUSE RD",
        "CITY:LOWER MACUNGIE TWP",
        "NAME:LORI BOWICR",
        "INFO:**ECHO DWELLING OR STRUCTURE FIRE WITH ENTRAPMENT / FIRE IN THE DRYER CAN NOT FIND HER DAUGHTER",
        "UNIT:FD/ST30 FD/ST66 FD/E3012 FD/E3011 FD/E1512 FD/E1511 FD/TK3031 FD/ST60RIT",
        "X:5753 FRESH MEADOW DR & SAUERKRAUT LN");

    doTest("T21",
        "ST6651 TYP: AIRPORT ALERT 2 AD: 3311 AIRPORT RD CTY: HANOVER LOC: LVIA CMT1: **AIRPORT ALERT 2 CMT2: RJ SOUTH OF AIRPORT 6 MIN OUT 21 XST: CITY LINE RD RUNWAY 24 OPEN DOOR 35 SOULS. TIME: 19:16 UNTS: FD/ST33 FD/ST02 FD/ST75 FD/ST60FD/48E10 FD/ST62WH FD/ST73 FD/ST78 FD/6651 FD/TA32",
        "SRC:ST6651",
        "CALL:AIRPORT ALERT 2",
        "ADDR:3311 AIRPORT RD",
        "CITY:HANOVER TWP",
        "PLACE:LVIA",
        "INFO:**AIRPORT ALERT 2 / RJ SOUTH OF AIRPORT 6 MIN OUT 21",
        "UNIT:FD/ST33 FD/ST02 FD/ST75 FD/ST60FD/48E10 FD/ST62WH FD/ST73 FD/ST78 FD/6651 FD/TA32",
        "X:CITY LINE RD RUNWAY 24 OPEN DOOR 35 SOULS. TIME: 19:16");

    doTest("T22",
        "ST3000 TYP: ALARM-FIRE-COMRCL AD: 4400 S CEDARBROOK RD CTY: LOWER MACUNGIE LOC: HAPCO CN: SIMPLEX GRUNNEL CMT1: **COMMERICAL FIRE ALARM CMT2: NO PREMISE PHONE ZONE 999 SMOKE DETECTOR TIME: 19:47 UNTS: FD/ST30 FD/E3011 FD/E3012 XST2: RT222",
        "SRC:ST3000",
        "CALL:ALARM-FIRE-COMRCL",
        "ADDR:4400 S CEDARBROOK RD",
        "CITY:LOWER MACUNGIE TWP",
        "PLACE:HAPCO",
        "NAME:SIMPLEX GRUNNEL",
        "INFO:**COMMERICAL FIRE ALARM / NO PREMISE PHONE ZONE 999 SMOKE DETECTOR",
        "UNIT:FD/ST30 FD/E3011 FD/E3012",
        "X:RT222");

    doTest("T23",
        "ST3000 TYP: ALARM-FIRE-COMRCL AD: 4400 S CEDARBROOK RD CTY: LOWER MACUNGIE LOC: HAPCO CN: SIMPLEX GRUNNEL CMT1: **COMMERICAL FIRE ALARM CMT2: NO PREMISE PHONE ZONE 999 SMOKE DETECTOR TIME: 19:47 UNTS: FD/ST30 FD/E3011 FD/E3012 XST2: RT222",
        "SRC:ST3000",
        "CALL:ALARM-FIRE-COMRCL",
        "ADDR:4400 S CEDARBROOK RD",
        "CITY:LOWER MACUNGIE TWP",
        "PLACE:HAPCO",
        "NAME:SIMPLEX GRUNNEL",
        "INFO:**COMMERICAL FIRE ALARM / NO PREMISE PHONE ZONE 999 SMOKE DETECTOR",
        "UNIT:FD/ST30 FD/E3011 FD/E3012",
        "X:RT222");
  }
  
  public static void main(String[] args) {
    new PALehighCountyParserTest().generateTests("T22");
  }
}