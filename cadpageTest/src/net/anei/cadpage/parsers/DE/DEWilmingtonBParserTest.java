package net.anei.cadpage.parsers.DE;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Wilmington, DE (B)
Contact: Mike Khairzada <mkhairzada@comcast.net>
Sender: WLPD@state.de.us

prvs=765d904d8=WLPD@state.de.us (Incident) FR2 Box Alarm 03/01/13 10:33 1332 W  7TH ST  52B1
[Incident]  FR2 Box Alarm 03/02/13 19:31 3003 W  6TH ST  69C1  3.This is a reported contained appliance fir  s on scene (1st party).  2.Smoke is visible
[Incident]  FR2 Box Alarm 03/03/13 08:58 216 N  CLAYTON ST  60C1O  y).  1.The caller is on scene (1st party).  2  kitchen.     Residential (single)
[Incident]  FR2 Box Alarm 03/02/13 10:09 3301 N  MARKET ST  b10 on scene w/ gas odor inside structure, auth b6 send 1 eng & 1 ladder
[Incident]  FR2 Box Alarm 03/02/13 17:34 514 N  HARRISON ST  69D6  le.  3.The incident involves a single-family  er is on scene (1st party).  2.Smoke
[Incident]  FR2 Box Alarm 03/01/13 19:06 34 W  31ST ST  52C4S  is a smoke detector alarm.  3.The incident i  caller is an alarm monitoring company. 
[Incident]  FR2 Box Alarm 03/01/13 10:31 49 BANCROFT MILLS RD  52C4G  pany.  2.It is a general/fire alarm.  3.The i  re).  1.The caller is an alarm m
prvs=793ebe2c2=WLPD@state.de.us (Incident) FR3 Tactical Box Alarm 03/29/13 09:26 325 E  5TH ST  60D2O  (1st party).  2.The problem is reportedly ins  s odor 5th floor.\3s1.The call
prvs=793ebe2c2=WLPD@state.de.us (Incident) From: James Rosseel Loc: 110 N  POPLAR ST Inc: M1 EMS-Delta :ALS Time: 03/29/13 16:31 2013-00004869 SB2 PA4  Narr:  M6D4  difficulty spea

 */

public class DEWilmingtonBParserTest extends BaseParserTest {
  
  public DEWilmingtonBParserTest() {
    setParser(new DEWilmingtonBParser(), "WILMINGTON", "DE");
  }
  
  @Test
  public void testMikeKhairzada() {

    doTest("T1",
        "prvs=765d904d8=WLPD@state.de.us (Incident) FR2 Box Alarm 03/01/13 10:33 1332 W  7TH ST  52B1",
        "BOX:FR2",
        "DATE:03/01/13",
        "TIME:10:33",
        "ADDR:1332 W  7TH ST",
        "CODE:52B1",
        "CALL:Alarms - Residential");

    doTest("T2",
        "[Incident]  FR2 Box Alarm 03/02/13 19:31 3003 W  6TH ST  69C1  3.This is a reported contained appliance fir  s on scene (1st party).  2.Smoke is visible",
        "BOX:FR2",
        "DATE:03/02/13",
        "TIME:19:31",
        "ADDR:3003 W  6TH ST",
        "CODE:69C1",
        "CALL:Structure Fire - Appliance (contained)",
        "INFO:3.This is a reported contained appliance fir  s on scene (1st party).  2.Smoke is visible");

    doTest("T3",
        "[Incident]  FR2 Box Alarm 03/03/13 08:58 216 N  CLAYTON ST  60C1O  y).  1.The caller is on scene (1st party).  2  kitchen.     Residential (single)",
        "BOX:FR2",
        "DATE:03/03/13",
        "TIME:08:58",
        "ADDR:216 N  CLAYTON ST",
        "CODE:60C1O",
        "CALL:Gas leak/Gas odor - Residential (single) - Odor only",
        "INFO:y).  1.The caller is on scene (1st party).  2  kitchen.     Residential (single)");

    doTest("T4",
        "[Incident]  FR2 Box Alarm 03/02/13 10:09 3301 N  MARKET ST  b10 on scene w/ gas odor inside structure, auth b6 send 1 eng & 1 ladder",
        "BOX:FR2",
        "DATE:03/02/13",
        "TIME:10:09",
        "ADDR:3301 N MARKET ST",
        "CALL:b10 on scene w/ gas odor inside structure, auth b6 send 1 eng & 1 ladder");

    doTest("T5",
        "[Incident]  FR2 Box Alarm 03/02/13 17:34 514 N  HARRISON ST  69D6  le.  3.The incident involves a single-family  er is on scene (1st party).  2.Smoke",
        "BOX:FR2",
        "DATE:03/02/13",
        "TIME:17:34",
        "ADDR:514 N  HARRISON ST",
        "CODE:69D6",
        "CALL:Structure Fire - Residential (single)",
        "INFO:le.  3.The incident involves a single-family  er is on scene (1st party).  2.Smoke");

    doTest("T6",
        "[Incident]  FR2 Box Alarm 03/01/13 19:06 34 W  31ST ST  52C4S  is a smoke detector alarm.  3.The incident i  caller is an alarm monitoring company. ",
        "BOX:FR2",
        "DATE:03/01/13",
        "TIME:19:06",
        "ADDR:34 W  31ST ST",
        "CODE:52C4S",
        "CALL:Alarms - Residential (multiple) - Smoke Detector",
        "INFO:is a smoke detector alarm.  3.The incident i  caller is an alarm monitoring company.");

    doTest("T7",
        "[Incident]  FR2 Box Alarm 03/01/13 10:31 49 BANCROFT MILLS RD  52C4G  pany.  2.It is a general/fire alarm.  3.The i  re).  1.The caller is an alarm m",
        "BOX:FR2",
        "DATE:03/01/13",
        "TIME:10:31",
        "ADDR:49 BANCROFT MILLS RD",
        "CODE:52C4G",
        "CALL:Alarms - Residential (multiple) - General/Fire",
        "INFO:pany.  2.It is a general/fire alarm.  3.The i  re).  1.The caller is an alarm m");

    doTest("T8",
        "prvs=793ebe2c2=WLPD@state.de.us (Incident) FR3 Tactical Box Alarm 03/29/13 09:26 325 E  5TH ST  60D2O  (1st party).  2.The problem is reportedly ins  s odor 5th floor.\\3s1.The call",
        "BOX:FR3",
        "DATE:03/29/13",
        "TIME:09:26",
        "ADDR:325 E  5TH ST",
        "CODE:60D2O",
        "CALL:Gas leak/Gas odor - High rise - Odor only",
        "INFO:(1st party).  2.The problem is reportedly ins  s odor 5th floor.\\3s1.The call");

  }
  
  public static void main(String[] args) {
    new DEWilmingtonBParserTest().generateTests("T1");
  }
}
    		