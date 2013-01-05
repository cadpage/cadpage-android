
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class NCWataugaCountyParser extends DispatchSouthernParser {
  
  private static final String[] CITY_LIST = new String[]{
    "BEECH MOUNTAIN",
    "BLOWING ROCK",
    "BOONE",
    "SEVEN DEVILS",
    
    "DEEP GAP",
    "SUGAR GROVE",
    "VALLE CRUCIS",
    "ZIONVILLE",
    "FOSCOE"
  };

  public NCWataugaCountyParser() {
    super(CITY_LIST, "WATAUGA COUNTY", "NC", DSFLAG_OPT_DISPATCH_ID);
  }
  
  @Override
  public String getFilter() {
    return "wcc911@wataugacounty.org";
  }

  @Override
  protected void parseExtra(String sExtra, Data data) {
    int pt = sExtra.indexOf(' ');
    if (pt < 0) {
      data.strCall =  sExtra;
      return;
    }
    int pt2 = sExtra.indexOf('-', pt+1);
    if (pt2 >= 0) pt = sExtra.lastIndexOf(' ', pt2);
    data.strCall = sExtra.substring(0,pt).trim();
    data.strSupp = sExtra.substring(pt+1).trim();
  }
}
