package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTMadisonParserTest extends BaseParserTest {
  
  public CTMadisonParserTest() {
    setParser(new CTMadisonParser(), "MADISON", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Madison: FALLS- BLS COLD*- 17-B-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T2",
        "Madison: UNCONS/FAINTING- NOT ALERT- ALS HOT- 31-D-3  00032  LIBERTY ST  X-STR: -  Hilltop Dr/Grove Ave Premise: 32 LIBERTY ST",
        "CALL:UNCONS/FAINTING- NOT ALERT- ALS HOT",
        "CODE:31-D-3",
        "ADDR:32 LIBERTY ST",
        "X:Hilltop Dr/Grove Ave");

    doTest("T3",
        "Madison: HEART/ BLS COLD - 19-A-1  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:HEART/ BLS COLD",
        "CODE:19-A-1",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T4",
        "Madison: BACK PAIN- BLS COLD- 5-A-1  00146  PRINCESS DR  X-STR: -  RT 79 NORTH/PRINCESS DR LOOP Premise: 146 PRINCESS DR",
        "CALL:BACK PAIN- BLS COLD",
        "CODE:5-A-1",
        "ADDR:146 PRINCESS DR",
        "X:RT 79 NORTH/PRINCESS DR LOOP");

    doTest("T5",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-1  00049  WHITMAN RD  X-STR: -  Nursery Ln/DEAD END Premise: 49 WHITMAN RD",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-1",
        "ADDR:49 WHITMAN RD",
        "X:Nursery Ln/DEAD END");

    doTest("T6",
        "Madison: TRAUMATIC INJURY/ MINOR- BLS COLD- 30-A-1  01414  DURHAM RD  X-STR: -  ASPEN DR/WHITE CEDAR Premise: 1414 DURHAM RD",
        "CALL:TRAUMATIC INJURY/ MINOR- BLS COLD",
        "CODE:30-A-1",
        "ADDR:1414 DURHAM RD",
        "X:ASPEN DR/WHITE CEDAR");

    doTest("T7",
        "Madison: BLEEDING/ BLS HOT- 21-B-2  00048  FLINTLOCK RD  X-STR: -  Hunters Trl/Wildcat Rd Premise: 48 FLINTLOCK RD",
        "CALL:BLEEDING/ BLS HOT",
        "CODE:21-B-2",
        "ADDR:48 FLINTLOCK RD",
        "X:Hunters Trl/Wildcat Rd");

    doTest("T8",
        "Madison: ABDOMINAL PAIN- BLS COLD- 1-A-1  00133  TWIN COVES RD  X-STR: -  Bassett Ln/Bassett Ln Premise: 133 TWIN COVES RD",
        "CALL:ABDOMINAL PAIN- BLS COLD",
        "CODE:1-A-1",
        "ADDR:133 TWIN COVES RD",
        "X:Bassett Ln/Bassett Ln");

    doTest("T9",
        "Madison: BACK PAIN- BLS COLD- 5-A-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:BACK PAIN- BLS COLD",
        "CODE:5-A-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T10",
        "Madison: SICK/ NON SPECIFIC - BLS COLD- 26-A-1  00142  TWILIGHT DR  X-STR: -  LAKE DR/TWILIGHT DR LOOP Premise: 142 TWILIGHT DR",
        "CALL:SICK/ NON SPECIFIC - BLS COLD",
        "CODE:26-A-1",
        "ADDR:142 TWILIGHT DR",
        "X:LAKE DR/TWILIGHT DR LOOP");

    doTest("T11",
        "Madison: DIABETIC/ NOT ALERT- ALS HOT- 13-C-1  00271  WARPAS RD  X-STR: -  Amber Trl/Copperstone Ln Premise: 271 WARPAS RD",
        "CALL:DIABETIC/ NOT ALERT- ALS HOT",
        "CODE:13-C-1",
        "ADDR:271 WARPAS RD",
        "X:Amber Trl/Copperstone Ln");

    doTest("T12",
        "Madison: UNCONS/FAINTING- CARDIAC HIST.- ALS HOT- 31-C-2  SUMMIT LA/ SUFFOLK DR  X-STR:  Premise: SUMMIT LA/ SUFFOLK DR",
        "CALL:UNCONS/FAINTING- CARDIAC HIST.- ALS HOT",
        "CODE:31-C-2",
        "ADDR:SUMMIT LA & SUFFOLK DR",
        "MADDR:SUMMIT LN & SUFFOLK DR");

    doTest("T13",
        "Madison: MV ACCIDENT-INJURIES  01647  DURHAM RD (CATI)  X-STR: -  GOAT LOT RD/HARRY FIELD RD Premise: 01647  DURHAM RD (CATI)",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:1647 DURHAM RD (CATI)",
        "MADDR:1647 DURHAM RD",
        "X:GOAT LOT RD/HARRY FIELD RD");

    doTest("T14",
        "Madison: BREATHING PROBLEM- ALS HOT- 6-C-1  00070  WOODLAND RD  X-STR: Brantwood Dr/COPSE RD Premise: CONCORD MEADOWS",
        "CALL:BREATHING PROBLEM- ALS HOT",
        "CODE:6-C-1",
        "ADDR:70 WOODLAND RD",
        "X:Brantwood Dr/COPSE RD",
        "PLACE:CONCORD MEADOWS");

    doTest("T15",
        "Madison: BLEEDING/ BLS HOT- 21-B-1  00030  OVERLOOK DR  X-STR: -  ROCKLEDGE DR/DEAD END Premise: 30 OVERLOOK DR",
        "CALL:BLEEDING/ BLS HOT",
        "CODE:21-B-1",
        "ADDR:30 OVERLOOK DR",
        "X:ROCKLEDGE DR/DEAD END");

    doTest("T16",
        "Madison: CHEST PAIN/ NOT ALERT- ALS HOT- 10-D-2  00864  OPENING HILL RD  X-STR: -  RT 79/SPERRY RD Premise: NORTH MADISON FIRE DEPARTMENT",
        "CALL:CHEST PAIN/ NOT ALERT- ALS HOT",
        "CODE:10-D-2",
        "ADDR:864 OPENING HILL RD",
        "X:RT 79/SPERRY RD",
        "PLACE:NORTH MADISON FIRE DEPARTMENT");

    doTest("T17",
        "Madison: PSYCH/ NOT SUICIDAL- BLS COLD- 25-A-1  00009  CAMPUS DR  X-STR: -  DUCK HOLE RD /TOWN CAMPUS Premise: MADISON POLICE DEPARTMENT HQ",
        "CALL:PSYCH/ NOT SUICIDAL- BLS COLD",
        "CODE:25-A-1",
        "ADDR:9 CAMPUS DR",
        "X:DUCK HOLE RD /TOWN CAMPUS",
        "PLACE:MADISON POLICE DEPARTMENT HQ");

    doTest("T18",
        "Madison: MV ACCIDENT-INJURIES  I-95 NB EXIT 61>EXIT 62  X-STR: -   Premise: I-95 NB EXIT 61>EXIT 62",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:I-95 NB EXIT 61>EXIT 62",
        "MADDR:I 95 EXIT 61>EXIT 62");

    doTest("T19",
        "Madison: DIABETIC/ NOT ALERT- ALS HOT- 13-C-1  00282  BOSTON POST RD  X-STR: -  Neck Rd/WHEDON LN Premise: 282 BOSTON POST RD",
        "CALL:DIABETIC/ NOT ALERT- ALS HOT",
        "CODE:13-C-1",
        "ADDR:282 BOSTON POST RD",
        "X:Neck Rd/WHEDON LN");

    doTest("T20",
        "Madison: BREATHING PROBLEM- ALS HOT- 6-C-1  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:BREATHING PROBLEM- ALS HOT",
        "CODE:6-C-1",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T21",
        "Madison: FALLS- BLS COLD*- 17-B-1  00027  WILLOW LA  X-STR: BEECHWOOD DR/ DEAD END Premise: 27 WILLOW LA",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:27 WILLOW LA",
        "MADDR:27 WILLOW LN",
        "X:BEECHWOOD DR/ DEAD END");

    doTest("T22",
        "Madison: BACK PAIN- BLS COLD- 5-A-1  00463  SUMMER HILL RD  X-STR: -  RT 80 EAST/SHEPHERDS TRAIL Premise: CAMP LAURELWOOD",
        "CALL:BACK PAIN- BLS COLD",
        "CODE:5-A-1",
        "ADDR:463 SUMMER HILL RD",
        "X:RT 80 EAST/SHEPHERDS TRAIL",
        "PLACE:CAMP LAURELWOOD");

    doTest("T23",
        "Madison: FALLS- BLS COLD- 17-A-1  00210  NECK RD  X-STR: -  Highland Ter/Ridgewood Ave Premise: 210 NECK RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:210 NECK RD",
        "X:Highland Ter/Ridgewood Ave");

    doTest("T24",
        "Madison: STROKE/ VISION AFF.- ALS HOT- 28-C-5  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:STROKE/ VISION AFF.- ALS HOT",
        "CODE:28-C-5",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T25",
        "Madison: MEDICAL ASSISTANCE NEEDED  00027  HOTCHKISS LA  X-STR: -  Liberty St/DEAD END Premise: 27 HOTCHKISS LA",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:27 HOTCHKISS LA",
        "MADDR:27 HOTCHKISS LN",
        "X:Liberty St/DEAD END");

    doTest("T26",
        "Madison: TRAUMA/ POSS SEVERE- BLS HOT- 30-B-1  00087  SURF CLUB RD  X-STR: Holly Park Rd/DEAD END Premise: SURF CLUB",
        "CALL:TRAUMA/ POSS SEVERE- BLS HOT",
        "CODE:30-B-1",
        "ADDR:87 SURF CLUB RD",
        "X:Holly Park Rd/DEAD END",
        "PLACE:SURF CLUB");

    doTest("T27",
        "Madison: FALLS- BLS COLD- 17-A-1  00019  PARDEE PL  X-STR: -  MIUNGERTOWN RD/SALEM RD Premise: 19 PARDEE PL",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:19 PARDEE PL",
        "X:MIUNGERTOWN RD/SALEM RD");

    doTest("T28",
        "Madison: FALLS- BLS COLD*- 17-B-1  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T29",
        "Madison: BREATHING DISTRESS - ALS HOT - 6-D-4  00012  AYLESBURY CIR  X-STR: -  COTTAGE RD/MAYBURY PL (WINDERMERE) Premise: 12 AYLESBURY CIR",
        "CALL:BREATHING DISTRESS - ALS HOT",
        "CODE:6-D-4",
        "ADDR:12 AYLESBURY CIR",
        "X:COTTAGE RD/MAYBURY PL (WINDERMERE)");

    doTest("T30",
        "Madison: UNCONS/FAINTING- NOT ALERT- ALS HOT- 31-D-3  00064  QUARRY LEDGE RD  X-STR: -   Premise: 64 QUARRY LEDGE",
        "CALL:UNCONS/FAINTING- NOT ALERT- ALS HOT",
        "CODE:31-D-3",
        "ADDR:64 QUARRY LEDGE RD",
        "PLACE:64 QUARRY LEDGE");

    doTest("T31",
        "Madison: CHEST PAIN/ UNDER 35- BLS COLD- 10-A-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:CHEST PAIN/ UNDER 35- BLS COLD",
        "CODE:10-A-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T32",
        "Madison: MUTUAL AID - AMBULANCE GUILFRD  00400  CHURCH ST  X-STR: -   Premise: GUILFORD POLICE DEPARTMENT",
        "CALL:MUTUAL AID - AMBULANCE GUILFRD",
        "ADDR:400 CHURCH ST",
        "PLACE:GUILFORD POLICE DEPARTMENT");

    doTest("T33",
        "Madison: CHEST PAIN - ALS HOT- 10-D-2  00600  GREEN HILL RD  X-STR: -  Kelsey Springs Dr/Buttonball Ln Premise: 600 GREEN HILL RD",
        "CALL:CHEST PAIN - ALS HOT",
        "CODE:10-D-2",
        "ADDR:600 GREEN HILL RD",
        "X:Kelsey Springs Dr/Buttonball Ln");

    doTest("T34",
        "Madison: FALL / UNCONS- 17-D-3  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALL / UNCONS",
        "CODE:17-D-3",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T35",
        "Madison: UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT- 32-B-2  00017  FOREST RD  X-STR: -  Durham Rd/Fox Run Rd Premise: 17 FOREST RD",
        "CALL:UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT",
        "CODE:32-B-2",
        "ADDR:17 FOREST RD",
        "X:Durham Rd/Fox Run Rd");

    doTest("T36",
        "Madison: BREATHING PROBLEM- ALS HOT- 6-C-1   S I-95   X-STR: -   Premise: I-95 SB EXIT 60>GUILFORD LINE",
        "CALL:BREATHING PROBLEM- ALS HOT",
        "CODE:6-C-1",
        "ADDR:S I-95",
        "MADDR:I-95 SB EXIT 60>GUILFORD LINE,S I 95",
        "PLACE:I-95 SB EXIT 60>GUILFORD LINE");

    doTest("T37",
        "Madison: BREATHING PROBLEM- ALS HOT- 6-C-1  00251  NECK RD  X-STR: -  Highland Ter/Ridgewood Ave Premise: 251 NECK RD",
        "CALL:BREATHING PROBLEM- ALS HOT",
        "CODE:6-C-1",
        "ADDR:251 NECK RD",
        "X:Highland Ter/Ridgewood Ave");

    doTest("T38",
        "Madison: UNCONS/FAINTING- ABNORM BREATHING- ALS HOT- 31-C-1  00087  SURF CLUB RD  X-STR: -  Holly Park Rd/DEAD END Premise: SURF CLUB",
        "CALL:UNCONS/FAINTING- ABNORM BREATHING- ALS HOT",
        "CODE:31-C-1",
        "ADDR:87 SURF CLUB RD",
        "X:Holly Park Rd/DEAD END",
        "PLACE:SURF CLUB");

    doTest("T39",
        "Madison: MV ACCIDENT-INJURIES  HORSE POND RD/ DURHAM RD  X-STR:  Premise: HORSE POND RD/ DURHAM RD",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:HORSE POND RD & DURHAM RD");

    doTest("T40",
        "Madison: FALL / UNCONS- 17-D-3  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:FALL / UNCONS",
        "CODE:17-D-3",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T41",
        "Madison: FALLS- BLS COLD*- 17-B-1  00090  HULL RD  X-STR: -  SAXON RD/JUNIPER LN Premise: 90 HULL RD",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:90 HULL RD",
        "X:SAXON RD/JUNIPER LN");

    doTest("T42",
        "Madison: LIFT ASSIST - BLS COLD - 17-A-3  00002  ESTERLY FARMS RD  X-STR: -  DEAD END/Mungertown Rd Premise: 2 ESTERLY FARMS RD",
        "CALL:LIFT ASSIST - BLS COLD",
        "CODE:17-A-3",
        "ADDR:2 ESTERLY FARMS RD",
        "X:DEAD END/Mungertown Rd");

    doTest("T43",
        "Madison: FALLS- BLS COLD- 17-A-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T44",
        "Madison: ANIMAL BITE/ NOT RECENT- BLS COLD- 3-A-2  00509  COUNTY RD  X-STR: -  Suffolk Dr/Summer Hill Rd Premise: 509 COUNTY RD",
        "CALL:ANIMAL BITE/ NOT RECENT- BLS COLD",
        "CODE:3-A-2",
        "ADDR:509 COUNTY RD",
        "X:Suffolk Dr/Summer Hill Rd");

    doTest("T45",
        "Madison: BLEEDING/ ABNORM BREATHING- ALS HOT- 21-D-3  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:BLEEDING/ ABNORM BREATHING- ALS HOT",
        "CODE:21-D-3",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T46",
        "Madison: CHOKING- ALS HOT- 11-D-1  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:CHOKING- ALS HOT",
        "CODE:11-D-1",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T47",
        "Madison: UNCONS/FAINTING - ALS HOT - 31-D-4  00144  HARBOR AVE  X-STR: -  Neck Rd Premise: 144 HARBOR AVE",
        "CALL:UNCONS/FAINTING - ALS HOT",
        "CODE:31-D-4",
        "ADDR:144 HARBOR AVE",
        "X:Neck Rd");

    doTest("T48",
        "Madison: FALLS- BLS COLD*- 17-B-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T49",
        "Madison: FALLS- BLS COLD- 17-A-1  00250  SAMSON ROCK DR  X-STR: Boston Post Rd/MEIGS AVE Premise: BANK OF AMERICA",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:250 SAMSON ROCK DR",
        "X:Boston Post Rd/MEIGS AVE",
        "PLACE:BANK OF AMERICA");

    doTest("T50",
        "Madison: INTERFACILITY/ NOT ALERT- ALS HOT- 33-C-1  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:INTERFACILITY/ NOT ALERT- ALS HOT",
        "CODE:33-C-1",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T51",
        "Madison: HEAT/COLD EXPOSURE- ALS HOT- 20-C-1  02105  DURHAM RD  X-STR: -  DORSET LN/STEPHANIE CT Premise: 2105 DURHAM RD",
        "CALL:HEAT/COLD EXPOSURE- ALS HOT",
        "CODE:20-C-1",
        "ADDR:2105 DURHAM RD",
        "X:DORSET LN/STEPHANIE CT");

    doTest("T52",
        "Madison: FALLS- BLS COLD- 17-A-1  00039  GODMAN RD  X-STR: -  Warpas Rd/DEAD END Premise: 39 GODMAN RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:39 GODMAN RD",
        "X:Warpas Rd/DEAD END");

    doTest("T53",
        "Madison: FALLS- BLS COLD*- 17-B-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T54",
        "Madison: HEADACHE/ SEVERE- ALS HOT- 18-C-4  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:HEADACHE/ SEVERE- ALS HOT",
        "CODE:18-C-4",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T55",
        "Madison: MEDICAL ASSISTANCE NEEDED  00042  LAWSON DR  X-STR: -  Madison Ave/DEAD END Premise: 42 LAWSON DR",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:42 LAWSON DR",
        "X:Madison Ave/DEAD END");

    doTest("T56",
        "Madison: SICK ALTERED LOC - ALS - 26-C-1  00037  BEACH AVE  X-STR: -  NECK RD/DEAD END Premise: 37 BEACH AVE",
        "CALL:SICK ALTERED LOC - ALS",
        "CODE:26-C-1",
        "ADDR:37 BEACH AVE",
        "X:NECK RD/DEAD END");

    doTest("T57",
        "Madison: PSYCH/ NOT SUICIDAL- BLS COLD- 25-A-1  00021  HAMPSHIRE RD  X-STR: -  STRATHMORE/ESSEX (KENSINGTON NORTH) Premise: 21 HAMPSHIRE RD",
        "CALL:PSYCH/ NOT SUICIDAL- BLS COLD",
        "CODE:25-A-1",
        "ADDR:21 HAMPSHIRE RD",
        "X:STRATHMORE/ESSEX (KENSINGTON NORTH)");

    doTest("T58",
        "Madison: DIABETIC/ NOT ALERT- ALS HOT- 13-C-1  00818  BOSTON POST RD  X-STR: -  SAMSON ROCK DR/EAST WHARF RD Premise: 818 BOSTON POST RD (BIRNBAUM LA)",
        "CALL:DIABETIC/ NOT ALERT- ALS HOT",
        "CODE:13-C-1",
        "ADDR:818 BOSTON POST RD",
        "X:SAMSON ROCK DR/EAST WHARF RD",
        "PLACE:818 BOSTON POST RD (BIRNBAUM LA)");

    doTest("T59",
        "Madison: MV ACCIDENT-INJURIES  DURHAM RD/ GREEN HILL RD  X-STR:  Premise: DURHAM RD/ GREEN HILL RD",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:DURHAM RD & GREEN HILL RD");

    doTest("T60",
        "Madison: MEDICAL ASSISTANCE NEEDED  00069  SEAVIEW AVE  X-STR: -  Grove Ave/Woodlawn Ave Premise: 69 SEAVIEW AVE",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:69 SEAVIEW AVE",
        "X:Grove Ave/Woodlawn Ave");

    doTest("T61",
        "Madison: SICK/ NON SPECIFIC - BLS COLD- 26-A-1  00080  RIVER RD  X-STR: -   Premise: 80 RIVER RD",
        "CALL:SICK/ NON SPECIFIC - BLS COLD",
        "CODE:26-A-1",
        "ADDR:80 RIVER RD");

    doTest("T62",
        "Madison: BURNS UNKN STATUS - BLS HOT - 7-B-1  00021  STONEWALL LA  X-STR: -  Deer Run Rd Premise: 21 STONEWALL LA",
        "CALL:BURNS UNKN STATUS - BLS HOT",
        "CODE:7-B-1",
        "ADDR:21 STONEWALL LA",
        "MADDR:21 STONEWALL LN",
        "X:Deer Run Rd");

    doTest("T63",
        "Madison: DIABETIC/ NOW ALERT- BLS COLD- 13-A-1  00234  NECK RD  X-STR: -  Highland Ter/Ridgewood Ave Premise: 234 NECK RD",
        "CALL:DIABETIC/ NOW ALERT- BLS COLD",
        "CODE:13-A-1",
        "ADDR:234 NECK RD",
        "X:Highland Ter/Ridgewood Ave");

    doTest("T64",
        "Madison: SEIZURE- BREATHING NOT VERIF.- BLS HOT- 12-B-1  00463  SUMMER HILL RD  X-STR: -  RT 80 EAST/SHEPHERDS TRAIL Premise: CAMP LAURELWOOD",
        "CALL:SEIZURE- BREATHING NOT VERIF.- BLS HOT",
        "CODE:12-B-1",
        "ADDR:463 SUMMER HILL RD",
        "X:RT 80 EAST/SHEPHERDS TRAIL",
        "PLACE:CAMP LAURELWOOD");

    doTest("T65",
        "Madison: SICK/ NON SPECIFIC - BLS COLD- 26-A-1  00080  RIVER RD  X-STR: -   Premise: 80 RIVER RD",
        "CALL:SICK/ NON SPECIFIC - BLS COLD",
        "CODE:26-A-1",
        "ADDR:80 RIVER RD");

    doTest("T66",
        "Madison: SICK/ NON SPECIFIC - BLS COLD- 26-A-1  00129  ACORN RD  X-STR: -  Scotland Rd/Forest Hills Rd Premise: 129 ACORN RD",
        "CALL:SICK/ NON SPECIFIC - BLS COLD",
        "CODE:26-A-1",
        "ADDR:129 ACORN RD",
        "X:Scotland Rd/Forest Hills Rd");

    doTest("T67",
        "Madison: LIFT ASSIST - BLS COLD - 17-A-3  00024  WILSHIRE RD  X-STR: -  Lovers Ln/LADSHAW DR  (KENSINGTON SO.) Premise: 24 WILSHIRE RD",
        "CALL:LIFT ASSIST - BLS COLD",
        "CODE:17-A-3",
        "ADDR:24 WILSHIRE RD",
        "X:Lovers Ln/LADSHAW DR  (KENSINGTON SO.)");

    doTest("T68",
        "Madison: SICK/ PAIN- BLS COLD- 26-A-8  00027  WILLOW LA  X-STR: BEECHWOOD DR/ DEAD END Premise: 27 WILLOW LA",
        "CALL:SICK/ PAIN- BLS COLD",
        "CODE:26-A-8",
        "ADDR:27 WILLOW LA",
        "MADDR:27 WILLOW LN",
        "X:BEECHWOOD DR/ DEAD END");

    doTest("T69",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00041  WILSHIRE RD  X-STR: -  Ladshaw Dr/DEAD END (KENSINGTON SO.) Premise: 41 WILSHIRE RD",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:41 WILSHIRE RD",
        "X:Ladshaw Dr/DEAD END (KENSINGTON SO.)");

    doTest("T70",
        "Madison: UNCONS/FAINTING- CARDIAC HIST.- ALS HOT- 31-C-2  00703  BOSTON POST RD  X-STR: -  DURHAM RD/WALL ST Premise: PETER INDORF JEWELERS",
        "CALL:UNCONS/FAINTING- CARDIAC HIST.- ALS HOT",
        "CODE:31-C-2",
        "ADDR:703 BOSTON POST RD",
        "X:DURHAM RD/WALL ST",
        "PLACE:PETER INDORF JEWELERS");

    doTest("T71",
        "Madison: FALLS- BLS COLD- 17-A-1  00005  DEER CREEK DR  X-STR: GREEN HILL RD/DEAD END Premise: 5 DEER CREEK",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:5 DEER CREEK DR",
        "X:GREEN HILL RD/DEAD END",
        "PLACE:5 DEER CREEK");

    doTest("T72",
        "Madison: UNCONS/FAINTING- NOT ALERT- ALS HOT- 31-D-3  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:UNCONS/FAINTING- NOT ALERT- ALS HOT",
        "CODE:31-D-3",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T73",
        "Madison: TRANSP. ACCIDENT/ MINOR INJURIES- BLS COLD- 29-A-1  00178  WARPAS RD  X-STR: -  GODMAN RD/AMBER TRL Premise: 178 WARPAS RD",
        "CALL:TRANSP. ACCIDENT/ MINOR INJURIES- BLS COLD",
        "CODE:29-A-1",
        "ADDR:178 WARPAS RD",
        "X:GODMAN RD/AMBER TRL");

    doTest("T74",
        "Madison: MUTUAL AID - AMBULANCE GUILFRD  MUTUAL AID- GUILFORD  X-STR: -   Premise: MUTUAL AID- GUILFORD",
        "CALL:MUTUAL AID - AMBULANCE GUILFRD",
        "ADDR:MUTUAL AID- GUILFORD");

    doTest("T75",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  00056  New RD  X-STR: Birch Ln/Bishop Ln Premise: 00056  New RD",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:56 New RD",
        "X:Birch Ln/Bishop Ln");

    doTest("T76",
        "Madison: SICK ALTERED LOC - ALS - 26-C-1  00005  DEER CREEK DR  X-STR: -  GREEN HILL RD/DEAD END Premise: 5 DEER CREEK",
        "CALL:SICK ALTERED LOC - ALS",
        "CODE:26-C-1",
        "ADDR:5 DEER CREEK DR",
        "X:GREEN HILL RD/DEAD END",
        "PLACE:5 DEER CREEK");

    doTest("T77",
        "Madison: FALLS- BLS COLD- 17-A-1  00023  BRADLEY RD  X-STR: -  COPSE RD/ACADEMY ST Premise: 23 BRADLEY RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:23 BRADLEY RD",
        "X:COPSE RD/ACADEMY ST");

    doTest("T78",
        "Madison: HEADACHE/ SEVERE- ALS HOT- 18-C-4  00070  WOODLAND RD  X-STR: Brantwood Dr/COPSE RD Premise: CONCORD MEADOWS",
        "CALL:HEADACHE/ SEVERE- ALS HOT",
        "CODE:18-C-4",
        "ADDR:70 WOODLAND RD",
        "X:Brantwood Dr/COPSE RD",
        "PLACE:CONCORD MEADOWS");

    doTest("T79",
        "Madison: SICK/ ABNORMAL BREATHING - ALS - 26-C-2  01353  BOSTON POST RD  X-STR: DUDLEY LN/COTTAGE RD Premise: SHORELINE MEDICAL ASSOCIATES",
        "CALL:SICK/ ABNORMAL BREATHING - ALS",
        "CODE:26-C-2",
        "ADDR:1353 BOSTON POST RD",
        "X:DUDLEY LN/COTTAGE RD",
        "PLACE:SHORELINE MEDICAL ASSOCIATES");

    doTest("T80",
        "Madison: FALLS- BLS COLD*- 17-B-1  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T81",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T82",
        "Madison: HEART / UNKN STATUS- ALS - 19-C-7  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:HEART / UNKN STATUS- ALS",
        "CODE:19-C-7",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T83",
        "Madison: MV ACCIDENT-INJURIES   S I-95   X-STR: -   Premise: I-95 SB EXIT 62>EXIT 61",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:S I-95",
        "MADDR:I-95 SB EXIT 62>EXIT 61,S I 95",
        "PLACE:I-95 SB EXIT 62>EXIT 61");

    doTest("T84",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T85",
        "Madison: MEDICAL ASSISTANCE NEEDED  00105  WINDING RD  X-STR: -  WOODSVALE RD/WINDING RD LOOP Premise: 105 WINDING RD",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:105 WINDING RD",
        "X:WOODSVALE RD/WINDING RD LOOP");

    doTest("T86",
        "Madison: UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT- 32-B-2  00041  BEAVER POND RD  X-STR: -  ROLLING MEADOW/ROLLING MEADOW LOOP Premise: 41 BEAVER POND RD",
        "CALL:UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT",
        "CODE:32-B-2",
        "ADDR:41 BEAVER POND RD",
        "X:ROLLING MEADOW/ROLLING MEADOW LOOP");

    doTest("T87",
        "Madison: MEDICAL ASSISTANCE NEEDED  00094  DUCK HOLE RD  X-STR: -  NEW RD/CAMPUS DR Premise: 94 DUCK HOLE RD",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:94 DUCK HOLE RD",
        "X:NEW RD/CAMPUS DR");

    doTest("T88",
        "Madison: PSYCH/ THREAT OF SUICIDE- BLS HOT- 25-B-3  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:PSYCH/ THREAT OF SUICIDE- BLS HOT",
        "CODE:25-B-3",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T89",
        "Madison: FALLS- BLS COLD- 17-A-1  BOSTON POST RD/ EAST WHARF RD  X-STR:  Premise: BOSTON POST RD/ EAST WHARF RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:BOSTON POST RD & EAST WHARF RD");

    doTest("T90",
        "Madison: FALLS- BLS COLD- 17-A-1  00009  CANBORNE WAY  X-STR: -  CURRYCROSS RD/DEAD END (WINDERMERE) Premise: 9 CANBORNE WAY",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:9 CANBORNE WAY",
        "X:CURRYCROSS RD/DEAD END (WINDERMERE)");

    doTest("T91",
        "Madison: SICK/ - BLS COLD- 26-A-10  00009  CAMPUS DR  X-STR: -  DUCK HOLE RD /TOWN CAMPUS Premise: MADISON POLICE DEPARTMENT HQ",
        "CALL:SICK/ - BLS COLD- 26-A-10",
        "ADDR:9 CAMPUS DR",
        "X:DUCK HOLE RD /TOWN CAMPUS",
        "PLACE:MADISON POLICE DEPARTMENT HQ");

    doTest("T92",
        "Madison: FALLS- BLS COLD- 17-A-1  00268  MUNGERTOWN RD  X-STR: -  Old Schoolhouse Rd/DEAD END Premise: 268 MUNGERTOWN RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:268 MUNGERTOWN RD",
        "X:Old Schoolhouse Rd/DEAD END");

    doTest("T93",
        "Madison: PSYCH/ SUICIDE- UNKN STATUS- BLS HOT- 25-B-6  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:PSYCH/ SUICIDE- UNKN STATUS- BLS HOT",
        "CODE:25-B-6",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T94",
        "Madison: FALLS/ NOT RECENT- BLS COLD- 17-A-2  00121  SUMMER HILL RD  X-STR: -  LENORE DR/HARKNESS DR Premise: 121 SUMMER HILL RD",
        "CALL:FALLS/ NOT RECENT- BLS COLD",
        "CODE:17-A-2",
        "ADDR:121 SUMMER HILL RD",
        "X:LENORE DR/HARKNESS DR");

    doTest("T95",
        "Madison: HEART / UNKN STATUS- ALS - 19-C-7  00016  ESTERLY FARMS RD  X-STR: -  DEAD END/Mungertown Rd Premise: 16 ESTERLY FARMS RD",
        "CALL:HEART / UNKN STATUS- ALS",
        "CODE:19-C-7",
        "ADDR:16 ESTERLY FARMS RD",
        "X:DEAD END/Mungertown Rd");

    doTest("T96",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  00463  SUMMER HILL RD  X-STR: -  RT 80 EAST/SHEPHERDS TRAIL Premise: CAMP LAURELWOOD",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:463 SUMMER HILL RD",
        "X:RT 80 EAST/SHEPHERDS TRAIL",
        "PLACE:CAMP LAURELWOOD");

    doTest("T97",
        "Madison: STROKE/ NOT ALERT- ALS HOT- 28-C-1  01080  BOSTON POST RD  X-STR: -  SUNNY HILL RD/SIGNAL HILL RD Premise: 1080 BOSTON POST RD",
        "CALL:STROKE/ NOT ALERT- ALS HOT",
        "CODE:28-C-1",
        "ADDR:1080 BOSTON POST RD",
        "X:SUNNY HILL RD/SIGNAL HILL RD");

    doTest("T98",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  00038  WINDING RD  X-STR: -  Cornish Woods Rd/WINDING RD LOOP Premise: 38 WINDING RD",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:38 WINDING RD",
        "X:Cornish Woods Rd/WINDING RD LOOP");

    doTest("T99",
        "Madison: UNCONS/FAINTING- NOT ALERT- ALS HOT- 31-D-3  00043  WALL ST  X-STR: -  Boston Post Rd/Brookside Rd Premise: 43 WALL ST",
        "CALL:UNCONS/FAINTING- NOT ALERT- ALS HOT",
        "CODE:31-D-3",
        "ADDR:43 WALL ST",
        "X:Boston Post Rd/Brookside Rd");

    doTest("T100",
        "Madison: LIFT ASSIST - BLS COLD - 17-A-3  00066  BEEKMAN PL  X-STR: -  SAINT JAMES CT/WINDSOR CR Premise: 66 BEEKMAN PL",
        "CALL:LIFT ASSIST - BLS COLD",
        "CODE:17-A-3",
        "ADDR:66 BEEKMAN PL",
        "X:SAINT JAMES CT/WINDSOR CR");

    doTest("T101",
        "Madison: ABDOMINAL PAIN- BLS COLD- 1-A-1  00056  New RD  X-STR: Birch Ln/Bishop Ln Premise: 00056  New RD",
        "CALL:ABDOMINAL PAIN- BLS COLD",
        "CODE:1-A-1",
        "ADDR:56 New RD",
        "X:Birch Ln/Bishop Ln");

    doTest("T102",
        "Madison: UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT- 32-B-2  00052  SIGNAL HILL RD  X-STR: -  LAUREL CREST RD/MADRINA LN Premise: 52 SIGNAL HILL RD",
        "CALL:UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT",
        "CODE:32-B-2",
        "ADDR:52 SIGNAL HILL RD",
        "X:LAUREL CREST RD/MADRINA LN");

    doTest("T103",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T104",
        "Madison: FALLS- BLS COLD- 17-A-1  00210  NECK RD  X-STR: -  Highland Ter/Ridgewood Ave Premise: 210 NECK RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:210 NECK RD",
        "X:Highland Ter/Ridgewood Ave");

    doTest("T105",
        "Madison: UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT- 32-B-2  00064  BLINNSHED RD  X-STR: -  NUTMEG LN/PARTRIDGE LN Premise: 64 BLINNSHED RD",
        "CALL:UNKN PROB/MAN DOWN- MEDIC ALERT- BLS HOT",
        "CODE:32-B-2",
        "ADDR:64 BLINNSHED RD",
        "X:NUTMEG LN/PARTRIDGE LN");

    doTest("T106",
        "Madison: SICK ALTERED LOC - ALS - 26-C-1  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:SICK ALTERED LOC - ALS",
        "CODE:26-C-1",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T107",
        "Madison: HEART / UNKN STATUS- ALS - 19-C-7  00006  WOODLAND RD  X-STR: -  Durham Rd/Brantwood Dr Premise: 6 WOODLAND RD",
        "CALL:HEART / UNKN STATUS- ALS",
        "CODE:19-C-7",
        "ADDR:6 WOODLAND RD",
        "X:Durham Rd/Brantwood Dr");

    doTest("T108",
        "Madison: SICK ALTERED LOC - ALS - 26-C-1  00284  SUMMER HILL RD  X-STR: -  LENORE DR/HARKNESS DR Premise: 284 SUMMER HILL RD",
        "CALL:SICK ALTERED LOC - ALS",
        "CODE:26-C-1",
        "ADDR:284 SUMMER HILL RD",
        "X:LENORE DR/HARKNESS DR");

    doTest("T109",
        "Madison: FALLS- BLS COLD- 17-A-1  00688  DURHAM RD  X-STR: -  WARPUS RD/CHESTNUT HILL Premise: 688 DURHAM RD",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:688 DURHAM RD",
        "X:WARPUS RD/CHESTNUT HILL");

    doTest("T110",
        "Madison: FAINTING NOW ALERT BLS COLD 31-A-1  00170  Boston Post RD  X-STR: Nathans Ln/Nathans Ln Premise: 00170  Boston Post RD",
        "CALL:FAINTING NOW ALERT BLS COLD 31-A-1",
        "ADDR:170 Boston Post RD",
        "X:Nathans Ln/Nathans Ln");

    doTest("T111",
        "Madison: MV ACCIDENT-INJURIES  00277  DURHAM RD  X-STR: -  WELLSWEEP DR/WILDCAT RD Premise: 277 DURHAM RD",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:277 DURHAM RD",
        "X:WELLSWEEP DR/WILDCAT RD");

    doTest("T112",
        "Madison: SICK/ ABNORMAL BREATHING - ALS - 26-C-2  00066  BEEKMAN PL  X-STR: -  SAINT JAMES CT/WINDSOR CR Premise: 66 BEEKMAN PL",
        "CALL:SICK/ ABNORMAL BREATHING - ALS",
        "CODE:26-C-2",
        "ADDR:66 BEEKMAN PL",
        "X:SAINT JAMES CT/WINDSOR CR");

    doTest("T113",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00009  CANBORNE WAY  X-STR: -  CURRYCROSS RD/DEAD END (WINDERMERE) Premise: 9 CANBORNE WAY",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:9 CANBORNE WAY",
        "X:CURRYCROSS RD/DEAD END (WINDERMERE)");

    doTest("T114",
        "Madison: FALLS- BLS COLD- 17-A-1  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T115",
        "Madison: FOCAL SEIZURE- NOT ALERT- ALS - 12-C-1  00002  HAMPSHIRE RD  X-STR: -  Lovers Ln/ESSEX LA (KENSINGTON NORTH) Premise: 2 HAMPSHIRE RD",
        "CALL:FOCAL SEIZURE- NOT ALERT- ALS",
        "CODE:12-C-1",
        "ADDR:2 HAMPSHIRE RD",
        "X:Lovers Ln/ESSEX LA (KENSINGTON NORTH)");

    doTest("T116",
        "Madison: SICK/ NON SPECIFIC - BLS COLD- 26-A-1  00130  DURHAM RD  X-STR: -  I-95 OVERPASS/HUNTERS TR Premise: COMMUTER LOT",
        "CALL:SICK/ NON SPECIFIC - BLS COLD",
        "CODE:26-A-1",
        "ADDR:130 DURHAM RD",
        "X:I-95 OVERPASS/HUNTERS TR",
        "PLACE:COMMUTER LOT");

    doTest("T117",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  00014  DOWNING WAY  X-STR: -  Aylesbury Cir/DEAD END (WINDERMERE) Premise: 14 DOWNING WAY",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:14 DOWNING WAY",
        "X:Aylesbury Cir/DEAD END (WINDERMERE)");

    doTest("T118",
        "Madison: FALLS/ UNKN STATUS- BLS HOT- 17-B-3  00100  BRADLEY RD  X-STR: -  OLD ROUTE 79/WALL ST Premise: HEARTH AT TUXIS POND",
        "CALL:FALLS/ UNKN STATUS- BLS HOT",
        "CODE:17-B-3",
        "ADDR:100 BRADLEY RD",
        "X:OLD ROUTE 79/WALL ST",
        "PLACE:HEARTH AT TUXIS POND");

    doTest("T119",
        "Madison: MV ACCIDENT-INJURIES  00509  BOSTON POST RD (CATI)  X-STR: -  Cherry Ln/Britton Ln Premise: 00509  BOSTON POST RD (CATI)",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:509 BOSTON POST RD (CATI)",
        "MADDR:509 BOSTON POST RD",
        "X:Cherry Ln/Britton Ln");

    doTest("T120",
        "Madison: FALLS- BLS COLD*- 17-B-1  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:FALLS- BLS COLD*",
        "CODE:17-B-1",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T121",
        "Madison: BREATHING DISTRESS- ALS HOT- 6-D-2  01291  BOSTON POST RD  X-STR: -  MILL RD/DUDLEY LN Premise: MARQUIS TRACI J MD",
        "CALL:BREATHING DISTRESS- ALS HOT",
        "CODE:6-D-2",
        "ADDR:1291 BOSTON POST RD",
        "X:MILL RD/DUDLEY LN",
        "PLACE:MARQUIS TRACI J MD");

    doTest("T122",
        "Madison: BACK PAIN- BLS COLD- 5-A-1  00023  PRINCESS DR  X-STR: -  RT 79 NORTH/PRINCESS DR LOOP Premise: 23 PRINCESS DR",
        "CALL:BACK PAIN- BLS COLD",
        "CODE:5-A-1",
        "ADDR:23 PRINCESS DR",
        "X:RT 79 NORTH/PRINCESS DR LOOP");

    doTest("T123",
        "Madison: BURNS/ LESS THAN 18%- BLS HOT* 7-A-1  01301  BOSTON POST RD  X-STR: -  MILL RD/DUDLEY LN Premise: FISH TALE RESTAURANT",
        "CALL:BURNS/ LESS THAN 18%- BLS HOT* 7-A-1",
        "ADDR:1301 BOSTON POST RD",
        "X:MILL RD/DUDLEY LN",
        "PLACE:FISH TALE RESTAURANT");

    doTest("T124",
        "Madison: UNCONS/FAINTING- NOT ALERT- ALS HOT- 31-D-3  00004  SCHOOL ST  X-STR: -  Academy St/Island Ave Premise: ACADEMY STREET SCHOOL",
        "CALL:UNCONS/FAINTING- NOT ALERT- ALS HOT",
        "CODE:31-D-3",
        "ADDR:4 SCHOOL ST",
        "X:Academy St/Island Ave",
        "PLACE:ACADEMY STREET SCHOOL");

    doTest("T125",
        "Madison: ABDOMINAL PAIN- BLS COLD- 1-A-1  00065  BARTLETT DR  X-STR: -  WOODSVALE RD/PHEASENT LN Premise: 65 BARTLETT DR",
        "CALL:ABDOMINAL PAIN- BLS COLD",
        "CODE:1-A-1",
        "ADDR:65 BARTLETT DR",
        "X:WOODSVALE RD/PHEASENT LN");

    doTest("T126",
        "Madison: MV ACCIDENT-INJURIES  00122  OPENING HILL RD  X-STR: -  KACHINA WAY/MANZONI FARMS Premise: 122 OPENING HILL RD",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:122 OPENING HILL RD",
        "X:KACHINA WAY/MANZONI FARMS");

    doTest("T127",
        "Madison: FALLS- BLS COLD- 17-A-1  00068  LANTERN HILL RD  X-STR: -  BOSTON POST RD/DEAD END Premise: 68 LANTERN HILL",
        "CALL:FALLS- BLS COLD",
        "CODE:17-A-1",
        "ADDR:68 LANTERN HILL RD",
        "X:BOSTON POST RD/DEAD END",
        "PLACE:68 LANTERN HILL");

    doTest("T128",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00028  HICKORY LA  X-STR: RT 80 WEST/RACE HILL RD Premise: 28 HICKORY LA",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:28 HICKORY LA",
        "MADDR:28 HICKORY LN",
        "X:RT 80 WEST/RACE HILL RD");

    doTest("T129",
        "Madison: MEDICAL ASSISTANCE NEEDED  01320  BOSTON POST RD  X-STR: DUDLEY LN/COTTAGE RD Premise: DONAHUES MADISON BEACH GRILLE",
        "CALL:MEDICAL ASSISTANCE NEEDED",
        "ADDR:1320 BOSTON POST RD",
        "X:DUDLEY LN/COTTAGE RD",
        "PLACE:DONAHUES MADISON BEACH GRILLE");

    doTest("T130",
        "Madison: CHEST PAIN - ALS HOT - 10-D-4  00012  LOVERS LA  X-STR: -  Boston Post Rd/Wilshire Rd Premise: 12 LOVERS LA",
        "CALL:CHEST PAIN - ALS HOT",
        "CODE:10-D-4",
        "ADDR:12 LOVERS LA",
        "MADDR:12 LOVERS LN",
        "X:Boston Post Rd/Wilshire Rd");

    doTest("T131",
        "Madison: MV ACCIDENT-INJURIES  02174  DURHAM RD  X-STR: -  DORSET LN/STEPHANIE CT Premise: 2174 DURHAM RD",
        "CALL:MV ACCIDENT-INJURIES",
        "ADDR:2174 DURHAM RD",
        "X:DORSET LN/STEPHANIE CT");

    doTest("T132",
        "Madison: FALLS/ NOT RECENT- BLS COLD- 17-A-2  00009  NECK RD  X-STR: -  /Shorelands Dr Premise: WATROUS NURSING CENTER",
        "CALL:FALLS/ NOT RECENT- BLS COLD",
        "CODE:17-A-2",
        "ADDR:9 NECK RD",
        "X:Shorelands Dr",
        "PLACE:WATROUS NURSING CENTER");

    doTest("T133",
        "Madison: STROKE/ SPEECH AFF. - ALS HOT- 28-C-3  00057 W MIDDLE BEACH RD  X-STR: -  WYNDY BROOK LN/WEST WHARF RD Premise: 57 MIDDLE BEACH WEST",
        "CALL:STROKE/ SPEECH AFF. - ALS HOT",
        "CODE:28-C-3",
        "ADDR:57 W MIDDLE BEACH RD",
        "X:WYNDY BROOK LN/WEST WHARF RD",
        "PLACE:57 MIDDLE BEACH WEST");

    doTest("T134",
        "Madison: SICK ALTERED LOC - ALS - 26-C-1  00034  WILDWOOD AVE  X-STR: -  RT-1/I-95 OVERPASS Premise: MADISON HOUSE CARE & REHAB",
        "CALL:SICK ALTERED LOC - ALS",
        "CODE:26-C-1",
        "ADDR:34 WILDWOOD AVE",
        "X:RT-1/I-95 OVERPASS",
        "PLACE:MADISON HOUSE CARE & REHAB");

    doTest("T135",
        "Madison: SICK/ DIZZY- BLS COLD- 26-A-3  00146  HARBOR AVE  X-STR: -  Neck Rd Premise: 146 HARBOR AVE",
        "CALL:SICK/ DIZZY- BLS COLD",
        "CODE:26-A-3",
        "ADDR:146 HARBOR AVE",
        "X:Neck Rd");

  }
  
  public static void main(String[] args) {
    new CTMadisonParserTest().generateTests("T1", "CALL CODE ADDR APT X PLACE");
  }
}