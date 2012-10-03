package net.anei.cadpage.parsers.TN;

/**
 * Sumner County, TN
 */
import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


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