package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

public class OHFultonCountyParser extends DispatchEmergitechParser {
  
  public OHFultonCountyParser() {
    super("", 0, CITY_LIST, "FULTON COUNTY", "OH");
  }
 
  private static final String[] CITY_LIST = new String[]{
    //CITY
    "WAUSEON",
    
    //VILLAGES
    "ARCHBOLD",
    "DELTA",
    "FAYETTE",
    "LYONS",
    "METAMORA",
    "SWANTON",

    //TOWNSHIPS
    "AMBOY",
    "CHESTERFIELD",
    "CLINTON",
    "DOVER",
    "FRANKLIN",
    "FULTON",
    "GERMAN",
    "GORHAM",
    "PIKE",
    "ROYALTON",
    "SWAN CREEK",
    "YORK",

   //OTHER
    "PETTISVILLE",
    "TEDROW"
  };
}
