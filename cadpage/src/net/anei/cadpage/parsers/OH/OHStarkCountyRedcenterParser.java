package net.anei.cadpage.parsers.OH;

import net.anei.cadpage.parsers.dispatch.DispatchEmergitechParser;


public class OHStarkCountyRedcenterParser extends DispatchEmergitechParser {
  
  public OHStarkCountyRedcenterParser() {
    super("RED:", 64, CITY_LIST, "STARK COUNTY", "OH");
  }
  
  @Override
  public int getMapFlags() {
    
    // Suppressing the LA -> LN translation fixes problems when LAWRENCE is split wrong
    return MAP_FLG_SUPPR_LA;
  }

  @Override
  public String getFilter() {
    return "RED@sssnet.com,messaging@iamresponding.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    // Cities
    "ALLIANCE",
    "CANAL FULTON",
    "CANTON",
    "LOUISVILLE",
    "MASSILLON",
    "NORTH CANTON",
    
    // Villages
    "BEACH CITY",
    "BREWSTER",
    "EAST CANTON",
    "EAST SPARTA",
    "HARTVILLE",
    "HILLS AND DALES",
    "LIMAVILLE",
    "MAGNOLIA",
    "MINERVA",
    "MEYERS LAKE",
    "NAVARRE",
    "WAYNESBURG",
    "WILMOT",
    
    // Townships
    "BETHLEHEM TWP",
    "CANTON TWP",
    "JACKSON TWP",
    "LAKE TWP",
    "LAWRENCE TWP",
    "LEXINGTON TWP",
    "MARLBORO TWP",
    "NIMISHILLEN TWP",
    "OSNABURG TWP",
    "PARIS TWP",
    "PERRY TWP",
    "PIKE TWP",
    "PLAIN TWP",
    "SANDY TWP",
    "SUGAR CREEK TWP",
    "TUSCARAWAS TWP",
    "WASHINGTON TWP",
    
    // Census-designated places
    "GREENTOWN",
    "PERRY HEIGHTS",
    "UNIONTOWN",
    
    // Other localities
    "AVONDALE",
    "CAIRO",
    "MARCHAND",
    "MAXIMO",
    "MIDDLEBRANCH",
    "NEW FRANKLIN",
    "NORTH INDUSTRY",
    "NORTH LAWRENCE",
    "PARIS",
    "RICHVILLE",
    "ROBERTSVILLE",
    "WACO"
  };
}
