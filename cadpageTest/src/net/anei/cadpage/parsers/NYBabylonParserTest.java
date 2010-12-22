package net.anei.cadpage.parsers;

import org.junit.Test;


public class NYBabylonParserTest extends BaseParserTest {
  
  public NYBabylonParserTest() {
    setParser(new NYBabylonParser(), "BABYLON", "NY");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "*** 13 - Structure Fire *** 147 CHERUBINA LN CS: LEADER AVE  / SKIDMORE RD TOA: 22:37 09/22/10 OIL BURNER NORTH BABYLON FC 2010-002398 HY: 8' 11",
        "CALL:13 - Structure Fire",
        "ADDR:147 CHERUBINA LN",
        "X:LEADER AVE  / SKIDMORE RD",
        "INFO:OIL BURNER",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002398");

    doTest("T2",
        "*** 13 - Structure Fire *** 514 MOUNT PL CS: ESSEX ST  / LAKEWAY DR TOA: 19:55 09/22/10 NORTH BABYLON FC 2010-002393 HY: 12' 533 MOUNT PL @ ESSE",
        "CALL:13 - Structure Fire",
        "ADDR:514 MOUNT PL",
        "X:ESSEX ST  / LAKEWAY DR",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002393");

    doTest("T3",
        "*** 2nd/16 - Rescue *** 733 HIGHRIDGE RD CS: OCONNER RD  / NARLAND LN TOA: 20:46 09/22/10 a/m pysch emer NORTH BABYLON FC 2010-002395",
        "CALL:2nd/16 - Rescue",
        "ADDR:733 HIGHRIDGE RD",
        "X:OCONNER RD  / NARLAND LN",
        "INFO:a/m pysch emer",
        "SRC:NORTH BABYLON FC",
        "ID:2010-002395");
    
    doTest("T4",
        "*** 23 - Miscellaneous Fire *** SR CITZ APTS (5 BLDGS) COMPLEX 15 WEEKS RD CS: DEER PARK AVE  / MULHOLLAND DR TOA: 11:07 09/23/10 INVEST NORTH B",
        "CALL:23 - Miscellaneous Fire",
        "PLACE:SR CITZ APTS (5 BLDGS) COMPLEX",
        "ADDR:15 WEEKS RD",
        "X:DEER PARK AVE  / MULHOLLAND DR",
        "INFO:INVEST NORTH B");
    
    doTest("T10",
        "*** 24/16 - Mutual Aid *** 27 COOLIDGE AVE CS: RT 110  / COOLIDGE AVE TOA: 06:54 10/20/10 40 Y/F ABDOMINAL PAINS  AMITYVILLE FD 2010-000228",
        "CALL:24/16 - Mutual Aid",
        "ADDR:27 COOLIDGE AVE",
        "X:RT 110  / COOLIDGE AVE",
        "INFO:40 Y/F ABDOMINAL PAINS",
        "SRC:AMITYVILLE FD",
        "ID:2010-000228");
    
    doTest("T11",
        "*** 24/16 - Mutual Aid *** 22 ELGIN RD CS: DE  / COOLIDGE AVE TOA: 11:38 10/18/10 E/F UNABLE TO MOVE  **FULL CREW NEEDED** AMITYVILLE FD 2010-00",
        "CALL:24/16 - Mutual Aid",
        "ADDR:22 ELGIN RD",
        "X:DE  / COOLIDGE AVE",
        "INFO:E/F UNABLE TO MOVE  **FULL CREW NEEDED**",
        "SRC:AMITYVILLE FD",
        "ID:2010-00");
    
    doTest("T12",
        "*** 24/MV - Mutual Aid ***  MONTAUK HWY CS: WILSON AVE TOA: 11:43 10/20/10 AMITYVILLE FD 2010-000229",
        "CALL:24/MV - Mutual Aid",
        "ADDR:MONTAUK HWY",
        "X:WILSON AVE",
        "SRC:AMITYVILLE FD",
        "ID:2010-000229");

    doTest("T13",
        "*** 24/13 - Mutual Aid *** 42 NATHALIE AVE CS: CAMPBELL ST  / MOORE ST TOA: 12:04 10/04/10 POSS OCCUPANTS WITH IN  AMITYVILLE FD 2010-000226",
        "CALL:24/13 - Mutual Aid",
        "ADDR:42 NATHALIE AVE",
        "X:CAMPBELL ST  / MOORE ST",
        "INFO:POSS OCCUPANTS WITH IN",
        "SRC:AMITYVILLE FD",
        "ID:2010-000226");
    
    doTest("T14",
        "*** 3/16 - Rescue *** 204 VAN BUREN ST CS: LEWIS AVE  / BELMONT AVE TOA: 10:04 10/29/10 E/F UNRESPONSIVE  **EMT NEEDED** NO",
        "CALL:3/16 - Rescue",
        "ADDR:204 VAN BUREN ST",
        "X:LEWIS AVE  / BELMONT AVE",
        "INFO:E/F UNRESPONSIVE  **EMT NEEDED** NO");
    
    doTest("T14",
        "*** 16 - Rescue *** 41 WILLIAMS AVE CS: CAMPBELL ST  / MOORE ST TOA: 18:01 10/25/10 E/F UNCONCIOUS-NOT BREATHING AMITYVILLE FD 2010-000231",
        "CALL:16 - Rescue",
        "ADDR:41 WILLIAMS AVE",
        "X:CAMPBELL ST  / MOORE ST",
        "INFO:E/F UNCONCIOUS-NOT BREATHING",
        "SRC:AMITYVILLE FD",
        "ID:2010-000231");
    
    doTest("T15",
        "*** 16 - Rescue *** 100 PARK AVE CS: IRELAND PL  / CEDAR ST TOA: 05:28 10/30/10 E/M  AMITYVILLE FD 2010-000235",
        "CALL:16 - Rescue",
        "ADDR:100 PARK AVE",
        "X:IRELAND PL  / CEDAR ST",
        "INFO:E/M",
        "SRC:AMITYVILLE FD",
        "ID:2010-000235");
    
    doTest("T16",
        "*** 16 - Rescue *** 47 DIXON AVE CS: RT 110  / ALBANY AVE TOA: 20:28 10/27/10 77Y/O FEMALE CHOKING AMITYVILLE FD 2010-000233",
        "CALL:16 - Rescue",
        "ADDR:47 DIXON AVE",
        "X:RT 110  / ALBANY AVE",
        "INFO:77Y/O FEMALE CHOKING",
        "SRC:AMITYVILLE FD",
        "ID:2010-000233");
    
    doTest("T17",
        "*** 24/16 - Mutual Aid *** CHURCH OF GOD 102 COOLIDGE AVE CS: ROSEWOODAVE  / STEELE PL TOA: 17:49 10/28/10 VOV AMITYVILLE FD 2010-000234",
        "CALL:24/16 - Mutual Aid",
        "PLACE:CHURCH OF GOD",
        "ADDR:102 COOLIDGE AVE",
        "X:ROSEWOODAVE  / STEELE PL",
        "INFO:VOV",
        "SRC:AMITYVILLE FD",
        "ID:2010-000234");
    
    doTest("T20",
        "*** 16 - Rescue *** 99 OVERTON ST CS: JEFFERSON AVE  / DEER PARK AVE TOA: 15:06 11/25/10 E/F SICK DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:99 OVERTON ST",
        "X:JEFFERSON AVE  / DEER PARK AVE",
        "INFO:E/F SICK",
        "SRC:DEER PARK FIRE DISTRICT");

    doTest("T21",
        "*** 23 - Miscellaneous Fire *** 14 BROOKLYN ST CS: CARLLS PA  / CAYUGA AVE TOA: 15:59 11/25/10 A/F/A  DEER PARK FIRE DISTRICT",
        "CALL:23 - Miscellaneous Fire",
        "ADDR:14 BROOKLYN ST",
        "X:CARLLS PA  / CAYUGA AVE",
        "INFO:A/F/A",
        "SRC:DEER PARK FIRE DISTRICT");

    doTest("T22",
        "*** 2nd/16 - Rescue *** INVALID 185 W 7TH ST CS: PARK AVE  / CENTRAL AVE TOA: 10:35 12/13/10 80 YR FEM VOMITTING WEAK DEER PARK FIRE DISTRICT",
        "CALL:2nd/16 - Rescue",
        "PLACE:INVALID",
        "ADDR:185 W 7TH ST",
        "X:PARK AVE  / CENTRAL AVE",
        "INFO:80 YR FEM VOMITTING WEAK",
        "SRC:DEER PARK FIRE DISTRICT");
    
    doTest("T23",
        "*** 16 - Rescue *** 189 W 10TH ST CS: PARK AVE  / CENTRAL AVE TOA: 07:53 12/13/10 A/F SYNCOPAL DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:189 W 10TH ST",
        "X:PARK AVE  / CENTRAL AVE",
        "INFO:A/F SYNCOPAL",
        "SRC:DEER PARK FIRE DISTRICT");
   
    doTest("T24",
        "*** 16 - Rescue *** 111 LIBERTY ST CS: DEER PARK AVE  / PINE ACRES BLVD TOA: 20:06 12/12/10 82YR MALE CHEST PAIN DEER PARK FIRE DISTRICT",
        "CALL:16 - Rescue",
        "ADDR:111 LIBERTY ST",
        "X:DEER PARK AVE  / PINE ACRES BLVD",
        "INFO:82YR MALE CHEST PAIN",
        "SRC:DEER PARK FIRE DISTRICT");
    
  }
}