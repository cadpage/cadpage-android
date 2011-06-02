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

    doTest("T7",
        "([PRNV_911] NEW INCIDENT) 5/3/2011 0805\nEVENT # 1105030076 PFD\nMINJ - INJURIES\nPRIORITY 1 \nLOCATION 1265 NW LAMBERT RD\nCITY PRINEVILL",
        "ID:1105030076 PFD",
        "CALL:MINJ - INJURIES",
        "ADDR:1265 NW LAMBERT RD",
        "CITY:PRINEVILL");

    doTest("T8",
        "([PRNV_911] NEW INCIDENT) 5/3/2011 0705\nEVENT # 1105030067 PFD\nMFALL - FALL\nPRIORITY 1 \nLOCATION 210 SE 5TH ST\nCITY PRINEVILLE\nAPT 13",
        "ID:1105030067 PFD",
        "CALL:MFALL - FALL",
        "ADDR:210 SE 5TH ST",
        "CITY:PRINEVILLE",
        "APT:13");

    doTest("T9",
        "([PRNV_911] NEW INCIDENT) 5/3/2011 0605\nEVENT # 1105030061 PFD\nMFALL - FALL\nPRIORITY 1 \nLOCATION 14493 SE LEE WAY\nCITY PRINEVILLE\nAPT",
        "ID:1105030061 PFD",
        "CALL:MFALL - FALL",
        "ADDR:14493 SE LEE WAY",
        "CITY:PRINEVILLE");

    doTest("T10",
        "S:NEW INCIDENT M:6/2/2011 1006\nEVENT # 1106020016 PFD\nALARM - 1201:1225/1221/1222/...\nPRIORITY 1\nLOCATION 1100 SE LYNN\nCITY PRINEVILLE\nAPT\nPREMISE:\nCOMMENT: SMOKE ALARM//",
        "ID:1106020016 PFD",
        "CALL:ALARM - 1201:1225/1221/1222/...",
        "ADDR:1100 SE LYNN",
        "CITY:PRINEVILLE",
        "INFO:SMOKE ALARM//");
  }
  
  public static void main(String[] args) {
    new ORCrookCountyParserTest().generateTests("T10");
  }
}