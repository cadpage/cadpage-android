package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class SCAndersonCountyParser extends DispatchBParser {
  
  private static final String[] MARKERS = new String[] {
    "ANDERSON CO 911:",
    "AND 911:",
    "active911:"
  };
  
  private static final String[] CITY_CODES = new String[]{
    "ANDERSON", "BELTON", "CLEMSON", "EASLEY", "HONEA PATH", "IVA", "PELZER", 
    "STARR", "WEST PELZER", "WILLIAMSTON",
    "CENTERVILLE", "HOMELAND PARK", "LA FRANC", "NORTHLAKE", "PIEDMONT", 
    "POWDERSVILLE", "SANDY SPRINGS", "TOWNVILLE",
    
    "PENDLETON"
  };
 
  public SCAndersonCountyParser() {
    super(CITY_CODES, "ANDERSON COUNTY", "SC");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    
    // See if this is one of our pages
    boolean good = false;
    for (String marker : MARKERS) {
      if (body.startsWith(marker)) {
        body = body.substring(marker.length()).trim();
        good = true;
        break;
      }
    }
    if (!good) return false;
    
    int pt = body.indexOf('>');
    if (pt >= 0) data.strCode = body.substring(0,pt).trim();
    
    // Call superclass parser
    return super.parseMsg(body, data);
    
  }
}
