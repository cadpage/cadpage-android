package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.SmsMsgParser;

/*
Deleware County, OH
Contact: ryan kirby <ryankirby950@gmail.com>
Sender: 911@co.delaware.oh.us

(Alert: Service Run-Fire) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\nRCVD AS Radio\n\nCOM:\n\nCT:\n9961 at POS 05
(Alert: Unresponsive / Unconscious) ALRM LVL: 1\nLOC:\n4114 CURVE RD\nBERLIN TWP\nBTWN: WINDING CREEK LN & LACKEY OLD STATE RD\nRCVD AS E-911 Call\nCOM:\nPROQA Urg
(Alert: Gas Leak-Residential) ALRM LVL: 1\nLOC:\n210 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nPROQA Urgent Message: basement\nPROQA Urgen
(Alert: Fire-Vehicle) ALRM LVL: 1\nLOC:\nALUM CREEK BIG RUN PARKING LOT NORTH (UPPER)\n606 BIG RUN RD\nBERLIN TWP\nBTWN: STATE ROUTE 37 E & SOUTH END\n\nCOM:\nVEHIC
(Alert: Auto Accident Injuries) ALRM LVL: 1\nLOC:\nSHANAHAN RD/COLUMBUS PIKE\nBERLIN TWP\nBTWN: COLUMBUS PIKE & NORTH RD IN ORANGE TWP\n\nRCVD AS Cellular 911\nCOM:
 */


public class OHDelewareCountyParser extends SmsMsgParser {
  
  public OHDelewareCountyParser() {
    super("DELEWARE COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "911@co.delaware.oh.us";
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
    if (! subject.startsWith("Alert: ")) return false;
    data.strCall = subject.substring(7).trim();

    String[] lines = body.split("\n");
    
    // First line is ignored
        
    // Second line always contains LOC: keyword
    if (lines.length <= 1) return false;
    if (!lines[1].equals("LOC:")) return false;

    // The location section may contain 2 or 3 lines
    // Skip ahead to find the cross street line and work backward from it
    int ndx = 4;
    for ( ; ndx<=5; ndx++) {
      if (ndx >= lines.length) return false;
      String line = lines[ndx];
      if (line.startsWith("BTWN: ")) {
        data.strCross = line.substring(6).trim();
        break;
      }
    }
    if (ndx > 5) return false;
    
    // Line just before the cross street lines contains the town
    data.strCity = lines[--ndx];
    
    // Line before that contains the address
    parseAddress(lines[--ndx], data);
    
    // If there is a line before that, it contains the place name
    if (--ndx > 1) data.strPlace = lines[ndx];
    
    return true;
  }
}
