package net.anei.cadpage.parsers.IA;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

/**
 * Oldham County, KY
 */
public class IADickinsonCountyParser extends DispatchEmergitechParser {
  
  public IADickinsonCountyParser() {
    super("DC911:", true, null, CITY_LIST, "DICKINSON COUNTY", "IA");
  }
  
  public String getFilter() {
    return "DC911@secureserver.net";
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Incorporated Cities
    "ARNOLDS PARK",
    "LAKE PARK",
    "MILFORD",
    "OKOBOJI",
    "ORLEANS",
    "SPIRIT LAKE",
    "SUPERIOR",
    "TERRIL",
    "WAHPETON",
    "WEST OKOBOJI",
    
    // Unincorporated Communities
    "MONTGOMERY",
    
    // Townships
    "CENTER GROVE TWP",
    "DIAMOND LAKE TWP",
    "EXCELSIOR TWP",
    "LAKEVILLE TWP",
    "LLOYD TWP",
    "MILFORD TWP",
    "OKOBOJI TWP",
    "RICHLAND TWP",
    "SILVER LAKE TWP",
    "SPIRIT LAKE TWP",
    "SUPERIOR TWP",
    "WESTPORT TWP"
  };
}
