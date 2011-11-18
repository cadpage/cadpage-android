package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.SmsMsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchBParser;

/*
Dade County, GA
Contact: "unit20@msn.com" <unit20@msn.com>
DADE COUNTY 911:M10 >CHEST PAIN 367 GRAY RD XS: 224 FAWN DAWN DR. NEW SALEM KATY DILLS Map:10-D1,E1 Grids:0,0 Cad: 2011-0000000796
DADE COUNTY 911:M26 >SICK PERSON 391 BIBLE GULF RD XS: 869 TATUM GULF RD OFF OLD STATE RD HEAD RIVER KEATON, GLENN Map:12-D2 Grids:0,0 Cad: 2011-0000000651
DADE COUNTY 911:M5 >FALL - ANY 2862 YANKEE RD XS: HWY 157 S HEAD RIVER KEENER, CAROL Map:11,12 Grids:0,0 Cad: 2011-0000001152
DADE COUNTY 911:50PI >M.V.A. - POSSIBLE INJURIES 13500 HWY 136 E XS: N & S MOORE RD NEW SALEM ROBERTS, CHIP Map:6,15 Grids:0,0 Cad: 2011-0000000992
DADE COUNTY 911:M1 >ABDOMINAL PAIN/PROBLEM 2321 OLD STATE RD XS: 16548 HWY 157 S HEAD RIVER CHAD LANIER Map:11,12 Grids:0,0 Cad: 2011-0000001270
DADE COUNTY 911:78 >ASSISTANCE/ MUTUAL AID 84 RUSHING WATER TRL CHRISTY / WALKER Cad: 2011-0000001334

Contact: Rodney <unit20@msn.com>
Sender: 4238021533
DADE COUNTY 911:78 >ASSISTANCE/ MUTUAL AID 8376 HWY 157 S HEAD RIVER WALKER CO Cad: 2011-0000015531

*/

public class GADadeCountyParser extends DispatchBParser {
  
  private static final String[] CITY_LIST = new String[]{
    "NEW SALEM", "HEAD RIVER"
  };

  private static final String DEF_STATE = "GA";
  private static final String DEF_CITY = "DADE COUNTY";
 
  public GADadeCountyParser() {
    super(CITY_LIST, DEF_CITY, DEF_STATE);
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("DADE COUNTY 911:");
  }

  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    
    // The field we parse as a city isn't recognized by Google maps.  We'll
    // switch it to the Place field where at least it will show up on the screen
    // but won't interfere with mapping
    if (data.strPlace.length() == 0) data.strPlace = data.strCity;
    data.strCity = "";
    return true;
  }
}
