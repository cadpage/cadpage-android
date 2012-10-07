package net.anei.cadpage.parsers.IN;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * Kosciusko County, IN
 */
public class INKosciuskoCountyParser extends DispatchOSSIParser {
  
  public INKosciuskoCountyParser() {
    super(CITY_CODES, "KOSCIUSKO COUNTY", "IN",
           "FYI CALL ADDR APT? CITY! END");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CLAY", "CLAYPOOL",
      "MILF", "MILFORD",
      "PIER", "PIERCETON",
      "SYR",  "SYRACUSE",
      "WAR",  "WARSAW",
      "WL",   "WINONA LAKE"
  });
}
