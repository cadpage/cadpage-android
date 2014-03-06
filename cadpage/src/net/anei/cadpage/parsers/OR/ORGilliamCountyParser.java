package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;

/*
Hood River County, OR
 */

public class ORGilliamCountyParser extends DispatchA22Parser {
  
  public ORGilliamCountyParser() {
    super(CITY_CODES, "GILLIAM COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "april.steam@tcdispatch.org";
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "ARL", "ARLINGTON",
      "CON", "CONDON",
      "LON", "LONEROCK"
  });
}
