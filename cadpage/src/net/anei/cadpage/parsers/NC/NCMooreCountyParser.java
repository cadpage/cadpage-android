package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;


public class NCMooreCountyParser extends DispatchSouthernParser {
  
  public NCMooreCountyParser() {
    super(CITY_LIST, "MOORE COUNTY", "NC", DSFLAG_UNIT);
  }
  
  @Override
  public String getFilter() {
    return "dispatch911@moorecountync.gov";
  }
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    data.strAddress = data.strAddress.replace('@', '&');
    if (data.strAddress.contains("&") && data.strAddress.startsWith("1 ")) {
      data.strAddress = data.strAddress.substring(2).trim();
    }
    return true;
  }
  
  private static final String[] CITY_LIST = new String[]{
    "ABERDEEN",
    "CAMERON",
    "CARTHAGE",
    "FOXFIRE",
    "PINEBLUFF",
    "PINE BLUFF",
    "PINEHURST",
    "ROBBINS",
    "SEVEN LAKES",
    "SOUTHERN PINES",
    "TAYLORTOWN",
    "VASS",
    "WEST END",
    "WHISPERING PINES",
    
    "CARTHAGE TWP",
    "BENSALEM TWP",
    "SHEFFIELDS TWP",
    "RITTER TWP",
    "DEEP RIVER TWP",
    "GREENWOOD TWP",
    "MCNEILL TWP",
    "SANDHILL TWP",
    "MINERAL SPRINGS TWP",
    "LITTLE RIVER TWP"
  };
}
