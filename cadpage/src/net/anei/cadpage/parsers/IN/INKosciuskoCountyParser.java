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
      "952",  "MARION",
      "AKRN", "AKRON",
      "ATW",  "ATWOOD",
      "BOUR", "BOURBON",
      "BREM", "BREMEN",
      "BRK",  "BURKET",
      "CLAY", "CLAYPOOL",
      "COL",  "COLUMBIA CITY",
      "CROM", "CROMWELL",
      "EG",   "ETNA GREEN",
      "LAR",  "LARWILL",
      "LEES", "LEESBURG",
      "MENT", "MENTONE",
      "MILF", "MILFORD",
      "NAPP", "NAPPANEE",
      "NW",   "NORTH WEBSTER",
      "PIER", "PIERCETON",
      "PLY",  "PLYMOUTH",
      "ROA",  "ROANN",
      "ROCH", "ROCHESTER",
      "SID",  "SIDNEY",
      "SL",   "SILVER LAKE",
      "SWHT", "SOUTH WHITLEY",
      "SYR",  "SYRACUSE",
      "WAR",  "WARSAW",
      "WL",   "WINONA LAKE"
      
  });
}
