package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA3Parser;

public class CASuisunCityBParser extends DispatchA3Parser {
  
  public CASuisunCityBParser() {
    super(0, CITY_CODES, "SUISUN CITY", "CA");
  }
  
  @Override
  public String getFilter() {
    return "alfredabruzzini@yahoo.com";
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "DIX",   "DIXON",
      "FRFLD", "FAIRFIELD"
  });
}
