package net.anei.cadpage.parsers.WV;

import net.anei.cadpage.parsers.dispatch.DispatchB2Parser;



public class WVLincolnCountyParser extends DispatchB2Parser {
  
  public WVLincolnCountyParser() {
    super("LINCOLN 911:",CITY_LIST, "LINCOLN COUNTY", "WV");
  }
  
  @Override
  public String getFilter() {
    return "LINCOLN911@e911.org";
  }
  
  private static final String[] CITY_LIST = new String[]{
    
    // Incorporated cities and towns

    "HAMLIN",
    "WEST HAMLIN",

    // Unincorporated communities

    "ALKOL",
    "ALUM CREEK",
    "ATENVILLE",
    "BIG UGLY",
    "BRANCHLAND",
    "DOLLIE",
    "EDEN PARK",
    "FERRELLSBURG",
    "FOURTEEN",
    "FRY",
    "GILL",
    "GREEN SHOAL",
    "GRIFFITHSVILLE",
    "HARTS",
    "LEET",
    "MIDKIFF",
    "PLEASANT VIEW",
    "RANGER",
    "RECTOR",
    "SOD",
    "SPURLOCKVILLE",
    "SUMERCO",
    "SWEETLAND",
    "WARREN",
    "WEWANTA",
    "YAWKEY"
  };
}
