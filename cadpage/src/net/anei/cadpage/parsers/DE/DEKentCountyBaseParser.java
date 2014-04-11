package net.anei.cadpage.parsers.DE;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import net.anei.cadpage.parsers.FieldProgramParser;
import net.anei.cadpage.parsers.MsgInfo.Data;



public class DEKentCountyBaseParser extends FieldProgramParser {
  
  public DEKentCountyBaseParser(String program) {
    super(CITY_LIST, "KENT COUNTY", "DE", program);
    setupMultiWordStreets("SLOW AND EASY", "GUN AND ROD");
    setupProtectedNames("SLOW AND EASY", "GUN AND ROD");
  }
  
  /**
   * Set state field if required
   * @param data parsed data object
   */
  protected void setState(Data data) {
    String state = CITY_STATE_TABLE.getProperty(data.strCity.toUpperCase());
    if (state != null) data.strState = state;
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities
    "DOVER",
    "HARRINGTON",
    "MILFORD",
    
    // Towns
    "BOWERS",
    "CAMDEN",
    "CAMDEN WYOMING",
    "CHESWOLD",
    "CLAYTON",
    "FARMINGTON",
    "FELTON",
    "FREDERICA",
    "HARTLY",
    "HOUSTON",
    "KENTON",
    "LEIPSIC",
    "LITTLE CREEK",
    "MAGNOLIA",
    "SMYRNA",
    "VIOLA",
    "WOODSIDE",
    "WYOMING",
    
    // Census - designated places
    "DOVER AIR FORCE BASE",
    "HIGHLAND ACRES",
    "KENT ACRES",
    "RISING SUN-LEBANON",
    "RIVERVIEW",
    "RODNEY VILLAGE",
    "WOODSIDE EAST",

    // Other localities
    "ANDREWVILLE",
    "BERRYTOWN",
    "LITTLE HEAVEN",
    "MARYDEL",
    
    // Carolin County, MD
    "DENTON",
    "FEDERALSBURG",
    "GREENSBORO",
    "HENDERSON",
    "HILLSBORO",
    "MARYDEL",
    "PRESTON",
    "RIDGELY",
    
    // Kent County, MD
    "BETTERTON",
    "CHESTERTOWN",
    "GALENA",
    "MILLINGTON",
    "ROCK HALL"
  };

  protected static final Set<String> CITY_SET = new HashSet<String>(Arrays.asList(CITY_LIST));
  
  
  // Out of state municipalities
  private static final Properties CITY_STATE_TABLE = buildCodeTable(new String[]{
      
      // Carolin County
      "DENTON",       "MD",
      "FEDERALSBURG", "MD",
      "GREENSBORO",   "MD",
      "HENDERSON",    "MD",
      "HILLSBORO",    "MD",
      "MARYDEL",      "MD",
      "PRESTON",      "MD",
      "RIDGELY",      "MD",
      
      // Kent County
      "BETTERTON",    "MD",
      "CHESTERTOWN",  "MD",
      "GALENA",       "MD",
      "MILLINGTON",   "MD",
      "ROCK HALL",    "MD",

  });

}


