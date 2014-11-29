package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;



public class NCMontgomeryCountyParser extends DispatchSouthernParser {
  
  
  public NCMontgomeryCountyParser() {
    super(CITY_LIST, "MONTGOMERY COUNTY", "NC", DSFLAG_DISPATCH_ID | DSFLAG_ID_OPTIONAL | DSFLAG_LEAD_PLACE);
  }
  
  @Override
  public String getFilter() {
    return "@montgomerycountync.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    
    if (!body.startsWith("CAD:")) return false;
    return super.parseMsg(body, data);
  }
  
  @Override
  protected void parseExtra(String sExtra, Data data) {
    Parser p = new Parser(sExtra);
    data.strCall = p.get(" - ");
    data.strSupp = p.get();
  }

  private static final String[] CITY_LIST = new String[] {
    "BISCOE",
    "BLACK ANKLE",
    "CANDOR",
    "ETHER",
    "JACKSON SPRINGS",
    "MT GILEAD",
    "NEW LONDON",
    "OKEEWEMEE",
    "OPHIR",
    "PEE DEE",
    "SEAGROVE",
    "STAR",
    "STEEDS",
    "TROY",
    "WINDBLOW"
  };
}
