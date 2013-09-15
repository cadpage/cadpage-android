package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.MsgInfo.Data;
import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Gallatin County, KY
 */
public class KYGallatinCountyParser extends DispatchA29Parser {
  
  public KYGallatinCountyParser() {
    super(CITY_LIST, "GALLATIN COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@insightbb.com";
  }
  
  @Override
  public boolean parseMsg(String body, Data data) {
    if (!super.parseMsg(body, data)) return false;
    if (data.strCity.equalsIgnoreCase("GALLATIN COUNTY")) data.strCity = "";
    return true;
  }

  private static final String[] CITY_LIST = new String[]{
    "GLENCOE",
    "SPARTA",
    "WARSAW",
    
    "GALLATIN COUNTY"
  };
}
