package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class MOJeffersonCityParserTest extends BaseParserTest {
  
  public MOJeffersonCityParserTest() {
    setParser(new MOJeffersonCityParser(), "JEFFERSON CITY", "MO");
  }
  
  @Test
  public void testParser1() {

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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "1410000046:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Batt12 E1 L1 S2 E4  13:40 Structure Fire - 600 ADAMS -Cross Streets-\nDEAD END / E CEDAR WAY\n(Con't) 2 of 2\n  LAST HOUSE DEAD END OF ADAMS  DECK ON FIRE  SMOKE IN THE AREA\n(End)\n",
        "CALL:Structure Fire",
        "ADDR:600 ADAMS",
        "X:DEAD END / E CEDAR WAY",
        "INFO:LAST HOUSE DEAD END OF ADAMS  DECK ON FIRE  SMOKE IN THE AREA");

    doTest("T2",
        "1410000050:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Gabathuler, Erin 20:34 Medical Emergency 207 FRANKLIN A -Cross Streets-\nMADISON ST / MONROE\n(Con't) 2 of 2\nST L1   HISTORY OF DIABETES  48 YO FEMALE HAS FELL AND IS\n(End)",
        "CALL:Medical Emergency",
        "ADDR:207 FRANKLIN A",
        "X:MADISON ST / MONROE ST L1",
        "INFO:HISTORY OF DIABETES  48 YO FEMALE HAS FELL AND IS");

    doTest("T3",
        "1410000052:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Suchanek, Celeste 23:52 Medical Emergency 531 ELM A -Cross Streets-\nJACKSON ST / MARSHALL\n(Con't) 2 of 2\nST L1   F 5 MONTHS PREGNANT   BLEEDING\n(End)",
        "CALL:Medical Emergency",
        "ADDR:531 ELM A",
        "X:JACKSON ST / MARSHALL ST L1",
        "INFO:F 5 MONTHS PREGNANT   BLEEDING");

    doTest("T4",
        "1410000045:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Batt12 E1 L1 S5 E4  11:42 Fire Alarm - 1432 SOUTHWEST -Cross Streets-\nEDGEWOOD DR / CEDAR\n(Con't) 2 of 2\nRIDGE RD   GENERAL FIRE\n(End)",
        "CALL:Fire Alarm",
        "ADDR:1432 SOUTHWEST",
        "X:EDGEWOOD DR / CEDAR RIDGE RD",
        "INFO:GENERAL FIRE");

    doTest("T5",
        "1410000036:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Snyder, Jodi 11:18 Medical Emergency 308 BENTON -Cross Streets- DEAD END\n/ COLLIER LN,\n(Con't) 2 of 2\nNORTHWAY DR L1   SUBJECT CAN'T WALK\n(End)",
        "CALL:Medical Emergency",
        "ADDR:308 BENTON",
        "X:DEAD END / COLLIER LN, NORTHWAY DR L1",
        "INFO:SUBJECT CAN'T WALK");

    doTest("T6",
        "1410000039:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:Morgan, Kacey 22:05 Medical Emergency 1020 ELIZABETH A -Cross Streets-\nEDMONDS ST / MYRTLE\n(Con't) 2 of 2\nAVE L1   SUBJECT IS ON A BREATHING MACHINE  ASTHMA ATTACK\n(End)",
        "CALL:Medical Emergency",
        "ADDR:1020 ELIZABETH A",
        "X:EDMONDS ST / MYRTLE AVE L1",
        "INFO:SUBJECT IS ON A BREATHING MACHINE  ASTHMA ATTACK");

    doTest("T7",
        "1410000043:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:1101 1401 1110 112 CCPager  17:53 Fire Alarm - 2709 LILAC -Cross\nStreets- DEAD END / S\n(Con't) 2 of 2\nCOUNTRY CLUB DR   RESIDENTAL- PIERSONS - FIRE MAIN FLOOR\n(End)",
        "CALL:Fire Alarm",
        "ADDR:2709 LILAC",
        "X:DEAD END / S COUNTRY CLUB DR",
        "INFO:RESIDENTAL- PIERSONS - FIRE MAIN FLOOR");

    doTest("T8",
        "1410000038:  1 of 2\nFRM:paging@jeffcitymo.org\nSUBJ:DONOTREPLY\nMSG:1201 1401 1531 114 CCPager  17:45 Accident with Injuries - 8000 D BLK\n-Cross Streets-\n(Con't) 2 of 2\nSCRIVNER RD / BATES RD   RP JUST HEARD THE ACCIDENT  UNKNOWN INJURY\n(End)",
        "CALL:Accident with Injuries",
        "ADDR:8000 D BLK",
        "X:SCRIVNER RD / BATES RD",
        "INFO:RP JUST HEARD THE ACCIDENT  UNKNOWN INJURY");

  }

  public static void main(String[] args) {
    new MOJeffersonCityParserTest().generateTests("T1", "CALL ADDR X INFO");
  }
}
