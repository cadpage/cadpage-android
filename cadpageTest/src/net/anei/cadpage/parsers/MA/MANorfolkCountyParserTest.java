package net.anei.cadpage.parsers.MA;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*    
Norfolk County, MA
Contact: Active911
Agency name: Franklin Fire Department
Location: Franklin, MA, United States
Sender: franklinfd@rednmxcad.com 

Medical Emergency at 99 HIGHWOOD DR, FRANKLIN   O: SINGER, TIMOTHY J. & CALLAN, BARBARA J. . . 03:08:55
MVA with Injury at 393 UNION ST, FRANKLIN   O: LAMPASONA PATRICK & MARY . . 19:55:14
CO Alarm no symptoms at 156 MAPLE ST, FRANKLIN . . 19:03:16
Medical Emergency at 359 GROVE ST, FRANKLIN   O: GIACALONE MICHAEL J & SUZANNE M . . 14:10:34
Fire Alarm Activation at 855 WEST CENTRAL ST, FRANKLIN   O: OXFORD DENTAL . . 12:55:10
Medical Emergency at 40 WEST CENTRAL ST, FRANKLIN   O: FRANKLIN FIRE DEPARTMENT . . 10:48:14
Liquid or Gas Leak at 11 WHITE DOVE RD, FRANKLIN   O: WILFORK, VINCENT & BIANCA . . 10:36:22
Medical Emergency at 425 PROSPECT ST, FRANKLIN   O: ELIASON,  RICHARD M . . 09:22:16
Medical Emergency at 264 NORTH MAIN ST, BELLINGHAM . . 00:04:39
Medical Emergency at 837 WEST CENTRAL ST, FRANKLIN   O: ICHIGO ICHIE  STEAK HOUSE . . 22:14:12
Electrical/Wiring Problem at 6 SARGENT LN, FRANKLIN   O: CAPPELLO, PAUL . . 20:36:52
MVA with Injury at DALEY DR /  . . 18:20:42
Medical Emergency at 65 EAST CENTRAL ST #1B, FRANKLIN   O: MOLLOY . . 18:02:34
MVA with Injury at ROUTE 495 SOUTH 18-17, FRANKLIN   O: ROUTE 495 SOUTH 18-17 . . 14:50:44
Medical Emergency at 8 GATEHOUSE LN, FRANKLIN   O: FRANKLIN COMMONS-OFFICE . . 11:17:18
Medical Emergency at 5 PALOMINO DR, FRANKLIN   O: JAMPALA CHANDI AND KOLLIPARA SRINIVAS . . 09:28:09
Medical Emergency at 10 MOUNTAIN ASH LN, FRANKLIN   O: ABRAMO, RALPH . . 07:27:24
Medical Emergency at 43 CENTRAL PARK TER, FRANKLIN   O: MEYER,BARBARA . . 07:08:40
Medical Emergency at ROUTE 495 NORTH 17-18, FRANKLIN   O: ROUTE 495 NORTH 17-18 . . 06:47:58
MVA with Injury at ROUTE 495 NORTH 17-18, FRANKLIN   O: ROUTE 495 NORTH 17-18 . . 06:41:26
Fire Alarm Activation at 3 EAGLE'S NEST WAY, FRANKLIN . . 03:34:40
Fire Alarm Activation at 5-25 FRANKLIN VILLAGE DR, FRANKLIN   O: FRANKLIN VILLAGE MALL BLDG A ZONE 1 . . 23:26:37
Medical Emergency at 9 CENTRAL PARK TER, FRANKLIN   O: POWER, KENNETH . . 21:43:35
Medical Emergency at 76 GLEN MEADOW RD #BLG 3, FRANKLIN   O: CANARD, DEBORAH . . 19:11:15
Medical Emergency at 4 BERKELEY DR, FRANKLIN   O: STACKPOLE MICHAEL H & JACQUELINE R . . 18:12:58
Electrical/Wiring Problem at 25 MOUNT ST, FRANKLIN   O: MARKEE JOSEPH P & HELEN . . 15:46:03
Medical Emergency at 45 WINTER ST, FRANKLIN   O: WINTER ST APARTMENTS . . 14:52:05
MVA with Injury at 2 CONSTITUTION BLVD #A, FRANKLIN   O: FRANKLIN INDUSTRIAL PARK BOOSTER STATION . . 14:21:35
MVA with Injury at 53 OAK ST, FRANKLIN   O: CAI, WENYAN & WANG, XIANG . . 14:15:29
Medical Emergency at 463 MARTELLO RD, FRANKLIN   O: PIRROTTA, ERNESTO M & DAWN M . . 12:46:50

*/

public class MANorfolkCountyParserTest extends BaseParserTest {
  
  public MANorfolkCountyParserTest() {
    setParser(new MANorfolkCountyParser(), "NORFOLK COUNTY", "MA");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Medical Emergency at 99 HIGHWOOD DR, FRANKLIN   O: SINGER, TIMOTHY J. & CALLAN, BARBARA J. . . 03:08:55",
        "CALL:Medical Emergency",
        "ADDR:99 HIGHWOOD DR",
        "CITY:FRANKLIN",
        "NAME:SINGER, TIMOTHY J. & CALLAN, BARBARA J.",
        "TIME:03:08:55");

    doTest("T2",
        "MVA with Injury at 393 UNION ST, FRANKLIN   O: LAMPASONA PATRICK & MARY . . 19:55:14",
        "CALL:MVA with Injury",
        "ADDR:393 UNION ST",
        "CITY:FRANKLIN",
        "NAME:LAMPASONA PATRICK & MARY",
        "TIME:19:55:14");

    doTest("T3",
        "CO Alarm no symptoms at 156 MAPLE ST, FRANKLIN . . 19:03:16",
        "CALL:CO Alarm no symptoms",
        "ADDR:156 MAPLE ST",
        "CITY:FRANKLIN",
        "TIME:19:03:16");

    doTest("T4",
        "Medical Emergency at 359 GROVE ST, FRANKLIN   O: GIACALONE MICHAEL J & SUZANNE M . . 14:10:34",
        "CALL:Medical Emergency",
        "ADDR:359 GROVE ST",
        "CITY:FRANKLIN",
        "NAME:GIACALONE MICHAEL J & SUZANNE M",
        "TIME:14:10:34");

    doTest("T5",
        "Fire Alarm Activation at 855 WEST CENTRAL ST, FRANKLIN   O: OXFORD DENTAL . . 12:55:10",
        "CALL:Fire Alarm Activation",
        "ADDR:855 WEST CENTRAL ST",
        "CITY:FRANKLIN",
        "PLACE:OXFORD DENTAL",
        "TIME:12:55:10");

    doTest("T6",
        "Medical Emergency at 40 WEST CENTRAL ST, FRANKLIN   O: FRANKLIN FIRE DEPARTMENT . . 10:48:14",
        "CALL:Medical Emergency",
        "ADDR:40 WEST CENTRAL ST",
        "CITY:FRANKLIN",
        "PLACE:FRANKLIN FIRE DEPARTMENT",
        "TIME:10:48:14");

    doTest("T7",
        "Liquid or Gas Leak at 11 WHITE DOVE RD, FRANKLIN   O: WILFORK, VINCENT & BIANCA . . 10:36:22",
        "CALL:Liquid or Gas Leak",
        "ADDR:11 WHITE DOVE RD",
        "CITY:FRANKLIN",
        "NAME:WILFORK, VINCENT & BIANCA",
        "TIME:10:36:22");

    doTest("T8",
        "Medical Emergency at 425 PROSPECT ST, FRANKLIN   O: ELIASON,  RICHARD M . . 09:22:16",
        "CALL:Medical Emergency",
        "ADDR:425 PROSPECT ST",
        "CITY:FRANKLIN",
        "NAME:ELIASON, RICHARD M",
        "TIME:09:22:16");

    doTest("T9",
        "Medical Emergency at 264 NORTH MAIN ST, BELLINGHAM . . 00:04:39",
        "CALL:Medical Emergency",
        "ADDR:264 NORTH MAIN ST",
        "CITY:BELLINGHAM",
        "TIME:00:04:39");

    doTest("T10",
        "Medical Emergency at 837 WEST CENTRAL ST, FRANKLIN   O: ICHIGO ICHIE  STEAK HOUSE . . 22:14:12",
        "CALL:Medical Emergency",
        "ADDR:837 WEST CENTRAL ST",
        "CITY:FRANKLIN",
        "PLACE:ICHIGO ICHIE STEAK HOUSE",
        "TIME:22:14:12");

    doTest("T11",
        "Electrical/Wiring Problem at 6 SARGENT LN, FRANKLIN   O: CAPPELLO, PAUL . . 20:36:52",
        "CALL:Electrical/Wiring Problem",
        "ADDR:6 SARGENT LN",
        "CITY:FRANKLIN",
        "NAME:CAPPELLO, PAUL",
        "TIME:20:36:52");

    doTest("T12",
        "MVA with Injury at DALEY DR /  . . 18:20:42",
        "CALL:MVA with Injury",
        "ADDR:DALEY DR &",
        "TIME:18:20:42");

    doTest("T13",
        "Medical Emergency at 65 EAST CENTRAL ST #1B, FRANKLIN   O: MOLLOY . . 18:02:34",
        "CALL:Medical Emergency",
        "ADDR:65 EAST CENTRAL ST",
        "APT:1B",
        "CITY:FRANKLIN",
        "PLACE:MOLLOY",
        "TIME:18:02:34");

    doTest("T14",
        "MVA with Injury at ROUTE 495 SOUTH 18-17, FRANKLIN   O: ROUTE 495 SOUTH 18-17 . . 14:50:44",
        "CALL:MVA with Injury",
        "ADDR:ROUTE 495 SOUTH 18-17",
        "CITY:FRANKLIN",
        "PLACE:ROUTE 495 SOUTH 18-17",
        "TIME:14:50:44");

    doTest("T15",
        "Medical Emergency at 8 GATEHOUSE LN, FRANKLIN   O: FRANKLIN COMMONS-OFFICE . . 11:17:18",
        "CALL:Medical Emergency",
        "ADDR:8 GATEHOUSE LN",
        "CITY:FRANKLIN",
        "PLACE:FRANKLIN COMMONS-OFFICE",
        "TIME:11:17:18");

    doTest("T16",
        "Medical Emergency at 5 PALOMINO DR, FRANKLIN   O: JAMPALA CHANDI AND KOLLIPARA SRINIVAS . . 09:28:09",
        "CALL:Medical Emergency",
        "ADDR:5 PALOMINO DR",
        "CITY:FRANKLIN",
        "PLACE:JAMPALA CHANDI AND KOLLIPARA SRINIVAS",
        "TIME:09:28:09");

    doTest("T17",
        "Medical Emergency at 10 MOUNTAIN ASH LN, FRANKLIN   O: ABRAMO, RALPH . . 07:27:24",
        "CALL:Medical Emergency",
        "ADDR:10 MOUNTAIN ASH LN",
        "CITY:FRANKLIN",
        "NAME:ABRAMO, RALPH",
        "TIME:07:27:24");

    doTest("T18",
        "Medical Emergency at 43 CENTRAL PARK TER, FRANKLIN   O: MEYER,BARBARA . . 07:08:40",
        "CALL:Medical Emergency",
        "ADDR:43 CENTRAL PARK TER",
        "CITY:FRANKLIN",
        "NAME:MEYER,BARBARA",
        "TIME:07:08:40");

    doTest("T19",
        "Medical Emergency at ROUTE 495 NORTH 17-18, FRANKLIN   O: ROUTE 495 NORTH 17-18 . . 06:47:58",
        "CALL:Medical Emergency",
        "ADDR:ROUTE 495 NORTH 17-18",
        "CITY:FRANKLIN",
        "PLACE:ROUTE 495 NORTH 17-18",
        "TIME:06:47:58");

    doTest("T20",
        "MVA with Injury at ROUTE 495 NORTH 17-18, FRANKLIN   O: ROUTE 495 NORTH 17-18 . . 06:41:26",
        "CALL:MVA with Injury",
        "ADDR:ROUTE 495 NORTH 17-18",
        "CITY:FRANKLIN",
        "PLACE:ROUTE 495 NORTH 17-18",
        "TIME:06:41:26");

    doTest("T21",
        "Fire Alarm Activation at 3 EAGLE'S NEST WAY, FRANKLIN . . 03:34:40",
        "CALL:Fire Alarm Activation",
        "ADDR:3 EAGLE'S NEST WAY",
        "CITY:FRANKLIN",
        "TIME:03:34:40");

    doTest("T22",
        "Fire Alarm Activation at 5-25 FRANKLIN VILLAGE DR, FRANKLIN   O: FRANKLIN VILLAGE MALL BLDG A ZONE 1 . . 23:26:37",
        "CALL:Fire Alarm Activation",
        "ADDR:5-25 FRANKLIN VILLAGE DR",
        "MADDR:5 FRANKLIN VILLAGE DR",
        "CITY:FRANKLIN",
        "PLACE:FRANKLIN VILLAGE MALL BLDG A ZONE 1",
        "TIME:23:26:37");

    doTest("T23",
        "Medical Emergency at 9 CENTRAL PARK TER, FRANKLIN   O: POWER, KENNETH . . 21:43:35",
        "CALL:Medical Emergency",
        "ADDR:9 CENTRAL PARK TER",
        "CITY:FRANKLIN",
        "NAME:POWER, KENNETH",
        "TIME:21:43:35");

    doTest("T24",
        "Medical Emergency at 76 GLEN MEADOW RD #BLG 3, FRANKLIN   O: CANARD, DEBORAH . . 19:11:15",
        "CALL:Medical Emergency",
        "ADDR:76 GLEN MEADOW RD",
        "APT:BLG 3",
        "CITY:FRANKLIN",
        "NAME:CANARD, DEBORAH",
        "TIME:19:11:15");

    doTest("T25",
        "Medical Emergency at 4 BERKELEY DR, FRANKLIN   O: STACKPOLE MICHAEL H & JACQUELINE R . . 18:12:58",
        "CALL:Medical Emergency",
        "ADDR:4 BERKELEY DR",
        "CITY:FRANKLIN",
        "NAME:STACKPOLE MICHAEL H & JACQUELINE R",
        "TIME:18:12:58");

    doTest("T26",
        "Electrical/Wiring Problem at 25 MOUNT ST, FRANKLIN   O: MARKEE JOSEPH P & HELEN . . 15:46:03",
        "CALL:Electrical/Wiring Problem",
        "ADDR:25 MOUNT ST",
        "CITY:FRANKLIN",
        "NAME:MARKEE JOSEPH P & HELEN",
        "TIME:15:46:03");

    doTest("T27",
        "Medical Emergency at 45 WINTER ST, FRANKLIN   O: WINTER ST APARTMENTS . . 14:52:05",
        "CALL:Medical Emergency",
        "ADDR:45 WINTER ST",
        "CITY:FRANKLIN",
        "PLACE:WINTER ST APARTMENTS",
        "TIME:14:52:05");

    doTest("T28",
        "MVA with Injury at 2 CONSTITUTION BLVD #A, FRANKLIN   O: FRANKLIN INDUSTRIAL PARK BOOSTER STATION . . 14:21:35",
        "CALL:MVA with Injury",
        "ADDR:2 CONSTITUTION BLVD",
        "APT:A",
        "CITY:FRANKLIN",
        "PLACE:FRANKLIN INDUSTRIAL PARK BOOSTER STATION",
        "TIME:14:21:35");

    doTest("T29",
        "MVA with Injury at 53 OAK ST, FRANKLIN   O: CAI, WENYAN & WANG, XIANG . . 14:15:29",
        "CALL:MVA with Injury",
        "ADDR:53 OAK ST",
        "CITY:FRANKLIN",
        "NAME:CAI, WENYAN & WANG, XIANG",
        "TIME:14:15:29");

    doTest("T30",
        "Medical Emergency at 463 MARTELLO RD, FRANKLIN   O: PIRROTTA, ERNESTO M & DAWN M . . 12:46:50",
        "CALL:Medical Emergency",
        "ADDR:463 MARTELLO RD",
        "CITY:FRANKLIN",
        "NAME:PIRROTTA, ERNESTO M & DAWN M",
        "TIME:12:46:50");

  }
  
  public static void main(String[] args) {
    new MANorfolkCountyParserTest().generateTests("T1");
  }
}