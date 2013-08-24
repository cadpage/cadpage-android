package net.anei.cadpage.parsers.NJ;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/* 
Summerset County, NJ
Finderne (Bridgewater, NJ - Somerset County) (separate dispatch from NCSomersetCounty)
Sender: rc.324@c-msg.net

<Call Type> | <Address > | <Cross Streets> | <venue/City> | <Units>

13 - Assist|110 REHILL AVE SOMERSET MEDICAL CENTER|STEELE AVE/FAIRMONT AVE|Somerville|1FFD
13 - Assist|204 SUTPHIN LN|WESCOTT RD/SAXSON ST|Hillsborough|2FFD2,FFD
AF - Fire Alarm|31 SHADY LN|HAYWARD ST/CATHY CT|Bridgewater|1FFD
38V - Car fire| VAN VEGHTEN DR/ FINDERNE AVE|Quadrant: Finderne FD|Bridgewater|1FFD
38V - Car fire|I 287/NB 14.5||Bridgewater|6A1,30-101,30-102,SMC801,FFD2,FFD
AF - Fire Alarm|1260 USHY 22 EB DAYS INN|No Cross Streets Found|Bridgewater|5A3,A1,30-102,311D,FFD
38L - Lines Down|594 BRIDGEWATER AVE|WHARTON AVE/FINDERNE AVE|Bridgewater|6A2,A1,BWFO,30-102,311E,FFD
AF - Fire Alarm|600 PROMENADE BLVD CHUCK E CHEESE|CONNECTING ROAD/CONNECTING ROAD|Bridgewater|5A2,A1,BWFO,FFD2,FFD
38G - Gas Leak|31 MORGAN LN APT 4B|COLUMBIA DR/KELLY CT|Bridgewater|6BWFO,30-101,FFD2,311F,FRS1,FFD
38V - Car fire|USHY 22 E/THOMPSON AVE||| 8110D,SMC802,BWFO,30-102,RJ3,RJ2,FFD2,FFD
39 - Notify|POLHEMUS LANE||Bridgewater|4FFD2,BBRS2,FRS2,FFD

*/
public class NJSomersetCountyCParserTest extends BaseParserTest {
  
  public NJSomersetCountyCParserTest() {
    setParser(new NJSomersetCountyCParser(), "SOMERSET COUNTY", "NJ");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "13 - Assist|110 REHILL AVE SOMERSET MEDICAL CENTER|STEELE AVE/FAIRMONT AVE|Somerville|1FFD",
        "CODE:13",
        "CALL:Assist",
        "ADDR:110 REHILL AVE",
        "CITY:Somerville",
        "PLACE:SOMERSET MEDICAL CENTER",
        "X:STEELE AVE/FAIRMONT AVE",
        "UNIT:1FFD");

    doTest("T2",
        "13 - Assist|204 SUTPHIN LN|WESCOTT RD/SAXSON ST|Hillsborough|2FFD2,FFD",
        "CODE:13",
        "CALL:Assist",
        "ADDR:204 SUTPHIN LN",
        "CITY:Hillsborough",
        "X:WESCOTT RD/SAXSON ST",
        "UNIT:2FFD2,FFD");

    doTest("T3",
        "AF - Fire Alarm|31 SHADY LN|HAYWARD ST/CATHY CT|Bridgewater|1FFD",
        "CODE:AF",
        "CALL:Fire Alarm",
        "ADDR:31 SHADY LN",
        "CITY:Bridgewater",
        "X:HAYWARD ST/CATHY CT",
        "UNIT:1FFD");

    doTest("T4",
        "38V - Car fire| VAN VEGHTEN DR/ FINDERNE AVE|Quadrant: Finderne FD|Bridgewater|1FFD",
        "CODE:38V",
        "CALL:Car fire",
        "ADDR:VAN VEGHTEN DR & FINDERNE AVE",
        "CITY:Bridgewater",
        "X:Quadrant: Finderne FD",  // Misparsed quadrant??
        "UNIT:1FFD");

    doTest("T5",
        "38V - Car fire|I 287/NB 14.5||Bridgewater|6A1,30-101,30-102,SMC801,FFD2,FFD",
        "CODE:38V",
        "CALL:Car fire",
        "ADDR:I 287",
        "CITY:Bridgewater",
        "PLACE:/NB 14.5",
        "UNIT:6A1,30-101,30-102,SMC801,FFD2,FFD");

    doTest("T6",
        "AF - Fire Alarm|1260 USHY 22 EB DAYS INN|No Cross Streets Found|Bridgewater|5A3,A1,30-102,311D,FFD",
        "CODE:AF",
        "CALL:Fire Alarm",
        "ADDR:1260 USHY 22 EB",
        "MADDR:1260 US 22",
        "CITY:Bridgewater",
        "PLACE:DAYS INN",
        "X:No Cross Streets Found",
        "UNIT:5A3,A1,30-102,311D,FFD");

    doTest("T7",
        "38L - Lines Down|594 BRIDGEWATER AVE|WHARTON AVE/FINDERNE AVE|Bridgewater|6A2,A1,BWFO,30-102,311E,FFD",
        "CODE:38L",
        "CALL:Lines Down",
        "ADDR:594 BRIDGEWATER AVE",
        "CITY:Bridgewater",
        "X:WHARTON AVE/FINDERNE AVE",
        "UNIT:6A2,A1,BWFO,30-102,311E,FFD");

    doTest("T8",
        "AF - Fire Alarm|600 PROMENADE BLVD CHUCK E CHEESE|CONNECTING ROAD/CONNECTING ROAD|Bridgewater|5A2,A1,BWFO,FFD2,FFD",
        "CODE:AF",
        "CALL:Fire Alarm",
        "ADDR:600 PROMENADE BLVD",
        "CITY:Bridgewater",
        "PLACE:CHUCK E CHEESE",
        "X:CONNECTING ROAD/CONNECTING ROAD",
        "UNIT:5A2,A1,BWFO,FFD2,FFD");

    doTest("T9",
        "38G - Gas Leak|31 MORGAN LN APT 4B|COLUMBIA DR/KELLY CT|Bridgewater|6BWFO,30-101,FFD2,311F,FRS1,FFD",
        "CODE:38G",
        "CALL:Gas Leak",
        "ADDR:31 MORGAN LN",
        "APT:4B",
        "CITY:Bridgewater",
        "X:COLUMBIA DR/KELLY CT",
        "UNIT:6BWFO,30-101,FFD2,311F,FRS1,FFD");

    doTest("T10",
        "38V - Car fire|USHY 22 E/THOMPSON AVE||| 8110D,SMC802,BWFO,30-102,RJ3,RJ2,FFD2,FFD",
        "CODE:38V",
        "CALL:Car fire",
        "ADDR:USHY 22 E & THOMPSON AVE",
        "MADDR:US 22 E & THOMPSON AVE",
        "UNIT:8110D,SMC802,BWFO,30-102,RJ3,RJ2,FFD2,FFD");

    doTest("T11",
        "39 - Notify|POLHEMUS LANE||Bridgewater|4FFD2,BBRS2,FRS2,FFD",
        "CODE:39",
        "CALL:Notify",
        "ADDR:POLHEMUS LANE",
        "CITY:Bridgewater",
        "UNIT:4FFD2,BBRS2,FRS2,FFD");

  }
  
  public static void main(String[] args) {
    new NJSomersetCountyCParserTest().generateTests("T1");
  }
}