package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class GAJacksonCountyParser extends DispatchBParser {

  public GAJacksonCountyParser() {
    super(CITY_LIST, "JACKSON COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "93001";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("JACKSONE911:");
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // cities and towns
    "ARCADE",
    "BRASELTON",
    "COMMERCE",
    "HOSCHTON",
    "JEFFERSON",
    "MAYSVILLE",
    "NICHOLSON",
    "PENDERGRASS",
    "TALMO",
    
    // unincorporated communities
    "APPLE VALLEY",
    "ATTICA",
    "BROCKTON",
    "CENTER",
    "CLARKSBORO",
    "CONSTANTINE",
    "DRY POND",
    "EDNAVILLE",
    "FAIRVIEW",
    "GROVE LEVEL",
    "HOLDERS",
    "HOLLY SPRINGS",
    "RED STONE",
    "SELLS",
    "STONEHAM",
    "THOMPSONS MILLS",
    "THURMACK",
    "THYATIRA",
    "WILSONS CHURCH"

  };
}
