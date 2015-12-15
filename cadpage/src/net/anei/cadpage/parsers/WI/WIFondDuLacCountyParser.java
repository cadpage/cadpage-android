package net.anei.cadpage.parsers.WI;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA41Parser;

public class WIFondDuLacCountyParser extends DispatchA41Parser {

  public WIFondDuLacCountyParser() {
    super("CALLALERT:", CITY_CODES, "FOND DU LAC COUNTY", "WI", "FA|FF");
  }
  
  @Override
  public String getFilter() {
    return "cadmail@fdlco.wi.gov";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "FDL", "FOND DU LAC",
  });
}
