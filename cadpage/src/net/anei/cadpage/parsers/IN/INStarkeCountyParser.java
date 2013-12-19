package net.anei.cadpage.parsers.IN;


import net.anei.cadpage.parsers.dispatch.DispatchA29Parser;

/**
 * Starke County, IN
 */
public class INStarkeCountyParser extends DispatchA29Parser {
  
  public INStarkeCountyParser() {
    super(CITY_LIST, "STARKE COUNTY", "IN");
  }
  
  @Override
  public String getFilter() {
    return "DISPATCH@co.starke.in.us,messaging@iamresponding.com";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Cities and towns
    "HAMLET",
    "KNOX",
    "NORTH JUDSON",
 
    // Unincorporated towns
    "BASS LAKE",
    "ENGLISH LAKE",
    "GROVERTOWN",
    "KOONTZ LAKE",
    "ORA",
    "SAN PIERRE",
 
    // Townships
    "CALIFORNIA TWP",
    "CENTER TWP",
    "DAVIS TWP",
    "JACKSON TWP",
    "NORTH BEND TWP",
    "OREGON TWP",
    "RAILROAD TWP",
    "WASHINGTON TWP",
    "WAYNE TWP",
    
    // Marshall County
    "CULVER",
    
    // Pulaski County
    "MONTEREY"
      
  };
}
