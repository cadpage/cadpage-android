package net.anei.cadpage.parsers.KY;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * Carter County, KY
 */
public class KYCarterCountyParser extends DispatchEmergitechParser {
  
  public KYCarterCountyParser() {
    super("Carter911:", 0, CITY_LIST, "CARTER COUNTY", "KY");
  }
  
  @Override
  public String getFilter() {
    return "Carter911@windstream.net";
  }

  private static final String[] CITY_LIST = new String[]{

      "GRAYSON",
      "OLIVE HILL"

  };
}
