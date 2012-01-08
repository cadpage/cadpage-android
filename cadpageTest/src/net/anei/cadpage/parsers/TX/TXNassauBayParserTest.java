package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXNassauBayParserTest extends BaseParserTest {
  
  public TXNassauBayParserTest() {
    setParser(new TXNassauBayParser(), "NASSAU BAY", "TX");
  }
  
  @Test
  public void testParserNBFD() {

    doTest("T1",
        "39:CAD:FYI: ;NBFD;FIRE ALARM;18101 POINT LOOKOUT DR;NB;NB;01/12/2011  22:10:16;TRASHROOM 1 SMOKE DETECTOR [01/12/11 22:11:43 NHUGHES] fire alarms going",
        "SRC:NBFD",
        "CALL:FIRE ALARM",
        "ADDR:18101 POINT LOOKOUT DR",
        "CITY:NASSAU BAY",
        "CODE:NB",
        "DATE:01/12/2011",
        "TIME:22:10:16",
        "INFO:TRASHROOM 1 SMOKE DETECTOR / fire alarms going");

    doTest("T2",
        "40:CAD:FYI: ;NBFD;STRUCTURE FIRE;1020-264 W NASA PKWY;WB;WBW;01/13/2011 11:46:25;smoke inside [01/13/11 11:45:40 TSWANSON]",
        "SRC:NBFD",
        "CALL:STRUCTURE FIRE",
        "ADDR:1020-264 W NASA PKWY",
        "MADDR:1020 W NASA PKWY",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:01/13/2011",
        "TIME:11:46:25",
        "INFO:smoke inside");

    doTest("T3",
        "41:CAD:FYI: ;NBFD;ACCIDENT MAJOR;NASA PKWY/ST JOHN BLVD;HO;NB;01/18/2011 12:53:59",
        "SRC:NBFD",
        "CALL:ACCIDENT MAJOR",
        "ADDR:NASA PKWY & ST JOHN BLVD",
        "CITY:NASSAU BAY",
        "CODE:NB",
        "DATE:01/18/2011",
        "TIME:12:53:59");

    doTest("T4",
        "CAD:FYI: ;NBFD;UNCONSCIOUS;1427 SAXONY LN;NB;NB;03/06/2011 14:30:40;female down in bathroom [03/06/11 14:30:28 DCOOLEY]",
        "SRC:NBFD",
        "CALL:UNCONSCIOUS",
        "ADDR:1427 SAXONY LN",
        "CITY:NASSAU BAY",
        "CODE:NB",
        "DATE:03/06/2011",
        "TIME:14:30:40",
        "INFO:female down in bathroom");

    doTest("T5",
        "CAD:FYI: ;NBFD;ASSIST BY FIRE;3000 E NASA PKWY;SB;03/06/2011 15:38:43;boat [03/06/11 15:35:58 DCOOLEY]",
        "SRC:NBFD",
        "CALL:ASSIST BY FIRE",
        "ADDR:3000 E NASA PKWY",
        "CITY:SEABROOK",
        "DATE:03/06/2011",
        "TIME:15:38:43",
        "INFO:boat");

    doTest("T6",
        ":CAD:FYI: ;NBFD;VEHICLE FIRE;18100 UPPER BAY RD;NB;NB;03/26/2011 13:36:15",
        "SRC:NBFD",
        "CALL:VEHICLE FIRE",
        "ADDR:18100 UPPER BAY RD",
        "CITY:NASSAU BAY",
        "CODE:NB",
        "DATE:03/26/2011",
        "TIME:13:36:15");
  }
  
  @Test
  public void testParserWBDF() {

    doTest("T1",
        "CAD:Update: ;WBFD;FIRE ALARM;450 W MEDICAL CENTER BLVD;WB;WBW;04/02/2011 07:22:55;CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I",
        "SRC:WBFD",
        "CALL:FIRE ALARM",
        "ADDR:450 W MEDICAL CENTER BLVD",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:04/02/2011",
        "TIME:07:22:55",
        "INFO:CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I");

    doTest("T2",
        "CAD:FYI: ;WBFD;ACCIDENT MAJOR;MAGNOLIA/ S KOBAYSHI;04/03/2011 18:01:07;gry mits eclipse/////18 wheeler [04/03/11 18:00:35 DJOHNSON]",
        "SRC:WBFD",
        "CALL:ACCIDENT MAJOR",
        "ADDR:MAGNOLIA & S KOBAYSHI",
        "DATE:04/03/2011",
        "TIME:18:01:07",
        "INFO:gry mits eclipse/////18 wheeler");

    doTest("T3",
        ":CAD:FYI: ;WBFD;SMELL OF SMOKE GAS OUTSIDE;18206 EGRET BAY BLVD;WB;WBE;04/04/2011 17:01:45;SMELL OF NATURAL GAS IN AREA - FENCED AREA NEXT TO ICHIBON [04/04/1",
        "SRC:WBFD",
        "CALL:SMELL OF SMOKE GAS OUTSIDE",
        "ADDR:18206 EGRET BAY BLVD",
        "CITY:WEBSTER",
        "CODE:WBE",
        "DATE:04/04/2011",
        "TIME:17:01:45",
        "INFO:SMELL OF NATURAL GAS IN AREA - FENCED AREA NEXT TO ICHIBON");

    doTest("T4",
        ":CAD:FYI: ;WBFD;FIRE ALARM;1001-B W BAY AREA BLVD;WB;WBW;04/05/2011 12:18:03;manual pull in offc [04/05/11 12:18:19 ESALLIER]",
        "SRC:WBFD",
        "CALL:FIRE ALARM",
        "ADDR:1001-B W BAY AREA BLVD",
        "MADDR:1001 W BAY AREA BLVD",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:04/05/2011",
        "TIME:12:18:03",
        "INFO:manual pull in offc");

    doTest("T5",
        ":CAD:FYI: ;WBFD;UNCONSCIOUS;20233 IH 45 FWY;WB;WBW;04/07/2011 14:44:07;IN FRONT SHOWROOM [04/07/11 14:44:03 VKEENER] FEMALE PASSED OUT, IS BREATHING",
        "SRC:WBFD",
        "CALL:UNCONSCIOUS",
        "ADDR:20233 IH 45 FWY",
        "MADDR:20233  45 FWY",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:04/07/2011",
        "TIME:14:44:07",
        "INFO:IN FRONT SHOWROOM / FEMALE PASSED OUT, IS BREATHING");

    doTest("T6",
        ":CAD:Update: ;WBFD;MINOR ACCIDENT;SH 3 HWY/MAGNOLIA AVE;WB;WBE;04/10/2011 13:23:20; 7 months [04/10/11 13:23:18 DCOOLEY] blk tk silber pt cruiser [04/10/11 17:42:10 MHAYES]",
        "SRC:WBFD",
        "CALL:MINOR ACCIDENT",
        "ADDR:SH 3 HWY & MAGNOLIA AVE",
        "MADDR:ST 3 & MAGNOLIA AVE",
        "CITY:WEBSTER",
        "CODE:WBE",
        "DATE:04/10/2011",
        "TIME:13:23:20",
        "INFO:7 months / blk tk silber pt cruiser");

    doTest("T7",
        ":CAD:FYI: ;WBFD;FIRE ALARM;901 S KOBAYASHI RD;WB;WBW;04/10/2011 16:11:22;RESIDENT OF 133 CALLED ADVISED SHE HAD A KITCHEN FIRE AND SPRINKLERS CAME ON",
        "SRC:WBFD",
        "CALL:FIRE ALARM",
        "ADDR:901 S KOBAYASHI RD",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:04/10/2011",
        "TIME:16:11:22",
        "INFO:RESIDENT OF 133 CALLED ADVISED SHE HAD A KITCHEN FIRE AND SPRINKLERS CAME ON");

    doTest("T8",
        ":CAD:FYI: ;WBFD;UNCONSCIOUS;409 GREEN ST;WB;WBW;04/09/2011 11:58:10;he is breathing [04/09/11 11:58:08 TSWANSON] cold and clammy [04/09/11 11:57:46 TSWANSON]",
        "SRC:WBFD",
        "CALL:UNCONSCIOUS",
        "ADDR:409 GREEN ST",
        "CITY:WEBSTER",
        "CODE:WBW",
        "DATE:04/09/2011",
        "TIME:11:58:10",
        "INFO:he is breathing / cold and clammy");
  }
  
  @Test
  public void testParserLCFD() {

    doTest("T1",
        ":CAD:FYI: ;LCFD;ELECTRICAL PROBLEMS SPARKS;FOX RUN CT/CREEKSIDE DR;LC;LCFW;09/10/2011 13:26:13;right next to soccer field, [09/10/11 1  ",
        "SRC:LCFD",
        "CALL:ELECTRICAL PROBLEMS SPARKS",
        "ADDR:FOX RUN CT & CREEKSIDE DR",
        "CITY:LEAGUE CITY",
        "CODE:LCFW",
        "DATE:09/10/2011",
        "TIME:13:26:13",
        "INFO:right next to soccer field,");

    doTest("T2",
        ":CAD:Update: ;LCFD;ELECTRICAL PROBLEMS SPARKS;500-BLK PALOMINO LN;LC;LCFW;09/10/2011 13:26:13;(D2) E2 CAN GO BACK IN SERVICE [09/10/11 13",
        "SRC:LCFD",
        "CALL:ELECTRICAL PROBLEMS SPARKS",
        "ADDR:500-BLK PALOMINO LN",
        "MADDR:500 PALOMINO LN",
        "CITY:LEAGUE CITY",
        "CODE:LCFW",
        "DATE:09/10/2011",
        "TIME:13:26:13",
        "INFO:(D2) E2 CAN GO BACK IN SERVICE");

    doTest("T3",
        ":CAD:Update: ;LCFD;ELECTRICAL PROBLEMS SPARKS;207 HIDDEN PINES CT;LC;LCFW;09/10/2011 13:26:13;(D2) CONTACT ELECTRIC CO. POLE # F1233565A,",
        "SRC:LCFD",
        "CALL:ELECTRICAL PROBLEMS SPARKS",
        "ADDR:207 HIDDEN PINES CT",
        "CITY:LEAGUE CITY",
        "CODE:LCFW",
        "DATE:09/10/2011",
        "TIME:13:26:13",
        "INFO:(D2) CONTACT ELECTRIC CO. POLE # F1233565A,");

    doTest("T4",
        ":CAD:FYI: ;LCFD;FIRE ALARM;3045 W MARINA BAY DR;LC;LCFE;09/08/2011 08:52:28;NO CONTACT MADE [09/08/11 08:55:10 RCOX] BUILDING 2 ZONE 13 [",
        "SRC:LCFD",
        "CALL:FIRE ALARM",
        "ADDR:3045 W MARINA BAY DR",
        "CITY:LEAGUE CITY",
        "CODE:LCFE",
        "DATE:09/08/2011",
        "TIME:08:52:28",
        "INFO:NO CONTACT MADE / BUILDING 2 ZONE 13");

    doTest("T5",
        ":CAD:FYI: ;LCFD;GRASS;2220 COVESIDE ST;LC;LCFE;09/08/2011 15:19:21;grass fire, front yard,possible from transformer [09/08/11 15:20:13 RD",
        "SRC:LCFD",
        "CALL:GRASS",
        "ADDR:2220 COVESIDE ST",
        "CITY:LEAGUE CITY",
        "CODE:LCFE",
        "DATE:09/08/2011",
        "TIME:15:19:21",
        "INFO:grass fire, front yard,possible from transformer");

    doTest("T6",
        ":CAD:FYI: ;LCFD;FIRE ALARM;1455-3307 LOUISIANA AVE;LC;LCFE;09/07/2011 10:52:53;smoke dector alarm resd 281-557-2707 jones, jazzeline [09/",
        "SRC:LCFD",
        "CALL:FIRE ALARM",
        "ADDR:1455-3307 LOUISIANA AVE",
        "MADDR:1455 LOUISIANA AVE",
        "CITY:LEAGUE CITY",
        "CODE:LCFE",
        "DATE:09/07/2011",
        "TIME:10:52:53",
        "INFO:smoke dector alarm resd 281-557-2707 jones, jazzeline");

    doTest("T7",
        ":CAD:FYI: ;LCFD;FIRE ALARM;1450 LOUISIANA AVE;LC;LCFE;09/07/2011 11:55:22;at bldg 5 [09/07/2011 11:55:20 KCOOK]",
        "SRC:LCFD",
        "CALL:FIRE ALARM",
        "ADDR:1450 LOUISIANA AVE",
        "CITY:LEAGUE CITY",
        "CODE:LCFE",
        "DATE:09/07/2011",
        "TIME:11:55:22",
        "INFO:at bldg 5");

    doTest("T8",
        ":CAD:FYI: ;LCFD;FIRE ALARM;211 W LEAGUE CITY PKWY;LC;LCFW;09/07/2011 12:04:36;automatic fire alarm, 24 hour fire circuit to positions 1 a",
        "SRC:LCFD",
        "CALL:FIRE ALARM",
        "ADDR:211 W LEAGUE CITY PKWY",
        "CITY:LEAGUE CITY",
        "CODE:LCFW",
        "DATE:09/07/2011",
        "TIME:12:04:36",
        "INFO:automatic fire alarm, 24 hour fire circuit to positions 1 a");

    doTest("T9",
        ":CAD:FYI: ;LCFD;GRASS;2381 GUN RANGE RD;LC;LCFE;09/07/2011 14:33:12;grass, no buildings [09/07/11 14:33:47 RDARROW]",
        "SRC:LCFD",
        "CALL:GRASS",
        "ADDR:2381 GUN RANGE RD",
        "CITY:LEAGUE CITY",
        "CODE:LCFE",
        "DATE:09/07/2011",
        "TIME:14:33:12",
        "INFO:grass, no buildings");
  }
  
  public static void main(String[] args) {
    new TXNassauBayParserTest().generateTests("T1");
  }
}
