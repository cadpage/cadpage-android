package net.anei.cadpage.parsers.VA;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.VA.VAWaynesboroParser;

import org.junit.Test;


public class VAWaynesboroParserTest extends BaseParserTest {
  
  public VAWaynesboroParserTest() {
    setParser(new VAWaynesboroParser(), "WAYNESBORO", "VA");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "Dispatch2:RESPOND SEIZURES 14 FRONTIER RIDGE CT, AP1302 SARS 1",
        "CALL:SEIZURES",
        "ADDR:14 FRONTIER RIDGE CT",
        "INFO:AP1302 SARS 1");

    doTest("T3",
        "Dispatch:RESPOND - 2ND CALL - CHEST PAIN - 1142 NEW HOPE RD, AP3",
        "CALL:2ND CALL - CHEST PAIN",
        "ADDR:1142 NEW HOPE RD",
        "INFO:AP3");
    
    doTest("T4",
        "Dispatch:RESPOND GENERAL ILLNESS 1429 2ND ST MEDICAL ALARM ACTIVATION",
        "CALL:GENERAL ILLNESS",
        "ADDR:1429 2ND ST",
        "INFO:MEDICAL ALARM ACTIVATION");
    
    doTest("T5",
        "Dispatch:RESPOND 2ND CALL 216 ELKIN CIR CHEST PAINS",
        "CALL:2ND CALL",
        "ADDR:216 ELKIN CIR",
        "INFO:CHEST PAINS");
    
    doTest("T6",
        "Dispatch:RESPOND - 809 GRAYSON AVE - VEH OVER AN EMBANKMENT",
        "CALL:VEH OVER AN EMBANKMENT",
        "ADDR:809 GRAYSON AVE");

    doTest("T7",
        "Dispatch:300 BLK PATTON FARM RD - SQAUD 2 REQUESTED - PRI1 PT WITH ENTRAPMENT - OPERATE COUNTY 1",
        "CALL:SQAUD 2 REQUESTED - PRI1 PT WITH ENTRAPMENT - OPERATE COUNTY 1",
        "ADDR:300 BLK PATTON FARM RD");
    
    doTest("T8",
        "Dispatch2@ci.waynesboro.va.us Msg: Dispatch2:RESPOND 368 WALNUT AVE FALL, BACK INJURY",
        "CALL:FALL BACK INJURY",
        "ADDR:368 WALNUT AVE");

    doTest("T9",
        "Dispatch2@ci.waynesboro.va.us Msg: Dispatch2:RESPOND LIFELINE ACTIVATION - FALL SPRINGDALE APTS 300 S WAYNE AVE APT 12",
        "CALL:LIFELINE ACTIVATION - FALL SPRINGDALE APTS",
        "ADDR:300 S WAYNE AVE",
        "APT:12");
  }
  
  public static void main(String[] args) {
    new VAWaynesboroParserTest().generateTests("T9", "CALL ADDR APT INFO");
  }
}