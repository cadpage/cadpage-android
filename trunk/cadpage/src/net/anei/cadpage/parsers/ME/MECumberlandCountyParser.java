package net.anei.cadpage.parsers.ME;


import net.anei.cadpage.parsers.dispatch.DispatchA16Parser;
/**
 * Cumberland County, ME
 */
public class MECumberlandCountyParser extends DispatchA16Parser {
  
  public MECumberlandCountyParser() {
    super(CITY_LIST, "CUMBERLAND COUNTY", "ME");
  }

  @Override
  public String getFilter() {
    return "autopage-no-reply@ci.scarborough.me.us";
  }
  
  private static final String[] CITY_LIST= new String[]{
    "BALDWIN",
    "BRIDGTON",
    "BRUNSWICK",
    "CAPE ELIZABETH",
    "CASCO",
    "CHEBEAGUE ISLAND",
    "CUMBERLAND",
    "FALMOUTH",
    "FREEPORT",
    "FRYE ISLAND",
    "GORHAM",
    "GRAY",
    "HARPSWELL",
    "HARRISON",
    "LONG ISLAND",
    "NAPLES",
    "NEW GLOUCESTER",
    "NORTH YARMOUTH",
    "PORTLAND",
    "POWNAL",
    "RAYMOND",
    "SCARBOROUGH",
    "SEBAGO",
    "SOUTH PORTLAND",
    "STANDISH",
    "WESTBROOK",
    "WINDHAM",
    "YARMOUTH",
    
    // York County
    "OLD ORCHARD BEACH"
  };
}
