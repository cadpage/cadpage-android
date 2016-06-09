package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchSPKParser;

/**
 * Johnson County, KY
 */

public class KYJohnsonCountyParser extends DispatchSPKParser {
  
  public KYJohnsonCountyParser() {
    super("JOHNSON COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "CADPJC911@CityofPaintsville.net";
  }

}
