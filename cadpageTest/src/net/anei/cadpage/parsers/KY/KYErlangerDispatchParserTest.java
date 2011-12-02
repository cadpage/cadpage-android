package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class KYErlangerDispatchParserTest extends BaseParserTest {
  
  public KYErlangerDispatchParserTest() {
    setParser(new KYErlangerDispatchParser(), "KENTON COUNTY", "KY");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n709 ORCHARD ST\nELSMERE\nBTWN: MAIN ST & LYTLE AV\n\nRCVD AS E-911 Call\n\nCOM:\nSMOKE FILLED BASEMENT\nHEARD A POP\n\nCT:\n22-",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:709 ORCHARD ST",
        "CITY:ELSMERE",
        "X:MAIN ST & LYTLE AV",
        "INFO:SMOKE FILLED BASEMENT / HEARD A POP / 22-");

    doTest("T2",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n3812 HARVEST WY\nELSMERE\nBTWN: HARVEST LN & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:3812 HARVEST WY",
        "CITY:ELSMERE",
        "X:HARVEST LN & N/A");

    doTest("T3",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n416 ELKEN PL\nELSMERE\nBTWN: MAPLE AV & CALDWELL DR",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:416 ELKEN PL",
        "CITY:ELSMERE",
        "X:MAPLE AV & CALDWELL DR");

    doTest("T4",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n1028 CAPITOL AV\n1\nELSMERE\nBTWN: GALVIN ST & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:1028 CAPITOL AV",
        "MADDR:1028 CAPITOL AVE",
        "APT:1",
        "CITY:ELSMERE",
        "X:GALVIN ST & N/A");

    doTest("T5",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nELSMERE FIRE DEPARTMENT\n401 GARVEY AV\nELSMERE\nBTWN: ASH ST & PALACE AV",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:ELSMERE FIRE DEPARTMENT",
        "ADDR:401 GARVEY AV",
        "MADDR:401 GARVEY AVE",
        "CITY:ELSMERE",
        "X:ASH ST & PALACE AV");

    doTest("T6",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nLANIGAN'S\n4409 DIXIE HW\nELSMERE\nBTWN: N/A & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:LANIGAN'S",
        "ADDR:4409 DIXIE HW",
        "MADDR:4409 DIXIE HWY",
        "CITY:ELSMERE",
        "X:N/A & N/A");

    doTest("T7",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n631 WILLOW ST\nELSMERE\nBTWN: KENTON ST & MAIN ST",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:631 WILLOW ST",
        "CITY:ELSMERE",
        "X:KENTON ST & MAIN ST");

    doTest("T8",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nWOODCREST MANOR CARE CENTER\n3876 TURKEYFOOT RD\nELSMERE\nBTWN: TURKEYFOOT RD & INDUSTRIAL RD",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:WOODCREST MANOR CARE CENTER",
        "ADDR:3876 TURKEYFOOT RD",
        "CITY:ELSMERE",
        "X:TURKEYFOOT RD & INDUSTRIAL RD");

    doTest("T9",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n120 SPARROW DR\nELSMERE\nBTWN: N/A & ROBIN DR",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:120 SPARROW DR",
        "CITY:ELSMERE",
        "X:N/A & ROBIN DR");

    doTest("T10",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\n430 FOX ST\nELSMERE\nBTWN: GARVEY AV & MAIN ST",
        "CALL:Fire Structure",
        "PRI:1",
        "ADDR:430 FOX ST",
        "CITY:ELSMERE",
        "X:GARVEY AV & MAIN ST");

    doTest("T11",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nSIGNODE PLASTIC RECYCLING ALLIANCE\n7080 INDUSTRIAL RD\nELSMERE\nBTWN: NEW BUFFINGTON RD & VULACN DR",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:SIGNODE PLASTIC RECYCLING ALLIANCE",
        "ADDR:7080 INDUSTRIAL RD",
        "CITY:ELSMERE",
        "X:NEW BUFFINGTON RD & VULACN DR");

    doTest("T12",
        "(Alert: Fire Structure) ALRM LVL: 1\nLOC:\nALLENDALE MOBILE HOME PARK\n1150 EDWARDS RD\nELSMERE\nBTWN: LYTLE AV & N/A",
        "CALL:Fire Structure",
        "PRI:1",
        "PLACE:ALLENDALE MOBILE HOME PARK",
        "ADDR:1150 EDWARDS RD",
        "CITY:ELSMERE",
        "X:LYTLE AV & N/A");
  }
  
  @Test
  public void testParser2() {

    doTest("T1",
        "pscc@ci.erlanger.ky.us\nSUBJ:Alert: Unconscious / Unresponsive\nMSG:\nALRM LVL: 1\nLOC:\n32 DUDLEY RD\nEDGEWOOD\nBTWN: MAPLE LN & WILDROSE DR\n\nRCVD AS E-911 Call\n\nCOM:\nSUBJ FELL IN BATHROOM\nUNK IF BREATHING\nBETWEEN THE TOILET AND BATH TUB\n\nCT:\n22-RCA at POS 03\n",
        "CALL:Unconscious / Unresponsive",
        "PRI:1",
        "ADDR:32 DUDLEY RD",
        "CITY:EDGEWOOD",
        "X:MAPLE LN & WILDROSE DR",
        "INFO:SUBJ FELL IN BATHROOM / UNK IF BREATHING / BETWEEN THE TOILET AND BATH TUB / 22-RCA at POS 03");
    
  }
  
  public static void main(String[] args) {
    new KYErlangerDispatchParserTest().generateTests("T1");
  }
}