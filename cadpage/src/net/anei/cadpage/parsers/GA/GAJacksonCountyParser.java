package net.anei.cadpage.parsers.GA;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;


public class GAJacksonCountyParser extends DispatchB2Parser {

  public GAJacksonCountyParser() {
    super("JACKSONE911:||JACKSON CO SO JACKSONE911:", CITY_LIST, "JACKSON COUNTY", "GA");
  }
  
  @Override
  public String getFilter() {
    return "93001,777,14101,JACKSONE911@jacksoncountygov.com";
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
