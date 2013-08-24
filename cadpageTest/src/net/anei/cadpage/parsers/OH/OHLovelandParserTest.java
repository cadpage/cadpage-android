package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;

import org.junit.Test;

/*
Loveland, OH
Contact: support@active911.com
Sender: "dispatcher@safety-center.org" <dispatcher@safety-center.org>

Subject: Alert: EMS FALLS\nALRM LVL: 1\nLOC:\nPAXTON'S GRILL ***\n126 W LOVELAND AV\nLOVELD\nBTWN: 2ND ST & RAILROAD AV\n\n\n\nCOM:\n\n\nCT:\nD-JMP at POS 02
Subject: Alert: EMS ABDOMINAL PAIN\nALRM LVL: 1\nLOC:\n9270 CACTUS LN\nSYMMTP\nBTWN: MCKINNEY RD & DEADEND\n\n\n\nCOM:\nM/58\n\nCT:\nD-CMS at POS 01
Subject: Alert: EMS DIABETIC EMERGENCY\nALRM LVL: 1\nLOC:\n438 MAIN ST\nLOVELD\nBTWN: RIVERSIDE DR & WALL ST\n\nRCVD AS 911 Call\n\nCOM:\nF-40...LOW SUGAR\n\nCT:\nD-RCS at POS 02
Subject: Alert: FIRE ODOR INVESTIGATION\nALRM LVL: 1\nLOC:\n497 N 2ND ST\nLOVELD\nBTWN: LYONS AV & SENTRY HILL DR\n\nRCVD AS Phone\n\nCOM:\nSMOKE IN THE AREA\nPOSS ON LYONS\n\nCT:\nD-AWK at POS 01
Subject: Alert: EMS DIABETIC EMERGENCY\nALRM LVL: 1\nLOC:\nSTATION 61\n8871 WEEKLY LN\nSYMMTP\nBTWN: MASON RD & DEAD END\n\n\n\nCOM:\nM/20\nEMS\nLOW BLOOD SUGAR\nLOBBY\nIN FRT LOBBY\n\nCT:\nD-AWK at POS 02
Subject: Alert: EMS DIABETIC EMERGENCY\nALRM LVL: 1\nLOC:\nSTATION 61\n8871 WEEKLY LN\nSYMMTP\nBTWN: MASON RD & DEAD END\n\n\n\nCOM:\nM/20\nEMS\nLOW BLOOD SUGAR\nLOBBY\nIN FRT LOBBY\n\nCT:\nD-AWK at POS 02
Subject: Alert: EMS ABDOMINAL PAIN\nALRM LVL: 1\nLOC:\n154 FALLENOAK CT\nLOVELD\nBTWN: RAVINEWOOD TE & DEADEND\n\nRCVD AS Phone\n\nCOM:\nM-13....VOMITING & HALLUCENATING\n\nCT:\nD-RCS at POS 02

 */

public class OHLovelandParserTest extends BaseParserTest {
  
  public OHLovelandParserTest() {
    setParser(new OHLovelandParser(), "LOVELAND", "OH");
  }
  
  @Test
  public void testParser() {

    doTest("T1",
        "Subject: Alert: EMS FALLS\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "PAXTON'S GRILL ***\n" +
        "126 W LOVELAND AV\n" +
        "LOVELD\n" +
        "BTWN: 2ND ST & RAILROAD AV\n\n\n\n" +
        "COM:\n\n\n" +
        "CT:\n" +
        "D-JMP at POS 02",

        "CALL:EMS FALLS",
        "PRI:1",
        "PLACE:PAXTON'S GRILL ***",
        "ADDR:126 W LOVELAND AV",
        "MADDR:126 W LOVELAND AVE",
        "CITY:LOVELAND",
        "X:2ND ST & RAILROAD AV",
        "INFO:D-JMP at POS 02");

    doTest("T2",
        "Subject: Alert: EMS ABDOMINAL PAIN\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "9270 CACTUS LN\n" +
        "SYMMTP\n" +
        "BTWN: MCKINNEY RD & DEADEND\n\n\n\n" +
        "COM:\n" +
        "M/58\n\n" +
        "CT:\n" +
        "D-CMS at POS 01",

        "CALL:EMS ABDOMINAL PAIN",
        "PRI:1",
        "ADDR:9270 CACTUS LN",
        "CITY:SYMMES TWP",
        "X:MCKINNEY RD & DEADEND",
        "INFO:M/58 / D-CMS at POS 01");

    doTest("T3",
        "Subject: Alert: EMS DIABETIC EMERGENCY\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "438 MAIN ST\n" +
        "LOVELD\n" +
        "BTWN: RIVERSIDE DR & WALL ST\n\n" +
        "RCVD AS 911 Call\n\n" +
        "COM:\n" +
        "F-40...LOW SUGAR\n\n" +
        "CT:\n" +
        "D-RCS at POS 02",

        "CALL:EMS DIABETIC EMERGENCY",
        "PRI:1",
        "ADDR:438 MAIN ST",
        "CITY:LOVELAND",
        "X:RIVERSIDE DR & WALL ST",
        "INFO:F-40...LOW SUGAR / D-RCS at POS 02");

    doTest("T4",
        "Subject: Alert: FIRE ODOR INVESTIGATION\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "497 N 2ND ST\n" +
        "LOVELD\n" +
        "BTWN: LYONS AV & SENTRY HILL DR\n\n" +
        "RCVD AS Phone\n\n" +
        "COM:\n" +
        "SMOKE IN THE AREA\n" +
        "POSS ON LYONS\n\n" +
        "CT:\n" +
        "D-AWK at POS 01",

        "CALL:FIRE ODOR INVESTIGATION",
        "PRI:1",
        "ADDR:497 N 2ND ST",
        "CITY:LOVELAND",
        "X:LYONS AV & SENTRY HILL DR",
        "INFO:SMOKE IN THE AREA / POSS ON LYONS / D-AWK at POS 01");

    doTest("T5",
        "Subject: Alert: EMS DIABETIC EMERGENCY\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "STATION 61\n" +
        "8871 WEEKLY LN\n" +
        "SYMMTP\n" +
        "BTWN: MASON RD & DEAD END\n\n\n\n" +
        "COM:\n" +
        "M/20\n" +
        "EMS\n" +
        "LOW BLOOD SUGAR\n" +
        "LOBBY\n" +
        "IN FRT LOBBY\n\n" +
        "CT:\n" +
        "D-AWK at POS 02",

        "CALL:EMS DIABETIC EMERGENCY",
        "PRI:1",
        "PLACE:STATION 61",
        "ADDR:8871 WEEKLY LN",
        "CITY:SYMMES TWP",
        "X:MASON RD & DEAD END",
        "INFO:M/20 / EMS / LOW BLOOD SUGAR / LOBBY / IN FRT LOBBY / D-AWK at POS 02");

    doTest("T6",
        "Subject: Alert: EMS DIABETIC EMERGENCY\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "STATION 61\n" +
        "8871 WEEKLY LN\n" +
        "SYMMTP\n" +
        "BTWN: MASON RD & DEAD END\n\n\n\n" +
        "COM:\n" +
        "M/20\n" +
        "EMS\n" +
        "LOW BLOOD SUGAR\n" +
        "LOBBY\n" +
        "IN FRT LOBBY\n\n" +
        "CT:\n" +
        "D-AWK at POS 02",

        "CALL:EMS DIABETIC EMERGENCY",
        "PRI:1",
        "PLACE:STATION 61",
        "ADDR:8871 WEEKLY LN",
        "CITY:SYMMES TWP",
        "X:MASON RD & DEAD END",
        "INFO:M/20 / EMS / LOW BLOOD SUGAR / LOBBY / IN FRT LOBBY / D-AWK at POS 02");

    doTest("T7",
        "Subject: Alert: EMS ABDOMINAL PAIN\n" +
        "ALRM LVL: 1\n" +
        "LOC:\n" +
        "154 FALLENOAK CT\n" +
        "LOVELD\n" +
        "BTWN: RAVINEWOOD TE & DEADEND\n\n" +
        "RCVD AS Phone\n\n" +
        "COM:\n" +
        "M-13....VOMITING & HALLUCENATING\n\n" +
        "CT:\n" +
        "D-RCS at POS 02",

        "CALL:EMS ABDOMINAL PAIN",
        "PRI:1",
        "ADDR:154 FALLENOAK CT",
        "CITY:LOVELAND",
        "X:RAVINEWOOD TE & DEADEND",
        "INFO:M-13....VOMITING & HALLUCENATING / D-RCS at POS 02");
      
  }
  
  public static void main(String[] args) {
    new OHLovelandParserTest().generateTests("T1");
  }
}