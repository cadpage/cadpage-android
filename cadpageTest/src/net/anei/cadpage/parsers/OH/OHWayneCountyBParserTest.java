package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHWayneCountyBParserTest extends BaseParserTest {
  
  public OHWayneCountyBParserTest() {
    setParser(new OHWayneCountyBParser(), "WAYNE COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Dispatch Message) TRAFFIC DETAIL/COMPLAINT  \n94 BAUMGARTNER RD \nBIG TRUCK WITH BROKEN DRIVE TRAIN ADV NEEDING TRAFFIC CONTROL  \nON 94 JUST SOUTH OF BAUMGARTN",
        "CALL:TRAFFIC DETAIL/COMPLAINT",
        "ADDR:94 BAUMGARTNER RD",
        "INFO:BIG TRUCK WITH BROKEN DRIVE TRAIN ADV NEEDING TRAFFIC CONTROL / ON 94 JUST SOUTH OF BAUMGARTN");

    doTest("T2",
        "(Dispatch Message) SQUAD: CARDIAC/CHEST PAIN \n110 WEST LEBANON RD N 40\n33 YEAR OLD MALE CHEST PAINS\nHAS MITROVALVE PROLASPE",
        "CALL:SQUAD: CARDIAC/CHEST PAIN",
        "ADDR:110 WEST LEBANON RD N 40",
        "INFO:33 YEAR OLD MALE CHEST PAINS / HAS MITROVALVE PROLASPE");

    doTest("T3",
        "(Dispatch Message) FIRE: GRASS/TREES/BRUSH   \nHACKETT RD KANSAS RD S \nFIELD FIRE AT S. KANSAS AND HACKETT.",
        "CALL:FIRE: GRASS/TREES/BRUSH",
        "ADDR:HACKETT RD & KANSAS RD S",
        "INFO:FIELD FIRE AT S. KANSAS AND HACKETT.");

    doTest("T4",
        "(Dispatch Message) MISCELLANEOUS             \n  \nTUESD NOV 15TH AT 1800 HRS SHARP, A SHORT WORK DETAIL TO GET ENGINE 71 READY TO GO TO TWINSBURG TUES EVENING",
        "CALL:MISCELLANEOUS",
        "INFO:TUESD NOV 15TH AT 1800 HRS SHARP, A SHORT WORK DETAIL TO GET ENGINE 71 READY TO GO TO TWINSBURG TUES EVENING");

    doTest("T5",
        "(Dispatch Message) SQUAD: FALLS              \n14765 LINCOLN WAY E \n911 CALL LUCY INDORF 89 YOF FALL VICTIM - LIFT ASSIST - NO INJURY- FD HAS KEY\nCROSS KURZEN",
        "CALL:SQUAD: FALLS",
        "ADDR:14765 LINCOLN WAY E",
        "INFO:911 CALL LUCY INDORF 89 YOF FALL VICTIM - LIFT ASSIST - NO INJURY- FD HAS KEY / CROSS KURZEN");

    doTest("T6",
        "(Dispatch Message) SQUAD: FRACTURES          \n22 KING \n50 YR OLD MALE, BROKEN LEG",
        "CALL:SQUAD: FRACTURES",
        "ADDR:22 KING",
        "INFO:50 YR OLD MALE, BROKEN LEG");

    doTest("T7",
        "(Dispatch Message) SQUAD: (FREE TEXT)        \n1 ARLINGTON CT 1\n51 YOM SEVERE HEADACHE  BLDG 3",
        "CALL:SQUAD: (FREE TEXT)",
        "ADDR:1 ARLINGTON CT 1",
        "INFO:51 YOM SEVERE HEADACHE  BLDG 3");

    doTest("T8",
        "(Dispatch Message) SQUAD: (FREE TEXT)        \n15028 OLD LINCOLN WAY \nPATIENT PULLED TRAC OUT NEEDS TO GO TO DUNLAP ER, USE BACK DOOR DOGWOOD",
        "CALL:SQUAD: (FREE TEXT)",
        "ADDR:15028 OLD LINCOLN WAY",
        "INFO:PATIENT PULLED TRAC OUT NEEDS TO GO TO DUNLAP ER, USE BACK DOOR DOGWOOD");
  }
  
  @Test
  public void testJackieElkins() {

    doTest("T1",
        "(Dispatch Message) MUTUAL AID REQUESTED BY US\r961 ROSELAND \rNORTH LAWRENCE REQ RIT TEAM FOR STRUCTURE FIRE, NORTH OF 172, EAST OF KENYON",
        "CALL:MUTUAL AID REQUESTED BY US",
        "ADDR:961 ROSELAND",
        "INFO:NORTH LAWRENCE REQ RIT TEAM FOR STRUCTURE FIRE, NORTH OF 172, EAST OF KENYON",
        "CITY:NORTH LAWRENCE");

  }
  
  public static void main(String[] args) {
    new OHWayneCountyBParserTest().generateTests("T1");
  }
}