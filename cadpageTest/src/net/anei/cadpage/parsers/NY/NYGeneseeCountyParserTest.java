package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYGeneseeCountyParserTest extends BaseParserTest {
  
  public NYGeneseeCountyParserTest() {
    setParser(new NYGeneseeCountyParser(), "GENESEE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Dispatch]  Acc PIAA ** 392.3 RT 90 E** , BATAVIA - ** ONE VEHICLE ROLLOVER ** LEWISTON RD, I 90 / KELSEY RD, I 90 ** 07/12/11 17:29 **",
        "CALL:Acc PIAA",
        "ADDR:392.3 RT 90 E",
        "MADDR:392.3 RT 90 E & LEWISTON RD",
        "CITY:BATAVIA",
        "INFO:ONE VEHICLE ROLLOVER",
        "X:LEWISTON RD, I 90 / KELSEY RD, I 90",
        "DATE:07/12/11",
        "TIME:17:29");

    doTest("T2",
        "[Dispatch]  Alarm Fire ** ** 2614 W  MAIN STREET RD , BATAVIA - ** 2ND FLOOR SMOKE DETECRTOR KENNETH HERMAN RESIDENCE ** READ",
        "CALL:Alarm Fire",
        "ADDR:2614 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "INFO:2ND FLOOR SMOKE DETECRTOR KENNETH HERMAN RESIDENCE",
        "X:READ");

    doTest("T3",
        "[Dispatch]  Fire Auto ** 387.6 RT 90 W** , BATAVIA - ** POSS TRACTOR TRAILER FIRE - BOX TRAILER ** I 90, I-90 CONNECTOR / I 90,",
        "CALL:Fire Auto",
        "ADDR:387.6 RT 90 W",
        "MADDR:387.6 RT 90 W & I 90",
        "CITY:BATAVIA",
        "INFO:POSS TRACTOR TRAILER FIRE - BOX TRAILER",
        "X:I 90, I-90 CONNECTOR / I 90,");

    doTest("T4",
        "[Dispatch]  Fire Nat Propane Gas ** ** 8470 VIOLET LN , BATAVIA - ** COMPL STRUCK GAS LINE OUT THE RESIDENCE 1/2\" LINE  ** DANA",
        "CALL:Fire Nat Propane Gas",
        "ADDR:8470 VIOLET LN",
        "CITY:BATAVIA",
        "INFO:COMPL STRUCK GAS LINE OUT THE RESIDENCE 1/2\" LINE",
        "X:DANA");

    doTest("T5",
        "[Dispatch]  Acc PIAA ** ** 5402 ELLICOTT STREET RD , BETHANY - ** ONE VEHICLE ACCIDENT ** CLAPSADDLE RD / MAYNE RD ** 06/19/11 02:22 **",
        "CALL:Acc PIAA",
        "ADDR:5402 ELLICOTT STREET RD",
        "CITY:BETHANY",
        "INFO:ONE VEHICLE ACCIDENT",
        "X:CLAPSADDLE RD / MAYNE RD",
        "DATE:06/19/11",
        "TIME:02:22");

    doTest("T6",
        "(Dispatch) Acc PIAA ** FRONTIER KITCHENS** 8392 LEWISTON RD , BATAVIA - ** TWO CAR MVA MINER INJ ** PARK RD / W MAIN STREET RD",
        "CALL:Acc PIAA",
        "PLACE:FRONTIER KITCHENS",
        "ADDR:8392 LEWISTON RD",
        "CITY:BATAVIA",
        "INFO:TWO CAR MVA MINER INJ",
        "X:PARK RD / W MAIN STREET RD");

    doTest("T7",
        "(Dispatch) Alarm Fire ** COLLEGE VILLAGE** 8170 BATAVIA STAFFORD TOWNLINE RD , BATAVIA - ** F 201- FIRE ALARM - ALARM HAS RESE",
        "CALL:Alarm Fire",
        "PLACE:COLLEGE VILLAGE",
        "ADDR:8170 BATAVIA STAFFORD TOWNLINE RD",
        "CITY:BATAVIA",
        "INFO:F 201- FIRE ALARM - ALARM HAS RESE");

    doTest("T8",
        "[Dispatch]  Acc PIAA ** Johnson Automotive** 3924 W  MAIN STREET RD , BATAVIA - ** 2 CAR MVA W INJ ** COUNTY BLDG / COLONIAL BL",
        "CALL:Acc PIAA",
        "PLACE:Johnson Automotive",
        "ADDR:3924 W  MAIN STREET RD",
        "CITY:BATAVIA",
        "INFO:2 CAR MVA W INJ",
        "X:COUNTY BLDG / COLONIAL BL");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH Unit:251 Status:Dispatched Acc PIAA ** BANK STREET RD , ASSEMBLYMAN R. STEPHEN HAWLEY DR BATAVIA - ** 3 CAR MVA ** ** 01/19/12 11:07",
        "UNIT:251",
        "CALL:Acc PIAA",
        "ADDR:BANK STREET RD",
        "MADDR:BANK STREET RD & ASSEMBLYMAN R STEPHEN HAWLEY DR",
        "CITY:BATAVIA",
        "INFO:3 CAR MVA",
        "X:ASSEMBLYMAN R STEPHEN HAWLEY DR",
        "DATE:01/19/12",
        "TIME:11:07");

    doTest("T2",
        "GENESEE COUNTY DISPATCH Unit:251 Status:Dispatched Acc PIAA * ** BATAVIA STAFFORD TOWNLINE RD , FOTCH RD BATAVIA - ** ** ** 01/20/12 16:08 ** 2012-00001287 ** TXT STOP to opt-out",
        "UNIT:251",
        "CALL:Acc PIAA",
        "ADDR:BATAVIA STAFFORD TOWNLINE RD",
        "MADDR:BATAVIA STAFFORD TOWNLINE RD & FOTCH RD",
        "CITY:BATAVIA",
        "X:FOTCH RD",
        "DATE:01/20/12",
        "TIME:16:08",
        "ID:2012-00001287");

    doTest("T3",
        "GENESEE COUNTY DISPATCH Unit:251 Status:Dispatched Fire CO Detector ** ** 3645 GALLOWAY RD , BATAVIA - ** CO DECTOR IS GOING OFF ** LEWISTON RD / KELSEY RD ** 01/18/12 18:52 ** 2012-00000016 ** TXT STOP to opt-out",
        "UNIT:251",
        "CALL:Fire CO Detector",
        "ADDR:3645 GALLOWAY RD",
        "CITY:BATAVIA",
        "INFO:CO DECTOR IS GOING OFF",
        "X:LEWISTON RD / KELSEY RD",
        "DATE:01/18/12",
        "TIME:18:52",
        "ID:2012-00000016");

    doTest("T4",
        "GENESEE COUNTY DISPATCH Unit:251 Status:Dispatched Acc PIAA * ** BANK STREET RD , ASSEMBLYMAN R. STEPHEN HAWLEY DR BATAVIA - ** 3 CAR MVA ** ** 01/19/12 11:07 ** 2012-00000188 ** TXT STOP to opt-out",
        "UNIT:251",
        "CALL:Acc PIAA",
        "ADDR:BANK STREET RD",
        "MADDR:BANK STREET RD & ASSEMBLYMAN R STEPHEN HAWLEY DR",
        "CITY:BATAVIA",
        "INFO:3 CAR MVA",
        "X:ASSEMBLYMAN R STEPHEN HAWLEY DR",
        "DATE:01/19/12",
        "TIME:11:07",
        "ID:2012-00000188");

    doTest("T5",
        "GENESEE COUNTY DISPATCH Unit:EP56 Status:Dispatched EMD Alpha ** ** 2128 MAIN RD , PEMBROKE - ** 78 Y/O MALE COMPLAINING OF DIZZINESS ** INDIAN FALLS RD / CLEVELAND RD ** 01/22/12 06:57 ** 2012-00000021 ** TXT STOP to opt-out",
        "UNIT:EP56",
        "CALL:EMD Alpha",
        "ADDR:2128 MAIN RD",
        "CITY:PEMBROKE",
        "INFO:78 Y/O MALE COMPLAINING OF DIZZINESS",
        "X:INDIAN FALLS RD / CLEVELAND RD",
        "DATE:01/22/12",
        "TIME:06:57",
        "ID:2012-00000021");

    doTest("T6",
        "GENESEE COUNTY DISPATCH EMD Delta ** ** 2584 MAIN RD , PEMBROKE - LOWER ** 25 YO MALE TROUBLE BREATHING - CO REQ NO FIRE DEPT ** SLUSSER RD / CHURCH ST ** 02/13/12 04:59 ** 2012-00000035 ** TXT STOP to opt-out",
        "CALL:EMD Delta",
        "ADDR:2584 MAIN RD",
        "INFO:25 YO MALE TROUBLE BREATHING - CO REQ NO FIRE DEPT",
        "X:PEMBROKE - LOWER & SLUSSER RD / CHURCH ST",
        "DATE:02/13/12",
        "TIME:04:59",
        "ID:2012-00000035");
  }
  
  @Test
  public void testParser3() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH Unit:EP57 Status:Dispatched EMD Alpha ** Batavia Mobile Home Park** 3322 W MAIN STREET RD , BATAVIA - 31 ** 40 Y/O MALE VOMITTING ** WORTENDYKE RD / STEGMAN RD ** 01/29/12 10:53 ** 2012-00000025 ** TXT STOP to opt-out",
        "UNIT:EP57",
        "CALL:EMD Alpha",
        "PLACE:Batavia Mobile Home Park",
        "ADDR:3322 W MAIN STREET RD",
        "CITY:BATAVIA",
        "INFO:31 / 40 Y/O MALE VOMITTING",
        "X:WORTENDYKE RD / STEGMAN RD",
        "DATE:01/29/12",
        "TIME:10:53",
        "ID:2012-00000025");

    doTest("T2",
        "GENESEE COUNTY DISPATCH EMD Charlie ** ** 1858 MAIN RD , PEMBROKE - ** 91 YOM POSS STROKE ** CLEVELAND RD / BOYCE RD ** 01/30/12 20:25 ** 2012-00000026 ** TXT STOP to opt-out",
        "CALL:EMD Charlie",
        "ADDR:1858 MAIN RD",
        "CITY:PEMBROKE",
        "INFO:91 YOM POSS STROKE",
        "X:CLEVELAND RD / BOYCE RD",
        "DATE:01/30/12",
        "TIME:20:25",
        "ID:2012-00000026");

  }
  
  @Test
  public void testParser4() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH EMD Charlie ** ** 11208 MAPLEWOOD RD , ALEXANDER - ** 10 MO FEMALE PASSING OUT ** STROH RD / GENESEE ST ** 02/07/12 19:53 ** 2012-00000026 ** TXT STOP to opt-out",
        "CALL:EMD Charlie",
        "ADDR:11208 MAPLEWOOD RD",
        "CITY:ALEXANDER",
        "INFO:10 MO FEMALE PASSING OUT",
        "X:STROH RD / GENESEE ST",
        "DATE:02/07/12",
        "TIME:19:53",
        "ID:2012-00000026");

    doTest("T2",
        "GENESEE COUNTY DISPATCH Unit:AX10 Status:Dispatched EMD Delta ** ** 89 COLONY RUN , ATTICA - APT D ** 78YO MALE TROUBLE BREATHING  ** COLONY CT / ALEXANDER RD ** 02/26/12 20:04 ** 2012-00000046 ** TXT STOP to opt-out",
        "UNIT:AX10",
        "CALL:EMD Delta",
        "ADDR:89 COLONY RUN",
        "INFO:78YO MALE TROUBLE BREATHING",
        "X:ATTICA - APT D & COLONY CT / ALEXANDER RD",
        "DATE:02/26/12",
        "TIME:20:04",
        "ID:2012-00000046");

  }
  
  @Test
  public void testParser5() {

    doTest("T1",
        "GENESEE COUNTY DISPATCH Unit:AX06 Status:Dispatched Fire Mutual Aid ** * <UNKNOWN> , - ** FAST TEAM TO THE HOUSE FIRE ** ** 02/09/12 10:21 ** 2012-00000027 ** TXT STOP to opt-out",
        "UNIT:AX06",
        "CALL:Fire Mutual Aid",
        "ADDR:* <UNKNOWN>",
        "INFO:FAST TEAM TO THE HOUSE FIRE",
        "DATE:02/09/12",
        "TIME:10:21",
        "ID:2012-00000027");

  }
  
  public static void main(String[] args) {
    new NYGeneseeCountyParserTest().generateTests("T1");
  }
}