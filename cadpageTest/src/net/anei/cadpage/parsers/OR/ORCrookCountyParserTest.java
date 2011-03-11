package net.anei.cadpage.parsers.OR;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OR.ORCrookCountyParser;

import org.junit.Test;


public class ORCrookCountyParserTest extends BaseParserTest {
  
  public ORCrookCountyParserTest() {
    setParser(new ORCrookCountyParser(), "CROOK COUNTY", "OR");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(NEW INCIDENT) 3/10/2011 1003\nEVENT # 1103100020 PFD\nMABD - ABDOMINAL PAIN\nPRIORITY 1 \nLOCATION 2250 SE KYLE RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: HA",
        "ID:1103100020 PFD",
        "CALL:MABD - ABDOMINAL PAIN",
        "ADDR:2250 SE KYLE RD",
        "CITY:PRINEVILLE",
        "INFO:HA");

    doTest("T2",
        "(NEW INCIDENT) 3/11/2011 1003\nEVENT # 1103110010 PFD\nBURN - BURN INFO ONLY\nPRIORITY 1 \nLOCATION 6282 NW GREEN VALLEY RD\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOM",
        "ID:1103110010 PFD",
        "CALL:BURN - BURN INFO ONLY",
        "ADDR:6282 NW GREEN VALLEY RD",
        "CITY:PRINEVILLE");

    doTest("T3",
        "(NEW INCIDENT) 3/11/2011 0903\nEVENT # 1103110009 PFD\nFALARM - FIRE ALARM\nPRIORITY 1 \nLOCATION 210 NE 3RD ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: BACK R\n",
        "ID:1103110009 PFD",
        "CALL:FALARM - FIRE ALARM",
        "ADDR:210 NE 3RD ST",
        "CITY:PRINEVILLE",
        "INFO:BACK R");

    doTest("T4",
        "(NEW INCIDENT) 3/10/2011 0803\nEVENT # 1103100051 PFD\nMUNK - UNKNOWN MEDICAL\nPRIORITY 1 \nLOCATION 587 SE KNIGHT ST\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT:",
        "ID:1103100051 PFD",
        "CALL:MUNK - UNKNOWN MEDICAL",
        "ADDR:587 SE KNIGHT ST",
        "CITY:PRINEVILLE");

    doTest("T5",
        "(NEW INCIDENT) 3/10/2011 0803\nEVENT # 1103100050 PFD\nALARM - ALARM\nPRIORITY 1 \nLOCATION 705 NW 10TH\nCITY PRINEVILLE\nAPT 27\nPREMISE: \nCOMMENT: 90 YOF FALLE",
        "ID:1103100050 PFD",
        "CALL:ALARM - ALARM",
        "ADDR:705 NW 10TH",
        "CITY:PRINEVILLE",
        "APT:27",
        "INFO:90 YOF FALLE");

    doTest("T6",
        "(NEW INCIDENT) 3/10/2011 0703\nEVENT # 1103100047 PFD\nMVA - 1201: 1273 / 1225\nPRIORITY 1 \nLOCATION HWY 27 MP 2\nCITY PRINEVILLE\nAPT \nPREMISE: \nCOMMENT: SUV",
        "ID:1103100047 PFD",
        "CALL:MVA - 1201: 1273 / 1225",
        "ADDR:HWY 27 MP 2",
        "CITY:PRINEVILLE",
        "INFO:SUV");
  }
  
  public static void main(String[] args) {
    new ORCrookCountyParserTest().generateTests("T7");
  }
}