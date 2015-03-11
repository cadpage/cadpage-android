package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;

public class OHPerryCountyParser extends DispatchEmergitechParser {

  public OHPerryCountyParser() {
    super("Perry911:", 0, CITY_LIST, "PERRY COUNTY", "OH");
  }
  
  private static final String[] CITY_LIST = new String[] { 
    
   //villages
    "CORNING",
    "CROOKSVILLE",
    "GLENFORD",
    "HEMLOCK",
    "JUNCTION CITY",
    "NEW LEXINGTON",
    "NEW STRAITSVILLE",
    "RENDVILLE",
    "ROSEVILLE",
    "SHAWNEE",
    "SOMERSET",
    "THORNVILLE",

    //townships
    "BEARFIELD TWP",
    "CLAYTON TWP",
    "COAL TWP",
    "HARRISON TWP",
    "HOPEWELL TWP",
    "JACKSON TWP",
    "MADISON TWP",
    "MONDAY CREEK TWP",
    "MONROE TWP",
    "PIKE TWP",
    "PLEASANT TWP",
    "READING TWP",
    "SALT LICK TWP",
    "THORN TWP",
   
    //other communities
    "BRISTOL",
    "GLASS ROCK",
    "MCLUNEY",
    "MILLIGAN",
    "MOUNT PERRY",
    "MOXAHALA",
    "PORTERSVILLE",
    "REHOBOTH",
    "WHIPSTOWN",
    
    //ghost town
    "SAN TOY"
  };
}