package net.anei.cadpage.parsers.NC;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchOSSIParser;

/**
 * fAlamance county, NC
 */
public class NCAlamanceCountyParser extends DispatchOSSIParser {
  
  public NCAlamanceCountyParser() {
    super(CITY_CODES, "ALAMANCE COUNTY", "NC",
           "ID?: CALL ADDR CITY X X INFO+");
  }
  
  @Override
  public String getFilter() {
    return "CAD@alamance-nc.com";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "GRAH",  "GRAHAM",
      "GREE",  "GREEN LEVEL",
      "HAW",   "HAW RIVER",
      "MEB",   "MEBANE",
      "BURL",  "BURLINGTON",
      "GIB",   "GIBSONVILLE",
      "ELON",  "ELON",
      "LIB",   "LIBERTY",
      "SWEP",  "SWEPSONVILLE",
      "SNOW",  "SNOW CAMP"
  });
}
