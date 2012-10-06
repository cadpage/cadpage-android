package net.anei.cadpage.parsers.CT;

import java.util.Properties;



public class CTHartfordCountyParser extends CTNewHavenCountyBParser {
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{});
  
  public CTHartfordCountyParser() {
    super(CITY_CODES, "HARTFORD COUNTY", "CT");
  }
  
  public CTHartfordCountyParser(Properties cityCodes, String defCity, String defState) {
    super(cityCodes, defCity, defState);
  }
  
  @Override
  public String getFilter() {
    return "pdpaging@farmington-ct.org";
  }
}
