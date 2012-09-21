package net.anei.cadpage.parsers.PA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class PAMontgomeryCountyDParserTest extends BaseParserTest {
  
  public PAMontgomeryCountyDParserTest() {
    setParser(new PAMontgomeryCountyDParser(), "MONTGOMERY COUNTY", "PA");
  }
  
  @Test
  public void testActive911A() {

    doTest("T1",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1214933\n" +
        "Incident Received: 07-03-2012  19:35:46              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n" +
        "BALA POINT\n" +
        "111 PRESIDENTIAL BLVD  Apt# 2\n" +
        "Cross Street: E CITY AVE AND GLEN RD\n\n" +
        "Map:    Plan:   ADC: 3479F9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:35  CLEAR CHANNEL ALARM\n" +
        "19:35  W/N\n" +
        "19:35  610-667-7150\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1214933",
        "DATE:07-03-2012",
        "TIME:19:35:46",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "PLACE:BALA POINT",
        "ADDR:111 PRESIDENTIAL BLVD",
        "APT:2",
        "X:E CITY AVE AND GLEN RD",
        "BOX:3479F9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T2",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215078\n" +
        "Incident Received: 07-05-2012  19:44:55              Call Source:  10DIGIT\n\n" +
        "CODE: FIN-FIRE INVESTIGATION \n" +
        "JOE'S CRAB SHACK\n" +
        "555 CITY AVE E\n" +
        "Cross Street: MONUMENT RD AND PRESIDENTIAL BLVD\n\n" +
        "Map:    Plan:   ADC: 3479G9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:44  SPECIAL ADDRESS COMMENT:\n" +
        "19:44  VALID SUITES AT LOCATION - REVERIFY\n" +
        "19:44  DIRECTLY ACROSS FROM TGI FRIDAYS\n" +
        "19:44  SPECIAL ADDRESS COMMENT:\n" +
        "19:44  VALID SUITES AT LOCATION - REVERIFY\n" +
        "19:44  SPECIAL ADDRESS COMMENT:\n" +
        "19:44  VALID SUITES AT LOCATION - REVERIFY\n" +
        "19:44  STATED MANHOLE COVER POPPED OFF AGAIN\n" +
        "19:44  AND SMOKE CAME OUT\n" +
        "19:45  NO LONGER SMOKING BUT MANHOLE EXPOSED\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1213317    06-15-2012    TRANSFERRED CALL\n" +
        "F1213307    06-15-2012    FIRE ALARM\n" +
        "F1213161    06-14-2012    FIRE ALARM\n" +
        "F1212009    05-31-2012    FIRE ALARM\n" +
        "F1211449    05-25-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1215078",
        "DATE:07-05-2012",
        "TIME:19:44:55",
        "CODE:FIN",
        "CALL:FIRE INVESTIGATION",
        "PLACE:JOE'S CRAB SHACK",
        "ADDR:555 CITY AVE E",
        "X:MONUMENT RD AND PRESIDENTIAL BLVD",
        "BOX:3479G9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T3",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215080\n" +
        "Incident Received: 07-05-2012  20:16:07              Call Source:  10DIGIT\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "302 PENBREE CIR \n" +
        "Cross Street:  PENBREE TER\n\n" +
        "Map:    Plan:   ADC: 3479D9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "20:16  SEES SMOKE COMING FROM THE HOUSE\n" +
        "20:16  LEFT SIDE OF THE HOUSE TOWARD THE POOL\n" +
        "20:16  AND SMOKE BANKED DOWN THE DRIVEWAY\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1209262    04-29-2012    UNKNOWN TYPE FIRE\n" +
        "F1208316    04-18-2012    BUILDING FIRE\n" +
        "F1208316    04-18-2012    UNKNOWN TYPE FIRE\n" +
        "F1208328    04-18-2012    BUILDING FIRE\n" +
        "\n\n" +
        " ** ",

        "ID:F1215080",
        "DATE:07-05-2012",
        "TIME:20:16:07",
        "CODE:FBL",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:302 PENBREE CIR",
        "X:PENBREE TER",
        "BOX:3479D9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T4",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215342\n" +
        "Incident Received: 07-09-2012  02:52:07              Call Source:  10DIGIT\n\n" +
        "CODE: FUN-UNKNOWN TYPE FIRE \n\n" +
        "310 VALLEY RD \n" +
        "Cross Street: SYCAMORE AVE AND BOWMAN AVE\n\n" +
        "Map:    Plan:   ADC: 3478K10  MUN: LMER\n\n" +
        "Units Due:   FXLMER  U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "02:52  SMELLS SOMETHING BURNING IN THE AREA\n" +
        "02:52  STATED BETWEEN THE 200-300 BLOCK\n" +
        "02:52  DOES NOT NEED TO SEE AN OFFICER\n" +
        "02:52  NO SMOKE\n" +
        "02:52  SAYING IT SMELLS LIKE A BITTER BURNING SMELL\n" +
        "02:52  STRONGEST BEHIND 310 VALLEY RD - NEAR THE RAILROAD\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215342",
        "DATE:07-09-2012",
        "TIME:02:52:07",
        "CODE:FUN",
        "CALL:UNKNOWN TYPE FIRE",
        "ADDR:310 VALLEY RD",
        "X:SYCAMORE AVE AND BOWMAN AVE",
        "BOX:3478K10",
        "CITY:LOWER MERION TWP",
        "UNIT:FXLMER U28 P28");

    doTest("T5",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215467\n" +
        "Incident Received: 07-10-2012  09:45:41              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "153 CITY AVE E\n" +
        "Cross Street: N 47TH ST AND BELMONT AVE\n\n" +
        "Map:    Plan:   ADC: 3479E10  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:45  A/C GAVE ADDRESS AS 153 -169 CITY AVE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215467",
        "DATE:07-10-2012",
        "TIME:09:45:41",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:153 CITY AVE E",
        "X:N 47TH ST AND BELMONT AVE",
        "BOX:3479E10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T6",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215474\n" +
        "Incident Received: 07-10-2012  10:31:14              Call Source:      911\n\n" +
        "CODE: FBL-BUILDING FIRE COMMERCIAL\n" +
        "PAGODA BUILDING\n" +
        "100 PRESIDENTIAL BLVD \n" +
        "Cross Street: E CITY AVE AND GLEN RD\n\n" +
        "Map:    Plan:   ADC: 3479F9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "ACCESS CODE 04\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:31  SMOKE COMING FROM THE VENTS\n" +
        "10:31  CALER NOW STATING SMOKE IS COMING FROM MACHINE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1212660    06-08-2012    TRANSFERRED CALL\n" +
        "F1212592    06-07-2012    TRANSFERRED CALL\n" +
        "F1205295    03-13-2012    TRANSFERRED CALL\n" +
        "F1123843    09-22-2011    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1215474",
        "DATE:07-10-2012",
        "TIME:10:31:14",
        "CODE:FBL",
        "CALL:BUILDING FIRE COMMERCIAL",
        "PLACE:PAGODA BUILDING",
        "ADDR:100 PRESIDENTIAL BLVD",
        "X:E CITY AVE AND GLEN RD",
        "BOX:3479F9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T7",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215510\n" +
        "Incident Received: 07-10-2012  22:34:26              Call Source:   POLICE\n\n" +
        "CODE: FVE-VEHICLE FIRE \n\n" +
        "   \n" +
        "Cross Street: MONTGOMERY AVE AND HAVERFORD AVE\n\n" +
        "Map:    Plan:   ADC: 3478K9  MUN: LMER\n\n" +
        "Units Due:   U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "22:32  S/D\n" +
        "22:34  3417-HAVE FIRE DEPT RESPOND HAVE ALOT OF SMOKE COMING OUT FROM UNDER THE HOOD\n" +
        "22:34  3417 -- LIC/HRE6441, LIS/PA, LIY/12, LIT/PC. MAZDA\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215510",
        "DATE:07-10-2012",
        "TIME:22:34:26",
        "CODE:FVE",
        "CALL:VEHICLE FIRE",
        "ADDR:MONTGOMERY AVE AND HAVERFORD AVE",
        "BOX:3478K9",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28");

    doTest("T8",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215532\n" +
        "Incident Received: 07-11-2012  08:45:33              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n" +
        "WALDRON MERCY ACADEMY\n" +
        "513 MONTGOMERY AVE \n" +
        "Cross Street: MERION RD AND ANTHWYN RD\n\n" +
        "Map:    Plan:   ADC: 3478K9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "PFA ORDER - 9 N LEXINGTON RD HAVERTOWN DELCO - PLAINTIFF KIANNA WILLIAMS VS. DEFENDANT AARON MCKIE OF 1414 CENTENNIAL RD PNVY - SUBJ IS PROHIBITED FROM GOING TO WALDRON MERCY ACADEMY WHERE HIS DAUGHTER ATTENDS.\n" +
        "KNOX BOX OUTSIDE MAIN ENTRANCE - 51307 (THE LAST TWO (2) DIGITS WILL CHANGE WITH THE CORRESPONDING YEAR)\n" +
        "KEY BOX LOCATED TO THE RIGHT OF THE MAIN DOOR. KEYS TO THE ENTIRE BUILDING ARE LOCATED HERE.\n" +
        "KEYBOX CODE IS 51307\n\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "08:45  BASEMENT LAUNDRY RM\n" +
        "08:45  W/N\n" +
        "08:45  PH: 610.664.9847\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1119956    08-26-2011    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1215532",
        "DATE:07-11-2012",
        "TIME:08:45:33",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "PLACE:WALDRON MERCY ACADEMY",
        "ADDR:513 MONTGOMERY AVE",
        "X:MERION RD AND ANTHWYN RD",
        "BOX:3478K9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T9",
        "(Dispatch) ---- Clear Report v1.2SP ------        `\"h$          INCIDENT: F1215532\n" +
        "Incident Received: 07-11-2012  08:45:33              Call Soubce:    PHONE\n" +
        "Incident Closed8   07-11-2012  08:57:16\n" +
        "First Unit Onscene:            00:04:39\n" +
        "Time I~ Service:               00:11:27\n\n" +
        "CODE: FAL-FIRE ALARM  \n" +
        "WALDRGN MERCY ACADEMY\n" +
        "513 MONTGOMERY AVE \n" +
        "Cross Street: MERION RD AND ANTHWYN RD\n\n" +
        "Map:    Plan:   MUN: LMER\n\n" +
        "UNIT      DISPATCH0)RESPOND   ON-SCENE  TRANSPORT  AT HOSP.  AVAILABLE  MILES\n" +
        "----      --------  -------   --------  ---------  --------  ----/----  -----\n" +
        "CH28      08:49:21  08:49:22  08:50:14  --:--:--   --:--:--  08:57:15\n" +
        "FXLMER    08:45:50  --:--:--  --:--:--  --:--:--   --:--:--  08:46:39\n" +
        "P28       08:45:49  08:49:15  08:50:12  --:--:--   --:--:--  08:57:15\n" +
        "TW28      08:45:49  --:--:,-  --:--:--  --:--:--   --:--:--  4::57:15\n" +
        "U28       08:45:49  --:--:--  --:--:--  --:--:--   --:--:--  08:57:160\n\n" +
        "Event Commentw:\n" +
        "----- ---------\n" +
        "08:45  BASEMENT LAUNDRY RM\n" +
        "08:45  PH: 610>764.9847\n" +
        "0:45  W/N\n" +
        "08:56  -- page tk 28 -- NotE: ALL UNITS RECALL PER LT28\n" +
        "08:57  LT28-28AVAIL SET OFF BY WORKERS\n\n" +
        "\n\n" +
        " ** ",

        "CALL:RUN REPORT",
        "PLACE:---- Clear Report v1.2SP ------         \"h$          INCIDENT: F1215532\nIncident Received: 07-11-2012  08:45:33              Call Soubce:    PHONE\nIncident Closed8   07-11-2012  08:57:16\nFirst Unit Onscene:            00:04:39\nTime I~ Service:               00:11:27\n\nCODE: FAL-FIRE ALARM  \nWALDRGN MERCY ACADEMY\n513 MONTGOMERY AVE \nCross Street: MERION RD AND ANTHWYN RD\n\nMap:    Plan:   MUN: LMER\n\nUNIT      DISPATCH0)RESPOND   ON-SCENE  TRANSPORT  AT HOSP.  AVAILABLE  MILES\n----      --------  -------   --------  ---------  --------  ----/----  -----\nCH28      08:49:21  08:49:22  08:50:14  --:--:--   --:--:--  08:57:15\nFXLMER    08:45:50  --:--:--  --:--:--  --:--:--   --:--:--  08:46:39\nP28       08:45:49  08:49:15  08:50:12  --:--:--   --:--:--  08:57:15\nTW28      08:45:49  --:--:,-  --:--:--  --:--:--   --:--:--  4::57:15\nU28       08:45:49  --:--:--  --:--:--  --:--:--   --:--:--  08:57:160\n\nEvent Commentw:\n----- ---------\n08:45  BASEMENT LAUNDRY RM\n08:45  PH: 610>764.9847\n0:45  W/N\n08:56  -- page tk 28 -- NotE: ALL UNITS RECALL PER LT28\n08:57  LT28-28AVAIL SET OFF BY WORKERS\n\n\n\n **");

    doTest("T10",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215602\n" +
        "Incident Received: 07-11-2012  19:51:45              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "104 MAPLE AVE \n" +
        "Cross Street: UNION AVE AND N LATCHS LN\n\n" +
        "Map:    Plan:   ADC: 3479C10  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:51  AUD-2ND FLOOR SMOKE,PRAKASH ARYA RES#-610-660-9911,W/A/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1131638    12-15-2011    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1215602",
        "DATE:07-11-2012",
        "TIME:19:51:45",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:104 MAPLE AVE",
        "X:UNION AVE AND N LATCHS LN",
        "BOX:3479C10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T11",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215670\n" +
        "Incident Received: 07-12-2012  14:30:52              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "225 LATCHS LN N\n" +
        "Cross Street: OLD LANCASTER RD AND LAPSLEY LN\n\n" +
        "Map:    Plan:   ADC: 3589B1  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "14:30  GEN ALARM - FOYER SMOKE\n" +
        "14:30  W/N\n" +
        "14:30  RES - HILDIBRANDT #610-667-2335\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215670",
        "DATE:07-12-2012",
        "TIME:14:30:52",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:225 LATCHS LN N",
        "X:OLD LANCASTER RD AND LAPSLEY LN",
        "BOX:3589B1",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T12",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215778\n" +
        "Incident Received: 07-13-2012  18:22:51              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "301 CITY AVE E\n" +
        "Cross Street: KINGS GRANT DR AND DECKER BLVD\n\n" +
        "Map:    Plan:   ADC: 3479F10  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:22  SPECIAL ADDRESS COMMENT:\n" +
        "18:22  VALID SUITES AT LOCATION - REVERIFY\n" +
        "18:22  SPECIAL ADDRESS COMMENT:\n" +
        "18:22  GROUND FLOOR REAR PULL STATION\n" +
        "18:22  ALARM CO HAS IT AS THE 301 CITY BUILDING\n" +
        "18:22  NO BUSINESS NAME GIVEN\n" +
        "18:22  VALID SUITES AT LOCATION - REVERIFY\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215778",
        "DATE:07-13-2012",
        "TIME:18:22:51",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:301 CITY AVE E",
        "X:KINGS GRANT DR AND DECKER BLVD",
        "BOX:3479F10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T13",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215796\n" +
        "Incident Received: 07-13-2012  22:08:17             `Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "40 DERWEN RD \n" +
        "Cross Street: CONSHOHOCKEN STATE RD AND BRYN MAWR AVE\n\n" +
        "Map:`   Plan:   ADC: 3479B9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "22:08  AUD FIRE - GENERAL\n" +
        "22:08  CITRENBAUM RES - 610-664-2896\n" +
        "22:08  W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1211555    05-26-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1215796",
        "DATE:07-13-2012",
        "TIME:22:08:17",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:40 DERWEN RD",
        "X:CONSHOHOCKEN STATE RD AND BRYN MAWR AVE",
        "BOX:3479B9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T14",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215833\n" +
        "Incident Received: 07-14-2012  13:25:29              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "504 HOWE RD \n" +
        "Cross Street: MEETING HOUSE LN AND STANDISH RD\n\n" +
        "Map:    Plan:   ADC: 3479A9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "13:25  SMOKE DETECTOR IN FOYIER\n" +
        "13:25  RES SERXNER #610-664-7960\n" +
        "13:25  W/N\n" +
        "13:25  KEY BOX INFO-MOP\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215833",
        "DATE:07-14-2012",
        "TIME:13:25:29",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:504 HOWE RD",
        "X:MEETING HOUSE LN AND STANDISH RD",
        "BOX:3479A9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T15",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1215851\n" +
        "Incident Received: 07-14-2012  18:00:02              Call Source:  10DIGIT\n\n" +
        "CODE: FGL-GAS-ODOR/LEAK OUTSIDE\n\n" +
        "251 STANDISH RD \n" +
        "Cross Street: HOWE RD AND PUTNAM RD\n\n" +
        "Map:    Plan:   ADC: 3479A8  MUN: LMER\n\n" +
        "Units Due:   U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:00  NATURAL GAS\n" +
        "18:00  ODOR OUTSIDE NEAR...AND 253 STANDISH\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1215851",
        "DATE:07-14-2012",
        "TIME:18:00:02",
        "CODE:FGL",
        "CALL:GAS-ODOR/LEAK OUTSIDE",
        "ADDR:251 STANDISH RD",
        "X:HOWE RD AND PUTNAM RD",
        "BOX:3479A8",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28");

    doTest("T16",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216012\n" +
        "Incident Received: 07-16-2012  07:34:12              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "134 ROLLING RD \n" +
        "Cross Street: E LEVERING MILL RD AND E LEVERING MILL RD\n\n" +
        "Map:    Plan:   ADC: 3479C8  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "07:34  BASEMENT\n" +
        "07:34  W/N\n" +
        "07:34  RES: SCOTT YUDIS 610-664-3415\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216012",
        "DATE:07-16-2012",
        "TIME:07:34:12",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:134 ROLLING RD",
        "X:E LEVERING MILL RD AND E LEVERING MILL RD",
        "BOX:3479C8",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T17",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216034\n" +
        "Incident Received: 07-16-2012  09:36:09              Call Source:  10DIGIT\n\n" +
        "CODE: FRL-RESCUE - ELEVATOR \n" +
        "CONNEHLY HALL - SJU\n" +
        "430 LATCHS LN N\n" +
        "Cross Street: LAPSLEY LN AND RAYNHAM RD\n\n" +
        "Map:    Plan:   ADC: 3589A1  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:36  SPECIAL ADDRESS COMMENT:\n" +
        "09:36  + SAINT JOSEPHS UNIVERSITY - JAMES J MAGUIRE CAMPUS\n" +
        "09:36  PER PHILLY DISPATCH 228\n" +
        "09:36  EALE STUCK ON MAIN FLOOR IN ELEVATOR OF CONNELLY HALL\n" +
        "09:36  THEY HAVE FD ENROUTE FOR THEIR SIDE\n" +
        "09:36  UNK ELEVATOR NUMBER\n" +
        "09:36  NFI\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216034",
        "DATE:07-16-2012",
        "TIME:09:36:09",
        "CODE:FRL",
        "CALL:RESCUE - ELEVATOR",
        "PLACE:CONNEHLY HALL - SJU",
        "ADDR:430 LATCHS LN N",
        "X:LAPSLEY LN AND RAYNHAM RD",
        "BOX:3589A1",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T18",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216134\n" +
        "Incident Received: 07-17-2012  11:52:00              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "16 NEWFIELD WAY E\n" +
        "Cross Street: CONSHOHOCKEN STATE RD AND CLWYD RD\n\n" +
        "Map:    Plan:   ADC: 3479D10  MUN: LMER\n\n" +
        "Units Due:   U28  P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:51  AUD - DINING ROOM AND KITCHEN MOTION\n" +
        "11:51  COMING IN AS A BURGLAR ALARM AS WELL\n" +
        "11:51  ALSO SMOKE DETECTOR\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216134",
        "DATE:07-17-2012",
        "TIME:11:52:00",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:16 NEWFIELD WAY E",
        "X:CONSHOHOCKEN STATE RD AND CLWYD RD",
        "BOX:3479D10",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28 TW28");

    doTest("T19",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216329\n" +
        "Incident Received: 07-19-2012  09:29:04              Call Source:  10DIGIT\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "   \n" +
        "Cross Street: OAKHILL RD AND N HIGHLAND AVE\n\n" +
        "Map:    Plan:   ADC: 3479B10  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:29  ON OAKHILL BETWEEN HIGHLAND NAD BIRCH\n" +
        "09:29  WHITE SMOKE FORM A HOME\n" +
        "09:29  IN THE MIDDLE OF THE BLOCK\n" +
        "09:29  POSSIBLE ADRESS ADRESS OF 120 OR 122 HIGHLAND\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216329",
        "DATE:07-19-2012",
        "TIME:09:29:04",
        "CODE:FBL",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:OAKHILL RD AND N HIGHLAND AVE",
        "BOX:3479B10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T20",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216400\n" +
        "Incident Received: 07-20-2012  02:24:26              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "415 MONTGOMERY AVE \n" +
        "Cross Street: BOWMAN AVE AND WINDING WAY\n\n" +
        "Map:    Plan:   ADC: 3479A9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "02:24  3RD FL MAIN HALL FIRE ALARM\n" +
        "02:24  CACIA, MARIA RES - 610-668-2107\n" +
        "02:24  W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1211321    05-23-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1216400",
        "DATE:07-20-2012",
        "TIME:02:24:26",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:415 MONTGOMERY AVE",
        "X:BOWMAN AVE AND WINDING WAY",
        "BOX:3479A9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T21",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216537\n" +
        "Incident Received: 07-21-2012  20:58:52              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT STAND-BY\n\n" +
        "   \n" +
        "Cross Street: E CITY AVE AND MONUMENT RD\n\n" +
        "Map:    Plan:   ADC: 3479F9  MUN: LMER\n\n" +
        "Units Due:   U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "20:55  1 VEH\n" +
        "20:55  ACROSS FROM THE TARGET\n" +
        "20:55  CALLER HEARD A CRASH\n" +
        "20:58  VEH IS LEAKING GAS\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1200631    01-09-2012    VEHICLE FIRE\n" +
        "F1131146    12-08-2011    VEHICLE FIRE\n" +
        "\n\n" +
        " ** ",

        "ID:F1216537",
        "DATE:07-21-2012",
        "TIME:20:58:52",
        "CODE:VA",
        "CALL:VEHICLE ACCIDENT STAND-BY",
        "ADDR:E CITY AVE AND MONUMENT RD",
        "BOX:3479F9",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28");

    doTest("T22",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216580\n" +
        "Incident Received: 07-22-2012  15:29:07              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n" +
        "JOE'S CRAB SHACK\n" +
        "555 CITY AVE E\n" +
        "Cross Street: MONUMENT RD AND PRESIDENTIAL BLVD\n\n" +
        "Map:    Plan:   ADC: 3479G9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "15:29  SPECIAL ADDRESS COMMENT:\n" +
        "15:29  VALID SUITES AT LOCATION - REVERIFY\n" +
        "15:29  SPECIAL ADDRESS COMMENT:\n" +
        "15:29  VALID SUITES AT LOCATION - REVERIFY\n" +
        "15:29  KITCHEN SMOKE SENSOR TOP OF STEPS\n" +
        "15:29  BUS: 610-949-0391\n" +
        "15:29  W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1215078    07-05-2012    FIRE INVESTIGATION\n" +
        "F1213317    06-15-2012    TRANSFERRED CALL\n" +
        "F1213307    06-15-2012    FIRE ALARM\n" +
        "F1213161    06-14-2012    FIRE ALARM\n" +
        "F1212009    05-31-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1216580",
        "DATE:07-22-2012",
        "TIME:15:29:07",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "PLACE:JOE'S CRAB SHACK",
        "ADDR:555 CITY AVE E",
        "X:MONUMENT RD AND PRESIDENTIAL BLVD",
        "BOX:3479G9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T23",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216593\n" +
        "Incident Received: 07-22-2012  20:34:07              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "529 PRESCOTT RD \n" +
        "Cross Street: MEETING HOUSE LN AND GENERAL LAFAYETTE RD\n\n" +
        "Map:    Plan:   ADC: 3478K8  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "20:34  JOHN BURMAN RESD\n" +
        "20:34  2ND FLR SIDE BEDROOM SMOKE DETECTOR\n" +
        "20:34  610-6667-2636\n" +
        "20:34  WILL ATTEMPT\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216593",
        "DATE:07-22-2012",
        "TIME:20:34:07",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:529 PRESCOTT RD",
        "X:MEETING HOUSE LN AND GENERAL LAFAYETTE RD",
        "BOX:3478K8",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T24",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216660\n" +
        "Incident Received: 07-23-2012  17:58:08              Call Source:  10DIGIT\n\n" +
        "CODE: FCM-CARBON MONOXIDE DETECTOR NO SYMPTOMS\n\n" +
        "220 STONEWAY LN \n" +
        "Cross Street: OLD LANCASTER RD AND ORCHARD RD\n\n" +
        "Map:    Plan:   ADC: 3589C1  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "17:58  SOUNDING\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216660",
        "DATE:07-23-2012",
        "TIME:17:58:08",
        "CODE:FCM",
        "CALL:CARBON MONOXIDE DETECTOR NO SYMPTOMS",
        "ADDR:220 STONEWAY LN",
        "X:OLD LANCASTER RD AND ORCHARD RD",
        "BOX:3589C1",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T25",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216718\n" +
        "Incident Received: 07-24-2012  10:44:58              Call Source:      911\n\n" +
        "CODE: FBL-BUILDING FIRE COMMERCIAL\n" +
        "WALDRON MERCY ACADEMY\n" +
        "513 MONTGOMERY AVE \n" +
        "Cross Street: MERION RD AND ANTHWYN RD\n\n" +
        "Map:    Plan:   ADC: 3478K9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "PFA ORDER - 9 N LEXINGTON RD HAVERTOWN DELCO - PLAINTIFF KIANNA WILLIAMS VS. DEFENDANT AARON MCKIE OF 1414 CENTENNIAL RD PNVY - SUBJ IS PROHIBITED FROM GOING TO WALDRON MERCY ACADEMY WHERE HIS DAUGHTER ATTENDS.\n" +
        "KNOX BOX OUTSIDE MAIN ENTRANCE - 51307 (THE LAST TWO (2) DIGITS WILL CHANGE WITH THE CORRESPONDING YEAR)\n" +
        "KEY BOX LOCATED TO THE RIGHT OF THE MAIN DOOR. KEYS TO THE ENTIRE BUILDING ARE LOCATED HERE.\n" +
        "KEYBOX CODE IS 51307\n\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:44  3RD PARTY\n" +
        "10:45  ALARM SOUNDING\n" +
        "10:45  CALELR WAS TOLD BY MAINTACIE THERE IS A FIRE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1216717    07-24-2012    FIRE ALARM\n" +
        "F1215532    07-11-2012    FIRE ALARM\n" +
        "F1119956    08-26-2011    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1216718",
        "DATE:07-24-2012",
        "TIME:10:44:58",
        "CODE:FBL",
        "CALL:BUILDING FIRE COMMERCIAL",
        "PLACE:WALDRON MERCY ACADEMY",
        "ADDR:513 MONTGOMERY AVE",
        "X:MERION RD AND ANTHWYN RD",
        "BOX:3478K9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T26",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1216869\n" +
        "Incident Received: 07-26-2012  08:49:43              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "15 PRESIDENTIAL BLVD \n" +
        "Cross Street: E CITY AVE AND GLEN RD\n\n" +
        "Map:    Plan:   ADC: 3479G9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "CODE TO DOOR IS #1940 PUSH RED BUTTON FOR DIAL TONE THEN ENTER CODE\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "08:49  A/C GIVING THE BUS AS - 15 PRESIDENTIAL BLVD\n" +
        "08:49  GEN AUD ALARM FROM THE SMOKE DETECTOR ON THE 1ST FLR\n" +
        "08:49  W/N\n" +
        "08:49  NO NUMBER TO PREMISE\n" +
        "08:49  100-101\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1216869",
        "DATE:07-26-2012",
        "TIME:08:49:43",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:15 PRESIDENTIAL BLVD",
        "X:E CITY AVE AND GLEN RD",
        "BOX:3479G9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T27",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217105\n" +
        "Incident Received: 07-28-2012  09:19:27              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "510 WINDING WAY \n" +
        "Cross Street: SPRING HOUSE LN AND STANDISH RD\n\n" +
        "Map:    Plan:   ADC: 3479A8  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "09:19  SMOKE DECTORS\n" +
        "09:19  RES LOUISE BARSONS 610-668-1551\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217105",
        "DATE:07-28-2012",
        "TIME:09:19:27",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:510 WINDING WAY",
        "X:SPRING HOUSE LN AND STANDISH RD",
        "BOX:3479A8",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T28",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217246\n" +
        "Incident Received: 07-30-2012  14:37:03              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "39 LLANBERRIS RD \n" +
        "Cross Street: CONSHOHOCKEN STATE RD AND CLWYD RD\n\n" +
        "Map:    Plan:   ADC: 3479D10  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "14:37  GENERAL\n" +
        "14:37  W/N\n" +
        "14:37  LAUDERBACH - 610 668 8979\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217246",
        "DATE:07-30-2012",
        "TIME:14:37:03",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:39 LLANBERRIS RD",
        "X:CONSHOHOCKEN STATE RD AND CLWYD RD",
        "BOX:3479D10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T29",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217260\n" +
        "Incident Received: 07-30-2012  19:10:36              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "734 RIGHTERS MILL RD \n" +
        "Cross Street: N WOODBINE AVE AND CONSHOHOCKEN STATE RD\n\n" +
        "Map:    Plan:   ADC: 3479A7  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:10  GENERAL - MULTIPLE SIGNALS\n" +
        "19:10  REF# 247 5532\n" +
        "19:10  RES: GLASSMAN\n" +
        "19:10  610 668 1938 W/N\n\n" +
        "Prior EvenTs:\n" +
        "----- -------\n" +
        "F1209334    04-30-2012    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1217260",
        "DATE:07-30-2012",
        "TIME:19:10:36",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:734 RIGHTERS MILL RD",
        "X:N WOODBINE AVE AND CONSHOHOCKEN STATE RD",
        "BOX:3479A7",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T30",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217264\n" +
        "Incident Received: 07-30-2012  20:19:07              Call Source:  10DIGIT\n\n" +
        "CODE: VA-VEHICLE ACCIDENT STAND-BY\n\n" +
        "   \n" +
        "Cross Street: BRYN MAWR AVE AND BALA AVE\n\n" +
        "Map:    Plan:   ADC: 3479B9  MUN: LMER\n\n" +
        "Units Due:   U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "20:13  VEH INTO A TREE\n" +
        "20:13  DRIVER REFUSED EMS\n" +
        "20:13  DRIVER DOES HAVE BRUISING AND THE AIR BAG DEPLOYED---STILL REFUSED EMS\n" +
        "20:14  VEH IS PULLED ONTO THE SHOULDER\n" +
        "20:17  3422 -- START EMS FOR SOME BRUISING\n" +
        "20:19  3425 -- FIRE CO TO SECURE THE VEHICLE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1215721    07-13-2012    TRANSFERRED CALL\n" +
        "\n\n" +
        " ** ",

        "ID:F1217264",
        "DATE:07-30-2012",
        "TIME:20:19:07",
        "CODE:VA",
        "CALL:VEHICLE ACCIDENT STAND-BY",
        "ADDR:BRYN MAWR AVE AND BALA AVE",
        "BOX:3479B9",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28");

    doTest("T31",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217310\n" +
        "Incident Received: 07-31-2012  10:29:55              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "523 MONROE RD \n" +
        "Cross Street: MEETING HOUSE LN AND MAPLEWOOD AVE\n\n" +
        "Map:    Plan:   ADC: 3478K9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "10:29  GENERAL\n" +
        "10:29  W/N\n" +
        "10:29  RICHARD BROWN - 610 664 6875\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217310",
        "DATE:07-31-2012",
        "TIME:10:29:55",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:523 MONROE RD",
        "X:MEETING HOUSE LN AND MAPLEWOOD AVE",
        "BOX:3478K9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T32",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217349\n" +
        "Incident Received: 07-31-2012  18:42:01              Call Source:      911\n\n" +
        "CODE: FBL-BUILDING FIRE NON-COMMERCIAL\n\n" +
        "326 MEADOW LN \n" +
        "Cross Street: MONTGOMERY AVE AND MERION RD\n\n" +
        "Map:    Plan:   ADC: 3479A9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:42  COUPLE HOUSES DOWN FROM...\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217349",
        "DATE:07-31-2012",
        "TIME:18:42:01",
        "CODE:FBL",
        "CALL:BUILDING FIRE NON-COMMERCIAL",
        "ADDR:326 MEADOW LN",
        "X:MONTGOMERY AVE AND MERION RD",
        "BOX:3479A9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T33",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217616\n" +
        "Incident Received: 08-03-2012  19:45:35              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "401 MERION RD \n" +
        "Cross Street: WINDING WAY AND MEADOW LN\n\n" +
        "Map:    Plan:   ADC: 3478K10  MUN: LMER\n\n" +
        "Units Due:`  P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "19:45  STAIRS SMOKE DET\n" +
        "19:45  RES: SCHEER\n" +
        "19:45  NO ANSWER AT THE LOCATION\n" +
        "19:45  484 270 8235 W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217616",
        "DATE:08-03-2012",
        "TIME:19:45:35",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:401 MERION RD",
        "X:WINDING WAY AND MEADOW LN",
        "BOX:3478K10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T34",
        "(Dispatch) ------ Clear Report v5.2SP ------           0($     0)INCIDENT: F1217616\n" +
        "Incident Received: 08-03-2012  19:45:35             `Call Source:    PHONE\n" +
        "Incident CloSed:   08-03-2012  19:52:44\n" +
        "First Uni| Onscene:            02:04:55\n" +
        "Time I~ Service:        ( 0!   00:06:51\n\n" +
        "CODE: FAL-FIRE ALCRM  \n\n" +
        "401 MERION RD \n" +
        "Cross Street: WINDING WAY AND MEADOW LN\n\n" +
        "Map:    Plan:   MUN: LMER\n\n" +
        "UNIT      DISPATCH  RESPOND   ON-SCENE 0TRANSPORT  AT HOSP.  AVAILABLE  MILES\n" +
        "----      --------  -\n" +
        "-----   --------  ---------  --------  ---------  -----\n" +
        "AC28     19:48:1  19:48:19  19:50:32  --:--:\n" +
        "-   --:--:--  19:52:44\n" +
        "FXLMER    19:45:55  --:--:--  --:--:--  --:--:--   --:--:--  19:46:50\n" +
        "P28  )$  019:45:53  19:48:20  19:50:30  --:--:-- 2 --:--:--  19:52:44\n" +
        "TW28      19:45:54  --:--:--  --:--:--  --:--:--   --:--:--  19:52:44\n" +
        "U28       19:45:54  --:--:--  --:--:--  --:--:--   --:--:--  19:52:440\n\n" +
        "Event Comments2\n" +
        "----= ---------\n" +
        "19:45  RES: SCHEER\n" +
        "19:45  NO ANSWER AT HE LOCATION19:45  484 270 8235 W/N\n" +
        "19:45  STAIRQ SMOKA DET\n" +
        "19*46  A/C BACK ON THE`LIE - RGQUESTING TO CANCUL\n" +
        "19:<7  SPOKE WITH RANDY SCHEER - GAVE PASSCODE\n" +
        "19:47  SET IT OFF WHILE COOKING - IS ON LOCATION\n" +
        "19:48  HOMEOWNER ON THE LINE NOW - SAYING SHE BURNT SOMETHING IN THE OVEN\n" +
        "19:48  NO FIRE - SENT OF THE SMOKE ALARM\n" +
        "19:52\" P28-STaTION 28 AVAILABLE\n\n" +
        "\n\n" +
        " ** ",

        "CALL:RUN REPORT",
        "PLACE:------ Clear Report v5.2SP ------           0($     0)INCIDENT: F1217616\nIncident Received: 08-03-2012  19:45:35              Call Source:    PHONE\nIncident CloSed:   08-03-2012  19:52:44\nFirst Uni| Onscene:            02:04:55\nTime I~ Service:        ( 0!   00:06:51\n\nCODE: FAL-FIRE ALCRM  \n\n401 MERION RD \nCross Street: WINDING WAY AND MEADOW LN\n\nMap:    Plan:   MUN: LMER\n\nUNIT      DISPATCH  RESPOND   ON-SCENE 0TRANSPORT  AT HOSP.  AVAILABLE  MILES\n----      --------  -\n-----   --------  ---------  --------  ---------  -----\nAC28     19:48:1  19:48:19  19:50:32  --:--:\n-   --:--:--  19:52:44\nFXLMER    19:45:55  --:--:--  --:--:--  --:--:--   --:--:--  19:46:50\nP28  )$  019:45:53  19:48:20  19:50:30  --:--:-- 2 --:--:--  19:52:44\nTW28      19:45:54  --:--:--  --:--:--  --:--:--   --:--:--  19:52:44\nU28       19:45:54  --:--:--  --:--:--  --:--:--   --:--:--  19:52:440\n\nEvent Comments2\n----= ---------\n19:45  RES: SCHEER\n19:45  NO ANSWER AT HE LOCATION19:45  484 270 8235 W/N\n19:45  STAIRQ SMOKA DET\n19*46  A/C BACK ON THE LIE - RGQUESTING TO CANCUL\n19:<7  SPOKE WITH RANDY SCHEER - GAVE PASSCODE\n19:47  SET IT OFF WHILE COOKING - IS ON LOCATION\n19:48  HOMEOWNER ON THE LINE NOW - SAYING SHE BURNT SOMETHING IN THE OVEN\n19:48  NO FIRE - SENT OF THE SMOKE ALARM\n19:52\" P28-STaTION 28 AVAILABLE\n\n\n\n **");

    doTest("T35",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217746\n" +
        "Incident Received: 08-05-2012  14:01:48              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "130 LODGES LN \n" +
        "Cross Street: PEMBROKE RD AND TREGARON RD\n\n" +
        "Map:    Plan:   ADC: 3479B9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "14:01  RESD-MATITYAHU, GIL 610/370-6337\n" +
        "14:01  W/N\n" +
        "14:01  3RD FLR SMOKE\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217746",
        "DATE:08-05-2012",
        "TIME:14:01:48",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:130 LODGES LN",
        "X:PEMBROKE RD AND TREGARON RD",
        "BOX:3479B9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T36",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217762\n" +
        "Incident Received: 08-05-2012  18:39:37              Call Source:  10DIGIT\n\n" +
        "CODE: FIN-FIRE INVESTIGATION \n\n" +
        "309 VALLEY RD \n" +
        "Cross Street: SYCAMORE AVE AND BOWMAN AVE\n\n" +
        "Map:    Plan:   ADC: 3478K10  MUN: LMER\n\n" +
        "Units Due:   U28  P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "18:39  IN FRONT OF...........\n" +
        "18:39  LARGE BRANCH\n" +
        "18:39  UNKNOWN IF ANY DAMAGE\n" +
        "18:39  UP AGAINST CALLER HOME\n" +
        "18:39  NO WIRES DOWN\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217762",
        "DATE:08-05-2012",
        "TIME:18:39:37",
        "CODE:FIN",
        "CALL:FIRE INVESTIGATION",
        "ADDR:309 VALLEY RD",
        "X:SYCAMORE AVE AND BOWMAN AVE",
        "BOX:3478K10",
        "CITY:LOWER MERION TWP",
        "UNIT:U28 P28");

    doTest("T37",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217785\n" +
        "Incident Received: 08-05-2012  23:24:37              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "101 CITY AVE W\n" +
        "Cross Street: BRYN MAWR AVE AND HAMPTON TER\n\n" +
        "Map:    Plan:   ADC: 3589C1  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "COMBINATION LOCK BOX FOR THE RESIDENTIAL \n" +
        "PROPERTY  and   BARE FOOT SHOES: 3748\n\n" +
        "10/18/11\n\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "23:24  @MAVERICK MAIN LINE\n" +
        "23:24  Event stacked at: 08/05/12 23:24:19\n" +
        "23:24  COULD NOT CONFIRM TWP\n" +
        "23:24  OR XSTREETS\n" +
        "23:25  WATERLFLOW , BARE FEET RISER NUMBER 1\n" +
        "23:25  215-885-8383\n" +
        "23:25  W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1214213    06-26-2012    SPECIAL SERVICE\n" +
        "F1132414    12-26-2011    FIRE ALARM\n" +
        "F1126090    10-15-2011    FIRE ALARM\n" +
        "F1125100    10-05-2011    FIRE ALARM\n" +
        "\n\n" +
        " ** ",

        "ID:F1217785",
        "DATE:08-05-2012",
        "TIME:23:24:37",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:101 CITY AVE W",
        "X:BRYN MAWR AVE AND HAMPTON TER",
        "BOX:3589C1",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T38",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1217985\n" +
        "Incident Received: 08-08-2012  07:13:34              Call Source:      911\n\n" +
        "CODE: FCM-CARBON MONOXIDE DETECTOR NO SYMPTOMS\n\n" +
        "17 NEWFIELD WAY E\n" +
        "Cross Street: CONSHOHOCKEN STATE RD AND CLWYD RD\n\n" +
        "Map:    Plan:   ADC: 3479D10  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "07:13  GOING OFF WITHIN 10 MIN/CALLERHAS DISCONNECTED\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1217985",
        "DATE:08-08-2012",
        "TIME:07:13:34",
        "CODE:FCM",
        "CALL:CARBON MONOXIDE DETECTOR NO SYMPTOMS",
        "ADDR:17 NEWFIELD WAY E",
        "X:CONSHOHOCKEN STATE RD AND CLWYD RD",
        "BOX:3479D10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T39",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1218017\n" +
        "Incident Received: 08-08-2012  11:54:03              Call Source:      911\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "406 BRYN MAWR AVE \n" +
        "Cross Street: BALA AVE AND LODGES LN\n\n" +
        "Map:    Plan:   ADC: 3479B9  MUN: LMER\n\n" +
        "Units Due:   P28  TW28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "11:54  ALARMS ARE GOING OFF - NO SMOKE OR FLAMES IN HOME\n" +
        "11:54  GROUNDED WIRES\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** ",

        "ID:F1218017",
        "DATE:08-08-2012",
        "TIME:11:54:03",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:406 BRYN MAWR AVE",
        "X:BALA AVE AND LODGES LN",
        "BOX:3479B9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28 TW28");

    doTest("T40",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1218021\n" +
        "Incident Received: 08-08-2012  13:04:19              Call Source:      911\n\n" +
        "CODE: FCM-CARBON MONOXIDE DETECTOR NO SYMPTOMS\n\n" +
        "17 NEWFIELD WAY E\n" +
        "Cross Street: CONSHOHOCKEN STATE RD AND CLWYD RD\n\n" +
        "Map:    Plan:   ADC: 3479D10  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "13:04  ADVD TO EVACUATE\n" +
        "13:04  CARBON MONOXIDE DETECTOR IS GOING OFF AGAIN\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "F1217985    08-08-2012    CARBON MONOXIDE DETECTOR\n" +
        "\n\n" +
        " ** ",

        "ID:F1218021",
        "DATE:08-08-2012",
        "TIME:13:04:19",
        "CODE:FCM",
        "CALL:CARBON MONOXIDE DETECTOR NO SYMPTOMS",
        "ADDR:17 NEWFIELD WAY E",
        "X:CONSHOHOCKEN STATE RD AND CLWYD RD",
        "BOX:3479D10",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

    doTest("T41",
        "(Dispatch) ------ Dispatch Report v1.3SP ------                   INCIDENT: F1218164\n" +
        "Incident Received: 08-09-2012  23:47:29              Call Source:  10DIGIT\n\n" +
        "CODE: FAL-FIRE ALARM \n\n" +
        "402 KUNT RD \n" +
        "Cross Street: BALA AVE AND LODGES LN\n\n" +
        "Map:    Plan:   ADC: 3479B9  MUN: LMER\n\n" +
        "Units Due:   P28\n\n" +
        "Additional Info:\n" +
        "---------- ----\n" +
        "*** ADDITIONAL INFO NOT ON FILE FOR THIS LOCATION ***\n\n" +
        "Event Comments:\n" +
        "----- ---------\n" +
        "23:47  FIRE ELECTRIC SMOKE- UNK AREA\n" +
        "23:47  MR AND MRS BILL ERICH 610-949-9691\n" +
        "23:47  Event stacked at: 08/09/12 23:47:09\n" +
        "23:47  W/N\n\n" +
        "Prior Events:\n" +
        "----- -------\n" +
        "*** NOT FOUND ***\n" +
        "\n\n" +
        " ** \n\n",

        "ID:F1218164",
        "DATE:08-09-2012",
        "TIME:23:47:29",
        "CODE:FAL",
        "CALL:FIRE ALARM",
        "ADDR:402 KUNT RD",
        "X:BALA AVE AND LODGES LN",
        "BOX:3479B9",
        "CITY:LOWER MERION TWP",
        "UNIT:P28");

  }
  
  public static void main(String[] args) {
    new PAMontgomeryCountyDParserTest().generateTests("T1", "ID DATE TIME CODE CALL PLACE ADDR APT X MAP BOX CITY UNIT");
  }
}
