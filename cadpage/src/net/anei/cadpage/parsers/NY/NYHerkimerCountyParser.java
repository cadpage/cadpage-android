package net.anei.cadpage.parsers.NY;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

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

Contact: russell johnson <rjohnson185@gmail.com>
264 CHURCH ST XS: N ANN ST LITTLE FALLS CITY SLABE,CAROL 3158231466 Map: Grids:, Cad: 2010-0000068836
168 FURNACE ST Apt: 1 Bldg XS: W MAIN ST LITTLE FALLS CITY SCLARZ, RANDY 3155085302 Map: Grids:, Cad: 2010-0000068790I
*/

public class NYHerkimerCountyParser extends DispatchBParser {
  
  private static final String DEF_CITY = "HERKIMER COUNTY";
  private static final String DEF_STATE = "NY";
  
  private static final String[] CITY_LIST =  
    {"NORWAY", "NEWPORT", "RUSSIA", "POLAND", "NEWPORT", "FAIRFIELD",
     "MIDDLEVILLE", "OHIO", "DEERFIELD", "LITTLE FALLS CITY"}; 
  
  public NYHerkimerCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }
  
  @Override
  public String getFilter() {
    return "HC911@herkimercounty.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    if (!super.isPageMsg(body) && !body.contains("Grids:,, NY")) return false; 
    body = "(" + subject + ") " + body.replaceAll("\n", " ").replaceAll(" Grids:,, NY ", " ");
    return super.parseMsg(body, data);
  }
  
  @Override
  public boolean parseAddrField(String line, Data data) {
    if (line.length() < 10) return false;
    if (line.charAt(0) == '(') {
      int pt = line.indexOf(')');
      if (pt < 0) return false;
      data.strCall = line.substring(1, pt);
      data.strCall = data.strCall.replaceAll("\\s+>", ">");
      line = line.substring(pt+1).trim();
    }
    
    // Call smart parser for rest of it
    parseAddress(StartType.START_ADDR, line, data);
    return true;
  }
}
