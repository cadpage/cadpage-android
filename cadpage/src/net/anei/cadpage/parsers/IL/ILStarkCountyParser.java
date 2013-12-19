package net.anei.cadpage.parsers.IL;

import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Stark County, IL
 */
public class ILStarkCountyParser extends DispatchA29Parser {
  
  public ILStarkCountyParser() {
    super(CITY_LIST, "STARK COUNTY", "IL");
  }
  
  @Override
  public String getFilter() {
    return "messaging@iamresponding.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "BRADFORD",
    "LA FAYETTE",
    "TOULON",
    "WYOMING",

    // Unincorporated communities
    "CASTLETON",
    "DUNCAN",
    "ELMIRA",
    "LOMBARDVILLE",
    "MODENA",
    "OSCEOLA",
    "SAXTON",
    "SPEER",
    "STARK",
    "WEST JERSEY",

    // Townships
    "ELMIRA TWP",
    "ESSEX TWP",
    "GOSHEN TWP",
    "OSCEOLA TWP",
    "PENN TWP",
    "TOULON TWP",
    "VALLEY TWP",
    "WEST JERSEY TWP",
    
    // Henry County
    "GALVA",
    "WOODHULL",
    
    // Tippecanoe County
    "LAFAYETTE"
  };
}
