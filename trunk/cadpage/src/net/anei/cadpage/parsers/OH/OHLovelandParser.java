package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA1Parser;

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


public class OHLovelandParser extends DispatchA1Parser {
  
  public OHLovelandParser() {
    super(CITY_CODES, "LOVELAND", "OH");
  }
  
  @Override
  public String getFilter() {
    return "dispatcher@safety-center.org";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "LOVELD", "LOVELAND",
      "SYMMTP", "SYMMES TWP"
  });
}
