package net.anei.cadpage.parsers.CA;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA22Parser;

/*
Paso Robles, CA
 */

public class CAPasoRoblesParser extends DispatchA22Parser {
  
  public CAPasoRoblesParser() {
    super(CITY_CODES, "PASO ROBLES", "CA");
  }
  
  @Override
  public String getFilter() {
    return "Cad@prcity.com";
  }

  private static Properties CITY_CODES = buildCodeTable(new String[]{
      "PR", "PASO ROBLES"
     // "SLO_CO", "SAN LUIS OBISPO COUNTY"
  });
}
