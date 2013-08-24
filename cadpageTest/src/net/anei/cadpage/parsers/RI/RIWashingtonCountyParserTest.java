package net.anei.cadpage.parsers.RI;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Washington County, RI
Contact: Patrick Hawkins <forestryfire302@gmail.com>
Sender: cad_do_not_reply@westerlyambulance.org

(CAD Notification) 2012/05/13 15:25:39\n10 CEDAR HILLS DR\nNO NAME\nRICHMOND\nEMERGENCY\n\nNotes\n71 FEMALE, FALL IN PAIN.  CALL FROM 303
(CAD Notification) 2012/05/13 10:11:03\n825 MAIN ST APT C105\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\nMEDICAL ALARM, NO RESPONSE
(CAD Notification) 2012/05/13 04:41:24\n307 CHURCH ST A\nNO NAME\nRICHMOND\nEMERGENCY\n\nNotes\n86 Y/O F. FALL VICTIM
(CAD Notification) 2012/05/13 02:27:03\n807 MAIN ST APT B5\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\n80 Y/O F. DEYDRATION AND WEAK
(CAD Notification) 2012/05/12 13:32:27\n2 @95 N\n@95 NORTH AT EXIT 2 (@95)\nHOPKINTON\nMVA\n\nAssigned Units\nAMB_313 RESP HOT\n\nNotes\nNORTH OF EXIT
(CAD Notification) 2012/05/12 01:41:45\n31 COLUMBIA HTS OVAL\nNO NAME\nCHARLESTOWN\nEMERGENCY\n\nNotes\nDISORIENTED MAN
(CAD Notification) 2012/05/12 16:26:30\n54 NOOSENECK HILL RD\nRI STATE POLICE (NOOSENECK HILL RD)\nRICHMOND\nEMERGENCY\n\nNotes\nEYE INJURY FROM PRE

Contact: "ldisandro3137@gmail.com" <ldisandro3137@gmail.com>
Sender: cad_do_not_reply@westerlyambulance.org

Subject:CAD Notification\nhttp://911txt.co/r/wd/59050\r\n2012/09/03 09:34:11\r\n21 KINGSTOWN RD\r\nRICHMOND\r\nMVA\r\n\r
Subject:CAD Notification\nhttp://911txt.co/r/wd/63414\n2012/12/15 13:53:19\n172 FENNER HILL RD\nHOPKINTON\nEMERGENCY\nAMS
Subject:CAD Notification\nhttp://911txt.co/r/wd/63411\n2012/12/15 13:07:30\n335 WOODVILLE ALTON RD\nHOPKINTON\nEMERGENCY
Subject:CAD Notification\nhttp://911txt.co/r/wd/63403\n2012/12/15 09:13:33\n7 FOSTER FARM DR\nRICHMOND\nEMERGENCY\n**FEMA
Subject:CAD Notification\nhttp://911txt.co/r/wd/63397\n2012/12/15 07:26:21\n188 RICHMOND TOWNHOUSE RD\nRICHMOND\nEMERGENC
Subject:CAD Notification\nhttp://911txt.co/r/wd/63381\n2012/12/14 13:34:53\n71 SMALLPOX TRL\nRICHMOND\nEMERGENCY\nSTOMACH
Subject:CAD Notification\nhttp://911txt.co/r/wd/63365\n2012/12/13 13:58:58\n12 STILSON RD\nRICHMOND\nEMERGENCY\nSYNCOPE\n

*/

public class RIWashingtonCountyParserTest extends BaseParserTest {
  
  public RIWashingtonCountyParserTest() {
    setParser(new RIWashingtonCountyParser(), "WASHINGTON COUNTY", "RI");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(CAD Notification) 2012/05/13 15:25:39\n" +
        "10 CEDAR HILLS DR\n" +
        "NO NAME\n" +
        "RICHMOND\n" +
        "EMERGENCY\n\n" +
        "Notes\n" +
        "71 FEMALE, FALL IN PAIN.  CALL FROM 303",

        "DATE:05/13/2012",
        "TIME:15:25:39",
        "ADDR:10 CEDAR HILLS DR",
        "CITY:RICHMOND",
        "CALL:EMERGENCY",
        "INFO:71 FEMALE, FALL IN PAIN.  CALL FROM 303");

    doTest("T2",
        "(CAD Notification) 2012/05/13 10:11:03\n825 MAIN ST APT C105\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\nMEDICAL ALARM, NO RESPONSE",
        "DATE:05/13/2012",
        "TIME:10:11:03",
        "ADDR:825 MAIN ST",
        "APT:C105",
        "CITY:HOPKINTON",
        "CALL:EMERGENCY",
        "INFO:MEDICAL ALARM, NO RESPONSE");

    doTest("T3",
        "(CAD Notification) 2012/05/13 04:41:24\n307 CHURCH ST A\nNO NAME\nRICHMOND\nEMERGENCY\n\nNotes\n86 Y/O F. FALL VICTIM",
        "DATE:05/13/2012",
        "TIME:04:41:24",
        "ADDR:307 CHURCH ST A",
        "CITY:RICHMOND",
        "CALL:EMERGENCY",
        "INFO:86 Y/O F. FALL VICTIM");

    doTest("T4",
        "(CAD Notification) 2012/05/13 02:27:03\n807 MAIN ST APT B5\nNO NAME\nHOPKINTON\nEMERGENCY\n\nNotes\n80 Y/O F. DEYDRATION AND WEAK",
        "DATE:05/13/2012",
        "TIME:02:27:03",
        "ADDR:807 MAIN ST",
        "APT:B5",
        "CITY:HOPKINTON",
        "CALL:EMERGENCY",
        "INFO:80 Y/O F. DEYDRATION AND WEAK");

    doTest("T5",
        "(CAD Notification) 2012/05/12 13:32:27\n" +
        "2 @95 N\n" +
        "@95 NORTH AT EXIT 2 (@95)\n" +
        "HOPKINTON\n" +
        "MVA\n\n" +
        "Assigned Units\n" +
        "AMB_313 RESP HOT\n\n" +
        "Notes\n" +
        "NORTH OF EXIT",

        "DATE:05/12/2012",
        "TIME:13:32:27",
        "ADDR:2 I95 N",
        "MADDR:2 I 95 N",
        "PLACE:I95 NORTH AT EXIT 2 (I95)",
        "CITY:HOPKINTON",
        "CALL:MVA",
        "UNIT:AMB_313 RESP HOT",
        "INFO:NORTH OF EXIT");

    doTest("T6",
        "(CAD Notification) 2012/05/12 01:41:45\n31 COLUMBIA HTS OVAL\nNO NAME\nCHARLESTOWN\nEMERGENCY\n\nNotes\nDISORIENTED MAN",
        "DATE:05/12/2012",
        "TIME:01:41:45",
        "ADDR:31 COLUMBIA HTS OVAL",
        "CITY:CHARLESTOWN",
        "CALL:EMERGENCY",
        "INFO:DISORIENTED MAN");

    doTest("T7",
        "(CAD Notification) 2012/05/12 16:26:30\n" +
        "54 NOOSENECK HILL RD\n" +
        "RI STATE POLICE (NOOSENECK HILL RD)\n" +
        "RICHMOND\n" +
        "EMERGENCY\n\n" +
        "Notes\n" +
        "EYE INJURY FROM PRE",

        "DATE:05/12/2012",
        "TIME:16:26:30",
        "ADDR:54 NOOSENECK HILL RD",
        "PLACE:RI STATE POLICE (NOOSENECK HILL RD)",
        "CITY:RICHMOND",
        "CALL:EMERGENCY",
        "INFO:EYE INJURY FROM PRE");
   
  }
  
  @Test
  public void testLarryDisandro() {

    doTest("T1",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/59050\r\n2012/09/03 09:34:11\r\n21 KINGSTOWN RD\r\nRICHMOND\r\nMVA\r\n\r",
        "URL:http://911txt.co/r/wd/59050",
        "DATE:09/03/2012",
        "TIME:09:34:11",
        "ADDR:21 KINGSTOWN RD",
        "CITY:RICHMOND",
        "CALL:MVA");

    doTest("T2",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63414\n2012/12/15 13:53:19\n172 FENNER HILL RD\nHOPKINTON\nEMERGENCY\nAMS",
        "URL:http://911txt.co/r/wd/63414",
        "DATE:12/15/2012",
        "TIME:13:53:19",
        "ADDR:172 FENNER HILL RD",
        "CITY:HOPKINTON",
        "CALL:EMERGENCY - AMS");

    doTest("T3",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63411\n2012/12/15 13:07:30\n335 WOODVILLE ALTON RD\nHOPKINTON\nEMERGENCY",
        "URL:http://911txt.co/r/wd/63411",
        "DATE:12/15/2012",
        "TIME:13:07:30",
        "ADDR:335 WOODVILLE ALTON RD",
        "CITY:HOPKINTON",
        "CALL:EMERGENCY");

    doTest("T4",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63403\n2012/12/15 09:13:33\n7 FOSTER FARM DR\nRICHMOND\nEMERGENCY\n**FEMA",
        "URL:http://911txt.co/r/wd/63403",
        "DATE:12/15/2012",
        "TIME:09:13:33",
        "ADDR:7 FOSTER FARM DR",
        "CITY:RICHMOND",
        "CALL:EMERGENCY - **FEMA");

    doTest("T5",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63397\n2012/12/15 07:26:21\n188 RICHMOND TOWNHOUSE RD\nRICHMOND\nEMERGENC",
        "URL:http://911txt.co/r/wd/63397",
        "DATE:12/15/2012",
        "TIME:07:26:21",
        "ADDR:188 RICHMOND TOWNHOUSE RD",
        "CITY:RICHMOND",
        "CALL:EMERGENC");

    doTest("T6",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63381\n2012/12/14 13:34:53\n71 SMALLPOX TRL\nRICHMOND\nEMERGENCY\nSTOMACH",
        "URL:http://911txt.co/r/wd/63381",
        "DATE:12/14/2012",
        "TIME:13:34:53",
        "ADDR:71 SMALLPOX TRL",
        "CITY:RICHMOND",
        "CALL:EMERGENCY - STOMACH");

    doTest("T7",
        "Subject:CAD Notification\nhttp://911txt.co/r/wd/63365\n2012/12/13 13:58:58\n12 STILSON RD\nRICHMOND\nEMERGENCY\nSYNCOPE\n",
        "URL:http://911txt.co/r/wd/63365",
        "DATE:12/13/2012",
        "TIME:13:58:58",
        "ADDR:12 STILSON RD",
        "CITY:RICHMOND",
        "CALL:EMERGENCY - SYNCOPE");

  }
  
  public static void main(String[] args) {
    new RIWashingtonCountyParserTest().generateTests("T1");
  }
}