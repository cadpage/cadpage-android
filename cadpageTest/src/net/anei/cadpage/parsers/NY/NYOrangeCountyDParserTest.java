
package net.anei.cadpage.parsers.NY;

                                                                                                                                                                                                                                                                                                                                                                                                           

import net.anei.cadpage.parsers.BaseParserTest;
import org.junit.Test;

/* 
Orange County, NY 
Contact: CodeMessaging

[sCAD] ALS MEDICAL CALL |14 MAPLE AVE |CORNWALL /MFELL DOWN THE STAIRS 12 STEPS 55 YEAR OLD FEMALE CONSCIOUS BREATHING 1)THIS HAPPENED NOW (LESS THAN 6HRS AGO) 2)THE FALL WAS LESS THAN 10FT/ XST: 237 HUDSON ST
[sCAD] VEHICLE FIRE |85 DUNCAN AVE |CORNWALL /CALLER STATED HE CAN SEE A VEHICLE ON FIRE IN FRONT OF LOCATION // |CORNWALL XST: AQUEDUCT LN /29 STILLMAN AVE
[sCAD] AUTOMATIC FIRE ALARM |114 BAY VIEW AVE |CORNWALL /GENERAL FIRE - PREMISE 534-7900 KEY ATTEMPT |CAMP OLMSTED XST: 1 TAFT PL /1 WINTERVIEW LN
[sCAD] ELECTRICAL FIRE |152 HUDSON ST |CORNWALL /ELECTRICAL BURNING SMELL - SEE NO SMOKE OR FIRE - NO DECTECTORS GOING OFF |CORNWALL V XST: 1 BAY VIEW AVE/RIVERSIDE DR
[sCAD] BRUSH FIRE |BAY VIEW AVE&MOUNTAIN HOUSE LN |CORNWALL /BRUSH FIRE IN THE AREA OF THE OVERLOOK |NEWBURGH C message has been scanned for malware.
[sCAD] ALS MEDICAL CALL |19 IDLEWILD PARK DR |CORNWALL /MPOSSIBLE HEART ATTACK AGE UNKNOWN GENDER UNKNOWN CONSCIOUSNESS UNKNOWN BREATHING STATUS UNKNOWN MULTIPLE PATIENTS INVOLVED: 55) 1)THEY ARE C XST: 25 CURIE RD
[sCAD] ALS MEDICAL CALL |374 HUDSON ST |CORNWALL /MFALL UNCONSCIOUS 50 YEAR OLD MALE UNCONSCIOUS BREATHING 1)HIS BREA THING IS NOT COMPLETELY NORMAL 2)THE CALLER IS UNABLE TO ASSESS THEPATI XST: 10 KELLY LN /27 FIRST ST
[sCAD] ALS MEDICAL CALL |7 PARTRIDGE RD |CORNWALL /86YOF//AWAKE AND BREATHING//PT IS ALERT//BREATHING NORMALLY//SUDDEN SPEEC H PROBLEMS//STARTED APPX AN HOUR AGO//NO HISTORY OF STROKE XST: 219 MOUNTAIN RD
[sCAD] AUTOMATIC FIRE ALARM |314 MOUNTAIN RD |CORNWALL /AUTOMATIC ALARM |STORM KING SCHOOL XST: 41 DEER HILL RD /US RTE 9W
[sCAD] AUTOMATIC FIRE ALARM |146 BAY VIEW AVE |CORNWALL /BUSINESS - KIRK WOOD HOUSE - ZONE 5 THIRD FLOOR - NO CONTACT - 845-534-39 76 XST: 1 TAFT PL /1 WINTERVIEW LN
[sCAD] CARBON MONOXIDE DETR APT: 9 |289 HUDSON ST |CORNWALL /CO ALARM SOUNDED |CORNWALL V XST: 5 COLUMBUS AVE /7 COLONIAL PL


*/

public class NYOrangeCountyDParserTest extends BaseParserTest {
  
  public NYOrangeCountyDParserTest() {
    setParser(new NYOrangeCountyDParser(), "ORANGE COUNTY", "NY");
  }
  
  @Test
  public void testParser() {



    doTest("T1",
        "[sCAD] ALS MEDICAL CALL |14 MAPLE AVE |CORNWALL /MFELL DOWN THE STAIRS 12 STEPS 55 YEAR OLD FEMALE CONSCIOUS BREATHING 1)THIS HAPPENED NOW (LESS THAN 6HRS AGO) 2)THE FALL WAS LESS THAN 10FT/ XST: 237 HUDSON ST",
        "CALL:ALS MEDICAL CALL",
        "ADDR:14 MAPLE AVE",
        "CITY:CORNWALL",
        "INFO:MFELL DOWN THE STAIRS 12 STEPS 55 YEAR OLD FEMALE CONSCIOUS BREATHING 1)THIS HAPPENED NOW (LESS THAN 6HRS AGO) 2)THE FALL WAS LESS THAN 10FT/",
        "X:237 HUDSON ST");

    doTest("T2",
        "[sCAD] VEHICLE FIRE |85 DUNCAN AVE |CORNWALL /CALLER STATED HE CAN SEE A VEHICLE ON FIRE IN FRONT OF LOCATION // |CORNWALL XST: AQUEDUCT LN /29 STILLMAN AVE",
        "CALL:VEHICLE FIRE",
        "ADDR:85 DUNCAN AVE",
        "CITY:CORNWALL",
        "INFO:CALLER STATED HE CAN SEE A VEHICLE ON FIRE IN FRONT OF LOCATION //",
        "X:AQUEDUCT LN /29 STILLMAN AVE");

    doTest("T3",
        "[sCAD] AUTOMATIC FIRE ALARM |114 BAY VIEW AVE |CORNWALL /GENERAL FIRE - PREMISE 534-7900 KEY ATTEMPT |CAMP OLMSTED XST: 1 TAFT PL /1 WINTERVIEW LN",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:114 BAY VIEW AVE",
        "CITY:CORNWALL",
        "INFO:GENERAL FIRE - PREMISE 534-7900 KEY ATTEMPT",
        "X:1 TAFT PL /1 WINTERVIEW LN");

    doTest("T4",
        "[sCAD] ELECTRICAL FIRE |152 HUDSON ST |CORNWALL /ELECTRICAL BURNING SMELL - SEE NO SMOKE OR FIRE - NO DECTECTORS GOING OFF |CORNWALL V XST: 1 BAY VIEW AVE/RIVERSIDE DR",
        "CALL:ELECTRICAL FIRE",
        "ADDR:152 HUDSON ST",
        "CITY:CORNWALL",
        "INFO:ELECTRICAL BURNING SMELL - SEE NO SMOKE OR FIRE - NO DECTECTORS GOING OFF",
        "X:1 BAY VIEW AVE/RIVERSIDE DR");

    doTest("T5",
        "[sCAD] BRUSH FIRE |BAY VIEW AVE&MOUNTAIN HOUSE LN |CORNWALL /BRUSH FIRE IN THE AREA OF THE OVERLOOK |NEWBURGH C message has been scanned for malware.",
        "CALL:BRUSH FIRE",
        "ADDR:BAY VIEW AVE & MOUNTAIN HOUSE LN",
        "CITY:CORNWALL",
        "INFO:BRUSH FIRE IN THE AREA OF THE OVERLOOK");

    doTest("T6",
        "[sCAD] ALS MEDICAL CALL |19 IDLEWILD PARK DR |CORNWALL /MPOSSIBLE HEART ATTACK AGE UNKNOWN GENDER UNKNOWN CONSCIOUSNESS UNKNOWN BREATHING STATUS UNKNOWN MULTIPLE PATIENTS INVOLVED: 55) 1)THEY ARE C XST: 25 CURIE RD",
        "CALL:ALS MEDICAL CALL",
        "ADDR:19 IDLEWILD PARK DR",
        "CITY:CORNWALL",
        "INFO:MPOSSIBLE HEART ATTACK AGE UNKNOWN GENDER UNKNOWN CONSCIOUSNESS UNKNOWN BREATHING STATUS UNKNOWN MULTIPLE PATIENTS INVOLVED: 55) 1)THEY ARE C",
        "X:25 CURIE RD");

    doTest("T7",
        "[sCAD] ALS MEDICAL CALL |374 HUDSON ST |CORNWALL /MFALL UNCONSCIOUS 50 YEAR OLD MALE UNCONSCIOUS BREATHING 1)HIS BREA THING IS NOT COMPLETELY NORMAL 2)THE CALLER IS UNABLE TO ASSESS THEPATI XST: 10 KELLY LN /27 FIRST ST",
        "CALL:ALS MEDICAL CALL",
        "ADDR:374 HUDSON ST",
        "CITY:CORNWALL",
        "INFO:MFALL UNCONSCIOUS 50 YEAR OLD MALE UNCONSCIOUS BREATHING 1)HIS BREA THING IS NOT COMPLETELY NORMAL 2)THE CALLER IS UNABLE TO ASSESS THEPATI",
        "X:10 KELLY LN /27 FIRST ST");

    doTest("T8",
        "[sCAD] ALS MEDICAL CALL |7 PARTRIDGE RD |CORNWALL /86YOF//AWAKE AND BREATHING//PT IS ALERT//BREATHING NORMALLY//SUDDEN SPEEC H PROBLEMS//STARTED APPX AN HOUR AGO//NO HISTORY OF STROKE XST: 219 MOUNTAIN RD",
        "CALL:ALS MEDICAL CALL",
        "ADDR:7 PARTRIDGE RD",
        "CITY:CORNWALL",
        "INFO:86YOF//AWAKE AND BREATHING//PT IS ALERT//BREATHING NORMALLY//SUDDEN SPEEC H PROBLEMS//STARTED APPX AN HOUR AGO//NO HISTORY OF STROKE",
        "X:219 MOUNTAIN RD");

    doTest("T9",
        "[sCAD] AUTOMATIC FIRE ALARM |314 MOUNTAIN RD |CORNWALL /AUTOMATIC ALARM |STORM KING SCHOOL XST: 41 DEER HILL RD /US RTE 9W",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:314 MOUNTAIN RD",
        "CITY:CORNWALL",
        "INFO:AUTOMATIC ALARM",
        "X:41 DEER HILL RD /US RTE 9W");

    doTest("T10",
        "[sCAD] AUTOMATIC FIRE ALARM |146 BAY VIEW AVE |CORNWALL /BUSINESS - KIRK WOOD HOUSE - ZONE 5 THIRD FLOOR - NO CONTACT - 845-534-39 76 XST: 1 TAFT PL /1 WINTERVIEW LN",
        "CALL:AUTOMATIC FIRE ALARM",
        "ADDR:146 BAY VIEW AVE",
        "CITY:CORNWALL",
        "INFO:BUSINESS - KIRK WOOD HOUSE - ZONE 5 THIRD FLOOR - NO CONTACT - 845-534-39 76",
        "X:1 TAFT PL /1 WINTERVIEW LN");

    doTest("T11",
        "[sCAD] CARBON MONOXIDE DETR APT: 9 |289 HUDSON ST |CORNWALL /CO ALARM SOUNDED |CORNWALL V XST: 5 COLUMBUS AVE /7 COLONIAL PL",
        "CALL:CARBON MONOXIDE DETR APT: 9",
        "ADDR:289 HUDSON ST",
        "CITY:CORNWALL",
        "INFO:CO ALARM SOUNDED",
        "X:5 COLUMBUS AVE /7 COLONIAL PL");
    
  }
  
  public static void main(String[] args) {
    new NYOrangeCountyDParserTest().generateTests("T1");
  }
}
  