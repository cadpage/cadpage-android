package net.anei.cadpage.parsers.MO;

import java.util.Properties;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchCiscoParser;

/**
 * Washington County, MO
 */

public class MOWashingtonCountyParser extends DispatchCiscoParser {
    
  public MOWashingtonCountyParser() {
    super(CITY_CODES, "WASHINGTON COUNTY", "MO");
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    return super.parseMsg(body.replace('\n', ' ').replace("!",""), data);
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "POTO",   "POTOSI"
  });
}
