package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.BaseParserTest;
import net.anei.cadpage.parsers.OH.OHDelawareCountyParser;

import org.junit.Test;


public class OHDelawareCountyParserTest extends BaseParserTest {
  
  public OHDelawareCountyParserTest() {
    setParser(new OHDelawareCountyParser(), "DELAWARE COUNTY", "OH");
  }
  
  @Test
  public void testParser() {
    
    doTest("T1",
        "(Alert: Service Run-Fire) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\nRCVD AS Radio\n\nCOM:\n\nCT:\n9961 at POS 05",
        "CALL:Service Run-Fire",
        "PRI:1",
        "ADDR:210 BIG RUN RD",
        "CITY:BERLIN TWP",
        "X:STATE ROUTE 37 E & SOUTH END",
        "INFO:9961 at POS 05");

    doTest("T2",
        "(Alert: Unresponsive / Unconscious) ALRM LVL: 1\nLOC:\n4114 CURVE RD\nBERLIN TWP\nBTWN: WINDING CREEK LN & LACKEY OLD STATE RD\nRCVD AS E-911 Call\nCOM:\nPROQA Urg",
        "CALL:Unresponsive / Unconscious",
        "PRI:1",
        "ADDR:4114 CURVE RD",
        "CITY:BERLIN TWP",
        "X:WINDING CREEK LN & LACKEY OLD STATE RD",
        "INFO:PROQA Urg");
    
    doTest("T3",
        "(Alert: Gas Leak-Residential) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nPROQA Urgent Message: basement\nPROQA Urgen",
        "CALL:Gas Leak-Residential",
        "PRI:1",
        "ADDR:210 BIG RUN RD",
        "CITY:BERLIN TWP",
        "X:STATE ROUTE 37 E & SOUTH END",
        "INFO:PROQA Urgent Message: basement / PROQA Urgen");
    
    doTest("T4",
        "(Alert: Fire-Vehicle) ALRM LVL: 1\nLOC:\nALUM CREEK BIG RUN PARKING LOT NORTH (UPPER)\n606 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nVEHIC",
        "CALL:Fire-Vehicle",
        "PRI:1",
        "PLACE:ALUM CREEK BIG RUN PARKING LOT NORTH (UPPER)",
        "ADDR:606 BIG RUN RD",
        "CITY:BERLIN TWP",
        "X:STATE ROUTE 37 E & SOUTH END",
        "INFO:VEHIC");
    
    doTest("T5",
        "(Alert: Auto Accident Injuries) ALRM LVL: 1\nLOC:\nSHANAHAN RD/COLUMBUS PIKE\nBERLIN TWP\nBTWN: COLUMBUS PIKE & NORTH RD IN ORANGE TWP\n\nRCVD AS Cellular 911\nCOM:",
          "CALL:Auto Accident Injuries",
          "PRI:1",
          "ADDR:SHANAHAN RD & COLUMBUS PIKE",
          "CITY:BERLIN TWP",
          "X:COLUMBUS PIKE & NORTH RD IN ORANGE TWP");
      
  }
}