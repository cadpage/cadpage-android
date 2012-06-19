package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;


public class OHBrownCountyParserTest extends BaseParserTest {
  
  public OHBrownCountyParserTest() {
    setParser(new OHBrownCountyParser(), "BROWN COUNTY", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "[Alert: SMOKE IN THE AREA] ALRM LVL: 1 \nLOC: \n13101 PURDY RD\nWASHINGTON \nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM: CALLER ADV MAN BURNING SOMETHING ABOUT TWO HO",
        "CALL:SMOKE IN THE AREA",
        "PRI:1",
        "ADDR:13101 PURDY RD",
        "CITY:WASHINGTON",
        "INFO:CALLER ADV MAN BURNING SOMETHING ABOUT TWO HO");

    doTest("T2",
        "(Alert: SICK PERSON (SPECIFIC DIAG)) \nALRM LVL: 1 \nLOC: DEERFIELD TOWNHOUSE \nAPARTMENTS \n455 W MAIN ST \nAPT 703 \nMT ORAB \nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM",
        "CALL:SICK PERSON (SPECIFIC DIAG)",
        "PRI:1",
        "PLACE:APARTMENTS",
        "ADDR:455 W MAIN ST",
        "APT:703",
        "CITY:MT ORAB");

    doTest("T3",
        "[Alert: SMOKE IN THE AREA]  ALRM LVL: 1 \nLOC:\n13101 PURDY RD \nWASHINGTON \nBTWN: N/A & N/A \n\nRCVD AS Phone\n\nCOM:\nCALLER ADV MAN BURNING SOMETHING ABOUT TWO HO",
        "CALL:SMOKE IN THE AREA",
        "PRI:1",
        "ADDR:13101 PURDY RD",
        "CITY:WASHINGTON",
        "INFO:CALLER ADV MAN BURNING SOMETHING ABOUT TWO HO");

    doTest("T4",
        "(Alert: SICK PERSON (SPECIFIC DIAG)) ALRM LVL: 1\nLOC:\nDEERFIELD TOWNHOUSE APARTMENTS\n455 W MAIN ST\nAPT 703\nMT ORAB\nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM:",
        "CALL:SICK PERSON (SPECIFIC DIAG)",
        "PRI:1",
        "PLACE:DEERFIELD TOWNHOUSE APARTMENTS",
        "ADDR:455 W MAIN ST",
        "APT:703",
        "CITY:MT ORAB");

    doTest("T5",
        "(Alert: BREATHING PROBLEMS) ALRM LVL: 1\nLOC:\n14885 EASTWOOD RD\nSTERLING\nBTWN: TRI-COUNTY HWY & N/A\n\nRCVD AS 911\n\nCOM:\n60 YOF\n\nCT:\n6D0013 at POS 03",
        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "ADDR:14885 EASTWOOD RD",
        "CITY:STERLING",
        "X:TRI-COUNTY HWY",
        "INFO:60 YOF / 6D0013 at POS 03");

    doTest("T6",
        "(Alert: PSYCH/ABNRML BEHVR/SUICIDE ATT) ALRM LVL: 1\nLOC:\n14964 HILL CREST RD\nGREEN\nBTWN: BARDWELL-BUFORD RD & GREENBUSH EAST RD\n\nRCVD AS Phone\n\nCOM:\nCAL",
        "CALL:PSYCH/ABNRML BEHVR/SUICIDE ATT",
        "PRI:1",
        "ADDR:14964 HILL CREST RD",
        "CITY:GREEN",
        "X:BARDWELL-BUFORD RD & GREENBUSH EAST RD",
        "INFO:CAL");

    doTest("T7",
        "(Alert: BREATHING PROBLEMS) ALRM LVL: 1\nLOC:\n1871 CROSSTOWN ROAD\nSTERLING TWP\nBTWN: N/A & N/A\n\n\n\nCOM:\n78 Y O F\nHAVING TROUBLE BRAETHING\nCOPD\nDIFFICULTY",
        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "ADDR:1871 CROSSTOWN ROAD",
        "CITY:STERLING TWP",
        "INFO:78 Y O F / HAVING TROUBLE BRAETHING / COPD / DIFFICULTY");

    doTest("T8",
        "(Alert: CHEST PAIN (NON TRAUMATIC)) ALRM LVL: 1\nLOC:\n7703 GARDNER RD\nLEWIS\nBTWN: OAK GROVE RD & N/A\n\nRCVD AS Phone\n\nCOM:\nSEVERE CHEST PAINS\n77 Y O M\nPA",
        "CALL:CHEST PAIN (NON TRAUMATIC)",
        "PRI:1",
        "ADDR:7703 GARDNER RD",
        "CITY:LEWIS",
        "X:OAK GROVE RD",
        "INFO:SEVERE CHEST PAINS / 77 Y O M / PA");

    doTest("T9",
        "(Alert: PSYCH/ABNRML BEHVR/SUICIDE ATT) ALRM LVL: 1\nLOC:\n200 COLUMBIA ST\nHIGGINSPORT\nBTWN: OLIVE ST & JOHN ST\n\nRCVD AS Phone\n\nCOM:\nBOYFRIEND WENT TO CHE",
        "CALL:PSYCH/ABNRML BEHVR/SUICIDE ATT",
        "PRI:1",
        "ADDR:200 COLUMBIA ST",
        "CITY:HIGGINSPORT",
        "X:OLIVE ST & JOHN ST",
        "INFO:BOYFRIEND WENT TO CHE");

    doTest("T10",
        "(Alert: SICK PERSON (SPECIFIC DIAG)) ALARM LVL: 1\nLOC:\nDEERFIELD TOWNHOUSE APARTMENTS\n455 W MAIN ST\nAPT 703\nMT ORAB\nBTWN: N/A & N/A\n\nRCVD AS Phone\n\nCOM:",
        "CALL:SICK PERSON (SPECIFIC DIAG)",
        "PLACE:DEERFIELD TOWNHOUSE APARTMENTS",
        "ADDR:455 W MAIN ST",
        "APT:703",
        "CITY:MT ORAB");

    doTest("T11",
        "(Alert: STRUCTURE FIRE UNCONFIRMED) ALARM LVL: 1\nLOC:\n2567 US RTE 134\nBTWN: N/A & N/A\n\nRCVD AS PHONE\n\nCOM: ADVISED SMOKE WAS COMING OUT OF THE WINDOWS CA",
        "CALL:STRUCTURE FIRE UNCONFIRMED",
        "ADDR:2567 US RTE 134",
        "MADDR:2567 US 134",
        "INFO:ADVISED SMOKE WAS COMING OUT OF THE WINDOWS CA");

    doTest("T12",
        "(Alert: FIRE ALARM) ALARM LVL: 1\nLOC:\n11519 US RTE 62\nEAGLE\nBTWN: N/A & MAPLE DR\n\nRCVD AS PHONE\n\nCOM: FIRE ALARM EASTERN MIDDLE SCHOOL DUCT SMOKE D",
        "CALL:FIRE ALARM",
        "ADDR:11519 US RTE 62",
        "MADDR:11519 US 62",
        "CITY:EAGLE",
        "X:MAPLE DR",
        "INFO:FIRE ALARM EASTERN MIDDLE SCHOOL DUCT SMOKE D");

    doTest("T13",
        "(Alert: BREATHING PROBLEMS) ALRM LVL: 1\r\n" +
        "LOC:\r\n" +
        "6072 TRI-COUNTY HWY\r\n" +
        "LOT 1\r\n" +
        "WASHINGTON\r\n" +
        "BTWN: WARDLOW RD & N/A\r\n" +
        "\r\n" +
        "RCVD AS Phone\r\n" +
        "\r\n" +
        "COM:\r\n" +
        "BREATHING PROBLE",

        "CALL:BREATHING PROBLEMS",
        "PRI:1",
        "ADDR:6072 TRI-COUNTY HWY",
        "APT:LOT 1",
        "CITY:WASHINGTON",
        "X:WARDLOW RD",
        "INFO:BREATHING PROBLE");
      
  }
  
  public static void main(String[] args) {
    new OHBrownCountyParserTest().generateTests("T1");
  }
}