package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NCCatawbaCountyParserTest extends BaseParserTest {
  
  public NCCatawbaCountyParserTest() {
    setParser(new NCCatawbaCountyParser(), "CATAWBA COUNTY", "NC");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "|2011-000821*213 9TH ST SW***CONOVER**STRUCTURE*********",
        "ID:2011-000821",
        "ADDR:213 9TH ST SW",
        "CITY:CONOVER",
        "CALL:STRUCTURE");

    doTest("T2",
        "|2010-190520*3977 C & B FARM RD***CONOVER**AUTO PD*********",
        "ID:2010-190520",
        "ADDR:3977 C AND B FARM RD",
        "CITY:CONOVER",
        "CALL:AUTO PD");

    doTest("T3",
        "|2010-188877*1127 2ND ST NE*218**CONOVER**LIFELINE*********",
        "ID:2010-188877",
        "ADDR:1127 2ND ST NE",
        "CITY:CONOVER",
        "CALL:LIFELINE");

    doTest("T4",
        "|2010-188192*1405 DEBORAH HERMAN RD SW***CONOVER**FIRE ALARM*********",
        "ID:2010-188192",
        "ADDR:1405 DEBORAH HERMAN RD SW",
        "CITY:CONOVER",
        "CALL:FIRE ALARM");

    doTest("T5",
        "|2011-000273*1104 CONOVER BLVD E***CONOVER**VEHICLE FIRE*********",
        "ID:2011-000273",
        "ADDR:1104 CONOVER BLVD E",
        "CITY:CONOVER",
        "CALL:VEHICLE FIRE");

    doTest("T6",
        "|2010-190520*3977 C & B FARM RD***CONOVER**AUTO PD*********",
        "ID:2010-190520",
        "ADDR:3977 C AND B FARM RD",
        "CITY:CONOVER",
        "CALL:AUTO PD");

    doTest("T7",
        "2010-189098*1211 PECAN ST***CONOVER**OVERDOSE*********",
        "ID:2010-189098",
        "ADDR:1211 PECAN ST",
        "CITY:CONOVER",
        "CALL:OVERDOSE");

    doTest("T8",
        "2011-020998*100 SOUTHWEST BLVD*B*1*NEWTON**TESTING*ALARMING TESTING*CATAWBA COUNTY SHERIFFS OFFICE*828-464-5241*C51*363*Medical: No*Hazards: No*02/09/2011 07:52:50 : pos4 : BADRUM   Landmark: CATAWBA COUNTY SHERIFFS OFFICE*",
        "ID:2011-020998",
        "ADDR:100 SOUTHWEST BLVD",
        "APT:1",
        "CITY:NEWTON",
        "INFO:ALARMING TESTING / Medical: No / Hazards: No / 02/09/2011 07:52:50 : pos4 : BADRUM   Landmark: CATAWBA COUNTY SHERIFFS OFFICE",
        "CALL:TESTING",
        "PLACE:CATAWBA COUNTY SHERIFFS OFFICE",
        "PHONE:828-464-5241",
        "UNIT:C51");

    doTest("T9",
        "2011-021005*SHERRILLS FORD RD // ALLEY RD***CATAWBA**TESTING*ALARMING TESTING*TEST*828-   -*ZZZ,C51**Medical: No*Hazards: No*02/09/2011 08:07:18 : pos4 : BADRUM   SHERRILLS FORD RD//ALLEY RD*",
        "ID:2011-021005",
        "ADDR:SHERRILLS FORD RD & ALLEY RD",
        "CITY:CATAWBA",
        "INFO:ALARMING TESTING / Medical: No / Hazards: No / 02/09/2011 08:07:18 : pos4 : BADRUM   SHERRILLS FORD RD/ALLEY RD",
        "CALL:TESTING",
        "PLACE:TEST",
        "PHONE:828-   -",
        "UNIT:ZZZ,C51");

    doTest("T10",
        "2011-021016*1101 S BRADY AV*E*12*NEWTON**TESTING*ALARMING TESTING*EMS STANDBY NEWTON AREA*828-465-0034*C51*364*Medical: No*Hazards: No*02/09/2011 08:20:34 : pos4 : BADRUM   Landmark: EMS STANDBY NEWTON AREA*",
        "ID:2011-021016",
        "ADDR:1101 S BRADY AV",
        "MADDR:1101 S BRADY AVE",
        "APT:12",
        "CITY:NEWTON",
        "INFO:ALARMING TESTING / Medical: No / Hazards: No / 02/09/2011 08:20:34 : pos4 : BADRUM   Landmark: EMS STANDBY NEWTON AREA",
        "CALL:TESTING",
        "PLACE:EMS STANDBY NEWTON AREA",
        "PHONE:828-465-0034",
        "UNIT:C51");

    doTest("T11",
        "2011-021018*100 SOUTHWEST BLVD*A**NEWTON*Landmark Comment: AED 1ST FLOOR LOBBY HALLWAY NEAR PUBLIC REST ROOMS*TESTING*ALARMING TESTING**828-465-8200*C51*363*Medical: No*Hazards: No*02/09/2011 08:26:53 : pos4 : BADRUM   Landmark: CATAWBA COUNTY GOVERNMENT CENTER  Landmark Comment: AED 1ST FLOOR LOBBY HALLWAY NEAR PUBLIC REST ROOMS*",
        "ID:2011-021018",
        "ADDR:100 SOUTHWEST BLVD",
        "CITY:NEWTON",
        "INFO:Landmark Comment: AED 1ST FLOOR LOBBY HALLWAY NEAR PUBLIC REST ROOMS / ALARMING TESTING / Medical: No / Hazards: No / 02/09/2011 08:26:53 : pos4 : BADRUM   Landmark: CATAWBA COUNTY GOVERNMENT CENTER  Landmark Comment: AED 1ST FLOOR LOBBY HALLWAY NEAR PUBLIC REST ROOMS",
        "CALL:TESTING",
        "PHONE:828-465-8200",
        "UNIT:C51");

    doTest("T12",
        "2011-021063*2204 WITHERS RD***MAIDEN**OVERDOSE*********",
        "ID:2011-021063",
        "ADDR:2204 WITHERS RD",
        "CITY:MAIDEN",
        "CALL:OVERDOSE");

    doTest("T13",
        "2011-021052*35 S US 321 HWY***NEWTON**Traffic Stop*********",
        "ID:2011-021052",
        "ADDR:35 S US 321 HWY",
        "MADDR:35 S US 321",
        "CITY:NEWTON",
        "CALL:Traffic Stop");

    doTest("T14",
        "2011-021048*3724 ROCK BRIDGE DR NE***CONOVER**ALARM RES*********",
        "ID:2011-021048",
        "ADDR:3724 ROCK BRIDGE DR NE",
        "CITY:CONOVER",
        "CALL:ALARM RES");

    doTest("T15",
        "2011-021037*3983 HOKE ST***CLAREMONT**TRAUMATIC IN*********",
        "ID:2011-021037",
        "ADDR:3983 HOKE ST",
        "CITY:CLAREMONT",
        "CALL:TRAUMATIC IN");
  }
  
  public static void main(String[] args) {
    new NCCatawbaCountyParserTest().generateTests();
  }
}
