package net.anei.cadpage.parsers.TX;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class TXNassauBayParserTest extends BaseParserTest {
  
  public TXNassauBayParserTest() {
    setParser(new TXNassauBayParser(), "NASSAU BAY", "TX");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "39:CAD:FYI: ;NBFD;FIRE ALARM;18101 POINT LOOKOUT DR;NB;NB;01/12/2011  22:10:16;TRASHROOM 1 SMOKE DETECTOR [01/12/11 22:11:43 NHUGHES] fire alarms going",
        "SRC:NBFD",
        "CALL:FIRE ALARM",
        "ADDR:18101 POINT LOOKOUT DR",
        "INFO:TRASHROOM 1 SMOKE DETECTOR / fire alarms going");

    doTest("T2",
        "40:CAD:FYI: ;NBFD;STRUCTURE FIRE;1020-264 W NASA PKWY;WB;WBW;01/13/2011 11:46:25;smoke inside [01/13/11 11:45:40 TSWANSON]",
        "SRC:NBFD",
        "CALL:STRUCTURE FIRE",
        "ADDR:1020-264 W NASA PKWY",
        "INFO:smoke inside");

    doTest("T3",
        "41:CAD:FYI: ;NBFD;ACCIDENT MAJOR;NASA PKWY/ST JOHN BLVD;HO;NB;01/18/2011 12:53:59",
        "SRC:NBFD",
        "CALL:ACCIDENT MAJOR",
        "ADDR:NASA PKWY & ST JOHN BLVD");

    doTest("T4",
        "CAD:FYI: ;NBFD;UNCONSCIOUS;1427 SAXONY LN;NB;NB;03/06/2011 14:30:40;female down in bathroom [03/06/11 14:30:28 DCOOLEY]",
        "SRC:NBFD",
        "CALL:UNCONSCIOUS",
        "ADDR:1427 SAXONY LN",
        "INFO:female down in bathroom");

    doTest("T5",
        "CAD:FYI: ;NBFD;ASSIST BY FIRE;3000 E NASA PKWY;SB;03/06/2011 15:38:43;boat [03/06/11 15:35:58 DCOOLEY]",
        "SRC:NBFD",
        "CALL:ASSIST BY FIRE",
        "ADDR:3000 E NASA PKWY",
        "INFO:boat");

    doTest("T6",
        ":CAD:FYI: ;NBFD;VEHICLE FIRE;18100 UPPER BAY RD;NB;NB;03/26/2011 13:36:15",
        "SRC:NBFD",
        "CALL:VEHICLE FIRE",
        "ADDR:18100 UPPER BAY RD");

    doTest("T7",
        "CAD:Update: ;WBFD;FIRE ALARM;450 W MEDICAL CENTER BLVD;WB;WBW;04/02/2011 07:22:55;CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I",
        "SRC:WBFD",
        "CALL:FIRE ALARM",
        "ADDR:450 W MEDICAL CENTER BLVD",
        "INFO:CALLED THE NUMBER BELOW AND REC ANSWERING SERVICE THEY COULD PROVIDE MORE I");
 }
  
  public static void main(String[] args) {
    new TXNassauBayParserTest().generateTests("T7");
  }
}
