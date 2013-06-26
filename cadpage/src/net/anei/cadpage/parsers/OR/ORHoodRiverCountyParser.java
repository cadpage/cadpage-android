package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;

/*
 * Klamath County, OR
 */

public class ORHoodRiverCountyParser extends DispatchA22Parser {
  
  public ORHoodRiverCountyParser() {
    super(CITY_CODES, "HOOD RIVER COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "HoodRiverDispatch@psnet.us";
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "HR", "HOOD RIVER"
  });
}
