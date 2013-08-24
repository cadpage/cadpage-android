package net.anei.cadpage.parsers.LA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Beauregard Parish, LA 
Contact: Clarence Dyson <cdnee13115@gmail.com>
Contact: CAD ALERTS

FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/2/2013 1:15:39 PM\n\nPASTURE FIRE BETWEEN 550 AND 613 GAYTINE RD, NO STRUCTURES IN IMMEDIATE DANGER
FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/1/2013 6:57:48 PM\n\n276 JARED RD LANDING ZONE
FRM:CAD ALERTS\nSUBJ:GORDO\nMSG:at: 7/6/2013 4:16:13 AM\n\nCALCASIEU 911 REQUESTING GORDON FD FOR DEQUINCY FD - MANPOWER ONLY - 110 SOUTH HOLLY ST - CROSS STREETS ARE EAST CENTER AND EAST HARRISON
FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/7/2013 7:40:41 PM\n\nLANDING ZONE NEEDED FOR AIRMED AT 244 HUNTER RD\n  Meadow village fire department 
FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/6/2013 2:15:59 PM\n\nSMALL GRASS FIRE NEAR INTERSECTION OF CAMP EDGEWOOD RD AND HWY 171\nMeadow village fire department 
FRM:CAD ALERTS\nSUBJ:BROAD,GORDO,LONGV,MEADO,TEXAS,RAGLE\nMSG:at: 7/8/2013 9:50:18 PM\n\n959 PEIRCE RD HOUSE FIRE GORDON AREA
FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/9/2013 5:40:33 PM\n\n10-22 ALL MEADOW VILLAGE UNITS NOT ON SCENE AT 3710 CAMP EDGEWOOD RD PER GORDON 5

 */
public class LABeauregardParishParserTest extends BaseParserTest {
  
  public LABeauregardParishParserTest() {
    setParser(new LABeauregardParishParser(), "BEAUREGARD PARISH", "LA");
  }
  
  @Test
  public void testClarenceDyson() {

    doTest("T1",
        "FRM:CAD ALERTS\n" +
        "SUBJ:MEADO\n" +
        "MSG:at: 7/2/2013 1:15:39 PM\n\n" +
        "PASTURE FIRE BETWEEN 550 AND 613 GAYTINE RD, NO STRUCTURES IN IMMEDIATE DANGER",

        "SRC:MEADO",
        "DATE:7/2/2013",
        "TIME:13:15:39",
        "CALL:PASTURE FIRE",
        "ADDR:550-613 GAYTINE RD",
        "MADDR:550 GAYTINE RD",
        "INFO:NO STRUCTURES IN IMMEDIATE DANGER");

    doTest("T2",
        "FRM:CAD ALERTS\nSUBJ:MEADO\nMSG:at: 7/1/2013 6:57:48 PM\n\n276 JARED RD LANDING ZONE",
        "SRC:MEADO",
        "DATE:7/1/2013",
        "TIME:18:57:48",
        "CALL:LANDING ZONE",
        "ADDR:276 JARED RD");

    doTest("T3",
        "FRM:CAD ALERTS\n" +
        "SUBJ:GORDO\n" +
        "MSG:at: 7/6/2013 4:16:13 AM\n\n" +
        "CALCASIEU 911 REQUESTING GORDON FD FOR DEQUINCY FD - MANPOWER ONLY - 110 SOUTH HOLLY ST - CROSS STREETS ARE EAST CENTER AND EAST HARRISON",

        "SRC:GORDO",
        "DATE:7/6/2013",
        "TIME:04:16:13",
        "CALL:CALCASIEU 911 REQUESTING GORDON FD FOR DEQUINCY FD - MANPOWER ONLY",
        "ADDR:110 SOUTH HOLLY ST",
        "INFO:CROSS STREETS ARE EAST CENTER AND EAST HARRISON");

    doTest("T4",
        "FRM:CAD ALERTS\n" +
        "SUBJ:MEADO\n" +
        "MSG:at: 7/7/2013 7:40:41 PM\n\n" +
        "LANDING ZONE NEEDED FOR AIRMED AT 244 HUNTER RD\n" +
        "  Meadow village fire department ",

        "SRC:MEADO",
        "DATE:7/7/2013",
        "TIME:19:40:41",
        "CALL:LANDING ZONE NEEDED FOR AIRMED",
        "ADDR:244 HUNTER RD",
        "INFO:Meadow village fire department");

    doTest("T5",
        "FRM:CAD ALERTS\n" +
        "SUBJ:MEADO\n" +
        "MSG:at: 7/6/2013 2:15:59 PM\n\n" +
        "SMALL GRASS FIRE NEAR INTERSECTION OF CAMP EDGEWOOD RD AND HWY 171\n" +
        "Meadow village fire department ",

        "SRC:MEADO",
        "DATE:7/6/2013",
        "TIME:14:15:59",
        "CALL:SMALL GRASS FIRE NEAR",
        "ADDR:CAMP EDGEWOOD RD AND HWY 171",
        "MADDR:CAMP EDGEWOOD RD & HWY 171",
        "INFO:Meadow village fire department");

    doTest("T6",
        "FRM:CAD ALERTS\nSUBJ:BROAD,GORDO,LONGV,MEADO,TEXAS,RAGLE\nMSG:at: 7/8/2013 9:50:18 PM\n\n959 PEIRCE RD HOUSE FIRE GORDON AREA",
        "SRC:BROAD,GORDO,LONGV,MEADO,TEXAS,RAGLE",
        "DATE:7/8/2013",
        "TIME:21:50:18",
        "CALL:HOUSE FIRE GORDON AREA",
        "ADDR:959 PEIRCE RD");

    doTest("T7",
        "FRM:CAD ALERTS\n" +
        "SUBJ:MEADO\n" +
        "MSG:at: 7/9/2013 5:40:33 PM\n\n" +
        "10-22 ALL MEADOW VILLAGE UNITS NOT ON SCENE AT 3710 CAMP EDGEWOOD RD PER GORDON 5",

        "SRC:MEADO",
        "DATE:7/9/2013",
        "TIME:17:40:33",
        "CALL:10-22 ALL MEADOW VILLAGE UNITS NOT ON SCENE",
        "ADDR:3710 CAMP EDGEWOOD RD",
        "INFO:PER GORDON 5");

  }
  
  public static void main(String[] args) {
    new LABeauregardParishParserTest().generateTests("T1");
  }
}