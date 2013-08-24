package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Bloomfield, CT
Contact: Steve H <Shess@bloomfieldctfd.com>
Sender: bloomfielddispatch@rednmxcad.com

Fire Alarm, Commercial Fire Alarm: AUDIBAL ALARM NO SMOKE NO FIRE. BASEMENT LIGHT at 120 MOUNTAIN AVE #MAINBLDG, BLOOMFIELD  c/s: LOEFFLER RD   O:  
Motor Vehicle Accident, Motor Vehicle Accident with Injuries at BRITTON DR / BLUE HILLS AVE, BLOOMFIELD . . 13:08:56
Motor Vehicle Accident, Motor Vehicle Accident with Injuries: CAR VS BOX TRUCK at BLUE HILLS AVE / WEST DUDLEY TOWN RD, BLOOMFIELD . . 13:52:30
Motor Vehicle Accident, Motor Vehicle Accident with Injuries at COTTAGE GROVE RD / PROSPECT ST, BLOOMFIELD . . 14:45:33

*/

public class CTBloomfieldParserTest extends BaseParserTest {
  
  public CTBloomfieldParserTest() {
    setParser(new CTBloomfieldParser(), "BLOOMFIELD", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Fire Alarm, Commercial Fire Alarm: AUDIBAL ALARM NO SMOKE NO FIRE. BASEMENT LIGHT at 120 MOUNTAIN AVE #MAINBLDG, BLOOMFIELD  c/s: LOEFFLER RD   O:  ",
        "CALL:Fire Alarm, Commercial Fire Alarm",
        "INFO:AUDIBAL ALARM NO SMOKE NO FIRE. BASEMENT LIGHT",
        "ADDR:120 MOUNTAIN AVE",
        "APT:MAINBLDG",
        "CITY:BLOOMFIELD",
        "X:LOEFFLER RD");

    doTest("T2",
        "Motor Vehicle Accident, Motor Vehicle Accident with Injuries at BRITTON DR / BLUE HILLS AVE, BLOOMFIELD . . 13:08:56",
        "CALL:Motor Vehicle Accident, Motor Vehicle Accident with Injuries",
        "ADDR:BRITTON DR & BLUE HILLS AVE",
        "CITY:BLOOMFIELD",
        "TIME:13:08:56");

    doTest("T3",
        "Motor Vehicle Accident, Motor Vehicle Accident with Injuries: CAR VS BOX TRUCK at BLUE HILLS AVE / WEST DUDLEY TOWN RD, BLOOMFIELD . . 13:52:30",
        "CALL:Motor Vehicle Accident, Motor Vehicle Accident with Injuries",
        "INFO:CAR VS BOX TRUCK",
        "ADDR:BLUE HILLS AVE & WEST DUDLEY TOWN RD",
        "CITY:BLOOMFIELD",
        "TIME:13:52:30");

    doTest("T4",
        "Motor Vehicle Accident, Motor Vehicle Accident with Injuries at COTTAGE GROVE RD / PROSPECT ST, BLOOMFIELD . . 14:45:33",
        "CALL:Motor Vehicle Accident, Motor Vehicle Accident with Injuries",
        "ADDR:COTTAGE GROVE RD & PROSPECT ST",  // Not found in Bloomfield
        "CITY:BLOOMFIELD",
        "TIME:14:45:33");

  }
  
  public static void main(String[] args) {
    new CTBloomfieldParserTest().generateTests("T1");
  }

}