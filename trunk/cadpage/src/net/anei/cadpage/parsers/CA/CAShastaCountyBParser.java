package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchArchonixParser;


/**
 * Shasta County, CA (B)
 */
public class CAShastaCountyBParser extends DispatchArchonixParser {
  
  public CAShastaCountyBParser() {
    super(CITY_CODES, "SHASTA COUNTY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "cccademail@shascom911.com";
  }
  
  @Override
  public int getMapFlags() {
    return MAP_FLG_SUPPR_LA;
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "RE", "REDDING"
  });
}
