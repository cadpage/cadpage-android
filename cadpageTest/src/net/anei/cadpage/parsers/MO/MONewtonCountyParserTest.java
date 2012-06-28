package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MONewtonCountyParserTest extends BaseParserTest {
  
  public MONewtonCountyParserTest() {
    setParser(new MONewtonCountyParser(), "NEWTON COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:911 CALL\n11178 ELAND RD  CrossStreets: JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N SICK PERSON ESN: pg6 Call Number: 763388",
        "ADDR:11178 ELAND RD",
        "X:JUNIPER DR 0.01 mi SE IVY DR 0.73 mi N",
        "CALL:SICK PERSON",
        "MAP:pg6",
        "ID:763388");

    doTest("T2",
        "Subject:911 CALL\nIRIS RD & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ALL TERRAIN ESN: pg6 Call Number: 760919",
        "ADDR:IRIS RD & STATE LINE RD",
        "CALL:TA-D (TONE PD) HIGH MECH-ALL TERRAIN",
        "MAP:pg6",
        "ID:760919");

    doTest("T3",
        "Subject:911 CALL\n" +
        "2953 ROWAN DR  CrossStreets: ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W STRUCTURE FIRE-D / RES (SINGLE) ESN: pg8 Call Number: 7",

        "ADDR:2953 ROWAN DR",
        "X:ANTELOPE RD 0.19 mi E HIGHWAY 43 0.81 mi W",
        "CALL:STRUCTURE FIRE-D / RES (SINGLE)",
        "MAP:pg8",
        "ID:7");

    doTest("T4",
        "Subject:911 CALL\n" +
        "13724 HIGHWAY 43, Apt. 30 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE ESN: pg7 Call Number",

        "ADDR:13724 HIGHWAY 43",
        "APT:30",
        "PLACE:TEEPEE MHP",
        "X:AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW",
        "CALL:STRUCTURE FIRE",
        "MAP:pg7");

    doTest("T5",
        "Subject:911 CALL\n" +
        "20513 HIGHWAY Y  CrossStreets: RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N CHEST PAIN ESN: pg8 Call Number: 762218",

        "ADDR:20513 HIGHWAY Y",
        "X:RHINEHART LN 0.19 mi S REDBUD RD 0.62 mi N",
        "CALL:CHEST PAIN",
        "MAP:pg8",
        "ID:762218");

    doTest("T6",
        "Subject:911 CALL\n5369 QUINCE RD  CrossStreets: DENNISON LN 0.03 mi E CROW RD 0.71 mi W TA INJURY ESN: pg8 Call Number: 762973",
        "ADDR:5369 QUINCE RD",
        "X:DENNISON LN 0.03 mi E CROW RD 0.71 mi W",
        "CALL:TA INJURY",
        "MAP:pg8",
        "ID:762973");

    doTest("T7",
        "Subject:911 CALL\n" +
        "13724 HIGHWAY 43, Apt. 29 TEEPEE MHP CrossStreets: AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW STRUCTURE FIRE-D / MH-PORTABLE OFC ",

        "ADDR:13724 HIGHWAY 43",
        "APT:29",
        "PLACE:TEEPEE MHP",
        "X:AVALON LN 0.22 mi N LONNIE LN 0.33 mi SW",
        "CALL:STRUCTURE FIRE-D / MH-PORTABLE OFC");

    doTest("T8",
        "Subject:911 CALL\n5156 JESSICA LN  CrossStreets: CROW RD 0.31 mi W FALL ESN: pg6 Call Number: 762520",
        "ADDR:5156 JESSICA LN",
        "X:CROW RD 0.31 mi W",
        "CALL:FALL",
        "MAP:pg6",
        "ID:762520");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "(911 CALL) 344 REDINGS MILL RD RMFD1 CrossStreets: CHRISTMAN DR 0.09 mi SW PARK HILL DR 0.08 mi NE OUTSIDE FIRE ESN: pg47 Call Number: 770023",
        "ADDR:344 REDINGS MILL RD",
        "PLACE:RMFD1",
        "X:CHRISTMAN DR 0.09 mi SW PARK HILL DR 0.08 mi NE",
        "CALL:OUTSIDE FIRE",
        "MAP:pg47",
        "ID:770023");

    doTest("T2",
        "(911 CALL) 5517 SPURGEON RD, Apt. 157 BIG VALLEY MHP CrossStreets: DANIELLE LN 0.24 mi N ELM DR 0.76 mi S BREATHING PROB ESN: pg26 Call Number: 770098",
        "ADDR:5517 SPURGEON RD",
        "APT:157",
        "PLACE:BIG VALLEY MHP",
        "X:DANIELLE LN 0.24 mi N ELM DR 0.76 mi S",
        "CALL:BREATHING PROB",
        "MAP:pg26",
        "ID:770098");

    doTest("T3",
        "(911 CALL) 3427 HOLLY RD  CrossStreets: ANTELOPE RD 0.31 mi W BISON RD 0.64 mi E OUTSIDE FIRE ESN: pg5 Call Number: 770114",
        "ADDR:3427 HOLLY RD",
        "X:ANTELOPE RD 0.31 mi W BISON RD 0.64 mi E",
        "CALL:OUTSIDE FIRE",
        "MAP:pg5",
        "ID:770114");

    doTest("T4",
        "(911 CALL) 11319 HIGHWAY FF, Apt. LOT 8A  CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E SICK PERSON ESN: pg25 Call Number: 770124",
        "ADDR:11319 HIGHWAY FF",
        "APT:LOT 8A",
        "X:REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E",
        "CALL:SICK PERSON",
        "MAP:pg25",
        "ID:770124");

    doTest("T5",
        "(911 CALL) 9477 DANIELLE LN  CrossStreets: DEAD END 0.65 mi W SPURGEON RD 0.65 mi E UNCONS/FAINTING ESN: pg26 Call Number: 770284",
        "ADDR:9477 DANIELLE LN",
        "X:DEAD END 0.65 mi W SPURGEON RD 0.65 mi E",
        "CALL:UNCONS/FAINTING",
        "MAP:pg26",
        "ID:770284");

    doTest("T6",
        "(911 CALL) 712 E 39TH ST, Apt. 1 DENNIS ACRES MHP CrossStreets: S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E CHEST PAIN ESN: pg39 Call Number: 770315",
        "ADDR:712 E 39TH ST",
        "APT:1",
        "PLACE:DENNIS ACRES MHP",
        "X:S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E",
        "CALL:CHEST PAIN",
        "MAP:pg39",
        "ID:770315");

    doTest("T7",
        "(911 CALL) 20TH & BLACKCAT RD  CrossStreets: MUTUAL AID-A / ASST OUTSIDE-MULTI/COLD ESN:  Call Number: 770414",
        "ADDR:20TH & BLACKCAT RD",
        "CALL:MUTUAL AID-A / ASST OUTSIDE-MULTI/COLD",
        "ID:770414");

    doTest("T8",
        "(911 CALL) NEWTON RD & CRANE DR  CrossStreets: OUTSIDE FIRE ESN: pg4/38 Call Number: 770492",
        "ADDR:NEWTON RD & CRANE DR",
        "CALL:OUTSIDE FIRE",
        "MAP:pg4/38",
        "ID:770492");

    doTest("T9",
        "(911 CALL) 11319 HIGHWAY FF, Apt. C6 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E SICK PERSON ESN: pg25 Call Number: 770567",
        "ADDR:11319 HIGHWAY FF",
        "APT:C6",
        "PLACE:BYKOTA ESTATES MHP",
        "X:REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E",
        "CALL:SICK PERSON",
        "MAP:pg25",
        "ID:770567");

    doTest("T10",
        "(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S TA INJURY ESN: pg5 Call Number: 770745",
        "ADDR:5725 HIGHWAY 43",
        "PLACE:GO ZONE",
        "X:DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S",
        "CALL:TA INJURY",
        "MAP:pg5",
        "ID:770745");

    doTest("T11",
        "(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S ALLERGIES/STINGS/BITES ESN: pg5 Call Number: 770872",
        "ADDR:5725 HIGHWAY 43",
        "PLACE:GO ZONE",
        "X:DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S",
        "CALL:ALLERGIES/STINGS/BITES",
        "MAP:pg5",
        "ID:770872");

    doTest("T12",
        "(911 CALL) 808 W 46TH ST  CrossStreets: DEAD END 0.09 mi W SARGEANT AVE 0.09 mi E CARDIAC/RESPIR ARREST ESN: pg51 Call Number: 770886",
        "ADDR:808 W 46TH ST",
        "X:DEAD END 0.09 mi W SARGEANT AVE 0.09 mi E",
        "CALL:CARDIAC/RESPIR ARREST",
        "MAP:pg51",
        "ID:770886");

    doTest("T13",
        "(911 CALL) 3586 CHERRY RD  CrossStreets: APPLE VALLEY LN 0.14 mi W BERRY HILL LN 0.59 mi E BREATHING PROB ESN: pg4/38 Call Number: 770912",
        "ADDR:3586 CHERRY RD",
        "X:APPLE VALLEY LN 0.14 mi W BERRY HILL LN 0.59 mi E",
        "CALL:BREATHING PROB",
        "MAP:pg4/38",
        "ID:770912");

    doTest("T14",
        "(911 CALL) HIGHWAY 43 & I 44 EB  CrossStreets: TA INJURY-UNK (JOP/OUT) ESN: pg4/38 Call Number: 770924",
        "ADDR:HIGHWAY 43 & I 44 EB",
        "MADDR:HIGHWAY 43 & I 44",
        "CALL:TA INJURY-UNK (JOP/OUT)",
        "MAP:pg4/38",
        "ID:770924");

    doTest("T15",
        "(911 CALL) 11319 HIGHWAY FF, Apt. A10 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E BREATHING PROB ESN: pg25 Call Number: 770969",
        "ADDR:11319 HIGHWAY FF",
        "APT:A10",
        "PLACE:BYKOTA ESTATES MHP",
        "X:REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E",
        "CALL:BREATHING PROB",
        "MAP:pg25",
        "ID:770969");

    doTest("T16",
        "(911 CALL) 712 E 39TH ST, Apt. 1 DENNIS ACRES MHP CrossStreets: S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E OD/POISON ESN: pg39 Call Number: 771014",
        "ADDR:712 E 39TH ST",
        "APT:1",
        "PLACE:DENNIS ACRES MHP",
        "X:S INDIANA AVE 0.64 mi W DEAD END 0.64 mi E",
        "CALL:OD/POISON",
        "MAP:pg39",
        "ID:771014");

    doTest("T17",
        "(911 CALL) HILLTOP LN & REINMILLER RD  CrossStreets: STRUCTURE FIRE ESN: pg9 Call Number: 771084",
        "ADDR:HILLTOP LN & REINMILLER RD",
        "CALL:STRUCTURE FIRE",
        "MAP:pg9",
        "ID:771084");

    doTest("T18",
        "(911 CALL) HILLTOP LN & REINMILLER RD  CrossStreets: STRUCTURE FIRE-D / MH-PORTABLE OFC ESN: pg9 Call Number: 771084",
        "ADDR:HILLTOP LN & REINMILLER RD",
        "CALL:STRUCTURE FIRE-D / MH-PORTABLE OFC",
        "MAP:pg9",
        "ID:771084");

    doTest("T19",
        "(911 CALL) 4995 EDWARD LN  CrossStreets: DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E FALL ESN: pg5 Call Number: 771137",
        "ADDR:4995 EDWARD LN",  // Not mapping
        "X:DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E",
        "CALL:FALL",
        "MAP:pg5",
        "ID:771137");

    doTest("T20",
        "(911 CALL) 5203 S RANGELINE RD EXTREME SPORTS SCUBA/EDS ELECTRIC CrossStreets: SAGINAW RD 0.09 mi N SUNSET PL 0.03 mi S SICK PERSON ESN: pg49 Call Number: 771254",
        "ADDR:5203 S RANGELINE RD",
        "PLACE:EXTREME SPORTS SCUBA / EDS ELECTRIC",
        "X:SAGINAW RD 0.09 mi N SUNSET PL 0.03 mi S",
        "CALL:SICK PERSON",
        "MAP:pg49",
        "ID:771254");

    doTest("T21",
        "(911 CALL) 4531 HICKORY LN 4531 HICKORY LN CrossStreets: SILVER CREEK DR 0.15 mi N MARTIN DR 0.18 mi S BREATHING PROB ESN: pg53 Call Number: 771261",
        "ADDR:4531 HICKORY LN",
        "X:SILVER CREEK DR 0.15 mi N MARTIN DR 0.18 mi S",
        "CALL:BREATHING PROB",
        "MAP:pg53",
        "ID:771261");

    doTest("T22",
        "(911 CALL) ARCADIA LN & NEWTON RD  CrossStreets: OUTSIDE FIRE ESN: pg4/38 Call Number: 771357",
        "ADDR:ARCADIA LN & NEWTON RD", // Not mapping
        "CALL:OUTSIDE FIRE",
        "MAP:pg4/38",
        "ID:771357");

    doTest("T23",
        "(911 CALL) 5646 CARVER RD CARVER NATIONAL MONUMENT CrossStreets: MACON LN 0.56 mi S HIGHWAY V 0.08 mi N OUTSIDE FIRE-D / BRUSH/GRASS ESN: pg10 Call Number: 771633",
        "ADDR:5646 CARVER RD",
        "PLACE:CARVER NATIONAL MONUMENT",
        "X:MACON LN 0.56 mi S HIGHWAY V 0.08 mi N",
        "CALL:OUTSIDE FIRE-D / BRUSH/GRASS",
        "MAP:pg10",
        "ID:771633");

    doTest("T24",
        "(911 CALL) 11319 HIGHWAY FF, Apt. A22 BYKOTA ESTATES MHP CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E CHEST PAIN ESN: pg25 Call Number: 771728",
        "ADDR:11319 HIGHWAY FF",
        "APT:A22",
        "PLACE:BYKOTA ESTATES MHP",
        "X:REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E",
        "CALL:CHEST PAIN",
        "MAP:pg25",
        "ID:771728");

    doTest("T25",
        "(911 CALL) HIGHWAY 71 & HIGHWAY V  CrossStreets: TA INJURY ESN: pg26 Call Number: 771800",
        "ADDR:HIGHWAY 71 & HIGHWAY V",
        "CALL:TA INJURY",
        "MAP:pg26",
        "ID:771800");

    doTest("T26",
        "(911 CALL) 4257 HIGHWAY NN  CrossStreets: BROADLAWN BLVD 0.35 mi NW CLIFF LN 0.18 mi SE SICK PERSON ESN: pg4/38 Call Number: 771825",
        "ADDR:4257 HIGHWAY NN",
        "X:BROADLAWN BLVD 0.35 mi NW CLIFF LN 0.18 mi SE",
        "CALL:SICK PERSON",
        "MAP:pg4/38",
        "ID:771825");

    doTest("T27",
        "(911 CALL) 4368 OLD HIGHWAY 71 SAGAMOUNT BIBLE CAMP CrossStreets: HAROLD LN 0.18 mi SE CHRISTY LN 0.22 mi NW OUTSIDE FIRE ESN: pg9 Call Number: 771831",
        "ADDR:4368 OLD HIGHWAY 71",
        "PLACE:SAGAMOUNT BIBLE CAMP",
        "X:HAROLD LN 0.18 mi SE CHRISTY LN 0.22 mi NW",
        "CALL:OUTSIDE FIRE",
        "MAP:pg9",
        "ID:771831");

    doTest("T28",
        "(911 CALL) 4704 ELM DR  CrossStreets: CARTER LN 0.23 mi W HIGHWAY 43 0.23 mi E TA INJURY ESN: pg5 Call Number: 771874",
        "ADDR:4704 ELM DR",
        "X:CARTER LN 0.23 mi W HIGHWAY 43 0.23 mi E",
        "CALL:TA INJURY",
        "MAP:pg5",
        "ID:771874");

    doTest("T29",
        "(911 CALL) HIGHWAY NN & E HIGHWAY 86  CrossStreets: INFO-EMS ESN: pg11 Call Number: 772128",
        "ADDR:HIGHWAY NN & E HIGHWAY 86",
        "CALL:INFO-EMS",
        "MAP:pg11",
        "ID:772128");

    doTest("T30",
        "(911 CALL) 115 BURGESS ST 115 BURGESS ST CrossStreets: WOODLAND DR 0.73 mi N SAGINAW RD 0.73 mi S STROKE ESN: pg49 Call Number: 772174",
        "ADDR:115 BURGESS ST",
        "X:WOODLAND DR 0.73 mi N SAGINAW RD 0.73 mi S",
        "CALL:STROKE",
        "MAP:pg49",
        "ID:772174");

    doTest("T31",
        "(911 CALL) 3405 SCHIFFERDECKER AVE, Apt. COMMON AREA OZARK OAKS & RCF CrossStreets: W 32ND ST 0.08 mi N CROW RD 0.16 mi S BREATHING PROB-D / DIFF SPK BTWN BREATHS ESN: PG4/24/36 Call Number: 772188",
        "ADDR:3405 SCHIFFERDECKER AVE",
        "APT:COMMON",
        "PLACE:AREA OZARK OAKS & RCF",
        "X:W 32ND ST 0.08 mi N CROW RD 0.16 mi S",
        "CALL:BREATHING PROB-D / DIFF SPK BTWN BREATHS",
        "MAP:PG4/24/36",
        "ID:772188");

    doTest("T32",
        "(911 CALL) 3112 BAY DR  CrossStreets: IMPALA DR 0.03 mi W BIRCH DR 0.31 mi SE CHEST PAIN ESN: pg9 Call Number: 772264",
        "ADDR:3112 BAY DR",
        "X:IMPALA DR 0.03 mi W BIRCH DR 0.31 mi SE",
        "CALL:CHEST PAIN",
        "MAP:pg9",
        "ID:772264");

    doTest("T33",
        "(911 CALL) 4617 S JACKSON AVE  CrossStreets: W 46TH ST 0.02 mi NW EDGEWOOD RD 0.23 mi SW TA INJURY ESN: pg51 Call Number: 772270",
        "ADDR:4617 S JACKSON AVE",
        "X:W 46TH ST 0.02 mi NW EDGEWOOD RD 0.23 mi SW",
        "CALL:TA INJURY",
        "MAP:pg51",
        "ID:772270");

    doTest("T34",
        "(911 CALL) HIGHWAY 71 & HIGHWAY FF  CrossStreets: TA INJURY ESN: pg25 Call Number: 772284",
        "ADDR:HIGHWAY 71 & HIGHWAY FF",
        "CALL:TA INJURY",
        "MAP:pg25",
        "ID:772284");

    doTest("T35",
        "(911 CALL) 10032 BIRCH DR  CrossStreets: STACY LN 0.13 mi W HERON DR 0.13 mi W TRAUMATIC INJS ESN: pg9 Call Number: 772512",
        "ADDR:10032 BIRCH DR",
        "X:STACY LN 0.13 mi W HERON DR 0.13 mi W",
        "CALL:TRAUMATIC INJS",
        "MAP:pg9",
        "ID:772512");

    doTest("T36",
        "(911 CALL) GREENWOOD DR & APRICOT DR  CrossStreets: TA INJURY ESN: pg4/38 Call Number: 772560",
        "ADDR:GREENWOOD DR & APRICOT DR",
        "CALL:TA INJURY",
        "MAP:pg4/38",
        "ID:772560");

    doTest("T37",
        "(911 CALL) 1625 APRICOT DR  CrossStreets: ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W CHEST PAIN ESN: pg4/38 Call Number: 772607",
        "ADDR:1625 APRICOT DR",
        "X:ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W",
        "CALL:CHEST PAIN",
        "MAP:pg4/38",
        "ID:772607");

    doTest("T38",
        "(911 CALL) ANGUS DR & STATE LINE RD  CrossStreets: TA-D (TONE PD) HIGH MECH-ROLLOVER ESN: pg5 Call Number: 772689",
        "ADDR:ANGUS DR & STATE LINE RD",
        "CALL:TA-D (TONE PD) HIGH MECH-ROLLOVER",
        "MAP:pg5",
        "ID:772689");

    doTest("T39",
        "(911 CALL) HIGHWAY 71 & GATEWAY DR  CrossStreets: TA INJURY ESN: pg26 Call Number: 772725",
        "ADDR:HIGHWAY 71 & GATEWAY DR",
        "CALL:TA INJURY",
        "MAP:pg26",
        "ID:772725");

    doTest("T40",
        "(911 CALL) , Apt. B5 BYKOTA ESTATES MHP CrossStreets: ELECTRICAL HAZARD ESN:  Call Number: 772780",
        "APT:B5",
        "PLACE:BYKOTA ESTATES MHP",
        "CALL:ELECTRICAL HAZARD",
        "ID:772780");

    doTest("T41",
        "(911 CALL) IRIS RD & W HIGHWAY 86  CrossStreets: TA INJURY ESN: pg6 Call Number: 772832",
        "ADDR:IRIS RD & W HIGHWAY 86",
        "CALL:TA INJURY",
        "MAP:pg6",
        "ID:772832");

    doTest("T42",
        "(911 CALL) RIVER RD & S RANGELINE RD  CrossStreets: ELECTRICAL HAZARD ESN: pg4/38 Call Number: 772994",
        "ADDR:RIVER RD & S RANGELINE RD",
        "CALL:ELECTRICAL HAZARD",
        "MAP:pg4/38",
        "ID:772994");

    doTest("T43",
        "(911 CALL) 8695 BETHEL RD  CrossStreets: HOLLY RD 0.20 mi N HUNNEY LN 0.39 mi S BREATHING PROB ESN: pg5 Call Number: 773047",
        "ADDR:8695 BETHEL RD",
        "X:HOLLY RD 0.20 mi N HUNNEY LN 0.39 mi S",
        "CALL:BREATHING PROB",
        "MAP:pg5",
        "ID:773047");

    doTest("T44",
        "(911 CALL) 7157 GREENBRIER DR  CrossStreets: ELAND RD 0.19 mi W FINCH DR 0.31 mi E OUTSIDE FIRE ESN: pg5 Call Number: 773057",
        "ADDR:7157 GREENBRIER DR",
        "X:ELAND RD 0.19 mi W FINCH DR 0.31 mi E",
        "CALL:OUTSIDE FIRE",
        "MAP:pg5",
        "ID:773057");

    doTest("T45",
        "(911 CALL) 2530 HOLLY RD  CrossStreets: AKRON LN 0.10 mi E BETHEL RD 0.93 mi W TA INJURY ESN: pg5 Call Number: 773154",
        "ADDR:2530 HOLLY RD",
        "X:AKRON LN 0.10 mi E BETHEL RD 0.93 mi W",
        "CALL:TA INJURY",
        "MAP:pg5",
        "ID:773154");

    doTest("T46",
        "(911 CALL) 4995 EDWARD LN  CrossStreets: DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E UNK PRO/MAN DWN ESN: pg5 Call Number: 773162",
        "ADDR:4995 EDWARD LN", // Not mapping
        "X:DEAD END 0.63 mi W HIGHWAY 43 0.63 mi E",
        "CALL:UNK PRO/MAN DWN",
        "MAP:pg5",
        "ID:773162");

    doTest("T47",
        "(911 CALL) HIGHWAY 43 & DOUGLAS FIR RD  CrossStreets: HEAT/COLD EXPOSURE ESN: pg5 Call Number: 773226",
        "ADDR:HIGHWAY 43 & DOUGLAS FIR RD",
        "CALL:HEAT/COLD EXPOSURE",
        "MAP:pg5",
        "ID:773226");

    doTest("T48",
        "(911 CALL) 203 CREEK RD 203 CREEK RD CrossStreets: SAGINAW RD 0.10 mi E TA INJURY ESN: pg49 Call Number: 773391",
        "ADDR:203 CREEK RD",
        "X:SAGINAW RD 0.10 mi E",
        "CALL:TA INJURY",
        "MAP:pg49",
        "ID:773391");

    doTest("T49",
        "(911 CALL) 1625 APRICOT DR  CrossStreets: ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W STROKE ESN: pg4/38 Call Number: 773615",
        "ADDR:1625 APRICOT DR",
        "X:ALPACA RD 0.20 mi SE AUSTIN DR 0.39 mi W",
        "CALL:STROKE",
        "MAP:pg4/38",
        "ID:773615");

    doTest("T50",
        "(911 CALL) HIGHWAY 43 & DAKOTA LN  CrossStreets: TA INJURY ESN: pg4/38 Call Number: 773680",
        "ADDR:HIGHWAY 43 & DAKOTA LN",
        "CALL:TA INJURY",
        "MAP:pg4/38",
        "ID:773680");

    doTest("T51",
        "(911 CALL) HIGHWAY P & W HIGHWAY 86  CrossStreets: OD/POISON ESN: pg5 Call Number: 773883",
        "ADDR:HIGHWAY P & W HIGHWAY 86",
        "CALL:OD/POISON",
        "MAP:pg5",
        "ID:773883");

    doTest("T52",
        "(911 CALL) 1185 OUTER RD 1185 OUTER RD CrossStreets: RAINBOW DR 0.34 mi W REINMILLER RD 0.34 mi E SICK PERSON ESN: pg25 Call Number: 774053",
        "ADDR:1185 OUTER RD",
        "X:RAINBOW DR 0.34 mi W REINMILLER RD 0.34 mi E",
        "CALL:SICK PERSON",
        "MAP:pg25",
        "ID:774053");

    doTest("T53",
        "(911 CALL) 5725 HIGHWAY 43 GO ZONE CrossStreets: DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S TA INJURY ESN: pg5 Call Number: 774079",
        "ADDR:5725 HIGHWAY 43",
        "PLACE:GO ZONE",
        "X:DUTCH ELM DR 0.02 mi NE DELFIN LN 0.05 mi S",
        "CALL:TA INJURY",
        "MAP:pg5",
        "ID:774079");

    doTest("T54",
        "(911 CALL) REINMILLER RD & APRICOT DR  CrossStreets: ROAD CLOSING (PG FD) ESN: pg25 Call Number: 774188",
        "ADDR:REINMILLER RD & APRICOT DR",
        "CALL:ROAD CLOSING (PG FD)",
        "MAP:pg25",
        "ID:774188");

    doTest("T55",
        "(911 CALL) 3944 W 7TH ST WASTE CORPERATON CrossStreets: MUTUAL AID-B / ASST OUTSIDE/HOT ESN:  Call Number: 774207",
        "ADDR:3944 W 7TH ST",
        "PLACE:WASTE CORPERATON",
        "CALL:MUTUAL AID-B / ASST OUTSIDE/HOT",
        "ID:774207");

    doTest("T56",
        "(911 CALL) 7648 GREENBRIER DR  CrossStreets: ELGIN LN 0.10 mi E FINCH DR 0.11 mi W BREATHING PROB-E / INEFFECTIVE BREATHING ESN: pg5 Call Number: 774310",
        "ADDR:7648 GREENBRIER DR",
        "X:ELGIN LN 0.10 mi E FINCH DR 0.11 mi W",
        "CALL:BREATHING PROB-E / INEFFECTIVE BREATHING",
        "MAP:pg5",
        "ID:774310");

    doTest("T57",
        "(911 CALL) 11319 HIGHWAY FF, Apt. B18  CrossStreets: REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E HEART PROB ESN: pg25 Call Number: 774327",
        "ADDR:11319 HIGHWAY FF",
        "APT:B18",
        "X:REINMILLER RD 0.16 mi W JOPLIN LN 0.16 mi E",
        "CALL:HEART PROB",
        "MAP:pg25",
        "ID:774327");

    doTest("T58",
        "(911 CALL) 1450 IRIS RD  CrossStreets: STATE LINE RD 0.13 mi W BETHEL RD 0.52 mi E FALL ESN: pg6 Call Number: 774366",
        "ADDR:1450 IRIS RD",
        "X:STATE LINE RD 0.13 mi W BETHEL RD 0.52 mi E",
        "CALL:FALL",
        "MAP:pg6",
        "ID:774366");

    doTest("T59",
        "(911 CALL) 7859 FAIR PORT LN  CrossStreets: DEAD END 0.20 mi N HIGHWAY P 0.20 mi S OUTSIDE FIRE ESN: pg5 Call Number: 774465",
        "ADDR:7859 FAIR PORT LN",
        "X:DEAD END 0.20 mi N HIGHWAY P 0.20 mi S",
        "CALL:OUTSIDE FIRE",
        "MAP:pg5",
        "ID:774465");

    doTest("T60",
        "(911 CALL) FULTON LN & HIGHWAY NN  CrossStreets: TA INJURY ESN: pg5 Call Number: 774512",
        "ADDR:FULTON LN & HIGHWAY NN", // Not mapping
        "CALL:TA INJURY",
        "MAP:pg5",
        "ID:774512");

    doTest("T61",
        "(911 CALL) 6995 FLETCHER LN  CrossStreets: DEAD END 0.05 mi W IMPALA DR 0.05 mi E CHEST PAIN ESN: pg26 Call Number: 774533",
        "ADDR:6995 FLETCHER LN",  // Not mapping
        "X:DEAD END 0.05 mi W IMPALA DR 0.05 mi E",
        "CALL:CHEST PAIN",
        "MAP:pg26",
        "ID:774533");

    doTest("T62",
        "(911 CALL) 3323 S TEXAS AVE JOPLIN FIRE STATION 5 CrossStreets: MUTUAL AID-A / ASST OUTSIDE/COLD ESN:  Call Number: 774592",
        "ADDR:3323 S TEXAS AVE",
        "PLACE:JOPLIN FIRE STATION 5",
        "CALL:MUTUAL AID-A / ASST OUTSIDE/COLD",
        "ID:774592");

    doTest("T63",
        "(911 CALL) 905 CASTLE DR  CrossStreets: DANIEL BOONE DR 0.02 mi N MARK TWAIN DR 002 mi S TRAUMATIC INJS ESN: pg47 Call Number: 774593",
        "ADDR:905 CASTLE DR",
        "X:DANIEL BOONE DR 0.02 mi N MARK TWAIN DR 002 mi S",
        "CALL:TRAUMATIC INJS",
        "MAP:pg47",
        "ID:774593");
  }
  
  public static void main(String[] args) {
    new MONewtonCountyParserTest().generateTests("T1");
  }
}