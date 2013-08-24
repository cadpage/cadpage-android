package net.anei.cadpage.parsers.MO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


/*
Polk County, MO

Contact:  Eric Davey <ericleedavey@gmail.com> (Mapping Coordinator,417-298-7448)
Agency Name: Polk County Central Dispatch, Global Dispatch
Sender: 911paging@polkco911.com 

571 S FLINT AV  SICK PERSON/26-C-1 M1780 100 MapRegions: BOLIVAR CrossStreets: E BUFFALO ST 0.03 mi S E MAUPIN ST 0.15 mi N Disp: 4/1/2013 13:07:29 Disp: 4/1/2013 13:07:29
404 E BROADWAY ST MANOR HOUSE FIRE ALARM 100 MapRegions: BOLIVAR CrossStreets: N ALBANY AV 0.03 mi NE N WILSON AV 0.02 mi W Disp: 4/1/2013 6:30:21
1587 E 526TH RD, Apt. #4  HEMORRHAGE/LACERATIONS/21-D-3 300 M1770 MapRegions: E4 CrossStreets: HIGHWAY F 0.24 mi SW S 120TH RD 3.79 mi W Disp: 03/31/13 11:48:44 Disp: 03/31/13 11:48:44
305 E 2ND ST, Apt. 7 FIRE STRUCTURE RESIDENTIAL 600 400 700 MapRegions: Fair Play CrossStreets: ALLEY 0.02 mi SW S BRIER ST 0.02 mi E
HIGHWAY H & E 562ND RD POLK COUNTY TRAFFIC/TRANSPORTATION/29-B-4 MSHP1 200 280 M1780


Contact: Kirk Jones <k.jones@morrisvillefire.org>
Sender: 911paging@polkco911.com
 1 of 2\nFRM:911paging@polkco911.com\nSUBJ:RT:\nMSG:1538 E 490TH RD \n\nSICK PERSON/26-C-2 \nM1720 300 \nMapRegions:  CrossStreets: S 243RD RD\n(Con't) 2 of 2\n6393.32 mi W UNKNOWN 6393.32 mi W \nDisp: 7/1/2013 20:38:39 Disp: 7/1/2013 20:38:39\n\n\n\n(End)

Contact: Active911
Agency name: Bolivar City Fire Department
Location: Bolivar, MO, United States
Sender: 911paging@polkco911.com

(RT:) 0 UNKNOWN \nHERMITAGE AREA \nSICK PERSON/26-C-1 \nM1780 \nMapRegions:  CrossStreets: S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W \nDisp: 8/15/2013 11:30:05
(RT:) 312 S SPRINGFIELD AV \nBOLIVAR MO \nBOLIVAR CITY FIRE STATION 1 \nTEST \n100 \nMapRegions: BOLIVAR CrossStreets: ALLEY 0.05 mi S VAC ALLEY 0.01 mi W
(RT:) 1975 E 558TH RD \n \nCHEST PAIN/10-D-2 \nM1770 200 \nMapRegions: F4 CrossStreets: HIGHWAY H 0.19 mi E \nDisp: 08/15/13 10:49:59 Disp: 08/15/13 10:49:59
(RT:) 342 E BROADWAY ST \nBOLIVAR MO \nPLANTATION MANOR \nSICK PERSON/26-C-1 \nM1780 100 \nMapRegions: BOLIVAR CrossStreets: N BENTON AV 0.04 mi W N WILSON AV 0.03 mi NE \nM1780 100
(RT:) 403 E SUMMIT ST, Apt. 19 \nROSE PARK APARTMENTS \nFALLS/17-A-3 \nM1770 \nMapRegions: BOLIVAR CrossStreets: N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE \nDisp: 8/15/2013 08:08:30
(RT:) HIGHWAY 13 & E 316TH RD \n \nTRAFFIC/TRANSPORTATION/29-B-4 \nM1770 700 \nMapRegions: A1 CrossStreets: \nDisp: 08/15/13 07:22:45 Disp: 08/15/13 07:22:45
(RT:) 702 E BROADWAY ST \nBOLIVAR MO \n \nUNCONSCIOUS/FAINTING/31-D-2 \nM1770 100 \nMapRegions: BOLIVAR CrossStreets: N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E \nM1770 100
(RT:) 702 E BROADWAY ST \n \nUNCONSCIOUS/FAINTING/31-D-2 \nM1770 \nMapRegions: BOLIVAR CrossStreets: N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E \nDisp: 08/15/13 06:02:01
(RT:) 1500 N OAKLAND AV, Apt. 7 \nCMH-CITIZENS MEMORIAL HOSPITAL \nTRANSFER/INTERFACILITY/33-A-3 \nM1720 \nMapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \nDisp: 8/14/2013 20:18:31
(RT:) 102 S BOLIVAR RD \nLAKESHORES \nPSYCHIATRIC/ABNORMAL BEH/25-B-6 \n2370 M1770 \nMapRegions: Humansvill CrossStreets: E HUMAN ST 0.01 mi W N BOLIVAR RD 0.06 mi N \nDisp: 8/14/2013 19:58:08
(RT:) 601 W FOREST ST \nDUNNEGAN PARK \nHEMORRHAGE/LACERATIONS/21-A-1 \nM1720 \nMapRegions: BOLIVAR CrossStreets: ALLEY 0.02 mi W UNKNOWN 0.05 mi E \nDisp: 8/14/2013 18:07:56
(RT:) 1500 N OAKLAND AV, Apt. 1 \nCMH-CITIZENS MEMORIAL HOSPITAL \nTRANSFER/INTERFACILITY/33-A-1 \nM1770 \nMapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \nDisp: 8/14/2013 17:28:23
(RT:) 1690 W BROADWAY ST \nPOLK CO LIBRARY \nBREATHING PROBLEMS/6-D-1 \n100 M1780 \nMapRegions: BOLIVAR CrossStreets: N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E \nDisp: 8/14/2013 15:58:21 Disp: 8/14/2013 15:58:21
(RT:) 1690 W BROADWAY ST \nBOLIVAR MO \nPOLK CO LIBRARY \nBREATHING PROBLEMS/6-D-1 \n100 M1780 \nMapRegions: BOLIVAR CrossStreets: N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E \n100 M1780
(RT:) HIGHWAY H & HIGHWAY 215 \n \nTRAFFIC/TRANSPORTATION/29-B-4 \nM1720 200 915 M1780 \nMapRegions: Pleasant H CrossStreets: \nDisp: 8/14/2013 15:19:21
(RT:) 315 S MAIN AV, Apt. A \nKEMP, RONALD DR \nFALLS/17-A-1 \nM1770 \nMapRegions: BOLIVAR CrossStreets: ALLEY 0.03 mi SE ALLLEY 0.03 mi N \nDisp: 08/14/13 15:08:54
(RT:) HIGHWAY H & HIGHWAY 215 \n \nTRAFFIC/TRANSPORTATION/29-B-4 \nM1720 200 \nMapRegions: Pleasant H CrossStreets: \nDisp: 8/14/2013 14:53:31 Disp: 8/14/2013 14:53:31
(RT:) 464 W MAPLE ST \n \nSTROKE/CVA/28-C-1 \nM1780 100 \nMapRegions: BOLIVAR CrossStreets: S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S \nDisp: 8/14/2013 12:10:25 Disp: 8/14/2013 12:10:25
(RT:) 464 W MAPLE ST \nBOLIVAR MO \n \nSTROKE/CVA/28-C-1 \nM1780 100 \nMapRegions: BOLIVAR CrossStreets: S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S \nM1780 100
(RT:) 201 S ARTHUR ST \nHUMANSVILLE FAMILY CARE CENTER \nTRANSFER/INTERFACILITY/33-C-5 \nM1770 \nMapRegions: Humansvill CrossStreets: W BUFFALO ST 0.03 mi N W TILDEN ST 0.05 mi S \nDisp: 8/14/2013 10:07:56
(RT:) 403 E SUMMIT ST, Apt. 19 \nROSE PARK APARTMENTS \nFALLS/17-B-3 \nM1770 100-1 \nMapRegions: BOLIVAR CrossStreets: N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE \nDisp: 8/14/2013 09:42:31 Disp: 8/14/2013 09:42:31
(RT:) 113 E JEFFERSON ST \nBOLIVAR MO \nPOLK CO JAIL \nCHEST PAIN/10-C-1 \nSJDC 100 \nMapRegions: BOLIVAR CrossStreets: S MAIN AV 0.04 mi SW S SPRINGFIELD AV 0.03 mi SE \nSJDC 100
(RT:) 3808 S 128TH RD \n \nCONVULSIONS/SEIZURES/12-C-1 \nM1780 800 \nMapRegions:  CrossStreets: \nDisp: 8/14/2013 08:58:05 Disp: 8/14/2013 08:58:05
(RT:) 1500 N OAKLAND AV \nCMH-CITIZENS MEMORIAL HOSPITAL \nTRANSFER/INTERFACILITY/33-A-1 \nM1770 \nMapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \nDisp: 8/14/2013 07:39:16
(RT:) 1500 N OAKLAND AV \nCMH-CITIZENS MEMORIAL HOSPITAL \nTRANSFER/INTERFACILTY/33-C-2 \nM1720 \nMapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \nDisp: 8/13/2013 22:50:10
(RT:) 5409 S 175TH RD \n \nCHEST PAIN/10-C-2 \nM1720 \nMapRegions:  CrossStreets: E 355TH RD 6399.18 mi W E 360TH RD 6399.24 mi W \nDisp: 8/13/2013 21:15:23
(RT:) 1500 N OAKLAND AV \nCMH-CITIZENS MEMORIAL HOSPITAL \nTRANSFER/INTERFACILITY/33-A-3 \nM1770 \nMapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \nDisp: 8/13/2013 20:21:02
(RT:) 2503 S ORCHARD AV \nBOLIVAR MO \n \nFIRE STRUCTURE RESIDENTIAL \n100 \nMapRegions: BOLIVAR CrossStreets: W WOLLARD ST 0.03 mi NE W PEARL ST 0.03 mi SE \n100
(RT:) 0 UNKNOWN \nPRESTON AREA \nTRAFFIC/TRANSPORTATION/29-D-2 \nM1770 \nMapRegions:  CrossStreets: S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W \nDisp: 8/13/2013 20:05:41
(RT:) 210 W SOUTH ST, Apt. 3 \nBOLIVAR MO \nJS MORGAN LLC \nSICK PERSON/26-D-1 \nM1770 100 \nMapRegions: BOLIVAR CrossStreets: S MISSOURI AV 0.05 mi N S MILL AV 0.16 mi W \nM1770 100

*/

public class MOPolkCountyParserTest extends BaseParserTest {
  
  public MOPolkCountyParserTest() {
    setParser(new MOPolkCountyParser(), "POLK COUNTY", "MO");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "571 S FLINT AV  SICK PERSON/26-C-1 M1780 100 MapRegions: BOLIVAR CrossStreets: E BUFFALO ST 0.03 mi S E MAUPIN ST 0.15 mi N Disp: 4/1/2013 13:07:29 Disp: 4/1/2013 13:07:29",
        "UNIT:M1780 100",
        "ADDR:571 S FLINT AV",
        "MADDR:571 S FLINT AVE",
        "CALL:SICK PERSON",
        "CODE:26-C-1",
        "CITY:BOLIVAR",
        "X:E BUFFALO ST 0.03 mi S E MAUPIN ST 0.15 mi N",
        "DATE:4/1/2013",
        "TIME:13:07:29");

    doTest("T2",
        "404 E BROADWAY ST MANOR HOUSE FIRE ALARM 100 MapRegions: BOLIVAR CrossStreets: N ALBANY AV 0.03 mi NE N WILSON AV 0.02 mi W Disp: 4/1/2013 6:30:21",
        "UNIT:100",
        "ADDR:404 E BROADWAY ST",
        "CALL:MANOR HOUSE FIRE ALARM",
        "CITY:BOLIVAR",
        "X:N ALBANY AV 0.03 mi NE N WILSON AV 0.02 mi W",
        "DATE:4/1/2013",
        "TIME:6:30:21");

    doTest("T3",
        "1587 E 526TH RD, Apt. #4  HEMORRHAGE/LACERATIONS/21-D-3 300 M1770 MapRegions: E4 CrossStreets: HIGHWAY F 0.24 mi SW S 120TH RD 3.79 mi W Disp: 03/31/13 11:48:44 Disp: 03/31/13 11:48:44",
        "UNIT:300 M1770",
        "ADDR:1587 E 526TH RD",
        "APT:#4",
        "CALL:HEMORRHAGE/LACERATIONS",
        "CODE:21-D-3",
        "MAP:E4",
        "X:HIGHWAY F 0.24 mi SW S 120TH RD 3.79 mi W",
        "DATE:03/31/13",
        "TIME:11:48:44");

    doTest("T4",
        "305 E 2ND ST, Apt. 7 FIRE STRUCTURE RESIDENTIAL 600 400 700 MapRegions: Fair Play CrossStreets: ALLEY 0.02 mi SW S BRIER ST 0.02 mi E",
        "UNIT:600 400 700",
        "ADDR:305 E 2ND ST",
        "APT:7",
        "CALL:FIRE STRUCTURE RESIDENTIAL",
        "CITY:Fair Play",
        "X:ALLEY 0.02 mi SW S BRIER ST 0.02 mi E");

    doTest("T5",
        "HIGHWAY H & E 562ND RD POLK COUNTY TRAFFIC/TRANSPORTATION/29-B-4 MSHP1 200 280 M1780",
        "UNIT:MSHP1 200 280 M1780",
        "ADDR:HIGHWAY H & E 562ND RD",  // Not mapping
        "CALL:TRAFFIC/TRANSPORTATION",
        "CODE:29-B-4");
   
  }
  
  @Test
  public void testKirkJones() {

        doTest("T1",
            " 1 of 2\n" +
            "FRM:911paging@polkco911.com\n" +
            "SUBJ:RT:\n" +
            "MSG:1538 E 490TH RD \n\n" +
            "SICK PERSON/26-C-2 \n" +
            "M1720 300 \n" +
            "MapRegions:  CrossStreets: S 243RD RD\n" +
            "(Con't) 2 of 2\n" +
            "6393.32 mi W UNKNOWN 6393.32 mi W \n" +
            "Disp: 7/1/2013 20:38:39 Disp: 7/1/2013 20:38:39\n\n\n\n" +
            "(End)",

            "ADDR:1538 E 490TH RD",
            "CALL:SICK PERSON",
            "CODE:26-C-2",
            "UNIT:M1720 300",
            "X:S 243RD RD 6393.32 mi W UNKNOWN 6393.32 mi W",
            "DATE:7/1/2013",
            "TIME:20:38:39");
        

  }
  
  @Test
  public void testBolivarCityFireDepartment() {

    doTest("T1",
        "(RT:) 0 UNKNOWN \n" +
        "HERMITAGE AREA \n" +
        "SICK PERSON/26-C-1 \n" +
        "M1780 \n" +
        "MapRegions:  CrossStreets: S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W \n" +
        "Disp: 8/15/2013 11:30:05",

        "ADDR:UNKNOWN",
        "MADDR:UNKNOWN & S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W",
        "PLACE:HERMITAGE AREA",
        "CALL:SICK PERSON",
        "CODE:26-C-1",
        "UNIT:M1780",
        "X:S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W",
        "DATE:8/15/2013",
        "TIME:11:30:05");

    doTest("T2",
        "(RT:) 312 S SPRINGFIELD AV \n" +
        "BOLIVAR MO \n" +
        "BOLIVAR CITY FIRE STATION 1 \n" +
        "TEST \n" +
        "100 \n" +
        "MapRegions: BOLIVAR CrossStreets: ALLEY 0.05 mi S VAC ALLEY 0.01 mi W",

        "ADDR:312 S SPRINGFIELD AV",
        "MADDR:312 S SPRINGFIELD AVE",
        "CITY:BOLIVAR",
        "PLACE:BOLIVAR CITY FIRE STATION 1",
        "CALL:TEST",
        "UNIT:100",
        "X:ALLEY 0.05 mi S VAC ALLEY 0.01 mi W");

    doTest("T3",
        "(RT:) 1975 E 558TH RD \n" +
        " \n" +
        "CHEST PAIN/10-D-2 \n" +
        "M1770 200 \n" +
        "MapRegions: F4 CrossStreets: HIGHWAY H 0.19 mi E \n" +
        "Disp: 08/15/13 10:49:59 Disp: 08/15/13 10:49:59",

        "ADDR:1975 E 558TH RD",
        "CALL:CHEST PAIN",
        "CODE:10-D-2",
        "UNIT:M1770 200",
        "MAP:F4",
        "X:HIGHWAY H 0.19 mi E",
        "DATE:08/15/13",
        "TIME:10:49:59");

    doTest("T4",
        "(RT:) 342 E BROADWAY ST \n" +
        "BOLIVAR MO \n" +
        "PLANTATION MANOR \n" +
        "SICK PERSON/26-C-1 \n" +
        "M1780 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: N BENTON AV 0.04 mi W N WILSON AV 0.03 mi NE \n" +
        "M1780 100",

        "ADDR:342 E BROADWAY ST",
        "CITY:BOLIVAR",
        "PLACE:M1780 100",
        "CALL:SICK PERSON",
        "CODE:26-C-1",
        "UNIT:M1780 100",
        "X:N BENTON AV 0.04 mi W N WILSON AV 0.03 mi NE");

    doTest("T5",
        "(RT:) 403 E SUMMIT ST, Apt. 19 \n" +
        "ROSE PARK APARTMENTS \n" +
        "FALLS/17-A-3 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE \n" +
        "Disp: 8/15/2013 08:08:30",

        "ADDR:403 E SUMMIT ST",
        "APT:19",
        "PLACE:ROSE PARK APARTMENTS",
        "CALL:FALLS",
        "CODE:17-A-3",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE",
        "DATE:8/15/2013",
        "TIME:08:08:30");

    doTest("T6",
        "(RT:) HIGHWAY 13 & E 316TH RD \n" +
        " \n" +
        "TRAFFIC/TRANSPORTATION/29-B-4 \n" +
        "M1770 700 \n" +
        "MapRegions: A1 CrossStreets: \n" +
        "Disp: 08/15/13 07:22:45 Disp: 08/15/13 07:22:45",

        "ADDR:HIGHWAY 13 & E 316TH RD",
        "CALL:TRAFFIC/TRANSPORTATION",
        "CODE:29-B-4",
        "UNIT:M1770 700",
        "MAP:A1",
        "DATE:08/15/13",
        "TIME:07:22:45");

    doTest("T7",
        "(RT:) 702 E BROADWAY ST \n" +
        "BOLIVAR MO \n" +
        " \n" +
        "UNCONSCIOUS/FAINTING/31-D-2 \n" +
        "M1770 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E \n" +
        "M1770 100",

        "ADDR:702 E BROADWAY ST",
        "CITY:BOLIVAR",
        "PLACE:M1770 100",
        "CALL:UNCONSCIOUS/FAINTING",
        "CODE:31-D-2",
        "UNIT:M1770 100",
        "X:N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E");

    doTest("T8",
        "(RT:) 702 E BROADWAY ST \n" +
        " \n" +
        "UNCONSCIOUS/FAINTING/31-D-2 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E \n" +
        "Disp: 08/15/13 06:02:01",

        "ADDR:702 E BROADWAY ST",
        "CALL:UNCONSCIOUS/FAINTING",
        "CODE:31-D-2",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:N BOSTON AV 0.02 mi N N CHICAGO AV 0.09 mi E",
        "DATE:08/15/13",
        "TIME:06:02:01");

    doTest("T9",
        "(RT:) 1500 N OAKLAND AV, Apt. 7 \n" +
        "CMH-CITIZENS MEMORIAL HOSPITAL \n" +
        "TRANSFER/INTERFACILITY/33-A-3 \n" +
        "M1720 \n" +
        "MapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \n" +
        "Disp: 8/14/2013 20:18:31",

        "ADDR:1500 N OAKLAND AV",
        "MADDR:1500 N OAKLAND AVE",
        "APT:7",
        "PLACE:CMH-CITIZENS MEMORIAL HOSPITAL",
        "CALL:TRANSFER/INTERFACILITY",
        "CODE:33-A-3",
        "UNIT:M1720",
        "CITY:BOLIVAR",
        "X:HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S",
        "DATE:8/14/2013",
        "TIME:20:18:31");

    doTest("T10",
        "(RT:) 102 S BOLIVAR RD \n" +
        "LAKESHORES \n" +
        "PSYCHIATRIC/ABNORMAL BEH/25-B-6 \n" +
        "2370 M1770 \n" +
        "MapRegions: Humansvill CrossStreets: E HUMAN ST 0.01 mi W N BOLIVAR RD 0.06 mi N \n" +
        "Disp: 8/14/2013 19:58:08",

        "ADDR:102 S BOLIVAR RD",
        "PLACE:LAKESHORES",
        "CALL:PSYCHIATRIC/ABNORMAL BEH",
        "CODE:25-B-6",
        "UNIT:2370 M1770",
        "CITY:Humansville",
        "X:E HUMAN ST 0.01 mi W N BOLIVAR RD 0.06 mi N",
        "DATE:8/14/2013",
        "TIME:19:58:08");

    doTest("T11",
        "(RT:) 601 W FOREST ST \n" +
        "DUNNEGAN PARK \n" +
        "HEMORRHAGE/LACERATIONS/21-A-1 \n" +
        "M1720 \n" +
        "MapRegions: BOLIVAR CrossStreets: ALLEY 0.02 mi W UNKNOWN 0.05 mi E \n" +
        "Disp: 8/14/2013 18:07:56",

        "ADDR:601 W FOREST ST",
        "PLACE:DUNNEGAN PARK",
        "CALL:HEMORRHAGE/LACERATIONS",
        "CODE:21-A-1",
        "UNIT:M1720",
        "CITY:BOLIVAR",
        "X:ALLEY 0.02 mi W UNKNOWN 0.05 mi E",
        "DATE:8/14/2013",
        "TIME:18:07:56");

    doTest("T12",
        "(RT:) 1500 N OAKLAND AV, Apt. 1 \n" +
        "CMH-CITIZENS MEMORIAL HOSPITAL \n" +
        "TRANSFER/INTERFACILITY/33-A-1 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \n" +
        "Disp: 8/14/2013 17:28:23",

        "ADDR:1500 N OAKLAND AV",
        "MADDR:1500 N OAKLAND AVE",
        "APT:1",
        "PLACE:CMH-CITIZENS MEMORIAL HOSPITAL",
        "CALL:TRANSFER/INTERFACILITY",
        "CODE:33-A-1",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S",
        "DATE:8/14/2013",
        "TIME:17:28:23");

    doTest("T13",
        "(RT:) 1690 W BROADWAY ST \n" +
        "POLK CO LIBRARY \n" +
        "BREATHING PROBLEMS/6-D-1 \n" +
        "100 M1780 \n" +
        "MapRegions: BOLIVAR CrossStreets: N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E \n" +
        "Disp: 8/14/2013 15:58:21 Disp: 8/14/2013 15:58:21",

        "ADDR:1690 W BROADWAY ST",
        "PLACE:POLK CO LIBRARY",
        "CALL:BREATHING PROBLEMS",
        "CODE:6-D-1",
        "UNIT:100 M1780",
        "CITY:BOLIVAR",
        "X:N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E",
        "DATE:8/14/2013",
        "TIME:15:58:21");

    doTest("T14",
        "(RT:) 1690 W BROADWAY ST \n" +
        "BOLIVAR MO \n" +
        "POLK CO LIBRARY \n" +
        "BREATHING PROBLEMS/6-D-1 \n" +
        "100 M1780 \n" +
        "MapRegions: BOLIVAR CrossStreets: N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E \n" +
        "100 M1780",

        "ADDR:1690 W BROADWAY ST",
        "CITY:BOLIVAR",
        "PLACE:100 M1780",
        "CALL:BREATHING PROBLEMS",
        "CODE:6-D-1",
        "UNIT:100 M1780",
        "X:N SUNSET AV 0.06 mi N S BARKER AV 0.19 mi E");

    doTest("T15",
        "(RT:) HIGHWAY H & HIGHWAY 215 \n" +
        " \n" +
        "TRAFFIC/TRANSPORTATION/29-B-4 \n" +
        "M1720 200 915 M1780 \n" +
        "MapRegions: Pleasant H CrossStreets: \n" +
        "Disp: 8/14/2013 15:19:21",

        "ADDR:HIGHWAY H & HIGHWAY 215",
        "CALL:TRAFFIC/TRANSPORTATION",
        "CODE:29-B-4",
        "UNIT:M1720 200 915 M1780",
        "CITY:Pleasant Hope",
        "DATE:8/14/2013",
        "TIME:15:19:21");

    doTest("T16",
        "(RT:) 315 S MAIN AV, Apt. A \n" +
        "KEMP, RONALD DR \n" +
        "FALLS/17-A-1 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: ALLEY 0.03 mi SE ALLLEY 0.03 mi N \n" +
        "Disp: 08/14/13 15:08:54",

        "ADDR:315 S MAIN AV",
        "MADDR:315 S MAIN AVE",
        "APT:A",
        "PLACE:KEMP, RONALD DR",
        "CALL:FALLS",
        "CODE:17-A-1",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:ALLEY 0.03 mi SE ALLLEY 0.03 mi N",
        "DATE:08/14/13",
        "TIME:15:08:54");

    doTest("T17",
        "(RT:) HIGHWAY H & HIGHWAY 215 \n" +
        " \n" +
        "TRAFFIC/TRANSPORTATION/29-B-4 \n" +
        "M1720 200 \n" +
        "MapRegions: Pleasant H CrossStreets: \n" +
        "Disp: 8/14/2013 14:53:31 Disp: 8/14/2013 14:53:31",

        "ADDR:HIGHWAY H & HIGHWAY 215",
        "CALL:TRAFFIC/TRANSPORTATION",
        "CODE:29-B-4",
        "UNIT:M1720 200",
        "CITY:Pleasant Hope",
        "DATE:8/14/2013",
        "TIME:14:53:31");

    doTest("T18",
        "(RT:) 464 W MAPLE ST \n" +
        " \n" +
        "STROKE/CVA/28-C-1 \n" +
        "M1780 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S \n" +
        "Disp: 8/14/2013 12:10:25 Disp: 8/14/2013 12:10:25",

        "ADDR:464 W MAPLE ST",
        "CALL:STROKE/CVA",
        "CODE:28-C-1",
        "UNIT:M1780 100",
        "CITY:BOLIVAR",
        "X:S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S",
        "DATE:8/14/2013",
        "TIME:12:10:25");

    doTest("T19",
        "(RT:) 464 W MAPLE ST \n" +
        "BOLIVAR MO \n" +
        " \n" +
        "STROKE/CVA/28-C-1 \n" +
        "M1780 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S \n" +
        "M1780 100",

        "ADDR:464 W MAPLE ST",
        "CITY:BOLIVAR",
        "PLACE:M1780 100",
        "CALL:STROKE/CVA",
        "CODE:28-C-1",
        "UNIT:M1780 100",
        "X:S PIKE AV 0.09 mi E E MAPLE ST 8.08 mi S");

    doTest("T20",
        "(RT:) 201 S ARTHUR ST \n" +
        "HUMANSVILLE FAMILY CARE CENTER \n" +
        "TRANSFER/INTERFACILITY/33-C-5 \n" +
        "M1770 \n" +
        "MapRegions: Humansvill CrossStreets: W BUFFALO ST 0.03 mi N W TILDEN ST 0.05 mi S \n" +
        "Disp: 8/14/2013 10:07:56",

        "ADDR:201 S ARTHUR ST",
        "PLACE:HUMANSVILLE FAMILY CARE CENTER",
        "CALL:TRANSFER/INTERFACILITY",
        "CODE:33-C-5",
        "UNIT:M1770",
        "CITY:Humansville",
        "X:W BUFFALO ST 0.03 mi N W TILDEN ST 0.05 mi S",
        "DATE:8/14/2013",
        "TIME:10:07:56");

    doTest("T21",
        "(RT:) 403 E SUMMIT ST, Apt. 19 \n" +
        "ROSE PARK APARTMENTS \n" +
        "FALLS/17-B-3 \n" +
        "M1770 100-1 \n" +
        "MapRegions: BOLIVAR CrossStreets: N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE \n" +
        "Disp: 8/14/2013 09:42:31 Disp: 8/14/2013 09:42:31",

        "ADDR:403 E SUMMIT ST",
        "APT:19",
        "PLACE:ROSE PARK APARTMENTS",
        "CALL:FALLS",
        "CODE:17-B-3",
        "UNIT:M1770 100-1",
        "CITY:BOLIVAR",
        "X:N MARKET AV 0.14 mi SW N WATER AV 0.15 mi SE",
        "DATE:8/14/2013",
        "TIME:09:42:31");

    doTest("T22",
        "(RT:) 113 E JEFFERSON ST \n" +
        "BOLIVAR MO \n" +
        "POLK CO JAIL \n" +
        "CHEST PAIN/10-C-1 \n" +
        "SJDC 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: S MAIN AV 0.04 mi SW S SPRINGFIELD AV 0.03 mi SE \n" +
        "SJDC 100",

        "ADDR:113 E JEFFERSON ST",
        "CITY:BOLIVAR",
        "PLACE:SJDC 100",
        "CALL:CHEST PAIN",
        "CODE:10-C-1",
        "UNIT:SJDC 100",
        "X:S MAIN AV 0.04 mi SW S SPRINGFIELD AV 0.03 mi SE");

    doTest("T23",
        "(RT:) 3808 S 128TH RD \n" +
        " \n" +
        "CONVULSIONS/SEIZURES/12-C-1 \n" +
        "M1780 800 \n" +
        "MapRegions:  CrossStreets: \n" +
        "Disp: 8/14/2013 08:58:05 Disp: 8/14/2013 08:58:05",

        "ADDR:3808 S 128TH RD",
        "CALL:CONVULSIONS/SEIZURES",
        "CODE:12-C-1",
        "UNIT:M1780 800",
        "DATE:8/14/2013",
        "TIME:08:58:05");

    doTest("T24",
        "(RT:) 1500 N OAKLAND AV \n" +
        "CMH-CITIZENS MEMORIAL HOSPITAL \n" +
        "TRANSFER/INTERFACILITY/33-A-1 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \n" +
        "Disp: 8/14/2013 07:39:16",

        "ADDR:1500 N OAKLAND AV",
        "MADDR:1500 N OAKLAND AVE",
        "PLACE:CMH-CITIZENS MEMORIAL HOSPITAL",
        "CALL:TRANSFER/INTERFACILITY",
        "CODE:33-A-1",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S",
        "DATE:8/14/2013",
        "TIME:07:39:16");

    doTest("T25",
        "(RT:) 1500 N OAKLAND AV \n" +
        "CMH-CITIZENS MEMORIAL HOSPITAL \n" +
        "TRANSFER/INTERFACILTY/33-C-2 \n" +
        "M1720 \n" +
        "MapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \n" +
        "Disp: 8/13/2013 22:50:10",

        "ADDR:1500 N OAKLAND AV",
        "MADDR:1500 N OAKLAND AVE",
        "PLACE:CMH-CITIZENS MEMORIAL HOSPITAL",
        "CALL:TRANSFER/INTERFACILTY",
        "CODE:33-C-2",
        "UNIT:M1720",
        "CITY:BOLIVAR",
        "X:HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S",
        "DATE:8/13/2013",
        "TIME:22:50:10");

    doTest("T26",
        "(RT:) 5409 S 175TH RD \n" +
        " \n" +
        "CHEST PAIN/10-C-2 \n" +
        "M1720 \n" +
        "MapRegions:  CrossStreets: E 355TH RD 6399.18 mi W E 360TH RD 6399.24 mi W \n" +
        "Disp: 8/13/2013 21:15:23",

        "ADDR:5409 S 175TH RD",
        "CALL:CHEST PAIN",
        "CODE:10-C-2",
        "UNIT:M1720",
        "X:E 355TH RD 6399.18 mi W E 360TH RD 6399.24 mi W",
        "DATE:8/13/2013",
        "TIME:21:15:23");

    doTest("T27",
        "(RT:) 1500 N OAKLAND AV \n" +
        "CMH-CITIZENS MEMORIAL HOSPITAL \n" +
        "TRANSFER/INTERFACILITY/33-A-3 \n" +
        "M1770 \n" +
        "MapRegions: BOLIVAR CrossStreets: HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S \n" +
        "Disp: 8/13/2013 20:21:02",

        "ADDR:1500 N OAKLAND AV",
        "MADDR:1500 N OAKLAND AVE",
        "PLACE:CMH-CITIZENS MEMORIAL HOSPITAL",
        "CALL:TRANSFER/INTERFACILITY",
        "CODE:33-A-3",
        "UNIT:M1770",
        "CITY:BOLIVAR",
        "X:HIGHWAY 83 0.10 mi S W FOREST ST 0.10 mi S",
        "DATE:8/13/2013",
        "TIME:20:21:02");

    doTest("T28",
        "(RT:) 2503 S ORCHARD AV \n" +
        "BOLIVAR MO \n" +
        " \n" +
        "FIRE STRUCTURE RESIDENTIAL \n" +
        "100 \n" +
        "MapRegions: BOLIVAR CrossStreets: W WOLLARD ST 0.03 mi NE W PEARL ST 0.03 mi SE \n" +
        "100",

        "ADDR:2503 S ORCHARD AV",
        "MADDR:2503 S ORCHARD AVE",
        "CITY:BOLIVAR",
        "PLACE:100",
        "CALL:FIRE STRUCTURE RESIDENTIAL",
        "UNIT:100",
        "X:W WOLLARD ST 0.03 mi NE W PEARL ST 0.03 mi SE");

    doTest("T29",
        "(RT:) 0 UNKNOWN \n" +
        "PRESTON AREA \n" +
        "TRAFFIC/TRANSPORTATION/29-D-2 \n" +
        "M1770 \n" +
        "MapRegions:  CrossStreets: S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W \n" +
        "Disp: 8/13/2013 20:05:41",

        "ADDR:UNKNOWN",
        "MADDR:UNKNOWN & S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W",
        "PLACE:PRESTON AREA",
        "CALL:TRAFFIC/TRANSPORTATION",
        "CODE:29-D-2",
        "UNIT:M1770",
        "X:S 243RD RD 6393.32 mi W E 490TH RD 6393.32 mi W",
        "DATE:8/13/2013",
        "TIME:20:05:41");

    doTest("T30",
        "(RT:) 210 W SOUTH ST, Apt. 3 \n" +
        "BOLIVAR MO \n" +
        "JS MORGAN LLC \n" +
        "SICK PERSON/26-D-1 \n" +
        "M1770 100 \n" +
        "MapRegions: BOLIVAR CrossStreets: S MISSOURI AV 0.05 mi N S MILL AV 0.16 mi W \n" +
        "M1770 100",

        "ADDR:210 W SOUTH ST",
        "APT:3",
        "CITY:BOLIVAR",
        "PLACE:M1770 100",
        "CALL:SICK PERSON",
        "CODE:26-D-1",
        "UNIT:M1770 100",
        "X:S MISSOURI AV 0.05 mi N S MILL AV 0.16 mi W");

  }
  
  public static void main(String[] args) {
    new MOPolkCountyParserTest().generateTests("T1");
  }
}