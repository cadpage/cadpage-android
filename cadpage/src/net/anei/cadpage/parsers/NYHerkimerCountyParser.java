package net.anei.cadpage.parsers;

import java.util.Properties;

import net.anei.cadpage.SmsMsgInfo.Data;

/* 
Sample Herkimer Pages
Contact: Robert Tucker <mobilewlightn@gmail.com>
Sender: HC911@herkimercounty.org <From%3AHC911@herkimercounty.org>
(EMS   >EMS CALL) 185 GUIDEBOARD RD XS: DAIRY HILL RD NORWAY AAAAAAA AAAAAAA 3150000000 Map: Grids:, Cad: 2010-0000049305
(MVA   >MOTOR VEHICLE ACCIDENT) 5781 STHY 28 XS: TOWN LINE NEWPORT AAAAAA AAAAA 3150000000 Map: Grids:, Cad: 2010-0000049651
(EMS   >EMS CALL) 808 OLD STATE RD NEWPORT AAAAAAAA 8880000000 Map: Grids:, Cad: 2010-0000049432
(EMS   >EMS CALL) 3141 MECHANIC ST XS: MAIN ST NEWPORT VILLAGE JOHN 3157179999 Map: Grids:, Cad: 2010-0000058093
(EMS   >EMS CALL) 3746 BLACK CREEK RD Apt: C Bldg XS: TAYLOR BROOK RD RUSSIA SMITH, E 3158265805 Map: Grids:,Cad: 2010-0000058750
(FIREST>STRUCTURE FIRE) 1316 HARD SCRABBLE RD XS: BEGIN ESN 029 FAIRFIELD JONES, CORA 3158913818 Map: Grids:, Cad: 2010-0000060399
(LIFT  >LIFT ASSIST/NON EMER EMS) 3746 BLACK CREEK RD Apt: LOTC Bldg XS: TAYLOR BROOK RD RUSSIA JOHN SMITH 3158265805 Map: Grids:, Cad: 2010-0000064384

Contact: Chris Conover <conovercj@ntcnet.com>
Sender: HC911@herkimercounty.org
(EMS>EMS CALL) 112 N Main St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(EMS>EMS CALL) 54 Fairfield St\nGrids:,, NY X:Fairfield St\nMiddleville Village Smith, John\n5419991234 MAP:
(LIFT>LIFT ASSIST/NON EMER EMS)\n112 N Main St Grids:,, NY\nX:Fairfield St Smith, John\n5419991234 MAP:

*/

public class NYHerkimerCountyParser extends SmartAddressParser {
  
  private static final String DEF_CITY = "HERKIMER COUNTY";
  private static final String DEF_STATE = "NY";
  
  private static final String[] CITY_LIST =  
    {"NORWAY", "NEWPORT", "RUSSIA", "POLAND", "NEWPORT", "FAIRFIELD",
     "MIDDLEVILLE", "OHIO", "DEERFIELD"}; 
  
  private static final String[] KEYWORDS = 
    new String[]{"Loc", "Map:", "Grids", "Cad"};
  
  public NYHerkimerCountyParser() {
    super(CITY_LIST, DEF_STATE);
  }

  @Override
  public boolean isPageMsg(String body) {
    return body.contains(" Grids:");
  }

  @Override
  protected void parse(String body, Data data) {
    
    data.defState=DEF_STATE;
    data.defCity = DEF_CITY;
    
    body = "Loc: " + body.trim();
    Properties props = parseMessage(body, KEYWORDS);
    
    // First field is the hardest
    // Parse call description from front
    String line = props.getProperty("Loc", "");
    if (line.length() < 10) return;
    if (line.charAt(0) == '(') {
      int pt = line.indexOf(')');
      if (pt >= 1) {
        data.strCall = line.substring(1, pt);
        data.strCall = data.strCall.replaceAll("\\s+>", ">");
        line = line.substring(pt+1).trim();
      }
    }
    
    // Call smart parser for rest of it
    parseAddress(StartType.START_ADDR, line, data);
    
    // Fish out cad page and we're done
    
    // Strip CAD number off end of message
    data.strCallId = props.getProperty("Cad", "");
  }
}
