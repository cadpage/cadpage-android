package net.anei.cadpage.parsers.TN;


import net.anei.cadpage.parsers.dispatch.DispatchBParser;


public class TNWilliamsonCountyParser extends DispatchBParser {
  
  public TNWilliamsonCountyParser() {
    super(CITY_LIST, "WILLIAMSON COUNTY", "TN");
  }
  
  @Override
  public String getFilter() {
    return "911-CENTER@williamson-tn.org";
  }
  
  @Override
  protected boolean isPageMsg(String body) {
    return body.startsWith("911-CENTER:");
  }

  private static final String[] CITY_LIST = new String[]{
    
    // Cities & Towns
    "BRENTWOOD",
    "FAIRVIEW",
    "FRANKLIN",
    "NOLENSVILLE",
    "SPRING HILL",
    "THOMPSONS STATION",
    
    // Unincorporated Communities
    "ALLISONA",
    "ARRINGTON",
    "BERRY'S CHAPEL",
    "BETHESDA",
    "BETHLEHEM",
    "BOSTON",
    "BURWOOD",
    "COLLEGE GROVE",
    "CLOVERCROFT",
    "COOL SPRINGS",
    "FERNVALE",
    "GRASSLAND",
    "KIRKLAND",
    "LEIPER'S FORK",
    "LIBERTY HILL",
    "PEYTONSVILLE",
    "PRIMM SPRINGS",
    "RUDDERVILLE",
    "SOUTHALL",
    "TRIUNE",
    
    // Davidson County
    "NASHVILLE"
  };
  
}