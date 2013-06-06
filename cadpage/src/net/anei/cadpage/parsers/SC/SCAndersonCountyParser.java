package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class SCAndersonCountyParser extends DispatchB2Parser {
  
  private static final String[] MARKERS = new String[] {
    "ANDERSON CO 911:",
    "AND 911:",
    "active911:",
    "06-wp:",
    "13-pie:",
    "20-hop:",
    "als10:",
    "ems1:",
    "esadmin:",
    "childcnty:",
    "afdtrt:"
  };
 
  public SCAndersonCountyParser() {
    super(CITY_CODES, "ANDERSON COUNTY", "SC");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return true;
  }
  
  @Override
  protected boolean parseMsg(String subject, String body, Data data) {
    
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
    if (subject.equals("EVENT")) subject = "EVENT:";
    body = append(subject, " ", body);
    
    // Call superclass parser
    body = body.replace('@', '&').replace("//", "/");
    return super.parseMsg(body, data);
  }
  
  private static final String[] CITY_CODES = new String[]{
    "ANDERSON", 
    "BELTON", 
    "CLEMSON", 
    "EASLEY",
    "HONEA PATH",
    "IVA",
    "PELZER", 
    "STARR",
    "WEST PELZER",
    "WILLIAMSTON",
    "CENTERVILLE",
    "HOMELAND PARK",
    "LA FRANC",
    "NORTHLAKE",
    "PIEDMONT", 
    "POWDERSVILLE",
    "SANDY SPRINGS",
    "TOWNVILLE",
    
    "PENDLETON"
  };
}
