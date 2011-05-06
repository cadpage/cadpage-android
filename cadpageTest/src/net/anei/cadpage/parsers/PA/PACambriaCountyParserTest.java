package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PACambriaCountyParserTest;

import org.junit.Test;
/*
[29] 11 Time: 15:02:29 Nature: 17A01G-Alpha FALL Location: 216 MAIN ST-JO | Sta 35
[29] 11 Time: 11:54:47 Nature: 29B01-Bravo VEH ACC WITH INJURIES Location: 110 PLAZA DR-LY | Sta 30, Sta 23, Sta 35
[29] 11 Time: 08:03:01 Nature: 10C02-Charlie CHEST PAIN Location: 315 LOCUST ST-JO | Sta 35 
[29] 11 Time: 06:45:29 Nature: 17B03G-Bravo FALL Location: WALNUT ST-JO/MAIN ST-JO | Sta 35
[28] 11 Time: 21:39:31 N t 06D03A D lt BREATHING PROBLEMS Location: 205 CHANDLER AVE-JO | Sta 35, Sta 21, Sta 36

*/

public class PACambriaCountyParserTest extends BaseParserTest {
  
  public PACambriaCountyParserTest() {
    setParser(new PACambriaCountyParser(), "CAMBRIA COUNTY", "PA");
  }

 
  
  @Test
  public void testParser() {

    doTest("T1",
        "[29] 11 Time: 15:02:29 Nature: 17A01G-Alpha FALL Location: 216 MAIN ST-JO | Sta 35",
        "CALL:17A01G-Alpha FALL",
        "ADDR:216 MAIN ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");

    doTest("T2",
        "[29] 11 Time: 11:54:47 Nature: 29B01-Bravo VEH ACC WITH INJURIES Location: 110 PLAZA DR-LY | Sta 30, Sta 23, Sta 35",
        "CALL:29B01-Bravo VEH ACC WITH INJURIES",
        "ADDR:110 PLAZA DR",
        "CITY:LY",
        "UNIT:Sta 30, Sta 23, Sta 35");

    doTest("T3",
        "[29] 11 Time: 08:03:01 Nature: 10C02-Charlie CHEST PAIN Location: 315 LOCUST ST-JO | Sta 35",
        "CALL:10C02-Charlie CHEST PAIN",
        "ADDR:315 LOCUST ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");

    doTest("T4",
        "[29] 11 Time: 06:45:29 Nature: 17B03G-Bravo FALL Location: WALNUT ST-JO/MAIN ST-JO | Sta 35",
        "CALL:17B03G-Bravo FALL",
        "ADDR:WALNUT ST & MAIN ST",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35");
    
    doTest("T5",
        "[28] 11 Time: 21:39:31 Nature: 06D03A-Delta BREATHING PROBLEMS Location: 205 CHANDLER AVE-JO | Sta 35, Sta 21, Sta 36",
        "CALL:06D03A-Delta BREATHING PROBLEMS",
        "ADDR:205 CHANDLER AVE",
        "CITY:JOHNSTOWN",
        "UNIT:Sta 35, Sta 21, Sta 36");

    
  }
  
  
  public static void main(String[] args) {
    new PACambriaCountyParserTest().generateTests("T1");
  }
}
