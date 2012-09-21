package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHAshtabulaCountyParserTest extends BaseParserTest {
  
  public OHAshtabulaCountyParserTest() {
    setParser(new OHAshtabulaCountyParser(), "ASHTABULA COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "FIRE, 320 EAST MAIN ST ORWELL, EASTON RD,ORWELL//LEFFINGWELL DR,ORWELL, HEAVY SMOKE COMING FROM A RESIDENCE BEHIND MIDWAY ",
        "CALL:FIRE",
        "ADDR:320 EAST MAIN ST",
        "CITY:ORWELL",
        "X:EASTON RD & LEFFINGWELL DR",
        "INFO:HEAVY SMOKE COMING FROM A RESIDENCE BEHIND MIDWAY");

    doTest("T2",
        "FIRE, 4396 MONTGOMERY RD WINDSOR TWP, MONTGOMERY RD,ORWELL TWP//WINDSOR-MECHANICSVILLE RD,WINDSOR TWP, HEAVY SMOKE IN THE AREA OF THIS LOCATION THAT",
        "CALL:FIRE",
        "ADDR:4396 MONTGOMERY RD",
        "CITY:WINDSOR TWP",
        "X:MONTGOMERY RD & WINDSOR-MECHANICSVILLE RD",
        "INFO:HEAVY SMOKE IN THE AREA OF THIS LOCATION THAT");

    doTest("T3",
        "FIRE, 3595 US RT 322 ORWELL TWP, PARKER RD,ORWELL TWP//, LARGE BON FIRE IN A FIELD ACROSS THE STREET FROM THIS ADDRESS, APPEARS UNATTENDED, NEAR A S",
        "CALL:FIRE",
        "ADDR:3595 US RT 322",
        "MADDR:3595 US 322",  // Not mapping, reported to Google
        "CITY:ORWELL TWP",
        "X:PARKER RD",
        "INFO:LARGE BON FIRE IN A FIELD ACROSS THE STREET FROM THIS ADDRESS, APPEARS UNATTENDED, NEAR A S");

    doTest("T4",
        "INJURY CRASH, 862 US RT 322  W COLEBROOK TWP, FEE RD,COLEBROOK TWP//ST RT 46,COLEBROOK TWP, 1 VEHICLE MVA, DRIVER IS IN THE DITCH, UNRESPONSIVE, IS ",
        "CALL:INJURY CRASH",
        "ADDR:862 US RT 322 W",
        "MADDR:862 US 322 W",
        "CITY:COLEBROOK TWP",
        "X:FEE RD & ST RT 46",
        "INFO:1 VEHICLE MVA, DRIVER IS IN THE DITCH, UNRESPONSIVE, IS");

    doTest("T5",
        "FIRE, 7437 ST RT 45 ORWELL TWP, HAGUE RD,ORWELL TWP//NEW HUDSON RD,ORWELL TWP, SOMEONE BURNING TRASH SOUTH OF THIS LOCATION",
        "CALL:FIRE",
        "ADDR:7437 ST RT 45",
        "MADDR:7437 OH 45",
        "CITY:ORWELL TWP",
        "X:HAGUE RD & NEW HUDSON RD",
        "INFO:SOMEONE BURNING TRASH SOUTH OF THIS LOCATION");

    doTest("T6",
        "FIRE, 6091 ST RT 86 WINDSOR TWP, HYDE RD,WINDSOR TWP//STONEVILLE RD,WINDSOR TWP, POSSIBLE FIELD FIRE",
        "CALL:FIRE",
        "ADDR:6091 ST RT 86",
        "MADDR:6091 OH 86",
        "CITY:WINDSOR TWP",
        "X:HYDE RD & STONEVILLE RD",
        "INFO:POSSIBLE FIELD FIRE");

    doTest("T7",
        "ALARM DROP, 8789 ST RT 45 ORWELL TWP, WATERS RD,ORWELL TWP//WINTERS RD,ORWELL TWP, GENERAL FIRE ALARM, KINGS STORAGE GARAGE",
        "CALL:ALARM DROP",
        "ADDR:8789 ST RT 45",
        "MADDR:8789 OH 45",  // Google just isn't finding this
        "CITY:ORWELL TWP",
        "X:WATERS RD & WINTERS RD",
        "INFO:GENERAL FIRE ALARM, KINGS STORAGE GARAGE");

    doTest("T8",
        "FIRE, 6410 US RT 322 WINDSOR TWP, COX RD,WINDSOR TWP//WISWELL RD,WINDSOR TWP, BRUSH FIRE APPROX 100 FEET OFF THE ROAD",
        "CALL:FIRE",
        "ADDR:6410 US RT 322",
        "MADDR:6410 US 322",  // Google not mapping
        "CITY:WINDSOR TWP",
        "X:COX RD & WISWELL RD",
        "INFO:BRUSH FIRE APPROX 100 FEET OFF THE ROAD");

    doTest("T9",
        "FIRE,  ST RT 46/WINDSOR RD W COLEBROOK TWP, //,",
        "CALL:FIRE",
        "ADDR:ST RT 46 & WINDSOR RD W",
        "MADDR:OH 46 & WINDSOR RD W",
        "CITY:COLEBROOK TWP");
  
  }
  
  public static void main(String[] args) {
    new OHAshtabulaCountyParserTest().generateTests("T1");
  }
}