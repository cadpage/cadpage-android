
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCMcDowellCountyParser extends DispatchSouthernParser {

  public NCMcDowellCountyParser() {
    super(CITY_LIST, "MCDOWELL COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL | DSFLAG_FOLLOW_CROSS);
  }

  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (! super.parseMsg(body, data)) return false;
    if (data.strAddress.startsWith("0 ")) data.strAddress = data.strAddress.substring(2).trim();
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    //cities
    "MARION",
    
    //towns
    "OLD FORT",
    
    //Census-designated place
    "WEST MARION",
    
    //Unincorporated communities

    "GLENWOOD",
    "LINVILLE FALLS",
    "LITTLE SWITZERLAND",
    "NEBO",
    "NORTH COVE",
    "PLEASANT GARDENS",
    "PROVIDENCE",

    //townships
    "CROOKED CREEK",
    "DYSARTSVILLE",
    "MONTFORD COVE",
    "PLEASANT GARDENS",
    "WOODLAWN-SEVIER",
    "SUGAR HILL"
 
  };
}
