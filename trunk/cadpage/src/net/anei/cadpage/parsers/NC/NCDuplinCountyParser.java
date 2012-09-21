package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

/* 
Duplin County, NC
Contact: Jeffrey Allen <jeffrey.allen84@gmail.com>
Sender: D.CHAMBERS@duplincountync.com

D.CHAMBERS:113 GEORGE RD FAISON WARREN RD - SR 1301 X DEAD END 15:50:43 ILLNESS CALLER ADV SHE IS AT A NEIGHBORS HOUSE, BELIEVES HE IS INSIDE AND POSS SICK ADV HE HAS BEEN SICK RE @ 1322 WARREN RD SR 1301 TO DEAD END
T.KENNEDY:353 E I 40 MM CALLEWR DUPLIN 12:34:02
T.KENNEDY:110 E MAIN ST EXT FAISON 16:15:11
T.KENNEDY:1 16:37:58 OUT OF SERVICE FOR ANY REASON FAISON RESCUE 5 10-17 BRUSH WILL RESPONSE IN THERE PLACE OCA: 2012001083
T.KENNEDY:364 I 40 MM DUPLIN 15:50:25 ACCIDENT-PROPERTY DAMAGE ONLY AND FAISON EXIT NO ONE IS HURT GREY HONDA AND A SILEVR TAURUS VEHICLES IN RD DUPLIN I 40

*/

public class NCDuplinCountyParser extends DispatchSouthernParser {
  
  
  public NCDuplinCountyParser() {
    super(CITY_LIST, "DUPLIN COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL | DSFLAG_FOLLOW_CROSS);
  }
  
  @Override
  public String getFilter() {
    return "@duplincountync.com";
  }
  
  @Override
  protected boolean parseMsg(String field, Data data) {
    if (!super.parseMsg(field, data));
    if (data.strCity.equals("DUPLIN")) data.strCity = "";
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    "DUPLIN",
    
    // Cities
    "BEULAVILLE",
    "CALYPSO",
    "CHINQUAPIN",
    "FAISON",
    "FOUNTAINTOWN",
    "GREENEVERS",
    "HARRELLS",
    "KENANSVILLE",
    "MAGNOLIA",
    "ROSE HILL",
    "SARECTA",
    "TEACHEY",
    "WALLACE",
    "WARSAW",
    
    // Townships
    "ALBERTSON",
    "CYPRESS CREEK",
    "FAISON",
    "GLISSON",
    "ISLAND CREEK",
    "KENANSVILLE",
    "LIMESTONE",
    "MAGNOLIA",
    "ROCKFISH",
    "ROSE HILL",
    "SMITH",
    "WALLACE",
    "WARSAW",
    "WOLFSCRAPE",
  };

}
