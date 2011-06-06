package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.PA.PACambriaCountyParserTest;

import org.junit.Test;

public class PACambriaCountyParserTest extends BaseParserTest {
  
  public PACambriaCountyParserTest() {
    setParser(new PACambriaCountyParser(), "CAMBRIA COUNTY", "PA");
  }

 
  
  @Test
  public void testParser1() {

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
  
  @Test
  public void testParser2() {

    doTest("T1",
        "Date: 06/02/11\nTime: 20:47:52\nNature: 10C01-Charlie CHEST PAIN\nLocation: 1518 W 2ND ST-CR\n| Sta 75",
        "CALL:10C01-Charlie CHEST PAIN",
        "ADDR:1518 W 2ND ST",
        "CITY:CARROLLTOWN",
        "UNIT:Sta 75");

    doTest("T2",
        "Date: 06/04/11\nTime: 11:03:04\nNature: 06D02-Delta\2sBREATHING PROBLEMS\nLocation: 908 SHORT AVE-CR\n| Sta 75",
        "CALL:06D02-Delta\2sBREATHING PROBLEMS",
        "ADDR:908 SHORT AVE",
        "CITY:CARROLLTOWN",
        "UNIT:Sta 75");

    doTest("T3",
        "Date: 06/04/11\nTime: 17:24:03\nNature: STB-STAND BY\nLocation: 721 MAIN ST-PORB\n| Sta 73",
        "CALL:STB-STAND BY",
        "ADDR:721 MAIN ST",
        "CITY:PORTAGE",
        "UNIT:Sta 73");

  }
  
  
  public static void main(String[] args) {
    new PACambriaCountyParserTest().generateTests("T1");
  }
}
