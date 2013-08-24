package net.anei.cadpage.parsers.NH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Keene Mutual Aid (VT & NH)
Contact: Nick Cushman <flame05154@gmail.com>
Sender: cad_do_not_reply@firemutualaid.com
System: Symposium

Firemutualaid.com lists all the departments they dispatch 

(CAD Automated Event Notification) 12 CLARK CT\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\n89 Y/O M, BLEEDING FROM PENIS FROM CATHADER, CBA
(CAD Automated Event Notification) 12 CLARK CT\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\nTAC: Tac 1\r\n89 YOM, ILL
(CAD Automated Event Notification) 13 STURTEVANT LN\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\nCaller Phone: 8696225\r\n25YOF KNEE INJ\r\nSOCCER F
(CAD Automated Event Notification) 347 BROOKLINE RD\r\nNO NAME\r\nATHENS\r\nMEDICAL\r\nAthens\r\n\r\nNotes\r\nCaller Name: LIFELINE\r\nWILLIAMS 73F FALLEN HEAD E
(CAD Automated Event Notification) 17 RIVER\r\nNO NAME\r\nSAXTONS RIVER\r\nBRUSH/SMOKE INVEST\r\n1\r\n\r\nNotes\r\nCaller Phone: 869-1399\r\nCaller Name: KIM FAI
(CAD Automated Event Notification) 14 STURTEVANT LN\r\nNO NAME\r\nSAXTONS RIVER\r\nAFA/BOX ALARM\r\n1\r\n\r\nNotes\r\nSTURTAVANT BUILDING\r\nCaller Name: HOME SE
(CAD Automated Event Notification) 801 SAXTONS RIVER RD\r\nNO NAME\r\nROCKINGHAM\r\nMEDICAL\r\n3\r\n\r\nNotes\r\nCaller Phone: 888-289-2018\r\nBUDZIC 90M CARD HX
(CAD Automated Event Notification) 27 MAIN\r\nSAXTONS RIVER INN (MAIN)\r\nSAXTONS RIVER\r\nAFA/BOX ALARM\r\n1
(CAD Automated Event Notification) EMLive: http://911txt.co/r/fma/147835\r\n995 SAXTONS RIVER RD\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n3\r\n\r\nNotes\r\nALTE
(CAD Automated Event Notification) 801 SAXTONS RIVER RD\r\nNO NAME\r\nROCKINGHAM\r\nMEDICAL\r\n3\r\n\r\nNotes\r\nCaller Name: LIFELINE\r\nBRONY BUDZIK RESIDENCE\r

Contact: Jeremy LaPlante <nhjeremy@gmail.com>
Sender: cad_do_not_reply@firemutualaid.com
(CAD Automated Event Notification) EMLive: http://911txt.co/r/fma/148541\r\n18 WILDWOOD RD\r\nCONGDON LILLIAN R. REVOCABLE TRUST (WILDWOOD RD)\r\nKEENE

*/

public class NHKeeneMutualAidParserTest extends BaseParserTest {
  
  public NHKeeneMutualAidParserTest() {
    setParser(new NHKeeneMutualAidParser(), "", "");
  }
  
  @Test
  public void testParserVT() {

    doTest("T1",
        "(CAD Automated Event Notification) 12 CLARK CT\r\n" +
        "NO NAME\r\n" +
        "SAXTONS RIVER\r\n" +
        "MEDICAL\r\n" +
        "1\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "89 Y/O M, BLEEDING FROM PENIS FROM CATHADER, CBA",

        "ADDR:12 CLARK CT",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:1",
        "INFO:89 Y/O M, BLEEDING FROM PENIS FROM CATHADER, CBA");

    doTest("T2",
        "(CAD Automated Event Notification) 12 CLARK CT\r\nNO NAME\r\nSAXTONS RIVER\r\nMEDICAL\r\n1\r\n\r\nNotes\r\nTAC: Tac 1\r\n89 YOM, ILL",
        "ADDR:12 CLARK CT",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:1",
        "INFO:89 YOM, ILL",
        "CH:Tac 1");

    doTest("T3",
        "(CAD Automated Event Notification) 13 STURTEVANT LN\r\n" +
        "NO NAME\r\n" +
        "SAXTONS RIVER\r\n" +
        "MEDICAL\r\n" +
        "1\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "Caller Phone: 8696225\r\n" +
        "25YOF KNEE INJ\r\n" +
        "SOCCER F",

        "ADDR:13 STURTEVANT LN",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:1",
        "PHONE:8696225");

    doTest("T4",
        "(CAD Automated Event Notification) 347 BROOKLINE RD\r\n" +
        "NO NAME\r\n" +
        "ATHENS\r\n" +
        "MEDICAL\r\n" +
        "Athens\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "Caller Name: LIFELINE\r\n" +
        "WILLIAMS 73F FALLEN HEAD E",

        "ADDR:347 BROOKLINE RD",
        "CITY:ATHENS",
        "ST:VT",
        "CALL:MEDICAL",
        "INFO:Athens / WILLIAMS 73F FALLEN HEAD E",
        "NAME:LIFELINE");

    doTest("T5",
        "(CAD Automated Event Notification) 17 RIVER\r\n" +
        "NO NAME\r\n" +
        "SAXTONS RIVER\r\n" +
        "BRUSH/SMOKE INVEST\r\n" +
        "1\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "Caller Phone: 869-1399\r\n" +
        "Caller Name: KIM FAI",

        "ADDR:17 RIVER",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:BRUSH/SMOKE INVEST",
        "PRI:1",
        "PHONE:869-1399",
        "NAME:KIM FAI");

    doTest("T6",
        "(CAD Automated Event Notification) 14 STURTEVANT LN\r\n" +
        "NO NAME\r\n" +
        "SAXTONS RIVER\r\n" +
        "AFA/BOX ALARM\r\n" +
        "1\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "STURTAVANT BUILDING\r\n" +
        "Caller Name: HOME SE",

        "ADDR:14 STURTEVANT LN",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:AFA/BOX ALARM",
        "PRI:1",
        "INFO:STURTAVANT BUILDING",
        "NAME:HOME SE");

    doTest("T7",
        "(CAD Automated Event Notification) 801 SAXTONS RIVER RD\r\n" +
        "NO NAME\r\n" +
        "ROCKINGHAM\r\n" +
        "MEDICAL\r\n" +
        "3\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "Caller Phone: 888-289-2018\r\n" +
        "BUDZIC 90M CARD HX",

        "ADDR:801 SAXTONS RIVER RD",
        "CITY:ROCKINGHAM",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:3",
        "PHONE:888-289-2018");

    doTest("T8",
        "(CAD Automated Event Notification) 27 MAIN\r\nSAXTONS RIVER INN (MAIN)\r\nSAXTONS RIVER\r\nAFA/BOX ALARM\r\n1",
        "ADDR:27 MAIN",
        "PLACE:SAXTONS RIVER INN (MAIN)",
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:AFA/BOX ALARM",
        "PRI:1");

    doTest("T9",
        "(CAD Automated Event Notification) EMLive: http://911txt.co/r/fma/147835\r\n" +
        "995 SAXTONS RIVER RD\r\n" +
        "NO NAME\r\n" +
        "SAXTONS RIVER\r\n" +
        "MEDICAL\r\n" +
        "3\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "ALTE",

        "URL:http://911txt.co/r/fma/147835",
        "ADDR:995 SAXTONS RIVER RD",  // Not mapping
        "CITY:SAXTONS RIVER",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:3",
        "INFO:ALTE");

    doTest("T10",
        "(CAD Automated Event Notification) 801 SAXTONS RIVER RD\r\n" +
        "NO NAME\r\n" +
        "ROCKINGHAM\r\n" +
        "MEDICAL\r\n" +
        "3\r\n" +
        "\r\n" +
        "Notes\r\n" +
        "Caller Name: LIFELINE\r\n" +
        "BRONY BUDZIK RESIDENCE\r",

        "ADDR:801 SAXTONS RIVER RD",
        "CITY:ROCKINGHAM",
        "ST:VT",
        "CALL:MEDICAL",
        "PRI:3",
        "INFO:BRONY BUDZIK RESIDENCE",
        "NAME:LIFELINE");
    
  }
  
  @Test 
  public void JeremyLapant() {

    doTest("T1",
        "(CAD Automated Event Notification) EMLive: http://911txt.co/r/fma/148541\r\n" +
        "18 WILDWOOD RD\r\n" +
        "CONGDON LILLIAN R. REVOCABLE TRUST (WILDWOOD RD)\r\n" +
        "KEENE",

        "URL:http://911txt.co/r/fma/148541",
        "ADDR:18 WILDWOOD RD",
        "PLACE:CONGDON LILLIAN R. REVOCABLE TRUST (WILDWOOD RD)",
        "CITY:KEENE",
        "ST:NH");
   
  }

  public static void main(String[] args) {
    new NHKeeneMutualAidParserTest().generateTests("T1");
  }
}
