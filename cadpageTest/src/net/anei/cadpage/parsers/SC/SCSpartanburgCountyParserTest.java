package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


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
  
  public static void main(String[] args) {
    new SCSpartanburgCountyParserTest().generateTests("T1");
  }
}