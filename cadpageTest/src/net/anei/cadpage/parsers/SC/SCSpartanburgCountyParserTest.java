package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Spartanburg County, SC
Contact: Richard Brown <firefighterjacob@gmail.com>
Sender: 911info@spartanburgcounty.org
System: Motorola CAD premeire

GLFD - CF/14072 TYP: ..FUEL SPILL........ AD: DOGWOOD CLUB RD&S PINE ST CMT1: <<< FUEL SPILL >>> CMT2: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE
GLFD - CF/13375 TYP: COMMERC FIRE ALARM. AD: 2720 COUNTRY CLUB RD LOC: PARK PLACE ASSISTED LIVING CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE
GLFD - CF/13440 TYP: FIRE ALARM(RESDENTL) AD: 200 JOHNSON LAKE RD LOC: MURF/RESD/5831013 CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES &
GLFD - CF/09993 TYP: MVA W/INJURY..... AD: CLIFTON GLENDALE RD&GLENDALE A CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS >>> CMT2
GLFD - CF/10647 TYP: BRUSH FIRE......... AD: 170 FRETWELL RD CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS >>> CMT2: <<< BRUSH,

Contact: Andrew Couchey <abcouchey@gmail.com>
BSFD - CF/20546 TYP: COMMERC FIRE ALARM. AD: 2251 OLD FURNACE RD LOC: BOILING SPRINGS HIGH CMT1: << BOILING SPRINGS FIRE DISTRICT >> CMT2: <<< COMMERC

Contact: Hector Cardona <krzcolombian@gmail.com>
(Email Copy from Emergin Integration Suite) TRFD - CF/27137 TYP: ..SUICIDE THREAT ..` AD: 326 STODDARD DR CMT1: <<< SUICIDE THREAT (NOT ATTEMPTED) >>>
(Email Copy from Emergin Integration Suite) TRFD - CF/27162 TYP: NON-INJURY MVA... AD: CANADY RD&INMAN RD CMT1: <<< NON INJURY VEHICLE ACCIDENT >>> CM

Contact: Dave <shaftoa@bellsouth.net>
Sender: 911info@spartanburgcounty.org
1 of 2\nFRM:911info@spartanburgcounty.org\nMSG:NSFD - CF/24117 TYP: CHECK A SMOKE DETECT AD: 381 STILL WATER CIR CMT1: <<< CHECK SMOKE DETECTOR\n(Con't) 2 of 2\n>>> CMT2: CALLERS SMK DETECTORS ARE GOIN OFF CALLER DONT SEE OR(End)

Contact: Matthew Garrett <matthewgarrett@ymail.com>
Sender: 911info@spartanburgcounty.org
REFD - CF/24948 TYP: ..VEHICLE FIRE...... AD: 6100 I85 S CMT1: <<< VEHICLE ON FIRE >>> CMT2: OLDER 2 DOOR SEDAN GREY IN COLOR TIME: 14:51

Contact: Derrick Miller <williemiller43@gmail.com>
Sender: 911info@spartanburgcounty.org
 1 of 2\nFRM:911info@spartanburgcounty.org\nMSG:STA32 - CF/026604 TYP: ..ABDOMINAL PAINS..' AD: 3105 MERIDIAN RIVER RUN LOC: RIVER RUN APT CMT1:\n(Con't) 2 of 2\n<<GATE CODE FOR EMERGENCY VEHICLES RIVER RUN APTS = #7474 CMT2:(End)

 */

public class SCSpartanburgCountyParserTest extends BaseParserTest {
  
  public SCSpartanburgCountyParserTest() {
    setParser(new SCSpartanburgCountyParser(), "SPARTANBURG COUNTY", "SC");
  }
  
  @Test
  public void testGLFDParser() {

    doTest("T1",
        "GLFD - CF/14072 TYP: ..FUEL SPILL........ AD: DOGWOOD CLUB RD&S PINE ST CMT1: <<< FUEL SPILL >>> CMT2: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE",
        "SRC:GLFD",
        "ID:CF/14072",
        "CALL:FUEL SPILL",
        "ADDR:DOGWOOD CLUB RD & S PINE ST",
        "INFO:FUEL SPILL / SEND GLENDALE AND PACOLET ON ALL STRUCTURE");

    doTest("T2",
        "GLFD - CF/13375 TYP: COMMERC FIRE ALARM. AD: 2720 COUNTRY CLUB RD LOC: PARK PLACE ASSISTED LIVING CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE",
        "SRC:GLFD",
        "ID:CF/13375",
        "CALL:COMMERC FIRE ALARM",
        "ADDR:2720 COUNTRY CLUB RD",
        "PLACE:PARK PLACE ASSISTED LIVING",
        "INFO:SEND GLENDALE AND PACOLET ON ALL STRUCTURE");

    doTest("T3",
        "GLFD - CF/13440 TYP: FIRE ALARM(RESDENTL) AD: 200 JOHNSON LAKE RD LOC: MURF/RESD/5831013 CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES &",
        "SRC:GLFD",
        "ID:CF/13440",
        "CALL:FIRE ALARM(RESDENTL)",
        "ADDR:200 JOHNSON LAKE RD",
        "PLACE:MURF/RESD/5831013",
        "INFO:SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES &");

    doTest("T4",
        "GLFD - CF/09993 TYP: MVA W/INJURY..... AD: CLIFTON GLENDALE RD&GLENDALE A CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS >>> CMT2",
        "SRC:GLFD",
        "ID:CF/09993",
        "CALL:MVA W/INJURY",
        "ADDR:CLIFTON GLENDALE RD & GLENDALE A",
        "INFO:SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS");

    doTest("T5",
        "GLFD - CF/10647 TYP: BRUSH FIRE......... AD: 170 FRETWELL RD CMT1: <<< SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS >>> CMT2: <<< BRUSH,",
        "SRC:GLFD",
        "ID:CF/10647",
        "CALL:BRUSH FIRE",
        "ADDR:170 FRETWELL RD",
        "INFO:SEND GLENDALE AND PACOLET ON ALL STRUCTURE FIRES & ALARMS / BRUSH,");
  }
  
  @Test
  public void testBSFDParser() {

    doTest("T1",
        "BSFD - CF/20546 TYP: COMMERC FIRE ALARM. AD: 2251 OLD FURNACE RD LOC: BOILING SPRINGS HIGH CMT1: << BOILING SPRINGS FIRE DISTRICT >> CMT2: <<< COMMERC",
        "SRC:BSFD",
        "ID:CF/20546",
        "CALL:COMMERC FIRE ALARM",
        "ADDR:2251 OLD FURNACE RD",
        "PLACE:BOILING SPRINGS HIGH",
        "INFO:BOILING SPRINGS FIRE DISTRICT / COMMERC");
  }
  
  public void testTRFDParser() {

    doTest("T1",
        "(Email Copy from Emergin Integration Suite) TRFD - CF/27137 TYP: ..SUICIDE THREAT ..` AD: 326 STODDARD DR CMT1: <<< SUICIDE THREAT (NOT ATTEMPTED) >>>",
        "SRC:TRFD",
        "ID:CF/27137",
        "CALL:SUICIDE THREAT ..`",
        "ADDR:326 STODDARD DR",
        "INFO:SUICIDE THREAT (NOT ATTEMPTED)");

    doTest("T2",
        "(Email Copy from Emergin Integration Suite) TRFD - CF/27162 TYP: NON-INJURY MVA... AD: CANADY RD&INMAN RD CMT1: <<< NON INJURY VEHICLE ACCIDENT >>> CM",
        "SRC:TRFD",
        "ID:CF/27162",
        "CALL:NON-INJURY MVA",
        "ADDR:CANADY RD & INMAN RD",
        "INFO:NON INJURY VEHICLE ACCIDENT");

  }
  
  @Test
  public void testNSFD() {

    doTest("T1",
        "1 of 2\n" +
        "FRM:911info@spartanburgcounty.org\n" +
        "MSG:NSFD - CF/24117 TYP: CHECK A SMOKE DETECT AD: 381 STILL WATER CIR CMT1: <<< CHECK SMOKE DETECTOR\n" +
        "(Con't) 2 of 2\n" +
        ">>> CMT2: CALLERS SMK DETECTORS ARE GOIN OFF CALLER DONT SEE OR(End)",

        "SRC:NSFD",
        "ID:CF/24117",
        "CALL:CHECK A SMOKE DETECT",
        "ADDR:381 STILL WATER CIR",
        "INFO:CHECK SMOKE DETECTOR / CALLERS SMK DETECTORS ARE GOIN OFF CALLER DONT SEE OR");

  }
  
  @Test
  public void testREFD() {
    doTest("T1",
        "REFD - CF/24948 TYP: ..VEHICLE FIRE...... AD: 6100 I85 S CMT1: <<< VEHICLE ON FIRE >>> CMT2: OLDER 2 DOOR SEDAN GREY IN COLOR TIME: 14:51",
        "SRC:REFD",
        "ID:CF/24948",
        "CALL:VEHICLE FIRE",
        "ADDR:6100 I85 S",
        "MADDR:6100 I 85 S",
        "INFO:VEHICLE ON FIRE / OLDER 2 DOOR SEDAN GREY IN COLOR",
        "TIME:14:51");

  }
  
  @Test
  public void testDerrickMiller() {

    doTest("T1",
        " 1 of 2\n" +
        "FRM:911info@spartanburgcounty.org\n" +
        "MSG:STA32 - CF/026604 TYP: ..ABDOMINAL PAINS..' AD: 3105 MERIDIAN RIVER RUN LOC: RIVER RUN APT CMT1:\n" +
        "(Con't) 2 of 2\n" +
        "<<GATE CODE FOR EMERGENCY VEHICLES RIVER RUN APTS = #7474 CMT2:(End)",

        "SRC:STA32",
        "ID:CF/026604",
        "CALL:ABDOMINAL PAINS..'",
        "ADDR:3105 MERIDIAN RIVER RUN",
        "PLACE:RIVER RUN APT",
        "INFO:GATE CODE FOR EMERGENCY VEHICLES RIVER RUN APTS = #7474");

  }
  
  public static void main(String[] args) {
    new SCSpartanburgCountyParserTest().generateTests("T1");
  }
}