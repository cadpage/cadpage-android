package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Suffolk County, NY (Variant G)

Contact: Erik DePasquale <edepasquale@commackfd.org>
Sender: commackfd@gmail.com
13 Commercial Automatic Alarm \n TOA: 08:54 07-16-13 \n1815 JERICHO TPKE, HUNTINGTON ,NY '\n RETRO FITNESS \n\n CS: STOWE AVE / ELWOOD RD

Contact: Active911
Agency name: Commack Fire Department
Location: Commack, NY, United States
From: commackfd@gmail.com

23 Wires \n TOA: 20:00 06-22-13 \n16 BARRE PL, HUNTINGTON ,NY '\n  \n\n CS: STOWE AVE / WARE AVE \n Commack Fire District \n 2013-000559 \nH1: HYDRANTS\nI/F/O #2\nI/F/O #2\nI/F/O #2 \n Child/Elder \n STA2 \n STA3 \n A-5
23 Motor Vehicle Accident \n TOA: 15:51 06-22-13 \nCOMMACK RD, ,NY '\n  \n\n CS: NEW HWY \n Commack Fire District \n 2013-000558 \n STA3 \n STA2
13 Commercial Automatic Alarm \n TOA: 15:43 06-22-13 \n148 JERICHO TPKE, COMMACK ,NY '\n THE GAP \n\n CS: MAYFAIR TER / WALTER CT \n Commack Fire District \n 2013-000557 \nH1: PRIMARY - EXP 4 OF STRIP          SECONDARY - JERI \nJERICHO TPKE CLICK ON AREA IMAGES FOR EMERGENCY CONTACT INFO \n Suppression \n STA4 \n STA3 \n F-4
23 Misc \n TOA: 15:02 06-22-13 \nNB SUNKEN MEADOW PKY, COMMACK ,NY '\n  \n\n CS: JERICHO TPKE / INDIAN HEAD RD \n Commack Fire District \n 2013-000556
SIGNAL 323 Gas Leak (Outside) \n TOA: 11:29 06-22-13 \n438 TOWNLINE RD, COMMACK ,NY '\n  \n\n CS: MAPLE MALL / DOVECOTE LN \n Commack Fire District \n 2013-000555 \nH1: HYDRANTS\nC/O MAPLELAWN & TOWNLINE                 \n Child/Elder \n STA4 \n STA3
23 Gas Leak (Outside) \n TOA: 11:29 06-22-13 \n438 TOWNLINE RD, COMMACK ,NY '\n  \n\n CS: MAPLE MALL / DOVECOTE LN \n Commack Fire District \n 2013-000555 \nH1: HYDRANTS\nC/O MAPLELAWN & TOWNLINE                 \n Child/Elder \n STA4 \n STA3

*/

public class NYSuffolkCountyGParserTest extends BaseParserTest {
  
  public NYSuffolkCountyGParserTest() {
    setParser(new NYSuffolkCountyGParser(), "SUFFOLK COUNTY", "NY");
  }
  
  @Test
  public void testErikDePasquale() {

    doTest("T1",
        "13 Commercial Automatic Alarm \n" +
        " TOA: 08:54 07-16-13 \n" +
        "1815 JERICHO TPKE, HUNTINGTON ,NY '\n" +
        " RETRO FITNESS \n\n" +
        " CS: STOWE AVE / ELWOOD RD",

        "CALL:13 Commercial Automatic Alarm",
        "TIME:08:54",
        "DATE:07/16/13",
        "ADDR:1815 JERICHO TPKE",
        "CITY:HUNTINGTON",
        "PLACE:RETRO FITNESS",
        "X:STOWE AVE / ELWOOD RD");

  }
  
  @Test
  public void testCommackFireDepartment() {

    doTest("T1",
        "23 Wires \n" +
        " TOA: 20:00 06-22-13 \n" +
        "16 BARRE PL, HUNTINGTON ,NY '\n" +
        "  \n\n" +
        " CS: STOWE AVE / WARE AVE \n" +
        " Commack Fire District \n" +
        " 2013-000559 \n" +
        "H1: HYDRANTS\n" +
        "I/F/O #2\n" +
        "I/F/O #2\n" +
        "I/F/O #2 \n" +
        " Child/Elder \n" +
        " STA2 \n" +
        " STA3 \n" +
        " A-5",

        "CALL:23 Wires",
        "TIME:20:00",
        "DATE:06/22/13",
        "ADDR:16 BARRE PL",
        "CITY:HUNTINGTON",
        "X:STOWE AVE / WARE AVE",
        "SRC:Commack Fire District",
        "ID:2013-000559",
        "INFO:H1: HYDRANTS\nI/F/O #2\nI/F/O #2\nI/F/O #2\nChild/Elder",
        "UNIT:STA2 STA3 A-5");

    doTest("T2",
        "23 Motor Vehicle Accident \n" +
        " TOA: 15:51 06-22-13 \n" +
        "COMMACK RD, ,NY '\n" +
        "  \n\n" +
        " CS: NEW HWY \n" +
        " Commack Fire District \n" +
        " 2013-000558 \n" +
        " STA3 \n" +
        " STA2",

        "CALL:23 Motor Vehicle Accident",
        "TIME:15:51",
        "DATE:06/22/13",
        "ADDR:COMMACK RD",
        "MADDR:COMMACK RD & NEW HWY",
        "X:NEW HWY",
        "SRC:Commack Fire District",
        "ID:2013-000558",
        "UNIT:STA3 STA2");

    doTest("T3",
        "13 Commercial Automatic Alarm \n" +
        " TOA: 15:43 06-22-13 \n" +
        "148 JERICHO TPKE, COMMACK ,NY '\n" +
        " THE GAP \n\n" +
        " CS: MAYFAIR TER / WALTER CT \n" +
        " Commack Fire District \n" +
        " 2013-000557 \n" +
        "H1: PRIMARY - EXP 4 OF STRIP          SECONDARY - JERI \n" +
        "JERICHO TPKE CLICK ON AREA IMAGES FOR EMERGENCY CONTACT INFO \n" +
        " Suppression \n" +
        " STA4 \n" +
        " STA3 \n" +
        " F-4",

        "CALL:13 Commercial Automatic Alarm",
        "TIME:15:43",
        "DATE:06/22/13",
        "ADDR:148 JERICHO TPKE",
        "CITY:COMMACK",
        "PLACE:THE GAP",
        "X:MAYFAIR TER / WALTER CT",
        "SRC:Commack Fire District",
        "ID:2013-000557",
        "INFO:H1: PRIMARY - EXP 4 OF STRIP SECONDARY - JERI\nJERICHO TPKE CLICK ON AREA IMAGES FOR EMERGENCY CONTACT INFO\nSuppression",
        "UNIT:STA4 STA3 F-4");

    doTest("T4",
        "23 Misc \n" +
        " TOA: 15:02 06-22-13 \n" +
        "NB SUNKEN MEADOW PKY, COMMACK ,NY '\n" +
        "  \n\n" +
        " CS: JERICHO TPKE / INDIAN HEAD RD \n" +
        " Commack Fire District \n" +
        " 2013-000556",

        "CALL:23 Misc",
        "TIME:15:02",
        "DATE:06/22/13",
        "ADDR:NB SUNKEN MEADOW PKY",
        "MADDR:SUNKEN MEADOW PKWY & JERICHO TPKE",
        "CITY:COMMACK",
        "X:JERICHO TPKE / INDIAN HEAD RD",
        "SRC:Commack Fire District",
        "ID:2013-000556");

    doTest("T5",
        "SIGNAL 323 Gas Leak (Outside) \n" +
        " TOA: 11:29 06-22-13 \n" +
        "438 TOWNLINE RD, COMMACK ,NY '\n" +
        "  \n\n" +
        " CS: MAPLE MALL / DOVECOTE LN \n" +
        " Commack Fire District \n" +
        " 2013-000555 \n" +
        "H1: HYDRANTS\n" +
        "C/O MAPLELAWN & TOWNLINE                 \n" +
        " Child/Elder \n" +
        " STA4 \n" +
        " STA3",

        "CALL:SIGNAL 323 Gas Leak (Outside)",
        "TIME:11:29",
        "DATE:06/22/13",
        "ADDR:438 TOWNLINE RD",
        "CITY:COMMACK",
        "X:MAPLE MALL / DOVECOTE LN",
        "SRC:Commack Fire District",
        "ID:2013-000555",
        "INFO:H1: HYDRANTS\nC/O MAPLELAWN & TOWNLINE\nChild/Elder",
        "UNIT:STA4 STA3");

    doTest("T6",
        "23 Gas Leak (Outside) \n" +
        " TOA: 11:29 06-22-13 \n" +
        "438 TOWNLINE RD, COMMACK ,NY '\n" +
        "  \n\n" +
        " CS: MAPLE MALL / DOVECOTE LN \n" +
        " Commack Fire District \n" +
        " 2013-000555 \n" +
        "H1: HYDRANTS\n" +
        "C/O MAPLELAWN & TOWNLINE                 \n" +
        " Child/Elder \n" +
        " STA4 \n" +
        " STA3",

        "CALL:23 Gas Leak (Outside)",
        "TIME:11:29",
        "DATE:06/22/13",
        "ADDR:438 TOWNLINE RD",
        "CITY:COMMACK",
        "X:MAPLE MALL / DOVECOTE LN",
        "SRC:Commack Fire District",
        "ID:2013-000555",
        "INFO:H1: HYDRANTS\nC/O MAPLELAWN & TOWNLINE\nChild/Elder",
        "UNIT:STA4 STA3");

  }
  
  public static void main(String[] args) {
    new NYSuffolkCountyGParserTest().generateTests("T1");
  }
}