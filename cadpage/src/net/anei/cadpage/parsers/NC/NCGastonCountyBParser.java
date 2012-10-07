package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA9Parser;

/**
 * Gaston County, NC
 */

public class NCGastonCountyBParser extends DispatchA9Parser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "COUNTY",    ""
  });
  
  public NCGastonCountyBParser() {
    super(CITY_CODES, "GASTON COUNTY", "NC");
  }
  
  @Override
  public String getFilter() {
    return "NWSAdmin@cityofgastonia.com";
  }
}
