package net.anei.cadpage.parsers.TN;


import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Sumner County, TN
Contact: alan fulwood <nofd1236@gmail.com>
Sender: None

INITIAL.\nSC EMS COMMUNICATIONS:42 >NON-SPECIFIC DIAGNOSIS 521 SHUTE LN XS: SHORESIDE DR HENDERSONVILLE  MIKE 6158249869 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:50 >STROKE-CVA 114 MOONLIGHT DR HENDERSONVILLE AT&T MOBILITY 6153058788 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1109 LAKE RISE OVERLOOK HENDERSONVILLE L., JOHN 6158264086 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:43 >OTHER-FIRE 209 BROOKHAVEN DR GALLATIN W., MYRA 6154529951 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:32 >HAZARDOUS MATERIALS 2079 MORGANS WAY GALLATIN Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:10 >BREATHING PROBLEMS A 1080 BRADLEY RD GALLATIN E., ROGER D 6154528905 Map: Grids:0,0
INITIAL.\nSC EMS COMMUNICATIONS:2 >FIRE ALARM 1005 LAKE RISE PL HENDERSONVILLE HAY, BRUCE 6158262033 Map: Grids:0,0

*/

public class TNSumnerCountyParser extends DispatchBParser {
  
  private static final String[] CITY_LIST = new String[]{
    "BETHPAGE", "CASTALIAN SPRINGS", "COTTONTOWN", "GALLATIN", "GOODLETTSVILLE", 
    "HENDERSONVILLE", "MILLERSVILLE", "MITCHELLVILLE", "PORTLAND", "WALNUT GROVE", 
    "WESTMORELAND", "WHITE HOUSE"
  };
  
  private static final String MARKER = "SC EMS COMMUNICATIONS:";
  
  public TNSumnerCountyParser() {
    super(CITY_LIST, "SUMNER COUNTY", "TN");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }

  @Override
  protected boolean parseAddrField(String field, Data data) {
    int pt = field.indexOf(MARKER);
    if (pt < 0) return false;
    pt += MARKER.length();
    int pt2 = field.indexOf('>', pt);
    if (pt2 < 0) return false;
    data.strCallId = field.substring(pt, pt2).trim();
    return super.parseAddrField(field, data);
  }
  
  
}