package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA58Parser;

public class CACathedralCityParser extends DispatchA58Parser {

  public CACathedralCityParser() {
    super("CCPD Alliance Message", CITY_CODES, "CATHEDRAL CITY", "CA");
  }

  private static Properties CITY_CODES = buildCodeTable(new String[] { 
      "CTHDRL CTY",   "Cathedral City" 
  });

}
