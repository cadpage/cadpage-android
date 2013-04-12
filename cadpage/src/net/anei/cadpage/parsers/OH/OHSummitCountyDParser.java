package net.anei.cadpage.parsers.OH;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA5Parser;

/**
 * Summit County, OH
 */
public class OHSummitCountyDParser extends DispatchA5Parser {
  
  public OHSummitCountyDParser() {
    super(CITY_CODES, "SUMMIT COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "MAKRINOSL@STOW.OH.US";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "BrimTwpPC",    "Brimfield Twp",
  });
  
}