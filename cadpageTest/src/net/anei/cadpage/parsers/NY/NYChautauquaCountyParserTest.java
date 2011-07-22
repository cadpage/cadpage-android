package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYChautauquaCountyParserTest extends BaseParserTest {
  
  public NYChautauquaCountyParserTest() {
    setParser(new NYChautauquaCountyParser(), "CHAUTAUQUA COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 07:06 *EMS CALL ; 3735 WESTMAN RD ; C/T/V Ellery ; BRET SANTILLI ; 17 yr female seizure  ; A441",
        "CALL:EMS CALL",
        "ADDR:3735 WESTMAN RD",
        "CITY:Ellery",
        "NAME:BRET SANTILLI",
        "INFO:17 yr female seizure",
        "UNIT:A441");

    doTest("T2",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 00:44 *EMS CALL ; 170 HIGH ACRES MHP ; C/T/V Ellery ; DONALD SCHAUMAN ; hip pain and back pain ; A441 E301 E302 T301 A301 R302 E373 E383 in Sun Room Zone 27 ;",
        "CALL:EMS CALL",
        "ADDR:170 HIGH ACRES MHP",
        "CITY:Ellery",
        "NAME:DONALD SCHAUMAN",
        "INFO:hip pain and back pain / in Sun Room Zone 27",
        "UNIT:A441 E301 E302 T301 A301 R302 E373 E383");

    doTest("T3",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 12:18 *STRUCTURE FIRE -3000 ; 5457 BLY HILL RD ; C/T/V North Harmony ; Richard Robinson ; Fire alarm A301 R302 A281",
        "CALL:STRUCTURE FIRE -3000",
        "ADDR:5457 BLY HILL RD",
        "CITY:North Harmony",
        "NAME:Richard Robinson",
        "INFO:Fire alarm A301 R302 A281");

    doTest("T4",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 19:43 *EMS CALL ; 3246 PANAMA STEDMAN RD ; C/T/V North Harmony ; Gregory Mcchesney ; MALE INCOHERENT / ELEV BP AND TEMP ;",
        "CALL:EMS CALL",
        "ADDR:3246 PANAMA STEDMAN RD",
        "CITY:North Harmony",
        "NAME:Gregory Mcchesney",
        "INFO:MALE INCOHERENT / ELEV BP AND TEMP");

    doTest("T5",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 12:06 *EMS CALL ; 5410 MEADOWS RD ; C/T/V Chautauqua ; C MERRITT ; 73 yoa fm shortness in breath gene ELLE M10 MAPL",
        "CALL:EMS CALL",
        "ADDR:5410 MEADOWS RD",
        "CITY:Chautauqua",
        "NAME:C MERRITT",
        "INFO:73 yoa fm shortness in breath gene ELLE M10 MAPL");

    doTest("T6",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 18:46 *EMS CALL ; 4412 DUTCH HOLLOW RD ; C/T/V Ellery ; FLOYD DELLAHOY ; MALE - DIFF BREATHING ; A481",
        "CALL:EMS CALL",
        "ADDR:4412 DUTCH HOLLOW RD",
        "CITY:Ellery",
        "NAME:FLOYD DELLAHOY",
        "INFO:MALE - DIFF BREATHING",
        "UNIT:A481");

    doTest("T7",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 14:05 *EMS CALL ; 4900 RT430 lot 1 ; C/T/V Ellery ; ; ; A481",
        "CALL:EMS CALL",
        "ADDR:4900 RT430 lot 1",
        "CITY:Ellery",
        "UNIT:A481");

    doTest("T8",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 17:10 *EMS CALL ; 2916 BENTLEY AVE ; C/T/V Ellicott ; ; FEMALE - DIFF BREATHING ; FLUV A441",
        "CALL:EMS CALL",
        "ADDR:2916 BENTLEY AVE",
        "CITY:Ellicott",
        "INFO:FEMALE - DIFF BREATHING",
        "UNIT:FLUV A441");

    doTest("T9",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 17:24 *EMS CALL ; 5011 STONELEDGE RD ; C/T/V North Harmony ; ; MALE - FALLEN, POSS STROKE ; A301 R30",
        "CALL:EMS CALL",
        "ADDR:5011 STONELEDGE RD",
        "CITY:North Harmony",
        "INFO:MALE - FALLEN, POSS STROKE",
        "UNIT:A301 R30");

    doTest("T10",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 11:27 *STRUCTURE FIRE -3000 ; 1136 HOAG RD ; C/T/V Harmony ; RICK NORRIS ; house fire ;",
        "CALL:STRUCTURE FIRE -3000",
        "ADDR:1136 HOAG RD",
        "CITY:Harmony",
        "NAME:RICK NORRIS",
        "INFO:house fire");

    doTest("T11",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 18:36 *SINGLE COMPANY ; 27 E  MAIN ST ; C/T/V Panama ; ; ASHVILLE ONE ENGINR STAND BY AT PANAMA FD  ;",
        "CALL:SINGLE COMPANY",
        "ADDR:27 E MAIN ST",
        "CITY:Panama",
        "INFO:ASHVILLE ONE ENGINR STAND BY AT PANAMA FD");

    doTest("T12",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 15:18 *EMS CALL ; S  MAPLE AVE GLEASON RD ; C/T/V Busti ; ; ; A301 R302",
        "CALL:EMS CALL",
        "ADDR:S MAPLE AVE & GLEASON RD",
        "CITY:Busti",
        "UNIT:A301 R302");

    doTest("T13",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 00:15 *EMS CALL ; 28 LIBERTY ST ; C/T/V Bemus Point ; CHARLES CROSSLEY ; f/70 back pains and leg pain",
        "CALL:EMS CALL",
        "ADDR:28 LIBERTY ST",
        "CITY:Bemus Point",
        "NAME:CHARLES CROSSLEY",
        "INFO:f/70 back pains and leg pain");

    doTest("T14",
        "CHAUTAUQUA_COUNTY_SHERIFF (MSP CAD) 15:11 *SINGLE COMPANY ; BEMUS ELLERY RD MAHANNA RD ; C/T/V Ellery ; Philip Erickson ; live electric line across the road.",
        "CALL:SINGLE COMPANY",
        "ADDR:BEMUS ELLERY RD & MAHANNA RD",
        "CITY:Ellery",
        "NAME:Philip Erickson",
        "INFO:live electric line across the road.");
 }
  
  public static void main(String[] args) {
    new NYChautauquaCountyParserTest().generateTests("T1");
  }
}