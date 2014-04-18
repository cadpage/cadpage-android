package net.anei.cadpage.parsers.MI;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;


public class MICalhounCountyBParser extends DispatchOSSIParser {
  
  public MICalhounCountyBParser() {
    super(MICalhounCountyParser.CITY_TABLE, "CALHOUN COUNTY", "MI",
          "FYI? DATETIME CALL ADDR! CITY INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@calhouncountymi.gov";
  }
  
  
  @Override
  protected boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    MICalhounCountyParser.cleanup(data);
    return true;
  }
}
