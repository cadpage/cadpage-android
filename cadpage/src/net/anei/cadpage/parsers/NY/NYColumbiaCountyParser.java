package net.anei.cadpage.parsers.NY;

import java.util.Properties;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYColumbiaCountyParser extends DispatchA13Parser {
  
  public NYColumbiaCountyParser() {
    super(CITY_CODES, "COLUMBIA COUNTY", "NY");
  }
  
  private static final Properties CITY_CODES = buildCodeTable(new String[]{
      "CANA", "CANAAN",
      "CLAV", "CLAVERACK",
      "COPA", "COPAKE",
      "GHEN", "GHENT", 
      "GREE", "GREENPORT",
      "HILL", "HILLSDALE",
      "HUDS", "HUDSON",
      "NLEB", "NEW LEBANON",
      "V-PH", "PHILMONT"
  });

    // Unidentified cities
//    "ANCRAM",
//    "AUSTERLITZ",
//    "CHATHAM",
//    "CLAVERACK-RED MILLS",
//    "CLERMONT",
//    "COPAKE",
//    "COPAKE",
//    "GALLATIN",
//    "GERMANTOWN",
//    
//    
//    "KINDERHOOK",
//    "LIVINGSTON",
//    "LORENZ PARK",
//    
//    "NIVERVILLE",
//    "STOCKPORT",
//    "STOTTVILLE",
//    "STUYVESANT",
//    "TAGHKANIC",
//    "VALATIE",
}
	