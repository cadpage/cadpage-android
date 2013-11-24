package net.anei.cadpage.parsers.NY;

import java.util.Properties;
import java.util.regex.Pattern;

import net.anei.cadpage.parsers.dispatch.DispatchA13Parser;


public class NYColumbiaCountyParser extends DispatchA13Parser {
  
  public NYColumbiaCountyParser() {
    super(CITY_CODES, "COLUMBIA COUNTY", "NY");
  }
  
  // Override checkAddress to relax the standards a bit
  @Override
  protected int checkAddress(String address) {
    if (LEAD_NUMBER_PTN.matcher(address).matches()) return 3;
    return super.checkAddress(address, 1);
  }
  private static final Pattern LEAD_NUMBER_PTN = Pattern.compile("\\d+ .*");

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
	