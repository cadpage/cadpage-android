package net.anei.cadpage.parsers;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/**

Contact: Active911
Agency name: Evergreen Fire Rescue
Location: Evergreen, CO, United States
Sender: EFR CAD <call-alert@evergreenfirerescue.com>

(EFR Call: VEHICLE ACCIDENT #CFS:020713-5) \nCALL: VEHICLE ACCIDENT\nPLACE: \nADDR: 7256 S BROOK FOREST RD, Evergreen, CO 80439\nCITY: EVERGREEN\nID: CFS:020713-5\nPRI: 1\nDATE: 02/07/2013\nTIME: 08:06:12\nMAP: http://maps.google.com/maps?q=+39.58827%20-105.35374\nUNIT: \nINFO: CFS: 020713-5\nHydrant: 677  \nHydrant: 95  \nPage 16\nFIRE DISTRICT\nSTATION 8 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : S COLUMBINE RD Inc Location changed to 7256 S BROOK FOREST RD at 08:06\nFIRE DISTRICT\n  
(EFR Call: NAT GAS OR PROPANE LEAK-RESID #CFS:020713-1) \nCALL: NAT GAS OR PROPANE LEAK-RESID\nPLACE: \nADDR: 7796 CENTAUR DR, Evergreen, CO 80439\nCITY: EVERGREEN\nID: CFS:020713-1\nPRI: 1\nDATE: 02/07/2013\nTIME: 00:16:05\nMAP: http://maps.google.com/maps?q=+39.57529%20-105.32719\nUNIT: \nINFO: CFS: 020713-1\nHydrant: 677  \nHydrant: 49  \nSD EVERGREEN MEADOWS\nSD EVERGREEN MEADOWS\nPage 7\nFIRE DISTRICT\nSTATION 3 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : NEEDLES TRL EVAC IN PROGRESS\nGAS LEAK IN BASEMENT, MAJOR\nInc Location changed to 7796 CENTAUR DR at 00:15\nSD EVERGREEN MEADOWS\n  
(EFR Call: FIRE ALARM-COMMERCIAL #CFS:020613-11) \nCALL: FIRE ALARM-COMMERCIAL\nPLACE: mtn pro tech\nADDR: 30746 BRYANT DR, Evergreen, CO 80439\nCITY: EVERGREEN\nID: CFS:020613-11\nPRI: 1\nDATE: 02/06/2013\nTIME: 17:03:13\nMAP: http://maps.google.com/maps?q=+39.64955%20-105.34741\nUNIT: 316\nINFO: CFS: 020613-11\nCross Streets : UNNAMED 2571\nEvergreen Auto Works\nEvergreen Artisan Park - East\nArtisan Park Self Storage\nEvergreen Landscapes & Supply\nAmber Doe Furnishings & Design\nBergen Homes\nAir Dat, LLC\nWard Hardwood Flooring (313)\nWard Hardwood Flooring (314)\nWard Hardwood Flooring (315)\nWard Hardwood Flooring (316)\nKatoya Products\nVacant - June 2005 (406)\nVacant - June 2005 (408)\nVacant - June 2005 (416)\nEVERGREEN BUSINESS PLAZA\nPage 63\nFIRE DISTRICT\nSTATION 2 AMB\nSTATION 2 RESPONSE ZONE\nREC PROPER CODE BUT CANNOT CANCEL\nKEY PAD FIRE ALARM\nInc Location changed to 30746 BRYANT DR at 17:00\nArtisan Park Self Storage\n  
(EFR Call: MEDICAL RESPONSE #CFS:020613-10) \nCALL: MEDICAL RESPONSE\nPLACE: \nADDR: 2170 TORREY PINE DR, Evergreen, CO 80439\nCITY: EVERGREEN\nID: CFS:020613-10\nPRI: 1\nDATE: 02/06/2013\nTIME: 17:00:27\nMAP: http://maps.google.com/maps?q=+39.67513%20-105.36189\nUNIT: \nINFO: CFS: 020613-10\nHydrant: 169  \nHydrant: 170  \nSD HIWAN\nSD HIWAN\nPage 70\nFIRE DISTRICT\nSTATION 2 AMB\nSTATION 2 RESPONSE ZONE\n\n\n         \n         \n         \n         \n         \n         \n         \n         \n         \n         \nCross Streets : TORREY PINE CIR LIFT ASSIST TO GET PT FROM CAR TO HOUSE\nInc Location changed to 2170 TORREY PINE DR at 17:00\nSD HIWAN\n  
(EFR Call: MEDICAL RESPONSE #CFS:020613-7) \nCALL: MEDICAL RESPONSE\nPLACE: \nADDR: 31299 MANITOBA DR, Evergreen, CO 80439\nCITY: EVERGREEN\nID: CFS:020613-7\nPRI: 1\nDATE: 02/06/2013\nTIME: 13:44:48\nMAP: http://maps.google.com/maps?q=+39.59878%20-105.35666\nUNIT: \nINFO: CFS: 020613-7\nHydrant: 85  \nHydrant: 95  \nSD EVERGREEN VALLEY ESTATES\nPage 26\nFIRE DISTRICT\nSTATION 8 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : SNOWSHOE RD Inc Location changed to 31299 MANITOBA DR at 13:44\nInc Location changed to [NO VALUE] at 13:44\nPage 26\n  

Contact: CodeMessaging
ID: 21996\nUNIT: 211,\nCALL: Suspicious Person\nCODE: 81\nSRC: 102\nPRI: 1\nPLACE: NEWMAN'S CARRYOUT\nADDR: 1421  ST RT 15\18\nAPT: B\nBOX: 15 15\nX: US 24 and CHRISTY RD\nCITY: NOBLE TWP\nSTATE: OH\nMAP:\nCH:\nINFO: WHITE MALE WHO IS ELDERLY LEANING AGAINST A SEMI-TRUCK WITH\nCAMOFLOUGE SHORTS\nNAME: LORETTA\nPHONE:\nGPS:\nTIME: 12:10:37\nDATE: 08/09/2013\nTime_Dispatched: 2013-08-09 12:10:37\nThis_Unit: 211\nVersion: OHDefianceCounty.20130701

 */
public class Cadpage2ParserTest extends BaseParserTest {
  
  public Cadpage2ParserTest() {
    setParser(new Cadpage2Parser(), "", "");
  }
  
  @Test
  public void testCodeMessaging() {
    doTest("OHDefianceCounty",
        "D: 18832 <BR> UNIT: 406, <BR> CALL: Miscellaneous <BR> CODE: 54 <BR> SRC: 104 <BR> PRI: 0 <BR> PLACE:  <BR> ADDR: CR 7/CR C <BR> APT:  <BR> BOX:  <BR> X:  <BR> CITY:  <BR> STATE:  <BR> MAP:  <BR> CH:  <BR> INFO: WILLIAMS CO. CALLED REQ A TANKER FROM FARMER TO GO TO ABOVE ADDRESS. FOR TRAIN DERAILMENT. WILLIAMS CO. ADVSD THEY WOULD CALL BACK TO ADVISE WHERE TO STAGE.//BG@1436... FARMER 400 PAGED. /EMB@1414... PAGE ACKNOWLEDGED. /EMB <BR> NAME:  <BR> PHONE:  <BR> GPS:  <BR> TIME: 15:05:03 <BR> DATE: 07/10/2013 <BR> Time_Dispatched: 2013-07-10 15:05:03 <BR> This_Unit: 406 <BR> Version: OHDefianceCounty.20130701 <BR>",
        "UNIT:406,",
        "CALL:Miscellaneous",
        "CODE:54",
        "SRC:104",
        "PRI:0",
        "ADDR:CR 7 & CR C",
        "MADDR:COUNTY ROAD 7 & COUNTY ROAD C",
        "INFO:WILLIAMS CO. CALLED REQ A TANKER FROM FARMER TO GO TO ABOVE ADDRESS. FOR TRAIN DERAILMENT. WILLIAMS CO. ADVSD THEY WOULD CALL BACK TO ADVISE WHERE TO STAGE.//BG@1436... FARMER 400 PAGED. /EMB@1414... PAGE ACKNOWLEDGED. /EMB",
        "TIME:15:05:03",
        "DATE:07/10/2013");

    doTest("BackSlash",
        "ID: 21996\nUNIT: 211,\nCALL: Suspicious Person\nCODE: 81\nSRC: 102\nPRI: 1\nPLACE: NEWMAN'S CARRYOUT\nADDR: 1421  ST RT 15\\18\nAPT: B\nBOX: 15 15\nX: US 24 and CHRISTY RD\nCITY: NOBLE TWP\nSTATE: OH\nMAP:\nCH:\nINFO: WHITE MALE WHO IS ELDERLY LEANING AGAINST A SEMI-TRUCK WITH\nCAMOFLOUGE SHORTS\nNAME: LORETTA\nPHONE:\nGPS:\nTIME: 12:10:37\nDATE: 08/09/2013\nTime_Dispatched: 2013-08-09 12:10:37\nThis_Unit: 211\nVersion: OHDefianceCounty.20130701",
        "ID:21996",
        "UNIT:211,",
        "CALL:Suspicious Person",
        "CODE:81",
        "SRC:102",
        "PRI:1",
        "PLACE:NEWMAN'S CARRYOUT",
        "ADDR:1421  ST RT 15\\18",
        "MADDR:1421  STATE 15\\18",
        "APT:B",
        "BOX:15 15",
        "X:US 24 and CHRISTY RD",
        "CITY:NOBLE TWP",
        "INFO:WHITE MALE WHO IS ELDERLY LEANING AGAINST A SEMI-TRUCK WITH\nCAMOFLOUGE SHORTS",
        "NAME:LORETTA",
        "TIME:12:10:37",
        "DATE:08/09/2013");
  }

  @Test
  public void testUserFriendlyVersion() {
    doTest("T1",
           "CITY OF WYLIE DISPATCH\n\nCALL: MEDIC CALL- COALITION\nBOX: LUCAS\nADDR: 612 FAIRBROOK CT\nCH: E M S\nCITY: LUCAS",
           "CALL:MEDIC CALL- COALITION",
           "BOX:LUCAS",
           "ADDR:612 FAIRBROOK CT",
           "CH:E M S",
           "CITY:LUCAS");

  }
  
  @Test
  public void testEvergreenFireResecue() {

    doTest("T1",
        "(EFR Call: VEHICLE ACCIDENT #CFS:020713-5) \n" +
        "CALL: VEHICLE ACCIDENT\n" +
        "PLACE: \n" +
        "ADDR: 7256 S BROOK FOREST RD, Evergreen, CO 80439\n" +
        "CITY: EVERGREEN\n" +
        "ID: CFS:020713-5\n" +
        "PRI: 1\n" +
        "DATE: 02/07/2013\n" +
        "TIME: 08:06:12\n" +
        "MAP: http://maps.google.com/maps?q=+39.58827%20-105.35374\n" +
        "UNIT: \n" +
        "INFO: CFS: 020713-5\n" +
        "Hydrant: 677  \n" +
        "Hydrant: 95  \n" +
        "Page 16\n" +
        "FIRE DISTRICT\n" +
        "STATION 8 RESPONSE ZONE\n" +
        "STATION 4 AMB\n" +
        "Cross Streets : S COLUMBINE RD Inc Location changed to 7256 S BROOK FOREST RD at 08:06\n" +
        "FIRE DISTRICT\n" +
        "  ",

        "CALL:VEHICLE ACCIDENT",
        "ADDR:7256 S BROOK FOREST RD, Evergreen, CO 80439",
        "MADDR:7256 S BROOK FOREST RD, Evergreen, COUNTY ROAD 80439",
        "CITY:EVERGREEN",
        "ID:CFS:020713-5",
        "PRI:1",
        "DATE:02/07/2013",
        "TIME:08:06:12",
        "MAP:http://maps.google.com/maps?q=+39.58827%20-105.35374",
        "INFO:CFS: 020713-5\nHydrant: 677  \nHydrant: 95  \nPage 16\nFIRE DISTRICT\nSTATION 8 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : S COLUMBINE RD Inc Location changed to 7256 S BROOK FOREST RD at 08:06\nFIRE DISTRICT");

    doTest("T2",
        "(EFR Call: NAT GAS OR PROPANE LEAK-RESID #CFS:020713-1) \n" +
        "CALL: NAT GAS OR PROPANE LEAK-RESID\n" +
        "PLACE: \n" +
        "ADDR: 7796 CENTAUR DR, Evergreen, CO 80439\n" +
        "CITY: EVERGREEN\n" +
        "ID: CFS:020713-1\n" +
        "PRI: 1\n" +
        "DATE: 02/07/2013\n" +
        "TIME: 00:16:05\n" +
        "MAP: http://maps.google.com/maps?q=+39.57529%20-105.32719\n" +
        "UNIT: \n" +
        "INFO: CFS: 020713-1\n" +
        "Hydrant: 677  \n" +
        "Hydrant: 49  \n" +
        "SD EVERGREEN MEADOWS\n" +
        "SD EVERGREEN MEADOWS\n" +
        "Page 7\n" +
        "FIRE DISTRICT\n" +
        "STATION 3 RESPONSE ZONE\n" +
        "STATION 4 AMB\n" +
        "Cross Streets : NEEDLES TRL EVAC IN PROGRESS\n" +
        "GAS LEAK IN BASEMENT, MAJOR\n" +
        "Inc Location changed to 7796 CENTAUR DR at 00:15\n" +
        "SD EVERGREEN MEADOWS\n" +
        "  ",

        "CALL:NAT GAS OR PROPANE LEAK-RESID",
        "ADDR:7796 CENTAUR DR, Evergreen, CO 80439",
        "MADDR:7796 CENTAUR DR, Evergreen, COUNTY ROAD 80439",
        "CITY:EVERGREEN",
        "ID:CFS:020713-1",
        "PRI:1",
        "DATE:02/07/2013",
        "TIME:00:16:05",
        "MAP:http://maps.google.com/maps?q=+39.57529%20-105.32719",
        "INFO:CFS: 020713-1\nHydrant: 677  \nHydrant: 49  \nSD EVERGREEN MEADOWS\nSD EVERGREEN MEADOWS\nPage 7\nFIRE DISTRICT\nSTATION 3 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : NEEDLES TRL EVAC IN PROGRESS\nGAS LEAK IN BASEMENT, MAJOR\nInc Location changed to 7796 CENTAUR DR at 00:15\nSD EVERGREEN MEADOWS");

    doTest("T3",
        "(EFR Call: FIRE ALARM-COMMERCIAL #CFS:020613-11) \n" +
        "CALL: FIRE ALARM-COMMERCIAL\n" +
        "PLACE: mtn pro tech\n" +
        "ADDR: 30746 BRYANT DR, Evergreen, CO 80439\n" +
        "CITY: EVERGREEN\n" +
        "ID: CFS:020613-11\n" +
        "PRI: 1\n" +
        "DATE: 02/06/2013\n" +
        "TIME: 17:03:13\n" +
        "MAP: http://maps.google.com/maps?q=+39.64955%20-105.34741\n" +
        "UNIT: 316\n" +
        "INFO: CFS: 020613-11\n" +
        "Cross Streets : UNNAMED 2571\n" +
        "Evergreen Auto Works\n" +
        "Evergreen Artisan Park - East\n" +
        "Artisan Park Self Storage\n" +
        "Evergreen Landscapes & Supply\n" +
        "Amber Doe Furnishings & Design\n" +
        "Bergen Homes\n" +
        "Air Dat, LLC\n" +
        "Ward Hardwood Flooring (313)\n" +
        "Ward Hardwood Flooring (314)\n" +
        "Ward Hardwood Flooring (315)\n" +
        "Ward Hardwood Flooring (316)\n" +
        "Katoya Products\n" +
        "Vacant - June 2005 (406)\n" +
        "Vacant - June 2005 (408)\n" +
        "Vacant - June 2005 (416)\n" +
        "EVERGREEN BUSINESS PLAZA\n" +
        "Page 63\n" +
        "FIRE DISTRICT\n" +
        "STATION 2 AMB\n" +
        "STATION 2 RESPONSE ZONE\n" +
        "REC PROPER CODE BUT CANNOT CANCEL\n" +
        "KEY PAD FIRE ALARM\n" +
        "Inc Location changed to 30746 BRYANT DR at 17:00\n" +
        "Artisan Park Self Storage\n" +
        "  ",

        "CALL:FIRE ALARM-COMMERCIAL",
        "PLACE:mtn pro tech",
        "ADDR:30746 BRYANT DR, Evergreen, CO 80439",
        "MADDR:30746 BRYANT DR, Evergreen, COUNTY ROAD 80439",
        "CITY:EVERGREEN",
        "ID:CFS:020613-11",
        "PRI:1",
        "DATE:02/06/2013",
        "TIME:17:03:13",
        "MAP:http://maps.google.com/maps?q=+39.64955%20-105.34741",
        "UNIT:316",
        "INFO:CFS: 020613-11\nCross Streets : UNNAMED 2571\nEvergreen Auto Works\nEvergreen Artisan Park - East\nArtisan Park Self Storage\nEvergreen Landscapes & Supply\nAmber Doe Furnishings & Design\nBergen Homes\nAir Dat, LLC\nWard Hardwood Flooring (313)\nWard Hardwood Flooring (314)\nWard Hardwood Flooring (315)\nWard Hardwood Flooring (316)\nKatoya Products\nVacant - June 2005 (406)\nVacant - June 2005 (408)\nVacant - June 2005 (416)\nEVERGREEN BUSINESS PLAZA\nPage 63\nFIRE DISTRICT\nSTATION 2 AMB\nSTATION 2 RESPONSE ZONE\nREC PROPER CODE BUT CANNOT CANCEL\nKEY PAD FIRE ALARM\nInc Location changed to 30746 BRYANT DR at 17:00\nArtisan Park Self Storage");

    doTest("T4",
        "(EFR Call: MEDICAL RESPONSE #CFS:020613-10) \n" +
        "CALL: MEDICAL RESPONSE\n" +
        "PLACE: \n" +
        "ADDR: 2170 TORREY PINE DR, Evergreen, CO 80439\n" +
        "CITY: EVERGREEN\n" +
        "ID: CFS:020613-10\n" +
        "PRI: 1\n" +
        "DATE: 02/06/2013\n" +
        "TIME: 17:00:27\n" +
        "MAP: http://maps.google.com/maps?q=+39.67513%20-105.36189\n" +
        "UNIT: \n" +
        "INFO: CFS: 020613-10\n" +
        "Hydrant: 169  \n" +
        "Hydrant: 170  \n" +
        "SD HIWAN\n" +
        "SD HIWAN\n" +
        "Page 70\n" +
        "FIRE DISTRICT\n" +
        "STATION 2 AMB\n" +
        "STATION 2 RESPONSE ZONE\n\n\n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "         \n" +
        "Cross Streets : TORREY PINE CIR LIFT ASSIST TO GET PT FROM CAR TO HOUSE\n" +
        "Inc Location changed to 2170 TORREY PINE DR at 17:00\n" +
        "SD HIWAN\n" +
        "  ",

        "CALL:MEDICAL RESPONSE",
        "ADDR:2170 TORREY PINE DR, Evergreen, CO 80439",
        "MADDR:2170 TORREY PINE DR, Evergreen, COUNTY ROAD 80439",
        "CITY:EVERGREEN",
        "ID:CFS:020613-10",
        "PRI:1",
        "DATE:02/06/2013",
        "TIME:17:00:27",
        "MAP:http://maps.google.com/maps?q=+39.67513%20-105.36189",
        "INFO:CFS: 020613-10\nHydrant: 169  \nHydrant: 170  \nSD HIWAN\nSD HIWAN\nPage 70\nFIRE DISTRICT\nSTATION 2 AMB\nSTATION 2 RESPONSE ZONE\n         \n         \n         \n         \n         \n         \n         \n         \n         \n         \nCross Streets : TORREY PINE CIR LIFT ASSIST TO GET PT FROM CAR TO HOUSE\nInc Location changed to 2170 TORREY PINE DR at 17:00\nSD HIWAN");

    doTest("T5",
        "(EFR Call: MEDICAL RESPONSE #CFS:020613-7) \n" +
        "CALL: MEDICAL RESPONSE\n" +
        "PLACE: \n" +
        "ADDR: 31299 MANITOBA DR, Evergreen, CO 80439\n" +
        "CITY: EVERGREEN\n" +
        "ID: CFS:020613-7\n" +
        "PRI: 1\n" +
        "DATE: 02/06/2013\n" +
        "TIME: 13:44:48\n" +
        "MAP: http://maps.google.com/maps?q=+39.59878%20-105.35666\n" +
        "UNIT: \n" +
        "INFO: CFS: 020613-7\n" +
        "Hydrant: 85  \n" +
        "Hydrant: 95  \n" +
        "SD EVERGREEN VALLEY ESTATES\n" +
        "Page 26\n" +
        "FIRE DISTRICT\n" +
        "STATION 8 RESPONSE ZONE\n" +
        "STATION 4 AMB\n" +
        "Cross Streets : SNOWSHOE RD Inc Location changed to 31299 MANITOBA DR at 13:44\n" +
        "Inc Location changed to [NO VALUE] at 13:44\n" +
        "Page 26\n" +
        "  ",

        "CALL:MEDICAL RESPONSE",
        "ADDR:31299 MANITOBA DR, Evergreen, CO 80439",
        "MADDR:31299 MANITOBA DR, Evergreen, COUNTY ROAD 80439",
        "CITY:EVERGREEN",
        "ID:CFS:020613-7",
        "PRI:1",
        "DATE:02/06/2013",
        "TIME:13:44:48",
        "MAP:http://maps.google.com/maps?q=+39.59878%20-105.35666",
        "INFO:CFS: 020613-7\nHydrant: 85  \nHydrant: 95  \nSD EVERGREEN VALLEY ESTATES\nPage 26\nFIRE DISTRICT\nSTATION 8 RESPONSE ZONE\nSTATION 4 AMB\nCross Streets : SNOWSHOE RD Inc Location changed to 31299 MANITOBA DR at 13:44\nInc Location changed to [NO VALUE] at 13:44\nPage 26");

  }
  
  public static void main(String[] args) {
//    new Cadpage2ParserTest().generateTests("T1", "CALL PLACE ADDR CITY ID PRI DATE TIME MAP UNIT INFO");
  }
}