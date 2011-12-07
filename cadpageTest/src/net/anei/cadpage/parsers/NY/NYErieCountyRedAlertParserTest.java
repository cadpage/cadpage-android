package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class NYErieCountyRedAlertParserTest extends BaseParserTest {
  
  public NYErieCountyRedAlertParserTest() {
    setParser(new NYErieCountyRedAlertParser(), "ERIE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "*2EMS: 60/M LONG FALL POSSIBLE ARM AND LEG FRACTURE ILS RESPONSE at 3425 OLD LAKEVIEW RD, Hamburg  c/s: ENGEL DR . . 17:31:57\n\n-- \nThis message has bee",
        "CALL:EMS",
        "INFO:60/M LONG FALL POSSIBLE ARM AND LEG FRACTURE ILS RESPONSE",
        "ADDR:3425 OLD LAKEVIEW RD",
        "CITY:Hamburg",
        "X:ENGEL DR",
        "TIME:17:31:57");

    doTest("T2",
        "*2EMS: Male fell has a elbow laceration Cold Response at 25 BUFFALO ST #420, Village of Hamburg  c/s: MAIN ST   O: CREEK BEND HGTS APTS . . 05:16:00\n\n-",
        "CALL:EMS",
        "INFO:Male fell has a elbow laceration Cold Response",
        "ADDR:25 BUFFALO ST",
        "APT:420",
        "CITY:Village of Hamburg",
        "X:MAIN ST",
        "PLACE:CREEK BEND HGTS APTS",
        "TIME:05:16:00");

    doTest("T3",
        "*2EMS: 23 male poss od uncx at 7219 LIEBLER RD, Boston  c/s: COLE RD . . 19:44:01\n\n-- \nThis message has been scanned for viruse",
        "CALL:EMS",
        "INFO:23 male poss od uncx",
        "ADDR:7219 LIEBLER RD",
        "CITY:Boston",
        "X:COLE RD",
        "TIME:19:44:01");

    doTest("T4",
        "*2EMS: 51 female dyspnea paramedic response at 8169 BOSTON STATE RD, Boston  c/s: MAY DR   O: PEOPLE INC . . 21:26:12\n\n-- \nThis",
        "CALL:EMS",
        "INFO:51 female dyspnea paramedic response",
        "ADDR:8169 BOSTON STATE RD",
        "CITY:Boston",
        "X:MAY DR",
        "PLACE:PEOPLE INC",
        "TIME:21:26:12");

    doTest("T5",
        "*2Misc Electrical Problem: TELEPHONE POLE ON FIRE NEAR ROADWAY at 6674 LIEBLER RD, Boston  c/s: BOSTON STATE RD . . 07:50:52\n\n--",
        "CALL:Misc Electrical Problem",
        "INFO:TELEPHONE POLE ON FIRE NEAR ROADWAY",
        "ADDR:6674 LIEBLER RD",
        "CITY:Boston",
        "X:BOSTON STATE RD",
        "TIME:07:50:52");

    doTest("T6",
        "*2EMS: 71 Y/F NOT ALERT  PARAMEDIC RESPONSE   NO MEMBERS ON DUTY  at 8799 ROCKWOOD RD, Boston  c/s: PA/BO LINE . . 13:54:46\n\n-- ",
        "CALL:EMS",
        "INFO:71 Y/F NOT ALERT PARAMEDIC RESPONSE NO MEMBERS ON DUTY",
        "ADDR:8799 ROCKWOOD RD",
        "CITY:Boston",
        "X:PA/BO LINE",
        "TIME:13:54:46");
  }
  
  public static void main(String[] args) {
    new NYErieCountyRedAlertParserTest().generateTests("T1", "CALL INFO ADDR APT CITY X PLACE TIME");
  }

}