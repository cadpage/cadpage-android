package net.anei.cadpage.parsers.CT;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
New London County, CT

Montville, CT
Contact: Jim fear <jimmyboy762@yahoo.com>
Contact: William Betters <betters49@gmail.com>
Sender: dispatch@montville-ct.org
Sender: mecc@montville-ct.org
(Imc Solutions Page) MOTOR VEHICLE ACCIDENT\nCUMBERLAND FARMS\n863 NORWICH NEW LONDON TPKE \nMONTVILLE\nFire District: MFD1\n5/24/2012 18:17
(Imc Solutions Page) STRUCTURE FIRE\nVILLAGE APARTMENTS, LLC\n82 JEROME RD \nMONTVILLE\nFire District: MFD1\n6/2/2012 16:36
(Imc Solutions Page) ASSIST IN TOWN\r\nORCHARD GROVE SPECIALTY CARE\r\n5 RICHARD BROWN DR \r\nMONTVILLE\r\nFire District: MOH1\r\n6/6/2012 21:29
(Imc Solutions Page) AMBULANCE EMERGENCY\r\nAZEVEDO, BRIAN\r\n9 SALTBOX CIR \r\nCOLD RESPONSE\r\nLEG PAIN / NUMBNESS
(Imc Solutions Page) ASSIST IN TOWN\r\nGOSS, DAVID M.\r\n6 CRANDALL HILL RD APT A\r\nCOLD RESPONSE\r\nLEG PAIN / NUMBNESS
(Imc Solutions Page) AMBULANCE EMERGENCY\r\nMARKHAM, ELIZABETH\r\n3 POLLY'S LN \r\nMONTVILLE\r\nFire District: MOH1\r\n7/28/2012 22:32
(Imc Solutions Page) AMBULANCE EMERGENCY\r\n9 MAPLE AVE EXT APT 2\r\n55 YOM DIZZYNESS, QUESTION HIGH BLOOD PRESSURE.\r\nHOT\r\nFire District: MFD1\r\n9/11/2012 14:41

East Lyme, CT
Contact: Chris Taylor <taylorq83@gmail.com>
Sender: dispatch@mail.eastlyme911.gov
[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n27 PROSPECT AVE\nEast Lyme\nFire District: NHQ\n10/6/2012 23:35
[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n283 BOSTON POST RD\nEast Lyme\nFire District: FC\n10/6/2012 15:55
[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n32 BROADWAY\nEast Lyme\nFire District: NHQ\n10/6/2012 15:17
[Imc Solutions Page]  FD - MEDICAL EMERGENCY\nPENFIELD RESD\n16 FAULKNER DR\nEast Lyme\nFire District: NHQ\n10/6/2012 10:39
[Imc Solutions Page]  Officer Down - Medical\nADAMS RESD\n5 SCOTT RD\nEast Lyme\nFire District: FW\n10/6/2012 00:42
[Imc Solutions Page]  MVA - WITH INJURIES\nEXIT 72N\nI-95 EXIT 73 TO OLD LYME\nEast Lyme\nFire District: IW\n10/5/2012 18:54
[Imc Solutions Page]  FD - FIRE, STRUCTURE\n36 DEAN RD\nEast Lyme\nFire District: FW\n10/5/2012 11:22
[Imc Solutions Page]  FD - MEDICAL EMERGENCY\nKIMBALL RESD\n2 SEA BREEZE AVE\n85 y/o male, gerneral weakness unable to ambulate.\n10/5/2012 09:50
[Imc Solutions Page]  FD - FIRE, AUTO\n231 MAIN ST\nEast Lyme\nFire District: NHQ\n10/4/2012 22:01

Contact: Active911
Agency name: Gales Ferry Fire Company
Location: Gales Ferry, CT, United States
Sender: ledyard911@ct.org

(Imc Solutions Page) CARBON MONOXIDE EMERGENCY\n792 LONG COVE RD APT A\nLedyard\nFire District: 2C\n10/20/2012 10:15\n\r\n\r\n\r\n
(Imc Solutions Page) MUTUAL AID OUT - FIRE\nSUB BASE FIRE DEPARTMENT LOWER BASE\n107 LOWER BASE \nGroton\nFire District: OT\n10/19/2012 17:02\n\r\n\r\n\r\n
(Imc Solutions Page) BLS Medical\n22 WINTHROP RD \nLedyard\nFire District: 2C\n10/19/2012 06:15\n83 YOF FALL W/ LEG PAIN\r\n\r\n\r\n
(Imc Solutions Page) ALS Medical\n80 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/18/2012 16:26\n\r\n\r\n\r\n
(Imc Solutions Page) MVA WITH INJ.\n69 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/17/2012 18:57\nONE CAR\r\n\r\n\r\n
(Imc Solutions Page) ALS Medical\nMYSTIC VALLEY HUNT CLUB\n645 LONG COVE RD \nLedyard\nFire District: 2C\n10/17/2012 15:39\nLVES ONE NEEDED\r\n\r\n\r\n

Contact: Active911
Agency name: Ledyard Fire
Location: Ledyard, CT, United States
Sender: ledyard911@ct.org

(Imc Solutions Page) HAZMAT LVL 2 / MEDIUM SPILL\r\n100LB PROPANE TANK ATTACHED TO HOUSE LEAKING AT VALVE\n341 PUMPKIN HILL RD \nLedyard\nFire District: 1COM\n10/20/2012 15:06\n\r\n\r\n\r\n
(Imc Solutions Page) BLS Medical\n22 WINTHROP RD \nLedyard\nFire District: 2C\n10/19/2012 06:15\n83 YOF FALL W/ LEG PAIN\r\n\r\n\r\n\r\n
(Imc Solutions Page) MVA WITH INJ.\n69 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/17/2012 18:57\nONE CAR\r\n\r\n\r\n
(Imc Solutions Page) ALS Medical\nLEDYARD HIGH SCHOOL\n24 GALLUP HILL RD \nLedyard\nFire District: 1COM\n10/16/2012 12:57\n1 MEMBER NEEDED FOR THE AMBO\r\n\r\n\r\n

*/

public class CTNewLondonCountyParserTest extends BaseParserTest {
  
  public CTNewLondonCountyParserTest() {
    setParser(new CTNewLondonCountyParser(), "NEW LONDON COUNTY", "CT");
  }
  
  @Test
  public void testMontville() {

    doTest("T1",
        "(Imc Solutions Page) MOTOR VEHICLE ACCIDENT\n" +
        "CUMBERLAND FARMS\n" +
        "863 NORWICH NEW LONDON TPKE \n" +
        "MONTVILLE\n" +
        "Fire District: MFD1\n" +
        "5/24/2012 18:17",

        "CALL:MOTOR VEHICLE ACCIDENT",
        "NAME:CUMBERLAND FARMS",
        "ADDR:863 NORWICH NEW LONDON TPKE",
        "CITY:MONTVILLE",
        "UNIT:MFD1",
        "DATE:5/24/2012",
        "TIME:18:17");

    doTest("T2",
        "(Imc Solutions Page) STRUCTURE FIRE\nVILLAGE APARTMENTS, LLC\n82 JEROME RD \nMONTVILLE\nFire District: MFD1\n6/2/2012 16:36",
        "CALL:STRUCTURE FIRE",
        "NAME:VILLAGE APARTMENTS, LLC",
        "ADDR:82 JEROME RD",
        "CITY:MONTVILLE",
        "UNIT:MFD1",
        "DATE:6/2/2012",
        "TIME:16:36");

    doTest("T3",
        "(Imc Solutions Page) ASSIST IN TOWN\r\n" +
        "ORCHARD GROVE SPECIALTY CARE\r\n" +
        "5 RICHARD BROWN DR \r\n" +
        "MONTVILLE\r\n" +
        "Fire District: MOH1\r\n" +
        "6/6/2012 21:29",

        "CALL:ASSIST IN TOWN",
        "PLACE:ORCHARD GROVE SPECIALTY CARE",
        "ADDR:5 RICHARD BROWN DR",
        "CITY:MONTVILLE",
        "UNIT:MOH1",
        "DATE:6/6/2012",
        "TIME:21:29");

    doTest("T4",
        "(Imc Solutions Page) AMBULANCE EMERGENCY\r\nAZEVEDO, BRIAN\r\n9 SALTBOX CIR \r\nCOLD RESPONSE\r\nLEG PAIN / NUMBNESS",
        "CALL:AMBULANCE EMERGENCY",
        "NAME:AZEVEDO, BRIAN",
        "ADDR:9 SALTBOX CIR",
        "INFO:COLD RESPONSE / LEG PAIN / NUMBNESS");

    doTest("T5",
        "(Imc Solutions Page) ASSIST IN TOWN\r\nGOSS, DAVID M.\r\n6 CRANDALL HILL RD APT A\r\nCOLD RESPONSE\r\nLEG PAIN / NUMBNESS",
        "CALL:ASSIST IN TOWN",
        "NAME:GOSS, DAVID M.",
        "ADDR:6 CRANDALL HILL RD",
        "APT:A",
        "INFO:COLD RESPONSE / LEG PAIN / NUMBNESS");

    doTest("T6",
        "(Imc Solutions Page) AMBULANCE EMERGENCY\r\nMARKHAM, ELIZABETH\r\n3 POLLY'S LN \r\nMONTVILLE\r\nFire District: MOH1\r\n7/28/2012 22:32",
        "CALL:AMBULANCE EMERGENCY",
        "NAME:MARKHAM, ELIZABETH",
        "ADDR:3 POLLY'S LN",
        "CITY:MONTVILLE",
        "UNIT:MOH1",
        "DATE:7/28/2012",
        "TIME:22:32");

    doTest("T7",
        "(Imc Solutions Page) AMBULANCE EMERGENCY\r\n" +
        "9 MAPLE AVE EXT APT 2\r\n" +
        "55 YOM DIZZYNESS, QUESTION HIGH BLOOD PRESSURE.\r\n" +
        "HOT\r\n" +
        "Fire District: MFD1\r\n" +
        "9/11/2012 14:41",

        "CALL:AMBULANCE EMERGENCY",
        "ADDR:9 MAPLE AVE EXT",
        "MADDR:9 MAPLE AVE",
        "APT:2",
        "INFO:55 YOM DIZZYNESS, QUESTION HIGH BLOOD PRESSURE. / HOT",
        "UNIT:MFD1",
        "DATE:9/11/2012",
        "TIME:14:41");
  }
  
  @Test
  public void testEastLyme() {

    doTest("T1",
        "[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n27 PROSPECT AVE\nEast Lyme\nFire District: NHQ\n10/6/2012 23:35",
        "CALL:FD - MEDICAL EMERGENCY",
        "ADDR:27 PROSPECT AVE",
        "CITY:East Lyme",
        "UNIT:NHQ",
        "DATE:10/6/2012",
        "TIME:23:35");

    doTest("T2",
        "[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n283 BOSTON POST RD\nEast Lyme\nFire District: FC\n10/6/2012 15:55",
        "CALL:FD - MEDICAL EMERGENCY",
        "ADDR:283 BOSTON POST RD",
        "CITY:East Lyme",
        "UNIT:FC",
        "DATE:10/6/2012",
        "TIME:15:55");

    doTest("T3",
        "[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n32 BROADWAY\nEast Lyme\nFire District: NHQ\n10/6/2012 15:17",
        "CALL:FD - MEDICAL EMERGENCY",
        "NAME:32 BROADWAY",
        "ADDR:East Lyme",
        "UNIT:NHQ",
        "DATE:10/6/2012",
        "TIME:15:17");

    doTest("T4",
        "[Imc Solutions Page]  FD - MEDICAL EMERGENCY\nPENFIELD RESD\n16 FAULKNER DR\nEast Lyme\nFire District: NHQ\n10/6/2012 10:39",
        "CALL:FD - MEDICAL EMERGENCY",
        "NAME:PENFIELD RESD",
        "ADDR:16 FAULKNER DR",
        "CITY:East Lyme",
        "UNIT:NHQ",
        "DATE:10/6/2012",
        "TIME:10:39");

    doTest("T5",
        "[Imc Solutions Page]  Officer Down - Medical\nADAMS RESD\n5 SCOTT RD\nEast Lyme\nFire District: FW\n10/6/2012 00:42",
        "CALL:Officer Down - Medical",
        "NAME:ADAMS RESD",
        "ADDR:5 SCOTT RD",
        "CITY:East Lyme",
        "UNIT:FW",
        "DATE:10/6/2012",
        "TIME:00:42");

    doTest("T6",
        "[Imc Solutions Page]  MVA - WITH INJURIES\nEXIT 72N\nI-95 EXIT 73 TO OLD LYME\nEast Lyme\nFire District: IW\n10/5/2012 18:54",
        "CALL:MVA - WITH INJURIES",
        "NAME:EXIT 72N",
        "ADDR:I-95 EXIT 73 TO OLD LYME",
        "MADDR:I 95 EXIT 73 TO OLD LYME",
        "CITY:East Lyme",
        "UNIT:IW",
        "DATE:10/5/2012",
        "TIME:18:54");

    doTest("T7",
        "[Imc Solutions Page]  FD - FIRE, STRUCTURE\n36 DEAN RD\nEast Lyme\nFire District: FW\n10/5/2012 11:22",
        "CALL:FD - FIRE, STRUCTURE",
        "ADDR:36 DEAN RD",
        "CITY:East Lyme",
        "UNIT:FW",
        "DATE:10/5/2012",
        "TIME:11:22");

    doTest("T8",
        "[Imc Solutions Page]  FD - MEDICAL EMERGENCY\n" +
        "KIMBALL RESD\n" +
        "2 SEA BREEZE AVE\n" +
        "85 y/o male, gerneral weakness unable to ambulate.\n" +
        "10/5/2012 09:50",

        "CALL:FD - MEDICAL EMERGENCY",
        "NAME:KIMBALL RESD",
        "ADDR:2 SEA BREEZE AVE",
        "INFO:85 y/o male, gerneral weakness unable to ambulate.",
        "DATE:10/5/2012",
        "TIME:09:50");

    doTest("T9",
        "[Imc Solutions Page]  FD - FIRE, AUTO\n231 MAIN ST\nEast Lyme\nFire District: NHQ\n10/4/2012 22:01",
        "CALL:FD - FIRE, AUTO",
        "ADDR:231 MAIN ST",
        "CITY:East Lyme",
        "UNIT:NHQ",
        "DATE:10/4/2012",
        "TIME:22:01");
  }
  
  @Test
  public void testGalesFerryFire() {

    doTest("T1",
        "(Imc Solutions Page) CARBON MONOXIDE EMERGENCY\n792 LONG COVE RD APT A\nLedyard\nFire District: 2C\n10/20/2012 10:15\n\r\n\r\n\r\n",
        "CALL:CARBON MONOXIDE EMERGENCY",
        "ADDR:792 LONG COVE RD",
        "APT:A",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/20/2012",
        "TIME:10:15");

    doTest("T2",
        "(Imc Solutions Page) MUTUAL AID OUT - FIRE\n" +
        "SUB BASE FIRE DEPARTMENT LOWER BASE\n" +
        "107 LOWER BASE \n" +
        "Groton\n" +
        "Fire District: OT\n" +
        "10/19/2012 17:02\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:MUTUAL AID OUT - FIRE",
        "PLACE:SUB BASE FIRE DEPARTMENT LOWER BASE",
        "ADDR:107 LOWER BASE",  // Not Mapping
        "INFO:Groton",
        "UNIT:OT",
        "DATE:10/19/2012",
        "TIME:17:02");

    doTest("T3",
        "(Imc Solutions Page) BLS Medical\n22 WINTHROP RD \nLedyard\nFire District: 2C\n10/19/2012 06:15\n83 YOF FALL W/ LEG PAIN\r\n\r\n\r\n",
        "CALL:BLS Medical",
        "ADDR:22 WINTHROP RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/19/2012",
        "TIME:06:15",
        "INFO:83 YOF FALL W/ LEG PAIN");

    doTest("T4",
        "(Imc Solutions Page) ALS Medical\n80 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/18/2012 16:26\n\r\n\r\n\r\n",
        "CALL:ALS Medical",
        "ADDR:80 VINEGAR HILL RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/18/2012",
        "TIME:16:26");

    doTest("T5",
        "(Imc Solutions Page) MVA WITH INJ.\n69 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/17/2012 18:57\nONE CAR\r\n\r\n\r\n",
        "CALL:MVA WITH INJ.",
        "ADDR:69 VINEGAR HILL RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/17/2012",
        "TIME:18:57",
        "INFO:ONE CAR");

    doTest("T6",
        "(Imc Solutions Page) ALS Medical\n" +
        "MYSTIC VALLEY HUNT CLUB\n" +
        "645 LONG COVE RD \n" +
        "Ledyard\n" +
        "Fire District: 2C\n" +
        "10/17/2012 15:39\n" +
        "LVES ONE NEEDED\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:ALS Medical",
        "PLACE:MYSTIC VALLEY HUNT CLUB",
        "ADDR:645 LONG COVE RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/17/2012",
        "TIME:15:39",
        "INFO:LVES ONE NEEDED");

  }
  
  @Test
  public void testLedYardFire() {

    doTest("T1",
        "(Imc Solutions Page) HAZMAT LVL 2 / MEDIUM SPILL\r\n" +
        "100LB PROPANE TANK ATTACHED TO HOUSE LEAKING AT VALVE\n" +
        "341 PUMPKIN HILL RD \n" +
        "Ledyard\n" +
        "Fire District: 1COM\n" +
        "10/20/2012 15:06\n" +
        "\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:HAZMAT LVL 2 / MEDIUM SPILL",
        "PLACE:100LB PROPANE TANK ATTACHED TO HOUSE LEAKING AT VALVE",
        "ADDR:341 PUMPKIN HILL RD",
        "CITY:Ledyard",
        "UNIT:1COM",
        "DATE:10/20/2012",
        "TIME:15:06");

    doTest("T2",
        "(Imc Solutions Page) BLS Medical\n22 WINTHROP RD \nLedyard\nFire District: 2C\n10/19/2012 06:15\n83 YOF FALL W/ LEG PAIN\r\n\r\n\r\n\r\n",
        "CALL:BLS Medical",
        "ADDR:22 WINTHROP RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/19/2012",
        "TIME:06:15",
        "INFO:83 YOF FALL W/ LEG PAIN");

    doTest("T3",
        "(Imc Solutions Page) MVA WITH INJ.\n69 VINEGAR HILL RD \nLedyard\nFire District: 2C\n10/17/2012 18:57\nONE CAR\r\n\r\n\r\n",
        "CALL:MVA WITH INJ.",
        "ADDR:69 VINEGAR HILL RD",
        "CITY:Ledyard",
        "UNIT:2C",
        "DATE:10/17/2012",
        "TIME:18:57",
        "INFO:ONE CAR");

    doTest("T4",
        "(Imc Solutions Page) ALS Medical\n" +
        "LEDYARD HIGH SCHOOL\n" +
        "24 GALLUP HILL RD \n" +
        "Ledyard\n" +
        "Fire District: 1COM\n" +
        "10/16/2012 12:57\n" +
        "1 MEMBER NEEDED FOR THE AMBO\r\n" +
        "\r\n" +
        "\r\n",

        "CALL:ALS Medical",
        "PLACE:LEDYARD HIGH SCHOOL",
        "ADDR:24 GALLUP HILL RD",
        "CITY:Ledyard",
        "UNIT:1COM",
        "DATE:10/16/2012",
        "TIME:12:57",
        "INFO:1 MEMBER NEEDED FOR THE AMBO");

  }
  
  public static void main(String[] args) {
    new CTNewLondonCountyParserTest().generateTests("T1");
  }
}