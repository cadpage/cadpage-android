package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class WVLincolnCountyParser extends DispatchB2Parser {
  
  public WVLincolnCountyParser() {
    super(CITY_LIST, "LINCOLN COUNTY", "WV");
  }
  
  @Override
  public String getFilter() {
    return "LINCOLN911@e911.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Incorporated cities and towns

    "Hamlin",
    "West Hamlin",

    // Unincorporated communities

    "Alkol",
    "Alum Creek",
    "Atenville",
    "Big Ugly",
    "Branchland",
    "Dollie",
    "Eden Park",
    "Ferrellsburg",
    "Fourteen",
    "Fry",
    "Gill",
    "Green Shoal",
    "Griffithsville",
    "Harts",
    "Leet",
    "Midkiff",
    "Pleasant View",
    "Ranger",
    "Rector",
    "Sod",
    "Spurlockville",
    "Sumerco",
    "Sweetland",
    "Warren",
    "Wewanta",
    "Yawkey"
  };
}
