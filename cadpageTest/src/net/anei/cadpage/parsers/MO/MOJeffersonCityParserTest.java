package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOJeffersonCityParserTest extends BaseParserTest {
  
  public MOJeffersonCityParserTest() {
    setParser(new MOJeffersonCityParser(), "JEFFERSON CITY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject:DONOTREPLY\nSnyder, Jodi 14:00 Medical Emergency 718 MICHIGAN -Cross Streets- LOUISIANA AVE / MISSOURI BLVD E1   CONSCIOUS  OUTSID",
        "CALL:Medical Emergency",
        "ADDR:718 MICHIGAN",
        "X:LOUISIANA AVE / MISSOURI BLVD E1",
        "INFO:CONSCIOUS  OUTSID");

    doTest("T2",
        "Subject:DONOTREPLY\nE4  14:28 Line Down  - 1505 SOUTHWEST -Cross Streets- CEDAR RIDGE RD / EDGEWOOD DR   LIMB IS ON A POWER LINE \n",
        "CALL:Line Down",
        "ADDR:1505 SOUTHWEST",
        "X:CEDAR RIDGE RD / EDGEWOOD DR",
        "INFO:LIMB IS ON A POWER LINE");

    doTest("T3",
        "Subject:DONOTREPLY\nMcDowell, Shelley 13:40 Medical Emergency 301 HIGH -Cross Streets- BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1   FEMA",
        "CALL:Medical Emergency",
        "ADDR:301 HIGH",
        "X:BROADWAY ST / RAMP OFF RAMP, RAMP ON RAMP E1",
        "INFO:FEMA");

    doTest("T4",
        "Subject:DONOTREPLY\nBatt12 E1 L1 E3 S5  13:31 Fire Alarm - 1303 EDMONDS -Cross Streets- MONTANA ST / MYRTLE AVE   OPER 38  UNKNOWN ROOM  3",
        "CALL:Fire Alarm",
        "ADDR:1303 EDMONDS",
        "X:MONTANA ST / MYRTLE AVE",
        "INFO:OPER 38  UNKNOWN ROOM  3");

    doTest("T5",
        "Subject:DONOTREPLY\nL1  12:02 Accident with Injuries - 1300 5463 BLK -Cross Streets- RAMP 25, HWY 54 E / RAMP 26   CCEMS EN ROUTE  NEED EX",
        "CALL:Accident with Injuries",
        "ADDR:1300 5463 BLK",
        "X:RAMP 25, HWY 54 E / RAMP 26",
        "INFO:CCEMS EN ROUTE  NEED EX");

    doTest("T6",
        "Subject:DONOTREPLY\nMcDowell, Shelley 10:07 Medical Emergency 1705 CHRISTY -Cross Streets- CHRISTY CT / ELLIS BLVD E4   SUITE 208 \n",
        "CALL:Medical Emergency",
        "ADDR:1705 CHRISTY",
        "X:CHRISTY CT / ELLIS BLVD E4",
        "INFO:SUITE 208");

    doTest("T7",
        "Subject:DONOTREPLY\nMcDowell, Shelley 09:40 Medical Emergency 1434 NOTTING HILL -Cross Streets- DEAD END / PORTABELLO PLACE DR S5   EMS EN",
        "CALL:Medical Emergency",
        "ADDR:1434 NOTTING HILL",
        "X:DEAD END / PORTABELLO PLACE DR S5",
        "INFO:EMS EN");

    doTest("T8",
        "Subject:DONOTREPLY\nMcDowell, Shelley 08:30 Medical Emergency 424 STADIUM -Cross Streets- ADAMS ST / YMCA DR, JACKSON ST E4   ELDERLY MALE",
        "CALL:Medical Emergency",
        "ADDR:424 STADIUM",
        "X:ADAMS ST / YMCA DR, JACKSON ST E4",
        "INFO:ELDERLY MALE");

    doTest("T9",
        "Subject:DONOTREPLY\nStiefermann, Angela 02:32 Medical Alarm 10 JACKSON 704 -Address Between- DEAD END / E STATE ST E1   \n",
        "CALL:Medical Alarm",
        "ADDR:10 JACKSON 704",
        "X:DEAD END / E STATE ST E1");

    doTest("T10",
        "Subject:DONOTREPLY\nE1  16:32 Assist Citizen Fire - MYRTLE EDMONDS -Cross Streets-   MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O",
        "CALL:Assist Citizen Fire",
        "ADDR:MYRTLE EDMONDS",
        "INFO:MALE WAS ROLLING BACKWARDS UNTIL CALLERS SON JUMPED O");

    doTest("T11",
        "FRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Aston, Nora 22:35 Medical Alarm 10 JACKSON 207 -Address Between- DEAD END / E STATE ST E1 EMS NOTIFIED \n",
        "CALL:Medical Alarm",
        "ADDR:10 JACKSON 207",
        "X:DEAD END / E STATE ST E1 EMS NOTIFIED");
 }

  public static void main(String[] args) {
    new MOJeffersonCityParserTest().generateTests("T1", "CALL ADDR X INFO");
  }
}
