package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class CTHartfordCountyParserTest extends BaseParserTest {
  
  public CTHartfordCountyParserTest() {
    setParser(new CTHartfordCountyParser(), "HARTFORD COUNTY", "CT");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "1100024685 MEDICAL CALL CHARLIE RESPONSE 00088  SCOTT SWAMP RD   UM1 XXFF AMR1 111117 15:13",
        "ID:1100024685",
        "CALL:MEDICAL CALL CHARLIE RESPONSE",
        "ADDR:88 SCOTT SWAMP RD",
        "UNIT:UM1 XXFF AMR1",
        "DATE:11/17/11",
        "TIME:15:13");

    doTest("T2",
        "1200006652 FIRE - BRUSH FIRE 01825 FARMINGTON AVE Prem Map -  PARK POND PL/SOUTH MAIN ST  XXTH 120409 11:05\r\n\r",
        "ID:1200006652",
        "CALL:FIRE - BRUSH FIRE",
        "ADDR:1825 FARMINGTON AVE",
        "X:PARK POND PL / SOUTH MAIN ST",
        "UNIT:XXTH",
        "DATE:04/09/12",
        "TIME:11:05");

    doTest("T3",
        "1200006665 FIRE - MV  00270 FARMINGTON AVE Prem Map -  TALCOTT NOTCH RD/PARK DR  EXOG UE1 XXEF 120409 15:40\r\n\r",
        "ID:1200006665",
        "CALL:FIRE - MV",
        "ADDR:270 FARMINGTON AVE",
        "X:TALCOTT NOTCH RD / PARK DR",
        "UNIT:EXOG UE1 XXEF",
        "DATE:04/09/12",
        "TIME:15:40");

    doTest("T4",
        "1200006659 FIRE - BRUSH FIRE SPIELMAN HWY/ MOUNTAIN SPRING RD   LC1 XXBF 120409 13:26\r\n\r",
        "ID:1200006659",
        "CALL:FIRE - BRUSH FIRE",
        "ADDR:SPIELMAN HWY & MOUNTAIN SPRING RD",
        "UNIT:LC1 XXBF",
        "DATE:04/09/12",
        "TIME:13:26");

    doTest("T5",
        "1200006653 MEDICAL CALL BRAVO RESPONSE 00204 MAIN ST BIDWELL SQ/ROURKE PL  XXFF AMR1 120409 11:12\r\n\r",
        "ID:1200006653",
        "CALL:MEDICAL CALL BRAVO RESPONSE",
        "ADDR:204 MAIN ST",
        "X:BIDWELL SQ / ROURKE PL",
        "UNIT:XXFF AMR1",
        "DATE:04/09/12",
        "TIME:11:12");

    doTest("T6",
        "1200006626 FIRE - SMOKE/GAS INVEST OUTSIDE 00339 MEADOW RD SOMERSBY WAY/JUDSON LA  EXSW XXFF 120409 00:12\r\n\r",
        "ID:1200006626",
        "CALL:FIRE - SMOKE/GAS INVEST OUTSIDE",
        "ADDR:339 MEADOW RD",
        "X:SOMERSBY WAY / JUDSON LA",
        "UNIT:EXSW XXFF",
        "DATE:04/09/12",
        "TIME:00:12");

    doTest("T7",
        "1200006038 MEDICAL CALL CHARLIE RESPONSE 00051 LITCHFIELD RD PLAINVILLE AVE/BIRCH ST  UM1 XXTH AMR1 120330 20:14\r\n\r",
        "ID:1200006038",
        "CALL:MEDICAL CALL CHARLIE RESPONSE",
        "ADDR:51 LITCHFIELD RD",
        "X:PLAINVILLE AVE / BIRCH ST",
        "UNIT:UM1 XXTH AMR1",
        "DATE:03/30/12",
        "TIME:20:14");

  }
  
  public static void main(String[] args) {
    new CTHartfordCountyParserTest().generateTests("T1", "ID CALL ADDR CITY MAP X UNIT DATE TIME");
  }
}