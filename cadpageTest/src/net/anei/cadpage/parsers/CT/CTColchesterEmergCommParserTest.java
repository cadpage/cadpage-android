package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;
/*
New London County, CT
Contact: Kevin McManus <kmacinct@gmail.com>
Sender: messaging@iamresponding.com,911@kx911.com

COLCHESTER\ 25 VILLAGE CT\ \@  AMSTON RD\ FAINTING OR UNCONC. PERS\ VOGEL,HERBERT H \  ** 12-6474  \ 11:42 ** MapIt:  25  VILLAGE CT, COLCHESTER , CT ( UNCONSCIOUS )
COLCHESTER\ 15 OLD HARTFORD RD\ \@  WALL ST\ DIFFICULTY BREATHING\ STATE POLICE TROOP K - LOBBY \  ** 12-6456  \ 05:21 ** MapIt:  15  OLD HARTFORD RD, COLCHESTER , CT
COLCHESTER\  ROUTE 2 WEST \ \@  \ M/V ACCIDENT\ area of exit 18 \  ** 12-6481  \ 12:30 ** MapIt:    ROUTE 2 WEST , COLCHESTER , CT ( ROLLOVER. )
COLCHESTER\ 13 HUNTERS CT\ \@  MELANIE LN\ DIFFICULTY BREATHING\ FORTIN,V \ ** 12-6400  \ 23:17 ** MapIt:  13  HUNTERS CT, COLCHESTER , CT ( 40S MALE - ATTN G LAKE R2 MUTUAL AID )
COLCHESTER\ 27 VICKI LN\ \@  OLD HEBRON RD\ ALLERG. REACT\ CINCIRIPINO,JEFFREY \  ** 12-6342  \ 00:32 ** MapIt:  27  VICKI LN, COLCHESTER , CT ( 27 MALE REACTION TO MEDICATION )
COLCHESTER\ 64 BALABAN RD\ 505\@  GILLETTES LN\ SICK PERSON\ STAPLES,ARTHUR J \  ** 12-6360  \ 10:13 ** MapIt:  64  BALABAN RD, COLCHESTER , CT

Contact: Active911
Agency name: Colchester Fire
Location: Colchester, CT, United States
Sender: 911@kx911.com

EAST HAMPTON\ 6 SUMMIT ST\ \@  \ SICK PERSON\ ACROSS FROM... \  ** 13-13331  \ 17:48  ( ETOH --- MEET PD )
(CHFD) COLCHESTER\ 59 RESERVOIR RD\ \@  \ FIRE ALARM\ MAIESE  \  ** 13-13327  \ 17:17  
(CHFD) COLCHESTER\ 163 BROADWAY\ \@  AMSTON RD\ CHEST PAIN\ BACKUS HEALTH CENTER \  ** 13-13324  \ 16:58  
COLCHESTER\ 163 BROADWAY\ \@  AMSTON RD\ CHEST PAIN\ BACKUS HEALTH CENTER \  ** 13-13324  \ 16:58  
EAST HAMPTON\ 29 MIDDLE HADDAM RD\ \@  \ FIRE ALARM\ COBALT LODGE \  ** 13-13322  \ 16:34  
HADDAM NECK\ 50 HADDAM NECK RD\ \@  \ STATION COVER\ TEST TEST HADDAM NECK FIRE TEST TEST \  ** 13-13316  \ 14:09  ( TEST PAGE FOR HADDAM NECK FIRE. THIS IS ONLY A TEST PAGE. 1016 CONTACT KX )
EAST HAMPTON\ 60 LONG CROSSING RD\ \@  \ SICK PERSON\ STEBEN,J \  ** 13-13314  \ 13:25  ( ELD FEMALE. DIZZINESS. SILENT APPROACH REQUESTED )
(CHFD) COLCHESTER\ 29 CRAGIN CT\ \@  LINWOOD AVE\ PSYCH PROBLEM\ jackie jordon \  ** 13-13311  \ 12:35  ( STAGE PRIOR TO. FEMALE PT. INTOX. SUICIDAL. DEPRESSED. POLICE ENROUTE )
EAST HADDAM\ 374 TOWN ST\ \@  MT PARNASSUS RD\ SEIZURES\ COFFEE ,TWO WRASSLIN CATS \  ** 13-13307  \ 11:41  ( 6 MONTH OLD  )
(CHFD) COLCHESTER\ 24 EAST CT\ \@  NORTH WOODS BLVD\ PSYCH PROBLEM\  \  ** 13-13300  \ 09:27  ( R2 - FEMALE PT - MEET CSP )
(CHFD) EAST HADDAM\ 86 LONGWOOD DR\ \@  WILDWOOD RD\ HEART PROBLEMS\ TURICK,JOHN \  ** 13-13293  \ 08:05  ( LAKE HAYWARD SECTION. COLC R1. HX OF MULT STROKES )
LEBANON\ 10 BEAUMONT HWY\ \@  southridge dr\ MATERNITY\  \  ** 13-13290  \ 07:43  ( 28 WEEKS PREGNANT. ABDOMINAL PAIN )
EAST HADDAM\ 27 LANDING HILL RD\ \@  E HADDAM-MOODUS RD\ TRANSFORMER INCIDENT\ across from \  ** 13-13285  \ 05:23  ( TRANSFORMER FIRE )
EAST HAMPTON\ 20 E HIGH ST\ \@  \ FIRE ALARM\ town hall \  ** 13-13284  \ 04:40  ( BURNT FOOD. NO PROBLEM. ALARM NEEDS TO BE RESET )
(CHFD) COLCHESTER\ 16 SHADY BROOK LN\ \@  CARLI BLVD\ ALLERG. REACT\  \  ** 13-13279  \ 00:33  ( 30 F. HOUSE IN BACK )
(CHFD) COLCHESTER\ 15 OLD HARTFORD RD\ \@  \ SICK PERSON\ STATE POLICE TROOP K \  ** 13-13272  \ 22:14  
MARLBOROUGH\ 222 WEST RD\ \@  \ UNKNOWN PROBLEM\ jane doucette \  ** 13-13273  \ 22:21  ( MEDICAL ALARM )
COLCHESTER\ 15 OLD HARTFORD RD\ \@  \ SICK PERSON\ STATE POLICE TROOP K \  ** 13-13272  \ 22:14  
EAST HAMPTON\ 29 MIDDLE HADDAM RD\ \@  \ INJURED PERSON\ COBALT HEATH CARE \  ** 13-13270  \ 21:28  ( HIP  ---  2ND CREW NEEDED )
EAST HAMPTON\ 12 BROWNING DR\ \@  \ CARDIAC ARREST\ SORVILLO,GARY D \  ** 13-13266  \ 21:20  
(CHFD) COLCHESTER\ 100 THORNRIDGE DR\ \@  \ OUTSIDE FIRE\ RYAN,TERENCE & JANE \  ** 13-13263  \ 19:42  ( GAS GRILL WONT SHUT OFF )
COLCHESTER\ 100 THORNRIDGE DR\ \@  \ OUTSIDE FIRE\ RYAN,TERENCE & JANE \  ** 13-13263  \ 19:42  ( GAS GRILL WONT SHUT OFF )
EAST HAMPTON\ 9 W HIGH ST\ \@  \ HEADACHE\ MANOR,WESTSIDE \  ** 13-13258  \ 19:02  
(CHFD) COLCHESTER\ 112 COLCHESTER CMNS\ \@  \ SICK PERSON\ ELLIS \  ** 13-13257  \ 18:24  ( WEAKNESS )
(CHFD) COLCHESTER\ 146 LAKE HAYWARD RD\ \@  \ SICK PERSON\  \  ** 13-13255  \ 17:12  ( ACCIDENTAL INJECTION OF EPPI PEN - NO PRI SYMPTONS )
(CHFD) COLCHESTER\ 15 OLD HARTFORD RD\ \@  \ INJURED PERSON\ STATE POLICE TROOP K \  ** 13-13249  \ 14:54  (   2ND CREW NEEDED )
EAST HADDAM\ 141 SALEM RD\ \@  FOXTOWN CEMETERY RD\ INJURED PERSON\  \  ** 13-13248  \ 14:49  ( 154C RESPONDING )
(CHFD) COLCHESTER\  BULL HILL RD\ \@  FARM GATE DR\ SICK PERSON\ airline trail entrance  \  ** 13-13246  \ 14:23  (   2ND CREW NEEDED, MARL R1 )
COLCHESTER\  BULL HILL RD\ \@  FARM GATE DR\ SICK PERSON\ airline trail entrance  \  ** 13-13246  \ 14:23  (   2ND CREW NEEDED, MARL R1 )
(CHFD) COLCHESTER\ 429 LEBANON AVE\ \@  MUNN RD\ DIFFICULTY BREATHING\ WROBLINSKI,STACY \  ** 13-13242  \ 13:53  ( 35 Y/O FEMALE  )
EAST HADDAM\ 155 BALLAHACK RD #2 EXT\ \@  SCHULMAN VESELAK RD\ FALLS\  \  ** 13-13239  \ 13:23  ( OFF LADDER APROX 15 FEET NO LOC )
EAST HADDAM\ 89 ALGER RD\ \@  SMITH RD\ UNKNOWN PROBLEM\  \  ** 13-13237  \ 12:27  ( ALARM ACTIVATION NO RESPONSE )
LEBANON\ 271 LEONARD BRIDGE RD\ T1\@  BASCOM RD\ SICK PERSON\ WATERS EDGE CAMPGROUND \  ** 13-13230  \ 07:58  (   RETONE  CREW STILL NEEDED )
LEBANON\ 271 LEONARD BRIDGE RD\ T1\@  BASCOM RD\ SICK PERSON\  \  ** 13-13230  \ 07:58  ( FEMALE UNABLE TO AMBULATE )
COLCHESTER\ 8 COBBLE WAY\ 3\@  MEADOW DR\ SICK PERSON\  \  ** 13-13227  \ 06:07  (   RETONE  CREW STILL NEEDED )

Unit: 10124B Times: # 13-13314 Disp 13:25 Enrt 13:30 Arrv 13:35 Dprt 13:49  Dest: 079K   Hspt 14:00  Add: LONG CROSSING RD-- 
Unit: AMB528 Times: # 13-13311 Disp 12:35 Enrt 12:40 Arrv 12:42 Dprt 12:53  Dest: 104A   Hspt 13:10  Add: CRAGIN CT-- 
Unit: AMB528 Times: # 13-13300 Disp 09:29 Enrt 09:30 Arrv 09:34 Dprt 09:46  Dest: 104A   Hspt 10:03  Add: EAST CT-- 
Unit: AMB506 Times: # 13-13290 Disp 07:43 Enrt 07:52 Arrv 08:01 Dprt 08:03  Dest: 163A   Hspt 08:11  Add: BEAUMONT HWY-- 
Unit: AMB628 Times: # 13-13249 Disp 14:56 Enrt 14:59 Arrv 15:07 Dprt 15:20  Dest: 079K   Hspt 15:29  Add: OLD HARTFORD RD-- 
Unit: AMB528 Times: # 13-13242 Disp 13:55 Enrt 13:57 Arrv 14:01 Dprt 14:09  Dest: 079K   Hspt 14:21  Add: LEBANON AVE-- 
Unit: AMB506 Times: # 13-13230 Disp 07:58 Enrt 08:10 Arrv 08:22 Dprt 08:30  Dest: 163A   Hspt 09:02  Add: LEONARD BRIDGE RD-- 
Unit: AMB528 Times: # 13-13227 Disp 06:07 Enrt 06:19 Arrv 06:24 Dprt 06:40  Dest: 079K   Hspt 06:57  Add: COBBLE WAY-- 

*/


public class CTColchesterEmergCommParserTest extends BaseParserTest {
  
  public CTColchesterEmergCommParserTest() {
    setParser(new CTColchesterEmergCommParser(), "", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "COLCHESTER\\ 25 VILLAGE CT\\ \\@  AMSTON RD\\ FAINTING OR UNCONC. PERS\\ VOGEL,HERBERT H \\  ** 12-6474  \\ 11:42 ** MapIt:  25  VILLAGE CT, COLCHESTER , CT ( UNCONSCIOUS )",
        "CITY:COLCHESTER",
        "ADDR:25 VILLAGE CT", //*** NOT FOUND ***
        "X:AMSTON RD",
        "CALL:FAINTING OR UNCONC. PERS",
        "NAME:VOGEL,HERBERT H",
        "ID:12-6474",
        "TIME:11:42",
        "INFO:UNCONSCIOUS");

    doTest("T2",
        "COLCHESTER\\ 15 OLD HARTFORD RD\\ \\@  WALL ST\\ DIFFICULTY BREATHING\\ STATE POLICE TROOP K - LOBBY \\  ** 12-6456  \\ 05:21 ** MapIt:  15  OLD HARTFORD RD, COLCHESTER , CT",
        "CITY:COLCHESTER",
        "ADDR:15 OLD HARTFORD RD",
        "X:WALL ST",
        "CALL:DIFFICULTY BREATHING",
        "PLACE:STATE POLICE TROOP K - LOBBY",
        "ID:12-6456",
        "TIME:05:21");

    doTest("T3",
        "COLCHESTER\\  ROUTE 2 WEST \\ \\@  \\ M/V ACCIDENT\\ area of exit 18 \\  ** 12-6481  \\ 12:30 ** MapIt:    ROUTE 2 WEST , COLCHESTER , CT ( ROLLOVER. )",
        "CITY:COLCHESTER",
        "ADDR:ROUTE 2 WEST",
        "CALL:M/V ACCIDENT",
        "PLACE:area of exit 18",
        "ID:12-6481",
        "TIME:12:30",
        "INFO:ROLLOVER.");

    doTest("T4",
        "COLCHESTER\\ 13 HUNTERS CT\\ \\@  MELANIE LN\\ DIFFICULTY BREATHING\\ FORTIN,V \\ ** 12-6400  \\ 23:17 ** MapIt:  13  HUNTERS CT, COLCHESTER , CT ( 40S MALE - ATTN G LAKE R2 MUTUAL AID )",
        "CITY:COLCHESTER",
        "ADDR:13 HUNTERS CT",
        "X:MELANIE LN",
        "CALL:DIFFICULTY BREATHING",
        "NAME:FORTIN,V",
        "ID:12-6400",
        "TIME:23:17",
        "INFO:40S MALE - ATTN G LAKE R2 MUTUAL AID");

    doTest("T5",
        "COLCHESTER\\ 27 VICKI LN\\ \\@  OLD HEBRON RD\\ ALLERG. REACT\\ CINCIRIPINO,JEFFREY \\  ** 12-6342  \\ 00:32 ** MapIt:  27  VICKI LN, COLCHESTER , CT ( 27 MALE REACTION TO MEDICATION )",
        "CITY:COLCHESTER",
        "ADDR:27 VICKI LN",
        "X:OLD HEBRON RD",
        "CALL:ALLERG. REACT",
        "NAME:CINCIRIPINO,JEFFREY",
        "ID:12-6342",
        "TIME:00:32",
        "INFO:27 MALE REACTION TO MEDICATION");

    doTest("T6",
        "COLCHESTER\\ 64 BALABAN RD\\ 505\\@  GILLETTES LN\\ SICK PERSON\\ STAPLES,ARTHUR J \\  ** 12-6360  \\ 10:13 ** MapIt:  64  BALABAN RD, COLCHESTER , CT",
        "CITY:COLCHESTER",
        "ADDR:64 BALABAN RD",
        "APT:505",
        "X:GILLETTES LN",
        "CALL:SICK PERSON",
        "NAME:STAPLES,ARTHUR J",
        "ID:12-6360",
        "TIME:10:13");
  }
  
  @Test
  public void testColchesterFire() {

    doTest("T1",
        "EAST HAMPTON\\ 6 SUMMIT ST\\ \\@  \\ SICK PERSON\\ ACROSS FROM... \\  ** 13-13331  \\ 17:48  ( ETOH --- MEET PD )",
        "CITY:EAST HAMPTON",
        "ADDR:6 SUMMIT ST",
        "CALL:SICK PERSON",
        "NAME:ACROSS FROM...",
        "ID:13-13331",
        "TIME:17:48",
        "INFO:ETOH --- MEET PD");

    doTest("T2",
        "(CHFD) COLCHESTER\\ 59 RESERVOIR RD\\ \\@  \\ FIRE ALARM\\ MAIESE  \\  ** 13-13327  \\ 17:17  ",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:59 RESERVOIR RD",
        "CALL:FIRE ALARM",
        "NAME:MAIESE",
        "ID:13-13327",
        "TIME:17:17");

    doTest("T3",
        "(CHFD) COLCHESTER\\ 163 BROADWAY\\ \\@  AMSTON RD\\ CHEST PAIN\\ BACKUS HEALTH CENTER \\  ** 13-13324  \\ 16:58  ",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:163 BROADWAY",
        "X:AMSTON RD",
        "CALL:CHEST PAIN",
        "PLACE:BACKUS HEALTH CENTER",
        "ID:13-13324",
        "TIME:16:58");

    doTest("T4",
        "COLCHESTER\\ 163 BROADWAY\\ \\@  AMSTON RD\\ CHEST PAIN\\ BACKUS HEALTH CENTER \\  ** 13-13324  \\ 16:58  ",
        "CITY:COLCHESTER",
        "ADDR:163 BROADWAY",
        "X:AMSTON RD",
        "CALL:CHEST PAIN",
        "PLACE:BACKUS HEALTH CENTER",
        "ID:13-13324",
        "TIME:16:58");

    doTest("T5",
        "EAST HAMPTON\\ 29 MIDDLE HADDAM RD\\ \\@  \\ FIRE ALARM\\ COBALT LODGE \\  ** 13-13322  \\ 16:34  ",
        "CITY:EAST HAMPTON",
        "ADDR:29 MIDDLE HADDAM RD",
        "CALL:FIRE ALARM",
        "NAME:COBALT LODGE",
        "ID:13-13322",
        "TIME:16:34");

    doTest("T6",
        "HADDAM NECK\\ 50 HADDAM NECK RD\\ \\@  \\ STATION COVER\\ TEST TEST HADDAM NECK FIRE TEST TEST \\  ** 13-13316  \\ 14:09  ( TEST PAGE FOR HADDAM NECK FIRE. THIS IS ONLY A TEST PAGE. 1016 CONTACT KX )",
        "CITY:HADDAM NECK",
        "ADDR:50 HADDAM NECK RD",
        "CALL:STATION COVER",
        "PLACE:TEST TEST HADDAM NECK FIRE TEST TEST",
        "ID:13-13316",
        "TIME:14:09",
        "INFO:TEST PAGE FOR HADDAM NECK FIRE. THIS IS ONLY A TEST PAGE. 1016 CONTACT KX");

    doTest("T7",
        "EAST HAMPTON\\ 60 LONG CROSSING RD\\ \\@  \\ SICK PERSON\\ STEBEN,J \\  ** 13-13314  \\ 13:25  ( ELD FEMALE. DIZZINESS. SILENT APPROACH REQUESTED )",
        "CITY:EAST HAMPTON",
        "ADDR:60 LONG CROSSING RD",
        "CALL:SICK PERSON",
        "NAME:STEBEN,J",
        "ID:13-13314",
        "TIME:13:25",
        "INFO:ELD FEMALE. DIZZINESS. SILENT APPROACH REQUESTED");

    doTest("T8",
        "(CHFD) COLCHESTER\\ 29 CRAGIN CT\\ \\@  LINWOOD AVE\\ PSYCH PROBLEM\\ jackie jordon \\  ** 13-13311  \\ 12:35  ( STAGE PRIOR TO. FEMALE PT. INTOX. SUICIDAL. DEPRESSED. POLICE ENROUTE )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:29 CRAGIN CT",
        "X:LINWOOD AVE",
        "CALL:PSYCH PROBLEM",
        "NAME:jackie jordon",
        "ID:13-13311",
        "TIME:12:35",
        "INFO:STAGE PRIOR TO. FEMALE PT. INTOX. SUICIDAL. DEPRESSED. POLICE ENROUTE");

    doTest("T9",
        "EAST HADDAM\\ 374 TOWN ST\\ \\@  MT PARNASSUS RD\\ SEIZURES\\ COFFEE ,TWO WRASSLIN CATS \\  ** 13-13307  \\ 11:41  ( 6 MONTH OLD  )",
        "CITY:EAST HADDAM",
        "ADDR:374 TOWN ST",
        "X:MT PARNASSUS RD",
        "CALL:SEIZURES",
        "NAME:COFFEE ,TWO WRASSLIN CATS",
        "ID:13-13307",
        "TIME:11:41",
        "INFO:6 MONTH OLD");

    doTest("T10",
        "(CHFD) COLCHESTER\\ 24 EAST CT\\ \\@  NORTH WOODS BLVD\\ PSYCH PROBLEM\\  \\  ** 13-13300  \\ 09:27  ( R2 - FEMALE PT - MEET CSP )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:24 EAST CT",
        "X:NORTH WOODS BLVD",
        "CALL:PSYCH PROBLEM",
        "ID:13-13300",
        "TIME:09:27",
        "INFO:R2 - FEMALE PT - MEET CSP");

    doTest("T11",
        "(CHFD) EAST HADDAM\\ 86 LONGWOOD DR\\ \\@  WILDWOOD RD\\ HEART PROBLEMS\\ TURICK,JOHN \\  ** 13-13293  \\ 08:05  ( LAKE HAYWARD SECTION. COLC R1. HX OF MULT STROKES )",
        "SRC:CHFD",
        "CITY:EAST HADDAM",
        "ADDR:86 LONGWOOD DR",
        "X:WILDWOOD RD",
        "CALL:HEART PROBLEMS",
        "NAME:TURICK,JOHN",
        "ID:13-13293",
        "TIME:08:05",
        "INFO:LAKE HAYWARD SECTION. COLC R1. HX OF MULT STROKES");

    doTest("T12",
        "LEBANON\\ 10 BEAUMONT HWY\\ \\@  southridge dr\\ MATERNITY\\  \\  ** 13-13290  \\ 07:43  ( 28 WEEKS PREGNANT. ABDOMINAL PAIN )",
        "CITY:LEBANON",
        "ADDR:10 BEAUMONT HWY",
        "X:southridge dr",
        "CALL:MATERNITY",
        "ID:13-13290",
        "TIME:07:43",
        "INFO:28 WEEKS PREGNANT. ABDOMINAL PAIN");

    doTest("T13",
        "EAST HADDAM\\ 27 LANDING HILL RD\\ \\@  E HADDAM-MOODUS RD\\ TRANSFORMER INCIDENT\\ across from \\  ** 13-13285  \\ 05:23  ( TRANSFORMER FIRE )",
        "CITY:EAST HADDAM",
        "ADDR:27 LANDING HILL RD",
        "X:E HADDAM-MOODUS RD",
        "CALL:TRANSFORMER INCIDENT",
        "NAME:across from",
        "ID:13-13285",
        "TIME:05:23",
        "INFO:TRANSFORMER FIRE");

    doTest("T14",
        "EAST HAMPTON\\ 20 E HIGH ST\\ \\@  \\ FIRE ALARM\\ town hall \\  ** 13-13284  \\ 04:40  ( BURNT FOOD. NO PROBLEM. ALARM NEEDS TO BE RESET )",
        "CITY:EAST HAMPTON",
        "ADDR:20 E HIGH ST",
        "CALL:FIRE ALARM",
        "NAME:town hall",
        "ID:13-13284",
        "TIME:04:40",
        "INFO:BURNT FOOD. NO PROBLEM. ALARM NEEDS TO BE RESET");

    doTest("T15",
        "(CHFD) COLCHESTER\\ 16 SHADY BROOK LN\\ \\@  CARLI BLVD\\ ALLERG. REACT\\  \\  ** 13-13279  \\ 00:33  ( 30 F. HOUSE IN BACK )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:16 SHADY BROOK LN",
        "X:CARLI BLVD",
        "CALL:ALLERG. REACT",
        "ID:13-13279",
        "TIME:00:33",
        "INFO:30 F. HOUSE IN BACK");

    doTest("T16",
        "(CHFD) COLCHESTER\\ 15 OLD HARTFORD RD\\ \\@  \\ SICK PERSON\\ STATE POLICE TROOP K \\  ** 13-13272  \\ 22:14  ",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:15 OLD HARTFORD RD",
        "CALL:SICK PERSON",
        "PLACE:STATE POLICE TROOP K",
        "ID:13-13272",
        "TIME:22:14");

    doTest("T17",
        "MARLBOROUGH\\ 222 WEST RD\\ \\@  \\ UNKNOWN PROBLEM\\ jane doucette \\  ** 13-13273  \\ 22:21  ( MEDICAL ALARM )",
        "CITY:MARLBOROUGH",
        "ADDR:222 WEST RD",
        "CALL:UNKNOWN PROBLEM",
        "NAME:jane doucette",
        "ID:13-13273",
        "TIME:22:21",
        "INFO:MEDICAL ALARM");

    doTest("T18",
        "COLCHESTER\\ 15 OLD HARTFORD RD\\ \\@  \\ SICK PERSON\\ STATE POLICE TROOP K \\  ** 13-13272  \\ 22:14  ",
        "CITY:COLCHESTER",
        "ADDR:15 OLD HARTFORD RD",
        "CALL:SICK PERSON",
        "PLACE:STATE POLICE TROOP K",
        "ID:13-13272",
        "TIME:22:14");

    doTest("T19",
        "EAST HAMPTON\\ 29 MIDDLE HADDAM RD\\ \\@  \\ INJURED PERSON\\ COBALT HEATH CARE \\  ** 13-13270  \\ 21:28  ( HIP  ---  2ND CREW NEEDED )",
        "CITY:EAST HAMPTON",
        "ADDR:29 MIDDLE HADDAM RD",
        "CALL:INJURED PERSON",
        "PLACE:COBALT HEATH CARE",
        "ID:13-13270",
        "TIME:21:28",
        "INFO:HIP  ---  2ND CREW NEEDED");

    doTest("T20",
        "EAST HAMPTON\\ 12 BROWNING DR\\ \\@  \\ CARDIAC ARREST\\ SORVILLO,GARY D \\  ** 13-13266  \\ 21:20  ",
        "CITY:EAST HAMPTON",
        "ADDR:12 BROWNING DR",
        "CALL:CARDIAC ARREST",
        "NAME:SORVILLO,GARY D",
        "ID:13-13266",
        "TIME:21:20");

    doTest("T21",
        "(CHFD) COLCHESTER\\ 100 THORNRIDGE DR\\ \\@  \\ OUTSIDE FIRE\\ RYAN,TERENCE & JANE \\  ** 13-13263  \\ 19:42  ( GAS GRILL WONT SHUT OFF )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:100 THORNRIDGE DR",
        "CALL:OUTSIDE FIRE",
        "NAME:RYAN,TERENCE & JANE",
        "ID:13-13263",
        "TIME:19:42",
        "INFO:GAS GRILL WONT SHUT OFF");

    doTest("T22",
        "COLCHESTER\\ 100 THORNRIDGE DR\\ \\@  \\ OUTSIDE FIRE\\ RYAN,TERENCE & JANE \\  ** 13-13263  \\ 19:42  ( GAS GRILL WONT SHUT OFF )",
        "CITY:COLCHESTER",
        "ADDR:100 THORNRIDGE DR",
        "CALL:OUTSIDE FIRE",
        "NAME:RYAN,TERENCE & JANE",
        "ID:13-13263",
        "TIME:19:42",
        "INFO:GAS GRILL WONT SHUT OFF");

    doTest("T23",
        "EAST HAMPTON\\ 9 W HIGH ST\\ \\@  \\ HEADACHE\\ MANOR,WESTSIDE \\  ** 13-13258  \\ 19:02  ",
        "CITY:EAST HAMPTON",
        "ADDR:9 W HIGH ST",
        "CALL:HEADACHE",
        "NAME:MANOR,WESTSIDE",
        "ID:13-13258",
        "TIME:19:02");

    doTest("T24",
        "(CHFD) COLCHESTER\\ 112 COLCHESTER CMNS\\ \\@  \\ SICK PERSON\\ ELLIS \\  ** 13-13257  \\ 18:24  ( WEAKNESS )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:112 COLCHESTER CMNS",
        "CALL:SICK PERSON",
        "NAME:ELLIS",
        "ID:13-13257",
        "TIME:18:24",
        "INFO:WEAKNESS");

    doTest("T25",
        "(CHFD) COLCHESTER\\ 146 LAKE HAYWARD RD\\ \\@  \\ SICK PERSON\\  \\  ** 13-13255  \\ 17:12  ( ACCIDENTAL INJECTION OF EPPI PEN - NO PRI SYMPTONS )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:146 LAKE HAYWARD RD",
        "CALL:SICK PERSON",
        "ID:13-13255",
        "TIME:17:12",
        "INFO:ACCIDENTAL INJECTION OF EPPI PEN - NO PRI SYMPTONS");

    doTest("T26",
        "(CHFD) COLCHESTER\\ 15 OLD HARTFORD RD\\ \\@  \\ INJURED PERSON\\ STATE POLICE TROOP K \\  ** 13-13249  \\ 14:54  (   2ND CREW NEEDED )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:15 OLD HARTFORD RD",
        "CALL:INJURED PERSON",
        "PLACE:STATE POLICE TROOP K",
        "ID:13-13249",
        "TIME:14:54",
        "INFO:2ND CREW NEEDED");

    doTest("T27",
        "EAST HADDAM\\ 141 SALEM RD\\ \\@  FOXTOWN CEMETERY RD\\ INJURED PERSON\\  \\  ** 13-13248  \\ 14:49  ( 154C RESPONDING )",
        "CITY:EAST HADDAM",
        "ADDR:141 SALEM RD",
        "X:FOXTOWN CEMETERY RD",
        "CALL:INJURED PERSON",
        "ID:13-13248",
        "TIME:14:49",
        "INFO:154C RESPONDING");

    doTest("T28",
        "(CHFD) COLCHESTER\\  BULL HILL RD\\ \\@  FARM GATE DR\\ SICK PERSON\\ airline trail entrance  \\  ** 13-13246  \\ 14:23  (   2ND CREW NEEDED, MARL R1 )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:BULL HILL RD",
        "MADDR:BULL HILL RD & FARM GATE DR",
        "X:FARM GATE DR",
        "CALL:SICK PERSON",
        "PLACE:airline trail entrance",
        "ID:13-13246",
        "TIME:14:23",
        "INFO:2ND CREW NEEDED, MARL R1");

    doTest("T29",
        "COLCHESTER\\  BULL HILL RD\\ \\@  FARM GATE DR\\ SICK PERSON\\ airline trail entrance  \\  ** 13-13246  \\ 14:23  (   2ND CREW NEEDED, MARL R1 )",
        "CITY:COLCHESTER",
        "ADDR:BULL HILL RD",
        "MADDR:BULL HILL RD & FARM GATE DR",
        "X:FARM GATE DR",
        "CALL:SICK PERSON",
        "PLACE:airline trail entrance",
        "ID:13-13246",
        "TIME:14:23",
        "INFO:2ND CREW NEEDED, MARL R1");

    doTest("T30",
        "(CHFD) COLCHESTER\\ 429 LEBANON AVE\\ \\@  MUNN RD\\ DIFFICULTY BREATHING\\ WROBLINSKI,STACY \\  ** 13-13242  \\ 13:53  ( 35 Y/O FEMALE  )",
        "SRC:CHFD",
        "CITY:COLCHESTER",
        "ADDR:429 LEBANON AVE",
        "X:MUNN RD",
        "CALL:DIFFICULTY BREATHING",
        "NAME:WROBLINSKI,STACY",
        "ID:13-13242",
        "TIME:13:53",
        "INFO:35 Y/O FEMALE");

    doTest("T31",
        "EAST HADDAM\\ 155 BALLAHACK RD #2 EXT\\ \\@  SCHULMAN VESELAK RD\\ FALLS\\  \\  ** 13-13239  \\ 13:23  ( OFF LADDER APROX 15 FEET NO LOC )",
        "CITY:EAST HADDAM",
        "ADDR:155 BALLAHACK RD",
        "APT:2 EXT",
        "X:SCHULMAN VESELAK RD",
        "CALL:FALLS",
        "ID:13-13239",
        "TIME:13:23",
        "INFO:OFF LADDER APROX 15 FEET NO LOC");

    doTest("T32",
        "EAST HADDAM\\ 89 ALGER RD\\ \\@  SMITH RD\\ UNKNOWN PROBLEM\\  \\  ** 13-13237  \\ 12:27  ( ALARM ACTIVATION NO RESPONSE )",
        "CITY:EAST HADDAM",
        "ADDR:89 ALGER RD",
        "X:SMITH RD",
        "CALL:UNKNOWN PROBLEM",
        "ID:13-13237",
        "TIME:12:27",
        "INFO:ALARM ACTIVATION NO RESPONSE");

    doTest("T33",
        "LEBANON\\ 271 LEONARD BRIDGE RD\\ T1\\@  BASCOM RD\\ SICK PERSON\\ WATERS EDGE CAMPGROUND \\  ** 13-13230  \\ 07:58  (   RETONE  CREW STILL NEEDED )",
        "CITY:LEBANON",
        "ADDR:271 LEONARD BRIDGE RD",
        "APT:T1",
        "X:BASCOM RD",
        "CALL:SICK PERSON",
        "PLACE:WATERS EDGE CAMPGROUND",
        "ID:13-13230",
        "TIME:07:58",
        "INFO:RETONE  CREW STILL NEEDED");

    doTest("T34",
        "LEBANON\\ 271 LEONARD BRIDGE RD\\ T1\\@  BASCOM RD\\ SICK PERSON\\  \\  ** 13-13230  \\ 07:58  ( FEMALE UNABLE TO AMBULATE )",
        "CITY:LEBANON",
        "ADDR:271 LEONARD BRIDGE RD",
        "APT:T1",
        "X:BASCOM RD",
        "CALL:SICK PERSON",
        "ID:13-13230",
        "TIME:07:58",
        "INFO:FEMALE UNABLE TO AMBULATE");

    doTest("T35",
        "COLCHESTER\\ 8 COBBLE WAY\\ 3\\@  MEADOW DR\\ SICK PERSON\\  \\  ** 13-13227  \\ 06:07  (   RETONE  CREW STILL NEEDED )",
        "CITY:COLCHESTER",
        "ADDR:8 COBBLE WAY",
        "APT:3",
        "X:MEADOW DR",
        "CALL:SICK PERSON",
        "ID:13-13227",
        "TIME:06:07",
        "INFO:RETONE  CREW STILL NEEDED");

  }
  
  @Test
  public void testRunReport() {

    doTest("T1",
        "Unit: 10124B Times: # 13-13314 Disp 13:25 Enrt 13:30 Arrv 13:35 Dprt 13:49  Dest: 079K   Hspt 14:00  Add: LONG CROSSING RD-- ",
        "CALL:RUN REPORT",
        "ID:13-13314",
        "UNIT:10124B",
        "PLACE:Times: Disp 13:25 Enrt 13:30 Arrv 13:35 Dprt 13:49  Dest: 079K   Hspt 14:00  Add: LONG CROSSING RD--");

    doTest("T2",
        "Unit: AMB528 Times: # 13-13311 Disp 12:35 Enrt 12:40 Arrv 12:42 Dprt 12:53  Dest: 104A   Hspt 13:10  Add: CRAGIN CT-- ",
        "CALL:RUN REPORT",
        "ID:13-13311",
        "UNIT:AMB528",
        "PLACE:Times: Disp 12:35 Enrt 12:40 Arrv 12:42 Dprt 12:53  Dest: 104A   Hspt 13:10  Add: CRAGIN CT--");

    doTest("T3",
        "Unit: AMB528 Times: # 13-13300 Disp 09:29 Enrt 09:30 Arrv 09:34 Dprt 09:46  Dest: 104A   Hspt 10:03  Add: EAST CT-- ",
        "CALL:RUN REPORT",
        "ID:13-13300",
        "UNIT:AMB528",
        "PLACE:Times: Disp 09:29 Enrt 09:30 Arrv 09:34 Dprt 09:46  Dest: 104A   Hspt 10:03  Add: EAST CT--");

    doTest("T4",
        "Unit: AMB506 Times: # 13-13290 Disp 07:43 Enrt 07:52 Arrv 08:01 Dprt 08:03  Dest: 163A   Hspt 08:11  Add: BEAUMONT HWY-- ",
        "CALL:RUN REPORT",
        "ID:13-13290",
        "UNIT:AMB506",
        "PLACE:Times: Disp 07:43 Enrt 07:52 Arrv 08:01 Dprt 08:03  Dest: 163A   Hspt 08:11  Add: BEAUMONT HWY--");

    doTest("T5",
        "Unit: AMB628 Times: # 13-13249 Disp 14:56 Enrt 14:59 Arrv 15:07 Dprt 15:20  Dest: 079K   Hspt 15:29  Add: OLD HARTFORD RD-- ",
        "CALL:RUN REPORT",
        "ID:13-13249",
        "UNIT:AMB628",
        "PLACE:Times: Disp 14:56 Enrt 14:59 Arrv 15:07 Dprt 15:20  Dest: 079K   Hspt 15:29  Add: OLD HARTFORD RD--");

    doTest("T6",
        "Unit: AMB528 Times: # 13-13242 Disp 13:55 Enrt 13:57 Arrv 14:01 Dprt 14:09  Dest: 079K   Hspt 14:21  Add: LEBANON AVE-- ",
        "CALL:RUN REPORT",
        "ID:13-13242",
        "UNIT:AMB528",
        "PLACE:Times: Disp 13:55 Enrt 13:57 Arrv 14:01 Dprt 14:09  Dest: 079K   Hspt 14:21  Add: LEBANON AVE--");

    doTest("T7",
        "Unit: AMB506 Times: # 13-13230 Disp 07:58 Enrt 08:10 Arrv 08:22 Dprt 08:30  Dest: 163A   Hspt 09:02  Add: LEONARD BRIDGE RD-- ",
        "CALL:RUN REPORT",
        "ID:13-13230",
        "UNIT:AMB506",
        "PLACE:Times: Disp 07:58 Enrt 08:10 Arrv 08:22 Dprt 08:30  Dest: 163A   Hspt 09:02  Add: LEONARD BRIDGE RD--");

    doTest("T8",
        "Unit: AMB528 Times: # 13-13227 Disp 06:07 Enrt 06:19 Arrv 06:24 Dprt 06:40  Dest: 079K   Hspt 06:57  Add: COBBLE WAY-- ",
        "CALL:RUN REPORT",
        "ID:13-13227",
        "UNIT:AMB528",
        "PLACE:Times: Disp 06:07 Enrt 06:19 Arrv 06:24 Dprt 06:40  Dest: 079K   Hspt 06:57  Add: COBBLE WAY--");

  }
  
  public static void main(String[] args) {
    new CTColchesterEmergCommParserTest().generateTests("T1");
  }
}