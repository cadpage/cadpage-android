
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCColumbusCountyParser extends DispatchSouthernParser {

  public NCColumbusCountyParser() {
    super(CITY_LIST, "COLUMBUS COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_LEAD_PLACE | DSFLAG_CROSS_NAME_PHONE);
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strApt.equals("SHOPPING CTR")) {
      data.strAddress = append(data.strAddress, " ", data.strApt);
      data.strApt = "";
    }
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
    "BOARDMAN",
    "BOLTON",
    "BRUNSWICK",
    "CERRO GORDO",
    "CHADBOURN",
    "CLARENDON",
    "FAIR BLUFF",
    "LAKE WACCAMAW",
    "SANDYFIELD",
    "TABOR CITY",
    "WHITEVILLE"
    
  };
}
