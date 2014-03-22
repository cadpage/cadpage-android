
package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchSouthernParser;

public class NCHertfordCountyBParser extends DispatchSouthernParser {

  public NCHertfordCountyBParser() {
    super(CITY_LIST, "HERTOFRD COUNTY", "NC", DSFLAG_UNIT);
  }
  
  @Override
  public String getFilter() {
    return "chiltonal911@gmail.com";
  }

  private static final String[] CITY_LIST = new String[]{
    "AHOSKIE",
    "COFIELD",
    "COMO",
    "HARRELLSVILLE",
    "MURFREESBORO",
    "WINTON"
  };
}
