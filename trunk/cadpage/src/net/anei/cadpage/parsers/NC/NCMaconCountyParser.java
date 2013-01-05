package net.anei.cadpage.parsers.NC;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;



public class NCMaconCountyParser extends DispatchBParser {
 
  public NCMaconCountyParser() {
    super(CITY_LIST, "MACON COUNTY", "NC");
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911 CENTER:");
  }

  private static final String[] CITY_LIST = new String[]{
    "FRANKLIN", 
    "HIGHLANDS", 
    "OTTO",
    "FRANKLIN TWP", 
    "HIGHLANDS TWP", 
    "SUGARFORK TWP", 
    "BURNINGTOWN TWP",
    "CARTOOGECHAYE TWP", 
    "ELLIJAY TWP", 
    "MILLSHOAL TWP",
    "NANTAHALA TWP", 
    "SMITHBRIDGE TWP",
  };
}
