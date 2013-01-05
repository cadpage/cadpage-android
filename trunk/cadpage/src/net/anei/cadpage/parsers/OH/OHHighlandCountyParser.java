package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;



public class OHHighlandCountyParser extends DispatchEmergitechParser {
  
  public OHHighlandCountyParser() {
    super("Dispatch:", 69, CITY_LIST, "HIGHLAND COUNTY", "OH");
  }
  
  @Override
  public String getFilter() {
    return "Dispatch@highlandcoso.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Mutual aid counties
    "FAYETTE COUNTY",

    // Cites
    "HILLSBORO",
    
    // Villages
    "GREENFIELD",
    "HIGHLAND",
    "LEESBURG",
    "LYNCHBURG",
    "MOWRYSTOWN",
    "SINKING SPRING",
    
    // Townships
    "BRUSHCREEK TWP",
    "CLAY TWP",
    "CONCORD TWP",
    "DODSON TWP",
    "FAIRFIELD TWP",
    "HAMER TWP",
    "JACKSON TWP",
    "LIBERTY TWP",
    "MADISON TWP",
    "MARSHALL TWP",
    "NEW MARKET TWP",
    "PAINT TWP",
    "PENN TWP",
    "SALEM TWP",
    "UNION TWP",
    "WASHINGTON TWP",
    "WHITEOAK TWP",
    
    // Unincorporated communities
    "ALLENSBURG",
    "BELFAST",
    "BERRYSVILLE",
    "BOSTON",
    "BRIDGES",
    "BUFORD",
    "CAREYTOWN",
    "CARMEL",
    "CENTERFIELD",
    "DANVILLE",
    "DODSONVILLE",
    "EAST DANVILLE",
    "EAST MONROE",
    "ELMVILLE",
    "FAIRFAX",
    "FAIRVIEW",
    "FOLSOM",
    "GIST SETTLEMENT",
    "HARIETT",
    "HARWOOD",
    "HOAGLAND",
    "HOLLOWTOWN",
    "MARSHALL",
    "NEW MARKET",
    "NEW PETERSBURG",
    "PRICETOWN",
    "RAINSBORO",
    "RUSSELL",
    "SAMANTHA",
    "SHACKLETON",
    "STRINGTOWN",
    "SUGAR TREE RIDGE",
    "TAYLORSVILLE",
    "WILLETTSVILLE"
  };
}
