package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Camden County, GA
Contact: Donald M. Doyle <dmdoyle@co.camden.ga.us>
Sender: 4046926092

MEDICAL EMERGENCY\n445 MARYFIELD PLANTATION RD CAMDEN COUNTY\nUnits: LS1,T18\nMedical No / Hazards No
LAWNWOOD AVE\n490 S LEE ST KINGSLAND\nUnits: PERSON SICK\nMEDICAL EMERGENCY / TERRY / 912-729-3975 / 531LS3 / Medical No / Hazards Yes\nPH Landmark Comment LS3 D...
TRAUMA EMERGENCY\n4361 HORSE STAMP CHURCH RD WAVERLY\nUnits: LS7\nMedical No / Hazards No

*/

public class GACamdenCountyBParserTest extends BaseParserTest {
  
  public GACamdenCountyBParserTest() {
    setParser(new GACamdenCountyBParser(), "CAMDEN COUNTY", "GA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "MEDICAL EMERGENCY\n445 MARYFIELD PLANTATION RD CAMDEN COUNTY\nUnits: LS1,T18\nMedical No / Hazards No",
        "CALL:MEDICAL EMERGENCY",
        "ADDR:445 MARYFIELD PLANTATION RD",
        "UNIT:LS1,T18",
        "INFO:Medical No / Hazards No");

    doTest("T2",
        "LAWNWOOD AVE\n" +
        "490 S LEE ST KINGSLAND\n" +
        "Units: PERSON SICK\n" +
        "MEDICAL EMERGENCY / TERRY / 912-729-3975 / 531LS3 / Medical No / Hazards Yes\n" +
        "PH Landmark Comment LS3 D...",

        "CALL:LAWNWOOD AVE",
        "ADDR:490 S LEE ST",
        "CITY:KINGSLAND",
        "UNIT:PERSON SICK",
        "INFO:MEDICAL EMERGENCY / TERRY / 912-729-3975 / 531LS3 / Medical No / Hazards Yes / PH Landmark Comment LS3 D...");

    doTest("T3",
        "TRAUMA EMERGENCY\n4361 HORSE STAMP CHURCH RD WAVERLY\nUnits: LS7\nMedical No / Hazards No",
        "CALL:TRAUMA EMERGENCY",
        "ADDR:4361 HORSE STAMP CHURCH RD",
        "CITY:WAVERLY",
        "UNIT:LS7",
        "INFO:Medical No / Hazards No");

  }
  
  public static void main(String[] args) {
    new GACamdenCountyBParserTest().generateTests("T1");
  }
}
