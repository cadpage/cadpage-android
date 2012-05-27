package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.NY.NYSuffolkCountyBParser;

import org.junit.Test;


public class NYSuffolkCountyBParserTest extends BaseParserTest {
  
  public NYSuffolkCountyBParserTest() {
    setParser(new NYSuffolkCountyBParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*** 13 - Structure Fire *** 147 CHERUBINA LN CS: LEADER AVE  / SKIDMORE RD TOA: 22:37 09/22/10 OIL BURNER NORTH BABYLON FC 2010-002398 HY: 8' 11",
        "CALL:13 - Structure Fire",
        "ADDR:147 CHERUBINA LN",
        "X:LEADER AVE  / SKIDMORE RD",
        "TIME:22:37",
        "DATE:09/22/10",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002398",
        "INFO:OIL BURNER HY: 8' 11");

    doTest("T2",
        "*** 13 - Structure Fire *** 514 MOUNT PL CS: ESSEX ST  / LAKEWAY DR TOA: 19:55 09/22/10 NORTH BABYLON FC 2010-002393 HY: 12' 533 MOUNT PL @ ESSE",
        "CALL:13 - Structure Fire",
        "ADDR:514 MOUNT PL",
        "X:ESSEX ST  / LAKEWAY DR",
        "TIME:19:55",
        "DATE:09/22/10",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002393",
        "INFO:HY: 12' 533 MOUNT PL @ ESSE");

    doTest("T3",
        "*** 2nd/16 - Rescue *** 733 HIGHRIDGE RD CS: OCONNER RD  / NARLAND LN TOA: 20:46 09/22/10 a/m pysch emer NORTH BABYLON FC 2010-002395",
        "CALL:2nd/16 - Rescue",
        "ADDR:733 HIGHRIDGE RD",
        "X:OCONNER RD  / NARLAND LN",
        "TIME:20:46",
        "DATE:09/22/10",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002395",
        "INFO:a/m pysch emer");

    doTest("T4",
        "*** 23 - Miscellaneous Fire *** SR CITZ APTS (5 BLDGS) COMPLEX 15 WEEKS RD CS: DEER PARK AVE  / MULHOLLAND DR TOA: 11:07 09/23/10 INVEST NORTH B",
        "CALL:23 - Miscellaneous Fire",
        "PLACE:SR CITZ APTS (5 BLDGS) COMPLEX",
        "ADDR:15 WEEKS RD",
        "X:DEER PARK AVE  / MULHOLLAND DR",
        "TIME:11:07",
        "DATE:09/23/10",
        "INFO:INVEST NORTH B");

    doTest("T5",
        "*** 24/16 - Mutual Aid *** 27 COOLIDGE AVE CS: RT 110  / COOLIDGE AVE TOA: 06:54 10/20/10 40 Y/F ABDOMINAL PAINS  AMITYVILLE FD 2010-000228",
        "CALL:24/16 - Mutual Aid",
        "ADDR:27 COOLIDGE AVE",
        "X:RT 110  / COOLIDGE AVE",
        "TIME:06:54",
        "DATE:10/20/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000228",
        "INFO:40 Y/F ABDOMINAL PAINS");

    doTest("T6",
        "*** 24/16 - Mutual Aid *** 22 ELGIN RD CS: DE  / COOLIDGE AVE TOA: 11:38 10/18/10 E/F UNABLE TO MOVE  **FULL CREW NEEDED** AMITYVILLE FD 2010-00",
        "CALL:24/16 - Mutual Aid",
        "ADDR:22 ELGIN RD",
        "X:DE  / COOLIDGE AVE",
        "TIME:11:38",
        "DATE:10/18/10",
        "SRC:AMITYVILLE FD",
        "INFO:E/F UNABLE TO MOVE **FULL CREW NEEDED** 2010-00");

    doTest("T7",
        "*** 24/MV - Mutual Aid ***  MONTAUK HWY CS: WILSON AVE TOA: 11:43 10/20/10 AMITYVILLE FD 2010-000229",
        "CALL:24/MV - Mutual Aid",
        "ADDR:MONTAUK HWY",
        "MADDR:MONTAUK HWY & WILSON AVE",
        "X:WILSON AVE",
        "TIME:11:43",
        "DATE:10/20/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000229");

    doTest("T8",
        "*** 24/13 - Mutual Aid *** 42 NATHALIE AVE CS: CAMPBELL ST  / MOORE ST TOA: 12:04 10/04/10 POSS OCCUPANTS WITH IN  AMITYVILLE FD 2010-000226",
        "CALL:24/13 - Mutual Aid",
        "ADDR:42 NATHALIE AVE",
        "X:CAMPBELL ST  / MOORE ST",
        "TIME:12:04",
        "DATE:10/04/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000226",
        "INFO:POSS OCCUPANTS WITH IN");

    doTest("T9",
        "*** 3/16 - Rescue *** 204 VAN BUREN ST CS: LEWIS AVE  / BELMONT AVE TOA: 10:04 10/29/10 E/F UNRESPONSIVE  **EMT NEEDED** NO",
        "CALL:3/16 - Rescue",
        "ADDR:204 VAN BUREN ST",
        "X:LEWIS AVE  / BELMONT AVE",
        "TIME:10:04",
        "DATE:10/29/10",
        "INFO:E/F UNRESPONSIVE **EMT NEEDED** NO");

    doTest("T10",
        "*** 16 - Rescue *** 41 WILLIAMS AVE CS: CAMPBELL ST  / MOORE ST TOA: 18:01 10/25/10 E/F UNCONCIOUS-NOT BREATHING AMITYVILLE FD 2010-000231",
        "CALL:16 - Rescue",
        "ADDR:41 WILLIAMS AVE",
        "X:CAMPBELL ST  / MOORE ST",
        "TIME:18:01",
        "DATE:10/25/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000231",
        "INFO:E/F UNCONCIOUS-NOT BREATHING");

    doTest("T11",
        "*** 16 - Rescue *** 100 PARK AVE CS: IRELAND PL  / CEDAR ST TOA: 05:28 10/30/10 E/M  AMITYVILLE FD 2010-000235",
        "CALL:16 - Rescue",
        "ADDR:100 PARK AVE",
        "X:IRELAND PL  / CEDAR ST",
        "TIME:05:28",
        "DATE:10/30/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000235",
        "INFO:E/M");

    doTest("T12",
        "*** 16 - Rescue *** 47 DIXON AVE CS: RT 110  / ALBANY AVE TOA: 20:28 10/27/10 77Y/O FEMALE CHOKING AMITYVILLE FD 2010-000233",
        "CALL:16 - Rescue",
        "ADDR:47 DIXON AVE",
        "X:RT 110  / ALBANY AVE",
        "TIME:20:28",
        "DATE:10/27/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000233",
        "INFO:77Y/O FEMALE CHOKING");

    doTest("T13",
        "*** 24/16 - Mutual Aid *** CHURCH OF GOD 102 COOLIDGE AVE CS: ROSEWOODAVE  / STEELE PL TOA: 17:49 10/28/10 VOV AMITYVILLE FD 2010-000234",
        "CALL:24/16 - Mutual Aid",
        "PLACE:CHURCH OF GOD",
        "ADDR:102 COOLIDGE AVE",
        "X:ROSEWOODAVE  / STEELE PL",
        "TIME:17:49",
        "DATE:10/28/10",
        "SRC:AMITYVILLE FD",
        "ID:2010-000234",
        "INFO:VOV");

    doTest("T14",
        "*** 16 - Rescue *** 99 OVERTON ST CS: JEFFERSON AVE  / DEER PARK AVE TOA: 15:06 11/25/10 E/F SICK DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:99 OVERTON ST",
        "X:JEFFERSON AVE  / DEER PARK AVE",
        "TIME:15:06",
        "DATE:11/25/10",
        "SRC:DEER PARK FIRE DISTRICT",
        "INFO:E/F SICK");

    doTest("T15",
        "*** 23 - Miscellaneous Fire *** 14 BROOKLYN ST CS: CARLLS PA  / CAYUGA AVE TOA: 15:59 11/25/10 A/F/A  DEER PARK FIRE DISTRICT",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:14 BROOKLYN ST",
        "X:CARLLS PA  / CAYUGA AVE",
        "TIME:15:59",
        "DATE:11/25/10",
        "SRC:DEER PARK FIRE DISTRICT",
        "INFO:A/F/A");

    doTest("T16",
        "*** 2nd/16 - Rescue *** INVALID 185 W 7TH ST CS: PARK AVE  / CENTRAL AVE TOA: 10:35 12/13/10 80 YR FEM VOMITTING WEAK DEER PARK FIRE DISTRICT",
        "CALL:2nd/16 - Rescue",
        "PLACE:INVALID",
        "ADDR:185 W 7TH ST",
        "X:PARK AVE  / CENTRAL AVE",
        "TIME:10:35",
        "DATE:12/13/10",
        "SRC:DEER PARK FIRE DISTRICT",
        "INFO:80 YR FEM VOMITTING WEAK");

    doTest("T17",
        "*** 16 - Rescue *** 189 W 10TH ST CS: PARK AVE  / CENTRAL AVE TOA: 07:53 12/13/10 A/F SYNCOPAL DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:189 W 10TH ST",
        "X:PARK AVE  / CENTRAL AVE",
        "TIME:07:53",
        "DATE:12/13/10",
        "SRC:DEER PARK FIRE DISTRICT",
        "INFO:A/F SYNCOPAL");

    doTest("T18",
        "*** 16 - Rescue *** 111 LIBERTY ST CS: DEER PARK AVE  / PINE ACRES BLVD TOA: 20:06 12/12/10 82YR MALE CHEST PAIN DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:111 LIBERTY ST",
        "X:DEER PARK AVE  / PINE ACRES BLVD",
        "TIME:20:06",
        "DATE:12/12/10",
        "SRC:DEER PARK FIRE DISTRICT",
        "INFO:82YR MALE CHEST PAIN");

    doTest("T19",
        "***23- Wires/Electrical Hazard*** THEATRE THREE* 412 MAIN ST PORT JEFFERSON CS: SPRING ST  / MAPLE PL TOA: 14:18 01/02/11 PT JEFFERSON 2011-000003 PJFD\",",
        "CALL:23- Wires/Electrical Hazard",
        "PLACE:THEATRE THREE",
        "ADDR:412 MAIN ST",
        "CITY:PORT JEFFERSON",
        "X:SPRING ST  / MAPLE PL",
        "TIME:14:18",
        "DATE:01/02/11",
        "SRC:PT JEFFERSON",
        "ID:2011-000003",
        "INFO:PJFD\",");

    doTest("T20",
        "*** 30 - RESCUE *** U.S.A. SKATING RINK 1276 HICKSVILLE RD CS: SUFFOLK AVE  / DOGWOOD LN A-2 TOA: 20:12 03/30/11 2011-000250 Hazmat",
        "CALL:30 - RESCUE",
        "PLACE:USA SKATING RINK",
        "ADDR:1276 HICKSVILLE RD",
        "X:SUFFOLK AVE  / DOGWOOD LN A-2",
        "TIME:20:12",
        "DATE:03/30/11",
        "ID:2011-000250",
        "INFO:Hazmat");

    doTest("T21",
        "*** 16 - Rescue *** 30 DEER SHORE SQ CS: DEER PARK AVE  / BAY SHORE RD TOA: 13:04 04/02/11 F/M STROKE DEER PARK FIRE",
        "CALL:16 - Rescue",
        "ADDR:30 DEER SHORE SQ",
        "X:DEER PARK AVE  / BAY SHORE RD",
        "TIME:13:04",
        "DATE:04/02/11",
        "INFO:F/M STROKE DEER PARK FIRE");

    doTest("T22",
        "*** 16/23-Rescue/Miscellaneous *** 1015 GRAND BLVD CS: E INDUSTRY CT  / CORBIN AVE TOA: 12:09 04/02/11 3 Y/O POSSINI",
        "CALL:16/23-Rescue/Miscellaneous",
        "ADDR:1015 GRAND BLVD",
        "X:E INDUSTRY CT  / CORBIN AVE",
        "TIME:12:09",
        "DATE:04/02/11",
        "INFO:3 Y/O POSSINI");

    doTest("T23",
        "*** 16 - Rescue *** 1015 GRAND BLVD CS: E INDUSTRY CT  / CORBIN AVE TOA: 12:09 04/02/11 3 Y/O POSSINING  DEER PARK F",
        "CALL:16 - Rescue",
        "ADDR:1015 GRAND BLVD",
        "X:E INDUSTRY CT  / CORBIN AVE",
        "TIME:12:09",
        "DATE:04/02/11",
        "INFO:3 Y/O POSSINING DEER PARK F");

    doTest("T24",
        "*** 16 - Rescue *** 162 OAKLAND AVE CS: W 6TH ST  / W 5TH ST TOA: 10:20 04/02/11 A/F INF FROM A FALL   DEER PARK FIR",
        "CALL:16 - Rescue",
        "ADDR:162 OAKLAND AVE",
        "X:W 6TH ST  / W 5TH ST",
        "TIME:10:20",
        "DATE:04/02/11",
        "INFO:A/F INF FROM A FALL DEER PARK FIR");

    doTest("T25",
        "  / *** 23 - Miscellaneous Fire *** 18 SILVERPINE DR CS: ATNA DR  - PROSPECT ST W TOA: 12:10 07-17-11 2011-001109\n",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:18 SILVERPINE DR",
        "X:ATNA DR  - PROSPECT ST W",
        "TIME:12:10",
        "DATE:07-17-11",
        "ID:2011-001109");

    doTest("T26",
        "*** 2nd/16 - Rescue *** WENDY'S NBFC 1236 DEER PARK AVE CS: WOODS RD  - AUGUST RD TOA: 18:07 09-12-11 <07091211> a/f inj from fall NORTH BABYLON FC 2011-00 <201100>",
        "CALL:2nd/16 - Rescue",
        "PLACE:WENDY'S NBFC",
        "ADDR:1236 DEER PARK AVE",
        "X:WOODS RD  - AUGUST RD",
        "TIME:18:07",
        "DATE:09-12-11",
        "SRC:NORTH BABYLON FC",
        "INFO:a/f inj from fall 2011-00");

    doTest("T27",
        "*** MV - Motor Vehicle Accident *** SS PY & DEER PARK AV Ext 39 SOUTHERN STATE PARKWAY CS: DEER PARK AVE TOA: 17:49 09-12-11 <49091211> EASTBOUND NORTH BAB",
        "CALL:MV - Motor Vehicle Accident",
        "PLACE:SS PY & DEER PARK AV Ext",
        "ADDR:39 SOUTHERN STATE PARKWAY",
        "X:DEER PARK AVE",
        "TIME:17:49",
        "DATE:09-12-11",
        "INFO:EASTBOUND NORTH BAB");

    doTest("T28",
        "*** 23 - Miscellaneous Fire *** 7 NON-AMBULATORY PTS ON 2ND FLOOR 15 BROOKSIDE AVE CS: O  - O DEER PARK AVE",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:7 NON-AMBULATORY PTS ON 2ND FLOOR 15 BROOKSIDE AVE",
        "X:O  - O DEER PARK AVE");

    doTest("T29",
        "*** 2nd/16 - Rescue *** 1171 LITTLE EAST NECK RD CS: DELAWARE RD  - PHOENIX RD TOA: 09:29 09-12-11 <29091211> NORTH BABYLON FC 2011-002275 <2011002275>",
        "CALL:2nd/16 - Rescue",
        "ADDR:1171 LITTLE EAST NECK RD",
        "X:DELAWARE RD  - PHOENIX RD",
        "TIME:09:29",
        "DATE:09-12-11",
        "SRC:NORTH BABYLON FC",
        "ID:2011-002275");

    doTest("T30",
        "*** 16 - Rescue *** 101 ELKTON LN CS: MAYBROOK RD  - AUGUST RD TOA: 08:52 09-12-11 84 <5209121184> Y/F BODY PAINS  NORTH BABYLON FC 2011-002274<2011002274>",
        "CALL:16 - Rescue",
        "ADDR:101 ELKTON LN",
        "X:MAYBROOK RD  - AUGUST RD",
        "TIME:08:52",
        "DATE:09-12-11",
        "SRC:NORTH BABYLON FC",
        "ID:2011-002274",
        "INFO:84 Y/F BODY PAINS");

    doTest("T31",
        "*** 2nd/16 - Rescue *** 224 STATE AVE CS: MOUNT AVE  - LUND ST TOA: 18:48 09-17-11 E/F ABD PAIN WYANDANCH/WHEATLEY HTS 2011-001835",
        "CALL:2nd/16 - Rescue",
        "ADDR:224 STATE AVE",
        "X:MOUNT AVE  - LUND ST",
        "TIME:18:48",
        "DATE:09-17-11",
        "ID:2011-001835",
        "INFO:E/F ABD PAIN WYANDANCH/WHEATLEY HTS");

    doTest("T32",
        "*** 16 ***  BROADWAY CS: PARK AVE ADTML: 31-D-3 TOA: 16:14 10-20-11 2011-004568 TYPE: UNCONSCIOUS / FAINTING (NEAR) I/V/O NURSERY E/M",
        "CALL:16 - UNCONSCIOUS / FAINTING",
        "ADDR:BROADWAY",
        "MADDR:BROADWAY & PARK AVE",
        "X:PARK AVE",
        "CODE:31-D-3",
        "TIME:16:14",
        "DATE:10-20-11",
        "ID:2011-004568",
        "INFO:(NEAR) I/V/O NURSERY E/M");

    doTest("T33",
        "*** 16 *** 24 FOXHURST RD CS: DIX HILLS RD TOA: 16:16 10-29-11 2011-004718",
        "CALL:16",
        "ADDR:24 FOXHURST RD",
        "X:DIX HILLS RD",
        "TIME:16:16",
        "DATE:10-29-11",
        "ID:2011-004718");

    doTest("T34",
        "*** 16 *** 180 E PULASKI RD CS: ALBERMARLE ST ADTML: 10-C-1 TOA: 15:43 01-26-12 2012-000393 TYPE: CHEST PAIN LOC: 180 E PULASKI RD HU",
        "CALL:16 - CHEST PAIN",
        "ADDR:180 E PULASKI RD",
        "X:ALBERMARLE ST",
        "CODE:10-C-1",
        "TIME:15:43",
        "DATE:01-26-12",
        "ID:2012-000393");

    doTest("T35",
        "*** 16 ***  JONES LN CS: W JERICHO TRNP ADTML: 29-B-1 TOA: 14:04 01-26-12 2012-000392 TYPE: MOTOR VEHICLE ACCIDENT  IN PARKING LOT CR",
        "CALL:16 - MOTOR VEHICLE ACCIDENT",
        "ADDR:JONES LN",
        "MADDR:JONES LN & W JERICHO TRNP",
        "X:W JERICHO TRNP",
        "CODE:29-B-1",
        "TIME:14:04",
        "DATE:01-26-12",
        "ID:2012-000392",
        "INFO:IN PARKING LOT CR");

    doTest("T36",
        "*** 16 *** 379 NEW YORK AV CS: ELM ST ADTML: 17-D-3 TOA: 13:28 01-26-12 2012-000391 TYPE: FALLS LOC: 379 NEW YORK AV HUNTIN :@FOX'S  ",
        "CALL:16 - FALLS",
        "ADDR:379 NEW YORK AV",
        "MADDR:379 NEW YORK AVE",
        "X:ELM ST",
        "CODE:17-D-3",
        "TIME:13:28",
        "DATE:01-26-12",
        "ID:2012-000391");

    doTest("T37",
        "*** 16 *** 257 E 17 CS: LENOX RD ADTML: 17-A-1 TOA: 10:16 02-05-12 2012-000535 TYPE: FALLS LOC: 257A E 17 ST HUNTIS   CROSS: LENOX RD",
        "CALL:16 - FALLS",
        "ADDR:257 E 17",
        "X:LENOX RD",
        "CODE:17-A-1",
        "TIME:10:16",
        "DATE:02-05-12",
        "ID:2012-000535");

    doTest("T38",
        "*** 16 *** 2 MATHER CT CS: STRATTON DR ADTML: 6-C-1 TOA: 08:00 02-05-12 2012-000533 TYPE: RESPIRATORY LOC: 2 MATHER CT HUNTIS   CROSS",
        "CALL:16 - RESPIRATORY",
        "ADDR:2 MATHER CT",
        "X:STRATTON DR",
        "CODE:6-C-1",
        "TIME:08:00",
        "DATE:02-05-12",
        "ID:2012-000533");

    doTest("T39",
        "***16-26 Sick*** ***26-A-1*** 139 SHINNECOCK AV CS: BETTS PL  / MASTIC RD TOA: 10:13 03/07/12 26-A-1 2012-000419 \n",
        "CALL:16-26 Sick",
        "PLACE:***26-A-1**",
        "ADDR:139 SHINNECOCK AV",
        "MADDR:139 SHINNECOCK AVE",
        "X:BETTS PL  / MASTIC RD",
        "TIME:10:13",
        "DATE:03/07/12",
        "ID:2012-000419",
        "INFO:26-A-1");

    doTest("T40",
        "***23 CO Call No Symptoms*** 14 EMPIRE CT COMMACK CS: PIMLICO DR  - CUL DE SAC TOA: 06:18 03-07-12",
        "CALL:23 CO Call No Symptoms",
        "ADDR:14 EMPIRE CT",
        "CITY:COMMACK",
        "X:PIMLICO DR  - CUL DE SAC",
        "TIME:06:18",
        "DATE:03-07-12");

    doTest("T41",
        "***24 Mutual Aid R.I.T.***  ROBIN DR COMMACK CS: NEW HWY TOA: 20:25  ",
        "CALL:24 Mutual Aid R.I.T.",
        "ADDR:ROBIN DR",
        "MADDR:ROBIN DR & NEW HWY",
        "CITY:COMMACK",
        "X:NEW HWY",
        "TIME:20:25");

    doTest("T42",
        "***23 Motor Vehicle Accident***  LEFFERTS PL CS: ELWOOD RD TOA: 17:58 03-07-12",
        "CALL:23 Motor Vehicle Accident",
        "ADDR:LEFFERTS PL",
        "MADDR:LEFFERTS PL & ELWOOD RD",
        "X:ELWOOD RD",
        "TIME:17:58",
        "DATE:03-07-12");

    doTest("T43",
        "***13 Residential Automatic Fire Alarm*** 34 MCARTHUR LN SMITHTOWN CS: LAUREL DR  - LEDGEWOOD DR TOA: 10:02 03-08-12",
        "CALL:13 Residential Automatic Fire Alarm",
        "ADDR:34 MCARTHUR LN",
        "CITY:SMITHTOWN",
        "X:LAUREL DR  - LEDGEWOOD DR",
        "TIME:10:02",
        "DATE:03-08-12");

    doTest("T44",
        "***23 Motor Vehicle Accident*** 1815 E JERICHO TRNP E NORTHPORT CS: E DEER PARK RD  - JERICHO TRNP TOA: 14:55 03-14-12",
        "CALL:23 Motor Vehicle Accident",
        "ADDR:1815 E JERICHO TRNP",
        "CITY:E NORTHPORT",
        "X:E DEER PARK RD  - JERICHO TRNP",
        "TIME:14:55",
        "DATE:03-14-12");

    doTest("T45",
        "***23 Misc*** PEPPERTREE COMMONS 6401 JERICHO TPKE COMMACK TOA: 18:31 03-16-12",
        "CALL:23 Misc",
        "PLACE:PEPPERTREE COMMONS",
        "ADDR:6401 JERICHO TPKE",
        "CITY:COMMACK",
        "TIME:18:31",
        "DATE:03-16-12");

    doTest("T46",
        "Sig 3 ALS Needed *** 16 ***  E 6 ST CS: FAIRGROUND AVE TOA: 11:53",
        "CALL:16 - Sig 3 ALS Needed ",
        "ADDR:E 6 ST",
        "X:FAIRGROUND AVE",
        "TIME:11:53");

    doTest("T47",
        "Sig 3 CL Needed *** 16 *** 160 WALT WHITMAN RD CS: PINETREE RD TOA: 11:16 04-01-12 2012-001368\r",
        "CALL:16 - Sig 3 CL Needed ",
        "ADDR:160 WALT WHITMAN RD",
        "X:PINETREE RD",
        "TIME:11:16",
        "DATE:04-01-12",
        "ID:2012-001368");

    doTest("T48",
        "Sig 3 ALS Needed *** 16 *** 107 E 25 ST CS: POPLAR AVE TOA: 09:49 04-01-12 2012-001365\r",
        "CALL:16 - Sig 3 ALS Needed ",
        "ADDR:107 E 25 ST",
        "X:POPLAR AVE",
        "TIME:09:49",
        "DATE:04-01-12",
        "ID:2012-001365");

    doTest("T49",
        "Sig3 Full Crew Need *** 16 *** 160 WALT WHITMAN RD CS: PINETREE RD TOA: 11:16 04-01-12 2012-001368\r",
        "CALL:16 - Sig3 Full Crew Need ",
        "ADDR:160 WALT WHITMAN RD",
        "X:PINETREE RD",
        "TIME:11:16",
        "DATE:04-01-12",
        "ID:2012-001368");

    doTest("T50",
        "***23 Heavy Rescue***  SUNKEN MEADOW PKY CS: NORTHERN STATE PKY TOA: 23:23 04-01-12",
        "CALL:23 Heavy Rescue",
        "ADDR:SUNKEN MEADOW PKY",
        "MADDR:SUNKEN MEADOW PKY & NORTHERN STATE PKY",
        "X:NORTHERN STATE PKY",
        "TIME:23:23",
        "DATE:04-01-12");

    doTest("T51",
        "***23 Motor Vehicle Accident*** INDIAN HEAD RD COMMACK CS: SOMERS LN TOA: 09:38 04-18-12",
        "CALL:23 Motor Vehicle Accident",
        "ADDR:INDIAN HEAD RD",
        "MADDR:INDIAN HEAD RD & SOMERS LN",
        "CITY:COMMACK",
        "X:SOMERS LN",
        "TIME:09:38",
        "DATE:04-18-12");
  }
  
  @Test
  public void testActive911() {

    doTest("T1",
        "*** 13 - Structure Fire *** 336 W 24TH ST CS: DIX ST  - DEAD END TOA: 18:05 05-22-12 ELECTRICAL DEER PARK FIRE DISTRICT 2012-001125 HY: 6' 172 W 24TH ST - 6' 224 W 24TH ST",
        "CALL:13 - Structure Fire",
        "ADDR:336 W 24TH ST",
        "X:DIX ST  - DEAD END",
        "TIME:18:05",
        "DATE:05-22-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001125",
        "INFO:ELECTRICAL HY: 6' 172 W 24TH ST - 6' 224 W 24TH ST");

    doTest("T2",
        "*** 16A- Rescue Frn Fam *** 31 CHATHAM ST CS: CARLLS PA  - CAYUGA AVE TOA: 20:19 05-22-12 MALE CHILD FACIAL INJURY FROM A FALL 2012-001126",
        "CALL:16A- Rescue Frn Fam",
        "ADDR:31 CHATHAM ST",
        "X:CARLLS PA  - CAYUGA AVE",
        "TIME:20:19",
        "DATE:05-22-12",
        "ID:2012-001126",
        "INFO:MALE CHILD FACIAL INJURY FROM A FALL");

    doTest("T3",
        "*** 16 - Rescue *** 122 CLAREMONT ST CS: DEER PARK AVE  - WILDWOOD AVE TOA: 06:10 05-23-12 E/M RESP DIFF  DEER PARK FIRE DISTRICT 2012-001128",
        "CALL:16 - Rescue",
        "ADDR:122 CLAREMONT ST",
        "X:DEER PARK AVE  - WILDWOOD AVE",
        "TIME:06:10",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001128",
        "INFO:E/M RESP DIFF");

    doTest("T4",
        "*** 23 - Miscellaneous Fire *** 37 LIBERTY ST CS: JEFFERSON AVE  - GLASGOW AVE TOA: 19:38 05-24-12 AUTOMATIC FIRE ALARM DEER PARK FIRE DISTRICT 2012-001143 HY: 8' 37 LIBERTY ST - 8' 127 OAK ST",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:37 LIBERTY ST",
        "X:JEFFERSON AVE  - GLASGOW AVE",
        "TIME:19:38",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001143",
        "INFO:AUTOMATIC FIRE ALARM HY: 8' 37 LIBERTY ST - 8' 127 OAK ST");

    doTest("T5",
        "*** 16 - Rescue *** 4TH E ST & GRAND BD E 4TH ST CS: GRAND BLVD TOA: 00:00 05-25-12 MALE VICTIM OF VIOLENCE DEER PARK FIRE DISTRICT 2012-001145",
        "CALL:16 - Rescue",
        "ADDR:4TH E ST & GRAND BD E 4TH ST",
        "X:GRAND BLVD",
        "TIME:00:00",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001145",
        "INFO:MALE VICTIM OF VIOLENCE");

    doTest("T6",
        "*** 16 - Rescue *** DEER PARK AV & NICHOLLS RD DEER PARK AVE CS: NICHOLS RD TOA: 00:34 05-25-12 A/M UNKOWN DEER PARK FIRE DISTRICT 2012-001146",
        "CALL:16 - Rescue",
        "ADDR:DEER PARK AV & NICHOLLS RD DEER PARK AVE",
        "MADDR:DEER PARK AVE & NICHOLLS RD DEER PARK AVE",
        "X:NICHOLS RD",
        "TIME:00:34",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001146",
        "INFO:A/M UNKOWN");

    doTest("T7",
        "*** 16 - Rescue *** BROOKVIEW COMMONS 1906 COMMONS WAY CS: BROOK AVE  - MORGAN AVE TOA: 01:19 05-25-12 DEER PARK FIRE DISTRICT 2012-001147",
        "CALL:16 - Rescue",
        "PLACE:BROOKVIEW COMMONS",
        "ADDR:1906 COMMONS WAY",
        "X:BROOK AVE  - MORGAN AVE",
        "TIME:01:19",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001147");

    doTest("T8",
        "*** 24/16 - Mutual Aid *** DEPARTMENT OF SOCIAL SERVICES 2 S 2ND ST CS: SAXWOOD ST  - DUNTON AVE TOA: 18:44 05-25-12 A/M KNEE INJURY TO BRENTWOOD LEGION AMBULANCE DEER PARK FIRE DISTRICT 2012-001155",
        "CALL:24/16 - Mutual Aid",
        "PLACE:DEPARTMENT OF SOCIAL SERVICES",
        "ADDR:2 S 2ND ST",
        "X:SAXWOOD ST  - DUNTON AVE",
        "TIME:18:44",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001155",
        "INFO:A/M KNEE INJURY TO BRENTWOOD LEGION AMBULANCE");

    doTest("T9",
        "*** 16 - Rescue *** YORKSHIRE COMMONS CONDOS 42 GREENMEADOW CT CS: SUMMERFIELD CT  - DEAD END TOA: 07:21 05-24-12 E/M ABDOMINAL PAINS DEER PARK FIRE DISTRICT 2012-001138",
        "CALL:16 - Rescue",
        "PLACE:YORKSHIRE COMMONS CONDOS",
        "ADDR:42 GREENMEADOW CT",
        "X:SUMMERFIELD CT  - DEAD END",
        "TIME:07:21",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001138",
        "INFO:E/M ABDOMINAL PAINS");

    doTest("T10",
        "*** 09 *** DEER PARK SR HIGH SCHOOL 1 FALCON PL CS: N 1ST ST  - N 5TH ST TOA: 07:50 05-24-12 1-4-4,5 DEER PARK FIRE DISTRICT 2012-001139",
        "CALL:09",
        "PLACE:DEER PARK SR HIGH SCHOOL",
        "ADDR:1 FALCON PL",
        "X:N 1ST ST  - N 5TH ST",
        "TIME:07:50",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001139",
        "INFO:1-4-4,5");

    doTest("T11",
        "*** 23 - Miscellaneous Fire *** ACORN ST & HHR ACORN ST CS: HALF HOLLOW RD TOA: 08:02 05-24-12 WIRES DOWN;POLE LEANING DEER PARK FIRE DISTRICT 2012-001140 HY: 10' 253 ACORN ST - 10' 729 ACORN ST",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:ACORN ST & HHR ACORN ST",
        "X:HALF HOLLOW RD",
        "TIME:08:02",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001140",
        "INFO:WIRES DOWN;POLE LEANING HY: 10' 253 ACORN ST - 10' 729 ACORN ST");

    doTest("T12",
        "*** 16 - Rescue *** 192 W 18TH ST CS: PARK AVE  - CENTRAL AVE TOA: 16:06 05-25-12 A/M INJ FROM FALL DEER PARK FIRE DISTRICT 2012-001154",
        "CALL:16 - Rescue",
        "ADDR:192 W 18TH ST",
        "X:PARK AVE  - CENTRAL AVE",
        "TIME:16:06",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001154",
        "INFO:A/M INJ FROM FALL");

    doTest("T13",
        "*** 09 *** DEER PARK SR HIGH SCHOOL 1 FALCON PL CS: N 1ST ST  - N 5TH ST TOA: 18:37 05-24-12 sig 9 at high school DEER PARK FIRE DISTRICT 2012-001142",
        "CALL:09",
        "PLACE:DEER PARK SR HIGH SCHOOL",
        "ADDR:1 FALCON PL",
        "X:N 1ST ST  - N 5TH ST",
        "TIME:18:37",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001142",
        "INFO:sig 9 at high school");

    doTest("T14",
        "*** 16 - Rescue *** HOME DEPOT DPFD 475 COMMACK RD CS: LONG ISLAND AVE  - GRAND BLVD TOA: 13:23 05-24-12 A/M INJURY FROM FALL DEER PARK FIRE DISTRICT 2012-001141",
        "CALL:16 - Rescue",
        "PLACE:HOME DEPOT DPFD",
        "ADDR:475 COMMACK RD",
        "X:LONG ISLAND AVE  - GRAND BLVD",
        "TIME:13:23",
        "DATE:05-24-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001141",
        "INFO:A/M INJURY FROM FALL");

    doTest("T15",
        "*** MV - Motor Vehicle Accident *** COMAC RD & LIA COMMACK RD CS: LONG ISLAND AVE TOA: 11:43 05-25-12 DEER PARK FIRE DISTRICT 2012-001151 - 10' 450 COMMACK RD",
        "CALL:MV - Motor Vehicle Accident",
        "ADDR:COMAC RD & LIA COMMACK RD",  // Not mapping, typo????
        "X:LONG ISLAND AVE",
        "TIME:11:43",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001151",
        "INFO:- 10' 450 COMMACK RD");

    doTest("T16",
        "*** 2nd/16 - Rescue *** 338 W 5TH ST CS: ALO CT  - ERLANGER BLVD TOA: 11:34 05-25-12 E/F INJURY FROM FALL DEER PARK FIRE DISTRICT 2012-001150",
        "CALL:2nd/16 - Rescue",
        "ADDR:338 W 5TH ST",
        "X:ALO CT  - ERLANGER BLVD",
        "TIME:11:34",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001150",
        "INFO:E/F INJURY FROM FALL");

    doTest("T17",
        "*** 16 - Rescue *** 145 W 8TH ST CS: GRAND BLVD  - PARK AVE TOA: 10:49 05-25-12 A/F SICK DEER PARK FIRE DISTRICT 2012-001149",
        "CALL:16 - Rescue",
        "ADDR:145 W 8TH ST",
        "X:GRAND BLVD  - PARK AVE",
        "TIME:10:49",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001149",
        "INFO:A/F SICK");

    doTest("T18",
        "*** 16A- Rescue Frn Fam *** 145 W 8TH ST CS: GRAND BLVD  - PARK AVE TOA: 10:49 05-25-12 A/F SICK 2012-001149",
        "CALL:16A- Rescue Frn Fam",
        "ADDR:145 W 8TH ST",
        "X:GRAND BLVD  - PARK AVE",
        "TIME:10:49",
        "DATE:05-25-12",
        "ID:2012-001149",
        "INFO:A/F SICK");

    doTest("T19",
        "*** 16A- Rescue Frn Fam *** 11 MONMOUTH ST CS: BURLINGTON AVE  - BERGEN DR TOA: 08:42 05-25-12 INJ FROM A FALL 2012-001148",
        "CALL:16A- Rescue Frn Fam",
        "ADDR:11 MONMOUTH ST",
        "X:BURLINGTON AVE  - BERGEN DR",
        "TIME:08:42",
        "DATE:05-25-12",
        "ID:2012-001148",
        "INFO:INJ FROM A FALL");

    doTest("T20",
        "*** 16 - Rescue *** 11 MONMOUTH ST CS: BURLINGTON AVE  - BERGEN DR TOA: 08:42 05-25-12 INJ FROM A FALL DEER PARK FIRE DISTRICT 2012-001148",
        "CALL:16 - Rescue",
        "ADDR:11 MONMOUTH ST",
        "X:BURLINGTON AVE  - BERGEN DR",
        "TIME:08:42",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001148",
        "INFO:INJ FROM A FALL");

    doTest("T21",
        "*** 24/16 - Mutual Aid *** testDEPARTMENT OF SOCIAL SERVICES 2 S 2ND ST CS: SAXWOOD ST - DUNTON AVE TOA: 18:44 05-25-12 A/M KNEE INJURY TO BRENTWOOD LEGION AMBULANCE DEER PARK FIRE DISTRICT 2012-001155 ",
        "CALL:24/16 - Mutual Aid",
        "PLACE:testDEPARTMENT OF SOCIAL SERVICES",
        "ADDR:2 S 2ND ST",
        "X:SAXWOOD ST - DUNTON AVE",
        "TIME:18:44",
        "DATE:05-25-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001155",
        "INFO:A/M KNEE INJURY TO BRENTWOOD LEGION AMBULANCE");

    doTest("T22",
        "*** 2nd/16 - Rescue *** YORKSHIRE COMMONS CONDOS 125 GREENMEADOW DR CS: OAK PARK CT - QUAIL RUN DR TOA: 18:44 05-20-12 E/F CVA DEER PARK FIRE DISTRICT 2012-001110 ",
        "CALL:2nd/16 - Rescue",
        "PLACE:YORKSHIRE COMMONS CONDOS",
        "ADDR:125 GREENMEADOW DR",
        "X:OAK PARK CT - QUAIL RUN DR",
        "TIME:18:44",
        "DATE:05-20-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001110",
        "INFO:E/F CVA");

    doTest("T23",
        "*** 16 - Rescue *** 58 COLLINS AVE CS: OAK ST - GLEELAND ST TOA: 21:38 05-19-12 A/M UNCONSCIOUS DEER PARK FIRE DISTRICT 2012-001100 ",
        "CALL:16 - Rescue",
        "ADDR:58 COLLINS AVE",
        "X:OAK ST - GLEELAND ST",
        "TIME:21:38",
        "DATE:05-19-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001100",
        "INFO:A/M UNCONSCIOUS");

    doTest("T24",
        "*** 13 - Structure Fire *** IRENES DRY CLEANERS 1823 DEER PARK AVE CS: LAKE AVE - GRAND BLVD TOA: 03:53 05-21-12 DEER PARK FIRE DISTRICT 2012-001115 HY: 10' 1817 DEER PARK AV(E/S DPA) - 8' 80 E 1ST ST ",
        "CALL:13 - Structure Fire",
        "PLACE:IRENES DRY CLEANERS",
        "ADDR:1823 DEER PARK AVE",
        "X:LAKE AVE - GRAND BLVD",
        "TIME:03:53",
        "DATE:05-21-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001115",
        "INFO:HY: 10' 1817 DEER PARK AV(E/S DPA) - 8' 80 E 1ST ST");

    doTest("T25",
        "*** MV - Motor Vehicle Accident *** CARLLS PA & JOHN VIGIANO II BD CARLLS PA CS: GRAND BLVD TOA: 17:12 05-23-12 mva DEER PARK FIRE DISTRICT 2012-001133 - 8' 623 GRAND BD",
        "CALL:MV - Motor Vehicle Accident",
        "ADDR:CARLLS PA & JOHN VIGIANO II BD CARLLS PA", // What is this!!!
        "MADDR:CARLLS PATH & JOHN VIGIANO II BD CARLLS PATH",
        "X:GRAND BLVD",
        "TIME:17:12",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001133",
        "INFO:mva - 8' 623 GRAND BD");

    doTest("T26",
        "*** 16 - Rescue *** MANGANO FUNERAL HOME 1701 DEER PARK AVE CS: WESTON AVE  - WINNECOMAC AVE TOA: 19:23 05-23-12 E/M RESP DIFF DEER PARK FIRE DISTRICT 2012-001134",
        "CALL:16 - Rescue",
        "PLACE:MANGANO FUNERAL HOME",
        "ADDR:1701 DEER PARK AVE",
        "X:WESTON AVE  - WINNECOMAC AVE",
        "TIME:19:23",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001134",
        "INFO:E/M RESP DIFF");

    doTest("T27",
        "*** CO - Carbon Monoxide Detector Activation *** 18 FAIRLAWN DR CS: DAHLIA LN  - ELMWOOD RD TOA: 20:27 05-23-12 DEER PARK FIRE DISTRICT 2012-001135 - 8' 20 ELMWOOD RD",
        "CALL:CO - Carbon Monoxide Detector Activation",
        "ADDR:18 FAIRLAWN DR",
        "X:DAHLIA LN  - ELMWOOD RD",
        "TIME:20:27",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001135",
        "INFO:- 8' 20 ELMWOOD RD");

    doTest("T28",
        "*** 13 - Structure Fire *** 41 BURLINGTON AVE CS: MORRIS PL  - NICHOLS RD TOA: 22:29 05-23-12 DEER PARK FIRE DISTRICT 2012-001136 HY: 10' 38 BURLINGTON AV - 8' 883 NICHOLS RD",
        "CALL:13 - Structure Fire",
        "ADDR:41 BURLINGTON AVE",
        "X:MORRIS PL  - NICHOLS RD",
        "TIME:22:29",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001136",
        "INFO:HY: 10' 38 BURLINGTON AV - 8' 883 NICHOLS RD");

    doTest("T29",
        "*** 16 - Rescue *** 361 COMMACK RD CS: GRAND BLVD  - QUAIL RUN DR TOA: 23:27 05-23-12 A/M ABD PAIN DEER PARK FIRE DISTRICT 2012-001137",
        "CALL:16 - Rescue",
        "ADDR:361 COMMACK RD",
        "X:GRAND BLVD  - QUAIL RUN DR",
        "TIME:23:27",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001137",
        "INFO:A/M ABD PAIN");

    doTest("T30",
        "*** 16 - Rescue *** MANOR PARK SR CITIZENS APTS 215 CARLLS PA G24 CS: CARA CT  - TELL AVE TOA: 10:10 05-23-12 E/F SICK DEER PARK FIRE DISTRICT 2012-001132",
        "CALL:16 - Rescue",
        "PLACE:MANOR PARK SR CITIZENS APTS",
        "ADDR:215 CARLLS PA G24", 
        "MADDR:215 CARLLS PATH G24", 
        "X:CARA CT  - TELL AVE",
        "TIME:10:10",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001132",
        "INFO:E/F SICK");

    doTest("T31",
        "*** 16 - Rescue *** 102 ELLEN SUE DR CS: DARTMOUTH DR  - KATHLEEN LN TOA: 09:11 05-23-12 A/M RESP DIFF DEER PARK FIRE DISTRICT 2012-001131",
        "CALL:16 - Rescue",
        "ADDR:102 ELLEN SUE DR",              // Not mapping
        "X:DARTMOUTH DR  - KATHLEEN LN",
        "TIME:09:11",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001131",
        "INFO:A/M RESP DIFF");

    doTest("T32",
        "*** 16 - Rescue *** 89 W 15TH ST CS: LAKE AVE  - GRAND BLVD TOA: 03:05 05-23-12 F/Y ABD PAIN DEER PARK FIRE DISTRICT 2012-001127",
        "CALL:16 - Rescue",
        "ADDR:89 W 15TH ST",
        "X:LAKE AVE  - GRAND BLVD",
        "TIME:03:05",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001127",
        "INFO:F/Y ABD PAIN");

    doTest("T33",
        "*** 16 - Rescue *** DEER PARK AVENUE VILLAS 49 JACQUELINE WAY 49 CS: DEER PARK AVE  - BAY SHORE RD TOA: 17:49 05-22-12 52Y/O MALE UNCONCIOUS DEER PARK FIRE DISTRICT 2012-001124",
        "CALL:16 - Rescue",
        "PLACE:DEER PARK AVENUE VILLAS",
        "ADDR:49 JACQUELINE WAY 49",
        "X:DEER PARK AVE  - BAY SHORE RD",
        "TIME:17:49",
        "DATE:05-22-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001124",
        "INFO:52Y/O MALE UNCONCIOUS");

    doTest("T34",
        "*** 09 *** DEER PARK SR HIGH SCHOOL 1 FALCON PL CS: N 1ST ST  - N 5TH ST TOA: 07:50 05-23-12 1-4-4 1-4-5 AND 33 ALL SIG 9 DEER PARK FIRE DISTRICT 2012-001130",
        "CALL:09",
        "PLACE:DEER PARK SR HIGH SCHOOL",
        "ADDR:1 FALCON PL",
        "X:N 1ST ST  - N 5TH ST",
        "TIME:07:50",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001130",
        "INFO:1-4-4 1-4-5 AND 33 ALL SIG 9");

    doTest("T35",
        "*** 3/16 - Rescue *** 95 OAKLAND AVE CS: W 2ND ST  - W 1ST ST TOA: 06:15 05-23-12 FULL CREW NEEDED A/F INCOHEIRENT DEER PARK FIRE DISTRICT 2012-001129",
        "CALL:3/16 - Rescue",
        "ADDR:95 OAKLAND AVE",
        "X:W 2ND ST  - W 1ST ST",
        "TIME:06:15",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001129",
        "INFO:FULL CREW NEEDED A/F INCOHEIRENT");

    doTest("T36",
        "*** 2nd/16 - Rescue *** 95 OAKLAND AVE CS: W 2ND ST  - W 1ST ST TOA: 06:15 05-23-12 A/F INCOHEIRENT DEER PARK FIRE DISTRICT 2012-001129",
        "CALL:2nd/16 - Rescue",
        "ADDR:95 OAKLAND AVE",
        "X:W 2ND ST  - W 1ST ST",
        "TIME:06:15",
        "DATE:05-23-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001129",
        "INFO:A/F INCOHEIRENT");

    doTest("T37",
        "*** 16 - Rescue *** 76 WRIGHT AVE CS: LIBERTY ST  - NICHOLS RD TOA: 21:17 05-26-12 E/M RESP DIFF DEER PARK FIRE DISTRICT 2012-001161",
        "CALL:16 - Rescue",
        "ADDR:76 WRIGHT AVE",
        "X:LIBERTY ST  - NICHOLS RD",
        "TIME:21:17",
        "DATE:05-26-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001161",
        "INFO:E/M RESP DIFF");

    doTest("T38",
        "*** 16 - Rescue *** 16 JERSEY ST CS: CARLLS PA  - CAYUGA AVE TOA: 09:15 05-22-12 A/F CHEST PAINS DEER PARK FIRE DISTRICT 2012-001122",
        "CALL:16 - Rescue",
        "ADDR:16 JERSEY ST",
        "X:CARLLS PA  - CAYUGA AVE",
        "TIME:09:15",
        "DATE:05-22-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001122",
        "INFO:A/F CHEST PAINS");

    doTest("T39",
        "*** MV - Motor Vehicle Accident *** MARCUS BD & GRAND BD GRAND BLVD CS: MARCUS BLVD TOA: 16:28 05-22-12 DEER PARK FIRE DISTRICT 2012-001123 - 10' 95 MARCUS BD",
        "CALL:MV - Motor Vehicle Accident",
        "PLACE:MARCUS BD & GRAND BD",
        "ADDR:GRAND BLVD",
        "MADDR:GRAND BLVD & MARCUS BLVD",
        "X:MARCUS BLVD",
        "TIME:16:28",
        "DATE:05-22-12",
        "SRC:DEER PARK FIRE DISTRICT",
        "ID:2012-001123",
        "INFO:- 10' 95 MARCUS BD");
   
  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyBParserTest().generateTests("T1");
  }
}