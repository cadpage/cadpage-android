package net.anei.cadpage.parsers.CO;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Kit Carson County, CO
Contact: Active911
Agency name: Burlington Volunteer Fire Department
Location: Burlington, CO, United States
Sender: kccdispatch@yahoo.com 

(CAD) EVENT:0002\nTIME:05/29/2013 05:29:16\nTYPE:CONTBURN/Controlled Burn\nLOC:16031 HWY 385\nTXT:APPROVED CONTROLLED BURN FOR MARY HITCHCOCK AT 16031 HWY 385.
(CAD) EVENT:0007\nTIME:05/28/2013 07:40:27\nTYPE:CONTBURN/Controlled Burn\nLOC:CR 46 AND CR U\nTXT:REC A CALL FROM ERIC MCARTHUR REQUESTING A CONTROLLED BURN AT CR 46 AND CR U. BURN APPROVED
(CAD) EVENT:0009\nTIME:05/10/2013 06:26:23\nTYPE:CONTBURN/Controlled Burn\nLOC:48275 CR HH\nTXT:REC A CALL FROM MARILYN SCHLICHENMAYER REQUESTING TO BURN TRASH AT 48275 CR HH. HUM 86 WIND 0.
(CAD) EVENT:0006\nTIME:05/02/2013 07:01:33\nTYPE:CONTBURN/Controlled Burn\nLOC:46435 HWY 24\nTXT:BRETT WITH EASTERN COLORADO RECYCLING WILL BE BURNING. 
(CAD) EVENT:0022\nTIME:04/23/2013 16:20:57\nTYPE:CONTBURN/Controlled Burn\nLOC:19985 COUNTY ROAD 40\nTXT:MERLENE PELSER WILL BE HAVING A CONTROLLED BURN.  SENT MESSAGE TO MARK, C4, C5, C6
(CAD) EVENT:0035\nTIME:04/17/2013 07:15:43\nTYPE:CONTBURN/Controlled Burn\nLOC:43465 HWY 24\nTXT:BRITT WITH EASTERN COLORADO RECYCLING REQUESTING TO BURN. HUM 88 WIND 8
(CAD) EVENT:0032\nTIME:04/12/2013 15:52:27\nTYPE:WEATHER/Weather\nLOC:KIT CARSON COUNTY\nTXT:NWS ISSUED A SERVE THUNDERSTORM WARNING UNTIL 1645.  FOR NORTHEASTERN KIT CARSON COUNTY.  QUARTER SIZE HAIL AND WINDS OF 60 MPH ARE EXPECTED. 
(CAD) EVENT:0024\nTIME:04/12/2013 13:47:22\nTYPE:FIRE/Fire\nLOC:CTY RD 52 AND CTY RD JJ\nTXT:
(CAD) EVENT:0004\nTIME:04/04/2013 11:19:57\nTYPE:CONTBURN/Controlled Burn\nLOC:43465 HWY 24\nTXT:BRITT AT EASTERN COLORADO RECYCLING BURN FOR ABOUT 1 HOUR.  \nMESSAGE SENT MARK, TRAVIS, TOM
(CAD) EVENT:0003\nTIME:04/01/2013 07:18:52\nTYPE:CONTBURN/Controlled Burn\nLOC:43465 HWY 24\nTXT:REC A CALL FROM BRITT WITH EASTERN COLORADO RECYL
(CAD) EVENT:0027\nTIME:03/29/2013 14:16:21\nTYPE:CONTBURN/Controlled Burn\nLOC:38511 COUNTY ROAD Z\nTXT:DOYLE ADOLF HAS A SMALL PILE OF TREE BRANCHES. \nSENT MESSAGE TO MARK, COOLEY, AND ANDY
(CAD) EVENT:0036\nTIME:03/28/2013 16:14:07\nTYPE:CONTBURN/Controlled Burn\nLOC:20691 COUNTY ROAD 48\nTXT:RAE ZICHT BURNING IN A BARREL.  \nSENT MESSAGE TO ANDY, DARRIN AND MARK. 
(CAD) EVENT:0036\nTIME:03/28/2013 15:29:21\nTYPE:CONTBURN/Controlled Burn\nLOC:20691 COUNTY ROAD 48\nTXT:
(CAD) EVENT:0036\nTIME:03/27/2013 19:52:22\nTYPE:VEHSTOP/Vehicle Stop\nLOC:COUNTY ROAD 48 AND COUNTY ROAD X\nTXT:License Plate:           / CO\n     \nComment: C4\n\nSTATE OF COLORADO\nCOLORADO VEHICLE REGISTRATION\n\nOWNER:   GRINNAN DANIEL W JR\nOWNER2:  GRINNAN CATHERINE M\nOWNER3:  \nDRIVER:  \nADDRES
(CAD) EVENT:0036\nTIME:03/27/2013 19:47:11\nTYPE:VEHSTOP/Vehicle Stop\nLOC:COUNTY ROAD 48 AND COUNTY ROAD X\nTXT:License Plate:           / CO\n     \nComment: C4\n\nSTATE OF COLORADO\nCOLORADO VEHICLE REGISTRATION\n\nOWNER:   GRINNAN DANIEL W JR\nOWNER2:  GRINNAN CATHERINE M\nOWNER3:  \nDRIVER:  \nADDRES
(CAD) EVENT:0036\nTIME:03/27/2013 19:47:11\nTYPE:VEHSTOP/Vehicle Stop\nLOC:CTY RD 48 AND CTY RD X\nTXT:License Plate:           / CO\nLocation: CTY RD 48 AND CTY RD X        \nComment: C4\n\nSTATE OF COLORADO\nCOLORADO VEHICLE REGISTRATION\n\nOWNER:   GRINNAN DANIEL W JR\nOWNER2:  GRINNAN CATHERINE M\nOWN
(CAD) EVENT:0036\nTIME:03/27/2013 19:29:37\nTYPE:VEHSTOP/Vehicle Stop\nLOC:CTY RD 48 AND CTY RD X\nTXT:License Plate:           / COLocation: CTY RD 48 AND CTY RD X        Comment:
(CAD) EVENT:0015\nTIME:03/27/2013 17:43:10\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z\nTXT:CONTROLLED BURN
(CAD) EVENT:0015\nTIME:03/27/2013 17:43:10\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z STRATTON\nTXT:CONTROLLED BURN
(CAD) EVENT:0030\nTIME:03/27/2013 17:28:19\nTYPE:TPATROL/Town Patrol\nLOC:VONA\nTXT:C5 TOWN PATROL
(CAD) EVENT:0015\nTIME:03/27/2013 16:41:14\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z STRATTON\nTXT:CONTROLLED BURN
(CAD) EVENT:0015\nTIME:03/27/2013 16:41:14\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z\nTXT:CONTROLLED BURN
(CAD) EVENT:0015\nTIME:03/27/2013 16:01:23\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 RD Z\nTXT:CONTROLLED BURN
(CAD) EVENT:0027\nTIME:03/27/2013 16:20:02\nTYPE:INCIDENT/Incident\nLOC:ARBYS\nTXT:1201
(CAD) EVENT:0027\nTIME:03/27/2013 16:20:02\nTYPE:INCIDENT/Incident\nLOC:CTY RD HH AND HWY 385\nTXT:1201
(CAD) EVENT:0026\nTIME:03/27/2013 16:03:39\nTYPE:LOSTPRP/Lost Property\nLOC:450 S LINCOLN ST\nTXT:RECEIVED A CALL FROM A MARISA VAN ADIVSING THAT SHE IS TRAVELING FROM  COLORADO TO NEW YORK  AND SHE HAS LOS

 */

public class COKitCarsonCountyParserTest extends BaseParserTest {
  
  public COKitCarsonCountyParserTest() {
    setParser(new COKitCarsonCountyParser(), "KIT CARSON COUNTY", "CO");
  }
  
  @Test
  public void testParser() {
    doTest("T1",
        "(CAD) EVENT:0002\n" +
        "TIME:05/29/2013 05:29:16\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:16031 HWY 385\n" +
        "TXT:APPROVED CONTROLLED BURN FOR MARY HITCHCOCK AT 16031 HWY 385.",

        "UNIT:0002",
        "DATE:05/29/2013",
        "TIME:05:29:16",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:16031 HWY 385",
        "MADDR:16031 US 385",
        "INFO:APPROVED CONTROLLED BURN FOR MARY HITCHCOCK AT 16031 HWY 385.");

    doTest("T2",
        "(CAD) EVENT:0007\n" +
        "TIME:05/28/2013 07:40:27\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:CR 46 AND CR U\n" +
        "TXT:REC A CALL FROM ERIC MCARTHUR REQUESTING A CONTROLLED BURN AT CR 46 AND CR U. BURN APPROVED",

        "UNIT:0007",
        "DATE:05/28/2013",
        "TIME:07:40:27",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:CR 46 AND CR U",
        "MADDR:COUNTY ROAD 46 & COUNTY ROAD U",
        "INFO:REC A CALL FROM ERIC MCARTHUR REQUESTING A CONTROLLED BURN AT CR 46 AND CR U. BURN APPROVED");

    doTest("T3",
        "(CAD) EVENT:0009\n" +
        "TIME:05/10/2013 06:26:23\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:48275 CR HH\n" +
        "TXT:REC A CALL FROM MARILYN SCHLICHENMAYER REQUESTING TO BURN TRASH AT 48275 CR HH. HUM 86 WIND 0.",

        "UNIT:0009",
        "DATE:05/10/2013",
        "TIME:06:26:23",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:48275 CR HH",
        "MADDR:48275 COUNTY ROAD HH",//cannot find number. also wants a city.
        "INFO:REC A CALL FROM MARILYN SCHLICHENMAYER REQUESTING TO BURN TRASH AT 48275 CR HH. HUM 86 WIND 0.");

    doTest("T4",
        "(CAD) EVENT:0006\n" +
        "TIME:05/02/2013 07:01:33\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:46435 HWY 24\n" +
        "TXT:BRETT WITH EASTERN COLORADO RECYCLING WILL BE BURNING. ",

        "UNIT:0006",
        "DATE:05/02/2013",
        "TIME:07:01:33",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:46435 HWY 24",
        "INFO:BRETT WITH EASTERN COLORADO RECYCLING WILL BE BURNING.");

    doTest("T5",
        "(CAD) EVENT:0022\n" +
        "TIME:04/23/2013 16:20:57\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:19985 COUNTY ROAD 40\n" +
        "TXT:MERLENE PELSER WILL BE HAVING A CONTROLLED BURN.  SENT MESSAGE TO MARK, C4, C5, C6",

        "UNIT:0022",
        "DATE:04/23/2013",
        "TIME:16:20:57",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:19985 COUNTY ROAD 40",
        "INFO:MERLENE PELSER WILL BE HAVING A CONTROLLED BURN.  SENT MESSAGE TO MARK, C4, C5, C6");

    doTest("T6",
        "(CAD) EVENT:0035\n" +
        "TIME:04/17/2013 07:15:43\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:43465 HWY 24\n" +
        "TXT:BRITT WITH EASTERN COLORADO RECYCLING REQUESTING TO BURN. HUM 88 WIND 8",

        "UNIT:0035",
        "DATE:04/17/2013",
        "TIME:07:15:43",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:43465 HWY 24",
        "INFO:BRITT WITH EASTERN COLORADO RECYCLING REQUESTING TO BURN. HUM 88 WIND 8");

    doTest("T7",
        "(CAD) EVENT:0032\n" +
        "TIME:04/12/2013 15:52:27\n" +
        "TYPE:WEATHER/Weather\n" +
        "LOC:KIT CARSON COUNTY\n" +
        "TXT:NWS ISSUED A SERVE THUNDERSTORM WARNING UNTIL 1645.  FOR NORTHEASTERN KIT CARSON COUNTY.  QUARTER SIZE HAIL AND WINDS OF 60 MPH ARE EXPECTED. ",

        "UNIT:0032",
        "DATE:04/12/2013",
        "TIME:15:52:27",
        "CALL:WEATHER/Weather",
        "ADDR:KIT CARSON COUNTY",
        "INFO:NWS ISSUED A SERVE THUNDERSTORM WARNING UNTIL 1645.  FOR NORTHEASTERN KIT CARSON COUNTY.  QUARTER SIZE HAIL AND WINDS OF 60 MPH ARE EXPECTED.");

    doTest("T8",
        "(CAD) EVENT:0024\nTIME:04/12/2013 13:47:22\nTYPE:FIRE/Fire\nLOC:CTY RD 52 AND CTY RD JJ\nTXT:",
        "UNIT:0024",
        "DATE:04/12/2013",
        "TIME:13:47:22",
        "CALL:FIRE/Fire",
        "ADDR:CTY RD 52 AND CTY RD JJ",
        "MADDR:COUNTY ROAD 52 & COUNTY ROAD JJ");

    doTest("T9",
        "(CAD) EVENT:0004\n" +
        "TIME:04/04/2013 11:19:57\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:43465 HWY 24\n" +
        "TXT:BRITT AT EASTERN COLORADO RECYCLING BURN FOR ABOUT 1 HOUR.  \n" +
        "MESSAGE SENT MARK, TRAVIS, TOM",

        "UNIT:0004",
        "DATE:04/04/2013",
        "TIME:11:19:57",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:43465 HWY 24",
        "INFO:BRITT AT EASTERN COLORADO RECYCLING BURN FOR ABOUT 1 HOUR.");

    doTest("T10",
        "(CAD) EVENT:0003\n" +
        "TIME:04/01/2013 07:18:52\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:43465 HWY 24\n" +
        "TXT:REC A CALL FROM BRITT WITH EASTERN COLORADO RECYL",

        "UNIT:0003",
        "DATE:04/01/2013",
        "TIME:07:18:52",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:43465 HWY 24",
        "INFO:REC A CALL FROM BRITT WITH EASTERN COLORADO RECYL");

    doTest("T11",
        "(CAD) EVENT:0027\n" +
        "TIME:03/29/2013 14:16:21\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:38511 COUNTY ROAD Z\n" +
        "TXT:DOYLE ADOLF HAS A SMALL PILE OF TREE BRANCHES. \n" +
        "SENT MESSAGE TO MARK, COOLEY, AND ANDY",

        "UNIT:0027",
        "DATE:03/29/2013",
        "TIME:14:16:21",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:38511 COUNTY ROAD Z",
        "INFO:DOYLE ADOLF HAS A SMALL PILE OF TREE BRANCHES.");

    doTest("T12",
        "(CAD) EVENT:0036\n" +
        "TIME:03/28/2013 16:14:07\n" +
        "TYPE:CONTBURN/Controlled Burn\n" +
        "LOC:20691 COUNTY ROAD 48\n" +
        "TXT:RAE ZICHT BURNING IN A BARREL.  \n" +
        "SENT MESSAGE TO ANDY, DARRIN AND MARK. ",

        "UNIT:0036",
        "DATE:03/28/2013",
        "TIME:16:14:07",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:20691 COUNTY ROAD 48",
        "INFO:RAE ZICHT BURNING IN A BARREL.");

    doTest("T13",
        "(CAD) EVENT:0036\nTIME:03/28/2013 15:29:21\nTYPE:CONTBURN/Controlled Burn\nLOC:20691 COUNTY ROAD 48\nTXT:",
        "UNIT:0036",
        "DATE:03/28/2013",
        "TIME:15:29:21",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:20691 COUNTY ROAD 48");

    doTest("T14",
        "(CAD) EVENT:0036\n" +
        "TIME:03/27/2013 19:52:22\n" +
        "TYPE:VEHSTOP/Vehicle Stop\n" +
        "LOC:COUNTY ROAD 48 AND COUNTY ROAD X\n" +
        "TXT:License Plate:           / CO\n" +
        "     \n" +
        "Comment: C4\n\n" +
        "STATE OF COLORADO\n" +
        "COLORADO VEHICLE REGISTRATION\n\n" +
        "OWNER:   GRINNAN DANIEL W JR\n" +
        "OWNER2:  GRINNAN CATHERINE M\n" +
        "OWNER3:  \n" +
        "DRIVER:  \n" +
        "ADDRES",

        "UNIT:0036",
        "DATE:03/27/2013",
        "TIME:19:52:22",
        "CALL:VEHSTOP/Vehicle Stop",
        "ADDR:COUNTY ROAD 48 AND COUNTY ROAD X",
        "MADDR:COUNTY ROAD 48 & COUNTY ROAD X",
        "INFO:License Plate:           / CO");

    doTest("T15",
        "(CAD) EVENT:0036\n" +
        "TIME:03/27/2013 19:47:11\n" +
        "TYPE:VEHSTOP/Vehicle Stop\n" +
        "LOC:COUNTY ROAD 48 AND COUNTY ROAD X\n" +
        "TXT:License Plate:           / CO\n" +
        "     \n" +
        "Comment: C4\n\n" +
        "STATE OF COLORADO\n" +
        "COLORADO VEHICLE REGISTRATION\n\n" +
        "OWNER:   GRINNAN DANIEL W JR\n" +
        "OWNER2:  GRINNAN CATHERINE M\n" +
        "OWNER3:  \n" +
        "DRIVER:  \n" +
        "ADDRES",

        "UNIT:0036",
        "DATE:03/27/2013",
        "TIME:19:47:11",
        "CALL:VEHSTOP/Vehicle Stop",
        "ADDR:COUNTY ROAD 48 AND COUNTY ROAD X",
        "MADDR:COUNTY ROAD 48 & COUNTY ROAD X",
        "INFO:License Plate:           / CO");

    doTest("T16",
        "(CAD) EVENT:0036\n" +
        "TIME:03/27/2013 19:47:11\n" +
        "TYPE:VEHSTOP/Vehicle Stop\n" +
        "LOC:CTY RD 48 AND CTY RD X\n" +
        "TXT:License Plate:           / CO\n" +
        "Location: CTY RD 48 AND CTY RD X        \n" +
        "Comment: C4\n\n" +
        "STATE OF COLORADO\n" +
        "COLORADO VEHICLE REGISTRATION\n\n" +
        "OWNER:   GRINNAN DANIEL W JR\n" +
        "OWNER2:  GRINNAN CATHERINE M\n" +
        "OWN",

        "UNIT:0036",
        "DATE:03/27/2013",
        "TIME:19:47:11",
        "CALL:VEHSTOP/Vehicle Stop",
        "ADDR:CTY RD 48 AND CTY RD X",
        "MADDR:COUNTY ROAD 48 & COUNTY ROAD X",
        "INFO:License Plate:           / CO");

    doTest("T17",
        "(CAD) EVENT:0036\n" +
        "TIME:03/27/2013 19:29:37\n" +
        "TYPE:VEHSTOP/Vehicle Stop\n" +
        "LOC:CTY RD 48 AND CTY RD X\n" +
        "TXT:License Plate:           / COLocation: CTY RD 48 AND CTY RD X        Comment:",

        "UNIT:0036",
        "DATE:03/27/2013",
        "TIME:19:29:37",
        "CALL:VEHSTOP/Vehicle Stop",
        "ADDR:CTY RD 48 AND CTY RD X",
        "MADDR:COUNTY ROAD 48 & COUNTY ROAD X",
        "INFO:License Plate:           / COLocation: CTY RD 48 AND CTY RD X        Comment:");

    doTest("T18",
        "(CAD) EVENT:0015\nTIME:03/27/2013 17:43:10\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z\nTXT:CONTROLLED BURN",
        "UNIT:0015",
        "DATE:03/27/2013",
        "TIME:17:43:10",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:33985 COUNTY ROAD Z",
        "INFO:CONTROLLED BURN");

    doTest("T19",
        "(CAD) EVENT:0015\nTIME:03/27/2013 17:43:10\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z STRATTON\nTXT:CONTROLLED BURN",
        "UNIT:0015",
        "DATE:03/27/2013",
        "TIME:17:43:10",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:33985 COUNTY ROAD Z",
        "CITY:STRATTON",
        "INFO:CONTROLLED BURN");

    doTest("T20",
        "(CAD) EVENT:0030\nTIME:03/27/2013 17:28:19\nTYPE:TPATROL/Town Patrol\nLOC:VONA\nTXT:C5 TOWN PATROL",
        "UNIT:0030",
        "DATE:03/27/2013",
        "TIME:17:28:19",
        "CALL:TPATROL/Town Patrol",
        "ADDR:VONA",
        "INFO:C5 TOWN PATROL");

    doTest("T21",
        "(CAD) EVENT:0015\nTIME:03/27/2013 16:41:14\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z STRATTON\nTXT:CONTROLLED BURN",
        "UNIT:0015",
        "DATE:03/27/2013",
        "TIME:16:41:14",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:33985 COUNTY ROAD Z",
        "CITY:STRATTON",
        "INFO:CONTROLLED BURN");

    doTest("T22",
        "(CAD) EVENT:0015\nTIME:03/27/2013 16:41:14\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 COUNTY ROAD Z\nTXT:CONTROLLED BURN",
        "UNIT:0015",
        "DATE:03/27/2013",
        "TIME:16:41:14",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:33985 COUNTY ROAD Z",
        "INFO:CONTROLLED BURN");

    doTest("T23",
        "(CAD) EVENT:0015\nTIME:03/27/2013 16:01:23\nTYPE:CONTBURN/Controlled Burn\nLOC:33985 RD Z\nTXT:CONTROLLED BURN",
        "UNIT:0015",
        "DATE:03/27/2013",
        "TIME:16:01:23",
        "CALL:CONTBURN/Controlled Burn",
        "ADDR:33985 RD Z", 
        "INFO:CONTROLLED BURN");

    doTest("T24",
        "(CAD) EVENT:0027\nTIME:03/27/2013 16:20:02\nTYPE:INCIDENT/Incident\nLOC:ARBYS\nTXT:1201",
        "UNIT:0027",
        "DATE:03/27/2013",
        "TIME:16:20:02",
        "CALL:INCIDENT/Incident",
        "ADDR:ARBYS", //ARBYS
        "INFO:1201");

    doTest("T25",
        "(CAD) EVENT:0027\nTIME:03/27/2013 16:20:02\nTYPE:INCIDENT/Incident\nLOC:CTY RD HH AND HWY 385\nTXT:1201",
        "UNIT:0027",
        "DATE:03/27/2013",
        "TIME:16:20:02",
        "CALL:INCIDENT/Incident",
        "ADDR:CTY RD HH AND HWY 385",
        "MADDR:COUNTY ROAD HH & US 385",
        "INFO:1201");

    doTest("T26",
        "(CAD) EVENT:0026\n" +
        "TIME:03/27/2013 16:03:39\n" +
        "TYPE:LOSTPRP/Lost Property\n" +
        "LOC:450 S LINCOLN ST\n" +
        "TXT:RECEIVED A CALL FROM A MARISA VAN ADIVSING THAT SHE IS TRAVELING FROM  COLORADO TO NEW YORK  AND SHE HAS LOS",

        "UNIT:0026",
        "DATE:03/27/2013",
        "TIME:16:03:39",
        "CALL:LOSTPRP/Lost Property",
        "ADDR:450 S LINCOLN ST",
        "INFO:RECEIVED A CALL FROM A MARISA VAN ADIVSING THAT SHE IS TRAVELING FROM  COLORADO TO NEW YORK  AND SHE HAS LOS");
    
  }
  
  public static void main(String[] args) {
    new COKitCarsonCountyParserTest().generateTests("T1");
  }
}