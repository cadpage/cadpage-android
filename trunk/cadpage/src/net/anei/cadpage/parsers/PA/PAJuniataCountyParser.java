package net.anei.cadpage.parsers.PA;


import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class PAJuniataCountyParser extends DispatchBParser {
 
  public PAJuniataCountyParser() {
    super(CITY_LIST, "JUNIATA COUNTY", "PA");
  }
  
  @Override
  public String getFilter() {
    return "UNIATA911@Juniata.PA";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("JUNIATA911:");
  }
  
  public static final String[] CITY_LIST = new String[]{
    // Boroughs
    "MIFFLIN",
    "MIFFLINTOWN",
    "PORT ROYAL",
    "THOMPSONTOWN",
    
    //Townships
    "BEALE",
    "DELAWARE",
    "FAYETTE",
    "FERMANAGH",
    "GREENWOOD",
    "LACK",
    "MILFORD",
    "MONROE",
    "SPRUCE HILL",
    "SUSQUEHANNA",
    "TURBETT",
    "TUSCARORA",
    "WALKER"
  };

}