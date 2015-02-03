package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;

/*
Paso Robles, CA
 */

public class CAGroverBeachParser extends DispatchA22Parser {
  
  public CAGroverBeachParser() {
    super(CITY_CODES, "", "CA");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@GBPD.ORG";
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "OC",             "OCEANO", 
      "GROVER BEA",     "GROVER BEACH"
  });
}
