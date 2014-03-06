package net.anei.cadpage.parsers.OR;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;

/*
Hood River County, OR
 */

public class ORShermanCountyParser extends DispatchA22Parser {
  
  public ORShermanCountyParser() {
    super(CITY_CODES,"SHERMAN COUNTY", "OR");
  }
  
  @Override
  public String getFilter() {
    return "april.steam@tcdispatch.org";
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "GV", "GRASS VALLEY"
  });
}
