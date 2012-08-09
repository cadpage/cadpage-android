package net.anei.cadpage.parsers.SC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Anderson County, SC
Contact: Kevin Blakely <kblakely@sgfdfire.com>
Sender: varies
System: Interact GIS 5.16

ANDERSON CO 911:29B1 >MVA-ALS PRI1 3814 N HIGHWAY 29 XS: BROOKS RD - DORCHESTER RD BELTON PLATINUM PLUS Map: Grids:0,0 Cad: 2011-0000004351
ANDERSON CO 911:29B4 >MVA-ALS PRI1 HIGHWAY 29 N MICHAEL QUEEN2214421 Cad: 2011-0000004070
ANDERSON CO 911:32 >UNKNOWN PROBLEM 1216 ROUND ABOUT TRL JOSH 201-4436 Cad: 2011-0000004370
ANDERSON CO 911:17B1 >FALLS-ALS PRI1-FR 110 FRANKLIN RD ANDERSON HAWKINS, PAUL Map: Grids:0,0 Cad: 2011-0000004223
ANDERSON CO 911:31 >UNCONSCIOUS/FAINTING 210 KIRK LN Apt: 11 Bldg PENDLETON6463347 MICHELLE DURHAM Map: Grids:0,0 Cad: 2011-0000004465
ANDERSON CO 911:13A1 >DIABETIC-ALS PRI2 7900 HIGHWAY 76 PENDLETON OFFICER SUMMERS 934-3443 Map: Grids:0,0 Cad: 2011-0000004494

Contact: afd_jlo@yahoo.com <afd_jlo@yahoo.com> 
Sender: 8643146900
AND 911:17A01 >FALLS-BLS PRI2 141 ASHTON LN Apt: 141 Bldg ANDERSON LOUIE SHEILDS 6264049863 Map: Grids:0,0 Cad: 2011-0000202072

Contact: support@active911.com
Sender: @andersonsheriff.com>
active911: FIRE ALARM 201 EDGEBROOK DR XS: HWY 81 N Cad: 2012-0000120876

*/

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
